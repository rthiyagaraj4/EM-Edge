<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<html>
<head>
	<%
          String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script>
	<script language="JavaScript" src="../../eSM/js/ReleaseLockedUserSession.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
    request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	Connection con = null;
	con = ConnectionManager.getConnection(request);
	try{
		String MULTIPLE_LOGIN_ALLOWED_YN = eSM.SMCommonBean.getMultiLoginDetails(con);
		if(MULTIPLE_LOGIN_ALLOWED_YN.equals("N")){
%>
		<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='mainFrame' id='mainFrame' 	src='../../eSM/jsp/ReleaseLockedUserSessionForm.jsp' frameborder=0 scrolling='no' style='height:11vh;width:100vw'></iframe><iframe name='resultFrame' id='resultFrame' 	src='../../eSM/jsp/ReleaseLockedUserSessionResults.jsp' frameborder=0 style='height:72vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<%
		}else {
			out.println("<script>alert(getMessage('MULTI_USER_ALLOWED','SM'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
		}
	}catch(Exception e){ 
			e.printStackTrace();	
		}finally{ 
			if(con != null){
				ConnectionManager.returnConnection(con,request);
			}	
		}                           
%>  


</html>

