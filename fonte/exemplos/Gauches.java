import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Gauches {
public static void main(String[] args) {
    String[] Operadores = {"=", "!=",">","<",">=","<="};
    final List<String> list = Arrays.asList(Operadores);
  
    ArquivoController arquivo = new ArquivoController();
    
    arquivo.leArquivo();

    //Cada array foi criado para um tipo de variavel:
    ArrayList<String> memoriaTodo = new ArrayList<String>();
    ArrayList<String> memoriaQuebrado = new ArrayList<String>();
    ArrayList<String> memoriaJaguarice = new ArrayList<String>();
    ArrayList<String> memoriaGarrancho = new ArrayList<String>();
    ArrayList<String> memoriaCalcule = new ArrayList<String>();

    boolean leitura = true;
    Integer Pare = 0;
    
    //I == linha || J == palavra
    for(int i = 0; i < arquivo.frasesCertas.length; i++){
        String novaLinha = ";";
        for(int j = 0; j < arquivo.frasesCertas.length; j++){
          arquivo.palavra = arquivo.frasesCertas[i][j];//Recebe cada palavra do arquivo
          
          if (arquivo.palavra != null){
            if(leitura == false){

                if(arquivo.palavra.equals("Bah")){
                    Pare++;
                }
                if(arquivo.palavra.equals("Pare")){
                    Pare--;
                }

                if(Pare == -1){
                    leitura = true;
                }
                continue;
              }
          //Verifica se a variavel já existe e se ja existir coloca o valor indicado:
          boolean existeTodo = memoriaTodo.contains(arquivo.palavra);
          boolean existeQuebrado = memoriaQuebrado.contains(arquivo.palavra);
          boolean existeJaguarice = memoriaJaguarice.contains(arquivo.palavra);
          boolean existeGarrancho = memoriaGarrancho.contains(arquivo.palavra);
          if(existeTodo == true && novaLinha.equals(";")){
            int index = memoriaTodo.indexOf(arquivo.palavra);
            memoriaTodo.set(index+1, arquivo.frasesCertas[i][j+2]);
          }
          if(existeQuebrado == true && novaLinha.equals(";")){
            int index = memoriaQuebrado.indexOf(arquivo.palavra);
            memoriaQuebrado.set(index+1, arquivo.frasesCertas[i][j+2]);
          }
          if(existeJaguarice == true && novaLinha.equals(";")){
            int index = memoriaJaguarice.indexOf(arquivo.palavra);
            memoriaJaguarice.set(index+1, arquivo.frasesCertas[i][j+2]);
          }
          if(existeGarrancho == true && novaLinha.equals(";")){
            int index = memoriaGarrancho.indexOf(arquivo.palavra);
            memoriaGarrancho.set(index+1, arquivo.frasesCertas[i][j+2]);
          }
          novaLinha = "";

          
          //Faz a verificação se a palavra é uma variavel e armazena no array indicado com seu valor ao lado:
          switch(arquivo.palavra) {
            case "Todo":
              String varT = arquivo.frasesCertas[i][j+1];
              memoriaTodo.add(varT);

              if(arquivo.frasesCertas[i][j+2] == null){
                String valorT = "indefinido";
                memoriaTodo.add(valorT);
              }
              else if(arquivo.frasesCertas[i][j+2].equals("=")){
                String valorT = arquivo.frasesCertas[i][j+3];
                memoriaTodo.add(valorT);
              }
            break;
            case "Quebrado":
              String varQ = arquivo.frasesCertas[i][j+1];
              memoriaQuebrado.add(varQ);
              if(arquivo.frasesCertas[i][j+2] == null){
                String valorQ = "indefinido";
                memoriaQuebrado.add(valorQ);
              }
              else if(arquivo.frasesCertas[i][j+2].equals("=")){
                String valorQ = arquivo.frasesCertas[i][j+3];
                memoriaQuebrado.add(valorQ);
              }
              break;

            case "Jaguarice":
              String varJ = arquivo.frasesCertas[i][j+1];
              memoriaJaguarice.add(varJ);
              if(arquivo.frasesCertas[i][j+2] == null){
                String valorJ = "indefinido";
                memoriaJaguarice.add(valorJ);
              }
              else if(arquivo.frasesCertas[i][j+2].equals("=")){
                String valorJ = arquivo.frasesCertas[i][j+3];
                memoriaJaguarice.add(valorJ);
              }
              break;
            case "Garrancho":
              String varG = arquivo.frasesCertas[i][j+1];
              memoriaGarrancho.add(varG);
              if(arquivo.frasesCertas[i][j+2] == null){
                String valorG = "indefinido";
                memoriaGarrancho.add(valorG);
              }
              else if(arquivo.frasesCertas[i][j+2].equals("=")){
                String valorG = arquivo.frasesCertas[i][j+3];
                memoriaGarrancho.add(valorG);
              }
              break;
            case "Amostre":
            String print = "";
              if (arquivo.frasesCertas[i][j+1].equals("'")){
                for (int cont = 2; !arquivo.frasesCertas[i][j+cont].equals("'"); cont++){
                  if(arquivo.frasesCertas[i][j+cont] != null){
                  print = print + arquivo.frasesCertas[i][j+cont] + " " ;
                  }
                }
                System.out.println(print);
              } 
              //Verificamos se a varivel existe em alguma das memorias:
              boolean valorTodo = memoriaTodo.contains(arquivo.frasesCertas[i][j+1]);
              boolean valorQuebrado = memoriaQuebrado.contains(arquivo.frasesCertas[i][j+1]);
              boolean valorJaguarice = memoriaJaguarice.contains(arquivo.frasesCertas[i][j+1]);
              boolean valorGarrancho = memoriaGarrancho.contains(arquivo.frasesCertas[i][j+1]);
              boolean valorCalcule = memoriaCalcule.contains(arquivo.frasesCertas[i][j+1]);

              //Pegamos a posição da variavel dentro do array e printamos o seu lado que esta do lado:
              if(valorTodo == true){
                int index = memoriaTodo.indexOf(arquivo.frasesCertas[i][j+1]);
                String valor = memoriaTodo.get(index+1);
                Sintaxe.amostre(valor);
              }
              if(valorQuebrado == true){
                int index = memoriaQuebrado.indexOf(arquivo.frasesCertas[i][j+1]);
                String valor = memoriaQuebrado.get(index+1);
                Sintaxe.amostre(valor);
              }
              if(valorJaguarice == true){
                int index = memoriaJaguarice.indexOf(arquivo.frasesCertas[i][j+1]);
                String valor = memoriaJaguarice.get(index+1);
                Sintaxe.amostre(valor);
              }
              if(valorGarrancho == true){
                int index = memoriaGarrancho.indexOf(arquivo.frasesCertas[i][j+1]);
                String valor = memoriaGarrancho.get(index+1);
                Sintaxe.amostre(valor);
              }
              if(valorCalcule == true){
                int index = memoriaCalcule.indexOf(arquivo.frasesCertas[i][j+1]);
                String valor = memoriaCalcule.get(index+1);
                Sintaxe.amostre(valor);
              }
            break;
            case "Calcule":
              String variavel = arquivo.frasesCertas[i][j+1];
              String primeiro = arquivo.frasesCertas[i][j+3];
              String operador = arquivo.frasesCertas[i][j+4];
              String segundo = arquivo.frasesCertas[i][j+5];
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
            case "Bah":
                  
                  String primeiroPar = arquivo.frasesCertas[i][j+1];
                  String operadorIf = arquivo.frasesCertas[i][j+2];
                  String segundoPar = arquivo.frasesCertas[i][j+3];
                   
                  if(list.contains(operadorIf) == false){
                    System.out.println("Operador invalido");
                    System.exit(22);
                  }

                  leitura = Sintaxe.Bah(segundoPar, primeiroPar, operadorIf);

                  break;
              default:
                break;
            }

          }
        }
    }  
  }  
}
