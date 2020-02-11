# Corrector automático de trabajos prácticos y exámenes para ORT
El corrector recibe una entrega por mail con un formato esperado y descarga los archivos en un path especifico. Ejecuta un archivo de pruebas y devuelve una respuesta al alumno. Actualiza una planilla de spreadsheet y sube la entrega a un repositorio de github.


## Dependendencias y pre-condiciones
El programa corre con python 3.6 o superior. Para poder comenzar su instalación previamente se debe contar con las siguientes condiciones.
### Instalar pip3
``` sudo apt install python3-pip```

### Clonar el repositorio con el código del sistema
``` git clone https://github.com/matiscakosky/corrector```

### Variables de entorno
Deben colocarse las variables de entorno
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

## Instalación
Una vez finalizadas todas las instalaciones previas se procede con las autenticaciones con las API's del sistema

### Correr el corrector la primera vez
Escribir el comando de ejecución del script principal del corrector
```bash
python3 corrector.py
```

Se pedirá la autenticación con la API de Gmail. La misma solicitará que abra el browser para pegar un link que brindará la API.

Si se encuentra instalando la aplicación desde algún servidor web o un bash que no posee browser correr de nuevo el corrector con el siguiente parametro 
```bash
python3 corrector.py --noauth_local_webserver
```


## Anexos
### Ejecución por SSH del servidor AWS
### Terminal de AWS sin colores (Ubuntu 18 LTS)
Si la terminal que se ejecuta desde ubuntu por SSH no tiene colores, se debe abrir el bash_profile.
```bash
vi ~/.bashrc
```
Posteriormente agregar estas lineas.
```bash
if [ -n "$BASH_VERSION" ]; then
    # include .bashrc if it exists
    if [ -f "$HOME/.bashrc" ]; then
        . "$HOME/.bashrc"
    fi
fi
```
Luego
```bash
source ~/.bashrc
```
Y ¡Voilà! Aparecen los colores. Y no será necesario ejecutar el bash cada vez que se inicie una sesión SSH

