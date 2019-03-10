package m.lacourpaille.register;

import java.io.Serializable;



public class User {
	
	public String nom;
	public String getNom()
	{
		return nom;
	}
	
	
	public String email;
	public String getEmail()
	{
		return email;
	}
	public String motdepasse;
	public String getMotdepasse()
	{
		return motdepasse;
	}
	
	User(String nom, String email, String motdepasse){
		this.nom = nom;

		this.email = email;

		this.motdepasse = motdepasse;
	}

}
