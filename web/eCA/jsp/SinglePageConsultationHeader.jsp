<!DOCTYPE html>
<%
/*  							 
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
02/06/2014	  IN037701		Nijitha												SKR-CRF-0036- new file created.
20/09/2019		IN071408		SIVABAGYAM M		RAMESH G    20/09/2019				Regression-OR/RL-Existing Orders and Attached Images
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,java.net.*,java.lang.*,java.text.*,webbeans.eCommon.* "%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language=javascript src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' >
<form>
<%
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String patient_name = request.getParameter("patient_name") == null ? "" : request.getParameter("patient_name");
	
	String patient_class =  "";
	String speciality_name = "";
	String location_name = "";
	String patient_info = "";
	String location_desc = "";
	String adm_date_time = "";
	String discharge_date_time = "";
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");
	String facilityId = (String) session.getValue("facility_id") == null ? "" : (String) session.getValue("facility_id");
	StringBuilder patient_detail = new StringBuilder();
	String attending_practitioner = "";
	String admitting_practitioner = "";
	Hashtable htParameter=new Hashtable();
	String	section_content			=	"";
	String  sect_template_query		=	"";
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	PreparedStatement pstmt2 = null;
	ResultSet rs2 =	null;
	String	section_content_rpt		=	"";
	String age="";
	String sex="";
	String strSql = "";
	Connection con  = null;
	ResultSet oRs = null;
	PreparedStatement pstmt  = null;
	int paramIndex = 0;
	HashMap<String,String> paramMap = null;
	String  url1					=	"";
	String  url						=	"";
	//url   = HttpUtils.getRequestURL(request).toString();//IN071408
	//url = url.substring(0,url.indexOf("jsp/"));//IN071408
	url=application.getRealPath("/eCA/")+"/";//IN071408
	url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";//IN071408
	con =  ConnectionManager.getConnection(request);
	try
	{
		patient_detail = patient_detail.append("SELECT AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,(SELECT SHORT_NAME FROM am_practitioner WHERE practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,nvl(to_char(a.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') VISIT_ADM_DATE_TIME,AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,?,1) speciality_name,AM_GET_DESC.AM_PATIENT_CLASS(a.patient_class,?,1) patient_class,case when a.PAT_CURR_LOCN_TYPE in ('N','D','W') then ip_get_desc.ip_nursing_unit(a.facility_id,a.PAT_CURR_LOCN_CODE,?,'2') else op_get_desc.op_clinic(a.facility_id,a.PAT_CURR_LOCN_CODE,?,'2') end location_description,b.SEX gender,get_age(b.DATE_OF_BIRTH) AGE FROM PR_ENCOUNTER a, MP_PATIENT B WHERE A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? AND a.patient_id = ?");
		//patient_detail = patient_detail.append("SELECT AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,(SELECT SHORT_NAME FROM am_practitioner WHERE practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,a.DISCHARGE_DATE_TIME,TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') VISIT_ADM_DATE_TIME,a.SPECIALTY_CODE speciality_name,a.patient_class patient_class,case when a.PAT_CURR_LOCN_TYPE in ('N','D','W') then ip_get_desc.ip_nursing_unit(a.facility_id,a.PAT_CURR_LOCN_CODE,?,'2') else op_get_desc.op_clinic(a.facility_id,a.PAT_CURR_LOCN_CODE,?,'2') end location_description,b.SEX gender,get_age(b.DATE_OF_BIRTH) AGE FROM PR_ENCOUNTER a, MP_PATIENT B WHERE A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? AND a.patient_id = ?");
		pstmt = con.prepareStatement(patient_detail.toString());
		pstmt.setString(++paramIndex,locale);
		pstmt.setString(++paramIndex,locale);
		pstmt.setString(++paramIndex,locale);
		pstmt.setString(++paramIndex,locale);
		pstmt.setString(++paramIndex,locale);
		pstmt.setString(++paramIndex,encounter_id);
		pstmt.setString(++paramIndex,patient_id);
		oRs = pstmt.executeQuery();
		if (oRs.next())
		{
			attending_practitioner = oRs.getString("attending_practitioner");
			admitting_practitioner = oRs.getString("admitting_practitioner")==null?"":oRs.getString("admitting_practitioner");
			discharge_date_time = oRs.getString("DISCHARGE_DATE_TIME")==null?"":oRs.getString("DISCHARGE_DATE_TIME");
			adm_date_time = oRs.getString("VISIT_ADM_DATE_TIME")==null?"":oRs.getString("VISIT_ADM_DATE_TIME");
			speciality_name = oRs.getString("speciality_name")==null?"":oRs.getString("speciality_name");
			location_desc = oRs.getString("location_description")==null?"":oRs.getString("location_description");
			patient_class = oRs.getString("patient_class")==null?"":oRs.getString("patient_class");
			age = oRs.getString("AGE")==null?"":oRs.getString("AGE");
			sex = oRs.getString("gender")==null?"":oRs.getString("gender");
		}	
		if(oRs!=null) oRs.close();
		if(pstmt!=null) pstmt.close();
		
		try
		{
			sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
			pstmt2	= con.prepareStatement(sect_template_query);
			pstmt2.setString(1,"V$RH");
			rs2 = pstmt2.executeQuery();
			if(rs2.next())
			{
				clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
				if(clob_notes_content!=null)
				{
					try
					{
						content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
						bf_content_reader	= new java.io.BufferedReader(content_reader);
						char[] arr_notes_content = new char[(int)clob_notes_content.length()];
						bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
						section_content = new String(arr_notes_content);
						bf_content_reader.close();
						if(section_content == null)
							section_content = "";
					}
					catch(Exception e)
					{
						//out.println("Exception@1-readCLOB : "+e);//common-icn-0181
						e.printStackTrace();
					}
		
		
				}
			}
		}
		
		catch(Exception eee)
		{
			//out.println("Exceptionin SinglePageConsultationHeader.jsp getting section content : "+eee.toString());//COMMON-ICN-0181
			eee.printStackTrace();
		
		}
		finally
		{
			if(rs2 != null) rs2.close();
			if(pstmt2 != null) pstmt2.close();
			//if(con!=null) ConnectionManager.returnConnection(con,request);//6/5/2014
		}
		
		if(!adm_date_time.equals(""))
		{
			adm_date_time					=	com.ehis.util.DateUtils.convertDate(adm_date_time,"DMYHM","en",locale);
		}
		
		if(!discharge_date_time.equals(""))
		{
			discharge_date_time					=	com.ehis.util.DateUtils.convertDate(discharge_date_time,"DMYHM","en",locale);
		}
		if(sex.equals("M"))
			sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		else if (sex.equals("F"))
			sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		else 
			sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		htParameter.put("V$ATT_PRACT", attending_practitioner);
		htParameter.put("V$ADM_PRACT", admitting_practitioner);
		htParameter.put("V$PT_SPLTY", speciality_name);
		htParameter.put("V$PT_NAME", patient_name);
		htParameter.put("V$PT_ID", patient_id);
		htParameter.put("V$SEX", sex);
		htParameter.put("V$AGE", age);
		htParameter.put("V$ENC_ID", encounter_id);
		htParameter.put("V$ADM_DT", adm_date_time);
		htParameter.put("V$DIS_DT", discharge_date_time);
		htParameter.put("V$PT_LOCN", location_desc);
		htParameter.put("V$PT_CLASS", patient_class);

		StringBuffer section_content_new = new StringBuffer(section_content);
		
		if (! locale.equals("en") )
		{
			if(!section_content_new.toString().equals(""))
			{
				paramMap = new HashMap<String,String>();
				paramMap.put("CURR_SEC_HDG_CODE","V$RH");
				paramMap.put("LOCALE",locale);						
				paramMap.put("RANGE_PASER_YN","N");
				eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
				section_content_new = tempLangParse.getLangReplacedXML();
				tempLangParse = null;
			}
		
		
		}
		
		if(!section_content_new.toString().equals(""))
		{					
			eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
			HashMap paramHash=new HashMap();
			Hashtable tempParameter=new Hashtable();
			paramHash.put("#p_patient_id#",patient_id);
			paramHash.put("#p_encounter_id#",encounter_id);
			paramHash.put("#p_locale#",locale);
			paramHash.put("#p_facility_id#",facilityId);
			tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);								
			if(tempParameter.size()>0){					
			htParameter.putAll(tempParameter);
			}
			sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
		}
		
		if(!(sectionContentUpdatedXML.toString().equals("")))
		{								
			section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
			
		}
	}
	catch(Exception eee)
	{
		//out.println("Exceptionin SinglePageConsultationHeader.jsp: "+eee.toString());//COMMON-ICN-0181
		eee.printStackTrace();
	}
	finally
	{
		if(con!=null) //6/5/2014
			ConnectionManager.returnConnection(con,request);//6/5/2014
	}
	

%>	
	<table border='2'cellpadding='0' cellspacing='4' width='100%'><tr><td><%=section_content_rpt%></td></tr></table><BR>
		
</form>
</body>
</html>

