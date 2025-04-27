package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import javax.servlet.http.*;
import org.json.simple.*;
import javax.servlet.jsp.JspWriter;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __regpatreferralmainpage1_new extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/RegPatReferralMainPage1_new.jsp", 1742454077939L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n<html>\n<head>\n\t<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></SCRIPT>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></SCRIPT>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eMP/js/RegPatReferral.js\' language=\'javascript\'></script>\t\n\t<script src=\'../../eMP/js/RegPatReferral1.js\' language=\'javascript\'></script>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\t\n\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></SCRIPT>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n// Added on 24/12/2009 by Muthu against IN017559\nfunction invokeTab(objName)\n    {\n        // FIRST CHANGE THE CURRENT SELECTED TAB \n\t\tselectTab(objName);\t\t\n\t\tgoToTab(objName); \t\t\n    }\n\n\tfunction goToTab(objName)\n    {\n        \t\t\n\t\tif(objName == \'ReferredFrom_a\') { \n\t\t\tdocument.getElementById(\'referred_from\').style.display = \'inline\';\n\t\t\tdocument.getElementById(\'referred_to\').style.display = \'none\'; \t\t\t\t\t\t\t\t\t\n\t\t} else if(objName == \'ReferredTo_a\') {\t\t\t\n\t\t\tdocument.getElementById(\'referred_from\').style.display = \'none\';\n\t\t\tdocument.getElementById(\'referred_to\').style.display = \'inline\';\t\t\t\t\t\n\t\t} \t\t\n\t}\n// End of Comment\nfunction tab_click1(id,id1){\n\t\n\t//selectTab(id1);\n\tif(id==\'1\')\n\t{\n\t\t\tdocument.getElementById(\'mother_tab\').style.visibility=\'hidden\'\n\t\t\tdocument.getElementById(\'first\').style.visibility=\'visible\'\n\t\t\tdocument.getElementById(\'referred_from1\').scrollIntoView();\n\t\t\t//alert(document.getElementById(\'ref_letter_no\').disabled);\n\t\t\tif(document.forms[0].referral_type.value == \'L\')\n\t\t\t{\n\t\t\tdocument.getElementById(\'b_pract\').disabled=false;\n\t\t\t}\n\t\t\tif(document.getElementById(\'ref_letter_no\').disabled == false)\n\t\t\tdocument.getElementById(\'ref_letter_no\').focus();\n\t\t\t\n\t\t\n\t}\n\telse if(id==\'2\')\n\t{\n\t\t\tdocument.getElementById(\'mother_tab\').style.visibility=\'visible\'\n\t\t\tdocument.getElementById(\'first\').style.visibility=\'hidden\'\n\t\t\t//document.getElementById(\'b_pract\').disabled=true;\n\t\t\tdocument.getElementById(\'referredto1\').scrollIntoView();\n\t\t\tif(document.getElementById(\"to_speciality_code\").disabled == false)\n\t\t\tdocument.getElementById(\"to_speciality_code\").focus();\n\t\t   \n\t\t\t\n\t}\n\t\n\t\n\t        }\n\n\n\t\t\t\n</script>\n<script>\n\n</script>\n\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<!--defaultLoginFacility() Added by Dharma on 11th Feb 2016 against ML-MMOH-CRF-0340 [IN057178]-->\n\t<!--reftype() Added by Afruddin on 28-jun-2020 for ML-MMOH-CRF-1527 US3 -->\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown =\'lockKey()\' onload=\'chkforref();";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="defaultLoginFacility();";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="reftype();";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onSelect = \"resMove()\">\n\t\t\n\n\t\n\t\n\t  <form name=\"RegPatReferral_form\" id=\"RegPatReferral_form\" action=\"../../servlet/eMP.RegPatReferralServlet\" target=messageFrame method=post>\n\t   <div id = \'referred_from\'>\n\t\t\t<input type=\'hidden\' name=\'ct_tab_name\' id=\'ct_tab_name\' >\n\t\t\t<a name=\'firstanc\' id=\'firstanc\'></a>\n\t\t\t<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'REGISTER_PAT_REFERRAL\'>\n\t\t\t<a name=\'fromref\' id=\'fromref\' ></a>\n\t\t\t\n\t  \n\t    <ul id=\"tablist\" class=\"tablist\" style=\"padding-left:0px\" >\n\t   <li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t  <a onclick=\"invokeTab(\'ReferredFrom_a\')\" class=\"tabClicked\" id=\"ReferredFrom_a\" >\n\t\t  <span class=\"tabSpanclicked\" id=\"ReferredFrom_aspan\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span>\n\t\t  </a>\n\t  </li>\n\t   <li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t       <a onclick=\"invokeTab(\'ReferredTo_a\')\" class=\"tabA\" id=\"ReferredTo_a\" >\n\t        <span class=\"tabAspan\" id=\"ReferredTo_aspan\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</span>\n\t\t\t</a>\n\t\t</li>\n       </ul>\n\t\n\t  <table cellpadding=\'1\' cellspacing=0 border=0 width=\"100%\" id=\'first\'>\n\t\t\t<tr>\n\t\t\t<td  class=\'COLUMNHEADER\' colspan=6>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </td>\n\t\t\t<tr>\n\t\t\t\t\t<td align=\'left\' class=LABEL  >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t<td class=\'FIELDS\' >\n\t\t\t\t\t<input type=\"text\" name=\"ref_letter_no\" id=\"ref_letter_no\"  onBlur = \'makeValidString(this);\' onKeyPress=\'return CheckForSpecChars1(event)\' size=15 maxlength=30 tabIndex=\'1\' >\n\t\t\t\t\t</td>\n\t\t\t\t\t<td align=\'left\' class=\'label\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  class=\'FIELDS\' >\n\t\t\t\t\t<input type=\"text\" id=\"received_date\" name=\"received_date\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  size=14 maxlength=16 onBlur=\"javascript:return validateDates(this,\'RE\');\" tabIndex=\'2\'><input type=\'image\' name= \"recd\" id= \"recd\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return  showCalendar(\'received_date\',null,\'hh:mm\');\" ><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'left\'  class=\'label\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'FIELDS\' ><input type=\"text\"  name=\"referral_date\" id=\"referral_date\" size=14 maxlength=16 value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" onBlur=\"javascript:return validateDates(this,\'R\')\" tabIndex=\'3\' ><input type=\'image\' name= \"red\" id= \"red\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'referral_date\',null,\'hh:mm\');\" ><img align=\'center\' src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\n\t\t\t\t\t<td align=\'left\'  class=\'label\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t<td class=\'FIELDS\'>\n\t\t\t\t\t\t<input type=\"text\" id=\"preferred_date\" name=\"preferred_date\"  size=10 maxlength=10 onBlur=\"javascript:return validateDates(this,\'P\')\" tabIndex=\'4\'><input type=\'image\' name= \"pred\" id= \"pred\" src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'preferred_date\');\"  ></img></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\t\n\t\t\t\t\t<td align=left class=LABEL  width=\'195pt\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t<td width=\'299pt\' class=\'FIELDS\'><input type=\'text\' name=\'referral_reason_desc\' id=\'referral_reason_desc\' onBlur =\'getReasonForRefblur(document.getElementById(\"refReason\"));\'  size=30 maxlength=30 value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" tabIndex=\'5\'><input type=\'button\' class=\'button\' name=\'ref_reason\' id=\'ref_reason\' value=\'?\' id = \'refReason\' onclick=\"getReasonForRef(this);\" ><input type=\'hidden\' name=\'referral_reason_code\' id=\'referral_reason_code\'  value=\"\"></td>\n\t\t\t\t\t\n\t\t\t\t\t<td align=left class=LABEL width=\'243pt\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t<td class=\'FIELDS\' >\n\t\t\t\t\t      <!-- Below line modified by Afruddin for ML-MMOH-CRF-1527 US3 -->\n\t\t\t\t\t\t<select name=\"referral_type\" id=\"referral_type\" onchange=\'getval3(this);";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="reftypechange();";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' tabIndex=\'6\'>\t\n\t\t\t\t\t\t\t<option value=\'\'>-----------";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="-----------</option>\n\t\t\t\t\t\t\t<option value=\'L\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</option>\n\t\t\t\t\t\t\t<option value=\'E\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\n\t\t\t\t\t\t\t<option value=\'X\'>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</option>\t\t\n\t\t\t\t\t\t</select><img id=id1 src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t</td>\n\t\t\t\t    \n\t\t\t\t\t <!-- Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020 -->\n\t\t\t\t\t \n\t\t\t\t\t ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t  <td align=left class=\'label\' id= \'transfer_case\' nowrap >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t         <input type=\'checkbox\'  name=\'transfer_case_yn\' id=\'transfer_case_yn\'value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" onclick=\'ChangeState(this)\' ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =">\n                      </td>\n\t\t\t\t\t ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t<!-- Ended by Afruddin for ML-MMOH-CRF-1527 US3 on 28-jun-2020-->\n                     </tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=left class=LABEL  >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t\t<td  class=\'FIELDS\'>\n\t\t\t\t\t\t<select name=\"hcare_type\" id=\"hcare_type\" onchange=\'getval3(this)\' tabIndex=\'7\'>\n\t\t\t\t\t\t\t<option value=\'\'>-----------";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="-----------</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\t\n\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t</select><img align=center src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t  <!--Legend name  modified  for PMG2014-CRF-0007 [IN:046756] -->\n\t\t\t\t\t\t\t\t\t<td  align=left class=LABEL >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t\t<td  class=\'FIELDS\' >\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'text\' name=\'referral_source\' id=\'referral_source\' size=\'25\' maxlength=\"15\" onBlur =\'clear_ref();\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"><input type=\'button\' class=\'button\' name=\'referral_source_lkp_but\' id=\'referral_source_lkp_but\' value=\'?\' onClick=\"referralSourceLookup(this)\" >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="<img src=\'../../eCommon/images/more.gif\' name=\"lng_name\" id=\"lng_name\" align=center style=\"visibility:hidden\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="<img src=\'../../eCommon/images/more.gif\' name=\"lng_name\" id=\"lng_name\" align=center alt=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'referral_source_lkp_bkup_text\' id=\'referral_source_lkp_bkup_text\' size=\'15\' maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'referral_source_lkp_id\' id=\'referral_source_lkp_id\' size=\'5\' maxlength=\"15\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=left class=LABEL>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t\t\t\t<td class=\'FIELDS\'>\n\t\t\t\t\t\t<select name=\'speciality\' id=\'speciality\' onchange=\'clearLocationList(this);\' tabIndex=\'9\'>\n\t\t\t\t\t\t\t<option value=\'\'>-----------";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="-----------</option>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t</select></td>\n\t\t\t\t\t<td align=\'right\'colspan=2>\n                      <input type=\'button\' style=\'width:78pt\'class=\'button\' name=\'clinical_details\' id=\'clinical_details\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' onclick=\"Modal_Clinical_Details(this,\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\',\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\');\" tabIndex=\'16\'><input type=\'hidden\' name = \'from_practitioner\' id = \'from_practitioner\' value=\"\"><!-- </td><td align=\'left\'> --><input type=\"button\" style=\'width:40pt\' class=BUTTON value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'onClick=\"javascript:showTextArea(\'referral_notes\',\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\')\" tabIndex=\'17\'>   \n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<!--Added \'id\' for incident IN023039 by Suresh M on 24.08.2010 -->\n\t\t\t\t\t<td  id = \'E_locationtype\' class=LABEL>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t<td  id =\'E_location\' class=\'FIELDS\' >\n\t\t\t\t\t\t\t<select name=location0 id=location0  onchange=\'clear_location(this)\' tabIndex=\'10\'>\n\t\t\t\t\t\t\t\t<option value=\'\'>-----------";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="-----------</option>    \n\t\t\t\t\t\t\t</select></td><td class=label id=\'enew_location1\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td><td   colspan=1  id =\'Enew_location\' >\n\t\t\t\t\t\t\t<select name=\"from_locn\" id=\"from_locn\" onChange=\'clear_pract(this)\' tabIndex=\'11\'>\n\t\t\t\t\t\t\t\t<option value=\'\'>-----------";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="-----------</option>\n\t\t\t\t\t\t\t</select></td>\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t<td  id =\'E_location\' class=\'FIELDS\'  >\n\t\t\t\t\t\t\t\t<input type=\'text\' name=\'from_locn\' id=\'from_locn\' size=30 maxlength=30 onBlur = \'makeValidString(this)\' tabIndex=\'11\'></td> \n\t\t\t\t\t\t\t\t<td class=label id=\'enew_location1\'></td><td  id =\'Enew_location\' class=\'FIELDS\'></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t<td  id =\'E_location\' class=\'FIELDS\' >\n\t\t\t\t\t\t\t\t<select name=location0 id=location0 onchange=\'clear_location(this)\' tabIndex=\'10\'><option value=\'\'>-----------";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="-----------</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t</select></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t <td class=label id=\'enew_location1\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td><td  id =\'Enew_location\' class=\'FIELDS\'><select name=from_locn onChange=\'clear_pract(this)\'><option value=\'\'>-----------";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n           \n\t\t\t\t\t</td>\t\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td align=left class=LABEL >";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n\t\t\t\t\t\n\t\t\t\t\t<td  class=\'FIELDS\' >\t\t\n\t\t\t\t\t<input type=\'text\' name=\'from_practitioner_id\' id=\'from_practitioner_id\' onchange=\"disable_ext_pract(this);\" onBlur = \"makeValidString(this);chg_pract(this);onBlurCallPractitionerSearch(document.forms[0].b_pract,document.forms[0].from_practitioner_id);disable_ext_pract(this);\" tabIndex=\'12\' size=25 maxlength=30><input type=\'button\' class=\'button\' name=\'b_pract\' id=\'b_pract\' value=\'?\' onclick=\"callPractSearch(this,document.forms[0].from_practitioner_id);\" >\n\n\n\t\t\t\t\t <input type=\'text\' name=\'from_ext_practitioner_id\' id=\'from_ext_practitioner_id\' onchange=\"disable_pract(this);\"  onBlur = \"disable_pract(this);\" tabIndex=\'12\' size=25 maxlength=30 id = \'pract_ext_name\' style = \'display:none\'>\n\t\t\t\t\t</td>\t\n\n\t\t\t\t\t<td align=\'left\' class=\'label\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'FIELDS\' >\n\t\t\t\t\t<input type=\"text\" id=\"\" name=\"tel_no\" id=\"tel_no\" size=10 maxlength=18 onKeyPress=\'return CheckForSpecChars1(event)\' onBlur = \'makeValidString(this);\' tabIndex=\'13\'>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\t\n\t\t\t\t\t<td class=label>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'FIELDS\'>\t\n\t\t\t\t\t<input type=\"text\" id=\"\" name=\"mobile_no\" id=\"mobile_no\" onKeyPress=\'return CheckForSpecChars1(event)\' onKeyPress=\'return CheckForSpecChars(event)\' size=10 maxlength=18 onBlur = \'makeValidString(this);\' tabIndex=\'14\' >\n\t\t\t\t\t</td>\t\n\t\t\t\t\t<td class=label>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" \n\t\t\t\t\t</td><td  class=\'FIELDS\' >\t\n\t\t\t\t\t<input type=\"text\" id=\"\" name=\"pager_no\" id=\"pager_no\" size=10 maxlength=18 onKeyPress=\'return CheckForSpecChars1(event)\' onBlur = \'makeValidString(this);if(document.getElementById(\'ref_letter_no\')){document.getElementById(\'ref_letter_no\').focus();}\' tabIndex=\'15\'>\n\t\t\t\t\t</td>\t\n\t\t\t\t\t</tr>\n\t\t\t\t\n\t\t </table>\n\t\t</div>\n\n\t\t <div id = \'referred_to\' style = \'display:none\'> \n\t\t\n\t\t <ul id=\"tablist\" class=\"tablist\" style=\"padding-left:0px\">\n\t     <li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t\t  <a onclick=\"invokeTab(\'ReferredFrom_a\')\" class=\"tabA\" id=\"ReferredFrom_b\" >\n\t\t  <span class=\"tabAspan\" id=\"ReferredFrom_bspan\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</span>\n\t\t  </a>\n\t     </li>\n\t   <li class=\"tablistitem\" title=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n\t       <a onclick=\"invokeTab(\'ReferredTo_a\')\" class=\"tabClicked\" id=\"ReferredTo_b\" >\n\t        <span class=\"tabSpanclicked\" id=\"ReferredTo_bspan\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</span>\n\t\t\t</a>\n\t\t</li>\n        </ul>\t\n\t\t<table id=\'mother_tab\' width=\"100%\" cellpadding=2 cellspacing=0 border=0 >\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=\'COLUMNHEADER\' colspan=4>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t<td  align=left class=LABEL  width=\'20%\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t\t\t\t\t<td class=\'FIELDS\'  width=\'304pt\'>\n \t\t\t\t\t\t<select name=\"to_speciality_code\" id=\"to_speciality_code\" onChange=\"populatetolocn(this)\"  > \n\t\t\t\t\t\t\t<option value=\'\' >-----------";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t</select>\t\t\t\t\t\t\t\n\t\t\t\t\t\t<img align=center src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tdocument.forms[0].to_speciality_code.value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\";\n\t\t\t\t\t\t</script>\n\t\t\t\t\t</td>\n\t\t\t\t<td  align=left class=LABEL>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t\t\t\t<td class=\'FIELDS\'>\n\t\t\t\t\t\t<select name=\"priority\" id=\"priority\"  > \n\t\t\t\t\t\t\t<option value=\"\">-----------";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="-----------</option>\n\t\t\t\t\t\t\t<!--Added by Suji Keerthi for NMC-JD-CRF-0130-->\n                               ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\n\t\t\t\t\t\t<!--Ended by Suji Keerthi for NMC-JD-CRF-0130-->\n\t\t\t\t\t\t\t<option value=\"L\">";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</option>\n\t\t\t\t\t\t\t<option value=\"U\">";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</option>\n\t\t\t\t\t\t\t<option value=\"E\">";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\t\t<!--Added by Suji Keerthi for NMC-JD-CRF-0130-->\n\t\t\t\t\t\t</select><img align=center src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\n\t\t\n\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\n\t\t\t\t\t<td align=left class=LABEL >";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t\t\t\t<td class=\'FIELDS\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t<select name=\'locationT0\' id=\'locationT0\' onchange=\'clear_location(this)\' ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =">\n\t\t\t\t\t\t\t<option value=\'\'>-----------";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="----------- \t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\tif(parent.frames[1].document.forms[0].locationT0 != null)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tpopToLocationType(\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\');\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t</script>\n\t\t\t\t\t\t</select><img align=center src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=label>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td><td class=\'FIELDS\'   id =\'T_location\'>\n\t\t\t\t\t\t<select name=to_locn id=to_locn  onchange=\'clear_pract(this)\' ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td  align=left class=LABEL  width=\'245pt\'>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\t<!--REFERAL_REQUIRED ADDED BY SANTHOSH FOR MMS-DM-CRF-0209.4-US005-->\n\t\t\t\t\t<td class=\'FIELDS\'><INPUT TYPE=\"text\" name=\"to_service_desc\" id=\"to_service_desc\" ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\" disabled";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" onblur=\"getService1(this,\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\',to_service_code)\" size=18 ><input type=\'button\' class=\'button\'  name=\'search_service\' id=\'search_service\' value=\'?\' onclick=\"getService(to_service_desc,\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\',to_service_code);\" >\n\t\t         ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t              <input type=hidden name=\'to_service_code\' id=\'to_service_code\' ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" value=\'\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =">\n\t\t           ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t              <input type=hidden name=\'to_service_code\' id=\'to_service_code\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t\t             ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t </td>\n\t\t\t\t\t\n\t\t\t\t\t<td align=left class=LABEL>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n\t\t\t\t\t<td class=\'FIELDS\' >\n\t\t\t\t\t\t<input type=\'text\' name=\'to_practitioner_id\' id=\'to_practitioner_id\' size=30 maxlength=30 onblur=\"onBlurCallPractitionerSearch(document.forms[0].b_pract1,document.forms[0].to_practitioner_id);\" disabled><input type=\'button\' class=\'button\' name=\'b_pract1\' id=\'b_pract1\' value=\'?\' onclick=\"callPractSearch(document.forms[0].b_pract1,document.forms[0].to_practitioner_id);\" disabled><input type=\'hidden\' name = \'to_practitioner\' id = \'to_practitioner\' value=\"\">\n\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\n\t\t\n\t\n\n\t\t<tr>\t\n\t\t<td align=left class=LABEL >";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</td>\n\t\t<td class=\'FIELDS\'><input type=\'text\' align=\'left\' name=\'order_catalog_desc\' id=\'order_catalog_desc\' size=30 maxlength=30 ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="  value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' onblur=\'if(this.value !=\"\") populate_order(document.getElementById(\"catalog_but_id\"));\'><input type=\'button\' class=\'button\' value=\'?\' name=\'catalog_but\' id=\'catalog_but\' id=\'catalog_but_id\' ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="  onClick=\'populate_order(this);\' onblur=\"getFocus(\'priority\');\">\n\t\t\n\t\t<input type=\'hidden\' name=\'order_catalog\' id=\'order_catalog\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\n\t\t\t\t\n\t\t</td>\n\t\t\n\n\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t<td align=left class=LABEL ></td>\n\t\t<td> \n\t\t<input type=\'hidden\' name=\'order_catalog\' id=\'order_catalog\' value=\'\'>\n\t\t\t\t\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t<td  align=left class=LABEL >";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td>\n\t\t\t<td class=\'FIELDS\'>\n\t\t\t<select name=\"referred_for_ip\" id=\"referred_for_ip\" onblur=\"getFocus(\'refferd\')\";> \n\t\t\t<option value=\'\'>-----------";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="-----------</option>\n\t\t\t<option value=\'A\'>";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</option>\n\t\t\t<option value=\'B\'>";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</option>\n\t\t\t</select><img align=center src=\'../../eCommon/images/mandatory.gif\' name=\'refforipimg\'></img>\n\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =" \n\t\t\t\t<td class=\'COLUMNHEADER\' colspan=4>";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="/";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td>\n\t\t\t\t\n\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t<tr>\n\t<td align=\'left\' class=\'label\' >";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =" </td>\n\t<td class=\'FIELDS\' ><select name=\'action\' id=\'action\' onchange=\"clear_text(this);\" ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="><option value=\'\'>----";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="----</option>\n\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t<option value=\'RF\'>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</option>\n\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</option>\n\t<option value=\'RR\'>";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t</select>\n\t</td>\n\t<td align=\'left\' class=\'label\' >";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</td>\n\t<td class=\'FIELDS\' ><input type=\'text\' name=\'reason_txt\' id=\'reason_txt\' size=\'30\' onblur=\"if(this.value!=\'\'){populate_reason(this);}\"  maxlength=\'40 \'value=\'\' readonly><input type=\'button\' class=\'button\' name=\'reason_but\' id=\'reason_but\' value=\'?\' onclick=\"populate_reason(this,reason_txt);\" disabled></td>\n\t<input type=\'hidden\' name=\'reason_code\' id=\'reason_code\' value=\'\'>\n\t</tr>\n\t<tr>\n\t<td align=\'left\' class=\'label\' >";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</td>\n\t<td class=\'FIELDS\' ><input type=\'text\' name=\'apptNo\' id=\'apptNo\' onKeyPress=\"return CheckForSpecChars(event)\" value=\'\' size=22 maxlength=20 ></td>\n\t\n\t<td align=\'left\' class=\'label\' >";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</td>\n\t<td class=\'FIELDS\' ><input type=\'text\' name=\'remarks\' id=\'remarks\' size=35 maxlength=30 value=\'\' readonly></td>\n\t\n\t<!-- <input type=\'hidden\' name=\'apptNo\' id=\'apptNo\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'> -->\n\t</tr>\n\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t<tr><td class=\'white\'></td></tr>\n\t<tr><td class=\'white\'></td></tr>\n\t<tr><td class=\'white\'></td></tr>\n\t</table>\n    <table  cellpadding=0 cellspacing=0 border=1 width=\"100%\">\t\t\n\t<!-- <tr style=\"height:36px;\"> -->\n\t\t\n\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t<tr>\n\t\t\t<th width=\'15%\'>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</th>\n\t\t\t<th width=\'25%\'>";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</th>\n\t\t\t<th width=\'24%\'>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</th>\n\t\t\t<th width=\'8%\'>";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="</th>\n\t\t\t<th width=\'20%\'>";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</th>\t\t\t\n\t\t\t<th width=\'8%\' >";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="&nbsp;";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</th> <!-- Thursday, December 24, 2009  17559 (Venkat S) -->\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t</tr>\n\t</table>\n\t</a>\t\n\t\t<!-- added on 1/15/2004 -->\n\t\t<input type=\"hidden\" name=\"from_fac_id\" id=\"from_fac_id\" value=\"\">\t\n\t\t<input type=\"hidden\" name=\"operation_type\" id=\"operation_type\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t\t<input type=\"hidden\" name=\"facilityid\" id=\"facilityid\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\n\t\t<input type=\"hidden\" name=\"from_hcare_setting_type\" id=\"from_hcare_setting_type\" value=\"\">\t\n\t\t<input type=\'hidden\' name=\'ca_patient_id\' id=\'ca_patient_id\' value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'>\n\t\t<input type=\'hidden\' name=\'ServerDate11\' id=\'ServerDate11\' value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\'>\n\t\t<input type=\'hidden\' name=\'ServerDatetime\' id=\'ServerDatetime\' value=\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\'>\n\t\t<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'REGISTER_PAT_REFERRAL\'>\t\t\n\t\t<input type=\'hidden\' name=\'current_year\' id=\'current_year\' value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'>\n\t\t<input type=\'hidden\' name=\'facility_name\' id=\'facility_name\' value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\t\n\t\t<input type=\'hidden\' name=\'to_hcare_setting_type_code\' id=\'to_hcare_setting_type_code\' value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\t\t\n\t\t<input type = \'hidden\' name=\"referral_notes\" id=\"referral_notes\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" ></input>\n\t\t<input type = \'hidden\' name=\"other_doc_att\" id=\"other_doc_att\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" ></input>\n\t\t\t\n\t\t<!-- ***** Hidden variables for clinical details**********-->\t\t\n\n\t\t<input type = \'hidden\' name=\"exm_clinical_find\" id=\"exm_clinical_find\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\"></input>\n\t\t<input type = \'hidden\' name=\"diagnosis\" id=\"diagnosis\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\"></input>\n\t\t<input type = \'hidden\' name=\"treatment\" id=\"treatment\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\"></input>\n\n\t\t<input type=\'hidden\' name=\'calling_from\' id=\'calling_from\' value=\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'>\t\t\n\t\t<input type=\'hidden\' name=\'practitioner\' id=\'practitioner\' value=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\'>\t\t\n\t\t<input type=\'hidden\' name=\'service_code\' id=\'service_code\' value=\'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'>\t\t\n\t\t<input type=\'hidden\' name=\'referral_id\' id=\'referral_id\' value=\'\'>\t\n\t\t<input type=\'hidden\' name=\'pat_id\' id=\'pat_id\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'service1\' id=\'service1\' value=\'\'>\t\t\n\t\t<input type=\'hidden\' name=\'to_pract1\' id=\'to_pract1\' value=\'\'>\t\t\n\t\t<input type=\'hidden\' name=\'referral_source1\' id=\'referral_source1\' value=\'\'>\t\n\t\t<input type=\'hidden\' name=\'race_code1\' id=\'race_code1\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'res_class\' id=\'res_class\' value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t\t<input type=\'hidden\' name=\'concat_address_hidden\' id=\'concat_address_hidden\' value=\'\'>\t\t\n\t\t<input type=\'hidden\' name=\'concat_NatIdDetails_hidden\' id=\'concat_NatIdDetails_hidden\' value=\'\'>\t\t\n\t\t<input type=\'hidden\' name=\'p_calling_function\' id=\'p_calling_function\' value=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'>\t\n\t\t<input type=\'hidden\' name=\'ass_func_id\' id=\'ass_func_id\' value=\'";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'>\t\n\t\t<input type=\"hidden\" name=\'reason_for_ref_hid\' id=\'reason_for_ref_hid\' value =\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>\n\t\t<input type=\'hidden\' name=\'citizenvalue\' id=\'citizenvalue\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'illegalvalue\' id=\'illegalvalue\' value=\'\'>\n\t\t<!-- <input type=\'hidden\' name=\'pat_name_as_multipart_yn\' id=\'pat_name_as_multipart_yn\' value=\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' > -->\n\t\t<input type=\'hidden\' name=\'birth_place\' id=\'birth_place\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'Birth_place_code\' id=\'Birth_place_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'ethnic_group\' id=\'ethnic_group\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'place_of_birth\' id=\'place_of_birth\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'race_code\' id=\'race_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'patient_name\' id=\'patient_name\' value=\'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\'>\n\t\t\t<input type=\'hidden\' name=\'pat_name1\' id=\'pat_name1\' value=\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\'>\n\t\t<input type=\'hidden\' name=\'name_prefix1\' id=\'name_prefix1\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'first_name\' id=\'first_name\' value=\'\'>\n\n\t\t<input type=\'hidden\' name=\'second_name\' id=\'second_name\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'third_name\' id=\'third_name\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'family_name\' id=\'family_name\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'name_suffix1\' id=\'name_suffix1\' value=\'\'>\n\n\t\t<input type=\'hidden\' name=\'first_name_oth_lang\' id=\'first_name_oth_lang\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'second_name_oth_lang\' id=\'second_name_oth_lang\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'third_name_oth_lang\' id=\'third_name_oth_lang\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'family_name_oth_lang\' id=\'family_name_oth_lang\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'name_prefix_oth_lang\' id=\'name_prefix_oth_lang\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'name_suffix_oth_lang\' id=\'name_suffix_oth_lang\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'patient_name_local_lang\' id=\'patient_name_local_lang\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'patient_name_long\' id=\'patient_name_long\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'patient_name_loc_lang_long\' id=\'patient_name_loc_lang_long\' value=\'\'>\n\n\t\t<input type=\'hidden\' name=\'sex\' id=\'sex\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'date_of_birth\' id=\'date_of_birth\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'b_age\' id=\'b_age\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'b_months\' id=\'b_months\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'b_days\' id=\'b_days\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'dob\' id=\'dob\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'nationality_code1\' id=\'nationality_code1\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'citizen_yn0\' id=\'citizen_yn0\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'citizen_yn1\' id=\'citizen_yn1\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'legal_yn0\' id=\'legal_yn0\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'legal_yn1\' id=\'legal_yn1\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'national_id_no\' id=\'national_id_no\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_id1_no\' id=\'alt_id1_no\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_id2_no\' id=\'alt_id2_no\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_id3_no\' id=\'alt_id3_no\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_id4_no\' id=\'alt_id4_no\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_id1_exp_date\' id=\'alt_id1_exp_date\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_id2_exp_date\' id=\'alt_id2_exp_date\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_id3_exp_date\' id=\'alt_id3_exp_date\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'alt_id4_exp_date\' id=\'alt_id4_exp_date\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'other_alt_type\' id=\'other_alt_type\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'other_alt_Id\' id=\'other_alt_Id\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'addr_line1\' id=\'addr_line1\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'addr_line2\' id=\'addr_line2\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'addr_line3\' id=\'addr_line3\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'addr_line4\' id=\'addr_line4\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'res_town_code\' id=\'res_town_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'res_area_code\' id=\'res_area_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'postal_code\' id=\'postal_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'postal_desc\' id=\'postal_desc\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'region_code\' id=\'region_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'country_code\' id=\'country_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_addr_line1\' id=\'mail_addr_line1\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_addr_line2\' id=\'mail_addr_line2\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_addr_line3\' id=\'mail_addr_line3\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_addr_line4\' id=\'mail_addr_line4\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_res_town_code\' id=\'mail_res_town_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_res_area_code\' id=\'mail_res_area_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_postal_code\' id=\'mail_postal_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_postal_desc\' id=\'mail_postal_desc\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_region_code\' id=\'mail_region_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'mail_country_code\' id=\'mail_country_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'contact1_no\' id=\'contact1_no\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'contact2_no\' id=\'contact2_no\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'email\' id=\'email\' value=\'\'>\n\n\t\t<!--Added by Thamizh selvi on 1st Feb 2018 against ML-MMOH-CRF-0601 Start-->\n\t\t<input type=\'hidden\' name=\'alt_addr_line1\' id=\'alt_addr_line1\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_addr_line2\' id=\'alt_addr_line2\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_addr_line3\' id=\'alt_addr_line3\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_addr_line4\' id=\'alt_addr_line4\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_town_code\' id=\'alt_town_code\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_town_desc\' id=\'alt_town_desc\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_area_code\' id=\'alt_area_code\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_area_desc\' id=\'alt_area_desc\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_postal_code\' id=\'alt_postal_code\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_postal_desc\' id=\'alt_postal_desc\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_region_code\' id=\'alt_region_code\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_region_desc\' id=\'alt_region_desc\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_country_code\' id=\'alt_country_code\' value=\"\">\n\t\t<input type=\'hidden\' name=\'alt_country_desc\' id=\'alt_country_desc\' value=\"\">\n\t\t<!--End-->\n\t\t\n\t\t<input type=\'hidden\' name=\'rd_operational_yn\' id=\'rd_operational_yn\' value=\'";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\'>\n\t\t<input type=\'hidden\' name=\'or_operational_yn\' id=\'or_operational_yn\' value=\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\'>\n\t\t<input type=\'hidden\' name=\'entitlement_by_pat_cat_yn\' id=\'entitlement_by_pat_cat_yn\' value=\'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\'>\n\t\t<input type=\'hidden\' name=\'p_to_locn_type\' id=\'p_to_locn_type\' value=\'";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\'>\n\t\t<input type=\'hidden\' name=\'p_to_locn_code\' id=\'p_to_locn_code\' value=\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\'>\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\'>\n\t\t<input type=\'hidden\' name=\'contextURL\' id=\'contextURL\' value=\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\'>\n\t\t<!--<input type=\'hidden\' name=\'reloadYN\' id=\'reloadYN\' value=\'N\'>-->\n\n\t\t<!--  code added for 20854 -->\n\n\t\t<input type=\'hidden\' name=\'open_to_all_pract_yn\' id=\'open_to_all_pract_yn\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'from_locn_hid\' id=\'from_locn_hid\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'to_locn_hid\' id=\'to_locn_hid\' value=\'\'>\n\t\t<!--Below lines Added by afruddin for ML-MMOH-CRF-1527 on 28 jun 2020-->\n        <input type=\'hidden\' name=\'isTransferCase\' id=\'isTransferCase\' value=\'";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\'> \n\t\t<input type=\'hidden\' name=\'from_ref_type\' id=\'from_ref_type\' value=\'";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\'> \n\t\t<input type=\'hidden\' name=\'transfer_case_hidd\' id=\'transfer_case_hidd\' value=\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\'> \n\t\t<!--//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023-->\n\t\t<input type=\'hidden\' name=\'smartCardFunc\' id=\'smartCardFunc\' value=\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\'> \n\t\t\n\t\t<!--Ended by Afruddin for ML-MMOH-CRF-1527 US3 on 28-jun-2020-->\n\n\t\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t\t<script>\n\t\t\t\t\t\n\t\t\tvar from_pract_name1 = \"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\";\n\t\t\tvar from_pract_name = \"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\";\n\t\t\tvar to_pract_name = \"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\";\n\t\t\t\n\t\t\tsetTimeout(\"SecondframesValidation(\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\',from_pract_name,\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\',from_pract_name1,\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\',to_pract_name,\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\')\",700)\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\n\t\t<script>\n\t\tif(parent.frames[1].document.getElementById(\'p_calling_function\') != null)\n\t\t{\n\t\t\tif(parent.frames[1].document.getElementById(\'p_calling_function\').value==\'IP_ADMIT\' || parent.frames[1].document.getElementById(\'p_calling_function\').value==\'CHG_ADM_DTLS\' )\n\t\t\t{\n\t\t\t\tparent.frames[1].document.forms[0].referred_for_ip.value=\'A\';\n\t\t\t\tparent.frames[1].document.forms[0].referred_for_ip.disabled=true;\n\n\t\t\t}\n\n\t\t\tif(parent.frames[1].document.getElementById(\'p_calling_function\').value==\'IP_BOOKING\')\n\t\t\t{\n\t\t\t\tparent.frames[1].document.forms[0].referred_for_ip.value=\'B\';\n\t\t\t\tparent.frames[1].document.forms[0].referred_for_ip.disabled=true;\n\n\t\t\t}\n\t\t}\n\t\t</script>\n\t\t<script>\t\n\t\t\tif(parent.frames[0].document.getElementById(\'patient_id\') != null)\n\t\t\t{\t\n\t\t\t\tif(parent.frames[0].document.getElementById(\'patient_id\').disabled==false)\n\t\t\t\t   parent.frames[0].document.getElementById(\'patient_id\').focus();\n\t\t\t}\t\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\tsetTimeout(\"tab_click(\'rejfrom_tab\')\",300);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t\t\t\t<script>\n\t\t\t\t\t\t\n\t\t\t\t\tsetTimeout(\"tab_click(\'reffrom_tab\')\",300);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\t\t\t<script>\n\t\t\t\t\t\n\t\t\t\t\tsetTimeout(\'enableDisableFrom()\',200);\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t\t\t<input type=\"hidden\" name=\"localeth\" id=\"localeth\" value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n\t</form>\n</body>\n";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n</html>\n";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

/*************getdata1() more generalized*******************/

		public ArrayList getData1(String sql,String[] whereClause,JspWriter out,Connection con) throws Exception
		{

			ArrayList arrL_of_HashMap                            = new ArrayList() ;
			PreparedStatement pstmt                              = null ;
			ResultSet resultSet                                  = null ;
			ResultSetMetaData resultSetMetaData  = null;
			HashMap hmRecord = null;

			try {	
				pstmt = con.prepareStatement(sql) ;                 
				if (whereClause!=null)
						for (int index=0; index<whereClause.length ;index++ )
								pstmt.setString( index+1, whereClause[index]);
				resultSet = pstmt.executeQuery() ;
				if (resultSet != null) {
					resultSetMetaData   =   resultSet.getMetaData();			
					while (resultSet.next()) {	
						hmRecord	=  new HashMap();			
						for (int i=1; i<=resultSetMetaData.getColumnCount(); i++) {
							String column_Val=resultSet.getString(resultSetMetaData.getColumnName(i));
							if(column_Val==null) column_Val="";     
							hmRecord.put(resultSetMetaData.getColumnName(i),column_Val);	
						}
						arrL_of_HashMap.add(hmRecord) ;				
					} 
				}
				if(resultSet != null) resultSet.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e) {
				
				e.printStackTrace() ;
				out.println(e.toString()); 
			}
			finally {		
				try {
					if(resultSet!=null)     resultSet.close();
					if(pstmt!=null) pstmt.close();
				 }catch(Exception es) { es.printStackTrace();}
			}	
			return arrL_of_HashMap;
		}		


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
public static String isSiteSpecificforBiometric(Connection con)
	 {
	 	String function_name="";
	 	PreparedStatement pstmt		= null;
	 	ResultSet rs 				= null;
	 	try
	 	{
	 	String siteSpecificSQL="select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID";
	 	pstmt= con.prepareStatement(siteSpecificSQL);
	     rs= pstmt.executeQuery();
	     if(rs!=null && rs.next())
	 	{
	 	function_name=rs.getString("VALUE_2");
	 	}	
	 	}catch(Exception esql)
	 	{
	 		esql.printStackTrace();
	 	}finally
	 	{
	 		try{
	 	 if(pstmt != null)pstmt.close();
	 	 if(rs != null)rs.close();
	 		}catch(Exception fe){
	 		}
	 	}
	 	return function_name;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

 String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8");
 request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
 String locale			= (String)session.getAttribute("LOCALE");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	String facilityid = (String) session.getValue("facility_id");
	
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rset=null ;
	ResultSet rs=null ;
	ResultSet mod_rs=null ;
	Statement stmt = null;
	String sel				 = "";	
	String facilityname			= "";	
	String pat_name_as_multipart_yn = "";	
	String ass_func_id			= "";	
	String service_desc	=	"";
	String calling_from			= request.getParameter("calling_from");		
	String p_calling_function	= request.getParameter("p_calling_function");
	if (p_calling_function==null) p_calling_function="";
	
	String p_to_locn_type=request.getParameter("p_to_locn_type");
	 if(p_to_locn_type == null) p_to_locn_type="";
	String p_to_locn_code=request.getParameter("p_to_locn_code");
	 if(p_to_locn_code == null) p_to_locn_code="";
	 String contextURL= request.getContextPath();

    if(p_calling_function.equals("OP_REG_VISIT"))
	{
		ass_func_id=(request.getParameter("ass_func_id") == null)?"":request.getParameter("ass_func_id");
	}
	
	String res_class=(request.getParameter("res_class") == null)?"":request.getParameter("res_class");

	String mode = request.getParameter("mode");	
	
	if(mode==null || mode.equals("")) mode="insert";

	String pat_ID = request.getParameter("pat_ID");	
	if(pat_ID == null) pat_ID="";
		
	String hcaresettingtypecode = "";
	String speciality_code	= request.getParameter("speciality_code");
	if(speciality_code==null) speciality_code="";

	
	String service_code	= request.getParameter("service_code");
	if(service_code==null) service_code="";
	String practitioner	= request.getParameter("practitioner");
	if(practitioner==null) practitioner="";
	String practitioner_name	= request.getParameter("practitioner_name");
	if(practitioner_name==null) 	practitioner_name="";

		
	if (calling_from==null) calling_from="";
		
	String sys_date="";
	
	String sql				= "";
	StringBuffer mod_sql			= new StringBuffer();
	String referral_id	= request.getParameter("referral_id");
	if (referral_id==null) referral_id="";
	String patientid		= "";
	String ca_patient_id= (request.getParameter("ca_patient_id") == null)?"":request.getParameter("ca_patient_id");
	String from_ref_code	= "";
	String referral_letter_no= "";
	String referral_priority = "";
	String from_locn_desc	= "";
	String referral_date	= "";
	String received_date	= "";
	String preferred_treatment_date="";
	String from_pract_name	= "";
	String to_speciality_code= "";
	String to_locn_type		= "";
	String to_locn_code		= "";	
	String to_service_code	= "";
	String to_pract_id		= "";	
	String from_hcare_setting_type="";
	String ref_notes		= "";
	String from_fcy_id		= "";
	String to_pract_name	= "";
	String from_pract_id	= "";
	String from_ref_type	= "";
	String from_pract_name1	= "";
	String from_locn_id		= "";
	String from_locn_type	= "";	
	String pract_res_tel_num =""; 
	String pract_mobile_num=""; 
	String pract_pager_num =""; 
	String referral_reason_code =""; 
	String referral_reason_desc="";
	String other_doc_att=""; 
	String exam_and_clin_findings="";
	String diagnosisTab="";
	String treatmentTab="";	
	String from_speciality_code="";
	String referred_for_ip="";
	String locntypecode="";
	String locntypedesc="";
	String transfer_case_yn="N";  //Added by Afruddin for ML-MMOH-CRF-1527 US3 On 28-july-2020
	String tc_chk=""; //Added by Afruddin for ML-MMOH-CRF-1527 US3 On 28-july-2020
	StringBuffer specstr=new StringBuffer();
	specstr.setLength(0);

    String curr_year="";   	

	String or_operational_yn="";
	String entitlement_by_pat_cat_yn="";
    String patient_name="";
	String status="";

	String or_catalog_desc="";
	String or_catalog_code="";
	String rd_operational_yn="";
	String selval="";
	String seldis="";
	Clob note = null;
	String smartCardFunc="";//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023

	ArrayList Arr_Of_HashMap=new ArrayList();
	HashMap general_HashMap=new HashMap();
    //Below Added by Suji Keerthi for NMC-JD-CRF-0130
	String priority_Code="";
    String priority_Desc="";
	JSONObject RefPriorityJson = new JSONObject();
	JSONArray refPriorityjsonArr = new JSONArray();	
	
	//ADDED BY SANTHOSH FOR MMS-DM-CRF-0209.4-US005
	String p_service_desc	=	request.getParameter("p_service_desc");
	String p_service_code	=	request.getParameter("p_service_code");
	//End
	
	try
	{
		con = ConnectionManager.getConnection(request);
		smartCardFunc = isSiteSpecificforBiometric(con);//Added by Himanshu for AAKH-CRF-0175
		Boolean isTransferCase	= eCommon.Common.CommonBean.isSiteSpecific(con,"MP","BMI_REG_PAT_CHNGES_RH101"); //Added by Afruddin for ML-MMOH-CRF-1527 US0003 on 28-jun-2020
        //Below Added by Suji Keerthi for NMC-JD-CRF-0130
        Boolean isReferralPriorityAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AM","REFERRAL_PRIORITY_DESC");
        RefPriorityJson = eIP.IPCommonBean.getReferralPriority(con); 
		refPriorityjsonArr = (JSONArray)RefPriorityJson.get("refPriorityArray");
		
		
		if(mode.equals("modify") || mode.equals("RegisterMoreReferral"))
		{
			mod_sql.append("SELECT a.from_speciality_code,a.pract_res_tel_num pract_res_tel_num, a.pract_mobile_num pract_mobile_num, a.pract_pager_num pract_pager_num , a.referral_reason_code referral_reason_code,(SELECT am_get_desc.am_contact_reason(contact_reason_code,'"+locale+"','1')  FROM am_contact_reason  WHERE contact_reason_code  = a.referral_reason_code and reason_for_referral_yn ='Y') referral_reason_desc ,a.other_doc_att, a.exam_and_clin_findings,a.referral_letter_no ref_letter_no, a.diagnosis,a.treatment, a.referral_id, a.from_ref_type from_ref_type, a.patient_id,a.PATIENT_NAME, a.from_ref_code, a.referral_priority, a.referral_letter_no, a.from_locn_desc,TO_CHAR(a.referral_date,'dd/mm/yyyy hh24:mi')referral_date, TO_CHAR(a.received_date,'dd/mm/yyyy hh24:mi') received_date, TO_CHAR(a.preferred_treatment_date,'dd/mm/yyyy') preferred_treatment_date,a.from_facility_id, a.from_pract_name, a.to_speciality_code,a.to_locn_type to_locn_type,a.to_locn_code to_locn_code, a.to_service_code,a.to_pract_id,a.status stat,a.ORDER_CATALOG_CODE ORDER_CATALOG_CODE, a.from_hcare_setting_type, a.ref_notes, am_get_desc.am_practitioner(a.TO_PRACT_ID,'en',1) to_pract_name,(case when a.FROM_REF_TYPE='X' then am_get_desc.am_ext_practitioner(a.FROM_PRACT_ID,?,1) else am_get_desc.am_practitioner(a.FROM_PRACT_ID,?,1) end) from_pract_name1,a.from_pract_id from_pract_id ,a.FROM_PRACT_NAME free_text_pract_name,from_locn_code from_locn_id, from_locn_type,referred_for_ip,transfer_case_yn FROM pr_referral_register a"); //Modified by Afruddin for ML-MMOH-CRF-1527 US3 On 28-july-2020

			if(mode.equals("modify"))
			{
				  mod_sql.append(" where a.referral_id =? ");
			}
			else if(mode.equals("RegisterMoreReferral"))
			{

				if(!pat_ID.equals(""))
				{
				  mod_sql.append(" where a.patient_id =? order by a.referral_id ");
				}
				else
				{
					mod_sql.append(" where a.referral_id =? order by a.referral_id ");
				}
			}
			
			pstmt = con.prepareStatement(mod_sql.toString());
			
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);

			if(mode.equals("modify"))
			{
				pstmt.setString(3,referral_id);
			}
			else if(mode.equals("RegisterMoreReferral"))
			{
				if(!pat_ID.equals(""))
				{
				pstmt.setString(3,pat_ID);
				}
				else
				{
				pstmt.setString(3,referral_id);
				}	
			}

		
			mod_rs = pstmt.executeQuery();
	

			while(mod_rs !=null&& mod_rs.next())
			{	
				referred_for_ip            = mod_rs.getString("referred_for_ip");
				if (referred_for_ip==null) referred_for_ip="";

				from_pract_id           = mod_rs.getString("from_pract_id");
				if (from_pract_id==null) from_pract_id=""; 
				//treatmentTab	= java.net.URLEncoder.encode(mod_rs.getString("treatment"),"UTF-8");
				treatmentTab            = mod_rs.getString("treatment");
				if (treatmentTab==null) treatmentTab="";
				//diagnosisTab	= java.net.URLEncoder.encode(mod_rs.getString("diagnosis"),"UTF-8");
				diagnosisTab            =mod_rs.getString("diagnosis");
				if (diagnosisTab==null) diagnosisTab="";
				//exam_and_clin_findings	= java.net.URLEncoder.encode(mod_rs.getString("exam_and_clin_findings"),"UTF-8");
				exam_and_clin_findings          = mod_rs.getString("exam_and_clin_findings");		
				
				if (exam_and_clin_findings==null) exam_and_clin_findings="";
				
				other_doc_att           = mod_rs.getString("other_doc_att");
				if (other_doc_att==null) other_doc_att="";
				referral_reason_code            = mod_rs.getString("referral_reason_code");
				if (referral_reason_code==null) referral_reason_code="";
				referral_reason_desc            = mod_rs.getString("referral_reason_desc");
				if (referral_reason_desc==null) referral_reason_desc="";

				pract_pager_num                 = mod_rs.getString("pract_pager_num");
				if (pract_pager_num==null) pract_pager_num="";

				pract_mobile_num                = mod_rs.getString("pract_mobile_num");
				if (pract_mobile_num==null) pract_mobile_num="";

				pract_res_tel_num               = mod_rs.getString("pract_res_tel_num");
				if (pract_res_tel_num==null) pract_res_tel_num="";

				from_fcy_id		 = mod_rs.getString("from_facility_id");
				if (from_fcy_id==null) from_fcy_id="";
				from_locn_id		 = mod_rs.getString("from_locn_id");
				if (from_locn_id==null) from_locn_id="";
				from_locn_type		 = mod_rs.getString("from_locn_type");
				if (from_locn_type==null) from_locn_type="";
				from_ref_type		 = mod_rs.getString("from_ref_type");				 
				if (from_ref_type==null) from_ref_type="";
				from_speciality_code            = mod_rs.getString("from_speciality_code");
				if (from_speciality_code==null) from_speciality_code="";
				//Added by Afruddin for ML-MMOH-CRF-1527 US3 on 28-july-2020
				transfer_case_yn = mod_rs.getString("transfer_case_yn"); 
				
				if (transfer_case_yn==null ||transfer_case_yn=="") transfer_case_yn="N";
				
				if(transfer_case_yn.equals("Y"))
				{
					tc_chk="Checked";
				}
				//Ended by Afruddin for ML-MMOH-CRF-1527 US3 on 28-july-2020
				from_ref_code		=mod_rs.getString("from_ref_code");
				if (from_ref_code==null) from_ref_code="";
				from_hcare_setting_type=mod_rs.getString("from_hcare_setting_type");
				if (from_hcare_setting_type==null) from_hcare_setting_type="";
				patient_name=mod_rs.getString("patient_name");
				patientid			=mod_rs.getString("patient_id");
				if (patientid==null) patientid="";
				referral_priority	=mod_rs.getString("referral_priority");
				if (referral_priority==null) referral_priority="";
				referral_letter_no	=mod_rs.getString("referral_letter_no");
				if (referral_letter_no==null) referral_letter_no="";
				from_locn_desc		=mod_rs.getString("from_locn_desc");
				if (from_locn_desc==null) from_locn_desc="";
				referral_date		=mod_rs.getString("referral_date");
				if (referral_date!=null) 
					referral_date=DateUtils.convertDate(referral_date,"DMYHM","en",localeName);	
				else
					referral_date="";
				received_date		=mod_rs.getString("received_date");
				if (received_date!=null)
					received_date=DateUtils.convertDate(received_date,"DMYHM","en",localeName);
				else
					received_date="";
				

				preferred_treatment_date=mod_rs.getString("preferred_treatment_date");
				if (preferred_treatment_date!=null)
					preferred_treatment_date=DateUtils.convertDate(preferred_treatment_date,"DMY","en",localeName);
				else
					preferred_treatment_date="";
				from_pract_name=mod_rs.getString("from_pract_name");
				if (from_pract_name==null) from_pract_name="";
				to_speciality_code=mod_rs.getString("to_speciality_code");
				if (to_speciality_code==null) to_speciality_code="";
				to_locn_type=mod_rs.getString("to_locn_type");
				if (to_locn_type==null) to_locn_type="";		 
				to_locn_code=mod_rs.getString("to_locn_code");
				if (to_locn_code==null) to_locn_code="";

				status=mod_rs.getString("stat");
				if(status == null) status="";
		
				or_catalog_code=mod_rs.getString("ORDER_CATALOG_CODE");
				if(or_catalog_code == null) or_catalog_code="";


				to_service_code=mod_rs.getString("to_service_code");
				if (to_service_code==null) to_service_code="";
				
				to_pract_id=mod_rs.getString("to_pract_id");
				if (to_pract_id==null) to_pract_id="";
				from_pract_name1	 = mod_rs.getString("from_pract_name1");
				if (from_pract_name1==null) from_pract_name1="";
				to_pract_name		 = mod_rs.getString("to_pract_name");
				if (to_pract_name==null) to_pract_name="";			 
				note=mod_rs.getClob("ref_notes");

				ref_notes = "";
				java.io.BufferedReader r = null;
				if(note!=null)
				{
				r = new java.io.BufferedReader(note.getCharacterStream());
				String line = null;
				while((line=r.readLine()) != null) 	ref_notes=ref_notes+line+"\n";
				
				}			
			}	



			if(mod_rs != null) mod_rs.close();
			if(pstmt != null) pstmt.close();
			mod_sql.setLength(0);
		}

		

            _bw.write(_wl_block2Bytes, _wl_block2);

	try{			
			String sqlQuery = "select facility_name,hcare_setting_type_code,TO_CHAR (SYSDATE, 'dd/mm/rrrr hh24:mi') sys_date, TO_CHAR (SYSDATE, 'rrrr') curr_year,(SELECT operational_yn FROM sm_modules_facility WHERE module_id = 'RD' AND facility_id = ?) rd_operational_yn,(SELECT operational_yn FROM sm_modules_facility WHERE module_id = 'OR' AND facility_id =?) or_operational_yn, (SELECT  SHORT_DESC FROM AM_SERVICE_LANG_VW WHERE  SERVICE_CODE=? and language_id=?) short_desc, (select entitlement_by_pat_cat_yn  from mp_param) entitlement_by_pat_cat_yn from SM_FACILITY_PARAM_LANG_VW where FACILITY_ID = ? and language_id=?";	
			pstmt=con.prepareStatement(sqlQuery);		
			pstmt.setString(1,facilityid);
			pstmt.setString(2,facilityid);
			pstmt.setString(3,to_service_code);
			pstmt.setString(4,locale);
			pstmt.setString(5,facilityid);
			pstmt.setString(6,locale);
			rs=pstmt.executeQuery();
			if(rs!=null && rs.next())	{
				service_desc=rs.getString("short_desc")==null?"":rs.getString("short_desc");
				facilityname = rs.getString("facility_name")==null?"":rs.getString("facility_name");;
				hcaresettingtypecode = rs.getString("hcare_setting_type_code")==null?"":rs.getString("hcare_setting_type_code");
				sys_date=rs.getString("sys_date")==null?"":rs.getString("sys_date");;
				curr_year=rs.getString("curr_year")==null?"":rs.getString("curr_year");;
				rd_operational_yn=rs.getString("rd_operational_yn")==null?"":rs.getString("rd_operational_yn") ;
				or_operational_yn=rs.getString("or_operational_yn")==null?"":rs.getString("or_operational_yn") ;
				entitlement_by_pat_cat_yn=rs.getString("entitlement_by_pat_cat_yn");
			}	
			
			sys_date=DateUtils.convertDate(sys_date,"DMYHM","en",localeName);	
			if(received_date.equals("")) received_date=sys_date;		

			if(pstmt!=null)pstmt.close();
		 } catch(Exception e){
				
				e.printStackTrace() ;
		}
		
	 try{

		sql="Select Short_Desc,Speciality_Code from AM_SPECIALITY_LANG_VW where Eff_Status = 'E' and language_id='"+locale+"' order by 1";
		Arr_Of_HashMap=getData1(sql,null,out,con);
		general_HashMap.clear();
		for(int i=0; i<Arr_Of_HashMap.size();i++)	{
			general_HashMap=(HashMap)Arr_Of_HashMap.get(i);
			specstr.append(" <option value='"+general_HashMap.get("SPECIALITY_CODE")+"'>"+general_HashMap.get("SHORT_DESC")+"</option>");					
		}		
		}catch(Exception e) {
			
			e.printStackTrace() ;
		}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
if(!mode.equals("modify")){
            _bw.write(_wl_block9Bytes, _wl_block9);
}
if(isTransferCase){
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(referral_reason_desc));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
if(isTransferCase){
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(isTransferCase){
						 
					  
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(transfer_case_yn));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(tc_chk));
            _bw.write(_wl_block35Bytes, _wl_block35);

						  }
					 
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

								sel="";
								String sql_hcare="SELECT hcare_setting_type_code,short_desc FROM AM_HCARE_SETTING_TYPE_LANG_VW  WHERE eff_status='E' and  language_id='"+locale+"' ORDER BY 2";
								Arr_Of_HashMap=getData1(sql_hcare,null,out,con);							
								general_HashMap.clear();
								for(int i=0; i<Arr_Of_HashMap.size();i++)
								{
									sel="";		
									 general_HashMap=(HashMap)Arr_Of_HashMap.get(i);								 if(general_HashMap.get("HCARE_SETTING_TYPE_CODE").equals(from_hcare_setting_type)) sel="selected";	
								
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(general_HashMap.get("HCARE_SETTING_TYPE_CODE")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(general_HashMap.get("SHORT_DESC")));
            _bw.write(_wl_block42Bytes, _wl_block42);
						
								}
								
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
	
								String disp_val="";
								String disp_val_bkup="";
								String disp_val_id="";
								String disp_val_lng_name="***";

								if(mode.equals("modify") || mode.equals("RegisterMoreReferral")){									
									if (from_ref_type.equals("X")){
										sql = "Select a.LONG_DESC referred_to_id_desc, a.REFERRAL_CODE referred_to_id, a.healthcare_setting_type hcare_setting_type, b.short_desc hcare_setting_type_desc,nvl(a.long_name,'***') long_name from AM_REFERRAL_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW b where a.healthcare_setting_type = b.hcare_setting_type_code and nvl(a.dest_use_at_concl_yn,'N') = 'Y' and a.eff_status = 'E' and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.short_desc";	
										pstmt=con.prepareStatement(sql);
										rs = pstmt.executeQuery();			
										while(rs!=null && rs.next()){											
											if (rs.getString("referred_to_id").equals(from_ref_code)){
												disp_val=rs.getString("referred_to_id_desc");
												disp_val_bkup=disp_val;
												disp_val_id=rs.getString("hcare_setting_type")+"~"+rs.getString("referred_to_id");
												disp_val_lng_name=rs.getString("long_name");
											}			
										}											
										if(rs != null) rs.close();
										if(pstmt != null) pstmt.close();
									 }else if (from_ref_type.equals("L")){ 		
										 if (from_fcy_id.equals(facilityid)){		
											 /*
											sql = " select facility_name from SM_FACILITY_PARAM_LANG_VW where facility_id = '"+facilityid+"' and b.language_id='"+locale+"'";											
											pstmt=con.prepareStatement(sql);
											rs = pstmt.executeQuery();
											while(rs!=null && rs.next()){
												disp_val=rs.getString("facility_name");
												disp_val_bkup=disp_val;												
												disp_val_id=from_hcare_setting_type+"~"+facilityid;
												disp_val_lng_name="***";												
											}											
											if(rs != null) rs.close();
											if(pstmt != null) pstmt.close();		
											*/
												disp_val=facilityname;
												disp_val_bkup=disp_val;												
												disp_val_id=from_hcare_setting_type+"~"+facilityid;
												disp_val_lng_name="***";		
										}else{												
											sql = " SELECT a.FACILITY_ID Referral_Code ,a.FACILITY_NAME referred_to_id_desc   ,a.hcare_setting_type_code hcare_setting_type_code , b.short_desc hcare_setting_type_desc FROM  sm_facility_param_lang_vw a ,  am_hcare_setting_type_lang_vw b WHERE a.facility_id != '"+facilityid+"'  AND a.hcare_setting_type_code= '"+from_hcare_setting_type+"'   AND a.hcare_setting_type_code=b.hcare_setting_type_code   AND a.hcare_setting_type_code IN ( SELECT to_hcare_setting_type_code   FROM    am_hcare_setting_type_rstrn   WHERE from_hcare_setting_type_code = a.hcare_setting_type_code AND ( ip_referral_yn = 'Y' OR op_referral_yn = 'Y'    )   )   AND a.language_id='"+localeName+"' AND b.language_id='"+localeName+"' ORDER BY  a.facility_name";
											
											pstmt=con.prepareStatement(sql);
											rs = pstmt.executeQuery();
											sel ="";			
											while(rs!=null && rs.next()){													
												if (rs.getString("Referral_Code").equals(from_fcy_id)){
													
													disp_val=rs.getString("referred_to_id_desc");
													disp_val_bkup=disp_val;
													disp_val_id=rs.getString("hcare_setting_type_code")+"~"+rs.getString("Referral_Code");
													disp_val_lng_name="***";
												}		   
											}//while Close		

											if(rs != null) rs.close();
											if(pstmt != null) pstmt.close();
										}  //else close
									}else{			
										sql="select a.FACILITY_ID referred_to_id,a.FACILITY_NAME referred_to_id_desc ,a.hcare_setting_type_code hcare_setting_type_code, b.short_desc hcare_setting_type_desc from SM_FACILITY_PARAM_LANG_VW a, AM_HCARE_SETTING_TYPE_LANG_VW  b where a.hcare_setting_type_code=b.hcare_setting_type_code and a.hcare_setting_type_code in ( select to_hcare_setting_type_code from am_hcare_setting_type_rstrn where from_hcare_setting_type_code = (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facilityid+"' ) and (ip_referral_yn = 'Y'  or op_referral_yn = 'Y') ) and a.language_id='"+locale+"' and b.language_id='"+locale+"' order by a.facility_name";									
										
										pstmt=con.prepareStatement(sql);
										rs = pstmt.executeQuery();			 
										sel ="";
										while(rs!=null && rs.next()){
											 sel ="";
											if (rs.getString("referred_to_id").equals(from_fcy_id)){
												disp_val=rs.getString("referred_to_id_desc");
												disp_val_bkup=disp_val;
												disp_val_id=rs.getString("hcare_setting_type_code")+"~"+rs.getString("referred_to_id");
												disp_val_lng_name="***";
											}											
										}
										
										if(rs != null) rs.close();
										if(pstmt != null) pstmt.close();
									}		
								}
								
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(disp_val));
            _bw.write(_wl_block46Bytes, _wl_block46);
if(disp_val_lng_name.equals("***")){
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disp_val_lng_name));
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(disp_val_bkup));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(disp_val_id));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(specstr.toString()));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(calling_from));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(calling_from));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
 
						if(!mode.equals("modify") && !mode.equals("RegisterMoreReferral")){
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

						}else{ 

							if (from_ref_type.equals("X")){	
            _bw.write(_wl_block66Bytes, _wl_block66);
}else{
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
sql = " select count(distinct decode(ip_referral_yn,'N',null,ip_referral_yn) ) ip, count(distinct decode(op_referral_yn,'N',null,op_referral_yn) ) op from am_hcare_setting_type_rstrn where from_hcare_setting_type_code= (select hcare_setting_type_code from sm_facility_param where facility_id = '"+facilityid+"' ) and (ip_referral_yn='Y' or op_referral_yn = 'Y') ";
								
								pstmt=con.prepareStatement(sql);
								rs = pstmt.executeQuery();
								int ip=0;
								int op=0;

								stmt=con.createStatement();
								while(rs!=null && rs.next()) {
									ip= rs.getInt("ip");
									op= rs.getInt("op");
									mod_sql.append("select locn_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in (");
									
									if (op>0){
										mod_sql.append("'C',");
									}
									mod_sql.append("'E','D'");
									if(ip>0){
									  mod_sql.append(",'N'");
									}
									mod_sql.append(") and locn_type in(");
									if(op>0){
									  mod_sql.append("'C',");
									}
									mod_sql.append("'E','Y' ");
									if(ip>0){
									  mod_sql.append(",'N'");
									}
									mod_sql.append(" ) and sys_user_def_ind='S' and language_id='"+locale+"' order by 2");

								
									rset=stmt.executeQuery(mod_sql.toString());
									if(rset != null){
										while(rset.next()){	
										  locntypecode=rset.getString("locn_type");
										  locntypedesc=rset.getString("short_desc");
											
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(locntypecode));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(locntypedesc));
            _bw.write(_wl_block71Bytes, _wl_block71);
		 
										}
									}
            _bw.write(_wl_block72Bytes, _wl_block72);
if(rset != null) rset.close();						
									mod_sql.setLength(0);

								}

								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
								if(stmt != null) stmt.close();
						
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
		
					
								if(from_locn_type.equals("C") ){
									sql = "Select long_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic_lang_vw  where facility_id = '"+from_fcy_id+"'  and allow_visit_regn_yn = 'Y' and ALLOW_REFERRAL_YN='Y' and eff_status = 'E' and CARE_LOCN_TYPE_IND='C'  and clinic_type='C' and language_id='"+locale+"' order by 1";

									
								}else if(from_locn_type.equals("E")){
									sql = "Select long_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic_lang_vw where facility_id = '"+from_fcy_id+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E' and CARE_LOCN_TYPE_IND='E' and language_id='"+locale+"' order by 1";

								}else if(from_locn_type.equals("N")){
									sql = "Select a.long_desc dat, a.nursing_unit_code id, 'N' open_to_all_pract_yn from ip_nursing_unit_lang_vw  a   where a.facility_id = '"+from_fcy_id+"' and a.locn_type='N' and a.PATIENT_CLASS = 'IP' and a.eff_status = 'E' and a.language_id='"+locale+"' order by 1";
								}else if(from_locn_type.equals("Y")){
									
									sql = "Select long_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic_lang_vw where facility_id = '"+from_fcy_id+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E' and CARE_LOCN_TYPE_IND='D' and clinic_type='Y' and language_id='"+locale+"' order by 1";
								}              

								if(from_locn_type.equals("C") || from_locn_type.equals("N") || from_locn_type.equals("Y") || from_locn_type.equals("E"))
								{
									pstmt=con.prepareStatement(sql);					   
									rs = pstmt.executeQuery();
									sel ="";
									while(rs!=null && rs.next()){
										sel ="";
										if (rs.getString("id").equals(from_locn_id)) 
											sel="selected";	
										
										out.println("<option value='"+rs.getString("id")+ "'"+sel+" >" + rs.getString("dat")+"</option>");
									}
									if(rs != null) rs.close();
									if(pstmt != null) pstmt.close();
								}
							}
						}
						
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(specstr.toString()));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(to_speciality_code));
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
 if(isReferralPriorityAppl){ 	

								   refPriorityjsonArr = (JSONArray)RefPriorityJson.get("refPriorityArray");
					
					              for(int i = 0 ; i < refPriorityjsonArr.size() ; i++) 
				                  {
                             
									JSONObject jsonObj = (JSONObject) refPriorityjsonArr.get(i);
									priority_Code		= checkForNull((String) jsonObj.get("priority_Code"));
									priority_Desc		= checkForNull((String) jsonObj.get("priority_Desc"));
									out.println("<option value='"+priority_Code+"'>"+priority_Desc+"</option>");						
							
						         } 
								 }else{
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
} 
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

							String restric="N";
						if( p_calling_function.equals("IP_ADMIT") || p_calling_function.equals("IP_BOOKING") ||	 p_calling_function.equals("CHG_ADM_DTLS"))
							restric="Y";
						else if(p_calling_function.equals("OA_BOOK_APPT") || p_calling_function.equals("OA_MODIFY_APPT")|| ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED"))
							restric="O";
						else if(p_calling_function.equals("CHG_REG_DTLS") ||p_calling_function.equals("AE_REGISTER_ATTN") ||p_calling_function.equals("REV_VISIT_DTLS"))
							restric="C";
						else if(p_calling_function.equals("OP_REG_VISIT")&&ass_func_id.equals("VISIT_REGISTRATION")){
							
							restric="E";
						}
                        	String lcare="";
	 					if(p_calling_function.equals("CHG_REG_DTLS")||p_calling_function.equals("AE_REGISTER_ATTN"))
						{
							
							to_locn_type="C";
							to_speciality_code=speciality_code;
							p_to_locn_code="";
							lcare="and level_of_care_ind ='E' ";
						}
						if(p_calling_function.equals("REV_VISIT_DTLS")) {
							
							lcare="and level_of_care_ind in ('A','E') ";
							to_locn_type = p_to_locn_type;
							to_speciality_code=speciality_code;
						}

						else
						{
							lcare="and level_of_care_ind in ('A','E') ";
						}

						if(restric.equals("O"))
						{
							selval="selected";
							if(!p_calling_function.equals("OA_MODIFY_APPT"))
								seldis="disabled";
						}
						else
						{
							selval="";
							seldis="";
						}
					
						if( p_calling_function.equals("REV_VISIT_DTLS") || p_calling_function.equals("OA_MODIFY_APPT") ||	 p_calling_function.equals("CHG_ADM_DTLS")|| ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED"))
                         seldis="disabled"; 
						
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(seldis));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

						mod_sql.append("select locn_type,short_desc from AM_CARE_LOCN_TYPE_LANG_VW  where ");
						
						
						if(restric.equals("C"))
						{
							mod_sql.append(" care_locn_type_ind in ('C') and locn_type in('C') and ");
						}
						else if(restric.equals("E"))
						{
                            
							mod_sql.append(" care_locn_type_ind in ('E','C')  and locn_type in('E','C') and");
						}
						else if(restric.equals("O"))
						{
							if(p_to_locn_type.equals("D"))
								to_locn_type="Y";
							else
								to_locn_type=p_to_locn_type;

							to_speciality_code=speciality_code;
							to_locn_code=p_to_locn_code;
													
							if(p_to_locn_type.equals("C"))
							{
								mod_sql.append(" care_locn_type_ind in ('C') and locn_type in('C') and ");
							}
							else if(p_to_locn_type.equals("D"))
							{
								mod_sql.append(" care_locn_type_ind in ('D') and locn_type in('Y') and ");
							}
							else if(p_to_locn_type.equals("E"))
							{
								mod_sql.append(" care_locn_type_ind in ('E') and locn_type in('E') and ");
							}
						}
						else if(restric.equals("Y"))
						{
							mod_sql.append(" care_locn_type_ind in ('N')  and locn_type in('N') and");
							to_locn_type="N";
							to_speciality_code=speciality_code;
						}
						else
						{
							if(rd_operational_yn.equals("Y"))
							{
								mod_sql.append(" care_locn_type_ind in ('C','E','D','N','W') and locn_type in('C','E','Y','N','W') and  ");
							}else
							{
								mod_sql.append(" care_locn_type_ind in ('C','E','D','N') and locn_type in('C','E','Y','N') and ");
							}
							
						}		  
			  
						mod_sql.append(" sys_user_def_ind='S' and language_id='"+locale+"' order by 2");	 

						
						
						pstmt=con.prepareStatement(mod_sql.toString());
						rs=pstmt.executeQuery();
						if(rs != null)
						{
							while(rs.next())
							{	
								locntypecode=rs.getString("locn_type");
								locntypedesc=rs.getString("short_desc");
								
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(locntypecode));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(selval));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(locntypedesc));
            _bw.write(_wl_block100Bytes, _wl_block100);
			 
							}
						}

						if(rs != null) rs.close();
						if(pstmt !=null) pstmt.close();								
						
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(to_locn_type));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(seldis));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

							sel="";
							if(!to_locn_type.equals("")) {
								if(to_locn_type.equals("C")) {
									sql="Select long_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic_lang_vw  where facility_id = '"+facilityid+"'  and allow_visit_regn_yn = 'Y' and ALLOW_REFERRAL_YN='Y' and eff_status = 'E' "+lcare+" and speciality_code = '"+to_speciality_code+"' and CARE_LOCN_TYPE_IND = 'C' and clinic_type='C' and clinic_code=nvl('"+p_to_locn_code+"',clinic_code) and language_id='"+locale+"' order by 1 ";
								} else if(to_locn_type.equals("E")) {
									sql="Select long_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic_lang_vw where facility_id = '"+facilityid+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = '"+to_speciality_code+"' and CARE_LOCN_TYPE_IND = 'E' and clinic_code=nvl('"+p_to_locn_code+"',clinic_code) and language_id='"+locale+"' order by 1 ";
								}// Fix Against ML-BRU-SCF-1200 [IN:045701] By Saanthaakumar 
								else if (to_locn_type.equals("N")) {
									sql="Select a.long_desc dat, a.nursing_unit_code id,'N' open_to_all_pract_yn from ip_nursing_unit_lang_vw  a, ip_nurs_unit_for_specialty b  where a.facility_id = '"+facilityid+"' and a.eff_status = 'E' and  a.nursing_unit_code = b.nursing_unit_code and locn_type='N' and PATIENT_CLASS = 'IP'and a.facility_id = b.facility_id and b.specialty_code = '"+to_speciality_code+"' and a.nursing_unit_code = nvl('"+p_to_locn_code+"',a.nursing_unit_code) and a.language_id='"+locale+"' order by 1";
								} else if(to_locn_type.equals("Y")) {									
									sql="Select long_desc dat, clinic_code id, open_to_all_pract_yn from op_clinic_lang_vw  where facility_id = '"+facilityid+"'  and allow_visit_regn_yn = 'Y' and eff_status = 'E'  and speciality_code = '"+to_speciality_code+"' and CARE_LOCN_TYPE_IND = 'D' and clinic_type='Y' and clinic_code=nvl('"+p_to_locn_code+"',clinic_code) and language_id='"+locale+"' order by 1 ";
								} else if(to_locn_type.equals("W")) {
									sql="SELECT  SHORT_DESC dat,WING_CODE id, 'N' open_to_all_pract_yn FROM RD_WINGS WHERE  OPERATING_FACILITY_ID  ='"+facilityid+"' AND INT_OR_EXT= 'I' AND STATUS IS NULL";
								}
								if(mode.equals("modify") && p_calling_function.equals(""))
									  p_to_locn_code = to_locn_code;
								pstmt=con.prepareStatement(sql);
								rs=pstmt.executeQuery();
								if(rs != null) {
									while(rs.next()) {											
										if(p_to_locn_code.equals(rs.getString("id"))){
											sel="selected";
										} else {
											sel="";
										}
										
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(rs.getString("id")+"$"+rs.getString("open_to_all_pract_yn")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(sel));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((rs.getString("dat") == null)?"":rs.getString("dat")));
            _bw.write(_wl_block105Bytes, _wl_block105);

									   }
									}				
									if(rs != null) rs.close();
									if(pstmt != null) pstmt.close();
							}						
					
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
if(ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED")){
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(p_service_desc));
            _bw.write(_wl_block109Bytes, _wl_block109);
}else{
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(service_desc));
            _bw.write(_wl_block110Bytes, _wl_block110);
}
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(to_locn_type));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(to_locn_type));
            _bw.write(_wl_block113Bytes, _wl_block113);
if(mode.equals("insert")) 
		             {
            _bw.write(_wl_block114Bytes, _wl_block114);
if(ass_func_id.equalsIgnoreCase("REFERAL_REQUIRED")){
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(p_service_code));
            _bw.write(_wl_block116Bytes, _wl_block116);
}else{
            _bw.write(_wl_block117Bytes, _wl_block117);
}
            _bw.write(_wl_block118Bytes, _wl_block118);
}else
		              {
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(to_service_code));
            _bw.write(_wl_block120Bytes, _wl_block120);
}
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);

			String dis1="";
			String ronly="";

		if(or_operational_yn.equals("Y")) {
			if(mode.equals("modify")) {
				pstmt=con.prepareStatement("select short_desc from or_order_catalog where ORDER_CATALOG_CODE='"+or_catalog_code+"' ");
				rs = pstmt.executeQuery();
				if(rs != null && rs.next()) {
					 or_catalog_desc=rs.getString(1);
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
		}

		if(mode.equals("modify")) {
		   if(to_locn_type.equals("N")){
			  dis1="disabled";
			  ronly="readOnly";
		   }else{
			 dis1="";
			 ronly="";
		   }
		}else {
			dis1="disabled";
			ronly="readOnly";
		}
		
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(ronly));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(or_catalog_desc));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(dis1));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(or_catalog_code));
            _bw.write(_wl_block128Bytes, _wl_block128);
}else{
			
            _bw.write(_wl_block129Bytes, _wl_block129);
}
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
if(mode.equals("modify"))
		{
            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);

		
		String apptNo="";
	    String dis="";

		if(status.equals("X") || status.equals("D") || status.equals("N"))
			dis="disabled";
		else if (status.equals("C") || status.equals("O"))
			dis="";
	
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(dis));
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
 if(status.equals("C")){
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
}else if(status.equals("O")){
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
}
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(apptNo));
            _bw.write(_wl_block149Bytes, _wl_block149);
}
            _bw.write(_wl_block150Bytes, _wl_block150);

		
		if(mode.equals("modify"))
		{
	   
		sql="select to_char(a.ACTION_DATE_TIME,'dd/mm/yyyy hh24:mi')  ACTION_DATE_TIME,a.ACTION_TYPE,DECODE(a.ACTION_TYPE,'AS', 'Appt Scheduled','AR', 'Appt Re-scheduled','AC', 'Appt Cancelled','RF', 'Referral Follow-up','RR', 'Referral Rejected','CO', 'Completed/Encounter Registered') ACTION_TYPE_DESC,a.ACTION_REASON_CODE,b.CONTACT_REASON ACTION_REASON_DESC,a.ACTION_REF_ID   ACTION_REF_ID,a.ACTIONED_BY ACTIONED_BY,a.ACTION_REMARKS ACTION_REMARKS from PR_REFERRAL_REGISTER_ACTION a, am_contact_reason b where a.ACTION_REASON_CODE=b.CONTACT_REASON_CODE(+) and a.FACILITY_ID='"+facilityid+"' and a.referral_id='"+referral_id+"' order by  a.ACTION_DATE_TIME desc ";

		
		
		pstmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		rs=pstmt.executeQuery();
		
		int i=0;		
		int maxRecord=0;

		String classValue="";
		String action_ref_id="";
		String action_reason=""; 		
		String action_remarks="";
		String action_date_time = "";
		String action_type_desc = "";
		String actioned_by = "";

		if(rs != null)
		{
			rs.last();
			maxRecord=rs.getRow();
			rs.beforeFirst();

			if(maxRecord > 0)
			{
		
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);

			while(rs.next())
			{
				 if(i % 2 == 0)
					classValue 		  = "QRYODD" ;
		         else
					classValue 		  = "QRYEVEN" ;

				action_date_time = rs.getString("ACTION_DATE_TIME") == null?"&nbsp;":rs.getString("ACTION_DATE_TIME"); 
				action_type_desc = rs.getString("ACTION_TYPE_DESC") == null?"&nbsp;":rs.getString("ACTION_TYPE_DESC"); 				
				action_ref_id = rs.getString("ACTION_REF_ID") == null?"&nbsp;":rs.getString("ACTION_REF_ID"); 
				action_reason = rs.getString("ACTION_REASON_DESC") == null?"&nbsp;":rs.getString("ACTION_REASON_DESC"); 
				action_remarks = rs.getString("ACTION_REMARKS") == null?"&nbsp;":rs.getString("ACTION_REMARKS");			
				actioned_by = rs.getString("ACTIONED_BY") == null?"&nbsp;":rs.getString("ACTIONED_BY");			

				out.println("<tr>");
				out.println("<td width='15%' class='"+classValue+"'><font size='1'>"+action_date_time+"</td>");
				out.println("<td width='25%' class='"+classValue+"'><font size='1'>"+action_type_desc+"</td>");
				out.println("<td width='24%' class='"+classValue+"'><font size='1'>"+action_reason+"</td>");
				out.println("<td width='8%' class='"+classValue+"'><font size='1'>"+action_ref_id+"</td>");
				out.println("<td width='20%' class='"+classValue+"'><font size='1'>"+action_remarks+"</td>");
				out.println("<td width='8%' class='"+classValue+"' ><font size='1'>"+actioned_by+"</td>");
				
				out.println("</tr>");
			    i++;
			}

			}

		}
		
			if(rs != null) rs.close();
		    if(pstmt != null) pstmt.close();


				
		}
	specstr.setLength(0);
	
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(ca_patient_id));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(curr_year));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(facilityname));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(hcaresettingtypecode));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(ref_notes));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(other_doc_att));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(exam_and_clin_findings));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(diagnosisTab));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(treatmentTab));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(calling_from));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(service_code));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(res_class));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(p_calling_function));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(ass_func_id));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(referral_reason_desc));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(pat_name_as_multipart_yn));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(rd_operational_yn));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(or_operational_yn));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(p_to_locn_type));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(p_to_locn_code));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(contextURL));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(isTransferCase));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(from_ref_type));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(transfer_case_yn));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(smartCardFunc));
            _bw.write(_wl_block193Bytes, _wl_block193);

         
		
		
		
		 if (calling_from.equals("SEARCH"))     		
		 out.println("<script>document.forms[0].to_speciality_code.value='"+speciality_code+"';if(document.forms[0].to_speciality_code.value != ''){document.forms[0].to_speciality_code.disabled=true;}if(document.forms[0].to_speciality_code.value != ''){ document.forms[0].b_pract1.disabled = false;}else{document.forms[0].b_pract1.disabled = true;} if(document.forms[0].to_service_code.value != ''){document.forms[0].to_service_code.disabled=true;}if(document.getElementById('res_class').value == 'P' && document.forms[0].p_calling_function.value != 'OA_MODIFY_APPT'){document.forms[0].to_practitioner_id.value='"+practitioner_name+"'; document.forms[0].to_practitioner.value='"+practitioner+"';if(document.forms[0].to_practitioner_id.value != ''){document.forms[0].to_practitioner_id.readonly=true;}}</script>");  
         //document.forms[0].to_service_code.value='"+service_code+"';	 
		if(mode.equals("RegisterMoreReferral") || p_calling_function.equals("CHG_REG_DTLS") || !ca_patient_id.equals("") || p_calling_function.equalsIgnoreCase("REV_VISIT_DTLS"))
		{
			patientid = pat_ID; 
			
		}

		if(mode.equals("modify") || mode.equals("RegisterMoreReferral"))
		{	
// Below Variables Newly Added Against Incident : ML-BRU-SCF-1200 [IN:045701] By Saanthaakumar		
		
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(from_pract_name1));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(from_pract_name));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(to_pract_name));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(referred_for_ip));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(referral_priority));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(to_service_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(referral_date));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(referral_letter_no));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(received_date));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(preferred_treatment_date));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(from_speciality_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(referral_reason_code));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(from_ref_type));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(pract_res_tel_num));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(pract_mobile_num));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(pract_pager_num));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(from_locn_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(from_ref_code));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(from_pract_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(from_fcy_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(from_locn_type));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(from_hcare_setting_type));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(to_pract_id));
            _bw.write(_wl_block201Bytes, _wl_block201);
	
		}	
		
            _bw.write(_wl_block202Bytes, _wl_block202);
	
			if(!mode.equals("RegisterMoreReferral"))
			{	
					if(mode.equals("modify")){
					
            _bw.write(_wl_block203Bytes, _wl_block203);
}else{
				
            _bw.write(_wl_block204Bytes, _wl_block204);

					}
			}
			else if(mode.equals("RegisterMoreReferral"))
			{	
				
            _bw.write(_wl_block205Bytes, _wl_block205);

			}
			
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block207Bytes, _wl_block207);

}
catch(Exception e)
{
	out.print("exception in regpatreff"+e.toString());
	e.printStackTrace();
}
finally
{
	try{		
			if(rset!=null)	rset.close();
			if(rs!=null)	rs.close();
			if(mod_rs!=null)	mod_rs.close();
			if(pstmt!=null)	pstmt.close();
			if(pstmt1 != null) pstmt1.close();
	}catch(Exception ee){ee.printStackTrace();}
	if(con != null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block208Bytes, _wl_block208);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ReferralLetterNo.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReceivedDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredDate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforReferral.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referraltype.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.loginfacility.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enterprise.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.external.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.TransferCase.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HealthcareSettingType.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.clinicaldetails.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.notes.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.telno.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MobileNo.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PagerNo.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredFrom.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReferredTo.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.elective.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.semiemergency.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.emergency.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.OrderableProcedure.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ReferredForIP.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.followup.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Rejected.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.followup.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.followup.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Rejected.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Reference.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Reference.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.by.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }
}
