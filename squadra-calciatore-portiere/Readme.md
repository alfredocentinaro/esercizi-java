Creare una gerarchia di classi come nel diagramma UML in foto per Calciatore e Portiere. Prevedere gli attributi, metodi di accesso set/get (non indicati per brevità), costruttori e metodi accessori come da schema. Dare particolare attenzione a overloading e override di costruttori e metodi. Creare quindi una classe main di test che funge da black box ed implementare le seguenti richieste;


Parte 1

crea l’istanza c1 di tipo Calciatore e p1 di tipo Portiere;
visualizzi i dati del Calciatore c1 e del portiere p1;
visualizzare il nome di quale dei due atleti ha giocato più partite;
per il portiere p1 visualizzare il messaggio “Ottimo” se il numero di rigori parati è pari almeno alla metà dei rigori subiti;
per il calciatore c1, visualizzare la media gol a partita

Parte 2

Implementiamo la restante porzione di UML realizzando la classe Squadra che gestisce più calciatori con un ArrayList. Realizzare i seguenti metodi:

inserisciCalciatore(Calciatore): void – Aggiunge un calciatore di tipo oggetto all’arraylist
cerca(nome): int – Cerca un calciatore per nome passato come parametro e restituisce la posizione indice dell’arraylist
modifica(nome): Calciatore – Cerca un calciatore per nome passato come parametro e restituisce l’oggetto corrispondente
rimuoviCalciatore(int): void – Prende il Calciatore in posizione passata da parametro e lo cancella
rimuoviCalciatore(String): void – Cerca un calciatore per nome e lo rimuove
stampaRosa(): void – Stampa le informazioni di tutti i calciatori in rosa. Stampare anche il ruolo (usa instanceof)
valoreInEuroSquadra(): int; restituisce il totale somma dei valori in euro di tutti i calciatori in rosa
calciatoreConPiùGol(): Calciatore – Restituisce l’oggetto calciatore che ha più gol fatti in rosa
Nel main, testare ciascuno dei metodi appena implementati inserendo un congruo numero di calciatori/portieri nella rosa.

La spiegazione completa dell'esercizio la trovate su: https://www.alfredocentinaro.it/lezioni/java/classe-squadra-con-calciatore-e-portiere-con-ereditarieta-in-java/
