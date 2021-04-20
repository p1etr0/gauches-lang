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


      //UTILIZAR GET INDEX SE VARIAVEL EXISTIR E COLOCAR O ADD(INDEX, ELEMENT) ADICIONANDO AO LADO DA VARIAVEL
      // memoriaTodo.add(0, "teste");
      // memoriaTodo.add(0, "teste2");
      // memoriaTodo.add(1, "teste3");
      // System.out.println(memoriaTodo);
      // System.exit(0);
      
      //I == linha || J == palavra
      for(int i = 0; i < frasesCertas.length; i++){
          for(int j = 0; j < frasesCertas.length; j++){
            //Recebe cada palavra do arquivo
            palavra = frasesCertas[i][j];
            if (palavra != null){
              boolean existe = memoriaTodo.contains(palavra);
              
              // System.exit(0);

              
              //Faz a verificação se a palavra é uma variavel e armazena no array indicado com seu valor ao lado:
              switch(palavra) {
                case "Todo":
                  String varT = frasesCertas[i][j+1];
                  memoriaTodo.add(varT);
                  if(frasesCertas[i][j+2].equals("=")){
                    String valorT = frasesCertas[i][j+3];
                    memoriaTodo.add(valorT);
                  }
                  break;
                case "Quebrado":
                  String varQ = frasesCertas[i][j+1];
                  memoriaQuebrado.add(varQ);
                  if(frasesCertas[i][j+2].equals("=")){
                    String valorQ = frasesCertas[i][j+3];
                    memoriaQuebrado.add(valorQ);
                  }
                  break;
                case "Jaguarice":
                  String varJ = frasesCertas[i][j+1];
                  memoriaJaguarice.add(varJ);
                  if(frasesCertas[i][j+2].equals("=")){
                    String valorJ = frasesCertas[i][j+3];
                    memoriaJaguarice.add(valorJ);
                  }
                  break;
                case "Garrancho":
                  String varG = frasesCertas[i][j+1];
                  memoriaGarrancho.add(varG);
                  if(frasesCertas[i][j+2].equals("=")){
                    String valorG = frasesCertas[i][j+3];
                    memoriaGarrancho.add(valorG);
                  }
                  break;
                case "Calcule":
                  String operador = frasesCertas[i][j+3];
                  String primeiro = frasesCertas[i][j+2];
                  String segundo = frasesCertas[i][j+4];
                  String procurarPor = ".";
                  
                  //verificar se é double ou inteiro
                  boolean verificaDouble = primeiro.toLowerCase().contains(procurarPor.toLowerCase());
                  boolean verificaDouble2 = segundo.toLowerCase().contains(procurarPor.toLowerCase());

                  //Chama a função correta para calcular
                  if(verificaDouble == false && verificaDouble2 == false){
                    //FALTA SALVAR O RETORNO EM UM ARRAY 
                    int retorno = Sintaxe.CalculeInteiro(operador, primeiro, segundo);
                    //SYSTEMS ABAIXO PARA TESTAR
                    System.out.println(retorno);
                    System.exit(0);
                  }
                  else if(verificaDouble == false || verificaDouble2 == false){
                    System.out.println("Não é possivel calcular double com inteiro");
                    System.exit(0);
                  }
                  else{
                    //FALTA SALVAR O RETORNO EM UM ARRAY
                    Double retorno = Sintaxe.CalculeDouble(operador, primeiro, segundo);
                    //SYSTEMS ABAIXO PARA TESTAR
                    System.out.println(retorno);
                    System.exit(0);
                  }
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
