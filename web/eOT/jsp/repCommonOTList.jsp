<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eOT.*,eOT.Common.*" %>
  
<%
	//String p_module_id		= "OT" ;
	//String p_report_id		= "" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	//String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_rep_desc		= request.getParameter("rep_desc"); 
	String p_table_id		= request.getParameter("t_id"); 
	String user_id			= (String)session.getValue("login_user");
	
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	//String params = request.getQueryString() ;
	//String function_id = request.getParameter("function_id");
	//String source = url + params ;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
	}catch(Exception e){
		System.err.println("Err Msg repCommonOTList.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }

%>
<script language="javascript">
	function assignLabel(){
		var formObj = document.forms[0];
		var x_table_id= formObj.p_table_id.value;
		var x_rep_desc= formObj.p_rep_desc.value;
        var locale = formObj.locale.value;
		var code_title=getLabel("Common.code.label","common");
		 if (x_rep_desc.length!=0 ) 
		   t1.innerHTML= x_rep_desc + " &nbsp;";//x_rep_desc.toLowerCase() +" &nbsp;";
		else{
		   //t1.innerHTML= "Code" +" &nbsp;";  
		   t1.innerHTML= code_title +" &nbsp;";  
		}

		if (x_table_id=="OT_OPER_TYPE"){
		//	formObj.qry_sql.value="SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) ORDER BY 2";
	
		formObj.qry_sql.value="SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE_LANG_VW WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) AND LANGUAGE_ID ='"+locale+"'  ORDER BY 2";
		formObj.p_report_id.value="OTSOPTYP";

		}
		else if (x_table_id=="OT_EQUIPMENT_LANG_VW"){
			formObj.qry_sql.value="SELECT EQUIPMENT_CODE CODE, LONG_DESC DESCRIPTION FROM OT_EQUIPMENT_LANG_VW WHERE LANGUAGE_ID ='"+locale+"' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(EQUIPMENT_CODE) LIKE UPPER(?) ORDER BY 2";
			formObj.p_report_id.value="OTCEQUIP";
		}
		else if (x_table_id=="OT_OPER_ROOM"){
			formObj.qry_sql.value="SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID = '"+p_facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";
			formObj.p_report_id.value="OTROTROM";
		}	
	}
</script>
<html>
<HEAD>
<TITLE></TITLE>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
 <script src="../../eCommon/js/ValidateControl.js"></script>
 <script src="../../eOT/js/OtReports.js" ></script> 
 <script language="javascript" src="../../eCommon/html/blank.html"> </script>
 <script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script src="../../eCommon/js/messages.js" language="javascript"></script>
	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey()' onLoad="Focusing('p1');">
<br>
<br>
<form name="OtReportOptionsForm" id="OtReportOptionsForm" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame">

<table width='80%' align='center' valign='top' >
	<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='100%' cellpadding=3 cellSpacing="0" align='center'>
				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="label" width="20%" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
					<tr>
						<td align='right' width='30%' class="label" id="test" > <fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width='30%'  >
						<input type='hidden' name="p1" id="p1" value=""> 
						<input type="text"  name='p1_desc' id='p1_desc' size="15" maxlength="15" align="center" onFocus = "assignLabel();">
					  	<input type='button' class='button' value='?' name='but1' id='but1' onclick="searchCode(p1,p1_desc,document.forms[0].p_rep_desc.value,document.forms[0].qry_sql.value);" >
     				    </td>


						<td width='40%'> 
						<input type='hidden' name="p2" id="p2" value=""> 
						<input type="text"  name='p2_desc' id='p2_desc' size="15" maxlength="15" align="center" >
						<input type='button' name='but2' id='but2' value='?' class='button' onclick="searchCode(p2,p2_desc,document.forms[0].p_rep_desc.value,document.forms[0].qry_sql.value);" >
						</td>				

					</tr>

</table>
</td>
</tr>
</table>

<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
<input type="hidden" name="p_report_id" id="p_report_id" value="OTSOPTYP">
<input type="hidden" name="pgm_id" id="pgm_id" value="OTSOPTYP">

<input type="hidden" name="facility_id" id="facility_id"	value="<%=p_facility_id%>">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=p_facility_id%>">
<input type="hidden" name="p_rep_desc" id="p_rep_desc" value = <%= p_rep_desc %>>
<input type="hidden" name="p_table_id" id="p_table_id" value = <%= p_table_id %>>
<input type="hidden" name="qry_sql" id="qry_sql" value=" " >

<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="0" disabled>
<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="0" disabled>
<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="0" disabled>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>
			
			

