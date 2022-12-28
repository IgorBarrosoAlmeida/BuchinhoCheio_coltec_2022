/* @File ComandaComida.java
 * @Author Igor Barroso Almeida
 * @Brief Modelagem de uma comanda
 * especifica para comidas
 * @Date 25/11/2022
*/

package Code;

import java.util.Scanner;

public class ComandaComida extends Comanda {
    // Atributos
    private double pesoKg = 0;

    @Override
    public void addConsumo(String item, double preco) {
        Scanner read = new Scanner(System.in);
        double Kg;

        System.out.println("Digite a quantidade em quilogramas do item: ");
        Kg = read.nextDouble();

        this.pesoKg += Kg;
        super.addConsumo(item, preco);
    }

    @Override
    public double listarConsumo() {
        if (this.consumo != null) {
            System.out.println("-- COMANDA DE COMIDA --");
            for (int i = 0; i < this.consumo.length; i++) {
                System.out.println("    - " + this.consumo[i] + " ~ R$" + this.valor[i]);
            }

            System.out.println("Preço comida: R$" + this.valorTotal);
            System.out.println("Peso total em gramas: " + this.pesoKg + "Kg");
            return this.valorTotal;
        } else {
            System.out.println("Comidas não foram consumidas");
            return 0;
        }
    }
}
