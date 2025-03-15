package validadores;
public class ValidadorNomeUsuario {

    // Valida se o nome de usuário não está vazio e não contém espaços em branco
    public boolean isValidNome(String nome) {
        return nome != null && !nome.trim().isEmpty() && !nome.contains(" ");
    }

    // Valida se o nome de usuário possui um tamanho mínimo e máximo
    public boolean isValidTamanho(String nome, int minLength, int maxLength) {
        return nome.length() >= minLength && nome.length() <= maxLength;
    }

    // Valida se o nome de usuário contém apenas caracteres alfanuméricos
    public boolean isValidAlfanumerico(String nome) {
        return nome.matches("[a-zA-Z0-9]+");
    }

    // Método principal para validar nome de usuário
    public boolean validarNomeUsuario(String nome) {
        return isValidNome(nome) && 
               isValidTamanho(nome, 3, 15) && 
               isValidAlfanumerico(nome);
    }

    public static void main(String[] args) {
        ValidadorNomeUsuario validador = new ValidadorNomeUsuario();
        String nome = "Usuario123";
        
        if (validador.validarNomeUsuario(nome)) {
            System.out.println("Nome de usuário válido.");
        } else {
            System.out.println("Nome de usuário inválido.");
        }
    }
}
