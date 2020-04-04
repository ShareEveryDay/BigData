package cn.tedu.flume;

import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.EventDrivenSource;
import org.apache.flume.channel.ChannelProcessor;
import org.apache.flume.event.EventBuilder;
import org.apache.flume.source.AbstractSource;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AutoSources extends AbstractSource implements EventDrivenSource {
    private  int step=1;

    private ExecutorService es= Executors.newFixedThreadPool(5);
    public void configThreadPool(Context context){
        String step =context.getString("stop");
        if (step==null){
            this.step=Integer.parseInt(step);
        }
    }
    @Override
    public synchronized void start() {
        ChannelProcessor cp=this.getChannelProcessor();
        es.submit(new Add(step,cp));

    }

    @Override
    public synchronized void stop() {
        es.shutdownNow();
    }
}
class Add implements Runnable{
    private int step;
    private ChannelProcessor cp;
    public Add(int step,ChannelProcessor cp){
        this.step=step;
        this.cp=cp;
    }
    @Override
    public void run() {
        int i=0;
        while(true){
            Map<String,String> headers=new HashMap<>();
            headers.put("puttime",System.currentTimeMillis()+"");
            byte[] body = (i + "").getBytes();
            Event e = EventBuilder.withBody(body,headers);
            cp.processEvent(e);
            i+=step;
        }
    }
}