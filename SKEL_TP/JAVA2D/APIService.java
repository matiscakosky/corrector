
public class APIService {
	boolean response;
	boolean trafic;
	boolean generatedToken;
	
	public APIService() {
		response=false;
		trafic=false;
		generatedToken=false;
	}
	
	public void accesoAServidorAPI() {
		if(response&&generatedToken)trafic=true;
	}
	public void comprobarServidor() {
		if(generatedToken)response=true;
	}
	public void solicitarAcceso() {
		generatedToken=true;
	}
	
	

}
