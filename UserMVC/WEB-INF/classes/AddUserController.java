
import com.lti.*;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.*;

/**
 * Servlet implementation class AddUserController
 */
@WebServlet("/AddUserController")
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setEmail(email);
		u.setPassword(password);
		
		UserDAO userDao=new UserDAO();
		String result=userDao.addUser(u);
		
		if(result.equals(Results.SUCCESS))
		{
			session.setAttribute("name",u.getName());
			RequestDispatcher rd=request.getRequestDispatcher("/userSuccess.jsp");
			rd.forward(request, response);
		}
		
	}

}
