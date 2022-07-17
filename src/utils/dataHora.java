package utils;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class dataHora {

    public static void main(String[] args) {
        Calendar hoje1 = Calendar.getInstance();
        GregorianCalendar hoje = new GregorianCalendar();

        imprimirData(hoje);
    };

    private static void imprimirData(Calendar hoje) {

        int ano = hoje.get(Calendar. YEAR);
        int mes = hoje.get(Calendar.MONTH);
        int dia = hoje.get(Calendar. DAY_OF_MONTH);
        int hora = hoje.get(Calendar. HOUR_OF_DAY);
        int minutos = hoje.get(Calendar.MINUTE);
        int segundos = hoje.get(Calendar. SECOND);
        System.out.printf("Hoje é : %02d/%02d/%d %02d:%02d: %02d",
                dia, (mes+1), ano, hora, minutos, segundos);
    }

    public static String getDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        return dtf.format(LocalDateTime.now());
    }


//    private static final DateTimeFormatter FORMATO_HORAS = DateTimeFormatter
//            .ofPattern("HH:mm")
//            .withResolverStyle(ResolverStyle.STRICT);
//
//    private static LocalTime faltando(LocalTime agora, LocalTime desejada) {
//        return desejada.minusHours(agora.getHour()).minusMinutes(agora.getMinute());
//    }
//
//    private static void mostrar(LocalTime horario, String objetivo) {
//        LocalTime desejada = LocalTime.parse(objetivo, FORMATO_HORAS);
//        LocalTime falta = faltando(horario, desejada);
//        System.out.println(
//                "Entre " + horario.format(FORMATO_HORAS)
//                        + " e " + desejada.format(FORMATO_HORAS)
//                        + ", a diferença é de " + falta.format(FORMATO_HORAS)
//                        + ".");
//    }
//
//    public static void main(String[] args) {
//        LocalTime agora = LocalTime.now();
//        mostrar(agora, "07:30");
//        mostrar(agora, "23:59");
//        mostrar(agora, "00:00");
//    };

}


