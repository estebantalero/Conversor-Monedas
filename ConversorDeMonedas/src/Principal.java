import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        ConsultaMoneda consultaMoneda = new ConsultaMoneda();

        int seleccion = 0;
        while (seleccion != 8) {
            System.out.println("-------------------------------------\n" +
                    "Bienvenido Conversor Moneda\n" +
                    "Seleccione la conversion que desea realizar\n" +
                    "1.Peso Colombiano a Euro\n" +
                    "2.Euro a Peso Colombiano\n" +
                    "3.Dollar a Peso Colombiano\n" +
                    "4.Peso Colombiano a Dollar\n" +
                    "5.Peso Argentino a Peso Colombiano\n" +
                    "6.Peso Colombiano a Peso Argentino\n" +
                    "7.Conversion Moneda Diferente\n" +
                    "8.Salir\n" +
                    "-----------------------------------------------\n" +
                    "Seleccióne una opcion entre 1-8");

            try {
                seleccion = lector.nextInt();
                lector.nextLine();

                switch (seleccion) {
                    case 1:
                        ConversionMoneda.cambio("COP", "EUR", consultaMoneda, lector);
                        break;
                    case 2:
                        ConversionMoneda.cambio("EUR", "COP", consultaMoneda, lector);
                        break;
                    case 3:
                        ConversionMoneda.cambio("USD", "COP", consultaMoneda, lector);
                        break;
                    case 4:
                        ConversionMoneda.cambio("COP", "USD", consultaMoneda, lector);
                        break;
                    case 5:
                        ConversionMoneda.cambio("ARS", "COP", consultaMoneda, lector);
                        break;
                    case 6:
                        ConversionMoneda.cambio("COP", "ARS", consultaMoneda, lector);
                        break;
                    case 7:
                        ConversionMoneda.cambioMonedaDiferente(consultaMoneda, lector);
                        break;
                    case 8:
                        System.out.println("Saliendo un gusto atenderlo");
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero.");
                lector.next();

            }

        }
    }
}
