package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __aetriagedetailsresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AETriageDetailsResult.jsp", 1709113865553L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Added/Modified By Nanda 11/8/2002 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n  <script language=\'javascript\' src=\'../../eAE/js/AETriageDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n  <Script>\n  function setFocus()\n  {\n\t     if(document.forms[0].nurse.disabled==false) \n\t\t  { \n\t\t\t  document.forms[0].nurse.focus(); \n\t\t  }\n  }\n  function checkMaxSize(Obj)\n\t\t\t{\n\t\t\t\tif(Obj.value.length > 60)\n\t\t\t\t{\n\t\t\t\t\tvar error = getMessage(\"REMARKS_CANNOT_EXCEED\",\'Common\');\n\t\t\t\t\terror = error.replace(\"$\",\"Complaint\");\n\t\t\t\t\terror = error.replace(\"#\",\"60\");\n\t\t\t\t\talert(error)\n\t\t\t\t\tObj.focus();\n\t\t\t\t}\n\t\t\t}\n</script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t <body OnMouseDown=\'CodeArrest()\' onLoad=\'setFocus();\' onSelect=\"codeArrestThruSelect()\" onKeyDown = \'lockKey()\' >\n\t <form name=\"ae_triage_details_result_form\" id=\"ae_triage_details_result_form\"  action=\"../../servlet/eAE.AETriageDetailsServlet\"  method=\"post\" target=\"messageframe\">\n<br>\n   <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" align=\'left\' width=\'90%\'>\n\t <tr>\n\t\t <th align=\'left\' colspan=\'6\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n     </tr>\n     <tr>\n\t          <td class=\'label\' width=\'5%\'>&nbsp;</td>\n\t\t\t  <td class=\'LABEL\' align=\'RIGHT\' width=\'15%\' nowrap>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n  \t\t      <td class=\'QUERYDATA\' align=\'left\' width=\'30%\'>&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n              </td>\n\t\t\t  <td class=\'LABEL\' align=\'RIGHT\' width=\'15%\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n              </td>\n\t          <td class=\'label\' width=\'5%\'>&nbsp;</td>\n\t </tr>\n\t<tr> \n\t\t <td align=\'left\' colspan=\'6\'>&nbsp;</td>\n    </tr>\n\t<tr>\n\t\t\t  <td class=\'label\' width=\'5%\'>&nbsp;</td>\n  \t\t      <td class=\'LABEL\' align=\'right\' width=\'20%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t  <td class=\'LABEL\' align=\'left\' width=\'25%\'>&nbsp;<select name=\'nurse\' id=\'nurse\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n\t\t\t\t\t<option value=\'\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n                   </select>\n              </td>\n\t\t\t  <td class=\'LABEL\' align=\'RIGHT\' width=\'20%\'>&nbsp;</td>\n  \t\t      <td class=\'LABEL\' align=\'left\' width=\'25%\'>&nbsp;\n\t\n\t\t\t\t\n              </td>\n  \t\t      <td class=\'LABEL\' align=\'RIGHT\' width=\'5%\'>&nbsp;</td>\n\t</tr>\n<tr> \n\t\t <td align=\'left\' colspan=\'6\'>&nbsp;</td>\n    </tr>\n\t<tr> \n\t      <td class=\'label\' width=\'5%\'>&nbsp;</td>\n\t\t  <td class=\'LABEL\' align=\'RIGHT\' width=\'20%\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t  <td class=\'LABEL\' align=\'left\' width=\'25%\' colspan=2>&nbsp;<input readonly type=text name=physician_desc value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" size=30 maxlength=30><input type=hidden name=physician value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"><input type=button class=button name=phy_button onClick=\"TriagepopulatePractitioners()\" value=\'?\' ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">\n\t\t <td class=\'LABEL\' align=\'RIGHT\' width=\'5%\' colspan=3>&nbsp;</td>\n\n\t</tr>\n\n\t<tr> \n\t\t <td align=\'left\' colspan=\'6\'>&nbsp;</td>\n    </tr>\n\t<tr>\t\n\t\t      <td class=\'label\' width=\'5%\'>&nbsp;</td>\n\t\t      <td class=\'LABEL\' align=\'RIGHT\' width=\'15%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t      <td class=\'LABEL\' align=\'left\' width=\'25%\' colspan=\'3\'>&nbsp;<input type=\'text\'  name=\"start_date_time\" id=\"start_date_time\"  value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" maxLength=\'16\' size=\'16\' onBlur=\'checkTiming(this);\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =">\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n              </td>\n\t\t\t <td class=\'LABEL\' align=\'RIGHT\' width=\'5%\'>&nbsp;</td>\n     </tr>\n\t<tr> \n\t\t <td align=\'left\' colspan=\'6\'>&nbsp;</td>\n    </tr>\n    <tr>\n\t\t\t <td class=\'LABEL\' align=\'RIGHT\' width=\'5%\'>&nbsp;</td>\n  \t\t      <td class=\'LABEL\' align=\'right\' width=\'20%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t\t  <td class=\'LABEL\' align=\'left\' width=\'25%\' colspan=\'3\'>&nbsp;<!-- <input type=\'text\'  name=\"complaint\" id=\"complaint\"  value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" maxLength=\'60\' size=\'60\'  ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" onBlur=\"makeValidString(this)\"> --><textarea name=\"complaint\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" rows=\'2\' cols=\'40\' onKeyPress=\'checkMaxLimit(this,60);\' onBlur=\'makeValidString(this);checkMaxSize(this);\' onkeypress=\'checkMaxLimit(this,60)\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</textarea>\n              </td>\n\t\t\t  <td class=\'LABEL\' align=\'RIGHT\' width=\'5%\'>&nbsp;</td>\n\t </tr>\n\t<tr> \n\t\t <td align=\'left\' colspan=\'6\'>&nbsp;</td>\n    </tr>\n\t<tr> \n\t\t <td align=\'left\' colspan=\'6\'>&nbsp;</td>\n    </tr>\n\t<tr>\t\n\t\t      <td class=\'label\' width=\'5%\'>&nbsp;</td>\n\t\t      <td class=\'LABEL\' align=\'RIGHT\' width=\'15%\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n  \t\t      <td class=\'LABEL\' align=\'left\' width=\'25%\' colspan=\'3\'>&nbsp;<input type=\'text\'  name=\"end_date_time\" id=\"end_date_time\"  value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" maxLength=\'16\' size=\'16\' onBlur=\'checkEndTiming(this);\' ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =">\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n              </td>\n\t\t\t <td class=\'LABEL\' align=\'RIGHT\' width=\'5%\'>&nbsp;</td>\n    </tr>\n\t<tr> \n\t\t <td align=\'left\' colspan=\'6\'>&nbsp;</td>\n    </tr>\n\t<tr>\t\n\t\t      <td class=\'label\' width=\'5%\'>&nbsp;</td>\n\t\t      <td class=\'LABEL\' align=\'RIGHT\' width=\'20%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n  \t\t      <td class=\'LABEL\' align=\'left\' width=\'25%\'>&nbsp;<select name=\'priority\' id=\'priority\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =">\n\t\t\t\t   <option value=\'\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n                 </select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img>\n                \n              </td>\n  \t\t      <td class=\'LABEL\' align=\'RIGHT\' width=\'5%\' colspan=\'3\'>&nbsp;</td>\n\t</tr>\n\t\n   \t<tr> \n\t\t    <td colspan=\'4\' colspan=\'4\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t    <td width=\'auto\' align=\'right\' colspan=\'2\'>\n   \t\t        <input type=\"button\" class=button name=\'recording\' id=\'recording\' value=\'Record\' title=\'Record\' onClick=\'recordTriageResult();\' ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" ><input type=\"button\" class=button name=\'Reseting\' id=\'Reseting\' value=\'Reset\' title=\'Reset\' onClick=\'resetingTriageResult();\'></input><input type=\"button\" class=button name=\'close\' id=\'close\' value=\'Close\' title=\'Close\' onClick=\'parent.parent.window.close();\'></input>\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t<td width=\'auto\' align=\'right\' colspan=\'2\'>\n   \t\t        <input type=\"button\" class=button name=\'recording\' id=\'recording\' value=\'Record\' title=\'Record\' onClick=\'recordTriageResult();\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" ><input type=\"button\" class=button name=\'Reseting\' id=\'Reseting\' value=\'Reset\' title=\'Reset\' onClick=\'resetingTriageResult();\'></input>\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t</tr>\n\t\t</table>\n\t\t\t<input type=\'hidden\' name=\'hdnCA\' id=\'hdnCA\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n          <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t  <input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t  <input type=\'hidden\' name=\'queue_status\' id=\'queue_status\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t  <input type=\'hidden\' name=\'location_code\' id=\'location_code\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t  <input type=\'hidden\' name=\'orig_tmt_area_code\' id=\'orig_tmt_area_code\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t\n\t\t\t\t\n  \t\t  <input type=\'hidden\' name=\'treatment_area_code\' id=\'treatment_area_code\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n  \t\t  <input type=\'hidden\' name=\'treatment_area_desc\' id=\'treatment_area_desc\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n  \t\t  <input type=\'hidden\' name=\'clinic_desc\' id=\'clinic_desc\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t  <input type=\'hidden\' name=\'queryString\' id=\'queryString\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t      <input type=\'hidden\' name=\'visit_adm_date_time\' id=\'visit_adm_date_time\' value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t      <input type=\'hidden\' name=\'visit_adm_date\' id=\'visit_adm_date\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\n \t\t  <input type=\'hidden\' name=\'nurse_val\' id=\'nurse_val\' value=\'\'>\n\t\t  <input type=\'hidden\' name=\'physician_val\' id=\'physician_val\' value=\'\'>\n\t\t  <input type=\'hidden\' name=\'start_date_time_val\' id=\'start_date_time_val\' value=\'\'>\n\t\t  <input type=\'hidden\' name=\'complaint_val\' id=\'complaint_val\' value=\'\'>\n\t  \t  <input type=\'hidden\' name=\'duration_val\' id=\'duration_val\' value=\'\'>\n\t  \t  <input type=\'hidden\' name=\'end_date_time_val\' id=\'end_date_time_val\' value=\'\'>\n\t  \t  <input type=\'hidden\' name=\'priority_ind\' id=\'priority_ind\' value=\'\'>\n\t  \t  <input type=\'hidden\' name=\'priority_val\' id=\'priority_val\' value=\'\'>\n\t\t  <input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t\t  <input type=\'hidden\' name=\'open_to_all_pract_yn\' id=\'open_to_all_pract_yn\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t  <input type=\'hidden\' name=\'open_to_all_prac_for_clinic_yn\' id=\'open_to_all_prac_for_clinic_yn\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n\t\t  <input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t  <input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n\t    ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n<!-- \t\t   <input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n -->\t \n\t\t   <input type=\'hidden\' name=\'sysdate\' id=\'sysdate\' value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\n\t</form>\n\t </body>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n</html>\n\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

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
 request= new XSSRequestWrapper(request);
 response.addHeader("X-XSS-Protection", "1; mode=block");
 response.addHeader("X-Content-Type-Options", "nosniff");
 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

        Connection con						= null;
    	PreparedStatement pstmt				= null;
        ResultSet rset						= null ;
		Statement stmt						= null;
		ResultSet rs						= null;
		String facilityId					= (String)session.getValue("facility_id");
		String strCA						= request.getParameter("CA");
		String patient_id					= request.getParameter("Patient_ID");
			   patient_id					= (patient_id == null)?"":patient_id;
		String clinic_code					= request.getParameter("clinic_code");
		if(clinic_code==null || clinic_code.equals("") || clinic_code=="")
				clinic_code					= "";
		String clinic_desc					= request.getParameter("clinic_desc");
		if(clinic_desc==null || clinic_desc.equals("") || clinic_desc=="")
				clinic_desc					= "";
	    String treatment_area_desc			= request.getParameter("treatment_area_desc");
			   treatment_area_desc			= (treatment_area_desc == null)?"":treatment_area_desc;
		String treatment_area_code			= request.getParameter("treatment_area_code");
		if(treatment_area_code==null || treatment_area_code.equals("") || treatment_area_code=="")
				treatment_area_code			= "";
		String orig_tmt_area_code			= request.getParameter("orig_tmt_area_code");
		if(orig_tmt_area_code==null || orig_tmt_area_code.equals("") || orig_tmt_area_code=="")
				orig_tmt_area_code			= "";
		
		String encounter_id					= request.getParameter("encounter_id");
			   encounter_id					= (encounter_id == null)?"":encounter_id;
		String queue_status					= request.getParameter("queue_status");
			   queue_status					= (queue_status == null)?"":queue_status;
	   String practitioner_id					= request.getParameter("practitioner_id");
			   practitioner_id					= (practitioner_id == null)?"":practitioner_id;
        String operation					= request.getParameter("operation");
			   operation					= (operation == null)?"INSERT":operation;

		

        String queryString					= request.getQueryString();
		String triage_sysdate						= "";
	
		String visit_adm_date_time			= "";
		String visit_adm_date				= "";
		String open_to_all_pract_yn			= "";
		String open_to_all_prac_for_clinic_yn = ""; 
		String triage_start_date_time		= request.getParameter("triage_start_date_time");
			   triage_start_date_time		= (triage_start_date_time == null)?"":triage_start_date_time;

		String triage_start_date			= "";
		String nurse_description			= "";
  		String practitioner_description		= "";
		String triage_complaint				= "";
		String triage_end_date				= "";
		String priority_code				= "";
		String disabledField				= "";
		String readOnlyAttribute			= "";
		String sysdate						= "";
		String p_physician_id				= "",	p_physician_desc	= "";

		try{
                con                  = ConnectionManager.getConnection(request);
				// To get the open_to_all_pract_yn and  OPEN_TO_ALL_PRAC_FOR_CLINIC_YN
				String sqlClinic	 = " select OPEN_TO_ALL_PRACT_YN, "+
				" OPEN_TO_ALL_PRAC_FOR_CLINIC_YN,to_char(sysdate,'dd/mm/yyyy hh24:mi'),"+
				" short_desc treatment_area_desc "+
				" from AE_TMT_AREA_FOR_CLINIC_vw where FACILITY_ID= ? and CLINIC_CODE = ? and "+
				" TREATMENT_AREA_CODE = ? ";

				String sql_sysdate	=	"SELECT to_char(SYSDATE,'dd/mm/yyyy hh24:mi') FROM DUAL";

				pstmt = con.prepareStatement(sqlClinic);
				pstmt.setString(1, facilityId);
				pstmt.setString(2, clinic_code);
				pstmt.setString(3, orig_tmt_area_code);
				rset = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
					open_to_all_pract_yn	 = rset.getString("OPEN_TO_ALL_PRACT_YN");
					open_to_all_prac_for_clinic_yn	 = rset.getString("OPEN_TO_ALL_PRAC_FOR_CLINIC_YN");
					 sysdate						 = rset.getString(3);
					 treatment_area_desc	=	rset.getString("treatment_area_desc");
                }    
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				// Get the visit_adm_date_time
				String sqlVisit		= " select to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE_TIME, to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy') VISIT_ADM_DATE from PR_ENCOUNTER where FACILITY_ID = ? and ENCOUNTER_ID= ? ";
				pstmt = con.prepareStatement(sqlVisit);
				pstmt.setString(1, facilityId);
				pstmt.setString(2, encounter_id);
				rset = pstmt.executeQuery();
				while(rset!=null && rset.next())
				{
						visit_adm_date_time	 = rset.getString("VISIT_ADM_DATE_TIME");
						visit_adm_date		 = rset.getString("VISIT_ADM_DATE");
                }    
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
			
				String sqlPriority	= "select PRIORITY_CODE, SHORT_DESC, PRIORITY_NO "+
									  "from AE_PAT_PRIORITY where EFF_STATUS='E' order by SHORT_DESC ";

		if(!operation.equalsIgnoreCase("INSERT"))
			{
				String sqlQuery		= " SELECT to_char(TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_START_DATE_TIME, "+
									  " CLINIC_CODE, CLINIC_DESC, TREATMENT_AREA_DESC, TREATMENT_AREA_CODE, NURSE_ID, PHYSICIAN_ID, "+  " TRIAGE_COMPLAINT, to_char(TRIAGE_END_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_END_DATE_TIME,  "+
									  " PRIORITY_CODE,PHYSICIAN_NAME from AE_PAT_TRIAGE_VW "+
									  " where FACILITY_ID = ? and ENCOUNTER_ID = ? and "+
									  "	to_date(to_char(TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi'),'dd/mm/yyyy hh24:mi') = to_date('"+triage_start_date_time+"','dd/mm/yyyy hh24:mi') "+
									  " and CLINIC_CODE = ? and TREATMENT_AREA_CODE = ? ";
								pstmt			=	con.prepareStatement(sqlQuery);

								pstmt.setString	(	1,	facilityId		);  // from the session
								pstmt.setString	(	2,	encounter_id	);
								pstmt.setString	(	3,	clinic_code	);
								pstmt.setString	(	4,	treatment_area_code	);
							    rset = pstmt.executeQuery();
								while(rset!=null && rset.next())
								{
									 triage_start_date			= rset.getString("TRIAGE_START_DATE_TIME");
									 triage_start_date			= (triage_start_date == null)?"":triage_start_date;
									 clinic_desc				= rset.getString("CLINIC_DESC");
 									 clinic_desc				= (clinic_desc == null)?"":clinic_desc;
									 treatment_area_desc		= rset.getString("TREATMENT_AREA_DESC");
									 treatment_area_desc		= (treatment_area_desc == null)?"":treatment_area_desc;
									 nurse_description			= rset.getString("NURSE_ID");
									 nurse_description			= (nurse_description == null)?"":nurse_description;
									 practitioner_description	= rset.getString("PHYSICIAN_ID");
									 practitioner_description	= (practitioner_description == null)?"":practitioner_description;

									 p_physician_id				= rset.getString("PHYSICIAN_ID");
									 p_physician_id	= (p_physician_id == null)?"":p_physician_id;

									 p_physician_desc			= rset.getString("PHYSICIAN_NAME");
									 p_physician_desc	= (p_physician_desc == null)?"":p_physician_desc;

									 triage_complaint			= rset.getString("TRIAGE_COMPLAINT");
 									 triage_complaint			= (triage_complaint == null)?"" : triage_complaint;
									 

									 triage_end_date			= rset.getString("TRIAGE_END_DATE_TIME");
  									 triage_end_date			= (triage_end_date == null)?"":triage_end_date;
									 priority_code				= rset.getString("PRIORITY_CODE");
								     priority_code				= (priority_code == null)?"":priority_code;
									 disabledField				= "DISABLED";
									 readOnlyAttribute			= "READONLY";
								}
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
	
			} // End of operation
				//  To populate the nurse or the practitioner
				// pract_type='NS'-- Is for Nurse
				// pract_type='MD'-- Is for Doctor
			else if(operation.equalsIgnoreCase("INSERT"))
			{
							pstmt				=	con.prepareStatement(sql_sysdate);
							rset				=	pstmt.executeQuery();
							while(rset!=null && rset.next())
							{
							triage_sysdate		=	rset.getString(1);
							}
							triage_start_date	=	triage_sysdate;
							triage_end_date		=	triage_sysdate;
							if(rset!=null)rset.close();
                			if(pstmt!=null)pstmt.close();
			}
				
				String sqlNurse		 = "";
				//String sqlPract		= "";

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(clinic_desc)));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(treatment_area_desc)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disabledField));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

						if(open_to_all_pract_yn.equals("Y"))	
						{
							if(open_to_all_prac_for_clinic_yn.equals("Y"))
							{
								sqlNurse	=	" Select practitioner_id, practitioner_name "+
												" from am_pract_for_facility_vw where "+
												" operating_facility_id = ? and eff_status = 'E' "+
												" and pract_type = 'NS' ";
								pstmt			=	con.prepareStatement(sqlNurse);
								pstmt.setString	(	1,	facilityId		);
							}
							else if(treatment_area_code.equals(""))
							{
								sqlNurse	=	" select distinct PRACTITIONER_ID, PRACTITIONER_NAME "+
												" from AE_PRACT_FOR_TMT_AREA_VW "+
												" where FACILITY_ID = ? and CLINIC_CODE = ? "+
												" and EFF_STATUS = 'E' and PRACT_TYPE ='NS' ";
                                if(pstmt!=null) pstmt.close();
								pstmt			=	con.prepareStatement(sqlNurse);
								pstmt.setString	(	1,	facilityId		);
								pstmt.setString	(	2,	clinic_code		);
							}
							else
							{
								sqlNurse		=	" select PRACTITIONER_ID, PRACTITIONER_NAME "+
													" from AE_PRACT_FOR_TMT_AREA_VW "+
													" where FACILITY_ID = ? and CLINIC_CODE = ? "+
													" and TREATMENT_AREA_CODE = ? and EFF_STATUS = 'E' and PRACT_TYPE ='NS' ";
                                if(pstmt!=null) pstmt.close();
								pstmt			=	con.prepareStatement(sqlNurse);
								pstmt.setString	(	1,	facilityId			);
								pstmt.setString	(	2,	clinic_code			);
								pstmt.setString (	3,	treatment_area_code	);
							}
						} // End of if open_to_all_pract_yn
						else
						{
							if(open_to_all_prac_for_clinic_yn.equals("Y"))
							{
								sqlNurse			=	" Select a.PRACTITIONER_ID, a.PRACTITIONER_SHORT_NAME "+
														" PRACTITIONER_NAME "+
														" from OP_PRACT_FOR_CLINIC_VW a,AM_PRACTITIONER b where a.FACILITY_ID = ? "+
														" and a.CLINIC_CODE = ? and a.practitioner_id=b.practitioner_id and  a.EM_VISIT_TYPE_APPL_YN ='Y' "+
														" and b.pract_type='NS' and a.EFF_STATUS = 'E' ";
                                if(pstmt!=null) pstmt.close();
								pstmt				=	con.prepareStatement(sqlNurse);
								pstmt.setString	(	1,	facilityId			);
								pstmt.setString	(	2,	clinic_code			);
						}
						else if(treatment_area_code.equals(""))
						{
								sqlNurse	=	" select distinct PRACTITIONER_ID, PRACTITIONER_NAME "+
												" from AE_PRACT_FOR_TMT_AREA_VW where FACILITY_ID = ? "+
												" and CLINIC_CODE = ? and EFF_STATUS = 'E' and "+
												" PRACT_TYPE ='NS'";
                                if(pstmt!=null) pstmt.close();

								pstmt				=	con.prepareStatement(sqlNurse);

								pstmt.setString	(	1,	facilityId			);
								pstmt.setString	(	2,	clinic_code			);
						}
						else
						{
								sqlNurse			=	" select PRACTITIONER_ID, PRACTITIONER_NAME "+
														" from AE_PRACT_FOR_TMT_AREA_VW where FACILITY_ID = ? "+
														" and CLINIC_CODE = ? and TREATMENT_AREA_CODE = ? "+
														" and EFF_STATUS = 'E' and PRACT_TYPE ='NS'";
                                if(pstmt!=null) pstmt.close();
								pstmt		=	con.prepareStatement(sqlNurse);
								pstmt.setString	(	1,	facilityId			);
								pstmt.setString	(	2,	clinic_code			);
								pstmt.setString (	3,	treatment_area_code	);
						}
					}
					rset			=	pstmt.executeQuery();

					while(rset!=null && rset.next())
					{
						if(nurse_description.equalsIgnoreCase(rset.getString(1)))
							 out.println("<option value='"+rset.getString(1)+"' selected>"+rset.getString(2)+" ");
						else
							 out.println("<option value='"+rset.getString(1)+"'>"+rset.getString(2)+" ");
					}
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					
		   
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_physician_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_physician_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disabledField));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(triage_start_date)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(readOnlyAttribute));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(triage_complaint)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(readOnlyAttribute));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(readOnlyAttribute));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(triage_complaint)));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(triage_end_date)));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(readOnlyAttribute));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disabledField));
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

						   pstmt = con.prepareStatement(sqlPriority);
					       rset = pstmt.executeQuery();
						   while(rset!=null && rset.next())
						   {
							   if(priority_code.equalsIgnoreCase(rset.getString(1)))
									 out.println("<option value='"+rset.getString(1)+"|"+rset.getString(3)+"' selected>"+rset.getString(2)+" ");
								else
									 out.println("<option value='"+rset.getString(1)+"|"+rset.getString(3)+"'>"+rset.getString(2)+" ");
						   }
						   if(rset!=null) rset.close();
						   if(pstmt!=null) pstmt.close();
						   
					   
            _bw.write(_wl_block35Bytes, _wl_block35);

		if(strCA==null)
			{
		
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disabledField));
            _bw.write(_wl_block37Bytes, _wl_block37);

			}
			else
			{
		
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disabledField));
            _bw.write(_wl_block39Bytes, _wl_block39);

			}
		
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(strCA));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(orig_tmt_area_code));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(treatment_area_code));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(treatment_area_desc)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(clinic_desc)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(queryString)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(visit_adm_date_time)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(visit_adm_date)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(open_to_all_pract_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(open_to_all_prac_for_clinic_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block57Bytes, _wl_block57);

			try
			{
				String sql_sys = "select to_char(sysdate,'dd/mm/yyyy hh24:mi') cdate from dual ";

				stmt = con.createStatement();

				rs   = stmt.executeQuery(sql_sys);

				while (rs.next())
				{
					sysdate = rs.getString(1);
				}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(rs!=null) rs.close();
				if (stmt!=null) stmt.close();
			}
		
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(ecis.utils.HTMLUtilities.getDisplayString(sysdate)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(sysdate));
            _bw.write(_wl_block60Bytes, _wl_block60);

    }
    catch(Exception e)
    {
		e.printStackTrace();
	}
    finally
    {
        if(pstmt!=null)  pstmt.close();
		if(rset!=null)  rset.close();
		if(rs!=null)  rs.close();
	    ConnectionManager.returnConnection(con,request);
    }

            _bw.write(_wl_block61Bytes, _wl_block61);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TriageDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clinic.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.treatmentarea.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nurse.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAE.Physician.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ae_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.startdatetime.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Complaint.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddatetime.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
}
