import csv
from timeit import default_timer

#Inicio del timer
start = default_timer()

#Lectura del CSV
with open('Scripts/SalesRecords.csv', 'r') as csv_file:
    csv_reader = csv.reader(csv_file)

    for line in csv_reader:
        print(line)
        
 #Fin del timer       
duration = default_timer() - start
print(duration)
  
   
 