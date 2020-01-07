package ar.com.ada.maven.Utils;

import java.util.Scanner;

public class ScannerSingleton {

    private static Scanner scannerSingleton;

    private ScannerSingleton() {
    }

    public static Scanner getInstance() {
        if (scannerSingleton == null)
            scannerSingleton = new Scanner(System.in);

        return scannerSingleton;
    }
}
