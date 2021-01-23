package infrastructure.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestLogger {
    private int step = 0;

    public void log(String msg){

        increaseStep();

        System.out.println(step + ") " + getCurrentTime() + " [" + getThreadName() + "]: " + msg);
    }

    protected String getThreadName(){
        return Thread.currentThread().getName();
    }

    protected String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        return sdf.format(new Date());
    }

    private void increaseStep(){
        step++;
    }

}
