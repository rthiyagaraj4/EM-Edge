<!DOCTYPE html>
    
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.text.*,webbeans.eCommon.* " %> 

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script language="javascript" src="../../eOA/js/TransferClinicSch.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
	request.setCharacterEncoding("UTF-8");	

	String facilityId = (String) session.getValue( "facility_id" ) ;
	String p_user_name= (String) session.getValue( "login_user" ) ;
   String locale=(String)session.getAttribute("LOCALE");

	Connection con = null;
	Statement stmt		=null;
	ResultSet rset		=null ;
	String dat = "",ID = "",currentdate = "",datval1 ="",oper_stn_id="";
	String default_select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	
	try{
		con = ConnectionManager.getConnection(request);

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(con, "OA","REMARKS_FOR_OTHERS");
		String others_id	= (String)hashdata.get("value1");
		if(others_id == null) others_id = "";
		/*End ML-MMOH-CRF-1114*/
%>

	</head>

	<body onLoad="chgbuttonclr();"  OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()'>
	
		<form name='TransferClinicSch_form' id='TransferClinicSch_form' target="messageFrame">
			<div>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='100%' >

		<tr>
			<td width='25%' class='label'><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>

			<td width='25%' class='fields'>
				<SELECT name='location_type' id='location_type' onChange="javascript:populateLocations(this)">
				<option>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----
				<%
					stmt=con.createStatement();
					String sqlLoc="select locn_type,short_desc,CARE_LOCN_TYPE_IND, to_char(sysdate,'dd/mm/yyyy') d ,  to_char(sysdate,'ddmmyyyyhh24miss') dtm  from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y')  and  language_id='"+locale+"' order by short_desc ";
					rset=stmt.executeQuery(sqlLoc);
					if(rset!=null)
					{
					   while(rset.next())
					   {
						dat=rset.getString("short_desc");
						ID=rset.getString("CARE_LOCN_TYPE_IND");
						currentdate = rset.getString("d");
						datval1 =rset.getString("dtm");

						out.println("<option value='"+ID+"' >"+dat+"</option>");
						}
					}
					if(rset !=null) rset.close();
					%>
				</select></td>
						
				<td width='25%' class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td width='25%' class='fields'><input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='' onblur="ena_loc_lookup(this);"><input type="hidden" name="location" id="location" ><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup();" class='button'>
				
				
					  </select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
					  <input type="hidden" name="locationField" id="locationField" value="">
					  </td>
	</tr>
	<tr>
			<td width='25%' id='locn_type' value='' class='label'><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
			<td width='25%' class='fields'>		
					<SELECT name='resourceType' id='resourceType'  onchange="enable_dsiable_res(this)" disabled >
					<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
					<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
					<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
					<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
					<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
				
				</SELECT><img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
					

				<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from_page" value= "block_lift_cancel" />
					<jsp:param name ="pract_value" value= "" />
					</jsp:include>

		<!-- 	<td width='25%' id='locn_type' value='' class='label'><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
			<td width='25%' class='fields'>		
				
				<input type=text size='25' maxlength='30' name='practitioner_name' id='practitioner_name' onblur="onblurcheck(this,practitioner_name)" disabled><input type='button' name='pract_search' id='pract_search'  disabled value='?' class='button' onClick="callPractSearch(this,practitioner_name);" disabled><input type='hidden' name='practitioner' id='practitioner' value=''></td> -->
</tr>
<tr>
	
		<td width='25%'  class='label'><fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
		<td width='25%' class='fields'>
			<input type=radio name='date_day' id='date_day'  value='A' onClick="clearDetail('X');changeDate(this);"><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		
		<td width='25%'  class='label'><fmt:message key="Common.by.label" bundle="${common_labels}"/></td>
		<td width='25%' class='fields'>
			<input type=radio name='date_day' id='date_day' value='Y'  onClick="clearDetail('X');changeDate(this);" checked><fmt:message key="Common.day.label" bundle="${common_labels}"/></td>
		
</tr>
<tr>
	<td id='date' width='25%' class='label' nowrap><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
	<td width='25%' id='to' nowrap>
		<input type='text' id='clinicfrom' name='eff_from' id='eff_from' value='' size='10' maxlength='10' onChange="clearDetail('X')" Onblur='validate_date_from(this,eff_to);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif"  onClick="  document.forms[0].eff_from.select();return showCalendar('clinicfrom');"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
	
	<td id='date' width='25%' class='label' nowrap><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
	<td width='25%' id='to' nowrap>
		<input type='text' id='clinicto' name='eff_to' id='eff_to' value='' size='10' maxlength='10' onChange="clearDetail('X');" Onblur='validate_date_to(this,eff_from);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif"  onClick=" document.forms[0].eff_to.select();return showCalendar('clinicto');"><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td> 
</tr>
<tr>
			<td width='25%' class='label' nowrap><fmt:message key="eOA.FromDay.label" bundle="${oa_labels}"/></td>
			<td class='fields' width="25%">
				<select name='from_day' id='from_day' onChange="clearDetail('X');PopToDays(this);">
				<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
				</select>
				<font id='ch1'><img src='../../eCommon/images/mandatory.gif' align='center'></img></font></td>
			<td class='label' width='25%'><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.day.label" bundle="${common_labels}"/></td>
			<td class=fields' width='25%'>
				<select name='to_day' id='to_day' onChange="clearDetail('X')">
				<option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				</select>
				<font id='ch2'><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</font></td>
</tr>


<tr>
		
			
			<td  class='label' ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>

			<td class='fields'>
			<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
			<input type='text' name='reason' id='reason' value='' onblur='reasonlookup(this);displayRemarksForOtherReason(reason_code);' size=30 maxlength=30 ><input type='button' value='?' onclick='reasonlookup(this);displayRemarksForOtherReason(reason_code);' class='button' name='reasonclick' id='reasonclick'><img src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='reason_code' id='reason_code' value=''></td>

			<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->

			<td class=label id='remarks_labl' style='display:none'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class="fields" id='remarks_fld' style='display:none'><textarea rows=2 cols=45 name="other_remarks" onkeyPress='checkMaxLimit(this,100)' onBlur="SPCheckMaxLen('Remarks',this,100)"></textarea><img src='../../eCommon/images/mandatory.gif' id='remarks_img' style='visibility:hidden'></td>
			<!--End ML-MMOH-CRF-1114-->

</tr>

<tr>
			<td class='label' colspan=4>&nbsp;</td>
</tr>

<tr>

		  <td class='label'>&nbsp;</td>
		  <td class='label'>&nbsp;</td>
		  <td class='label'>&nbsp;</td>
          <td class='button' width='25%'>
			  <input type='button' name='generaterep' id='generaterep' id='genRep' value='<fmt:message key="Common.Generate.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.report.label" bundle="${common_labels}"/>' class='button'  onClick='gen_report();' disabled>&nbsp;<input type='button' name='Select' id='Select' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' class='button' onClick='blank_chk(this.name)'></td>
</tr>

	</table>
			</div>
	 
	 
			<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
			<input type='hidden' name='no_days' id='no_days' value='' >
			<input type='hidden' name='only_header' id='only_header' value='' >
			<input type="hidden" name="P_Facility_id" id="P_Facility_id" value='<%=facilityId%>'>
	        <input type="hidden" name="oper_stn_id" id="oper_stn_id" value='<%=oper_stn_id%>'>
			<input type='hidden' name='P_Clinic_Code' id='P_Clinic_Code' value='' >
			<input type='hidden' name='P_Practitioner_Id' id='P_Practitioner_Id' value='' >
			<input type="hidden" name="p_module_id" id="p_module_id"   value="OA"></input>
			<input type="hidden" name="p_report_id" id="p_report_id"   value="OAAFAPLST"></input>
			<input type='hidden' name='p_user_id' id='p_user_id' value='<%=p_user_name%>'></input>
			<input type='hidden' name='P_From_Date' id='P_From_Date' value=''></input>
			<input type='hidden' name='P_To_Date' id='P_To_Date' value=''></input>
			<input type='hidden' name='P_Reason' id='P_Reason' value=''></input>
			<input type='hidden' name='P_Event_Date' id='P_Event_Date' value='<%=datval1%>'></input>
			<input type='hidden' name='P_Day_No' id='P_Day_No' value=''></input>
			<input type='hidden' name='P_To_Day_No' id='P_To_Day_No' value=''></input>
			<input type='hidden' name='P_Report_Title' id='P_Report_Title' value=''></input>
			<input type="hidden" name="P_Action" id="P_Action" value=''></input>
			<input type="hidden" name="res_pos_val" id="res_pos_val" value=''></input>
			<input type="hidden" name="cntval1" id="cntval1" value=''>
			<input type='hidden' name='ref_val' id='ref_val' value=''>
			<input type='hidden' name='default_select' id='default_select' value='<%=default_select%>'>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
			<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
			<input type='hidden' name='others_id' id='others_id' value='<%=others_id%>'>
	<%
	if(rset  !=null)	rset.close();
	if(stmt  !=null)	stmt.close();


}catch(Exception e){
	//out.print("here :" +e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
	ConnectionManager.returnConnection(con,request);
}
	%>


</form>
</body>
</html>

