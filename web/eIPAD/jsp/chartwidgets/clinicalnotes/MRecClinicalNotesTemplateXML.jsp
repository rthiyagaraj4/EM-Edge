<!DOCTYPE html>
<%@page import="eIPAD.chartsummary.common.healthobject.PatContext"%>

<%@page import="java.sql.Clob"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Properties"%>

<%@page import="com.ehis.persist.PersistenceHelper"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>

<%@page import="eCA.AgeGroupCodeDependencyParser"%>
<%@page import="eCA.DomParser"%>
<%@page import="eCA.GridComponent"%>
<%@page import="eCA.TemplateLangRepParser"%>
<%@page import="eCA.TemplateRangeParser"%>
<%@page import="webbeans.eCA.RecClinicalNotesSectionBean"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
String SECTION_TYPE_TEMPLATE="T";
String SECTION_TYPE_SUB_SECTION="S";
StringBuffer contentXML				= new StringBuffer();
PatContext patContext= (PatContext)session.getAttribute("PatientContext");  
if(patContext!=null){
	
	String patientId					= checkForNull(patContext.getPatientId());
	String encounter_id					= checkForNull(patContext.getEncounterId());
	
	String gender = checkForNull(patContext.getGender());	//				= checkForNull(obj.getGender());
	String DOB = checkForNull(patContext.getDob()); //					= checkForNull(obj.getDob());
	
	/* String curr_sec_hdg_code			= checkForNull(obj.getCurrSecHeadingCode());
	String curr_section_type			= checkForNull(obj.getCurrentSecType());
	String curr_child_sec_hdg_code 		= checkForNull(obj.getCurrChildSecHeadingCode()); */
	
	String curr_sec_hdg_code = (request.getParameter("section_code") == null) ? "" : request.getParameter("section_code");
	String curr_child_sec_hdg_code = (request.getParameter("child_section_code") == null) ? "" : request.getParameter("child_section_code");
	String curr_section_type = (request.getParameter("child_section_type") == null) ? "" : request.getParameter("child_section_type");
	
	

	
	String sub_sec_content_type			= "";
	String existingContentXML			= "";
	String beanContentXML				= "";
	
	String	templateMode				= "Insert";
	boolean	templateExists				= false;
	
	String ageDependentCompIds 			= "";
	String compDependentAgeGrps			= "";
	String strKey						= patientId + "~"+ encounter_id;
	strKey = strKey.trim();
	
	java.util.Properties p 				= (java.util.Properties) session.getValue( "jdbc" ) ;
	String  locale						= (String) p.getProperty("LOCALE");
	
	Connection	con						=	null;
	PreparedStatement pstmt				=	null;
	ResultSet rs						=	null;
	
	con	= ConnectionManager.getConnection(request);
	
	try {
		RecClinicalNotesSectionBean sectionBean = (RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
		sectionBean.getPatientSection(strKey);
		
		if(curr_section_type.equals(SECTION_TYPE_TEMPLATE) )
		{
			existingContentXML=(String)sectionBean.getSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code);
			
			if(existingContentXML == null) existingContentXML = "";
			
			sub_sec_content_type = sectionBean.getSectionLevel(curr_sec_hdg_code,curr_child_sec_hdg_code);
	
		}
		
		if(existingContentXML!=null && !existingContentXML.equals(""))
		{		
			DomParser parser = new DomParser();
			StringBuffer sectionContentXML = new StringBuffer(existingContentXML);		
			sectionContentXML = parser.updateXMLLanguageIDValues(sectionContentXML, locale);
			existingContentXML = sectionContentXML.toString();		
			
			contentXML.append(existingContentXML);
			templateMode	=	"Update";
			templateExists =   true;
		}
		
		if(templateMode.equals("Insert"))//get the XML content from the master table 
		{
			
			String query = " Select AGE_GRP_DEP_COMP_INFO,DEP_AGE_GRP_INFO,TEMPLATE_FORMAT from CA_SECTION_HDG where sec_hdg_code = ? ";
	
			pstmt =	con.prepareStatement(query);
								
			if(sub_sec_content_type.equals(SECTION_TYPE_SUB_SECTION) && curr_section_type.equals(SECTION_TYPE_TEMPLATE))
				
				pstmt.setString(1,curr_child_sec_hdg_code);
			
			else if(curr_section_type.equals(SECTION_TYPE_TEMPLATE))
			
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
					AgeGroupCodeDependencyParser ageGroupBeanObj=new AgeGroupCodeDependencyParser();
					contentXML = ageGroupBeanObj.removeAgeDependentComponents(contentXML,ageDependentCompIds,ageDependentResults);
				}
				
			}
	
			if (!locale.equals("en") && curr_section_type.equals(SECTION_TYPE_TEMPLATE))
			{
				HashMap<String,String> paramMap = new HashMap<String,String>();
				paramMap.put("CURR_SEC_HDG_CODE",curr_sec_hdg_code);
				paramMap.put("LOCALE",locale);
				paramMap.put("SEX",gender);
				paramMap.put("DOB",DOB);
				paramMap.put("RANGE_PASER_YN","Y");
				
				if ((contentXML != null) && !(contentXML.toString().equals("")))
				{
					TemplateLangRepParser tempLangParse = new TemplateLangRepParser(con,paramMap,contentXML);
					contentXML = tempLangParse.getLangReplacedXML();
					tempLangParse = null;
				}
			}
			
			else if(curr_section_type.equals(SECTION_TYPE_TEMPLATE))	{
				
				if ((contentXML != null) && !(contentXML.toString().equals("")))
				{							
					TemplateRangeParser tempRangeParse = new TemplateRangeParser(con,curr_sec_hdg_code,gender,DOB,contentXML);
					contentXML = tempRangeParse.getRangePlacedXML();
					tempRangeParse = null; 							
				}
			} 
				
			
			if(curr_section_type.equals(SECTION_TYPE_TEMPLATE))
				sectionBean.setSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code,contentXML.toString());		
				
				PersistenceHelper.putObjectInBean("sectionBean",sectionBean,session);
	
				beanContentXML = (String)sectionBean.getSectionContent(curr_sec_hdg_code,curr_child_sec_hdg_code);
				
				if(contentXML.length() > 0){
					contentXML.delete(0,contentXML.length());
				}
				contentXML.append(beanContentXML);
	
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
				TemplateLangRepParser tempLangParse = new TemplateLangRepParser(con,paramMap,contentXML);
				tempLangParse = null;
			}
	
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null)	ConnectionManager.returnConnection(con,request);
		
	} 
	
	catch (Exception e) {
		e.printStackTrace();
	}		
	
	//return contentXML;

}


response.setContentType("application/xml");
out.println(contentXML.toString());
//response.getWriter().write(contentXML.toString());

%>
<%!
public String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
}
public String checkForNull(String inputString, String defaultValue)
{
	if(inputString==null)inputString ="";
	return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
}
%> 
