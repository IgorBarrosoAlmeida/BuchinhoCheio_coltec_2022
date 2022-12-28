/* @File Comanda.java
 * @Author Igor Barroso Almeida
 * @Brief Modelagem de uma comanda generica
 * abstrata para ser herdada de comandas 
 * mais especificas
 * @Date 25/11/2022
*/

package Code;

abstract public class Comanda {
    // Atributos
    protected String[] consumo;
    protected double[] valor;
    protected double valorTotal;

    // Getters
    public double[] getValor() {
        return valor;
    }

    public String[] getConsumo() {
        return consumo;
    }

    // Setters
    public void setValor(double[] valor) {
        this.valor = valor;
    }

    public void setConsumo(String[] consumo) {
        this.consumo = consumo;
    }

    // Métodos

    // Método que adiciona um item aos consumos
    public void addConsumo(String item, double preco) {
        // Se ainda não tem nenhum item, cria juntamente com preços
        if (this.consumo == null && this.valor == null) {
            this.consumo = new String[1];
            this.valor = new double[1];
            this.valorTotal = preco;
        } else {
            String[] aux = new String[this.consumo.length + 1];
            double[] aux2 = new double[this.valor.length + 1];

            // Copia os componentes já existentes para o aux e aux2
            for (int i = 0; i < this.consumo.length; i++) {
                aux[i] = this.consumo[i];
                aux2[i] = this.valor[i];
            }

            this.consumo = aux;
            this.valor = aux2;
            this.valorTotal += preco;
        }

        // Novo consumo e preço é adicionado
        this.consumo[this.consumo.length - 1] = item;
        this.valor[this.valor.length - 1] = preco;
    }

    // Método abstrato de listagem do consumo e preço
    abstract public double listarConsumo();

    // Retorna os 10% adicionais
    public double calcular10porcento() {
        return this.valorTotal * (10 / 100);
    }

    // Divide a conta
    public double dividirConta(int nPessoas, double valor) {
        return valor / nPessoas;
    }
}
