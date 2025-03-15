package validadores;

public class ValidadorEmail {

    public boolean isValidEmail(String email) {
        return email != null && email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    public static void main(String[] args) {
        ValidadorEmail validador = new ValidadorEmail();
        String email = "exemplo@dominio.com";
        
        if (validador.isValidEmail(email)) {
            System.out.println("E-mail válido.");
        } else {
            System.out.println("E-mail inválido.");
        }
    }
}
