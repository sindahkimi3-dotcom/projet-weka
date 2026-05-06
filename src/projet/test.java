package projet;

import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.Evaluation;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class test {

    public static void main(String[] args) throws Exception {

        // ==== ÉTAPE 1 : Créer les fichiers ====
        utile.createTextFile(400); // 400 trois + 400 cinq
        utile.createTestArffFile("data/chiffres.txt", 
                            "data/train-data.arff");

        // ==== ÉTAPE 2 : Charger les données ====
        DataSource source = new DataSource("data/train-data.arff");
        Instances data = source.getDataSet();
        data.setClassIndex(data.numAttributes() - 1);

        // ==== ÉTAPE 3 : Naive Bayes ====
        System.out.println("=== NAIVE BAYES ===");
        NaiveBayes nb = new NaiveBayes();
        nb.buildClassifier(data);

        Evaluation evalNB = new Evaluation(data);
        evalNB.crossValidateModel(nb, data, 10, 
                                  new java.util.Random(1));
        System.out.println(evalNB.toSummaryString());

        // ==== ÉTAPE 4 : Random Forest ====
        System.out.println("=== RANDOM FOREST ===");
        RandomForest rf = new RandomForest();
        rf.buildClassifier(data);

        Evaluation evalRF = new Evaluation(data);
        evalRF.crossValidateModel(rf, data, 10, 
                                  new java.util.Random(1));
        System.out.println(evalRF.toSummaryString());
        
        
     // Tester imageToFile
        utile.imageToFile("data/monimage.png");

        // Tester fileToImage
        utile.fileToImage("data/monimage.txt");
        
     // Tester Excel
        utile.createExcelFile("data/chiffres.xlsx");
        
    }
    
    
    
    
 
    
    
    
    

    
    
    
 
}