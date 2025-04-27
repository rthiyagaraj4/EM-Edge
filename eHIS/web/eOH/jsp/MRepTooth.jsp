<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>              
<% request.setCharacterEncoding("UTF-8");%>
<%@ page  import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
 <% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String locale	= (String)session.getAttribute("LOCALE");
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
   (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql = "";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<!-- <script language="javascript" src="../../eOH/js/MasterReports.js"></script> -->
<script>
function run(){
	chkMandatory();
	var formObj = document.forms[0];
	if(formObj) {
		formObj.submit();
		window.returnValue=true;
		window.close();
	}
}

function chkMandatory(){
	var frmObj=document.MReportForm;
	var err_txt="";
	var msg=getMessage("CAN_NOT_BE_BLANK","Common");
	var msgArry=msg.split("&");
	var numberSystem=getLabel("eOH.NumberingSystem.Label","OH");
	if(frmObj.p_numbering_system.value==''){
		err_txt=msgArry[0]+ numberSystem + msgArry[1];
		if(err_txt.length>0){
			messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+err_txt;
			return false;
		}else       
		  return true;
	}
}

</script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<br>
	<form name="MReportForm" id="MReportForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
		<table width="70%" align="center" cellpadding="0" cellspacing="0" border="0">
		<th colspan="4" align="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td align="right" width="25%" class="label"><fmt:message key="eOH.NumberingSystem.Label" bundle="${oh_labels}"/> &nbsp;</td>
			<td align="left">
			<select name="p_numbering_system" id="p_numbering_system" tabIndex="3">
	<% 
	try{
		String numbering_system = "";
		String numbering_system_desc = "";
        con=ConnectionManager.getConnection(request);
		sql="SELECT NUMBERING_SYSTEM, NUMBERING_SYSTEM_DESC FROM OH_NUMBERING_SYSTEM_LANG_VW WHERE LANGUAGE_ID=? ORDER BY NUMBERING_SYSTEM_DESC";
		pstmt=con.prepareStatement(sql);
	    pstmt.setString(1,locale);
		rs=pstmt.executeQuery();
	    while(rs.next()){
			numbering_system=rs.getString("NUMBERING_SYSTEM");
			numbering_system_desc=rs.getString("NUMBERING_SYSTEM_DESC");
	%>	
			<option value= "<%=numbering_system%>"> <%=numbering_system_desc%> </option>
        <% 
		}%>
		</select> <img src='../../eCommon/images/mandatory.gif' align='center'>
		
	<% 
	}catch(Exception e){
		out.println("exp"+e);
	}finally{
		try{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){
			out.println("exp"+e);
		}
	}
%>		
			</select>
			</td>
		</tr>
		<tr>
			<td colspan="4">&nbsp;</td>
		</tr>
	</table>

	<input type="hidden" name="facility_id" id="facility_id" value="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= session.getValue( "facility_id" ) %>">
	<input type="hidden" name="user_name" id="user_name" value="<%= session.getValue( "login_user" ) %>">
	<input type="hidden" name="module_id" id="module_id" value="OH">
	<input type="hidden" name="p_module_id" id="p_module_id" value="OH">
	<input type="hidden" name="report_id" id="report_id" value="OHRTOOTH">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OHRTOOTH">
	<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	
</form>
</body>
</html>





