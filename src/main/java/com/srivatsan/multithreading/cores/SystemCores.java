package com.srivatsan.multithreading.cores;

public class SystemCores {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println(cores);
    }

}
