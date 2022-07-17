package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Date;

public class DataHora {

    public static void main(String[] args) throws ParseException {
//        LocalTime agora = LocalTime.now();
//        String aaa = "01:35:00";
//        System.out.println(mostrar(agora, "02:05:00"));
//        System.out.println(mostrar(agora, "07:30:00"));
//        System.out.println(mostrar(agora, "23:59:00"));
//        System.out.println(mostrar(agora, "00:00:00"));
//
//        System.out.println(faltando(agora, LocalTime.parse("01:35:00", FORMATO_HORAS)));
//        System.out.println(faltando(agora, LocalTime.parse("02:15:00", FORMATO_HORAS)));
    }


    public static String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

        return dtf.format(LocalDateTime.now());
    };

    public static String getDate(String getDateTime) {
        String date = getDateTime.substring(0, 10);
        return date;
    }

    public static String getTime(String getDateTime) {
        String time = getDateTime.substring(11, 19);
        return time;
    };
    public static int dateToSeconds(String tempoPermanecido) {
        LocalTime lt = LocalTime.parse(tempoPermanecido,
                DateTimeFormatter.ofPattern("HH:mm:ss"));
        return lt.toSecondOfDay();
    }


    public static final DateTimeFormatter FORMATO_HORAS = DateTimeFormatter
            .ofPattern("HH:mm:ss")
            .withResolverStyle(ResolverStyle.STRICT);
    public static LocalTime faltando(LocalTime agora, LocalTime desejada) {
        return desejada.minusHours(agora.getHour()).minusMinutes(agora.getMinute()).minusSeconds(agora.getSecond());
    }
    public static String mostrar(LocalTime horario, String objetivo) {
        LocalTime desejada = LocalTime.parse(objetivo, FORMATO_HORAS);
        LocalTime falta = faltando(horario, desejada);

        return falta.format(FORMATO_HORAS);
    }

}


