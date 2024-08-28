/*
ToDo (im Test ANF statt HSA)
informationen aus .properties nutzen
URL bauen
URL verarbeiten
 iteration durch ticketnummern. im Test ANF1 bis ANF 3500
.html downloaden. Dateiname: ANF{nr.}.html
informationen aus .properties nutzen
 */


package org.fs.jirabackup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JiraBackupApplication{

    public static void main(String[] args) {
        SpringApplication.run(JiraBackupApplication.class, args);
        //Backing backing = new Backing();
        Download download = new Download();
    }

}
