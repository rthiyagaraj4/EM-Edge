<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="eOT.*, eOT.Common.*, eCommon.Common.CommonBean,java.util.ArrayList,eOT.Common.OTRepository,eCommon.Common.*" %>

<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eOT/js/SlateReSchedule.js"></script>
	<script language="JavaScript" src="../../eOT/js/Slate.js"></script>
	<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<style>
		 TD.OTMENULAYER
		  {
	 	  FONT-FAMILY: VERDANA ;
	 	  FONT-SIZE: 10PT ;
	 	  BACKGROUND-COLOR: #D8BFD8;
	 	  COLOR: WHITE;
		}
		TD.OTMENU
		  {
			BACKGROUND-COLOR: #C0C0C0 ;
			FONT-SIZE: 9PT ;
			BORDER-STYLE: DASHED;
			BORDER-LEFT-COLOR: #FFA500;
			BORDER-RIGHT-COLOR: #FFA500;
			BORDER-TOP-COLOR: #FFFACD;
			BORDER-BOTTOM-COLOR: #FFFACD;
		  }
	</style>
</head>
<%
String facility_id	= (String) session.getValue("facility_id");
String mode			= (String)CommonRepository.getCommonKeyValue("MODE_INSERT") ;
String params		= request.getQueryString() ;
String refresh_flag	= request.getParameter("refresh_flag");
String booking_date	= "";
String view_status	= "P";
String speciality	= "";
String theatre_type	= "ALL";
String surgeon		= "";
String surgeon_name = "";
String theatre		= "";
String bean_id		= "SlateBean";
String bean_name	= "eOT.SlateBean";
SlateBean   bean  = (SlateBean)mh.getBeanObject(bean_id, request, bean_name);
String sql_ot_slate_select5=(String) OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT5");

if(refresh_flag!=null && !refresh_flag.equals("null") && !refresh_flag.equals("")){
	booking_date	=	request.getParameter("booking_date");
	view_status	=	CommonBean.checkForNull(request.getParameter("view_status"),"S");
	speciality		=	request.getParameter("speciality");
	theatre_type	=	request.getParameter("theatre_type");
	surgeon			=	request.getParameter("surgeon");
	surgeon_name	=	request.getParameter("surgeon_name");
}
if(booking_date==null)
	booking_date = bean.getSysDateTime();
else if(booking_date.equals("null") || booking_date.equals(""))
	booking_date = bean.getSysDateTime();

%>
<body  onKeyDown = 'lockKey()'>
<form name="SlateSearchForm" id="SlateSearchForm" >
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
<tr>
	<td width="25%" class="label">
		<fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/>
	</td>
	<td width="25%" class="fields">
		<input type="text" name="booking_date" id="booking_date" size="10" maxlength=10 value="<%=booking_date%>" disabled>
	</td>


	<td width="25%" class="label">
		<fmt:message key="eOT.TheatreType.Label" bundle="${ot_labels}"/>
	</td>
	<td width="25%" class="fields" colspan="1"><select name="theatre_type" id="theatre_type"  onChange="validateReScheduleTheatre();">
		<option value="ALL">
		<fmt:message key="eOT.AllTheatres.Label" bundle="${ot_labels}"/></option>

			<%
				String theatre_type_temp   = "";
				String theatre_type_select = "";
				ArrayList arr_list_theatre_types = bean.getTheatreTypes();
				if(arr_list_theatre_types!=null){
					for (int i=0;i<arr_list_theatre_types.size();i=i+2){
						theatre_type_temp   = (String)arr_list_theatre_types.get(i);
						if(theatre_type.equals(theatre_type_temp)){
							theatre_type_select = "selected";
						}else {
							theatre_type_select = "";
						}
			%>
					<option value="<%=theatre_type_temp%>" <%=theatre_type_select%>> 
						<%=arr_list_theatre_types.get(i+1)%>	
					</option>
			<%
					}
				}
			%>
		</select>
	</td>
</tr>
<tr>
	<td width="25%" class="label">
		<fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>
	</td> 
	<td width="25%" class="fields"><select name="theatre" id="theatre">
		<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<%
				if(theatre_type!=null && !theatre_type.equals("null") && !theatre_type.equals("")){
					String theatre_temp   = "";
					String theatre_select = "";
					ArrayList arr_list_theatres = bean.getTheatres(theatre_type);
					if(arr_list_theatres!=null){
						for (int i=0;i<arr_list_theatres.size();i=i+2){
							theatre_temp   = (String)arr_list_theatres.get(i);
							if(theatre.equals(theatre_temp)){
								theatre_select = "selected";
							}else {
								theatre_select = "";
							}
			%>
						<option value="<%=theatre_temp%>" <%=theatre_select%>> 
							<%=arr_list_theatres.get(i+1)%>	
						</option>
			<%
						}
					}
				}
			%>
		</select><img src="../../eCommon/images/mandatory.gif" id="mand_id_" ></img>
		<input type='hidden' name='theatre_from' id='theatre_from' value="">
		<input type='hidden' name='theatre_to' id='theatre_to' value="" >
	</td>
	<td width="25%" class="label" >
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	<td width="25%" class="fields" ><select name="speciality" id="speciality">
		<option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
			<%
				String speciality_code_temp   = "";
				String speciality_code_select = "";
				ArrayList arr_list_speciality_codes = bean.getSpecialities();
				if(arr_list_speciality_codes!=null){
					for (int i=0;i<arr_list_speciality_codes.size();i=i+2){
						speciality_code_temp   = (String)arr_list_speciality_codes.get(i);
						if(speciality.equals(speciality_code_temp)){
							speciality_code_select = "selected";
						}else {
							speciality_code_select = "";
						}
			%>
					<option value="<%=speciality_code_temp%>" <%=speciality_code_select%>> 
						<%=arr_list_speciality_codes.get(i+1)%>	
					</option>
			<%
					}
				}
			%>
		</select>
	</td>
</tr>
<tr>
	<td width="25%" class="label" colspan="1">
		<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
	<td width="25%" class="fields">
		<input name='surgeon_name' id='surgeon_name' maxlength='30' size='15' value= "<%=surgeon_name%>"  >
		<input type="hidden" name="surgeon" id="surgeon" value="<%=surgeon%>">
		<input type='button' class='button' value='?' name='generic_search' id='generic_search' onClick="return searchSurgeonslate(document.SlateSearchForm.surgeon_name);" >
	</td>

	<td width="25%" class="label" >
		<fmt:message key="Common.status.label" bundle="${common_labels}"/>	
	</td>
	<td width="25%" class="fields" colspan="1">
		<select name="view_status" id="view_status">
		<%	if(view_status.equals("P")){
		%>
				<option value="P" selected><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option>
				<option value="C"><fmt:message key="eOT.CancelledCases.Label" bundle="${ot_labels}"/></option>
				<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
		<%
			}else if(view_status.equals("C")){
		%>
				<option value="P" ><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option>
				<option value="C" selected><fmt:message key="eOT.CancelledCases.Label" bundle="${ot_labels}"/></option>
				<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
		<%
			}else if(view_status.equals("B")){
		%>
				<option value="P"><fmt:message key="Common.Pending.label" bundle="${common_labels}"/></option>
				<option value="C"><fmt:message key="eOT.CancelledCases.Label" bundle="${ot_labels}"/></option>
				<option value="B" selected><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
		<%
			}
		%>
		</select>
	</td>
</tr>
<tr>
	<td width='25%'></td>
	<td width='25%'></td>
	<td width='25%'></td>
	<td width="25%" class="fields">
		<input type="button" class="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="searchSlateReSchedule()">
	</td>
</tr>
</table>
	<input type='hidden' name='params' id='params' value='<%=params%>' >
	<input type='hidden' name='mode' id='mode' value='<%=mode%>' >
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>' >	
	<input type='hidden' name='sql_ot_slate_select5' id='sql_ot_slate_select5' value="<%=sql_ot_slate_select5%>">

	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<input type="hidden" name="function_id_list" id="function_id_list" value="">		
	<input type="hidden" name="function_name_list" id="function_name_list" value="">		
	<input type="hidden" name="url_desc_list" id="url_desc_list" value="">		

</form>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=3  cellspacing='3' border='0'  width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='menu_table'></td>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>

