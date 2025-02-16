package ThreadsHW;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    static final int size = 10;
    static final int h = size / 2;
    private static final float[] arr1 = new float[size];
    private static final float[] arr2 = new float[size];

    private static float[] fillArray(float[] arr){
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        return arr;
    }

    private static void oneThreadCalc(float[] arr){
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    private static void multiThreadCalc(float[] arr){

        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        CalcThread t1 = new CalcThread(a1, 0);
        CalcThread t2 = new CalcThread(a2, h);
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.currentTimeMillis() - a);
    }

    public static void main(String[] args) {

        fillArray(arr1);
        fillArray(arr2);
        oneThreadCalc(arr1);
        multiThreadCalc(arr2);
        if (Arrays.equals(arr1, arr2)){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }
    }
}
