#  Reconnaissance de Chiffres Manuscrits — Java & Weka

> Projet de Machine Learning pour reconnaître automatiquement les chiffres **3** et **5** à partir de la base de données **MNIST**.

---

## 🛠️ Technologies

- **Java 21** — Langage principal
- **Weka 3.8.7** — Algorithmes de Machine Learning
- **Apache POI 5.5.1** — Génération de fichiers Excel
- **MNIST** — Base de données d'images de chiffres manuscrits

---

##  Résultats

| Modèle | Entraînement | Test |
|:---|:---:|:---:|
| Naive Bayes | 87.5% | 92% |
| **Random Forest** | **97%** | **92%** |

>  **Random Forest** est le meilleur modèle avec **97%** de précision sur 800 chiffres.

---

##  Structure du projet

```
WekaProject/
├── src/
│   └── projet/
│       ├── Util.java        # Traitement des données
│       └── Test.java        # Machine Learning
└── data/
    ├── train-images.idx3-ubyte    # Images MNIST
    ├── train-labels.idx1-ubyte    # Labels MNIST
    ├── chiffres.txt               # Généré automatiquement
    ├── train-data.arff            # Généré automatiquement
    └── test-data.arff             # Généré automatiquement
```

---

## ⚙️ Fonctionnalités

```java
Util.createTextFile(400)         // Extrait 400 "trois" + 400 "cinq" → chiffres.txt
Util.imageToFile("image.png")    // Convertit une image PNG en fichier texte
Util.fileToImage("fichier.txt")  // Reconstruit une image PNG depuis un fichier texte
Util.createExcelFile("data.xlsx")// Exporte les données en Excel
Util.createArffFile(...)         // Génère train-data.arff pour Weka
Util.createTestArffFile(...)     // Génère test-data.arff pour Weka
```

---

##  Installation

### Étape 1 — Cloner le projet

```bash
git clone https://github.com/ton-username/WekaProject.git
cd WekaProject
```

### Étape 2 — Télécharger les données MNIST

 [https://www.kaggle.com/datasets/hojjatk/mnist-dataset](https://www.kaggle.com/datasets/hojjatk/mnist-dataset)

Placer dans `data/` :
- `train-images.idx3-ubyte`
- `train-labels.idx1-ubyte`

### Étape 3 — Télécharger les JARs

| JAR | Téléchargement |
|:---|:---|
| weka.jar | [waikato.ac.nz](https://www.cs.waikato.ac.nz/ml/weka/) |
| poi-5.5.1.jar | [Maven Central](https://repo1.maven.org/maven2/org/apache/poi/poi/5.5.1/poi-5.5.1.jar) |
| poi-ooxml-5.5.1.jar | [Maven Central](https://repo1.maven.org/maven2/org/apache/poi/poi-ooxml/5.5.1/poi-ooxml-5.5.1.jar) |
| poi-ooxml-full-5.5.1.jar | [Maven Central](https://repo1.maven.org/maven2/org/apache/poi/poi-ooxml-full/5.5.1/poi-ooxml-full-5.5.1.jar) |
| commons-collections4-4.4.jar | [Maven Central](https://repo1.maven.org/maven2/org/apache/commons/commons-collections4/4.4/commons-collections4-4.4.jar) |
| commons-io-2.15.1.jar | [Maven Central](https://repo1.maven.org/maven2/commons-io/commons-io/2.15.1/commons-io-2.15.1.jar) |
| xmlbeans-5.1.1.jar | [Maven Central](https://repo1.maven.org/maven2/org/apache/xmlbeans/xmlbeans/5.1.1/xmlbeans-5.1.1.jar) |
| log4j-api-2.21.1.jar | [Maven Central](https://repo1.maven.org/maven2/org/apache/logging/log4j/log4j-api/2.21.1/log4j-api-2.21.1.jar) |
| log4j-core-2.21.1.jar | [Maven Central](https://repo1.maven.org/maven2/org/apache/logging/log4j/log4j-core/2.21.1/log4j-core-2.21.1.jar) |

### Étape 4 — Configurer Eclipse

```
Clic droit sur le projet
→ Build Path
→ Configure Build Path
→ Libraries → Classpath
→ Add External JARs
→ Sélectionner tous les JARs
→ Apply and Close
```

### Étape 5 — Exécuter

```
Clic droit sur Test.java → Run As → Java Application
```

---

## Auteur
Sinda Hkimi 1TA2

**Sinda Hkimi** — ENSTAB 2025/2026

Encadrant : **Mohamed M. Moussa**
