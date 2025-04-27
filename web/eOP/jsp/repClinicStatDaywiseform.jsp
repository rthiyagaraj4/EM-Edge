<!DOCTYPE html>

<%--
Filename		: repClinicStatDaywiseform.jsp
Modified On		: 2-3-2005
Version			: 3
--%>

<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>

function validate_dateTo(obj) {
		var from = obj.value;
		var to   = document.forms[0].CurrentDate.value;
		var fromarray;
		var toarray;
		fromarray  = from.split("/");
		toarray    = to.split("/");
		var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
		var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
		if (CheckDate(obj)){
			if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
					var invaldt = getMessage("TO_DT_NGE_CURR_DATE","SM") ;
					var visit_Date=getLabel('Common.to.label','common_labels')+" "+getLabel('Common.VisitDate.label','op_labels');
					invaldt = invaldt.replace('To date',visit_Date);
					alert(invaldt);
					document.forms[0].p_to_visit_date.select();
					document.forms[0].p_to_visit_date.focus();
				}
			}
		}
		function validate_dateFrom(obj){
			var from = obj.value;
			var to   = document.forms[0].CurrentDate.value;
			var fromarray;
			var toarray;
			fromarray  = from.split("/");
			toarray    = to.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1]-1,fromarray[0]);
			var todt = new Date(toarray[2],toarray[1]-1,toarray[0]);
			if (CheckDate(obj)){
				if(Date.parse(todt) < Date.parse(fromdt)) {//DATE_NOT_LESS_SYSDATE
					var invaldtFrom = getMessage("FROM_DT_NGE_CURR_DATE","SM") ;
					var visit_fromDate=getLabel('Common.from.label','common_labels')+" "+getLabel('Common.VisitDate.label','op_labels');
					invaldtFrom = invaldtFrom.replace('From date',visit_fromDate);
					alert(invaldtFrom);
					document.forms[0].p_fm_visit_date.select();
					document.forms[0].p_fm_visit_date.focus();
					}
				}
		}


		

	function setValue()
{
				
if ( repClinicStatDaywiseform.sum_id.checked == true)
     {
	    repClinicStatDaywiseform.p_sum_yn.value="Y";
			 
	  }
              
	  if ( repClinicStatDaywiseform.detail_id.checked == true)
        {
	     repClinicStatDaywiseform.p_sum_yn.value="N";
		}
             
}
</script>
<%
    String p_module_id      = "OP" ;
    String p_report_id      = "OPBDYCST" ;
    String p_facility_id        = (String) session.getValue( "facility_id" ) ;
    String p_user_name      = (String) session.getValue( "login_user" ) ;
	String CurrentDate = "";
    Statement stmt=null;
    ResultSet rset=null ;
    Connection con=null;
    String ID="";
    String dat="";
    String en="";

    try{
		con=ConnectionManager.getConnection(request); 
%>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<center>
    <form name="repClinicStatDaywiseform" id="repClinicStatDaywiseform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
    <BR>
    <table width='80%' align='center' valign='top'>
	<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	</table>   
    <table width='80%' cellPadding="2" cellSpacing="0"  align='center' border='0'>        
		<tr>
				<td class="label" ><fmt:message key="Common.facility.label" 	 bundle="${common_labels}"/></td>				
				<td class='fields' colspan='2'><select name='p_for_facility_id' id='p_for_facility_id' >
					<%
					stmt=con.createStatement();
					rset=stmt.executeQuery("SELECT facility_id,sm_get_desc.SM_FACILITY_PARAM(facility_id,'"+localeName+"',1) facility_name,to_char(sysdate,'dd/mm/yyyy')CurrentDate FROM SM_FACILITY_FOR_USER WHERE appl_user_id='"+p_user_name+"' ORDER BY facility_name");

					if(rset!=null)
					{
					while(rset.next())
					{
					dat=rset.getString("FACILITY_NAME");
					ID=rset.getString("FACILITY_ID");
					CurrentDate=rset.getString("CurrentDate");

					out.println("<option value='"+ID+ "' "+en+">"+dat+"</option>");
					}%>
					</select>
					<%  }

					%>
				</td>					
			</tr> 
			 <tr>
					<td >&nbsp;</td>
					<td class="querydata" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class="querydata" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
			</tr>
			<tr>
					<td class="label"><fmt:message key="Common.VisitDate.label" bundle="${op_labels}"/></td>
					<td class='fields'><input type=text id='p_fm_visit_date'  name='p_fm_visit_date'  size="10" maxlength="10" align="left" onBlur='validate_dateFrom(this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_visit_date');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>	
					<td class='fields'><input type=text id='p_to_visit_date'  name='p_to_visit_date'  size="10" maxlength="10" align="left" onBlur='validate_dateTo(this);'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_visit_date');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>
					</td>
			</tr> 
			</table>
				<table width='80%' cellpadding="0" cellspacing="0" border="0" align='center'>
    <tr>
        <td width='17%' class="label">
            <fmt:message key="Common.Summary.label" bundle="${common_labels}"/>
        </td>
        <td width='3%'><input type='radio' id='sum_id' name='p_sum_yn' value='Y' onClick="setValue();"></td>
        <td width='3%' class="label">
            <fmt:message key="Common.Detail.label" bundle="${common_labels}"/>
        </td>
        <td><input type='radio' id='detail_id' name='p_sum_yn' value='N' checked onClick="setValue();"></td>
    </tr>
</table>
    
        <input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
        <input type="hidden" name="p_module_id" id="p_module_id"         value="<%= p_module_id %>">
        <input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
        <input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">
		<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%= CurrentDate %>">

<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>">	--%>

        
    </form>
<% }
	catch(Exception e)
	{ out.println(e.toString());}
finally{
	try{
if(stmt != null) stmt.close();
if(rset != null) rset.close();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
 if( con !=null ) ConnectionManager.returnConnection(con,request);
}
%>
</center>
</body>
</html>

