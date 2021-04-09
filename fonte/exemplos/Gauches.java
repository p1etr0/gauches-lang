import java.io.File;
import java.util.Scanner;


public class Gauches {
public static void main(String[] args) {
    try {
        String[] lines = new String[2000];
        int amount = 0;
        File arquivo = new File("teste.txt");
        Scanner entrada = new Scanner(arquivo);
        
        while (entrada.hasNextLine()) {
            String line = entrada.nextLine();
            lines[amount++] = line;
        }

        entrada.close();
        
        for (int i = 0; i < amount; i++) {
            System.out.println("Linha " + i + ": " + lines[i]);
        }
        } catch (Exception e) {
            System.out.println("Nao foi possivel abrir o arquivo teste.txt");
            System.out.println("Ele existe mesmo?");
            e.printStackTrace();
        }
}
}
