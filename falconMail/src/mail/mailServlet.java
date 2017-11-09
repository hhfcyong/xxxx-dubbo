package mail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class mailServlet
 */
@WebServlet("/mailServlet")
public class mailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public mailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String tos = request.getParameter("tos");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String[] sourcetos = tos.split(",");
			// 这个类主要是设置邮件
			MailSenderInfo mailInfo = new MailSenderInfo();
			mailInfo.setMailServerHost("邮箱地址");
			mailInfo.setMailServerPort("25");
			mailInfo.setValidate(true);
			mailInfo.setUserName("账号");
			mailInfo.setPassword("密码");// 您的邮箱密码
			mailInfo.setFromAddress("发送邮箱");
			for (int i = 0; i < sourcetos.length; i++) {
				mailInfo.setToAddress(sourcetos[i]);
				mailInfo.setSubject(subject);
				mailInfo.setContent(content);
				// 这个类主要来发送邮件
				SimpleMailSender sms = new SimpleMailSender();
				sms.sendTextMail(mailInfo);// 发送文体格式
				// SimpleMailSender.sendHtmlMail(mailInfo);//发送html格式
			}
		} catch (Exception ex) {
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String tos = request.getParameter("tos");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			String[] sourcetos = tos.split(",");
			// 这个类主要是设置邮件
			MailSenderInfo mailInfo = new MailSenderInfo();
			mailInfo.setMailServerHost("mail.yonyou.com");
			mailInfo.setMailServerPort("25");
			mailInfo.setValidate(true);
			mailInfo.setUserName("zhangyongw");
			mailInfo.setPassword("upgs2014");// 您的邮箱密码
			mailInfo.setFromAddress("zhangyongw@yonyou.com");
			for (int i = 0; i < sourcetos.length; i++) {
				mailInfo.setToAddress(sourcetos[i]);
				mailInfo.setSubject(subject);
				mailInfo.setContent(content);
				// 这个类主要来发送邮件
				SimpleMailSender sms = new SimpleMailSender();
				sms.sendTextMail(mailInfo);// 发送文体格式
				// SimpleMailSender.sendHtmlMail(mailInfo);//发送html格式
			}
		} catch (Exception ex) {
		}
	}

}
