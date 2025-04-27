<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>     
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>

<% 
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String fac_id		= (String) session.getValue( "facility_id" ) ;
		String locale = (String)session.getAttribute("LOCALE");
		StringBuffer sql=new StringBuffer("") ;
		String web_request_yn="N";
		String patientid	=   request.getParameter("patientid")== null?"":request.getParameter("patientid");
		String practitioner	=   request.getParameter("practitioner")== null?"":request.getParameter("practitioner");
		
		
		String rd_appt_yn	=	request.getParameter("rd_appt_yn")== null?"N":request.getParameter("rd_appt_yn");
		String WaitListNo	=	request.getParameter("WaitListNo")== null?"":request.getParameter("WaitListNo");
		String patientname	=	request.getParameter("patientname")== null?"":request.getParameter("patientname");
		String cliniccode	=	request.getParameter("cliniccode")== null?"":request.getParameter("cliniccode");
		String practcode	=	request.getParameter("practcode")== null?"":request.getParameter("practcode");
		String gender		=	request.getParameter("gender")== null?"":request.getParameter("gender");
		String waitListfrmdate	=	request.getParameter("waitListfrmdate")== null?"":request.getParameter("waitListfrmdate");
		String waitListTodate	=	request.getParameter("waitListTodate") == null?"":request.getParameter("waitListTodate");
		String stylSetter="";
		String patient_name_yn="N";		
		waitListfrmdate=DateUtils.convertDate(waitListfrmdate,"DMY",locale,"en");
		waitListTodate=DateUtils.convertDate(waitListTodate,"DMY",locale,"en");
		
		String clinic_type=	request.getParameter("clinic_type") == null?"":request.getParameter("clinic_type");
		String res_type=	request.getParameter("res_type") == null?"":request.getParameter("res_type");
		String specCode=	request.getParameter("specCode") == null?"":request.getParameter("specCode");
	//	String frmClinicCode=	request.getParameter("frmClinicCode") == null?"":request.getParameter("frmClinicCode");
	//	out.println("cliniccode--->"+cliniccode);
		String elapsed=request.getParameter("elaspsed")==null?"":request.getParameter("elaspsed");
		String oper_stn_id=request.getParameter("oper_stn_id")==null?"":request.getParameter("oper_stn_id");
		String ALCN_CRITERIA_YN=request.getParameter("ALCN_CRITERIA_YN");
		if(ALCN_CRITERIA_YN ==null) ALCN_CRITERIA_YN="";
		String elapsed_grace_period=request.getParameter("elapsed_grace_period");
		if(elapsed_grace_period ==null) elapsed_grace_period="";
		String nat_id_no=request.getParameter("nat_id_no");
		if(nat_id_no ==null) nat_id_no="";
		String alt_id1_no=request.getParameter("alt_id1_no");
		if(alt_id1_no ==null) alt_id1_no="";
		String alt_id1_type=request.getParameter("alt_id1_type");
		if(alt_id1_type ==null) alt_id1_type="";
		String alt_id2_no=request.getParameter("alt_id2_no");
		if(alt_id2_no ==null) alt_id2_no="";
		String alt_id2_type=request.getParameter("alt_id2_type");
		if(alt_id2_type ==null) alt_id2_type="";
		String alt_id3_no=request.getParameter("alt_id3_no");
		if(alt_id3_no ==null) alt_id3_no="";
		String alt_id3_type=request.getParameter("alt_id3_type");
		if(alt_id3_type ==null) alt_id3_type="";
		String alt_id4_no=request.getParameter("alt_id4_no");
		if(alt_id4_no ==null) alt_id4_no="";
		String alt_id4_type=request.getParameter("alt_id4_type");
		if(alt_id4_type ==null) alt_id4_type="";
		String other_alt_Id=request.getParameter("other_alt_Id");
		if(other_alt_Id ==null) other_alt_Id="";
		String other_alt_type=request.getParameter("other_alt_type");
		if(other_alt_type ==null) other_alt_type="";

		String nat_id_code=request.getParameter("nat_id_code");
		if(nat_id_code ==null) nat_id_code="";
		String r_area_code=request.getParameter("r_area");
		if(r_area_code ==null) r_area_code="";
		String m_area_code=request.getParameter("m_area");
		if(m_area_code ==null) m_area_code="";
		String r_region_code=request.getParameter("r_region");
		if(r_region_code ==null) r_region_code="";
		String m_region_code=request.getParameter("m_region");
		if(m_region_code ==null) m_region_code="";
		String r_town_code=request.getParameter("r_town");
		if(r_town_code ==null) r_town_code="";
		String m_town_code=request.getParameter("m_town");
		if(m_town_code ==null) m_town_code="";
		String wtlt_category=request.getParameter("wtlt_category");
		if(wtlt_category ==null) wtlt_category="";
		
		String wtlt_category_one=request.getParameter("wtlt_category_one");
		if(wtlt_category_one ==null) wtlt_category_one="";

		String priority1=request.getParameter("priority");
		if(priority1==null)priority1="";
		
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String classValue	 = "";
		String waitListNo="";
		String priority="";
		String patientId="";
		String patientName="";
		String preferedDate="";
		String preferedDate_disp="";
		String specialityDesc="";
		String locationDesc="";
		//String resourceClass="";
		//String res_class_desc="";
		String resource="";
		String clinicDesc="";
		String careLocnTypeInd="";
		String clinicCode="";
		String resourceId="";
		String specialityCode="";
		String resClass="";
		String SPECIALITY_DESC="";
		String WAITLIST_CAT_DESC="";
		String reason_for_modify="";
		String wait_list_ref_no="";
		String rd_waitlist_yn="";
		String order_catalog_code="";
		//String	start_index	= "";	
		//String end_index =	"";
		//start_index		=	(request.getParameter("start_index")==null)		?	"0"		:	request.getParameter("start_index");
		//end_index		=	(request.getParameter("end_index")==null)		?	"11"	:	request.getParameter("end_index");
		
		/*added for Bru-HIMS-CRF-173*/
		String wtListControl = request.getParameter("wtListControl")==null?"":request.getParameter("wtListControl");
		
		

		if (!patientName.equals(""))
		{
			patientName		= 	patientName + "%" ;
		}
	int start = 0 ;
	int end = 0 ;
int s=1;
	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 15 ;
	else
		end = Integer.parseInt( to ) ;



		String req_start = "", req_end = "";
		Statement stmt				= null;
		ResultSet rs				= null;
		Connection conn=null;
		Statement st=null;
		ResultSet rsSet=null;

		req_start       =   (request.getParameter("start")==null)?"0" :   request.getParameter("start");
		req_end         =   (request.getParameter("end")==null)?"0" :   request.getParameter("end");
	%>
	<HTML>
	<head>
		<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
		<script src="../../eOA/js/QueryLocnForDay.js"></script>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
		 -->
		 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eOA/js/WaitListMgmt.js' language='javascript'></script>
		</head>

		
		<%
try
{
			conn = ConnectionManager.getConnection(request);

			stmt	 = conn.createStatement();			
			//StringBuffer sql2 = new StringBuffer();
			StringBuffer sql3 = new StringBuffer();
			//String sqlmain="";
			StringBuffer sqlmain2= new StringBuffer();
			int i=0;	
			if(elapsed ==null) elapsed="N";
			//commented the following linfg code as it was developed for web request demo  
			/*Below Query Modified for this [35078]*/
			/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
			//sql.append("select nvl(WAIT_LIST_NO,'') wait_list_no, decode(WAIT_LIST_PRIORITY,'U','Urgent','S','Semi Urgent','N','Normal') priority , nvl(PATIENT_ID,'') patient_id,  to_char(PREFERRED_DATE_TIME,'dd/mm/yyyy') pref_date_time , nvl(SPECIALTY_CODE,'') spec_desc, nvl(AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id='"+fac_id+"' and CLINIC_CODE=locn_code),'"+locale+"','1'), '') locn_desc , nvl(RESOURCE_CLASS,'') resc_class, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(resource_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, resource_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2')) PRACTITIONER_SHORT_NAME, (decode(care_locn_type_ind, 'N', (IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, locn_code,'"+locale+"','2')))), OP_GET_DESC.OP_CLINIC(FACILITY_ID, locn_code, '"+locale+"','1') CLINIC_SHORT_DESC, SPECIALTY_CODE, care_locn_type_ind, locn_code clinic_code, resource_id PRACTITIONER_ID, resource_class, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') SPECIALITY_DESC, (CASE WHEN pr_wait_list.waitlist_category_code IS NOT NULL THEN (SELECT long_desc FROM oa_waitlist_category_lang_vw WHERE waitlist_category_code = pr_wait_list.waitlist_category_code and language_id = '"+locale+"') END) WAITLIST_CAT_DESC, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,AM_GET_DESC.AM_CONTACT_REASON(REASON_FOR_MODIFY,'"+locale+"','1')  REASON_FOR_MODIFY,wait_list_ref_no,rd_waitlist_yn,order_catalog_code  from pr_wait_list where facility_id = '"+fac_id+"'  and wait_list_status='O'");
			
			/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
			sql.append("SELECT wait_list_no, priority,patient_id, pref_date_time, spec_desc, locn_desc, resc_class, practitioner_short_name, clinic_short_desc,specialty_code, care_locn_type_ind, clinic_code, practitioner_id,resource_class, speciality_desc, waitlist_cat_desc, patient_name, reason_for_modify, wait_list_ref_no, rd_waitlist_yn, order_catalog_code, eff_status FROM (select nvl(WAIT_LIST_NO,'') wait_list_no, decode(WAIT_LIST_PRIORITY,'U','Urgent','S','Semi Urgent','N','Normal') priority , nvl(PATIENT_ID,'') patient_id,  to_char(PREFERRED_DATE_TIME,'dd/mm/yyyy') pref_date_time , nvl(SPECIALTY_CODE,'') spec_desc, nvl(AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id='"+fac_id+"' and CLINIC_CODE=locn_code),'"+locale+"','1'), '') locn_desc , nvl(RESOURCE_CLASS,'') resc_class, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(resource_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, resource_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2')) PRACTITIONER_SHORT_NAME, (decode(care_locn_type_ind, 'N', (IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, locn_code,'"+locale+"','2')))), OP_GET_DESC.OP_CLINIC(FACILITY_ID, locn_code, '"+locale+"','1') CLINIC_SHORT_DESC, SPECIALTY_CODE, care_locn_type_ind, locn_code clinic_code, resource_id PRACTITIONER_ID, resource_class, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') SPECIALITY_DESC, (CASE WHEN pr_wait_list.waitlist_category_code IS NOT NULL THEN (SELECT long_desc FROM oa_waitlist_category_lang_vw WHERE waitlist_category_code = pr_wait_list.waitlist_category_code and language_id = '"+locale+"') END) WAITLIST_CAT_DESC, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,AM_GET_DESC.AM_CONTACT_REASON(REASON_FOR_MODIFY,'"+locale+"','1')  REASON_FOR_MODIFY,wait_list_ref_no,rd_waitlist_yn,order_catalog_code ,(CASE WHEN (    pr_wait_list.resource_class = 'P'AND pr_wait_list.resource_id IS NOT NULL)  THEN (SELECT eff_status FROM am_practitioner   WHERE practitioner_id =  pr_wait_list.resource_id)   WHEN (    pr_wait_list.resource_class = 'R'  AND pr_wait_list.resource_id IS NOT NULL   ) THEN (SELECT eff_status   FROM am_facility_room  WHERE operating_facility_id =  pr_wait_list.facility_id  AND room_num = pr_wait_list.resource_id)  WHEN (    pr_wait_list.resource_class = 'E' AND pr_wait_list.resource_id IS NOT NULL ) THEN (SELECT eff_status FROM am_resource WHERE facility_id = pr_wait_list.facility_id AND resource_class = 'E' AND resource_id = pr_wait_list.resource_id) WHEN (    pr_wait_list.resource_class = 'O' AND pr_wait_list.resource_id IS NOT NULL ) THEN (SELECT eff_status FROM am_resource WHERE facility_id = pr_wait_list.facility_id AND resource_class = 'O' AND resource_id = pr_wait_list.resource_id) END ) eff_status   from pr_wait_list where facility_id = '"+fac_id+"'  and wait_list_status='O'");
			
			//sql.append("select nvl(WAIT_LIST_NO,'') wait_list_no, decode(WAIT_LIST_PRIORITY,'U','Urgent','S','Semi Urgent','N','Normal') priority , nvl(PATIENT_ID,'') patient_id,  to_char(PREFERRED_DATE_TIME,'dd/mm/yyyy') pref_date_time , nvl(SPECIALTY_CODE,'') spec_desc, nvl(AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_IND,'"+locale+"','1'), '') locn_desc , nvl(RESOURCE_CLASS,'') resc_class, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(resource_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, resource_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, resource_id,'"+locale+"','2')) PRACTITIONER_SHORT_NAME, (decode(care_locn_type_ind, 'N', (IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, locn_code,'"+locale+"','2')))), OP_GET_DESC.OP_CLINIC(FACILITY_ID, locn_code, '"+locale+"','1') CLINIC_SHORT_DESC, SPECIALTY_CODE, care_locn_type_ind, locn_code clinic_code, resource_id PRACTITIONER_ID, resource_class, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') SPECIALITY_DESC, (CASE WHEN pr_wait_list.waitlist_category_code IS NOT NULL THEN (SELECT long_desc FROM oa_waitlist_category_lang_vw WHERE waitlist_category_code = pr_wait_list.waitlist_category_code and language_id = '"+locale+"') END) WAITLIST_CAT_DESC, decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,AM_GET_DESC.AM_CONTACT_REASON(REASON_FOR_MODIFY,'"+locale+"','1')  REASON_FOR_MODIFY  from pr_wait_list where facility_id = '"+fac_id+"'  and wait_list_status='O'");

				
			if (elapsed.equals("N")){
				sql.append(" and ( trunc(PREFERRED_DATE_TIME)>=trunc(sysdate)  or trunc(PREFERRED_DATE_TIME) is null ) ");
			}else if (elapsed.equals("Y")){
				sql.append(" and ( trunc(PREFERRED_DATE_TIME) between (sysdate- "+elapsed_grace_period+") and (sysdate)  or trunc(PREFERRED_DATE_TIME) is null )");
			}

			if (!specCode.equals("")) 
				sql3=sql3.append(" and SPECIALTY_CODE='"+specCode+"'");
				
			if(cliniccode.equals("") && wtListControl.equals("")) res_type="";

			if (!clinic_type.equals("")) 
			sql3.append(" and CARE_LOCN_TYPE_IND='"+clinic_type+"'");
			if(clinic_type.equals("") && !wtListControl.equals(""))
				sql3.append(" and CARE_LOCN_TYPE_IND !='N'");

			if (!cliniccode.equals("")) 
				sql3.append(" and NVL(LOCN_CODE,'*')='"+cliniccode+"'");

			if (!res_type.equals("")) 
				sql3.append(" and resource_class='"+res_type+"'");
				
			if(!priority1.equals(""))
				sql3.append(" and WAIT_LIST_PRIORITY='"+priority1+"'");

			if (!practcode.equals("")) 
				sql3.append(" and NVL(RESOURCE_ID,'*')='"+practcode+"'");

			if (!gender.equals(""))  
				sql3.append(" and gender='"+gender+"'");

             if (!practitioner.equals(""))  
				sql3.append(" and resource_id='"+practitioner+"'");


			if (!WaitListNo.equals("")) 
				sql3=sql3.append(" and WAIT_LIST_NO='"+WaitListNo+"'");

			/*if (!resource1.equals("")) 
				sql3=sql3.append(" and PRACTITIONER_SHORT_NAME='"+resource1+"'");*/

			if (!patientid.equals(""))  
				sql3.append(" and patient_id='"+patientid+"'");

			if (!patientname.equals(""))
				{
				
				sql3.append(" and UPPER(patient_name) like upper('"+patientname+"%')");
					
				}
			if (!waitListfrmdate.equals("")) 
				sql3.append("  and trunc(preferred_date_time)>=to_date('"+waitListfrmdate+"','dd/mm/yyyy')");

			if (!waitListTodate.equals(""))  
				sql3.append(" and trunc(preferred_date_time)<=to_date('"+waitListTodate+"','dd/mm/yyyy')");

			if (!nat_id_no.equals(""))
				sql3.append(" and NATIONAL_ID_NO='"+nat_id_no+"'");

			if (!alt_id1_no.equals(""))
				sql3.append(" and ALT_ID1_NO='"+alt_id1_no+"'");

			if (!alt_id1_type.equals(""))
				sql3.append(" and ALT_ID1_TYPE='"+alt_id1_type+"'");

			if (!alt_id2_no.equals(""))
				sql3.append(" and ALT_ID2_NO='"+alt_id2_no+"'");

			if (!alt_id2_type.equals(""))
				sql3.append(" and ALT_ID2_TYPE='"+alt_id2_type+"'");

			if (!alt_id3_no.equals(""))
				sql3.append(" and ALT_ID3_NO='"+alt_id3_no+"'");

			if (!alt_id3_type.equals(""))
				sql3.append(" and ALT_ID3_TYPE='"+alt_id3_type+"'");

			if (!alt_id4_no.equals("") )
				sql3.append(" and ALT_ID4_NO='"+alt_id4_no+"'");

			if (!alt_id4_type.equals("") )
				sql3.append(" and ALT_ID4_TYPE='"+alt_id4_type+"'");
			
			if (!other_alt_Id.equals(""))
				sql3.append(" and OTH_ALT_ID_NO='"+other_alt_Id+"'");
			
			if (!other_alt_type.equals(""))
				sql3.append(" and OTH_ALT_ID_TYPE='"+other_alt_type+"'");

			if	(!nat_id_code.equals(""))
				sql3.append(" and NATIONALITY_CODE ='"+nat_id_code+"'");

			if	(!r_area_code.equals(""))
				sql3.append(" and RES_AREA_CODE ='"+r_area_code+"'");

			if	(!m_area_code.equals(""))
				sql3.append(" and MAIL_AREA_CODE ='"+m_area_code+"'");

			if	(!r_town_code.equals(""))
				sql3.append(" and RES_TOWN_CODE ='"+r_town_code+"'");

			if	(!m_town_code.equals(""))
				sql3.append(" and MAIL_TOWN_CODE ='"+m_town_code+"'");

			if	(!r_region_code.equals(""))
				sql3.append(" and RES_REGION_CODE ='"+r_region_code+"'");

			if	(!m_region_code.equals(""))
				sql3.append(" and MAIL_REGION_CODE ='"+m_region_code+"'");

			if(!wtlt_category.equals(""))
				sql3.append("and ORDER_CATALOG_CODE='"+wtlt_category+"'");

			if(!wtlt_category_one.equals(""))
				sql3.append(" and WAITLIST_CATEGORY_CODE='"+wtlt_category_one+"'");

				sqlmain2.append(sql.toString()+sql3.toString());
				sql3.setLength(0);
				sql.setLength(0);
				/*Below query commented by venkatesh against GHL-SCF-992  on 18-02-2016 */
				//sqlmain2.append(" ORDER BY WAIT_LIST_PRIORITY DESC ,PREFERRED_DATE_TIME,to_number(WAIT_LIST_NO)");
				/* Below query Modified by venkatesh against GHL-SCF-992 on 18-02-2016 */
				sqlmain2.append(" ORDER BY WAIT_LIST_PRIORITY DESC ,PREFERRED_DATE_TIME,to_number(WAIT_LIST_NO))  WHERE (eff_status != 'D' OR eff_status IS NULL) ORDER BY priority DESC, pref_date_time, TO_NUMBER (wait_list_no) ");
				
				rs 	= stmt.executeQuery(sqlmain2.toString());
				sqlmain2.setLength(0);


		
		%>
					<body OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()' onscroll='scrollTitle()' >
		<form name='QueryApptForPatient' id='QueryApptForPatient'>
			<input type=hidden name='from' id='from' value='<%=start%>'>
						<input type=hidden name='to' id='to' value='<%=end%>'>
						<input type=hidden name='start' id='start' value='<%=start%>'>
						<input type=hidden name='end' id='end' value='<%=end%>'>

			<%
				int rowcolor=0;
				if ( start != 1 )
				for( int j=1; j<start; s++,j++ )
				{
					rs.next() ;
				}
				if(rs != null)
				{
					while ( s<=end && rs.next())
					{
						if(i==0)
						{
						%>

	<table width='90%' border=0 align='center' >
		<tr>
		<td align='right' class='NONURGENT'>
		<%
		if ( !(start <= 1)) {
	%>
		<a href='javascript:submitPrevNext(<%=(start-15)%>,<%=(end-15)%>)' id='prev' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<input type=hidden name='whichPage' id='whichPage' value='prev'>
	<%
		}
	//	if ( !((start+15) > i ))
			{
	%>
		<a href='javascript:submitPrevNext(<%=(start+15)%>,<%=(end+15)%>)' id='next' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a><input type=hidden name='whichPage' id='whichPage' value='next'>
	<%
		}
	%>
		
	</td>
	 </tr>
		</table>

		
		<table border="1" width="150%" bgColor=white cellspacing='0' cellpadding='0' id='tb3'>
				<td class="COLUMNHEADER" width='8%'><div  id='head1'  class='myClass' nowrap ><fmt:message key="Common.waitlistno.label" bundle="${common_labels}"/></div></td>
				<td class="COLUMNHEADER" width='12%'><div  id='head2'  class='myClass' nowrap ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></div></td>
				<td class="COLUMNHEADER" width='17%'><div  id='head3'  class='myClass' nowrap ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></div></td>
				<td class="COLUMNHEADER" width='13%'><div  id='head4'  class='myClass' nowrap ><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/></div></td>

				<td class="COLUMNHEADER" width='13%'><div  id='head11'  class='myClass' nowrap ><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/></div></td>

				<td class="COLUMNHEADER" width='10%'><div  id='head5'  class='myClass' nowrap ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></div></td>
				<td class="COLUMNHEADER" width='16%'><div  id='head6'  class='myClass' nowrap ><fmt:message key="Common.category1.label" bundle="${common_labels}"/></div></td>
				<td class="COLUMNHEADER" width='15%'><div  id='head7'  class='myClass' nowrap ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></div></td>
				<td class="COLUMNHEADER" width='30%'><div  id='head8'  class='myClass' nowrap ><fmt:message key="Common.resource.label" bundle="${common_labels}"/></div></td>
				<td class='COLUMNHEADER' nowrap width='13%'><div  id='head9'  class='myClass' nowrap ><fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/></div></td>
				<td class="COLUMNHEADER" width='30%'><div  id='head10'  class='myClass' nowrap ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></div></td>
		
					
				<% }
				
			
						waitListNo =rs.getString("wait_list_no");
						priority = rs.getString("priority");	
						patientId = rs.getString("patient_id");	
					
						patientName	=rs.getString("patient_name");	
						if(patientName==null || patientName.equals("")){
							patient_name_yn="N";
						}else{
							patient_name_yn="Y";
						}
					
						preferedDate =rs.getString("pref_date_time")	;

						preferedDate_disp=DateUtils.convertDate(preferedDate,"DMY","en",locale);

						specialityDesc	=rs.getString("spec_desc")	;
						locationDesc =rs.getString("locn_desc"); 
						String resourceClass=rs.getString("resc_class"); 
						if(resourceClass ==null) resourceClass="";
							
							String res_class_desc="";
						if(resourceClass.equals("P"))
						{
						res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
						}else if(resourceClass.equals("E"))
						{
						res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
						}else if(resourceClass.equals("R"))
						{
						 res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
						}else if(resourceClass.equals("O"))
						{
						res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
						}

						resource =rs.getString("PRACTITIONER_SHORT_NAME");
						if (resource==null) resource="";
						//out.println("resource==="+resource);
                        
						clinicDesc=rs.getString("CLINIC_SHORT_DESC");
						specialityCode=rs.getString("SPECIALTY_CODE");
						careLocnTypeInd=rs.getString("care_locn_type_ind");
						clinicCode=rs.getString("clinic_code");
						resourceId=rs.getString("PRACTITIONER_ID");
						resClass=rs.getString("resource_class");
						SPECIALITY_DESC=rs.getString("SPECIALITY_DESC");
						//out.println("SPECIALITY_DESC=="+SPECIALITY_DESC);
						reason_for_modify=rs.getString("REASON_FOR_MODIFY");
						if(reason_for_modify ==null)	 reason_for_modify="";
						WAITLIST_CAT_DESC=rs.getString("WAITLIST_CAT_DESC");
						//commented the following linfg code as it was developed for web request demo
						//web_request_yn=rs.getString("web_request_yn");
						if (waitListNo==null) waitListNo="";
						if (priority==null) priority="";
						if (patientId==null) patientId="";
						if (patientName==null) 
							patientName="";
						else
						if (patientName.length() >= 25) patientName=patientName.substring(0,25);
						
						if (locationDesc==null) locationDesc="";
						if (resourceClass==null) resourceClass="";
						if (res_class_desc ==null) res_class_desc="";
						if (preferedDate==null) preferedDate ="";
						if (specialityDesc==null) specialityDesc="";
						
						if (clinicDesc==null) clinicDesc="";
						if (careLocnTypeInd==null) careLocnTypeInd="";
						if (clinicCode==null) clinicCode="";
						if (resourceId==null) resourceId="";
						//out.println("resourceId=="+resourceId);
						if (specialityCode==null) specialityCode="";
						if (resClass==null) resClass="";
						if (WAITLIST_CAT_DESC ==null) WAITLIST_CAT_DESC="";

						wait_list_ref_no=rs.getString("wait_list_ref_no");
						if(wait_list_ref_no ==null)	 wait_list_ref_no="";
						rd_waitlist_yn = rs.getString("rd_waitlist_yn")==null?"N":rs.getString("rd_waitlist_yn");
						order_catalog_code = rs.getString("order_catalog_code")==null?"":rs.getString("order_catalog_code");
						
						if ( rowcolor % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
						if(web_request_yn.equals("Y")){
							stylSetter="style='BackGround-color:yellow'";
						}else{
							stylSetter="";
						}
						%>
							
					<tr >
					
					<%	/*changed for Bru-HIMS-CRF-173 starts*/
						if (elapsed.equals("N")&& (wtListControl.equals("") ||wtListControl.equals("B"))){System.err.println("rad_appt_yn--111-->"+rd_appt_yn);%>

						<td class='<%=classValue%>' id="<%=waitListNo%>"  onMouseOver='hideToolTip("<%=waitListNo%>")' width='8%' onClick="displayToolTip('<%=waitListNo%>','<%=patientId%>','<%=preferedDate%>',	'<%=res_class_desc%>','<%=java.net.URLEncoder.encode(resource)%>','<%=careLocnTypeInd%>','<%=clinicCode%>','<%=resourceId%>','<%=specialityCode%>','<%=resClass%>','<%=order_catalog_code%>','<%=web_request_yn%>','<%=patient_name_yn%>','<%=rd_waitlist_yn%>')" <%=stylSetter%>> 
						<a href="javascript:callDummy()"><%=waitListNo%></a>&nbsp;</td>	
							
					<%}else if (elapsed.equals("Y") && (wtListControl.equals("") ||wtListControl.equals("B"))){System.err.println("rad_appt_yn--222-->"+rd_appt_yn);%>

						<td class='<%=classValue%>' width='8%'><a href="javascript:show_ModifyWin('<%=waitListNo%>','Y')"><%=waitListNo%></a></td>
					<%}else if(!wtListControl.equals("") && wtListControl.equals("B")){%>
						<td class='<%=classValue%>' id="<%=waitListNo%>"  onMouseOver='hideToolTip("<%=waitListNo%>")' width='8%' onClick="displayToolTip('<%=waitListNo%>','<%=patientId%>','<%=preferedDate%>',	'<%=res_class_desc%>','<%=java.net.URLEncoder.encode(resource)%>','<%=careLocnTypeInd%>','<%=clinicCode%>','<%=resourceId%>','<%=specialityCode%>','<%=resClass%>','<%=order_catalog_code%>','<%=web_request_yn%>','<%=patient_name_yn%>')"<%=stylSetter%>><a href="javascript:callDummy()"><%=waitListNo%></a>&nbsp;
						</td>
					<%}else if(!wtListControl.equals("") && wtListControl.equals("V")){%>
						<td class='<%=classValue%>' width='8%'><%=waitListNo%></td>
					<%}/*changed for Bru-HIMS-CRF-173 Ends*/%>

					<td class="<%=classValue%>"  onClick='hideToolTip()' width='12%'><%=patientId%>&nbsp;</td>
					<td class="<%=classValue%>"   width='17%'>
					<%=patientName%>&nbsp;</td>
					<td class="<%=classValue%>"  width='13%' nowrap><%=preferedDate_disp%>&nbsp;&nbsp;</td>
                    <td class="<%=classValue%>"  width='13%' nowrap><%=wait_list_ref_no%>&nbsp;</td>
					<td class="<%=classValue%>"  width='10%' nowrap><%=SPECIALITY_DESC%>&nbsp;</td>
					<td class="<%=classValue%>"  width='16%' nowrap><%=WAITLIST_CAT_DESC%>&nbsp;</td>
					<%if(clinicDesc.length() >1) {%>

						<td  class='<%=classValue%>'  width='15%' nowrap><%=locationDesc%>/<%=clinicDesc%>&nbsp;</td>

					<%}else{%>

						<td  class='<%=classValue%>'  width='15%' nowrap><%=locationDesc%>&nbsp;</td>

					<%}%>


					<%if(resource.length() >1) {%>

						<td  class='<%=classValue%>'  width='30%' nowrap><%=res_class_desc%>/<%=resource%>&nbsp;</td>

					<%}else{%>

						<td  class='<%=classValue%>'  width='30%' nowrap><%=res_class_desc%>&nbsp;</td>

					<%}%>
					<%if(!patientId.equals("")){%>
					<td class='<%=classValue%>'  onClick='hideToolTip()' width='13%' ><a href='javascript:onclick=past_visits_view("<%=patientId%>")'><fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/></a></td>
					<%}else{%>
					<td class='<%=classValue%>'  width='13%' nowrap>&nbsp;</td>
					<%}%>
					<td  class='<%=classValue%>'  width='30%' nowrap><%=reason_for_modify%>&nbsp;</td>
						
					</tr>
					<%
					rowcolor++;
					s++;
					i++;
				}//while loop
		}//if

		if(i == 0)
		{%>
			<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			parent.frames[3].location.href='../../eCommon/html/blank.html';</script>
		<%}

		if ( i < 15 || (!rs.next()) ) {
		%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='hidden';
			</script>
		<% 
				} else {%>
			<script >
			if (document.getElementById("next"))
				document.getElementById("next").style.visibility='visible';
			</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<%}


		%>
			<input type='hidden' name='oper_stn_id' id='oper_stn_id' value='<%=oper_stn_id%>'>
			<input type='hidden' name='ALCN_CRITERIA_YN' id='ALCN_CRITERIA_YN' value='<%=ALCN_CRITERIA_YN%>'>
			<input type='hidden' name='specCode' id='specCode' value='<%=specCode%>'>
			<input type=hidden name='elaspsed' id='elaspsed' value='<%=elapsed%>'>
			<input type=hidden name='cliniccode' id='cliniccode' value='<%=cliniccode%>'>
			<input type=hidden name='practcode' id='practcode' value='<%=practcode%>'>
			<input type=hidden name='waitListfrmdate' id='waitListfrmdate' value='<%=waitListfrmdate%>'>
			<input type=hidden name='waitListTodate' id='waitListTodate' value='<%=waitListTodate%>'>
			<input type=hidden name='clinic_type' id='clinic_type' value='<%=clinic_type%>'>
			<input type=hidden name='res_type' id='res_type' value='<%=res_type%>'>
			<input type=hidden name='elapsed_grace_period' id='elapsed_grace_period' value='<%=elapsed_grace_period%>'>
			<input type=hidden name='wtlt_category' id='wtlt_category' value='<%=wtlt_category%>'>
			<input type=hidden name='wtlt_category_one' id='wtlt_category_one' value='<%=wtlt_category_one%>'>
			<input type=hidden name='nat_id_no' id='nat_id_no' value="<%=nat_id_no%>">
			<input type=hidden name='alt_id1_no' id='alt_id1_no' value="<%=alt_id1_no%>">
			<input type=hidden name='alt_id1_type' id='alt_id1_type' value="<%=alt_id1_type%>">
			<input type=hidden name='alt_id2_no' id='alt_id2_no' value="<%=alt_id2_no%>">
			<input type=hidden name='alt_id2_type' id='alt_id2_type' value="<%=alt_id2_type%>">
			<input type=hidden name='alt_id3_no' id='alt_id3_no' value="<%=alt_id3_no%>">
			<input type=hidden name='alt_id3_type' id='alt_id3_type' value="<%=alt_id3_type%>">
			<input type=hidden name='alt_id4_no' id='alt_id4_no' value="<%=alt_id4_no%>">
			<input type=hidden name='alt_id4_type' id='alt_id4_type' value="<%=alt_id4_type%>">
			<input type=hidden name='other_alt_Id' id='other_alt_Id' value="<%=other_alt_Id%>">
			<input type=hidden name='other_alt_type' id='other_alt_type' value="<%=other_alt_type%>">
			<input type=hidden name='nat_id_code' id='nat_id_code' value="<%=nat_id_code%>">
			<input type=hidden name='r_area' id='r_area' value="<%=r_area_code%>">
			<input type=hidden name='m_area' id='m_area' value="<%=m_area_code%>">
			<input type=hidden name='r_region' id='r_region' value="<%=r_region_code%>">
			<input type=hidden name='m_region' id='m_region' value="<%=m_region_code%>">
			<input type=hidden name='r_town' id='r_town' value="<%=r_town_code%>">
			<input type=hidden name='m_town' id='m_town' value="<%=m_town_code%>">
			<input type=hidden name='priority' id='priority' value="<%=priority1%>">
			<input type=hidden name='reason_for_modify' id='reason_for_modify' value="<%=reason_for_modify%>">
			<input type=hidden name='cntval' id='cntval' value="<%=i%>">
			<input type=hidden name='web_no_show_flag' id='web_no_show_flag' value="">
			<!--below line is added for Bru-HIMS-CRF-173-->
			<input type=hidden name='wtListControl' id='wtListControl' value="<%=wtListControl%>">
			<input type=hidden name='rd_appt_yn' id='rd_appt_yn' value="<%=rd_appt_yn%>">
			</table>
  <%// }// any rec present

	if ( rs != null ) rs.close() ;
	if ( rsSet!=null) rsSet.close();
	if ( stmt != null ) stmt.close() ;
	if ( st != null ) st.close();

}	catch ( Exception e ){
	//out.println("Exception : "+e);
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally
{
	ConnectionManager.returnConnection(conn,request);
}
%>  
<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:15%; visibility:hidden;' bgcolor='blue'>
<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
<tr><td width='100%' id='t'></td></tr>
</table>
</center>
</form>
</body>
</html>

