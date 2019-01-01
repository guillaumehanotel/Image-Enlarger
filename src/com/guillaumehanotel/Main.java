package com.guillaumehanotel;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {


        String inputFileName = args[0];
        String outputFileName = args[1];
        int multiplier = Integer.parseInt(args[2]);

        ImageEnlarger imageEnlarger = new ImageEnlarger();
        try {
            imageEnlarger.enlargeImage(inputFileName, outputFileName, multiplier);
        } catch (IOException e) {
            e.getMessage();
        }


    }
}
