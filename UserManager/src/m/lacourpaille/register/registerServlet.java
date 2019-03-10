package m.lacourpaille.register;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/register.jsp";
	public static final String CHAMP_EMAIL = "email";
	public static final String CHAMP_PASS = "motdepasse";
	public static final String CHAMP_CONF = "confirmation";
	public static final String CHAMP_NOM = "nom";
	public static final String ATT_ERREURS = "erreurs";
	public static final String ATT_FORM = "form";
	public static final String ATT_RESULTAT = "resultat";
	public static final String ATT_NEWUSER = "newUser";
	public static final String target = "newUser";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public registerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("errorStatus", false);
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String resultat;
		Map<String, String> erreurs = new HashMap<String, String>();
		Map<String, String> form = new HashMap<String, String>();
		User newUser = null;

		String email = request.getParameter(CHAMP_EMAIL);
		String motDePasse = request.getParameter(CHAMP_PASS);
		String confirmation = request.getParameter(CHAMP_CONF);
		String nom = request.getParameter(CHAMP_NOM);

		try {
			validationEmail(email);
			form.put(CHAMP_EMAIL, email);

		} catch (Exception e) {
			erreurs.put(CHAMP_EMAIL, e.getMessage());
		}

		/* Validation des champs mot de passe et confirmation. */
		try {
			validationMotsDePasse(motDePasse, confirmation);
			form.put(CHAMP_PASS, motDePasse);

		} catch (Exception e) {
			erreurs.put(CHAMP_PASS, e.getMessage());
		}

		/* Validation du champ nom. */
		try {
			validationNom(nom);
			form.put(CHAMP_NOM, nom);

		} catch (Exception e) {
			erreurs.put(CHAMP_NOM, e.getMessage());
		}

		/* Initialisation du résultat global de la validation. */
		if (erreurs.isEmpty()) {
			resultat = "Succès de l'inscription.";
			newUser = new User(nom, email, motDePasse);
			request.setAttribute("errorStatus", false);
			HttpSession session = request.getSession();
			session.setAttribute("name", "session scoped attribute");
			Map<String, User> users = (HashMap<String, User>) session.getAttribute("users");
			if (users == null) {
				users = new HashMap<String, User>();
			}
			users.put(newUser.getEmail(), newUser);
			session.setAttribute("users", users);
		} else {
			resultat = "Échec de l'inscription.";
			request.setAttribute("errorStatus", true);
		}

		/* Stockage du résultat et des messages d'erreur dans l'objet request */
		request.setAttribute(ATT_ERREURS, erreurs);
		request.setAttribute(ATT_RESULTAT, resultat);
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_NEWUSER, newUser);

		/* Transmission de la paire d'objets request/response à notre JSP */
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);

	}

	/**
	 * Valide l'adresse mail saisie.
	 */
	public static void validationEmail(String email) throws Exception {
		if (email != null && email.trim().length() != 0) {
			if (!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Merci de saisir une adresse mail valide.");
			}
		} else {
			throw new Exception("Merci de saisir une adresse mail.");
		}
	}

	/**
	 * Valide les mots de passe saisis.
	 */
	public static void validationMotsDePasse(String motDePasse, String confirmation) throws Exception {
		if (motDePasse != null && motDePasse.trim().length() != 0 && confirmation != null
				&& confirmation.trim().length() != 0) {
			if (!motDePasse.equals(confirmation)) {
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			} else if (motDePasse.trim().length() < 3) {
				throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}
	
	/**
	 * Valide le nom d'utilisateur saisi.
	 */
	private void validationNom(String nom) throws Exception {
		if (nom != null && nom.trim().length() < 3) {
			throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères.");
		}
	}

}
