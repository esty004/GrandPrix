# Simulatore Grand Prix

Questo progetto consiste in un'applicazione Java che simula una gara di Grand Prix, dove i giocatori possono partecipare come piloti, gestendo le proprie auto attraverso un circuito e vivendo varie situazioni di gara come i pit stop, gli incidenti e gli interventi della safety car.

## Funzionalità

- **Registrazione Giocatori**: I giocatori possono registrarsi fornendo il loro nome, password e chiave di crittografia.
- **Crittografia Password**: Le password dei giocatori vengono crittografate utilizzando il cifrario di Vigenère prima di essere salvate.
- **Archiviazione Dati**: I dati crittografati dei giocatori vengono salvati su un file CSV.
- **Gestione Circuito**: Gli utenti possono specificare il nome del circuito, il numero di giri, la lunghezza e il numero di possibili pit stop.
- **Gestione Piloti**: I giocatori possono gestire i piloti che partecipano alla gara, fornendo i loro nomi e modelli di auto.
- **Simulazione Gara**: L'applicazione simula la gara, includendo movimenti delle auto, pit stop, incidenti e interventi della safety car.
- **Registrazione Dati**: I dati della gara come nomi dei piloti e modelli di auto vengono registrati su un file CSV.

## Come Eseguire

Per compilare ed eseguire il programma, segui questi passaggi:

1. Assicurati di avere installato il Java Development Kit (JDK) sul tuo sistema.
2. Clona o scarica questo repository sul tuo computer locale.
3. Naviga nella directory del progetto tramite la riga di comando.
4. Compila i file Java usando il seguente comando:

    ```
    javac com/mycompany/grandprix/*.java
    ```

5. Esegui l'applicazione con il seguente comando:

    ```
    java com.mycompany.grandprix.GrandPrix
    ```

6. Segui le istruzioni visualizzate a schermo per partecipare alla simulazione del Grand Prix.


