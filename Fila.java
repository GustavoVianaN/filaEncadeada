public class Fila {

    private NoFila ultimo = null;
    private NoFila elementoInicial = null;
    private int tamanho_fila = 0;


    public NoFila posicaoBuscar(int posicao) {
        if(!validarPosicao(posicao)) {
            throw new RuntimeException("Opção inválida");
        }

        NoFila elementoAtual = elementoInicial;

        for (int i = 0; i < posicao; i++) {
            elementoAtual = elementoAtual.getProximo();
        }
        return elementoAtual;
    }

    public void inserirPosicao(int posicao, int elemento) {
        if (tamanho_fila == 0) {
            inserirElementoInicio(elemento);
        } else if(posicao == tamanho_fila) {
            inserirNoFinal(elemento);
        } else {
            NoFila noNaPosicao = escolherPosicao(posicao);
            noNaPosicao.setNumero(elemento);
        }
    }

    public void imprimir() {
        if(tamanho_fila == 0) {
            System.out.println("[]");
            return;
        }

        String elementos = retornarElementos();
        System.out.println(elementos);
    }

    public NoFila escolherPosicao(int posicao) {
        if(!validarPosicao(posicao)) {
            throw new RuntimeException("Posição não existente");
        }

        NoFila elementoAtual = elementoInicial;


        for (int i = 0; i < posicao; i++) {

            elementoAtual = elementoAtual.getProximo();
        }
        return elementoAtual;
    }
    

    public void inserirElementoInicio(int elemento) {
        NoFila noSeguinte = new NoFila();
        noSeguinte.setNumero(elemento);
        noSeguinte.setProximo(elementoInicial);

        elementoInicial = noSeguinte;

        if(tamanho_fila == 0) {
            ultimo = elementoInicial;
        }

        tamanho_fila++;
    }

    public void inserirNoFinal(int elemento) {
        if(tamanho_fila == 0) {
            inserirElementoInicio(elemento);
        } else {
            NoFila noSeguinte = new NoFila();
            noSeguinte.setNumero(elemento);
            noSeguinte.setProximo(null);
            ultimo.setProximo(noSeguinte);
            ultimo = noSeguinte;
            tamanho_fila++;
        }
    }


    public void removerNoFinal() {
        if(tamanho_fila == 0) {
            return;
        }

        if(tamanho_fila == 1) {
            removerPosicaoInicio();
            return;
        }

        NoFila PosicaoAnterior = posicaoBuscar(tamanho_fila - 2);
        PosicaoAnterior.setProximo(null);

        ultimo = PosicaoAnterior;
        tamanho_fila--;
    }





    public void removerPosicaoInicio() {
        if(tamanho_fila == 0) {
            return;
        }

        elementoInicial = elementoInicial.getProximo();
        tamanho_fila--;

        if(tamanho_fila == 0) {
            ultimo = null;
        }
    }



    public void removerNaPosicao(int posicao) {
        if (tamanho_fila == 0) {
            removerPosicaoInicio();
        } else if(posicao == tamanho_fila) {
            removerNoFinal();
        } else {
            NoFila PosicaoAnterior = posicaoBuscar(posicao - 1);
            NoFila noNaPosicaoelementoAtual = PosicaoAnterior.getProximo();

            if(noNaPosicaoelementoAtual.getProximo() != null) {
                PosicaoAnterior.setProximo(noNaPosicaoelementoAtual.getProximo());
            } else {
                PosicaoAnterior.setProximo(null);
                ultimo = PosicaoAnterior;
            }

            tamanho_fila--;
        }
    }

    String retornarElementos() {
        StringBuilder elementos = new StringBuilder("[");

        NoFila elementoAtual = elementoInicial;

        while (elementoAtual.getProximo() != null) {
            elementos.append(elementoAtual.getNumero());
            elementos.append(" ");
            elementoAtual = elementoAtual.getProximo();
        }

        elementos.append(elementoAtual.getNumero());

        elementos.append("]");

        return elementos.toString();
    }



    public Integer retonarElementoPorPosicao(int posicao) {
        return posicaoBuscar(posicao).getNumero();
    }

    public int retornartamanho_filaDeElementos() {
        return tamanho_fila;
    }

    private boolean validarPosicao(int posicao){
        return posicao >= 0 && posicao < tamanho_fila;
    }



    public NoFila getElementoInicial() {
        return elementoInicial;
    }

    public NoFila getUltimo() {
        return ultimo;
    }
}
