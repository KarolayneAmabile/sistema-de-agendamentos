package validadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ValidadorDataNascimento {

    public boolean isValidData(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public boolean isMaiorDeIdade(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date = sdf.parse(data);
            long idadeEmMillis = new Date().getTime() - date.getTime();
            long idadeEmAnos = idadeEmMillis / (1000L * 60 * 60 * 24 * 365);
            return idadeEmAnos >= 18;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        ValidadorDataNascimento validador = new ValidadorDataNascimento();
        String dataNascimento = "01/01/2000";

        if (validador.isValidData(dataNascimento) && validador.isMaiorDeIdade(dataNascimento)) {
            System.out.println("Data de nascimento válida.");
        } else {
            System.out.println("Data de nascimento inválida.");
        }
    }
}
