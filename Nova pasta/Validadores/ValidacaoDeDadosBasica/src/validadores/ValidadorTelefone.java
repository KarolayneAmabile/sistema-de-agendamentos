package validadores;

public class ValidadorTelefone {

    public boolean isValidTelefone(String telefone) {
        return telefone != null && telefone.matches("\\(\\d{2}\\) \\d{5}-\\d{4}");
    }

    public static void main(String[] args) {
        ValidadorTelefone validador = new ValidadorTelefone();
        String telefone = "(11) 91234-5678";

        if (validador.isValidTelefone(telefone)) {
            System.out.println("Telefone válido.");
        } else {
            System.out.println("Telefone inválido.");
        }
    }
}
