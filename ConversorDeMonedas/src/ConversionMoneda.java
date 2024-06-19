import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConversionMoneda {
    public static void cambio(String baseMoneda, String cambioMoneda, ConsultaMoneda consulta, Scanner lectura){
        double monto;
        double montoHaConvertir;
        Date fechaActual = new Date();
        SimpleDateFormat formato = new SimpleDateFormat();
        Conversion conversion = consulta.buscaConversion(baseMoneda, cambioMoneda);

        if (conversion != null){
            try{
                System.out.println("La tasa de cambio para el dia "+formato.format(fechaActual));
                System.out.println("La tasa de cambio de la moneda" + baseMoneda + "=" + conversion.conversion_rate() + " " + cambioMoneda);
                System.out.println("Ingrese la cantidad de " + baseMoneda);
                monto = Double.parseDouble(lectura.nextLine());
                montoHaConvertir = monto * conversion.conversion_rate();
                System.out.println(monto+" "+baseMoneda+"="+montoHaConvertir+" "+conversion.target_code());
            }catch (NumberFormatException e){
                System.out.println("Ingrese un numero valido");
            }
        }else {
            System.out.println("No se pudo obtener la tasa de cambio para "+baseMoneda +"a "+cambioMoneda);
        }


    }
    public static void cambioMonedaDiferente(ConsultaMoneda consulta,Scanner lectura){
        System.out.println("Ingrese el codigo de la moneda a convertir");
        String baseMoneda = lectura.nextLine().toUpperCase();
        System.out.println("Ingrese el codigo de la moneda a deseada");
        String cambioMoneda = lectura.nextLine().toUpperCase();
        cambio(baseMoneda, cambioMoneda, consulta, lectura);
    }
}
