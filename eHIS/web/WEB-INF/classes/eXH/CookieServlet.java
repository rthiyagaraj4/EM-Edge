/***************************************************************************************************************
 * Author   :   Ravindranath
 * Desc     :	For handling cookies
 ***************************************************************************************************************/
package eXH;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet
{ 
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException
	{
		String cookieKey = request.getParameter("cookieKey");
		String cookieVal = request.getParameter("cookieVal");

		Cookie cookie = new Cookie(cookieKey, cookieVal);
		cookie.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(cookie);
	}
}