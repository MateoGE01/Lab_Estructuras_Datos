package Scripts;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

class readcsv {
    private static String[] datos;

    public static void main(String[] args) {
        long start = System.nanoTime();
        String sample = ",";
        String mystring;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Scripts\\SalesRecords.csv"));
            while ((mystring = reader.readLine()) != null) // Reads a line of text
            {
                datos = mystring.split(sample);
                System.out.println("['" + datos[0] + "', '" + datos[1] + "', '" + datos[2] + "', '" + datos[3] + "', '"
                        + datos[4] + "', '" + datos[5] + "', '" + datos[6] + "', '" + datos[7] + "', '" + datos[8]
                        + "', '" + datos[9] + "', '" + datos[10] + "', '" + datos[11] + "', '" + datos[12] + "', '"
                        + datos[13] + "']");
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        long tiempo = end - start;
        System.out.println(tiempo);
        float tiempoSegundos = (float) tiempo / 1000000000;
        System.out.println(tiempoSegundos+" segundos");
    }

}
