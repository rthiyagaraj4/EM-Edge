<!DOCTYPE html>
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
		//String ca_practitioner_id		=	(String) session.getValue("ca_practitioner_id");
		String resp_id = (String)session.getValue("responsibility_id");
		eCA.PatientBannerGroupLine multiTransBean = null;
		//String queryString = request.getQueryString();


	%>
	
		<link	rel='StyleSheet'	  href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"> </script>
		<script language='javascript' src='../../eCommon/js/common.js' >		 </script>
		<script Language="JavaScript" src='../../eCA/js/MultiTransRequest.js'>	 </script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js">		 </script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

	<%
	
		Connection con = null;
		PreparedStatement stmt=null;
		//PreparedStatement pstmt=null;
		ResultSet rs=null;
		//ResultSet prs=null;
	
		//ArrayList selectedList =new ArrayList(); 

		StringBuffer query_string	 =	new StringBuffer();
		StringBuffer transReqQry	 =	new StringBuffer();
		//StringTokenizer Tokens		 =	null ;
		String patientId			 =	"";
		String practitionerId		 =	"";
		String speciality_code		 =	"";
		String location_code		 =	"";
		String service_code			 =	"";
		//String cons_date			 =	"";
		//String cons_time			 =	"";
		String create_type			 =	"";
		String bean_key				 =	"";
		String res_mode				 =	"";
		//String strVal				 =	"";
		//String checked				 =	"";
		//String arrVal				 =	"";
		String pline				 =	"";
		String rsAdmission_date_time =	"";
		//String rsSpecialty_code		 =	"";
		//String rsSpecialty_desc		 =	"";
		//String rsLocation_code		 =	"";
		String patient_id			 =	"";
		String encounter_id			 =	"";
		//String preRsLocation_code	 =	"";
		String attend_practitioner_id =	"";
		//String preattend_practitioner_id ="";
		//String specialty_desc		 =	"";
		//String nursing_unit_desc	 =	"";
		//String practitioner_name	 =	"";
		String display_admission_date=	"";
		//String control				 =	"";
		//String max_cons_per_pract	 =	"";
		//String max_cons_per_splty	 =	"";
		//String cons_back_date		 =	"";
		//String amd_cons_list		 =	"";
		//String min_cons_duration	 =	"";
		//String control_value		 =	"";
		//String disabled				 =	"";
		//String className1			 =	"";
		//String splty_code			 =	"";
		String referral_id			 =	"";
		String lower_limit			 =	"";	
		String upper_limit			 =	"";
		String hash_key				 =	"";
		String chkBxStat			 =	"";
		String default_transcriber	 =	"";
		String default_transcriber_desc	 =	"";
		String def_trans_chk		 =	"";
		String default_note			 =	"";
		String def_note_chk			 =	"";
		String locn_code			 =	"";
		String locn_type			 =	"";
		String locn_name			 =	"";
		String pre_locn_code		 =	"";
		String locn_type_desc		 =	"";
		String CurrentDate			 =	"";
		String CurrentTime			 =	"";
		String locn_type_crit		 =	"";
		String viewlist				 =	"";
		String tr = "";
		String tr_vals[]			 =  new String[2];
		int		rowCnt					=	0,		maxRecordsDisp		=	10;
		int		startIndex				=	0,		endIndex			=	0;
		int		totalRecordCount		=	0;
		int		i						=	0;
		boolean flag = true;
		
		String count = "0";
		int chCount= 0;
		ArrayList transcriber_arr = new ArrayList();
		ArrayList notes_arr = new ArrayList();

		patientId			=	(request.getParameter("patientId")==null)	?	""	:	request.getParameter("patientId");
		practitionerId			=	(request.getParameter("practitionerId")==null)	?	""	:	request.getParameter("practitionerId");
		speciality_code			=	(request.getParameter("speciality_code")==null)	?	""	:	request.getParameter("speciality_code");
		location_code			=	(request.getParameter("location_code")==null)	?	""	:	request.getParameter("location_code");
		service_code			=	(request.getParameter("service_code")==null)	?	""	:	request.getParameter("service_code");
		create_type			=	(request.getParameter("create_type")==null)	?	""	:	request.getParameter("create_type");
		res_mode			=	(request.getParameter("res_mode")==null)	?	""	:	request.getParameter("res_mode");
		locn_type_crit			=	(request.getParameter("locn_type")==null)	?	""	:	request.getParameter("locn_type");
		viewlist			=	(request.getParameter("viewlist")==null)	?	""	:	request.getParameter("viewlist");
		
		//count			=	(request.getParameter("selcount")==null)	?	"0"	:	request.getParameter("selcount");


		lower_limit			=	(request.getParameter("lower_limit")==null)	?	"1"					:	request.getParameter("lower_limit");
		upper_limit			=	(request.getParameter("upper_limit")==null)	?	(""+maxRecordsDisp)	:	request.getParameter("upper_limit");

		startIndex		=	Integer.parseInt(lower_limit);
		endIndex		=	Integer.parseInt(upper_limit);

		CurrentDate	= (request.getParameter("CurrentDate")==null)	?	""	:	request.getParameter("CurrentDate");

		CurrentTime	= (request.getParameter("CurrentTime")==null)	?	""	:	request.getParameter("CurrentTime");
	
		if(res_mode.equals("Next")||res_mode.equals("Prev"))
		{
			bean_key			=	(request.getParameter("bean_key")==null)	?	""	:	request.getParameter("bean_key");

		}
		else
		{
			bean_key = practitionerId+CurrentDate+CurrentTime;
		}



		query_string.append("practitionerId=");		query_string.append(practitionerId);
		query_string.append("&speciality_code=");	query_string.append(speciality_code);
		query_string.append("&location_code=");	query_string.append(location_code);
		query_string.append("&service_code=");	query_string.append(service_code);
		query_string.append("&patientId=");	query_string.append(patientId);
		query_string.append("&create_type=");	query_string.append(create_type);
		query_string.append("&locn_type=");	query_string.append(locn_type_crit);
		query_string.append("&viewlist=");	query_string.append(viewlist);

		String transcriber_qry = "select PRACTITIONER_ID, PRACTITIONER_NAME from AM_PRACTITIONER_LANG_VW where LANGUAGE_ID = ? order by 2";

		String noteType_qry="select a.note_type_desc description, a.note_type code from  ca_note_type a,ca_note_group c where a.NOTE_GROUP_ID=c.NOTE_GROUP and c.TRANSCRIPTION_YN='Y' and (a.note_type in (select b.note_type_id from CA_NOTE_TYPE_FOR_RESOURCE b where b.note_type_id = a.note_type and b.resource_code = ? AND  EXISTS (SELECT 1 FROM ca_note_type_for_resp c WHERE a.note_type = c.note_type   AND c.resp_id = ?  AND c.privilege_type != '5' )) or a.NOTE_TYPE in  (select d.NOTE_TYPE from CA_NOTE_TYPE_FOR_RESP d where d.NOTE_TYPE = a.NOTE_TYPE and d.RESP_ID = ? and d.PRIVILEGE_TYPE!=5)) order by 1";

		multiTransBean = (eCA.PatientBannerGroupLine)getObjectFromBean("multiTransBean"+bean_key,"eCA.PatientBannerGroupLine",session);
	
	%>

		<body onScroll='scrollTitle()' OnMouseDown='CodeArrest()' onload="" onKeyDown="lockKey()">
		<form name='MultiTransRequestResultForm' id='MultiTransRequestResultForm' method='post' target='messageFrame' action='../../servlet/eCA.MultiTransRequestServlet'>
		<!--<div id='divDataTitle' style='postion:relative'> -->
	<%
		transReqQry.append("select b.PATIENT_ID,b.ENCOUNTER_ID,get_patient.get_line_detail(b.PATIENT_ID,?) Pline,REFERRAL_ID, to_char(b.ADMISSION_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME , AM_GET_DESC.AM_PRACTITIONER(nvl(b.ATTEND_PRACTITIONER_ID,b.ADMIT_PRACTITIONER_ID),?,'1') ATTEND_PRACTITIONER_ID,CA_GET_DEFAULT_TRANSCRIBER(?,b.SPECIALTY_CODE,b.PATIENT_CLASS) DEFAULT_TRANSCRIBER,AM_GET_DESC.AM_PRACTITIONER(CA_GET_DEFAULT_TRANSCRIBER(?,b.SPECIALTY_CODE,b.PATIENT_CLASS),?,'1') DEFAULT_TRANSCRIBER_DESC,CA_GET_DEFAULT_NOTES(?,?,b.SPECIALTY_CODE) DEFAULT_NOTE,PAT_CURR_LOCN_CODE LOCN_CODE, PAT_CURR_LOCN_TYPE LOCN_TYPE ,IP_GET_DESC.IP_NURSING_UNIT(?,b.PAT_CURR_LOCN_CODE,?,'1') locn_name  from IP_OPEN_ENCOUNTER b where  b.facility_id= ?  ");
		//viewlist and b.ATTEND_PRACTITIONER_ID= ?
		if(viewlist.equals("P"))
			transReqQry.append(" and b.ATTEND_PRACTITIONER_ID= ? ");
		else if(viewlist.equals("R"))
			transReqQry.append(" and patient_id in (select patient_id from CA_ENCNTR_PRACT_RELN f where f.PRACTITIONER_ID = ? and f.STATUS ='01' and FACILITY_ID= ? AND NVL(b.ENCOUNTER_ID,0) = NVL(f.ENCOUNTER_ID,0) AND SYSDATE BETWEEN BEGIN_DATE_TIME and nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY'))  )");

		if(!speciality_code.equals(""))
			transReqQry.append("and b.SPECIALTY_CODE=? ");
		if(!patientId.equals(""))
			transReqQry.append("and b.PATIENT_ID =? ");
		
		if(!locn_type_crit.equals(""))
			transReqQry.append("and PAT_CURR_LOCN_TYPE = ? ");
				

		if(!location_code.equals(""))
			transReqQry.append("and b.NURSING_UNIT_CODE =? ");
		if(!service_code.equals(""))
			transReqQry.append("and b.SERVICE_CODE=? "); //

		   transReqQry.append(" UNION ALL SELECT a.PATIENT_ID,a.ENCOUNTER_ID,get_patient.get_line_detail(a.PATIENT_ID,?) Pline,'' REFERRAL_ID, to_char(a.ARRIVE_DATE_TIME,'DD/MM/YYYY HH24:MI') ADMISSION_DATE_TIME, AM_GET_DESC.AM_PRACTITIONER( PRACTITIONER_ID,?,'1') ATTEND_PRACTITIONER_ID,CA_GET_DEFAULT_TRANSCRIBER(?,a.SPECIALITY_CODE,a.PATIENT_CLASS) DEFAULT_TRANSCRIBER,AM_GET_DESC.AM_PRACTITIONER(CA_GET_DEFAULT_TRANSCRIBER(?,a.SPECIALITY_CODE,a.PATIENT_CLASS),?,'1') DEFAULT_TRANSCRIBER_DESC,CA_GET_DEFAULT_NOTES(?,?,a.SPECIALITY_CODE) DEFAULT_NOTE,PAT_CURR_LOCN_CODE LOCN_CODE, PAT_CURR_LOCN_TYPE LOCN_TYPE,OP_GET_DESC.OP_CLINIC(?,a.PAT_CURR_LOCN_CODE,?,'1') locn_name from op_patient_queue a where a.QUEUE_DATE between trunc(sysdate)  and trunc(sysdate) + 1 and   a.FACILITY_ID=? "); //and a.PRACTITIONER_ID=?
		
		if(viewlist.equals("P"))
			transReqQry.append(" and a.PRACTITIONER_ID=? ");
		else if(viewlist.equals("R"))
			transReqQry.append(" and patient_id in (select patient_id from CA_ENCNTR_PRACT_RELN f where f.PRACTITIONER_ID = ? and f.STATUS ='01' and FACILITY_ID= ? AND NVL(a.ENCOUNTER_ID,0) = NVL(f.ENCOUNTER_ID,0) AND SYSDATE BETWEEN BEGIN_DATE_TIME and nvl(end_date_time,to_date('31/12/3000','DD/MM/YYYY')) )");


		if(!speciality_code.equals(""))
			transReqQry.append("and a.SPECIALITY_CODE=? "); //SPECIALITY_CODE
		if(!patientId.equals(""))
			transReqQry.append("and a.PATIENT_ID =? ");
		if(!locn_type_crit.equals(""))
			transReqQry.append("and PAT_CURR_LOCN_TYPE = ? ");

		if(!location_code.equals(""))
			transReqQry.append("and a.PAT_CURR_LOCN_CODE =? ");
		if(!service_code.equals(""))
			transReqQry.append("and a.SERVICE_CODE=? "); //

			transReqQry.append(" Order By LOCN_CODE ");
	

		try
		{
			
			con =  ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(transcriber_qry);
			stmt.setString(1,locale);
			rs = stmt.executeQuery();

			while(rs.next())
			{
			 	transcriber_arr.add(rs.getString("PRACTITIONER_ID")+"~"+rs.getString("PRACTITIONER_NAME"));
			}

			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();

			stmt = con.prepareStatement(noteType_qry);
			stmt.setString(1,practitionerId);
			stmt.setString(2,resp_id);
			stmt.setString(3,resp_id);
			rs = stmt.executeQuery();

			while(rs.next())
			{
			
				notes_arr.add(rs.getString("CODE")+"~"+rs.getString("DESCRIPTION"));
				
			}

			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();

			stmt = con.prepareStatement(transReqQry.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			int count1=0;

			stmt.setString(++count1,locale);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,practitionerId);
			//new
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,locale);
			//new
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,resp_id);
			stmt.setString(++count1,facility_id);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,facility_id);
			if(viewlist.equals("P"))
			{
			stmt.setString(++count1,practitionerId);
			}
			else if(viewlist.equals("R"))
			{
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,facility_id);

			}
			
			if(!speciality_code.equals(""))
				stmt.setString(++count1,speciality_code);
			if(!patientId.equals(""))
				stmt.setString(++count1,patientId);
			if(!locn_type_crit.equals(""))
				stmt.setString(++count1,locn_type_crit);
			if(!location_code.equals(""))
				stmt.setString(++count1,location_code);
			if(!service_code.equals(""))
				stmt.setString(++count1,service_code);

			stmt.setString(++count1,locale);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,practitionerId);
			//new
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,locale);
			//new
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,resp_id);
			stmt.setString(++count1,facility_id);
			stmt.setString(++count1,locale);
			stmt.setString(++count1,facility_id);
			if(viewlist.equals("P"))
			{
			stmt.setString(++count1,practitionerId);
			}
			else if(viewlist.equals("R"))
			{
			stmt.setString(++count1,practitionerId);
			stmt.setString(++count1,facility_id);

			}


			if(!speciality_code.equals(""))
				stmt.setString(++count1,speciality_code);
			if(!patientId.equals(""))
				stmt.setString(++count1,patientId);
			if(!locn_type_crit.equals(""))
				stmt.setString(++count1,locn_type_crit);
			if(!location_code.equals(""))
				stmt.setString(++count1,location_code);
			if(!service_code.equals(""))
				stmt.setString(++count1,service_code);
		
			rs = stmt.executeQuery();
			rs.last();
			totalRecordCount	=	rs.getRow();
			rs.beforeFirst();

			if( totalRecordCount>maxRecordsDisp)
			{

	%>
			<table  class='grid' WIDTH='100%' align='center'  >
			<tr>
				<td CLASS='gridData' >&nbsp;</td>
	<%
			if(startIndex>maxRecordsDisp)
			{
	%>
				<td class='gridData'  width='8%'><a class='gridLink' href="javascript:submitPrevNext('<%=(startIndex-maxRecordsDisp)%>','<%=(endIndex-maxRecordsDisp)%>','<%=query_string.toString()%>')" style="text-decoration:none;  font-weight:bold"><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
	<%
			}
			if(totalRecordCount>endIndex)
			{
	%>
				<td class='gridData' align='center' width='8%'><a class='gridLink' href="javascript:submitPrevNext('<%=(startIndex+maxRecordsDisp)%>','<%=(endIndex+maxRecordsDisp)%>','<%=query_string.toString()%>')" style="text-decoration:none; font-weight:bold"><fmt:message key="Common.next.label" bundle="${common_labels}"/></a></td>
	<%
			}
	%>
			</tr></table>
	<%
			}
	%>
		<table class='grid'  width="100%" align="center" name="resultTable" id="resultTable" id="dataTitleTable">
			<tr>
				<td class='COLUMNHEADER'><fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/><input type='checkbox' id= 'selAll' onclick='selectPatInPage(this)'></td>
				<td class='COLUMNHEADER'><fmt:message key='Common.PatientDetails.label' bundle='${common_labels}'/></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key='Common.admissiondate.label' bundle='${common_labels}'/></td>
				<td class='COLUMNHEADER'><fmt:message key="eCA.Transcriber.label" bundle="${ca_labels}"/></td>
				<td class='COLUMNHEADER'><fmt:message key="Common.notes.label" bundle="${common_labels}"/></td>
			</tr>
	<!--	</table>
		</div>
		<table class='grid'  width="100%" align="center" name="resultTable" id="resultTable" id="dataTable" > -->

	<%

		if(startIndex>1)
			rs.absolute((startIndex-1));

		while(rs.next())
		{
			
			flag = false ;
			rowCnt++;
			patient_id = rs.getString("PATIENT_ID")==null?"":rs.getString("PATIENT_ID");
			encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
			pline = rs.getString("Pline")==null?"":rs.getString("Pline");
			pline =pline.replaceAll("\\|",",");
			referral_id = rs.getString("REFERRAL_ID")==null?"":rs.getString("REFERRAL_ID");
			rsAdmission_date_time = rs.getString("ADMISSION_DATE_TIME")==null?"":rs.getString("ADMISSION_DATE_TIME");
			attend_practitioner_id = rs.getString("ATTEND_PRACTITIONER_ID")==null?"":rs.getString("ATTEND_PRACTITIONER_ID");
			default_transcriber = rs.getString("DEFAULT_TRANSCRIBER")==null?"":rs.getString("DEFAULT_TRANSCRIBER");
			default_transcriber_desc = rs.getString("DEFAULT_TRANSCRIBER_DESC")==null?"":rs.getString("DEFAULT_TRANSCRIBER_DESC");
			default_note = rs.getString("DEFAULT_NOTE")==null?"":rs.getString("DEFAULT_NOTE");
			locn_code = rs.getString("LOCN_CODE")==null?"":rs.getString("LOCN_CODE");
			locn_type = rs.getString("LOCN_TYPE")==null?"":rs.getString("LOCN_TYPE");
			locn_name = rs.getString("locn_name")==null?"":rs.getString("locn_name");


			if(locn_type.equals("C"))
			{
				locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(locn_type.equals("N"))
			{
				locn_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}
			else
			{
				locn_type_desc="";
			}
			display_admission_date=com.ehis.util.DateUtils.convertDate(rsAdmission_date_time,"DMYHM","en",localeName);

			hash_key = patient_id+"~"+encounter_id;
		
			if(multiTransBean.ContainsKey(hash_key))
			{
				chkBxStat = "checked";
				chCount++;

			}
			else
			{
				chkBxStat = "";
				//chCount--;
			}
			
			if(multiTransBean.ContainsKey(hash_key))
			{
				multiTransBean.removeFromHashMap(hash_key);
			}
				
			
			
			/*
			if(!(multiTransBean.returnList1().contains(hash_key)))
			{
				chkBxStat = "checked";

			}
			else
			{
				chkBxStat = "";
			} */

			if(!pre_locn_code.equals(locn_code))
			{
	%>
			<tr>
				<td colspan='4' class='CAFOURTHLEVELCOLOR' ><%=locn_type_desc%>&nbsp;-&nbsp;<%=locn_name%>
				</td>
			<tr>
	<%
			}
	%>
			<tr>
				<td class='gridData'><input type='checkbox' name='selRow<%=rowCnt%>' id='selRow<%=rowCnt%>' <%=chkBxStat%> onClick="remFromList(this,'<%=patient_id%>','<%=encounter_id%>');" ><input type='hidden' name='patient_id<%=rowCnt%>' id='patient_id<%=rowCnt%>' value="<%=patient_id%>">
				<input type='hidden' name='encounter_id<%=rowCnt%>' id='encounter_id<%=rowCnt%>' value="<%=encounter_id%>">
				</td>
				<td class='gridData'><%=pline%>, <%=encounter_id%></td>
				<td class='gridData'><%=attend_practitioner_id%></td>
				<td class='gridData'><%=display_admission_date%></td>
				<td class='gridData'><input type='hidden' name='transcriber<%=rowCnt%>' id='transcriber<%=rowCnt%>' value="<%=default_transcriber%>">
				<input type='text' name='transcriber_desc<%=rowCnt%>' id='transcriber_desc<%=rowCnt%>' size=30 maxlength='30' value='<%=default_transcriber_desc%>' onBlur ="getTranscriber(this,'<%=rowCnt%>');" ><input type='button' class='button' value='?' id='src_butn'  name='search_pract' id='search_pract' onClick="getTranscriber1(this,'<%=rowCnt%>');" ><img src='../../eCommon/images/mandatory.gif'>
			<!--	
					<select name='transcriber<%=rowCnt%>' id='transcriber<%=rowCnt%>'>
									
	<%				for(int l=0;l<transcriber_arr.size();++l)
					{
						tr =	(String)transcriber_arr.get(l);				
						tr_vals = tr.split("~");
					if(default_transcriber.equals(tr_vals[0]))
						{
							def_trans_chk="selected";
						}
					else
						{
							def_trans_chk="";
						}
					
	%>
					<option value="<%=tr_vals[0]%>" <%=def_trans_chk%> ><%=tr_vals[1]%></option>
					
	<%
					}
	%>
					</select> -->
				</td>
				<td class='gridData'>
					<select name='notes<%=rowCnt%>' id='notes<%=rowCnt%>'>
										
	<% 
					for(int m=0;m<notes_arr.size();++m)
					{
						tr =	(String)notes_arr.get(m);				
						tr_vals = tr.split("~");
				
						if(default_note.equals(tr_vals[0]))
						{
							def_note_chk="selected";
						}
						else
						{
							def_note_chk="";
						}
	%>
					<option value="<%=tr_vals[0]%>" <%=def_note_chk%> ><%=tr_vals[1]%></option>
									
	<%
					}
	%>
					</select>
				</td>		
			</tr>
	
	<%	
			pre_locn_code = locn_code ;
			i++;

			if(rowCnt>=maxRecordsDisp) break;
	
	}
	%>
			<tr style='visibility:hidden' >
				<td class='columnHeadercenter'><fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/></td>
				<td class='columnHeadercenter'><fmt:message key='Common.PatientDetails.label' bundle='${common_labels}'/></td>
				<td class='columnHeadercenter'><fmt:message key="Common.AttendingPractitioner.label" bundle="${common_labels}"/></td>
				<td class='columnHeadercenter'><fmt:message key='Common.admissiondate.label' bundle='${common_labels}'/></td>
				<td class='columnHeadercenter'><fmt:message key="eCA.Transcriber.label" bundle="${ca_labels}"/></td>
				<td class='columnHeadercenter'><fmt:message key="Common.notes.label" bundle="${common_labels}"/></td>
			</tr>

	<%
			if(rs!=null) rs.close();
			if(stmt!=null)stmt.close();
		putObjectInBean("multiTransBean"+bean_key,multiTransBean,session);
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
		}
		else
		{
			out.println("<script>parent.MultiTransRequestToolbarFrame.MultiTransRequestToolbarForm.apply.disabled=false; </script>");
		}
	%>
	<!--</table> -->
	<input type='hidden' name='bean_key' id='bean_key' value="<%=bean_key%>">
	<input type='hidden' name='practitionerId' id='practitionerId' value="<%=practitionerId%>">
	<input type='hidden' name='count' id='count' value="<%=i%>">
	<!--<input type='hidden' name='selcount' id='selcount' value="<%=count%>"> -->
	<input type='hidden' name='startIndex' id='startIndex' value="<%=startIndex%>">
	<input type='hidden' name='endIndex' id='endIndex' value="<%=endIndex%>">
	<input type='hidden' name='facilityid' id='facilityid' value="<%=facility_id%>">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	</form>
	<%if(!flag)
	{
	%>
		<!--<script>alignWidth();</script>-->
	<%
		if(chCount==i)
		{
		%>
			<script>document.forms[0].selAll.checked=true;</script>
		<%
		}
		if(chCount>0){
		%>
			<script>global_count='<%=chCount%>'</script>
		<%
		}
	}
	%>
  </body>
</html>

