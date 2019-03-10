package m.lacourpaille.register;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private final String ATT_ERREURS = "erreurs";
	private final String ATT_FORM = "form";
	private final String ATT_RESULTAT = "resultat";
	private final String VUE = "/WEB-INF/login/login.jsp";
	private final String CHAMP_EMAIL = "email";
	private final String CHAMP_AUTH = "authentification";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> erreurs = new HashMap<String, String>();
		erreurs.put(CHAMP_AUTH, "Pas encore authentifié");
		request.setAttribute(ATT_ERREURS, erreurs);
		ServletContext context = getServletContext();
		context.log(""+erreurs.size());
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String resultat="";
		Map<String, String> erreurs = new HashMap<String, String>();
		Map<String, String> form = new HashMap<String, String>();
		
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String motDePasse = request.getParameter("motdepasse");
		Map<String, User> users = (HashMap<String, User>) session.getAttribute("users" );
		
		try {
			registerServlet.validationEmail(email);
			form.put(CHAMP_EMAIL, email);

		} catch (Exception e) {
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}
		
		if(users!=null) {
			if(erreurs.size()==0) {
				if(users.containsKey(email))
				{
					if(users.get(email).motdepasse.equals(motDePasse)) {
						resultat="Vous êtes connecté "+users.get(email).nom;
					}
					else {
						erreurs.put(CHAMP_AUTH, "Mot de passe incorrect");
						resultat="Mot de passe incorrect";
					}
				}
				else {
					erreurs.put(CHAMP_AUTH, "Adresse email non reconnu");
					resultat="Adresse email non reconnu";
				}
			}
			
		}
		else {
			erreurs.put(CHAMP_AUTH, "Nous n'avons pas encore d'utilisateurs , inscrivez vous ! ");
			resultat="Nous n'avons pas encore d'utilisateurs , inscrivez vous !";
		}
		request.setAttribute(ATT_ERREURS, erreurs);
		request.setAttribute(ATT_RESULTAT, resultat);
		request.setAttribute(ATT_FORM, form);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
