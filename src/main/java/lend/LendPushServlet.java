package lend;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dto.LendDto1;
import dto.LendDto2;

/**
 * Servlet implementation class LendPushServlet
 */
@WebServlet("/LendPushServlet")
public class LendPushServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LendPushServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		try {
			int account_id = Integer.parseInt(request.getParameter("account_id"));
			int book_id = Integer.parseInt(request.getParameter("book_id"));
			String scheduledday = request.getParameter("scheduledday");	
			Date day = new Date();
			
			LendDto1 book1 = new LendDto1(-1,account_id,book_id);
			LendDto2 book2 = new LendDto2(book_id);
			
			int result = Dao.lendday(book1);
			
			// 図書IDを元にDBを検索して、本の登録日を取得する
			Date days = Dao.date(book2);
			// 取得した登録日を元に1年以内かどうかで新/旧を判断する
			if(day.before(days)) {
				// 判断に応じてlend7 or lend14 を呼び出して貸出テーブルにINSERT
				result = Dao.lend7(book2);
			}else {
				result = Dao.lend14(book2);
			}
			
			if(result >= 1) {
				String view = "WEB-INF/view/lend_success.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
			}else {
				String view = "WEB-INF/view/lendinput.jsp?error=1";
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
