package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __emailhdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EMailHdr.jsp", 1732086050413L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../js/EMail.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"EMailHdrForm\" id=\"EMailHdrForm\" action=\"../../servlet/eCA.EMailServlet\" method=\"post\" target=\"dummyEmailFrame\">\n<table border=0 cellspacing=0 cellpadding=\'3\' width=\'100%\' align=center>\n<tr>\n\t<td colspan=\'2\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td class=\'label\'><!-- <a href=\'#\' onclick=\"getRegRecpts(this);\" id=\"to\"> -->";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<!-- </a> --></td>\n\t<td class=\'fields\'>&nbsp;<input type=\"text\" name=\"to_emailId\" id=\"to_emailId\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" size=30 maxlength=100 onBlur=\"return makeValidString(this)\"  readonly\n\t><input type=\'button\' class=\'button\' value=\'?\' onclick=\'getRegRecpts(this)\' id=\'toLookup\' style=\'display:none\'><img src=\'../../eCommon/images/mandatory.gif\'><input type=\"hidden\" name=\"to_id\" id=\"to_id\" value=\"\"><input type=\"hidden\" name=\"to_name\" id=\"to_name\" value=\"\">&nbsp;</td>\n</tr>\n\n<tr id = \'ccLabelId\'>\n\t<td class=label ><!-- <a href=\"#\" onclick=\"getRegRecpts(this)\" id=\"cc\"> -->";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'fields\' >&nbsp;<input type=\"text\" name=\"cc_emailId\" id=\"cc_emailId\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" size=30 maxlength=100  onBlur=\"return makeValidString(this)\" readonly><input type=\'button\' class=\'button\' value=\'?\' onclick=\'getRegRecpts(this)\' id=\'ccLookup\' style=\'display:none\'><input type=\"hidden\" name=\"cc_id\" id=\"cc_id\" value=\"\"><input type=\"hidden\" name=\"cc_name\" id=\"cc_name\" value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href=\'javascript:clearDetails(document.forms[0].cc_emailId)\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a></td>\n</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t<tr>\n\t\t<td class=label >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<td class=\'fields\' >&nbsp;<input type=\"text\" name=\"subject\" id=\"subject\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" size=100 maxlength=100 onBlur=\"return makeValidString(this)\" ></td>\n\t</tr>\n\t<tr>\n\t\t<td class=label colspan=\'2\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t</tr>\n\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\"hidden\" name=\"report_id\" id=\"report_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\" name=\"disclaimer\" id=\"disclaimer\" value=\"\">\n\t<input type=\"hidden\" name=\"p_report_type\" id=\"p_report_type\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\" name=\"p_file_name\" id=\"p_file_name\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name=\"beanKey\" id=\"beanKey\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\" name=\"email_to_pat_id_yn\" id=\"email_to_pat_id_yn\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\"hidden\" name=\"email_to_regd_id_yn\" id=\"email_to_regd_id_yn\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\"hidden\" name=\"email_to_any_id_yn\" id=\"email_to_any_id_yn\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\"hidden\" name=\"disclaimerId\" id=\"disclaimerId\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"mailToType\" id=\"mailToType\" value=\"P\">\n\t<input type=\"hidden\" name=\"veryReqdYn\" id=\"veryReqdYn\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\"hidden\" name=\"veryReqdRegdYn\" id=\"veryReqdRegdYn\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\" name=\"veryReqdAdhocYn\" id=\"veryReqdAdhocYn\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"password\" id=\"password\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\n\t</table>\n\t</form>\n\t<script>\n\t\tif(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' != \'N\' && \'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' == \'N\' && \'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' != \'\')\n\t\t\topenEditor(document.EMailHdrForm)\n\t</script>\n\t</body>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n</html>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


String module_id="";
String report_id="";
String to_emailId="";
String cc_emailId="";
String p_file_name="";
String p_report_type="";
String AuthReqdYN="N";
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
module_id		=(request.getParameter("module_id")==null)?"":request.getParameter("module_id");
report_id		=(request.getParameter("report_id")==null)?"":request.getParameter("report_id");
p_file_name		=(request.getParameter("p_file_name")==null)?"":request.getParameter("p_file_name");
p_report_type		=(request.getParameter("p_report_type")==null)?"":request.getParameter("p_report_type");
AuthReqdYN		=(request.getParameter("AuthReqdYN")==null)?"N":request.getParameter("AuthReqdYN");
String beanKey = request.getParameter("beanKey") == null ? "" : request.getParameter("beanKey");
//out.println("<script>alert('"+beanKey+"');</script>");

String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
String veryReqdYn = "";
String veryReqdRegdYn = "";
String veryReqdAdhocYn = "";
String password = "";
String email_to_pat_id_yn = "";
String email_to_regd_id_yn = "";
String email_to_any_id_yn = "";
String very_reqd_conf_result_yn = "N";
String patEMailId = "";
String disclaimerId = "";
String subjTxt = "";

String sqlStr = "SELECT  A.QRY_SOURCE_ID	qry_src_id,A.SUBJECT_TEXT			subj_txt,A.DISCLIMER_ID			discl_id,A.EMAIL_TO_PAT_ID_YN		email_to_pat_id ,A.EMAIL_TO_REGD_ID_YN		email_to_regd_id,A.EMAIL_TO_ANY_ID_YN		email_to_any_id,A.VERY_REQD_PAT_YN		very_reqd_pat_yn,A.VERY_REQD_REGD_ID_YN		very_reqd_regd_id_yn,A.VERY_REQD_ANY_ID_YN		very_reqd_any_id_yn,A.VERY_REQD_CONF_RESULT_YN	very_reqd_conf_result_yn,A.PAT_BODY_TEXT_REF		pat_body_text_ref,A.REGD_ID_BODY_TEXT_REF		regd_id_body_text_ref,A.ANY_ID_BODY_TEXT_REF	any_id_body_text_ref,B.REPORT_DESC rep_desc,C.MODULE_NAME FROM SM_REPORT_MAIL_INFO A, SM_REPORT B, SM_MODULE C WHERE A.MODULE_ID=? AND A.REPORT_ID=? AND B.MODULE_ID=A.MODULE_ID AND B.REPORT_ID=A.REPORT_ID AND C.MODULE_ID=A.MODULE_ID";

String sqlStrPatId = "select EMAIL_ID from mp_patient where patient_id=?";

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(to_emailId));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(cc_emailId));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

try
{
	con=ConnectionManager.getConnection(request);
	pstmt=con.prepareStatement(sqlStr);
	pstmt.setString(1,module_id);
	pstmt.setString(2,report_id);
	rs=pstmt.executeQuery();
	while(rs.next())
	{
		email_to_pat_id_yn = rs.getString("email_to_pat_id") == null ? "N" : rs.getString("email_to_pat_id");
		email_to_regd_id_yn = rs.getString("email_to_regd_id") == null ? "N" : rs.getString("email_to_regd_id");
		email_to_any_id_yn = rs.getString("email_to_any_id") == null ? "N" : rs.getString("email_to_any_id");
		veryReqdYn = rs.getString("very_reqd_pat_yn") == null ? "N" : rs.getString("very_reqd_pat_yn");
		veryReqdRegdYn = rs.getString("very_reqd_regd_id_yn") == null ? "N" : rs.getString("very_reqd_regd_id_yn");
		veryReqdAdhocYn = rs.getString("very_reqd_any_id_yn") == null ? "N" : rs.getString("very_reqd_any_id_yn");
		very_reqd_conf_result_yn = rs.getString("very_reqd_conf_result_yn") == null ? "N" : rs.getString("very_reqd_conf_result_yn");
		disclaimerId = rs.getString("discl_id") == null ? "" : rs.getString("discl_id");
		subjTxt = rs.getString("subj_txt") == null ? "" : rs.getString("subj_txt");
	}//end of while

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	if (AuthReqdYN.equals("Y")&& very_reqd_conf_result_yn.equals("Y") )
	{
		veryReqdYn = "V";
		veryReqdRegdYn = "V";
		veryReqdAdhocYn = "V";
	}
	else
	{
		if(veryReqdYn.equals("Y")) veryReqdYn = "V";
		else veryReqdYn = "A";

		if(veryReqdRegdYn.equals("Y")) veryReqdRegdYn = "V";
		else veryReqdRegdYn = "A";

		if(veryReqdAdhocYn.equals("Y")) veryReqdAdhocYn = "V";
		else veryReqdAdhocYn = "A";
	}
	if(email_to_pat_id_yn.equals("N") && email_to_regd_id_yn.equals("N") && email_to_any_id_yn.equals("N"))
	{
		out.println("<script>alert(getMessage('MAILING_NOT_ALLOWED','CA'));parent.window.close();</script>");
	}
	else if(!email_to_pat_id_yn.equals("N") && email_to_regd_id_yn.equals("N") && email_to_any_id_yn.equals("N"))
	{
		pstmt=con.prepareStatement(sqlStrPatId);
		pstmt.setString(1,patient_id);
		rs=pstmt.executeQuery();
		while(rs.next())
		{
			patEMailId = rs.getString(1) == null ? "" : rs.getString(1);
		}		

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		if(patEMailId.equals("") || patEMailId == null)
		{
			out.println("<script>alert(getMessage('PAT_EMAIL_ID_NOT_NULL','CA'));parent.window.close();</script>");
		}
		else
		{
			out.println("<script>");
			out.println("document.forms[0].to_emailId.value='"+patEMailId+"' ");
			out.println("document.forms[0].to_emailId.readOnly='readOnly' ");
			out.println("document.getElementById('ccLabelId').style.display = 'none';");
			out.println("document.getElementById('toLookup').style.display = 'none';");
			out.println("</script>");
			password = patient_id;
		}
	}
	else
	{
		out.println("<script>");
		out.println("document.getElementById('toLookup').style.display = 'inline';");
		out.println("document.getElementById('ccLookup').style.display = 'inline';");
		out.println("</script>");
	}
	
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(subjTxt));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(report_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_report_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_file_name));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(beanKey));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(email_to_pat_id_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(email_to_regd_id_yn));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(email_to_any_id_yn));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disclaimerId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(veryReqdYn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(veryReqdRegdYn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(veryReqdAdhocYn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(password));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(email_to_pat_id_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(email_to_regd_id_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(email_to_any_id_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(patEMailId));
            _bw.write(_wl_block35Bytes, _wl_block35);
}catch(Exception e){
	
	//out.println("@@@ Exception in EMailHdr.jsp="+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}finally{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CC.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ClearMailId.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Subject.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.BodyText.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
