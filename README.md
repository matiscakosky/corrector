# Corrector automático de trabajos prácticos y exámenes para ORT
El corrector recibe una entrega por mail con un formato esperado y descarga los archivos en un path especifico. Ejecuta un archivo de pruebas y devuelve una respuesta al alumno. Actualiza una planilla de spreadsheet y sube la entrega a un repositorio de github.


## Dependendencias y pre-condiciones
El programa corre con python 3.6 o superior. Para poder comenzar su instalación previamente se debe contar con las siguientes condiciones.
### Instalar pip3
``` sudo apt install python3-pip```


### Variables de entorno
Deben colocarse las variables de entorno\n
* SKEL_DIR -> A donde esten los trabajos practicos y sus pruebas 
* MOSS_DIR -> A donde esten guardados los trabajos de los alumnos
* junit -> A java/junit.jar (Valido para JUNIT 4) 
* hamcrest-> A java/hamcrest.jar (Valido para JUNIT 4)

Cuando se establece una variable de entorno desde el shell utilizando el comando de exportación, su existencia finaliza cuando finalizan las sesiones del usuario. Esto es problemático cuando necesitamos que la variable persista en las sesiones. Para hacer que un entorno sea persistente para el entorno de un usuario, exportamos la variable desde el script de perfil del usuario.

```bash
vi ~/.bash_profile
export junit=/path/to/java/junit.jar
export hamcrest=/path/to/java/hamcrest.jar
export SKEL_DIR=/path/to/SKEL_TP
export MOSS_DIR=/path/to/moss

```
Guardar cambios.

Agregar la variable de entorno solo al perfil bash de un usuario no lo exportará automáticamente. Sin embargo, la variable se exportará la próxima vez que el usuario inicie sesión.

Para aplicar inmediatamente todos los cambios a bash_profile, use el comando de origen.
```bash
source ~ /.bash_profile
```

### Java y Junit
```bash
sudo apt install default-jdk 
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
### De no tener instalada dateutil
```bash
pip3 install python-dateutil
```

