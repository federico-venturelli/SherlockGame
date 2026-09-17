# Sherlock game 🔎

Un videogioco investigativo 2D point-and-click sviluppato interamente in **Java Swing** puro.

Questo progetto è stato realizzato come prova d'esame per il corso di Programmazione Orientata agli Oggetti (Corso di Laurea in Matematica con curriculum in Informatica, Università Cattolica - Brescia). 

L'obiettivo principale del progetto è dimostrare la corretta applicazione del paradigma OOP, l'implementazione di Design Pattern e il mantenimento di un'architettura software pulita ed estensibile.

## 🕹️ Il gioco: il delitto di villa Morandi

Il giocatore veste i panni di un detective chiamato a risolvere l'omicidio del Professor Morandi all'interno della sua villa. 
Le meccaniche di gioco includono:
* **Esplorazione:** navigazione attraverso la mappa della villa e l'interno delle varie stanze.
* **Analisi degli Indizi:** ricerca di prove sulla scena del crimine.
* **Risoluzione di Enigmi:** deduzione di password e codici (tramite un sistema polimorfico di enigmi) per sbloccare documenti segreti e dispositivi protetti (PC, terminali).
* **Interrogatori:** raccolta delle dichiarazioni dei sospettati.
* **Accusa Finale:** rielaborazione degli indizi sul taccuino per formulare l'accusa finale contro il vero colpevole.

## 📐 Architettura e design pattern

Il codice è stato progettato con un'attenzione rigorosa ai principi dell'Ingegneria del Software, evitando God Classes e logica procedurale.

* **Pattern MVC Rigoroso:** separazione netta tra Modello (logica di dominio) e Vista (GUI Swing). Il modello è completamente agnostico rispetto all'interfaccia.
* **Pattern Facade:** la GUI comunica con il Modello esclusivamente tramite la classe `FacciataSherlock`, garantendo un accoppiamento debole (Low Coupling).
* **Event Listener Distribuiti:** nessun "God Controller". Ogni interazione (es. esplorazione, accusa, analisi) è gestita da classi `.java` autonome e separate, nel pieno rispetto del Single Responsibility Principle. Nessun uso di classi anonime per la gestione degli eventi Swing.
* **Design Pattern Creazionali e Comportamentali:**
  * **Factory Method:** `FabbricaGioco` centralizza la creazione delle entità della partita.
  * **Template Method:** gestione dell'impalcatura dei casi (`Caso` / `CasoVilla`) e del layout dinamico.
  * **Strategy:** risoluzione polimorfica dei lucchetti digitali (`Enigma` / `EnigmaCodice`).
  * **Singleton:** gestione ottimizzata delle risorse audio tramite `GestoreAudio`.
* **Scalatura Grafica Dinamica:** algoritmo custom integrato in `PannelloGioco` per la trasformazione matematica delle coordinate degli *hotspot* (bottoni invisibili) in base al ridimensionamento proporzionale della finestra.

## 🛠️ Stack tecnologico

* **Linguaggio:** Java 17
* **Librerie:** Java Swing, AWT, `javax.sound.sampled` (nessun framework grafico esterno)
* **Build System:** Maven

## 🚀 Come Giocare
1. Vai nella sezione **Releases** di questa repository.
2. Scarica il file `SherlockGame.jar` della versione più recente.
3. Avvia il gioco facendo doppio clic sul file, oppure da terminale con il comando:
   ```bash
   java -jar SherlockGame.jar
