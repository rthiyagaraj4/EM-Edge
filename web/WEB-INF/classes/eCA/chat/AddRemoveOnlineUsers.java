/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eCA.chat;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.naming.*;
import java.util.*;

public class AddRemoveOnlineUsers extends HttpServlet 
{		
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession(false);

		String loginUserId			= (String)session.getValue("login_user");
		String responsibilityId		= (String)session.getValue("responsibility_name");
		String action				= request.getParameter("action")==null?"":request.getParameter("action");

		try
		{
			Context ctx = new InitialContext();

			HashMap map;

			try
			{
				map = (HashMap)ctx.lookup("chat");
			}
			catch(NameNotFoundException nm)
			{
				ctx.bind("chat",new HashMap());
			}
			
			if(action.equals("add"))
			{
				addUser(loginUserId,responsibilityId);
				//RequestDispatcher disp = request.getRequestDispatcher("../eCA/jsp/InstantMessengerChatMain.jsp");
				RequestDispatcher disp = request.getRequestDispatcher("/eCA/jsp/InstantMessengerChatMain.jsp");
		
				disp.forward(request,response);
			}
			else if(action.equals("remove"))
			{
				removeUser(loginUserId,responsibilityId);
				response.getWriter().println("<SCRIPT>parent.window.close();</SCRIPT>");
			}
		}
		catch(NamingException e)
		{
			System.out.println("Exception in AddRemoveOnlineUsers.java --"+e.toString());
			e.printStackTrace(System.err);
		}
	
	}
	public  void addUser(String userId, String responsibilityId) throws NamingException
	{
		
		Context ctx = new InitialContext();
		HashMap map = (HashMap)ctx.lookup("chat");
		//it will put a new entry for the user at the application level
		ChatMessages chatMs = new ChatMessages();
		map.put(userId+"~"+responsibilityId,chatMs);
		//System.out.println("----- map from AddUsers ----"+map+"-----");
	}
	public  void removeUser(String userId, String responsibilityId) throws NamingException{
		Context ctx = new InitialContext();
		HashMap map = (HashMap)ctx.lookup("chat");
		//System.out.println("----- map from  removeUser ----"+map+"-----");
		//it will remove the entry for the user at the application level
		ChatMessages chatMsg = (ChatMessages)map.get(userId+"~"+responsibilityId);
		
		//System.out.println("----- chatMsg ----"+chatMsg+"-----");

		if(chatMsg != null)
		{
			synchronized (chatMsg)
			{
				//nullify the ChatMessages Object and remove the entry
				if(chatMsg != null) chatMsg = null;
			}
		}
		map.remove(userId+"~"+responsibilityId);
	}
}
