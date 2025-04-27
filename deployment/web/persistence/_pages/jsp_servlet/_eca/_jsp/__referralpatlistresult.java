package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import eCA.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __referralpatlistresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ReferralPatListResult.jsp", 1742466712835L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\n\t<script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    <script src=\'../js/ReferralPatListResult.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCA/js/CACommon.js\'></script><!-- 32902 -->\n    <head>\n    </head>\n    <body class=\'CONTENT\' onscroll=\'moveFrame()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t<form name=\'PatCriteriaFrm\' id=\'PatCriteriaFrm\' action=\'../../eCA/jsp/OpenChartWrapper.jsp\' method = \'post\' target=\'messageFrame\' >\n\t<table cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t<td class=\'white\' width=\'90%\'></td> \n\t\t<td nowrap  width=\'5%\' align=\'right\' id=\'previous\' ></td>\n\t\t<td nowrap  width=\'5%\' align=\'right\' id=\'next\' ></td>\n\t\t</tr>\n\t</table>\n\t<table id=\'PatCriteriaTbl\'  width=\'100%\' class=\'grid\' scrolling=\"auto\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\'previous\').innerHTML = \"<a href=`javascript:onClick=navigate(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\',\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\')`title=\'Previous\'  value=\' Previous  \' class=\'gridLink\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</a>\";\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.getElementById(\'next\').innerHTML = \"<a href=`javascript:onClick=navigate(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')`title=\'Next\' value=\' next  \' class=\'gridLink\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\'previous\').innerHTML=\"\";\n\t\t\t</script>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<tr>\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th nowrap><a id=\'a01\'   href=\"javascript:callForOrderByLoc(\'PC\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a02\'   href=\"javascript:callForOrderByLoc(\'LOC\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a03\'   href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a04\'   href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a05\'   href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a06\'   href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a07\'   href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a08\'  href=\"javascript:callForOrderByLoc(\'RS\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a09\'   href=\"javascript:callForOrderByLoc(\'AD\');\" onclick=\'changeColor(this);\' style=\'color:pink\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a10\' href=\"javascript:callForOrderByLoc(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a11\'   href=\"javascript:callForOrderByLoc(\'RN\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a12\'   href=\"javascript:callForOrderByLoc(\'BN\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a13\'   href=\"javascript:callForOrderByLoc(\'AP\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</a></th>\n\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</th>\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<input type=\"hidden\" name=\"patient_id";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"patient_id";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t<input type=\"hidden\" name=\"referral_id";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" id=\"referral_id";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t<input type=\"hidden\" name=\"location_code";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" id=\"location_code";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t\t<input type=\"hidden\" name=\"practitioner_Id";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"practitioner_Id";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n\t\t\t\t<input type=\"hidden\" name=\"sex";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"sex";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t\t<input type=\"hidden\" name=\"unAssigned_yn";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" id=\"unAssigned_yn";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t\t<input type=\"hidden\"  id=\"restPatientYN";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" name=\"restPatientYN";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'><!-- 32902 -->\n\t\t\t     <input type=\"hidden\" id=\"accessRightsViewPatient\" name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'><!-- 32902 -->\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t<tr>\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th nowrap><a id=\'a01\'   href=\"javascript:callForOrderByLoc(\'LOC\');\" onclick=\'changeColor(this);\' style=\'color:white\' >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a02\'   href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a03\'   href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a04\'   href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a05\'   href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a06\'   href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a07\'  href=\"javascript:callForOrderByLoc(\'SAP\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a08\'   href=\"javascript:callForOrderByLoc(\'AD\');\" onclick=\'changeColor(this);\' style=\'color:pink\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a09\' href=\"javascript:callForOrderByLoc(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a10\'   href=\"javascript:callForOrderByLoc(\'RN\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a11\'   href=\"javascript:callForOrderByLoc(\'BN\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a12\'   href=\"javascript:callForOrderByLoc(\'AP\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t<tr>\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th nowrap><a id=\'a01\'   href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a02\'   href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a03\'   href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a04\'   href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a05\'   href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a06\'  href=\"javascript:callForOrderByLoc(\'SAP\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a07\'   href=\"javascript:callForOrderByLoc(\'AD\');\" onclick=\'changeColor(this);\' style=\'color:pink\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a08\' href=\"javascript:callForOrderByLoc(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a09\'   href=\"javascript:callForOrderByLoc(\'RN\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a10\'   href=\"javascript:callForOrderByLoc(\'BN\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</a></th>\n\t\t\t\t<th nowrap><a id=\'a11\'   href=\"javascript:callForOrderByLoc(\'AP\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"unAssigned_yn\" id=\"unAssigned_yn\" value=\"\">\n\t\t<input type=\"hidden\" name=\"referral_id\" id=\"referral_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t<input type=\"hidden\" name=\"locationType\" id=\"locationType\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t<input type=\"hidden\" name=\"locationCode\" id=\"locationCode\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t<!-- <input type=\"hidden\" name=\"fromDate\" id=\"fromDate\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">//IN28273\n\t\t<input type=\"hidden\" name=\"toDate\" id=\"toDate\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"> -->\n\t\t<input type=\"hidden\" name=\"groupByLocn\" id=\"groupByLocn\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t<input type=\"hidden\" name=\"groupByEpisode\" id=\"groupByEpisode\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t<input type=\"hidden\" name=\"unAssigned\" id=\"unAssigned\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t<input type=\"hidden\" name=\"pendingRef\" id=\"pendingRef\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t<!--IN064836 start-->\n\t\t<!--<input type=\"hidden\" name=\"closed\" id=\"closed\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t<input type=\"hidden\" name=\"open\" id=\"open\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">-->\n\t\t<input type=\"hidden\" name=\"refStatus\" id=\"refStatus\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t<input type=\"hidden\" name=\"refRegSiteYN\" id=\"refRegSiteYN\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t<!--IN064836 ends-->\n\t\t<input type=\"hidden\" name=\"reln_req_yn\" id=\"reln_req_yn\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"navigate\">\n\t\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"\">\n\t\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"\">\n\t\t<input type=\"hidden\" name=\"form\" id=\"form\" value=\"ReferralList\">\n\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t\t<input type=\"hidden\" name=\"loc_code\" id=\"loc_code\" value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n\t\t<input type=\"hidden\" name=\"locn_type\" id=\"locn_type\" value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n\t\t</form>\n\t\t<div id=\'motherLink\' style=\'position:absolute; visibility:hidden;overflow:overflow\'></div>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'!=\'\')\n\t\t\t{\n\t\t\t\tdocument.body.scrollLeft=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\';\n\t\t\t}\n\t\t\tif(\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'!=\'\')\n\t\t\t{\n\t\t\t\tfor(i=0;i<document.anchors.length;i++)\n\t\t\t\t{\n\t\t\t\t\tdocument.anchors(i).style.color=\'white\';\n\n\t\t\t\t}\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'==\'1\')\n\t\t\t\t\tdocument.getElementById(";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =").style.color=\'pink\';\n\t\t\t\telse if(\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'==\'2\')\n\t\t\t\t\tdocument.getElementById(";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =").style.color=\'yellow\';\n\t\t\t}\n\t\t</script>\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\n\t\n    \n\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );
	
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

/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name        Rev.Date Rev.by Description
--------------------------------------------------------------------------------------------------------------
?				100					?           					created
30/01/2012		IN030566			Ramesh G						When we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.								  
08/11/2011		IN28273				Dinesh T	 					Added the change event to that control
18/04/2012		IN030318			Ramesh G						This age of the newborn is displayed in the newborn list in location list as well as in the patient banner in patient?s chart.
24/04/2012		IN032435,IN032437		Ramesh G					The age of new born is displayed as Null.
12/09/2012		IN034999			vijayakumark					Encounter details and Confirm hyperlink not displayed for Enterprise Referral Type
21/01/2014		IN044931			Chowminya  	21/01 		Akbar	Referral Status Still remains as Pending Referral even though the referral is closed
13/03/2014		IN044157			Chowminya		 				[AAKH CRF 0010.1]Five level Triage system AE requirement 	
02/04/2014		IN047927			Chowminya						Referral List - Transactions Failed, while confirm Bed Side Referral 
10/02/2015		IN048463			Karthi L						Bed Side Referral Status
06/04/2015		IN052595			Karthi L						Referral Patient List
04/02/2016		IN057201		    Karthi L						View Forwarded Referral Letter Under Consults
----------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
09/08/2016		IN064836		Krishna Gowtham		09/08/2017		Ramesh G	ML-MMOH-CRF-0566.1
24/10/2017		IN065452		Krishna Gowtham		25/10/2017		Ramesh G	ML-MMOH-CRF-0566.2
11/06/2018      IN067543        Ramya Maddena       11/06/2018      Ramesh G    ML-MMOH-CRF-1168
 6/11/2023     32902             Krishna Pranay    	     7/11/2023      Ramesh G      MMS-DM-CRF-0210	

-------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block4Bytes, _wl_block4);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String facility_id=(String)session.getValue("facility_id");
	if(facility_id == null) facility_id="";

	String clinicianId =(String)session.getValue("ca_practitioner_id");
	//out.println("<script>alert('"+request.getQueryString()+"');</script>");

	String locationType		=	request.getParameter("locationType") == null ? "" : request.getParameter("locationType");
	//out.println("locationType"+locationType);
	
	String locationCode		=	request.getParameter("locationCode") == null ? "" : request.getParameter("locationCode");

	String fromDate			=	request.getParameter("fromDate") == null ? "" : request.getParameter("fromDate");
	String toDate			=	request.getParameter("toDate") == null ? "" : request.getParameter("toDate"); 
    String patientId		=	request.getParameter("patientId") == null ? "" : request.getParameter("patientId");
   // String groupByEpisode	=	request.getParameter("groupByEpisode") == null ? "" : request.getParameter("groupByEpisode");
	String groupByEpisode="N"; // 
   // String groupByLocn		=	request.getParameter("groupByLocn") == null ? "" : request.getParameter("groupByLocn");
    String groupByLocn	="N";
	String unAssigned		=	request.getParameter("unAssigned") == null ? "" : request.getParameter("unAssigned");
	String pendingRef		=	request.getParameter("pendingRef") == null ? "" : request.getParameter("pendingRef");
	String closed			=	request.getParameter("closed") == null ? "" : request.getParameter("closed");
	String open				=	request.getParameter("open") == null ? "" : request.getParameter("open");
	String refStatus		= 	request.getParameter("refStatus") == null ? "" : request.getParameter("refStatus");//IN064836

	String from				=	request.getParameter("from") ;
	String to				=	request.getParameter("to") ;
	String orderBy			=	request.getParameter("orderBy") == null ? "" : request.getParameter("orderBy");
	String reOrder			=	request.getParameter("reOrder") == null ? "" : request.getParameter("reOrder");
	String anchorID			=	request.getParameter("anchorID") == null ? "" : request.getParameter("anchorID");
	String leftScrolling	=	request.getParameter("leftScrolling") == null ? "" : request.getParameter("leftScrolling");

	//String mode				=	request.getParameter("mode") == null ? "" : request.getParameter("mode");

	String loc_code			=	request.getParameter("loc_code") == null ? "" : request.getParameter("loc_code");//from bean
	String locn_type			=	request.getParameter("locn_type") == null ? "" : request.getParameter("locn_type");//from bean
	
	String bedside_ref_review_status 	= "";  // added for IN048463
	String bedside_referral_YN			= "";  //  added for IN064836
	//Date Conversion added by Archana Dhal related to IN18772
	if(!locale.equals("en"))//IN28273
	{
	fromDate = com.ehis.util.DateUtils.convertDate(fromDate,"DMY",locale,"en");
	toDate = com.ehis.util.DateUtils.convertDate(toDate,"DMY",locale,"en");
	}
	  
	String prev = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String next = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");

	String relnreqyn = request.getParameter("reln_req_yn")==null?"Y":request.getParameter("reln_req_yn");

	String visitStyle = "";
	if(reOrder.equals("1"))
	{
		visitStyle = "color:pink" ;
	}
	else
	{
		visitStyle = "color:yellow" ;
	} 

	int maxNoRecords = 0;

	String qry_mo_install_yn = "select install_yn from sm_module where module_id='MO'";

	Connection con = null;

	PreparedStatement pstmt = null;
	PreparedStatement stmtMotherLink = null;

	ResultSet rs = null;
	ResultSet rsMotherLink = null;

	StringBuffer sql = new StringBuffer();
	StringBuffer layer = new StringBuffer();
	String mo_install_yn = "";
	String sqlMotherLink = "";
	String episode_type_desc = "";
	String sex = "";
	String patient_status = "";
	String decesedColor = "";
	String apgar_score = "	";
	String title = "";
	String dateofbirth1 = "";
	String enctr_id = "";
	String ca_record_referral_note_yn = "Y"; //ML-MMOH-CRF-0362 [IN057201]
	boolean isScroll	= true;

	Boolean isRefPatientListAppl = false; //IN067543
	if(groupByEpisode.equals("Y") && groupByLocn.equals("Y"))
	{

		isScroll = false;
	}

	boolean flag = true;

	try
	{
		// IN048463 Start.
		String bean_id = "CA_ca_patListbylocationresult" ;
		String bean_name = "eCA.PatListByLocationResult";
		PatListByLocationResult bean = (PatListByLocationResult)getObjectFromBean( bean_id, bean_name, session ) ;
		String allow_muti_bedside_review_yn  = bean.getMultiBedSideReviewYN(facility_id); 
		// IN048463 End.
		//32902 start
		String restPatientYN="";
	 String ca_bean_id 						= "@CACommonGetPatientDtlBean";
	 String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
	 CACommonGetPatientDtlBean bean1	= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
	 int accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	
	 //32902 end
		ca_record_referral_note_yn = bean.getReferralNoteFromPASYN(facility_id); //  ML-MMOH-CRF-0362 [IN057201]
		con = ConnectionManager.getConnection(request);
		//IN064836 start
		String refRegSiteYN = "";
		//IN067543 Start.
		ArrayList<String> functionIds = new ArrayList<String>();
		functionIds.add("REF_PAT_LST_WITHIN_PRACT_SPLTY");
		bean.setSiteSpecific(functionIds,"CA");
		isRefPatientListAppl = bean.isSiteSpecific("REF_PAT_LST_WITHIN_PRACT_SPLTY");
		//IN067543 End.
		Boolean referralRegister = CommonBean.isSiteSpecific(con, "IP", "RECNL_REFERRAL_REGISTER");
		if(referralRegister)
		{
			refRegSiteYN = "Y";
		}
		else
		{
			refRegSiteYN = "N";
		}
		//IN064836 ends
	//IN044157 - Start
	String AEZone5 = "N";
	PreparedStatement stmtAE = con.prepareStatement("Select FIVE_LEVEL_TRIAGE_APPL_YN from AE_PARAM where OPERATING_FACILITY_ID=?");
	ResultSet rsAE = null;
	stmtAE.setString(1,facility_id);
	rsAE = stmtAE.executeQuery();
	while(rsAE.next()){
		AEZone5 = rsAE.getString("FIVE_LEVEL_TRIAGE_APPL_YN");
	}
	if(stmtAE!=null)stmtAE.close();
	if(rsAE!=null)rsAE.close();
	//IN044157 - End
		stmtMotherLink = con.prepareStatement(qry_mo_install_yn);
		rs = stmtMotherLink.executeQuery();

		if(rs.next())
			mo_install_yn = (rs.getString("install_yn") == null ? "" : rs.getString("install_yn"));

		if(rs != null) rs.close();
		if(stmtMotherLink != null) stmtMotherLink.close();

		sqlMotherLink = "select a.patient_id pat_id, replace(decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)) ,'''','')  short_name, to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH, a.WEIGHT, a.WEIGHT_UNIT, a.LENGTH ||' cms'  LENGTH_OF_BABY,a.CIRCUMFERENCE ||' cms'  CIRCUMFERENCE_OF_HEAD,a.APGAR_SCORE, b.sex from mp_birth_register a,mp_patient b where  b.patient_id=a.patient_id and a.mother_patient_id= ? and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by TIME_OF_BIRTH  ";

		stmtMotherLink = con.prepareStatement(sqlMotherLink);

		int k=0;
		int i=0;
		String rowclass = "gridData";

		//[IN030318] sql.append("SELECT B.PATIENT_NAME, A.referral_id, GET_AGE(B.DATE_OF_BIRTH) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) ");

		// [IN032435] sql.append("SELECT B.PATIENT_NAME, A.referral_id, MP_GET_AGE_YMDH(b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) ");

		// [IN032437] sql.append("SELECT B.PATIENT_NAME, A.referral_id, nvl(MP_GET_AGE_YMDH(b.date_of_birth,b.DECEASED_DATE),GET_AGE(B.DATE_OF_BIRTH)) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) ");
		
		//sql.append("SELECT B.PATIENT_NAME, A.referral_id, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else BEDSIDE_REFERRAL_YN end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) ");
		
		/* IN034999 starts */
		//sql.append("SELECT B.PATIENT_NAME, A.referral_id, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,A.FACILITY_ID FACILITY_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else 'Y' end)   confirm_yn FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) ");
		/* IN034999 ends */
		//sql.append("SELECT B.PATIENT_NAME, A.referral_id, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when a.status ='C' THEN 'C' when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,A.FACILITY_ID FACILITY_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color,A.BEDSIDE_REFERRAL_YN  FROM (SELECT REFERRAL_ID, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else 'Y' end)   confirm_yn,BEDSIDE_REFERRAL_YN FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) "); //IN044931//IN047927 added BEDSIDE_REFERRAL_YN col - Commented for IN048463
		//sql.append("SELECT B.PATIENT_NAME, A.referral_id,  A.BEDSIDE_REF_REVIEW_STATUS, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when a.status ='C' THEN 'C' when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,A.FACILITY_ID FACILITY_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color,A.BEDSIDE_REFERRAL_YN  FROM (SELECT REFERRAL_ID, BEDSIDE_REF_REVIEW_STATUS, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else 'Y' end)   confirm_yn,BEDSIDE_REFERRAL_YN FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) "); // Modified for IN048463 // commented  for ML-MMOH-CRF-0362 [IN057201]
		//sql.append("SELECT B.PATIENT_NAME, A.referral_id,  A.BEDSIDE_REF_REVIEW_STATUS, CA_REF_LETTER_NOTES_REC_YN, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when a.status ='C' THEN 'C' when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,A.FACILITY_ID FACILITY_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color,A.BEDSIDE_REFERRAL_YN  FROM (SELECT REFERRAL_ID, BEDSIDE_REF_REVIEW_STATUS, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else 'Y' end)   confirm_yn,BEDSIDE_REFERRAL_YN, CA_REF_LETTER_NOTES_REC_YN FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) "); // Modified for ML-MMOH-CRF-0362 [IN057201]//32902
		sql.append("SELECT B.PATIENT_NAME, A.referral_id,  A.BEDSIDE_REF_REVIEW_STATUS, CA_REF_LETTER_NOTES_REC_YN, CA_GET_AGE_IN_HRS (b.date_of_birth,b.DECEASED_DATE) AGE, decode(B.SEX, 'M','Male','F','Female','U','Unknown','') sex, A.PATIENT_ID, case when a.status ='C' THEN 'C' when open_chart_yn='N' then 'P' when A.unAssigned_yn='N' THEN 'U' ELSE A.STATUS END  STATUS, A.unAssigned_yn, B.DATE_OF_BIRTH actual_dob, C.PATIENT_CLASS, C.ENCOUNTER_ID EPISODE_ID,A.FACILITY_ID FACILITY_ID, CA_GET_PATIENT_CURR_STATUS(C.FACILITY_ID,C.PATIENT_ID,C.ENCOUNTER_ID,C.PATIENT_CLASS,?)  patient_status, C.PRIORITY_ZONE,  C.ASSIGN_CARE_LOCN_CODE, case when C.patient_class in ('IP','DC') then ip_get_desc.ip_nursing_unit(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') else op_get_desc.op_clinic(C.FACILITY_ID, C.ASSIGN_CARE_LOCN_CODE,?,'2') end  LOCATION_DETAILS, to_char(C.VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date, to_char(C.DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') DISCHARGE_DATE_TIME, to_char(SYSDATE,'hh24:mi:ss') QRYTIME, C.ASSIGN_BED_NUM  BED_NO, C.ASSIGN_ROOM_NUM  ROOM_NO, C.ATTEND_PRACTITIONER_ID, NVL (am_get_desc.am_practitioner (C.ATTEND_PRACTITIONER_ID, ?, '2'), '') attend_pract_name, A.confirm_yn, A.open_chart_yn,ca_ae_get_priority_zone_color(C.PRIORITY_ZONE,'en') ae_zone_color,A.BEDSIDE_REFERRAL_YN, b.restrict_reinstate_yn  FROM (SELECT REFERRAL_ID, BEDSIDE_REF_REVIEW_STATUS, FROM_FACILITY_ID FACILITY_ID, patient_id, NVL(CLOSE_ENCOUNTER_ID,FROM_ENCOUNTER_ID) ENCOUNTER_ID, STATUS, nvl2(TO_PRACT_ID,'Y','N') unAssigned_yn, (Case when BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID is not null  then 'Y' else 'N' end ) open_chart_yn, (Case when STATUS='C' then 'N' else 'Y' end)   confirm_yn,BEDSIDE_REFERRAL_YN, CA_REF_LETTER_NOTES_REC_YN FROM PR_REFERRAL_REGISTER WHERE TO_FACILITY_ID = ? AND REFERRAL_DATE BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?,'dd/mm/yyyy')+.9999 AND PATIENT_ID = NVL('',PATIENT_ID) "); //32902
				//IN065452 start
		if("R".equals(pendingRef) && "Self".equals(unAssigned))
		{
			sql.append(" AND FROM_PRACT_ID = ?  ");
		}
		//if(unAssigned.equals("Self")){
		else if(unAssigned.equals("Self")){
		//IN065452 ends
			sql.append(" AND TO_PRACT_ID = ?  ");										
		}
		else if(unAssigned.equals("Unassigned"))
		{		
			// IN067543 Start.
			if(isRefPatientListAppl)
			{				
                sql.append(" and (TO_PRACT_ID != ? or TO_PRACT_ID IS NULL) AND TO_SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID = ?)");
			}else
			{
			// IN067543 End.
			    sql.append(" and TO_PRACT_ID is null and TO_SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID = ? union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID = ? AND PRACTITIONER_ID = ?)");
			}
		}
		else
		{	
			// IN067543 Start.
			if(isRefPatientListAppl)
			{ 				
				sql.append("AND (TO_PRACT_ID = ? or TO_SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID = ?))" );	
	        
			}else
			{
			// IN067543	End.
              sql.append(" AND (TO_PRACT_ID = ? or (TO_PRACT_ID is null and TO_SPECIALITY_CODE IN (SELECT PRIMARY_SPECIALITY_CODE  from am_practitioner where PRACTITIONER_ID = ? union all SELECT SPECIALITY_CODE FROM AM_PRACT_SPECIALITIES WHERE FACILITY_ID = ? AND PRACTITIONER_ID = ? )) ) " );
			}
		}	
		//IN064836 start
		/*if(closed.equals("N") && open.equals("N"))
			sql.append(" AND 1=2 ");
		else if(closed.equals("Y") && open.equals("Y"))
			sql.append(" AND STATUS IN ('C','O') ");
		else if(closed.equals("Y"))
			sql.append(" AND STATUS IN ('C') ");
		else if(open.equals("Y"))
			sql.append(" AND STATUS IN ('O') ");*/
		if(referralRegister)
		{
			if("O".equals(refStatus))
				sql.append(" AND STATUS = 'O'");
			else if("C".equals(refStatus))
				sql.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'C' ");
			else if("N".equals(refStatus))
				sql.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'N' ");
			/*else if("P".equals(refStatus))
				sql.append(" AND BEDSIDE_REF_REVIEW_STATUS = 'P' ");*/
			else if("S".equals(refStatus))
				sql.append(" AND STATUS = 'C' AND BEDSIDE_REF_REVIEW_STATUS = 'S' ");
			else if("X".equals(refStatus))
				sql.append(" AND STATUS = 'X' AND BEDSIDE_REF_REVIEW_STATUS = 'X' ");
		}
		else
		{
			if("O".equals(refStatus))
				sql.append(" AND STATUS IN ('O') ");
			else if("Z".equals(refStatus))
				sql.append(" AND STATUS IN ('C') ");
			else if("A".equals(refStatus))
				sql.append(" AND STATUS IN ('C','O') ");
		}
		//IN064836 ends

		if(pendingRef.equals("N"))
			sql.append(" AND ( BEDSIDE_REFERRAL_YN = 'Y' OR CLOSE_ENCOUNTER_ID IS NOT NULL ) ");

		sql.append(" ) A , MP_PATIENT B , PR_ENCOUNTER C WHERE B.PATIENT_ID = A.PATIENT_ID AND C.FACILITY_ID(+) = A.FACILITY_ID AND C.ENCOUNTER_ID(+) = A.ENCOUNTER_ID /*and (NVL (c.adt_status, '01') IN ('07', '08') or nvl(c.visit_status,'01') between '01' and '08'*/ ");

		if(locationType.equals("IP") || locationType.equals("OP") || locationType.equals("DC") || locationType.equals("EM") || groupByEpisode.equals("Y"))
		{
			sql.append(" AND C.PATIENT_CLASS = ? ");
		}

		if((!locationCode.equals("*ALL") && !locationCode.equals("")) || groupByLocn.equals("Y"))
			sql.append(" AND C.ASSIGN_CARE_LOCN_CODE(+)  = ? ");

		if(!patientId.equals(""))
			sql.append(" AND A.PATIENT_ID  = ? ");
		
		sql.append("AND 'N'=CA_GET_RESTRICTED_PATIENTS_YN(?,c.patient_id,c.facility_id) ");//32902

		
		String desc="";
		if(reOrder.equals("2"))
		{
			desc=" desc";

		}
		if(orderBy.equals("PC"))
		{
			sql.append(" Order By PATIENT_CLASS ");
			sql.append(desc);
		}
		else if(orderBy.equals("LOC"))
		{
			sql.append(" order By LOCATION_DETAILS ");
			sql.append(desc);
		}
		else if(orderBy.equals("PN"))
		{
			sql.append(" order By PATIENT_NAME ");
			sql.append(desc);
		}
		else if(orderBy.equals("AGE"))
		{
			if(reOrder.equals("1"))
			{
				sql.append(" order By actual_dob desc ");
			}
			else
			{
				sql.append(" order By actual_dob ");
			}
		}
		else if(orderBy.equals("SEX"))
		{
			sql.append(" order By sex ");
			sql.append(desc);
		}
		else if(orderBy.equals("PID"))
		{
			sql.append(" order By PATIENT_ID ");
			sql.append(desc);
		}
		else if(orderBy.equals("AD"))
		{
			sql.append(" order By VISIT_ADM_DATE_TIME ");
			sql.append(desc);
		}
		else if(orderBy.equals("RS"))
		{
			sql.append(" order By STATUS ");
			sql.append(desc);
		}
		else if(orderBy.equals("BN"))
		{
			sql.append(" order By BED_NO ");
			sql.append(desc);
		}
		else if(orderBy.equals("RID"))
		{
			sql.append(" order By referral_id ");
			sql.append(desc);
		}
		else if(orderBy.equals("AP"))
		{
			sql.append(" order By attend_pract_name ");
			sql.append(desc);
		}
		else if(orderBy.equals("DD"))
		{
			sql.append(" order By C.DISCHARGE_DATE_TIME");
			sql.append(desc);
		}
		else if(orderBy.equals("RN"))
		{
			sql.append(" order By ROOM_NO");
			sql.append(desc);
		}
		
		
		pstmt = con.prepareStatement(sql.toString());

		int count = 0;
		/*out.println("clinicianId"+clinicianId+"<BR>");
		out.println("locale"+locale+"<BR>");
		out.println("facility_id"+facility_id+"<BR>");
		out.println("clinicianId"+clinicianId+"<BR>");
		out.println("fromDate"+fromDate+"<BR>");
		out.println("toDate"+toDate+"<BR>");
		out.println("locationType"+locationType+"<BR>");
		out.println("locn_type"+locn_type+"<BR>");
		out.println("locationCode"+locationCode+"<BR>");
		out.println("loc_code"+loc_code+"<BR>");
		out.println("patientId"+patientId+"<BR>");*/


		pstmt.setString(++count,clinicianId);
		pstmt.setString(++count,locale);
		pstmt.setString(++count,locale);
		pstmt.setString(++count,locale);
		pstmt.setString(++count,facility_id);
		pstmt.setString(++count,fromDate);
		pstmt.setString(++count,toDate);

		if(unAssigned.equals("Self"))
			pstmt.setString(++count,clinicianId);
		else if(unAssigned.equals("Unassigned"))
		{
			// IN067543
			if(isRefPatientListAppl){
				pstmt.setString(++count,clinicianId);
				pstmt.setString(++count,clinicianId);
			}else{
				pstmt.setString(++count,clinicianId);
				pstmt.setString(++count,facility_id);
				pstmt.setString(++count,clinicianId);
			}
		}
		else
		{
			// IN067543
			if(isRefPatientListAppl){
				pstmt.setString(++count,clinicianId);
				pstmt.setString(++count,clinicianId);
			}else{
				pstmt.setString(++count,clinicianId);
				pstmt.setString(++count,clinicianId);
				pstmt.setString(++count,facility_id);
				pstmt.setString(++count,clinicianId);
			}
		}

		if(locationType.equals("IP") || locationType.equals("OP") || locationType.equals("DC") || locationType.equals("EM"))
			pstmt.setString(++count,locationType);
		else if(groupByEpisode.equals("Y"))
			pstmt.setString(++count,locn_type);
		
		if(!locationCode.equals("*ALL") && !locationCode.equals(""))
			pstmt.setString(++count,locationCode);
		else if(groupByLocn.equals("Y"))
			pstmt.setString(++count,loc_code); 

		if(!patientId.equals(""))
			pstmt.setString(++count,patientId);
			
		pstmt.setString(++count,clinicianId);//32902

		if(groupByEpisode.equals("N") || groupByLocn.equals("N"))
		{
			
			rs = pstmt.executeQuery();
			while(rs.next())
				maxNoRecords += 1;
		}
		if(rs!=null)rs.close();


/*		out.println("<BR>");
		out.println("locationType ="+locationType+"=<BR>");
		out.println("loc_code ="+loc_code+"=<BR>");
		out.println("clinicianId ="+clinicianId+"=<BR>");*/

		int start   = 0 ;
		int end     = 0 ;
		int iterate = 1 ;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt(from) ; 

		if ( to == null )
			end = 11 ;
		else
			end = Integer.parseInt(to) ;

		if(isScroll)
		{
			if (!(start <= 1))
			{

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf((start-11)));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((end-11)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(prev));
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
			if ( !( (start+11) > maxNoRecords ) )
			{

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((start+11)));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf((end+11)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(next));
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
		}
		else
		{

            _bw.write(_wl_block13Bytes, _wl_block13);

		}

		rs = pstmt.executeQuery();

		if(isScroll)
		{
			if ( start != 1 )
			{
				for( int j=1; j<start;j++ )
				{
					rs.next() ;
					iterate++;
				}
			}
		}

		if(groupByEpisode.equals("N") && groupByLocn.equals("N"))
		{
			
			//out.println("first Query -----------"+sql.toString()+"-----<BR>");
			String status = null;
			String emergencyYn = null;
			String deceasedYn = null;
			String relationYn = null;
			String className = null;
			String className1 = null;
			String text = null;
			String disp_cls_cons_date = null;
  			StringTokenizer st = null;
			String n = null;           
            boolean header = false;
			String ca_ref_letter_notes_rec_yn = null; //ML-MMOH-CRF-0362 [IN057201]
			while( rs.next() && iterate <= end )
			{
				flag = false;
				iterate++ ;
			
				if(header == false)
				{

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

				header = true;
				i++;
				}
				rowclass = "gridData";
				/*if (k % 2 == 0 )
					rowclass = "gridData";
				else
					rowclass = "gridData";*/

				
				emergencyYn = "";
				deceasedYn = "";
				int noofchildren = 0;
				relationYn = "";
				className = rowclass;
				className1 = rowclass;
				text = "&nbsp;&nbsp;&nbsp;";
				disp_cls_cons_date = "&nbsp;";
				bedside_ref_review_status = rs.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rs.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
				bedside_referral_YN			= rs.getString("BEDSIDE_REFERRAL_YN") == null ? "" : rs.getString("BEDSIDE_REFERRAL_YN"); //added for IN064836
				patient_status	= rs.getString("patient_status") == null ? "" : rs.getString("patient_status");
				episode_type_desc = rs.getString("PATIENT_CLASS")==null?"":rs.getString("PATIENT_CLASS");
				//out.println("episode_type_desc"+episode_type_desc);
				//out.println("patient_status"+patient_status);
				sex = rs.getString("sex")==null?"":rs.getString("sex");
				status = rs.getString("STATUS") == null ? "" : rs.getString("STATUS");
				enctr_id = rs.getString("EPISODE_ID")== null ? "" : rs.getString("EPISODE_ID");
				ca_ref_letter_notes_rec_yn = rs.getString("CA_REF_LETTER_NOTES_REC_YN") ==  null ? "":rs.getString("CA_REF_LETTER_NOTES_REC_YN"); // ML-MMOH-CRF-0362 [IN057201]	
				restPatientYN = rs.getString("restrict_reinstate_yn")== null ? "" : rs.getString("restrict_reinstate_yn");//32902
				if(episode_type_desc.equals("OP"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(episode_type_desc.equals("IP"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(episode_type_desc.equals("EM"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(episode_type_desc.equals("DC"))
					episode_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				if(sex.equals("M") || sex.equals("Male") )
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if(sex.equals("F") || sex.equals("Female"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else if(sex.equals("U") || sex.equals("Unknown"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				//IN064836 start			
				if(!referralRegister)
				{
					if(status.equals("C"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
					else if(status.equals("O"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
				}
				else
				{
					if(status.equals("C") && bedside_ref_review_status.equals("S"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
					else if(status.equals("O") && bedside_ref_review_status.equals(""))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
					else if(status.equals("C") && bedside_referral_YN.equals("N"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
				}
				if(status.equals("P"))//IN064836 ends
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PendingReferrals.label","ca_labels");
				else if(status.equals("U"))
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
				//IN064836 start
				else if(status.equals("X"))
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
				//IN064836 ends
				// added for IN048463 - Start
				if(allow_muti_bedside_review_yn.equals("Y")){
					if(bedside_ref_review_status.equals("P") && !status.equals("P"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
					else if(bedside_ref_review_status.equals("C"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
					else if(bedside_ref_review_status.equals("N")) // IN052595 
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595	
				//IN064836 start
					else if(bedside_ref_review_status.equals("X"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
					else if(bedside_ref_review_status.equals("S"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
				//IN064836 ends
				}
				// added for IN048463 - End
				st = new StringTokenizer(patient_status,"|");
	
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}

				if(!( rs.getString("DISCHARGE_DATE_TIME") == null))
					if( !rs.getString("DISCHARGE_DATE_TIME").equals(""))
						className = "DISCHARGED";
				if(deceasedYn.equals("D"))
				{
					className = "CADECEASED";
					rowclass = "DECEASED1";
					decesedColor = "";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor = "";
				}
				else
				{
					decesedColor = "";
				}
				if(noofchildren > 0) 
					className = "NEWBORN";
				emergencyYn = rs.getString("PRIORITY_ZONE")==null?"":rs.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y"))
				{
				if(!emergencyYn.equals(""))
					className1 = rs.getString("ae_zone_color")==null?"":rs.getString("ae_zone_color");
				}else{
				if(emergencyYn.equals("R")) 
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";}
				//IN044157 - End
				if(relnreqyn.equals("Y"))
				{
					if(relationYn.equals("N"))
						text = "<font size=2><b>*</b></font>";
				}
				if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC"))
				{
					layer = new StringBuffer();
					
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rs.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rs.getString("EPISODE_ID"));
						rsMotherLink = stmtMotherLink.executeQuery();
						while(rsMotherLink.next())
						{
							if(locale.equals("en"))
	                       {
		                     dateofbirth1=rsMotherLink.getString("date_of_birth");
	                       }
	                      else
	                      {
		                   dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
	                      }
							apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
							layer.append("<tr></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
						}
						if(rsMotherLink!=null) rsMotherLink.close();
					}
				}
				//String s=rs.getString("EPISODE_ID");
				//String location = rs.getString("EPISODE_ID")==null?"":rs.getString("EPISODE_ID");
				
				out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rs.getString("QRYTIME")+ "</b>'}</script>");
				String location_details=rs.getString("LOCATION_DETAILS")==null?"":rs.getString("LOCATION_DETAILS");
				out.println("<script>babyDetails["+rs.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rs.getString("EPISODE_ID")+"]=\""+rs.getString("PATIENT_NAME")+"\";</script>");
				
                out.println("<tr>");
				if(!enctr_id.equals(""))
				{
				/*IN034999 starts */
				/*out.println("<td class='gridData'><a href=\"javascript:showEncounterDeatils('"+i+"','"+rs.getString("EPISODE_ID")+"')\" class='gridLink'>&nbsp;+&nbsp;</a></td>");*/
				out.println("<td class='gridData'><a href=\"javascript:showEncounterDeatils('"+i+"','"+rs.getString("EPISODE_ID")+"','"+rs.getString("FACILITY_ID")+"')\" class='gridLink'>&nbsp;+&nbsp;</a></td>");
				/* IN034999 ends */
				}
				else
				{
				out.println("<td class='gridData'></td>");

				}
				//IN044157 - Start		
				if(!emergencyYn.equals(""))
					out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt; width='5%'>&nbsp;&nbsp;&nbsp;</td>");
				else
					out.println("<td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td>");
				//IN044157 - End
				out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td><td class='"+rowclass+"' nowrap><font size=1>"+episode_type_desc+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+location_details+"</font></td>");
				
				//IN065452 start
				if("R".equals(pendingRef) && "Self".equals(unAssigned))
				{
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("PATIENT_NAME")+"</font></td>");
				}
				//if(rs.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") )
				else if(rs.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") )
				//IN065452 ends	
				{
					//[IN030566] Starts
					out.println("<td onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rs.getString("patient_id")+"')\" class='gridLink'><font color="+decesedColor+">"+rs.getString("PATIENT_NAME")+"</a></font></td>");
					//out.println("<td onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:patClick('"+i+"')\" class='gridLink'><font color="+decesedColor+">"+rs.getString("PATIENT_NAME")+"</a></font></td>");					
					//[IN030566] Ends
				}
				else
				{
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("PATIENT_NAME")+"</font></td>");
				}

				//out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' class='gridLink' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>"); // commented for   ML-MMOH-CRF-0362 [IN057201]
				//   ML-MMOH-CRF-0362 [IN057201] - Start
				if("Y".equals(ca_record_referral_note_yn)) {
					//IN065452 start
					if("R".equals(pendingRef) && "Self".equals(unAssigned)){
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}
					//if("Y".equals(ca_ref_letter_notes_rec_yn)){
					else if("Y".equals(ca_ref_letter_notes_rec_yn)){
					//IN065452 ends
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' class='gridLink' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font>&nbsp;<a class='gridLink' href=\"javascript:getRefClinicalNotes('"+rs.getString("patient_id")+"','"+enctr_id+"','"+rs.getString("PATIENT_CLASS")+"','"+facility_id+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' class='gridLink' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}
				}else{
					//IN065452 start
					if("R".equals(pendingRef) && "Self".equals(unAssigned)){
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}
					else{
					//IN065452 ends
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' class='gridLink' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}//IN065452
				}
				//   ML-MMOH-CRF-0362 [IN057201] - End
				//if(rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))//IN047927
				if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
					//IN065452 start
					if("R".equals(pendingRef) && "Self".equals(unAssigned) && !("Unassigned".equals(status))){
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))
					else if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))
					//IN065452 ends	
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"')\" class='gridLink'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//IN064836 start
					/*else				
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
					
					else if(!referralRegister || "N".equals(bedside_referral_YN) || "Unassigned".equals(status)){
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
					}
					else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//IN064836 ends
				} else { // added for IN048463 - Start
					//IN065452 start
					if("R".equals(pendingRef) && "Self".equals(unAssigned) && !("Unassigned".equals(status))){
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals("")))
					else if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals("")))
					//IN065452 ends
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"')\" class='gridLink'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//IN064836 start
					/*else
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
					else if(!referralRegister || "N".equals(bedside_referral_YN) || "Unassigned".equals(status)){
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
					}
					else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//IN064836 ends
					
					// added for IN048463 - End
					
				}
					
                out.println("<script language='javascript'>");
                out.println("episodeIdArr["+i+"]='"+rs.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rs.getString("patient_class")+"';");
				out.println("</script>");

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("patient_id")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("referral_id")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("ASSIGN_CARE_LOCN_CODE")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("ATTEND_PRACTITIONER_ID")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("sex")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("unAssigned_yn")));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block47Bytes, _wl_block47);

			    i++;
			    k++;
			}
			if(rs!=null) rs.close();
			if(stmtMotherLink!=null) stmtMotherLink.close();
			}
				
			else if(groupByEpisode.equals("Y") && groupByLocn.equals("N"))
			{
				String status = null;
				String emergencyYn = null;
				String deceasedYn = null;
				String relationYn = null;
				String className = null;
				String className1 = null;
				String text = null;
				String disp_cls_cons_date = null;
  				StringTokenizer st = null;
				String n = null;           
				boolean header = false;
				String ca_ref_letter_notes_rec_yn = null; //ML-MMOH-CRF-0362 [IN057201]
				while(rs.next())
				{
				flag = false;
				iterate++ ;
			
				if(header == false)
				{

            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

				header = true;
				i++;
				}
				if (k % 2 == 0 )
					rowclass = "gridData";
				else
					rowclass = "gridData";

				
				emergencyYn = "";
				deceasedYn = "";
				int noofchildren = 0;
				relationYn = "";
				className = rowclass;
				className1 = rowclass;
				text = "&nbsp;&nbsp;&nbsp;";
				disp_cls_cons_date = "&nbsp;";
				bedside_ref_review_status 	= rs.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rs.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
				bedside_referral_YN			= rs.getString("BEDSIDE_REFERRAL_YN") == null ? "" : rs.getString("BEDSIDE_REFERRAL_YN"); //added for IN064836
				patient_status	= rs.getString("patient_status") == null ? "" : rs.getString("patient_status");
				episode_type_desc = rs.getString("PATIENT_CLASS")==null?"":rs.getString("PATIENT_CLASS");
				
				sex = rs.getString("sex")==null?"":rs.getString("sex");
				status = rs.getString("STATUS") == null ? "" : rs.getString("STATUS");
				enctr_id = rs.getString("EPISODE_ID")== null ? "" : rs.getString("EPISODE_ID");
				ca_ref_letter_notes_rec_yn = rs.getString("CA_REF_LETTER_NOTES_REC_YN") ==  null ? "":rs.getString("CA_REF_LETTER_NOTES_REC_YN"); // ML-MMOH-CRF-0362 [IN057201]
				if(episode_type_desc.equals("OP"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(episode_type_desc.equals("IP"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(episode_type_desc.equals("EM"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(episode_type_desc.equals("DC"))
					episode_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				if(sex.equals("M") || sex.equals("Male") )
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if(sex.equals("F") || sex.equals("Female"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else if(sex.equals("U") || sex.equals("Unknown"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

				//IN064836 start
				if(!referralRegister)
				{
					if(status.equals("C"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
					else if(status.equals("O"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
				}
				else
				{
					if(status.equals("C") && bedside_ref_review_status.equals("S"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
					else if(status.equals("O") && bedside_ref_review_status.equals(""))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
					else if(status.equals("C") && bedside_referral_YN.equals("N"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
				}
				if(status.equals("P"))//IN064836 ends
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PendingReferrals.label","ca_labels");
				else if(status.equals("U"))
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
				//IN064836 start
				else if(status.equals("X"))
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
				//IN064836 ends
					
				// added for IN048463 - Start
				if(allow_muti_bedside_review_yn.equals("Y")){
					if(bedside_ref_review_status.equals("P") && !status.equals("P"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
					else if(bedside_ref_review_status.equals("C"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
					else if(bedside_ref_review_status.equals("N")) // IN052595 
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595	
					//IN064836 start
					else if(bedside_ref_review_status.equals("X"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels");
					//IN064836 ends
				}
				// added for IN048463 - End
				st = new StringTokenizer(patient_status,"|");
	
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}

				if(!( rs.getString("DISCHARGE_DATE_TIME") == null))
					if( !rs.getString("DISCHARGE_DATE_TIME").equals(""))
						className = "DISCHARGED";
				if(deceasedYn.equals("D"))
				{
					className = "CADECEASED";
					rowclass = "DECEASED1";
					decesedColor = "";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor = "";
				}
				else
				{
					decesedColor = "";
				}
				if(noofchildren > 0) 
					className = "NEWBORN";
				emergencyYn = rs.getString("PRIORITY_ZONE")==null?"":rs.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y"))
				{
				if(!emergencyYn.equals(""))
					className1 = rs.getString("ae_zone_color")==null?"":rs.getString("ae_zone_color");
				}else{
				if(emergencyYn.equals("R")) 
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";}
				//IN044157 - End
				if(relnreqyn.equals("Y"))
				{
					if(relationYn.equals("N"))
						text = "<font size=2><b>*</b></font>";
				}
				if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC"))
				{
					layer = new StringBuffer();
					
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rs.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rs.getString("EPISODE_ID"));
						rsMotherLink = stmtMotherLink.executeQuery();
						while(rsMotherLink.next())
						{
							if(locale.equals("en"))
	                        {
		                      dateofbirth1=rsMotherLink.getString("date_of_birth");
	                        }
	                       else
	                       {
		                    dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
	                       }
							apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
							layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
						}
						if(rsMotherLink!=null) rsMotherLink.close();	
					}
					
				}


				out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rs.getString("QRYTIME")+ "</b>'}</script>");
				out.println("<script>babyDetails["+rs.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rs.getString("EPISODE_ID")+"]=\""+rs.getString("PATIENT_NAME")+"\";</script>");
				
               
				out.println("<tr>");
				if(!enctr_id.equals(""))
				{
				/* IN034999 starts */
				/*out.println("<td class='gridData'><a href=\"javascript:showEncounterDeatils('"+i+"','"+rs.getString("EPISODE_ID")+"')\" class='gridLink'>&nbsp;+&nbsp;</a></td>");*/
				
				out.println("<td class='gridData'><a href=\"javascript:showEncounterDeatils('"+i+"','"+rs.getString("EPISODE_ID")+"','"+rs.getString("FACILITY_ID")+"')\" class='gridLink'>&nbsp;+&nbsp;</a></td>");
				/* IN034999 ends */
				
				}
				else
				{
				out.println("<td class='gridData'></td>");

				}
				//IN044157 - Start		
				if(!emergencyYn.equals(""))
					out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt; width='5%'>&nbsp;&nbsp;&nbsp;</td>");
				else
					out.println("<td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td>");
				//IN044157 - End
				out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("LOCATION_DETAILS")+"</font></td>");
				
				if(rs.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") )
				{
					//[IN030566] Starts
					out.println("<td onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rs.getString("patient_id")+"')\"><font color="+decesedColor+">"+rs.getString("PATIENT_NAME")+"</a></font></td>");
					//out.println("<td onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rs.getString("PATIENT_NAME")+"</a></font></td>");
					//[IN030566] Ends
				}
				else
				{
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("PATIENT_NAME")+"</font></td>");
				}
				
				//out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>"); // commented for ML-MMOH-CRF-0362 [IN057201]
				//   ML-MMOH-CRF-0362 [IN057201] - Start
				if("Y".equals(ca_record_referral_note_yn)) {
					if("Y".equals(ca_ref_letter_notes_rec_yn)){
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font>&nbsp;<a class='gridLink' href=\"javascript:getRefClinicalNotes('"+rs.getString("patient_id")+"','"+enctr_id+"','"+rs.getString("PATIENT_CLASS")+"','"+facility_id+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}
				}else{
					out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
				}
				//   ML-MMOH-CRF-0362 [IN057201] - End
				//if(rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))//IN047927
				if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
					if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"')\">");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//IN064836 start
					/*else
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
					else if(!referralRegister || "N".equals(bedside_referral_YN) || "Unassigned".equals(status)){
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
					}
					else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//IN064836 ends
				} else { // added for IN048463 - Start
					if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals("")))
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"')\" class='gridLink'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//IN064836 start
					/*else
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
					else if(!referralRegister || "N".equals(bedside_referral_YN) || "Unassigned".equals(status)){
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
					}
					else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//IN064836 ends
				} // added for IN048463 - End
				
                out.println("<script language='javascript'>");
                out.println("episodeIdArr["+i+"]='"+rs.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rs.getString("patient_class")+"';");
				out.println("</script>");

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("patient_id")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("referral_id")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("ASSIGN_CARE_LOCN_CODE")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("ATTEND_PRACTITIONER_ID")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("sex")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("unAssigned_yn")));
            _bw.write(_wl_block60Bytes, _wl_block60);

			    i++;
			    k++;
			}
			if(rs!=null) rs.close();
			if(stmtMotherLink!=null) stmtMotherLink.close();

			}
			else if(groupByEpisode.equals("Y") && groupByLocn.equals("Y"))
			{
				String status = null;
				String emergencyYn = null;
				String deceasedYn = null;
				String relationYn = null;
				String className = null;
				String className1 = null;
				String text = null;
				String disp_cls_cons_date = null;
  				StringTokenizer st = null;
				String n = null;           
				boolean header = false;
				String ca_ref_letter_notes_rec_yn = null; //ML-MMOH-CRF-0362 [IN057201]
				while(rs.next())
				{
				flag = false;
				iterate++ ;
			
				if(header == false)
				{

            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

				header = true;
				i++;
				}
				rowclass = "gridData";
				/*if (k % 2 == 0 )
					rowclass = "QRYODD";
				else
					rowclass = "QRYEVEN";*/

				
				emergencyYn = "";
				deceasedYn = "";
				int noofchildren = 0;
				relationYn = "";
				className = rowclass;
				className1 = rowclass;
				text = "&nbsp;&nbsp;&nbsp;";
				disp_cls_cons_date = "&nbsp;";

				bedside_ref_review_status = rs.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rs.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
				bedside_referral_YN			= rs.getString("BEDSIDE_REFERRAL_YN") == null ? "" : rs.getString("BEDSIDE_REFERRAL_YN"); //added for IN064836 
				patient_status	= rs.getString("patient_status") == null ? "" : rs.getString("patient_status");
				episode_type_desc = rs.getString("PATIENT_CLASS")==null?"":rs.getString("PATIENT_CLASS");
				sex = rs.getString("sex")==null?"":rs.getString("sex");
				status = rs.getString("STATUS") == null ? "" : rs.getString("STATUS");
				enctr_id = rs.getString("EPISODE_ID")== null ? "" : rs.getString("EPISODE_ID");
				ca_ref_letter_notes_rec_yn = rs.getString("CA_REF_LETTER_NOTES_REC_YN") ==  null ? "":rs.getString("CA_REF_LETTER_NOTES_REC_YN"); // ML-MMOH-CRF-0362 [IN057201]
				if(episode_type_desc.equals("OP"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(episode_type_desc.equals("IP"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(episode_type_desc.equals("EM"))
					episode_type_desc =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(episode_type_desc.equals("DC"))
					episode_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				if(sex.equals("M") || sex.equals("Male") )
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if(sex.equals("F") || sex.equals("Female"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				else if(sex.equals("U") || sex.equals("Unknown"))
					sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

				//IN064836 start
				if(!referralRegister)
				{
					if(status.equals("C"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
					else if(status.equals("O"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
				}
				else
				{
					if(status.equals("C") && bedside_ref_review_status.equals("S"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
					else if(status.equals("O") && bedside_ref_review_status.equals(""))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.open.label","common_labels");
					else if(status.equals("C") && bedside_referral_YN.equals("N"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.closed.label","common_labels");
				}
				if(status.equals("P"))//IN064836 ends
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.PendingReferrals.label","ca_labels");
				else if(status.equals("U"))
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Unassigned.label","common_labels");
				//IN064836 start
				else if(status.equals("X"))
					status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
				//IN064836 ends

				// added for IN048463 - Start
				if(allow_muti_bedside_review_yn.equals("Y")){
					if(bedside_ref_review_status.equals("P") && !status.equals("P"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
					else if(bedside_ref_review_status.equals("C"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
					else if(bedside_ref_review_status.equals("N")) // IN052595 
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595	
					//IN064836 start
					else if(bedside_ref_review_status.equals("X"))
						status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reject.label","common_labels");
					//IN064836 ends
				}
				// added for IN048463 - End
				if(rs.getString("unAssigned_yn").equals("N"))
					title = "Speciality Specific Patient (Unassigned)";
				else
					title = "";
					
				st = new StringTokenizer(patient_status,"|");
	
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}

				if(!( rs.getString("DISCHARGE_DATE_TIME") == null))
					if( !rs.getString("DISCHARGE_DATE_TIME").equals(""))
						className = "DISCHARGED";
				if(deceasedYn.equals("D"))
				{
					className = "CADECEASED";
					rowclass = "DECEASED1";
					decesedColor = "";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor = "";
				}
				else
				{
					decesedColor = "";
				}
				if(noofchildren > 0) 
					className = "NEWBORN";
				emergencyYn = rs.getString("PRIORITY_ZONE")==null?"":rs.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y"))
				{
				if(!emergencyYn.equals(""))
					className1 = rs.getString("ae_zone_color")==null?"":rs.getString("ae_zone_color");
				}else{
				if(emergencyYn.equals("R")) 
					className1 = "RED";
				if(emergencyYn.equals("Y")) 
					className1 = "YELLOW";
				if(emergencyYn.equals("G")) 
					className1 = "GREEN";}
				//IN044157 - End
				if(relnreqyn.equals("Y"))
				{
					if(relationYn.equals("N"))
						text = "<font size=2><b>*</b></font>";
				}
				if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC"))
				{
					layer = new StringBuffer();
					
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rs.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rs.getString("EPISODE_ID"));
						rsMotherLink = stmtMotherLink.executeQuery();
						while(rsMotherLink.next())
						{
							if(locale.equals("en"))
	                        {
		                      dateofbirth1=rsMotherLink.getString("date_of_birth");
	                        }
	                       else
	                       {
		                      dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
	                       }
							apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
							layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
						}
						if(rsMotherLink!=null) rsMotherLink.close();
					}
					
				}
				out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rs.getString("QRYTIME")+ "</b>'}</script>");
				out.println("<script>babyDetails["+rs.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rs.getString("EPISODE_ID")+"]=\""+rs.getString("PATIENT_NAME")+"\";</script>");
				                
				out.println("<tr>");
				if(!enctr_id.equals(""))
				{
				/* IN034999 starts */
				/*out.println("<td class='gridData'><a href=\"javascript:showEncounterDeatils('"+i+"','"+rs.getString("EPISODE_ID")+"')\" class='gridLink'>&nbsp;+&nbsp;</a></td>");*/
				out.println("<td class='gridData'><a href=\"javascript:showEncounterDeatils('"+i+"','"+rs.getString("EPISODE_ID")+"','"+rs.getString("FACILITY_ID")+"')\" class='gridLink'>&nbsp;+&nbsp;</a></td>");
				/* IN034999 ends */
				}
				else
				{
				out.println("<td class='gridData'></td>");

				}
				//IN044157 - Start		
				if(!emergencyYn.equals(""))
					out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt; width='5%'>&nbsp;&nbsp;&nbsp;</td>");
				else
					out.println("<td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td>");
				//IN044157 - End
				out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td>");
				
				if(rs.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") )
				{
					//[IN030566] Starts
					out.println("<td onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rs.getString("patient_id")+"')\"><font color="+decesedColor+">"+rs.getString("PATIENT_NAME")+"</a></font></td>");
					//out.println("<td onMouseOver='showMotherLinks(\""+rs.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap><font size=1><a href=\"javascript:patClick('"+i+"')\"><font color="+decesedColor+">"+rs.getString("PATIENT_NAME")+"</a></font></td>");
					//[IN030566] Ends
				}
				else
				{
					out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("PATIENT_NAME")+"</font></td>");
				}
				
				//out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>"); // commented for ML-MMOH-CRF-0362 [IN057201]
				//   ML-MMOH-CRF-0362 [IN057201] - Start
				if("Y".equals(ca_record_referral_note_yn)) {
					if("Y".equals(ca_ref_letter_notes_rec_yn)){
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font>&nbsp;<a class='gridLink' href=\"javascript:getRefClinicalNotes('"+rs.getString("patient_id")+"','"+enctr_id+"','"+rs.getString("PATIENT_CLASS")+"','"+facility_id+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
					}
				
				}else{
					out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rs.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rs.getString("referral_id")== null ? "&nbsp;" : rs.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rs.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rs.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rs.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("DISCHARGE_DATE_TIME")==null ? "" : rs.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("ROOM_NO")==null?"&nbsp;":rs.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("BED_NO")==null?"&nbsp;":rs.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rs.getString("attend_pract_name")== null ? "&nbsp;" : rs.getString("attend_pract_name")) +"</font></td>");
				}
				//   ML-MMOH-CRF-0362 [IN057201] - End
				//if(rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))//IN047927
				if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
					if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y"))
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//IN064836 start
					/*else
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
					else if(!referralRegister || "N".equals(bedside_referral_YN) || "Unassigned".equals(status)){
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
					}
					else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//IN064836 ends
				} else { // added for IN048463 - Start
					if(rs.getString("BEDSIDE_REFERRAL_YN").equals("Y") && rs.getString("confirm_yn").equals("Y") && rs.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals("")))
					{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"')\" class='gridLink'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//IN064836 start
					/*else
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
					else if(!referralRegister || "N".equals(bedside_referral_YN) || "Unassigned".equals(status)){
						out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
					}
					else{
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
	
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

						out.println("</a></font></td>");
					}
					//IN064836 ends
				} // added for IN048463 - End
				
                out.println("<script language='javascript'>");
                out.println("episodeIdArr["+i+"]='"+rs.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rs.getString("patient_class")+"';");
				out.println("</script>");

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("patient_id")));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("referral_id")));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("ASSIGN_CARE_LOCN_CODE")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("ATTEND_PRACTITIONER_ID")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("sex")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(rs.getString("unAssigned_yn")));
            _bw.write(_wl_block60Bytes, _wl_block60);

			    i++;
			    k++;
			}
			if(rs!=null) rs.close();
			if(stmtMotherLink!=null) stmtMotherLink.close();
			}
			
		
		if(flag)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
		
		if(rs != null ) rs.close();
		if(pstmt != null) pstmt.close();

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(locationCode));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(fromDate));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(groupByLocn));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(groupByEpisode));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(unAssigned));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(pendingRef));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(closed));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(open));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(refStatus));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(refRegSiteYN));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(relnreqyn));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(request.getParameter("function_id")));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(loc_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block89Bytes, _wl_block89);

		if(!anchorID.equals(""))
		{

            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block97Bytes, _wl_block97);

		}
		putObjectInBean(bean_id,bean,session);
	}
	catch(Exception e)
	{
		
		//out.println("Exception in ReferralPatListResult.jsp ------"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block98Bytes, _wl_block98);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ReferralStatus.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitAdmDate.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VisitAdmEndDate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ReferralStatus.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitAdmDate.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VisitAdmEndDate.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ReferralStatus.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitAdmDate.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VisitAdmEndDate.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
