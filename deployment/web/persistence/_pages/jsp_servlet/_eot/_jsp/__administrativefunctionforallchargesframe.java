package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import eOT.*;
import eOR.OrderEntryBillingQueryBean;
import eST.OTTransactionBean;
import eST.*;
import java.sql.*;
import java.sql.ResultSet;
import java.util.HashMap;
import eOR.OrderEntryBillingQueryBean;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __administrativefunctionforallchargesframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AdministrativeFunctionforAllChargesFrame.jsp", 1709120140067L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n   ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n    ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<html>\n\t<head>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n\t\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n\t\t<script Language=\"javascript\" src=\"../../eOT/js/AdministrativeFunctionforAllCharges.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/Sales.js\"></script> \n\t\t<script language=\"Javascript\" src=\"../../framework/js/PopupWindow.js\"></script>\n\t\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script><!--MMS-QH-CRF-0199 -->\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<!--MMS-QH-CRF-0199-->\n<style type=\"text/css\">\t\t\n\t.my_dropdown {\t\t    \n\t    width: 180px ; min-width: 100px; max-width: 200px;\t\t    \n\t}\n\tselect:focus{width:200px !important;}\t\n\t</style>\n\t<!--MMS-QH-CRF-0199-->\n\t<script>\n\t$(document).ready(function() {\n\tvar maxLength = 30;\n\t    $(\'#my_dropdown > option\').text(function(i, text) {\n\t    if (text.length > maxLength) {\n\t        return text.substr(0, maxLength) + \'...\';  \n\t        }\n\t    });\n\t});\n</script>\n<!--MMS-QH-CRF-0199 -->\n\t\t<script language=\"javascript\">\n\t\tvar rightSide_title=getLabel(\"eOT.RightSide.Label\",\"ot\");\n\t\tvar leftSide_title=getLabel(\"eOT.LeftSide.Label\",\"ot\");\n\t\tvar notApplicable_title=getLabel(\"Common.notapplicable.label\",\"common\");\n\t\tvar bilateral_title=getLabel(\"eOT.Bilateral.Label\",\"ot\");\n\t\tvar operation_title=getLabel(\"Common.operation.label\",\"common\");\n\t\tvar sideApplicable_title=getLabel(\"eOT.SideApplicable.Label\",\"ot\");\n\t    var code_pi = new String();\n\t    var code_cons = new String();\n\t    var code_eq = new String();\n\t    var code_ic = new String();\n\t\tvar remarks_value=getLabel(\"Common.remarks.label\",\"common\");\n\t\t//Added by muthu on 6-1-2012\n\t\tvar equip_image=getLabel(\"Common.equipment.label\",\"common\");\n\t\tvar instr_image=getLabel(\"Common.Instrument.label\",\"common\");\n\n\t\tfunction checkEmpty(obj){\n\t\t\tif((obj == null) || (obj == \'\'))\n\t\t\t\tobj=\'&nbsp;\';\n\t\t\treturn obj;\n\t\t}\n\n\t\t//Added by Muthu for RUT-CRF-0057\nfunction openDialogWindow_eq_img(strVal,index,equip_code){\n  var rows = parent.parent.parent.AdminObjectCollect.equipment_rows[index];\n  var equip_code=encodeURIComponent(rows.equip_code);\n var title=encodeURIComponent(getLabel(\"Common.equipment.label\",\"Common\"));\n\tvar xmlDoc = \"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar params = equip_code;\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\"/></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\t\n\txmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=check_Image_flag&equipment_code=\"+equip_code,false);\n\txmlHttp.send(xmlDoc);\t\n\tvar sql_image_flag = trimString(xmlHttp.responseText);\t\n//Newly Added on 12-1-2012\n//RUT-CRF-0091 by MuthuN Starts Here\n\tvar eq_location_array=sql_image_flag.split(\"~BR~\");\n\tloc_eq=encodeURIComponent(eq_location_array[0]); \n\timage_eq=eq_location_array[1];\n\t//RUT-CRF-0091 by MuthuN Ends Here\nif(!sql_image_flag == \"\")\n\t{\n\t\tvar dialogHeight \t\t= \"0\";\n\t\tvar dialogWidth  \t\t= \"40\";\n\t\tvar dialogTop   \t\t= \"200\";\n\t\tvar dialogLeft   \t\t= \"100\";\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\tvar arguments\t\t\t= \"\";\n\t\tvar\tparam=\"image=\"+image_eq + \"&location=\" + loc_eq;\n\t\tretVal=window.showModalDialog(\"../../eOT/jsp/AdminEquipmentFrame.jsp?\"+param,arguments,features);}\n\telse\n\t{\n\t\talert(getMessage(\"NO_RECORD_FOUND\",\"Common\"));\n\t\t//Modified by rajesh for CRF-0057 26-9-12\n\t}\t\n}\n\nfunction openDialogWindow_ic_img(strVal,index,instr_code){\n  var rows = parent.parent.parent.AdminObjectCollect.instrument_rows[index];\n  var instr_code=encodeURIComponent(rows.instr_code);\n  var instr_desc=encodeURIComponent(rows.instr_desc);\n\n\tvar title=encodeURIComponent(getLabel(\"Common.equipment.label\",\"Common\"));\n\tvar xmlDoc = \"\";\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar params = instr_code;\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\"/></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\t\n\txmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=check_CSSD_Image_flag&instr_code=\"+instr_code,false);\n\txmlHttp.send(xmlDoc);\t\n\tvar sql_cssd_image_flag = trimString(xmlHttp.responseText);\n\t//RUT-CRF-0091 by MuthuN Starts Here\n\tvar ins_location_array=sql_cssd_image_flag.split(\"~BR~\");\n\tloc_ic=encodeURIComponent(ins_location_array[0]);\n\timage_ic=ins_location_array[1];\n\t//RUT-CRF-0091 by MuthuN Ends Here\n\t//Modified by Rajesh for CRF-0057 for opening image always\n\tvar dialogHeight \t\t= \"0\";\n\t\tvar dialogWidth  \t\t= \"40\";\n\t\tvar dialogTop   \t\t= \"200\";\n\t\tvar dialogLeft   \t\t= \"100\";\n\t\tvar features\t\t\t= \"dialogTop:\"+dialogTop+\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\tvar arguments\t\t\t= \"\";\n\t\t\n\t\tvar\tparam=\"instr_code=\"+instr_code+\"&instr_desc=\"+instr_desc; \n\t\tparam=param+\"&image=\"+image_ic;\n\t\tparam=param+\"&location=\"+loc_ic;\n\t\tretVal=window.showModalDialog(\"../../eOT/jsp/AdminInstrumentFrame.jsp?\"+param,arguments,features);\n\t//Modified by Rajesh for CRF-0057 for opening image always\n}\t//Added by Muthu for RUT-CRF-0057\n\t\n\t\tfunction createTable_pi()\n\t\t{   \n\t\tvar rows=parent.parent.parent.AdminObjectCollect.implants_rows;\n\t\tvar st_interface_flag=document.forms[0].st_interface_flag.value;\n\t\tvar implant_entry_cmp_yn=localTrimString(document.forms[0].implant_entry_cmp_yn.value);\n\t\tvar tab_data=\"\";\n\t\ttab_data=\"<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\"\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\"\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\"\n\t\tif(st_interface_flag==\'Y\')\n\t    {\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\"\n\t\t}\n\t\tif(st_interface_flag==\"N\")\n\t\t{\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\"\n\t\t}\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\";\n\t\tif(st_interface_flag==\'Y\')\n\t    {\n        tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\" \n\t\t}\n       \n\t    ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\"\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'></td>\"\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\tvar args=\'\';\n        if(rows!=null){\n\t      for(var jj=0;jj<rows.length;jj++) {\n\t\t     if(rows[jj]!=null && rows[jj].db_mode!=\'D\'){\n\t\t\t\targs=jj;\n\t\t\t\tcode_pi+= rows[jj].oper_code+rows[jj].implant_code+\",\";\n\t\t\t    if(jj%2==0)\n\t\t\t     qryVal=\"gridData\";\n\t\t\t   else\n\t\t\t\t qryVal=\"gridData\";\n\n\t\t\t     if(implant_entry_cmp_yn==\"Y\"){  \n\t\t\t       tab_data+=\"<tr>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].oper_desc)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].implant_desc)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].quantity)+\"</td>\";\n\t\t\t\t    if(st_interface_flag==\'Y\')\n\t               {\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].reserved_qty)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].requested_qty)+\"</td>\";\n\t\t\t\t   }\n\t\t\t\t   if(st_interface_flag==\"N\")\n\t\t           {\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].manufacturer)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].batch)+\"</td>\";\n\t\t\t\t   }\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_pi(remarks_value,\'\"+jj+\"\');\\\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</a><input type=\'hidden\' name=\'Stockavail\' id=\'Stockavail\' value=\'\"+rows[jj].Stockavail+\"\'></a></td>\";\n\t\t\t\t   if(st_interface_flag==\"Y\")\n\t\t\t\t   {\n\t\t\t\t    tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].Store_desc)+\"</td>\";\n\t\t\t\t   }\n\t\t\t\t    ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t   var arr = rows[jj].bill_str.split(\"::\");\n                    var inclexcl=\"\";\n\t\t\t\t   var approvalreqd=\"\";\n\t\t\t\t   if(arr[6]==\'S\'){\n\t\t\t\t   if(arr[8]==\"E\" ||arr[8]==\'\' ||arr[8]==\'null\') inclexcl=\"<img src=\'../../eCommon/images/disabled.gif\'  width=\'15px\' align=\'texttop\' ></img>\";\n\t\t\t\t   if(arr[8]==\"I\") inclexcl=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t   if(arr[5]==\"Y\") approvalreqd=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t   if(arr[5]==\"N\") approvalreqd=\"<img src=\'../../eCommon/images/disabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t   }else{\n\t\t\t\t\t   inclexcl=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t   approvalreqd=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t   }\n\t\t\t\t   \n\t\t\t\t  if(arr !=\"\")\n\t\t\t\t{\n\t\t\t\t\t  tab_data+=\"<td  class=gridData><B><font color=\'Indigo\' >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =":&nbsp;\"+arr[0]+\"</font>&nbsp;&nbsp;<font color=\'crimson\'>&nbsp;";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =":&nbsp;\"+arr[1]+\"</font>&nbsp;&nbsp;<font color=\'green\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =":&nbsp;\"+arr[2]+\"</font></B><br>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="?\"+inclexcl+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?\"+approvalreqd+\"\";\n\t\t\t\t}else\n\t\t\t\t  {\n\t\t\t\t  tab_data+=\"<td  class=gridData><B><font color=\'Indigo\' >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =":&nbsp;0.0</font>&nbsp;&nbsp;<font color=\'crimson\'>&nbsp;";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =":&nbsp;0.0</font>&nbsp;&nbsp;<font color=\'green\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =":&nbsp;0.0</font></B><br>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="?\"+inclexcl+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?\"+approvalreqd+\"\";\n\t\t\t\t  }\n\t\t\t\t   if(st_interface_flag==\"N\"){\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:callBillingWindow_pi(\"+jj+\");\\\"><img src=\'../../eOT/images/dollar.png\'></img></a></td>\";\n\t\t\t\t   }else{\n\t\t\t\t\t   var Appr_reqd=arr[5];\n\t\t\t\t\t   var include_exclude=arr[8];\n\t\t\t\t\t   arr[0]=trimString(arr[0]);\n\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><img src=\'../../eOT/images/dollar.png\'></img></a></td>\";\n\t\t\t\t  }\n\t\t\t\t   ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t  tab_data+=\"</tr>\"; \n\t\t\t\t}else\n\t\t\t\t   {\n\t\t\t\t   tab_data+=\"<tr>\";\n\t\t\t\t   \n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:sendparams_pi(\"+args+\");\\\">\"+checkEmpty(rows[jj].oper_desc)+\"</a></td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].implant_desc)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].quantity)+\"</td>\";\n\t\t\t\t   if(st_interface_flag==\'Y\')\n\t               {\n\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].reserved_qty)+\"</td>\";\n\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].requested_qty)+\"</td>\";\n\t\t\t\t   }\n\t\t\t\t   if(st_interface_flag==\"N\")\n\t\t           {\n\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].manufacturer)+\"</td>\";\n\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].batch)+\"</td>\";\n\t\t\t\t   }\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_pi(remarks_value,\'\"+jj+\"\');\\\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</a><input type=\'hidden\' name=\'Stockavail\' id=\'Stockavail\' value=\'\"+rows[jj].Stockavail+\"\'></a></td>\";\n\t\t\t\t   if(st_interface_flag==\"Y\")\n\t\t\t\t   {\n\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows[jj].Store_desc)+\"</td>\";\n\t\t\t\t   }\n\t\t\t ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t   var arr = rows[jj].bill_str.split(\"::\");\n\t\t\t\t\t\n\t\t\t\t   if(arr[6]==\'S\'){\n\t\t\t\t   if(arr[8]==\"E\" ||arr[8]==\'\' ||arr[8]==\'null\') inclexcl=\"<img src=\'../../eCommon/images/disabled.gif\'  width=\'15px\' align=\'texttop\' ></img>\";\n\t\t\t\t   if(arr[8]==\"I\") inclexcl=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t   if(arr[5]==\"Y\") approvalreqd=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t   if(arr[5]==\"N\") approvalreqd=\"<img src=\'../../eCommon/images/disabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t   }else{\n\t\t\t\t\t   inclexcl=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t   approvalreqd=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t   }\n\t\t\t\t  if(arr !=\"\")\n\t\t\t\t  {\n\t\t\t\t  tab_data+=\"<td  class=gridData><B><font color=\'Indigo\' >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="?\"+inclexcl+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?\"+approvalreqd+\"\";\n\t\t\t\t  }\n\t\t\t\t  else{\n\t\t\t\t  tab_data+=\"<td  class=gridData><B><font color=\'Indigo\' >";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="?\"+inclexcl+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?\"+approvalreqd+\"\";\n\t\t\t\t  }\n\t\t\t\t  if(st_interface_flag==\"N\"){\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:callBillingWindow_pi(\"+jj+\");\\\"><img src=\'../../eOT/images/dollar.png\'></img></a></td>\";\n\n\t\t\t\t  }else{\n\t\t\t\t\t   var Appr_reqd=arr[5];\n\t\t\t\t\t   var include_exclude=arr[8];\n\t\t\t\t\t   arr[0]=trimString(arr[0])\n\n\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:callBillingWindow_st(\'\"+jj+\"\',\'\"+Appr_reqd+\"\',\'\"+include_exclude+\"\',\'\"+arr[0]+\"\',\'\"+arr[1]+\"\',\"+arr[2]+\",\'\"+arr[7]+\"\',\'\"+rows[jj].req_store_code+\"\',\'\"+rows[jj].quantity+\"\',\'\"+rows[jj].implant_code+\"\',\'\"+rows[jj].sale_document_no+\"\',  \'\"+rows[jj].sale_document_type+\"\',\'\"+arr[9]+\"\');\\\"><img src=\'../../eOT/images/dollar.png\'></img></a></td>\";\n\t\t\t\t  }\n\t\t\t\t   ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t   tab_data+=\"</tr>\"; \n\t\t\t\t\t}\n\t\t     }\n\t        }\n\t      }\n\t\t document.getElementById(\"menuExpand4\").innerHTML = tab_data;\n\t\t}\n\t\tfunction createTable_cons(){   \t\t\t\t\n\t\t\tvar rows=parent.parent.parent.AdminObjectCollect.packs_rows;\n\t\t\tvar consumable_entry_cmp_yn=localTrimString(document.forms[0].consumable_entry_cmp_yn.value);\n\t\t\tvar tab_data=\"\";\n\t\t\ttab_data=\"<table border=\'1\' cellpadding=0 cellspacing=\'0\' width=\'100%\' align=\'center\'>\"\n\t\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\"\n\t\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</td>\"\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\";\n\t\t\ttab_data+=\"<td class=\'columnHeaderCenter\'></td>\";\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\tvar args=\'\';\n\t\t\tif(rows!=null){\n\t\t\t   for(var jj=0;jj<rows.length;jj++) {\n\t\t\t\t   if(rows[jj]!=null  && rows[jj].db_mode!=\'D\'){\n\t\t\t\t\t\targs=jj;\n\t\t\t\t\t\tcode_cons+= rows[jj].oper_code+rows[jj].package_code+\",\";\n\t\t\t\t\t\tif(jj%2==0)\n\t\t\t\t\t\t qryVal=\"gridData\";\n\t\t\t\t\t   else\n\t\t\t\t\t\t qryVal=\"gridData\";\n\t\t\t\t\t\t if( consumable_entry_cmp_yn==\"Y\") { \n\t\t\t\t\t\t   tab_data+=\"<tr>\";\n\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+rows[jj].oper_desc+\"</td>\";\n\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+rows[jj].package_desc+\"</td>\";\n\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+rows[jj].quantity+\"</td>\";\n\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_cons(remarks_value,\'\"+jj+\"\');\\\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</a></td>\";\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t   var arr = rows[jj].bill_str.split(\"::\");\n\t\t\t\t\t\t\tvar inclexcl=\"\";\n\t\t\t\t\t\t\tvar approvalreqd=\"\";\n\t\t\t\t\t\t\tif(arr[6]==\'S\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(arr[8]==\"E\" ||arr[8]==\'\' ||arr[8]==\'null\') inclexcl=\"<img src=\'../../eCommon/images/disabled.gif\'  width=\'15px\' align=\'texttop\' ></img>\";\n\t\t\t\t\t\t\tif(arr[8]==\"I\") inclexcl=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\tif(arr[5]==\"Y\") approvalreqd=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\tif(arr[5]==\"N\") approvalreqd=\"<img src=\'../../eCommon/images/disabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tinclexcl=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\tapprovalreqd=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t  tab_data+=\"<td  class=gridData><B><font color=\'Indigo\' >";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="?\"+inclexcl+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?\"+approvalreqd+\"\";\n\t\t\t\t\t\t  tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:callBillingWindow_cons(\"+jj+\");\\\"><img src=\'../../eOT/images/dollar.png\'></img></a></td>\";\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t  tab_data+=\"</tr>\"; \n\t\t\t\t\t\t } else {\n\t\t\t\t\t\t   tab_data+=\"<tr>\";\n\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:sendparams_cons(\"+args+\");\\\">\"+rows[jj].oper_desc+\"</a></td>\";\n\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+rows[jj].package_desc+\"</td>\";\n\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+rows[jj].quantity+\"</td>\";\n\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_cons(remarks_value,\'\"+jj+\"\');\\\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t   var arr = rows[jj].bill_str.split(\"::\");\n\t\t\t\t\t\t\tvar inclexcl=\"\";\n\t\t\t\t\t\t\tvar approvalreqd=\"\";\n\t\t\t\t\t\t\tif(arr[6]==\'S\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(arr[8]==\"E\" ||arr[8]==\'\' ||arr[8]==\'null\') inclexcl=\"<img src=\'../../eCommon/images/disabled.gif\'  width=\'15px\' align=\'texttop\' ></img>\";\n\t\t\t\t\t\t\tif(arr[8]==\"I\") inclexcl=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\tif(arr[5]==\"Y\") approvalreqd=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\tif(arr[5]==\"N\") approvalreqd=\"<img src=\'../../eCommon/images/disabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\tinclexcl=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\tapprovalreqd=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t    tab_data+=\"<td  class=gridData><B><font color=\'Indigo\' >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="?\"+inclexcl+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?\"+approvalreqd+\"\";\n\t\t\t\t\t\t  tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:callBillingWindow_cons(\"+jj+\");\\\"><img src=\'../../eOT/images/dollar.png\'></img></a></td>\";\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t   tab_data+=\"</tr>\";\n\t\t\t\t\t\t }\n\t\t\t   }\n\t\t\t }\n\t\t\t}\n\t\t\tdocument.getElementById(\"menuExpand5\").innerHTML = tab_data;\n\t\t}\n\t\t\n\t\tfunction createTable_eq1()\n\t\t{\n\t\t  var equipment_entry_cmp_yn=localTrimString(document.forms[0].equipment_entry_cmp_yn.value);\n\t\t  var customer_id = document.forms[0].customer_id1.value;\n\t\t  var tab_data=\"\";\n          \n\t\t  tab_data+=\"<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\";\n\t\t\t//Added by Muthu for RUT-CRF-0057\n\t\t  tab_data+=\"<td class=\'columnHeaderCenter\'></td>\"\n\t\t\t//Added by Muthu for RUT-CRF-0057\n\t\t  tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\"\n\t\t  tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\";\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\";<!-- 047546 -->\n\t\t  tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\";\n\t\t//Added by MuthuN against RUT-CRF-0091 on 10-05-13 starts here\n\t\tif(customer_id == \"RTN\"){\n\t\t  tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\"\n\t}else{\n\t\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\";\n\t}\n\t//Added by MuthuN against RUT-CRF-0091 on 10-05-13 ends here\n\t\t tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\"; \n\t\t ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t  tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\";\n\t\t  tab_data+=\"<td class=\'columnHeaderCenter\'></td>\";\n\t\t  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\tvar  rows_eq=parent.parent.parent.AdminObjectCollect.equipment_rows;\n              var args3=\'\';\n\t\t\t  if(rows_eq!=null){\n\t\t\t\t   for(var kk=0;kk<rows_eq.length;kk++) {\n\t\t\t\t\t   if(rows_eq[kk]!=null  && rows_eq[kk].db_mode!=\'D\'){\n\t\t\t\t\t\t\targs3=kk;\n\t\t\t\t\t\t\tcode_eq+= rows_eq[kk].oper_code+rows_eq[kk].equip_code+\",\";\n\t\t\t\t\t\t\tif(kk%2==0)\n\t\t\t\t\t\t\t qryVal=\"gridData\";\n\t\t\t\t\t\t   else\n\t\t\t\t\t\t\t qryVal=\"gridData\";\n\t\t\t\t\t\t\tvar remarks=rows_eq[kk].remarks_eq;\n\t\t\t\t\t\t\t if(equipment_entry_cmp_yn==\"Y\") { \n\t\t\t\t\t\t\t\t   tab_data+=\"<tr>\";\n//Added by Muthu for RUT-CRF-0057\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\" javascript:openDialogWindow_eq_img(equip_image,\'\"+kk+\"\',\'\"+rows_eq[kk].equip_code+\"\');\\\"><img src=\'../../eOT/images/nolines_plus.gif\'></img></a></td>\";\n//Added by Muthu for RUT-CRF-0057\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].oper_desc)+\"</td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].equip_desc)+\"</td>\";\n\t\t\t\t\t\t\t   \ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].desiredDate)+\"</td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].quantity)+\"</td>\";\n\t\t\t\t\t\t\t if(customer_id == \"RTN\"){\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t  tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].st_location)+\"</td>\";\n\t\t\t\t\t\t\t  }else{tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].equip_code)+\"</td>\";\n\t\t\t\t\t\t\t  }\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_eq(remarks_value,\'\"+kk+\"\');\\\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</a></td>\";\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\tvar arr = rows_eq[kk].bill_str.split(\"::\");\n\t\t\t\t\t\t\t\tvar inclexcl=\"\";\n\t\t\t\t\t\t\t\tvar approvalreqd=\"\";\n\t\t\t\t\t\t\t\tif(arr[6]==\'S\')\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif(arr[8]==\"E\" ||arr[8]==\'\' ||arr[8]==\'null\') inclexcl=\"<img src=\'../../eCommon/images/disabled.gif\'  width=\'15px\' align=\'texttop\' ></img>\";\n\t\t\t\t\t\t\t\tif(arr[8]==\"I\") inclexcl=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\t\tif(arr[5]==\"Y\") approvalreqd=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\t\tif(arr[5]==\"N\") approvalreqd=\"<img src=\'../../eCommon/images/disabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\t   inclexcl=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\t\t   approvalreqd=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t   tab_data+=\"<td  class=gridData><B><font color=\'Indigo\' >";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="?\"+inclexcl+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?\"+approvalreqd+\"\";\n\t\t\t\t              tab_data+=\"</font></td>\";\n\t\t\t\t\t\t\t  tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:callBillingWindow_eq(\"+kk+\");\\\"><img src=\'../../eOT/images/dollar.png\'></img></a></td>\";\n\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t   tab_data+=\"</tr>\";\n\t\t\t\t\t\t\t   }else {\n\t\t\t\t\t\t\t   tab_data+=\"<tr>\";\n\t\t\t\n//Added by Muthu for RUT-CRF-0057\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\" javascript:openDialogWindow_eq_img(equip_image,\'\"+kk+\"\',\'\"+rows_eq[kk].equip_code+\"\');\\\"><img src=\'../../eOT/images/nolines_plus.gif\'></img></a></td>\";\n//Added by Muthu for RUT-CRF-0057\n\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:sendparams_eq(\"+args3+\");\\\">\"+checkEmpty(rows_eq[kk].oper_desc)+\"</a></td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].equip_desc)+\"</td>\";\n\t\t\t\t\t\t\t   \ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].desiredDate)+\"</td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].quantity)+\"</td>\";\n\t\t\t\t\t\t\t    if(customer_id == \"RTN\"){\n\t\t\t\t\t\t\t\t  tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].st_location)+\"</td>\";\n\t\t\t\t\t\t\t  }else{\n\t\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].equip_code)+\"</td>\";//Added by MuthuN against 39535 on 13/05/2013\n\t\t\t\t\t\t\t  }\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_eq(remarks_value,\'\"+kk+\"\');\\\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="?\"+inclexcl+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?\"+approvalreqd+\"\";\n\t\t\t\t               tab_data+=\"</font></td>\";\n\t\t\t\t\t\t\t  tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:callBillingWindow_eq(\"+kk+\");\\\"><img src=\'../../eOT/images/dollar.png\'></img></a></td>\";\n\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t   tab_data+=\"</tr>\"; \n\t\t\t\t\t\t\t   }\t\t\t \n\t\t\t\t    }\n\t\t\t\t }\n\t\t\t  }\t \n\t\t\t tab_data+=\"</table>\";\n\t\t\t tab_data+=\"</div>\";\n\t\t\t tab_data+=\"</tr>\";\n\t\t\t document.getElementById(\"menuExpand6\").innerHTML = tab_data;\n\t\t}\nfunction createTable_eq()\n{\n\t\t  var equipment_entry_cmp_yn=localTrimString(document.forms[0].equipment_entry_cmp_yn.value);\n\t\t  var customer_id = document.forms[0].customer_id1.value;\n\t\t  var tab_data=\"\";\n          \n\t\t  tab_data+=\"<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\";\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\";\n//Added by MuthuN against RUT-CRF-0091 on 10-05-13 starts here\n\t\tif(customer_id == \"RTN\")\n\t\t{\n\t\t  tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\"\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</td>\";\n\t}\n//Added by MuthuN against RUT-CRF-0091 on 10-05-13 ends here\n\t\t tab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t  /* Added Start Against AMRI-CRF-0294 [IN049121(Header) step-1*/ \n\t\t  tab_data+=\"<td nowrap class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\"  \n\t\t  /* Added End Against AMRI-CRF-0294 [IN049121*/\n\t\t\tvar  rows_eq=parent.parent.parent.AdminObjectCollect.equipment_rows;\n              \t\tvar args3=\'\';\n\t\t\t  if(rows_eq!=null){\n\t\t\t\t   for(var kk=0;kk<rows_eq.length;kk++) {\n\t\t\t\t\t   if(rows_eq[kk]!=null){ //Added Against AMRI-CRF-0294 [IN049121]\n\t\t\t\t\t\t\targs3=kk;\n\t\t\t\t\t\t\tcode_eq+= rows_eq[kk].oper_code+rows_eq[kk].equip_code+\",\";\n\t\t\t\t\t\t\tif(kk%2==0)\n\t\t\t\t\t\t\t qryVal=\"gridData\";\n\t\t\t\t\t\t   else\n\t\t\t\t\t\t\t qryVal=\"gridData\";\n\n\t\t\t\t\t\t\tvar remarks=rows_eq[kk].remarks_eq;\n\t\t\t\t\t\t\t /*Added Start Against 294-CRF*/\t\n\t\t\t\t\t\t\tvar oper_line_status1=rows_eq[kk].oper_line_status; \n\t\t\t\t\t\t\tif(oper_line_status1 == null)  oper_line_status1=\"\";\n\t\t\t\t\t\t\t/*Added End Against 294-CRF*/\n\t\t\t\t\t\t\t if(equipment_entry_cmp_yn==\"Y\") { \n\t\t\t\t\t\t\t\t   tab_data+=\"<tr>\";\n\t\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].oper_desc)+\"</td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].equip_desc)+\"</td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].desiredDate)+\"</td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].quantity)+\"</td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].equip_code)+\"</td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_eq(remarks_value,\'\"+kk+\"\');\\\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t   // Added Against Start AMRI-CRF-0294 [IN049121] step-3\n\t\t\t\t\t\t\t \tif(rows_eq[kk].db_mode==\'D\' || oper_line_status1==\'99\')\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\"><img src=\'../../eCommon/images/RRnwd.gif\'></img></td>\";\n\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t\t// Added Against End AMRI-CRF-0294 [IN049121\n\t\t\t\t\t\t\t   tab_data+=\"</tr>\";\n\t\t\t\t\t\t\t   }else {\n\t\t\t\t\t\t\t   tab_data+=\"<tr>\";\n\t\t\t\t\t\t\tif(rows_eq[kk].db_mode==\"D\" || oper_line_status1==\'99\') \n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].oper_desc)+\"</td>\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\telse{ \t\n\t\t\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:sendparams_eq(\"+args3+\");\\\">\"+checkEmpty(rows_eq[kk].oper_desc)+\"</a></td>\";\n\t\t\t\t\t\t\t\t} \n\t\t\t\t\t\t\t  tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].equip_desc)+\"</td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].desiredDate)+\"</td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].quantity)+\"</td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_eq[kk].equip_code)+\"</td>\";\n\t\t\t\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_eq(remarks_value,\'\"+kk+\"\');\\\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t   // Added Against Start AMRI-CRF-0294 [IN049121] step-3\n\t\t\t\t\t\t\t  \t if(rows_eq[kk].db_mode==\'D\' || oper_line_status1==\'99\')\n\t\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\"><img src=\'../../eCommon/images/RRnwd.gif\'></img></td>\";\n\t\t\t\t\t\t\t\t}  \n\t\t\t\t\t\t\t\t// Added Against End AMRI-CRF-0294 [IN049121\n\t\t\t\t\t\t\t   tab_data+=\"</tr>\"; \n\t\t\t\t\t\t\t   }\t\t\t \n\t\t\t\t    }\n\t\t\t\t }\n\t\t\t  }\t \n\t\t\t tab_data+=\"</table>\";\n\t\t\t tab_data+=\"</div>\";\n\t\t\t tab_data+=\"</tr>\";\n\t\t\t document.getElementById(\"menuExpand6\").innerHTML = tab_data;\n\t\t}\n\n\t\tfunction createTable_ic()\n\t\t{\n\t\tvar instrument_entry_cmp_yn=localTrimString(document.forms[0].instrument_entry_cmp_yn.value);\n\t\tvar tab_data=\"\";\n\t    tab_data+=\"<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\"\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\" \n\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</td>\";\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'></td>\";\n\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\trows_ic=parent.parent.parent.AdminObjectCollect.instrument_rows;\n       if(rows_ic!=null){\n\t   for(var mm=0;mm<rows_ic.length;mm++) {\n\t\t   if(rows_ic[mm]!=null  && rows_ic[mm].db_mode!=\'D\'){\n\t\t\t\targs4=mm;\n\t\t\t\tcode_ic+= rows_ic[mm].oper_code+rows_ic[mm].instr_code+\",\";\n\t\t\t    if(mm%2==0)\n\t\t\t     qryVal=\"gridData\";\n\t\t\t   else\n\t\t\t\t qryVal=\"gridData\";\n\n\t\t\t   var remarks=rows_ic[mm].remarks_ic;\n\n\t\t\t      if(instrument_entry_cmp_yn==\"Y\" ) {  \n\t\t\t       tab_data+=\"<tr>\";\n\t\t\t\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].oper_desc)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].instr_desc)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].quantity)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].tray_no)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_ic(remarks_value,\'\"+mm+\"\');\\\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</a></td>\";\n\t\t\t\t   ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t   var arr = rows_ic[mm].bill_str.split(\"::\");\n\t\t\t\t   var inclexcl=\"\";\n\t\t           var approvalreqd=\"\";\n\t\t\t\t  \n\t\t\t\t\tif(arr[6]==\'S\')\n\t\t\t\t\t{\n\t\t\t\t\tif(arr[8]==\"E\" ||arr[8]==\'\' ||arr[8]==\'null\') inclexcl=\"<img src=\'../../eCommon/images/disabled.gif\'  width=\'15px\' align=\'texttop\' ></img>\";\n\t\t\t\t\tif(arr[8]==\"I\") inclexcl=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\tif(arr[5]==\"Y\") approvalreqd=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\tif(arr[5]==\"N\") approvalreqd=\"<img src=\'../../eCommon/images/disabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t}\n\t\t\t\t   else{\n\t\t\t\t\t   inclexcl=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t   approvalreqd=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t   }\n\t\t\t\t  tab_data+=\"<td  class=gridData><B><font color=\'Indigo\' >";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="?\"+inclexcl+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?\"+approvalreqd+\"\";\n\t\t\t\t  tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:callBillingWindow_ic(\"+mm+\");\\\"><img src=\'../../eOT/images/dollar.png\'></img></a></td>\";\n\t\t\t\t   ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t   tab_data+=\"</tr>\"; \n\t\t\t\t   } else { \n\t\t\t\t   tab_data+=\"<tr>\";\n\t\t \n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:sendparams_ic(\"+args4+\");\\\">\"+checkEmpty(rows_ic[mm].oper_desc)+\"</a></td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].instr_desc)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].quantity)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].tray_no)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_ic(remarks_value,\'\"+mm+\"\');\\\">";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</a></td>\";\n\t\t\t\t  ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t   var arr = rows_ic[mm].bill_str.split(\"::\");\n\t\t\t\t   var inclexcl=\"\";\n\t\t\t\t   var approvalreqd=\"\";\n\t\t\t\t   if(arr[6]==\'S\')\n\t\t\t\t   {\n\t\t\t\t\tif(arr[8]==\"E\" ||arr[8]==\'\' ||arr[8]==\'null\') inclexcl=\"<img src=\'../../eCommon/images/disabled.gif\'  width=\'15px\' align=\'texttop\' ></img>\";\n\t\t\t\t\tif(arr[8]==\"I\") inclexcl=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\tif(arr[5]==\"Y\") approvalreqd=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\tif(arr[5]==\"N\") approvalreqd=\"<img src=\'../../eCommon/images/disabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t   }else{\n\t\t\t\t\t   inclexcl=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t\t   approvalreqd=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t\t\t  }\n\t\t\t\t  tab_data+=\"<td  class=gridData><B><font color=\'Indigo\' >";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t   tab_data+=\"</tr>\";\n\t\t\t\t   } \n\t            }\n\t          }\n             }\n        tab_data+=\"</table>\";\n\t\ttab_data+=\"</div>\";\n\t\ttab_data+=\"</tr>\";\n\t\tdocument.getElementById(\"menuExpand7\").innerHTML = tab_data;\n\t  }\n\n//Added by lakshmi against CRF-0058\n\t  function createTable_ic1()\n\t\t{\n\t\tvar instrument_entry_cmp_yn=localTrimString(document.forms[0].instrument_entry_cmp_yn.value);\n\t\tvar tab_data=\"\";\n\t    tab_data+=\"<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\"\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'></td>\"//Added by Muthu for RUT-CRF-0057\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\"\t\t\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</td>\"//Added by lakshmi against CRF-0058\t\t\n\t\ttab_data+=\"<td class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\trows_ic=parent.parent.parent.AdminObjectCollect.instrument_rows;\n       if(rows_ic!=null){\n\t   for(var mm=0;mm<rows_ic.length;mm++) {\n\t\t   if(rows_ic[mm]!=null  && rows_ic[mm].db_mode!=\'D\'){\n\t\t\t\targs4=mm;\n\t\t\t\tcode_ic+= rows_ic[mm].oper_code+rows_ic[mm].instr_code+\",\";\n\t\t\t    if(mm%2==0)\n\t\t\t     qryVal=\"gridData\";\n\t\t\t   else\n\t\t\t\t qryVal=\"gridData\";\n\n\t\t\t   var remarks=rows_ic[mm].remarks_ic;\n\n\t\t\t      if(instrument_entry_cmp_yn==\"Y\" ) {  \n\t\t\t       tab_data+=\"<tr>\";\n//Added by Muthu for RUT-CRF-0057\n\t\ttab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_ic_img(instr_image,\'\"+mm+\"\',\'\"+rows_ic[mm].instr_code+\"\');\\\"><img src=\'../../eOT/images/nolines_plus.gif\'></img></a></td>\";\n//Added by Muthu for RUT-CRF-0057\n\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].oper_desc)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].instr_desc)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].quantity)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].tray_no)+\"</td>\";\t\t\t\t   \n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_ic(remarks_value,\'\"+mm+\"\');\\\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t   tab_data+=\"</tr>\"; \n\t\t\t\t   } else { \n\t\t\t\t   tab_data+=\"<tr>\";\n\ttab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_ic_img(instr_image,\'\"+mm+\"\',\'\"+rows_ic[mm].instr_code+\"\');\\\"><img src=\'../../eOT/images/nolines_plus.gif\'></img></a></td>\";\n//Added by Muthu for RUT-CRF-0057\n\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:sendparams_ic(\"+args4+\");\\\">\"+checkEmpty(rows_ic[mm].oper_desc)+\"</a></td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].instr_desc)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].quantity)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\">\"+checkEmpty(rows_ic[mm].tray_no)+\"</td>\";\n\t\t\t\t   tab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_ic(remarks_value,\'\"+mm+\"\');\\\">";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t   tab_data+=\"</tr>\";\n\t\t\t\t   } \n\t            }\n\t          }\n             }\n        tab_data+=\"</table>\";\n\t\ttab_data+=\"</div>\";\n\t\ttab_data+=\"</tr>\";\n\t\tdocument.getElementById(\"menuExpand7\").innerHTML = tab_data;\n\t  }\n\t\tfunction createTable_op()\n\t\t{\n\t\tvar objFrm = parent.parent.parent.AdminObjectCollect;\n\t\tvar bill_flag=document.forms[0].bill_flag.value;\n\t\tvar proc_chrg_cmp_yn=document.forms[0].proc_chrg_cmp_yn.value;\n\t\tvar tab_data=\"\";\n\t\tvar bill_data=\"\";\n\t\tvar oper_code=\"\";\n\t\tvar side_applicable=\"\";\n\t\tvar remarks=\"\";\n\t\tvar chk_status=\"\";\n\t\tvar cancel_remarks=\"\";\n\t\tvar oper_line_status=\"\";\n\t\tvar oper_line_num=\"\";\n\t\tvar doc_send_val=\"\";\n\t\tvar bill_yn=\"\";// now not using this flags proc_chrg_cmp_yn flag only using.\n\t\tvar billed_yn=\"\";\n\t\tvar fpp_category=\"\";//Added Against ML-MMS-QH-CRF-1939-US4\n\t\tvar fpp_order_yn=\"\";//Added Against ML-MMS-QH-CRF-1939-US4\n\t\tvar chk_status=\"\";\n\t\tvar obj=document.getElementById(\"menuExpand1\");\n\t\ttab_data=\"<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\"\n\t\ttab_data+=\"<td nowrap class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" </td>\";\n\t\ttab_data+=\"<td nowrap class=\'columnHeaderCenter\'> ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" </td>\";\n\t\ttab_data+=\"<td nowrap class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\";\n\t\ttab_data+=\"<td nowrap class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\";  \n\n\t\tif(bill_flag==\"true\"){\n\t\ttab_data+=\"<td nowrap class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</td>\";\n\t\ttab_data+=\"<td nowrap class=\'columnHeaderCenter\'></td>\";\n\t\t}\n\t\ttab_data+=\"<td nowrap class=\'columnHeaderCenter\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\"  \n\t\tif(objFrm.op_rows!=null){\n\t\tfor(var jj=0;jj<objFrm.op_rows.length;jj++) {\n\t\tif(objFrm.op_rows[jj]!=null){\n\t\toper_code=objFrm.op_rows[jj].oper_code;\n\t\toper_desc=objFrm.op_rows[jj].oper_desc;        \n\t\tside_applicable=objFrm.op_rows[jj].side_applicable;\n\t\tside_applicable_desc=objFrm.op_rows[jj].side_applicable_desc;\n\t\tchk_status=objFrm.op_rows[jj].chk_status;\n\t\tcancel_remarks=objFrm.op_rows[jj].cancel_remarks;\n\t\tremarks=objFrm.op_rows[jj].remarks;\n\t\toper_line_num=objFrm.op_rows[jj].line_no;\n\t\toper_line_status=objFrm.op_rows[jj].oper_line_status;\n\t\tbill_yn =objFrm.op_rows[jj].bill_yn;\n\t\tbilled_yn =objFrm.op_rows[jj].billed_yn;\n\t\t//Added Against ML-MMS-QH-CRF-1939-US4...starts\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\tvar arr=new Array();\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\tvar param=\"func_mode=getFppList&oper_code=\"+oper_code;\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open(\"POST\",\"../../eOT/jsp/OTCommonValidation.jsp?\"+param,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = localTrimString(xmlHttp.responseText);\n\t\t\t\tif(retVal!=\'\'){\n\t\t\t\tar=retVal.split(\"::\");\n\t\t\t\tfpp_order_yn=ar[0];\n\t\t\t\t}\t\t\n\t\tfpp_category =trimString(objFrm.op_rows[jj].fpp_category);\n\t\t\n\t\tif(fpp_category == \"S\" || fpp_category == \"M\" || fpp_category == \"C\")\n\t\t\t{\n\t\t\t\t\t // fpp_order_yn = \"Y\";\n\t\t\tif(fpp_category == \"S\") fpp_category =\"Simple\";\n\t\t\tif(fpp_category == \"M\") fpp_category =\"Moderate\";\n\t\t\tif(fpp_category == \"C\") fpp_category =\"Complex\";\n\t\t\t}\n\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t//Added Against ML-MMS-QH-CRF-1939-US4...ends\n\t\t\n\t\tif(jj%2==0)\n\t\tqryVal=\"gridData\";\n\t\telse\n\t\tqryVal=\"gridData\";\n\t\t\n\t\tremarks=encodeURIComponent(remarks);\n\t\tcancel_remarks=encodeURIComponent(cancel_remarks);\n\t\t\n\t\tvar tab_name = document.forms[0].tab_name.value\n\t\t\n\t\ttab_data+=\"<tr>\";\n\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+oper_code+\"</td>\";\n\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+objFrm.op_rows[jj].oper_desc+\"</td>\";\n\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">\"+objFrm.op_rows[jj].side_applicable_desc+\"</td>\";\n\t\ttab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:openDialogWindow_op(remarks_value,\'\"+jj+\"\');\\\">";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</a><input type=\'hidden\' name=\'chk_status\' id=\'chk_status\' value=\'\"+chk_status+\"\'><input type=\'hidden\' name=\'cancel_remarks\' id=\'cancel_remarks\' value=\'\"+cancel_remarks+\"\'></td>\";\n\t\tif(bill_flag==\"true\"){\n\t\tif(chk_status !=\"99\"){\n\t\tvar arr = objFrm.op_rows[jj].bill_str.split(\"::\");\n\t\tvar inclexcl=\"\";\n\t\tvar approvalreqd=\"\";\n\t\tif(arr[6]==\'S\')\n\t\t{\n\t\tif(arr[8]==\"E\" ||arr[8]==\'\'||arr[8]==\'null\') inclexcl=\"<img src=\'../../eCommon/images/disabled.gif\'  width=\'15px\' align=\'texttop\' ></img>\";\n\t\tif(arr[8]==\"I\") inclexcl=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\tif(arr[5]==\"Y\") approvalreqd=\"<img src=\'../../eCommon/images/enabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\tif(arr[5]==\"N\") approvalreqd=\"<img src=\'../../eCommon/images/disabled.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t}else{\n\t\tinclexcl=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\tapprovalreqd=\"<img src=\'../../eCommon/images/blank.gif\' hegiht=\'15px\' width=\'15px\' align=\'texttop\'></img>\";\n\t\t}\n\t\tif(fpp_order_yn==\"Y\" && tab_name === \'SCHEDULED\')\n\t\t{\t\n\t\ttab_data+=\"<td  class=gridData><B><font color=\'Indigo\' >";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =":&nbsp\"+fpp_category+\"&nbsp;";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="?\"+inclexcl+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?\"+approvalreqd+\"\";\n\t\ttab_data+=\"</font></td>\";\n\t\t}\n\t\telse\n\t\t{\n\t\t\ttab_data+=\"<td  class=gridData><B><font color=\'Indigo\' >";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="?\"+inclexcl+\"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Approval Reqd?\"+approvalreqd+\"\";\n\t\ttab_data+=\"</font></td>\";\n\t\t}\n\t\tif(proc_chrg_cmp_yn==\"N\")\n\t\t{\n\t\ttab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:callBillingWindow_op(\"+jj+\");\\\"><img src=\'../../eOT/images/dollar.png\'></img></a></td>\";\n\t\t}\n\t\telse{\n\t\ttab_data+=\"<td nowrap class=\"+qryVal+\"><a class=\'gridLink\' href=\\\"javascript:callBillingWindow_op(\"+jj+\");\\\"><img src=\'../../eOT/images/dollar.png\'></img></a></td>\";\n\t\t}\n\t\t}else {\n\t\ttab_data+=\"<td nowrap class=gridData><B><font color=\'Indigo\' >&nbsp</td>\";\n\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp</td>\"\n\t\t}\n\t\t}\n\t\tif(chk_status==\"99\") {\n\t\ttab_data+=\"<td nowrap class=\"+qryVal+\"><img src=\'../../eCommon/images/RRnwd.gif\'></img></td>\";\n\t\t}else\n\t\t{\n\t\ttab_data+=\"<td nowrap class=\"+qryVal+\">&nbsp;</td>\";\n\t\t}\n\t\ttab_data+=\"</tr>\";\n\t\t}\n\t\t}            \n\t\t}\n\t\tdocument.getElementById(\"menuExpand1\").innerHTML = tab_data;\n\t\t} \n\t    </script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t</head>\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\" onLoad=\"loadCodes();callChargeableUnits();callChargeableUnits_or();callChargeableUnits_ha(\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\')\">\n\t\t<form name=\"AdministrativeFunctionforAllChargesForm\" id=\"AdministrativeFunctionforAllChargesForm\">\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\n\t\t\t\t<tr >\n\t\t\t\t\t<td valign=\"top\">\t\t\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t   \n\t\t\t\t\t   ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\n                       \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand2A\" style=\'display:none;visibility:visible;overflow:auto;height:158px;width:100%\'>\n\t\t\t\t\t\t<table id=\"AC_arrow\" style=\'display:visible;overflow:auto;width:100%\'>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 =" </td>\n\t\t\t\t\t\t<td class=\"fields\" width=\'25%\'>\n\t\t\t\t\t\t<select name=\"accesstype\" id=\"accesstype\"  ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 =" disabled>\n\t\t\t\t\t\t\t<option value=\'PI\'  Selected>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t<option value=\'CP\' >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t<option value=\'EQ\' >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t<option value=\'IC\' >\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\n\n\t\t\t\t\t\t  <td class=\"label\" width=\'25%\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" </td>\n\t\t\t\t\t\t  <td class=\"fields\" width=\'25%\'>\n\t\t\t\t\t\t\t  <input type=\'hidden\' name=\'implant_code\' id=\'implant_code\' > \n\t\t\t\t\t\t\t  <input type=\'text\' name=\'implant_desc\' id=\'implant_desc\' onBlur=\"if(this.value!=\'\')searchProsthesis(implant_code,implant_desc);\"> \n\t\t\t\t\t\t\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'ImplantLookUp\' id=\'ImplantLookUp\' onClick=\'searchProsthesis(implant_code,implant_desc);\' ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t  </td>\n\t\t\t\t\t </tr>\n\n\t\t\t\t\t\t <tr>\n\t\t\t\t\t\t\t <td class=\"label\" width=\'25%\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" </td>\n\t\t\t\t\t\t\t <td class=\"fields\" width=\'25%\'>\n\t\t\t\t\t\t\t\t\t<select class=\"my_dropdown\" id=\"menuPI\" name=\"operation_pi\" id=\"operation_pi\"  ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" ><!--MMS-QH-CRF-0199-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' title=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\"> ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="  </option><!--MMS-QH-CRF-0199-->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t</td>\n                            ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t\t\t  <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n\t\t\t\t\t\t\t  <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'conns_store_pi\' id=\'conns_store_pi\' onblur=\"if(this.value!=\'\')searchStore(this,conns_store_pi,document.forms[0].operation);else{}\"> \n\t\t\t\t\t\t\t   <input type=\'hidden\' name=\'reqstore_code\' id=\'reqstore_code\' value=\'\'> \n\t\t\t\t\t\t\t\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'Cons_store_LookUp\' id=\'Cons_store_LookUp\' onClick=\'searchStore(this,conns_store_pi);\' ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t  </td>\t\n\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t </tr>\n                        ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t\t\t\t<tr>\n\n\t\t\t\t\t\t\t <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 =" </td>\n\t\t\t\t\t\t\t <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'manufacturer\' id=\'manufacturer\' maxlength=\'30\' size=\'20\' ";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =" ></td>\n\n\t\t\t\t\t\t\t <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 =" </td>\n\t\t\t\t\t\t\t <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'batch\' id=\'batch\' maxlength=\'30\' size=\'20\'  ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 =" ></td>\n\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 =" </td>\n\t\t\t\t\t\t\t <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'Reservepicklist_pi\' id=\'Reservepicklist_pi\' maxlength=\'6\' size=\'6\' disabled ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =" </td>\n\t\t\t\t\t\t\t <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'Requestpicklist_pi\' id=\'Requestpicklist_pi\' maxlength=\'6\' size=\'6\'  disabled ";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t\t <input type=\'hidden\' name=\'sale_document_no\' id=\'sale_document_no\' value=\'\'>\n                             <input type=\'hidden\' name=\'sale_document_type\' id=\'sale_document_type\' value=\'\'>\n\t\t\t\t\t\t\t <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =" </td>\n\t\t\t\t\t\t\t <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'Stockavail_pi\' id=\'Stockavail_pi\' maxlength=\'6\' size=\'6\'  ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 =" ></td>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t\t\t <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="</td>\n\t\t\t\t\t\t\t <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'quantity_pi\' id=\'quantity_pi\' maxlength=\'3\' size=\'2\' onBlur=\"ChkNumber(this);\" ";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t<td class=\"label\" width=\"25%\"></td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\"25%\"></td>\n\t\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>\n\t\t\t\t\t\t\t  <input type=\'hidden\' name=\'remarks_pi\' id=\'remarks_pi\' value=\"\">\n\t\t\t                 <a  class=\"gridLink\" href=\"javascript:openRemarksWindow(document.forms[0].remarks_pi,\'implants\');\">\n\t\t\t\t           ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="</a></td>\n\t\t\t\t\t\t\t<td width=\'20%\' class=\"button\">\n\t\t\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\' onClick=\'assignCodes_pi(document.forms[0].operation_pi);addRow_pi();\' ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 =" >\n\t\t\t\t\t\t\t\t<input type=\'button\' name=\"btn_cancel\" id=\"btn_cancel\" class=\'button\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\' onClick=\'removeRow();\' ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" >\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand2B\" style=\'display:none;visibility:visible;overflow:auto;height:158px;width:100%\'>\n\t\t\t\t\t\t<br>\n\t\t\t\t\t\t<br>\n\t\t\t\t\t\t<table id=\"AC_arrow\" style=\'display:visible;overflow:auto;width:100%\'>\n\n\t\t\t\t\t\t<tr>\n\n\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 =" disabled>\n\t\t\t\t\t\t<option value=\'PI\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\'CP\' Selected>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\'EQ\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\'IC\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =" </td>\n\t\t\t\t\t\t<td class=\"fields\" width=\'25%\'>\n\t\t\t\t\t\t<select class=\"my_dropdown\" id=\"menuCP\" name=\"operation_cons\" id=\"operation_cons\"  ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" ><!--MMS-QH-CRF-0199-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="  </option><!--MMS-QH-CRF-0199-->\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n                        <tr>\n\t\t\t\t\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 =" </td>\n\t\t\t\t\t\t<td class=\"fields\" width=\"25%\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'package_code\' id=\'package_code\' > \n\t\t\t\t\t\t<input type=\'text\' name=\'package_desc\' id=\'package_desc\' onBlur=\"if(this.value!=\'\')searchPackage(package_code,package_desc);\"> \n\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'PackageLookUp\' id=\'PackageLookUp\' onClick=\'searchPackage(package_code,package_desc);\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="</td>\n\t\t\t\t\t\t<td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'quantity_cons\' id=\'quantity_cons\' maxlength=\'3\' size=\'2\' onBlur=\"ChkNumber(this);\" ";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"fields\" width=\"25%\"></td>\n\t\t\t\t\t    <td class=\"fields\" width=\"25%\"></td>\n\t\t\t\t\t\t<td class=\"label\" width=\'25%\'> <input type=\'hidden\' name=\'remarks_cons\' id=\'remarks_cons\' value=\"\">\n\t\t\t                 <a  class=\"gridLink\" href=\"javascript:openRemarksWindow(document.forms[0].remarks_cons,\'consumables\');\">\n\t\t\t\t            ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="</a></td>\n\t\t\t\t\t\t<td width=\'25%\' class=\"button\">\n\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\' onClick=\'assignCodes_cons(document.forms[0].operation_cons);addRow_cons();\' ";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =" >\n\t\t\t\t\t\t<input type=\'button\' name=\"btn_cancel\" id=\"btn_cancel\" class=\'button\' value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' onClick=\'removeRow_cons();\' ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =" >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr> \n                        ";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n                        <tr>\n\t\t\t\t\t\t<div id=\"menuExpand2C\" style=\'display:none;visibility:visible;overflow:auto;height:158px;width:100%\'>\n\t\t\t\t\t\t\t<table id=\"AC_arrow\" style=\'display:visible;overflow:auto;width:100%\'>\n                            <br>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\'CP\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\'EQ\' Selected>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =" </td>\n\t\t\t\t\t\t<td class=\"fields\" width=\"25%\" >\n\t\t\t\t\t\t<select class=\"my_dropdown\" id=\"menuEq\" name=\"operation_eq\" id=\"operation_eq\" ";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="  </option><!--MMS-QH-CRF-0199-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td>\n\n                        </tr>\n\n\t\t\t\t\t\t<tr> \n\t\t\t\t\t\t<td class=\"label\" width=\"25%\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =" \n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td width=\"25%\" class=\"fields\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'equip_code\' id=\'equip_code\' > \n\t\t\t\t\t\t<input type=\'text\' name=\'equip_desc\' id=\'equip_desc\' onBlur=\"if(this.value!=\'\')searchEquipments(equip_code,equip_desc);\"> \n\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'EquipmentLookUp\' id=\'EquipmentLookUp\' onClick=\'searchEquipments(equip_code,equip_desc);\' ";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td>\n<!--Added by MuthuN against RUT-CRF-0091 on 13-May-2013 starts here-->\n";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t<td class=\"label\" width=\"25%\" >\n\t";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =" </td>\n     <td width=\"25%\" class=\"fields\">\n\t  <input type=\'text\' name=\'st_location\' id=\'st_location\' maxlength=\'20\' size=\'20\' ";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 =">\n\t\t<input type=\'hidden\' name=\'equip_id\' id=\'equip_id\' value=\"\">\n\t</td>\n\t";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\n\t\t<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="  </td>\n\t\t<td width=\"25%\" class=\"fields\">\n\t\t<input type=\'text\' name=\'equip_id\' id=\'equip_id\' maxlength=\'20\' size=\'20\' ";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 =" > \n\t\t</td>\n\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n<!--Added by MuthuN against RUT-CRF-0091 ends here-->\t\t\n\t\t\t\t\t    </tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="</td>\n\t\t\t\t\t\t<td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'quantity_eq\' id=\'quantity_eq\' maxlength=\'3\' size=\'2\' onBlur=\"ChkNumber(this);\" onkeypress=\"return checkForSpecCharsforID(event);\"  ";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t    <td class=\"label\" width=\'25%\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'remarks_eq\' id=\'remarks_eq\' value=\"\">\n\t\t\t            <a  class=\"gridLink\" href=\"javascript:openRemarksWindow(document.forms[0].remarks_eq,\'equipments\');\">\n\t\t\t\t        ";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="</a></td>\n\t\t\t\t\t\t<td class=\"fields\" width=\"25%\">\n\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\' onClick=\'assignCodes_eq(document.forms[0].operation_eq);addRow_eq();\'  ";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="  >\n\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' onClick=\'removeRow_eq();\' ";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 =" >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="</td><!-- 047546 -->\n\t\t\t\t\t\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"desiredDate\" id=\"desiredDate\" id=\"desiredDate\" size=\"16\" value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\" maxlength=\"16\" onkeypress=\"return checkForSpecCharsforID(event);\" onblur=\"if(this.value!=\'\'){ validateDate(this.value); chkDateRangeValidity(this.value); }\">\n\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onclick=\"return showCalWithTime(\'desiredDate\',\'%d/%m/%Y %H:%M\',\'24\',true,\'desiredDate\');\"><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</tr> \n                        ";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand2D\" style=\'display:none;visibility:visible;overflow:auto;height:158px;width:100%\'>\n\t\t\t\t\t\t<table id=\"AC_arrow\" style=\'display:visible;overflow:auto;width:100%\'>\n                        <br>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\'EQ\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t<option value=\'IC\' Selected>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t\t\t\t\t</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t<td class=\"label\" width=\"25%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =" </td>\n\t\t\t\t\t\t<td class=\"fields\" width=\"25%\" >\n\t\t\t\t\t\t<select class=\"my_dropdown\" id=\"menuIC\" name=\"operation_ic\" id=\"operation_ic\"  ";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t<tr>\n\n\t\t\t\t\t\t<td class=\"label\" width=\"25%\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 =" </td>\n\t\t\t\t\t\t<td class=\"fields\" width=\"25%\">\n\t\t\t\t\t\t<input type=\'hidden\' name=\'instr_code\' id=\'instr_code\' > \n\t\t\t\t\t\t<input type=\'text\' name=\'instr_desc\' id=\'instr_desc\' onBlur=\"if(this.value!=\'\')searchInstrument(instr_code,instr_desc);\"> \n\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'InstrumentLookUp\' id=\'InstrumentLookUp\' onClick=\'searchInstrument(instr_code,instr_desc);\' ";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<!-- </tr>\n\t\t\t\t\t\t<tr> -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 =" <!--Added by lakshmi against RUT-CRF-0058-->\n\t\t\t\t\t\t<td class=\"label\" width=\"25%\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 =" </td>\n\t\t\t\t\t\t<td class=\"fields\" width=\"25%\">\n\t\t\t\t\t\t<!-- Modified By rajesh 29-8-2012 -->\n\t\t\t\t\t\t<input type=\'text\' name=\'tray_no\' id=\'tray_no\' maxlength=\'30\' size=\'20\' disabled > \n\t\t\t\t\t\t<!-- Modified By rajesh 29-8-2012 -->\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t\t\t\t\t\t<td class=\"label\" width=\"25%\" >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 =" </td>\n\t\t\t\t\t\t<td class=\"fields\" width=\"25%\">\n\t\t\t\t\t\t<input type=\'text\' name=\'tray_no\' id=\'tray_no\' maxlength=\'30\' size=\'20\' ";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 =" > \n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t\t\t\t\t\t</tr>\n\n                        <tr>\n\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="</td>\n\t                    <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'quantity_ic\' id=\'quantity_ic\' maxlength=\'3\' size=\'2\' onBlur=\"ChkNumber(this);\" onkeypress=\"return checkForSpecCharsforID(event);\"  ";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\t\t\t\t<td class=\"label\" width=\'25%\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'remarks_ic\' id=\'remarks_ic\' value=\"\">\n\t\t\t            <a  class=\"gridLink\" href=\"javascript:openRemarksWindow(document.forms[0].remarks_ic,\'instrumnets\');\">\n\t\t\t\t        ";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="</a></td>\n\t\t\t\t\t\t<td width=\"25%\" >\n\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\' onClick=\'assignCodes_ic(document.forms[0].operation_ic);addRow_ic();\' ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 =" >\n\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\' onClick=\'removeRow_ic();\' ";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n                    \n   \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" onclick=\"createTable_pi();\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th align=\"left\">&nbsp;&nbsp;&nbsp;<img name=\"PI_arrow\" src=\"../../eCommon/images/tree_handlerightlast.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuPI\',this);\" />";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="</th>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'  id=\'moreCriteriaPI\' name=\'moreCriteriaPI\' id=\'moreCriteriaPI\' style=\'visible:hidden;display:none;\' \n                        bordercolor=\'white\'> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'  id=\'moreCriteriaPI\' name=\'moreCriteriaPI\' id=\'moreCriteriaPI\' style=\'display:inline;\'  bordercolor=\'white\'> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand4\" style=\'display:none;visibility:visible;height:60px;width:100%\' >\n\t\t\t\t\t\t<table id=\"PI_arrow\" style=\'display:visible;\' >\n\t\t\t\t\t\n                        </table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n                        ";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" onclick=\"createTable_cons();\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th align=\"left\">&nbsp;&nbsp;&nbsp;<img name=\"CP_arrow\" src=\"../../eCommon/images/tree_handlerightlast.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuCP\',this);\" />";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaCP\' name=\'moreCriteriaCP\' id=\'moreCriteriaCP\' style=\'visible:hidden;display:none;overflow:auto;\' \n                        bordercolor=\'white\' > \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaCP\' name=\'moreCriteriaCP\' id=\'moreCriteriaCP\' style=\'visible:inline;overflow:auto;\'  bordercolor=\'white\'> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand5\" style=\'display:none;visibility:visible;height:60px;width:100%\'>\n\t\t\t\t\t\t<table id=\"CP_arrow\" style=\'display:visible;overflow:auto;\'>\n                      \n                        </table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<!--Modified by lakshmi against CRF-0057 starts here-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\"  onclick=\"createTable_eq1();\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th align=\"left\">&nbsp;&nbsp;&nbsp;<img name=\"Eq_arrow\" src=\"../../eCommon/images/tree_handlerightlast.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuEq\',this);\" />";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="</th>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\"  onclick=\"createTable_eq();\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<!-- Modified By rajesh 29-8-2012 -->\n\t\t\t\t\t\t\t\t<th align=\"left\">&nbsp;&nbsp;&nbsp;<img name=\"Eq_arrow\" src=\"../../eCommon/images/tree_handlerightlast.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuEq\',this);\" />";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="</th>\n\t\t\t\t\t\t\t<!-- Modified By rajesh 29-8-2012 -->\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n\t\t\t\t\t\t<!--Modified by lakshmi against CRF-0057 ends here-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaEq\' name=\'moreCriteriaEq\' id=\'moreCriteriaEq\' style=\'visible:hidden;display:none;overflow:auto;\' \n                        bordercolor=\'white\' > \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaEq\' name=\'moreCriteriaEq\' id=\'moreCriteriaEq\' style=\'visible:inline;overflow:auto;\'  bordercolor=\'white\'> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand6\" style=\'display:none;visibility:visible;height:60px;width:100%\'>\n\t\t\t\t\t\t<table id=\"Eq_arrow\" style=\'display:visible;overflow:auto;\'>\n                        \n                        </table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\"  onclick=\"createTable_ic1();\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th align=\"left\">&nbsp;&nbsp;&nbsp;<img name=\"IC_arrow\" src=\"../../eCommon/images/tree_handlerightlast.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuIC\',this);\" />";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\n\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\"  onclick=\"createTable_ic();\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th align=\"left\">&nbsp;&nbsp;&nbsp;<img name=\"IC_arrow\" src=\"../../eCommon/images/tree_handlerightlast.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuIC\',this);\" />";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\n\t\t\t\t\t\t<!--Modified by lakshmi against CRF-0058 ends here-->\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaIC\' name=\'moreCriteriaIC\' id=\'moreCriteriaIC\' style=\'visible:hidden;display:none;overflow:auto;\' \n                        bordercolor=\'white\' > \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaIC\' name=\'moreCriteriaIC\' id=\'moreCriteriaIC\' style=\'visible:inline;overflow:auto;\'  bordercolor=\'white\'> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand7\" style=\'display:none;visibility:visible;height:60px;width:100%\'>\n\t\t\t\t\t\t<table id=\"IC_arrow\" style=\'display:visible;overflow:auto;\'>\n                       \n                        </table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n                        ";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th align=\"left\"><img name=\"OR_arrow\" src=\"../../eCommon/images/tree_handlerightlast.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuOR\',this);\" />";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaOR\' name=\'moreCriteriaOR\' id=\'moreCriteriaOR\' style=\'visible:hidden;display:none;overflow:auto;\' \n                        bordercolor=\'white\' > \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaOR\' name=\'moreCriteriaOR\' id=\'moreCriteriaOR\' style=\'visible:inline;overflow:auto;\'  bordercolor=\'white\'> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand8\" style=\'display:none;visibility:visible;overflow:auto;height:92px;width:100%\'>\n\t\t\t\t\t\t<table id=\"OR_arrow\" style=\'display:visible;overflow:auto;\'>\n                       <tr>\n\t\t\t\t\t\t<td class=\'fields\' width=\"32%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="  &nbsp;&nbsp;\n\t\t\t\t\t\t   <input type=\'text\' class=\'fields\' name=\'chk_in_or_date_time\' id=\'chk_in_or_date_time\' size=\'12\'  value=\'";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\'  disabled>\n\t\t\t\t\t\t   \n\t\t\t\t\t\t    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n                        <td class=\'fields\' width=\"32%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="&nbsp;&nbsp; \n\t\t\t\t\t\t       <input type=\'text\' class=\'fields\' name=\'chk_out_or_date_time\' id=\'chk_out_or_date_time\' size=\'12\'  value=\'";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\' onblur=\'validateDate();\' onkeypress=\"return checkForSpecCharsforID(event);\" disabled>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t</td> \n\n\t\t\t\t\t\t<td class=\'fields\' width=\"36%\">\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 =" &nbsp;&nbsp;\n\t\t\t\t\t\t\n\t\t\t\t\t\t    <input type=\'text\' class=\'fields\' name=\'charge_units_or\' id=\'charge_units_or\' size=\'3\'  maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\' onblur=\"getServPanelDtls(this,\'OR\');\" ";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'></td>\n\t\t\t\t\t\t<td class=\"gridData\" colspan =\'3\' >\n\t\t\t\t\t\t<div id=\"charge_details_or\" style=\'visible:hidden;display:none\'>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\n\t\t\t\t\t\t<td  class=\'Label\' width=\"25%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\t\n\t\t\t\t\t    &nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'checkbox\'  class=\'label\' name=\'doc_compl_or\' id=\'doc_compl_or\' onClick=\'validateCheckBox_or();\' disabled checked>\n\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\t\n\t\t\t\t\t    &nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'checkbox\'  class=\'label\' name=\'doc_compl_or\' id=\'doc_compl_or\' onClick=\'validateCheckBox_or();\' ";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 =" >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\n\t\t\t\t\t\t</tr>\n                        </table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\n                        ";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th align=\"left\"><img name=\"HA_arrow\" src=\"../../eCommon/images/tree_handlerightlast.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuHA\',this);\" />";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaHA\' name=\'moreCriteriaHA\' id=\'moreCriteriaHA\' style=\'visible:hidden;display:none;overflow:auto;\' \n                        bordercolor=\'white\' > \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaHA\' name=\'moreCriteriaHA\' id=\'moreCriteriaHA\' style=\'visible:inline;overflow:auto;\'  bordercolor=\'white\'> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand9\" style=\'display:none;visibility:visible;overflow:auto;height:92px;width:100%\'>\n\t\t\t\t\t\t<table id=\"HA_arrow\" style=\'display:visible;overflow:auto;\'>                     \n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t <td class=\'fields\' width=\"32%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 =" &nbsp;&nbsp;\n\t\t\t\t\t\t   <input type=\'text\' class=\'fields\' name=\'chk_in_ha_date_time_";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\' id=\'chk_in_ha_date_time_";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\' size=\'12\'  value=\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\'  disabled>\n\t\t\t\t\t\n\t\t\t\t\t\t    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n                        <td class=\'fields\' width=\"32%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \n\t\t\t\t\t\t       <input type=\'text\' class=\'fields\' name=\'chk_out_ha_date_time_";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\' id=\'chk_out_ha_date_time_";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\' onblur=\'validateDate();\' onkeypress=\"return checkForSpecCharsforID(event);\" disabled>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t</td> \n\n\t\t\t\t\t\t<td class=\'fields\' width=\"36%\">\n\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 =" &nbsp;&nbsp;\n\t\t\t\t\t\t\n\t\t\t\t\t\t    <input type=\'text\' class=\'fields\' name=\'charge_units_ha_";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\' id=\'charge_units_ha_";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\' size=\'3\'  maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\'  onblur=\"getServPanelDtls(this,\'HA\',\'";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\');\" ";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\'></td>\n\t\t\t\t\t\t<td class=\"gridData\" colspan =\'3\' >\n\t\t\t\t\t\t<div id=\"charge_details_ha_";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\" style=\'visible:hidden;display:none\'>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'checked_in_date_time_";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\' id=\'checked_in_date_time_";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\'   value=\'";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'checked_out_date_time_";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\' id=\'checked_out_date_time_";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\'>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_accession_num_";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\' id=\'bl_accession_num_";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\'>\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'holding_seq_num_";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\' id=\'holding_seq_num_";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\'    value=\'";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\'>\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'holding_area_code_";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\' id=\'holding_area_code_";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\'  value=\'";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\'>\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'calc_charge_units_";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\' id=\'calc_charge_units_";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\'>\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'modified_charge_units_ha_";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\' id=\'modified_charge_units_ha_";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\'  value=\'\'>\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'serv_code_ha_";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\' id=\'serv_code_ha_";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\'  value=\'\'>\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'include_exclude_ha_";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\' id=\'include_exclude_ha_";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\'  value=\'\'>\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'appr_reqd_val_ha_";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\' id=\'appr_reqd_val_ha_";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\'  value=\'\'>\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'action_reason_code_ha_";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\' id=\'action_reason_code_ha_";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\'  value=\'\'>\t\n                        ";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 =" ><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<input type=\'hidden\' name=\'bl_accession_num_";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\'>\t\n\t\t\t\t\t\t<input type=\'hidden\' name=\'chargeable_units_";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\' id=\'chargeable_units_";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\'  value=\'\'>\t\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\t\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\'checkbox\'  class=\'label\' name=\'doc_compl_ha\' id=\'doc_compl_ha\' onClick=\'validateCheckBox_ha();\' disabled checked >\n\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\t\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\'checkbox\'  class=\'label\' name=\'doc_compl_ha\' id=\'doc_compl_ha\' onClick=\'validateCheckBox_ha();\' ";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 =" >\n\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\n\t\t\t\t\t\t</tr>\n\t\t\n                        </table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t   ";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\n                      ";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td><table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th align=\"left\"><img name=\"RR_arrow\" src=\"../../eCommon/images/tree_handlerightlast.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuRR\',this);\" />";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaRR\' name=\'moreCriteriaRR\' id=\'moreCriteriaRR\' style=\'visible:hidden;display:none;overflow:auto;\' \n                        bordercolor=\'white\' > \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaRR\' name=\'moreCriteriaRR\' id=\'moreCriteriaRR\' style=\'visible:inline;overflow:auto;\'  bordercolor=\'white\'> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<div id=\"menuExpand10\" style=\'display:none;visibility:visible;overflow:auto;height:92px;width:100%\'>\n\t\t\t\t\t\t<table id=\"RR_arrow\" style=\'display:visible;overflow:auto;\'>\n                        <tr>\n\t\t\t\t\t\t<td class=\'fields\' width=\"32%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 =" &nbsp;&nbsp;\n\t\t\t\t\t\t   <input type=\'text\' class=\'fields\' name=\'chk_in_rec_date_time\' id=\'chk_in_rec_date_time\' size=\'12\'  value=\'";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\'  disabled>\n\t\t\t\t\t\t   \n\t\t\t\t\t\t    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\n                        <td class=\'fields\' width=\"32%\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 =" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t       <input type=\'text\' class=\'fields\' name=\'chk_out_rec_date_time\' id=\'chk_out_rec_date_time\' size=\'12\'  value=\'";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 =" &nbsp;&nbsp;\n\t\t\t\t\t\t\n\t\t\t\t\t\t    <input type=\'text\' class=\'fields\' name=\'charge_units_rec\' id=\'charge_units_rec\' size=\'3\'  maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\' onblur=\"getServPanelDtls(this,\'REC\');\" ";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t</td> \n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'label\' ></td>\n\t\t\t\t\t\t<td class=\"gridData\" colspan =\'4\' >\n\t\t\t\t\t\t<div id=\"charge_details_1\" style=\'visible:hidden;display:none\'>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\n\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\t\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\'checkbox\'  class=\'label\' name=\'doc_compl_rec\' id=\'doc_compl_rec\' onClick=\'validateCheckBox_rec();\' disabled checked>\n\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\t\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t<input type=\'checkbox\'  class=\'label\' name=\'doc_compl_rec\' id=\'doc_compl_rec\' onClick=\'validateCheckBox_rec();\' ";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 =">\n\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\n\t\t\t\t\t\t</tr>\t\n                        </table>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\n\n\t\t\t\t<!--Added by lakshmi for crf-0601 starts here-->\n\t\t\t\t";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 =" <!--Muthu Modified -->\n\t\t\t\t\t\t<table width=\"100%\" border=\"0\" >\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th align=\"left\"><img name=\"PR_arrow\" src=\"../../eCommon/images/tree_handlerightlast.gif\" alt=\"Arrow\" height=\"20\" align=\"middle\" onclick=\"expandMenu(\'menuPR\',this);\" /> ";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="</th>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaPR\' name=\'moreCriteriaPR\' id=\'moreCriteriaPR\' style=\'visible:hidden;display:none;overflow:auto;\' \n\t\t\t\t\t\tbordercolor=\'white\' > </table>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\n\t\t\t\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=0 width=\'100%\'  id=\'moreCriteriaPR\' name=\'moreCriteriaPR\' id=\'moreCriteriaPR\' style=\'visible:inline;overflow:auto;\'  bordercolor=\'white\'> \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<div id=\"menuExpand11\" style=\'display:none;visibility:visible;overflow:auto;height:92px;width:100%\'>\n\t\t\t\t\t\t<table id=\"PR_arrow\" style=\'display:visible;overflow:auto;\'>\n                        <tr>\n\t\t\t\t\t\t<td  class=\'Label\' width=\"25%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\t\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'checkbox\'  class=\'label\' name=\'summary\' id=\'summary\' onClick=\'validateCheckboxSummary()\' >\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td  class=\'Label\' width=\"25%\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\t\n\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t<input type=\'checkbox\'  class=\'label\' name=\'pros_impl\' id=\'pros_impl\' onClick=\'validateCheckboxProsthesis()\' >\n\t\t\t\t\t\t</td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\n\t\t\t\t\t\t<td class=\'Label\' width=\"25%\">\n\t\t\t\t\t\t<input type=\'button\'  class=\'label\' name=\'print\' id=\'print\' value=\'Print\' onClick=\'OnPrintReport()\' >\n\t\t\t\t\t\t</td>\n                        </tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<!--Added by lakshmi for crf-0601 ends here-->\n           <input type=\'hidden\' name=\'module_id\' id=\'module_id\'       value=\'";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\'>\n\t\t\t<input type=\'hidden\' name=\'hld_chrg_cmp_yn\' id=\'hld_chrg_cmp_yn\' value=\'";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\'>\n\t\t\t<input type=\'hidden\' name=\'or_chrg_cmp_yn\' id=\'or_chrg_cmp_yn\'  value=\'";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\'>\n\t\t\t<input type=\'hidden\' name=\'rec_chrg_cmp_yn\' id=\'rec_chrg_cmp_yn\' value=\'";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\'>\n\t\t\t<input type=\'hidden\' name=\'serv_date\' id=\'serv_date\'       value=\'";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\'>\n\t\t\t<input type = \"hidden\" name= \"rec_implants_in_admin_notes_yn\" value=\"";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\">\n\t\t\t<input type = \"hidden\" name= \"rec_packs_in_admin_notes_yn\"  value =\"";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\">\n\t\t\t<input type = \"hidden\" name= \"rec_equp_in_admin_notes_yn\"  value =\"";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\">\n\t\t\t<input type = \"hidden\" name= \"rec_instr_in_admin_notes_yn\"  value =\"";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\">\n\t\t\t<input type = \"hidden\" name= \"st_interface_flag\"  value =\"";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\">\n\t\t\t<input type = \"hidden\" name= \"oper_room_code\"  value =\"";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\">\n\t\t\t<input type = \"hidden\" name= \"params\"       value = \"";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\">\n\t\t\t<input type = \"hidden\" name= \"patient_class1\"       value = \"";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\">\n\t\t\t<input type = \"hidden\" name= \"locale\"       value = \"";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\">\n\t\t\t<input type = \"hidden\" name= \"facility_id\"  value=";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 =" >\n\t\t    <input type = \"hidden\" name= \"flag_op\"      value=\"";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\">\n\t\t    <input type = \"hidden\" name= \"flag_ac\"      value=\"";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\">\n\t\t    <input type = \"hidden\" name= \"flag_dc\"      value=\"";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\">\n\t\t    <input type = \"hidden\" name= \"flag_pi\"      value=\"";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\">\n\t\t    <input type = \"hidden\" name= \"flag_cp\"      value=\"";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\">\n\t\t    <input type = \"hidden\" name= \"flag_eq\"      value=\"";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\">\n\t\t    <input type = \"hidden\" name= \"flag_ic\"      value=\"";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\">\n\t\t    <input type = \"hidden\" name= \"flag_or\"      value=\"";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\">\n\t\t    <input type = \"hidden\" name= \"flag_ha\"      value=\"";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\">\n\t\t    <input type = \"hidden\" name= \"flag_rr\"      value=\"";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\">\n\t\t    <input type = \"hidden\" name= \"flag_asc\"     value=\"";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\">\n\t\t\t<!--Added by lakshmi for crf-0601-->\n\t\t\t<input type = \"hidden\" name= \"flag_pr\"      value=\"";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\">\n\t\t\t<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'oper_code\' id=\'oper_code\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'oper_line_no\' id=\'oper_line_no\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n\t\t\t<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\"";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\">\n\t\t\t<input type=\'hidden\' name=\'bill_flag\' id=\'bill_flag\' value=\"";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\">\n\t\t\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\">\n\t\t\t<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\"";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\">\n\t\t\t<input type=\'hidden\' name=\'check_into_or_time\' id=\'check_into_or_time\' value=\"";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\">\n\t\t\t<input type=\'hidden\' name=\'check_out_or_time\' id=\'check_out_or_time\' value=\"";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\">\n\t\t\t<input type=\'hidden\' name=\'oper_room_code_or\' id=\'oper_room_code_or\' value=\"";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\">\n\t\t    <input type=\'hidden\' name=\'serv_code_or\' id=\'serv_code_or\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'modified_charge_units_or\' id=\'modified_charge_units_or\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'or_bl_accession_num\' id=\'or_bl_accession_num\' value=\"";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\">\n\t\t\t<input type=\'hidden\' name=\'booking_num\' id=\'booking_num\' value=\"";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\">\n\t\t\t<input type=\'hidden\' name=\'surgeon_code\' id=\'surgeon_code\' value=\"";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\">\n\t\t\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\"";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\">\n\t\t\t<input type=\'hidden\' name=\'recovery_room_code\' id=\'recovery_room_code\' value=\"";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\">\n\t\t\t<input type=\'hidden\' name=\'recovery_start_time\' id=\'recovery_start_time\' value=\"";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\">\n\t\t\t<input type=\'hidden\' name=\'recovery_end_time\' id=\'recovery_end_time\' value=\"";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\">\n\t\t\t<input type=\'hidden\' name=\'serv_code\' id=\'serv_code\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'recv_bl_accession_num\' id=\'recv_bl_accession_num\' value=\"";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\">\n\t\t\t<input type=\'hidden\' name=\'modified_charge_units\' id=\'modified_charge_units\' value=\"\">\n\t\t\t<input type=\'hidden\' name=\'maxRecord\' id=\'maxRecord\' value=\"";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\">\n\t\t\t<input type=\'hidden\' name=\'encounter_id1\' id=\'encounter_id1\' value=\"";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\">\n\t\t\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=\"";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\">\n\t\t\t<input type=\'hidden\' name=\'visit_id1\' id=\'visit_id1\' value=\"";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\">\n\t\t\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\"";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\">\n\t\t\t<input type=\'hidden\' name=\'order_id1\' id=\'order_id1\' value=\"";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\">\n\t\t\t<input type=\'hidden\' name=\'str_order_catalog_code\' id=\'str_order_catalog_code\' value=\"";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\">\n\t\t\t<input type=\'hidden\' name=\'ref_source_code\' id=\'ref_source_code\' value=\"";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\">\n\t\t\t<input type=\'hidden\' name=\'operation_sub_services_yn\' id=\'operation_sub_services_yn\' value=\"";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\">\n\t\t\t<input type=\'hidden\' name=\'trfr_ward_code\' id=\'trfr_ward_code\' value=\"";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\">\n\t\t\t<input type=\'hidden\' name=\'implant_entry_cmp_yn\' id=\'implant_entry_cmp_yn\' value=\"";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\">\n\t\t\t<input type=\'hidden\' name=\'consumable_entry_cmp_yn\' id=\'consumable_entry_cmp_yn\' value=\"";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\">\n\t\t\t<input type=\'hidden\' name=\'equipment_entry_cmp_yn\' id=\'equipment_entry_cmp_yn\' value=\"";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\">\n\t\t\t<input type=\'hidden\' name=\'instrument_entry_cmp_yn\' id=\'instrument_entry_cmp_yn\' value=\"";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\">\n\t\t\t<input type=\'hidden\' name=\'recy_room_finalization_stage\' id=\'recy_room_finalization_stage\' value=\"";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\">\n\t\t\t<input type=\'hidden\' name=\'hold_finalization_stage\' id=\'hold_finalization_stage\' value=\"";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\">\n\t\t\t<input type=\'hidden\' name=\'oper_room_finalization_stage\' id=\'oper_room_finalization_stage\' value=\"";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\">\n\t\t\t<input type=\'hidden\' name=\'charge_holding_area_yn\' id=\'charge_holding_area_yn\' value=\"";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\">\n\t\t\t<input type=\'hidden\' name=\'charge_operating_room_yn\' id=\'charge_operating_room_yn\' value=\"";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\">\n\t\t\t<input type=\'hidden\' name=\'charge_recovery_room_yn\' id=\'charge_recovery_room_yn\' value=\"";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\">\n\t\t\t<input type=\'hidden\' name=\'rec_chargeable_yn\' id=\'rec_chargeable_yn\' value=\"";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\">\n\t\t\t<input type=\'hidden\' name=\'or_chargeable_yn\' id=\'or_chargeable_yn\' value=\"";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\">\n\t\t\t<input type=\'hidden\' name=\'oper_finalization_stage\' id=\'oper_finalization_stage\' value=\"";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\">\n\t\t\t<input type=\'hidden\' name=\'proc_chrg_cmp_yn\' id=\'proc_chrg_cmp_yn\' value=\"";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\">\n\t\t\t<input type=\'hidden\' name=\'slate_user_id\' id=\'slate_user_id\' value=\"";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\">\n\t\t\t<input type=\'hidden\' name=\'st_charge_based_yn\' id=\'st_charge_based_yn\' value=\"";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\">\n\t\t\t<input type=\'hidden\' name=\'mm_item_code\' id=\'mm_item_code\' value=\"";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\">\n\t\t\t<input type=\'hidden\' name=\'surgeon_code1\' id=\'surgeon_code1\' value=\"";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\">\n\t\t\t<input type=\'hidden\' name=\'include_exclude1\' id=\'include_exclude1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'include_exclude_or\' id=\'include_exclude_or\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'appr_reqd_val1\' id=\'appr_reqd_val1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'appr_reqd_val_or\' id=\'appr_reqd_val_or\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'calc_chrge_units_rec\' id=\'calc_chrge_units_rec\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'calc_chrge_units_or\' id=\'calc_chrge_units_or\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'action_reason_code1\' id=\'action_reason_code1\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'action_reason_code_or\' id=\'action_reason_code_or\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'p_ord_practitioner_id\' id=\'p_ord_practitioner_id\' value=\'";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\'>\t\n\t\t\t<!-- Modified by Muthukumar on 21-10-11-->\n\t\t<input type=\'hidden\' name=\'customer_id1\' id=\'customer_id1\' value=\"";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\">\n\t\t\t<!-- Modified by Muthukumar on 21-10-11-->\n\t\t\t<!--Added by lakshmi for crf-0601 starts here-->\n\t\t\t<input type=\'hidden\' name=\'p_oper_num\' id=\'p_oper_num\' value=\"";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\">\n\t\t\t<input type=\'hidden\' name=\'p_patient_id\' id=\'p_patient_id\' value=\"";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\">\n\t\t\t<input type =\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\"";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\">\n\t\t\t<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\"";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\">\n\t\t\t<!--Added by lakshmi for crf-0601 ends here-->\n\t\t\t<input type=\'hidden\' name=\'Ot_param\' id=\'Ot_param\' value=\"";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\"><!--Added by lakshmi against crf-0058-->\n\t\t\t<input type=\"hidden\" name=\"checkInTime\" id=\"checkInTime\" id=\"checkInTime\" value=\"";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\">\n\t\t\t<input type=\'hidden\' name=\'oneWeekDate\' id=\'oneWeekDate\' id=\'oneWeekDate\' value=\"";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\">\n\t\t\t<input type=\'hidden\' name=\'tab_name\' id=\'tab_name\' value=\"";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\">\n\n\t\t</form>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}

	
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

 
	String encode(String data){	  
		String outDat = "";
		byte byteData[] = data.getBytes();
		for (int i=0; i<byteData.length; i++){
			outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
		}
		return(outDat);
   }	


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String or_bean_id 				    = "Or_billingQueryBean";
	String or_bean_name 			    = "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean	= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;

	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean	= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

	String st_bean_id 				    = "ottransactionbean";
	String st_bean_name 			    = "eST.OTTransactionBean";
	OTTransactionBean st_bean	= (OTTransactionBean)getBeanObject(st_bean_id, st_bean_name, request ) ;
	
	//Added Against ML-MMOH-CRF-1939-US4...starts
	String facility_id     = (String)session.getValue("facility_id");
	String tab_name     = checkForNull((String)request.getParameter("tab_name"));//Added Against ML-MMOH-SCF-2510
	Connection con=null;
	String fpp_category="";
	String Include_Fpp_yn = "";
	boolean isIncludeFpp = false;
	ArrayList Fpplist = new ArrayList();
    String fpp_order_yn = "N";
	String fpp_def_category = "";
	Integer count =0;
	String ot_bean_id = "OTCommonBean";
	String ot_bean_name = "eOT.OTCommonBean";
	OTCommonBean bean = (OTCommonBean)mh.getBeanObject( ot_bean_id, request, ot_bean_name );
	try{	
			con = ConnectionManager.getConnection(request);
			Include_Fpp_yn = bean.getIncludeFpp(facility_id);
			isIncludeFpp = CommonBean.isSiteSpecific(con,"OT","OT_FPP");
			count = bean.getFppIcon();
		}catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Error="+e);
		}
	//Added Against ML-MMS-QH-CRF-1939-US4...ends
 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);
 String bill_flag = checkForNull(request.getParameter("bill_flag")); 
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(("true").equals(bill_flag)){
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
 if(("true").equals(bill_flag)){
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(("true").equals(bill_flag)){
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
}
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
}
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
}
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
}
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
}
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
}
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
}
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag110(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag111(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag112(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag113(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
}
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag114(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag115(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag116(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag117(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag118(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag119(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
}
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag120(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);
if(("true").equals(bill_flag)){
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag121(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag122(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag123(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag124(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag125(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
}
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag126(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag127(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag128(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag129(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag130(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag131(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
 if(Include_Fpp_yn.equals("Y") && isIncludeFpp && count==1 && (bill_flag.equals("true"))){
            _bw.write(_wl_block94Bytes, _wl_block94);

	}
	
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag132(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag133(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag134(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag135(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag136(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag137(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag138(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag139(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag140(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag141(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag142(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag143(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

	String frm_pick_list = "N";
    String disable_flag = "";
	String flag_op = checkForNull(request.getParameter("flag_op"))==""?"Y":request.getParameter("flag_op");
	String flag_ac = checkForNull(request.getParameter("flag_ac"))==""?"Y":request.getParameter("flag_ac");
	String flag_dc = checkForNull(request.getParameter("flag_dc"))==""?"Y":request.getParameter("flag_dc");
	String flag_pi = checkForNull(request.getParameter("flag_pi"))==""?"Y":request.getParameter("flag_pi");
	String flag_cp = checkForNull(request.getParameter("flag_cp"))==""?"Y":request.getParameter("flag_cp");
	String flag_eq = checkForNull(request.getParameter("flag_eq"))==""?"Y":request.getParameter("flag_eq");
	String flag_ic = checkForNull(request.getParameter("flag_ic"))==""?"Y":request.getParameter("flag_ic");
	String flag_or = checkForNull(request.getParameter("flag_or"))==""?"Y":request.getParameter("flag_or");
	String flag_ha = checkForNull(request.getParameter("flag_ha"))==""?"Y":request.getParameter("flag_ha");
	String flag_rr = checkForNull(request.getParameter("flag_rr"))==""?"Y":request.getParameter("flag_rr");
	String flag_asc = checkForNull(request.getParameter("flag_asc"))==""?"Y":request.getParameter("flag_asc");
	//Added by lakshmi
	String flag_pr = checkForNull(request.getParameter("flag_pr"))==""?"Y":request.getParameter("flag_pr");
	String slate_user_id   = checkForNull(request.getParameter("slate_user_id"));
	String module_id       = CommonBean.checkForNull(request.getParameter("module_id"));
	String called_from     = checkForNull(request.getParameter("called_from"));
	String oper_num        = checkForNull(request.getParameter("oper_num"));
	String patient_id      = checkForNull(request.getParameter("patient_id"));
	String booking_num     = checkForNull(request.getParameter("booking_num"));
	String surgeon_code    = checkForNull(request.getParameter("surgeon_code"));
	String surgeon_code1    = "";
	String speciality_code = checkForNull(request.getParameter("speciality_code"));
	String params	       = request.getQueryString();
	String oper_code= "";
	String description= "";
	String oper_remarks= "";
	String order_line_no = "";
	String side_applicable="";
	String st_charge_based_yn="";
	
	String serv_date="";
	String rate="";
	String posted_yn="";
	//added by lakshmi for crf-0601
	String p_report_id="";
	CallableStatement statement =null;
	String arr[]=null;
	String val= "";
	HashMap line_no_map = new HashMap();
	String line_no="";
	boolean exist_rec_pi   = false;
	boolean exist_rec_cons = false;
	boolean exist_rec_eq   = false;
	boolean exist_rec_ic   = false;
	boolean pick_list      = false;
	StringBuffer oper_codes = new StringBuffer();
	String side_applicalbe_desc= "";
	String rightSide_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RightSide.Label","ot_labels");
	String leftSide_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.LeftSide.Label","ot_labels");
	String bilateral=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Bilateral.Label","ot_labels");
	String notApplicable_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
	con=null;
	PreparedStatement pstmt_sm_report_display = null; //muthu
	PreparedStatement pstmt_ot_post_oper_hdr = null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt2=null;
	PreparedStatement pstmt_bl=null;
	PreparedStatement pstmt_st = null;
	PreparedStatement pstmt_pi = null;
	PreparedStatement pstmt_cons=null;
	PreparedStatement pstmt_eq=null;
	PreparedStatement pstmt_ic=null;
	PreparedStatement pstmt_ha_room = null;
	PreparedStatement pstmt_rec_chargeyn = null;
	PreparedStatement pstmt_or_chargeableyn= null;
	PreparedStatement pstmt_req_store= null;
	PreparedStatement pstm_bl= null;
	PreparedStatement pstmt_param_for_facility= null;
	ResultSet rs=null;
	ResultSet rst_sm_report_display=null; //muthu
	ResultSet rst_ot_post_oper_hdr=null;
	ResultSet rs_bl=null;
	ResultSet rst_bl=null;
	ResultSet rset_req_store=null;
	ResultSet rst_st = null;
	ResultSet rst_pi = null;
	ResultSet rst_cons=null;
	ResultSet rst_eq=null;
	ResultSet rst_ic=null;
	ResultSet rst_ha_room = null;
	ResultSet rst_rec_chargeyn = null;
	ResultSet rst_or_chargeyn = null;
	PreparedStatement pstmt_ord_phy_id=null;
	ResultSet rset_one=null;
	ResultSet rst_param_for_facility=null;
	String tr_no="";
	String ref_source_code="";
	String req_store_code="";
	String bill_yn="";
	String billed_yn="";
    String rec_implants_in_admin_notes_yn="";
	String rec_equp_in_admin_notes_yn="";
	String rec_instr_in_admin_notes_yn="";
	String rec_packs_in_admin_notes_yn="";
	String st_interface_flag="";
	String st_doc_type_rti="";
	String st_doc_type_sli="";
	String operation_sub_services_yn="";
	String charge_holding_area_yn="";
	String charge_operating_room_yn="";
	String charge_recovery_room_yn="";
	String oper_line_num="";
	String oper_finalization_stage="";
	String recy_room_finalization_stage="";
	String hold_finalization_stage="";
	String oper_room_finalization_stage="";
	String finalize_packs_in="";
	    //Bharati
	String st_location="";
	String desiredDate = "";
	String currentDateTime = "";
	String oneWeekDate = "";
	HashMap bill_info     =new HashMap();
	HashMap bill_info_pi  =new HashMap();
	HashMap bill_info_cons=new HashMap();
	HashMap bill_info_eq  =new HashMap();
	HashMap bill_info_ic  =new HashMap();
	HashMap bill_info_reqd_dtls =new HashMap();
//Added by lakshmi against CRF-0058
	PreparedStatement pstmt_sm_report_display1 = null;
	ResultSet rst_sm_report_display1=null;
try{
	con = ConnectionManager.getConnection(request);
	//Added by lakshmi against CRF-0058 starts here	
	
		String Ot_param="";
		//Modified by Rajesh
		String sql_sm_report1="select NVL(INSTRUMENT_CSSD_IMAGE,'N') PICKLIST from OT_PARAM where rownum = 1";
		//Modified by Rajesh
		pstmt_sm_report_display1=con.prepareStatement(sql_sm_report1);
		rst_sm_report_display1=pstmt_sm_report_display1.executeQuery();
		if(rst_sm_report_display1 !=null && rst_sm_report_display1.next())
	   {
		Ot_param=checkForNull(rst_sm_report_display1.getString("PICKLIST"));
		
	   }
	   if(rst_sm_report_display1!=null)rst_sm_report_display1.close();
	   if(pstmt_sm_report_display1!=null)pstmt_sm_report_display1.close();
	   //Added by lakshmi against CRF-0058 ends here
	String sql_param_for_facility="SELECT OPER_FINALIZATION_STAGE,NVL(RECY_ROOM_FINALIZATION_STAGE,'X') RECY_ROOM_FINALIZATION_STAGE, NVL(HOLD_FINALIZATION_STAGE,'X') HOLD_FINALIZATION_STAGE, NVL(OPER_ROOM_FINALIZATION_STAGE,'X')OPER_ROOM_FINALIZATION_STAGE,OPERATION_SUB_SERVICES_YN,CHARGE_HOLDING_AREA_YN, CHARGE_OPERATING_ROOM_YN, CHARGE_RECOVERY_ROOM_YN,NVL(REC_IMPLANTS_IN_ADMIN_YN,'N') REC_IMPLANTS_IN_ADMIN_YN, NVL(REC_EQUP_IN_ADMIN_YN,'N') REC_EQUP_IN_ADMIN_YN,NVL(REC_INSTR_IN_ADMIN_YN,'N')REC_INSTR_IN_ADMIN_YN,NVL(REC_PACKS_IN_ADMIN_YN,'N')REC_PACKS_IN_ADMIN_YN,NVL(ST_INTERFACE_FLAG,'N') ST_INTERFACE_FLAG,NVL(FINALIZE_PACKS_IN,'N')FINALIZE_PACKS_IN,ST_DOC_TYPE_RTI,ST_DOC_TYPE_SLI FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID='"+facility_id+"'";

	pstmt_param_for_facility=con.prepareStatement(sql_param_for_facility);
	rst_param_for_facility=pstmt_param_for_facility.executeQuery(sql_param_for_facility);
	if(rst_param_for_facility !=null && rst_param_for_facility.next())
    {
	oper_finalization_stage=checkForNull(rst_param_for_facility.getString("OPER_FINALIZATION_STAGE"));
	recy_room_finalization_stage=checkForNull(rst_param_for_facility.getString("RECY_ROOM_FINALIZATION_STAGE"));
	hold_finalization_stage=checkForNull(rst_param_for_facility.getString("HOLD_FINALIZATION_STAGE"));
	oper_room_finalization_stage=checkForNull(rst_param_for_facility.getString("OPER_ROOM_FINALIZATION_STAGE"));
	operation_sub_services_yn=checkForNull(rst_param_for_facility.getString("OPERATION_SUB_SERVICES_YN"));
	charge_holding_area_yn=checkForNull(rst_param_for_facility.getString("CHARGE_HOLDING_AREA_YN"));
	charge_operating_room_yn=checkForNull(rst_param_for_facility.getString("CHARGE_OPERATING_ROOM_YN"));
	charge_recovery_room_yn=checkForNull(rst_param_for_facility.getString("CHARGE_RECOVERY_ROOM_YN"));
	rec_implants_in_admin_notes_yn=checkForNull(rst_param_for_facility.getString("REC_IMPLANTS_IN_ADMIN_YN"));
	rec_equp_in_admin_notes_yn=checkForNull(rst_param_for_facility.getString("REC_EQUP_IN_ADMIN_YN"));
	rec_instr_in_admin_notes_yn=checkForNull(rst_param_for_facility.getString("REC_INSTR_IN_ADMIN_YN"));
	rec_packs_in_admin_notes_yn=checkForNull(rst_param_for_facility.getString("REC_PACKS_IN_ADMIN_YN"));
	st_interface_flag=checkForNull(rst_param_for_facility.getString("ST_INTERFACE_FLAG"));

	finalize_packs_in=checkForNull(rst_param_for_facility.getString("FINALIZE_PACKS_IN"));
	st_doc_type_rti =checkForNull(rst_param_for_facility.getString("ST_DOC_TYPE_RTI"));
	st_doc_type_sli=checkForNull(rst_param_for_facility.getString("ST_DOC_TYPE_SLI"));

	if(("Y").equals(st_interface_flag))
	{
	 if(("").equals(st_doc_type_rti) || ("").equals(st_doc_type_sli))
	 {
		out.println("<script>alert(getMessage('PRC-OT0055','OT')); window.close();</script>");
	 }
	}
	}
	currentDateTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM", locale);
	if(locale.equals("th"))
	currentDateTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM", "en"); //Modified against SKR-SCF-1289
	System.err.println("currentDateTime===>"+currentDateTime);
	oneWeekDate = com.ehis.util.DateUtils.plusDate((com.ehis.util.DateUtils.plusDate(com.ehis.util.DateUtils.getCurrentDate("DMY", locale), "DMY", locale, 1, "d")), "DMY", locale, 1, "w");	//048580
		
     String SQL_OP = "";
    if(isIncludeFpp  && count==1 && Include_Fpp_yn.equals("Y") && ("true").equals(bill_flag)){
		SQL_OP="SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM,A.RIGHT_LEFT_FLAG,A.OPER_REMARKS,A.ORDER_LINE_NUM ORDER_LINE_NUM,A.ORDER_ID ORDER_ID,A.OPER_LINE_STATUS OPER_LINE_STATUS,A.CANCEL_REMARKS CANCEL_REMARKS ,B.LONG_DESC OPR_DESC,B.ORDER_CATALOG_CODE ORDER_CATALOG_CODE,A.FPP_CATEGORY FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B WHERE  A.OPERATING_FACILITY_ID  = '"+facility_id+"' AND A.OPER_NUM = '"+oper_num+"' AND A.OPER_CODE = B.OPER_CODE AND B.LANGUAGE_ID = '"+locale+"'" ; //MODIFIED Against ML-MMS-QH-CRF-1939-US4
		}else{
		SQL_OP="SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM,A.RIGHT_LEFT_FLAG,A.OPER_REMARKS,A.ORDER_LINE_NUM ORDER_LINE_NUM,A.ORDER_ID ORDER_ID,A.OPER_LINE_STATUS OPER_LINE_STATUS,A.CANCEL_REMARKS CANCEL_REMARKS ,B.LONG_DESC OPR_DESC,B.ORDER_CATALOG_CODE ORDER_CATALOG_CODE FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B WHERE  A.OPERATING_FACILITY_ID ='"+facility_id+"' AND A.OPER_NUM = '"+oper_num+"' AND A.OPER_CODE = B.OPER_CODE AND B.LANGUAGE_ID = '"+locale+"'";//MMS-QH-CRF-0199			
		}
	
	pstmt = con.prepareStatement(SQL_OP,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	rs  = pstmt.executeQuery();	
    
	String p_qty = "";
	String key = "";
	String key_pi = "";
	String key_cons = "";
	String key_eq = "";
	String key_ic = "";
	String key_line="";
	String key_line_pi="";
	String key_line_cons="";
	String key_line_eq="";
	String key_line_ic="";
	String bill_str="";
	String panel_str="";
	
	StringBuilder bl_bfr = new StringBuilder();
	String order_id="";
	String order_line_num="";
	String booking_date  = "";
	String encounter_id   = "";
	String patient_class   = "";
	String visit_id   = "";
	String catalog_code   = "";

	String item_id="";
	String req_store="";
	String sql_mm_code="";
	String mm_item_code="";
	String avail_stock="";
	String oper_room_code="";
    String sale_document_no="";
	String no_of_units="";
	String sale_document_type="";
	
	String recovery_start_time="";
	String recovery_start_time1="";
	String recovery_end_time="";
	String recovery_end_time1="";
	String recv_calc_chargeable_units="";
	String recv_chargeable_units="";
	String recv_bl_accession_num="";
	String recovery_room_code="";
	String holding_area_code="";
	String holding_seq_num="";
	String checked_in_date_time="";
	String checked_out_date_time="";
	String checked_in_date_time1="";
	String checked_out_date_time1="";
	String calc_chargeable_units="";
	String chargeable_units="";
	String bl_accession_num="";
   	String trfr_ward_code="";
	String oper_status="";    
	String oper_room_code_or="";
	String check_into_or_time="";
	String check_into_or_time1="";
	String check_out_or_time="";
	String check_out_or_time1="";
	String or_calc_chargeable_units="";
	String or_chargeable_units="";
	String or_bl_accession_num="";
	String disable_rec=""; 
	String disable_or=""; 
	String disable_ha=""; 

	String encounter_id1="";
	String episode_id="";
	String episode_type="";
	String visit_id1="";
	String nature_type="";
	String nature_code="";
	String order_id1="";
	String str_order_catalog_code="";
	String order_catalog="";
	
	String implant_entry_cmp_yn="";
	String consumable_entry_cmp_yn="";
	String equipment_entry_cmp_yn="";
	String instrument_entry_cmp_yn="";
	
	String rec_chargeable_yn="";
	String or_chargeable_yn="";
	String hld_chrg_cmp_yn="";
    String or_chrg_cmp_yn="";
    String rec_chrg_cmp_yn="";
	String checkInTime = "";
	String impl_disable_flag="";
	String cons_disable_flag="";
	String eq_disable_flag="";
	String ic_disable_flag="";
	String bl_episode_type="";
	String cancel_remarks="";
	String oper_line_status= ""; 
	String proc_chrg_cmp_yn= ""; 
	//Muthu Modified on 21-10-11
	String customer_id1="";
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1";
	pstmt_sm_report_display=con.prepareStatement(sql_sm_report);
	rst_sm_report_display=pstmt_sm_report_display.executeQuery();
	if(rst_sm_report_display !=null && rst_sm_report_display.next())
	   {
		customer_id1=checkForNull(rst_sm_report_display.getString("customer_id"));
	   }
	   if(rst_sm_report_display!=null)rst_sm_report_display.close();
if(pstmt_sm_report_display!=null)pstmt_sm_report_display.close();
	//Muthu Modified on 21-10-11
  
    int maxRecord=0;
	   String sql_ot_post_oper_hdr="SELECT DECODE (?, 'en', TO_CHAR (check_in_time, 'DD/MM/YYYY HH24:MI'), 'th', TO_CHAR (check_in_time, 'DD/MM/YYYY HH24:MI', 'NLS_CALENDAR=''THAI BUDDHA''' ) ) check_in_time, encounter_id, episode_id, episode_type, visit_id, nature_type,nature_code, order_id, ref_source_code, implant_entry_cmp_yn, consumable_entry_cmp_yn, equipment_entry_cmp_yn, INSTRUMENT_ENTRY_CMP_YN,NVL(HLD_CHRG_CMP_YN,'N')HLD_CHRG_CMP_YN,NVL(OR_CHRG_CMP_YN  ,'N')OR_CHRG_CMP_YN ,NVL(REC_CHRG_CMP_YN  ,'N') REC_CHRG_CMP_YN,PATIENT_CLASS,NVL(PROC_CHRG_CMP_YN  ,'N')PROC_CHRG_CMP_YN,RECVERY_ROOM_CODE,TO_CHAR(RECOVERY_START_TIME,'MM/DD/YYYY HH24:MI') RECOVERY_START_TIME,TO_CHAR(RECOVERY_START_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_START_TIME1,TO_CHAR(RECOVERY_END_TIME,'MM/DD/YYYY HH24:MI') RECOVERY_END_TIME,TO_CHAR(RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_END_TIME1,RECV_CALC_CHARGEABLE_UNITS, RECV_CHARGEABLE_UNITS, RECV_BL_ACCESSION_NUM,TRFR_WARD_CODE,OPER_STATUS,OPER_ROOM_CODE,TO_CHAR(CHECK_INTO_OR_TIME,'MM/DD/YYYY HH24:MI') CHECK_INTO_OR_TIME,TO_CHAR(CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_OR_TIME1,TO_CHAR(CHECK_OUT_TIME,'MM/DD/YYYY HH24:MI') CHECK_OUT_TIME,TO_CHAR(CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI') CHECK_OUT_TIME1,OR_CALC_CHARGEABLE_UNITS, OR_CHARGEABLE_UNITS, OR_BL_ACCESSION_NUM,PATIENT_ID,(SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') FROM DUAL) SERV_DATE,SURGEON_CODE FROM OT_POST_OPER_HDR  WHERE OPERATING_FACILITY_ID ='"+facility_id+"' AND OPER_NUM='"+oper_num+"'"; 	//048580
	   pstmt_ot_post_oper_hdr=con.prepareStatement(sql_ot_post_oper_hdr);
	   pstmt_ot_post_oper_hdr.setString(1, locale);
	   rst_ot_post_oper_hdr=pstmt_ot_post_oper_hdr.executeQuery();
       
	   if(rst_ot_post_oper_hdr !=null && rst_ot_post_oper_hdr.next())
	   {
		encounter_id1=checkForNull(rst_ot_post_oper_hdr.getString("ENCOUNTER_ID"));
		episode_id=checkForNull(rst_ot_post_oper_hdr.getString("EPISODE_ID"));
		episode_type=checkForNull(rst_ot_post_oper_hdr.getString("EPISODE_TYPE"));
		visit_id1=checkForNull(rst_ot_post_oper_hdr.getString("VISIT_ID"));
		nature_type=checkForNull(rst_ot_post_oper_hdr.getString("NATURE_TYPE"));
		nature_code=checkForNull(rst_ot_post_oper_hdr.getString("NATURE_CODE"));
		order_id1=checkForNull(rst_ot_post_oper_hdr.getString("ORDER_ID"));
		ref_source_code=checkForNull(rst_ot_post_oper_hdr.getString("REF_SOURCE_CODE"));
		implant_entry_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("IMPLANT_ENTRY_CMP_YN"));
		consumable_entry_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("CONSUMABLE_ENTRY_CMP_YN"));
		equipment_entry_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("EQUIPMENT_ENTRY_CMP_YN"));
		instrument_entry_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("INSTRUMENT_ENTRY_CMP_YN"));
		hld_chrg_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("HLD_CHRG_CMP_YN"));
		or_chrg_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("OR_CHRG_CMP_YN"));
		rec_chrg_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("REC_CHRG_CMP_YN"));
		patient_class=checkForNull(rst_ot_post_oper_hdr.getString("PATIENT_CLASS"));
		proc_chrg_cmp_yn=checkForNull(rst_ot_post_oper_hdr.getString("PROC_CHRG_CMP_YN"));
		recovery_room_code=checkForNull(rst_ot_post_oper_hdr.getString("RECVERY_ROOM_CODE"));
		recovery_start_time1=checkForNull(com.ehis.util.DateUtils.convertDate(rst_ot_post_oper_hdr.getString("RECOVERY_START_TIME1"),"DMYHM","en",locale));
		recovery_start_time=checkForNull(rst_ot_post_oper_hdr.getString("RECOVERY_START_TIME"));
		recovery_end_time1=checkForNull(com.ehis.util.DateUtils.convertDate(rst_ot_post_oper_hdr.getString("RECOVERY_END_TIME1"),"DMYHM","en",locale));
		recovery_end_time=checkForNull(rst_ot_post_oper_hdr.getString("RECOVERY_END_TIME"));
		recv_calc_chargeable_units=checkForNull(rst_ot_post_oper_hdr.getString("RECV_CALC_CHARGEABLE_UNITS"));
		recv_chargeable_units=checkForNull(rst_ot_post_oper_hdr.getString("RECV_CHARGEABLE_UNITS"));
		recv_bl_accession_num=checkForNull(rst_ot_post_oper_hdr.getString("RECV_BL_ACCESSION_NUM"));
		trfr_ward_code=checkForNull(rst_ot_post_oper_hdr.getString("TRFR_WARD_CODE"));
		oper_status=checkForNull(rst_ot_post_oper_hdr.getString("OPER_STATUS"));
		oper_room_code=checkForNull(rst_ot_post_oper_hdr.getString("OPER_ROOM_CODE"));
		oper_room_code_or=checkForNull(rst_ot_post_oper_hdr.getString("OPER_ROOM_CODE"));
		check_into_or_time1=checkForNull(com.ehis.util.DateUtils.convertDate(rst_ot_post_oper_hdr.getString("CHECK_INTO_OR_TIME1"),"DMYHM","en",locale));
		check_into_or_time=checkForNull(rst_ot_post_oper_hdr.getString("CHECK_INTO_OR_TIME"));
		check_out_or_time1=checkForNull(com.ehis.util.DateUtils.convertDate(rst_ot_post_oper_hdr.getString("CHECK_OUT_TIME1"),"DMYHM","en",locale));
		check_out_or_time=checkForNull(rst_ot_post_oper_hdr.getString("CHECK_OUT_TIME"));
		or_calc_chargeable_units=checkForNull(rst_ot_post_oper_hdr.getString("OR_CALC_CHARGEABLE_UNITS"));
		or_chargeable_units=checkForNull(rst_ot_post_oper_hdr.getString("OR_CHARGEABLE_UNITS"));
		or_bl_accession_num=checkForNull(rst_ot_post_oper_hdr.getString("OR_BL_ACCESSION_NUM"));
		patient_id=checkForNull(rst_ot_post_oper_hdr.getString("PATIENT_ID"));
		serv_date=checkForNull(rst_ot_post_oper_hdr.getString("SERV_DATE"));
		surgeon_code1=checkForNull(rst_ot_post_oper_hdr.getString("SURGEON_CODE"));	
		checkInTime = checkForNull(rst_ot_post_oper_hdr.getString("check_in_time"));
		System.err.println("AdministrativeFunctionforAllChargesFrame.jsp, locale====>"+locale);
		//Added Against SKR-SCF-1289 Starts
		if(locale.equals("th"))
		{
			String arr1[]=null;
			String arr2[]=null;
			arr1 = checkInTime.split(" ");
			arr2 = arr1[0].split("/");
			int a = Integer.parseInt(arr2[2]);
			a = a-543;
			checkInTime = arr2[0] + "/" + arr2[1] + "/" + a + " " + arr1[1];
			}
		//Added Against SKR-SCF-1289 Ends
		}
		String p_ord_practitioner_id="";
		String sql_phy_id="SELECT ORD_PRACT_ID from or_order where order_id='"+order_id1+"'";
		pstmt_ord_phy_id=con.prepareStatement(sql_phy_id);
		rset_one=pstmt_ord_phy_id.executeQuery();
		if(rset_one !=null && rset_one.next())
		{
		p_ord_practitioner_id =rset_one.getString("ORD_PRACT_ID");
		if(p_ord_practitioner_id ==null) p_ord_practitioner_id="";	
		}

		String sql_bl_epi_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		pstmt_bl = con.prepareStatement(sql_bl_epi_type);
		rst_bl=pstmt_bl.executeQuery();
		if(rst_bl !=null && rst_bl.next())
		{
		bl_episode_type=checkForNull(rst_bl.getString(1));
		}
				
		bill_info_reqd_dtls.put("patient_id",patient_id);
		bill_info_reqd_dtls.put("encounter_id",encounter_id1);
		bill_info_reqd_dtls.put("episode_id",episode_id);
		bill_info_reqd_dtls.put("visit_id",visit_id1);
		bill_info_reqd_dtls.put("serv_date",serv_date);
		bill_info_reqd_dtls.put("pract_staff_id",surgeon_code1);
		bill_info_reqd_dtls.put("patient_class",patient_class);
		bill_info_reqd_dtls.put("bl_episode_type",bl_episode_type);
		bill_info_reqd_dtls.put("order_id",order_id1);

		if(("Y").equals(implant_entry_cmp_yn))    impl_disable_flag="disabled";
		if(("Y").equals(consumable_entry_cmp_yn)) cons_disable_flag="disabled";
		if(("Y").equals(equipment_entry_cmp_yn))  eq_disable_flag="disabled";
		if(("Y").equals(instrument_entry_cmp_yn)) ic_disable_flag="disabled";
		if(("Y").equals(rec_chrg_cmp_yn))         disable_rec="disabled";
		if(("Y").equals(hld_chrg_cmp_yn))         disable_ha="disabled";
		if(("Y").equals(or_chrg_cmp_yn))          disable_or="disabled";

	if(("R").equals(recy_room_finalization_stage))disable_rec="disabled";
    if(("H").equals(hold_finalization_stage))     disable_ha="disabled";
    if(("O").equals(oper_room_finalization_stage))disable_or="disabled";

	String sql_rec_chargeyn="SELECT NVL(CHARGEABLE_YN,'N') FROM OT_RECOVERY_ROOM_LANG_VW WHERE RECOVERY_ROOM_CODE ='"+recovery_room_code+"' AND OPERATING_FACILITY_ID='"+facility_id+"' and language_id='"+locale+"'";
	pstmt_rec_chargeyn=con.prepareStatement(sql_rec_chargeyn);
	rst_rec_chargeyn=pstmt_rec_chargeyn.executeQuery();
		if(rst_rec_chargeyn !=null && rst_rec_chargeyn.next())
		{
			rec_chargeable_yn=rst_rec_chargeyn.getString(1);
		}
	if(("").equals(recovery_start_time) || ("").equals(recovery_end_time)) disable_rec="disabled";

    String SQL_HA_ROOM="SELECT HOLDING_AREA_CODE,TO_CHAR(CHECKED_IN_DATE_TIME,'DD/MM/YYYY HH24:MI') CHECKED_IN_DATE_TIME,TO_CHAR(CHECKED_OUT_DATE_TIME,'DD/MM/YYYY HH24:MI') CHECKED_OUT_DATE_TIME,TO_CHAR(CHECKED_IN_DATE_TIME,'MM/DD/YYYY HH24:MI') CHECKED_IN_DATE_TIME1,TO_CHAR(CHECKED_OUT_DATE_TIME,'MM/DD/YYYY HH24:MI') CHECKED_OUT_DATE_TIME1, CALC_CHARGEABLE_UNITS,CHARGEABLE_UNITS, BL_ACCESSION_NUM, HOLDING_SEQ_NUM FROM OT_OPER_HOLDING_DTLS WHERE  OPERATING_FACILITY_ID   ='"+facility_id+"' AND OPER_NUM='"+oper_num+"' AND HOLDING_AREA_CODE IN (SELECT HOLDING_AREA_CODE FROM OT_HOLDING_AREAS WHERE OPERATING_FACILITY_ID ='"+facility_id+"'AND NVL(CHARGEABLE_YN,'N') ='Y')	ORDER BY HOLDING_SEQ_NUM";
    pstmt_ha_room=con.prepareStatement(SQL_HA_ROOM,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
	rst_ha_room = pstmt_ha_room.executeQuery();
	int total=0;
	while(rst_ha_room.next()){
			total++;
	}
	maxRecord = total;
	if(maxRecord==0)disable_ha="disabled";
	rst_ha_room.beforeFirst();
   
	String sql_or_chargeableyn="SELECT NVL(CHARGEABLE_YN,'N') FROM OT_OPER_ROOM_LANG_VW WHERE OPER_ROOM_CODE ='"+oper_room_code_or+"' AND OPERATING_FACILITY_ID='"+facility_id+"' and language_id='"+locale+"'";

    pstmt_or_chargeableyn=con.prepareStatement(sql_or_chargeableyn);
	rst_or_chargeyn=pstmt_or_chargeableyn.executeQuery();
	if(rst_or_chargeyn !=null && rst_or_chargeyn.next())
	{
	  or_chargeable_yn=rst_or_chargeyn.getString(1);
	}

    if(("").equals(check_into_or_time) || ("").equals(check_out_or_time)) disable_or="disabled";
	
	//below query checks whether we have already record in OT_PICK_LISTS Table if returns true="PICK_LIST_DEFINED Qry is executed "
	String PICK_LIST_EXIST_YN = "SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID='"+facility_id+"' AND (BOOKING_NUM='"+booking_num+"' OR OPER_NUM='"+oper_num+"') AND ROWNUM=1";
    PreparedStatement pstmt_pl = null;
	ResultSet rst_pl = null;
	String rst_acc_code = "";
	String rst_tr_no = "";
	int index=0;
	  /* just Checking pick list exist or not particular accessory_type as told by Dilip on 24-06-2009*/
		pstmt_pl = con.prepareStatement(PICK_LIST_EXIST_YN);
		rst_pl = pstmt_pl.executeQuery();
		if(rst_pl.next()){
			pick_list=true;
		}
		if(rst_pl!=null)rst_pl.close();
		if(pstmt_pl!=null)pstmt_pl.close();
		int fetch_count = 0;
		while(rs.next()){
			oper_line_status = checkForNull(rs.getString("OPER_LINE_STATUS"));
			if(!("99").equals(oper_line_status))
			{
			++fetch_count;
			if(fetch_count==1)
			oper_codes.append("'"+rs.getString("OPR_CODE")+"'");
			else
			 oper_codes.append(","+"'"+rs.getString("OPR_CODE")+"'");
			 line_no_map.put(rs.getString("OPR_CODE"),rs.getString("LN_NUM"));
			}
		}
	    /* below query added by sathish as told by Dilip */
		if(("Y").equals(st_interface_flag))
		{
		PreparedStatement pstmt_charge_based= null;
		ResultSet rs_charge_based=null;
		String sql_chrage_based_yn="SELECT BL_INTERFACE_YN  FROM ST_ACC_ENTITY_PARAM";
		pstmt_charge_based=con.prepareStatement(sql_chrage_based_yn);

		rs_charge_based=pstmt_charge_based.executeQuery();
		if(rs_charge_based !=null && rs_charge_based.next())
		 {
		 st_charge_based_yn=checkForNull(rs_charge_based.getString("BL_INTERFACE_YN"));
		 }
		}
           /* &&&&&&&&&&&&&&& Prothesis Impalnts Query &&&&&&&&&&&&&&&&*/
			if(("Y").equals(rec_implants_in_admin_notes_yn))
		    {
			String SQL_PI = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.ACCESSORY_CODE) ACC_DESC,GET_DESC('"+locale+"','MM_STORE_LANG_VW','SHORT_DESC','STORE_CODE',A.REQ_STORE_CODE) Store_desc, A.QUANTITY TR_NO, A.PROSTHESIS_MFR MFR,A.PROSTHESIS_BATCH_NO BTCH, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY,A.SALE_DOCUMENT_TYPE SALE_DOCUMENT_TYPE ,A.SALE_DOCUMENT_NO SALE_DOCUMENT_NO,A.EXCL_INCL_IND, A.ACTION_REASON_CODE FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PROSTHESIS_LANG_VW C WHERE A.OPERATING_FACILITY_ID='"+facility_id+"'AND A.OPER_NUM='"+oper_num+"' AND ACCESSORY_TYPE = 'S' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PROSTHESIS_CODE AND C.LANGUAGE_ID='"+locale+"' ";//MMS-QH-CRF-0199

			pstmt_pi = con.prepareStatement(SQL_PI,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			rst_pi = pstmt_pi.executeQuery();

            if(rst_pi.next()){
			exist_rec_pi=true;
		    }
		 if(exist_rec_pi==true){
            rst_pi.beforeFirst();
			while(rst_pi.next()){
				++index;	
			
			key_pi = checkForNull(rst_pi.getString("KEY"));
			key_line_pi = checkForNull(rst_pi.getString("KEY_LINE"));
			item_id=checkForNull(rst_pi.getString("ACC_CODE"));
			req_store_code=	checkForNull(rst_pi.getString("REQ_STORE_CODE"));
			sale_document_type=	checkForNull(rst_pi.getString("SALE_DOCUMENT_TYPE"));
			sale_document_no=	checkForNull(rst_pi.getString("SALE_DOCUMENT_NO"));
			String excl_incl_ind_st=	checkForNull(rst_pi.getString("EXCL_INCL_IND"));
			String action_reason_code_st=	checkForNull(rst_pi.getString("ACTION_REASON_CODE"));

            if(excl_incl_ind_st=="") excl_incl_ind_st=null;
            if(action_reason_code_st=="") action_reason_code_st=null;
			
			if(("true").equals(bill_flag))
			{
			bill_info_pi = or_bean.getOrderBillDtls(key_pi+key_line_pi);
		   if(!("").equals(item_id))
		    {
			try 
			{
			sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_id+"'";
			pstmt_st=con.prepareStatement(sql_mm_code);
			rst_st=pstmt_st.executeQuery();
			if(rst_st !=null && rst_st.next())
			{
			mm_item_code=checkForNull(rst_st.getString(1));
			}
			String[] stParameters = {mm_item_code,req_store_code , "0", "N", "", "N", "" };
			HashMap hmStockAvailabilityStatus = st_bean.getStockAvailabilityStatus(stParameters);
			avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");
			}catch(Exception e)
			{
			avail_stock="";
			e.printStackTrace();
			}
			}
			if(("N").equals(st_interface_flag))
			{
			if(bill_info_pi==null){
				bill_info_pi = new HashMap();
				bill_info_pi.put("key",key_pi);
				bill_info_pi.put("key_line_no",key_line_pi);
				rst_acc_code = rst_pi.getString("ACC_CODE");
				bill_info_pi.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info_pi.put("acc_type","I");
				bill_info_pi.put("oper_num",oper_num);
				bill_info_pi.put("locale",locale);
				bill_info_pi.put("module_id","OT");
				rst_tr_no = rst_pi.getString("TR_NO");
				bill_info_pi.put("quantity",rst_tr_no);
				bill_info_pi.put("rate",rate);
				//populate billing details from OTBillingBean........	
				
				bill_info_pi = billing_bean.getBillingParamsForAdmin(bill_info_pi,"C",bill_info_reqd_dtls);//C-> for Surgical Accessories Billing

			   //set billing details from OTBillingBean........	

				or_bean.setOrderBillDtls(key_pi+key_line_pi,bill_info_pi);
				putObjectInBean(or_bean_id,or_bean,request);
				}
			panel_str = (String) bill_info_pi.get("bl_panel_str");	
			bl_bfr.append(checkForNull(""+bill_info_pi.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_pi.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_pi.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_pi.get("charged_yn"),"N")).append("::");
			bl_bfr.append(excl_incl_ind_st).append("::");
			bl_bfr.append(checkForNull(""+bill_info_pi.get("preapp_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_pi.get("serv_panel_ind"),"S")).append("::");
			bl_bfr.append(action_reason_code_st).append("::");
			bl_bfr.append(checkForNull(""+bill_info_pi.get("incl_excl_ind"),"E"));
			bill_str = bl_bfr.toString();
			bl_bfr.setLength(0);
			}else
			{
		   if(!("").equals(req_store_code))
		   {//Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			statement=con.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
		   String sal_trn_type="";
		   rst_tr_no = rst_pi.getString("TR_NO");
		   if(("IP").equals(patient_class))
			{
				sal_trn_type="I";
			}else if(("OP").equals(patient_class))
			{
			sal_trn_type="O";
			}else if(("EM").equals(patient_class))
			{
			sal_trn_type="E";
			}else if(("DC").equals(patient_class))
			{
			sal_trn_type="D";
			}else if(("XT").equals(patient_class))
			{
			sal_trn_type="R";
			}
			p_qty=rst_tr_no;
			
			statement.setString(1, facility_id);
			statement.setString(2, patient_id);
			statement.setString(3, "ST");
			statement.setString(4, encounter_id1);
			statement.setString(5, sal_trn_type);
			statement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
			statement.setString(7, mm_item_code);
			statement.setString(8, req_store);
			statement.setInt(9, Integer.parseInt(p_qty));
			statement.setString(10, ";");

			statement.registerOutParameter(11, Types.VARCHAR);
			statement.registerOutParameter(12, Types.VARCHAR);
			statement.registerOutParameter(13, Types.VARCHAR);
			statement.registerOutParameter(14, Types.VARCHAR);
			statement.registerOutParameter(15, Types.FLOAT);
			statement.registerOutParameter(16, Types.FLOAT);
			statement.registerOutParameter(17, Types.FLOAT);
			statement.registerOutParameter(18, Types.FLOAT);
			statement.registerOutParameter(19, Types.FLOAT);
			statement.registerOutParameter(20, Types.FLOAT);
			statement.registerOutParameter(21, Types.FLOAT);
			statement.registerOutParameter(22, Types.FLOAT);
			statement.registerOutParameter(23, Types.FLOAT);
			statement.registerOutParameter(24, Types.FLOAT);
			statement.registerOutParameter(25, Types.FLOAT);
			statement.registerOutParameter(26, Types.FLOAT);
			statement.registerOutParameter(27, Types.FLOAT);
			statement.registerOutParameter(28, Types.FLOAT);
			statement.registerOutParameter(29, Types.VARCHAR);
			statement.registerOutParameter(30, Types.FLOAT);
			statement.registerOutParameter(31, Types.VARCHAR);
			statement.registerOutParameter(32, Types.VARCHAR);
			statement.registerOutParameter(33, Types.VARCHAR);
			statement.registerOutParameter(34, Types.VARCHAR);
			statement.registerOutParameter(35, Types.VARCHAR);
			statement.registerOutParameter(36, Types.VARCHAR);
			statement.registerOutParameter(37, Types.VARCHAR);
			statement.registerOutParameter(38, Types.VARCHAR);
			statement.setString(39, excl_incl_ind_st);
			statement.setString(40, action_reason_code_st);
			statement.setString(41, "N"); //Internal Adjestment
            statement.setString(42, sale_document_type);
		    statement.setString(43, sale_document_no);
		    statement.setString(44, "1");
			//Maheshwaran K added for the  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			//Start
			statement.setString(45, "N");//p_discharge_ind
			statement.registerOutParameter(46, Types.VARCHAR);//p_drug_penalty_str
			//End
            statement.execute();
			   
				if(excl_incl_ind_st=="") excl_incl_ind_st=null;
				if(action_reason_code_st=="") action_reason_code_st=null;
				
                String override_value=statement.getString(37);
				bl_bfr.append(checkForNull(""+statement.getString(21),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(25),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(38),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");
				bl_bfr.append(excl_incl_ind_st).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(36),"N")).append("::");
				bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value always in the screen   but there is no concept of service or panel through St billing.
				bl_bfr.append(action_reason_code_st).append("::");
				bl_bfr.append(checkForNull(""+excl_incl_ind_st,"E")).append("::");// this value is for just front end screen purpose not inserting into databse.
				bl_bfr.append(override_value);
			
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0); 
					}
			}
			}
			 frm_pick_list="N";
			            //Added encode for REMKS on 10/18/2010 by AnithaJ
			out.println("<script>loadDBRows_pi('"+checkForNull(rst_pi.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_pi.getString("OPR_DESC")))+"','"+checkForNull(rst_pi.getString("LN_NUM"))+"','"+checkForNull(rst_pi.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_pi.getString("ACC_DESC")))+"','"+checkForNull(rst_pi.getString("TR_NO"))+"','"+checkForNull(rst_pi.getString("MFR"))+"','"+checkForNull(rst_pi.getString("BTCH"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_pi.getString("REMKS")),"UTF-8")+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key_pi+"','"+key_line_pi+"','"+checkForNull(rst_pi.getString("REQ_STORE_CODE"))+"','"+checkForNull(rst_pi.getString("RESERVED_QTY"))+"','"+checkForNull(rst_pi.getString("REQUESTED_QTY"))+"','"+no_of_units+"','"+sale_document_no+"','"+sale_document_type+"','"+avail_stock+"','"+checkForNull(rst_pi.getString("Store_desc"))+"','"+frm_pick_list+"','"+booking_num+"'); </script>");	
		}
		if(rst_pi!=null)rst_pi.close();
		if(pstmt_pi!=null)pstmt_pi.close();
		out.println("<script>assignRecId_pi()</script>");
		}
	    else if(("").equals(implant_entry_cmp_yn))
	     { 
		  if(pick_list==true)
		  { 
			String PICK_LIST_DEFINED_PI="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.ITEM_ID) ACC_DESC,GET_DESC('"+locale+"','MM_STORE_LANG_VW','SHORT_DESC','STORE_CODE',A.REQ_STORE_CODE) Store_desc,NVL(A.NO_OF_UNITS,1) TR_NO,A.REQ_STORE_CODE, A.RESERVED_QTY RESERVED_QTY, A.REQUESTED_QTY REQUESTED_QTY,A.SALE_DOCUMENT_TYPE SALE_DOCUMENT_TYPE,A.SALE_DOCUMENT_NO SALE_DOCUMENT_NO,A.REQ_DOCUMENT_TYPE REQ_DOCUMENT_TYPE,A.REQ_DOCUMENT_NO REQ_DOCUMENT_NO,NVL(A.NO_OF_UNITS,1) NO_OF_UNITS FROM  OT_PICK_LISTS A, OT_PROSTHESIS_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'S' AND A.ITEM_ID = B.PROSTHESIS_CODE AND B.LANGUAGE_ID='"+locale+"'"; //MMS-QH-CRF-0199

			pstmt_pi = con.prepareStatement(PICK_LIST_DEFINED_PI);
			pstmt_pi.setString(1,facility_id);
			pstmt_pi.setString(2,patient_id);
			pstmt_pi.setString(3,booking_num);
			pstmt_pi.setString(4,oper_num);
			rst_pi = pstmt_pi.executeQuery();
		   while(rst_pi.next()){
			++index;	
			line_no = (String)line_no_map.get(rst_pi.getString("OPR_CODE"));
		    if(("true").equals(bill_flag))
			{
			item_id=checkForNull(rst_pi.getString("ACC_CODE"));
			req_store=checkForNull(rst_pi.getString("REQ_STORE_CODE"));
			sale_document_no=checkForNull(rst_pi.getString("SALE_DOCUMENT_NO"));
			sale_document_type=checkForNull(rst_pi.getString("SALE_DOCUMENT_TYPE"));
			no_of_units=checkForNull(rst_pi.getString("NO_OF_UNITS"));
		   if(!item_id.equals(""))
		  {
            try 
			 {
				sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_id+"'";
				pstmt_st=con.prepareStatement(sql_mm_code);
				rst_st=pstmt_st.executeQuery();
				if(rst_st !=null && rst_st.next())
				{
				mm_item_code=rst_st.getString(1);
				}
				
				String[] stParameters = {mm_item_code,req_store , "0", "N", "", "N", "" };
				HashMap hmStockAvailabilityStatus = st_bean.getStockAvailabilityStatus(stParameters);
				avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");
			  }catch(Exception e)
				{
				avail_stock="";
				e.printStackTrace();
				}
              }
			    if(("N").equals(st_interface_flag))
				{
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "I#"+rst_pi.getString("ACC_CODE");
				key_pi = oper_num+"@"+rst_pi.getString("OPR_CODE")+"@S@"+rst_pi.getString("ACC_CODE");
				key_line_pi="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				p_qty = rst_pi.getString("TR_NO");
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_pi			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info_pi.putAll(hash);
				bill_info_pi.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key_pi,bill_info_pi);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info_pi.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info_pi.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_pi.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_pi.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_pi.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_pi.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_pi.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_pi.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
			  }else
			 {
			  if(!("").equals(req_store))
			  {//Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			  statement=con.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			 String sal_trn_type="";
			 p_qty = rst_pi.getString("TR_NO");
		     if(("IP").equals(patient_class))
			 {
				sal_trn_type="I";
			 }else if(("OP").equals(patient_class))
			 {
			 sal_trn_type="O";
			 }else if(("EM").equals(patient_class))
			 {
			 sal_trn_type="E";
			 }else if(("DC").equals(patient_class))
			 {
			 sal_trn_type="D";
			 }else if(("XT").equals(patient_class))
			 {
			 sal_trn_type="R";
			 }
			 
			 statement.setString(1, facility_id);
			 statement.setString(2, patient_id);
			 statement.setString(3, "ST");
			 statement.setString(4, encounter_id1);
			 statement.setString(5, sal_trn_type);
			 statement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
			 statement.setString(7, mm_item_code);
			 statement.setString(8, req_store);
			 statement.setInt(9, Integer.parseInt(p_qty));
			 statement.setString(10, ";");

			statement.registerOutParameter(11, Types.VARCHAR);
			statement.registerOutParameter(12, Types.VARCHAR);
			statement.registerOutParameter(13, Types.VARCHAR);
			statement.registerOutParameter(14, Types.VARCHAR);
			statement.registerOutParameter(15, Types.FLOAT);
			statement.registerOutParameter(16, Types.FLOAT);
			statement.registerOutParameter(17, Types.FLOAT);
			statement.registerOutParameter(18, Types.FLOAT);
			statement.registerOutParameter(19, Types.FLOAT);
			statement.registerOutParameter(20, Types.FLOAT);
			statement.registerOutParameter(21, Types.FLOAT);
			statement.registerOutParameter(22, Types.FLOAT);
			statement.registerOutParameter(23, Types.FLOAT);
			statement.registerOutParameter(24, Types.FLOAT);
			statement.registerOutParameter(25, Types.FLOAT);
			statement.registerOutParameter(26, Types.FLOAT);
			statement.registerOutParameter(27, Types.FLOAT);
			statement.registerOutParameter(28, Types.FLOAT);
			statement.registerOutParameter(29, Types.VARCHAR);
			statement.registerOutParameter(30, Types.FLOAT);
			statement.registerOutParameter(31, Types.VARCHAR);
			statement.registerOutParameter(32, Types.VARCHAR);
			statement.registerOutParameter(33, Types.VARCHAR);
			statement.registerOutParameter(34, Types.VARCHAR);
			statement.registerOutParameter(35, Types.VARCHAR);
			statement.registerOutParameter(36, Types.VARCHAR);
			statement.registerOutParameter(37, Types.VARCHAR);
			statement.registerOutParameter(38, Types.VARCHAR);
			statement.setString(39, "");
			statement.setString(40, "");
			statement.setString(41, "N"); //Internal Adjestment
            statement.setString(42, sale_document_type);
		    statement.setString(43, sale_document_no);
		    statement.setString(44, "1");
			//Maheshwaran K added for the  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			//Start
			statement.setString(45, "N");//p_discharge_ind
			statement.registerOutParameter(46, Types.VARCHAR);//p_drug_penalty_str
			//End
            statement.execute();
			
                String overridden_action_reason_code=null;
			    String incl_excl=null;
			    incl_excl=statement.getString(35);
                String override_value=statement.getString(37);
				bl_bfr.append(checkForNull(""+statement.getString(21),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(25),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(38),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");
				bl_bfr.append(incl_excl).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(36),"N")).append("::");
				bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value always in the screen   but there is no concept of service or panel through St billing.
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+incl_excl,"E")).append("::");// this value is for just front end screen purpose not inserting into databse.
				bl_bfr.append(override_value);
			
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0); 
			 }
			}
			}//end of if bill_flag

		    frm_pick_list="Y";
			out.println("<script>loadDBRows_pi('"+checkForNull(rst_pi.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_pi.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_pi.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_pi.getString("ACC_DESC")))+"','"+checkForNull(rst_pi.getString("TR_NO"))+"','','','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key_pi+"','"+key_line_pi+"','"+checkForNull(rst_pi.getString("REQ_STORE_CODE"))+"','"+checkForNull(rst_pi.getString("RESERVED_QTY"))+"','"+checkForNull(rst_pi.getString("REQUESTED_QTY"))+"','"+no_of_units+"','"+sale_document_no+"','"+sale_document_type+"','"+avail_stock+"','"+checkForNull(rst_pi.getString("Store_desc"))+"','"+frm_pick_list+"','"+booking_num+"'); </script>");	
			}//end of while loop
			if(rst_pi!=null)rst_pi.close();
			if(pstmt_pi!=null)pstmt_pi.close();
			
			out.println("<script>assignRecId_pi()</script>");
			 }else{
				 if(rst_pi!=null)rst_pi.close();
				 if(pstmt_pi!=null)pstmt_pi.close();
				 String Store_desc="";
				 String sql_req_code="SELECT a.STORE_CODE,b.SHORT_DESC FROM OT_STORES_FOR_THEATRE a, MM_STORE_LANG_VW b WHERE a.STORE_CODE=b.STORE_CODE AND  a.STORE_TYPE='R' AND a.OPERATING_FACILITY_ID='"+facility_id+"' AND a.OPER_ROOM_CODE='"+oper_room_code+"' and b.language_id='"+locale+"' and DEFAULT_YN='Y'";


					pstmt_req_store=con.prepareStatement(sql_req_code);
					rset_req_store = pstmt_req_store.executeQuery();
					if(rset_req_store !=null && rset_req_store.next())
					{
						req_store_code=rset_req_store.getString("STORE_CODE");
						Store_desc=rset_req_store.getString("SHORT_DESC");
						if(req_store_code ==null) req_store_code="";
						if(Store_desc ==null) Store_desc="";
					}
					String PICK_LIST_UNDEFINED_PI="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO FROM  OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")   UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC,  NVL(A.NO_OF_UNITS,1) TR_NO FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.PROSTHESIS_CODE  = B.PROSTHESIS_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC, NVL(A.NO_OF_UNITS,1) TR_NO   FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND  A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE     AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE      AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC,  NVL(A.NO_OF_UNITS,1) TR_NO FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE";  //MMS-QH-CRF-0199
					
							pstmt_pi = con.prepareStatement(PICK_LIST_UNDEFINED_PI);
							rst_pi = pstmt_pi.executeQuery();
			     while(rst_pi.next()){
					++index;	
					
					line_no = (String)line_no_map.get(rst_pi.getString("OPR_CODE"));
					item_id=checkForNull(rst_pi.getString("ACC_CODE"));
				if(!("").equals(item_id))
				{
				try 
				{    
				 sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_id+"'";
				 pstmt_st=con.prepareStatement(sql_mm_code);
				 rst_st=pstmt_st.executeQuery();
				 if(rst_st !=null && rst_st.next())
				 {
				 mm_item_code=checkForNull(rst_st.getString(1));
				 }
				 String[] stParameters = {mm_item_code,req_store_code , "0", "N", "", "N", "" };
				 HashMap hmStockAvailabilityStatus = st_bean.getStockAvailabilityStatus(stParameters);
				 avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");
				 }catch(Exception e)
				 {
				avail_stock="";
				e.printStackTrace();
				 }
				}

				if(("true").equals(bill_flag))
			    {
				if(("N").equals(st_interface_flag))
				{
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "I#"+rst_pi.getString("ACC_CODE");
				key = oper_num+"@"+rst_pi.getString("OPR_CODE")+"@S@"+rst_pi.getString("ACC_CODE");
				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				p_qty		= rst_pi.getString("TR_NO");
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst_pi.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","I");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",rst_pi.getString("TR_NO"));

				bill_info.putAll(hash);
				bill_info.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
			    bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
			    bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
		     }else{
		     if(!("").equals(req_store_code))
		     {
			 //Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			 statement=con.prepareCall("{ call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");
		     String sal_trn_type="";
		     p_qty		= rst_pi.getString("TR_NO");
		     if(("IP").equals(patient_class))
			 {
			 sal_trn_type="I";
			 }else if(("OP").equals(patient_class))
			 {
			 sal_trn_type="O";
			 }else if(("EM").equals(patient_class))
			 {
			 sal_trn_type="E";
			 }else if(("DC").equals(patient_class))
			 {
			 sal_trn_type="D";
			 }else if(("XT").equals(patient_class))
			 {
			 sal_trn_type="R";
			 }
			int p_qty1=Integer.parseInt(p_qty);
			statement.setString(1, facility_id);
			statement.setString(2, patient_id);
			statement.setString(3, "ST");
			statement.setString(4, encounter_id1);
			statement.setString(5, sal_trn_type);
			statement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
			statement.setString(7, mm_item_code);
			statement.setString(8, req_store);
			statement.setInt(9, p_qty1);
			statement.setString(10, ";");

			statement.registerOutParameter(11, Types.VARCHAR);
			statement.registerOutParameter(12, Types.VARCHAR);
			statement.registerOutParameter(13, Types.VARCHAR);
			statement.registerOutParameter(14, Types.VARCHAR);
			statement.registerOutParameter(15, Types.FLOAT);
			statement.registerOutParameter(16, Types.FLOAT);
			statement.registerOutParameter(17, Types.FLOAT);
			statement.registerOutParameter(18, Types.FLOAT);
			statement.registerOutParameter(19, Types.FLOAT);
			statement.registerOutParameter(20, Types.FLOAT);
			statement.registerOutParameter(21, Types.FLOAT);
			statement.registerOutParameter(22, Types.FLOAT);
			statement.registerOutParameter(23, Types.FLOAT);
			statement.registerOutParameter(24, Types.FLOAT);
			statement.registerOutParameter(25, Types.FLOAT);
			statement.registerOutParameter(26, Types.FLOAT);
			statement.registerOutParameter(27, Types.FLOAT);
			statement.registerOutParameter(28, Types.FLOAT);
			statement.registerOutParameter(29, Types.VARCHAR);
			statement.registerOutParameter(30, Types.FLOAT);
			statement.registerOutParameter(31, Types.VARCHAR);
			statement.registerOutParameter(32, Types.VARCHAR);
			statement.registerOutParameter(33, Types.VARCHAR);
			statement.registerOutParameter(34, Types.VARCHAR);
			statement.registerOutParameter(35, Types.VARCHAR);
			statement.registerOutParameter(36, Types.VARCHAR);
			statement.registerOutParameter(37, Types.VARCHAR);
			statement.registerOutParameter(38, Types.VARCHAR);
			statement.setString(39, "");
			statement.setString(40, "");
			statement.setString(41, "N"); //Internal Adjestment
            statement.setString(42, sale_document_type);
		    statement.setString(43, sale_document_no);
		    statement.setString(44, "1");
			//Maheshwaran K added for the  SKR-SCF-0788 [IN:039522] as on 24/09/2013
			//Start
			statement.setString(45, "N");//p_discharge_ind
			statement.registerOutParameter(46, Types.VARCHAR);//p_drug_penalty_str
			//End
            statement.execute();
			
                String overridden_action_reason_code=null;
			    String incl_excl=null;
                incl_excl=statement.getString(35);
                String override_value=statement.getString(37);
				
				bl_bfr.append(checkForNull(""+statement.getString(21),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(25),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(38),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");
				bl_bfr.append(incl_excl).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(36),"N")).append("::");
				bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value always in the screen   but there is no concept of service or panel through St billing.
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+incl_excl,"E")).append("::");//this value is just for showing front end screen only, its ot for inserting into database.
				bl_bfr.append(override_value);

				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0); 
				}	
				}
				}
             if(pstmt_st!=null)pstmt_st.close();
			 if(rst_st!=null)rst_st.close();

			frm_pick_list="N";
			out.println("<script>loadDBRows_pi('"+checkForNull(rst_pi.getString("OPR_CODE"))+"','"+checkForNull(rst_pi.getString("OPR_DESC"))+"','"+line_no+"','"+checkForNull(rst_pi.getString("ACC_CODE"))+"','"+checkForNull(rst_pi.getString("ACC_DESC"))+"','"+checkForNull(rst_pi.getString("TR_NO"))+"','','','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+req_store_code+"','','','','','','"+avail_stock+"','"+Store_desc+"','"+frm_pick_list+"','"+booking_num+"'); </script>");	


		}//end of while loop
		  if(pstmt_st!=null)pstmt_st.close();
		  if(rst_st!=null)rst_st.close();
		  if(rst_pi!=null)rst_pi.close();
		  if(pstmt_pi!=null)pstmt_pi.close();
		   out.println("<script>assignRecId_pi()</script>");
			 }
			}
		} else{
            out.println("<script>assignRecId_pi()</script>");
		}

	/* ################### Consumable Packs  Starts Here ################# */
        if(("Y").equals(rec_packs_in_admin_notes_yn))
	    {
		String SQL_CONS = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',C.PACKAGE_CODE) ACC_DESC, A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PACKAGE_HDR_LANG_VW C WHERE A.OPERATING_FACILITY_ID='"+facility_id+"' AND A.OPER_NUM='"+oper_num+"' AND ACCESSORY_TYPE = 'P' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PACKAGE_CODE AND C.LANGUAGE_ID='"+locale+"' ORDER BY BILL_SUB_REGN_LINE_NUM"; //MMS-QH-CRF-0199

			pstmt_cons = con.prepareStatement(SQL_CONS,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			rst_cons = pstmt_cons.executeQuery();
            if(rst_cons.next()){
			exist_rec_cons=true;
		    }
        if(exist_rec_cons==true)
	      {
			rst_cons.beforeFirst();
			while(rst_cons.next()){
			   ++index;	
			key_cons = rst_cons.getString("KEY");
			key_line_cons = rst_cons.getString("KEY_LINE");
			if(("true").equals(bill_flag))
			{
			bill_info_cons = or_bean.getOrderBillDtls(key_cons+key_line_cons);
			if(bill_info_cons==null){
				bill_info_cons = new HashMap();
				bill_info_cons.put("key",key_cons);
				bill_info_cons.put("key_line_no",key_line_cons);
				rst_acc_code = rst_cons.getString("ACC_CODE");
				bill_info_cons.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info_cons.put("acc_type","C");
				bill_info_cons.put("oper_num",oper_num);
				bill_info_cons.put("locale",locale);
				bill_info_cons.put("module_id","OT");
				//populate billing details from OTBillingBean........	
				rst_tr_no = rst_cons.getString("TR_NO");
				bill_info_cons.put("quantity",rst_tr_no);
				bill_info_cons = billing_bean.getBillingParamsForAdmin(bill_info_cons,"C",bill_info_reqd_dtls);//C-> for Surgical Accessories Billing
				or_bean.setOrderBillDtls(key_cons+key_line_cons,bill_info_cons);
				putObjectInBean(or_bean_id,or_bean,request);
			}
			panel_str = (String) bill_info_cons.get("bl_panel_str");
			String overridden_action_reason_code=null;
			String overridden_incl_excl_ind=null;
			bl_bfr.append(checkForNull(""+bill_info_cons.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_cons.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_cons.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_cons.get("charged_yn"),"N")).append("::");
			bl_bfr.append(overridden_incl_excl_ind).append("::");
			bl_bfr.append(checkForNull(""+bill_info_cons.get("preapp_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_cons.get("serv_panel_ind"),"S")).append("::");
			bl_bfr.append(overridden_action_reason_code).append("::");
			bl_bfr.append(checkForNull(""+bill_info_cons.get("incl_excl_ind"),"E"));
			bill_str = bl_bfr.toString();
			bl_bfr.setLength(0); 
			}//end of if bill_flag
			out.println("<script>loadDBRows_cons('"+checkForNull(rst_cons.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_cons.getString("OPR_DESC")))+"','"+checkForNull(rst_cons.getString("LN_NUM"))+"','"+checkForNull(rst_cons.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_cons.getString("ACC_DESC")))+"','"+checkForNull(rst_cons.getString("TR_NO"))+"',\""+java.net.URLEncoder.encode(checkForNull(rst_cons.getString("REMKS")),"UTF-8")+"\",'"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key_cons+"','"+key_line_cons+"');</script>");	

		}
		out.println("<script>assignRecId_cons()</script>");
		}
	  else if(("").equals(consumable_entry_cmp_yn)) {
		     if(pstmt_cons!=null)	pstmt_cons.close();
		     if(rst_cons!=null)      rst_cons.close();
			if(pick_list==true){
			    String PICK_LIST_DEFINED_CONS="SELECT A.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.ITEM_ID ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY FROM  OT_PICK_LISTS A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'P' AND A.ITEM_ID = B.PACKAGE_CODE";//MMS-QH-CRF-0199

				pstmt_cons = con.prepareStatement(PICK_LIST_DEFINED_CONS);
				pstmt_cons.setString(1,facility_id);
				pstmt_cons.setString(2,patient_id);
				pstmt_cons.setString(3,booking_num);
				pstmt_cons.setString(4,oper_num);
		
				rst_cons = pstmt_cons.executeQuery();
				while(rst_cons.next()){
					++index;	
					line_no = (String)line_no_map.get(rst_cons.getString("OPR_CODE"));
                if(("true").equals(bill_flag))
			    {
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "C#"+rst_cons.getString("ACC_CODE");
				key_cons = oper_num+"@"+rst_cons.getString("OPR_CODE")+"@S@"+rst_cons.getString("ACC_CODE");
				key_line_cons="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				p_qty		= rst_cons.getString("TR_NO");
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_cons			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info_cons.putAll(hash);
				bill_info_cons.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key_cons,bill_info_cons);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info_cons.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info_cons.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_cons.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_cons.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_cons.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_cons.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_cons.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_cons.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
		       /*oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order	*/	  out.println("<script>loadDBRows_cons('"+checkForNull(rst_cons.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_cons.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_cons.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_cons.getString("ACC_DESC")))+"','"+checkForNull(rst_cons.getString("TR_NO"))+"','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key_cons+"','"+key_line_cons+"'); </script>");	
			}//end of while loop
			if(pstmt_cons!=null)    pstmt_cons.close();
			if(rst_cons!=null)      rst_cons.close();
			out.println("<script>assignRecId_cons()</script>");
			}else {
				String PICK_LIST_UNDEFINED_CONS="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE,   GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.PACKAGE_CODE     = B.PACKAGE_CODE  AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL'AND A.SPECIALITY_CODE = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE    AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE     AND A.PACKAGE_CODE     = B.PACKAGE_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE  = D.OPER_SUB_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+")  AND C.OPER_CODE = D.OPER_CODE AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE  AND A.PACKAGE_CODE = B.PACKAGE_CODE";//MMS-QH-CRF-0199
			pstmt_cons = con.prepareStatement(PICK_LIST_UNDEFINED_CONS);
		
			rst_cons = pstmt_cons.executeQuery();
			while(rst_cons.next()){
				++index;	
				line_no = (String)line_no_map.get(rst_cons.getString("OPR_CODE"));
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "C#"+rst_cons.getString("ACC_CODE");
				key = oper_num+"@"+rst_cons.getString("OPR_CODE")+"@S@"+rst_cons.getString("ACC_CODE");
				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				p_qty		= rst_cons.getString("TR_NO");
				if(("true").equals(bill_flag))
			    {
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst_cons.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","C");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",p_qty);
				bill_info.putAll(hash);
				bill_info.put("quantity",rst_cons.getString("TR_NO"));
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
				panel_str = (String) bill_info.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E"));// just for front end screnn pupose only not inserting this value in to database.
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
			/*oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order	*/
	out.println("<script>loadDBRows_cons('"+checkForNull(rst_cons.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_cons.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_cons.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_cons.getString("ACC_DESC")) )+"','"+checkForNull(rst_cons.getString("TR_NO"))+"','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"'); </script>");	
		}//end of while loop
		if(pstmt_cons!=null)			pstmt_cons.close();
		if(rst_cons!=null)           rst_cons.close();
		//out.println("<script>refresh()</script>");
		out.println("<script>assignRecId_cons()</script>");

			}
	   }
	  }else {
		   out.println("<script>assignRecId_cons()</script>");
	   }

		/* ############################ END of Consumable Packs  ###################### */

		/* @@@@@@@@@@@@@@@@@@ Equipments  Starts Here @@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
        if(("Y").equals(rec_equp_in_admin_notes_yn))
	    {
		//SKR-SCF-0984 [IN:048580]
		String SQL_EQ = "SELECT a.oper_code opr_code, a.oper_line_num ln_num,get_desc ('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',a.oper_code) opr_desc,a.accessory_code acc_code,get_desc ('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',a.accessory_code) acc_desc,a.equipment_id euip_id, a.quantity tr_no, a.remarks remks,bill_sub_regn_num KEY, bill_sub_regn_line_num key_line, c.LOCATION,DECODE (?, 'en', NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI'),TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI')), 'th', NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI','NLS_CALENDAR=''THAI BUDDHA'''),TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI','NLS_CALENDAR=''THAI BUDDHA''')) ) desired_date,a.STATUS as OPER_LINE_STATUS FROM ot_surgical_accessories a, ot_oper_mast b, ot_equipment c WHERE a.operating_facility_id = '"+facility_id+"' AND a.oper_num = '"+oper_num+"' AND accessory_type = 'E' AND a.oper_code = b.oper_code AND a.accessory_code = c.equipment_code";//MMS-QH-CRF-0199
		pstmt_eq = con.prepareStatement(SQL_EQ,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);	
		pstmt_eq.setString(1,locale);
		rst_eq = pstmt_eq.executeQuery();
		if(rst_eq.next()){
			exist_rec_eq=true;
		}
		 if(exist_rec_eq==true)
	   	 {
			 rst_eq.beforeFirst();
			 while(rst_eq.next()){
		  	 ++index;	
			
			key_eq = rst_eq.getString("KEY");
			key_line_eq = rst_eq.getString("KEY_LINE");
			    //IN048103
			 st_location = checkForNull(rst_eq.getString("LOCATION"));
			 desiredDate = checkForNull(rst_eq.getString("desired_date"));
			if(("true").equals(bill_flag))// added this condition by sathish on 10-01-2009 to disabling billingpart 
			{
				bill_info_eq = or_bean.getOrderBillDtls(key_eq+key_line_eq);
				if(bill_info_eq==null){
					bill_info_eq = new HashMap();
					bill_info_eq.put("key",key_eq);
					bill_info_eq.put("key_line_no",key_line_eq);
					rst_acc_code = rst_eq.getString("ACC_CODE");
					String p_qty_eq= checkForNull(rst_eq.getString("TR_NO"));
					bill_info_eq.put("oper_code",rst_acc_code);//pass acc_code in oper_code
					bill_info_eq.put("acc_type","E");
					bill_info_eq.put("oper_num",oper_num);
					bill_info_eq.put("locale",locale);
					bill_info_eq.put("module_id","OT");
					bill_info_eq.put("quantity",p_qty_eq);
					//populate billing details from OTBillingBean........	
					bill_info_eq = billing_bean.getBillingParamsForAdmin(bill_info_eq,"C",bill_info_reqd_dtls);//C-> for Surgical Accessories Billing

					or_bean.setOrderBillDtls(key_eq+key_line_eq,bill_info_eq);
					putObjectInBean(or_bean_id,or_bean,request);
			}
				panel_str = (String) bill_info_eq.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;

				bl_bfr.append(checkForNull(""+bill_info_eq.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();

				bl_bfr.setLength(0);
			
			  }//end of if bill_flag
			out.println("<script>loadDBRows_eq('"+checkForNull(rst_eq.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("OPR_DESC")),"UTF-8")+"','"+checkForNull(rst_eq.getString("LN_NUM"))+"','"+checkForNull(rst_eq.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst_eq.getString("EUIP_ID"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("REMKS")),"UTF-8")+"','"+checkForNull(rst_eq.getString("OPER_LINE_STATUS"))+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key_eq+"','"+key_line_eq+"','"+checkForNull(rst_eq.getString("TR_NO"))+"','"+checkForNull(rst_eq.getString("LOCATION"))+"','"+desiredDate+"'); </script>"); 
			//Added(STATUS) for AMRI CRF 294
			
		  }
			if(rst_eq!=null)	 rst_eq.close();
			if(pstmt_eq !=null)  pstmt_eq.close();
			out.println("<script>assignRecId_eq()</script>");
		} 
		else if(equipment_entry_cmp_yn.equals("")||equipment_entry_cmp_yn.equals("N"))
		{ 
			 if(rst_eq!=null)	  rst_eq.close();
			 if(pstmt_eq !=null)  pstmt_eq.close();
             if(pick_list==true)
             {
			String PICK_LIST_DEFINED_EQ="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.ITEM_ID)  ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO FROM  OT_PICK_LISTS A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'E' AND A.ITEM_ID = B.EQUIPMENT_CODE";//MMS-QH-CRF-0199
			 pstmt_eq = con.prepareStatement(PICK_LIST_DEFINED_EQ);
			 pstmt_eq.setString(1,facility_id);
			 pstmt_eq.setString(2,patient_id);
			 pstmt_eq.setString(3,booking_num);
			 pstmt_eq.setString(4,oper_num);
			 rst_eq = pstmt_eq.executeQuery();
			 while(rst_eq.next()){
					++index;	
					line_no = (String)line_no_map.get(rst_eq.getString("OPR_CODE"));
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "E#"+rst_eq.getString("ACC_CODE");
				key_eq = oper_num+"@"+rst_eq.getString("OPR_CODE")+"@S@"+rst_eq.getString("ACC_CODE");
				key_line_eq="";
				booking_date    = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id    = (String)hash.get("encounter_id");
				surgeon_code    = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id	    = (String)hash.get("visit_id");
				
				if(("true").equals(bill_flag))
			    {
             		       String p_qty_eq= checkForNull(rst_eq.getString("TR_NO"));
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty_eq,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_eq			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info_eq.putAll(hash);
				
				bill_info_eq.put("quantity",p_qty_eq);
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key_eq,bill_info_eq);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info_eq.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info_eq.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
				String equip_id="";//Added Against Common Equipment Issue
		         //IN048103
			 out.println("<script>loadDBRows_eq('"+checkForNull(rst_eq.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("OPR_DESC")),"UTF-8")+"','"+line_no+"','"+checkForNull(rst_eq.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("ACC_DESC")),"UTF-8")+"','"+equip_id+"','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key_eq+"','"+key_line_eq+"','"+checkForNull(rst_eq.getString("TR_NO"))+"','"+st_location+"','"+currentDateTime+"'); </script>");	//047546
			 }//end of while loop
			 if(rst_eq!=null)	  rst_eq.close();
		     if(pstmt_eq !=null)  pstmt_eq.close();
			out.println("<script>assignRecId_eq()</script>");
			 }
			 else
		    {    if(rst_eq!=null)	  rst_eq.close();
		         if(pstmt_eq !=null)  pstmt_eq.close();
				 String PICK_LIST_UNDEFINED_EQ="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC, NVL(A.NO_OF_UNITS,1) TR_NO,B.location LOCATION FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE  A.APPLICABILITY = 'AOPR' AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE   AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC, NVL(A.NO_OF_UNITS,1) TR_NO,B.location LOCATION 	FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE   A.APPLICABILITY   = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN  ("+oper_codes.toString()+") AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION	SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO,B.location LOCATION  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY  = 'SCAT' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO,B.location LOCATION  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'  AND A.SPECIALITY_CODE       = D.OPER_GROUP_CODE  AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE  AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,  NVL(A.NO_OF_UNITS,1) TR_NO,B.location LOCATION FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY   = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE";//MMS-QH-CRF-0199
				pstmt_eq = con.prepareStatement(PICK_LIST_UNDEFINED_EQ);
				rst_eq = pstmt_eq.executeQuery();
				while(rst_eq.next()){
					++index;	
					
					line_no = (String)line_no_map.get(rst_eq.getString("OPR_CODE"));
				
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "E#"+rst_eq.getString("ACC_CODE");
				key = oper_num+"@"+rst_eq.getString("OPR_CODE")+"@S@"+rst_eq.getString("ACC_CODE");
				key_line="";
				booking_date	= (String)hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id	= (String)hash.get("encounter_id");
				surgeon_code	= (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id		= (String)hash.get("visit_id");
				    //IN048103
				 st_location= checkForNull(rst_eq.getString("LOCATION"));
					   if(("true").equals(bill_flag))
			    {
				String p_qty_eq= checkForNull(rst_eq.getString("TR_NO"));
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty_eq,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_eq			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst_eq.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","E");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",p_qty_eq);
				bill_info_eq.putAll(hash);
				
				bill_info_eq.put("quantity",p_qty_eq);
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key,bill_info_eq);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info_eq.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info_eq.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
				String equip_id="";
				
		
		out.println("<script>loadDBRows_eq('"+checkForNull(rst_eq.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("OPR_DESC")),"UTF-8")+"','"+line_no+"','"+checkForNull(rst_eq.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("ACC_DESC")),"UTF-8")+"','"+equip_id+"','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst_eq.getString("TR_NO"))+"','"+checkForNull(rst_eq.getString("LOCATION"))+"','"+currentDateTime+"'); </script>");	 //047546
			 }//end of while loop
			if(rst_eq!=null)		rst_eq.close();
		    if(pstmt_eq !=null)  pstmt_eq.close();
			
			out.println("<script>assignRecId_eq()</script>");
		    }
	   }
		}else{
		   out.println("<script>assignRecId_eq()</script>");
	   }
        /* @@@@@@@@@@@@@@@@@@ Equipments Ends Here @@@@@@@@@@@@@@@@@@@@*/
       
	   /* $$$$$$$$$$$$ Instrument/CSSD packs Code Starts Here$$$$$$$$$$$*/

		  if(("Y").equals(rec_instr_in_admin_notes_yn))
	        {
			  String SQL_IC="";
			  //Added by lakshmi agianst CRF-0058
			  if(Ot_param.equalsIgnoreCase("Y")){			
					SQL_IC = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ACCESSORY_CODE) ACC_DESC, A.TRAY_NO TRAY_NO,A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE, D.LOCATION LOCATION FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT_LANG_VW C, OT_INSTRUMENT D WHERE A.OPERATING_FACILITY_ID='"+facility_id+"' AND C.LANGUAGE_ID='"+locale+"' AND ACCESSORY_TYPE='I' AND A.OPER_NUM='"+oper_num+"' AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE AND A.ACCESSORY_CODE=D.INSTR_CODE";//MMS-QH-CRF-0199
			  }
			  else {
			       SQL_IC = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ACCESSORY_CODE) ACC_DESC, A.TRAY_NO TRAY_NO,A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE  FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT_LANG_VW C WHERE A.OPERATING_FACILITY_ID='"+facility_id+"' AND C.LANGUAGE_ID='"+locale+"' AND ACCESSORY_TYPE='I' AND A.OPER_NUM='"+oper_num+"' AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE "; //MMS-QH-CRF-0199
			  }

            pstmt_ic = con.prepareStatement(SQL_IC,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			rst_ic = pstmt_ic.executeQuery();
            if(rst_ic.next()){
			exist_rec_ic=true;
		    }
           if(exist_rec_ic==true)
	       {
			rst_ic.beforeFirst();
			while(rst_ic.next()){
			   ++index;	
			key_ic = rst_ic.getString("KEY");
			key_line_ic = rst_ic.getString("KEY_LINE");
            if(("true").equals(bill_flag)) 
			{
			bill_info_ic = or_bean.getOrderBillDtls(key_ic+key_line_ic);

			if(bill_info_ic==null){
				bill_info_ic = new HashMap();
				bill_info_ic.put("key",key_ic);
				bill_info_ic.put("key_line_no",key_line_ic);
				rst_acc_code = rst_ic.getString("ACC_CODE");
				tr_no = checkForNull(rst_ic.getString("TR_NO"));
				bill_info_ic.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info_ic.put("acc_type","S");
				bill_info_ic.put("oper_num",oper_num);
				bill_info_ic.put("locale",locale);
				bill_info_ic.put("module_id","OT");
				bill_info_ic.put("quantity",tr_no);
				//populate billing details from OTBillingBean........	
				bill_info_ic = billing_bean.getBillingParamsForAdmin(bill_info_ic,"C",bill_info_reqd_dtls);//C-> for Surgical Accessories Billing
				
				or_bean.setOrderBillDtls(key_ic+key_line_ic,bill_info_ic);
				putObjectInBean(or_bean_id,or_bean,request);
				}
			panel_str = (String) bill_info_ic.get("bl_panel_str");	
			String overridden_action_reason_code=null;
			String overridden_incl_excl_ind=null;
			bl_bfr.append(checkForNull(""+bill_info_ic.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_ic.get("charged_yn"),"N")).append("::");
			bl_bfr.append(overridden_incl_excl_ind).append("::");
			bl_bfr.append(checkForNull(""+bill_info_ic.get("preapp_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_ic.get("serv_panel_ind"),"S")).append("::");
			bl_bfr.append(overridden_action_reason_code).append("::");
			bl_bfr.append(checkForNull(""+bill_info_ic.get("incl_excl_ind"),"E"));
			bill_str = bl_bfr.toString();
			bl_bfr.setLength(0);
		    }//end of if bill_flag
			 
			//Added by Rajesh for CRF-0058
		    if(Ot_param.equalsIgnoreCase("Y")){
			 	out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+checkForNull(rst_ic.getString("LN_NUM"))+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("LOCATION"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("REMKS")),"UTF-8")+"','"+index+"','"+oper_num+"','L','1','"+bill_str+"','"+panel_str+"','"+key_ic+"','"+key_line_ic+"','"+checkForNull(rst_ic.getString("TR_NO"))+"');</script>");
		    }
		    else{
			 	out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+checkForNull(rst_ic.getString("LN_NUM"))+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("TRAY_NO"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("REMKS")),"UTF-8")+"','"+index+"','"+oper_num+"','L','1','"+bill_str+"','"+panel_str+"','"+key_ic+"','"+key_line_ic+"','"+checkForNull(rst_ic.getString("TR_NO"))+"');</script>");
		    }
		  //Added by Rajesh for CRF-0058 
		  
			}
			if(rst_ic!=null)rst_ic.close();
			if(pstmt_ic!=null)pstmt_ic.close();
			out.println("<script>assignRecId_ic()</script>");
			}
		  else if(("").equals(instrument_entry_cmp_yn))
    	  {      
			    if(rst_ic!=null)		rst_ic.close();
		        if(pstmt_ic !=null)  pstmt_ic.close();

				if(pick_list==true){
				//Modified By Rajesh for CRF-0058
				 String PICK_LIST_DEFINED_IC = "" ;
				 if(Ot_param.equalsIgnoreCase("Y")){
					PICK_LIST_DEFINED_IC = "SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ITEM_ID) ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO, B.location LOCATION FROM  OT_PICK_LISTS A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'I' AND A.ITEM_ID = B.INSTR_CODE AND B.LANGUAGE_ID='"+locale+"' ";//MMS-QH-CRF-0199
				 }
				 else{
					 PICK_LIST_DEFINED_IC = "SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ITEM_ID) ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO FROM  OT_PICK_LISTS A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'I' AND A.ITEM_ID = B.INSTR_CODE AND B.LANGUAGE_ID='"+locale+"' ";//MMS-QH-CRF-0199
				 }
				//Modified By Rajesh for CRF-0058
			     pstmt_ic = con.prepareStatement(PICK_LIST_DEFINED_IC);
				 pstmt_ic.setString(1,facility_id);
				 pstmt_ic.setString(2,patient_id);
				 pstmt_ic.setString(3,booking_num);
				 pstmt_ic.setString(4,oper_num);
				 rst_ic = pstmt_ic.executeQuery();
				 while(rst_ic.next()){
					++index;	
					line_no = (String)line_no_map.get(rst_ic.getString("OPR_CODE"));
				
				if(("true").equals(bill_flag))
			    {
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "S#"+rst_ic.getString("ACC_CODE");
				key_ic = oper_num+"@"+rst_ic.getString("OPR_CODE")+"@S@"+rst_ic.getString("ACC_CODE");
				key_line_ic="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				String p_qty_ic= checkForNull(rst_ic.getString("TR_NO"));
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty_ic,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_ic			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info_ic.putAll(hash);
				bill_info_ic.put("quantity",p_qty_ic);
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key_ic,bill_info_ic);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info_ic.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info_ic.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end ofm if bill_flag
                String tray_no="";
				//Modified By Rajesh for CRF-0058
				if(Ot_param.equalsIgnoreCase("Y")){
					out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("LOCATION"))+"','','"+index+"','"+oper_num+"','L','2','"+bill_str+"','"+panel_str+"','"+key_ic+"','"+key_line_ic+"','"+checkForNull(rst_ic.getString("TR_NO"))+"');</script>");	
				}
				else{
					out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+tray_no+"','','"+index+"','"+oper_num+"','L','2','"+bill_str+"','"+panel_str+"','"+key_ic+"','"+key_line_ic+"','"+checkForNull(rst_ic.getString("TR_NO"))+"');</script>");	
				}
				//Modified By Rajesh for CRF-0058	
			 }//end of while loop
			if(rst_ic!=null)		rst_ic.close();
		    if(pstmt_ic !=null)  pstmt_ic.close();
			out.println("<script>assignRecId_ic()</script>");
			}else
			 {
				//Modified By Rajesh for CRF-0058
				String PICK_LIST_UNDEFINED_IC = "";
				if(Ot_param.equalsIgnoreCase("Y")){
					PICK_LIST_UNDEFINED_IC="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO, b.location  LOCATION 	FROM   OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.INSTR_CODE  = B.INSTR_CODE  AND C.OPER_CODE  IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO, b.location  LOCATION FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO, b.location  LOCATION FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO, b.location  LOCATION 	FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT  B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO, b.location  LOCATION FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR'  AND A.OPER_CODE  IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE";//MMS-QH-CRF-0199
				}
				else{
					PICK_LIST_UNDEFINED_IC="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO 	FROM   OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.INSTR_CODE  = B.INSTR_CODE  AND C.OPER_CODE  IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO 	FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT  B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR'  AND A.OPER_CODE  IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE";//MMS-QH-CRF-0199
				}
				//Modified By Rajesh for CRF-0058
				pstmt_ic = con.prepareStatement(PICK_LIST_UNDEFINED_IC);
				rst_ic = pstmt_ic.executeQuery();
				while(rst_ic.next()){
					++index;	
					line_no = (String)line_no_map.get(rst_ic.getString("OPR_CODE"));
				if(("true").equals(bill_flag))
			    {	
				bill_info = new HashMap();
				HashMap hash = billing_bean.getORBillingParamsForAdmin(oper_num,bill_info_reqd_dtls);
				catalog_code = "S#"+rst_ic.getString("ACC_CODE");
				key = oper_num+"@"+rst_ic.getString("OPR_CODE")+"@S@"+rst_ic.getString("ACC_CODE");
				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				String p_qty_ic= checkForNull(rst_ic.getString("TR_NO"));
				ArrayList bill_dtls =or_bean.getBillChargeDetails(p_qty_ic,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst_ic.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","C");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",p_qty_ic);
				bill_info.putAll(hash);
				bill_info.put("quantity",checkForNull(rst_ic.getString("TR_NO")));
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info.get("bl_panel_str");	
				String overridden_action_reason_code=null;
				String overridden_incl_excl_ind=null;
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag	
				String tray_no="";
				//Modified By Rajesh for CRF-0058
				if(Ot_param.equalsIgnoreCase("Y")){
					out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("LOCATION"))+"','','"+index+"','"+oper_num+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst_ic.getString("TR_NO"))+"'); </script>");	
				}
				else{
					out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+tray_no+"','','"+index+"','"+oper_num+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst_ic.getString("TR_NO"))+"'); </script>");	
				}
				//Modified By Rajesh for CRF-0058
			 }//end of while loop
			 if(rst_ic!=null)rst_ic.close();
			 if(pstmt_ic!=null)pstmt_ic.close();
			 out.println("<script>assignRecId_ic()</script>");
			 }
	     }
	  }else
	      {
		  out.println("<script>assignRecId_ic()</script>");
	      }
       /* $$$$$$$$$$$$$$$ Instrument/CSSD packs Code Ends Here$$$$$$$$$$$$$$$$$$$$*/

            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block101Bytes, _wl_block101);
  rs.beforeFirst();
						while (rs != null && rs.next())
						{
							oper_code = checkForNull(rs.getString("OPR_CODE"));
							Fpplist = billing_bean.getFPPDetails(oper_code);
							for (int j = 0; j < Fpplist.size(); j++){
							if(j==0) fpp_order_yn=checkForNull((String)Fpplist.get(j));
							if(j==1) fpp_def_category=checkForNull((String)Fpplist.get(j));
							}
							oper_line_num = checkForNull(rs.getString("LN_NUM"));
							description = checkForNull(rs.getString("OPR_DESC"));
							side_applicable = checkForNull(rs.getString("RIGHT_LEFT_FLAG"));
							oper_remarks =  checkForNull(rs.getString("OPER_REMARKS"));
							System.err.println("oper_remarks @@@"+oper_remarks);
                            oper_remarks=java.net.URLEncoder.encode(oper_remarks,"UTF-8");
							order_id = checkForNull(rs.getString("ORDER_ID"));
							order_line_no = checkForNull(rs.getString("ORDER_LINE_NUM"));
							cancel_remarks = checkForNull(rs.getString("CANCEL_REMARKS"));
							cancel_remarks=java.net.URLEncoder.encode(cancel_remarks,"UTF-8");
							oper_line_status = checkForNull(rs.getString("OPER_LINE_STATUS"));
							order_catalog=(rs.getString("ORDER_CATALOG_CODE"));
							//Added Against ML-MMS-QH-CRF-1939-US4...starts
							if(isIncludeFpp  && count==1 && Include_Fpp_yn.equals("Y") && ("true").equals(bill_flag)){
							fpp_category=checkForNull(rs.getString("FPP_CATEGORY"));
							}
							//Added Against ML-MMS-QH-CRF-1939-US4...ends
						    str_order_catalog_code=str_order_catalog_code+order_catalog+"|";
							if(rs_bl!=null) rs_bl.close();
	                        if(pstm_bl!=null) pstm_bl.close();
							pstm_bl = con.prepareStatement("select BILL_YN, BILLED_YN from   or_order_line where  order_id   = '"+order_id+"' and order_line_num  ='"+order_line_no+"'");
							rs_bl  = pstm_bl.executeQuery();
							while (rs_bl != null && rs_bl.next())
							{
								bill_yn=checkForNull(rs_bl.getString("BILL_YN"));
								billed_yn=checkForNull(rs_bl.getString("BILLED_YN"));
							}
							if(("").equals(side_applicable) || ("N").equals(side_applicable))
							{
								side_applicalbe_desc=notApplicable_title;
							}else if(("R").equals(side_applicable))
							{
								side_applicalbe_desc=rightSide_title;
							}
							else if(("L").equals(side_applicable))
							{
								side_applicalbe_desc=leftSide_title;
							}
							else if(("B").equals(side_applicable))
							{
								side_applicalbe_desc=bilateral;
							}
							posted_yn = billing_bean.billingPostedYN(oper_num,oper_line_num);
							bill_info = or_bean.getOrderBillDtls(order_id+order_line_no);	
							if((bill_info == null || bill_info.size() == 0) && !"".equals(called_from))
							{
							bill_info = new HashMap();
						/*	if("X".equals(posted_yn) && fpp_order_yn.equals("N"))
								{
							module_id = "OT";
							bill_info.put("module_id",module_id);
							bill_info.put("key",order_id);//changed insted of oper_num we used order_id
							bill_info.put("key_line_no",oper_line_num);
								}
								else*/ //Commented Against KDAH-SCF-0891
								 if("X".equals(posted_yn))
								{
							module_id = "OT";
							bill_info.put("module_id",module_id);
							bill_info.put("key",oper_num);//changed insted of oper_num we used order_id
							bill_info.put("key_line_no",oper_line_num);
								}
								else
								{
							module_id = "OR";
							bill_info.put("module_id",module_id);
							bill_info.put("key",order_id);
							bill_info.put("key_line_no",order_line_no);
							}
							bill_info.put("oper_code",oper_code);
							bill_info.put("oper_num",oper_num);
							bill_info.put("locale",locale);
							bill_info.put("quantity","1");
							bill_info.put("oper_line_status",oper_line_status);
							bill_info.put("called_from",called_from);
							bill_info.put("order_line_no", order_line_no);//50485
							//ML-MMOH-CRF-1939-US4
							//if(Include_Fpp_yn.equals("Y") && isIncludeFpp && count==1 && (bill_flag.equals("true"))){
							if(fpp_category.equals("S") || fpp_category.equals("M") || fpp_category.equals("C"))
									bill_info.put("fpp_category", fpp_category);
							else
									bill_info.put("fpp_category", fpp_def_category);
							//}
							//ML-MMOH-CRF-1939-US4
							bill_info = billing_bean.getBillingParamsForAdmin(bill_info,"S",bill_info_reqd_dtls);
							or_bean.setOrderBillDtls(order_id+order_line_no,bill_info);
							putObjectInBean(or_bean_id,or_bean,request);
							}
						    panel_str = (String) bill_info.get("bl_panel_str");
							String overridden_action_reason_code=null;
							String overridden_incl_excl_ind=null;
							bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
							bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
							bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
							bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
							bl_bfr.append(overridden_incl_excl_ind).append("::");
							bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
							bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
							bl_bfr.append(overridden_action_reason_code).append("::");
							bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
							bl_bfr.append(checkForNull(posted_yn,"N")).append("::");
							bill_str = bl_bfr.toString();
                            bl_bfr.setLength(0);
                            arr = bill_str.split("::");
							
						
						out.println("<script>loadDBRows_op('"+oper_line_num+"','"+oper_code+"','"+encode(description) +"','"+side_applicable+"','"+oper_remarks+"','"+order_line_no+"','"+order_id+"','"+bill_str+"','"+panel_str+"','L','"+oper_line_status+"','"+cancel_remarks+"','"+bill_yn+"','"+billed_yn+"','"+fpp_category+"','"+Include_Fpp_yn+"','"+isIncludeFpp+"','"+count+"','"+bill_flag+"');</script>"); // Modified Against ML-MMS-QH-CRF-1939-US4
						
                       
            _bw.write(_wl_block102Bytes, _wl_block102);
}
            _bw.write(_wl_block103Bytes, _wl_block103);
            {java.lang.String __page ="AdministrativeFunctionforAllChargesFrame1.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("sStyle"), weblogic.utils.StringUtils.valueOf(sStyle
                        )},{ weblogic.utils.StringUtils.valueOf("flag_op"), weblogic.utils.StringUtils.valueOf(flag_op
                        )},{ weblogic.utils.StringUtils.valueOf("oper_finalization_stage"), weblogic.utils.StringUtils.valueOf(oper_finalization_stage
                        )},{ weblogic.utils.StringUtils.valueOf("proc_chrg_cmp_yn"), weblogic.utils.StringUtils.valueOf(proc_chrg_cmp_yn
                        )},{ weblogic.utils.StringUtils.valueOf("operation_sub_services_yn"), weblogic.utils.StringUtils.valueOf(operation_sub_services_yn
                        )},{ weblogic.utils.StringUtils.valueOf("flag_asc"), weblogic.utils.StringUtils.valueOf(flag_asc
                        )},{ weblogic.utils.StringUtils.valueOf("flag_dc"), weblogic.utils.StringUtils.valueOf(flag_dc
                        )},{ weblogic.utils.StringUtils.valueOf("rec_packs_in_admin_notes_yn"), weblogic.utils.StringUtils.valueOf(rec_packs_in_admin_notes_yn
                        )},{ weblogic.utils.StringUtils.valueOf("consumable_entry_cmp_yn"), weblogic.utils.StringUtils.valueOf(consumable_entry_cmp_yn
                        )},{ weblogic.utils.StringUtils.valueOf("rec_implants_in_admin_notes_yn"), weblogic.utils.StringUtils.valueOf(rec_implants_in_admin_notes_yn
                        )},{ weblogic.utils.StringUtils.valueOf("rec_equp_in_admin_notes_yn"), weblogic.utils.StringUtils.valueOf(rec_equp_in_admin_notes_yn
                        )},{ weblogic.utils.StringUtils.valueOf("rec_instr_in_admin_notes_yn"), weblogic.utils.StringUtils.valueOf(rec_instr_in_admin_notes_yn
                        )},{ weblogic.utils.StringUtils.valueOf("flag_ac"), weblogic.utils.StringUtils.valueOf(flag_ac
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block104Bytes, _wl_block104);
  if(("Y").equals(rec_implants_in_admin_notes_yn))
			            {
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag144(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(impl_disable_flag));
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag145(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag146(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);

            if (_jsp__tag147(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag148(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);

            if (_jsp__tag149(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(impl_disable_flag));
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag150(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(impl_disable_flag));
            _bw.write(_wl_block115Bytes, _wl_block115);
 
						        rs.beforeFirst();
						        while(rs.next())
	                            {
								oper_line_status = checkForNull(rs.getString("OPER_LINE_STATUS"));
									if(!("99").equals(oper_line_status))
									{
									val = checkForNull(rs.getString("OPR_CODE"))+"##"+checkForNull(rs.getString("LN_NUM"));
									
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(val));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(checkForNull(rs.getString("OPR_DESC"))));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(checkForNull(rs.getString("OPR_DESC"))));
            _bw.write(_wl_block119Bytes, _wl_block119);

									}
								}
								
            _bw.write(_wl_block120Bytes, _wl_block120);
if(("Y").equals(st_interface_flag)){
            _bw.write(_wl_block121Bytes, _wl_block121);

            if (_jsp__tag151(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(impl_disable_flag));
            _bw.write(_wl_block123Bytes, _wl_block123);
}
            _bw.write(_wl_block124Bytes, _wl_block124);
if(("N").equals(st_interface_flag)){
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag152(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(impl_disable_flag));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag153(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(impl_disable_flag));
            _bw.write(_wl_block129Bytes, _wl_block129);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
if(("Y").equals(st_interface_flag)){
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag154(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(impl_disable_flag));
            _bw.write(_wl_block127Bytes, _wl_block127);

            if (_jsp__tag155(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(impl_disable_flag));
            _bw.write(_wl_block129Bytes, _wl_block129);
}
            _bw.write(_wl_block133Bytes, _wl_block133);
if(("Y").equals(st_interface_flag)){
            _bw.write(_wl_block134Bytes, _wl_block134);

            if (_jsp__tag156(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(impl_disable_flag));
            _bw.write(_wl_block136Bytes, _wl_block136);
}
            _bw.write(_wl_block137Bytes, _wl_block137);

            if (_jsp__tag157(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block139Bytes, _wl_block139);

            if (_jsp__tag158(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block140Bytes, _wl_block140);

            if (_jsp__tag159(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(impl_disable_flag));
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag160(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(impl_disable_flag));
            _bw.write(_wl_block144Bytes, _wl_block144);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
  if(("Y").equals(rec_packs_in_admin_notes_yn))
	                     {
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag161(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(cons_disable_flag));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag162(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag163(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag164(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag165(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag166(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(cons_disable_flag));
            _bw.write(_wl_block152Bytes, _wl_block152);
 
                                rs.beforeFirst();
						        while(rs.next())
	                            {
								//Added by DhanasekarV on 14/11/2011
								oper_line_status = checkForNull(rs.getString("OPER_LINE_STATUS"));
									if(!("99").equals(oper_line_status))
									{
								val = checkForNull(rs.getString("OPR_CODE"))+"##"+checkForNull(rs.getString("LN_NUM"));

								
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(val));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(checkForNull(rs.getString("OPR_DESC"))));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(checkForNull(rs.getString("OPR_DESC"))));
            _bw.write(_wl_block154Bytes, _wl_block154);

									}	
								}
            _bw.write(_wl_block155Bytes, _wl_block155);

            if (_jsp__tag167(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(cons_disable_flag));
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag168(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(cons_disable_flag));
            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag169(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);

            if (_jsp__tag170(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(cons_disable_flag));
            _bw.write(_wl_block162Bytes, _wl_block162);

            if (_jsp__tag171(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(cons_disable_flag));
            _bw.write(_wl_block164Bytes, _wl_block164);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
  if(("Y").equals(rec_equp_in_admin_notes_yn))
	                     {
            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag172(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(cons_disable_flag));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag173(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag174(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);

            if (_jsp__tag175(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);

            if (_jsp__tag176(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag177(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(eq_disable_flag));
            _bw.write(_wl_block152Bytes, _wl_block152);
 
		                rs.beforeFirst();
						while(rs.next())
						{
							//Added by DhanasekarV on 14/11/2011
						oper_line_status = checkForNull(rs.getString("OPER_LINE_STATUS"));
						if(!("99").equals(oper_line_status))
						{

						val = checkForNull(rs.getString("OPR_CODE"))+"##"+checkForNull(rs.getString("LN_NUM"));

						
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(val));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(checkForNull(rs.getString("OPR_DESC"))));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(checkForNull(rs.getString("OPR_DESC"))));
            _bw.write(_wl_block171Bytes, _wl_block171);
}
							}
            _bw.write(_wl_block172Bytes, _wl_block172);

            if (_jsp__tag178(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(eq_disable_flag));
            _bw.write(_wl_block174Bytes, _wl_block174);
 if(customer_id1.equalsIgnoreCase("RTN")){
            _bw.write(_wl_block175Bytes, _wl_block175);

            if (_jsp__tag179(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(eq_disable_flag));
            _bw.write(_wl_block177Bytes, _wl_block177);
}else{
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag180(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(eq_disable_flag));
            _bw.write(_wl_block180Bytes, _wl_block180);
}
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag181(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(eq_disable_flag));
            _bw.write(_wl_block183Bytes, _wl_block183);

            if (_jsp__tag182(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block184Bytes, _wl_block184);

            if (_jsp__tag183(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(eq_disable_flag));
            _bw.write(_wl_block186Bytes, _wl_block186);

            if (_jsp__tag184(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(eq_disable_flag));
            _bw.write(_wl_block188Bytes, _wl_block188);

            if (_jsp__tag185(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(currentDateTime));
            _bw.write(_wl_block190Bytes, _wl_block190);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
 if(("Y").equals(rec_instr_in_admin_notes_yn)){
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag186(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(cons_disable_flag));
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag187(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);

            if (_jsp__tag188(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);

            if (_jsp__tag189(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block193Bytes, _wl_block193);

            if (_jsp__tag190(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag191(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(ic_disable_flag));
            _bw.write(_wl_block152Bytes, _wl_block152);
 
		                rs.beforeFirst();
						while(rs.next())
						{
						//Added by DhanasekarV on 14/11/2011
						oper_line_status = checkForNull(rs.getString("OPER_LINE_STATUS"));
						if(!("99").equals(oper_line_status))
						{
						val = checkForNull(rs.getString("OPR_CODE"))+"##"+checkForNull(rs.getString("LN_NUM"));

						
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(val));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(checkForNull(rs.getString("OPR_DESC"))));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(checkForNull(rs.getString("OPR_DESC"))));
            _bw.write(_wl_block171Bytes, _wl_block171);

						}
							}
            _bw.write(_wl_block196Bytes, _wl_block196);

            if (_jsp__tag192(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(ic_disable_flag));
            _bw.write(_wl_block198Bytes, _wl_block198);
if(Ot_param.equalsIgnoreCase("Y")){
            _bw.write(_wl_block199Bytes, _wl_block199);

            if (_jsp__tag193(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block200Bytes, _wl_block200);
}
						else{
            _bw.write(_wl_block201Bytes, _wl_block201);

            if (_jsp__tag194(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(ic_disable_flag));
            _bw.write(_wl_block203Bytes, _wl_block203);
}
            _bw.write(_wl_block204Bytes, _wl_block204);

            if (_jsp__tag195(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(ic_disable_flag));
            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag196(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);

            if (_jsp__tag197(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(ic_disable_flag));
            _bw.write(_wl_block209Bytes, _wl_block209);

            if (_jsp__tag198(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(ic_disable_flag));
            _bw.write(_wl_block164Bytes, _wl_block164);
}
            _bw.write(_wl_block211Bytes, _wl_block211);
  if(("Y").equals(rec_implants_in_admin_notes_yn))
			            {
            _bw.write(_wl_block212Bytes, _wl_block212);

            if (_jsp__tag199(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);

						if(("Y").equals(flag_pi)){
						
            _bw.write(_wl_block214Bytes, _wl_block214);
}else{
            _bw.write(_wl_block215Bytes, _wl_block215);
}
            _bw.write(_wl_block216Bytes, _wl_block216);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
  if(("Y").equals(rec_packs_in_admin_notes_yn))
	                     {
            _bw.write(_wl_block217Bytes, _wl_block217);

            if (_jsp__tag200(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);

						if(("Y").equals(flag_cp)){
						
            _bw.write(_wl_block218Bytes, _wl_block218);
}else{
            _bw.write(_wl_block219Bytes, _wl_block219);
}
            _bw.write(_wl_block220Bytes, _wl_block220);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
if(("Y").equals(rec_equp_in_admin_notes_yn)){
            _bw.write(_wl_block221Bytes, _wl_block221);
if(Ot_param.equalsIgnoreCase("Y")){
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag201(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
}
						else{
            _bw.write(_wl_block224Bytes, _wl_block224);

            if (_jsp__tag202(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block225Bytes, _wl_block225);
}
            _bw.write(_wl_block226Bytes, _wl_block226);

						if(("Y").equals(flag_eq)){
						
            _bw.write(_wl_block227Bytes, _wl_block227);
}else{
            _bw.write(_wl_block228Bytes, _wl_block228);
}
            _bw.write(_wl_block229Bytes, _wl_block229);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
if(("Y").equals(rec_instr_in_admin_notes_yn)){
            _bw.write(_wl_block230Bytes, _wl_block230);
if(Ot_param.equalsIgnoreCase("Y")){
            _bw.write(_wl_block231Bytes, _wl_block231);

            if (_jsp__tag203(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
}
						else{
            _bw.write(_wl_block232Bytes, _wl_block232);

            if (_jsp__tag204(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
}
            _bw.write(_wl_block233Bytes, _wl_block233);

						if(("Y").equals(flag_ic)){
						
            _bw.write(_wl_block234Bytes, _wl_block234);
}else{
            _bw.write(_wl_block235Bytes, _wl_block235);
}
            _bw.write(_wl_block236Bytes, _wl_block236);
}
            _bw.write(_wl_block130Bytes, _wl_block130);
if(("true").equals(bill_flag) && ("Y").equals(charge_operating_room_yn) && ("Y").equals(or_chargeable_yn)){
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag205(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);

						if(("Y").equals(flag_or)){
						
            _bw.write(_wl_block238Bytes, _wl_block238);
}else{
            _bw.write(_wl_block239Bytes, _wl_block239);
}
            _bw.write(_wl_block240Bytes, _wl_block240);

            if (_jsp__tag206(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(check_into_or_time1));
            _bw.write(_wl_block242Bytes, _wl_block242);

            if (_jsp__tag207(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(check_out_or_time1));
            _bw.write(_wl_block244Bytes, _wl_block244);

            if (_jsp__tag208(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(or_chargeable_units));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(disable_or));
            _bw.write(_wl_block247Bytes, _wl_block247);
if(("Y").equals(or_chrg_cmp_yn))
						{
            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag209(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block249Bytes, _wl_block249);
}else {
            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag210(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(disable_or));
            _bw.write(_wl_block251Bytes, _wl_block251);
}
            _bw.write(_wl_block252Bytes, _wl_block252);
}
            _bw.write(_wl_block253Bytes, _wl_block253);
if(("true").equals(bill_flag) && ("Y").equals(charge_holding_area_yn) && maxRecord>0){
            _bw.write(_wl_block254Bytes, _wl_block254);

            if (_jsp__tag211(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);

						if(("Y").equals(flag_ha)){
						
            _bw.write(_wl_block255Bytes, _wl_block255);
}else{
            _bw.write(_wl_block256Bytes, _wl_block256);
}
            _bw.write(_wl_block257Bytes, _wl_block257);
int i=0;
						if(maxRecord>0)
	                    {
							while(rst_ha_room !=null && rst_ha_room.next())
	                    { 
						holding_area_code=checkForNull(rst_ha_room.getString("HOLDING_AREA_CODE"));
						checked_in_date_time=checkForNull(com.ehis.util.DateUtils.convertDate(rst_ha_room.getString("CHECKED_IN_DATE_TIME"),"DMYHM","en",locale));
						checked_out_date_time=checkForNull(com.ehis.util.DateUtils.convertDate(rst_ha_room.getString("CHECKED_OUT_DATE_TIME"),"DMYHM","en",locale));
						checked_in_date_time1=checkForNull(rst_ha_room.getString("CHECKED_IN_DATE_TIME1"));
						checked_out_date_time1=checkForNull(rst_ha_room.getString("CHECKED_OUT_DATE_TIME1"));
						calc_chargeable_units=checkForNull(rst_ha_room.getString("CALC_CHARGEABLE_UNITS"));
						chargeable_units=checkForNull(rst_ha_room.getString("CHARGEABLE_UNITS"));
						bl_accession_num=checkForNull(rst_ha_room.getString("BL_ACCESSION_NUM"));
						holding_seq_num=checkForNull(rst_ha_room.getString("HOLDING_SEQ_NUM"));
						 if(("").equals(checked_in_date_time) || ("").equals(checked_out_date_time)) disable_ha="disabled";

						
            _bw.write(_wl_block258Bytes, _wl_block258);

            if (_jsp__tag212(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(i));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(i));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(checked_in_date_time));
            _bw.write(_wl_block262Bytes, _wl_block262);

            if (_jsp__tag213(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(i));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(i));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(checked_out_date_time));
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag214(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(i));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(i));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(chargeable_units));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(i));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(disable_ha));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(i));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(i));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(i));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(checked_in_date_time1));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(i));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(i));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(checked_out_date_time1));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(i));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(i));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(bl_accession_num));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(i));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(i));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(holding_seq_num));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(i));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(i));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(holding_area_code));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(i));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(i));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(chargeable_units));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(i));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(i));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(i));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(i));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(i));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(i));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(i));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(i));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(i));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(i));
            _bw.write(_wl_block297Bytes, _wl_block297);
 
						
						i++;maxRecord=i;
						}
						}else {
            _bw.write(_wl_block258Bytes, _wl_block258);

            if (_jsp__tag215(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(i));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(i));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(checked_in_date_time));
            _bw.write(_wl_block262Bytes, _wl_block262);

            if (_jsp__tag216(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(i));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(i));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(checked_out_date_time));
            _bw.write(_wl_block265Bytes, _wl_block265);

            if (_jsp__tag217(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(i));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(i));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(chargeable_units));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(i));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(disable_ha));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(i));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(i));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(bl_accession_num));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(i));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(i));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(chargeable_units));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(i));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(i));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(holding_area_code));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(i));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(i));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(i));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(i));
            _bw.write(_wl_block301Bytes, _wl_block301);
} 
            _bw.write(_wl_block302Bytes, _wl_block302);
if(("Y").equals(hld_chrg_cmp_yn)){
            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag218(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block303Bytes, _wl_block303);
}else{
            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag219(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(disable_ha));
            _bw.write(_wl_block305Bytes, _wl_block305);
}
            _bw.write(_wl_block306Bytes, _wl_block306);
}
            _bw.write(_wl_block307Bytes, _wl_block307);
if(("true").equals(bill_flag) && ("Y").equals(charge_recovery_room_yn) && ("Y").equals(rec_chargeable_yn)){
            _bw.write(_wl_block308Bytes, _wl_block308);

            if (_jsp__tag220(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);

						if(("Y").equals(flag_rr)){
						
            _bw.write(_wl_block309Bytes, _wl_block309);
}else{
            _bw.write(_wl_block310Bytes, _wl_block310);
}
            _bw.write(_wl_block311Bytes, _wl_block311);

            if (_jsp__tag221(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(recovery_start_time1));
            _bw.write(_wl_block313Bytes, _wl_block313);

            if (_jsp__tag222(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(recovery_end_time1));
            _bw.write(_wl_block244Bytes, _wl_block244);

            if (_jsp__tag223(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(recv_chargeable_units));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(disable_rec));
            _bw.write(_wl_block317Bytes, _wl_block317);
if(("Y").equals(rec_chrg_cmp_yn))
						{
            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag224(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block318Bytes, _wl_block318);
}else {
            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag225(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(disable_rec));
            _bw.write(_wl_block320Bytes, _wl_block320);
}
            _bw.write(_wl_block321Bytes, _wl_block321);
}
            _bw.write(_wl_block322Bytes, _wl_block322);
if(customer_id1.equalsIgnoreCase("SRR")){
            _bw.write(_wl_block323Bytes, _wl_block323);

            if (_jsp__tag226(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block324Bytes, _wl_block324);
}
            _bw.write(_wl_block325Bytes, _wl_block325);

						if(("Y").equals(flag_pr)){							
						
            _bw.write(_wl_block326Bytes, _wl_block326);
}						
					    else{
            _bw.write(_wl_block327Bytes, _wl_block327);
}
            _bw.write(_wl_block328Bytes, _wl_block328);

            if (_jsp__tag227(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block329Bytes, _wl_block329);

            if (_jsp__tag228(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(hld_chrg_cmp_yn));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(or_chrg_cmp_yn));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(rec_chrg_cmp_yn));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(serv_date));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(rec_implants_in_admin_notes_yn));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(rec_packs_in_admin_notes_yn));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(rec_equp_in_admin_notes_yn));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(rec_instr_in_admin_notes_yn));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(st_interface_flag));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(oper_room_code));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(params));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(flag_op));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(flag_ac));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(flag_dc));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(flag_pi));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(flag_cp));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(flag_eq));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(flag_ic));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(flag_or));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(flag_ha));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(flag_rr));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(flag_asc));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(flag_pr));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(bill_flag));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(check_into_or_time));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(check_out_or_time));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(oper_room_code_or));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(or_bl_accession_num));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(surgeon_code));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(recovery_room_code));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(recovery_start_time));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(recovery_end_time));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(recv_bl_accession_num));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(encounter_id1));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(visit_id1));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(bl_episode_type));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(order_id1));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(str_order_catalog_code));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(ref_source_code));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(operation_sub_services_yn));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(trfr_ward_code));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(implant_entry_cmp_yn));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(consumable_entry_cmp_yn));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(equipment_entry_cmp_yn));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(instrument_entry_cmp_yn));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(recy_room_finalization_stage));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(hold_finalization_stage));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(oper_room_finalization_stage));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(charge_holding_area_yn));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(charge_operating_room_yn));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(charge_recovery_room_yn));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(rec_chargeable_yn));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(or_chargeable_yn));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(oper_finalization_stage));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(proc_chrg_cmp_yn));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(slate_user_id));
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(st_charge_based_yn));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(mm_item_code));
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(surgeon_code1));
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(p_ord_practitioner_id));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(customer_id1));
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block405Bytes, _wl_block405);
            out.print( String.valueOf(p_report_id));
            _bw.write(_wl_block406Bytes, _wl_block406);
            out.print( String.valueOf(Ot_param));
            _bw.write(_wl_block407Bytes, _wl_block407);
            out.print( String.valueOf(checkInTime));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(oneWeekDate));
            _bw.write(_wl_block409Bytes, _wl_block409);
            out.print( String.valueOf(tab_name));
            _bw.write(_wl_block410Bytes, _wl_block410);
 
 oper_codes.setLength(0);
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null)                rs.close();
		if(pstmt!=null)             pstmt.close();
		if(pstmt2!=null)            pstmt2.close();
		if(rst_bl!=null) rst_bl.close();
		if(pstmt_bl!=null)pstmt_bl.close();
		if(statement!=null)statement.close();
		if(rst_ha_room!=null)rst_ha_room.close();
		if(pstmt_ha_room!=null)pstmt_ha_room.close();
		if(pstmt_pi!=null)   pstmt_pi.close();
		if(rst_pi!=null)     rst_pi.close();
		if(pstmt_cons!=null) pstmt_cons.close();
		if(rst_cons!=null)   rst_cons.close();
		if(rst_eq!=null)	  rst_eq.close();
		if(pstmt_eq !=null)   pstmt_eq.close();
		if(rst_ic!=null)	  rst_ic.close();
		if(pstmt_ic !=null)   pstmt_ic.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Implant.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ReservedPicklistUnits.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RequestedPicklistUnits.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Manufacturer.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Batch.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumptionStore.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Package.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Package.label", java.lang.String .class,"key"));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DateTime.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.EquipmentID.Label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
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
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Package.label", java.lang.String .class,"key"));
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
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DateTime.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.EquipmentID.Label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
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
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${\tcommon_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Instrument.label", java.lang.String .class,"key"));
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
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TrayNo.label", java.lang.String .class,"key"));
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
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Instrument.label", java.lang.String .class,"key"));
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
        __tag110.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag110.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag111.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag112.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag113.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
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
        __tag114.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag115.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag116.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag116.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag117.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
        __tag117.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag118.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag119.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag120.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag121.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag122.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag122.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag123.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag124.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag125.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag126.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperationCode.Label", java.lang.String .class,"key"));
        __tag126.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag127.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
        __tag127.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag128.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SideApplicable.Label", java.lang.String .class,"key"));
        __tag128.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag129.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeComments.Label", java.lang.String .class,"key"));
        __tag129.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag130.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Charge.label", java.lang.String .class,"key"));
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
        __tag131.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag131.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag132.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PreOperativeComments.Label", java.lang.String .class,"key"));
        __tag132.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag133.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FppCategory.Label", java.lang.String .class,"key"));
        __tag133.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag134.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag135.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag135.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag136.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag137.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag138.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag139.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag140.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Payable.Label", java.lang.String .class,"key"));
        __tag140.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag141.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPayable.label", java.lang.String .class,"key"));
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
        __tag142.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientPaid.label", java.lang.String .class,"key"));
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
        __tag143.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Included.label", java.lang.String .class,"key"));
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
        __tag144.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AccessoryType.Label", java.lang.String .class,"key"));
        __tag144.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag145.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProsthesisImplants.Label", java.lang.String .class,"key"));
        __tag145.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag146.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumablePacks.Label", java.lang.String .class,"key"));
        __tag146.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag147.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Equipments.Label", java.lang.String .class,"key"));
        __tag147.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag148.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InstrumentsCSSDPacks.Label", java.lang.String .class,"key"));
        __tag148.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag149.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Implant.label", java.lang.String .class,"key"));
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
        __tag150.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag151.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumptionStore.Label", java.lang.String .class,"key"));
        __tag151.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag152.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Manufacturer.label", java.lang.String .class,"key"));
        __tag152.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag153.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Batch.label", java.lang.String .class,"key"));
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
        __tag154.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ReservedPicklistUnits.Label", java.lang.String .class,"key"));
        __tag154.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag155.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RequestedPicklistUnits.Label", java.lang.String .class,"key"));
        __tag155.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag156.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.StockAvailable.Label", java.lang.String .class,"key"));
        __tag156.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag157.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag157.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag158.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag159.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag160.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag161.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AccessoryType.Label", java.lang.String .class,"key"));
        __tag161.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag162.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProsthesisImplants.Label", java.lang.String .class,"key"));
        __tag162.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag163.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumablePacks.Label", java.lang.String .class,"key"));
        __tag163.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag164.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Equipments.Label", java.lang.String .class,"key"));
        __tag164.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag165.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InstrumentsCSSDPacks.Label", java.lang.String .class,"key"));
        __tag165.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag166.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag167.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Package.label", java.lang.String .class,"key"));
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
        __tag168.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag168.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag169.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag170.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag171.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag172.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AccessoryType.Label", java.lang.String .class,"key"));
        __tag172.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag173.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProsthesisImplants.Label", java.lang.String .class,"key"));
        __tag173.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag174.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumablePacks.Label", java.lang.String .class,"key"));
        __tag174.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag175.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Equipments.Label", java.lang.String .class,"key"));
        __tag175.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag176.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InstrumentsCSSDPacks.Label", java.lang.String .class,"key"));
        __tag176.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag177.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag178.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
        __tag178.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag179.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag180.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.EquipmentID.Label", java.lang.String .class,"key"));
        __tag180.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag181.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag181.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag182.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag182.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag183.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag184.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag185.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DateTime.label", java.lang.String .class,"key"));
        __tag185.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag186.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AccessoryType.Label", java.lang.String .class,"key"));
        __tag186.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag187.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProsthesisImplants.Label", java.lang.String .class,"key"));
        __tag187.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag188.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumablePacks.Label", java.lang.String .class,"key"));
        __tag188.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag189.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Equipments.Label", java.lang.String .class,"key"));
        __tag189.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag190.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InstrumentsCSSDPacks.Label", java.lang.String .class,"key"));
        __tag190.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag191.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
        __tag191.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag192.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Instrument.label", java.lang.String .class,"key"));
        __tag192.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag193(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag193 = null ;
        int __result__tag193 = 0 ;

        if (__tag193 == null ){
            __tag193 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag193);
        }
        __tag193.setPageContext(pageContext);
        __tag193.setParent(null);
        __tag193.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
        __tag193.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag193;
        __result__tag193 = __tag193.doStartTag();

        if (__result__tag193!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag193== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag193.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag193);
            return true;
        }
        _activeTag=__tag193.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag193);
        __tag193.release();
        return false;
    }

    private boolean _jsp__tag194(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag194 = null ;
        int __result__tag194 = 0 ;

        if (__tag194 == null ){
            __tag194 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag194);
        }
        __tag194.setPageContext(pageContext);
        __tag194.setParent(null);
        __tag194.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TrayNo.label", java.lang.String .class,"key"));
        __tag194.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag194;
        __result__tag194 = __tag194.doStartTag();

        if (__result__tag194!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag194== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag194.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag194);
            return true;
        }
        _activeTag=__tag194.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag194);
        __tag194.release();
        return false;
    }

    private boolean _jsp__tag195(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag195 = null ;
        int __result__tag195 = 0 ;

        if (__tag195 == null ){
            __tag195 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag195);
        }
        __tag195.setPageContext(pageContext);
        __tag195.setParent(null);
        __tag195.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag195.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag195;
        __result__tag195 = __tag195.doStartTag();

        if (__result__tag195!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag195== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag195.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag195);
            return true;
        }
        _activeTag=__tag195.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag195);
        __tag195.release();
        return false;
    }

    private boolean _jsp__tag196(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag196 = null ;
        int __result__tag196 = 0 ;

        if (__tag196 == null ){
            __tag196 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag196);
        }
        __tag196.setPageContext(pageContext);
        __tag196.setParent(null);
        __tag196.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag196.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag196;
        __result__tag196 = __tag196.doStartTag();

        if (__result__tag196!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag196== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag196.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag196);
            return true;
        }
        _activeTag=__tag196.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag196);
        __tag196.release();
        return false;
    }

    private boolean _jsp__tag197(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag197 = null ;
        int __result__tag197 = 0 ;

        if (__tag197 == null ){
            __tag197 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag197);
        }
        __tag197.setPageContext(pageContext);
        __tag197.setParent(null);
        __tag197.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag197.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag197;
        __result__tag197 = __tag197.doStartTag();

        if (__result__tag197!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag197== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag197.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag197);
            return true;
        }
        _activeTag=__tag197.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag197);
        __tag197.release();
        return false;
    }

    private boolean _jsp__tag198(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag198 = null ;
        int __result__tag198 = 0 ;

        if (__tag198 == null ){
            __tag198 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag198);
        }
        __tag198.setPageContext(pageContext);
        __tag198.setParent(null);
        __tag198.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
        __tag198.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag198;
        __result__tag198 = __tag198.doStartTag();

        if (__result__tag198!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag198== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag198.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag198);
            return true;
        }
        _activeTag=__tag198.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag198);
        __tag198.release();
        return false;
    }

    private boolean _jsp__tag199(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag199 = null ;
        int __result__tag199 = 0 ;

        if (__tag199 == null ){
            __tag199 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag199);
        }
        __tag199.setPageContext(pageContext);
        __tag199.setParent(null);
        __tag199.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProsthesisImplants.Label", java.lang.String .class,"key"));
        __tag199.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag199;
        __result__tag199 = __tag199.doStartTag();

        if (__result__tag199!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag199== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag199.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag199);
            return true;
        }
        _activeTag=__tag199.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag199);
        __tag199.release();
        return false;
    }

    private boolean _jsp__tag200(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag200 = null ;
        int __result__tag200 = 0 ;

        if (__tag200 == null ){
            __tag200 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag200);
        }
        __tag200.setPageContext(pageContext);
        __tag200.setParent(null);
        __tag200.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumablePacks.Label", java.lang.String .class,"key"));
        __tag200.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag200;
        __result__tag200 = __tag200.doStartTag();

        if (__result__tag200!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag200== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag200.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag200);
            return true;
        }
        _activeTag=__tag200.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag200);
        __tag200.release();
        return false;
    }

    private boolean _jsp__tag201(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag201 = null ;
        int __result__tag201 = 0 ;

        if (__tag201 == null ){
            __tag201 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag201);
        }
        __tag201.setPageContext(pageContext);
        __tag201.setParent(null);
        __tag201.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Equipments.Label", java.lang.String .class,"key"));
        __tag201.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag201;
        __result__tag201 = __tag201.doStartTag();

        if (__result__tag201!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag201== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag201.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag201);
            return true;
        }
        _activeTag=__tag201.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag201);
        __tag201.release();
        return false;
    }

    private boolean _jsp__tag202(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag202 = null ;
        int __result__tag202 = 0 ;

        if (__tag202 == null ){
            __tag202 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag202);
        }
        __tag202.setPageContext(pageContext);
        __tag202.setParent(null);
        __tag202.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Equipments.Label", java.lang.String .class,"key"));
        __tag202.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag202;
        __result__tag202 = __tag202.doStartTag();

        if (__result__tag202!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag202== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag202.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag202);
            return true;
        }
        _activeTag=__tag202.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag202);
        __tag202.release();
        return false;
    }

    private boolean _jsp__tag203(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag203 = null ;
        int __result__tag203 = 0 ;

        if (__tag203 == null ){
            __tag203 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag203);
        }
        __tag203.setPageContext(pageContext);
        __tag203.setParent(null);
        __tag203.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InstrumentsCSSDPacks.Label", java.lang.String .class,"key"));
        __tag203.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag203;
        __result__tag203 = __tag203.doStartTag();

        if (__result__tag203!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag203== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag203.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag203);
            return true;
        }
        _activeTag=__tag203.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag203);
        __tag203.release();
        return false;
    }

    private boolean _jsp__tag204(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag204 = null ;
        int __result__tag204 = 0 ;

        if (__tag204 == null ){
            __tag204 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag204);
        }
        __tag204.setPageContext(pageContext);
        __tag204.setParent(null);
        __tag204.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InstrumentsCSSDPacks.Label", java.lang.String .class,"key"));
        __tag204.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag204;
        __result__tag204 = __tag204.doStartTag();

        if (__result__tag204!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag204== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag204.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag204);
            return true;
        }
        _activeTag=__tag204.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag204);
        __tag204.release();
        return false;
    }

    private boolean _jsp__tag205(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag205 = null ;
        int __result__tag205 = 0 ;

        if (__tag205 == null ){
            __tag205 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag205);
        }
        __tag205.setPageContext(pageContext);
        __tag205.setParent(null);
        __tag205.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.OperatingRoomUsage.Label", java.lang.String .class,"key"));
        __tag205.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag205;
        __result__tag205 = __tag205.doStartTag();

        if (__result__tag205!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag205== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag205.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag205);
            return true;
        }
        _activeTag=__tag205.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag205);
        __tag205.release();
        return false;
    }

    private boolean _jsp__tag206(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag206 = null ;
        int __result__tag206 = 0 ;

        if (__tag206 == null ){
            __tag206 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag206);
        }
        __tag206.setPageContext(pageContext);
        __tag206.setParent(null);
        __tag206.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckinToORDateTime.Label", java.lang.String .class,"key"));
        __tag206.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag206;
        __result__tag206 = __tag206.doStartTag();

        if (__result__tag206!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag206== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag206.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag206);
            return true;
        }
        _activeTag=__tag206.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag206);
        __tag206.release();
        return false;
    }

    private boolean _jsp__tag207(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag207 = null ;
        int __result__tag207 = 0 ;

        if (__tag207 == null ){
            __tag207 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag207);
        }
        __tag207.setPageContext(pageContext);
        __tag207.setParent(null);
        __tag207.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckOutFromORDateTime.Label", java.lang.String .class,"key"));
        __tag207.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag207;
        __result__tag207 = __tag207.doStartTag();

        if (__result__tag207!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag207== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag207.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag207);
            return true;
        }
        _activeTag=__tag207.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag207);
        __tag207.release();
        return false;
    }

    private boolean _jsp__tag208(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag208 = null ;
        int __result__tag208 = 0 ;

        if (__tag208 == null ){
            __tag208 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag208);
        }
        __tag208.setPageContext(pageContext);
        __tag208.setParent(null);
        __tag208.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ChargableUnits.Label", java.lang.String .class,"key"));
        __tag208.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag208;
        __result__tag208 = __tag208.doStartTag();

        if (__result__tag208!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag208== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag208.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag208);
            return true;
        }
        _activeTag=__tag208.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag208);
        __tag208.release();
        return false;
    }

    private boolean _jsp__tag209(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag209 = null ;
        int __result__tag209 = 0 ;

        if (__tag209 == null ){
            __tag209 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag209);
        }
        __tag209.setPageContext(pageContext);
        __tag209.setParent(null);
        __tag209.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.completed.label", java.lang.String .class,"key"));
        __tag209.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag209;
        __result__tag209 = __tag209.doStartTag();

        if (__result__tag209!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag209== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag209.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag209);
            return true;
        }
        _activeTag=__tag209.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag209);
        __tag209.release();
        return false;
    }

    private boolean _jsp__tag210(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag210 = null ;
        int __result__tag210 = 0 ;

        if (__tag210 == null ){
            __tag210 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag210);
        }
        __tag210.setPageContext(pageContext);
        __tag210.setParent(null);
        __tag210.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.completed.label", java.lang.String .class,"key"));
        __tag210.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag210;
        __result__tag210 = __tag210.doStartTag();

        if (__result__tag210!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag210== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag210.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag210);
            return true;
        }
        _activeTag=__tag210.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag210);
        __tag210.release();
        return false;
    }

    private boolean _jsp__tag211(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag211 = null ;
        int __result__tag211 = 0 ;

        if (__tag211 == null ){
            __tag211 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag211);
        }
        __tag211.setPageContext(pageContext);
        __tag211.setParent(null);
        __tag211.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.HoldingAreaUsage.Label", java.lang.String .class,"key"));
        __tag211.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag211;
        __result__tag211 = __tag211.doStartTag();

        if (__result__tag211!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag211== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag211.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag211);
            return true;
        }
        _activeTag=__tag211.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag211);
        __tag211.release();
        return false;
    }

    private boolean _jsp__tag212(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag212 = null ;
        int __result__tag212 = 0 ;

        if (__tag212 == null ){
            __tag212 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag212);
        }
        __tag212.setPageContext(pageContext);
        __tag212.setParent(null);
        __tag212.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedInDateTime.Label", java.lang.String .class,"key"));
        __tag212.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag212;
        __result__tag212 = __tag212.doStartTag();

        if (__result__tag212!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag212== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag212.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag212);
            return true;
        }
        _activeTag=__tag212.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag212);
        __tag212.release();
        return false;
    }

    private boolean _jsp__tag213(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag213 = null ;
        int __result__tag213 = 0 ;

        if (__tag213 == null ){
            __tag213 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag213);
        }
        __tag213.setPageContext(pageContext);
        __tag213.setParent(null);
        __tag213.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedOutDateTime.Label", java.lang.String .class,"key"));
        __tag213.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag213;
        __result__tag213 = __tag213.doStartTag();

        if (__result__tag213!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag213== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag213.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag213);
            return true;
        }
        _activeTag=__tag213.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag213);
        __tag213.release();
        return false;
    }

    private boolean _jsp__tag214(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag214 = null ;
        int __result__tag214 = 0 ;

        if (__tag214 == null ){
            __tag214 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag214);
        }
        __tag214.setPageContext(pageContext);
        __tag214.setParent(null);
        __tag214.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ChargableUnits.Label", java.lang.String .class,"key"));
        __tag214.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag214;
        __result__tag214 = __tag214.doStartTag();

        if (__result__tag214!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag214== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag214.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag214);
            return true;
        }
        _activeTag=__tag214.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag214);
        __tag214.release();
        return false;
    }

    private boolean _jsp__tag215(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag215 = null ;
        int __result__tag215 = 0 ;

        if (__tag215 == null ){
            __tag215 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag215);
        }
        __tag215.setPageContext(pageContext);
        __tag215.setParent(null);
        __tag215.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedInDateTime.Label", java.lang.String .class,"key"));
        __tag215.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag215;
        __result__tag215 = __tag215.doStartTag();

        if (__result__tag215!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag215== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag215.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag215);
            return true;
        }
        _activeTag=__tag215.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag215);
        __tag215.release();
        return false;
    }

    private boolean _jsp__tag216(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag216 = null ;
        int __result__tag216 = 0 ;

        if (__tag216 == null ){
            __tag216 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag216);
        }
        __tag216.setPageContext(pageContext);
        __tag216.setParent(null);
        __tag216.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedOutDateTime.Label", java.lang.String .class,"key"));
        __tag216.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag216;
        __result__tag216 = __tag216.doStartTag();

        if (__result__tag216!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag216== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag216.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag216);
            return true;
        }
        _activeTag=__tag216.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag216);
        __tag216.release();
        return false;
    }

    private boolean _jsp__tag217(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag217 = null ;
        int __result__tag217 = 0 ;

        if (__tag217 == null ){
            __tag217 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag217);
        }
        __tag217.setPageContext(pageContext);
        __tag217.setParent(null);
        __tag217.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ChargableUnits.Label", java.lang.String .class,"key"));
        __tag217.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag217;
        __result__tag217 = __tag217.doStartTag();

        if (__result__tag217!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag217== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag217.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag217);
            return true;
        }
        _activeTag=__tag217.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag217);
        __tag217.release();
        return false;
    }

    private boolean _jsp__tag218(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag218 = null ;
        int __result__tag218 = 0 ;

        if (__tag218 == null ){
            __tag218 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag218);
        }
        __tag218.setPageContext(pageContext);
        __tag218.setParent(null);
        __tag218.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.completed.label", java.lang.String .class,"key"));
        __tag218.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag218;
        __result__tag218 = __tag218.doStartTag();

        if (__result__tag218!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag218== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag218.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag218);
            return true;
        }
        _activeTag=__tag218.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag218);
        __tag218.release();
        return false;
    }

    private boolean _jsp__tag219(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag219 = null ;
        int __result__tag219 = 0 ;

        if (__tag219 == null ){
            __tag219 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag219);
        }
        __tag219.setPageContext(pageContext);
        __tag219.setParent(null);
        __tag219.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.completed.label", java.lang.String .class,"key"));
        __tag219.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag219;
        __result__tag219 = __tag219.doStartTag();

        if (__result__tag219!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag219== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag219.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag219);
            return true;
        }
        _activeTag=__tag219.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag219);
        __tag219.release();
        return false;
    }

    private boolean _jsp__tag220(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag220 = null ;
        int __result__tag220 = 0 ;

        if (__tag220 == null ){
            __tag220 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag220);
        }
        __tag220.setPageContext(pageContext);
        __tag220.setParent(null);
        __tag220.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RecoveryRoomUsage.Label", java.lang.String .class,"key"));
        __tag220.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag220;
        __result__tag220 = __tag220.doStartTag();

        if (__result__tag220!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag220== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag220.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag220);
            return true;
        }
        _activeTag=__tag220.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag220);
        __tag220.release();
        return false;
    }

    private boolean _jsp__tag221(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag221 = null ;
        int __result__tag221 = 0 ;

        if (__tag221 == null ){
            __tag221 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag221);
        }
        __tag221.setPageContext(pageContext);
        __tag221.setParent(null);
        __tag221.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedInDateTime.Label", java.lang.String .class,"key"));
        __tag221.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag221;
        __result__tag221 = __tag221.doStartTag();

        if (__result__tag221!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag221== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag221.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag221);
            return true;
        }
        _activeTag=__tag221.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag221);
        __tag221.release();
        return false;
    }

    private boolean _jsp__tag222(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag222 = null ;
        int __result__tag222 = 0 ;

        if (__tag222 == null ){
            __tag222 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag222);
        }
        __tag222.setPageContext(pageContext);
        __tag222.setParent(null);
        __tag222.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CheckedOutDateTime.Label", java.lang.String .class,"key"));
        __tag222.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag222;
        __result__tag222 = __tag222.doStartTag();

        if (__result__tag222!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag222== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag222.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag222);
            return true;
        }
        _activeTag=__tag222.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag222);
        __tag222.release();
        return false;
    }

    private boolean _jsp__tag223(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag223 = null ;
        int __result__tag223 = 0 ;

        if (__tag223 == null ){
            __tag223 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag223);
        }
        __tag223.setPageContext(pageContext);
        __tag223.setParent(null);
        __tag223.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ChargableUnits.Label", java.lang.String .class,"key"));
        __tag223.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag223;
        __result__tag223 = __tag223.doStartTag();

        if (__result__tag223!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag223== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag223.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag223);
            return true;
        }
        _activeTag=__tag223.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag223);
        __tag223.release();
        return false;
    }

    private boolean _jsp__tag224(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag224 = null ;
        int __result__tag224 = 0 ;

        if (__tag224 == null ){
            __tag224 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag224);
        }
        __tag224.setPageContext(pageContext);
        __tag224.setParent(null);
        __tag224.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.completed.label", java.lang.String .class,"key"));
        __tag224.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag224;
        __result__tag224 = __tag224.doStartTag();

        if (__result__tag224!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag224== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag224.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag224);
            return true;
        }
        _activeTag=__tag224.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag224);
        __tag224.release();
        return false;
    }

    private boolean _jsp__tag225(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag225 = null ;
        int __result__tag225 = 0 ;

        if (__tag225 == null ){
            __tag225 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag225);
        }
        __tag225.setPageContext(pageContext);
        __tag225.setParent(null);
        __tag225.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.completed.label", java.lang.String .class,"key"));
        __tag225.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag225;
        __result__tag225 = __tag225.doStartTag();

        if (__result__tag225!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag225== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag225.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag225);
            return true;
        }
        _activeTag=__tag225.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag225);
        __tag225.release();
        return false;
    }

    private boolean _jsp__tag226(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag226 = null ;
        int __result__tag226 = 0 ;

        if (__tag226 == null ){
            __tag226 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag226);
        }
        __tag226.setPageContext(pageContext);
        __tag226.setParent(null);
        __tag226.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PrintReports.Label", java.lang.String .class,"key"));
        __tag226.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag226;
        __result__tag226 = __tag226.doStartTag();

        if (__result__tag226!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag226== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag226.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag226);
            return true;
        }
        _activeTag=__tag226.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag226);
        __tag226.release();
        return false;
    }

    private boolean _jsp__tag227(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag227 = null ;
        int __result__tag227 = 0 ;

        if (__tag227 == null ){
            __tag227 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag227);
        }
        __tag227.setPageContext(pageContext);
        __tag227.setParent(null);
        __tag227.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SummaryOfMedicalTreatmentInOT.Label", java.lang.String .class,"key"));
        __tag227.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag227;
        __result__tag227 = __tag227.doStartTag();

        if (__result__tag227!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag227== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag227.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag227);
            return true;
        }
        _activeTag=__tag227.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag227);
        __tag227.release();
        return false;
    }

    private boolean _jsp__tag228(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag228 = null ;
        int __result__tag228 = 0 ;

        if (__tag228 == null ){
            __tag228 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag228);
        }
        __tag228.setPageContext(pageContext);
        __tag228.setParent(null);
        __tag228.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProsthesisImplantsUsedForTreatment.Label", java.lang.String .class,"key"));
        __tag228.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag228;
        __result__tag228 = __tag228.doStartTag();

        if (__result__tag228!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag228== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag228.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag228);
            return true;
        }
        _activeTag=__tag228.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag228);
        __tag228.release();
        return false;
    }
}
