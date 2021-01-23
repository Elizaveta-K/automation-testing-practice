package infrastructure.logger;

public class StdTestLogger extends TestLogger{
    public void log(String msg){

        System.out.println(getCurrentTime() + " [" + getThreadName() + "]: " + msg);
    }
}
