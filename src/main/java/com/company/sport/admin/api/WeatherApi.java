package com.company.sport.admin.api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;

@Service
public class WeatherApi {
    public String key = "3RvIWoLb3UdEX8U0A6hqoEX9AR3NeFaPCOLY%2F2aJNNB8xrqkeOXagpSBQU2ucTFBvYDroWryc2OUhUoQ4ppr7A%3D%3D";
    public String link ="http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst";
    LocalDate currentDate = LocalDate.now();
    LocalTime currentTime = LocalTime.now();
    LocalTime roundedTime = LocalTime.of(currentTime.getHour(), 0);
    LocalTime rounded1hTime= roundedTime.minusHours(1);
    String baseDate = currentDate.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    String baseTime = rounded1hTime.format(DateTimeFormatter.ofPattern("HHmm"));
    public String getWeather(int nx, int ny) throws IOException {
        StringBuilder urlBuilder = new StringBuilder(link);
        
        
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "="+key);
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1","UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1000","UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("dataType","UTF-8") + "=" + URLEncoder.encode("XML","UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("base_date","UTF-8") + "=" + URLEncoder.encode(baseDate,"UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("base_time","UTF-8") + "=" + URLEncoder.encode(baseTime,"UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("nx","UTF-8") + "=" + URLEncoder.encode(String.valueOf(nx),"UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("ny","UTF-8") + "=" + URLEncoder.encode(String.valueOf(ny),"UTF-8"));
        
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");

        try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } finally {
            conn.disconnect();
        }
    }
    public String toString() {
    	String result = baseDate+" / " + baseTime+"기준";
    	return result;
    }

}
