🔢 Mini-Projet : Reconnaissance de Chiffres Manuscrits avec Java & Weka

Projet de Machine Learning pour reconnaître automatiquement les chiffres 3 et 5 à partir de la base de données MNIST.

Technologies utilisées

Java 21 — Langage principal
Weka 3.8.7 — Algorithmes de Machine Learning
Apache POI 5.5.1 — Génération de fichiers Excel
MNIST — Base de données d'images de chiffres manuscrits


Fonctionnalités
MéthodeDescriptioncreateTextFile(n)Extrait n chiffres "trois" et n chiffres "cinq" depuis MNIST → chiffres.txtimageToFile(image)Convertit une image PNG 28x28 en fichier texte de pixelsfileToImage(fichier)Reconstruit une image PNG depuis un fichier texte de pixelscreateExcelFile(fichier)Exporte les données dans un fichier Excel (.xlsx)createArffFile()Génère train-data.arff pour l'entraînement WekacreateTestArffFile()Génère test-data.arff pour les tests Weka

Résultats
ModèleEntraînementTestNaive Bayes87.5%92%Random Forest97%92%

✅ Random Forest est le meilleur modèle avec 97% de précision sur 800 chiffres.


Installation
1. Cloner le projet
bashgit clone https://github.com/ton-username/WekaProject.git
2. Télécharger les données MNIST
👉 https://www.kaggle.com/datasets/hojjatk/mnist-dataset
Placer ces fichiers dans data/ :
data/
├── train-images.idx3-ubyte
└── train-labels.idx1-ubyte
3. Télécharger les JARs et les ajouter dans Eclipse
Build Path → Classpath → Add External JARs
JARLienweka.jarhttps://www.cs.waikato.ac.nz/ml/weka/poi-5.5.1.jarhttps://repo1.maven.org/maven2/org/apache/poi/poi/5.5.1/poi-5.5.1.jarpoi-ooxml-5.5.1.jarhttps://repo1.maven.org/maven2/org/apache/poi/poi-ooxml/5.5.1/poi-ooxml-5.5.1.jarpoi-ooxml-full-5.5.1.jarhttps://repo1.maven.org/maven2/org/apache/poi/poi-ooxml-full/5.5.1/poi-ooxml-full-5.5.1.jarcommons-collections4-4.4.jarhttps://repo1.maven.org/maven2/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.jarcommons-io-2.15.1.jarhttps://repo1.maven.org/maven2/commons-io/commons-io/2.15.1/commons-io-2.15.1.jarxmlbeans-5.1.1.jarhttps://repo1.maven.org/maven2/org/apache/xmlbeans/xmlbeans/5.1.1/xmlbeans-5.1.1.jarlog4j-api-2.21.1.jarhttps://repo1.maven.org/maven2/org/apache/logging/log4j/log4j-api/2.21.1/log4j-api-2.21.1.jarlog4j-core-2.21.1.jarhttps://repo1.maven.org/maven2/org/apache/logging/log4j/log4j-core/2.21.1/log4j-core-2.21.1.jar
4. Exécuter
Clic droit sur Test.java → Run As → Java Application

Structure du projet
WekaProject/
├── src/projet/
│   ├── Util.java       ← Traitement des données
│   └── Test.java       ← Machine Learning
└── data/
    ├── train-images.idx3-ubyte
    ├── train-labels.idx1-ubyte
    ├── chiffres.txt          ← généré automatiquement
    ├── train-data.arff       ← généré automatiquement
    └── test-data.arff        ← généré automatiquement

Auteur
Sinda Hkimi — Université: ENSTAB 2025/2026
Encadrant : Mohamed M. Moussa



