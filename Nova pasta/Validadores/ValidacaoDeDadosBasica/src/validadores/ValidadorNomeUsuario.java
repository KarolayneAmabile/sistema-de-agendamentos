package validadores;
public class ValidadorNomeUsuario {

    // Valida se o nome de usu�rio n�o est� vazio e n�o cont�m espa�os em branco
    public boolean isValidNome(String nome) {
        return nome != null && !nome.trim().isEmpty() && !nome.contains(" ");
    }

    // Valida se o nome de usu�rio possui um tamanho m�nimo e m�ximo
    public boolean isValidTamanho(String nome, int minLength, int maxLength) {
        return nome.length() >= minLength && nome.length() <= maxLength;
    }

    // Valida se o nome de usu�rio cont�m apenas caracteres alfanum�ricos
    public boolean isValidAlfanumerico(String nome) {
        return nome.matches("[a-zA-Z0-9]+");
    }

    // M�todo principal para validar nome de usu�rio
    public boolean validarNomeUsuario(String nome) {
        return isValidNome(nome) && 
               isValidTamanho(nome, 3, 15) && 
               isValidAlfanumerico(nome);
    }

    public static void main(String[] args) {
        ValidadorNomeUsuario validador = new ValidadorNomeUsuario();
        String nome = "Usuario123";
        
        if (validador.validarNomeUsuario(nome)) {
            System.out.println("Nome de usu�rio v�lido.");
        } else {
            System.out.println("Nome de usu�rio inv�lido.");
        }
    }
}
