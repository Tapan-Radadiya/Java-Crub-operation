package Library;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Servlet implementation class edit_data
 */
public class edit_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit_data() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		pw.print("<form action = 'update_data'>");
		pw.print("<table border = '1px solid black'>"
				+ "<input type = 'hidden' name = 'id' value = "+id+">"
				+ "<tr> <td>Enter New Book Name</td><td><input type = 'text' name = 'newBook'></td></tr>"
				+ "<tr> <td>Enter New Book Price</td><td><input type = 'text' name = 'newPrice'></td></tr>"
				+ "<tr> <td>Select New Book Purchase</td><td><input type = 'radio' name = 'newPurchase'>Rent"
				+ "<input type = 'radio' name = 'newPurchase'>Buy</td></tr>"
				+ "<tr> <td>Select New Book Purchase/rent Date</td><td><input type = 'date' name = 'newDate'></td></tr>"
				+ "<tr><td>Select Book Type</td>"
				+ "<td><input type = 'checkbox' name = 'newType' value = 'Novel'>novel"
				+ "<input type = 'checkbox' name = 'newType' value = 'Education'>Education"
				+ "<input type = 'checkbox' name = 'newType' value = 'Comic'>Comic"
				+ "<input type = 'checkbox' name = 'newType' value = 'Stories'>Stories"
				+ "<input type = 'checkbox' name = 'newType' value = 'Horror'>Horror</td></tr>"
				+ "<tr> <td>Select Book Author</td><td><select = 'newAuthor' name = 'newAuthor'>"
				+ "<option value = ''>--Select--</option>"
				+ "<option value = 'Bimal Jalal'>Bimal Jalal</option>"
				+ "<option value = 'Ruskin Bond'>Ruskin Bond</option>"
				+ "<option value = 'Vinit Karnik'>Vinit Karnik</option>"
				+ "<option value = 'Preeti Shenoy'>Preeti Shenoy</option>"
				+ "<option value = 'VP Venkaiah Naidu'>VP Venkaiah Naidu</option>"
				+ "</select></td></tr>"
				+ "<tr> <td><input type = 'submit' name = 'update'></td><td><input type = 'reset' name = 'reset'></td></tr>"
				+ "</table>");
		pw.print("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
