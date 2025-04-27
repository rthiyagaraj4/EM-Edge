<!DOCTYPE html>
<!-- Page created for  Operating Site Identification - IN:41808 -  11/11/2013  -->
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
  <%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
			<script src='../../eCommon/js/common.js' language='javascript'></script>

	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	</head>
	
	<script language="JavaScript">
	function reportOptionChange( option ) {
		var destype = option.value ;
		var patId = document.getElementById("patId").value;
		document.location.href="OperatingSiteIdentificationMain.jsp?destype=" + destype+"&Patient_ID="+patId ;
		return true ;
	}

	function CheckForAlphaNumeric(event){
    var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key

	return true ;
	}

	function CheckForZero(obj){
		if ( obj.value < 1) {
			alert("Number of copies should be greater than zero");
			obj.focus();
		}
	}
</script>

<%
	Connection con = null;
	Connection con1 = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs1 = null;

	String patientId = request.getParameter("Patient_ID");
	String destype	= request.getParameter( "destype" ) ;
	String locale = (String) session.getAttribute("LOCALE");
	String report_dir	= "" ;
	String file_name	= "" ;
	try{
		request.setCharacterEncoding("UTF-8");
		con=ConnectionManager.getConnection(request);
	
	String login_user	= (String) session.getValue( "login_user" ) ;


	if ( destype	== null ) destype		= "P" ;
	if ( login_user 	== null ) login_user 	= "" ;

	if ( destype.equals( "F" ) ) {	
		pstmt = con.prepareCall( "select report_base_dir, dir_path_separator from medstart.sm_db_info" ) ;
		rs = pstmt.executeQuery() ;

		if ( rs != null && rs.next() ) {
			String report_base_dir		= rs.getString( "report_base_dir" ) ;
			String dir_path_separator	= rs.getString( "dir_path_separator" ) ;

			report_dir 	= report_base_dir + dir_path_separator + login_user + dir_path_separator ;

			java.text.SimpleDateFormat dateTimeFormat = new java.text.SimpleDateFormat( "yyyyMMddHHmmss" ) ;
			String currentDateTime = dateTimeFormat.format( new java.util.Date() ) ;

			file_name = currentDateTime ;
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	
			}
			catch(Exception e){
				System.err.println("Exception is ->"+e);
			}
			finally{
				try{
					if(rs!=null) rs.close();
					if(pstmt!=null)	pstmt.close();
					if(con!=null) ConnectionManager.returnConnection(con,request);
				}
				catch(Exception e){
					System.err.println("Exception is ->"+e);
				}
			}%>

<body OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>

<center>
	<form name="report_options_form" id="report_options_form">

		<br>

		<table width='90%' cellpadding='0' cellspacing='0'>
		<%
		// Modified for IN:45519
		String sql1 = "select report_id, report_desc, module_id from sm_report_lang_vw where module_id = 'OT' AND REPORT_ID = 'OTOSIDEN' and language_id = '"+locale+"'";
 		%>
 		<tr>
			<td class="columnheadercenter" nowrap> 
				<fmt:message key="Common.reportname.label" bundle="${common_labels}"/>
			</td>
			<td class="columnheadercenter" nowrap> 
				<fmt:message key="eOT.PreferredLanguage.Label" bundle="${ot_labels}"/>
			</td>
			<td class="columnheadercenter" nowrap> 
				<fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/>
			</td>
			<%if(destype.equals( "V" )){ %>
			<td class="columnheadercenter" nowrap> 
				<fmt:message key="Common.FileFormat.label" bundle="${common_labels}"/>
			</td>
			<%}else if(destype.equals( "F" )){%>
			<td class="columnheadercenter" nowrap> 
				<fmt:message key="Common.FileFormat.label" bundle="${common_labels}"/>
			</td>
			<td class="columnheadercenter" nowrap> 
				<fmt:message key="Common.FileName.label" bundle="${common_labels}"/>
			</td>
			<%} else if(destype.equals("P")){%>
			<td class="columnheadercenter" nowrap> 
				<fmt:message key="Common.copies.label" bundle="${common_labels}"/>
			</td>
			<%} %>
		</tr>
		
		<%
		ResultSet rst = null;
		try{
			
			String sql = request.getParameter("sqlString");
			String patLang = "SELECT nvl(upper(dflt_lang_online_report),upper('"+locale+"')) language FROM mp_language WHERE upper(lang_id) = (SELECT nvl(upper(language_id),upper('"+locale+"'))  FROM mp_patient WHERE patient_id = ?) ";
			String patlangId = "";

			
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(patLang);
			
			/*pstmt.setString(1,locale);
			pstmt.setString(2,locale);*/
			pstmt.setString(1,patientId);
			rst = pstmt.executeQuery();
			while(rst.next()){
				patlangId = rst.getString("language");
			}
			
			if("".equals(patlangId))	patlangId = locale.toUpperCase();
			//con = null;
			//pstmt = null;
			//rst = null;
			if(rst!=null) rst.close();	
			if(pstmt!=null)	pstmt.close();
			
			//con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sql1);
			rst = pstmt.executeQuery();
			while(rst.next()){
			%>
			<tr>
			<td class='gridData' nowrap><%=rst.getString(2) %></td>
			<td class='gridData' nowrap>
			<select name="languageSel" id="languageSel">
			<%
			// Modified for IN:45519
			String sqlLang = "select upper(language_id) language_id,short_name from sm_language where eff_status = 'E' and LANGUAGE_ID ='th' order by seq_no";
			con1 = ConnectionManager.getConnection(request);
			pstmt1 = con1.prepareStatement(sqlLang);
			rs1 = pstmt1.executeQuery();
			while(rs1.next()){
				if(patlangId.equals(rs1.getString("language_id"))){
			%>

			<option value="<%=rs1.getString("language_id")%>" selected>
			<%}
				else{%>
				<option value="<%=rs1.getString("language_id")%>" disabled>
				<%}%>
			<%=rs1.getString("short_name") %></option>
			<%} %>
			</select></td>
			<td class='gridData' nowrap>
			<select name="reportOption" id="reportOption" onChange="reportOptionChange(this);" disabled>
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
			<%
				if ( destype.equals( "V" )  ) {
			%>
			<td class='gridData' nowrap>
			<select name="fileFormat" id="fileFormat">
			<option value="pdf">PDF</option>
			<option value="spreadsheet">Spread Sheet</option>
			</select>
			</td>
			</tr>
			<%}
			else if(destype.equals( "F" )){%>
			<td>
					&nbsp;&nbsp;<select name="fileFormat" id="fileFormat">
						<option value ='pdf'>		PDF &nbsp;&nbsp;
						<option value ='htmlcss'>	HTML &nbsp;&nbsp;
						<option value ='rtf'>		RTF &nbsp;&nbsp;
						<option value ='xml'>		XML &nbsp;&nbsp;
						<option value ='spreadsheet'>  Spread Sheet&nbsp;&nbsp;
						</select>
				</td>
				<td>
					&nbsp;&nbsp;<input type="text" name="file_name" id="file_name" value="<%= file_name %>" size="30" maxlength="45" >
					<input type="hidden" name="report_dir" id="report_dir" value="<%= report_dir %>">
					
				</td>
				</tr>
			<%}
				else if(destype.equals("P")){%>
				<td>
					&nbsp;&nbsp;<input type="text" name="copies" id="copies" value="1" size="5" maxlength="5" onkeypress="return CheckForAlphaNumeric(event);" onblur="return CheckForZero(this);">					
				</td>
				</tr>
			<%}
			}
			if(rst!=null) rst.close();	
			if(pstmt!=null)	pstmt.close();
		}
			catch(Exception e){
				System.err.println("Exception is ->"+e);
				e.printStackTrace();
			}
			finally{
				try{
					if(pstmt!=null)	pstmt.close();
					if(rst!=null) rst.close();
					if(con != null) ConnectionManager.returnConnection(con,request);
					if(con1 != null) ConnectionManager.returnConnection(con1,request);
				}
				catch(Exception e){
					System.err.println("Exception is ->"+e);
				}
			}%>			
</table>
<input type="hidden" name="patId" id="patId" value="<%=patientId%>">
</form>
</body>
</html>

