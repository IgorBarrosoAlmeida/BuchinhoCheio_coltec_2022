/* @File Cliente.java
 * @Author Igor Barroso Almeida
 * @Brief Modelagem de um cliente
 * a classe contem os dados do cliente
 * @Date 25/11/2022
*/

package Code;

public class Cliente {
    // Atributos
    private String nome;
    private String email;

    // Getters
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}