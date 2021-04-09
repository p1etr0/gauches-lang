import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class Gauches {
public static void main(String[] args) {
  try {
      String[] linhas = new String[2000];
      int contador = 0;
      
      File file = new File("teste.txt");
      System.out.println("1");
      Scanner entrada = new Scanner(new FileReader("dados.txt"));
      System.out.println("2");

      while (entrada.hasNextLine()) {
          System.out.println("3");
          String line = entrada.nextLine();
          linhas[contador++] = line;
      }

      entrada.close();
      
      for (int i = 0; i < contador; i++) {
          System.out.println("Linha " + i + ": " + linhas[i]);
      }
    } catch (Exception e) {
        System.out.println("Nao foi possivel abrir o arquivo teste.txt");
        System.out.println("Ele existe mesmo?");
        e.printStackTrace();
    }
  }
}
