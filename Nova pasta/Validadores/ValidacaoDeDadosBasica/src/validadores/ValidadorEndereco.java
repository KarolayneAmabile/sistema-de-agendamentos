package validadores;

public class ValidadorEndereco {

    public boolean isValidEndereco(String rua, String numero, String cidade, String cep) {
        return isValidRua(rua) && isValidNumero(numero) && isValidCidade(cidade) && isValidCEP(cep);
    }

    public boolean isValidRua(String rua) {
        return rua != null && !rua.trim().isEmpty();
    }

    public boolean isValidNumero(String numero) {
        return numero != null && !numero.trim().isEmpty();
    }

    public boolean isValidCidade(String cidade) {
        return cidade != null && !cidade.trim().isEmpty();
    }

    public boolean isValidCEP(String cep) {
        return cep != null && cep.matches("\\d{5}-\\d{3}");
    }

    public static void main(String[] args) {
        ValidadorEndereco validador = new ValidadorEndereco();
        String rua = "Rua Exemplo";
        String numero = "123";
        String cidade = "Cidade Exemplo";
        String cep = "12345-678";

        if (validador.isValidEndereco(rua, numero, cidade, cep)) {
            System.out.println("Endereço válido.");
        } else {
            System.out.println("Endereço inválido.");
        }
    }
}
