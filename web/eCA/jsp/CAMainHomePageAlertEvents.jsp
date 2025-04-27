<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language=javascript src='../../eCA/js/CAMainMyTasks.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

</script>
</head>

<%
	Connection con=null;
	PreparedStatement  pstmt=null;
	ResultSet rset=null;
	String strMessage = "";
	
	try
	{
			String sql="SELECT DISTINCT ALERT_MSG FROM CA_CLIN_ALERT /*WHERE PRACTITIONER_ID=? OR PRACTITIONER_ID='*ALL'*/ ";
			con=ConnectionManager.getConnection(request);
			pstmt=con.prepareStatement(sql);
			rset=pstmt.executeQuery();

			while (rset.next())
			{
				strMessage =strMessage + "\\n"+rset.getString("ALERT_MSG");					
			}
			if(strMessage == null) strMessage = "";
			if(!strMessage.equals(""))
			{
				strMessage = strMessage +getMessage(locale,"CONF_RDT_MAIN_PAGE","CA");  
				//getMessage("CONF_RDT_MAIN_PAGE","CA");
				//strMessage = strMessage.substring(2);
			}
			if(rset != null) rset.close();
			if(pstmt != null) pstmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception in CAMainHomePageAlertEvents.jsp:"+e.toString());//common-icn-0181
		        e.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if (con!=null) ConnectionManager.returnConnection(con,request);
		}

%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<!-- <META CONTENT='10; URL=CAMainHomePageAlertEvents.jsp?<%=request.getQueryString()%>' HTTP-EQUIV="REFRESH"> -->
</body>
</html> 
<%if(!strMessage.equals("")){%>
	<script>
		
		if(confirm("<%=strMessage%>")){
			top.content.workAreaFrame.location.href="../../eNM/jsp/BedManagementMain.jsp?<%=request.getQueryString()%>";
			top.content.CommonToolbar.displayFunctionName("Nursing Activity");
			top.content.alertFrame.location.href="../../eCA/jsp/CAMainHomeRemoveAlerts.jsp?<%=request.getQueryString()%>";				
		}else{
			top.content.alertFrame.location.href="../../eCA/jsp/CAMainHomeRemoveAlerts.jsp?<%=request.getQueryString()%>";
		}

	</script>	
	<%}
	else
	{%>
	<script>top.content.alertFrame.location.href="../../eCommon/jsp/error.jsp";</script>		
<%}%>

<%!
	private String getMessage(String locale, String messageId, String moduleId)
	{
        java.util.Hashtable message = MessageManager.getMessage(locale,messageId,moduleId);
		String mesg = (String) message.get("message");
		message.clear();
        return(mesg) ;
    }
%>

