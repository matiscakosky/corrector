
public class CloudService implements Conexion {
	
	boolean a1=false;
	boolean a2=false;
	boolean a3=false;
	
	@Override
	public void abrirConexion() {
		a1=true;
		a2=true;
		a3=true;
		
	}

	@Override
	public boolean successful() {
		return a1&&a2&&a3;
	}

}
