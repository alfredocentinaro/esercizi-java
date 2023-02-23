# Gestione thread: simulazione impianto di produzione schede
Un esercizio completo e un po’ complesso. Vogliamo simulare un impianto di produzione di schede con tre macchinari.

Ogni macchinario è identificato da un codice alfanumerico e produce, in contemporanea con gli altri macchinari, delle schede che sono idealmente rappresentate da un semplice numero seriale da apporvi, costruito dal codicemacchinario-seriale.

Il seriale è un terzo oggetto che deve essere costruito con un numero intero auto-incrementale ad ogni pezzo che viene realizzato dai macchinari. Il seriale, non è gestito direttamente dai macchinari, ma deve essere condiviso comunque tra tutti.

Ogni macchinario produce una scheda in un tempo casuale tra i 2 e 5 secondi, stacca e stampa un seriale con la modalità descritta. Ogni macchinario può produrre al massimo 100 schede al giorno, dopodiché arresta la sua esecuzione.

L’impianto conta 3 macchinari. Ogni giorno viene avviato l’impianto e i suoi macchinari con un tasto invio (prevedere un opportuno messaggio). Viene impostato un numero seriale da cui riprendere la stampa delle schede. Col tasto invio si può stoppare nuovamente la produzione in qualsiasi momento, lasciando che i macchinari finiscano la produzione della scheda che hanno eventualmente in corso.


Al termine della produzione giornaliera o dell’arresto preventivo, viene stampato il quantitativo complessivo di schede prodotte, comprese quelle concluse dopo l’arresto forzato.

La spiegazione completa su https://www.alfredocentinaro.it/lezioni/java/thread-java-impianto-di-produzione-schede-con-seriale/
