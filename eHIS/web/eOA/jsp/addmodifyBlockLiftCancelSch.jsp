<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>        
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src="../../eOA/js/BlockLiftCancelSch.js" language="JavaScript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String p_user_name= (String) session.getValue( "login_user" ) ;	
%> 

<%
	Connection con = null;
	//Statement stmt=null;
	Statement stmt1=null;
	PreparedStatement pstmt=null;
	ResultSet rset=null ;
	String currentdate = "";
	String datval1 ="";
	String from_date ="";
	String to_date ="";
	String reason ="";
	String practitioner ="";
	String from_day ="";	
	String day_1="";
	String day_2="";
	String day_3="";
	String day_4="";
	String day_5="";
	String day_6="";
	String day_7="";
	String others_id = ""; //Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
    String locale=(String)session.getAttribute("LOCALE");
    String default_select=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	request.setCharacterEncoding("UTF-8");
	try{
		con=ConnectionManager.getConnection(request);	

		/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(con, "OA","REMARKS_FOR_OTHERS");
		others_id	= (String)hashdata.get("value1");
		if(others_id == null) others_id = "";
		/*End ML-MMOH-CRF-1114*/
		 
%>
	</head>
	<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey()' onload='disableFields()'>
		<form name='BlockLiftCancelSch_form' id='BlockLiftCancelSch_form' target="messageFrame">
		<div>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='100%' >
			<tr>

				
					<td class='label'><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
					<td class='fields' >
						<select name='action' id='action'  onChange="clearDetail(this);popReason(this);">
						<option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
						<option value='B'><fmt:message key="Common.block.label" bundle="${common_labels}"/></option>
						<option value='L'><fmt:message key="eOA.LiftBlock.label" bundle="${oa_labels}"/></option>
						<option value='C'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/></option>
						</select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
						
					<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
					<td  class='label'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></td>
					<td><input type='text' name='reason_desc' id='reason_desc'  onblur='reasonlookup(this);displayRemarksForOtherReason(reason);' size=30 maxlength=30 ><input type='button' value='?' onclick='reasonlookup(this);displayRemarksForOtherReason(reason);' class='button' name='reasonclick' id='reasonclick'><img src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='reason' id='reason' value=''></td>

			</tr>
			<tr>
				<td class='label' width='20%' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
				<td class='fields' width='30%'>
							<SELECT name='location_type' id='location_type' onChange="javascript:populateLocations(this)" style="width:130">
							<option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
								<%
								//stmt=con.createStatement();
								pstmt = con.prepareStatement( "select locn_type,short_desc,CARE_LOCN_TYPE_IND ,to_char(sysdate,'ddmmyyyyhh24miss') date1,to_char(sysdate,'dd/mm/yyyy') d from am_care_locn_type_lang_vw where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') and language_id = ?  order by short_desc " ) ;
								pstmt.setString(1,locale);
								rset=pstmt.executeQuery();
									if(rset!=null){
									   while(rset.next()) { %>
											<option value='<%=rset.getString("CARE_LOCN_TYPE_IND")%>'><%=rset.getString("short_desc")%></option>
									<%	datval1 =rset.getString("date1");
										currentdate = rset.getString("d");
				
										   
									   }
									}
								if(pstmt!=null){
									pstmt.close();
								}
								if(rset !=null){
									rset.close();
								}
								%>
							</select>
				<td class='label' width='20%' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td class='fields' width='50%'><input type='text' name='b_loc_val' id='b_loc_val' value='' onblur='ena_loc_lookup(this);' size=30 maxlength=30 ><input type='button' value='?' onclick='open_loc_lookup();' class='button' name='b_loc_search' id='b_loc_search'><img src='../../eCommon/images/mandatory.gif'></img>
				<!--<td class='fields' width='50%'>
								<select name='location' id='location' onChange="clearDetail();PopPract(this);" >
								<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>			
								</select><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>-->
				<input type="hidden" name="location" id="location" value="">
		</tr>
		<tr>							
				
				<td class='label' width='15%' nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td>
				<td class='fields' width="30%">	
							<SELECT name='resourceType' id='resourceType' onchange="enable_dsiable_res(this)" disabled>
							<option value=''> ----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----- </option>
							<option value='P' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/> </option>
							<option value='E'><fmt:message key="Common.equipment.label" bundle="${common_labels}"/></option>
							<option value='R'><fmt:message key="Common.room.label" bundle="${common_labels}"/> </option>
							<option value='O'><fmt:message key="Common.other.label" bundle="${common_labels}"/> </option>
							
						</SELECT><img  src='../../eCommon/images/mandatory.gif' align='center'></img>
					<jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="from_page" value= "block_lift_cancel" />
					<jsp:param name ="pract_value" value= "" />
					</jsp:include>

				<!-- <td class='label' width='15%' nowrap><fmt:message key="Common.resource.label" bundle="${common_labels}"/></td>
				<td class='fields' width="30%">		
						<input type=text size='25' maxlength='30' name='practitioner_name' id='practitioner_name' onblur="onblurcheck(this,practitioner_name)" disabled><input type='button' name='pract_search' id='pract_search'  disabled value='?' class='button' onClick="callPractSearch(this,practitioner_name);"><input type='hidden' name='practitioner' id='practitioner' value=''><img id='imgpract' src='../../eCommon/images/mandatory.gif' align='center'></img></td>  -->  
		</tr>
		<tr>
				<td class='label' nowrap ><fmt:message key="Common.DateRange.label" bundle="${common_labels}"/></td>
				<td width="30%" class='fields' valign='top'>
				<input type='text' id='blkliftfrom' name='eff_from' id='eff_from' size='10' maxlength='10'   Onblur='validate_date_from(this,eff_to);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].eff_from.select();return showCalendar('blkliftfrom');"><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				<input type='text' id='blkliftto'  name='eff_to' id='eff_to' size='10' maxlength='10'      Onblur='validate_date_to(this,eff_from);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].eff_to.select();return showCalendar('blkliftto');"><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
				
				<!--<td class='label' width='15%' nowrap><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>	
				<td class='fields' width="30%">	
				<input type='text' id='blkliftto'  name='eff_to' id='eff_to' size='10' maxlength='10'  onChange="clearDetail('X')" Onblur='validate_date_to(this,eff_from);'><img  style="cursor:pointer" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].eff_to.select();return showCalendar('blkliftto');"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>-->
				<td class='label' id="blockTimeNameID" style='visibility:hidden'><fmt:message key="eOA.BlockTime.label" bundle="${oa_labels}"/></td>
				<td class='fields' id="blockTimeID" style='visibility:hidden'><input type=text size='5'  name='blk_time_from' id='blk_time_from' maxlength='5' onKeyUp="javascript:formatTimeForBlock(this)" onblur="timeValidation(this)">&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type=text size='5' maxlength='5' name='blk_time_to' id='blk_time_to' onKeyUp="javascript:formatTimeForBlock(this)" onblur="timeValidation(this)">
		</tr>
		<tr>
				<td  class='label' width="15%"><fmt:message key="Common.day.label" bundle="${common_labels}"/></td>
				<td class='label' align='left'><fmt:message key="Common.Monday.label" bundle="${common_labels}"/><input type =checkbox name='mon' id='mon' value ='N' onClick='checkDay(this);' disabled><fmt:message key="Common.Tuesday.label" bundle="${common_labels}"/><input type =checkbox name='tue' id='tue' value ='N' onClick='checkDay(this);' disabled><fmt:message key="Common.Wednesday.label" bundle="${common_labels}"/><input type =checkbox name='wed' id='wed' value ='N' onClick='checkDay(this);' disabled><fmt:message key="Common.Thursday.label" bundle="${common_labels}"/><input type =checkbox name='thu' id='thu' value ='N' onClick='checkDay(this);' disabled><fmt:message key="Common.Friday.label" bundle="${common_labels}"/><input type =checkbox name='fri' id='fri' value ='N' onClick='checkDay(this);' disabled><fmt:message key="Common.Saturday.label" bundle="${common_labels}"/><input type =checkbox name='sat' id='sat' value ='N' onClick='checkDay(this);' disabled><fmt:message key="Common.Sunday.label" bundle="${common_labels}"/><input type =checkbox name='sun' id='sun' value ='N' onClick='checkDay(this);' disabled></td>
				
				<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
				<td class=label id='remarks_labl' style='display:none'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
				<td class="fields" id='remarks_fld' style='display:none'><textarea rows=2 cols=45 name="other_remarks" onkeyPress='checkMaxLimit(this,100)' onBlur="SPCheckMaxLen('Remarks',this,100)"></textarea><img src='../../eCommon/images/mandatory.gif' id='remarks_img' style='visibility:hidden'></td>
				<!--End ML-MMOH-CRF-1114-->

		</tr>

		<tr>
			<td class='label' colspan=4>&nbsp;</td>
		</tr>

		<tr>
			<input type='hidden' name='sch_value' id='sch_value' value=''>
				<td></td>
				<td></td>					
				<td class='label'>&nbsp;</td>
				<td class='button' align="right"><input type='button'  name='reportbut' id='reportbut' value='<fmt:message key="Common.Generate.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.report.label" bundle="${common_labels}"/>' class='button' onClick='gen_report();' disabled>&nbsp;<input type='button' name='Select' id='Select' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' class='button' onClick='blank_chk(this.name);'></td>
		</tr>
	</table>
		</div>
	
			<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
			<input type='hidden' name='no_days' id='no_days' value='' >
			<%
				if(pstmt!=null){
					pstmt.close();
				}
				if(rset !=null){
					rset.close();
				}
			pstmt = con.prepareStatement( "select substr(day_of_week,1,3) week_day,day_no from sm_day_of_week order by day_no" ) ;
			rset=pstmt.executeQuery();

			while(rset!=null && rset.next()){

				switch(rset.getInt("day_no")){

					case 1:		day_1 = rset.getString("week_day");
							break;
					case 2:		day_2 = rset.getString("week_day");
							break;
					case 3:		day_3 = rset.getString("week_day");
							break;
					case 4:		day_4 = rset.getString("week_day");
							break;
					case 5:		day_5 = rset.getString("week_day");
							break;
					case 6:		day_6 = rset.getString("week_day");
							break;
					case 7:		day_7 = rset.getString("week_day");
							break;
				}
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(rset !=null){
				rset.close();
			}

		%>
	<%
				
			

				if(pstmt!=null){
					pstmt.close();
				}
				if(rset !=null){
					rset.close();
				}

			}
				catch(Exception e){
				//out.print(e);
				e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
				}

				finally
				{
					  ConnectionManager.returnConnection(con,request);
		
	}%>

			<input type='hidden' name='only_header' id='only_header' value='' >
			<input type="hidden" name="P_Facility_id" id="P_Facility_id" value='<%=facilityId%>'></input>
			<input type='hidden' name='P_Clinic_Code' id='P_Clinic_Code' value='' >
			<input type='hidden' name='P_Practitioner_Id' id='P_Practitioner_Id' value='<%=practitioner%>' >
			<input type="hidden" name="p_module_id" id="p_module_id"   value="OA"></input>
			<input type="hidden" name="p_report_id" id="p_report_id"   value="OAAFAPLST"></input>
     		<input type='hidden' name='p_user_id' id='p_user_id' value='<%=p_user_name%>'></input>
     		<input type='hidden' name='P_From_Date' id='P_From_Date' value='<%=from_date%>'></input>
     		<input type='hidden' name='P_To_Date' id='P_To_Date' value='<%=to_date%>'></input>
     		<input type='hidden' name='P_Reason' id='P_Reason' value='<%=reason%>'></input>
     		<input type='hidden' name='P_Event_Date' id='P_Event_Date' value='<%=datval1%>'></input>
     		<input type='hidden' name='P_Day_No' id='P_Day_No' value='<%=from_day%>'></input>
     		<input type="hidden" name="P_Action" id="P_Action" value=''></input>
     		<input type='hidden' name='P_Report_Title' id='P_Report_Title' value=''></input>
			<input type='hidden' name='locale' id='locale' value='<%=locale%>'></input>   
			<input type='hidden' name='default_select' id='default_select' value='<%=default_select%>'></input>   
			<input type='hidden' name='wday_1' id='wday_1' value='<%=day_1%>' >
		<input type='hidden' name='wday_2' id='wday_2' value='<%=day_2%>' >
		<input type='hidden' name='wday_3' id='wday_3' value='<%=day_3%>' >
		<input type='hidden' name='wday_4' id='wday_4' value='<%=day_4%>' >
		<input type='hidden' name='wday_5' id='wday_5' value='<%=day_5%>' >
		<input type='hidden' name='wday_6' id='wday_6' value='<%=day_6%>' >
		<input type='hidden' name='wday_7' id='wday_7' value='<%=day_7%>' >

		<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->
		<input type='hidden' name='others_id' id='others_id' value='<%=others_id%>'>
     </form>
</body><script>document.forms[0].location_type.focus();
document.getElementById("imgpract").style.visibility='hidden'
			</script></script>
</html>

