/* @File Restaurante.java
 * @Author Igor Barroso Almeida
 * @Brief Classe principal do projeto
 * modelagem de um sistema para um restaurante
 * @Date 25/11/2022
*/

package Code;

import java.util.Scanner;

public class Restaurante {
    // Atributos
    private String nome;
    private String endereco;
    private Mesa[] mesas;

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Construtores
    Restaurante() {
    }

    Restaurante(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }

    // Métodos
    public void addMesa(int numeroMesa, int nCadeiras) {
        // Se ainda não tem nenhuma mesa, cria
        if (this.mesas == null) {
            this.mesas = new Mesa[1];
        } else {
            Mesa[] aux = new Mesa[this.mesas.length + 1];

            // Copia as mesas já existentes para o aux
            for (int i = 0; i < this.mesas.length; i++) {
                aux[i] = this.mesas[i];
            }

            this.mesas = aux;
        }

        // Nova mesa é adicionada
        Mesa m = new Mesa(numeroMesa, nCadeiras);
        this.mesas[this.mesas.length - 1] = m;
    }

    /*
     * Método que a partir de uma solicitação de reserva
     * Procura uma mesa disponivel, se achou a mesa retorna true
     * e reserva a mesa, se não retorna false
     */
    public boolean realizarReserva(int dia, int mes, int hora, int nPessoas) {
        if (mesas != null) {
            for (int i = 0; i < this.mesas.length; i++) {
                // Se a reserva der certo
                if (this.mesas[i].reservar(dia, mes, hora, nPessoas)) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    // Atualiza as reservas de todas as mesas
    public void atualizaReservas(int diaAtual, int mesAtual, int horaAtual) {

        if (mesas != null) {
            for (int i = 0; i < this.mesas.length; i++) {
                mesas[i].atualizaReservas(diaAtual, mesAtual, horaAtual);
            }
        } else {
            System.out.println("Não há mesas cadastradas");
        }
    }

    public void imprimeRestaurante() {
        System.out.println("Restaurante " + this.nome);
        System.out.println("Endereço: " + endereco + "\n");
        System.out.println("-----Informações das mesas-----");

        if (this.mesas != null) {
            for (int i = 0; i < this.mesas.length; i++) {
                mesas[i].imprimeMesa();
            }

            System.out.println("----------------------------");
        } else {
            System.out.println("Não há mesas cadastradas");
        }
    }

    public void realizaPedido() {
        if (mesas != null) {
            Scanner read = new Scanner(System.in);
            int id, mesa, tipo;
            String consumo;
            double Valor;

            System.out.println("Digite o numero da mesa: ");
            mesa = read.nextInt();

            System.out.println("Digite o id da reserva que deseja realizar o pedido: ");
            id = read.nextInt();

            System.out.print("Qual o tipo (1 para comida e 2 para bebida): ");
            tipo = read.nextInt();

            System.out.println("Digite o consumo: ");
            consumo = read.next();

            System.out.println("Digite o preço por esse consumo: ");
            Valor = read.nextDouble();

            for (int i = 0; i < mesas.length; i++) {
                if (mesas[i].getNumeroMesa() == mesa) {
                    for (int j = 0; j < mesas[i].reservas.length; j++) {
                        if (mesas[i].reservas[j].getId() == id) {
                            mesas[i].reservas[j].realizaPedido(consumo, Valor, tipo);

                            break;
                        }
                    }

                    break;
                }
            }
        } else {
            System.out.println("Não há mesas cadastradas");
        }
    }

    public void fechaPedido() {
        if (mesas != null) {
            Scanner read = new Scanner(System.in);
            int id, mesa;

            System.out.println("Digite o numero da mesa: ");
            mesa = read.nextInt();

            System.out.println("Digite o id da reserva que deseja fechar o pedido: ");
            id = read.nextInt();

            for (int i = 0; i < mesas.length; i++) {
                if (mesas[i].getNumeroMesa() == mesa) {
                    if (mesas[i].reservas == null) {
                        System.out.println("Não há reservas nessa mesa");
                        break;
                    }
                    for (int j = 0; j < mesas[i].reservas.length; j++) {
                        if (mesas[i].reservas[j].getId() == id) {
                            mesas[i].reservas[j].fechaPedido(mesas[i].getnCadeiras());

                            break;
                        }
                    }

                    break;
                }
            }
        } else {
            System.out.println("Não há mesas cadastradas");
        }
    }

    public void cadastraClientes(String[] nomes, String[] emails, int nPessoas) {
        if (mesas != null) {
            Scanner read = new Scanner(System.in);
            int id, mesa;

            System.out.println("Digite o numero da mesa: ");
            mesa = read.nextInt();

            System.out.println("Digite o id da reserva: ");
            id = read.nextInt();

            for (int i = 0; i < mesas.length; i++) {
                if (mesas[i].getNumeroMesa() == mesa) {
                    if (mesas[i].reservas == null) {
                        System.out.println("Não há reservas nessa mesa");
                        break;
                    }
                    for (int j = 0; j < mesas[i].reservas.length; j++) {
                        if (mesas[i].reservas[j].getId() == id) {
                            mesas[i].reservas[j].cadastraClientes(nomes, emails, nPessoas);
                            break;
                        }
                    }

                    break;
                }
            }
        } else {
            System.out.println("Não há mesas cadastradas;");
        }
    }
}