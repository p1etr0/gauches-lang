public class Sintaxe {
    
    public static void armazenaVetor(String var, int valor){
        String memoria[][] = new String[11][11];
        for (int i = 0; i < memoria.length; i++){
            for(int j = 0; j <= i ; j++){
                j = i;
                String valorTrans = Integer.toString(valor);
                memoria[i][j] = var;
                memoria[i][j+1] = valorTrans;
                System.out.println("Variavel " + memoria[0][0] + " " + "Valor " + memoria[0][1]);
            }
        }
    }    
}
