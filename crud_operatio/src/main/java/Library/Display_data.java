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
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class Display_data
 */
public class Display_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Display_data() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/tapan","root","Tapan123");
			String query = "SELECT * FROM library";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			pw.print("<table border = '1px solid black'>");
			pw.print("<tr><td>Book Id</td><td>Book Name</td><td>Book Price</td><td>Book Purchase Type</td><td>Book Purchase Date</td><td>Book Type</td><td>Author Name</td><td>Delete</td><td>Update</td></tr>");
			while(rs.next()) {
				pw.print("<tr>");
				pw.print("<td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getInt(3)+"</td><td>"+rs.getString(4)+"</td>"
						+ "<td>"+rs.getDate(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td><a href = 'delete_data?id="+rs.getInt(1)+"'>Delete</a></td><td><a href = 'edit_data?id="+rs.getInt(1)+"'>Update</a></td>");
				pw.print("</tr>");
			}
			pw.print("<tr><td><a href = 'index.html'><button type = 'button'>Insert Data</button></a></td></tr>");
			pw.print("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
