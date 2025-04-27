<!DOCTYPE html>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<%@ page   import="java.sql.*, java.io.*,java.util.*,java.text.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../js/NoteTerminologyCode.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String sql_term = "select term_set_id,term_set_desc,defn_levels from mr_term_set where proc_spec_yn = 'Y' and eff_status = 'E'";

	Connection con = null;
	PreparedStatement pstmt_term = null;
	ResultSet rs_term = null;
	
	con = ConnectionManager.getConnection(request);
	pstmt_term = con.prepareStatement(sql_term);
	rs_term = pstmt_term.executeQuery();

	String service_code		= checkForNull( request.getParameter( "service_code" ) ) ;
    String service_desc		= checkForNull( request.getParameter( "service_desc" ) ) ;
    String note_type		= checkForNull( request.getParameter( "note_type" ) ) ;
    String note_desc		= checkForNull( request.getParameter( "note_type_desc" ) ) ;
    String term_set			= checkForNull( request.getParameter( "term_set" ) ) ;
    String term_set_desc	= checkForNull( request.getParameter( "term_set_desc" ) ) ;
	String level			= checkForNull( request.getParameter( "level" ) ) ;
	//out.println("<script>alert('term_set==="+term_set+"==term_set_desc=="+term_set_desc+"=level="+level+"==')</script>");	
	String display = "";
	//String readonly= ""; Check Style Correction
	String disabled= "";
	if(mode.equals("2")){
		display = "visibility:hidden";
		//readonly= "readOnly";	Check Style Correction
		disabled= "disabled";
	}
%>

<form name='note_terminology' id='note_terminology' target='messageFrame' >
<table cellpadding='5' cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td width="15%"  class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
		<td class='fields' width='40%'>
			<input type=text name='service_desc' id='service_desc' size='30' maxlength='30' onKeyPress='' value="<%=service_desc%>" onblur='serviceLookup(service_desc, "N")' <%=disabled%>><input type=button class=button value="?" name='service_butn' id='service_butn' Style='<%=display%>' onclick="serviceLookup(service_desc, 'Y')"><img src="../../eCommon/images/mandatory.gif"><input type=hidden name='service_code' id='service_code' value='<%=service_code%>'>
		</td>
		<td class='label' width='15%'></td>
		<td class='label' width='15%'></td>
		<td class='label' width='15%'></td>
	</tr>
	<tr>
		<td class="label"><fmt:message key="Common.note.label" bundle="${common_labels}"/></td>
		<td class='fields'>
		<input type=text name='proc_desc' id='proc_desc' size='30' value="<%=note_desc%>" maxlength='30' onKeyPress='' onblur='procLookup(proc_desc)' <%=disabled%>><input type=button size='' class='button'  value='?' name='proc_butn' id='proc_butn' onClick='procLookup(proc_desc)' style="<%=display%>"><img src="../../eCommon/images/mandatory.gif"><input type=hidden name='proc_code' id='proc_code' value='<%=note_type%>'>
		</td>
		<td colspan='3' class='label'></td>
	</tr>
	<tr>
		<td class="label" ><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></td>
		<td class="fields" >
			<select name='term_set' id='term_set' onChange='displayLevel(this)' <%=disabled%> >
			<option>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<%while(rs_term.next()){ %>
				<option  value='<%=rs_term.getString(1)%>,<%=rs_term.getString(2)%>,<%=rs_term.getString(3)%>' <%=select(rs_term.getString(1),term_set)%>> <%=rs_term.getString(2).trim()%></option> 
		<%}%>
		<input type="hidden" name="term_set_id" id="term_set_id" value='<%=term_set%>' ></select><img src="../../eCommon/images/mandatory.gif"></td>
		<input type="hidden" name="term_set_desc" id="term_set_desc" value='<%=term_set_desc%>' >
		<td id='level' class="label" ><fmt:message key="eMR.NoofLevels.label" bundle="${mr_labels}"/><B><%=level%></B></td>
		<td class='label'></td>
		<input type="hidden" name="lvl" id="lvl" value='<%=level%>' >
		<td class='button'><input type="button" class='button' name='term_code_btn' id='term_code_btn' style='visibility:hidden' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TermCode.label","common_labels")%>' onClick='callTermCode(term_set_id)'></td>	
		
	</tr>

	
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="function_id" id="function_id" value="">
<input type="hidden" name="sql_term_code" id="sql_term_code" value="select a.term_Code code, a.short_Desc ,a.long_Desc, Decode(CODE_LEVEL,'1',LEVEL_1_DESC,'2',LEVEL_2_DESC,
'3',LEVEL_3_DESC, '4',LEVEL_4_DESC ,'5',LEVEL_5_DESC ,'6',LEVEL_6_DESC ,'7',LEVEL_7_DESC ,'8',LEVEL_8_DESC ,'9',LEVEL_9_DESC ,'10',LEVEL_5_DESC )  CODE_LEVEL,b.TERM_SET_DESC  Term_SET_DESC 
from mr_term_code a, mr_Term_set b    where 	a.term_set_id = b.term_set_ID    and 	a.term_Set_id = ?  and 	upper(a.term_code)  like ?  and upper(short_Desc) like  DECODE   ((?),'S',upper(?)||'%','C','%' ||upper(?)||'%','E','%'||upper(?)) and Code_Level= ? order by 1 ">
<input type="hidden" name="sql_dept" id="sql_dept" value="select dept_code code,long_desc description from am_dept where upper(dept_Code) like (?) and upper(long_Desc) like (?) and eff_Status = 'E' order by 2">
<input type="hidden" name="sql_service" id="sql_service" value="Select service_code code,long_desc description from am_service where upper(service_Code) like upper(?) and upper(long_Desc) like upper(?) and eff_Status = 'E' order by 2">
<!--
Monday, August 10, 2009 List the note which are applicable for result reporting application task (13392)
<input type="hidden" name="sql_proc_note" id="sql_proc_note" value="select note_type code,note_type_desc description from ca_note_type where eff_Status = 'E' and upper(note_type) like upper(?) and upper(note_type_desc) like upper(?)  and note_group_id in ('*PROCNOTE','*OPERNOTE') order by 2">
-->
<input type="hidden" name="sql_proc_note" id="sql_proc_note" value="select note_type code,note_type_desc description from ca_note_type where eff_Status = 'E' and upper(note_type) like upper(?) and upper(note_type_desc) like upper(?)  and note_group_id in (select note_group from ca_note_group where appl_task_id='RESULT_REPORTING') order by 2">


</form>
<script>
/* If the mode is 2(Query mode) the button should be visible */
if(<%=mode%>=="2")
	document.note_terminology.term_code_btn.style.visibility='visible';
</script>  

<script>
/*	
if(<%=mode%> == "2" ){
var len = document.note_terminology.term_set.options.length;
	for(var i=0;i<len;i++){
				if((document.note_terminology.term_set.options[i].value).indexOf("<%=term_set%>") != -1){
			var split_val=(document.note_terminology.term_set.options[i].value).split(",");
			document.note_terminology.term_set_id.value		= split_val[0];
			document.note_terminology.term_set_desc.value	= split_val[1];
			document.note_terminology.lvl.value				= split_val[2];

			document.getElementById("level").innerHTML = "<div class='label'>No of Levels&nbsp;&nbsp&nbsp<B>"+split_val[2]+"</B></div>";
			document.getElementById("term_code_btn").style.visibility='visible';
			break;
		}
	}
}*/
	
</script>
<%
	if ( rs_term != null) 	rs_term.close();
	if ( pstmt_term != null) pstmt_term.close();
	if ( con != null )	ConnectionManager.returnConnection(con,request);
%>
</body>
</html>
<%!
String select(String str1, String str2)
{
		if(str1.trim().equalsIgnoreCase(str2.trim()))
		return "selected";
		else
		return "";
}
String leveldisplay(String str1, String str2,String str3)
{
		if(str1.trim().equalsIgnoreCase(str2.trim()))
			return str3;
		else
		return "";
}
private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>

