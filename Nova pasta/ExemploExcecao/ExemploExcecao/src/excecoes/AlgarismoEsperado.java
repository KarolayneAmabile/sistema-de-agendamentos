package excecoes;

public class AlgarismoEsperado extends Exception
{ 
	public AlgarismoEsperado (char c){
		super ("Caractere digitado: " + c + "\n" +
            "Era esperado um algarismo."); 
	}
}