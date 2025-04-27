<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="CommonInclude.jsp"%>
<head>
  <%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
			<script src='../../eCommon/js/common.js' language='javascript'></script>

	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

	
<script language="JavaScript">
	function reportOptionChange( option ) {
		var destype = option.value ;

		document.location.href="report_options_form.jsp?destype=" + destype ;
		return true ;
	}
	function callMethod()
	{
	document.forms[0].dummy.style.visibility='hidden'
	
	}
</script>

<%
	Connection con = null;
	try{
		request.setCharacterEncoding("UTF-8");
	con=ConnectionManager.getConnection(request);
	String destype	= request.getParameter( "destype" ) ;
	String login_user	= (String) session.getValue( "login_user" ) ;
	String report_dir	= "" ;
	String file_name	= "" ;
	String report_dir_path="";

	if ( destype	== null ) destype		= "V" ;
	if ( login_user 	== null ) login_user 	= "" ;

	if ( destype.equals( "F" ) || destype.equals( "V" )) {
//		Connection con = (Connection) session.getValue( "connection" ) ;
	  
		PreparedStatement pstmt = con.prepareCall( "select report_base_dir, dir_path_separator,report_dir from sm_db_info" ) ;
		ResultSet rs = pstmt.executeQuery() ;

		if ( rs != null && rs.next() ) {
			String report_base_dir		= rs.getString( "report_base_dir" ) ;
			String dir_path_separator	= rs.getString( "dir_path_separator" ) ;
			 report_dir_path	= rs.getString( "report_dir" ) ;

			report_dir 	= report_base_dir + dir_path_separator + login_user + dir_path_separator ;
			java.text.SimpleDateFormat dateTimeFormat = new java.text.SimpleDateFormat( "yyyyMMddHHmmss" ) ;
			String currentDateTime = dateTimeFormat.format( new java.util.Date() ) ;

			file_name = currentDateTime ;
		}
		rs.close();
		pstmt.close();
	}
	
%>
</head>
<body onLoad='callMethod()' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>

<center>
	<form name="report_options_form" id="report_options_form">

		<br>

		<table width='100%' cellpadding='2' cellspacing='0'>

			<tr>
				<td  width='60%' style="white-space: nowrap;text-align:center"" class='label'>
					<fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/>
				</td>

				<td>
					<select name="destype" id="destype" onChange="reportOptionChange(this);">
						<%
							if ( destype.equals( "V" ) )
								{
								%><option value ='V' selected><fmt:message key="Common.view.label" bundle="${common_labels}"/>  &nbsp;&nbsp;<%
								}else
								{					
								%> <option value ='V'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp;&nbsp;<%
								}

							if ( destype.equals( "P" ) )
									{
								%><option value ='P' selected><fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/> &nbsp;&nbsp;<%
									}else{
								%><option value ='P'><fmt:message key="eSM.Printer.label" bundle="${sm_labels}"/>&nbsp;&nbsp;<%
								}

							if ( destype.equals( "F" ) ){
							%><option value ='F' selected><fmt:message key="eMP.File.label" bundle="${mp_labels}"/>&nbsp;&nbsp;<%
							}else{
								%><option value ='F'><fmt:message key="eMP.File.label" bundle="${mp_labels}"/> &nbsp;&nbsp;<%
									
								}
						%>
					</select>
				</td>
			</tr>

			<%
				if ( destype.equals( "F" )  ) {
			%>
			<tr>
				<td  width='60%'  class='label' style="text-align:center">
					<fmt:message key="Common.FileFormat.label" bundle="${common_labels}"/>
				</td>

				<td>
					<select name="file_format" id="file_format">
						<option value ='pdf'>		PDF &nbsp;&nbsp;
						<option value ='htmlcss'>	HTML &nbsp;&nbsp;
						<option value ='rtf'>		RTF &nbsp;&nbsp;
						<option value ='xml'>		XML &nbsp;&nbsp;
						<option value ='spreadsheet'>  Spread Sheet&nbsp;&nbsp;
						</select>
				</td>
			</tr>

			<tr>
				<td  width='60%'  class='label' style="text-align:center">
					<fmt:message key="Common.FileName.label" bundle="${common_labels}"/>
				</td>

				<td>
					<input type="text" width='70%' name="file_name" id="file_name" value="<%= file_name %>" maxlength="45" >
					
				</td>
			</tr>
			<%
				}else if(destype.equals( "V" )){%>
							<tr>
				<td width='60%'  class='label' style="text-align:center">
					<fmt:message key="Common.FileFormat.label" bundle="${common_labels}"/>
				</td>

				<td>
					<select name="file_format" id="file_format">
						<option value ='pdf'>		PDF &nbsp;&nbsp;
						<option value ='spreadsheet'>     Spread Sheet&nbsp;&nbsp;
						</select>
				</td>
			</tr> 
				<%}
				
				if(destype.equals( "V" ) || destype.equals( "F")){
				%>	<input type="hidden" name="report_dir" id="report_dir" value="<%= report_dir %>"> <%
				}
			%>
		</table>

		<br>
		<input type="hidden" name="dummy" id="dummy" >
		<input type="hidden" name="report_dir_path" id="report_dir_path" value="<%=report_dir_path%>">
	</form>
</center>
	<%}catch(Exception e){
		System.err.println("Exception in report_options_form.jsp : "+e);
		out.println(e);
		}
		finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}
		%>
</body>

