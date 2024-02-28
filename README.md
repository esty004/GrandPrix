# Grand Prix

Questo progetto simula una gara automobilistica in cui i piloti gareggiano su diversi circuiti.

## Funzionalità

- **Criptazione Password**: Le password dei giocatori vengono criptate utilizzando l'algoritmo di Vigenère.
- **Salvataggio Dati**: I dati dei giocatori e dei piloti vengono salvati su file CSV.
- **Simulazione Gara**: I piloti gareggiano su circuiti predefiniti, con possibilità di incidenti e pit stop.
- **Classifica Finale**: Alla fine della gara viene generata una classifica dei piloti.

## Istruzioni per l'utilizzo

1. **Esecuzione del Programma**: Per eseguire il programma, compilare ed eseguire il file `GrandPrix.java`.
2. **Input Utente**: Seguire le istruzioni visualizzate sulla console per inserire i dati richiesti.
3. **Visualizzazione Risultati**: Alla fine della gara, verrà visualizzata la classifica finale e salvata su file.

## Struttura del Codice

Il codice è diviso in diverse classi:

- **GrandPrix.java**: La classe principale che avvia il programma e gestisce l'input dell'utente.
- **Giocatore.java**: Gestisce i dati e le azioni del giocatore, inclusa la criptazione delle password.
- **Circuito.java**: Rappresenta un circuito e gestisce la simulazione della gara.
- **Pilota.java**: Rappresenta un pilota e gestisce la simulazione della sua corsa.
- **Scrittore.java**: Gestisce il salvataggio dei dati su file.
- **Cronometro.java**: Gestisce il tempo durante la gara.
- **ScrittoreDatiPiloti.java**: Gestisce il salvataggio dei dati dei piloti su file.
- **Lettore.java**: Gestisce la lettura dei file.

## Requisiti di Sistema

- JDK (Java Development Kit) installato sul sistema.

## Avvertenza

Questo programma è stato sviluppato a scopo didattico e non dovrebbe essere utilizzato in ambienti di produzione senza una rigorosa revisione e adeguata sicurezza.

---

© 2024 - Esty
