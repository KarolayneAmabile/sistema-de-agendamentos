package validadores;

import java.util.InputMismatchException;

public class ValidadorCPF {

    public boolean isCPF(String CPF) {
        CPF = CPF.replaceAll("[^0-9]", "");

        if (CPF.length() != 11) {
            return false;
        }

        boolean todosDigitosIguais = true;
        char primeiroDigito = CPF.charAt(0);
        for (int i = 1; i < CPF.length(); i++) {
            if (CPF.charAt(i) != primeiroDigito) {
                todosDigitosIguais = false;
                break;
            }
        }
        if (todosDigitosIguais) {
            return false;
        }

        try {
            char digito10 = calcularDigito(CPF, 10);
            char digito11 = calcularDigito(CPF, 11);
            return digito10 == CPF.charAt(9) && digito11 == CPF.charAt(10);
        } catch (InputMismatchException e) {
            return false;
        }
    }

    private char calcularDigito(String CPF, int pesoInicial) throws InputMismatchException {
        int soma = 0;
        int peso = pesoInicial;
        for (int i = 0; i < pesoInicial - 1; i++) {
            int num = (int) (CPF.charAt(i) - '0');
            soma += num * peso--;
        }

        int resto = 11 - (soma % 11);
        if ((resto == 10) || (resto == 11)) {
            return '0';
        } else {
            return (char) (resto + '0');
        }
    }

    public static void main(String[] args) {
        ValidadorCPF validador = new ValidadorCPF();
        String cpf = "123.456.789-09";

        if (validador.isCPF(cpf)) {
            System.out.println("CPF válido.");
        } else {
            System.out.println("CPF inválido.");
        }
    }
}
