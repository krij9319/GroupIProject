package accountservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AccountDAO;
import dto.Account;
import util.GenerateHashedPw;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getParameter("UTF-8");
		
		String mail = request.getParameter("mail");
		String pw = request.getParameter("pw");
		
		// 入力されたIDをもとにソルトを取得する。
		String salt = AccountDAO.getSalt(mail);
		
		// 取得したソルトがnullの場合は対象のユーザがいないので、Errorでログイン画面に戻す
		if(salt == null) {
			String view = "./?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
			return;
		}
		
		// 取得したソルトを使って入力したPWをハッシュ
		String hashedPw = GenerateHashedPw.getSafetyPassword(pw, salt);
		
		// 入力されたID、ハッシュしたPWに一致するユーザを検索する
		Account accountuser = AccountDAO.login(mail, hashedPw);
		int situation = AccountDAO.situation2(mail);
		
		// 一致するユーザがいなければ、ログイン失敗
		if(accountuser == null) {
			String view = "./?error=1";
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		} else {
			// ログイン情報をセッションに登録
			HttpSession session = request.getSession();
			session.setAttribute("user", accountuser);
			  String redirectUrl ="";
			    if(situation == 1){
			    	System.out.println(situation);
			      redirectUrl = "WEB-INF/view/adminmenu.jsp";
			      RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl);
			      dispatcher.forward(request, response);
			    		  
			    } else {
			    	System.out.println(situation);
			    	redirectUrl = "WEB-INF/view/menu.jsp";
			    	RequestDispatcher dispatcher = request.getRequestDispatcher(redirectUrl);
			    	dispatcher.forward(request, response);
			    }

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
