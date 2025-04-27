<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" 
			contentType="text/html; charset=UTF-8" %>
<%	request.setCharacterEncoding("UTF-8");	%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
response.setContentType("text/html");
String Facility_Id = (String) session.getValue("facility_id");
String sql4 = "";
String pid_length="";
String locale=(String)session.getAttribute("LOCALE");
Connection conn1 = null;
Statement stmt4=null;
ResultSet rset4=null;

try {
		conn1 = ConnectionManager.getConnection(request);
	    stmt4 = conn1.createStatement();
	    sql4 = "select patient_id_length from mp_param";
		rset4 = stmt4.executeQuery(sql4);
		if(rset4 != null){
		if(rset4.next())
			  pid_length = rset4.getString(1);
          
		}
		if(pid_length==null || pid_length.equals(""))
			pid_length = "20";
        if(rset4 != null) rset4.close();
		if(stmt4 != null) stmt4.close();
       
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script Language="JavaScript" src='../js/ProcessReferrals.js'></script>
<script language="javascript" src="../js/OPPractitionerComponent.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
   <body onload='FocusFirstElement()' onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
   <form name='query_criteria_form' id='query_criteria_form'>
    <table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
		
		<tr>
		<td  class=label><fmt:message key="Common.VisitDateFrom.label" bundle="${common_labels}"/></td>
		<td class='fields' nowrap><input type='text' id='critFrom' name='txtdtfrm' id='txtdtfrm' size='10' maxlength='10' value=''  onChange='clearDetail()' onBlur="validate_date_from(this);" >
		<img  style="cursor:pointer"  src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].txtdtfrm.select(); return showCalendar('critFrom');">
		<img src='../../eCommon/images/mandatory.gif' align='center'></img>
			<input type='hidden' name='eff_from_date' id='eff_from_date' size='10' maxlength='10' value=''></td>

			<td class='label'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			<td class='fields'>
			<input type='text' id='critTo' name='txtdtto' id='txtdtto' size='10' maxlength='10' value=""  onChange='clearDetail()' onBlur="validate_date_to(this,txtdtfrm);">
			
			<img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].txtdtto.select();return showCalendar('critTo'); " >
			<img src='../../eCommon/images/mandatory.gif' align='center'></img>
			
			<input type='hidden' name='eff_to_date' id='eff_to_date' size='10' maxlength='10' value="">
			
			</td>
		</tr>		
		<tr>
			
			<td class='LABEL'><fmt:message key="eMR.EpisodeNo.label" bundle="${mr_labels}"/></td>
			<td class='fields'><input type='text' name='episode_no' id='episode_no' size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))'></td>
			<td colspan='1'>&nbsp;</td>
            <td class='fields'><input type="button" class='Button' name="search_button" id="search_button" title='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="chkfld();"><input type="button" class='Button' name="clear_button" id="clear_button" title='Clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onclick="clearqry()"></td>
        </tr>
	</table>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=Facility_Id%>'>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
</form>
</body>

</html>
<%
}
catch(Exception e){out.println("Excep1:"+e);}
finally
{
	try{
	if(stmt4!=null) stmt4.close();
	if(rset4!=null)rset4.close();
	}catch(Exception e){}
   if(conn1!=null) ConnectionManager.returnConnection(conn1,request);
}
%>

