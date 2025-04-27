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
import java.sql.*;
import java.text.*;
import java.util.*;

public final class __transferpatientoccupancydtlstab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/TransferPatientOccupancyDtlsTab.jsp", 1742461575815L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script src=\"../js/TransferPatient.js\" language=\"javascript\"></script> \n\t<Script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n\t<Script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n \t<Script src=\"../js/TransferPatOccupancyDtls.js\" language=\"JavaScript\"></Script> \t\n\t<Script src=\"../js/IPPractitionerComponent.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \t \n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\n\nfunction validateFrTo()\n{\n\tvar call_function = document.forms[0].call_function.value;\n\tvar from_bed_class\t= document.forms[0].fr_bed_class.value;\n\tvar to_bed_class = \"\";\n\n\tif(call_function == \'Transfer_In\')\n\t{\n\t\tto_bed_class\t= document.forms[0].Bedcode.value;\n\t}\n\t\n\tif(call_function == \'Transfer_Out\')\n\t{\n\t\tto_bed_class\t= document.forms[0].to_bed_class.value;\n\t}\n\n\tvar from_bed_type\t= document.forms[0].fr_bed_type.value;\n\tvar to_bed_type\t\t= document.forms[0].bed_type_code.value;\n\n\tif( (from_bed_class == to_bed_class) && (from_bed_type == to_bed_type) )\n\t{\n\t\tself.document.forms[0].bed_change.checked = false;\n\t\tself.document.forms[0].bed_change.value = \"N\";\n\t\tself.document.forms[0].bed_change.onclick();\n\t}\n}\n\n\nfunction CheckNursingUnit()\n{\t\t\n\tvar nursingunit=document.forms[0].nursing_unit_desc.value;\n\tif(nursingunit == \'\')\n\t{\n\tdocument.forms[0].nursing_unit_code.value=\'\';\n\tdocument.forms[0].service.value=\'\';\n\tdocument.forms[0].sub_service.value=\'\';\n\tdocument.forms[0].pract_desig.value=\'\';\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\tif (document.forms[0].bed_status_name != null)\n\t\t\tdocument.forms[0].bed_status_name.style.visibility = \"Hidden\" ;\n\tdocument.forms[0].to_bed_no.value=\'\';\n\tdocument.forms[0].to_room_no.value = \'\';\t\n\tif(document.forms[0].bed_class_allowed.value !=\'Y\'){\n\tdocument.forms[0].Bedcode.value=\'\';\n\tvar obj =document.forms[0].bed_type_code;\t\t\n\t\tvar length  = obj.length;\n\t\tfor(i=0;i<length;i++) \n\t\t{\n\t\tobj.remove(1);\n\t\t}\n\t}\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\tvar obj =document.forms[0].service;\t\t\n\t\tvar length  = obj.length;\n\t\tfor(i=0;i<length;i++) \n\t\t{\n\t\tobj.remove(1);\n\t\t}\n\tvar obj1 =document.forms[0].sub_service;\n\t\tvar length1  = obj1.length;\n\t\tfor(i=0;i<length1;i++) \n\t\t{\n\t\tobj1.remove(1);\n\t\t}\n\t}\n\tif(document.forms[0].nursing_unit_desc.value ==document.forms[0].fr_nursing_unit_desc.value)\n\t{\n\t\tvar error = getMessage(\'TFR_SAME_NU_NOT_ALLOW\',\'IP\');\n\t\terror = error.replace(\'$\',getLabel(\'Common.nursingUnit.label\',\'Common\'));\n\t\talert(error);\n\t\tvar obj =document.forms[0].service;\t\t\n\t\tvar length  = obj.length;\n\t\tfor(i=0;i<length;i++) \n\t\t{\n\t\tobj.remove(1);\n\t\t}\n\t\tvar obj1 =document.forms[0].sub_service;\n\t\tvar length1  = obj1.length;\n\t\tfor(i=0;i<length1;i++) \n\t\t{\n\t\tobj1.remove(1);\n\t\t}\n\t\tdocument.forms[0].nursing_unit_desc.value =\"\";\n\n\t\tdocument.forms[0].nursing_unit_desc.focus();\n\t\treturn false;\n\t}\n}\n\nfunction compareSystemDate_tout(calid2)\n{\n\n  if (calid2.value != \"\" || calid2.value != \'\')\n\t{\n\t\tif(!validDateObj(calid2,\"DMYHM\",localeName))\n\t\t{\n\t\t\treturn ;\n\t\t}\n\t\t\n\t\tvar greg_authorizationDateTime = convertDate(calid2.value,\'DMYHM\',localeName,\'en\');\n\t\tvar greg_prefDateTime = convertDate(parent.frames[1].document.trf_form.pref_date.value,\'DMYHM\',localeName,\'en\');\n\t\t/* 17956 Thursday, January 07, 2010*/\n\t\tvar max_trn_date_time = convertDate(parent.frames[1].document.forms[0].max_trn_date_time.value,\'DMYHM\',localeName,\'en\');\n\t\t\t\t\n\t\tif(!isBefore(greg_authorizationDateTime,greg_prefDateTime,\'DMYHM\',\'en\'))\n\t\t{\n\t\t\t/* 17956 Thursday, January 07, 2010*/ \n\t\t\tvar error = getMessage(\'DATE1_GT_DATE2\',\'IP\');\n\t\t\terror = error.replace(\'$\',getLabel(\"eIP.AuthorizationDateTime.label\",\"IP\"));\n\t\t\terror = error.replace(\'#\',getLabel(\"eIP.PreferredDateTime.label\",\"IP\"));\n\t\t\talert(error);\n\t\t\tcalid2.value= \"\";\n\t\t\tcalid2.focus();\n\t\t\t\n\t\t\treturn false;\n\t\t}\n\t\tif(!isBefore(parent.frames[1].document.trf_form.admission_date.value,greg_authorizationDateTime,\'DMYHM\',\'en\'))\n\t\t{\n\t\t\t/* 17956 Thursday, January 07, 2010*/\n\t\t\tvar error = getMessage(\'DATE1_LT_DATE2\',\'IP\');\n\t\t\terror = error.replace(\'$\',getLabel(\"eIP.AuthorizationDateTime.label\",\"IP\"));\n\t\t\terror = error.replace(\'#\',getLabel(\"Common.AdmissionDateTime.label\",\"Common\"));\n\t\t\talert(error);\n\t\t\tcalid2.value= \"\";\n\t\t\tcalid2.focus;\n\t\t\treturn false;\n\t\t}\n\t\t/* 17956 Thursday, January 07, 2010*/\n\t\tif(!isBefore(max_trn_date_time,greg_authorizationDateTime,\'DMYHM\',\'en\')){\n\t\t\t var error = getMessage(\'DATE1_LT_DATE2\',\'IP\');\n\t\t\t var last_encounter = getLabel(\"eIP.LastTransactionDateTime.label\",\"IP\");\n\t\t\t error = error.replace(\'$\',getLabel(\"eIP.AuthorizationDateTime.label\",\'IP\'));\n\t\t\t error = error.replace(\'#\',last_encounter);\n\t\t\t alert(error);\n   \t\t\t calid2.value= \"\";\n\t\t\t calid2.select();\n \t\t\treturn false;\n\n\t\t}\n\t\t\n\t}\n}\n\nfunction compareSystemDate1(calid)\n{\n\tif (calid.value != \"\" || calid.value != \'\' )\n\t{\n\t\t\n\t\tif(!validDateObj(calid,\"DMYHM\",localeName))\n\t\t{\n\t\t\treturn ;\n\t\t}\n\t\t/* 17956 Thursday, January 07, 2010*/\n\t\tvar max_trn_date_time = convertDate(parent.frames[1].document.forms[0].max_trn_date_time.value,\'DMYHM\',localeName,\'en\');\n\t\tvar greg_informedDateTime = convertDate(calid.value,\'DMYHM\',localeName,\'en\');\n\t\tvar greg_prefDateTime = convertDate(parent.frames[1].document.trf_form.pref_date.value,\'DMYHM\',localeName,\'en\');\n\t\t/*  17956 Thursday, January 07, 2010 */\n\t\tif(!isBefore(greg_informedDateTime,greg_prefDateTime,\'DMYHM\',\'en\'))\n\t\t{\n\t\t\tvar error = getMessage(\'DATE1_GT_DATE2\',\'IP\');\n\t\t\terror = error.replace(\'$\',getLabel(\"Common.InformedDate/Time.label\",\"Common\"));\n\t\t\t/*  17956 Thursday, January 07, 2010 */\n\t\t\terror = error.replace(\'#\',getLabel(\"eIP.PreferredDateTime.label\",\"IP\"));\n\t\t\talert(error);\t\n\t\t\tcalid.select();\n\t\t\tcalid.focus;\n\t\t\treturn false;\n\t\t}\n\n\t\tif(!isBefore(parent.frames[1].document.trf_form.admission_date.value,greg_informedDateTime,\'DMYHM\',\'en\'))\n\t\t{\n\t\t\tvar error = getMessage(\'DATE1_LT_DATE2\',\'IP\');\n\t\t\terror = error.replace(\'$\',getLabel(\"Common.InformedDate/Time.label\",\"Common\"));\n\t\t\t/*  17956 Thursday, January 07, 2010 */\n\t\t\terror = error.replace(\'#\',getLabel(\"Common.AdmissionDateTime.label\",\"Common\"));\n\t\t\talert(error);\n\t\t\tcalid.select();\n\t\t\tcalid.focus;\n\t\t\treturn false;\n\t\t}\n\t\t\t/* 17956 Thursday, January 07, 2010*/\n\t\tif(!isBefore(max_trn_date_time,greg_informedDateTime,\'DMYHM\',\'en\')){\n\t\t\t var error = getMessage(\'DATE1_LT_DATE2\',\'IP\');\n\t\t\t var last_encounter = getLabel(\"eIP.LastTransactionDateTime.label\",\"IP\");\n\t\t\t error = error.replace(\'$\',getLabel(\"Common.InformedDate/Time.label\",\"Common\"));\n\t\t\t error = error.replace(\'#\',last_encounter);\n\t\t\t alert(error);\n   \t\t\t calid.value= \"\";\n\t\t\t calid.select();\n \t\t\treturn false;\n\n\t\t}\n\n\t}\n}\n\nfunction checkform()\n{\n\tvar mother_status = document.forms[0].mother_status.value;\n\tvar transfer_wo_delink_yn = document.forms[0].transfer_wo_delink_yn.value;\n\t\n\tif (mother_status != \'0\')\n\t{\n\t\tif(transfer_wo_delink_yn==\'N\'){\n\t\t\tif(confirm(getMessage(\'DELINK_BABY_YN\',\'IP\'))) \n\t\t\t{\n\t\t\t\t document.forms[0].mother_bed_status.value=\'Y\';\n\t\t\t\t return true; \n\t\t\t}\n\t\t\telse \n\t\t\t{\n\t\t\t\t document.forms[0].mother_bed_status.value=\'N\';\n\t\t\t\t window.close(); \n\t\t\t}\n\t\t}else{\n\t\t\tdocument.forms[0].mother_bed_status.value=\'Y\';\n\t\t\treturn true;\n\t\t}\n\t}\n}\nfunction disabledAllFields()\n\t{\n\t\t\n\t\tdocument.getElementById(\'nursing_unit_desc\').disabled\t= true;\n\t\tdocument.getElementById(\'nursing_unit_lookup\').disabled\t= true;\n\t\tdocument.getElementById(\'service\').disabled\t\t\t\t= true;\n\t\tdocument.getElementById(\'sub_service\').disabled\t\t\t= true;\n\t\tdocument.getElementById(\'Bedcode\').disabled\t\t\t\t= true;\n\t\tdocument.getElementById(\'bed_type_code\').disabled\t\t=true;\n\t\tif (document.getElementById(\'to_bed_class\').value == \"\")\n\t\t\tdocument.getElementById(\'Bedcode\').value\t\t\t\t= \"\";\t\n\t\telse\n\t\tdocument.getElementById(\'Bedcode\').value\t\t\t\t= document.getElementById(\'to_bed_class\').value;\n\t\tdocument.getElementById(\'to_bed_no\').disabled\t\t\t= true;\n\t\tdocument.getElementById(\'to_room_no\').disabled\t\t\t= true;\n\t\tdocument.getElementById(\'Splcode_desc\').disabled\t\t= true;\n\t\tdocument.getElementById(\'pract_desc\').disabled\t\t\t= true;\n\t\tdocument.getElementById(\'pract_desig\').disabled\t\t\t= true;\n\t\tdocument.getElementById(\'team_id\').disabled\t\t\t\t= true;\n\t\tdocument.getElementById(\'info_pat_relatives\').disabled\t= true;\n\t\tdocument.getElementById(\'info_date_time\').disabled\t\t= true;\n\t\tdocument.getElementById(\'inform_to\').disabled\t\t\t= true;\n\t\tdocument.getElementById(\'auth_date_time\').disabled\t\t= true;\n\t\tdocument.getElementById(\'info_pat_name\').disabled\t\t= true;\n\t\tdocument.getElementById(\'bed_avail\').disabled\t\t\t= true;\n\t\tdocument.getElementById(\'Splcode_lookup\').disabled\t\t= true;\n\t\tdocument.getElementById(\'pract_id_search\').disabled\t\t= true;\n\n\t\tdocument.getElementById(\'cancel_reason\').value\t\t\t= \"\";\n\t\tdocument.getElementById(\"ondate1\").disabled\t\t\t\t\t= true;\t\n\t\tdocument.getElementById(\'inform_button\').disabled = true;\n\t\tdocument.getElementById(\"img2\").style.visibility\t\t\t\t= \'hidden\';\n\t\tdocument.getElementById(\"img3\").style.visibility\t\t\t\t= \'hidden\';\n\t\tdocument.getElementById(\"img4\").style.visibility\t\t\t\t= \'hidden\';\n\t\tdocument.getElementById(\"img5\").style.visibility\t\t\t\t= \'hidden\';\n\t\tdocument.getElementById(\"ondate1\").style.visibility\t\t\t= \'hidden\';\n\t\tdocument.getElementById(\"ondate2\").style.visibility\t\t\t= \'hidden\';\n\t\tdocument.getElementById(\"serv_img\").style.visibility\t\t\t= \'hidden\';\n\t\tdocument.getElementById(\"received_img\").style.visibility\t\t= \'hidden\';\n\t\tdocument.getElementById(\'Bedcode\').disabled = true;\n\t\tdocument.getElementById(\'to_bed_class\').disabled = true;\n\t\tdocument.getElementById(\"img_informed_date\").style.visibility = \"Hidden\";\n\t\tdocument.getElementById(\"img_m\").style.visibility\t\t\t\t= \"hidden\";\n\t\tdocument.getElementById(\'cancel_reason\').disabled\t\t= true;\t \n\t\tdocument.getElementById(\"cancelreasonid\").style.visibility   = \"hidden\";\t \n\t\tdocument.getElementById(\'cancel_reason\').value\t\t= \"\";\t \n\t\t\n\t\tif (document.forms[0].inform_to.value != \"\")\n\t\t\tdocument.getElementById(\"img_informed_date\").style.visibility = \"Visible\";\n\t\telse\t\n\t\t\tdocument.getElementById(\"img_informed_date\").style.visibility = \"Hidden\";\n\t\tdocument.getElementById(\"img_auth_date\").style.visibility = \"Hidden\";\n\t\t\n\t}\n\nfunction ChkNumberInput(fld, e, deci)\n{\nif (parseInt(deci)>0)\n   var strCheck = \'.0123456789 /:\';\nelse\n   var strCheck = \'0123456789 /:\';\n\n   var whichCode = (window.Event) ? e.which : e.keyCode;\n    if (whichCode == 13) return true;  // Enter\n\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n}\n\n\nfunction ValidatePrefDateTime(from,to)\n{\n    from = from.value\n    to   = to.value\n    var a=  from.split(\" \")\n    splitdate=a[0];\n    splittime=a[1]\n    var splitdate1 =splitdate.split(\"/\")\n    var splittime1= splittime.split(\":\")\n    var from_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n    a=  to.split(\" \")\n    splitdate=a[0];\n    splittime=a[1]\n\tsplitdate1 =splitdate.split(\"/\")\n\tsplittime1= splittime.split(\":\")\n\ttime3=splittime1[1]\n\tvar strCheck = \':0123456789\';\n\tfor(var i=0;i<=time3.length;i++) \n\t{\n\t\tif (strCheck.indexOf(time3.charAt(i)) == -1)\n\t\t{\n\t\t\talert(getMessage(\"INVALID_DATE_TIME\",\"SM\"));\n\t\t\treturn false;\n\t\t\tbreak;\n\t\t}\n\t}\n     var to_date  =new Date(eval(splitdate1[2]), eval(splitdate1[1])-1, eval(splitdate1[0]), eval(splittime1[0]), eval(splittime1[1]))\n\n\tif(Date.parse(to_date) < Date.parse(from_date))\n    {\n        return false;\n    }\n    else\n        return true;\n}\n\n//added by kishore on 9/6/2004\nfunction setDesable()\n{\n\n\tvar obj =document.getElementById(\'bed_type_code\');\t\t\n\tvar length  = obj.length;\n\tfor(i=0;i<length;i++) \n\t{\n\t\tobj.remove(1);\n\t}\n\tvar opt= parent.frames[1].document.createElement(\'Option\');\n\topt.text=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"; \n\topt.value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\n\tif(opt.text != \'\')\n\t{\n\t\topt.selected = true;\n\t\tobj.add(opt);\n\t}\n\tparent.frames[1].document.createElement(\'Option\');\n\tif(document.forms[0].call_function_name.value==\'TransferPatientIn\')\n\t\tvar obj1 =document.getElementById(\'Bedcode\');\t\n\telse\n\t\tvar obj1 =document.getElementById(\'to_bed_class\');\t\n\n\tvar length  = obj1.length;\n\t\n\tfor(i=0;i<length;i++) \n\t{\n\t\tobj1.remove(1);\n\t}\n\t\n\tvar opt= parent.frames[1].document.createElement(\'Option\');\n\topt.text=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\topt.selected = true;\n\tobj1.add(opt);\n\tparent.frames[1].document.createElement(\'Option\');\n\n\tif(document.forms[0].bed_class_allowed.value==\'Y\')\n\t{\n\t\tdocument.forms[0].to_bed_class.disabled=true;\n\t\tdocument.forms[0].Bedcode.disabled=true;\n\t\tdocument.forms[0].bed_type_code.disabled=true;\n\t}\n\telse if(document.forms[0].bed_class_allowed.value==\'N\')\n\t{\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\tdocument.forms[0].to_bed_class.disabled=true;\n\t\t\tdocument.forms[0].Bedcode.disabled=true;\n\t\t\tdocument.forms[0].bed_type_code.disabled=true;\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t}\n\t//11/14/2008  FS102IPSRRCRF0228V2.0 \n\tif(document.forms[0].call_function.value == \"Transfer_In\"){\n\t\tif(document.forms[0].reserve_bed_on_tfr_yn.value == \'Y\'){\n\t\t\tif(document.forms[0].reserved_bed_yn.value.checked == true)\n\t\t\t{\n\t\t\t\t//document.forms[0].reason_for_reserved_bed.disabled=false;\n\t\t\t\t//document.forms[0].reserved_bed_img.style.visibility=\'visible\';\n\t\t\t}else\n\t\t\t{\n\t\t\t\t//document.forms[0].reason_for_reserved_bed.value = \'\';\n\t\t\t\t//document.forms[0].reason_for_reserved_bed.disabled=true;\n\t\t\t\t//document.forms[0].reserved_bed_img.style.visibility=\'hidden\';\n\t\t\t}\n\t\t}\n\t}\n\t\n\t\n\tif(document.forms[0].call_function.value == \"Transfer_Out\"){\n\t\tif(document.forms[0].reserve_bed_on_tfr_yn.value == \'Y\'){\n\t\t\tif(document.forms[0].reserved_bed_yn.checked == true){\n\t\t\t\tdocument.forms[0].reason_for_reserved_bed.disabled = false;\n\t\t\t}else{\n\t\t\t\tdocument.forms[0].reason_for_reserved_bed.disabled = true;\n\t\t\t}\n\t\t}\n\t}\n\t\n}\n\nfunction setEnable()\n{\n\tvar call_func = document.forms[0].call_function_name.value;\n\tif (document.forms[0].bed_change.checked==true)\n\t{\n\t\tdocument.forms[0].bed_change.value=\"Y\";\n\t\tdocument.forms[0].to_bed_class.disabled=false;\n\t\tdocument.forms[0].bed_type_code.disabled=false;\n\t\t\n\t\t\tif(call_func == \'TransferPatientOut\')\n\t\t\t{\n\t\t\t\tgetBedClass();\n\t\t\t}\n\t\t\telse\n\t\t\t\tgetBedtype();\n\t}\n\telse\n\t{\n\tdocument.forms[0].bed_change.value=\"N\";\n    document.forms[0].to_bed_class.value=document.forms[0].frbedclass.value;\n\tdocument.forms[0].to_bed_class.disabled=true;\n\tdocument.forms[0].bed_type_code.disabled=true;\n\tif(call_func == \'TransferPatientOut\')\n\t{\n\t\tvar obj = document.forms[0].to_bed_class;\n\t\tvar length  = obj.length;\n\t\tfor(i=0;i<length;i++) \n\t\t{\n\t\t\tobj.remove(1);\n\t\t}\n\t\tvar opt= document.createElement(\'Option\');\n\t\topt.text=document.forms[0].fr_bed_class_descn.value; \n\t\topt.value=document.forms[0].frbedclass.value;\n\t\tobj.add(opt)\n\t\topt.selected = true;\n\t}\n\telse\n\t{\n\t\tdocument.getElementById(\'bed_type_code\').value = document.getElementById(\'fr_bed_type\').value;\n\t}\n\t\tvar obj = document.getElementById(\'bed_type_code\');\n\t\tvar length  = obj.length;\n\t\tfor(i=0;i<length;i++) \n\t\t{\n\t\t\tobj.remove(1);\n\t\t}\n\t\tvar opt= document.createElement(\'Option\');\n\t\topt.text=document.getElementById(\'frbedtypedesc\').value; \n\t\topt.value=document.getElementById(\'fr_bed_type\').value;\n\t\tobj.add(opt)\n\t\topt.selected = true;\n\t}\n}\n\tfunction getBedClass()\n\t{\n\t\tvar obj1 = parent.frames[2].document.forms[0].nursing_unit_desc;\n\t\tvar obj_nUnit_code = parent.frames[2].document.forms[0].nursing_unit_code;\n\t\tvar deactivate_pseudo_bed_yn = parent.frames[2].document.forms[0].deactivate_pseudo_bed_yn.value;\n\t\tif((obj1.value!=null)&&(obj1.value!=\"\"))\n\t\t{\n\t\tvar bed_class = parent.frames[2].document.forms[0].to_bed_class.value;\n\n\t\tvar obj2 = parent.frames[2].document.forms[0].to_bed_class;\n\t\tvar length  = obj2.length;\n\t\tfor(i=0;i<length;i++) \n\t\t{\n\t\tobj2.remove(1);\n\t\t}\n\n\t\tvar obj = parent.frames[2].document.forms[0].bed_type_code;\n\t\tlength  = obj.length;\n\t\tfor(i=0;i<length;i++) \n\t\t{\n\t\t\tobj.remove(1);\n\t\t}\n\tvar HTMLVal = \" <html><body onKeyDown=\'lockKey()\'><form name=\'dum_form1\' id=\'dum_form1\' method=\'post\' action=\'../../eIP/jsp/TransferValidation.jsp\' ><input type=\'hidden\' name=\'field4\' id=\'field4\' value=\'getBedClass\'><input type=\'hidden\' name=\'function_Id\' id=\'function_Id\' value=\'TRANSFER_PAT_OUT\'><input type=\'hidden\' name=\'nursingunitcode\' id=\'nursingunitcode\' value=\\\"\"+obj_nUnit_code.value+\"\\\"><input type=\'hidden\' name=\'deactivate_pseudo_bed_yn\' id=\'deactivate_pseudo_bed_yn\' value=\\\"\"+deactivate_pseudo_bed_yn+\"\\\"></form></body></html>\";\n\tparent.frames[3].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\tparent.frames[3].document.dum_form1.submit();\n\t}\n }\n\nfunction getBedtype()\n{\n\tif(document.forms[0].call_function_name.value==\'TransferPatientIn\')\n\t\tvar bed_class = document.forms[0].Bedcode.value;\n\telse\n\t\tvar bed_class = document.forms[0].to_bed_class.value;\n\n\tdocument.forms[0].bed_type_code.value=\'\';\n\tdocument.forms[0].to_bed_no.value=\'\';\n\tdocument.forms[0].to_room_no.value=\'\';\n\tvar obj =document.forms[0].bed_type_code;\t\t\n\t\tvar length  = obj.length;\n\t\tfor(i=0;i<length;i++) \n\t\t{\n\t\tobj.remove(1);\n\t\t}\n\tvar HTMLVal = \" <html><body onKeyDown=\'lockKey()\'><form name=\'dum_form\' id=\'dum_form\' method=\'post\' action=\'../../eIP/jsp/TransferValidation.jsp\'>\"+\n\t\" <input type=\'hidden\' name=\'field1\' id=\'field1\' value=\'\'><input type=\'hidden\' name=\'field2\' id=\'field2\' value=\'\'> \"+\n\t\" <input type=\'hidden\' name=\'field3\' id=\'field3\' value=\"+document.forms[0].nursing_unit_code.value+\"><input type=\'hidden\' name=\'deactivate_pseudo_bed_yn\' id=\'deactivate_pseudo_bed_yn\' value=\"+document.forms[0].deactivate_pseudo_bed_yn.value+\"><input type=\'hidden\' name=\'field4\' id=\'field4\' value=\'\'><input type=\'hidden\' name=\'field8\' id=\'field8\' value=\'\'><input type=\'hidden\' name=\'field9\' id=\'field9\' value=\'Tfr_out\'><input type=\'hidden\' name=\'bed_class\' id=\'bed_class\' value=\\\"\"+bed_class+\"\\\"></form></body></html>\";\n \n\tparent.frames[3].document.body.insertAdjacentHTML(\'afterbegin\',HTMLVal);\n\tparent.frames[3].document.dum_form.submit();\n}\n\t\tfunction expandCollapse(calledFrom) {\t\t\t\t\t\n\n\t\t\t\t\tif(calledFrom == \'Occupancy_Details\') {\n\n\t\t\t\t\t\tdocument.getElementById(\"Occupancy\").style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\"Other\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Porterage\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Medical\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Patient\").style.display = \'none\';\n\t\t\t\t\t\tparent.Button_frame.document.getElementById(\'button_s\').disabled = false;\n\t\t\t\t\t\tif(document.forms[0].call_function_name.value == \'TransferPatientOut\'){\n\t\t\t\t\t\tif(document.forms[0].reserve_reason_code.value != \"\" && eval(document.forms[0].bed_blocking_period.value) != \"\")\n\t\t\t\t\t\t\tsetReserveBedDtls();\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\n\t\t\t\t\t} else if(calledFrom == \'other_details\') {\n\t\t\t\t\t\t\n\t\t\t\t\t\tdocument.getElementById(\"Occupancy\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Other\").style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\"Porterage\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Medical\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Patient\").style.display = \'none\';\n\t\t\t\t\t\tif(document.forms[0].call_function_name.value == \'TransferPatientOut\' && document.forms[0].book_conf_yn.value > 0)\n\t\t\t\t\t\t\tgetBlockBedDate();\n\t\t\t\t\t\t\n\t\t\t\t\t} else if(calledFrom == \'porterage_details\') {\n\n\t\t\t\t\t\tdocument.getElementById(\"Occupancy\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Other\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Porterage\").style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\"Patient\").style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\"Medical\").style.display = \'none\';\n\n\n\n\t\t\t\t\t} else if(calledFrom == \'Patient_Details\') {\n\n\t\t\t\t\t\tdocument.getElementById(\"Occupancy\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Other\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Porterage\").style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\"Patient\").style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\"Medical\").style.display = \'none\';\n\n\t\t\t\t\t} else if(calledFrom == \'Medical_details\') {\n\n\t\t\t\t\t\tdocument.getElementById(\"Occupancy\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Other\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Porterage\").style.display = \'inline\';\n\t\t\t\t\t\tdocument.getElementById(\"Patient\").style.display = \'none\';\n\t\t\t\t\t\tdocument.getElementById(\"Medical\").style.display = \'inline\';\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t}\n\t\n</script>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<body onload=\'disabledAllFields();populateDetails();setDesable();\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey();\'>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<body onload=\'populateDetails();getBlockBedDates();";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="enableBedNo();";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="chkInformedDtlsMandOnLoad();";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="setReserveBedDtls();";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey();\'><!--Modified by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617-->\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t<body onload=\'checkform();populateDetails();disabledef();";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t<form name=\"EmergencyTransfer_form\" id=\"EmergencyTransfer_form\"  method=\"post\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="action=\"../../servlet/eIP.TransferPatientInServlet\"  ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="action=\"../../servlet/eIP.TransferPatientOutServlet\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" target=\"parent.frames[1]\">\n\t<input type=\'hidden\' name=\'call_function_hdd\' id=\'call_function_hdd\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\n\t<!-- <a name=\"demo\" tabindex=\'0\'></a>  -->\n\t<div id =\"Occupancy\">\n\t\n\t<ul id=\"tablist\" class=\"tablist\">\n\t\t<li class=\"tablistitem\" title=\"Occupancy Details\">\n\t\t\t<a onclick=\"expandCollapse(\'Occupancy_Details\')\"  class=\"tabClicked\" id=\"Occupancy_Details\" ><span class=\"tabSpanclicked \" id=\"Occup_tabspan\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Other Details\">\n\t\t\t<a onclick=\"expandCollapse(\'other_details\')\" class=\"tabA\" id=\"other_details\" ><span class=\"tabAspan\" id=\"Othe_tabspan\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Porterage Details\">\n\t\t\t<a onclick=\"expandCollapse(\'porterage_details\')\" class=\"tabA\" id=\"porterage_details\" ><span class=\"tabAspan\" id=\"Port_tabspan\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t</ul>\n\t<table border=\"0\" width=\"100%\" cellpadding=\"3\" cellspacing=\"0\">\n\t\t <tr>\n\t\t\t\t<th  width=\'25%\' class=\'columnheader\'>&nbsp;</th>\n\t            <th align=\"left\" style=\" color: white;\" width=\'25%\' class=\'columnheader\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" </th>\n\t\t\t\t<th  width=\'25%\' class=\'columnheader\'>&nbsp;</th>\n\t            <th align=\"left\" style=\" color: white;\" class=\'columnheader\' width=\'25%\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</th>\n\t\t        \n\t\t</tr>\n\t\n\t\t<tr>\n\t\t\t<td colspan=4 class=\'CAGROUP\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t</tr> \n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t<tr>\n\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t<td class=\"label\" >&nbsp;</td>\n\t\t\t\n\t\t\t<td  class=\'querydata\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n\t\t\t<td class=\'fileds\'>\n\t\t\t\t<select name=\"priority\" id=\"priority\" disabled>\n\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" </option>\n\t\t\t\t</select>\n\t\t\t</td>\n\t\t</tr>\n\t\t ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t<td  class=\'querydata\' >";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t<input type=\"hidden\" name=\"fr_nursing_unit_code\" id=\"fr_nursing_unit_code\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"fr_nursing_unit_desc\" id=\"fr_nursing_unit_desc\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t\t</td>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t \t<td class=\'fileds\'><input type=text name=\"nursing_unit_desc\" id=\"nursing_unit_desc\"  maxlength=15 size=15 ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" value=\'\' ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" onblur=\"beforeGetNursingUnit(nursing_unit_desc,\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\',\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\');CheckNursingUnit();";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="enbldisbchk(this);";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\"  ><input type=button class=button name=nursing_unit_lookup id=nursing_unit_lookup value=\'?\' onClick=\"checkNursTxtVal(nursing_unit_desc,\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');\" ><img align=\"center\" id = \"img2\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t<input type=hidden name=\"nursing_unit_code\" id=\"nursing_unit_code\"  value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t\t\t<input type=hidden name=\"nurs_desc_hid\" id=\"nurs_desc_hid\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"></td>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t<input type=\"hidden\" name=\"fr_service_code\" id=\"fr_service_code\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"fr_service_desc\" id=\"fr_service_desc\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t\t<td  class=\"fileds\" nowrap>\t\n\t\t\t\n\t\t\t<select name=\"service\" id=\"service\" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="onChange=\'\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" onChange=\'onServiceChange()\' ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" >\n\n\t\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" ---</option>\n\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t</select><img align=\"center\" id=\"serv_img\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t</td>\n\t\t</tr>\n\t\t\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t<input type=\"hidden\" name=\"fr_sub_service_code\" id=\"fr_sub_service_code\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t\t<input type=\"hidden\" name=\"fr_service_desc\" id=\"fr_service_desc\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t\t<td  class=\"fileds\" nowrap>\t\n\t\t\t<select name=\"sub_service\" id=\"sub_service\" >\n\t\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t</select>\n\t\t\t</td>\n\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t<td  class=\'querydata\' >&nbsp;</td>\n\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t\t\t<td class=\'fileds\' >\n\t\t\t\t<input type=\'checkbox\' name=\'bed_change\' id=\'bed_change\'  onClick=\"setEnable();\"  >\n\t\t\t</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\n\t\t\t<td class=\'querydata\'  ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" >";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="<input type=\"hidden\" name=\"fr_bed_class\" id=\"fr_bed_class\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"  >\n\t\t\t<input type=\"hidden\" name=\"fr_bed_class_descn\" id=\"fr_bed_class_descn\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" >\n\t\t\t</td>\n\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</td>\n\t\t\t\n\t\t\t<td  class=\'fileds\'>\t\n\t\t\t<select ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" id=\'Bedcode\' name=\'Bedcode\' ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" id=\'to_bed_class\' name=\'to_bed_class\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" onChange=\'getBedtype();\' ><option value=\"\">--- ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" ---</option>\n\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\n\t</select><img align=\"center\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\n\t\t<input type=\"hidden\" name=\"hid_bed_code\" id=\"hid_bed_code\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >\t\n\t\t\t</td>\n\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\t\t\t<td  class=\'querydata\' ><input type=\"hidden\" name=\"fr_bed_type\" id=\"fr_bed_type\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" >";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td><input type=\"hidden\" name=\"frbedtypedesc\" id=\"frbedtypedesc\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" >\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t<td ><select name=\'bed_type_code\' id=\'bed_type_code\' onchange=\'validateFrTo();\' ><option value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' selected>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="<input type=\"hidden\" name=\"hid_bed_type\" id=\"hid_bed_type\" value=\"\" ><img align=\"center\" src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" ><input type=\"hidden\" name=\"fr_bed_no\" id=\"fr_bed_no\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" > ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</td>\n\t\t\t\n\t\t\t<!-- Modified by Sangeetha on 25/05/17 for GDOH-CRF-0151-->\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</td>\n\t\t\t\n\t\t\t\t<td class=\'fileds\'><input type=\"text\" readOnly name=\"to_bed_no\" id=\"to_bed_no\"  value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" size=8 maxlength=8 onBlur=\"ChangeUpperCase(this);getRoomNo(this);";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="chkforVacantNormalBed();";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" onKeyPress=\'return CheckForSpecChars(event)\' disabled ><input type=\"button\" class=\"button\" name=\"bed_avail\" id=\"bed_avail\" value=\"?\" onclick=\"callBedAvailChart();\" ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="onblur=\"chkforVacantNormalBed()\" ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" disabled >\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t<img align=\"center\" id=\"img3\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t\t</td>\n\t\t\t\n\t\t</tr>\n \t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</td>\n\t\t\t<td class=\'querydata\'  ><input type=\"hidden\" name=\"fr_room_no\" id=\"fr_room_no\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" </td>\n\t\t\t\n\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="</td>\n\t\t\t<td ><input type=\"text\" name=\"to_room_no\" id=\"to_room_no\"  value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\" size=4 maxlength=4 readonly onBlur=\"specialChar(this,\'Char\')\" disabled > </td>\n\t\t\t\n\t\t</tr>\t\t\n\t\t\t\n\t\t<tr>\n\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\t\t\t<td class=\'querydata\'  >";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t<input type=\"hidden\" name=\"fr_speciality_code\" id=\"fr_speciality_code\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\t\t\t<td class=\'fileds\' ><input type=text name=\'Splcode_desc\' id=\'Splcode_desc\' onblur=\"beforeGetSpecialty(Splcode_desc,\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\');\" maxlength=15 size=15  value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" ><input type=hidden name=\'Splcode\' id=\'Splcode\'  value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"><input type=button name=\'Splcode_lookup\' id=\'Splcode_lookup\' value=\'?\' class=button onClick=\"checkSpecTxtVal(Splcode_desc,\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\');\" ><img id = \"img4\"  src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img><input type=hidden name=\"spec_desc_hid\" id=\"spec_desc_hid\" value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\"></td>\n\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\t\t\t<td class=\'querydata\' id=\"PractDesc\"  nowrap >";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t<input type=\"hidden\" name=\"fr_practitioner_id\" id=\"fr_practitioner_id\" value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n\t\t\t<td nowrap class=\'fileds\'><input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" readonly><input type=\'text\' name=\'pract_desc\' id=\'pract_desc\' value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" size=\'25\' maxlength=\'30\' onblur=\"clearDesignation();beforeGetPractitioner(practid,this,\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\');\" ><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' class=\'button\'  onClick=\"checkPractTxtVal(document.forms[0].practid,pract_desc, \'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\');\"  ><img align=\"center\" id=\"img5\" src=\"../../eCommon/images/mandatory.gif\"><input type=hidden name=\"pract_desc_hid\" id=\"pract_desc_hid\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"> \n\t\t\t</td>\t\t\t\n\t\t</tr>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</td>\n\t\t\t<td class=\'querydata\' id=\"PractDesc\"   nowrap>";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\t\t\t</td>\n\t\t\t<td class=\"label\"  >";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</td>\n\t\t\t<td nowrap class=\'fileds\'>\n\t\t\t<input type=\'text\' name=\'pract_desig\' id=\'pract_desig\'  value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" size=\'25\' maxlength=\'30\' readonly >\n\t\t\t\t\t\n\t\t\t</td>\t\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="</td>\n\t\t\t<td  class=\'querydata\' id=\"MedTeamDesc\" >";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t<input type=\"hidden\" name=\"fr_team_id\" id=\"fr_team_id\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="</td>\n\t\t\t<td class=\'fileds\' ><select name=\"team_id\" id=\"team_id\"  onblur=\'reserve_bed();\'>\n\t\t\t\t\t<option value=\'\' selected>--- ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 =" ---\n";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\t\t\t\t\t\n\t\t\t\t</select>\t\t\t\t\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t<table border=0 width=\"100%\" cellpadding=\'2\' cellspacing=0 id=\'cancelreasonid\' style=\"visibility:hidden\">\n\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\n\t<tr>\n\t\t\t<td class=\"label\" width=\'25%\'  onkeydown=\'cancelreason1();\'>";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="</td>\n\t\t\t<td class=\'fileds\' colspan=\'3\'  ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 =" >\n\t\t\t<select name=\'cancel_reason\' id=\'cancel_reason\'  onblur=\"cancelreason();\">\n\t\t\t\t<option value=\'\' selected>--- ";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =" ---</option>\n\t\t\t\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\t\t\t\t <!--<OPTION VALUE=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</option>-->\n\t\t\t\t";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" \n\t\t\t\t</select>\t\t\t\t\t\t\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\' id=\"img_m\"></img></td>\n\t\t\t\t\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t<!--<tr>\n\t\t\n\t\t<td  colspan=4 align=right><input type=\"button\" class=\"button\" name=\"button_s\" id=\"button_s\" value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" onclick=\"submit_Form();\"><input type=\"button\" class=\"button\" value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" onclick=\"cancel();\" onblur=\"setfus();\" ></td>\n\t</tr> -->\n</table>\n</tr>\n</table>\n\t<!--10/20/2008 FS102IPSRRCRF0228V2.0-->\n\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t<!--";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="-->\n\t<table width=\'100%\' cellpadding=\'2\' cellspacing=\'0\' BORDER=\'0\'>\n\t<tr>\n\t\t<td colspan=4 width=\"100%\" class=\"COLUMNHEADER\" >";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="</td>\n\t</tr>\n\t<TR>\n\t<TD  class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="</TD> <!--Below line modified GHL-SCF-794 [IN:047142] -->\n\t<TD   class=\"fields\" colspan=\'3\'><INPUT TYPE=\"checkbox\" name=\"reserved_bed_yn\" id=\"reserved_bed_yn\"  onClick=\"setReserveBedDtls();\" disabled ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="checked";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="><input type=\"hidden\" name=\"is_reserved_bed_checked\" id=\"is_reserved_bed_checked\"  value=\"N\"></TD>\n\t</TR>\n\t\n\t</table>\n\n\t";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\n\t<table width=\'100%\' cellpadding=\'2\' cellspacing=\'0\' BORDER=\'0\'>\n\t<tr>\n\t\t<td colspan=4 width=\"100%\" class=\"COLUMNHEADER\" >";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="</TD>\n\t<TD   class=\"fields\" colspan=\'3\'><INPUT TYPE=\"checkbox\" name=\"reserved_bed_yn\" id=\"reserved_bed_yn\" onClick=\"setReserveBedDtls();\" ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="  ><input type=\"hidden\" name=\"is_reserved_bed_checked\" id=\"is_reserved_bed_checked\"  value=\"N\"></TD>\n\t</TR>\n\t<TR>\n\t<TD  class=\"label\" width=\'25%\' >";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="</TD>\n\t<TD   class=\"fields\" colspan=\'3\'>\n\t<select name=\'reason_for_reserved_bed\' id=\'reason_for_reserved_bed\' ><option value=\"\">-----&nbsp;";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="&nbsp;-----</option>\n\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\n\n\t</select>\n\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\' id=\'reserved_bed_img\' style=\'visibility:hidden\'></img >\n\t</TD>\n\t</TR>\n\t</table>\n\t\n\t";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t\t\n\t\n    <input type=\"hidden\" name=\"locale1\" id=\"locale1\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">  \n\t<input type=\"hidden\" name=\"status\" id=\"status\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\t<input type=\"hidden\" name=\"sStyle\" id=\"sStyle\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t<input type=\"hidden\" name=\"fr_team_id\" id=\"fr_team_id\" value=\"\">\n\t<input type=\"hidden\" name=\"prefered_date\" id=\"prefered_date\" value=\"\">\t\n\t<input type=\"hidden\" name=\"patient_gender\" id=\"patient_gender\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t<input type=\"hidden\" name=\"gender\" id=\"gender\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t<input type=\"hidden\" name=\"age\" id=\"age\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\t<input type=\"hidden\" name=\"year\" id=\"year\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t<input type=\"hidden\" name=\"dateofbirth\" id=\"dateofbirth\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t<input type=\"hidden\" name=\"DOB\" id=\"DOB\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t<input type=\"hidden\" name=\"blng_serv_code\" id=\"blng_serv_code\" value=\"\">\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t<input type=\"hidden\" name=\"continue_yn\" id=\"continue_yn\" value=\"\">\n\t<input type=\"hidden\" name=\"book_conf_yn\" id=\"book_conf_yn\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\">\n\t<input type=\"hidden\" name=\"book_ref_no\" id=\"book_ref_no\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t<input type=\"hidden\" name=\"sysdate\" id=\"sysdate\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t<input type=\"hidden\" name=\"porterage_hid\" id=\"porterage_hid\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t<input type=\'hidden\' name=\'to_nursing_unit_locn_type\' id=\'to_nursing_unit_locn_type\' value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\t\n\t<input type=\"hidden\" name=\"bed_class_allowed\" id=\"bed_class_allowed\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n\t<input type=\"hidden\" name=\"change_bed_class_yn\" id=\"change_bed_class_yn\" value=\"\">\n\t<input type=\"hidden\" name=\"to_bed_class_code_val\" id=\"to_bed_class_code_val\" value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\">\n\t<input type=\"hidden\" name=\"ipparam_bed_yn\" id=\"ipparam_bed_yn\" value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\">\n\t<input type=\"hidden\" name=\"deactivate_pseudo_bed_yn\" id=\"deactivate_pseudo_bed_yn\" value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\">\n\t<input type=\"hidden\" name=\"allow_multiple_bed_for_resv_yn\" id=\"allow_multiple_bed_for_resv_yn\" value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\">\n\t<input type=\"hidden\" name=\"reserve_bed_on_tfr_yn\" id=\"reserve_bed_on_tfr_yn\" value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n\n\t<input type=\"hidden\" name=\"accomp_person\" id=\"accomp_person\" value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\"><!--Added by Thamizh selvi on 16th May 2017 for ML-MMOH-CRF-0617-->\n\n";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t<input type=\"hidden\" name=\"booking_ref_no\" id=\"booking_ref_no\" value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\">\n\t<input type=\"hidden\" name=\"pat_check_in_allowed_yn\" id=\"pat_check_in_allowed_yn\" value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\">\n\t<input type=\'hidden\' name=\'to_bed_class\' id=\'to_bed_class\' value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\">\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\'Transfer_In\'>\n\t<input type=\"hidden\" name=\"mother_bed_status\" id=\"mother_bed_status\" value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\">\n\t<input type=\"hidden\" name=\"mother_status\" id=\"mother_status\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\"> \n\t<input type=\"hidden\" name=\"res_nurs_unit_code\" id=\"res_nurs_unit_code\" value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\">\n\t<input type=\"hidden\" name=\"res_room_no\" id=\"res_room_no\" value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\">\n\t<input type=\"hidden\" name=\"res_bed_no\" id=\"res_bed_no\" value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n\t<input type=\"hidden\" name=\"reserve_nurs_unit_code\" id=\"reserve_nurs_unit_code\" value=\"\">\n\t<input type=\"hidden\" name=\"reserve_room_no\" id=\"reserve_room_no\" value=\"\">\n\t<input type=\"hidden\" name=\"reserve_bed_no\" id=\"reserve_bed_no\" value=\"\">\n\t<input type=\"hidden\" name=\"confirm_yn\" id=\"confirm_yn\" value=\"N\">\n\t<input type=\"hidden\" name=\"is_to_bed_equals_reserve_bed\" id=\"is_to_bed_equals_reserve_bed\" value=\"N\">\n\t<input type=\"hidden\" name=\"reserve_specialty_code\" id=\"reserve_specialty_code\" value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\n\t<input type=\"hidden\" name=\"reserve_practitioner_id\" id=\"reserve_practitioner_id\" value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n\t<input type=\"hidden\" name=\"reserve_bed_type_code\" id=\"reserve_bed_type_code\" value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n\t<input type=\"hidden\" name=\"reserve_service_code\" id=\"reserve_service_code\" value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n\t<input type=\"hidden\" name=\"reserve_bed_class_code\" id=\"reserve_bed_class_code\" value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\">\n\t<input type=\"hidden\" name=\"exp_discharge_date_time\" id=\"exp_discharge_date_time\" value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\">\n\t\n\t";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t<input type=\'hidden\' name=\'Bedcode\' id=\'Bedcode\' value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\">\n\t<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\'Transfer_Out\'>\n\t<input type=\"hidden\" name=\"mother_status\" id=\"mother_status\" value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\">\n\t<input type=\"hidden\" name=\"mother_bed_status\" id=\"mother_bed_status\" value=\"\">\n\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t<input type=\"hidden\" name=\"to_bed_no_val\" id=\"to_bed_no_val\" value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\">\n\t<input type=\"hidden\" name=\"to_room_no_val\" id=\"to_room_no_val\" value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\n\t<input type=\"hidden\" name=\"req_bed_type_code\" id=\"req_bed_type_code\" value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\">\n\t<input type=\"hidden\" name=\"max_period\" id=\"max_period\" value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n\t<input type=\"hidden\" name=\"without_booking\" id=\"without_booking\" value=\"\">\n\t<input type=\"hidden\" name=\"to_daily_rate\" id=\"to_daily_rate\" value=\"0\">\t\n\t<input type=\"hidden\" name=\"transfer_date\" id=\"transfer_date\" value=\"\">\n\t<input type=\"hidden\" name=\"transfer_type\" id=\"transfer_type\" value=\"\">\n\t<input type=\"hidden\" name=\"to_subservice_desc\" id=\"to_subservice_desc\" value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\">\n\t<input type=\"hidden\" name=\"to_subservice_code\" id=\"to_subservice_code\" value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n\t<input type=\"hidden\" name=\"tobedtype\" id=\"tobedtype\" value=\"\">\n\t<input type=\"hidden\" name=\"to_bed_type\" id=\"to_bed_type\" value=\"\">\n\t<input type=\"hidden\" name=\"from_daily_rate\" id=\"from_daily_rate\" value=\"0\">\n\t<input type=\"hidden\" name=\"transfer_status\" id=\"transfer_status\" value=\"\">\n\t\n\t<input type=\"hidden\" name=\"port_received_yn1\" id=\"port_received_yn1\" value=\"\">\n\t<input type=\"hidden\" name=\"received1\" id=\"received1\" value=\"\">\t\n\t<input type=\"hidden\" name=\"port_remarks1\" id=\"port_remarks1\" value=\"\">\n\t<input type=\"hidden\" name=\"call_function_name\" id=\"call_function_name\" value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n\t<input type=\"hidden\" name=\"oper_stn_id\" id=\"oper_stn_id\" value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n\t<input type=\"hidden\" name=\"def_nursing_unit\" id=\"def_nursing_unit\" value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\">\n\t<input type=\"hidden\" name=\"frbedclass\" id=\"frbedclass\" value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\">\t\n\t<input type=\"hidden\" name=\"bl_interface_yn\" id=\"bl_interface_yn\" value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\">\n\t<input type=\"hidden\" name=\"bl_operational\" id=\"bl_operational\" value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\">\n\t<input type=\'hidden\' name=\'billing_group_id\' id=\'billing_group_id\' value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\">\n\t<input type=\'hidden\' name=\'billing_group_desc\' id=\'billing_group_desc\' value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\n\t<input type=\'hidden\' name=\'modified_bed_type_code\' id=\'modified_bed_type_code\' value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\">\n\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n\t<input type=\'hidden\' name=\'admission_date\' id=\'admission_date\' value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\">\n\t<input type=\'hidden\' name=\'priority_status\' id=\'priority_status\' value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n\t<input type=\'hidden\' name=\'priority_applicable_yn\' id=\'priority_applicable_yn\' value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\">\n\t<input type=\'hidden\' name=\'temp_blocking_type\' id=\'temp_blocking_type\' value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\n\t<input type=\'hidden\' name=\'temp_blocking_code\' id=\'temp_blocking_code\' value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\">\t\n\t<input type=\'hidden\' name=\'temp_block_period\' id=\'temp_block_period\' value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\">\t\n\t<input type=\'hidden\' name=\'temp_blocked_until_date\' id=\'temp_blocked_until_date\' value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\">\n\t<input type=\'hidden\' name=\'temp_override_yn\' id=\'temp_override_yn\' value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\">\t\n\t<input type=\'hidden\' name=\'modified_date_val\' id=\'modified_date_val\' value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\n\t<input type=\'hidden\' name=\'tfr_req_type\' id=\'tfr_req_type\' value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n\t<input type=\"hidden\" name=\"bed_class_chk\" id=\"bed_class_chk\" value=\"N\">\n\t<input type=\"hidden\" name=\"tfr_req_status\" id=\"tfr_req_status\" value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\">\n\t<input type=\'hidden\' name=\'res_bed_no\' id=\'res_bed_no\' value=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\">\n\t<input type=\'hidden\' name=\'res_room_no\' id=\'res_room_no\' value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\">\n\t<input type=\'hidden\' name=\'res_nursing_unit\' id=\'res_nursing_unit\' value=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\">\n\t<input type=\'hidden\' name=\'r_bed_no\' id=\'r_bed_no\' value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\">\n\t<input type=\'hidden\' name=\'r_room_no\' id=\'r_room_no\' value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\">\n\t<input type=\'hidden\' name=\'r_nursing_unit\' id=\'r_nursing_unit\' value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\">\n\t<input type=\'hidden\' name=\'blocking_period\' id=\'blocking_period\' value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\">\n\t<input type=\'hidden\' name=\'r_nursing_unit_desc\' id=\'r_nursing_unit_desc\' value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\">\t\n\t<input type=\'hidden\' name=\'blocking_remarks\' id=\'blocking_remarks\' value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">\t\n\t<input type=\'hidden\' name=\'reserve_reason_code\' id=\'reserve_reason_code\' value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\t\n\t<input type=\'hidden\' name=\'pseudo_bed\' id=\'pseudo_bed\' value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\">\t\n\t<input type=\'hidden\' name=\'reserved_bed_cont\' id=\'reserved_bed_cont\' value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\">\t\n\t<input type=\'hidden\' name=\'transfer_wo_delink_yn\' id=\'transfer_wo_delink_yn\' value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\t\n\t\n\t<!--Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start-->\n\t<input type=\'hidden\' name=\'informed_dtls_yn\' id=\'informed_dtls_yn\' value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\">\n\t<input type=\'hidden\' name=\'autoCnrmTfrReq\' id=\'autoCnrmTfrReq\' value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n\t<!--End-->\n\n\t<!--below line added for this CRF GHL-CRF-0340 -->\n\t <input type=\"hidden\" name=\"specialtyCheck\" id=\"specialtyCheck\" value=\"0\">  \n     <input type=\"hidden\" name=\"practitionerCheck\" id=\"practitionerCheck\" value=\"0\"> \t \n\t <!--End GHL-CRF-0340 -->\n\t \n\t <input type=\"hidden\" name=\"isArrivalDateAppl\" id=\"isArrivalDateAppl\" value=\"\"> <!-- added by mujafar for ML-MMOH-CRF-1136 -->\n\t <input type=\"hidden\" name=\"arrival_date\" id=\"arrival_date\" value=\"\"> <!-- added by mujafar for ML-MMOH-CRF-1136 -->\n\t\n\n\t<!-- <a name=\"addr\" tabindex=\'0\'></a>  -->\n\t</div>\n\t<div id =\"Other\" style = \'display:none\'>\n\n\t<ul id=\"tablist\" class=\"tablist\">\n\t\t<li class=\"tablistitem\" title=\"Occupancy Details\">\n\t\t\t<a onclick=\"expandCollapse(\'Occupancy_Details\')\"  class=\"tabA\" id=\"Occu_tab1\" ><span class=\"tabAspan \" id=\"Occup_tabspan1\">";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Other Details\">\n\t\t\t<a onclick=\"expandCollapse(\'other_details\')\" class=\"tabClicked\" id=\"Oth_tab1\" ><span class=\"tabSpanclicked \" id=\"othe_tabspan1\">";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t\t<li class=\"tablistitem\" title=\"Porterage Details\">\n\t\t\t<a onclick=\"expandCollapse(\'porterage_details\')\" class=\"tabA\" id=\"Port_tab1\" ><span class=\"tabAspan\" id=\"port_tabspan1\">";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="</span>\n\t\t\t</a>\n\t\t</li>\n\t</ul>\n\t";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\t\n\t";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\n<!--Tuesday, June 29, 2010 , modified for PMG20089-CRF-0851-IN022285 ,frpract_id &  frpract_desc added to default Transferring Practitioner with Attending Practitioner -->\n\t</div>\n\n\n\t<div id =\"Porterage\" style = \'display:none\'>\n\t<!-- <a name=\"tab3\" tabindex=\'0\'></a> --> \n\t\n\t<script>\n\tvar arguments\t= document.forms[0].porterage_hid.value;\n\t/*\n\tvar isShift = false;\nfunction setShift(){\n\t\tvar keyCode=window.event.keyCode;\n\t\tif(keyCode == 16) isShift=true;\n\t}\n\nfunction shift_tab(){\n\t\tvar keyCode=window.event.keyCode;\n\t\tif(keyCode == 9 && isShift == true){\n\t\tparent.frames[5].button_s.focus();\n\t\n\t\t}\n\t\t\n\t}\n*/\n\tfunction reserve_bed(){\n\t\tif(\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\"==\"N\")\n\t\t\t{\n\t\t\tdocument.forms[0].nursing_unit_desc.focus();\n\t\t\t}\n\t}\n\nfunction cancelreason(){\n\tif(\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\"==\"N\"){\nif(parent.frames[1].document.forms[0].transfer_in_status.value==\'02\'){\nparent.frames[5].button_s.focus();\n}\n}\n}\n\nfunction cancelreason1()\n\t{\n\tvar keyCode=window.event.keyCode;\n\tvar transfer_in_status =parent.frames[1].document.forms[0].transfer_in_status.value\n\tif(keyCode == 9 ){\n\t\t\tif(\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\"==\"N\"){\n    if(parent.frames[1].document.forms[0].transfer_in_status.value==\"\"){\n    parent.frames[5].button_s.focus();\n  }\n }\n }\n}\n/*\nfunction DisabledTab(obj){\n\tvar keyCode=window.event.keyCode;\n\t\n\t\tif(obj.disabled==true){\n\t\t\t//if(keyCode == 9 ){\n\t\t\t\n\t\t\tparent.frames[5].button_s.focus();\n\n\t\t//}\n\t}\n}\n*/\n\t</script>\n\t";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\n\t\n\t</div>\n\n";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\n\t\t\t\t<script>\n\t\t\t\t\tdocument.forms[0].auth_date_time.value = parent.Transfer_frame.document.forms[0].pref_date.value;\n\t\tif(parent.frames[2].document.forms[0].nursing_unit_desc.value == \"\")\n\t\t\t\t{\n\t\t\t\tif(parent.frames[2].document.forms[0].bed_change!=null)\n\t\t\t\t\tparent.frames[2].document.forms[0].bed_change.disabled = true;\n\t\t\t\t}\n\t\t\t\t</script>\n\t";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\n\t \n<script>\n\tenabledDisabled();\n\tparent.frames[2].src = \"../../eCommon/html/blank.html\";\n</script>\n\n</form>\n<script>\nsetDesable();\n</script>\n</body>\n</html>\n";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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

request.setCharacterEncoding("UTF-8");
String locale			= "";
String sStyle			= "";

 
            _bw.write(_wl_block1Bytes, _wl_block1);
 sStyle				= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	Connection con		= null;
	Statement stmt		= null;
	ResultSet rset		= null;
	Statement stmt1		= null;
	ResultSet rs1		= null;
	Statement medstmt	= null;
	ResultSet medrs		= null;
	PreparedStatement pstmt = null ;
	StringBuffer SqlSB		= new StringBuffer();
	String sel				= "";
	String bed_class_allowed			= "";
	String bl_interfaced_yn				= "";
	String priority_applicable_yn		= "";
	String pat_check_in_allowed_yn		= "";
	String blokcing_type_short_desc		= "";
	String loginUser					= "";
	String facilityId					= "";
	String DOB							= "";
	String patientid					= "";
	String p_oper_stn_id				= "";
	String sdate						= "";
	String eid							= "";
	String frpractitionerid				= "";
	String frpractdesc					= "";
	String frspecialitycode				= "";
	String frspecialitydesc				= "";
	String frbedclass					= "";
	String frbedclassdesc				= "";
	String frnursingunitcode			= "";
	String frnursingunitdesc			= "";
	String frbedno						= "";
	String frroomno						= "";
	String frbedtype					= "";
	String frbedtypedesc				= "";
	String gender						= "";
	String age							= "";
	String frservicecode				= "";
	String frservicedesc				= "";
	String frsubservicecode				= "";
	String frsubservicedesc				= "";
	String patient_class				= "";
	String admission_date				= "";
	String frmeddesc					= "";
	String frteamid						= "";
	String dateofbirth					= "";
	String year							= "";
	String call_function				= "";
	String reserve_bed_on_tfr_yn		= "";
	String allow_multiple_bed_for_resv_yn	= "";
	String pseudo_bed_yn				= "";
	String bl_operational				= "";
	java.text.SimpleDateFormat dateFormat	= null;
	java.util.Date dt					= null;
	String d							= "";
	String min							= "";
	String transfer_wo_delink_yn			= "";//Added for the CRF HSA-CRF-0035
	
	/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
	boolean isCnrmReqPatOutChngAppl	= false;
	String autoCnrmTfrReq			= "N";
	/*End*/
		
	try
	{
		con						= ConnectionManager.getConnection(request);

		Boolean restrictPseudoBed	= CommonBean.isSiteSpecific(con,"IP","RESTRICT_PSEUDO_BED"); //Added by Sangeetha on  23/05/17 for GDOH-CRF-0151
				
		locale					= (String)session.getAttribute("LOCALE");
		loginUser				= checkForNull((String)session.getValue("login_user"));
		facilityId				= checkForNull((String)session.getValue("facility_id"));
		DOB						= checkForNull(request.getParameter("DOB"));
		patientid				= checkForNull(request.getParameter("patient_id"));
		p_oper_stn_id			= checkForNull(request.getParameter("oper_stn_id"));
		sdate					= checkForNull(request.getParameter("sdate"));
		eid						= checkForNull(request.getParameter("encounter_id"));
		frpractitionerid		= checkForNull(request.getParameter("frpractitionerid"));
		frpractdesc				= checkForNull(request.getParameter("frpractdesc"));
		frspecialitycode		= checkForNull(request.getParameter("frspecialitycode"));
		frspecialitydesc		= checkForNull(request.getParameter("frspecialitydesc"));
		frbedclass				= checkForNull(request.getParameter("frbedclass"));
		frbedclassdesc			= checkForNull(request.getParameter("frbedclassdesc"));
		frnursingunitcode		= checkForNull(request.getParameter("frnursingunitcode"));
		frnursingunitdesc		= checkForNull(request.getParameter("frnursingunitdesc"));
		frbedno					= checkForNull(request.getParameter("frbedno"));
		frroomno				= checkForNull(request.getParameter("frroomno"));
		frbedtype				= checkForNull(request.getParameter("frbedtype"));
		frbedtypedesc			= checkForNull(request.getParameter("frbedtypedesc"));
		gender					= checkForNull(request.getParameter("gender"));
		age						= checkForNull(request.getParameter("age"));
		frservicecode			= checkForNull(request.getParameter("frservicecode"));
		frservicedesc			= checkForNull(request.getParameter("frservicedesc"));
		frsubservicecode		= checkForNull(request.getParameter("frsubservicecode"));
		frsubservicedesc		= checkForNull(request.getParameter("frsubservicedesc"));
		patient_class			= checkForNull(request.getParameter("patient_class"));
		admission_date			= checkForNull(request.getParameter("admission_date"));
		frmeddesc				= checkForNull(request.getParameter("frmeddesc"));
		frteamid				= checkForNull(request.getParameter("frteamid"));
		dateofbirth				= checkForNull(request.getParameter("dateofbirth"));
		year					= checkForNull(request.getParameter("year"));
		call_function			= checkForNull(request.getParameter("call_function"));
		pat_check_in_allowed_yn	= checkForNull(request.getParameter("pat_check_in_allowed_yn"),"N");
		reserve_bed_on_tfr_yn	= checkForNull(request.getParameter("reserve_bed_on_tfr_yn"),"N");
		allow_multiple_bed_for_resv_yn	= checkForNull(request.getParameter("allow_multiple_bed_for_resv_yn"),"N");
		pseudo_bed_yn			= checkForNull(request.getParameter("pseudo_bed_yn"),"N");
		transfer_wo_delink_yn			= checkForNull(request.getParameter("transfer_wo_delink_yn"),"N");

		/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
		isCnrmReqPatOutChngAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"IP","AUTO_CNRM_TFR_REQ_PAT_OUT_CHNG");
		autoCnrmTfrReq	= eIP.IPCommonBean.getAutoCnrmTfrReqParam(con,facilityId);
		/*End*/

		bl_operational			= (String)session.getValue("bl_operational");
		String status			= "0";
		long  encounterid		= 0;
		if(!eid.equals(""))
		{
			encounterid			=	Long.parseLong(eid);
		}

		StringBuffer strBuffer		= new StringBuffer();
		String billing_group_id		= "";
		String billing_group_desc	= "";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	dateFormat					= new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
	dt							= new java.util.Date();
	d							= dateFormat.format( dt ) ;
	min							= String.valueOf(dt.getMinutes()) ;
	if(min.length() == 1)   min = "0"+min ;
	d = d + " "+String.valueOf(dt.getHours())+":"+min;
	int block_period			= 0;
	String medcode				= "";
	String meddesc				= "";
	String frpractteamid		= "";
	String priority				= "";
	String tfr_req_type			= "";
	String priority_code		= "N";
	String toNursingUnitCode	= "";
	String toNursingUnit_Desc	= "";
	String toServiceCode		= "";
	String toService_Desc		= "";
	String toSubServiceCode		= "";
	String toSubService_Desc	= "";
	String toSplCode			= "";
	String toSplDesc			= "";
	String toPractId			= "";
	String toPractName			= "";
	String toMedTeam			= "";
	String toMedTeam_Desc		= "";
	String bkgRefNo				= "";
	String colspanValue			= "";
	String to_bed_class_code	= "";
	String to_bed_class_desc	= "";
	String to_bed_no			= "";
	String to_room_no			= "";
	String req_bed_type_code	= "";
	String PRACTITIONER_DESIGNATION = "";
	String to_nursing_unit_locn_type= "";
	String to_bedtypedesc			= "";
	String deactivate_pseudo_bed_yn	= "";
	String dflt_blk_prd_for_tfr_out	= "";
	String bed_block_period_normal	= "";
	String req_bed_type_code_by_defn= "";
	String tfr_req_code				= "";
	String blocking_type			= "";
	String blocked_until_date		= "";
	String blocking_code			= "";
	String block_unit				= "";
	String override_yn				= "";
	String modified_date_val		= "";
	StringBuffer portBuffer=new StringBuffer();
	String mode_of_transport			= "";
	String accomp_person1				= "";
	String accomp_person2				= "";
	String accomp_person3				= "";
	String accomp_person4				= "";
	String accomp_person5				= "";
	String accomp_person6				= "";
	String accomp_person7				= "";
	String equipment1					= "";
	String equipment2					= "";
	String equipment3					= "";
	String equipment4					= "";
	String equipment5					= "";
	String equipment6					= "";
	String equipment7					= "";
	String blood_and_medication1		= "";
	String blood_and_medication2		= "";
	String blood_and_medication3		= "";
	String blood_and_medication4		= "";
	String blood_and_medication5		= "";
	String blood_and_medication6		= "";
	String blood_and_medication7		= "";
	String blood_and_medication8		= "";
	String blood_and_medication9		= "";
	String blood_and_medication10		= "";
	String records_and_documents1		= "";
	String records_and_documents2		= "";
	String records_and_documents3		= "";
	String records_and_documents4		= "";
	String records_and_documents5		= "";
	String patient_belongings1			= "";
	String patient_belongings2			= "";
	String patient_belongings3			= "";
	String patient_belongings4			= "";
	String patient_belongings5			= "";
	String patient_belongings6			= "";
	String patient_belongings7			= "";
	String patient_belongings8			= "";
	String patient_belongings9			= "";
	String patient_belongings10			= "";
	String port_received_yn				= "";
	String port_recd_status				= "";
	String port_recd_remarks			= "";
	String mother_bed_status			= "";
	String reserve_bed_no				= "";
	String reserve_nurs_unit_code		= "";
	String reserve_room_no				= "";
	String reserve_specialty_code		= "";
	String reserve_practitioner_id		= "";
	String reserve_bed_type_code		= "";
	String reserve_service_code			= "";
	String reserve_bed_class_code		= "";
	String tfr_req_status				= "";
	String reserved_nursing_unit		= "";
	String reserved_bed					= "";
	String reserved_room			    = "";
	String r_nursing_unit				= "";
	String r_bed						= "";
	String r_room						= "";
	String blocking_remarks             = "";
	String blocking_type_code           = "";
	String blocking_period	            = "";
	String r_nursing_unit_desc	        = "";
	String exp_discharge_date_time	    = "";
	String prct_Designation			    = "";
	String change_bed_class_yn			= "";
	
	/*Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617 Start*/
	String informed_dtls_mand_yn		= "";
	StringBuffer accompPerson			= new StringBuffer();
	String accomp_person1_desc			= "";
	String accomp_person2_desc			= "";
	String accomp_person3_desc			= "";
	String accomp_person4_desc			= "";
	String accomp_person5_desc			= "";
	String accomp_person6_desc			= "";
	/*End*/

	String reserved_reason_code=""; //thie line added GHL-SCF-794 [IN:047142] 
	
	int mother_status					= 0;
	int reserved_bed_cont				= 0;
	if(bl_operational.equals("Y"))
	{
		String bl_elig = "select a. blng_grp_id, a.short_desc from bl_blng_grp a, bl_episode_fin_dtls b where a.blng_grp_id = b.blng_grp_id and b.operating_facility_id ='"+facilityId+"' and b.episode_id = '"+eid+"'";
		stmt  = con.createStatement();
		rset = stmt.executeQuery(bl_elig);
		while(rset.next())
		{
			billing_group_id = rset.getString("blng_grp_id");
			billing_group_desc = rset.getString("short_desc");
		}
			if(rset	!= null)   rset.close();
			if(stmt  != null)   stmt.close();		
	}	
	int max_period = -1;
	if (strBuffer.length() > 0)		
	strBuffer.delete(0, strBuffer.length());
	/*Tuesday, May 04, 2010 , commented for PE
	stmt  = con.createStatement();
	rset = stmt.executeQuery("select PAT_CHECK_IN_ALLOWED_YN,RESERVE_BED_ON_TFR_YN,allow_multiple_bed_for_resv_yn from ip_param where facility_id='"+facilityId+"' ") ;
	if(rset.next())
	{
		if(rset != null)
		{
			pat_check_in_allowed_yn = rset.getString("pat_check_in_allowed_yn");
			reserve_bed_on_tfr_yn = rset.getString("RESERVE_BED_ON_TFR_YN");
			allow_multiple_bed_for_resv_yn = rset.getString("allow_multiple_bed_for_resv_yn");
			if(pat_check_in_allowed_yn == null) pat_check_in_allowed_yn="N";
			if(reserve_bed_on_tfr_yn == null) reserve_bed_on_tfr_yn="N";
			if(allow_multiple_bed_for_resv_yn == null) allow_multiple_bed_for_resv_yn="N";
		}
	}
		if(rset	!= null)    rset.close();
		if(stmt  != null)   stmt.close();	
	*/
		
	if(reserve_bed_on_tfr_yn.equals("Y") && call_function.equals("TransferPatientIn"))
	{
	
		if(strBuffer.length()>0)	strBuffer.delete(0,strBuffer.length());
		strBuffer.append(" select " );
		strBuffer.append(" a.reserved_nurs_unit_code ");
		strBuffer.append(" ,a.reserved_room_no ");
		strBuffer.append(" ,a.reserved_bed_no ");
		strBuffer.append(" ,a.specialty_code ");
		strBuffer.append(" ,a.admit_practitioner_id ");
		strBuffer.append(" ,a.bed_type_code ");
		strBuffer.append(" ,a.service_code ");
		strBuffer.append(" ,a.bed_class_code ");
		strBuffer.append(" from ");
		strBuffer.append(" ip_open_encounter  a, ");
		strBuffer.append(" ip_reserved_bed_dtl b ");
		strBuffer.append(" where a.facility_id = '"+facilityId+"' ");
		strBuffer.append(" and a.facility_id = b.facility_id ");
		strBuffer.append(" and a.encounter_id = '"+eid+"' ");
		strBuffer.append(" and a.encounter_id = b.encounter_id ");
		strBuffer.append(" and a.reserved_nurs_unit_code = b.reserved_nursing_unit_code ");
		strBuffer.append(" and a.reserved_bed_no =  b.reserved_bed_no ");
		strBuffer.append(" and b.reserved_to_time is null ");
		stmt = con.createStatement() ;
		rset = stmt.executeQuery(strBuffer.toString()) ;
		if(rset != null && rset.next())
		{
			reserve_nurs_unit_code	= checkForNull(rset.getString("reserved_nurs_unit_code"));
			reserve_room_no	= checkForNull(rset.getString("reserved_room_no"));
			reserve_bed_no	= checkForNull(rset.getString("reserved_bed_no"));
			reserve_specialty_code  = checkForNull(rset.getString("specialty_code"));
			reserve_practitioner_id  = checkForNull(rset.getString("admit_practitioner_id"));
			reserve_bed_type_code  = checkForNull(rset.getString("bed_type_code"));
			reserve_service_code  = checkForNull(rset.getString("service_code"));
			reserve_bed_class_code  = checkForNull(rset.getString("bed_class_code"));
		}
		if(rset!=null)rset.close();
		if(stmt!=null)stmt.close();
	}
	change_bed_class_yn			= checkForNull(request.getParameter("change_bed_class_yn"),"N");
	bl_interfaced_yn			= checkForNull(request.getParameter("bl_interfaced_yn"));
	priority_applicable_yn		= checkForNull(request.getParameter("priotity_status"),"N");
	deactivate_pseudo_bed_yn	= checkForNull(request.getParameter("deactivate_pseudo_bed_yn"),"N");
	dflt_blk_prd_for_tfr_out	= checkForNull(request.getParameter("dflt_blk_prd_for_tfr_out"));
	if(!dflt_blk_prd_for_tfr_out.equals(""))
		max_period = Integer.parseInt(dflt_blk_prd_for_tfr_out);
	bed_block_period_normal	= checkForNull(request.getParameter("bed_block_period_normal"));
	if(!bed_block_period_normal.equals(""))
		block_period = Integer.parseInt(bed_block_period_normal);
	bed_class_allowed		= change_bed_class_yn;
	strBuffer.delete(0, strBuffer.length());
	strBuffer.append("select count(*) from ip_transfer_request where tfr_req_status = '1' and encounter_id =");
	strBuffer.append(encounterid);
	strBuffer.append("  and facility_id = '");
	strBuffer.append(facilityId);
	strBuffer.append("' ");
	stmt  = con.createStatement();
	rset  = stmt.executeQuery(strBuffer.toString());
	int nRec=0;
	if(rset.next())
	{
		nRec = rset.getInt(1);
		if(rset	!= null)   rset.close();
		if(stmt  != null)   stmt.close();		
	}

	//Added by kishore on 7/2/2004
	if(call_function.equals("TransferPatientIn"))
	{
		nRec = 1;
	}
	if(nRec>0)
	{
		
		if(call_function.equals("TransferPatientIn"))
		{
		    //Below line modified for SCF GHL-SCF-794 [IN:047142]
					
			strBuffer.delete(0, strBuffer.length());
			strBuffer.append("select a.priority_code, ip_get_desc.ip_transfer_priority(a.facility_id, a.priority_code,'"+locale+"',2) priority_short_desc, a.req_nursing_unit_code nursing_unit_code, ip_get_desc.ip_nursing_unit(a.facility_id, a.req_nursing_unit_code,'"+locale+"',2 ) nursing_unit_short_desc, a.req_service_code service_code, am_get_desc.am_service(a.req_service_code,'"+locale+"',2 ) service_short_desc, a.req_specialty_code specialty_code, am_get_desc.am_speciality(a.req_specialty_code,'"+locale+"',2 ) specialty_short_desc, a.req_practitioner_id practitioner_id, am_get_desc.am_practitioner(a.req_practitioner_id,'"+locale+"',1) practitioner_name, a.tfr_req_type, a.req_subservice_code subservice_code, am_get_desc.am_subservice(a.req_service_code, a.req_subservice_code,'"+locale+"',2 ) subservice_short_desc, a.tfr_req_reason, a.req_team_id team_id, am_get_desc.am_medical_team(a.facility_id,a.req_team_id,'"+locale+"',2) team_short_desc, a.tfr_req_ref_no, a.req_bed_class_code bed_class_code, ip_get_desc.ip_bed_class(a.req_bed_class_code,'"+locale+"',2)bed_class_short_desc, a.req_bed_no bed_no, a.req_room_no room_no, a.req_bed_type_code bed_type_code, ip_get_desc.ip_bed_type(a.req_bed_type_code,'"+locale+"',2 ) bed_type_short_desc, to_char(a.informed_date_time, 'dd/mm/rrrr hh24:mi') informed_date_time, a.informed_name, a.informed_to, a.informed_yn, a.bed_blk_period_hrs, to_char(a.auth_trf_date_time,'dd/mm/rrrr hh24:mi') auth_trf_date_time, a.mode_of_transport, a.accomp_person1, a.accomp_person2, a.accomp_person3, a.accomp_person4, a.accomp_person5, a.accomp_person6, a.accomp_person7,sm_get_desc.sm_appl_user (a.accomp_person1, 'en', 1 ) accomp_person1_desc,sm_get_desc.sm_appl_user (a.accomp_person2, 'en', 1 ) accomp_person2_desc, sm_get_desc.sm_appl_user (a.accomp_person3, 'en', 1 ) accomp_person3_desc, sm_get_desc.sm_appl_user (a.accomp_person4, 'en', 1 ) accomp_person4_desc, sm_get_desc.sm_appl_user (a.accomp_person5, 'en', 1 ) accomp_person5_desc, sm_get_desc.sm_appl_user (a.accomp_person6, 'en', 1 ) accomp_person6_desc, a.equipment1, a.equipment2, a.equipment3, a.equipment4, a.equipment5, a.equipment6, a.equipment7, a.blood_and_medication1, a.blood_and_medication2, a.blood_and_medication3, a.blood_and_medication4, a.blood_and_medication5, a.blood_and_medication6, a.blood_and_medication7, a.blood_and_medication8, a.blood_and_medication9, a.blood_and_medication10, a.records_and_documents1, a.records_and_documents2, a.records_and_documents3, a.records_and_documents4, a.records_and_documents5, a.patient_belongings1, a.patient_belongings2, a.patient_belongings3, a.patient_belongings4, a.patient_belongings5, a.patient_belongings6, a.patient_belongings7, a.patient_belongings8, a.patient_belongings9, a.patient_belongings10, a.port_received_yn, a.port_recd_status, a.port_recd_remarks, 'N' nursing_unit_locn_type, b.attend_practitioner_id from_practitioner_id, am_get_desc.am_practitioner(b.attend_practitioner_id,'"+locale+"',1) from_practitioner_name, b.specialty_code from_specialty_code, am_get_desc.am_speciality(b.specialty_code,'"+locale+"',2 ) from_specialty_short_desc, b.bed_class_code from_bed_class_code, ip_get_desc.ip_bed_class(b.bed_class_code,'"+locale+"',2 ) from_bed_class_short_desc , b.nursing_unit_code from_nursing_unit_code, ip_get_desc.ip_nursing_unit(b.facility_id, b.nursing_unit_code, '"+locale+"', 2) from_nursing_unit_short_desc, b.bed_num from_bed_no, b.room_num from_room_no, b.service_code from_service_code, am_get_desc.am_service(b.service_code,'"+locale+"',2 ) from_service_short_desc, b.subservice_code from_subservice_code, am_get_desc.am_subservice(b.service_code, b.subservice_code,'"+locale+"',2) from_subservice_short_desc, b.team_id from_team_id, am_get_desc.am_medical_team(b.facility_id, b.team_id,'"+locale+"',2) from_team_short_desc, a.delink_baby_yn, a.req_bed_type_code_by_defn, to_char(a.modified_date,'dd/mm/rrrr hh24:mi')  modified_date,a.tfr_req_status,b.reserved_bed_no,b.reserved_room_no,b.reserved_nurs_unit_code,a.blocking_type_code,a.reserve_reason_code,ip_get_desc.ip_blocking_type(a.blocking_type_code,'"+locale+"',2)blokcing_type_short_desc,ip_get_desc.ip_nursing_unit (b.facility_id, b.reserved_nurs_unit_code, '"+locale+"', 2 ) res_nursing_unit_short_desc,to_char(b.exp_discharge_date_time,'dd/mm/rrrr hh24:MI') exp_discharge_date_time ");
			/*Tuesday, May 04, 2010 ,added for PE*/
			strBuffer.append (" ,(select dflt_min_block_period  from ip_blocking_type where blocking_type_code = a.blocking_type_code) dflt_min_block_period ");
			strBuffer.append(" ,(select count(*) m_status from ip_nursing_unit_bed ");
			strBuffer.append(" where ");
			strBuffer.append("  main_bed_no = b.bed_num and occupying_patient_id is not null and facility_id = b.facility_id ");
			strBuffer.append(" and nursing_unit_code = b.nursing_unit_code) m_status ");
			strBuffer.append(" ,(select am_get_desc.am_position(position_code, '"+locale+"',1)practitioner_designation from am_practitioner where  practitioner_id = b.attend_practitioner_id) practitioner_designation  ");
			strBuffer.append(" ,a.blocking_remarks ");
			/*Monday, October 04, 2010 ,if EDD is less than current sysdate and if any bed was reserved before current sysdate and was not released from Release Bed function , reserved bed details will not be available because of condition  blocked_until_date_time > SYSDATE but IP_RESERVED_BED_DTL table having reserved bed data*/
			strBuffer.append(" ,(SELECT COUNT(1) FROM ip_bed_booking WHERE facility_id = b.facility_id AND encounter_id = b.encounter_id AND booking_type = 'N' AND (blocked_until_date_time IS NULL OR blocked_until_date_time > SYSDATE) ) reserved_bed_cont ");
			strBuffer.append (" from ip_transfer_request a, ip_open_encounter b where a.facility_id ='"+facilityId+"' and a.encounter_id = '"+encounterid+"' and a.tfr_req_status = '3' and a.facility_id = b.facility_id and a.encounter_id = b.encounter_id");
		}
		else
		{
			strBuffer.delete(0, strBuffer.length());
			strBuffer.append("select" );
			strBuffer.append(" a.priority_code" );
			strBuffer.append(" , ip_get_desc.ip_transfer_priority(a.facility_id, a.priority_code,'"+locale+"',2) priority_short_desc" );
			strBuffer.append(" , a.req_nursing_unit_code nursing_unit_code" );
			strBuffer.append(" , ip_get_desc.ip_nursing_unit(a.facility_id, a.req_nursing_unit_code,'"+locale+"',2 )nursing_unit_short_desc" );
			strBuffer.append(" , a.req_service_code service_code" );
			strBuffer.append(" , am_get_desc.am_service(a.req_service_code,'"+locale+"',2) service_short_desc" );
			strBuffer.append(" , a.req_specialty_code specialty_code" );
			strBuffer.append(" , am_get_desc.am_speciality(a.req_specialty_code,'"+locale+"',2) specialty_short_desc" );
			strBuffer.append(" , a.req_practitioner_id practitioner_id" );
			strBuffer.append(" , am_get_desc.am_practitioner(a.req_practitioner_id,'"+locale+"',1) practitioner_name" );
			strBuffer.append(" , a.tfr_req_type" );
			strBuffer.append(" , a.tfr_req_type tfr_req_type_desc" );
			strBuffer.append(" , a.req_subservice_code subservice_code" );
			strBuffer.append(" , am_get_desc.am_subservice(a.req_service_code, a.req_subservice_code,'"+locale+"',2 ) subservice_short_desc" );
			strBuffer.append(" , a.req_team_id team_id" );
			strBuffer.append(" , am_get_desc.am_medical_team(a.facility_id, a.req_team_id,'"+locale+"',2) team_short_desc" );
			strBuffer.append(" , b.team_id from_team_id" );
			strBuffer.append(" , a.tfr_req_reason" );
			strBuffer.append(" , am_get_desc.am_medical_team(b.facility_id, b.team_id ,'"+locale+"',2) from_team_short_desc" );
			strBuffer.append(" , a.tfr_req_ref_no" );
			strBuffer.append(" , a.req_bed_class_code bed_class_code" );
			strBuffer.append(" , a.req_bed_no bed_no" );
			strBuffer.append(" , a.req_room_no room_no" );
			strBuffer.append(" , a.req_bed_type_code bed_type_code" );
			strBuffer.append(" , ip_get_desc.ip_bed_type(a.req_bed_type_code,'"+locale+"',2) bed_type_short_desc" );
			strBuffer.append(" , b.attend_practitioner_id from_practitioner_id" );
			strBuffer.append(" , am_get_desc.am_practitioner(b.attend_practitioner_id,'"+locale+"',1) from_practitioner_name" );
			strBuffer.append(" , b.specialty_code from_specialty_code" );
			strBuffer.append(" , am_get_desc.am_speciality(b.specialty_code,'"+locale+"',2) from_specialty_short_desc" );
			strBuffer.append(" , b.bed_class_code from_bed_class_code" );
			strBuffer.append(" , ip_get_desc.ip_bed_class(b.bed_class_code, '"+locale+"', 2) from_bed_class_short_desc" );
			strBuffer.append(" ,  ip_get_desc.ip_bed_class(a.req_bed_class_code,'"+locale+"',2)bed_class_short_desc" );
			strBuffer.append(" , b.nursing_unit_code from_nursing_unit_code" );
			strBuffer.append(" , ip_get_desc.ip_nursing_unit(b.facility_id, b.nursing_unit_code, '"+locale+"', 2) from_nursing_unit_short_desc" );
			strBuffer.append(" , b.bed_num from_bed_no" );
			strBuffer.append(" , b.room_num from_room_no" );
			strBuffer.append(" , b.service_code from_service_code" );
			strBuffer.append(" , am_get_desc.am_service(b.service_code,'"+locale+"',2) from_service_short_desc" );
			strBuffer.append(" , am_get_desc.am_subservice(b.service_code, b.subservice_code,'"+locale+"',2) from_subservice_short_desc" );
			strBuffer.append(" , 'N' nursing_unit_locn_type " );
			strBuffer.append(" , to_char(a.modified_date,'dd/mm/rrrr hh24:mi')  modified_date, a.tfr_req_status " );
			strBuffer.append(",b.reserved_bed_no,b.reserved_room_no,b.reserved_nurs_unit_code,a.blocking_type_code ,ip_get_desc.ip_blocking_type(a.blocking_type_code,'"+locale+"',2)blokcing_type_short_desc,ip_get_desc.ip_nursing_unit (b.facility_id, b.reserved_nurs_unit_code, '"+locale+"', 2 ) res_nursing_unit_short_desc");
			/*Tuesday, May 04, 2010 added for PE*/
			strBuffer.append(",(select dflt_min_block_period  from ip_blocking_type where blocking_type_code=a.blocking_type_code)dflt_min_block_period ");
			strBuffer.append(" ,(select count(*) m_status from ip_nursing_unit_bed ");
			strBuffer.append(" where ");
			strBuffer.append(" main_bed_no = b.bed_num and occupying_patient_id is not null and facility_id = b.facility_id ");
			strBuffer.append(" and nursing_unit_code = b.nursing_unit_code) m_status ");
			strBuffer.append(" ,(select am_get_desc.am_position(position_code, '"+locale+"',1)practitioner_designation from am_practitioner where  practitioner_id = b.attend_practitioner_id) practitioner_designation  ");
			strBuffer.append(" ,a.blocking_remarks ");
			/*Monday, October 04, 2010 ,if EDD is less than current sysdate and if any bed was reserved before current sysdate and was not released from Release Bed function , reserved bed details will not be available because of condition  blocked_until_date_time > SYSDATE but IP_RESERVED_BED_DTL table having reserved bed data*/
			strBuffer.append(" ,(SELECT COUNT(1) FROM ip_bed_booking WHERE facility_id = b.facility_id AND encounter_id = b.encounter_id AND booking_type = 'N' AND (blocked_until_date_time IS NULL OR blocked_until_date_time > SYSDATE) ) reserved_bed_cont ");
			strBuffer.append(" from ");
			strBuffer.append(" ip_transfer_request a" );
			strBuffer.append(" , ip_open_encounter b " );
			strBuffer.append(" where " );
			strBuffer.append(" a.facility_id = '"+facilityId+"' " );
			strBuffer.append(" and a.encounter_id = '"+encounterid+"'" );
			strBuffer.append(" and a.facility_id = b.facility_id " );
			strBuffer.append(" and a.encounter_id = b.encounter_id " );
			strBuffer.append(" and a.tfr_req_status = '1'" );
			status = "1";
		}
		stmt  = con.createStatement();
		rset  = stmt.executeQuery(strBuffer.toString());
		if(rset.next())
		{
			try
			{
				priority_code				=	rset.getString("priority_code")==null?"N":rset.getString("priority_code"); 
				tfr_req_type				=	checkForNull(rset.getString("tfr_req_type"));
				modified_date_val			=	checkForNull(rset.getString("modified_date"));
				priority					=	checkForNull(rset.getString("priority_short_desc"));
				toNursingUnitCode			=	checkForNull(rset.getString("nursing_unit_code"));
				toNursingUnit_Desc			=	checkForNull(rset.getString("nursing_unit_short_desc"));
				toServiceCode				=	checkForNull(rset.getString("service_code"));
				toService_Desc				=	checkForNull(rset.getString("service_short_desc"));
				toSubServiceCode			=	checkForNull(rset.getString("subservice_code"));
				toSubService_Desc			=	checkForNull(rset.getString("subservice_short_desc"));
				toSplCode					=	checkForNull(rset.getString("specialty_code"));
				toSplDesc					=	checkForNull(rset.getString("specialty_short_desc"));
				toPractId					=	checkForNull(rset.getString("practitioner_id"));
				toPractName					=	checkForNull(rset.getString("practitioner_name"));
				PRACTITIONER_DESIGNATION	=	checkForNull(rset.getString("practitioner_designation"));
				toMedTeam					=	checkForNull(rset.getString("team_id"));
				toMedTeam_Desc				=	checkForNull(rset.getString("team_short_desc"));
				bkgRefNo					=	checkForNull(rset.getString("tfr_req_ref_no"));
				to_bed_class_code			=	checkForNull(rset.getString("bed_class_code"));
				to_bed_class_desc			=	checkForNull(rset.getString("bed_class_short_desc"));
				to_bed_no					=	checkForNull(rset.getString("bed_no"));
				to_room_no					=	checkForNull(rset.getString("room_no"));
				req_bed_type_code			=	checkForNull(rset.getString("bed_type_code"));
				to_bedtypedesc				=	checkForNull(rset.getString("bed_type_short_desc"));
				to_nursing_unit_locn_type	=	checkForNull(rset.getString("nursing_unit_locn_type"));
				frpractitionerid			=	checkForNull(rset.getString("from_practitioner_id"));
				frpractdesc					=	checkForNull(rset.getString("from_practitioner_name"));
				frspecialitycode			=	checkForNull(rset.getString("from_specialty_code"));
				frspecialitydesc			=	checkForNull(rset.getString("from_specialty_short_desc"));
				frbedclass					=	checkForNull(rset.getString("from_bed_class_code"));
				frbedclassdesc				=	checkForNull(rset.getString("from_bed_class_short_desc"));
				frnursingunitcode			=	checkForNull(rset.getString("from_nursing_unit_code"));
				frnursingunitdesc			=	checkForNull(rset.getString("from_nursing_unit_short_desc"));
				frbedno						=	checkForNull(rset.getString("from_bed_no"));       
				frroomno					=	checkForNull(rset.getString("from_room_no"));  
				frmeddesc					=	checkForNull(rset.getString("from_team_short_desc"));
				frteamid					=	checkForNull(rset.getString("from_team_id"));
				frservicecode				=	checkForNull(rset.getString("from_service_code"));
				frservicedesc				=	checkForNull(rset.getString("from_service_short_desc"));
				frsubservicedesc			=	checkForNull(rset.getString("from_subservice_short_desc"));
				tfr_req_code				=	checkForNull(rset.getString("tfr_req_reason"));
				tfr_req_status				= checkForNull(rset.getString("tfr_req_status"));
				r_bed						= checkForNull(rset.getString("reserved_bed_no"));
				r_room						= checkForNull(rset.getString("reserved_room_no"));
				r_nursing_unit				= checkForNull(rset.getString("reserved_nurs_unit_code"));
				blocking_type_code          = checkForNull(rset.getString("blocking_type_code"));
				
				blocking_remarks            = checkForNull(rset.getString("blocking_remarks"));
				blokcing_type_short_desc	= checkForNull(rset.getString("blokcing_type_short_desc"));
				r_nursing_unit_desc         = checkForNull(rset.getString("res_nursing_unit_short_desc"));
				blocking_period				= checkForNull(rset.getString("dflt_min_block_period"));
				mother_status				= rset.getInt("m_status");
				prct_Designation			= checkForNull(rset.getString("practitioner_designation"));
				reserved_bed_cont			= rset.getInt("reserved_bed_cont");
				
			}
			catch(SQLException ex)
			{
				
				ex.printStackTrace();
			}
			if(call_function.equals("TransferPatientIn"))
			{	
				mother_bed_status			= checkForNull(rset.getString("delink_baby_yn"));
				req_bed_type_code_by_defn	= checkForNull(rset.getString("req_bed_type_code_by_defn"));
				mode_of_transport			= checkForNull(rset.getString("mode_of_transport"));
				accomp_person1				= checkForNull(rset.getString("accomp_person1"));
				accomp_person2				= checkForNull(rset.getString("accomp_person2"));
				accomp_person3				= checkForNull(rset.getString("accomp_person3"));
				accomp_person4				= checkForNull(rset.getString("accomp_person4"));
				accomp_person5				= checkForNull(rset.getString("accomp_person5"));
				accomp_person6				= checkForNull(rset.getString("accomp_person6"));
				accomp_person7				= checkForNull(rset.getString("accomp_person7"));
				equipment1					= checkForNull(rset.getString("equipment1"));
				equipment2					= checkForNull(rset.getString("equipment2"));
				equipment3					= checkForNull(rset.getString("equipment3"));
				equipment4					= checkForNull(rset.getString("equipment4"));
				equipment5					= checkForNull(rset.getString("equipment5"));
				equipment6					= checkForNull(rset.getString("equipment6"));
				equipment7					= checkForNull(rset.getString("equipment7"));
				blood_and_medication1		= checkForNull(rset.getString("blood_and_medication1"));
				blood_and_medication2		= checkForNull(rset.getString("blood_and_medication2"));
				blood_and_medication3		= checkForNull(rset.getString("blood_and_medication3"));
				blood_and_medication4		= checkForNull(rset.getString("blood_and_medication4"));
				blood_and_medication5		= checkForNull(rset.getString("blood_and_medication5"));
				blood_and_medication6		= checkForNull(rset.getString("blood_and_medication6"));
				blood_and_medication7		= checkForNull(rset.getString("blood_and_medication7"));
				blood_and_medication8		= checkForNull(rset.getString("blood_and_medication8"));
				blood_and_medication9		= checkForNull(rset.getString("blood_and_medication9"));
				blood_and_medication10		= checkForNull(rset.getString("blood_and_medication10"));
				records_and_documents1		= checkForNull(rset.getString("records_and_documents1"));
				records_and_documents2		= checkForNull(rset.getString("records_and_documents2"));
				records_and_documents3		= checkForNull(rset.getString("records_and_documents3"));
				records_and_documents4		= checkForNull(rset.getString("records_and_documents4"));
				records_and_documents5		= checkForNull(rset.getString("records_and_documents5"));
				patient_belongings1			= checkForNull(rset.getString("patient_belongings1"));
				patient_belongings2			= checkForNull(rset.getString("patient_belongings2"));
				patient_belongings3			= checkForNull(rset.getString("patient_belongings3"));
				patient_belongings4			= checkForNull(rset.getString("patient_belongings4"));
				patient_belongings5			= checkForNull(rset.getString("patient_belongings5"));
				patient_belongings6			= checkForNull(rset.getString("patient_belongings6"));
				patient_belongings7			= checkForNull(rset.getString("patient_belongings7"));
				patient_belongings8			= checkForNull(rset.getString("patient_belongings8"));
				patient_belongings9			= checkForNull(rset.getString("patient_belongings9"));
				patient_belongings10		= checkForNull(rset.getString("patient_belongings10"));
				port_received_yn			= checkForNull(rset.getString("port_received_yn"));
				port_recd_status			= checkForNull(rset.getString("port_recd_status"));
				port_recd_remarks			= checkForNull(rset.getString("port_recd_remarks"));
				exp_discharge_date_time     = checkForNull(rset.getString("exp_discharge_date_time"));
				
				reserved_reason_code         = checkForNull(rset.getString("reserve_reason_code"));   //this line added for SCF GHL-SCF-794 [IN:047142]
				
				/*Added by Thamizh selvi on 16th May 2017 for ML-MMOH-CRF-0617 Start*/
				accomp_person1_desc				= checkForNull(rset.getString("accomp_person1_desc"));
				accomp_person2_desc				= checkForNull(rset.getString("accomp_person2_desc"));
				accomp_person3_desc				= checkForNull(rset.getString("accomp_person3_desc"));
				accomp_person4_desc				= checkForNull(rset.getString("accomp_person4_desc"));
				accomp_person5_desc				= checkForNull(rset.getString("accomp_person5_desc"));
				accomp_person6_desc				= checkForNull(rset.getString("accomp_person6_desc"));
				/*End*/
				if(rset	!= null)   rset.close();
				if(stmt  != null)   stmt.close();		
				portBuffer.append(mode_of_transport);
				portBuffer.append("^^");
				portBuffer.append(accomp_person1);
				portBuffer.append("^^");
				portBuffer.append(accomp_person2);
				portBuffer.append("^^");
				portBuffer.append(accomp_person3);
				portBuffer.append("^^");
				portBuffer.append(accomp_person4);
				portBuffer.append("^^");
				portBuffer.append(accomp_person5);
				portBuffer.append("^^");
				portBuffer.append(accomp_person6);
				portBuffer.append("^^");
				portBuffer.append(accomp_person7);
				portBuffer.append("^^");
				portBuffer.append(equipment1);
				portBuffer.append("^^");
				portBuffer.append(equipment2);
				portBuffer.append("^^");
				portBuffer.append(equipment3);
				portBuffer.append("^^");
				portBuffer.append(equipment4);
				portBuffer.append("^^");
				portBuffer.append(equipment5);
				portBuffer.append("^^");
				portBuffer.append(equipment6);
				portBuffer.append("^^");
				portBuffer.append(equipment7);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication1);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication2);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication3);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication4);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication5);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication6);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication7);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication8);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication9);
				portBuffer.append("^^");
				portBuffer.append(blood_and_medication10);
				portBuffer.append("^^");
				portBuffer.append(records_and_documents1);
				portBuffer.append("^^");
				portBuffer.append(records_and_documents2);
				portBuffer.append("^^");
				portBuffer.append(records_and_documents3);
				portBuffer.append("^^");
				portBuffer.append(records_and_documents4);
				portBuffer.append("^^");
				portBuffer.append(records_and_documents5);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings1);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings2);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings3);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings4);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings5);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings6);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings7);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings8);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings9);
				portBuffer.append("^^");
				portBuffer.append(patient_belongings10);
				portBuffer.append("^^");
				portBuffer.append(port_received_yn);
				portBuffer.append("^^");
				portBuffer.append(port_recd_status);
				portBuffer.append("^^");
				portBuffer.append(port_recd_remarks);

				/*Added by Thamizh selvi on 16th May 2017 for ML-MMOH-CRF-0617 Start*/
				accompPerson.append(accomp_person1_desc);
				accompPerson.append("^^");
				accompPerson.append(accomp_person2_desc);
				accompPerson.append("^^");
				accompPerson.append(accomp_person3_desc);
				accompPerson.append("^^");
				accompPerson.append(accomp_person4_desc);
				accompPerson.append("^^");
				accompPerson.append(accomp_person5_desc);
				accompPerson.append("^^");
				accompPerson.append(accomp_person6_desc);
				accompPerson.append("^^");
				/*End*/
			}
		}
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
		if(SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());
		if(call_function.equals("TransferPatientOut"))
		{
			SqlSB.append(" select blocking_type_code, ip_get_desc.ip_blocking_type(blocking_type_code,'"+locale+"',2) blokcing_type_short_desc,");
			SqlSB.append(" block_period, block_units,override_yn ");
			/*Tuesday, May 04, 2010 , added for PE*/
			SqlSB.append(",to_char (decode(block_units,'D',sysdate + block_period,'H',sysdate + block_period / 24), 'dd/mm/rrrr hh24:mi') blocked_until_date, informed_dtls_mand_yn ");//Modified by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617
			SqlSB.append(" from ip_transfer_type_vw where transfer_type_code ='"+tfr_req_code+"' ");
			stmt				   =	con.createStatement();
			rset                   = stmt.executeQuery(SqlSB.toString());
			if (rset.next())
			{
				blocking_code	   = checkForNull(rset.getString("blocking_type_code"));
				blocking_type	   = checkForNull(rset.getString("blokcing_type_short_desc"));
				block_unit		   = checkForNull(rset.getString("block_units"));
				block_period	   = rset.getInt("block_period");
				if(block_unit.equals("D"))
					block_period   =(block_period)*24;
				override_yn		   = checkForNull(rset.getString("override_yn"));
				blocked_until_date = checkForNull(rset.getString("blocked_until_date"));
				informed_dtls_mand_yn = checkForNull(rset.getString("informed_dtls_mand_yn"),"N");//Added by Thamizh selvi on 8th May 2017 for ML-MMOH-CRF-0617
			}
				/*Tuesday, May 04, 2010 commted for PE*/
				/*
				if(!blocking_code.equals(""))
				{
					if(block_period >0 )
					{
						if(block_unit.equals("D"))
						block_period =(block_period)*24;	

						str_block_period = "select to_char((sysdate+'"+block_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual";
						stmt			=	con.createStatement();
						rset = stmt.executeQuery(str_block_period);
						if (rset != null && rset.next())
						{
							blocked_until_date = rset.getString("a");
							if(blocked_until_date==null) blocked_until_date="";
						}
						if(rset !=null) rset.close(); if(stmt != null) stmt.close();
					}
					else
					{
						str_block_period = "select to_char((sysdate+'"+block_period+"'/24),'dd/mm/rrrr hh24:mi') a from dual";
						stmt			=	con.createStatement();
						rset = stmt.executeQuery(str_block_period);
						while(rset.next())
						{
							blocked_until_date = rset.getString("a");
						if(blocked_until_date==null) blocked_until_date="";
						}
						if(rset !=null) rset.close(); if(stmt != null) stmt.close();
					}
				}*/
            _bw.write(_wl_block8Bytes, _wl_block8);
}
	}
	else
	{
		
		if(toServiceCode.equals(""))
			toServiceCode = frservicecode;
		if(toService_Desc.equals(""))
			toService_Desc = frservicedesc;
		if(toSubServiceCode.equals("")) 	
			toSubServiceCode = frsubservicecode;
		if(toSubService_Desc.equals(""))
			toSubService_Desc = frsubservicedesc;
		if(toSplCode.equals(""))
			toSplCode = frspecialitycode;
		if(toSplDesc.equals(""))
			toSplDesc = frspecialitydesc;
		if(toPractId.equals(""))
			toPractId = frpractitionerid;
		if(toPractName.equals(""))
			toPractName = frpractdesc;
		if(toMedTeam.equals(""))			
			toMedTeam = frteamid;
		if(toMedTeam_Desc.equals(""))			
			toMedTeam_Desc = frmeddesc;
		if(to_bed_class_code.equals(""))
		{
			to_bed_class_code=frbedclass;
			to_bed_class_desc=frbedclassdesc;
		}
		if(req_bed_type_code.equals(""))
			req_bed_type_code=frbedtype;
			to_bedtypedesc	=frbedtypedesc;
			/*FS102IPSRRCRF0228V2.0*/
			
			if(strBuffer.length()>0)	strBuffer.delete(0,strBuffer.length());
			strBuffer.append(" select " );
			strBuffer.append(" a.reserved_nurs_unit_code ");
			strBuffer.append(" ,a.reserved_room_no ");
			strBuffer.append(" ,a.reserved_bed_no ");
			strBuffer.append(" ,ip_get_desc.ip_nursing_unit (a.facility_id, a.reserved_nurs_unit_code, '"+locale+"', 2 ) res_nursing_unit_short_desc ");
			/*Monday, October 04, 2010 ,if EDD is less than current sysdate and if any bed was reserved before current sysdate and was not released from Release Bed function , reserved bed details will not be available because of condition  blocked_until_date_time > SYSDATE but IP_RESERVED_BED_DTL table having reserved bed data*/
			strBuffer.append(" ,(SELECT COUNT(1) FROM ip_bed_booking WHERE facility_id = a.facility_id AND encounter_id = a.encounter_id AND booking_type = 'N' AND (blocked_until_date_time IS NULL OR blocked_until_date_time > SYSDATE) ) reserved_bed_cont ");
			strBuffer.append(" from ");
			strBuffer.append(" IP_OPEN_ENCOUNTER  a ");
			strBuffer.append(" ,ip_reserved_bed_dtl b ");
			strBuffer.append(" where a.facility_id = '"+facilityId+"' ");
			strBuffer.append(" and a.encounter_id = '"+eid+"' ");
			strBuffer.append(" and a.facility_id = b.facility_id ");
			strBuffer.append(" and a.encounter_id = b.encounter_id ");
			strBuffer.append(" and a.reserved_nurs_unit_code = b.reserved_nursing_unit_code ");
			strBuffer.append(" and a.reserved_bed_no =  b.reserved_bed_no ");
			stmt = con.createStatement() ;
			rset = stmt.executeQuery(strBuffer.toString()) ;
			if(rset != null && rset.next())
			{
				r_nursing_unit				= checkForNull(rset.getString("reserved_nurs_unit_code"));
				r_room						= checkForNull(rset.getString("reserved_room_no"));
				r_bed						= checkForNull(rset.getString("reserved_bed_no"));
				r_nursing_unit_desc         = checkForNull(rset.getString("res_nursing_unit_short_desc"));
				reserved_bed_cont	        = rset.getInt("reserved_bed_cont");
			}
			if(rset!=null)rset.close();
			if(stmt!=null)stmt.close();
			
			/*FS102IPSRRCRF0228V2.0*/
}

			//Added by kishore on 9/24/2004 for check newborn function
		/*Tuesday, May 04, 2010 ,commented for PE and merged with main query.*/
		
		if(SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());

		SqlSB.append(" select count(*) m_status from ip_nursing_unit_bed ");
		SqlSB.append(" where ");
		SqlSB.append("  main_bed_no = '"+frbedno+"' and occupying_patient_id is not null and facility_id = '"+facilityId+"' ");
		SqlSB.append(" and nursing_unit_code = '"+frnursingunitcode+"' ");
		
		stmt = con.createStatement();
		rset = stmt.executeQuery(SqlSB.toString());
			if(rset != null)
			{
				if(rset.next())
				{
					mother_status = rset.getInt("m_status");
				}
				if(rset	!= null)   rset.close();
				if(stmt  != null)   stmt.close();		
			}
		
	//Getting Operation Station ID for Nursing Unit
	if(SqlSB.length() > 0)
	SqlSB.delete(0, SqlSB.length());

	//11/13/2008 FS102IPSRRCRF0228V2.0
		/*
		String reason_period 	= " select dflt_min_block_period  from ip_blocking_type where blocking_type_code='"+blocking_remarks+"'  ";
			
			stmt = con.createStatement() ;	
			rset = stmt.executeQuery(reason_period.toString());
			
			if( rset != null &&  rset.next())
				{
					blocking_period = checkForNull(rset.getString("dflt_min_block_period"));
				 }
				if(rset!=null) rset.close();
				
		*/
			
		
	//11/13/2008


            _bw.write(_wl_block9Bytes, _wl_block9);
if(call_function.equals("TransferPatientIn"))
	{
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(to_bedtypedesc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(req_bed_type_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(to_bed_class_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(to_bed_class_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
	if(call_function.equals("TransferPatientOut")&& !priority.equals(""))
		{	
            _bw.write(_wl_block15Bytes, _wl_block15);
	}	
            _bw.write(_wl_block16Bytes, _wl_block16);
if(call_function.equals("TransferPatientIn"))
	{
	
            _bw.write(_wl_block17Bytes, _wl_block17);
}
	else
	{
	if(call_function.equals("TransferPatientOut")&& nRec>0){ 
            _bw.write(_wl_block18Bytes, _wl_block18);
if(autoCnrmTfrReq.equals("Y")){
            _bw.write(_wl_block19Bytes, _wl_block19);
}
if(isCnrmReqPatOutChngAppl){
            _bw.write(_wl_block20Bytes, _wl_block20);
}
if(!blocking_type_code.equals("")){
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
}
	else{
            _bw.write(_wl_block23Bytes, _wl_block23);
if(autoCnrmTfrReq.equals("Y")){
            _bw.write(_wl_block19Bytes, _wl_block19);
}
if(isCnrmReqPatOutChngAppl){
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);
if(call_function.equals("TransferPatientIn"))
	{
            _bw.write(_wl_block26Bytes, _wl_block26);
}else 		{
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

			 if(!priority.equals(""))
			 {
		 
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(priority_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block40Bytes, _wl_block40);

			 }
		 
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(frnursingunitdesc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(frnursingunitcode));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(frnursingunitdesc));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
if((nRec==0)){
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(toNursingUnit_Desc));
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block52Bytes, _wl_block52);
if(call_function.equals("TransferPatientOut")){
            _bw.write(_wl_block53Bytes, _wl_block53);
}
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(toNursingUnitCode));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(toNursingUnit_Desc));
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(frservicedesc));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(frservicecode));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(frservicedesc));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
 if((nRec>0)&(call_function.equals("TransferPatientOut"))){
            _bw.write(_wl_block61Bytes, _wl_block61);
}else{
            _bw.write(_wl_block62Bytes, _wl_block62);
}
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
if((nRec!=0))
			{
            _bw.write(_wl_block65Bytes, _wl_block65);

				String service_code = "", service_desc = "";
				
				if(SqlSB.length() > 0)
					SqlSB.delete(0, SqlSB.length());

				SqlSB.append(" select service_code, am_get_desc.am_service(service_code,?,2 ) service_short_desc from ip_nurs_unit_for_service where facility_id = ? ");
				SqlSB.append(" and nursing_unit_code = ? union select service_code, am_get_desc.am_service(service_code,?,2 ) service_short_desc ");
				SqlSB.append(" from ");
				SqlSB.append(" ip_nursing_unit where ");
				SqlSB.append(" facility_id = ? ");
				SqlSB.append(" and nursing_unit_code = ? order by 2 ");
				pstmt = con.prepareStatement(SqlSB.toString());
				pstmt.setString(1,locale);
				pstmt.setString(2,facilityId);
				pstmt.setString(3,toNursingUnitCode);
				pstmt.setString(4,locale);
				pstmt.setString(5,facilityId);
				pstmt.setString(6,toNursingUnitCode);
				rset = pstmt.executeQuery();
				if(rset!=null )
				{
					while(rset.next())
					{
						service_code  = rset.getString("service_code");
						service_desc = rset.getString("service_short_desc");
						
						if (service_code.equals(toServiceCode))
							sel = "selected";
						else
							sel = "";
						out.print("<option value=\""+service_code+"\" "+sel+">"+service_desc+"");
					}
				if(rset	!= null)   rset.close();
				if(pstmt  != null)   pstmt.close();		
				}
			
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(frsubservicedesc));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(frsubservicecode));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(frsubservicedesc));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
if((nRec!=0))
			{
            _bw.write(_wl_block65Bytes, _wl_block65);

				String subsel = "";
				String sersql="";
				String subservice_code = "", subservice_desc = "";
				
				if(nRec>0)
				{
					
					sersql = "select service_code, am_get_desc.am_service(service_code,?,2 )service_short_desc, subservice_code, am_get_desc.am_subservice(service_code,subservice_code,?,2 ) subservice_short_desc from am_facility_subsrvc where operating_facility_id = ? and service_code = ? and eff_status = 'E'";
				}
				else
				{
					sersql = "select service_code,am_get_desc.am_service(service_code,?,2 ) service_short_desc, subservice_code, am_get_desc.am_subservice(service_code,subservice_code,?,2 )subservice_short_desc   from am_facility_subsrvc where operating_facility_id = ? and service_code = ? and eff_status = 'E'";
				}
				pstmt = con.prepareStatement(sersql);
				pstmt.setString(1,locale);
				pstmt.setString(2,locale);
				pstmt.setString(3,facilityId);
				if(nRec>0)
					pstmt.setString(4,toServiceCode);
				else
					pstmt.setString(4,frservicecode);
				rset = pstmt.executeQuery();
				if(rset!=null )
				{
					while(rset.next()){
						subservice_code  = rset.getString("SUBSERVICE_CODE");
						subservice_desc = rset.getString("SUBSERVICE_SHORT_DESC");
						if(nRec>0)
						{						
						if (subservice_code.equals(toSubServiceCode))
							subsel = "selected";
						else
							subsel = "";
						out.print("<option value=\""+subservice_code+"\" "+subsel+">"+subservice_desc+"");
						}
						else
						{
						if (subservice_code.equals(frsubservicecode))
						subsel = "selected";
						else
							subsel = "";
						out.print("<option value=\""+subservice_code+"\" "+subsel+">"+subservice_desc+"");
						}
					}
				if(rset	!= null)   rset.close();
				if(pstmt  != null)   pstmt.close();		
				}
			
            _bw.write(_wl_block70Bytes, _wl_block70);
}
            _bw.write(_wl_block71Bytes, _wl_block71);

	if(bed_class_allowed.equals("Y")&& nRec<=0){
		
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
}
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(colspanValue));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(frbedclassdesc));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(frbedclass));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(frbedclassdesc));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
if(call_function.equals("TransferPatientIn")){
            _bw.write(_wl_block80Bytes, _wl_block80);
} else{
            _bw.write(_wl_block81Bytes, _wl_block81);
}
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

			if(call_function.equals("TransferPatientIn")){
			try{
			//String sql2="Select bed_class_code, short_desc from ip_bed_class_lang_vw where eff_status='E'  and language_id='"+locale+"' order by short_desc ";
			String sql2="Select bed_class_code, ip_get_desc.ip_bed_class(bed_class_code,?,2)short_desc from ip_bed_class where eff_status='E'  order by short_desc ";
			String bedcode="";
			String beddesc="";
			String subsel	="";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1,locale);
			if(to_bed_class_code.equals(""))
				to_bed_class_code=frbedclass;
			rset = pstmt.executeQuery();
				if( rset != null )
				{
			  while( rset.next() )
				  {
					bedcode   = rset.getString("bed_class_code") ;
					 beddesc   = rset.getString("short_desc") ;


					if (bedcode.equals(to_bed_class_code))
						subsel = "selected";
					
					else
						subsel = "";
					out.println("<option value=\""+bedcode+"\" "+subsel+">"+beddesc+"</option>");
					}
				if(rset	!= null)   rset.close();
				if(pstmt  != null)   pstmt.close();		
				}
			}catch(Exception e) 
			{
				
				e.printStackTrace();
			}
		}
	
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(to_bed_class_code));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(frbedtypedesc));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(frbedtypedesc));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(frbedtypedesc));
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(colspanValue));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(frbedno));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(frbedno));
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(to_bed_no));
            _bw.write(_wl_block98Bytes, _wl_block98);
 if(restrictPseudoBed){ 
            _bw.write(_wl_block99Bytes, _wl_block99);
 }
            _bw.write(_wl_block100Bytes, _wl_block100);
 if(restrictPseudoBed){ 
            _bw.write(_wl_block101Bytes, _wl_block101);
 }
            _bw.write(_wl_block102Bytes, _wl_block102);
 if(isCnrmReqPatOutChngAppl && autoCnrmTfrReq.equals("Y")){ 
            _bw.write(_wl_block103Bytes, _wl_block103);
 if(!priority.equals("")|| call_function.equals("TransferPatientIn") || call_function.equals("TransferPatientOut")){ 
            _bw.write(_wl_block104Bytes, _wl_block104);
 } 
            _bw.write(_wl_block70Bytes, _wl_block70);
 }else{ 
            _bw.write(_wl_block103Bytes, _wl_block103);
 if(!priority.equals("")|| call_function.equals("TransferPatientIn")){ 
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block70Bytes, _wl_block70);
 } 
            _bw.write(_wl_block103Bytes, _wl_block103);

						if (!to_bed_no.equals(""))
						{
					
            _bw.write(_wl_block105Bytes, _wl_block105);
            {java.lang.String __page ="OccupiedBedDetails.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("to_room_no"), weblogic.utils.StringUtils.valueOf(to_room_no
                        )},{ weblogic.utils.StringUtils.valueOf("to_bed_no"), weblogic.utils.StringUtils.valueOf(to_bed_no
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block103Bytes, _wl_block103);

						}
					
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(frroomno));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(frroomno));
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(to_room_no));
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(frspecialitydesc));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(frspecialitycode));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(toSplDesc));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(toSplCode));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(toSplDesc));
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(frpractdesc));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(frpractitionerid));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(toPractId));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(toPractName));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(frpractdesc));
            _bw.write(_wl_block127Bytes, _wl_block127);
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(prct_Designation));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(prct_Designation));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(PRACTITIONER_DESIGNATION));
            _bw.write(_wl_block132Bytes, _wl_block132);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(frmeddesc));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(frpractteamid));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block136Bytes, _wl_block136);


					String medValsql = "";
					medValsql		 = "select team_id,am_get_desc.am_medical_team(facility_id, team_id, ?,1) team_short_desc from am_pract_for_team_vw where facility_id = ? and practitioner_id =? and speciality_code = ?";

					pstmt = con.prepareStatement(medValsql);
					pstmt.setString(1,locale);
					pstmt.setString(2,facilityId);
					pstmt.setString(3,toPractId);
					pstmt.setString(4,toSplCode);
					rs1 = pstmt.executeQuery();
					if(rs1!= null)
					{
						while(rs1.next())
						{				
							medcode = rs1.getString("team_id");
							if(medcode == null) medcode="";
							meddesc = rs1.getString("team_short_desc");
							String optSelected="";
							if(medcode.equals(toMedTeam))
								optSelected="selected";
							else
								optSelected="";
							out.println("<option value=\""+medcode+"\"" +optSelected+">"+meddesc+"</option>");							
						}			
					if(rs1	!= null)   rs1.close();
					if(pstmt  != null)   pstmt.close();		
					}					

            _bw.write(_wl_block137Bytes, _wl_block137);

	if(call_function.equals("TransferPatientIn"))
	{
		/*stmt = con.createStatement();
	    String reasonQuery = "select contact_reason_code, contact_reason from am_contact_reason_lang_vw where EFF_STATUS ='E' and cancel_transfer_yn = 'Y' and language_id='"+locale+"' order by contact_reason";
	    rset  = stmt.executeQuery(reasonQuery );*/
	
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(colspanValue));
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            _bw.write(_wl_block142Bytes, _wl_block142);
            _bw.write(_wl_block87Bytes, _wl_block87);
            _bw.write(_wl_block143Bytes, _wl_block143);
            _bw.write(_wl_block144Bytes, _wl_block144);
}
		
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block147Bytes, _wl_block147);
 
	
	if(reserve_bed_on_tfr_yn.equals("Y") && call_function.equals("TransferPatientIn")) {
            _bw.write(_wl_block148Bytes, _wl_block148);
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);
if(!reserved_reason_code.equals("")){
            _bw.write(_wl_block152Bytes, _wl_block152);
}
            _bw.write(_wl_block153Bytes, _wl_block153);
}else if(reserve_bed_on_tfr_yn.equals("Y") && call_function.equals("TransferPatientOut")){
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
if(!blocking_type_code.equals("")){
            _bw.write(_wl_block152Bytes, _wl_block152);
}
            _bw.write(_wl_block156Bytes, _wl_block156);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);

	/*Wednesday, May 05, 2010 , commnted for PE , query will be executed on click of setReserveBedDtls() function*/
	/*	
	try{
			
			stmt = con.createStatement();
			String sqlQuery	= " SELECT  a.BLOCKING_TYPE_CODE, IP_GET_DESC.IP_BLOCKING_TYPE(a.BLOCKING_TYPE_CODE,'"+locale+"','2') SHORT_DESC FROM IP_BLOCKING_TYPE a WHERE  a.ADDED_FACILITY_ID ='"+facilityId+"' AND a.EFF_STATUS = 'E' ORDER BY a.SHORT_DESC ";
			
			
			String reason_code="";
			String reason_desc="";
			rset = stmt.executeQuery(sqlQuery);
			if( rset != null )
				{
				  while(rset.next()){
						reason_code   = rset.getString("BLOCKING_TYPE_CODE") ;
						reason_desc  = rset.getString("SHORT_DESC") ;
						if(blocking_remarks.equals(reason_code))
							out.println("<option value=\""+reason_code+"\" selected>"+reason_desc+"</option>");
						else
							out.println("<option value=\""+reason_code+"\">"+reason_desc+"</option>");
				  }
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
				}
			}catch(Exception e) 
			{
				out.println(e.toString());
				e.printStackTrace();
			}*/
		
	
            _bw.write(_wl_block159Bytes, _wl_block159);
}
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(status));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(age));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(year));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(dateofbirth));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(DOB));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(nRec));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf( bkgRefNo));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(sdate));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(portBuffer.toString()));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(to_nursing_unit_locn_type));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(change_bed_class_yn));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(to_bed_class_code));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(change_bed_class_yn));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(allow_multiple_bed_for_resv_yn));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(reserve_bed_on_tfr_yn));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(accompPerson.toString()));
            _bw.write(_wl_block184Bytes, _wl_block184);
	

if(call_function.equals("TransferPatientIn"))
	{	
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(bkgRefNo));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(to_bed_class_code));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(mother_bed_status));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(mother_status));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(reserve_nurs_unit_code));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(reserve_room_no));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(reserve_bed_no));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(reserve_specialty_code));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(reserve_practitioner_id));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(reserve_bed_type_code));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(reserve_service_code));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(reserve_bed_class_code));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(exp_discharge_date_time));
            _bw.write(_wl_block199Bytes, _wl_block199);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
if(call_function.equals("TransferPatientOut")){
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(to_bed_class_code));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(mother_status));
            _bw.write(_wl_block202Bytes, _wl_block202);
}
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(to_bed_no));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(to_room_no));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(req_bed_type_code));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(max_period));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(toSubService_Desc));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(toServiceCode));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(p_oper_stn_id));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(toNursingUnitCode));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(frbedclass));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(billing_group_id));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(billing_group_desc));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(req_bed_type_code_by_defn));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(admission_date));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(priority_applicable_yn));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(blocking_type));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(blocking_code));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(block_period));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(blocked_until_date));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(override_yn));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(modified_date_val));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(tfr_req_type));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(tfr_req_status));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(reserved_bed));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(reserved_room));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(reserved_nursing_unit));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(r_bed));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(r_room));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(r_nursing_unit));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(blocking_period));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(r_nursing_unit_desc));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(blocking_remarks));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(blocking_type_code));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(pseudo_bed_yn));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(reserved_bed_cont));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(transfer_wo_delink_yn));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(informed_dtls_mand_yn));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(autoCnrmTfrReq));
            _bw.write(_wl_block245Bytes, _wl_block245);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block246Bytes, _wl_block246);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block248Bytes, _wl_block248);
            {java.lang.String __page ="TransferPatientOtherDtlsTab.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("function_name"), weblogic.utils.StringUtils.valueOf(call_function
                        )},{ weblogic.utils.StringUtils.valueOf("frpract_id"), weblogic.utils.StringUtils.valueOf(frpractitionerid
                        )},{ weblogic.utils.StringUtils.valueOf("frpract_desc"), weblogic.utils.StringUtils.valueOf(frpractdesc
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(reserve_bed_on_tfr_yn));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(reserve_bed_on_tfr_yn));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(reserve_bed_on_tfr_yn));
            _bw.write(_wl_block253Bytes, _wl_block253);
            {java.lang.String __page ="PorterageDetailsTab1.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("function_name"), weblogic.utils.StringUtils.valueOf(call_function
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block254Bytes, _wl_block254);
		
		if(call_function.equals("TransferPatientOut"))
			{
	
            _bw.write(_wl_block255Bytes, _wl_block255);
		}

		if(stmt   != null)			stmt.close();
		if(rset	  != null)			rset.close();
		if(rs1	  != null)			rs1.close();
		if(stmt1   != null)			stmt1.close();
		if(medrs	  != null)		medrs.close();
		if(medstmt   != null)		medstmt.close();
	}catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}

	
            _bw.write(_wl_block256Bytes, _wl_block256);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.OccupancyDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PorterageDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.current.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferTo.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NursingUnitDetails.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.subservice.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.subservice.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RequestBedClassChange.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RequestBedClassChange.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PractitionerDesignation.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PractitionerDesignation.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforRejection.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReserveBedDetails.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReserveBed.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReserveBedDetails.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReserveBed.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonforReserveBed.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.OccupancyDetails.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.otherDetails.label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PorterageDetails.label", java.lang.String .class,"key"));
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
}
