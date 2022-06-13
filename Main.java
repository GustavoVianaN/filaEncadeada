import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Fila fila = new Fila();
        int filaInicial = 0;

        while (filaInicial <= 5) { 
            filaInicial = filaInicial + 1;
            fila.inserirElementoInicio(filaInicial);
        }

        fila.imprimir();

        while (true) {

        Scanner inputEscolha_1 = new Scanner(System.in);
        int escolha_1;

        System.out.println("Selecione a opção");
        System.out.println("inserir : 1");
        System.out.println("remover : 2");
        escolha_1 = inputEscolha_1.nextInt();

        if (escolha_1 == 1) {
            System.out.println("Inserir no início : 1");
            System.out.println("Inserir no final  : 2");
            System.out.println("Escolher posição  : 3");
            Scanner inserirElemento = new Scanner(System.in);
            int inserir;
            inserir = inserirElemento.nextInt();
            
            if (inserir == 1) {
                System.out.println("Qual número deseja inserir? ");
                Scanner numeroInserirElemento = new Scanner(System.in);
                int numeroInserir;
                numeroInserir = numeroInserirElemento.nextInt();
                fila.inserirElementoInicio(numeroInserir);
                fila.imprimir();
            }

            if (inserir == 2) {
                System.out.println("Qual número deseja inserir? ");
                Scanner numeroInserirElemento = new Scanner(System.in);
                int numeroInserir;
                numeroInserir = numeroInserirElemento.nextInt();
                fila.inserirNoFinal(numeroInserir);
                fila.imprimir();
                
            }
            if (inserir == 3) {
                System.out.println("Qual número deseja inserir? ");
                Scanner numeroInserirElemento = new Scanner(System.in);
                int numeroInserir;
                numeroInserir = numeroInserirElemento.nextInt();
                System.out.println("Qual posição deseja inserir? ");
                Scanner PosicaoInsercao = new Scanner(System.in);
                int posicaoInserir;
                posicaoInserir = PosicaoInsercao.nextInt();
                fila.inserirPosicao(posicaoInserir, numeroInserir);
                fila.imprimir();

            }


        }
        else if (escolha_1 == 2) {

        {
                System.out.println("Remover no início: 1");
                System.out.println("Remover no final : 2");
                System.out.println("Escolher posição : 3");
                Scanner numeroInserirElemento = new Scanner(System.in);
                int numeroInserir;
                numeroInserir = numeroInserirElemento.nextInt();
                if (numeroInserir == 1) {
                fila.removerPosicaoInicio();
                fila.imprimir();

                } 
                if(numeroInserir == 2){
                    fila.removerNoFinal();
                    fila.imprimir();

                }
                if(numeroInserir == 3){
                    System.out.println("Qual posição remover? ");
                    Scanner removerElemento = new Scanner(System.in);
                    int remover;
                    remover = removerElemento.nextInt();
                    fila.removerNaPosicao(remover);
                    fila.imprimir();

                }


            }
}



    }
    }

}