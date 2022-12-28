/* @File Reserva.java
 * @Author Igor Barroso Almeida
 * @Brief modelagem da reserva de uma mesa
 * em um restaurante, contem todos os detalhes
 * da reserva e as comandas utilizadas no atendimento
 * dos clientes
 * @Date 25/11/2022
*/

package Code;

import java.util.Scanner;

public class Reserva {
    // Atributos
    private int id;
    private int dia;
    private int mes;
    private int hora;
    private boolean valida;
    protected ComandaComida comComida = new ComandaComida();
    protected ComandaBebida comBebida = new ComandaBebida();
    private Cliente[] clientes;

    // Getters
    public int getId() {
        return id;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getHora() {
        return hora;
    }

    public boolean isValida() {
        return valida;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setValida(boolean valida) {
        this.valida = valida;
    }

    // Construtores
    public Reserva(int dia, int mes, int hora) {
        this.dia = dia;
        this.mes = mes;
        this.hora = hora;
        this.valida = true;
    }

    // Métodos
    public void cadastraClientes(String[] nomes, String[] emails, int nPessoas) {
        this.clientes = new Cliente[nPessoas];

        for (int i = 0; i < this.clientes.length; i++) {
            this.clientes[i] = new Cliente();

            this.clientes[i].setNome(nomes[i]);
            this.clientes[i].setEmail(emails[i]);
        }
    }

    // imprime os dados da reserva
    public void imprimeReserva() {
        System.out.println("Id " + this.id);
        System.out.println(dia + "/" + mes + " as " + hora + " horas.");
        System.out.println("Clientes cadastrados:");
        if (this.clientes != null) {
            for (int i = 0; i < this.clientes.length; i++) {
                System.out.println("Nome: " + this.clientes[i].getNome());
                System.out.println("Email: " + this.clientes[i].getEmail());
            }

        } else {
            System.out.println("Nenhum cliente cadastrado");
        }

        System.out.println("~~~~");
    }

    // realiza um pedido, registrando tudo nas comandas
    public void realizaPedido(String consumo, double valor, int tipo) {
        // registra na comanda de acordo com o tipo 1 = comida
        if (tipo == 1) {
            this.comComida.addConsumo(consumo, valor);
        } else {
            this.comBebida.addConsumo(consumo, valor);
        }
    }

    // Fecha a comanda após todos os pedidos
    public void fechaPedido(int nPessoas) {
        double valorTotal = 0;
        double soma10porcento = 0;
        int dividir;
        Scanner read = new Scanner(System.in);

        // Soma os valores das diferentes comandas
        valorTotal += comComida.listarConsumo();
        valorTotal += comBebida.listarConsumo();
        soma10porcento += comComida.calcular10porcento();
        soma10porcento += comBebida.calcular10porcento();

        // Calculo do valor total
        valorTotal += soma10porcento;

        System.out.println("Voce deseja dividir a conta? (1 para sim e 2 para não): ");
        dividir = read.nextInt();

        // De acordo com o desejo do usuario, divide ou não a conta
        if (dividir == 1) {
            double valorPorPessoa;

            valorPorPessoa = comComida.dividirConta(nPessoas, valorTotal);
            System.out.println("Preço total por pessoa: R$" + valorPorPessoa);
        } else if (dividir == 2) {
            System.out.println("Valor total (10% incluso): " + valorTotal);
        }
    }
}