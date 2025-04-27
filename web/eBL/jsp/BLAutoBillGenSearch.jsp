<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date     	  Edit History      	Name     			Description
--------------------------------------------------------------------------------------------------------------
23-OCT-2018      100           	Subha Sundari M          Created
---------------------------------------------------------------------------------------------------------------
-->
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*,java.util.GregorianCalendar,java.util.Date,java.util.Calendar" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%request.setCharacterEncoding("UTF-8");%>

<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
	<script language='javascript' src='../../eBL/js/BLAutoBillGen.js' ></script>
	<script language='javascript' src='../js/AddModifyPatFinDetails.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	request.setCharacterEncoding("UTF-8");
	HttpSession httpSession = request.getSession(false);
	Connection con				= null;
	Statement stmt				= null;
	ResultSet rs				= null;	
	String  params="",function_id="",str_facility_id="";
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	Calendar cal = Calendar.getInstance();
	String todaysDate = dateFormat.format(cal.getTime());
	cal.add(Calendar.DATE, -1);
	String yesterdayDate = dateFormat.format(cal.getTime());
	String loginUser = "";
 	String clientIp = "";
	try
	{
		con	=	ConnectionManager.getConnection(request);
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";
		params = request.getQueryString();
		if(params == null) params="";
		function_id = request.getParameter("function_id");
		if(function_id == null) function_id="";
		System.out.println("function_id --> " + function_id);
		str_facility_id = (String) session.getValue("facility_id");
		if (str_facility_id==null) str_facility_id = "";
		loginUser = (String) session.getValue("login_user");
		Properties p = (Properties)httpSession.getValue("jdbc");
		clientIp = p.getProperty("client_ip_address");
%>
<script>
 $(document).ready(function() {
	$('#visit_from_date').blur(function(){
		var bool =  checkDateBL(document.forms[0].visit_from_date);
		if(!bool){
			$('#visit_from_date').val($('#visit_to_date').val());
			return false;
		}
		if($("#visit_from_date").val()!='' ){
			var fromLesserThanCurrentDt=true;
			var lesserThanCurrentDt=true;
			var toGrtThanFromDt=true;
			fromLesserThanCurrentDt=isBeforeNow($("#visit_from_date").val(), 'DMY',$("#locale").val());
			if($("#visit_to_date").val()!=''){
				lesserThanCurrentDt=isBeforeNow($("#visit_to_date").val(), 'DMY',$("#locale").val());
				toGrtThanFromDt=isAfter( $("#visit_to_date").val(), $("#visit_from_date").val(), 'DMY',$("#locale").val());
			}
			if(fromLesserThanCurrentDt == false){
				alert(getMessage("BL0777","BL"));
				$("#visit_from_date").val($('#todaysDate').val());
			} else if(lesserThanCurrentDt==false){
			  	alert(getMessage("BL0777","BL"));
			  	$("#visit_to_date").val($('#todaysDate').val());
			}  else if(toGrtThanFromDt==false){
				if( $("#visit_from_date").val()!=''){
					var msg = getMessage("BL0775","BL");
					msg = msg.replace("$", "Visit From Date");
					alert(msg);
					$("#visit_from_date").val($("#visit_to_date").val());
		   		}
			}
		}
	});
	$('#visit_to_date').blur(function(){
		var bool =  checkDateBL(document.forms[0].visit_to_date);
		if(!bool){
			$('#visit_to_date').val($('#visit_from_date').val());
			return false;
		}
		if($("#visit_to_date").val()!=''){
			var fromLesserThanCurrentDt=isBeforeNow($("#visit_to_date").val(), 'DMY',$("#locale").val());	
			var  lesserThanCurrentDt=isBeforeNow($("#visit_from_date").val(), 'DMY',$("#locale").val());			 
			var  toGrtThanFromDt= isAfter(   $("#visit_to_date").val(), $("#visit_from_date").val(), 'DMY',$("#locale").val());
			if(fromLesserThanCurrentDt == false){
				alert(getMessage("BL0777","BL"));
				$("#visit_to_date").val($('#todaysDate').val());
			} else if(lesserThanCurrentDt==false){
				var msg = getMessage("CAN_NOT_BE_BLANK","Common");
				msg = msg.replace("$", "Visit From Date");
				alert(msg);
				$("#visit_from_date").val($('#visit_to_date').val());
			} else if(toGrtThanFromDt==false){
				if($("#visit_to_date").val()!='' ){
					var msg = getMessage("BL0776","BL");
					msg = msg.replace("$", "Visit To Date");
					alert(msg);
				  	$("#visit_to_date").val($('#visit_from_date').val());
				}
		    }
				 
		}
	});
}); 

async function getPatID()
{	
	var pat_id=await PatientSearch();		
	if( pat_id != null )						
	document.forms[0].patient_id.value = pat_id ;					
}
</script>	

<BODY onLoad="onLoadStatus()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
	<FORM name='billGenSearchForm' id='billGenSearchForm' action="" method='post'>
		<TABLE border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
			<tr>
			 	<td class="label" ><fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels}"/></td>
				<td class='fields'>
					<input type="text" name="cust_group" id="cust_group" id="cust_group" maxlength='40'
					onblur='if(this.value!=""){ customerLookup(2,cust_group,custgroupCode,0);}else{ fnClearCode(this,custgroupCode); }'>
					<input type="hidden" name="custgroupCode" id="custgroupCode" id="custgroupCode"> 
					<input type='button' class='button' name="custgroupbtn" id="custgroupbtn" value='?' onClick="customerLookup(2,cust_group,custgroupCode,0)" />
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td class="label" ><fmt:message key="eBL.Customer.label" bundle="${bl_labels}"/></td>
				<td class="fields" colspan="2">
					<input type="text" name="cust_name" id="cust_name" id="cust_name"    maxlength="100"
					onblur='if(this.value!=""){ customerLookup(1,cust_name,custnameCode,0);}else{ fnClearCode(this,custnameCode); }'>
					<input type="hidden" name="custnameCode" id="custnameCode" id="custnameCode"> 
					<input type='button' class='button' name="custnamebtn" id="custnamebtn" value='?' onClick="customerLookup(1,cust_name,custnameCode,0)" />
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td class="label" colspan='3'></td>
			 </tr>
			 <tr>
				<td width='25%' class='label'><fmt:message key="Common.Visit.label" bundle="${common_labels}"/> <fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
				<td width='25%' class="fields"><input type='text' name='visit_from_date' id='visit_from_date' id='visit_from_date' size='10' maxlength='30' value='<%=yesterdayDate %>'>
				<img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('visit_from_date');">
				<img src='../../eCommon/images/mandatory.gif'></td>
				<td width="25%"  class='label'><fmt:message key="Common.Visit.label" bundle="${common_labels}"/> <fmt:message key="Common.todate.label" bundle="${common_labels}"/> </td>
				<td width='25%' class="fields"><input type='text' name='visit_to_date' id='visit_to_date' id='visit_to_date' size='10' maxlength='30'  value='<%=todaysDate %>'>
				<img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('visit_to_date');">
				<img src='../../eCommon/images/mandatory.gif'></td>
			</tr>
			<tr>
				<td width='25%' class='label'><fmt:message key="Common.EpisodeType.label"	bundle="${common_labels}"/></td>
				<td width='25%' class="fields">
				<select id="episode_type" name="episode_type" id="episode_type">
					<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="E"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/></option>
					<option value="O"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
				</select>
				</td>
				<td class="label" width="25%"><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></td>	
				<td class="fields" width="25%"><INPUT TYPE="TEXT"  name="patient_id" id="patient_id" SIZE="10" maxlength='10' VALUE=''  onKeyPress='changeToUpper()' onBlur="" >
				<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' onClick="return getPatID()"></td>
			</tr>
			<tr>
				<td width='25%' class='label'><fmt:message key="eBL.InclLabRadiologyStatus.label"	bundle="${bl_labels}"/></td>
				<td width='25%' class="fields"><fmt:message key="Common.completed.label" bundle="${common_labels}"/>
				<%-- <select id="status" name="status" id="status">
					<option value="RST"><fmt:message key="eBL.Resulted.label" bundle="${bl_labels}"/></option>
					<option value="CMP"><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>
				</select> --%>
				<input type='hidden' name='status' id='status' id='status' value='CMP' />
				</td>
			</tr>
			
			<tr>
				<td width="25%"  class='labels'>
				<td width="25%"  class='labels'>
				<td width="25%"  class='labels'>
				<td width="25%"  class='labels'><input type='button'  name="search_button" id="search_button" id="search_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>" class='button' onClick='search();'>	
				<input type='button'  name="cancel_button" id="cancel_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" class='button' onClick='clearFrame()'></td>	
			</tr>
		</TABLE>
		<input type='hidden' name='locale' id='locale' id='locale' value='<%=locale%>' >
		<input type='hidden' name='todaysDate' id='todaysDate' id= 'todaysDate' value='<%=todaysDate%>'>
		<input type='hidden' name='params' id='params' id='params' value='<%=params%>'>
		<input type='hidden' name='function_id' id='function_id' id='function_id' value='<%=function_id%>'>
		<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value='<%=str_facility_id%>'>
		<input type='hidden' name='loginUser' id='loginUser' id='loginUser' value='<%=loginUser%>'>
		<input type='hidden' name='clientIp' id='clientIp' id='clientIp' value='<%=clientIp%>'>
	</FORM>
</BODY>	
</HTML>
<%
	}
	catch(Exception e )
	{ 
		System.err.println("Error in BLViewPatEncounterPatSearch.jsp:"+e);
		out.println(e);
	}
	finally
	{	
		if(stmt != null)		stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
%> 

