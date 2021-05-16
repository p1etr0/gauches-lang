
import java.io.FileReader;
import java.util.Scanner;

public class ArquivoController{

    String[] linhas = new String[2000];
    int contador = 0;
    String linha = "";
    String arrayFrases[] = new String[2000];
    String palavra = "";
    String frases[] = new String[2000];
    String frasesCertas[][] = new String[2000][2000];

    public void leArquivo(){
        try {
            //Abre e le o arquivo e armazena em um array:
            Scanner entrada = new Scanner(new FileReader("teste.txt"));
            while (entrada.hasNextLine()) {
                String line = entrada.nextLine();
                this.linhas[contador++] = line;
            }
            
            entrada.close();

            //Jutando o arquivo em uma linha: 

            for (int i = 0; i < linhas.length ; i++){
                if(linhas[i] != null){
                    this.linha = this.linha.concat(linhas[i]);  
                }
            }

            // Dividindo o arquivo em um array quebrando no (;):

            for(int i = 0; i < this.arrayFrases.length; i++){
                this.arrayFrases = this.linha.split(";");
            }

            // Dividindo o arquivo em um array quebrando no (" "):
            // O Array frases[] tem cada palavra do arquivo:

            for(int i = 0; i < arrayFrases.length; i++){
                this.palavra = this.arrayFrases[i];
                this.frases = this.palavra.split(" ");
                for (int j = 0; j < this.frases.length; j++){
                    this.frasesCertas[i][j] = this.frases[j];
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