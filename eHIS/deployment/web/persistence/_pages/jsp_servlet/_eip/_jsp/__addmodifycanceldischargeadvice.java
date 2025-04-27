package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifycanceldischargeadvice extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/addmodifyCancelDischargeAdvice.jsp", 1709117690723L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Function for cancelling the Discharge Advice -- 21 July 2001 --->\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<head>\n<TITLE> ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" </TITLE>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n\t  \n\t<script src=\"../js/CancelDischargeAdv.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</head>\n\n<script>\nfunction CancelDisc(obj)\n{\n\tvar canval = obj.value;\n\tif( canval == getLabel(\"Common.CancelDischargeAdvice.label\",\"Common\") )\n\t{\n\t\tdocument.getElementById(\"u\").style.visibility = \'visible\';\n\t\tdocument.canceldischarge_form.cancel_discharge.value=getLabel(\"eIP.ConfirmCancellation.label\",\"IP\");\n\t\tdocument.canceldischarge_form.close.value=getLabel(\"eIP.AbortCancellation.label\",\"IP\");\n\t\tdocument.getElementById(\"u\").innerHTML=\"\"+getLabel(\"Common.ReasonforCancellation.label\",\"Common\");\n\t\tdocument.getElementById(\"v\").innerHTML=\"\"+\"<select name=\'cancel_remarks\' id=\'cancel_remarks\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</select><img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\";\n\t\tdocument.canceldischarge_form.cancel_remarks.focus();\n\t}\n\n\tif(canval == getLabel(\"eIP.ConfirmCancellation.label\",\"IP\"))\n\t{\n\t\tif ((document.canceldischarge_form.cancel_remarks.value == \"null\") || (document.canceldischarge_form.cancel_remarks.value == \"\"))\n\t\t{\n\t\t\tvar err = getMessage(\"CAN_NOT_BE_BLANK\",\"Common\");\n\t\t\terr = err.replace(\'$\',getLabel(\"Common.ReasonforCancellation.label\",\"Common\"));\n\t\t\talert(err);\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].submit();\n\t\t}\n\t}\n}\n</script>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'canceldischarge_form\' id=\'canceldischarge_form\' action=\'../../servlet/eIP.CancelDischargeAdviceServlet\' method=\'post\' target=\'messageFrame\'>\n<table border=\'0\' cellpadding=\'4\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr><td colspan = \'7\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td></tr>\n<tr><!-- 17956 Thursday, January 07, 2010 -->\n\t  <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t  <td class=\'QUERYDATA\' width=\'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<input type=\'hidden\' name=\'admissiondatetime\' id=\'admissiondatetime\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t  </td>\n\t  <td class=\'label\' nowrap  width=\'25%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<input type=\'hidden\' name=\'encounterID\' id=\'encounterID\' value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t  </td>\n</tr>\n<tr>\n\t  <td class=\'label\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t  <td class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="<input type=\'hidden\' name=\'admissiontypedesc\' id=\'admissiontypedesc\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t  </td>\n\t  <td class=\'label\' >&nbsp;</td>\n\t  <td class=\'QUERYDATA\' >&nbsp;<input type=\'hidden\' name=\'patienttype\' id=\'patienttype\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t  </td>\t  \n</tr>\n<tr>  \n  \t  <td class=\'label\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t  \t<input type=\'hidden\' name=\'specialtyshortdesc\' id=\'specialtyshortdesc\' >\n\t  </td>\n      <td class=\'label\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t  \t<input type=\'hidden\' name=\'practitionername\' id=\'practitionername\'>\n\t  </td>\n</tr>\n    <tr>  <td class=\'label\' >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t  <td class=\'QUERYDATA\' colspan=\'3\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n      \n\t  </td>\n</tr>\n<!--Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start-->\n<tr>\n<td class=\'label\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n <td class=\'QUERYDATA\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n       \n  \t  </td>\n\t  <!--Added by kamatchi S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->\n  \t  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n  \t  <td class=\'label\' \">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" </td>\n  \t  <td class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\t\n\t  <td class=\'label\' \">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" </td>\n\t  <td class=\'QUERYDATA\' >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td> \n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t  <td class=label colspan=2 >&nbsp;</td>\n\t   ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n\t\n\t\t<!--Added by kamatchi S for ML-MMOH-CRF-1527 ON 23-JUN-2020-->\n\t\t\n</tr>\n<!--Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End-->\n<tr>\n </tr>\n  \n <td colspan = \'7\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n <tr>\n  \t  <td class=\'label\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t  <td class=\'QUERYDATA\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t  <input type=\'hidden\' name=\'nursingunitshortdesc\' id=\'nursingunitshortdesc\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t  <input type=\'hidden\' name=\'nursingunitcode\' id=\'nursingunitcode\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"><!--  Added for INC:47208 -->\n\t  </td>\n\t  <td class=\'label\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t  \t<input type=\'hidden\' name=\'serviceshortdesc\' id=\'serviceshortdesc\'>\n\t  </td>\n</tr>\n<tr>\n\t  <td class=\'label\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t  \t<input type=\'hidden\' name=\'bedno\' id=\'bedno\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t  </td>\n      \n  \t  <td class=\'label\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t  \t<input type=\'hidden\' name=\'roomno\' id=\'roomno\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t  </td>\n</tr>\n<tr>\n\t  <td class=\'label\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t  \t<input type=\'hidden\' name=\'bedclassshortdesc\' id=\'bedclassshortdesc\'>\n\t  </td>\n\t \t  <!--  <td colspan=2 class=\'label\'></td> -->\n\t  <td class=\'label\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t  \t<input type=\'hidden\' name=\'bedtypeshortdesc\' id=\'bedtypeshortdesc\'>\n\t  </td>\n   </tr>\n </table>\n\n <table border=\'0\' cellpadding=\'4\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n <td colspan=\'4\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</td>\n <tr>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n   \t  <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td><td class=\'QUERYDATA\' width=\'25%\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="<input type=\'hidden\' name=\'expected_discharge_date\' id=\'expected_discharge_date\' value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n \t  </td>\n \t  <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n \t  <td class=\'QUERYDATA\' width=\'25%\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n </tr>\n\n <tr><td colspan=4></td></tr>\n <tr>\n   \t  <td class=\'label\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n  \t  <td class=\'QUERYDATA\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n  \t  </td>\n      <td class=\'label\'>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n  \t  <td class=\'QUERYDATA\'>\n      ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n  \t  \t<img src=\'../../eCommon/images/enabled.gif\'align=\'center\'></img>\n  \t  \t<input type= \'hidden\' name=\'pmrequested\' id=\'pmrequested\' value=";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =">\n  \t  ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n  \t  \t<img src=\'../../eCommon/images/RRnwd.gif\'align=\'center\'></img>\n  \t  \t<input type= \'hidden\' name=\'pmrequested\' id=\'pmrequested\' value=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =">\n\t    <input type= \'hidden\' name=\'dischgsumsigned\' id=\'dischgsumsigned\' value=";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n  \t  </td>\n  </tr>\n  ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n  <tr>\n  <td></td>\n  <td></td>\n  <td class=\'label\'>\n   <a href=\"javascript:getDeathRegFormAccessionNum(\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\',\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\',\'\',\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\',\'\');\" id=\'deathRegFormLink\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</a>\n  </td>\n  <td></td>\n  </tr>\n  ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\n<!--Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505-->\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t<tr>\n\t\t  <td class=\'label\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t  <td class=\'QUERYDATA\'>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\n\t\t  <td class=\'label\'>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t  ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t  <td class=\'QUERYDATA\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t</tr>\n\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n<!--End GHL-CRF-0505-->\n\n   <td colspan=\'4\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</td>\n   <tr>\n       \t  <td class=\'label\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</td>\n     \t  <td class=\'QUERYDATA\'>\n     \t  ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n     \t  <img src=\'../../eCommon/images/enabled.gif\'align=\'center\'></img>\n     \t  \t<input type= \'hidden\' name=\'newmedicine\' id=\'newmedicine\' value=";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =">\n     \t  ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n     \t  <img src=\'../../eCommon/images/RRnwd.gif\'align=\'center\'></img>\n     \t  \t<input type= \'hidden\' name=\'newmedicine\' id=\'newmedicine\' value=";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n     \t  </td>\n     \t  <td class=\'label\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n     \t  <img src=\'../../eCommon/images/enabled.gif\'align=\'center\'></img>\n  \t   \t  <input type=\'hidden\' name=\'stockmedicine\' id=\'stockmedicine\'  value= ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n  \t  <img src=\'../../eCommon/images/RRnwd.gif\'align=\'center\'></img>\n  \t   \t<input type=\'hidden\' name=\'stockmedicine\' id=\'stockmedicine\'  value= ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n     \t  </td>\n   </tr>\n\n   <table border=\'0\' cellpadding=\'4\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n   <td colspan=\'4\' class=\'COLUMNHEADER\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n   <tr>\n          <td width=\'25%\' class=\'label\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td><td width=\'25%\' class=\'QUERYDATA\'>\n     \t  ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t  <img src=\'../../eCommon/images/enabled.gif\'align=\'center\'></img>\n\t\t\t<input type=\'hidden\' name=\'lab\' id=\'lab\'  value= ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =">\n\t\t  ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t  <img src=\'../../eCommon/images/RRnwd.gif\'align=\'center\'></img>\n    \t  <input type=\'hidden\' name=\'lab\' id=\'lab\'  value= ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =">\n    \t  ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n     \t  </td>\n       \t  <td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\n       \t  <td class=\'QUERYDATA\' width=\'25%\'>\n       \t  ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t  <img src=\'../../eCommon/images/enabled.gif\'align=\'center\'></img>\n\t      <input type=\'hidden\' name=\'xray\' id=\'xray\'  value= ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t  <img src=\'../../eCommon/images/RRnwd.gif\'align=\'center\'></img>\n\t\t  <input type=\'hidden\' name=\'xray\' id=\'xray\'  value= ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n     \t  </td>\n  </tr>\n  <tr>\n     \t  <td class=\'label\'>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n     \t  <img src=\'../../eCommon/images/enabled.gif\'align=\'center\'></img>\n     \t  \t<input type=\'hidden\' name=\'scan\' id=\'scan\'  value= ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =">\n  \t\t  ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n  \t\t  <img src=\'../../eCommon/images/RRnwd.gif\'align=\'center\'></img>\n    \t  \t<input type=\'hidden\' name=\'scan\' id=\'scan\'  value= ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n     \t  <img src=\'../../eCommon/images/enabled.gif\'align=\'center\'></img>\n  \t  \t  <input type=\'hidden\' name=\'scan\' id=\'scan\'  value= ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n  \t      <img src=\'../../eCommon/images/RRnwd.gif\'align=\'center\'></img>\n     \t  <input type=\'hidden\' name=\'scan\' id=\'scan\'  value= ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n     \t  </td>\n</tr>\n<tr>\t\n     \t  <td class=\'label\'>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n     \t  <img src=\'../../eCommon/images/enabled.gif\'align=\'center\'></img>\n     \t  <input type=\'hidden\' name=\'mri\' id=\'mri\'  value= ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t  <img src=\'../../eCommon/images/RRnwd.gif\'align=\'center\'></img>\n    \t  <input type=\'hidden\' name=\'mri\' id=\'mri\'  value= ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n     \t  </td>     \t \n          <td class=\'label\'>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>\n      \t  <td class=\'QUERYDATA\'>\n      \t  ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n      \t  <img src=\'../../eCommon/images/enabled.gif\'align=\'center\'></img>\n  \t      <input type=\'hidden\' name=\'rt\' id=\'rt\'  value= ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =">\n  \t      ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n  \t      <img src=\'../../eCommon/images/RRnwd.gif\'align=\'center\'></img>\n     \t  <input type=\'hidden\' name=\'rt\' id=\'rt\'  value= ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n      \t  </td>\n</tr>\n<tr>\n\t\t  <td class=\'label\'>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>\n\t\t  <td class=\'QUERYDATA\'>\n\t\t  ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t  <img src=\'../../eCommon/images/enabled.gif\'></img>\n\t\t\t\t<input type=\'hidden\' name=\'physio\' id=\'physio\'  value= ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t  <img src=\'../../eCommon/images/RRnwd.gif\'></img>\n      \t    \t<input type=\'hidden\' name=\'physio\' id=\'physio\'  value= ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =">\n      \t  ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n      \t  </td>\n      \t  <td class=\'label\'>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n      \t  <img src=\'../../eCommon/images/enabled.gif\'></img>\n  \t      <input type=\'hidden\' name=\'ecg\' id=\'ecg\'  value= ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t  <img src=\'../../eCommon/images/RRnwd.gif\'></img>\n      \t  <input type=\'hidden\' name=\'ecg\' id=\'ecg\'  value= ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n      \t  </td>\n</tr>\n<tr>\n      \t  <td class=\'label\'>";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n      \t  <img src=\'../../eCommon/images/enabled.gif\'align=\'center\'></img>\n  \t      <input type=\'hidden\' name=\'diet\' id=\'diet\'  value= ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n  \t      <img src=\'../../eCommon/images/RRnwd.gif\'align=\'center\'></img>\n      \t  <input type=\'hidden\' name=\'diet\' id=\'diet\'  value= ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n      \t  <img src=\'../../eCommon/images/enabled.gif\'align=\'center\'></img>\n  \t      <input type=\'hidden\' name=\'pharmacy\' id=\'pharmacy\'  value= \"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t  ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t  <img src=\'../../eCommon/images/RRnwd.gif\'align=\'center\'></img>\n     \t  <input type=\'hidden\' name=\'pharmacy\' id=\'pharmacy\'  value= \"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n     \t  ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n      \t  </td>\n    </tr>\n   </table>\n\n    <table border=\'0\' cellpadding=\'4\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n    <tr>\n    \t  <td width=\"25%\" class=\'label\' id=\'u\' nowrap>&nbsp;</td>          \n    \t  <td width=\"25%\" class=\'label\' id=\'v\' nowrap>&nbsp;</td>          \n\t\t  <td colspan=2 nowrap>\n\t\t  </td>\n\t</tr>\n    </table>\n    <table border=\'0\' cellpadding=\'4\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\t\t\t  \n\t<tr> \n\t\t<td class=\'label\' height=\'5\' width=\'75%\'></td>\n\t\t\n\t\t<td class=\'button\'>\n\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t<input type=button class=\'button\' name = \'cancel_discharge\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' align = \'left\' onClick=\'CancelDisc(this)\'>";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>\n\t\t<td class=\'button\' width=\'5%\'>\n\t\t<input type=button class=\'button\' name = \'close\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' align=\'left\'  onClick=\'CloseWin(this)\'></td>\n\n\t</tr>\n</table>\n\t<input type =\'hidden\' name= \'dis_adv_srl_no\' value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n\t<input type =\'hidden\' name= \'patient_id\' value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\t\n\t<input type =\'hidden\' name= \'function_id\' value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\t\n\t<input type =\'hidden\' name= \'patient_class\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\t\n\t<input type =\'hidden\' name= \'bl_interfaced_yn\' value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\t\n\t<input type =\'hidden\' name= \'bl_operational\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\t\n\t<input type =\'hidden\' name= \'death_reg_form_accession_num\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\t<!-- Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023 -->\n\t<input type =\'hidden\' name= \'callback_mode\' value=\"View\">\n\t\n</BODY>\n";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	String bl_operational	= (String)session.getValue("bl_operational");
	String bl_interfaced_yn	= "";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet prs = null;

	/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
	boolean isAadharCardAndRelAppl = false;
	String citizen_yn = "";
	JSONObject AadharCardAndRelJson	= new JSONObject();
	String alt_id4_type_desc = "";
	String alt_id4_type = "";
	JSONObject AltIdLengthAndTypeJson = new JSONObject();
	/*End GHL-CRF-0505*/

	String ReasonValues = "<option value=''>---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---</option>";

	con = ConnectionManager.getConnection(request);

	pstmt = con.prepareStatement(" select Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON_LANG_VW where LANGUAGE_ID = '"+locale+"' and Cancel_Discharge_Advice_Yn = 'Y' and Eff_Status = 'E' order by 1");
	prs = pstmt.executeQuery();
	if(prs!=null)
	{
		while(prs.next())
		{
			String contact_code = prs.getString("Contact_Reason_Code");
			String contact_desc = prs.getString("Contact_Reason");
			ReasonValues = ReasonValues+"<option value='"+contact_code+"'>"+contact_desc+"</option>"; 
		}
	}
	if(prs!=null) prs.close();

            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ReasonValues));
            _bw.write(_wl_block10Bytes, _wl_block10);

	Statement stmt=null;
	ResultSet rs =null;
	Statement stmt1		= null;
	String setup_bl_dtls_in_ip_yn = "N";
	StringBuffer SqlSB = new StringBuffer();
	try
	{
	
	stmt = con.createStatement();
	String facilityID =(String)session.getValue("facility_id");
	String encounterID=request.getParameter("EncounterId");
	String fromfunction = request.getParameter("from_function")==null?"":request.getParameter("from_function");
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");

	/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
	isAadharCardAndRelAppl	=	eCommon.Common.CommonBean.isSiteSpecific(con, "IP","AADHAR_CARD_RELATIONSHIP"); 
	Boolean isHeightAndBmiEnable = eCommon.Common.CommonBean.isSiteSpecific(con, "MP", "BMI_REG_PAT_CHNGES_RH101");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527
	AltIdLengthAndTypeJson	=	eIP.IPCommonBean.getAltIdLengthAndType(con);
	alt_id4_type_desc		=	(String)AltIdLengthAndTypeJson.get("alt_id4_type_desc");
	alt_id4_type			=	(String)AltIdLengthAndTypeJson.get("alt_id4_type");
	
	String aadhar_card_no		= "";
	String relationship_code	= "";
	String discharge_indicator	= "";
	/*End GHL-CRF-0505*/

	/* Added by Ajay Hatwate for AAKH-CRF-0179 on 22/08/2023 */
	Boolean isDeathRegisterFormAppl = false;
	String enable_death_reg_form = "N";
	String death_reg_form_accession_num = "";
	/* End of AAKH-CRF-0179 */
	/* Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023 */
	isDeathRegisterFormAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "AE", "DEATH_REGISTER_FORM_APPL"); //Added by Ajay Hatwate for AAKH-CRF-0179 on 22-08-2023
	if(isDeathRegisterFormAppl){
		enable_death_reg_form = eMP.MPCommonBean.getEnableDeathRegisterFormYN(con);
		if(enable_death_reg_form.equals("Y")){
			pstmt = con.prepareStatement(" SELECT death_reg_form_accession_num FROM PR_ENCOUNTER WHERE FACILITY_ID=? and ENCOUNTER_ID = ? ");
			pstmt.setString(1,facilityID);
			pstmt.setString(2,encounterID);
			prs = pstmt.executeQuery();
			if(prs!=null)
			{
				while(prs.next())
				{
					death_reg_form_accession_num = checkForNull(prs.getString("death_reg_form_accession_num"));
				}
			}
			if(pstmt!=null) pstmt.close();	
			if(prs!=null) prs.close();		
		}
	}
	/* End of AAKH-CRF-0179 */
/* Merged with ip_open_encounter query for PE - 11/05/2010
	SqlSB.append(" select setup_bl_dtls_in_ip_yn,bl_interfaced_yn from IP_PARAM where facility_id='"+facilityID+"' ");
	rs = stmt.executeQuery(SqlSB.toString());
	if(rs!=null )
	{
		while(rs.next())
		{
			setup_bl_dtls_in_ip_yn=rs.getString("setup_bl_dtls_in_ip_yn");
			bl_interfaced_yn	  =rs.getString("bl_interfaced_yn");
		}
	}
	if(rs!=null) rs.close();
	
	if (SqlSB.length() > 0)
		SqlSB.delete(0, SqlSB.length());
*/

 	String ph_charges_yn  = "";
	String admissiondatetime = "";
	String adm_date_display = "";
	String admissiontypedesc = "";
	String auth_pract_name = "";
	String bedclassshortdesc="";
	String bedno = "";
	String bedtypeshortdesc="";
	String diet_charges_yn  = "";
	String dis_adv_srl_no = "";
	String discharge_summary_yn = "";
	String ecg_charges_yn   = "";
	String expected_discharge_date = "";
	String gender = "";
	String lab_charges_yn  = "";
	String meddesc 		= "";
	String mri_charges_yn   = "";
	String nursingunitshortdesc = "";
	String patient_id="";
	String patienttype = "";
	String physio_charges_yn= "";
	String practitionerid= "";
	String practitionername = "";
	String ref_to_coroner_yn  =  "";
	String roomno = "";
	String rt_charges_yn  = "";
	String scan_charges_yn = "";
	String serviceshortdesc = "";
	String short_desc = "";
	String specialtyshortdesc = "";
	String take_home_new_med_yn  = "";
	String take_home_stk_med_yn  ="";
	String ultrasound_charges_yn = "";
	String xray_charges_yn  = "";
	String patient_class  = "";
	//Modified for INC:47208
	String nursingunitcode = "";

	/*dded by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start*/
	String WEIGHT_ON_ADMISSION="";
	String WEIGHT_ON_ADMISSION_UNIT="";
	String weight_on_admission_unit_display="";
	/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End*/
	
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
	String height_on_admission				= "";
	String height_on_admission_unit			= "";
	String bmi="";
	String enable_height_bmi_pat_cls="";
	/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END */

	SqlSB.append(" SELECT a.Room_num Room_No,");
	SqlSB.append(" ip_Get_desc.Ip_bed_class(a.Bed_Class_Code,?,2) Bed_Class_Short_desc,");
	SqlSB.append(" am_get_desc.AM_PRACTITIONER(a.Attend_Practitioner_Id,?,'1') practitioner_name,");
	SqlSB.append(" ip_Get_desc.Ip_bed_type(a.Bed_Type_Code,?,2) Bed_Type_Short_desc,");
	SqlSB.append(" ip_get_desc.IP_ADMISSION_TYPE(a.admission_type,?,'2') admission_short_desc, ");
	SqlSB.append(" To_char(a.Admission_Date_Time,'dd/mm/rrrr hh24:mi') admission_date_time,");
	SqlSB.append(" b.Sex Gender,");
	SqlSB.append(" Am_Get_desc.Am_speciality(a.Specialty_Code,?,2) Specialty_Short_desc,");
	SqlSB.append(" a.nurSing_Unit_Code nurSing_Unit_Code,");
	SqlSB.append(" Am_Get_desc.Am_practitioner(a.Attend_Practitioner_Id,?,1) Practitioner_Short_Name,");
	SqlSB.append(" a.Encounter_Id,");
	SqlSB.append(" a.Patient_Id,");
	SqlSB.append(" To_char(b.Date_Of_Birth,'dd/mm/rrrr hh24:mi') Date_Of_Birth,");
	SqlSB.append(" decode(?,'en', b.patient_name, nvl(b.patient_name_loc_lang, b.patient_name)) Patient_Name,");
	SqlSB.append(" ip_Get_desc.Ip_nursing_unit(a.Facility_Id, a.nurSing_Unit_Code,?,2) nurSing_Unit_Short_desc,");
	SqlSB.append(" a.Bed_num Bed_No,");
	SqlSB.append(" a.Blocked_Bed_No,");
	SqlSB.append(" a.Attend_Practitioner_Id Practitioner_Id,");
	SqlSB.append(" NULL dly_Charge,");
	SqlSB.append(" NULL Patient_Type_Short_desc,");
	SqlSB.append(" AM_GET_DESC.AM_SERVICE(service_code,?,'2') service_short_desc,");
	SqlSB.append(" DECODE(Pat_Curr_Locn_Type,'N', ip_Get_desc.Ip_nursing_unit(a.Facility_Id, a.Pat_Curr_Locn_Code,?,2),");
	SqlSB.append("                           'R', a.Pat_Curr_Locn_Code,");
	SqlSB.append(" op_Get_desc.Op_clinic(a.Facility_Id, a.Pat_Curr_Locn_Code,?,1)) Location_desc,");
	SqlSB.append(" a.patient_class patient_class, AM_GET_DESC.AM_MEDICAL_TEAM(a.facility_id, a.team_id, ?,'2') team_short_desc,");
	SqlSB.append(" c.setup_bl_dtls_in_ip_yn, c.bl_interfaced_yn,");
	SqlSB.append(" to_char(d.expected_discharge_date,'dd/mm/rrrr hh24:mi') expected_discharge_date,");
	SqlSB.append(" d.dis_adv_srl_no, ip_get_desc.IP_DISCHARGE_TYPE(d.discharge_type_code, ?, '2') short_desc, d.ref_to_coroner_yn,");
	SqlSB.append(" d.discharge_summary_yn, d.take_home_new_med_yn,");
	SqlSB.append(" d.take_home_stk_med_yn, ");
	SqlSB.append(" am_get_desc.AM_PRACTITIONER(d.auth_practitioner_id,?, '1') auth_pract_name,");
	SqlSB.append(" d.lab_charges_yn, d.xray_charges_yn, d.scan_charges_yn, d.ultrasound_charges_yn, d.mri_charges_yn, d.rt_charges_yn, d.physio_charges_yn,"); SqlSB.append("d.ecg_charges_yn, d.diet_charges_yn, d.ph_charges_yn, ");
	SqlSB.append(" a.WEIGHT_ON_ADMISSION,a.WEIGHT_ON_ADMISSION_UNIT, ");//Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123]
	SqlSB.append(" a.HEIGHT_ON_ADMISSION,a.BMI, ");//Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527		
	SqlSB.append(" b.alt_id4_no,d.relationship_code, e.indicator "); //Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505
	SqlSB.append(" FROM   IP_OPEN_ENCOUNTER a,");
	SqlSB.append("        MP_PATIENT b, ip_param c, IP_DISCHARGE_ADVICE d, IP_DISCHARGE_TYPE e "); //Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505
	SqlSB.append(" WHERE  a.facility_id = ?");
	SqlSB.append("        AND a.encounter_id = ?");
	SqlSB.append("        AND a.patient_id = b.patient_id");
	SqlSB.append("        AND a.facility_id = c.facility_id");
	SqlSB.append("        AND a.facility_id = d.facility_id");
	SqlSB.append("        AND a.encounter_id = d.encounter_id");
	SqlSB.append("        AND d.dis_adv_status='0'");
	SqlSB.append("        AND e.discharge_type_code = d.discharge_type_code"); //Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505

	pstmt = con.prepareStatement(SqlSB.toString());
	pstmt.setString(1, locale);
	pstmt.setString(2, locale);
	pstmt.setString(3, locale);
	pstmt.setString(4, locale);
	pstmt.setString(5, locale);
	pstmt.setString(6, locale);
	pstmt.setString(7, locale);
	pstmt.setString(8, locale);
	pstmt.setString(9, locale);
	pstmt.setString(10, locale);
	pstmt.setString(11, locale);
	pstmt.setString(12, locale);
	pstmt.setString(13, locale);
	pstmt.setString(14, locale);
	pstmt.setString(15, facilityID);
	pstmt.setString(16, encounterID);
	
	rs = pstmt.executeQuery();
/* 	rs=stmt.executeQuery(SqlSB.toString()); */
	if(rs.next())
	{
		admissiondatetime 		= checkForNull(rs.getString("admission_date_time"));
		adm_date_display		= DateUtils.convertDate(admissiondatetime,"DMYHM","en",locale);
		admissiontypedesc 		= checkForNull(rs.getString("admission_short_desc"));
		specialtyshortdesc 		= checkForNull(rs.getString("specialty_short_desc"));
		practitionername 		= checkForNull(rs.getString("practitioner_name"));
		patienttype 			= checkForNull(rs.getString("patient_type_short_desc"));
		nursingunitcode			= checkForNull(rs.getString("nurSing_Unit_Code")); // Added for INC:47208
		nursingunitshortdesc 	= checkForNull(rs.getString("Nursing_unit_short_desc"));
		serviceshortdesc 		= checkForNull(rs.getString("service_short_desc"));
		bedno 					= checkForNull(rs.getString("bed_no"));
		roomno 					= checkForNull(rs.getString("room_no"));
		bedclassshortdesc 		= checkForNull(rs.getString("bed_class_short_desc"));
		bedtypeshortdesc 		= checkForNull(rs.getString("bed_type_short_desc"));
		gender					= checkForNull(rs.getString("gender"));
		encounterID	 			= checkForNull(rs.getString("encounter_id"));
		practitionerid			= checkForNull(rs.getString("practitioner_id"));
		patient_id				= checkForNull(rs.getString("patient_id"));
		patient_class			= checkForNull(rs.getString("patient_class"));
		meddesc					= checkForNull(rs.getString("team_short_desc"));
		setup_bl_dtls_in_ip_yn	= checkForNull(rs.getString("setup_bl_dtls_in_ip_yn"));
		bl_interfaced_yn		= checkForNull(rs.getString("bl_interfaced_yn"));
		auth_pract_name			= checkForNull(rs.getString("auth_pract_name"));			
		diet_charges_yn			= checkForNull(rs.getString("diet_charges_yn"));
		dis_adv_srl_no			= checkForNull(rs.getString("dis_adv_srl_no"));
		discharge_summary_yn	= checkForNull(rs.getString("discharge_summary_yn"));
		ecg_charges_yn			= checkForNull(rs.getString("ecg_charges_yn"));
		expected_discharge_date = checkForNull(rs.getString("expected_discharge_date"));
		lab_charges_yn			= checkForNull(rs.getString("lab_charges_yn"));
		mri_charges_yn			= checkForNull(rs.getString("mri_charges_yn"));
		ph_charges_yn			= checkForNull(rs.getString("ph_charges_yn"));
		physio_charges_yn		= checkForNull(rs.getString("physio_charges_yn"));
		ref_to_coroner_yn		= checkForNull(rs.getString("ref_to_coroner_yn"));
		rt_charges_yn			= checkForNull(rs.getString("rt_charges_yn"));
		scan_charges_yn			= checkForNull(rs.getString("scan_charges_yn"));
		short_desc				= checkForNull(rs.getString("short_desc"));
		take_home_new_med_yn	= checkForNull(rs.getString("take_home_new_med_yn"));
		take_home_stk_med_yn	= checkForNull(rs.getString("take_home_stk_med_yn"));
		ultrasound_charges_yn	= checkForNull(rs.getString("ultrasound_charges_yn"));
		xray_charges_yn			= checkForNull(rs.getString("xray_charges_yn"));
		/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] Start*/
		WEIGHT_ON_ADMISSION		=checkForNull(rs.getString("WEIGHT_ON_ADMISSION"));
		WEIGHT_ON_ADMISSION_UNIT		=checkForNull(rs.getString("WEIGHT_ON_ADMISSION_UNIT"));
		/*Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123] End*/
		
		/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527*/
		height_on_admission		=checkForNull(rs.getString("HEIGHT_ON_ADMISSION"));
		bmi		=checkForNull(rs.getString("BMI"));
		enable_height_bmi_pat_cls		= checkForNull(request.getParameter("enable_height_bmi_pat_cls"));
		/*Added By Kamatchi S on 23-JUN-2020 for ML-MMOH-CRF-1527 END */
		
		/*Added by Ashwini on 07-Mar-2018 for GHL-CRF-0505*/
		aadhar_card_no		= checkForNull(rs.getString("alt_id4_no"));
		relationship_code	= checkForNull(rs.getString("relationship_code"));
		discharge_indicator = checkForNull(rs.getString("indicator"));
		/*End GHL-CRF-0505*/
 	}
	if(rs !=null) rs.close();
	if(pstmt !=null) pstmt.close();

/* Merged with ip_open_encounter query for PE - 11/05/2010
	if(setup_bl_dtls_in_ip_yn.equals("Y"))
	{
		if (SqlSB.length() > 0)	SqlSB.delete(0, SqlSB.length());
		SqlSB.append(" Select to_char(expected_discharge_date,'dd/mm/rrrr hh24:mi') expected_discharge_date,a.dis_adv_srl_no,b.short_desc,a.ref_to_coroner_yn,");	SqlSB.append("a.discharge_summary_yn,a.take_home_new_med_yn,a.take_home_stk_med_yn,a.lab_charges_yn,a.xray_charges_yn,a.scan_charges_yn,a.ultrasound_charges_yn,");	SqlSB.append("a.mri_charges_yn,a.rt_charges_yn,a.physio_charges_yn,a.ecg_charges_yn,a.diet_charges_yn,a.ph_charges_yn, c.practitioner_name auth_pract_name ");
		SqlSB.append("from IP_DISCHARGE_ADVICE a , IP_DISCHARGE_TYPE_LANG_VW b, AM_PRACTITIONER_LANG_VW c ");
		SqlSB.append("where a.facility_id = '"+facilityID+"' and b.language_id = '"+locale+"' and b.language_id = c.language_id  and encounter_id= '"+encounterID+"' and a.dis_adv_status='0' ");
		SqlSB.append("and a.discharge_type_code = b.discharge_type_code and a.auth_practitioner_id = c.practitioner_id");

		rs = stmt.executeQuery(SqlSB.toString());
		if(rs.next())
		{
			auth_pract_name			= checkForNull(rs.getString("auth_pract_name"));			
			diet_charges_yn			= checkForNull(rs.getString("diet_charges_yn"));
			dis_adv_srl_no			= checkForNull(rs.getString("dis_adv_srl_no"));
			discharge_summary_yn	= checkForNull(rs.getString("discharge_summary_yn"));
			ecg_charges_yn			= checkForNull(rs.getString("ecg_charges_yn"));
			expected_discharge_date = checkForNull(rs.getString("expected_discharge_date"));
			lab_charges_yn			= checkForNull(rs.getString("lab_charges_yn"));
			mri_charges_yn			= checkForNull(rs.getString("mri_charges_yn"));
			ph_charges_yn			= checkForNull(rs.getString("ph_charges_yn"));
			physio_charges_yn		= checkForNull(rs.getString("physio_charges_yn"));
			ref_to_coroner_yn		= checkForNull(rs.getString("ref_to_coroner_yn"));
			rt_charges_yn			= checkForNull(rs.getString("rt_charges_yn"));
			scan_charges_yn			= checkForNull(rs.getString("scan_charges_yn"));
			short_desc				= checkForNull(rs.getString("short_desc"));
			take_home_new_med_yn	= checkForNull(rs.getString("take_home_new_med_yn"));
			take_home_stk_med_yn	= checkForNull(rs.getString("take_home_stk_med_yn"));
			ultrasound_charges_yn	= checkForNull(rs.getString("ultrasound_charges_yn"));
			xray_charges_yn			= checkForNull(rs.getString("xray_charges_yn"));
		}
		if(rs!=null) rs.close();	
	}
	else 
	{
		if (SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());
			SqlSB.append(" Select to_char(expected_discharge_date,'dd/mm/rrrr hh24:mi') expected_discharge_date,");
			SqlSB.append("a.dis_adv_srl_no,b.short_desc,a.ref_to_coroner_yn,");
			SqlSB.append("a.discharge_summary_yn,a.take_home_new_med_yn,");
			SqlSB.append("a.take_home_stk_med_yn, c.practitioner_name auth_pract_name, ");
			SqlSB.append("a.lab_charges_yn, a.xray_charges_yn, a.scan_charges_yn, a.ultrasound_charges_yn, a.mri_charges_yn, a.rt_charges_yn, a.physio_charges_yn, a.ecg_charges_yn, a.diet_charges_yn, a.ph_charges_yn ");
			SqlSB.append(" from IP_DISCHARGE_ADVICE a , IP_DISCHARGE_TYPE_LANG_VW b, AM_PRACTITIONER_LANG_VW c ");
			SqlSB.append("where a.facility_id = '"+facilityID+"' and b.language_id = '"+locale+"' and b.language_id = c.language_id and encounter_id= '"+encounterID+"' and a.dis_adv_status='0' ");
			SqlSB.append("and a.discharge_type_code = b.discharge_type_code and a.auth_practitioner_id = c.practitioner_id");

			rs = stmt.executeQuery(SqlSB.toString());
		 	if(rs.next())
			{
				expected_discharge_date = rs.getString("expected_discharge_date");
				if(expected_discharge_date == null ) expected_discharge_date = "";

				ref_to_coroner_yn  = rs.getString("ref_to_coroner_yn");
				if(ref_to_coroner_yn  == null ) ref_to_coroner_yn = "";

				discharge_summary_yn =   rs.getString("discharge_summary_yn");
				if(discharge_summary_yn == null ) discharge_summary_yn = "";

				take_home_new_med_yn =  rs.getString("take_home_new_med_yn");
				if(take_home_new_med_yn == null ) take_home_new_med_yn = "";

				take_home_stk_med_yn =  rs.getString("take_home_stk_med_yn");
				if(take_home_stk_med_yn == null ) take_home_stk_med_yn = "";
				
				dis_adv_srl_no = rs.getString("dis_adv_srl_no");
				if(dis_adv_srl_no == null) dis_adv_srl_no = "";

				short_desc = rs.getString("short_desc");
				if(short_desc == null ) short_desc = "";

				auth_pract_name = rs.getString("auth_pract_name");
				if(auth_pract_name == null ) auth_pract_name = "";

				lab_charges_yn =  rs.getString("lab_charges_yn");
				if(lab_charges_yn == null ) lab_charges_yn = "";

				xray_charges_yn =  rs.getString("xray_charges_yn");
				if(xray_charges_yn == null ) xray_charges_yn = "";

				scan_charges_yn =  rs.getString("scan_charges_yn");
				if(scan_charges_yn == null ) scan_charges_yn = "";

				ultrasound_charges_yn  = rs.getString("ultrasound_charges_yn");
				if(ultrasound_charges_yn == null ) ultrasound_charges_yn = "";

				mri_charges_yn =  rs.getString("mri_charges_yn");
				if(mri_charges_yn == null ) mri_charges_yn = "";

				rt_charges_yn =  rs.getString("rt_charges_yn");
				if(rt_charges_yn == null ) rt_charges_yn = "";

				physio_charges_yn =  rs.getString("physio_charges_yn");
				if(physio_charges_yn == null ) physio_charges_yn = "";

				ecg_charges_yn =  rs.getString("ecg_charges_yn");
				if(ecg_charges_yn == null ) ecg_charges_yn = "N";

				diet_charges_yn =  rs.getString("diet_charges_yn");
				if(diet_charges_yn == null ) diet_charges_yn = "";

				ph_charges_yn =  rs.getString("ph_charges_yn");
				if(ph_charges_yn == null ) ph_charges_yn = "";
			}
			if(rs!=null) rs.close();	
		}
*/

/* Merged with ip_open_encounter query for PE - 11/05/2010	

	if (SqlSB.length() > 0)	SqlSB.delete(0, SqlSB.length());
	SqlSB.append(" Select AM_GET_DESC.AM_MEDICAL_TEAM(facility_id,team_id, '"+locale+"','2') team_short_desc from AM_PRACT_FOR_TEAM ");
	SqlSB.append(" where facility_id = '"+facilityID+"' and (FACILITY_ID, TEAM_ID) in (select facility_id, to_pract_team_id from IP_ADT_TRN ");
	SqlSB.append(" where facility_id = '"+facilityID+"' and to_practitioner_id='"+practitionerid+"' and ");
	SqlSB.append(" trn_type='A' and encounter_id='"+encounterID+"' ) ");
	if(rs !=null) rs.close();
	stmt1 = con.createStatement();
	rs = stmt1.executeQuery(SqlSB.toString());
	if(rs!= null)
	{
		while(rs.next())
		{				
			meddesc = rs.getString("team_short_desc");										
		}			
	}	
	if(rs !=null) rs.close();
*/

weight_on_admission_unit_display=(WEIGHT_ON_ADMISSION_UNIT.equals("K"))?"Kg":(WEIGHT_ON_ADMISSION_UNIT.equals("G"))?"Gram":"";//Added by Rameswar on 22nd May 2015 Against HSA-CRF-0181.1 [IN054123]
height_on_admission_unit=(height_on_admission.equals(""))?"":"Cm";//Added by Kamatchi S for ML-MMOH-CRF-1527 on 23-jun-2020	

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(adm_date_display));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(admissiondatetime));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(admissiontypedesc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(admissiontypedesc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patienttype));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(specialtyshortdesc));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practitionername));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(meddesc));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(WEIGHT_ON_ADMISSION));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(weight_on_admission_unit_display));
            _bw.write(_wl_block28Bytes, _wl_block28);
if(isHeightAndBmiEnable ){
  		if(enable_height_bmi_pat_cls.equals(patient_class)|| enable_height_bmi_pat_cls.equals("ID")){
  	  
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(height_on_admission));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(height_on_admission_unit));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bmi));
            _bw.write(_wl_block33Bytes, _wl_block33);
}}else{
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(nursingunitshortdesc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(nursingunitshortdesc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(nursingunitcode));
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(serviceshortdesc));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bedno));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bedno));
            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(roomno));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(roomno));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bedclassshortdesc));
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bedtypeshortdesc));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

	String expected_discharge_date_display = "";
	if(expected_discharge_date == "" || expected_discharge_date.equals("null"))
		expected_discharge_date_display = "&nbsp;";
	else
		expected_discharge_date_display = DateUtils.convertDate(expected_discharge_date,"DMYHM","en",locale);

            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(expected_discharge_date_display));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(expected_discharge_date));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(auth_pract_name));
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
if(ref_to_coroner_yn.equals("Y")){ 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(ref_to_coroner_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
 }else{
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ref_to_coroner_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(discharge_summary_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block62Bytes, _wl_block62);
 if(isDeathRegisterFormAppl && enable_death_reg_form.equals("Y") && discharge_indicator.equals("DS") && !death_reg_form_accession_num.equals("")){ 
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(encounterID));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(admissiondatetime ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(patient_class ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(nursingunitcode ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(death_reg_form_accession_num ));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
} 
            _bw.write(_wl_block68Bytes, _wl_block68);
if(isAadharCardAndRelAppl && (!("").equals(alt_id4_type))){
	 AadharCardAndRelJson	=	eIP.IPCommonBean.getAadharCardAndRel(con, patient_id);
	 citizen_yn				=	(String)AadharCardAndRelJson.get("citizen_yn");

	 if(citizen_yn.equals("Y") && discharge_indicator.equals("DS")){

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(alt_id4_type_desc));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(aadhar_card_no));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
if(relationship_code.equals("1")){
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
}else if(relationship_code.equals("2")){
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
}else if(relationship_code.equals("3")){
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
}
            _bw.write(_wl_block74Bytes, _wl_block74);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
}
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
 if( take_home_new_med_yn.equals("Y")){ 
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(take_home_new_med_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
} else { 
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(take_home_new_med_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
 if( take_home_stk_med_yn.equals("Y")) {
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(take_home_stk_med_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
} else {
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(take_home_stk_med_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
}
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
 if( lab_charges_yn.equals("Y")){ 
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(lab_charges_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
 } else {
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(lab_charges_yn));
            _bw.write(_wl_block90Bytes, _wl_block90);
}
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
 if( xray_charges_yn.equals("Y")) {
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(xray_charges_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
 } else {
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(xray_charges_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
 if( scan_charges_yn.equals("Y")) {
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(scan_charges_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);
 } else {
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(scan_charges_yn));
            _bw.write(_wl_block90Bytes, _wl_block90);
}
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
 if( ultrasound_charges_yn.equals("Y")) {
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(ultrasound_charges_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);
 } else {
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(ultrasound_charges_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
 if( mri_charges_yn.equals("Y")) {
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(mri_charges_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
 } else {
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(mri_charges_yn));
            _bw.write(_wl_block90Bytes, _wl_block90);
}
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
 if( rt_charges_yn.equals("Y")) { 
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(rt_charges_yn));
            _bw.write(_wl_block107Bytes, _wl_block107);
 } else {
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(rt_charges_yn));
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
 if( physio_charges_yn.equals("Y")) {
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(physio_charges_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
 } else {
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(physio_charges_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
}
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
 
		  if( ecg_charges_yn.equals("Y")) {
		  
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(ecg_charges_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
 } else {
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(ecg_charges_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
 }
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
 if( diet_charges_yn.equals("Y")){ 
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(diet_charges_yn));
            _bw.write(_wl_block107Bytes, _wl_block107);
 } else {
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(diet_charges_yn));
            _bw.write(_wl_block113Bytes, _wl_block113);
}
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
 if( ph_charges_yn.equals("Y")){ 
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(ph_charges_yn));
            _bw.write(_wl_block121Bytes, _wl_block121);
 } else {
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(ph_charges_yn));
            _bw.write(_wl_block123Bytes, _wl_block123);
}
            _bw.write(_wl_block124Bytes, _wl_block124);
if(!fromfunction.equals("PD")){
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelDischargeAdvice.label","common_labels")));
            _bw.write(_wl_block126Bytes, _wl_block126);
}
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(dis_adv_srl_no));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(death_reg_form_accession_num));
            _bw.write(_wl_block135Bytes, _wl_block135);

	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
	if (stmt1 != null) stmt1.close();
	if (pstmt != null) pstmt.close();
	
}catch(Exception e) 
{
/* 	out.println(e.toString()); */
e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block136Bytes, _wl_block136);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DischargeAdvice.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AdmissionDateTime.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.WeightOnAdmission.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.HeightOnAdmission.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BMI.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NursingUnitDetails.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeDetails.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpectedDischargeDateTime.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargetype.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AuthorizedPractitioner.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PostMortemRequested.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DeathRegForm.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.relationship.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.self.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Attendant.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Spouse.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TakeHomeMedicine.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.NewMedicine.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.StockMedicine.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ChargesIncurredonDischargeDay.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Lab.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Xray.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Scan.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Ultrasound.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MRI.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.RT.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Physio.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ecg.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Diet.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.pharmacy.label", java.lang.String .class,"key"));
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
}
