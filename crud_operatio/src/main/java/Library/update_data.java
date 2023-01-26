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
import java.sql.PreparedStatement;

import com.mysql.cj.jdbc.Driver;

/**
 * Servlet implementation class update_data
 */
public class update_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_data() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    boolean flag = false;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		int id = Integer.parseInt(request.getParameter("id"));
		String book_name = request.getParameter("newBook");
		int book_Price = Integer.parseInt(request.getParameter("newPrice"));
		String book_buy = request.getParameter("newPurchase");
		String book_date = request.getParameter("newDate");
		String[] type = request.getParameterValues("newType");
		String newbookType = "";
		for(int i = 0;i<type.length;i++) {
			newbookType += type[i] + ",";
		}
		String newAuthor = request.getParameter("newAuthor");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3305/tapan","root","Tapan123");
			String query = "Update library set Book_name = ?,Book_price = ?,book_purchase = ?,book_date = ?,book_type = ?,author_name = ? where Book_id = "+id;
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, book_name);
			pstmt.setInt(2, book_Price);
			pstmt.setString(3, book_buy);
			pstmt.setString(4, book_date);
			pstmt.setString(5, newbookType);
			pstmt.setString(6, newAuthor);
			pstmt.execute();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!flag) {
			pw.print("Data Not Updated");
		}
		else {
			response.sendRedirect("Display_data");
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
