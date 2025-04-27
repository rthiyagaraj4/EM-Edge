<!DOCTYPE html>
<!--
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29413    Dinesh T     ARTEMIS - Added the new method
21/12/2011	  IN30050	 Dinesh T	  ARTEMIS - Updated for the patient id irrespective of the												  practitioners and updated the = to like in qry
14/12/2012	  IN033692	 Vijayakumar K patient referral has been closed still patient is appearing in IP Consultation list because of which patients are getting charged extra as consultants are charging visit.attached is the screen shot
12/03/2013    IN033692	 Chowminya G   patient referral has been closed still patient is appearing
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
18/07/2018    IN067769		Raja S		18/07/2018		Ramesh G			KDAH-SCF-0506
-----------------------------------------------------------------------------------------------
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html> 
	<head>
		<title></title>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");
	String facility_id		=	(String) session.getValue("facility_id");
	String ca_practitioner_id		=	(String) session.getValue("ca_practitioner_id");
	eCA.IPConsultationListBean ipConsultListBean = null;
	String queryString = request.getQueryString();
		
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script Language="JavaScript" src='../../eCA/js/IPConsultationList.js'></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	Connection con = null;
	PreparedStatement stmt=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	ResultSet prs=null;
	ArrayList selectedList =new ArrayList(); 
	StringTokenizer Tokens = null ;
	String patientId ="";
	String practitionerId ="";
	String speciality_code ="";
	String location_code ="";
	String service_code ="";
	String cons_date ="";
	String cons_time ="";
	String create_type ="";
	String bean_key ="";
	String res_mode ="";
	String strVal ="";
	String checked ="";
	String arrVal ="";
	StringBuffer consListQry = new StringBuffer();
	String pline ="";
	String rsAdmission_date_time ="";
	String rsSpecialty_code="";
	String rsSpecialty_desc="";
	String rsLocation_code ="";
	String patient_id ="";
	String encounter_id ="";
	String preRsLocation_code ="";
	String attend_practitioner_id ="";
	String preattend_practitioner_id ="";
	String specialty_desc ="";
	String bedNo="";//IN29413
	String nursing_unit_desc ="";
	String practitioner_name ="";
	String display_admission_date="";
	String control="";
	String max_cons_per_pract="";
	String max_cons_per_splty="";
	String cons_back_date="";
	String amd_cons_list="";
	String min_cons_duration="";
	String control_value="";
	String disabled="";
	String className1="";
	String splty_code="";
	String referral_id="";
	String lower_limit				=	"";	
	String upper_limit				=	"";
	StringBuffer query_string		=	new StringBuffer();
	int		rowCnt					=	0,		maxRecordsDisp		=	10;
	int		startIndex				=	0,		endIndex			=	0;
	int		totalRecordCount		=	0 ;
	String classValue = "QRYEVEN";
	int i = 0;
	boolean flag = true;
	int totChecked=0;
	int totDisabled=0;
		
	patientId			=	(request.getParameter("patientId")==null)	?	""	:	request.getParameter("patientId");
	practitionerId			=	(request.getParameter("practitionerId")==null)	?	""	:	request.getParameter("practitionerId");
	speciality_code			=	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");
	location_code			=	(request.getParameter("location_code")==null)	?	""	:	request.getParameter("location_code");
	service_code			=	(request.getParameter("service_code")==null)	?	""	:	request.getParameter("service_code");
	bedNo			=	(request.getParameter("bedNo")==null)	?	""	:	request.getParameter("bedNo");//IN29413	
	cons_date			=	(request.getParameter("cons_date")==null)	?	""	:	request.getParameter("cons_date");
	cons_time			=	(request.getParameter("cons_time")==null)	?	""	:	request.getParameter("cons_time");
	res_mode			=	(request.getParameter("res_mode")==null)	?	""	:	request.getParameter("res_mode");
	create_type			=	(request.getParameter("create_type")==null)	?	""	:	request.getParameter("create_type");
	lower_limit			=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
	upper_limit			=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");

	startIndex		=	Integer.parseInt(lower_limit);
	endIndex		=	Integer.parseInt(upper_limit);
	String restrictSearch = (request.getParameter("restrictSearch")==null)	?	"N"	:	request.getParameter("restrictSearch");//IN30050 
	String tempPractId = practitionerId;//IN30050
	
	query_string.append("practitionerId=");		query_string.append(practitionerId);
	query_string.append("&speciality_code=");	query_string.append(speciality_code);
	query_string.append("&bedNo=");	query_string.append(bedNo);//IN29413
	query_string.append("&location_code=");	query_string.append(location_code);
	query_string.append("&service_code=");	query_string.append(service_code);
	query_string.append("&patientId=");	query_string.append(patientId);
	query_string.append("&cons_date=");	query_string.append(cons_date);
	query_string.append("&cons_time=");	query_string.append(cons_time);
	query_string.append("&create_type=");	query_string.append(create_type);
	query_string.append("&restrictSearch=");	query_string.append(restrictSearch);//IN30050
	
	if(res_mode.equals("Next")||res_mode.equals("Back"))
	{ 
		bean_key			=	(request.getParameter("beankey")==null)	?	""	:	request.getParameter("beankey");
	}
	else
	{
		bean_key =practitionerId+cons_date+cons_time;
	}  	   
	
	//Added By Archana Dhal on 5/3/2010 related to IN021047.
	if(!locale.equals("en"))
	{
		cons_date	= com.ehis.util.DateUtils.convertDate(cons_date,"DMY",locale,"en");
		cons_time	= com.ehis.util.DateUtils.convertDate(cons_time,"HM",locale,"en");
	}	

	ipConsultListBean = (eCA.IPConsultationListBean)getObjectFromBean("ipConsultListBean"+bean_key,"eCA.IPConsultationListBean",session);
%>

	<body OnMouseDown='CodeArrest()' onload="loadNextButton();" onKeyDown="lockKey()">
		<form name='IPConsultationListResultForm' id='IPConsultationListResultForm' method='post' target='messageFrame' action='../../servlet/eCA.IPConsultationListServlet'>
<%
	if(res_mode.equals("Next"))
	{ 
%>
		<table class='grid' width="100%" align="center" name="resultTable"  id="dataTitleTable">
		<tr>
			<th class='columnHeadercenter' width='5%' align='left'><fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/><input type='checkbox' name='selectAllNext' id='selectAllNext' id='selectAllNext' onclick='selectAllChkNext()' checked value='Y'/></th><!--IN29413-->
			<th class='columnHeadercenter' align='left'><fmt:message key='Common.PatientDetails.label' bundle='${common_labels}'/></th>
			<th class='columnHeadercenter' width='15%' align='left'><fmt:message key='Common.admissiondate.label' bundle='${common_labels}'/></th>
			<th class='columnHeadercenter' width='20%' align='left'><fmt:message key='Common.Specialty.label' bundle='${common_labels}'/></th>
			<th class='columnHeadercenter' width='25%' align='left'><fmt:message key='Common.Location.label' bundle='${common_labels}'/></th>			
		</tr>
		</table>
		
		<div style='width:100%;height:93%;overflow:auto;position:absolute'>
		<table class='grid' align="center" name="resultTable"  id="dataTable" width="100%">
<%		
		String pract_qry ="select nvl(b.ATTEND_PRACTITIONER_ID,ADMIT_PRACTITIONER_ID) ATTEND_PRACTITIONER_ID ,am_get_desc.AM_PRACTITIONER(nvl(ATTEND_PRACTITIONER_ID,ADMIT_PRACTITIONER_ID),?,1)practitioner_name,am_get_desc.AM_SPECIALITY(b.SPECIALTY_CODE,?,2) SPECIALTY_DESC,b.SPECIALTY_CODE splty_code,IP_get_desc.IP_NURSING_UNIT(?,b.NURSING_UNIT_CODE,?,2) nursing_unit_desc from IP_OPEN_ENCOUNTER b where b.facility_id= ? and b.ENCOUNTER_ID =?";
		selectedList =	ipConsultListBean.returnConsList();
		Collections.sort(selectedList);		
		int listSize = selectedList.size();
		out.println("<input type='hidden' id='consultCntNext' name='consultCntNext' id='consultCntNext' value='"+listSize+"'");
		totChecked = listSize;//IN30050
		try
		{
			con =  ConnectionManager.getConnection(request);
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}

		if(listSize>0){
		for(int k=0; k<listSize; k++)
		{
			strVal = (String)selectedList.get(k);
			Tokens = new StringTokenizer(strVal,"~");
			rowCnt++;
			if(i % 2 == 0) 
				classValue = "QRYEVEN";
			else 
				classValue = "QRYODD";
			while(Tokens.hasMoreTokens())
			{
			Tokens.nextToken(); 
			rsLocation_code = (String) Tokens.nextToken();
			pline = (String) Tokens.nextToken();
			rsAdmission_date_time = (String) Tokens.nextToken();
			rsSpecialty_desc = (String) Tokens.nextToken();
			patient_id = (String) Tokens.nextToken();
			encounter_id = (String) Tokens.nextToken();
			Tokens.nextToken();

			try
			{
				stmt = con.prepareStatement(pract_qry);
				stmt.setString(1,locale);
				stmt.setString(2,locale);
				stmt.setString(3,facility_id);
				stmt.setString(4,locale);
				stmt.setString(5,facility_id);
				stmt.setString(6,encounter_id);
					
				rs = stmt.executeQuery();
				while(rs.next())
				{
					attend_practitioner_id = rs.getString("ATTEND_PRACTITIONER_ID")==null?"":rs.getString("ATTEND_PRACTITIONER_ID");
					specialty_desc = rs.getString("SPECIALTY_DESC")==null?"":rs.getString("SPECIALTY_DESC");
					nursing_unit_desc = rs.getString("nursing_unit_desc")==null?"":rs.getString("nursing_unit_desc");
					practitioner_name = rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");
					splty_code = rs.getString("splty_code")==null?"":rs.getString("splty_code");

				}

				if(rs!=null) rs.close();
				if(stmt!=null)stmt.close();

				//pract_key = attend_practitioner_id+"~"+specialty_desc+"~"+pline+"~"+rsAdmission_date_time+"~"+patient_id+"~"+encounter_id;
			if(create_type.equals("S"))
			{
				if(!attend_practitioner_id.equals(preattend_practitioner_id))
				{
					out.println("<tr ><td class='gridData' colspan='5' class=CAFOURTHLEVELCOLOR><font size=1>" +practitioner_name+ "</font></td></tr>");
				}
				
			}
			else
			{
				if(!rsLocation_code.equals(preRsLocation_code))
				{
					out.println("<tr ><td class='gridData' colspan='5' class=CAFOURTHLEVELCOLOR><font size=1>" +nursing_unit_desc+ "</font></td></tr>");
				}
			}
			 display_admission_date=com.ehis.util.DateUtils.convertDate(rsAdmission_date_time,"DMYHM","en",localeName);
	%>

			<tr>
				<td class='gridData' width='5%'><input type='checkbox' checked value='Y' name='consultChk<%=rowCnt%>' id='consultChk<%=rowCnt%>' id= 'consultChk<%=rowCnt%>'onClick="addToList(this,'<%=rowCnt%>','<%=pline%>','<%=rsAdmission_date_time%>','<%=rsSpecialty_desc%>','<%=rsLocation_code%>','<%=patient_id%>','<%=encounter_id%>','<%=attend_practitioner_id%>','<%=splty_code%>');"></td><!--IN29413-->
				<td class='gridData'>&nbsp;&nbsp;<%=java.net.URLDecoder.decode(pline,"UTF-8")%></td>
				<td class='gridData' width='15%'>&nbsp;&nbsp;<%=display_admission_date%></td>
				<td class='gridData' width='20%'>&nbsp;&nbsp;<%=specialty_desc%></td>
				<td class='gridData' width='25%'>&nbsp;&nbsp;<%=nursing_unit_desc%></td>
			</tr>
			<%
			}
			catch(Exception e)
			{
				e.printStackTrace();				

			}
			
		   }
			preRsLocation_code = rsLocation_code;
			preattend_practitioner_id = attend_practitioner_id;
			i++;
		}
		}
		else
		{	
%>		
			<tr>
				<td class='gridData'>APP-000052 No Records Found...</td>
			</tr>

<%		}
		if(con != null) ConnectionManager.returnConnection(con,request);
%>		
		</table>
		</div>
<%
		if(listSize==0)
		{
%>		</table>
		</div>
		<script>
			document.getElementById("selectAllNext").checked="";
			document.getElementById("selectAllNext").value="N";
		</script>	
<%		}
	}
	else 						   
	{	
		selectedList =	ipConsultListBean.returnConsList();
		
		control="select MAX_CONS_PER_PRACT MAX_CONS_PER_PRACT,MAX_CONS_PER_SPLTY MAX_CONS_PER_SPLTY,CONS_BACK_DATE CONS_BACK_DATE,AMD_CONS_LIST AMD_CONS_LIST,MIN_CONS_DURATION MIN_CONS_DURATION from ca_cons_param";
		//String speciality_query="select PRIMARY_SPECIALITY_CODE splty_code from am_practitioner where  practitioner_id=?";
		consListQry.append("select b.PATIENT_ID,b.ENCOUNTER_ID,get_patient.get_line_detail(b.PATIENT_ID,?)Pline,(select REFERRAL_ID from PR_REFERRAL_REGISTER where PATIENT_ID = b.PATIENT_ID and FROM_ENCOUNTER_ID =b.ENCOUNTER_ID and BEDSIDE_REFERRAL_YN ='Y' and status != 'C'  and rownum=1 and TO_PRACT_ID like ? )REFERRAL_ID, to_char(b.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME ,b.SPECIALTY_CODE,b.SPECIALTY_CODE  splty_code,am_get_desc.AM_SPECIALITY(b.SPECIALTY_CODE,?,2) SPECIALTY_DESC,IP_get_desc.IP_NURSING_UNIT(?,b.NURSING_UNIT_CODE,?,2) nursing_unit_desc,b.NURSING_UNIT_CODE,nvl(b.ATTEND_PRACTITIONER_ID,b.ADMIT_PRACTITIONER_ID) ATTEND_PRACTITIONER_ID,CA_GET_CONS_LIST_CONTROL(");//IN30050
		//if (create_type.equals("S"))
		consListQry.append("b.ATTEND_PRACTITIONER_ID");
		//else
		//consListQry.append("?");
		
		//IN033692 starts
		//consListQry.append(",b.SPECIALTY_CODE,?,b.facility_id,b.ENCOUNTER_ID,?,?,?,?) control_value from IP_OPEN_ENCOUNTER b where b.facility_id= ? ");//Commented for IN067769
		//consListQry.append(",b.SPECIALTY_CODE,?,b.facility_id,b.ENCOUNTER_ID,?,?,?,?) control_value from IP_OPEN_ENCOUNTER b,pr_referral_register prc WHERE b.facility_id= ? ");
		//IN033692 ends
		consListQry.append(",b.SPECIALTY_CODE,?,b.facility_id,b.ENCOUNTER_ID,?,?,?,?) control_value from IP_OPEN_ENCOUNTER b where b.facility_id= ? and b.encounter_id like '%%' ");//Modified for IN067769

		if(!speciality_code.equals(""))
			consListQry.append("and b.SPECIALTY_CODE=? ");
		if(!patientId.equals(""))
			consListQry.append("and b.PATIENT_ID =? ");

		if(!location_code.equals(""))
			consListQry.append("and b.NURSING_UNIT_CODE =? ");
		if(!service_code.equals(""))
			consListQry.append("and b.SERVICE_CODE=? "); //
		if(create_type.equals("S"))
			consListQry.append("and b.SPECIALTY_CODE like ?  "); //IN30050
		
		consListQry.append("AND UPPER(b.BED_NUM) LIKE UPPER(?)");//IN29413

		if (create_type.equals("S"))
		{
			consListQry.append("AND NOT EXISTS (SELECT 1 FROM CA_CONS_LIST_HDR IA, CA_CONS_LIST_DTL IB WHERE IA.PRACTITIONER_ID=b.ATTEND_PRACTITIONER_ID AND IA.CONS_DATE=TO_DATE(?,'DD/MM/YYYY') AND IB.CONS_REF_ID=IA.CONS_REF_ID AND IB.FACILITY_ID=B.FACILITY_ID AND IB.ENCOUNTER_ID=B.ENCOUNTER_ID and TO_DATE( TO_CHAR(CONS_DATE,'DD/MM/YYYY')||' '|| CONS_TIME,'DD/MM/YYYY HH24:MI') between  TO_DATE(?||' '|| ?,'DD/MM/YYYY HH24:MI') -(?/1440) and  TO_DATE( ?||' '|| ?,'DD/MM/YYYY HH24:MI')+(?/1440))"); 
		}
		else
		{
			//if(create_type.equals("P"))
			consListQry.append("and (b.ATTEND_PRACTITIONER_ID like ?  "); //IN30050

			if(create_type.equals("O"))
				consListQry.append("or b.ATTEND_PRACTITIONER_ID like ?  "); //P_MIN_CONS_DURATION

			//consListQry.append(" or exists (select 1 from PR_REFERRAL_REGISTER where FROM_FACILITY_ID = B.FACILITY_ID AND FROM_ENCOUNTER_ID = b.encounter_id AND TO_PRACT_ID like ? AND BEDSIDE_REFERRAL_YN='Y' and status != 'C' )) AND NOT EXISTS (SELECT 1 FROM CA_CONS_LIST_HDR IA, CA_CONS_LIST_DTL IB WHERE IA.PRACTITIONER_ID like ? AND IA.CONS_DATE=TO_DATE(?,'DD/MM/YYYY') AND IB.CONS_REF_ID=IA.CONS_REF_ID AND IB.FACILITY_ID=B.FACILITY_ID AND IB.ENCOUNTER_ID=B.ENCOUNTER_ID AND  TO_DATE( TO_CHAR(CONS_DATE,'DD/MM/YYYY')||' '|| CONS_TIME,'DD/MM/YYYY HH24:MI') between  TO_DATE(?||' '|| ?,'DD/MM/YYYY HH24:MI') -(?/1440) and  TO_DATE( ?||' '|| ?,'DD/MM/YYYY HH24:MI')+(?/1440))  "); //P_MIN_CONS_DURATION//Added status condition - IN033692
			consListQry.append(" or exists (select 1 from PR_REFERRAL_REGISTER where FROM_FACILITY_ID = B.FACILITY_ID AND FROM_ENCOUNTER_ID = b.encounter_id and facility_id= ? AND TO_PRACT_ID like ? AND BEDSIDE_REFERRAL_YN='Y' and status != 'C' )) AND NOT EXISTS (SELECT 1 FROM CA_CONS_LIST_HDR IA, CA_CONS_LIST_DTL IB WHERE IA.PRACTITIONER_ID like ? AND IA.CONS_DATE=TO_DATE(?,'DD/MM/YYYY') AND IB.CONS_REF_ID=IA.CONS_REF_ID AND IB.FACILITY_ID=B.FACILITY_ID AND IB.ENCOUNTER_ID=B.ENCOUNTER_ID AND  TO_DATE( TO_CHAR(CONS_DATE,'DD/MM/YYYY')||' '|| CONS_TIME,'DD/MM/YYYY HH24:MI') between  TO_DATE(?||' '|| ?,'DD/MM/YYYY HH24:MI') -(?/1440) and  TO_DATE( ?||' '|| ?,'DD/MM/YYYY HH24:MI')+(?/1440))  "); //Modified for IN067769
		}

		//consListQry.append(" and b.ADMISSION_DATE_TIME <= to_date(?||' '|| ?,'DD/MM/YYYY HH24:MI') "); //Added By Archana Dhal on 5/3/2010 related to IN021047.//CHANGES INCLUDED FOR GET ACCESS RULE
		//consListQry.append(" and b.ADMISSION_DATE_TIME <= to_date(?||' '|| ?,'DD/MM/YYYY HH24:MI') AND 'Y'=OR_GET_ACCESS_RULE(B.facility_id,B.encounter_id,'CN',B.patient_class,to_char(B.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI'),     (select to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') from pr_encounter where facility_id = b.facility_id and encounter_id = b.encounter_id),(SELECT to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=B.FACILITY_ID   and ENCOUNTER_ID=B.encounter_id AND DIS_ADV_STATUS in('0','1') and rownum <=1)) "); //CHANGES INCLUDED FOR GET ACCESS RULE//Commented for IN067769
		consListQry.append(" and b.ADMISSION_DATE_TIME <= to_date(?||' '|| ?,'DD/MM/YYYY HH24:MI') AND 'Y'=OR_GET_ACCESS_RULE(B.facility_id,B.encounter_id,'CN',B.patient_class,to_char(B.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI'),     (select to_char(DISCHARGE_DATE_TIME,'DD/MM/YYYY HH24:MI') from pr_encounter where facility_id = b.facility_id and facility_id= ? and encounter_id = b.encounter_id),(SELECT to_char(DIS_ADV_DATE_TIME,'DD/MM/YYYY HH24:MI') FROM IP_DISCHARGE_ADVICE WHERE FACILITY_ID=B.FACILITY_ID   and ENCOUNTER_ID=B.encounter_id and facility_id= ? AND DIS_ADV_STATUS in('0','1') and rownum <=1)) "); //Modified for IN067769
		//IN033692 starts
		//consListQry.append("and prc.from_encounter_id = b.ENCOUNTER_ID(+) and prc.status != 'C' ");
		//IN033692 ends
		try																					  
		{
			con =  ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(control);
			prs = pstmt.executeQuery();
			while(prs.next())
			{
				max_cons_per_pract=prs.getString("MAX_CONS_PER_PRACT");
				max_cons_per_splty=prs.getString("MAX_CONS_PER_SPLTY");
				cons_back_date=prs.getString("CONS_BACK_DATE");
				amd_cons_list=prs.getString("AMD_CONS_LIST");
				min_cons_duration=prs.getString("MIN_CONS_DURATION");
			}

			if(prs!=null) 
				prs.close();
			if(pstmt!=null)
				pstmt.close();
			
			if(restrictSearch.equals("Y"))//IN30050
				practitionerId="%";//IN30050
			stmt = con.prepareStatement(consListQry.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			int count1=0;
			stmt.setString(++count1,locale);
			stmt.setString(++count1,practitionerId);//IN30050
			stmt.setString(++count1,locale);
			stmt.setString(++count1,facility_id);
			stmt.setString(++count1,locale);
			//if (!create_type.equals("S"))
			//stmt.setString(++count1,practitionerId);
			//stmt.setString(++count1,splty_code);
			stmt.setString(++count1,cons_date);
			stmt.setString(++count1,cons_time);
			stmt.setString(++count1,max_cons_per_pract);
			stmt.setString(++count1,max_cons_per_splty);
			stmt.setString(++count1,min_cons_duration);
			stmt.setString(++count1,facility_id);
			
			if(!speciality_code.equals(""))
			{
				stmt.setString(++count1,speciality_code);
			}	 
			
			if(!patientId.equals(""))
			{
			   stmt.setString(++count1,patientId);
			}
			
			if(!location_code.equals(""))
			{
				stmt.setString(++count1,location_code);
			}
			
			if(!service_code.equals(""))
			{
				stmt.setString(++count1,service_code);
			}
			 
			if(create_type.equals("S"))
			{
				stmt.setString(++count1,practitionerId); // value is speciality only
			}
			if(bedNo.equals(""))//IN30050
				bedNo="%";//IN30050
			stmt.setString(++count1,bedNo);//IN29413

			if (create_type.equals("S"))
			{
				//stmt.setString(++count1,practitionerId);
				stmt.setString(++count1,cons_date);
				stmt.setString(++count1,cons_date);
				stmt.setString(++count1,cons_time);
				stmt.setString(++count1,min_cons_duration);
				stmt.setString(++count1,cons_date);
				stmt.setString(++count1,cons_time);
				stmt.setString(++count1,min_cons_duration);
			}
			else
			{	
				//if(create_type.equals("P"))
				stmt.setString(++count1,practitionerId);
				
				if(create_type.equals("O"))
				{
					stmt.setString(++count1,ca_practitioner_id);
				}	
				stmt.setString(++count1,facility_id);//IN067769
				stmt.setString(++count1,practitionerId);
				stmt.setString(++count1,practitionerId);
				stmt.setString(++count1,cons_date);
				stmt.setString(++count1,cons_date);
				stmt.setString(++count1,cons_time);
				stmt.setString(++count1,min_cons_duration);
				stmt.setString(++count1,cons_date);
				stmt.setString(++count1,cons_time);
				stmt.setString(++count1,min_cons_duration);
			}
			//Below set strings added by Archana Dhal on 5/3/2010 related to IN021047.
			stmt.setString(++count1,cons_date);
			stmt.setString(++count1,cons_time);
			stmt.setString(++count1,facility_id);//IN067769
			stmt.setString(++count1,facility_id);//IN067769
					
			rs = stmt.executeQuery();

			rs.last();
			totalRecordCount	=	rs.getRow();
			rs.beforeFirst();
	
			if( totalRecordCount>maxRecordsDisp)
			{
%>
				<table  class='grid' WIDTH='100%' align='center'  >
				<tr><td CLASS='gridData' >&nbsp;</td>	
<%
				if(startIndex>maxRecordsDisp)
				{
%>
					<td class='gridData'  width='8%'><a class='gridLink' href="../../eCA/jsp/IPConsultationListResult.jsp?lower_limit=<%=(startIndex-maxRecordsDisp)%>&upper_limit=<%=(endIndex-maxRecordsDisp)%>&<%=query_string.toString()%>&res_mode=res_prev" style="text-decoration:none;  font-weight:bold"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
<%
				}
				if(totalRecordCount>endIndex)
				{
%>
					<td class='gridData' align='center' width='8%'><a class='gridLink' href="../../eCA/jsp/IPConsultationListResult.jsp?lower_limit=<%=(startIndex+maxRecordsDisp)%>&upper_limit=<%=(endIndex+maxRecordsDisp)%>&<%=query_string.toString()%>&res_mode=res_next" style="text-decoration:none; font-weight:bold"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
<%
				}
%>
				</tr></table>
<%
			}
%>
	<table class='grid'  width="100%" align="center" name="resultTable"  id="dataTitleTable">
		<tr>
			<th class='columnHeadercenter' width='5%' align='left'><fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/><input type='checkbox' name='selectAll' id='selectAll' id='selectAll' onclick='selectAllChk()' checked value='Y'/></th><!--IN29413-->
			<th class='columnHeadercenter' align='left'>&nbsp;<fmt:message key='Common.PatientDetails.label' bundle='${common_labels}'/></th>
			<th class='columnHeadercenter' width='15%' align='left'><fmt:message key='Common.admissiondate.label' bundle='${common_labels}'/></th>
			<th class='columnHeadercenter' width='20%' align='left'><fmt:message key='Common.Specialty.label' bundle='${common_labels}'/></th>
			<th class='columnHeadercenter' width='25%' align='left'><fmt:message key='Common.Location.label' bundle='${common_labels}'/></th>
		</tr>
	</table>
	<table class='grid'  width="100%" align="center" name="resultTable" id="dataTable" >

<%

	if(startIndex>1)
		rs.absolute((startIndex-1));
	
	while(rs.next())
	{
		if(i % 2 == 0) 
			classValue = "QRYEVEN";
		else 
			classValue = "QRYODD";	
		
		flag = false ;
		rowCnt++;
		
		patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
		encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
		pline = rs.getString("Pline")==null?"":rs.getString("Pline");
		pline =pline.replaceAll("\\|",",");
		referral_id = rs.getString("REFERRAL_ID")==null?"":rs.getString("REFERRAL_ID");
		rsAdmission_date_time = rs.getString("ADMISSION_DATE_TIME")==null?"":rs.getString("ADMISSION_DATE_TIME");
		rsSpecialty_code = rs.getString("SPECIALTY_CODE")==null?"":rs.getString("SPECIALTY_CODE");
		rsSpecialty_desc = rs.getString("SPECIALTY_DESC")==null?"":rs.getString("SPECIALTY_DESC");
		rsLocation_code = rs.getString("NURSING_UNIT_CODE")==null?"":rs.getString("NURSING_UNIT_CODE");
		nursing_unit_desc = rs.getString("nursing_unit_desc")==null?"":rs.getString("nursing_unit_desc");
		attend_practitioner_id = rs.getString("ATTEND_PRACTITIONER_ID")==null?"":rs.getString("ATTEND_PRACTITIONER_ID");
		control_value = rs.getString("control_value")==null?"":rs.getString("control_value");
		splty_code = rs.getString("splty_code")==null?"":rs.getString("splty_code");
		
		//arrVal = rsLocation_code+"~"+pline+"~"+rsAdmission_date_time+"~"+rsSpecialty_code+"~"+patient_id+"~"+encounter_id;

		if(create_type.equals("S"))
		{
			arrVal = attend_practitioner_id+"~"+rsLocation_code+"~"+java.net.URLEncoder.encode(pline,"UTF-8")+"~"+rsAdmission_date_time+"~"+rsSpecialty_code+"~"+patient_id+"~"+encounter_id+"~"+splty_code;
		}
		else
		{
			arrVal = rsLocation_code+"~"+rsLocation_code+"~"+java.net.URLEncoder.encode(pline,"UTF-8")+"~"+rsAdmission_date_time+"~"+rsSpecialty_code+"~"+patient_id+"~"+encounter_id+"~"+splty_code;
		} 		
		if(res_mode.equals(""))
		{
			if(!control_value.equals(""))
			{
				disabled="disabled";
				checked ="";
				totDisabled++;
			}
			else
			{
				disabled="";
				checked ="checked";
				totChecked++;
				if(!ipConsultListBean.returnConsList().contains(arrVal))
				{
					ipConsultListBean.addtoConsList(arrVal);
				}
			}
		}
		else
		{
			if(!control_value.equals(""))
			{
				disabled="disabled";
				totDisabled++;
			}
			else
			{
				disabled="";
			}
			
			
			if(selectedList.contains(arrVal))
			{
				checked ="checked";
				totChecked++;
			}
			else
			{
				checked ="";
			}
		}
		
		if(control_value.equals("DURN"))
		{
			className1="IVINGREDIENT1";
		}
		else if(control_value.equals("PRACT"))
		{
			className1="IVFLUID1";
		}
		else if(control_value.equals("SPLTY"))
		{
			className1="QRY9";
		}
		else
		{
			className1=classValue;
		} 		
		
		display_admission_date=com.ehis.util.DateUtils.convertDate(rsAdmission_date_time,"DMYHM","en",localeName);
%>
		<tr>
			<td class='gridData' width='5%'><input type='checkbox' name='consultChk<%=rowCnt%>' id='consultChk<%=rowCnt%>' id='consultChk<%=rowCnt%>' onClick="addToList(this,'<%=rowCnt%>','<%=java.net.URLEncoder.encode(pline,"UTF-8")%>','<%=rsAdmission_date_time%>','<%=rsSpecialty_code%>','<%=rsLocation_code%>','<%=patient_id%>','<%=encounter_id%>','<%=attend_practitioner_id%>','<%=splty_code%>');"<%=checked%><%=disabled%>></td><!--IN29413-->
<%
		if(referral_id.equals(""))
		{
%>
			<td class='gridData'>&nbsp;<%=pline%></td>
<%
		}
		else
		{
%>
			<td class='gridData'><%=pline%>
			<a class='gridLink' href="javascript:callBedSideRefferal('<%=referral_id%>')"> <b>&nbsp;&nbsp;&nbsp;<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedSideReferral.label","common_labels")%> </b></a> </td>
<%
		}
%>
			<td class='gridData' width='15%'><%=display_admission_date%></td>
			<td class='gridData' width='20%'><%=rsSpecialty_desc%></td>
			<td class='gridData' width='25%'><%=nursing_unit_desc%></td>		
		</tr>	
<%
		i++;

		if(rowCnt>=maxRecordsDisp) 
			break;
	}
%>
	
	<% 
	putObjectInBean("ipConsultListBean"+bean_key,ipConsultListBean,session);
%>
	
	<tr  style='visibility:hidden' >
			<td> <fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/></td>
			<td><fmt:message key='Common.PatientDetails.label' bundle='${common_labels}'/></td>
			<td><fmt:message key='Common.admissiondate.label' bundle='${common_labels}'/></td>
			<td><fmt:message key='Common.Specialty.label' bundle='${common_labels}'/></td>
			<td><fmt:message key='Common.Location.label' bundle='${common_labels}'/></td>			
	</tr>
	</table>
<%	
			if(rs!=null) 
				rs.close();
			if(stmt!=null)
				stmt.close();	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			ConnectionManager.returnConnection(con,request);
		}
		if(flag)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script>parent.IPConsultationListResultFrame.location.href='../../eCommon/html/blank.html';</script>");
		}
	}
	practitionerId = tempPractId;
	
%>
	
		<input type='hidden' name='bean_key' id='bean_key' value="<%=bean_key%>">
		<input type='hidden' name='queryString' id='queryString' value="<%=queryString%>">
		<input type='hidden' name='create_type' id='create_type' value="<%=create_type%>">
		<input type='hidden' name='cons_date' id='cons_date' value="<%=cons_date%>">
		<input type='hidden' name='cons_time' id='cons_time' value="<%=cons_time%>">
		<input type='hidden' name='cons_list_desc' id='cons_list_desc' value="">
		<input type='hidden' name='practitionerId' id='practitionerId' value="<%=practitionerId%>">
		<input type='hidden' name='servMode' id='servMode' value="insert">
		<input type='hidden' name='consultCnt' id='consultCnt' value='<%=rowCnt%>'>
		<input type='hidden' name='bedNo' id='bedNo' value='<%=bedNo%>'>
		<input type='hidden' name='totChecked' id='totChecked' value='<%=totChecked%>'>
		<input type='hidden' name='totDisabled' id='totDisabled' value='<%=totDisabled%>'>
		</form>
		<script>
			alignWidth();
			totRecords=document.getElementById("consultCnt").value;
			if(document.getElementById("selectAll")!=null)
			{
				for(i=1;i<=totRecords;i++)
				{
					var clicker = document.getElementById('consultChk'+i);
					if(clicker.disabled == false)
					{
						if(!clicker.checked)
						{
							document.getElementById("selectAll").checked='';
							break;
						}
					}
				}
				if(totRecords == parseInt(document.getElementById("totDisabled").value)+parseInt(document.getElementById("totChecked").value)  )
				{
					document.getElementById("selectAll").checked='checked';
				}
			}
			else if(document.getElementById("selectAllNext")!=null)
			{
				for(i=1;i<=totRecords;i++)
				{
					var clicker = document.getElementById('consultChk'+i);
					if(clicker.disabled == false)
					{
						if(!clicker.checked)
						{
							document.getElementById("selectAllNext").checked='';
							break;
						}
					}
				}
				
				if(totRecords==0)
				{
					document.getElementById("selectAllNext").checked='';
					document.getElementById("selectAllNext").value='N';
				}
				else
				{
					if(totRecords == parseInt(document.getElementById("totDisabled").value)+parseInt(document.getElementById("totChecked").value))
					{
						document.getElementById("selectAllNext").checked='checked';
						document.getElementById("selectAllNext").value='Y';
					}
				}
			}
		if(document.getElementById("selectAll")!=null){
		var totDisabled=0;
		for(i=1;i<=document.getElementById("consultCnt").value;i++)  
		{
			var clicker = document.getElementById('consultChk'+i+);
			
			if(clicker.disabled == true)
			{
				totDisabled=totDisabled+1;
			}
		}
		document.getElementById("totDisabled").value=totDisabled;
		//alert(parseInt(document.getElementById("consultCnt").value)+" "+parseInt(document.getElementById("totChecked").value));
		if(parseInt(document.getElementById("totDisabled").value)==parseInt(document.getElementById("consultCnt").value))
		{
			document.getElementById("selectAll").checked='';
			document.getElementById("selectAll").value='N';
		}
		else
		{
			if(parseInt(document.getElementById("consultCnt").value)==parseInt(document.getElementById("totChecked").value)+parseInt(document.getElementById("totDisabled").value))
			{
				document.getElementById("selectAll").checked='checked';
				document.getElementById("selectAll").value='Y';
			}
		}
		}
		</script>
  </body>
</html>

