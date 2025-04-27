<!DOCTYPE html>
<%@page  contentType="text/html;charset=UTF-8" import="java.util.*, eOT.*, eOT.Common.*, eCommon.Common.*" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<html>
<head>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eOT/js/SlateWaitlist.js"></script>
	<script language="JavaScript" src="../../eOT/js/Slate.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
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
String preferred_date	= "";
String speciality	= "";
String surgeon		= "";
String surgeon_name = "";
String bean_id		= "SlateBean";
String bean_name	= "eOT.SlateBean";
SlateBean   bean  = (SlateBean)mh.getBeanObject(bean_id, request, bean_name);
String sql_ot_slate_select5=(String) OTRepository.getOTKeyValue("SQL_OT_SLATE_SELECT5");

if(refresh_flag!=null && !refresh_flag.equals("null") && !refresh_flag.equals("")){
	preferred_date	=	request.getParameter("preferred_date");
	speciality		=	request.getParameter("speciality");
	surgeon			=	request.getParameter("surgeon");
	surgeon_name	=	request.getParameter("surgeon_name");
}
if(preferred_date==null)
	preferred_date = bean.getSysDateTime();
else if(preferred_date.equals("null") || preferred_date.equals(""))
	preferred_date = bean.getSysDateTime();

%>
<body onKeyDown = 'lockKey()' >
<form name="SlateSearchForm" id="SlateSearchForm" >
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
<tr>
	<td width="25%" class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	<td width="25%" class="fields"><select name="speciality" id="speciality">
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
		</select><img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td width="25%" class="label"><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
	<td width="25%" class="fields"><input name='surgeon_name' id='surgeon_name' maxlength='30' size='15' value= "<%=surgeon_name%>">
<input type="hidden" name="surgeon" id="surgeon" value="<%=surgeon%>">
<input type='button' class='button' value='?' name='generic_search' id='generic_search' onClick="return searchSurgeonslate(document.SlateSearchForm.surgeon_name);">
	</td>
</tr>
<tr>
	<td width="25%" class="label"><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/>
	</td>
	<td width="25%" class="fields">
		<input type="text" name="preferred_date" id="preferred_date" size="10" maxlength=10 value="<%=preferred_date%>" disabled>
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('preferred_date');"><img src='../../eCommon/images/mandatory.gif'></img>
	</td>

	<td width='25%'></td>
	<td width='25%' class="fields">
	<input type="button" class="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onclick="searchSlateWaitlist()">
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
		<table id='tooltiptable' cellpadding=3  cellspacing=0 border='0'  width='100%' height='100%' align='center'>
			<tr>
				<td width='100%' id='menu_table'></td>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>

