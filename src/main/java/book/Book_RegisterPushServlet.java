package book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.BookDto1;

/**
 * Servlet implementation class Book_RegisterPushServlet
 */
@WebServlet("/Book_RegisterPushServlet")
public class Book_RegisterPushServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book_RegisterPushServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			int isbn = Integer.parseInt(request.getParameter("isbn"));
			String name = request.getParameter("name");
			String auther = request.getParameter("auther");
			String publisher = request.getParameter("publisher");
			
			BookDto1 book = new BookDto1(-1,isbn,name,auther,publisher);
			
			int result = Dao.register(book);
			
			if(result == 1) {
				String view = "WEB-INF/view/register_success.jsp";			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}else {
				String view = "WEB-INF/view/book_register.jsp?error=1";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}
		}finally {
			
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
