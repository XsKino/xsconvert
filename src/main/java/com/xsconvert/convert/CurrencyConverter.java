package com.xsconvert.convert;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyConverter {

    public static void convert(Currency curr1, Currency curr2) {
        String url = "https://currency-converter5.p.rapidapi.com/currency/convert?format=xml&from="+ curr1.getCode() +"&to="+ curr2.getCode() +"&amount="+ curr2.getAmount() +"&language=es";
        String apiKey = "4756562718msh50ebc8e0aae730ap1e5502jsna59f285ac952";
        String apiHost = "currency-converter5.p.rapidapi.com";

        try {
            // Crear la conexión
            URL apiUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("X-RapidAPI-Key", apiKey);
            connection.setRequestProperty("X-RapidAPI-Host", apiHost);

            // Obtener el InputStream del XML de respuesta
            InputStream inputStream = connection.getInputStream();

            // Crear el DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el XML a un objeto Document
            Document document = builder.parse(inputStream);

            // Obtener los elementos del XML
            Element rootElement = document.getDocumentElement();
            String baseCurrencyCode = rootElement.getAttribute("base_currency_code");
            String baseCurrencyName = rootElement.getAttribute("base_currency_name");
            String amount = rootElement.getAttribute("amount");
            String updatedDate = rootElement.getAttribute("updated_date");
            NodeList rateNodeList = rootElement.getElementsByTagName("rate");
            Element mxnRateElement = (Element) rateNodeList.item(0);
            String currencyName = mxnRateElement.getAttribute("currency_name");
            String rate = mxnRateElement.getAttribute("rate");
            String rateForAmount = mxnRateElement.getAttribute("rate_for_amount");
            String status = rootElement.getAttribute("status");

            // Imprimir los datos procesados
            System.out.println("Base Currency Code: " + baseCurrencyCode);
            System.out.println("Base Currency Name: " + baseCurrencyName);
            System.out.println("Amount: " + amount);
            System.out.println("Updated Date: " + updatedDate);
            System.out.println("Currency Name: " + currencyName);
            System.out.println("Rate: " + rate);
            System.out.println("Rate for Amount: " + rateForAmount);
            System.out.println("Status: " + status);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
