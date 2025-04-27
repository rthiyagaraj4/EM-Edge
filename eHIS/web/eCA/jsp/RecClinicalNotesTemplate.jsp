<?xml version='1.0' encoding="UTF-8"?>
<%@page contentType="application/xml;charset=UTF-8" import="org.w3c.dom.*,java.sql.*,eCA.*,eCA.Common.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"%><!--IN071264-->

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//IN041284 Start.
	String dispResLinkHYMLYN 		=(request.getParameter("dispResLinkHYMLYN")==null)?"N":(String)request.getParameter("dispResLinkHYMLYN");	
	String noteSplCharValidate 		=(request.getParameter("noteSplCharValidate")==null)?"N":(String)request.getParameter("noteSplCharValidate"); //IN059571	
	
//IN069884, starts
ArrayList funcIds = new ArrayList();
funcIds.add("REC_CLI_NTS_RESTRICT_RIGHT_CLK");
funcIds.add("FORMULA_COMP_DELETE_ENABLE");  //IN072304
CaAdapter obj = new CaAdapter();
obj.setSiteSpecific(funcIds,"CA");
String is_ss_restrict_right_click = obj.isSiteSpecific("REC_CLI_NTS_RESTRICT_RIGHT_CLK")?"Y":"N";
String formulaCompDelOptionEnable = obj.isSiteSpecific("FORMULA_COMP_DELETE_ENABLE")?"Y":"N";  //IN072304
//IN069884, ends
if("Y".equals(dispResLinkHYMLYN) && "N".equals(noteSplCharValidate)){
%>
<?xml-stylesheet type="text/xsl" href="../html/RecClinicalNotesTemplateRecordingViewHTMLTextArea.xsl"?>
<%
//IN059571 Start. 
}else if("Y".equals(dispResLinkHYMLYN) && "Y".equals(noteSplCharValidate)){
%>
<?xml-stylesheet type="text/xsl" href="../html/RecClinicalNotesTemplateRecordingViewHTMLTextArea_SplVald.xsl"?>
<%
}else if("N".equals(dispResLinkHYMLYN) && "N".equals(noteSplCharValidate)){
%>
<?xml-stylesheet type="text/xsl" href="../html/RecClinicalNotesTemplateRecordingView.xsl"?>
<%
}else if("N".equals(dispResLinkHYMLYN) && "Y".equals(noteSplCharValidate)){
%>
<!--<?xml-stylesheet type="text/xsl" href="../html/RecClinicalNotesTemplateRecordingView__SplVald.xsl"?>--><!--IN063963-->
<?xml-stylesheet type="text/xsl" href="../html/RecClinicalNotesTemplateRecordingView_SplVald.xsl"?><!--IN063963-->
<%
//IN059571 End.
} //IN041284%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

	//StringBuffer traceBeanOBJ = new StringBuffer();

	//traceBeanOBJ.append("sectionBean Object in Bean RecClinicalNotesTemplate.jsp at 8  ====>>>"+sectionBean+"   login_user   :    "+(String)session.getValue("login_user")+"***    session  :    "+session+"**encounter_id**"+request.getParameter("episode_id")+"**patient_id**"+request.getParameter("patient_id")+"**");

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<DOCUMENT FORM-NAME="RecClinicalNotesTemplateForm" ID="RecClinicalNotesTemplateForm">
<SITE-SPECIFIC RESTRICT_RIGHT_CLICK='<%=is_ss_restrict_right_click%>'  FORMULA_COMP_DELETE_ENABLE='<%=formulaCompDelOptionEnable%>' ></SITE-SPECIFIC><!--IN069884-SITE_SPECIFIC--> <!-- IN072304 -->
<CSS sStyle="<%=sStyle%>"/>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/common.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/showModalDialog.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/ValidateControl.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/dchk.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCommon/js/DateUtils.js'></SCRIPT><!--Added for IN071708 -->
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart1.js'></SCRIPT>
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/RecClinicalNotesPart2.js'></SCRIPT>
<SCRIPT type='text/javascript' SRC='../../eCommon/js/CommonCalendar.js'></SCRIPT>
<SCRIPT type='text/javascript' SRC='../../eCA/js/RecClinicalNotesTempCompDfltValLookup.js'></SCRIPT>
<!--included for 10261 in 07/06/09-->
<SCRIPT LANGUAGE='javascript' SRC='../../eCA/js/SpeciltyEvents.js'></SCRIPT>

<STYLE type="text/css">
	.READONLY
	{
		BACKGROUND-COLOR: #C0C0C0;
	}
</STYLE>
<STYLE>
	textarea {
	  	resize: none;
	}
</STYLE>
<%
	Connection			con					=	null;
	PreparedStatement	pstmt				=	null;
	ResultSet			rs					=	null;

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;

	boolean	templateExists					=	false;

	String  locale							=	(String) p.getProperty("LOCALE");
	String	templateMode					=	"Insert";
	String	curr_sec_hdg_code				=	"";
	String	curr_section_type				=	"";
	String	curr_child_sec_hdg_code			=	"";
	String	sub_sec_content_type			=	"";
	String	childSecContentType				=	"";
	String	patientId						=	"";
	String	encounter_id					=	"";
	String  systemDateTime					=	""; 
	String  systemDate						=	""; 
	String  template_title						=	""; 
	//
	/*String  DISCR_MSR_ID						=	"";
	String  NUM_REF_LOW						=	"";
	String  NUM_REF_HIGH						=	"";
	String  NUM_CRIT_LOW						=	"";
	String  NUM_CRIT_HIGH						=	"";
	String  START_AGE_DAYS						=	"";
	String  END_AGE_DAYS						=	""; */
	String  dob						=	"";
	String  sex						=	"";
	
	
	
	
	StringBuffer contentXML=new StringBuffer();

	try
	{
	con	= ConnectionManager.getConnection(request);
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

	curr_sec_hdg_code		= (request.getParameter("curr_sec_hdg_code")==null)?"":request.getParameter("curr_sec_hdg_code");
	curr_section_type		= (request.getParameter("curr_section_type")==null)?"":request.getParameter("curr_section_type");
	curr_child_sec_hdg_code = (request.getParameter("curr_child_sec_hdg_code")==null)?"":request.getParameter("curr_child_sec_hdg_code");
	template_title = (request.getParameter("template_title")==null)?"":request.getParameter("template_title");
	patientId				= (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	encounter_id			= (request.getParameter("episode_id")==null)?"":request.getParameter("episode_id");
	sex			= (request.getParameter("Sex")==null)?"":request.getParameter("Sex");
	dob			= (request.getParameter("Dob")==null)?"":request.getParameter("Dob");
	//IN071264 Starts
	String auto_save_yn ="N";
	CAClinicalNotesAutoSaveBean  autoSaveBean = new CAClinicalNotesAutoSaveBean();
	auto_save_yn = autoSaveBean.getAutoSaveNoteYN();
	String existingContentXMLTemp	=	"";
	String beanContentXMLTemp	=	"";
	//IN071264 Ends
	String existingContentXML	=	"";
	String beanContentXML	=	"";
	String ageDependentCompIds = "",compDependentAgeGrps="";
	
	String strKey	=	"";

	strKey = patientId + "~"+ encounter_id;
	strKey = strKey.trim();
	
	sectionBean.getPatientSection(strKey);
	
	if(curr_section_type.equals("T") )
	{
		//IN071264 Starts
		// existingContentXML=(String)sectionBean.getSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code);
		  if("Y".equals(auto_save_yn)){
			 existingContentXMLTemp=(String)sectionBean.getSectionContent("temp"+curr_sec_hdg_code,"temp"+curr_child_sec_hdg_code);
		 }
		 if(null!=existingContentXMLTemp && !"".equals(existingContentXMLTemp)){
			 existingContentXML =existingContentXMLTemp;
		 }
		 else{
			 existingContentXML=(String)sectionBean.getSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code);
		 }
		//IN071264 Ends

		
		if(existingContentXML == null)
			existingContentXML = "";

		
		sub_sec_content_type = sectionBean.getSectionLevel(curr_sec_hdg_code,curr_child_sec_hdg_code);

	}

	//traceBeanOBJ.append("existingContentXML  ..."+existingContentXML);	

	if(existingContentXML!=null && !existingContentXML.equals(""))
	{		
		eCA.DomParser parser = new eCA.DomParser();
		StringBuffer sectionContentXML = new StringBuffer(existingContentXML);		
		sectionContentXML = parser.updateXMLLanguageIDValues(sectionContentXML, locale);
		existingContentXML = sectionContentXML.toString();		
		
		//[IN032326]existingContentXML = existingContentXML.replaceAll("&lt;br&gt;","");
		contentXML.append(existingContentXML);
		templateMode	=	"Update";
		templateExists =   true;
	}

		
		if(templateMode.equals("Insert"))//get the XML content from the master table 
		{
			
			String query = " Select AGE_GRP_DEP_COMP_INFO,DEP_AGE_GRP_INFO,TEMPLATE_FORMAT from CA_SECTION_HDG where sec_hdg_code = ? ";

			pstmt =	con.prepareStatement(query);
								
			if(sub_sec_content_type.equals("S") && curr_section_type.equals("T"))
				
				pstmt.setString(1,curr_child_sec_hdg_code);
			
			else if(curr_section_type.equals("T"))
			
				pstmt.setString(1,curr_sec_hdg_code);
			
			rs	= pstmt.executeQuery();			
			
			if(rs.next())
			{
				ageDependentCompIds = rs.getString(1)==null?"":rs.getString(1); 
				compDependentAgeGrps = rs.getString(2)==null?"":rs.getString(2);
				Clob clb = rs.getClob(3);				

				if(clb!=null)
				{
					java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
					String line = null;

					while((line=r.readLine()) != null) 
					{
						contentXML.append(line);
					}
				}

				
			}
			
	
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
	
			if(!ageDependentCompIds.equals(""))
			{
				
				
				String functionSQL = "Select ca_comp_visibility(?,?) from dual";
				pstmt =con.prepareStatement(functionSQL);
				pstmt.setString(1,compDependentAgeGrps);
				pstmt.setString(2,patientId);
				rs = pstmt.executeQuery();

				if(rs.next())
				{
					String ageDependentResults = rs.getString(1);
					
					
					eCA.AgeGroupCodeDependencyParser ageGroupBeanObj=new eCA.AgeGroupCodeDependencyParser();
					contentXML = ageGroupBeanObj.removeAgeDependentComponents(contentXML,ageDependentCompIds,ageDependentResults);
				}
				
			}
	
		/*	if (!locale.equals("en"))
			{
				if ((contentXML != null) && !(contentXML.toString().equals(""))){
					eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,curr_sec_hdg_code,locale,contentXML);
					contentXML = tempLangParse.getLangReplacedXML();
					tempLangParse = null;
				}
			}		
			if(curr_section_type.equals("T"))
			{			
				if ((contentXML != null) && !(contentXML.toString().equals("")))
				{							
					eCA.TemplateRangeParser tempRangeParse = new eCA.TemplateRangeParser(con,curr_sec_hdg_code,sex,dob,contentXML);
					contentXML = tempRangeParse.getRangePlacedXML();
					tempRangeParse = null; 							
				}
			} */

			if (!locale.equals("en") && curr_section_type.equals("T"))
			{
				HashMap<String,String> paramMap = new HashMap<String,String>();
				paramMap.put("CURR_SEC_HDG_CODE",curr_sec_hdg_code);
				paramMap.put("LOCALE",locale);
				paramMap.put("SEX",sex);
				paramMap.put("DOB",dob);
				paramMap.put("RANGE_PASER_YN","Y");
				if ((contentXML != null) && !(contentXML.toString().equals("")))
				{
					eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,contentXML);
					contentXML = tempLangParse.getLangReplacedXML();
					tempLangParse = null;
				}
			}else if(curr_section_type.equals("T"))
			{			
				if ((contentXML != null) && !(contentXML.toString().equals("")))
				{							
					eCA.TemplateRangeParser tempRangeParse = new eCA.TemplateRangeParser(con,curr_sec_hdg_code,sex,dob,contentXML);
					contentXML = tempRangeParse.getRangePlacedXML();
					tempRangeParse = null; 							
				}
			} 
				
			
			if(curr_section_type.equals("T"))
				sectionBean.setSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code,contentXML.toString());		
				
				putObjectInBean("sectionBean",sectionBean,session);

				beanContentXML = (String)sectionBean.getSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code);
				
				if(contentXML.length() > 0){
					contentXML.delete(0,contentXML.length());
				}
				contentXML.append(beanContentXML);

			//	traceBeanOBJ.append("curr_section_type  ..."+curr_section_type+"...ContentXML in NotesTemplate at 216 ..."+sectionBean.getSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code));
			templateExists =   true;
		}
		else if(templateMode.equals("Update"))//get the content from the bean and display 
		{
			if (! locale.equals("en") )
			{
				HashMap<String,String> paramMap = new HashMap<String,String>();
				paramMap.put("CURR_SEC_HDG_CODE",curr_sec_hdg_code);
				paramMap.put("LOCALE",locale);				
				paramMap.put("RANGE_PASER_YN","N");
				eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,contentXML);
			//	contentXML = tempLangParse.getLangReplacedXML(); //Commentted --[IN033507]
				tempLangParse = null;
			}

		}
		
		System.out.println("************* Content XML **********  "+contentXML.toString());
			
%>
		
		<%=
		
		(contentXML.toString()).replaceAll("<FORMULA-COMP", "<FORMULA-COMP FORMULA_COMP_DELETE_ENABLE='"+formulaCompDelOptionEnable+"'")
		
		%><!-- IN072304 -->	
		<%
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
		//out.println("Exception@2: "+e);//common-icn-0181
	}
	finally
	{
		if(con!=null)	ConnectionManager.returnConnection(con,request);


	}
%>
<HIDDEN-FIELD NAME="CACalanderFun" VALUE="Y"></HIDDEN-FIELD>  
<HIDDEN-FIELD NAME="sec_hdg_code" VALUE="<%=curr_sec_hdg_code%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="sec_content_type" VALUE="<%=curr_section_type%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="child_sec_hdg_code" VALUE="<%=curr_child_sec_hdg_code%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="child_sec_content_type" VALUE="<%=childSecContentType%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="template_exists" VALUE="<%=templateExists%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="template_mode" VALUE="<%=templateMode%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="patient_id" VALUE="<%=patientId%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="encounter_id" VALUE="<%=encounter_id%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="systemDate99999A" VALUE="<%=systemDate%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="systemDateTime99999A" VALUE="<%=systemDateTime%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="template_title" VALUE="<%=template_title%>"></HIDDEN-FIELD>
<HIDDEN-FIELD NAME="dispResLinkHYMLYN" VALUE="<%=dispResLinkHYMLYN%>"></HIDDEN-FIELD><!--IN061907-->
<HIDDEN-FIELD NAME="locale" VALUE="<%=locale%>"></HIDDEN-FIELD><!--Added for IN071708 -->
</DOCUMENT>





