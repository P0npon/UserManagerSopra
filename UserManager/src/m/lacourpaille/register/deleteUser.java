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
 * Servlet implementation class deleteUser
 */
@WebServlet("/del-user")
public class deleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter( registerServlet.CHAMP_EMAIL );
		Map<String, String[]> params = request.getParameterMap();
		ServletContext context = getServletContext( );
		for(String mail : params.keySet()) {
			context.log(params.get(mail)[0]);
		}
		
		context.log(email);
		// Find user map
		HttpSession session = request.getSession();
		Map<String, User> users = (HashMap<String, User>) session.getAttribute("users" );
		for(String mail : users.keySet()) {
			context.log(mail);
		}
		context.log("This is a log item");
		 // Check if email not empty
		 if ( email != null ) {
		 // Remove user from list
		 users.remove( email );
		 // Reset users list into session attribut
		 session.setAttribute( "users", users );
		 }
		 // Redirect to the user list
		 response.sendRedirect( request.getContextPath() + "/users" );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
