package com.example.tp;

import java.io.PrintWriter;
import java.io.IOException;

public class HtmlGenerator {

    public static void writeHtml(String path,
                                 String pageTitle,
                                 String bodyText) {

        try (PrintWriter pw = new PrintWriter(path, "UTF-8")) {

            pw.println("<!DOCTYPE html>");
            pw.println("<html lang=\"fr\">");
            pw.println("<head>");
            pw.println("  <meta charset=\"UTF-8\">");
            pw.printf("  <title>%s</title>%n", pageTitle);
            pw.println("</head>");
            pw.println("<body>");
            pw.printf("  <h1>%s</h1>%n", pageTitle);
            pw.printf("  <p>%s</p>%n", bodyText);
            pw.println("</body>");
            pw.println("</html>");

        } catch (IOException e) {
            System.err.println("Erreur HTML : " + e.getMessage());
        }
    }
}
