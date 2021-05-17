import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Gauches {
  public static void main(String[] args) {
    String[] Operadores = {"=", "!=",">","<",">=","<="};
    final List<String> list = Arrays.asList(Operadores);
    String[] OperadoresMath = {"+","-","*","/"};
    final List<String> listMath = Arrays.asList(OperadoresMath);
  
    ArquivoController arquivo = new ArquivoController();
    
    arquivo.leArquivo();

    //Cada array foi criado para um tipo de variavel:
    ArrayList<String> memoriaTodo = new ArrayList<String>();
    ArrayList<String> memoriaQuebrado = new ArrayList<String>();
    ArrayList<String> memoriaJaguarice = new ArrayList<String>();
    ArrayList<String> memoriaGarrancho = new ArrayList<String>();
    ArrayList<String> memoriaCalcule = new ArrayList<String>();
    ArrayList<Integer> pilhaWhile = new ArrayList<Integer>();
    ArrayList<String> pilhaPar1 = new ArrayList<String>();
    ArrayList<String> pilhaPar2 = new ArrayList<String>();
    ArrayList<String> pilhaPar3 = new ArrayList<String>();
    boolean leituraFor = true;
    boolean leitura = true;
    Integer Pare = 0;
    
    //I == linha || J == palavra
    for(int i = 0; i < arquivo.frasesCertas.length; i++){
      String novaLinha = ";";
      for(int j = 0; j < arquivo.frasesCertas.length; j++){
        arquivo.palavra = arquivo.frasesCertas[i][j];//Recebe cada palavra do arquivo

        if (arquivo.palavra != null){
          if(leituraFor == false){
            if(arquivo.palavra.equals("EndAprochegue")){
              leituraFor = true;
            }else{
              continue;
            }
          }     
           
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
             

          if(memoriaTodo.contains(arquivo.palavra) && novaLinha.equals(";")){
            if(arquivo.frasesCertas[i][j+3] == null){
              int index = memoriaTodo.indexOf(arquivo.palavra);
              memoriaTodo.set(index+1, arquivo.frasesCertas[i][j+2]);
              
            }else if(listMath.contains(arquivo.frasesCertas[i][j+3])){
              int index = memoriaTodo.indexOf(arquivo.palavra);   
              String primeiroPar = arquivo.frasesCertas[i][j+2];
              String segundoPar = arquivo.frasesCertas[i][j+4];
              //System.out.println(primeiroPar);
             // System.out.println(segundoPar);

              if(memoriaTodo.contains(arquivo.frasesCertas[i][j+2])){
                int valor = memoriaTodo.indexOf(arquivo.frasesCertas[i][j+2]);
                primeiroPar = memoriaTodo.get(valor+1);  
              }if(memoriaQuebrado.contains(arquivo.frasesCertas[i][j+2])){
                int valor = memoriaQuebrado.indexOf(arquivo.frasesCertas[i][j+2]);
                primeiroPar = memoriaQuebrado.get(valor+1);
              }if(memoriaJaguarice.contains(arquivo.frasesCertas[i][j+2])){
                System.out.println("INT com Boolean");
                System.exit(1);
              }if(memoriaGarrancho.contains(arquivo.frasesCertas[i][j+2])){
                System.out.println("INT com STRING");
                System.exit(1);
              }

              if(memoriaTodo.contains(arquivo.frasesCertas[i][j+4])){
                int valor = memoriaTodo.indexOf(arquivo.frasesCertas[i][j+4]);
                segundoPar = memoriaTodo.get(valor+1);  
              }if(memoriaQuebrado.contains(arquivo.frasesCertas[i][j+4])){
                int valor = memoriaQuebrado.indexOf(arquivo.frasesCertas[i][j+4]);
                segundoPar = memoriaQuebrado.get(valor+1);
              }if(memoriaJaguarice.contains(arquivo.frasesCertas[i][j+4])){
                System.out.println("INT com Boolean");
                System.exit(1);
              }if(memoriaGarrancho.contains(arquivo.frasesCertas[i][j+4])){
                System.out.println("INT com STRING");
                System.exit(1);
              }

              String retorno = Integer.toString(Sintaxe.CalculeInteiro(arquivo.frasesCertas[i][j+3],primeiroPar,segundoPar));
              memoriaTodo.set(index+1, retorno);
            }else{
              System.out.println("Operador invalido");
            }
          }

          if(memoriaQuebrado.contains(arquivo.palavra) && novaLinha.equals(";")){
            if(arquivo.frasesCertas[i][j+3] == null){
              int index = memoriaQuebrado.indexOf(arquivo.palavra);
              memoriaQuebrado.set(index+1, arquivo.frasesCertas[i][j+2]);
            }else if(listMath.contains(arquivo.frasesCertas[i][j+3])){
              int index = memoriaQuebrado.indexOf(arquivo.palavra);
              String retorno = Double.toString(Sintaxe.CalculeDouble(arquivo.frasesCertas[i][j+3], arquivo.frasesCertas[i][j+2], arquivo.frasesCertas[i][j+4]));
              
              memoriaQuebrado.set(index+1, retorno);
            }
          }

          if(memoriaJaguarice.contains(arquivo.palavra) && novaLinha.equals(";")){     
            int index = memoriaJaguarice.indexOf(arquivo.palavra);
            memoriaJaguarice.set(index+1, arquivo.frasesCertas[i][j+2]);
          }
          if(memoriaGarrancho.contains(arquivo.palavra) && novaLinha.equals(";")){
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
                String valorT = "0";
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
                String valorQ = "0";
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
                String valorJ = "0";
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
                String valorG = "0";
                memoriaGarrancho.add(valorG);
              }
              else if(arquivo.frasesCertas[i][j+2].equals("=")){
                String valorG = arquivo.frasesCertas[i][j+3];
                memoriaGarrancho.add(valorG);
              }

            break;

            case "Amostre":
              String print = ""; 
              String var = "";
              if (arquivo.frasesCertas[i][j+1].equals("'")){
                for (int cont = 2; !arquivo.frasesCertas[i][j+cont].equals("'"); cont++){
                  if(arquivo.frasesCertas[i][j+cont] != null){

                    String teste = arquivo.frasesCertas[i][j+cont];
                    int tamanhoString = teste.length();
                    for(int tamanho = 0 ; tamanho < tamanhoString ; tamanho++ ){
                      if (teste.charAt(tamanho) == '{'){
                        for(int tamanho2 = tamanho+1; tamanho2 < tamanhoString; tamanho2++){
                          if(teste.charAt(tamanho2) == '}') {
                            continue;
                          }
                          var +=  teste.charAt(tamanho2);
                        }
                      }
                    }
                    if(var.length() > 0 ){
                        //Pegamos a posição da variavel dentro do array e printamos o seu lado que esta do lado:
                      if(memoriaTodo.contains(var)){
                        int index = memoriaTodo.indexOf(var);
                        String valor = memoriaTodo.get(index+1);
                        print += valor + " ";
                      }
                      if(memoriaQuebrado.contains(var)){
                        int index = memoriaQuebrado.indexOf(var);
                        String valor = memoriaQuebrado.get(index+1);
                        print += valor + " ";
                      }
                      if(memoriaJaguarice.contains(var)){
                        int index = memoriaJaguarice.indexOf(var);
                        String valor = memoriaJaguarice.get(index+1);
                        print += valor + " ";
                      }
                      if(memoriaGarrancho.contains(var)){
                        int index = memoriaGarrancho.indexOf(var);
                        String valor = memoriaGarrancho.get(index+1);
                        print += valor + " ";
                      }
                      if(memoriaCalcule.contains(var)){
                        int index = memoriaCalcule.indexOf(var);
                        String valor = memoriaCalcule.get(index+1);
                        print += valor + " ";
                      }
                      var = "";
                      continue;
                    }
                    print += arquivo.frasesCertas[i][j+cont] + " " ;
                  }
                }
              }  
              Sintaxe.amostre(print);
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

              //verifica o valor do primeiro parametro em memoria caso exista
              if(memoriaTodo.contains(primeiroPar)){
                int index = memoriaTodo.indexOf(primeiroPar);
                String valor = memoriaTodo.get(index+1);
                primeiroPar = valor;
              }

              if(memoriaQuebrado.contains(primeiroPar)){
                int index = memoriaQuebrado.indexOf(primeiroPar);
                String valor = memoriaQuebrado.get(index+1);
                primeiroPar = valor;
              }

              if(memoriaJaguarice.contains(primeiroPar)){
                int index = memoriaJaguarice.indexOf(primeiroPar);
                String valor = memoriaJaguarice.get(index+1);
                primeiroPar = valor ;
              }

              if(memoriaGarrancho.contains(primeiroPar)){
                int index = memoriaGarrancho.indexOf(primeiroPar);
                String valor = memoriaGarrancho.get(index+1);
                primeiroPar = valor;
              }

              if(memoriaCalcule.contains(primeiroPar)){
                int index = memoriaCalcule.indexOf(primeiroPar);
                String valor = memoriaCalcule.get(index+1);
                primeiroPar = valor;
              }

              //verifica o valor do segundo parametro em memoria caso exista
              if(memoriaTodo.contains(segundoPar)){
                int index = memoriaTodo.indexOf(segundoPar);
                String valor = memoriaTodo.get(index+1);
                segundoPar = valor;
              }

              if(memoriaQuebrado.contains(segundoPar)){
                int index = memoriaQuebrado.indexOf(segundoPar);
                String valor = memoriaQuebrado.get(index+1);
                segundoPar = valor;
              }

              if(memoriaJaguarice.contains(segundoPar)){
                int index = memoriaJaguarice.indexOf(segundoPar);
                String valor = memoriaJaguarice.get(index+1);
                segundoPar = valor ;
              }

              if(memoriaGarrancho.contains(segundoPar)){
                int index = memoriaGarrancho.indexOf(segundoPar);
                String valor = memoriaGarrancho.get(index+1);
                segundoPar = valor;
              }
              if(memoriaCalcule.contains(segundoPar)){
                int index = memoriaCalcule.indexOf(segundoPar);
                String valor = memoriaCalcule.get(index+1);
                segundoPar = valor;
              }

              leitura = Sintaxe.Bah(segundoPar, primeiroPar, operadorIf);

            break;

            case "Aprochegue":
              pilhaPar1.clear();
              pilhaPar2.clear();
              pilhaPar3.clear();
              pilhaWhile.clear();
              pilhaWhile.add(i); 
              primeiroPar = arquivo.frasesCertas[i][j+1];
              operadorIf = arquivo.frasesCertas[i][j+2];
              segundoPar = arquivo.frasesCertas[i][j+3];
              pilhaPar2.add(operadorIf);

              if(memoriaTodo.contains(primeiroPar)){
                int index = memoriaTodo.indexOf(primeiroPar);
                String valor = memoriaTodo.get(index+1);
                pilhaPar1.add(valor);
              }else if(memoriaQuebrado.contains(primeiroPar)){
                int index = memoriaQuebrado.indexOf(primeiroPar);
                String valor = memoriaQuebrado.get(index+1);
                pilhaPar1.add(valor);
              }else if(memoriaJaguarice.contains(primeiroPar)){
                  System.out.println("Invalido");
                  System.exit(1);
              }else if(memoriaGarrancho.contains(primeiroPar)){
                  System.out.println("Invalido");
                  System.exit(1);
              }else{
                  pilhaPar1.add(primeiroPar);
              }

              if(memoriaTodo.contains(segundoPar)){
                int index = memoriaTodo.indexOf(segundoPar);
                String valor = memoriaTodo.get(index+1);
                pilhaPar3.add(valor);
              }else if(memoriaQuebrado.contains(segundoPar)){
                int index = memoriaQuebrado.indexOf(segundoPar);
                String valor = memoriaQuebrado.get(index+1);
                pilhaPar3.add(valor);
              }else if(memoriaJaguarice.contains(segundoPar)){
                System.out.println("Invalido");
                System.exit(1);
              }else if(memoriaGarrancho.contains(segundoPar)){
                System.out.println("Invalido");
                System.exit(1);
              }else{
                pilhaPar3.add(segundoPar);
              }
                                      

              Boolean valorFor = Sintaxe.Bah(pilhaPar3.get(pilhaPar3.size()-1),pilhaPar1.get(pilhaPar1.size()-1),pilhaPar2.get(pilhaPar2.size()-1));           
              if(valorFor == false){
                leituraFor = false;
              }else{
                leituraFor = true;
              }
            break;

            case "EndAprochegue":
              valorFor = Sintaxe.Bah(pilhaPar3.get(pilhaPar3.size()-1),pilhaPar1.get(pilhaPar1.size()-1),pilhaPar2.get(pilhaPar2.size()-1));
            
              if(valorFor == true){
                i = (pilhaWhile.get(pilhaWhile.size()-1)-1);
                j = 0;
              }else{
                continue;
              }

               default:
            break;
          }
        }
      }
    }   
  }  
}
