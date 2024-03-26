package com.prototypage.calendrierduceri.api;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIEDT {
    public static String sendGetEdt(String apiUrl) {
        StringBuilder response = new StringBuilder();

        try {
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response.toString();
    }
    public static void writeToFile(String filePath,String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            writer.write(content);
        }

}
    public static void main(String[] args) throws IOException {
        String apiUrl = "https://edt-api.univ-avignon.fr/api/exportAgenda/tdoption/def50200a1e4a985b3b2d15180505b603aa0763ceea729639237eb96e357086412c05cbea1bfb6df2eb40d356b8c066015fbe9db5aa9c22db178324d750f98ec68bfee9dd60b6f49054c80c8cbd76edab802f6d67e7ca5be";
        String response = sendGetEdt(apiUrl);

        writeToFile("file.ics",response);
        System.out.println("Réponse de l'API :");
        System.out.println(response);
    }
}
