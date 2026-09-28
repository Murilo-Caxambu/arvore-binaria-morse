package br.puc;

public class Nodo {
    private String caractere;
    private Nodo filho_esquerdo;
    private Nodo filho_direito;

    public Nodo getFilho_esquerdo() {return filho_esquerdo;}

    public void setFilho_esquerdo(Nodo filho_esquerdo) { this.filho_esquerdo = filho_esquerdo;}

    public String getCaractere() {return caractere;}

    public void setCaractere(String caractere) {this.caractere = caractere;}

    public Nodo getFilho_direito() {return filho_direito;}

    public void setFilho_direito(Nodo filho_direito) {this.filho_direito = filho_direito;}
}
