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
#### Uso de git
Para el uso del repo de alumnos, de manera automatica es necesario que el server cuente con las credenciale de acceso. Para ello
```bash
git config --global user.name reponame
git config --global user.password repopass
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
### Agregar el repositorio de alumnos
Se debe agregar un sub-repositorio dentro del original, en el directorio /corrector/moss donde se guardan los trabajos de los alumnos para ellos (el punto es para indicar que no es necesario la project folder)
```bash
git clone https://github.com/matiscakosky/tps_alumnos .
```


### Ejecutar el corrector desde crontab
Si bien parece algo sencillo, es una de las partes mas complicadas de la instalación del corrector, es justamente la parte en la que el mismo se ejecuta de manera automatica y revisa si hay entregas.

El crontab tiene varios problemas con las rutas relativas, y el reconocimiento de variables de entorno. Por lo que para ejecutar el corrector, en Ubuntu 18 LTS. La mejor opción es hacer un script de bash que funcione como wrapper hacia el script principal del corrector. (Anteriormente con el servidor de Ubuntu 16, esto no era necesario.). En ningun momento se pueden utilizar atajos, siempre hay que poner las rutas completas a cualquier directorio o archivo que se quiera acceder.
Por ejemplo:
 * Para acceder a python no alcanza con escribir python3 sino que se debe ejecutar mediante /usr/bin/python3.6
 *



El wrapper es llamado *auto_execute.sh*
```bash
#!/usr/bin/env bash
source $HOME/.bash_profile
cd /home/ubuntu/corrector/scripts && /usr/bin/python3.6 /home/ubuntu/corrector/scripts/corrector.py
```
El archivo de crontab al cual se accede con:
```bash
crontab -e 
```
(El -e indica la edición)

Contiene:
```bash
* * * * * /home/ubuntu/auto_execute.sh > /home/ubuntu/cronstatus.txt 2>&1
* * * * * sleep 15;/home/ubuntu/auto_execute.sh > /home/ubuntu/cronstatus.txt 2>&1
* * * * * sleep 30;/home/ubuntu/auto_execute.sh > /home/ubuntu/cronstatus.txt 2>&1
* * * * * sleep 45;/home/ubuntu/auto_execute.sh > /home/ubuntu/cronstatus.txt 2>&1
```
Los astericos indican que la operacion debe hacerse a cada minuto, cada hora, cada dia y cada semana.
El comado sleep es para poder manejarse entre los segundos, luego la ejecución del bash.
Algo interesante es que la última sentencia guarda el resultado del bash en el archivo *cronstatus.txt* que resulta una buena forma de debuggear el programa cuando se corre desde crontab, aunque no es necesario para su ejecución.


## Anexos
### Ejecución por SSH del servidor AWS
Requisitos:
* El archivo .pem que se descarga por única vez de AWS.  Ej: file.pem
* La public DNS id del server. Ej: ec2-35-173-242-106.compute-1.amazonaws.com 

Guardar el .pem en algún directorio, luego en la terminal, de ese directorio escribir.
```bash
ssh -i file.pem ubuntu@ec2-35-173-242-106.compute-1.amazonaws.com
```

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


### Librería de memory_profiler
Es un módulo de Python para monitorear el consumo de memoria de un proceso, así como el análisis línea por línea del consumo de memoria para los programas de Python. Se utiliza para distintos trabajos en los que importa el consumo de memoria.
```bash
pip3 install -U memory_profiler
```




