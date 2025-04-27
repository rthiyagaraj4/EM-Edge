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
import eBL.BLReportIdMapper;
import webbeans.op.CurrencyFormat;
import webbeans.eCommon.*;
import org.apache.commons.codec.binary.Base64;
import java.util.*;
import com.ehis.util.*;

public final class __blfutordinsapprtrackencounterframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLFutOrdInsApprTrackEncounterFrame.jsp", 1730288353802L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eBL/js/BLFutOrdInsApprTrackResult.js\' language=\'javascript\'></script>\n<script src=\'../../eBL/js/BLFutOrdInsApprTrack.js\' language=\'javascript\'></script>\n\n<html>\n<HEAD>\n\t<style>\n\t\tdiv.tableContainer {\n\t\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\t\theight: 160px; \t/* must be greater than tbody*/\n\t\t\toverflow: auto;\n\t\t\tmargin: 0 auto;\n\t\t}\n\t\t\n\t\ttable {\n\t\t\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\t\t\tborder: none;\n\t\t\tbackground-color: #f7f7f7;\n\t\t\t}\n\t\t\t\n\t\ttable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\t\t\toverflow: auto; \n\t\t\theight: 120x;\n\t\t\toverflow-x: hidden;\n\t\t\t}\n\t\t\t\n\t\tthead tr\t{\n\t\t\tposition:relative; \n\t\t\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t\t\t}\n\t\t\t\t\n\t\t\t\tdiv.tableContainer {\n\t\t\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\t\t\theight: 140px; \t/* must be greater than tbody*/\n\t\t\t\toverflow: scroll;\n\t\t\t\tmargin: 0 auto;\n\t\t\t}\t\n\t\t\t.LocalYellow\n\t\t\t{\n\t\t\t\tCOLOR:#444444;\n\t\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\t\tFONT-SIZE: 8pt ;\n\t\t\t\tborder: 1x;\n\t\t\t\tborder-style: dashed;\n\t\t\t\tborder-left-color: #D5E2E5;\n\t\t\t\tborder-right-color: #D5E2E5;\n\t\t\t\tborder-top-color: #D5E2E5;\n\t\t\t\tborder-bottom-color: #D5E2E5; \n\t\t\t\tPADDING-LEFT:7px;\n\t  \t\t\tPADDING-RIGHT:7px\n\t\t\t}\n\t\t\tSPAN.LABEL\n\t\t\t{\n\t\t\t  COLOR:#444444;\n\t\t\t  /*background-color:#FFFFFF;*/\n\t\t\t  background-color:#FFFFFF;\n\t\t\t  FONT-SIZE: 8pt;\n\t\t\t  TEXT-ALIGN: LEFT;\n\t\t\t  /*TEXT-ALIGN: RIGHT;*/\n\t\t\t  PADDING-LEFT:7px;\n\t\t\t  PADDING-RIGHT:7px\n\t\t\t}\n\t\t\t\n\t\t\tSPAN.LABEL1\n\t\t\t{\n\t\t\t  COLOR:#444444;\n\t\t\t  /*background-color:#FFFFFF;*/\n\t\t\t  background-color:#FFFFFF;\n\t\t\t  FONT-SIZE: 8pt;\n\t\t\t  /*TEXT-ALIGN: LEFT;*/\n\t\t\t  TEXT-ALIGN: RIGHT;\n\t\t\t  PADDING-LEFT:7px;\n\t\t\t  PADDING-RIGHT:7px\n\t\t\t}\n\t\t\t\n\t\t\tSPAN.SpanYellow\n\t\t\t{\n\t\t\t\tCOLOR:#444444;\n\t\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\t\tFONT-SIZE: 8pt ;\n\t\t\t\tPADDING-LEFT:7px;\n\t\t\t\tPADDING-RIGHT:7px\n\t\t\t}\n\t\t\n\t</style>\n\t\n</HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n\n<form name=\"BLFutOrdInsApprTrackEncounterFrame\" id=\"BLFutOrdInsApprTrackEncounterFrame\">\n<table cellpadding=3 cellspacing=0  width=\"100%\" border=\"1\">\n<div id=\"tableContainer\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\n<thead>\n\t<tr><td class=\"COLUMNHEADER\" align=\'left\' colspan=\"9\">Patient Data</td></tr>\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"2%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td class=\'COLUMNHEADER\' nowrap width = \"5%\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t</tr>\n</thead>\n<tbody id=\"BLFutOrdInsApprTrackEncTable\" name=\"BLFutOrdInsApprTrackEncTable\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\n\n\t<tr id=\'row";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' >\n\t\t<td class=\"field\">\n\t\t\t&nbsp;<label name=\'srl_no_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' id=\'srl_no_";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</label>\n\t\t</td>\n\t\t\n\t\t<td class=\"field\" nowrap>\n        \t<a href=\"#\" name=\"patient_name_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" id=\"patient_name_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" onclick=\"callDemographic(this)\" style=\"text-decoration: underline;\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a>\n        \t<input type=\"hidden\" name = \"patient_id_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id = \"patient_id_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" />\n         </td>\n\t\t \n\t\t <td class=\"field\" nowrap>\n         \t&nbsp;<a href=\"#\" name=\"encounter_id_";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"encounter_id_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" onclick=\"placeFutureOrder(this)\" style=\"text-decoration: underline;\" >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</a>\n         \t\t  <input type=\"button\" name=\"search_btn\" id=\"search_btn\" id=\"search_btn\" value=\"D\" class=\"button\" onClick=\"changeFieldColor(";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="); displayServiceData(this);\" />\n         \t\t  <input type=\"hidden\" \tid=\"rowbgColorYN_";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" name=\"rowbgColorYN_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"  value=\"\" />\n         </td>\n\t\t <td class=\"field\" nowrap>\n          \t&nbsp;<label name=\"patient_class_";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" id=\"patient_class_";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</label>\n          \t<input type=\"hidden\" id=\"episode_type_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" name=\"episode_type_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"\tvalue=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n         </td>\n\t\t<td class=\"field\" nowrap>\n         \t&nbsp;<label name=\"payer_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"payer_";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</label>\n\t\t\t<input type=\"hidden\" id=\"payer_code_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" name=\"payer_code_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t<input type=\"hidden\" id=\"payer_grp_code_";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" name=\"payer_grp_code_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t<input type=\"hidden\" id=\"blng_grp_id_";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" name=\"blng_grp_id_";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\t\n         </td>\n\t\t \n\t\t <td class=\"field\" nowrap>\n         \t&nbsp;<label name=\"policy_";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"policy_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</label>\n         \t <input type=\"hidden\" name = \"policy_type_code_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id = \"policy_type_code_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" />\n         </td>\n\t\t \n\t\t <td class=\"field\" nowrap>\n             <label name=\"visit_adm_date_";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"visit_adm_date_";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</label>\n         </td>\n\t\t \n         <td class=\"field\" nowrap>\n         \t&nbsp;<label name=\"physician_name_";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"physician_name_";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</label>\n         \t<input type=\"hidden\" id=\"physician_id_";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" name=\"physician_id_";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n         </td>\n\t\t \n\t\t <td class=\"field\" nowrap>\n         \t&nbsp;<label name=\"speciality_";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"speciality_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</label>\n         \t<input type=\"hidden\" id=\"speciality_code_";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" name=\"speciality_code_";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n         </td>\n\t\t \t\n\t</tr>\t\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\t\t\n\n\t</tbody>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\t\n<Script>\n//document.getElementById(\"patient_sec\").style.display = \"none\";\nalert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));</script>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\n\t</tbody>\n\t<input type=\'hidden\' name=\'prevClicked\' id=\'prevClicked\' value=\"\" />\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"/>\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"/>\n\t<input type=\"hidden\" name=\"login_user\" id=\"login_user\" id=\"login_user\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"/>\n\t<input type=\"hidden\" name=\"rowCount\" id=\"rowCount\" id=\"rowCount\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"/> \n\t<input type=\"hidden\" id=\"p_action_id\" name=\"p_action_id\" id=\"p_action_id\"\tvalue=\"\"/>\t\n\t<input type=\"hidden\" id=\"prevActionID\" name=\"prevActionID\" id=\"prevActionID\"\tvalue=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"/>\n\t<input type=\"hidden\" id=\"prevEncounterId\" name=\"prevEncounterId\" id=\"prevEncounterId\"\tvalue=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\n\t<input type=\"hidden\" id=\"p_serv_grp_code\" name=\"p_serv_grp_code\" id=\"p_serv_grp_code\"\tvalue=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type=\"hidden\" id=\"p_serv_class_code\" name=\"p_serv_class_code\" id=\"p_serv_class_code\"\tvalue=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\"hidden\" id=\"p_order_line_status\" name=\"p_order_line_status\" id=\"p_order_line_status\"\tvalue=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<input type=\"hidden\" id=\"p_coding_status\" name=\"p_coding_status\" id=\"p_coding_status\"\tvalue=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\"hidden\" id=\"p_ins_status\" name=\"p_ins_status\" id=\"p_ins_status\"\tvalue=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\"hidden\" id=\"p_enc_frm_date\" name=\"p_enc_frm_date\" id=\"p_enc_frm_date\"\tvalue=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t<input type=\"hidden\" id=\"p_enc_to_date\" name=\"p_enc_to_date\" id=\"p_enc_to_date\"\tvalue=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n</table>\t\n</div>\t\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n</form>\n</body>\n<script type=\"text/javascript\"> \n\t\t//var prevEncounterId = document.forms[0].prevEncounterId.value;\n\t\t \n\t\tvar prevEncounterId = document.getElementById(\'prevEncounterId\').value;\n\t\tif(prevEncounterId != \"\"){\n\t\t\treloadResultFrame(prevEncounterId); \n\t\t}\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</html>\n\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );
	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}

	
	private String checkForNull(String inputString, String dfltVal)
	{
		return (inputString == null) ? dfltVal : inputString;
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

	System.err.println("In BLFutOrdInsApprTrackEncounterFrame.jsp");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rst=null;
	
	String facilityId = (String)session.getAttribute("facility_id");
	String locale = (String)session.getAttribute("locale");
	if(locale == null) locale = "en";
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
	String prevActionID = checkForNull(request.getParameter("prevActionID"));
	String prevEncounterId = checkForNull(request.getParameter("prevEncounterId"));
	
	System.err.println("URL Parameters :- Patient_id= "+qry_patient_id+", Episode_type="+qry_episode_type+" , Encounter_id="+qry_encounter_id+", Enc_frm_date="+qry_enc_frm_date+", Enc_to_date="+qry_enc_to_date+", Spec_nursing_unit_code="+qry_spec_nursing_unit_code+", Insurance_Status="+qry_insurance_Status+", Payer_grp_code="+qry_payer_grp_code+", Payer_code="+qry_payer_code+", Policy_type_code="+qry_policy_type_code+", Order_status="+qry_order_status+", ServiceGroupCode="+qry_serviceGroupCode+", ServiceClassificationCode="+qry_serviceClassificationCode+", Coding_status="+qry_coding_status+", BillingGrpCode="+qry_billingGrpCode+", prevActionID= "+prevActionID);

            _bw.write(_wl_block8Bytes, _wl_block8);
	

	
	try
	{
		System.err.println("Query String in inerror.jsp:"+request.getQueryString());
		String params = request.getQueryString() ;
		if(params==null || params.equals("")) params="";
		String sql = "";
		int row_count = 0;
		int column_count = 1;
		java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_user = (String) p.getProperty("login_user");
		System.err.println("locale in BLFutOrdInsApprTrackEncounterFrame.jsp: "+locale);
		
		
		con=ConnectionManager.getConnection(request);
		
		sql = "SELECT DISTINCT b.short_name patient_name, a.patient_id PATIENT_ID, ENCOUNTER_ID, PATIENT_CLASS, "+
			  "(select long_name from ar_customer_lang_vw where cust_code = c.CUST_CODE and language_id = 'en') as Payer, "+
			  "POLICY_NUMBER as PolicyNumber, "+
			  "to_char(VISIT_ADM_DATE_TIME,'DD/MM/YYYY HH:MI:SS') VISIT_ADMN_DATE_TIME, "+
			  "(select PRACTITIONER_NAME from am_practitioner_lang_vw where practitioner_id = (DECODE(PATIENT_CLASS,'IP',ADMIT_PRACTITIONER_ID,'DC',ADMIT_PRACTITIONER_ID,'OP',ATTEND_PRACTITIONER_ID,'EM',ATTEND_PRACTITIONER_ID)) and language_id = 'en') as Practitioner, "+
			  "(select short_desc from am_speciality_lang_vw where language_id='en' AND NVL(EFF_STATUS,'D') = 'E' and speciality_code = a.SPECIALTY_CODE)  as SPECIALTY, "+
			  "DECODE(PATIENT_CLASS,'IP','I','DC','D','OP','O','EM','E') EPISODE_TYPE, "+
			  "a.EPISODE_ID, "+
			  "a.OP_EPISODE_VISIT_NUM VisitID, "+
			  "a.SPECIALTY_CODE, "+
			  "DECODE(PATIENT_CLASS,'IP',ADMIT_PRACTITIONER_ID,'DC',ADMIT_PRACTITIONER_ID,'OP',ATTEND_PRACTITIONER_ID,'EM',ATTEND_PRACTITIONER_ID) PRACTITIONER_ID, "+
			  "CUST_GROUP_CODE, "+
			  "CUST_CODE, "+
			  "POLICY_TYPE_CODE, "+
			  "c.BLNG_GRP_ID "+
			  "FROM PR_ENCOUNTER a, MP_PATIENT_MAST b, BL_PRV_ENC_SELECT_INS_BG_VW c "+
			  "WHERE TRUNC(VISIT_ADM_DATE_TIME) BETWEEN to_date(?,'DD/MM/YYYY') AND to_date(?,'DD/MM/YYYY') "+
			  "AND FACILITY_ID = NVL(?,FACILITY_ID) "+
			  "AND a.PATIENT_ID = NVL(?,a.PATIENT_ID) "+
			  "AND ENCOUNTER_ID = NVL(?,ENCOUNTER_ID) "+
			  "AND SPECIALTY_CODE = NVL(?,SPECIALTY_CODE)  "+
			  "AND a.patient_id = b.patient_id "+
			  "AND a.PATIENT_CLASS = DECODE(NVL(?,a.PATIENT_CLASS),'I','IP','D','DC','O','OP','E','EM',a.PATIENT_CLASS) "+
			  "AND a.patient_id = c.patient_id "+
			  "AND a.episode_id = c.episode_id "+
			  "AND c.priority = 1 "+
			  "AND ((a.PATIENT_CLASS IN ('OP','EM') and a.OP_EPISODE_VISIT_NUM = c.visit_id) OR a.PATIENT_CLASS IN ('IP','DC')) "+
			  "AND C.BLNG_GRP_ID = NVL(?,c.BLNG_GRP_ID) ";
			  
		if(!"".equals(qry_payer_grp_code)){
			sql = sql + " and a.CUST_GROUP_CODE = nvl(?,a.CUST_GROUP_CODE) ";
		}
		
		if(!"".equals(qry_payer_code)){
			sql = sql + " and a.CUST_CODE = nvl(?,a.CUST_CODE) ";
		}
		
		if(!"".equals(qry_policy_type_code)){
			sql = sql + " and a.policy_type_code = nvl(?,a.policy_type_code) ";
		}
				
				
		System.err.println("sql to load data :"+sql);
		
		pstmt = con.prepareStatement(sql);		
		pstmt.setString(column_count, qry_enc_frm_date);				
		pstmt.setString(++column_count, qry_enc_to_date);		
		pstmt.setString(++column_count, facilityId);
		pstmt.setString(++column_count,qry_patient_id);							
		pstmt.setString(++column_count,qry_encounter_id);						
		pstmt.setString(++column_count, qry_spec_nursing_unit_code);					
		pstmt.setString(++column_count, qry_episode_type);
		pstmt.setString(++column_count, qry_billingGrpCode);
		
		System.err.println("sql to load data column_count:"+column_count);
		if(!"".equals(qry_payer_grp_code))
			pstmt.setString(++column_count,qry_payer_grp_code);			
		
		if(!"".equals(qry_payer_code))
			pstmt.setString(++column_count, qry_payer_code);
		
		if(!"".equals(qry_policy_type_code))
			pstmt.setString(++column_count, qry_policy_type_code);	


		System.err.println("sql to load data column_count:"+column_count);
				
		rst = pstmt.executeQuery();
		while ( rst.next() )
		{	
			System.err.println(rst.toString());
			String patient_id = checkForNull(rst.getString("PATIENT_ID"));
			String patient_name = checkForNull(rst.getString("patient_name"));
			String encounter_id = checkForNull(rst.getString("ENCOUNTER_ID"));
			String pat_class = checkForNull(rst.getString("PATIENT_CLASS"));
			String episode_type = checkForNull(rst.getString("EPISODE_TYPE"));
			String payer_code = checkForNull(rst.getString("CUST_CODE"));
			String payer_desc = checkForNull(rst.getString("Payer"));
			String policy_no = checkForNull(rst.getString("PolicyNumber"));
			String visit_date = checkForNull(rst.getString("VISIT_ADMN_DATE_TIME"));
			String physician_id = checkForNull(rst.getString("PRACTITIONER_ID"));
			String physician_name = checkForNull(rst.getString("Practitioner"));
			String speciality_code = checkForNull(rst.getString("SPECIALTY_CODE"));
			String specialty_desc = checkForNull(rst.getString("SPECIALTY"));
			String payer_group_code = checkForNull(rst.getString("CUST_GROUP_CODE"));
			String policy_type_code = checkForNull(rst.getString("POLICY_TYPE_CODE"));
			String blng_grp_id = checkForNull(rst.getString("BLNG_GRP_ID"));
						
 			row_count++;


            _bw.write(_wl_block9Bytes, _wl_block9);

		if(row_count == 1)
		{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		}

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(payer_desc));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(payer_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(payer_group_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(policy_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(policy_type_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(visit_date));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(physician_name));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(physician_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(specialty_desc));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block57Bytes, _wl_block57);

		}

            _bw.write(_wl_block58Bytes, _wl_block58);
					
		
		if(row_count == 0){

            _bw.write(_wl_block59Bytes, _wl_block59);

		}

            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(prevActionID));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(prevEncounterId));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(qry_serviceGroupCode));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(qry_serviceClassificationCode));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(qry_order_status));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(qry_coding_status));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(qry_insurance_Status));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(qry_enc_frm_date));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(qry_enc_to_date));
            _bw.write(_wl_block73Bytes, _wl_block73);

	}catch(Exception e){
		out.println("Exception in BLFutOrdInsApprTrackEncounterFrame.jsp: "+e);
		System.err.println("Exception in BLFutOrdInsApprTrackEncounterFrame.jsp: "+e);
	}finally{
		if(pstmt!=null)	pstmt.close();
		if(rst!=null)	rst.close();
		ConnectionManager.returnConnection(con,request);		
	} 

            _bw.write(_wl_block74Bytes, _wl_block74);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SrlNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY_NO.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.VISIT_ADMN_DATE_TIME.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }
}
