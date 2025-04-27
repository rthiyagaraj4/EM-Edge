<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
PreparedStatement pstmt	= null;
ResultSet rs		= null;
String EncounterId  = checkForNull(request.getParameter("EncounterId"));
String PatientId    = request.getParameter("PatientId");
String PractId1     = request.getParameter("PractId");
String call_from		=checkForNull(request.getParameter("call_from"));
String SickLeaveDetails	= request.getParameter("SickLeaveDetails");

%>
<html>
<head>
<title><fmt:message key="Common.certificate.label" bundle="${common_labels}"/></title>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eMR/js/SickLeave.js' language='javascript'></script>
<script src='../../eMR/js/MRPractitionerComponent.js' language='javascript'></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%if(!EncounterId.equals("")){%>
	<body onLoad='callSearch();FocusFirstElement();calculateNoOfDays();' onMouseDown="CodeArrest();" onKeyDown ='lockKey()'>
<% }else{ %>
	<body onLoad='callSearch();FocusFirstElement();' onMouseDown="CodeArrest();" onKeyDown ='lockKey()'>
<% } %>
<form name="SickLeaveForm" id="SickLeaveForm" action="../../servlet/eMR.SickLeaveServlet"  method="post" target="dummy">
<%
	
	String PractId      = "";
	String StartTime    = "";
	String StartTime_Converted = "";
	String Startdate ="";
	String EndTime      = "";
	String EndTime1      = "";
	String EndTime_Converted = "";
	String EndTime1_Converted = "";
	if (EncounterId==null)	EncounterId = "";
	if (PatientId==null)	PatientId = "";
	if (StartTime==null)	StartTime = "";
	if (EndTime==null)		EndTime = "";
	if (PractId1==null)		PractId = "";
	if (call_from==null)	call_from = "";
	String FacilityId  	= (String) session.getValue( "facility_id" );
	String sql			= "";
	String PractDetails	= "";
	String PatDetails   = "";
	String name	= "";
	String dob	= "";
	String PatientIdDisplay= "";
	String PractName= "";
	String sys_date	= "";
	String sys_dttime="";
	String followUpDate=request.getParameter("followup_date");

	if(followUpDate==null)
		followUpDate="";

	String occupationClass="";
	String occupation="";
	String employeeID="";
	String employerName="";

	String nationalIDPrompt="NRIC No.";
	String NRICNo="";
	String altIdTypeDescription[]=new String[4];
	String altIdNo[]=new String[4];
	String chkattribute="";
	String disattribute="";
	String readattribute="";

	for(int i=0;i<4;i++)
	{
		altIdTypeDescription[i]="";
		altIdNo[i]="";
	}

	Connection conn = null;
	
	if(EncounterId.equals(""))
	{
	    chkattribute="";
		readattribute="readOnly";
		disattribute="disabled";
	}else
	{
		chkattribute="checked";
		readattribute="";
		disattribute="";
	}

	
	if 	(!call_from.equals("MAIN"))
	{
		try{
			conn=ConnectionManager.getConnection(request);
			if(!PatientId.equals(""))
			    sql="select to_char(SYSDATE,'DD/MM/YYYY') sys_date,get_patient.get_line_detail(?,?) Pline, to_char(SYSDATE,'dd/mm/yyyy hh24:mi') sys_dttime FROM dual";
			else
		         sql="select to_char(SYSDATE,'DD/MM/YYYY') sys_date, get_patient.get_line_detail(?,?,?) Pline, to_char(SYSDATE,'dd/mm/yyyy hh24:mi') sys_dttime FROM dual"; 
			pstmt = conn.prepareStatement(sql);
			if(!PatientId.equals(""))
			{
				pstmt.setString(1,PatientId);
				pstmt.setString(2,locale);
			}
			else{
				pstmt.setString(1,FacilityId);
				pstmt.setString(2,EncounterId);
				pstmt.setString(3,locale);
				}
			rs = pstmt.executeQuery();
			if (rs!=null)
			{
				if (rs.next())
				{
					sys_date = rs.getString(1);
					PatDetails = rs.getString(2);
					sys_dttime = rs.getString(3);
					if (PatDetails==null) PatDetails="";
				}
			}
			if ( rs != null ) rs.close() ;
			if ( pstmt != null ) pstmt.close() ;

			if(PatientId.equals(""))
			{
			
			
			/*sql="select to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi' ) ,to_char(nvl(discharge_date_time,sysdate),'dd/mm/yyyy hh24:mi'),to_char(nvl(discharge_date_time+1,sysdate+1),'dd/mm/yyyy '),b.practitioner_id,b.practitioner_name,to_char(visit_adm_date_time,'dd/mm/yyyy') from pr_encounter a, am_practitioner b where a.facility_id = ? and a.encounter_id = ? and a.attend_practitioner_id = b.practitioner_id(+)";
			*/

	
			//sql="select to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi' ) ,to_char(nvl(discharge_date_time,sysdate),'dd/mm/yyyy hh24:mi'),to_char(nvl(discharge_date_time+1,sysdate+1),'dd/mm/yyyy '), a.attend_practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(a.attend_practitioner_id,'"+locale+"','1') practitioner_name, to_char(visit_adm_date_time,'dd/mm/yyyy') from PR_ENCOUNTER a where a.facility_id = ? and a.encounter_id = ?";

			//sql="select to_char(A.visit_adm_date_time,'dd/mm/yyyy hh24:mi'),to_char(nvl(A.discharge_date_time,sysdate),'dd/mm/yyyy hh24:mi'),to_char(nvl(A.discharge_date_time+1,sysdate+1),'dd/mm/yyyy '),a.attend_practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(NVL( a.attend_practitioner_id,'"+PractId1+"'),'"+locale+"','1') practitioner_name,to_char(A.visit_adm_date_time,'dd/mm/yyyy'),to_char(B.date_of_birth,'dd/mm/yyyy') from PR_ENCOUNTER a, MP_PATIENT b where  a.facility_id = ? and a.encounter_id = ? AND a.PATIENT_ID = b.PATIENT_ID"; 

			sql="select to_char(A.visit_adm_date_time,'dd/mm/yyyy'),to_char(nvl(A.discharge_date_time,sysdate),'dd/mm/yyyy'),to_char(nvl(A.discharge_date_time+1,sysdate+1),'dd/mm/yyyy'),a.attend_practitioner_id practitioner_id, am_get_desc.AM_PRACTITIONER(NVL( a.attend_practitioner_id,'"+PractId1+"'),'"+locale+"','1') practitioner_name,to_char(A.visit_adm_date_time,'dd/mm/yyyy'),to_char(B.date_of_birth,'dd/mm/yyyy') from PR_ENCOUNTER a, MP_PATIENT b where  a.facility_id = ? and a.encounter_id = ? AND a.PATIENT_ID = b.PATIENT_ID"; 




			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,FacilityId);
			pstmt.setString(2,EncounterId);
			rs = pstmt.executeQuery();
			if (rs!=null){
				if (rs.next()){
				StartTime =	 rs.getString(1);
				EndTime   =	 rs.getString(2);
				EndTime1   =	 rs.getString(3);
				PractId   =	 rs.getString(4);
				PractName =	 rs.getString(5);
				Startdate=   rs.getString(6);
				dob		=	rs.getString(7);
				if (StartTime==null) StartTime="";
				if(!(StartTime==null || StartTime.equals("")))
					StartTime_Converted =  DateUtils.convertDate(StartTime,"DMY","en",locale);

				if (EndTime==null) EndTime="";
				if(!(EndTime==null || EndTime.equals("")))
					EndTime_Converted =  DateUtils.convertDate(EndTime,"DMY","en",locale);

				if (EndTime1==null) EndTime1="";
				if(!(EndTime1==null || EndTime1.equals("")))
					EndTime1_Converted =  DateUtils.convertDate(EndTime1,"DMY","en",locale);

								
				if (PractId==null) PractId="";
				if (PractName==null) PractName="";
				if(Startdate==null)Startdate="";
				if(dob==null)	dob="";
				}
			}
			if ( rs != null ) rs.close() ;
			if ( pstmt != null ) pstmt.close() ;

		}
		

		if (PractId1==null) PractId1="";
		
		if (PractId.equals("")){
			//sql="select practitioner_name from am_practitioner where practitioner_id =?";
			sql="select practitioner_name from am_practitioner_lang_vw where language_id='"+locale+"' and practitioner_id =?";


			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,PractId1);
			rs=pstmt.executeQuery();
			PractId = PractId1;
			if (rs!=null){
				if (rs.next()){
					PractName =	 rs.getString(1);
					if (PractName==null) PractName="";
				}
			}
			if ( rs != null ) rs.close() ;
			if ( pstmt != null ) pstmt.close() ;			
		}

		StringTokenizer token=new StringTokenizer(PatDetails,"|");
		while(token.hasMoreTokens()){
			name=token.nextToken();
			PatientIdDisplay  =token.nextToken();
			PatientId  =PatientIdDisplay.substring(3,PatientIdDisplay.length());
			if(!EncounterId.equals("")){
				PractDetails=token.nextToken();
				token.nextToken();
			}
		}

		/*if(EncounterId.equals("")){
				sql="select to_char(date_of_birth,'dd/mm/yyyy') from mp_patient where patient_id=?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,PatientId);
				rs=pstmt.executeQuery();
				if (rs!=null){
					if (rs.next())
					  dob = rs.getString(1);
				
				}
				if ( rs != null ) rs.close() ;
				if ( pstmt != null ) pstmt.close() ;
			}*/
		
		if(!PatientId.equals("")){			
				//sql="select emplr_ocpn_class_desc, occupation_desc, patient_employee_id, emplr_contact_name, national_id_no, alt_id1_desc, alt_id1_no, alt_id2_desc, alt_id2_no, alt_id3_desc, alt_id3_no, alt_id4_desc, alt_id4_no from mp_chg_pat_dtls_vw where patient_id=?";


				//sql="select mp_get_desc.mp_occupation_class(ocpn_class_code,'"+locale+"',2)emplr_ocpn_class_desc, mp_get_desc.mp_occupation(ocpn_code,'"+locale+"',2)occupation_desc, patient_employee_id, emplr_contact_name, national_id_no, mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"',2)alt_id1_desc, alt_id1_no, mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"',2)alt_id2_desc, alt_id2_no, mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"',2)alt_id3_desc, alt_id3_no, mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"',2)alt_id4_desc, alt_id4_no from MP_CHG_PAT_DTLS_VW where patient_id = ?";


				//sql=" select MP_GET_DESC.mp_occupation_class(b.ocpn_class_code,'"+locale+"',2) emplr_ocpn_class_desc, mp_get_desc.mp_occupation(b.ocpn_code,'"+locale+"',2) occupation_desc, b.patient_employee_id, b.contact3_name emplr_contact_name, a.national_id_no, mp_get_desc.MP_ALTERNATE_ID_TYPE(a.alt_id1_type,'"+locale+"',2) alt_id1_desc, a.alt_id1_no, mp_get_desc.MP_ALTERNATE_ID_TYPE(a.alt_id2_type,'"+locale+"',2) alt_id2_desc, a.alt_id2_no, mp_get_desc.MP_ALTERNATE_ID_TYPE(a.alt_id3_type,'"+locale+"',2) alt_id3_desc, a.alt_id3_no, mp_get_desc.MP_ALTERNATE_ID_TYPE(a.alt_id4_type,'"+locale+"',2) alt_id4_desc, a.alt_id4_no, nvl(c.nat_id_prompt, 'National ID No.') nationalIDPrompt from MP_PATIENT A, MP_PAT_REL_CONTACTS B, MP_PARAM_LANG_VW C where a.patient_id = ? and a.patient_id=b.patient_id";

				 sql="select MP_GET_DESC.mp_occupation_class(b.ocpn_class_code,'"+locale+"',2) emplr_ocpn_class_desc, mp_get_desc.mp_occupation(b.ocpn_code,'"+locale+"',2) occupation_desc, b.patient_employee_id, b.contact3_name emplr_contact_name,a.national_id_no, mp_get_desc.MP_ALTERNATE_ID_TYPE(a.alt_id1_type,'"+locale+"',1) alt_id1_desc, a.alt_id1_no, mp_get_desc.MP_ALTERNATE_ID_TYPE(a.alt_id2_type,'"+locale+"',2) alt_id2_desc, a.alt_id2_no, mp_get_desc.MP_ALTERNATE_ID_TYPE(a.alt_id3_type,'"+locale+"',2) alt_id3_desc,a.alt_id3_no, mp_get_desc.MP_ALTERNATE_ID_TYPE(a.alt_id4_type,'"+locale+"',2) alt_id4_desc, a.alt_id4_no, nvl(c.nat_id_prompt, 'National ID No.') nationalIDPrompt,to_char(A.date_of_birth,'dd/mm/yyyy') DOB from MP_PATIENT A, MP_PAT_REL_CONTACTS B, MP_PARAM_LANG_VW C where a.patient_id = ? and a.patient_id=b.patient_id" ;


/*				
				pstmt=conn.prepareStatement("select nvl(nat_id_prompt, 'NRIC No.') nationalIDPrompt from MP_PARAM_LANG_VW where module_id='MP' and language_id='"+locale+"'");
				rs = pstmt.executeQuery();
				if(rs!=null && rs.next())
					nationalIDPrompt=rs.getString("nationalIDPrompt");
				if ( rs != null ) rs.close() ;
				if ( pstmt != null ) pstmt.close() ;
*/
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,PatientId);
				rs=pstmt.executeQuery();

				if(rs!=null && rs.next())
				{
					nationalIDPrompt=rs.getString("nationalIDPrompt");
					occupationClass=rs.getString("emplr_ocpn_class_desc");
					occupation=rs.getString("occupation_desc");
					employeeID=rs.getString("patient_employee_id");
					employerName=rs.getString("emplr_contact_name");
					NRICNo=rs.getString("national_id_no");
					dob=rs.getString("DOB");

					if(NRICNo==null) NRICNo="";
					
					for(int i=0;i<4;i++)
					{
						altIdTypeDescription[i]=rs.getString("alt_id"+(i+1)+"_desc");
						altIdNo[i]=rs.getString("alt_id"+(i+1)+"_no");

						if(altIdTypeDescription[i]==null)
							altIdTypeDescription[i]="";

						if(altIdNo[i]==null)
							altIdNo[i]="";
					}

					if(occupationClass==null)
						occupationClass="";

					if(occupation==null)
						occupation="";

					if(employeeID==null)
						employeeID="";

					if(employerName==null)
						employerName="";
				}
				if ( rs != null ) rs.close() ;
				if ( pstmt != null ) pstmt.close() ;
			}

	}catch ( Exception e ){ e.printStackTrace();}
	
	finally{
			if(conn!=null) ConnectionManager.returnConnection(conn,request);
	 }

		%>
		<table border='0' cellpadding='3' cellspacing='0' width='100%'>
         <tr>
			<td class='PATIENTLINECOLOR' width='55%' style='position:relative;' colspan='1' nowrap><%=name%></td>
				
			<td class='PATIENTLINECOLOR' width='20%' style='position:relative;' colspan='1'></td>
 		
			<td class='PATIENTLINECOLOR' width='25%' style='position:relative;' colspan='1'><%=PatientIdDisplay%></td>

			<td width = '5%' class='PATIENTLINECOLOR' style='position:relative;'></td>
				
			<td width='5%' style='position:relative;' class='PATIENTLINECOLOR'></td>

		<%if(!EncounterId.equals("")){%>
		<tr>
		
		<td class='PATIENTLINECOLOR' width='55%' nowrap
		style='position:relative;'><%=PractDetails%></td>
			
		<td class='PATIENTLINECOLOR' width='20%' 
		style='position:relative;'></td>
		
		<td class='PATIENTLINECOLOR'  style='position:relative;' width='25%' nowrap><fmt:message key="Common.encounter.label" bundle="${common_labels}"/> :<%=EncounterId%></td><td class='PATIENTLINECOLOR' style='position:relative;' width='5%'></td>
		<td class='PATIENTLINECOLOR' style='position:relative;' width='5%' ></td>
		</tr>
		<%}%>
		</tr>
		<tr>
		<td class='PATIENTLINECOLOR' style='position:relative;' nowrap>
			
		<%if(!NRICNo.equals("")){%>
			
		<%=nationalIDPrompt%>:<%= NRICNo %>
	
		<%}%>
		
		</td>
			
		<%
			String altIdTypeDescriptionDisplay="";
			String altIdNoDisplay="";
			for(int i=0;i<4;i++)
			{
				if(!altIdTypeDescription[i].equals("") && !altIdNo[i].equals("")){ 
					altIdTypeDescriptionDisplay=altIdTypeDescription[i];
					altIdNoDisplay=altIdNo[i];
					break;
				}
					
			}%>

			<td class='PATIENTLINECOLOR' width='15%' style='position:relative;' colspan='1'></td>
			
			<td class='PATIENTLINECOLOR' width='25%' style='position:relative;' colspan='1' nowrap>
				
			<%if(!altIdTypeDescriptionDisplay.equals("")){%>	
			<%=altIdTypeDescriptionDisplay%>:<%=altIdNoDisplay%>
			
			<%}%>
			
			</td>

			<td width = '5%' class='PATIENTLINECOLOR' style='position:relative;'></td>
				
			<td width='5%' style='position:relative;' class='PATIENTLINECOLOR'></td>
		</tr>
	    </table>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
		<tr><td colspan='4' class='label'></td></tr>
		<tr><td colspan='4' class='label'></td></tr>
		<tr><td colspan='4' class='label'></td></tr>
		<tr><td colspan='4' class='label'></td></tr>
		<tr><td colspan='4' class='label'></td></tr>
		<tr>
		 <td class='label' width='25%'><fmt:message key="Common.certificatetype.label" bundle="${common_labels}"/>
		  <td class='fields' width='30%'>
			  <select name='certificate_type' id='certificate_type' onChange="PopulateValues(this);">
				<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<option value='M'><fmt:message key="Common.medical.label" bundle="${common_labels}"/></option>
				<option value='O'><fmt:message key="Common.others.label" bundle="${common_labels}"/> </option>
			  </select><img  src='../../eCommon/images/mandatory.gif'></img>
		  </td>
		<td width='25%' class='label' nowrap>
      	<fmt:message key="Common.medical.label" bundle="${common_labels}"/> <fmt:message key="Common.certificate.label" bundle="${common_labels}"/> <fmt:message key="Common.no.label" bundle="${common_labels}"/>
		</td>
		<td width='20%' class='fields'>
		<input type='text' name='mcNo' id='mcNo' value='' onBlur='makeValidString(this);checkMaxLen(this)' onkeypress="return CheckForSpecChars(event);" size='20' maxlength='20'>
		<img  src='../../eCommon/images/mandatory.gif'></img>
	</td>	
 </tr>	
	
<%if(!EncounterId.equals("")){%>

	<tr><td class='label'><fmt:message key="Common.LeaveFrom.label" bundle="${common_labels}"/></td>
	<td width ='10%' class='QUERYDATA' nowrap><%=StartTime_Converted%>			
	<input id='leave_date_from' type='hidden' name='LeaveFrom' id='LeaveFrom' maxlength='10' size='10' value ="<%=StartTime_Converted%>">
		
	</td>
			
	<td Class = label ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	
	<td class='fields'><input type='text' id='leave_date_to' name='LeaveTo' id='LeaveTo' maxlength='10' size='10' value ="<%=EndTime_Converted%>" onBlur="checkDateTime(this)">
	<img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById("LeaveTo").focus();return showCalendar('leave_date_to')" ><img  src='../../eCommon/images/mandatory.gif'></img>
	<input type='hidden' name='LeaveTo1' id='LeaveTo1' maxlength='20' size='20' value ="" readonly>
	</td>
	</tr>
	<tr>
	<!-- Code added by Tushar .T. Bhat on 30-Jan-04 -->
	<td class=label nowrap><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/></td>
	<td  class='fields'><input type='text' name='noOfDays' id='noOfDays' value='' size='3' readonly></td>
	<td class=label>&nbsp;</td>	
	<td class=label>&nbsp</td>
	<script>

	calculateNoOfDays();

	</script>
	</tr>
	
<%}else{%>
	<tr>
	<td class='label'><fmt:message key="Common.LeaveFrom.label" bundle="${common_labels}"/></td>
		 <td class='fields' nowrap> 
		
	<input type='text' id='leave_date_from' name='LeaveFrom' id='LeaveFrom' maxlength='10' size='10' value ="<%=StartTime_Converted%>" onBlur= "checkDateTime(this)">
		
	<img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById("LeaveFrom").focus();return showCalendar('leave_date_from')" style="cursor='hand'"></img><img  src='../../eCommon/images/mandatory.gif'></img>
		
	</td>
		
	<td Class = label ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	
	<td class='fields' >
		
	<input type='text' id='leave_date_to' name='LeaveTo' id='LeaveTo' maxlength='10' size='10' value ="<%=EndTime_Converted%>" onBlur= "checkDateTime(this)">
		
	<img  src='../../eCommon/images/CommonCalendar.gif' onClick="document.getElementById("LeaveTo").focus();return showCalendar('leave_date_to')" style="cursor='hand'"></img><img  src='../../eCommon/images/mandatory.gif'></img>
		
	</td>

	<!-- Code added by Tushar .T. Bhat on 30-Jan-04 -->
	</tr>
	<tr>
	<td class=label nowrap><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name='noOfDays' id='noOfDays' value='' size='3' readonly></td>	
	<td class=label>&nbsp</td>
	<td class=label>&nbsp</td>
	</tr>
	<%}%>
	<tr>
		
	<td class='label'><fmt:message key="Common.ResumeActivity.label" bundle="${common_labels}"/></td>
	
	<td class='fields' nowrap>
	<input type='checkbox' name='FitForDuty' id='FitForDuty' value ='Y' <%=chkattribute%> onclick="enablefit(this)">
	</td>
			
	<td Class = label >
	<fmt:message key="Common.date.label" bundle="${common_labels}"/>
    </td>
	
	<td class='fields'>
		
	<input type='text' id='fit_on_duty' name='FitonDuty' id='FitonDuty' maxlength='10' size='10' value ="<%=EndTime1_Converted%>" <%=readattribute%> onBlur= "checkDateTime(this)">
		
	<img src='../../eCommon/images/CommonCalendar.gif' name ="FitCal" onClick="document.getElementById("FitonDuty").focus();return showCalendar('fit_on_duty');" style="cursor='hand'" <%=disattribute%>></img>

    </td>
	</tr>
	<%if(!followUpDate.equals("")){%>
	<tr>	
	<td class=label nowrap><fmt:message key="Common.followupdate.label" bundle="${common_labels}"/></td>
	
	<td class='querydata'>
		
	<B><%=followUpDate%></B>
	
	</td><td class='label' >&nbsp;</td><td class='label' >&nbsp;</td>

	<input type='hidden' name='followUpDate' id='followUpDate' value='<%=followUpDate%>'>
	</tr>

	<%}
	else{%>
	<tr>
	<td class='label'></td>
	<td class='label'></td>
	<td class='label' ></td>
	<td class='label'  ></td>
	</tr>
	<%}%>
	<tr>
		<td class='label' nowrap><fmt:message key="Common.certificateissued.label" bundle="${common_labels}"/></td>
		<td class='fields' ><input type='checkbox' name='CertIssued' id='CertIssued' value =N onClick="dispIssuedDate(this);"></td>
		
	    <td class='label' nowrap> <fmt:message key="Common.issueddate.label" bundle="${common_labels}"/> </td>
		<td class='fields'>

		<input type='text' id='issued_date' name='IssuedDate' id='IssuedDate' maxlength='10' size='10' value ="" readonly  onBlur="checkDateTime(this)">
		<img  src='../../eCommon/images/CommonCalendar.gif' name ="IssuedCal" onClick="document.getElementById("IssuedDate").focus();return showCalendar('issued_date');" style="cursor='hand'" disabled></img>
		</td> 
		</tr>
		<tr>
		<td  class='label' nowrap><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
		<td  class='fields'><input type='text' size = 30 maxlength = 30 name='auth_by_name' id='auth_by_name' value ="<%=PractName%>" onBlur="onBlurCallPractitionerSearch(document.forms[0].pract_butt,auth_by_name);"><input type='button' name='pract_butt' id='pract_butt' value='?' class='button'  onClick="callPractSearch(this,auth_by_name);"><img  src='../../eCommon/images/mandatory.gif'></img><input type='hidden' name='AuthorizedById' id='AuthorizedById' value ="<%=PractId%>"></td>
		<td class='label' >&nbsp;</td>
	<td class='label'  >&nbsp;</td>
		</tr>
		
	<!-- </table>
		
		<table border='1' cellpadding='0'cellspacing='0' width='100%' align='center'> -->
    	<tr>
			<td  class='label' valign=top><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td  class='fields' valign=top  colspan='2'><textarea name='Remarks' rows=3 cols=70 onblur='makeValidString(this);checkMaxLen(this);' onkeypress='checkMaxLimit(this,500)'></textarea><img valign='center' src='../../eCommon/images/mandatory.gif'></img></td>
		 <td ></td>
			
		</tr> 
		
        <!-- </table>
		<table  border='1' cellpadding='0'cellspacing='0' width='100%' align='center'> -->
		  <tr>
			<td id='enableDisable' style='visibility:hidden' colspan='4'>
			 <%if(occupation.equals("") && occupationClass.equals("") && employeeID.equals("") && employerName.equals(""))
			{%>			
		
		  <table  border='0' cellpadding='3'cellspacing='0' width='100%' align='center'>
	 <tr>
		<td class="COLUMNHEADER" colspan='4'><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></td>
		 </tr>

		 <tr>	
			<td  class='label' nowrap width='25%'>&nbsp;</td>
			<input type='hidden' name='employmentDetailsHidden' id='employmentDetailsHidden' value=''>
			<td   class='fields' colspan='2'><textarea name='employmentDetailsTextArea' rows=4 cols=70 onBlur='makeValidString(this);checkMaxLen(this)' ></textarea>
			</td>
			<script>
			document.getElementById("employmentDetailsHidden").value=document.getElementById("employmentDetailsTextArea").value
			</script>
			<td class='label' width='20%' >&nbsp;</td>
		</tr>
			 <%}
				else{%>
				
           <table  border='0' cellpadding='3'cellspacing='0' width='100%' align='center'> 
         <tr>
		<td class="COLUMNHEADER" colspan='4'><fmt:message key="Common.employmentdetails.label" bundle="${common_labels}"/></td>
		 </tr>
		<tr>
			<td  class='label' nowrap width='25%'>
			<fmt:message key="eMP.OccupationClass.label" bundle="${mp_labels}"/>
		</td>
			<td  class='querydata' nowrap width='30%'>
				<B><%=occupationClass%></B>
			</td>
			<td  class='label' nowrap width='25%'>
				<fmt:message key="eMP.occupation.label" bundle="${mp_labels}"/>
			</td>
			<td  class='QUERYDATA' nowrap width='20%'>
				<B><%=occupation%></B>
			</td>
		</tr>
		<tr>
			<td  class='label' nowrap>
				<fmt:message key="Common.employmentid.label" bundle="${common_labels}"/>
			</td>
			<td  class='QUERYDATA' nowrap>
				<B><%=employeeID%></B>
			</td>
			<td class='label' nowrap>
				<fmt:message key="Common.employer.label" bundle="${common_labels}"/> <fmt:message key="Common.name.label" bundle="${common_labels}"/>
			</td>	
			<td class='QUERYDATA' nowrap>
				<B><%=employerName%></B>
			</td> 
			<input type='hidden' name='employmentDetailsHidden' id='employmentDetailsHidden' value='<%=occupationClass+occupation+employeeID+employerName%>'>
			</tr>

			<%}%>
			 </table>
	 		</td>
			</tr>
		</table> 

	<table width='100%' border='0' cellpadding='3' cellspacing='0'  align='right' >
		<tr>
			<td class='button' ><input type='button' class='Button' name='record' id='record' onClick='Record()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>'><input type='button' class='Button' name='clear' id='clear' onClick='Clear_vals()' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'><input type='button' class='Button' name='cancel' id='cancel' onClick='Close_win()' value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%> '>
			</td>
		</tr>
	</table>
		<input type='hidden' name='EncounterId' id='EncounterId' value="<%=EncounterId%>">        
		<input type='hidden' name='PatientId' id='PatientId' value="<%=PatientId%>">        
		<input type='hidden' name='SickLeaveDetails' id='SickLeaveDetails' value="<%=SickLeaveDetails%>">        
		<input type='hidden' name='dob' id='dob'	value="<%=dob%>">        
		<input type='hidden' name='sydate' id='sydate' value="<%=sys_date%>"> 
		<input type='hidden' name='LeaveFrom1' id='LeaveFrom1' value='<%=Startdate%>'>
		<input type='hidden' name='sydttime' id='sydttime' value="<%=sys_dttime%>">
	
<%	}	%>
<input type='hidden' name='call_from' id='call_from' value='<%=call_from%>'>		


</form>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

