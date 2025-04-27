package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Properties;
import java.util.HashMap;
import com.ehis.persist.PersistenceHelper;

public final class __mrecclinicalnotesservlet extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesServlet.jsp", 1709116943004L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<!-- \ncode extracted from RecClinicalNotesServlet\nvariable names are maintained same as in the RecClinicalNotesServlet.java\n -->\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

public String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
}
private String checkForNull(String inputString, String defaultValue)
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
            _bw.write(_wl_block3Bytes, _wl_block3);

webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

Properties p = (Properties)session.getAttribute("jdbc") ;
String locale = (String)p.getProperty("LOCALE");

String operation_mode = checkForNull(request.getParameter("operation_mode"));
String clinician_id	= (String)session.getAttribute("ca_practitioner_id");
String clinician_name = (String)session.getAttribute("practitioner_name");
String resp_name = (String)session.getAttribute("resp_name");
String resp_id = (String)session.getAttribute("responsibility_id");
String facility_id = (String)session.getAttribute("facility_id");
String login_user_id = (String)session.getAttribute("login_user_id");
String login_at_ws_no =	checkForNull(p.getProperty("client_ip_address"));
String accession_num = checkForNull(request.getParameter("accession_num")); //empty for new note
String performed_by_id = clinician_id; //Logged in practitioner is the one always in mobile. Other practitioners cannot create on behalf
String forwarded_clinician_id = checkForNull(request.getParameter("forwarded_clinician_id")); //not applicable for record/sign
String action_comment =	checkForNull( request.getParameter("action_comment")); //empty for new note
action_comment = java.net.URLDecoder.decode(action_comment); 
String privilege_type; //TODO take from RecClinincalNotesHeader.jsp line 934
String serv_facl_spec_yn; //TODO take from RecClinincalNotesHeader.jsp line 934
String note_type_desc = checkForNull(request.getParameter("note_type_desc"));
String patient_id;	//TODO get it from patContext object
String episode_type = checkForNull(request.getParameter("episode_type")); //DECODE(a.patient_class,'OP','O','EM' ,'O','I') Episode_type
String encounter_id; //TODO get from patContext
String patient_class; //TODO get from patContext or a query is available in the jsp line 230
String event_type_caption;//TODO -- msgstring Note Type
String note_type = checkForNull(request.getParameter("note_type"));
String service_code;//Medical Anc Service
String event_class; //TODO take from RecClinincalNotesHeader.jsp line 1154
String note_type_security_level; //TODO take from RecClinincalNotesHeader.jsp line 934
String event_date_caption; //TODO take from RecClinincalNotesHeader.jsp line 934
String event_date_time	= checkForNull( request.getParameter("event_date_time"));
event_date_time	= com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM",locale,"en");
String event_perf_by_caption; //TODO take from RecClinincalNotesHeader.jsp line 934
String event_title_caption; //TODO take from RecClinincalNotesHeader.jsp line 934
String event_title_desc; //TODO take from RecClinincalNotesHeader.jsp line 934
String note_content;//TODO FIND
String event_auth_by_caption; //TODO take from RecClinincalNotesHeader.jsp line 934
String authorized_by_id;//empty for now
String authorized_date_time; //empty for now
String event_status_caption; //TODO take from RecClinincalNotesHeader.jsp line 934
String event_status = checkForNull( request.getParameter("event_status"),"1"); 
if(event_status.equals(""))
	event_status="j"; //More on this variable is done in the RecClinicalNotesServlet TODO
String encntr_date;	//TODO take from RecClinincalNotesHeader.jsp line 1238 visit_adm_date
String contr_mod_accession_num; //empty for new note
String doc_linked_note_yn; //TODO take from RecClinincalNotesHeader.jsp line 934
String forward_mode = "";
String appl_task_id = "CLINICAL_NOTES";
String selection_type = "";
HashMap multiHash = null;
//multiHash = manageEmailBean.returnHashMap(); -- Commented for BUILD ERROR
String function_id = ""; 
String srl_no = ""; //applicable for addendum only
String forwardToFac = "";
String contr_oth_accession_num = "";



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
