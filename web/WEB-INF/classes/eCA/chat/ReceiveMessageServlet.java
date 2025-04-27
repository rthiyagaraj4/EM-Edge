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
import eCA.chat.*;
import java.util.*;
import java.io.*;
import javax.naming.*;

public class ReceiveMessageServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		HashMap map = new HashMap();


		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String receiveUser ="";
		String message = "";
		String loginUserId = (String)session.getValue("login_user");
		try
		{
			Context ctx = new InitialContext();
			map = (HashMap)ctx.lookup("chat");
			out.println(map);
			out.println("LoginUser ID :"+loginUserId);
			ChatMessages chatMsg = (ChatMessages)map.get(loginUserId); 
			
			try
			{
				//iterarating through the hashtable to get the messages.
				ChatEntry chatentry = null;
				out.println(chatMsg.getAllChatEntries());
				out.println(chatMsg.getSize());
				out.println("<html><head><META HTTP-EQUIV=\"REFRESH\" CONTENT=\"15; URL='../servlet/eCA.chat.ReceiveMessageServlet'\"></head>");
				out.println("<body>");
				out.println("<form name =\"blankframe2\">");	
				out.println("<script>");
				out.println("var rowvar = ''; ");
				out.println("var cellvar =''; ");
				for(int i = 0;i < chatMsg.getSize();i++)
				{
					chatentry = chatMsg.getChatEntry(i);
					receiveUser =(String) chatentry.getSenderName();
					message = (String) chatentry.getMessage();
					//putting the same values in the table
					out.println("rowvar = parent.frames(0).document.all.chattable.insertRow();");
					out.println("cellvar = rowvar.insertCell();");
					out.println("cellvar.insertAdjacentHTML(\"BeforeEnd\",z'"+receiveUser+"');");
					out.println("cellvar = rowvar.insertCell();"); 
					out.println("cellvar.insertAdjacentHTML(\"BeforeEnd\",'');");
					out.println("cellvar = rowvar.insertCell();");
					out.println("cellvar.insertAdjacentHTML(\"BeforeEnd\",'"+message+"');");
					out.println("parent.sendtextframe.document.forms(0).instantsendmsg.value = \"\";");
					out.println("parent.frames(0).document.all.chattable.scrollIntoView(false);");
									
				}
				out.println("</script>");
				out.println("</form>");
				out.println("</body>");
				out.println("</html>");	
				chatMsg.clearChatEntries();

			}
			catch(Exception e)
			{
				out.println(e);
			}
		}
		catch(Exception ee)
		{
			//out.println(ee);//common-icn-0181
			ee.printStackTrace();//COMMON-ICN-0181
		}
		if(map != null) map.clear();

	}				
}
