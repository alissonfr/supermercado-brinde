package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class dataHora {
    public static String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        return dtf.format(LocalDateTime.now());
    };
}