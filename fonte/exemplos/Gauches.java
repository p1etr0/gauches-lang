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
      ArrayList<String> memoriaCalcule = new ArrayList<String>();
      
      //I == linha || J == palavra
      for(int i = 0; i < frasesCertas.length; i++){
         String novaLinha = ";";
          for(int j = 0; j < frasesCertas.length; j++){
            
            //Recebe cada palavra do arquivo
            palavra = frasesCertas[i][j];
            
            if (palavra != null){
            //Verifica se a variavel já existe e se ja existir coloca o valor indicado:
            boolean existeTodo = memoriaTodo.contains(palavra);
            boolean existeQuebrado = memoriaQuebrado.contains(palavra);
            boolean existeJaguarice = memoriaJaguarice.contains(palavra);
            boolean existeGarrancho = memoriaGarrancho.contains(palavra);
            if(existeTodo == true && novaLinha.equals(";")){
              int index = memoriaTodo.indexOf(palavra);
              memoriaTodo.set(index+1, frasesCertas[i][j+2]);
            }
            if(existeQuebrado == true && novaLinha.equals(";")){
              int index = memoriaQuebrado.indexOf(palavra);
              memoriaQuebrado.set(index+1, frasesCertas[i][j+2]);
            }
            if(existeJaguarice == true && novaLinha.equals(";")){
              int index = memoriaJaguarice.indexOf(palavra);
              memoriaJaguarice.set(index+1, frasesCertas[i][j+2]);
            }
            if(existeGarrancho == true && novaLinha.equals(";")){
              int index = memoriaGarrancho.indexOf(palavra);
              memoriaGarrancho.set(index+1, frasesCertas[i][j+2]);
            }
            novaLinha = "";

            
            //Faz a verificação se a palavra é uma variavel e armazena no array indicado com seu valor ao lado:
            switch(palavra) {
              case "Todo":
                String varT = frasesCertas[i][j+1];
                memoriaTodo.add(varT);

                if(frasesCertas[i][j+2] == null){
                  String valorT = "indefinido";
                  memoriaTodo.add(valorT);
                }
                else if(frasesCertas[i][j+2].equals("=")){
                  String valorT = frasesCertas[i][j+3];
                  memoriaTodo.add(valorT);
                }
              break;
              case "Quebrado":
                String varQ = frasesCertas[i][j+1];
                memoriaQuebrado.add(varQ);
                if(frasesCertas[i][j+2] == null){
                  String valorQ = "indefinido";
                  memoriaQuebrado.add(valorQ);
                }
                else if(frasesCertas[i][j+2].equals("=")){
                  String valorQ = frasesCertas[i][j+3];
                  memoriaQuebrado.add(valorQ);
                }
                break;

              case "Jaguarice":
                String varJ = frasesCertas[i][j+1];
                memoriaJaguarice.add(varJ);
                if(frasesCertas[i][j+2] == null){
                  String valorJ = "indefinido";
                  memoriaJaguarice.add(valorJ);
                }
                else if(frasesCertas[i][j+2].equals("=")){
                  String valorJ = frasesCertas[i][j+3];
                  memoriaJaguarice.add(valorJ);
                }
                break;
              case "Garrancho":
                String varG = frasesCertas[i][j+1];
                memoriaGarrancho.add(varG);
                if(frasesCertas[i][j+2] == null){
                  String valorG = "indefinido";
                  memoriaGarrancho.add(valorG);
                }
                else if(frasesCertas[i][j+2].equals("=")){
                  String valorG = frasesCertas[i][j+3];
                  memoriaGarrancho.add(valorG);
                }
                break;
              case "Calcule":
                String variavel = frasesCertas[i][j+1];
                String primeiro = frasesCertas[i][j+3];
                String operador = frasesCertas[i][j+4];
                String segundo = frasesCertas[i][j+5];
                String procurarPor = ".";
                
                //verificar se é double ou inteiro
                boolean verificaDouble = primeiro.toLowerCase().contains(procurarPor.toLowerCase());
                boolean verificaDouble2 = segundo.toLowerCase().contains(procurarPor.toLowerCase());

                //Chama a função correta para calcular
                if(verificaDouble == false && verificaDouble2 == false){
                  int retorno = Sintaxe.CalculeInteiro(operador, primeiro, segundo);
                  memoriaCalcule.add(variavel);
                  String retornoAux = String.valueOf( retorno );
                  memoriaCalcule.add(retornoAux);

                }
                else if(verificaDouble == false || verificaDouble2 == false){
                  System.out.println("Não é possivel calcular double com inteiro");
                  System.exit(0);
                }
                else{                 
                  Double retorno = Sintaxe.CalculeDouble(operador, primeiro, segundo);
                  memoriaCalcule.add(variavel);
                  String retornoAux = String.valueOf( retorno );
                  memoriaCalcule.add(retornoAux);
                }
                break;
              default:
                break;
              }

            }
          }
      }
      
      System.out.println(memoriaGarrancho);
      System.out.println(memoriaJaguarice);
      System.out.println(memoriaQuebrado);
      System.out.println(memoriaTodo);
      System.out.println(memoriaCalcule);
      
      
    } 
    catch (Exception e) {
        // System.out.println("Nao foi possivel abrir o arquivo teste.txt");
        // System.out.println("Ele existe mesmo?");
        // e.printStackTrace();
    }
    
  }
}
