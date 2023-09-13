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

/**
 * Servlet implementation class insert_data
 */
public class insert_data extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insert_data() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    boolean flag = false;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String book_name = request.getParameter("book_name");
		int book_Price = Integer.parseInt(request.getParameter("book_Price"));
		String book_buy = request.getParameter("book_buy");
		String book_date = request.getParameter("book_date");
		String[] type = request.getParameterValues("book_type");
		String book_type = "";
		for(int i = 0; i < type.length;i++) {
			book_type += type[i] + ",";
		}
		String author_name = request.getParameter("author_name");
		try {
			String url = "Url to jdbc";
			String user = "your User name";
			String pass = "Your Pass"
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,pass);
			String query = "INSERT INTO library(Book_name,Book_price,book_purchase,book_date,book_type,author_name) values(?,?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, book_name);
			pstmt.setInt(2, book_Price);
			pstmt.setString(3, book_buy);
			pstmt.setString(4, book_date);
			pstmt.setString(5, book_type);
			pstmt.setString(6, author_name);
			pstmt.execute();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!flag) {
			pw.print("Cant Insert Data");		
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
