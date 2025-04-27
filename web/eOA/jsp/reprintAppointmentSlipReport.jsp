<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>

<html>
	<head>
		<title>
			Reprint Report
		</title>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		var checkFlag=true;
		function ValidateChk() {
			checkFlag=false;
			if(document.forms[0].singleApptYN.value=="Y"){
				if(document.forms[0].check.checked){									//parent.window.returnValue=document.forms[0].prefLang.value+"|~"+document.forms[0].noofcopies.value;
				//parent.window.close();
				let dialogBody = parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = document.forms[0].prefLang.value+"|~"+document.forms[0].noofcopies.value;
    
				const dialogTag = parent.document.getElementById("dialog_tag");    
				dialogTag.close();
				}else{
					alert(getMessage("ATLEAST_ONE_REP_SELECT","Common"));
				}
			}else{
				//parent.window.returnValue=document.forms[0].prefLang.value;
				//parent.window.close();
				let dialogBody = parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = document.forms[0].prefLang.value;
    
				const dialogTag = parent.document.getElementById("dialog_tag");    
				dialogTag.close();
			}
		}
		function closeWindow(){
			//parent.window.returnValue="N";
			//parent.window.close();
			let dialogBody = parent.document.getElementById('dialog-body');
    		dialogBody.contentWindow.returnValue = "N";
    
    		const dialogTag = parent.document.getElementById("dialog_tag");    
    		dialogTag.close();
		}
		function closeWindowUnLoad(){
			if(checkFlag){
				//parent.window.returnValue="N";
				//parent.window.close();
				let dialogBody = parent.document.getElementById('dialog-body');
				dialogBody.contentWindow.returnValue = "N";
    
    			const dialogTag = parent.document.getElementById("dialog_tag");    
    			dialogTag.close();
			}
		}
	</script>
	</head>

<%
	Connection connection = null;
	Statement stmt = null;
	ResultSet rset = null;

	String locale=(String)session.getAttribute("LOCALE");
	String p_module_id=request.getParameter("p_module_id")==null?"":request.getParameter("p_module_id");		
	String p_report_id=request.getParameter("p_report_id")==null?"":request.getParameter("p_report_id");		
	String p_facility_id=request.getParameter("p_facility_id")==null?"":request.getParameter("p_report_id");		
	String p_location_type=request.getParameter("p_location_type")==null?"":request.getParameter("p_location_type");		
	String p_clinic_code=request.getParameter("p_clinic_code")==null?"":request.getParameter("p_clinic_code");		
	String p_appt_ref_no=request.getParameter("p_appt_ref_no")==null?"":request.getParameter("p_appt_ref_no");
	String singleApptYN=request.getParameter("singleApptYN")==null?"N":request.getParameter("singleApptYN");
	//String reportSql="select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = '"+p_module_id+"' AND REPORT_ID = '"+p_report_id+"' and language_id = '"+locale+"'";
	String reportSql="select report_id, report_desc, 1 no_of_copies, module_id from sm_report_lang_vw where module_id = ? AND REPORT_ID = ? and language_id = ? ";
	String report_desc="";
	String numofCopies="";
	String disableChkbox="";
	CallableStatement cs = null;
	PreparedStatement pstmt=null;
	String ws_no        = request.getRemoteAddr() ;
	String report_option    = "P" ;
	String message ="";
	String langCode ="";
	String langDesc ="";
	String rep_server_key ="";//IN037658
	try{
		connection = ConnectionManager.getConnection(request);
		stmt=connection.createStatement();
		//rset=stmt.executeQuery(reportSql);
		pstmt = connection.prepareStatement(reportSql);
		pstmt.setString(1,p_module_id);
		pstmt.setString(2,p_report_id);
		pstmt.setString(3,locale);
		rset = pstmt.executeQuery();
		if(rset!=null && rset.next()){
			report_desc=rset.getString("REPORT_DESC");
			numofCopies = rset.getString("NO_OF_COPIES");
			cs = connection.prepareCall( "{ call report_routing( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ) }" ) ;//Changes for 37658
			cs.setString( 1,    p_module_id ) ;
			cs.setString( 2,    p_report_id ) ;
			cs.setString( 3,    p_location_type ) ;
			cs.setString( 4,    p_clinic_code ) ;
			cs.setString( 5,    p_facility_id ) ;
			cs.setString( 6,    ws_no ) ;
			cs.setString( 7,    report_option ) ;
			cs.registerOutParameter( 8,  Types.VARCHAR ) ;
			cs.registerOutParameter( 9,  Types.VARCHAR ) ;
			cs.registerOutParameter( 10, Types.VARCHAR ) ;
			cs.registerOutParameter( 11, Types.VARCHAR ) ;
			cs.registerOutParameter( 12, Types.VARCHAR ) ;
			cs.registerOutParameter( 13, Types.VARCHAR ) ;
			cs.registerOutParameter( 14, Types.VARCHAR ) ;
			cs.registerOutParameter( 15, Types.VARCHAR ) ;
			cs.registerOutParameter( 16, Types.VARCHAR ) ;
			cs.registerOutParameter( 17, Types.VARCHAR ) ;//IN037658
			cs.execute() ;

			message = cs.getString( 15 ) ;
			rep_server_key = cs.getString( 17 ) ;
			
			if (message==null) message="";

			if (message.equals(""))
				disableChkbox = " checked ";
			else
				disableChkbox = " disabled ";	
						
			if(cs != null)		cs.close();
		}
		if(rset!=null)rset.close();
		rset=stmt.executeQuery("select LANGUAGE_ID,SHORT_NAME from sm_language");
%>
<body onunload="closeWindowUnLoad()">
<form name='reprintSlipReportForm' id='reprintSlipReportForm' >
<table width='100%' border='1' cellspacing='0' cellpadding='0'>
<TR>
<%if(singleApptYN.equals("Y")){%>
<th align='left'><fmt:message key="Common.reportname.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.required.label" bundle="${common_labels}"/></th><th><fmt:message key="Common.copies.label" bundle="${common_labels}"/></th>
<%}%>
<th><fmt:message key="eSM.PreferredLanguage.label" bundle="${sm_labels}"/></th></TR>
<tr>
<%if(singleApptYN.equals("Y")){%>
	<td width='75%' align='left' class=''>&nbsp;<%=report_desc%></td>
	<td width='10%' align='center' class=''><input type='checkbox' name='check' id='check' width='15%' value='Y' <%=disableChkbox%>></td>
	<td  align='center' class=''><input type='text' name='noofcopies' id='noofcopies' align='right' maxlength='3' size='2' onKeyPress='return(ChkNumberInput(this,event,0));'  onblur='CheckPositiveNumber(this)' value='<%=numofCopies%>'></td>
	<%}%>
	<td  align='center' class=''>
		<select name='prefLang' id='prefLang'>
	<%
		while(rset!=null && rset.next()){
						langCode=rset.getString("LANGUAGE_ID");
						langDesc=rset.getString("SHORT_NAME");
						String selecteYN="";
						if(locale.equals(langCode)){
								selecteYN="selected";
						}
						%>
						<option value="<%=langCode%>" <%=selecteYN%>><%=langDesc%></option>
						<%
		}
	%>
	</select></td>
</tr>
</table>
<%if(singleApptYN.equals("N")){%>
<br><br>
<%}%>
<center><input type='button' name='ok' id='ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>   ' class='Button' onclick='ValidateChk();'>&nbsp;&nbsp;&nbsp;<input type='Button' name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' class='Button' onclick='closeWindow()'></center>
<input type='hidden' name='reportid"' id='reportid"' value='<%=p_report_id%>'>
<input type='hidden' name='module_id' id='module_id' value='<%=p_module_id%>'>
<input type='hidden' name='p_facility_id' id='p_facility_id' value='<%=p_facility_id%>'>
<input type='hidden' name='p_location_type' id='p_location_type' value='<%=p_location_type%>'>
<input type='hidden' name='p_clinic_code' id='p_clinic_code' value='<%=p_clinic_code%>'>
<input type='hidden' name='p_appt_ref_no' id='p_appt_ref_no' value='<%=p_appt_ref_no%>'>
<input type='hidden' name='singleApptYN' id='singleApptYN' value='<%=singleApptYN%>'>
<input type='hidden' name='rep_server_key' id='rep_server_key' value='<%=rep_server_key%>'>

</form>
</body>
<%}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
		ConnectionManager.returnConnection(connection,request);
	}%>
</html>

