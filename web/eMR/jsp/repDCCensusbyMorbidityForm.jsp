<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "MR" ;
	String p_report_id		= "MRDCCSMB" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
%>

<html>	
<HEAD>
<TITLE></TITLE>
	<%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eMR/js/MRReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown='lockKey()' onLoad="mychangerepDCCensusbyMorbidity()">
<br>
<br>
<form name="repDCCensusbyMorbidityForm" id="repDCCensusbyMorbidityForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >
				<tr>
					<td align='right' width='35%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>&nbsp;</td>
					<td width='25%'>
						 <SELECT name="p_type" id="p_type" onchange='mychangerepDCCensusbyMorbidity()'>
						 <option value="D"><fmt:message key="Common.daily.label" bundle="${common_labels}"/></option>
						 <option value="M"><fmt:message key="Common.monthly.label" bundle="${common_labels}"/></option>
						 <option value="Y"><fmt:message key="Common.Yearly.label" bundle="${common_labels}"/></option>
						 </SELECT>
					</td>
						 <td >&nbsp; </td>
				</tr>
						 <td colspan ='3'> 

				<tr>
					<td align='right' width='35%' class="label">&nbsp;</td>
					<td width='25%'  ></td>
					<td >&nbsp;</td>
				</tr>
					<td colspan ='3'></td>
				<tr>
						<td align='right' id='MY1'class="label">&nbsp;</td>
						<td align='left' id='MY' > &nbsp; </td>
						<td align='left' id='MY2' > &nbsp; </td>
						<td> </td>
				</tr>
				<tr>
					<td align='right' width='35%' class="label"> &nbsp;</td>
					<td width='25%'  ></td>
					<td>&nbsp;</td>
					
				</tr>
			<!-- <tr>
					<td width='2%'  align='left'>&nbsp;</td>
					
					<td class='label' align='left'>From</td>
					
					<td class='label' align='left'>To</td>
					<td width='30%'' align='left'>&nbsp;</td>
          </tr> -->
		 <!--  <tr>
             <td width='30%' align='right' class='label' nowrap>Tab List &nbsp;&nbsp;</td>
             <td align='left'>
               <input name='p_fm_tab_list' id='p_fm_tab_list' onkeypress='return ValidStringrepAdm(event)' value='' size='5' maxlength='4' ><input type='button' name='tab1st' id='tab1st' value='?' class='button' onclick='searchCoderepIPCensusbyMorbidity(this, p_fm_tab_list)'>
              </td> -->
             <!--  <td align='left'>
               <input name='p_to_tab_list' id='p_to_tab_list' onkeypress='return ValidStringrepAdm(event)' value='' size='5' maxlength='4' ><input type='button' name='tablst' id='tablst' value='?' class='button' onclick='searchCoderepIPCensusbyMorbidity(this, p_to_tab_list)'>
             </td>
          </tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr> -->
				
				
             <!-- <tr>
             <td width='30%' align='right' class='label' nowrap>Diag Group Code&nbsp;&nbsp;</td>
             <td align='left'>
               <input name='p_fm_diag_code' id='p_fm_diag_code'onkeypress='return ValidStringrepAdm(event)' value='' size='5' maxlength='4' ><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCoderepIPCensusbyMorbidity(this, p_fm_diag_code)'>
              </td> -->
              <!-- <td align='left'>
               <input name='p_to_diag_code' id='p_to_diag_code'onkeypress='return ValidStringrepAdm(event)' value='' size='5' maxlength='4' ><input type='button' name='locn' id='locn' value='?' class='button' onclick='searchCoderepIPCensusbyMorbidity(this, p_to_diag_code)'>
             </td>
          </tr>
		  <tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr> -->
					<!-- <td align='right' width='35%' class="label">Report By&nbsp;</td>
					<td width='25%'>
						 <SELECT name="report_by" id="report_by" >
						 <option value="D">Detail</option>
                         <option value="S">Summary</option>
						 </SELECT>
					</td>
						 <td >&nbsp; </td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td> -->
				<!-- </tr> -->

		</table>
	</td>
</tr>
		</table>
	</td>
</tr> 
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="buffers" id="buffers"			value="1200">

</form>
</BODY>
</HTML>

