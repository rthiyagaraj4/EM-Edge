<!DOCTYPE html>
<HTML>
<%@ page contentType="text/html;" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,eXH.XHUtil" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	

<HEAD>
																									  
																									  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		      
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	    

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../OP/js/messages.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/ViewEvents.js"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/jquery-3.6.3.js' language='javascript'></script>


<script language="javascript">

function Report(){

		var event = "";
		var checkBoxes = document.getElementsByName('checkbox');

		for(var i = 0; i < checkBoxes.length; i++)
		{
			if(checkBoxes[i].checked)
			{
				document.getElementById("p_detail_rep").value = "Y";
			}
			else
			{
				document.getElementById("p_detail_rep").value = "N";
			}
		}
		var event =  document.getElementById("p_opt_yn").value;
	    //var report_id =  document.getElementById("p_report_id").value;
      
		parent.resultFrame.location.href='../../eCommon/html/blank.html';
		parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.action = '../../eCommon/jsp/report_options.jsp';
	    parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.target="messageFrame";
	    parent.f_query_add_mod.PAYER_CHECK_QUERY_FORM.submit();

}
function clearSearch()
{
   
   parent.f_query_add_mod.location.reload();
   parent.resultFrame.location.href='../../eCommon/html/blank.html';	
}


function clearSearchResult()
{
   parent.resultFrame.location.href='../../eCommon/html/blank.html';
}

function getPatID()
{					  
	var pat_id=PatientSearch('','','','','','','','','','VIEW');
	if( pat_id != null )						
		document.forms[0].patient_id.value = pat_id ;					
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" >

<%

String p_fm_date = "";
String p_to_date = "";
String status_code = "",status_desc = "";
String str = "";
String p_module_id      = "XH" ;
String p_facility_id    = (String) session.getValue( "facility_id" ) ;
String p_user_name      = (String) session.getValue( "login_user" ) ;
SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
java.util.Date da = new java.util.Date();
Calendar cal = Calendar.getInstance();
cal.setTime(da);
cal.add(Calendar.MONTH, -1);
da = cal.getTime();
p_fm_date =dateFormat.format(da) ;
p_to_date = dateFormat.format(new java.util.Date()) ;

String pid_length="10";
Connection conn = null;
	try
	{ 
		pid_length = (XHUtil.singleParamExeQry("SELECT PATIENT_ID_LENGTH FROM MP_PARAM"));	
	%>

<form name="PAYER_CHECK_QUERY_FORM" id="PAYER_CHECK_QUERY_FORM" method="get" action="">
<fieldset style=" border-color:grey;">
<table cellspacing=0 cellpadding=3 width='100%' align=center>

<tr>
	<td class=label width="15%"><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
	
		<td class='fields'>
			<input type=text name=p_fm_date id="p_fm_date" value="<%=p_fm_date %>" size=11  > <input type='image' id="p_fm_date_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_fm_date','dd/mm/y');"  >
		</td>	
        
        <td class=label width="15%"><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
	
		<td class='fields'>
			<input type=text name=p_to_date id="p_to_date" value="<%=p_to_date %>" size=11  > <input type='image' id="p_to_date_img" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_date','dd/mm/y');">
		</td>		
</tr>


<tr>
	<td class=label width="10%"><fmt:message key="eXH.StatusOptOut.label" bundle="${xh_labels}"/></td>
		<td class='fields'>
			<select  id="p_opt_yn" style="width: 150px" onChange="popup();">
				<option value = ''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				<option value = ''><fmt:message key="eXH.StatusYes.label" bundle="${xh_labels}"/></option>
				<option value = ''><fmt:message key="eXH.StatusNo.label" bundle="${xh_labels}"/></option>
			    <option value = ''><fmt:message key="eXH.StatusAll.label" bundle="${xh_labels}"/></option>
				
		    </select>
	</td>			

<td class=label width="10%" >Show Item Details</td>
<td><input type='checkbox' id='checkbox' value = 'N'> </td>
</tr>

</table>

<table width='100%' cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr align="right">
		<td colspan=4 class='BUTTON'>
		<!--<input class='BUTTON' type="button"  ID="query" name="query" id="query" value='Search' onClick="Query()">-->
		<input class='BUTTON' type="button"  ID="report" name="report" id="report" value='Report' onClick="Report()">
		<input class='BUTTON' type="button"  ID="clear" name=clear value='Clear' onClick="clearSearch()">
		</td>
	</tr>
</table>
<input type="hidden" name="p_facility_id" id="p_facility_id"							 value="<%=p_facility_id%>">
<input type="hidden" name="p_module_id" id="p_module_id"								 value="<%=p_module_id%>">
<input type="hidden" name="p_report_id" id="p_report_id"          id="p_report_id"	 value="XHOPTOUT">
<input type="hidden" name="p_detail_rep" id="p_detail_rep"		 id="p_detail_rep"   value="N">
<input type="hidden" name="p_language_id" id="p_language_id"		 id="p_language_id"	value="en">
<input type="hidden" name="p_user_id" id="p_user_id"								value="<%= p_user_name %>">
</fieldset>
<%
}catch(Exception e1)
			{
			 out.println("(MyhixStatPatOptOutMaster.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}
%>

</form>
</body>
</html>

