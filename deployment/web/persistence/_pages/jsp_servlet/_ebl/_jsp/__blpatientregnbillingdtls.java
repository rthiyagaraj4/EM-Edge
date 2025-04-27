package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blpatientregnbillingdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPatientRegnBillingDtls.jsp", 1724645802097L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\t\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/BLPatRegBlngDtls.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/Hashtable.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\n<script language=\'javascript\'>\n\nfunction onFormLoad(serv_panel_ind,charge_YN,charge_at_enc_regn_YN,charge_at_renwel)\n{\n\tparent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false;\n\tparent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;\n\tif(serv_panel_ind != null && serv_panel_ind != \"\")\n\t{\n\t\tif(serv_panel_ind==\'S\')\n\t\t{\n\t\t\tdocument.forms[0].serv_panel_ind.value = \'S\';\n\t\t}\n\t\telse if(serv_panel_ind==\'L\')\n\t\t{\n\t\t\tdocument.forms[0].serv_panel_ind.value = \'L\';\n\t\t}\n\t}\n\n\tif(charge_YN != null && charge_YN != \"\")\n\t{\n\t\tif(charge_YN == \"Y\")\n\t\t{\n\t\t\tdocument.forms[0].chargeble_yn.checked= true;\n\t\t\tdocument.forms[0].charge_non_chargeable_yn.checked= false;\n\t\t\tdocument.forms[0].charge_non_chargeable_yn.disabled = true;\n\t\t\t//Commented V190401-MuthuKumarN/IN70056 & IN:070057\n\t\t\t//document.forms[0].chargeble_dur_renwel.checked= false;\n\t\t\t//document.forms[0].chargeble_dur_renwel.disabled = true;\t\t\t\n\t\t}\n\t}\n\n\tif(charge_at_enc_regn_YN != null && charge_at_enc_regn_YN != \"\")\n\t{\n\t\tif(charge_at_enc_regn_YN == \"Y\")\n\t\t{\n\t\t\tdocument.forms[0].chargeble_yn.checked= false;\n\t\t\tdocument.forms[0].chargeble_yn.disabled = true;\n\t\t\tdocument.forms[0].charge_non_chargeable_yn.checked= true;\n\t\t\t//Commented V190401-MuthuKumarN/IN70056 & IN:070057\n\t\t\t//document.forms[0].chargeble_dur_renwel.checked= false;\n\t\t\t//document.forms[0].chargeble_dur_renwel.disabled = true;\t\t\t\n\t\t}\n\t}\n\t\n\tif(charge_at_renwel != null && charge_at_renwel != \"\")\n\t{\n\t\tif(charge_at_renwel == \"Y\")\n\t\t{\n\t\t\t//Commented V190401-MuthuKumarN/IN70056 & IN:070057\n\t\t\t//document.forms[0].chargeble_yn.checked= false;\n\t\t\t//document.forms[0].charge_non_chargeable_yn.checked= false;\n\t\t\tdocument.forms[0].chargeble_dur_renwel.checked= true;\n\t\t\t//document.forms[0].chargeble_dur_renwel.disabled = true;//Commented V190401-MuthuKumarN/IN70056 & IN:070057\n\t\t\t//Added V190404-MuthuKumarN/AMRI-CRF-0357.1\n\t\t\tdocument.getElementById(\"renewDescLabel\").style.visibility=\'visible\';\n\t\t\tdocument.getElementById(\"renewDescText\").style.visibility=\'visible\';\n\t\t\t//Added V190404-MuthuKumarN/AMRI-CRF-0357.1\n\t\t}\n\t}\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n</head>\n\n<body onLoad=\"onFormLoad(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\',\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\')\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"> \n\n<form name=\'PatRegBlngDtlsForm\' id=\'PatRegBlngDtlsForm\' action=\"../../servlet/eBL.BLPatRegBlngDtlsServlet\" method=\"post\" target=\"messageFrame\">\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'3\' align=\'center\' width=\'100%\'>\n\t\t<tr>\n\t\t\t<td width=\"25%\" class=\"label\"><B>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</B></td>\n\t\t\t<td width=\"25%\" class=\"fields\" colspan=\'3\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<!--\t\t\t<input type=\'text\' name=\"facility_id\" id=\"facility_id\"><input type=\'button\' class=\'button\' name=\"facilitybut\" id=\"facilitybut\" value=\'?\' onClick=\"\">\n-->\n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\"25%\" class=\"label\"><B>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</B></td>\n\t\t\t<td width=\"25%\" class=\"fields\" colspan=\'3\'><input type=\'text\' size=\'40\' maxlength=\'100\' name=\"pat_ser_desc\" id=\"pat_ser_desc\" onBlur=\"pat_series_lkup(\'B\');\" tabindex=\'1\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="><input type=\'hidden\' name=\'pat_ser_code\' id=\'pat_ser_code\' value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"><input type=\'button\' class=\'button\' name=\"patseriesbut\" id=\"patseriesbut\" value=\'?\' onClick=\"pat_series_lkup(\'C\');\" tabindex=\'2\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\"25%\" class=\"label\"><B>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</B></td>\n\t\t\t<td width=\"25%\" class=\"fields\" colspan=\'3\'><input type=\'text\' size=\'40\' maxlength=\'40\' name=\"blng_grp_desc\" id=\"blng_grp_desc\" onBlur=\"blng_grp_lkup(\'B\');\" tabindex=\'3\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="><input type=\'hidden\' name=\'blng_grp_code\' id=\'blng_grp_code\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"><input type=\'hidden\' name=\'slmt_ind\' id=\'slmt_ind\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"><input type=\'hidden\' name=\'adm_rec_flag\' id=\'adm_rec_flag\' value=\"\"><input type=\'button\' class=\'button\' name=\"blnggrpbut\" id=\"blnggrpbut\" value=\'?\' onClick=\"blng_grp_lkup(\'C\');\" tabindex=\'4\' ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</B></td>\n\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' size=\'40\' maxlength=\'100\' name=\"pyr_grp_desc\" id=\"pyr_grp_desc\" onBlur=\"payer_grp_lkup(\'B\');\" tabindex=\'5\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="><input type=\'hidden\' name=\'payer_grp_code\' id=\'payer_grp_code\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"><input type=\'button\' class=\'button\' name=\"pyrgrpbut\" id=\"pyrgrpbut\" value=\'?\' onClick=\"payer_grp_lkup(\'C\');\" tabindex=\'6\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="><img src=\'../../eCommon/images/mandatory.gif\' name=\'payer_grp_mand_yn\' style=\'visibility:hidden\'></td>\n\n\t\t\t<td width=\"25%\" class=\"label\"><B>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</B></td>\n\t\t\t<td width=\"25%\" class=\"fields\"><input type=\'text\' size=\'40\' maxlength=\'100\' name=\"payer_desc\" id=\"payer_desc\" onBlur=\"payer_lkup(\'B\');\" tabindex=\'7\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="><input type=\'hidden\' name=\'payer_code\' id=\'payer_code\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"><input type=\'button\' class=\'button\' name=\"payerbut\" id=\"payerbut\" value=\'?\' onClick=\"payer_lkup(\'C\');\" tabindex=\'8\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="><img src=\'../../eCommon/images/mandatory.gif\' name=\'payer_mand_yn\' style=\'visibility:hidden\'></td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\"15%\" class=\"label\"><B>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</B></td>\n\t\t\t<td width=\"15%\" class=\"fields\"><INPUT TYPE=\"checkbox\" name=\"chargeble_yn\" id=\"chargeble_yn\" tabindex=\'3\' onClick=\"check_item();\"><!--<img src=\'../../eCommon/images/mandatory.gif\'>--></td>\n\t\t\t<td width=\"15%\" class=\"label\"><B>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</B></td>\n\t\t\t<td width=\"15%\" class=\"fields\"><INPUT TYPE=\"checkbox\" name=\"charge_non_chargeable_yn\" id=\"charge_non_chargeable_yn\" tabindex=\'2\' onClick=\"check_item();\"></td>\n\t\t<!--Added V190305-Gayathri/AMRI-CRF-0357.1 -->\t\n\t\t\t<td width=\"15%\" class=\"label\"><B>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</B></td>\n\t\t\t<td width=\"15%\" class=\"fields\"><INPUT TYPE=\"checkbox\" name=\"chargeble_dur_renwel\" id=\"chargeble_dur_renwel\" tabindex=\'2\' onClick=\"check_item();\"></td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\"10%\" class=\"label\">\n\t\t\t<B>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t</B>\n\t\t\t</td>\n\t\t\t<td width=\"10%\" class=\"fields\">\n\t\t\t\t<SELECT name=\"serv_panel_ind\" id=\"serv_panel_ind\" onChange=\'change_pnl_serv_leg()\' tabindex=\'11\'>\n\t\t\t\t\t<option value=\'S\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</option>\n\t\t\t\t\t<option value=\'L\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</option>\n\t\t\t\t</SELECT>\n\t\t\t</td>\n\t\t\t<td width=\"20%\" class=\"label\">\n\t\t\t\t<DIV id=\'serv_leg\' style=\'display:inline\'><B>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</B></DIV>\n\t\t\t\t<DIV id=\'panel_leg\' style=\'display:none\'><B>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</B></DIV>\n\t\t\t</td>\n\t\t\t<td width=\"20%\" class=\"fields\">\n\t\t\t\t<input type=\'text\' size=\'20\' maxlength=\'100\' name=\"serv_panel_desc\" id=\"serv_panel_desc\" tabindex=\'12\' onBlur=\"serv_panel_lkup(\'B\');\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'serv_panel_code\' id=\'serv_panel_code\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t\t\t\t<input type=\'button\' class=\'button\' name=\"servpnlbut\" id=\"servpnlbut\" value=\'?\' onClick=\"serv_panel_lkup(\'C\');\" tabindex=\'13\'>\n\t\t\t</td>\n\t\t\t<!--Added V190404-MuthuKN/AMRI-CRF-0357.1 -->\t\t\t\n\t\t\t<td width=\"20%\" class=\"label\" id=\"renewDescLabel\" name=\"renewDescLabel\" style=\'visibility:hidden\'>\n\t\t\t<B>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t</B>\n\t\t\t</td>\n\t\t\t<td width=\"20%\" class=\"fields\" id=\"renewDescText\" name=\"renewDescText\" style=\'visibility:hidden\' nowrap>\n\t\t\t\t<input type=\'text\' size=\'20\' maxlength=\'100\' name=\"renewal_desc\" id=\"renewal_desc\" tabindex=\'14\' onBlur=\"renew_desc_lkup(\'B\');\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t\t\t<input type=\'hidden\' name=\'renewal_code\' id=\'renewal_code\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t\t\t<input type=\'button\' class=\'button\' name=\"renewdescbtn\" id=\"renewdescbtn\" value=\'?\' onClick=\"renew_desc_lkup(\'C\');\" tabindex=\'15\'>\n\t\t\t</td>\t\t\t\n\t\t\t<!--Added V190404-MuthuKN/AMRI-CRF-0357.1 -->\n\t\t</tr>\n\n\t</table>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t<input type=\'hidden\' name=\'facility_id1\' id=\'facility_id1\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t<input type=\'hidden\' name=\'pat_ser_grp_code1\' id=\'pat_ser_grp_code1\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n\t<input type=\'hidden\' name=\'blng_grp_id1\' id=\'blng_grp_id1\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n\t<input type=\'hidden\' name=\'cust_group_code1\' id=\'cust_group_code1\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t<input type=\'hidden\' name=\'cust_code1\' id=\'cust_code1\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n</form>\n\n</body>\n\n</html>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null;
	PreparedStatement pstmt = null ;
	Statement stmt				= null;
	ResultSet rs = null;

	String locale = (String)session.getAttribute("LOCALE");
	int noofdecimal=2;
	String sys_date="";
	String sys_date_wht_sec=""; // System time without seconds
	String facility_desc="", mode="";

	String pat_ser_grp_code="", pat_ser_grp_desc="", blng_grp_id="", blng_grp_desc="", payer_grp_code="", payer_grp_desc="";
	String payer_code="", payer_desc="", serv_panel_ind="", serv_panel_code="", serv_panel_desc= "";
	String charge_YN="N", charge_at_enc_regn_YN="N", slmt_ind="";
	
	String charge_at_renwel="N";
	String renewal_desc ="",renewal_code="";//Added V190404-MuthuKN/AMRI-CRF-0357.1

	String enable_disable_flag = "";

	try
	{
		con = ConnectionManager.getConnection(request);

		request.setCharacterEncoding("UTF-8");
		HttpSession httpSession = request.getSession(false);
//		Properties p  = (Properties)httpSession.getValue("jdbc");	
		String facility_id = (String)httpSession.getValue("facility_id");
//		String strLoggedUser = p.getProperty("login_user");

//		java.util.Locale loc = new java.util.Locale(locale);

		mode = request.getParameter("mode");
		if(mode == null) mode="";
//		System.err.println("Mode:"+mode);

		if(mode.equals("modify"))
		{
			enable_disable_flag = "DISABLED";
		}
		try
		{
			String facility_desc_sql="select FACILITY_NAME from SM_FACILITY_PARAM_LANG_VW where FACILITY_ID='"+facility_id+"' and language_id='"+locale+"'";
			stmt = con.createStatement();
			rs = stmt.executeQuery(facility_desc_sql) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					facility_desc = rs.getString(1);
				}
			}
			if(rs !=null) rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception @ sysdate"+e);
			e.printStackTrace();
		}
		if(facility_desc == null) facility_desc="";

		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			ResultSet rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}	
			if(rscurr!=null) rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("Exception in No of Decimal Query="+e.toString());
		}	

		try
		{
			String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					sys_date = rs.getString(1);
				}
			}
			if(rs !=null) rs.close();
			stmt.close();

			query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI') from dual";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query_date) ;
			if( rs != null ) 
			{
				while( rs.next() )
				{  
					sys_date_wht_sec = rs.getString(1);
				}
			}
			if(rs !=null) rs.close();
			stmt.close();
		}
		catch(Exception e)
		{
			//out.println("Exception @ sysdate"+e);
			e.printStackTrace();
		}

		if(mode.equals("modify"))
		{
//			System.err.println("Inside UPDATE loop");
			String str_pat_ser_grp_code = request.getParameter("pat_ser_grp_code");
			if(str_pat_ser_grp_code == null) str_pat_ser_grp_code="";

			String str_blng_grp_id = request.getParameter("blng_grp_id");
			if(str_blng_grp_id == null) str_blng_grp_id="";

			String str_payer_grp_code = request.getParameter("payer_grp_code");
			if(str_payer_grp_code == null) str_payer_grp_code="";

			String str_payer_code = request.getParameter("payer_code");
			if(str_payer_code == null) str_payer_code="";

//			System.err.println("str_pat_ser_grp_code:"+str_pat_ser_grp_code);
//			System.err.println("str_blng_grp_id:"+str_blng_grp_id);
//			System.err.println("str_payer_grp_code:"+str_payer_grp_code);
//			System.err.println("str_payer_code:"+str_payer_code);
			
			try
			{
				String sql = "select SETTLEMENT_IND from BL_BLNG_GRP where BLNG_GRP_ID= ?";				
				pstmt   = con.prepareStatement(sql.toString());
				pstmt.setString(1,str_blng_grp_id) ;
		
				rs = pstmt.executeQuery();
		
				while(rs!=null && rs.next())
				{
					slmt_ind = rs.getString("SETTLEMENT_IND");
					if(slmt_ind == null) slmt_ind="";
				}
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
//				System.err.println("slmt_ind:"+slmt_ind);
				if(slmt_ind.equals("C"))
				{
					sql = "select * from BL_MP_PAT_REGN_DTLS_VW where OPERATING_FACILITY_ID= ?  and PAT_SER_GRP_CODE= ?  and BLNG_GRP_ID=? and language_id=?";

					pstmt   = con.prepareStatement(sql.toString());
					pstmt.setString(1,facility_id) ;
					pstmt.setString(2,str_pat_ser_grp_code) ;
					pstmt.setString(3,str_blng_grp_id) ;
					pstmt.setString(4,locale) ;
				}
				else
				{
					sql = "select * from BL_MP_PAT_REGN_DTLS_VW where OPERATING_FACILITY_ID= ?  and PAT_SER_GRP_CODE= ?  and BLNG_GRP_ID=? and PAYER_GRP_CODE=? and PAYER_CODE=? and language_id=?";
					pstmt   = con.prepareStatement(sql.toString());
					pstmt.setString(1,facility_id) ;
					pstmt.setString(2,str_pat_ser_grp_code) ;
					pstmt.setString(3,str_blng_grp_id) ;
					pstmt.setString(4,str_payer_grp_code) ;
					pstmt.setString(5,str_payer_code) ;
					pstmt.setString(6,locale) ;
				}

				rs = pstmt.executeQuery();
		
				while(rs!=null && rs.next())
				{
					pat_ser_grp_code = rs.getString("PAT_SER_GRP_CODE");
					if(pat_ser_grp_code == null) pat_ser_grp_code="";

					pat_ser_grp_desc = rs.getString("PAT_SER_GRP_DESC");
					if(pat_ser_grp_desc == null) pat_ser_grp_desc="";
//					System.err.println("pat_ser_grp_desc:"+pat_ser_grp_desc);
					blng_grp_id = rs.getString("BLNG_GRP_ID");
					if(blng_grp_id == null) blng_grp_id="";

					blng_grp_desc = rs.getString("BLNG_GRP_DESC");
					if(blng_grp_desc == null) blng_grp_desc="";

					payer_grp_code = rs.getString("PAYER_GRP_CODE");
					if(payer_grp_code == null) payer_grp_code="";

					payer_grp_desc = rs.getString("PAYER_GRP_DESC");
					if(payer_grp_desc == null) payer_grp_desc="";

					payer_code = rs.getString("PAYER_CODE");
					if(payer_code == null) payer_code="";

					payer_desc = rs.getString("PAYER_DESC");
					if(payer_desc == null) payer_desc="";

					serv_panel_ind = rs.getString("SERV_PANEL_IND");
					if(serv_panel_ind == null) serv_panel_ind="";

					serv_panel_code = rs.getString("SERV_PANEL_CODE");
					if(serv_panel_code == null) serv_panel_code="";

					serv_panel_desc = rs.getString("SERV_PANEL_DESC");
					if(serv_panel_desc == null) serv_panel_desc="";

					charge_YN = rs.getString("CHARGE_YN");
					if(charge_YN == null) charge_YN="N";

					charge_at_enc_regn_YN = rs.getString("CHARGE_AT_ENC_REGN");
					if(charge_at_enc_regn_YN == null) charge_at_enc_regn_YN="N";
					
					charge_at_renwel = rs.getString("CHARGE_PAT_RENEW_YN");
					if(charge_at_renwel == null) charge_at_renwel="N";
					
					//Added V190404-MuthuKN/AMRI-CRF-0357.1
					renewal_code = rs.getString("REN_SERV_PANEL_CODE");
					if(renewal_code == null) renewal_code="";
					System.err.println("renewal_code:"+renewal_code);

					renewal_desc = rs.getString("REN_SERV_PANEL_DESC");
					if(renewal_desc == null) renewal_desc="";
					System.err.println("renewal_desc:"+renewal_desc);

					//Added V190404-MuthuKN/AMRI-CRF-0357.1
				}
				if(rs != null)rs.close();
				if(pstmt != null)pstmt.close();
			}
			catch(Exception e)
			{
				//System.err.println("Execption in Update Loop:"+e);
				//out.println("Execption in Update Loop:"+e);
				e.printStackTrace();
			}
		}
	
		String query_string=request.getQueryString();
//		System.err.println("request.getQueryString() in BLPatientRegnBillingDtls.jsp:"+query_string);

            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(serv_panel_ind));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(charge_YN));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(charge_at_enc_regn_YN));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(charge_at_renwel));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pat_ser_grp_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(enable_disable_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pat_ser_grp_code));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(enable_disable_flag));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(blng_grp_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(enable_disable_flag));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(slmt_ind));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(enable_disable_flag));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(payer_grp_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(enable_disable_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(payer_grp_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(enable_disable_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(payer_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(enable_disable_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(payer_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(enable_disable_flag));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(serv_panel_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(serv_panel_code));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(renewal_desc));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(renewal_code));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(pat_ser_grp_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(payer_grp_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(payer_code));
            _bw.write(_wl_block49Bytes, _wl_block49);

	}
	catch(Exception ee)
	{
		//out.println("Exception in Details.jsp"+ee);
		ee.printStackTrace();
	}
	finally
	{
		if(pstmt != null)pstmt.close();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FacilityID.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.PatientSeries.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CHAR_AT_REG.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CHRG_DUR_ENC.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CHRG_DUR_REW.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILLING_SERVICE_PANEL.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Panel.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ServiceDescription.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PanelDescription.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RenewalDescription.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }
}
