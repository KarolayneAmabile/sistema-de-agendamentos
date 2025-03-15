package validadores;

public class ValidadorGenero {

    public boolean isValidGenero(String genero) {
        return genero != null && (genero.equalsIgnoreCase("Masculino") ||
                genero.equalsIgnoreCase("Feminino") || genero.equalsIgnoreCase("Outro"));
    }

    public static void main(String[] args) {
        ValidadorGenero validador = new ValidadorGenero();
        String genero = "Masculino";

        if (validador.isValidGenero(genero)) {
            System.out.println("G�nero v�lido.");
        } else {
            System.out.println("G�nero inv�lido.");
        }
    }
}
