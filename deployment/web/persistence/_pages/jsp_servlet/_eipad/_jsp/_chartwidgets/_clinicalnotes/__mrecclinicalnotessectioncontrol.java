package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Properties;
import com.ehis.persist.PersistenceHelper;
import webbeans.eCommon.ConnectionManager;
import eCA.AgeGroupCodeDependencyParser;
import eCA.DomParser;
import eCA.GridComponent;
import eCA.TemplateLangRepParser;
import eCA.TemplateRangeParser;
import webbeans.eCA.RecClinicalNotesSectionBean;

public final class __mrecclinicalnotessectioncontrol extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionControl.jsp", 1709118015412L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<!-- \ncode extracted fr\nvariable names are maintained same as in the RecClinicalNotesSectionControl.jsp\n -->\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

public String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
}
public String checkForNull(String inputString, String defaultValue)
{
	if(inputString==null)inputString ="";
	return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
PatContext patContext= (PatContext)session.getAttribute("PatientContext");  
String prev_sec_hdg_code					=		checkForNull(request.getParameter("section_code"));
String prev_child_sec_hdg_code				=		checkForNull(request.getParameter("child_section_code"));
String section_content						=		checkForNull(request.getParameter("section_content"));
if(patContext!=null && !prev_sec_hdg_code.equals("") && !prev_child_sec_hdg_code.equals("")){
	


String prev_sec_content_type				=		sectionBean.getSectionType(prev_sec_hdg_code,prev_child_sec_hdg_code);

String SECTION_TYPE_TEMPLATE="T";
String SECTION_TYPE_SUB_SECTION="S";

if(prev_sec_content_type.equals("F") || prev_sec_content_type.equals("R")){
	if(!(section_content.equals("")))
	{				
		sectionBean.setSectionContent(prev_sec_hdg_code,prev_child_sec_hdg_code, section_content); //IN040265,IN040266
	}
	else if(section_content.equals(""))
	{				
		sectionBean.removeSectionContent(prev_sec_hdg_code,prev_child_sec_hdg_code);
	}
}else if(prev_sec_content_type.equals("T")){
	
	
	String prev_result_link_type		= "";
	String prev_image_linked_yn			= "";
	String image_edited_yn				= checkForNull(request.getParameter("image_edited_yn"));
	String section_image_content		= checkForNull(request.getParameter("section_image_content"));
	String section_image_height			= checkForNull(request.getParameter("section_image_height"));
	String previousNote_accession_num	= checkForNull(request.getParameter("previousNote_accession_num"));

	
	
	String patientId					= checkForNull(patContext.getPatientId());
	String encounterId					= checkForNull(patContext.getEncounterId());
	
	String gender = checkForNull(patContext.getGender());	//				= checkForNull(obj.getGender());
	String DOB = checkForNull(patContext.getDob()); //					= checkForNull(obj.getDob());
	
	String grid_component_ids			= checkForNull(request.getParameter("grid_component_ids"));
	String no_of_rows					= checkForNull(request.getParameter("no_of_rows"));
	String clear_values					= checkForNull(request.getParameter("clear_values"));
	String operation_mode				= checkForNull(request.getParameter("operation_mode"));
	String accession_num				= checkForNull(request.getParameter("accession_num"));

	String sub_sec_content_type			= "";
	String existingContentXML			= "";
	String beanContentXML				= "";
	String	templateMode				= "Insert";
	boolean	templateExists				= false;
	String prev_section_type = "";
	
	String ageDependentCompIds 			= "";
	String compDependentAgeGrps			= "";
	String strKey						= patientId + "~"+ encounterId;
	strKey = strKey.trim();
	
	java.util.Properties p 				= (java.util.Properties) session.getValue( "jdbc" ) ;
	String  locale						= (String) p.getProperty("LOCALE");
	String appl_task_id					= checkForNull(request.getParameter("appl_task_id"),"CLINICAL_NOTES");
	String selection_type				= checkForNull(request.getParameter("selection_type"));
	
	Connection	con						=	null;
	PreparedStatement pstmt				=	null;
	ResultSet rs						=	null;
	
	Properties tempProp = null;
	
	StringBuffer sectionContentXML	=	new StringBuffer();
	StringBuffer sbSecFormat		=	new StringBuffer();
	StringBuffer sbOutFormat		=	new StringBuffer();
	
	String contentXML="";
	StringBuffer contentOutXML = new StringBuffer();
	
	/*String xslURL   = HttpUtils.getRequestURL(req).toString();
	xslURL = xslURL.substring(0,xslURL.indexOf("jsp/"));
	
	String xslURL1 = xslURL + "html/RecClinicalNotesTemplateDispayView.xsl"; */  /* Name of the XSL file in IPAD folder to be replaced*/	

	String url = request.getRequestURL().toString();
	String uri = request.getRequestURI();
	String root = url.substring( 0, url.indexOf(uri) ) + request.getContextPath();
	
	//xslURL   = HttpUtils.getRequestURL(request).toString();
	//xslURL = xslURL.substring(0,xslURL.indexOf("jsp/"));
	String xslURL1 = root + "/eCA/html/RecClinicalNotesTemplateDispayView.xsl";		
	
	try {
		con	= ConnectionManager.getConnection(request);
		strKey	= patientId + "~"+encounterId;
		strKey = strKey.trim();
		tempProp = sectionBean.getPatientSection(strKey);
		
		Hashtable htParameter=new Hashtable();
		Hashtable htPatdet=new Hashtable();
		Hashtable htOutParameter ;
		
		if(!(prev_sec_hdg_code.equals("")) || !(prev_child_sec_hdg_code.equals("")))
		{
			prev_section_type		= sectionBean.getSectionType(prev_sec_hdg_code,prev_child_sec_hdg_code);
			prev_result_link_type	= sectionBean.getResultLinked(prev_sec_hdg_code,prev_child_sec_hdg_code);
			prev_image_linked_yn	= sectionBean.getImageLinked(prev_sec_hdg_code,prev_child_sec_hdg_code);
		}
		
		/************** TODO: CHECK IF THE BELOW IS NEEDED *********/
		
		/*if(!(curr_sec_hdg_code.equals("")) || !(curr_child_sec_hdg_code.equals("")))
		{
			curr_section_type		= sectionBean.getSectionType(curr_sec_hdg_code,curr_child_sec_hdg_code);			
			curr_image_linked_yn	= sectionBean.getImageLinked(curr_sec_hdg_code,curr_child_sec_hdg_code);
			curr_result_link_yn		= sectionBean.getResultLinked(curr_sec_hdg_code,curr_child_sec_hdg_code);
			curr_result_link_type	= sectionBean.getHistoryType(curr_sec_hdg_code,curr_child_sec_hdg_code);
		}*/
		
		if(prev_section_type.equals(SECTION_TYPE_TEMPLATE))
		{
			try
			{
				Enumeration enumParameter=request.getParameterNames();
				
				String parameterName="";
				String parameterValue="";
						
				while(enumParameter.hasMoreElements())
				{
					parameterName=(String)enumParameter.nextElement();
					parameterValue = checkForNull(request.getParameter(parameterName));
					
					htParameter.put(parameterName, parameterValue);
					
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			htOutParameter = new Hashtable(htParameter);

			DomParser parser = new DomParser();
		
			contentXML=(String)sectionBean.getSectionContent(prev_sec_hdg_code,prev_child_sec_hdg_code);
						
			try
			{
				if (contentXML == null || contentXML.equals("") )
				{
					contentXML = "";
					PreparedStatement psSec = null;
					ResultSet rsSec = null;
			
					String strSecGetQuery = "Select AGE_GRP_DEP_COMP_INFO,DEP_AGE_GRP_INFO,TEMPLATE_FORMAT from CA_SECTION_HDG where sec_hdg_code = ? ";
			
					psSec =	con.prepareStatement(strSecGetQuery);
					psSec.setString(1,prev_child_sec_hdg_code);			
					rsSec	= psSec.executeQuery();		
						
					if(rsSec.next())
					{
						ageDependentCompIds		= rsSec.getString(1)==null?"":rsSec.getString(1); 
						compDependentAgeGrps	= rsSec.getString(2)==null?"":rsSec.getString(2);
						Clob clb = rsSec.getClob(3);				
					
						if(clb!=null)
						{
							java.io.BufferedReader r = new java.io.BufferedReader(clb.getCharacterStream());
							String line = null;
							
							while((line=r.readLine()) != null) 
							{
								sbSecFormat.append(line);
							}
						}
					}
					//check for the age group dependency and call a function to delete the component from the XML by parsing it
					if(rsSec!=null) rsSec.close();
					if(psSec!=null) psSec.close();

					PreparedStatement psage = null;
					ResultSet rsage = null;
	
					if(!ageDependentCompIds.equals(""))
					{
						String functionSQL = "Select ca_comp_visibility(?,?) from dual";
						psage =con.prepareStatement(functionSQL);

						psage.setString(1,compDependentAgeGrps);
						psage.setString(2,patientId);
						rsage = psage.executeQuery();

						if(rsage.next())
						{
							String ageDependentResults = rsage.getString(1);
							AgeGroupCodeDependencyParser ageGroupBeanObj=new AgeGroupCodeDependencyParser();
							sbSecFormat = ageGroupBeanObj.removeAgeDependentComponents(sbSecFormat,ageDependentCompIds,ageDependentResults);
						}
					}
					if(rsage!=null) rsage.close();
					if(psage!=null) psage.close();
				
					contentXML = sbSecFormat.toString();
				}
				if(!grid_component_ids.equals(""))
				{			
					GridComponent gridComp = new GridComponent();			
					contentXML = gridComp.updateXML(no_of_rows, contentXML).toString();			
					gridComp = null;
				}
				if (contentXML!= null && !contentXML.equals("") &&  clear_values.equals("clearTemplateValues"))
				{	
					htParameter = parser.clearComponentValues(new StringBuffer(contentXML),htParameter);
					htOutParameter = htParameter;
					
					sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
				}

				sectionContentXML.append(contentXML);	
				StringBuffer sectionContentUpdatedXML=new StringBuffer();
				
				if(!sectionContentXML.toString().equals("") && sectionContentXML != null && !clear_values.equals("clearTemplateValues"))
				{ 						
					String chk_Empty = parser.isTemplateEmpty(sectionContentXML,htParameter);							
					if(operation_mode.equals("") && chk_Empty.equals("false"))
					{						
						sectionBean.removeSectionContent( prev_sec_hdg_code,prev_child_sec_hdg_code);
					}
					
					
					if(chk_Empty.equals("true"))
					{
						eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
						HashMap paramHash=new HashMap();
						Hashtable tempParameter=new Hashtable();
						paramHash.put("#p_patient_id#",patientId);
						paramHash.put("#p_encounter_id#",encounterId);
						paramHash.put("#p_accNum#",accession_num);
						paramHash.put("#p_locale#",locale);
						
						tempParameter = dynamicCompDetails.getDynamicCompDetails(sectionContentXML,paramHash);
						
						if(tempParameter.size()>0){					
						htParameter.putAll(tempParameter);
						}

						sectionContentUpdatedXML=parser.updateXMLContentValues(sectionContentXML,htParameter,locale);
						sectionContentUpdatedXML=parser.removeEmptyValuesGridComp(sectionContentUpdatedXML);
					}
					
				}
				parser=null;				
				String output_yn =  "";

				output_yn = sectionBean.getOutputExistYN(prev_sec_hdg_code,prev_sec_hdg_code);
				
				if(output_yn.equals("Y") && !clear_values.equals("clearTemplateValues") && !sectionContentUpdatedXML.equals(""))
				{
					String output_format_qry ="select OUTPUT_XML_FORMAT from  CA_SEC_OUTPUT_FORM b where b.SEC_HDG_CODE =?" ;
					pstmt=	con.prepareStatement(output_format_qry);
					pstmt.setString(1,prev_sec_hdg_code);	
					rs	= pstmt.executeQuery();	

					if(rs.next())
					{
						
						Clob clb1 = rs.getClob("OUTPUT_XML_FORMAT");				
					
						if(clb1!=null)
						{
							java.io.BufferedReader r = new java.io.BufferedReader(clb1.getCharacterStream());
							String line = null;
							
							while((line=r.readLine()) != null) 
							{
								sbOutFormat.append(line);
							}
						}
					}
					
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

					contentOutXML = sbOutFormat;

				}
				StringBuffer contentOutUpdatedXML = new StringBuffer();
				
				htPatdet = sectionBean.getPatOutDetails(patientId);
				
				if(htPatdet!=null)
				{
					htOutParameter.put("PATIENT_ID",htPatdet.get("PATIENT_ID"));
					htOutParameter.put("PATIENT_NAME",htPatdet.get("PATIENT_NAME"));
					htOutParameter.put("REGN_DATE",htPatdet.get("REGN_DATE"));
					htOutParameter.put("GENDER",htPatdet.get("GENDER"));
					htOutParameter.put("RESIDENTAIL_ADDRESS",htPatdet.get("RESIDENTAIL_ADDRESS"));
					htOutParameter.put("AGE",htPatdet.get("AGE"));
					htOutParameter.put("FACILITY_NAME",htPatdet.get("FACILITY_NAME"));
					htOutParameter.put("DATE_OF_BIRTH",htPatdet.get("DATE_OF_BIRTH"));
					htOutParameter.put("MAR_STATUS_CODE",htPatdet.get("MAR_STATUS_CODE"));
					htOutParameter.put("NATIONALITY_CODE",htPatdet.get("NATIONALITY_CODE"));
					htOutParameter.put("RH_FACTOR",htPatdet.get("RH_FACTOR"));
					htOutParameter.put("BLOOD_GRP",htPatdet.get("BLOOD_GRP"));
					htOutParameter.put("RES_AREA_CODE",htPatdet.get("RES_AREA_CODE"));
					htOutParameter.put("RES_TOWN_CODE",htPatdet.get("RES_TOWN_CODE"));
					htOutParameter.put("RELGN_CODE",htPatdet.get("RELGN_CODE"));
					htOutParameter.put("NAME_PREFIX",htPatdet.get("NAME_PREFIX"));
					htOutParameter.put("REGION_CODE",htPatdet.get("REGION_CODE"));
					htOutParameter.put("ENCOUNTER_ID",htPatdet.get("ENCOUNTER_ID"));
					htOutParameter.put("CURRENT_LOCATION",htPatdet.get("CURRENT_LOCATION"));
					htOutParameter.put("ATTENDING_PRACTITIONER",htPatdet.get("ATTENDING_PRACTITIONER"));
					htOutParameter.put("ADMISSION_DATE",htPatdet.get("ADMISSION_DATE"));
					htOutParameter.put("SPECIALITY",htPatdet.get("SPECIALITY"));
					htOutParameter.put("PATIENT_CLASS",htPatdet.get("PATIENT_CLASS"));
					htOutParameter.put("ROOM_NUM",htPatdet.get("ROOM_NUM"));
					htOutParameter.put("BED_NUM",htPatdet.get("BED_NUM"));
					htOutParameter.put("SERVICE_CODE",htPatdet.get("SERVICE_CODE"));
					htOutParameter.put("ATT_PRACT_WITH_CREDENTIAL",htPatdet.get("ATT_PRACT_WITH_CREDENTIAL"));
					htOutParameter.put("PATIENT_NRIC",htPatdet.get("PATIENT_NRIC"));

				}
				
				if(!contentOutXML.toString().equals("") && contentOutXML != null)
				{ 
					if(parser==null)
					{
						parser = new eCA.DomParser();	
					}
					
					contentOutUpdatedXML=parser.updateXMLOutContentValues(sectionContentUpdatedXML,contentOutXML,htOutParameter,locale,xslURL1);								
				}
			

				String prev_sec_hdg_code_out ="";
				String prev_child_sec_hdg_code_out ="";

				prev_sec_hdg_code_out = prev_sec_hdg_code+"_out";
				prev_child_sec_hdg_code_out = prev_child_sec_hdg_code+"_out";
				
				parser=null;
				sectionBean.setSectionContent(prev_sec_hdg_code,prev_child_sec_hdg_code,sectionContentUpdatedXML.toString());
				sectionBean.setSectionValues(prev_sec_hdg_code_out,prev_child_sec_hdg_code_out,"T","N","N","N","N","","N","N", contentOutUpdatedXML.toString(),"",output_yn);
				

				PersistenceHelper.putObjectInBean("sectionBean",sectionBean,session);		
			}
			catch(Exception ex)
			{
				System.out.println("Exception in ClinicalNotesUtil:traverseSections()"+ex.toString());
				ex.printStackTrace();
			}
			
		}
		
		else if(prev_section_type.equals("F") || prev_section_type.equals("R"))
		{			
			if(!(section_content.equals("")) )
			{				
				sectionBean.setSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code, "<ADDRESS>"+section_content+"<ADDRESS>");
			}
			else if (section_content.equals("")&&( !(appl_task_id.equals("PAT_MEDICAL_REPORT") && selection_type.equals("M"))) )
			{				
				sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
			}
			
			if(prev_image_linked_yn.equals("Y") && image_edited_yn.equals("Y")){
				sectionBean.setSectionImageContent(prev_sec_hdg_code,prev_child_sec_hdg_code,section_image_content);
				sectionBean.setSectionImageHeight(prev_sec_hdg_code,prev_child_sec_hdg_code,section_image_height);
			}
			PersistenceHelper.putObjectInBean("sectionBean",sectionBean,session);
		}
		
		/************** TODO: CHECK IF THE BELOW IS USED *********/			
		/*if(!section_content.equals("") && !prev_populated_section_tblrowID.equals(""))
		{
			out.println("<script>");
			out.println("var tblrow_id = eval(\"parent.RecClinicalNotesSectionFrame.document.all." + prev_populated_section_tblrowID + "\");");
			out.println("if(tblrow_id != null)");
			out.println("{");
			out.println("tblrow_id.cells(0).className = \"POPULATED_SECTION\";");
			out.println("}");
			out.println("</script>");
		}*/	
		
		if(!"".equals(previousNote_accession_num) && !"undefined".equals(previousNote_accession_num)){
			
			sectionBean.removeSectionContent ( prev_sec_hdg_code,prev_child_sec_hdg_code);
			
			String	sql = "SELECT SEC_HDG_CODE,SUBSEC_HDG_CODE,NOTES_SECTION_CONTENT FROM CA_ENCNTR_NOTE_SECTION WHERE ACCESSION_NUM = ?";
			
			PreparedStatement pstmt1 = con.prepareStatement(sql);
			pstmt1.setString(1,previousNote_accession_num);
			
			ResultSet rs1 = pstmt1.executeQuery();			
			java.sql.Clob clob_content	= null;
			
			while(rs1.next()){	
				String clobData="";			
				clob_content = (java.sql.Clob) rs1.getObject("NOTES_SECTION_CONTENT");
				if(clob_content!=null && clob_content.length() > 0){
					clobData = clob_content.getSubString(1,( (int)clob_content.length() ));
				}				
				sectionBean.setSectionContent((String) rs1.getString("SEC_HDG_CODE"),(String) rs1.getString("SUBSEC_HDG_CODE"),clobData);				
			}		
			
			if(rs1 != null) rs1.close();
			if(pstmt1 != null) pstmt1.close();
		
		}
		

		/************** TODO: CHECK IF THE BELOW IS USED *********/			
/*			section_content = "";		
		if(!curr_sec_hdg_code.equals("") && !curr_child_sec_hdg_code.equals(""))
		{
			section_content = (java.lang.String) sectionBean.getSectionContent ( curr_sec_hdg_code,curr_child_sec_hdg_code );

			if(section_content == null || section_content.equals("")) section_content = "";
			section_content			=	java.net.URLEncoder.encode(section_content,"UTF-8");
			
		}	*/		
		
	}
	catch(Exception e) {
		
	}
	
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}		
	
}
}
PersistenceHelper.putObjectInBean("sectionBean",sectionBean,session);


            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
