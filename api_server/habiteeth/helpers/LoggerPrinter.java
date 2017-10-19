package habiteeth.helpers;

import java.util.*;
import java.io.*;
import habiteeth.helpers.LoggerType;

public class LoggerPrinter {

    public static void print(String text, LoggerType type) {
        switch (type) {
            case SUCCESS:
                System.out.println("\033[96m" + text + "\033[0m");
                break;
            case ERROR:
                System.out.println("\033[101m" + text + "\033[0m");
                break;
            default:
                System.out.println(text);
                break;
        }
    }
}