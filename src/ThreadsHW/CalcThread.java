package ThreadsHW;

public class CalcThread extends Thread{
    private int offset = 0;
    private final float[] arr;

    CalcThread(float[] arr, int offset){
        this.arr = arr;
        this.offset = offset;
        start();
    }

    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] *
                    Math.sin(0.2f + (i + offset) / 5) *
                    Math.cos(0.2f + (i + offset) / 5) *
                    Math.cos(0.4f + (i + offset) / 2));
        }
    }
}
