package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __patientcfsnotes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/PatientCFSNotes.jsp", 1709118029115L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n<!DOCTYPE html>\n<html>\n<head>\n<title>jQuery Mobile Application</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n\n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n \n<link rel=\"stylesheet\" href=\"../css/ipadAllergyContent.css\" />\n\n\n<script>\nfunction noteclose()\n{\n\t//document.getElementById(\"notesContentFrame2\").src = \"../jsp/widgetResultDetail.jsp\";\n\twindow.parent.closecfs();\n}\nfunction changeOrientation(orient)\n{\n\t\t\n\tif(orient == \"landscape\")\n\t   {\n\t\n\t    $(\"#notes\").css(\'min-height\',\'470px\');\n\t \n\t   \n\t   }\n     else\n\t   {\n    \t \n    \t$(\"#notes\").css(\'min-height\',\'726px\');\n   \n\t   }\n \n}\n</script>\n<style>\n.ADDRESS {\n\tFONT-FAMILY: Arial;\n\tFONT-SIZE: 10pt;\n\tFONT-STYLE: NORMAL;\n\tCOLOR: BLACK;\n}\n\n.white {\n\t\n}\n</style>\n</head>\n\n<body style=\"background-color: #ffffff\">\n\n\t<form>\n       <div id = \"notes\" style = \"height:auto;overflow:auto;padding:0px;background-color: #ffffff\" data-role = \"none\"> \n       \n\t\t<table border=\"0\" width=\"100%\" cellspacing=\'0\' cellpadding=\'3\'>\n\t\t\t\n            <tr >  \n            <td style = \"width : 80%\">&nbsp;&nbsp;</td>\n            <td style = \"width : 20%\" align = \"right\" valign = \"center\" >\n          \n          <input type =\"button\" name=\'Close_btn\' id=\'Close_btn\' value=\'Close\' class=\"btnType1\"  data-role = \"none\" onclick = \"noteclose()\" />\n            \n         </td>\n            </tr>\n\t\t\t<tr >\n\t\t\t\t<td align=\'left\'>";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="</td>\n\t\t\t</tr>\n\t\t</table>\n</div>\n\t</form>\n\n\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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

	request.setCharacterEncoding("UTF-8");

	String locale = "en";
	StringBuffer sqlStr = new StringBuffer("");

	String accession_num = request.getParameter("accession_num");
	String hist_rec_type = request.getParameter("hist_rec_type");
	String contr_sys_id = request.getParameter("contr_sys_id");
	String contr_sys_event_code = request
			.getParameter("contr_sys_event_code");
	String notes_content = "";
	//String notesHeader = request.getParameter("notesHeader");
	//String	notes_content		=	"";

	java.sql.Clob clob_notes_content = null;
	java.io.Reader content_reader = null;
	java.io.BufferedReader bf_content_reader = null;

	//sqlStr.append("SELECT B.TERM_SET_DESC AS ProblemSet,A.TERM_CODE as DiagProb,A.TERM_CODE_SHORT_DESC as Description FROM PR_DIAGNOSIS A JOIN MR_TERM_SET B ON A.TERM_SET_ID = B.TERM_SET_ID WHERE A.PATIENT_ID = 'MC00000149'");

	//sqlStr.append("SELECT HIST_DATA FROM cr_encounter_detail_txt WHERE hist_rec_type = "+ hist_rec_type +" AND contr_sys_id = a.contr_sys_id AND accession_num = a.accession_num AND contr_sys_event_code = a.event_code AND DBMS_LOB.getlength (hist_data) > 0)");
	sqlStr.append("SELECT HIST_DATA FROM cr_encounter_detail_txt WHERE hist_rec_type = '"
			+ hist_rec_type
			+ "' AND contr_sys_id = '"
			+ contr_sys_id
			+ "' AND accession_num = '"
			+ accession_num
			+ "' AND contr_sys_event_code = '"
			+ contr_sys_event_code
			+ "'");
	Statement stmt = null;
	ResultSet rs = null;

	Statement stmt1 = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	Connection conn = null;
	int maxRecord = 0;
	int start = 0;
	int end = 0;
	int i = 1;
	String strRowCount = "";
	try {
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		stmt1 = conn.createStatement();
		
		
		rs = stmt.executeQuery(sqlStr.toString());
		

		if (rs != null && rs.next()) {
			clob_notes_content = (java.sql.Clob) rs
					.getObject("HIST_DATA");

			if (clob_notes_content != null) {
				try {
					content_reader = clob_notes_content
							.getCharacterStream();
					bf_content_reader = new java.io.BufferedReader(
							content_reader);
					char[] arr_notes_content = new char[(int) clob_notes_content
							.length()];
					bf_content_reader.read(arr_notes_content, 0,
							(int) clob_notes_content.length());
					notes_content = new String(arr_notes_content);
					//out.println("notes content=" + notes_content);
					bf_content_reader.close();
				} catch (Exception e) {
					out.println("Exception@2-readCLOB : " + e);
				}

				/*if (notes_content != null
						&& !notes_content.trim().equals("")) {
					int nIndex = notes_content.indexOf("<BODY>");
					int nIndex1 = notes_content.lastIndexOf("</BODY>");

					if (nIndex != -1 && nIndex1 != -1)
						notes_content = notes_content.substring(
							nIndex + 6, nIndex1);

				}*/
				
			}//c
			else {
				out.println("notes content is null");
			}
		} else {
			out.println("rs is null");
		}

	} catch (Exception e) {
		out.println("Exception " + e);
		//out.println(sqlStr.toString());
		e.printStackTrace();
	} finally {
		if (rs != null)
			rs.close();
		if (rs1 != null)
			rs1.close();
		if (stmt1 != null)
			stmt1.close();
		if (stmt != null)
			stmt.close();

		ConnectionManager.returnConnection(conn, request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(notes_content));
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
