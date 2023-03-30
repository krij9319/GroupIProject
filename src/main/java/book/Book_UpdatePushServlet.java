package book;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.BookDto4;

/**
 * Servlet implementation class Book_UpdatePushServlet
 */
@WebServlet("/Book_UpdatePushServlet")
public class Book_UpdatePushServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Book_UpdatePushServlet() {
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
			
			int id = Integer.parseInt(request.getParameter("id"));
			String register_day = request.getParameter("register_day");
			

			BookDto1 book = new BookDto1(id,isbn,name,auther,publisher,register_day);

			BookDto4 book = new BookDto4(id,isbn,name,auther,publisher);

			
			int result = Dao.update(book);
			
			if(result == 1) {
				String view = "WEB-INF/view/update_success.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}else {
				String view = "WEB-INF/view/book_update.jsp?error=1";
				RequestDispatcher dispatcehr = request.getRequestDispatcher(view);
				dispatcehr.forward(request, response);
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
