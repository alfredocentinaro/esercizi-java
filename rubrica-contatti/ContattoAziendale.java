public class ContattoAziendale extends Contatto
{
    // ATTRIBUTI
    private String societa;
    private String mail;
    private Tipo tipoemail;

    // COSTRUTTORI
    public ContattoAziendale()
    {
        super();
    }

    public ContattoAziendale(String nome, String cognome, String telefono, Tipo tipotelfono, String societa, String mail, Tipo tipoemail) {
        super(nome, cognome, telefono, tipotelfono);
        this.societa = societa;
        this.mail = mail;
        this.tipoemail = tipoemail;
    }

    public String getSocieta() {
        return societa;
    }

    public void setSocieta(String societa) {
        this.societa = societa;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Tipo getTipoemail() {
        return tipoemail;
    }

    public void setTipoemail(Tipo tipoemail) {
        this.tipoemail = tipoemail;
    }

    void stampaInfo()
    {
        System.out.println("|---------------------------------------|");
        System.out.println("|         CONTATTO AZIENDALE            |");
        System.out.println("|---------------------------------------|");
        System.out.println("| Nome            : " + String.format("%-20s", this.getNome()) + "|");
        System.out.println("| Cognome         : " + String.format("%-20s", this.getCognome()) + "|");
        System.out.println("| Telefono        : " + String.format("%-20s", this.getTelefono()) + "|");
        System.out.println("| Tipo            : " + String.format("%-20s", this.getTipotelfono()) + "|");
        System.out.println("| Società         : " + String.format("%-20s", this.societa) + "|");
        System.out.println("| E-Mail          : " + String.format("%-20s", this.mail) + "|");
        System.out.println("| Tipo            : " + String.format("%-20s", this.tipoemail) + "|");
        System.out.println("|---------------------------------------|");
    }
}
