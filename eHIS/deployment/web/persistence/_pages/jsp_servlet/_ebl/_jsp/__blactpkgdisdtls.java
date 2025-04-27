package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.pkgpricerevision.bc.PkgPriceDisountBC;
import java.util.*;
import com.ehis.util.*;

public final class __blactpkgdisdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLActPkgDisDtls.jsp", 1737915443836L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title></title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script language=\'javascript\' src=\'../../eBL/js/PkgBulkUpdate.js\'></script>\n\t<script language=\"javascript\" src=\"../../eBL/js/BLPatientEncounters.js\"></script>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\t\n\t\t\n\t\n\t<script type=\"text/javascript\">\n\n\tfunction showCalendar_loc(Val1, Val2)\n\t{\t\n\t\t\n\t\tif (Val2.disabled == true)\t\t\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn showCalendar(Val1,null,null);\n\t\t}\n\t}\n\t\n\tfunction checkDateBL(entered_date)\n\t{\n\t\t\n\tvar locale=document.forms[0].locale.value;\n\tif(entered_date.value!=\"\")\n\t{\n\t\tif(validDate(entered_date.value,\'DMY\',locale))\n\t\t{\n\t\t\treturn true;\n\t\t}\n\t\telse\n\t\t{\t\n\t\t\talert(getMessage(\"INVALID_DATE_FMT\",\"SM\"));\n\t\t\tentered_date.select();\n\t\t\treturn false;\n\t\t}\n\t}\n\telse\n\t{\n\t\treturn true;\n\t}\n}\n\t\n\tfunction call_date_less_equal_chk(obj)\n\t{\t\n\t\tif(!(obj.value==\"\"))\n\t\t{\n\t\t\tvar locale=document.forms[0].locale.value;\n\t\t\tvar sysdate=getCurrentDate(\'DMY\',locale);\n\t\t\tif(chkDtLessEqualThanSysDateNew(obj,sysdate))\n\t\t\t{\t\t\n\t\t\t\treturn true;\n\t\t\t}\n\t\t\telse\n\t\t\t{\t\t\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\t\n\t\t\treturn false;\n\t\t}\n\t}\t\n\n\tfunction toFromDateChk(obj)\n\t{\n\t\tif(!(obj.value==\"\"))\n\t\t{\t\t\n\t\t\tvar effFromDt = document.forms[0].encounter_from_date.value;\n\t\t\tvar effToDt = document.forms[0].encounter_to_date.value;\n\t\t\tif(checkDateBL(obj))\n\t\t\t{\n\t\t\t\tvar locale=document.forms[0].locale.value;\t\t\t\n\t\t\t\tif((!isBefore(effFromDt,effToDt,\'DMY\',locale)))\n\t\t\t\t{\t\t\n\t\t\t\t\talert(getMessage(\"BL4115\",\'BL\'));\n\t\t\t\t\tobj.select();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\t\t\t\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\treturn false;\n\t\t}\n\t}\n\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t\n\t<script>\n\t\n\n\n\t$(document).ready(function(){\n\t\t\n\t\t$(\"input[type=\'text\']\").keydown(function(e){\n\t\t\tif (e.which === 8 && !$(e.target).is(\"input[type=\'text\']:not([readonly])\")) {\n\t\t\t\te.preventDefault();\n\t\t    }\n\t\t});\n\t\t\n\t\t$(\'#priceType\').change(function(){\n\t\t\tvar priceType = $(this).val();\n\t\t\tif(priceType == \'C\'){\n\t\t\t\t$(\'#tdCustgrpLbl\').show();\t\t\t\n\t\t\t\t$(\'#tdCustgrpData\').show();\n\t\t\t\t$(\'#tdCustLbl\').show();\t\t\t\n\t\t\t\t$(\'#tdCustData\').show();\n\t\t\t\t$(\'#tdSearchBtn\').attr(\'colspan\',\'1\');\n\t\t\t}\n\t\t\telse if(priceType == \'S\'){\n\t\t\t\t$(\'#tdCustgrpLbl\').hide();\t\t\t\n\t\t\t\t$(\'#tdCustgrpData\').hide();\n\t\t\t\t$(\'#tdCustLbl\').hide();\t\t\t\n\t\t\t\t$(\'#tdCustData\').hide();\n\t\t\t\t$(\'#tdSearchBtn\').attr(\'colspan\',\'5\');\n\t\t\t}\n\t\t\t\n\t\t\t//loadFrames();\n\t\t});\n\t\t\n\t\t$(\'#updateType\').change(function(){\n\t\t\tif($(this).val() == \'B\'){\n\t\t\t\t$(\'#pkgCode\').val(\'**\');\n\t\t\t\t$(\'#pkgDesc\').val(\'All Package\');\n\t\t\t\t$(\'#pkgCode\').prop(\'readonly\',true);\n\t\t\t\t$(\'#pkgDesc\').prop(\'readonly\',true);\n\t\t\t\t$(\'#pkgBtn\').prop(\'disabled\',true);\n\t\t\t}\n\t\t\telse if($(this).val() == \'P\'){\n\t\t\t\tif($(\'#pkgCode\').val() == \'**\'){\n\t\t\t\t\t$(\'#pkgCode\').val(\'\');\n\t\t\t\t\t$(\'#pkgDesc\').val(\'\');\n\t\t\t\t}\n\t\t\t\t$(\'#pkgCode\').prop(\'readonly\',false);\n\t\t\t\t$(\'#pkgDesc\').prop(\'readonly\',false);\n\t\t\t\t$(\'#pkgBtn\').prop(\'disabled\',false);\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#pkgCode\').val(\'\');\n\t\t\t\t$(\'#pkgDesc\').val(\'\');\n\t\t\t\t$(\'#pkgCode\').prop(\'readonly\',false);\n\t\t\t\t$(\'#pkgDesc\').prop(\'readonly\',false);\n\t\t\t\t$(\'#pkgBtn\').prop(\'disabled\',false);\n\t\t\t}\n\t\t});\n\t\t\n\t\t$(\'#resetBtn\').click(function(){\n\t\t\t$(\'input:text\').val(\'\');\n\t\t\t$(\'select\').val(\'\');\n\t\t\t$(\'#updateType\').change();\n\t\t});\n\t\t\n\t\t$(\'#searchBtn\').click(function(){\t\t\t\n\t\t\tif($(\'#priceType\').val() == \'\'){\n\t\t\t\talert(\'Please choose standard price / customer price\');\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tif($(\'#updateType\').val() == \'\'){\n\t\t\t\talert(\'Please choose Package price / Bulk update\');\n\t\t\t\treturn false;\n\t\t\t}\n\t/*\t\tif($(\'#pkgCode\').val() == \'\'){\n\t\t\t\talert(\'Package Code is Mandatory\');\n\t\t\t\treturn false;\n\t\t\t}\n*/\n\t\t\n\n\t\t});\n\t\t\n\t\t$(\'td\').each(function(){\n\t\t\t$(this).css(\'padding-bottom\',\'5px\');\n\t\t});\n\t\t\n\t\t\n\t});\n\t\n\tfunction funQry()\n\t{\t\t\n\t\tvar mainfrmObj=\"\";\n\t\tmainfrmObj=parent.frames[0].searchFrm;\n\t\tvar Package= getLabel(\"Common.Package.label\", \"common\");\n\t\tvar BillingGroup = getLabel(\"eBL.BillingGroup.label\", \"bl\");\n\t\tvar Customer = getLabel(\"eBL.Customer.label\", \"bl\");\n\t\tvar POLICY = getLabel(\"eBL.POLICY.label\", \"bl\");\n\t\tvar EffectiveFrom = getLabel(\"eBL.EffectiveFrom.Label\", \"bl\");\n\t\tvar fieldsTop = new Array(mainfrmObj.blngGrpCode,mainfrmObj.custCode,mainfrmObj.ppGrpCode,mainfrmObj.pkgCode,mainfrmObj.encounter_from_date);\n\t\tvar namesTop = new Array(BillingGroup,Customer,POLICY,Package,EffectiveFrom);\n\t\tvar msgFrame;\n\t\tvar msgFrame = parent.frames[2];\n\t\tvar  result=checkFieldsofMst(fieldsTop, namesTop, msgFrame)\n          if(result)\n        \t{ \n\t\t//added against the ICN no:73412 mms-qh-128.1\n       \t\tparent.frames[2].location.href=\'../../eCommon/html/blank.html\';\n\t\tvar custGrpCode=document.getElementById(\"custGrpCode\").value;\n\t\tvar blng_class_code=document.getElementById(\"blngGrpCode\").value;  //28.8.2020 CHANGED\n\t\tvar custCode=document.getElementById(\"custCode\").value; //28.8.2020 CHANGED\n\t\t//var pkgDesc=document.getElementById(\"pkgDesc\").value;\n\t\tvar pkgCode=document.getElementById(\"pkgCode\").value; //28.8.2020 CHANGED\n\t\tvar ppGrpCode=document.getElementById(\"ppGrpcode\").value; //28.8.2020 CHANGED\n\t\tvar eff_from_date=document.getElementById(\"encounter_from_date\").value; //28.8.2020 CHANGED\n\t\tvar eff_to_date=document.getElementById(\"encounter_to_date\").value; //28.8.2020 CHANGED\n\t\t//added against inc 77403 FOR MMS-QH-CRF-128.1\n\t\t\n\t\t//20.8.2020 CHANGED one parameter\n\t\t\n\t\t//28.8.2020 add  one parameter encounter_to_date\n\t\tparent.summarydetail1.location.href=\"../../eBL/jsp/BLAdvPackDiscSrcDtlsFrame.jsp?packageCode=\"+pkgCode+\"&blng_class_code=\"+blng_class_code+\"&custCode=\"+custCode+\"&ppGrpCode=\"+ppGrpCode+\"&eff_from_date=\"+eff_from_date+\"&eff_to_date=\"+eff_to_date+\"&custGrpCode=\"+custGrpCode;  \n\t\t//parent.frames[1].location.href=\"../../eBL/jsp/BLViewActPakDtl.jsp?sel_patient_id=\"+patient_id+\"&sel_episode_type=\"+episode_type+\"&sel_episode_id=\"+episode_id+\"&sel_visit_id=\"+visit_id+\"&sel_encounter_from_date=\"+encounter_from_date+\"&sel_encounter_to_date=\"+encounter_to_date+\"&sel_ward_clinic_code=\"+ward_clinic_code+\"&\"+params;\n\t}\n\t}\n\n\t\n\t</script>\n\t\n\t\n\t\n</head>\n<body  onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \tonSelect=\"codeArrestThruSelect();\">\n\t<form name=\'searchFrm\' id=\'searchFrm\' id=\'searchFrm\' >\n\t<table  width=\"100%\" align=\"center\" cellpadding=3 cellspacing=0>\n\t\t\t<tr  >\n\t\t\t\t<td  class=\'COLUMNHEADER\' nowrap ><CENTER>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</CENTER></td>\n\t\t\t</tr>\n\t</table>\n\t\t<table id=\'searchTbl\' name=\'searchTbl\' id=\'searchTbl\' width=\"90%\" align=\"center\" cellpadding=3 cellspacing=0>\n\t\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td style=\"padding-top: 10px;\" width=\"10%\" nowrap>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"10%\" nowrap class=\'label\' style=\"text-align: left;\" id=\'tdCustgrpLbl\'>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t</td>\n\t\t\t\t<!-- Changed for the ICN:73403 14/7/2020 -->\n\t\t\t\t<td width=\"10%\" nowrap class=\'fields\' style=\"text-align: left;\" id=\'tdCustgrpData\'>\n\t\t\t\t\t<input type=\'text\' name=\'custGrpCode\' id=\'custGrpCode\' id=\'custGrpCode\' size=\"10\" value=\"\" onblur=\"if(this.value!=\'\'){ callCommonLookupCode(custGrpDesc,custGrpCode,9,1); } else{ fnClearCode(custGrpDesc); }\">&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'custGrpDesc\' id=\'custGrpDesc\' id=\'custGrpDesc\' size=\"30\" value=\"\" onblur=\"if(this.value!=\'\'){ callCommonLookupCode(custGrpDesc,custGrpCode,9,2); } else{ fnClearCode(custGrpCode); }\">&nbsp;\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"custGrpBtn\" id=\"custGrpBtn\" id=\'custGrpBtn\' value=\'?\' onClick=\"callCommonLookupCode(custGrpDesc,custGrpCode,9,2);\" tabindex=\'2\'>\n\t\t\t\t</td>\n\t\t\t\t<td style=\"padding-top: 10px;\" width=\"10%\" nowrap>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"10%\" nowrap class=\'label\' style=\"text-align: left;\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"10%\" nowrap class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' name=\'blngGrpCode\' id=\'blngGrpCode\' id=\'blngGrpCode\' size=\"10\" value=\"\"  onblur=\"if(this.value!=\'\'){ callCommonLookupCode(blngGrpDesc,blngGrpCode,6,1); } else{ fnClearCode(blngGrpDesc); }\">&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'blngGrpDesc\' id=\'blngGrpDesc\' id=\'blngGrpDesc\' size=\"30\" value=\"\"  onblur=\"if(this.value!=\'\'){ callCommonLookupCode(blngGrpDesc,blngGrpCode,6,2); } else{ fnClearCode(blngGrpCode); }\">&nbsp;\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"blngGrpBtn\" id=\"blngGrpBtn\" value=\'?\' onClick=\"callCommonLookupCode(blngGrpDesc,blngGrpCode,6,2);\" tabindex=\'2\'>\t\t\t\t\t\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\t\n\t\t\t\t</td>\n\t\t\t\t</tr >\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t<td style=\"padding-top: 10px;\" width=\"10%\" nowrap>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"10%\" nowrap class=\'label\' style=\"text-align: left;\" id=\'tdCustLbl\'> \n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"10%\" nowrap class=\'fields\' >\n\t\t\t\t\t<input type=\'text\' name=\'custCode\' id=\'custCode\' id=\'custCode\' size=\"10\" value=\"\" onblur=\"if(this.value!=\'\'){ callCommonLookupCode(custDesc,custCode,3,1,custGrpCode); } else{ fnClearCode(custDesc); }\">&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'custDesc\' id=\'custDesc\' id=\'custDesc\' size=\"30\" value=\"\" onblur=\"if(this.value!=\'\'){ callCommonLookupCode(custDesc,custCode,3,2,custGrpCode); } else{ fnClearCode(custCode); }\">&nbsp;\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"custBtn\" id=\"custBtn\" id=\'custBtn\' value=\'?\' onClick=\"callCommonLookupCode(custDesc,custCode,3,2,custGrpCode)\" tabindex=\'2\'>\t\t\t\t\t\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\t\n\t\t\t\t</td>\n\t\t\t\t<td style=\"padding-top: 10px;\" width=\"10%\" nowrap>\n\t\t\t\t</td>\n\t\t\t\t<td width=\"10%\" nowrap class=\'label\' style=\"text-align: left;\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"10%\" nowrap class=\'fields\' >\n\t\t\t\t\t<input type=\'text\' name=\'pkgCode\' id=\'pkgCode\' id=\'pkgCode\' size=\"10\" onblur=\"if(this.value!=\'\'){ callCommonLookupCode(pkgDesc,pkgCode,4,1); } else{ fnClearCode(pkgDesc); }\">&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'pkgDesc\' id=\'pkgDesc\' id=\'pkgDesc\' size=\"30\" onblur=\"if(this.value!=\'\'){ callCommonLookupCode(pkgDesc,pkgCode,4,2); } else{ fnClearCode(pkgCode); }\">&nbsp;\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"pkgBtn\" id=\"pkgBtn\" id=\'pkgBtn\' value=\'?\' onClick=\"callCommonLookupCode(pkgDesc,pkgCode,4,2)\" tabindex=\'2\'>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<td style=\"padding-top: 10px;\" width=\"10%\" nowrap>\n\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t<td width=\"10%\" nowrap class=\'label\' style=\"text-align: left;\" id=\'tdCustLbl\'> \n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</td>\n\t\t\t\t\t<td width=\"10%\" nowrap class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' name=\'ppGrpCode\' id=\'ppGrpCode\' id=\'ppGrpCode\' size=\"10\" value=\"\"  onblur=\"if(this.value!=\'\'){ callCommonLookupCode(ppGrpDesc,ppGrpCode,8,1); } else{ fnClearCode(ppGrpDesc); }\">&nbsp;\n\t\t\t\t\t<input type=\'text\' name=\'ppGrpDesc\' id=\'ppGrpDesc\' id=\'ppGrpDesc\' size=\"30\" value=\"\"  onblur=\"if(this.value!=\'\'){ callCommonLookupCode(ppGrpDesc,ppGrpCode,8,2); } else{ fnClearCode(ppGrpCode); }\">&nbsp;\n\t\t\t\t\t<input type=\'button\' class=\'button\' name=\"ppGrpBtn\" id=\"ppGrpBtn\" value=\'?\' onClick=\"callCommonLookupCode(ppGrpDesc,ppGrpCode,8,2);\" tabindex=\'2\'>\t\t\t\t\t\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\t\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\t<td style=\"padding-top: 10px;\" width=\"10%\" nowrap>\n\t\t\t\t</td>\t\n\t\t\t\n\t\t\t\t<td width=\'25%\' class=\'label\'> ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" &nbsp;&nbsp;\n\t\t\t\t<input type=\'text\' name=\'encounter_from_date\' id=\'encounter_from_date\' id=\'encounter_from_date\' size=\'10\' maxlength=\'30\' value=\'\' onBlur=\'return checkDateBL(document.forms[0].encounter_from_date)\' ><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar_loc(\'encounter_from_date\',document.forms[0].encounter_from_date);\" onBlur=\'return checkDateBL(document.forms[0].encounter_from_date)\'>\n\t\t\t\t <img src=\'../../eCommon/images/mandatory.gif\'>\t\n\t\t\t\t </td>\n\t\t\t\t<td width=\"25%\"  class=\'label\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;&nbsp;\n\t\t\t\t<input type=\'text\' name=\'encounter_to_date\' id=\'encounter_to_date\' id=\'encounter_to_date\' size=\'10\' maxlength=\'30\'  value=\'\' onBlur=\'return toFromDateChk(document.forms[0].encounter_to_date)\'><img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar_loc(\'encounter_to_date\',document.forms[0].encounter_to_date);\" onBlur=\'return toFromDateChk(document.forms[0].encounter_to_date)\'>\n\t\t\t\t</td>\n\t\t\t\n\t\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t</tr>\n\t\t\t\t\n\t\t\t<tr>\n\t\t\t<td style=\"padding-top: 10px;\" width=\"10%\" nowrap>\n\t\t\t\t</td>\n\t\t\t\t<td style=\"padding-top: 10px;\" width=\"10%\" nowrap>\n\t\t\t\t</td>\n\t\t\t<td>\n\t\t\t</td>\n\t\t\t\n\t\t\t\t<td  style=\"text-align: right width=\"40%\" nowrap>\n\t\t\t\t</td>\n\t\t\t<td  style=\"text-align: right; width: 40%\" id=\'tdSearchBtn\' colspan=\'2\'>\n\t\t\t\t\t<input type=\'button\' calss=\'button\' name=\"searchBtn\" id=\"searchBtn\" id=\"searchBtn\" value=\'Search\' onclick=\"funQry();\">\n\t\t\t\t\t<input type=\'button\' calss=\'button\' name=\"clear\" id=\"clear\" id=\"resetBtn\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'\'>\n\t\t\t\t</td>\n\t\t\t\n\t\t\t</tr>\n\t\t\t\n\t\t</table>\n\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' />\n\t\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\' id=\'facilityId\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' />\n\t\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	String facilityId = (String)session.getAttribute("facility_id");
	PkgPriceDisountBC priceDiscBC =  new PkgPriceDisountBC();
	String backDate = priceDiscBC.getPkgBackDate(facilityId);	
	int noOfDecimal = priceDiscBC.getNoOfDecimal();	
	String login_user = (String)session.getAttribute("login_user");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locale ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(facilityId ));
            _bw.write(_wl_block18Bytes, _wl_block18);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Query_Criteria.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CUSTOMER_GROUP.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingClass.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Customer.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Package.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.POLICY.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveFrom.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveTo.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
}
