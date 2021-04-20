public class Sintaxe {
    //ainda não esta sendo utilizado pra nada (NÃO FUNCIONA)
    public static void armazenaVetor(String var, String valor){
        String memoria[][] = new String[11][11];
        for (int i = 0; i < memoria.length; i++){
            int parametro=0;
            for(int j = 0; parametro <= i; j++){
                memoria[i][j] = var;
                memoria[i][j+1] = valor;
                System.out.println("Variavel " + memoria[i][j] + " " + "Valor " + memoria[i][j+1]);
                parametro = i+1;
            }
        } 
    }    


    public static void CalculeInteiro(String operador, String primeiro, String segundo){
        int a = Integer.parseInt(primeiro);
        int b = Integer.parseInt(segundo);
            if (operador == "+"){
                int soma = 0;
                soma = a + b;
            }
            if (operador == "-"){
                int subtracao = 0;
                subtracao = a - b;
            }
            if (operador == "/"){
                int divisao = 0;
                divisao = a / b;
            }
            if (operador == "*"){
                int multiplicacao = 0;
                multiplicacao = a * b;
            }
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
    }
    

