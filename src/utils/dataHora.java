package utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class dataHora {

    public static String getDateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        return dtf.format(LocalDateTime.now());
    };

    public static String getTime(String getDateTime) {
        String time = getDateTime.substring(11, 19);
        return time;
    };



    public static final DateTimeFormatter FORMATO_HORAS = DateTimeFormatter
            .ofPattern("HH:mm:ss")
            .withResolverStyle(ResolverStyle.STRICT);

    public static LocalTime faltando(LocalTime agora, LocalTime desejada) {
        return desejada.minusHours(agora.getHour()).minusMinutes(agora.getMinute());
    }

    public static String mostrar(LocalTime horario, String objetivo) {
        LocalTime desejada = LocalTime.parse(objetivo, FORMATO_HORAS);
        LocalTime falta = faltando(horario, desejada);

        return falta.format(FORMATO_HORAS);
    }

    public static void main(String[] args) {

    };

}


