<!DOCTYPE html>
<!--
*	Copyright © ibaHealth Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Created By		:	Ajay Hatwate 
*	Created On		:	22 Dec 2022
-->
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.util.HashMap, com.ehis.eslp.* ,java.net.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<!-- JSP Page specific attributes end -->
<!--Mandatory declarations start-->
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<jsp:useBean id="DiagnosysSetBean" class="webbeans.eCommon.RecordSet" scope="request"/> 
<%-- Mandatory declarations end --%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<!-- <Script src="../../eCommon/js/jquery-3.6.3.js" language="JavaScript"></Script> -->
	

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<script language="javascript" src="../js/DiagnosisCategory.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
	 request.setCharacterEncoding("UTF-8");
	 
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 
	 String locale=(String)session.getAttribute("LOCALE");

	 String mode=request.getParameter("mode");
	 String diagCatCode="";
	 String long_desc="";
	 String short_desc="";
	 String diag_class_type="";
	 String eff_status="";
	
	 Connection con =null;
	PreparedStatement pstmt=null ;
	Statement stmt=null;
	//Statement stmt1=null;
	ResultSet reset=null;
	ResultSet reset1=null;
	
	String diagTypecode="";
	String shortdesc="";
	//boolean newVisitType=true;
	String termSetId=" ";

	//String checkValue="D";
	String checked="";

	int i=0;
	int j=0;

	int max_record=0;
	//String selected="selected";
	String CheckValue;
	
	 String readOnly=" ";
	 String readOnlyMod=" ";
	String status="checked";
	String disable="";
	String Display_TD_Default= "display:none;";
	try{
	con = ConnectionManager.getConnection(request);
	 if(mode.equals("modify"))
	 {
		readOnly="readonly";

		 diagCatCode=checkForNull(request.getParameter("diag_catg_code"));
		 
		
		//con=ConnectionManager.getConnection(request);			
			/*Added by Maheshwaran for the SKR-CRF-0020 as on 07/05/2012*/
			/*Default Status Column was added in the select query*/
			pstmt = con.prepareStatement("select a.long_desc ,a.short_desc, a.eff_status  from mr_diag_category a where a.diag_catg_code =?");
			pstmt.setString(1,diagCatCode);
			reset=pstmt.executeQuery();
			
			if( reset != null )
			{
			 
					while(reset.next( )){
						long_desc=reset.getString("long_desc")==null ? "":reset.getString("long_desc");
						short_desc=reset.getString("short_desc")==null ? "":reset.getString("short_desc");
						eff_status=reset.getString("EFF_STATUS");
						
						if(eff_status.equals("E"))
						{
							status="checked";
							readOnlyMod=" ";
							 disable="";
						}
						else if(eff_status.equals("D")) 
						{
							status="";
							readOnlyMod="readonly";
							disable="disabled";
						}

					}
			 }
	 }
	
%>

<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="FocusFirstElement()">
<form name="diagnocategory_form" id="diagnocategory_form" action="../../servlet/eMR.DiagnosisCategoryServlet" method="post" target="messageFrame">
<table border="0" cellpadding="5" cellspacing="0" width="90%" align='center'>
<tr>
      <td  class="label" width="50%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
      <td  class='fields' width='50%' >
      <input type="text" name="diag_catg_code" id="diag_catg_code"  value="<%=diagCatCode%>" size="5" maxlength="5" onBlur='ChangeUpperCase(this);' <%=readOnly%> onKeyPress="return CheckForSpecChars(event)" > <img src='../../eCommon/images/mandatory.gif'></img>
      </td>
    </tr>

	<tr>
      <td class="label" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
      <td  class='fields'><input type="text" name="long_desc" id="long_desc" value="<%=long_desc%>" size="40" maxlength="40" <%=readOnlyMod%> onBlur='ValidString(this)' style='{ font-size: ;}' ><img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>

	<tr>
      <td class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
      <td class='fields' ><input type="text" name="short_desc" id="short_desc" value="<%=short_desc%>" size="20" maxlength="20"  <%=readOnlyMod%> onBlur='ValidString(this)' ><img src='../../eCommon/images/mandatory.gif'></img></td>
    </tr>


<tr>
	<td  class="label" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td  class='fields' ><input type="checkbox" name="eff_status" id="eff_status" value="<%=eff_status%>" value="E" <%=status%> ></td>
</tr>
	<tr> </tr><tr> </tr><tr> </tr><tr> </tr><tr> </tr><tr> </tr><tr> </tr><tr> </tr><tr></tr>
	<tr>

<%
if (reset != null) reset.close();
if (pstmt != null) pstmt.close();
if(stmt!=null) stmt.close();
if(reset1 !=null) reset1.close();
}catch(Exception e){
	//out.println(e.toString());
	e.printStackTrace();
}finally{
    ConnectionManager.returnConnection(con,request);
}

%>
</tr>

	
</table>


<input type='hidden' name='tot_cnt' id='tot_cnt' value='<%=max_record%>'>
<input type='hidden' name='final_termSet' id='final_termSet' value='<%=termSetId%>'>
<!--<input type='hidden' name='final_ModTermSet' id='final_ModTermSet' value='<%=termSetId%>'>-->
<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
<input type='hidden' name='diag_class_type1' id='diag_class_type1' value='<%=diag_class_type%>'>
<input type='hidden' name='defaulttermset' id='defaulttermset' id="defaulttermset" value=''>
</form>

</body>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	
%>

