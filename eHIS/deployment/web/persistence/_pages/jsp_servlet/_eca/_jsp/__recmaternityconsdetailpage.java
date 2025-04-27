package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.w3c.dom.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __recmaternityconsdetailpage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecMaternityConsDetailPage.jsp", 1709116208715L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

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

    private final static java.lang.String  _wl_block1 ="\n<?xml version=\'1.0\' encoding=\"UTF-8\"?>\n<?xml-stylesheet type=\"text/xsl\" href=\"../html/RecClinicalNotesTemplateRecordingView_MC.xsl\"?>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<DOCUMENT FORM-NAME=\"RecClinicalNotesTemplateForm\" >\n<CSS sStyle=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\"/>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/common.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/ValidateControl.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCA/js/RecClinicalNotesPart1.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCA/js/RecClinicalNotesPart2.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/dchk.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCommon/js/DateUtils.js\'></SCRIPT>\n<SCRIPT LANGUAGE=\'javascript\' SRC=\'../../eCA/js/RecMaternityCons.js\'></SCRIPT>\n<SCRIPT type=\'text/javascript\' SRC=\'../../eCommon/js/CommonCalendar.js\'></SCRIPT>\n<SCRIPT type=\'text/javascript\' SRC=\'../../eCA/js/SpeciltyEvents.js\'></SCRIPT>\n\n<STYLE type=\"text/css\">\n\t.READONLY\n\t{\n\t\tBACKGROUND-COLOR: #C0C0C0;\n\t}\n</STYLE>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\n<HIDDEN-FIELD NAME=\"patientId\" VALUE=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"encounterId\" VALUE=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"securityLevel\" VALUE=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"patientClass\" VALUE=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"secHdgCode\" VALUE=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"subSecHdgCode\" VALUE=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"moduleId\" VALUE=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"sectionType\" VALUE=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"accessionNum\" VALUE=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"cycle_no\" VALUE=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"splty_event_code\" VALUE=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"splty_task_code\" VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"modeValue\" VALUE=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"close_episode_yn\" VALUE=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"outcome_code\" VALUE=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"outcome_event_code\" VALUE=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"closeFlag\" VALUE=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"birth_order\" VALUE=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"finalize_yn\" VALUE=\"\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"systemDate99999A\" VALUE=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"systemDateTime99999A\" VALUE=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"patient_id\" VALUE=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"encounter_id\" VALUE=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"></HIDDEN-FIELD>\n<HIDDEN-FIELD NAME=\"locale\" VALUE=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"></HIDDEN-FIELD>\n</DOCUMENT>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "application/xml;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("application/xml;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

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

	
	
	

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

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

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(xmlContent.toString()));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(securityLevel));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(secHdgCode));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(subSecHdgCode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(moduleId));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sectionType));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(accessionNum));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(cycle_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(splty_event_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(splty_task_code));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(modeValue));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(close_episode_yn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(outcome_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(outcome_event_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(closeFlag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(birth_order));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(systemDate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(systemDateTime));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
