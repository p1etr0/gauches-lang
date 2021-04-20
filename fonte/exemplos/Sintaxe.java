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
}
