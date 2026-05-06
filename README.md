🔢 Mini-Projet : Reconnaissance de Chiffres Manuscrits avec Java & Weka

📋 Description
Ce projet implémente un système de reconnaissance automatique de chiffres manuscrits (3 et 5) en utilisant des algorithmes de Machine Learning. Il s'appuie sur la base de données MNIST et l'API Weka pour entraîner et tester deux modèles : Naive Bayes et Random Forest.

🎯 Objectifs

Lire et traiter les fichiers binaires MNIST
Créer des fichiers texte, image et Excel à partir des données
Entraîner des modèles de Machine Learning avec Weka
Comparer les performances de Naive Bayes et Random Forest


🗂️ Structure du projet
WekaProject/
├── src/
│   └── projet/
│       ├── Util.java         # Classe utilitaire (traitement des données)
│       └── Test.java         # Classe principale (tests et ML)
├── data/
│   ├── train-images.idx3-ubyte   # Images MNIST (binaire)
│   ├── train-labels.idx1-ubyte   # Labels MNIST (binaire)
│   ├── chiffres.txt              # Généré automatiquement
│   ├── train-data.arff           # Données d'entraînement Weka
│   └── test-data.arff            # Données de test Weka
└── lib/
    ├── weka.jar
    ├── poi-5.5.1.jar
    ├── poi-ooxml-5.5.1.jar
    ├── poi-ooxml-full-5.5.1.jar
    ├── commons-collections4-4.4.jar
    ├── commons-io-2.15.1.jar
    ├── commons-compress-1.24.0.jar
    ├── xmlbeans-5.1.1.jar
    ├── log4j-api-2.21.1.jar
    └── log4j-core-2.21.1.jar

⚙️ Prérequis

Java JDK 21 ou supérieur
Eclipse IDE (ou tout autre IDE Java)
Weka 3.8.7 (Télécharger)
Apache POI 5.5.1 (Télécharger)
Données MNIST (Télécharger sur Kaggle)


📦 Dépendances (JARs)
BibliothèqueVersionLien de téléchargementweka3.8.7waikato.ac.nzpoi5.5.1Mavenpoi-ooxml5.5.1Mavenpoi-ooxml-full5.5.1Mavencommons-collections44.4Mavencommons-io2.15.1Mavencommons-compress1.24.0Mavenxmlbeans5.1.1Mavenlog4j-api2.21.1Mavenlog4j-core2.21.1Maven

🚀 Installation et Configuration
1. Cloner le projet
bashgit clone https://github.com/ton-username/WekaProject.git
cd WekaProject
2. Télécharger les données MNIST

Va sur Kaggle MNIST
Télécharge train-images.idx3-ubyte et train-labels.idx1-ubyte
Place-les dans le dossier data/

3. Télécharger les JARs
Télécharge tous les JARs listés dans le tableau ci-dessus et place-les dans lib/
4. Configurer Eclipse

Importe le projet dans Eclipse
Clic droit sur le projet → Build Path → Configure Build Path
Onglet Libraries → Classpath → Add External JARs
Sélectionne tous les JARs du dossier lib/
Clique Apply and Close


📝 Méthodes de la classe Util
createTextFile(int n)
Crée le fichier chiffres.txt avec les n premiers "trois" et n premiers "cinq" extraits des fichiers binaires MNIST.
javaUtil.createTextFile(400); // 400 trois + 400 cinq = 800 lignes
imageToFile(String nomImage)
Convertit une image PNG 28x28 en fichier texte contenant les intensités des pixels.
javaUtil.imageToFile("data/monimage.png");
fileToImage(String nomFichier)
Reconstruit une image PNG à partir d'un fichier texte de pixels.
javaUtil.fileToImage("data/monimage.txt");
createExcelFile(String nomFichier)
Stocke les données de chiffres.txt dans un fichier Excel (.xlsx) avec Apache POI.
javaUtil.createExcelFile("data/chiffres.xlsx");
createArffFile(String input, String output)
Convertit chiffres.txt en format ARFF compatible avec Weka.
javaUtil.createArffFile("data/chiffres.txt", "data/train-data.arff");
createTestArffFile(String input, String output)
Crée un fichier ARFF de test à partir des 50 dernières lignes de chiffres.txt.
javaUtil.createTestArffFile("data/chiffres.txt", "data/test-data.arff");

🤖 Algorithmes de Machine Learning
Naive Bayes
Algorithme probabiliste basé sur le théorème de Bayes. Simple, rapide, mais moins précis.
Random Forest
Ensemble d'arbres de décision. Plus puissant et plus précis que Naive Bayes.

📊 Résultats
ModèlePrécision (Entraînement)Précision (Test)Naive Bayes87.5%92%Random Forest97%92%
Détail des résultats (800 instances d'entraînement)
=== NAIVE BAYES ===
Correctly Classified Instances    700    87.5%
Incorrectly Classified Instances  100    12.5%
Kappa statistic                   0.75

=== RANDOM FOREST ===
Correctly Classified Instances    776    97%
Incorrectly Classified Instances   24     3%
Kappa statistic                   0.94

🔄 Schéma de fonctionnement
Fichiers MNIST (binaires)
         ↓
   createTextFile(400)
         ↓
   chiffres.txt (800 lignes)
    ↙              ↘
createArffFile()   createExcelFile()
    ↓                    ↓
train-data.arff     chiffres.xlsx
    ↓
┌─────────────────────┐
│   Entraînement ML   │
│  ─ Naive Bayes 87.5%│
│  ─ Random Forest 97%│
└─────────────────────┘
    ↓
test-data.arff (50 instances)
    ↓
┌─────────────────────┐
│      Test final     │
│  ─ Naive Bayes  92% │
│  ─ Random Forest 92%│
└─────────────────────┘

👥 Auteurs

Nom : Sinda
Année universitaire : 2025/2026
Encadrant : Mohamed M. Moussa


📄 Licence
Ce projet est réalisé dans le cadre d'un mini-projet universitaire.

🙏 Remerciements

MNIST Database - Yann LeCun
Weka - University of Waikato
Apache POI - Apache Software Foundation
