class CandidatoSaida {

    private String nome;
    private double media;
    private double mediana;
    private double variancia;
    private double desvpadrao;

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setMedia(double media){
        this.media = media;
    }
    public void setMediana(double mediana){
        this.mediana = mediana;
    }
    public void setVariancia(double variancia){
        this.variancia = variancia;
    }
    public void setDesvpadrao(double desvpadrao){
        this.desvpadrao = desvpadrao;
    }

    public String getNome(){
        return this.nome;
    }
    public double getMedia(){
        return this.media;
    }
    public double getMediana(){
        return this.mediana;
    }
    public double getVariancia(){
        return this.variancia;
    }
    public double getDesvpadrao(){
        return this.desvpadrao;
    }
    public String toString(){
        return this.getNome() + " Media = " + this.getMedia() + " Mediana = " + this.getMediana() + " Devio Padrao = " + this.getDesvpadrao() + " Variancia = " + this.getVariancia();
    }
}