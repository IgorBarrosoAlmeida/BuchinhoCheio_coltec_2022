/* @File ComandaBebida.java
 * @Author Igor Barroso Almeida
 * @Brief Modelagem de uma comanda
 * especifica para bebidas
 * @Date 25/11/2022
*/

package Code;

import java.util.Scanner;

public class ComandaBebida extends Comanda { // Atributos
    private double volumeLitro = 0;

    @Override
    public void addConsumo(String item, double preco) {
        Scanner read = new Scanner(System.in);
        double ml;

        System.out.println("Digite a quantidade em litros do item: ");
        ml = read.nextDouble();

        this.volumeLitro += ml;
        super.addConsumo(item, preco);
    }

    @Override
    public double listarConsumo() {
        if (this.consumo != null) {
            System.out.println("-- COMANDA DE BEBIDAS --");
            for (int i = 0; i < this.consumo.length; i++) {
                System.out.println("    - " + this.consumo[i] + " ~ R$" + this.valor[i]);
            }

            System.out.println("Preço bebida: R$" + this.valorTotal);
            System.out.println("Volume total em litros: " + this.volumeLitro + "L");
            return this.valorTotal;
        } else {
            System.out.println("Bebidas não foram consumidas");
            return 0;
        }

    }
}
