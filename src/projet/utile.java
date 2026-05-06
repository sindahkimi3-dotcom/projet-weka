package projet;
import java.io.*;

public class utile {

    /**
     * Crée chiffres.txt avec les n premiers "trois" et n premiers "cinq"
     * depuis les fichiers binaires MNIST
     */
    public static void createTextFile(int n) throws IOException {
        // Chemins vers les fichiers MNIST
        String imagesPath = "data/train-images.idx3-ubyte";
        String labelsPath = "data/train-labels.idx1-ubyte";

        DataInputStream imgStream = new DataInputStream(
            new BufferedInputStream(new FileInputStream(imagesPath)));
        DataInputStream lblStream = new DataInputStream(
            new BufferedInputStream(new FileInputStream(labelsPath)));

        // Lire les headers MNIST (magic numbers)
        imgStream.readInt(); // magic number
        int totalImages = imgStream.readInt();
        imgStream.readInt(); // rows = 28
        imgStream.readInt(); // cols = 28

        lblStream.readInt(); // magic number
        lblStream.readInt(); // total labels

        PrintWriter writer = new PrintWriter(new FileWriter("data/chiffres.txt"));

        int countTrois = 0, countCinq = 0;

        for (int i = 0; i < totalImages; i++) {
            // Lire 784 pixels
            byte[] pixels = new byte[784];
            imgStream.readFully(pixels);
            int label = lblStream.readByte() & 0xFF;

            if ((label == 3 && countTrois < n) || (label == 5 && countCinq < n)) {
                StringBuilder sb = new StringBuilder();
                for (byte pixel : pixels) {
                    sb.append(pixel & 0xFF).append(",");
                }
                // Ajouter le label texte
                String labelStr = (label == 3) ? "trois" : "cinq";
                sb.append(labelStr);
                writer.println(sb.toString());

                if (label == 3) countTrois++;
                else countCinq++;
            }

            if (countTrois >= n && countCinq >= n) break;
        }

        writer.close();
        imgStream.close();
        lblStream.close();
        System.out.println("✅ chiffres.txt créé avec " + (2*n) + " lignes.");
    }
    
    
    /**
     * Lit une image PNG 28x28 et écrit les intensités dans un fichier texte
     */
    public static void imageToFile(String nomImage) throws IOException {
        // Charger l'image PNG
        java.awt.image.BufferedImage img = javax.imageio.ImageIO.read(
            new File(nomImage));

        // Nom du fichier texte = même nom que l'image
        String nomFichier = nomImage.replace(".png", ".txt");
        PrintWriter writer = new PrintWriter(new FileWriter(nomFichier));

        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < 28; y++) {
            for (int x = 0; x < 28; x++) {
                int rgb = img.getRGB(x, y);
                // Extraire le niveau de gris
                int gray = rgb & 0xFF;
                sb.append(gray);
                if (!(y == 27 && x == 27)) sb.append(",");
            }
        }
        writer.println(sb.toString());
        writer.close();
        System.out.println("✅ Image convertie en texte : " + nomFichier);
    }
    
    
    
    /**
     * Lit un fichier texte d'intensités et crée une image PNG
     */
    public static void fileToImage(String nomFichier) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(nomFichier));
        String line = reader.readLine();
        reader.close();

        String[] values = line.split(",");
        java.awt.image.BufferedImage img = new java.awt.image.BufferedImage(
            28, 28, java.awt.image.BufferedImage.TYPE_BYTE_GRAY);

        for (int i = 0; i < 784; i++) {
            int gray = Integer.parseInt(values[i].trim());
            int rgb = (gray << 16) | (gray << 8) | gray;
            img.setRGB(i % 28, i / 28, rgb);
        }

        String nomImage = nomFichier.replace(".txt", ".png");
        javax.imageio.ImageIO.write(img, "PNG", new File(nomImage));
        System.out.println("✅ Fichier texte converti en image : " + nomImage);
    }
    
    
    /**
     * Convertit chiffres.txt en fichier Excel (.xlsx)
     * Colonnes : pixel_1, pixel_2, ..., pixel_784, label
     */
    public static void createExcelFile(String nomFichier) throws IOException {
        org.apache.poi.xssf.usermodel.XSSFWorkbook workbook =
            new org.apache.poi.xssf.usermodel.XSSFWorkbook();
        org.apache.poi.ss.usermodel.Sheet sheet =
            workbook.createSheet("Chiffres");

        // En-tête
        org.apache.poi.ss.usermodel.Row header = sheet.createRow(0);
        for (int i = 0; i < 784; i++) {
            header.createCell(i).setCellValue("pixel_" + (i + 1));
        }
        header.createCell(784).setCellValue("label");

        // Données
        BufferedReader reader = new BufferedReader(
            new FileReader("data/chiffres.txt"));
        String line;
        int rowNum = 1;

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            org.apache.poi.ss.usermodel.Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < 784; i++) {
                row.createCell(i).setCellValue(
                    Double.parseDouble(parts[i].trim()));
            }
            row.createCell(784).setCellValue(parts[784].trim()); // label
        }

        reader.close();
        FileOutputStream fos = new FileOutputStream(nomFichier);
        workbook.write(fos);
        fos.close();
        workbook.close();
        System.out.println("✅ Excel créé : " + nomFichier);
    }
    
    
    
    
    /**
     * Convertit chiffres.txt en fichier ARFF pour Weka
     */
    public static void createArffFile(String inputTxt, String outputArff,
                                       boolean isTraining) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(outputArff));

        // En-tête ARFF
        writer.println("@RELATION chiffres");
        writer.println();
        for (int i = 1; i <= 784; i++) {
            writer.println("@ATTRIBUTE pixel_" + i + " NUMERIC");
        }
        writer.println("@ATTRIBUTE classe {trois,cinq}");
        writer.println();
        writer.println("@DATA");

        // Données
        BufferedReader reader = new BufferedReader(new FileReader(inputTxt));
        String line;
        while ((line = reader.readLine()) != null) {
            writer.println(line);
        }
        reader.close();
        writer.close();
        System.out.println("✅ ARFF créé : " + outputArff);
    }
    
    
    
   
    
    
    public static void createTestArffFile(String inputTxt, 
            String outputArff) 
            throws Exception {BufferedReader reader = new BufferedReader(
            		 new FileReader(inputTxt));
            java.util.List<String> lines = new java.util.ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
            lines.add(line);
            }
            reader.close();

            PrintWriter writer = new PrintWriter(new FileWriter(outputArff));

            // En-tête ARFF
            writer.println("@RELATION test_chiffres");
            writer.println();
            for (int i = 1; i <= 784; i++) {
            writer.println("@ATTRIBUTE pixel_" + i + " NUMERIC");
            }
            writer.println("@ATTRIBUTE classe {trois,cinq}");
            writer.println();
            writer.println("@DATA");

            // Prendre les 50 dernières lignes
            int total = lines.size();
            for (int i = total - 50; i < total; i++) {
            writer.println(lines.get(i));
            }

            writer.close();
            System.out.println("✅ test-data.arff créé !");
            }
                
                


    	


    
    
    
    
}
