<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,com.ehis.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%! 
 
public StringBuffer getStatistics(PageContext pageContext,Connection con,String facility_id,String clinic_type,String clinic_code,String treatment_area_code,int cutoff_prv_days) throws java.sql.SQLException
	{

        StringBuffer tmt_area_statistics = new StringBuffer();
		String query_statistics	= " SELECT SUM(DECODE(queue_status,'01',0,1)) tot_assigned, SUM(DECODE(queue_status,'04',1,0)) tot_under_tmt, SUM(DECODE(queue_status,'07',1,'09',1,0)) tot_consulted, SUM(CASE WHEN QUEUE_STATUS='02' AND CONS_SRVC_START_DATE_TIME IS NULL AND CONS_SRVC_END_DATE_TIME IS NULL THEN 1 ELSE 0 END) tot_await_tmt FROM op_patient_queue where facility_id = ? and (trunc(queue_date) between trunc(SYSDATE) -((1/(24*60*60))*3600*"+cutoff_prv_days+") and sysdate) and locn_type = ? and locn_code = ? and treatment_area_code = ? and patient_class = 'EM'"; 

		int tot_assigned	=	0;
		int tot_under_tmt	=	0;
		int tot_consulted	=	0;
		int tot_await_tmt	=	0;

		PreparedStatement pstmt	=	con.prepareStatement(query_statistics);

		pstmt.setString	(	1,	facility_id	);
		pstmt.setString	(	2,	clinic_type	);
		pstmt.setString	(	3,	clinic_code	);
		pstmt.setString	(	4,	treatment_area_code);

		ResultSet rs =	pstmt.executeQuery();

		if(rs !=null && rs.next())
		{
			tot_assigned	=	rs.getInt("tot_assigned");
			tot_under_tmt	=	rs.getInt("tot_under_tmt");
			tot_consulted	=	rs.getInt("tot_consulted");
			tot_await_tmt	=	rs.getInt("tot_await_tmt");
		}
		tmt_area_statistics.append("( "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assigned.label","common_labels")+" : "+tot_assigned+" ");
		tmt_area_statistics.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels")+" : "+tot_under_tmt+" ");
		tmt_area_statistics.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Consulted.label","ae_labels")+" : "+tot_consulted+" ");
		tmt_area_statistics.append(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AwaitingTreatment.label","ae_labels")+" : "+tot_await_tmt+" )");
  
		if(rs!=null) rs.close();
		if(pstmt!=null)			pstmt.close();

		return tmt_area_statistics;
	}  

	%>

<html>
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eAE/js/AEManagePatientGI.js'></script>
<script language='javascript' src='../../eAE/js/AEManagePatient.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body  onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<center>
<form name='AEPatientTMTResultForm' id='AEPatientTMTResultForm'>
<div name='msg' id='msg' style="position:absolute;width: 0; height: 0; left: 201; top: 62">
</div>

<%
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	StringBuffer query_patient_queue	=	new StringBuffer();
	String facility_id			=	"";
	String	clinic_code			=	"";
	String	practitioner_id		=	"",		practitioner_name		=	"";
	String	priority_indicator	=	"",		check_in_date_time		=	"";
	String clinic_desc="";
	String	patient_id			=	"",		patient_name			=	"";
	String	waiting_time		=	"";
	String	queue_status_desc	=	"",		classValue				=	"";
	String	treatment_area_code	=	"",		prv_treatment_area_code	=	"";
	String	treatment_area_desc	=	"",		triage_area				=	"";
	String	classValuePI		=	"";
	String	queue_date			=	"",		classValuePat			=	"";
	String	clinic_type			=	"";
	String	patient_gender		=	"",		brought_dead_yn			=	"";
	String	order_by_priority	=	"";
	StringBuffer whereClause    =   new StringBuffer();
    StringBuffer orderByClause	=	new StringBuffer();
	String locale				= (String)session.getAttribute("LOCALE");
	
	//Added for this AAKH-CRF-0010 [IN:038535]
	String prior_zone_bgcolor="";
	String priority_zone_all_codes="";
	String five_level_triage_appl_yn	= "N";
	String FIVE_LEVEL_TRIAGE_APPL_YN1="N";

	String	priority			=	"";		
	String	tblrow_id			=	"";
	String  priority_zone = "";
	String  from_date = "";
	String  to_date = "";
	int p_cutoff_hours_prv_day_visit = 0;
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	String from 				= request.getParameter("from") ;
	String to 					= request.getParameter("to") ;
	String whereCondition		= request.getParameter("whereCondition");
     if(whereCondition==null || whereCondition.equals("null"))  whereCondition= "";
 
	patient_id					=	(request.getParameter("patient_id")==null)	? "" : request.getParameter("patient_id");	

	String brought_dead = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.broughtdead.label","common_labels") + " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patient.label","common_labels") ;

    java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy hh:mm" ) ;
    java.util.Date dt=new java.util.Date();
	String d = dateFormat.format( dt ) ;

	int start = 0 ;
	int end = 0 ;
	int i=1; 
	int p_rec_cnt = 0;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 12 ;
	else
		end = Integer.parseInt( to ) ;   

	
try
	{
		con				=	ConnectionManager.getConnection(request);
		facility_id		=	(String)session.getValue("facility_id");





	int		rowIndex				=	1,		columnIndex				=	0;
	
		from_date			=	(request.getParameter("patbytrmtroom_datefrom")==null) ? ""		             :request.getParameter("patbytrmtroom_datefrom");
		/*Added By Dharma For Leap Year Issue on Oct 5th 2015 Start*/
		if(!from_date.equals("") && locale.equals("th"))
			from_date			= DateUtils.convertDate(from_date,"DMYHM","th","en");
		/*Added By Dharma For Leap Year Issue on Oct 5th 2015 End*/

		to_date				=	(request.getParameter("patbytrmtroom_to")==null)? "" : request.getParameter("patbytrmtroom_to");
		/*Added By Dharma For Leap Year Issue on Oct 5th 2015 Start*/
		if(!to_date.equals("") && locale.equals("th"))
			to_date			= DateUtils.convertDate(to_date,"DMYHM","th","en");
		/*Added By Dharma For Leap Year Issue on Oct 5th 2015 End*/
		if (from_date.equals("")) from_date =d;
		if (to_date.equals("")) to_date = "01/01/1900 00:01";
		clinic_code			=	(request.getParameter("clinic_code")==null)			? "" : request.getParameter("clinic_code");
		clinic_type			=	(request.getParameter("clinic_type")==null)			? "" : request.getParameter("clinic_type");
		treatment_area_code	=	(request.getParameter("treatment_area_code")==null)	? "" : request.getParameter("treatment_area_code");
		practitioner_id		=	(request.getParameter("practitioner_id")==null)		? "" : request.getParameter("practitioner_id"); 
		priority			=	(request.getParameter("priority")==null)			? "" : request.getParameter("priority");
		patient_gender		=	(request.getParameter("patient_gender")==null)		? "" : request.getParameter("patient_gender");
		order_by_priority	=	(request.getParameter("order_by_priority")==null)	? "" : request.getParameter("order_by_priority");
		FIVE_LEVEL_TRIAGE_APPL_YN1	=	(request.getParameter("FIVE_LEVEL_TRIAGE_APPL_YN")==null)	? "" : request.getParameter("FIVE_LEVEL_TRIAGE_APPL_YN");
		
		/*Below line added for this AAKH-CRF-0010 [IN:038535]*/
		priority_zone_all_codes=(request.getParameter("priority_zone_all_codes")==null)	? "" : request.getParameter("priority_zone_all_codes");
	
		StringBuilder priority_zone_order	 = new StringBuilder();
	if(!priority_zone_all_codes.equals("")&&priority_zone_all_codes.length()>0){
	
			priority_zone_all_codes = priority_zone_all_codes.substring(0, priority_zone_all_codes.length());				
		    String[] priority_zone_split = priority_zone_all_codes.split(",");
			
		for (int  x= 0; x < priority_zone_split.length; x++) {
			priority_zone_order.append("'"+priority_zone_split[x]+"',"+(x+1));
			if (x!= priority_zone_split.length - 1) {
		    	priority_zone_order.append(",");
		    }
		}
		
	}//End AAKH-CRF-0010 [IN:038535]
		
		
		if(!(clinic_code.equals("")))			whereClause.append(" and locn_code = ? and locn_type = ? ");
		if(!(treatment_area_code.equals("")))	whereClause.append(" and treatment_area_code = ? ");
		if(!(practitioner_id.equals("")))		whereClause.append(" and practitioner_id = ? ");
		if(!(patient_id.equals("")))			whereClause.append(" and a.patient_id = ? ");
	
		if(!priority.equals("")){
			/*if(priority.equals("B"))		whereClause.append(" and priority_zone = 'B' ");
			if(priority.equals("R"))		whereClause.append(" and priority_zone = 'R' ");
			if(priority.equals("Y"))		whereClause.append(" and priority_zone = 'Y' ");
			if(priority.equals("G"))		whereClause.append(" and priority_zone = 'G' ");
			if(priority.equals("W"))		whereClause.append(" and priority_zone = 'W' ");
			if(priority.equals("U"))		whereClause.append(" and priority_zone = 'U' ");*/
			whereClause.append(" and priority_zone = '"+priority+"' ");//Added By Shanmukh for MMS-DM-CRF-0147
		}
		if(!(patient_gender.equals("")))		whereClause.append(" and sex = ? ");
		//if(order_by_priority.equals("Y")) orderByClause.append(" priority_zone"); //Commented this line [IN:038535]
		
	query_patient_queue.append(" select c.five_level_triage_appl_yn,a.LOCN_TYPE,a.LOCN_CODE,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.LOCN_CODE,'"+locale+"','1') LOCN_DESC, a.treatment_area_code, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(a.FACILITY_ID, a.LOCN_CODE, a.TREATMENT_AREA_CODE,'"+locale+"','2') treatment_area_desc,(CASE WHEN a.treatment_area_code IS NOT NULL THEN (SELECT DECODE (triage_area_yn, 'Y', 'B','N', 'C','', 'A') FROM ae_tmt_area_for_clinic WHERE facility_id = a.facility_id AND clinic_code = a.locn_code AND treatment_area_code = a.treatment_area_code) END) triage_area , a.practitioner_id, AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,'"+locale+"','1') practitioner_name, a.PRIORITY_INDICATOR,  a.PRIORITY_ZONE,  to_char(a.queue_date,'dd/mm/yyyy hh24:mi') check_in_date_time,  a.patient_id, decode('"+locale+"', 'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) patient_name, a.encounter_id,get_waiting_time (NVL(a.cons_srvc_start_date_time, SYSDATE),queue_date) waiting_time, to_char(a.queue_date,'dd/mm/yyyy') queue_date1, a.queue_status,  NVL(queue_status,'Autoclosed') queue_status_desc, a.BROUGHT_DEAD_YN, c.cutoff_hours_prv_day_visit,(SELECT PRIORITY_ZONE_COLOR FROM AE_PRIORITY_ZONE WHERE EFF_STATUS='E' and PRIORITY_ZONE=a.PRIORITY_ZONE ) PRIORITY_ZONE_COLOR from op_patient_queue a, mp_patient b,ae_param c where a.facility_id='"+facility_id+"' and a.patient_class = 'EM' and a.patient_id = b.patient_id and a.facility_id = c.operating_facility_id AND a.queue_date BETWEEN TO_DATE('"+from_date+"','DD/MM/YYYY hh24:mi') AND TO_DATE('"+to_date+"','DD/MM/YYYY hh24:mi') ");
	/*Above query modified for this AAKH-CRF-0010 [IN:038535]*/
	
		query_patient_queue.append(whereClause.toString());
		if(FIVE_LEVEL_TRIAGE_APPL_YN1.equals("Y"))	{
			if((order_by_priority.equals("Y")&& priority.equals(""))||(order_by_priority.equals("Y")&&!priority.equals(""))||(order_by_priority.equals("")&&!priority.equals(""))){
				orderByClause.append(" order by DECODE(priority_zone,"+priority_zone_order.toString()+") asc,queue_date desc");
			}else{ 
				orderByClause.append(" order by triage_area,treatment_area_code,queue_date ");
			}
		}
		else{
			/*Modified By Dharma on 16th Dec 2014 against HSA-SCF-0050.1 [IN:052934] Start*/
			/*
			if(order_by_priority.equals("Y")) orderByClause.append(" ,priority_zone");
			query_patient_queue.append(" order by triage_area,treatment_area_code,queue_date ");*/
			if((order_by_priority.equals("Y")&& priority.equals(""))||(order_by_priority.equals("Y")&&!priority.equals(""))||(order_by_priority.equals("")&&!priority.equals(""))){
				orderByClause.append(" order by DECODE(priority_zone,"+priority_zone_order.toString()+") asc,queue_date desc");
			}else{ 
				orderByClause.append(" order by triage_area,treatment_area_code,queue_date ");
			}
			/*Modified By Dharma on 16th Dec 2014 against HSA-SCF-0050.1 [IN:052934] End*/
			
		}
		
		query_patient_queue.append(orderByClause.toString());
		pstmt		=	con.prepareStatement(query_patient_queue.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//pstmt.setString	(	1,	facility_id		);
		if(!(clinic_code.equals("")))	
		{
			pstmt.setString	(	++columnIndex,	clinic_code	);
			pstmt.setString	(	++columnIndex,	clinic_type	);
		}
		if(!(treatment_area_code.equals("")))	
			pstmt.setString	(	++columnIndex,	treatment_area_code	);
		if(!(practitioner_id.equals("")))	
			pstmt.setString	(	++columnIndex,	practitioner_id	);
		if(!(patient_id.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_id	);
		if(!(patient_gender.equals("")))	
			pstmt.setString	(	++columnIndex,	patient_gender	);

		rs			=	pstmt.executeQuery();
	 
	  int cnt=0;
	  String endOfRes="1";
	  if ( start != 1 )
		 for( int j=1; j<start; i++,j++ )
		  {
			rs.next() ;
		  }
  
	 while (i<=end && rs.next()){
		if(cnt==0){
			five_level_triage_appl_yn	=  (rs.getString("five_level_triage_appl_yn")==null || rs.getString("five_level_triage_appl_yn")=="")?"N":rs.getString("five_level_triage_appl_yn");

		%>
		<script>
		parent.AEMPLegendFrame.location.href='../../eAE/jsp/AEMPLegend.jsp?five_level_triage_appl_yn=<%=five_level_triage_appl_yn%>';
	</script>

<p>
	<table align='right'>
	<tr>
	<td>
	<%

	if ( !(start <= 1) )
	out.println("<A HREF='../../eAE/jsp/AEPatientTMTResult.jsp?from="+(start-12)+"&to="+(end-12)+ "&clinic_code="+clinic_code+"&clinic_type="+clinic_type+"&FIVE_LEVEL_TRIAGE_APPL_YN="+FIVE_LEVEL_TRIAGE_APPL_YN1+"&treatment_area_code="+treatment_area_code+ "&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority_zone_all_codes="+priority_zone_all_codes+"&priority="+priority+"&patient_gender="+patient_gender+"&order_by_priority="+order_by_priority+"&patbytrmtroom_datefrom="+from_date+"&patbytrmtroom_to="+to_date+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eAE/jsp/AEPatientTMTResult.jsp?from="+(start+12)+"&to="+(end+12)+"&clinic_code="+clinic_code+"&clinic_type="+clinic_type+"&FIVE_LEVEL_TRIAGE_APPL_YN="+FIVE_LEVEL_TRIAGE_APPL_YN1+"&treatment_area_code="+treatment_area_code+ "&practitioner_id="+practitioner_id+"&patient_id="+patient_id+"&priority_zone_all_codes="+priority_zone_all_codes+"&priority="+priority+"&patient_gender="+patient_gender+"&order_by_priority="+order_by_priority+"&patbytrmtroom_datefrom="+from_date+"&patbytrmtroom_to="+to_date+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>"); 
	
	%>
</td>
</tr>
</table>
<br>
<br>
</p>

<table border='1' cellpadding='0' cellspacing='0' width='100%' id='tb1'>
<th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
<th>&nbsp;&nbsp;&nbsp;</th>
<th><fmt:message key="Common.QueueDate.label" bundle="${common_labels}"/> </th>
<th><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.WaitTime.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.QueueStatus.label" bundle="${common_labels}"/></th>
		<%}

			classValue				=	((rowIndex%2)==0)? "QRYEVEN" : "QRYODD";
			rowIndex++;
			tblrow_id				=	"tblrow_id"+rowIndex;
        
			clinic_code			=	(rs.getString("locn_code")==null)	?	""	: rs.getString("locn_code");
			clinic_type			=	(rs.getString("locn_type")==null)	?	""	: rs.getString("locn_type");	
            clinic_desc         =(rs.getString("LOCN_DESC")==null)	?	""	: rs.getString("LOCN_DESC");	
			
			treatment_area_code		=	(rs.getString("treatment_area_code")==null)	?	"&nbsp;"	: rs.getString("treatment_area_code");	
			treatment_area_desc		=	(rs.getString("treatment_area_desc")==null)	?	"&nbsp;"	: rs.getString("treatment_area_desc");	
			triage_area				=	(rs.getString("triage_area")==null)			?	"&nbsp;"	: rs.getString("triage_area");	

			practitioner_id			=	(rs.getString("practitioner_id")==null)		?	"&nbsp;"	: rs.getString("practitioner_id");
			practitioner_name		=	(rs.getString("practitioner_name")==null)	?	"&nbsp;"	: rs.getString("practitioner_name");
			priority_indicator		=	(rs.getString("priority_indicator")==null)	?	"&nbsp;"	: rs.getString("priority_indicator");
			check_in_date_time		=	(rs.getString("check_in_date_time")==null)	?	"&nbsp;"	: rs.getString("check_in_date_time");
			patient_id				=	(rs.getString("patient_id")==null)			?	"&nbsp;"	: rs.getString("patient_id");
			patient_name			=	(rs.getString("patient_name")==null)		?	"&nbsp;"	: rs.getString("patient_name");
			waiting_time			=	(rs.getString("waiting_time")==null)		?	"&nbsp;"	: rs.getString("waiting_time");
			queue_date				=	(rs.getString("queue_date1")==null)			?	"&nbsp;"	: rs.getString("queue_date1");	
			queue_status_desc		=	(rs.getString("queue_status_desc")==null)	?	"&nbsp;"	: rs.getString("queue_status_desc");	

			if(queue_status_desc.equals("00"))
		queue_status_desc="&nbsp;";
		if(queue_status_desc.equals("01"))			        queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
		if(queue_status_desc.equals("02"))                  queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AssignedtoTreatmentArea.label","ae_labels");		
		if(queue_status_desc.equals("03"))						queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.UndergoingTreatment.label","ae_labels");
		if(queue_status_desc.equals("04"))
		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");	
		if(queue_status_desc.equals("07"))		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckOut.label","common_labels");
		if(queue_status_desc.equals("09"))
		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.Autoclosed.label","ae_labels");
		if(queue_status_desc.equals("99"))
		queue_status_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");

			p_cutoff_hours_prv_day_visit = rs.getInt("CUTOFF_HOURS_PRV_DAY_VISIT");
			
	  prior_zone_bgcolor=(rs.getString("PRIORITY_ZONE_COLOR")==null)?"":rs.getString("PRIORITY_ZONE_COLOR"); //Added for this AAKH-CRF-0010 [IN:038535]
			
			priority_zone			=	(rs.getString("priority_zone")==null)		?	"&nbsp;"	: rs.getString("priority_zone");


            brought_dead_yn				=	(rs.getString("brought_dead_yn")==null)			?	"&nbsp;"	: rs.getString("brought_dead_yn");
			if(brought_dead_yn.equals("Y"))
				classValuePat		=	"AEBROUGHTDEAD";
			else
				classValuePat		=	classValue;  
			if	(priority_zone.equals("R"))		classValuePI	=	"RESUSCITATION";
			else if(priority_zone.equals("Y"))		classValuePI	=	"OAYELLOW";
			else if(priority_zone.equals("G"))		classValuePI	=	"URGENT";
			else if(priority_zone.equals("U"))		classValuePI	=	"EMERGENT";
			else classValuePI	=	classValue;
              String temp_area_code=clinic_code+"/"+ treatment_area_code;
			if(!(temp_area_code.equals(prv_treatment_area_code)))
			{	if(treatment_area_desc.equals("&nbsp;"))
					treatment_area_desc = "Unassigned";
				if(triage_area.equals("B"))
					treatment_area_desc = clinic_desc+"/"+treatment_area_desc;
				else 
					treatment_area_desc =clinic_desc+"/"+ treatment_area_desc; 
	%>	
		 <tr id='one'> 
	<%
				if(!( treatment_area_desc.equals("Unassigned") ))
				{   
	%>
			<th colspan=3 align='left'><font size=1><%=treatment_area_desc%></th>
			<th colspan=4 align='right'> 
	<% 
out.println(getStatistics(pageContext,con,facility_id,clinic_type,clinic_code,treatment_area_code,p_cutoff_hours_prv_day_visit));
	%>
		 </th>
	<%
				}
				else
				{ 		        
	%>
			 <th colspan=7 align='left'><font size=1><%= treatment_area_desc%></th> 
	<%
				}	
	%>
		 </tr> 
	<%
				prv_treatment_area_code	 =	 temp_area_code;
			
			} 
	%>
		 <tr id='<%=tblrow_id%>'>
			<td class='<%=classValue%>'><font size=1><%=practitioner_name%></td>
			<td class='<%=classValuePI%>' style="background-color:<%=prior_zone_bgcolor%>">&nbsp;</td> <!--Modified for this CRF AAKH-CRF-0010 [IN:038535] -->
			<td class='<%=classValue%>'><font size=1><%=DateUtils.convertDate(check_in_date_time,"DMYHM","en",locale)%></td>
			<td class='<%=classValue%>'		onMouseover="onMMove(msg,event,'<%=brought_dead%>','<%=brought_dead_yn%>');" onMouseout="onMOut(msg,'<%=brought_dead_yn%>');"><font size=1><%=patient_name%></td>
			<td class='<%=classValuePat%>'><font size=1><%=patient_id%></td>
			<td class='<%=classValue%>' align='center'><font size=1><%=waiting_time%></td>
			<td class='<%=classValue%>'><font size=1><%=queue_status_desc%></td>
		</tr> 
	<%
		i++;
		p_rec_cnt++;
		cnt++;
		}
	  
	 
	 if(cnt==0){
%>
		<script>

			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
			parent.frames[0].document.forms[0].refresh.disabled = false;
			parent.frames[1].location.href='../../eCommon/html/blank.html';
			parent.frames[2].location.href='../../eCommon/html/blank.html';
			parent.parent.frames[0].document.forms[0].reset.disabled=false;
		</script>
<%
	  }
		 if(!rs.next()&&cnt!=0){
	endOfRes="0";%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
	<%}

query_patient_queue.setLength(0);
whereClause.setLength(0);
orderByClause.setLength(0);

if(rs!=null)	rs.close();
if(pstmt!=null)	pstmt.close();

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
	out.println("<script>parent.frames[0].document.forms[0].refresh.disabled = false; </script>");
	    
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
	}


%>
<script>
		parent.parent.frames[0].document.forms[0].reset.disabled=false;
		parent.frames[0].document.forms[0].refresh.disabled = false;
</script>
</table>

<input type='hidden' name='queue_date' id='queue_date' value='<%=queue_date%>'> 
</form>
</center>
</body>
</html>

