<!DOCTYPE html>
 <%@ page import="java.sql.*,java.text.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/> 
<html> 
	<head>
		<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<%
		associateDiagBean.clearAll();
		String callfunc=(request.getParameter("call_func") == null)?"":request.getParameter("call_func");
		   
		if(callfunc.equals("Clinic"))
		{
		  
		%>
			<script language='javascript' src='../../eOP/js/ClinicForResource.js'></script>
		   <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		<%
		}
		else if(callfunc.equals("ProcedureUnit"))
		{
			
		%>
			<script language='javascript' src='../../eOP/js/ProcUnit.js'></script>
		<%
		}
		else if(callfunc.equals("DaycareUnit"))
		{
			
		%>
			<script language='javascript' src='../../eOP/js/DaycareUnit.js'></script>
		<%
		}
		%>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>		
			var prevTabObj="char_tab";
			function CheckForSpecChars(event){
				var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
				var whichCode = (window.Event) ? event.which : event.keyCode;
				key = String.fromCharCode(whichCode);  // Get key value from key code
				if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
				if( (event.keyCode >= 97) && (event.keyCode <= 122) )
					return (event.keyCode -= 32);
				return true ;
			}
		</script>
	</head>
	<body onLoad="setfocus();" OnMouseDown="CodeArrest();" onKeyDown='lockKey();'>
	<%
	String facilityid=(String)session.getValue("facility_id");     
	String clinic_code=request.getParameter("clinic_code");
	if(clinic_code == null || clinic_code.equals("null")) clinic_code="";

		
		PreparedStatement pstmt = null;		
		ResultSet rs = null;    
		Connection conn = null;
		String loctype="";
		String sql1="";
		String fnval="insert";
		String clinicCode="";
		String short_desc="";
		String long_desc="";
		String clinic_type="";
		String specialist_clinic_yn="N";
		String effStatus="E";
		String disable="";
		String readonly="";
		String chkval="";
		String modifyread="";
		String sel="";
		String locntypedesc="";

		String chkval1="";
		String visitdisable="";
		String visit_pract_val="N";
		String physical_locn="";
		String risOaIntegrate="N";
		String rd_appl_yn="N";
		String radApplChk="";
		String radApplDis="";
		Boolean isAlertApplicableforBookAppt=false; //Added by Mujafar  for GHL-CRF-0527
		Boolean isSplCharNotAllowApplYN=false; //Added by Suji Keerthi for MOHE-CRF-0113 US001
		String eventFunctionForCase=""; //Added by Suji Keerthi for PAS-OP-MOHE-CRF-0113/01-OP Code Setup-Clinic
		String popup_hide="none";
		String alert_req_book_appt_yn="";
		String chk_alert_req_book_appt_yn="";
		String popup_msg ="";
		//Added by Ajay for MMS-DM-CRF 0209.4
		String CATEGORY="";		
		String category_yn="";
		String category_mand="";
		String CatgMandVisible = "hidden";

		//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
		Boolean isSlotStartMidEndAppl = false;
		String clinic_type_sub="";
		String clinic_type_sub_desc="";
		String sel_op="";
		String sel_vc="";
		String sel_va="";

	try{
		conn=ConnectionManager.getConnection(request);
		isAlertApplicableforBookAppt = eCommon.Common.CommonBean.isSiteSpecific(conn, "OP", "ALRT_DISP_APPL_BOOK_APPT");//Added by Mujafar  for GHL-CRF-0527
		isSplCharNotAllowApplYN = eCommon.Common.CommonBean.isSiteSpecific(conn, "AM", "SPL_CHAR_NOT_ALLOWED");//Added by Suji Keerthi for MOHE-CRF-0113 US001

		isSlotStartMidEndAppl = eCommon.Common.CommonBean.isSiteSpecific(conn, "OA", "BRU_HEALTH_INTG");//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
		Boolean isClinicCategory = eCommon.Common.CommonBean.isSiteSpecific(conn, "OP", "CLINIC_CATEGORY");//Added by Ajay for MMS-DM-CRF-0209.4
		
		if(!(clinic_code.equals("")))
		{
			fnval="modify";
			modifyread="readOnly";
            String sql2="select a.clinic_code clinic_code,a.short_desc short_desc,a.long_desc long_desc,a.clinic_type clinic_type,a.specialist_clinic_yn SPECIALIST_CLINIC_YN,a.eff_status eff_status,b.short_desc locntypedesc,a.VISIT_SPECIALIST_CLINIC_YN VISIT_SPECIALIST_CLINIC_YN,a.PHYSICAL_LOCATION physical_location,rd_appl_yn,a.alert_req_book_appt_yn,a.POPUP_DESC_BOOK_APPT popup_msg, a.clinic_type_sub clinic_type_sub,a.CATEGORY from op_clinic a,am_care_locn_type b where a.clinic_code='"+clinic_code+"' and a.facility_id='"+facilityid+"' and a.clinic_type=b.locn_type"; // modified by Mujafar  for GHL-CRF-0527
			//Modified by Ajay for MMS-DM-CRF-0209.4
			pstmt=conn.prepareStatement(sql2);

			
			rs=pstmt.executeQuery();

			if(rs!= null)
			{
				if(rs.next())
				{
					clinicCode=rs.getString(1);
					short_desc=rs.getString(2);
					long_desc=rs.getString(3);
					clinic_type=rs.getString(4);
					specialist_clinic_yn=rs.getString(5);
					effStatus=rs.getString(6);
					locntypedesc=rs.getString(7);
					visit_pract_val=rs.getString(8);
					physical_locn = rs.getString("physical_location")==null?"":rs.getString("physical_location");
					rd_appl_yn = rs.getString("rd_appl_yn")==null?"N":rs.getString("rd_appl_yn");
					alert_req_book_appt_yn = rs.getString("alert_req_book_appt_yn")==null?"N":rs.getString("alert_req_book_appt_yn"); //Added by Mujafar  for GHL-CRF-0527
					popup_msg = rs.getString("popup_msg")==null?"":rs.getString("popup_msg");
					clinic_type_sub = rs.getString("clinic_type_sub")==null?"":rs.getString("clinic_type_sub");//Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6
					CATEGORY = rs.getString("CATEGORY")==null?"":rs.getString("CATEGORY"); //Added by Ajay for MMS-DM-CRF-0209.4
				}
			 } 

			 if(rs !=null) rs.close();
			 if(pstmt != null) pstmt.close();

			  if(visit_pract_val == null) visit_pract_val="N";
			  if(rd_appl_yn.equals("Y")){
				  radApplChk = "checked";
				  radApplDis = "disabled";
			  }else{
				  radApplChk = "";
				  radApplDis = "";
			  }

             if(effStatus.equals("D"))
					 {
						disable="disabled";
						readonly="readonly";
					 }
					else
					 {
						disable="";
						readonly="";
					 }
		}else
		{
			modifyread="";
		}
		//Added by Mujafar  for GHL-CRF-0527
		if(alert_req_book_appt_yn.equals("Y")) 
		   {
			chk_alert_req_book_appt_yn="checked";
			popup_hide="visible";
		   }
		else
			{
			chk_alert_req_book_appt_yn="";
			}

	 if(callfunc.equals("ProcedureUnit")){
			String risOaSql="select 'Y' ris_oa_integrate from sm_function_control where functionality_id = 'RD_OA_INTEGRATE'";
			pstmt=conn.prepareStatement(risOaSql);			
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next()){		 
				risOaIntegrate=rs.getString("ris_oa_integrate")==null?"N":rs.getString("ris_oa_integrate");				
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
	 }
     //Below Added by Suji Keerthi for PAS-OP-MOHE-CRF-0113/01-OP Code Setup-Clinic
	 if(isSplCharNotAllowApplYN)
			{
			eventFunctionForCase="OnBlur='ChangeUpperCase(this);CheckSplCharsforIdValidation(this)'";		
			}
 
		
	%>
	<form name="clinic_main_resource_form" id="clinic_main_resource_form">
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center' valign='top' >
	 <tr>
	   <td width="100%" class="Border">
	     <table  border='0' cellpadding='0' cellspacing='0' width='100%' >
	      <tr>
		   <td class='label' width='21%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		   <td class='fields' width='32%'>
		    <input type='text' name='clinic_code' id='clinic_code' value="<%=clinicCode%>" size='4' maxlength='4' <%if(isSplCharNotAllowApplYN){%> onKeyPress="return CheckForSpecCharsValidation2(event);changeUppercase(this);" <%=eventFunctionForCase%> <%}else{%> onKeyPress="return CheckForSpecChars(event);changeUppercase(this);" <%}%> <%=modifyread%>> <!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->
		    <img src='../../eCommon/images/mandatory.gif' align='center'></img>
	       </td>
		<td  class='label' width='23%'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
		 <td class='fields' width='25%' nowrap>
				<%
				if(fnval.equals("modify") && effStatus.equals("D"))
						{
							%>
					<input type='text' name="clinic_type_desc" id="clinic_type_desc" value="<%=locntypedesc%>" readonly><img src='../../eCommon/images/mandatory.gif' align='center'></img>
					<input type='hidden' name="clinic_type" id="clinic_type" value="<%=clinic_type%>">
					<%
						}
						else
						{
						%>
			     <select name='clinic_type' id='clinic_type'><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
			           <%
						try{
							if(callfunc.equals("Clinic"))
									{
										sql1="select locn_type,short_desc from am_care_locn_type where (care_locn_type_ind='C') and locn_type ='C' and SYS_USER_DEF_IND='S' order by short_desc";
									}
									else if(callfunc.equals("ProcedureUnit"))
									{
										//sql1="select locn_type,short_desc from am_care_locn_type WHERE care_locn_type_ind in ('O','E') and locn_type in ('O','E') and SYS_USER_DEF_IND='S' order by short_desc";

										sql1="select locn_type,short_desc from am_care_locn_type WHERE (care_locn_type_ind  ='E') and locn_type ='E' and SYS_USER_DEF_IND='S' order by short_desc";

									}
									else if(callfunc.equals("DaycareUnit"))
									{
										sql1="select locn_type,short_desc from am_care_locn_type where (care_locn_type_ind='D') and locn_type ='Y' and SYS_USER_DEF_IND='S' order by short_desc";

									}
								
								pstmt=conn.prepareStatement(sql1);
								rs=pstmt.executeQuery();
								if(rs != null)
								{
									while(rs.next())
									{
										loctype=(rs.getString("locn_type") == null)?"":rs.getString("locn_type");

										
										if(loctype.equals(clinic_type))
										{
											sel="selected";
										}
										else
											sel="";
										%>
											<option value='<%=loctype%>' <%=sel%> ><%=(rs.getString("short_desc") == null)?"":rs.getString("short_desc")%>
											<%
									}
								}
								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								
							}catch(Exception e)
							{
								e.printStackTrace();
							}
										%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
			<%}%>
		
		<!--Added by Ashwini on 01-Dec-2021 for ML-BRU-CRF-0628.6-->
		<%if(isSlotStartMidEndAppl){

			if(fnval.equals("modify") && effStatus.equals("D"))
			{
		%>
			<input type='text' name="clinic_type_sub_desc" id="clinic_type_sub_desc" value="<%=clinic_type_sub_desc%>" readonly>
			<input type='hidden' name="clinic_type_sub" id="clinic_type_sub" value="<%=clinic_type_sub%>">
		<%
			}else{
		%>
			<select name='clinic_type_sub' id='clinic_type_sub'> <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
				<%
					 pstmt = conn.prepareStatement("select clinic_proc_catg_code, long_desc from op_clinic_proc_category where eff_status = 'E' order by clinic_proc_catg_code");
					 rs = pstmt.executeQuery();
					 while(rs.next()){
						 %>
				<option  value='<%=rs.getString("clinic_proc_catg_code")%>' <%if(clinic_type_sub.equals(rs.getString("clinic_proc_catg_code"))){out.println("selected");}%>> <%=rs.getString("long_desc")%> &nbsp</option>		 
						 <%
					 }
					 %>
			</select>&nbsp;
		<%
			}
		}
		%>
		<input type='hidden' name="isSlotStartMidEndAppl" id="isSlotStartMidEndAppl" value="<%=isSlotStartMidEndAppl%>">
		<!--End ML-BRU-CRF-0628.6-->

	 </td>

	 </tr>
	 <input type='hidden' name='isAlertApplicableforBookAppt' id='isAlertApplicableforBookAppt' value='<%=isAlertApplicableforBookAppt%>'> <!--Added by Mujafar  for GHL-CRF-0527 -->
			<tr>
			<td class='label' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type='text'  name='long_desc' id='long_desc' size='30' maxlength='30' value="<%=long_desc%>" <%if(isSplCharNotAllowApplYN){%> onBlur='CheckSplCharsValidation(this); makeValidString(this);' onKeyPress="return CheckForSpecCharsValidation1(event);" <%}else{%> onBlur = 'makeValidString(this)' <%}%> <%=readonly%>><img src='../../eCommon/images/mandatory.gif' align='center'></img> <!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->
				</td>
			<td class='label'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
				<td class='fields'>
			    	<input type='text'   name='short_desc' id='short_desc' size='15' maxlength='15' value="<%=short_desc%>" <%if(isSplCharNotAllowApplYN){%> onBlur='CheckSplCharsValidation(this); makeValidString(this);' onKeyPress="return CheckForSpecCharsValidation1(event);" <%}else{%> onBlur = 'makeValidString(this)' <%}%> <%=readonly%>><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td> <!--Modified by Suji Keerthi for MOHE-CRF-0113 US001-->
			</tr>
		<tr>
			<td class='label'>
				<fmt:message key="Common.PhysicalLocation.label" bundle="${common_labels}"/>
			</td>
			<td class='fields'>
				<input type='text' name='physical_locn' id='physical_locn' size='40' maxlength='40' value="<%=physical_locn%>"  onBlur = 'makeValidString(this)' <%=readonly%>>
			</td>
			<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td class='fields'>
						<%
						  if(effStatus.equals("E"))
							{
							chkval="checked";
							}
							else if(effStatus.equals("D"))
							{
							chkval="";
							}
							else
							{
							chkval="checked";
							}
						%>
				<input type='checkbox' name='eff_status' id='eff_status' value='<%=effStatus%>' <%=chkval%>  onClick='assignvalspec(this)'>
			</td>				
			</tr>
			<%
				 if(callfunc.equals("Clinic"))
			{%>
			<tr>
			<td class='label'><fmt:message key="Common.SpecialistClinic.label" bundle="${common_labels}"/></td>
			<td class='fields'>
							
							<%
									 if(specialist_clinic_yn.equals("Y"))
											chkval="checked";
										else
											chkval="";
									%>

			<input type='checkbox' name='specialist_clinic' id='specialist_clinic' onClick='assignvalspec(this);'   value='<%=specialist_clinic_yn%>' <%=disable%> <%=chkval%>>
		    <input type='hidden' name='specialist_clinic_yn' id='specialist_clinic_yn' value='<%=specialist_clinic_yn%>'>  
			</td>
			<%
					if(visit_pract_val.equals("Y"))
						chkval1="checked";
					else
						chkval1="";
					 if( specialist_clinic_yn.equals("N") || effStatus.equals("D"))
						visitdisable="disabled";
					 else
						visitdisable="";
				%>						
			<td class='label'>
				<fmt:message key="eOP.VisitingPractitioner.label" bundle="${op_labels}"/>
			</td>
			<td class='fields'>
				<input type='checkbox' name='visit_pract' id='visit_pract' onClick='assignVisitval(this);'   value='<%=visit_pract_val%>' <%=chkval1%> <%=visitdisable%>>
				<input type=hidden name='visit_pract_yn' id='visit_pract_yn' value="<%=visit_pract_val%>" >
			</td>
			</tr>
			<%if(isAlertApplicableforBookAppt)
			{ //Added by Mujafar  for GHL-CRF-0527
			%>	
			<tr>
			<td></td><td></td>
			<td class='label'>
				<fmt:message key="Common.Alert.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Message.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.required.label" bundle="${common_labels}"/>
			</td>
			<td><input type='checkbox' name='alert_req_book_appt_yn' id='alert_req_book_appt_yn'  value="<%=alert_req_book_appt_yn%>"  <%=chk_alert_req_book_appt_yn%> onclick="PopupHide(this);" ></td>
			</tr>
			<tr id='popup_hide' style='display:<%=popup_hide%>' >
			<td></td><td></td>
			<td class='label'>
				<fmt:message key="Common.Alert.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.popup.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>
			</td>
			
			<td  class='fields' colspan='2'>&nbsp;<input type='text' name='popup_desc' id='popup_desc' size='50' maxlength='255' onBlur = 'makeValidString(this)'    value="<%=popup_msg%>"    ><img src='../../eCommon/images/mandatory.gif' ></img>
		</td>
			</tr>
			<%
			}
			}
			if(callfunc.equals("ProcedureUnit") && risOaIntegrate.equals("Y")){%>
			<td class='label'><fmt:message key="Common.ApplicableToRadiology.label" bundle="${common_labels}"/></td>
			<td class='fields'>
				<input type='checkbox' name='rd_appl_yn' id='rd_appl_yn' onClick='assignValue(this);' value='<%=rd_appl_yn%>' <%=radApplChk%> <%=radApplDis%> onClick="assignValue(this)">				
			</td>
			<%if(isAlertApplicableforBookAppt)
			{ //Added by Mujafar  for GHL-CRF-0527
			%>	
			<tr>
			<td></td><td></td>
			<td class='label'>
				<fmt:message key="Common.Alert.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.Message.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.required.label" bundle="${common_labels}"/>
			</td>
			<td><input type='checkbox' name='alert_req_book_appt_yn' id='alert_req_book_appt_yn'  value="<%=alert_req_book_appt_yn%>"  <%=chk_alert_req_book_appt_yn%> onclick="PopupHide(this);" ></td>
			</tr>
			<tr id='popup_hide' style='display:<%=popup_hide%>' >
			<td></td><td></td>
			<td class='label'>
				<fmt:message key="Common.Alert.label" bundle="${common_labels}"/>&nbsp<fmt:message key="Common.popup.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>
			</td>
			<td  class='fields' colspan='2'>&nbsp;<input type='text' name='popup_desc' id='popup_desc' size='50' maxlength='255'  onBlur = 'makeValidString(this)'  value="<%=popup_msg%>"   ><img src='../../eCommon/images/mandatory.gif' ></img>
		</td>
			</tr>
			<%
			}
			}else{ %>
				<input type=hidden name='rd_appl_yn' id='rd_appl_yn' value="<%=rd_appl_yn%>" >
		<%	}
			%>
	
</tr>
<!-- Added by Ajay for MMS-DM-CRF-0209.4 -->
<% 
if(isClinicCategory){
try
   {
    pstmt=conn.prepareStatement("select CLINIC_CATAGORY_YN,CLINIC_CATAGORY_MAND_YN  from op_param where OPERATING_FACILITY_ID ='"+facilityid+"'");
    
     rs=pstmt.executeQuery();
     if(rs!=null)
      {
        if(rs.next())
         {
           category_yn=rs.getString("CLINIC_CATAGORY_YN");
           category_mand=rs.getString("CLINIC_CATAGORY_MAND_YN");
		   if(category_mand.equals("Y")){
			   CatgMandVisible = "visible";
		   }
         }
	  }
         if(rs !=null) rs.close();
	if(pstmt != null) pstmt.close();
  }catch(Exception e)
   {
   e.printStackTrace();
 }%>


<% if(category_yn.equals("Y"))
		{
			if(callfunc.equals("Clinic") || callfunc.equals("ProcedureUnit"))
			{			
			%>
			<tr>
				<td  class='label' width='23%'><fmt:message key="Common.CCategory.label" bundle="${common_labels}"/></td>
		        <td class='fields' width='25%' nowrap>   
				 <select name='CATEGORY' id='CATEGORY' ><option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;
					 <%
					 pstmt = conn.prepareStatement("select clinic_proc_catg_code, long_desc from op_clinic_proc_category where eff_status = 'E' order by srl_no");
					 rs = pstmt.executeQuery();
					 while(rs.next()){
						 %>
				<option  value='<%=rs.getString("clinic_proc_catg_code")%>' <%if(CATEGORY.equals(rs.getString("clinic_proc_catg_code"))){out.println("selected");}%>> <%=rs.getString("long_desc")%> &nbsp</option>		 
						 <%
					 }
					 %>
				</select>
				<img src='../../eCommon/images/mandatory.gif' style="visibility:<%=CatgMandVisible%>" align='center'></img>
				</td></tr>
        <%}
		}
}
		%>
		<!-- End of MMS-DM-CRF-0209.4 -->
	 <%
		 if(!callfunc.equals("Clinic"))
		{%>
	<tr>
	<td colspan=4>&nbsp;</td>
 	</tr>  
		<%}%>
		<!-- <tr>						
				<td align='left' class='label' width='15%'><a name="clinic_char" href="javascript:tab_click('char_tab');" alt="clinic_char" ><img src='../../eOP/images/Characteristics.gif' name="char_tab" border='0' alt='clinic_char' style='{ border-style: ridge;}'></img></a>				
				<a name="clinic_others" href="javascript:tab_click('others_tab');" ><img src='../../eOP/images/Others_click.gif' name="others_tab" border='0' alt='clinic_others' style='{ border-style: ridge;}'></img></a>
				</td>
		</tr>	 -->							
</table>
</td>		
 </table>
 
 

<!-- <a alt='Characteristics'></a> -->
<div id="general_div">
	<ul id="tablist" class="tablist" style="padding-left:0px">

		<li class="tablistitem" title="Characteristics">
			<a onclick="javascript:tab_click('char_tab')" id="char_tab" class="tabClicked">
			<span class="tabSpanclicked" id="char_tabspan"><fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Others">
			<a onclick="javascript:tab_click('others_tab')" id="others_tab" class="tabA">
			<span class="tabAspan" id="others_tabspan"><fmt:message key="Common.others.label" bundle="${common_labels}"/></span>
			</a>
		</li>
		<li class="tablistitem" title="Patient Instructions">
			<a onclick="javascript:tab_click('patinstructions_tab')" id="patinstructions_tab" class="tabA"  >
			<span class="tabAspan" id="patinstructions_tabspan"><fmt:message key="eAM.PatInstructions.label" bundle="${am_labels}"/></span>
			</a>
		</li>	
	</ul>	
	</div>

<input name="categoryYN" id="categoryYN" value="<%=category_yn%>" style="visibility:hidden">
<input name="categoryMand" id="categoryMand" value="<%=category_mand%>" style="visibility:hidden">
<input name="isClinicCategory" id="isClinicCategory" value="<%=isClinicCategory%>" style="visibility:hidden">
  <!--    <a name="clinic_char" href="javascript:tab_click('char_tab');" alt="clinic_char" ><img src='../../eOP/images/Characteristics.gif' name="char_tab" border='0' alt='clinic_char' style='{ border-style: ridge;}'></img></a>				
 	  <a name="clinic_others" href="javascript:tab_click('others_tab');" ><img src='../../eOP/images/Others_click.gif' name="others_tab" border='0' alt='clinic_others' style='{ border-style: ridge;}'></img></a> -->
 </form>
 
	<%}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(conn != null)
			ConnectionManager.returnConnection(conn,request);
	}
	%>
	
</body>
 </html>

