package bean;

import java.io.IOException;

import get.Attack1CX;
import get.Attack1JS;
import get.Attack1RE;
import get.Attack1RL;
import get.Attack2CX;
import get.Attack2JS;
import get.Attack2RE;
import get.Attack2RL;






import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import sun.security.validator.ValidatorException;


@ManagedBean
@SessionScoped
public class SelectOneMenuView {
	private String metodos="g";
	private String ataques;
	private String librerias;
	private String resultado;
	public String getMetodos() {
		return metodos;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public void setMetodos(String metodos) {
		this.metodos = metodos;
	}
	public String getAtaques() {
		return ataques;
	}
	public void setAtaques(String ataques) {
		this.ataques = ataques;
	}
	public String getLibrerias() {
		return librerias;
	}
	public void setLibrerias(String librerias) {
		this.librerias = librerias;
	}
	
	public void validate(FacesContext arg0, UIComponent arg1, Object arg2)
            throws ValidatorException {
		System.out.println(((String)arg2));
		if (((String)arg2).equals("null")) {
	         throw new ValidatorException(new FacesMessage("Al menos 5 caracteres "));
	    }
	}
	
	public String consultar() throws IOException{
		
		if(metodos.equals("g")){
			if(librerias.equals("Jersey")){
				Attack2JS a = new Attack2JS();
				resultado=a.At("",1,5);   
			}else if(librerias.equals("Restlet")){
				Attack2RL a = new Attack2RL();
				resultado=a.At("",1,5);
			}
			else if(librerias.equals("RestEasy")){
				Attack2RE a = new Attack2RE();
				resultado=a.At("",1,5);
			}
			else if(librerias.equals("ApacheCXF")){
				Attack2CX a = new Attack2CX();
			    resultado=a.At("",1,5);
			}
			
		}
		else if (metodos.equals("p")){
			if(librerias.equals("Jersey")){
				post.Attack2RE a = new post.Attack2RE();
				resultado=a.At("",1,5);
			}else if(librerias.equals("Restlet")){
				post.Attack2RL a = new post.Attack2RL();
				resultado=a.At("",1,5);
			}
			else if(librerias.equals("RestEasy")){
				post.Attack2RE a = new post.Attack2RE();
				resultado=a.At("",1,5);
			}
			else if(librerias.equals("ApacheCXF")){
				post.Attack2CX a = new post.Attack2CX();
				resultado=a.At("",1,5);
			}
		}
		return "answ1.xhtml";
	}
	
	public String consultar2() throws IOException{
		
		if(metodos.equals("g")){
			if(librerias.equals("Jersey")){
				Attack1JS a = new Attack1JS();
			    resultado=a.At();   
			}else if(librerias.equals("Restlet")){
				Attack1RL a = new Attack1RL();
			    resultado=a.At();
			}
			else if(librerias.equals("RestEasy")){
				Attack1RE a = new Attack1RE();
			    resultado=a.At();
			}
			else if(librerias.equals("ApacheCXF")){
				Attack1CX a = new Attack1CX();
			    resultado=a.At();
			}
			
		}
		else if (metodos.equals("p")){
			if(librerias.equals("Jersey")){
				post.Attack1RE a = new post.Attack1RE();
			    resultado=a.At();
			}else if(librerias.equals("Restlet")){
				post.Attack1RL a = new post.Attack1RL();
			    resultado=a.At();
			}
			else if(librerias.equals("RestEasy")){
				post.Attack1RE a = new post.Attack1RE();
			    resultado=a.At();
			}
			else if(librerias.equals("ApacheCXF")){
				post.Attack1CX a = new post.Attack1CX();
			    System.out.println(a.At());
				resultado=a.At();
			}
		}
		return "answ1.xhtml";
	}
}