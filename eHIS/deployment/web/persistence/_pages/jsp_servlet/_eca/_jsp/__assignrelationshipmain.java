package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __assignrelationshipmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/AssignRelationshipMain.jsp", 1742377313980L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/AssignRelationship.js\'></script>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n</head>\n<body class=\'CONTENT\' OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\'makeInvisible()\'>\n <br><br>\n\t<center>\n\t<form name=\'AssignRelationshipForm\' id=\'AssignRelationshipForm\' method=\'POST\' action=\'../../servlet/eCA.AssignRelationshipServlet\' target=\'\'>\n\t<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'95%\' align=\'center\' height=\'60%\'>\n\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\n\t\t<tr id=\'tempCheckList\'>\n\t\t\t<td  class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'checkbox\' name=\'chkLimitPractList\' id=\'chkLimitPractList\'></td>\n\t\t\t<td colspan=2></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\n\t\t\t<td class=\'fields\' width=\'25%\'><select name=\'clinician_type\' id=\'clinician_type\' \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t\t<option value=\'\'>&nbsp;&nbsp;&nbsp;---- ---- ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="---- ----&nbsp;&nbsp;&nbsp;</option>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t\t<!--<script>document.forms[0].clinician_type.value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\';</script> -->\n\t\t\t<td class=\'LABEL\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t\t\t<input type=\'text\' name=\'clinician_name\' id=\'clinician_name\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' size=20 \'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' onblur=\'get_name(this)\'><input type=\"button\" class=\'Button\' name=\"clinician_name_button\" id=\"clinician_name_button\" title=\'search_code\' value=\"?\" onClick=\'get_name(this)\' \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><select name=\'relationship\' id=\'relationship\' onChange=\'return checkOnBlurRelationship(this);\'>\n\t\t\t\t<!-- option value set as \'\' IN051373-->\n\t\t\t\t<option value=\'\'>&nbsp;&nbsp;&nbsp;---- ---- ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="---- ----&nbsp;&nbsp;&nbsp;</option>\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t\t<td class=\'LABEL\'  >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'checkbox\' disabled name=\'expiry_based_yn\' id=\'expiry_based_yn\' value=\'Y\'></td>\n\t\t\t</tr><tr>\n\t\t\t<td class=\'LABEL\'  width=\'25%\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'expiry_rule\' id=\'expiry_rule\' readOnly value=\'\' size=20></td>\n\t\t\t<td colspan=4></td>\n\t\t</tr>\n\t<!-- ReasonCode Start --><!--  605.5 -->\n\t\t<tr style=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><select name=\'reason\' id=\'reason\' onChange=\'return setReasonText(this)\'>\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<option value=\'\'>&nbsp;&nbsp;&nbsp;---- ---- ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t</select><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n\n\t\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><TEXTAREA NAME=\"reasonText\" ROWS=\"3\" COLS=\"40\" onBlur = \"return makeValidString(this)\" onKeyPress=\"return CheckMaxLength(this,200)\" readonly></TEXTAREA></td>\n\t\t</tr>\n\t<!-- ReasonCode End --><!--  605.5 -->\n\t\t<tr>\n\t\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'start_date\' id=\'start_date\'  readOnly value=\'\' size=14 maxlength=14></td>\n\t\t\t<td class=\'LABEL\' width=\'25%\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'end_date\' id=\'end_date\'  readOnly value=\'\' size=14  maxlength=14></td>\n\t\t</tr><tr id=\'tdTerminate\'>\n\t\t\t<td class=\'LABEL\' width=\'25%\' >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t<td class=\'fields\' id=\'\'><input type=\'checkbox\' name=\'chkTerminate\' id=\'chkTerminate\' value=\'N\' onClick=\'return funTerminateReln()\' ></td>\t\n\t\t\t<td class=\'LABEL\' id=\'tempRelation\' ></td>\n\t\t\t<td colspan=4></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td colspan=4 align=right>\n\t\t\t<input type=\'button\' class=\'BUTTON\' name=\'record\' id=\'record\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' onClick = \'return checkOnSubAssignRelationship();\'>\n\t\t\t<input type=\'button\' class=\'BUTTON\' name=\'cancel\' id=\'cancel\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'  onClick=\'return callOnCancel();\'>\n\t\t\t<input type=\'reset\' class=\'BUTTON\' name=\'clear\' id=\'clear\' \'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' onClick = \'return callClear();\' >\n\t\t\t</td>\n\t\t</tr>\n\n\t</table>\n\t\t<input type=\'hidden\' name=\'clinician_id\' id=\'clinician_id\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t\t<input type=\'hidden\' name=\'pline\' id=\'pline\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t\t<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t\t<input type=\'hidden\' name=\'act_clinician_type\' id=\'act_clinician_type\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'act_clinician_id\' id=\'act_clinician_id\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t<input type=\'hidden\' name=\'phys_prov_id\' id=\'phys_prov_id\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t<input type=\'hidden\' name=\'phys_prov_reln_id\' id=\'phys_prov_reln_id\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t\t<input type=\'hidden\' name=\'resp_id\' id=\'resp_id\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t\t<input type=\'hidden\' name=\'all_all\' id=\'all_all\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t\t<input type=\'hidden\' name=\'all_enc\' id=\'all_enc\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n\t\t<input type=\'hidden\' name=\'self_all\' id=\'self_all\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n\t\t<input type=\'hidden\' name=\'self_enc\' id=\'self_enc\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t<input type=\'hidden\' name=\'my_all\' id=\'my_all\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t\t<input type=\'hidden\' name=\'my_enc\' id=\'my_enc\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t<input type=\'hidden\' name=\'whereClause\' id=\'whereClause\' value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t<input type=\'hidden\' name=\'boundCount\' id=\'boundCount\' value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t<input type=\'hidden\' name=\'modal_yn\' id=\'modal_yn\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n\t\t<input type=\'hidden\' name=\'hyperLinkStartDate\' id=\'hyperLinkStartDate\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'hyperLinkEndDate\' id=\'hyperLinkEndDate\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'currentDateTime\' id=\'currentDateTime\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'tempEndDate\' id=\'tempEndDate\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'added_date\' id=\'added_date\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'terminate\' id=\'terminate\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'location_code\' id=\'location_code\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t<input type=\'hidden\' name=\'fromOpenChart_yn\' id=\'fromOpenChart_yn\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n\t\t<input type=\'hidden\' name=\'pat_discharged_yn\' id=\'pat_discharged_yn\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'><!-- IN051373 -->\n\t\t<input type=\'hidden\' name=\'act_reason_short_desc\' id=\'act_reason_short_desc\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'reason_text\' id=\'reason_text\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'remarks_relationships_yn\' id=\'remarks_relationships_yn\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n\t\t\n\t</form>\n\t</center>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

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

/* 
--------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	?				?				created
01/10/2014    IN051373		Chowminya      									Patient List By PPR Relationship Issue 	
---------------------------------------------------------------------------------------------------------------
*/

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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");

		Connection			con		=	null;
		PreparedStatement	pstmt	=	null;
		ResultSet			rs		=	null;

		String patient_id = "";
		//String sex="";
		String episode_type = "",location_code="";
		String episode_id = "", visit_id = "", resp_id = "", phys_prov_reln_id = "",phys_prov_reln="";
		String all_all = "", all_enc = "", self_all = "", self_enc = "", my_all = "", my_enc = "";
		String clinician_type = "";
		String reln_rule="";//IN051373
		//String physician_id = "";
		//String clinician_id_prop = "", 
		String login_user_id = ""; 
		//query_clinician_details  = "";
		String query_applicable_tasks = "", clinician_id = "";
		String phys_prov_reln_name = "", phys_prov_id = "";
		String clinician_prop = "",modal_yn="",patient_class="",clinician_value="";
		String pract_type = "";
		String facility_id = "";
		String fromOpenChart_yn = "";
		String pract_name = "";
		String current_relationship_id = "";
		String speciality_code = "";
		String reason_Short_Desc="";
		String reason="";
		String reasonText="";
		String Flag="display : none; ";
		String remarks_relationships_yn ="";

		int	boundCount = 0;
		MessageManager mm = null; 
		java.util.Hashtable message = null;
		PreparedStatement psPract=null;
		ResultSet	rsPract = null;
		//IN051373 - Start
		PreparedStatement psPractRule = null;
		ResultSet rsPractRule = null;
		String pat_discharged_yn = "N"; 
		//IN051373 - End
		Connection	conReason	=	null;
		PreparedStatement psReason  = null;
		ResultSet rsReason = null;
		StringBuffer whereClause = new StringBuffer();


		try
		{
			con = ConnectionManager.getConnection(request);
			conReason = ConnectionManager.getConnection(request);
			login_user_id		=	(String) session.getValue("login_user");
			mm					=	new MessageManager();
			resp_id				=	(String)session.getValue("responsibility_id");
			
			clinician_id		=	(String)session.getValue("ca_practitioner_id");
			facility_id			=	(String)session.getValue("facility_id");
			clinician_type		= (String)session.getValue("practitioner_type");
			pract_type			= 	(String)session.getValue("practitioner_type");
			pract_name			= 	(String)session.getValue("practitioner_name");
			
			
			//String sqlPract="select pract_type, DESC_USERDEF   from am_pract_Type order by DESC_USERDEF ";
			String sqlPract = "select pract_type,  DESC_USERDEF   from am_pract_Type_lang_Vw where language_id= ?  order by DESC_USERDEF";
			psPract = con.prepareStatement(sqlPract);
			psPract.setString(1,locale);
			rsPract = psPract.executeQuery();

			patient_id			=	request.getParameter("patient_id");
			episode_type		=	request.getParameter("episode_type");
			episode_id			=	request.getParameter("episode_id");
			visit_id			=	request.getParameter("visit_id");
			phys_prov_id		=	request.getParameter("phys_prov_id");
			location_code		=	request.getParameter("location_code");
			fromOpenChart_yn		=	request.getParameter("fromOpenChart_yn");
			current_relationship_id		=	request.getParameter("relationship_id");
			speciality_code		=	request.getParameter("speciality_code");

			if (fromOpenChart_yn==null) fromOpenChart_yn="N";
			if ((phys_prov_id==null) ||(phys_prov_id.equals("") ))
					phys_prov_id		=	clinician_id ;
			modal_yn			= request.getParameter("modal_yn")==null?"N":request.getParameter("modal_yn");

			if(location_code==null)		location_code		=	"";
			if(episode_id==null)		episode_id			=	"";
			if(visit_id==null)			visit_id			=	"";
			if(resp_id==null)			resp_id				=	"";
			if(phys_prov_id==null)		phys_prov_id		=	"";
			if(clinician_type==null)	clinician_type		=	"";
			if(clinician_id==null)		clinician_id		=	"";
			if(login_user_id==null)		login_user_id		=	"";
			if(speciality_code==null)		speciality_code		=	"";
			if(current_relationship_id==null)		current_relationship_id		=	"";
			
			patient_class=request.getParameter("patient_class") == null?"":request.getParameter("patient_class");

			whereClause = new StringBuffer();

			if( modal_yn.equals("Y") )
			{
				clinician_prop = " disabled ";
				clinician_value = pract_name;
			}
		
			
			/* commended by Rajan/Shaiju on 03/05/2007 as it is not used anywhere
			String query_patient_encounter_details="select A.patient_id    , b.sex   , GET_AGE(b.date_of_birth, NVL(b.deceased_date,SYSDATE)) age     , a.ATTEND_PRACTITIONER_ID  physician_id     , AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,'2') physician_name     ,to_char(VISIT_ADM_DATE_TIME    ,'dd/mm/yyyy HH24:MI:SS') visit_adm_date_time     ,ASSIGN_CARE_LOCN_CODE||decode(ASSIGN_ROOM_NUM,null,null,', room no:'||ASSIGN_ROOM_NUM)|| decode(assign_bed_num,null,null,', bed no:'||assign_bed_num) locn_name,    decode(a.patient_class,'OP','O','EM','O','I')from pr_encounter a, mp_patient b where a.facility_id=?   and a.encounter_id=?   and b.patient_id=a.patient_id ";

			pstmt		=	con.prepareStatement(query_patient_encounter_details);

			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,episode_id);
			
			rs	=	pstmt.executeQuery();

			
			try
			{
				if(rs.next())
				{
					patient_id			=	rs.getString("patient_id");
					sex=rs.getString("sex");
					physician_id		=	rs.getString("physician_id");
					//episode_type		=	rs.getString("episode_type");
				}
			
				if(sex.equals("M"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				if(sex.equals("F"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				if (rs!=null) rs.close();
			if (pstmt!=null) pstmt.close();

				*/

			try
			{
				//IN051373 - Start
				String sqlPractRule = "Select DISCHARGE_DATE_TIME from pr_encounter b where PATIENT_ID = ?  and encounter_id=? ";
				psPractRule = con.prepareStatement(sqlPractRule);
				psPractRule.setString(1,patient_id);
				psPractRule.setString(2,episode_id);
				rsPractRule = psPractRule.executeQuery();
				if(rsPractRule.next())
				{
					String dis_date = rsPractRule.getString("DISCHARGE_DATE_TIME");
					if(dis_date !=null && (current_relationship_id.equals("")))
					{
						pat_discharged_yn = "Y";
					}
				}
				//IN051373 - End
				query_applicable_tasks = " select GET_TASK_APPLICABILITY('EST_RELN_ALL_LFT',null,?,?) all_all, GET_TASK_APPLICABILITY('EST_RELN_ALL_ENC',null,?,?) all_enc, GET_TASK_APPLICABILITY('EST_RELN_SELF_LFT',null,?,?) self_all,  GET_TASK_APPLICABILITY('EST_RELN_SELF_ENC',null,?,?) self_enc, GET_TASK_APPLICABILITY('EST_RELN_MYPAT_LFT',null,?,?) my_all, GET_TASK_APPLICABILITY('EST_RELN_MYPAT_ENC',null,?,?) my_enc from dual ";
					
				pstmt = con.prepareStatement(query_applicable_tasks);
				pstmt.setString(1, resp_id);
				pstmt.setString(2, current_relationship_id);
				pstmt.setString(3, resp_id);
				pstmt.setString(4, current_relationship_id);	
				pstmt.setString(5, resp_id);
				pstmt.setString(6, current_relationship_id);
				pstmt.setString(7, resp_id);
				pstmt.setString(8, current_relationship_id);
				pstmt.setString(9, resp_id);
				pstmt.setString(10, current_relationship_id);
				pstmt.setString(11, resp_id);
				pstmt.setString(12, current_relationship_id);
				
				rs	=	pstmt.executeQuery();

				if(rs.next())
				{
					all_enc = "";
					all_all		=	rs.getString("all_all");
					all_enc		=	rs.getString("all_enc");
					self_all	=	rs.getString("self_all");
					self_enc	=	rs.getString("self_enc");
					my_all		=	rs.getString("my_all");
					my_enc		=	rs.getString("my_enc");
				

					if(all_all==null)	all_all		=	"";
					if(all_enc==null)	all_enc		=	"";
					if(self_all==null)	self_all	=	"";
					if(self_enc==null)	self_enc	=	"";
					if(my_all==null)	my_all		=	"";
					if(all_all==null)	my_enc		=	"";
				}

				if(phys_prov_id.equals(clinician_id))
				{
					if(my_all.equals("A")) all_all = "A";
					if(my_enc.equals("A")) all_enc = "A";
				}
			}
			catch(Exception e)
			{
				e.printStackTrace() ;				
			}

			if(all_all.equals("A"))   // if EST_RELN_ALL_LFT (all_all) is Y 
			{
				if(episode_id.equals("")) // if episode ID is not null then No restrictuin else then following condition
				{
					whereClause.append(" and lifetime_or_encntr = 'L' ");
				}
			}
			else   // if EST_RELN_ALL_LFT (all_all) is N
			{
				if(all_enc.equals("A")) // if EST_RELN_ALL_ENC is Y
				{
					if(self_all.equals("A"))  // if EST_RELN_SELF_LFT is Y
					{
						if(!(episode_id.equals("")))
						{						
							whereClause.append(" and ( ( ? != ? and lifetime_or_encntr = 'E' ) or ? = ? ) ");
							boundCount = 4;
						}
						else
						{
							whereClause.append(" and ( ? = ? and lifetime_or_encntr = 'L' ) ");
							boundCount = 2;
							clinician_prop = " DISABLED ";
						}
					}
					else   // if EST_RELN_ALL_ENC is N
					{
						if(!(episode_id.equals("")))
						{
							whereClause.append(" and ( lifetime_or_encntr = 'E' ) ");
						}
						else
						{
							out.println("<script>alert(getMessage('RELN_REQ_ENC_ID','CA'));parent.window.close()</script>");
						}
					}
				}
				else   //  // if EST_RELN_ALL_ENC is N
				{
					if(self_all.equals("A"))
					{
						if(episode_id.equals(""))
						{
							whereClause.append(" and ( lifetime_or_encntr = 'L' ) ");
						}
					}
					else
					{
						if(self_enc.equals("A"))
						{
							if(!(episode_id.equals("")))
							{
								whereClause.append(" and ( lifetime_or_encntr = 'E' ) ");
							}
							else
							{
								//message = mm.getMessage( con, "RELN_REQ_ENC_ID" ) ;
								out.println("<script>alert(getMessage('RELN_REQ_ENC_ID','CA'));parent.window.close()</script>");
								//throw new Exception ((String) message.get("message"));
							}
						}
						else
						{
							//message = mm.getMessage( con, "RELN_NOT_ELGIBLE" ) ;							
							//out.println("<script>alert('RELN_NOT_ELGIBLE','CA');parent.window.close()</script>");
							out.println("<script>alert(getMessage('RELN_NOT_ELGIBLE','CA'));parent.window.close()</script>");
							
							
							
							//throw new Exception ((String) message.get("message"));
						} // end of else
					} // end of else
					clinician_prop = " DISABLED ";
				} // end of else
			} // end of else

			if(message!=null)message.clear();
		} // end of try
		catch(Exception e)
		{

			e.printStackTrace() ;
			if(modal_yn.equals("Y"))
			{
				//out.println("<script>parent.window.close();");
				//out.println("</script>");
			}
			else
			{
				//out.println("<script>alert('"+e.getMessage()+"');");//COMMON-ICN-0181
				out.println("top.secondframe.thirdframe.location.href='../../eCommon/html/blank.html';//document.location.href='../../eCommon/html/blank.html';</script>");
				//out.println(e.getMessage());//common-icn-0181				
			}
		}
		//ReasonCode 
		
		try{
			
			String sqlPractRule ="SELECT  REMARKS_RELATIONSHIPS_YN FROM ca_encntr_param";
			psPractRule = con.prepareStatement(sqlPractRule);
			rsPractRule = psPractRule.executeQuery();
			if(rsPractRule.next())
			{  
				remarks_relationships_yn = rsPractRule.getString("REMARKS_RELATIONSHIPS_YN");
					if(remarks_relationships_yn.equalsIgnoreCase("Y") && (episode_id.equals(""))){
					 Flag="";
				}else{
					 Flag="display : none; ";
				}
			}		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		//ReasonCode
		finally{
			try{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}catch(Exception ex){
				ex.printStackTrace() ;
			}
		}
		
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(clinician_prop));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

				String PType = "";
				String selOpt = "";
				while(rsPract.next())
				{
					PType = rsPract.getString(1);
					if(clinician_type.equals(PType))
						selOpt = "selected";
					
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rsPract.getString(1)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(selOpt));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rsPract.getString(2)));
            _bw.write(_wl_block17Bytes, _wl_block17);
	
					selOpt = "";
					}
			
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(clinician_value));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(clinician_prop));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinician_prop));
            _bw.write(_wl_block24Bytes, _wl_block24);

				try
				{
					if(rsPract!=null) rsPract.close();
					if(psPract!=null) psPract.close();
				}
				catch(Exception e)
				{
					e.printStackTrace() ;
				}
			
			
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

				try
				{
						
				 if (modal_yn.equals("Y"))
				 {
						String query_relationship_details ="select PRACT_RELN_ID phys_prov_reln_id, PRACT_RELN_NAME pract_name,LIFETIME_OR_ENCNTR phys_prov_reln_name,EXPIRY_RULE rule from ca_pract_reln_lang_vw O where LANGUAGE_ID   =? and direct_yn='Y' and EFF_STATUS='E' and exists (select 1 from ca_pract_reln_for_resp a, sm_resp_for_user b where b.appl_user_id =  ? and a.resp_id =? and pract_reln_id= O.pract_reln_id and a.resp_id = b.resp_id and CAN_ASSIGN_YN='Y') 	and exists (select 1 from ca_pract_reln_for_resp a, sm_resp_for_user b, sm_appl_user c where c.FUNC_ROLE_ID = ? and pract_reln_id= O.pract_reln_id and c.APPL_USER_ID=b.appl_user_id and a.resp_id = b.resp_id and CAN_HOLD_YN='Y' ) "+whereClause.toString()+" order by phys_prov_reln_name "; //IN051373 included rule
					
					pstmt		=	con.prepareStatement(query_relationship_details);					
					pstmt.setString(1,locale);
					pstmt.setString(2,login_user_id);
					pstmt.setString(3,resp_id);
					pstmt.setString(4,phys_prov_id);
							
					if(boundCount==2)
					{
						pstmt.setString(4,phys_prov_id);
						pstmt.setString(5,clinician_id);

					}
					else if(boundCount==4)
					{
						pstmt.setString(4,phys_prov_id);
						pstmt.setString(5,clinician_id);
						pstmt.setString(6,phys_prov_id);
						pstmt.setString(7,clinician_id);

					
					}
					rs	=	pstmt.executeQuery();

					while(rs.next())
					{
						phys_prov_reln_id	=	rs.getString("phys_prov_reln_id");
						phys_prov_reln		=	rs.getString("phys_prov_reln_name");
						pract_name			=	rs.getString("pract_name");
						//IN051373 - Start
						reln_rule			=	rs.getString("rule");
						if(reln_rule==null)
							reln_rule = "";	
						phys_prov_reln_id = phys_prov_reln_id+"~"+reln_rule;
						//IN051373 - End
						if(phys_prov_reln.equals("E"))
							phys_prov_reln_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
			
						else if(phys_prov_reln.equals("L"))
							phys_prov_reln_name=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.LifeTime.label","ca_labels");
						phys_prov_reln_name=pract_name+"/"+phys_prov_reln_name;

				
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(phys_prov_reln_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(phys_prov_reln_name));
            _bw.write(_wl_block30Bytes, _wl_block30);

					
					}

				
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				 }
				}
				catch(Exception e)
				{
					e.printStackTrace() ;
				}
				finally
				{
					
					if(con!=null) ConnectionManager.returnConnection(con,request);
				}
				
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(Flag ));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

			try{
				 String sqlReasonTxt = "select Reason_Desc, Reason_text from CA_REASON_CODE where eff_status='E' ";
				 psReason = conReason.prepareStatement(sqlReasonTxt);
				 rsReason = psReason.executeQuery();
					while(rsReason.next())
					{
						reason= rsReason.getString("Reason_Desc");
						reasonText=rsReason.getString("Reason_text");
						
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(reasonText));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block38Bytes, _wl_block38);
					
						}
					
			}
			catch(Exception e){
				e.printStackTrace();
			}finally{
				rsReason.close();
				psReason.close();
				conReason.close();
			}
			
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(clinician_prop));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(clinician_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(request.getParameter("pline")));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(phys_prov_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(phys_prov_reln_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(all_all));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(all_enc));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(self_all));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(self_enc));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(my_all));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(my_enc));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(whereClause.toString()));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(boundCount));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(modal_yn));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(fromOpenChart_yn));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(pat_discharged_yn));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(remarks_relationships_yn));
            _bw.write(_wl_block73Bytes, _wl_block73);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AssignPatientRelationship.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.LimitPractitionerListtoAccessLocation.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitionertype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ExpiryBased.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.rule.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Reason.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ReasonText.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startdatetime.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddatetime.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.TerminateRelation.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
