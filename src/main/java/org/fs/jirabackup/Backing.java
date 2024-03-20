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

OkHttpClient client = new OkHttpClient();

Request request = new Request.Builder()
        .url("https://jira.comline.de/sr/jira.issueviews:searchrequest-fullcontent/temp/SearchRequest.html?jqlQuery=key+%3D+AEGHAW-2381")
        .get()
        .addHeader("Authorization", "Basic c2NobG9zc2VyOk1lcGhpc3RvMX5qYW4=")
        .addHeader("User-Agent", "PostmanRuntime/7.13.0")
        .addHeader("Accept", "*/*")
        .addHeader("Cache-Control", "no-cache")
        .addHeader("Postman-Token", "12ea7ce3-0c65-4de0-b3fa-15117a9ed3d2,32c799e6-68a5-4171-a644-ff65e5d71bc7")
        .addHeader("Host", "jira.comline.de")
        .addHeader("cookie", "JSESSIONID=11C45299F2967C3BDF1460C75DCD9147; atlassian.xsrf.token=B2LQ-2W30-5PCA-3L89|d890cd29de469b59491c199ec759157f37e6aa2c|lin")
        .addHeader("accept-encoding", "gzip, deflate")
        .addHeader("Connection", "keep-alive")
        .addHeader("cache-control", "no-cache")
        .build();

Response response = client.newCall(request).execute();