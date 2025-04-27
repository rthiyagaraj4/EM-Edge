<!DOCTYPE html>
<%
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
/// MODULE			:	OutPatient Management..(OP)
// Developer		:	SRIDHAR R 
/// Created On		:	6 SEP 2004
/// Funtion			:	To View the details of Referrals made & Book an appointment for the same... if referred to is Login facility..
/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
%>

<%@ page contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script src='../../eMP/js/ReferralDtls.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<%
	Connection con = null;
	PreparedStatement pstmt	= null;
	Statement stmt = null;
	ResultSet rs	= null;	
	ResultSet rs1	= null;

	


	//String	care_locn_type_ind	= ""; 
	String	appt_ref_no			= ""; 
	String	referral_id			= ""; 
	String preferred_treatment_date="";
	String preferred_treatment_date1="";
	
	String	patient_id			= "";
	
	String	to_pract_id			= "";
	String	to_speciality_desc	= "";
	String	to_speciality_code	= "";
	
	String	Practitioner		= "";
	String	to_ref_locn_desc	= "";
	StringBuffer referral_idS	=new StringBuffer();
	String	to_locn_type		= "";
	
  
	String  to_nurs_unit_code	= "";
	String  to_clinic_code		= "";
	String  referred_to			= "";
	String  Location_Code		= "";
	String  Location_Desc		= "";
	String  to_nurs_unit_desc	= "";
	String  to_clinic_desc		= "";
	String  to_ref_type			= "";
	String  to_facility_name	= "";
	
	/*Below line Added for this cRF Bru-HIMS-CRF-261*/
	String quick_admission="";
	String ip_open_encounter_id="";
	String from_encounterid="";
	String open_encounter="";
	//String regOutref="";	
String globaluser = (String)(session.getValue("login_user")==null?"":session.getValue("login_user"));
String quickadmchk="";

//End Bru-HIMS-CRF-261

//Below line Added for this incident  [41098] 
String admission_type="";ResultSet rs2=null;
	
	//String  from_time			= "";
	//String  to_time				= "";
	//String  appt_date			= "";
	//String  resource_class		= "";
	String  care_Ind			= "";
	StringBuffer sql = new StringBuffer();

	try
	{
		con	= ConnectionManager.getConnection(request);		
		Boolean isForAdmission = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "AE_FOR_ADMISSION_TAB");//Added by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
		//String facility_id = (String)session.getValue("facility_id");	
		String funcId	= request.getParameter("recFun");
		if(funcId	== null) funcId	= "";
			//added for Bru-HIMS-CRF-380 Start
			String facility_id	= request.getParameter("facility_id");
			if(facility_id==null)
				facility_id = (String) session.getValue("facility_id");
			//added for Bru-HIMS-CRF-380 End	
		String encounter_id	= request.getParameter("encounter_id");
		if(encounter_id	== null) encounter_id	= "";

		String patient_ID	= request.getParameter("patient_id");
		if(patient_ID == null) patient_ID = "";

		String Transaction_type	= request.getParameter("Transaction_type");
		if(Transaction_type == null) Transaction_type = "";
        
		
		
		ip_open_encounter_id	= request.getParameter("ip_open_encounter_id");
		if(ip_open_encounter_id == null) ip_open_encounter_id = "";
		
		/*Below line Added for this incident [41098]*/
			
			try
					{						
						String ip_paracheck="select allowed_admission_type from ip_param where facility_id ='"+facility_id+"'";
						stmt=con.createStatement();	
						rs2=stmt.executeQuery(ip_paracheck);
						if(rs2.next()){
							admission_type=checkForNull(rs2.getString("allowed_admission_type"));
						}						
						if(stmt !=null) stmt.close(); if(rs2 !=null) rs2.close(); 
					}catch(Exception e)
					{
						
						e.printStackTrace() ;
						
					}
		//end 41098

		if(Transaction_type.equals("MR") || Transaction_type.equals("VW"))// called from eMR -> Queries -> View Encounter Details 
		{	
			out.println("<title>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referraldetails.label","common_labels")+"</title>");
		}
%>
</head>                         
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<form name='ReferralResultForm' id='ReferralResultForm'>

<%//if(Transaction_type.equals("MR")){	%>
        <div  style="position:relative;height:120px; overflow:auto">
		<table width='100%' height='30' cellspacing='0' cellpadding='2' border=1>
			<thead>
		 	<tr style="position: sticky; top: 0; z-index: 1;"> 
				<th width='16%' align='center' nowrap ><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></th>
				<th width='12%' align='center' nowrap ><fmt:message key="Common.PreferredOn.label" bundle="${common_labels}"/></th>
				<th width='15%' align='center' nowrap ><fmt:message key="Common.ReferredTo.label" bundle="${common_labels}"/></th>
				<th width='15%' align='center' nowrap ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
				<th width='15%' align='center' nowrap ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
				<th width='15%' align='center' nowrap ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			<%if(!isForAdmission || (isForAdmission.equals(true) && !funcId.equals("ModifyReferral") && !Transaction_type.equals("VW"))) { %> <!--  added by lakshmanan for ML-MMOH-CRF-1972 on 24-07-2023 -->
				<th width='10%' align='center' nowrap ><fmt:message key="Common.apptno.label" bundle="${common_labels}"/>/<fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>	
				<% } %>			
			</tr>
			&nbsp;
			<tr><td colspan='7'></td></tr></thead>
		
<%	//}
	try
	{
		
		stmt=con.createStatement();	

		//<!--if condition modified AND Added (Transaction_type.equals("VW")) by Himanshu Saxena on 11-Jul-2023 for ML-MMOH-CRF-1972 US5 -->
			if( Transaction_type.equals("MR") || Transaction_type.equals("DA") || Transaction_type.equals("CO") || Transaction_type.equals("DP") || Transaction_type.equals("VW"))
			{
			  /*Below query modified for this CRF Bru-HIMS-CRF-261*/
			
				sql.append(" select  b.appt_ref_no appt_ref_no, (case when a.to_facility_id is not null then( sm_get_desc.sm_facility_param(a.to_facility_id,'"+localeName+"','1')) end) to_facility_name, a.to_ref_type to_ref_type, to_char(sysdate,'dd/mm/yyyy hh24:mi') sydate, a.referral_id referral_id, to_char (a.referral_date, 'dd/mm/yyyy') referral_date, to_char (a.preferred_treatment_date, 'dd/mm/yyyy') preferred_treatment_date, a.to_ref_code to_ref_code, (case when to_ref_code is not null then ( am_get_desc.am_referral(a.to_ref_code,'"+localeName+"',1)) end) to_ref_desc,a.patient_id patient_id, decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, a.to_pract_id to_pract_id, (CASE WHEN a.to_pract_id IS NULL THEN a.to_pract_name ELSE DECODE (a.to_ref_type, 'X', am_get_desc.am_ext_practitioner (a.to_pract_id, '"+localeName+"', 1 ), am_get_desc.am_practitioner (a.to_pract_id, '"+localeName+"', 1)) END ) to_ref_pract_name, a.to_speciality_code to_speciality_code, (case when a.to_speciality_code is not null then ( am_get_desc.am_speciality(a.to_speciality_code,'"+localeName+"','2')) end)  to_speciality_desc,a.to_locn_desc to_ref_locn_desc, decode(a.to_locn_type , 'Y','D',a.to_locn_type) to_locn_type, a.to_speciality_code to_speciality_code, a.to_locn_code to_clinic_code, a.to_locn_code to_nurs_unit_code, (case when a.to_locn_code is not null then ( op_get_desc.op_clinic(a.to_facility_id, a.to_locn_code,'"+localeName+"','1')) end) to_clinic_desc, (case when a.to_locn_code is not null then ( ip_get_desc.ip_nursing_unit(a.to_facility_id, a.to_locn_code, '"+localeName+"','1') ) end) to_nurs_unit_desc, a.quick_admission_yn quick_admission_yn,a.from_encounter_id,c.ENCOUNTER_ID open_encounter,AM_OPER_STN_ACCESS_CHECK('"+facility_id+"','"+globaluser+"','X','','QUICK_ADMISSION_YN') quickadmchk  from pr_referral_register a, OA_APPT b, pr_encounter c WHERE a.added_facility_id = b.facility_id (+) and a.referral_id = b.referral_id(+) and a.added_facility_id = '"+facility_id+"' AND a.from_encounter_id = '"+encounter_id+"' and a.bedside_referral_yn = 'N' and a.REFERRAL_ID=c.REFERRAL_ID(+) ");

				if(isForAdmission && (funcId.equals("ModifyReferral") || Transaction_type.equals("VW")))
				{}
				else
				{
					sql.append(" and a.status !='N'  ");
				}
			  	if(isForAdmission && (funcId.equals("ModifyReferral") || Transaction_type.equals("VW"))){	 //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
			  		sql.append(" AND a.referral_id =(select DISP_REFERRAL_ID from  op_patient_queue where  ENCOUNTER_ID=a.from_encounter_id) ");
			  	}	
			  	sql.append(" order by a.referral_id, a.referral_date desc ");
			}
			
			pstmt=con.prepareStatement(sql.toString());
			rs	= pstmt.executeQuery();
			
			//out.println("<table width='100%' hieght='100%' cellspacing=0 cellpadding=0 border=1 id='RefDertailsDetails'>") ;			
			
			referral_idS.setLength(0);

			if(rs!=null)
			{
				String cname= "QRYEVEN" ;
				int i = 0; 
			
				while(rs.next())
				{
					if(cname.equals("QRYEVEN"))
						cname = "QRYODD" ;
					else
						cname = "QRYEVEN" ;
					
					appt_ref_no			= checkForNull(rs.getString("APPT_REF_NO"));
			
					referral_id			= checkForNull(rs.getString("REFERRAL_ID"));
					
					preferred_treatment_date= checkForNull(rs.getString("PREFERRED_TREATMENT_DATE"));
			
					if(!preferred_treatment_date.equals(""))
					{
						preferred_treatment_date1= DateUtils.convertDate(preferred_treatment_date,"DMY","en",localeName);
					}

					referred_to			= checkForNull(rs.getString("TO_REF_DESC"));
					if(referred_to.equals("")) 
					{
						to_facility_name	= checkForNull(rs.getString("TO_FACILITY_NAME"));
							if(to_facility_name.equals("")) to_facility_name = "&nbsp;";
								referred_to	= to_facility_name;
					}

					patient_id			= checkForNull(rs.getString("PATIENT_ID"));
			
					to_speciality_code	= checkForNull(rs.getString("TO_SPECIALITY_CODE"));
					to_speciality_desc	= checkForNull(rs.getString("TO_SPECIALITY_DESC"));
					if(to_speciality_desc == null || to_speciality_desc.equals("")) 
						to_speciality_desc = "&nbsp;";	
					to_pract_id			= checkForNull(rs.getString("TO_PRACT_ID"));
					
					
					Practitioner		= rs.getString("TO_REF_PRACT_NAME");
					if(Practitioner == null)	Practitioner = "&nbsp;";
					
					to_locn_type		= checkForNull(rs.getString("TO_LOCN_TYPE"));
					
					to_ref_type			= checkForNull(rs.getString("TO_REF_TYPE"));
					if(!to_ref_type.equals("L")) to_ref_type = "&nbsp;";

					referral_idS.append(checkForNull(rs.getString("REFERRAL_ID"))+"/");

					if(to_locn_type.equals("N"))
					{
						to_nurs_unit_code	= checkForNull(rs.getString("TO_NURS_UNIT_CODE"));
						to_nurs_unit_desc	= checkForNull(rs.getString("TO_NURS_UNIT_DESC"));
	
						Location_Code		= to_nurs_unit_code;
						Location_Desc		= to_nurs_unit_desc;

					}
					else if(to_locn_type.equals("C") || to_locn_type.equals("E") || to_locn_type.equals("D"))
					{
						to_clinic_code		= checkForNull(rs.getString("TO_CLINIC_CODE"));
						to_clinic_desc		= checkForNull(rs.getString("TO_CLINIC_DESC"));
						
						Location_Code		= to_clinic_code;
						Location_Desc		= to_clinic_desc;
					}
					else
					{
						Location_Code = "";
						to_clinic_code="";
						to_ref_locn_desc	= checkForNull(rs.getString("TO_REF_LOCN_DESC"));
						Location_Desc		= to_ref_locn_desc;
					}

					if(Location_Desc == null || Location_Desc.equals("")) 
						Location_Desc = "&nbsp;";		
					
					/*Below line Added for this CRF Bru-HIMS-CRF-261*/
					quick_admission=checkForNull(rs.getString("quick_admission_yn"));
					from_encounterid=checkForNull(rs.getString("from_encounter_id")); 
					open_encounter=checkForNull(rs.getString("open_encounter")); 
					quickadmchk=checkForNull(rs.getString("quickadmchk")); 
					
					try{							
						   String sqlQuery = "SELECT LEVEL_OF_CARE_IND CARE_IND FROM op_clinic WHERE clinic_code = '"+Location_Code+"' AND facility_id = '"+facility_id+"'";
						   rs1	= stmt.executeQuery(sqlQuery); 			
						   if(rs1!=null && rs1.next()) {
							care_Ind	= checkForNull(rs1.getString("CARE_IND"));
						   }							
						   if(rs1 != null) rs1.close();
						}catch(Exception e) {
							e.printStackTrace();
						}
					
					%>
					<tbody>
					<tr>
					<%
					if( Transaction_type.equals("MR") )
					{	%>

						<td align='center' width='16%' class="<%=cname%>" style="color:#6600FF;cursor:pointer" onclick= "showRefDtls('<%=referral_id%>')"><%=referral_id%></a></td>
				<%	}
					else
					{	%>
						<td align='center' width='16%' class="<%=cname%>" ><a href ="javascript:showRefDtls('<%=referral_id%>')"><%=referral_id%></a></td>
				<%	}	%>

						<td class='<%=cname%>' width='12%' align='center'><%=preferred_treatment_date1%>&nbsp;</td>
						<td class='<%=cname%>' width='15%' align='left'  ><%=referred_to%></td>
						<td class='<%=cname%>' width='15%' align='left'  ><%=to_speciality_desc%></td>
						<td class='<%=cname%>' width='15%' align='left'  ><%=Location_Desc%></td>
						<td class='<%=cname%>' width='15%' align='left'	 ><%=Practitioner%></td>
					<%  
					if(!isForAdmission || (isForAdmission.equals(true) && !funcId.equals("ModifyReferral") && !Transaction_type.equals("VW"))){ //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
					if(Transaction_type.equals("MR") && appt_ref_no.equals(""))
					{	%>
						<td class='<%=cname%>' width='10%' align='center' >&nbsp;</td>
				<%	}
					else if(appt_ref_no.equals("") && to_ref_type.equals("L") && !to_locn_type.equals("N") && !care_Ind.equals("E") && !Transaction_type.equals("MR"))
					{	%>
		
						<td class='<%=cname%>' width='10%' align='center' id="apptLabel<%=i%>" ><a href="javascript:book_appointment('<%=referral_id%>','<%=to_pract_id%>','<%=patient_id%>','<%=to_speciality_code%>','<%=to_locn_type%>', '<%=preferred_treatment_date%>','<%=i%>','<%=Location_Code%>','<%=encounter_id%>','<%=facility_id%>')" ><fmt:message key="Common.bookappointment.label" bundle="${common_labels}"/></a></td>
					<%
					}
					else if(!appt_ref_no.equals(""))
					{	
					/// Here appt no is not null.. Appt is already made...
						if(appt_ref_no.equals("") || appt_ref_no == null) 
							appt_ref_no="&nbsp;";
					%>	
						<td class='<%=cname%>' width='10%' align='center'  style='cursor:pointer;color:blue' onClick="javascript:view_appt_details('<%=appt_ref_no%>')"><%=appt_ref_no%></td>
					<%
					}
					else
					{	
					/*Below line modified for this CRF Bru-HIMS-CRF-261*/
					if(quick_admission.equals("Y") && open_encounter.equals("") &&!quickadmchk.equals("1")&&!quickadmchk.equals("2")&&!quickadmchk.equals("3")&&!quickadmchk.equals("4")&&!quickadmchk.equals("5") ){ /*Below line modified for this incident [41098]*/
					%>
					   <td class='<%=cname%>' width='10%' align='center'  style='cursor:pointer;color:blue' onClick="javascript:view_admitpatient('<%=referral_id%>','<%=from_encounterid%>','<%=admission_type%>')"><fmt:message key="eMP.QuickAdmission.label" bundle="${mp_labels}"/></td>
					   <%}else if(quick_admission.equals("Y") &&!open_encounter.equals("")){%>
						<td class='<%=cname%>' width='10%' align='center' ><%=open_encounter%></td>
						
					<%}else{%> <td class='<%=cname%>' width='10%' align='center' >&nbsp;</td><%}
					}	//End this CRF Bru-HIMS-CRF-261
					} //modified by lakshmanan for ML-MMOH-CRF-1972 on 19-07-2023
					%>
					</tr>
						<input type = 'hidden' name='referral_idS' id='referral_idS' value="<%=referral_idS.toString()%>" >
				<%		
				i++;
				}
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(stmt != null) stmt.close();

			out.println("</tbody></table></div>");
		
	referral_idS.setLength(0);

	}catch(Exception e) 
	{ 
		out.println(e.toString());
		e.printStackTrace();
	}
finally 
{
	try{
	
	if (rs != null)		rs.close(); 
	if(rs1 != null) rs1.close();
	if(pstmt != null) pstmt.close();
	if(stmt != null) stmt.close();
	}catch(Exception ee){}

	
}
%>
</form>
</body>
<%
}catch(Exception e)
{
	out.println(e);
	e.printStackTrace();
}
finally
{
	if(con != null) ConnectionManager.returnConnection(con,request);
}    
%>

</html>

<%!
public static String checkForNull(String inputString)
{
	return((inputString == null) ? "" : inputString);
}
	
%>

