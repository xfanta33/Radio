package fr.xfanta.radio.utils;

import java.io.*;

public class Folder {

    private static String dir;

    public static void SetURL() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            dir = System.getProperty("user.home") + "\\AppData\\Roaming\\.Radio\\";
        } else if (os.contains("mac")) {
            dir = System.getProperty("user.home") + "/Library/Application Support/Radio/";
        } else {
            dir = System.getProperty("user.home") + "/.Radio/";
        }

    }

    public static String getDir() {
        return dir;
    }

    public static void SaveURL(String URL) {
        File dos = new File(getDir());
        if (!dos.exists()) {
            dos.mkdirs();
        }
        File fichierTexte = new File(getDir() + "url.txt");
        try {
            FileWriter ecrireFichier = new FileWriter(fichierTexte);

            if (URL!=null){
                ecrireFichier.write(URL);
            }

            ecrireFichier.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getURL() {
        String url = " ";
        try {
            File f = new File(getDir() + "url.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);


            try {
                String line = br.readLine();

                while (line != null) {
                    url =  line;
                    line = br.readLine();
                }

                br.close();
                fr.close();
            } catch (IOException exception) {

                System.out.println("Erreur lors de la lecture : " + exception.getMessage());
                url =  " ";
            }

        } catch (FileNotFoundException exception) {

            System.out.println("Le fichier n'a pas �t� trouv�");
            url = " ";
        }
        return url;
    }
}
