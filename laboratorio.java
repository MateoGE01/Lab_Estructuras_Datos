import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import javax.imageio.stream.FileCacheImageOutputStream;
import javax.sound.sampled.SourceDataLine;

public class laboratorio {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Por favor digite el nombre del archivo de los clientes");
        String Client = scan.nextLine();
        System.out.println("Por favor digite el nombre del archivo de las facturas");
        String Factura = scan.nextLine();
        System.out.println("Por favor digite el nombre del archivo de las productos");
        String productos = scan.nextLine();
        

            int filas_clientes= tamañox(Client);
            int columnas_clientes = tamañoy(Client);
            int filas_facturas= tamañox(Factura);
            int columnas_facturas = tamañoy(Factura);
            int filas_productos= tamañox(productos);
            int columnas_productos = tamañoy(productos);

            String matriz_clientes[][] = File_to_matriz(filas_clientes, Client, columnas_clientes);
            String matriz_clientes_ordenada[][] = ordenar_matriz(filas_clientes, matriz_clientes, columnas_clientes);
            printmatriz(matriz_clientes_ordenada);
            String matriz_facturas[][] = File_to_matriz(filas_facturas, Factura,columnas_facturas);
            String matriz_facturas_ordenada[][] = ordenar_matriz(filas_facturas, matriz_facturas,columnas_facturas);
            String matriz_productos[][] = File_to_matriz(filas_productos, productos,columnas_productos);
           
            
            // int Num_clientes_con_factura = Num_clients(matriz_facturas_ordenada,filas_facturas);
            // System.out.println(Num_clientes_con_factura);
            
            //String Clientes_con_facturas[]= clients_facturas(matriz_facturas_ordenada,filas_facturas);
            //System.out.println(Clientes_con_facturas[0]);
            //System.out.println(Clientes_con_facturas[1]);
            //System.out.println(Clientes_con_facturas[2]);
            
            
    } 


    public static String [][] ordenar_matriz (int x, String Save [][], int z){
        int ordenador [] = new int [x];
        String  save2 [][] = new String [x][z];
        for (int i = 0; i < x; i++){
            ordenador [i] = Integer.parseInt(Save [i][0]);    
        } 
        Arrays.sort(ordenador); //cedulas ordenadas en un array
        for(int i = 0; i <x; i++){
            int y=0;
            while(ordenador [i]!= Integer.parseInt(Save[y][0])){
                y++;     
            }
            for(int h = 0; h <z; h++){
                save2[i][h] = Save[y][h];
            }
        }
        
        return save2;
    }

    public static String [] clients_facturas (String facturas_ordenadas[][], int filas_facturas){
        int i = 1;
        int r = 0;
        int k = 0;
        int h =0;
        String []clients = new String[3];
        clients [h] = facturas_ordenadas[0][0];
        while(facturas_ordenadas[k+1][0] != null){
            while(i != filas_facturas ){
                if(facturas_ordenadas[k][0] != facturas_ordenadas[i][0]){
                    r = i;
                    i=filas_facturas;
                    h++;
                    clients[h] = facturas_ordenadas[i][0];
                }else{
                    i++;
                }
            }
            k = r;
            i = k +1;
        }
        return clients;
    }
    

    public static String [][] File_to_matriz (int x, String file, int z){
            String  Save [][] = new String [x][z];
            try {
                int fila = 0;
                String strCurrentLine = null;
                FileReader lector = new FileReader(file + ".csv");
                BufferedReader reader = new BufferedReader(lector);
                while ((strCurrentLine = reader.readLine ())!= null) {  
                    for (int i = 0; i < z; i++){
                    String[] parts = strCurrentLine.split("\\;");
                        Save [fila][i]= parts[i]; 
                    }
                    fila++;
                }                 
            } catch (Exception e) {
                // TODO: handle exception
            }
            return Save;
    }
    public static int tamañoy (String archivo){
        int i = 0;
        try {
            String strCurrentLine = null;
            FileReader lector = new FileReader(archivo + ".csv");
            BufferedReader reader = new BufferedReader(lector);
            while ((strCurrentLine = reader.readLine ())!= null) {
                String[] parts = strCurrentLine.split("\\;");
                i= parts.length;
            }
           
        } catch (Exception e) {
        }    
            return i;
    }


    public static int tamañox (String archivo){
        int i =0;
        try {
            String strCurrentLine = null;
            FileReader lector = new FileReader(archivo + ".csv");
            BufferedReader reader = new BufferedReader(lector);
            while ((strCurrentLine = reader.readLine ())!= null) {
                    i++;
            }  
        } catch (Exception e) {
        }    
        return i;
    }
    public static int Num_clients (String facturas_ordenadas[][], int filas_facturas){
        int j = 1;
        int i = 1;
        int r = 0;
        int k = 0;
        while(facturas_ordenadas[k+1][0] != null){
            while(i != filas_facturas ){
                if(facturas_ordenadas[k][0] != facturas_ordenadas[i][0]){
                    j++;
                    r = i;
                    i=filas_facturas;
                }else{
                    i++;
                }
            }
            k = r;
            i = k +1;
        }
        System.out.println(j);
        return j;
    }
        
        public static void printmatriz(String[][] matriz) {
            for (int i=0;i<matriz.length;i++){
                for (int j=0; j<matriz[0].length;j++){
                    System.out.print(matriz[i][j]+"\t");
                    if (j== matriz[0].length-1)     
                    System.out.println("");
                    
                }
            }
        }            
}