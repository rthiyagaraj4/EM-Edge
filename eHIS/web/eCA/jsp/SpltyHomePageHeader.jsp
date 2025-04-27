<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
%>

<html>
<title><fmt:message key="eCA.ViewSpecialtyEventHistory.label" bundle="${ca_labels}"/></title>
<head> 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language='javascript' src='../../eCA/js/SpltyHomePage.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onKeyDown='lockKey()'>
<form name='SpltyHomeHeaderForm' id='SpltyHomeHeaderForm'>
<table border='0' width='100%' height='100%' id='headertable' cellpadding='3' cellspacing='0' align='center'>
<%
String disc_id="";
String disc_desc="";
String disc_value="";
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
String cycle_no = request.getParameter("cycle_no")==null?"":request.getParameter("cycle_no");

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try
	{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement("SELECT DISCR_MSR_ID,AM_GET_DESC.AM_DISCR_MSR(DISCR_MSR_ID,?,'1') DISCR_MSR_DESC,DISCR_MSR_VALUE FROM CA_PAT_SPLTY_KEY_MSR WHERE PATIENT_ID =? AND MODULE_ID  =? AND CYCLE_NO   =?");
		try
		{

			pstmt.setString(1,locale);
			pstmt.setString(2,patient_id);
			pstmt.setString(3,module_id);
			pstmt.setString(4,cycle_no);
			
			rs = pstmt.executeQuery();
			int i=0;

			while (rs.next())
			{
				disc_id = rs.getString(1);
				disc_desc = rs.getString(2);
				disc_value= rs.getString(3);
				
%>
<%if(i%2==0){%>
	<TR>
<%}%>
<TD class='label'><%=disc_desc%></TD><TD class='label'>:&nbsp;</TD><TD class='label' ><B><%=disc_value%></B></TD>
<%if(i%2!=0){%>
	</TR>
<%}%>
<%
	i++;
			}
if(i%2!=0){%>
	<TD class='label'></TD><TD class='label'></TD><TD class='label'></TD></TR>
<%}
		}
		catch (Exception ee1)
		{
			//out.println(ee1);//common-icn-0181
			ee1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
	}
	catch(Exception e)
	{
		//out.println(e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
	%>
</table>
</form>
</body>
</html>

