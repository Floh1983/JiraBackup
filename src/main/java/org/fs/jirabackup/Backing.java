package org.fs.jirabackup;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Backing {
    public static void main(String args[]) throws IOException {
        download("https://jira.comline.de/sr/jira.issueviews:searchrequest-fullcontent/temp/SearchRequest.html?jqlQuery=key+%3D+AEGHAW-2381");
    }
    public static void download(String urlString) throws IOException {
        URL url = new URL(urlString);
        try(
                BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
                BufferedWriter writer = new BufferedWriter(new FileWriter("AEGHAW-2381.html"));
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
            System.out.println("Page downloaded.");
        }
    }
}


//import java.io.IOException;
//import java.io.InputStream;
//import java.net.URL;
//
//
//try (buffered stream?){
//start stream
//wie denn nun?...
//} catch (IOException e){
//
//        }
//InputStream in = new URL(FILE_URL).openStream();
//Files.copy(in, Paths.get(FILE_NAME), StandardCopyOption.REPLACE_EXISTING);


//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//
//@Component
//@Getter
//@Setter
//@AllArgsConstructor
//
//public class Backing {
//    @Value("${properties.url}")
//    public static String url;
//
//    @Value("${properties.ticket}")
//    public static String ticket;
//
//    @Value("${properties.start}")
//    public static int start;
//
//    @Value("${properties.end}")
//    public static int end;
//
//
//    public static void backing(){
//        System.out.println("Hello");
//        System.out.println(url + ticket + start + end);
//
//    }
//
//    public static void main(String[] args) {
//        System.out.println("Hello");
//        System.out.println(url + ticket + start + end);
//        backing();
//    }
//}