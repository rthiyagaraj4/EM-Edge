<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	PreparedStatement pstmt = null;

	String resp_id				= (String)session.getValue("responsibility_id");

	String location					= "";
	String attending_practitioner	= "";
	String nationality_id			= "",			nationality_legend	=	"";
	String accessionnum				= "";
	String printDateTime			= "",			dischargeDateTime	=	"",			authorizedBy	=	"";
	String query_privilege_type		= "";
	String encounter_id				= "",			episode_type		=	"";
	String discharge_summary_text	= "",			referral_letter_text=	"";

	String eventdesc			= request.getParameter("event_desc")==null?"":request.getParameter("event_desc");
	String from					= request.getParameter("from")==null?"":request.getParameter("from");
	String patient_line			= request.getParameter("patient_line")==null?"":request.getParameter("patient_line");
	String facility_name		= request.getParameter("facility_name")==null?"":request.getParameter("facility_name");
	String specialty_name		= request.getParameter("specialty_name")==null?"":request.getParameter("specialty_name");
	String visit_adm_date		= request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");

	if(resp_id == null)resp_id ="";
	
	String facility_id = (request.getParameter("facility_id")==null)?"":request.getParameter("facility_id");
	String histrectype = (request.getParameter("hist_type")==null?"":request.getParameter("hist_type"));

%>
<html>
<head>
	<title><%=eventdesc%> Details</title>
	 <%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
	%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link> 
	<script src='../../eCA/js/Encounters.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<style>
	PRE
	{
		font-size: 8pt ;
		Font-Family : Courier New;
		BACKGROUND-COLOR: #E2E3F0;
		BORDER-STYLE: none;
		fontWeight : bold;
		text-align: left;
		WORD-WRAP: break-word
	}							

	</style>
	<%if (histrectype.equals("LBIN")) {%>
		<style>
		ADDRESS	{ FONT-FAMILY: Courier ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
	</style>
	<%}else{%>
	<style>
		ADDRESS	{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
	</style>
	<%}%>
</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	if( from.equals("A") || from.equals("DISCHARGE_SUMMARY") )
	{
		String buttonValue	=	from.equals("A") ? com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Zoom.label","ca_labels") : com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels");
		String callFunction	=	from.equals("A") ? "showinModal()" : "modalForPrint()";
		out.println("<table cellpadding=3 cellspacing=0 border=0 width='100%' align=center>");
		out.println("<tr><td colspan =4 width = 100% align = right><input type='button' class=button onClick=\""+callFunction+"\" value=\""+buttonValue+"\"></td></tr></table>");
		out.println("<br>");
	
	}

	Connection con  = null;
	PreparedStatement pstmt1=null;
	ResultSet rs		  = null;
	
	accessionnum =  request.getParameter("accession_num");
	
	if(accessionnum!=null)
		accessionnum = java.net.URLDecoder.decode( accessionnum );
	else
		accessionnum = "";
	
	String datatype = request.getParameter("data_type")==null?"":request.getParameter("data_type");
	datatype=java.net.URLDecoder.decode(datatype);
	
	String contr_sys_id = request.getParameter("contr_sys_id")==null?"":request.getParameter("contr_sys_id");
	contr_sys_id=java.net.URLDecoder.decode(contr_sys_id);
	
	String contr_sys_event_code = request.getParameter("contr_sys_event_code")==null?"":request.getParameter("contr_sys_event_code");
	contr_sys_event_code=java.net.URLDecoder.decode(contr_sys_event_code);
	
	StringBuffer displaydata = new StringBuffer();
	StringBuffer dispdata = new StringBuffer();
	
	
	String site_name = "";
	String newLine="\n";

	if(from.equals("CN"))
		newLine="<BR>";	

	try
	{
		con  = ConnectionManager.getConnection(request);

		if(from.equals("DISCHARGE_SUMMARY"))
		{
			pstmt =	con.prepareStatement("select site_name from sm_site_param");

			try
			{
				rs	=	pstmt.executeQuery();

				if(rs.next())
					site_name	=	rs.getString("site_name")==null?"":rs.getString("site_name");

				if(pstmt!=null)	pstmt.close();
			}
			catch(Exception e)
			{
				//out.println("Exception@2: "+e);//common-icn-0181
				e.printStackTrace();//COMMON-ICN-0181
			}			
		}		

		StringTokenizer strTknSysId = new StringTokenizer(contr_sys_id,"','");
		StringTokenizer strTknAccNo = new StringTokenizer(accessionnum,"','");
		StringTokenizer strTknSysEvent = new StringTokenizer(contr_sys_event_code,"','");
		
		String contr_sys_id_curr="";
		String accessionnum_curr="";
		String contr_sys_event_code_curr="";

		while(strTknAccNo.hasMoreTokens())
		{
			StringBuffer sqltxt=new StringBuffer();

			contr_sys_id_curr			= strTknSysId.nextToken();			
			accessionnum_curr			= strTknAccNo.nextToken();			
			contr_sys_event_code_curr	= strTknSysEvent.nextToken();

			if(histrectype.equals("CLNT"))
			{
				//sqltxt.append(" select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT  from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =? ");

				sqltxt.append("select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,AM_GET_DESC.AM_PRACTITIONER(A.PERFORMED_BY_ID,?,'2') authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT  from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =?");
			}
			else
			{
				/*sqltxt.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT , A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'"+newLine+"'");
								
				if(from.equals("CN"))
					sqltxt.append("||CHR(10)");
				
				sqltxt.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name  from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =? ");
				*/

				sqltxt.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT , A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'"+newLine+"'");

				if(from.equals("CN"))
					sqltxt.append("||CHR(10)");
				
				sqltxt.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name  from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =?  ");
			}

			

			pstmt1 = con.prepareStatement(sqltxt.toString());
			
			if(histrectype.equals("CLNT"))
			{
				pstmt1.setString(1,locale);
				pstmt1.setString(2,locale);
				pstmt1.setString(3,histrectype);
				pstmt1.setString(4,contr_sys_id_curr);
				pstmt1.setString(5,accessionnum_curr);
				pstmt1.setString(6,contr_sys_event_code_curr);
			}
			else
			{
				pstmt1.setString(1,histrectype);
				pstmt1.setString(2,contr_sys_id_curr);
				pstmt1.setString(3,accessionnum_curr);
				pstmt1.setString(4,contr_sys_event_code_curr);
			}
			rs = pstmt1.executeQuery();			

			if(histrectype.equals("CLNT"))
			{
				while (rs.next())
				{
					Clob clb = rs.getClob("hist_data");
					facility_id = rs.getString("FACILITY_ID")==null?"":rs.getString("FACILITY_ID");
					encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
					printDateTime = rs.getString("print_datetime")==null?"":rs.getString("print_datetime");
					nationality_id = rs.getString("NATIONAL_ID_NO")==null?"":rs.getString("NATIONAL_ID_NO");
					nationality_legend = rs.getString("NAT_ID_PROMPT")==null?"":rs.getString("NAT_ID_PROMPT");
					authorizedBy = rs.getString("authorized_by_name")==null?"":rs.getString("authorized_by_name");

					episode_type = rs.getString("episode_type")==null?"":rs.getString("episode_type");
					facility_name = rs.getString("facility_name")==null?"":rs.getString("facility_name");
					discharge_summary_text = rs.getString("DIS_SUMM_DISCLAIMER_TXT")==null?"":rs.getString("DIS_SUMM_DISCLAIMER_TXT");
					referral_letter_text = rs.getString("REF_LETTER_DISCLAIMER_TXT")==null?"":rs.getString("REF_LETTER_DISCLAIMER_TXT");

					if(discharge_summary_text == null) 
						discharge_summary_text = "";

					if(referral_letter_text == null) 
						referral_letter_text = "";

					if( (clb!=null) && (clb.length()>0) )
						displaydata.append( clb.getSubString( 1, ((int)clb.length()) ) );						
				}
				if(rs != null)rs.close();
				if(pstmt1 != null)pstmt1.close();	 
			
			}
			else
			{
				String longDesc ="";
				String histDataType ="";
				String resutStr ="";
				String resultNum ="";

				while (rs.next())
				{
					
					longDesc=rs.getString("long_desc")==null?"":rs.getString("long_desc");
					histDataType= rs.getString("HIST_DATA_TYPE")==null?"":rs.getString("HIST_DATA_TYPE");
					resutStr = rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
					resultNum= rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM");

					Clob clb = rs.getClob("hist_data");
					nationality_id = rs.getString("NATIONAL_ID_NO")==null?"":rs.getString("NATIONAL_ID_NO");
					nationality_legend = rs.getString("NAT_ID_PROMPT")==null?"":rs.getString("NAT_ID_PROMPT");
					facility_id = rs.getString("FACILITY_ID")==null?"":rs.getString("FACILITY_ID");
					encounter_id = rs.getString("ENCOUNTER_ID")==null?"":rs.getString("ENCOUNTER_ID");
					printDateTime = rs.getString("print_datetime")==null?"":rs.getString("print_datetime");
					authorizedBy = rs.getString("authorized_by_name")==null?"":rs.getString("authorized_by_name");
					
					episode_type = rs.getString("episode_type")==null?"":rs.getString("episode_type");
					facility_name = rs.getString("facility_name")==null?"":rs.getString("facility_name");

					
					if(!histDataType.equals("HTM"))
						displaydata.append(newLine+longDesc+":");

					if(histDataType.equals("NUM"))
					{
						displaydata.append(resultNum);
						if(!resutStr.equals(""))
						{
							displaydata.append(newLine+resutStr);
						}
					}
					else if(histDataType.equals("STR"))
					{
						displaydata.append(resutStr);
					}

					if( (clb!=null) && (clb.length()>0) )
					{
						displaydata.append(newLine);
						displaydata.append( clb.getSubString( 1, ((int)clb.length()) ) );						
					}
				}
             
			
				if(rs != null)rs.close();	 
					if(pstmt1 != null)pstmt1.close();	 
			}

		}//end of while(strTknAccNo.hasMoreTokens())		

		if(from.equals("A") || from.equals("B"))
		{
			//if(histrectype.equals("CLNT") || datatype.equals("HTM"))
			if( datatype.equals("HTM"))
				out.println(displaydata.toString());
			else
				out.println("<textarea  align='MIDDLE' readOnly style='FONT-FAMILY:Courier New;FONT-SIZE: 8pt' rows=24 cols=80>"+displaydata.toString()+"</textarea>");
			
                
			 
		}
		else
		{
			out.println(displaydata.toString());
					
			
		}

 	   if(	episode_type.equals("O") )
		{
			//query_privilege_type	=	"select to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,acc_entity_name facility_name, service_short_desc specialty_name,LOCN_NAME,(select SHORT_NAME from am_practitioner where practitioner_id=ca_op_episode_vw.PHYSICIAN_ID) attending_practitioner from ca_op_episode_vw where facility_id = ? and episode_id = ? ";
			query_privilege_type	=	"select to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(?,?,'1') facility_name,AM_GET_DESC.AM_SERVICE(service_code,?,'2')  specialty_name,OP_GET_DESC.OP_CLINIC(facility_id,LOCN_CODE,?,'1') LOCN_NAME,AM_GET_DESC.AM_PRACTITIONER(PHYSICIAN_ID,?,'2')  attending_practitioner from ca_op_episode_vw where facility_id = ? and episode_id = ? ";
		}
		else
		{
			//query_privilege_type	=	"select to_char(admission_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,facility_name, service_short_desc specialty_name,WARD_SHORT_DESC||'/'||CUR_ROOM_NUM||'/'||CUR_BED_NUM  LOCN_NAME,(select SHORT_NAME from am_practitioner where practitioner_id=ca_ip_active_episode_vw.CUR_PHYSICIAN_ID) attending_practitioner   from ca_ip_active_episode_vw where facility_id = ? and episode_id = ? ";
			query_privilege_type	=	"select to_char(admission_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(?,?,'1') facility_name, AM_GET_DESC.AM_SERVICE(SERVICE_CODE,?,'2') specialty_name,IP_GET_DESC.IP_NURSING_UNIT(?,CUR_WARD_CODE,?,'1')||'/'||CUR_ROOM_NUM||'/'||CUR_BED_NUM  LOCN_NAME,AM_GET_DESC.AM_PRACTITIONER(CUR_PHYSICIAN_ID,?,'2')  attending_practitioner   from ca_ip_active_episode_vw where facility_id = ? and episode_id = ?";
		}
			
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();




		pstmt	=	con.prepareStatement(query_privilege_type);

		pstmt.setString	(	1,	facility_id	);
		pstmt.setString	(	2,	locale	);
		pstmt.setString	(	3,	locale	);
		if(	episode_type.equals("O") )
		{
		pstmt.setString	(	4,	locale	);
		pstmt.setString	(	5,	locale	);
		pstmt.setString	(	6,	facility_id	);
		pstmt.setString	(	7,	encounter_id);
		}
		else
		{
		pstmt.setString	(	4,	facility_id	);
		pstmt.setString	(	5,	locale	);
		pstmt.setString	(	6,	locale	);
		pstmt.setString	(	7,	facility_id	);
		pstmt.setString	(	8,	encounter_id);
		}
		rs		=	pstmt.executeQuery();

		if(rs.next())
		{
			facility_name	=	rs.getString("facility_name")==null?"":rs.getString("facility_name");
			visit_adm_date	=	rs.getString("visit_adm_date")==null?"":rs.getString("visit_adm_date");
			specialty_name	=	rs.getString("specialty_name")==null?"":rs.getString("specialty_name");
			location		=	rs.getString("LOCN_NAME")==null?"":rs.getString("LOCN_NAME");
			dischargeDateTime= rs.getString("DISCHARGE_DATE_TIME")==null?"":rs.getString("DISCHARGE_DATE_TIME");
			attending_practitioner = rs.getString("attending_practitioner")==null?"":rs.getString("attending_practitioner");
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(dischargeDateTime==null){
			dischargeDateTime="";
		}
		if(nationality_id==null){
			nationality_id="";
		}
	
		if(nationality_legend==null){
			nationality_legend="";
		}
			
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
	
	}	catch(Exception e){
		e.printStackTrace();
		//out.println("Exception "+e);//COMMON-ICN-0181
	}
	finally {
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
%>
</p>
<form name="detail_form" id="detail_form">
	<input type="hidden" name="qs" id="qs" value="hist_type=<%=histrectype%>&accession_num=<%=java.net.URLEncoder.encode(accessionnum)%>&event_desc=<%=eventdesc%>&data_type=<%=datatype%>&from=B&contr_sys_id=<%=contr_sys_id%>&contr_sys_event_code=<%=contr_sys_event_code%>">
	<input type="hidden" name="from" id="from" value="<%=from%>">
	<input type="hidden" name="facility_name" id="facility_name"	value="<%=facility_name%>">
	<input type="hidden" name="specialty_name" id="specialty_name"	value="<%=specialty_name%>">
	<input type="hidden" name="patient_line" id="patient_line"	value="<%=patient_line%>">
	<input type="hidden" name="site_name" id="site_name"	value="<%=site_name%>">
	<input type="hidden" name="accession_num" id="accession_num" value="<%=accessionnum%>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=facility_id%>">
	<input type="hidden" name="location" id="location" value="<%=location%>">
	<input type="hidden" name="visit_adm_date" id="visit_adm_date" value="<%=visit_adm_date%>">
	<input type="hidden" name="dischargeDateTime" id="dischargeDateTime" value="<%=dischargeDateTime%>">
	<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
	<input type="hidden" name="episode_type" id="episode_type" value="<%=episode_type%>">
	<input type="hidden" name="facility_disp_name" id="facility_disp_name" value="<%=facility_name%>">
	<input type="hidden" name="authorizedBy" id="authorizedBy" value="<%=authorizedBy%>">
	<input type="hidden" name="printDateTime" id="printDateTime" value="<%=printDateTime%>">
	<input type="hidden" name="attending_practitioner" id="attending_practitioner" value="<%=attending_practitioner%>">
	<input type="hidden" name="nationality_legend" id="nationality_legend" value="<%=nationality_legend%>">
	<input type="hidden" name="nationality_id" id="nationality_id"		value="<%=nationality_id%>">
	<input type="hidden" name="discharge_summary_text" id="discharge_summary_text" value="<%=discharge_summary_text%>">
	<input type="hidden" name="referral_letter_summary" id="referral_letter_summary"		value="<%=referral_letter_text%>">

<!-- <div id='data' style='position:absolute; width:0%; visibility:hidden;' border='0' width='0'> -->
<%
dispdata.append("<PRE style='word-wrap:break-word;margin-right:5%'>");
dispdata.append(displaydata.toString());
dispdata.append("</PRE>");
%>

<div id='data' style='display:none;' border='0' width='0'>


<%=dispdata.append("<LINK href='../../eCommon/html/ "+ sStyle +" ' type=text/css rel=stylesheet></LINK>").toString()%>

</div>
</form>
</body>

<%

	//out.println("<h1>FROM : "+from);
	if(from.equals("CN"))
	{
		//out.println("<h1>FROM : "+from);

		out.println("<script>");
		//out.println("alert('inside returnDataa...');");
		//if(histrectype.equals("CLNT") || datatype.equals("HTM"))
		 if(datatype.equals("HTM"))
			out.println("var d = document.getElementById('data').innerHTML;");
		else
			out.println("var d = document.getElementById('data').innerText;");

		out.println("parent.window.returnValue = d;");
		out.println("parent.window.close();");
		out.println("</script>");
	}
%>
</html>

