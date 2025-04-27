<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
01/02/2012	  IN030859		Menaka V	CA>HTML code is displayed if we view the recorded Chief complaints in
										Clinical Events History and Chart Summary. 	
05/04/2012	  IN031989		Menaka V	When a patient is selected by using patient without encounter search function and when clinical
										event history is accessed the note header is incomplete for all the existing notes for that patient.	
20/06/2012	  IN033489		Menaka V	Report header blank in clinical event history.										 
--------------------------------------------------------------------------------------------------------------------
-->
<html>
	<head>

<%@ page import = "java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    String patientid = request.getParameter("patient_id") == null? "" : request.getParameter("patient_id");
    String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String fac_id ="";
	String enctr_id = "";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");

	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patientid+encounter_id,"eCA.PatientBannerGroupLine",session);

	ArrayList list = manageEmailBean.returnSortList();
	Collections.sort(list);
	int listSize = list.size();

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet res = null;
	StringTokenizer strTok = null;
	String listValue = "";
	String value = "";
	String strToken = "";
	StringBuffer displaydata = new StringBuffer();
	String displaydtls = "";
	
	int i=0;
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<!-- ****  Modified by kishor kumar n on 05/12/2008 for crf0387 applied new css grid. **** -->
		
		
		<script src='../../eCA/js/Encounters.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<title> <fmt:message key="eCA.Email.label" bundle="${ca_labels}"/></title>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onscroll='staticTitleForManage()'>
		<form name='manageEMailTextForm' id='manageEMailTextForm'>
			<table width='100%' class='grid'>
				<tr id='titleId'>
					<th>&nbsp;</th>
					<th>&nbsp;</th>
					<th><fmt:message key="Common.Event.label" bundle="${common_labels}"/></th>
					<th>	<fmt:message key="eCA.Value.label" bundle="${ca_labels}"/></th>
					<th>	<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th><!-- <input type='checkbox' name='selDeselAll' id='selDeselAll' onclick='selectAllToManage(this)' checked> -->
				</tr>
<%
	try
	{
		con  = ConnectionManager.getConnection(request);

		String sortEventDateTime = "";
		String prevHistRecType = "";
		String prevEventDate = "";
		String histRecTypeDesc = "";
		String contrSysEventCode = "";	
		String eventCode = "";
		String eventDate = "";
		String eventDesc = "";
		String histRecType = "";
		String histDataType = "";
		String resultNum = "";
		String resultStr = "";
		String listKeyValueStr = "";
		String sortListValueStr = "";
		String dispValue = "";
		String contrSysId = "";
		String accNum = "";
		String sortEventDate = "";
		String enc_id = "";
		String classValue = "CAQRYEVEN";
		StringBuffer sql = new StringBuffer();

		for(i=0; i<listSize; i++)
		{
			listValue = (String)list.get(i);
			strTok = new StringTokenizer(listValue,"`");

			if(i % 2 == 0) classValue = "CAQRYEVEN";
			else classValue = "CAQRYODD";

			while(strTok.hasMoreTokens())
			{
				sql.setLength(0);

				enc_id = (String) strTok.nextToken();
				histRecType = (String) strTok.nextToken();
				sortEventDateTime = (String) strTok.nextToken();
				contrSysId = (String) strTok.nextToken();
				accNum = (String) strTok.nextToken();
				contrSysEventCode = (String) strTok.nextToken();
			}

			if(histRecType.equals("CLNT"))
			{
				//sql.append("select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,AM_GET_DESC.AM_PRACTITIONER(A.PERFORMED_BY_ID,?,'2') authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT, to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,to_char(a.event_date,'YYYYMMDDHH24MISS') sort_event_date, CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, A.EVENT_CODE,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,'"+locale+"','1')  event_desc,A.HIST_DATA_TYPE from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =?");//Menaka
				sql.append("select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,AM_GET_DESC.AM_PRACTITIONER(A.PERFORMED_BY_ID,?,'2') authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT, to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,to_char(a.event_date,'YYYYMMDDHH24MISS') sort_event_date, CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc, A.EVENT_CODE,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,'"+locale+"','1')  event_desc,A.HIST_DATA_TYPE,a.encounter_ID, a.FACILITY_ID from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =?");//Menaka
			}//if end of CLNT
			else
			{
				sql.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT , A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'\n'");
				//sql.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name,to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,to_char(a.event_date,'YYYYMMDDHH24MISS') sort_event_date, CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc,A.EVENT_CODE,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,'"+locale+"','1')  event_desc   from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =?  ");//Menaka
				sql.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name,to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,to_char(a.event_date,'YYYYMMDDHH24MISS') sort_event_date, CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc,A.EVENT_CODE,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,'"+locale+"','1')  event_desc,a.encounter_ID, a.FACILITY_ID   from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =?  ");//Menaka
			}

			ps = con.prepareStatement(sql.toString());

			if(histRecType.equals("CLNT"))
			{
				ps.setString(1,locale);
				ps.setString(2,locale);
				ps.setString(3,histRecType);
				ps.setString(4,contrSysId);
				ps.setString(5,accNum);
				ps.setString(6,contrSysEventCode);
			}
			else
			{
				ps.setString(1,histRecType);
				ps.setString(2,contrSysId);
				ps.setString(3,accNum);
				ps.setString(4,contrSysEventCode);
			}

			res = ps.executeQuery();

			if(histRecType.equals("CLNT"))
			{
				while(res.next())
				{
					eventDate = res.getString("event_date") == null ? "" : res.getString("event_date");
					sortEventDate = res.getString("sort_event_date") == null ? "" : res.getString("sort_event_date");
					histRecTypeDesc = res.getString("hist_rec_type_desc") == null ? "" : res.getString("hist_rec_type_desc");
					eventCode = res.getString("EVENT_CODE") == null ? "" : res.getString("EVENT_CODE");
					eventDesc = res.getString("event_desc") == null ? "" : res.getString("event_desc");
					histDataType = res.getString("HIST_DATA_TYPE") == null ? "" : res.getString("HIST_DATA_TYPE");
					enctr_id = res.getString("encounter_ID") == null ? "" : res.getString("encounter_ID");//Menaka
					fac_id = res.getString("FACILITY_ID") == null ? "" : res.getString("FACILITY_ID");//Menaka
					eventDate	= com.ehis.util.DateUtils.convertDate(eventDate,"DMYHM","en",locale);
					if(!prevHistRecType.equals(histRecType))
					{
						out.println("<tr>");
						out.println("<td class='CAFLOWSHEETLEVEL1' colspan ='5'>"+histRecTypeDesc);
						out.println("</td>");
						out.println("</tr>");
					}

					if(!prevEventDate.equals(eventDate))
					{
						out.println("<tr>");
						out.println("<td class='CAFLOWSHEETLEVEL2'>&nbsp;</td>");
						out.println("<td class='CAFLOWSHEETLEVEL2' colspan ='4'>"+eventDate);
						out.println("</td>");
						out.println("</tr>");
					}

					if(histDataType.equals("HTM") || histDataType.equals("TXT"))
					{
						//dispValue = "<a href=\"javascript:getText('"+histRecType+"','"+contrSysId+"','"+accNum+"','"+contrSysEventCode+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";//IN031989
						dispValue = "<a href=\"javascript:getText('"+histRecType+"','"+contrSysId+"','"+accNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";//IN031989//IN033489
					}	

					else if(histDataType.equals("STR"))
						dispValue = resultStr;
					else
						dispValue = resultNum;

					if(resultNum.equals("") || resultNum == null) resultNum = " ";
					else if(!resultNum.equals(" ")) resultNum = resultNum.trim();
					if(resultStr.equals("")) resultStr = " ";

					listKeyValueStr = enc_id+"`"+histRecType+"`"+contrSysId+"`"+accNum+"`"+contrSysEventCode;
					sortListValueStr = enc_id+"`"+histRecType+"`"+sortEventDate+"`"+contrSysId+"`"+accNum+"`"+contrSysEventCode;

					out.println("<tr>");
					out.println("<td class='gridData'>&nbsp;</td>");
					out.println("<td class='gridData'>&nbsp;</td>");
					out.println("<td class='gridData'>"+eventDesc+"</td>");
					out.println("<td class='gridData'>"+dispValue+"</td>");
					out.println("<td class='gridData'><input type='checkbox' id='chkBox"+i+"' checked onclick='removeFromBean(this,\""+i+"\",\""+listKeyValueStr+"\",\""+sortListValueStr+"\")'></td>");
					out.println("</tr>");

					prevHistRecType = histRecType;
					prevEventDate = eventDate;
				}
			}
			else
			{
				while (res.next())
				{
					resultNum = res.getString("RESULT_NUM") == null ? "" : res.getString("RESULT_NUM");
					resultStr = res.getString("RESULT_STR") == null ? "" : res.getString("RESULT_STR");
					histDataType = res.getString("HIST_DATA_TYPE") == null ? "" : res.getString("HIST_DATA_TYPE");
					eventDate = res.getString("event_date") == null ? "" : res.getString("event_date");
					histRecTypeDesc = res.getString("hist_rec_type_desc") == null ? "" : res.getString("hist_rec_type_desc");
					eventCode = res.getString("EVENT_CODE") == null ? "" : res.getString("EVENT_CODE");
					eventDesc = res.getString("event_desc") == null ? "" : res.getString("event_desc");
					sortEventDate = res.getString("sort_event_date") == null ? "" : res.getString("sort_event_date");
					enctr_id = res.getString("encounter_ID") == null ? "" : res.getString("encounter_ID");//Menaka
					fac_id = res.getString("FACILITY_ID") == null ? "" : res.getString("FACILITY_ID");//Menaka
					eventDate	= com.ehis.util.DateUtils.convertDate(eventDate,"DMYHM","en",locale);
					if(resultNum.equals("") || resultNum == null) resultNum = " ";
					else if(!resultNum.equals(" "))resultNum = resultNum.trim();
					if(resultStr.equals("")) resultStr = " ";

					if(!prevHistRecType.equals(histRecType))
					{
						out.println("<tr>");
						out.println("<td class='CAFLOWSHEETLEVEL1' colspan ='5'>&nbsp;&nbsp;"+histRecTypeDesc);
						out.println("</td>");
						out.println("</tr>");
					}

					if(!prevEventDate.equals(eventDate))
					{
						out.println("<tr>");
						out.println("<td class='CAFLOWSHEETLEVEL2'>&nbsp;</td>");
						out.println("<td class='CAFLOWSHEETLEVEL2' colspan ='4'>&nbsp;"+eventDate);
						out.println("</td>");
						out.println("</tr>");
					}

					if(histDataType.equals("HTM") || histDataType.equals("TXT"))
					{
						//dispValue = "<a href=\"javascript:getText('"+histRecType+"','"+contrSysId+"','"+accNum+"','"+contrSysEventCode+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";//IN031989
						dispValue = "<a href=\"javascript:getText('"+histRecType+"','"+contrSysId+"','"+accNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";//IN031989//IN033489
					}
						
					else if(histDataType.equals("STR"))
					{
						dispValue = resultStr;
					
						java.util.StringTokenizer remarksTokens = new java.util.StringTokenizer(dispValue,",");
						//dispValue = resultStr;
						//Below condition is added by Archana Dhal on 11/24/2010 related to IN025200.
						while(remarksTokens.hasMoreTokens() )
						{
							strToken = remarksTokens.nextToken();
							 if(strToken.indexOf("Date")!=-1)
							{
								  value = strToken.substring(7, strToken.length());
								  value	= com.ehis.util.DateUtils.convertDate(value,"DMYHM","en",locale);
								  displaydata.append(value);
								  displaydata.append(",");		
							}
							else
							{
								displaydata.append(strToken);
								displaydata.append(",");
							}
								
						 }
						 displaydtls = displaydata.substring(0,displaydata.length()-1);
					}

					else
					{
						displaydtls = resultNum;
					}

					

					listKeyValueStr = enc_id+"`"+histRecType+"`"+contrSysId+"`"+accNum+"`"+contrSysEventCode;
					sortListValueStr = enc_id+"`"+histRecType+"`"+sortEventDate+"`"+contrSysId+"`"+accNum+"`"+contrSysEventCode;

					out.println("<tr>");
					out.println("<td class='gridData'>&nbsp;</td>");
					out.println("<td class='gridData'>&nbsp;</td>");
					out.println("<td class='gridData'>"+eventDesc+"</td>");
					out.println("<td class='gridData'>"+displaydtls+"</td>");
					out.println("<td class='gridData'><input type='checkbox' checked onclick='removeFromBean(this,\""+i+"\",\""+listKeyValueStr+"\",\""+sortListValueStr+"\")' id='chkBox"+i+"'></td>");
					out.println("</tr>");

					prevHistRecType = histRecType;
					prevEventDate = eventDate;
				}
			}
		}
		%>
		<input type='hidden' name='enc_id' id='enc_id' value='<%=enc_id%>'>	<!--IN030859-->	
		<%
	}
	catch(Exception e)
	{
		
		//out.println("Exception at try - main of EncountersManageTxtDetails.jsp -"+e.toString());//common-icn-0181
		e.printStackTrace();
	}
	finally
	{
		if(res != null) res.close();
		if(ps != null) ps.close();
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
				</table>
				<input type='hidden' name='patient_id' id='patient_id' value='<%=patientid%>'>
				<input type='hidden' name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>		
				<input type='hidden' name='numEvents' id='numEvents' value='<%=i%>'>		
			</form>
		</body>
</html>

