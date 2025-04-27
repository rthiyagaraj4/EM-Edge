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

public final class __mrecclinicalnotestemplatexml extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesTemplateXML.jsp", 1709116943129L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n\n\n";
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

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


            _bw.write(_wl_block2Bytes, _wl_block2);
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
