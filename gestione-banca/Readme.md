<h1>Classe conto corrente con gestione banca e arraylist ed ereditarietà</h1>

Vediamo un esercizio java con diversi spunti di riflessione e proprietà del nostro linguaggio. Implementiamo una classe che descrive una banca in cui è possibile aprire più conti corrente. La banca archivia questi conti con un comodo ArraList. Il conto corrente è invece una realtà duplice: c'è una classe padre e due figli che la specilizzano ereditando, uno sarà il conto corrente per le persone fisiche private, uno giuridico per le aziende. Lo schema UML di quello che vogliamo catalogare è riportato in basso. Anche se non specificati per brevità, sono da implementare i metodi di accesso, costruttori e costruttori di copia. Dei metodi da costruire si sappia che: 

- inserisciConto aggiunge all'arraylist l'oggetto del parametro
- cancellaConto elimina un oggetto ContoCorrente dall'ArrayList cercandolo per  IBAN passato come parametro
- cercaConto esegue la ricerca per nome e cognome se l'istanza è di ContoCorrentePrivato, per piva e ragioneSociale se ContoCorrenteGiuridico (DIFFICILE)
- stampaInfoConti gira tutto l'arraylist stampando le info dei conti presenti
- totaleSaldi da la somma dei saldi di tutti i conti dell'arraylist
- versamento aggiunge il double in parametro al saldo dell'oggetto e aumenta il numero di conteggioMovimenti di 1
- prelievo sottrae se possibile il double in parametro al saldo dell'oggetto e aumenta il numero di conteggioMovimenti di 1
- stampaInfo è in ovverride stampando le informazioni delle rispettive classi figlio + padre
