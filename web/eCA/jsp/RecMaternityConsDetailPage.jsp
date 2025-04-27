<!DOCTYPE html>
<%@page contentType="application/xml;charset=UTF-8" import="org.w3c.dom.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%>
<?xml version='1.0' encoding="UTF-8"?>
<?xml-stylesheet type="text/xsl" href="../html/RecClinicalNotesTemplateRecordingView_MC.xsl"?>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	webbeans.eCA.RecClinicalNotesSectionBean matBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("matBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

	String facility_id       = (String) session.getValue("facility_id");



	String patientId = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String sectionType = request.getParameter("sectionType") == null ? "" : request.getParameter("sectionType");
	String encounterId = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	String securityLevel = request.getParameter("security_level") == null ? "" : request.getParameter("security_level");
	String patientClass = request.getParameter("patient_class") == null ? "" : request.getParameter("patient_class");
	String moduleId = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String accessionNum = request.getParameter("accessionNum") == null ? "" : request.getParameter("accessionNum");
	String cycle_no = request.getParameter("cycle_no") == null ? "" : request.getParameter("cycle_no");
	String splty_event_code = request.getParameter("splty_event_code") == null ? "" : request.getParameter("splty_event_code");
	String splty_task_code = request.getParameter("splty_task_code") == null ? "" : request.getParameter("splty_task_code");
	String modeValue = request.getParameter("modeValue") == null ? "" : request.getParameter("modeValue");		
	String close_episode_yn = request.getParameter("close_episode_yn") == null ? "" : request.getParameter("close_episode_yn");
	String outcome_event_code = request.getParameter("outcome_event_code") == null ? "" : request.getParameter("outcome_event_code");
	String outcome_code = request.getParameter("outcome_code") == null ? "" : request.getParameter("outcome_code");
	String closeFlag = request.getParameter("closeFlag") == null ? "N" : request.getParameter("closeFlag");
	String birth_order = request.getParameter("birth_order") == null ? "1" : request.getParameter("birth_order");
	//String accessionNum = request.getParameter("accessionNum") == null ? "" : request.getParameter("accessionNum");

	
	
	
%>
<DOCUMENT FORM-NAME="RecClinicalNotesTemplateForm" >
<CSS sStyle="<%=sStyle%>"/>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/common.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/ValidateControl.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart1.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart2.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/dchk.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/DateUtils.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecMaternityCons.js'></SCRIPT>
<SCRIPT type='text/javascript' SRC='../../eCommon/js/CommonCalendar.js'></SCRIPT>
<SCRIPT type='text/javascript' SRC='../../eCA/js/SpeciltyEvents.js'></SCRIPT>

<STYLE type="text/css">
	.READONLY
	{
		BACKGROUND-COLOR: #C0C0C0;
	}
</STYLE>

<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet res = null;
	ResultSet rs = null;
	String  systemDateTime					=	""; 
	String  systemDate						=	"";
	//String  updatedxmlContent						=	"";
	ArrayList paramList = new ArrayList();


//
	con = ConnectionManager.getConnection(request);
	String query1 = " Select  to_char(sysdate, 'dd/mm/yyyy hh24:mi') systemDateTime, to_char(sysdate, 'dd/mm/yyyy') systemDate  from dual  ";
	pstmt		=	con.prepareStatement(query1);
	rs			=	pstmt.executeQuery();

	if(rs.next())
	{
		systemDateTime		= rs.getString("systemDateTime");
		systemDate			= rs.getString("systemDate");
	}
	
	if(rs !=null) rs.close();
	if(pstmt !=null) pstmt.close();

//
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" );
	String  locale = (String) p.getProperty("LOCALE");

	String secHdgCode = request.getParameter("sec_hdg_code") == null ? "" : request.getParameter("sec_hdg_code");
	String subSecHdgCode = request.getParameter("sub_sec_hdg_code") == null ? secHdgCode :  request.getParameter("sub_sec_hdg_code");
	StringBuffer xmlContent = new StringBuffer();
	String tempDisp = "";
	
	eCA.DomParser parser = new eCA.DomParser();

	paramList.add(facility_id);
	paramList.add(encounterId);
	paramList.add(secHdgCode);
	if(cycle_no.equals(""))
		cycle_no = "0";
	paramList.add(cycle_no);
	paramList.add(patientId);

	
 
	if(!secHdgCode.equals("") && !subSecHdgCode.equals(""))
	{		
		tempDisp = (String) matBean.getSectionContent(secHdgCode,subSecHdgCode);
		
	}

	if(tempDisp == null || tempDisp.equals(""))
	{
		
		try
		{	
			String query = "";
			if(modeValue.equals("T"))
			{
			
				query = " select XML_CONTENT TEMPLATE_FORMAT from CA_PAT_SPLTY_TASK_DTL where ACCESSION_NUM = ? and HDR_CODE = ? and SUBHDR_CODE = ? " ;

			}
			else
			{

			//con = ConnectionManager.getConnection(request);
				query = " Select TEMPLATE_FORMAT  from CA_SECTION_HDG where sec_hdg_code = ? ";
			
			}
			pstmt = con.prepareStatement(query);
			
			if(modeValue.equals("T"))
			{
				pstmt.setString	(1,accessionNum);
				pstmt.setString	(2,secHdgCode);
				pstmt.setString	(3,subSecHdgCode);

			}
			else
			{
				pstmt.setString	(1,subSecHdgCode);
			}
			res = pstmt.executeQuery();		
			if(res.next())
			{
				Clob tmplFormat = (Clob) res.getClob("TEMPLATE_FORMAT");
				if(tmplFormat !=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(tmplFormat.getCharacterStream());
					String line = null;

					while((line=r.readLine()) != null) 
					{
						xmlContent.append(line);
					}
				}
			}

						
			//if (!locale.equals("en") )
			//{
				HashMap<String,String> paramMap = new HashMap<String,String>();
				//paramMap.put("CURR_SEC_HDG_CODE",secHdgCode);
				paramMap.put("CURR_SEC_HDG_CODE",subSecHdgCode);
				paramMap.put("LOCALE",locale);						
				paramMap.put("RANGE_PASER_YN","N");
				eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,xmlContent);
				xmlContent = tempLangParse.getLangReplacedXML();
				tempLangParse = null;
			//}
			
		
		if(!modeValue.equals("T") && !xmlContent.toString().equals(""))
		{				
			xmlContent = parser.updateXMLContent(xmlContent, locale,con,paramList);			
		}

		if(!secHdgCode.equals("")&&!subSecHdgCode.equals(""))
			{
				matBean.setSectionValues(secHdgCode,subSecHdgCode,"","","","","","", "","", xmlContent.toString(), "","");
				matBean.setSectionContent(secHdgCode,subSecHdgCode,xmlContent.toString());
				putObjectInBean("matBean",matBean,session);
			}

			if(res!=null) res.close();
			if(pstmt!=null) pstmt.close();		
		}//end of try-main
		catch(Exception e)
		{			
			e.printStackTrace();
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}
	}
	else
	{		
		xmlContent.append(tempDisp);
		if(!modeValue.equals("T") && !xmlContent.toString().equals(""))
		{	
			xmlContent = parser.updateXMLContent(xmlContent, locale,con,paramList);
			
		}		
	}
%>
	<%=xmlContent.toString()%>
	
<HIDDEN-FIELD NAME="patientId" VALUE="<%=patientId%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="encounterId" VALUE="<%=encounterId%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="securityLevel" VALUE="<%=securityLevel%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="patientClass" VALUE="<%=patientClass%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="secHdgCode" VALUE="<%=secHdgCode%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="subSecHdgCode" VALUE="<%=subSecHdgCode%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="moduleId" VALUE="<%=moduleId%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="sectionType" VALUE="<%=sectionType%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="accessionNum" VALUE="<%=accessionNum%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="cycle_no" VALUE="<%=cycle_no%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="splty_event_code" VALUE="<%=splty_event_code%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="splty_task_code" VALUE="<%=splty_task_code%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="modeValue" VALUE="<%=modeValue%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="close_episode_yn" VALUE="<%=close_episode_yn%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="outcome_code" VALUE="<%=outcome_code%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="outcome_event_code" VALUE="<%=outcome_event_code%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="closeFlag" VALUE="<%=closeFlag%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="birth_order" VALUE="<%=birth_order%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="finalize_yn" VALUE=""></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="systemDate99999A" VALUE="<%=systemDate%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="systemDateTime99999A" VALUE="<%=systemDateTime%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="patient_id" VALUE="<%=patientId%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="encounter_id" VALUE="<%=encounterId%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="locale" VALUE="<%=locale%>"></HIDDEN-FIELD>
</DOCUMENT>

