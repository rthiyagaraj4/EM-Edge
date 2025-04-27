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
import eCommon.Common.*;
import webbeans.op.CurrencyFormat;
import blopin.*;
import eBL.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __visitregistrationcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/VisitRegistrationCriteria.jsp", 1742353449826L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<meta http-equiv=\"Expires\" content=\"0\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n    <Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n    <Script src=\"../../eMP/js/PatientRegistration.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eOP/js/VisitRegistrationQuery.js\" language=\"JavaScript\"></Script> \n    <Script src=\"../../eOP/js/VisitRegistration1.js\" language=\"JavaScript\"></Script>\t\n\t<Script src=\"../../eOP/js/VisitRegistration.js\" language=\"JavaScript\"></Script>\t\n    <Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t<Script src=\"../../eCommon/js/FieldFormatMethods.js\" language=\"JavaScript\"></Script>\n \t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script src=\'../../eOP/js/OPPractitionerComponent.js\' language=\'javascript\'></script>\n\t<!-- Below line added by Venkatesh.S on 15/Feb/2013 against CHL-SCF-0013 [IN035559] -->\n\t<script src=\'../../eMP/js/PatientSearch.js\' language=\'javascript\'></script>\n\t<!-- End CHL-SCF-0013 [IN035559] -->\n\t<script language=\"javascript\" src=\"../../eST/js/StCommon.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n             \n  </head>    \n<body onLoad=\'disableData();focusElement()\' onMouseDown=\"CodeArrest();\" onKeyDown =\'lockKey()\' onSelect=\"codeArrestThruSelect();\" class=\'content\' topmargin=\'0\' bottommargin=\'0\' >\n<form name=\'visit_registration\' id=\'visit_registration\' method=\'post\' action=\'\' target=\"messageFrame\">    \n\t\t  \n<table width=\'100%\' cellspacing=0 cellpadding=\'1\' border=0>\n<!-- ******************** -->\n<tr >\n<td colspan=7>\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" \n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t \n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n</td>\n</tr>\n\n\n<tr>\n\t<td class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'pat_id1\' id=\'pat_id1\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' maxlength=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' size=\'25\'    onBlur=\"setValue(\'patient\',this);\" onChange=\"ChangeUpperCase(this);if(document.getElementById(\'srch_code\')!=null)document.getElementById(\'srch_code\').click();\" onkeypress=\"readyToBlur(event);\"><input type=\'button\' class=\'button\' value=\'?\' name=\'srch\' id=\'srch\' onClick=\"getPatID()\"> \n\t    ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" <!--Below line modified for this CRF MMS-QH-CRF-0162.1-->\n\t\t\t\t\t\t <img  align=\'center\'  style=\"visibility:hidden\"  id=\"Update_pat\" Title=\"Change Patient Details\" src=\'../../eCommon/images/update.jpg\' \n\t\t\t\t\t  onClick=\"getPatientDetails(document.forms[0].pat_id1.value);image_click1(\'search\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',pat_id1.value,referal_id1.value)\" />\n\t\t\t\t  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t<input type=\'hidden\' name=\'isSiteSpe_change_pat_dtls\' id=\'isSiteSpe_change_pat_dtls\' value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"> \n\t\t\t\t<input type=\'hidden\' name=\'userFunRightsCount\' id=\'userFunRightsCount\' value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"> <!--Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]-->\n\t\t\t\t<input type=\'hidden\' name=\'appt_refno_flag\' id=\'appt_refno_flag\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"> <!--this line added for this incident[52415] -->\n\t\t\t\t<input type=\'hidden\' name=\'blflag_op_yn\' id=\'blflag_op_yn\' value=\"\"> <!--this line added for this incident[52415] -->\n\t\t\t\t<input type=\'hidden\' name=\'appt_service_code\' id=\'appt_service_code\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"> <!--Added this line incident[52513] -->\n\t\t\t\t<input type=\'hidden\' name=\'invitation_no\' id=\'invitation_no\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"> <!--Added this line incident[52619] -->\n\t\t\t\t<input type=\'hidden\' name=\'inviate_facility_id\' id=\'inviate_facility_id\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"> <!--Added this line incident[52619] -->\n\t\t\t\t<input type=\'hidden\' name=\'locn_code\' id=\'locn_code\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"> <!--Added this line incident[52619] -->\n\t\t\t\t<input type=\'hidden\' name=\'practitioner_id\' id=\'practitioner_id\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"> <!--Added this line incident[52619] -->\n\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'episode\' id=\'episode\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"> <!--Added this line incident[52854] -->\n\t\t\t\t<input type=\'hidden\' name=\'record\' id=\'record\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"> <!--Added this line incident[52854] -->\n\t\t\t\t\n\t</td>\n\n\n\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n                 <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n     ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n      ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n         ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n    ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<td class=\'fields\' ><input type=text name=\'nationality_desc\' id=\'nationality_desc\'  size=\'25\' maxlength=\'20\' value=\'\' onblur=\'if(this.value !=\"\")searchCountry(nationality_id,nationality_desc);\'><input type=\'button\' name=\'nat_id\' id=\'nat_id\' value=\'?\' class=\'button\' onclick=\'searchCountry(this,nationality_desc)\'></td>\n\t\t<td ></td><td></td>\n\t\t<INPUT TYPE=\"hidden\"  name=\'nationality_id\' id=\'nationality_id\'>\n     ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t     <td class=\'fields\' width=\'25%\'><select name=\'gender\' id=\'gender\'><option value=\'\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t    <option value=\'M\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t    <option value=\'F\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t    <option value=\'U\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n            </select>   \n\t     </td><td></td>\n      </tr> \n\t  <tr>  \n\t   <td class=\'label\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td>\n        <td  class=\'fields\' width=\'25%\'>\n\t\t\t<INPUT TYPE=\"text\" name=\"nationality_iddesc\" id=\"nationality_iddesc\"   onblur=\'selectNationality1(nationality_iddesc,nationality_id);return makeValidString(this);\'  value=\'\' size=\'25\'><input type=button class=button value=\'?\' name=\'nat1\' id=\'nat1\' onClick=\'selectNationality(nationality_iddesc,nationality_id);\' >\n\t\t\t<INPUT TYPE=\"hidden\"  name=\'nationality_id\' id=\'nationality_id\'>\n\t   </td>\n\t  ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t   <td  class=\'fields\' >\n\t\t\t<input type=\'checkbox\' name=\'local_lang\' id=\'local_lang\' value=\'Y\' onClick=\"localLang(this);\" checked>\n\t\t\t\n\t   </td>\n   ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\n\t  <td  class=\'fields\' >\n\t\t\t\t\t\t\n\t   </td>\n\t  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" \n\t   </tr>\n</table>\n<table width=\'100%\' cellspacing=0 cellpadding=\'1\' border=0>\n<tr>\n   \n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n         <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t <td class=\'label\' >";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t   <td class=\'label\' >";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" \n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n        <td class=\'label\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n    ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n        <td class=\'label\' >";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n         <td class=\'label\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n          <td class=\'label\'>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</td>\n     \n\t  \n\t  ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n           <td class=\'label\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n</tr>\n<tr>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n       <td class=\'label\' width=\'25%\'><Select name=\'name_prefix\' id=\'name_prefix\' >\n     ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n            <td class=\'fields\'><Select name=\'name_prefix\' id=\'name_prefix\' >\n         ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n            <Option value=\'\'>--- ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" ---</option>\n       \n\t   ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n            <Option value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</option>\n          ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n    </Select>\n    ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t <input type=\'hidden\' name=\'name_prefix_reqd_yn\' id=\'name_prefix_reqd_yn\' value=\'Y\'></input>\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t <input type=\'hidden\' name=\'name_prefix_reqd_yn\' id=\'name_prefix_reqd_yn\' value=\'N\'></input>\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t</td>\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t<td class=\'fields\' ><input type=\'text\' name=\'first_name\' id=\'first_name\' maxlength=\'15\' size=\'15\'  tabIndex=\'15\'>\n\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t<input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'Y\'></input>\n\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t<input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'N\'></input>\n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t</td>\n ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t<td class=\'fields\' ><input type=\'text\' name=\'second_name\' id=\'second_name\' maxlength=\'15\' size=\'15\'  tabIndex=\'15\'>\n\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t    <input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'Y\'></input>\n\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t    <input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'N\'></input>\n\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t</td>\n     ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t<td class=\'fields\' ><input type=\'text\' name=\'third_name\' id=\'third_name\' maxlength=\'15\' size=\'15\'  tabIndex=\'15\'>\n\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t    <input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'Y\'></input>\n\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t    <input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'N\'></input>\n\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t</td>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\n  \t<td class=\'fields\'><input type=\'text\' name=\'family_name\' id=\'family_name\' maxlength=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' size=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" >\n  \t\n ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n      <td class=\'fields\'><input type=\'text\' name=\'family_name\' id=\'family_name\' maxlength=\'40\' size=\'40\'  >\n ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n     <td class=\'fields\'><input type=\'text\' name=\'family_name\' id=\'family_name\' maxlength=\'15\' size=\'15\'  >\n ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n     <input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'Y\'></input>\n ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n     <input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'N\'></input>\n ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n     <td class=\'fields\'><input type=\'text\' name=\'first_name\' id=\'first_name\' maxlength=\'15\' size=\'15\'  tabIndex=\'16\'>\t\t\n  ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n     <input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'Y\'></input>\n  ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n   <input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'N\'></input>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n</td>\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n   <td class=\'fields\'><input type=\'text\' name=\'second_name\' id=\'second_name\' maxlength=\'15\' size=\'15\'  tabIndex=\'16\'>\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n  <input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'Y\'></input>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n  <input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'N\'></input>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n    <td class=\'fields\'><input type=\'text\' name=\'third_name\' id=\'third_name\' maxlength=\'15\' size=\'15\' tabIndex=\'16\'>\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n    <input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'Y\'></input>\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n    <input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'N\'></input>\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t   <td class=\'fields\'><input type=\'text\' name=\'family_name\' id=\'family_name\' maxlength=\'40\' size=\'40\' >\n\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t  <td class=\'fields\'><input type=\'text\' name=\'family_name\' id=\'family_name\' maxlength=\'15\' size=\'15\' >\n\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t   <input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'Y\'></input>\n\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t<input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'N\'></input>\n\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n  </td>\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t<td class=\'fields\'><input type=\'text\' name=\'first_name\' id=\'first_name\' maxlength=\'15\' size=\'15\' tabIndex=\'17\'>\n ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n        <input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'Y\'></input>\n   ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n        <input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'N\'></input>\n   ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\n  <td class=\'fields\'><input type=\'text\' name=\'second_name\' id=\'second_name\' maxlength=\'15\' size=\'15\' tabIndex=\'17\'>\n ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n       <input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'Y\'></input>\n   ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n       <input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'N\'></input>\n   ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n    </td>\n   ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n      <td class=\'fields\'><input type=\'text\' name=\'third_name\' id=\'third_name\' maxlength=\'15\' size=\'15\' tabIndex=\'17\'>\n   ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n       <input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'Y\'></input>\n    ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n       <input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'N\'></input>\n    ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' size=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'  >\n  ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n    <td class=\'fields\'><input type=\'text\' name=\'family_name\' id=\'family_name\' maxlength=\'40\' size=\'40\' >\n    ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n    <td class=\'fields\'><input type=\'text\' name=\'family_name\' id=\'family_name\' maxlength=\'15\' size=\'15\' >\n    ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n    <input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'Y\'></input>\n    ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n    <input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'N\'></input>\n   ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t<td class=\'fields\'><input type=\'text\' name=\'first_name\' id=\'first_name\' maxlength=\'15\' size=\'15\' tabIndex=\'18\'>\n\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\t\t<input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'Y\'></input>\n\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t<input type=\'hidden\' name=\'first_name_reqd_yn\' id=\'first_name_reqd_yn\' value=\'N\'></input>\n\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n     <td class=\'fields\'><input type=\'text\' name=\'second_name\' id=\'second_name\' maxlength=\'15\' size=\'15\' tabIndex=\'18\'>\n";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n     <input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'Y\'></input>\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n     <input type=\'hidden\' name=\'second_name_reqd_yn\' id=\'second_name_reqd_yn\' value=\'N\'></input>\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t<td class=\'fields\'><input type=\'text\' name=\'third_name\' id=\'third_name\' maxlength=\'15\' size=\'15\' tabIndex=\'18\'>\n\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t<input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'Y\'></input>\n\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t<input type=\'hidden\' name=\'third_name_reqd_yn\' id=\'third_name_reqd_yn\' value=\'N\'></input>\n\t";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\n\t<td class=\'fields\'><input type=\'text\' name=\'family_name\' id=\'family_name\' maxlength=\'40\' size=\'40\'  >\n\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t<td class=\'fields\'><input type=\'text\' name=\'family_name\' id=\'family_name\' maxlength=\'15\' size=\'15\' >\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n     <input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'Y\'></input>\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n     <input type=\'hidden\' name=\'family_name_reqd_yn\' id=\'family_name_reqd_yn\' value=\'N\'></input>\n";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n   <td class=\'fields\'><Select name=\'name_suffix\' id=\'name_suffix\' tabIndex=\'19\'>\n\t<Option value=\'\'>----";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 =" ----</option>\n\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n       <Option value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\' >";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</option>\n    ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t</select><input type=\'hidden\' name=\'name_suffix_reqd_yn\' id=\'name_suffix_reqd_yn\' value=\'Y\'></input>\n   ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t</select><input type=\'hidden\' name=\'name_suffix_reqd_yn\' id=\'name_suffix_reqd_yn\' value=\'N\'></input>\n  ";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n</tr>\n</table>\n</td>\n</tr>\n</table>\n<table width=\'100%\' align=\'center\'  cellpadding=\"1\" cellspacing=\"0\" border=0>\n  <tr>\n\t<td class=\'label\' width=\'24%\'>";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</td>\n\t<td class=\'fields\' width=\'25%\'>\n\t\n\t<!--below lines modified by Suresh.M on 28-Nov-2012 againist RUT-SCF-0160 [IN:033589] and  RUT-CRF-0060 [IN029598]  -->\n<input type=\'text\' name=\'appt_ref_no\' id=\'appt_ref_no\' size=\'15\' maxlength=\'8\' onkeypress=\"readyToBlur(event);\">  \n <!--RUT-SCF-0160 [IN:033589] and RUT-CRF-0060 [IN029598] -->\n\n\n\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="</td>\n    <td class=\'fields\' ><input type=\"text\" name=\"pract_name\" id=\"pract_name\" maxlength=\"30\" size=\"25\" onBlur=\"onBlurCallPractitionerSearch(document.forms[0].pract_butt,pract_name)\"  ><input type=\"button\" name=\"pract_butt\" id=\"pract_butt\" value=\"?\" class=\"button\" onClick=\"callPractSearch(this,pract_name);\" >\n\t<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"\">\t\n    </td>\n\t</td>\n\t</tr>\n\t<tr>\n\t\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</td>\n\t<td class=\'fields\' width=\'25%\'><select name=\"locn_type\" id=\"locn_type\" onchange=\'clearList();\'><option value=\"\">------ ";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =" ------\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\n\t\t\t</select>\n\t\t</td>\n\n\t<td class=\'label\' width=\'25%\'>\n\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t</td>\n\t<td class=\'fields\' width=\'25%\'><INPUT TYPE=\"text\" name=\"clinic_desc\" id=\"clinic_desc\"   onblur=\'selectClinic1(clinic_desc,clinic_code);return makeValidString(this);\'  value=\'\' size=\'25\'><input type=button class=button value=\'?\' name=\'clinic1\' id=\'clinic1\' onClick=\'selectClinic(clinic_desc,clinic_code);\' >\n\t<INPUT TYPE=\"hidden\"  name=\'clinic_code\' id=\'clinic_code\'>\n\t</td>\n\t\n\t</tr>\n\t<!--Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] Start-->\n\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t<tr>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</td>\n\t<td class=\'fields\' width=\'25%\'><input type=\'checkbox\' name=\'extApptOnly\' id=\'extApptOnly\' value=\'Y\'></td>\n\n\t<td class=\'label\'colspan=\"2\">&nbsp;</td>\n\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t<!--Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446] End-->\n\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="&nbsp;";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</td>\n\t<td class=\'fields\' width=\'25%\'><input type=\'checkbox\' name=\'virtualConsultVisit\' id=\'virtualConsultVisit\' value=\'N\' ></td>\n\t<td class=\'label\'colspan=\"2\">&nbsp;</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t<tr>\n\t\n\t<td colspan=4 align=\'right\'><input type=button class=button value=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\' name=\'bookingappointment\' onclick=\"appointment(false,\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\');\"> <input type=\"button\" name=\"search\" id=\"search\" value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'   onClick=\"image_clickappt(\'search\')\"   class=\"Button\">             \n    <input type=\"button\" name=\"clear\" id=\"clear\" value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\'      onClick=\"clear_all()\" class=\"Button\"></td>\n   </tr>\n";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t<td  class=\'Fields\' >\n\t<input type=\'text\' name=\'referal_id1\' id=\'referal_id1\' value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\' maxlength=\'20\' size=\'25\' onblur=\"setValue(\'referral\',this);\"   onChange= \"setValue(\'referral\',this);if(document.getElementById(\'srch_code\')!=null)document.getElementById(\'srch_code\').click()\"><input type=\'button\' class=\'button\' value=\'?\' name=\'ref_id_search\' id=\'ref_id_search\' onClick=\'getReferralID()\'></td>\n     ";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t</tr>\n\t<tr>\n\t <td align=\'right\' colspan=4> <input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\' onclick=\"image_click1(\'search\',\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\',pat_id1.value,referal_id1.value)\"  name=\'srch_code\' id=\'srch_code\'>&nbsp;<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\' onclick=\'clearData()\' name=\'clear1\'></td>\n\t<td   align=\'center\' id=\'button_item1\'></td>\n<!-- <td width=\'20%\'></td> -->\n";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n</tr>\n";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t<tr>\n\t <td class=label >";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</td>\n\t <td class=\'Fields\' ><input type=text name=\'r_town_code\' id=\'r_town_code\' size=\'25\'  maxlength=\'30\' onchange=\"if(this.value != \'\')searchCommonCode(town_code,r_town_code,\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\')\"><INPUT TYPE=\'button\' class=\'button\' name=\'town_code\' id=\'town_code\' value=\'?\' onclick=\'searchCommonCode(this,r_town_code,\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\")\' tabindex=\'$\'>\n\t </td>\n\t<td class=label >";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 =" </td>\n\t<td class=Fields align=left>\t\n\t<input type=\'text\' name=\'r_area_code\' id=\'r_area_code\' size=\'25\'  onchange= \"if(this.value != \'\')searchCommonCode(area_code,r_area_code,\'";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\')\"><input type=\'button\' name=\'area_code\' id=\'area_code\' value=\'?\' class=\'button\' onclick=\"searchCommonCode(this,r_area_code,\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\')\"></td></tr><tr><td class=label  >";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="</td><td class=fields colspan=4><input type=text name=\'r_region_code\' id=\'r_region_code\'  size=\'25\'   onchange= \"if(this.value != \'\')searchCommonCode(region_code,r_region_code,\'";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\')\"><input type=\'button\' name=\'region_code\' id=\'region_code\' value=\'?\' class=\'button\' onclick=\"searchCommonCode(this,r_region_code,\'";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\')\" ></td></tr>\n\t<tr>\n    <td  class=label >";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="</td><td>\n\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t<select name=\"speciality\" id=\"speciality\" tabindex=1 > \n\t<option value=\"\">---------";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="----------</option>\n\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t</select>\n\t</td>\n\t";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t<td class=\'label\'   >";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="</td><td class=\'fields\'>\n\t<input type=text name=\'category_desc_txt\' id=\'category_desc_txt\' size=\'25\' onblur=\"clear_vals()\" ><input type=\'button\' class=\'button\' value=\'?\'  name=\'search_or\' id=\'search_or\' onClick=\"callCataegorySearch();\"   tabindex=0>\n\t<input type=\"hidden\" name=\"category_code\" id=\"category_code\">\t\n\t</td> \n\t<td ></td>\n\t</tr>\n\t\n\t<tr><td class=\'label\'  >";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="</td><td><input type=text name=\'WaitListNo\' id=\'WaitListNo\' size=\'27\' maxlength=\'12\' value=\'\' tabindex=4></td>\n\t<td class=\'label\'   >";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="</td><td  class=\'Fields\' ><select name=\'priority\' id=\'priority\'>\n\t<option value=\'\'>--------";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="---------</option>\n\t<option value=\'U\'>";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</option>\n\t<option value=\'S\'>";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 =" &nbsp</option>\n\t<option value=\'N\'>";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 =" &nbsp</option>\n\t</select>\n\t</td>\n\t</tr>\n\n<tr>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t</td>\n\t<td class=\'fields\' width=\'25%\'><INPUT TYPE=\"text\" name=\"clinic_desc\" id=\"clinic_desc\"   onblur=\'selectClinic1(clinic_desc,clinic_code);return makeValidString(this);\'  value=\'\' size=\'25\'><input type=button class=button value=\'?\' name=\'clinic1\' id=\'clinic1\' onClick=\'selectClinic(clinic_desc,clinic_code);\' >\n\t<INPUT TYPE=\"hidden\"  name=\'clinic_code\' id=\'clinic_code\'>\n\t</td>\n\t</tr>\n\t\n\n<tr>\n\t<td class=\'label\'  >";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="</td><td class=\'Fields\'><input type=\'text\' name=\'frmDate\'  id=\'appt_from_dt\' value=\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\' size=\'8\' maxlength=\'10\' onBlur=\"validDateObj(this,\'DMY\',localeName);\"><img id=\'img1\' src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'appt_from_dt\');\" style=\"cursor=\'hand\'\"></img>-<input type=text name=\'ToDate\'  id=\'appt_to_dt\' size=\'8\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\' onBlur=\"validDateObj(this,\'DMY\',localeName);\" tabindex=10><img id=\'img2\'   src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"return showCalendar(\'appt_to_dt\');\" style=\"cursor=\'hand\'\"></img>\n\t<!-- if (CheckDate(this)) validate_date1(document.forms[0].frmDate,this); -->\n\t</td> \n\t</td>\n\t<td align=\'right\' colspan=2><input type=\'button\' name=\'search\' id=\'search\' value=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\' class=\'button\' onClick=\"WaitList();\" tabindex=12><input type=button name=\'Clear\' id=\'Clear\' value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\' class=\'button\' onClick=\'clearData();\' tabindex=13>\n\t<td ></td>\n\t</tr>\n";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\n</table>\n\n";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\t\n";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n<input type=\'hidden\' name=\'emer_regn_allow_yn\' id=\'emer_regn_allow_yn\' value=\'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\'>\n<input type=\'hidden\' name=\'visit_for_inpat_yn\' id=\'visit_for_inpat_yn\' value=\'";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\'>\n<input type=\'hidden\' name=\'build_episode_rule\' id=\'build_episode_rule\' value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\">\n\n<input type=\'hidden\' name=\'register_visit_yn\' id=\'register_visit_yn\' value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\n\n<input type=\'hidden\' name=\'oa_install_yn\' id=\'oa_install_yn\' value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n<input type=\'hidden\' name=\'or_install_yn\' id=\'or_install_yn\' value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n<input type=\'hidden\' name=\'functionId\' id=\'functionId\' value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\n<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n<input type=\'hidden\' name=\'wait_list_inv\' id=\'wait_list_inv\' value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n<input type=\'hidden\' name=\'bl_interface_yn\' id=\'bl_interface_yn\' value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n<input type=\'hidden\' name=\'register_visit_walkin\' id=\'register_visit_walkin\' value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\n<input type=\'hidden\' name=\'register_visit_referral\' id=\'register_visit_referral\' value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\n<input type=\'hidden\' name=\'register_pat_yn\' id=\'register_pat_yn\' value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\">\n<input type=\'hidden\' name=\'currentdate\' id=\'currentdate\' value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n<!--below line upt_contact_dtls_oa_yn field added by venkatesh.S on 26-11-2014 against HSA-CRF-0226 [IN:050599] -->\n<input type=\'hidden\' name=\'upt_contact_dtls_oa_yn\' id=\'upt_contact_dtls_oa_yn\' value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\n\n<input type=\'hidden\' name=\'alt_id1_desc\' id=\'alt_id1_desc\' value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\">\n<input type=\'hidden\' name=\'alt_id2_desc\' id=\'alt_id2_desc\' value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n<input type=\'hidden\' name=\'alt_id3_desc\' id=\'alt_id3_desc\' value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n<input type=\'hidden\' name=\'alt_id4_desc\' id=\'alt_id4_desc\' value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n<input type=\'hidden\' name=\'names_in_oth_lang_yn\' id=\'names_in_oth_lang_yn\' value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\n<input type=\'hidden\' name=\'accept_dis_inv_no\' id=\'accept_dis_inv_no\' value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\n<input type=\'hidden\' name=\'tabName\' id=\'tabName\' value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\">\n<input type=\'hidden\' name=\'isPractoApptApplYN\' id=\'isPractoApptApplYN\' value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\"> <!--Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446]-->\n<input type=\'hidden\' name=\'isVirtualConsultationVisit\' id=\'isVirtualConsultationVisit\' value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\" <!--  Added by lakshmanan ML-MMOH-CRF-1930 -->\n<input type=hidden name=\'r_town\' id=\'r_town\' value=\'\'> \n<input type=hidden name=\'m_town\' id=\'m_town\' value=\'\'> \n<input type=hidden name=\'r_area\' id=\'r_area\' value=\'\'> \n<input type=hidden name=\'m_area\' id=\'m_area\' value=\'\'> \n<input type=hidden name=\'r_region\' id=\'r_region\' value=\'\'> \n<input type=hidden name=\'m_region\' id=\'m_region\' value=\'\'> \n<input type=hidden name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\'> \n<input type=hidden name=\'queryString\' id=\'queryString\' value=\'";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\'> \n <input type=hidden name=\'entitlement_by_cat_yn\' id=\'entitlement_by_cat_yn\' value=\'";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\'> \n \n</form>\n</html>\n\n\n\n\n";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	String bean_id		= "PkgApprovalBean" ;
	String bean_name	= "eBL.PkgApprovalBean";
	PkgApprovalBean bean			= (PkgApprovalBean)getBeanObject( bean_id, bean_name, request ) ;
	String bean_id1		= "PkgAssociateBean" ;
	String bean_name1	= "eBL.PkgAssociateBean";
	PkgAssociateBean bean1			= (PkgAssociateBean)getBeanObject( bean_id1, bean_name1, request ) ;
	String bean_id2		= "PkgSubsBean" ;
	String bean_name2= "eBL.PkgSubsBean";
	PkgSubsBean bean2			= (PkgSubsBean)getBeanObject( bean_id2, bean_name2, request ) ;

	String bean_id3		= "PkgEnterReceptRefundBean" ;
	String bean_name3= "eBL.PkgEnterReceptRefundBean";
	PkgEnterReceptRefundBean bean3	= (PkgEnterReceptRefundBean)getBeanObject( bean_id3, bean_name3, request ) ; 
	
	String bean_id4		= "PkgDiscountBean" ;
	String bean_name4	= "eBL.PkgDiscountBean";
	PkgDiscountBean bean4			= (PkgDiscountBean)PersistenceHelper.getBeanObject( bean_id4, bean_name4, request) ;			

	bean.clearBean();
	bean1.clearBean();
	bean2.clearBean();
	bean3.clearBean();
	bean4.clearBean();
	
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id1,bean1,request);
	putObjectInBean(bean_id2,bean2,request);
	putObjectInBean(bean_id3,bean3,request);
	putObjectInBean(bean_id4,bean4,request);
	
	Connection con = null;
    PreparedStatement pstmt=null;
	Statement stmt=null;
	ResultSet rs=null;
   	String facilityid = checkForNull((String) session.getValue("facility_id"));	
	String locale = checkForNull((String)session.getAttribute("LOCALE"));
	String login_user = checkForNull((String)session.getAttribute("login_user"));//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
	String entitlement_by_cat_yn="";
	String First_Name_Accept_Yn ="";
	String First_Name_Prompt ="";
	String Second_Name_Accept_Yn ="";
	String Second_Name_Prompt ="";
	String Third_Name_Accept_Yn ="";
	String Third_Name_Prompt ="";
	String Family_Name_Accept_Yn ="";
	String Family_Name_Prompt ="";
	String Name_Suffix_Accept_Yn ="";
	String query_string=request.getParameter("query_string")==null?"":request.getParameter("query_string");	
	
	String patient=request.getParameter("patient")==null?"":request.getParameter("patient");
	String referral_id =request.getParameter("referral_id")==null?"":request.getParameter("referral_id");
	String register_visit_walkin=request.getParameter("register_visit_walkin")==null?"":request.getParameter("register_visit_walkin");
	String register_visit_referral=request.getParameter("register_visit_referral")==null?"":request.getParameter("register_visit_referral");
	String Name_Suffix_Prompt ="";
	String Name_Prefix_Accept_Yn = "";
	String register_visit_yn=request.getParameter("register_visit_yn")==null?"":request.getParameter("register_visit_yn");
	String Name_Prefix_Prompt = "";
	String First_Name_Reqd_Yn ="";
	String Second_Name_Reqd_Yn ="";
	String Third_Name_Reqd_Yn ="";
	String Family_Name_Reqd_Yn ="";
	String Name_Suffix_Reqd_Yn ="";
	String Name_Prefix_Reqd_Yn ="";		
	String pat_name_as_multipart_yn="";
    String register_pat_yn="N";
	String names_in_oth_lang_yn="";
	String build_episode_rule 
   	=request.getParameter("build_episode_rule")==null?"":request.getParameter("build_episode_rule");
    String emer_regn_allow_yn=(request.getParameter("emer_regn_allow_yn") == null)?"N":request.getParameter("emer_regn_allow_yn");
	String visit_for_inpat_yn=(request.getParameter("visit_for_inpat_yn") == null)?"N":request.getParameter("visit_for_inpat_yn");
	
	//Added for this incident 52619
	String locn_code=(request.getParameter("locn_code") == null)?"":request.getParameter("locn_code");
	String practitioner_id=(request.getParameter("practitioner_id") == null)?"":request.getParameter("practitioner_id");
	String bl_interface_yn=request.getParameter("bl_interface_yn")==null?"":request.getParameter("bl_interface_yn");
	String functionId=(request.getParameter("function_id") == null)?"":request.getParameter("function_id");
	
	String wait_list_inv=(request.getParameter("wait_list_inv") == null)?"":request.getParameter("wait_list_inv");
	String oa_install_yn=(request.getParameter("oa_install_yn") == null)?"":request.getParameter("oa_install_yn");
   
	String or_install_yn=(request.getParameter("or_install_yn") == null)?"":request.getParameter("or_install_yn");
	
	String oper_stn_id=(request.getParameter("oper_stn_id") == null)?"":request.getParameter("oper_stn_id");
	register_pat_yn=(request.getParameter("register_pat_yn") == null)?"":request.getParameter("register_pat_yn");

	String tabName=request.getParameter("objName")==null?"":request.getParameter("objName");
	
	
	String accept_dis_inv_no=(request.getParameter("accept_dis_inv_no") == null)?"":request.getParameter("accept_dis_inv_no");
	
	String appt_refno_flag=(request.getParameter("q_appt_ref_no") == null)?"":request.getParameter("q_appt_ref_no"); //modified this line incident[52415] 
	
	String appt_service_code=(request.getParameter("service_code") == null)?"":request.getParameter("service_code"); //modified this line incident[52513] 
	
	String invitation_no=(request.getParameter("invitation_no") == null)?"":request.getParameter("invitation_no"); //modified this line incident[52619]
	
	String facility_id=(request.getParameter("facility_id") == null)?"":request.getParameter("facility_id"); //modified this line incident[52619] 
	
	String episode=(request.getParameter("episode") == null)?"":request.getParameter("episode"); //added this line incident[52854] 
	String record=(request.getParameter("record") == null)?"":request.getParameter("record"); //added this line incident[52854] 
	//String oper_stn_id=(request.getParameter("oper_stn_id") == null)?"":request.getParameter("oper_stn_id"); //added this line incident[52854] 
	
	String currentdate="";
	String currentdate_display="";
	String res_area_prompt = "";
	String res_town_prompt = "";
	String region_prompt = "";
	String loctype = "";
	String loctypedesc = ""; 
	String alt_id1_desc = "";
	String alt_id2_desc = "";
	String alt_id3_desc = "";
	String alt_id4_desc = "";
	String upt_contact_dtls_oa_yn="";//added changes for HSA-CRF-0226 [IN:050599]
	int pat_id_len = 0; 
    int First_Name_Order=0;
	int Second_Name_Order =0;
	int Third_Name_Order =0;
	int Family_Name_Order =0;
 	String sql="";
	String customer_id="";
	boolean isSiteSpe_change_pat_dtls=false;// added by munisekhar for MMS-QH-CRF-0162
	boolean isVirtualConsultationVisit=false;// added by Lakhsmanan for ML-MMOH-CRF-1930 US007
	boolean isPractoApptApplYN=false;//Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446]

	String  family_name_length	= "";
	String 	fam_name_ind		= "N";/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
try
{
	con = ConnectionManager.getConnection(request);
	 isPractoApptApplYN= CommonBean.isSiteSpecific(con,"OP","OP_AUTO_APPLY_PRACTO_APPT");//Added By Dharma on 19th June 2019 against KDAH-CRF-0525.1 [IN:070446]
	 isVirtualConsultationVisit=CommonBean.isSiteSpecific(con,"OP","VIRTUAL_CONSULTATION"); // added by Lakshmanan for ML-MMOH-CRF-1930 US007
	//sql ="Select to_char(sysdate,'dd/mm/yyyy') sysdt, patient_id_length, First_Name_Accept_Yn, First_Name_Order, First_Name_Prompt, Second_Name_Accept_Yn, Second_Name_Order, Second_Name_Prompt, Third_Name_Accept_Yn, Third_Name_Order, Third_Name_Prompt, Family_Name_Accept_Yn, Family_Name_Order, Family_Name_Prompt , name_suffix_accept_yn, name_prefix_accept_yn, name_suffix_prompt, name_prefix_prompt, first_name_reqd_yn, second_name_reqd_yn, third_name_reqd_yn, family_name_reqd_yn, name_suffix_reqd_yn, name_prefix_reqd_yn, nat_id_length,pat_name_as_multipart_yn, entitlement_by_pat_cat_yn, names_in_oth_lang_yn from mp_param";
	
	 sql ="Select to_char(sysdate,'dd/mm/yyyy') sysdt, patient_id_length, First_Name_Accept_Yn, First_Name_Order,ENTITLEMENT_BY_PAT_CAT_YN, First_Name_Prompt, Second_Name_Accept_Yn, Second_Name_Order, Second_Name_Prompt, Third_Name_Accept_Yn, Third_Name_Order, Third_Name_Prompt, Family_Name_Accept_Yn, Family_Name_Order, Family_Name_Prompt , name_suffix_accept_yn, name_prefix_accept_yn, name_suffix_prompt, name_prefix_prompt, first_name_reqd_yn, second_name_reqd_yn, third_name_reqd_yn, family_name_reqd_yn, name_suffix_reqd_yn, name_prefix_reqd_yn, nat_id_length,pat_name_as_multipart_yn, names_in_oth_lang_yn,mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id1_type,'"+locale+"','1') alt_id1_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id2_type,'"+locale+"','1') alt_id2_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id3_type,'"+locale+"','1') alt_id3_desc,  mp_get_desc.MP_ALTERNATE_ID_TYPE(alt_id4_type,'"+locale+"','1') alt_id4_desc,upt_contact_dtls_oa_yn, NVL(family_name_length,0) family_name_length from mp_param  ";

	 pstmt = con.prepareStatement(sql);
     rs = pstmt.executeQuery();

	 if (rs != null && rs.next() )
     {
		 alt_id1_desc = rs.getString("alt_id1_desc")==null?"":rs.getString("alt_id1_desc");
		 alt_id2_desc = rs.getString("alt_id2_desc")==null?"":rs.getString("alt_id2_desc");
		 alt_id3_desc = rs.getString("alt_id3_desc")==null?"":rs.getString("alt_id3_desc");
		 alt_id4_desc = rs.getString("alt_id4_desc")==null?"":rs.getString("alt_id4_desc");
		 
		 upt_contact_dtls_oa_yn = rs.getString("upt_contact_dtls_oa_yn");//added changes for HSA-CRF-0226 [IN:050599]
		 /*Below line was added by venkatesh.S (4008) on 10-Oct-2012 aginst  ML-BRU-SCF-0336 [IN:034501]*/
		 // customer_id = rs.getString("customer_id")==null?"":rs.getString("customer_id");
		 /*end SCF ML-BRU-SCF-0336 [IN:034501] */
		 
		 names_in_oth_lang_yn = rs.getString("names_in_oth_lang_yn")==null?"N":rs.getString("names_in_oth_lang_yn"); 	
		 pat_id_len = rs.getInt("patient_id_length") ;
		 
		 entitlement_by_cat_yn = rs.getString("ENTITLEMENT_BY_PAT_CAT_YN")==null?"N":rs.getString("ENTITLEMENT_BY_PAT_CAT_YN"); 	
		 
	 }

	if(wait_list_inv.equals("N"))
	{         
			First_Name_Accept_Yn = rs.getString("First_Name_Accept_Yn")==null?"":rs.getString("First_Name_Accept_Yn");
			First_Name_Order = rs.getInt("First_Name_Order");
			First_Name_Prompt = rs.getString("First_Name_Prompt")==null?"":rs.getString("First_Name_Prompt");
			Second_Name_Accept_Yn = rs.getString("Second_Name_Accept_Yn")==null?"":rs.getString("Second_Name_Accept_Yn");
			Second_Name_Order = rs.getInt("Second_Name_Order");
			Second_Name_Prompt = rs.getString("Second_Name_Prompt")==null?"":rs.getString("Second_Name_Prompt");
			Third_Name_Accept_Yn = rs.getString("Third_Name_Accept_Yn")==null?"":rs.getString("Third_Name_Accept_Yn");
			Third_Name_Order = rs.getInt("Third_Name_Order");
			Third_Name_Prompt = rs.getString("Third_Name_Prompt")==null?"":rs.getString("Third_Name_Prompt");
			Family_Name_Accept_Yn = rs.getString("Family_Name_Accept_Yn")==null?"":rs.getString("Family_Name_Accept_Yn");
			Family_Name_Order = rs.getInt("Family_Name_Order");
			Family_Name_Prompt = rs.getString("Family_Name_Prompt")==null?"":rs.getString("Family_Name_Prompt");
			Name_Suffix_Accept_Yn = rs.getString("name_suffix_accept_yn")==null?"":rs.getString("name_suffix_accept_yn");
			Name_Prefix_Accept_Yn = rs.getString("name_prefix_accept_yn")==null?"":rs.getString("name_prefix_accept_yn");
			Name_Suffix_Prompt = rs.getString("name_suffix_prompt")==null?"":rs.getString("name_suffix_prompt");
			Name_Prefix_Prompt = rs.getString("name_prefix_prompt")==null?"":rs.getString("name_prefix_prompt");
			First_Name_Reqd_Yn = rs.getString("first_name_reqd_yn")==null?"":rs.getString("first_name_reqd_yn");
			Second_Name_Reqd_Yn = rs.getString("second_name_reqd_yn")==null?"":rs.getString("second_name_reqd_yn");
			Third_Name_Reqd_Yn = rs.getString("third_name_reqd_yn")==null?"":rs.getString("third_name_reqd_yn");
			Family_Name_Reqd_Yn = rs.getString("family_name_reqd_yn")==null?"":rs.getString("family_name_reqd_yn");
			Name_Suffix_Reqd_Yn = rs.getString("name_suffix_reqd_yn")==null?"":rs.getString("name_suffix_reqd_yn");
			Name_Prefix_Reqd_Yn = rs.getString("name_prefix_reqd_yn")==null?"":rs.getString("name_prefix_reqd_yn");
			pat_name_as_multipart_yn=rs.getString("pat_name_as_multipart_yn")==null?"":rs.getString("pat_name_as_multipart_yn");
		    currentdate=checkForNull(rs.getString("sysdt")); 

		    /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299*/
		    if(First_Name_Accept_Yn.equals("N")&&Second_Name_Accept_Yn.equals("N") && Third_Name_Accept_Yn.equals("N") &&Family_Name_Accept_Yn.equals("Y")){
		   family_name_length=rs.getString("family_name_length")==null?"":rs.getString("family_name_length");
			fam_name_ind ="Y";	
		   	}						 
        
	}

	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
		
	if(wait_list_inv.equals("Y"))
	{
		String prompt_sql = "select to_char(sysdate,'dd/mm/yyyy') sysdt, initcap(res_area_prompt)res_area_prompt, initcap(res_town_prompt)res_town_prompt, postal_code_prompt, initcap(region_prompt)region_prompt from sm_site_param_lang_vw where language_id='"+locale+"'";	
		
		stmt=con.createStatement();
		ResultSet rs1 = stmt.executeQuery(prompt_sql) ;

		while(rs1.next())
		{
			res_area_prompt=rs1.getString("res_area_prompt")==null?"":rs1.getString("res_area_prompt");
			res_town_prompt=rs1.getString("res_town_prompt")==null?"":rs1.getString("res_town_prompt");
			region_prompt=rs1.getString("region_prompt")==null?"":rs1.getString("region_prompt");
		    currentdate=checkForNull(rs1.getString("sysdt")); 		
		}
        if(rs1!=null) rs1.close();	 	
     }
		currentdate_display = DateUtils.convertDate(currentdate,"DMY","en",locale);
		
	
	//end  RUT-CRF-0060 [IN029598]
	
            _bw.write(_wl_block9Bytes, _wl_block9);

		//Added jsp:param name ="fun_id" tag by Ashwin K for AAKH-CRF-0150 
		if(!wait_list_inv.equals("")) {
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponentCriteria.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("nat_id_disabled"), weblogic.utils.StringUtils.valueOf(register_pat_yn
                        )},{ weblogic.utils.StringUtils.valueOf("tab_name"), weblogic.utils.StringUtils.valueOf(tabName
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block14Bytes, _wl_block14);

		} else {
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            {java.lang.String __page ="../../eMP/jsp/natAltIDComponentCriteria.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("patient_id"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("alert_reqd_yn"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("nat_id_disabled"), weblogic.utils.StringUtils.valueOf(register_pat_yn
                        )},{ weblogic.utils.StringUtils.valueOf("validateIdYN"), weblogic.utils.StringUtils.valueOf("N")},{ weblogic.utils.StringUtils.valueOf("tab_name"), weblogic.utils.StringUtils.valueOf(tabName
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block16Bytes, _wl_block16);

		}
	
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pat_id_len));
            _bw.write(_wl_block20Bytes, _wl_block20);
// added by munisekhar for MMS-QH-CRF-0162
				 isSiteSpe_change_pat_dtls= CommonBean.isSiteSpecific(con,"OP","INVOKE_CHANGE_PATIENT_DETIALS");
				 int userFunRightsCount		= 0;//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
				if(isSiteSpe_change_pat_dtls)
				{
					userFunRightsCount	= CommonBean.getUserFunRightsCount(con,login_user,"CHG_PAT_DTLS","MP");//Added by Dharma on 25th July against MMS-DM-CRF-0108 [IN:064794]
					if(userFunRightsCount > 0) {
					
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
                }
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(isSiteSpe_change_pat_dtls));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(userFunRightsCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(appt_refno_flag));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(appt_service_code));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(invitation_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(episode));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(record));
            _bw.write(_wl_block33Bytes, _wl_block33);

		if(wait_list_inv.equals("Y"))
       {
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
}
    else
	   if(wait_list_inv.equals("N"))
        {
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
}
	    else
           {
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block38Bytes, _wl_block38);

		
	if(wait_list_inv.equals("Y"))
       {
            _bw.write(_wl_block39Bytes, _wl_block39);
}
      else if(wait_list_inv.equals("N"))
	     { 
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
if(names_in_oth_lang_yn.equals("Y")) { 
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
}else {
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);

     if ( Name_Prefix_Accept_Yn.equals("Y") )
      {
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(Name_Prefix_Prompt));
            _bw.write(_wl_block36Bytes, _wl_block36);
}
	  
	if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 ) 
	{
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(First_Name_Prompt));
            _bw.write(_wl_block52Bytes, _wl_block52);
}else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 ){
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(Second_Name_Prompt));
            _bw.write(_wl_block52Bytes, _wl_block52);
}else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 ){
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(Third_Name_Prompt));
            _bw.write(_wl_block52Bytes, _wl_block52);
}else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 ){
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block52Bytes, _wl_block52);
}
	  
	if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ) 
	{
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(First_Name_Prompt));
            _bw.write(_wl_block52Bytes, _wl_block52);
}else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ) {
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Second_Name_Prompt));
            _bw.write(_wl_block56Bytes, _wl_block56);

	}else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )  {
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Third_Name_Prompt));
            _bw.write(_wl_block52Bytes, _wl_block52);
}else  if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 ){
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block56Bytes, _wl_block56);
}

	 
	 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 ) {
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(First_Name_Prompt));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else 
	 if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 ) {
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(Second_Name_Prompt));
            _bw.write(_wl_block58Bytes, _wl_block58);
}else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )  {
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(Third_Name_Prompt));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 ) {
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block35Bytes, _wl_block35);
}
	 if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 ) {
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(First_Name_Prompt));
            _bw.write(_wl_block35Bytes, _wl_block35);
}else  if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ) {
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(Second_Name_Prompt));
            _bw.write(_wl_block56Bytes, _wl_block56);
}
      else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )  {
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(Third_Name_Prompt));
            _bw.write(_wl_block36Bytes, _wl_block36);
} else
	  if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4  && Family_Name_Prompt!=null  ) {
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(Family_Name_Prompt));
            _bw.write(_wl_block62Bytes, _wl_block62);
}if ( Name_Suffix_Accept_Yn.equals("Y") && Name_Suffix_Prompt!=null){
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(Name_Suffix_Prompt));
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block64Bytes, _wl_block64);
if (Name_Prefix_Accept_Yn.equals("Y") )
{
    if(pat_name_as_multipart_yn.equals("N"))  {
            _bw.write(_wl_block65Bytes, _wl_block65);
}
	   else{
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

		
	  
	  sql="Select decode('"+locale+"', 'en', Name_Prefix, name_prefix_loc_lang) Name_Prefix from Mp_Name_Prefix where eff_status='E' order by 1";
	
		
		pstmt=con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		if (rs != null)
		{
          while( rs.next() ) {
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(checkForNull(rs.getString("Name_Prefix"))));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(checkForNull(rs.getString("Name_Prefix"))));
            _bw.write(_wl_block71Bytes, _wl_block71);
}
		 }

		 if(rs!=null) rs.close();
		 if(pstmt!=null) pstmt.close();
  
            _bw.write(_wl_block72Bytes, _wl_block72);

	if (Name_Prefix_Reqd_Yn.equals("Y")  ){
            _bw.write(_wl_block73Bytes, _wl_block73);
}else{
            _bw.write(_wl_block74Bytes, _wl_block74);
}
            _bw.write(_wl_block75Bytes, _wl_block75);
}

  if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==1 )
   {
            _bw.write(_wl_block76Bytes, _wl_block76);
if (First_Name_Reqd_Yn.equals("Y")  ){
            _bw.write(_wl_block77Bytes, _wl_block77);
}else{
            _bw.write(_wl_block78Bytes, _wl_block78);
}
            _bw.write(_wl_block79Bytes, _wl_block79);
 } else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==1 )
       {
            _bw.write(_wl_block80Bytes, _wl_block80);

			if (Second_Name_Reqd_Yn.equals("Y")  )
			{
            _bw.write(_wl_block81Bytes, _wl_block81);
}
			else
			{
            _bw.write(_wl_block82Bytes, _wl_block82);
}
            _bw.write(_wl_block83Bytes, _wl_block83);
}
else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==1 )
{
            _bw.write(_wl_block84Bytes, _wl_block84);
if (Third_Name_Reqd_Yn.equals("Y")  )
		{
            _bw.write(_wl_block85Bytes, _wl_block85);
}else{
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block87Bytes, _wl_block87);
}else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==1 )
{/*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-Start*/
  if(fam_name_ind.equals("Y")){ 
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block90Bytes, _wl_block90);
 }else{ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-End*/
  if(pat_name_as_multipart_yn.equals("N"))
   {
            _bw.write(_wl_block91Bytes, _wl_block91);
}else{
            _bw.write(_wl_block92Bytes, _wl_block92);
}
 }if ( Family_Name_Reqd_Yn.equals("Y") ){
            _bw.write(_wl_block93Bytes, _wl_block93);
}else{
            _bw.write(_wl_block94Bytes, _wl_block94);
}out.println("</td>");}
 
  if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==2 ){
            _bw.write(_wl_block95Bytes, _wl_block95);
if (First_Name_Reqd_Yn.equals("Y")  ){
            _bw.write(_wl_block96Bytes, _wl_block96);
}else{
            _bw.write(_wl_block97Bytes, _wl_block97);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
}else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==2 ){
            _bw.write(_wl_block99Bytes, _wl_block99);

if (Second_Name_Reqd_Yn.equals("Y")  )
{
            _bw.write(_wl_block100Bytes, _wl_block100);
}else{
            _bw.write(_wl_block101Bytes, _wl_block101);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
}else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==2 )
{
            _bw.write(_wl_block102Bytes, _wl_block102);
if (Third_Name_Reqd_Yn.equals("Y")  ){
            _bw.write(_wl_block103Bytes, _wl_block103);
}else{
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
}else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==2 )
{
if(fam_name_ind.equals("Y")){ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-Start*/ 
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block90Bytes, _wl_block90);
 }else{ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-End*/
	 if(pat_name_as_multipart_yn.equals("N")){
            _bw.write(_wl_block105Bytes, _wl_block105);
}else{
            _bw.write(_wl_block106Bytes, _wl_block106);
}
	}
	if (Family_Name_Reqd_Yn.equals("Y")  ){
            _bw.write(_wl_block107Bytes, _wl_block107);
}else{
            _bw.write(_wl_block108Bytes, _wl_block108);
}
            _bw.write(_wl_block109Bytes, _wl_block109);

}

if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==3 )
 {
            _bw.write(_wl_block110Bytes, _wl_block110);
if (First_Name_Reqd_Yn.equals("Y")  ){
            _bw.write(_wl_block111Bytes, _wl_block111);
}else{
            _bw.write(_wl_block112Bytes, _wl_block112);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
}else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==3 )
{
            _bw.write(_wl_block113Bytes, _wl_block113);
if (Second_Name_Reqd_Yn.equals("Y")  )
    {
            _bw.write(_wl_block114Bytes, _wl_block114);
}else{
            _bw.write(_wl_block115Bytes, _wl_block115);
}
            _bw.write(_wl_block116Bytes, _wl_block116);
} else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==3 )
   {
            _bw.write(_wl_block117Bytes, _wl_block117);
if (Third_Name_Reqd_Yn.equals("Y")  )
      {
            _bw.write(_wl_block118Bytes, _wl_block118);
}else{
            _bw.write(_wl_block119Bytes, _wl_block119);
}
            _bw.write(_wl_block98Bytes, _wl_block98);

}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==3 )
{	
	if(fam_name_ind.equals("Y")){ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-Start*/ 
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block121Bytes, _wl_block121);
}else{ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-End*/
	if(pat_name_as_multipart_yn.equals("N")){
            _bw.write(_wl_block122Bytes, _wl_block122);
}else{
            _bw.write(_wl_block123Bytes, _wl_block123);
} }
    if (Family_Name_Reqd_Yn.equals("Y")  ){
            _bw.write(_wl_block124Bytes, _wl_block124);
}
    else
   {
            _bw.write(_wl_block125Bytes, _wl_block125);
}
            _bw.write(_wl_block98Bytes, _wl_block98);

}
if ( First_Name_Accept_Yn.equals("Y") && First_Name_Order ==4 )
{
            _bw.write(_wl_block126Bytes, _wl_block126);
if (First_Name_Reqd_Yn.equals("Y")  )
	{
            _bw.write(_wl_block127Bytes, _wl_block127);
}else{
	
            _bw.write(_wl_block128Bytes, _wl_block128);
}
            _bw.write(_wl_block75Bytes, _wl_block75);
}else if ( Second_Name_Accept_Yn.equals("Y") && Second_Name_Order ==4 ){
            _bw.write(_wl_block129Bytes, _wl_block129);

if (Second_Name_Reqd_Yn.equals("Y")  ){

            _bw.write(_wl_block130Bytes, _wl_block130);
}else{

            _bw.write(_wl_block131Bytes, _wl_block131);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
}else if ( Third_Name_Accept_Yn.equals("Y") && Third_Name_Order ==4 )
{
            _bw.write(_wl_block132Bytes, _wl_block132);


	if (Third_Name_Reqd_Yn.equals("Y")  )
	{
            _bw.write(_wl_block133Bytes, _wl_block133);

	}else
	{
            _bw.write(_wl_block134Bytes, _wl_block134);
}
            _bw.write(_wl_block75Bytes, _wl_block75);
}
else if ( Family_Name_Accept_Yn.equals("Y") && Family_Name_Order ==4 )
{
if(fam_name_ind.equals("Y")){ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-Start*/ 
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(family_name_length));
            _bw.write(_wl_block121Bytes, _wl_block121);
}else{ /*Added by Rameswar on  19-04-2016 for HSA-CRF-0299-End*/
if(pat_name_as_multipart_yn.equals("N"))
{
            _bw.write(_wl_block135Bytes, _wl_block135);
}else{
            _bw.write(_wl_block136Bytes, _wl_block136);
} }
if (Family_Name_Reqd_Yn.equals("Y")  )
{
            _bw.write(_wl_block137Bytes, _wl_block137);
}else
{
            _bw.write(_wl_block138Bytes, _wl_block138);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
}if ( Name_Suffix_Accept_Yn.equals("Y") )
{
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);

	
	sql="Select decode('"+locale+"', 'en', Name_Suffix, Name_Suffix_loc_lang) Name_Suffix from Mp_Name_Suffix where eff_status='E' order by 1";

	pstmt=con.prepareStatement(sql);
	rs = pstmt.executeQuery();
    if(rs != null ) 
	 {
       while(rs.next()) { 
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(checkForNull(rs.getString("name_suffix"))));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(checkForNull(rs.getString("Name_Suffix"))));
            _bw.write(_wl_block143Bytes, _wl_block143);
}
	}

	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

   if (Name_Suffix_Reqd_Yn.equals("Y")  )
   { 
            _bw.write(_wl_block144Bytes, _wl_block144);
}else{
            _bw.write(_wl_block145Bytes, _wl_block145);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
}
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);


							try{
								
								String sql_locn = "select locn_type,short_desc from am_care_locn_type_lang_vw where ";

								if(functionId.equals("VISIT_REGISTRATION"))
								{
									sql_locn = sql_locn + " care_locn_type_ind in ('C','E') and locn_type in ('C','E') and ";
								}
								else if(functionId.equals("PROCD_REGISTRATION"))
								{
									sql_locn = sql_locn + " care_locn_type_ind ='E' and locn_type = 'E' and ";
								}
								
								sql_locn = sql_locn + " SYS_USER_DEF_IND='S' and language_id='"+localeName+"' order by short_desc ";

								pstmt=con.prepareStatement(sql_locn);
								rs=pstmt.executeQuery();
								if(rs != null)
								{
									while(rs.next())
									{
										loctype=checkForNull(rs.getString("locn_type"));
										loctypedesc=checkForNull(rs.getString("short_desc"));					
										
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(loctype));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(loctypedesc));
            _bw.write(_wl_block152Bytes, _wl_block152);

									}
								}
								
							if(rs != null ) rs.close();
							if(pstmt != null ) pstmt.close();							

							}catch(Exception e)
							{
								e.printStackTrace();
							}

				
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
if(isPractoApptApplYN){
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
}
            _bw.write(_wl_block157Bytes, _wl_block157);
if (isVirtualConsultationVisit) { // Added by lakshmanan on 17mar2023 for ML-MMOH-CRF-1930 US007 start 
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);
 } // Added by lakshmanan on 17mar2023 for ML-MMOH-CRF-1930 US007 end  
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);

}else{
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block165Bytes, _wl_block165);
} 
	if(wait_list_inv.equals("")){
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);
}
            _bw.write(_wl_block170Bytes, _wl_block170);
if(wait_list_inv.equals("Y")){
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(res_town_prompt));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(res_town_prompt));
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(res_area_prompt));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(res_area_prompt));
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(region_prompt));
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);

	String sql5 = " Select Short_Desc,Speciality_Code  from Am_Speciality_lang_vw where Eff_Status = 'E' and language_id='"+locale+"' order by 1";
	rs = stmt.executeQuery(sql5);
	
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);

	while(rs.next()){
		out.println("<option value='" + checkForNull(rs.getString("Speciality_Code")) + "' >" + checkForNull(rs.getString("Short_Desc"))+"</option>");
	}
	
            _bw.write(_wl_block184Bytes, _wl_block184);
if(stmt!=null)stmt.close();
	if(rs!=null)rs.close();  
	

            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block187Bytes, _wl_block187);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);


							try{
								
								String sql_locn = "select locn_type,short_desc from am_care_locn_type_lang_vw where ";

								if(functionId.equals("VISIT_REGISTRATION"))
								{
									sql_locn = sql_locn + " care_locn_type_ind in ('C','E') and locn_type in ('C','E') and ";
								}
								else if(functionId.equals("PROCD_REGISTRATION"))
								{
									sql_locn = sql_locn + " care_locn_type_ind ='E' and locn_type = 'E' and ";
								}
								
								sql_locn = sql_locn + " SYS_USER_DEF_IND='S' and language_id='"+localeName+"' order by short_desc ";

								pstmt=con.prepareStatement(sql_locn);
								rs=pstmt.executeQuery();
								if(rs != null)
								{
									while(rs.next())
									{
										loctype=checkForNull(rs.getString("locn_type"));
										loctypedesc=checkForNull(rs.getString("short_desc"));					
										
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(loctype));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(loctypedesc));
            _bw.write(_wl_block152Bytes, _wl_block152);

									}
								}
								
							if(rs != null ) rs.close();
							if(pstmt != null ) pstmt.close();							

							}catch(Exception e)
							{
								e.printStackTrace();
							}

				
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(currentdate_display));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(currentdate_display));
            _bw.write(_wl_block196Bytes, _wl_block196);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block198Bytes, _wl_block198);
}
            _bw.write(_wl_block199Bytes, _wl_block199);

}
  catch(Exception e) { 
	  out.println(e.toString());
	  e.printStackTrace();
	  }
  finally 
  {
	 ConnectionManager.returnConnection(con,request);
  }


            _bw.write(_wl_block200Bytes, _wl_block200);
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(emer_regn_allow_yn));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(visit_for_inpat_yn));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(register_visit_yn));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(oa_install_yn));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(or_install_yn));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(wait_list_inv));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(bl_interface_yn));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(register_visit_walkin));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(register_visit_referral));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(register_pat_yn));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(currentdate));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(upt_contact_dtls_oa_yn));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(alt_id1_desc));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(alt_id2_desc));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(alt_id3_desc));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(alt_id4_desc));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(names_in_oth_lang_yn));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(accept_dis_inv_no));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(tabName));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(isPractoApptApplYN));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(isVirtualConsultationVisit ));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(query_string));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(entitlement_by_cat_yn));
            _bw.write(_wl_block229Bytes, _wl_block229);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.male.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.female.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.unknown.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.SearchNameWithLocalLang.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.ExternalAppointmentsOnly.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.virtualConsultation.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Visit.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bookappointment.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Town.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.area.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.region.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.category1.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.waitlistno.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.semiurgent.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Normal.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.InvitationPeriod.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
}
