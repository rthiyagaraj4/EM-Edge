<!DOCTYPE html>
  <%@  page import="java.sql.*, webbeans.eCommon.* , java.io.*" contentType="text/html;charset=UTF-8" %>

  <!-- The following changes are done for Internationalisation Process
Added by Manivel Natarajan on 10/Aug/2006
-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
  <%
	
	//unused variable, commented on 09/06/05
	//String frame_size = "";
	Connection con = null; ;
	PreparedStatement pstmt = null ;
	ResultSet rs = null;
	String nd_detail_desc ="";
	String billing_group = "";	
	String locale			= (String)session.getAttribute("LOCALE");

	//The following changes are done for Internationalisation Process
//Added by Manivel Natarajan on 10/Aug/2006
	request.setCharacterEncoding("UTF-8");
	try
  	{
	
		con = ConnectionManager.getConnection(request);
		
		billing_group= request.getParameter("billing_group");
		if( billing_group == null) billing_group="";
		

		String sql="select replace(detail_desc,chr(10),' ') detail_desc from bl_blng_grp_lang_vw where language_id='"+locale+"' and blng_grp_id = '"+billing_group+"'";		

		
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery() ;
		if( rs != null ) 
		{
			while( rs.next() )
			{  
				nd_detail_desc = rs.getString("detail_desc");	
			}
		}
		if (rs != null)   rs.close();
		pstmt.close();	
		
		//frame_size = "5%,0%";
		
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con,request);
	}

	if (nd_detail_desc == null) nd_detail_desc = "";


	

	%>

<html>
	<head>
	<script>	
		function showblnggrpdesc()
				{
				document.forms[0].results.value = '<%=nd_detail_desc%>';
				 }
	</script>

		<title><fmt:message key="eBL.BILLING_GROUP_EXPLANATORY_NOTE.label" bundle="${bl_labels}"/></title>
		<!--
			<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
			-->
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

			<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- The following changes are done for Internationalisation Process
Commented by Manivel Natarajan on 10/Aug/2006 -->
<!--		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


			
	</head>

	<body onLoad='showblnggrpdesc();' onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect = "codeArrestThruSelect();">
	<form name='BlngGrpDescForm' id='BlngGrpDescForm' method='post' action=''>			
	 <TEXTAREA READONLY NAME="results" COLS="93" ROWS="4"></TEXTAREA><BR> 		 
	
	<input type= hidden name="locale" id="locale"  value='<%=locale%>'>
	</form>

	</body>

</html>



