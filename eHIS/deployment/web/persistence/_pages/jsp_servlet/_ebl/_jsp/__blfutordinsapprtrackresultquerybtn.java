package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __blfutordinsapprtrackresultquerybtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFutOrdInsApprTrackResultQueryBtn.jsp", 1709114520947L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n</head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eBL/js/BLFutOrdInsApprTrack.js\' language=\'javascript\'></script>\n<script src=\'../../eBL/js/BLFutOrdInsApprTrackResult.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<body>\n<form name=\'\' id=\'\'>\n\n<table cellpadding=\'3\' cellspacing=\'0\'  width=\"100%\">\n\t<tr>\n\n\t\t<td width=\"70%\"  class=\'labels\' colspan=5></td>\n\t\t<td width=\"30%\" class=\'fields\'>\n\t\t\t<input type=\'button\' name=\"save_&_export\" id=\"save_&_export\" id=\"save_&_export\" value=\"Save & Export\" class=\'button\' onclick=\'saveUserData(\"B\");\' >\n\t\t\t<input type=\'button\' name=\"export_to_excel\" id=\"export_to_excel\" id=\"export_to_excel\" value=\"Export to Excel\" class=\'button\' onclick=\'generateExcel(\"E\");\' >\n\t\t\t<input type=\'button\' name=\"save\" id=\"save\" id=\"save\" value=\"Save\" class=\'button\' onclick=\'saveUserData(\"S\")\' >\t\t\t\n\n\t\t\t<input type=\"hidden\" id=\"p_facility_id\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_patient_id\" name=\"p_patient_id\" id=\"p_patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_episode_type\" name=\"p_episode_type\" id=\"p_episode_type\"\tvalue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_encounter_id\" name=\"p_encounter_id\" id=\"p_encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_SPECIALITY_CODE\" name=\"p_SPECIALITY_CODE\" id=\"p_SPECIALITY_CODE\"\tvalue=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_payer_grp_code\" name=\"p_payer_grp_code\" id=\"p_payer_grp_code\"\tvalue=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_payer_code\" name=\"p_payer_code\" id=\"p_payer_code\"\tvalue=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_policy_type_code\" name=\"p_policy_type_code\" id=\"p_policy_type_code\"\tvalue=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_enc_frm_date\" name=\"p_enc_frm_date\" id=\"p_enc_frm_date\"\tvalue=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_enc_to_date\" name=\"p_enc_to_date\" id=\"p_enc_to_date\"\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_ins_status\" name=\"p_ins_status\" id=\"p_ins_status\"\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_ORDER_LINE_STATUS\" name=\"p_ORDER_LINE_STATUS\" id=\"p_ORDER_LINE_STATUS\"\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_SERV_GRP_CODE\" name=\"p_SERV_GRP_CODE\" id=\"p_SERV_GRP_CODE\"\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_SERV_CLASS_CODE\" name=\"p_SERV_CLASS_CODE\" id=\"p_SERV_CLASS_CODE\"\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_BLNG_GRP_ID\" name=\"p_BLNG_GRP_ID\" id=\"p_BLNG_GRP_ID\"\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\t\t\t\n\t\t\t\n\t\t</td>\n\t</tr>\n</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
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

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);

System.err.println("Query String in Btn.jsp:"+request.getQueryString());
	String facilityId = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("locale");
	String qry_patient_id = checkForNull(request.getParameter("patient_id"));
	String qry_encounter_id = checkForNull(request.getParameter("encounter_id"));
	String qry_episode_type = checkForNull(request.getParameter("episode_type"));
	String qry_payer_grp_code = checkForNull(request.getParameter("payer_grp_code"));
	String qry_payer_code = checkForNull(request.getParameter("payer_code"));
	String qry_policy_type_code = checkForNull(request.getParameter("policy_type_code"));
	String qry_enc_frm_date = checkForNull(request.getParameter("enc_frm_date"));
	String qry_enc_to_date = checkForNull(request.getParameter("enc_to_date"));
	String qry_spec_nursing_unit_code = checkForNull(request.getParameter("spec_nursing_unit_code"));	
	String qry_insurance_Status = checkForNull(request.getParameter("insurance_Status"));	
	String qry_order_status = checkForNull(request.getParameter("order_status"));
	String qry_serviceGroupCode = checkForNull(request.getParameter("serviceGroupCode"));
	String qry_serviceClassificationCode = checkForNull(request.getParameter("serviceClassificationCode"));
	String qry_coding_status = checkForNull(request.getParameter("coding_status"));
	String qry_billingGrpCode = checkForNull(request.getParameter("billingGrpCode"));

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(qry_patient_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(qry_episode_type));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(qry_encounter_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(qry_spec_nursing_unit_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(qry_payer_grp_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(qry_payer_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(qry_policy_type_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(qry_enc_frm_date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(qry_enc_to_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(qry_insurance_Status));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(qry_order_status));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(qry_serviceGroupCode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(qry_serviceClassificationCode));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(qry_billingGrpCode));
            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
