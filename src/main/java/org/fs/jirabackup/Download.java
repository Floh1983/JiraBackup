package org.fs.jirabackup;

import java.io.*;
import java.net.URL;

public class Download {
    public static void download(String urlString) throws IOException {
        URL url = new URL(urlString);
        try (
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
