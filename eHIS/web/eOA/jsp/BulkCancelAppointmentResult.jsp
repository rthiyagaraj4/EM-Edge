<!DOCTYPE html>
    <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page  contentType="text/html;charset=UTF-8" import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %>
<jsp:useBean id="apptRecordSet" class="webbeans.eCommon.RecordSet" scope="session"/>
<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	HashMap	htRecord		=	null;
	String	operation_mode	=	"";
	String fac_id		= (String) session.getValue( "facility_id" ) ;
	StringBuffer sql3=new StringBuffer("") ;

	String curr_user_id	=(String) session.getValue( "login_user" ) ;
	String cliniccode	=	request.getParameter("cliniccode")== null?"":request.getParameter("cliniccode");
	String practcode	=	request.getParameter("practcode")== null?"":request.getParameter("practcode");
	String apptfromdate	=	request.getParameter("apptfromdate")== null?"":request.getParameter("apptfromdate");
	String appttodate	=	request.getParameter("appttodate") == null?"":request.getParameter("appttodate");
	String clinic_type=	request.getParameter("clinic_type") == null?"":request.getParameter("clinic_type");
	String res_type=	request.getParameter("res_type") == null?"":request.getParameter("res_type");
	String called_for=request.getParameter("called_for");
	if(called_for==null) called_for="";
	String locale=(String)session.getAttribute("LOCALE");

	apptfromdate=DateUtils.convertDate(apptfromdate,"DMY",locale,"en");
	appttodate=DateUtils.convertDate(appttodate,"DMY",locale,"en");
	String patname="";
	String appt_ref_no="";
	String gender="";
	String patientid="";
	String 	apptrefno		="";
	String 	forced_yn		="";
	String cliniccode1		="";
	String patientid1="";
	String gender1="";
	String practitionerid	="";
	String apptdate			= "";
	String overbookedyn ="";	
	String apptslabfromtime= "";
	String apptslabtotime="";
	String canc_appt_yn  =""; 
	String tfr_appt_yn="";
	String tfr_appt_across_catg_yn="";
	String alcn_criteria="";
	String resourcetype="";
	String dis_age			="";
	String appt_duration	="";
	String visit_type_short_desc="";
	String clinic_short_desc="";
	String practitioner_short_name="";
	String referral_id		="";
	String classValue	 = "";
	String appt_day1	 = "";
	String visit_type_ind	 = "";
	String team_id	 = "";
	String appt_status="";
	String carelocndesc="";
	String locnType="";
	String resourceClass="";
	int cnt=0;	
	PreparedStatement stmtps=null;
	String secCnt="";
	ResultSet rsps=null;
	int		lower_limit		=	0,		upper_limit			=	0;
	int		maxDispRecord	=	14;
	String	start_index		=	"",		end_index			=	"";

	operation_mode	=	(request.getParameter("operation_mode")==null)	?	""		:	request.getParameter("operation_mode");
	start_index		=	(request.getParameter("start_index")==null)		?	"0"		:	request.getParameter("start_index");
	end_index		=	(request.getParameter("end_index")==null)		?	"14"	:	request.getParameter("end_index");

	lower_limit		=	Integer.parseInt(start_index);
	upper_limit		=	Integer.parseInt(end_index);



	Statement stmt				= null;
	ResultSet rs				= null;
	Connection conn=null;
	%>
	<HTML>
	<head>
		<script src="../../eOP/js/menu.js" language="JavaScript1.2"></script>
		<script src="../../eOA/js/QueryLocnForDay.js"></script>

		 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src="../../eOA/js/BulkCancelAppointment.js"></script>



	</head>
	<body OnMouseDown='CodeArrest();'onKeyDown = 'lockKey()' >
	<form name='QueryApptForPatient' id='QueryApptForPatient'>

	<%
	try 
	{
		conn = ConnectionManager.getConnection(request);
		stmt	 = conn.createStatement();
		
		if (appt_ref_no ==null) appt_ref_no="";
		String oper_stn_id="";


			try
			{
			
				oper_stn_id=request.getParameter("oper_stn_id");
				if(oper_stn_id==null)	oper_stn_id	=	"";

					
					//String sql1 = "";
					StringBuffer sql1 = new StringBuffer();
					StringBuffer sql2 = new StringBuffer();

		

		
 
	sql1=sql1.append("SELECT NVL (b.canc_appt_yn, 'N') canc_appt_yn, (select count(appt_ref_no) cntr from oa_resource_for_appt where appt_ref_no = a.appt_ref_no and FACILITY_ID=a.FACILITY_ID) CNT, team_id, NVL (b.tfr_appt_yn, 'N') tfr_appt_yn, NVL (b.tfr_appt_across_catg_yn, 'N') tfr_appt_across_catg_yn, a.patient_id,  decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, get_age (a.date_of_birth) age, a.appt_type_code visit_type_ind, a.gender, TO_CHAR (a.appt_date, 'Day') appt_day1, a.appt_ref_no, NVL (a.forced_appt_yn, 'N') forced_appt_yn, TO_CHAR (a.appt_date, 'dd/mm/rrrr') appt_date, NVL (TO_CHAR (a.appt_slab_from_time, 'hh24:mi'),'00:00') appt_slab_from_time, NVL (TO_CHAR (a.appt_slab_to_time, 'hh24:mi'),'00:00') appt_slab_to_time, NVL (TO_CHAR (a.appt_duration, 'hh24:mi'), '00:00') appt_duration, OP_GET_DESC.OP_VISIT_TYPE(a.FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc, OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, A.CLINIC_CODE,'"+locale+"','1') clinic_short_desc,	decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,'"+locale+"','1'), 'R', a.practitioner_id, AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_short_name , a.clinic_code, a.practitioner_id, a.overbooked_yn, a.referral_id, a.alcn_criteria, AM_GET_DESC.AM_CARE_LOCN_TYPE(CARE_LOCN_TYPE_IND,'"+locale+"','1') care_locn_type_desc, a.care_locn_type_ind,  a.resource_class resource_class_desc, a.resource_class");


	sql2 =sql2.append(" FROM oa_appt a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' and a.facility_id = b.facility_id and b.locn_type !='N' AND a.clinic_code = b.locn_code AND b.oper_stn_id = '"+oper_stn_id+"' AND b.appl_user_id = '"+curr_user_id+"'   AND NVL (a.clinic_code, 'X') = NVL ('"+cliniccode+"', a.clinic_code) AND NVL (a.practitioner_id, 'X') = NVL ('"+practcode+"', NVL (a.practitioner_id, 'X')) AND a.appt_date BETWEEN TO_DATE (NVL ('"+apptfromdate+"', TO_CHAR (SYSDATE, 'dd/mm/yyyy')),'dd/mm/yyyy')AND TO_DATE (NVL ('"+appttodate+"', '31/12/5000'), 'dd/mm/yyyy') AND a.appt_ref_no = NVL ('"+appt_ref_no+"', a.appt_ref_no) AND TRUNC (a.appt_date) >= TRUNC (SYSDATE) AND TO_DATE (   TO_CHAR (a.appt_date, 'dd/mm/yyyy') || ' '|| TO_CHAR (a.appt_time, 'hh24:mi'),'dd/mm/yyyy hh24:mi') >=TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi') AND appt_status != 'A'");

		
			
					
					if(!called_for.equals("")){
						sql2 = sql2.append(" and a.RECUR_WO_SEC_RES='Y'");
					}

					if(!clinic_type.equals("")){
						sql2 = sql2.append(" and a.care_locn_type_ind='"+clinic_type+"'");
					}

					if(!res_type.equals("")){
						sql2 = sql2.append(" and a.resource_class='"+res_type+"' ");
					}

					if(!apptfromdate.equals("")){
						sql2 = sql2.append(" and trunc(to_date('"+apptfromdate+"','dd/mm/yyyy')) >= trunc(sysdate) ");
					}

					
                        
					sql2= sql2.append( " order by a.appt_date,a.appt_slab_from_time, to_number(a.appt_ref_no)") ;

					
					if (rs!=null) rs.close();
					
	/*				rs 	= stmt.executeQuery("select count(1) cnt " + sql2.toString());
					
					if(rs.next())
					{
						
						cnt = rs.getInt("cnt");
						
					}
					if (rs!=null) rs.close(); */
				

						sql3.append(sql1.toString());
						sql3.append(sql2.toString());					
					//out.println("next :" +sql3.toString());
				
					
						rs 	= stmt.executeQuery(sql3.toString());
						sql2.setLength(0);
						sql3.setLength(0);
						apptRecordSet.clearAll();
						if(rs != null)
						{
						
						
					while ( rs != null && rs.next() )
					{
						
						htRecord		= new HashMap();
						try
						{

							tfr_appt_yn				=rs.getString("tfr_appt_yn");	
							secCnt					=rs.getString("CNT");
							tfr_appt_across_catg_yn	=rs.getString("tfr_appt_across_catg_yn");	
							canc_appt_yn			=rs.getString("canc_appt_yn");	
							apptrefno				=rs.getString("appt_ref_no")	;
							forced_yn				=rs.getString("FORCED_APPT_YN")	;
							cliniccode1				=rs.getString("clinic_code"); 
							practitionerid			=rs.getString("practitioner_id"); 
							if(practitionerid==null) practitionerid="";
							apptdate				=rs.getString("appt_date"); 
							overbookedyn 			=rs.getString("overbooked_yn");   
							team_id 				=rs.getString("team_id");
							carelocndesc			=rs.getString("CARE_LOCN_TYPE_DESC") ;
							resourcetype			=rs.getString("resource_class_desc");
							if(resourcetype==null) resourcetype="";
							locnType = rs.getString("care_locn_type_ind");
							resourceClass=rs.getString("resource_class");

							if(resourcetype.equals("P"))
			{
			resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			 }
			 else if(resourcetype.equals("E"))
			{
				resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			  }
			  else if(resourcetype.equals("R"))
			{
				resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}
			else if(resourcetype.equals("O"))
			{
				resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
						}
						catch(Exception e)
						{
							//out.println("Exception@4 : "+e);
							e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
						}
					
						team_id				= rs.getString("team_id")== null?"":rs.getString("team_id");
						patientid1				=rs.getString("patient_id")== null?"":rs.getString("patient_id");
						
						patname					=rs.getString("patient_name")== null?"":rs.getString("patient_name");
						
						dis_age					=rs.getString("age")== null?"":rs.getString("age");
						gender1					=rs.getString("gender")== null?"":rs.getString("gender");
						apptslabfromtime		=rs.getString("appt_slab_from_time")== null?"":rs.getString("appt_slab_from_time");
						apptslabtotime			=rs.getString("appt_slab_to_time")== null?"":rs.getString("appt_slab_to_time");
						appt_duration			=rs.getString("appt_duration")== null?"":rs.getString("appt_duration");
						visit_type_short_desc	=rs.getString("visit_type_short_desc")== null?"":rs.getString("visit_type_short_desc");
						clinic_short_desc		=rs.getString("clinic_short_desc")== null?"":rs.getString("clinic_short_desc");
						practitioner_short_name	=rs.getString("practitioner_short_name")== null?"":rs.getString("practitioner_short_name");
						referral_id				=rs.getString("referral_id")== null?"":rs.getString("referral_id");
						alcn_criteria				=rs.getString("alcn_criteria")== null?"":rs.getString("alcn_criteria");
						appt_day1				=rs.getString("appt_day1")== null?"":rs.getString("appt_day1");
						visit_type_ind			=rs.getString("visit_type_ind")== null?"":rs.getString("visit_type_ind");

						if (practitionerid==null)	practitionerid	=	"";

						

						try
						{
				
						htRecord.put	("tfr_appt_yn",					tfr_appt_yn				);
						htRecord.put	("secCnt",					secCnt				);
						htRecord.put	("tfr_appt_across_catg_yn",		tfr_appt_across_catg_yn	);
						htRecord.put	("canc_appt_yn",				canc_appt_yn			);
						htRecord.put	("apptrefno",					apptrefno				);
						htRecord.put	("carelocndesc", carelocndesc);
						htRecord.put	("resourcetype", resourcetype);
						htRecord.put	("forced_yn",					forced_yn				);
						htRecord.put	("cliniccode1",					cliniccode1				);
						htRecord.put	("practitionerid",				practitionerid			);
						htRecord.put	("apptdate",					apptdate				);
						htRecord.put	("overbookedyn",				overbookedyn 			);
						htRecord.put	("apptslabfromtime",			apptslabfromtime		);
						htRecord.put	("apptslabtotime",				apptslabtotime			);
						htRecord.put	("patientid",					patientid1				);
						htRecord.put	("patname",						patname					);
						htRecord.put	("dis_age",						dis_age					);
						htRecord.put	("gender",						gender1					);
						htRecord.put	("appt_duration",				appt_duration			);
						htRecord.put	("visit_type_short_desc",		visit_type_short_desc	);
						htRecord.put	("clinic_short_desc",			clinic_short_desc		);
						htRecord.put	("practitioner_short_name",		practitioner_short_name	);
						htRecord.put	("referral_id",					referral_id				);
						htRecord.put	("appt_day1",					appt_day1				);
						htRecord.put	("visit_type_ind",				visit_type_ind			);
						htRecord.put	("alcn_criteria",			    alcn_criteria		);
						htRecord.put	("team_id",			    team_id		);
						htRecord.put    ("appt_status", appt_status);
						htRecord.put	("resourceClass",resourceClass);
						htRecord.put	("locnType",locnType);
						apptRecordSet.putObject(htRecord);


						}
					
						catch(Exception e)
						{
							//out.println("Exception@5 : "+e);
							e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
						}
						
					}

					}
			if (rs!=null) rs.close();	
			}
			catch(Exception e)
			{
				e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165				
				//out.println("Exception@2 : "+e);
			}
int totalRecords=0;
		 totalRecords = apptRecordSet.getSize();
	
	/*	if(cnt == 0)
					{ */
					%>	<!-- <script>
						alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
					</script> -->
					<%	
			//		}else{
		
	%>
	<p align='right'>
		<table border="0" cellspacing='0' cellpadding='0'>
		<tr>
		<%
		int upper_limit1=0;
		upper_limit1=upper_limit;

			try
		{
			if(upper_limit>totalRecords)	upper_limit1	=	totalRecords;
			int rowcolor=0;

			for(int i=lower_limit; i <upper_limit1; i++)
			{
				if(cnt==0)
				{
			
			if(!(lower_limit <= 1))
			{
		%>
			<td align ='right' id='prev'><a href="../../eOA/jsp/BulkCancelAppointmentResult.jsp?operation_mode=Previous&start_index=<%=(lower_limit-maxDispRecord)%>&end_index=<%=(upper_limit-maxDispRecord)%>&oper_stn_id=<%=oper_stn_id%>&called_for=<%=called_for%>&practcode=<%=practcode%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&cliniccode=<%=cliniccode%>&appttodate=<%=appttodate%>&apptfromdate=<%=apptfromdate%>"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
		<%
			}

			{
		%>
			<td align ='right' id='next' style='visibility:hidden'><a href="../../eOA/jsp/BulkCancelAppointmentResult.jsp?operation_mode=Next&start_index=<%=(lower_limit+maxDispRecord)%>&end_index=<%=(upper_limit+maxDispRecord)%>&oper_stn_id=<%=oper_stn_id%>&called_for=<%=called_for%>&practcode=<%=practcode%>&clinic_type=<%=clinic_type%>&res_type=<%=res_type%>&cliniccode=<%=cliniccode%>&appttodate=<%=appttodate%>&apptfromdate=<%=apptfromdate%>"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
		<%
			}	
		%>
		</tr>
		</table>
	</p>
	<table border="1" width="100%" cellspacing='0'id='vv' cellpadding='0'>
		<tr>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.apptno.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/></td>
			<%if(called_for.equals("")){%>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/></td>
			<%}%>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.fromtime.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.totime.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.resourcetype.label" bundle="${common_labels}"/></td> 
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.resourcename.label" bundle="${common_labels}"/></td>
			<td class='COLUMNHEADER' nowrap><fmt:message key="Common.referralid.label" bundle="${common_labels}"/></td>
		</tr>
		<% }
	/*	try
		{
			if(upper_limit>totalRecords)	upper_limit	=	totalRecords;
			int rowcolor=0;

			for(int i=lower_limit; i <upper_limit; i++)
			{ */
				
				htRecord				=		(java.util.HashMap)	apptRecordSet.getObject(i);
				tfr_appt_yn				=		(String)	htRecord.get	("tfr_appt_yn");
				secCnt					=		(String)	htRecord.get	("secCnt");
				tfr_appt_across_catg_yn	=		(String)	htRecord.get	("tfr_appt_across_catg_yn");
				canc_appt_yn			=		(String)	htRecord.get	("canc_appt_yn");			
				apptrefno				=		(String)	htRecord.get	("apptrefno");	carelocndesc	        =		(String)	htRecord.get	("carelocndesc");
				resourcetype			=    (String) htRecord.get ("resourcetype");
				forced_yn				=		(String)	htRecord.get	("forced_yn");	
				
				cliniccode1				=		(String)	htRecord.get	("cliniccode1");		
				practitionerid			=		(String)	htRecord.get	("practitionerid");
				apptdate				=		(String)	htRecord.get	("apptdate");			
				appt_status             =       (String)    htRecord.get    ("appt_status");
				overbookedyn 			=		(String)	htRecord.get	("overbookedyn");		
				apptslabfromtime		=		(String)	htRecord.get	("apptslabfromtime");		
				apptslabtotime			=		(String)	htRecord.get	("apptslabtotime");
				patientid				=		(String)	htRecord.get	("patientid");				
				resourceClass			=		(String)    htRecord.get	("resourceClass");
				locnType				=		(String)	htRecord.get	("locnType");
				if(patientid==null || patientid.equals("")) patientid="&nbsp;";
				patname					=		(String)	htRecord.get	("patname");
				dis_age					=		(String)	htRecord.get	("dis_age");
				if(dis_age==null || dis_age.equals("")) dis_age="&nbsp;";
				gender					=		(String)	htRecord.get	("gender");			
				appt_duration			=		(String)	htRecord.get	("appt_duration");	
				visit_type_short_desc	=		(String)	htRecord.get	("visit_type_short_desc");
				clinic_short_desc		=		(String)	htRecord.get	("clinic_short_desc");	
				if(clinic_short_desc==null || clinic_short_desc.equals("")) clinic_short_desc="&nbsp;";
				practitioner_short_name	=		(String)	htRecord.get	("practitioner_short_name");
				if(practitioner_short_name==null || practitioner_short_name.equals("")) practitioner_short_name="&nbsp;";
				referral_id				=		(String)	htRecord.get	("referral_id");
				if(referral_id==null || referral_id.equals("")) referral_id="&nbsp;";
				
				alcn_criteria				=		(String)	htRecord.get	("alcn_criteria");
				if(alcn_criteria==null || alcn_criteria.equals("")) alcn_criteria="";
				appt_day1				=		(String)	htRecord.get	("appt_day1");
				visit_type_ind				=		(String)	htRecord.get	("visit_type_ind");
				team_id				=		(String)	htRecord.get	("team_id");
				if(appt_day1==null || appt_day1.equals("")) appt_day1="";
				if(visit_type_ind==null || visit_type_ind.equals("")) visit_type_ind="";
				if(team_id==null || team_id.equals("")) team_id="";

												
				if ( rowcolor % 2 == 0 )
				classValue = "QRYEVEN" ;
				else
				classValue = "QRYODD" ;
				
				String apptdate_display="";
				apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);
				%>
					
				<tr onMouseOver='hideToolTip()'>
				<%			
				if(forced_yn.equals("N")){ %>

						<%if(called_for.equals("")){%>
						
						<td class='<%=classValue%>' nowrap><input type="checkbox"  name='selectall<%=i%>' id='selectall<%=i%>' onclick="show_second(this,'<%=apptrefno%>')" checked></input>	<a href="javascript:callDummy()"><%=apptrefno%></a></td>
						<%}else{%>

							<td class='<%=classValue%>' onClick="displaydet_for_sec('<%=apptrefno%>','<%=cliniccode1%>','<%=practitionerid%>','<%=apptdate%>',	'<%=overbookedyn%>','<%=apptslabfromtime%>','<%=apptslabtotime%>','<%=appt_day1.trim()%>','N','<%=resourceClass%>')" nowrap> 
							<input type="checkbox"  name='selectall<%=i%>' id='selectall<%=i%>' checked></input><a href="javascript:callDummy()"><%=apptrefno%></a></td>

						<%}%>


					<% } else {%>
							
					<td  title = 'Forced Appointment' class = 'OAFORCED'  nowrap> <input type="checkbox"  name='selectall<%=i%>' id='selectall<%=i%>' checked></input>
					<a href="javascript:callDummy()">
					<%=apptrefno%></a></td>
					<% } %>
				
				<td class="<%=classValue%>" nowrap onClick=hideToolTip()><%=apptdate_display%></td>

				<%String tmp_ref_no=apptrefno;
				
				%>
				<%if(called_for.equals("")){%>
				<td nowrap class="<%=classValue%>">
					<%if(!secCnt.equals("0")){%><a href="javascript:show_Reference_details('<%=tmp_ref_no%>','<%=fac_id%>')"><fmt:message key="Common.details.label" bundle="${common_labels}"/></a>
				<%}%>&nbsp;</td>
				<%}%>


				<td class="<%=classValue%>" nowrap onClick=hideToolTip()>
				<%if(patientid==null){%>
					&nbsp;
				<%}else{
					out.println(patientid);
				}
				%>
				</td>
				<td class="<%=classValue%>" nowrap >
				<%=patname%>&nbsp;,<%=gender%>&nbsp;,<%=dis_age%></td>
					
			<td nowrap class='<%=classValue%>'><%=apptslabfromtime%></td>
				<td nowrap class='<%=classValue%>'><%=apptslabtotime%></td>
				<td nowrap class='<%=classValue%>'><%=appt_duration%></td>		
				<td nowrap class='<%=classValue%>'><%=visit_type_short_desc%></td>
				<td nowrap class='<%=classValue%>'><%=carelocndesc%></td>
				<td nowrap class='<%=classValue%>'><%=clinic_short_desc%></td>
			
				<td nowrap class='<%=classValue%>'><%=resourcetype%></td>
					<%
				String patname10 = practitioner_short_name == null?"&nbsp;":practitioner_short_name;
				%>
				<td nowrap class='<%=classValue%>'><%=patname10%></td>
				<%
				String patname11 = referral_id== null?"&nbsp;":referral_id;
				%>
				<td nowrap class='<%=classValue%>'><%=patname11%></td>
				</tr>
					<%
				rowcolor++;		
				cnt++;
				//htRecord.clear();
				}

		}
		catch(Exception e)
		{
			//out.println("Exception@3 : "+e);
			e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
		}
//	}

	if(cnt == 0)
	{%>
		<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>
	<%}

	//boolean flag = false;
	if ( cnt < 14  ) {
	%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='hidden';
		</script>
	<% //flag = true;
			} else {%>
		<script >
		if (document.getElementById("next"))
			document.getElementById("next").style.visibility='visible';
		</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<%}

		if (rsps!=null) rsps.close();
		if ( rs != null ) rs.close() ;
		if (stmtps!=null) stmtps.close();
	    if ( stmt != null ) stmt.close() ;
	}
	catch ( Exception e )
	{
		//out.println("Exception : "+e);
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
	finally
	{   
		ConnectionManager.returnConnection(conn,request);

	}
%>  
	</table>
	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>
		<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0' width='auto' height='100%' align='center'>
			<tr><td width='100%' id='t'></td></tr>
		</table>
	</div>	 
</center>
<input type='hidden' name='canc_appt_yn' id='canc_appt_yn' value='<%=canc_appt_yn%>' >
<input type='hidden' name='alcn_criteria' id='alcn_criteria' value='<%=alcn_criteria%>' >
</form>
</body>
<script>
	
	if(parent.frames[1].document.forms[0].select)
 	parent.frames[1].document.forms[0].select.disabled=false;

</script>	
</html>

