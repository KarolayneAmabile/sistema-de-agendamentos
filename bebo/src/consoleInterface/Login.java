package consoleInterface;

import java.util.Scanner;

public class Login {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void printLogin(String user, String password) {
        System.out.printf("************************************************************\n");
        System.out.printf("\t\tBEM-VINDO AO BEBO!\n");
        System.out.printf("\tSeu assistente pessoal para salões e barbearias\n");
        System.out.printf("************************************************************\n");
        System.out.printf("Usuário: ");
        user = scanner.nextLine();
        System.out.printf("\nSenha: ");
        password = scanner.nextLine();
	}
}
