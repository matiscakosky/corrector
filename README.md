# Corrector automático de trabajos prácticos y exámenes para ORT
El corrector recibe una entrega por mail con un formato esperado y descarga los archivos en un path especifico. Ejecuta un archivo de pruebas y devuelve una respuesta al alumno. Actualiza una planilla de spreadsheet y sube la entrega a un repositorio de github.


## Instalacion
El programa corre con python 3.6 o superior.
Deben instalarse varias librerías. Algunas de ellas:

#### Variables de entorno
Deben colocarse las variables de entorno\n
SKEL_DIR -> A donde esten los trabajos practicos y sus pruebas 
MOSS_DIR -> A donde esten guardados los trabajos de los alumnos
junit -> A java/junit.jar (Valido para JUNIT 4) 
hamcrest-> A java/hamcrest.jar (Valido para JUNIT 4)


### Java y Junit
```bash
sudo add-apt-repository ppa:webupd8team/java
sudo apt update
sudo apt install oracle-java8-installer
sudo apt install oracle-java8-set-default
javac -version
```

### API de Gmail
Si no se tiene instalado pip3, instalarlo previamente 
```bash
sudo apt install pip3
pip3 install --upgrade google-api-python-client google-auth-httplib2 google-auth-oauthlib
pip3 install --upgrade oauth2client 
```

### API de SpreadSheets
```bash
pip3 install gspread
```


### API de git
```bash
pip3 install gitpython
```

