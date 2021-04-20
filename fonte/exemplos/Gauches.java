import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Gauches {
public static void main(String[] args) {
  try {
      //Abre e le o arquivo e armazena em um array:
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
      // O Array frases[] tem cada palavra do arquivo:
      String palavra = "";
      String frases[] = new String[2000];
      String frasesCertas[][] = new String[2000][2000];
      for(int i = 0; i < arrayFrases.length; i++){
        palavra = arrayFrases[i];
        frases = palavra.split(" ");
       for (int j = 0; j < frases.length; j++){
            frasesCertas[i][j] = frases[j];
       }
      }

      //Cada array foi criado para um tipo de variavel:
      ArrayList<String> memoriaTodo = new ArrayList<String>();
      ArrayList<String> memoriaQuebrado = new ArrayList<String>();
      ArrayList<String> memoriaJaguarice = new ArrayList<String>();
      ArrayList<String> memoriaGarrancho = new ArrayList<String>();
      
      //I == linha || J == palavra
      for(int i = 0; i < frasesCertas.length; i++){
          for(int j = 0; j < frasesCertas.length; j++){
            //Recebe cada palavra do arquivo
            palavra = frasesCertas[i][j];
            if (palavra != null){
              //Faz a verificação se a palavra é uma variavel e armazena no array indicado:
              switch(palavra) {
                case "Todo":
                  String varT = frasesCertas[i][j+1];
                  String valorT = frasesCertas[i][j+3];
                  memoriaTodo.add(varT);
                  memoriaTodo.add(valorT);
                  break;
                case "Quebrado":
                  String varQ = frasesCertas[i][j+1];
                  String valorQ = frasesCertas[i][j+3];
                  memoriaQuebrado.add(varQ);
                  memoriaQuebrado.add(valorQ);
                  break;
                case "Jaguarice":
                  String varJ = frasesCertas[i][j+1];
                  String valorJ = frasesCertas[i][j+3];
                  memoriaJaguarice.add(varJ);
                  memoriaJaguarice.add(valorJ);
                  break;
                case "Garrancho":
                  String varG = frasesCertas[i][j+1];
                  String valorG = frasesCertas[i][j+3];
                  memoriaGarrancho.add(varG);
                  memoriaGarrancho.add(valorG);
                  break;
                default:
                  break;
              }
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
