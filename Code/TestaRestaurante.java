/* @File TestaRestaurante.java
 * @Author Igor Barroso Almeida
 * @Brief Implementação da main que testa
 * as classes criadas para o projeto de restaurante
 * @Date 25/11/2022
*/

package Code;

import java.util.Scanner;

public class TestaRestaurante {
    // Imprime um menu e retorna a opção escolhida pelo usuário
    public static int menu() {
        Scanner read = new Scanner(System.in);
        int resposta = 0;

        System.out.println("\n-----------MENU-----------");
        System.out.println("[1] - Adicionar mesa;");
        System.out.println("[2] - Fazer reserva;");
        System.out.println("[3] - Cadastrar clientes;");
        System.out.println("[4] - Ver informações;");
        System.out.println("[5] - Atualizar reservas;");
        System.out.println("[6] - Fazer pedido;");
        System.out.println("[7] - Fechar pedido;");
        System.out.println("[0] - Finalizar");
        System.out.println("--------------------------");

        resposta = read.nextInt();

        return resposta;
    }

    public static void main(String[] args) {
        Restaurante R = new Restaurante("Buchinho cheio", "Praça de alimentação, Shopping del rey");
        int resposta;
        Scanner read = new Scanner(System.in);

        do {
            resposta = menu();
            // Implementação de cada uma das opções disponiveis no menu
            switch (resposta) {
                case 1:
                    // Adicionar mesa
                    int nMesa, nCadeiras;

                    System.out.println("Digite o numero da nova mesa");
                    nMesa = read.nextInt();

                    System.out.println("Quantas cadeiras a mesa tem?");
                    nCadeiras = read.nextInt();

                    R.addMesa(nMesa, nCadeiras);
                    break;
                case 2:
                    // Fazer reserva
                    int dia, mes, hora, nPessoas;
                    System.out.println("---Informações da reserva---");

                    System.out.println("Dia: ");
                    dia = read.nextInt();

                    System.out.println("Mes: ");
                    mes = read.nextInt();

                    System.out.println("Hora:");
                    hora = read.nextInt();

                    System.out.println("Numero de pessoas: ");
                    nPessoas = read.nextInt();

                    if (!R.realizarReserva(dia, mes, hora, nPessoas)) {
                        System.out.println("Não foi possivel realizar a reserva");
                    }
                    break;
                case 3:
                    // Cadastrar clientes
                    String[] nome, email;
                    int numPessoas;

                    System.out.println("Numero de pessoas: ");
                    numPessoas = read.nextInt();

                    nome = new String[numPessoas];
                    email = new String[numPessoas];

                    for (int i = 0; i < numPessoas; i++) {
                        int n = i + 1;
                        System.out.println("Digite o nome da pessoa " + n + ": ");
                        nome[i] = read.next();

                        System.out.println("Digite o email da pessoa " + n + ": ");
                        email[i] = read.next();
                    }

                    R.cadastraClientes(nome, email, numPessoas);
                    break;
                case 4:
                    // Ver informações
                    R.imprimeRestaurante();
                    break;
                case 5:
                    // Atualizar reservas
                    int diaAtual, mesAtual, horaAtual;

                    System.out.println("Dia atual: ");
                    diaAtual = read.nextInt();

                    System.out.println("Mes atual: ");
                    mesAtual = read.nextInt();

                    System.out.println("Hora atual: ");
                    horaAtual = read.nextInt();

                    R.atualizaReservas(diaAtual, mesAtual, horaAtual);
                    break;
                case 6:
                    // Fazer pedido
                    R.realizaPedido();
                    break;
                case 7:
                    // Fechar pedido
                    R.fechaPedido();
                    break;
                case 0:
                    // Finalizar programa
                    break;
                default:
                    System.out.println("Opção invalida");
            }

        } while (resposta != 0);
    }
}