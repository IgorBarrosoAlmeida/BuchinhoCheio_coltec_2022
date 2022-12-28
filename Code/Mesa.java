/* @File Mesa.java
 * @Author Igor Barroso Almeida
 * @Brief modelagem de uma mesa
 * de um restaurante que contem 
 * as reservas ligadas a ela
 * @Date 25/11/2022
*/

package Code;

public class Mesa {
    // Atributos
    private int numeroMesa;
    private int nCadeiras;
    protected Reserva[] reservas;

    // Getters
    public int getNumeroMesa() {
        return numeroMesa;
    }

    public int getnCadeiras() {
        return nCadeiras;
    }

    // Setters
    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    // Construtores
    Mesa() {
    }

    Mesa(int numeroMesa, int nCadeiras) {
        this.numeroMesa = numeroMesa;
        this.nCadeiras = nCadeiras;
    }

    // Métodos
    public void addCadeira() {
        nCadeiras++;
    }

    public void tiraCadeira() {
        nCadeiras--;
    }

    /*
     * Método que realiza a reserva da mesa
     * Retorna verdadeiro caso a reserva dê certo
     * Retorna falso se a reserva der errado
     */
    public boolean reservar(int dia, int mes, int hora, int nPessoas) {

        if (nPessoas != this.nCadeiras) {
            // Muitas pessoas para poucas cadeiras
            return false;
        } else {
            // Se ainda não tem nenhuma reserva, cria
            if (this.reservas == null) {
                this.reservas = new Reserva[1];
            } else {
                // Verifica se já não há uma reserva igual
                for (int i = 0; i < this.reservas.length; i++) {
                    if (this.reservas[i].getDia() == dia && this.reservas[i].getMes() == mes
                            && this.reservas[i].getHora() == hora) {
                        return false;
                    }
                }

                Reserva[] aux = new Reserva[this.reservas.length + 1];

                // Copia as reservas já existentes para o aux
                for (int i = 0; i < this.reservas.length; i++) {
                    aux[i] = this.reservas[i];
                }

                this.reservas = aux;
            }

            // Nova reserva é adicionada
            this.reservas[this.reservas.length - 1] = new Reserva(dia, mes, hora);
            this.reservas[this.reservas.length - 1].setId(this.reservas.length - 1);
            // A reserva deu certo
            return true;
        }

    }

    // Método que tira as reservas invalidas do array "reservas"
    public void atualizaReservas(int diaAtual, int mesAtual, int horaAtual) {

        if (this.reservas != null) {
            int qntValidas = 0;

            // Conta a quantidade de reservas validas
            for (int i = 0; i < this.reservas.length; i++) {
                // Se o mês já passou, é invalida
                if (this.reservas[i].getMes() < mesAtual) {
                    this.reservas[i].setValida(false);

                    // Se o dia já passou, é invalida
                } else if (this.reservas[i].getMes() == mesAtual && this.reservas[i].getDia() < diaAtual) {
                    this.reservas[i].setValida(false);

                    // Se a hora já passou, é invalida
                } else if (this.reservas[i].getMes() == mesAtual && this.reservas[i].getDia() == diaAtual
                        && this.reservas[i].getHora() < horaAtual) {
                    this.reservas[i].setValida(false);
                } else {
                    // Conta as reservas validas
                    qntValidas++;
                }
            }

            Reserva[] aux = new Reserva[qntValidas];
            int pos = 0;

            // Copia todas as reservas validas pra aux
            for (int i = 0; i < this.reservas.length; i++) {
                if (this.reservas[i].isValida()) {
                    aux[pos] = this.reservas[i];
                    // reset dos IDs
                    aux[pos].setId(pos);
                    // Para colocar na posição correta em aux
                    pos++;
                }
            }

            // Atualiza "reservas" apenas com as validas
            this.reservas = aux;
        }
    }

    public void imprimeMesa() {
        System.out.println("> Mesa " + this.numeroMesa);
        System.out.println("Numero de cadeiras: " + this.nCadeiras);
        System.out.println("Reservas: ");

        // Imprime as reservas, se tiver
        if (this.reservas != null) {
            for (int i = 0; i < this.reservas.length; i++) {
                if (reservas[i].isValida()) {
                    reservas[i].imprimeReserva();
                }
            }
        } else {
            System.out.println("Não há reserva cadastrada");
        }

        System.out.print("\n");
    }
}