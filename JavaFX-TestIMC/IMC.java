package com.centinaro.testimc;

public class IMC
{
    private double peso;
    private double altezza;
    private Sesso sesso;

    public IMC( double altezza, double peso,Sesso sesso) {
        this.peso = peso;
        this.altezza = altezza;
        this.sesso = sesso;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }

    /**
     * Formula: Peso (kg) / ( Altezza (m) * Altezza (m) )
     */
    double calcolaIMC()
    {
        double imc = 0;

        imc = this.peso / (this.altezza * this.altezza);

        return imc;
    }

    /**
     * sottopeso 	<18,5
     * normopeso 	18,5-24,9
     * sovrappeso 	25-29,9
     * obesità 	>30
     */

    Stato statoIMC()
    {
        double imc = this.calcolaIMC();
        Stato  stato = Stato.Sottopeso;

        //if (this.sesso == Sesso.M){} cerca la formula uomo/donna

        if (imc < 18.5)
        {
            stato = Stato.Sottopeso;
        }

        if (imc >= 18.5 && imc <= 24.9)
        {
            stato =  Stato.Normopeso;
        }

        if (imc >= 25 && imc <= 29.9)
        {
            stato =  Stato.Sovrappeso;
        }

        if (imc >29.9) {
            stato =  Stato.Obeso;
        }

        return stato;

    }
}
