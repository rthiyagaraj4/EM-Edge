package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.text.*;
import eCA.*;
import eOR.Common.*;
import eOR.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patlistbylocationresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatListByLocationResult.jsp", 1745325749737L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="  \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\t\n\t<script src=\'../../eCA/js/CAMenu.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n    <script src=\'../../eCA/js/PatientListByLocationResult.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/CACommon.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n    <head>\n    </head>\t\n\t<style>\n\t\t.gridDataSelectNew\n\t\t{\n\t\t\tbackground-color: #CDE5FF;\n\t\t\tfont-family: Verdana;\n\t\t\tfont-size: 8pt;\n\t\t\tcolor: #000000;\n\t\t\tfont-weight:normal;\n\t\t\ttext-align:left;\n\t\t\tpadding-left:10px;\n\t\t\tpadding-right:10px;\n\t\t\tvertical-align:middle;\t\n\t\t\tborder-bottom:0px;\n\t\t\tborder-top:0px;\n\t\t\tborder-left:0px;\n\t\t\tborder-right:0px;\n\t\t}\n\t\tthead\n\t\t{\n\t\t\tposition: sticky;\n\t\t\ttop: 0px; \n\t\t\tz-index: 1;\n\t\t}\n\t</style>\n\t<body class=\'CONTENT\' onscroll=\'moveFrame()\' onload=\"storeValues(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\')\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey();\" >\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<table cellpadding=\'0\' id=\"prevnexttab\" cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\' style=\"\tposition: FIXED;top: 0;background-color: #f1f1f1;z-index: 1;\">\n\t\t<tr >\n\t\t<td class=\'white\' width=\'92.5%\'></td> \n\t\t<td nowrap  width=\'5%\' align=\'right\' id=\'previous\' ></td>\n\t\t<td nowrap  width=\'5%\' align=\'right\' id=\'next\' ></td>\n\t\t</tr>\n\t</table>\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<!------------------------ Changes for Prevoius Next Functionality----------->\n\t<input type=\"hidden\" name=\"locationType1\" id=\"locationType1\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\"hidden\" name=\"locationCode1\" id=\"locationCode1\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\"hidden\" name=\"viewList1\" id=\"viewList1\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n \t<input type=\"hidden\" name=\"adm_fromdate1\" id=\"adm_fromdate1\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n    <input type=\"hidden\" name=\"adm_todate1\" id=\"adm_todate1\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type=\"hidden\" name=\"groupByLocn1\" id=\"groupByLocn1\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=\"hidden\" name=\"locationType1\" id=\"locationType1\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\"hidden\" name=\"groupByEpisode1\" id=\"groupByEpisode1\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\" name=\"checked_out1\" id=\"checked_out1\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\" name=\"past1\" id=\"past1\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name=\"discharged1\" id=\"discharged1\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name=\"unscheduled_yn1\" id=\"unscheduled_yn1\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name=\"from_visit_date1\" id=\"from_visit_date1\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\" name=\"to_visit_date1\" id=\"to_visit_date1\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\"hidden\" name=\"from_discharge_date1\" id=\"from_discharge_date1\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\"hidden\" name=\"to_discharge_date1\" id=\"to_discharge_date1\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\"hidden\" name=\"patientId1\" id=\"patientId1\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"nationID1\" id=\"nationID1\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\"hidden\" name=\"queueId1\" id=\"queueId1\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\" name=\"sortOrder1\" id=\"sortOrder1\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"queueStatus1\" id=\"queueStatus1\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=\"hidden\" name=\"reln_req_yn1\" id=\"reln_req_yn1\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\"hidden\" name=\"attend_practId1\" id=\"attend_practId1\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" name=\"speciality1\" id=\"speciality1\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"navigate\">\n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"\">\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"\">\n\t<input type=\"hidden\" name=\"form\" id=\"form\" value=\"Location\">\n\t<input type=\"hidden\" name=\"RP_locn_type\" id=\"RP_locn_type\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\"hidden\" name=\"P_locn_code\" id=\"P_locn_code\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"> <!-- added for CRF 192 -->\n\t<input type=\"hidden\" name=\"assign_confirm_referral_yn\" id=\"assign_confirm_referral_yn\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"><!-- IN048704 -->\n    <input type=\"hidden\" name=\"bar_code_scaned_YN\" id=\"bar_code_scaned_YN\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"><!-- Added for IN072184 -->\n    <input type=\"hidden\" name=\"bar_code_site_yn\" id=\"bar_code_site_yn\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"><!-- Added for IN072184  -->\n\t\n\t<!------------------------ end of change---------------------------------->\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t<Script>\t\t\t\n\t\t\t\tdocument.getElementById(\'previous\').innerHTML=\"\";\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t<script>\t\t\t\t\n\t\t\t\tif(top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById(\'previous\'))\n\t\t\t\t\ttop.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById(\'previous\').innerHTML = \"<INPUT TYPE=\'button\' class=\'button\' name=\'prev\' id=\'prev\' onClick=navigate(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\') title=\'Previous\' value=\'  \\<  \' >\";\n\t\t\t\telse\n\t\t\t\t\tdocument.getElementById(\'previous\').innerHTML = \"<a class=\'gridLink\' href=`javascript:onClick=navigate(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\')`title=\'Previous\' value=\' Previous  \' >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</a>\";\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t<script>\n\t\t\t\tif(top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.next)\n\t\t\t\t\ttop.content.workAreaFrame.PatResultFr.LocnResultTitle.document.next.innerHTML = \"<INPUT TYPE=\'button\' class=\'button\' name=\'nex\' id=\'nex\'  onClick=navigate(\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\') title=\'Next\' value=\'  \\>  \' >\";\n\t\t\t\telse \n\t\t\t\t\tdocument.getElementById(\'next\').innerHTML = \"<a class=\'gridLink\' href=`javascript:onClick=navigate(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\')`title=\'Next\' value=\' next  \' >";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<script>\n\t\t\t\tdocument.getElementById(\'previous\').innerHTML=\"\";\t\t\t\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t<input type=\"hidden\" name=\"maxNoRecords\" id=\"maxNoRecords\"value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\t\t\t    \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_id";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"patient_id";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"referral_id";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" id=\"referral_id";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"location_code";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"location_code";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"practitioner_Id";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" id=\"practitioner_Id";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"sex";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" id=\"sex";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"unAssigned_yn";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" id=\"unAssigned_yn";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t<thead style=\"top: 15px;\">\n\t\t\t\t\t\t\t<tr><th class=\'columnheader\' width=\'16px\'>&nbsp;</th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\'16px\'>&nbsp;</th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\'  onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</a></th><!--54073-->\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a01\'   href=\"javascript:callForOrderByLoc(\'PC\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a02\'   href=\"javascript:callForOrderByLoc(\'LOC\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a03\'   href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</a></th>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t<th class=\'columnheader\'   nowrap><a style=\'color:white\'   >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a07\'   href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</a></th>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a05\'   href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a06\'   href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</a></th>\n\t\t\t\t\t\t\t<!--Added -  Changes suggested by sunil-->\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a11\'   href=\"javascript:callForOrderByLoc(\'BN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a10\'   href=\"javascript:callForOrderByLoc(\'RN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</a></th> \n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a12\'   href=\"javascript:callForOrderByLoc(\'AP\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a  class=\'gridLink\' id=\'a13\'   href=\"javascript:callForOrderByLoc(\'MS\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a08\'   href=\"javascript:callForOrderByLoc(\'AD\');\" onclick=\'changeColor(this);\' style=\'color:pink\'>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><style=\'color:white\'>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td> <!-- IN044246 -->\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a09\' href=\"javascript:callForOrderByLoc(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a14\'   href=\"javascript:callForOrderByLoc(\'DOB\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a15\'   href=\"javascript:callForOrderByLoc(\'AT\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a16\'   href=\"javascript:callForOrderByLoc(\'QN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a17\'   href=\"javascript:callForOrderByLoc(\'QS\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</a></th>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a04\'   href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</a></th>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a18\'   href=\"javascript:callForOrderByLoc(\'PDA\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</a></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t</thead>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t    <!--32902 start-->\n\t\t\t\t\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"  name=\"restPatientYN";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'><!--32902-->\n\t\t\t\t\t\t\t<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'><!--32902-->\n\t\t\t\t\t\t<!--32902 end--->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'><!--32902-->\n\t\t\t\t\t<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'><!--32902-->\n\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t\t<thead>\n\t\t\t\t\t\t\t\t<tr >\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' width=\'16px\'>&nbsp;</td><td class=\'columnheader\' width=\'16px\'>&nbsp;</th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\'  onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</a></th><!--54073-->\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a01\'   href=\"javascript:callForOrderByLoc(\'LOC\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a02\'   href=\"javascript:callForOrderByLoc(\'AT\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a03\'   href=\"javascript:callForOrderByLoc(\'QN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</a></th>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</th>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a04\'   href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a08\'   href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a06\'   href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a  class=\'gridLink\' id=\'a07\'   href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a12\'   href=\"javascript:callForOrderByLoc(\'AP\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a13\'   href=\"javascript:callForOrderByLoc(\'SAP\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a15\'   href=\"javascript:callForOrderByLoc(\'VT\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a  class=\'gridLink\' id=\'a09\'   href=\"javascript:callForOrderByLoc(\'VD\');\" onclick=\'changeColor(this);\' style=\'color:pink\'>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap colspan=2><a class=\'gridLink\' id=\'a11\'   href=\"javascript:callForOrderByLoc(\'QS\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</a></th>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap> ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</th><!-- IN044246 -->\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a10\' href=\"javascript:callForOrderByLoc(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a14\'   href=\"javascript:callForOrderByLoc(\'DOB\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a05\'   href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</a></th>\n\t\t\t\t\t\t\t\t</thead>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t\t\t    <!--32902 start-->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'><!--32902-->\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'><!--32902-->\n\t\t\t\t\t\t\t\t<!--32902 end--->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t\t\t<thead style=\"top: 15px;\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' width=\'16px\'>&nbsp;</th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' width=\'16px\'>&nbsp;</th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\'  onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap colspan=\'3\'><a class=\'gridLink\' id=\'a02\'   href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a06\'   href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a04\'   href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a05\'   href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a11\'   href=\"javascript:callForOrderByLoc(\'BN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a10\'   href=\"javascript:callForOrderByLoc(\'RN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a07\'   href=\"javascript:callForOrderByLoc(\'AD\');\" onclick=\'changeColor(this);\' style=\'color:pink\'>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="</a></th><!--Changes suggested by sunil-->\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a08\'   href=\"javascript:callForOrderByLoc(\'IQS\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap> ";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</th><!-- IN044246 -->\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a09\' href=\"javascript:callForOrderByLoc(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a03\'   href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</thead>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t\t<!--32902 start-->\n\t\t\t\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'><!--32902-->\n\t\t\t\t\t\t<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t\t\t\t\t<thead>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' width=\'16px\'>&nbsp;</th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' width=\'16px\'>&nbsp;</th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a01\'   href=\"javascript:callForOrderByLoc(\'AT\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a  class=\'gridLink\' id=\'a02\'   href=\"javascript:callForOrderByLoc(\'QN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</a></th>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a03\'   href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a  class=\'gridLink\' id=\'a07\'   href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a  class=\'gridLink\' id=\'a05\'   href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a06\'   href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a11\'   href=\"javascript:callForOrderByLoc(\'AP\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a  class=\'gridLink\' id=\'a12\'   href=\"javascript:callForOrderByLoc(\'MS\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a08\'   href=\"javascript:callForOrderByLoc(\'AD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap colspan=2><a class=\'gridLink\' id=\'a10\'   href=\"javascript:callForOrderByLoc(\'QS\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="</a></th>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap style=\'color:white\'> ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="</th><!-- IN044246 -->\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a09\'   href=\"javascript:callForOrderByLoc(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\'  id=\'a13\'   href=\"javascript:callForOrderByLoc(\'DOB\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a04\'   href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="</a></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<thead>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t\t\t\t\t<thead>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' width=\'16px\'>&nbsp;</th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' width=\'16px\'>&nbsp;</th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap colspan=\'3\'><a class=\'gridLink\' id=\'a01\' href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a05\'   href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a03\'   href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a04\'   href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a10\'   href=\"javascript:callForOrderByLoc(\'AP\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a11\'   href=\"javascript:callForOrderByLoc(\'MS\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a06\'   href=\"javascript:callForOrderByLoc(\'AD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a09\'   href=\"javascript:callForOrderByLoc(\'BN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a08\'   href=\"javascript:callForOrderByLoc(\'RN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</th><!-- IN044246 -->\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a07\' href=\"javascript:callForOrderByLoc(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a12\'   href=\"javascript:callForOrderByLoc(\'DOB\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="</a></th>\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' nowrap><a class=\'gridLink\' id=\'a02\'   href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</a></th>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</thead>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\t\t\t    \n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =" \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"patient_id";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"referral_id";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"location_code";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"practitioner_Id";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sex";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"unAssigned_yn";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\'>\n\t\t\t\t\t\t\t<!--32902 start-->\n\t\t\t\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\'><!--32902-->\n\t\t\t\t\t\t<!--32902 end--->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" id=\"practitioner_id";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\"  name=\"practitioner_id";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" id=\"facility_id\"  name=\"facility_id\" id=\"facility_id\" value=\'";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\'>\n\t\t\t\t\t\t<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\'>\n\t\t\t                  \t";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\n\t\t\t\t\t\t\t<input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" id=\"practitioner_id";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" id=\"facility_id\"  name=\"facility_id\" id=\"facility_id\" value=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\'>\n\t\t\t\t\t\t\t<input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\'>\n\t\t\t                ";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n<script>\n\t\t\t\t\t/* <tr id=\'titleHdrRP\' style=\'visibility:hidden\' >\n\t\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="</th>\n\t\t\t\t\t<th nowrap>\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</th>\n\t\t\t\t\t<th nowrap>\t\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="</th>\n\t\t\t\t\t<th nowrap>\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="</th>\n\t\t\t\t\t<th nowrap>\t\t";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="</th>\n\t\t\t\t\t<th nowrap>";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="</th><!-- IN044246 -->\n\t\t\t\t\t<th nowrap>\t\t";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="</th>\n\t\t\t\t\t</tr> */\n\t\t\t\t\t// Define the HTML content to be added\n\t\t\t\tconst newHeaderRow = `<tr id=\'titleHdrRP\' >\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th>&nbsp;</th>\n\t\t\t\t<th nowrap  valign=\"top\"><a id=\'a01\'   href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="</a></th>\n\t\t\t\t<th nowrap  valign=\"top\"><a id=\'a02\'   href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="</a></th>\n\t\t\t\t<th nowrap  valign=\"top\"><a id=\'a03\'   href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="</a></th>\n\t\t\t\t<th nowrap  valign=\"top\"><a id=\'a04\'   href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="</a></th>\n\t\t\t\t<th nowrap  valign=\"top\"><a id=\'a05\'   href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\'color:white\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="</a></th>\n\t\t\t\t<th nowrap  valign=\"top\"><a id=\'a06\'  href=\"javascript:callForOrderByLoc(\'SAP\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="</a></th>\n\t\t\t\t<th nowrap  valign=\"top\"><a id=\'a07\'   href=\"javascript:callForOrderByLoc(\'AD\');\" onclick=\'changeColor(this);\' style=\'color:pink\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="</a></th>\n\t\t\t\t<th nowrap  valign=\"top\"><a id=\'a08\' href=\"javascript:callForOrderByLoc(\'DD\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="</a></th>\n\t\t\t\t<th nowrap  valign=\"top\"><a id=\'a09\'   href=\"javascript:callForOrderByLoc(\'RN\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="</a></th>\n\t\t\t\t<th nowrap  valign=\"top\"><a id=\'a10\'   href=\"javascript:callForOrderByLoc(\'BN\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="</a></th>\n\t\t\t\t<!-- added new header for CRF-025 -->\n\t\t\t\t<!--<th nowrap>";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="</th>-->\n\t\t\t\t<th nowrap  valign=\"top\">";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="</th><!--IN044246-->\n\t\t\t\t<th nowrap  valign=\"top\"><a id=\'a11\'   href=\"javascript:callForOrderByLoc(\'AP\');\" onclick=\'changeColor(this);\' style=\'color:white\'> \t\t\t\t";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="</a></th>\n\t\t\t\t<th nowrap  valign=\"top\">";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="</th>\n\t\t\t\t</tr>`;\n\n// Get the table by its ID\nconst table = document.getElementById(\'PatCriteriaTbl\');\n\n// Check if the table exists\nif (table) {\n    // Get or create the <thead> element\n    let thead = table.querySelector(\'thead\');\n    if (!thead) {\n        thead = document.createElement(\'thead\');\n        table.prepend(thead);\n    }\n    \n    // Add the new header row to the <thead>\n    thead.innerHTML += newHeaderRow;\n} else {\n    console.error(\"Table with ID \'PatCriteriaTbl\' not found.\");\n}\ndocument.getElementById(\'PatCriteriaTbl\').style.marginTop=\"0px\";\ndocument.getElementById(\'prevnexttab\').style.display=\"none\";\nparent.document.getElementById(\'LocnResultTitle\').style.display=\"none\";\nparent.document.getElementById(\'LocnResult\').style.height=\"83vh\";\n\n\t</script>\t\t\t\t\n\t";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n\t\t\t\t\t\n\t\t\t\t\t<script>\n\t\t\t\t\tconst newHeaderRow = `\n\t\t\t\t\t<tr id=\'titleHdrIP\' >\n\t\t\t\t\t<th class=\'columnheader\' width=\"16px\" nowrap  valign=\"top\">&nbsp;</th>\n                        <th class=\'columnheader\' width=\"16px\" nowrap  valign=\"top\">&nbsp;</th>\n                        <!-- //22856-start-->\n                        <th class=\'columnheader\' width=\"\" nowrap rowspan=3 valign=\"top\" >";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="</th>\n                        <!-- //22856-End-->\n                        <th class=\'columnheader\' width=\"\" nowrap colspan=3  valign=\"top\"><a id=\'a01\'  name=1 href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="</a></th>\n                        <th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a02\' name=1 href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="</a></th>\n                        <th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a03\' name=1 href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="</a></th>\n                        <th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a04\' name=1 href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="</a></th>\n\t\t\t\t\t\t<!-- Changes Suggested By Sunil To rearrange bedNo and Room No Column-->\n\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap valign=\"top\"><a id=\'a05\' name=1 href=\"javascript:callForOrderByLoc(\'BN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</a></th><th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a name=1 href=\"javascript:callForOrderByLoc(\'RN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="</a></th>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a06\' name=1 href=\"javascript:callForOrderByLoc(\'AP\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="</a></th>\n\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a07\' name=1 href=\"javascript:callForOrderByLoc(\'MS\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="</a></th>\n\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a08\' name=1 href=\"javascript:callForOrderByLoc(\'AD\');\"  onclick=\'changeColor(this);\' style=\"color:pink\">";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="</a></th>\n\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a09\' name=1 href=\"javascript:callForOrderByLoc(\'IQS\');\"  onclick=\'changeColor(this);\' style=\"color:white\" >";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="</a></th>\n\t\t\t\t\t\t<!-- added new header for CRF-025 -->\n\t\t\t\t\t\t<!--<td class=\'columnheader\' width=\"\" nowrap><style=\"color:white\"/>";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="</td>-->\n\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><style=\"color:white\"/>";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="</th> <!--IN044246-->\n\t\t\t\t\t\t<!-- Changes Suggested By Sunil To rearrange bedNo and Room No Column-->\n\t\t\t\t\t\t<!--<td class=\'columnheader\' width=\"\" nowrap><a id=\'a10\' name=1 href=\"javascript:callForOrderByLoc(\'BN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="</a></td><td class=\'columnheader\' width=\"\" nowrap><a name=1 href=\"javascript:callForOrderByLoc(\'RN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="</a></td>--><th class=\'columnheader\' width=\"\" nowrap valign=\"top\"><a name=1 href=\"javascript:callForOrderByLoc(\'DD\');\"  onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="</a></th><th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a name=1 href=\"javascript:callForOrderByLoc(\'DOB\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="</a></th><th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a name=1 href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="</a></th>\n                        \n\t\t\t\t\t";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\"  valign=\"top\"><a id=\'a11\' name=1 href=\"javascript:callForOrderByLoc(\'PDA\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="</a></th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\n\t\t\t\t\t<th class=\'columnheader\' width=\"\"  valign=\"top\">&nbsp;&nbsp;&nbsp;</th>\n\t\t\t\t\t<tr>`;\n\t\t\t\t\t\n\t\t\t\t\t// Get the table by its ID\nconst table = document.getElementById(\'PatCriteriaTbl\');\n\n// Check if the table exists\nif (table) {\n    // Get or create the <thead> element\n    let thead = table.querySelector(\'thead\');\n    if (!thead) {\n        thead = document.createElement(\'thead\');\n        table.prepend(thead);\n    }\n    \n    // Add the new header row to the <thead>\n    thead.innerHTML += newHeaderRow;\n} else {\n    console.error(\"Table with ID \'PatCriteriaTbl\' not found.\");\n}\ndocument.getElementById(\'PatCriteriaTbl\').style.marginTop=\"0px\";\ndocument.getElementById(\'prevnexttab\').style.display=\"none\";\nparent.document.getElementById(\'LocnResultTitle\').style.display=\"none\";\nparent.document.getElementById(\'LocnResult\').style.height=\"83vh\";\n\t</script>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t const newHeaderRow = `<tr id=\'titleHdrOP\'>\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"16px\" nowrap valign=\"top\">&nbsp;</th>\n                            <th class=\'columnheader\' width=\"16px\" nowrap valign=\"top\">&nbsp;</th>\n                           <!-- //22856-start-->\n                            <th class=\'columnheader\' width=\"\" nowrap rowspan=2 valign=\"top\" >";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="</th>\n                           <!-- //22856-End-->\n                            <!-- <td class=\'columnheader\' width=\"\" nowrap><a id=\'a01\' name=1 href=\"javascript:callForOrderByLoc(\'AT\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="</a></td><td class=\'columnheader\' width=\"\" nowrap><a name=1 href=\"javascript:callForOrderByLoc(\'QN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="</a></td><td class=\'columnheader\' width=\"\" nowrap colspan=3><a name=1 href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="</a></td><td class=\'columnheader\' width=\"\" nowrap><a name=1 href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="</a></td><td class=\'columnheader\' width=\"\" nowrap><a name=1 href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="</a></td><td class=\'columnheader\' width=\"\" nowrap><a name=1 href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="</a></td><td class=\'columnheader\' width=\"\" nowrap><a name=1 href=\"javascript:callForOrderByLoc(\'AP\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="</a></td><td class=\'columnheader\' width=\"\" nowrap><a name=1 href=\"javascript:callForOrderByLoc(\'MS\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="</a></td> [IN030291]-->\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a02\' name=1 href=\"javascript:callForOrderByLoc(\'AT\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a03\' name=1 href=\"javascript:callForOrderByLoc(\'QN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\n\t\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\">";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="</th>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap colspan=3  valign=\"top\"><a id=\'a04\' name=1 href=\"#\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap colspan=3  valign=\"top\"><a id=\'a05\' name=1 href=\"javascript:callForOrderByLoc(\'PN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\n\t\t\t\t\t\t\t\t<th class=\'columnheader\'   nowrap ><a id=\'a06\' style=\'color:white\'   >";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a07\' name=1 href=\"javascript:callForOrderByLoc(\'PID\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a08\' name=1 href=\"javascript:callForOrderByLoc(\'AGE\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a09\' name=1 href=\"javascript:callForOrderByLoc(\'SEX\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a10\' name=1 href=\"javascript:callForOrderByLoc(\'AP\');\" onclick=\'changeColor(this);\' style=\"width=150px;color:white\">";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a11\' name=1 href=\"javascript:callForOrderByLoc(\'MS\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="</a></th>  <!--  [IN030291] -->\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a12\' name=1 href=\"javascript:callForOrderByLoc(\'VT\');\" onclick=\'changeColor(this);\' style=\"color:white\"><nobr>";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="</nobr></a></th>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a13\' name=1 href=\"javascript:callForOrderByLoc(\'VD\');\" onclick=\'changeColor(this);\' style=\"color:pink\">";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap colspan=2 valign=\"top\"><a id=\'a14\' name=1 href=\"javascript:callForOrderByLoc(\'QS\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="</a></th>\n\t\t\t\t\t\t\t\t<!-- added new header for CRF-025 -->\n\t\t\t\t\t\t\t<!--<td class=\'columnheader\' style=\"width=100px;color:white\" nowrap>\t";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\t\t</td>\t-->\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><style=\"color:white\"/>";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="</th> <!--IN044246-->\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><nobr><a id=\'a15\' name=1 href=\"javascript:callForOrderByLoc(\'DD\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="</a></nobr></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><a id=\'a16\' name=1 href=\"javascript:callForOrderByLoc(\'DOB\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="</a></th>\n\t\t\t\t\t\t\t<th class=\'columnheader\' width=\"\" nowrap  valign=\"top\"><nobr><a id=\'a17\' name=1 href=\"javascript:callForOrderByLoc(\'RID\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="</a></nobr></th>\n                            <th class=\'columnheader\' width=\"\"  valign=\"top\">&nbsp;&nbsp;&nbsp;</th>\n\t\t\t\t\t\t\t</tr>`;\n\t\t\t\t\t\n\t\t\t\t\t// Get the table by its ID\nconst table = document.getElementById(\'PatCriteriaTbl\');\n\n// Check if the table exists\nif (table) {\n    // Get or create the <thead> element\n    let thead = table.querySelector(\'thead\');\n    if (!thead) {\n        thead = document.createElement(\'thead\');\n        table.prepend(thead);\n    }\n    \n    // Add the new header row to the <thead>\n    thead.innerHTML += newHeaderRow;\n} else {\n    console.error(\"Table with ID \'PatCriteriaTbl\' not found.\");\n}\ndocument.getElementById(\'PatCriteriaTbl\').style.marginTop=\"0px\";\ndocument.getElementById(\'prevnexttab\').style.display=\"none\";\nparent.document.getElementById(\'LocnResultTitle\').style.display=\"none\";\nparent.document.getElementById(\'LocnResult\').style.height=\"83vh\";\n\t</script>\n\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\n\t\t</table>\n\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\'";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\'>\n\t\t<input type=\"hidden\" name=\"pre_dis_advc_prep_site_YN\" id=\"pre_dis_advc_prep_site_YN\" value=\'";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\'><!--IN064342-->\n\t</form>\n    <div id=\'motherLink\' name=\'motherLink\' style=\'position:absolute; visibility:hidden;overflow:overflow\'></div>\n\t";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\n\t\t<script>\n\t\t\tif(\'";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\'!=\'\'){\n\t\t\t\tdocument.body.scrollLeft=\'";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\';\n\t\t\t}\t\t\t\n\t\t\tif(top.content.workAreaFrame.PatResultFr.LocnResultTitle.document.getElementById(\'TitleTab\') == null){\n\t\t\t\tsetTimeout(\"alignHeading();\",300);\n\t\t\t}else \n\t\t\t\talignHeading();\n\t\t</script>\n\t";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\'!=\'\')\n\t\t\t{\n\t\t\t\tdocument.body.scrollLeft=\'";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\';\n\t\t\t}\n\t\t\tif(\'";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\'!=\'\')\n\t\t\t{   //*** added to make all anchors white before making the selcted one pink\n\t\t\t\tfor(i=0;i<document.anchors.length;i++){\n\t\t\t\t\tdocument.anchors[i].style.color=\'white\';\n\t\t\t\t}//***\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\'==\'1\')\n\t\t\t\t{\n\t\t\t\t\t//document.getElementById(\"PatCriteriaTbl\").";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 =".style.color=\'pink\';\n\t\t\t\t\tdocument.getElementById(\'";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\').style.color=\'pink\';\n\t\t\t\t}\n\t\t\t\telse if(\'";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\'==\'2\')\n\t\t\t\t{\n\t\t\t\t\t//document.getElementById(\"PatCriteriaTbl\").";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 =".style.color=\'yellow\';\n\t\t\t\t\tdocument.getElementById(\'";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\').style.color=\'yellow\';\n\t\t\t\t}\n\t\t\t}\n\t\t</script>\n\t";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\t\t\n\t<script>\t\t\n\t\tparent.parent.PatCriteriaFr.document.getElementById(\'searchID\').disabled = false;\n\t</script>\n    </body>\t\n</html>\n\n";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );
	
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
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
	?			100				?				?			?			?
22/01/2014		IN044246		Chowminya 	22/01/2014	Self		Research Study rename to Patient Classification in all labels,added &nbsp; for alignment	
13/03/2014		IN044157		Chowminya		 					[AAKH-CRF-0010.1]Five level Triage system - AE requirement
06/04/2015		IN048704		Nijitha S							HSA-CRF-0175
06/04/2015		IN052595		Karthi L							Referral Patient List
22/01/2016		IN057193		Karthi L							Flag For Discharge Summary Not Done
-------------------------------------------------------------------------------------------------------------------------------
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
09/08/2016		IN064836		Krishna Gowtham		09/08/2017		Ramesh G	ML-MMOH-CRF-0566.1
23/10/2017		IN064342		Krishna Gowtham		23/10/2017		Ramesh G	GHL-CRF-0468.1
26/03/2018		IN067111		Ramesh G			26/03/2018					ML-MMOH-SCF-0957
18/10/2019		IN071570		Nijitha S			18/10/2019		Ramesh G	ML-BRU-SCF-1989
08/07/2020     IN072184         Chandrashekar raju  08/07/2020      Ramesh G    Modified for MMS-DM-CRF-0157.2
15/04/2023		37866			Ramesh G		 								MMS-DM-CRF-0226
22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778
18/10/2023     32902             Krishna Pranay    	     19/10/2023      Ramesh G      MMS-DM-CRF-0210	
14/11/2023		51215		Ramesh												ML-MMOH-CRF-1930.2
05/12/2023   54073     srinivasa N T              ramesh Goli   
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
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String legendstyle		= "padding-left:0px;padding-right:0px";
	String locn_type		= request.getParameter("locn_type");
	String RP_locn_type		= request.getParameter("RP_locn_type")==null?"":request.getParameter("RP_locn_type");
	String pre_dis_advc_prep_site_YN 	=	request.getParameter("pre_dis_advc_prep_site_YN")==null?"":request.getParameter("pre_dis_advc_prep_site_YN"); //IN064342
	String Summary=request.getParameter("Summary")==null?"":request.getParameter("Summary");
	
	if(RP_locn_type.equals("RP"))locn_type="RP";
	if(locn_type==null || locn_type.equals("null") || locn_type=="")locn_type="";
	String bar_code_scaned_YN="";//IN072184
	String bar_code_site_yn="";//Added for IN072184


	
	String queueValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QPr.label","ca_labels");	
	if(locn_type.equals("OP"))
		queueValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QNo.label","ca_labels");
	else if(locn_type.equals("EM"))
		queueValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels");
	else
		queueValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.QPr.label","ca_labels");

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection  con =null;

	PreparedStatement stmtMotherLink = null;
	PreparedStatement pstmtForAEPat = null;
	ResultSet rsMotherLink = null;	
	ResultSet rsPatList = null;

	String facility_id=(String)session.getValue("facility_id");
	if(facility_id == null) facility_id="";
	webbeans.op.PatientData patdata = new  webbeans.op.PatientData();    
	patdata.setFacility_id(facility_id);
	//32902 start
	String ca_bean_id 						= "@CACommonGetPatientDtlBean";
	String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
	CACommonGetPatientDtlBean bean1					= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
	 int accessRightsViewPatient=0;
	 //32902 end
	PatListByLocationResult bean ;
	String bean_id = "CA_ca_patListbylocationresult" ;
	String bean_name = "eCA.PatListByLocationResult";
	String allow_muti_bedside_review_yn="";	
	
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt=new java.util.Date();
	HashMap qryStringHash = new HashMap();
	
	boolean flag = true;
	boolean isQMSapplicable	=	false;
	StringBuffer layer = new StringBuffer();
	
	boolean pre_dis_advc_prep_siteYN = CommonBean.isSiteSpecific(con, "CA", "PRE_DIS_ADVC_PRE");//IN064342	
	boolean isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION"); //37866
	
	boolean header = false;
	boolean outpHeader=false;
	boolean inpHeader=false;
	
	String c4cStatuDisplay=""; //51215
	out.println("<form name='PatCriteriaFrm' id='PatCriteriaFrm'  action='../../eCA/jsp/OpenChartWrapper.jsp' method = 'post' target='messageFrame' >");
	
            _bw.write(_wl_block9Bytes, _wl_block9);

    out.println("<table id='PatCriteriaTbl' border=1 width='100%' class='grid' style='margin-top: 15px;'>");
	
            _bw.write(_wl_block10Bytes, _wl_block10);

	String clinicianId, decesedColor, encounterID, queueDesc,patientClass;
	clinicianId = decesedColor = encounterID = queueDesc = patientClass="";
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	clinicianId =(String)session.getValue("ca_practitioner_id");
	if(clinicianId == null) clinicianId="";
	
	
	String Sdate = dateFormat.format( dt ) ;
	String apgar_score="	";
	String mode = (request.getParameter("mode")==null)? "" :(String)request.getParameter("mode");
	
	String locationType, locationCode, viewList, adm_fromdate, adm_todate, groupByLocn, groupByEpisode, checkedout, past, discharged;
	locationType = locationCode = viewList = adm_fromdate = adm_todate = groupByLocn = groupByEpisode = checkedout = past = discharged = "";
	
	String unscheduledyn, fromvisitdate, tovisitdate, fromdischargedate, todischargedate, relnreqyn, patientId, nationID;
	unscheduledyn = fromvisitdate = tovisitdate = fromdischargedate = todischargedate = relnreqyn = patientId = nationID = "";
		
	String queueId, queueStatus, queueNumber, sortOrder, episode_type_desc, sex, queue_status, visit_episode_status, strTempDisp; 
	queueId = queueStatus = queueNumber = sortOrder = episode_type_desc = sex = queue_status = visit_episode_status = strTempDisp = "";
	
	String mo_install_yn, visitStyle, attend_practId, speciality, visitType, bedNo, q_num, pi_clinical_stud_gif, site_id, patName, bedside_ref_review_status;
	mo_install_yn = visitStyle = attend_practId = speciality = visitType= bedNo = q_num = pi_clinical_stud_gif = site_id = patName = bedside_ref_review_status = "";
	String restPatientYN="";//32902
	String from = request.getParameter("from") ;
	String to = request.getParameter("to") ;
	String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
	String leftScrolling	= request.getParameter("leftScrolling")==null?"":request.getParameter("leftScrolling");
	String anchorID	= request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
	String virtualConsultation_yn = request.getParameter("virtualConsultation_yn")==null?"N":request.getParameter("virtualConsultation_yn"); //51215
	String prev =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String next =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	String assign_confirm_referral_yn = "";
	int res_pat_rec_count = 0;
	String qms_interfaced_yn =	"N";
	 
	String qms_call_counter = "0"; 
	 	
	visitType = request.getParameter("visitType")==null?"":request.getParameter("visitType");
	String link_allowed_yn="Y"; 

	if(reOrder.equals("1"))
		visitStyle = "color:pink" ;
	else
		visitStyle = "color:yellow" ;
	
	assign_confirm_referral_yn = request.getParameter("assign_confirm_referral_yn")==null?"":request.getParameter("assign_confirm_referral_yn");//IN048704
	
	con = ConnectionManager.getConnection(request);
	isQMSapplicable=eOP.QMSInterface.isSiteSpecific(con,"OP","EXT_QUEUE_NO");//IN071570
	int maxNoRecords = 0;
	
	String refRegSiteYN = "";
	Boolean referralRegister = CommonBean.isSiteSpecific(con, "IP", "RECNL_REFERRAL_REGISTER");
	//boolean isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION");  //37866
	boolean isVirtualConsSDGSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION_SDG");	//51215
	if(referralRegister)
		refRegSiteYN = "Y";	
	else
		refRegSiteYN = "N";
	
	if(mode.equals("search") || mode.equals("")) //when request for search for first time
	{
		locationType=request.getParameter("locationType")==null?"":request.getParameter("locationType");		
		locationCode=request.getParameter("locationCode")==null?"":request.getParameter("locationCode");		
		viewList=request.getParameter("viewList")==null?"":request.getParameter("viewList");
		adm_fromdate	=	request.getParameter("adm_fromdate")==null?"":request.getParameter("adm_fromdate");
		adm_todate		=	request.getParameter("adm_todate")==null?"":request.getParameter("adm_todate");
		
		groupByLocn=request.getParameter("groupByLocn");
		if(groupByLocn==null || groupByLocn.equals("null") || groupByLocn=="")
			groupByLocn="";

		groupByEpisode=request.getParameter("groupByEpisode");
		if(groupByEpisode==null || groupByEpisode.equals("null") || groupByEpisode=="")
			groupByEpisode="";

		checkedout=request.getParameter("checked_out")==null?"N":request.getParameter("checked_out");
		past=request.getParameter("past")==null?"N":request.getParameter("past");
		discharged=request.getParameter("discharged")==null?"N":request.getParameter("discharged");

		unscheduledyn=request.getParameter("unscheduled_yn")==null?"N":request.getParameter("unscheduled_yn");

		fromvisitdate = request.getParameter("from_visit_date")==null?"":request.getParameter("from_visit_date");
		tovisitdate = request.getParameter("to_visit_date")==null?"":request.getParameter("to_visit_date");
		fromdischargedate = request.getParameter("from_discharge_date")==null?"":request.getParameter("from_discharge_date");
		todischargedate	= request.getParameter("to_discharge_date")==null?"":request.getParameter("to_discharge_date");
		relnreqyn = request.getParameter("reln_req_yn")==null?"Y":request.getParameter("reln_req_yn");
		patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		nationID	=	request.getParameter("nationID"); 
		if(nationID==null || nationID.equals("null") || nationID=="")
			nationID	=	"";
		queueId = request.getParameter("queueId")==null?"":request.getParameter("queueId");
		sortOrder = request.getParameter("sortOrder")==null?"v":request.getParameter("sortOrder");
		queueStatus = request.getParameter("queueStatus")==null?"":request.getParameter("queueStatus");
		if (queueStatus.equals("~~"))
			queueStatus = "";
		queueStatus	=	queueStatus.replace('~','\'');
		attend_practId = request.getParameter("attend_practId")==null?"":request.getParameter("attend_practId");
		speciality = request.getParameter("speciality")==null?"":request.getParameter("speciality");
		bedNo = request.getParameter("bedNo").equals("")||request.getParameter("bedNo")==null?"%":request.getParameter("bedNo");//IN29412	
		 bar_code_scaned_YN =request.getParameter("bar_code_scaned_YN")==null?"N":request.getParameter("bar_code_scaned_YN");//Added for IN072184
		 bar_code_site_yn =request.getParameter("bar_code_site_yn")==null?"N":request.getParameter("bar_code_site_yn");//Added for IN072184
			//System.err.println("bar_code_scaned_YN if @@@ Resultpage"+bar_code_scaned_YN+"bar_code_site_yn@@2==="+bar_code_site_yn+"patientId=="+patientId);
		
	}
	else
	{
		//Called when navigating
		locationType=request.getParameter("locationType1");
		if(locationType==null || locationType.equals("null") || locationType=="")
			locationType="";
		locationCode=request.getParameter("locationCode1");
		if(locationCode==null || locationCode.equals("null") || locationCode=="")
			locationCode="";
		
		viewList=request.getParameter("viewList1");
		if(viewList==null || viewList.equals("null") || viewList=="")
			viewList="";
		adm_fromdate = request.getParameter("adm_fromdate1")==null?"":request.getParameter("adm_fromdate1");
		adm_todate=request.getParameter("adm_todate1")==null?"":request.getParameter("adm_todate1");
		if(adm_fromdate==null || adm_fromdate.equals("null") || adm_fromdate=="")
			adm_fromdate="";
		if(adm_todate==null || adm_todate.equals("null") || adm_todate=="")
			adm_todate="";
		groupByLocn=request.getParameter("groupByLocn1");

		if(groupByLocn==null || groupByLocn.equals("null") || groupByLocn=="")
			groupByLocn="";

		groupByEpisode=request.getParameter("groupByEpisode1");
		if(groupByEpisode==null || groupByEpisode.equals("null") || groupByEpisode=="")
			groupByEpisode="";
		checkedout=request.getParameter("checked_out1")==null?"N":request.getParameter("checked_out1");
		past=request.getParameter("past1")==null?"N":request.getParameter("past1");
		discharged=request.getParameter("discharged1")==null?"N":request.getParameter("discharged1");

		unscheduledyn=request.getParameter("unscheduled_yn1")==null?"N":request.getParameter("unscheduled_yn1");
		fromvisitdate = request.getParameter("from_visit_date1")==null?"":request.getParameter("from_visit_date1");
		tovisitdate=request.getParameter("to_visit_date1")==null?"":request.getParameter("to_visit_date1");
		fromdischargedate = request.getParameter("from_discharge_date1")==null?"":request.getParameter("from_discharge_date1");
		todischargedate = request.getParameter("to_discharge_date1")==null?"":request.getParameter("to_discharge_date1");
		relnreqyn = request.getParameter("reln_req_yn1")==null?"Y":request.getParameter("reln_req_yn1");
		patientId = request.getParameter("patientId1")==null?"":request.getParameter("patientId1");
		nationID=request.getParameter("nationID1");
		if(nationID==null || nationID.equals("null") || nationID=="")
			nationID="";
		
		queueId = request.getParameter("queueId1")==null?"":request.getParameter("queueId1");
		sortOrder = request.getParameter("sortOrder1")==null?"v":request.getParameter("sortOrder1");
		queueStatus = request.getParameter("queueStatus1")==null?"":request.getParameter("queueStatus1");
		if (queueStatus.equals("00")) 
			queueStatus="";
		attend_practId = request.getParameter("attend_practId1")==null?"":request.getParameter("attend_practId1");
		speciality = request.getParameter("speciality1")==null?"":request.getParameter("speciality1");
		bedNo = request.getParameter("bedNo")==null||request.getParameter("bedNo").equals("")?"%":request.getParameter("bedNo");//IN29412
		 bar_code_scaned_YN =request.getParameter("bar_code_scaned_YN")==null?"N":request.getParameter("bar_code_scaned_YN");//Added for IN072184
			bar_code_site_yn =request.getParameter("bar_code_site_yn")==null?"N":request.getParameter("bar_code_site_yn");//Added for IN072184
	//		System.err.println("bar_code_scaned_YN if @@@ Resultpage"+bar_code_scaned_YN+"bar_code_site_yn@@2==="+bar_code_site_yn+"patientId=="+patientId);
	}
	adm_fromdate	=	com.ehis.util.DateUtils.convertDate(adm_fromdate,"DMY",locale,"en");
	adm_todate		=	com.ehis.util.DateUtils.convertDate(adm_todate,"DMY",locale,"en");
	fromdischargedate	=	com.ehis.util.DateUtils.convertDate(fromdischargedate,"DMY",locale,"en");
	todischargedate		=	com.ehis.util.DateUtils.convertDate(todischargedate,"DMY",locale,"en");
	fromvisitdate	=	com.ehis.util.DateUtils.convertDate(fromvisitdate,"DMY",locale,"en");
	tovisitdate		=	com.ehis.util.DateUtils.convertDate(tovisitdate,"DMY",locale,"en");

	boolean isScroll	= true;
	boolean floatTitle  = false;
	boolean isIP = false;
	boolean isOP = false;
	locn_type =	request.getParameter("locn_type");
	if(locn_type==null)
		locn_type="";
	String locn_code =	request.getParameter("locn_code");
	if(locn_code==null)
		locn_code="";
	
	qms_interfaced_yn = eOP.QMSInterface.isClinicQMSInterfaced(locn_code,facility_id,con); // added for CRF 192 - IN030532
	RP_locn_type=request.getParameter("RP_locn_type")==null?"":request.getParameter("RP_locn_type");

	if(RP_locn_type.equals("RP"))
		locn_type="RP";
	
	if(groupByEpisode.equals("Y") && groupByLocn.equals("Y")){
		floatTitle = true;
		isScroll = false;
		if(!locn_type.equals("")){
			if(locn_type.equals("OP")){
				isOP = true;
				locationType = "OP";
			}else if(locn_type.equals("IP")){
				isIP = true;
				locationType = "IP";
			}else if(locn_type.equals("EM")){
				isOP = true;
				locationType = "EM";
			}else if(locn_type.equals("DC")){
				isIP = true;
				locationType = "DC";
			}else if(locn_type.equals("RP")){
				isScroll = true;
			}
		}
		if(!locn_code.equals(""))
			locationCode = locn_code;
	}else if(groupByEpisode.equals("Y") && groupByLocn.equals("N") ){
		if(!locn_type.equals("")){
			if(locn_type.equals("OP")){
				isOP = true;
				locationType = "OP";
			}else if(locn_type.equals("IP")){
				isIP = true;
				locationType = "IP";
			}else if(locn_type.equals("EM")){
				isOP = true;
				locationType = "EM";
			}else if(locn_type.equals("DC")){
				isIP = true;
				locationType = "DC";
			}
		}		
	}
	//krishna ends
	// added for CRF 192 
	qryStringHash.put("Relnreqyn", relnreqyn); 
	qryStringHash.put("LocationType", locationType); 
	qryStringHash.put("PatientId", patientId);
	qryStringHash.put("NationID", nationID);
	qryStringHash.put("QueueId", queueId);
	qryStringHash.put("QueueStatus", queueStatus);
	qryStringHash.put("GroupByEpisode", groupByEpisode);
	qryStringHash.put("Unscheduledyn", unscheduledyn);
	qryStringHash.put("Checkedout", checkedout);
	qryStringHash.put("Past", past);
	qryStringHash.put("Fromvisitdate", fromvisitdate);
	qryStringHash.put("Tovisitdate", tovisitdate);
	qryStringHash.put("ViewList", viewList);
	qryStringHash.put("LocationCode", locationCode);
	
	qryStringHash.put("Attend_practId", attend_practId);
	qryStringHash.put("Speciality", speciality);
	qryStringHash.put("VisitType", visitType);
	qryStringHash.put("Discharged", discharged);
	qryStringHash.put("Fromdischargedate", fromdischargedate);
	qryStringHash.put("Todischargedate", todischargedate);
	qryStringHash.put("Adm_fromdate", adm_fromdate);
	qryStringHash.put("Adm_todate", adm_todate);
	qryStringHash.put("Locn_type", locn_type);
	qryStringHash.put("ReOrder", reOrder);
	qryStringHash.put("OrderBy", orderBy);
	qryStringHash.put("GroupByLocn", groupByLocn);
	qryStringHash.put("SortOrder", sortOrder);
	qryStringHash.put("ClinicianId", clinicianId);
	qryStringHash.put("Locale", locale);
	qryStringHash.put("Facility_id", facility_id);
	qryStringHash.put("BedNo", bedNo);
	qryStringHash.put("assign_confirm_referral_yn", assign_confirm_referral_yn);//IN048704
	qryStringHash.put("virtualConsultation_yn",virtualConsultation_yn); //51215
	
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(locationCode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(viewList));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(adm_fromdate));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(adm_todate));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(groupByLocn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(groupByEpisode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(checkedout));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(past));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(discharged));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(unscheduledyn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(fromvisitdate));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(tovisitdate));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(fromdischargedate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(todischargedate));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(nationID));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(queueId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(sortOrder));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(queueStatus));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(relnreqyn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(attend_practId));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(assign_confirm_referral_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bar_code_scaned_YN));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bar_code_site_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
	/*----------------Code at for next Previous------*/
	int start   = 0 ;
	int end     = 0 ;
	int iterate =1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt(from) ; 

	if ( to == null )
		end = 11 ;
	else
		end = Integer.parseInt(to) ;
	int counts=start;//54073
	/*--------------------------------------------------*/
	
	String sqlMotherLink = "select a.patient_id pat_id, replace(decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)) ,'''','')  short_name, to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth, to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH, a.WEIGHT, a.WEIGHT_UNIT, a.LENGTH ||' cms'  LENGTH_OF_BABY,a.CIRCUMFERENCE ||' cms'  CIRCUMFERENCE_OF_HEAD,a.APGAR_SCORE, b.sex from mp_birth_register a,mp_patient b where  b.patient_id=a.patient_id and a.mother_patient_id= ? and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by pat_id asc  ";//Modified --[IN029180]
	 
	PreparedStatement stmtPatList = null ;
	try
	{	
		bean = (PatListByLocationResult)getObjectFromBean( bean_id, bean_name, session ) ;
		allow_muti_bedside_review_yn  = bean.getMultiBedSideReviewYN(facility_id); // added for IN048463
		mo_install_yn 	= bean.getMOInstallYN(con);
		site_id 		= bean.getSiteId(con);
		qryStringHash.put("Mo_install_yn", mo_install_yn);
		stmtMotherLink = con.prepareStatement(sqlMotherLink);
		int k=0;
		int i=0;
		String rowclass = "gridData";
		
		if((groupByEpisode.equals("N") || groupByLocn.equals("N"))||((groupByEpisode.equals("Y") || groupByLocn.equals("Y"))&&locn_type.equals("RP"))){
			rsPatList = bean.patListByLocationResult(con,qryStringHash); // modified for CRF 192	
			while(rsPatList.next())
				maxNoRecords += 1;
		}
			
		if(rsPatList!=null)rsPatList.close();	
		
            _bw.write(_wl_block41Bytes, _wl_block41);
if(isScroll){
            _bw.write(_wl_block42Bytes, _wl_block42);
if (!(start <= 1)){
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((start-11)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((end-11)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((start-11)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((end-11)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(prev));
            _bw.write(_wl_block47Bytes, _wl_block47);
}if ( !( (start+11) > maxNoRecords ) ){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((start+11)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((end+11)));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((start+11)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((end+11)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(next));
            _bw.write(_wl_block47Bytes, _wl_block47);
}
		}else{
            _bw.write(_wl_block51Bytes, _wl_block51);

		}
		rsPatList = bean.patListByLocationResult(con,qryStringHash); // modified for CRF 192
		if(isScroll){
			if ( start != 1 ){
				for( int j=1; j<start;j++ ){
					rsPatList.next() ;
					iterate++;
				}
			}
		}//end of isScroll
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(maxNoRecords));
            _bw.write(_wl_block53Bytes, _wl_block53);

		if(groupByEpisode.equals("N") && groupByLocn.equals("N")){
			try{
				String status = null;
				String emergencyYn = null;
				String deceasedYn = null;
				String relationYn = null;
				String className = null;
				String className1 = null;
				String text = null;
				String tempDischargeDate = "";
				String disp_cls_cons_date = null;
				StringTokenizer st = null;
				String n = null;           
				//boolean header=false;
				String pendDisSummColor = "#000000", pendDisSummtTip = ""; //ML-MMOH-CRF-0356 [IN057193]
				String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="";//Added forIN072994

				while(rsPatList.next() && iterate <=end ){
					patName="";//IN067111
					res_pat_rec_count  = rsPatList.getInt("RES_STUDIES_CNT"); //CRF-025 - IN030466
					if(res_pat_rec_count > 0) //added for CRF-025 - IN030466
					{
						pi_clinical_stud_gif = "<img src='../../eCA/images/PI_ClinicalStudies.gif'/>";	
					}else{
						pi_clinical_stud_gif = "";
					} 
					
					flag = false; //shaiju
					iterate++ ;
					
					if (k % 2 == 0 )
					   rowclass = "gridData";
					else
						rowclass = "gridData";

					if(locn_type.equals("RP")){
						String patient_status="";
						String title ="";
						String dateofbirth1  ="";
						
						flag = false;					
						if(header == false){
						
            _bw.write(_wl_block54Bytes, _wl_block54);
            {java.lang.String __page ="../../eCA/jsp/PatListByLocationResultHeader01.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block55Bytes, _wl_block55);
		
							header = true;
							i++;
						}
						rowclass = "gridData";					
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date = "&nbsp;";

						patient_status	= rsPatList.getString("patient_status") == null ? "" : rsPatList.getString("patient_status");
						episode_type_desc = rsPatList.getString("PATIENT_CLASS")==null?"":rsPatList.getString("PATIENT_CLASS");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						status = rsPatList.getString("STATUS") == null ? "" : rsPatList.getString("STATUS");
						bedside_ref_review_status = rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");

						episode_type_desc = bean.getLabel(pageContext,episode_type_desc);
						//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994

						

						
						if("U".equals(sex))
							sex = "Unknown";
						
						sex  = bean.getLabel(pageContext,sex);
						
						status  = bean.getLabel(pageContext,status);
						
						if(allow_muti_bedside_review_yn.equals("Y")){
							if(bedside_ref_review_status.equals("P"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandTobeReviewedAgain.label","ip_labels");
							else if(bedside_ref_review_status.equals("C"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.SeenandClosed.label","ip_labels");
							else if(bedside_ref_review_status.equals("N")) // IN052595 
							status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NotSeenandClosed.label","ip_labels");	// IN052595
							else if(bedside_ref_review_status.equals("X"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Rejected.label","common_labels");
							else if(bedside_ref_review_status.equals("S"))
								status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");
						}
						
						if(rsPatList.getString("unAssigned_yn").equals("N"))
							title = "Speciality Specific Patient (Unassigned)";
						else
							title = "";
							
						st = new StringTokenizer(patient_status,"|");
		
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}
						if(!( rsPatList.getString("DISCHARGE_DATE_TIME") == null))
							if( !rsPatList.getString("DISCHARGE_DATE_TIME").equals(""))
								className = "DISCHARGED";
						if(deceasedYn.equals("D")){
							className = "CADECEASED";
							rowclass = "DECEASED1";
							decesedColor = "";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";
							decesedColor = "";
						}
						else{
							decesedColor = "";
						}
						if(noofchildren > 0) 
							className = "NEWBORN";
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC")){
							layer = new StringBuffer();
							
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									if(locale.equals("en")){
									  dateofbirth1=rsMotherLink.getString("date_of_birth");
									}
								   else{
									  dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
								   }
									apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}
								if(rsMotherLink!=null) rsMotherLink.close();
							}
							
						}
						out.println("<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
						out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
						out.println("<tr><td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td><td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td>");
						
						if(rsPatList.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") ){
							out.println("<td onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap onkeydown=\"javascript:if(event.keyCode == 13) patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"',,'"+rsPatList.getString("episode_id")+"')\"><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"',,'"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a></font></td>");//IN032928
						}else{
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+patName+"</font></td>");
						}
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rsPatList.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("DISCHARGE_DATE_TIME")==null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("ROOM_NO")==null?"&nbsp;":rsPatList.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("BED_NO")==null?"&nbsp;":rsPatList.getString("BED_NO"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif +"</a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("attend_pract_name")== null ? "&nbsp;" : rsPatList.getString("attend_pract_name")) +"</font></td>"); // modified above out.println for CRF-025 IN030466
					
						if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
							if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y")){
								if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
			
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

								out.println("</a></font></td>");
							}//IN064836 start
								else
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}
							/*else
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");*/
							else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}
							else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

								out.println("</a></font></td>");
							}
							//IN064836 ends
						} // added for IN048463 - Start
						else {  
							if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals("")))
							{
								if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704	
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
			
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;

								out.println("</a></font></td>");
							}//IN064836 start
								else
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}						
							else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}
							else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

								out.println("</a></font></td>");
							}
							//IN064836 ends
						} // added for IN048463 - End
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for MIN072994
						out.println("</script>");
	
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("patient_id")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("referral_id")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("ASSIGN_CARE_LOCN_CODE")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("ATTEND_PRACTITIONER_ID")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("sex")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("unAssigned_yn")));
            _bw.write(_wl_block72Bytes, _wl_block72);

						i++;
						k++;
					}else{
						if(header==false){
							out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>'}</script>");
							
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

							//37866 Start.
							if(isVirtualConsSiteSpec && "OP".equals(locationType)){
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
}
							//37866 End.
							
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(queueValue));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);

							//IN064342 start
							if("Y".equals(pre_dis_advc_prep_site_YN)){
						
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

							}
							//IN064342 ends
						
            _bw.write(_wl_block97Bytes, _wl_block97);

							header=true;
							i++;
						}				
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";				
						disp_cls_cons_date ="&nbsp;";
						status			= rsPatList.getString("status")==null?"":rsPatList.getString("status");

						queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
						visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
						episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
						//Adding startIN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994

						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
					
						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
						
						if("Y".equals(rsPatList.getString("PEND_DISC_SUM_YN"))){ //ML-MMOH-CRF-0356 [IN057193] 
							pendDisSummColor = "'color:red;'";
							pendDisSummtTip = "alt ='Discharge Summary is not done' title= 'Discharge Summary is not done'";
						}else { 
							pendDisSummColor = "'color:black;'";
							pendDisSummtTip = "";
						} //ML-MMOH-CRF-0356 [IN057193]
						if(episode_type_desc.equals("IP")){
							if(patName.equals("X")){
								continue;
							}else if(patName.indexOf("|")!=-1){
								patName = patName.substring(patName.indexOf("|")+1);
								link_allowed_yn="N";
							}
						}
						queue_status  = bean.getLabelTxt(pageContext, episode_type_desc, queue_status, visit_episode_status); //Code changed to reduce number of code line
						
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						
						if(sex.equals("M") || sex.equals("Male") )
							sex ="M";
						else if(sex.equals("F") || sex.equals("Female"))
							sex ="F";
						else if(sex.equals("U") || sex.equals("Unknown"))
							sex ="U";
		
						st = new StringTokenizer(status,"|");
		
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}
						if(deceasedYn.equals("D")){
							className="CADECEASED";
							rowclass = "DECEASED1";
							decesedColor="";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";
							decesedColor="";
						}else{
							decesedColor="";
						}
						tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");

						if(!deceasedYn.equals("D")){
							if(!tempDischargeDate.equals("")){
								className = "DISCHARGED";
							}else if(noofchildren > 0){						
								className = "NEWBORN";
							}
						}
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
					    restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
						accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
						//IN044157 - Start
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						//IN044157 - End
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						if(rsPatList.getString("episode_type").equals("I")){
							layer = new StringBuffer();
							disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
							if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
								disp_cls_cons_date="&nbsp;";

							if(!disp_cls_cons_date.equals("&nbsp;")){
								disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);}
							else{
								disp_cls_cons_date = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
							}

							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("patient_id"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=gridData>" +rsMotherLink.getString("pat_id") +"</td><td class=gridData>" + rsMotherLink.getString("short_name") + "</td><td class=gridData>" +rsMotherLink.getString("sex") + "</td><td class=gridData>" + com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale) + "</td><td class=gridData>" +rsMotherLink.getString("TIME_OF_BIRTH") + "</td><td class=gridData>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</td><td class=gridData>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</td><td class=gridData>" +rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</td><td class=gridData>"+apgar_score+"</td></tr>");}
													
							}
						}				
						out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+rsPatList.getString("PATIENT_NAME")+"\";</script>");
						out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
						//IN044157 - Start		
						out.println("<tr>");
						if(!emergencyYn.equals(""))
							out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
						else
							out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
						//IN044157 - End
						out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td class=gridData nowrap>&nbsp;"+ counts++ +"</td><td id='rta"+i+"' class=gridData nowrap>"+episode_type_desc+"</td><td id='rtb"+i+"' class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td id='rtc"+i+"' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class=gridData nowrap>");//54073
						if(link_allowed_yn.equals("Y")){
							out.println("<a class='gridLink' href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN032928					
						}
						else{
						out.println("<font color="+decesedColor+">"+patName);
						}
						//37866 Start.
						if(isVirtualConsSiteSpec && "OP".equals(locationType)  && ("Y".equals(rsPatList.getString("virtualApptYN")))){
							out.println("<td id='rtct"+i+"' class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
						}else if(isVirtualConsSiteSpec && "OP".equals(locationType)){ 	
							out.println("<td id='rtct"+i+"' class='gridData' nowrap>&nbsp;</td>");
						}
						//37866 End.
						out.println("</font></td><td id='rtd"+i+"' class=gridData nowrap>"+ rsPatList.getString("patient_id")+"</td><td id='rte"+i+"' class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td id='rtf"+i+"' class=gridData nowrap>"+sex+"</td><td id='rtk"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("BED_NUM")+"</a></td>");
						out.println("<td id='rtl"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("ROOM_NUM")+"</a></td>");
						out.println("<td id='rtg"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+(rsPatList.getString("PHYSICIAN_NAME")== null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME")) +"</a></td>");
						out.println("<td id='rth"+i+"' class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td id='rti"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td id='rtj"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td><td id='rtm"+i+"' class=gridData nowrap>"+disp_cls_cons_date+"</td>");
						out.println("<td id='rtn"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td><td id='rto"+i+"' class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td id='rtp"+i+"' class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td><td  id='rtq"+i+"' class=gridData nowrap style="+pendDisSummColor+pendDisSummtTip+">"+queue_status+"</td>"); // modified for CRF-025 - IN030466//Added - Changes suggested by sunil
						//IN064342 start
						if(rsPatList.getString("referral_id")!= null){
							if("N".equals(pre_dis_advc_prep_site_YN)){
								out.println("<td id='rtr"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}else{
								out.println("<td id='rtr"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
							}
						}else{
							if("N".equals(pre_dis_advc_prep_site_YN)){
								out.println("<td id='rtr"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}else{
								out.println("<td id='rtr"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
							}
						}
						if("Y".equals(pre_dis_advc_prep_site_YN)){
							if("Y".equals(rsPatList.getString("pre_disg_advice_YN"))){
								out.println("<td class=gridData nowrap>");
								
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

								out.println("</td></tr>");
							}else{
								out.println("<td class=gridData nowrap>");
								
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

								out.println("</td></tr>");
							}
						}
						//IN064342 ends
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for IN072994
						out.println("</script>");
						
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block103Bytes, _wl_block103);

						i++;
						k++;
						link_allowed_yn="Y";
					}
				}
				if(rsPatList!=null) rsPatList.close();
				if(rsMotherLink!=null) rsMotherLink.close();	
				if(stmtMotherLink!=null) stmtMotherLink.close();	
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		else if(groupByEpisode.equals("Y") && groupByLocn.equals("N"))
		{
			try{
				boolean outpHeader=false;
				boolean inpHeader=false;
				String currcompstring = "";
				String prevcompstring = "`";
				String status =		null;
				String currpract = null;
				String currvisitdate = null;
				String emergencyYn = null;
				String deceasedYn = null;
				String relationYn = null;
				String className = null;
				String className1 = null;
				String text = null;                   
				String disp_cls_cons_date =null;                  
				StringTokenizer st = null;
				String n =null;
				String datedisplay = null;
				String practScheduled= null;
				String tempDischargeDate = "";
				//boolean header = false;
				String p_queue_status = null; // added for CRF 192 - IN030532
				String pendDisSummColor = "#000000", pendDisSummtTip = ""; //ML-MMOH-CRF-0356 [IN057193]			
			    String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="";//Added for IN072994
			    int count= 1;//   22856 - ML-MMOH-CRF-1778
				while(rsPatList.next() && iterate <=end ) 
				{
					patName="";//IN067111
					res_pat_rec_count  = rsPatList.getInt("RES_STUDIES_CNT"); //CRF-025	- IN030466
					if(res_pat_rec_count > 0)
						pi_clinical_stud_gif = "<img src='../../eCA/images/PI_ClinicalStudies.gif'/>";
					else
						pi_clinical_stud_gif = "";
					encounterID = rsPatList.getString("EPISODE_ID"); // added for CRF 192 - IN030532				
					p_queue_status = rsPatList.getString("queue_status");  // added for CRF 192 - IN030532
					
					//IN042191 starts
					q_num =rsPatList.getString("QUEUE_NUM")==null?"":rsPatList.getString("QUEUE_NUM");							
				
					if(q_num.equals("0")) queueNumber = "&nbsp;";
					//IN042191 ends
							else queueNumber = rsPatList.getString("QUEUE_NUM");
					
					String p_patient_id = rsPatList.getString("patient_id");// CRF 192 - IN030532
					
					iterate++ ;
					
					flag=false;

					if (k % 2 == 0 )
						rowclass = "gridData";
					else
						rowclass = "gridData";
						// color coding

					if(locn_type.equals("RP")){
						String patient_status="";
						String title ="";
						String dateofbirth1  ="";
						
						flag = false;			
						if(header == false)
						{
						
            _bw.write(_wl_block104Bytes, _wl_block104);
            {java.lang.String __page ="../../eCA/jsp/PatListByLocationResultHeader01.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block55Bytes, _wl_block55);

							header = true;
							i++;
						}
						rowclass = "gridData";				
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date = "&nbsp;";

						patient_status	= rsPatList.getString("patient_status") == null ? "" : rsPatList.getString("patient_status");
						episode_type_desc = rsPatList.getString("PATIENT_CLASS")==null?"":rsPatList.getString("PATIENT_CLASS");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						status = rsPatList.getString("STATUS") == null ? "" : rsPatList.getString("STATUS");
						bedside_ref_review_status = rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
					    restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
						accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding endIN072994

						//IN064836 start
						if("U".equals(sex))
							sex = "Unknown";
						//IN064836 ends
						sex  = bean.getLabel(pageContext,sex);
						
						status  = bean.getLabel(pageContext,status);
						// added for IN048463 - Start
						if(allow_muti_bedside_review_yn.equals("Y")){
							if(bedside_ref_review_status.equals("P"))
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
						if(rsPatList.getString("unAssigned_yn").equals("N"))
							title = "Speciality Specific Patient (Unassigned)";
						else
							title = "";						
						st = new StringTokenizer(patient_status,"|");
			
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}
						if(!( rsPatList.getString("DISCHARGE_DATE_TIME") == null))
							if( !rsPatList.getString("DISCHARGE_DATE_TIME").equals(""))
								className = "DISCHARGED";
						if(deceasedYn.equals("D")){
							className = "CADECEASED";
							rowclass = "DECEASED1";
							decesedColor = "";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";
							decesedColor = "";
						}else{
							decesedColor = "";
						}
						if(noofchildren > 0) 
							className = "NEWBORN";
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						//IN044157 - Start
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						//IN044157 - End
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC")){
							layer = new StringBuffer();
							
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									if(locale.equals("en"))
									  dateofbirth1=rsMotherLink.getString("date_of_birth");
									else
									  dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
								 
									apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}
								if(rsMotherLink!=null) rsMotherLink.close();
							}
							
						}
						out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
						out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
						out.println("<tr><td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td><td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td>");
						
						if(rsPatList.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("")) 
							out.println("<td onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a></font></td>");						
						else
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+patName+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id"))+"</font></a></font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rsPatList.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("DISCHARGE_DATE_TIME")==null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("ROOM_NO")==null?"&nbsp;":rsPatList.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("BED_NO")==null?"&nbsp;":rsPatList.getString("BED_NO"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif +"</a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("attend_pract_name")== null ? "&nbsp;" : rsPatList.getString("attend_pract_name")) +"</font></td>"); //modifid above for CRF-025 IN030466									
						if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
							if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y")){
								if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
			
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

								out.println("</a></font></td>");
								}//IN064836 start
								else
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

								out.println("</a></font></td>");
							}
							//IN064836 ends
						}	// added for IN048463 - Start
						else {  
								if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals(""))){
									if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
										out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
				
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

									out.println("</a></font></td>");
									}//IN064836 start
									else
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}						
							else if(!referralRegister|| "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}
							else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

								out.println("</a></font></td>");
							}
							//IN064836 ends
						} // added for IN048463 - End
							out.println("<script language='javascript'>");
							out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
							out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
							out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added forIN072994
						    out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added forIN072994
						    out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added forIN072994
							out.println("</script>");
		
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("patient_id")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("referral_id")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("ASSIGN_CARE_LOCN_CODE")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("ATTEND_PRACTITIONER_ID")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("sex")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("unAssigned_yn")));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block108Bytes, _wl_block108);

						i++;
						k++;
					}else{
						status			= rsPatList.getString("status")==null?"":rsPatList.getString("status");
						queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
						visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
						episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");

						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
						//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994


						if(episode_type_desc.equals("IP")){
							if(patName.equals("X")){
								continue;
							}else if(patName.indexOf("|")!=-1){
								patName = patName.substring(patName.indexOf("|")+1);
								link_allowed_yn="N";
							}
						}
						
						queue_status  = bean.getLabelTxt(pageContext, episode_type_desc, queue_status, visit_episode_status); //Code changed to reduce number of code line
						
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						
						if(sex.equals("M") || sex.equals("Male") )
							sex ="M";
						else if(sex.equals("F") || sex.equals("Female"))
							sex ="F";
						else if(sex.equals("U") || sex.equals("Unknown"))
							sex ="U";
						currpract = rsPatList.getString("ACTUAL_PHYSICIAN_ID")==null?"":rsPatList.getString("ACTUAL_PHYSICIAN_ID");
						currvisitdate = rsPatList.getString("visit_date")==null?"":rsPatList.getString("visit_date");
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date ="&nbsp;";
						st = new StringTokenizer(status,"|");
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}				
						tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");

						if(deceasedYn.equals("D")){
							className="CADECEASED"; rowclass = "DECEASED1"; decesedColor="";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";  decesedColor="";
						}else{
							decesedColor="";
						}
						if (!deceasedYn.equals("D")){	
							if(!tempDischargeDate.equals("")) className = "DISCHARGED";
							else if((noofchildren > 0)) className = "NEWBORN";
						}
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						//IN044157 - Start
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						//IN044157 - End
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
						if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
							disp_cls_cons_date = "&nbsp;";

						if(!disp_cls_cons_date.equals("&nbsp;")){
							disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);
						}else{
							disp_cls_cons_date = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}

						if(rsPatList.getString("episode_type").equals("O")){
							if(outpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+ rsPatList.getString("QRYTIME")+"</b>'}</script>");
								
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(queueValue));
            _bw.write(_wl_block113Bytes, _wl_block113);
 							
								if(isQMSapplicable && locn_type.equals("OP")){ 
								
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
}
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

								//37866 Start.
								if(isVirtualConsSiteSpec && "OP".equals(locationType)){
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
}
								//37866 End.
								
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
 if(locationType.equals("OP")){
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
}
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);

								i++; i++;  outpHeader=true;
							}						
							datedisplay = rsPatList.getString("adm_visit_date").substring(0,rsPatList.getString("adm_visit_date").indexOf(" "));
							if(datedisplay.equals(Sdate)) 
								datedisplay = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CurrentQueue.label","ca_labels");
							if(unscheduledyn.equals("Y") && past.equals("N")){
								practScheduled= "Unassigned";
								if(currpract.equals(""))    
									practScheduled = "Unassigned";
								else
									practScheduled = "Assigned";
								currcompstring = practScheduled;						
							}else if(unscheduledyn.equals("N") && past.equals("Y")){
								currcompstring = currvisitdate;
							}else if(unscheduledyn.equals("Y") && past.equals("Y")){
								practScheduled= "Unassigned";
								if(currpract.equals(""))    
									practScheduled = "Unassigned";
								else 
									practScheduled = "Assigned";
								currcompstring = practScheduled+currvisitdate;
							}
							if(!currcompstring.equals("")){
								if(!currcompstring.equals(prevcompstring)){
									i++;
								}
							}
							//IN044157 - Start		
						    restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
							accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							//IN044157 - End
							//51215 Start.
							c4cStatuDisplay="";
							if(isVirtualConsSDGSpec && "OP".equals(locationType)  && ("Y".equals(rsPatList.getString("C4C_STATUS_DISPLAY")))){
								c4cStatuDisplay="<img src='../../eCA/images/bellIcon.png' alt='Patient Waiting for Virtual Consultation'/>";
							}
							//51215 End.
							out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td class=gridData nowrap>&nbsp;"+ count++ +"&nbsp;"+c4cStatuDisplay+"</td><td id='rta"+i+"' class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td id='rtb"+i+"' class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td id='rtc"+i+"' class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td>");						
							int qms_call_cnt = rsPatList.getInt("QMS_CALL_COUNT"); // added for  // added for CRF 192 - IN030532 - Start
							String callRecall="Call.png";
							String mouseOver="Call Patient";
							if(qms_call_cnt >=1)
							{
								callRecall="Recall.png";
								mouseOver="Recall Patient";
								qms_call_cnt=(qms_call_cnt-1)<=0?0:(qms_call_cnt-1);
								qms_call_counter=String.valueOf(qms_call_cnt);
							}else{
								qms_call_counter="";
							}
							if(isQMSapplicable && locn_type.equals("OP")){	
								if(qms_interfaced_yn.equals("Y") && !encounterID.equals("0") && !p_queue_status.equals("01") && !"&nbsp;".equals((String)rsPatList.getString("QUEUE_NUM"))){
									out.println("<td id='rtp"+i+"' class=gridData nowrap><img style='cursor:pointer;' src='../../eCommon/images/"+callRecall+"' alt='"+mouseOver+"' onclick=\"callPatient('"+p_patient_id+"','"+encounterID+"','"+queueNumber+"');\" >&nbsp;<FONT size=1>"+qms_call_counter+"</td> "); //IN000000
								}else{
									out.println(" <td id='rtp"+i+"' class = gridData nowrap>&nbsp;</td> ");//IN000000
								}
							} // END added for CRF 192 - IN030532					
							if(link_allowed_yn.equals("Y")){
								out.println("<td id='rtd"+i+"' class=gridData nowrap><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN000000							
							}else{
								out.println("<td id='rtd"+i+"' class=gridData nowrap><font color="+decesedColor+">"+patName);//IN000000
							}
							//37866 Start.
							if(isVirtualConsSiteSpec && "OP".equals(locationType) && ("Y".equals(rsPatList.getString("virtualApptYN")))){
								out.println("<td id='rtct"+i+"' class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
							}else if(isVirtualConsSiteSpec && "OP".equals(locationType)){ 	
								out.println("<td id='rtct"+i+"' class='gridData' nowrap>&nbsp;</td>");
							}
							//37866 End.
							
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block132Bytes, _wl_block132);

							out.println("</font></td><td id='rte"+i+"' class=gridData nowrap>"+rsPatList.getString("patient_id")+"</td><td id='rtf"+i+"' class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td id='rtg"+i+"' class=gridData nowrap>"+sex+"</td><td id='rth"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+(rsPatList.getString("PHYSICIAN_NAME")== null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</a></td><td id='rti"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("SPLTY_NAME")+"</a></td>");//Added - Changes suggested by sunil
							if(locationType.equals("OP")){
							out.println("<td id='rtq"+i+"' class=gridData nowrap>"+rsPatList.getString("visit_type")+"</td>");
							}
							out.println("<td id='rtj"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td id='rtk"+i+"' class=gridData nowrap colspan='2'>"+queue_status+"</td><td id='rtl"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td><td id='rtm"+i+"' class=gridData nowrap>"+disp_cls_cons_date+"</td><td id='rtn"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>");
							if(rsPatList.getString("referral_id")!= null){
							out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}else{
							out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}
						}
						else if(rsPatList.getString("episode_type").equals("I"))
						{
							if("Y".equals(rsPatList.getString("PEND_DISC_SUM_YN"))){ //ML-MMOH-CRF-0356 [IN057193] 
								pendDisSummColor = "'color:red;'";
								pendDisSummtTip = "alt ='Discharge Summary is not done' title= 'Discharge Summary is not done'";
							}else { 
								pendDisSummColor = "'color:black;'";
								pendDisSummtTip = "";
							} //ML-MMOH-CRF-0356 [IN057193]
							layer = new StringBuffer();
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("patient_id"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									apgar_score=rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append( "<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale)+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}							
							}
							
							if(inpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
								
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

								//IN064342 start
								if("Y".equals(pre_dis_advc_prep_site_YN)){
							
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

								}
								//IN064342 Ends
							
            _bw.write(_wl_block145Bytes, _wl_block145);

								i++;
								i++;
								inpHeader=true;
							}
							 restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
							accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
							out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
							//IN044157 - Start		
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							//IN044157 - End
							out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td class=gridData nowrap>&nbsp;"+counts++ +"</td><td id='rta"+i+"' class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td id='rtb"+i+"' onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class=gridData nowrap colspan='3'>");//54073
							
							if(link_allowed_yn.equals("Y")){
								out.println("<a class='gridLink'  href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN032928													
							}
							else{
								out.println("<font color="+decesedColor+">"+patName);
							}
							out.println("</font></td><td id='rtc"+i+"' class=gridData nowrap>"+ rsPatList.getString("patient_id")+"</td><td id='rtd"+i+"' class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td id='rte"+i+"' class=gridData nowrap>"+sex+"</td>");
							out.println("<td id='rtk"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("BED_NUM")+"</a></td>");
							out.println("<td id='rtl"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+rsPatList.getString("ROOM_NUM")+"</a></td>");
							out.println("<td id='rtf"+i+"' class=gridData nowrap><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</a></td>");
							out.println("<td id='rtg"+i+"' class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td id='rth"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td id='rti"+i+"' class=gridData nowrap style="+pendDisSummColor+pendDisSummtTip+">"+queue_status+"</td>");
							out.println("<td id='rtj"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td><td id='rtm"+i+"' class=gridData nowrap>"+disp_cls_cons_date+"</td><td id='rtn"+i+"' class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>"); // added for CRF-025 - IN030466//Changes suggested bu sunil
							//IN064342 start
							if(rsPatList.getString("referral_id")!= null){
								if("N".equals(pre_dis_advc_prep_site_YN)){
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
								}
								else{
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
								}
							}else{
								if("N".equals(pre_dis_advc_prep_site_YN)){	
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
								}else{
									out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
								}
							}
							if("Y".equals(pre_dis_advc_prep_site_YN)){
								if("Y".equals(rsPatList.getString("pre_disg_advice_YN"))){
									out.println("<td class=gridData nowrap>");
								
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

								out.println("</td></tr>");
								}else{
									out.println("<td class=gridData nowrap>");
								
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);

									out.println("</td></tr>");
								}
							}
							//IN064342 ends
						}
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");					
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for IN072994
						out.println("</script>");
					   
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block103Bytes, _wl_block103);

						i++; k++;
						prevcompstring = currcompstring; link_allowed_yn="Y";
					}
				}
				if(rsPatList!=null) rsPatList.close();
				if(rsMotherLink!=null) rsMotherLink.close();	
				if(stmtMotherLink!=null) stmtMotherLink.close();	
			
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}else if(groupByEpisode.equals("N") && groupByLocn.equals("Y")){
			try{
				//boolean outpHeader=false; 
				//boolean inpHeader=false;
				String currLocn="";
				String currcompstring = "";
				String prevcompstring = "`";
				String displaytext = "";
				String status = null;
				String currpract = null;
				String currvisitdate = null;
				String emergencyYn = null;
				String deceasedYn = null;
				String relationYn = null;
				String className = null;
				String className1 = null;
				String text = null;					  
				String disp_cls_cons_date =null;						  
				StringTokenizer st = null;
				String n = null;
				String datedisplay = null;
				String practScheduled= null;
				String tempDischargeDate = "";
				//boolean header = false;
				String p_patient_id = "";// added for CRF 192 - IN030532 
				String p_queue_status = null; //added for CRF 192 - IN030532
				String pendDisSummColor = "#000000", pendDisSummtTip = ""; //ML-MMOH-CRF-0356 [IN057193]
				String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="";//Added for IN072994
				qms_interfaced_yn = eOP.QMSInterface.isClinicQMSInterfaced(locn_code,facility_id,con); // added for CRF 192 - IN030532
				int count= 1;//22856- ML-MMOH-CRF-1778
				while(rsPatList.next() && iterate <=end ){
					patName="";//IN067111
					res_pat_rec_count  = rsPatList.getInt("RES_STUDIES_CNT"); //CRF - 025 - IN030466	
					if(res_pat_rec_count > 0){
						pi_clinical_stud_gif = "<img src='../../eCA/images/PI_ClinicalStudies.gif'/>";
					}else{
						pi_clinical_stud_gif = "";
					}
					p_patient_id = rsPatList.getString("patient_id"); //added for CRF 192 - IN030532 
					
					//IN042191 starts
					q_num =rsPatList.getString("QUEUE_NUM")==null?"":rsPatList.getString("QUEUE_NUM");							
					
					if(q_num.equals("0")) queueNumber = "&nbsp;";				
					else queueNumber = rsPatList.getString("QUEUE_NUM");
					p_queue_status = rsPatList.getString("queue_status"); // End
					
					iterate++ ;
						
					flag=false;
					if (k % 2 == 0 )
						rowclass = "gridData";
					else
						rowclass = "gridData";

					if(locn_type.equals("RP")){
						String patient_status="";
						String title ="";
						String dateofbirth1  ="";					
						flag = false;
						if(header == false){				
							header = true;
							i++;
						}
						rowclass = "gridData";				
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date = "&nbsp;";

						patient_status	= rsPatList.getString("patient_status") == null ? "" : rsPatList.getString("patient_status");
						episode_type_desc = rsPatList.getString("PATIENT_CLASS")==null?"":rsPatList.getString("PATIENT_CLASS");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						status = rsPatList.getString("STATUS") == null ? "" : rsPatList.getString("STATUS");
						bedside_ref_review_status = rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
						
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994

						//IN064836 start
						if("U".equals(sex))
							sex = "Unknown";
						//IN064836 ends
						sex  = bean.getLabel(pageContext,sex);
						status  = bean.getLabel(pageContext,status);
						// added for IN048463 - Start
						if(allow_muti_bedside_review_yn.equals("Y")){
							if(bedside_ref_review_status.equals("P"))
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
						if(rsPatList.getString("unAssigned_yn").equals("N"))
							title = "Speciality Specific Patient (Unassigned)";
						else
							title = "";						
						st = new StringTokenizer(patient_status,"|");	
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}

						if(!( rsPatList.getString("DISCHARGE_DATE_TIME") == null))
							if( !rsPatList.getString("DISCHARGE_DATE_TIME").equals(""))
								className = "DISCHARGED";
						if(deceasedYn.equals("D")){
							className = "CADECEASED"; rowclass = "DECEASED1"; decesedColor = "";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY"; decesedColor = "";
						}else{
							decesedColor = "";
						}
						if(noofchildren > 0) 
							className = "NEWBORN";
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						//IN044157 - Start
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						//IN044157 - End
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC")){
							layer = new StringBuffer();						
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									if(locale.equals("en"))								
									  dateofbirth1=rsMotherLink.getString("date_of_birth");
									else
									  dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
								  
									apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td>");
									layer.append("<td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td>");
									layer.append("<td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}
								if(rsMotherLink!=null) rsMotherLink.close();
							}
							
						}
						out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
						out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
						out.println("<tr><td class='gridLink' ><a href=\"javascript:showEncounterDeatils()\" >&nbsp;+&nbsp;</a></td><td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td><td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td>");
						
						if(rsPatList.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") ){
							out.println("<td onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a></font></td>");
						}else{
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+patName+"</font></td>");
						}
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id"))+"</font></a></font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+ rsPatList.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("DISCHARGE_DATE_TIME")==null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("ROOM_NO")==null?"&nbsp;":rsPatList.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("BED_NO")==null?"&nbsp;":rsPatList.getString("BED_NO"))+"</font></td>");
						out.println("<td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif +"</a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("attend_pract_name")== null ? "&nbsp;" : rsPatList.getString("attend_pract_name")) +"</font></td>"); // modified above out.println for CRF-025 IN030466
						if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
							if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y")){
								if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
									out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
			
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

									out.println("</a></font></td>");
								}//IN064836 start
									else
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

								out.println("</a></font></td>");
							}
							//IN064836 ends
						}  // added for IN048463 - Start
						else { 
							if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals("")))
							{
								if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
									out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
			
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

								out.println("</a></font></td>");
								}//IN064836 start
									else
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
							}else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
			
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

								out.println("</a></font></td>");
							}
							//IN064836 ends
						} // added for IN048463 - End
						
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for IN072994
						out.println("</script>");
		
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("patient_id")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("referral_id")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("ASSIGN_CARE_LOCN_CODE")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("ATTEND_PRACTITIONER_ID")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("sex")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("unAssigned_yn")));
            _bw.write(_wl_block72Bytes, _wl_block72);

						i++;
						k++;
					}else{
						status			= rsPatList.getString("status")==null?"":rsPatList.getString("status");
						queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
						visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
						episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994


						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");	
						if(episode_type_desc.equals("IP")){
							if(patName.equals("X")){
								continue;
							}else if(patName.indexOf("|")!=-1){
								patName = patName.substring(patName.indexOf("|")+1);
								link_allowed_yn="N";
							}
						}
						
						queue_status  = bean.getLabelTxt(pageContext, episode_type_desc, queue_status, visit_episode_status); //Code changed to reduce number of code line
						
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						
						if(sex.equals("M") || sex.equals("Male") )
							sex ="M";
						else if(sex.equals("F") || sex.equals("Female"))
							sex ="F";
						else if(sex.equals("U") || sex.equals("Unknown"))
							sex ="F";

						currpract = rsPatList.getString("ACTUAL_PHYSICIAN_ID")==null?"":rsPatList.getString("ACTUAL_PHYSICIAN_ID");
						currvisitdate = rsPatList.getString("visit_date")==null?"":rsPatList.getString("visit_date");
						emergencyYn = ""; deceasedYn = ""; 
						int noofchildren = 0;
						relationYn = ""; className = rowclass; className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;"; disp_cls_cons_date ="&nbsp;";
						st = new StringTokenizer(status,"|");
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}
					
						tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");

						if(deceasedYn.equals("D")){
							className="CADECEASED";
							rowclass = "DECEASED1";
							decesedColor="";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";
							decesedColor="";
						}else{
							decesedColor="";
						}
						if (!deceasedYn.equals("D"))
						{	
							if(!tempDischargeDate.equals("")) className = "DISCHARGED";
							else if((noofchildren > 0)) className = "NEWBORN";
						}
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						//IN044157 - Start
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						//IN044157 - End
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
						if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
							disp_cls_cons_date="&nbsp;";

						if(!disp_cls_cons_date.equals("&nbsp;")){
							disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);
						}else{
							disp_cls_cons_date = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}
						if(rsPatList.getString("episode_type").equals("O")){
							if(outpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
								
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(queueValue));
            _bw.write(_wl_block150Bytes, _wl_block150);
 if(isQMSapplicable && locn_type.equals("OP")){ 
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
}
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

								//37866 Start.
								if(isVirtualConsSiteSpec && "OP".equals(locationType)){
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
}
								//37866 End.
								
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);

								i++;
								outpHeader=true;
							}
							datedisplay = rsPatList.getString("adm_visit_date").substring(0,rsPatList.getString("adm_visit_date").indexOf(" "));
							if(datedisplay.equals(Sdate)) 
								datedisplay = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CurrentQueue.label","ca_labels");
							if(unscheduledyn.equals("Y") && past.equals("N")){
								practScheduled= "Unassigned";
								strTempDisp   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UnAssigned.label","common_labels");
								if(currpract.equals("")){
									practScheduled = "Unassigned";
									strTempDisp   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UnAssigned.label","common_labels");
								}else {
									practScheduled = "Assigned";
									strTempDisp   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assigned.label","common_labels");
								}
								currcompstring = rsPatList.getString("LOCN_NAME")+practScheduled;
								displaytext= rsPatList.getString("LOCN_NAME")+", "+strTempDisp;
							}else if(unscheduledyn.equals("N") && past.equals("Y")){
								currcompstring = rsPatList.getString("LOCN_NAME")+currvisitdate;
								displaytext= rsPatList.getString("LOCN_NAME")+", "+datedisplay;
							}else if(unscheduledyn.equals("Y") && past.equals("Y")){
								practScheduled= "Unassigned";
								strTempDisp   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UnAssigned.label","common_labels");
								if(currpract.equals("")){
									practScheduled = "Unassigned";
									strTempDisp   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.UnAssigned.label","common_labels");
								}else{
									practScheduled = "Assigned";
									strTempDisp   =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Assigned.label","common_labels");
								}
								currcompstring = rsPatList.getString("LOCN_NAME")+practScheduled+currvisitdate;
								displaytext= rsPatList.getString("LOCN_NAME")+", "+strTempDisp+", "+datedisplay;
							}else{
								currcompstring = rsPatList.getString("LOCN_NAME");
								displaytext= rsPatList.getString("LOCN_NAME");
							}
							if(!currcompstring.equals(prevcompstring)){
								out.println("<tr><td class='CAGROUP'  colspan='16'><font size=1><b>"+displaytext+"</b></font></td></tr>");
								i++;
							}
							//IN044157 - Start		
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							//IN044157 - End
							//51215 Start.
							c4cStatuDisplay="";
							if(isVirtualConsSDGSpec && "OP".equals(locationType)  && ("Y".equals(rsPatList.getString("C4C_STATUS_DISPLAY")))){
								c4cStatuDisplay="<img src='../../eCA/images/bellIcon.png' alt='Patient Waiting for Virtual Consultation'/>";
							}
							//51215 End.
							out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td class=gridData nowrap>&nbsp;"+count++ +"&nbsp;"+c4cStatuDisplay+"</td><td class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td><td class=gridData nowrap>");
							
							int qms_call_cnt = rsPatList.getInt("QMS_CALL_COUNT"); // added for CRF 192 - IN030532 - Start
							String callRecall="Call.png";
							String mouseOver="Call Patient";
							if(qms_call_cnt >=1)
							{
								callRecall="Recall.png";
								mouseOver="Recall Patient";
								qms_call_cnt=(qms_call_cnt-1)<=0?0:(qms_call_cnt-1);
								qms_call_counter=String.valueOf(qms_call_cnt);
							}else{
								qms_call_counter="";
							}	
							
							if(isQMSapplicable && locn_type.equals("OP")){	
								if(qms_interfaced_yn.equals("Y") && !encounterID.equals("0") && !p_queue_status.equals("01") && !"&nbsp;".equals((String)rsPatList.getString("QUEUE_NUM")))
								{
									out.println("<td class=gridData nowrap><img style='cursor:pointer;' src='../../eCommon/images/"+callRecall+"' alt='"+mouseOver+"' onclick=\"callPatient('"+p_patient_id+"','"+encounterID+"','"+queueNumber+"');\" >&nbsp;<FONT size=1>"+qms_call_counter+"</td> ");//IN000000
								}else{
									out.println(" <td class = gridData nowrap>&nbsp;</td>");//IN000000
								}
							} 	// 	CRF 192 - IN030532 - End
							
							if(link_allowed_yn.equals("Y")){
								out.println("<td class=gridData nowrap><a class='gridLink' href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN000000
							}else{
								out.println("<td class=gridData nowrap><font color="+decesedColor+">"+patName);
							}
							//37866 Start.
							if(isVirtualConsSiteSpec && "OP".equals(locationType) && ("Y".equals(rsPatList.getString("virtualApptYN")))){
								out.println("<td id='rtct"+i+"' class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
							}else if(isVirtualConsSiteSpec && "OP".equals(locationType)){ 	
								out.println("<td id='rtct"+i+"' class='gridData' nowrap>&nbsp;</td>");
							}
							//37866 End.
							out.println("</font></td><td class=gridData nowrap>"+ rsPatList.getString("patient_id")+"</td><td class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td class=gridData nowrap>"+sex+"</td><td class=gridData nowrap>"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</td>");
							out.println("<td class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td class=gridData nowrap colspan='2'>"+queue_status+"</td>");
							out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td><td class=gridData nowrap>"+disp_cls_cons_date+"</td><td class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>"); // modified for CRF-025
							
							if(rsPatList.getString("referral_id")!= null){
							out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}else{
							out.println("<td class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}
						}
						else if(rsPatList.getString("episode_type").equals("I"))
						{
							if("Y".equals(rsPatList.getString("PEND_DISC_SUM_YN"))){ //ML-MMOH-CRF-0356 [IN057193] 
								pendDisSummColor = "'color:red;'";
								pendDisSummtTip = "alt ='Discharge Summary is not done' title= 'Discharge Summary is not done'";
							}else{ 
								pendDisSummColor = "'color:black;'";
								pendDisSummtTip = "";
							} //ML-MMOH-CRF-0356 [IN057193]
							layer = new StringBuffer();
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("patient_id"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									apgar_score=rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale)+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td>"+
									"<td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}
							}
							if(rsMotherLink!=null)rsMotherLink.close();
							if(stmtMotherLink!=null) stmtMotherLink.close();
							if(inpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
								
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block174Bytes, _wl_block174);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);

								i++;
								inpHeader=true;
							}
							if(!currLocn.equals(rsPatList.getString("LOCN_NAME"))){
								out.println("<tr><td colspan='16' class='CAGROUP' ><font size='1'><B>"+rsPatList.getString("LOCN_NAME")+"/Ward"+"</td></tr></font>");
								i++;
								currLocn=rsPatList.getString("LOCN_NAME");
							}
							out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
							//IN044157 - Start		
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							//IN044157 - End
							out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</td><td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class=gridData nowrap colspan='3'>");
							if(link_allowed_yn.equals("Y")){
								out.println("<a class='gridLink' href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN032928
							}else{
								out.println("<font color="+decesedColor+">"+patName);
							}

								out.println("</font></td><td class=gridData nowrap>"+ rsPatList.getString("patient_id")+"</td><td class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td class=gridData nowrap>"+sex+"</td><td class=gridData nowrap>"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" :  rsPatList.getString("PHYSICIAN_NAME"))+"</td>");
								out.println("<td class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td class=gridData nowrap style="+pendDisSummColor+pendDisSummtTip+">"+queue_status+"</td><td class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a></td>");
								out.println("<td class=gridData nowrap>"+rsPatList.getString("BED_NUM")+"</td><td class=gridData nowrap>"+rsPatList.getString("ROOM_NUM")+"</td><td class=gridData nowrap>"+disp_cls_cons_date+"</td><td class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>");
								//IN064342 start
								if(rsPatList.getString("referral_id")!= null)
								{
									if("N".equals(pre_dis_advc_prep_site_YN)){
										out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
									}else{
										out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
									}
								}else{	
									if("N".equals(pre_dis_advc_prep_site_YN)){
										out.println("<td class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
									}else{
										out.println("<td class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
									}
								}
								if("Y".equals(pre_dis_advc_prep_site_YN)){
									if("Y".equals(rsPatList.getString("pre_disg_advice_YN"))){
										out.println("<td class=gridData nowrap>");
										
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block178Bytes, _wl_block178);

										out.println("</td></tr>");
									}else{
										out.println("<td class=gridData nowrap>");
										
            _bw.write(_wl_block177Bytes, _wl_block177);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);

										out.println("</td></tr>");
									}
								}
								//IN064342 ends
						}
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for IN072994
						out.println("</script>");
						i++;
						k++;
						prevcompstring = currcompstring;
						link_allowed_yn="Y";
					}
				}
				if(rsPatList!=null) rsPatList.close();
			
			}catch(Exception e3){
				e3.printStackTrace();
			}
		}else if(groupByEpisode.equals("Y") && groupByLocn.equals("Y")){
			try{
				boolean outpHeader=false;
				boolean inpHeader=false;
				String currLocn="";
				String currcompstring = "";
				String prevcompstring = "`";		
				String status = null;
				String currpract = null;
				String currvisitdate = null;
				String emergencyYn = null;   
				String deceasedYn = null;   
				String relationYn = null;
				String className = null;
				String className1 = null;
				String text = null;											   
				String disp_cls_cons_date =null;										   
				StringTokenizer st = null;
				String n = null;
				String datedisplay = null;
				String practScheduled= null;
				String tempDischargeDate = "";
				//boolean header = false;
				String p_queue_status = null; //added for CRF 192 - IN030532
				qms_interfaced_yn = eOP.QMSInterface.isClinicQMSInterfaced(locn_code,facility_id,con); // added for CRF 192 - IN030532
				String pendDisSummColor = "#000000", pendDisSummtTip = ""; //ML-MMOH-CRF-0356 [IN057193] 
				String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="";//Added for IN072994
				int count= 1;//22856- ML-MMOH-CRF-1778
				while(rsPatList.next()){
					patName="";//IN067111
					res_pat_rec_count  = rsPatList.getInt("RES_STUDIES_CNT"); //CRF-025	- IN030466
					if(res_pat_rec_count > 0){
						pi_clinical_stud_gif = "<img src='../../eCA/images/PI_ClinicalStudies.gif'/>";
					}else{
						pi_clinical_stud_gif = "";
					}
					
					p_queue_status = rsPatList.getString("queue_status");
					
					flag=false;
					if (k % 2 == 0 )
					   rowclass = "gridData";
					else
					   rowclass = "gridData";
					 
					if(locn_type.equals("RP")){
						if( iterate <=end){
							iterate++ ;
							String patient_status="";
							String title ="";
							String dateofbirth1  ="";						
							flag = false;				
							if(header == false)
							{
							
            _bw.write(_wl_block180Bytes, _wl_block180);
            {java.lang.String __page ="../../eCA/jsp/PatListByLocationResultHeader01.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block181Bytes, _wl_block181);

								header = true;
								i++;
							}
							rowclass = "gridData";				
							emergencyYn = "";
							deceasedYn = "";
							int noofchildren = 0;
							relationYn = "";
							className = rowclass;
							className1 = rowclass;
							text = "&nbsp;&nbsp;&nbsp;";
							disp_cls_cons_date = "&nbsp;";

							patient_status	= rsPatList.getString("patient_status") == null ? "" : rsPatList.getString("patient_status");
							episode_type_desc = rsPatList.getString("PATIENT_CLASS")==null?"":rsPatList.getString("PATIENT_CLASS");
							sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
							status = rsPatList.getString("STATUS") == null ? "" : rsPatList.getString("STATUS");
							bedside_ref_review_status = rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS") == null ? "" : rsPatList.getString("BEDSIDE_REF_REVIEW_STATUS"); // added for IN048463
							patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
							
							episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
							//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994

							//IN064836 start
							if("U".equals(sex))
								sex = "Unknown";
							//IN064836 ends					
							sex  = bean.getLabel(pageContext,sex);
							
							status  = bean.getLabel(pageContext,status);
							// added for IN048463 - Start
							if(allow_muti_bedside_review_yn.equals("Y")){
								if(bedside_ref_review_status.equals("P"))
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
							if(rsPatList.getString("unAssigned_yn").equals("N"))
								title = "Speciality Specific Patient (Unassigned)";
							else
								title = "";
								
							st = new StringTokenizer(patient_status,"|");
			
							while (st.hasMoreTokens()){
								emergencyYn = st.nextToken();
								deceasedYn = st.nextToken();
								n = st.nextToken();
								if(!(n == null || n.equals("")))
									noofchildren = Integer.parseInt(n);
								relationYn = st.nextToken();
							}

							if(!( rsPatList.getString("DISCHARGE_DATE_TIME") == null))
								if( !rsPatList.getString("DISCHARGE_DATE_TIME").equals(""))
									className = "DISCHARGED";
							if(deceasedYn.equals("D")){
								className = "CADECEASED";
								rowclass = "DECEASED1";
								decesedColor = "";
							}else if(deceasedYn.equals("S")){
								rowclass = "GRAY";
								decesedColor = "";
							}else{
								decesedColor = "";
							}
							if(noofchildren > 0) 
								className = "NEWBORN";
							emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
							//IN044157 - Start
							if(!emergencyYn.equals(""))
								className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
							//IN044157 - End
							if(relnreqyn.equals("Y")){
								if(relationYn.equals("N"))
									text = "<font size=2><b>*</b></font>";
							}
							if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC")){
								layer = new StringBuffer();
								
								if(noofchildren > 0){
									stmtMotherLink.setString(1,locale);
									stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
									stmtMotherLink.setString(3,facility_id);
									stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
									rsMotherLink = stmtMotherLink.executeQuery();
									while(rsMotherLink.next()){
										if(locale.equals("en")){
										  dateofbirth1=rsMotherLink.getString("date_of_birth");
										}else{
										  dateofbirth1=com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale);
									   }
										apgar_score = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
										layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td>");
										layer.append("<td class=ORPANEL><font size=1>" +dateofbirth1+ "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td>");
										layer.append("<td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
									}
									if(rsMotherLink!=null) rsMotherLink.close();
								}
							}
							out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn2').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
							out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
							out.println("<tr><td class='"+className1+"' width='5%'>&nbsp;&nbsp;&nbsp;</td><td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' width='5%' class='"+className+"'><b>"+text+"</td>");
							
							 restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
							String  practitioner_id = rsPatList.getString("TO_PRACT_ID");//32902
							accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
							
							if(rsPatList.getString("open_chart_yn").equals("Y") && !episode_type_desc.equals("") ){
								out.println("<td onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID")+"\",this,\""+noofchildren+"\")' class='"+rowclass+"' title='"+title+"' nowrap onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font size=1><a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a></font></td>");//IN032928
							}else{
								out.println("<td class='"+rowclass+"' nowrap><font size=1>"+patName+"</font></td>");
							}
							out.println("<td class='"+rowclass+"' nowrap><font size=1><a href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")' ><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id"))+"</font></a></font></td><td class='"+rowclass+"' nowrap><font size=1>"+rsPatList.getString("AGE")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+sex+"</font></td>");
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+ rsPatList.getString("patient_id")+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+status+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("visit_adm_date"),"DMYHM","en",locale)+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("DISCHARGE_DATE_TIME")==null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME"))+"</font></td>");
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("ROOM_NO")==null?"&nbsp;":rsPatList.getString("ROOM_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("BED_NO")==null?"&nbsp;":rsPatList.getString("BED_NO"))+"</font></td><td class='"+rowclass+"' nowrap><font size=1><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif +"</a></font></td>");
							out.println("<td class='"+rowclass+"' nowrap><font size=1>"+(rsPatList.getString("attend_pract_name")== null ? "&nbsp;" : rsPatList.getString("attend_pract_name")) +"</font></td>");// modifid above for CRF-025 IN030466
							if(allow_muti_bedside_review_yn.equals("N")){ // added for IN048463
								if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y")){
									if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
										out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
					
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);

										out.println("</a></font></td>");
									}//IN064836 start
									else
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
								}else if(!referralRegister || "Unassigned".equals(status)){
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
								}else{
									out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
				
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

									out.println("</a></font></td>");
								}
								//IN064836 ends
							} // added for IN048463 - Start
							else{ 
								if(rsPatList.getString("confirm_yn").equals("Y") && rsPatList.getString("unAssigned_yn").equals("Y") && (bedside_ref_review_status.equals("P") || bedside_ref_review_status.equals(""))){
									if(rsPatList.getString("to_pract_id").equals(clinicianId)){//IN048704
										out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:getConfirm('"+i+"');\">");
					
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);

										out.println("</a></font></td>");
									}
									//IN064836 start
									else
									out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
								}else if(!referralRegister || "Unassigned".equals(status)){
								out.println("<td class='"+rowclass+"' nowrap>&nbsp;</td>");
								}else{
									out.println("<td class='"+rowclass+"' nowrap><font size=1><a href=\"javascript:ReferralRegAuditTrial('"+i+"')\" class='gridLink'>");
				
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

									out.println("</a></font></td>");
								}
								//IN064836 ends
							} // added for IN048463 - End
							out.println("<script language='javascript'>");
							out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
							out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
							out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added forIN072994
						    out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						    out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added forIN072994
							out.println("</script>");
			
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("patient_id")));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("referral_id")));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("ASSIGN_CARE_LOCN_CODE")));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("ATTEND_PRACTITIONER_ID")));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("sex")));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("unAssigned_yn")));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block190Bytes, _wl_block190);

							i++;
							k++;
						}
					}else{					
						status			= rsPatList.getString("status")==null?"":rsPatList.getString("status");

						queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
						visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
						episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
						sex = rsPatList.getString("sex")==null?"":rsPatList.getString("sex");
						//Adding start IN072994
						if(bar_code_site_yn.equals("Y")){
								ArrayList scanCountSetup    = bean.getScanCountReqForPatientClass(episode_type_desc,"PATIENT_LIST_BY_LOCATION");
								if(scanCountSetup.size()>0){
								    scan_count_required_yn = (String)scanCountSetup.get(0);
								    alert_required_yn      = (String)scanCountSetup.get(1);
								    remarks_required_yn    = (String)scanCountSetup.get(2);
								}
						}//Adding end IN072994


						patName=rsPatList.getString("PATIENT_NAME")==null?"":rsPatList.getString("PATIENT_NAME");
						rsPatList.getString("patient_id");
					
						if(episode_type_desc.equals("IP")){
							if(patName.equals("X")){
								continue;
							}else if(patName.indexOf("|")!=-1){

								patName = patName.substring(patName.indexOf("|")+1);
								link_allowed_yn="N";
							}
						}
						
						queue_status  = bean.getLabelTxt(pageContext, episode_type_desc, queue_status, visit_episode_status); //Code changed to reduce number of code line
						
						episode_type_desc  = bean.getLabel(pageContext,episode_type_desc);
						
						if(sex.equals("M") || sex.equals("Male") )
							sex ="M";
						else if(sex.equals("F") || sex.equals("Female"))
							sex ="F";
						else if(sex.equals("U") || sex.equals("Unknown"))
							sex ="U";

						currpract = rsPatList.getString("ACTUAL_PHYSICIAN_ID")==null?"":rsPatList.getString("ACTUAL_PHYSICIAN_ID");
						currvisitdate = rsPatList.getString("visit_date")==null?"":rsPatList.getString("visit_date");
						emergencyYn = "";
						deceasedYn = "";
						int noofchildren = 0;
						relationYn = "";
						className = rowclass;
						className1 = rowclass;
						text = "&nbsp;&nbsp;&nbsp;";
						disp_cls_cons_date ="&nbsp;";

						st = new StringTokenizer(status,"|");
						while (st.hasMoreTokens()){
							emergencyYn = st.nextToken();
							deceasedYn = st.nextToken();
							n = st.nextToken();
							if(!(n == null || n.equals("")))
								noofchildren = Integer.parseInt(n);
							relationYn = st.nextToken();
						}
						tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");

						if(deceasedYn.equals("D")){
							className="CADECEASED";
							rowclass = "DECEASED1";
							decesedColor="";
						}else if(deceasedYn.equals("S")){
							rowclass = "GRAY";
							decesedColor="";
						}else{
							decesedColor="";
						}
						if (!deceasedYn.equals("D")){	
							if(!tempDischargeDate.equals("")) className = "DISCHARGED";
							else if((noofchildren > 0)) className = "NEWBORN";
						}
						emergencyYn = rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
						//IN044157 - Start
						if(!emergencyYn.equals(""))
							className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
						//IN044157 - End
						if(relnreqyn.equals("Y")){
							if(relationYn.equals("N"))
								text = "<font size=2><b>*</b></font>";
						}
						// color coding ends
						disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
						if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
							disp_cls_cons_date="&nbsp;";

						if(!disp_cls_cons_date.equals("&nbsp;")){
							disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);
						}else{
							disp_cls_cons_date = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
						}
						
						if(rsPatList.getString("episode_type").equals("O")){ 
							if(outpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
								i++;
								i++;
							}
							datedisplay = rsPatList.getString("adm_visit_date").substring(0,rsPatList.getString("adm_visit_date").indexOf(" "));
							if(datedisplay.equals(Sdate)) 
								datedisplay = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.CurrentQueue.label","ca_labels");
							if(unscheduledyn.equals("Y") && past.equals("N")){
								practScheduled= "Unassigned";
								if(currpract.equals("")){
									practScheduled = "Unassigned";
								}else {
									practScheduled = "Assigned";
								}
								currcompstring = rsPatList.getString("LOCN_NAME")+practScheduled;						
							}else if(unscheduledyn.equals("N") && past.equals("Y")){
								currcompstring = rsPatList.getString("LOCN_NAME")+currvisitdate;
							}else if(unscheduledyn.equals("Y") && past.equals("Y")){
								practScheduled= "Unassigned";
								if(currpract.equals(""))    
									practScheduled = "Unassigned";
								else
									practScheduled = "Assigned";
								currcompstring = rsPatList.getString("LOCN_NAME")+practScheduled+currvisitdate;
							}else{
								currcompstring = rsPatList.getString("LOCN_NAME");
							}
							if(!currcompstring.equals(prevcompstring)){
								i++;
							}

							encounterID = rsPatList.getString("EPISODE_ID");
							patientClass = rsPatList.getString("patient_class");
							queueDesc="&nbsp;";
							if(patientClass.equals("EM")){
								
									queueNumber = bean.getQueueDesc(con,facility_id,encounterID);
								
							}else{
							//IN042191 starts
									q_num =rsPatList.getString("QUEUE_NUM")==null?"":rsPatList.getString("QUEUE_NUM");
							
								if(q_num.equals("0")) queueNumber = "&nbsp;";						
								else queueNumber = rsPatList.getString("QUEUE_NUM");
							}					
							//[IN030291] Start
							//IN044157 - Start		
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							//IN044157 - End
							//51215 Start.
							c4cStatuDisplay="";
							if(isVirtualConsSDGSpec && "OP".equals(locationType)  && ("Y".equals(rsPatList.getString("C4C_STATUS_DISPLAY")))){
								c4cStatuDisplay="<img src='../../eCA/images/bellIcon.png' alt='Patient Waiting for Virtual Consultation'/>";
							}
							//51215 End.
							out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>&nbsp;"+count++ +"&nbsp;"+c4cStatuDisplay+"</td><td id='rta"+i+"' class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td id='rtb"+i+"' class=gridData nowrap>"+queueNumber+"</td>");//22856 -ML-MMOH-CRF-1778
							//out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td id='rta"+i+"' class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td id='rtb"+i+"' class=gridData nowrap>"+queueNumber+"</td>");
							String  p_patient_id=rsPatList.getString("patient_id"); // modified for CRF 192 - IN030532 -Start
							// added for CRF 192
							int qms_call_cnt = rsPatList.getInt("QMS_CALL_COUNT");
							
							String callRecall="Call.png";
							String mouseOver="Call Patient";
							if(qms_call_cnt >=1){
								callRecall="Recall.png";
								mouseOver="Recall Patient";
								qms_call_cnt=(qms_call_cnt-1)<=0?0:(qms_call_cnt-1);
								qms_call_counter=String.valueOf(qms_call_cnt);
							}else{
								qms_call_counter="";
							}				 
						
							if(isQMSapplicable && locn_type.equals("OP")){	
								if(qms_interfaced_yn.equals("Y") && !encounterID.equals("0") && !p_queue_status.equals("01") && !"&nbsp;".equals((String)rsPatList.getString("QUEUE_NUM"))){	
									out.println("<td id='rtp"+i+"' class=gridData nowrap><img style='cursor:pointer; 'src='../../eCommon/images/"+callRecall+"' alt='"+mouseOver+"' onclick=\"callPatient('"+p_patient_id+"','"+encounterID+"','"+queueNumber+"');\" >&nbsp;<FONT size=1>"+qms_call_counter+"</td> ");
								}else{
									out.println(" <td id='rtp"+i+"' class = gridData nowrap>&nbsp;</td> ");
								}
							}	// END CRF 192 - IN030532
							String isInpatient = patdata.CheckInPatient(con,p_patient_id,facility_id);
							if(isInpatient.equals("CURRENTLY_IN_PATIENT")) {
								out.println("<td id='rtc"+i+"' class=gridData nowrap><img align='center'  src='../../eCommon/images/inpatient.gif' alt=''></img></td>");
							}else{
								out.println("<td id='rtc"+i+"' class=gridData nowrap>&nbsp;</td>");
							}
							out.println("<td id='rtd"+i+"' class=gridData nowrap>");
							//[IN030291] End
						  restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
						accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902


							if(link_allowed_yn.equals("Y")){
								out.println("<a class='gridLink' href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">"+patName+"</a>");//IN032928
							}else{
								out.println("<font color="+decesedColor+">"+patName);
							}
							//37866 Start.
							if(isVirtualConsSiteSpec && "OP".equals(locationType) && ("Y".equals(rsPatList.getString("virtualApptYN")))){
								out.println("<td id='rtct"+i+"' class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
							}else if(isVirtualConsSiteSpec && "OP".equals(locationType)){ 	
								out.println("<td id='rtct"+i+"' class='gridData'width=100 nowrap>&nbsp;</td>");
							}
							//37866 End.
							out.println("</font></td><td id='rte"+i+"' class=gridData nowrap>"+ rsPatList.getString("patient_id")+"</td><td id='rtf"+i+"' class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td id='rtg"+i+"' class=gridData nowrap>"+sex+"</td><td id='rth"+i+"' class=gridData nowrap style='width=150px;color:blue;cursor:pointer'><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</a></td>");
							out.println("<td id='rti"+i+"'  class=gridData nowrap style='color:blue;cursor:pointer'><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>&nbsp;&nbsp;"+rsPatList.getString("SPLTY_NAME")+"</a></td>");//Changes suggested by sunil
							if(locationType.equals("OP")){
							out.println("<td id='rtq"+i+"' class=gridData nowrap>&nbsp;&nbsp"+rsPatList.getString("visit_type")+"</td>");
							}
							out.println("<td id='rtj"+i+"' class=gridData nowrap>&nbsp;&nbsp;"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td id='rtk"+i+"' class=gridData nowrap colspan='2'>&nbsp;&nbsp;"+queue_status+"</td><td id='rtl"+i+"' class=gridData nowrap style='width=100px;color:white'><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td id='rtm"+i+"' class=gridData nowrap>&nbsp;&nbsp;"+disp_cls_cons_date+"</td><td id='rtn"+i+"' class=gridData nowrap>&nbsp;&nbsp;"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>");
							if(rsPatList.getString("referral_id")!= null){
								out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">&nbsp;&nbsp;&nbsp"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}else{
								out.println("<td id='rto"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">&nbsp;&nbsp;"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
							}
							//32902 start
							
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(i));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("physician_id")));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block196Bytes, _wl_block196);

						//32902 end

						}else if(rsPatList.getString("episode_type").equals("I")){ 
							
							if("Y".equals(rsPatList.getString("PEND_DISC_SUM_YN"))){ //ML-MMOH-CRF-0356 [IN057193] 
								pendDisSummColor = "'color:red;'";
								pendDisSummtTip = "alt ='Discharge Summary is not done' title= 'Discharge Summary is not done'";
							}else{ 
								pendDisSummColor = "'color:black;'";
								pendDisSummtTip = "";
							} //ML-MMOH-CRF-0356 [IN057193]
							layer = new StringBuffer();
							if(noofchildren > 0){
								stmtMotherLink.setString(1,locale);
								stmtMotherLink.setString(2,rsPatList.getString("patient_id"));
								stmtMotherLink.setString(3,facility_id);
								stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
								rsMotherLink = stmtMotherLink.executeQuery();
								while(rsMotherLink.next()){
									apgar_score=rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;": rsMotherLink.getString("APGAR_SCORE");
									layer.append("<tr><td class=ORPANEL><font size=1>" + rsMotherLink.getString("pat_id") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("short_name") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("sex") + "</font></td><td class=ORPANEL><font size=1>" + com.ehis.util.DateUtils.convertDate(rsMotherLink.getString("date_of_birth"),"DMY","en",locale)+ "</font></td>");
									layer.append("<td class=ORPANEL><font size=1>" + rsMotherLink.getString("TIME_OF_BIRTH") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("LENGTH_OF_BABY") + "</font></td><td class=ORPANEL><font size=1>" + rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD") + "</font></td><td class=ORPANEL><font size=1>"+apgar_score+"</font></td></tr>");
								}
								
							}					
							if(inpHeader==false){
								out.println("<script language='javascript'>if(top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn')){ top.content.workAreaFrame.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+ "</b>'}</script>");
								i++;
								i++;
							}
							if(!currLocn.equals(rsPatList.getString("LOCN_NAME"))) {
								i++;
								currLocn=rsPatList.getString("LOCN_NAME");
							}
							out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]=\""+patName+"\";</script>");
							//IN044157 - Start		
							out.println("<tr>");
							if(!emergencyYn.equals(""))
								out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
							else
								out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
							//IN044157 - End
							out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID") +"\",this,\""+noofchildren+"\")' width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>&nbsp;"+ count++ +"</td><td id='rta"+i+"' class=gridData nowrap colspan='3' onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID") +"\",this,\""+noofchildren+"\")'>");//CRF-1778
							//out.println("<td onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID") +"\",this,\""+noofchildren+"\")' width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td id='rta"+i+"' class=gridData nowrap colspan='3' onMouseOut='clearLayer()' onMouseOver='showMotherLinks(\""+rsPatList.getString("EPISODE_ID") +"\",this,\""+noofchildren+"\")'>");
							
							restPatientYN = rsPatList.getString("restrict_reinstate_yn");//32902
							String  practitioner_id = rsPatList.getString("physician_id");//32902
							accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902


							if(link_allowed_yn.equals("Y")){
								out.println("<a href=\"javascript:patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"'),patClick_('"+i+"')\" onkeydown=\"javascript:if(event.keyCode == 13)patClick_new('"+i+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_id")+"')\"><font color="+decesedColor+">&nbsp;&nbsp"+patName+"</a>");//IN032928
							}else{
								out.println("<font color="+decesedColor+">"+patName);
							}
							out.println("</font></td><td id='rtb"+i+"' class=gridData nowrap>&nbsp;&nbsp"+ rsPatList.getString("patient_id")+"</td><td id='rtc"+i+"' class=gridData nowrap>&nbsp;&nbsp"+rsPatList.getString("AGE")+"</td><td id='rtd"+i+"' class=gridData nowrap>&nbsp;&nbsp"+sex+"</td><td id='rte"+i+"' class=gridData nowrap>&nbsp;&nbsp"+rsPatList.getString("BED_NUM")+"</td>");
							out.println("<td id='rtf"+i+"' class=gridData nowrap style='color:blue;cursor:pointer'><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>&nbsp;&nbsp"+rsPatList.getString("ROOM_NUM")+"</a></td>");
							out.println("<td id='rtg"+i+"' class=gridData nowrap style='color:blue;cursor:pointer'><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>&nbsp;&nbsp"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</a></td>");
							out.println("<td id='rth"+i+"' class=gridData nowrap style='color:blue;cursor:pointer'><a href='javascript:patClick_new(\""+i+"\",\""+rsPatList.getString("patient_id")+"\",\""+rsPatList.getString("episode_id")+"\"),patClick_(\""+i+"\")'>&nbsp;&nbsp"+rsPatList.getString("SPLTY_NAME")+"</a></td><td id='rti"+i+"' class=gridData nowrap>&nbsp;&nbsp"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td>");
							out.println("<td id='rtj"+i+"' class=gridData nowrap style="+pendDisSummColor+pendDisSummtTip+">&nbsp;&nbsp"+queue_status+"</td><td id='rtk"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:researchPatient(\""+rsPatList.getString("patient_id")+"\")'>"+pi_clinical_stud_gif+"</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td id='rtl"+i+"' class=gridData nowrap>&nbsp;&nbsp"+disp_cls_cons_date+"</td>");
							out.println("<td id='rtm"+i+"' class=gridData nowrap>&nbsp;&nbsp"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale)+"</td>");
							//IN064342 start
						     // 32902 start
							
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(i));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(i));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(rsPatList.getString("physician_id")));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block201Bytes, _wl_block201);

						     // 32902 end

							if(rsPatList.getString("referral_id")!= null){
								if("N".equals(pre_dis_advc_prep_site_YN)){
									out.println("<td id='rtn"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
								}else{
									out.println("<td id='rtn"+i+"' class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
								}
							}else{
								if("N".equals(pre_dis_advc_prep_site_YN)){
									out.println("<td  id='rtn"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
								}
								else{
									out.println("<td  id='rtn"+i+"' class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td>");
								}
							}
							if("Y".equals(pre_dis_advc_prep_site_YN)){
								if("Y".equals(rsPatList.getString("pre_disg_advice_YN"))){
									out.println("<td class=gridData nowrap>");
									
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block202Bytes, _wl_block202);

									out.println("</td></tr>");
								}else{
									out.println("<td class=gridData width='1px' nowrap>");
									
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

									out.println("</td></tr>");
								}
							}
							//IN064342 ends
						}
						out.println("<script language='javascript'>");
						out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
						out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");
						out.println("scan_count_required_yn["+i+"]='"+scan_count_required_yn+"';");//Added for IN072994
						out.println("alert_required_yn["+i+"]='"+alert_required_yn+"';");//Added for IN072994
						out.println("remarks_required_yn["+i+"]='"+remarks_required_yn+"';");//Added for IN072994
						out.println("</script>");
						
						i++;
						k++;
						prevcompstring = currcompstring;
						link_allowed_yn="Y";
					}
				}
				if(rsPatList!=null) rsPatList.close();
				if(rsMotherLink!=null) rsMotherLink.close();	
				if(stmtMotherLink!=null) stmtMotherLink.close();			
				if(locn_type.equals("RP")){
	
            _bw.write(_wl_block203Bytes, _wl_block203);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block209Bytes, _wl_block209);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block208Bytes, _wl_block208);

            if (_jsp__tag119(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block210Bytes, _wl_block210);

            if (_jsp__tag120(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);

            if (_jsp__tag121(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag122(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag123(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);

            if (_jsp__tag124(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag125(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);

            if (_jsp__tag126(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag127(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block218Bytes, _wl_block218);

            if (_jsp__tag128(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block219Bytes, _wl_block219);

            if (_jsp__tag129(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block220Bytes, _wl_block220);

            if (_jsp__tag130(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag131(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag132(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);

            if (_jsp__tag133(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);

				}			
				if(isIP){
					
            _bw.write(_wl_block225Bytes, _wl_block225);

            if (_jsp__tag134(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block226Bytes, _wl_block226);

            if (_jsp__tag135(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block227Bytes, _wl_block227);

            if (_jsp__tag136(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block228Bytes, _wl_block228);

            if (_jsp__tag137(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag138(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);

            if (_jsp__tag139(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block231Bytes, _wl_block231);

            if (_jsp__tag140(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);

            if (_jsp__tag141(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);

            if (_jsp__tag142(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);

            if (_jsp__tag143(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block235Bytes, _wl_block235);

            if (_jsp__tag144(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block236Bytes, _wl_block236);

            if (_jsp__tag145(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag146(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block238Bytes, _wl_block238);

            if (_jsp__tag147(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block239Bytes, _wl_block239);

            if (_jsp__tag148(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block240Bytes, _wl_block240);

            if (_jsp__tag149(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block241Bytes, _wl_block241);

            if (_jsp__tag150(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag151(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);

						//IN064342 start
						if("Y".equals(pre_dis_advc_prep_site_YN))
						{
					
            _bw.write(_wl_block244Bytes, _wl_block244);

            if (_jsp__tag152(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block245Bytes, _wl_block245);

						}
						//IN064342 end
					
            _bw.write(_wl_block246Bytes, _wl_block246);

					inpHeader=true;
				}
				if(isOP)
				{
					
            _bw.write(_wl_block247Bytes, _wl_block247);

            if (_jsp__tag153(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag154(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(queueValue));
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag155(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block251Bytes, _wl_block251);

            if (_jsp__tag156(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block252Bytes, _wl_block252);

            if (_jsp__tag157(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block253Bytes, _wl_block253);

            if (_jsp__tag158(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block254Bytes, _wl_block254);

            if (_jsp__tag159(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block255Bytes, _wl_block255);

            if (_jsp__tag160(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block256Bytes, _wl_block256);

            if (_jsp__tag161(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(queueValue));
            _bw.write(_wl_block77Bytes, _wl_block77);
 if((isQMSapplicable) && locn_type.equals("OP")) // added for [IN030532]
							{ 
							
            _bw.write(_wl_block258Bytes, _wl_block258);

            if (_jsp__tag162(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block259Bytes, _wl_block259);

							}
							
            _bw.write(_wl_block260Bytes, _wl_block260);

            if (_jsp__tag163(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block261Bytes, _wl_block261);

            if (_jsp__tag164(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

							//37866 Start.
							if(isVirtualConsSiteSpec  &&  "OP".equals(locationType)){
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ConsultationType.label","ca_labels")));
            _bw.write(_wl_block77Bytes, _wl_block77);
}
							//37866 End.
							
            _bw.write(_wl_block263Bytes, _wl_block263);

            if (_jsp__tag165(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block264Bytes, _wl_block264);

            if (_jsp__tag166(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag167(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block266Bytes, _wl_block266);

            if (_jsp__tag168(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block267Bytes, _wl_block267);

            if (_jsp__tag169(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block268Bytes, _wl_block268);
if( "OP".equals(locationType)){
            _bw.write(_wl_block269Bytes, _wl_block269);

            if (_jsp__tag170(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block270Bytes, _wl_block270);
}
            _bw.write(_wl_block271Bytes, _wl_block271);

            if (_jsp__tag171(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block272Bytes, _wl_block272);

            if (_jsp__tag172(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block273Bytes, _wl_block273);

            if (_jsp__tag173(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block274Bytes, _wl_block274);

            if (_jsp__tag174(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block275Bytes, _wl_block275);

            if (_jsp__tag175(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block276Bytes, _wl_block276);

            if (_jsp__tag176(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block277Bytes, _wl_block277);

            if (_jsp__tag177(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block278Bytes, _wl_block278);

					outpHeader=true;
				}
			
			}catch(Exception e4){
				e4.printStackTrace();
			}
		}
		if(rsMotherLink!=null) rsMotherLink.close();
		if(stmtMotherLink != null ) stmtMotherLink.close();
		if(rsPatList!=null) rsPatList.close();
		if(stmtPatList!=null) stmtPatList.close();

		if(flag){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script>top.content.workAreaFrame.PatResultFr.LocnResultTitle.location.href='../../eCommon/html/blank.html'</script>");
			out.println("<script>top.content.workAreaFrame.PatResultFr.LocnResult.location.href='../../eCommon/html/blank.html'</script>");
		}
		putObjectInBean(bean_id,bean,session);		
	}
	catch(Exception e){
		e.printStackTrace();	
	}
	finally{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(request.getParameter("function_id")));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(pre_dis_advc_prep_site_YN));
            _bw.write(_wl_block281Bytes, _wl_block281);

		if(floatTitle){
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block284Bytes, _wl_block284);

	}
	if(!anchorID.equals("")){
		
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block293Bytes, _wl_block293);
}
            _bw.write(_wl_block294Bytes, _wl_block294);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsultationType.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalService.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitAdmDate.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientClassification.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VisitAdmEndDate.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.appttime.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PreDischargeAdvice.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Prepared.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NotPrepared.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.appttime.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.CallTicket.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsultationType.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDate.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientClassification.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsEndDate.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientClassification.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PreDischargeAdvice.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Prepared.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NotPrepared.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
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
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.appttime.label", java.lang.String .class,"key"));
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
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.CallTicket.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsultationType.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalService.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDate.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }

    private boolean _jsp__tag82(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag82 = null ;
        int __result__tag82 = 0 ;

        if (__tag82 == null ){
            __tag82 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag82);
        }
        __tag82.setPageContext(pageContext);
        __tag82.setParent(null);
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientClassification.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag82;
        __result__tag82 = __tag82.doStartTag();

        if (__result__tag82!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag82== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag82.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag82);
            return true;
        }
        _activeTag=__tag82.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag82);
        __tag82.release();
        return false;
    }

    private boolean _jsp__tag83(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag83 = null ;
        int __result__tag83 = 0 ;

        if (__tag83 == null ){
            __tag83 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag83);
        }
        __tag83.setPageContext(pageContext);
        __tag83.setParent(null);
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsEndDate.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag83;
        __result__tag83 = __tag83.doStartTag();

        if (__result__tag83!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag83== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag83.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag83);
            return true;
        }
        _activeTag=__tag83.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag83);
        __tag83.release();
        return false;
    }

    private boolean _jsp__tag84(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag84 = null ;
        int __result__tag84 = 0 ;

        if (__tag84 == null ){
            __tag84 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag84);
        }
        __tag84.setPageContext(pageContext);
        __tag84.setParent(null);
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag84;
        __result__tag84 = __tag84.doStartTag();

        if (__result__tag84!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag84== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag84.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag84);
            return true;
        }
        _activeTag=__tag84.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag84);
        __tag84.release();
        return false;
    }

    private boolean _jsp__tag85(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag85 = null ;
        int __result__tag85 = 0 ;

        if (__tag85 == null ){
            __tag85 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag85);
        }
        __tag85.setPageContext(pageContext);
        __tag85.setParent(null);
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag85;
        __result__tag85 = __tag85.doStartTag();

        if (__result__tag85!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag85== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag85.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag85);
            return true;
        }
        _activeTag=__tag85.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag85);
        __tag85.release();
        return false;
    }

    private boolean _jsp__tag86(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag86 = null ;
        int __result__tag86 = 0 ;

        if (__tag86 == null ){
            __tag86 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag86);
        }
        __tag86.setPageContext(pageContext);
        __tag86.setParent(null);
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag86;
        __result__tag86 = __tag86.doStartTag();

        if (__result__tag86!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag86== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag86.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag86);
            return true;
        }
        _activeTag=__tag86.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag86);
        __tag86.release();
        return false;
    }

    private boolean _jsp__tag87(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag87 = null ;
        int __result__tag87 = 0 ;

        if (__tag87 == null ){
            __tag87 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag87);
        }
        __tag87.setPageContext(pageContext);
        __tag87.setParent(null);
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag87;
        __result__tag87 = __tag87.doStartTag();

        if (__result__tag87!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag87== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag87.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag87);
            return true;
        }
        _activeTag=__tag87.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag87);
        __tag87.release();
        return false;
    }

    private boolean _jsp__tag88(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag88 = null ;
        int __result__tag88 = 0 ;

        if (__tag88 == null ){
            __tag88 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag88);
        }
        __tag88.setPageContext(pageContext);
        __tag88.setParent(null);
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag88;
        __result__tag88 = __tag88.doStartTag();

        if (__result__tag88!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag88== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag88.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag88);
            return true;
        }
        _activeTag=__tag88.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag88);
        __tag88.release();
        return false;
    }

    private boolean _jsp__tag89(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag89 = null ;
        int __result__tag89 = 0 ;

        if (__tag89 == null ){
            __tag89 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag89);
        }
        __tag89.setPageContext(pageContext);
        __tag89.setParent(null);
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag89;
        __result__tag89 = __tag89.doStartTag();

        if (__result__tag89!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag89== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag89.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag89);
            return true;
        }
        _activeTag=__tag89.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag89);
        __tag89.release();
        return false;
    }

    private boolean _jsp__tag90(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag90 = null ;
        int __result__tag90 = 0 ;

        if (__tag90 == null ){
            __tag90 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag90);
        }
        __tag90.setPageContext(pageContext);
        __tag90.setParent(null);
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag90;
        __result__tag90 = __tag90.doStartTag();

        if (__result__tag90!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag90== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag90.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag90);
            return true;
        }
        _activeTag=__tag90.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag90);
        __tag90.release();
        return false;
    }

    private boolean _jsp__tag91(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag91 = null ;
        int __result__tag91 = 0 ;

        if (__tag91 == null ){
            __tag91 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag91);
        }
        __tag91.setPageContext(pageContext);
        __tag91.setParent(null);
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalService.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag91;
        __result__tag91 = __tag91.doStartTag();

        if (__result__tag91!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag91== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag91.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag91);
            return true;
        }
        _activeTag=__tag91.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag91);
        __tag91.release();
        return false;
    }

    private boolean _jsp__tag92(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag92 = null ;
        int __result__tag92 = 0 ;

        if (__tag92 == null ){
            __tag92 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag92);
        }
        __tag92.setPageContext(pageContext);
        __tag92.setParent(null);
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag92;
        __result__tag92 = __tag92.doStartTag();

        if (__result__tag92!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag92== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag92.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag92);
            return true;
        }
        _activeTag=__tag92.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag92);
        __tag92.release();
        return false;
    }

    private boolean _jsp__tag93(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag93 = null ;
        int __result__tag93 = 0 ;

        if (__tag93 == null ){
            __tag93 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag93);
        }
        __tag93.setPageContext(pageContext);
        __tag93.setParent(null);
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag93;
        __result__tag93 = __tag93.doStartTag();

        if (__result__tag93!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag93== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag93.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag93);
            return true;
        }
        _activeTag=__tag93.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag93);
        __tag93.release();
        return false;
    }

    private boolean _jsp__tag94(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag94 = null ;
        int __result__tag94 = 0 ;

        if (__tag94 == null ){
            __tag94 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag94);
        }
        __tag94.setPageContext(pageContext);
        __tag94.setParent(null);
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag94;
        __result__tag94 = __tag94.doStartTag();

        if (__result__tag94!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag94== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag94.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag94);
            return true;
        }
        _activeTag=__tag94.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag94);
        __tag94.release();
        return false;
    }

    private boolean _jsp__tag95(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag95 = null ;
        int __result__tag95 = 0 ;

        if (__tag95 == null ){
            __tag95 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag95);
        }
        __tag95.setPageContext(pageContext);
        __tag95.setParent(null);
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientClassification.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag95;
        __result__tag95 = __tag95.doStartTag();

        if (__result__tag95!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag95== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag95.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag95);
            return true;
        }
        _activeTag=__tag95.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag95);
        __tag95.release();
        return false;
    }

    private boolean _jsp__tag96(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag96 = null ;
        int __result__tag96 = 0 ;

        if (__tag96 == null ){
            __tag96 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag96);
        }
        __tag96.setPageContext(pageContext);
        __tag96.setParent(null);
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag96;
        __result__tag96 = __tag96.doStartTag();

        if (__result__tag96!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag96== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag96.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag96);
            return true;
        }
        _activeTag=__tag96.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag96);
        __tag96.release();
        return false;
    }

    private boolean _jsp__tag97(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag97 = null ;
        int __result__tag97 = 0 ;

        if (__tag97 == null ){
            __tag97 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag97);
        }
        __tag97.setPageContext(pageContext);
        __tag97.setParent(null);
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag97;
        __result__tag97 = __tag97.doStartTag();

        if (__result__tag97!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag97== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag97.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag97);
            return true;
        }
        _activeTag=__tag97.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag97);
        __tag97.release();
        return false;
    }

    private boolean _jsp__tag98(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag98 = null ;
        int __result__tag98 = 0 ;

        if (__tag98 == null ){
            __tag98 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag98);
        }
        __tag98.setPageContext(pageContext);
        __tag98.setParent(null);
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag98;
        __result__tag98 = __tag98.doStartTag();

        if (__result__tag98!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag98== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag98.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag98);
            return true;
        }
        _activeTag=__tag98.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag98);
        __tag98.release();
        return false;
    }

    private boolean _jsp__tag99(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag99 = null ;
        int __result__tag99 = 0 ;

        if (__tag99 == null ){
            __tag99 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag99);
        }
        __tag99.setPageContext(pageContext);
        __tag99.setParent(null);
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Prepared.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag99;
        __result__tag99 = __tag99.doStartTag();

        if (__result__tag99!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag99== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag99.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag99);
            return true;
        }
        _activeTag=__tag99.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag99);
        __tag99.release();
        return false;
    }

    private boolean _jsp__tag100(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag100 = null ;
        int __result__tag100 = 0 ;

        if (__tag100 == null ){
            __tag100 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag100);
        }
        __tag100.setPageContext(pageContext);
        __tag100.setParent(null);
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NotPrepared.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag100;
        __result__tag100 = __tag100.doStartTag();

        if (__result__tag100!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag100== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag100.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag100);
            return true;
        }
        _activeTag=__tag100.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag100);
        __tag100.release();
        return false;
    }

    private boolean _jsp__tag101(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag101 = null ;
        int __result__tag101 = 0 ;

        if (__tag101 == null ){
            __tag101 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag101);
        }
        __tag101.setPageContext(pageContext);
        __tag101.setParent(null);
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
        __tag101.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag101;
        __result__tag101 = __tag101.doStartTag();

        if (__result__tag101!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag101== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag101.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag101);
            return true;
        }
        _activeTag=__tag101.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag101);
        __tag101.release();
        return false;
    }

    private boolean _jsp__tag102(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag102 = null ;
        int __result__tag102 = 0 ;

        if (__tag102 == null ){
            __tag102 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag102);
        }
        __tag102.setPageContext(pageContext);
        __tag102.setParent(null);
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag102;
        __result__tag102 = __tag102.doStartTag();

        if (__result__tag102!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag102== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag102.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag102);
            return true;
        }
        _activeTag=__tag102.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag102);
        __tag102.release();
        return false;
    }

    private boolean _jsp__tag103(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag103 = null ;
        int __result__tag103 = 0 ;

        if (__tag103 == null ){
            __tag103 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag103);
        }
        __tag103.setPageContext(pageContext);
        __tag103.setParent(null);
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.confirm.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag103;
        __result__tag103 = __tag103.doStartTag();

        if (__result__tag103!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag103== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag103.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag103);
            return true;
        }
        _activeTag=__tag103.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag103);
        __tag103.release();
        return false;
    }

    private boolean _jsp__tag104(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag104 = null ;
        int __result__tag104 = 0 ;

        if (__tag104 == null ){
            __tag104 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag104);
        }
        __tag104.setPageContext(pageContext);
        __tag104.setParent(null);
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ViewAuditTrail.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag104;
        __result__tag104 = __tag104.doStartTag();

        if (__result__tag104!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag104== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag104.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag104);
            return true;
        }
        _activeTag=__tag104.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag104);
        __tag104.release();
        return false;
    }

    private boolean _jsp__tag105(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag105 = null ;
        int __result__tag105 = 0 ;

        if (__tag105 == null ){
            __tag105 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag105);
        }
        __tag105.setPageContext(pageContext);
        __tag105.setParent(null);
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Prepared.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag105;
        __result__tag105 = __tag105.doStartTag();

        if (__result__tag105!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag105== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag105.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag105);
            return true;
        }
        _activeTag=__tag105.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag105);
        __tag105.release();
        return false;
    }

    private boolean _jsp__tag106(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag106 = null ;
        int __result__tag106 = 0 ;

        if (__tag106 == null ){
            __tag106 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag106);
        }
        __tag106.setPageContext(pageContext);
        __tag106.setParent(null);
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.NotPrepared.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag106;
        __result__tag106 = __tag106.doStartTag();

        if (__result__tag106!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag106== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag106.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag106);
            return true;
        }
        _activeTag=__tag106.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag106);
        __tag106.release();
        return false;
    }

    private boolean _jsp__tag107(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag107 = null ;
        int __result__tag107 = 0 ;

        if (__tag107 == null ){
            __tag107 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag107);
        }
        __tag107.setPageContext(pageContext);
        __tag107.setParent(null);
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag107;
        __result__tag107 = __tag107.doStartTag();

        if (__result__tag107!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag107== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag107.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag107);
            return true;
        }
        _activeTag=__tag107.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag107);
        __tag107.release();
        return false;
    }

    private boolean _jsp__tag108(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag108 = null ;
        int __result__tag108 = 0 ;

        if (__tag108 == null ){
            __tag108 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag108);
        }
        __tag108.setPageContext(pageContext);
        __tag108.setParent(null);
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag108;
        __result__tag108 = __tag108.doStartTag();

        if (__result__tag108!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag108== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag108.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag108);
            return true;
        }
        _activeTag=__tag108.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag108);
        __tag108.release();
        return false;
    }

    private boolean _jsp__tag109(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag109 = null ;
        int __result__tag109 = 0 ;

        if (__tag109 == null ){
            __tag109 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag109);
        }
        __tag109.setPageContext(pageContext);
        __tag109.setParent(null);
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag109;
        __result__tag109 = __tag109.doStartTag();

        if (__result__tag109!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag109== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag109.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag109);
            return true;
        }
        _activeTag=__tag109.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag109);
        __tag109.release();
        return false;
    }

    private boolean _jsp__tag110(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag110 = null ;
        int __result__tag110 = 0 ;

        if (__tag110 == null ){
            __tag110 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag110);
        }
        __tag110.setPageContext(pageContext);
        __tag110.setParent(null);
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag110;
        __result__tag110 = __tag110.doStartTag();

        if (__result__tag110!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag110== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag110.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag110);
            return true;
        }
        _activeTag=__tag110.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag110);
        __tag110.release();
        return false;
    }

    private boolean _jsp__tag111(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag111 = null ;
        int __result__tag111 = 0 ;

        if (__tag111 == null ){
            __tag111 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag111);
        }
        __tag111.setPageContext(pageContext);
        __tag111.setParent(null);
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag111.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag111;
        __result__tag111 = __tag111.doStartTag();

        if (__result__tag111!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag111== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag111.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag111);
            return true;
        }
        _activeTag=__tag111.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag111);
        __tag111.release();
        return false;
    }

    private boolean _jsp__tag112(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag112 = null ;
        int __result__tag112 = 0 ;

        if (__tag112 == null ){
            __tag112 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag112);
        }
        __tag112.setPageContext(pageContext);
        __tag112.setParent(null);
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ReferralStatus.label", java.lang.String .class,"key"));
        __tag112.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag112;
        __result__tag112 = __tag112.doStartTag();

        if (__result__tag112!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag112== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag112.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag112);
            return true;
        }
        _activeTag=__tag112.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag112);
        __tag112.release();
        return false;
    }

    private boolean _jsp__tag113(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag113 = null ;
        int __result__tag113 = 0 ;

        if (__tag113 == null ){
            __tag113 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag113);
        }
        __tag113.setPageContext(pageContext);
        __tag113.setParent(null);
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitAdmDate.label", java.lang.String .class,"key"));
        __tag113.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag113;
        __result__tag113 = __tag113.doStartTag();

        if (__result__tag113!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag113== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag113.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag113);
            return true;
        }
        _activeTag=__tag113.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag113);
        __tag113.release();
        return false;
    }

    private boolean _jsp__tag114(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag114 = null ;
        int __result__tag114 = 0 ;

        if (__tag114 == null ){
            __tag114 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag114);
        }
        __tag114.setPageContext(pageContext);
        __tag114.setParent(null);
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VisitAdmEndDate.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag114;
        __result__tag114 = __tag114.doStartTag();

        if (__result__tag114!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag114== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag114.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag114);
            return true;
        }
        _activeTag=__tag114.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag114);
        __tag114.release();
        return false;
    }

    private boolean _jsp__tag115(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag115 = null ;
        int __result__tag115 = 0 ;

        if (__tag115 == null ){
            __tag115 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag115);
        }
        __tag115.setPageContext(pageContext);
        __tag115.setParent(null);
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
        __tag115.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag115;
        __result__tag115 = __tag115.doStartTag();

        if (__result__tag115!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag115== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag115.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag115);
            return true;
        }
        _activeTag=__tag115.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag115);
        __tag115.release();
        return false;
    }

    private boolean _jsp__tag116(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag116 = null ;
        int __result__tag116 = 0 ;

        if (__tag116 == null ){
            __tag116 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag116);
        }
        __tag116.setPageContext(pageContext);
        __tag116.setParent(null);
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag116;
        __result__tag116 = __tag116.doStartTag();

        if (__result__tag116!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag116== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag116.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag116);
            return true;
        }
        _activeTag=__tag116.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag116);
        __tag116.release();
        return false;
    }

    private boolean _jsp__tag117(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag117 = null ;
        int __result__tag117 = 0 ;

        if (__tag117 == null ){
            __tag117 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag117);
        }
        __tag117.setPageContext(pageContext);
        __tag117.setParent(null);
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientClassification.label", java.lang.String .class,"key"));
        __tag117.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag117;
        __result__tag117 = __tag117.doStartTag();

        if (__result__tag117!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag117== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag117.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag117);
            return true;
        }
        _activeTag=__tag117.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag117);
        __tag117.release();
        return false;
    }

    private boolean _jsp__tag118(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag118 = null ;
        int __result__tag118 = 0 ;

        if (__tag118 == null ){
            __tag118 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag118);
        }
        __tag118.setPageContext(pageContext);
        __tag118.setParent(null);
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag118.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag118;
        __result__tag118 = __tag118.doStartTag();

        if (__result__tag118!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag118== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag118.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag118);
            return true;
        }
        _activeTag=__tag118.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag118);
        __tag118.release();
        return false;
    }

    private boolean _jsp__tag119(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag119 = null ;
        int __result__tag119 = 0 ;

        if (__tag119 == null ){
            __tag119 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag119);
        }
        __tag119.setPageContext(pageContext);
        __tag119.setParent(null);
        __tag119.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
        __tag119.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag119;
        __result__tag119 = __tag119.doStartTag();

        if (__result__tag119!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag119== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag119.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag119);
            return true;
        }
        _activeTag=__tag119.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag119);
        __tag119.release();
        return false;
    }

    private boolean _jsp__tag120(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag120 = null ;
        int __result__tag120 = 0 ;

        if (__tag120 == null ){
            __tag120 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag120);
        }
        __tag120.setPageContext(pageContext);
        __tag120.setParent(null);
        __tag120.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag120.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag120;
        __result__tag120 = __tag120.doStartTag();

        if (__result__tag120!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag120== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag120.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag120);
            return true;
        }
        _activeTag=__tag120.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag120);
        __tag120.release();
        return false;
    }

    private boolean _jsp__tag121(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag121 = null ;
        int __result__tag121 = 0 ;

        if (__tag121 == null ){
            __tag121 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag121);
        }
        __tag121.setPageContext(pageContext);
        __tag121.setParent(null);
        __tag121.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag121.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag121;
        __result__tag121 = __tag121.doStartTag();

        if (__result__tag121!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag121== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag121.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag121);
            return true;
        }
        _activeTag=__tag121.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag121);
        __tag121.release();
        return false;
    }

    private boolean _jsp__tag122(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag122 = null ;
        int __result__tag122 = 0 ;

        if (__tag122 == null ){
            __tag122 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag122);
        }
        __tag122.setPageContext(pageContext);
        __tag122.setParent(null);
        __tag122.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag122.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag122;
        __result__tag122 = __tag122.doStartTag();

        if (__result__tag122!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag122== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag122.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag122);
            return true;
        }
        _activeTag=__tag122.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag122);
        __tag122.release();
        return false;
    }

    private boolean _jsp__tag123(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag123 = null ;
        int __result__tag123 = 0 ;

        if (__tag123 == null ){
            __tag123 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag123);
        }
        __tag123.setPageContext(pageContext);
        __tag123.setParent(null);
        __tag123.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
        __tag123.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag123;
        __result__tag123 = __tag123.doStartTag();

        if (__result__tag123!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag123== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag123.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag123);
            return true;
        }
        _activeTag=__tag123.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag123);
        __tag123.release();
        return false;
    }

    private boolean _jsp__tag124(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag124 = null ;
        int __result__tag124 = 0 ;

        if (__tag124 == null ){
            __tag124 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag124);
        }
        __tag124.setPageContext(pageContext);
        __tag124.setParent(null);
        __tag124.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag124.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag124;
        __result__tag124 = __tag124.doStartTag();

        if (__result__tag124!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag124== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag124.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag124);
            return true;
        }
        _activeTag=__tag124.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag124);
        __tag124.release();
        return false;
    }

    private boolean _jsp__tag125(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag125 = null ;
        int __result__tag125 = 0 ;

        if (__tag125 == null ){
            __tag125 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag125);
        }
        __tag125.setPageContext(pageContext);
        __tag125.setParent(null);
        __tag125.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ReferralStatus.label", java.lang.String .class,"key"));
        __tag125.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag125;
        __result__tag125 = __tag125.doStartTag();

        if (__result__tag125!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag125== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag125.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag125);
            return true;
        }
        _activeTag=__tag125.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag125);
        __tag125.release();
        return false;
    }

    private boolean _jsp__tag126(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag126 = null ;
        int __result__tag126 = 0 ;

        if (__tag126 == null ){
            __tag126 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag126);
        }
        __tag126.setPageContext(pageContext);
        __tag126.setParent(null);
        __tag126.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitAdmDate.label", java.lang.String .class,"key"));
        __tag126.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag126;
        __result__tag126 = __tag126.doStartTag();

        if (__result__tag126!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag126== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag126.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag126);
            return true;
        }
        _activeTag=__tag126.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag126);
        __tag126.release();
        return false;
    }

    private boolean _jsp__tag127(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag127 = null ;
        int __result__tag127 = 0 ;

        if (__tag127 == null ){
            __tag127 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag127);
        }
        __tag127.setPageContext(pageContext);
        __tag127.setParent(null);
        __tag127.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VisitAdmEndDate.label", java.lang.String .class,"key"));
        __tag127.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag127;
        __result__tag127 = __tag127.doStartTag();

        if (__result__tag127!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag127== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag127.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag127);
            return true;
        }
        _activeTag=__tag127.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag127);
        __tag127.release();
        return false;
    }

    private boolean _jsp__tag128(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag128 = null ;
        int __result__tag128 = 0 ;

        if (__tag128 == null ){
            __tag128 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag128);
        }
        __tag128.setPageContext(pageContext);
        __tag128.setParent(null);
        __tag128.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
        __tag128.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag128;
        __result__tag128 = __tag128.doStartTag();

        if (__result__tag128!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag128== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag128.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag128);
            return true;
        }
        _activeTag=__tag128.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag128);
        __tag128.release();
        return false;
    }

    private boolean _jsp__tag129(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag129 = null ;
        int __result__tag129 = 0 ;

        if (__tag129 == null ){
            __tag129 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag129);
        }
        __tag129.setPageContext(pageContext);
        __tag129.setParent(null);
        __tag129.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag129.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag129;
        __result__tag129 = __tag129.doStartTag();

        if (__result__tag129!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag129== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag129.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag129);
            return true;
        }
        _activeTag=__tag129.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag129);
        __tag129.release();
        return false;
    }

    private boolean _jsp__tag130(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag130 = null ;
        int __result__tag130 = 0 ;

        if (__tag130 == null ){
            __tag130 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag130);
        }
        __tag130.setPageContext(pageContext);
        __tag130.setParent(null);
        __tag130.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.researchStudy.label", java.lang.String .class,"key"));
        __tag130.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag130;
        __result__tag130 = __tag130.doStartTag();

        if (__result__tag130!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag130== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag130.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag130);
            return true;
        }
        _activeTag=__tag130.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag130);
        __tag130.release();
        return false;
    }

    private boolean _jsp__tag131(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag131 = null ;
        int __result__tag131 = 0 ;

        if (__tag131 == null ){
            __tag131 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag131);
        }
        __tag131.setPageContext(pageContext);
        __tag131.setParent(null);
        __tag131.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientClassification.label", java.lang.String .class,"key"));
        __tag131.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag131;
        __result__tag131 = __tag131.doStartTag();

        if (__result__tag131!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag131== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag131.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag131);
            return true;
        }
        _activeTag=__tag131.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag131);
        __tag131.release();
        return false;
    }

    private boolean _jsp__tag132(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag132 = null ;
        int __result__tag132 = 0 ;

        if (__tag132 == null ){
            __tag132 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag132);
        }
        __tag132.setPageContext(pageContext);
        __tag132.setParent(null);
        __tag132.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag132.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag132;
        __result__tag132 = __tag132.doStartTag();

        if (__result__tag132!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag132== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag132.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag132);
            return true;
        }
        _activeTag=__tag132.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag132);
        __tag132.release();
        return false;
    }

    private boolean _jsp__tag133(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag133 = null ;
        int __result__tag133 = 0 ;

        if (__tag133 == null ){
            __tag133 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag133);
        }
        __tag133.setPageContext(pageContext);
        __tag133.setParent(null);
        __tag133.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
        __tag133.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag133;
        __result__tag133 = __tag133.doStartTag();

        if (__result__tag133!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag133== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag133.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag133);
            return true;
        }
        _activeTag=__tag133.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag133);
        __tag133.release();
        return false;
    }

    private boolean _jsp__tag134(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag134 = null ;
        int __result__tag134 = 0 ;

        if (__tag134 == null ){
            __tag134 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag134);
        }
        __tag134.setPageContext(pageContext);
        __tag134.setParent(null);
        __tag134.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
        __tag134.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag134;
        __result__tag134 = __tag134.doStartTag();

        if (__result__tag134!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag134== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag134.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag134);
            return true;
        }
        _activeTag=__tag134.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag134);
        __tag134.release();
        return false;
    }

    private boolean _jsp__tag135(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag135 = null ;
        int __result__tag135 = 0 ;

        if (__tag135 == null ){
            __tag135 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag135);
        }
        __tag135.setPageContext(pageContext);
        __tag135.setParent(null);
        __tag135.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag135.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag135;
        __result__tag135 = __tag135.doStartTag();

        if (__result__tag135!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag135== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag135.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag135);
            return true;
        }
        _activeTag=__tag135.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag135);
        __tag135.release();
        return false;
    }

    private boolean _jsp__tag136(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag136 = null ;
        int __result__tag136 = 0 ;

        if (__tag136 == null ){
            __tag136 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag136);
        }
        __tag136.setPageContext(pageContext);
        __tag136.setParent(null);
        __tag136.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag136.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag136;
        __result__tag136 = __tag136.doStartTag();

        if (__result__tag136!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag136== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag136.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag136);
            return true;
        }
        _activeTag=__tag136.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag136);
        __tag136.release();
        return false;
    }

    private boolean _jsp__tag137(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag137 = null ;
        int __result__tag137 = 0 ;

        if (__tag137 == null ){
            __tag137 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag137);
        }
        __tag137.setPageContext(pageContext);
        __tag137.setParent(null);
        __tag137.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag137.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag137;
        __result__tag137 = __tag137.doStartTag();

        if (__result__tag137!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag137== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag137.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag137);
            return true;
        }
        _activeTag=__tag137.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag137);
        __tag137.release();
        return false;
    }

    private boolean _jsp__tag138(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag138 = null ;
        int __result__tag138 = 0 ;

        if (__tag138 == null ){
            __tag138 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag138);
        }
        __tag138.setPageContext(pageContext);
        __tag138.setParent(null);
        __tag138.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
        __tag138.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag138;
        __result__tag138 = __tag138.doStartTag();

        if (__result__tag138!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag138== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag138.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag138);
            return true;
        }
        _activeTag=__tag138.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag138);
        __tag138.release();
        return false;
    }

    private boolean _jsp__tag139(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag139 = null ;
        int __result__tag139 = 0 ;

        if (__tag139 == null ){
            __tag139 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag139);
        }
        __tag139.setPageContext(pageContext);
        __tag139.setParent(null);
        __tag139.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag139.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag139;
        __result__tag139 = __tag139.doStartTag();

        if (__result__tag139!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag139== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag139.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag139);
            return true;
        }
        _activeTag=__tag139.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag139);
        __tag139.release();
        return false;
    }

    private boolean _jsp__tag140(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag140 = null ;
        int __result__tag140 = 0 ;

        if (__tag140 == null ){
            __tag140 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag140);
        }
        __tag140.setPageContext(pageContext);
        __tag140.setParent(null);
        __tag140.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
        __tag140.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag140;
        __result__tag140 = __tag140.doStartTag();

        if (__result__tag140!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag140== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag140.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag140);
            return true;
        }
        _activeTag=__tag140.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag140);
        __tag140.release();
        return false;
    }

    private boolean _jsp__tag141(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag141 = null ;
        int __result__tag141 = 0 ;

        if (__tag141 == null ){
            __tag141 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag141);
        }
        __tag141.setPageContext(pageContext);
        __tag141.setParent(null);
        __tag141.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag141.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag141;
        __result__tag141 = __tag141.doStartTag();

        if (__result__tag141!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag141== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag141.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag141);
            return true;
        }
        _activeTag=__tag141.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag141);
        __tag141.release();
        return false;
    }

    private boolean _jsp__tag142(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag142 = null ;
        int __result__tag142 = 0 ;

        if (__tag142 == null ){
            __tag142 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag142);
        }
        __tag142.setPageContext(pageContext);
        __tag142.setParent(null);
        __tag142.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalService.label", java.lang.String .class,"key"));
        __tag142.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag142;
        __result__tag142 = __tag142.doStartTag();

        if (__result__tag142!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag142== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag142.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag142);
            return true;
        }
        _activeTag=__tag142.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag142);
        __tag142.release();
        return false;
    }

    private boolean _jsp__tag143(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag143 = null ;
        int __result__tag143 = 0 ;

        if (__tag143 == null ){
            __tag143 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag143);
        }
        __tag143.setPageContext(pageContext);
        __tag143.setParent(null);
        __tag143.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
        __tag143.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag143;
        __result__tag143 = __tag143.doStartTag();

        if (__result__tag143!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag143== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag143.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag143);
            return true;
        }
        _activeTag=__tag143.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag143);
        __tag143.release();
        return false;
    }

    private boolean _jsp__tag144(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag144 = null ;
        int __result__tag144 = 0 ;

        if (__tag144 == null ){
            __tag144 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag144);
        }
        __tag144.setPageContext(pageContext);
        __tag144.setParent(null);
        __tag144.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
        __tag144.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag144;
        __result__tag144 = __tag144.doStartTag();

        if (__result__tag144!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag144== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag144.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag144);
            return true;
        }
        _activeTag=__tag144.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag144);
        __tag144.release();
        return false;
    }

    private boolean _jsp__tag145(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag145 = null ;
        int __result__tag145 = 0 ;

        if (__tag145 == null ){
            __tag145 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag145);
        }
        __tag145.setPageContext(pageContext);
        __tag145.setParent(null);
        __tag145.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.researchStudy.label", java.lang.String .class,"key"));
        __tag145.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag145;
        __result__tag145 = __tag145.doStartTag();

        if (__result__tag145!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag145== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag145.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag145);
            return true;
        }
        _activeTag=__tag145.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag145);
        __tag145.release();
        return false;
    }

    private boolean _jsp__tag146(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag146 = null ;
        int __result__tag146 = 0 ;

        if (__tag146 == null ){
            __tag146 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag146);
        }
        __tag146.setPageContext(pageContext);
        __tag146.setParent(null);
        __tag146.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientClassification.label", java.lang.String .class,"key"));
        __tag146.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag146;
        __result__tag146 = __tag146.doStartTag();

        if (__result__tag146!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag146== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag146.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag146);
            return true;
        }
        _activeTag=__tag146.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag146);
        __tag146.release();
        return false;
    }

    private boolean _jsp__tag147(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag147 = null ;
        int __result__tag147 = 0 ;

        if (__tag147 == null ){
            __tag147 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag147);
        }
        __tag147.setPageContext(pageContext);
        __tag147.setParent(null);
        __tag147.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag147.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag147;
        __result__tag147 = __tag147.doStartTag();

        if (__result__tag147!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag147== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag147.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag147);
            return true;
        }
        _activeTag=__tag147.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag147);
        __tag147.release();
        return false;
    }

    private boolean _jsp__tag148(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag148 = null ;
        int __result__tag148 = 0 ;

        if (__tag148 == null ){
            __tag148 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag148);
        }
        __tag148.setPageContext(pageContext);
        __tag148.setParent(null);
        __tag148.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
        __tag148.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag148;
        __result__tag148 = __tag148.doStartTag();

        if (__result__tag148!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag148== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag148.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag148);
            return true;
        }
        _activeTag=__tag148.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag148);
        __tag148.release();
        return false;
    }

    private boolean _jsp__tag149(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag149 = null ;
        int __result__tag149 = 0 ;

        if (__tag149 == null ){
            __tag149 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag149);
        }
        __tag149.setPageContext(pageContext);
        __tag149.setParent(null);
        __tag149.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
        __tag149.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag149;
        __result__tag149 = __tag149.doStartTag();

        if (__result__tag149!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag149== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag149.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag149);
            return true;
        }
        _activeTag=__tag149.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag149);
        __tag149.release();
        return false;
    }

    private boolean _jsp__tag150(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag150 = null ;
        int __result__tag150 = 0 ;

        if (__tag150 == null ){
            __tag150 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag150);
        }
        __tag150.setPageContext(pageContext);
        __tag150.setParent(null);
        __tag150.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag150.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag150;
        __result__tag150 = __tag150.doStartTag();

        if (__result__tag150!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag150== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag150.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag150);
            return true;
        }
        _activeTag=__tag150.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag150);
        __tag150.release();
        return false;
    }

    private boolean _jsp__tag151(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag151 = null ;
        int __result__tag151 = 0 ;

        if (__tag151 == null ){
            __tag151 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag151);
        }
        __tag151.setPageContext(pageContext);
        __tag151.setParent(null);
        __tag151.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag151.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag151;
        __result__tag151 = __tag151.doStartTag();

        if (__result__tag151!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag151== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag151.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag151);
            return true;
        }
        _activeTag=__tag151.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag151);
        __tag151.release();
        return false;
    }

    private boolean _jsp__tag152(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag152 = null ;
        int __result__tag152 = 0 ;

        if (__tag152 == null ){
            __tag152 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag152);
        }
        __tag152.setPageContext(pageContext);
        __tag152.setParent(null);
        __tag152.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PreDischargeAdvice.label", java.lang.String .class,"key"));
        __tag152.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag152;
        __result__tag152 = __tag152.doStartTag();

        if (__result__tag152!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag152== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag152.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag152);
            return true;
        }
        _activeTag=__tag152.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag152);
        __tag152.release();
        return false;
    }

    private boolean _jsp__tag153(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag153 = null ;
        int __result__tag153 = 0 ;

        if (__tag153 == null ){
            __tag153 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag153);
        }
        __tag153.setPageContext(pageContext);
        __tag153.setParent(null);
        __tag153.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
        __tag153.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag153;
        __result__tag153 = __tag153.doStartTag();

        if (__result__tag153!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag153== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag153.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag153);
            return true;
        }
        _activeTag=__tag153.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag153);
        __tag153.release();
        return false;
    }

    private boolean _jsp__tag154(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag154 = null ;
        int __result__tag154 = 0 ;

        if (__tag154 == null ){
            __tag154 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag154);
        }
        __tag154.setPageContext(pageContext);
        __tag154.setParent(null);
        __tag154.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.appttime.label", java.lang.String .class,"key"));
        __tag154.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag154;
        __result__tag154 = __tag154.doStartTag();

        if (__result__tag154!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag154== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag154.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag154);
            return true;
        }
        _activeTag=__tag154.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag154);
        __tag154.release();
        return false;
    }

    private boolean _jsp__tag155(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag155 = null ;
        int __result__tag155 = 0 ;

        if (__tag155 == null ){
            __tag155 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag155);
        }
        __tag155.setPageContext(pageContext);
        __tag155.setParent(null);
        __tag155.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag155.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag155;
        __result__tag155 = __tag155.doStartTag();

        if (__result__tag155!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag155== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag155.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag155);
            return true;
        }
        _activeTag=__tag155.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag155);
        __tag155.release();
        return false;
    }

    private boolean _jsp__tag156(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag156 = null ;
        int __result__tag156 = 0 ;

        if (__tag156 == null ){
            __tag156 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag156);
        }
        __tag156.setPageContext(pageContext);
        __tag156.setParent(null);
        __tag156.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag156.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag156;
        __result__tag156 = __tag156.doStartTag();

        if (__result__tag156!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag156== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag156.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag156);
            return true;
        }
        _activeTag=__tag156.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag156);
        __tag156.release();
        return false;
    }

    private boolean _jsp__tag157(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag157 = null ;
        int __result__tag157 = 0 ;

        if (__tag157 == null ){
            __tag157 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag157);
        }
        __tag157.setPageContext(pageContext);
        __tag157.setParent(null);
        __tag157.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag157.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag157;
        __result__tag157 = __tag157.doStartTag();

        if (__result__tag157!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag157== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag157.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag157);
            return true;
        }
        _activeTag=__tag157.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag157);
        __tag157.release();
        return false;
    }

    private boolean _jsp__tag158(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag158 = null ;
        int __result__tag158 = 0 ;

        if (__tag158 == null ){
            __tag158 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag158);
        }
        __tag158.setPageContext(pageContext);
        __tag158.setParent(null);
        __tag158.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
        __tag158.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag158;
        __result__tag158 = __tag158.doStartTag();

        if (__result__tag158!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag158== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag158.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag158);
            return true;
        }
        _activeTag=__tag158.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag158);
        __tag158.release();
        return false;
    }

    private boolean _jsp__tag159(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag159 = null ;
        int __result__tag159 = 0 ;

        if (__tag159 == null ){
            __tag159 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag159);
        }
        __tag159.setPageContext(pageContext);
        __tag159.setParent(null);
        __tag159.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag159.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag159;
        __result__tag159 = __tag159.doStartTag();

        if (__result__tag159!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag159== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag159.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag159);
            return true;
        }
        _activeTag=__tag159.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag159);
        __tag159.release();
        return false;
    }

    private boolean _jsp__tag160(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag160 = null ;
        int __result__tag160 = 0 ;

        if (__tag160 == null ){
            __tag160 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag160);
        }
        __tag160.setPageContext(pageContext);
        __tag160.setParent(null);
        __tag160.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalService.label", java.lang.String .class,"key"));
        __tag160.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag160;
        __result__tag160 = __tag160.doStartTag();

        if (__result__tag160!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag160== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag160.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag160);
            return true;
        }
        _activeTag=__tag160.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag160);
        __tag160.release();
        return false;
    }

    private boolean _jsp__tag161(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag161 = null ;
        int __result__tag161 = 0 ;

        if (__tag161 == null ){
            __tag161 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag161);
        }
        __tag161.setPageContext(pageContext);
        __tag161.setParent(null);
        __tag161.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.appttime.label", java.lang.String .class,"key"));
        __tag161.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag161;
        __result__tag161 = __tag161.doStartTag();

        if (__result__tag161!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag161== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag161.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag161);
            return true;
        }
        _activeTag=__tag161.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag161);
        __tag161.release();
        return false;
    }

    private boolean _jsp__tag162(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag162 = null ;
        int __result__tag162 = 0 ;

        if (__tag162 == null ){
            __tag162 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag162);
        }
        __tag162.setPageContext(pageContext);
        __tag162.setParent(null);
        __tag162.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.CallTicket.label", java.lang.String .class,"key"));
        __tag162.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag162;
        __result__tag162 = __tag162.doStartTag();

        if (__result__tag162!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag162== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag162.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag162);
            return true;
        }
        _activeTag=__tag162.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag162);
        __tag162.release();
        return false;
    }

    private boolean _jsp__tag163(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag163 = null ;
        int __result__tag163 = 0 ;

        if (__tag163 == null ){
            __tag163 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag163);
        }
        __tag163.setPageContext(pageContext);
        __tag163.setParent(null);
        __tag163.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.isinpatient.label", java.lang.String .class,"key"));
        __tag163.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag163;
        __result__tag163 = __tag163.doStartTag();

        if (__result__tag163!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag163== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag163.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag163);
            return true;
        }
        _activeTag=__tag163.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag163);
        __tag163.release();
        return false;
    }

    private boolean _jsp__tag164(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag164 = null ;
        int __result__tag164 = 0 ;

        if (__tag164 == null ){
            __tag164 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag164);
        }
        __tag164.setPageContext(pageContext);
        __tag164.setParent(null);
        __tag164.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag164.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag164;
        __result__tag164 = __tag164.doStartTag();

        if (__result__tag164!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag164== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag164.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag164);
            return true;
        }
        _activeTag=__tag164.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag164);
        __tag164.release();
        return false;
    }

    private boolean _jsp__tag165(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag165 = null ;
        int __result__tag165 = 0 ;

        if (__tag165 == null ){
            __tag165 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag165);
        }
        __tag165.setPageContext(pageContext);
        __tag165.setParent(null);
        __tag165.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag165.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag165;
        __result__tag165 = __tag165.doStartTag();

        if (__result__tag165!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag165== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag165.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag165);
            return true;
        }
        _activeTag=__tag165.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag165);
        __tag165.release();
        return false;
    }

    private boolean _jsp__tag166(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag166 = null ;
        int __result__tag166 = 0 ;

        if (__tag166 == null ){
            __tag166 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag166);
        }
        __tag166.setPageContext(pageContext);
        __tag166.setParent(null);
        __tag166.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag166.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag166;
        __result__tag166 = __tag166.doStartTag();

        if (__result__tag166!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag166== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag166.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag166);
            return true;
        }
        _activeTag=__tag166.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag166);
        __tag166.release();
        return false;
    }

    private boolean _jsp__tag167(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag167 = null ;
        int __result__tag167 = 0 ;

        if (__tag167 == null ){
            __tag167 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag167);
        }
        __tag167.setPageContext(pageContext);
        __tag167.setParent(null);
        __tag167.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
        __tag167.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag167;
        __result__tag167 = __tag167.doStartTag();

        if (__result__tag167!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag167== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag167.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag167);
            return true;
        }
        _activeTag=__tag167.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag167);
        __tag167.release();
        return false;
    }

    private boolean _jsp__tag168(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag168 = null ;
        int __result__tag168 = 0 ;

        if (__tag168 == null ){
            __tag168 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag168);
        }
        __tag168.setPageContext(pageContext);
        __tag168.setParent(null);
        __tag168.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag168.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag168;
        __result__tag168 = __tag168.doStartTag();

        if (__result__tag168!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag168== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag168.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag168);
            return true;
        }
        _activeTag=__tag168.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag168);
        __tag168.release();
        return false;
    }

    private boolean _jsp__tag169(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag169 = null ;
        int __result__tag169 = 0 ;

        if (__tag169 == null ){
            __tag169 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag169);
        }
        __tag169.setPageContext(pageContext);
        __tag169.setParent(null);
        __tag169.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MedicalService.label", java.lang.String .class,"key"));
        __tag169.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag169;
        __result__tag169 = __tag169.doStartTag();

        if (__result__tag169!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag169== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag169.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag169);
            return true;
        }
        _activeTag=__tag169.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag169);
        __tag169.release();
        return false;
    }

    private boolean _jsp__tag170(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag170 = null ;
        int __result__tag170 = 0 ;

        if (__tag170 == null ){
            __tag170 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag170);
        }
        __tag170.setPageContext(pageContext);
        __tag170.setParent(null);
        __tag170.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
        __tag170.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag170;
        __result__tag170 = __tag170.doStartTag();

        if (__result__tag170!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag170== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag170.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag170);
            return true;
        }
        _activeTag=__tag170.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag170);
        __tag170.release();
        return false;
    }

    private boolean _jsp__tag171(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag171 = null ;
        int __result__tag171 = 0 ;

        if (__tag171 == null ){
            __tag171 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag171);
        }
        __tag171.setPageContext(pageContext);
        __tag171.setParent(null);
        __tag171.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDate.label", java.lang.String .class,"key"));
        __tag171.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag171;
        __result__tag171 = __tag171.doStartTag();

        if (__result__tag171!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag171== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag171.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag171);
            return true;
        }
        _activeTag=__tag171.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag171);
        __tag171.release();
        return false;
    }

    private boolean _jsp__tag172(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag172 = null ;
        int __result__tag172 = 0 ;

        if (__tag172 == null ){
            __tag172 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag172);
        }
        __tag172.setPageContext(pageContext);
        __tag172.setParent(null);
        __tag172.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
        __tag172.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag172;
        __result__tag172 = __tag172.doStartTag();

        if (__result__tag172!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag172== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag172.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag172);
            return true;
        }
        _activeTag=__tag172.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag172);
        __tag172.release();
        return false;
    }

    private boolean _jsp__tag173(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag173 = null ;
        int __result__tag173 = 0 ;

        if (__tag173 == null ){
            __tag173 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag173);
        }
        __tag173.setPageContext(pageContext);
        __tag173.setParent(null);
        __tag173.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.researchStudy.label", java.lang.String .class,"key"));
        __tag173.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag173;
        __result__tag173 = __tag173.doStartTag();

        if (__result__tag173!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag173== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag173.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag173);
            return true;
        }
        _activeTag=__tag173.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag173);
        __tag173.release();
        return false;
    }

    private boolean _jsp__tag174(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag174 = null ;
        int __result__tag174 = 0 ;

        if (__tag174 == null ){
            __tag174 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag174);
        }
        __tag174.setPageContext(pageContext);
        __tag174.setParent(null);
        __tag174.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientClassification.label", java.lang.String .class,"key"));
        __tag174.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag174;
        __result__tag174 = __tag174.doStartTag();

        if (__result__tag174!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag174== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag174.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag174);
            return true;
        }
        _activeTag=__tag174.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag174);
        __tag174.release();
        return false;
    }

    private boolean _jsp__tag175(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag175 = null ;
        int __result__tag175 = 0 ;

        if (__tag175 == null ){
            __tag175 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag175);
        }
        __tag175.setPageContext(pageContext);
        __tag175.setParent(null);
        __tag175.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsEndDate.label", java.lang.String .class,"key"));
        __tag175.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag175;
        __result__tag175 = __tag175.doStartTag();

        if (__result__tag175!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag175== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag175.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag175);
            return true;
        }
        _activeTag=__tag175.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag175);
        __tag175.release();
        return false;
    }

    private boolean _jsp__tag176(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag176 = null ;
        int __result__tag176 = 0 ;

        if (__tag176 == null ){
            __tag176 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag176);
        }
        __tag176.setPageContext(pageContext);
        __tag176.setParent(null);
        __tag176.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag176.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag176;
        __result__tag176 = __tag176.doStartTag();

        if (__result__tag176!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag176== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag176.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag176);
            return true;
        }
        _activeTag=__tag176.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag176);
        __tag176.release();
        return false;
    }

    private boolean _jsp__tag177(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag177 = null ;
        int __result__tag177 = 0 ;

        if (__tag177 == null ){
            __tag177 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag177);
        }
        __tag177.setPageContext(pageContext);
        __tag177.setParent(null);
        __tag177.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
        __tag177.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag177;
        __result__tag177 = __tag177.doStartTag();

        if (__result__tag177!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag177== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag177.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag177);
            return true;
        }
        _activeTag=__tag177.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag177);
        __tag177.release();
        return false;
    }
}
