package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.lang.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __oncologyregimenadmindetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/OncologyRegimenAdminDetail.jsp", 1743130557366L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n \n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\n\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"javascript\" src=\"../../ePH/js/OncologyRegimen.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../ePH/js/PhCommon.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<!-- \t<body> -->\n<body onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\t\t<form name=\"oncologyRegimenAdminDetail\" id=\"oncologyRegimenAdminDetail\">\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<th colspan=\"6\"><font style=\"font-size:9\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</font></th>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<tr NOWRAP>\n\t\t\n\t\t\t\t\t\t\t<td  class=\"label\" nowrap style=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' COLSPAN=2 id=\"InfusionRate\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;\n\t\t\t\t\t\t\t\t<input type=\"text\" name=\"infusion_rate\" id=\"infusion_rate\"  value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" size=\"2\" maxlength=\"9\" class=\"number\"  onBlur=\"checkValue(this);calInfuseOver()\" onKeyPress=\"return allowValidNumber(this,event,6,2);\"><label width=\'5%\'class=\'label\' id=\"infuse_rate_uom\"><b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></label>\n\t\t\t\t\t\t\t\t<label class=\'label\'><b>/</b></label>\n\t\t\t\t\t\t\t\t<select name=\"infusion_period_uom\" id=\"infusion_period_uom\" onChange=\"ChangeInfuseOverTime(this)\">\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"M\" SELECTED>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t\t\t\t\t\t\t\t\t<option value=\"H\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t\t\t\t\t\t\t<!--\t<option value=\"D\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>-->\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"M\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</option>\n\t\t\t\t\t\t\t\t\t\t<option value=\"H\" SELECTED>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</option>\n\t\t\t\t\t\t\t\t\t<!--<option value=\"D\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</option>\n\t\t\t\t\t\t\t\t\t\t<!-- <option value=\"D\" SELECTED>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</option> -->\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"M\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</option>\n\t\t\t\t\t\t\t\t\t\t<!-- <option value=\"D\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\" id = \"inf_rate_mand\"></img>\n\t\t\t\t\t\t\t</td>\n\t\t\n\t\t\t\t\t\t\t<td class=\'label\' nowrap ><font class=label style=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font>&nbsp;<input type=\'checkbox\' name=\'adMixture\' id=\'adMixture\'  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'  ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" onclick=\"setvalue(this),checkadmixture(oncologyRegimenAdminDetail,\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\',\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\')\" style=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">&nbsp;\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t<!--  RUT-CRF-0062 [IN029600] Added buildMAR_enable  to get enable/ disable based on Build MAR Rule -->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="&nbsp;\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="  onclick=\'assignValue(this);\'>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\"N\" disabled >\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="&nbsp;\n\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'N\' disabled>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t<label nowrap style=\'color:red;font-size:10\' id=\"dosage_label_cycle\" onMouseOver=\"displayCycleToolTip(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\')\" onmouseout=\'disasbleToolTipDataChange1();\'> Scheduled Dose</label>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'label\' nowrap style=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\"InfusionOver\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="&nbsp;\n\t\t\t\t\t\t\t<input type=text size=2 maxlength =9 name=\'infusion_period_value\' id=\'infusion_period_value\'  class=\"number\" colspan=\"2\"  value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" onblur=\'calInfusionRate();\' onKeyPress=\"return allowValidNumber(this,event,6,2);\">&nbsp;\n\t\t\t\t\t\t\t<label width=\'5%\'class=\'label\' id=\"infuse_over_time\"><b>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</b></label>\n\t\t\t\t\t\t\t<br><label width=\'5%\'class=\'label\' id=\"infuse_over_str\"></label>\n\t\t\t\t\t\t\t&nbsp;</td>\n\t\t\t\t\t\t\t <input type=hidden  name=\"infuse_over_time_value\" id=\"infuse_over_time_value\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t   <tr height=\'30\'>\n\t\t\t\t\t\t <td class=\"label\" colspan=\'2\' >&nbsp;&nbsp;&nbsp;</td>\n\t\t<!--  RUT-CRF-0062 [IN029600] Added buildMAR_enable flag to get enable/ disable based on Build MAR Rule -->\n\t\t\t\t\t\t <td class=\'label\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" <input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="  onclick=\'assignValue(this);\'  >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t <label nowrap style=\'color:red;font-size:10\' id=\"dosage_label_cycle\" onMouseOver=\"displayCycleToolTip(\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\" onmouseout=\'disasbleToolTipDataChange1();\'> Scheduled Dose</label>\n\t\t\t\t\t\t ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t </td>\n\t\t\t\t\t\t <td class=\"label\" >&nbsp;&nbsp;&nbsp;</td>\n\t\t\t\t\t  </tr>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t<tr nowrap>\n\t\t\t\t\t<td width=\"5%\" class=\"label\" id =\"Frequency_lbl\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t\t\t\t<td COLSPAN=3 id =\"frequency_selection\">\n\t\t\t\t\t\t<select name=\"frequency\" id=\"frequency\" onChange=\"checkScheduledYN(this.value);setSchedule();ExternalDosageCheck(\'\',\'admndtl\',\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\');changeDate();setCycleFreqDetails(this,\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\')\" style=\"width:500;\" >\n\t\t\t\t\t\t\t<option value=\"\">&nbsp;--- ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" ---&nbsp;</option>\n";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" selected>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</option>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\" border=\"0\" id = \"freq_mand\"></img>&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\t\t\t<input type=\"button\" name=\"btn_schedule\" id=\"btn_schedule\" value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' class=\"button\" onClick=\"DisplaySchedule()\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t<input type=\"button\" name=\"btn_schedule_cycle\" id=\"btn_schedule_cycle\" value=\'Cycle\' class=\"button\" onClick=\"DisplayCycle(\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\')\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"sched_medn_yn\" id=\"sched_medn_yn\" value=\"N\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t <tr>\n\t\t\t\t\t<td class=\"label\" id =\"duration_lbl\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</TD>\n\t\t\t\t\t<td  COLSPAN=2><input type=\"text\" name=\"durn_value\" id=\"durn_value\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" size=\"5\" maxlength=\"6\" class=\"number\"  onBlur=\"chkDuration(this,true);ExternalDosageCheck(\'\',\'admndtl\',\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\')\" onKeyPress=\"return allowValidNumber(this,event,5,0);\">\n\t\t\t\t\t\t<select name=\"durn_unit\" id=\"durn_unit\"  onChange=\"chkDuration(document.oncologyRegimenAdminDetail.durn_value,true);checkScheduledYN(document.oncologyRegimenAdminDetail.frequency.value);\t\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\t\t\t\t\t\t\t\n\t\t\t\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\" border=\"0\" id = \"durn_mand\"></img>&nbsp;\n\t\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t<A HREF onMouseOver=\"changeCursor(this);\" onClick=\" showOverRideRemarks(\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\" style=\"font-size:10;font-weight:bold;color:blue;visibility:hidden\"  id=\"dosage_label\">";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</A>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\" id=\"mand2\"  style=\"visibility:hidden\"></img></td>\n\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t <A HREF onMouseOver=\"changeCursor(this);\" onClick=\" showOverRideRemarks(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\n\t\t</tr>\n\t\t <tr>\n\t\t\n\t\t<td  class=\"label\" nowrap id =\"StartDateLbl\">";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</td>\t\t\t\n\t\t<td ><!-- setCycleFreqDetails added for ml-mmoh-scf-1050  -->\n\t\t\t<input type=\"text\" name=\"start_date\" id=\"start_date\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" SIZE=\"13\" MAXLENGTH=\"16\" onBlur=\"if(CheckDateLeap(this,\'DMYHM\',\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\')){changeDate();}setCycleFreqDetails(oncologyRegimenAdminDetail.frequency,\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\')\"> \n\t\t\t<!-- validateDate(this) changed to CheckDateLeap for RollForward from SRR - SRR20056-SCF-9366[IN 57051] -->\n\t\t\t<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onclick=\"showCalendar(\'start_date\',null,\'hh:mm\');\n\t\t\tdocument.oncologyRegimenAdminDetail.start_date.focus();return false;\" > \n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" BORDER=\"0\" id=\"start_date_mand\"></img>\n\t\t</td>\t\t\n\t\t<td  class=\"label\" nowrap id=\"end_date_lbl\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="&nbsp;\n\t\t<input type=\"text\" name=\"end_date\" id=\"end_date\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" size=\"13\" maxlength=\"16\" readonly>\n\t\t<input type=\"hidden\" name=\"ocurrance_num\" id=\"ocurrance_num\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" ><!--//ML-MMOH-CRF-1014 -->\n\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t<tr height=\'30\'><td class=\"label\" colspan=\'6\' >&nbsp;&nbsp;&nbsp;</td></tr>  \n\t\t</tr>\n\t\t<tr>\n\t\t<tr height=\'30\'><td class=\"label\" colspan=\'6\' >&nbsp;&nbsp;&nbsp;</td></tr>  \n\t\t</tr>\n\t\t</table>\n\t\n\t\t<input type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t<input type=\"hidden\" name=\"perform_external_database_checks_yn\" id=\"perform_external_database_checks_yn\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t<input type=\"hidden\" name=\"locn_type\" id=\"locn_type\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t<input type=\"hidden\" name=\"locn_code\" id=\"locn_code\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t\t<input type=\"hidden\" name=\"repeat_value\" id=\"repeat_value\" value=\"\">\n\t\t<input type=\"hidden\" name=\"freq_nature\" id=\"freq_nature\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t<input type=\"hidden\" name=\"schedulereqdyn\" id=\"schedulereqdyn\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t\t<input type=\"hidden\" name=\"overridereason_mand\" id=\"overridereason_mand\"\tvalue=\"N\">\n\t\t<input type=\"hidden\" name=\"overridereason_flag\" id=\"overridereason_flag\"\tvalue=\"N\">\n\t\t<input type=\"hidden\" name=\"srlNo\" id=\"srlNo\"\tvalue=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t<input type=\"hidden\" name=\"freq_chng_durn_desc\" id=\"freq_chng_durn_desc\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t<input type=\"hidden\" name=\"amend_durn_type\" id=\"amend_durn_type\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t<input type=\"hidden\" name=\"amend_durn_value\" id=\"amend_durn_value\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t<input type=\"hidden\" name=\"disp_durn_type\" id=\"disp_durn_type\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t<input type=\"hidden\" name=\"repeat_durn_type\" id=\"repeat_durn_type\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t<input type=\"hidden\" name=\"no_of_cycle\" id=\"no_of_cycle\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\"><!-- added for ML-MMOH-CRF-0345 -->\n\t\t<input type=\"hidden\" name=\"drug_code\" id=\"drug_code\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\"><!-- added for ML-MMOH-CRF-0345 -->\n\t\t<input type=\"hidden\" name=\"order_type_flag\" id=\"order_type_flag\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\"><!-- added for ML-MMOH-CRF-0345 -->\n\t\t<input type=\"hidden\" name=\"Def_freq_code\" id=\"Def_freq_code\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\"><!-- ML-MMOH-CRF-1014 -->\n\t\t<input type=\"hidden\" name=\"def_durn_type\" id=\"def_durn_type\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\"><!-- ML-MMOH-CRF-1014 -->\n\t\t<input type=\"hidden\" name=\"def_durn_value\" id=\"def_durn_value\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\"><!-- ML-MMOH-CRF-1014 -->\n\t\t<input type=\"hidden\" name=\"amend_yn\" id=\"amend_yn\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\"><!-- ML-MMOH-CRF-1014 -->\n\t\t\n\t\t<input type=\"hidden\" name=\"site_spec_YN\" id=\"site_spec_YN\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"><!-- ML-MMOH-CRF-1224 -->\n\t\t<input type=\"hidden\" name=\"infusion_over_insert_value\" id=\"infusion_over_insert_value\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"><!-- ML-MMOH-CRF-1014 -->\n\t\t<input type=\"hidden\" name=\"mfr_yn_value\" id=\"mfr_yn_value\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\"><!-- ML-MMOH-CRF-1014 -->\n\t\t<!-- added for ML-MMOH-CRF-0345 -->\n\t\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:40%; visibility:hidden;\" bgcolor=\"blue\">\n\t\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"auto\" height=\"100%\" align=\"center\">\n\t\t\t\t<tr><td width=\"100%\" id=\"t\"></td></tr>\n\t\t\t</table>\n\t\t</div>\n\t\t\n   \n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t<script>\n\n\t\t\t\tdefaultIVFluid(";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =");\n\t\t\t</script>\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" \n\t\t\t\t <script>\t   \n\t\t\t\t\tsetInfuseOverValue(\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\');\n\t\t\t\t\t\n\t\t\t\t </script>\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t<script>\t\n\t\t\t\t\tcalInfusionRate();\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t<script>\n\n\t\t\t\t\tsetSchedule();\n \t\t\t\t</script>\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t<script>\n\tif(document.oncologyRegimenAdminDetail.frequency.value==\"\"){\n\t\tdocument.oncologyRegimenAdminDetail.btn_schedule_cycle.disabled = true;\n\t}else{\n\t\tdocument.oncologyRegimenAdminDetail.btn_schedule_cycle.disabled = false;\n\t}\n\t</script>\n\t\n";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =" \n\t<script> \n\t\n\t\tcheckScheduledYN(document.oncologyRegimenAdminDetail.frequency.value);\t\t\n\t\tchkDuration(document.oncologyRegimenAdminDetail.durn_value,true); \n\t\tdisplayDispLocation(\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\');\t</script>\n";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\t\t\t<script>\n\t\t\t\tdocument.oncologyRegimenAdminDetail.dosage_label.style.visibility=\"visible\";\n\t\t\t\tdocument.oncologyRegimenAdminDetail.overridereason_mand.value=\"Y\";\t\n\t\t\t\tdocument.oncologyRegimenAdminDetail.mand2.style.visibility=\"visible\";\t</script>\t\t\n\t\t\t\n";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" <script>\n//\t\t\tdocument.oncologyRegimenAdminDetail.all.mand2.style.visibility=\"hidden\";\t\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n    </script>\n\n";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\n\t<script>\n\t\tst = getHrsMinStr(\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\');\n\t\tdocument.getElementById(\"infuse_over_str\").innerHTML = st;\n\t</script>\n\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t<script>\n\n\t\tassignDurnTypeList(\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\');\n\n\t\treloadDurnTypeList(\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\');\n\t</script>\n";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n\t\t<script>ExternalDosageCheck(\'\',\'admndtl\',\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\');</script>\n ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n <script>\n document.oncologyRegimenAdminDetail.durn_value.disabled = true;\n document.oncologyRegimenAdminDetail.durn_unit.disabled = true; \n </script>\n ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\n<script>\nif(document.oncologyRegimenAdminDetail.frequency.value!=\"\" ){ //added for ML-MMOH-CRF-0345  - start\n";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\t\n\tdocument.oncologyRegimenAdminDetail.end_date.value = \'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\';\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\ndocument.oncologyRegimenAdminDetail.frequency.disabled = true;\n";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\';\n\tdocument.oncologyRegimenAdminDetail.end_date.value = \'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n}//added for ML-MMOH-CRF-0345  - end\n\n</script>\n\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n<script>\n\tparent.oncology_fluid.oncologyRegimenFluidDetail.MFR_YN_chk.disabled=true;\n</script>\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n<script>\n\t\tif(parent.oncology_fluid.oncologyRegimenFluidDetail.ongomfrLink){\n\t\t\tparent.oncology_fluid.oncologyRegimenFluidDetail.ongomfrLink.disabled=false;\n\t\t}\n\n\tif(document.oncologyRegimenAdminDetail.adMixture){\n\tif(document.oncologyRegimenAdminDetail.adMixture.checked==true){\n\t\tif(parent.oncology_fluid.oncologyRegimenFluidDetail!=undefined)\n\t\tparent.oncology_fluid.oncologyRegimenFluidDetail.MFR_YN.style.visibility = \"hidden\";\n\t}\n\t}\n\n</script>\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="     \n <Script>\n\tparent.oncology_fluid.oncologyRegimenFluidDetail.MFR_YN_chk.onclick();\n//    document.getElementById(\"Frequency_lbl\").style.visibility\t= \"hidden\";\n//\tdocument.getElementById(\"frequency_selection\").style.visibility\t= \"hidden\";\n\tdocument.oncologyRegimenAdminDetail.durn_value.value = \"\";\n\tdisplayDispLocation(\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\');\n\tif(document.oncologyRegimenAdminDetail.end_date.value==\"\")\n\t\tdocument.oncologyRegimenAdminDetail.end_date.value = \'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" </Script>\n</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
1/6/2020	  	  IN072753          Prabha											   NMC-JD-CRF-0046 
*/
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	    
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String patient_id				= request.getParameter("patient_id")== null ? "":request.getParameter("patient_id");	
	String encounter_id				= request.getParameter("encounter_id")== null ? "":request.getParameter("encounter_id");		
//	String patient_class				= request.getParameter("patient_class")== null ? "":request.getParameter("patient_class");//Commented for Ml-mmoh-crf-0345		
	String start_date				= request.getParameter("start_date")== null ? "":request.getParameter("start_date");
	
	String comp_durn_value		    = request.getParameter("comp_durn_value")== null ? "":request.getParameter("comp_durn_value");	

	String amend_durn_type		    = request.getParameter("comp_durn_type")== null ? "":request.getParameter("comp_durn_type");		
	String disp_durn_type		    = amend_durn_type;	
	String serialNum			    = request.getParameter("serial_no") == null ? "":request.getParameter("serial_no");	
	String amend_serial_no          = request.getParameter("amend_serial_no") == null ? "":request.getParameter("amend_serial_no");
	String infuseovervalue			= request.getParameter("infuseovervalue") == null ? "":request.getParameter("infuseovervalue");
	String infuseoverdurntype		= request.getParameter("infuseoverdurntype") == null ? "":request.getParameter("infuseoverdurntype");
	String fluid_frame_display_yn	= request.getParameter("fluid_frame_display_yn") == null ? "":request.getParameter("fluid_frame_display_yn");
	String drug_unit		= request.getParameter("stock_uom_val") == null ? "":request.getParameter("stock_uom_val"); 
	String mfr_yn_value			= request.getParameter("mfr_yn_value")==null?"N":request.getParameter("mfr_yn_value");//ML-MMOH-CRF-1014
	String bean_id					= "@OncologyRegimenBean"+patient_id+encounter_id;
	String bean_name				= "ePH.OncologyRegimenBean";
	OncologyRegimenBean bean		= (OncologyRegimenBean)getBeanObject( bean_id, bean_name, request ) ;
	String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name				= "eOR.OrderEntryBean";
	OrderEntryBean ORbean			= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name , request) ;
	String locn_type				= (String)ORbean.getLocationType();
	String locn_code				= (String)ORbean.getLocationCode();
	String pract_id					= (String)ORbean.getPractitionerId();
	start_date						= bean.getOrderDate() ;
	
	//start of NMC-JD-CRF-0046
	String ext_disp_appl_yn=""; 
	String  disp_loc=(String)bean.getDispLocnCode(); 
	ext_disp_appl_yn =(String) bean.getExtDispYN(disp_loc);
    //end of NMC-JD-CRF-0046
	
	String site_spec_YN="N";//ADDED FOR ML-MMOH-CRF-1224
	boolean site_spec				= bean.isSiteSpecific("OR", "OR_ORDER_SET");//adDED FOR ml-MMOH-CRF-0345
	if(site_spec){//ADDED FOR ML-MMOH-CRF-1224
		site_spec_YN="Y";
	}
	String amend_frequency			= "";
	String amend_start_date			= "";
	String amend_end_date			= "";
	String amend_sched_medn_yn		= "N";
	String amend_infusion_period_value= "";
	String amend_infusion_period_uom= "";
    String facility_id				=(String)session.getValue("facility_id");
	String repeat_value			    ="";
	String drug_code				="";
	String srl_no					="";
	String order_catalog_code		="";
	String iv_fluid_yn				="";
	String iv_ingredient_yn			="";
	String visibility				="visibility:visible";
	String admixture_visibility		="visibility:visible";
	String drug_infuse_over_uom_text="";	
	String amend_infusion_over_value="";
	String amend_yn		        	="";
	String freq_code                ="";
	String freq_nature			    ="";
	String chk_addmixture           ="";
	String alert_practitioner_yn    ="";	
	String disable_addmixture       ="";
	//String time_flag                ="";
	String addmixture_checked       ="checked"; 
	String addmixture_value         ="Y";
	String order_type_flag		    ="";
	String durn_selected1           ="";
	String durn_selected2           ="";
	String durn_selected3           ="";
	String durn_selected4           ="";
	String durn_selected5			="";
//	String durn_selected6			="";
	String iv_prep_yn               ="0";
	String limit_ind			    ="";
	String allergy_yn			    ="";
	String current_rx			    ="";
	String amend_dup_drug           =""; 
	String order_id					="";
	String scheduled_yn				="";
	String perform_external_database_checks_yn = "N";
	String ext_prod_id				="";
	String ocurrance_num			="";

	String buildMAR_yn				= "";
	String MAR_app_yn				= "";
	String buildMAR_checked			= "";
	// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- begin
	String buildMAR_rule			= "";    
	String buildMAR_enable			= "";
	String cycle_freq_yn			= "Y"; //ML-MMOH-CRF-0345 
	String no_of_cycle			= "";//ML-MMOH-CRF-0345 
	// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- end
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
	String buildMAR_enable			= "";
		 SRR20056-CRF-0649.1 */
	Hashtable DurnDescDetails		=   new Hashtable();	
	String	duration_option			= "";
	String	freq_chng_durn_desc		= "";
	String	repeat_durn_type		= "";
	//ML-MMOH-CRF-1014 - start
	String  def_freq_code			= "";
	String  def_durn_type			= "";
	String  def_durn_value			= "";
	//ML-MMOH-CRF-1014 - end
	MAR_app_yn = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	buildMAR_yn = bean.getBuildMAR_yn();
	/* RUT-CRF-0062 [IN029600] Commented to assign value to Build MAR with Build MAR Rule  -- begin	 
	if(buildMAR_yn == null || buildMAR_yn.equals("")){
		bean.setBuildMAR_yn(MAR_app_yn);
		buildMAR_yn = MAR_app_yn;
	}
	//if(MAR_app_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
		if(patient_class.equals("IP"))
			buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 */
	/* 
			if(buildMAR_yn.equals("Y"))
			buildMAR_checked ="Checked";
		else
			buildMAR_checked ="";
	// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule  --  end  */
	//}

	DurnDescDetails	= (Hashtable)bean.loadDurnDesc();	
	Enumeration keys_des		= DurnDescDetails.keys();
	String	durn_code			= "";
	while(keys_des.hasMoreElements())	{
		durn_code		= (String)keys_des.nextElement();		
		duration_option	= duration_option + "<option value='"+durn_code+"'>"+((String)DurnDescDetails.get(durn_code))+"</option>";		
	}

	if(!serialNum.equals("")){
			int srlNo						= 0;
			srlNo							= Integer.parseInt(serialNum);
			ArrayList drugList				= bean.getDrugDetails();
//			String form_code				= "";//Unused variable
			
		if(drugList!=null){
			HashMap drugDetails				= (HashMap)drugList.get(srlNo-1);
			drug_code			            = (String)drugDetails.get("DRUG_CODE");			
			ocurrance_num			        = (String)drugDetails.get("OCURRANCE_NUM")==null?"":(String)drugDetails.get("OCURRANCE_NUM");;			
			ArrayList doseValues		    = (ArrayList)bean.getDoseValues(drug_code,patient_id);
			order_catalog_code				= (String)drugDetails.get("ORDER_CATALOG_CODE"); 
			iv_fluid_yn						= (String)drugDetails.get("IV_FLUID_YN");
			iv_ingredient_yn				= (String)drugDetails.get("IV_INGREDIENT_YN");
			limit_ind						= (String)drugDetails.get("LIMIT_IND");
		    allergy_yn						= (String)drugDetails.get("ALLERGY_YN");
		    current_rx						= (String)drugDetails.get("CURRENT_RX");
			scheduled_yn					= (String) drugDetails.get("SCHEDULED_YN");
			repeat_value					= (String) drugDetails.get("REPEAT_VALUE")==null?"1":(String) drugDetails.get("REPEAT_VALUE"); //ML-MMOH-CRF-0345 
		/*	RUT-CRF-0062 [IN029600] Commented to get Build MAR Rule -- begin
		
			if(drugDetails.get("buildMAR_yn")==null){
				drugDetails.put("buildMAR_yn",MAR_app_yn);
			}
			buildMAR_yn = (String) drugDetails.get("buildMAR_yn");
			
			if(MAR_app_yn.equals("Y")){
		// Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
				if(patient_class.equals("IP"))
					buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 
				if(buildMAR_yn.equals("Y"))
					buildMAR_checked ="Checked";
				else
					buildMAR_checked ="";
			}
		*/
				buildMAR_yn = (String) drugDetails.get("buildMAR_yn");
				buildMAR_rule=(String) drugDetails.get("BUILD_MAR_RULE")==null?"":(String) drugDetails.get("BUILD_MAR_RULE");
				
				if(buildMAR_yn==null || buildMAR_yn.equals(""))	{
					if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("CD")){
						buildMAR_checked="checked";
						buildMAR_yn="Y";
					}
					else if(buildMAR_rule.equals("UE") || buildMAR_rule.equals("UD")){
						buildMAR_checked="";
						buildMAR_yn="N";
					}
				}
				else
				{
					if(buildMAR_yn.equals("Y"))
						buildMAR_checked ="checked";		
					else
						buildMAR_checked ="";		
				}
				if(buildMAR_rule.equals("CE") || buildMAR_rule.equals("UE")){
						buildMAR_enable="";
				}
				else if(buildMAR_rule.equals("CD") || buildMAR_rule.equals("UD")){
						buildMAR_enable="disabled";
				}
						if(ext_disp_appl_yn.equals("Y")) //Added for NMC-JD-CRF-0046
						{
							buildMAR_checked ="";	
							buildMAR_enable="disabled";
							buildMAR_yn="N";
						}
						
						bean.setBuildMAR_yn(buildMAR_yn);
				
			  // RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- end  

			freq_chng_durn_desc = (String)drugDetails.get("REPEAT_DURN_TYPE");
			repeat_durn_type    = (String)drugDetails.get("REPEAT_DURN_TYPE");
//ML-MMOH-CRF-1014 - start
			def_freq_code					= (String)drugDetails.get("def_freq_code")==null?"":(String) drugDetails.get("def_freq_code");
			def_durn_type					= (String)drugDetails.get("def_durn_type")==null?"":(String) drugDetails.get("def_durn_type");
			def_durn_value					= (String)drugDetails.get("def_durn_value")==null?"":(String) drugDetails.get("def_durn_value");
//ML-MMOH-CRF-1014 - end
			if ( drugDetails.containsKey("amend_durn_value" )){
				
				amend_frequency				= (String)drugDetails.get("amend_frequency")== null ? "":(String)drugDetails.get("amend_frequency");
				amend_sched_medn_yn			= (String)drugDetails.get("amend_sched_medn_yn")== null ? "":(String)drugDetails.get("amend_sched_medn_yn");
				comp_durn_value				= (String)drugDetails.get("amend_durn_value")== null ? "":(String)drugDetails.get("amend_durn_value");


				amend_durn_type				= (String)drugDetails.get("amend_durn_unit")== null ? "":(String)drugDetails.get("amend_durn_unit");
				disp_durn_type = amend_durn_type.equals("")?disp_durn_type:amend_durn_type;
				amend_end_date				= (String)drugDetails.get("amend_end_date")== null ? "":(String)drugDetails.get("amend_end_date");
				
				amend_start_date			= (String)drugDetails.get("amend_start_date")== null ? "":com.ehis.util.DateUtils.convertDate((String)drugDetails.get("amend_start_date"),"DMYHM","en",locale); //Date conversion done for amend_start_date regarding incident num:24401 on 13/Oct/2010==By Sandhya

				if(amend_sched_medn_yn==null || amend_sched_medn_yn.equals(""))
					amend_sched_medn_yn 	= "N";
				else
					amend_sched_medn_yn 	= "Y" ;           

			if(amend_start_date==null || amend_start_date.equals("null") || amend_start_date.equals(""))
				start_date = start_date;
			else
				start_date = amend_start_date;
			
			}

            if( (iv_fluid_yn.equals("N"))&&(iv_ingredient_yn.equals("N"))){
				 visibility					="visibility:hidden";
				 admixture_visibility		="visibility:hidden";
				 fluid_frame_display_yn		="N";
				 iv_prep_yn ="9"; //added for IN26040 reopen --31/01/2011-- priya
            
		     }
			 else if( (iv_fluid_yn.equals("Y"))&&(iv_ingredient_yn.equals("Y"))||((iv_fluid_yn.equals("Y"))&&(iv_ingredient_yn.equals("N")))){             
				 admixture_visibility		="visibility:hidden";
				 amend_infusion_over_value	=(String)drugDetails.get("DRUG_INFUSE_OVER_VALUE");
				 amend_infusion_period_uom	=(String)drugDetails.get("DRUG_INFUSE_OVER_DURN_TYPE");		
				 drug_unit					= (String)doseValues.get(6);
				  iv_prep_yn ="9"; //added for IN26040 reopen(2) --01/02/2011-- priya
		    }

			perform_external_database_checks_yn = (String)drugDetails.get("PERFORM_EXTERNAL_DATABASE_CHECKS");
			ext_prod_id							= (String)drugDetails.get("EXTERNAL_PRODUCT_ID");
			 
	/*==============================Amend=======================================*/
			
		     HashMap Existingrecord;
		     order_type_flag		= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
	/*=========================================================================*/             
	/***************************************************************************
	  New Enhancement for malasiya :Code for validating IVADMIXTURE APPLICAPABLE 
	  and FROM_TIME and TO_TIME in PHPARAMETER FOR FACILITY UNDER IVADMIXTURE TAB
	  starts   
	***************************************************************************/
			HashMap record1;
			record1=new HashMap(); 
				record1=bean.ChkAdMixture();
				chk_addmixture=(String)record1.get("CDR_ADMIXTURE_APPL_YN");
				if(chk_addmixture.equals("N")){
					disable_addmixture	="Disabled";
				}else{
					disable_addmixture	="";
				}
			if(!order_type_flag.equals("Existing")){   
			
				alert_practitioner_yn=(String)record1.get("ALERT_PRACTITIONER_YN");
				if(chk_addmixture.equals("N")){
				   addmixture_checked	="";
				   addmixture_value		="N";
				   iv_prep_yn = "9"; //added while fixing IN26040 reopen(2) --01/02/2011-- priya
				}
				else{
				   addmixture_checked	="checked";
				   addmixture_value		="Y";
				 //  time_flag			=(String)record1.get("time_flag");
				}
			}
	/****************Endshere**************************************************/
			
			amend_yn	    = (String)drugDetails.get("AMEND_YN");
			if(amend_yn.equals("Y")){
				 amend_infusion_period_value=(String)drugDetails.get("amend_infusion_rate");      amend_infusion_over_value=(String)drugDetails.get("amend_infusion_period_value");	  amend_infusion_period_uom=(String)drugDetails.get("amend_infusion_period_uom");
				 freq_code=(String)drugDetails.get("amend_frequency");
			}
			else{
				freq_code=(String)drugDetails.get("COMP_FREQ_CODE"); 
				if(freq_code==null || freq_code.equals(""))
					freq_code=(String)drugDetails.get("FREQ_CODE"); 
				comp_durn_value = (String)drugDetails.get("COMP_DURN_VALUE")==null?comp_durn_value:(String)drugDetails.get("COMP_DURN_VALUE");
				amend_infusion_period_uom=(String)drugDetails.get("DRUG_INFUSE_OVER_DURN_TYPE");	//added for ml-mmoh-crf-1223
			}
			scheduled_yn = bean.getScheduledFreqYN(freq_code)+"";
			if(scheduled_yn.equals("true")) 
				scheduled_yn = "Y";
			freq_nature = bean.getFrequencyNature();
          /*------------------------------Amend--------------------------------------*/
			if(order_type_flag.equals("Existing")){
				ArrayList getExistingCYTORecords = bean.getExistingCYTORecords();	
				if(!amend_serial_no.equals("")){
					//srlNo					      = Integer.parseInt(serialNum);
					srlNo					      = Integer.parseInt(amend_serial_no);
					if(fluid_frame_display_yn.equals("Y")){
					    srlNo					      = Integer.parseInt(amend_serial_no)+1;
					}
					Existingrecord	          = (HashMap) getExistingCYTORecords.get(srlNo);
					if(amend_yn.equals("N")){

						amend_infusion_period_value = (String)Existingrecord.get("INFUSION_RATE")==null?"":(String)Existingrecord.get("INFUSION_RATE");
						amend_infusion_over_value	  = (String)Existingrecord.get("INFUSE_OVER")==null?"":(String)Existingrecord.get("INFUSE_OVER");
						amend_infusion_period_uom   = (String)Existingrecord.get("INFUSION_PER_UNIT")==null?"":(String)Existingrecord.get("INFUSION_PER_UNIT");
						comp_durn_value             = (String)Existingrecord.get("DURN_VALUE")==null?"":(String)Existingrecord.get("DURN_VALUE");
						amend_end_date				= (String)Existingrecord.get("END_DATE_TIME");
						amend_start_date            = (String)Existingrecord.get("START_DATE_TIME");
						amend_durn_type             = (String)Existingrecord.get("DURN_TYPE");
						buildMAR_yn		= (String)Existingrecord.get("buildMAR_yn")==null?"":(String) Existingrecord.get("buildMAR_yn"); // RUT-CRF-0062 [IN029600]
						disp_durn_type =amend_durn_type;
						repeat_durn_type = disp_durn_type;//added for ML-MOH-CRF-0345
					}
					/*amend_end_date				= (String)Existingrecord.get("END_DATE_TIME");
					amend_start_date            = (String)Existingrecord.get("START_DATE_TIME");
					amend_durn_type             = (String)Existingrecord.get("DURN_TYPE");
					disp_durn_type				=  amend_durn_type;*/

					if(amend_yn.equals("N")){
						amend_frequency             = (String)Existingrecord.get("FREQ_CODE");			 
						scheduled_yn = bean.getScheduledFreqYN(amend_frequency)+"";
						if(scheduled_yn.equals("true"))
							scheduled_yn = "Y";
						freq_nature  = bean.getFrequencyNature();
						freq_code  = amend_frequency;			  
					}

					iv_prep_yn 				  = (String)Existingrecord.get("IV_PREP_YN");
					drug_unit                   = (String)Existingrecord.get("INFUSION_VOL_STR_UNIT"); 
					order_id                    =  (String)Existingrecord.get("ORDER_ID"); 
					amend_dup_drug			  = java.net.URLDecoder.decode( (String)Existingrecord.get("DUPLICATE_DRUG_OVERRIDE_REASON"));	
					if(!amend_dup_drug.equals("")){
						//current_rx="Y";
					}
					else{
						//current_rx="N";
					}
					start_date=amend_start_date;

					if(MAR_app_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
						buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 
						if(buildMAR_yn.equals("Y"))
							buildMAR_checked ="Checked";
						else
							buildMAR_checked ="";
							*/
			 				
			 // RUT-CRF-0062 [IN029600]   Added to get Build MAR Rule -- begin
			 
							if(buildMAR_yn.equals("Y"))
								buildMAR_checked ="Checked";
							else
								buildMAR_checked ="";
			 
							buildMAR_rule=Existingrecord.get("BUILD_MAR_RULE").toString();  // Based on Build MAR Rule Enable / Disable Property assigned.
				
							if(buildMAR_rule.equals("CE")){
								buildMAR_enable="";
							}
							else if(buildMAR_rule.equals("UE")){
								buildMAR_enable="";
							}
							else if(buildMAR_rule.equals("CD")){
								buildMAR_enable="disabled";
							}
							else if(buildMAR_rule.equals("UD")){
								buildMAR_enable="disabled";
								//buildMAR_checked ="";
							}
							
							if(ext_disp_appl_yn.equals("Y"))   //ADDED FOR NMC-JD-CRF-0046--AMEND ORDER
							{
								buildMAR_enable="disabled";
								buildMAR_checked="";
								buildMAR_yn ="N";
							}
							
							bean.setBuildMAR_yn(buildMAR_yn);
							
			  // RUT-CRF-0062 [IN029600] Added to get Build MAR Rule -- end  
							
					}
				
				}
			} 

			if(drugDetails.containsKey("IV_PREP_YN")){
				 iv_prep_yn		=(String)drugDetails.get("IV_PREP_YN");
			}
            if( iv_prep_yn.equals("0")&&chk_addmixture.equals("Y")){
				addmixture_checked="checked";
				addmixture_value  ="Y";

			 }
			 else if( iv_prep_yn.equals("9")){
				addmixture_checked	="";
				addmixture_value	="N";
		     }
		  /*-------------------------------------------------------------------------*/
			if(amend_infusion_period_uom.equals("D")){
				drug_infuse_over_uom_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			}
			else if(amend_infusion_period_uom.equals("M")){
				drug_infuse_over_uom_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minutes.label","common_labels");
			}
			else if(amend_infusion_period_uom.equals("H")){
				drug_infuse_over_uom_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels");
			}
			else{
				drug_infuse_over_uom_text=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minutes.label","common_labels");     
			}
			if(amend_durn_type.equals("D")){
				durn_selected3	="selected" ;
			}
			else if(amend_durn_type.equals("M")){
				durn_selected1	="selected" ;
			}
			else if(amend_durn_type.equals("H")){
				durn_selected2	="selected" ;                 
			}
			else if(amend_durn_type.equals("L")){
				durn_selected4	="selected" ;                 
			}else if(amend_durn_type.equals("W")){
				durn_selected5	="selected" ;                 
			} 
			//else if(amend_durn_type.equals("Y")){
				//durn_selected6	="selected" ;                 
			//} 
		}
	}	

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

					if(!visibility.equals("visibility:hidden")){
						

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(visibility));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(amend_infusion_period_value));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_unit));
            _bw.write(_wl_block14Bytes, _wl_block14);
			
									if(amend_infusion_period_uom!=null && amend_infusion_period_uom.equals("M")){

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

									}
									else if(amend_infusion_period_uom!=null && amend_infusion_period_uom.equals("H")){

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

									} 
									else if(amend_infusion_period_uom!=null && amend_infusion_period_uom.equals("D")){

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
			
									}
									else {

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
			
									}

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(admixture_visibility));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(addmixture_checked));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(addmixture_value));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disable_addmixture));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(site_spec));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(fluid_frame_display_yn));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(admixture_visibility));
            _bw.write(_wl_block34Bytes, _wl_block34);
                  

								if(MAR_app_yn.equals("Y")){
									if(!ext_disp_appl_yn.equals("Y") || ext_disp_appl_yn.equals("")){ //Added For NMC-JD-CRF_0046

            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block39Bytes, _wl_block39);

								}
									else{ //Added For NMC-JD-CRF_0046
										
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
	
										}
									}

								else{

            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

								}

            _bw.write(_wl_block44Bytes, _wl_block44);
if(site_spec){ //ML-MMOH-CRF-0345 

							if(order_type_flag.equals("Existing") && mfr_yn_value.equals("Y")){
								comp_durn_value = "";
							}
							
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(serialNum));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(visibility));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(amend_infusion_over_value));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(drug_infuse_over_uom_text));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(amend_infusion_period_uom));
            _bw.write(_wl_block52Bytes, _wl_block52);

					}
					else if(visibility.equals("visibility:hidden")){
						

            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block55Bytes, _wl_block55);
 if(cycle_freq_yn.equals("Y") && site_spec){ //ML-MMOH-CRF-0345 
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(serialNum));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
 
				}
				 if(freq_nature.equals("Y")){ //ML-MMOH-CRF-0345 
				  no_of_cycle = bean.getMaxCycle(freq_code)+"";
				  comp_durn_value  = "1";
				 if(order_type_flag.equals("Existing"))
					 no_of_cycle = "1";
				 }

            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(site_spec));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
 
							if(!serialNum.equals("")){
								ArrayList frequencies = bean.populateFrequencyValues(order_catalog_code);
								for (int i=0; i<frequencies.size(); i+=2) {
									if(freq_code.equalsIgnoreCase((String)frequencies.get(i)) ) {

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( frequencies.get(i) ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( frequencies.get(i+1) ));
            _bw.write(_wl_block66Bytes, _wl_block66);

									}
									else { 

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( frequencies.get(i) ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( frequencies.get(i+1) ));
            _bw.write(_wl_block66Bytes, _wl_block66);
	
									}
								}
							}

            _bw.write(_wl_block67Bytes, _wl_block67);

					if(!freq_nature.equals("Y") && site_spec!=true){//ML-MMOH-CRF-0345 
					
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
}else{
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(serialNum));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(no_of_cycle));
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(comp_durn_value));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(duration_option));
            _bw.write(_wl_block76Bytes, _wl_block76);

				if(!order_type_flag.equals("Existing")){	
		
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(serialNum));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

				}
				else{
		
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(amend_serial_no));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);

				}

		


		
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(site_spec));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(amend_end_date));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(ocurrance_num));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf( iv_prep_yn ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( perform_external_database_checks_yn));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf( locn_type ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf( locn_code ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( pract_id ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(freq_nature));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(serialNum));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(freq_chng_durn_desc));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(amend_durn_type));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(comp_durn_value));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(disp_durn_type));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(no_of_cycle));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(order_type_flag));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(def_freq_code));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(def_durn_type));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(def_durn_value));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(amend_yn));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(site_spec_YN));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(amend_infusion_over_value));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(mfr_yn_value));
            _bw.write(_wl_block113Bytes, _wl_block113);

	if(fluid_frame_display_yn.equals("Y")){
		if(amend_yn.equals("N")  ){

            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(order_type_flag.equals("Existing")));
            _bw.write(_wl_block115Bytes, _wl_block115);

		}
	}

	if(!order_type_flag.equals("Existing")){  	
		if(!amend_yn.equals("Y")){
			if(fluid_frame_display_yn.equals("Y")){

            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(infuseovervalue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(infuseoverdurntype));
            _bw.write(_wl_block117Bytes, _wl_block117);

			}
			if( ((iv_fluid_yn.equals("Y"))&&(iv_ingredient_yn.equals("Y")))||((iv_fluid_yn.equals("Y"))&&(iv_ingredient_yn.equals("N")))){
            _bw.write(_wl_block118Bytes, _wl_block118);

			}
			if(!serialNum.equals("")){

            _bw.write(_wl_block119Bytes, _wl_block119);
	
			}
		}
	}
	if(site_spec){//added for ICN66351

            _bw.write(_wl_block120Bytes, _wl_block120);
	}
if(!mfr_yn_value.equals("Y")){

            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block122Bytes, _wl_block122);
  }
		//if(perform_external_database_checks_yn.equals("N")){

			if( (allergy_yn.equals("Y") || current_rx.equals("Y") ) || (perform_external_database_checks_yn.equals("N") && limit_ind.equals("N"))){

            _bw.write(_wl_block123Bytes, _wl_block123);
	
			}
		//}
//		if(order_type_flag.equals("Existing")){

            _bw.write(_wl_block124Bytes, _wl_block124);

//		}

            _bw.write(_wl_block125Bytes, _wl_block125);
 

	if((order_type_flag.equals("Existing"))&&(amend_yn.equals("N"))){
		ArrayList schedule		= new ArrayList();
			//new ArrayList();
			//(ArrayList)bean.getScheduleFrequencyStr(drug_code+ocurrance_num,"0");	
		String sch_bean_id		= "OrScheduleFreq" ;
		String sch_bean_name	= "eOR.ScheduleFrequencyCompBean";
		Hashtable sch_output	=	null;
		Hashtable schedule_val	=	null;
		if(schedule.size()==0 && scheduled_yn.equals("Y") ) { 
			schedule_val	=	new Hashtable();
			ScheduleFrequencyCompBean schedule_bean =(ScheduleFrequencyCompBean)getBeanObject( sch_bean_id,sch_bean_name,request );
			schedule_bean.setLanguageId(locale);
			schedule_val.put("facility_id", (String)session.getValue("facility_id"));
			schedule_val.put("start_time_day_param", amend_start_date);
			schedule_val.put("module_id", "PH"); 
			schedule_val.put("split_dose_yn","N"); 
			schedule_val.put("split_qty","100");//qty_value
			schedule_val.put("freq_code",  amend_frequency );
			schedule_val.put("code",drug_code+ocurrance_num);
			sch_output	=	schedule_bean.setScheduleFrequencyDefault(schedule_val);
			sch_output.put("code",drug_code+ocurrance_num);
			sch_output.put("row_value",srl_no);
			sch_output.put("start_date_time",amend_start_date);

//			bean.setScheduleFrequencyStr(sch_output);
			putObjectInBean(sch_bean_id,schedule_bean,request);
		} 
		if(sch_output!=null && freq_nature.equals("F")){
		    repeat_value=bean.getrepeat_value(amend_frequency);
			sch_output.put("code",drug_code+ocurrance_num);
			sch_output.put("row_value",srl_no);
			sch_output.put("start_time_assign","");
			sch_output.put("repeat",repeat_value);

			ArrayList values	=	bean.getFreqDet(order_id,"1");

				ArrayList freqCharctValues = new ArrayList();
				ArrayList day_list = new ArrayList();
				ArrayList day_names = new ArrayList();
				ArrayList time_list = new ArrayList();
				ArrayList dose_list = new ArrayList();
				ArrayList<String> week_days	= new ArrayList<String>();
				week_days = bean.getDayOfWeek(amend_start_date); 
						  freqCharctValues = (ArrayList)sch_output.get(drug_code+ocurrance_num);	

					//	  day_list  = (ArrayList)freqCharctValues.get(1);
					//	  day_names = (ArrayList)freqCharctValues.get(2);
					//	  time_list = (ArrayList)freqCharctValues.get(3);
					//	  dose_list = (ArrayList)freqCharctValues.get(4);
							
				ArrayList tmp_freq_values = new ArrayList();
				
				for(int p=0; p<values.size(); p+=4) {
					time_list.add(values.get(p));
					dose_list.add(values.get(p+1));
//					time_list.add(values.get(p+2));
					day_list.add(values.get(p+3));
				}

				
				if(day_list.size()>0){
					for(int j=0;j<day_list.size();j++){
					if(!day_list.get(j).equals(""))
					{
						String temp = (String)day_list.get(j);
						if (temp == null || temp.equals(""))
						{
							temp = "0";
						}
						if (!temp.equals("0"))
						{
							day_names.add(week_days.get((Integer.parseInt(temp))-1));
						}
						
					}
					}
				}
				if(freqCharctValues != null && freqCharctValues.size()>0){
					tmp_freq_values.add(freqCharctValues.get(0));
					tmp_freq_values.add(day_list);
					tmp_freq_values.add(day_names);
					tmp_freq_values.add(time_list);
					tmp_freq_values.add(dose_list);
				}
sch_output.put(drug_code+ocurrance_num,tmp_freq_values);


		/*	int incr=0;
			for(int p=0; p<values.size(); p+=4) {
				incr++;

				sch_output.put("time"+(incr),values.get(p));
				sch_output.put("qty"+(incr),values.get(p+1));				
//				sch_output.put("admin_day"+(incr),values.get(p+3));
			}
			if(incr<=6) {
				for(int q=(incr+1); q<=6; q++) {
					sch_output.put("time"+(q),"");
					sch_output.put("qty"+(q),"");
//					sch_output.put("admin_day"+(q),"");
				}
			}*/
			bean.setScheduleFrequencyStr(sch_output);
			schedule		= bean.getScheduleFrequencyStr(drug_code+ocurrance_num,"0");
		}

	}

	if(amend_infusion_period_uom != null && amend_infusion_over_value != null && amend_infusion_period_uom != "" && amend_infusion_over_value != ""){

            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(amend_infusion_over_value));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(amend_infusion_period_uom));
            _bw.write(_wl_block127Bytes, _wl_block127);
}
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(DurnDescDetails));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(disp_durn_type));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(repeat_durn_type));
            _bw.write(_wl_block130Bytes, _wl_block130);

////added for IN26467 --11/02/2011-- priya
		if(!ext_prod_id.equals("") && perform_external_database_checks_yn.equals("Y"))
				{
 
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(perform_external_database_checks_yn));
            _bw.write(_wl_block132Bytes, _wl_block132);

				}

 if(freq_nature.equals("Y")){ 
            _bw.write(_wl_block133Bytes, _wl_block133);
}
 
            _bw.write(_wl_block134Bytes, _wl_block134);

if(amend_yn.equals("N") && freq_nature.equals("Y")){
if(!order_type_flag.equals("Existing")){
bean.loadCycleFreqDetails(freq_code,facility_id,repeat_durn_type,repeat_value,start_date,drug_code,serialNum);
String endDate = bean.getOrderEndDate();//Added for ML-MMOH-CRF-0345

            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(endDate));
            _bw.write(_wl_block136Bytes, _wl_block136);
}else{
	bean.loadAmendCycleFreqDetails(freq_code,facility_id,repeat_durn_type,repeat_value,start_date,drug_code,serialNum,order_id);

            _bw.write(_wl_block137Bytes, _wl_block137);

	String start_date_amend = bean.getAmendOrderStartDate().split("~")[0];
	String end_date_amend   = bean.getAmendOrderStartDate().split("~")[1];

            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(start_date_amend));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(end_date_amend));
            _bw.write(_wl_block136Bytes, _wl_block136);
}
}


            _bw.write(_wl_block139Bytes, _wl_block139);
	
//System.err.println("OncologyRegimenAdminDetail.jsp==fluid_frame_display_yn==921==>"+fluid_frame_display_yn+"==-===site_spec==>"+site_spec);
	if(site_spec ){
	if(order_type_flag.equals("Existing")){//CRF-1014
		if(mfr_yn_value.equals("Y")){

            _bw.write(_wl_block140Bytes, _wl_block140);
		}

	}

            _bw.write(_wl_block141Bytes, _wl_block141);
if(mfr_yn_value.equals("Y")){ // ML-MMOH-CRF-1014 

            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(amend_end_date));
            _bw.write(_wl_block136Bytes, _wl_block136);

} 
}

            _bw.write(_wl_block144Bytes, _wl_block144);

	putObjectInBean(bean_id,bean,request);
	putObjectInBean(or_bean_id,ORbean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionRate.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.day.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.day.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.day.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.day.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Admixture.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfuseOver.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OverrideReason.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
}
