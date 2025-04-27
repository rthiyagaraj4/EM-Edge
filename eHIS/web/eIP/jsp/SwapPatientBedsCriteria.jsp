<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*" %>

<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	String locale			= (String)session.getAttribute("LOCALE");
	
	try
	{
		String jsp_name		= checkForNull(request.getParameter("jsp_name"));
		String win_height		= checkForNull(request.getParameter("win_height"));
		String win_width		= checkForNull(request.getParameter("win_width"));
		String call_function	= checkForNull(request.getParameter("call_function"));
		String modal			= checkForNull(request.getParameter("modal"));
		String dialogTop		= checkForNull(request.getParameter("dialogTop"));
		String module			= checkForNull(request.getParameter("module"));
		String model_window	= checkForNull(request.getParameter("model_window"));
		String function_id		= checkForNull(request.getParameter("function_id"));
		String prog_id			=checkForNull(request.getParameter("prog_id"));
		String practitioner_id=checkForNull(request.getParameter("practitioner_id"));
		String wherecondn	= checkForNull(request.getParameter("wherecondn"));
		String operstn			= checkForNull(request.getParameter("oper_stn_id"));
		String facilityID		= (String)session.getValue("facility_id");
		String loginUser		= (String)session.getValue("login_user");
%>	

	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
		<script src='../../eIP/js/SwapPatientBeds.js' language='javascript'></script>
		<script src='../../eIP/js/IPPractitionerComponent.js' language='javascript'></script>
		<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
		<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
		<Script src="../../eCommon/js/DateUtils.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	    <Script>
			function submitPage()
			{
				var condition=""
				var lengths = document.forms[0].elements.length;
				for (var i=0; i<lengths; i++)
				{
					condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
				}
				oper_stn = document.forms[0].operstn.value;
				
				var fields=new Array();
				fields[0]= document.forms[0].nursing_unit_desc;
				var names = new Array (	getLabel("Common.nursingUnit.label","Common"));
				if(checkFields( fields, names, parent.messageFrame))
				{
					document.forms[0].search.disabled=true;
					parent.frames[2].location.href= '../../eIP/jsp/SwapPatientBedsResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&show_bed_yn=Y';
					
					parent.frames[3].location.href='../../eCommon/html/blank.html';
					parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
				}else
				{
					parent.frames[1].document.forms[0].specialty_desc.value="";
					parent.frames[1].document.forms[0].Splcode.value="";
					parent.frames[1].document.forms[0].practid_desc.value="";
					parent.frames[1].document.forms[0].practid.value="";
					parent.frames[1].document.forms[0].from_date.value="";
					parent.frames[1].document.forms[0].to_date.value="";
					parent.frames[2].location.href='../../eCommon/html/blank.html';
					parent.frames[3].location.href='../../eCommon/html/blank.html';
				}
			}
	  </Script>
 </head>
 <body onLoad= 'FocusFirstElement()' onSelect="codeArrestThruSelect()" onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
 <form name='Inpatientlookup_Form' id='Inpatientlookup_Form' action='../../eIP/jsp/BookingReferenceLookupResult.jsp' target='result' >
	<table cellspacing=0 cellpadding=0 width='100%' border='0' align='center'>
 		<tr>
		  <td class='label' width="25%">&nbsp;</td>
		  <td class='label' width="25%">&nbsp;</td>
		  <td class='label' width="25%">&nbsp;</td>
		  <td class='label' width="25%">&nbsp;</td>
		</tr>
		<tr>
			<td class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td class='fields' ><input type=text name=nursing_unit_desc id=nursing_unit_desc size=15 onblur="beforeGetNursingUnit(nursing_unit_desc, '<%=facilityID%>','<%=loginUser%>','<%=operstn%>');"><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick="getNursingUnit(nursing_unit_desc, '<%=facilityID%>','<%=loginUser%>','<%=operstn%>');"><img src="../../eCommon/images/mandatory.gif"><input type="hidden" class=label name="nursing_unit" id="nursing_unit"></td>
			<td  class='label' nowrap ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
            <td class='fields'><input type='text' name='practid_desc' id='practid_desc' value="" size="30" maxlength="30" onblur="beforeGetPractitioner(practid,practid_desc, '<%=facilityID%>');" onFocus="checkForNursingUnit();"><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(practid,practid_desc, '<%=facilityID%>');" onFocus="checkForNursingUnit();" ><input type='hidden' name='practid' id='practid' value="" size="15" maxlength="15"></td>
		</tr>
		<tr>
			<td  class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td class='fields'><input type=text name="specialty_desc" id="specialty_desc" size=15 onblur="beforeGetSpecialty(this, '<%=facilityID%>');" onFocus="checkForNursingUnit();" ><input type="hidden" class=label name="Splcode" id="Splcode" size=15 readonly><input type=button class=button name='specialty_lookup' id='specialty_lookup' value='?' onFocus="checkForNursingUnit();" onClick="getSpecialty(specialty_desc, '<%=facilityID%>')"></td>
	
			<% if(modal.equals("")) 
			{ 
			%>	
				<td class='label' nowrap ><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/></td><td class='fields' nowrap><!--<input type='text' id="admn_date_from" maxlength='15' size='15' name='from_date' id='from_date'  value="" onBlur='CheckDate(this);compareDates(this);'>--><input type='text' id="admn_date_from" maxlength='10' size='10' name='from_date' id='from_date'  value="" onBlur="compareDates(this);"><input type="image"  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('admn_date_from');" >&nbsp;-<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;&nbsp;<!--<input type='text' id="admn_date_to" value="" maxlength='15' size='15' name='to_date' id='to_date' onBlur='CheckDate(this);compareDates(this);'>--><input type='text' id="admn_date_to" value="" maxlength='10' size='10' name='to_date' id='to_date' onBlur='compareDates(this);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="to_date.focus();return showCalendar('admn_date_to');" ></td>
		<% }%>
			</tr>
			<tr>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='label'>&nbsp;</td>
				<td class='fields' ><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick='submitPage()'><input type='button' class='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  onclick='clearAll()'></td>
			</tr>
		<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
		<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
		<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
		<input type='hidden' name='param' id='param' value="<%=call_function%>" >	
		<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
		<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
		<input type='hidden' name='module' id='module' value="<%=module%>" >
		<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
		<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
		<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
		<input type='hidden' name='wherecondn' id='wherecondn' value="<%=wherecondn%>" >
		<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
		<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=practitioner_id%>" >
		<input type='hidden' name='operstn' id='operstn' value="<%=operstn%>" >
		<input type='hidden' name='loginUser' id='loginUser' value="<%=loginUser%>" >
		<input type='hidden' name='hid_facility_ID' id='hid_facility_ID' value="<%=facilityID%>" >
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">  
 </form>
 </body>
<% 
}
catch(Exception e)	
{
	out.println(e);
	e.printStackTrace();
}
finally
{}
%>
</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

