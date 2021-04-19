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
      String arrayFrases[] = new String[2000];
      for(int i = 0; i < arrayFrases.length; i++){
        arrayFrases = linha.split(";");
      }

      // Dividindo o arquivo em um array quebrando no (" "):
      //o Array frases tem cada palavra do arquivo:
      String palavra = "";
      String frases[] = new String[2000];
      String frasesCertas[][] = new String[2000][2000];
      for(int i = 0; i < 3; i++){
        palavra = arrayFrases[i];
        frases = palavra.split(" ");
       for (int j = 0; j < frases.length; j++){
            frasesCertas[i][j] = frases[j];
       }
      }

      //I == linha // J == palavra
      for(int i = 0; i < frasesCertas.length; i++){
          for(int j = 0; j < frasesCertas.length; j++){
            palavra = frasesCertas[i][j];
            switch(palavra) {
              case "Todo":
              System.out.println("entrei");
              String var = frasesCertas[i][j+1];
              String valor = frasesCertas[i][j+3];
              Sintaxe.armazenaVetor(var,valor);
              System.exit(0);
                break;
              case "Quebrado":
                // code block
                break;
              default:
                System.out.println("Palavra não encontrada na linguagem Gauches (Olhe o Manual.md)");
                break;
            }
          }
      }
      
      



    
    } 
    catch (Exception e) {
        // System.out.println("Nao foi possivel abrir o arquivo teste.txt");
        // System.out.println("Ele existe mesmo?");
        // e.printStackTrace();
    }
    
  }
}
