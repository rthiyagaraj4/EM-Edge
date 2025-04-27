package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __mrecclinicalnotessectionaddendumview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesSectionAddendumView.jsp", 1709118015334L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<style>\n\t\t.cke_contents\n\t\t{\n\t\t\tmargin-top:50px;\t\t\t\n\t\t}\n\t\t</style>\n<script>\nvar clinicalNotesSectBodyScroll;\nfunction addendumclinicalNotesSectBodyScroll() {\t\n\tclinicalNotesSectBodyScroll = new IScroll(\'#addendumScrollWrapper\', { \n\t\tscrollX: true, \n\t\tscrollY: true, \n\t\tscrollbars: true,\n\t\tinteractiveScrollbars: true,\n\t\tclick: false,\n\t\tuseTransition: false,\n\t\tbindToWrapper: true\n\t\t\n\t});\t\n\tclinicalNotesSectBodyScroll.refresh();\n}\n\n$(document).ready(function () {\t\n\t$(\"#cke_RecNotesRTE_CK\").addClass(\"addendumSectionClass\");\n\tvar secHdgCode=$(\"#secHdgCode\").val();\n    var accession_num =$(\"#accessionNum\").val();\n\tvar childSecHdgCode=$(\"#childSecHdgCode\").val();\n    var secHdgCode=$(\"#secHdgCode\").val();\n\tvar childSecHdgCode=$(\"#childSecHdgCode\").val();\n\taddendumclinicalNotesSectBodyScroll();\t\n});\n</script>\n\n<html>\n<head>\n\t<title>RecClinicalNotesSectionView</title>\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\' />\n\n\t<style>\n\t\tADDRESS\t{ FONT-FAMILY: Verdana ;FONT-SIZE: 9pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n\t</style>\n\t\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" class=\'CONTENT\'>\n\n<div class=\"table\" style=\"width:100%;height:100%;\">\n   <div class=\"row\" style=\"width:100%;height:100%;\">\n      <div id=\"addendumScrollWrapper\" class=\"cell\" style=\"position: relative;width:100%;overflow:hidden;\">\n        <div style=\"position: absolute;width:100%;\">\n<center>\n<table  border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width = \'100%\' align=\'center\'>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t<tr><td class=\'BODYCOLORFILLED\'>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td></tr>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</table>\n</center>\n</div>\n</div>\n</div>\n\n<div class=\"row\" style=\"width:100%;height:100%;\">\n  <div  style=\"position: relative;bottom: 0;height: 245px;width: 100%;\">\n  <div style=\"background: #e0e0eb;font-size: 14px;vertical-align: middle;line-height: 45px;padding-left: 15px;font-weight: bold;\">Add Your Addendum Below</div>\n ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n  <div style=\"margin-right: 22px;min-height: 200px;\" id=\"RecNotesRTE_CK\" >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</div> \n  \n  <script>\n  function initRTE(){\n\tCKEDITOR.config.toolbar = [\n\t\t{ name: \'clipboard\', items: [ \'Undo\', \'Redo\' ] },\n\t\t{ name: \'editing\', items: [ \'SelectAll\' ] },\n\t\t{ name: \'basicstyles\', items: [ \'Bold\', \'Italic\', \'Underline\' ] },\n\t\t{ name: \'colors\', items: [ \'TextColor\', \'BGColor\' ] },\n\t\t{ name: \'paragraph\', items: [ \'NumberedList\', \'BulletedList\', \'-\', \'Outdent\', \'Indent\', \'-\',  \'JustifyLeft\', \'JustifyCenter\', \'JustifyRight\', \'JustifyBlock\' ] },\n\t\t{ name: \'styles\', items: [ \'Format\', \'FontSize\' ] },\n\t];\n\tCKEDITOR.config.resize_enabled = false;\n\tCKEDITOR.replace(\'RecNotesRTE_CK\', {\n\t\theight: 100,\n\t\tremovePlugins: \'floatingspace,resize,elementspath\',\n\t\tresize_enabled: false\n\t});\n}\n\ninitRTE();\n  </script>\n  \n</div>\n</div>\n</div>\n\n<input type=\"hidden\" name=\"secHdgCode\" id=\"secHdgCode\" id=\"secHdgCode\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"/>\n<input type=\"hidden\" name=\"secContentType\" id=\"secContentType\" id=\"secContentType\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\n<input type=\"hidden\" name=\"secHdgCode\" id=\"secHdgCode\" id=\"secHdgCode\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"/>\n<input type=\"hidden\" name=\"patientId\" id=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\n<input type=\"hidden\" name=\"encounterID\" id=\"encounterID\" id=\"encounterID\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n<input type=\"hidden\" name=\"childSecHdgCode\" id=\"childSecHdgCode\" id=\"childSecHdgCode\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\n<input type=\"hidden\" name=\"accessionNum\" id=\"accessionNum\" id=\"accessionNum\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
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


	public String checkForNull(String inputString)
	{
		return ((inputString==null )	?	""	:	inputString).trim();
	}
	public String checkForNull(String inputString, String defaultValue)
	{
		if(inputString==null )inputString ="";		
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
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

            _bw.write(_wl_block3Bytes, _wl_block3);
	
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

	String	sec_content_type			=	"",		section_content		=	"";
	String	sec_hdg_code				=	"",		child_sec_hdg_code	=	"";	
	String  patient_id				    =	"",		encounter_id		=	"";
    String accession_num="";
    String  strExistingContent="";
    String section_add_content= "";

	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	String url = request.getRequestURL().toString();
	String uri = request.getRequestURI();
	String root = url.substring( 0, url.indexOf(uri) ) + request.getContextPath();	
     url = root + "/eCA/html/RecClinicalNotesTemplateDispayView.xsl";	
	try
	{
		sec_hdg_code		=	checkForNull(	request.getParameter("sec_hdg_code")	);
		sec_content_type	=	checkForNull( request.getParameter("sec_content_type") );
		child_sec_hdg_code	=	checkForNull( request.getParameter("child_sec_hdg_code") );
		encounter_id	=	(request.getParameter("encounter_id")==null)		? ""	:	request.getParameter("encounter_id");
		patient_id		=	(request.getParameter("patient_id")==null)		? ""	:	request.getParameter("patient_id");		
		accession_num	=	checkForNull( request.getParameter("accession_num") );
		String strKey	=	"";
		strKey = patient_id + "~"+ encounter_id;
		strKey = strKey.trim();
		sectionBean.getPatientSection(strKey);	
		
		if( !(sec_hdg_code.equals("")) )
		{
			section_content = checkForNull( (String) sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code), "&nbsp;" );
		    if(sec_content_type.equals("T"))
			{	
				if(!(section_content.equals("&nbsp;")))
					section_content=converter.buildHTMLFromXML(section_content,url);	
			}		
			if(!(section_content.equals("&nbsp;")))
			{
				
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(section_content));
            _bw.write(_wl_block7Bytes, _wl_block7);
		
			}
		}
	}
	catch(Exception e)
	{
		out.println("Exception@2 : "+e);
	}
	finally
	{
		converter =null;
	}
	
	Connection			con				=	null;  //IN034871
	PreparedStatement addendumTextPstmt = null; //IN034871
	ResultSet addendumTextRs = null; //IN034871
	if( !(sec_hdg_code.equals("")) )
	{
		strExistingContent = (String) sectionBean.getAddendumText(sec_hdg_code,child_sec_hdg_code);
	}
	else
	{ //[IN034871] Start.
		String addendumTextSql = "SELECT srl_no, addendum_text, addendum_status FROM ca_encntr_note_addendum WHERE accession_num = ? AND addendum_status = 'R' and sec_hdg_code = ? and SUBSEC_HDG_CODE = ? ORDER BY srl_no";
	try{
			con				=	ConnectionManager.getConnection(request);
			if(!accession_num.equals("&nbsp;") && !accession_num.equals(""))
			{
				addendumTextPstmt = con.prepareStatement(addendumTextSql);
				addendumTextPstmt.setString(1,accession_num);
				addendumTextPstmt.setString(2,"*AmmendNotes*");
				addendumTextPstmt.setString(3,"*AmmendNotes*");
				addendumTextRs				=	addendumTextPstmt.executeQuery();
				String addendumText = "";

				if(addendumTextRs.next())
				{
					addendumText = addendumTextRs.getString("addendum_text");
				}						
				sectionBean.setAddendumText("*AmmendNotes*","*AmmendNotes*",addendumText);
			}
		}catch(Exception e)
		{
			out.println("Exception@2: "+e);		
			e.printStackTrace();
		}
		finally
		{
			if(addendumTextRs!=null) addendumTextRs.close();
			if(addendumTextPstmt!=null) addendumTextPstmt.close();
			if(con!=null)	ConnectionManager.returnConnection(con,request);
		}
		//[IN034871] End.
		strExistingContent = (String) sectionBean.getAddendumText("*AmmendNotes*","*AmmendNotes*");			
	}	

            _bw.write(_wl_block8Bytes, _wl_block8);

 section_add_content = (String) sectionBean.getAddendumText ( sec_hdg_code,child_sec_hdg_code );

	if(section_add_content == null || section_add_content.equals("") )
		section_add_content			="";
	
	section_add_content			=	java.net.URLDecoder.decode(section_add_content,"UTF-8");
 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(section_add_content ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sec_content_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sec_hdg_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(child_sec_hdg_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block17Bytes, _wl_block17);
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
