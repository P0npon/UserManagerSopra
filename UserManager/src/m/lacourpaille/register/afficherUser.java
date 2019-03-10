package m.lacourpaille.register;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class afficherUser
 */
@WebServlet("/users")
public class afficherUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/users/users.jsp";
	public static final String CHAMP_EMAIL = "email";
    public static final String CHAMP_PASS = "motdepasse";
    public static final String CHAMP_CONF = "confirmation";
    public static final String CHAMP_NOM = "nom";
    public static final String ATT_ERREURS  = "erreurs";
    public static final String ATT_FORM  = "form";
    public static final String ATT_RESULTAT = "resultat";
    public static final String ATT_NEWUSER = "newUser";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public afficherUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
