package ua.edu.ucu.tempseries;

/**
 * Created by cs.ucu.edu.ua on 10/11/2016.
 */
public class Main {
    public static void main(String[] args) {
        double[] list = new double[10];
        for (int i = 1; i <= list.length; i++) {
           list[list.length-i] = i; ;
        }
        for (Double d : list) {
            System.out.println(d);
        }


    }
}
