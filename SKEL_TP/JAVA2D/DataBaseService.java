
public class DataBaseService {
	boolean conectado;
	boolean consultado;
	boolean procesado;
	
	public DataBaseService() {
		conectado=false;
		consultado=false;
		procesado=false;
	}
	
	public void procesar() {
		if(conectado&&consultado)procesado=true;
	}
	public void consultar() {
		if(conectado)consultado=true;
	}
	public void conectar() {
		conectado=true;
	}
	
}
