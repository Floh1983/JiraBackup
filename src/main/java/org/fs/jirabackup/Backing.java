package org.fs.jirabackup;

import javax.net.ssl.*;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import static org.fs.jirabackup.Download.download;

public class Backing {

        public static void main (String args[]) throws IOException {
        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    @Override
                    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    }
                }
        };

        SSLContext sc = null;

        {
            try {
                sc = SSLContext.getInstance("SSL");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            try {
                sc.init(null, trustAllCerts, new java.security.SecureRandom());
            } catch (KeyManagementException e) {
                e.printStackTrace();
            }
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            // Create all-trusting host name verifier
            HostnameVerifier validHosts = new HostnameVerifier() {
                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(validHosts);

        download("https://jira.comline.de/sr/jira.issueviews:searchrequest-fullcontent/temp/SearchRequest.html?jqlQuery=key+%3D+AEGHAW-2381");
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