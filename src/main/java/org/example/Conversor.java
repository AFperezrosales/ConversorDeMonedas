package org.example;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Conversor {

    Scanner leer = new Scanner(System.in);
    boolean salir = true;
    int op = 0;
    public void menuConversor() throws IOException, InterruptedException {
        while (true) {

            if (op == 7) {
                System.out.println("Saliendo de el conversor...");
                return;
            }

            System.out.println("""
                    *******************************************
                    sea bienvenido/a al conversor de moneda =]
                    
                    1) Dólar =>> Peso Argentino
                    2) Peso Argentino =>> Dólar 
                    3) Dólar =>> Real Brasileño
                    4) Real Brasileño =>> Dólar 
                    5) Dólar =>> Peso Colombiano
                    6) Peso Colombiano =>> Dólar
                    7) Salir
                    Elija una opción valida:
                    *******************************************
                    """);
             op = leer.nextInt();

            BigDecimal valor = BigDecimal.valueOf(0);
            switch (op) {
                case 1:
                    System.out.println("Ingrese el valor que desea convertir");
                    valor = leer.nextBigDecimal();
                    convertirMoneda("USD", "ARS", valor);
                    break;
                case 2:
                    System.out.println("Ingrese el valor que desea convertir");
                    valor = leer.nextBigDecimal();
                    convertirMoneda("ARS", "USD",valor);
                    break;
                case 3:
                    System.out.println("Ingrese el valor que desea convertir");
                    valor = leer.nextBigDecimal();
                    convertirMoneda("USD", "BRL",valor);
                    break;
                case 4:
                    System.out.println("Ingrese el valor que desea convertir");
                    valor = leer.nextBigDecimal();
                    convertirMoneda("BRL", "USD",valor);
                    break;
                case 5:
                    System.out.println("Ingrese el valor que desea convertir");
                    valor = leer.nextBigDecimal();
                    convertirMoneda("USD", "COP",valor);
                    break;
                case 6:
                    System.out.println("Ingrese el valor que desea convertir");
                    valor = leer.nextBigDecimal();
                    convertirMoneda("COP", "USD",valor);
                    break;
                case 7:
                    break;

            }


        }
    }

    public void convertirMoneda(String moneda1, String moneda2, BigDecimal valor) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/a00a36683f5add62b3bd0591/pair/"+moneda1+"/"+moneda2 +"/"+valor))
                .build();

        HttpResponse<String> response = client
                .send(request,HttpResponse.BodyHandlers.ofString());

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

      MonedaRecord monedaRecord1 =  gson.fromJson(response.body(), MonedaRecord.class);

      Moneda moneda = new Moneda(monedaRecord1);
        System.out.println("Resultado de la conversión de "+ moneda1 + " a " + moneda2);
        System.out.println(moneda);
    }

}
