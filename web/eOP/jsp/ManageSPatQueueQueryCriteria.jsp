<!DOCTYPE html>
<!--
    Developed by    :   R.Nanda Kumar
    Created on		:   22/12/2000
    Module			:   Out Patient Management
    Function		:   This file is used for displaying fields in the frame1 -
						division - 1 of the parent frame. 
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<%

Connection con      = null;

try{    
	    	request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
	    	response.addHeader("X-XSS-Protection", "1; mode=block");
	    	response.addHeader("X-Content-Type-Options", "nosniff");
		con=ConnectionManager.getConnection(request);
		Statement stmt      = con.createStatement();
		ResultSet rset      = null;				
		Boolean isVirtualCons = false;
		isVirtualCons = eCommon.Common.CommonBean.isSiteSpecific(con, "OP", "VIRTUAL_CONSULTATION"); //Added by Ajay Hatwate for ML-MMOH-CRF-1930
		
		String InstallYN = (String)session.getValue("bl_operational");
		if(InstallYN==null) InstallYN="";
		String fac_id       = (String) session.getValue( "facility_id" );
		String loginuser    = (String) session.getValue( "login_user" );
		StringBuffer sql =new StringBuffer();
		SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
		String cdate = dateFormat.format(new java.util.Date());
        String locale=(String)session.getAttribute("LOCALE");
		String cdate_display=DateUtils.convertDate(cdate,"DMY","en",locale);
		String oper_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");		
		String Vitalsign = request.getParameter("Vitalsign");
		String ChkOut = request.getParameter("ChkOut");
		String Que = request.getParameter("Que")==null?"":request.getParameter("Que");
		
		String function_id=request.getParameter("function_id")==null?"":request.getParameter("function_id");
		String action_on_pending_bill =request.getParameter("action_on_pending_bill")==null?"":request.getParameter("action_on_pending_bill");// Added For MMS-QH-CRF-0126 [IN:041880]

		
        String rfresh_param = request.getParameter("refresh");
		String loctype="";
		String loctypedesc="";
		String access_rule=request.getParameter("oper_stn_access_rule");
		if(access_rule == null || access_rule.equals("null"))  access_rule = "U";
		String sdate = request.getParameter("sdate") == null?"":request.getParameter("sdate");
		//int patient_id_length = 0;
		String patient_id_length = request.getParameter("pat_id_length") == null?"":request.getParameter("pat_id_length");

		String bl_package_enabled_yn = request.getParameter("bl_package_enabled_yn")==null?"N":request.getParameter("bl_package_enabled_yn");

		if(ChkOut == null || ChkOut.equals("null"))  ChkOut = "";
		if(Vitalsign == null || Vitalsign.equals("null"))  Vitalsign = "";
		/*
		rset=stmt.executeQuery("Select patient_id_length,to_char(sysdate,'hh24:mi') sdate from mp_param");
				if (rset != null)
				{
					rset.next();
					patient_id_length = rset.getInt(1);
					sdate=rset.getString("sdate");

				}
		if (rset != null)  rset.close(); 
		*/

%>

<html>
<head>
    <script src="../../eOP/js/ManageSPatQueue.js"></script>
    <script src="../../eOP/js/OPPractitionerComponent.js"></script>
   
   <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<!-- <script src='../../eCommon/js/dchk.js' language='javascript'></script> -->
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="document.forms[0].Qspeciality.focus(); " onMouseDown="CodeArrest();" onKeyDown ='lockKey()'>
<form name="manage_patient" id="manage_patient">
   
		<table cellpadding='1' cellspacing='0' width='100%' border='0'>
			<tr>
			<td  class='label'  ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			<td  class='Fields'>
				<select name='Qspeciality' id='Qspeciality' onChange="clearList()"><option value=''>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------  
				<%        	
					
		
		
		sql.append("SELECT a.speciality_code, a.short_desc  FROM am_speciality_lang_vw a  WHERE a.eff_status = 'E' and language_id = '"+locale+"'   AND a.speciality_code IN (SELECT b.speciality_code FROM op_clinic b, am_os_user_locn_access_vw c  WHERE b.facility_id = '"+fac_id+"' AND b.facility_id = c.facility_id  AND b.clinic_code = c.locn_code and b.CLINIC_TYPE=c.locn_type AND a.speciality_code = b.speciality_code	 and c.appl_user_id = '"+loginuser+"' and c.oper_stn_id = '"+oper_id+"') order by 2");        	
					rset=stmt.executeQuery(sql.toString());
					if(rset != null)
					{
						while(rset.next())
						{
							String speciality_code=rset.getString("speciality_code");
							String speciality_desc=rset.getString("short_desc");
							out.println("<option value='"+speciality_code+"'>"+speciality_desc);
						}
					}	
									  
					if (rset != null)       rset.close();
					sql.setLength(0);
					

				%>
				</select>
			</td>
			
			  <td   class='label'><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
		      <td  class='Fields' >
			  <%
			if (Que.equals("Que"))
			 {
			%><input type='radio'  name='multiple' id='multiple' SIZE='10' maxlength='10' value='M' onclick='callSingleQ()'><font class='label'><fmt:message key="Common.multiple.label" bundle="${common_labels}"/>
			  <input type='radio' name='multiple' id='multiple' SIZE='10' maxlength='10' value='S' checked><font class='label'><fmt:message key="Common.single.label" bundle="${common_labels}"/>
			<%
			 }
			 else
			 {
			%>
				<!-- commented by Afruddin for ML-MMOH-SCF-1466 on 11-Aug-2020
			<input type='radio' name='multiple' id='multiple' SIZE='10' disabled maxlength='10' value='M' ><font class='label' ><fmt:message key="Common.multiple.label" bundle="${common_labels}"/> -->
			  <input type='radio' name='multiple' id='multiple' SIZE='10' maxlength='10' value='S' checked ><font class='label' ><fmt:message key="Common.single.label" bundle="${common_labels}"/>
			<%
			 }
			%>
		</td> 
			
			</tr>
			
			<tr>
					
				<td   class='label' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>
				<td  class='Fields' nowrap>
					<select name="Qloctype" id="Qloctype" onChange="clearList()">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
							<%
								sql.append("select locn_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E') and SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc");

								rset=stmt.executeQuery(sql.toString());
								if(rset != null)
								{
									while(rset.next())
									{
										loctype=rset.getString("locn_type");
										loctypedesc=rset.getString("short_desc");
										%>
											<option value="<%=loctype%>" ><%=loctypedesc%>
										<%
									}
								}						  
							  if (rset != null)       rset.close();
							  sql.setLength(0);						

				%>
				
			</select>
			</td>
			<td class=label ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='Fields' >
			<INPUT TYPE="text" name="Qloc1" id="Qloc1"  onBlur="onBlurgetLoc('<%=loginuser%>','<%=oper_id%>','<%=fac_id%>',document.forms[0].Qloctype.value,document.forms[0].Qloc1)"><input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=loginuser%>','<%=oper_id%>','<%=fac_id%>',document.forms[0].Qloctype.value,document.forms[0].Qloc1)" >
			<input type="hidden" name="Qloc" id="Qloc">
			<!-- <select name="Qloc" id="Qloc" onChange="">
				<option value="" selected>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
			</select> -->
			</td>
			</tr>
			
			<tr>	
			   <td   class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
			<td  class='Fields' colspan=3 >
				<input type="text" name="pract_name" id="pract_name" maxlength="30" size="25" onBlur="callGetPractitioner(document.forms[0].pract_butt,pract_name)"><input type="button" name="pract_butt" id="pract_butt" value="?" class="button" onClick="callGetPractitioner(this,pract_name)" ><input type="hidden" name="Qpr" id="Qpr" value="">
			</td>
           </tr>
			<tr>
				<td   class='label' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td  class='Fields'><input type="text" name="Qpatientid" id="Qpatientid" size="<%=patient_id_length%>" maxlength="<%=patient_id_length%>" onBlur="ChangeUpperCase(this);">
		</td>
			   
	
			 <td  class='label' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
				<td  class='Fields'>
					<select name='Qgender' id='Qgender' onChange="">
						<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/>
					</select>
				</td>
			
						
				
			</tr>
   
   
		<tr>
		
		<td   class='label' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td  class='Fields'>
					<input type="text" name="Qencid" id="Qencid" size="12" maxlength="12" onKeyPress='return(ChkNumberInput(this,event,0))' onBlur="CheckNumberEntry(this);">
				</td>
				<td   class='label' nowrap><fmt:message key="Common.QueueNo.label" bundle="${common_labels}"/></td>
			<td class='Fields' >
			<input type="text" name="Qno" id="Qno" size="15" maxlength="15" onKeyPress='return(CheckSplCharsforIdValidation(this))' onpaste='CheckSplCharsforIdValidation(this)' onBlur='CheckSplCharsforIdValidation(this)'>
			</td>
				
		 </tr>
			
		 <tr>     
		 <td   class='label' ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
		<td  class='Fields' >
			<input type='text' name='Qdate' id='Qdate'    SIZE='10' maxlength='10' value='<%=cdate_display%>' readonly >
		 </td>
	 	<td   class='label' ><fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></td>
		 <td  align='left'><input type='text' name='Qstarttime' id='Qstarttime' size='5' maxlength='5'  value='' onBlur="validateTIme(this);"></td>
         </tr>
		 <tr>
		<td  align='left' class='label' nowrap ><fmt:message key="Common.display.label" bundle="${common_labels}"/></td>
		<td class='Fields'>
	        <SELECT name="display" id="display" onChange="checkvalues(this)"><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------- </option><option value='Qvisittype'><fmt:message key="eOP.ByVisitType.label" bundle="${op_labels}"/></option><option value='include_prev_visits'><fmt:message key="Common.PreviousDayVisitsOnly.label" bundle="${common_labels}"/></option>
				<%	if(!Vitalsign.equals("Vitalsign") || ChkOut.equals("ChkOut"))
					{%>
					<option value='Qcpat'><fmt:message key="eOP.IncludeCheckedoutPatients.label" bundle="${op_labels}"/></option></SELECT> 
					<%}%>
					<input type="hidden" name="Qvisittype" id="Qvisittype" value="N">
					<input type="hidden" name="include_prev_visits" id="include_prev_visits" value="N">
		 			<input type="hidden" name="Qcpat" id="Qcpat" value="N">
					</td>		
				     <td class='label'   nowrap><fmt:message key="eOP.apptstatus.label" bundle="${op_labels}"/></td>
				    <td  align='left' >
					<select name='Qapptstatus' id='Qapptstatus' onChange="">
						<option value=''>-<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
						<option value='E'><fmt:message key="eOP.ApptStatusEarly.label" bundle="${op_labels}"/>
						<option value='Y'><fmt:message key="eOP.ApptStatusYettoCome.label" bundle="${op_labels}"/>
						<option value='T'><fmt:message key="eOP.AppStatusOnTime.label" bundle="${op_labels}"/>
						<option value='L'><fmt:message key="eOP.ApptStatusLate.label" bundle="${op_labels}"/>
						<option value='N'><fmt:message key="Common.noshow.label" bundle="${common_labels}"/>
					 </select>
				     </td>
					 </tr>
				<!-- Added by Ajay Hatwate for ML-MOH-CRF-1930 -->
					 <% if(isVirtualCons && function_id.equals("MANAGE_PAT_QUEUE")){ %>
						 <tr>
						 <td  align='left' class='label' nowrap ><fmt:message key="Common.virtualConsultation.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Visit.label" bundle="${common_labels}"/> </td>
						 <td class='fields'><input type='checkbox' name='VirtualConsultVisit' id='VirtualConsultVisit' >
						 </tr>
					 <%}%>
					<!-- <tr>
               
		  
					<td  colspan=4 align='right' >
					<input type='button' class='Button' name="refresh" id="refresh" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="refresh_records()">&nbsp;<input type='button' class='Button' name="cleardata" id="cleardata" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="clearfields()"> 
				    </td>
					</tr> -->
				<input type="hidden" name="emergency_patients" id="emergency_patients" value="N">	
			    <INPUT TYPE="hidden" name='Qoperstat' id='Qoperstat' value='<%=oper_id%>'>	<input type='hidden' name='help_function_id' id='help_function_id' value='MANAGE_PAT_QUEUE'>
    	<input type='hidden' name='facility_id' id='facility_id' value='<%=fac_id%>'>
	     <input type='hidden' name='loginuser' id='loginuser' value='<%=loginuser%>'>
    	 <input type='hidden' name='Vitalsign' id='Vitalsign' value='<%=Vitalsign%>'>
	     <input type='hidden' name='ChkOut' id='ChkOut' value='<%=ChkOut%>'>
	     <input type='hidden' name='Que' id='Que' value='<%=Que%>'>
	     <input type='hidden' name='rfresh_param' id='rfresh_param' value='<%=rfresh_param%>'>
	    <input type='hidden' name='sdate' id='sdate' value='<%=sdate%>'>
	    <input type='hidden' name='access_rule' id='access_rule' value='<%=access_rule%>'>
	    <input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	    <input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
	    <input type='hidden' name='bl_install_yn' id='bl_install_yn' value='<%=InstallYN%>'><!-- added for package billing-->
	    <input type='hidden' name='bl_package_enabled_yn' id='bl_package_enabled_yn' value='<%=bl_package_enabled_yn%>'><!-- added for package billing-->
	    <input type='hidden' name='pat_id_length' id='pat_id_length' value='<%=patient_id_length%>'>
	    <input type='hidden' name='action_on_pending_bill' id='action_on_pending_bill' value='<%=action_on_pending_bill%>'><!-- added for MMS-QH-CRF-0126 [IN:041880]-->
	    <input type='hidden' name='isVirtualCons' id='isVirtualCons' value='<%=isVirtualCons%>'><!-- added for ML-MMOH-CRF-1930 -->
	     </table>
         </form>
        </body>
        </html>
      <%
    if(stmt != null) stmt.close();
    }catch(Exception e) {
		out.println(e.toString());
		e.printStackTrace();
	}
    finally{
     if(con!=null) ConnectionManager.returnConnection(con,request);
         }
        %>

