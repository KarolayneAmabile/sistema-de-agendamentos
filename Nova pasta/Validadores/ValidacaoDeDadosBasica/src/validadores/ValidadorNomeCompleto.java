package validadores;

public class ValidadorNomeCompleto {

    public boolean isValidNome(String nome) {
        return nome != null && !nome.trim().isEmpty() && nome.matches("[a-zA-Z ]+");
    }

    public boolean isValidTamanho(String nome, int maxLength) {
        return nome.length() <= maxLength;
    }

    public static void main(String[] args) {
        ValidadorNomeCompleto validador = new ValidadorNomeCompleto();
        String nome = "João Silva";
        
        if (validador.isValidNome(nome) && validador.isValidTamanho(nome, 100)) {
            System.out.println("Nome válido.");
        } else {
            System.out.println("Nome inválido.");
        }
    }
}
