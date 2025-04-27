package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patlistbymedserviceresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatListByMedServiceResult.jsp", 1745326828540L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="<!-- 32902 -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\' />\n\n\n\n <script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCA/js/PatListByMedServiceResult.js\' language=\'javascript\'></script>\n<script language=\'javascript\' src=\'../../eCA/js/CACommon.js\'></script> <!-- 37866 -->\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>\n\n<body class=\'CONTENT\' onscroll=\'moveFrame()\' onload=\"storeValues(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\')\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<script language=javascript>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<table id=\'prevNext\' cellpadding=\'0\' cellspacing=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t\t<tr>\n\t\t<td class=\'white\' width=\'90%\'></td> \n\t\t<td nowrap  width=\'5%\' align=\'right\' id=\'previous\' ></td>\n\t\t<td nowrap  width=\'5%\' align=\'right\' id=\'next\' ></td>\n\t\t</tr>\n\t</table>\n\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t<!------------------------ Changes for Prevoius Next unctionality----------->\n\t<input type=\"hidden\" name=\"encounterType1\" id=\"encounterType1\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\"hidden\" name=\"medServiceCode1\" id=\"medServiceCode1\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\"hidden\" name=\"viewList1\" id=\"viewList1\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type=\"hidden\" name=\"groupByMedService1\" id=\"groupByMedService1\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type=\"hidden\" name=\"groupByEpisode1\" id=\"groupByEpisode1\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type=\"hidden\" name=\"reln_req_yn1\" id=\"reln_req_yn1\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=\"hidden\" name=\"past1\" id=\"past1\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\"hidden\" name=\"discharged1\" id=\"discharged1\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\" name=\"unscheduled_yn1\" id=\"unscheduled_yn1\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\" name=\"from_visit_date1\" id=\"from_visit_date1\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name=\"from_discharge_date1\" id=\"from_discharge_date1\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name=\"checked_out1\" id=\"checked_out1\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name=\"patientId1\" id=\"patientId1\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\" name=\"queueId1\" id=\"queueId1\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\"hidden\" name=\"sortOrder1\" id=\"sortOrder1\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\"hidden\" name=\"queueStatus1\" id=\"queueStatus1\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\"hidden\" name=\"nationID1\" id=\"nationID1\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"adm_fromdate1\" id=\"adm_fromdate1\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\"hidden\" name=\"adm_todate1\" id=\"adm_todate1\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\" name=\"to_visit_date1\" id=\"to_visit_date1\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"to_discharge_date1\" id=\"to_discharge_date1\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"navigate\">\n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"\">\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"\">\n\t<input type=\"hidden\" name=\"form\" id=\"form\" value=\"MedService\">\n\t<input type=\"hidden\" name=\"attend_practId1\" id=\"attend_practId1\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\"hidden\" name=\"speciality1\" id=\"speciality1\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\n\t<!------------------------ end of change---------------------------------->\n\n  ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t<Script>\n\t\t\t\tparent.parent.frames[2].document.getElementById(\"previous\").innerHTML=\"\";\n\t\t\t\tparent.parent.frames[2].document.getElementById(\"next\").innerHTML=\"\";\n\t\t\t</Script>\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<Script>\n\t\t\t\tif(top.content.workAreaFrame.PatResultFr.MedServResultTitle.document.getElementById(\'previous\'))\n\t\t\t\t{\t\n\t\t\t\t\tparent.parent.frames[2].document.getElementById(\'previous\').innerHTML = \"<INPUT TYPE=\'button\' class=\'button\' name=\'prev\' id=\'prev\' onClick=navigate(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\') title=\'Previous\' value=\'  \\<  \' >\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\tdocument.getElementById(\'previous\').innerHTML = \"<a href=\'javascript:onClick=navigate(";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =",";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =")\' title=\'Previous\' value=\' Previous  \' >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</a>\";\n\t\t\t\t}\n\t\t\t\t</Script>\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t<Script>\n\t\t\t\tif(top.content.workAreaFrame.PatResultFr.MedServResultTitle.document.getElementById(\'previous\'))\n\t\t\t\t{\n\t\t\t\t\tparent.parent.frames[2].document.getElementById(\'next\').innerHTML = \"<INPUT TYPE=\'button\' class=\'button\' name=\'nex\' id=\'nex\'  onClick=navigate(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\') title=\'Next\' value=\'  \\>  \' >\";\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\tdocument.getElementById(\"next\").innerHTML = \'<a href=\"javascript:onClick=navigate(\\\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\\\',\\\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\\\')\" title=\"Next\" value=\" next  \" >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</a>\';\n\t\t\t\t}\n\t\t\t\t</Script>\n\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t<script>\n\t\t\t\tif(parent.parent.frames[2].document.getElementById(\'next\'))\n\t\t\t\t\tparent.parent.frames[2].document.getElementById(\'next\').innerHTML=\"&nbsp;\";\n\t\t\t\tif(parent.parent.frames[2].document.getElementById(\'previous\'))\n\t\t\t\t\tparent.parent.frames[2].document.getElementById(\'previous\').innerHTML=\"&nbsp;\";\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t<input type=\"hidden\" name=\"maxNoRecords\" id=\"maxNoRecords\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n                                <input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"  name=\"restPatientYN";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n                                <input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n                                ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t                               <input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n\t                                <input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n\t                               ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n                                  <input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n                                  ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t      <input type=\"hidden\" id=\"restPatientYN";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n\t      <input type=\"hidden\" id=\"accessRightsViewPatient\"  name=\"accessRightsViewPatient\" id=\"accessRightsViewPatient\" value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n\t             ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n<!-- \t\t\t\tout.println(\"<tr id=\'titleHdrIP\' style=\'visibility:hidden\'><td class=\'COLUMNHEADERCENTER\' nowrap width=\'16px\'>&nbsp;</td><td class=\'COLUMNHEADERCENTER\' nowrap width=\'16px\'>&nbsp;</td><td class=\'COLUMNHEADERCENTER\' nowrap >\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.PatientName.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.age.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.gender.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.patientId.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.admissiondate.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.QueueStatus.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.dischargedate.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.roomno.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.bedno.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.AttendingPractitioner.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.Location.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.birthDate.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.referralid.label\",\"common_labels\")+\"</td></tr>\");\n -->\t\t\t\t\n\t\t\t\t<script>\n\t\t\t\t\n\t\t\t\tvar tableHeader=`<tr id=\'InPatAndDayCare\'>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' width=\"16px\" nowrap>&nbsp;</th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' width=\"16px\" nowrap>&nbsp;</th>\n\t\t\t\t\t\t\t\t        <!-- //22856-start-->\n\t\t\t\t\t                <th class=\'COLUMNHEADERCENTER\'  rowspan=1 width=\'\' nowrap  >";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</th>\n\t\t\t\t\t                                        <!-- //22856-End-->\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a id=\'a01\' name=1   href=\"javascript:callForOrderBy(\'PN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</a></th>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a id=\'a02\'name=1   href=\"javascript:callForOrderBy(\'AGE\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a id=\'a03\' name=1   href=\"javascript:callForOrderBy(\'SEX\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a  id=\'a04\'name=1   href=\"javascript:callForOrderBy(\'PID\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a  id=\'a05\'name=1   href=\"javascript:callForOrderBy(\'AD\');\" onclick=\'changeColor(this);\' style=\"color:pink\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a id=\'a06\' name=1 href=\"javascript:callForOrderBy(\'IQS\');\"  onclick=\'changeColor(this);\' style=\"color:white\" >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a  id=\'a07\'name=1   href=\"javascript:callForOrderBy(\'DD\');\" onclick=\'changeColor(this);\' title=\'discharge date\' style=\"color:white\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a id=\'a08\' name=1   href=\"javascript:callForOrderBy(\'RN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a id=\'a09\'name=1   href=\"javascript:callForOrderBy(\'BN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a id=\'a10\' name=1   href=\"javascript:callForOrderBy(\'AP\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a  id=\'a11\'name=1   href=\"javascript:callForOrderBy(\'LOC\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a  id=\'a12\'name=1   href=\"javascript:callForOrderBy(\'DOB\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' nowrap ><a id=\'a13\' name=1   href=\"javascript:callForOrderBy(\'RID\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</a></th>\n\t\t\t\t\t\t\t\t\t<!--<th class=\'COLUMNHEADERCENTER\' width=\"\">&nbsp;&nbsp;&nbsp;</th> -->\n\t\t\t\t\t\t\t\t</tr>`;\n\t\t\t\t\n\t\t\t\t// Get the table by its ID\n\t\t\t\tconst table = document.getElementById(\'PatCriteriaTbl\');\n\t\t\t\t// Check if the table exists\n\t\t\t\tif (table) {\n\t\t\t\t    // Get or create the <thead> element\n\t\t\t\t    let thead = table.querySelector(\'thead\');\n\t\t\t\t    if (!thead) {\n\t\t\t\t        thead = document.createElement(\'thead\');\n\t\t\t\t        table.prepend(thead);\n\t\t\t\t    }\n\t\t\t\t    \n\t\t\t\t    // Add the new header row to the <thead>\n\t\t\t\t    thead.innerHTML += tableHeader;\n\t\t\t\t} else {\n\t\t\t\t    console.error(\"Table with ID \'PatCriteriaTbl\' not found.\");\n\t\t\t\t}\n\t\t\t\tdocument.getElementById(\'PatCriteriaTbl\').style.marginTop=\"0px\";\n\t\t\t\tdocument.getElementById(\'prevNext\').style.display=\"none\"; \n\t\t\t\tparent.document.getElementById(\'MedServResultTitle\').style.display=\"none\";\n\t\t\t\tparent.document.getElementById(\'LocnResult\').style.height=\"83vh\";\n\t\t\t\t\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t<!--  out.println(\"<tr id=\'titleHdrOP\' style=\'visibility:hidden\' ><td class=\'COLUMNHEADERCENTER\' nowrap width=\'16px\'>&nbsp;</td><td class=\'COLUMNHEADERCENTER\' nowrap width=\'16px\'>&nbsp;</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.appttime.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.QueueNo.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.PatientName.label\",\"common_labels\")+\"</td>\");\n\t\t\t\t//37866 Start.\n\t\t\t\tif(isVirtualConsSiteSpec && \"OP\".equals(encounterType)){\n\t\t\t\tout.println(\"<td class=\'COLUMNHEADERCENTER\'   nowrap><a style=\'color:white\'   >\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"eCA.ConsultationType.label\",\"ca_labels\")+\"</a></td>\");\n\t\t\t\t}\n\t\t\t\t//37866 End.\t\t\t\t\n\t\t\t\tout.println(\"<td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.age.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.gender.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.patientId.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.VisitDate.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"eCA.ConsEndDate.label\",\"ca_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap colspan=\'2\'>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.QueueStatus.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.AttendingPractitioner.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.Location.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.birthDate.label\",\"common_labels\")+\"</td><td class=\'COLUMNHEADERCENTER\' nowrap>\"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,\"Common.referralid.label\",\"common_labels\")+\"</td></tr>\");\n\t\t\t\t  -->\n\t\t\t\t  <script>\n\t\t\t\t\n\t\t\t\tvar tableHeader=`<tr class=\'OutAndEmer\'>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' width=\"16px\" nowrap>&nbsp;</th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' width=\"16px\" nowrap>&nbsp;</th>\n\t\t\t\t                                        <!-- //22856-start-->\n\t\t                                                        <th class=\'columnheadercenter\'  rowspan=1 width=\'\' nowrap  >";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</th>\n\t\t                                                        <!-- //22856-End-->\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a01\'name=1   href=\"javascript:callForOrderBy(\'AT\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a02\' name=1   href=\"javascript:callForOrderBy(\'QN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a  id=\'a03\'name=1   href=\"javascript:callForOrderBy(\'PN\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</a></th>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a04\' style=\"color:white\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a05\' name=1   href=\"javascript:callForOrderBy(\'AGE\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a06\' name=1   href=\"javascript:callForOrderBy(\'SEX\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a07\' name=1   href=\"javascript:callForOrderBy(\'PID\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a08\' name=1   href=\"javascript:callForOrderBy(\'VD\');\" onclick=\'changeColor(this);\' style=\"color:pink\">";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a09\' name=1   href=\"javascript:callForOrderBy(\'VT\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a10\' name=1   href=\"javascript:callForOrderBy(\'DD\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a11\' name=1   href=\"javascript:callForOrderBy(\'QS\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a12\' name=1   href=\"javascript:callForOrderBy(\'AP\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a13\' name=1   href=\"javascript:callForOrderBy(\'LOC\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><a id=\'a14\' name=1   href=\"javascript:callForOrderBy(\'DOB\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</a></th>\n\t\t\t\t\t\t\t\t\t<th class=\'COLUMNHEADERCENTER\' ><nobr><a id=\'a15\' name=1   href=\"javascript:callForOrderBy(\'RID\');\" onclick=\'changeColor(this);\' style=\"color:white\">";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</a></nobr></th>\n\t\t\t\t\t\t\t\t<!--\t<th class=\'COLUMNHEADERCENTER\' width=\"\">&nbsp;&nbsp;&nbsp;</th> -->\n\t\t\t\t\t\t\t</tr>`;\n\t\t\t\t\t\t\n\t\t\t\t\t\t// Get the table by its ID\n\t\t\t\t\t\tconst table = document.getElementById(\'PatCriteriaTbl\');\n\n\t\t\t\t\t\t// Check if the table exists\n\t\t\t\t\t\tif (table) {\n\t\t\t\t\t\t    // Get or create the <thead> element\n\t\t\t\t\t\t    let thead = table.querySelector(\'thead\');\n\t\t\t\t\t\t    if (!thead) {\n\t\t\t\t\t\t        thead = document.createElement(\'thead\');\n\t\t\t\t\t\t        table.prepend(thead);\n\t\t\t\t\t\t    }\n\t\t\t\t\t\t    \n\t\t\t\t\t\t    // Add the new header row to the <thead>\n\t\t\t\t\t\t    thead.innerHTML += tableHeader;\n\t\t\t\t\t\t} else {\n\t\t\t\t\t\t    console.error(\"Table with ID \'PatCriteriaTbl\' not found.\");\n\t\t\t\t\t\t}\n\t\t\t\t\t\tdocument.getElementById(\'PatCriteriaTbl\').style.marginTop=\"0px\";\n\t\t\t\t\t\tdocument.getElementById(\'prevNext\').style.display=\"none\"; \n\t\t\t\t\t\tparent.document.getElementById(\'MedServResultTitle\').style.display=\"none\";\n\t\t\t\t\t\tparent.document.getElementById(\'LocnResult\').style.height=\"83vh\";\n\t\t\t\t\t\t\n\t\t\t\t\t\t</script>\n\t\t\t\t \n\t\t\t\t \n\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n        </table>\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"episode_visit_id\" id=\"episode_visit_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"\">\n\t\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"\">\n\t\t<input type=\"hidden\" name=\"bed_num\" id=\"bed_num\" value=\"\">\n\t\t<input type=\"hidden\" name=\"room_num\" id=\"room_num\" value=\"\">\n\t\t<input type=\"hidden\" name=\"episode_type\" id=\"episode_type\" value=\"\">\n\t\t<input type=\"hidden\" name=\"discharge_date\" id=\"discharge_date\" value=\"\">\n\t\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"\">\n\t\t<input type=\"hidden\" name=\"episode_Status\" id=\"episode_Status\" value=\"\">\n\t\t<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\"\">\n\t\t<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\"\">\n\t\t<input type=\"hidden\" name=\"age\" id=\"age\" value=\"\">\n\t\t<input type=\"hidden\" name=\"pline\" id=\"pline\" value=\"\">\n\t\t<input type=\"hidden\" name=\"security_level\" id=\"security_level\" value=\"\">\n\t\t<input type=\"hidden\" name=\"protection_ind\" id=\"protection_ind\" value=\"\">\n\t\t<input type=\"hidden\" name=\"physician_id\" id=\"physician_id\" value=\"\">\n        <input type=\"hidden\" name=\"Opphysician_id\" id=\"Opphysician_id\" value=\"\">\n\t\t<input type=\"hidden\" name=\"reln_req_yn\" id=\"reln_req_yn\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t<input type=\"hidden\" name=\"attending_doc\" id=\"attending_doc\" value=\"\">\n\t\t<input type=\"hidden\" name=\"insert_op\" id=\"insert_op\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"\">\n        <input type=\"hidden\" name=\"medical_team\" id=\"medical_team\" value=\"\">\n\t\t</form>\n\t\t<div id=\'motherLink\' style=\'position:absolute; visibility:hidden;overflow:overflow\'></div>\n\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t<script>\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'!=\'\')\n\t\t\t\t\tdocument.body.scrollLeft=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\';\n\t\t\t\tif(parent.MedServResultTitle.document.getElementById(\"TitleTab\") != null)\n\t\t\t\t{\n\t\t\t\t\tparent.MedServResultTitle.document.getElementById(\"TitleTab\").style.width =\tdocument.getElementById(\"PatCriteriaTbl\").offsetWidth+\"px\";\n\t\t\t\t\t//parent.MedServResultTitle.document.getElementById(\"TitleTab\").width = \"100%\";\n\t\t\t\t\tif(document.getElementById(\"PatCriteriaTbl\").rows[0] != null)\n\t\t\t\t\t{\n\t\t\t\t\t\tfor (j=2; j < document.getElementById(\"PatCriteriaTbl\").rows[0].cells.length; j++) \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar wid=eval(document.getElementById(\"PatCriteriaTbl\").rows[0].cells[j].offsetWidth);\n\t\t\t\t\t\t\t//alert(wid);\n\t\t\t\t\t\t\t/* if(parent.MedServResultTitle.document.getElementById(\"TitleTab\").rows[0].cells[j] != null)\n\t\t\t\t\t\t\t\tparent.MedServResultTitle.document.getElementById(\"TitleTab\").rows[0].cells[j].style.width=wid+\"px\"; */\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\';\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'!=\'\')\n\t\t\t\t{\n\t\t\t\t\t//*** added to make all anchors white before making the selcted one pink\n\t\t\t\t\tfor(i=0;i<document.anchors.length;i++)\n\t\t\t\t\t\tdocument.anchors[i].style.color=\'white\';\n\t\t\t\t\t//***\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'==\'1\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\").style.color=\'pink\'; \n\t\t\t\t\t\t\t/* document.getElementsByTagName(\'a\').style.color=\'pink\'; */\n\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t\telse if(\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'==\'2\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\n\t\t\t\t\t\t document.getElementById(\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\").style.color=\'yellow\';\n\t\t\t\t\t\t/* document.getElementsByTagName(\'a\').style.color=\'yellow\'; */\n\t\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n    </body>\n</html>\n";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History      Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
20/08/2012		IN029180		Chowminya 		 The system is not running by sequence number of newborn.	
13/03/2014		IN044157		Chowminya		 [AAKH CRF 0010.1]Five level Triage system AE requirement 
15/04/2023		37866			Ramesh G		 MMS-DM-CRF-0226				
22-06-2023        22856      Srinivasa N T                      22-06-2023            Ramesh G    ML-MMOH-CRF-1778
6/11/2023     32902             Krishna Pranay    	     7/11/2023      Ramesh G      MMS-DM-CRF-0210	
05/12/2023   54073     srinivasa N T              ramesh Goli   	

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String locn_type =	request.getParameter("locn_type");
	String legendstyle="padding-left:0px;padding-right:0px";

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
	
Connection con =null;
PreparedStatement stmtMotherLink = null;
PreparedStatement pstmtForAEPat = null;
ResultSet rsMotherLink = null;
ResultSet resForAEPat = null;
String mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
String	 encounterType = "" ;
String	 encounterID = "" ;
String	 patientClass = "" ;
String	 queueDesc = "" ;
String	 queueNumber = "" ;
//String	 sqlQueueForAEPat = "select b.short_desc from AE_PAT_EMERGENCY_DETAIL a, AE_PAT_PRIORITY b where a.FACILITY_ID=? AND a.ENCOUNTER_ID=? AND b.PRIORITY_CODE = a.PAT_PRIORITY";
String	 sqlQueueForAEPat = "select AE_GET_DESC.AE_PAT_PRIORITY(a.PAT_PRIORITY,?,'2') short_desc from AE_PAT_EMERGENCY_DETAIL a where a.FACILITY_ID=? AND a.ENCOUNTER_ID=?";
String  medServiceCode ="";
String viewList="";
String groupByMedService="";
String groupByEpisode="";
String relnreqyn="";
String past="";
String discharged="";
String unscheduledyn="";
String fromvisitdate="";
String fromdischargedate="";
String patientId = "";
String queueId = ""; //alt id1
String queueStatus = "";
String sortOrder = "";
String checkedout="";
String adm_fromdate="";
String adm_todate="";
String tovisitdate="";			
String todischargedate="";
String nationID="";
String decesedColor="";		
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
String episode_type_desc = "";
String episode_type = "";
String sex = "";
String queue_status = "";
String visit_episode_status = "";
String dateofbirth1 = "";
String DateofBirth = "";

boolean flag =true;
//32902 start
String restPatientYN	=	"";
	String ca_bean_id 						= "@CACommonGetPatientDtlBean";
	String ca_bean_name 					= "eCA.CACommonGetPatientDtlBean";
	CACommonGetPatientDtlBean bean1			= (CACommonGetPatientDtlBean)getBeanObject(ca_bean_id,ca_bean_name, request ) ;
	int accessRightsViewPatient=0;
//32902 end
String prev =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String next =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
try
{
	out.println("<form name='PatCriteriaFrm' id='PatCriteriaFrm' action='OpenChartWrapper.jsp' method = 'post' target='messageFrame'>");
	
            _bw.write(_wl_block10Bytes, _wl_block10);

	out.println("<table id='PatCriteriaTbl' class='grid' width='100%' style='margin-top: 0px'>");
	HttpSession thisSession = request.getSession(false);

	String clinicianId=(String) session.getValue("ca_practitioner_id");
	if(clinicianId == null) 
		clinicianId="";
	String facilityId = (String) thisSession.getValue("facility_id");
	String facility_id = facilityId;
	//String resp_id = (String)session.getValue("responsibility_id");
	//String user_id = (String)session.getValue("login_user");
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	java.util.Date dt=new java.util.Date();
	//Date dt=new Date();
	String Sdate = dateFormat.format( dt ) ;
	//values comming from title frame
	String orderBy = request.getParameter("orderBy")==null?"":request.getParameter("orderBy");
	//out.println(orderBy);
	String reOrder = request.getParameter("reOrder")==null?"":request.getParameter("reOrder");
	//to give scrolling effect which clicked on title for sorting
	String leftScrolling = request.getParameter("leftScrolling")==null?"":request.getParameter("leftScrolling");
	String anchorID = request.getParameter("anchorID")==null?"":request.getParameter("anchorID");
	//ends here
	checkedout = request.getParameter("checked_out")==null?"N":request.getParameter("checked_out");
	int maxNoRecords = 0;

	String attend_practId = "";
	String speciality = "";
	String visitType = request.getParameter("visitType")==null?"":request.getParameter("visitType");

	if(mode.equals("search") || mode.equals(""))//when request for search for first time
	{
		encounterType = request.getParameter("encounterType");
		medServiceCode = request.getParameter("medServiceCode");
		if(medServiceCode==null || medServiceCode.equals("null") || medServiceCode=="")	
			medServiceCode="";
		viewList = request.getParameter("viewList");
		groupByMedService=request.getParameter("groupByMedService");
		groupByEpisode=request.getParameter("groupByEpisode");
		relnreqyn = request.getParameter("reln_req_yn")==null?"Y":request.getParameter("reln_req_yn");
		past=request.getParameter("past")==null?"N":request.getParameter("past");
		discharged=request.getParameter("discharged")==null?"N":request.getParameter("discharged");
		unscheduledyn=request.getParameter("unscheduled_yn")==null?"N":request.getParameter("unscheduled_yn");
		fromvisitdate = request.getParameter("from_visit_date")==null?"":request.getParameter("from_visit_date");
		fromdischargedate = request.getParameter("from_discharge_date")==null?"":request.getParameter("from_discharge_date");
		nationID=request.getParameter("nationID")==null?"":request.getParameter("nationID");
		adm_fromdate=request.getParameter("adm_fromdate")==null?"":request.getParameter("adm_fromdate");
		adm_todate=request.getParameter("adm_todate")==null?"":request.getParameter("adm_todate");
		tovisitdate = request.getParameter("to_visit_date")==null?"":request.getParameter("to_visit_date");
		todischargedate = request.getParameter("to_discharge_date")==null?"":request.getParameter("to_discharge_date");
		patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId");
		queueId = request.getParameter("queueId")==null?"":request.getParameter("queueId");
		sortOrder = request.getParameter("sortOrder")==null?"v":request.getParameter("sortOrder");
		queueStatus = request.getParameter("queueStatus")==null?"":request.getParameter("queueStatus");

		if (queueStatus.equals("~~"))
			queueStatus = "";

		queueStatus=queueStatus.replace('~','\'');

		attend_practId = request.getParameter("attend_practId")==null?"":request.getParameter("attend_practId");
		speciality = request.getParameter("speciality")==null?"":request.getParameter("speciality");
	}
	else
	{
		encounterType=request.getParameter("encounterType1");
		medServiceCode=request.getParameter("medServiceCode1");
		if(medServiceCode==null || medServiceCode.equals("null") || medServiceCode=="")
			medServiceCode="";
		viewList=request.getParameter("viewList1");
		nationID=request.getParameter("nationID1")==null?"":request.getParameter("nationID1");
		adm_fromdate=request.getParameter("adm_fromdate1")==null?"":request.getParameter("adm_fromdate1");
		adm_todate=request.getParameter("adm_todate1")==null?"":request.getParameter("adm_todate1");
		if(adm_fromdate==null || adm_fromdate.equals("null") || adm_fromdate=="")
			adm_fromdate="";
		if(adm_todate==null || adm_todate.equals("null") || adm_todate=="")
			adm_todate="";
		tovisitdate=request.getParameter("to_visit_date1")==null?"":request.getParameter("to_visit_date1");
		todischargedate = request.getParameter("to_discharge_date1")==null?"":request.getParameter("to_discharge_date1");
		groupByMedService=request.getParameter("groupByMedService1");
		groupByEpisode=request.getParameter("groupByEpisode1");
		relnreqyn = request.getParameter("reln_req_yn1")==null?"Y":request.getParameter("reln_req_yn1");
		past=request.getParameter("past1")==null?"N":request.getParameter("past1");
		discharged=request.getParameter("discharged1")==null?"N":request.getParameter("discharged1");
		unscheduledyn=request.getParameter("unscheduled_yn1")==null?"N":request.getParameter("unscheduled_yn1");
		fromvisitdate = request.getParameter("from_visit_date1")==null?"":request.getParameter("from_visit_date1");
		fromdischargedate = request.getParameter("from_discharge_date1")==null?"":request.getParameter("from_discharge_date1");
		patientId = request.getParameter("patientId1")==null?"":request.getParameter("patientId1");
		queueId = request.getParameter("queueId1")==null?"":request.getParameter("queueId1");
		sortOrder = request.getParameter("sortOrder1")==null?"v":request.getParameter("sortOrder1");
		queueStatus = request.getParameter("queueStatus1")==null?"":request.getParameter("queueStatus1");

		if (queueStatus.equals("00")) 
			queueStatus="";

		attend_practId = request.getParameter("attend_practId1")==null?"":request.getParameter("attend_practId1");
		speciality = request.getParameter("speciality1")==null?"":request.getParameter("speciality1");
	}

	adm_fromdate = com.ehis.util.DateUtils.convertDate(adm_fromdate,"DMY",locale,"en");
	adm_todate = com.ehis.util.DateUtils.convertDate(adm_todate,"DMY",locale,"en");
	tovisitdate = com.ehis.util.DateUtils.convertDate(tovisitdate,"DMY",locale,"en");
	todischargedate = com.ehis.util.DateUtils.convertDate(todischargedate,"DMY",locale,"en");
	fromvisitdate = com.ehis.util.DateUtils.convertDate(fromvisitdate,"DMY",locale,"en");
	fromdischargedate = com.ehis.util.DateUtils.convertDate(fromdischargedate,"DMY",locale,"en");

	boolean isScroll = true;
	boolean isIP = false;
	boolean isOP = false;
	boolean floatTitle  = false;
	if(locn_type==null)
		locn_type="";
	String locn_code =	request.getParameter("locn_code");
	if(locn_code==null)
		locn_code="";
	
	if(groupByEpisode.equals("Y") && groupByMedService.equals("Y"))
	{
		floatTitle = true;
		isScroll = false;
		if(!locn_type.equals(""))
		{
			if(locn_type.equals("OP"))
			{
				isOP = true;
				encounterType = "OP";
			}
			else if(locn_type.equals("IP"))
			{
				isIP = true;
				encounterType = "IP";
			}
			else if(locn_type.equals("EM"))
			{ 
				isOP = true;
				encounterType = "EM";
			}
			else if(locn_type.equals("DC"))
			{  
				isIP = true;
				encounterType = "DC";
			}
		}
		if(!locn_code.equals(""))
		{
			medServiceCode = locn_code;
		}
	}
	else if(groupByEpisode.equals("Y") && groupByMedService.equals("N"))
	{
		if(!locn_type.equals(""))
		{
			if(locn_type.equals("OP"))
			{
				isOP = true;
				encounterType = "OP";
			}
			else if(locn_type.equals("IP"))
			{
				isIP = true;
				encounterType = "IP";
			}
			else if(locn_type.equals("DC"))
			{
				isIP = true;
				encounterType = "DC";
			}
			else if(locn_type.equals("EM"))
			{
				isOP = true;
				encounterType = "EM";
			}
		}
	/*	if(!locn_code.equals(""))
		{
			medServiceCode = "";
		} */
	}
	/*else
	{
		if(!locn_code.equals(""))
		{
			medServiceCode = "";
		}
	} */
	
	StringBuffer QueryString = new StringBuffer();
	StringBuffer OPQueryString = new StringBuffer();
	StringBuffer IPQueryString = new StringBuffer();
	//OPQueryString.append(" select decode(A.PATIENT_CLASS,'OP','Outpatient','IP','Inpatient','EM','Emergency','DC','Day Care',' ')  episode_type_desc,'O' episode_type,patient_id,replace(patient_name,'''','') patient_name,to_char(dob,'dd/mm/yyyy') dob,age,decode(sex,'F','Female','M','Male','Unknown')sex, locn_type,locn_code, locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(physician_id,'*ALL') physician_id,physician_name,service_code splty_code,nvl(service_short_desc,'Not Specified') splty_name, to_char(adm_visit_date,'dd/mm/yyyy hh24:mi')adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,to_number('') visit_id,vis_adm_type_code,visit_episode_status,nvl(appt_time,'&nbsp;')appt_time,nvl(decode(queue_num,'','&nbsp;','null','&nbsp;',queue_num),'')queue_num,nvl(decode(queue_status,'01','Checked-in','02','Arrived At NS','03','Vital Sign Recorded','04','Consultation in Progress','05','Treat/Invest','06','Returned from Invest','07','Checked Out','null','&nbsp;','','&nbsp;'),'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME  ,decode(ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(adm_visit_date) visit_date,'1' SECURITY_LEVEL,'1' PROTECTION_IND  ,(replace(patient_name,'''','')||','||AGE||','||decode(SEX,'M','Male','F','Female','Unknown')) p_line  ,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?) STATUS,patient_class, adm_visit_date orderbydate  ,REFERRAL_ID , dob actual_dob,adm_visit_date adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date, /*NVL((SELECT 'Y' FROM MP_PATIENT WHERE PATIENT_ID=a.patient_id AND SECURITY_LEVEL <=f_pr_security_level('"+user_id+"','"+facility_id+"','"+resp_id+"')),'N') */ 'Y' access_yn,PRIORITY_ZONE from CA_OP_EPISODE_VW a Where a.facility_id =? and a.patient_id = nvl(?,a.patient_id)  and  nvl(a.NATIONAL_ID_NO,'X') = nvl(?,nvl(a.NATIONAL_ID_NO,'X'))   and NVL(a.alt_id1_no,'X') = nvl(?,NVL(a.alt_id1_no,'X')) and queue_status >= nvl(DISP_IN_CA_QUEUE_AFTER,queue_status)  ");
	
	//OPQueryString.append("select A.PATIENT_CLASS episode_type_desc,'O' episode_type,a.patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(a.dob,'dd/mm/yyyy') dob,a.age,a.sex, a.locn_type,a.locn_code, OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.locn_code,?,'1') locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(a.physician_id,'*ALL') physician_id,b.PRACTITIONER_NAME PHYSICIAN_NAME,a.service_code splty_code,nvl(service_short_desc,'Not Specified') splty_name, to_char(a.adm_visit_date,'dd/mm/yyyy hh24:mi')adm_visit_date,to_char(a.discharge_date_time,'dd/mm/yyyy') discharge_date_time,a.episode_id,to_number('') visit_id,a.vis_adm_type_code,a.visit_episode_status,nvl(a.appt_time,'&nbsp;')appt_time,nvl(decode(a.queue_num,'','&nbsp;','null','&nbsp;',queue_num),'')queue_num,nvl(a.queue_status,'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME  ,decode(a.ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(a.adm_visit_date) visit_date,'1' SECURITY_LEVEL,'1' PROTECTION_IND  ,(replace(A.patient_name,'''','')||','||A.AGE||','||A.SEX) p_line  ,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?) STATUS,A.patient_class, A.adm_visit_date orderbydate  ,A.REFERRAL_ID , A.dob actual_dob,A.adm_visit_date adm_date1, to_char(A.discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date,  'Y' access_yn,A.PRIORITY_ZONE from CA_OP_EPISODE_VW a, AM_PRACTITIONER_LANG_VW B Where B.LANGUAGE_ID(+) = ? AND B.PRACTITIONER_ID(+) = A.PHYSICIAN_ID and  a.facility_id =? and a.patient_id = nvl(?,a.patient_id)  and  nvl(a.NATIONAL_ID_NO,'X') = nvl(?,nvl(a.NATIONAL_ID_NO,'X'))   and NVL(a.alt_id1_no,'X') = nvl(?,NVL(a.alt_id1_no,'X')) and queue_status >= nvl(DISP_IN_CA_QUEUE_AFTER,queue_status)");
	
	//OPQueryString.append("select A.PATIENT_CLASS episode_type_desc,'O' episode_type,a.patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(a.dob,'dd/mm/yyyy') dob,a.age,a.sex,a.locn_type,a.locn_code,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.locn_code,?,'1') locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(a.physician_id,'*ALL') physician_id,AM_GET_DESC.AM_PRACTITIONER(physician_id,?,'2') physician_name,a.service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'&nbsp;')  splty_name, to_char(a.adm_visit_date,'dd/mm/yyyy hh24:mi')adm_visit_date,to_char(a.discharge_date_time,'dd/mm/yyyy') discharge_date_time,a.episode_id, visit_id,a.vis_adm_type_code,a.visit_episode_status,nvl(a.appt_time,'&nbsp;')appt_time,nvl(decode(queue_num,'','&nbsp;','null','&nbsp;','0','&nbsp;',queue_num),'')queue_num,nvl(a.queue_status,'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME  ,decode(a.ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(a.adm_visit_date) visit_date,null SECURITY_LEVEL,null PROTECTION_IND  ,(replace(A.patient_name,'''','')||','||A.AGE||','||A.SEX) p_line  ,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) STATUS,A.patient_class, A.adm_visit_date orderbydate  ,A.REFERRAL_ID , A.dob actual_dob,A.adm_visit_date adm_date1, to_char(A.discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date,A.PRIORITY_ZONE from CA_OP_EPISODE_VW a Where a.facility_id =? and a.patient_id = nvl(?,a.patient_id)  and  nvl(a.NATIONAL_ID_NO,'X') = nvl(?,nvl(a.NATIONAL_ID_NO,'X'))   and NVL(a.alt_id1_no,'X') = nvl(?,NVL(a.alt_id1_no,'X')) and queue_status >= nvl(DISP_IN_CA_QUEUE_AFTER,queue_status)");
	/****MODIFIED BY Deepa on 1/27/2010 at 11:16 AM for MF performance issue*******************/
	//OPQueryString.append("select A.PATIENT_CLASS episode_type_desc,'O' episode_type,a.patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(a.dob,'dd/mm/yyyy') dob,get_age (a.dob,NVL (a.deceased_date, SYSDATE)) age,a.sex,a.locn_type,a.locn_code,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.locn_code,?,'1') locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(a.physician_id,'*ALL') physician_id,AM_GET_DESC.AM_PRACTITIONER(physician_id,?,'2') physician_name,a.service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'&nbsp;')  splty_name, to_char(a.adm_visit_date,'dd/mm/yyyy hh24:mi')adm_visit_date,to_char(a.discharge_date_time,'dd/mm/yyyy') discharge_date_time,a.episode_id, visit_id,a.vis_adm_type_code,a.visit_episode_status,nvl(a.appt_time,'&nbsp;')appt_time,nvl(decode(queue_num,'','&nbsp;','null','&nbsp;','0','&nbsp;',queue_num),'')queue_num,nvl(a.queue_status,'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME  ,decode(a.ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(a.adm_visit_date) visit_date,null SECURITY_LEVEL,null PROTECTION_IND  ,(replace(A.patient_name,'''','')||','||A.AGE||','||A.SEX) p_line  ,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) STATUS,A.patient_class, A.adm_visit_date orderbydate  ,A.REFERRAL_ID , A.dob actual_dob,A.adm_visit_date adm_date1, to_char(A.discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date,A.PRIORITY_ZONE, OP_GET_DESC.OP_VISIT_TYPE(?,VIS_ADM_TYPE_CODE,?,1) visit_type from CA_OP_EPISODE_VW a Where a.facility_id =? and a.patient_id = nvl(?,a.patient_id)  and  nvl(a.NATIONAL_ID_NO,'X') = nvl(?,nvl(a.NATIONAL_ID_NO,'X'))   and NVL(a.alt_id1_no,'X') = nvl(?,NVL(a.alt_id1_no,'X')) and queue_status >= nvl(DISP_IN_CA_QUEUE_AFTER,queue_status)");
	/****MODIFIED BY Deepa on 1/27/2010 at 11:16 AM for MF performance issue*******************/
	//OPQueryString.append("select A.PATIENT_CLASS episode_type_desc,'O' episode_type,a.patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(a.dob,'dd/mm/yyyy') dob,get_age (a.dob,NVL (a.deceased_date, SYSDATE)) age,a.sex,a.locn_type,a.locn_code,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.locn_code,?,'1') locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(a.physician_id,'*ALL') physician_id,AM_GET_DESC.AM_PRACTITIONER(physician_id,?,'2') physician_name,a.service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'&nbsp;')  splty_name, to_char(a.adm_visit_date,'dd/mm/yyyy hh24:mi')adm_visit_date,to_char(a.discharge_date_time,'dd/mm/yyyy') discharge_date_time,a.episode_id, visit_id,a.vis_adm_type_code,a.visit_episode_status,nvl(a.appt_time,'&nbsp;')appt_time,nvl(decode(queue_num,'','&nbsp;','null','&nbsp;','0','&nbsp;',queue_num),'')queue_num,nvl(a.queue_status,'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME  ,decode(a.ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(a.adm_visit_date) visit_date,null SECURITY_LEVEL,null PROTECTION_IND  ,(replace(A.patient_name,'''','')||','||A.AGE||','||A.SEX) p_line  ,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) STATUS,A.patient_class, A.adm_visit_date orderbydate  ,A.REFERRAL_ID , A.dob actual_dob,A.adm_visit_date adm_date1, to_char(A.discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date,A.PRIORITY_ZONE, OP_GET_DESC.OP_VISIT_TYPE(?,VIS_ADM_TYPE_CODE,?,1) visit_type,ca_ae_get_priority_zone_color(A.PRIORITY_ZONE,'en') ae_zone_color,oa_appt_virtual_status(a.facility_id,a.patient_id,a.episode_id,a.patient_class) virtualApptYN  from CA_OP_EPISODE_VW a Where a.facility_id =? and a.patient_id = nvl(?,a.patient_id)  and  nvl(a.NATIONAL_ID_NO,'X') = nvl(?,nvl(a.NATIONAL_ID_NO,'X'))   and NVL(a.alt_id1_no,'X') = nvl(?,NVL(a.alt_id1_no,'X')) and queue_status >= nvl(DISP_IN_CA_QUEUE_AFTER,queue_status)");//32902
	OPQueryString.append("select A.PATIENT_CLASS episode_type_desc,'O' episode_type,a.patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(a.dob,'dd/mm/yyyy') dob,get_age (a.dob,NVL (a.deceased_date, SYSDATE)) age,a.sex,a.locn_type,a.locn_code,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID,a.locn_code,?,'1') locn_name,null file_num,'&nbsp;' room_num,'&nbsp;' bed_num,nvl(a.physician_id,'*ALL') physician_id,AM_GET_DESC.AM_PRACTITIONER(physician_id,?,'2') physician_name,a.service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(service_code,?,'2') ,'&nbsp;')  splty_name, to_char(a.adm_visit_date,'dd/mm/yyyy hh24:mi')adm_visit_date,to_char(a.discharge_date_time,'dd/mm/yyyy') discharge_date_time,a.episode_id, visit_id,a.vis_adm_type_code,a.visit_episode_status,nvl(a.appt_time,'&nbsp;')appt_time,nvl(decode(queue_num,'','&nbsp;','null','&nbsp;','0','&nbsp;',queue_num),'')queue_num,nvl(a.queue_status,'&nbsp;')queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME  ,decode(a.ACTUAL_PHYSICIAN_ID,'*ALL',null,'2') ACTUAL_PHYSICIAN_ID,trunc(a.adm_visit_date) visit_date,null SECURITY_LEVEL,null PROTECTION_IND  ,(replace(A.patient_name,'''','')||','||A.AGE||','||A.SEX) p_line  ,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) STATUS,A.patient_class, A.adm_visit_date orderbydate  ,A.REFERRAL_ID , A.dob actual_dob,A.adm_visit_date adm_date1, to_char(A.discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date,A.PRIORITY_ZONE, OP_GET_DESC.OP_VISIT_TYPE(?,VIS_ADM_TYPE_CODE,?,1) visit_type,ca_ae_get_priority_zone_color(A.PRIORITY_ZONE,'en') ae_zone_color,oa_appt_virtual_status(a.facility_id,a.patient_id,a.episode_id,a.patient_class) virtualApptYN,a.restrict_reinstate_yn  from CA_OP_EPISODE_VW a Where a.facility_id =? and a.patient_id = nvl(?,a.patient_id)  and  nvl(a.NATIONAL_ID_NO,'X') = nvl(?,nvl(a.NATIONAL_ID_NO,'X'))   and NVL(a.alt_id1_no,'X') = nvl(?,NVL(a.alt_id1_no,'X')) and queue_status >= nvl(DISP_IN_CA_QUEUE_AFTER,queue_status)");//32902

	if (queueStatus.equals(""))
	{
		OPQueryString.append(" and a.queue_status  in ( null )   ");
	}
	else
	{
		OPQueryString.append(" and a.queue_status  in ( ");
		OPQueryString.append(queueStatus);
		OPQueryString.append(	" ) " );
	}
	if (groupByEpisode.equals("Y"))
	{
		OPQueryString.append(" and a.PATIENT_CLASS =  ?   ");
	}
	if(!(unscheduledyn.equals("Y")))
		OPQueryString.append( " and ACTUAL_PHYSICIAN_ID != '*ALL' and ");
	else if(unscheduledyn.equals("Y")) 
		OPQueryString.append( "and 'Y' = decode(ACTUAL_PHYSICIAN_ID,'*ALL',CA_GET_UNASSIGN_LOCN_APPL(a.facility_id,a.UNASSIGN_PATIENT_YN, '"+clinicianId+"', a.locn_type, a.locn_code, a.patient_class),'Y')  and ");
	if(checkedout.equals("Y"))
		//OPQueryString.append( " episode_type='O' and  visit_episode_status BETWEEN '00' AND '07' ");
	/****MODIFIED BY Deepa on 1/27/2010 at 11:20 AM for MF performance issue*****/
		OPQueryString.append( " episode_type='O' and  visit_episode_status BETWEEN '00' AND '09' ");
	/****MODIFIED BY Deepa on 1/27/2010 at 11:20 AM for MF performance issue*****/
	else
		OPQueryString.append( " episode_type='O' and  visit_episode_status BETWEEN '00' AND '06'  ");

	if (past.equals("N")||past.equals(""))
		OPQueryString.append(" and adm_visit_date between trunc(sysdate) and trunc(sysdate)+1 ");
	else
	{
		if (!fromvisitdate.equals(""))
		{
			OPQueryString.append( " and adm_visit_date >= to_date(?,'dd/mm/yyyy') ");
		}
		if (!tovisitdate.equals(""))
		{
			OPQueryString.append( " and adm_visit_date <= to_date(?,'dd/mm/yyyy')+.9999 ");
		}
	}
	if(viewList.equals("S")) 
	{
		OPQueryString.append(  " and PHYSICIAN_ID=? ");
	}
	//if (groupByMedService.equals("Y") || (!medServiceCode.equals("ALL")))
	if ((!medServiceCode.equals("ALL")))
		OPQueryString.append(" and  SERVICE_CODE =? ");	
	
	if(!attend_practId.equals(""))
	{
		OPQueryString.append(  " and PHYSICIAN_ID=? ");
	}
	if(!speciality.equals(""))
	{
		OPQueryString.append(" and SPECIALTY_CODE = ? ");
	}
	if(encounterType.equals("OP")){
		if(!visitType.equals(""))
		{
			OPQueryString.append(" and VIS_ADM_TYPE_CODE = ? "); // visitType
		}
	}
	OPQueryString.append("  AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,a.patient_id,a.facility_id) "); //32902
	//IPQueryString.append(" select decode(A.PATIENT_CLASS,'OP','Outpatient','IP','Inpatient','EM','Emergency','DC','Daycare',' ')  episode_type_desc,'I' episode_type,patient_id,replace(patient_name,'''','') patient_name,to_char(dob,'dd/mm/yyyy') dob,age,decode(sex,'F','Female','M','Male','Unknown')sex, locn_type,CUR_WARD_CODE locn_code, WARD_SHORT_DESC locn_name,null file_num,nvl(CUR_ROOM_NUM,'&nbsp;')room_num,nvl(CUR_BED_NUM,'&nbsp;')bed_num,CUR_PHYSICIAN_ID physician_id,PHYSICIAN_SHORT_NAME physician_name,service_code splty_code,nvl(service_short_desc,'Not Specified') splty_name, to_char(ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi')adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,to_number('') visit_id,ADMISSION_TYPE_CODE vis_adm_type_code, ADT_STATUS visit_episode_status,'&nbsp;' appt_time,'&nbsp;'queue_num,case when a.adt_status='08' then 'Discharged' when  (select 'Y' from ip_discharge_adviCe            where facility_id=a.facility_id and encounter_id=a.EPISODE_ID and DIS_ADV_STATUS='0' and rownum=1)='Y' then 'Dicharge advice Prepard'  when  (select 'Y' from pr_problem where ONSET_FACILITY_ID=a.facility_id and ONSET_ENCOUNTER_ID = a.EPISODE_ID  and rownum=1 and NVL(ERROR_YN,'N')='N')='Y' then 'Diagnosis Recorded'       when a.CUR_BED_NUM is not null then 'Bed Assigned' else 'Admitted' end queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME  , NULL ACTUAL_PHYSICIAN_ID ,trunc(ADMISSION_DATE_TIME) visit_date,'1' SECURITY_LEVEL,'1' PROTECTION_IND  ,(replace(patient_name,'''','')||','||AGE||','||decode(SEX,'M','Male','F','Female','Unknown')) p_line  ,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?) status ,patient_class, ADMISSION_DATE_TIME orderbydate ,REFERRAL_ID , dob actual_dob,ADMISSION_DATE_TIME adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date, /*NVL((SELECT 'Y' FROM MP_PATIENT WHERE PATIENT_ID=a.patient_id AND SECURITY_LEVEL <=f_pr_security_level('"+user_id+"','"+facility_id+"','"+resp_id+"')),'N') */ 'Y' access_yn, null PRIORITY_ZONE from CA_IP_ACTIVE_EPISODE_VW a Where a.facility_id =? and a.patient_id = nvl(?,a.patient_id)  and  nvl(a.NATIONAL_ID_NO,'X') = nvl(?,nvl(a.NATIONAL_ID_NO,'X'))  and NVL(a.alt_id1_no,'X') = nvl(?,NVL(a.alt_id1_no,'X'))  ");
	
	
	//IPQueryString.append(" select A.PATIENT_CLASS episode_type_desc,'I' episode_type,a.patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(a.dob,'dd/mm/yyyy') dob,a.age,a.sex, a.locn_type,a.CUR_WARD_CODE locn_code, IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.CUR_WARD_CODE,?,'1')  locn_name,null file_num,nvl(A.CUR_ROOM_NUM,'&nbsp;')room_num,nvl(A.CUR_BED_NUM,'&nbsp;')bed_num,A.CUR_PHYSICIAN_ID physician_id,AM_GET_DESC.AM_PRACTITIONER(A.CUR_PHYSICIAN_ID,?,'2') physician_name,A.service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2'),'Not Specified') splty_name, to_char(ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi')adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,to_number('') visit_id,ADMISSION_TYPE_CODE vis_adm_type_code, ADT_STATUS visit_episode_status,'&nbsp;' appt_time,'&nbsp;'queue_num,case when a.adt_status='08' then 'Discharged' when  (select 'Y' from ip_discharge_adviCe      where facility_id=a.facility_id and encounter_id=a.EPISODE_ID and DIS_ADV_STATUS='0' and rownum=1)='Y' then 'Dicharge advice Prepard'  when  (select 'Y' from pr_problem where ONSET_FACILITY_ID=a.facility_id and ONSET_ENCOUNTER_ID = a.EPISODE_ID  and rownum=1 and NVL(ERROR_YN,'N')='N')='Y' then 'Diagnosis Recorded'       when a.CUR_BED_NUM is not null then 'Bed Assigned' else 'Admitted' end queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME  , NULL ACTUAL_PHYSICIAN_ID ,trunc(a.ADMISSION_DATE_TIME) visit_date,'1' SECURITY_LEVEL,'1' PROTECTION_IND  ,(replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','')||','||a.AGE||','||a.SEX) p_line  ,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?) status ,patient_class, ADMISSION_DATE_TIME orderbydate ,REFERRAL_ID , dob actual_dob,ADMISSION_DATE_TIME adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date, 'Y' access_yn, null PRIORITY_ZONE from CA_IP_ACTIVE_EPISODE_VW a Where a.facility_id =? and a.patient_id = nvl(?,a.patient_id)  and  nvl(a.NATIONAL_ID_NO,'X') = nvl(?,nvl(a.NATIONAL_ID_NO,'X'))  and NVL(a.alt_id1_no,'X') = nvl(?,NVL(a.alt_id1_no,'X'))  ");
	//IPQueryString.append("select A.PATIENT_CLASS episode_type_desc,'I' episode_type,a.patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(a.dob,'dd/mm/yyyy') dob,a.age,a.sex, a.locn_type,a.CUR_WARD_CODE locn_code, IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.CUR_WARD_CODE,?,'1')  locn_name,null file_num,nvl(A.CUR_ROOM_NUM,'&nbsp;')room_num,nvl(A.CUR_BED_NUM,'&nbsp;')bed_num,A.CUR_PHYSICIAN_ID physician_id,AM_GET_DESC.AM_PRACTITIONER(A.CUR_PHYSICIAN_ID,?,'2') physician_name,A.service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'1'),'&nbsp;') splty_name, to_char(ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi')adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,to_number('') visit_id,ADMISSION_TYPE_CODE vis_adm_type_code, case when a.adt_status in ('00','08') then case when a.adt_status='08' then 'DS' when a.CUR_BED_NUM is not null then 'BA' else 'AD' end when a.adt_status='01' then  case when  (select 'Y' from ip_discharge_advice where facility_id=a.facility_id and encounter_id=a.EPISODE_ID and DIS_ADV_STATUS='0' and rownum=1)='Y' then 'AP' when  (select 'Y' from PR_DIAGNOSIS_ENC_DTL where FACILITY_ID=a.facility_id and  ENCOUNTER_ID = a.EPISODE_ID  and rownum=1 and status!='E' ) = 'Y' then 'DR' else case when a.CUR_BED_NUM is not null then 'BA' else 'AD' end end end visit_episode_status,'&nbsp;' appt_time,'&nbsp;'queue_num, a.adt_status queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME  , a.CUR_PHYSICIAN_ID ACTUAL_PHYSICIAN_ID ,trunc(a.ADMISSION_DATE_TIME) visit_date,null SECURITY_LEVEL,null PROTECTION_IND  ,(replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','')||','||a.AGE||','||a.SEX) p_line  ,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) status ,patient_class, ADMISSION_DATE_TIME orderbydate ,REFERRAL_ID , dob actual_dob,ADMISSION_DATE_TIME adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date, null PRIORITY_ZONE,'' visit_type ");
	
	//IPQueryString.append("select A.PATIENT_CLASS episode_type_desc,'I' episode_type,a.patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(a.dob,'dd/mm/yyyy') dob,a.age,a.sex, a.locn_type,a.CUR_WARD_CODE locn_code, IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.CUR_WARD_CODE,?,'1')  locn_name,null file_num,nvl(A.CUR_ROOM_NUM,'&nbsp;')room_num,nvl(A.CUR_BED_NUM,'&nbsp;')bed_num,A.CUR_PHYSICIAN_ID physician_id,AM_GET_DESC.AM_PRACTITIONER(A.CUR_PHYSICIAN_ID,?,'2') physician_name,A.service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'1'),'&nbsp;') splty_name, to_char(ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi')adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,to_number('') visit_id,ADMISSION_TYPE_CODE vis_adm_type_code, case when a.adt_status in ('00','08') then case when a.adt_status='08' then 'DS' when a.CUR_BED_NUM is not null then 'BA' else 'AD' end when a.adt_status='01' then  case when  (select 'Y' from ip_discharge_advice where facility_id=a.facility_id and encounter_id=a.EPISODE_ID and DIS_ADV_STATUS='0' and rownum=1)='Y' then 'AP' when  (select 'Y' from PR_DIAGNOSIS_ENC_DTL where FACILITY_ID=a.facility_id and  ENCOUNTER_ID = a.EPISODE_ID  and rownum=1 and status!='E' ) = 'Y' then 'DR' else case when a.CUR_BED_NUM is not null then 'BA' else 'AD' end end end visit_episode_status,'&nbsp;' appt_time,'&nbsp;'queue_num, a.adt_status queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME  , a.CUR_PHYSICIAN_ID ACTUAL_PHYSICIAN_ID ,trunc(a.ADMISSION_DATE_TIME) visit_date,null SECURITY_LEVEL,null PROTECTION_IND  ,(replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','')||','||a.AGE||','||a.SEX) p_line  ,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) status ,patient_class, ADMISSION_DATE_TIME orderbydate ,REFERRAL_ID , dob actual_dob,ADMISSION_DATE_TIME adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date, null PRIORITY_ZONE,'' visit_type,'' ae_zone_color, 'N' virtualApptYN  ");//IN044157
		IPQueryString.append("select A.PATIENT_CLASS episode_type_desc,'I' episode_type,a.patient_id,replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','') patient_name,to_char(a.dob,'dd/mm/yyyy') dob,a.age,a.sex, a.locn_type,a.CUR_WARD_CODE locn_code, IP_GET_DESC.IP_NURSING_UNIT(A.FACILITY_ID,A.CUR_WARD_CODE,?,'1')  locn_name,null file_num,nvl(A.CUR_ROOM_NUM,'&nbsp;')room_num,nvl(A.CUR_BED_NUM,'&nbsp;')bed_num,A.CUR_PHYSICIAN_ID physician_id,AM_GET_DESC.AM_PRACTITIONER(A.CUR_PHYSICIAN_ID,?,'2') physician_name,A.service_code splty_code,nvl(AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'1'),'&nbsp;') splty_name, to_char(ADMISSION_DATE_TIME,'dd/mm/yyyy hh24:mi')adm_visit_date,to_char(discharge_date_time,'dd/mm/yyyy') discharge_date_time,episode_id,to_number('') visit_id,ADMISSION_TYPE_CODE vis_adm_type_code, case when a.adt_status in ('00','08') then case when a.adt_status='08' then 'DS' when a.CUR_BED_NUM is not null then 'BA' else 'AD' end when a.adt_status='01' then  case when  (select 'Y' from ip_discharge_advice where facility_id=a.facility_id and encounter_id=a.EPISODE_ID and DIS_ADV_STATUS='0' and rownum=1)='Y' then 'AP' when  (select 'Y' from PR_DIAGNOSIS_ENC_DTL where FACILITY_ID=a.facility_id and  ENCOUNTER_ID = a.EPISODE_ID  and rownum=1 and status!='E' ) = 'Y' then 'DR' else case when a.CUR_BED_NUM is not null then 'BA' else 'AD' end end end visit_episode_status,'&nbsp;' appt_time,'&nbsp;'queue_num, a.adt_status queue_status,to_char(SYSDATE,'hh24:mi:ss') QRYTIME  , a.CUR_PHYSICIAN_ID ACTUAL_PHYSICIAN_ID ,trunc(a.ADMISSION_DATE_TIME) visit_date,null SECURITY_LEVEL,null PROTECTION_IND  ,(replace(decode(?,'en',PATIENT_NAME,nvl(PATIENT_NAME_LOC_LANG,PATIENT_NAME)),'''','')||','||a.AGE||','||a.SEX) p_line  ,CA_GET_PATIENT_CURR_STATUS(a.facility_id,a.patient_id,a.EPISODE_ID,a.PATIENT_CLASS,?,a.DECEASED_YN) status ,patient_class, ADMISSION_DATE_TIME orderbydate ,REFERRAL_ID , dob actual_dob,ADMISSION_DATE_TIME adm_date1, to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') cls_cons_date, null PRIORITY_ZONE,'' visit_type,'' ae_zone_color, 'N' virtualApptYN,a.restrict_reinstate_yn  ");//32902

	if (discharged.equals("Y"))
	{
	IPQueryString.append("from CA_IP_EPISODE_VW a");
	}
	else
	{
	IPQueryString.append("from CA_IP_ACTIVE_EPISODE_VW a");
	}

	IPQueryString.append(" Where a.facility_id =? and a.patient_id = nvl(?,a.patient_id)  and  nvl(a.NATIONAL_ID_NO,'X') = nvl(?,nvl(a.NATIONAL_ID_NO,'X'))  and NVL(a.alt_id1_no,'X') = nvl(?,NVL(a.alt_id1_no,'X'))  ");

	if (groupByEpisode.equals("Y"))
	{
		IPQueryString.append(" and a.PATIENT_CLASS  =  ? ");
	}
		IPQueryString.append(" and ( a.adt_status in ('01','02') ");
	
	if (discharged.equals("Y"))
	{
		IPQueryString.append(" OR  a.adt_status in ('08')  ");
	
		if (!fromdischargedate.equals("")&&(!todischargedate.equals("")))
		{
			IPQueryString.append(" and discharge_date_time between to_date('");
			IPQueryString.append(fromdischargedate);
			IPQueryString.append("','dd/mm/yyyy')  ");
			IPQueryString.append(" and  to_date('");
			IPQueryString.append(todischargedate);
			IPQueryString.append("','dd/mm/yyyy')+.9999  ");
			
		}
	
	}
	else if (discharged.equals("N")||discharged.equals(""))
	{
		IPQueryString.append(" and discharge_date_time  is null ");
	}
	    IPQueryString.append(" ) ");
	
	/*
	else
	{
		
		
		
		if (!fromdischargedate.equals(""))
		{
			IPQueryString.append(" and trunc(nvl(discharge_date_time,sysdate)) >= to_date('");
			IPQueryString.append(fromdischargedate);
			IPQueryString.append("','dd/mm/yyyy')  ");
		}
		if (!todischargedate.equals(""))
		{			
			IPQueryString.append(" and trunc(nvl(discharge_date_time,sysdate))<= to_date('");
			IPQueryString.append(todischargedate);
			IPQueryString.append("','dd/mm/yyyy')+.9999  ");
		} 
	}
	*/
	if(!medServiceCode.equals("ALL") ) 
	{
		IPQueryString.append(  " and SERVICE_CODE=?  "); 
	}
	if(viewList.equals("S")) 
	{
		IPQueryString.append(  " and CUR_PHYSICIAN_ID=? ");
	}

	if (!adm_fromdate.equals(""))
	{
		IPQueryString.append( " and ADMISSION_DATE_TIME >= to_date(?,'dd/mm/yyyy') ");
	}
	if (!adm_todate.equals(""))
		IPQueryString.append( " and ADMISSION_DATE_TIME <= to_date(?,'dd/mm/yyyy')+.9999 "	);
	if(!attend_practId.equals(""))
	{
		IPQueryString.append(  " and CUR_PHYSICIAN_ID = ? ");
	}
	if(!speciality.equals(""))
	{
		IPQueryString.append(" and SPECIALTY_CODE = ? ");
	}
	IPQueryString.append(" AND 'N' =CA_GET_RESTRICTED_PATIENTS_YN(?,a.patient_id,a.facility_id) ");//32902

	if(encounterType.equals("Z"))
	{
		QueryString.append(OPQueryString.toString());
		QueryString.append(" UNION ALL ");
		QueryString.append(IPQueryString.toString());
	}
	else if(encounterType.equals("OP"))
		QueryString.append(OPQueryString.toString());
	else if(encounterType.equals("IP"))
		QueryString.append(IPQueryString.toString());
	else if(encounterType.equals("EM"))
		QueryString.append(OPQueryString.toString());
	else if(encounterType.equals("DC"))
		QueryString.append(IPQueryString.toString());
	//added by ankur
	String desc="";
	if(reOrder.equals("2"))
		desc=" desc";
	if(orderBy.equals("PC"))
	{
		QueryString.append( " Order By episode_type_desc");
		QueryString.append(desc);
	}
	else if(orderBy.equals("LOC"))
	{
		QueryString.append( " Order By locn_name");
		QueryString.append(desc);
	}
	else if(orderBy.equals("PN"))
	{
		QueryString.append( " Order By 4");
		QueryString.append(desc);
	}
	else if(orderBy.equals("SAP"))
	{
		QueryString.append( " Order By splty_name");
		QueryString.append(desc);
	}
	else if(orderBy.equals("DOB"))
	{
		QueryString.append( " Order By actual_dob");
		QueryString.append(desc);
	}
	else if(orderBy.equals("AGE"))
	{
		if(reOrder.equals("1"))
		{
			QueryString.append( " Order By actual_dob desc");
		}
		else
			QueryString.append( " Order By actual_dob");
	}
	else if(orderBy.equals("SEX"))
	{
		QueryString.append( " Order By 7");
		QueryString.append(desc);
	}
	else if(orderBy.equals("PID"))
	{
		QueryString.append( " Order By 3");
		QueryString.append(desc);
	}
	else if(orderBy.equals("AD"))
	{
		QueryString.append( " Order By adm_date1");
		QueryString.append(desc);
	}
	else if(orderBy.equals("RN"))
	{
		QueryString.append( " Order By 12");
		QueryString.append(desc);
	}
	else if(orderBy.equals("BN"))
	{
		QueryString.append( " Order By 13");
		QueryString.append(desc);
	}
	else if(orderBy.equals("RID"))
	{
		QueryString.append( " Order By referral_id");
		QueryString.append(desc);
	}
	else if(orderBy.equals("AP"))
	{
		QueryString.append( " Order By physician_name");
		QueryString.append(desc);
	}
	else if(orderBy.equals("MS"))
	{
		QueryString.append( " Order By splty_name");
		QueryString.append(desc);
	}
	else if(orderBy.equals("AT"))
	{
		QueryString.append( " Order By appt_time");
		QueryString.append(desc);
	}
	else if(orderBy.equals("QN"))
	{
		QueryString.append( " Order By lpad(queue_num,6,0) ");
		QueryString.append(desc);
	}
	else if(orderBy.equals("VD"))
	{
		QueryString.append( " Order By orderbydate");
		QueryString.append(desc);
	}
	else if(orderBy.equals("VT"))
	{
		// Uncommented by USH
		QueryString.append(" Order By visit_type ");
		QueryString.append(desc);
	}
	else if(orderBy.equals("QS"))
	{
		QueryString.append( " Order By queue_status");
		QueryString.append(desc);
	}
	else if(orderBy.equals("IQS")) // added for queue status for IP and DC
	{
		QueryString.append(" Order by queue_status ");
		QueryString.append(desc);
	}
	else if(orderBy.equals("DD"))
	{
				QueryString.append( " Order By discharge_date_time");
				QueryString.append(desc);
	}
	else if(orderBy.equals("LOC"))
	{
		QueryString.append( " Order By PHYSICIAN_NAME");
		QueryString.append(desc);
	}

	else if(groupByEpisode.equals("N") && groupByMedService.equals("N"))
	{
		if (sortOrder.equals("v"))
			QueryString.append( " Order By orderbydate");
		else if(sortOrder.equals("p"))
			QueryString.append( " Order By 4");
	}
	else if(groupByEpisode.equals("Y") && groupByMedService.equals("N"))
	{
		if (sortOrder.equals("v"))
			QueryString.append( " Order By 2 desc,orderbydate,28 ,4");
		else if(sortOrder.equals("p"))
			QueryString.append( " Order By 2 desc,4,28,orderbydate");
	}
	else 
	{
		if (sortOrder.equals("v"))
			QueryString.append( " Order By 2 desc ,10,orderbydate,28,4");
		else if(sortOrder.equals("p"))
			QueryString.append( " Order By 2 desc ,10,4,28,orderbydate");
	}
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounterType));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(medServiceCode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(viewList));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(groupByMedService));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(groupByEpisode));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(relnreqyn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(past));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(discharged));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(unscheduledyn));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(fromvisitdate));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fromdischargedate));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(checkedout));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(queueId));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(sortOrder));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(queueStatus));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(nationID));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(adm_fromdate));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(adm_todate));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(tovisitdate));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(todischargedate));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(attend_practId));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block34Bytes, _wl_block34);
     
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
	
	con = ConnectionManager.getConnection(request);
	
	boolean isVirtualConsSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION"); //37866
	
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
	PreparedStatement stmtPatList =null;
	stmtPatList = con.prepareStatement(QueryString.toString());
	

	ResultSet rsPatList = null;
	

	StringBuffer layer = new StringBuffer();
	//String sqlMotherLink =  "   select a.patient_id pat_id , replace(decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)),'''','') short_name , to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth , to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH  , a.WEIGHT  , a.WEIGHT_UNIT  , a.LENGTH||' cms'  LENGTH_OF_BABY  , a.CIRCUMFERENCE||' cms'  CIRCUMFERENCE_OF_HEAD  , a.APGAR_SCORE  , b.sex  from  mp_birth_register a  ,mp_patient b  where  b.patient_id=a.patient_id  and a.MOTHER_PATIENT_ID = ?  and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by TIME_OF_BIRTH ";
	String sqlMotherLink =  "   select a.patient_id pat_id , replace(decode(?,'en',b.PATIENT_NAME,nvl(b.PATIENT_NAME_LOC_LANG,b.PATIENT_NAME)),'''','') short_name , to_char(b.date_of_birth,'dd/mm/yyyy') date_of_birth , to_char(a.TIME_OF_BIRTH,'hh24:mi') TIME_OF_BIRTH  , a.WEIGHT  , a.WEIGHT_UNIT  , a.LENGTH||' cms'  LENGTH_OF_BABY  , a.CIRCUMFERENCE||' cms'  CIRCUMFERENCE_OF_HEAD  , a.APGAR_SCORE  , b.sex  from  mp_birth_register a  ,mp_patient b  where  b.patient_id=a.patient_id  and a.MOTHER_PATIENT_ID = ?  and ENCOUNTER_FACILITY_ID=? and MOTHER_ENCOUNTER_ID=? order by pat_id asc  ";//Modified --[IN029180]
	
	stmtMotherLink = con.prepareStatement(sqlMotherLink);
	try 
	{
		int k=0;
		int i=0;
		String rowclass = "gridData";

		if(encounterType.equals("Z")) 
		{
			int count=0;
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,clinicianId);
			//stmtPatList.setString(++count,locale);
			//new shaiju
			
			stmtPatList.setString(++count,facility_id);
			stmtPatList.setString(++count,locale);
			// new shaiju
			stmtPatList.setString(++count,facilityId);
			stmtPatList.setString(++count,patientId);
			stmtPatList.setString(++count,nationID);
			stmtPatList.setString(++count,queueId);

			if (groupByEpisode.equals("Y"))
				stmtPatList.setString(++count,locn_type);

			if (past.equals("N")||past.equals(""))
			{
			}
			else
			{
				if (!fromvisitdate.equals(""))
					stmtPatList.setString(++count,fromvisitdate);
				if (!tovisitdate.equals(""))
					stmtPatList.setString(++count,tovisitdate);
			}
			if(viewList.equals("S")) 
				stmtPatList.setString(++count,clinicianId);
			if(!medServiceCode.equals("ALL") ) 
				stmtPatList.setString(++count,medServiceCode);
			if(!attend_practId.equals(""))
			{
				stmtPatList.setString(++count,attend_practId);
			}
			if(!speciality.equals(""))
			{
				stmtPatList.setString(++count,speciality);
			}
			if(encounterType.equals("OP")){
				if(!visitType.equals(""))
				{
					stmtPatList.setString(++count,visitType );
				}
			}
			stmtPatList.setString(++count,clinicianId);//32902
			//inpatients
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,clinicianId);
			stmtPatList.setString(++count,facilityId);
			stmtPatList.setString(++count,patientId);
			stmtPatList.setString(++count,nationID);
			stmtPatList.setString(++count,queueId);								
			
			if (groupByEpisode.equals("Y"))
			{
				stmtPatList.setString(++count,locn_type);						
			}
			
			if(!medServiceCode.equals("ALL") ) 
				stmtPatList.setString(++count,medServiceCode);

			if(viewList.equals("S")) 
				stmtPatList.setString(++count,clinicianId);
			
			if (!adm_fromdate.equals(""))
				stmtPatList.setString(++count,adm_fromdate);
			if (!adm_todate.equals(""))
				stmtPatList.setString(++count,adm_todate);
			if(!attend_practId.equals(""))
			{
				stmtPatList.setString(++count,attend_practId);
			}
			if(!speciality.equals(""))
			{
				stmtPatList.setString(++count,speciality);
			}
			stmtPatList.setString(++count,clinicianId);//32902
		}
		else if(encounterType.equals("OP") || encounterType.equals("EM")) 
		{
			int count=0;
		
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,clinicianId);
			//stmtPatList.setString(++count,locale);
			//new shaiju
			stmtPatList.setString(++count,facility_id);
			stmtPatList.setString(++count,locale);
			// new shaiju
			stmtPatList.setString(++count,facilityId);
			stmtPatList.setString(++count,patientId);
			stmtPatList.setString(++count,nationID);
			stmtPatList.setString(++count,queueId);
//			count=5;
			if (groupByEpisode.equals("Y"))
			{
				
				stmtPatList.setString(++count,encounterType);
//				count=6;
			}
			if (past.equals("N")||past.equals(""))
			{
			}
			else
			{
				if (!fromvisitdate.equals(""))
					stmtPatList.setString(++count,fromvisitdate);
				if (!tovisitdate.equals(""))
					stmtPatList.setString(++count,tovisitdate);
			}
			if(viewList.equals("S")) 
				stmtPatList.setString(++count,clinicianId);
			if(!medServiceCode.equals("ALL") ) 
				stmtPatList.setString(++count,medServiceCode);
			if(!attend_practId.equals(""))
			{
				stmtPatList.setString(++count,attend_practId);
			}
			if(!speciality.equals(""))
			{
				stmtPatList.setString(++count,speciality);
			}
			if(encounterType.equals("OP")){
				if(!visitType.equals(""))
				{
					stmtPatList.setString(++count,visitType );
				}
			}
			stmtPatList.setString(++count,clinicianId); //32902
		}
		else if(encounterType.equals("IP") || encounterType.equals("DC")) 
		{
			int count=0;
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,locale);
			stmtPatList.setString(++count,clinicianId);
			stmtPatList.setString(++count,facilityId);
			stmtPatList.setString(++count,patientId);
			stmtPatList.setString(++count,nationID);
			stmtPatList.setString(++count,queueId);
//			count=6;
			if (groupByEpisode.equals("Y"))
				stmtPatList.setString(++count,encounterType);
			if(!medServiceCode.equals("ALL") ) 
				stmtPatList.setString(++count,medServiceCode);
			if(viewList.equals("S")) 
				stmtPatList.setString(++count,clinicianId);
			if (!adm_fromdate.equals(""))
				stmtPatList.setString(++count,adm_fromdate);
			if (!adm_todate.equals(""))
				stmtPatList.setString(++count,adm_todate);
			if(!attend_practId.equals(""))
			{
				stmtPatList.setString(++count,attend_practId);
			}
			if(!speciality.equals(""))
			{
				stmtPatList.setString(++count,speciality);
			}
			stmtPatList.setString(++count,clinicianId); //32902
		}
		//rsPatList = stmtPatList.executeQuery();
		if(groupByEpisode.equals("N") || groupByMedService.equals("N"))
		{
			rsPatList = stmtPatList.executeQuery();
			//	out.println(rsPatList);
			while(rsPatList.next())
				maxNoRecords += 1;
		}

		
		/*while(rsPatList.next())
			maxNoRecords += 1;
		if(maxNoRecords == 0) */
			//out.println("<script>alert('APP-002415 Query caused no records to be retrieved');</script>");
		    //out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");  
		if(rsPatList!=null)rsPatList.close();
		if(isScroll)
		{
            _bw.write(_wl_block35Bytes, _wl_block35);

			if ( !(start <= 1) )
			{
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((start-11)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((end-11)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( (start - 11) ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( (end - 11) ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( prev ));
            _bw.write(_wl_block42Bytes, _wl_block42);
}
			if ( !( (start+11) > maxNoRecords ) )
			{
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((start+11)));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((end+11)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( (start + 11) ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( (end + 11) ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( next ));
            _bw.write(_wl_block48Bytes, _wl_block48);
}
		}
		else
		{
            _bw.write(_wl_block49Bytes, _wl_block49);
}
		rsPatList = stmtPatList.executeQuery();
		if(isScroll)
		{
			if ( start != 1 )
			{
				for( int j=1; j<start;j++ )
				{
					rsPatList.next() ;
					iterate++;
				}
			}
		}//end of isScroll
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(maxNoRecords));
            _bw.write(_wl_block51Bytes, _wl_block51);

		if(groupByEpisode.equals("N") && groupByMedService.equals("N"))
		{
			boolean header=false;
			while(rsPatList.next()&& iterate <=end ) 
			{
				flag = false;
				iterate++ ;	
				episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
				episode_type= rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
				if(header==false) 
				{
					out.println("<script language='javascript'>parent.parent.PatCriteriaFr.document.getElementById(\"asOn\").innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
					//out.println("<tr id='1046'><td class='COLUMNHEADERCENTER' width='16px'>&nbsp;</td><td class='COLUMNHEADERCENTER' width='16px'>&nbsp;</td><td class='COLUMNHEADERCENTER'   nowrap><a style='color:white'   >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Sno.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a01'   href=\"javascript:callForOrderBy('PC');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encountertype.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a02'   href=\"javascript:callForOrderBy('SAP');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a03'   href=\"javascript:callForOrderBy('PN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</a></td>");//54073
					out.println("<thead style='top:15px;'><tr id='1046'>" +
							    "<th class='COLUMNHEADERCENTER' width='16px'>&nbsp;</th>" +
							    "<th class='COLUMNHEADERCENTER' width='16px'>&nbsp;</th>" +
							    "<th class='COLUMNHEADERCENTER' nowrap>" +
							    "<a style='color:white'>" +
							    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "eCA.Sno.label", "common_labels") +
							    "</a></th>" +
							    "<th class='COLUMNHEADERCENTER' nowrap>" +
							    "<a id='a01' href=\"javascript:callForOrderBy('PC');\" onclick='changeColor(this);' style='color:white'>" +
							    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.encountertype.label", "common_labels") +
							    "</a></th>" +
							    "<th class='COLUMNHEADERCENTER' nowrap>" +
							    "<a id='a02' href=\"javascript:callForOrderBy('SAP');\" onclick='changeColor(this);' style='color:white'>" +
							    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.service.label", "common_labels") +
							    "</a></th>" +
							    "<th class='COLUMNHEADERCENTER' nowrap>" +
							    "<a id='a03' href=\"javascript:callForOrderBy('PN');\" onclick='changeColor(this);' style='color:white'>" +
							    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.PatientName.label", "common_labels") +
							    "</a></th>");

					
					//37866 Start.
					if(isVirtualConsSiteSpec && "OP".equals(episode_type)){
					//out.println("<td class='COLUMNHEADERCENTER'   nowrap><a style='color:white'   >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ConsultationType.label","ca_labels")+"</a></td>");
						out.println("<th class='COLUMNHEADERCENTER' nowrap>" +
							    "<a style='color:white'>" +
							    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "eCA.ConsultationType.label", "ca_labels") +
							    "</a></th>");

					}	
					//37866 End.
	//				out.println("<td class='COLUMNHEADERCENTER' nowrap><a id='a05'   href=\"javascript:callForOrderBy('AGE');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a06'   href=\"javascript:callForOrderBy('SEX');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a07'   href=\"javascript:callForOrderBy('PID');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a08'   href=\"javascript:callForOrderBy('VD');\" onclick='changeColor(this);' style='color:pink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitDate.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a09'   href=\"javascript:callForOrderBy('DD');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.VisitCloseDate.label","ca_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a10'   href=\"javascript:callForOrderBy('RN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a11'   href=\"javascript:callForOrderBy('BN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a12'   href=\"javascript:callForOrderBy('AP');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a13'   href=\"javascript:callForOrderBy('LOC');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a14'   href=\"javascript:callForOrderBy('DOB');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthDate.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a15'   href=\"javascript:callForOrderBy('AT');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.appttime.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a16'   href=\"javascript:callForOrderBy('QN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueueNo.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a17'   href=\"javascript:callForOrderBy('QS');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueueStatus.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a04'   href=\"javascript:callForOrderBy('RID');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</a></td></tr>");	
					out.println(
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a05' href=\"javascript:callForOrderBy('AGE');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.age.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a06' href=\"javascript:callForOrderBy('SEX');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.gender.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a07' href=\"javascript:callForOrderBy('PID');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.patientId.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a08' href=\"javascript:callForOrderBy('VD');\" onclick='changeColor(this);' style='color:pink'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.VisitDate.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a09' href=\"javascript:callForOrderBy('DD');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "eCA.VisitCloseDate.label", "ca_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a10' href=\"javascript:callForOrderBy('RN');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.roomno.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a11' href=\"javascript:callForOrderBy('BN');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.bedno.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a12' href=\"javascript:callForOrderBy('AP');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AttendingPractitioner.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a13' href=\"javascript:callForOrderBy('LOC');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Location.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a14' href=\"javascript:callForOrderBy('DOB');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.birthDate.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a15' href=\"javascript:callForOrderBy('AT');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.appttime.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a16' href=\"javascript:callForOrderBy('QN');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.QueueNo.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a17' href=\"javascript:callForOrderBy('QS');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.QueueStatus.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a04' href=\"javascript:callForOrderBy('RID');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.referralid.label", "common_labels") +
					    "</a></th>" +
					    "</tr></thead>");
					header=true;
					i++;
				}
				if (k % 2 == 0 )
					rowclass = "gridData";
				else
					rowclass = "gridData";
				// color coding
				String status = rsPatList.getString("status")==null?"":rsPatList.getString("status");
				
				sex = rsPatList.getString("SEX")==null?"":rsPatList.getString("SEX");
				queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
				visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
				String emergencyYn = "";
				String deceasedYn = "";
				int noofchildren = 0;
				String relationYn = "";
				String className = rowclass;
				String className1 = rowclass;
				String text = "&nbsp;&nbsp;&nbsp;";
				String disp_cls_cons_date ="&nbsp;";
				String tempDischargeDate = "";
	
				if(episode_type_desc.equals("OP") || episode_type_desc.equals("EM"))
				{
					if(queue_status.equals("01"))
						queue_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
					else if(queue_status.equals("02"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ArrivedatNS.label","ca_labels");
					else if(queue_status.equals("03"))
						queue_status =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.VitalSignRecorded.label","op_labels");
					else if(queue_status.equals("04"))
						queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
					else if(queue_status.equals("05"))
						queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Treat/Invest.label","common_labels");
					else if(queue_status.equals("06"))
						queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReturnfromInvest.label","ca_labels");
					else if(queue_status.equals("07"))
						queue_status =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedOut.label","common_labels");
					else if(queue_status.equals(" "))
						queue_status = "&nbsp;";
				}
				else if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC"))
				{
					if(visit_episode_status.equals("DS"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels");
					else if(visit_episode_status.equals("AP"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DAPrepared.label","ca_labels");
					else if(visit_episode_status.equals("DR"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DiagnosisRec.label","ca_labels");
					else if(visit_episode_status.equals("BA"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.BedAssigned.label","ca_labels");
					else if(visit_episode_status.equals("AD"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Admitted.label","common_labels");
					else
						queue_status = "&nbsp;";
				}
				
				if(episode_type_desc.equals("OP"))
					episode_type_desc = 	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(episode_type_desc.equals("IP"))
					episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(episode_type_desc.equals("EM"))
					episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(episode_type_desc.equals("DC"))
					episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				if(sex.equals("M") || sex.equals("MALE"))
						sex="M";
						//sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if(sex.equals("F") || sex.equals("FEMALE"))
						//sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						sex="F";
				else if(sex.equals("U") || sex.equals("UNKNOWN"))
						//sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						sex="U";
		
				StringTokenizer st = new StringTokenizer(status,"|");
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					String n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}
				//if(rsPatList.getString("episode_type").equals("I"))
				/*{
					if(!( rsPatList.getString("discharge_date_time")==null))
						if( !rsPatList.getString("discharge_date_time").equals(""))
							className = "DISCHARGED";
				}*/
				/*else
				{
					if(!(rsPatList.getString("visit_episode_status") == null))
						if(rsPatList.getString("visit_episode_status").equals("4"))
							className = "DISCHARGED";
				}*/
				tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");

				if(deceasedYn.equals("D"))
				{
					className="CADECEASED";
					rowclass = "DECEASED1";
					decesedColor="";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor="";
				}
				else
				{
					decesedColor="";
				}
				if (!deceasedYn.equals("D"))
				{	
					if(!tempDischargeDate.equals("")) className = "DISCHARGED";
					else if((noofchildren > 0)) className = "NEWBORN";
				}

				emergencyYn=rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y"))
				{
				if(!emergencyYn.equals(""))
					className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
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
				// color coding ends
				disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
				if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
					disp_cls_cons_date="&nbsp;";

				if(!disp_cls_cons_date.equals("&nbsp;") )
					disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);

				if(rsPatList.getString("episode_type").equals("I"))
				{
					layer = new StringBuffer();
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rsPatList.getString("patient_id"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
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
							String apgar_score_val = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;":rsMotherLink.getString("APGAR_SCORE");
							layer.append("<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td><td class=ORPANEL><font size=1>"+dateofbirth1+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT") + "</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td><td class=ORPANEL><font size=1>"+apgar_score_val+"</font></td></tr>");
						}
							if(rsMotherLink !=null) rsMotherLink.close();
							//if(stmtMotherLink != null ) stmtMotherLink.close();
					
					}
				}
				if(locale.equals("en"))
	             {
		          DateofBirth=rsPatList.getString("DOB");
	             }
	           else
	            {
		          DateofBirth=com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale);
	            }
				restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902
                                accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);//32902
				out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
				//IN044157 - Start		
				out.println("<tr>");
				if(!emergencyYn.equals(""))
					out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
				else
					out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
				//IN044157 - End				
				out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>&nbsp;"+ counts++ +"</td><td class=gridData nowrap>"+episode_type_desc+"</td><td class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class=gridData nowrap><a class='gridLink' href=\"javascript:patClick('"+i+"','"+rsPatList.getString("PATIENT_ID")+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</a></font></td>");//54073
				//37866 Start.
				if(isVirtualConsSiteSpec && "OP".equals(episode_type)  && ("Y".equals(rsPatList.getString("virtualApptYN")))){
					out.println("<td  class='"+className1+"' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
				}else if(isVirtualConsSiteSpec && "OP".equals(episode_type)){ 	
					out.println("<td  class='"+className1+"' nowrap>&nbsp;</td>");
				}		
				//37866 End.
				out.println("<td class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td class=gridData nowrap>"+sex+"</td><td class=gridData nowrap>"+rsPatList.getString("PATIENT_ID")+"</td><td class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td class=gridData nowrap>"+disp_cls_cons_date+"</td><td class=gridData nowrap>"+rsPatList.getString("ROOM_NUM")+"</td><td class=gridData nowrap>"+rsPatList.getString("BED_NUM")+"</td><td class=gridData nowrap>"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" :  rsPatList.getString("PHYSICIAN_NAME"))+"</td><td class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td class=gridData nowrap>"+DateofBirth+"</td><td class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td><td class=gridData nowrap>"+queue_status+"</td>");
				if(rsPatList.getString("referral_id")!= null){
					out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\"" + rsPatList.getString("referral_id")+"\")'>" + (rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></td></tr>");
				}
				else
				{
					out.println("<td class=gridData nowrap><a class='gridLink'>" + (rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></td></tr>");
				}
				// start.32902  
				
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block56Bytes, _wl_block56);

		         // end. 32902 
				out.println("<script language='javascript'>");
				out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");				
				out.println("</script>");
				i++;
				k++;
			}
		}
		else if(groupByEpisode.equals("Y") && groupByMedService.equals("N"))
		{
			boolean outpHeader=false;
			boolean inpHeader=false;
			String currcompstring = "";
			String prevcompstring = "`";
			int countvar=1;//ML-MMOH-CRF-1778
			//String displaytext = "";
			while(rsPatList.next()&& iterate <=end ) 
			{
				flag = false;
				iterate++ ;
				if (k % 2 == 0 )
					rowclass = "gridData";
				else
					rowclass = "gridData";
				// color coding
				String status = rsPatList.getString("status")==null?"":rsPatList.getString("status");
				episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
				episode_type= rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
				sex = rsPatList.getString("SEX")==null?"":rsPatList.getString("SEX");
				queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
				visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
				String currpract = rsPatList.getString("ACTUAL_PHYSICIAN_ID")==null?"":rsPatList.getString("ACTUAL_PHYSICIAN_ID");
				String currvisitdate = rsPatList.getString("visit_date")==null?"":rsPatList.getString("visit_date");
				String emergencyYn = "";
				String deceasedYn = "";
				int noofchildren = 0;
				String relationYn = "";
				String className = rowclass;
				String className1 = rowclass;
				String text = "&nbsp;&nbsp;&nbsp;";
				String disp_cls_cons_date ="&nbsp;";
				String tempDischargeDate = "";

				if(episode_type_desc.equals("OP") || episode_type_desc.equals("EM"))
				{
					if(queue_status.equals("01"))
						queue_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
					else if(queue_status.equals("02"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ArrivedatNS.label","ca_labels");
					else if(queue_status.equals("03"))
						queue_status =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.VitalSignRecorded.label","op_labels");
					else if(queue_status.equals("04"))
						queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
					else if(queue_status.equals("05"))
						queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Treat/Invest.label","common_labels");
					else if(queue_status.equals("06"))
						queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReturnfromInvest.label","ca_labels");
					else if(queue_status.equals("07"))
						queue_status =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedOut.label","common_labels");
					else if(queue_status.equals(" "))
						queue_status = "&nbsp;";
				}
				else if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC"))
				{
					if(visit_episode_status.equals("DS"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels");
					else if(visit_episode_status.equals("AP"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DAPrepared.label","ca_labels");
					else if(visit_episode_status.equals("DR"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DiagnosisRec.label","ca_labels");
					else if(visit_episode_status.equals("BA"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.BedAssigned.label","ca_labels");
					else if(visit_episode_status.equals("AD"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Admitted.label","common_labels");
					else
						queue_status = "&nbsp;";
				}
				
				if(episode_type_desc.equals("OP"))
						episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(episode_type_desc.equals("IP"))
						episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(episode_type_desc.equals("EM"))
						episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(episode_type_desc.equals("DC"))
						episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				if(sex.equals("M") || sex.equals("MALE"))
						//sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						sex="M";
				else if(sex.equals("F") || sex.equals("FEMALE"))
						//sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						sex="F";
				else if(sex.equals("U") || sex.equals("UNKNOWN"))
						//sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						sex="U";
				
				StringTokenizer st = new StringTokenizer(status,"|");
				while (st.hasMoreTokens())
				{
					
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					String n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}
				//if(rsPatList.getString("EPISODE_TYPE").equals("I"))
				/*{
					if(!( rsPatList.getString("DISCHARGE_DATE_TIME")==null))
						if( !rsPatList.getString("DISCHARGE_DATE_TIME").equals(""))
							className = "DISCHARGED";
				}*/
				/*else
				{
					if(!(rsPatList.getString("visit_episode_status") == null))
						if(rsPatList.getString("visit_episode_status").equals("4"))
							className = "DISCHARGED";
				}*/

				tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");

				if(deceasedYn.equals("D"))
				{
					className="CADECEASED";
					rowclass = "DECEASED1";
					decesedColor="";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor="";
				}
				else
				{
					decesedColor="";
				}
				if (!deceasedYn.equals("D"))
				{	
					if(!tempDischargeDate.equals("")) className = "DISCHARGED";
					else if((noofchildren > 0)) className = "NEWBORN";
				}
				
				emergencyYn=rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y")){
				if(!emergencyYn.equals(""))
					className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
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
				// color coding ends
				disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
				if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
					disp_cls_cons_date="&nbsp;";

				if(!disp_cls_cons_date.equals("&nbsp;") )
					disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);

				if(rsPatList.getString("episode_type").equals("O"))
				{
					if(outpHeader==false)
					{
						out.println("<script language='javascript'>parent.parent.PatCriteriaFr.document.getElementById(\"asOn\").innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
						out.println("<tr id='1444'><td class='COLUMNHEADERCENTER' width='16px'>&nbsp;</td><td class='COLUMNHEADERCENTER' width='16px'>&nbsp;</td><td class='COLUMNHEADERCENTER' nowrap><a style='color:white' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Sno.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a01'   href=\"javascript:callForOrderBy('SAP');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a02'   href=\"javascript:callForOrderBy('AT');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.appttime.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a03'   href=\"javascript:callForOrderBy('QN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueueNo.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a04'   href=\"javascript:callForOrderBy('PN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</a></td>");//54073
						//37866 Start.
						if(isVirtualConsSiteSpec && "OP".equals(episode_type)){
						out.println("<td class='COLUMNHEADERCENTER'   nowrap><a style='color:white'   >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ConsultationType.label","ca_labels")+"</a></td>");
						}	
						//37866 End.
						out.println("<td class='COLUMNHEADERCENTER' nowrap><a id='a06'   href=\"javascript:callForOrderBy('AGE');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a07'   href=\"javascript:callForOrderBy('SEX');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a08'   href=\"javascript:callForOrderBy('PID');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a09'   href=\"javascript:callForOrderBy('VD');\" onclick='changeColor(this);' style='color:pink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitDate.label","common_labels")+"</a></td>");
						if(encounterType.equals("OP")){
						out.println("<td class='COLUMNHEADERCENTER' nowrap><a id='a15'   href=\"javascript:callForOrderBy('VT');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.visittype.label","common_labels")+"</a></td>");
						}
						out.println("<td class='COLUMNHEADERCENTER' nowrap><a id='a10'   href=\"javascript:callForOrderBy('DD');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ConsEndDate.label","ca_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap colspan=2><a id='a11'   href=\"javascript:callForOrderBy('QS');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueueStatus.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a12'   href=\"javascript:callForOrderBy('AP');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a13'   href=\"javascript:callForOrderBy('LOC');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a14'   href=\"javascript:callForOrderBy('DOB');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthDate.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a05'   href=\"javascript:callForOrderBy('RID');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</a></td></tr>");
						i++;
						i++;
						outpHeader=true;
					}
					String datedisplay = rsPatList.getString("adm_visit_date").substring(0,rsPatList.getString("adm_visit_date").indexOf(" "));
					if(datedisplay.equals(Sdate)) 
						datedisplay="Current Queue";
					if(unscheduledyn.equals("Y") && past.equals("N"))
					{
						String practScheduled= "Unassigned";
						if(currpract.equals("")) 	
							practScheduled = "Unassigned";
						else 
							practScheduled = "Assigned";
						currcompstring = practScheduled;
						//displaytext= practScheduled;
					}
					else if(unscheduledyn.equals("N") && past.equals("Y"))
					{
						currcompstring = currvisitdate;
						//displaytext= datedisplay;
					}
					else if(unscheduledyn.equals("Y") && past.equals("Y"))
					{
						String practScheduled= "Unassigned";
						if(currpract.equals("")) 	
							practScheduled = "Unassigned";
						else 
							practScheduled = "Assigned";
						currcompstring = practScheduled+currvisitdate;
						//displaytext= practScheduled+", "+datedisplay;
					}
					if(!currcompstring.equals(""))					
						if(!currcompstring.equals(prevcompstring))
						i++;
					if(locale.equals("en"))
	               {
		             DateofBirth=rsPatList.getString("DOB");
	               }
	               else
	               {
		             DateofBirth=com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale);
	                }
					restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902
	                                accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);//32902
					//IN044157 - Start		
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>"+ countvar++ +"</td><td class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td><td class=gridData nowrap><a class='gridLink' href=\"javascript:patClick('"+i+"','"+rsPatList.getString("PATIENT_ID")+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</a></font></td>");	//ML-MMOH-CRF-1778			
					//out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td><td class=gridData nowrap><a class='gridLink' href=\"javascript:patClick('"+i+"','"+rsPatList.getString("PATIENT_ID")+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</a></font></td>");
					//37866 Start.
					if(isVirtualConsSiteSpec && "OP".equals(episode_type)  && ("Y".equals(rsPatList.getString("virtualApptYN")))){
						out.println("<td  class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
					}else if(isVirtualConsSiteSpec  && "OP".equals(episode_type)){ 	
						out.println("<td  class='gridData' nowrap>&nbsp;</td>");
					}	
					//37866 End.					
					out.println("<td class=gridData nowrap &nbsp;&nbsp;>"+rsPatList.getString("AGE")+"</td><td class=gridData nowrap >"+sex+"</td><td class=gridData nowrap  >"+rsPatList.getString("PATIENT_ID")+"</td><td class=gridData nowrap >"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td>");
					if(encounterType.equals("OP")){
					out.println("<td class=gridData nowrap>"+rsPatList.getString("visit_type")+"</td>");
					}
						
					out.println("<td class=gridData nowrap>"+disp_cls_cons_date+"</td><td class=gridData nowrap colspan='2'>"+queue_status+"</td><td class=gridData nowrap>"+(rsPatList.getString("PHYSICIAN_NAME")== null ? "&nbsp;" :  rsPatList.getString("PHYSICIAN_NAME"))+"</td><td class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td class=gridData nowrap>"+DateofBirth+"</td>");
					if(rsPatList.getString("referral_id")!= null)
					{
						out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'>"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></td></tr>");
					}
					else
					{
						out.println("<td class=gridData nowrap><a class='gridLink'>"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></td></tr>");
					}
					// start.32902  
					
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block59Bytes, _wl_block59);

			                  // end. 32902 
				}
				else if(rsPatList.getString("episode_type").equals("I"))
				{
					layer = new StringBuffer();
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
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
							String apgar_score_val = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;":rsMotherLink.getString("APGAR_SCORE");
							layer.append("<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td><td class=ORPANEL><font size=1>"+dateofbirth1+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td><td class=ORPANEL><font size=1>"+apgar_score_val+"</font></td></tr>");
						}
					
							if(rsMotherLink !=null) rsMotherLink.close();
							//if(stmtMotherLink != null ) stmtMotherLink.close();					
					}
					if(inpHeader==false)
					{
						out.println("<script language='javascript'>parent.parent.PatCriteriaFr.document.getElementById(\"asOn\").innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
	//					out.println("<tr id='1567'><td class='COLUMNHEADERCENTER' width='16px'>&nbsp;</td><td class='COLUMNHEADERCENTER' width='16px'>&nbsp;</td><td class='COLUMNHEADERCENTER'   nowrap><a style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Sno.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a01'   href=\"javascript:callForOrderBy('SAP');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap ><a id='a02'   href=\"javascript:callForOrderBy('PN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a04'   href=\"javascript:callForOrderBy('AGE');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a05'   href=\"javascript:callForOrderBy('SEX');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a06'   href=\"javascript:callForOrderBy('PID');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a07'   href=\"javascript:callForOrderBy('AD');\" onclick='changeColor(this);' style='color:pink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admissiondate.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a08'   href=\"javascript:callForOrderBy('IQS');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueueStatus.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a09' href=\"javascript:callForOrderBy('DD');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargedate.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a10'   href=\"javascript:callForOrderBy('RN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a11'   href=\"javascript:callForOrderBy('BN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a12'   href=\"javascript:callForOrderBy('AP');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a13'   href=\"javascript:callForOrderBy('LOC');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a14'   href=\"javascript:callForOrderBy('DOB');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthDate.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a03'   href=\"javascript:callForOrderBy('RID');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</a></td></tr>");//54073
						
						out.println("<thead> <tr id='1567'>"
								    + "<th class='COLUMNHEADERCENTER' width='16px'>&nbsp;</th>"
								    + "<th class='COLUMNHEADERCENTER' width='16px'>&nbsp;</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "eCA.Sno.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a01' href=\"javascript:callForOrderBy('SAP');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.service.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a02' href=\"javascript:callForOrderBy('PN');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.PatientName.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a04' href=\"javascript:callForOrderBy('AGE');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.age.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a05' href=\"javascript:callForOrderBy('SEX');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.gender.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a06' href=\"javascript:callForOrderBy('PID');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.patientId.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a07' href=\"javascript:callForOrderBy('AD');\" onclick='changeColor(this);' style='color:pink'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.admissiondate.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a08' href=\"javascript:callForOrderBy('IQS');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.QueueStatus.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a09' href=\"javascript:callForOrderBy('DD');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.dischargedate.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a10' href=\"javascript:callForOrderBy('RN');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.roomno.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a11' href=\"javascript:callForOrderBy('BN');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.bedno.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a12' href=\"javascript:callForOrderBy('AP');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AttendingPractitioner.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a13' href=\"javascript:callForOrderBy('LOC');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Location.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a14' href=\"javascript:callForOrderBy('DOB');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.birthDate.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "<th class='COLUMNHEADERCENTER' nowrap>"
								        + "<a id='a03' href=\"javascript:callForOrderBy('RID');\" onclick='changeColor(this);' style='color:white'>"
								        + com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.referralid.label", "common_labels")
								        + "</a>"
								    + "</th>"
								    + "</tr> </thead>");

							
	
	
						i++;
						i++;
						inpHeader=true;
					}

					if(locale.equals("en"))
	                 {
		                DateofBirth=rsPatList.getString("DOB");
	                 }
	              else
	               {
		             DateofBirth=com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale);
	              }
				  	out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
					//IN044157 - Start		
					restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902
	                                accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);//32902
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>&nbsp;"+ counts++ +"</td><td class=gridData nowrap>"+rsPatList.getString("SPLTY_NAME")+"</td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class=gridData nowrap colspan='3'><a class='gridLink' href=\"javascript:patClick('"+i+"','"+rsPatList.getString("PATIENT_ID")+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</a></font></td><td class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td class=gridData nowrap>"+sex+"</td><td class=gridData nowrap>"+rsPatList.getString("PATIENT_ID")+"</td><td class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td class=gridData nowrap>"+queue_status+"</td><td class=gridData nowrap>"+disp_cls_cons_date+"</td><td class=gridData nowrap>"+rsPatList.getString("ROOM_NUM")+"</td><td class=gridData nowrap>"+rsPatList.getString("BED_NUM")+"</td><td class=gridData nowrap>"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</td><td class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td class=gridData nowrap>"+DateofBirth+"</td>");//54073
					if(rsPatList.getString("referral_id")!= null)
					{
						out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
					}
					else
					{
						out.println("<td class=gridData nowrap><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
					}
				}
				// start.32902  
				
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block61Bytes, _wl_block61);

	                        	// end. 32902 
				out.println("<script language='javascript'>");
				out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");				
				out.println("</script>");
				i++;
				k++;
				prevcompstring = currcompstring;
			}
		}
		else if(groupByEpisode.equals("N") && groupByMedService.equals("Y"))
		{
			boolean outpHeader=false;
			boolean inpHeader=false;
			String currLocn="";
			String currcompstring = "";
			String prevcompstring = "`";
			String displaytext = "";
			int countvar=1;//22856--
			while(rsPatList.next()&& iterate <=end ) 
			{
				flag = false;
				iterate++ ;
				if (k % 2 == 0 )
					rowclass = "gridData";
				else
					rowclass = "gridData";
				// color coding
				String status = rsPatList.getString("status")==null?"":rsPatList.getString("status");
				episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
				episode_type= rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
				sex = rsPatList.getString("SEX")==null?"":rsPatList.getString("SEX");
				queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
				visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
				String currpract = rsPatList.getString("ACTUAL_PHYSICIAN_ID")==null?"":rsPatList.getString("ACTUAL_PHYSICIAN_ID");
				String currvisitdate = rsPatList.getString("visit_date")==null?"":rsPatList.getString("visit_date");
				String emergencyYn = "";
				String deceasedYn = "";
				int noofchildren = 0;
				String relationYn = "";
				String className = rowclass;
				String className1 = rowclass;
				String text = "&nbsp;&nbsp;&nbsp;";
				String disp_cls_cons_date ="&nbsp;";
				String tempDischargeDate = "";

				if(episode_type_desc.equals("OP") || episode_type_desc.equals("EM"))
				{
					if(queue_status.equals("01"))
						queue_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
					else if(queue_status.equals("02"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ArrivedatNS.label","ca_labels");
					else if(queue_status.equals("03"))
						queue_status =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.VitalSignRecorded.label","op_labels");
					else if(queue_status.equals("04"))
						queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
					else if(queue_status.equals("05"))
						queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Treat/Invest.label","common_labels");
					else if(queue_status.equals("06"))
						queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReturnfromInvest.label","ca_labels");
					else if(queue_status.equals("07"))
						queue_status =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedOut.label","common_labels");
					else if(queue_status.equals(" "))
						queue_status = "&nbsp;";
				}
				else if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC"))
				{
					if(visit_episode_status.equals("DS"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels");
					else if(visit_episode_status.equals("AP"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DAPrepared.label","ca_labels");
					else if(visit_episode_status.equals("DR"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DiagnosisRec.label","ca_labels");
					else if(visit_episode_status.equals("BA"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.BedAssigned.label","ca_labels");
					else if(visit_episode_status.equals("AD"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Admitted.label","common_labels");
					else
						queue_status = "&nbsp;";
				}
				
				if(episode_type_desc.equals("OP"))
					episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(episode_type_desc.equals("IP"))
					episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(episode_type_desc.equals("EM"))
					episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(episode_type_desc.equals("DC"))
					episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				if(sex.equals("M") || sex.equals("MALE"))
						//sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						sex="M";
				else if(sex.equals("F") || sex.equals("FEMALE"))
						//sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						sex="F";
				else if(sex.equals("U") || sex.equals("UNKNOWN"))
						//sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						sex="U";
				
				StringTokenizer st = new StringTokenizer(status,"|");
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					String n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}
				//if(rsPatList.getString("episode_type").equals("I"))
				/*{
					if(!( rsPatList.getString("discharge_date_time")==null))
						if( !rsPatList.getString("discharge_date_time").equals(""))
							className = "DISCHARGED";
				}*/
				/*else
				{
					if(!(rsPatList.getString("visit_episode_status") == null))
						if(rsPatList.getString("visit_episode_status").equals("4"))
							className = "DISCHARGED";
				}*/

				tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");

				if(deceasedYn.equals("D"))
				{						
					className="CADECEASED";
					rowclass = "DECEASED1";				
					decesedColor="";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor="";
				}
				else
				{
					decesedColor="";
				}
				if (!deceasedYn.equals("D"))
				{	
					if(!tempDischargeDate.equals("")) className = "DISCHARGED";
					else if((noofchildren > 0)) className = "NEWBORN";
				}

				emergencyYn=rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y")){
				if(!emergencyYn.equals(""))
					className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
				}else{if(emergencyYn.equals("R")) 
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
				// color coding ends
				disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
				if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
					disp_cls_cons_date="&nbsp;";

				if(!disp_cls_cons_date.equals("&nbsp;") )
					disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);
				
				if(rsPatList.getString("episode_type").equals("O"))
				{
					if(outpHeader==false)
					{
						out.println("<script language='javascript'>parent.parent.PatCriteriaFr.document.getElementById(\"asOn\").innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
						out.println("<tr id='1782'><td class='COLUMNHEADERCENTER' width='16px'>&nbsp;</td><td class='COLUMNHEADERCENTER' width='16px'>&nbsp;</td><td class='COLUMNHEADERCENTER'  nowrap><a id='a01'   href=\"javascript:callForOrderBy('AT');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.appttime.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER'  nowrap><a id='a02'   href=\"javascript:callForOrderBy('QN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueueNo.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER'  nowrap><a id='a03'   href=\"javascript:callForOrderBy('PN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</a></td>");
						//37866 Start.
						if(isVirtualConsSiteSpec && "OP".equals(episode_type)){
						out.println("<td class='COLUMNHEADERCENTER'   nowrap><a style='color:white'   >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ConsultationType.label","ca_labels")+"</a></td>");
						}	
						//37866 End.						
						out.println("<td class='COLUMNHEADERCENTER'  nowrap><a id='a05'   href=\"javascript:callForOrderBy('AGE');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER'  nowrap><a id='a06'   href=\"javascript:callForOrderBy('SEX');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER'  nowrap><a id='a07'   href=\"javascript:callForOrderBy('PID');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER'  nowrap><a id='a08'   href=\"javascript:callForOrderBy('VD');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VisitDate.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER'  nowrap><a id='a09' href=\"javascript:callForOrderBy('DD');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ConsEndDate.label","ca_labels")+"</a></td><td class='COLUMNHEADERCENTER'  nowrap colspan=2><a id='a10'   href=\"javascript:callForOrderBy('QS');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueueStatus.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER'  nowrap><a id='a11'   href=\"javascript:callForOrderBy('AP');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER'  nowrap><a id='a12'   href=\"javascript:callForOrderBy('LOC');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER'  nowrap><a id='a13'   href=\"javascript:callForOrderBy('DOB');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthDate.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER'  nowrap><a id='a04'   href=\"javascript:callForOrderBy('RID');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</a></td></tr>");
						i++;
						outpHeader=true;
					}
					String datedisplay = rsPatList.getString("adm_visit_date").substring(0,rsPatList.getString("adm_visit_date").indexOf(" "));
					if(datedisplay.equals(Sdate)) 
						datedisplay="Current Queue";
					if(unscheduledyn.equals("Y") && past.equals("N"))
					{
						String practScheduled= "Unassigned";
						if(currpract.equals("")) 	
							practScheduled = "Unassigned";
						else 
							practScheduled = "Assigned";
						currcompstring = rsPatList.getString("SPLTY_NAME")+practScheduled;
						displaytext= rsPatList.getString("SPLTY_NAME")+", "+practScheduled;
					}
					else if(unscheduledyn.equals("N") && past.equals("Y"))
					{
						currcompstring = rsPatList.getString("SPLTY_NAME")+currvisitdate;
						displaytext= rsPatList.getString("SPLTY_NAME")+", "+datedisplay;
					}
					else if(unscheduledyn.equals("Y") && past.equals("Y"))
					{
						String practScheduled= "Unassigned";
						if(currpract.equals("")) 	
							practScheduled = "Unassigned";
						else 
							practScheduled = "Assigned";
						currcompstring = rsPatList.getString("SPLTY_NAME")+practScheduled+currvisitdate;
						displaytext= rsPatList.getString("SPLTY_NAME")+", "+practScheduled+", "+datedisplay;
					}
					else
					{
						currcompstring = rsPatList.getString("SPLTY_NAME");
						displaytext= rsPatList.getString("SPLTY_NAME");
					}
					if(!currcompstring.equals(prevcompstring))
					{
						out.println("<tr><td class=gridData  colspan='15'>"+displaytext+"</td></tr>");
						i++;
					}

					encounterID = rsPatList.getString("EPISODE_ID");
					patientClass = rsPatList.getString("patient_class");

					if(patientClass.equals("EM"))
					{
						try
						{
							pstmtForAEPat = con.prepareStatement(sqlQueueForAEPat);
							pstmtForAEPat.setString(1,locale);
							pstmtForAEPat.setString(2,facility_id);
							pstmtForAEPat.setString(3,encounterID);

							resForAEPat = pstmtForAEPat.executeQuery();
						
							while(resForAEPat.next())
							{
								queueDesc = resForAEPat.getString(1) == null ? "&nbsp;" : resForAEPat.getString(1);
							}

							queueNumber = queueDesc;

							if(pstmtForAEPat != null) pstmtForAEPat.close();
							if(resForAEPat != null) resForAEPat.close();
						}
						catch(Exception eee)
						{
							//out.println("Exception in try of QueueForAEPat of PatListByMedServiceResult.jsp "+eee.toString());//COMMON-ICN-0181
							eee.printStackTrace();
							if(pstmtForAEPat != null) pstmtForAEPat.close();
							if(resForAEPat != null) resForAEPat.close();
						}
					}					
					else
					{
						if(rsPatList.getString("QUEUE_NUM").equals("0")) queueNumber = "&nbsp;";
						else queueNumber = rsPatList.getString("QUEUE_NUM");
					}

					if(locale.equals("en"))
	                {
		              DateofBirth=rsPatList.getString("DOB");
	                }
	               else
	              {
		              DateofBirth=com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale);
	               }
					
					//out.println("queueNumber ="+queueNumber+"=");
					//IN044157 - Start		
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>"+ countvar++ +"</td><td class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td class=gridData nowrap>here here</td><td class=gridData nowrap><a class='gridLink' href=\"javascript:patClick('"+i+"','"+rsPatList.getString("PATIENT_ID")+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</a></font></td>");
					//out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td class=gridData nowrap>here here</td><td class=gridData nowrap><a class='gridLink' href=\"javascript:patClick('"+i+"','"+rsPatList.getString("PATIENT_ID")+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</a></font></td>");				
					//37866 Start.
					if(isVirtualConsSiteSpec && "OP".equals(episode_type)  && ("Y".equals(rsPatList.getString("virtualApptYN")))){
						out.println("<td  class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
					}else if(isVirtualConsSiteSpec && "OP".equals(episode_type)){ 	
						out.println("<td  class='gridData' nowrap>&nbsp;</td>");
					}
					//37866 End.
					out.println("<td class=gridData nowrap &nbsp;&nbsp;>"+rsPatList.getString("AGE")+"</td><td class=gridData nowrap >"+sex+"</td><td class=gridData nowrap >"+rsPatList.getString("PATIENT_ID")+"</td><td class=gridData nowrap >"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td class=gridData nowrap >"+disp_cls_cons_date+"</td><td class=gridData nowrap colspan='2'>"+queue_status+"</td><td class=gridData nowrap >"+(rsPatList.getString("PHYSICIAN_NAME") == null ? "&nbsp;" : rsPatList.getString("PHYSICIAN_NAME"))+"</td><td class=gridData nowrap >"+rsPatList.getString("LOCN_NAME")+"</td><td class=gridData nowrap >"+DateofBirth+"</td>");
					if(rsPatList.getString("referral_id")!= null){
					out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'>"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></td></tr>");
					}
					else
					{
					out.println("<td class=gridData nowrap><a class='gridLink'>"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></td></tr>");
					}
				}
				else if(rsPatList.getString("episode_type").equals("I"))
				{
					layer = new StringBuffer();
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
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
							String apgar_score_val = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;":rsMotherLink.getString("APGAR_SCORE");
							layer.append("<tr><td class=ORPANEL><font size=1>"+rsMotherLink.getString("pat_id")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("short_name")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("sex")+"</font></td><td class=ORPANEL><font size=1>"+dateofbirth1+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td><td class=ORPANEL><font size=1>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td><td class=ORPANEL><font size=1>"+apgar_score_val+"</font></td></tr>");
						}
					
							if(rsMotherLink !=null) rsMotherLink.close();
							//if(stmtMotherLink != null ) stmtMotherLink.close();
					}
					if(inpHeader==false)
					{
						out.println("<script language='javascript'>parent.parent.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
						//out.println("<thead><tr id='1934'><td class='COLUMNHEADERCENTER' width='16px'>&nbsp;</td><td class='COLUMNHEADERCENTER' width='16px'>&nbsp;</td><td class='COLUMNHEADERCENTER' nowrap colspan='3'><a id='a01'   href=\"javascript:callForOrderBy('PN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientName.label","common_labels")+"</a></td>");
						out.println("<thead><tr id='1934'>" +
					    "<th class='COLUMNHEADERCENTER' width='16px'>&nbsp;</th>" +
					    "<th class='COLUMNHEADERCENTER' width='16px'>&nbsp;</th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a01' href=\"javascript:callForOrderBy('PN');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.PatientName.label", "common_labels") +
					    "</a></th>");
					
											//out.println("<td class='COLUMNHEADERCENTER' nowrap><a id='a03'   href=\"javascript:callForOrderBy('AGE');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a04'   href=\"javascript:callForOrderBy('SEX');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.gender.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a05'   href=\"javascript:callForOrderBy('PID');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a06'   href=\"javascript:callForOrderBy('AD');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.admissiondate.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a07' href=\"javascript:callForOrderBy('DD');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dischargedate.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a08'   href=\"javascript:callForOrderBy('RN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a09'   href=\"javascript:callForOrderBy('BN');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a10'   href=\"javascript:callForOrderBy('AP');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AttendingPractitioner.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a11'   href=\"javascript:callForOrderBy('LOC');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a12'   href=\"javascript:callForOrderBy('DOB');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.birthDate.label","common_labels")+"</a></td><td class='COLUMNHEADERCENTER' nowrap><a id='a02'   href=\"javascript:callForOrderBy('RID');\" onclick='changeColor(this);' style='color:white'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referralid.label","common_labels")+"</a></td></tr>");
						out.println("<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a03' href=\"javascript:callForOrderBy('AGE');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.age.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a04' href=\"javascript:callForOrderBy('SEX');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.gender.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a05' href=\"javascript:callForOrderBy('PID');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.patientId.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a06' href=\"javascript:callForOrderBy('AD');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.admissiondate.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a07' href=\"javascript:callForOrderBy('DD');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.dischargedate.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a08' href=\"javascript:callForOrderBy('RN');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.roomno.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a09' href=\"javascript:callForOrderBy('BN');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.bedno.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a10' href=\"javascript:callForOrderBy('AP');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.AttendingPractitioner.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a11' href=\"javascript:callForOrderBy('LOC');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Location.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a12' href=\"javascript:callForOrderBy('DOB');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.birthDate.label", "common_labels") +
					    "</a></th>" +
					    "<th class='COLUMNHEADERCENTER' nowrap>" +
					    "<a id='a02' href=\"javascript:callForOrderBy('RID');\" onclick='changeColor(this);' style='color:white'>" +
					    com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.referralid.label", "common_labels") +
					    "</a></th></tr></thead>");

						
						i++;
						inpHeader=true;
					}
					if(!currLocn.equals(rsPatList.getString("SPLTY_NAME"))) 
					{
						out.println("<tr><td colspan='15' class=gridData ><B>"+rsPatList.getString("SPLTY_NAME")+"</td></tr>");
						i++;
						currLocn=rsPatList.getString("SPLTY_NAME");
					}
				    if(locale.equals("en"))
	               {
		              DateofBirth=rsPatList.getString("DOB");
	               }
	              else
	               {
		             DateofBirth=com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale);
	               }
				    restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902
                    accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);//32902
					out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
					//IN044157 - Start		
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class=gridData nowrap ><a class='gridLink' href=\"javascript:patClick('"+i+"','"+rsPatList.getString("PATIENT_ID")+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</a></font></td>");
					out.println("<td class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td class=gridData nowrap>"+sex+"</td><td class=gridData nowrap>"+rsPatList.getString("PATIENT_ID")+"</td><td class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td class=gridData nowrap>"+disp_cls_cons_date+"</td><td class=gridData nowrap>"+rsPatList.getString("ROOM_NUM")+"</td><td class=gridData nowrap>"+rsPatList.getString("BED_NUM")+"</td><td class=gridData nowrap>"+(rsPatList.getString("PHYSICIAN_NAME")== null ? "&nbsp;" :  rsPatList.getString("PHYSICIAN_NAME"))+"</td><td class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td class=gridData nowrap>"+DateofBirth+"</td>");
					if(rsPatList.getString("referral_id")!= null)
					{
						out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'>"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></td></tr>");
					}
					else
					{
						out.println("<td class=gridData nowrap><a class='gridLink'>"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></td></tr>");
					}
				}
				// start.32902  
				
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block61Bytes, _wl_block61);

	                        	// end. 32902
				out.println("<script language='javascript'>");
				out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");				
				out.println("</script>");
				i++;
				k++;
				prevcompstring = currcompstring;
			}
		}
		else if(groupByEpisode.equals("Y") && groupByMedService.equals("Y"))
		{
			boolean outpHeader=false;
			boolean inpHeader=false;
			String currLocn="";
			String currcompstring = "";
			String prevcompstring = "`";
			//String displaytext = "";
			int countvar= 1;//ML-MMOH-CRF-1778
		    while(rsPatList.next())
			{
				flag = false;
				iterate++ ;
				if (k % 2 == 0 )
					rowclass = "gridData";
				else
					rowclass = "gridData";
				// color coding
				String status = rsPatList.getString("status")==null?"":rsPatList.getString("status");
				episode_type_desc = rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
				episode_type= rsPatList.getString("episode_type_desc")==null?"":rsPatList.getString("episode_type_desc");
				sex = rsPatList.getString("SEX")==null?"":rsPatList.getString("SEX");
				queue_status = rsPatList.getString("queue_status")==null?"":rsPatList.getString("queue_status");
				visit_episode_status = rsPatList.getString("visit_episode_status")==null?"":rsPatList.getString("visit_episode_status");
				String currpract = rsPatList.getString("ACTUAL_PHYSICIAN_ID")==null?"":rsPatList.getString("ACTUAL_PHYSICIAN_ID");
				String currvisitdate = rsPatList.getString("visit_date")==null?"":rsPatList.getString("visit_date");
				String emergencyYn = "";
				String deceasedYn = "";
				int noofchildren = 0;
				String relationYn = "";
				String className = rowclass;
				String className1 = rowclass;
				String text = "&nbsp;&nbsp;&nbsp;";
				String disp_cls_cons_date ="&nbsp;";
				String tempDischargeDate = "";

				if(episode_type_desc.equals("OP") || episode_type_desc.equals("EM"))
				{
					if(queue_status.equals("01"))
						queue_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedIn.label","common_labels");
					else if(queue_status.equals("02"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ArrivedatNS.label","ca_labels");
					else if(queue_status.equals("03"))
						queue_status =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.VitalSignRecorded.label","op_labels");
					else if(queue_status.equals("04"))
						queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOP.ConsultationInProgress.label","op_labels");
					else if(queue_status.equals("05"))
						queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Treat/Invest.label","common_labels");
					else if(queue_status.equals("06"))
						queue_status = 		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReturnfromInvest.label","ca_labels");
					else if(queue_status.equals("07"))
						queue_status =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckedOut.label","common_labels");
					else if(queue_status.equals(" "))
						queue_status = "&nbsp;";
				}
				else if(episode_type_desc.equals("IP") || episode_type_desc.equals("DC"))
				{
					if(visit_episode_status.equals("DS"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.discharged.label","common_labels");
					else if(visit_episode_status.equals("AP"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DAPrepared.label","ca_labels");
					else if(visit_episode_status.equals("DR"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DiagnosisRec.label","ca_labels");
					else if(visit_episode_status.equals("BA"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.BedAssigned.label","ca_labels");
					else if(visit_episode_status.equals("AD"))
						queue_status =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Admitted.label","common_labels");
					else
						queue_status = "&nbsp;";
				}
				
				if(episode_type_desc.equals("OP"))
						episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
				else if(episode_type_desc.equals("IP"))
						episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
				else if(episode_type_desc.equals("EM"))
						episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
				else if(episode_type_desc.equals("DC"))
						episode_type_desc =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

				if(sex.equals("M") || sex.equals("MALE"))
						//sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
						sex="M";
				else if(sex.equals("F") || sex.equals("FEMALE"))
						//sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
						sex="F";
				else if(sex.equals("U") || sex.equals("UNKNOWN"))
						//sex = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
						sex="U";
				
				StringTokenizer st = new StringTokenizer(status,"|");
				while (st.hasMoreTokens())
				{
					emergencyYn = st.nextToken();
					deceasedYn = st.nextToken();
					String n = st.nextToken();
					if(!(n == null || n.equals("")))
						noofchildren = Integer.parseInt(n);
					relationYn = st.nextToken();
				}
				//if(rsPatList.getString("episode_type").equals("I"))
				/*{
					if(!( rsPatList.getString("discharge_date_time")==null))
						if( !rsPatList.getString("discharge_date_time").equals(""))
							className = "DISCHARGED";
				}*/
				/*else
				{
					if(!(rsPatList.getString("visit_episode_status") == null))
						if(rsPatList.getString("visit_episode_status").equals("4"))
							className = "DISCHARGED";
				}*/
				
				tempDischargeDate = rsPatList.getString("DISCHARGE_DATE_TIME") == null ? "" : rsPatList.getString("DISCHARGE_DATE_TIME");

				if(deceasedYn.equals("D"))
				{
					className="CADECEASED";
					rowclass = "DECEASED1";
					decesedColor="";
				}
				else if(deceasedYn.equals("S"))
				{
					rowclass = "GRAY";
					decesedColor="";
				}
				else
				{
					decesedColor="";
				}
				if (!deceasedYn.equals("D"))
				{	
					if(!tempDischargeDate.equals("")) className = "DISCHARGED";
					else if((noofchildren > 0)) className = "NEWBORN";
				}

				emergencyYn=rsPatList.getString("PRIORITY_ZONE")==null?"":rsPatList.getString("PRIORITY_ZONE");
				//IN044157 - Start
				if(AEZone5.equals("Y")){
				if(!emergencyYn.equals(""))
					className1 = rsPatList.getString("ae_zone_color")==null?"":rsPatList.getString("ae_zone_color");
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
				// color coding ends
				disp_cls_cons_date		 = rsPatList.getString("cls_cons_date");
				if(disp_cls_cons_date==null || disp_cls_cons_date.equals("null") || disp_cls_cons_date=="")
					disp_cls_cons_date="&nbsp;";

				if(!disp_cls_cons_date.equals("&nbsp;") )
					disp_cls_cons_date = com.ehis.util.DateUtils.convertDate(disp_cls_cons_date,"DMYHM","en",locale);

				if(rsPatList.getString("episode_type").equals("O"))
				{
					if(outpHeader==false)
					{
						out.println("<script language='javascript'>parent.parent.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Ason.label","common_labels")+": "+rsPatList.getString("QRYTIME")+"</b>';</script>");
						i++;
						i++;
					}
					String datedisplay = rsPatList.getString("adm_visit_date").substring(0,rsPatList.getString("adm_visit_date").indexOf(" "));
					if(datedisplay.equals(Sdate)) 
						datedisplay="Current Queue";
					if(unscheduledyn.equals("Y") && past.equals("N"))
					{
						String practScheduled= "Unassigned";
						if(currpract.equals("")) 	
							practScheduled = "Unassigned";
						else 
							practScheduled = "Assigned";
						currcompstring = rsPatList.getString("SPLTY_NAME")+practScheduled;
						//displaytext= rsPatList.getString("SPLTY_NAME")+", "+practScheduled;
					}
					else if(unscheduledyn.equals("N") && past.equals("Y"))
					{
						currcompstring = rsPatList.getString("SPLTY_NAME")+currvisitdate;
						//displaytext= rsPatList.getString("SPLTY_NAME")+", "+datedisplay;
					}
					else if(unscheduledyn.equals("Y") && past.equals("Y"))
					{
						String practScheduled= "Unassigned";
						if(currpract.equals("")) 	
							practScheduled = "Unassigned";
						else 
							practScheduled = "Assigned";
						currcompstring = rsPatList.getString("SPLTY_NAME")+practScheduled+currvisitdate;
						//displaytext= rsPatList.getString("SPLTY_NAME")+", "+practScheduled+", "+datedisplay;
					}							
					else
					{
						currcompstring = rsPatList.getString("SPLTY_NAME");
						//displaytext= rsPatList.getString("SPLTY_NAME");
					}
					if(!currcompstring.equals(prevcompstring))
					{
						i++;
					}
					if(locale.equals("en"))
	                {
		              DateofBirth=rsPatList.getString("DOB");
	                }
	               else
	               {
		             DateofBirth=com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale);
	               }
					//IN044157 - Start		
					out.println("<tr>");
					restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902
	             accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>"+ countvar++ +"</td><td class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td><td class=gridData nowrap><a class='gridLink' href=\"javascript:patClick('"+i+"','"+rsPatList.getString("PATIENT_ID")+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</a></td>");//ML-MMOH-CRF-1778
					//out.println("<td width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td><td class=gridData nowrap>"+rsPatList.getString("APPT_TIME")+"</td><td class=gridData nowrap>"+rsPatList.getString("QUEUE_NUM")+"</td><td class=gridData nowrap><a class='gridLink' href=\"javascript:patClick('"+i+"','"+rsPatList.getString("PATIENT_ID")+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</a></td>");
					//37866 Start.
					if(isVirtualConsSiteSpec && "OP".equals(episode_type)  && ("Y".equals(rsPatList.getString("virtualApptYN")))){
						out.println("<td  class='gridData' nowrap><a style='color:#a020f0' href='#' onclick=\"virtualConsultation('"+facility_id+"','"+rsPatList.getString("patient_id")+"','"+rsPatList.getString("episode_type")+"','"+rsPatList.getString("EPISODE_ID")+"','"+clinicianId+"');\">Virtual</a></td>");
					}else if(isVirtualConsSiteSpec && "OP".equals(episode_type)){ 	
						out.println("<td  class='gridData' width=85 nowrap>&nbsp;</td>");
					}
					//37866 End.
					out.println("<td class=gridData nowrap &nbsp;&nbsp;>"+rsPatList.getString("AGE")+"</font></td><td class=gridData nowrap >"+sex+"</td><td class=gridData nowrap >"+rsPatList.getString("PATIENT_ID")+"</td><td class=gridData nowrap >"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td>");
					if(encounterType.equals("OP")){
					out.println("<td class=gridData nowrap>"+rsPatList.getString("visit_type")+"</font></td>");
					}
					out.println("<td class=gridData nowrap>"+disp_cls_cons_date+"</font></td><td class=gridData nowrap colspan='2'>"+queue_status+"</font></td><td class=gridData nowrap>"+(rsPatList.getString("PHYSICIAN_NAME")== null ? "&nbsp;" :  rsPatList.getString("PHYSICIAN_NAME"))+"</td><td class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td class=gridData nowrap>"+DateofBirth+"</td>");
					if(rsPatList.getString("referral_id")!= null){
						out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'>"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></td></tr>");
					}
					else
					{
						out.println("<td class=gridData nowrap><a class='gridLink'>"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></td></tr>");

					}
				}
				else if(rsPatList.getString("episode_type").equals("I"))
				{
					layer = new StringBuffer();
					if(noofchildren > 0)
					{
						stmtMotherLink.setString(1,locale);
						stmtMotherLink.setString(2,rsPatList.getString("PATIENT_ID"));
						stmtMotherLink.setString(3,facility_id);
						stmtMotherLink.setString(4,rsPatList.getString("EPISODE_ID"));
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
							String apgar_score_val = rsMotherLink.getString("APGAR_SCORE")== null?"&nbsp;":rsMotherLink.getString("APGAR_SCORE");
							layer.append("<tr><td class=ORPANEL>"+rsMotherLink.getString("pat_id")+"</font></td><td class=ORPANEL>"+rsMotherLink.getString("short_name")+"</font></td><td class=ORPANEL>"+rsMotherLink.getString("sex")+"</font></td><td class=ORPANEL>"+dateofbirth1+"</font></td><td class=ORPANEL>"+rsMotherLink.getString("TIME_OF_BIRTH")+"</font></td><td class=ORPANEL>"+rsMotherLink.getString("WEIGHT")+"  "+rsMotherLink.getString("WEIGHT_UNIT")+"</font></td><td class=ORPANEL>"+rsMotherLink.getString("LENGTH_OF_BABY")+"</font></td><td class=ORPANEL>"+rsMotherLink.getString("CIRCUMFERENCE_OF_HEAD")+"</font></td><td class=ORPANEL>"+apgar_score_val+"</font></td></tr>");
						}
					}
					if(inpHeader==false)
					{
						out.println("<script language='javascript'>parent.parent.PatCriteriaFr.document.getElementById('asOn').innerHTML='<b>As on: "+rsPatList.getString("QRYTIME")+"</b>';</script>");
						i++;
						i++;
					}
					if(!currLocn.equals(rsPatList.getString("SPLTY_NAME"))) 
					{
						i++;
						currLocn=rsPatList.getString("SPLTY_NAME");
					}
				    if(locale.equals("en"))
	                {
		              DateofBirth=rsPatList.getString("DOB");
	                }
	               else
	                {
		               DateofBirth=com.ehis.util.DateUtils.convertDate(rsPatList.getString("DOB"),"DMY","en",locale);
	                }
				    restPatientYN= rsPatList.getString("restrict_reinstate_yn"); //32902
					
	             accessRightsViewPatient=bean1.getAccessRightsViewPatient(clinicianId,facility_id);	//32902
					out.println("<script>babyDetails["+rsPatList.getString("EPISODE_ID")+"]='"+layer.toString()+"';motherName["+rsPatList.getString("EPISODE_ID")+"]='"+rsPatList.getString("PATIENT_NAME")+"'</script>");
					//IN044157 - Start		
					out.println("<tr>");
					if(!emergencyYn.equals(""))
						out.println("<td style=background-color:"+className1+";FONT-SIZE:9pt;"+legendstyle+" width='16px' >&nbsp;&nbsp;&nbsp;</td>");
					else
						out.println("<td width='16px' class='"+className1+"' style='"+legendstyle+"'>&nbsp;&nbsp;&nbsp;</td>");
					//IN044157 - End
					out.println("<td onMouseOut='clearLayer()' onMouseOver= \"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td> <td class=gridData nowrap width=20>"+ countvar++  +"</td> <td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class=gridData nowrap colspan='1'><a class='gridLink' href=\"javascript:patClick('"+i+"','"+rsPatList.getString("PATIENT_ID")+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</a></font></td><td class=gridData nowrap &nbsp;&nbsp; >"+rsPatList.getString("AGE")+"</td><td class=gridData nowrap >"+sex+"</td><td class=gridData nowrap >"+rsPatList.getString("PATIENT_ID")+"</td><td class=gridData nowrap >"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td class=gridData nowrap >"+queue_status+"</td><td class=gridData  width=50 nowrap>"+disp_cls_cons_date+"</td><td class=gridData nowrap>&nbsp;&nbsp;&nbsp;"+rsPatList.getString("ROOM_NUM")+"</td><td class=gridData nowrap >&nbsp;&nbsp;&nbsp;"+rsPatList.getString("BED_NUM")+"</td><td class=gridData nowrap >&nbsp;&nbsp;&nbsp;"+(rsPatList.getString("PHYSICIAN_NAME")== null ? "&nbsp;&nbsp;&nbsp;" :  rsPatList.getString("PHYSICIAN_NAME"))+"</td><td class=gridData nowrap >&nbsp;&nbsp;"+rsPatList.getString("LOCN_NAME")+"</td><td class=gridData nowrap >&nbsp;&nbsp;"+DateofBirth+"</td>");//ML-MMOH-CRF-1778
					//out.println("<td onMouseOut='clearLayer()' onMouseOver= \"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" width='16px' class='"+className+"' style='"+legendstyle+"'><b>"+text+"</b></td> <td onMouseOut='clearLayer()' onMouseOver=\"showMotherLinks('"+rsPatList.getString("EPISODE_ID")+"',this)\" class=gridData nowrap colspan='3'><a class='gridLink' href=\"javascript:patClick('"+i+"','"+rsPatList.getString("PATIENT_ID")+"')\"><font color="+decesedColor+">"+rsPatList.getString("PATIENT_NAME")+"</a></font></td><td class=gridData nowrap>"+rsPatList.getString("AGE")+"</td><td class=gridData nowrap>"+sex+"</td><td class=gridData nowrap>"+rsPatList.getString("PATIENT_ID")+"</td><td class=gridData nowrap>"+com.ehis.util.DateUtils.convertDate(rsPatList.getString("ADM_VISIT_DATE"),"DMYHM","en",locale)+"</td><td class=gridData nowrap>"+queue_status+"</td><td class=gridData nowrap>"+disp_cls_cons_date+"</td><td class=gridData nowrap>"+rsPatList.getString("ROOM_NUM")+"</td><td class=gridData nowrap>"+rsPatList.getString("BED_NUM")+"</td><td class=gridData nowrap>"+(rsPatList.getString("PHYSICIAN_NAME")== null ? "&nbsp;" :  rsPatList.getString("PHYSICIAN_NAME"))+"</td><td class=gridData nowrap>"+rsPatList.getString("LOCN_NAME")+"</td><td class=gridData nowrap>"+DateofBirth+"</td>");
					if(rsPatList.getString("referral_id")!= null){
						out.println("<td class=gridData nowrap><a class='gridLink' href='javascript:viewReferral(\""+rsPatList.getString("referral_id")+"\")'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
					}
					else
					{
						out.println("<td class=gridData nowrap width=40 ><a class='gridLink'><font color="+decesedColor+">"+(rsPatList.getString("referral_id")== null ? "&nbsp;&nbsp;&nbsp;&nbsp;" : rsPatList.getString("referral_id")) +"</a></font></td></tr>");
					}
				}
				 // start.32902  
					
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(rsPatList.getString("restrict_reinstate_yn")));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(accessRightsViewPatient));
            _bw.write(_wl_block64Bytes, _wl_block64);

			// end. 32902 
				out.println("<script language='javascript'>");
				out.println("episodeIdArr["+i+"]='"+rsPatList.getString("EPISODE_ID")+"';");
				out.println("patient_class["+i+"]='"+rsPatList.getString("patient_class")+"';");				
				out.println("</script>");
				i++;
				k++;
				prevcompstring = currcompstring;
			}			
			if(isIP)
			{
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
 inpHeader=true;}
			if(isOP)
			{
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

									//37866 Start.
									if(isVirtualConsSiteSpec && "OP".equals(encounterType)){
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
}
									//37866 End.
									
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
if("OP".equals(encounterType)){
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
  
				 outpHeader=true;
			}
		}
		if(rsPatList!=null) rsPatList.close();
		if(stmtPatList!=null) stmtPatList.close();
		//if(rsMotherLink !=null) rsMotherLink.close();

		if(flag)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
			out.println("<script>top.content.workAreaFrame.PatResultFr.MedServResultTitle.location.href='../../eCommon/html/blank.html'</script>");
			out.println("<script>top.content.workAreaFrame.PatResultFr.LocnResult.location.href='../../eCommon/html/blank.html'</script>");
		}
		
		
		
	}
	catch(Exception e)
	{
		//out.println("1 in sub"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	
        
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(relnreqyn));
            _bw.write(_wl_block99Bytes, _wl_block99);
if(floatTitle)
		{
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block102Bytes, _wl_block102);
}
		 if(!anchorID.equals(""))
		{
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(leftScrolling));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(reOrder));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(anchorID));
            _bw.write(_wl_block108Bytes, _wl_block108);
}
            _bw.write(_wl_block109Bytes, _wl_block109);

}
catch ( Exception e) 
{
	//out.println("In Main "+e);//COMMON-ICN-0181
        e.printStackTrace();//COMMON-ICN-0181
}
finally 
{
	if(stmtMotherLink != null ) stmtMotherLink.close();
	if(con!=null)ConnectionManager.returnConnection(con,request);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiondate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Sno.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.appttime.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueNo.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsultationType.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDate.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsEndDate.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
