package model;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Controller {

    static String folder = "data";
    static String path = "data/data.txt";
    private static ArrayList<Country> countries;

    public Controller() {
        countries = new ArrayList<>();
    }

    public void save() throws IOException {
        File file = new File(path);
        FileOutputStream fos = new FileOutputStream(file);

        Gson gson = new Gson();
        String data = gson.toJson(countries);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        writer.write(data);
        writer.flush();

        fos.close();
    }

    public void load() throws IOException{
        File file = new File(path);
        if (file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            String content = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }
            Gson gson = new Gson();
            Country[] array = gson.fromJson(content, Country[].class);
            countries.addAll(Arrays.asList(array));
            fis.close();
        } else {
            File f = new File(folder);
            if (!f.exists()) {
                f.mkdirs();
            }
            file.createNewFile();
        }
    }

    public static void addCountry(String name, int g, int s, int b) {
        Country country = search(name);
        if (country == null) {
            country = new Country(name);
            countries.add(country);
        }
        country.setGold(country.getGold() + g);
        country.setSilver(country.getSilver() + s);
        country.setBronze(country.getBronze() + b);
    }

    private static Country search(String name) {
        Country country = null;
        for (Country value : countries) {
            if (value.getName().equals(name)) {
                country = value;
            }
        }
        return country;
    }

    public static String showMedals() {
        String list = "";
        Collections.sort(countries, (a, b) -> {
            return b.getGold()- a.getGold();
        });

        list += "--------------------\n" +
                "Gold Medals" +
                "\n--------------------\n";

        for (int i = 0; i < countries.size(); i++) {
            list += countries.get(i).getName() + "--" + countries.get(i).getGold() + "\n";
        }

        Collections.sort(countries, (a, b) -> {
            return b.getSilver()- a.getSilver();
        });

        list += "--------------------\n" +
                "Silver Medals" +
                "\n--------------------\n";

        for (int i = 0; i < countries.size(); i++) {
            list += countries.get(i).getName() + "--" + countries.get(i).getSilver() + "\n";
        }

        Collections.sort(countries, (a, b) -> {
            return b.getBronze()- a.getBronze();
        });

        list += "--------------------\n" +
                "Bronze Medals" +
                "\n--------------------\n";

        for (int i = 0; i < countries.size(); i++) {
            list += countries.get(i).getName() + "--" + countries.get(i).getBronze() + "\n";
        }

        return list;
    }

    public static String showAllMedals() {
        String list = "";
        Collections.sort(countries, (a, b) -> {
            return b.getTotalMedals()- a.getTotalMedals();
        });

        list += "--------------------\n" +
                "Total Medals" +
                "\n--------------------\n";

        for (int i = 0; i < countries.size(); i++) {
            list += countries.get(i).getName() + "--" + countries.get(i).getTotalMedals() + "\n";
        }

        return list;
    }

    public static String sort() {
        String list = "";
        for (int i = 0; i < countries.size(); i++) {
            for (int j = 0; j < countries.size()-1; j++) {
                if (countries.get(j).getName().compareTo(countries.get(j + 1).getName()) > 0) {
                    Country temp = countries.get(j);
                    countries.set(j, countries.get(j + 1));
                    countries.set(j + 1,temp);
                }
            }
        }

        list += "--------------------\n" +
                "Countries" +
                "\n--------------------\n";

        for (int i = 0; i < countries.size(); i++) {
            list += countries.get(i).getName() + "\n";
        }

        return list;
    }
}