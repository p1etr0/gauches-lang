public class Sintaxe {
    
    public static void armazenaVetor(String var, String valor){
        String memoria[][] = new String[11][11];
        for (int i = 0; i < memoria.length; i++){
            for(int j = 0; j <= i ; j++){
                j = i;
                memoria[i][j] = var;
                memoria[i][j+1] = valor;
                System.out.println("Variavel " + memoria[0][0] + " " + "Valor " + memoria[0][1]);
            }
        }
    }    
}
