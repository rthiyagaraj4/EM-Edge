<!DOCTYPE html>
<!--
	Developed by 	:	Chitra 
	Created on 	:	29/06/2001
	Module		:	ip
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
 	String facilityID		= (String)session.getValue("facility_id");
	String loginUser		= (String)session.getValue("login_user");
	String operstn			= checkForNull(request.getParameter("oper_stn_id"));
%>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eIP/js/ReleaseBed.js' language='javascript'></script>
		<script src="../../eCommon/js/CommonCalendar.js" language='javascript' ></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad='FocusFirstElement();'>
<form name='ReleaseBedMain_Form' id='ReleaseBedMain_Form'  >
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		 
		 <tr>
			<!-- Modified to COMMON LOOKUP START by Sridhar on 10/02/04-->
			<td nowrap class="label"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
			<td class = 'fields' nowrap><input type=text name=nursing_unit_desc size=15 onblur='beforeGetNursingUnit("<%=operstn%>",nursing_unit,nursing_unit_desc)'><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick='beforeLookup("<%=operstn%>",nursing_unit,nursing_unit_desc)'></td>
			<input type=hidden class=label name=nursing_unit >
			<input type=hidden name="nurs_desc_hid" id="nurs_desc_hid" value=''>			

			<td nowrap class="label"><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
			<td class = 'fields' nowrap><input type="text" name="bed_class_desc" id="bed_class_desc" size=15 onblur="beforeBedClassLookup(Bedcode,bed_class_desc);"><input type="button" class="button" name='bed_class_lookup' id='bed_class_lookup' value='?' onClick="BedClassLookupClick(Bedcode,bed_class_desc);"></td>
			<input type="hidden" class="label" name="Bedcode" id="Bedcode" size="1"><input type="hidden" name="BedClassHidden" id="BedClassHidden" >
		</tr>
			<!-- Block Bed - End of Common lookup code -->
		<tr>
		    <td class='label'><fmt:message key="eIP.BlockedThrough.label" bundle="${ip_labels}"/></td>
		    <td class = 'fields' nowrap>
			  <select name="booking_type" id="booking_type">
					<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					<option value="B"><fmt:message key="eIP.BlockingFunction.label" bundle="${ip_labels}"/></option>
					<option value="D"><fmt:message key="eIP.DischargeFunction.label" bundle="${ip_labels}"/></option>
					<option value="T"><fmt:message key="eIP.TransferFunction.label" bundle="${ip_labels}"/></option>
			  </select>
		    </td>
			<td class='label' nowrap><fmt:message key="eIP.BlockType.label" bundle="${ip_labels}"/>/<fmt:message key="eIP.ReasonforReserveBed.label" bundle="${ip_labels}"/></td>
            <td class='fields'>
				<jsp:include page="BlockTypeComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include>
			</td>
		</tr>
		<tr>
			<td class='label' nowrap><fmt:message key="eIP.BlockedFromDate.label" bundle="${ip_labels}"/></td>
			<td class ='fields' nowrap>				
				<input type="text" id="date_from" name="from_date" id="from_date" size=10 maxlength=10 value="" onblur="DateCompare(this,until_date) ;"><img src='../../eCommon/images/CommonCalendar.gif' onClick="from_date.focus();return showCalendar('date_from');"/>
			</td>
			<td class='label' nowrap>
				<fmt:message key="Common.until.label" bundle="${common_labels}"/>
			</td>
			<td class ='fields' nowrap>					
				<input type="text" id="date_to" name="until_date" id="until_date" size=10 maxlength=10 value="" onblur="DateCompare(from_date,this);"><img src='../../eCommon/images/CommonCalendar.gif' onClick="until_date.focus();return showCalendar('date_to');"/>	
			</td>
		</tr>  
		<%
			String search = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels");
			String clear  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels");
		%> 
		<tr>
		        <!--<td class='label'><fmt:message key="eIP.IncludeReservedBeds.label" bundle="${ip_labels}"/></td>
				<td class='fields'><input type="checkbox" name="includereservebed_yn" id="includereservebed_yn" value='N' onclick='reserveBedChecked(this);'></td>
				<td class='label'>&nbsp;</td>-->

				<td class = 'label'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></td>
				<td class = 'fiels'><select name = 'select_bed' >
				<option value = 'B' selected><fmt:message key="Common.blocked.label" bundle="${common_labels}"/>&nbsp<fmt:message key="eIP.Beds.label" bundle="${ip_labels}"/></option>
				<option value = 'R' ><fmt:message key="eIP.ReservedBeds.label" bundle="${ip_labels}"/></option>
				<option value = 'A' ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				</select></td>
				<td class='label'>&nbsp;</td>
				<td class='fields'><input type="button" class="button" name="search" id="search" value="<%=search%>" onClick="javascript:callDetail('<%=request.getQueryString()%>');"><input type="button" class="button"  name="clear" id="clear" value="<%=clear%>" onClick="javascript:clearValues('<%=request.getQueryString()%>');"></td>
		</tr>
       </table> 
   </table>
	<input type=hidden name='facilityID' id='facilityID' value='<%=facilityID%>'>
	<input type=hidden name='loginUser' id='loginUser' value='<%=loginUser%>'>
	<input type=hidden name='operstn' id='operstn' value='<%=operstn%>'>
	<input type='HIDDEN'  name='call_function' id='call_function' value='RELEASE_BED' >
	<input type='hidden' name = 'locale' value="<%=locale%>">  
 </form>
 </body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

