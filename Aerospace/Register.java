package Aerospace;

import java.io.IOException;

import java.io.PrintWriter;
import Aerospace.DB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String var1 = request.getParameter("var");
		System.out.println("var2======"+var1);
		request.setAttribute("var",var1);
		String  name= request.getParameter("name1");
		String  email= request.getParameter("email1");
		String  pswd= request.getParameter("pass");
		String  cpswd= request.getParameter("cpass");
		System.out.println(name+email+pswd+cpswd);
		String status="pending";
		 PrintWriter prw = response.getWriter();
			try {
				String qry = "INSERT INTO users(name,mail,password,cpassword,role,status) "
								+ "VALUES('"+name+"','"+email+"','"+pswd+"','"+cpswd+"','"+var1+"','"+status+"')";
				/*int i = DataBase.getconnection().prepareStatement(qry).executeUpdate();*/
				int ii =DB.getconnection().prepareStatement(qry).executeUpdate();
				System.out.println("ii value============"+ii);
				if(ii>0) {
					request.setAttribute("var",var1);
					prw.print("<html><body><script> alert('Registered Successfully...');</script></body></html>");
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
				}else {
					request.setAttribute("var",var1);
					System.out.println("Failed !");
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
	}

}
