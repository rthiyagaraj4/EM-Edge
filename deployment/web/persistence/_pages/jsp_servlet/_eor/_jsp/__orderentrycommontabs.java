package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentrycommontabs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryCommonTabs.jsp", 1739872018000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="<!--IN068314-->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head><title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/></link>\n\t<style>\n\t\t.HIDENEWORDERS\n\t\t{\n\t\t\tdisplay:none;\n\t\t}\n\t</style>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<!--<script language=\"JavaScript\" src=\"../../eOR/js/OrMessages.js\"></script>-->\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryGlobal.js\"></script>\t\n\t<script language=\"JavaScript\" src=\"../../ePH/js/PrescriptionTest.js\"></script><!-- Used for Prescription -->\n\t<script language=\'javascript\' src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\t\t/*\n\t\t *   Script Used here (violation), Need to pass the Query String to the Functions Called,\n\t\t */\n\t\t// To change the Tabs, from the Existing Orders to New Orders or vice versa\n\t\t//function change_common_tab(obj, licence_key, function_from,pharmacy_scope,called_from,multi_called_from,function_id)//Commented for IN071315\n\t\tfunction change_common_tab(obj, licence_key, function_from,pharmacy_scope,called_from,multi_called_from,function_id,p_called_from_ca)//IN071315\n\t\t{ \n\t\t\t\t\n\t\t\t\t//if( (obj==\"NewOrders\" && function_from==\"COPY_ORDER\" && called_from==\"ON_LOAD\")) //IN073695\n\t\t\t\tif( (obj==\"NewOrders\" && (function_from==\"COPY_ORDER\"||function_from==\"HIGH_RISK_ASSESS\") && called_from==\"ON_LOAD\")) //IN073695\n\t\t\t\t{\t\n\t\t\t\t\tcolorChange();\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif((obj==\"ExistingOrders\" && licence_key==\"ORPV\" && called_from==\"ON_LOAD\"))\n\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\t//(licence_key==\"ORPV\") Only For Alrabha Version(Pharmacy Version) to load the Pharamacy Tab\n\t\t\t\t\tcolorChange();\n\t\t\t\t\t//IN041702 - pass pharmacy_scope parameter \n\t\t\t\t\tparent.orderDetailFrame.location.href = \"../../eOR/jsp/OrderEntryByPractitioner.jsp?";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from+\"&pharmacy_scope=\"+pharmacy_scope;\n\t\t\t\t}\n\t\t\t\telse if( obj==\"ExistingOrders\" && (function_from!=\"EXTERNAL_ORDER\" || function_from!=\"MULTI_PATIENT_ORDERS\" || function_from!=\"CP\" || function_from!=\"MO\"|| function_from!=\"REPLACE_ADD\" )  )\n\t\t\t\t{\t\n\t\t\t\t\tif(pharmacy_scope!=\'\' && pharmacy_scope==\'PH\')\n\t\t\t\t\t{\n\t\t\t\t\t\tcolorChange();\n\t\t\t\t\t\t//IN069027 Start.\n\t\t\t\t\t\t//parent.orderDetailFrame.location.href = \"../../eOR/jsp/OrderEntryByPractitioner.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from+\"&pharmacy_scope=\"+pharmacy_scope;\n\t\t\t\t\t\tif(\"Y\"==(document.forms[0].dxChkBfrPlaceOrderSpec.value)){\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tparent.orderDetailFrame.location.href = \"../../eOR/jsp/OrderEntryByPractitioner.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from+\"&pharmacy_scope=\"+pharmacy_scope;\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\talert(getMessage(\"DIAG_NOT_RECORDED\",\"OR\"));\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t//alert(\'Patient Diagnosis not recorded, please complete to proceed further.\');\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\t//IN069027 End.\n\t\t\t\t\t}//Menaka Starts\n\t\t\t\t\telse if(function_id==\'CONT\')\n\t\t\t\t\t{\n\t\t\t\t\t\tcolorChange();\n\t\t\t\t\t\t//IN041702 - pass pharmacy_scope parameter\n\t\t\t\t\t\tparent.orderDetailFrame.location.href = \"../../eOR/jsp/OrderEntryByPractitioner.jsp?";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from+\"&pharmacy_scope=\"+pharmacy_scope;\n\t\t\t\t\t}//Menaka Ends\n\t\t\t\t\telse\n\t\t\t\t\t{\n\n\t\t\t\t\t\tparent.orderDetailFrame.location.href = \"../../eOR/jsp/ExistingOrder.jsp?";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from+\"&function_from=\"+function_from+\"&p_called_from_ca=\"+p_called_from_ca;//Added for IN071315\n\n\t\t\t\t\t\tif(multi_called_from==\"MULTI_PATIENT_ORDER\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(document.OrCommonForm.newOrders)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tdocument.OrCommonForm.newOrders.style.display = \"none\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\n\t\t\t\t\t}\n\t\t\t\t}\t\t\t\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t//IN069027 Start.\t\t\t\t\t\n\t\t\t\t\t//parent.orderDetailFrame.location.href = \"../../eOR/jsp/OrderEntryByPractitioner.jsp?";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from+\"&pharmacy_scope=\"+pharmacy_scope;  //IN041702 - pass pharmacy_scope parameter\n\t\t\t\t\tif( obj==\"NewOrders\" && function_from!=\"AMEND_ORDER\"){\n\t\t\t\t\t\tif(\"Y\"==(document.getElementById(\'dxChkBfrPlaceOrderSpec\').value)){\n\t\t\t\t\t\t\tparent.orderDetailFrame.location.href = \"../../eOR/jsp/OrderEntryByPractitioner.jsp?";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from+\"&pharmacy_scope=\"+pharmacy_scope;\n\t\t\t\t\t\t}else{\t\n\t\t\t\t\t\t\talert(getMessage(\"DIAG_NOT_RECORDED\",\"OR\"));\t\t\t\n\t\t\t\t\t\t\t//alert(\'Patient Diagnosis not recorded, please complete to proceed further.\');\n\t\t\t\t\t\t\tif(\"0\"!=(document.forms[0].newOrdersPosition.value))\n\t\t\t\t\t\t\tchangeColor(document.getElementById(\"existingOrders\"),\"COMMON\");\n\t\t\t\t\t\t}\n\t\t\t\t\t}else{\t\t\t\t\t\n\t\t\t\t\t\tparent.orderDetailFrame.location.href = \"../../eOR/jsp/OrderEntryByPractitioner.jsp?";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&licence_key=\"+licence_key+\"&called_from=\"+called_from+\"&pharmacy_scope=\"+pharmacy_scope;\n\t\t\t\t\t}\n\t\t\t\t\t//IN069027 End.\n\t\t\t\t}\n\n\t\t\t\tif(top.content)\n\t\t\t\t\ttop.content.messageFrame.location.href = \"../../eCA/jsp/error1.jsp\";\n\t\t\t\n\t\t}\n\n\t\tfunction colorChange() \n\t\t{\n\t\t\tif(document.OrCommonForm.existingOrders)\n\t\t\t\tdocument.OrCommonForm.existingOrders.className  = \"CAFIRSTSELECTHORZ\";\n\t\t\tif(document.OrCommonForm.newOrders)\n\t\t\t\tdocument.OrCommonForm.newOrders.className\t\t= \"CASECONDSELECTHORZ\";\n\t\t}\n\n\t</script>\n\t<STYLE TYPE=\"text/css\"></STYLE>\n </head>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\t\t\n\t\t\t<body onLoad=\"change_common_tab(\'ExistingOrders\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\',\'ON_LOAD\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\')\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"><!--Menaka--><!-- p_called_from_ca add for 71315 -->\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\n\t\t\t<body onLoad=\"change_common_tab(\'NewOrders\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\"  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"><!-- Menaka --><!--IN041702 included pharmacy_scope & function_id--> <!-- p_called_from_ca add for 71315 -->\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n<!--<form name=\"commonTab\" id=\"commonTab\">-->\n<form name=\"OrCommonForm\" id=\"OrCommonForm\">\n\t<table id=\"tab\" name=\"tab\" cellspacing=0 cellpadding=\"0\" border=\"0\" align=center width=\"100%\">\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<tr>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<td id=\"existingOrders\" class=\"CAFIRSTSELECTHORZ\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"changeColor(this,\'COMMON\')\" nowrap>\n\t\t\t\t\t<a style=\'color:white;cursor:pointer\' href=\"javascript:change_common_tab(\'ExistingOrders\',\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'\',\'ON_CLICK\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\')\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t</a>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<td id=\"newOrders\" class=\"CASECONDSELECTHORZ\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"changeColor(this,\'COMMON\')\" nowrap>\n                <a style=\'color:white;cursor:pointer\' href=\"javascript:change_common_tab(\'NewOrders\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')\">\n                    ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n                </a>\n            </td>\n            <input type=\"hidden\" id=\"newOrdersPosition\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"/> <!-- IN069027 -->\n            ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\t\t\t\n\t\t<td class=\"LABEL\" width=\"100%\"></td>\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t<!-- IN061988 Below line newly add patient_class and encountier_id parameters in callDrugProfile function -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" \n\t\t\t\t\t<td  style=\"background-color: white; padding-left: 2px; border: 2px solid #000000;border-right: none;border-bottom: 1px solid #e00000;\"  >\n\t\t\t\t\t<input type=\"button\" name=\"drug_profile\" id=\"drug_profile\" class=\"BUTTON\" value =\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" onClick=\'callDrugProfile(\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\",\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\")\'  >\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t<td style=\"background-color: white;border: 2px solid #000000; border-right: none; border-bottom: 1px solid #000000; border-left: none;\">\n\t\t\t\t\t<input type=\"button\" name=\"allergies\" id=\"allergies\" class=\"BUTTON\" value =\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" onClick=\'callAllergies(\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\")\' ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" >\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  style=\"background-color: white;border: 2px solid #000000; border-right: none; border-bottom: 1px solid #000000; border-left: none;\">\n\t\t\t\t\t<input type=\'button\' name=\'active\' id=\'active\' class=\'BUTTON\' value =\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' onClick=\'callActive(\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =">\n\t\t\t\t\t</td>\n\t\t\t\t\t<td style=\"background-color: white; padding-right: 2px; border: 2px solid #000000; border-bottom: 1px solid #000000; border-left: none;\">\n\t\t\t\t\t<input type=\'button\' name=\'demographic\' id=\'demographic\' class=\'BUTTON\' value =\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' onClick=\'callDemographic(\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =">\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t</tr>\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<script>\n\t\t\t\talert(getMessage(\"OR_MODULE_INSTALL\",\"OR\"));\n\t\t\t\tdocument.location.href = \"../../eCommon/html/blank.html\";\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t</table>\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\"hidden\" name=\"bed_num\" id=\"bed_num\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"hidden\" name=\"room_num\" id=\"room_num\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"\"><!-- Used to identify from which tab(Lab,Radiology,Treatment) it is currently used,  -->\n\t<input type=\"hidden\" name=\"ph_load_yn\" id=\"ph_load_yn\" value=\"\"><!-- Used by Pharmacy Module(To identify if it is coming inside the Pharmacy Orders,first time) -->\n\t<input type=\"hidden\" name=\"ph_priority\" id=\"ph_priority\" value=\"\"><!-- Used by Pharmacy Module(To identify if it is coming inside the Pharmacy Orders,first time) -->\n\t<input type=\"hidden\" name=\"ph_order_date_time\" id=\"ph_order_date_time\" value=\"\"><!-- Used by Pharmacy Module(To identify if it is coming inside the Pharmacy Orders,first time) -->\n\t<input type=\"hidden\" name=\"params\" id=\"params\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"ON_LOAD\">\n\t<input type=\"hidden\" name=\"licence_key\" id=\"licence_key\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<input type=\"hidden\" name =\"cnsnt_with_order_yn\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"> <!-- IN057196 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderSpec\" id =\"dxChkBfrPlaceOrderSpec\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderMI\" id =\"dxChkBfrPlaceOrderMI\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderOT\" id =\"dxChkBfrPlaceOrderOT\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderCN\" id =\"dxChkBfrPlaceOrderCN\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderLB\" id =\"dxChkBfrPlaceOrderLB\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderTR\" id =\"dxChkBfrPlaceOrderTR\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderPC\" id =\"dxChkBfrPlaceOrderPC\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderPH\" id =\"dxChkBfrPlaceOrderPH\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderNC\" id =\"dxChkBfrPlaceOrderNC\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderDS\" id =\"dxChkBfrPlaceOrderDS\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderRX\" id =\"dxChkBfrPlaceOrderRX\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderRD\" id =\"dxChkBfrPlaceOrderRD\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderCS\" id =\"dxChkBfrPlaceOrderCS\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"> <!-- IN069027 -->\n\t<input type=\"hidden\" name =\"dxChkBfrPlaceOrderOH\" id =\"dxChkBfrPlaceOrderOH\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"> <!-- IN072036 -->\n</form>\n</body>\n</html> \n\n \n\n";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
-----------------------------------------------------------------------
Date       Edit His	tory   Name        	Description
-----------------------------------------------------------------------
?             100         ?           	created
27/08/2013  IN041702   Chowminya G     When click at the icon or menu 'Pharmacy Order' the screen will display �??Order screen�??
20/05/2014	IN044502   Nijitha S	   Bru-HIMS-CRF-400	
13/08/2014	IN049419	Ramesh G		An Audit Trail for Additional Information Amendment of Order
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

01/11/2016	IN061988		Vijayakumar K									AAKH-CRF-0088.3 [IN:061988]
27/05/2019	IN069027		Ramesh G										MMS-DM-CRF-0150
14/10/2019  IN071315		Nijitha S       14/10/2019		Ramesh G		GHL-CRF-0607
12/12/2019	IN072036		sivabagyam	 	12/12/2019		Ramesh G      	BSP-SCF-0080
24/02/2019	IN072532		Nijitha S	 	12/12/2019		Ramesh G 		CA-ML-MMOH-CRF-1229/05-Order set category order
23/08/2020	IN073695	 	Durga N			23/08/2020		Ramesh G 		OR-Common-Health Risk Assessment	
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block18Bytes, _wl_block18);
	
	//Added on 21/05/2003
	/*
	 *  Common to make the Button enable or disable
	 */
    String params					= request.getQueryString() ;
   	String bed_num                  = beanQueryObj.checkForNull(request.getParameter("bed_num"),"");
	String room_num                 = beanQueryObj.checkForNull(request.getParameter("room_num"),"");
	String patient_id				= request.getParameter("patient_id");
	String encounter_id				= request.getParameter("episode_id");
	
//	String bean_id 					= "@accessrightbean"+patient_id+encounter_id;
//	String bean_name 				= "eOR.Common.AccessRightBean";
	String multi_bean_id 			= "Or_MultiPatientOrders";
	String multi_bean_name 			= "eOR.MultiPatientOrdersBean";
	String facility_id				= (String)session.getValue("facility_id");
	Properties properties			= (Properties) session.getValue( "jdbc" );
	beanQueryObj.setLanguageId(localeName);	
	//Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	String function_from			= beanQueryObj.checkForNull(request.getParameter("function_from"),"");
	//Added for Bru-HIMS-CRF-400[IN044502] Start	
	String or_bean_id 						= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name 					= "eOR.OrderEntryBean";
	OrderEntryBean bean					= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	bean.setLanguageId(localeName);
	HashMap hmRenewOrders = bean.getRenewOrderIds();
	if(null!=hmRenewOrders && hmRenewOrders.size() > 0){
	bean.setCalledFromFunction("RENEW_ORDER");
	function_from = "RENEW_ORDER";
	}
	//Added for Bru-HIMS-CRF-400[IN044502] End
	//IN049419 Start.	
		String amend_reason = request.getParameter("amendDesc")==null?"":(String)request.getParameter("amendDesc");
		bean.setAmend_reason(amend_reason);
		String amend_auditTrailYN =  bean.getOrderFormatAuditTrailYN();
		bean.setAmend_auditTrailYN(amend_auditTrailYN);
	//IN049419 End.
 	//String ext_bean_id 			= "externalordersbean";
	//String ext_bean_name 			= "eOR.ExternalOrdersBean";
	/* Mandatory checks end */
	/* Initialize Function specific start */
		//AccessRightBean bean 		= (AccessRightBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
//		AccessRightBean  bean		= (AccessRightBean)getBeanObject( bean_id, bean_name, request ) ;
//		bean.clear();
	ArrayList multi_patient_details	=  null;
	if(function_from != null && function_from.equals("MULTI_PATIENT_ORDERS")) 
	{
		MultiPatientOrdersBean multi_bean = (MultiPatientOrdersBean)getBeanObject( multi_bean_id, multi_bean_name, request ) ;
		//MultiPatientOrdersBean multi_bean = (MultiPatientOrdersBean)mh.getBeanObject( multi_bean_id, request,  multi_bean_name ) ;
	//	ExternalOrdersBean ext_bean = (ExternalOrdersBean)mh.getBeanObject( ext_bean_id, request,  ext_bean_name ) ;
	/* Initialize Function specific end */
		multi_patient_details	= multi_bean.getMultiPatientDetails();
		
	}
	String responsibility_id		= (String) session.getValue("responsibility_id");
	String ammend_called_from 		= beanQueryObj.checkForNull(request.getParameter("ammend_called_from"),"");
	String multi_called_from 		= beanQueryObj.checkForNull(request.getParameter("multi_called_from"),"");
	if(!ammend_called_from.equals(""))
		ammend_called_from 			= ammend_called_from.trim();
	if(!multi_called_from.equals(""))
		multi_called_from 			= multi_called_from.trim();
	String relationship_id			= beanQueryObj.checkForNull(request.getParameter("relationship_id"),"");
	String p_called_from_ca			= beanQueryObj.checkForNull(request.getParameter("p_called_from_ca "),"");
	String or_module_install_yn		= beanQueryObj.checkForNull(beanQueryObj.getFacilityModuleInstallYn("OR", facility_id, properties),"N");
 	String ph_module_install_yn		= beanQueryObj.checkForNull(beanQueryObj.getFacilityModuleInstallYn("PH", facility_id, properties),"N");
	//String p_option_function_name	= beanQueryObj.checkForNull(request.getParameter("p_option_function_name"),"");
	String function_id				= beanQueryObj.checkForNull(request.getParameter("function_id"),"ORDERS");
  	// Function_id will be passed from Pharmacy module as "MEDICATION_ADMIN"/"EXTERNAL_ORDERS", IF NOTHING IS PASSED DEFAULT IS ORDERS	
  	String licence_key				= eOR.OR_license_rights.getKey(); // Get the Licence Key from the Class
	String allergy_display_yn 		= "";
	String active_display_yn 		= "";
	String demography_display_yn 	= "";
	//String drug_display_yn			= "X";
	String disabledField			= "";
	String disp_patient_id			= patient_id;
	// Get the Main Tabs (Existing Order/New Order)
	String practitioner_id    		= (String) session.getValue("ca_practitioner_id");
	String login_user               = (String) session.getValue("login_user");
	String patient_class			= beanQueryObj.checkForNull(request.getParameter("patient_class"),"");
//	String practitioner_name		= "";
	String class_name_first			= "";
//	String class_name_second		= "";
	String record[]					= null;
	if (practitioner_id == null || practitioner_id.equals("null") || practitioner_id.equals("")) 
	{
	   String [] practitioner_details = beanQueryObj.getPractitionerDetails(properties, login_user);
	   if (practitioner_details.length == 2) 
		{
	       practitioner_id		= practitioner_details[0];
	    //   practitioner_name	= practitioner_details[1];
	   } // End of practitioner_details length
	} // end of if practitioner_id
	ArrayList MainTabsHdg		= beanQueryObj.getMainTabs(properties, practitioner_id, patient_class, function_id); 
	String cnsnt_with_order_yn			= beanQueryObj.checkForNull(request.getParameter("cnsnt_with_order_yn"),"N"); //IN057196
	//HashMap hashMapMainsTab		= new HashMap();	
	String pharmacy_scope = beanQueryObj.checkForNull(request.getParameter("p_scope"),"");
	//IN069027 Start.
	HashMap  dxChkBfrPlaceOrderMap=new HashMap();
	dxChkBfrPlaceOrderMap = bean.allowedNewOrders(patient_id,encounter_id,patient_class,facility_id,function_from);
	//IN069027 End.
	//IN068314 Starts
	String episode_type ="";
	if("IP".equals(patient_class))	
		episode_type ="I";
	else if("OP".equals(patient_class))
		episode_type ="O";
	else if("EM".equals(patient_class))
		episode_type ="E";
	else if("DC".equals(patient_class))
		episode_type ="D";	
	
	Connection connection =  null;
	Boolean isfppapplicable= false;//IN068314
	try{
		connection = ConnectionManager.getConnection(request); 
		
		isfppapplicable = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","FPP_APPLICABLE_YN");//IN068314
		}catch(Exception e1){
			e1.printStackTrace();
		}finally{
			if(connection!=null) connection.close();
		}
	if(isfppapplicable && !"EXTERNAL_ORDER".equals(function_from) )//IN072532
		bean.setFpp_patient_yn(bean.getFPPPatientYN(facility_id, episode_type, encounter_id));
	bean.setIsfppapplicable(isfppapplicable);
	//IN068314 Ends
// Till here 21/05/2003

            _bw.write(_wl_block1Bytes, _wl_block1);

	if(MainTabsHdg!=null && MainTabsHdg.size() > 0 ) 
	{
		for(int i=0; i<MainTabsHdg.size(); i++)
		{
			record = (String[])MainTabsHdg.get(i);
			//Put it in the hashmap for the check for the body onload 
			//hashMapMainsTab.put(record[0],record[1]);
			//if(hashMapMainsTab.containsKey("newOrders")) 
				//break; // come out of the loop because , the first one is the New Orders Tab
		//} 
		//if((hashMapMainsTab!=null && hashMapMainsTab.containsKey("existingOrders")) && (!(function_from.equals("AMEND_ORDER") || function_from.equals("EXTERNAL_ORDER") || function_from.equals("COPY_ORDER") || function_from.equals("MULTI_PATIENT_ORDERS") || function_from.equals("CP") || function_from.equals("MO") ||  function_from.equals("REPLACE_ADD") || function_from.equals("RENEW_ORDER"))))
		if((record[0].equalsIgnoreCase("existingOrders")) && (!(function_from.equals("AMEND_ORDER") || function_from.equals("EXTERNAL_ORDER") || function_from.equals("COPY_ORDER") || function_from.equals("MULTI_PATIENT_ORDERS") || function_from.equals("CP") || function_from.equals("MO") ||  function_from.equals("REPLACE_ADD") || function_from.equals("RENEW_ORDER") || function_from.equals("HIGH_RISK_ASSESS"))))
		{ 	
			
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(licence_key));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pharmacy_scope));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(multi_called_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_called_from_ca));
            _bw.write(_wl_block22Bytes, _wl_block22);

		}
		//else if(hashMapMainsTab!=null && hashMapMainsTab.containsKey("newOrders")) 
		else if((record[0].equalsIgnoreCase("newOrders")) && (!(function_from.equals("PASSED_ORDERS")) ) )  
		{
		
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(licence_key));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pharmacy_scope));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(multi_called_from));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_called_from_ca));
            _bw.write(_wl_block24Bytes, _wl_block24);

		} 
	} // End of  MainTabsHdg
}

            _bw.write(_wl_block25Bytes, _wl_block25);

	String location_type 			= request.getParameter("location_type");
	if(location_type!=null && location_type.equalsIgnoreCase("W"))
		location_type	 			= "N";
	String location_code 			= request.getParameter("location_code");
	if(or_module_install_yn.equals("Y"))
	{

            _bw.write(_wl_block26Bytes, _wl_block26);

		if(MainTabsHdg!=null && MainTabsHdg.size() > 0 ) 
		{
			for (int i = 0; i < MainTabsHdg.size(); i++) {
			record = (String[]) MainTabsHdg.get(i);
			class_name_first = "CAFIRSTSELECTHORZ";
    
			if (i == 0 || (function_from.equals("EXTERNAL_ORDER") || function_from.equals("CP") || function_from.equals("MO") || function_from.equals("REPLACE_ADD"))) {
			class_name_first = "CASECONDSELECTHORZ";
			}
    
			if (record[0].equalsIgnoreCase("existingOrders") && 
				!(function_from.equals("AMEND_ORDER") || function_from.equals("EXTERNAL_ORDER") || function_from.equals("MULTI_PATIENT_ORDERS") || function_from.equals("CP") || function_from.equals("MO") || function_from.equals("REPLACE_ADD") || function_from.equals("RENEW_ORDER"))) {
				// Name (record[0] --> Sys_tab_name --> System defined
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(licence_key));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(multi_called_from));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block30Bytes, _wl_block30);

				} else if (record[0].equalsIgnoreCase("newOrders")) {
					if (!(function_from.equals("PASSED_ORDERS") && multi_called_from.equals("MULTI_PATIENT_ORDER"))) {
				
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(licence_key));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(multi_called_from));
            _bw.write(_wl_block32Bytes, _wl_block32);
 if (function_from.equalsIgnoreCase("AMEND_ORDER")) out.println("Amend Orders"); else out.println(record[1]); 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);

        }
    }
}
	   } // End of MainTabsHdg

            _bw.write(_wl_block1Bytes, _wl_block1);
			// To check whether the user has access to view or not , other wise button gets disabled
		if(p_called_from_ca.equals("Y"))
		{
			//if(ph_module_install_yn.equals("Y"))
			//	drug_display_yn		= beanQueryObj.getMenu("PAT_DRUG_PROFILE",responsibility_id,relationship_id);
			allergy_display_yn 		= beanQueryObj.getMenu("ALLERGY_LST",responsibility_id,relationship_id, properties);
			active_display_yn 		= beanQueryObj.getMenu("PROBLEM_LST",responsibility_id,relationship_id, properties);
			demography_display_yn 	= beanQueryObj.getMenu("DEMOGRAPY_VIEW",responsibility_id,relationship_id, properties);
		}			
		
            _bw.write(_wl_block35Bytes, _wl_block35);

			if(multi_patient_details==null || (multi_patient_details!=null && multi_patient_details.size()==1) ) 
			{
				if(multi_patient_details!=null && multi_patient_details.size() > 0)
				{
				  record					= (String[]) multi_patient_details.get(0);
				  disp_patient_id			=  beanQueryObj.checkForNull(record[0],"");	// FIRST One Patient_id, Second --> encounter-id, third-->patient_class
				}
				
            _bw.write(_wl_block36Bytes, _wl_block36);
if(ph_module_install_yn.equals("Y"))
					{
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugProfile.label","common_labels")));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
 } 
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Allergies.label","common_labels")));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disp_patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
if(allergy_display_yn.equals("X")) out.println("DISABLED");
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disabledField));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ActiveProblems.label","common_labels")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disp_patient_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
if(active_display_yn.equals("X")) out.println("DISABLED");
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disabledField));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Demographics.label","common_labels")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disp_patient_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
if(demography_display_yn.equals("X")) out.println("DISABLED");
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(disabledField));
            _bw.write(_wl_block49Bytes, _wl_block49);
 
		} // end of   multi_patient_details

            _bw.write(_wl_block50Bytes, _wl_block50);
} 
	   else 
	   {
	
            _bw.write(_wl_block51Bytes, _wl_block51);
		
		}
		
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(bed_num));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(params));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(licence_key));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(cnsnt_with_order_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderSpec")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderMI")));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderOT")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderCN")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderLB")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderTR")));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderPC")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderPH")));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderNC")));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderDS")));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderRX")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderRD")));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderCS")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf((String)dxChkBfrPlaceOrderMap.get("dxChkBfrPlaceOrderOH")));
            _bw.write(_wl_block75Bytes, _wl_block75);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderEntryTabs.label", java.lang.String .class,"key"));
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
}
