import java.io.File;
import java.io.FileReader;
import java.util.Scanner;


public class Gauches {
public static void main(String[] args) {
  try {
      String[] linhas = new String[2000];
      int contador = 0;
      File file = new File("teste.txt");
      Scanner entrada = new Scanner(new FileReader("teste.txt"));

      while (entrada.hasNextLine()) {
          String line = entrada.nextLine();
          linhas[contador++] = line;
      }

      entrada.close();
      
       //Jutando o arquivo em uma linha: 
      String linha = "";
      for (int i = 0; i < linhas.length ; i++){
          if(linhas[i] != null){
            linha = linha.concat(linhas[i]); 
          }
      }
      
      // Dividindo o arquivo em um array quebrando no (;):
      String arrayFrases[] = new String[3];
      for(int i = 0; i < arrayFrases.length; i++){
        arrayFrases = linha.split(";");
      }
      System.out.println(arrayFrases[0]);

    
    } catch (Exception e) {
        System.out.println("Nao foi possivel abrir o arquivo teste.txt");
        System.out.println("Ele existe mesmo?");
        e.printStackTrace();
    }

  }
}
