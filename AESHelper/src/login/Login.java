package login;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import loginClass.AESHelper;
import loginClass.ZongXing;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opr = request.getParameter("opr");
		if (opr.equals("jhns")) {
			loginJHNS(request, response);
		} else if (opr.equals("hgt")) {
			loginHGT(request, response);

		} else if (opr.equals("yuanqu")) {
			loginYuan(request, response);
		}

	}

	private void loginJHNS(HttpServletRequest request, HttpServletResponse response) {
		String username = "jhns";// 固定账号
		String password = "123456";// 固定密码
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 获取当前时间
		String content = df.format(day) + "|" + username + "|" + password;
		AESHelper aes = new AESHelper();// 创建加密对象
		String secret = "iotcommiotcommio";// 加密秘钥
		System.out.println(content);
		try {

			String skey = aes.encrypt(content, secret);// 加密方法
			System.out.println("加密的内容：" + skey);
			response.sendRedirect("http://zlxt.iotcomm.com:8087/monitor/module/pub/user/linkLogin.action?skey=" + skey);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void loginHGT(HttpServletRequest request, HttpServletResponse response) {
		String username = "hgt";// 固定账号
		String password = "hgt";// 固定密码
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 获取当前时间
		String content = df.format(day) + "|" + username + "|" + password;
		AESHelper aes = new AESHelper();// 创建加密对象
		String secret = "iotcommiotcommio";// 加密秘钥
		System.out.println(content);
		try {

			String skey = aes.encrypt(content, secret);// 调用加密方法
			System.out.println("加密的内容：" + skey);
			response.sendRedirect("http://182.106.128.243:8181/monitor/module/pub/user/linkLogin.action?skey=" + skey);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void loginYuan(HttpServletRequest request, HttpServletResponse response) {
		String username = "JHZM";// 固定账号
		String password = "aJHZM001";// 账号密码
		ZongXing zx = new ZongXing();// 创建加密对象
		String pwd = username + ":" + password;
		String signal = zx.encode(pwd.getBytes());
		System.out.println("加密的内容" + signal);
		Date day = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 获取当前时间
		String time = df.format(day);
		Long jeid;
		try {
			jeid = Long.valueOf((df.parse(time).getTime() / 1000));

			try {
				System.out.println("时间戳为" + jeid);
				response.sendRedirect("http://118.178.95.186:25450/teamcms/loginNoAuth?signal=" + signal + "&username="
						+ username + "&jeid=" + jeid);
				// response.sendRedirect("http://ledaips/teamcms/loginNoAuth?signal="+signal+"&username="+username+"&jeid="+jeid);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
