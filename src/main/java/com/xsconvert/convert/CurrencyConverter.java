package com.xsconvert.convert;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

public class CurrencyConverter {

    public static void convert(Currency curr1, Currency curr2) {
        String url = "https://currency-converter5.p.rapidapi.com/currency/convert?format=xml&from="+ curr1.getCode() +"&to="+ curr2.getCode() +"&amount="+ curr1.getAmount() +"&language=es";
        String apiHost = "currency-converter5.p.rapidapi.com";

        Properties properties = new Properties();

        try (InputStream input = new FileInputStream(".idea/libraries/config.properties")){

            properties.load(input);
            String apiKey = properties.getProperty("api.key");

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
            Element root = document.getDocumentElement();
            String baseCurrencyCode = getTextContent(root, "base_currency_code");
            String baseCurrencyName = getTextContent(root, "base_currency_name");
            String amount = getTextContent(root, "amount");
            String updatedDate = getTextContent(root, "updated_date");
            String currencyName = getTextContent(root, "currency_name");
            String rate = getTextContent(root, "rate");
            String rateForAmount = getTextContent(root, "rate_for_amount");
            String status = getTextContent(root, "status");

            curr2.setAmount(Double.parseDouble(!rateForAmount.equals("") ? rateForAmount : "0"));
            curr2.setRate(Double.parseDouble(!rate.equals("") ? rate : "0"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getTextContent(Element element, String tagName) {
        NodeList nodeList = element.getElementsByTagName(tagName);
        if (nodeList != null && nodeList.getLength() > 0) {
            return nodeList.item(0).getTextContent();
        } else {
            return "";
        }
    }
}
