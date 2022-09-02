# Lab_Estructuras_Datos
## Mateo Guerrero, Brayan Gutierrez, Hans Lubinus

## 2 A 

## Java

Tenemos la posibilidad de abrir un fichero de escrito para leer utilizando la clase FileReader. Esta clase tiene procedimientos que nos permiten leer letras y números. No obstante, suele ser usual querer las líneas enteras, bien pues nos atrae la línea completa, bien para lograr analizarla después y sustraer campos de ella. FileReader no tiene procedimientos que nos permitan leer líneas enteras, sin embargo sí BufferedReader. Afortunadamente, tenemos la posibilidad de edificar un BufferedReader desde el FileReader de la siguiente forma:

File archivo = new File ("C:\\archivo.txt");
FileReader fr = new FileReader (archivo);
BufferedReader br = new BufferedReader(fr);
...
String linea = br.readLine();

La abertura del fichero y su siguiente lectura tienen la posibilidad de arrojar excepciones que debemos capturar. Por esto, la abertura del fichero y la lectura debería meterse en un bloque try-catch.
 Además, el fichero se debe cerrarlo una vez que culminemos con él, tanto si todo ha ido bien como si ha habido cualquier error en la lectura luego de haberlo abierto. Por esto, se suele colocar al try-catch un bloque finally y en él, el close() del fichero.
El siguiente es un código completo con todo lo mencionado.

import java.io.*;
class LeeFichero {
   public static void main(String [] arg) {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;

      try {
 // Apertura del fichero y creacion de BufferedReader para poder hacer una lectura comoda    (disponer del metodo readLine()).
         archivo = new File ("C:\\archivo.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            System.out.println(linea);
      }
      catch(Exception e){
         e.printStackTrace();
      }finally{
 // En el finally cerramos el fichero, para asegurarnosque se cierra tanto si todo va bien como si salta una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   }
}
Como opción para leer un fichero de texto línea por línea, podría usarse la clase Scanner en vez de el FileReader y el BufferedReader.


El siguiente código escribe un fichero de texto desde cero.

import java.io.*;

public class EscribeFichero
{
    public static void main(String[] args)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("c:/prueba.txt");
            pw = new PrintWriter(fichero);

            for (int i = 0; i < 10; i++)
                pw.println("Linea " + i);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
}

## Python

Para leer del fichero, podemos usar las funciones f.read() y f.readline()
Lectura de todo el fichero de golpe : dato = f.read()
>>> f = open("kk.txt")
>>> f.read()
'hola\nmundo\n'
>>> f.close()
Lectura de 100 bytes : dato = f.read(100)
>>> f = open("kk.txt")
>>> dato = f.read(3)
>>> dato
'hol'
>>> f.close()
Lectura de una línea completa : dato = f.readline()
>>> f = open("kk.txt")
>>> dato = f.readline()
>>> dato
'hola\n'
>>> f.close()
Para escribir el fichero desde cero, machando su contenido si lo hubiera
>>> f=open("kk.txt","w")
>>> f.write("machacando\n")
>>> f.close()
>>> f=open("kk.txt")
>>> f.read()
'machacando\n'
>>> f.close()
Para escribir sobre un fichero existente, añadiendo al final
>>> f = open ("kk.txt", "a")
>>> f.write("tras tres tris\n")
>>> f.close()
>>> f=open("kk.txt")
>>> f.read()
'machacando\ntras tres tris\n'
>>> f.close()

## C#
Las clases System.IO.BinaryWriter y System.IO.BinaryReader se aplican para redactar y leer datos diversos de cadenas de letras y números. En el ejemplo siguiente se muestra cómo se crea un flujo de archivos vacío y cómo se escriben y se leen datos de este.
 El ejemplo crea un documento de datos denominado Examen.data en el directorio de hoy, crea los objetos BinaryWriter y BinaryReader asociados y usa el objeto BinaryWriter para redactar los completos de 0 a 10 en Examen.data, que deja el puntero de documento finalmente del documento. Luego, el objeto BinaryReader vuelve a implantar el puntero de documento en los principios y lee el contenido detallado.

using System;
using System.IO;

class MyStream
{
    private const string FILE_NAME = "Test.data";

    public static void Main()
    {
        if (File.Exists(FILE_NAME))
        {
            Console.WriteLine($"{FILE_NAME} already exists!");
            return;
        }

        using (FileStream fs = new FileStream(FILE_NAME, FileMode.CreateNew))
        {
            using (BinaryWriter w = new BinaryWriter(fs))
            {
                for (int i = 0; i < 11; i++)
                {
                    w.Write(i);
                }
            }
        }

        using (FileStream fs = new FileStream(FILE_NAME, FileMode.Open, FileAccess.Read))
        {
            using (BinaryReader r = new BinaryReader(fs))
            {
                for (int i = 0; i < 11; i++)
                {
                    Console.WriteLine(r.ReadInt32());
                }
            }
        }
    }
}

## Conclusión 

En conclusión, se puede ver como en los tres lenguajes de programación tiene la misma lógica para leer y escribir un archivo la cual es poner el archivo y leerlo línea por línea o solo una parte, pero por lo visto Python es el único de los 3 que puede, pero al final la implementación de lectura y escritura varia código por código, ya que cada lenguaje tiene su forma de leer y escribir.


## 2 C

Con lo aprendido en clase, hay dos tipos de archivos los secuenciales y indexados. Actualmente la mayoría de las empresas trabajan con los archivos y base de datos con el programa Excel (Microsoft Excel es una hoja de cálculo desarrollada por Microsoft para Windows, macOS, Android e iOS. Cuenta con cálculo, gráficas, tablas calculares y un lenguaje de programación macro llamado Visual Basic para aplicaciones.) que es mucho más flexible con la escritura, eliminación, modificación, etc. Los algoritmos vistos en clase son mas complejos comparado a Excel, ya que Excel cuenta con interfaces que son mas accesibles para el usuario. Por ejemplo, Excel es igual a los archivos indexados, con la diferencia que los archivos indexados presentados en clase no manejan interfaces.

A diferencia de java, donde usamos ciertas funciones como Split o funciones que eliminen los espacios para saber que palabra se encuentra en un campo.

En conclusión, el objetivo de las funciones en Excel y las usadas en clase, ya sea pseudocódigo o java, son exactamente las mismas con la diferencia de que Excel es un software más fácil de usar para un usuario nuevo, el cual cuenta con interfaces que permiten el entendimiento de la operación que se está realizando con el archivo, ya que alguien que no sabe sobre el manejo de archivos de java no lograra entender por más que analice el código lo que está ocurriendo.

