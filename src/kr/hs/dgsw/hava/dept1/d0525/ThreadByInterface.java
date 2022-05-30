package kr.hs.dgsw.hava.dept1.d0525;

public class ThreadByInterface implements Runnable {

    private final String name;

    public ThreadByInterface(String name){
        this.name = name;
    }

    @Override
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(this.name+" : "+i);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e) {}
        }
    }

    public static void main(String[] args) {
        ThreadByInterface thread = new ThreadByInterface("1번");
        Thread thread1 = new Thread(thread);
        thread1.start();
    }

}
