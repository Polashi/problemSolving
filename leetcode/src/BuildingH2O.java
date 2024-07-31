import java.util.concurrent.Semaphore;

public class BuildingH2O {
    Semaphore h;
    Semaphore o;

    public BuildingH2O(){
        h = new Semaphore(2);
        o = new Semaphore(0);
    }

    public void printH(Runnable runner) throws InterruptedException{
        h.acquire();
        runner.run();
        o.release();
    }

    public void printO(Runnable runner) throws InterruptedException{
        o.acquire(2);
        runner.run();
        h.release(2);

        //
    }
}
