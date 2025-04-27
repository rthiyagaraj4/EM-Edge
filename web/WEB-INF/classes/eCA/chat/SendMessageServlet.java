/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
 * Created on Jun 25, 2004
 *
 * To change the template for this generated file go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */

/**
 * @author ankursetia
 *
 * To change the template for this generated type comment go to
 * Window>Preferences>Java>Code Generation>Code and Comments
 */
package eCA.chat;
import javax.servlet.*;
import javax.servlet.http.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import java.util.*;
import java.io.*;
import javax.naming.*;

public class SendMessageServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException 
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		HashMap map			= new HashMap();
		HttpSession session = request.getSession();

		PrintWriter out = response.getWriter();

		String loginUserId = (String)session.getValue("login_user");
		String sendToUser = request.getParameter("sendTo").equals("")?"":request.getParameter("sendTo");
		String sendToUserRespId = request.getParameter("sendToRespId") == null ?"":request.getParameter("sendToRespId");
		String message = request.getParameter("message").equals("")?"":request.getParameter("message");
		String HTMLStart ="<font face ='Comic Sans MS' color=red style='font-weight:2'>";
		String HTMLEnd  = "</font>";
		String messageText = HTMLStart + message + HTMLEnd;
		String loginUserText = HTMLStart + loginUserId + HTMLEnd;
		String sendToUserText = HTMLStart + sendToUser + HTMLEnd;
				
		//create a chat Entry
		ChatEntry chatEntry = new ChatEntry(loginUserId,message);
		//putting the message into the application for the recipent
		try
		{
			Context ctx = new InitialContext();
			map = (HashMap)ctx.lookup("chat");
			ChatMessages chatMsg = (ChatMessages)map.get(sendToUser+"~"+sendToUserRespId);

			synchronized (chatMsg)         //synchronize the block so that multiple user cannot access at the same time
			{
				chatMsg.addChatEntry(chatEntry);
			}						
			/*HashMap map1 = (HashMap)ctx.lookup("chat");
			ChatMessages test = (ChatMessages)map1.get(sendToUser);*/
			
			out.println("<html>");
			out.println("<head>");	
			out.println("<link rel='stylesheet' type='text/css' href='../../eCA/html/IMStyleSheet.css'></link>");
			out.println("<script src='../eCA/js/InstantMessengerChat.js' language='javascript'></script>");
			out.println("</head>");	
			out.println("<body>");		
			out.println("<script>");	
			
			//printing the messages on the sender's table
			out.println("parent.sendtextframe.document.forms(0).to_user.value=\""+sendToUser+"\"");
			out.println("var rowvar = parent.frames(0).document.all.chattable.insertRow();");
			out.println("var cellvar = rowvar.insertCell();");
			out.println("cellvar.insertAdjacentHTML(\"BeforeEnd\",\""+loginUserText+"\");");
			out.println("cellvar = rowvar.insertCell();"); 
			out.println("cellvar.insertAdjacentHTML(\"BeforeEnd\",\""+sendToUserText+"\");");		
			out.println("cellvar = rowvar.insertCell();");
			out.println("cellvar.insertAdjacentHTML(\"BeforeEnd\",\""+messageText+"\");");			
			out.println("parent.sendtextframe.document.forms(0).instantsendmsg.value = \"\";");
			out.println("parent.frames(0).document.all.chattable.scrollIntoView(false);");
			out.println("setTimeout(\"alignHeading()\",300);");
			out.println("</script>");	
			out.println("</body>");
			out.println("</html>");
		}
		catch(Exception e)
		{
			out.println(e);
		}
		//if(map != null) map.clear();
	}	
}
