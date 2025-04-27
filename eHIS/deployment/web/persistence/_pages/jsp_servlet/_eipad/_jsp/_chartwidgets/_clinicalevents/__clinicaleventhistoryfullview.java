package jsp_servlet._eipad._jsp._chartwidgets._clinicalevents;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesMapResponse;
import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __clinicaleventhistoryfullview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalevents/ClinicalEventHistoryFullView.jsp", 1709116940942L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n</head>\n<div class=\"note-heading\">\n  <span class=\"time\">\n    ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n  </span>\n  <span class=\"text\">\n    ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n  </span>\n  <span class=\"ECText\">\n    Encounter Id\n  </span>\n  <span class=\"ECNum\">\n    ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n  </span>\n</div>\n<div class=\"note\">\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="          \n</div>\n        \t\t\t\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");

String locale = "en";
StringBuffer sqlStr = new StringBuffer("");

String accession_num = request.getParameter("accession_num");
String notesHeader = "header"; //request.getParameter("notesHeader");
String notes_content = "";

java.sql.Clob clob_notes_content = null;
java.io.Reader content_reader = null;
java.io.BufferedReader bf_content_reader = null;
String note_type = "";
String noteTime = "";
String note_type_desc = "";
String pract_name = "";
String event_status_code = "";
String event_status = "";
String encounter_id = "";
PatContext patientContext = (PatContext) session.getAttribute("PatientContext");

sqlStr.append("SELECT TO_CHAR (a.EVENT_DATE_TIME, 'HH24:MI') EVENT_DATE_TIME,a.ENCOUNTER_ID, a.note_content,a.note_type, a.event_status, CA_GET_DESC.CA_NOTE_TYPE(a.note_type,'" + locale + "' ,'1') note_type_desc, am_get_desc.am_practitioner (a.performed_by_id, '" + locale + "', 2 ) pract_name FROM ca_encntr_note a where  a.accession_num= '" + accession_num + "'");

Statement stmt = null;
ResultSet rs = null;

Statement stmt1 = null;
ResultSet rs1 = null;
Connection conn = null;

int i = 1;
String strRowCount = "";
try {
 conn = ConnectionManager.getConnection(request);
 stmt = conn.createStatement();
 stmt1 = conn.createStatement();
 if (rs != null) rs.close();
 rs = stmt.executeQuery(sqlStr.toString());

 if (rs != null && rs.next()) {
  clob_notes_content = (java.sql.Clob) rs.getObject("note_content");
  pract_name = rs.getString("pract_name") == null ? "" : rs.getString("pract_name"); // performed by
  note_type_desc = rs.getString("note_type_desc") == null ? "" : rs.getString("note_type_desc"); // note type
  note_type = rs.getString("note_type") == null ? "" : rs.getString("note_type"); // note type
  noteTime = rs.getString("EVENT_DATE_TIME") == null ? "" : rs.getString("EVENT_DATE_TIME"); // note time
  event_status_code = rs.getString("event_status") == null ? "" : rs.getString("event_status");
  encounter_id = rs.getString("ENCOUNTER_ID") == null ? "" : rs.getString("ENCOUNTER_ID");

  if (event_status_code.equals("1")) {
   event_status = "In Progress";
  } else if (event_status_code.equals("2")) {
   event_status = "Transcribed";
  } else if (event_status_code.equals("3")) {
   event_status = "Unauthorized";
  } else if (event_status_code.equals("4")) {
   event_status = "Authorized";
  } else if (event_status_code.equals("5")) {
   event_status = "Modified";
  } else if (event_status_code.equals("9")) {
   event_status = "In Error";
  }

  if (clob_notes_content != null) {
   try {
    content_reader = clob_notes_content.getCharacterStream();
    bf_content_reader = new java.io.BufferedReader(content_reader);
    char[] arr_notes_content = new char[(int) clob_notes_content.length()];
    bf_content_reader.read(arr_notes_content, 0, (int) clob_notes_content.length());
    notes_content = new String(arr_notes_content);
    bf_content_reader.close();
   } catch (Exception e) {
    out.println("Exception@2-readCLOB : " + e);
   }

   if (!notes_content.equals("")) {
    int nIndex = notes_content.indexOf("<BODY>");
    int nIndex1 = notes_content.lastIndexOf("</BODY>");

    if (nIndex != -1 && nIndex1 != -1)
     notes_content = notes_content.substring(nIndex + 6, nIndex1);
   }
  } 
 }

} catch (Exception e) {
 out.println("Exception " + e);
 e.printStackTrace();
} finally {
 if (rs != null) rs.close();
 if (rs1 != null) rs1.close();
 if (stmt1 != null) stmt1.close();
 if (stmt != null) stmt.close();

 ConnectionManager.returnConnection(conn, request);
}

ClinicalNotesBC bc = new ClinicalNotesBC();
ClinicalNotesMapResponse operationsAllowedResp = bc.getApplicableNoteOperations(patientContext, accession_num);
HashMap operationsHash = operationsAllowedResp.getMap();
String operations_allowed = (String) operationsHash.get("operations_allowed");
String amendment_type = (String) operationsHash.get("ammendment_type");
StringTokenizer stoken = new java.util.StringTokenizer(operations_allowed, "|");
HashMap arrFunctions = new HashMap();
while (stoken.hasMoreTokens()) {
 String button_name = (String) stoken.nextToken();
 arrFunctions.put(button_name, button_name);
}	

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(noteTime));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(note_type_desc));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(notes_content));
            _bw.write(_wl_block7Bytes, _wl_block7);
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
}
