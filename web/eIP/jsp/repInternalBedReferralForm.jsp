<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="com.ehis.util.*,java.util.*,java.sql.*,java.text.*,webbeans.eCommon.*,org.json.simple.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		 request.setCharacterEncoding("UTF-8"); %>

<html>
<HEAD>
<TITLE></TITLE>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script src="../../eCommon/js/ValidateControl.js" language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js" language='javascript'></script>
<script src="../../eIP/js/repInternalBedReferral.js" language="JavaScript"></script>
<script src='../../eIP/js/RepDeathRegister.js' language='javascript'></script>

</HEAD>
<%
    request.setCharacterEncoding("UTF-8"); 
	Connection con=null;
	String p_module_id		= "IP" ;
	String p_report_id		= "IPIBEREF" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String p_resp_id		= (String) session.getValue("responsibility_id");
	String pat_length = "";
	String locale = (String)session.getAttribute("LOCALE");
	JSONArray facility=null;	

	try{
		con  =  ConnectionManager.getConnection(request);
		facility=eAM.AMCommonBean.getFacility(con,p_user_name,p_resp_id);
		pat_length=eCommon.Common.CommonBean.getPatIdLength(con);
		
  
%>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()' onload='FocusFirstElement()'>
<form name="repInternalBedReferralForm" id="repInternalBedReferralForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
                <br>
                <br>
				<table width='80%' cellPadding="4" cellSpacing="0"  align='center' border='0'>
			<th align='left' colspan="3"> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
			</th>
					
					<tr>
		               <td class="label">&nbsp;</td>
		               <td class="querydata" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</td>
		               <td class="querydata" style="font-weight: bold;" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	                </tr>

					<tr>
		                <td  width='20%' class="label" align='right' nowrap><fmt:message key="Common.referral.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></td><td width='5%' align='left'><input type=text id="p_date_from" name='p_fm_ref_date' id='p_fm_ref_date' size="10" maxlength="10" onblur="ValidateDate(this);DateCompare(p_fm_ref_date,p_to_ref_date);" ><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_from'); ValidateDate(this);DateCompare(p_fm_ref_date,p_to_ref_date);">&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
		                </td>
		                <td width='5%' align='left'><input type=text id="p_date_to"  name='p_to_ref_date' id='p_to_ref_date' size="10" maxlength="10" onblur="ValidateDate(this);DateCompare(p_fm_ref_date,p_to_ref_date);"><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_date_to');DateCompare(p_fm_ref_date,p_to_ref_date);ValidateDate(this);">&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
		                </td>
	                </tr>

					<tr>
                        <td class="label">&nbsp;</td>
                    </tr>

				    <tr>			
						<td  width='30%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> &nbsp;</td>
						<td width = '30%' class = 'fields'><input type=text  name='p_patient_id' id='p_patient_id' id='p_patient_id' size=<%=pat_length%> maxlength=<%=pat_length%> onBlur="ChangeUpperCase(this);"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen()'></td>
						<td>&nbsp;</td>
				    </tr>

				    <tr>
                        <td class="label">&nbsp;</td>
                    </tr>

				    <tr>
						<td  width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/></td>
						<td width='30%' class="fields" >
							<input type=text  name='p_fm_nursg_unit_code' id='p_fm_nursg_unit_code' id='p_fm_nursg_unit_code' size="4" maxlength="4" align="center" ><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this, p_fm_nursg_unit_code)' >
						</td>
						<td width='40%' class="fields"> 
							<input type=text  name='p_to_nursg_unit_code' id='p_to_nursg_unit_code' size="4" id='p_to_nursg_unit_code' maxlength="4" align="center" ><input type='button' name='nursing_unit_code' id='nursing_unit_code' value='?' class='button' onclick='searchCode(this,p_to_nursg_unit_code)' >
						</td>
					
				    </tr>

				    <tr>
                        <td class="label">&nbsp;</td>
                    </tr>

				    <tr>
					    <td  width='30%' class="label"><fmt:message key="Common.SpecialityCode.label" bundle="${common_labels}"/></td>
					    <td width='30%' class="fields" >
						<input type=text  name='p_fm_splty_code' id='p_fm_splty_code' size="4" id='p_fm_splty_code'maxlength="4" align="center" ><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fm_splty_code)'>
					    </td>
					    <td width='40%' class="fields"> 
						<input type=text  name='p_to_splty_code' id='p_to_splty_code' size="4" id='p_to_splty_code'maxlength="4" align="center" ><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_splty_code)'>
					    </td>
				    </tr>

				    <tr>
                        <td class="label">&nbsp;</td>
                    </tr>

					<tr>
		               <td class="label">&nbsp;</td>
		               <td class="querydata" ><fmt:message key="Common.referredby.label" bundle="${common_labels}"/>&nbsp;</td>
		               <td class="querydata" ><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></td>
	                </tr>

			        <tr>
                        <td width='40%' class="label" align='left' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
                        <td class="fields" width='20%' align='left'><input type="text" name="p_fm_pract_id" id="p_fm_pract_id" size="6" maxlength="15" ><input type='button' name='practitioner_id1' id='practitioner_id1' value='?' class='button' onclick="searchCode(this, p_fm_pract_id)">
						</td>
                        <td  width='40%' align='left'><input type="text" name="p_to_pract_id" id="p_to_pract_id" size="6" maxlength="15" ><input type='button' name='practitioner_id2' id='practitioner_id2' value='?' class='button' onclick="searchCode(this, p_to_pract_id)" >
                        </td>
                    </tr>		   

				    <tr>
                        <td class="label">&nbsp;</td>
                    </tr>

				    <tr>
		                <td align="left" class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
		                <td colspan ="3"> 
				        <select name='p_for_facility_id' id='p_for_facility_id'>
			            <% for(int i=0;i<facility.size();i++){
							JSONObject jsonObj = (JSONObject) facility.get(i);
							
						
						   if(jsonObj.get("facility_id").equals("All"))
                               out.println("<option value='"+jsonObj.get("facility_id")+ "'  selected>"+jsonObj.get("facility_name")+"</option>");
						   else
					           out.println("<option value='"+jsonObj.get("facility_id")+ "' >"+jsonObj.get("facility_name")+"</option>");
						} %>
			                 </select>
		                  </td>
	                    </tr>

			</table>	
                
		<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%= p_facility_id %>">
		<input type="hidden" name="p_module_id" id="p_module_id" value="<%= p_module_id %>">
		<input type="hidden" name="p_report_id" id="p_report_id" value="<%= p_report_id %>">
		<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">
		<input type='hidden' name="locale" id="locale" value="<%=locale%>">
           
</form>
</body>
</html>
<%
}catch(Exception e){out.println(e);}
finally { 
	ConnectionManager.returnConnection(con,request);
}
%>


