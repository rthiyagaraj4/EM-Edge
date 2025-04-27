package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import java.sql.*;
import java.text.*;

public final class __ipparameter extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPParameter.jsp", 1741069528589L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t \n\t\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eIP/js/IPParam.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\tfunction setVal(obj)\n\t\t{\n\t\t\tif(obj.checked == true)\n\t\t\t\tobj.value = \"Y\";\n\t\t\telse\n\t\t\t\tobj.value = \"N\";\n\t\t}\n\n\t\t/* New function added for CRF \"MZ-CRF-0017-IP\"  by sathish on Wednesday, March 03, 2010*/\n\t\tfunction expandCollapse(calledFrom) {\t\t\n\n\t\t\tif(calledFrom == \'adt\'){\n\t\t\t\t\t\tdocument.getElementById(\"ADT\").style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\"ADDITIONAL\").style.display = \'none\';\t\t\t\t\t\t\n\t\t\t}else if(calledFrom == \'additional\') {\n\t\t\t\t\t\tdocument.getElementById(\"ADT\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"ADDITIONAL\").style.display = \'inline\';\n\t\t\t}\n\t\t}\n\nasync function ConsentText(){\n\tvar obj = new Object(); \n\tobj.data = document.getElementById(\"consent_text_details\").value;\n\tvar arg=\"dialogHeight:30;edge:sunken;resizable:no;status:no;scroll:no\";\t\n\tvar url=\"../../eIP/jsp/IPConsentFormatText.jsp\";\n\tawait window.showModalDialog(url,obj,arg); \n\tdocument.getElementById(\"consent_text_details\").value=obj.returnvalue;\n}\n\n\n\t\t</script>\n\t</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script>\n\nfunction checkForMax(obj)\n{\n\tif(parseInt(obj.value) > 24)\n\t{\n\t\tvar DCerror = getMessage(\'DATE1_GT_DATE2\',\'IP\');\n\t\tDCerror = DCerror.replace(\'$\',getLabel(\"Common.MaxDischargePeriodforDayCare.label\",\"Common\"));\n\t\tDCerror = DCerror.replace(\'#\',\"24\");\n\t\talert(DCerror);\n\t\tobj.select();\n\t\tobj.focus();\n\t}\n}\n\n\nfunction change() \n{\n\tif (document.ipparam_form.priority_appl_yn.checked == true)\n\t{\t\n\t\tif(document.ipparam_form.priority.options.length > 1)\n\t\t{\t\n\t\t\tdocument.ipparam_form.star.style.visibility = \'visible\';\n\t\t}\n\t\tdocument.ipparam_form.priority.value = \"\";\n\t\tdocument.ipparam_form.priority.disabled = false;\n\t}\n\telse\n\t{\n\t\tdocument.ipparam_form.priority.value = \"\";\n\t\tdocument.ipparam_form.priority.disabled = true;\n\t\tdocument.ipparam_form.star.style.visibility = \'hidden\';\n\t}\n}\n\nfunction disfuturebooking(obj)\n{\n\t\t\t\n\tif(obj.name == \'future_booking_for_boc_yn\' ){\n\t\tif(document.forms[0].future_booking_for_boc_yn.checked == false){\n\t\t\tdocument.forms[0].no_of_days_before_for_boc.value = \'\';\n\t\t\tdocument.forms[0].no_of_days_before_for_boc.disabled = true\n\t\t\tdocument.forms[0].consider_edd_stop_for_boc_yn.value = \'\';\n\t\t\tdocument.forms[0].consider_edd_stop_for_boc_yn.checked = false;\n\t\t\tdocument.forms[0].consider_edd_stop_for_boc_yn.disabled = true\n\t\t\tdocument.forms[0].action_for_boc.value = \'W\';\n\t\t\tdocument.forms[0].action_for_boc.disabled = true\n\t\t\t\n\t\t}else{\n\t\t\tdocument.forms[0].no_of_days_before_for_boc.disabled = false\n\t\t\tdocument.forms[0].no_of_days_before_for_boc.value = \'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t\tdocument.forms[0].consider_edd_stop_for_boc_yn.disabled = false;\n\t\t\tif(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'== \'checked\')\n\t\t\tdocument.forms[0].consider_edd_stop_for_boc_yn.checked = true;\n\t\t\tdocument.forms[0].action_for_boc.disabled = false;\n\t\t\tdocument.forms[0].action_for_boc.value = \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\';\n\t\t\t\n\t\t}\n\t}else if(obj.name == \'future_booking_for_bou_yn\' ){\n\t\tif(document.forms[0].future_booking_for_bou_yn.checked == false){\n\t\t\tdocument.forms[0].no_of_days_before_for_bou.value = \'\';\n\t\t\tdocument.forms[0].no_of_days_before_for_bou.disabled = true\n\t\t\tdocument.forms[0].consider_edd_stop_for_bou_yn.value = \'\';\n\t\t\tdocument.forms[0].consider_edd_stop_for_bou_yn.checked = false;\n\t\t\tdocument.forms[0].consider_edd_stop_for_bou_yn.disabled = true\n\t\t\tdocument.forms[0].action_for_bou.value = \'W\';\n\t\t\tdocument.forms[0].action_for_bou.disabled = true\n\t\t\t\n\t\t}else{\n\t\t\tdocument.forms[0].no_of_days_before_for_bou.disabled = false\n\t\t\tdocument.forms[0].no_of_days_before_for_bou.value = \'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\';\n\t\t\tdocument.forms[0].consider_edd_stop_for_bou_yn.disabled = false;\n\t\t\tif(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'== \'checked\')\n\t\t\tdocument.forms[0].consider_edd_stop_for_bou_yn.checked = true;\n\t\t\tdocument.forms[0].action_for_bou.disabled = false;\n\t\t\tdocument.forms[0].action_for_bou.value = \'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t\n\t\t}\n\t}else if(obj.name == \'future_booking_for_bnc_yn\' ){\n\t\tif(document.forms[0].future_booking_for_bnc_yn.checked == false){\n\t\t\tdocument.forms[0].no_of_days_before_for_bnc.value = \'\';\n\t\t\tdocument.forms[0].no_of_days_before_for_bnc.disabled = true\n\t\t\tdocument.forms[0].consider_edd_stop_for_bnc_yn.value = \'\';\n\t\t\tdocument.forms[0].consider_edd_stop_for_bnc_yn.checked = false;\n\t\t\tdocument.forms[0].consider_edd_stop_for_bnc_yn.disabled = true\n\t\t\tdocument.forms[0].action_for_bnc.value = \'W\';\n\t\t\tdocument.forms[0].action_for_bnc.disabled = true\n\t\t\t\n\t\t}else{\n\t\t\tdocument.forms[0].no_of_days_before_for_bnc.disabled = false\n\t\t\tdocument.forms[0].no_of_days_before_for_bnc.value = \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\tdocument.forms[0].consider_edd_stop_for_bnc_yn.disabled = false;\n\t\t\tif(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'== \'checked\')\n\t\t\tdocument.forms[0].consider_edd_stop_for_bnc_yn.checked = true;\n\t\t\tdocument.forms[0].action_for_bnc.disabled = false;\n\t\t\tdocument.forms[0].action_for_bnc.value = \'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\t\t\t\n\t\t}\n\t}else if(obj.name == \'future_booking_for_bnu_yn\' ){\n\t\tif(document.forms[0].future_booking_for_bnu_yn.checked == false){\n\t\t\tdocument.forms[0].no_of_days_before_for_bnu.value = \'\';\n\t\t\tdocument.forms[0].no_of_days_before_for_bnu.disabled = true\n\t\t\tdocument.forms[0].consider_edd_stop_for_bnu_yn.value = \'\';\n\t\t\tdocument.forms[0].consider_edd_stop_for_bnu_yn.checked = false;\n\t\t\tdocument.forms[0].consider_edd_stop_for_bnu_yn.disabled = true\n\t\t\tdocument.forms[0].action_for_bnu.value = \'W\';\n\t\t\tdocument.forms[0].action_for_bnu.disabled = true\n\t\t\t\n\t\t}else{\n\t\t\tdocument.forms[0].no_of_days_before_for_bnu.disabled = false\n\t\t\tdocument.forms[0].no_of_days_before_for_bnu.value = \'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\';\n\t\t\tdocument.forms[0].consider_edd_stop_for_bnu_yn.disabled = false;\n\t\t\tif(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'== \'checked\')\n\t\t\tdocument.forms[0].consider_edd_stop_for_bnu_yn.checked = true;\n\t\t\tdocument.forms[0].action_for_bnu.disabled = false;\n\t\t\tdocument.forms[0].action_for_bnu.value = \'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\';\n\t\t\t\n\t\t}\n\t}\n\n}\n\n</script>\n<body onLoad=\'focusTxt();changepriority();disBAC()\' onSelect=\'codeArrestThruSelect()\' onMouseDown=\"CodeArrest()\" onKeyDown = \"lockKey()\">\n<form name=\'ipparam_form\' id=\'ipparam_form\'  method=\"post\" action=\"../../servlet/eIP.IPParamServlet\"  target=\"messageFrame\">\n\t<input type=\'hidden\' name=\'PCIAY\' id=\'PCIAY\' value=\'\' >\n\t<input type=\'hidden\' name=\'DPBY\' id=\'DPBY\' value=\'\' >\n\t<input type=\'hidden\' name=\'cbcy\' id=\'cbcy\' value=\'\' >\n\t<input type=\'hidden\' name=\'dcay\' id=\'dcay\' value=\'\' > \n\t<input type=\'hidden\' name=\'AGPDA\' id=\'AGPDA\' value=\'\' >  <!-- added by mujafar for MO-CRF-20157 -->\n\t\n<div id = \'ADT\' >\n<!-- <a name = \'outpat_act_tab_vw\'></a> -->\n\t<ul id=\"tablist\" class=\"tablist\" style=\"padding-left:0px\">\n\t\t<li class=\"tablistitem\" title=\"ADT\">\n\t\t\t<a class=\"tabClicked\" id=\"outpat_act_tab\"><span class=\"tabSpanclicked \" id=\"outpat_act_tab_span\" onClick=\'javascript:expandCollapse(\"adt\")\'>ADT</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Additional\">\n\t\t\t<a class=\"tabA\" id=\"inpat_act_tab\"><span class=\"tabAspan\" id=\"inpat_act_tab_span\" onClick=\'javascript:expandCollapse(\"additional\")\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t</ul>\n\t\n<table name=\'tab_table\' id=\'tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\' width=\'100%\' style = \"margin-top:-15px\">  \n<th colspan=\'9\' align=\'left\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</th>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<tr>\n\t\t<td  class=\'label\' align =\'left\' width=\"20%\" >";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t<td class=\'fields\' align =\'left\' width=\"15%\" ><input type=\'checkbox\' size=\'8\' maxlength=\'8\' name=\'unregistered_patients_bkg_yn\' id=\'unregistered_patients_bkg_yn\' value=\'Y\' ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ></td>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\n\t\t<td class=\'label\' align =\'left\' width=\"22%\" nowrap>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t<td  class=\'fields\' colspan = \"6\" align =\'left\' width=\"20%\" ><input type=\'text\' name=\'bkg_grace_period\' id=\'bkg_grace_period\' size=\'3\'  maxlength=\'3\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" onBlur=\"CheckNum(this)\" onKeyPress=\'return(ChkNumberInput(this,event,0))\'>&nbsp;";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;</td>\n\t</tr>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n\t<tr>\n\t\t<td   class=\'label\' align=\'left\' width=\"24%\" >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t<td   class=\'fields\' align=\'left\' >&nbsp;<input type=\'text\' size=\'3\' maxlength=\'3\' name=\'adv_bed_book_period_bkg\' id=\'adv_bed_book_period_bkg\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNum(this);CheckZeroVal(this)\">&nbsp;";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="<img src=\'../../eMP/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td>\n\t\t<td   class=\'fields\' colspan = \"6\" align=\'left\' >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="&nbsp;<select name=\'chk_booking_limit_by\' id=\'chk_booking_limit_by\' ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="><option ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" value=\'1\'>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="<option ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" value=\'2\'>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</select></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'BLANKROW1PT\' colspan=\'6\' >&nbsp;</td>\n\t</tr>\t\n\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t<tr><td height=5 colspan=\"6\" class=label>&nbsp;</td></tr>\n\t<tr>\n\t\t<td class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t<td class=\'fields\' align=\'left\' >&nbsp;<select name=\'allowed_booking_type\' id=\'allowed_booking_type\'><option value=\'D\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</option><option value=\'R\'>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</option></select></td>\n\t\t\n\t\t<td class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t<td class=\'fields\' colspan = \"6\" align=\'left\' >&nbsp;<select name=\'block_bed_based_on\' id=\'block_bed_based_on\'><option value=\'P\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</option><option value=\'E\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</option></select></td>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t</tr>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t<tr>\t\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t<td class=\'fields\'><input type=\'checkbox\' name=\'multi_book_pat_yn\' id=\'multi_book_pat_yn\' value=\'N\' ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="></td>\n\t<!--Added  for PMG2016-CRF-0002 IN061508 on 23rd Aug 16-->\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t<td class=\'fields\' colspan = \"6\"><input type=\'checkbox\' name=\'rel_booked_bed_yn\' id=\'rel_booked_bed_yn\' value=\'N\'  ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" ></td>\n\t\n\t</tr>\n\t<!--Added  for PMG2016-CRF-0002 IN061508 on 23rd Aug 16-->\n\t<!--\tAdded  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas\t-->\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t<td   class=\'fields\' align=\'left\' >&nbsp;<input type=\'text\' size=\'3\' maxlength=\'3\' name=\'NOSHOW_BKNG_PERIOD\' id=\'NOSHOW_BKNG_PERIOD\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n<!--  end  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas\t-->\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\t\t<td class=\'fields\' colspan = \"6\"><input type=\'checkbox\' name=\'capture_fin_dtls_yn\' id=\'capture_fin_dtls_yn\' value=\'N\'  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" ></td>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t<td class=label>&nbsp;</td><td class=label>&nbsp;</td>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\n\t<tr>\n<script>document.forms[0].allowed_booking_type.value = \"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"\n\n</script>\n\t<tr><th colspan=\'9\' align=\'left\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="/";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</th></tr>\n\t<tr>\n\t   <td class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n       <td class=\'fields\' >&nbsp;<input type=\'text\' ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" name=\'adm_date_chk_days\' size=\'3\' maxlength=\'3\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"  onBlur=\"CheckNum(this);CheckZeroVal(this);\" onKeyPress=\'return(ChkNumberInput(this,event,0))\'> \n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t&nbsp;<select name=\"adm_date_chk_days_type\" id=\"adm_date_chk_days_type\" ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =">\n\t\t<option value=\'H\'  ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</option>\n\t\t<option value=\'D\'  ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</option>\n\t\t</select><img src=\'../../eMP/images/mandatory.gif\'align=\'center\'></img></td>\n\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n        <td   class=\'fields\' colspan = \"6\" align =\'left\' >\n\t\t&nbsp;<select name=\'allowed_admission_type\' id=\'allowed_admission_type\'>\n\t\t<option ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" value=\'D\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</option>\n\t\t<option ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" value=\'B\'>";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =" value=\'Z\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" value=\'R\'>";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</option>\n\t\t</select>\t\t\n\t\t</td> \n\t</tr>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n<!-- The New Check Box \"Invoke admission from New Born Registration\" Was Introduced On 5/27/2008 -->\n\t<!--<tr>\n\t\t\t<td   class=\'label\' align=\'right\' >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t<td class=\'fields\' align=\'left\' ><input type=\'checkbox\'  name=\'invk_admsn_frm_nwbrn_regYN\' id=\'invk_admsn_frm_nwbrn_regYN\' value=\'N\'  tabIndex=\'0\'  ></td>\n\t\t\t<td   class=\'fields\' align=\'left\' ></td><td></td>\n\t</tr>-->\n\t\n\n<tr>\n\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\n\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t<td   class=\'fields\' align=\'left\' >&nbsp;<input type=\'text\' size=\'2\' maxlength=\'2\' name=\'MAX_DISCH_PERIOD_FOR_DC\' id=\'MAX_DISCH_PERIOD_FOR_DC\' value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"checkForMax(this);CheckNum(this);CheckZeroVal(this)\">&nbsp;";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="<img src=\'../../eMP/images/mandatory.gif\'align=\'center\'></img></td>\n\n\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t<td   class=\'fields\' colspan = \"6\" align =\'left\'>&nbsp;<input type=\'text\' name=\'dis_date_chk_days\' id=\'dis_date_chk_days\' size=\'2\'  maxlength=\'2\' value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\"  ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" onBlur=\"CheckNum(this);CheckZeroVal(this);\" onKeyPress=\'return(ChkNumberInput(this,event,0))\'>\n\t\t\n&nbsp;<select name=\'diag_update_period_max_unit\' id=\'diag_update_period_max_unit\' ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" >\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n</select><img src=\'../../eMP/images/mandatory.gif\'align=\'center\'></img></td>\n</tr>\n\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="<!--12/9/2008 3752\tPMG20089-CRF-0047-->\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t<tr>\n\t\t<td class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="</td>\n\t\t<td class=\'fields\' align=\'left\' ><input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'invk_admsn_frm_nwbrn_regYN\' id=\'invk_admsn_frm_nwbrn_regYN\' value=\'N\'  ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" tabIndex=\'0\' onClick=\"\"></td>\n\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\n\t\t<td   class=\'fields\' colspan = \"6\" align=\'left\' >&nbsp;<input type=\'text\' size=\'1\' maxlength=\'1\' name=\'grc_prd_for_asgn_bed_mark_arvl\' id=\'grc_prd_for_asgn_bed_mark_arvl\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"  onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"checkForMax(this);CheckNum(this);CheckZeroVal(this)\">&nbsp;";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="<img src=\'../../eMP/images/mandatory.gif\'align=\'center\'></img></td>\n\n\t</tr>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n<tr>\n\t<td class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</td>\n\t<td class=\'fields\' align=\'left\' ><input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'priority_appl_yn\' id=\'priority_appl_yn\' value=\'Y\' ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" tabIndex=\'0\' onClick=\"change()\"></td>\n\n\t\t\n\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td>\n\t\t<td class=\'fields\' colspan = \"6\">&nbsp;<select name=\"priority\" id=\"priority\" ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" >\n\t\t<option value=\"\">------";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="-----</option>\n\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n<script>\n\t\tif(document.forms[0].priority_appl_yn.checked == true)\n\t\t{\n\t\t\tdocument.forms[0].priority.value = \"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\tdocument.forms[0].priority.value = \"\";\n\t\t\tdocument.forms[0].priority.disabled = true;\n\t\t}\n</script>\n\t\t</select><img id=\"star\" src=\'../../eMP/images/mandatory.gif\'align=\'center\'></img></td> \n\t</tr>\t\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\n   ";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t <tr>\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t\t<td   class=\'fields\' align=\'left\'  ><input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'PAT_CHECK_IN_ALLOWED_YN\' id=\'PAT_CHECK_IN_ALLOWED_YN\' value=\'Y\' ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" ></td>\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td>\n ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t<td   class=\'fields\' colspan = \"6\" align=\'left\' ><input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'DEACTIVATE_PSEUDO_BED_YN\' id=\'DEACTIVATE_PSEUDO_BED_YN\' value=\'Y\' ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" ></td>\n\t\t</tr>\n\t\t\n\t\t\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t<tr>\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</td>\n\t\t<td   class=\'fields\' align=\'left\' ><input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'change_bed_class_yn\' id=\'change_bed_class_yn\' value=\'Y\' ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" >\n\t\t</td>\n\n\t\t<td   class=\'label\' align=\'left\'>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" </td>\n\t\t<td   class=\'fields\' colspan = \"6\"  align =\'left\'>&nbsp;<select name=\'vital_signs_battery_id\' id=\'vital_signs_battery_id\' ";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =">\n\t\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t</select>\t\t\n\t\t</td>\n\n\t\t</tr>\n ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t\t<tr>\n\n\t\t\t<td  class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n\t\t<td class=\'fields\' align=\'left\' ><input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'discharge_checklist_app_yn\' id=\'discharge_checklist_app_yn\' value=\'Y\' ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 =" >\n\t\t</td>\n\t\t<td class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>&nbsp;\n\t\t<td class=\'fields\' colspan = \"6\">&nbsp;<input type=\'text\'align=\"left\"  name=\'disc_chklst_exp_period\' id=\'disc_chklst_exp_period\'  size=\'2\' maxlength=\'2\' value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'CheckNum(this);\'>\n\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t&nbsp;<select name=\"disc_chklst_exp_per_unit\" id=\"disc_chklst_exp_per_unit\" ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =">\n\t\t<option value=\'H\' ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</option>\n\t\t<option value=\'D\' ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</option>\n\t</select>\n\t</td>\n\t\t</tr>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t<tr>\n\n\t\t\t<td  class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="</td>\n\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t<td class=\'fields\' align=\'left\' >\n\t\t\t<select name=\"display_discharge_pat_list\" id=\"display_discharge_pat_list\">\n\t\t\t\t<option value=\'A\' ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</option>\n\t\t\t\t<option value=\'D\' ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</option>\n\t\t\t</select>\n\t\t</td>\n\t\t<!-- Below line(s) was added by venkatesh.S (4008) on 30/10/2012 against  Bru-HIMS-CRF-155 [IN030274] -->\n\t\t<td  class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td>\n\t\t<td class=\'fields\' >&nbsp;<input type=\'text\'align=\"left\"  name=\'chk_for_readmission\' id=\'chk_for_readmission\'  size=\'2\' maxlength=\'3\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\"  onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'CheckNum(this)\'>\n         &nbsp;";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t</td> \n\t<!-- end Bru-HIMS-CRF-155 [IN030274]  -->\n\t\t<td height=5 colspan=6 class=label>&nbsp;<!--";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" <input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'chk_for_pen_orders_bfr_dis_adv\' id=\'chk_for_pen_orders_bfr_dis_adv\' value=\'Y\' ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="  tabIndex=\'0\' onclick=\'dischargeAdvice()\'  >--></td>\n\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t<tr><td height=5 class=label>";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="</td><td height=5 class=fields> <input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'chk_for_pen_orders_bfr_dis_adv\' id=\'chk_for_pen_orders_bfr_dis_adv\' value=\'Y\' ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="  tabIndex=\'0\' onclick=\'dischargeAdvice()\'  ></td> <td height=5 colspan=6  class=\"label\" >";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =" <input type=\'radio\' id=\'r_1\' name=\'NO\' id=\'NO\' value=\'NO\'  tabIndex=\'0\' ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 =" onclick=\'clearRadio_1(this)\' ><height=5 colspan=2 class=label>";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="<input type=\'radio\' id=\'r_2\' name=\'YES\' id=\'YES\' value=\'Y\'  tabIndex=\'0\' ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" onclick=\'clearRadio_2(this)\'><height=5 colspan=2 class=label>";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td> \n\t</tr> <input type=\'hidden\' name=\'radioYN\' id=\'radioYN\' value=\'N\' > \n\t\t\t\n\t\t\t<tr><td height=5 colspan=6 class=\"label\">&nbsp;</td></tr> \n\t\n\t<!--Added by Thamizh selvi on 4th Nov 2016 against GHL-CRF-0412.2 Start-->\n\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t<tr>\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</td>\n\t<td class=\'fields\'><input type=\'checkbox\' name=\'chk_pen_ward_rtn_bfr_dis_adv\' id=\'chk_pen_ward_rtn_bfr_dis_adv\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 =" ></td>\n\t</tr>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t<!-- End-->\n\n\t\t\t\n\n\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\t\n\t\n\t\n<tr>\n\t<td height=5  class=label>";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =" </td>\n\t<td height=5  class=fields>\n\t<input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'chk_for_pen_orders_bfr_dis\' id=\'chk_for_pen_orders_bfr_dis\' value=\'Y\' ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =" tabIndex=\'0\' onclick=\'pendingDischarge()\'></td>\n\t<td height=5 colspan=6 class=label>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" <input type=\'radio\' id=\'notallow\' name=\'dis_notallow\' id=\'dis_notallow\' value=\'N\'  tabIndex=\'0\' ";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 =" onclick=\'notAllowDischarge(this)\' ><height=5 colspan=6 class=label>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="<input type=\'radio\' id=\'allowr\' name=\'dis_allow\' id=\'dis_allow\' value=\'Y\'  tabIndex=\'0\' ";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =" onclick=\'allowDischarge(this)\'><height=5 colspan=6 class=label>";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</td>\t\n\t</tr>\t\n\t <input type=\'hidden\' name=\'pending_discharge\' id=\'pending_discharge\' value=\'N\' > \n    <tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n<!--Added by Shanmukh on 22nd-MAY-2018 for ML-MMOH-CRF-1135 -->\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n<tr>\n\t<td height=5  class=label>";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =" </td>\n\t<td height=5  class=fields>\n\t<input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'chk_dis_pat_BT_order_pend\' id=\'chk_dis_pat_BT_order_pend\' value=\'Y\' ";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="checked";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 =" /></td>\t\t\n</tr>\t\n<!-- END -->\n\t \n    <tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\t\n";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\t\n\t\n\t<!--<tr>\n\t<td height=5  class=\'label\'>";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" </td>\n\t<td height=5  class=\'fields\'>\n\t<td class=\'fields\'>\n\t<input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'chk_for_pen_orders_bfr_dis\' id=\'chk_for_pen_orders_bfr_dis\' value=\'Y\' tabIndex=\'0\' onclick=\'pendingDischarge()\'></td>\n\t<td height=5 colspan=6 class=\'fields\'>&nbsp;</td>\t\n\t</tr>\n\t<tr><td height=5 colspan=4 class=label>&nbsp;</td></tr> \n    <tr> <td height=5 colspan=2  class=label >";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 =" <input type=\'radio\' id=\'notallow\' name=\'dis_notallow\' id=\'dis_notallow\' value=\'N\'  tabIndex=\'0\' onclick=\'notAllowDischarge(this)\' ><height=5 colspan=2 class=label>";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="<input type=\'radio\' id=\'allowr\' name=\'dis_allow\' id=\'dis_allow\' value=\'Y\'  tabIndex=\'0\'  onclick=\'allowDischarge(this)\'><height=5 colspan=2 class=label>";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="</td> <td height=5 colspan=2 class=label>&nbsp;</td>\n\t</tr> <input type=\'hidden\' name=\'pending_discharge\' id=\'pending_discharge\' value=\'N\' > \n    <tr><td height=5 colspan=4 class=label>&nbsp;</td></tr>\t-->\n\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\t\t\n\t\n\t\n\n\t<tr>\n\t<script> \n</script>\n\t\t<!--2/3/2009 dropped  ext_interface_for_priviledge_yn from IP_PARAM -->\n\t\t<!--<td   class=\'label\' align=\'right\' width =\'40%\'>";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="</td>\n\t\t<td   class=\'fields\' align=\'left\' width =\'5%\'><input type=\'checkbox\' size=\'1\' maxlength=\'1\' name=\'ext_interface_for_priviledge_yn\' id=\'ext_interface_for_priviledge_yn\' value=\'Y\'  ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =" tabIndex =\'0\'>\n\t\t</td>-->\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="</td>\n\t<td class=\'fields\'><input type=\'checkbox\' name=\'reserve_bed_on_tfr_yn\' id=\'reserve_bed_on_tfr_yn\' value=\'N\' ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 =" onclick = \'checkMultiple();EnableResBedIntraward();\'></td>\n\t\n    <td class=\'label\'>";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="</td>\n\t<td class=\'fields\' colspan = \"6\"><input type=\'checkbox\' name=\'allow_multiple_bed_for_resv_yn\' id=\'allow_multiple_bed_for_resv_yn\' value=\'N\'  ";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =" disabled ></td>\n\t</tr>\n\t<!-- Added by Darshini-->\n<!-- Below line added for the CRF [GHL-CRF-0340] -->\n<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n<tr>\n<td class=\'label\'>";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="</td>\n<td class=\'fields\' colspan = \"6\"><input type=\'checkbox\' name=\'res_reserve_bed_intraward_yn\' id=\'res_reserve_bed_intraward_yn\' value=\'N\' ";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =" onclick=\'ChkReserveBedIntrawardYN();\'></td>\n<!--Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] -->\n";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n<td class=\'label\'>";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="</td>\n<td class=\'fields\'><input type=\'checkbox\' name=\'chk_pen_sale_rtn_bfr_dis_adv\' id=\'chk_pen_sale_rtn_bfr_dis_adv\' value=\'Y\' ";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="</td> <!-- added by mujafar for ML-MMOH-CRF-0659 -->\n<td class=\'fields\'><input type=\'checkbox\' name=\'allow_user_modify_disc_type_status_yn\' id=\'allow_user_modify_disc_type_status_yn\' value=\'N\' ";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="  onclick=\'ChkModifyDiscTypeStatus();\'></td>\n";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\n\n\n</tr>\n<!--End-->\n<tr>\n    <tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t<tr>\n    <td class=\'label\'>";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="</td>\n\t<td   class=\'fields\' align=\'left\' >&nbsp;<input type=\'text\' name=\'change_admi\' id=\'change_admi\' size=\'2\' maxlength=\'2\' value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' >&nbsp;";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="<img src=\'../../eMP/images/mandatory.gif\'align=\'center\'></img></td>\n   <td class=\'label\'>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</td>\n   <td class=\'fields\' colspan = \"6\"><input type=\'checkbox\' name=\'Allow_Invoke_Maintn_Dth_Reg_YN\' id=\'Allow_Invoke_Maintn_Dth_Reg_YN\' value=\'N\' ";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 =" onclick=\"mandatoryDeathCheck();\">\n   <!--Below line added for this CRF ML-MMOH-CRF-0688-->\n   <input type=\'radio\' id=\'inv_deathreg_mandatory\' name=\'inv_deathreg_mandatory_y\' id=\'inv_deathreg_mandatory_y\' value=\'Y\' tabIndex=\'0\' ";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 =" onclick=\'invdeath_mandatory_radio()\' >\n\t\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\t<input type=\'radio\' id=\'inv_deathreg_notmandatory\' name=\'inv_deathreg_mandatory_n\' id=\'inv_deathreg_mandatory_n\' value=\'N\'  tabIndex=\'0\' ";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 =" onclick=\'invdeath_nonmandatory_radio()\'>\n\t\t\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\t \n\t\t <input type=\'hidden\' name=\'invdeathregmandatoryYN\' id=\'invdeathregmandatoryYN\' value=\'N\' >\n   \n   <!--End ML-MMOH-CRF-0688-->    \n   </td>\n\t</tr>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="&nbsp;";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="&nbsp;<input type=\"button\" class = \'BUTTON\' onclick=\"ConsentText()\" value=\"C\"></td>\n\t<td>\n\t<input type=\"hidden\" name=\"consent_text_details\" id=\"consent_text_details\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\"></td>\n<!-- Added by Shanthi-->\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="</td>\n\t<!-- <input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'chk_for_pen_orders_bfr_dis_adv\' id=\'chk_for_pen_orders_bfr_dis_adv\' value=\'Y\' ";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="  tabIndex=\'0\' onclick=\'dischargeAdvice()\'  ></td> -->\t\t\t\t\t\t\n    <td class=\'fields\' colspan = \"6\">\n\t<input type=\'checkbox\' name=\"allow_reason_for_late_discharge\" id=\"allow_reason_for_late_discharge\" value=\'N\' ";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 =" tabIndex=\'0\' onclick=\'mandatoryDischargeReason();\' > \n\n\t\n\t\t\t<input type=\'radio\' id=\'reason_mandatory\' name=\'mandatory_option_y\' id=\'mandatory_option_y\' value=\'Y\'      tabIndex=\'0\' ";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =" onclick=\'mandatory_radio_1()\' >\n\t\t\t";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t\t\t<input type=\'radio\' id=\'reason_not_mandatory\' name=\'mandatory_option_n\' id=\'mandatory_option_n\' value=\'N\'  tabIndex=\'0\' ";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 =" onclick=\'mandatory_radio_2()\'>\n\t\t\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t \n\t\t <input type=\'hidden\' name=\'mandatoryYN\' id=\'mandatoryYN\' value=\'N\' >\n\n\t\t </td>\n\t\t</tr>\n\t\t<!-- Added for the CRF - HSA-CRF-0035 -- Begin -->\n\t\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="&nbsp;</td>\n\t\t<td class=\'fields\'><input type=\'checkbox\' name=\'transfer_wo_delink_yn\' id=\'transfer_wo_delink_yn\' value=\'";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 =" onclick=\'setVal(this)\'></td>\n\t\t<!-- Added for MMS-QH-CRF-0144 -->\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="&nbsp;</td>\n\t\t<td class=\'fields\' colspan = \"6\"><input type=\'checkbox\' name=\'reason_for_adm_reqd_yn\' id=\'reason_for_adm_reqd_yn\' value=\'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 =" onclick=\'setVal(this)\'></td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t\t\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t\t\t<tr>\n\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="&nbsp;</td>\n\t\t\t<td class=\'fields\'><input type=\'checkbox\' name=\'pre_disch_appl_yn\' id=\'pre_disch_appl_yn\' value=\'";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 =" onclick=\'setVal(this)\'></td>\n\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t</tr>\n\t\t<!-- Added for the CRF - HSA-CRF-0035 -- End -->\n\t\n\t<!-- for CRF \"MZ-CRF-0017-IP\"  by sathish on Wednesday, March 03, 2010 starts here -->\n\t<!--tr>\n\t<td class=\'label\'>";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="</td>\n\t<td class=\'fields\'><input type=\'checkbox\' name=\'BED_MANDATORY_FOR_ADMN_YN\' id=\'BED_MANDATORY_FOR_ADMN_YN\' value=\'N\' ";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 =">\n\t</tr>\n\t\n\t<tr><td height=5 colspan=4 class=label>&nbsp;</td></tr-->\n\t<!-- Ends here -->\n\n\t\n  ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n<!-- \t<tr>\n\t\t<td  class=\'label\' align =\'right\' width=\"20%\" >";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="</td>\n\t\t<td class=\'fields\' align =\'left\' width=\"15%\" ><input type=\'checkbox\' size=\'8\' maxlength=\'8\' name=\'CANCEL_DISCHARGE_APPL_YN\' id=\'CANCEL_DISCHARGE_APPL_YN\' onclick=\"setVal(this);\" value=\'N\'  ></td>\n\t\t<td  class=label>&nbsp;</td>\n\t\t<td  class=label>&nbsp;</td>\n\t</tr> -->\n\t<!-- Added by Dharma on Oct 17th against HSA-CRF-0181 [IN:049541] Start -->\n\t<tr>\n\t\t<td height=5 colspan=6 class=label>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="</td>\n\t\t<td class=\'fields\' colspan=6>\n\t\t\t<select name=\'weight_on_admn_mandatory\' id=\'weight_on_admn_mandatory\'>\n           \t\t <option value=\'\' >---------------";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="---------------</option>\n           \t\t <option value=\'A\' ";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="selected";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="</option>\n           \t\t <option value=\'P\' ";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="</option>\n           \t\t <option value=\'D\' ";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="</option>\n\t\t\t</select>\n\t\t</td>\n\n\t\t<!--Added by Thamizh selvi on 8th May 2017 against ML-MMOH-CRF-0617 Start-->\n\t\t";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="</td>\n\t\t<td class=\'fields\'><input type=\'checkbox\' name=\'autoCnrmTfrReq\' id=\'autoCnrmTfrReq\' value=\'";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 =" ></td>\n\t\t";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\n\t\t<!-- End-->\n\n\t</tr>\n\t<!-- Added by Dharma on Oct 17th against HSA-CRF-0181 [IN:049541] End-->\n\t<!--Added by Thamizh selvi on 10th Nov 2017 against ML-MMOH-CRF-0866 Start-->\n\t<tr>\n\t\t<td height=5 colspan=6 class=label>&nbsp;</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t<tr>\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="</td>\n\t\t<td class=\'fields\' colspan=6>\n\t\t\t<select name=\'height_on_admn_mandatory\' id=\'height_on_admn_mandatory\'>\n           \t\t <option value=\'\' >---------------";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="</option>\n\t\t\t</select>\n\t\t</td>\n\t\t\n\t\t\n\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="&nbsp;</td>\n\t\t<td class=\'fields\' colspan=6>\n\t\t\t<select name=\'enable_height_bmi_pat_cls\' id=\'enable_height_bmi_pat_cls\'>\n           \t\t <option value=\'\' >---------------";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="---------------</option>\n           \t\t <option value=\'DC\' ";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="</option>\n           \t\t <option value=\'IP\' ";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="</option>\n           \t\t <option value=\'ID\' ";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="</option>\n\t\t\t</select>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t</tr>\n\t\t\n\t\t<tr>\n\t\t<td height=5 colspan=6 class=label>&nbsp;</td>\n\t</tr>\n\t\t\n\t<tr>\n\t\t\t<td class=\'label\' colspan=3>";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="</td>\n\t\t\t<td class=\'fields\' colspan=6><input type=\'checkbox\' name=\'dispBedClsChange\' id=\'dispBedClsChange\' value=\'";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 =" ></td>\n\t</tr>\n\t<tr>\n\t\t<td height=5 colspan=6 class=label>&nbsp;</td>\n\t</tr>\n\t\n\t<tr>\n\t";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\t\t\t<td class=\'label\' >";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="</td>\n\t\t\t<td class=\'fields\'><input type=\'checkbox\' name=\'trans_yn_unfnzed_newborn\' id=\'trans_yn_unfnzed_newborn\' value=\'Y\' ";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 =" /></td>\n\t\t";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n\t";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\t\n\t\t<!--Added by shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618-->\n\t<td class=\'label\' >";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="</td>\n\t<td class=\'label\' ><select name=\'admission_type\' id=\'admission_type\'>\n           \t\t <option value=\'\' >---";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="---</option>\n           \t\t ";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\n\t\t\t</select></td>\n\t";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\t\n\t</tr>\n\t\n\t\n\t<!-- Added by Mujafar  for ML-MMOH-CRF-1427 start -->\n\t\t\n\t\t";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\n\t\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t\t<tr>\n\t\t\n\t\t\t<td  class=\'label\'  >";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\n                                    </td>\n                                    <td class=\'fields\'   ><select name=\'DISP_TYPE_FOR_REVOKE_DEATH\' id=\'DISP_TYPE_FOR_REVOKE_DEATH\' >\n                                            <option value=\'\'>&nbsp;-------- ";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 =" --------&nbsp;</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\n\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t</td>\n\t\t\n\t\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\n\t\t\n\t\t\n\t\t<!-- Added by Mujafar  for ML-MMOH-CRF-1427 end  -->\n\t\n\t\n\n\t<!--Added by Ashwini on 06-Mar-2019 for MO-CRF-20148-->\n\t";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\n\t<tr>\n\t\t  <td class=\'label\' nowrap>";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="</td>\n\t\t  <td class=\'fields\' nowrap><input type=\'checkbox\' name=\'validate_natid_IP_admsn\' id=\'validate_natid_IP_admsn\' value=\'";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="></td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\n\t<!--End MO-CRF-20148-->\n\t<tr>\n\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="</td>\n\t<td class=\'label\' colspan=1>\n\t\t<table>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="<input type=\"checkbox\" name=\"dis_adv_ot_pend_ord_yn\" id=\"dis_adv_ot_pend_ord_yn\" value=\"Y\" ";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 =" /><td>\n\t\t\t\t<td class=\'label\' nowrap>";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 =" <input type=\"checkbox\" name=\"dis_ot_pend_ord_yn\" id=\"dis_ot_pend_ord_yn\" value=\"Y\" ";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="/><td>\n\t\t\t\t\n\t\t\t</tr>\n\t\t</table>\n\t</td>\n\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="</td> <!--  added by mujafar for MO-CRF-20157 -->\n\n<td   class=\'fields\' colspan = \"6\" align=\'left\' ><input type=\'checkbox\' size=\'8\' maxlength=\'8\'  name=\'ALLOW_GATE_PASS_PRE_DIS_ADV_YN\' id=\'ALLOW_GATE_PASS_PRE_DIS_ADV_YN\' value=\'Y\' ";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="  ></td>\n\t</tr>\n\t<tr>\n\n\t\t<td height=5 colspan=6 class=label>&nbsp;</td>\n\t</tr>\n\t<!-- ADDED BY SUJI KEERTHI ON 24-MAR-2020 FOR MOHE-CRF-0014 -->\n\t<tr>\n\t\t  <td class=\'label\' nowrap>";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="</td>\n\t\t  <td class=\'fields\' colspan = \"6\" nowrap><input type=\'checkbox\' name=\'enable_disch_diagnosis_yn\' id=\'enable_disch_diagnosis_yn\' value=\'";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="></td>\n\t</tr>\n\t<!-- END MOHE-CRF-0014 -->\n\t<!--End-->\n</table>\n<table name=\'tab_table\' id=\'tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\' width=\'100%\' align=\'center\'>  \n<th colspan=\'12\' align=\'left\'>";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\n\n\t<tr>\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="</td>\n\t\t<td   class=\'fields\' align=\'left\' >&nbsp;<input type=\'text\' name=\'bed_block_period_normal\' id=\'bed_block_period_normal\' size=\'3\' maxlength=\'3\' value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 =" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNum(this);checkNormalMax2(this);CheckZeroVal(this);\">&nbsp;";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="<img src=\'../../eMP/images/mandatory.gif\'align=\'center\'></img></td>\n\n\n";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\n\t\t<td   class=\'label\' align=\'left\' > ";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\n\t\t</td>\n        <td class=\'fields\' colspan = \"6\">&nbsp;<input type=\'text\'align=\"left\"  name=\'bed_block_period_max\' id=\'bed_block_period_max\'  size=\'3\' maxlength=\'3\' value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 =" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'CheckNum(this);checkNormalMax(this);CheckZeroVal(this);\'>\n                ";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\n               &nbsp;<select name=\"bed_block_period_max_type\" id=\"bed_block_period_max_type\" onchange=\"checkNormalMax1()\" ";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 =">\n                        <option value=\'H\' ";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="</option>\n                        <option value=\'D\' ";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="</option>\n               </select><img src=\'../../eMP/images/mandatory.gif\'align=\'center\'></img>&nbsp;&nbsp;\n        </td>\t\t\n\t</tr>\n\t<tr><td height=5 colspan=12 class=label>&nbsp;</td></tr>\n\n";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\n\n<tr>\n\t\t<td   class=\'label\' align=\'left\'  >";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="</td>\n\t\t<td   class=\'fields\' align=\'left\'  >&nbsp;<input type=\'text\' size=\'3\' name=\'bed_block_period_dis\' id=\'bed_block_period_dis\'  maxlength=\'3\' ";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 =" value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNum(this);CheckZeroVal(this);\">&nbsp;";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="<img src=\'../../eMP/images/mandatory.gif\'align=\'center\'></img></td> \t\n\n";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\n\t\t<td   class=\'label\' align=\'left\' nowrap>";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="</td>\n\t\t<td  class=\'fields\' colspan = \"6\" align=\'left\'>&nbsp;<input type=\'text\' size=\'3\' name=\'transfer_out\' id=\'transfer_out\'  value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 =" maxlength=\'3\'  onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNum(this);\" >&nbsp;";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="</td>\n</tr>\n\t\t<!-- ----- Added by Sridhar on 12th feb 2004 ------- -->\n\t\t<!-- ------------ PRIORITY START --------- -->\n\t\t";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\n\n\t\n\t\t<td class=\'BLANKROW1PT\' colspan=\'8\'>&nbsp;</td>\n\t</tr>\t\n\n";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\n\n<tr>\n\t<td class=\'label\' align=\'left\' colspan=3>";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="</td>\n\t<td   class=\'fields\' align=\'left\'  colspan=6>&nbsp;<input type=\'text\' size=\'3\' name=\'dflt_bed_blocking_period\' id=\'dflt_bed_blocking_period\'  value=\"";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 =" maxlength=\'3\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"setfcs();CheckNum(this);checkNormalMax(this); \" >&nbsp;";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="</td>       \n</tr>\n<tr>\n\t<td   class=\'BLANKROW1PT\'  colspan=\'12\' >&nbsp;<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\" > <input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\" ></td>\n</tr>\t\n\n</table>\n\t</div>\n\n<div id = \'ADDITIONAL\' style = \'display:none\'>\n<!-- <a name=\'inpat_act_tab_vw\'></a>\n -->\t\n <ul id=\"tablist\" class=\"tablist\" style=\"padding-left:0px\">\n\t\t<li class=\"tablistitem\" title=\"ADT\">\n\t\t\t<a class=\"tabA\" id=\"outpat_act_tab\"><span class=\"tabAspan\" id=\"outpat_act_tab_span\" onClick=\'javascript:expandCollapse(\"adt\")\'>ADT</span>\n\t\t\t</a>\n\t\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Additional\">\n\t\t\t<a class=\"tabClicked\" id=\"inpat_act_tab\"><span class=\"tabSpanclicked\" id=\"inpat_act_tab_span\" onClick=\'javascript:expandCollapse(\"additional\")\'>";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t</ul>\n<table name=\'tab_table\' id=\'tab_table\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\' width=\'100%\' align=\'center\'>\n\t<th colspan=\'6\' align=\'left\'>";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="</th>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\" > \n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\" >\n\t<tr>\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="</td>\n\t\t<td   class=\'fields\' align=\'left\'  >&nbsp;<input type=\'text\' size=\'8\' maxlength=\'8\' name=\'lodger_next_srl_no\' id=\'lodger_next_srl_no\' value=\"";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 =" onBlur= \'CheckNum(this);validateSrlNo(this);CheckZeroVal(this);\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' tabIndex=\'0\'><img src=\'../../eMP/images/mandatory.gif\'align=\'center\'></img><input type=\'hidden\' name = \'Foff\' ></td>\n\n";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\n\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="</td>\n\t\t<td   class=\'fields\' align=\'left\' >&nbsp;<input type=\'text\' size=\'8\' maxlength=\'8\' name=\'lodger_max_srl_no\' id=\'lodger_max_srl_no\' value=\"";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 =" onBlur=\"CheckNum(this);validateSrlNo(this);CheckZeroVal(this);\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' tabIndex=\'0\' ><img src=\'../../eMP/images/mandatory.gif\'align=\'center\'></img>\n\t\t</td>\n\t\t</tr>\n\t\t\t<tr>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n</tr>\n\n";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="&nbsp;</td>\n\t\t<td   class=\'fields\' align=\'left\'  >&nbsp;<input type=\'text\' size=\'3\' maxlength=\'3\' name=\'max_stay_of_lodger_after_disc\' id=\'max_stay_of_lodger_after_disc\'  value=\"";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 =" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\"CheckNum(this);\">&nbsp;";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="</td>\n\t\t";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\t\t\t\t\n\t\t\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="</td>\n\t\t\t\t<td class=\'fields\' >&nbsp;<input type=\'text\'align=\"left\"  name=\'allwbl_pd_rnw_gtpass\' id=\'allwbl_pd_rnw_gtpass\'  size=\'3\' maxlength=\'3\' value=\"";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 =" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'CheckNum(this);\'>\n                ";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\n            &nbsp;<select name=\"bed_block_period_max_type1\" id=\"bed_block_period_max_type1\" ";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="</option>\n                </select>\n\t\t</td>\n\t\t\t\t</tr>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\n<tr>\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="</td>\n\t\t<td   class=\'fields\' align=\'left\' >&nbsp;<input type=\'text\' size=\'2\' maxlength=\'2\' name=\'MAX_ALLOWED_ACCOM_PERS\' id=\'MAX_ALLOWED_ACCOM_PERS\' value=\"";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 =" onBlur=\"CheckNum(this);\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' tabIndex=\'0\' >\n\t\t</td>\t\n\n\t";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\t\t\t\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="&nbsp;</td>\n\t\t<td   class=\'fields\' align=\'left\'  >&nbsp;<input type=\'text\'align=\"left\"  name=\'chk_in_lodger_max_period\' id=\'chk_in_lodger_max_period\'  size=\'3\' maxlength=\'3\' value=\"";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 =" onKeyPress=\'return(ChkNumberInput(this,event,0))\'  onBlur=\'CheckNum(this);\'>&nbsp;";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="</td>\n\t</tr>\n<tr>\n<td colspan=6 class=label>&nbsp;</td>\n</tr>\n\n";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\n\n\t<tr>\n\t<th colspan=\'6\' align=\'left\'>";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 =" </th>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t<tr>\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="</td>\n\t\t<td   class=\'fields\' align=\'left\' ><input type=\'checkbox\' size=\'8\' maxlength=\'8\' name=\'allow_release_bed_on_lv\' id=\'allow_release_bed_on_lv\' ";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 =" value=\'Y\' ";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 =" tabIndex=\'0\'>\n\t\t</td>\n\n";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="</td>\n\t\t<td   class=\'fields\' align=\'left\' >&nbsp;<input type=\'text\' size=\'3\' maxlength=\'3\' name=\'max_allowed_lv_period\' id=\'max_allowed_lv_period\' onBlur=\"CheckNum(this)\" value=\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 =" onKeyPress=\'return(ChkNumberInput(this,event,0))\' tabIndex=\'0\'>&nbsp;";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="&nbsp;\n\t\t</td>\n</tr>\t\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t<tr>\n\t";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\n\n   ";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\n\n\t";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\n\n\t\t<td    class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="&nbsp;</td>\n\t\t<td   class=\'fields\' align=\'left\' colspan=\'6\'>&nbsp;<input type=\'text\' size=\'3\' maxlength=\'3\' name=\'max_allowed_lv_cancel_period\' id=\'max_allowed_lv_cancel_period\' onBlur=\"CheckNum(this)\"  value=\"";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 =" onKeyPress=\'return(ChkNumberInput(this,event,0))\' tabIndex=\'0\' >&nbsp;";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="</td>\n\t\t\t</tr>\n\t\t\t\t\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\n";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\n\n<tr>\n\t\t<td   class=\'label\' align=\'left\' >";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="</td>\n\t\t<td   class=\'fields\' align=\'left\'  >&nbsp;<input type=\'text\' size=\'2\' maxlength=\'2\' name=\'ABSCOND_GRACE_PERIOD\' id=\'ABSCOND_GRACE_PERIOD\' value=\"";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 =" onBlur= \'CheckNum(this);\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' tabIndex=\'0\'>&nbsp;";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="</td>\n\n";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="</td>\n\t\t<td   class=\'fields\' align=\'left\' >&nbsp;<input type=\'text\' size=\'2\' maxlength=\'2\' name=\'NO_SHOW_GRACE_PERIOD\' id=\'NO_SHOW_GRACE_PERIOD\' value=\"";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 =" onBlur=\"CheckNum(this);\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' tabIndex=\'0\' >&nbsp;";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\n\t\t</td>\n\t\t</tr>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t<tr>\n\t\n\t";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="</td>\n\t\t<td   class=\'fields\' align=\'left\'  colspan=\'6\'><input type=\'radio\' name=\'warn_or_error_max_leave\' id=\'warn_or_error_max_leave\' value=\'W\'  tabIndex=\'0\' ";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 =" >&nbsp;";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="&nbsp;<input type=\'radio\' name=\'warn_or_error_max_leave\' id=\'warn_or_error_max_leave\' value=\'E\' tabIndex=\'0\' ";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="  ";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="</td>\n\t</tr>\n\n<!-- ";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\n\t\t<script>document.ipparam_form.warn_or_error_max_leave[0].disabled = true;</script>\n\t";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\n\t<script>document.ipparam_form.warn_or_error_max_leave[1].disabled = true;</script>\n\t";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 =" -->\n\n\n</table>\n\t";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\n\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t<tr><th colspan=\'6\' align=\'left\'>";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="</th><tr>\n\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t<td   class=\'label\' align=\'left\' width =\'42%\'>";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="</td>\n\t<td   class=\'fields\' align=\'left\' width =\'5%\'><input type=\'checkbox\' size=\'1\' maxlength=\'1\' name=\'bl_interfaced_yn\' id=\'bl_interfaced_yn\' value=\'Y\' ";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 =" tabIndex =\'0\'>\n\t\t</td>\n\t\t<td   class=\'label\' align=\'right\' width =\'45%\'>&nbsp;</td>\n\t\t<td   class=\'label\' align=\'left\' width =\'7%\'>&nbsp;</td>\n\t</tr>\n\t</tr>\n\n";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\n\t\t\t<input type=\'hidden\' name=install_yn  value=\"";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\"><input type=\'hidden\' name=\"lodger_next_srl_no_db\" id=\"lodger_next_srl_no_db\"  value=\"";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\">\n<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t</table>\n\t<!-- SCR 4020 FDPMG20089CRF0119IP -->\n\n\t\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t\n\t\t<tr><th colspan=\'6\' align=\'left\'>";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="</th><tr>\n\t\t\n\t\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\n\t\t<tr>\n\t\t\t<td   class=\'label\' align=\'left\' width = \'42%\'>";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="</td>\n\t\t\t<td   class=\'fields\' align=\'left\' width = \'10%\'><input type=\'checkbox\' size=\'8\' maxlength=\'8\' name=\'allow_booking_without_edd_yn\' id=\'allow_booking_without_edd_yn\' value=\'N\' ";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="></td>\n\t\t\t<td   class=\'label\' align=\'left\' width = \'35%\'>";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="</td>\n\t\t\t<td   class=\'fields\' align=\'left\' width = \'10%\'><input type=\'checkbox\' size=\'8\' maxlength=\'8\' name=\'allow_booking_with_edd_yn\' id=\'allow_booking_with_edd_yn\' value=\'N\' ";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 =" ></td>\n\n\t\t</tr>\n\t\t<tr><td height=5 colspan=6 class=label>&nbsp;</td></tr>\n\t</table>\n\t\n\t<table cellspacing=0 cellpadding=0 align=\'center\' width=\'100%\' border=\'0\'>\n\t\t\t<tr>\n\t\t\t<td   class=\'label\' align=\'center\' width=\'26%\'><B>";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="</B></td>\n\t\t\t<td   class=\'label\' align=\'center\' width=\'18%\'><B>";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="</B></td>\n\t\t\t<td   class=\'label\' align=\'center\' width=\'16%\'><B>";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="</B></td>\n\t\t\t<td   class=\'label\' align=\'center\' width=\'20%\'><B>";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="</B></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td   class=\'label\' align=\'right\' width =\'26%\'>&nbsp;</td>\n\t\t\t\t<td   class=\'label\' align=\'right\' width =\'18%\'>&nbsp;</td>\n\t\t\t\t<td   class=\'label\' align=\'right\' width =\'16%\'>&nbsp;</td>\n\t\t\t\t<td   class=\'label\' align=\'right\' width =\'18%\'>&nbsp;</td>\n\t\t\t\t<td   class=\'label\' align=\'right\' width =\'20%\'>&nbsp;</td>\n\t\t\t\t\n\t\t\t</tr>\n\t</table>\n\t<table bordercolor=\"black\" width=\'100%\' >\n\t\t\t<tr>\n\t\t\t\t<td class=\'IP_WoodButton\' width =\'24%\' ><font size=1>&nbsp";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="&nbsp;&nbsp</td>\n\t\t\t\t<td    align=\'center\' width=\'18%\'><input type=\'checkbox\' size=\'2\' maxlength=\'2\' name=\'future_booking_for_boc_yn\' id=\'future_booking_for_boc_yn\' value=\'N\' ";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 =" onclick=\'disfuturebooking(this)\'></td>\n\t\t\t\t<td  align=\'center\' width=\'16%\' ><input type=\'textbox\' size=\'3\' maxlength=\'3\' name=\'no_of_days_before_for_boc\' id=\'no_of_days_before_for_boc\' value=\'";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\' onblur=\'CheckZeroVal(this)\' onKeyPress=\'return(ChkNumberInput(this,event,0))\'>";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="</td>\n\t\t\t\t<td    align=\'center\' width=\'16%\'><input type=\'checkbox\' size=\'2\' maxlength=\'2\' name=\'consider_edd_stop_for_boc_yn\' id=\'consider_edd_stop_for_boc_yn\' value=\'N\' ";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 =" ></td>\n\t\t\t\t<td class=\'fields\' align=\'center\' width=\'18%\'><select name=\'action_for_boc\' id=\'action_for_boc\' >\n\t\t\t\t\t<option value=\'W\' ";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="</option>\n\t\t\t\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="</option></select>\n\t\t\t\t</td>\t\t\t\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td class=\'IP_LWoodButton\' width =\'24%\'><font size=1>&nbsp;";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="&nbsp;&nbsp;</td>\n\t\t\t\t<td    align=\'center\' width=\'18%\'><input type=\'checkbox\' size=\'2\' maxlength=\'2\' name=\'future_booking_for_bou_yn\' id=\'future_booking_for_bou_yn\' value=\'N\'  ";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 =" onclick=\'disfuturebooking(this)\'></td>\n\t\t\t\t<td  align=\'center\' width=\'16%\' ><input type=\'textbox\' size=\'3\' maxlength=\'3\' name=\'no_of_days_before_for_bou\' id=\'no_of_days_before_for_bou\' onblur=\'CheckZeroVal(this)\' value=\'";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\' onKeyPress=\'return(ChkNumberInput(this,event,0))\'>";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="</td>\n\t\t\t\t<td    align=\'center\' width=\'16%\'><input type=\'checkbox\' size=\'8\' maxlength=\'8\' name=\'consider_edd_stop_for_bou_yn\' id=\'consider_edd_stop_for_bou_yn\' value=\'N\' ";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 =" ></td>\n\t\t\t\t<td class=\'fields\' align=\'center\' width=\'18%\'><select name=\'action_for_bou\' id=\'action_for_bou\' >\n\t\t\t\t\t<option value=\'W\' ";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="</option></select>\n\t\t\t\t</td>\t\t\t\n\t\t\t</tr>\n\n\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<!--<td  width =\'25%\' bgcolor=\'#871F78\'>-->\n\t\t\t\t<td width=\'24%\' class=\'IP_PurpleButton\'><b><font size=\'1\' color = \'#FFFFFF\' >&nbsp;";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="</b></td>\n\t\t\t\t<td   align=\'center\' width=\'18%\'><input type=\'checkbox\' size=\'2\' maxlength=\'2\' name=\'future_booking_for_bnc_yn\' id=\'future_booking_for_bnc_yn\' value=\'N\' onclick=\'disfuturebooking(this)\' ";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="></td>\n\t\t\t\t<td  align=\'center\' width=\'16%\' ><input type=\'textbox\' size=\'3\' maxlength=\'3\' name=\'no_of_days_before_for_bnc\' id=\'no_of_days_before_for_bnc\' value =\'";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="</td>\n\t\t\t\t<td    align=\'center\' width=\'16%\'><input type=\'checkbox\' size=\'8\' maxlength=\'8\' name=\'consider_edd_stop_for_bnc_yn\' id=\'consider_edd_stop_for_bnc_yn\' value=\'N\'  ";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="></td>\n\t\t\t\t<td class=\'fields\' align=\'center\' width=\'18%\'><select name=\'action_for_bnc\' id=\'action_for_bnc\' >\n\t\t\t\t\t<option value=\'W\' ";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="</option></select>\n\t\t\t\t</td>\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td class=\'IP_LpurpleButton\' width =\'24%\'><!--<td width = \'27%\' bgcolor=\'#DF0174\'>--><font size=1>&nbsp;";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="</td>\n\t\t\t\t<td    align=\'center\' width=\'18%\'><input type=\'checkbox\' size=\'2\' maxlength=\'2\' name=\'future_booking_for_bnu_yn\' id=\'future_booking_for_bnu_yn\' value=\'N\' onclick=\'disfuturebooking(this)\' ";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="></td>\n\t\t\t\t<td   align=\'center\' width=\'16%\' ><input type=\'textbox\' size=\'3\' maxlength=\'3\' name=\'no_of_days_before_for_bnu\' id=\'no_of_days_before_for_bnu\' value =\'";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="</td>\n\t\t\t\t<td    align=\'center\' width=\'16%\'><input type=\'checkbox\' size=\'8\' maxlength=\'8\' name=\'consider_edd_stop_for_bnu_yn\' id=\'consider_edd_stop_for_bnu_yn\' value=\'N\'  ";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="></td>\n\t\t\t\t<td class=\'fields\' align=\'center\' width=\'18%\'><select name=\'action_for_bnu\' id=\'action_for_bnu\' onBlur=\"setfcs1();\">\n\t\t\t\t\t<option value=\'W\' ";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="</option></select>\n\t\t\t\t</td>\t\t\t\n\t\t\t</tr>\n\n\n\t</table>\n\t<!-- Below line Added for this CRF Bru-HIMS-CRF-354 -->\n\t<table cellspacing=0 cellpadding=0 align=\'left\' width=\'100%\' border=\'0\'>\n\t\t\n\t\t<tr><th colspan=\'6\' align=\'left\'>";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="</th><tr>\n\t\t\n\t\t<tr><td colspan=6 class=label>&nbsp;</td></tr>\n\t\t<tr><td class=label  width =\'30%\'>";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="</td>\n\t\t<td class=\'fields\' align=\'left\' width=\'25%\' ><select name=\'default_ref_pract\' id=\'default_ref_pract\'>\n\t\t<option value=\'A\' ";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="</option>\n\t\t<option value=\'L\' ";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="</option></select></td>\n\t\t<!--Below line added for this CRF  HSA-CRF-146.1-->\n\t\t<td class=label align=\'left\'  width=\'20%\' >&nbsp;";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="</td>\n\t\t<td class=\'fields\' align=\'left\' width=\'20%\'  >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'checkbox\' size=\'2\' maxlength=\'2\' name=\'allow_muti_bedside_review_yn\' id=\'allow_muti_bedside_review_yn\' value=\'";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\' onclick=\'setVal(this)\' ";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="></td></td>\n\t\t<td class=\'fields\' align=\'left\'  width=\'20%\' >&nbsp;</td>\n\t\t<!--End this CRF HSA-CRF-146.1 -->\n\t\t</tr>\n\t\t<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->\n\t\t<tr><td class=label  width =\'30%\'>";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="</td>\n\t\t<td class=\'fields\' align=\'left\' width=\'25%\' ><input type=\'checkbox\' size=\'2\' maxlength=\'2\' name=\'ca_record_referral_note_yn\' id=\'ca_record_referral_note_yn\' value=\'";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="> </td>\n\t\t<!--Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362-->\n\t\t<!--Added by Kamatchi S for MOHE-CRF-0154-->\n\t\t<td class=label  width =\'20%\' nowrap>&nbsp;";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="</td>\n\t\t<td class=\'fields\' align=\'left\' width=\'20%\' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type=\'checkbox\' size=\'2\' maxlength=\'2\' name=\'allow_reg_referral_yn\' id=\'allow_reg_referral_yn\' value=\'";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="> </td>\n\t\t<td class=\'fields\' align=\'left\'  width=\'20%\' >&nbsp;</td>\n\t\t</tr>\n\t\t</table>\n     <!--End this CRF Bru-HIMS-CRF-354 -->\n</div>\n";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\t\t<script>\n\n\t\t</script>\t\n\t\t\n";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\t\t<script>\t\t\t\t\n\t\t\n\t\t</script>\t\n";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\t\n<input type=\"hidden\" name=\"bl_interfaced_yn\" id=\"bl_interfaced_yn\" value=\"N\">\n<input type=\"hidden\" name=\"setup_bl_dtls_in_ip_yn\" id=\"setup_bl_dtls_in_ip_yn\" value=\"N\">\n<input type=\"hidden\" name=\"outst_amt_limit\" id=\"outst_amt_limit\">\n<input type=\"hidden\" name=\"policy_expiry_warning_period\" id=\"policy_expiry_warning_period\">\n<input type=\"hidden\" name=\"credit_auth_reqd_yn\" id=\"credit_auth_reqd_yn\">\n\n<input type=\"hidden\" name=\"isRestrictDischargeAdvice\" id=\"isRestrictDischargeAdvice\" value=\"";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\"> <!--Added by Thamizh selvi on 7th Nov 2016 against GHL-CRF-0412.2 -->\n<!--Added by Ashwini on 06-Mar-2019 for MO-CRF-20148-->\n<input type=\'hidden\' name=\'isNationalIdValidationAppl\' id=\'isNationalIdValidationAppl\' value=\'";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\'>\n</form>\n</body>\n\n\t";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\n\n</html>\n";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	Connection con						= null;
	Statement stmt						= null;
	ResultSet rset						= null;
    Statement stmt_pt_leave				= null;
    ResultSet rset_pt_leave				= null; 
	String facility_id					= "QF";//(String)session.getAttribute("facility_id");
	String locale						= (String)session.getAttribute("LOCALE");

	try
	{
		con								= ConnectionManager.getConnection(request);
		stmt							= con.createStatement();
		String allowed_booking_type		= "D";
		String adm_date_chk_days		= "";
		String MAX_ALLOWED_ACCOM_PERS	= "";
		String CHK_IN_LODGER_MAX_PERIOD	= "";
		String NO_SHOW_GRACE_PERIOD		= "";
		String ABSCOND_GRACE_PERIOD 	= "";
		String dis_date_chk_days		= "";
		String start_admit_screen		= "";
		String bed_block_period_normal	= "";
		String bed_block_period_dis		= "";
		String bed_block_period_max		= "";
		String adv_bed_book_period_bkg	= "";
		String MAX_DISCH_PERIOD_FOR_DC	= "";
		String chk_booking_limit_by		= "";
		String lodger_max_srl_no		= "";
		String lodger_next_srl_no		= "";
		String allow_release_bed_on_lv	= "";
		String max_allowed_lv_period	= "";
		String vital_signs_battery_id	= "";
		String bl_interfaced_yn			= "";
		String bl_fields				= "";
		String bkg_grace_period			= "";
		String warn_or_error_max_leave	= "";
		String action_warning_yn		= "";
		String action_error_yn			= "";
		String adm_date_chk_days_type	= "";
		String allowed_admission_type	= "";
		String mode						= "insert";
		String strTransfer_Out			= "";
		String noshow_bkng_period        ="";  //Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
		String dflt_priority_for_bed_booking ="";
		String dflt_bed_blocking_period	="";
		
		String reserve_bed_on_tfr_yn	="";
		
		/*Added by Thamizh selvi on 4th Nov 2016 against GHL-CRF-0412.2 Start*/
		String chk_pen_ward_rtn_bfr_dis_adv =""; 
		String check_chk_pen_ward_rtn ="";
		/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] Start*/
		String chk_pen_sale_rtn_bfr_dis_adv =""; 
		String dis_chk_pen_sale_rtn_bfr_dis_adv ="";
		/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] End*/
		Boolean isRestrictDischargeAdvice = CommonBean.isSiteSpecific(con,"IP","RESTRICT_DISCHARGE_ADVICE");
		Boolean isModifyDiscTypeStatusAppl = CommonBean.isSiteSpecific(con,"IP","MODIFY_DISC_TYPE_STATUS_YN"); // added by mujafar for ML-MMOH-CRF-0659
		/*End*/

		Boolean isRestrictDisAdvSaleRetPend = CommonBean.isSiteSpecific(con,"IP","RESTRICT_DIS_ADV_SALE_RET_PEND"); //Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892]
		/*Added by Thamizh selvi on 8th May 2017 against ML-MMOH-CRF-0617 Start*/
		String autoCnrmTfrReq =""; 
		String chkAutoCnrmTfrReq ="";
		Boolean isCnrmReqPatOutChngAppl = CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");
		/*End*/
		
		Boolean isPatientEncRevokeDeathAppl=	CommonBean.isSiteSpecific(con, "MP", "PATIENT_ENC_REVOKE_DEATH"); // added by mujafar for JULY-2019 for ML-MMOH-CRF-1427
	String dispTypeForRevokeDeath=""; // added by mujafar  for ML-MMOH-CRF-1427
	

		/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
		 String validate_natid_IP_admsn	= "";
		 String validate_natid_chk		= "";
		 Boolean isNationalIdValidationAppl	= CommonBean.isSiteSpecific(con, "MP", "NATIONAL_ID_VALIDATION");
		 /*End MO-CRF-20148*/
		 
		 /*ADDED BY SUJI KEERTHI ON 24-MAR-2020 FOR MOHE-CRF-0014*/
		 String enable_disch_diagnosis_yn = "";
		 String enable_disch_chk ="";
		 /*END MOHE-CRF-0014*/
		
		/*Added by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866 Start*/
		String dispBedClsChange		= ""; 
		String chkDispBedClsChange	= "";
		/*End*/
//		String CANCEL_DISCHARGE_APPL_YN      ="";
		String max_stay_of_lodger_after_disc ="";
		String pat_type_override_leave_period="";
		String unregistered_patients_bkg_yn = "";
		 //Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
		String chk_for_pen_orders_bfr_dis_adv ="";
		String radio_flag_1                   ="";
		String radio_flag_2                   ="";
		String radio_check_yn_1                ="";
		String radio_check_yn_2                ="";
		String dis_adv_allow_yn                ="";
				//  venkatesh KDAH-CRF-0041 END
		
        /*Below Line Added for this CRF [JD-CRF-0006] by Senthil*/ 
        String chk_for_pen_orders_bfr_dis="";
		String dis_notallow_yn                   ="";
		String dis_notallow_chk               ="";
		String dis_allow_yn                      ="";
		String dis_allow_chk                  ="";		
		String dis_allow_rd                  ="";

       /*End [JD-CRF-0006]*/		
    		
		String max_allowed_lv_cancel_period = "";
		String bed_block_period_max_type	= "";
		String bed_block_period_max_type1	= "";
		String PAT_CHECK_IN_ALLOWED_YN		= "";
		String DEACTIVATE_PSEUDO_BED_YN		= ""; 
		String ALLOW_GATE_PASS_PRE_DIS_ADV_YN = ""; // added by mujafar for MO-CRF-20157
		String Disable_flg					= "";
		String Disable_Enable_flg			= "";
		String Readonly_flg					= "";
		String default_priority				= "";
		String dis_date_chk_days_unit		= "";
		String diag_update_period_max_unit	= "";
		//String bl_operational				=	(String)session.getAttribute("bl_operational");
		String bl_operational				=	"";
		String PRIORITY_APPLICABLE			= "";
		String change_bed_class_yn			= "";
		String discharge_checklist_app_yn	= "";
		String prioryn						= "";
		String DFLT_GATE					= "";
		String DISC_CHKLST_EXP_PERIOD		= "";
		/*Below line(s) was added by venkatesh.S (4008) on 30/10/2012 against  Bru-HIMS-CRF-155 [IN030274] */
		String chk_for_readmission          ="";
	    /* end Bru-HIMS-CRF-155 [IN030274]  */
		String DISC_CHKLST_EXP_PER_UNIT		= "";
		//String external_interface_for_priviledge_yn="";
		String multi_bkg_patient_yn			= "";
		String block_bed_based_on			= "";
		String capture_fin_dtls_yn			= "";
		StringBuffer sql					= new StringBuffer();
		String disable_enable_cap_fin_dtl	= "enabled";
		String allow_multiple_bed_for_resv_yn= "";
		String allow_multiple_bed_disabled  = "";
		String allow_multiple_bed_unchecked = "";
                String res_reserve_bed_intraward_yn ="";         //added for CRF GHL-CRF-0340 by Darshini
                String res_reserve_bed_intraward_disabled = "";  //added for CRF GHL-CRF-0340 by Darshini
		String allow_user_modify_disc_type_status_yn=""; // added by mujafar for ML-MMOH-CRF-0659
          String consenttxtdtls="";
		/*18/11/2008 SCR 4020 FDPMG20089CRF0119IP */

		String	allow_booking_without_edd_yn= "";
		String	allow_booking_with_edd_yn	= "";

		String future_booking_for_boc_yn	= "";
		String no_of_days_before_for_boc	= "";
		String consider_edd_stop_for_boc_yn	= "";
		String action_for_boc				= "";
		String action_for_boc_w				= "";
		String action_for_boc_s				= "";

		String future_booking_for_bou_yn	= "";
		String no_of_days_before_for_bou	= "";
		String consider_edd_stop_for_bou_yn	= "";
		String action_for_bou				= "";
		String action_for_bou_w				= "";
		String action_for_bou_s				= "";

		String future_booking_for_bnc_yn	= "";
		String no_of_days_before_for_bnc	= "";
		String consider_edd_stop_for_bnc_yn	= "";
		String action_for_bnc				= "";
		String action_for_bnc_w				= "";
		String action_for_bnc_s				= "";

		String future_booking_for_bnu_yn	= "";
		String no_of_days_before_for_bnu	= "";
		String consider_edd_stop_for_bnu_yn	= "";
		String action_for_bnu				= "";
		String action_for_bnu_w				= "";
		String action_for_bnu_s				= "";
		
		String grc_prd_for_asgn_bed_mark_arvl	= "";
		String   change_admission_dtls		= "";
		String display_discharge_pat_list	= "A";
		
		/*Below line Added for this CRF Bru-HIMS-CRF-354*/
		String deft_pract_bedside_referral="";
		String deft_pract_bedside_referral_chk_a="";
		String deft_pract_bedside_referral_chk_l="";
		
		//End Bru-HIMS-CRF-354

		
		String invoke_adm_from_newborn_yn	= "";//For Invoke Admission Check Box
		String invoke_adm_chkd				= "";//For Invoke Admission Check Box
//		String disable_enable_cap_fin_dtl	= "enabled";//For Invoke Admission Check Box
		String Allow_Invoke_Maintn_Dth_Reg_YN	= "";
		String BED_MANDATORY_FOR_ADMN_YN	= "N";//new variable created for CRF "MZ-CRF-0017-IP"  by sathish on Wednesday,March03,10 
		
		//Added for the CRF - Bru-HIMS-CRF-157 on 4-5-2012
		String reason_for_late_discharge="";
		String mandatory_flag="";
		String non_mandatory_flag="";
		String radio_check_mandatory_yn_1="";
		String radio_check_mandatory_yn_2="";
		String discharge_reason_mandatory_yn=""; 
		
		//Added for the CRF - HSA-CRF-0035 
		String transfer_wo_delink_yn=""; 
		String transfer_wo_delink_checked=""; 
				
		//Added for the CRF -KDAH-CRF-0104 by Dharma start
		String pre_disch_appl_yn=""; 
		String pre_disch_appl_checked=""; 
		Boolean SiteSpecific_pre_disch_appl = CommonBean.isSiteSpecific(con, "IP","PRE_DISCHARGE");	
		//Added for the CRF -KDAH-CRF-0104  by Dharma end
		
		
		String weight_on_admn_mandatory = ""; /*Added by Dharma on Oct 17th against HSA-CRF-0181 [IN:049541]*/
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 */		
		String height_on_admn_mandatory = "";
		String enable_height_bmi_pat_cls = "";
		Boolean isHeightAndBmiEnable	= CommonBean.isSiteSpecific(con, "MP", "BMI_REG_PAT_CHNGES_RH101");
		/*Added by KAMATCHI S on 23-JUN-2020 for ML-MMOH-CRF-1527 End*/
		//Added for MMS-QH-CRF-0144
		String reason_for_adm_reqd_yn=""; 
		String reason_for_adm_reqd_checked=""; 
		
		//Below line added for this CRF ML-MMOH-CRF-0688
		 String death_register_mandatory_yn="N";
         String invoke_maintn_dth_reg="";
         String death_reg_mandatory_yn_1="";
         String death_reg_mandatory_yn_2="";
		 String death_reg_mandatory_flag=""; 
		 String death_reg_non_mandatory_flag="";
		//End this CRF ML-MMOH-CRF-0688
		
		String chk_dis_pat_BT_order_pend=""; //Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
		String admission_type="";//Added by Shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618
		Boolean isDisPatBTorderPendAppl = CommonBean.isSiteSpecific(con,"IP","CHK_DIS_PAT_BT_ORDER_PEND");//Added by Shanmukh on 23rd-MAY-2018 for ML-MMOH-CRF-1135
		Boolean isAdmissionTypeAppl = CommonBean.isSiteSpecific(con,"IP","ADMISSION_TYPE_APPL");//Added by Shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618
		/*Added by Dharma on 23rd May 2018 against ML-MMOH-CRF-0898 [IN:064757] Start*/
		Boolean isNewBornChngsAppl		 = CommonBean.isSiteSpecific(con,"IP","REG_NEW_BORN_FOR_IP_FLD_CHNGS");
		String trans_yn_unfnzed_newborn	= "N";
		/*Added by Dharma on 23rd May 2018 against ML-MMOH-CRF-0898 [IN:064757] End*/

		String dis_ot_pend_ord_yn = "N";
		String dis_adv_ot_pend_ord_yn = "N";                 
		
		 //Added for  HSA-CRF-146.1
String allow_muti_bedside_review_yn="";
String allow_muti_bedside_review_checked="";
//Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362
String ca_record_referral_note_yn = "";
String ca_record_referral_note_yn_checked="";
//Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362	
//Added by Kamatchi S for MOHE-CRF-0154
String allow_reg_referral_yn = "";
String allow_reg_referral_yn_checked="";
String rel_booked_bed_yn			= "";	//Added  for PMG2016-CRF-0002 IN061508 on 23rd Aug 16
		//MODIFIED ON 17-09-2008 FOR billing parameter yn 
		String sql_bl="select operational_yn from sm_modules_facility where facility_id = '"+facility_id+"' and module_id = 'BL' ";
		rset = stmt.executeQuery(sql_bl);
		if(rset != null && rset.next() )
		{
			bl_operational					= rset.getString("operational_yn");
		}
		if(rset!=null) rset.close();
		//
		sql.append("select * from ip_param where facility_id='"+facility_id+"' ");
		
		rset								= stmt.executeQuery(sql.toString());
		if(rset!=null )
		{
			if(rset.next())
			{		


			Disable_flg						= "Disabled";

			DFLT_GATE						= rset.getString("DFLT_GATE_PASS_PERIOD");
			if(DFLT_GATE == null) DFLT_GATE = "";

			allowed_booking_type			= rset.getString("allowed_booking_type");
			

			DISC_CHKLST_EXP_PERIOD			= rset.getString("DISC_CHKLST_EXP_PERIOD");
			if(DISC_CHKLST_EXP_PERIOD == null) 
				DISC_CHKLST_EXP_PERIOD		= "";

			DISC_CHKLST_EXP_PER_UNIT		= checkForNull(rset.getString("DISC_CHKLST_EXP_PER_UNIT"));

			/*Below line(s) was added by venkatesh.S (4008) on 30/10/2012 against  Bru-HIMS-CRF-155 [IN030274] */
			 chk_for_readmission            = rset.getString("MAX_HRS_FOR_RE_ADMN"); 
			 if(chk_for_readmission == null) 
			  chk_for_readmission            ="";
			   /* end Bru-HIMS-CRF-155 [IN030274]  */
			PRIORITY_APPLICABLE				= rset.getString("PRIORITY_APPLICABLE_YN");
			if(PRIORITY_APPLICABLE == null) PRIORITY_APPLICABLE = "";

			if(PRIORITY_APPLICABLE.equals("Y"))
			{
			  prioryn = "checked";
			}
			else
			{
				prioryn = "";
			}
			
			dispTypeForRevokeDeath =rset.getString("REVOKE_DEATH_DISP_TYPE")==null?"":rset.getString("REVOKE_DEATH_DISP_TYPE"); 	// added by mujafar  for ML-MMOH-CRF-1427
		
			MAX_ALLOWED_ACCOM_PERS			= rset.getString("MAX_ALLOWED_ACCOM_PERS");
			if(MAX_ALLOWED_ACCOM_PERS == null) 
				MAX_ALLOWED_ACCOM_PERS		= "0";

			CHK_IN_LODGER_MAX_PERIOD		= rset.getString("CHK_IN_LODGER_MAX_PERIOD");
			if(CHK_IN_LODGER_MAX_PERIOD == null) 
				CHK_IN_LODGER_MAX_PERIOD	= "0";

			ABSCOND_GRACE_PERIOD			= rset.getString("ABSCOND_GRACE_PERIOD");
			if(ABSCOND_GRACE_PERIOD == null) 
				ABSCOND_GRACE_PERIOD		= "0";

			NO_SHOW_GRACE_PERIOD			= rset.getString("NO_SHOW_GRACE_PERIOD");
			if(NO_SHOW_GRACE_PERIOD == null) 
				NO_SHOW_GRACE_PERIOD		= "0";

			DEACTIVATE_PSEUDO_BED_YN		= rset.getString("DEACTIVATE_PSEUDO_BED_YN");
			if(DEACTIVATE_PSEUDO_BED_YN == null) 
				DEACTIVATE_PSEUDO_BED_YN	= "N";
			DEACTIVATE_PSEUDO_BED_YN		= DEACTIVATE_PSEUDO_BED_YN.equals("Y") ?"checked" :"" ;
			
			
			
			 
			ALLOW_GATE_PASS_PRE_DIS_ADV_YN		= rset.getString("ALLOW_GATE_PASS_PRE_DIS_ADV_YN"); // added by mujafar for MO-CRF-20157
			if(ALLOW_GATE_PASS_PRE_DIS_ADV_YN == null) 
				ALLOW_GATE_PASS_PRE_DIS_ADV_YN	= "N";
			ALLOW_GATE_PASS_PRE_DIS_ADV_YN		= ALLOW_GATE_PASS_PRE_DIS_ADV_YN.equals("Y") ?"checked" :"" ;
			
			
			
			
			
			
			
			
			
			
			

			PAT_CHECK_IN_ALLOWED_YN			= rset.getString("PAT_CHECK_IN_ALLOWED_YN");
			if(PAT_CHECK_IN_ALLOWED_YN == null) 
				PAT_CHECK_IN_ALLOWED_YN		= "N";
			PAT_CHECK_IN_ALLOWED_YN			= PAT_CHECK_IN_ALLOWED_YN.equals("Y") ?"checked" :"" ;

			change_bed_class_yn				= rset.getString("change_bed_class_yn");
			if(change_bed_class_yn == null) 
				change_bed_class_yn			= "N";
			change_bed_class_yn				= change_bed_class_yn.equals("Y") ?"checked" :"" ;

			discharge_checklist_app_yn		= rset.getString("discharge_checklist_app_yn");
			if(discharge_checklist_app_yn == null) 
				discharge_checklist_app_yn	= "N";
			discharge_checklist_app_yn		= discharge_checklist_app_yn.equals("Y") ?"checked" :"";
			adm_date_chk_days				= rset.getString("adm_date_chk_days");
			if(adm_date_chk_days == null) 
				adm_date_chk_days			= "0";

			dis_ot_pend_ord_yn = checkForNull(rset.getString("dis_ot_pend_ord_yn"),"N");
			dis_adv_ot_pend_ord_yn = checkForNull(rset.getString("dis_adv_ot_pend_ord_yn"),"N");

			adm_date_chk_days_type			= checkForNull(rset.getString("adm_date_chk_days_type"));
			allowed_admission_type			= checkForNull(rset.getString("allowed_admission_type"));
			dis_date_chk_days_unit			= checkForNull(rset.getString("DIS_DATE_CHK_DAYS_UNIT"));
			bed_block_period_max_type		= checkForNull(rset.getString("bed_block_period_max_type"));                        
			bed_block_period_max_type1		= checkForNull(rset.getString("DFLT_GATE_PASS_UNIT")); 
			diag_update_period_max_unit		= rset .getString("DIAG_UPDATE_PERIOD_MAX_UNIT");
			if(diag_update_period_max_unit == null) 
				diag_update_period_max_unit	= "";
			dis_date_chk_days				= rset.getString("dis_date_chk_days");
			if(dis_date_chk_days == null) 
				dis_date_chk_days			= "0";

			start_admit_screen				= rset.getString("start_admit_screen");
			if(start_admit_screen == null) 
				start_admit_screen			= "";

			bed_block_period_normal			= rset.getString("bed_block_period_normal");
			if(bed_block_period_normal == null) 
				bed_block_period_normal		= "";

			bed_block_period_dis			= rset.getString("bed_block_period_dis");
			if(bed_block_period_dis == null) 
				bed_block_period_dis		= "";

			bed_block_period_max			= rset.getString("bed_block_period_max");
			if(bed_block_period_max == null) 
				bed_block_period_max		= "";

			strTransfer_Out					= rset.getString("DFLT_BLK_PRD_FOR_TFR_OUT");
			if(strTransfer_Out == null) 
				strTransfer_Out				= "";

			dflt_priority_for_bed_booking	= rset.getString("dflt_priority_for_bed_booking");
			if(dflt_priority_for_bed_booking == null) 
				dflt_priority_for_bed_booking= "";

			dflt_bed_blocking_period		= rset.getString("dflt_bed_blocking_period");
			if(dflt_bed_blocking_period == null )
				dflt_bed_blocking_period	= "";
	  

			adv_bed_book_period_bkg			= rset.getString("adv_bed_book_period_bkg");
			if(adv_bed_book_period_bkg == null) 
				adv_bed_book_period_bkg		= "0";
			
            //Added  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
			noshow_bkng_period			= rset.getString("NOSHOW_BKNG_PERIOD");
			if(noshow_bkng_period == null) 
				noshow_bkng_period		= "";
			 //end  for Bru-HIMS-CRF-153 [IN:030273] by Srinivas
			MAX_DISCH_PERIOD_FOR_DC			= rset.getString("MAX_DISCH_PERIOD_FOR_DC");
			if(MAX_DISCH_PERIOD_FOR_DC == null) 
				MAX_DISCH_PERIOD_FOR_DC		= "0";

			pat_type_override_leave_period	= rset.getString("ALLOW_PAT_TYPE_FOR_LEAVE");
			if(pat_type_override_leave_period == null) 
				pat_type_override_leave_period	= "";

			max_stay_of_lodger_after_disc	= rset.getString("max_stay_of_lodger_after_disc");
			if(max_stay_of_lodger_after_disc == null)  
				max_stay_of_lodger_after_disc	= "";

			chk_booking_limit_by			= rset.getString("chk_booking_limit_by");
			
			if(chk_booking_limit_by == null) 
				chk_booking_limit_by		= "";
			mode="modify";

			lodger_next_srl_no				= rset.getString("lodger_next_srl_no");
			if(lodger_next_srl_no == null) 
				lodger_next_srl_no			= "";

			lodger_max_srl_no				= rset.getString("lodger_max_srl_no");
			if(lodger_max_srl_no == null) 
				lodger_max_srl_no			= "";

			allow_release_bed_on_lv			= rset.getString("allow_release_bed_on_lv");

			max_allowed_lv_period			= rset.getString("max_allowed_lv_period");
			if(max_allowed_lv_period == null) 
				max_allowed_lv_period		= "";

			max_allowed_lv_cancel_period	= rset.getString("max_allowed_lv_cancel_period");
			if(max_allowed_lv_cancel_period == null) 
				max_allowed_lv_cancel_period = "";

			vital_signs_battery_id			= rset.getString("vital_signs_battery_id");
			if(vital_signs_battery_id == null) 
				vital_signs_battery_id		= "" ;

			bl_interfaced_yn				= rset.getString("bl_interfaced_yn");
			if(bl_interfaced_yn == null)
				bl_interfaced_yn			= "N";

			bl_interfaced_yn				= bl_interfaced_yn.equals("Y") ?"checked" :"" ;

			//<!--2/3/2009 dropped  ext_interface_for_priviledge_yn from IP_PARAM -->
			
			/*
			external_interface_for_priviledge_yn = rset.getString("EXT_INTERFACE_FOR_PRIVILEGE_YN");
			if(external_interface_for_priviledge_yn == null)
			external_interface_for_priviledge_yn = "N";*/

			//external_interface_for_priviledge_yn = external_interface_for_priviledge_yn.equals("Y") ?"checked" :"" ;


			bkg_grace_period				= rset.getString("bkg_grace_period");
			if(bkg_grace_period == null ) 
				bkg_grace_period			= "";

			unregistered_patients_bkg_yn	= rset.getString("UNREGISTERED_PATIENTS_BKG_YN");
			if(unregistered_patients_bkg_yn == null) 
				unregistered_patients_bkg_yn= "N";
			unregistered_patients_bkg_yn	= unregistered_patients_bkg_yn.equals("Y") ?"checked" :"" ;
            
			//Below code added by venkatesh on 09/November/2011 against the KDAH-CRF-0041
			chk_for_pen_orders_bfr_dis_adv =rset.getString("chk_for_pen_orders_bfr_dis_adv");
			dis_adv_allow_yn=rset.getString("dis_adv_allow_yn");
		 
	        
			if(chk_for_pen_orders_bfr_dis_adv.equals("Y")){
			  chk_for_pen_orders_bfr_dis_adv ="checked";
			  if(dis_adv_allow_yn.equals("N"))
			  {
			  radio_check_yn_1 ="checked";
			  }
			  else
			  {
			  radio_check_yn_2="checked";
			  }
			  }
           else{		
	         chk_for_pen_orders_bfr_dis_adv="";
			 radio_flag_1="disabled";
             radio_flag_2="disabled";			 
			}
			
		// venkatesh KDAH-CRF-0041 END	
		
		
		
			/*Below Code Added for this CRF [JD-CRF-0006] by Senthil */
			chk_for_pen_orders_bfr_dis =rset.getString("chk_for_pen_orders_bfr_dis");
			dis_allow_rd=rset.getString("dis_allow_yn");			
	        
			if(chk_for_pen_orders_bfr_dis.equals("Y")){
			  chk_for_pen_orders_bfr_dis ="checked";
			  if(dis_allow_rd.equals("N"))
			  {
			  dis_notallow_yn ="checked";
			  }
			  else
			  {
			  dis_allow_yn="checked";
			  }
			  }
           else{		
	         chk_for_pen_orders_bfr_dis="";
			 dis_notallow_chk="disabled";
             dis_allow_chk="disabled";	
			 }
		
		
			
			
			
			
		/*Above line added for this CRF [JD-CRF-0006] by Senthil*/		
		
		
			
			multi_bkg_patient_yn			= rset.getString("MULTI_BOOK_PAT_YN");
			if(multi_bkg_patient_yn == null) 
				multi_bkg_patient_yn		= "N";
			multi_bkg_patient_yn			= multi_bkg_patient_yn.equals("Y") ?"checked" :"" ;
			//Added  for PMG2016-CRF-0002 IN061508 on 23rd Aug 16
			rel_booked_bed_yn			= rset.getString("REL_BOOKED_BED_YN");
			if(rel_booked_bed_yn == null) 
				rel_booked_bed_yn		= "N";
			rel_booked_bed_yn			= rel_booked_bed_yn.equals("Y") ?"checked" :"" ;

			block_bed_based_on				= rset.getString("block_bed_based_on");
			if(block_bed_based_on == null ) 
				block_bed_based_on			= "";

			capture_fin_dtls_yn				= rset.getString("capture_fin_dtls_yn");
			if(capture_fin_dtls_yn == null) 
				capture_fin_dtls_yn			= "N";
			if(capture_fin_dtls_yn.equals("Y"))
				disable_enable_cap_fin_dtl	= "disabled";
			capture_fin_dtls_yn				= capture_fin_dtls_yn.equals("Y") ?"checked" :"" ;
			

			reserve_bed_on_tfr_yn			= rset.getString("reserve_bed_on_tfr_yn");
			if(reserve_bed_on_tfr_yn == null )
				reserve_bed_on_tfr_yn		= "N";
			reserve_bed_on_tfr_yn			= reserve_bed_on_tfr_yn.equals("Y") ?"checked" :"" ;
			
			/*Added by Thamizh selvi on 4th Nov 2016 against GHL-CRF-0412.2 Start*/
			chk_pen_ward_rtn_bfr_dis_adv = rset.getString("CHK_PEN_WARD_RTN_BFR_DIS_ADV");
			if(chk_pen_ward_rtn_bfr_dis_adv == null )
				chk_pen_ward_rtn_bfr_dis_adv		= "N";
			if(chk_pen_ward_rtn_bfr_dis_adv.equals("Y"))
				check_chk_pen_ward_rtn="checked";	
			else
				check_chk_pen_ward_rtn="";	
			/*End*/

			/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
			autoCnrmTfrReq = rset.getString("auto_confirm_tfr_req_yn");
			if(autoCnrmTfrReq == null )
				autoCnrmTfrReq		= "N";
			if(autoCnrmTfrReq.equals("Y"))
				chkAutoCnrmTfrReq="checked";	
			else
				chkAutoCnrmTfrReq="";	
			/*End*/

			/*Added by Thamizh selvi on 10th Nov 2017 for ML-MMOH-CRF-0866 Start*/
			dispBedClsChange = checkForNull(rset.getString("DISP_BED_CLS_CHANGE_AUTH_YN"),"N");
			if(dispBedClsChange.equals("Y"))
				chkDispBedClsChange = "checked";	
			else
				chkDispBedClsChange = "";	
			/*End*/

			/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] Start*/
			chk_pen_sale_rtn_bfr_dis_adv = checkForNull(rset.getString("chk_pen_sale_rtn_bfr_dis_adv"),"N");
			if(chk_pen_sale_rtn_bfr_dis_adv.equals("Y"))
				dis_chk_pen_sale_rtn_bfr_dis_adv = "checked";	
			else
				dis_chk_pen_sale_rtn_bfr_dis_adv = "";
			/*Added By Dharma on 28th Mar 2019 AMRI-CRF-0380 [IN:067892] End*/
			/*Added by Ashwini on 06-Mar-2019 for MO-CRF-20148*/
			validate_natid_IP_admsn = checkForNull(rset.getString("VALIDATE_NATID_IP_ADMSN"),"N");
			if(validate_natid_IP_admsn.equals("Y"))
				validate_natid_chk = "checked";	
			/*End MO-CRF-20148*/
			
			/*ADDED BY SUJI KEERTHI ON 24-MAR-2020 FOR MOHE-CRF-0014*/
		    enable_disch_diagnosis_yn = checkForNull(rset.getString("ENABLE_DISCH_DIAGNOSIS_YN"),"N");
			if(enable_disch_diagnosis_yn.equals("Y"))
				enable_disch_chk = "checked";
			/*END MOHE-CRF-0014*/

			/*11/10/2008 3698	SRR20056-CRF-0228*/

			if(reserve_bed_on_tfr_yn.equals("N")){
				allow_multiple_bed_disabled	= "disabled";	
				allow_multiple_bed_unchecked = "";	
			}
			allow_multiple_bed_for_resv_yn	= rset.getString("allow_multiple_bed_for_resv_yn");
			if(allow_multiple_bed_for_resv_yn == null )
				allow_multiple_bed_for_resv_yn	= "N";
			allow_multiple_bed_for_resv_yn	= allow_multiple_bed_for_resv_yn.equals("Y") ?"checked" :"" ;
			
			/*GHL-CRF-340*/
			res_reserve_bed_intraward_yn	= rset.getString("res_reserve_bed_intraward_yn");
			if(res_reserve_bed_intraward_yn == null )
				res_reserve_bed_intraward_yn	= "N";
			res_reserve_bed_intraward_yn	= res_reserve_bed_intraward_yn.equals("Y") ?"checked" :"" ;
			if(reserve_bed_on_tfr_yn.equals("checked"))
				{
				res_reserve_bed_intraward_disabled="";
				}
			else
				{
				res_reserve_bed_intraward_disabled="disabled";
				}
			/**/
			
			/* added by mujafar for ML-MMOH-CRF-0659  */
			allow_user_modify_disc_type_status_yn = rset.getString("ALLOW_USER_MODIFY_DISC_YN");
			if(allow_user_modify_disc_type_status_yn == null )
				allow_user_modify_disc_type_status_yn	= "N";
			allow_user_modify_disc_type_status_yn	= allow_user_modify_disc_type_status_yn.equals("Y") ?"checked" :"" ;
			
			
			/* END */
            Allow_Invoke_Maintn_Dth_Reg_YN	= rset.getString("Allow_Invoke_Maintn_Dth_Reg_YN");
			if(Allow_Invoke_Maintn_Dth_Reg_YN == null )
				Allow_Invoke_Maintn_Dth_Reg_YN	= "N";
			
			
			/*Below line added for this CRF ML-MMOH-CRF-0688*/
			death_register_mandatory_yn=rset.getString("death_register_mandatory_yn");
			if (Allow_Invoke_Maintn_Dth_Reg_YN.equals("Y"))
			{
				invoke_maintn_dth_reg="checked";
				if(death_register_mandatory_yn.equals("Y"))
				{
					death_reg_mandatory_yn_1="checked";
				}
				else
				{
					death_reg_mandatory_yn_2="checked";
				}
			}
			else
			{
				invoke_maintn_dth_reg="";
				death_reg_mandatory_flag="disabled";
				death_reg_non_mandatory_flag="disabled";
			}
			
			//End this CRF ML-MMOH-CRF-0688
			
			//This line moved from top to here for ML-MMOH-CRF-0688
			Allow_Invoke_Maintn_Dth_Reg_YN	= Allow_Invoke_Maintn_Dth_Reg_YN.equals("Y") ?"checked" :"" ;

			 /*for CRF "MZ-CRF-0017-IP"  by sathish on Wednesday, March 03, 2010*/
			/* BED_MANDATORY_FOR_ADMN_YN =rset.getString("BED_MANDATORY_FOR_ADMN_YN");
			if(BED_MANDATORY_FOR_ADMN_YN == null )BED_MANDATORY_FOR_ADMN_YN="N";
			BED_MANDATORY_FOR_ADMN_YN = BED_MANDATORY_FOR_ADMN_YN.equals("Y") ?"checked" :"" ;*/

			
            
			/*11/10/2008 3698	SRR20056-CRF-0228*/
            
		/*
			CANCEL_DISCHARGE_APPL_YN = rset.getString("CANCEL_DISCHARGE_APPL_YN");
			if(CANCEL_DISCHARGE_APPL_YN == null)	CANCEL_DISCHARGE_APPL_YN = "N";
*/
			warn_or_error_max_leave			= rset.getString("warn_or_error_max_leave");
            default_priority				= rset.getString("DFLT_PRIORITY_FOR_TFR_REQ");
			if(default_priority == null) 
				default_priority			= "";

//Retriving  invoke_adm_from_newborn_yn Value 12/9/2008 3752	PMG20089-CRF-0047
				
				invoke_adm_from_newborn_yn	= rset.getString("invoke_adm_from_newborn_yn");
//				out.println("invoke_adm_from_newborn_yn==>" +invoke_adm_from_newborn_yn);
				if (invoke_adm_from_newborn_yn.equals("Y"))
					invoke_adm_chkd			= "checked";
				else
					invoke_adm_chkd			= "";

			/*18/11/2008 SCR 4020 FDPMG20089CRF0119IP By Sarita Dugge*/

			allow_booking_without_edd_yn	= rset.getString("ALLOW_BOOKING_WITHOUT_EDD_YN");
			if(allow_booking_without_edd_yn== null) 
				allow_booking_without_edd_yn= "N";
			allow_booking_without_edd_yn	= allow_booking_without_edd_yn.equals("Y") ?"checked" :"" ;

			allow_booking_with_edd_yn		= rset.getString("allow_booking_with_edd_yn");
			if(allow_booking_with_edd_yn== null) 
				allow_booking_with_edd_yn	= "N";
			allow_booking_with_edd_yn		= allow_booking_with_edd_yn.equals("Y") ?"checked" :"" ;


			future_booking_for_boc_yn		= rset.getString("future_booking_for_boc_yn");
			if(future_booking_for_boc_yn==null) 
				future_booking_for_boc_yn	= "N";
			future_booking_for_boc_yn		= future_booking_for_boc_yn.equals("Y") ?"checked" :"";


				
			no_of_days_before_for_boc		= rset.getString("no_of_days_before_for_boc");
			if(no_of_days_before_for_boc == null) 
				no_of_days_before_for_boc	= "";
			consider_edd_stop_for_boc_yn	= rset.getString("consider_edd_stop_for_boc_yn");
			if(consider_edd_stop_for_boc_yn==null) 
				consider_edd_stop_for_boc_yn= "N";
			consider_edd_stop_for_boc_yn	= consider_edd_stop_for_boc_yn.equals("Y") ? "checked" : "";

			action_for_boc					= rset.getString("action_for_boc");
			if(action_for_boc == null) action_for_boc="";
			if(action_for_boc.equals("W"))
				action_for_boc_w			= "selected";
			else
				action_for_boc_w			= "";
			if(action_for_boc.equals("S"))
				action_for_boc_s			= "selected";
			else
				action_for_boc_s			= "";

			future_booking_for_bou_yn		= rset.getString("future_booking_for_bou_yn");
			if(future_booking_for_bou_yn==null) 
				future_booking_for_bou_yn	= "N";
			future_booking_for_bou_yn		= future_booking_for_bou_yn.equals("Y") ?"checked" :"";

				
			no_of_days_before_for_bou		= rset.getString("no_of_days_before_for_bou");	
			if(no_of_days_before_for_bou == null) 
				no_of_days_before_for_bou	= "";
			consider_edd_stop_for_bou_yn	= rset.getString("consider_edd_stop_for_bou_yn");
			if(consider_edd_stop_for_bou_yn==null) 
				consider_edd_stop_for_bou_yn= "N";
			consider_edd_stop_for_bou_yn	= consider_edd_stop_for_bou_yn.equals("Y") ? "checked" : "";

			action_for_bou					= rset.getString("action_for_bou");
			if(action_for_bou == null) 
				action_for_bou				= "";
			if(action_for_bou.equals("W"))
				action_for_bou_w			= "selected";
			else
				action_for_bou_w			= "";
			if(action_for_bou.equals("S"))
				action_for_bou_s			= "selected";
			else
				action_for_bou_s			= "";

			future_booking_for_bnc_yn		= rset.getString("future_booking_for_bnc_yn");
			if(future_booking_for_bnc_yn==null) 
				future_booking_for_bnc_yn	= "N";
			future_booking_for_bnc_yn		= future_booking_for_bnc_yn.equals("Y") ?"checked" :"";

				
			no_of_days_before_for_bnc		= rset.getString("no_of_days_before_for_bnc");
			if(no_of_days_before_for_bnc == null) 
				no_of_days_before_for_bnc	= "";
			consider_edd_stop_for_bnc_yn	= rset.getString("consider_edd_stop_for_bnc_yn");
			if(consider_edd_stop_for_bnc_yn==null) 
				consider_edd_stop_for_bnc_yn= "N";
			consider_edd_stop_for_bnc_yn	= consider_edd_stop_for_bnc_yn.equals("Y") ? "checked" : "";

			action_for_bnc					= rset.getString("action_for_bnc");
			if(action_for_bnc == null) 
				action_for_bnc				= "";
			if(action_for_bnc.equals("W"))
				action_for_bnc_w			= "selected";
			else
				action_for_bnc_w			= "";

			if(action_for_bnc.equals("S"))
				action_for_bnc_s			= "selected";
			else
				action_for_bnc_s			= "";

			future_booking_for_bnu_yn		= rset.getString("future_booking_for_bnu_yn");
			if(future_booking_for_bnu_yn==null) 
				future_booking_for_bnu_yn	= "N";
			future_booking_for_bnu_yn		= future_booking_for_bnu_yn.equals("Y") ?"checked" :"";

				
			no_of_days_before_for_bnu		= rset.getString("no_of_days_before_for_bnu");
			if(no_of_days_before_for_bnu == null) 
				no_of_days_before_for_bnu	= "";
			consider_edd_stop_for_bnu_yn	= rset.getString("consider_edd_stop_for_bnu_yn");
			if(consider_edd_stop_for_bnu_yn==null) 
				consider_edd_stop_for_bnu_yn= "N";
			consider_edd_stop_for_bnu_yn	= consider_edd_stop_for_bnu_yn.equals("Y") ? "checked" : "";

			action_for_bnu					= rset.getString("action_for_bnu");

			if(action_for_bnu == null) action_for_bnu="";
			if(action_for_bnu.equals("W"))
				action_for_bnu_w			= "selected";
			else
				action_for_bnu_w			= "";

			if(action_for_bnu.equals("S"))
				action_for_bnu_s			= "selected";
			else
				action_for_bnu_s			= "";
		
			grc_prd_for_asgn_bed_mark_arvl	= rset.getString("grc_prd_for_asgn_bed_mark_arvl");
			if(grc_prd_for_asgn_bed_mark_arvl == null) 
				grc_prd_for_asgn_bed_mark_arvl="";

			 change_admission_dtls			= rset.getString("change_admission_dtls");
			if(change_admission_dtls == null) 
				change_admission_dtls		= "";

			display_discharge_pat_list		= rset.getString("display_discharge_pat_list");	
			if(display_discharge_pat_list == null) 
				display_discharge_pat_list	= "A";
				
		 /*Added by Senthil on 12-Dec-2011 for this CRF [KDAH-CRF-0035] */          
		  consenttxtdtls=checkForNull(rset.getString("consent_txt_dtls"));
		  
		  /*Below line Added for this CRF Bru-HIMS-CRF-354*/
		  	deft_pract_bedside_referral	= rset.getString("DFLT_PRACT_BEDSIDE_REFERRAL");
			if(deft_pract_bedside_referral == null)	deft_pract_bedside_referral= "";
			if(deft_pract_bedside_referral.equals("A"))
				deft_pract_bedside_referral_chk_a = "selected";
			if(deft_pract_bedside_referral.equals("L"))
				deft_pract_bedside_referral_chk_l = "selected";	
			//else
			//deft_pract_bedside_referral_chk	= "";			
			//else
			//	deft_pract_bedside_referral_chk			= "";		  
		  //End Bru-HIMS-CRF-354
		  
		  

		 /*Added by Shanthi for Bru-HIMS-CRF-157*/
		 	reason_for_late_discharge			= rset.getString("ALLOW_LATE_DISCHARGE_REASON");
			if(reason_for_late_discharge == null )
				reason_for_late_discharge	= "N";	
			
			discharge_reason_mandatory_yn=rset.getString("DISCH_REASON_MAND_YN");
			if (reason_for_late_discharge.equals("Y"))
			{
				reason_for_late_discharge="checked";
				if(discharge_reason_mandatory_yn.equals("Y"))
				{
					radio_check_mandatory_yn_1="checked";
				}
				else
				{
					radio_check_mandatory_yn_2="checked";
				}
			}
			else
			{
				reason_for_late_discharge="";
				mandatory_flag="disabled";
				non_mandatory_flag="disabled";
			}
			//Added for the CRF HSA-CRF-0035 - start
			transfer_wo_delink_yn=checkForNull(rset.getString("transfer_wo_delink_yn"),"N");
			if(transfer_wo_delink_yn.equals("Y"))
				transfer_wo_delink_checked="checked";
			//Added for the CRF HSA-CRF-0035 - End
			
			//Added for the CRF KDAH-CRF-0104  by Dharma - start
			pre_disch_appl_yn	= checkForNull(rset.getString("pre_disch_appl_yn"),"N");
			if(pre_disch_appl_yn.equals("Y"))
				pre_disch_appl_checked="checked";
			//Added for the CRF KDAH-CRF-0104  by Dharma - End
			
			//Added for MMS-QH-CRF-0144
			reason_for_adm_reqd_yn	= checkForNull(rset.getString("REASON_MANDATORY_FOR_ADMN_YN"),"N");
			if(reason_for_adm_reqd_yn.equals("Y"))
				reason_for_adm_reqd_checked="checked";	
           //Added for  HSA-CRF-146.1	  
			allow_muti_bedside_review_yn	= checkForNull(rset.getString("allow_muti_bedside_review_yn"),"N");
			if(allow_muti_bedside_review_yn.equals("Y"))allow_muti_bedside_review_checked="checked";
			//End HSA-CRF-146.1
			//Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362
			ca_record_referral_note_yn		= checkForNull(rset.getString("ca_record_referral_note_yn"),"N");
			if(ca_record_referral_note_yn.equals("Y"))ca_record_referral_note_yn_checked="checked";
			//Added by Rameswar on 29-Jan-16 for ML-MMOH-CRF-0362
			//Added by Kamatchi S for MOHE-CRF-0154
			allow_reg_referral_yn		= checkForNull(rset.getString("allow_reg_referral_yn"),"Y");
			if(allow_reg_referral_yn.equals("Y")) allow_reg_referral_yn_checked="checked";

			weight_on_admn_mandatory	= checkForNull(rset.getString("weight_on_admn_mandatory"));/*Added by Dharma on Oct 17th against HSA-CRF-0181 [IN:049541]*/
			//above line moved here for this incident HSA-SCF-0284 [IN:056842]
			chk_dis_pat_BT_order_pend=checkForNull(rset.getString("CHK_DIS_PAT_BT_ORDER_PEND"),"N");
			trans_yn_unfnzed_newborn = checkForNull(rset.getString("TRANS_YN_UNFNZED_NEWBORN"),"N");//Added by Dharma on 23rd May 2018 against ML-MMOH-CRF-0898 [IN:064757]
			admission_type=checkForNull(rset.getString("admission_type"),"");//Added by shanmukh on 31st-JULY-2018 for ML-MMOH-CRF-0618
			
			height_on_admn_mandatory	= checkForNull(rset.getString("height_on_admn_mandatory"));
			enable_height_bmi_pat_cls = checkForNull(rset.getString("enable_height_bmi_pat_cls"));
							}
		else
		{
			Disable_Enable_flg	= "";
			Readonly_flg		= "";
		}
			
			

	}

	session.putValue("consenttxtdtls",consenttxtdtls);
		if(rset!=null) rset.close();
		if(stmt!=null) stmt.close();

	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(no_of_days_before_for_boc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(consider_edd_stop_for_boc_yn));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(action_for_boc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(no_of_days_before_for_bou));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(consider_edd_stop_for_bou_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(action_for_bou));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(no_of_days_before_for_bnc));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(consider_edd_stop_for_bnc_yn));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(action_for_bnc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(no_of_days_before_for_bnu));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(consider_edd_stop_for_bnu_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(action_for_bnu));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

	/*if(unregistered_patients_bkg_yn==null||unregistered_patients_bkg_yn.equals(""))
		{
			Disable_Enable_flg	="";
			Readonly_flg	="";
		}
		else 
			if(unregistered_patients_bkg_yn.equals("checked"))
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg	="Readonly";
		}*/

		
		
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(unregistered_patients_bkg_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block26Bytes, _wl_block26);

/*if((bkg_grace_period.equals(null)||bkg_grace_period.equals("")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(bkg_grace_period));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

/*if(adv_bed_book_period_bkg.equals(null)||adv_bed_book_period_bkg.equals("0")||adv_bed_book_period_bkg.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(adv_bed_book_period_bkg));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
 String str3="",str4="";  if(chk_booking_limit_by.equals("1")) str3="selected"; else str4="selected";
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(str3));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(str4));
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

	
/*	if(adm_date_chk_days==null||adm_date_chk_days.equals("0")||adm_date_chk_days.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

	if(block_bed_based_on.equals("P")) 
		out.println("<script>document.forms[0].block_bed_based_on.value='P';</script>");
	else
		out.println("<script>document.forms[0].block_bed_based_on.value='E';</script>");

            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(multi_bkg_patient_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(rel_booked_bed_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(noshow_bkng_period));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
	if(bl_operational.equals("Y"))
	{	
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(disable_enable_cap_fin_dtl));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block59Bytes, _wl_block59);
	}
	else
	{	
            _bw.write(_wl_block60Bytes, _wl_block60);
	}	
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(allowed_booking_type));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(adm_date_chk_days));
            _bw.write(_wl_block67Bytes, _wl_block67);

		String stradm_date_chk_days_type_hours="";
		String stradm_date_chk_days_type_days="";
		if(adm_date_chk_days_type.equalsIgnoreCase("H")) stradm_date_chk_days_type_hours ="selected";
		else stradm_date_chk_days_type_days="selected" ;
		
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(stradm_date_chk_days_type_hours));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(stradm_date_chk_days_type_days));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
 
		String str1="",str2="",string3="",string4 ="";
		if(allowed_admission_type.equals("R")) 
			str1="selected"; 
		else if(allowed_admission_type.equals("B"))
			str2="selected"; 
		else if(allowed_admission_type.equals("D"))
			string3="selected"; 
		else if(allowed_admission_type.equals("Z"))
			string4="selected"; 
		
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(string3));
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(str2));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(string4));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(str1));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

/*if(vital_signs_battery_id.equals(null)||vital_signs_battery_id.equals("0")||vital_signs_battery_id.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

/*if(MAX_DISCH_PERIOD_FOR_DC.equals(null)||MAX_DISCH_PERIOD_FOR_DC.equals("0")||MAX_DISCH_PERIOD_FOR_DC.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(MAX_DISCH_PERIOD_FOR_DC));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(dis_date_chk_days));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block91Bytes, _wl_block91);
		
	if(dis_date_chk_days_unit.equals("H"))
	out.println("<option value='H' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels")+"</option>");
	else
	out.println("<option value='H'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.hours.label","common_labels")+"</option>");
	if(dis_date_chk_days_unit.equals("D"))
	out.println("<option value='D' selected>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels")+"</option>");
	else
	out.println("<option value='D'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels")+"</option>");

            _bw.write(_wl_block92Bytes, _wl_block92);

/*if(dis_date_chk_days==null||dis_date_chk_days.equals("0")||dis_date_chk_days.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block2Bytes, _wl_block2);

/*if(PRIORITY_APPLICABLE.equals("")||(PRIORITY_APPLICABLE==null)||PRIORITY_APPLICABLE.equals("null"))
	{
		Disable_Enable_flg	="";
		Readonly_flg	="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg	="Readonly";
	}*/


            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(invoke_adm_chkd));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(grc_prd_for_asgn_bed_mark_arvl));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(prioryn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

			String sel ="";
			stmt = con.createStatement();
			rset = stmt.executeQuery("select priority_code, ip_get_desc.ip_transfer_priority('"+facility_id+"',priority_code,'"+locale+"',2)short_desc from IP_TRANSFER_PRIORITY where facility_id='"+facility_id+"' and eff_status = 'E' order by 2");
			while(rset!=null && rset.next())
			{
				if(default_priority.equals(rset.getString(1)))
					sel = "selected";
				else
					sel = "";

					out.println("<option '"+sel+"' value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
			}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
			
		
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(default_priority));
            _bw.write(_wl_block105Bytes, _wl_block105);

	/*if(PAT_CHECK_IN_ALLOWED_YN.equals("")||PAT_CHECK_IN_ALLOWED_YN.equals(null))
		{
			Disable_Enable_flg	="";
			Readonly_flg	="";
		}
		else 
			if(PAT_CHECK_IN_ALLOWED_YN.equals("checked"))
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg	="Readonly";
		}*/
	
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(PAT_CHECK_IN_ALLOWED_YN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

	/*if(DEACTIVATE_PSEUDO_BED_YN.equals("")||DEACTIVATE_PSEUDO_BED_YN.equals(null))
	{
		Disable_Enable_flg	="";
		Readonly_flg	="";
	}
	else 
		if(DEACTIVATE_PSEUDO_BED_YN.equals("checked"))
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg	="Readonly";
	}*/
 
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(DEACTIVATE_PSEUDO_BED_YN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block111Bytes, _wl_block111);

	/*if(change_bed_class_yn.equals("")||change_bed_class_yn.equals(null))
		{
			Disable_Enable_flg	="";
			Readonly_flg	="";
		}
		else 
			if(change_bed_class_yn.equals("checked"))
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg	="Readonly";
		}*/
 
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(change_bed_class_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block114Bytes, _wl_block114);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block116Bytes, _wl_block116);

			StringBuffer sqlVital = new StringBuffer();
			sqlVital.append("select short_desc,discr_msr_id from am_discr_msr where eff_Status ='E' and result_type ='V' order by short_desc");	
			stmt	= con.createStatement();
			rset = stmt.executeQuery(sqlVital.toString());	
			while(rset!=null && rset.next())
				{	
					if(vital_signs_battery_id.equals(rset.getString(2)))
					out.println("<option selected value='"+rset.getString(2)+"'>"+rset.getString(1)+"</option>");
					else
					out.println("<option  value='"+rset.getString(2)+"'>"+rset.getString(1)+"</option>");
				}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
		
            _bw.write(_wl_block117Bytes, _wl_block117);

	/*if(discharge_checklist_app_yn.equals("")||discharge_checklist_app_yn.equals(null))
		{
			Disable_Enable_flg	="";
			Readonly_flg	="";
		}
		else 
			if(discharge_checklist_app_yn.equals("checked"))
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg	="Readonly";
		}*/

            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(discharge_checklist_app_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(DISC_CHKLST_EXP_PERIOD));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block122Bytes, _wl_block122);
 
		String dis_chklst_exp_hrs = "";
		String dis_chklst_exp_days  = "" ;

		if(DISC_CHKLST_EXP_PER_UNIT.equalsIgnoreCase("H"))
			dis_chklst_exp_hrs = "selected";
		else
			dis_chklst_exp_days = "selected";
	
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(dis_chklst_exp_hrs));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(dis_chklst_exp_days));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block127Bytes, _wl_block127);
 
		String display_discharge_pat_listA	= "";
		String display_discharge_pat_listD  = "" ;

		if(display_discharge_pat_list.equalsIgnoreCase("A"))
			display_discharge_pat_listA = "selected";
		else
			display_discharge_pat_listD = "selected";
	
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(display_discharge_pat_listA));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(display_discharge_pat_listD));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(chk_for_readmission));
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(chk_for_pen_orders_bfr_dis_adv));
            _bw.write(_wl_block135Bytes, _wl_block135);
  
		
		

		
            _bw.write(_wl_block136Bytes, _wl_block136);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(chk_for_pen_orders_bfr_dis_adv));
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(radio_flag_1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(radio_check_yn_1));
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(radio_flag_2));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(radio_check_yn_2));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
if(isRestrictDischargeAdvice){
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(chk_pen_ward_rtn_bfr_dis_adv));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(check_chk_pen_ward_rtn));
            _bw.write(_wl_block147Bytes, _wl_block147);
}
            _bw.write(_wl_block148Bytes, _wl_block148);
/*below line Added for this CRF [JD-CRF-0006]*/
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(chk_for_pen_orders_bfr_dis));
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(dis_notallow_chk));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dis_notallow_yn));
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(dis_allow_chk));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dis_allow_yn));
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
if(isDisPatBTorderPendAppl){
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
if(("Y").equals(chk_dis_pat_BT_order_pend)){
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block160Bytes, _wl_block160);
}
            _bw.write(_wl_block161Bytes, _wl_block161);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block164Bytes, _wl_block164);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block165Bytes, _wl_block165);
/*End CRF [JD-CRF-0006]*/
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);
            _bw.write(_wl_block25Bytes, _wl_block25);
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(reserve_bed_on_tfr_yn));
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(allow_multiple_bed_for_resv_yn));
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(res_reserve_bed_intraward_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(res_reserve_bed_intraward_disabled));
            _bw.write(_wl_block174Bytes, _wl_block174);
if(isRestrictDisAdvSaleRetPend){
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(dis_chk_pen_sale_rtn_bfr_dis_adv));
            _bw.write(_wl_block59Bytes, _wl_block59);
} else if(isModifyDiscTypeStatusAppl){
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(allow_user_modify_disc_type_status_yn));
            _bw.write(_wl_block178Bytes, _wl_block178);
}
            _bw.write(_wl_block179Bytes, _wl_block179);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(change_admission_dtls));
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(Allow_Invoke_Maintn_Dth_Reg_YN));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(death_reg_mandatory_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(death_reg_mandatory_yn_1));
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(death_reg_non_mandatory_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(death_reg_mandatory_yn_2));
            _bw.write(_wl_block187Bytes, _wl_block187);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block188Bytes, _wl_block188);
 /*Added by Senthil on 12-Dec-2011 for this CRF [KDAH-CRF-0035] */
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(consenttxtdtls));
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(chk_for_pen_orders_bfr_dis_adv));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(reason_for_late_discharge));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(mandatory_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(radio_check_mandatory_yn_1));
            _bw.write(_wl_block195Bytes, _wl_block195);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(non_mandatory_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(radio_check_mandatory_yn_2));
            _bw.write(_wl_block197Bytes, _wl_block197);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block198Bytes, _wl_block198);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(transfer_wo_delink_yn));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(transfer_wo_delink_checked));
            _bw.write(_wl_block200Bytes, _wl_block200);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(reason_for_adm_reqd_yn ));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(reason_for_adm_reqd_checked));
            _bw.write(_wl_block202Bytes, _wl_block202);
 if(SiteSpecific_pre_disch_appl){
            _bw.write(_wl_block203Bytes, _wl_block203);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(pre_disch_appl_yn ));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(pre_disch_appl_checked ));
            _bw.write(_wl_block205Bytes, _wl_block205);
}
            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(BED_MANDATORY_FOR_ADMN_YN));
            _bw.write(_wl_block208Bytes, _wl_block208);

		/*
		if(CANCEL_DISCHARGE_APPL_YN.equals("Y"))
		{
			CANCEL_DISCHARGE_APPL_YN = "checked";
		}
		else 
		{
			CANCEL_DISCHARGE_APPL_YN = "unchecked";
		}*/

            _bw.write(_wl_block209Bytes, _wl_block209);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block210Bytes, _wl_block210);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block211Bytes, _wl_block211);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block212Bytes, _wl_block212);
if(weight_on_admn_mandatory.equals("A")){
            _bw.write(_wl_block213Bytes, _wl_block213);
} 
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);
if(weight_on_admn_mandatory.equals("P")){
            _bw.write(_wl_block213Bytes, _wl_block213);
} 
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block215Bytes, _wl_block215);
if(weight_on_admn_mandatory.equals("D")){
            _bw.write(_wl_block213Bytes, _wl_block213);
} 
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);
if(isCnrmReqPatOutChngAppl){
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(autoCnrmTfrReq));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(chkAutoCnrmTfrReq));
            _bw.write(_wl_block219Bytes, _wl_block219);
}
            _bw.write(_wl_block220Bytes, _wl_block220);
if(isHeightAndBmiEnable){
            _bw.write(_wl_block221Bytes, _wl_block221);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block212Bytes, _wl_block212);
if(height_on_admn_mandatory.equals("A")){
            _bw.write(_wl_block213Bytes, _wl_block213);
} 
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);
if(height_on_admn_mandatory.equals("P")){
            _bw.write(_wl_block213Bytes, _wl_block213);
} 
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block215Bytes, _wl_block215);
if(height_on_admn_mandatory.equals("D")){
            _bw.write(_wl_block213Bytes, _wl_block213);
} 
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block224Bytes, _wl_block224);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block225Bytes, _wl_block225);
if(enable_height_bmi_pat_cls.equals("DC")){
            _bw.write(_wl_block213Bytes, _wl_block213);
} 
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block226Bytes, _wl_block226);
if(enable_height_bmi_pat_cls.equals("IP")){
            _bw.write(_wl_block213Bytes, _wl_block213);
} 
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block227Bytes, _wl_block227);
if(enable_height_bmi_pat_cls.equals("ID")){
            _bw.write(_wl_block213Bytes, _wl_block213);
} 
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block228Bytes, _wl_block228);
}
            _bw.write(_wl_block229Bytes, _wl_block229);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(dispBedClsChange));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(chkDispBedClsChange));
            _bw.write(_wl_block231Bytes, _wl_block231);
if(isNewBornChngsAppl){
            _bw.write(_wl_block232Bytes, _wl_block232);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);
if(("Y").equals(trans_yn_unfnzed_newborn)){
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block234Bytes, _wl_block234);
}
            _bw.write(_wl_block235Bytes, _wl_block235);
if(isAdmissionTypeAppl){
            _bw.write(_wl_block236Bytes, _wl_block236);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block238Bytes, _wl_block238);

			StringBuffer sqlAdmType = new StringBuffer();
			sqlAdmType.append("select admission_type_code,short_desc from ip_admission_type where eff_Status ='E' order by short_desc");	
			stmt	= con.createStatement();
			rset = stmt.executeQuery(sqlAdmType.toString());	
			while(rset!=null && rset.next())
				{	
					if(admission_type.equals(rset.getString(1)))
					out.println("<option selected value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
					else
					out.println("<option  value='"+rset.getString(1)+"'>"+rset.getString(2)+"</option>");
				}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
		
            _bw.write(_wl_block239Bytes, _wl_block239);
}
            _bw.write(_wl_block240Bytes, _wl_block240);

		if(isPatientEncRevokeDeathAppl)
		{ // Added by mujafar for ML-MMOH-CRF-1427
		
            _bw.write(_wl_block241Bytes, _wl_block241);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);

						                try{ 	
						
										  String sql1="select DISCHARGE_TYPE_CODE, short_desc from ip_discharge_type_vw where eff_status='E'   and DECEASED_YN = 'N' order by 2";
										  String selval= "";

										 stmt=con.createStatement();
										 rset=stmt.executeQuery(sql1);
										 if(rset!=null) {
										 String id1="";
										 String val1="";
										 
										 while(rset.next()) {
											 id1=rset.getString("DISCHARGE_TYPE_CODE");
											 val1=rset.getString("short_desc");
											 if(id1.equals(dispTypeForRevokeDeath))
											   selval="selected";
											 
											 out.print("<option value='"+id1+"' "+selval+">"+val1+"</option>");
											 selval="";
										 }
										 }
										 }catch(Exception e) { out.println(e.toString());e.printStackTrace();}
										 finally
										 {
											 if (stmt != null) stmt.close();
											 if (rset != null) rset.close();
										 }
				           
            _bw.write(_wl_block244Bytes, _wl_block244);
}
            _bw.write(_wl_block245Bytes, _wl_block245);
if(isNationalIdValidationAppl){
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(validate_natid_IP_admsn));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(validate_natid_chk));
            _bw.write(_wl_block248Bytes, _wl_block248);
}
            _bw.write(_wl_block249Bytes, _wl_block249);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block251Bytes, _wl_block251);
if(dis_adv_ot_pend_ord_yn.equals("Y")){
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block252Bytes, _wl_block252);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block253Bytes, _wl_block253);
if(dis_ot_pend_ord_yn.equals("Y")){
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block254Bytes, _wl_block254);

            if (_jsp__tag119(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(ALLOW_GATE_PASS_PRE_DIS_ADV_YN));
            _bw.write(_wl_block256Bytes, _wl_block256);

            if (_jsp__tag120(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(enable_disch_diagnosis_yn));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(enable_disch_chk));
            _bw.write(_wl_block258Bytes, _wl_block258);

            if (_jsp__tag121(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
	
/*if(bed_block_period_normal.equals("")||bed_block_period_normal.equals(null)||bed_block_period_normal.equals("0"))
		{	
			Disable_Enable_flg	="";
			Readonly_flg	="";
		}
		else 
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg	="Readonly";
		}*/

            _bw.write(_wl_block259Bytes, _wl_block259);

            if (_jsp__tag122(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(bed_block_period_normal));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block261Bytes, _wl_block261);

            if (_jsp__tag123(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block262Bytes, _wl_block262);

/*if((bed_block_period_max.equals(null)||bed_block_period_max.equals("")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block263Bytes, _wl_block263);

            if (_jsp__tag124(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(bed_block_period_max));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block265Bytes, _wl_block265);
 
					String bed_block_period_max_type_hours = "";
					String bed_block_period_max_type_days  = "" ;
					if(bed_block_period_max_type.equalsIgnoreCase("H"))
							bed_block_period_max_type_hours = "selected";
					else
							bed_block_period_max_type_days = "selected";
                
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(bed_block_period_max_type_hours));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag125(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(bed_block_period_max_type_days));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag126(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block269Bytes, _wl_block269);

/*if((bed_block_period_dis.equals(null)||bed_block_period_dis.equals("")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block270Bytes, _wl_block270);

            if (_jsp__tag127(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(bed_block_period_dis));
            _bw.write(_wl_block273Bytes, _wl_block273);

            if (_jsp__tag128(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block274Bytes, _wl_block274);

/*if((strTransfer_Out.equals(null)||strTransfer_Out.equals("")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block275Bytes, _wl_block275);

            if (_jsp__tag129(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(strTransfer_Out));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block277Bytes, _wl_block277);

            if (_jsp__tag130(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block278Bytes, _wl_block278);
/*
			String Priority2_date_chk_days_type_hours="";
			String Priority2_date_chk_days_type_days="";
			if(dflt_unit_priority_2.equalsIgnoreCase("H")) 
				Priority2_date_chk_days_type_hours ="selected";
			else 
				Priority2_date_chk_days_type_days="selected" ;
		
			String Priority3_date_chk_days_type_hours="";
			String Priority3_date_chk_days_type_days="";
			if(dflt_unit_priority_3.equalsIgnoreCase("H")) 
				Priority3_date_chk_days_type_hours ="selected";
			else 
				Priority3_date_chk_days_type_days="selected" ;
		*/
            _bw.write(_wl_block279Bytes, _wl_block279);

/*if((dflt_bed_blocking_period.equals(null)||dflt_bed_blocking_period.equals("")||dflt_bed_blocking_period.equals("0")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block280Bytes, _wl_block280);

            if (_jsp__tag131(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(dflt_bed_blocking_period));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block282Bytes, _wl_block282);

            if (_jsp__tag132(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block285Bytes, _wl_block285);

            if (_jsp__tag133(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block286Bytes, _wl_block286);

            if (_jsp__tag134(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block287Bytes, _wl_block287);

/*if(lodger_next_srl_no==null||lodger_next_srl_no.equals("0")||lodger_next_srl_no.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block290Bytes, _wl_block290);

            if (_jsp__tag135(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(lodger_next_srl_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block292Bytes, _wl_block292);

/*if(lodger_max_srl_no==null||lodger_max_srl_no.equals("0")||lodger_max_srl_no.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block293Bytes, _wl_block293);

            if (_jsp__tag136(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(lodger_max_srl_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block295Bytes, _wl_block295);

	/*	if(max_stay_of_lodger_after_disc.equals("")||max_stay_of_lodger_after_disc.equals(null))
		{
			Disable_Enable_flg	="";
			Readonly_flg		="";
		}
		else
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg		="Readonly";
		}
	*/

            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag137(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(max_stay_of_lodger_after_disc));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block297Bytes, _wl_block297);

            if (_jsp__tag138(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block298Bytes, _wl_block298);

		/*		
			if(DFLT_GATE.equals("")||DFLT_GATE.equals(null))
			{
				Disable_Enable_flg	="";
				Readonly_flg	="";
			}
			else
			{
				Disable_Enable_flg	="Disabled";
				Readonly_flg	="Readonly";
			}
		*/
		
            _bw.write(_wl_block299Bytes, _wl_block299);

            if (_jsp__tag139(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag140(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(DFLT_GATE));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block301Bytes, _wl_block301);
 
					String allow_prd_renew_hours = "";
					String allow_prd_renew_days  = "" ;
					
					if(bed_block_period_max_type1.equalsIgnoreCase("H"))
							allow_prd_renew_hours = "selected";
					else
							allow_prd_renew_days = "selected";
                
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(allow_prd_renew_hours));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag141(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(allow_prd_renew_days));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag142(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block303Bytes, _wl_block303);

/*if(MAX_ALLOWED_ACCOM_PERS==null||MAX_ALLOWED_ACCOM_PERS.equals("0")||MAX_ALLOWED_ACCOM_PERS.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block304Bytes, _wl_block304);

            if (_jsp__tag143(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(MAX_ALLOWED_ACCOM_PERS));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block306Bytes, _wl_block306);

	/*if(CHK_IN_LODGER_MAX_PERIOD==null||CHK_IN_LODGER_MAX_PERIOD.equals("0")||CHK_IN_LODGER_MAX_PERIOD.equals(""))
		{
			Disable_Enable_flg	="";
			Readonly_flg		="";
		}
		else
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg		="Readonly";
		}*/
	
            _bw.write(_wl_block307Bytes, _wl_block307);

            if (_jsp__tag144(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(CHK_IN_LODGER_MAX_PERIOD));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block309Bytes, _wl_block309);

            if (_jsp__tag145(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block310Bytes, _wl_block310);

		if(allow_release_bed_on_lv.equals("Y"))
		{	
			allow_release_bed_on_lv = "checked";
		}

		/*if(allow_release_bed_on_lv == null||allow_release_bed_on_lv.equals(""))
		{	
			allow_release_bed_on_lv = "";
			Disable_Enable_flg	="";
			Readonly_flg		="";
		}
		else
		if(allow_release_bed_on_lv.equals("Y"))
		{	
			allow_release_bed_on_lv = "checked";
			Disable_Enable_flg	="Disabled";
			Readonly_flg		="Readonly";
		}else
			if(allow_release_bed_on_lv.equals("N"))
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg		="Readonly";
		}*/

/*		out.println("Disable_Enable_flg"+Disable_Enable_flg);
		allow_release_bed_on_lv = allow_release_bed_on_lv.equals("Y") ?"checked" :"" ;
if(allow_release_bed_on_lv.equals("")||allow_release_bed_on_lv==null)
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	if(allow_release_bed_on_lv.equals("checked"))
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/


            _bw.write(_wl_block311Bytes, _wl_block311);

            if (_jsp__tag146(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block312Bytes, _wl_block312);

            if (_jsp__tag147(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(Disable_flg));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(allow_release_bed_on_lv));
            _bw.write(_wl_block315Bytes, _wl_block315);

/*if((max_allowed_lv_period.equals(null)||max_allowed_lv_period.equals("")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag148(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(max_allowed_lv_period));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block317Bytes, _wl_block317);

            if (_jsp__tag149(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block318Bytes, _wl_block318);

		stmt_pt_leave =con.createStatement();
		StringBuffer sql_pt_leave = new StringBuffer();
		sql_pt_leave.append(" SELECT short_desc,patient_type FROM am_patient_type WHERE eff_status='E' ORDER BY 1");
		rset_pt_leave = stmt_pt_leave.executeQuery(sql_pt_leave.toString());
	
            _bw.write(_wl_block319Bytes, _wl_block319);
      
	if(rset_pt_leave != null)
	{
			while(rset_pt_leave.next())
			{
					if(pat_type_override_leave_period.equalsIgnoreCase(rset_pt_leave.getString(2)))
					{
	
            _bw.write(_wl_block235Bytes, _wl_block235);

					}
					else
					{
	
            _bw.write(_wl_block235Bytes, _wl_block235);

					}
			}
	if(rset_pt_leave != null)rset_pt_leave.close();
	if(stmt_pt_leave != null)stmt_pt_leave.close();
	}
			
            _bw.write(_wl_block320Bytes, _wl_block320);

	/*if((max_allowed_lv_cancel_period.equals(null)||max_allowed_lv_cancel_period.equals("")))
		{
			Disable_Enable_flg	="";
			Readonly_flg		="";
		}
		else
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg		="Readonly";
		}*/
	
            _bw.write(_wl_block321Bytes, _wl_block321);

            if (_jsp__tag150(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(max_allowed_lv_cancel_period));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block323Bytes, _wl_block323);

            if (_jsp__tag151(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block324Bytes, _wl_block324);

/*if(ABSCOND_GRACE_PERIOD.equals(null)||ABSCOND_GRACE_PERIOD.equals("0")||ABSCOND_GRACE_PERIOD.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block325Bytes, _wl_block325);

            if (_jsp__tag152(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(ABSCOND_GRACE_PERIOD));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block327Bytes, _wl_block327);

            if (_jsp__tag153(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block328Bytes, _wl_block328);

/*if(NO_SHOW_GRACE_PERIOD.equals(null)||NO_SHOW_GRACE_PERIOD.equals("0")||NO_SHOW_GRACE_PERIOD.equals(""))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag154(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(NO_SHOW_GRACE_PERIOD));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(Readonly_flg));
            _bw.write(_wl_block330Bytes, _wl_block330);

            if (_jsp__tag155(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block331Bytes, _wl_block331);

		if (warn_or_error_max_leave.equals("W"))
		{
			action_warning_yn="checked";
			action_error_yn="";
			//Disable_Enable_flg	="Disabled";
			//Readonly_flg		="Readonly";
		}
		else if (warn_or_error_max_leave.equals("E"))
		{
			action_warning_yn="";
			action_error_yn="checked";
			//Disable_Enable_flg	="Disabled";
			//Readonly_flg		="Readonly";
		}
		else if (warn_or_error_max_leave.equals("")||warn_or_error_max_leave.equals(""))
		{
			action_warning_yn	="checked";	
			//Disable_Enable_flg	="";
			//Readonly_flg		="";
		}

	/*if((warn_or_error_max_leave.equals(null)||warn_or_error_max_leave.equals("")))
	{
		Disable_Enable_flg	="";
		Readonly_flg		="";
	}
	else
	{
	    Disable_Enable_flg	="Disabled";
		Readonly_flg		="Readonly";
	}*/

	
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag156(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(action_warning_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Disable_flg));
            _bw.write(_wl_block333Bytes, _wl_block333);

            if (_jsp__tag157(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(action_error_yn));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(Disable_flg));
            _bw.write(_wl_block333Bytes, _wl_block333);

            if (_jsp__tag158(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block336Bytes, _wl_block336);

if(action_warning_yn.equals("checked"))
		{
	
            _bw.write(_wl_block337Bytes, _wl_block337);

		}
	else
		if(action_error_yn.equals("checked"))
		{
	
            _bw.write(_wl_block338Bytes, _wl_block338);

		}
	
            _bw.write(_wl_block339Bytes, _wl_block339);
 
	if(bl_operational.equals("Y"))
	{ 
            _bw.write(_wl_block2Bytes, _wl_block2);

	/*if(bl_interfaced_yn.equals("")||bl_interfaced_yn.equals(null))
		{
			Disable_Enable_flg	="";
			Readonly_flg	="";
		}
		else 
			if(PAT_CHECK_IN_ALLOWED_YN.equals("checked"))
		{
			Disable_Enable_flg	="Disabled";
			Readonly_flg	="Readonly";
		}*/

            _bw.write(_wl_block340Bytes, _wl_block340);

            if (_jsp__tag159(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block341Bytes, _wl_block341);

            if (_jsp__tag160(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(Disable_Enable_flg));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(bl_fields));
            _bw.write(_wl_block343Bytes, _wl_block343);
}
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(lodger_next_srl_no));
            _bw.write(_wl_block346Bytes, _wl_block346);

            if (_jsp__tag161(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag162(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block347Bytes, _wl_block347);

            if (_jsp__tag163(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(allow_booking_without_edd_yn));
            _bw.write(_wl_block349Bytes, _wl_block349);

            if (_jsp__tag164(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(allow_booking_with_edd_yn));
            _bw.write(_wl_block351Bytes, _wl_block351);

            if (_jsp__tag165(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block352Bytes, _wl_block352);

            if (_jsp__tag166(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block353Bytes, _wl_block353);

            if (_jsp__tag167(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block352Bytes, _wl_block352);

            if (_jsp__tag168(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block354Bytes, _wl_block354);

            if (_jsp__tag169(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block355Bytes, _wl_block355);

            if (_jsp__tag170(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(future_booking_for_boc_yn));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(no_of_days_before_for_boc));
            _bw.write(_wl_block358Bytes, _wl_block358);

            if (_jsp__tag171(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(consider_edd_stop_for_boc_yn));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(action_for_boc_w));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag172(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(action_for_boc_s));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag173(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block362Bytes, _wl_block362);

            if (_jsp__tag174(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(future_booking_for_bou_yn));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(no_of_days_before_for_bou));
            _bw.write(_wl_block365Bytes, _wl_block365);

            if (_jsp__tag175(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(consider_edd_stop_for_bou_yn));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(action_for_bou_w));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag176(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(action_for_bou_s));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag177(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block368Bytes, _wl_block368);

            if (_jsp__tag178(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(future_booking_for_bnc_yn));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(no_of_days_before_for_bnc));
            _bw.write(_wl_block358Bytes, _wl_block358);

            if (_jsp__tag179(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(consider_edd_stop_for_bnc_yn));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(action_for_bnc_w));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag180(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(action_for_bnc_s));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag181(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block373Bytes, _wl_block373);

            if (_jsp__tag182(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(future_booking_for_bnu_yn));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(no_of_days_before_for_bnu));
            _bw.write(_wl_block358Bytes, _wl_block358);

            if (_jsp__tag183(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(consider_edd_stop_for_bnu_yn));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(action_for_bnu_w));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag184(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(action_for_bnu_s));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag185(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block378Bytes, _wl_block378);

            if (_jsp__tag186(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block379Bytes, _wl_block379);

            if (_jsp__tag187(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(deft_pract_bedside_referral_chk_a));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag188(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(deft_pract_bedside_referral_chk_l));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag189(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block382Bytes, _wl_block382);

            if (_jsp__tag190(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(allow_muti_bedside_review_yn));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(allow_muti_bedside_review_checked));
            _bw.write(_wl_block385Bytes, _wl_block385);

            if (_jsp__tag191(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(ca_record_referral_note_yn));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(ca_record_referral_note_yn_checked));
            _bw.write(_wl_block387Bytes, _wl_block387);

            if (_jsp__tag192(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(allow_reg_referral_yn));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(allow_reg_referral_yn_checked));
            _bw.write(_wl_block389Bytes, _wl_block389);
		
		if(warn_or_error_max_leave!=null && warn_or_error_max_leave.equals("W")){

            _bw.write(_wl_block390Bytes, _wl_block390);
		}else{

            _bw.write(_wl_block391Bytes, _wl_block391);
		}


            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(isRestrictDischargeAdvice));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(isNationalIdValidationAppl));
            _bw.write(_wl_block394Bytes, _wl_block394);

		if(stmt	!= null) stmt.close();
		if(stmt_pt_leave != null)stmt_pt_leave.close();
		if(rset_pt_leave != null)rset_pt_leave.close();
		if(rset		!= null)rset.close();
		//session.invalidate();
		//session.removeAttribute("bl_operational");
	}
	catch(Exception e)
	{
		out.println(e);
		e.printStackTrace() ;
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	
            _bw.write(_wl_block395Bytes, _wl_block395);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Additional.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowBookingforUnregisteredPatients.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.GracePeriodforRevisionofBooking.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MaxAllowablePeriodforAdvanceBedBooking.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CheckBookingLimitBasedon.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.NursingUnitBedClass.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AgeGroupBedClass.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowedBooking.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Direct.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referral.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BlockBedBasedon.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PrefAdmDateTime.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpectedDischargeDateTime.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MultipleBookingforPatients.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReleaseBookedBedForAdmission.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DisplayNoShowstatusinConfirmBookingAfter.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minutes.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CaptureFinancialDetails.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Discharge.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Transfer.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MaxAllowableBackdatedAdmission.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowedAdmission.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Direct.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingorReferral.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referral.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.InvokeAdmFromNewBornReg.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MaxDischargePeriodforDayCare.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MaxAllowableBackdatedDischarge.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.InvokeAdmFromNewBornReg.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.GrcprdforAsgnBed.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PriorityApplicable.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowPatientCheckin.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DeactivatePseudoBed.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RequestforBedClassChange.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VitalSignsBattery.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeCheckListApplicable.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeChecklistExpiryPeriod.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DsplyDisPatLst.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllPatients.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.OnlyPatPDA.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AlertReadmitPatient.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CheckForPendingOrdersBerforeDischargeAdvice.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CheckForPendingOrdersBerforeDischargeAdvice.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.IfOrdersArePending.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DonotallowdischargeAdvice.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowDischargeAdvice.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RestrictDischargeAdviceForPendingReturns.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CheckForPendingOrdersBerforeDischarge.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.IfOrdersArePending.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Donotallowdischarge.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowDischarge.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RestrictDischargePatientIfBTOrdersPending.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CheckForPendingOrdersBerforeDischarge.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.IfOrdersArePending.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Donotallowdischarge.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowDischarge.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ExternalInterfaceforPrivilege.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReserveBedWhileTransfer.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowMultipleBedsForReserving.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RestrictReserveBedinIntraWardTrnsfr.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RestrictDischargeAdviceIfSaleReturnPending.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowUserToModifyDischargeTypeStatus.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.ChangeAdmDtls.label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.InvokeDthReginDisAdv.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Mandatory.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.NotMandatory.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admission.label", java.lang.String .class,"key"));
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
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ConsentText.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowReasonForLateDischarge.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Mandatory.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.NotMandatory.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TransferWODelink.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonForAdmMandatory.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PreDischargeApplicable.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedMandForAdmn.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CancelDischargeApplicable.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.WeightOnAdmission.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mandatory.label", java.lang.String .class,"key"));
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
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.assignbedmarkpatientarrival.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PrepareDischargeAdvice.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DischargePatient.label", java.lang.String .class,"key"));
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
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AutoCnrmTfrReq.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.HeightOnAdmission.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Mandatory.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.assignbedmarkpatientarrival.label", java.lang.String .class,"key"));
        __tag101.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PrepareDischargeAdvice.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DischargePatient.label", java.lang.String .class,"key"));
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
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.EnableHeightandBmiforPatienClass.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.daycare.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.inpatient.label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DaycareandInpatient.label", java.lang.String .class,"key"));
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
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DispBedClsChangeRec.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RestrictTransferForUnfinalizedNewbornRecords.label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.admissiontype.label", java.lang.String .class,"key"));
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
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag112.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOP.DispTypeFOrOPEncounterRevokeDeath.label", java.lang.String .class,"key"));
        __tag113.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${op_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag114.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ValidateNatIDDurIPAdmsn.label", java.lang.String .class,"key"));
        __tag115.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RestrictIfOTRecordsPending.label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PrepareDischargeAdvice.label", java.lang.String .class,"key"));
        __tag117.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Discharge.label", java.lang.String .class,"key"));
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
        __tag119.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Allowgatepassinpredisadvice.label", java.lang.String .class,"key"));
        __tag119.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag120.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.EnableDischargeDiagInPrepareDischargeAdvice.label", java.lang.String .class,"key"));
        __tag120.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag121.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedBlocking.label", java.lang.String .class,"key"));
        __tag121.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag122.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DefaultPeriodforNormal.label", java.lang.String .class,"key"));
        __tag122.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag123.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag124.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MaxAllowablePeriodforNormal.label", java.lang.String .class,"key"));
        __tag124.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag125.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag125.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag126.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag127.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MaxAllowablePeriodforDischarge.label", java.lang.String .class,"key"));
        __tag127.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag128.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag129.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MaxAllowablePeriodforTransferOut.label", java.lang.String .class,"key"));
        __tag129.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag130.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag130.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag131.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DefaultBedBlockingPeriodonTransferDischargeofInfectiousDiseasePatients.label", java.lang.String .class,"key"));
        __tag131.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag132.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag133.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Additional.label", java.lang.String .class,"key"));
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
        __tag134.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.LodgerAccompanyingPersonReference.label", java.lang.String .class,"key"));
        __tag134.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag135.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nextsrlno.label", java.lang.String .class,"key"));
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
        __tag136.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.maxserialno.label", java.lang.String .class,"key"));
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
        __tag137.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MaxAllowedPeriodofStayforLodgerAccompanyingPerson.label", java.lang.String .class,"key"));
        __tag137.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag138.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag139.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowablePeriodforIssue.label", java.lang.String .class,"key"));
        __tag139.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag140.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RenewalOfGatePass.label", java.lang.String .class,"key"));
        __tag140.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag141.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag142.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag143.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MaxAllowedAccompanyingPersons.label", java.lang.String .class,"key"));
        __tag143.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag144.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MaxPeriodafterDischargeforCheckinLodger.label", java.lang.String .class,"key"));
        __tag144.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag145.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag145.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag146.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Leave.label", java.lang.String .class,"key"));
        __tag146.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag147.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReleaseBedonLeave.label", java.lang.String .class,"key"));
        __tag147.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag148.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MaxAllowableLeavePeriod.label", java.lang.String .class,"key"));
        __tag148.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag149.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag150.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowLeaveCancellationWithin.label", java.lang.String .class,"key"));
        __tag150.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag151.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute.label", java.lang.String .class,"key"));
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
        __tag152.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.GraceperiodforAbscondPatient.label", java.lang.String .class,"key"));
        __tag152.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag153.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag154.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.GraceperiodforNoShow.label", java.lang.String .class,"key"));
        __tag154.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag155.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag156.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ActiononExceedingMaxLeave.label", java.lang.String .class,"key"));
        __tag156.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag157.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Warning.label", java.lang.String .class,"key"));
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
        __tag158.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Error.label", java.lang.String .class,"key"));
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
        __tag159.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Billing.label", java.lang.String .class,"key"));
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
        __tag160.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.InterfacetoBillingModule.label", java.lang.String .class,"key"));
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
        __tag161.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedAvailabilityChart.label", java.lang.String .class,"key"));
        __tag161.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag162.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.setup.label", java.lang.String .class,"key"));
        __tag162.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag163.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowBookingoccupiedbedswithoutEDD.label", java.lang.String .class,"key"));
        __tag163.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag164.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowBookingoccupiedbedswithEDD.label", java.lang.String .class,"key"));
        __tag164.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag165.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.TypeOfBooking.label", java.lang.String .class,"key"));
        __tag165.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag166.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.IndicateFutureBooking.label", java.lang.String .class,"key"));
        __tag166.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag167.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.NumberofdaysBefore.label", java.lang.String .class,"key"));
        __tag167.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag168.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ConsiderEDDBeforeStop.label", java.lang.String .class,"key"));
        __tag168.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag169.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ActiononBookingadmission.label", java.lang.String .class,"key"));
        __tag169.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag170.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookedOverrideableConfirmed.label", java.lang.String .class,"key"));
        __tag170.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag171.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag172.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Warn.label", java.lang.String .class,"key"));
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
        __tag173.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stop.label", java.lang.String .class,"key"));
        __tag173.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag174.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookedOverrideableUnConfirmed.label", java.lang.String .class,"key"));
        __tag174.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag175.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
        __tag175.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag176.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Warn.label", java.lang.String .class,"key"));
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
        __tag177.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stop.label", java.lang.String .class,"key"));
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

    private boolean _jsp__tag178(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag178 = null ;
        int __result__tag178 = 0 ;

        if (__tag178 == null ){
            __tag178 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag178);
        }
        __tag178.setPageContext(pageContext);
        __tag178.setParent(null);
        __tag178.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookedNonOverrideableConfirmed.label", java.lang.String .class,"key"));
        __tag178.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag178;
        __result__tag178 = __tag178.doStartTag();

        if (__result__tag178!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag178== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag178.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag178);
            return true;
        }
        _activeTag=__tag178.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag178);
        __tag178.release();
        return false;
    }

    private boolean _jsp__tag179(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag179 = null ;
        int __result__tag179 = 0 ;

        if (__tag179 == null ){
            __tag179 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag179);
        }
        __tag179.setPageContext(pageContext);
        __tag179.setParent(null);
        __tag179.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
        __tag179.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag179;
        __result__tag179 = __tag179.doStartTag();

        if (__result__tag179!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag179== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag179.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag179);
            return true;
        }
        _activeTag=__tag179.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag179);
        __tag179.release();
        return false;
    }

    private boolean _jsp__tag180(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag180 = null ;
        int __result__tag180 = 0 ;

        if (__tag180 == null ){
            __tag180 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag180);
        }
        __tag180.setPageContext(pageContext);
        __tag180.setParent(null);
        __tag180.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Warn.label", java.lang.String .class,"key"));
        __tag180.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag180;
        __result__tag180 = __tag180.doStartTag();

        if (__result__tag180!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag180== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag180.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag180);
            return true;
        }
        _activeTag=__tag180.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag180);
        __tag180.release();
        return false;
    }

    private boolean _jsp__tag181(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag181 = null ;
        int __result__tag181 = 0 ;

        if (__tag181 == null ){
            __tag181 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag181);
        }
        __tag181.setPageContext(pageContext);
        __tag181.setParent(null);
        __tag181.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stop.label", java.lang.String .class,"key"));
        __tag181.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag181;
        __result__tag181 = __tag181.doStartTag();

        if (__result__tag181!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag181== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag181.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag181);
            return true;
        }
        _activeTag=__tag181.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag181);
        __tag181.release();
        return false;
    }

    private boolean _jsp__tag182(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag182 = null ;
        int __result__tag182 = 0 ;

        if (__tag182 == null ){
            __tag182 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag182);
        }
        __tag182.setPageContext(pageContext);
        __tag182.setParent(null);
        __tag182.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookedNonOverrideableUnConfirmed.label", java.lang.String .class,"key"));
        __tag182.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag182;
        __result__tag182 = __tag182.doStartTag();

        if (__result__tag182!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag182== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag182.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag182);
            return true;
        }
        _activeTag=__tag182.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag182);
        __tag182.release();
        return false;
    }

    private boolean _jsp__tag183(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag183 = null ;
        int __result__tag183 = 0 ;

        if (__tag183 == null ){
            __tag183 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag183);
        }
        __tag183.setPageContext(pageContext);
        __tag183.setParent(null);
        __tag183.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
        __tag183.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag183;
        __result__tag183 = __tag183.doStartTag();

        if (__result__tag183!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag183== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag183.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag183);
            return true;
        }
        _activeTag=__tag183.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag183);
        __tag183.release();
        return false;
    }

    private boolean _jsp__tag184(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag184 = null ;
        int __result__tag184 = 0 ;

        if (__tag184 == null ){
            __tag184 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag184);
        }
        __tag184.setPageContext(pageContext);
        __tag184.setParent(null);
        __tag184.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Warn.label", java.lang.String .class,"key"));
        __tag184.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag184;
        __result__tag184 = __tag184.doStartTag();

        if (__result__tag184!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag184== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag184.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag184);
            return true;
        }
        _activeTag=__tag184.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag184);
        __tag184.release();
        return false;
    }

    private boolean _jsp__tag185(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag185 = null ;
        int __result__tag185 = 0 ;

        if (__tag185 == null ){
            __tag185 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag185);
        }
        __tag185.setPageContext(pageContext);
        __tag185.setParent(null);
        __tag185.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stop.label", java.lang.String .class,"key"));
        __tag185.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag185;
        __result__tag185 = __tag185.doStartTag();

        if (__result__tag185!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag185== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag185.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag185);
            return true;
        }
        _activeTag=__tag185.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag185);
        __tag185.release();
        return false;
    }

    private boolean _jsp__tag186(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag186 = null ;
        int __result__tag186 = 0 ;

        if (__tag186 == null ){
            __tag186 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag186);
        }
        __tag186.setPageContext(pageContext);
        __tag186.setParent(null);
        __tag186.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.GeneralDetails.label", java.lang.String .class,"key"));
        __tag186.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag186;
        __result__tag186 = __tag186.doStartTag();

        if (__result__tag186!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag186== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag186.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag186);
            return true;
        }
        _activeTag=__tag186.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag186);
        __tag186.release();
        return false;
    }

    private boolean _jsp__tag187(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag187 = null ;
        int __result__tag187 = 0 ;

        if (__tag187 == null ){
            __tag187 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag187);
        }
        __tag187.setPageContext(pageContext);
        __tag187.setParent(null);
        __tag187.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DefaultReferringPractitioner.label", java.lang.String .class,"key"));
        __tag187.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag187;
        __result__tag187 = __tag187.doStartTag();

        if (__result__tag187!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag187== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag187.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag187);
            return true;
        }
        _activeTag=__tag187.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag187);
        __tag187.release();
        return false;
    }

    private boolean _jsp__tag188(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag188 = null ;
        int __result__tag188 = 0 ;

        if (__tag188 == null ){
            __tag188 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag188);
        }
        __tag188.setPageContext(pageContext);
        __tag188.setParent(null);
        __tag188.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag188.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag188;
        __result__tag188 = __tag188.doStartTag();

        if (__result__tag188!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag188== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag188.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag188);
            return true;
        }
        _activeTag=__tag188.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag188);
        __tag188.release();
        return false;
    }

    private boolean _jsp__tag189(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag189 = null ;
        int __result__tag189 = 0 ;

        if (__tag189 == null ){
            __tag189 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag189);
        }
        __tag189.setPageContext(pageContext);
        __tag189.setParent(null);
        __tag189.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.LoginPractitioner.label", java.lang.String .class,"key"));
        __tag189.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag189;
        __result__tag189 = __tag189.doStartTag();

        if (__result__tag189!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag189== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag189.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag189);
            return true;
        }
        _activeTag=__tag189.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag189);
        __tag189.release();
        return false;
    }

    private boolean _jsp__tag190(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag190 = null ;
        int __result__tag190 = 0 ;

        if (__tag190 == null ){
            __tag190 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag190);
        }
        __tag190.setPageContext(pageContext);
        __tag190.setParent(null);
        __tag190.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowMultipleBedsideReview.label", java.lang.String .class,"key"));
        __tag190.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag190;
        __result__tag190 = __tag190.doStartTag();

        if (__result__tag190!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag190== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag190.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag190);
            return true;
        }
        _activeTag=__tag190.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag190);
        __tag190.release();
        return false;
    }

    private boolean _jsp__tag191(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag191 = null ;
        int __result__tag191 = 0 ;

        if (__tag191 == null ){
            __tag191 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag191);
        }
        __tag191.setPageContext(pageContext);
        __tag191.setParent(null);
        __tag191.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.EnableRecordingofReferralLetterNotewithReferralRequest.label", java.lang.String .class,"key"));
        __tag191.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag191;
        __result__tag191 = __tag191.doStartTag();

        if (__result__tag191!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag191== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag191.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag191);
            return true;
        }
        _activeTag=__tag191.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag191);
        __tag191.release();
        return false;
    }

    private boolean _jsp__tag192(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag192 = null ;
        int __result__tag192 = 0 ;

        if (__tag192 == null ){
            __tag192 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag192);
        }
        __tag192.setPageContext(pageContext);
        __tag192.setParent(null);
        __tag192.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AllowRegOfNewRefInIPAdmFunc.label", java.lang.String .class,"key"));
        __tag192.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag192;
        __result__tag192 = __tag192.doStartTag();

        if (__result__tag192!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag192== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag192.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag192);
            return true;
        }
        _activeTag=__tag192.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag192);
        __tag192.release();
        return false;
    }
}
