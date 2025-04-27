package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import blipin.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifycanceladmission extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/addmodifyCancelAdmission.jsp", 1709117690348L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n<TITLE> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" </TITLE>\n    <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n    <script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n    <script src=\"../js/CancelAdmission.js\" language=\"JavaScript\"></Script>\n    <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<font id=\'Processing\'><td class=\'columnheader\'><h4>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<h4></td></font>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'canceladmission_form\' id=\'canceladmission_form\' action=\'../../servlet/eIP.CancelAdmissionServlet\' method=\'post\' target=\'messageFrame\'> \n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr><td class=\'columnheader\' colspan=\'4\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td></tr>\n<tr><!-- 17956 Thursday, January 07, 2010 -->\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td class=\'QUERYDATA\'  width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<input type=\'hidden\' name=\'admissiondatetime\' id=\'admissiondatetime\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"></td> \n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t<td class=\'QUERYDATA\'  width=\'25%\' >";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<input type=\'hidden\' name=\'admissiontypedesc\' id=\'admissiontypedesc\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></td>\n</tr>\n<tr>\t\t  \n    <td class=\'label\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n      <td class=\'QUERYDATA\'   >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n        <input type=\'hidden\' name=\'encounterID\' id=\'encounterID\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n      </td>\n\t<td class=\'label\'>&nbsp;</td>\n\t<td class=\'label\'>&nbsp;</td>\n </tr>\n  <tr>\n      <td class=\'label\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n        <input type=\'hidden\' name=\'specialtyshortdesc\' id=\'specialtyshortdesc\' >\n      </td> \n\t\t<td class=\'label\' width=\'10%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n        <input type=\'hidden\' name=\'practitionername\' id=\'practitionername\'>\n      </td> \n\n        \n </tr>\n  <tr>\n      <td class=\'label\' width=\'10%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n        <input type=\'hidden\' name=\'patienttype\' id=\'patienttype\'>\n      </td>   \n      <td class=\'label\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n        <input type=\'hidden\' name=\'medicalteam\' id=\'medicalteam\'>\n      </td>     \n  </tr>\n \n <td class=\'columnheader\' colspan=\'4\'  >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n <tr>\n      <td class=\'label\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n        <input type=\'hidden\' name=\'nursingunitcode\' id=\'nursingunitcode\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n      </td> \n      <td class=\'label\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n        <input type=\'hidden\' name=\'serviceshortdesc\' id=\'serviceshortdesc\'>\n      </td> \n</tr>\n<tr>\n      <td class=\'label\' >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\n\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<td class=\'QUERYDATA\'   >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<input type=\'hidden\' name=\'blocked_bed_no\' id=\'blocked_bed_no\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<input type=\'hidden\' name=\'bedno\' id=\'bedno\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t    <td class=\'label\' width=\'10%\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n        <td class=\'QUERYDATA\'   >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n        <input type=\'hidden\' name=\'roomno\' id=\'roomno\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n      </td> \n\n      </td>         \n </tr>\n <tr>\n      \n      <td class=\'label\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\n      <td class=\'QUERYDATA\'  >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n        <input type=\'hidden\' name=\'bedclassshortdesc\' id=\'bedclassshortdesc\'>\n      </td> \n\t   <td class=\'label\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n        <input type=\'hidden\' name=\'bedtypeshortdesc\' id=\'bedtypeshortdesc\'>\n      </td> \n </tr>\n \n</table>\n\t\t\n\t<tr><td class=\'label\' width=\'1%\' nowrap>\n <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' id=\'u\' align=\'center\' style=\'visibility:hidden\'> \n <tr>\n\t\t\t<td class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t</td>\n\t\t\t<td nowrap colspan=3 class=\"fields\">\n\t\t\t<select name=\"reason_for_cancellation\" id=\"reason_for_cancellation\">\n\t\t\t<option value=\"\">---";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="---</option>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n\t\t\t</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\n </tr>  \n </table>\n   </td></tr>\t\t  \n <table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\"100%\" > \n\n <tr> \n <!--  /* =========== commented by ranjani to revert back the billing details ============= -->\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'25%\'>&nbsp;</td>\n\t<td class=\"fields\" nowrap width=\'25%\'><input type=button class=\'button\' name = \'cancel_admission\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' onClick=\'CancelAdm(this)\' ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" ><input type=button class=\'button\' name = \'close\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' onClick=\'CloseWin(this)\'></td> \n </tr> \n\n </table>\n<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n<input type=\'hidden\' name=\'bl_install\' id=\'bl_install\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" >\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\t\n<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\t\n<input type=\'hidden\' name=\'pat_check_yn\' id=\'pat_check_yn\' value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\t\n\t\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\"Processing\").innerHTML=\"\";\n\t\t\t\t\tvar error = getMessage(\"TRF_EXIST_CONT_CANCEL_ADM\",\'IP\');\n\t\t\t\t\tif(!confirm(error)){\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\"Processing\").innerHTML=\"\";\n\t\t\t\t\tvar error = getMessage(\"TRF_REQ_EXIST_CONT_CANCEL_ADM\",\'IP\');\n\t\t\t\t\tif(!confirm(error)){\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\"Processing\").innerHTML=\"\";\n\t\t\t\t\tvar error = getMessage(\"UNCONF_BED_CLASS_REQ_EXIST\",\'IP\');\n\t\t\t\t\tif(!confirm(error)){\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t}\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\"Processing\").innerHTML=\"\";\n\t\t\t\t\tvar error = getMessage(\"ORD_EXIST_CANT_CANCEL_ADM\",\'IP\');\n\t\t\t\t\talert(error)\n\t\t\t\t\twindow.close();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\"Processing\").innerHTML=\"\";\n\t\t\t\t\tvar error = getMessage(\"DISCH_ADV_EXIST_CANT_CANCEL_ADM\",\'IP\');\n\t\t\t\t\talert(error)\n\t\t\t\t\twindow.close();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\"Processing\").innerHTML=\"\";\n\t\t\t\t\tvar error = getMessage(\"DISCR_MSR_EXIST_CANT_CANCEL_ADM\",\'IP\');\n\t\t\t\t\talert(error)\n\t\t\t\t\twindow.close();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\"Processing\").innerHTML=\"\";\n\t\t\t\t\tvar error = getMessage(\"ENC_NOTE_EXIST_CANT_CANCEL_ADM\",\'IP\');\n\t\t\t\t\talert(error)\n\t\t\t\t\twindow.close();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.getElementById(\"Processing\").innerHTML=\"\";\n\t\t\t\t\t\talert(getMessage(\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\',\'BL\'));\n\t\t\t\t\t\twindow.close();\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t<script>\n\t\t\t\t\talert(\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\");\n\t\t\t\t\twindow.close();\n\t\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\"Processing\").innerHTML=\"\";\n\t\t\t\tvar error = getMessage(\"ADMIN_CANCEL_NOT_ALLOWED\",\'IP\');\n\t\t\t\tvar error = error + \' - \' + \'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\';\n\t\t\t\talert(error)\n\t\t\t\twindow.close();\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\n<script>\ndocument.getElementById(\"Processing\").innerHTML=\"\";\n</script>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
  
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale		= (String)session.getAttribute("LOCALE");
	Connection con		= null;
    Statement stmt		= null;
    PreparedStatement pstmt = null;
    ResultSet rs		= null;
    String facilityID	= (String)session.getValue("facility_id");
    String encounterID	= request.getParameter("encounter_id");
	String episode_id	= encounterID;
    String patientId	= request.getParameter("patientId");
    String pat_check_yn	= "";
    String install_yn	= "N";
	// ========= Query string changed by ranjani to retreive back the billing details ==========
    String admissiondatetime	= "";
    String admissiontypedesc	= "";
    String specialtyshortdesc	= "";
    String practitionername		= "";
    String patienttype			= "";
    String nursingunitshortdesc = "";
    String serviceshortdesc		= "";
    String bedno				= "";
    String roomno				= "";
    String bedclassshortdesc	= "";
    String bedtypeshortdesc		= "";
    String gender				= "";
    String nursingunitcode		= "";
    String cancel_disable		= "";
    String practitionerid		= "";
    String meddesc				= "";
	String bill_error			= ""; 
	String charged_service		= "";
	String unprocessed_service	= "";
	String adm_deposit			= "";
	String blocked_bed_no		= "";
	String adt_status			= "";
	String patient_class		= "";
	String admissiondatetime_converted = "";
	StringBuffer sqlQuery		= new StringBuffer();
	String sub_pkg_chk="0";
	String bl_package_enabled_yn="N";
	
    try
    {
	    con		= ConnectionManager.getConnection(request);	

		String allowCancelAdm = checkForNull(request.getParameter("allowCancelAdmsn"),"N");//Added by Thamizh selvi on 20th Feb 2017 against MMS-QH-CRF-0182

		install_yn =(String)session.getValue("bl_operational");
		stmt	=	con.createStatement();
		if(rs != null)	rs.close();
		if(install_yn.equals("Y") )
		{
			/****************ADDED FOR PACKAGE BILLING**********************************************/	
		try{	
			PreparedStatement pstmt1=con.prepareStatement("select bl_package_enabled_yn(?) from dual");
			pstmt1.setString(1, facilityID);
			ResultSet rs2 = pstmt1.executeQuery();	
			if( rs2 != null ) 
			{
				if( rs2.next() )
				{			
					bl_package_enabled_yn  =  rs2.getString(1);	
				}
			}
			if(bl_package_enabled_yn == null) bl_package_enabled_yn="N";			
			pstmt1.close();
			if(rs2!=null) rs2.close();	
			if(bl_package_enabled_yn.equals("Y"))
			{
			String pat_pkg_sub_yn= " SELECT COUNT(*) FROM BL_PACKAGE_ENCOUNTER_DTLS WHERE ENCOUNTER_ID =? AND patient_id = ? AND PACKAGE_SEQ_NO IN (SELECT PACKAGE_SEQ_NO FROM BL_PACKAGE_SUB_HDR  WHERE patient_id = ? AND status = 'O')";
			if(rs!=null) rs.close();
/* 			if(stmt!=null) stmt.close();
			stmt	= con.createStatement(); */
			pstmt = con.prepareStatement(pat_pkg_sub_yn);
			pstmt.setString(1, episode_id);
			pstmt.setString(2, patientId);
			pstmt.setString(3, patientId);
			rs = pstmt.executeQuery();
			
/* 			rs=stmt.executeQuery(pat_pkg_sub_yn); */
			if(rs.next())
			{
				sub_pkg_chk = rs.getString(1);
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			//sub_pkg_chk="0";			
			if(sub_pkg_chk.equals("1"))
			{				
				bill_error = "BL8674";
			}
			}
}catch(Exception e){
				e.printStackTrace();
			}
/**************************ENDS PACKAGE BILLING*********************************************/
			sqlQuery.append("Select BL_IP_DETAILS.BL_CHECK_SERVICE_EXISTS(?, ");
			sqlQuery.append("?, 'I',?) p_service_charged_yn  from dual");
			
			pstmt	= 	con.prepareStatement(sqlQuery.toString());
			pstmt.setString(1, facilityID);
			pstmt.setString(2, patientId);
			pstmt.setString(3, encounterID);
			rs 		= 	pstmt.executeQuery();
			
/* 			stmt	=	con.createStatement();
			rs = stmt.executeQuery(sqlQuery.toString()); */
		
			if(rs.next())
			{
				 charged_service = checkForNull(rs.getString("p_service_charged_yn"));
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
				
			if(charged_service.equals("Y"))
			{
				bill_error = "BL9316";
			}
			else
			{
				if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
				sqlQuery.append("Select  BL_IP_DETAILS.BL_CHECK_UNPROCESSED_EXISTS (?, ?,'I',"+encounterID+")  P_UNPROCESSED_SERVICE_YN  from dual");
				pstmt = con.prepareStatement(sqlQuery.toString());
				pstmt.setString(1, facilityID);
				pstmt.setString(2, patientId);
				/* stmt	=	con.createStatement();
				rs = stmt.executeQuery(sqlQuery.toString()); */
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					unprocessed_service = checkForNull(rs.getString("P_UNPROCESSED_SERVICE_YN"));
				}
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(unprocessed_service.equals("Y"))
				{
					bill_error = "BL9317";
				}
				else
				{
					if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
					sqlQuery.append("Select  bl_ip_details.BL_CHECK_ADM_DEPOSIT_EXISTS(?, "+encounterID+")   P_ADM_DEPOSIT_YN  from dual");
					pstmt	= 	con.prepareStatement(sqlQuery.toString());
					pstmt.setString(1, facilityID);
					rs		= 	pstmt.executeQuery();
/* 					stmt	=	con.createStatement();
					rs = stmt.executeQuery(sqlQuery.toString()); */ 
					if(rs.next())
					{
						adm_deposit = checkForNull(rs.getString("P_ADM_DEPOSIT_YN"));
					}
				   if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(adm_deposit.equals("Y"))
					{
						bill_error = "BL9318";
					}
				}
			}
		}
		String cancel_allowed_yn ="";
		String Admmission = ""; 

		if(bill_error.equals(""))
		{
		/*Wednesday, May 26, 2010 , commented for PE Merged in main query*/
		/*
		if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append("select IP_ADMIN_CANCEL_ALLOWED_YN('"+facilityID+"',"+encounterID+",'"+patientId+"') from dual");
		stmt = con.createStatement();
		rs = stmt.executeQuery(sqlQuery.toString());
		if (rs!=null && rs.next())
			cancel_allowed_yn = rs.getString(1);
		if(rs!=null)rs.close(); 
		if(stmt!=null)stmt.close();
		int len	= cancel_allowed_yn.length();
		if(len	>= 2)
		{
			Admmission		 = cancel_allowed_yn.substring(2,len);
			cancel_allowed_yn= cancel_allowed_yn.substring(0,cancel_allowed_yn.indexOf("|"));
		}*/
//out.println("<script>alert(\""+cancel_allowed_yn+"\");</script>");
	try
	{
		if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
		sqlQuery.append("SELECT TO_CHAR(a.admission_date_time,  'dd/mm/rrrr HH24:mi')  admission_date_time,  b.sex gender,  a.encounter_id,  a.nursing_unit_code, IP_GET_DESC.IP_ADMISSION_TYPE(a.ADMISSION_TYPE,?,'2') admission_short_desc,  AM_GET_DESC.AM_SPECIALITY(a.specialty_code,?,'2') specialty_short_desc,  a.patient_class, AM_GET_DESC.AM_PRACTITIONER(a.ATTEND_PRACTITIONER_ID,?,'1') practitioner_name, NULL patient_type_short_desc, IP_GET_DESC.IP_NURSING_UNIT(a.FACILITY_ID, a.NURSING_UNIT_CODE,?,'2') nursing_unit_short_desc, AM_GET_DESC.AM_SERVICE(a.service_code,?,'2') service_short_desc, a.BED_NUM bed_no, a.blocked_bed_no, a.adt_status, A.ROOM_NUM room_no, A.ATTEND_PRACTITIONER_ID practitioner_id, IP_GET_DESC.IP_BED_TYPE(a.bed_type_code,?,'2') bed_type_short_desc, IP_GET_DESC.IP_BED_CLASS(a.bed_class_code,?,'2') bed_class_short_desc, a.team_id, am_get_desc.AM_MEDICAL_TEAM(a.FACILITY_ID,a.TEAM_ID,?,2) team_short_desc");
		/*Wednesday, May 26, 2010 , added for PE*/
		sqlQuery.append(",(select pat_check_in_allowed_yn from IP_PARAM where facility_id = a.facility_id) pat_check_in_allowed_yn ");
		sqlQuery.append(",IP_ADMIN_CANCEL_ALLOWED_YN(a.facility_id,a.encounter_id,a.patient_id)cancel_allowed_yn ");
		sqlQuery.append(" FROM IP_OPEN_ENCOUNTER a, MP_PATIENT b where a.facility_id = ? and a.encounter_id= ? and a.patient_id = b.patient_id");
    	/* stmt = con.createStatement();    
		rs=stmt.executeQuery(sqlQuery.toString()); */
		
		pstmt = con.prepareStatement(sqlQuery.toString());
		pstmt.setString(1, locale);
		pstmt.setString(2, locale);
		pstmt.setString(3, locale);
		pstmt.setString(4, locale);
		pstmt.setString(5, locale);
		pstmt.setString(6, locale);
		pstmt.setString(7, locale);
		pstmt.setString(8, locale);
		pstmt.setString(9, facilityID);
		pstmt.setString(10, encounterID);
		
		rs = pstmt.executeQuery();
		
		if(rs!=null && rs.next())
		{
			admissiondatetime   = checkForNull(rs.getString("admission_date_time"));
			if(!(admissiondatetime==null || admissiondatetime.equals("")))
				admissiondatetime_converted = DateUtils.convertDate(admissiondatetime,"DMYHM","en",locale);
			admissiontypedesc   = checkForNull(rs.getString("admission_short_desc"));      
			specialtyshortdesc  = checkForNull(rs.getString("specialty_short_desc"));   
			practitionername    = checkForNull(rs.getString("practitioner_name"));
			patienttype         = checkForNull(rs.getString("patient_type_short_desc"));
			nursingunitshortdesc= checkForNull(rs.getString("nursing_unit_short_desc"));   
			serviceshortdesc    = checkForNull(rs.getString("service_short_desc"));
			roomno				= checkForNull(rs.getString("room_no"));
			bedclassshortdesc   = checkForNull(rs.getString("bed_class_short_desc"));
			bedtypeshortdesc	= checkForNull(rs.getString("bed_type_short_desc"));
			gender				= checkForNull(rs.getString("gender"));   
			adt_status			= checkForNull(rs.getString("adt_status"));
			blocked_bed_no		= checkForNull(rs.getString("blocked_bed_no"));
			bedno				= checkForNull(rs.getString("bed_no"));
			patient_class		= checkForNull(rs.getString("patient_class"));
			encounterID			= checkForNull(rs.getString("encounter_id"));
			nursingunitcode     = checkForNull(rs.getString("nursing_unit_code"));
			practitionerid		= checkForNull(rs.getString("practitioner_id"));
            meddesc             = checkForNull(rs.getString("team_short_desc"));
            pat_check_yn        = checkForNull(rs.getString("pat_check_in_allowed_yn"),"N");
			cancel_allowed_yn	= checkForNull(rs.getString("cancel_allowed_yn"),"N");
			int len				= cancel_allowed_yn.length();
			if(len	>= 2)
			{
				Admmission		 = cancel_allowed_yn.substring(2,len);
				cancel_allowed_yn= cancel_allowed_yn.substring(0,cancel_allowed_yn.indexOf("|"));
			}
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
        if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
		}catch(Exception ex) {
			//out.println("error in cancel admission in main: "+ex.toString());
			ex.printStackTrace();
		}
			{
			}
		}
		//Wednesday, May 26, 2010 , modified for PE
		/*
		String pat_check_yn_Sql= " select pat_check_in_allowed_yn from IP_PARAM where facility_id = '"+facilityID+"' ";
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		stmt	= con.createStatement();
		rs=stmt.executeQuery(pat_check_yn_Sql);
		if(rs.next())
		{
			pat_check_yn = rs.getString("pat_check_in_allowed_yn");
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		*/


            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(admissiondatetime_converted));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(admissiondatetime));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(admissiontypedesc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(admissiontypedesc));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialtyshortdesc));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practitionername));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patienttype));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(meddesc));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(nursingunitshortdesc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(serviceshortdesc));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

		if(adt_status.equals("00") && pat_check_yn.equals("Y"))
		{
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(blocked_bed_no));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(blocked_bed_no));
            _bw.write(_wl_block32Bytes, _wl_block32);
	}
		else
		{
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bedno));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bedno));
            _bw.write(_wl_block34Bytes, _wl_block34);
} 
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(roomno));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(roomno));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bedclassshortdesc));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bedtypeshortdesc));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

			if(sqlQuery.length() > 0) sqlQuery.delete(0,sqlQuery.length());
			//sqlQuery.append("Select Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON_lang_vw where	language_id='"+locale+"' and Cancel_Admission_Yn = 'Y' and Eff_Status = 'E' order by 1");
			sqlQuery.append("Select am_get_desc.am_contact_reason(contact_reason_code,?,1)Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON where Cancel_Admission_Yn = 'Y' and Eff_Status = 'E' order by 1");
/* 			stmt	= con.createStatement();
			rs		= stmt.executeQuery(sqlQuery.toString()); */
			
			pstmt = con.prepareStatement(sqlQuery.toString());
			pstmt.setString(1, locale);
			rs = pstmt.executeQuery();
			
			if(rs != null)
			{
				while(rs.next())
				{
					String CDesc = rs.getString("Contact_Reason");
					String CCode = rs.getString("Contact_Reason_Code");
					out.println("<option value=\""+CCode+"\" >"+CDesc+"</option>");
				}			
			}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelAdmission.label","common_labels")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(cancel_disable));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(install_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(pat_check_yn));
            _bw.write(_wl_block53Bytes, _wl_block53);
if(install_yn.equals("Y")){
            _bw.write(_wl_block1Bytes, _wl_block1);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patientId
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block1Bytes, _wl_block1);
}
	/*Added by Thamizh selvi on 20th Feb 2017 against MMS-QH-CRF-0182 Start*/
	if(allowCancelAdm.equals("true"))
	{
		if(cancel_allowed_yn.equals("N"))
		{	
		
			if(Admmission.equals("IP_ADT_TRN")) 
			{
            _bw.write(_wl_block54Bytes, _wl_block54);
}
			else if( Admmission.equals("IP_TRANSFER_REQUEST") )
			{
            _bw.write(_wl_block55Bytes, _wl_block55);
}
			else if( Admmission.equals("IP_BED_CLASS_REQUEST") )
			{
            _bw.write(_wl_block56Bytes, _wl_block56);
}
			else if(Admmission.equals("OR_ORDER"))
			{
            _bw.write(_wl_block57Bytes, _wl_block57);
}
			else if(Admmission.equals("IP_DISCHARGE_ADVICE"))
			{
            _bw.write(_wl_block58Bytes, _wl_block58);
}
			else if(Admmission.equals("CA_ENCNTR_DISCR_MSR"))
			{
            _bw.write(_wl_block59Bytes, _wl_block59);
}
			else if(Admmission.equals("CA_ENCNTR_NOTE"))
			{
            _bw.write(_wl_block60Bytes, _wl_block60);
}
		}
		else if(!(cancel_allowed_yn.equals("Y")))
			{	
				if(!bill_error.equals(""))
				{
			
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bill_error));
            _bw.write(_wl_block62Bytes, _wl_block62);
	}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(cancel_allowed_yn));
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
	} 
	}/*End*/
	else{
		if(cancel_allowed_yn.equals("N"))
		{
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(Admmission));
            _bw.write(_wl_block67Bytes, _wl_block67);
}
		else if(!(cancel_allowed_yn.equals("Y")))
			{	
				if(!bill_error.equals("")) //modified on 25/08/2008 for SCR 5175 
				{
			
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bill_error));
            _bw.write(_wl_block62Bytes, _wl_block62);
	}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(cancel_allowed_yn));
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
	} 
	}

		if (rs != null) rs.close();
        if (stmt != null) stmt.close();

}catch(Exception e) {
	//out.println("error in cancel admission in main: "+e.toString());
	e.printStackTrace();}
    finally
    {
        ConnectionManager.returnConnection(con,request); 
    }

            _bw.write(_wl_block68Bytes, _wl_block68);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelAdmission.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.processing.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiontype.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patienttype.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NursingUnitDetails.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforCancellation.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }
}
