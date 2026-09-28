package br.puc;

public class ArvoreBinariaMorse {
    private Nodo raiz;

    public void incializar(){
        raiz = new Nodo();
    }

    public void inserir(String codigo_morse, String caractere){
        Nodo noAtual = raiz;

        for(int i = 0; i < codigo_morse.length(); i++){
            char simbolo = codigo_morse.charAt(i);
            if(simbolo == '.'){
                if(noAtual.getFilho_esquerdo() == null){
                    noAtual.setFilho_esquerdo(new Nodo());
                }
                noAtual = noAtual.getFilho_esquerdo();
            }
            else if(simbolo == '-'){
                if(noAtual.getFilho_direito() == null){
                    noAtual.setFilho_direito(new Nodo());
                }
                noAtual = noAtual.getFilho_direito();
            }
        }
        noAtual.setCaractere(caractere);
    }

    public String buscar(String codigo_morse){
        Nodo noAtual = raiz;

        for(int i = 0; i < codigo_morse.length(); i++){
            char simbolo = codigo_morse.charAt(i);
            if(simbolo == '.'){
                noAtual = noAtual.getFilho_esquerdo();
            } else if(simbolo == '-') {
                noAtual = noAtual.getFilho_direito();
            }
            if(noAtual == null){
                return null;
            }
        }
        return noAtual.getCaractere();
    }

    public void carregarTabelaMorsePadrao() {
        inserir(".-", "A");
        inserir("-...", "B");
        inserir("-.-.", "C");
        inserir("-..", "D");
        inserir(".", "E");
        inserir("..-.", "F");
        inserir("--.", "G");
        inserir("....", "H");
        inserir("..", "I");
        inserir(".---", "J");
        inserir("-.-", "K");
        inserir(".-..", "L");
        inserir("--", "M");
        inserir("-.", "N");
        inserir("---", "O");
        inserir(".--.", "P");
        inserir("--.-", "Q");
        inserir(".-.", "R");
        inserir("...", "S");
        inserir("-", "T");
        inserir("..-", "U");
        inserir("...-", "V");
        inserir(".--", "W");
        inserir("-..-", "X");
        inserir("-.--", "Y");
        inserir("--..", "Z");
        inserir("-----", "0");
        inserir(".----", "1");
        inserir("..---", "2");
        inserir("...--", "3");
        inserir("....-", "4");
        inserir(".....", "5");
        inserir("-....", "6");
        inserir("--...", "7");
        inserir("---..", "8");
        inserir("----.", "9");
    }

    public void exibir(){
        exibirRecursivo(raiz, 0);
    }
    public void exibirRecursivo(Nodo no, int profundidade){
        if(no == null){
            return;
        }
        if(no.getCaractere() !=null){
            for(int i = 0; i < profundidade; i ++ ){
                System.out.print(" ");
            }
            System.out.println(no.getCaractere());
        }

        exibirRecursivo(no.getFilho_esquerdo(), profundidade+1);
        exibirRecursivo(no.getFilho_direito(), profundidade+1);
    }
    public String decodificarMensagem(String mensagem) {
        String resultado = "";
        String letraAtual = "";

        for (int i = 0; i < mensagem.length(); i++) {
            char caractere = mensagem.charAt(i);

            if (caractere == ' ') {
                if (letraAtual.length() > 0) {
                    String letraDecodificada = buscar(letraAtual);
                    if (letraDecodificada != null) {
                        resultado += letraDecodificada;
                    }
                    letraAtual = "";
                }
            } else if (caractere == '/') {
                resultado += " ";
            } else {
                letraAtual += caractere;
            }
        }
        if (letraAtual.length() > 0) {
            String letraDecodificada = buscar(letraAtual);
            if (letraDecodificada != null) {
                resultado += letraDecodificada;
            }
        }
        return resultado;
    }
}

