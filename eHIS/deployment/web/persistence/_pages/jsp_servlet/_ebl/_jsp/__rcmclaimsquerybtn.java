package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Date;
import eBL.*;
import eBL.Common.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.math.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __rcmclaimsquerybtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/RCMClaimsQueryBtn.jsp", 1709114775161L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eBL/js/BLDischClear.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eBL/js/RCMClaimsStatusChange.js\' language=\'javascript\'></script>\n<script src=\'../../eBL/js/RCMClaims.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body onKeyDown=\"lockKey()\" onMouseDown=\"CodeArrest()\" method=\"Post\">\n<form name=\'\' id=\'\'>\n\n<table cellpadding=\'3\' cellspacing=\'0\'  width=\"100%\">\n\t<tr>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<td width=\"75%\"  class=\'labels\' colspan=6></td>\n\t\t<td width=\"25%\" class=\'fields\'>\n\t\t\t<input type=\'button\' name=\"generate\" id=\"generate\" id=\"generate\" value=\"Generate\" class=\'button\' onclick=\'generateDocs();\' >\n\t\t\t<input type=\'button\' name=\"export_to_excel\" id=\"export_to_excel\" id=\"export_to_excel\" value=\"Export to Excel\" class=\'button\' onclick=\'generateExcel();\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<td width=\"70%\"  class=\'labels\' colspan=5></td>\n\t\t<td width=\"30%\" class=\'fields\'>\n\t\t\t<input type=\'button\' name=\"regenerate\" id=\"regenerate\" id=\"regenerate\" value=\"Regenerate\" class=\'button\' onclick=\'regeneratePDF()\' >\n\t\t\t<input type=\'button\' name=\"ReviewApprove\" id=\"ReviewApprove\" id=\"ReviewApprove\" value=\"Review & Approve\" class=\'button\' onclick=\'reviewAppCall()\' >\n\t\t\t<input type=\'button\' name=\"export_to_excel\" id=\"export_to_excel\" id=\"export_to_excel\" value=\"Export to Excel\" class=\'button\' onclick=\'generateExcel();\' >\t\t\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<td width=\"67%\"  class=\'labels\' colspan=5></td>\n\t\t<td width=\"33%\" class=\'fields\'>\n\t\t\t<input type=\'button\' name=\"revertSts\" id=\"revertSts\" id=\"revertSts\" value=\"Revert Status\" class=\'button\' onclick=\'revertStatus()\' >\n\t\t\t<input type=\'button\' name=\"regenerate\" id=\"regenerate\" id=\"regenerate\" value=\"Regenerate\" class=\'button\' onclick=\'regeneratePDF()\' >\n\t\t\t<input type=\'button\' name=\"genClaim\" id=\"genClaim\" id=\"genClaim\" value=\"Generate claim\" class=\'button\' onclick=\'generateClaim()\' >\n\t\t\t<input type=\'button\' name=\"export_to_excel\" id=\"export_to_excel\" id=\"export_to_excel\" value=\"Export to Excel\" class=\'button\' onclick=\'generateExcel();\'>\t\t\t\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<td width=\"67%\"  class=\'labels\' colspan=5></td>\n\t\t<td width=\"33%\" class=\'fields\'>\n\t\t\t<input type=\'button\' name=\"revertSts\" id=\"revertSts\" id=\"revertSts\" value=\"Revert Status\" class=\'button\' onclick=\'revertStatus()\' >\n\t\t\t<input type=\'button\' name=\"regenerate\" id=\"regenerate\" id=\"regenerate\" disabled value=\"Regenerate\" class=\'button\' onclick=\'regeneratePDF()\' >\n\t\t\t<input type=\'button\' name=\"subToIns\" id=\"subToIns\" id=\"subToIns\" value=\"Submit to insurance\" class=\'button\' onclick=\'submitToIns()\' >\n\t\t\t<input type=\'button\' name=\"export_to_excel\" id=\"export_to_excel\" id=\"export_to_excel\" value=\"Export to Excel\" class=\'button\' onclick=\'generateExcel();\' >\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<input type=\"hidden\" id=\"p_facility_id\" name=\"p_facility_id\" id=\"p_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_claim_status\" name=\"p_claim_status\" id=\"p_claim_status\"\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_patient_id\" name=\"p_patient_id\" id=\"p_patient_id\"\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_episode_type\" name=\"p_episode_type\" id=\"p_episode_type\"\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_encounter_id\" name=\"p_encounter_id\" id=\"p_encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_spec_nursing_unit_code\" name=\"p_spec_nursing_unit_code\" id=\"p_spec_nursing_unit_code\"\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_payer_grp_code\" name=\"p_payer_grp_code\" id=\"p_payer_grp_code\"\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_payer_code\" name=\"p_payer_code\" id=\"p_payer_code\"\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_policy_type_code\" name=\"p_policy_type_code\" id=\"p_policy_type_code\"\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_enc_frm_date\" name=\"p_enc_frm_date\" id=\"p_enc_frm_date\"\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_enc_to_date\" name=\"p_enc_to_date\" id=\"p_enc_to_date\"\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_doc_gen_from\" name=\"p_doc_gen_from\" id=\"p_doc_gen_from\"\tvalue=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_doc_gen_to\" name=\"p_doc_gen_to\" id=\"p_doc_gen_to\"\tvalue=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_claim_number\" name=\"p_claim_number\" id=\"p_claim_number\"\tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_ins_status\" name=\"p_ins_status\" id=\"p_ins_status\"\tvalue=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t<input type=\"hidden\" id=\"p_past_recs_days\" name=\"p_past_recs_days\" id=\"p_past_recs_days\"\tvalue=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t\n\t\t\t<input type=\"hidden\" id=\"claim_status\" name=\"claim_status\" id=\"claim_status\"\tvalue=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\t\t\t\n\t\t</td>\n\t\t\n\t</tr>\n</table>\n</form>\n</body>  \n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);

	
	String facilityId = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	System.err.println("Query String in inerrorbtn.jsp:"+request.getQueryString());
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String claim_status = checkForNull(request.getParameter("claim_status"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String episode_type = checkForNull(request.getParameter("episode_type"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String spec_nursing_unit_code = checkForNull(request.getParameter("spec_nursing_unit_code"));
	String payer_grp_code = checkForNull(request.getParameter("payer_grp_code"));
	String payer_code = checkForNull(request.getParameter("payer_code"));
	String policy_type_code = checkForNull(request.getParameter("policy_type_code"));
	String enc_frm_date = checkForNull(request.getParameter("enc_frm_date"));
	String enc_to_date = checkForNull(request.getParameter("enc_to_date"));
	String doc_gen_from = checkForNull(request.getParameter("doc_gen_from"));
	String doc_gen_to = checkForNull(request.getParameter("doc_gen_to"));
	String claim_number = checkForNull(request.getParameter("claim_number"));
	String ins_status = checkForNull(request.getParameter("ins_status"));
	String past_recs_days = checkForNull(request.getParameter("past_recs_days"));

            _bw.write(_wl_block8Bytes, _wl_block8);
 
	if(claim_status.equals("E")){

            _bw.write(_wl_block9Bytes, _wl_block9);

	}else if(claim_status.equals("D")){

            _bw.write(_wl_block10Bytes, _wl_block10);

	}else if(claim_status.equals("R")){

            _bw.write(_wl_block11Bytes, _wl_block11);

	}else if(claim_status.equals("G")){

            _bw.write(_wl_block12Bytes, _wl_block12);

	}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(claim_status));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(spec_nursing_unit_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(payer_grp_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(payer_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(policy_type_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(enc_frm_date));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(enc_to_date));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(doc_gen_from));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(doc_gen_to));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(claim_number));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ins_status));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(past_recs_days));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(claim_status));
            _bw.write(_wl_block30Bytes, _wl_block30);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
