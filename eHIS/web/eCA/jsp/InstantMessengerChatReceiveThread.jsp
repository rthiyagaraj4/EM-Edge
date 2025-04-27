<!DOCTYPE html>
<%@ page import="javax.naming.*,eCA.chat.ChatMessages, eCA.chat.ChatEntry,java.io.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<title><fmt:message key="eCA.ReceiveMessage.label" bundle="${ca_labels}"/>
</title>
<!--to refresh the page every 15 seconds-->
<META HTTP-EQUIV="REFRESH" CONTENT="15; URL='InstantMessengerChatReceiveThread.jsp'">
<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
<script src='../../eCA/js/InstantMessengerChat.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<script>
setTimeout("alignHeading()",300);
</script>
<%
request.setCharacterEncoding("UTF-8");
String receiveUser ="";
String message = "";
String loginUserId = (String)session.getValue("login_user");
String responsibilityId  = (String)session.getValue("responsibility_name");
HashMap map = null;
Context ctx = null;

try
{
	ctx = new InitialContext();
	map = (HashMap)ctx.lookup("chat");
/*	out.println(map);
	out.println("LoginUser ID :"+loginUserId);*/
	ChatMessages chatMsg = (ChatMessages)map.get(loginUserId+"~"+responsibilityId);

	try
	{
		//iterating through the hashMap to get the messages.
		ChatEntry chatentry = null;
	
		if(chatMsg.getSize()!=0)
		{
			%>
			<script>
			//if any message is received while the window is minimized, it gets the focus
			parent.window.focus();
			</script>
			<%
		}
		out.println("<form name =\"blankframe2\">");	
		out.println("<script>");
		out.println("var rowvar = ''; ");
		out.println("var cellvar =''; ");
		//getting all the messages from the chatMessages
		for(int i = 0;i < chatMsg.getSize();i++)
		{
			chatentry = chatMsg.getChatEntry(i);
			receiveUser =(String) chatentry.getSenderName();
			message = (String) chatentry.getMessage();
			String HTMLStart = "<font face ='Comic Sans MS' color=blue style='font-weight:2'>";
			String HTMLEnd  = "</font>";
			String messageText = HTMLStart + message + HTMLEnd;
			String loginUserText = HTMLStart + loginUserId + HTMLEnd;
			String receiveUserText = HTMLStart + receiveUser + HTMLEnd;
						
			//putting the same values in the table of the receiver
			out.println("rowvar = parent.frames[0].document.getElementById('chattable').insertRow();");
			out.println("cellvar = rowvar.insertCell();");
			out.println("cellvar.insertAdjacentHTML(\"BeforeEnd\",\""+receiveUserText+"\");");
			out.println("cellvar = rowvar.insertCell();"); 
			out.println("cellvar.insertAdjacentHTML(\"BeforeEnd\",\""+loginUserText+"\");");		
			out.println("cellvar = rowvar.insertCell();");
			out.println("cellvar.insertAdjacentHTML(\"BeforeEnd\",\""+messageText+"\");");			
			out.println("parent.frames[0].document.getElementById('chattable').scrollIntoView(false);");
			out.println("parent.sendtextframe.document.forms[0].instantsendmsg.focus();");
		}
		out.println("</script>");
		out.println("</form>");
		chatMsg.clearChatEntries();
	}
	catch(Exception e)
	{
	//out.println(e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
	}
}
catch(Exception ee)
{
	//out.println(ee);//COMMON-ICN-0181
	ee.printStackTrace();//COMMON-ICN-0181
}
finally
{
	//map.clear();
}
%>
</body>
</html>

