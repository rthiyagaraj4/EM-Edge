package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnotesfileupload extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesFileUpload.jsp", 1736157591307L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html> \n<title></title>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eCA/js/RecClinicalNotesFileUpload.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n\t<body  class=\'CONTENT\' onKeyDown=\"lockKey()\">\n\n\t\t<form name=\'RecClinicalNotesFileUploadForm\' id=\'RecClinicalNotesFileUploadForm\'  action=\"../../servlet/eCA.RecClinicalNotesFileUploadServlet\" method=\'post\' enctype=\'multipart/form-data\' target=\'messageFrame\'>\n\t\t<table border=\'0\' width=\'90%\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'>\n\t\t\t<tr  id=\'change_fileid\' style=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t\t<td class = \'label\'  >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;</td>\n\t\t\t\t<td class = \'fields\' ><input type=\'checkbox\' name=\'changefile\' id=\'changefile\' value=\'N\' onClick=\"ShowFileRef(this)\"><input type=\'hidden\' name=\'change_file_ref\' id=\'change_file_ref\' value=\"N\" ></td>\n\t\t\t</tr>\n\t\t\n\t\t\t<tr id=\'file_id\' style=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t\t\t<td class=\'label\' id=\'fileref\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;</td><td class = \'fields\'  >\n\t\t\t\t<div id=\"uploadFile_div\"><input type=\'file\' name=\'fileupload\' id=\'fileupload\' id = \'fileuploadid\' size=\'30\' onMouseDown=\' return checkFilevalue(this)\' onKeyDown=\'return checkFilevalue(this);\' onKeyPress =\' return checkFilevalue(this);\' onContextMenu =\'return false;\' onclick=\'disableBtns(this,\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\");\' ><img src=\'../../eCommon/images/mandatory.gif\'></div>&nbsp;</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;</td>\n\t\t\t\t<td class = \'fields\' ><textarea name=\'uploadremarks\' rows=\'3\' cols=\'55\' onKeyPress=\'checkMaxLimit(this,200);\' onBlur=\'checkMaxLimitnew(this,200);\'></textarea></td>\n\t\t\t</tr>\n\t\t</table>\n\n\t\t<!--   Hidden Fields    -->\n\t\t<input type=\"hidden\" name=\"note_type\" id=\"note_type\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t<input type=\"hidden\" name=\"sys_date_time\" id=\"sys_date_time\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t<input type=\"hidden\" name=\"operation_mode\" id=\"operation_mode\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t<input type=\"hidden\" name=\"amendment_type\" id=\"amendment_type\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t<input type=\"hidden\" name=\"accession_num\" id=\"accession_num\"\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t<input type=\"hidden\" name=\"event_class\" id=\"event_class\"\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=\"hidden\" name=\"privilege_type\" id=\"privilege_type\"\t value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t<input type=\"hidden\" name=\"note_type_desc\" id=\"note_type_desc\"\tvalue=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t<input type=\"hidden\" name=\"event_type_caption\" id=\"event_type_caption\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t<input type=\"hidden\" name=\"note_type_security_level\" id=\"note_type_security_level\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t<input type=\"hidden\" name=\"event_date_caption\" id=\"event_date_caption\"\t\tvalue=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t<input type=\"hidden\" name=\"event_perf_by_caption\" id=\"event_perf_by_caption\"\t\tvalue=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t<input type=\"hidden\" name=\"event_title_caption\" id=\"event_title_caption\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t\t<input type=\"hidden\" name=\"event_auth_by_caption\" id=\"event_auth_by_caption\"\t\tvalue=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t\t<input type=\"hidden\" name=\"event_status_caption\" id=\"event_status_caption\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t\t<input type=\"hidden\" name=\"serv_facl_spec_yn\" id=\"serv_facl_spec_yn\"\tvalue=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t<input type=\"hidden\" name=\"forwarded_clinician_id\" id=\"forwarded_clinician_id\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\"\tvalue=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t<input type=\"hidden\" name=\"appl_task_id\" id=\"appl_task_id\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\t\n\n\t\t<input type=\"hidden\" name=\"event_date_time\" id=\"event_date_time\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\t\n\t\t<input type=\"hidden\" name=\"sys_date_time\" id=\"sys_date_time\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\t\n\t\t<input type=\"hidden\" name=\"note_header_desc\" id=\"note_header_desc\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\t\n\t\t<input type=\"hidden\" name=\"discharge_summary_text\" id=\"discharge_summary_text\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\t\n\t\t<input type=\"hidden\" name=\"note_group\" id=\"note_group\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\t\n\t\t<input type=\"hidden\" name=\"performed_by_id\" id=\"performed_by_id\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\t\n\t\t<input type=\"hidden\" name=\"event_title_desc\" id=\"event_title_desc\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\t\n\t\t<input type=\"hidden\" name=\"service_code\" id=\"service_code\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\t\n\t\t<input type=\"hidden\" name=\"queryString\" id=\"queryString\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\t\n\t\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\t\n\t\t<input type=\"hidden\" name=\"from_date_time\" id=\"from_date_time\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\t\n\t\t<input type=\"hidden\" name=\"to_date_time\" id=\"to_date_time\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\t\n\t\t<input type=\"hidden\" name=\"call_from\" id=\"call_from\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\t\n\t\t<input type=\"hidden\" name=\"call_mode\" id=\"call_mode\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\t\n\t\t<input type=\"hidden\" name=\"doc_type\" id=\"doc_type\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\t\n\t\t<input type=\"hidden\" name=\"previewMode\" id=\"previewMode\" value=\"\">\t\n\t\t<input type=\"hidden\" name=\"fileExtn\" id=\"fileExtn\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\t\n\t\t<input type=\"hidden\" name=\"image_name\" id=\"image_name\" value=\"\">\t\n\t\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\t\n\t\t<input type=\"hidden\" name=\"insertAuditLogYN\" id=\"insertAuditLogYN\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\t\n\t\t<input type=\"hidden\" name=\"contr_mod_accession_num\" id=\"contr_mod_accession_num\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\t\n\n\n\t\t</form>\n\t\t\t\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

//out.println("<script>alert('"+request.getQueryString()+"')</script>");
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String query_string = "";
String accession_num = "";
String note_type = "";
String operation_mode				= "";
String performed_by_id				= "";
String privilege_type					= "";
String function_id						= "";
String field_ref							= "";
String window_close					= "";
String patient_id						= "";
String episode_type					= "";
String encounter_id					= "";
String patient_class					= "";
String event_type_caption			= "";
String service_code					= "";
String event_class						= "";
String note_type_security_level = "";
String event_date_caption			= "";
String event_date_time				= "";
String event_perf_by_caption	= "";
String event_title_caption			= "";
String event_title_desc				= "";
String note_content					= "";
String event_auth_by_caption	= "";
String authorized_by_id				= "";
//String authorized_date_time		= "";
String event_status_caption		= "";
String event_status					= "";
String encntr_date						= "";
String contr_mod_accession_num = "";
String serv_facl_spec_yn			= "";
String visit_adm_date				= "";
String amendment_type			= "";
String appl_task_id					= "";
String security_level					= "";
//String login_at_ws_no				= "";
String remarks							= "";
String forwarded_clinician_id		= "";
String uploadremarks					= "";
String sys_date_time					= "";
String note_type_desc				= "";
String note_header_desc          = "";
String discharge_summary_text = "";
String note_group						 ="";
String from_date_time						 ="";
String to_date_time						 ="";

//String default_value						 ="";
String change_mode						 ="";
String display_file						 ="";
String call_from						 ="";
StringBuffer fileExtn = new StringBuffer();
String call_mode						 ="";
String called_from						 ="";
String insertAuditLogYN = "";

StringBuffer doc_type = new StringBuffer();

int count = 0;

	call_from = request.getParameter("call_from")==null?"":request.getParameter("call_from");
	//out.println("<script>alert('CN06$0000000000024841"+call_from+"')</script>");
	accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");	
	note_group = request.getParameter("note_group")==null?"":request.getParameter("note_group");	
	operation_mode = request.getParameter("operation_mode")==null?"":request.getParameter("operation_mode");	
	performed_by_id = request.getParameter("performed_by_id")==null?"":request.getParameter("performed_by_id");	
	privilege_type = request.getParameter("privilege_type")==null?"":request.getParameter("privilege_type");	
	function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");	
	field_ref = request.getParameter("field_ref")==null?"":request.getParameter("field_ref");	
	window_close = request.getParameter("window_close")==null?"":request.getParameter("window_close");	
	patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");	
	episode_type = request.getParameter("episode_type")==null?"":request.getParameter("episode_type");	
	encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	
	patient_class = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");	
	event_type_caption = request.getParameter("event_type_caption")==null?"":request.getParameter("event_type_caption");	
	service_code = request.getParameter("service_code")==null?"":request.getParameter("service_code");	
	event_class = request.getParameter("event_class")==null?"":request.getParameter("event_class");	
	note_type_security_level = request.getParameter("note_type_security_level")==null?"":request.getParameter("note_type_security_level");	
	event_date_time = request.getParameter("event_date_time")==null?"":request.getParameter("event_date_time");	
	note_content = request.getParameter("note_content")==null?"":request.getParameter("note_content");	
	authorized_by_id = request.getParameter("authorized_by_id")==null?"":request.getParameter("authorized_by_id");	
	event_status = request.getParameter("event_status")==null?"":request.getParameter("event_status");	
	encntr_date = request.getParameter("encntr_date")==null?"":request.getParameter("encntr_date");	
	contr_mod_accession_num = request.getParameter("contr_mod_accession_num")==null?"":request.getParameter("contr_mod_accession_num");	
	serv_facl_spec_yn = request.getParameter("serv_facl_spec_yn")==null?"":request.getParameter("serv_facl_spec_yn");	
	visit_adm_date = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");	
	amendment_type = request.getParameter("amendment_type")==null?"":request.getParameter("amendment_type");	
	appl_task_id = request.getParameter("appl_task_id")==null?"":request.getParameter("appl_task_id");	
	security_level = request.getParameter("security_level")==null?"":request.getParameter("security_level");	
	remarks = request.getParameter("remarks")==null?"":request.getParameter("remarks");	
	forwarded_clinician_id = request.getParameter("forwarded_clinician_id")==null?"":request.getParameter("forwarded_clinician_id");	
	query_string = request.getParameter("query_string")==null?"":request.getParameter("query_string");	
	from_date_time = request.getParameter("from_date_time")==null?"":request.getParameter("from_date_time");	
	to_date_time = request.getParameter("to_date_time")==null?"":request.getParameter("to_date_time");	
	called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");	
	insertAuditLogYN = request.getParameter("insertAuditLogYN")==null?"N":request.getParameter("insertAuditLogYN");
	

try
{
	con = ConnectionManager.getConnection(request);

	String qry_cr_enctr_dtl_obj = "";
	qry_cr_enctr_dtl_obj = "SELECT EVENT_TITLE FROM CR_ENCOUNTER_DETAIL_OBJ WHERE ACCESSION_NUM = ? AND CONTR_SYS_EVENT_CODE = ?";
	pstmt = con.prepareStatement(qry_cr_enctr_dtl_obj);
	pstmt.setString(1,accession_num);
	pstmt.setString(2,note_type);
	rs = pstmt.executeQuery();

	while(rs.next())
	{
		uploadremarks = rs.getString("EVENT_TITLE")==null?"":rs.getString("EVENT_TITLE");
		count = 1;
	}
	/*added by kishore kumar N for the CRF SRR - 500*/
	if(rs!=null)
		rs.close();
	if(pstmt!=null)
		pstmt.close();

	String fileExtQry = "SELECT DISTINCT FILE_EXTN FROM CA_APPL_LINKED_OBJ_TYPE WHERE APPLICABLE_YN='Y'";
	pstmt = con.prepareStatement(fileExtQry);
	rs = pstmt.executeQuery();
	
	while(rs.next())
	{			
		if(fileExtn.equals(""))
		{	 
			fileExtn.append(rs.getString(1)==null?"":rs.getString(1));
		}
		else
		{	 			
			fileExtn.append(","); 
			fileExtn.append(rs.getString(1)==null?"":rs.getString(1)); 
		}		
	}
		
	if(rs!=null)
		rs.close();
	if(pstmt!=null)
		pstmt.close();

	
/*ends here.*/	

}
catch(Exception e)
{
	e.printStackTrace();
	
}
finally
{

	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

if(operation_mode.equals("Update") || count > 0)
{
	change_mode = "display:none";
	display_file = "display";

}
else
{
	change_mode = "display:none";
	display_file = "display";
}

if(count > 0)
	call_mode = "update";
else
	call_mode = "";

//out.println("<script>document.fileuploadid.value="+default_value+"</script>");

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(change_mode));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(display_file));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(note_type));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(operation_mode));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(amendment_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(accession_num));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(event_class));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(privilege_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_type_caption));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(note_type_security_level));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(event_date_caption));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(event_perf_by_caption));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(event_title_caption));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(event_auth_by_caption));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(event_status_caption));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(serv_facl_spec_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(forwarded_clinician_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(event_date_time));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(sys_date_time));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(note_header_desc));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(discharge_summary_text));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(note_group));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(performed_by_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(event_title_desc));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(event_title_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(event_title_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(from_date_time));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(to_date_time));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(call_from));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(call_mode));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(doc_type));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(fileExtn.toString()));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(insertAuditLogYN));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(contr_mod_accession_num));
            _bw.write(_wl_block56Bytes, _wl_block56);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ChangeFileReference.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.FileReference.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
