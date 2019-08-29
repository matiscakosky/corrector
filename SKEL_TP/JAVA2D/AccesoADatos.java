
public class AccesoADatos {
	DataBaseService db;
	
	
	//Las pruebas no van a correr hasta reescribir bien este constructor
	public AccesoADatos(DataBaseService db) {
		this.db=db;
	}
	
	
	//Reescribir este codigo
	public boolean obtenerAccesoAlServicio() {
		//make service run 
		db.conectar();
		db.consultar();
		db.procesar();
		
		//successful exit
		return db.conectado && db.consultado && db.procesado;
	}
}


