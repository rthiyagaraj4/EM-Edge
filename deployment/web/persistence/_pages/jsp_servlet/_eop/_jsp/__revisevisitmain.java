package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __revisevisitmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ReviseVisitMain.jsp", 1731314971725L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n  <head>\n    <!-- <link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link> -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script><!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 21st Nov 2013-->\n\t\n    <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n   <!--  <Script src=\"../../eMP/js/PatientRegistration.js\" language=\"JavaScript\"></Script>  -->\n    <Script src=\"../../eOP/js/ReviseVisit.js\" language=\"JavaScript\"></Script>\n    <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t<script language=\'javascript\' src=\'../../eOP/js/OPPractitionerComponent.js\'></script>\n\t<script src=\"../../eCommon/js/CommonLookup.js\" language=\"javascript\"></script>\n    <script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>   \n    <script language=\"javascript\" src=\"../../eOP/js/Checkblockscheduleforpract.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013-->\n     \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="     \n\n</head>\n<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n<body class=\'content\' onload=\'FocusFirstElement();displayRemarksForOtherReason(document.forms[0].revise_reason_code);\' onMouseDown=\"CodeArrest();\"onKeyDown =\'lockKey();\' topmargin=\'0\' bottommargin=\'0\'  >\n<form name=\'revise_visit_form\' id=\'revise_visit_form\' method=\'post\' action=\'../../servlet/eOP.ReviseVisitServlet\' target=\"messageFrame\">\n\n <table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'97%\' align=\'center\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="      <tr>  \n\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n            <td class=\'QUERYDATA\' colspan=\'3\' width=\'75%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t</tr>\t\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="       \n          \n          <tr>\n             <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n             <td class=\'QUERYDATA\' colspan=\'3\' width=\'75%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n             </td>             \n          </tr>\n        </table>       \n       ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n      <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'97%\' align=\'center\'>\n      <tr>\t \n\t  <td class=\'columnheader\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n      </tr>\n      </table>\n\t  <table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'97%\' align=\'center\'>\t\t\t\n      <tr>\n\t\t<td class=\'querydata\' colspan=\'4\'>&nbsp;";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n      </tr>\n      </table>\t \n      \n\t\t  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n    \n\t\t <!-- Display the Encounter Details -->\n\t\t \n\t   <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'97%\' align=\'center\'>\n         <tr>\n\t\t    <th align=\"left\" class=\'columnheader\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</th> \n         </tr>\n       </table>       \n       <table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'97%\' align=\'center\' name=\'revise_detailstab\' id=\'revise_detailstab\' >  \n       <tr>\n\t\t  <td class=\'CAGROUPHEADING\'>&nbsp;</td>\t\n\t\t  <td class=\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n          <td class=\'CAGROUPHEADING\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t  <!--Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11-->\n\t\t  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<td class=\'CAGROUPHEADING\' nowrap><a href=\"javascript:UploadDocument();\"><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;</b></a></td>\n\t\t  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<td class=\'CAGROUPHEADING\'>&nbsp;</td>\n\t\t  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t   </tr>  \n\t   <tr>\n          <td class= \'label\' width=\'25%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t  <td class=\'QUERYDATA\' width=\'30%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n    ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="      \n </td></tr> \t\t\n\t\t<tr>\n           <td class= \'label\' width=\'25%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n           <td class=\'QUERYDATA\' nowrap width=\'30%\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t   <td colspan=2 class=\'QUERYDATA\' width=\'45%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>      \n    </tr>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="   \t\n\n<tr>   \n\t<td class= \'label\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n    <td class=\'QUERYDATA\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n    <td colspan=2 class=\'QUERYDATA\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n    </td>\n</tr>\t  \n<tr>\n    <!-- Populate the services  -->\n\t\t   <td class= \'label\' nowrap >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n           <td class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n           <td class=\'QUERYDATA\' colspan=2 ><select name=\'subService\' id=\'subService\' onChange=\'ChangeObj(this)\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" tabIndex=\'5\'>\n\t\t   <option value=\'\'>&nbsp;-------- ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" --------&nbsp; \n\t\t   \n\t\t   ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\n\t\t   </select>\n\t\t   </td>\n</tr>\n<tr>\n        <td class= \'label\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n        <td class=\'QUERYDATA\' nowrap>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t  \n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<td class=\'fields\' colspan=\"2\"><input type=\"text\" name=\"pract_name\" id=\"pract_name\" maxlength=\"30\" size=\"30\" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" onBlur=\"onBlurCallPractitionerSearch(document.getElementById(\'pract_butt\'),pract_name)\" tabIndex=\'4\' ><input type=\"button\" name=\"pract_butt\" id=\"pract_butt\" value=\"?\" class=\"button\" onClick=\"callPractSearchRevise(this,pract_name);\" ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" ><img ALIGN = center src = \"../../eCommon/images/mandatory.gif\" style = \'visibility:";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id = \'practitionerMandatoryGIF\' ></img><input type=\"hidden\" name=\"asn_pract_id\" id=\"asn_pract_id\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"></td>\n\t</tr>\t\n\t<tr>\n        <td class= \'label\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t<td class=\'fields\' colspan=\"2\"><select name=\'other_res_type\' id=\'other_res_type\' onChange=\'clearResourceVal(this);\' ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="><option value=\'\'>----";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="----</option>\n\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t<option value=\'E\' selected>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</option><option value=\'O\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</option>\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</option><option value=\'O\' selected>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t</select>/<input type=\'text\' name=\'other_res_txt\' id=\'other_res_txt\' maxlength=\'15\' size=\'16\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="><input type=\'button\' class=\'button\' name=\'other_res_butt\' id=\'other_res_butt\' value=\'?\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" onClick=\'otherResourceLookUp(this,other_res_txt);\'  >\n\t\t<input type=\'hidden\' name=\'other_res_code\' id=\'other_res_code\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'></td>\n\t</tr>\n\t<tr><td class=\'label\' >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\t<td  class=\'Fields\' colspan = \"4\">\n\t<input type=\'text\' name=\'referal_id1\' id=\'referal_id1\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" maxlength=\'20\' size=\'25\' onblur=\'searchReferral(this)\'><input type=\'button\' class=\'button\' value=\'?\' ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" name=\'ref_id_search\' onClick=\'getReferralID()\'></td></tr>\n\n <!--   <tr>\n           <td   class= \'label\' nowrap>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t\t<td  class=\'fields\'  colspan=3>\n\t\t\t<input type = \'checkbox\' value=\'Y\' name=\'new_op_episode_yn\' id=\'new_op_episode_yn\' value=\"N\" disabled checked onClick=\"new_episode_yn_func(this)\" tabIndex=\'8\'>\n           </td>\n\t\t</tr>\n\t\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\n\t\t<tr>\n        <td  align=\'left\' class=\'label\' nowrap>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="                                    \n           </td>           \n           <td  class=\'fields\'  class=\'QUERYDATA\'  colspan=3 nowrap ><b>\n                <input type=\"hidden\" name=\'last_episode_no\' id=\'last_episode_no\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'  size=\'12\' maxlength=\'12\' readOnly >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n          </td>           \n           <input type=\"hidden\" name=\'last_visit_no\' id=\'last_visit_no\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'  size=\'12\' maxlength=\'12\' readOnly >\n           \n\t</tr> -->\t\t\n     <tr>\n     <td class=\'label\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n     \n ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t    <td class=\'querydata\' colspan=\'3\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t   ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="     \n </tr>\n\n\t\t<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t<tr>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t\t<td class=\'QUERYDATA\' style=\'word-wrap:break-word;width:300px;\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t<!--End ML-MMOH-CRF-1114-->\n\n <tr>\n\t\t\t<!--displayRemarksForOtherReason() Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n            <td class= \'label\' nowrap>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t\t<td colspan = \"4\"><select name=\'revise_reason_code\' id=\'revise_reason_code\' tabIndex=\'11\' onChange=\'displayRemarksForOtherReason(revise_reason_code);\'><option value=\'\'>&nbsp;-------- ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" --------&nbsp;</option>\n ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="          \n            </select><img src=\'../../eCommon/images/mandatory.gif\'></img>             \n           </td>\n\t\t   <td  id=\'queue_div\' style=\'visibility:hidden;display:none\' class=\'label\' width=\'20%\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t<input type=\'text\' name=\'queue_no\' id=\'queue_no\' size=\'15\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' onKeyPress=\'return Check_SpecCharsValidationOP(event);\' onPaste=\'return checkspecialandalphanumericOP(event);\' onblur = \'chkValue(this);\' maxlength=\'15\' ><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t</tr> \n\n\t\t<!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t\t<tr>\n\t\t\t<td class=label id=\'remarks_labl\' style=\'visibility:hidden\'>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t\t<td class=\"fields\" id=\'remarks_fld\' style=\'visibility:hidden\'><textarea rows=2 cols=45 name=\"other_remarks\" onkeyPress=\'checkMaxLimit(this,100)\' onBlur=\"SPCheckMaxLen(\'Remarks\',this,100)\">";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</textarea><img src=\'../../eCommon/images/mandatory.gif\' id=\'remarks_img\' style=\'visibility:hidden\'></td>\n\t\t</tr>\n\t\t<!--End ML-MMOH-CRF-1114-->\n\n       </table>    \n      <input type=\'hidden\' name=\'ambulatory_status\' id=\'ambulatory_status\' value=\'\'></input>\n\t  <input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'></input>\n\t  <input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'></input>\n\t  <input type=\'hidden\' name=\'q_appt_ref_no\' id=\'q_appt_ref_no\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n      <input type=\'hidden\' name=\'queue_status\' id=\'queue_status\'  value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n      <input type=\'hidden\' name=\'cur_locn_code\' id=\'cur_locn_code\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n      <input type=\'hidden\' name=\'cur_locn_desc\' id=\'cur_locn_desc\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n      <input type=\'hidden\' name=\'cur_locn_type\' id=\'cur_locn_type\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n      <input type=\'hidden\' name=\'cur_locn_type_desc\' id=\'cur_locn_type_desc\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>               \n      <input type=\'hidden\' name=\'asn_care_locn_type\' id=\'asn_care_locn_type\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>             \n      <input type=\'hidden\' name=\'cur_specialty_code\' id=\'cur_specialty_code\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n\t  <input type=\'hidden\' name=\'room_num\' id=\'room_num\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\t  \t  \n\t  <input type=\'hidden\' name=\'referral_id_old\' id=\'referral_id_old\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\t  \t  \n\t  \t  \t  \n\t  <input type=\'hidden\' name=\'room_change\' id=\'room_change\' value=\'\'>\n\t  <input type=\'hidden\' name=\'room_cur\' id=\'room_cur\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n      <input type=\'hidden\' name=\'cur_visit_type_code\' id=\'cur_visit_type_code\'  value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n      <input type=\'hidden\' name=\'cur_visit_desc\' id=\'cur_visit_desc\'       value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\n      <input type=\'hidden\' name=\'cur_visit_type_ind\' id=\'cur_visit_type_ind\'   value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\n\t  <input type=\'hidden\' name=\'cur_service_code\' id=\'cur_service_code\'     value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>\n      <input type=\'hidden\' name=\'cur_service_desc\' id=\'cur_service_desc\'     value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>         \n      <input type=\'hidden\' name=\'cur_subservice_code\' id=\'cur_subservice_code\'  value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n      <input type=\'hidden\' name=\'cur_pract_name\' id=\'cur_pract_name\'       value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n      <input type=\'hidden\' name=\'cur_pract_type\' id=\'cur_pract_type\'       value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n      <input type=\'hidden\' name=\'cur_practitioner_id\' id=\'cur_practitioner_id\'  value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n      <input type=\'hidden\' name=\'patient_id\' id=\'patient_id\'       value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n      <input type=\'hidden\' name=\'p_clinic_type\' id=\'p_clinic_type\'    value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n      <input type=\'hidden\' name=\'p_clinic_code\' id=\'p_clinic_code\'    value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n      <input type=\'hidden\' name=\'p_visit_type_code\' id=\'p_visit_type_code\'    value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'>\n      <input type=\'hidden\' name=\'p_visit_type_short_desc\' id=\'p_visit_type_short_desc\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n      <input type=\'hidden\' name=\'visit_adm_type_ind\' id=\'visit_adm_type_ind\'   value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t  <input type=\'hidden\' name=\'unlinkapptcaseyn\' id=\'unlinkapptcaseyn\' value=\'N\'>\n\t   <input type=\'hidden\' name=\'visit_case\' id=\'visit_case\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>     \n      <input type=\'hidden\' name=\'open_to_all_pract_yn\' id=\'open_to_all_pract_yn\' value=\"N\">\n      <input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\"\">\n      <input type=\'hidden\' name=\'ident_at_checkin\' id=\'ident_at_checkin\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n      <input type=\'hidden\' name=\'visit_type_code\' id=\'visit_type_code\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n      <input type=\'hidden\' name=\'episodeReqd\' id=\'episodeReqd\' value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n      <input type=\'hidden\' name=\'last_episode_no\' id=\'last_episode_no\' value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n      <input type=\'hidden\' name=\'last_visit_no\' id=\'last_visit_no\' value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n      <input type=\'hidden\' name=\'h_visit_type_ind\' id=\'h_visit_type_ind\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n      <input type=\'hidden\' name=\'pract_type\' id=\'pract_type\' value=\"\">\n\t  <input type=\'hidden\' name=\'userid\' id=\'userid\' value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\n\t  <input type=\'hidden\' name=\'assign_q_num_by\' id=\'assign_q_num_by\' value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n\t  \n      <input type=\'hidden\' name=\'l_encounter_id\' id=\'l_encounter_id\' value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n      <input type=\'hidden\' name=\'visit_adm_date_time\' id=\'visit_adm_date_time\' value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n      <input type=\'hidden\' name=\'bl_interface_yn\' id=\'bl_interface_yn\' value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n\t  <input type=\'hidden\' name=\'bl_install_yn\' id=\'bl_install_yn\' value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n\t  <input type=\'hidden\' name=\'service\' id=\'service\' value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\t  <input type = \'hidden\' name = \'identifyPractitionerAtCheckIn\' value = \'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' >\n\t  <input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'REVISE_VISIT\'>\n\t  <input type=\'hidden\' name=\'resclass\' id=\'resclass\' value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t  <input type=\'hidden\' name=\'restype\' id=\'restype\' value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t  <input type=\'hidden\' name=\'chg_flag\' id=\'chg_flag\' value=\'\'>\n      <input type=\'hidden\' name=\'old_locn_code\' id=\'old_locn_code\'        value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n      <input type=\'hidden\' name=\'old_srvc_code\' id=\'old_srvc_code\'     value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n\t  <input type=\'hidden\' name=\'arrive_date_time\' id=\'arrive_date_time\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n      <input type=\'hidden\' name=\'vital_signs_date_time\' id=\'vital_signs_date_time\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\n\t  <input type=\'hidden\' name=\'res_class\' id=\'res_class\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'>\n\t  <input type=\'hidden\' name=\'appt_walk_ind\' id=\'appt_walk_ind\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n\t  <input type=\'hidden\' name=\'oth_res_id\' id=\'oth_res_id\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'>\n\t  <input type=\'hidden\' name=\'queue_date\' id=\'queue_date\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n\t  <input type=\'hidden\' name=\'queue_num\' id=\'queue_num\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n\t  <input type=\'hidden\' name=\'open_to_all\' id=\'open_to_all\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n\t  <input type=\'hidden\' name=\'queue_id\' id=\'queue_id\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n\t  <input type=\'hidden\' name=\'status\' id=\'status\' value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'>\n\t  <input type=\'hidden\' name=\'entitlement_by_pat_cat_yn\' id=\'entitlement_by_pat_cat_yn\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n\t  <input type=\'hidden\' name=\'cur_qms_interfaced_yn\' id=\'cur_qms_interfaced_yn\' value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\n\t  <input type=\'hidden\' name=\'qms_interfaced_yn\' id=\'qms_interfaced_yn\' value=\'N\'>\n\t  <input type=\'hidden\' name=\'qms_exception\' id=\'qms_exception\' value=\'N\'>\n\n\t  <!--Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114-->\n\t  <input type=\'hidden\' name=\'others_id\' id=\'others_id\' value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n\t  <input type=\'hidden\' name=\'contact_reason_code\' id=\'contact_reason_code\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\n\t  <input type=\'hidden\' name=\'other_reason_remarks\' id=\'other_reason_remarks\' value=\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'>\n\t  \n\t  <!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013 Start-->\t\t\n\t\t<input type=\'hidden\' name=\'Sysdate\' id=\'Sysdate\' id=\'Sysdate\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'\t />\n\t\t<input type=\'hidden\' name=\'Systime\' id=\'Systime\' id=\'Systime\'\t />\n\t\t<input type=\'hidden\' name=\'is_prac_blocked\' id=\'is_prac_blocked\' id=\'is_prac_blocked\' \t /> \n\t\t<input type=\'hidden\' name=\'action_on_pract_schedule\' id=\'action_on_pract_schedule\' id=\'action_on_pract_schedule\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\' \t />\n\t\t<input type=\'hidden\' name=\'exist_pract_id\' id=\'exist_pract_id\' id=\'exist_pract_id\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'\t /> \n\t\t\n\t\t<!--  Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013 End-->\n\t\t<input type=\'hidden\' name=\'isQMSapplicable\' id=\'isQMSapplicable\' value=";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =">\n\t  \t\n\t\t\n   <script>\n\n        function EnabApply()\n        {           \n            parent.parent.frames[0].document.forms[0].apply.disabled= false ;                   \n        }\n\t\t\n\t\tif(document.forms[0].status.value ==\"04\")\n\t\t\talert(getMessage(\"CONSPROG_ONLY_REFDET_CHANGE\",\"OP\"))\n\t\t\t\n  </script>       \n";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="      \n      </form>\n  </body>\n</html>\n\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

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
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


 Connection con=null;
 PreparedStatement pstmt=null;
 PreparedStatement pstmt1= null;
 ResultSet rs1 = null;
try{     request.setCharacterEncoding("UTF-8");
    String episodeReqd ="";      
    boolean isQMSapplicable=false;
    String appt_case            = "";   
    String q_appt_ref_no        = "";   
    String userid               = (String) session.getValue("login_user");   
	String locale = (String) session.getValue("LOCALE");
    String l_encounter_id       = "";    
    String patient_id       ="";
    String locn_desc        ="";
    String locn_type_desc       ="";
    String service_desc         ="";
    String pract_name       ="";
    String visit_type_desc      ="";
    String cur_locn_code        ="";
    String cur_locn_type        ="";
    String cur_room_num		="";
    String cur_service_code     ="";
    String cur_pract_type       = "";
	String cur_pract_type_desc  = "";
    String cur_visit_type_ind   = "";
	String visit_desc       = "";
    String care_locn_type_ind   = "";
    String p_clinic_code        = "";
    String p_clinic_type        = "";
    String p_clinic_type_code   = "";
    String p_clinic_desc        = "";
	String p_open_to_all_pract_yn = "";
    String constr               = "";
    String p_gender             = "";
    String p_dob                = "";
    String p_visit_type_short_desc  = "";
    String p_visit_type_code    = ""; 
    String p_cur_practitioner_id    = "";
    String p_cur_open_to_all_pract_yn = "";
    String p_cur_visit_type_code    = "";
    String subservice_code      = "";
	String subservice_desc      = "";
    String cur_specialty_code   = "";   
	String episode_id       = "";
	String last_visit_num       = "";       
	String visit_case       = "";     
	String asn_visit_type_ind_desc  = "";		
	String visit_type_code      = "";
	String allow_referral_yn      = "";
	String disableReferral      = "";
	
	String asn_care_locn_type   = "";
	String contact_reason_code  = "";		
	String revise_reason_code="";		
	String visit_adm_date_time = null;
	String roomnum="";
	/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
	String room_desc="";
	/*CRF end SS-CRF-0010 [IN034516]*/
	String p_speciality_code="";
	String visit_adm_type_ind="";
	String entitlement_by_pat_cat_yn = "";

	//Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	String other_reason_remarks = "";
	String others_id = "";
	String revise_visit_remarks = "";
	
	String sql="";
	String resource_class="";
	String resource_type="";
	String subServiceSQL = null;
	String subService = "";
	String subServiceCode = "";	
	String practitionerMandatory = null;
	String APPT_OR_WALK_IN_IND = "";
	ResultSet subServiceResult = null;
	PreparedStatement subServiceStatement = null;
	String referral_id="";
    String referral_details="";
    StringBuffer locsql=new StringBuffer();
	String 	  oper_id =request.getParameter("oper_id")==null?"":request.getParameter("oper_id");
	l_encounter_id      = request.getParameter("encounter_id");
	String facilityid   = (String) session.getValue("facility_id");
	String queue_status=request.getParameter("QStatus");
	 if(queue_status == null) queue_status="";
	String status=request.getParameter("status");
	 if(status == null) status="";
	 String disableFields = "";
	 if(status.equals("04")){
		 disableFields = "disabled";
	 }
	String arrive_date_time=request.getParameter("ArriveDTime");
	 if(arrive_date_time == null) arrive_date_time="";
	String vital_signs_date_time=request.getParameter("VitalDTime");
	 if(vital_signs_date_time == null) vital_signs_date_time="";
	con      = ConnectionManager.getConnection(request);
	
	String queue_num = request.getParameter("queue_num");	
	if(queue_num == null) queue_num="0";
	String other_res_class="";
	String other_res_id="";
	String other_res_desc="";
	String res_class_desc="";
	String res_tot="";
	String appt_walk_ind="";
	String queue_id="";
	String disableRoom = "";
  
	   ResultSet rs=null;     
       String record ="N";
       String bl_interface_yn = request.getParameter("bl_interfaced_yn");	
       String assign_q_num_by = request.getParameter("assign_queue_num_by");	
       String queue_date = request.getParameter("sys_date");		   
	   //For Billing
	   String bl_install_yn = (String) session.getValue("bl_operational");	
	   String action_on_pract_schedule	= "N";// Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
	   String Sysdate	= "";// Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013

	   /*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
		HashMap hashdata	= eCommon.Common.CommonBean.getSiteSpecificDetails(con, "OA","REMARKS_FOR_OTHERS");
		others_id	= (String)hashdata.get("value1");
		if(others_id == null) others_id = "";
		/*End ML-MMOH-CRF-1114*/
		
		isQMSapplicable=eCommon.Common.CommonBean.isSiteSpecific(con,"OP","EXT_QUEUE_NO");
		
		//Added by Ashwini on 12-Feb-2020 for AAKH-CRF-0079.11
		Boolean isInvokeUploadDocAppl =  eCommon.Common.CommonBean.isSiteSpecific(con,"MP","INVOKE_UPLOAD_DOCUMENT");

	  //String sql_new="SELECT A.patient_id patient_id ,TO_CHAR(A.QUEUE_DATE,'dd/mm/yyyy hh24:mi') visit_adm_date_time  ,decode(A.APPT_OR_WALK_IN_IND, 'A', 'Y', 'N') appt_case_yn , A.APPT_OR_WALK_IN_IND APPT_OR_WALK_IN_IND , A.appt_id appt_id ,A.SPECIALITY_CODE specialty_code ,null patient_type ,A.referral_id referral_id, A.episode_id episode_id ,A.OP_EPISODE_VISIT_NUM OP_EPISODE_VISIT_NUM ,B.SEX gender ,TO_CHAR(b.DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, d.long_desc LOCN_DESC , A.locn_type ASSIGN_CARE_LOCN_TYPE  ,AM_GET_DESC.AM_CARE_LOCN_TYPE(A.LOCN_TYPE,'"+locale+"','2') LOCN_TYPE_DESC   ,am_get_desc.AM_SERVICE(A.SERVICE_CODE,'"+locale+"',2) service_desc ,DECODE (A.LOCN_TYPE,'N', NULL, d.open_to_all_pract_yn) cur_open_to_all_pract_yn ,op_get_desc.op_visit_type(a.facility_id,a.VISIT_TYPE_CODE,'"+locale+"',2) visit_type_desc  ,NULL  RESCLASS , c.pract_type  RESTYPE ,A.LOCN_CODE CUR_LOCN_CODE ,A.LOCN_TYPE CUR_LOCN_TYPE ,A.SERVICE_CODE CUR_SERVICE_CODE , A.PRACTITIONER_ID CUR_PRACTITIONER_ID, c.practitioner_name pract_name ,c.pract_type CUR_PRACT_TYPE , am_get_desc.am_pract_type(c.pract_type,'"+locale+"',2)  PRACT_TYPE_DESC , d.level_of_care_ind CUR_LEVEL_OF_CARE_IND, A.VISIT_TYPE_CODE VISIT_TYPE_CODE ,decode(A.APPT_OR_WALK_IN_IND, 'A', 'Y', 'N') VISIT_CASE  ,A.VISIT_TYPE_IND CUR_VISIT_TYPE_IND ,op_get_desc.op_visit_type(a.facility_id,a.visit_type_code,'"+locale+"',2) VISIT_DESC  ,A.VISIT_TYPE_code P_CUR_VISIT_TYPE_CODE, A.SUBSERVICE_CODE SUBSERVICE_CODE  ,am_get_desc.am_subService(a.service_code,a.subservice_code,'"+locale+"',2) SUBSERVICE_DESC, A.ROOM_NUM ROOM_NUM ,A.REVISE_REASON_CODE REVISE_REASON_CODE , A.CONTACT_REASON_CODE CONTACT_REASON_CODE  , am_get_desc.am_contact_reason(a.contact_reason_code,'"+locale+"',1) REASON_FOR_CONTACT  ,A.OTHER_RES_CLASS OTHER_RES_CLASS , A.OTHER_RESOURCE_ID OTHER_RESOURCE_ID , am_get_desc.AM_RESOURCE(a.facility_id,a.other_resource_id,'"+locale+"',2)  other_resource_desc, A.QUEUE_ID QUEUE_ID, d.primary_resource_class, d.ident_at_checkin, d.allow_referral_yn, (select entitlement_by_pat_cat_yn from mp_param where module_id = 'MP') entitlement_by_pat_cat_yn FROM OP_PATIENT_QUEUE A, MP_PATIENT B, am_practitioner_lang_vw C, op_clinic d WHERE A.FACILITY_ID = '"+facilityid+"'  AND A.ENCOUNTER_ID = '"+l_encounter_id+"' AND A.PATIENT_CLASS = 'OP' AND a.patient_id = b.patient_id AND d.clinic_code = a.locn_code and d.facility_id = a.facility_id and  C.practitioner_id(+)=A.practitioner_id and c.language_id (+)= '"+locale+"'";  	  
		
	  // Modified for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
	  //Modified by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114
	  String sql_new="SELECT (select action_on_pract_schedule from op_param where OPERATING_FACILITY_ID='"+facilityid+"' ) action_on_pract_schedule,TO_CHAR(SYSDATE,'dd/mm/yyyy') Sys_date,A.patient_id patient_id ,TO_CHAR(A.QUEUE_DATE,'dd/mm/yyyy hh24:mi') visit_adm_date_time  ,decode(A.APPT_OR_WALK_IN_IND, 'A', 'Y', 'N') appt_case_yn , A.APPT_OR_WALK_IN_IND APPT_OR_WALK_IN_IND , A.appt_id appt_id ,A.SPECIALITY_CODE specialty_code ,null patient_type ,A.referral_id referral_id, A.episode_id episode_id ,A.OP_EPISODE_VISIT_NUM OP_EPISODE_VISIT_NUM ,B.SEX gender ,TO_CHAR(b.DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH, d.long_desc LOCN_DESC , A.locn_type ASSIGN_CARE_LOCN_TYPE  ,AM_GET_DESC.AM_CARE_LOCN_TYPE(A.LOCN_TYPE,'"+locale+"','2') LOCN_TYPE_DESC   ,am_get_desc.AM_SERVICE(A.SERVICE_CODE,'"+locale+"',2) service_desc ,DECODE (A.LOCN_TYPE,'N', NULL, d.open_to_all_pract_yn) cur_open_to_all_pract_yn ,op_get_desc.op_visit_type(a.facility_id,a.VISIT_TYPE_CODE,'"+locale+"',2) visit_type_desc  ,NULL  RESCLASS , c.pract_type  RESTYPE ,A.LOCN_CODE CUR_LOCN_CODE ,A.LOCN_TYPE CUR_LOCN_TYPE ,A.SERVICE_CODE CUR_SERVICE_CODE , A.PRACTITIONER_ID CUR_PRACTITIONER_ID, c.practitioner_name pract_name ,c.pract_type CUR_PRACT_TYPE , am_get_desc.am_pract_type(c.pract_type,'"+locale+"',2)  PRACT_TYPE_DESC , d.level_of_care_ind CUR_LEVEL_OF_CARE_IND, A.VISIT_TYPE_CODE VISIT_TYPE_CODE ,decode(A.APPT_OR_WALK_IN_IND, 'A', 'Y', 'N') VISIT_CASE  ,A.VISIT_TYPE_IND CUR_VISIT_TYPE_IND ,op_get_desc.op_visit_type(a.facility_id,a.visit_type_code,'"+locale+"',2) VISIT_DESC  ,A.VISIT_TYPE_code P_CUR_VISIT_TYPE_CODE, A.SUBSERVICE_CODE SUBSERVICE_CODE  ,am_get_desc.am_subService(a.service_code,a.subservice_code,'"+locale+"',2) SUBSERVICE_DESC, A.ROOM_NUM ROOM_NUM ,A.REVISE_REASON_CODE REVISE_REASON_CODE , A.CONTACT_REASON_CODE CONTACT_REASON_CODE  , am_get_desc.am_contact_reason(a.contact_reason_code,'"+locale+"',1) REASON_FOR_CONTACT  ,A.OTHER_RES_CLASS OTHER_RES_CLASS , A.OTHER_RESOURCE_ID OTHER_RESOURCE_ID , am_get_desc.AM_RESOURCE(a.facility_id,a.other_resource_id,'"+locale+"',2)  other_resource_desc, A.QUEUE_ID QUEUE_ID, d.primary_resource_class, d.ident_at_checkin, d.allow_referral_yn, (select entitlement_by_pat_cat_yn from mp_param where module_id = 'MP') entitlement_by_pat_cat_yn, A.other_reason_remarks, A.revise_visit_remarks FROM OP_PATIENT_QUEUE A, MP_PATIENT B, am_practitioner_lang_vw C, op_clinic d WHERE A.FACILITY_ID = '"+facilityid+"'  AND A.ENCOUNTER_ID = '"+l_encounter_id+"' AND A.PATIENT_CLASS = 'OP' AND a.patient_id = b.patient_id AND d.clinic_code = a.locn_code and d.facility_id = a.facility_id and  C.practitioner_id(+)=A.practitioner_id and c.language_id (+)= '"+locale+"'";
	  pstmt= con.prepareStatement(sql_new);
	  rs= pstmt.executeQuery();
	
	  if(rs!=null && rs.next())
      {
         //while(rs.next())
         //{		    
        	 	action_on_pract_schedule	= rs.getString("action_on_pract_schedule");// Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
        	 	Sysdate						= rs.getString("Sys_date");// Added for JD-CRF-0183 [IN:041353] By Dharma on 27th Nov 2013
        	 	visit_adm_date_time = rs.getString("visit_adm_date_time");
				if(visit_adm_date_time == null) visit_adm_date_time="";
				appt_case = rs.getString("appt_case_yn") ;
				 if(appt_case ==null) appt_case="";
				 
				 q_appt_ref_no = rs.getString("appt_id");
				  if(q_appt_ref_no == null) q_appt_ref_no = ""; 
				 
				 patient_id = rs.getString("patient_id");
				 if(patient_id == null) patient_id= "";     
												  
				 cur_specialty_code = rs.getString("specialty_code");
				 if(cur_specialty_code  == null ) cur_specialty_code = "";
			 
				referral_id = rs.getString("referral_id");

				APPT_OR_WALK_IN_IND = rs.getString("APPT_OR_WALK_IN_IND");
				
				if(referral_id == null) referral_id="";
                /*Below line commeneted and added for this incident [60902]*/
				/*if(!(referral_id.equals("") && q_appt_ref_no.equals("")))
					appt_walk_ind="A";
				else if(!referral_id.equals(""))
					appt_walk_ind="R";
				else
					appt_walk_ind=APPT_OR_WALK_IN_IND;*/
					
			    if(!q_appt_ref_no.equals("")){
					appt_walk_ind="A";
				}else if(!referral_id.equals("")){
					appt_walk_ind="R";
				}else{
					appt_walk_ind=APPT_OR_WALK_IN_IND;	
                }
                //End this incident [60902]				
 
				episode_id = rs.getString("episode_id");
                last_visit_num = rs.getString("OP_EPISODE_VISIT_NUM");

				p_gender    =   rs.getString("gender");
				p_dob       =   rs.getString("DATE_OF_BIRTH");
			//
            locn_desc   = rs.getString("LOCN_DESC");  
			   
            locn_type_desc  = rs.getString("locn_type_desc");
			if(locn_type_desc.equals("C"))
				locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			else if(locn_type_desc.equals("E"))
				locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
			else if(locn_type_desc.equals("D"))
				locn_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
            else if(locn_type_desc == null) locn_type_desc = "";

			            
            cur_service_code = rs.getString("cur_service_code");
		    if(cur_service_code == null ) cur_service_code = "";
            
            service_desc    = rs.getString("service_desc");
            if(service_desc == null) service_desc = "";         
            
            subservice_desc    = rs.getString("subservice_desc");
            if(subservice_desc == null) subservice_desc = "";         

            pract_name  = rs.getString("pract_name");
            if(pract_name == null) pract_name = "";
            
            visit_type_desc = rs.getString("visit_type_desc");   
            if(visit_type_desc == null) visit_type_desc = "";
            
            cur_locn_code   = rs.getString("cur_locn_code");
			
		    if(cur_locn_code == null) cur_locn_code = "";
            
            cur_locn_type   = rs.getString("cur_locn_type");
		    if(cur_locn_type == null) cur_locn_type = "";

			asn_care_locn_type= cur_locn_type;
            
            cur_room_num=rs.getString("room_num");
            if(cur_room_num == null) cur_room_num="";
             
            cur_pract_type     = rs.getString("cur_pract_type");
		    if((cur_pract_type == null) || (cur_pract_type.equals("?"))) cur_pract_type = ""; 
			
		    cur_pract_type_desc     = rs.getString("pract_type_desc");
            if(cur_pract_type_desc == null) cur_pract_type_desc = "";

			cur_visit_type_ind = rs.getString("cur_visit_type_ind");
            if(cur_visit_type_ind == null) cur_visit_type_ind = "";
            
            visit_adm_type_ind=cur_visit_type_ind;

			visit_desc     = rs.getString("visit_desc");
            if(visit_desc == null) visit_desc = "";
            
            visit_type_code =  rs.getString("visit_type_code");
             if(visit_type_code == null) visit_type_code = "";         
           
			care_locn_type_ind=cur_locn_type;
			resource_class=rs.getString("resclass");
			if(resource_class == null) resource_class="";
			
			resource_type=rs.getString("restype");
			if(resource_type == null) resource_type="";

			if(resource_type == null) resource_type="";		

			other_res_class=rs.getString("OTHER_RES_CLASS");
			if(other_res_class == null) other_res_class="";

			other_res_id=rs.getString("other_resource_id");
			if(other_res_id == null) other_res_id="";

			if(other_res_class.equals("E"))
			res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			else if(other_res_class.equals("O"))
		   res_class_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");

			other_res_desc=rs.getString("OTHER_RESOURCE_DESC");
			if(other_res_desc == null) other_res_desc="";

			if(!other_res_id.equals(""))
				res_tot=res_class_desc+"/"+other_res_desc;
			else
				res_tot=res_class_desc;

			queue_id=rs.getString("QUEUE_ID");
			if(queue_id == null) queue_id="";
            
            p_cur_practitioner_id = rs.getString("cur_practitioner_id");
             if(p_cur_practitioner_id == null) p_cur_practitioner_id ="";
             
            p_cur_open_to_all_pract_yn = rs.getString("cur_open_to_all_pract_yn");			
             if(p_cur_open_to_all_pract_yn == null) p_cur_open_to_all_pract_yn ="";
             
            p_cur_visit_type_code = rs.getString("p_cur_visit_type_code") ;
             if(p_cur_visit_type_code == null) p_cur_visit_type_code ="";             
            
             
	        subservice_code = rs.getString("subservice_code") ;
             if(subservice_code == null) subservice_code = "";
             
            visit_case = rs.getString("visit_case") ;
             if(visit_case == null) visit_case = "";            

			contact_reason_code = rs.getString("contact_reason_code");
					
    		if(contact_reason_code == null || contact_reason_code.equals("null")) 
				contact_reason_code = "";
			
			/*Added by Ashwini on 08-Nov-2018 for ML-MMOH-CRF-1114*/
			other_reason_remarks = rs.getString("other_reason_remarks");
    		if(other_reason_remarks == null || other_reason_remarks.equals("null")) 
			other_reason_remarks = "";

			revise_visit_remarks = rs.getString("revise_visit_remarks");
    		if(revise_visit_remarks == null || revise_visit_remarks.equals("null")) 
			revise_visit_remarks = "";
			/*End ML-MMOH-CRF-1114*/

			revise_reason_code=rs.getString("revise_reason_code");
			if(revise_reason_code == null || revise_reason_code.equals("null")) 
				revise_reason_code = "";
			
			resource_class = rs.getString("primary_resource_class");
			practitionerMandatory = rs.getString("ident_at_checkin");
			allow_referral_yn = rs.getString("allow_referral_yn");
			entitlement_by_pat_cat_yn = rs.getString("entitlement_by_pat_cat_yn");

			if(resource_class == null) resource_class="";
			if(allow_referral_yn == null) allow_referral_yn="";
			if(practitionerMandatory == null) practitionerMandatory="";
			if(entitlement_by_pat_cat_yn == null) entitlement_by_pat_cat_yn="";

         //}  
    }    
		

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	String qms_interfaced_yn=eOP.QMSInterface.isClinicQMSInterfaced(cur_locn_code,facilityid,con);
	/* 
	   try
		{
		   pstmt=con.prepareStatement("select PRIMARY_RESOURCE_CLASS,IDENT_AT_CHECKIN,ALLOW_REFERRAL_YN from op_clinic where facility_id='"+facilityid+"' and clinic_code='"+cur_locn_code+"' ");
		   
		   rs=pstmt.executeQuery();
		   if(rs != null)
			{
			   if(rs.next())
				{
					resource_class=rs.getString(1);
					practitionerMandatory=rs.getString(2);
					allow_referral_yn=rs.getString(3);
					if(resource_class == null) resource_class="";
					if(allow_referral_yn == null) allow_referral_yn="";
				}
			}
			
		   if(rs != null) rs.close();
		   if(pstmt != null) pstmt.close();

		  
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	*/
		
	if(!allow_referral_yn.equals("Y"))
		disableReferral = "disabled";
   
	/** Populate the Visit adm type desc**/

    if(cur_visit_type_ind.equals("F"))
		asn_visit_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.first.label","common_labels");
	else if(cur_visit_type_ind.equals("L"))
		asn_visit_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.followup.label","common_labels");
	else if(cur_visit_type_ind.equals("R"))
		asn_visit_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
	else if(cur_visit_type_ind.equals("E"))
		asn_visit_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
	else if(cur_visit_type_ind.equals("S"))
		asn_visit_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Series.label","common_labels");
	else if(cur_visit_type_ind.equals("C"))
		asn_visit_type_ind_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ReferralfoConsult.label","op_labels");

   if(!referral_id.equals(""))
     {
        //String from="FROM";
        String sql1 = "select  GET_REFERRAL_DETAIL_LINE('"+referral_id+"', 'FROM','"+locale+"') from dual " ;	
        String check="";
        Statement cs = null ;
		ResultSet csrs=null;
        try
         {
			cs = con.createStatement() ;
			csrs=cs.executeQuery(sql1) ;
			if(csrs!=null)
			{
				while(csrs.next())
				{
					check=csrs.getString(1).substring(0,13);
					if(check.equals("ORACLE__ERROR") || check.equals("NO_DATA_FOUND"))
					referral_details="";
					else referral_details=csrs.getString(1).substring(2,csrs.getString(1).length());

				}
                }
              
				if(csrs!=null)  csrs.close();
				if(cs != null)  cs.close() ;
			
			}
          catch(Exception e) { 
			  out.println("Exception in Stored proc="+e.toString());
			  e.printStackTrace();
			  }
           
        }
		

            _bw.write(_wl_block8Bytes, _wl_block8);
       
	    if(!q_appt_ref_no.equals(""))
         {
	
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block11Bytes, _wl_block11);
	
         }
	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( queue_status ));
            _bw.write(_wl_block14Bytes, _wl_block14);

      
	  if(referral_details!=null && !(referral_details.equals(""))) {
			
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(referral_details));
            _bw.write(_wl_block17Bytes, _wl_block17);

			 }
	     
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

		  int ins_count = eMP.MPCommonBean.getInsuranceCount(con,l_encounter_id,patient_id);
		  
		  if(isInvokeUploadDocAppl && ins_count > 0){
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(locn_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(locn_type_desc));
            _bw.write(_wl_block28Bytes, _wl_block28);
         
	
	try
	{
		
        locsql.append(" SELECT a.clinic_code ass_clinic_code, a.clinic_type ,c.short_desc ass_clinic_type,a.long_desc short_desc  , a.speciality_code ass_speciality_code,a.open_to_all_pract_yn open_to_all_pract_yn,a.pract_type pract_type,a.ident_at_checkin ident_at_checkin FROM op_clinic_lang_vw a,(SELECT day_no FROM sm_day_of_week WHERE day_of_week = RTRIM(TO_CHAR(SYSDATE,'DAY'))  ) b,am_care_locn_type_lang_vw c WHERE a.LANGUAGE_id='"+locale+"' AND c.language_id='"+locale+"' AND ");

		if(!appt_case.equals("Y") && q_appt_ref_no.equals(""))
		{
		locsql.append(" DECODE(b.day_no,'1',working_day_1,'2',working_day_2,'3',working_day_3,'4', working_day_4,'5',working_day_5,'6',working_day_6,'7',working_day_7)='Y' AND ");
		}

		locsql.append("level_of_care_ind = 'A' AND allow_visit_regn_yn='Y' AND eff_status='E' AND UPPER(clinic_type) IN (SELECT    locn_type FROM am_care_locn_type WHERE care_locn_type_ind='"+care_locn_type_ind+"') AND ((age_group_code IS NULL) OR (age_group_code IS NOT NULL)     AND EXISTS (SELECT age_group_code FROM am_age_group WHERE   age_group_code=a.age_group_code AND NVL(gender,'"+care_locn_type_ind+"') = '"+p_gender+"'      AND TO_DATE(TO_CHAR(SYSDATE,'dd/mm/yyyy'),'dd/mm/yyyy') - TO_DATE('"+p_dob+"','dd/mm/yyyy') BETWEEN DECODE(age_unit,'Y',365,'M',30,1)*min_age AND DECODE(age_unit,'Y',365,'M',30,1)*max_age AND eff_status='E')) AND facility_id = '"+facilityid+"' AND a.CLINIC_CODE IN (SELECT CLINIC_CODE FROM OP_CLINIC WHERE FACILITY_ID = '"+facilityid+"' AND SERVICE_CODE = '"+cur_service_code+"' UNION SELECT    CLINIC_CODE  FROM OP_CLINIC_FOR_SERVICE WHERE FACILITY_ID = '"+facilityid+"' AND SERVICE_CODE = '"+cur_service_code+"') AND c.locn_type = a.clinic_type   AND c.care_locn_type_ind = '"+care_locn_type_ind+"'  AND EXISTS (SELECT LOCN_CODE FROM AM_OS_USER_LOCN_ACCESS_VW WHERE FACILITY_ID = A.FACILITY_ID AND LOCN_CODE = A.CLINIC_CODE AND LOCN_TYPE=a.clinic_type and OPER_STN_ID = '"+oper_id+"' AND APPL_USER_ID = '"+userid+"' AND revise_visit_yn = 'Y') ORDER BY short_desc");
		
		pstmt = con.prepareStatement(locsql.toString());
		rs = pstmt.executeQuery();		
		 
        out.println("<td class='fields' width='20%'>" + "<select name='asn_locn_code' id='asn_locn_code' onChange='ChangeObj(this)' "+disableFields+" tabIndex='1'><option value='' >&nbsp;--------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"--------"); //below width changes mano

        if (rs != null)
        {
            while (rs.next())
            {
                p_clinic_code      = rs.getString("ass_clinic_code");
                p_clinic_type      = rs.getString("ass_clinic_type");
                p_clinic_type_code = rs.getString("clinic_type");
                p_clinic_desc      = rs.getString("short_desc");
				p_open_to_all_pract_yn = rs.getString("open_to_all_pract_yn");
				p_speciality_code=rs.getString("ass_speciality_code");
				
				//practitionerMandatory = rs.getString("ident_at_checkin");

	            constr = p_clinic_code +"|"+p_clinic_type+"|"+p_clinic_type_code+"|"+p_open_to_all_pract_yn+"|"+p_speciality_code;

                if (p_clinic_code.equals(cur_locn_code))
                {
                    out.println("<option value='"+constr+"' selected>"+p_clinic_desc);
                   
                }
                else
                {
                    out.println("<option value='"+constr+"'>"+p_clinic_desc);
                }
				 
             }			
			 
			
			 
			    out.println("</select><img src='../../eCommon/images/mandatory.gif'></td>");
				
				
				if(!cur_room_num.equals("*ALL") && status.equals("04")) {
					disableRoom = "disabled";
				}
                				
				out.println("<td class='QUERYDATA' id='asn_care_locn_text' width='30%' nowrap>"+locn_type_desc+"</td></tr>"); //below changes mano
				//out.println("<tr><td colspan='4' nowrap>&nbsp;</td></tr>");
                /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
				out.println("<tr><td class='label' nowrap width='25%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+"</td>");
				/*CRF end SS-CRF-0010 [IN034516]*/
				
                out.println("<td width='30%'></td><td colspan=2 class='fields' id='room_value' width='45%' ><select name='Room_numsel' id='Room_numsel' onChange='setroomno()' tabIndex='2' "+disableRoom+"><option value=''>&nbsp;-------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --------&nbsp;");
				/* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
				sql="select a.practitioner_id ROOM_NO,am_get_desc.am_facility_room (a.facility_id, a.practitioner_id,'"+locale+"', 2) room_desc  from op_pract_for_clinic a where facility_id='"+facilityid+"' and clinic_code='"+cur_locn_code+"' and eff_status='E' and resource_class='R' order by practitioner_id";
				/*CRF end SS-CRF-0010 [IN034516]*/
				pstmt1 = con.prepareStatement(sql);
				rs1=pstmt1.executeQuery();
		
				boolean flagvalue=false;
				while(rs1.next())
				{flagvalue=true;
					roomnum=rs1.getString(1);
					/* Below line added by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */
					room_desc=rs1.getString("room_desc");
					/*CRF end SS-CRF-0010 [IN034516]*/


				   /* Below line modified by Venkatesh.S (4008) on 18-Oct-2012 against crf SS-CRF-0010 [IN034516] */				
					if(cur_room_num != "" && roomnum.equals(cur_room_num))
					{
					 out.println("<option value='"+roomnum+"' selected>"+roomnum+" "+room_desc);
					}	 
					else
					{
						out.println("<option value='"+roomnum+"' >"+roomnum+" "+room_desc);
					}	
                    /*CRF end SS-CRF-0010 [IN034516]*/					
				}
			
				if(flagvalue)
			{
				out.println("</select><img src='../../eCommon/images/mandatory.gif'>");
			}
			  else
			{
			cur_room_num="NoRoom";
			out.println("</select>");
			}
			  
			  
			
		if(rs1 != null) rs1.close();
		if(pstmt1 != null) pstmt1.close();
		
		}
       if(rs!=null)rs.close();
	   if(pstmt!=null) pstmt.close();
	   locsql.setLength(0);
	 }catch (Exception e)
				{
					e.printStackTrace();
				}

            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(visit_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(asn_visit_type_ind_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(visit_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(subservice_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disableFields));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);

			   //subServiceSQL = "select subservice_code, short_desc from am_subservice where service_code = ? and eff_status = 'E' order by 2";

			  			   subServiceSQL = "select subservice_code, short_desc from am_subservice_lang_vw where language_id='"+locale+"' and service_code = ? and eff_status = 'E' order by 2";

		   subServiceStatement = con.prepareStatement(subServiceSQL);
		   subServiceStatement.setString(1,cur_service_code);		   
		   subServiceResult = subServiceStatement.executeQuery();

		   
		   if(subServiceResult!=null)
		   {
			   while(subServiceResult.next())
			   {
				   subService = subServiceResult.getString("short_desc");
				   subServiceCode=subServiceResult.getString("subservice_code");
				   
				   if(subService!=null)
				   {
					   out.println("<option value = '"+subServiceCode+"' ");
					   if(subServiceCode.equals(subservice_code))
					      out.println("selected");

					   out.println(">"+subService);
				   }
			   }
		   }
		   
		   if(subServiceResult != null) subServiceResult.close();
		   if(subServiceStatement != null) subServiceStatement.close();
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block43Bytes, _wl_block43);

		if(practitionerMandatory == null)
			practitionerMandatory = "X";

		
		String practitionerMandatoryGIFStatus = null;
		char identifyPractitionerAtCheckIn = 'Y';
		
		if(practitionerMandatory.equalsIgnoreCase("P")&& (!resource_class.equals("R")))
		{
			practitionerMandatoryGIFStatus = "visible";
			identifyPractitionerAtCheckIn = 'Y';
		}
		else
		{
			practitionerMandatoryGIFStatus = "hidden";
			identifyPractitionerAtCheckIn = 'N';
		}
			
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disableFields));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disableFields));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(practitionerMandatoryGIFStatus));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(p_cur_practitioner_id));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(res_tot));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(disableFields));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
if(other_res_class.equals("E")){
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
}else if(other_res_class.equals("O")){
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
}else{
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(other_res_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disableFields));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(disableFields));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(other_res_id));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disableReferral));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(disableReferral));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(last_visit_num));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(last_visit_num));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
   
         if(!contact_reason_code.equals(""))
         {
            //pstmt   = con.prepareStatement( "select contact_reason_code,contact_reason from am_contact_reason where contact_reason_code = '"+contact_reason_code+"'") ;

			pstmt   = con.prepareStatement( "select contact_reason_code,contact_reason from am_contact_reason_lang_vw  where contact_reason_code = '"+contact_reason_code+"' and language_id='"+locale+"'") ;

			rs = pstmt.executeQuery();
            if( rs != null )
            {
              while( rs.next() )
              {
               if(contact_reason_code.equals(rs.getString(1)))
				  {
			   
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block73Bytes, _wl_block73);

				  }
              }
          }
         if(rs!=null)rs.close();
	     if(pstmt!=null) pstmt.close();
		 out.println("</td>");
         }
		 else{	 
			out.println("<td colspan='3'></td>");
		 }
	 
            _bw.write(_wl_block74Bytes, _wl_block74);
if(!other_reason_remarks.equals(""))
		{
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(other_reason_remarks));
            _bw.write(_wl_block77Bytes, _wl_block77);
}
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
               
            //pstmt   = con.prepareStatement( "select contact_reason_code,contact_reason from am_contact_reason where nvl(revise_visit_yn,'N') = 'Y' and eff_status='E' order by contact_reason" ) ;

			pstmt   = con.prepareStatement("Select contact_reason_code,contact_reason from am_contact_reason_lang_vw where nvl(revise_visit_yn,'N') = 'Y' and eff_status='E' and language_id='"+locale+"' order by contact_reason" ) ;

            rs = pstmt.executeQuery();
            if( rs != null )
             {
			  while( rs.next() )
			  {                      
				String Value  = rs.getString("contact_reason_code");
				String Label  = rs.getString("contact_reason");
				
				if(revise_reason_code.equals(Value))
				  {
					
					out.println( "<option value='" + Value + "' selected>" + Label);
				  }
				  else
				  {
						 out.println( "<option value='" + Value + "' >" + Label );    
				  }           
			   }
              }
			if(rs!=null)rs.close();
	        if(pstmt!=null) pstmt.close();

            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(revise_visit_remarks));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf( q_appt_ref_no ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf( queue_status ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( cur_locn_code ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf( locn_desc ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf( cur_locn_type ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf( locn_type_desc ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf( asn_care_locn_type ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(cur_specialty_code));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(cur_room_num));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(cur_room_num));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( p_cur_visit_type_code ));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf( visit_desc ));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf( cur_visit_type_ind ));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf( cur_service_code ));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf( service_desc ));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf( subservice_code ));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf( pract_name ));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf( cur_pract_type ));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf( p_cur_practitioner_id ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(p_clinic_type));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(p_clinic_code));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(p_visit_type_code));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(p_visit_type_short_desc));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf( visit_adm_type_ind ));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(visit_case));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(practitionerMandatory));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(visit_type_code));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(episodeReqd));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(last_visit_num));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(cur_visit_type_ind));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(userid));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(assign_q_num_by));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(l_encounter_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(visit_adm_date_time));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(bl_install_yn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(cur_service_code));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(identifyPractitionerAtCheckIn));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(resource_type));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf( cur_locn_code ));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf( cur_service_code ));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(arrive_date_time));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(vital_signs_date_time));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(resource_class));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(other_res_id));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(p_cur_open_to_all_pract_yn));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(status));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(qms_interfaced_yn));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(others_id));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(contact_reason_code));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(other_reason_remarks));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(Sysdate));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(action_on_pract_schedule ));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(p_cur_practitioner_id));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf( isQMSapplicable));
            _bw.write(_wl_block151Bytes, _wl_block151);

if (bl_interface_yn.equals("Y"))
     {

            _bw.write(_wl_block1Bytes, _wl_block1);
            {java.lang.String __page ="../../eBL/jsp/BLFinDetHiddenFlds.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf(patient_id
                        )},{ weblogic.utils.StringUtils.valueOf("episode"), weblogic.utils.StringUtils.valueOf(episode_id
                        )},{ weblogic.utils.StringUtils.valueOf("record"), weblogic.utils.StringUtils.valueOf(record
                        )},{ weblogic.utils.StringUtils.valueOf("calling_module"), weblogic.utils.StringUtils.valueOf("OP")},{ weblogic.utils.StringUtils.valueOf("episode_type"), weblogic.utils.StringUtils.valueOf("O")},{ weblogic.utils.StringUtils.valueOf("calling_function_id"), weblogic.utils.StringUtils.valueOf("REVISE_VISIT")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block1Bytes, _wl_block1);

	}
    
 
     if (bl_interface_yn.equals("Y"))
     {      
            out.println("<input type='hidden' name='process_flag' id='process_flag' value=''>");      
     }
     
if(pstmt != null) pstmt.close();
if(rs != null) rs.close();

}catch(Exception e ){
	out.println("Errors encountered 2" + e.toString());
	e.printStackTrace();
	}
finally
{
	
	if(con!=null)
        ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block152Bytes, _wl_block152);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraldetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.CurrentVisit.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReviseVisit.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.UploadInsDoc.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.subservice.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.OtherResource.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.NewEpisode.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.EpisodeNoVisitNo.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForContact.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.ReasonForReviseVisit.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueNo.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }
}
