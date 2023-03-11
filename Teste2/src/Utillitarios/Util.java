package Utillitarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class Util {

    public static LocalDate getData(String data, String formatoInformado){
        String formato = isStringNullOrEmpty(formatoInformado) ? "dd/MM/yyyy" : formatoInformado;
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern(formato);
        return LocalDate.parse(data,dataFormatter);
    }

    public static boolean isStringNullOrEmpty(String texto){
        return texto == null || texto.isEmpty();
    }

    public static LocalDate getUltimaDataMes(int mes){
        return LocalDate.now().withMonth(mes).with(TemporalAdjusters.lastDayOfMonth());
    }

    public static LocalDate getUltimaDataMes(int mes, String data){
        return getData(data, "").withMonth(mes).with(TemporalAdjusters.lastDayOfMonth());
    }
}
