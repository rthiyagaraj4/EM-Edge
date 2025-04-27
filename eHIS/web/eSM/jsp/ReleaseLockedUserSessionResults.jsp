<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*, java.text.*,webbeans.eCommon.*,org.json.simple.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
		String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
	<script src="../../eSM/js/ReleaseLockedUserSession.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onKeyDown = 'lockKey()'  OnMouseDown="CodeArrest();">
	<%
	Connection con = null;
	try{
		request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		
		String reqUserId = (request.getParameter("userID")==null || request.getParameter("userID")=="")?"":request.getParameter("userID");
		
		JSONObject json 	= new JSONObject();
		JSONArray userListArr = new JSONArray();
		json  = eSM.SMCommonBean.getUserSessionDetails(con, reqUserId);
		String classValue = "";
		userListArr = (JSONArray)json.get("userListArr");
		
		if(userListArr.size() == 0) {
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script>parent.mainFrame.location.reload();</script>");
		}else{
			%>
			<form name='userDetails' id='userDetails' action='../../servlet/eSM.ReleaseLockedUserSessionServlet' method='post'  target='messageFrame' >
			<table border='1' cellpadding='0' cellspacing='0'   width="99%"  id='userResults' align="center">
				<tr>
					<th class="columnheader"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
					<th class="columnheader"><fmt:message key="Common.username.label" bundle="${mr_labels}"/></th>
					<th class="columnheader"><fmt:message key="Common.LoginDateTime.label" bundle="${mr_labels}"/></th>
					<th class="columnheader"><fmt:message key="Common.workstation.label" bundle="${mr_labels}"/></th>
					<th class="columnheader"><fmt:message key="Common.delete.label" bundle="${mr_labels}"/></th>
				</tr>
				<%
					
					for(int i = 0 ; i < userListArr.size() ; i++)  {

						JSONObject jsonDtls	= (JSONObject)userListArr.get(i);
						String userID  = (String) jsonDtls.get("USERID");
						String userName  = (String) jsonDtls.get("USERNAME");
						String loginDate  = (String) jsonDtls.get("LOGINDATE");
						String workStation  = (String) jsonDtls.get("WORKSTATION");
						if(i%2 == 0 )
							classValue = "QRYEVENSMALL" ;
						else
							classValue = "QRYODDSMALL" ;
				%>
						<tr>
							<td class='<%=classValue%>'><%=userID%>&nbsp;</td>
							<td class='<%=classValue%>'><%=userName%>&nbsp;</td>
							<td class='<%=classValue%>'> <%=loginDate%>&nbsp;</td>
							<td class='<%=classValue%>'><%=workStation%>&nbsp;</td>
							<td class='<%=classValue%>'><input type='checkbox' name='userChkBox' id='userChkBox' value='<%=userID%>' />&nbsp;</td>
						</tr>	
				<%
					}
				%>
			</table>
			<input type='hidden' name='finalData' id='finalData' id='finalData"' value="" />
			</form>
		<%
		}
	}catch(Exception e){out.println(e);
				e.printStackTrace();
}finally {
	try{
		ConnectionManager.returnConnection(con,request);
	}catch(Exception e) {}
}
%>
</body>

</html>

