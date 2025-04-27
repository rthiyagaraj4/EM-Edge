<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>      
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*" %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script language="javascript" src="../../eCommon/js/CommonLookup.js"> </script>
<script src='../../eOA/js/Blockapptslots.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%request.setCharacterEncoding("UTF-8");%>

<%
request.setCharacterEncoding("UTF-8");

String facilityid=(String)session.getValue("facility_id");
//String oper_stn_id=request.getParameter("oper_stn_id");
//if(oper_stn_id==null) oper_stn_id="";
String locale=(String)session.getAttribute("LOCALE");

String others_id = ""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114


String slot_appt_ctrl  ="";
String visit_limit_rule="";
String 	sys_date="";
String	sys_time="";
Connection con=null;
ResultSet rs	=null;
PreparedStatement pstmt=null;	
try{
	con=ConnectionManager.getConnection(request);

	/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
	HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(con, "OA","REMARKS_FOR_OTHERS");
	others_id	= (String)hashdata.get("value1");
	if(others_id == null) others_id = "";
	/*End ML-MMOH-CRF-1114*/
%>

<html>

<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()' onload='disableFields()'>

<form name='blockappt_form' id='blockappt_form'  action='../../servlet/eOA.BlockAppointmentServlet' method='post' target='messageFrame'>

<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center' id='main' >	
		
	<tr>
		
		<td  class='label' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td class='fields' >
		
		<%	String sqlloc = " Select Locn_Type, Short_Desc, CARE_LOCN_TYPE_IND from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and locn_type in ('C','E','Y') and language_id = ? order by short_desc";
		pstmt = con.prepareStatement( sqlloc ) ;
		pstmt.setString(1,locale);
		rs=pstmt.executeQuery();
		%>
			<select name='location1' id='location1' width='4' onchange='locationreturn(this)'> 
			<option value=''> -------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- </option>
		<%
			String locn_type="";
			String short_desc1="";
			if(rs !=null){
				while(rs.next()){
					locn_type=rs.getString("CARE_LOCN_TYPE_IND");
					short_desc1=rs.getString("short_desc");
				%>
				<option value='<%=locn_type%>'><%=short_desc1%>
				<%
				}
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(rs !=null){
				rs.close();
			}
		%>		
				</select>
			</td>

			<td  class='label' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>

			<!--<td class="fields"  id='loc' >
                  <SELECT name='location' id='location'  onChange='enablepr(this);validateTbs();'>
				  <OPTION value=''  style='align:center'>-----------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----------------------
                  </SELECT><img  src="../../eCommon/images/mandatory.gif"     align='center'></img>
			</td>-->
			<td class='fields' id='loc' colspan='2'>
			<input type='text' name='b_loc_val' id='b_loc_val' value='' onblur='ena_loc_lookup(this);' size=30 maxlength=30 ><input type='button' value='?' onclick='open_loc_lookup();' class='button' name='b_loc_search' id='b_loc_search'><img src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='location' id='location' value=''></td>						  
				  
		 </tr>
		
		 <tr>
			 <td class='label' ><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
			 
			 <td class='fields'>
						<SELECT name='resource' id='resource' id='resource' onchange='practValidate(this);' onblur='resourceOnBlur();'>
                        <OPTION value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----
                        <OPTION value='P'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
                        <OPTION value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/>
                        <OPTION value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/>
    				    <OPTION value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> 
						</SELECT><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			</td>

			<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from_page" value= "block" />
					<jsp:param name ="pract_value" value= "" />
					</jsp:include>
		<!-- 	
			 <td class='label' ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>

			<td class='fields'>
				<input type=text size='30' maxlength='30' name='practitioner_name' id='practitioner_name' disabled onblur="onblurcheck(this,practitioner_name,document.forms[0].resourceType)"><input type='button' name='pract_search' id='pract_search' value='?' class='button' id = 'pract_butt'  onClick="callPractSearch(this,practitioner_name,document.forms[0].resourceType);" disabled><img id='imgpract' src='../../eCommon/images/mandatory.gif' align='center'></img><input type='hidden'  name='pract' id='pract' value=''>
			</td> -->
		</tr>

		<tr>
			<td  nowrap class='label'><fmt:message key="eOA.BlockDate.label" bundle="${oa_labels}"/></td>
			
			<td class='fields'><input type=text size='10' id='blkapptslotdate' name='block_date1' id='block_date1' maxlength='10' onBlur='check_date(this)' onChange='cleared()' ><img style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="onClick=document.forms[0].block_date1.select();return showCalendar('blkapptslotdate');"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
				
			<td class='label'><fmt:message key="eOA.BlockTime.label" bundle="${oa_labels}"/></td>

			<td class='fields' colspan='2'><input type=text size='5'  name='b_from' id='b_from' maxlength='5' readonly>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type=text size='5' maxlength='5' name='b_to' id='b_to' readonly>
	  </tr>

		<tr>
			
			<td  class='label' ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
			<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
			<td class='fields'>
			<input type='text' name='reason_for_block1' id='reason_for_block1' value='' onblur='reasonlookup(this);displayRemarksForOtherReason(reason_code);' size=30 maxlength=30 ><input type='button' value='?' onclick='reasonlookup(this);displayRemarksForOtherReason(reason_code);' class='button' name='reasonclick' id='reasonclick'><img src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='reason_code' id='reason_code' value=''></td>
			
			<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
			<td class=label id='remarks_labl' style='display:none'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
			<td class="fields" id='remarks_fld' style='display:none'><textarea rows=2 cols=45 name="other_remarks" onkeyPress='checkMaxLimit(this,100)' onBlur="SPCheckMaxLen('Remarks',this,100)"></textarea><img src='../../eCommon/images/mandatory.gif' id='remarks_img' style='visibility:hidden'></td>
			<!--End ML-MMOH-CRF-1114-->

			<td  class='button' align='right' colspan='3'><input type='button'  class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='check_mandatory();'>
			</td>
			<%
			pstmt = con.prepareStatement("select slot_appt_ctrl,visit_limit_rule, to_char(sysdate,'dd/mm/yyyy') sysdt,to_char(sysdate,'hh24:mi') systm from oa_param where module_id='OA'") ;
			rs = pstmt.executeQuery();
			if(rs.next()){
				slot_appt_ctrl  = rs.getString("slot_appt_ctrl");
				visit_limit_rule= rs.getString("visit_limit_rule");
				sys_date=rs.getString("sysdt");
				sys_time=rs.getString("systm");
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(rs !=null){
				rs.close();
			}
			%>
				
		</tr>
		<input type="hidden" name='resourceType' id='resourceType' value="">
		<input type='hidden' name='block_date' id='block_date' value=''>
		<input type='hidden' name='block_from_time' id='block_from_time' value=''>
		<input type='hidden' name='block_to_time' id='block_to_time' value=''>
		<input type='hidden' name='reason_for_block' id='reason_for_block' value=''>
		<input type='hidden' name='clinic' id='clinic' value=''>
		<input type='hidden' name='time_per_patient' id='time_per_patient' value=''>
		<input type='HIDDEN' name='identityCheckIn' id='identityCheckIn' value=''>
		<input type='hidden' name='function' id='function' value='insert'>
		<input type='hidden' name='function_name' id='function_name' value='insert'>
		<input type='hidden' name='check' id='check' value='bbb'>
		<input type='hidden' name='insert_detail' id='insert_detail' value='N'>
		<input type='hidden' name='final_values' id='final_values' value=''>					
		<input type='hidden' name='first_visits_value' id='first_visits_value' value=''>					
		<input type='hidden' name='other_visits_value' id='other_visits_value' value=''>
		<input type='hidden' name='locationtype' id='locationtype' value=''>
		<input type='hidden' name='facilityid' id='facilityid' value='<%=facilityid%>'>
		<input type='hidden' name='slot_appt_ctrl' id='slot_appt_ctrl' value='<%=slot_appt_ctrl%>'>
		<input type='hidden' name='visit_limit_rule' id='visit_limit_rule' value='<%=visit_limit_rule%>'>
		<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
		<input type='hidden' name='sys_time' id='sys_time' value='<%=sys_time%>'>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<input type='hidden' name='Slot_fully_blocked' id='Slot_fully_blocked' value=''>
		<input type='hidden' name='time_table_type' id='time_table_type' value=''>
		<input type='hidden' name='max_patients_per_slab' id='max_patients_per_slab' value=''>
		<input type='hidden' name='from_count' id='from_count' value= '' >
		<input type='hidden' name='final_count' id='final_count' value= '' >

		<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
		<input type='hidden' name='others_id' id='others_id' value='<%=others_id%>'>

			
		</table>
</form>
</body>
<script>
document.forms[0].location1.focus();
document.getElementById("imgpract").style.visibility='hidden'
</script>
</html>
<%
	if (rs != null) rs.close();
	if (pstmt != null) pstmt.close();

}catch(Exception e) { 
	//out.println(e.toString());
	e.printStackTrace();
}finally{
	ConnectionManager.returnConnection(con,request);
}
%>

