package validadores;

public class ValidadorSenha {

    public boolean isValidSenha(String senha) {
        return senha != null && senha.length() >= 8 && senha.matches("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}");
    }

    public boolean isSenhaIgual(String senha, String confirmacaoSenha) {
        return senha.equals(confirmacaoSenha);
    }

    public static void main(String[] args) {
        ValidadorSenha validador = new ValidadorSenha();
        String senha = "Senha@123";
        String confirmacaoSenha = "Senha@123";
        
        if (validador.isValidSenha(senha) && validador.isSenhaIgual(senha, confirmacaoSenha)) {
            System.out.println("Senha válida.");
        } else {
            System.out.println("Senha inválida.");
        }
    }
}
