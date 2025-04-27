<!DOCTYPE html>
<!--
	Module			:	eMR
	Function			:	MR Queries -> View Death Register
	Developed By 	:	Vinod Babu 
	Created On	 	:	12/05/2005
	Modified On		:	12/05/2005
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>


<%

	request.setCharacterEncoding("UTF-8");
	String FacilityId		= (String) session.getValue( "facility_id" ) ;
	String loginUser = (String)session.getValue("login_user");
	String locale			=(String) session.getAttribute("LOCALE");
	String sql = "";
	String PatientId		=	request.getParameter("PatientId") ;
	String EncounterId		=	request.getParameter("EncounterId") ;
	String DischargeDateFrom	=	request.getParameter("DischargeDateFrom") ;
	String DischargeDateTo	=	request.getParameter("DischargeDateTo") ;
	String AdmnDateFrom	=	request.getParameter("AdmnDateFrom") ;
	String AdmnDateTo	=	request.getParameter("AdmnDateTo") ;
	String PatientClass	=	request.getParameter("PatientClass") ;
	String OrderBy			= 	request.getParameter("OrderBy") ;
/*	The following values are to be taken from MP file natAltIDComponentCriteria.jsp
	NRIC - national_id_no
	Birth Cert - alt_id1_no
	Police ID - alt_id3_no
	Other Alt Type - Other_Alt_Type
	Other Alt No - other_alt_Id
	PMI - alt_id2_no
	Old IC No1 - alt_id4_no
*/


	String NRIC	=	request.getParameter("NRIC") ;
	String Birth_Cert	=	request.getParameter("Birth_Cert") ;
	String PMI	=	request.getParameter("PMI") ;
	String Police_ID	=	request.getParameter("Police_ID") ;
	String Old_IC_No1	=	request.getParameter("Old_IC_No1") ;
	String Other_Alt_ID_Type	=	request.getParameter("Other_Alt_ID_Type") ;
	String Other_Alt_ID_No	=	request.getParameter("Other_Alt_ID_No") ;
	String discharged_yn = "";

	if ( PatientId	== null || PatientId.equals( "null" )   || PatientId.equals( "" )   )  		PatientId = "";
	if ( EncounterId	== null || EncounterId.equals( "null" )  	|| EncounterId.equals( "" )  ) 	EncounterId = "";
	if ( DischargeDateFrom == null || DischargeDateFrom.equals( "null" )  || DischargeDateFrom.equals( "" )  ) 	 DischargeDateFrom = "";
	if ( DischargeDateTo	== null || DischargeDateTo.equals( "null" )  || DischargeDateTo.equals( "" )  )  DischargeDateTo = "31/12/2005";
	if ( AdmnDateFrom == null || AdmnDateFrom.equals( "null" )  || AdmnDateFrom.equals( "" )  ) 	AdmnDateFrom = "";
	if ( AdmnDateTo	== null || AdmnDateTo.equals( "null" )  || AdmnDateTo.equals( "" )   )  AdmnDateTo = "31/12/2005";
	if ( PatientClass	== null || PatientClass.equals( "null" )  || PatientClass.equals( "" )  )  PatientClass = "";
	if ( NRIC	== null || NRIC.equals( "null" )  || NRIC.equals( "" )  )  NRIC = "";
	if ( Birth_Cert	== null || Birth_Cert.equals( "null" )  || Birth_Cert.equals( "" )  )  Birth_Cert = "";
	if ( PMI	== null || PMI.equals( "null" )  || PMI.equals( "" )  )  PMI = "";
	if ( Police_ID	== null || Police_ID.equals( "null" )  || Police_ID.equals( "" )  )  Police_ID = "";
	if ( Old_IC_No1	== null || Old_IC_No1.equals( "null" )  || Old_IC_No1.equals( "" )  )  Old_IC_No1 = "";
	if ( Other_Alt_ID_Type	== null || Other_Alt_ID_Type.equals( "null" )  || Other_Alt_ID_Type.equals( "" )  )  Other_Alt_ID_Type = "";
	if ( Other_Alt_ID_No	== null || Other_Alt_ID_No.equals( "null" )  || Other_Alt_ID_No.equals("" ) ) Other_Alt_ID_No = "";
	if ( OrderBy	== null || OrderBy.equals( "null" )  || OrderBy.equals("" ) ) OrderBy = "";

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String finalize_status = "";

	int start = 0 ;
	int end = 0 ;
    int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
		end = 12 ;
	else
		end = Integer.parseInt( to ) ;

	Statement stmt		= null;
	ResultSet rs				= null;
	PreparedStatement pstmt		= null;
	Connection conn = null ;	
try 
{
	conn = ConnectionManager.getConnection(request);	

	StringBuffer aesql = new StringBuffer();
	String oper_stn_id = "";
		
	aesql.append(" select oper_stn_id from am_user_for_oper_stn ");
	aesql.append(" where appl_user_id= ? ");
	aesql.append(" and facility_id=  ? ");
		
	pstmt = conn.prepareStatement(aesql.toString());
	pstmt.setString(1, loginUser);
	pstmt.setString(2, FacilityId);
	
	rs = pstmt.executeQuery();
	if(rs.next())
		oper_stn_id=rs.getString(1);

	if(rs!=null)rs.close();
	if(pstmt!=null)pstmt.close();
	if((aesql != null) && (aesql.length() > 0))
	{
		aesql.delete(0,aesql.length());
	} 


	stmt	= conn.createStatement();
	rs		= stmt.executeQuery("SELECT MAINTAIN_DEATH_REGISTER_YN from am_oper_stn where facility_id ='"+FacilityId+"' and oper_stn_id ='"+oper_stn_id+"'");	
	rs.next();
	String maintain_death_register_yn=rs.getString(1);
	
	%>

<head>
	<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
	<script src="../../eOA/js/QueryLocnForDay.js"></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script>

		async function call_death_reg(encid, patid, practId, pat_class, spclty_code, sex, dob, pract_type,  pat_curr_locn_code,finalize_yn,visit_adm_date)
		{
				if(sex=="Male"){
				sex="M";
			}else if(sex=="Female"){
				sex="F";
			}
			var dialogHeight="700px";
			var dialogWidth="900px";
			var dialogTop="100";
			var center = "1" ;
			var status="no";
			var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + ";" ;
			var arguments	= "" ;
			retVal = 	await window.showModalDialog("../../eMR/jsp/ViewMDRFrames.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code="+pat_curr_locn_code+"&Sex="+sex+"&Dob="+dob+"&speciality_code="+spclty_code+"&patient_id="+patid+"&encounter_id="+encid+"&episode_id="+encid+"&practitioner_id="+practId+"&practitioner_type="+pract_type+"&patient_class="+pat_class+"&call_from=VIEW_DEATH_REG&episode_type=I&finalize_yn="+finalize_yn+"&visit_adm_date="+visit_adm_date,arguments,features);

					//var action_url="../../eMR/jsp/DeathRegisterFrames.jsp?cause_of_death=Y&modal_yn=Y&Locn_Code="+pat_curr_locn_code+"&Sex="+sex+"&Dob="+dob+"&speciality_code="+spclty_code+"&patient_id="+patid+"&encounter_id="+encid+"&episode_id="+encid+"&practitioner_id="+practId+"&practitioner_type="+pract_type+"&patient_class="+pat_class+"&call_from=MAINTAIN_DEATH_REGISTER&episode_type=I&finalize_yn="+finalize_yn;
//		var retVal=window.showModalDialog(action_url,title,features);
		if(retVal==undefined){
			var xmlHttp = new XMLHttpRequest();
			//var xmlHttp 	= new ActiveXObject( "Microsoft.XMLHTTP" );
			xmlHttp.open("POST","../../eMR/jsp/DearthRegisterValidation.jsp?mode=RemoveSessionVals",false);
			xmlHttp.send(null);		
			responseText=xmlHttp.responseText;
		}
	}
	</script>
 </head>
 <body OnMouseDown='CodeArrest();' onKeyDown='lockKey()'>
	<form name='ViewDeathRegisterResult_from' id='ViewDeathRegisterResult_from'   method="post"  target ="messageFrame">
	<%
	StringBuffer Where = new StringBuffer();

	//Where.append(" where a.facility_id ='"+FacilityId+"' and b.patient_id = a.patient_id and a.facility_id = c.facility_id and a.encounter_id = c.encounter_id and a.specialty_code = d.speciality_code " );

	Where.append(" where a.facility_id ='"+FacilityId+"' and b.patient_id = a.patient_id and a.facility_id = c.facility_id and a.encounter_id = c.encounter_id " );

	Where.append(" AND (a.facility_id,a.assign_care_locn_type,a.assign_care_locn_code) in (select facility_id, locn_type, locn_code from AM_OS_USER_LOCN_ACCESS_VW where facility_id ='"+FacilityId+"' and oper_stn_id ='"+oper_stn_id+"' and appl_user_id = '"+loginUser+"' and MAINTAIN_DEATH_REGISTER_YN = 'Y')   ");


 
	if ( ! NRIC.equals("") )
	Where.append(" and b.national_id_no ='"+NRIC+"'");

	if ( ! Birth_Cert.equals("") )
	Where.append(" and b.alt_id1_no ='"+Birth_Cert+"'");

	if ( ! Police_ID.equals("") )
	Where.append(" and b.alt_id3_no ='"+Police_ID+"'");

	if ( ! Other_Alt_ID_Type.equals("") )
	Where.append(" and b.oth_alt_id_type ='"+Other_Alt_ID_Type+"'");

	if ( ! Other_Alt_ID_No.equals("") )
	Where.append(" and b.oth_alt_id_no ='"+Other_Alt_ID_No+"'");

	if ( ! PMI.equals("") )
	Where.append(" and b.alt_id2_no ='"+PMI +"'");

	if ( ! Old_IC_No1.equals("") )
	Where.append(" and b.alt_id4_no ='"+Old_IC_No1+"'");

	if ( ! PatientId.equals("") )
	Where.append(" and a.patient_id ='"+PatientId+"'");

	if ( ! EncounterId.equals("") )
	Where.append(" and a.encounter_id ='"+EncounterId+"'");

	if ( ! AdmnDateFrom.equals("") )
	Where.append(" and trunc(a.visit_adm_date_time) between  to_date('"+AdmnDateFrom+"','dd/mm/yyyy') and to_date('"+AdmnDateTo+"','dd/mm/yyyy')" );

	if ( ! DischargeDateFrom.equals("") )
	Where.append("and trunc(c.death_date_time) between  to_date('"+DischargeDateFrom+"','dd/mm/yyyy') and to_date('"+DischargeDateTo+"','dd/mm/yyyy')");

	if ( ! PatientClass.equals("") )
	Where.append(" and a.patient_class = '"+PatientClass+"' ");

	if ( ! OrderBy.equals("") )
	{
		if ( OrderBy.equals("ED") )
		{
			Where.append("  ORDER BY visit_adm_date_time ");
		}
		else
 	    if ( OrderBy.equals("ET") )
		{
			Where.append("  ORDER BY location_type ");
		}
	}

	int maxRecord = 0;

	//sql = "SELECT A.ENCOUNTER_ID, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') discharge_date, to_char(A.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') admission_date, A.PATIENT_ID, B.PATIENT_NAME, decode(B.SEX,'M','Male','F','Female','Unknown') sex, a.attend_practitioner_id, to_char(a.deceased_DATE_TIME,'dd/mm/yyyy hh24:mi') deceased_date, decode(a.assign_care_locn_type, 'N','Nursing Unit', 'Clinic') location_type, (case when a.assign_care_locn_type = 'N' then (select short_desc from ip_nursing_unit where facility_id = a.facility_id and nursing_unit_code = a.assign_care_locn_code) else (select short_desc from op_clinic where facility_id = a.facility_id and  clinic_code = a.assign_care_locn_code) end ) location_desc,d.short_desc speciality_name from pr_encounter a, mp_patient b , mr_death_register_hdr c, am_speciality d " + Where.toString(); 

	
	sql = "SELECT A.ENCOUNTER_ID, to_char(A.DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') discharge_date, to_char(A.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') admission_date,A.PATIENT_ID, decode('"+localeName+"', 'en', b.patient_name, Nvl(b.patient_name_loc_lang,b.patient_name)) PATIENT_NAME,B.SEX sex, a.attend_practitioner_id, TO_CHAR (c.death_date_time,      'dd/mm/yyyy hh24:mi') deceased_date, a.assign_care_locn_type location_type,DECODE(a.assign_care_locn_type, 'N', IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,'"+localeName+"','2'), 				OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,'"+localeName+"','1')) location_desc, AM_GET_DESC.AM_SPECIALITY(a.specialty_code,'"+localeName+"','2') speciality_name,c.finalize_yn,a.specialty_code,TO_CHAR (b.date_of_birth, 'dd/mm/yyyy') date_of_birth, (select pract_type from am_practitioner where practitioner_id =  c.auth_practitioner_id) pract_type, a.pat_curr_locn_code from pr_encounter a, mp_patient b , mr_death_register_hdr c " + Where.toString(); 
	
	//stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);	
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	if ( start != 1 )
	{
		 for( int j=1; j<start; i++,j++ )
			  rs.next() ;
	}

	while ( i<=end && rs.next())
	{
		if(maxRecord==0)
		{

	/*if ( (rs != null) )
	{
	   rs.last();
	   maxRecord = rs.getRow();
	   rs.beforeFirst();
	}
	if (maxRecord==0)	
	   out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	else
	{*/
  %>
	<P>
		<table align='right'>
			<tr>
				
				<%
					if ( start > 12) 
						out.println("<td align='right' id='prev'><A HREF='../../eMR/jsp/ViewDeathRegisterResult.jsp?PatientId="+PatientId+"&EncounterId="+EncounterId+"&AdmnDateFrom="+AdmnDateFrom+"&AdmnDateTo="+AdmnDateTo+"&DischargeDateFrom="+DischargeDateFrom+"&DischargeDateTo="+DischargeDateTo+"&PatientClass="+PatientClass+"&NRIC="+NRIC+"&Birth_Cert="+Birth_Cert+"&PMI="+PMI+"&Police_ID="+Police_ID+"&Old_IC_No1="+Old_IC_No1+"&Other_Alt_ID_Type="+Other_Alt_ID_Type+"&Other_Alt_ID_No="+Other_Alt_ID_No+"&OrderBy="+OrderBy+"&from="+(start-12)+"&to="+(end-12)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
					//if ( end < maxRecord )
						out.println("<td align='right'  id='next' style='visibility:hidden'><A HREF='../../eMR/jsp/ViewDeathRegisterResult.jsp?PatientId="+PatientId+"&EncounterId="+EncounterId+"&AdmnDateFrom="+AdmnDateFrom+"&AdmnDateTo="+AdmnDateTo+"&DischargeDateFrom="+DischargeDateFrom+"&DischargeDateTo="+DischargeDateTo+"&PatientClass="+PatientClass+"&NRIC="+NRIC+"&Birth_Cert="+Birth_Cert+"&PMI="+PMI+"&Police_ID="+Police_ID+"&Old_IC_No1="+Old_IC_No1+"&Other_Alt_ID_Type="+Other_Alt_ID_Type+"&Other_Alt_ID_No="+Other_Alt_ID_No+"&OrderBy="+OrderBy+"&from="+(start+12)+"&to="+(end+12)+"' text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
				%>
				
			</tr>
		</table><br>
	</P>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<tr>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.LocationDesc.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td>
			<td class="COLUMNHEADER" nowrap><fmt:message key="eMR.dischargeYN.label" bundle="${mr_labels}"/></td>
			<td class="COLUMNHEADER" nowrap><fmt:message key="Common.DeceasedDate.label" bundle="${common_labels}"/></td>
		</tr>
		<%
		}
		String classValue	 = "";

		//if ( rs != null )
		//{

				/*if ( start != 1 )
				{
					 for( int j=1; j<start; i++,j++ )
					  rs.next() ;
				}*/

				//while ( rs.next() && i<=end )
				//{
					if ( i % 2 == 0 )
						classValue = "QRYEVENSMALL" ;	 
					else
						classValue = "QRYODDSMALL" ;	  
					String EncounterID		= rs.getString(1);				
					String Discharge_Date	= rs.getString(2);
					String VisitAdmDate		= rs.getString(3);
					String PatientID		= rs.getString(4);
					String PatientName		= rs.getString(5);
					String Sex				= rs.getString(6);
					String Practitioner		= rs.getString(7);
					String Deceased_Date		= rs.getString(8);
					String Locntype		= rs.getString(9);
					String Locn_Desc		= rs.getString(10);
					String speciality_name		= rs.getString(11);
					String finalize_yn		= rs.getString(12);
					String speciality_code		= rs.getString(13);
					String date_of_birth		= rs.getString(14);
					String pract_type		= rs.getString(15);
					String pat_curr_locn_code		= rs.getString(16);
	
					if(!(Discharge_Date==null || Discharge_Date.equals("")))
						discharged_yn = "Y";
					else
						discharged_yn = "N";



					if(finalize_yn.equals("") || finalize_yn == null)
					finalize_yn="N";


					if(Sex.equalsIgnoreCase("M"))
						Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if(Sex.equalsIgnoreCase("F"))
						Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else
						Sex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

					if(Locntype.equalsIgnoreCase("C"))
						Locntype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
					else if(Locntype.equalsIgnoreCase("E"))
						Locntype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
					else if(Locntype.equalsIgnoreCase("N"))
						Locntype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
					else if(Locntype.equalsIgnoreCase("Y"))
						Locntype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
				
					if (EncounterID==null	|| EncounterID.equals("null"))		EncounterID = "";

					String VisitAdmDate_display = "";
					if (VisitAdmDate==null	|| VisitAdmDate.equals("null"))
					{
						VisitAdmDate = "&nbsp;";
						VisitAdmDate_display = "&nbsp;";
					}
					else
						VisitAdmDate_display = DateUtils.convertDate(VisitAdmDate,"DMYHM","en",locale);

					if (DischargeDateTo==null	|| DischargeDateTo.equals("null"))	DischargeDateTo = "&nbsp;";
					
					String Deceased_Date_display = "";
					if (Deceased_Date==null	|| Deceased_Date.equals("null"))
					{
						Deceased_Date = "&nbsp;";
						Deceased_Date_display = "&nbsp;";
					}
					else
						Deceased_Date_display = DateUtils.convertDate(Deceased_Date,"DMYHM","en",locale);
				
					if (PatientName==null	|| PatientName.equals("null"))		PatientName = "&nbsp;";
					if (Sex==null			|| Sex.equals("null"))				Sex = "&nbsp;";
					if (Practitioner==null	|| Practitioner.equals("null"))		Practitioner = "";
					if (Locntype==null	|| Locntype.equals("null"))		Locntype = "";
					if (Locn_Desc==null	|| Locn_Desc.equals("null"))		Locn_Desc = "";
					if (speciality_name==null	|| speciality_name.equals("null"))		speciality_name = "";
					if (speciality_code==null	|| speciality_code.equals("null"))speciality_code = "";
					if (date_of_birth==null	|| date_of_birth.equals("null"))date_of_birth = "";
					if (pract_type==null	|| pract_type.equals("null"))pract_type = "";
					if (pat_curr_locn_code==null	|| pat_curr_locn_code.equals("null"))pat_curr_locn_code = "";

					String Discharge_Date_display = "";					
					if (Discharge_Date==null	|| Discharge_Date.equals("null"))
					{
						Discharge_Date = "";
						Discharge_Date_display = "&nbsp;";
					}
					else
						Discharge_Date_display = DateUtils.convertDate(Discharge_Date,"DMYHM","en",locale);

			if(finalize_yn.equals("Y"))
			{
					finalize_status = "Finalized";

					if(maintain_death_register_yn.equals("Y"))
					{
						out.println("<tr><td align='left' class='"+classValue+"' style='font-weight:normal;background-color:white'>");
					
						out.println("<a href=javascript:call_death_reg('"+EncounterID+"','"+PatientID+"','"+Practitioner+"','"+PatientClass+"','"+speciality_code+"','"+Sex+"','"+date_of_birth+"','"+pract_type+"','"+pat_curr_locn_code+"','"+finalize_yn+"','"+java.net.URLEncoder.encode(VisitAdmDate)+"')>"+PatientID+"</a>");

					}
					else
					{
						out.println("<tr><td align='left' class='"+classValue+"' style='font-weight:normal;background-color:white'>"+PatientID);

					}
					out.println("</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+PatientName+"</td>");			
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+Sex+"</td>");	
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+finalize_status+"</td>");			
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+EncounterID+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+VisitAdmDate_display+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+Locntype+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>"+Locn_Desc+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>" +Discharge_Date_display+"</td>");
					out.println("<td align='center' class='"+classValue+"' style='font-weight:normal;background-color:white;text-align:center;'>" +discharged_yn+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:white'>" +Deceased_Date_display+"</td>");
					out.println("</tr>");
			}
			else
			{
				finalize_status = "Recorded";
					if(maintain_death_register_yn.equals("Y"))
					{
					
					out.println("<tr><td align='left' class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>");
					out.println("<a href=javascript:call_death_reg('"+EncounterID+"','"+PatientID+"','"+Practitioner+"','"+PatientClass+"','"+speciality_code+"','"+Sex+"','"+date_of_birth+"','"+pract_type+"','"+pat_curr_locn_code+"','"+finalize_yn+"','"+java.net.URLEncoder.encode(VisitAdmDate)+"')>"+PatientID+"</a>");
					}
					else
					{
						out.println("<tr><td align='left' class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+PatientID);	

					}
					out.println("</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+PatientName+"</td>");		
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+Sex+"</td>");			
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+finalize_status+"</td>");	
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+EncounterID+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+VisitAdmDate_display+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+Locntype+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>"+Locn_Desc+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>" +Discharge_Date_display+"</td>");
					out.println("<td align='center' class='"+classValue+"' style='font-weight:normal;background-color:lightblue;text-align:center;'>" +discharged_yn+"</td>");
					out.println("<td nowrap class='"+classValue+"' style='font-weight:normal;background-color:lightblue'>" +Deceased_Date_display+"</td>");
					out.println("</tr>");

			}
					i++;
					maxRecord++;
	}
			//}
	%>
	</table>
<br>
</form>
</body>
</html>
	<%
				if (maxRecord==0)	
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
				if(maxRecord<12 || (!rs.next()) )
				{%>
					<script>
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='hidden';
					</script>
				<%}
				else
				{%>
					<script>
						if (document.getElementById("next"))
							document.getElementById("next").style.visibility='visible';
					</script>
				<%}
	
	//}
}
catch ( Exception e )
{
	e.printStackTrace();
}
finally
{
	out.println("<script>parent.frames[1].document.forms[0].search.disabled=false;</script>");
	try
	{
		if ( stmt != null ) stmt.close() ;
		if ( rs != null ) rs.close() ;
	}
	catch(Exception e)
	{
	}
	ConnectionManager.returnConnection(conn,request);
}
%>

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

