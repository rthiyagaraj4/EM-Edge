<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created	
27/06/2013	  IN041228		Ramesh G	 Review Results->Click on Result Hyperlink->Click on any Lab results->HTML tags displayed in Result
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,java.sql.*, eOR.* ,eOR.Common.*,eCommon.Common.*,java.text.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>
<%
	request.setCharacterEncoding("UTF-8");
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ReviewResults" ;
	String bean_name = "eOR.ReviewResults";

	ReviewResults bean = (ReviewResults)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(localeName);
	
	String accession_num = request.getParameter("accession_num");
	String hist_data = bean.getClobData(accession_num);
	//Below Code is added by Archana Dhal on 11/22/2010 related to incident no IN025032.
	String temp = "";
    String value = "";
    String strToken = ""; 
	String practitioner_name = "";
	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);
	StringBuffer displaydata = new StringBuffer();
	java.util.StringTokenizer remarksTokens = new java.util.StringTokenizer(hist_data,"\n");
		try
	{
	
	  String sql1 = " select am_get_desc.am_practitioner(practitioner_id,?,2) practitioner_name from cr_encounter_detail where accession_num=?";
	  stmt = con.prepareStatement(sql1);
	  stmt.setString(1,locale);
	  stmt.setString(2,accession_num);
	  rs = stmt.executeQuery();
	  while(rs.next())
	  {	
		  practitioner_name=rs.getString("practitioner_name");		   
	   }
	
	while(remarksTokens.hasMoreTokens() )
	{
		strToken = remarksTokens.nextToken();
		 if(strToken.indexOf("Reviewed by")!=-1)
		{
		   temp   = strToken.substring(14,27);
		   temp = practitioner_name;
		   displaydata.append(strToken.substring(0,14));
		   displaydata.append(temp);
		  if(strToken.indexOf("On")!=-1)
			{
		      value = strToken.substring(31, strToken.length());
		      value	= com.ehis.util.DateUtils.convertDate(value,"DMYHM","en",locale);
			  displaydata.append(strToken.substring(27,31));
			  displaydata.append(value);
			  displaydata.append("\n");
			}		
		}
		else
		{
			displaydata.append(strToken);
			displaydata.append("\n");
		}
			
	}

//	out.println(accession_num);
	//if(accession_num==null)	accession_num="";

//  out.println("template_id= "+row_index+"templateText="+templateText);
%>

<html>
<head>
	<title><fmt:message key="Common.Result.label" bundle="${common_labels}"/></title>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 

</head>

<body style='background-color:#E2E3F0;' OnMouseDown="CodeArrest()"; onKeyDown="lockKey()"; width='100%' height='100%' >
<FORM name='result_clob_data_view' id='result_clob_data_view' METHOD=POST>
<table cellpadding=3 cellspacing=0 border=0 width='100%' height='100%' align=center>
<!-- IN041228 Start. -->
<!--
<tr><td><TEXTAREA class="COMMENTS" NAME="" ROWS="25" COLS="80" readonly><//%=displaydata.toString()%></TEXTAREA></td></tr>
<tr><td class='button'>
<INPUT TYPE="button"  class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick='window.close()'></td></tr>
-->
<tr><td><%=displaydata.toString()%></td></tr>
<!-- IN041228 End. -->
</table>
</FORM>
<%

	putObjectInBean(bean_id,bean,request);
%>
</BODY>
</HTML>
<%
    if (rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	}
	catch(Exception ex)
	{
				//out.println("Exception in ViewResultClobData.jsp"+ex.toString());//COMMON-ICN-0181
				 ex.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if (con!=null) ConnectionManager.returnConnection(con,request);
	}//end 
%>

