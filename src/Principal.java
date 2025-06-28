import com.google.gson.JsonSyntaxException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        int opcionElegida = 0;

        // Se utilizará esta instancia para obtener tasas de cambio al realizar conversiones de divisas.
        ConsultaConversion consulta = new ConsultaConversion();
       /* Se pasa una instancia de 'ConsultaConversion' al constructor de 'Calculos' porque esta clase debe acceder a ella
          para realizar las conversiones de moneda. */

        Calculos calculos = new Calculos(consulta);
        GeneradorDeArchivos generador = new GeneradorDeArchivos();

        List<String> respuestas = new ArrayList<>();

        String menu = """
                \n***************************************************
                *** Bienvenido al Conversor de Monedas ***
                
                Ingresa una opción
                
                1) Peso colombiano      -->> Dólar estadounidense
                2) Peso colombiano      -->> Euro
                3) Peso colombiano      -->> Libra esterlina
                4) Dólar estadounidense -->> Peso colombiano
                5) Euro                 -->> Peso colombiano
                6) Libra esterlina      -->> Peso colombiano
                
                7) Más opciones de conversión
                
                8) Salir
                ***************************************************
                """;

        while (opcionElegida != 8) {
            try {
                System.out.println(menu);
                opcionElegida = Integer.parseInt(lectura.nextLine());

                // Recupera la marca de tiempo actual del sistema
                LocalDateTime myDateObj = LocalDateTime.now();
                DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formattedDate = myDateObj.format(myFormatObj);

                switch (opcionElegida) {
                    case 1:
                        calculos.almacenarValores("COP", "USD");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 2:
                        calculos.almacenarValores("COP", "EUR");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 3:
                        calculos.almacenarValores("COP", "GBP");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 4:
                        calculos.almacenarValores("USD", "COP");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 5:
                        calculos.almacenarValores("EUR", "COP");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 6:
                        calculos.almacenarValores("GBP", "COP");
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 7:
                        calculos.almacenarValoresPersonalizados();
                        respuestas.add(formattedDate + " - " + calculos.obtenerMensajeRespuesta());
                        break;
                    case 8:
                        break;
                    default:
                        System.out.println(" Por favor ingrese una opción válida");
                }
            } catch (JsonSyntaxException | NullPointerException e) {
                System.out.println("Error. Ingrese códigos de moneda válidos.");
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Error. Ingrese un valor numérico válido.");
            }
        }
        generador.guardarJson(respuestas);

        System.out.println("Finalizando sesión");
    }
}