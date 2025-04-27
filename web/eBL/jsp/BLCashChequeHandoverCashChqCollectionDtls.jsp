<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%	
	HttpSession httpSession = request.getSession(false);
	Properties p = (Properties)httpSession.getValue("jdbc");	
	String facility_id = "";
	String loginUser = "";
	String strCashCounterCode = "";
	//String strCashCounterArray = "";
//String strLogoutTime  = "",
String strLoginTime="";
	Connection con = null;
	String locale	= (String)session.getAttribute("LOCALE");
//	System.out.println("cash counter");
	try
	{
		facility_id = (String)httpSession.getValue("facility_id");
		loginUser =  p.getProperty("login_user");		
		con = ConnectionManager.getConnection(request);
		
	


%>

<html>
<head>
<script>
  
</script>
<%

				try
				{
					String sql1 = "	SELECT  SHORT_DESC, CASH_COUNTER_CODE,to_char(LOGIN_DATE_TIME,'dd/mm/yyyy hh24:mi:ss'), "+
					" to_char(sysdate,'dd/mm/yyyy hh24:mi:ss') "+
					" FROM    BL_CASH_COUNTER_LANG_VW "+
					" WHERE  CASH_CTR_IN_USE_BY = ? "+
					" AND    OPERATING_FACILITY_ID   = ? "+
					" AND language_id='"+locale+"' ORDER BY 1 ";


					PreparedStatement pstmt = con.prepareStatement(sql1);
					pstmt.setString(1, loginUser);
					pstmt.setString(2, facility_id);					
					ResultSet rs = pstmt.executeQuery() ;
					while(rs.next())
					{
						strCashCounterCode = rs.getString(2);						
						strLoginTime = rs.getString(3);						
					}
					rs.close();
					pstmt.close();
				}
				catch(Exception e)
				{
					out.println("Error cash col = "+e);
				}				
				
			
%>

<!--
<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'>
-->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src='../../eBL/js/BLCashChequeHandover.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




	<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();" >
	<form name='cashCheqinHandForm' id='cashCheqinHandForm' action='' target='' method=''>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
			<td class="COLUMNHEADER" colspan="15"><fmt:message key="eBL.CASH_CHEQ_COLL_DTLS.label" bundle="${bl_labels}"/></td>
			<tr>
				<td  width='25%' class='label'><b><fmt:message key="eBL.CASH_COLLECTION.label" bundle="${bl_labels}"/></b></td>
				<td width="25%" class="fields"><input type='text' name='cashInHand' id='cashInHand' value='' readonly style='text-align:right'></td> 
				<td  width='25%' class='label'><b><fmt:message key="eBL.CHEQ_COLLECTION.label" bundle="${bl_labels}"/></b></td>
				<td width="25%" class="fields"><input type='text' name='chequeInHand' id='chequeInHand' value='' readonly style='text-align:right'></td>
			</tr>	
		 </table>
		
		<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
			<tr>
				<tr><td class="COLUMNHEADER" colspan="15"><fmt:message key="eBL.HANDOVER_REQ_DTLS.label" bundle="${bl_labels}"/></td></tr>
			</tr>
		</table>
</form>
</body>
<%
}
	catch(Exception eX)
	{
			out.println("Handover Cash collection "+eX);
	}
	finally
		{
		ConnectionManager.returnConnection(con, request);
		}
%>
</html>

