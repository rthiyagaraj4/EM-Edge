<!DOCTYPE html>
<html>
	<head>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*, eCA.* ,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String beanKey = "CA_EmailRepBodyTxtBean"+patient_id+encounter_id;
	
	String accession_num = request.getParameter("accession_num") == null ? "" : request.getParameter("accession_num");

	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);

	eCA.EmailRepBodyTxtBean	CA_EmailRepBodyTxtBean = (eCA.EmailRepBodyTxtBean)getObjectFromBean(beanKey,"eCA.EmailRepBodyTxtBean",session);
	//ArrayList keyList2 = new ArrayList();
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet res = null;
//	String result_linked_key ="";
//	String result_linked_val ="";

/*	try
	{
			con  = ConnectionManager.getConnection(request);
			String arrPopQry ="select a.RESULT_LINKED_KEY ,a.RESULT_LINKED_VALUE from CA_ENCNTR_MULT_RESULT_KEY a where a.ACCESSION_NUM =? " ;

			ps = con.prepareStatement(arrPopQry);
			ps.setString(1,accession_num);
			res = ps.executeQuery();
			while(res.next())
			{
				 result_linked_key = res.getString("RESULT_LINKED_KEY")==null?"":res.getString("RESULT_LINKED_KEY");
				 result_linked_val = res.getString("RESULT_LINKED_VALUE")==null?"":res.getString("RESULT_LINKED_VALUE");
					// arrList.add(result_linked_key);
					
						keyList2.add(result_linked_key);
						if(!manageEmailBean.returnSortList().contains(result_linked_key))
							{
								manageEmailBean.addRecordsToSortList(result_linked_key);
								//manageEmailBean.addToHashMap(result_linked_key,result_linked_val);
							}
					 
			}

					if(res!=null) res.close();
					if(ps!=null)ps.close();

	}
	catch(Exception e)
	{
		
		out.println("Exception in try of RecClinicalNotesLinkMultiHistEmailDetails.jsp --"+e.toString());
		e.printStackTrace();
	}
	
	
	
	
	//ArrayList keyList2 = manageEmailBean.returnList2();
	if(keyList2.size() == 0)
	{
		out.println("<script>");
		out.println("alert(getMessage(\"EVENTS_TO_EMAIL\",\"CA\"));");
		out.println("window.close();");
		out.println("</script>");
	}  */

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
	String userID= (String) session.getValue("login_user") == null ? "" : (String) session.getValue("login_user");
	String UserName = "";	
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle common_labels = java.util.ResourceBundle.getBundle( "eCommon.resources.Labels",loc);
	java.util.ResourceBundle caLabelStr = java.util.ResourceBundle.getBundle( "eCA.resources.Labels",loc);

	String loggedUser = common_labels.getString("Common.LoggedUser.label");
	String dateTime = common_labels.getString("Common.datetime.label");
	String title = caLabelStr.getString("eCA.Email.label");

	/*ArrayList list = manageEmailBean.returnSortList();
	Collections.sort(list);
	int listSize = list.size(); */

	

	
//	Clob clb = null;	
	
/*	StringTokenizer strTok = null;
	String listValue = "";
	String eventDate = "";
	String histRecType = "";
	String contrSysId = "";
	String accNum = "";
	String contrSysEventCode = "";
	String histDataType = "";
	String resultNum = "";
	String resultStr = "";
	String classValue = "CAQRYEVEN"; */
//	String siteLogo = "";
	String facilityName = "";
	String printDateTime = "";
	String reportDesc = "";
//	StringBuffer sql = new StringBuffer();
	StringBuffer displayData = new StringBuffer();
//	StringBuffer displayDataTemp = new StringBuffer();
	String query_notes_detail="";

	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;

%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCA/js/Encounters.js' language='javascript'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



		<title> <fmt:message key="eCA.Email.label" bundle="${ca_labels}"/></title>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='emailDtlsForm' id='emailDtlsForm'>		
<%
	try
	{
		con  = ConnectionManager.getConnection(request);		

		/*ps = con.prepareStatement("select SITE_LOGO_LOGIN_SCREEN PAGE_HEADER_IMAGE_FILE_NAME FROM SM_SITE_PARAM");
		res = ps.executeQuery();
		while(res.next())
		{
			siteLogo = res.getString("PAGE_HEADER_IMAGE_FILE_NAME") == null ? "" : res.getString("PAGE_HEADER_IMAGE_FILE_NAME");
		}
		
		if(res != null) res.close();
		if(ps != null) ps.close();*/

		ps = con.prepareStatement("select  REPORT_DESC from sm_report where MODULE_ID='CA' and REPORT_ID = 'AHCLINREP' ");
		res = ps.executeQuery();
		while(res.next())
		{
			reportDesc = res.getString("REPORT_DESC") == null ? "" : res.getString("REPORT_DESC");
		}
		
		if(res != null) res.close();
		if(ps != null) ps.close();

		ps = con.prepareStatement("SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id=?");
		ps.setString(1,locale);
		ps.setString(2,facilityId);

		res = ps.executeQuery();
		while(res.next())
		{
			facilityName = res.getString("FACILITY_NAME") == null ? "" : res.getString("FACILITY_NAME");
		}

		if(res != null) res.close();
		if(ps != null) ps.close();

		ps = con.prepareStatement("SELECT APPL_USER_NAME FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = ? and APPL_USER_ID=?");
		ps.setString(1,locale);
		ps.setString(2,userID);

		res = ps.executeQuery();
		while(res.next())
		{
			UserName = res.getString("APPL_USER_NAME") == null ? "" : res.getString("APPL_USER_NAME");
		}

		if(res != null) res.close();
		if(ps != null) ps.close();

		ps = con.prepareStatement("SELECT to_char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from dual");
		res = ps.executeQuery();
		while(res.next())
		{
			printDateTime = res.getString("print_date_time") == null ? "" : res.getString("print_date_time");
		}

		if(res != null) res.close();
		if(ps != null) ps.close();

/*		String sortEventDateTime = "";
		String prevHistRecType = "";
		String prevEventDate = "";
		String histRecTypeDesc = "";*/

		
		query_notes_detail = "select a.note_content, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,?,'1') note_type_desc from ca_encntr_note a where a.facility_id = ? and a.accession_num = ?";
		ps			=	con.prepareStatement(query_notes_detail);

		ps.setString(1, locale);
		ps.setString(2, facilityId);
		ps.setString(3, accession_num);

		res				=	ps.executeQuery();

		if(res.next())
		{
			clob_notes_content	=	(java.sql.Clob) res.getObject("note_content");

			if(clob_notes_content!=null)
			{
				try
				{
					content_reader	= clob_notes_content.getCharacterStream();
					bf_content_reader = new java.io.BufferedReader(content_reader);

					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());

					//notes_content = new String(arr_notes_content);
					displayData.append(arr_notes_content);

					bf_content_reader.close();
				}
				catch(Exception e)
				{
				//	out.println("Exception@2-readCLOB : "+e);//COMMON-ICN-0181
                                        e.printStackTrace();//COMMON-ICN-0181
				}
			
			} // end of if(clob_notes_content!=null)
		} // end of if(rs.next())
	
		if(res!=null) res.close();
		if(ps!=null) ps.close();
	
	
		
		
		
		/*for(int i=0; i<listSize; i++)
		{
			listValue = (String)list.get(i);
			strTok = new StringTokenizer(listValue,"`");

			while(strTok.hasMoreTokens())
			{
				sql.setLength(0);

				histRecType = (String) strTok.nextToken();
				sortEventDateTime = (String) strTok.nextToken();
				contrSysId = (String) strTok.nextToken();
				accNum = (String) strTok.nextToken();
				contrSysEventCode = (String) strTok.nextToken();
			}

			if(histRecType.equals("CLNT"))
			{
				sql.append("select null DIS_SUMM_DISCLAIMER_TXT,null  REF_LETTER_DISCLAIMER_TXT, b.hist_data,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,AM_GET_DESC.AM_PRACTITIONER(A.PERFORMED_BY_ID,?,'2') authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT, to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc  from cr_encounter_detail a,cr_encounter_detail_txt b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and a.CONTR_SYS_ID=b.CONTR_SYS_ID   and a.ACCESSION_NUM=b.ACCESSION_NUM and a.CONTR_SYS_EVENT_CODE=b.CONTR_SYS_EVENT_CODE and b.hist_rec_type = ? and a.contr_sys_id =? and b.accession_num=? and a.contr_sys_event_code =?");
			}//if end of CLNT
			else
			{
				sql.append(" select TO_CHAR(NULL) DIS_SUMM_DISCLAIMER_TXT ,TO_CHAR(NULL) REF_LETTER_DISCLAIMER_TXT , b.long_desc,(select nvl(NATIONAL_ID_NO,'') from MP_PATIENT where PATIENT_ID=a.patient_id) NATIONAL_ID_NO,(select nvl(NAT_ID_PROMPT,'National ID No') NAT_ID_PROMPT FROM MP_PARAM where rownum=1) NAT_ID_PROMPT , A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' '||RESULT_NUM_UOM||' '||(select decode(a.normalcy_ind,HIGH_STR,'Abnormal',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') from cr_clin_event_param)||' '||replace('('||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' - '||DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||')','( - )',null) RESULT_NUM,(SELECT CA_CLOB_REPLACE(hist_data,chr(10),'\n'");
				sql.append( "  ) FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,a.FACILITY_ID,a.ENCOUNTER_ID,a.PATIENT_CLASS,(select SHORT_NAME from am_practitioner where practitioner_id=a.PERFORMED_BY_ID) authorized_by_name,to_char(sysdate,'dd/mm/yyyy hh24:mi') print_datetime ,dEcode(a.patient_class,'OP','O','EM' ,'O','I') Episode_type,(select FACILITY_NAME from sm_facility_param where facility_id=a.facility_id) facility_name,to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,'"+locale+"','1') hist_rec_type_desc   from cr_encounter_detail a,cr_clin_event_mast b where a.HIST_REC_TYPE=b.HIST_REC_TYPE and b.event_code=a.event_code and a.EVENT_CODE_TYPE=b.EVENT_CODE_TYPE and a.hist_rec_type = ? and a.contr_sys_id =? and a.accession_num=? and a.contr_sys_event_code =?  ");
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
				displayData.append("<table width='100%' cellpadding=0 cellspacing=0 border='1'>");
				while(res.next())
				{
					clb = res.getClob("hist_data");
					eventDate = res.getString("event_date") == null ? "" : res.getString("event_date");
					histRecTypeDesc = res.getString("hist_rec_type_desc") == null ? "" : res.getString("hist_rec_type_desc");

					if(!prevHistRecType.equals(histRecType))
					{
						displayData.append("<TR><TD colspan='4' class='spanId1' align='center'><B>"+histRecTypeDesc+"</B></TD></TR>");
					}

					if(!prevEventDate.equals(eventDate))
					{
						displayData.append("<TR><TD colspan='4' class='spanId2' align='left' ><B>&nbsp;"+eventDate+"</B></TD></TR>");
					}

					displayData.append("<TR>");
					displayData.append("<TD class='"+classValue+"' colspan=''>");

					if( (clb!=null) && (clb.length()>0) )
						displayDataTemp.append(clb.getSubString(1,((int)clb.length())));

					displayData.append("<TR><TD class='"+classValue+"' colspan=''>"+displayDataTemp.toString()+"</TD></TR>");

					displayData.append("</TABLE>");
				}
				if(res != null) res.close();
				if(ps != null) ps.close();
			}
			else
			{
				displayData.append("<table width='100%' cellpadding=0 cellspacing=0 border='1'>");
				String longDesc = "";
				clb = null;
				while (res.next())
				{					
					longDesc = res.getString("long_desc") == null ? "" : res.getString("long_desc");
					resultNum = res.getString("RESULT_NUM") == null ? "" : res.getString("RESULT_NUM");
					resultStr = res.getString("RESULT_STR") == null ? "" : res.getString("RESULT_STR");
					histDataType = res.getString("HIST_DATA_TYPE") == null ? "" : res.getString("HIST_DATA_TYPE");
					eventDate = res.getString("event_date") == null ? "" : res.getString("event_date");
					histRecTypeDesc = res.getString("hist_rec_type_desc") == null ? "" : res.getString("hist_rec_type_desc");

					if(!prevHistRecType.equals(histRecType))
					{
						displayData.append("<TR><TD colspan='4' class='spanId1' align='center'><B>"+histRecTypeDesc+"</B></TD></TR>");
					}

					if(!prevEventDate.equals(eventDate))
					{
						displayData.append("<TR><TD colspan='4' class='spanId2' align='left' ><B>&nbsp;"+eventDate+"</B></TD></TR>");
					}

					displayData.append("<TR>");
					
					clb = res.getClob("hist_data");
					
					if(!histDataType.equals("HTM") && !histDataType.equals("TXT"))
					{
						displayData.append("<TD class='"+classValue+"' width='1%'>&nbsp;</TD>");
						displayData.append("<TD class='"+classValue+"' width='15%'>");
						displayData.append(longDesc);
						displayData.append("</TD>");
						displayData.append("<TD class='"+classValue+"' width='1%'>");
						displayData.append("&nbsp;: ");
						displayData.append("</TD>");
					}
					if(histDataType.equals("TXT"))
					{
						displayData.append("<TD class='"+classValue+"' width='1%'>&nbsp;</TD>");
						displayData.append("<TD class='"+classValue+"' width='15%'>");
						displayData.append(longDesc);
						displayData.append("</TD>");
					}


					if(histDataType.equals("NUM"))
					{
						displayData.append("<TD class='"+classValue+"' width='25%'>");
						displayData.append("&nbsp; "+resultNum+"</TD>");
						if(!resultStr.equals(""))
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"' >&nbsp;</TD>");
							displayData.append("<TD class='"+classValue+"' colspan='3'>");
							displayData.append("&nbsp;"+resultStr+"</TD>");
						}
					}
					else if(histDataType.equals("STR"))
					{
						displayData.append("<TD class='"+classValue+"' width='25%'>");
						displayData.append("&nbsp;"+resultStr);
						displayData.append("</TD>");
					}

					if((histDataType.equals("HTM") || histDataType.equals("TXT")))
					{
						if((clb!=null) && (clb.length()>0))
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"'>&nbsp;</TD>");
							displayData.append("<TD class='"+classValue+"'  colspan='3'>");
							displayData.append(clb.getSubString(1,((int)clb.length())));
							displayData.append("</TD>");
						}
						else
						{
							displayData.append("</TR>");
							displayData.append("<TR>");
							displayData.append("<TD class='"+classValue+"' colspan='4'>&nbsp;</TD>");
						}
					}
					displayData.append("</TR>");
				}
				displayData.append("</TABLE>");
				if(res != null) res.close();
				if(ps != null) ps.close();
			}
			prevEventDate = eventDate;
			prevHistRecType = histRecType;
		} */
	}
	catch(Exception e)
	{
		
		//out.println("Exception in try of RecClinicalNotesLinkMultiHistEmailDetails.jsp --"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(res != null) res.close();
		if(ps != null) ps.close();
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}  
	StringBuffer dispData = new StringBuffer();
	dispData.append("<table width='100%' cellpadding=0 cellspacing=0 border='0'>");
	dispData.append("<tr>");
	dispData.append("<td align='center'><h3>"+facilityName+"</h3></td>");
	dispData.append("</tr>");
	dispData.append("<tr>");
	dispData.append("<td align='center' ><h4>"+reportDesc+"</h4></td>");
	dispData.append("</tr>");
	dispData.append("</table>");
//	dispData.append("<PRE style='word-wrap:break-word;margin-right:5%'>");
	dispData.append(displayData.toString());
//	dispData.append("</PRE>");
	dispData.append("<table width='100%' cellpadding=0 cellspacing=0>");
	dispData.append("<tr>");
	dispData.append("<td align='left'><b>"+loggedUser+" : "+UserName+"</b></td>");
	dispData.append("<td align='right'><b>"+dateTime+" : "+printDateTime+"</b></td>");
	dispData.append("</tr>");
	dispData.append("</table>");
	//out.println(dispData);
	CA_EmailRepBodyTxtBean.clearBean();
	CA_EmailRepBodyTxtBean.setReportText(dispData.toString());


	putObjectInBean(beanKey,CA_EmailRepBodyTxtBean,session);

%>
<style>
	ADDRESS	{ FONT-FAMILY: Arial ;FONT-SIZE: 10pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }
	PRE
	{
		font-size: 8pt ;
		Font-Family : verdana;
		BACKGROUND-COLOR: #E2E3F0;
		BORDER-STYLE: none;
		font-Weight : bold;
		text-align: left;
		WORD-WRAP: break-word
	}

	TD.spanId1
	{
		BACKGROUND-COLOR: #637BBD;
		font-size: 14pt ;
		Font-Family : Verdana;
		BORDER-STYLE: solid;
		font-Weight: bold;
		text-align: center;
		width: 780;
		padding-top: 3;
		padding-bottom: 3;
		WORD-WRAP: break-word
	}
	
	TD.spanId2
	{
		BACKGROUND-COLOR: #B0C4DE;
		font-size: 10pt ;
		Font-Family : Verdana;
		BORDER-STYLE: solid;
		font-Weight: bold;
		text-align: left;
		width: 780;
		padding-top: 3;
		padding-bottom: 3;
		WORD-WRAP: break-word
	}
</style>
		</form>
	</body>
</html>
<script>
	self.location.href = '../../eCommon/jsp/error.jsp'
	
		var title = '<%=title%>';
		var action_url = '../../eCA/jsp/EMail.jsp';
		action_url +=	"?title="+encodeURIComponent(title,"UTF-8")+"&module_id=CA&report_id=AHCLINREP&p_report_type=H&beanKey=<%=beanKey%>&p_file_name=EncountersEmailDetails.jsp&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>";	
	//	var win = window.open(action_url,'emailWin','height=570,width=790,top=70,left=120,resizable=yes,scrollbars=yes');
	
	//	var retVal			=  ""; //new String();
		var dialogTop		= "50";
		var dialogHeight	= "50" ;
		var dialogWidth		= "60" ;
		var features		= "dialogTop:"+dialogTop+"dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments		= "" ;		
		
		window.showModalDialog(action_url,arguments,features); 

</script>

