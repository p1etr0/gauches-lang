public class Sintaxe {
  
  
    public static int CalculeInteiro(String operador, String primeiro, String segundo){
        int a = Integer.parseInt(primeiro);
        int b = Integer.parseInt(segundo);
        if (operador.equals("+")){
            int soma = 0;
            soma = a + b;
            return soma;
        }
        if (operador.equals("-")){
            int subtracao = 0;
            subtracao = a - b;
            return subtracao;
        }
        if (operador.equals("/")){
            int divisao = 0;
            divisao = a / b;
            return divisao;
        }
        if (operador.equals("*")){
            int multiplicacao = 0;
            multiplicacao = a * b;
            return multiplicacao;
        }
        b = 0;
        return b;
        }
    
    public static double CalculeDouble(String operador, String primeiro, String segundo){
        double a = Double.parseDouble(primeiro);
        double b = Double.parseDouble(segundo);
            if (operador.equals("+")){
                double soma = 0.0;
                soma = a + b;
                return soma;
            }
            if (operador.equals("-")){
                double subtracao = 0.0;
                subtracao = a - b;
                return subtracao;
            }
            if (operador.equals("/")){
                double divisao = 0.0;
                divisao = a / b;
                return divisao;
            }
            if (operador.equals("*")){
                double multiplicacao = 0.0;
                multiplicacao = a * b;
                return multiplicacao;
            }
            b = 0;
            return b;
        }

        public static Boolean Bah(String segundoPar, String primeiroPar, String operadorIf){
            switch(operadorIf){
                case "=":
                  if(primeiroPar.equals(segundoPar) == true){
                    return true;
                  }else{
                    return false;
                  }
                case "!=":
                  if(primeiroPar.equals(segundoPar) == false){
                        return true;
                  }else {
                        return false;
                  }  
                case ">":
                  try {
                    Integer first = Integer.parseInt(primeiroPar);
                    Integer second = Integer.parseInt(segundoPar);
                    if(first > second ){
                        return true;
                      
                    }else {
                        return false;
                      
                    }
                  } catch (Exception e) {
                    System.out.println(e);
                    System.exit(0);
                  }
                case "<":
                    try {
                      Integer first = Integer.parseInt(primeiroPar);
                      Integer second = Integer.parseInt(segundoPar);
                      if(first < second ){
                        return true;
                       
                      }else {
                        return false;
                     
                      }
                    } catch (Exception e) {
                      System.out.println(e);
                      System.exit(0);
                    }
                case "<=":
                try {
                      Integer first = Integer.parseInt(primeiroPar);
                      Integer second = Integer.parseInt(segundoPar);
                      if(first <= second ){
                        return true;
                        
                      }else {
                        return false;
                        
                      }
                    } catch (Exception e) {
                      System.out.println(e);
                      System.exit(0);
                    }
                case ">=":
                try {
                      Integer first = Integer.parseInt(primeiroPar);
                      Integer second = Integer.parseInt(segundoPar);
                      if(first >= second ){
                        return true;
                        
                      }else {
                        return false;
                        
                      }
                    } catch (Exception e) {
                      System.out.println(e);
                      System.exit(0);
                    }
              }
              return false;
        }

        public static void amostre(String valor){
            System.out.println(valor);
        }        
               
    }
    

