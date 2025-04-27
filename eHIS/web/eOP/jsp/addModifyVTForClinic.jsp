<!DOCTYPE html>
<!-- Program for visit types for a particular Clinic -->

<html>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eOP/js/VTForClinic.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
  	var careArray=new Array();
	var i=1;
</script>

<%
	Connection con = null;
	try
	{
        //String v_function_id = "";
        String procid=request.getParameter("procID");
	    if(procid==null)procid="";
		con = ConnectionManager.getConnection(request);  
		Boolean isAERegisterTypeAutoUpdateAppl =	CommonBean.isSiteSpecific(con, "AE", "AE_REG_TYPE_AUTO_UPDATE"); // added by mujafar for KDAH-CRF-0526
		ResultSet rset=null ;	
		//ResultSet rs=null ;
		PreparedStatement pstmt=null;

		String otherTextAttribute="";
		String dat="";
		String status="";
		String clinic="";
		String clinicname="";
		String visit="";
		String visitname="";
		String sservice="";
		String fnval="insert";
		String id="";
		String chk="checked";
		String fid=(String)session.getValue("facility_id") ;
		String vitalsignsbatteryid="" ;
		String vital_sign_short_desc="" ;
		String sql="";

		clinic=request.getParameter("clinic");	
		visit=request.getParameter("visit");	
	//	String bl_install_yn = (String)session.getValue("bl_operational"); 
		String or_install_yn="N";
		String max_appt_duration = "";
		String max_appt_slots = "";
		String visit_eff_status = "";
		String eff_status_disabled = "";	
	    String allow_visit_reg="";
		String locationtype="";
		String locationval="";
		String careind="";
		try 
		{
			pstmt=con.prepareStatement("select install_yn from sm_module where module_id='OR'");
			rset=pstmt.executeQuery();
			while(rset.next())
			{		 
				or_install_yn = rset.getString(1) == null ? "N" : rset.getString(1);
			}

			if(pstmt != null) pstmt.close();
			if(rset != null) rset.close();
		}catch(Exception e) {
			e.printStackTrace();
			} 
	try
	{
      if(clinic!=null )
		{
		clinic=clinic.trim();
		visit=visit.trim();
		fnval="modify";		
		try
		{
        if(procid.equals("visit_type_for_proc_unit"))
		{
			 sql="select a.clinic_code,b.long_desc CLINIC_SHORT_DESC,a.VISIT_TYPE_CODE,a.VISIT_TYPE_SHORT_DESC,a.vst_for_clin_max_appt_duration,a.max_appt_slots,a.visit_type_eff_status,a.eff_status,a.vital_signs_battery_id,a.VITAL_SIGN_SHORT_DESC,b.ALLOW_VISIT_REGN_YN,b.clinic_type from  op_visit_type_for_clinic_vw a,op_clinic b where a.facility_id=? and a.facility_id = b.facility_id and a.clinic_code=? and a.visit_type_code=?  and b.clinic_code=? ";
			}else{
		sql="select a.clinic_code,b.long_desc CLINIC_SHORT_DESC,a.VISIT_TYPE_CODE,a.VISIT_TYPE_SHORT_DESC,a.vst_for_clin_max_appt_duration,a.max_appt_slots,a.visit_type_eff_status,a.eff_status,a.vital_signs_battery_id,a.VITAL_SIGN_SHORT_DESC,b.ALLOW_VISIT_REGN_YN,b.clinic_type from  op_visit_type_for_clinic_vw a,op_clinic b where a.facility_id=? and a.facility_id = b.facility_id and a.clinic_code=? and a.visit_type_code=? and a.care_locn_type_ind='C' and b.clinic_code=?";
		
			}
 
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,fid);
		pstmt.setString(2,clinic);
		pstmt.setString(3,visit);
		pstmt.setString(4,clinic);
		rset=pstmt.executeQuery();	
  
		if(rset.next())
		{
		clinic=rset.getString("clinic_code");
		clinicname=rset.getString("CLINIC_SHORT_DESC");
		visit=rset.getString("VISIT_TYPE_CODE");
		visitname=rset.getString("VISIT_TYPE_SHORT_DESC");
		max_appt_duration=rset.getString("vst_for_clin_max_appt_duration");
		max_appt_slots=rset.getString("max_appt_slots");
		visit_eff_status=rset.getString("visit_type_eff_status");
		allow_visit_reg=rset.getString("ALLOW_VISIT_REGN_YN");
		locationtype=rset.getString("clinic_type");
		if (visit_eff_status==null) visit_eff_status="";
        if (visit_eff_status.equals("D"))  eff_status_disabled="Disabled";
		
		if(max_appt_slots==null)			max_appt_slots="";
		if(max_appt_duration==null)			max_appt_duration="";
		
		status=rset.getString("eff_status");
		if(status.equals("D"))
			{
			chk="";
			otherTextAttribute ="readonly";
			}

		vitalsignsbatteryid=rset.getString("vital_signs_battery_id");
		vital_sign_short_desc=rset.getString("VITAL_SIGN_SHORT_DESC");
		if (vital_sign_short_desc==null) vital_sign_short_desc="";
        
		}
		if(pstmt != null) pstmt.close();
		if(rset != null) rset.close();
		
		}catch(Exception e){
			e.printStackTrace();
			}
    
	    if(locationtype.equals("C"))
			locationval=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
		else if(locationtype.equals("E"))
			locationval=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
		else
			locationval=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
	}
%>

</head>
<br><br><br><br><br><br><br><br>
<body  onLoad="FocusFirstElement()" OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<form name='facility_form' id='facility_form' action='../../servlet/eOP.VTForClinicServlet' method='post' target='messageFrame'>
 <BR><BR><BR>		
 	<div align='center'>
       <input type='hidden' name='or_install_yn' id='or_install_yn' value='<%=or_install_yn%>'>
		<table border='0' cellpadding='2' cellspacing='0' width='80%'>
 		 <tr><td colspan=4>&nbsp;</td></tr>
		 <tr>
				<%if(procid.equals("")){%>
			    <td width='30%' class='label'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></td>
				<td width='25%' class='fields' colspan='2'>
				<%if(fnval.equals("modify"))
				 {
				%>
					<input type='text' name='clinic_name' id='clinic_name' value="<%=clinicname%>" readonly> <img align='center' src='../../eCommon/images/mandatory.gif'></img><input type='hidden'  name='clinic' id='clinic'  value="<%=clinic%>">    				    
				 <%
				 }
				 else
				{%>
					 <select name='clinic' id='clinic' onchange='fetchVals(this.form,this)'>
					 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
				   <%						    
					try{ 
						/*
						  This query fetches the Clinics  based on the facility ID and 
						  Effective Status.
						*/
						pstmt=con.prepareStatement("select clinic_code,long_desc from op_clinic where facility_id=? and eff_status='E' and care_locn_type_ind='C' order by long_desc");
							pstmt.setString(1,fid);
							rset=pstmt.executeQuery() ;
							if(rset!=null)
							{
								while(rset.next())
								{
									dat=rset.getString("long_desc");
									id=rset.getString("clinic_code");
									%>
										<option value='<%=id%>' ><%=dat%>
									<%
								}
							}

							if(pstmt != null) pstmt.close();
							if(rset != null) rset.close();
						}catch(Exception e){
							e.printStackTrace();
							}
				%>
						</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
				<%}
			    }else{%>

                 <td width='30%' class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/> </td>
				 <td width='25%' class='fields'>
				 <%if(fnval.equals("modify"))
				 {
				%>
				<input type='text' name='location' id='location' value="<%=locationval%>" readonly>
				<%}else{%>
				 <select name='location' id='location' onchange='clearList();'>
				 <option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------&nbsp;</option>
				 <%						    
				try{ 
				pstmt=con.prepareStatement("select short_desc,locn_type,care_locn_type_ind from am_care_locn_type where care_locn_type_ind in ('C','E','D') and locn_type in ('C','E','Y') and  SYS_USER_DEF_IND='S' order by short_desc");
					rset=pstmt.executeQuery() ;
					if(rset!=null)
							{
								while(rset.next())
								{
									dat=rset.getString("short_desc");
									id=rset.getString("locn_type");
									careind=rset.getString("care_locn_type_ind");
									%>
										<option value="<%=id%>" ><%=dat%>
									<script>
										careArray[i]="<%=careind%>";
									      i++;
									</script>
									<%
								}
							}

							if(pstmt != null) pstmt.close();
							if(rset != null) rset.close();
						}catch(Exception e){
							e.printStackTrace();
							}
				%>
			 </select>
               </td>
			    <%}%>
				<td width='45%' class='fields'>
				 
				 <%if(fnval.equals("modify"))
				 {
				%>
					<input type='text' name='clinic_name' id='clinic_name' value="<%=clinicname%>" readonly> <img align='center' src='../../eCommon/images/mandatory.gif'></img>			
					<input type='hidden'  name='clinic' id='clinic'  value="<%=clinic%>">    				     
				 <%
				 }					  
				 else
				{%>
					 <input ="text" name="clinic1" id="clinic1"  onBlur="onBlurgetLoc('<%=fid%>',document.getElementById('location').value,document.getElementById('clinic1'));fetchVals(this.form,this);"><input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=fid%>',document.getElementById('location').value,document.getElementById('clinic1'));fetchVals(this.form,document.getElementById('clinic1'));" ><img align='center' src='../../eCommon/images/mandatory.gif'></img>
					<input type="hidden" name="clinic" id="clinic">
					 
					 <!-- <select name='clinic' id='clinic' onchange='fetchVals(this.form,this)'>
					 <option value=''>&nbsp;-------- <fmt:message 
					 key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
				    	</select><img align='center' src='../../eCommon/images/mandatory.gif'></img> -->
								
					<%}
				}
			    %>
				</td>
			</tr>
				<%
				
			if(fnval.equals("insert"))
			{ %>
			<tr>
				<td class='label'><fmt:message key="eOP.ApplicableVisitTypeIndicators.label" bundle="${op_labels}"/></td>
				<td class='fields' colspan='2'><select name='indicator' id='indicator' onchange='fetchVals(this.form,this)'>
					<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
					</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
				</td>
			</tr>
			<%}
			if(fnval.equals("modify")){%>
			<%}%>	
			<tr>
				 <td class='label'><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
				 <td class='fields' colspan='2'>
				 <%if(fnval.equals("modify"))
				{
				%>
				<input type='text' name='visit_type_desc' id='visit_type_desc' value="<%=visitname%>" readonly><img align='center' src='../../eCommon/images/mandatory.gif'></img>
				<input type='hidden' name='visittype' id='visittype' value="<%=visit%>" >
				<%	
				}
				 else
				{%>
					<select name='visittype' id='visittype' onChange = 'return getdfltvalue(this)'>
					<option value=''>&nbsp;-------- <fmt:message 
					 key="Common.defaultSelect.label" bundle="${common_labels}"/> --------&nbsp;</option>
					</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
				<%}%>
				</td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="Common.VitalSignsBattery.label" bundle="${common_labels}"/></td>
				<td class='fields' colspan='2'>
				<%
            
            if(!chk.equals("checked"))
				{
				%>
					<input type='text' name='t' id='t' value="<%=vital_sign_short_desc%>"  readonly>
					<input type='hidden' name='vitalsignsb' id='vitalsignsb' value='<%=vitalsignsbatteryid%>'>
				<%}
				else
				{	
					try
					{
					if(procid.equals("visit_type_for_proc_unit"))
						{
					if(fnval.equals("insert")){
 				   %>
                 <select name='vitalsignsb' id='vitalsignsb' onchange='fetchVals(this.form,this)'>
				<option value=''>&nbsp;-------- <fmt:message 
					   key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- &nbsp;</option>
			       <%}
						}
				  if(fnval.equals("modify")||procid.equals(""))
					   {
                     if(allow_visit_reg.equals("N")&&procid.equals("visit_type_for_proc_unit"))
						 { 
					  %>
                 <select name='vitalsignsb' id='vitalsignsb' disabled>
				<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- &nbsp;</option>
			   <%
					 }else{
					  %>
                 <select name='vitalsignsb' id='vitalsignsb'>
				<option value=''>&nbsp;-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -------- &nbsp;</option>
			   <%
				pstmt=con.prepareStatement("select short_desc,discr_msr_id from am_discr_msr where eff_Status ='E' and result_type ='V' order by 1 ");
				rset=pstmt.executeQuery() ;
				String sel="";
						while (rset.next())
						{
							dat=rset.getString("short_desc");
							id=rset.getString("discr_msr_id");
							if(id.equals(vitalsignsbatteryid))
								sel="selected";
						%>			
						<option value='<%=id%>'<%=sel%>><%=dat%></option>;				
						<% sel="";
						}
					 }
				 }
				  
				    if(pstmt != null) pstmt.close();
					if(rset != null) rset.close();
			
				}catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				%>
				</select>
			</td>
			</tr>  
			<%
			String textBoxReadOnlyStatus = "";
			/* this is used based on the clinicLevel of care if 
               it is 'E' it makes readOnly
			   */
			if(fnval.equals("modify"))
			{
				try
				{
					pstmt = con.prepareStatement("Select level_of_care_ind from op_clinic where clinic_code = ? and facility_id = ?");
					pstmt.setString(1, clinic);
					pstmt.setString(2, fid);	

					String clinicLevelOfCare = "E";	
					rset = pstmt.executeQuery();

					if( rset != null && rset.next() )
						clinicLevelOfCare = rset.getString("level_of_care_ind");
					if(clinicLevelOfCare.equals("E"))
						textBoxReadOnlyStatus = "readOnly";

					if(pstmt != null) pstmt.close();
					if(rset != null) rset.close();
				}catch(Exception e){
					e.printStackTrace();
					}
			}
		%>
     </table>
	 <table border='0' cellpadding='2' cellspacing='0' width='80%'>		
		   <tr>
				<td class='label' width='30%'><fmt:message key="eOP.MaxApptDuration.label" bundle="${op_labels}"/></td>
				<td class='fields' width='10%'>
					<input type='text' name='max_appt_duration' id='max_appt_duration' onKeyPress='return(ChkNumberInput(this,event,0))' size='4' maxlength='4' value="<%=max_appt_duration%>" <%=otherTextAttribute%> <%=textBoxReadOnlyStatus%> onblur='chkMaxApptDuration(this)' ></td>
				<td class='querydata'><fmt:message key="Common.MIN.label" bundle="${common_labels}"/></td>
			</tr>
	 </table>
 	 <table border='0' cellpadding='2' cellspacing='0' width='80%'>		
		  <tr>	
			<td width='30%' class='label'><fmt:message key="eOP.MaxApptSlots.label" bundle="${op_labels}"/></td>
				<td width='10%' class='fields'>
					<input type='text' name='max_appt_slots' id='max_appt_slots' onKeyPress='return(ChkNumberInput(this,event,0))' size='3' maxlength='3' value="<%=max_appt_slots%>" <%=otherTextAttribute%> onblur='chkMaxApptDuration(this);' <%=textBoxReadOnlyStatus%>></td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<td class='fields'>
				<input type='checkbox'  name='active' id='active'  value='E' <%=eff_status_disabled%> <%=chk%>>&nbsp</td>
				<td>&nbsp;</td>
			</tr>			
    	 <tr><td colspan='4'>&nbsp;</td></tr>
		</table>
	<%
	}catch(Exception e) { 
			//out.println("subtry="+e.toString());
			e.printStackTrace();
			}
	%>
	</div>
	<input type='hidden' name='radApplYn' id='radApplYn' value=''>
	<input type='hidden' name='function' id='function' value='<%=fnval%>'>
	<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
	<input type='hidden' name='visittype1' id='visittype1' value="">
	<input type='hidden' name='sservice_hidden' id='sservice_hidden' value="<%=sservice%>">
	<input type='hidden' name='pfunction' id='pfunction' value='<%=procid%>'>
	<input type='hidden' name='facilityId' id='facilityId' value='<%=fid%>'>
	<input type='hidden' name='isAERegisterTypeAutoUpdateAppl' id='isAERegisterTypeAutoUpdateAppl' value='<%=isAERegisterTypeAutoUpdateAppl%>'>
	
	</form>
</body>
</html>
 <%
}catch(Exception e){
		e.printStackTrace();
		}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

