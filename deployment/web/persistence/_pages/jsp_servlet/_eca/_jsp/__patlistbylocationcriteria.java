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
import java.net.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __patlistbylocationcriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatListByLocationCriteria.jsp", 1745232213818L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/PatListByLocation.js\'></script> \n\t<script type=\'text/javascript\' src=\"../../eCommon/js/CommonCalendar.js\"></script>\t\t\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t\t\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<script language=javascript>\n\t\t\t\t\t   // var rows=\"30%,*,8%\";\t\n\t\t\t\t\t\t//parent.myFrameSet.rows = rows;\n\t\t\t\t\t\t\t\tparent.document.getElementById(\"PatCriteriaFr\").style.height=\"28vh\";\n\t\t\t\t\t\t\t\tparent.document.getElementById(\"PatResultFr\").style.height=\"60vh\";\n\t\t\t\t\t\t\t\tparent.document.getElementById(\"colorRefframe\").style.height=\"8vh\";\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\n\t</head>\n\t<body class=\'CONTENT\' onLoad=\'defaultGroupBy();checkboxes();checkboxes1()\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\'PatCriteriaFrm\' id=\'PatCriteriaFrm\' onload=\"callmakeless()\">\n\t\t\t<table id=\'PatCriteriaTbl\' width=\'100%\' border=\'0\' cellpadding=\'0\' cellspacing=0>\n\t\t\t\t<tr><td class =\'columnheader\' colspan=6>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td></tr>\n\t\t\t\t<tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<td class=\'LABEL\' colspan=1 width=\'25%\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t<td width=\'25%\'  class=\'fields\'>\n\t\t\t\t\t\t<select name=\'locationType\' id=\'locationType\' onchange=\'locnTypeChange(this.value)\' > \n\t\t\t\t\t\t<option value=\'Z\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\n\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\tvar val = document.PatCriteriaFrm.locationType.value;\n\t\t\t\t\t\t\t\tsetTimeout(\"locnTypeChange(val)\",100);\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'LABEL\'   id=\'locLed\' width=\'25%\'></td>\n\t\t\t\t\t\n\t\t\t\t\t<td  width=\'25%\'  class=\'fields\'>\n\n\t\t\t\t\t\t<!-- <select name=\'locationCode\' id=\'locationCode\' disabled id=\'locVal\' onChange=\'changeLocnCode(this)\'> \n\t\t\t\t\t\t\t<option value=\'*ALL\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\n\t\t\t\t\t\t</select> -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t<input type=\'text\' name=\"locationDesc\" id=\"locationDesc\" disabled id=\'locVal\' value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"  size=\'20\' maxlength=\'20\' \n\t\t\t\t\t\t onkeypress=\"\" onBlur=\"getClinicCode1(this)\"  />\n\t\t\t\t\t\t <input type=\'button\' class=\'button\' value=\'?\' id=\'src_butn\'  name=\'search_ref\'  onClick=\"getClinicCode()\"/>\n\t\t\t\t\t\t<input type=\"hidden\" name=\"locationCode\" id=\"locationCode\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'/>\n\n\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t<script language=\"JavaScript\">\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</script>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n\n\t\t\t\t\t  <script language=\"JavaScript\">\t\t\t\t\t\t \n\t\t\t\t\t\tdocument.getElementById(\'locLed\').innerText=\'\';//getLabel(\"Common.clinic.label\",\"COMMON\");\n\t\t\t\t\t\tdocument.getElementById(\'locVal\').style.visibility=\'hidden\';\n\t\t\t\t\t\tdocument.getElementById(\'src_butn\').style.visibility=\'hidden\';\n\t\t\t\t\t\tdocument.getElementById(\"locVal\").disabled = false;\n\t\t\t\t\t</script> \n\t\t\t\t\t</tr><tr>\n\t\t\t\t\t<td id=viewList class=\'LABEL\' colspan=1 width =\'25%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;</td>\n\t\t\t\t\t<td class=\'fields\' width =\'25%\'  ><select name=\'viewList\' id=\'viewList\' onchange=\'enablePract(this)\'>\n\t\t\t\t\t\t\t\t<option value=\'Z\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\t\t\n\t\t\t\t\t\t\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<td class=\'label\'  width=\'25%\' colspan=1 >";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t<td class=\'fields\' width =\'25%\' colspan=1> <input type=\'text\'  name=\'patientId\' id=\'patientId\' value=\'\' onkeydown =\'barcodeScan(event,this)\'\n\t\t\t\t\tonKeyPress=\'return CheckForSpecChars(event)\'  onBlur=\'checkDuplicate(this)\' size=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' maxlength=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' ><input type=button name=search id=search value=\'?\'  class=button tabIndex=\"4\" onClick=\"callPatientSearch()\"></td><!-- onkeydown =\'barcodeScan(event,this)\' Added for IN072184 -->\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'LABEL\' colspan=\'1\' width =\'25%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;</td>\n\t\t\t\t\t<td class=\'fields\' width =\'25%\'><input type=\'text\'  name=\'pract\' id=\'pract\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'  onKeyPress=\'\' onBlur=\'populatePract1(this)\' size=\'20\' maxlength=\'20\'><input type=\'button\' name=\'practSearch\' id=\'practSearch\' value=\'?\' class=\'button\' tabIndex=\"4\" onClick=\"populatePract()\"><input type=\"hidden\" name=\"AttendPract\" id=\"AttendPract\" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\' width=\'25%\' colspan=\'1\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t\t<td class=\'fields\' width =\'25%\' colspan=\'1\'><input type=\'text\'  name=\'specialty\' id=\'specialty\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'  onKeyPress=\'\' onBlur=\'getSpecialty1(this)\' size=\'20\' maxlength=\'20\'><input type=\'button\' name=\'search\' id=\'search\' value=\'?\'  class=\'button\' tabIndex=\"4\" onClick=\"getSpecialty()\"><input type=\"hidden\" name=\"specialty_code\" id=\"specialty_code\" value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'></td>\n\t\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<table  border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\' style=\'display:none\' id=\'moreCriteria\' name=\'moreCriteria\'  bordercolor=white>\n\t\t\t\t\t<tr >\n\t\t\t\t\t<td class=\'LABEL\' width=\'25%\' colspan=1>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t\t\t<td class=\'fields\' width=\'25%\'><input type=\'text\' name=\'queueId\' id=\'queueId\' value=\'\'  size=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'onKeyPress=\'return CheckForSpecChars(event)\' ></td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t<td class=\'label\'  width=\'25%\' >";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t<td class =\'fields\' width =\'25%\'  ><input class = \'fields\' type=\'text\' name=\'nationID\' id=\'nationID\' value=\'\'   size=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'onKeyPress=\'return CheckForSpecChars(event)\' ></td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td id=pa2 class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t\t<td class = \'fields\'><input type=\"checkbox\" name=\"past\" id=\"past\"  onClick=\"setVisitDate(this)\"></td>\n\t\t\t\t\t<td id=frv2 class=\'label\' width =\'25%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t\t\t\t<td class =\'fields\' nowrap><input class = \'fields\' id=\"from_date1\"  type=\"text\" name=\"from_date1\" id=\"from_date1\" size=10 maxlength=10 readOnly onBlur=\'validateDate(this,\"V\",\"DMY\",\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\",from_date11);doDateCheckLoc(this,from_date11,\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\",\"DMY\",\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\");\' ><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" name=\"cal_pv\" id=\"cal_pv\" onclick=\"return showCalendarValidate(\'from_date1\');\" >&nbsp;<B>-</B>&nbsp;\n\t\t\t\t\t\t<input class = \'fields\' id=\"from_date11\" type=\"text\" name=\"from_date11\" id=\"from_date11\" size=10 maxlength=10 \n\t\t\t\t\t\ttitle=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' onBlur=\'doDateCheckLoc(from_date1,this,\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\");\' readonly><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" name=\"cal_pv1\" id=\"cal_pv1\" title=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'; onclick=\"return showCalendarValidate(\'from_date11\');\" >\n\t\t\t\t\t\t</td> \n\t\t\t\t</tr>\n\t\t\t\t\t\t<script language=javascript>\n\t\t\t\t\t\t\t\tdocument.getElementById(\'cal_pv\').disabled=true;\n\t\t\t\t\t\t\t\tdocument.getElementById(\'cal_pv1\').disabled=true;\n\t\t\t\t\t\t</script>\n\t\t\t\t<tr>\n\t\t\t\t\t\t<td id=dis2  class=\'label\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t\t\t<td class=fields><input type=\"checkbox\" name=\"discharged\" id=\"discharged\" value=\'Y\' onClick=\"setDischargeDate(this)\"></td>\n\t\t\t\t\t\t<td id=frd2  class=\'label\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t\t\t<td id=frd22 class=\'fields\' nowrap><input type=\"text\" name=\"from_date2\" id=\"from_date2\" size=10 maxlength=10 readonly onBlur=\'validateDate(this,\"D\",\"DMY\",\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\",from_date22);doDateCheckLoc(this,from_date22,\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\");\' ><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" id=\"cal_di\" onclick=\"return showCalendarValidate(\'from_date2\');\">&nbsp;<B>-</B>&nbsp;\n\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\"text\" name=\"from_date22\" id=\"from_date22\" size=10 maxlength=10 onBlur=\'doDateCheckLoc(from_date2,this,\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\");\' readonly><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\" id=\"cal_di1\"  onclick=\"return showCalendarValidate(\'from_date22\');\">\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t\t\t<script language=javascript>\n\t\t\t\t\t\t\t\tdocument.getElementById(\'cal_di\').disabled=true;\n\t\t\t\t\t\t\t\tdocument.getElementById(\'cal_di1\').disabled=true;\n\t\t\t\t\t\t</script>\n\t\t\t\t<tr id=\'wtl\' style=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' >\n\t\t\t\t\t<td class=\'label\'  width=\'25%\' >";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t\t\t\t<td  class=\'fields\' colspan = \'3\' width=\'75%\' >\n\t\t\t\t<input type=\"text\" name=\"adm_fromdate\"  size=10 maxlength=10  id=\'daysVal\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'  onBlur=\'CheckDate(this);doDateCheckLoc(this,adm_todate,\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\");\'><input type=\'image\' id=adm_cal1  src=\"../../eCommon/images/CommonCalendar.gif\"  onclick=\"return showCalendarValidate(\'adm_fromdate\');\">\n\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<input type=\"text\" name=\"adm_todate\" size=10 maxlength=10 id=\'daysVal1\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'  onBlur=\'CheckDate(this);doDateCheckLoc(adm_fromdate,this,\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\");\'><input type=\'image\' src=\"../../eCommon/images/CommonCalendar.gif\"  id=adm_cal2 onclick=\"return  showCalendarValidate(\'adm_todate\');\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan = 4>\n\t\t\t\t\t<table>\n\t\t\t\t\t\t\t<tr><td id=days >&nbsp;</td></tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' colspan=\'4\'><b>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</B>&nbsp;&nbsp;&nbsp;<input type=checkbox name=\'QS\' id=\'QS\' onClick=\'checkAll(this)\'  value=\'00\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="></td> \n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=label width=\'25%\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name=\'CI\' id=\'CI\'  value=\'01\' onClick=\'appendStatus(this);\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="></td>\n\t\t\t\t\t<td  class=label width=\'25%\' >";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name=\'AAN\' id=\'AAN\'  value=\'02\' onClick=\'appendStatus(this);\' ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="&nbsp;<input type=checkbox name=\'VS\' id=\'VS\'  value=\'03\' onClick=\'appendStatus(this);\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="&nbsp;<input type=checkbox name=\'CIP\' id=\'CIP\'  value=\'04\' onClick=\'appendStatus(this);\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td  class=label width=\'25%\' >";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name=\'TI\' id=\'TI\'  value=\'05\' onClick=\'appendStatus(this);\' ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" ></td>\n\t\t\t\t\t\t\t<td  class=label width=\'25%\' >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&nbsp;<input type=checkbox name=\'RFI\' id=\'RFI\'  value=\'06\' onClick=\'appendStatus(this);\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="&nbsp;<input type=checkbox  name=\'CO\' id=\'CO\'  value=\'07\' onClick=\'appendStatus(this);\' ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" ></td>\t\n\t\t\t\t\t\t\t<td >&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<!--CRF changes starts-->\n\t\t\t\t<!--\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'label\' colspan=\'4\'><b>Referral Patients</b>&nbsp;&nbsp;&nbsp;<input type=checkbox name=\'RP\' id=\'RP\' onClick=\'checkRPAll(this)\'  value=\'N\'></td> \n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=label width=\'25%\'>On Visit Registration&nbsp;&nbsp;<input type=checkbox name=\'OVR\' id=\'OVR\'  value=\'N\' onClick=\'checkRPField(this);\' disabled ></td>\n\t\t\t\t\t<td  class=label width=\'25%\' >On Consultation In Progress &nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name=\'OCIP\' id=\'OCIP\'  value=\'N\' onClick=\'checkRPField(this);\' disabled ></td>\n\t\t\t\t\t<td  class=label width=\'25%\' >Confirmed Bed Side Referral&nbsp;<input type=checkbox name=\'CBSR\' id=\'CBSR\'  value=\'N\' onClick=\'checkRPField(this);\' disabled ></td>\n\t\t\t\t\t<td  class=label width=\'25%\' >Un Confirmed Bed Side Referral&nbsp;<input type=checkbox name=\'UCBSR\' id=\'UCBSR\'  value=\'N\' onClick=\'checkRPField(this);\' disabled></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td  class=label width=\'25%\' >On Admission&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name=\'OA\' id=\'OA\'  value=\'N\' onClick=\'checkRPField(this);\' disabled ></td>\n\t\t\t\t\t<td  class=label width=\'25%\' >On Assign Practitioner&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=checkbox name=\'OAP\' id=\'OAP\'  value=\'N\' onClick=\'checkRPField(this);\' disabled ></td>\n\t\t\t\t\t<td  class=label width=\'25%\' >&nbsp;</td>\t\n\t\t\t\t\t<td class=label width=\'25%\'  >&nbsp;</td>\n\t\t\t\t</tr>\n         -->\n\t\t\t\t<!--CRF changes Ends-->\n\t\t\t\t\t\t\t\t\n\t\t\t\t</table>\n\t\t\t\t<table  border=\'0\' cellpadding=\'0\' cellspacing=0   width=\'100%\' id=\'more1Criteria\' >\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=label width=\'25%\'  >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t\t\t\t<td width=\'25%\'  class=\'fields\'>\n\t\t\t\t\t\t\t<select name=\'visitType\' id=\'visitType\' onchange=\'visitTypeChange(this.value)\' > \n\t\t\t\t\t\t\t<option value=\"\">-----";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="-----</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t<td  id=\'asOn\' class=\'data\' >&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr id=\'bedRow\' style=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'> <!--IN29412-->\n\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t<td class=\'data\'><input class=\'fields\' type=\'text\' name=\'bedNo\' id=\'bedNo\' id=\'bedNo\' value=\'\' maxlength=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' size=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'/></td>\n\t\t\t\t</tr><!--IN29412-->\t\t\t\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=label width =\'25%\' >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t<input class = \'fields\' type=\'checkbox\' name=\'unscheduled\' id=\'unscheduled\' value=\'Y\' onClick=\'changeViewListValue(this)\' ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="></input></td>\t\n\t\t\t\t\t<td  class=\'label\' colspan=\'1\' width=\'25%\'><b>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</b>&nbsp;&nbsp;";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="<input type=\'checkbox\' name=\'groupByEpisode\' id=\'groupByEpisode\' value=\'Y\' checked ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" onclick=\'checkboxChk(this)\' ></input>&nbsp;&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="<input type=\'checkbox\' name=\'groupByLocn\' id=\'groupByLocn\' value=\'Y\' checked onclick=\'checkboxChk(this)\'></input></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t<td   class=label width =\'25%\' >";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n\t\t\t\t\t<td  class=\'data\'  ><input type=\'checkbox\' name=\'chkVirtualConsultation\' id=\'chkVirtualConsultation\' value=\'N\'  onclick=\'checkVirtualCons(this)\'></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t<td  class=\'data\' colspan=2 >&nbsp;</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t<tr><td colspan=\'4\'>&nbsp;</td></tr>\t\n\t\t\t\t\t<tr><td colspan=\'2\'>&nbsp;</td>\n\t\t\t\t\t<td align=\'right\' colspan=\'2\'> <!-- id=\'more2Criteria\' -->\n\t\t\t\t\t\t<input type=\'button\' class=\'button\' name=\'search\' id=\'search\' id = \'searchID\' onclick=\"strcon();disBtn(this);checkfields();\" \tvalue=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'></input> <!--ADDED CHECKFIELDS FUNCTION-->\n\t\t\t\t\t\t<input type=\'button\' class=\'button\' name=\'clear\' id=\'clear\' onclick=\"javascript:clearClick()\" value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'></input>\n\t\t\t\t\t\t<input type=\"button\" class=\'button\' value= \'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' name=\'more\' onClick=\"makeVisible(this,\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\');\"></input>\n\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t</tr>\t\t\t\n\t\t\t\t\n\t\t\t\t</table>\n\t\t\t\t<!-- added by arvind @ 27-11-08 -->\n\n\t\t\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\n\t\t\t\t<!-- end -->\n\t\t\t\t\n\t\t\t<input type=\"hidden\" name=\'sortOrder\' id=\'sortOrder\' value=\'v\'>\n\t\t\t<input type=\"hidden\" name=\"from_visit_date\" id=\"from_visit_date\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t\t<input type=\"hidden\" name=\"from_discharge_date\" id=\"from_discharge_date\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t\t<input type=\"hidden\" name=\"establish_reln_req_yn\" id=\"establish_reln_req_yn\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t<input type=\"hidden\" name=\"todaydate\" id=\"todaydate\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t<!-- Changes for Prevoius Next Functionality -->\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"search\">\n\t\t\t<!-- end of change-->\n\t\t\t<!-- added by ankur for saving the following values when sorting is done from fixed title bar -->\n\t\t\t<input type=\"hidden\" name=\"order_by\" id=\"order_by\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"re_order\" id=\"re_order\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"anchor_id\" id=\"anchor_id\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"locn_type\" id=\"locn_type\" value=\"\">\n\t\t\t<input type=\'hidden\' name=\'queueStatus\' id=\'queueStatus\' value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t<input type=\'hidden\' name=\'queueStatus1\' id=\'queueStatus1\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t\t\t<input type=\'hidden\' name=\'frameProperty\' id=\'frameProperty\' value=\'\'> \n\t\t\t<input type=\'hidden\' name=\'url\' id=\'url\' value=\'\'> \n\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' name=\'facilityid\' ></input>\n\t\t\t<input type=\'hidden\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' name=\'ca_practitioner_id\' ></input>\n\t\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' name=\'locale\'>\n\t\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' name=\'pract_name\'>\n\t\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' name=\'Summary\'>\n\t\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' name=\'ql_ref\'>\n\t\t\t<!--\n\t\t\t Added by Kishore kumar N on 08-07-2010\n\t\t\t-->\n\t\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' name=\'days_backward_disch_pat_id\'>\t\n\t\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' name=\'days_backward_visits_pat_id\'>\t\n\t\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' name=\'days_backward_visits\'>\t\n\t\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' name=\'days_backward_discharges\'>\t\n\t\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\' name=\'maxVisitDays\'>\t\n\t\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' name=\'maxDistDays\'>\t\n\t\t\t<input type=hidden value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' name=\'assign_confirm_referral_yn\'><!-- //IN048704 -->\n\t\t\t<!-- ends here. -->\n\t\t\t<input type=hidden name=\'past_visit_site_YN\' id=\'past_visit_site_YN\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'><!--IN063819-->\n\t\t\t<input type=hidden name=\'pre_dis_advc_prep_site_YN\' id=\'pre_dis_advc_prep_site_YN\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'><!--IN064342-->\n            <input type=\'hidden\' name=\'bar_code_scan_site_YN\' id=\'bar_code_scan_site_YN\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'><!--Added for IN072184-->\n            <input type=\'hidden\' name=\'bar_code_scaned_YN\' id=\'bar_code_scaned_YN\' value=\'\'><!--Added for IN072184-->\n\t\t\t<input type=\'hidden\' name=\'hideBedNoYN\' id=\'hideBedNoYN\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'/>\n\t\t\t<input type=\'hidden\' name=\'bedSearchAllowed\' id=\'bedSearchAllowed\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'/>  <!-- RBU-KDAH-CRF-0001 -->\n\t\t\t<input type=\'hidden\' id=\"virtualConsultation\" name=\'virtualConsultation\' id=\'virtualConsultation\' value=\'N\'/>  <!-- 51215 -->\n\t\t</form>\n\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t\t<script language=\"JavaScript\">\t\t\t\t\n\t\t\t\t\tvar relnreqyn = \'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\';\n\t\t\t\t\tvar tab_menu_yn=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\';\n\t\t\t\t\tvar queueStatus=document.forms[0].queueStatus.value;\n\n\t\t\t\t\tvar locTypefrmHomePage = \'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\';\t\t\t\t\t\n\t\t\t\t\t locnTypeChange(locTypefrmHomePage);\n\t\t\t\t\t var locnHandle = \'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\';\n\t\t\t\t\tvar locnRef=eval(locnHandle+\".colorRefframe.location\");\t\t\t\t\t\n\t\t\t\t\tlocnRef.href = \'../jsp/CAPatColorReference.jsp?reln_req_yn=\'+relnreqyn+\'&Summary=";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\';\n\t\t\t\t\t\n\t\t\t\t\tlocnRef = eval(locnHandle+\".PatResultFr.location\");\n\t\t\t\t\tlocnRef.href = \'../jsp/PatListByLocationResultMain.jsp?tab_menu_yn=\'+tab_menu_yn+\'&locationType=";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="&locationCode=*ALL&viewList=";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="&groupByLocn=Y&groupByEpisode=Y&reln_req_yn=\'+relnreqyn+\'&queueStatus=~01~,~02~,~03~,~04~,~05~,~06~&Summary=";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'+\"&bedNo=\"+document.getElementById(\'bedNo\').value+\"&virtualConsultation_yn=\"+document.getElementById(\'virtualConsultation\').value;//IN29412\n\t\t\t\t//\t}\n\t\t\t</script>\t\n\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t<script language=\"JavaScript\">\n\t\t\t\t\tvar relnreqyn = \'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\';\n\t\t\t\t\tvar queueStatus=document.forms[0].queueStatus.value;\n\t\t\t\t\tparent.PatResultFr.location.href = \'../../eCommon/html/blank.html\';\n\n\t\t\t\t\t//top.content.workAreaFrame.PatResultFr.location.href = \'../../eCommon/html/blank.html\';\n\t\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t<script>\n\t\t\tif(document.PatCriteriaFrm.viewList.value == \'S\')\n\t\t\t{\n\t\t\t\tdocument.PatCriteriaFrm.pract.disabled = true;\n\t\t\t\tdocument.PatCriteriaFrm.practSearch.disabled = true;\n\t\t\t\tdocument.PatCriteriaFrm.AttendPract.value = \'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\';\n\t\t\t\tdocument.PatCriteriaFrm.pract.value = \'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\';\n\t\t\t}\n\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\n\t\t<script>\n\t\t\n\t\tif(\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'!=\"\"){\n\t\t\tdocument.getElementById(\'locVal\').style.visibility=\'visible\';\n\t\t\tdocument.getElementById(\'src_butn\').style.visibility=\'visible\';\n\t\t\tdocument.forms[0].locationDesc.disabled = true;\n\t\t\t\n\t\tif(\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' == \'OP\') \n\t\t{\n\t\t\tdocument.getElementById(\'locLed\').innerText=getLabel(\"Common.clinic.label\",\"COMMON\");\n\t\t\tdocument.forms[0].locationDesc.disabled = false;\n\t\t\n\t\t}else if(\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' == \'IP\'){ \n\t\t\tdocument.getElementById(\'locLed\').innerText=getLabel(\"Common.nursingUnit.label\",\"COMMON\");\n\t\t\tdocument.getElementById(\"visitType\").selectedIndex = 0;\n\t\t\tdocument.getElementById(\"visitType\").disabled = true;\n\t\t\tdocument.forms[0].locationDesc.disabled = false;\n\t\t\n\t\t}else if (\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'==\'DC\'){\n\t\t\tdocument.getElementById(\'locLed\').innerText=getLabel(\"Common.DaycareUnit.label\",\"COMMON\");\n\t\t\tdocument.getElementById(\"visitType\").selectedIndex = 0;\n\t\t\tdocument.getElementById(\"visitType\").disabled = true;\n\t\t\tdocument.forms[0].locationDesc.disabled = false;\n\t\n\t\t}else if( \'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'==\'EM\'){\n\t\t\tdocument.getElementById(\'locLed\').innerText=getLabel(\"Common.EmergencyUnits.label\",\"COMMON\");\n\t\t\tdocument.getElementById(\"visitType\").selectedIndex = 0;\n\t\t\tdocument.getElementById(\"visitType\").disabled = true;\n\t\t\tdocument.forms[0].locationDesc.disabled = false;\n\t\n\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.getElementById(\"visitType\").selectedIndex = 0;\n\t\t\tdocument.getElementById(\"visitType\").disabled = true;\n\t\t}\n\t\t\n\t\tsearchClick();\n\n\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" \n\n\n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

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
-----------------------------------------------------------------------------------------------
Date       Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             100         ?           created
18/11/2011    IN29412     Dinesh T    AMS CRF
06/04/2015	  IN048704	  Nijitha S   HSA-CRF-0175 	
-----------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
05/10/2017	  IN063819		Krishna Gowtham	05/10/2017		Ramesh G			ML-MMOH-CRF-0805
23/10/2017	IN064342		Krishna Gowtham	23/10/2017		Ramesh G			GHL-CRF-0468.1
08/11/2017  IN065674		Krishna Gowtham	08/11/2017		Ramesh G			Patient List By Location Criteria Discharge 																				Date default loading issue
08/07/2020     IN072184          Chandrashekar raju     	08/07/2020       Ramesh G      Modified for MMS-DM-CRF-0157.2
14/09/2020	IN074034		Ramesh Goli			14/09/2020		Ramesh G			GHL-CRF-0613.1						
12/02/2021	6451		SIVABAGYAM M		12/02/2021	RAMESH G	GHL-CRF-0623
14/07/2022  33870			Twinkle Shah    	21/07/2022		Ramesh G        	ML-MMOH-CRF-1763
14/11/2023		51215		Ramesh												ML-MMOH-CRF-1930.2
-------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	// added by Arvind @ 27-11-08 

	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
		//IN29412,starts
	
		//Connection connection 		= null;//CheckStyle Fix
		Connection con 		= null;//CheckStyle Fix
		//con = ConnectionManager.getConnection(request);//CheckStyle Fix
		Statement patIdLenStmt 	= null;
		ResultSet patIdLenRs = null;
		String patientLength="";
		PreparedStatement pstamt = null;//6451
		ResultSet rst=null;//6451
		
		String hideBedNoYN ="N"; //6451
		try
		{
			con = ConnectionManager.getConnection(request);//CheckStyle Fix
			patIdLenStmt = con.createStatement();
			patIdLenRs = patIdLenStmt.executeQuery(" SELECT PATIENT_ID_LENGTH FROM MP_PARAM ");
			//6451
			pstamt=con.prepareStatement("SELECT HIDE_BED_NO_LISTBYLOCA_YN FROM CA_PARAM");
			rst=pstamt.executeQuery();
			if(rst.next())
			{
				hideBedNoYN=rst.getString("HIDE_BED_NO_LISTBYLOCA_YN")==null ? "":rst.getString("HIDE_BED_NO_LISTBYLOCA_YN");
			}
			//6451
			while(patIdLenRs.next())
			{
				patientLength = patIdLenRs.getString("PATIENT_ID_LENGTH");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(patIdLenRs!=null)
					patIdLenRs.close();
				if(patIdLenStmt != null) 
					patIdLenStmt.close();
				if(pstamt!=null)//6451
					pstamt.close();
				if(rst!=null)//6451
					rst.close();
				//ConnectionManager.returnConnection(con);		//CheckStyle Fix
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		//IN29412,ends

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			String toDate="";
			//Connection con = null;//CheckStyle Fix
		
			try
			{
				java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
				String locale = (String) p.getProperty("LOCALE");
				String clinicianType="";
				String ca_practitioner_id =(String)session.getValue("ca_practitioner_id");
						if(ca_practitioner_id == null) ca_practitioner_id="";
				String facilityId = (String) session.getValue("facility_id");
						if(facilityId == null) facilityId="";
				String Summary=request.getParameter("Summary")==null?"":request.getParameter("Summary");
				String ql_ref = request.getParameter("ql_ref")==null?"":request.getParameter("ql_ref");
				String default_yn = request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
				String locnType = request.getParameter("locationType")==null?"":request.getParameter("locationType"); //This value we r getting it from Home Page
				String default_sql = "";
				String login_user	= (String)session.getValue("login_user");
				String resp_id	= (String)session.getValue("responsibility_id");
				int Existance_Count = 0;
				StringBuffer default_query = new StringBuffer();
				PreparedStatement stmtsql = null;
				ResultSet rs = null;

				String sqlFilter = "";
				String column_id = "",value_type = "",	actual_value = "";
				String date_time_rel_id = "",	date_time_rel_val = "",	date_time_rel_unit = "",	relative_value = "";
				String final_value = "";
				String field_desc = "";
				String ql_disbl = "";
				Boolean ql_flag = false;
				String ql_disbl_loc = "";
				HashMap map = new HashMap();
				String dispBedRow="display:none";//IN29412

				String date_ind = "", date_val = "", date_unit = "", date_ref = "";
				StringTokenizer strToken = null;
		String  practSpDefultLocYN="N"; //33870
				String locnHandle;
				if (Summary.equals("Summary"))
					locnHandle="parent";
				else
					locnHandle="top.content.workAreaFrame";
				
				//out.println("Summary="+Summary+"\n");
				//out.println(request.getQueryString());
				String selp = "";
				String seld = "";
				String vis_sel = "";
				String visitvalue = "S";
				String days_backward_visits = "";
				String days_backward_discharges = "";
				String days_backward_visits_pat_id = "";
				String days_backward_disch_pat_id = "";
				String fromvisitdate = "";
				String fromdischargedate = "";
				String establishrelnreqyn = "";
				String assign_confirm_referral_yn = "";//IN048704
				String tab_menu_yn ="";
				String strOPFlag ="N";
				String maxVisitDays = "";
				String maxDistDays = "";
				//IN063819 starts
				//RBU-KDAH-CRF-0001 Start.
				String bedSearchAllowed = "N";
				if(CommonBean.isSiteSpecific(con, "CA", "BED_NO_SEARCH_ALLOWED"))
					bedSearchAllowed = "Y";
				//RBU-KDAH-CRF-0001 End.
				Boolean past_visit_site = CommonBean.isSiteSpecific(con, "CA", "PAST_VISIT_DATE_RANGE");
				String past_visit_site_YN = "";
				Boolean bar_code_scan_site = CommonBean.isSiteSpecific(con, "AM", "BARCODE_SCANNING_APPLICABLE");//Added for IN072184
				boolean isVirtualConsSDGSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VIRTUAL_CONSALTATION_SDG");  //51215
				String bar_code_scan_site_YN = "";
				//Adding start for IN072184
				if(bar_code_scan_site)
				{
					bar_code_scan_site_YN = "Y";
				}
				else
				{
					bar_code_scan_site_YN = "N";
				}
//Ading end for IN072184
				if(past_visit_site)
				{
					past_visit_site_YN = "Y";
				}
				else
				{
					past_visit_site_YN = "N";
				}
				/*
					 Added by Kishore kumar N on 08-07-2010
				*/
				/*String maxVisitDays ="2";
				String maxDistDays ="2";*/
				if(past_visit_site)
				{
					maxVisitDays	= "7";
					maxDistDays 	= "7";
				}
				else
				{
					maxVisitDays 	= "2";
					maxDistDays 	= "2";
				}
				//IN063819 Ends
				/* ends here.*/
				String pract_name = (String)session.getValue("practitioner_name");
				if (pract_name==null) pract_name="";
				String adm_prd_disp = "";

				if(locnType.equals("OP")||locnType.equals("EM"))
				{
				   adm_prd_disp = "display:none" ;
				}
				//con = ConnectionManager.getConnection(request);//CheckStyle Fix
				PreparedStatement pstmt = null;
				PreparedStatement stmtVt = null;
				ResultSet rset = null;
				ResultSet rsVt = null; 
				//IN064342 starts
				Boolean pre_dis_advc_prep_site = CommonBean.isSiteSpecific(con, "CA", "PRE_DIS_ADVC_PRE");
				String pre_dis_advc_prep_site_YN = "";
				if(pre_dis_advc_prep_site)
				{
					pre_dis_advc_prep_site_YN = "Y";
				}
				else
				{
					pre_dis_advc_prep_site_YN = "N";
				}
				//IN064342 ends

				if(ql_ref.equals("") && !default_yn.equals("N")&& locnType.equals(""))
				{

					default_sql = "SELECT count(*) existance_count FROM sm_quick_link_for_user a, sm_quick_link_resp b, SM_QUICK_LINK_LIST_LANG_VW c WHERE c.quick_link_ref = a.quick_link_ref AND a.quick_link_ref = b.quick_link_ref AND a.link_type = b.link_type AND a.appl_user_id = ? AND b.resp_id = ? AND b.link_type = 'F' AND a.option_id = b.option_id AND b.option_id = 'BY_LOCATION' AND c.eff_STATUS='E' AND c.LANGUAGE_ID = ? AND c.FUNCTION_SPEC_YN ='Y'";
					
					stmtsql = con.prepareStatement(default_sql);
				
					stmtsql.setString(1,login_user);
					stmtsql.setString(2,resp_id);
					stmtsql.setString(3,locale);
					rs = stmtsql.executeQuery();
					if(rs.next())
					{
						Existance_Count = rs.getInt("EXISTANCE_COUNT");
					}

					if(rs != null) rs.close();
					if(stmtsql != null) stmtsql.close();

					default_query.append("select A.QUICK_LINK_REF from ");
					if(Existance_Count>0)
						default_query.append(" SM_QUICK_LINK_FOR_USER A where A.APPL_USER_ID = ? ");
					else
						default_query.append(" SM_QUICK_LINK_RESP A where A.RESP_ID = ? ");
					default_query.append(" and OPTION_ID = 'BY_LOCATION' and LINK_TYPE = 'F' and DEFAULT_YN = 'Y' ");
					
					stmtsql = con.prepareStatement(default_query.toString());
					if(Existance_Count>0)
						stmtsql.setString(1,login_user);
					else
						stmtsql.setString(1,resp_id);
					rs = stmtsql.executeQuery();

					if(rs.next())
					{
						ql_ref = rs.getString(1) == null ? "" : rs.getString(1);
					}

					if(stmtsql != null) stmtsql.close();
					if(rs != null) rs.close();


				}
							
				if(!ql_ref.equals(""))
				{
					
					
					sqlFilter = "select a.COLUMN_ID, a.VALUE_TYPE, a.ACTUAL_VALUE, a.DATETIME_RELATIVE_IND, a.DATETIME_RELATIVE_VAL, a.DATETIME_RELATIVE_UNIT, a.RELATIVE_FIELD_REF from SM_QUICK_LINK_DEFN a where QUICK_LINK_REF = ?";
					stmtsql = con.prepareStatement(sqlFilter);
					stmtsql.setString(1,ql_ref);
					rs = stmtsql.executeQuery();

					while(rs.next())
					{
						column_id = rs.getString("COLUMN_ID") == null ? "" : rs.getString("COLUMN_ID");
						value_type = rs.getString("VALUE_TYPE") == null ? "" : rs.getString("VALUE_TYPE");
						actual_value = rs.getString("ACTUAL_VALUE") == null ? "" : rs.getString("ACTUAL_VALUE");
						date_time_rel_id = rs.getString("DATETIME_RELATIVE_IND") == null ? "" : rs.getString("DATETIME_RELATIVE_IND");
						date_time_rel_val = rs.getString("DATETIME_RELATIVE_VAL") == null ? "" : rs.getString("DATETIME_RELATIVE_VAL");
						date_time_rel_unit = rs.getString("DATETIME_RELATIVE_UNIT") == null ? "" : rs.getString("DATETIME_RELATIVE_UNIT");
						relative_value = rs.getString("RELATIVE_FIELD_REF") == null ? "" : rs.getString("RELATIVE_FIELD_REF");
						if(value_type.equals("A"))
							final_value = actual_value;
						else
						{
							if(column_id.equals("PERIOD_FROM") || column_id.equals("PERIOD_TO"))
							{
								if(!date_time_rel_id.equals("") && !date_time_rel_val.equals("") && !date_time_rel_unit.equals("") && !relative_value.equals(""))
								{
									final_value = date_time_rel_id + "|" + date_time_rel_val + "|" + date_time_rel_unit + "|" + relative_value;
								}
								else
									final_value = "";
							}
							else
								final_value = relative_value;
						}

						map.put(column_id,final_value);

					}
					
					if(stmtsql != null) stmtsql.close();
					if(rs != null) rs.close();

				}

				String	patient_id_ql = "",unassigned_ql = "",return_from_invest_ql="",
						location_chk_ql="",checked_in_ql="",treat_invest_ql = "",
						patient_class_chk_ql = "",period_to_ql = "",period_from_ql = "",
						arrived_at_ns_ql = "",speciality_ql = "",cons_in_progress_ql = "",
						vs_recorded_ql = "",checked_out_ql = "",visit_type_ql = "",
						queue_status_ql = "",clinic_ql="",view_list_ql="",patient_class_ql="",
						attend_pract_ql = "",attend_pract_ql_desc = "",speciality_ql_desc = "" ,spl_code = "" , spl_desc = "" ,clinic_ql_desc = "",queueStatus_ql="" ,queueStatus1_ql="" ;
						


				if(!ql_ref.equals(""))
				{

					ql_flag = true ;

					field_desc = (String) map.get("PATIENT_ID") == null ? "" : (String) map.get("PATIENT_ID");
					if(!field_desc.equals("")){
						patient_id_ql = field_desc;
						
					}

					field_desc = (String) map.get("UNASSIGNED") == null ? "" : (String) map.get("UNASSIGNED");
					if(field_desc.equals("Y"))
						unassigned_ql = "checked";
					else if(field_desc.equals("N"))
						unassigned_ql = "";
					   
					field_desc = (String) map.get("RETURN_FROM_INVEST") == null ? "" : (String) map.get("RETURN_FROM_INVEST");
					if(field_desc.equals("Y"))
						return_from_invest_ql = "checked";
					else if(field_desc.equals("N"))
						return_from_invest_ql = "";
					
					if(!return_from_invest_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~06~" ;
							 queueStatus_ql = "06" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~06~" ;
							  queueStatus_ql = queueStatus_ql+",06" ;
						  }
							 
					  }



					field_desc = (String) map.get("LOCATION_CHK") == null ? "" : (String) map.get("LOCATION_CHK");
					if(field_desc.equals("Y"))
						location_chk_ql = "checked";
					else if(field_desc.equals("N"))
						location_chk_ql = "";

					field_desc = (String) map.get("CHECKED_IN") == null ? "" : (String) map.get("CHECKED_IN");
					if(field_desc.equals("Y"))
						checked_in_ql = "checked";
					else if(field_desc.equals("N"))
						checked_in_ql = "";

					if(!checked_in_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~01~" ;
							 queueStatus_ql = "01" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~01~" ;
							  queueStatus_ql = queueStatus_ql+",01" ;
						  }
							 
					  }

					field_desc = (String) map.get("TREAT_INVEST") == null ? "" : (String) map.get("TREAT_INVEST");
					if(field_desc.equals("Y"))
						treat_invest_ql = "checked";
					else if(field_desc.equals("N"))
						treat_invest_ql = "";

					if(!treat_invest_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~05~" ;
							 queueStatus_ql = "05" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~05~" ;
							  queueStatus_ql = queueStatus_ql+",05" ;
						  }
							 
					  }

					field_desc = (String) map.get("PATIENT_CLASS_CHK") == null ? "" : (String) map.get("PATIENT_CLASS_CHK");
					if(field_desc.equals("Y"))
						patient_class_chk_ql = "checked";
					else if(field_desc.equals("N"))
						patient_class_chk_ql = "";  

					 
					field_desc = (String) map.get("PERIOD_FROM") == null ? "" : (String) map.get("PERIOD_FROM");
					
					
					String currDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
					int noOfdays = 0;
					if(!field_desc.equals(""))
					{
						strToken = new StringTokenizer(field_desc,"|");
						if(strToken.hasMoreTokens())
						{
							date_ind = strToken.nextToken();
							date_val = strToken.nextToken();
							date_unit = strToken.nextToken();
							date_ref = strToken.nextToken();
						}
						noOfdays = Integer.parseInt(date_val);
						
						if(date_ind.equals("B"))
						period_from_ql = com.ehis.util.DateUtils.minusDate(currDate,"DMY",locale,noOfdays,date_unit);
						else if(date_ind.equals("A"))
						period_from_ql = com.ehis.util.DateUtils.plusDate(currDate,"DMY",locale,noOfdays,date_unit);
									
					}


					field_desc = (String) map.get("PERIOD_TO") == null ? "" : (String) map.get("PERIOD_TO");
					
					if(!field_desc.equals(""))
					{
						strToken = new StringTokenizer(field_desc,"|");
						if(strToken.hasMoreTokens())
						{
							date_ind = strToken.nextToken();
							date_val = strToken.nextToken();
							date_unit = strToken.nextToken();
							date_ref = strToken.nextToken();
						}
						noOfdays = Integer.parseInt(date_val);
							
											
						if(date_ind.equals("B"))
						period_to_ql = com.ehis.util.DateUtils.minusDate(currDate,"DMY",locale,noOfdays,date_unit);
						else if(date_ind.equals("A"))
						period_to_ql = com.ehis.util.DateUtils.plusDate(currDate,"DMY",locale,noOfdays,date_unit);
									
					}


					field_desc = (String) map.get("ARRIVED_AT_NS") == null ? "" : (String) map.get("ARRIVED_AT_NS");
					if(field_desc.equals("Y"))
						arrived_at_ns_ql = "checked";
					else if(field_desc.equals("N"))
						arrived_at_ns_ql = "";

					if(!arrived_at_ns_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~02~" ;
							 queueStatus_ql = "02" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~02~" ;
							  queueStatus_ql = queueStatus_ql+",02" ;
						  }
							 
					  }



					field_desc = (String) map.get("SPECIALITY") == null ? "" : (String) map.get("SPECIALITY");
					
					speciality_ql = field_desc;
			

				
					field_desc = (String) map.get("CONS_IN_PROGRESS") == null ? "" : (String) map.get("CONS_IN_PROGRESS");
					if(field_desc.equals("Y"))
						cons_in_progress_ql = "checked";
					else if(field_desc.equals("N"))
						cons_in_progress_ql = "";

					if(!cons_in_progress_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~04~" ;
							 queueStatus_ql = "04" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~04~" ;
							  queueStatus_ql = queueStatus_ql+",04" ;
						  }
							 
					  }

					field_desc = (String) map.get("VS_RECORDED") == null ? "" : (String) map.get("VS_RECORDED");
					if(field_desc.equals("Y"))
						vs_recorded_ql = "checked";
					else if(field_desc.equals("N"))
						vs_recorded_ql = "";
					
					if(!vs_recorded_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~03~" ;
							 queueStatus_ql = "03" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~03~" ;
							  queueStatus_ql = queueStatus_ql+",03" ;
						  }
							 
					  }

					field_desc = (String) map.get("CHECKED_OUT") == null ? "" : (String) map.get("CHECKED_OUT");
					if(field_desc.equals("Y"))
						checked_out_ql = "checked";
					else if(field_desc.equals("N"))
						checked_out_ql = "";

					if(!checked_out_ql.equals(""))
					  { 
						 if(queueStatus1_ql.equals("")) 
						  {
							 queueStatus1_ql = "~07~" ;
							 queueStatus_ql = "07" ;
						  }
						  else
						  {
							  queueStatus1_ql = queueStatus1_ql+",~07~" ;
							  queueStatus_ql = queueStatus_ql+",07" ;
						  }
					  }

					/*  VISIT_TYPE */
					field_desc = (String) map.get("VISIT_TYPE") == null ? "" : (String) map.get("VISIT_TYPE");
					if(!field_desc.equals("")){
						visit_type_ql = field_desc;
					}


					field_desc = (String) map.get("QUEUE_STATUS") == null ? "" : (String) map.get("QUEUE_STATUS");
					if(field_desc.equals("Y"))
						queue_status_ql = "checked";
					else if(field_desc.equals("N"))
						queue_status_ql = "";

					/* CLINIC 	*/
					field_desc = (String) map.get("CLINIC") == null ? "" : (String) map.get("CLINIC");
					
					if(!field_desc.equals("")){
						clinic_ql = field_desc;
					}
					

					field_desc = (String) map.get("VIEW_LIST") == null ? "" : (String) map.get("VIEW_LIST");
					if(!field_desc.equals("")){
						view_list_ql = field_desc;
						
					}

					field_desc = (String) map.get("PATIENT_CLASS") == null ? "" : (String) map.get("PATIENT_CLASS");
					if(!field_desc.equals("")){
						patient_class_ql = field_desc;
						
					}
					if(patient_class_ql.equals("IP")||patient_class_ql.equals("DC"))
					{
						ql_disbl ="disabled";
						adm_prd_disp ="";
						if("N".equals(hideBedNoYN))   //IN074034
						dispBedRow="display";//IN29412
						else
							dispBedRow="display:none";

					}
					else if(patient_class_ql.equals("OP")||patient_class_ql.equals("EM"))
					{
						ql_disbl ="";
						adm_prd_disp = "display:none";

					}

					/* ATTEND_PRACT */
					field_desc = (String) map.get("ATTEND_PRACT") == null ? "" : (String) map.get("ATTEND_PRACT");
					
					if(!field_desc.equals("")){
						attend_pract_ql = field_desc;
					}
											
						String practSPLQry ="Select PRIMARY_SPECIALITY_CODE  spl_code,AM_GET_DESC.AM_SPECIALITY(PRIMARY_SPECIALITY_CODE,?,'2') spl_desc from am_practitioner D where D.PRACTITIONER_ID = ? ";

						if(speciality_ql.equals("CURR_PRACT_SPLTY_CODE"))
						{

							pstmt = con.prepareStatement(practSPLQry);
							pstmt.setString(1,locale);
							pstmt.setString(2,ca_practitioner_id);
							rset = pstmt.executeQuery();
							
							if(rset.next())
							{
									spl_code			= rset.getString("spl_code")==null?"":rset.getString("spl_code");
									spl_desc			= rset.getString("spl_desc")==null?"":rset.getString("spl_desc");
							}

							if(rset != null) rset.close();
							if(pstmt != null) pstmt.close();
						}
		}else{  //33870 Start.
			String practdSPDefaultLocQry ="SELECT PRACT_LOC_DEFAULT_YN FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID = ? ";
				
				pstmt = con.prepareStatement(practdSPDefaultLocQry);
				pstmt.setString(1,facilityId);
				rset = pstmt.executeQuery();
				
				if(rset.next())
				{
						practSpDefultLocYN			= rset.getString("PRACT_LOC_DEFAULT_YN")==null?"N":rset.getString("PRACT_LOC_DEFAULT_YN");
				}

				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
			
			if("Y".equals(practSpDefultLocYN)){
				String practSPLQry ="Select PRIMARY_SPECIALITY_CODE  spl_code,AM_GET_DESC.AM_SPECIALITY(PRIMARY_SPECIALITY_CODE,?,'2') spl_desc from am_practitioner D where D.PRACTITIONER_ID = ? ";
				
				pstmt = con.prepareStatement(practSPLQry);
				pstmt.setString(1,locale);
				pstmt.setString(2,ca_practitioner_id);
				rset = pstmt.executeQuery();
				
				if(rset.next())
				{
						spl_code			= rset.getString("spl_code")==null?"":rset.getString("spl_code");
						spl_desc			= rset.getString("spl_desc")==null?"":rset.getString("spl_desc");
				}

				if(rset != null) rset.close();
				if(pstmt != null) pstmt.close();
				
			}
		}  //33870 End.
			
					if(!period_from_ql.equals("")&&!period_to_ql.equals(""))
					{
						if(!com.ehis.util.DateUtils.isBefore( period_from_ql, period_to_ql,  "DMY",locale))
						{
							period_from_ql ="";
							period_to_ql =  "";
						}
					}


				if(view_list_ql.equals("A"))
				{
					selp = "selected";
					visitvalue = "Z";
				}
				else if(view_list_ql.equals("S"))
				{
					seld = "selected";
				}
				else{
				
					if(clinicianType.equals("P")||ql_flag)
				{
					selp = "selected";
					visitvalue = "Z";
				}
				else
				{
					seld = "selected";
				}
				}

				try
				{			
							
				//String sql = " select to_char(sysdate-LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 2), DAYS_BACKWARD_VISITS),'dd/mm/yyyy') from_visit_date, to_char(sysdate-LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 2),DAYS_BACKWARD_DISCHARGES),'dd/mm/yyyy') from_discharge_date, establish_reln_req_yn, tab_menu_yn ,  AM_GET_DESC.AM_PRACTITIONER(?,?,1) performed_by_name,AM_GET_DESC.AM_SPECIALITY(?,?,'2') spl_desc,( Select decode(locn_type,'C',OP_GET_DESC.OP_CLINIC(?,locn_code,?,'1'), 'W',   IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'1') ) from ca_pract_by_locn_view    where  locn_code = ? and  practitioner_id = ? and locn_type in ('C','W') and facility_id = ? and rownum=1 ) clinic_ql_desc,LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 2), DAYS_BACKWARD_VISITS) MAX_ALLOW_VISIT_DAYS, to_char(sysdate-DAYS_BACKWARD_VISITS,'dd/mm/yyyy') DAYS_BACKWARD_VISITS, to_char(sysdate-DAYS_BACKWARD_DISCHARGES,'dd/mm/yyyy') DAYS_BACKWARD_DISCHARGES, LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 2),DAYS_BACKWARD_DISCHARGES) MAX_ALLOW_DISCHARGE_DAYS, NVL(DAYS_BACKWARD_VISITS, 2) DAYS_BACKWARD_VISITS_PAT_ID,NVL(DAYS_BACKWARD_DISCHARGES, 2) DAYS_BACKWARD_DISCH_PAT_ID  from ca_encntr_param ";
				//IN063819 Start
				//String sql = " select to_char(sysdate-LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 2), DAYS_BACKWARD_VISITS),'dd/mm/yyyy') from_visit_date, to_char(sysdate-LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 2),DAYS_BACKWARD_DISCHARGES),'dd/mm/yyyy') from_discharge_date, establish_reln_req_yn, tab_menu_yn ,  AM_GET_DESC.AM_PRACTITIONER(?,?,1) performed_by_name,AM_GET_DESC.AM_SPECIALITY(?,?,'2') spl_desc,( Select decode(locn_type,'C',OP_GET_DESC.OP_CLINIC(?,locn_code,?,'1'), 'W',   IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'1') ) from ca_pract_by_locn_view    where  locn_code = ? and  practitioner_id = ? and locn_type in ('C','W') and facility_id = ? and rownum=1 ) clinic_ql_desc,LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 2), DAYS_BACKWARD_VISITS) MAX_ALLOW_VISIT_DAYS, to_char(sysdate-DAYS_BACKWARD_VISITS,'dd/mm/yyyy') DAYS_BACKWARD_VISITS, to_char(sysdate-DAYS_BACKWARD_DISCHARGES,'dd/mm/yyyy') DAYS_BACKWARD_DISCHARGES, LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 2),DAYS_BACKWARD_DISCHARGES) MAX_ALLOW_DISCHARGE_DAYS, NVL(DAYS_BACKWARD_VISITS, 2) DAYS_BACKWARD_VISITS_PAT_ID,NVL(DAYS_BACKWARD_DISCHARGES, 2) DAYS_BACKWARD_DISCH_PAT_ID,ASSGN_CONF_REF_YN  from ca_encntr_param ";//IN048704
				String sql = "";
				if(past_visit_site){
					sql = " select to_char(sysdate-LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 7), DAYS_BACKWARD_VISITS),'dd/mm/yyyy') from_visit_date, to_char(sysdate-LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 7),DAYS_BACKWARD_DISCHARGES),'dd/mm/yyyy') from_discharge_date, establish_reln_req_yn, tab_menu_yn ,  AM_GET_DESC.AM_PRACTITIONER(?,?,1) performed_by_name,AM_GET_DESC.AM_SPECIALITY(?,?,'2') spl_desc,( Select decode(locn_type,'C',OP_GET_DESC.OP_CLINIC(?,locn_code,?,'1'), 'W',   IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'1') ) from ca_pract_by_locn_view    where  locn_code = ? and  practitioner_id = ? and locn_type in ('C','W') and facility_id = ? and rownum=1 ) clinic_ql_desc,LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 7), DAYS_BACKWARD_VISITS) MAX_ALLOW_VISIT_DAYS, to_char(sysdate-DAYS_BACKWARD_VISITS,'dd/mm/yyyy') DAYS_BACKWARD_VISITS, to_char(sysdate-DAYS_BACKWARD_DISCHARGES,'dd/mm/yyyy') DAYS_BACKWARD_DISCHARGES, LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 7),DAYS_BACKWARD_DISCHARGES) MAX_ALLOW_DISCHARGE_DAYS, NVL(DAYS_BACKWARD_VISITS, 7) DAYS_BACKWARD_VISITS_PAT_ID,NVL(DAYS_BACKWARD_DISCHARGES, 7) DAYS_BACKWARD_DISCH_PAT_ID,ASSGN_CONF_REF_YN  from ca_encntr_param ";
				}
				else{
					sql = " select to_char(sysdate-LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 2), DAYS_BACKWARD_VISITS),'dd/mm/yyyy') from_visit_date, to_char(sysdate-LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 2),DAYS_BACKWARD_DISCHARGES),'dd/mm/yyyy') from_discharge_date, establish_reln_req_yn, tab_menu_yn ,  AM_GET_DESC.AM_PRACTITIONER(?,?,1) performed_by_name,AM_GET_DESC.AM_SPECIALITY(?,?,'2') spl_desc,( Select decode(locn_type,'C',OP_GET_DESC.OP_CLINIC(?,locn_code,?,'1'), 'W',   IP_GET_DESC.IP_NURSING_UNIT(?,locn_code,?,'1') ) from ca_pract_by_locn_view    where  locn_code = ? and  practitioner_id = ? and locn_type in ('C','W') and facility_id = ? and rownum=1 ) clinic_ql_desc,LEAST(NVL(MAX_ALLOW_VISIT_DAYS, 2), DAYS_BACKWARD_VISITS) MAX_ALLOW_VISIT_DAYS, to_char(sysdate-DAYS_BACKWARD_VISITS,'dd/mm/yyyy') DAYS_BACKWARD_VISITS, to_char(sysdate-DAYS_BACKWARD_DISCHARGES,'dd/mm/yyyy') DAYS_BACKWARD_DISCHARGES, LEAST(NVL(MAX_ALLOW_DISCHARGE_DAYS, 2),DAYS_BACKWARD_DISCHARGES) MAX_ALLOW_DISCHARGE_DAYS, NVL(DAYS_BACKWARD_VISITS, 2) DAYS_BACKWARD_VISITS_PAT_ID,NVL(DAYS_BACKWARD_DISCHARGES, 2) DAYS_BACKWARD_DISCH_PAT_ID,ASSGN_CONF_REF_YN  from ca_encntr_param ";
				}
				//IN063819 Ends
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,attend_pract_ql);
				pstmt.setString(2,locale);
				pstmt.setString(3,speciality_ql);
				pstmt.setString(4,locale);
				pstmt.setString(5,facilityId);
				pstmt.setString(6,locale);
				pstmt.setString(7,facilityId);
				pstmt.setString(8,locale);
				pstmt.setString(9,clinic_ql);
				pstmt.setString(10,ca_practitioner_id);
				pstmt.setString(11,facilityId);
				rset = pstmt.executeQuery();
				if(rset.next())
				{
						days_backward_visits_pat_id			= rset.getString("DAYS_BACKWARD_VISITS_PAT_ID")==null?"":rset.getString("DAYS_BACKWARD_VISITS_PAT_ID");
						//IN065674 Start
						//days_backward_disch_pat_id			= rset.getString("DAYS_BACKWARD_VISITS")==null?"":rset.getString("DAYS_BACKWARD_DISCH_PAT_ID");
						days_backward_disch_pat_id			= rset.getString("DAYS_BACKWARD_DISCH_PAT_ID")==null?"":rset.getString("DAYS_BACKWARD_DISCH_PAT_ID");
						//IN065674 Ends
						days_backward_visits			= rset.getString("DAYS_BACKWARD_VISITS")==null?"":rset.getString("DAYS_BACKWARD_VISITS");
						days_backward_discharges			= rset.getString("DAYS_BACKWARD_DISCHARGES")==null?"":rset.getString("DAYS_BACKWARD_DISCHARGES");
						fromvisitdate			= rset.getString("from_visit_date")==null?"":rset.getString("from_visit_date");
						fromdischargedate		= rset.getString("from_discharge_date")==null?"":rset.getString("from_discharge_date");
						establishrelnreqyn		= rset.getString("establish_reln_req_yn")==null?"Y":rset.getString("establish_reln_req_yn");
						tab_menu_yn				=(rset.getString("tab_menu_yn")==null)?"":rset.getString("tab_menu_yn");
						attend_pract_ql_desc				=(rset.getString("performed_by_name")==null)?"":rset.getString("performed_by_name");
						speciality_ql_desc				=(rset.getString("spl_desc")==null)?"":rset.getString("spl_desc");
						clinic_ql_desc				=(rset.getString("clinic_ql_desc")==null)?"":rset.getString("clinic_ql_desc");
						assign_confirm_referral_yn =(rset.getString("ASSGN_CONF_REF_YN")==null)?"":rset.getString("ASSGN_CONF_REF_YN");//IN048704
						/*
							Added by Kishore kumar N on 08-07-2010
						*/
						//IN063819 Start
						/*maxVisitDays = rset.getString("MAX_ALLOW_VISIT_DAYS")==null?"2":rset.getString("MAX_ALLOW_VISIT_DAYS");
						maxDistDays = rset.getString("MAX_ALLOW_DISCHARGE_DAYS")==null?"2":rset.getString("MAX_ALLOW_DISCHARGE_DAYS");*/
						if(past_visit_site)
						{
							maxVisitDays = rset.getString("MAX_ALLOW_VISIT_DAYS")==null?"7":rset.getString("MAX_ALLOW_VISIT_DAYS");
							maxDistDays = rset.getString("MAX_ALLOW_DISCHARGE_DAYS")==null?"7":rset.getString("MAX_ALLOW_DISCHARGE_DAYS");
						}
						else
						{
							maxVisitDays = rset.getString("MAX_ALLOW_VISIT_DAYS")==null?"2":rset.getString("MAX_ALLOW_VISIT_DAYS");
							maxDistDays = rset.getString("MAX_ALLOW_DISCHARGE_DAYS")==null?"2":rset.getString("MAX_ALLOW_DISCHARGE_DAYS");
						}
						//IN063819 Ends
						/*
							ends here.
						*/
				}
				if(speciality_ql.equals("CURR_PRACT_SPLTY_CODE"))
				{
					speciality_ql = spl_code;
					speciality_ql_desc = spl_desc;

				}else if(ql_ref.equals("")){  //33870 Start.
					if("Y".equals(practSpDefultLocYN)){
						speciality_ql = spl_code;
						speciality_ql_desc = spl_desc;
					}
				}  //33870 End.

				
				fromvisitdate		=	com.ehis.util.DateUtils.convertDate(fromvisitdate,"DMY","en",locale);
				fromdischargedate	=   com.ehis.util.DateUtils.convertDate(fromdischargedate,"DMY","en",locale);

				if(rset!=null)rset.close();
				if(pstmt != null)pstmt.close();

				if (tab_menu_yn.equals("N"))
				{ 
					
            _bw.write(_wl_block8Bytes, _wl_block8);

				}

				toDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}
	 
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
	
						 String  sql = "select PATIENT_CLASS, SHORT_DESC  from  am_patient_class_lang_vw where LANGUAGE_ID=? and  patient_class in ('OP','IP','EM','DC') order by 2 ";
			  				

							pstmt = con.prepareStatement(sql);
							pstmt.setString(1,locale);

							rset = pstmt.executeQuery();
					
            _bw.write(_wl_block11Bytes, _wl_block11);

										
										String display="";
							if(ql_flag && patient_class_ql.equals(""))
							{
								ql_disbl_loc = "selected";
							}
							else
							{
								ql_disbl_loc = "";

							}
						
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(ql_disbl_loc));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
 while (rset.next())
							{
											if(patient_class_ql.equals(rset.getString("PATIENT_CLASS")))
											{
												
												display=rset.getString("PATIENT_CLASS")+"    selected ";	
											}
											else
											{
												if(locnType.equals(rset.getString("PATIENT_CLASS"))&&!ql_flag)
												display=rset.getString("PATIENT_CLASS")+"    selected ";
											else
											{
												
												display=rset.getString("PATIENT_CLASS");
											
												if(display.equals("OP") && locnType.equals("") &&!ql_flag)
												{
													strOPFlag ="Y";
													display = display + "  selected";
													adm_prd_disp = "display:none" ;
												}
											}
											}

										out.println("<option value="+display+">"+rset.getString("SHORT_DESC")+"</option>");
							}	
							
							if(rset!=null)rset.close();
							if(pstmt != null)pstmt.close();

							if(strOPFlag.equals("Y"))
							{
            _bw.write(_wl_block16Bytes, _wl_block16);
}
							
							 
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

							if(ql_ref.equals("")|| clinic_ql.equals(""))
							{
								clinic_ql = "*ALL";
							}
							else if(!ql_ref.equals("") && clinic_ql_desc.equals("")) //Added By Jyothi on 02/06/2010 to fix IN020967
								clinic_ql = "";
							
						
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(clinic_ql_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(clinic_ql));
            _bw.write(_wl_block21Bytes, _wl_block21);
	if(!locnType.equals("")){ // this condition will be get fired when you are calling this page from Home Page
            _bw.write(_wl_block22Bytes, _wl_block22);
 }
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(selp));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(seld));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

					String PatIDLen  = "";
					String QIDLen	  = "";
					String QIDLegend = "";
					String nationID ="";
					String nationLen="";
		
					String sqlLen ="Select a.PATIENT_ID_LENGTH,a.ALT_ID1_LENGTH,MP_GET_DESC.MP_ALTERNATE_ID_TYPE(a.alt_id1_type,?,'2') short_desc,a.NAT_ID_LENGTH,(select NAT_ID_PROMPT from  MP_PARAM_LANG where LANGUAGE_ID= ? ) NAT_ID_PROMPT from mp_param a" ;
					PreparedStatement stmtLen = con.prepareStatement(sqlLen);
					stmtLen.setString(1,locale);
					stmtLen.setString(2,locale);

					ResultSet rsetLen = null;
					rsetLen  = stmtLen.executeQuery();
					while(rsetLen.next())
					{
						PatIDLen   = (rsetLen.getString("PATIENT_ID_LENGTH")==null)?"0":rsetLen.getString("PATIENT_ID_LENGTH");
						nationID = (rsetLen.getString("NAT_ID_PROMPT")==null)?"0":rsetLen.getString("NAT_ID_PROMPT");
						nationLen =(rsetLen.getString("NAT_ID_LENGTH")==null)?"0":rsetLen.getString("NAT_ID_LENGTH");
					    QIDLen	   = (rsetLen.getString("ALT_ID1_LENGTH")==null)?"0":rsetLen.getString("ALT_ID1_LENGTH");
						QIDLegend  = (rsetLen.getString("short_desc")==null)?"0":rsetLen.getString("short_desc");
					}
					if(rsetLen !=null) rsetLen.close();
					if(stmtLen !=null)stmtLen.close();
				
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(PatIDLen));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(PatIDLen));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(attend_pract_ql_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(attend_pract_ql));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(speciality_ql_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(speciality_ql));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(QIDLegend));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(QIDLen));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(QIDLen));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(nationID));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(nationLen));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(nationLen));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChangeIfPatIdGiven.label","ca_labels")));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ChangeIfPatIdGiven.label","ca_labels")));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(adm_prd_disp));
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(period_from_ql));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(period_to_ql));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(ql_disbl));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(checked_in_ql));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ql_disbl));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(arrived_at_ns_ql));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ql_disbl));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(vs_recorded_ql));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ql_disbl));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(cons_in_progress_ql));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ql_disbl));
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(treat_invest_ql));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ql_disbl));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(return_from_invest_ql));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ql_disbl));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(checked_out_ql));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ql_disbl));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);


								String visit_qry = " select VISIT_TYPE_CODE, SHORT_DESC,VISIT_TYPE_IND from OP_VISIT_TYPE where FACILITY_ID = ? order by 2 " ;

								stmtVt = con.prepareStatement(visit_qry);
				
								stmtVt.setString(1,facilityId);
								
								rsVt = stmtVt.executeQuery();
								while(rsVt.next())
								{

								  if(visit_type_ql.equals(rsVt.getString("VISIT_TYPE_CODE")))
								  {
										vis_sel = "selected";
								  }
									else
								  {
										vis_sel = "";
								  }
									
									out.println("<option value="+rsVt.getString("VISIT_TYPE_CODE")+" "+vis_sel+" >"+rsVt.getString("SHORT_DESC")+"</option>");

								}

								if(rsVt!=null) rsVt.close();
								if(stmtVt!=null) stmtVt.close();
							
							
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(dispBedRow));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(patientLength));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(patientLength));
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(unassigned_ql));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(ql_disbl));
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(ql_disbl));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);
if(isVirtualConsSDGSpec){
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
}else{
            _bw.write(_wl_block90Bytes, _wl_block90);
}
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.morecriteria.label","common_labels")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(tab_menu_yn));
            _bw.write(_wl_block95Bytes, _wl_block95);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block97Bytes, _wl_block97);
}
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(fromvisitdate));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(fromdischargedate));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(establishrelnreqyn));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(toDate ));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(queueStatus_ql));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(queueStatus1_ql));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(Summary));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(ql_ref));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(days_backward_disch_pat_id));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(days_backward_visits_pat_id));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(days_backward_visits));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(days_backward_discharges));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(maxVisitDays));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(maxDistDays));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(assign_confirm_referral_yn));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(past_visit_site_YN));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(pre_dis_advc_prep_site_YN));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(bar_code_scan_site_YN));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(hideBedNoYN));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(bedSearchAllowed));
            _bw.write(_wl_block122Bytes, _wl_block122);
	if(!locnType.equals("")){ // this condition will be get fired when you are calling this page from Home Page
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(establishrelnreqyn));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(tab_menu_yn));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(locnType));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(locnHandle));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(Summary));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(locnType));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(visitvalue));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(Summary));
            _bw.write(_wl_block131Bytes, _wl_block131);
 }else{ 
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(establishrelnreqyn));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(tab_menu_yn));
            _bw.write(_wl_block133Bytes, _wl_block133);
}
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(ca_practitioner_id));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block136Bytes, _wl_block136);
 if(!ql_ref.equals("")){
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(patient_class_ql));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(patient_class_ql));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(patient_class_ql));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(patient_class_ql));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(patient_class_ql));
            _bw.write(_wl_block142Bytes, _wl_block142);
}
            _bw.write(_wl_block143Bytes, _wl_block143);

	map.clear();//Checkstyle fix
}
catch(Exception e)
{
	
	e.printStackTrace();
}
finally 
{
	if (con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block144Bytes, _wl_block144);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SearchCriteria.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ViewList.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SelfRelated.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Specialty.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PastVisits.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.discharged.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Period.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.AdmittedPeriod.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.QueueStatus.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CheckedIn.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ArrivedatNS.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.VSRecorded.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ConsInProgress.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Treat/Invest.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.ReturnfromInvest.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CheckedOut.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.BedNo.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unassigned.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.groupby.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.virtualConsultation.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
