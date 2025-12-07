package com.example.tp;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {

    public static List<Record> readCsv(String path) throws IOException {
        List<Record> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {

                if (line.trim().isEmpty()) continue; // ignore lignes vides

                String[] parts = line.split("[,\t]"); // virgule ou TAB

                int id = Integer.parseInt(parts[0].replace("\"", "").trim());
                String name = parts[1].replace("\"", "").trim();
                double score = Double.parseDouble(parts[2].replace("\"", "").trim());

                records.add(new Record(id, name, score));
            }
        }
        return records;
    }

    public static void writeCsv(List<Record> records, String path) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Record r : records) {
                bw.write(r.getId() + "," + r.getName() + "," + r.getScore());
                bw.newLine();
            }
        }
    }
}
