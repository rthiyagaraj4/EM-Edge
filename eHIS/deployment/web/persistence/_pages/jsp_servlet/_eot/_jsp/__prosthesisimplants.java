package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.HashMap;
import eOR.OrderEntryBillingQueryBean;
import eOT.OTBillingBean;
import eST.OTTransactionBean;
import eST.*;
import org.joda.time.DateTime;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __prosthesisimplants extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ProsthesisImplants.jsp", 1709120324000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<HTML>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/RecordNursing.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"Javascript\" src=\"../../framework/js/PopupWindow.js\"></script>\n<script language=\'javascript\' src=\'../../eOT/js/jquery-latest.js\'></script>\n<!--MMS-QH-CRF-0199-->\n<style type=\"text/css\">\n.my_dropdown {    \n    width: 180px ; min-width: 100px; max-width: 200px;    \n}\nselect:focus{width:200px !important;}\n</style>\n\n<script>\n$(document).ready(function() {\n\tvar maxLength = 30;\n    $(\'#my_dropdown > option\').text(function(i, text) {\n    if (text.length > maxLength) {\n        return text.substr(0, maxLength) + \'...\';  \n        }\n    });\n});\n</script>\n<!--MMS-QH-CRF-0199-->\n<script language=\'javascript\'>\n\nfunction disableSelectButton(obj)\n{\n\n obj.disabled = true;\n}\nfunction openCheckListRemarksWindow(obj)\n{\n\n\t\tvar remarks=encodeURIComponent(document.ImplantsRecordForm.remarks.value);\n\t\tvar flag=\"1\"\t;\n\t\tvar size=\"100\";\n\t\tvar heading = getLabel(\"Common.remarks.label\",\"common\");\n\t\tvar dialogHeight\t\t= \"9\";\n\t\tvar dialogWidth\t\t\t= \"32\";\n\t\tvar features\t\t\t=\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\tvar arguments\t\t\t= \"\";\n\t\theading=encodeURIComponent(heading);\n\t\tvar param=\'remarks=\'+remarks+\'&heading=\'+heading+\'&flag=\'+flag+\'&size=\'+size;\n\t\t//var params=unescape(param);\n\t\tvar ret=\"\"+window.showModalDialog(\"../../eOT/jsp/TextArea.jsp?\"+param,arguments,features);\n\t\tif(flag==\'1\' && ret!=\"undefined\" ){\n\t\t\tret=ret.slice(0,ret.length);\n\t\t\tobj.value=ret;\n\t\t}\n}\nfunction openCheckListRemarksWindow_cp(obj)\n{\n\n\t\tvar remarks=encodeURIComponent(obj.value);\n\t\tvar flag=\"1\"\t;\n\t\tvar size=\"100\";\n\t\tvar heading = getLabel(\"Common.remarks.label\",\"common\");\n\t\tvar dialogHeight\t\t= \"9\";\n\t\tvar dialogWidth\t\t\t= \"32\";\n\t\tvar features\t\t\t=\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\tvar arguments\t\t\t= \"\";\n\t\theading=encodeURIComponent(heading);\n\t\tvar param=\'remarks=\'+remarks+\'&heading=\'+heading+\'&flag=\'+flag+\'&size=\'+size;\n\t\tvar ret=\"\"+window.showModalDialog(\"../../eOT/jsp/TextArea.jsp?\"+param,arguments,features);\n\t\tif(flag==\'1\' && ret!=\"undefined\" ){\n\t\tret=ret.slice(0,ret.length);\n\t\tobj.value=ret;\n\t}\n}\n\nfunction openCheckListRemarksWindow_eq(obj)\n{\n\n\t\tvar remarks=encodeURIComponent(obj.value);\n\t\tvar flag=\"1\"\t;\n\t\tvar size=\"100\";\n\t\tvar heading = getLabel(\"Common.remarks.label\",\"common\");\n\t\tvar dialogHeight\t\t= \"9\";\n\t\tvar dialogWidth\t\t\t= \"32\";\n\t\tvar features\t\t\t=\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\tvar arguments\t\t\t= \"\";\n\t\theading=encodeURIComponent(heading);\n\tvar param=\'remarks=\'+remarks+\'&heading=\'+heading+\'&flag=\'+flag+\'&size=\'+size;\n//\tvar params=unescape(param);\n\tvar ret=\"\"+window.showModalDialog(\"../../eOT/jsp/TextArea.jsp?\"+param,arguments,features);\n\tif(flag==\'1\' && ret!=\"undefined\" ){\n\t\tret=ret.slice(0,ret.length);\n\t\tobj.value=ret;\n\t}\n}\n\nfunction openCheckListRemarksWindow_ic(obj)\n{\n\n\t\tvar remarks=encodeURIComponent(obj.value);\n\t\tvar flag=\"1\"\t;\n\t\tvar size=\"100\";\n\t\tvar heading = getLabel(\"Common.remarks.label\",\"common\");\n\t\tvar dialogHeight\t\t= \"9\";\n\t\tvar dialogWidth\t\t\t= \"32\";\n\t\tvar features\t\t\t=\"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\";status=no\";\n\t\tvar arguments\t\t\t= \"\";\n\t\theading=encodeURIComponent(heading);\n\tvar param=\'remarks=\'+remarks+\'&heading=\'+heading+\'&flag=\'+flag+\'&size=\'+size;\n//\tvar params=unescape(param);\n\tvar ret=\"\"+window.showModalDialog(\"../../eOT/jsp/TextArea.jsp?\"+param,arguments,features);\n\tif(flag==\'1\' && ret!=\"undefined\" ){\n\t\tret=ret.slice(0,ret.length);\n\t\tobj.value=ret;\n\t}\n}\n\nfunction Class_row()\n{\n  this.oper_code =\"\";\n  this.oper_desc=\"\";\n  this.implants_code=\"\";\n  this.implants_desc=\"\";\n  this.oper_line_no =\"\";\n  this.manufacturer=\"\";\n  this.batch=\"\";\n  this.order=\"\";\n  this.quantity =\"\";\n  this.remarks =\"\";\n  this.accessory_type=\"\";\n  this.db_mode=\"\";\n  this.recId=\"\";\n  this.reserved_qty=\"\";\n  this.requested_qty=\"\";\n  this.frm_pick_list=\"\";\n  this.sale_document_no =\"\";\n  this.sale_document_type =\"\";\n  this.req_store_code=\"\";\n  this.Stockavail = \"\";\n  this.bill_str=\"\";\n  this.bill_str_conspack=\"\";\n  this.panel_str=\"\";\n  this.panel_str_conspack=\"\";\n  this.key=\"\";\n  this.key_line=\"\";\n  this.rate=\"\";\n}\n\nfunction Class_row_eq()\n{\n  this.oper_code =\"\";\n  this.oper_desc=\"\";\n  this.equip_code=\"\";\n  this.equip_desc=\"\";\n  this.oper_line_no =\"\";\n  this.equip_id =\"\";\n  this.remarks =\"\";\n  this.order=\"\";\n  this.accessory_type=\"\";\n  this.db_mode=\"\";\n  this.frm_pick_list=\"\";\n  this.recId=\"\";\n  this.bill_str=\"\";\n  this.panel_str=\"\";\n  this.key=\"\";\n  this.key_line=\"\";\n   this.rate=\"\";\n\tthis.desiredDate=\"\";\n}\n\n\n/*function addRow(){\n  var objrow = newRow();\n  var msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n  var rows=parent.parent.parent.ObjectCollect.implants_rows;\n  var index_val=rows.length+1;\n  var formObj = document.forms[0];\n  var params = formObj.params.value;\n  var rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;\n  var rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;\n  var rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;\n  var rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;\n  var st_interface_flag=formObj.st_interface_flag.value;\n  var fromval=formObj.fromval.value;\n  var mode =formObj.mode.value;\n   var key = formObj.oper_num.value+\"@\"+formObj.oper_code.value+\"@I\"+\"@\"+formObj.implant_code.value;\n  var obj = formObj.operation;\n  var bill_flag = formObj.bill_flag.value;\n\n  if(chkEmpty()){\n\tif(mode==\'I\'){\n\t  if(alreadyExist()){\n\t\tif(bill_flag==\"true\")// added by sathish to disable Billing Part\n\t\t{\n\t\t\tif(st_interface_flag==\"N\" && fromval==\"prosimplants\")\n\t\t\t{\n\t\tvar retVal = callOrderLineCreation(formObj.quantity.value);\n\t\tretVal=trimString(retVal);\n\t\t\n\t\tvar arr = retVal.split(\"@@\");\n\t\tif(arr[0]==\"BL0639\"){\n\t\t\talert(getMessage(\"BL0639\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tif(localTrimString(arr[2])!=\'\')\n\t\t\t{\n\t\t\tvar err_pat=localTrimString(arr[2]);\n\t\t\talert(err_pat);\n\t\t\treturn false;\n\t\t\t}\n\t\t\t}\n\t\t}\n\t\t\tobjrow.oper_code=formObj.oper_code.value;\n\t\t\tobjrow.oper_desc=formObj.operation.options[obj.selectedIndex].text;\n\t\t\tobjrow.quantity = formObj.quantity.value;\n\t\t\tif(st_interface_flag==\"Y\" && fromval==\"prosimplants\")\n\t\t\t{\n\t\t\tobjrow.reserved_qty=formObj.Reservepicklist.value;\n\t\t\tobjrow.requested_qty=formObj.Requestpicklist.value;\n\t\t\tobjrow.sale_document_no = formObj.sale_document_no.value\n\t\t\tobjrow.sale_document_type = formObj.sale_document_type.value\n\t\t\tobjrow.Stockavail = formObj.Stockavail.value;\n\t\t\tobjrow.Store_desc=formObj.conns_store.value;\n\t\t\tobjrow.req_store_code=formObj.req_store_code.value;\n\n\t\t\tif(formObj.Stockavail.value ==\"\" || formObj.Stockavail.value ==\"0\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"PRC-OT0054\",\"OT\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t}\n\t\t\t}\n\t\t\tobjrow.implant_code=formObj.implant_code.value;\n\t\t\tobjrow.implant_desc=formObj.implant_desc.value;\n\t\t\tobjrow.oper_line_no = formObj.oper_line_no.value;\n\t\t\tobjrow.remarks = formObj.remarks.value;\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\tif(st_interface_flag==\"N\")\n\t\t    {\n\t\t\tobjrow.manufacturer = formObj.manufacturer.value;\n\t\t\tobjrow.batch = formObj.batch.value;\n\t\t\t}\n\t\t    \n\t\t\tobjrow.recId = getRecId();\n\t\t\tif(bill_flag==\"true\")\n\t\t    {\n\t\t\tvar retVal = callOrderLineCreation(formObj.quantity.value);\n\t\t\tif(st_interface_flag==\"N\" && fromval==\"prosimplants\")\n\t\t\t{\n\t\t\tvar arr = retVal.split(\"@@\");\n\t\t\tobjrow.panel_str = arr[0];\n\t\t\tobjrow.bill_str = arr[1];\n\t\t\t}else\n\t\t\t{\n\t\t\t\tvar retVal = Callbilling_ST(formObj.quantity.value,formObj.req_store_code.value,formObj.patient_id.value,formObj.encounter_id.value,formObj.patient_class.value,formObj.implant_code.value);\n\n\t\t\t\tobjrow.bill_str = retVal;\n\t\t\t}\n\t\t\t}\n\t\t\tobjrow.key=key;\n\t\t\tobjrow.key_line=\"\";\n\t\t\tobjrow.db_mode=\"I\";\n\t\t\trows.push(objrow);\n\t\t\tresetFields();\n\t\t\t//alert(\"params  in pi\"+params);\n\t\t\t\t//Commented by AnithaJ on 22/11/2010 for scf-5515\n\t\t\t//params=params+\"&rec_implants_in_nurs_notes_yn=\"+rec_implants_in_nurs_notes_yn+\"&rec_instr_in_nurs_notes_yn=\"+rec_instr_in_nurs_notes_yn+\"&rec_packs_in_nurs_notes_yn=\"+rec_packs_in_nurs_notes_yn+\"&rec_equp_in_nurs_notes_yn=\"+rec_equp_in_nurs_notes_yn+\"&st_interface_flag=\"+st_interface_flag;\n\n\t\t\tparent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t\n\t} else{\n\t\t parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t\t resetFields();\n\t}\n\t}else{\n\t  updateRow();\n\t}\n  }\nif(st_interface_flag==\"Y\" && fromval==\"prosimplants\")\n\t\t\t{\n\t\tdocument.forms[0].Stockavail.value=\"\";\n\t\t\t}\n}*/\nfunction addRow()\n{\n\tvar objrow = newRow();\n\tvar msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n\tvar rows=parent.parent.parent.ObjectCollect.implants_rows;\n\tvar index_val=rows.length+1;\n\tvar formObj = document.forms[0];\n\tvar params = formObj.params.value;\n\tvar rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;\n\tvar rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;\n\tvar rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;\n\tvar rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;\n\tvar st_interface_flag=formObj.st_interface_flag.value;\n\tvar fromval=formObj.fromval.value;\n\tvar mode =formObj.mode.value;\n\tvar key = formObj.oper_num.value+\"@\"+formObj.oper_code.value+\"@I\"+\"@\"+formObj.implant_code.value;\n\tvar obj = formObj.operation;\n\tvar bill_flag = formObj.bill_flag.value;\n\tif(chkEmpty())\n\t{\n\t\tif(mode==\'I\')\n\t\t{\n\t\t\tif(alreadyExist())\n\t\t\t{\n\t\t\t\tif(bill_flag==\"true\")// added by sathish to disable Billing Part\n\t\t\t\t{\n\t\t\t\t\tif(st_interface_flag==\"N\" && fromval==\"prosimplants\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar retVal = callOrderLineCreation(formObj.quantity.value);\n\t\t\t\t\t\tretVal=trimString(retVal);\n\t\t\t\t\t\tvar arr = retVal.split(\"@@\");\n\t\t\t\t\t\t\n\t\t\t\t\t\t//if(arr[0]==\"BL0639\")\n\t\t\t\t\t\tif(arr[0]==\'BL0639\' || (~(arr[0]).indexOf(\'BL0639\')!=0))\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\talert(getMessage(\"BL0639\",\"BL\"));\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(localTrimString(arr[2])!=\'\')\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar err_pat=localTrimString(arr[2]);\n\t\t\t\t\t\t\talert(err_pat);\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tobjrow.panel_str = arr[0];\n\t\t\t\t\t\tobjrow.bill_str = arr[1];\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar retVal = Callbilling_ST(formObj.quantity.value,formObj.r";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="eq_store_code.value,formObj.patient_id.value,formObj.encounter_id.value,formObj.patient_class.value,formObj.implant_code.value);\n\t\t\t\t\t\tobjrow.bill_str = retVal;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tobjrow.oper_code=formObj.oper_code.value;\n\t\t\t\tobjrow.oper_desc=formObj.operation.options[obj.selectedIndex].title;//MMS-QH-CRF-0199\n\t\t\t\tobjrow.quantity = formObj.quantity.value;\n\t\t\t\tif(st_interface_flag==\"Y\" && fromval==\"prosimplants\")\n\t\t\t\t{\n\t\t\t\t\tobjrow.reserved_qty=formObj.Reservepicklist.value;\n\t\t\t\t\tobjrow.requested_qty=formObj.Requestpicklist.value;\n\t\t\t\t\tobjrow.sale_document_no = formObj.sale_document_no.value\n\t\t\t\t\tobjrow.sale_document_type = formObj.sale_document_type.value\n\t\t\t\t\tobjrow.Stockavail = formObj.Stockavail.value;\n\t\t\t\t\tobjrow.Store_desc=formObj.conns_store.value;\n\t\t\t\t\tobjrow.req_store_code=formObj.req_store_code.value;\n\t\t\t\t\tif(formObj.Stockavail.value ==\"\" || formObj.Stockavail.value ==\"0\")\n\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"PRC-OT0054\",\"OT\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\tobjrow.implant_code=formObj.implant_code.value;\n\t\t\t\tobjrow.implant_desc=formObj.implant_desc.value;\n\t\t\t\tobjrow.oper_line_no = formObj.oper_line_no.value;\n\t\t\t\tobjrow.remarks = formObj.remarks.value;\n\t\t\t\tif(st_interface_flag==\"N\")\n\t\t\t\t{\n\t\t\t\t\tobjrow.manufacturer = formObj.manufacturer.value;\n\t\t\t\t\tobjrow.batch = formObj.batch.value;\n\t\t\t\t}\n\t\t\t\tobjrow.recId = getRecId();\n\t/*************   Commented    duplicate  call -  callOrderLineCreation as per site informed  performance issue\n\t\t\t\tif(bill_flag==\"true\")\n\t\t\t\t{\n\t\t\t\t\tif(st_interface_flag==\"N\" && fromval==\"prosimplants\")\n\t\t\t\t\t{\n\t\t\t\t\t\tvar retVal = callOrderLineCreation(formObj.quantity.value);\n\t\t\t\t\t\tvar arr = retVal.split(\"@@\");\n\t\t\t\t\t\tobjrow.panel_str = arr[0];\n\t\t\t\t\t\tobjrow.bill_str = arr[1];\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tvar retVal = Callbilling_ST(formObj.quantity.value,formObj.req_store_code.value,formObj.patient_id.value,formObj.encounter_id.value,formObj.patient_class.value,formObj.implant_code.value);\n\t\t\t\t\t\tobjrow.bill_str = retVal;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t***************************/\n\t\t\t\tobjrow.key=key;\n\t\t\t\tobjrow.key_line=\"\";\n\t\t\t\tobjrow.db_mode=\"I\";\n\t\t\t\trows.push(objrow);\n\t\t\t\tresetFields();\n\t\t\t\t//alert(\"params  in pi\"+params);\n\t\t\t\t//Commented by AnithaJ on 22/11/2010 for scf-5515\n\t\t\t\t//params=params+\"&rec_implants_in_nurs_notes_yn=\"+rec_implants_in_nurs_notes_yn+\"&rec_instr_in_nurs_notes_yn=\"+rec_instr_in_nurs_notes_yn+\"&rec_packs_in_nurs_notes_yn=\"+rec_packs_in_nurs_notes_yn+\"&rec_equp_in_nurs_notes_yn=\"+rec_equp_in_nurs_notes_yn+\"&st_interface_flag=\"+st_interface_flag;\n\t\t\t\tparent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n\t\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t\t\t\tresetFields();\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\tupdateRow();\n\t\t}\n\t}\n\tif(st_interface_flag==\"Y\" && fromval==\"prosimplants\")\n\t{\n\t\tdocument.forms[0].Stockavail.value=\"\";\n\t}\n}\n\nfunction Callbilling_ST(Qty,req_store,patient_id,encounter_id,pat_class,item_code)\n{\n\n\tvar formObj = document.forms[0];\n\tvar oper_num = formObj.oper_num.value;\n\t//var item_code = formObj.item_id.value;\n\tvar locale = formObj.locale.value;\n\tvar param = \"oper_num=\"+oper_num+\"&p_Qty=\"+Qty+\"&req_store=\"+req_store+\"&patient_id=\"+patient_id+\"&encounter_id=\"+encounter_id+\"&pat_class=\"+pat_class+\"&item_code=\"+item_code;\n\tvar xmlStr =\"<root></root>\";\n\tvar temp_jsp=\"STbillingcharges.jsp?\"+param;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText) ;\n\treturn responseText;\n\n}\n\n\n\nfunction addRow_ic(){\n  var objrow = newRow_ic();\n  var msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n  var rows=parent.parent.parent.ObjectCollect.instrument_rows;\n  var formObj = document.forms[0];\n  var rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;\n  var rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;\n  var rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;\n  var rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;\n  var st_interface_flag=formObj.st_interface_flag.value;\n  var params = formObj.params.value;\n  var mode =formObj.mode.value;\n  var obj = formObj.operation_ic;\n  var bill_flag=document.forms[0].bill_flag.value;\n  \n  if(chkEmpty_ic()){\n\tif(mode==\'I\'){\n\t   if(alreadyExist_ic()){\n\t\tif(bill_flag==\"true\") // added by satihsh on 10-01-2009to diable billing part when interfaceto Patient billing check box unchecked \n\t\t{\n\n\t\tvar retVal = callOrderLineCreation_ic(formObj.quantity_ic.value);\n\t\tretVal=trimString(retVal);\n\t\tvar arr = retVal.split(\"@@\");\n\t\t\n\t\t//if(arr[0]==\"BL0639\")\n\t\tif(arr[0]==\'BL0639\' || (~(arr[0]).indexOf(\'BL0639\')!=0))\t\n\t\t{\n\t\t\talert(getMessage(\"BL0639\",\"BL\"));\n\t\t\treturn false;\n\t\t }\n\n\t\t if(localTrimString(arr[2])!=\'\')\n\t\t\t{\n\t\t\tvar err_pat=localTrimString(arr[2]);\n\t\t\talert(err_pat);\n\t\t\treturn false;\n\t\t\t}\n\t\t }\n\t\tvar key = formObj.oper_num.value+\"@\"+formObj.oper_code.value+\"@S\"+\"@\"+formObj.instr_code.value;\n\t\tobjrow.oper_code=formObj.oper_code.value;\n\t\tobjrow.oper_desc=formObj.operation_ic.options[obj.selectedIndex].title;//MMS-QH-CRF-0199\n\t\tobjrow.instr_code=formObj.instr_code.value;\n\t\tobjrow.instr_desc=formObj.instr_desc.value;\n\t\tobjrow.oper_line_no = formObj.oper_line_no.value;\n\t\tobjrow.tray_no = formObj.tray_no.value;\n\t\tobjrow.remarks = formObj.remarks_ic.value;\n\t\tobjrow.quantity = formObj.quantity_ic.value;\n\n\t\tobjrow.recId = getRecId_ic();\n        if(bill_flag==\"true\")\n\t\t{\n\t\tvar arr = retVal.split(\"@@\");\n\t\tobjrow.panel_str = arr[0];\n\t\tobjrow.bill_str = arr[1];\n\t\t}\n\t\tobjrow.key=key;\n\t\tobjrow.key_line=\"\";\n\t\tobjrow.db_mode=\"I\";\n\t\t//alert(\'objrow \'+key);\n\t\trows.push(objrow);\n\t\tresetFields_ic();\n\t\t\n\t//Commented by AnithaJ on 22/11/2010 for scf-5515\n\t/*params=params+\"&rec_implants_in_nurs_notes_yn=\"+rec_implants_in_nurs_notes_yn+\"&rec_instr_in_nurs_notes_yn=\"+rec_instr_in_nurs_notes_yn+\"&rec_packs_in_nurs_notes_yn=\"+rec_packs_in_nurs_notes_yn+\"&rec_equp_in_nurs_notes_yn=\"+rec_equp_in_nurs_notes_yn+\"&st_interface_flag=\"+st_interface_flag;*/\n\t\t//alert(\"params  \"+params);\n\n\t\tparent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n\t\t//alert(parent.ResultsFrame.location.href);\n\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t\n\t} else{\n\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t\tresetFields_ic();\n\t}\n\t}else\n\t  updateRow_ic();\t\n  }\n}\nfunction addRow_cp(){\n  var objrow = newRow();\n  var msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n  var rows=parent.parent.parent.ObjectCollect.packs_rows;\n  var formObj = document.forms[0];\n  var params = formObj.params.value;\n  var mode =formObj.mode.value;\n  var obj = formObj.operation_cp;\n  var bill_flag = formObj.bill_flag.value;\n  var rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;\n  var rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;\n  var rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;\n  var rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;\n  var st_interface_flag=formObj.st_interface_flag.value;\n   var key = formObj.oper_num.value+\"@\"+formObj.oper_code.value+\"@C\"+\"@\"+formObj.package_code.value;\n  if(chkEmpty_cp()){\n\tif(mode==\'I\'){\n\t   if(alreadyExist_cp()){\n\t\tif(bill_flag==\"true\") //added by sathish to disable Billing Part\n\t\t{\n\t\tvar retVal = callOrderLineCreation_cp(formObj.quantity_cp.value);\n\t\tretVal=trimString(retVal);\n\t\tvar arr = retVal.split(\"@@\");\n\t\t//if(arr[0]==\"BL0639\")\n\t\tif(arr[0]==\'BL0639\' || (~(arr[0]).indexOf(\'BL0639\')!=0))\n\t\t{\n\t\t\talert(getMessage(\"BL0639\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif(localTrimString(arr[2])!=\'\')\n\t\t\t{\n\t\t\tvar err_pat=localTrimString(arr[2]);\n\t\t\talert(err_pat);\n\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\t\tobjrow.oper_code=formObj.oper_code.value;\n\t\t\tobjrow.oper_desc=formObj.operation_cp.options[obj.selectedIndex].title;//MMS-QH-CRF-0199\n\t\t\tobjrow.package_code=formObj.package_code.value;\n\t\t\tobjrow.package_desc=formObj.package_desc.value;\n\t\t\tobjrow.oper_line_no = formObj.oper_line_no.value;\n\t\t\tobjrow.quantity = formObj.quantity_cp.value;\n\t\t\tobjrow.remarks = formObj.remarks_cp.value;\n\n\t\t\tobjrow.recId = getRecId_copk();\n\t\t\t//var retVal = callOrderLineCreation();\n\t\t\tif(bill_flag==\"true\")\n\t\t    {\n\t\t\t\t\n\t\t\tvar arr = retVal.split(\"@@\");\n\t\t\tobjrow.panel_str = arr[0];\n\t\t\tobjrow.bill_str_conspack = arr[1];\n\t\t    }\n\t\t\tobjrow.key=key;\n\t\t\tobjrow.key_line=\"\";\n\t\t\tobjrow.db_mode=\"I\";\n\t\t\trows.push(objrow);\n\t\t\tresetFields_cp();\n\t\t\t\n\t\t\t//Commented by Anitha on 11/23/2010 for scf-5515\n\t\t\t//params=params+\"&rec_implants_in_nurs_notes_yn=\"+rec_implants_in_nurs_notes_yn+\"&rec_instr_in_nurs_notes_yn=\"+rec_instr_in_nurs_notes_yn+\"&rec_packs_in_nurs_notes_yn=\"+rec_packs_in_nurs_notes_yn+\"&rec_equp_in_nurs_notes_yn=\"+rec_equp_in_nurs_notes_yn+\"&st_interface_flag=\"+st_interface_flag;\n\t\t\t//alert(\"params   in cp\"+params);\n\t\t\tparent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\n\t} else{\n\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t\tresetFields_cp();\n\t}\n\t}else\n\t  updateRow_cp();\n  }\n  expandselec(\'Conspack\')\n}\n\n\nfunction updateBillingDetailsValidation(key,key_line,p_qty,implant_code,acc_type){\n\tvar formObj = document.ImplantsRecordForm;\n\tvar oper_code = formObj.oper_code.value;\n\tvar locale = formObj.locale.value;\n\tvar oper_num = formObj.oper_num.value;\n\t\n\tvar order_id = \"\";\n\tvar order_line_num = \"\";\n\tvar param = \"order_id=\"+order_id+\"&order_line_num=\"+order_line_num+\"&oper_code=\"+oper_code+\"&key=\"+key+\"&key_line=\"+key_line+\"&locale=\"+locale+\"&p_qty=\"+p_qty+\"&oper_num=\"+oper_num+\"&oper_code=\"+oper_code+\"&acc_code=\"+implant_code+\"&acc_type=\"+acc_type;\n\tvar xmlStr =\"<root></root>\";\n\tvar temp_jsp=\"UpdateBillingDetailsValidation.jsp?\"+param;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText) ;\n\treturn responseText;\n\n\n}\n\nfunction DeleteKey(key){\n\tvar xmlStr =\"<root></root>\";\n\tvar temp_jsp=\"DeletePersistenceBeankey.jsp?del_key=\"+key;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText) ;\n\treturn responseText;\n}\n\n\nfu";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block8_2 ="nction callOrderLineCreation(quantity){\n\tvar formObj = document.forms[0];\n\tvar oper_num = formObj.oper_num.value;\n\tvar implant_code = formObj.implant_code.value;\n\tvar oper_code = (formObj.operation.value).split(\"##\")[0];\n\tvar param = \"oper_num=\"+oper_num+\"&acc_type=I&called_from=ACC_TAB&acc_code=\"+implant_code+\"&oper_code=\"+oper_code+\"&quantity=\"+quantity;\n\tvar xmlStr =\"<root></root>\";\n\tvar temp_jsp=\"OTOrderLineCreation.jsp?\"+param;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText) ;\n\treturn responseText;\n}\nfunction callOrderLineCreation_cp(quantity){\n\tvar formObj = document.forms[0];\n\tvar oper_num = formObj.oper_num.value;\n\tvar implant_code = formObj.package_code.value;\n\tvar oper_code = (formObj.operation_cp.value).split(\"##\")[0];\n\tvar param = \"oper_num=\"+oper_num+\"&acc_type=C&called_from=ACC_TAB&acc_code=\"+implant_code+\"&oper_code=\"+oper_code+\"&quantity=\"+quantity;\n\tvar xmlStr =\"<root></root>\";\n\tvar temp_jsp=\"OTOrderLineCreation.jsp?\"+param;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText) ;\n\treturn responseText;\n}\n\nfunction callOrderLineCreation_eq(quantity){\n\tvar formObj = document.forms[0];\n\tvar oper_num = formObj.oper_num.value;\n\tvar implant_code = formObj.equip_code.value;\n\tvar oper_code = (formObj.operation_eq.value).split(\"##\")[0];\n\tvar param = \"oper_num=\"+oper_num+\"&acc_type=E&called_from=ACC_TAB&acc_code=\"+implant_code+\"&oper_code=\"+oper_code+\"&quantity=\"+quantity;\n\tvar xmlStr =\"<root></root>\";\n\tvar temp_jsp=\"OTOrderLineCreation.jsp?\"+param;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText) ;\n\treturn responseText;\n}\n\nfunction callOrderLineCreation_ic(quantity){\n\tvar formObj = document.forms[0];\n\tvar oper_num = formObj.oper_num.value;\n\tvar implant_code = formObj.instr_code.value;\n\tvar oper_code = (formObj.operation_ic.value).split(\"##\")[0];\n\tvar param = \"oper_num=\"+oper_num+\"&acc_type=S&called_from=ACC_TAB&acc_code=\"+implant_code+\"&oper_code=\"+oper_code+\"&quantity=\"+quantity;\n\tvar xmlStr =\"<root></root>\";\n\tvar temp_jsp=\"OTOrderLineCreation.jsp?\"+param;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText) ;\n\treturn responseText;\n}\n\nfunction newRow(){\n  var objrow = new Class_row();\n   return(objrow);\n} \nfunction newRow_cons(){\n  var objrow = new Class_row_cons();\n   return(objrow);\n}  \nfunction newRow_eq(){\n  var objrow = new Class_row_eq();\n   return(objrow);\n} \nfunction newRow_ic(){\n  var objrow = new Class_row_ic();\n   return(objrow);\n} \nfunction Class_row_ic(){\n  this.oper_code =\"\";\n  this.oper_desc=\"\";\n  this.instr_code=\"\";\n  this.instr_desc=\"\";\n  this.oper_line_no =\"\";\n  this.tray_no =\"\";\n  this.remarks =\"\";\n  this.accessory_type=\"\";\n  this.db_mode=\"\";\n  this.recId=\"\";\n  this.order=\"\";\n  this.key=\"\";\n  this.key_line=\"\";\n  this.panel_str=\"\";\n  this.bill_str=\"\";\n  this.rate=\"\";\n  this.frm_pick_list=\"\";\n\n}\n\nfunction Class_row_cons()\n\t{\n\t  this.oper_code =\"\";\n\t  this.oper_desc=\"\";\n\t  this.package_code=\"\";\n\t  this.package_desc=\"\";\n\t  this.oper_line_no =\"\";\n\t  this.quantity =\"\";\n\t  this.remarks =\"\";\n\t  this.order=\"\";\n\t  this.accessory_type=\"\";\n\t  this.db_mode=\"\";\n\t  this.recId=\"\";\n\t   this.frm_pick_list=\"\";\n\t  this.bill_str=\"\";\n\t  this.panel_str=\"\";\n\t  this.key=\"\";\n\t  this.key_line=\"\";\n\t  this.reserved_qty=\"\";\n\t  this.requested_qty=\"\";\n\t  this.req_store_code=\"\";\n\t  this.rate=\"\";\n\t}\n\nfunction alreadyExist(){\n\tvar formObj = document.ImplantsRecordForm;\n\tvar codeDtl = parent.ResultsFrame.code; \n\tvar oper_code=formObj.oper_code.value;\n\tvar implant_code = formObj.implant_code.value;\n\tvar codeRecord = oper_code+implant_code;\n\tif(codeDtl.indexOf(codeRecord)>=0)\n\t   return false;\n\telse\n\t  return true;\n}\nfunction alreadyExist_eq(){\n\tvar formObj = document.forms[0];\n\tvar codeDtl = parent.ResultsFrame.code_eq; \n\tvar oper_code=formObj.oper_code.value;\n\tvar equip_code = formObj.equip_code.value;\n\tvar codeRecord = oper_code + equip_code + \',\';\n\tif(codeDtl.indexOf(codeRecord)>=0)\n\t{\n\t   return false;\n\t}\n\telse{\n\t  return true;\n\t}\n}\nfunction alreadyExist_ic(){\n\tvar formObj = document.forms[0];\n\tvar codeDtl = parent.ResultsFrame.code_ic; \n\tvar oper_code=formObj.oper_code.value;\n\tvar instr_code = formObj.instr_code.value;\n\tvar codeRecord = oper_code+instr_code;\n\tif(codeDtl.indexOf(codeRecord)>=0)\n\t   return false;\n\telse\n\t  return true;\n}\nfunction alreadyExist_cp(){\n\tvar formObj = document.forms[0];\n\tvar codeDtl = parent.ResultsFrame.code_copk; \n\tvar oper_code=formObj.oper_code.value;\n\tvar package_code = formObj.package_code.value;\n\tvar codeRecord = oper_code+package_code;\n\tif(codeDtl.indexOf(codeRecord)>=0)\n\t   return false;\n\telse\n\t  return true;\n}\n function assignRecId(){\n\t \n\tvar tab=\"";
    private final static byte[]  _wl_block8_2Bytes = _getBytes( _wl_block8_2 );

    private final static java.lang.String  _wl_block9_0 ="\";\n\t\n\tif(tab !=\"record_surgeon\")\n\t {\n\tvar rows = parent.parent.parent.ObjectCollect.implants_rows;\n\tvar rows_copk = parent.parent.parent.ObjectCollect.packs_rows;\n\tvar rows_eq = parent.parent.parent.ObjectCollect.equipment_rows;\n\tvar rows_ic = parent.parent.parent.ObjectCollect.instrument_rows;\n\t }else\n\t {\n\tvar rows = parent.parent.parent.ObjectCollect.implants_rows;\n\n\t }\n\n\t\n\n\tif(tab !=\"record_surgeon\")\n\t {\n\tparent.parent.parent.parent.ObjectCollect.implants_len=rows.length;\n\tparent.parent.parent.parent.ObjectCollect.packs_len=rows_copk.length;\n\t//alert(\'rows_eq.length \'+rows_eq.length);\n\tparent.parent.parent.parent.ObjectCollect.equipment_len=rows_eq.length;\n\tparent.parent.parent.parent.ObjectCollect.instrument_len=rows_ic.length;\n\t }else\n\t {\n\t\t \tparent.parent.parent.parent.ObjectCollect.implants_len=rows.length;\n\n\t }\n\n\n\t\n}\n\nfunction getRecId(){\n    var rowLength=parent.parent.parent.parent.ObjectCollect.implants_len;\n\tvar recId = rowLength+1;\n\tparent.parent.parent.parent.ObjectCollect.implants_len = recId;\n\treturn recId;\n}\n// commented by DhanasekarV against issue IN026038 on 24/01/2011\n/*function getRecId_copk(){\n    var rowLength_copk=parent.parent.parent.parent.ObjectCollect.packs_len;\n\tvar recId_copk = rowLength_copk+2;\n\tparent.parent.parent.parent.ObjectCollect.packs_len = recId_copk;\n\treturn recId_copk;\n}\n\nfunction getRecId_eq(){\n    var rowLength_copk=parent.parent.parent.parent.ObjectCollect.equipment_len;\n\talert(\'getRecId eq \'+rowLength_copk);\n\tvar recId_eq = rowLength_copk+2;\n\tparent.parent.parent.parent.ObjectCollect.equipment_len = recId_eq;\n\treturn recId_eq;\n}\n\nfunction getRecId_ic(){\n    var rowLength_copk=parent.parent.parent.parent.ObjectCollect.instrument_len;\n\tvar recId_ic = rowLength_copk+2;\n\tparent.parent.parent.parent.ObjectCollect.instrument_len = recId_ic;\n\treturn recId_ic;\n}*/\n\nfunction getRecId_copk(){\n    var rowLength_copk=parent.parent.parent.parent.ObjectCollect.packs_len;\n\tvar recId_copk = rowLength_copk+1;\n\tparent.parent.parent.parent.ObjectCollect.packs_len = recId_copk;\n\treturn recId_copk;\n}\n\nfunction getRecId_eq(){\n    var rowLength_copk=parent.parent.parent.parent.ObjectCollect.equipment_len;\n\t//alert(\'getRecId eq \'+rowLength_copk);\n\tvar recId_eq = rowLength_copk+1;\n\tparent.parent.parent.parent.ObjectCollect.equipment_len = recId_eq;\n\treturn recId_eq;\n}\n\nfunction getRecId_ic(){\n    var rowLength_copk=parent.parent.parent.parent.ObjectCollect.instrument_len;\n\tvar recId_ic = rowLength_copk+1;\n\tparent.parent.parent.parent.ObjectCollect.instrument_len = recId_ic;\n\treturn recId_ic;\n}\n\n\n\nfunction chkEmpty(){\n\tvar formObj = document.ImplantsRecordForm;\n\tvar st_interface_flag=formObj.st_interface_flag.value;\n\tvar operation\t\t\t=getLabel(\"Common.operation.label\",\"Common\");\n\tvar implant\t\t\t\t=getLabel(\"Common.Implant.label\",\"Common\");\n\tvar consum_store\t\t=getLabel(\"eOT.ConsumptionStore.Label\",\"OT\");\n\tvar no_of_units\t\t=getLabel(\"eOT.ActualUnits.Label\",\"OT\");\n\nif(st_interface_flag ==\"Y\")\n\t{\n\tvar fields = new Array(formObj.operation,formObj.implant_desc,formObj.conns_store,formObj.quantity);\n\tvar names = new Array(operation,implant,consum_store,no_of_units);\n\t}else\n\t{\n\tvar fields = new Array(formObj.operation,formObj.implant_desc,formObj.quantity);\n\tvar names = new Array(operation,implant,no_of_units);\n\t}\n\tvar messageFrame = parent.parent.parent.parent.messageFrame;\n\tif(checkFields( fields, names, messageFrame))\n\t\treturn true;\n}\nfunction chkEmpty_eq(){\n\tvar formObj = document.ImplantsRecordForm;\n\tvar operation\t\t\t=getLabel(\"Common.operation.label\",\"Common\");\n\tvar equipment\t\t\t=getLabel(\"Common.equipment.label\",\"Common\");\n\tvar no_of_units\t\t=getLabel(\"eOT.ActualUnits.Label\",\"OT\");\n\tvar desiredDate = getLabel(\"eOT.DateTime.label\",\"OT\");//047546\n\tvar customer_id = document.forms[0].customer_id.value;\n\t\tvar fields = new Array(formObj.operation_eq, formObj.equip_desc, formObj.quantity_eq, formObj.desiredDate);\n\t\tvar names = new Array(operation, equipment, no_of_units, desiredDate);\n\tvar messageFrame = parent.parent.parent.parent.messageFrame;\n\tif(checkFieldsOt(fields, names, messageFrame))\n\t\treturn true;\n}\n\nfunction chkEmpty_ic(){\n\tvar formObj = document.ImplantsRecordForm;\n\tvar operation\t\t\t=getLabel(\"Common.operation.label\",\"Common\");\n\tvar instrument\t\t\t=getLabel(\"Common.Instrument.label\",\"Common\");\n\tvar no_of_units\t\t=getLabel(\"eOT.ActualUnits.Label\",\"OT\");\n\n\tvar fields = new Array(formObj.operation_ic,formObj.instr_desc,formObj.quantity_ic);\n\tvar names = new Array(operation,instrument,no_of_units);\n\tvar messageFrame = parent.parent.parent.parent.messageFrame;\n\tif(checkFields( fields, names, messageFrame))\n\t\treturn true;\n}\nfunction chkEmpty_cp(){\n\tvar formObj = document.ImplantsRecordForm;\n\t\tvar operation\t\t\t=getLabel(\"Common.operation.label\",\"Common\");\n\t\tvar package_cp\t\t\t=getLabel(\"Common.Package.label\",\"Common\");\n\t\tvar no_of_units\t\t=getLabel(\"eOT.ActualUnits.Label\",\"OT\");\n\n\tvar fields = new Array(formObj.operation_cp,formObj.package_desc,formObj.quantity_cp);\n\tvar names = new Array(operation,package_cp,no_of_units);\n\tvar messageFrame = parent.parent.parent.messageFrame;\n\tif(checkFields( fields, names, messageFrame))\n\t\treturn true;\n}\n\n\nfunction removeRow(){\nvar formObj = document.ImplantsRecordForm;\nvar params = formObj.params.value;\nvar rows=parent.parent.parent.ObjectCollect.implants_rows;\nvar recId = document.forms[0].recId.value;\nvar mode = document.forms[0].mode.value;\n\n\n\nif(rows.length>0 && mode==\'U\'){        \n  for(var  jj=rows.length; jj>-1; jj--){\n\t if(rows[jj]!=null){\n\t\tif(rows[jj].recId==recId){\n\n\t\t\tDeleteKey(rows[jj].key+rows[jj].key_line);\n\t\t\t if( (rows[jj].db_mode==\'L\' || rows[jj].db_mode==\'U\') && (rows[jj].order==\'1\' ) )\n\t\t\t{\n\t\t\t\trows[jj].db_mode=\'D\';\n\t\t\t}\n\t\t\t else\n\t\t\t{\n\t\t\t\t\n\t\t\t  delete rows[jj];\n\t\t\t}\n\t\t\t\t\n\t\t\t   break;\n\t\t}\n\t }else\n\tcontinue;\n }//end for-Lo op\n resetFields();\n parent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n}else\n   resetFields();\n}\nfunction removeRow_cp(){\nvar formObj = document.forms[0];\nvar params = formObj.params.value;\nvar rows=parent.parent.parent.ObjectCollect.packs_rows;\nvar recId = document.forms[0].recId.value;\nvar mode = document.forms[0].mode.value;\nif(rows.length>0 && mode==\'U\'){ \n\n  for(var  jj=rows.length; jj>-1; jj-- ){\n\t if(rows[jj]!=null){\n\t\tif(rows[jj].recId==recId){\n\t\t\t\n\t\t\tDeleteKey(rows[jj].key+rows[jj].key_line);\n\t\t\t if( (rows[jj].db_mode==\'L\' || rows[jj].db_mode==\'U\') && (rows[jj].order==\'1\' ) )\n\t\t\t{\n\t\t\trows[jj].db_mode=\'D\';\n\t\t\t}\n\t\t\t else\n\t\t\t{\n\t\t\t\t  \n\t\t\tdelete rows[jj];\n\t\t\t}\n\t\t\t   break;\n\t\t}\n\t }else\n\tcontinue;\n }//end for-Loop\n resetFields_cp();\n parent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n}else\n   resetFields_cp();\n}\n\nfunction removeRow_eq(){\nvar formObj = document.ImplantsRecordForm;\nvar params = formObj.params.value;\nvar rows=parent.parent.parent.ObjectCollect.equipment_rows;\nvar recId = document.forms[0].recId.value;\nvar mode = document.forms[0].mode.value;\n\nif(rows.length>0 && mode==\'U\'){        \n  for(var  jj=rows.length; jj>-1; jj--){\n\t if(rows[jj]!=null){\n\t\tif(rows[jj].recId==recId){\n\t\t\tDeleteKey(rows[jj].key+rows[jj].key_line);\n\t\t\t if( (rows[jj].db_mode==\'L\' || rows[jj].db_mode==\'U\') && (rows[jj].order==\'1\' ) )\n\t\t\t rows[jj].db_mode=\'D\';\n\t\t\telse\n\t\t\t  delete rows[jj];\n\t\t\t  break;\t\t   \n\t\t}\n\t }else\n\tcontinue;\n }//end for-Loop\n resetFields_eq();\n parent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n}else\n   resetFields_eq();\n}\n\nfunction removeRow_ic()\n{\nvar formObj = document.ImplantsRecordForm;\nvar params = formObj.params.value;\nvar rows=parent.parent.parent.ObjectCollect.instrument_rows;\nvar recId = document.forms[0].recId.value;\nvar mode = document.forms[0].mode.value;\nif(rows.length>0 && mode==\'U\' )\n{\n  for(var  jj=rows.length; jj>-1; jj--)\n  {\n\t if(rows[jj]!=null)\n\t {\n\t\tif(rows[jj].recId==recId)\n\t\t{\n\t\t\tDeleteKey(rows[jj].key+rows[jj].key_line);\n\t\t\tif( (rows[jj].db_mode==\'L\' || rows[jj].db_mode==\'U\') && (rows[jj].order==\'1\' ) )\n\t\t\t\trows[jj].db_mode=\'D\';\n\t\t\t else\n\t\t\t  delete rows[jj];\n\t\t\t   break;\n\t\t}\n\t }else\n\tcontinue;\n }//end for-Loop\n resetFields_ic();\n parent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n}else\n   resetFields_ic();\n}\n\n\nfunction updateRow(){\n\n\tvar formObj\t\t\t= document.ImplantsRecordForm;\n\tvar rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;\n\tvar rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;\n\tvar rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;\n\tvar rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;\n\tvar st_interface_flag=formObj.st_interface_flag.value;\n\tvar fromval=formObj.fromval.value;\n\n\tvar params\t\t\t= formObj.params.value;\n\tvar\timplant_code\t= formObj.implant_code.value;\n\tvar\timplant_desc\t= formObj.implant_desc.value;\n\tvar\tquantity\t\t= formObj.quantity.value;\n\tif(st_interface_flag==\"N\")\n\t{\n\tvar mfr\t\t\t\t= formObj.manufacturer.value;\n\tvar batch\t\t\t= formObj.batch.value;\n\t}\n\tvar\tremarks\t\t\t= formObj.remarks.value;\n\tvar mode\t\t\t= formObj.mode.value;\n\tvar recId\t\t\t= formObj.recId.value;\n    var\toper_code\t\t= formObj.oper_code.value;                          \n\tvar oper_desc\t\t= formObj.operation.options[formObj.operation.selectedIndex].text;\n\tvar line_no\t\t\t= formObj.oper_line_no.value;\n\tvar rows\t\t\t= parent.parent.parent.ObjectCollect.implants_rows;\n\tvar bill_flag       = formObj.bill_flag.value;\n\t\n\n\t\tif(rows.length>0 && mode==\'U\'){        \n\t\t\tfor(var jj=0;jj<rows.length;jj++){\n\t\t\t\tif(rows[jj]!=null) {\n\t\t\t\t\tif(rows[jj].recId==recId){\n\t\t\t\t\t\tvar new_bill_str = \"\";\n\t\t\t\t\t\tvar new_panel_str = \"\";\n\t\t\t\t\t\tif(mode==\"U\" && bill_flag==\"true\"){\n\n\t\t\t\t\t\t\tif(st_interface_flag==\"N\" && fromval==\"prosimplants\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar result = updateBillingDetailsValidation(rows[jj].key,rows[jj].key_line,quantity,implant_code,\"I\");\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar result_arr = result.split(\"OTMS_SEP\");\n\t\t\t\t\t\t\tnew_bill_str = result_arr[0];\n\t\t\t\t\t\t\tnew_panel_str = result_arr[1];\n\t\t\t\t\t\t\t\n\t\t\t}else\n\t\t{\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar retVal = Callbilling_ST(formObj.quantity.value,formObj.req_store_code.value,formObj.patient_id.value,formObj.encounter_id.value,formObj.patient_class.value,formObj.implant_code.value);\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tnew_bill_str = retVal;\n\t\t}\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\trows[jj].quantity=quantity;\n\n\t\t\t\t\t\tif(st_interface_flag==\"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\trows[jj].reserved_qty=formObj.Reservepicklist.value;\n\t\t\t            row";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="s[jj].requested_qty=formObj.Requestpicklist.value;\n\t\t\t            rows[jj].req_store_code=formObj.req_store_code.value;\n\t\t\t\t\t\trows[jj].Store_desc=formObj.conns_store.value;\n\t\t\t            rows[jj].Stockavail=formObj.Stockavail.value;\n\t\t\t\t\t\tif(formObj.Stockavail.value ==\"\" || formObj.Stockavail.value ==\"0\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\talert(getMessage(\"PRC-OT0054\",\"OT\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t}\n\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(st_interface_flag==\"N\")\n\t                    {\n\t\t\t\t\t\trows[jj].manufacturer=mfr;\n\t\t\t\t\t\trows[jj].batch=batch;\n\t\t\t\t\t\t}\n\t\t\t\t\t\trows[jj].remarks=remarks;\n\t\t\t            if(rows[jj].db_mode==\'L\' && rows[jj].order==\'1\'){\n\t\t\t\t\t\t\trows[jj].db_mode=\'U\';\n\t\t\t\t\t\t}else if(rows[jj].db_mode==\'L\' && rows[jj].order==\'2\'){\n\t\t\t\t\t\t\trows[jj].db_mode=\'I\';\n\t\t\t\t\t\t}else if(rows[jj].db_mode==\'L\' || rows[jj].db_mode==\"I\" && rows[jj].order==\'3\'){\n\t\t\t\t\t\t\trows[jj].oper_code=oper_code;\n\t\t\t\t\t\t\trows[jj].oper_desc=oper_desc;\n\t\t\t\t\t\t\trows[jj].oper_line_no=line_no;\n\t\t\t\t\t\t\trows[jj].db_mode=\'I\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(bill_flag==\"true\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tif(st_interface_flag==\"N\" && fromval==\"prosimplants\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\trows[jj].panel_str = new_panel_str;\n\t\t\t\t\t\trows[jj].bill_str = new_bill_str;\n\t\t\t\t\t\t}else\n\t\t\t\t\t\t{\n\t\t\t\t\t\trows[jj].bill_str = new_bill_str;\n\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t         }else  \n\t\t\tcontinue;\n\t\t }\n      resetFields();\n parent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n }\n}\n\nfunction updateRow_cp(){\n\tvar formObj = document.ImplantsRecordForm;\n\tvar params = formObj.params.value;\n\tvar\tpackage_code=formObj.package_code.value;\n\tvar\tpackage_desc=formObj.package_desc.value;\n\tvar\tquantity = formObj.quantity_cp.value;\n\tvar\tremarks = formObj.remarks_cp.value;\n\tvar mode =formObj.mode.value;\n\tvar recId = formObj.recId.value;\n\tvar bill_flag       = formObj.bill_flag.value;\n\tvar rows=parent.parent.parent.ObjectCollect.packs_rows;\n\t\tif(rows.length>0 && mode==\'U\'){        \n\t\t\tfor(var jj=0;jj<rows.length;jj++){\n\t\t\t\tif(rows[jj]!=null) {\n\n\t\t\t\t\tif(rows[jj].recId==recId){\n\t\t\t\t\t\tvar new_bill_str = \"\";\n\t\t\t\t\t\tvar new_panel_str = \"\";\n\t\t\t\t\t\tif(mode==\"U\" && bill_flag==\"true\"){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar result = updateBillingDetailsValidation(rows[jj].key,rows[jj].key_line,quantity,package_code,\"C\");\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar result_arr = result.split(\"OTMS_SEP\");\n\t\t\t\t\t\t\tnew_bill_str = result_arr[0];\n\t\t\t\t\t\t\tnew_panel_str = result_arr[1];\n\t\t\t\t\t\t\n\t\t\t\t\t\t}\t\n\t\t\t            rows[jj].quantity=quantity;\n\t\t\t\t\t\trows[jj].remarks=remarks;\n\t\t\t            if(rows[jj].db_mode==\'L\' && rows[jj].order==\'1\'){\n\t\t\t\t\t\t\trows[jj].db_mode=\'U\';\n\t\t\t\t\t\t}else if(rows[jj].db_mode==\'L\' && rows[jj].order==\'2\'){\n\t\t\t\t\t\t\trows[jj].db_mode=\'I\';\n\t\t\t\t\t\t}else if(rows[jj].db_mode==\'L\' && rows[jj].order==\'3\'){\n\t\t\t\t\t\t\trows[jj].db_mode=\'I\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\tif(bill_flag==\"true\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\trows[jj].panel_str = new_panel_str;\n\t\t\t\t\t\trows[jj].bill_str_conspack = new_bill_str;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t         }else  \n\t\t\tcontinue;\n\t\t }\n\t\t\tresetFields_cp();\n\n parent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n }\n}\n\nfunction updateRow_eq(){\n\tvar formObj = document.ImplantsRecordForm;\n\tvar params = formObj.params.value;\n\tvar\tequip_code=formObj.equip_code.value;\n\tvar\tequip_desc=formObj.equip_desc.value;\n\tvar\tequip_id = formObj.equip_id.value;\n\tvar\tquantity = formObj.quantity_eq.value;\n\tvar\tremarks = formObj.remarks_eq.value;\n\tvar mode =formObj.mode.value;\n\tvar bill_flag       = formObj.bill_flag.value;\n\tvar recId = formObj.recId.value;\n\tvar desiredDate = \'\';\n\tif(formObj.desiredDate != null)\n\t\tdesiredDate = formObj.desiredDate.value;\n\n\tvar rows=parent.parent.parent.ObjectCollect.equipment_rows;\n\n\tif(rows.length>0 && mode==\'U\')\n\t{\n\t\tfor(var jj=0;jj<rows.length;jj++)\n\t\t{\n\t\t\tif(rows[jj] != null)\n\t\t\t{\n\t\t\t\tif(rows[jj].recId == recId)\n\t\t\t\t{\n\t\t\t\t\t\t\tvar new_bill_str = \"\";\n\t\t\t\t\t\tvar new_panel_str = \"\";\n\t\t\t\t\tif(mode==\"U\" && bill_flag==\"true\")\n\t\t\t\t\t{\n\t\t\t\t\t\t\tvar result = updateBillingDetailsValidation(rows[jj].key,rows[jj].key_line,quantity,equip_code,\"E\");\n\t\t\t\t\t\t\tvar result_arr = result.split(\"OTMS_SEP\");\n\t\t\t\t\t\t\tnew_bill_str = result_arr[0];\n\t\t\t\t\t\t\tnew_panel_str = result_arr[1];\n\t\t\t\t\t\t}\n\t\t\t            rows[jj].equip_id=equip_id;\n\t\t\t\t\t\trows[jj].remarks=remarks;\n\t\t\t\t\t\trows[jj].quantity=quantity;\n\t\t\t\t\trows[jj].desiredDate=desiredDate;\n\t\t\t\t\tif(rows[jj].db_mode==\'L\' && rows[jj].order==\'1\')\n\t\t\t\t\t\t\trows[jj].db_mode=\'U\';\n\t\t\t\t\telse if(rows[jj].db_mode==\'L\' && rows[jj].order==\'2\')\n\t\t\t\t\t\t\trows[jj].db_mode=\'I\';\n\t\t\t\t\telse if(rows[jj].db_mode==\'L\' && rows[jj].order==\'3\')\n\t\t\t\t\t\t\trows[jj].db_mode=\'I\';\n\t\t\t\t\t\t\tif(bill_flag==\"true\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\trows[jj].panel_str = new_panel_str;\n\t\t\t\t\t\trows[jj].bill_str = new_bill_str;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t\t}\n\t\t\telse  \n\t\t\tcontinue;\n\t\t }\n      resetFields_eq();\n\t parent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n     parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t}\n}\n\nfunction updateRow_ic(){\n\tvar formObj = document.ImplantsRecordForm;\n\tvar params = formObj.params.value;\n\tvar\tinstr_code=formObj.instr_code.value;\n\tvar\tinstr_desc=formObj.instr_desc.value;\n\tvar\ttray_no = formObj.tray_no.value;\n\tvar\tquantity = formObj.quantity_ic.value;\n\tvar\tremarks = formObj.remarks_ic.value;\n\tvar oper_line_no = formObj.oper_line_no.value;\n\tvar mode =formObj.mode.value;\n\tvar recId = formObj.recId.value;\n\tvar bill_flag       = formObj.bill_flag.value;\n\tvar rows=parent.parent.parent.ObjectCollect.instrument_rows;\n\t\tif(rows.length>0 && mode==\'U\'){        \n\t\t\tfor(var jj=0;jj<rows.length;jj++){\n\t\t\t\tif(rows[jj]!=null) {\n\t\t\t\t\tif(rows[jj].recId==recId){\n\t\t\t\t\t\t\tvar new_bill_str = \"\";\n\t\t\t\t\t\tvar new_panel_str = \"\";\n\t\t\t\t\t\tif(mode==\"U\" && bill_flag==\"true\"){\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar result = updateBillingDetailsValidation(rows[jj].key,rows[jj].key_line,quantity,instr_code,\"S\");\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar result_arr = result.split(\"OTMS_SEP\");\n\t\t\t\t\t\t\tnew_bill_str = result_arr[0];\n\t\t\t\t\t\t\tnew_panel_str = result_arr[1];\n\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t\trows[jj].tray_no=tray_no;\n\t\t\t\t\t\trows[jj].remarks=remarks;\n\t\t\t\t\t\trows[jj].quantity=quantity;\n\t\t\t\t\t\tif(rows[jj].db_mode==\'L\' && rows[jj].order==\'1\'){\n\t\t\t\t\t\t\trows[jj].db_mode=\'U\';\n\t\t\t\t\t\t}else if(rows[jj].db_mode==\'L\' && (rows[jj].order==\'2\' || rows[jj].order==\'3\' ) ){\n\t\t\t\t\t\t\trows[jj].db_mode=\'I\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(bill_flag==\"true\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\n\t\t\t\t\t\trows[jj].panel_str = new_panel_str;\n\t\t\t\t\t\trows[jj].bill_str = new_bill_str;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n      \t\t\t\t}\n\t\t         }else  \n\t\t\tcontinue;\n\t\t }\n      resetFields_ic();\n\t parent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n     parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n}\n}\n\nfunction splitString(strVal){\n    var arr = strVal.split(\'::\');\n\tvar formObj = document.ImplantsRecordForm;\n\tvar st_interface_flag=formObj.st_interface_flag.value\n\tformObj.oper_code.value=arr[0];\n\tformObj.operation.value=arr[1];\n\tformObj.oper_line_no.value = arr[2];\n\tformObj.implant_code.value=arr[3];\n\tformObj.implant_desc.value=arr[4];\n\tformObj.quantity.value=arr[5];\n\tif(st_interface_flag==\"N\")\n\t{\n\tformObj.manufacturer.value=arr[6];\n\tformObj.batch.value=arr[7];\n\t}\n\tformObj.remarks.value=arr[8];\n\tformObj.recId.value = arr[9];\n\tformObj.mode.value = arr[10];\n\tif(st_interface_flag ==\"Y\")\n\t{\n\tformObj.Reservepicklist.value = arr[12];\n\tformObj.Requestpicklist.value = arr[13];\n\tformObj.req_store_code.value = arr[14];\n\tformObj.Stockavail.value = arr[15];\n\tformObj.conns_store.value = arr[16];\n\tformObj.Stockavail.disabled=true;\n\t}\n\n\tformObj.operation.disabled=true;\n\tformObj.btn_cancel.disabled=false;\n\tformObj.ImplantLookUp.disabled=true;\n\tformObj.implant_desc.disabled=true;\n\t\n}\n\nfunction splitString_cp(strVal){\n    var arr = strVal.split(\'::\');\n\tvar formObj = document.ImplantsRecordForm;\n\tformObj.oper_code.value=arr[0];\n\tformObj.operation_cp.value=arr[1];\n\tformObj.oper_line_no.value = arr[2];\n\tformObj.package_code.value=arr[3];\n\tformObj.package_desc.value=arr[4];\n\tformObj.remarks_cp.value=arr[5];\n\tformObj.quantity_cp.value=arr[6];\n\tformObj.recId.value = arr[7];\n\tformObj.mode.value = arr[8];\n\tformObj.operation_cp.disabled=true;\n\tformObj.PackageLookUp.disabled=true;\n\tformObj.package_desc.disabled=true;\n\t\n}\nfunction splitString_eq(strVal){\n    var arr = strVal.split(\'::\');\n\tvar equip_code_id=(arr[6]==null ||arr[6]==\"\" )?arr[3]:arr[6];//Added by MuthuN against 39535 on 13/05/2013\n\tvar formObj = document.forms[0];\n\tvar customer_id =formObj.customer_id.value;\n\tformObj.oper_code.value=arr[0];\n\tformObj.operation_eq.value=arr[1];\n\tformObj.oper_line_no.value = arr[2];\n\tformObj.equip_code.value=arr[3];\n\tformObj.equip_desc.value=arr[4];\n\tformObj.remarks_eq.value=arr[5];\n\tformObj.equip_id.value=equip_code_id;//Added by MuthuN against 39535 on 13/05/2013\n\tformObj.recId.value = arr[7];\n\tformObj.mode.value = arr[8];\n\tformObj.quantity_eq.value = arr[9];\n\tif(customer_id == \"RTN\")\n\tformObj.st_location.value = arr[10];\n\tformObj.operation_eq.disabled=true;\n\tformObj.EquipmentLookUp.disabled=true;\n\tformObj.equip_desc.disabled=true;\n\tif(customer_id == \"RTN\")\n\t{\n\tif(formObj.st_location.value == \"undefined\")\n\t\t\tformObj.st_location.value=\'\';\n\t\telse\n\t\t{\n\t\t\tformObj.st_location.value = arr[10];\n\t\t\tformObj.st_location.disabled=true;\n\t\t}\n\t\tif(formObj.desiredDate.value == \"undefined\")\n\t\t\tformObj.desiredDate.value=\'\';\n\t\telse\n\t\t\tformObj.desiredDate.value = arr[11];\n\t}\n\telse\n\t{\n\t\tif(formObj.desiredDate.value == \"undefined\")\n\t\t\tformObj.desiredDate.value=\'\';\n\t\telse\n\t\t\tformObj.desiredDate.value = arr[10];\n\t}\n\t\tformObj.equip_id.value=equip_code_id;//Added by MuthuN against 39535 on 13/05/2013\n\t\tformObj.equip_id.disabled=true;//Added by Rameez for equipment issue on 02/05/2013\n}\n\nfunction splitString_ic(strVal){\n    var arr = strVal.split(\'::\');\n\tvar formObj = document.forms[0];\n\tformObj.oper_code.value=arr[0];\n\tformObj.operation_ic.value=arr[1];\n\tformObj.oper_line_no.value = arr[2];\n\tformObj.instr_code.value=arr[3];\n\tformObj.instr_desc.value=arr[4];\n\tformObj.remarks_ic.value=arr[5];\n\tformObj.tray_no.value=arr[6];\n\tformObj.recId.value = arr[7];\n\tformObj.mode.value = arr[8];\n\tformObj.quantity_ic.value = arr[9];\n\tformObj.operation_ic.disabled=true;\n\tformObj.InstrumentLookUp.disabled=true;\n\tformObj.instr_desc.disabled=true;\n}\nfunction resetFields(){\n\tvar formObj = document.ImplantsRecordForm;\n\tvar st_interface_flag=formObj.st_interface_flag.value;\n\tformObj.implant_desc.value=\'\';\n\tformObj.quantity.value=\'\';\n\tif(st_interface_flag==\"N\")\n\t{\n\tformObj.manufacturer.value=\'\';\n\tformObj.batch.value=\'\';\n\t}else\n\t{\n\tformObj.Reservepicklist.value=\'\';\n\tformObj.Requestpicklist.value=\'\';\n\tformObj.conns";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block9_2 ="_store.value=\'\';\n\tformObj.Stockavail.value=\"\";\n\t}\n\tformObj.mode.value=\'I\';\n\t// DhanasekarV modified for IN023814   - Remarks value is unchanged  remarks =\'\'\n\tformObj.remarks.value=\'\';\n\tformObj.operation.disabled=false;\n    formObj.operation.focus();\n\tformObj.ImplantLookUp.disabled=false;\n\tformObj.implant_desc.disabled=false;\n\tformObj.btn_cancel.disabled=false\n\n}\nfunction resetFields_eq(){\n\tvar formObj = document.forms[0];\n\tvar customer_id = document.forms[0].customer_id.value;\n\tformObj.equip_code.value=\'\';\n\tformObj.equip_desc.value=\'\';\n\tformObj.oper_code.value=\'\';\n\tformObj.equip_id.value=\'\';\n\t\tformObj.desiredDate.value=\'\';\n\tif (customer_id ==\"RTN\")\n\t\tformObj.st_location.value=\'\';\n\tformObj.mode.value=\'I\';\n\t// DhanasekarV modified for IN023814   - Remarks value is unchanged  remarks =\'\'\n\tformObj.remarks_eq.value=\'\';\n\tformObj.quantity_eq.value=\'\';\t\n\tformObj.operation_eq.disabled=false;\n\tformObj.EquipmentLookUp.disabled=false;\n\tformObj.equip_desc.disabled=false;\n    formObj.operation_eq.focus();\n}\n\nfunction resetFields_ic(){\n\tvar formObj = document.forms[0];\n\tformObj.instr_code.value=\'\';\n\tformObj.instr_desc.value=\'\';\n\tformObj.oper_line_no.value=\'\';\n\tformObj.oper_code.value=\'\';\n\tformObj.tray_no.value=\'\';\n\tformObj.remarks_ic.value=\'\';\n\tformObj.mode.value=\'I\';\n\tformObj.quantity_ic.value=\'\';\n\tformObj.operation_ic.disabled=false;\n\tformObj.InstrumentLookUp.disabled=false;\n\tformObj.instr_desc.disabled=false;\n    formObj.operation_ic.focus();\n\t\t\n}\nfunction resetFields_cp(){\n\tvar formObj = document.forms[0];\n\tformObj.package_code.value=\'\';\n\tformObj.package_desc.value=\'\';\n\tformObj.oper_code.value=\'\';\n\tformObj.oper_line_no.value=\'\';\n\tformObj.quantity_cp.value=\'\';\n\tformObj.remarks_cp.value=\'\';\n\tformObj.mode.value=\'I\';\n\tformObj.operation_cp.disabled=false;\n\tformObj.PackageLookUp.disabled=false;\n\tformObj.package_desc.disabled=false;\n    formObj.operation_cp.focus();\n\t\n}\nfunction setOperLineNumber(line_no){\n   var frmObj = parent.parent.ObjectCollect;\n   if(frmObj.line_no==0){\n\t\tfrmObj.line_no = parseInt(line_no,10);\n   }\n}\n\nfunction getOperLineNumber(){\n   frmObj = parent.parent.ObjectCollect;\n   var line_no= frmObj.line_no + 1;\n   parent.parent.ObjectCollect.line_no = line_no;\n   return line_no;\n}\n\nfunction loadCodes()\n{\n\tvar formObj = document.ImplantsRecordForm;\n\tparent.ResultsFrame.location.reload();\n}\n\nfunction assignCodes(obj){\n\tvar formObj=document.ImplantsRecordForm;\n\tvar codes =  obj.value;\n    var arr = codes.split(\"##\");\n\tformObj.oper_code.value=arr[0];\n\tformObj.oper_line_no.value=arr[1];\n}\n\nfunction assignCodes_eq(obj){\n\tvar formObj=document.ImplantsRecordForm;\n\tvar codes =  obj.value;\n    var arr = codes.split(\"##\");\n\tformObj.oper_code.value=arr[0];\n\tformObj.oper_line_no.value=arr[1];\n}\n\nfunction assignCodes_ic(obj){\n\tvar formObj = document.ImplantsRecordForm;\n\tvar codes =  obj.value;\n    var arr = codes.split(\"##\");\n\tformObj.oper_code.value=arr[0];\n\tformObj.oper_line_no.value=arr[1];\n}\nfunction assignCodes_cp(obj){\n\tvar formObj = document.ImplantsRecordForm;\n\tvar codes =  obj.value;\n    var arr = codes.split(\"##\");\n\tformObj.oper_code.value=arr[0];\n\tformObj.oper_line_no.value=arr[1];\n}\nfunction localTrimString(sInString) {\n  return sInString.replace(/^\\s+|\\s+$/g,\"\");\n}\n\nfunction addRow_eq()\n{\n  var objrow = newRow_eq();\n  var customer_id = document.forms[0].customer_id.value;\n  var msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n  var rows=parent.parent.parent.ObjectCollect.equipment_rows;\n  var formObj = document.ImplantsRecordForm;\n  var rec_implants_in_nurs_notes_yn=formObj.rec_implants_in_nurs_notes_yn.value;\n  var rec_equp_in_nurs_notes_yn=formObj.rec_equp_in_nurs_notes_yn.value;\n  var rec_instr_in_nurs_notes_yn=formObj.rec_instr_in_nurs_notes_yn.value;\n  var rec_packs_in_nurs_notes_yn=formObj.rec_packs_in_nurs_notes_yn.value;\n  var st_interface_flag=formObj.st_interface_flag.value;\n  var params = formObj.params.value;\n  var mode =formObj.mode.value;\n  \n  var obj = formObj.operation_eq;\n  var chkDateRangeValidityFlag = true;\n  var bill_flag=document.forms[0].bill_flag.value;\n\tchkDateRangeValidityFlag = chkDateRangeValidity(formObj.desiredDate.value);\n  var key = formObj.oper_num.value+\"@\"+formObj.oper_code.value+\"@E\"+\"@\"+formObj.equip_code.value;\n\n\n\tif(chkEmpty_eq())\n\t{\n\t\tif(chkDateRangeValidityFlag)\n\t\t{\n\t\t\tif(mode==\'I\')\n\t\t\t{\n\t\t\t\tif(alreadyExist_eq())\n\t\t\t\t{\n\t\tif(bill_flag==\"true\")  // added by sathish to disable Billing part\n\t\t{\n\t\tvar retVal =callOrderLineCreation_eq(formObj.quantity_eq.value);\n\t\tretVal=trimString(retVal);\n\t\tvar arr = retVal.split(\"@@\");\n\t\t\t\t\t\t//if(arr[0]==\"BL0639\")\n\t\t\t\t\t\tif(arr[0]==\'BL0639\' || (~(arr[0]).indexOf(\'BL0639\')!=0))\t\n\t\t\t\t\t\t{\n\t\t\talert(getMessage(\"BL0639\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif(localTrimString(arr[2])!=\'\')\n\t\t\t{\n\t\t\tvar err_pat=localTrimString(arr[2]);\n\t\t\talert(err_pat);\n\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\t\tobjrow.oper_code=formObj.oper_code.value;\n\t\t\tobjrow.oper_desc=formObj.operation_eq.options[obj.selectedIndex].title;//MMS-QH-CRF-0199\n\t\t\tobjrow.equip_code=formObj.equip_code.value;\n\t\t\tobjrow.equip_desc=formObj.equip_desc.value;\n\t\t\tobjrow.oper_line_no = formObj.oper_line_no.value;\n\t\t\t\t\t\tobjrow.desiredDate = formObj.desiredDate.value;\n\t\t\tif (customer_id == \"RTN\")\n\t\t\t\tobjrow.st_location = formObj.st_location.value;\n\t\t\tobjrow.equip_id = formObj.equip_id.value;\t\t\t\n\t\t\tobjrow.remarks = formObj.remarks_eq.value;\n\t\t\tobjrow.quantity = formObj.quantity_eq.value;\t\t\n\t\t\tobjrow.recId = getRecId_eq();\n\t\t\tobjrow.db_mode=\"I\";\n\t\t\tif(bill_flag==\"true\")\n\t\t    {\n\t\t\tvar arr = retVal.split(\"@@\");\n\t\t\tobjrow.panel_str = arr[0];\n\t\t\tobjrow.bill_str = arr[1];\n\t\t\t}\n\t\t\tobjrow.key=key;\n\t\t\tobjrow.key_line=\"\";\n\t\t\trows.push(objrow);\n\t\t\tresetFields_eq();\n\n\t\t\t//Commented by AnithaJ on 22/11/2010 for scf-5515\n\t\t\t//params=params+\"&rec_implants_in_nurs_notes_yn=\"+rec_implants_in_nurs_notes_yn+\"&rec_instr_in_nurs_notes_yn=\"+rec_instr_in_nurs_notes_yn+\"&rec_packs_in_nurs_notes_yn=\"+rec_packs_in_nurs_notes_yn+\"&rec_equp_in_nurs_notes_yn=\"+rec_equp_in_nurs_notes_yn+\"&st_interface_flag=\"+st_interface_flag;\n\n\t\t\tparent.ResultsFrame.location.href=\'../../eOT/jsp/SurgicalAccessoriesResult.jsp?\'+params;\n\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t\t\tresetFields_eq();\n\t}\n\t\t\t}\n\t\t\telse\n\t  updateRow_eq();\t  \n  }\n}\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onLoad=\"loadCodes();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name = \'ImplantsRecordForm\'>\n";
    private final static byte[]  _wl_block9_2Bytes = _getBytes( _wl_block9_2 );

    private final static java.lang.String  _wl_block10 ="\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n<input type=\'hidden\' name=\'tab\' id=\'tab\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n<input type=\'hidden\' name=\'booking_num\' id=\'booking_num\' value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\' align=\"center\">\n<tr>\n\n\t  <td class=\"label\" width=\'25%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </td>\n\t  <td class=\"fields\" width=\'25%\'>\n\t    <select name=\"accesstype\" id=\"accesstype\"  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" disabled >\n\t\t\t <option value=\'PI\'  Selected>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t</option>\n\t\t\t<option value=\'CP\' >\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t</option>\n\t\t\t<option value=\'EQ\' >\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t</option>\n\t\t\t<option value=\'IC\' >\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t</option>\n\t    </select>\n    </td>\n\n\n\t  <td class=\"label\" width=\'25%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" </td>\n\t  <td class=\"fields\" width=\'25%\'>\n\t\t  <input type=\'hidden\' name=\'implant_code\' id=\'implant_code\' > \n\t\t  <input type=\'text\' name=\'implant_desc\' id=\'implant_desc\' onBlur=\"if(this.value!=\'\')searchProsthesis(implant_code,implant_desc);else{}\"> \n\t\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'ImplantLookUp\' id=\'ImplantLookUp\' onClick=\'searchProsthesis(implant_code,implant_desc);\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t  </td>\n </tr>\n\n <tr>\n \t <td class=\"label\" width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" </td>\n     <td class=\"fields\" width=\'25%\'>\n\t\t\t<select class=\"my_dropdown\" id=\"my_dropdown\" name=\"operation\" id=\"operation\"  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" ><!--MMS-QH-CRF-0199-->\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' title=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'> ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="  </option><!--MMS-QH-CRF-0199-->\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t</select>\n\t\t\t <img src=\'../../eCommon/images/mandatory.gif\'></img>\n    </td>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\t  <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n\t  <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'conns_store\' id=\'conns_store\' onblur=\"if(this.value!=\'\')searchStore(this,conns_store,document.forms[0].operation);else{}\"> <input type=\'hidden\' name=\'req_store_code\' id=\'req_store_code\' value=\'\'><input type=\'button\' class=\'button\' value=\'?\' name=\'Cons_store_LookUp\' id=\'Cons_store_LookUp\' onClick=\'searchStore(this,conns_store,document.forms[0].operation);\' ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" ><img src=\'../../eCommon/images/mandatory.gif\'></img> </td>\t\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n </tr>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n<tr>\n\n\t <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" </td>\n     <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'manufacturer\' id=\'manufacturer\' maxlength=\'30\' size=\'20\' ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" ></td>\n\n\t <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" </td>\n     <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'batch\' id=\'batch\' maxlength=\'30\' size=\'20\'  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" ></td>\n\n</tr>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\n<tr>\n\n\t <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" </td>\n     <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'Reservepicklist\' id=\'Reservepicklist\' maxlength=\'6\' size=\'6\'  disabled ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" </td>\n     <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'Requestpicklist\' id=\'Requestpicklist\' maxlength=\'6\' size=\'6\'  disabled ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" ></td>\n\n</tr>\n<input type=\'hidden\' name=\'sale_document_no\' id=\'sale_document_no\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=\'hidden\' name=\'sale_document_type\' id=\'sale_document_type\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\n<tr>\n\t \n\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n \n\t <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" </td>\n     <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'Stockavail\' id=\'Stockavail\' maxlength=\'6\' size=\'6\'  value=\"\" ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" ></td>\n\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t <td class=\"fields\" width=\'25%\'>\n\t ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="<input type=\'text\' name=\'quantity\' id=\'quantity\' maxlength=\'3\' size=\'2\' onkeypress=\"return checkForSpecCharsforID(event);\"  onBlur=\"ChkNumber(this);\"  value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =">\n\t ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="<input type=\'text\' name=\'quantity\' id=\'quantity\' maxlength=\'3\' size=\'2\' onkeypress=\"return checkForSpecCharsforID(event);\"  onBlur=\"ChkNumber(this);\"  ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="<img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\n\t \n</tr>\n\n\t<td></td>\n\t<td></td>\n\t<td class=\"label\" width=\'25%\'><input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\"\">\n\t\t\t<a  class=\"gridLink\" href=\"javascript:openCheckListRemarksWindow(document.forms[0].remarks);\">\n\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</a></td>\n   \t<td width=\'20%\' class=\"button\">\n\t\t<input type=\'button\' class=\'button\' name = \'select\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' onClick=\'assignCodes(document.forms[0].operation);addRow();\' ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" >\n\t\t<input type=\'button\' name=\"btn_cancel\" id=\"btn_cancel\" class=\'button\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' onClick=\'removeRow();\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" >\n\t</td>\n\n</tr>\n</table>\n\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" disabled>\n\t\t\t <option value=\'PI\'  >\n\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t</option>\n\t\t\t<option value=\'CP\' Selected>\n\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t</option>\n\t    </select>\n    </td>\n\n\t <td class=\"label\" width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" </td>\n     <td class=\"fields\" width=\'25%\'>\n\t\t\t<select class=\"my_dropdown\" id=\"my_dropdown\" name=\"operation_cp\" id=\"operation_cp\"  ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" ><!--MMS-QH-CRF-0199 -->\n\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' title=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\"> ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="  </option><!--MMS-QH-CRF-0199 -->\n\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t</select>\n\t\t\t <img src=\'../../eCommon/images/mandatory.gif\'></img>\n    </td>\n </tr>\n\n <tr>\n \n  \n\t    <td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" </td>\n\t  <td width=\"25%\">\n\t\t  <input type=\'hidden\' name=\'package_code\' id=\'package_code\' > \n\t\t  <input type=\'text\' name=\'package_desc\' id=\'package_desc\' onBlur=\"if(this.value!=\'\')searchPackage(package_code,package_desc);else{}\"> \n\t\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'PackageLookUp\' id=\'PackageLookUp\' onClick=\'searchPackage(package_code,package_desc);\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t  </td>\n\n\t  \t <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</td>\n\t <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'quantity_cp\' id=\'quantity_cp\' maxlength=\'3\' size=\'2\' onBlur=\"ChkNumber(this);\" onkeypress=\"return checkForSpecCharsforID(event);\"  ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t\t\n </tr>\n\n<tr>\n</tr>\n\n\t<td></td>\n\t<td></td>\n\t<td class=\"label\" width=\'25%\'>\n\t<input type=\'hidden\' name=\'remarks_cp\' id=\'remarks_cp\' value=\"\">\n\t<a   class=\"gridLink\" href=\"javascript:openCheckListRemarksWindow_cp(document.forms[0].remarks_cp);\">\n\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</a></td>\n   \t<td width=\'20%\' class=\"button\">\n\t\t<input type=\'button\' name = \'select\' class=\'button\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' onClick=\'assignCodes_cp(document.forms[0].operation_cp);addRow_cp();\' ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' onClick=\'removeRow_cp();\' ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" >\n\t</td>\n\n</tr>\n</table>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\n\n<table border=\'0\' cellpadding=3 cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n\t \t  <td class=\"label\" width=\'25%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" disabled >\n\t\t\t <option value=\'PI\'  >\n\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t</option>\n\t\t\t<option value=\'EQ\' Selected>\n\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t</option>\n\t    </select>\n    </td>\n\n\n<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" </td>\n     <td class=\"fields\" width=\"25%\" >\n\t\t<select class=\"my_dropdown\" id=\"my_dropdown\" name=\"operation_eq\" id=\"operation_eq\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" ><!--MMS-QH-CRF-0199 -->\n\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t<option value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="  </option><!--MMS-QH-CRF-0199 -->\n\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t</select>\n\t <img src=\'../../eCommon/images/mandatory.gif\'></img>\n    </td>\n\n\t\n </tr>\n<tr>\n\n\n\n\t  <td class=\"label\" width=\"25%\" >\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" \n\t  </td>\n\t  <td width=\"25%\" class=\"fields\">\n\t\t  <input type=\'hidden\' name=\'equip_code\' id=\'equip_code\' > \n\t\t  <input type=\'text\' name=\'equip_desc\' id=\'equip_desc\' onBlur=\"if(this.value!=\'\')searchEquipments(equip_code,equip_desc);else{equip_id.value=\'\'}\"> \n\t\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'EquipmentLookUp\' id=\'EquipmentLookUp\' onClick=\'searchEquipments(equip_code,equip_desc);\' ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t  </td>\n\n<!--Added by MuthuN against RUT-CRF-0091 on 13-May-2013 starts here-->\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t<td class=\"label\" width=\"25%\" >\n\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" </td>\n     <td width=\"25%\" class=\"fields\">\n\t\t<input type=\'text\' name=\'st_location\' id=\'st_location\' maxlength=\'20\' size=\'20\' ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" > \n\t\t<input type=\'hidden\' name=\'equip_id\' id=\'equip_id\' value=\"\">\n\t</td>\n\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t <td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="  </td>\n     <td width=\"25%\" class=\"fields\">\n\t\t<input type=\'text\' name=\'equip_id\' id=\'equip_id\' maxlength=\'20\' size=\'20\' ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" > \n\t</td>\n\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n<!--Added by MuthuN against RUT-CRF-0091 ends here-->\n</tr>\n\t\t <td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</td>\n\t <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'quantity_eq\' id=\'quantity_eq\' maxlength=\'3\' size=\'2\' onBlur=\"ChkNumber(this);\" onkeypress=\"return checkForSpecCharsforID(event);\"  ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td class=\"label\" width=\'25%\'>\t\n\t<input type=\'hidden\' name=\'remarks_eq\' id=\'remarks_eq\' value=\"\">\n\t\n\t\t\t<a   class=\"gridLink\" href=\"javascript:openCheckListRemarksWindow_eq(document.forms[0].remarks_eq);\">\n\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</a></td>\n   \t<td width=\'20%\' class=\"button\">\n\n\t\t<input type=\'button\' name = \'select\' class=\'button\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' onClick=\'assignCodes_eq(document.forms[0].operation_eq);addRow_eq();\'  ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="  >\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' onClick=\'removeRow_eq();\' ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =" >\n\n\t</td>\n</tr>\n\t\t<tr>\n\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\t<!-- 047546 -->\n\t\t\t<td class=\'fields\' width=\'25%\'>\n\t\t\t\t<input type=\"text\" name=\"desiredDate\" id=\"desiredDate\" id=\"desiredDate\" size=\"16\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" maxlength=\"16\" onkeypress=\"return checkForSpecCharsforID(event);\" onblur=\"if(this.value!=\'\'){ validateDate(this.value); chkDateRangeValidity(this.value); }\">\n\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onclick=\"return showCalWithTime(\'desiredDate\',\'%d/%m/%Y %H:%M\',\'24\',true,\'desiredDate\');\"><img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t</td>\n\t\t</tr>\n\n</table>\n\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\n\n<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\' align=\'center\'\'>\n<tr>\n\n\t  <td class=\"label\" width=\'25%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t\t\t</option>\n\t\t\t<option value=\'IC\' Selected>\n\t\t\t";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n\t\t\t</option>\n\t    </select>\n    </td>\n\n\n\t<td class=\"label\" width=\"25%\">\n\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =" </td>\n\t<td class=\"fields\" width=\"25%\" >\n\t\t\t<select class=\"my_dropdown\" id=\"my_dropdown\" name=\"operation_ic\" id=\"operation_ic\"  ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t</select>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n    </td>\n\n\t \n </tr>\n<tr>\n\n\t <td class=\"label\" width=\"25%\" >\n\t\t\t";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" </td>\n\t  <td class=\"fields\" width=\"25%\">\n\t\t  <input type=\'hidden\' name=\'instr_code\' id=\'instr_code\' > \n\t\t  <input type=\'text\' name=\'instr_desc\' id=\'instr_desc\' onBlur=\"if(this.value!=\'\')searchInstrument(instr_code,instr_desc);else{}\"> \n\t\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'InstrumentLookUp\' id=\'InstrumentLookUp\' onClick=\'searchInstrument(instr_code,instr_desc);\' ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t  </td>\n\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t <td class=\"label\" width=\"25%\" >\n\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 =" </td>\n     <td class=\"fields\" width=\"25%\">\n     \t\t<!-- Modified By rajesh 29-8-2012 -->\n\t\t\t<input type=\'text\' name=\'tray_no\' id=\'tray_no\' maxlength=\'30\' size=\'20\' disabled > \n\t\t\t<!-- Modified By rajesh 29-8-2012 -->\n\t</td>\n\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t  <td class=\"label\" width=\"25%\" >\n\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =" </td>\n     <td class=\"fields\" width=\"25%\">\n\t\t\t<input type=\'text\' name=\'tray_no\' id=\'tray_no\' maxlength=\'30\' size=\'20\' ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\t\n</tr>\n\n\n<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\t <td class=\"fields\" width=\'25%\'><input type=\'text\' name=\'quantity_ic\' id=\'quantity_ic\' maxlength=\'3\' size=\'2\' onBlur=\"ChkNumber(this);\" onkeypress=\"return checkForSpecCharsforID(event);\"  ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="><img src=\'../../eCommon/images/mandatory.gif\'></img></td>\n\t<td class=\"label\" width=\'25%\'>\n\t<input type=\'hidden\' name=\'remarks_ic\' id=\'remarks_ic\' value=\"\">\n\t\n\t\t\t<a   class=\"gridLink\" href=\"javascript:openCheckListRemarksWindow_ic(document.forms[0].remarks_ic);\">\n\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</a>\n\t\n\t</td>\n\t<td width=\"25%\" >\n\t\t<input type=\'button\' id=\'sels\' name = \'select\' class=\'button\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' onClick=\'assignCodes(document.forms[0].operation_ic);addRow_ic();\' ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =" >\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' onClick=\'removeRow_ic();\' ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" >\n\t</td>\n</tr>\n</table>\n<!-- Starts Added for the incident 38966 -->\n";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n<script>\t\t\n\t//if(ImplantsRecordForm.elements(\"fromvalFlag\").value ==\'Y\'){\n\t\tdocument.getElementById(\"sels\").disabled=true;\n\t\t//}/*else{\n//\t\tImplantsRecordForm.elements(\"sels\").disable = false;\n//\t} */\t      \n   </script>\n     ";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="   \n<!-- Ends Added for the incident 38966 -->\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\n<!-- added by Sathish for Amazon Changes-->\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t<!-- end -->\n\n\t";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\n    <input type=\'hidden\' name=\'chk_val\' id=\'chk_val\' value=\"0\">\n\t<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n\t<input type=\'hidden\' name=\'oper_code\' id=\'oper_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'oper_line_no\' id=\'oper_line_no\' value=\'\'>\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t<input type=\'hidden\' name=\'bill_flag\' id=\'bill_flag\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t<input type=\'hidden\' name=\'rec_implants_in_nurs_notes_yn\' id=\'rec_implants_in_nurs_notes_yn\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t<input type=\'hidden\' name=\'rec_equp_in_nurs_notes_yn\' id=\'rec_equp_in_nurs_notes_yn\' value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t<input type=\'hidden\' name=\'rec_instr_in_nurs_notes_yn\' id=\'rec_instr_in_nurs_notes_yn\' value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t<input type=\'hidden\' name=\'rec_packs_in_nurs_notes_yn\' id=\'rec_packs_in_nurs_notes_yn\' value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t<input type=\'hidden\' name=\'st_interface_flag\' id=\'st_interface_flag\' value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t<input type=\'hidden\' name=\'oper_room_code\' id=\'oper_room_code\' value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t<input type=\'hidden\' name=\'fromval\' id=\'fromval\' value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\n\t<input type=\'hidden\' name=\'onLoadFlag\' id=\'onLoadFlag\' value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\">\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\n\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t<input type=\'hidden\' name=\'patient_class\' id=\'patient_class\' value=\"";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t<input type=\'hidden\' name=\'mm_item_code\' id=\'mm_item_code\' value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t<input type=\'hidden\' name=\'item_id\' id=\'item_id\' value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\">\n\t<input type=\'hidden\' name=\'include_exclude_st\' id=\'include_exclude_st\' value=\"\">\n\t<input type=\'hidden\' name=\'reason_code_st\' id=\'reason_code_st\' value=\"\">\n\t<input type=\'hidden\' name=\'Ot_param\' id=\'Ot_param\' value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\"><!--Added by lakshmi against crf-0058-->\n\t<input type=\'hidden\' name=\'fromvalFlag\' id=\'fromvalFlag\' value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\"><!-- Added for the incident 38966 -->\n\t<input type=\'hidden\' name=\'customer_id\' id=\'customer_id\' value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\"><!-- Added for the CRF-0091 -->\n\t<input type=\'hidden\' name=\'oneWeekDate\' id=\'oneWeekDate\' id=\'oneWeekDate\' value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\">\n\t<input type=\'hidden\' name=\'checkInTime\' id=\'checkInTime\' id=\'checkInTime\' value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n\t<script>\t\t\n\t  // disableSelectButton(document.forms[0].select);\n   </script>\n    ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n</form>\n</BODY>\n</HTML>\n\n\n\n";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );
	
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
 String locale = (String)session.getAttribute("LOCALE"); 
//Added code to get seesion values in OperationEquipmentsTab.jsp for scf-5515 by Anitha on 11/25/2010
HashMap temp = new HashMap();
temp=(HashMap)session.getAttribute("NursingDetails");

            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	
	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

	String st_bean_id 				    = "ottransactionbean";
	String st_bean_name 			    = "eST.OTTransactionBean";
	OTTransactionBean bean	= (OTTransactionBean)getBeanObject(st_bean_id, st_bean_name, request ) ;

	//String tab = checkForNull(request.getParameter("tab"));
	String tab = (String)temp.get("tab");


String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
String style = "";
				style = "color:blue;cursor:pointer";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);
            _bw.write(_wl_block8_2Bytes, _wl_block8_2);
            out.print( String.valueOf(tab));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);
            _bw.write(_wl_block9_2Bytes, _wl_block9_2);

	String rec_implants_in_nurs_notes_yn="";
	String rec_equp_in_nurs_notes_yn="";
	String rec_instr_in_nurs_notes_yn="";
	String rec_packs_in_nurs_notes_yn="";
	String st_interface_flag="";
	String st_doc_type_rti="";
	String st_doc_type_sli="";
	String frm_pick_list="";

	char fromvalFlag  = 'N';

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(tab));
            _bw.write(_wl_block12Bytes, _wl_block12);
  
	String p_qty = "";
	String st_location ="";//Added for CRF 091
	String desiredDate = "";
	String from_val_overload = request.getParameter("from_val_overload");
	if(from_val_overload ==null) from_val_overload="N";
	String flag_acc=checkForNull(request.getParameter("flag_acc"));
    if(flag_acc==null)flag_acc ="";  
	String fromval="";


	String oper_num		= checkForNull((String)temp.get("oper_num"));
	String facility_id	= checkForNull((String)temp.get("facility_id"));
	String patient_id	= checkForNull((String)temp.get("patient_id"));
	String booking_num = checkForNull((String)temp.get("booking_num"));
	String surgeon_code = checkForNull((String)temp.get("surgeon_code"));
	String bill_flag = checkForNull((String)temp.get("bill_flag"));

	

	if(flag_acc.equals(""))
	{

	fromval=checkForNull(request.getParameter("fromval"));

	}else
	{
		fromval=checkForNull(request.getParameter("from_values"));

	}
	String item_type="";
	if(fromval.equals("prosimplants"))
	{
		item_type="S";
	}else if(fromval.equals("Conspack"))
	{
		item_type="P";
	}else if(fromval.equals("equipments"))
	{
		item_type="E";
	}else if(fromval.equals("InstruCSSD"))
	{
		item_type="I";
	}


            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(booking_num));
            _bw.write(_wl_block14Bytes, _wl_block14);

	HashMap line_no_map = new HashMap();
	String line_no="";
	boolean exist_rec = false;
	boolean exist_rec_con = false;
	boolean exist_rec_eq = false;
	boolean exist_rec_inst = false;
	boolean pick_list = false;
	StringBuffer oper_codes = new StringBuffer();
	String surgeon_doc_comp_yn ="",nursing_doc_comp_yn ="", implant_entry_cmp_yn ="",consumable_entry_cmp_yn ="",equipment_entry_cmp_yn ="",instrument_entry_cmp_yn ="";
	String currentDateTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM", locale);
	String oneWeekDate = com.ehis.util.DateUtils.plusDate((com.ehis.util.DateUtils.plusDate(com.ehis.util.DateUtils.getCurrentDate("DMY", locale), "DMY", locale, 1, "d")), "DMY", locale, 1, "w");	//048580

	String oper_room_code = (String)temp.get("oper_room_code");
	String encounter_id = (String)temp.get("encounter_id");
	String onLoadFlag = request.getParameter("onLoadFlag") == null ? "" : request.getParameter("onLoadFlag");

	String rec_implants_in_surg_notes_yn = checkForNull((String)temp.get("rec_implants_in_surg_notes_yn"));
	rec_implants_in_nurs_notes_yn = checkForNull((String)temp.get("rec_implants_in_nurs_notes_yn"));
	rec_equp_in_nurs_notes_yn = checkForNull((String)temp.get("rec_equp_in_nurs_notes_yn"));
	rec_instr_in_nurs_notes_yn = checkForNull((String)temp.get("rec_instr_in_nurs_notes_yn"));
	rec_packs_in_nurs_notes_yn = checkForNull((String)temp.get("rec_packs_in_nurs_notes_yn"));
	st_interface_flag = checkForNull((String)temp.get("st_interface_flag"));
	String episode_type = checkForNull((String)temp.get("episode_type"));
	String patient_class = checkForNull((String)temp.get("patient_class"));

	if(tab.equals("record_surgeon")){
		surgeon_doc_comp_yn = checkForNull((String)temp.get("surgeon_doc_comp_yn"));
		nursing_doc_comp_yn = checkForNull((String)temp.get("nursing_doc_comp_yn"));
		rec_implants_in_nurs_notes_yn=rec_implants_in_surg_notes_yn;
		implant_entry_cmp_yn = checkForNull((String)temp.get("implant_entry_cmp_yn"));

	} else if(tab.equals("record_nursing")){
		
		nursing_doc_comp_yn = checkForNull((String)temp.get("nursing_doc_comp_yn"));
		implant_entry_cmp_yn = checkForNull((String)temp.get("implant_entry_cmp_yn"));
		consumable_entry_cmp_yn = checkForNull((String)temp.get("consumable_entry_cmp_yn"));
		equipment_entry_cmp_yn = checkForNull((String)temp.get("equipment_entry_cmp_yn"));
		instrument_entry_cmp_yn = checkForNull((String)temp.get("instrument_entry_cmp_yn"));
			
	}
	//Below condition changed by Sanjay for SRR20056-SCF-7684 on 21-Jun-2011
	if(consumable_entry_cmp_yn.equals("N")) consumable_entry_cmp_yn="";
		String disable_flag="",disable_flag1="",disable_flag2="",disable_flag3="";

	CallableStatement statement =null;

	String key = "",key_line="",key_eq = "", key_eq1 = "",key_line_eq="", key_ic = "",key_ic1 = "",key_cp = "", key_cp1 = "",key_pi = "",key_line_ic="",key_line_cp="",bill_str="",panel_str="",bill_str_conspack="";

	HashMap bill_info=new HashMap();
	HashMap bill_info_conspack=new HashMap();
	HashMap bill_info_eq=new HashMap();
	HashMap bill_info_ic=new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	StringBuilder bl_bfr_conspack = new StringBuilder();
	String order_id="",order_line_num="",booking_date  = "",visit_id   = "",catalog_code   = "",item_id="",req_store="", mm_item_code="",avail_stock="",sale_document_no="",no_of_units="",sale_document_type="",reserve_qty="",request_qty="",req_store_code="";
	int total_stock_val=0;

	 String SQL_EXIST = "SELECT ACCESSORY_CODE FROM OT_SURGICAL_ACCESSORIES WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND ACCESSORY_TYPE=? AND ROWNUM=1";
	//this query checks whether we have already record in OT_PICK_LISTS Table if returns true="PICK_LIST_DEFINED Qry is executed otherwise PICKlIST_UNDEFINED Qry is executed"
	String PICK_LIST_EXIST_YN = "SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?) AND ROWNUM=1";
 	String PICK_LIST_DEFINED="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.ITEM_ID) ACC_DESC,GET_DESC('"+locale+"','MM_STORE_LANG_VW','SHORT_DESC','STORE_CODE',A.REQ_STORE_CODE) Store_desc,NVL(A.NO_OF_UNITS,1) TR_NO,A.REQ_STORE_CODE, A.RESERVED_QTY RESERVED_QTY, A.REQUESTED_QTY REQUESTED_QTY,A.SALE_DOCUMENT_TYPE SALE_DOCUMENT_TYPE,A.SALE_DOCUMENT_NO SALE_DOCUMENT_NO,A.REQ_DOCUMENT_TYPE REQ_DOCUMENT_TYPE,A.REQ_DOCUMENT_NO REQ_DOCUMENT_NO,A.NO_OF_UNITS NO_OF_UNITS, 'Y' FRM_PICK_LIST ,B.MM_ITEM_CODE FROM  OT_PICK_LISTS A, OT_PROSTHESIS_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'S' AND A.ITEM_ID = B.PROSTHESIS_CODE AND B.LANGUAGE_ID='"+locale+"' ";//MMS-QH-CRF-0199
	String PICK_LIST_DEFINED_CONSPACK="SELECT A.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.ITEM_ID ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY, 'Y' FRM_PICK_LIST FROM  OT_PICK_LISTS A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'P' AND A.ITEM_ID = B.PACKAGE_CODE";//MMS-QH-CRF-0199
	String SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.ACCESSORY_CODE) ACC_DESC,GET_DESC('"+locale+"','MM_STORE_LANG_VW','SHORT_DESC','STORE_CODE',A.REQ_STORE_CODE) Store_desc, A.QUANTITY TR_NO, A.PROSTHESIS_MFR MFR,A.PROSTHESIS_BATCH_NO BTCH, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY,A.SALE_DOCUMENT_TYPE SALE_DOCUMENT_TYPE ,A.SALE_DOCUMENT_NO SALE_DOCUMENT_NO,A.EXCL_INCL_IND EXCL_INCL_IND , A.ACTION_REASON_CODE  ACTION_REASON_CODE,C.MM_ITEM_CODE FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PROSTHESIS_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'S' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PROSTHESIS_CODE AND C.LANGUAGE_ID='"+locale+"'" ;//MMS-QH-CRF-0199
	String SQL1 = "SELECT A.OPER_CODE OPR_CODE,A.OPER_LINE_NUM LN_NUM,B.LONG_DESC OPR_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND NVL(A.OPER_LINE_STATUS,'X' ) NOT IN '99' ";//MMS-QH-CRF-0199
	String PICK_LIST_DEFINED_EQ="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.ITEM_ID)  ACC_DESC,A.NO_OF_UNITS TR_NO, 'Y' FRM_PICK_LIST, B.LOCATION LOCATION FROM  OT_PICK_LISTS A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'E' AND A.ITEM_ID = B.EQUIPMENT_CODE";//MMS-QH-CRF-0199
	String PICK_LIST_DEFINED_IC="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ITEM_ID) ACC_DESC,A.NO_OF_UNITS TR_NO, 'Y' FRM_PICK_LIST FROM  OT_PICK_LISTS A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'I' AND A.ITEM_ID = B.INSTR_CODE AND B.LANGUAGE_ID='"+locale+"' ";//MMS-QH-CRF-0199
	//Added Site Specific Query by Rajesh for CRF-0058
	String PICK_LIST_DEFINED_IC_SS = "SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ITEM_ID) ACC_DESC,A.NO_OF_UNITS TR_NO, 'Y' FRM_PICK_LIST, b.location LOCATION  FROM  OT_PICK_LISTS A, OT_INSTRUMENT_LANG_VW B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ?  AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'I' AND A.ITEM_ID = B.INSTR_CODE AND B.LANGUAGE_ID='"+locale+"' ";//MMS-QH-CRF-0199
	String sqlForCheckInTime = "SELECT DECODE (?, 'en', TO_CHAR (a.check_in_time, 'DD/MM/YYYY HH24:MI'), 'th', TO_CHAR (a.check_in_time, 'DD/MM/YYYY HH24:MI', 'NLS_CALENDAR=''THAI BUDDHA''' ) ) check_in_time, CANCELLED_BY,TO_CHAR(CANCELLATION_DATE_TIME,'DD/MM/YYYY HH24:MI') CANCELLATION_DATE_TIME, DECODE(CANCEL_REASON,NULL,'',(SELECT REASON_DESC FROM OT_REASONS_LANG_VW WHERE LANGUAGE_ID = ? AND REASON_CODE = CANCEL_REASON)) CANCEL_REASON, TO_CHAR(A.CHECK_INTO_HOLDING_AREA_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_HOLDING_AREA_TIME, TO_CHAR(A.CHECK_INTO_OR_TIME,'DD/MM/YYYY HH24:MI') CHECK_INTO_OR_TIME,TO_CHAR(A.NURSING_DOC_COMP_TIME,'DD/MM/YYYY HH24:MI') NURSING_DOC_COMP_TIME,TO_CHAR(A.SURGEON_DOC_COMP_TIME,'DD/MM/YYYY HH24:MI') SURGEON_DOC_COMP_TIME,TO_CHAR(A.ANAESTHETIST_DOC_COMP_TIME,'DD/MM/YYYY HH24:MI') ANAESTHETIST_DOC_COMP_TIME,TO_CHAR(A.RECOVERY_START_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_START_TIME,TO_CHAR(A.RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI') RECOVERY_END_TIME,TO_CHAR(A.CHECK_OUT_TIME,'DD/MM/YYYY HH24:MI') CHECK_OUT_TIME FROM OT_POST_OPER_HDR A WHERE A.OPERATING_FACILITY_ID = ? AND A.OPER_NUM =?"; 	//048580
	//Added Site Specific Query by Rajesh for CRF-0058
	Connection con = null;
	PreparedStatement pstmt = null,pstmt_bl = null,pstmt_doc_type = null,pstmt_Conspack = null,pstmt_eq = null,pstmt_ic = null,pstmt_acc_reqyn = null,pstmt_st = null,pstmt_room = null,pstmt_req_store = null;

	//Added by lakshmi against CRF-0058
	PreparedStatement pstmt_sm_report_display = null;
	PreparedStatement pstmtForCheckInTime = null;
	ResultSet rst_sm_report_display=null;
	ResultSet rsForCheckInTime = null;
	String Ot_param="";

	//Added by muthuN RUT-CRF-0091 on 05-13-2013
	//PreparedStatement pstmt_st = null;
	ResultSet rst_st=null;
	String customer_id="";
	Statement stmt=null;
	String val= "";
	String checkInTime = "";
	String checkIntoOrTime = "";
	String checkOutTime = "";
	ResultSet rst = null,rst_bl = null,rset = null,rset_req_store = null,rset_doc_type = null,rst_Conspack = null,rst_eq = null,rst_ic = null,rst_room = null,rst_acc_reqyn = null;

	String rst_acc_code = "", rst_tr_no = "", bl_episode_type = "",st_charge_based_yn="";

	String overridden_action_reason_code=null;
	con = ConnectionManager.getConnection(request);
	int index=0;
	try{

		pstmtForCheckInTime = con.prepareStatement(sqlForCheckInTime) ;
		pstmtForCheckInTime.setString(1,locale);
		pstmtForCheckInTime.setString(2,locale);
		pstmtForCheckInTime.setString(3,facility_id);
		pstmtForCheckInTime.setString(4,oper_num);
		rsForCheckInTime = pstmtForCheckInTime.executeQuery();
		if(rsForCheckInTime != null && rsForCheckInTime.next())
		{
			checkInTime = checkForNull(rsForCheckInTime.getString("CHECK_IN_TIME"));
			checkIntoOrTime = checkForNull(rsForCheckInTime.getString("CHECK_INTO_OR_TIME"));
			checkOutTime = checkForNull(rsForCheckInTime.getString("CHECK_OUT_TIME"));
		}

		//Added by lakshmi against CRF-0058 starts here
		//Modified by Rajesh 28-8-2012
		//String sql_sm_report="select NVL(PICKLIST_BY_WARD,'N') PICKLIST  from OT_PARAM where rownum = 1";
		String sql_sm_report="select NVL(INSTRUMENT_CSSD_IMAGE,'N') PICKLIST  from OT_PARAM where rownum = 1";
		//Modified by Rajesh 28-8-2012
		pstmt_sm_report_display=con.prepareStatement(sql_sm_report);
		rst_sm_report_display=pstmt_sm_report_display.executeQuery();
		if(rst_sm_report_display !=null && rst_sm_report_display.next())
		Ot_param=checkForNull(rst_sm_report_display.getString("PICKLIST"));
		if(rst_sm_report_display!=null)
			rst_sm_report_display.close();
		if(pstmt_sm_report_display!=null)
			pstmt_sm_report_display.close();
	   //Added by lakshmi against CRF-0058 ends here
//Added by muthuN for RUT-CRF-0091 on 05-13-2013
	   pstmt_st = con.prepareStatement("select CUSTOMER_ID from sm_site_param");				
			rst_st = pstmt_st.executeQuery();	
			if ( rst_st.next() && rst_st != null )
			{
				customer_id  =  rst_st.getString(1);
			}
//Added by muthuN for RUT-CRF-0091 on 05-13-2013
		stmt=con.createStatement();
	String sql_bl_epi_type="SELECT BL_EPISODE_TYPE FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS = '"+patient_class+"' AND EPISODE_TYPE ='"+episode_type+"' ";
		pstmt_bl = con.prepareStatement(sql_bl_epi_type);
		rst_bl=pstmt_bl.executeQuery();
		if(rst_bl !=null && rst_bl.next())
		{
			bl_episode_type=checkForNull(rst_bl.getString(1));
		}

		if(implant_entry_cmp_yn.equals("Y"))
		{
			disable_flag="disabled";
		}
		
		if(consumable_entry_cmp_yn.equals("Y"))
		{
			disable_flag1="disabled";
		}

		if(equipment_entry_cmp_yn.equals("Y"))
		{
			disable_flag2="disabled";
		}

		if(instrument_entry_cmp_yn.equals("Y"))
		{
			disable_flag3="disabled";
		}

		if(st_interface_flag.equals("Y"))
			 {

	String sql_doc_type="SELECT ST_DOC_TYPE_RTI,ST_DOC_TYPE_SLI  FROM ot_param_for_facility WHERE OPERATING_FACILITY_ID='"+facility_id+"'";

			pstmt_doc_type=con.prepareStatement(sql_doc_type);
			rset_doc_type=pstmt_doc_type.executeQuery();

			if(rset_doc_type !=null && rset_doc_type.next())
			{
				st_doc_type_rti =rset_doc_type.getString("ST_DOC_TYPE_RTI");
				if(st_doc_type_rti==null) st_doc_type_rti="";
				st_doc_type_sli=rset_doc_type.getString("ST_DOC_TYPE_SLI");
				if(st_doc_type_sli==null) st_doc_type_sli="";
			}
		if(st_doc_type_rti.equals("") || st_doc_type_sli.equals(""))
		{
			out.println("<script>alert(getMessage('PRC-OT0055','OT')); window.close();</script>");
		}
  }
		if (fromval == "") 
					fromvalFlag = 'Y';
		else   fromvalFlag = 'N';

		if(fromval =="" && rec_implants_in_nurs_notes_yn.equals("Y") )  {fromval="prosimplants";}
	    else if(fromval =="" && rec_implants_in_nurs_notes_yn.equals("N") && rec_packs_in_nurs_notes_yn.equals("Y")) {fromval="Conspack";}
		else if(fromval =="" && rec_implants_in_nurs_notes_yn.equals("N") && rec_packs_in_nurs_notes_yn.equals("N") && rec_equp_in_nurs_notes_yn.equals("Y")) {fromval="equipments";}
		else if(fromval =="" && rec_implants_in_nurs_notes_yn.equals("N") && rec_packs_in_nurs_notes_yn.equals("N") && rec_equp_in_nurs_notes_yn.equals("N")) {fromval="InstruCSSD";}

		if(rst_acc_reqyn!=null)   rst_acc_reqyn.close();
		if(pstmt_acc_reqyn!=null) pstmt_acc_reqyn.close();

		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);

		rst = pstmt.executeQuery();
		int fetch_count = 0;
		while(rst.next()){
			++fetch_count;
			if(fetch_count==1)
			oper_codes.append("'"+rst.getString(1)+"'");
			else
			 oper_codes.append(","+"'"+rst.getString(1)+"'");
			line_no_map.put(rst.getString(1),rst.getString(2));
		}
		
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		pstmt = con.prepareStatement(SQL_EXIST);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		pstmt.setString(3,"S");
		rst = pstmt.executeQuery();
		if(rst.next()){
			exist_rec=true;
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();

	    /* **************************** Prothesis/Impalnts Starts Here******************************************/
			String rate="";
		
	if(st_interface_flag.equals("Y"))
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
		if(exist_rec==true){
			if(rec_implants_in_nurs_notes_yn.equals("Y"))
			{
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,oper_num);
			rst = pstmt.executeQuery();
			index = 0;
			while(rst.next()){
				++index;	
			key = rst.getString("KEY");
			key_line = rst.getString("KEY_LINE");
				item_id=checkForNull(rst.getString("ACC_CODE"));
			req_store=	checkForNull(rst.getString("REQ_STORE_CODE"));
			p_qty=	checkForNull(rst.getString("TR_NO"));
			if(p_qty == null) p_qty="";
			sale_document_type=	checkForNull(rst.getString("SALE_DOCUMENT_TYPE"));
			sale_document_no=	checkForNull(rst.getString("SALE_DOCUMENT_NO"));
			String excl_incl_ind_st=	checkForNull(rst.getString("EXCL_INCL_IND"));
			String action_reason_code_st=	checkForNull(rst.getString("ACTION_REASON_CODE"));
			mm_item_code=rst.getString("MM_ITEM_CODE");
				if(mm_item_code ==null) mm_item_code="";
			
		if(!item_id.equals("") )
		 {
try 
			 {
				/*	 sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_id+"'";

					    pstmt_st=con.prepareStatement(sql_mm_code);
					  rst_st=pstmt_st.executeQuery();
				if(rst_st !=null && rst_st.next())
				{
					mm_item_code=rst_st.getString(1);
					if(mm_item_code ==null) mm_item_code="";
				}*/
       
		String[] stParameters = {mm_item_code,req_store , "0", "N", "", "N", "" };
		HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
    	avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");

			 }catch(Exception e)
			 {
				System.err.println("2096,Err Msg in Pros=========="+e.getMessage());
				e.printStackTrace();
				//out.println("<script>alert('Stock is not available for the Item/Store combination') return;</script>");
				avail_stock="";
			 }
		 }

		 if(("true").equals(bill_flag))
			{

				if(st_interface_flag.equals("N"))
				{
			bill_info = or_bean.getOrderBillDtls(key+key_line);

			if(bill_info==null){
				bill_info = new HashMap();
				bill_info.put("key",key);
				bill_info.put("key_line_no",key_line);
				rst_acc_code = rst.getString("ACC_CODE");
				bill_info.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info.put("acc_type","I");
				bill_info.put("oper_num",oper_num);
				bill_info.put("locale",locale);
				bill_info.put("module_id","OT");
				rst_tr_no = rst.getString("TR_NO");
				bill_info.put("quantity",rst_tr_no);
				bill_info.put("rate",rate);
				bill_info = billing_bean.getBillingParams(bill_info,"C");//C-> for Surgical Accessories Billing
				if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key+key_line,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
		}
			}
			panel_str = (String) bill_info.get("bl_panel_str");	
	//		String overridden_incl_excl_ind=null;

			bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
			bl_bfr.append(excl_incl_ind_st).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
			bl_bfr.append(action_reason_code_st).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E"));
			
				bill_str = bl_bfr.toString();
				}else
					{


					if(!req_store.equals(""))
					{
					System.err.println("ST_BL_GET_ITEM_CHARGE_DTLS =b4====111=="+System.currentTimeMillis());
					statement=con.prepareCall("{call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");//Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
					System.err.println("ST_BL_GET_ITEM_CHARGE_DTLS =a4====111=="+System.currentTimeMillis());
				String sal_trn_type="";
					p_qty=	checkForNull(rst.getString("TR_NO"));
								if(patient_class.equals("IP"))
									{
										sal_trn_type="I";
									}else if(patient_class.equals("OP"))
									{
									sal_trn_type="O";
									}else if(patient_class.equals("EM"))
									{
									sal_trn_type="E";
									}else if(patient_class.equals("DC"))
									{
									sal_trn_type="D";
									}else if(patient_class.equals("XT"))
									{
									sal_trn_type="R";
									}

			statement.setString(1, facility_id);
			statement.setString(2, patient_id);
			statement.setString(3, "ST");
			statement.setString(4, encounter_id);
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
//				String overridden_incl_excl_ind=null;
				if(excl_incl_ind_st=="") excl_incl_ind_st=null;
				if(action_reason_code_st=="") action_reason_code_st=null;
				String override_value=statement.getString(37);
				bl_bfr.append(checkForNull(""+statement.getString(21),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(25),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(38),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");
				bl_bfr.append(excl_incl_ind_st).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(36),"N")).append("::");
				bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value always in the screen   but there is no concept of service or panel through ST billing.
				bl_bfr.append(action_reason_code_st).append("::");
				bl_bfr.append(checkForNull(""+excl_incl_ind_st,"E")).append("::");
				bl_bfr.append(override_value);
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
					}
				}
			bl_bfr.setLength(0);
			}

frm_pick_list="N";
           //Added encode for REMKS on 10/18/2010 by AnithaJ 
			out.println("<script>loadDBRows_pi('"+tab+"','"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+item_id+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+checkForNull(rst.getString("MFR"))+"','"+checkForNull(rst.getString("BTCH"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("REMKS")),"UTF-8")+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst.getString("REQ_STORE_CODE"))+"','"+checkForNull(rst.getString("RESERVED_QTY"))+"','"+checkForNull(rst.getString("REQUESTED_QTY"))+"','"+no_of_units+"','"+sale_document_no+"','"+sale_document_type+"','"+avail_stock+"','"+checkForNull(rst.getString("Store_desc"))+"','"+frm_pick_list+"'); </script>");	
 		   }
           if(rst!=null)rst.close();
		   if(pstmt!=null)pstmt.close();
			}
		}
		else if(implant_entry_cmp_yn.equals("N") || implant_entry_cmp_yn.equals("")) //commented on 2/15/2011 by Anitha for 25110
		{
			if(rec_implants_in_nurs_notes_yn.equals("Y"))
			{
			pstmt = con.prepareStatement(PICK_LIST_EXIST_YN);
		
			pstmt.setString(1,facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
			rst = pstmt.executeQuery();
			if(rst.next()){
				pick_list=true;
			}
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			//pick_list=true;
			if(pick_list==true)
			{

				 pstmt = con.prepareStatement(PICK_LIST_DEFINED);
				 pstmt.setString(1,facility_id);
				 pstmt.setString(2,patient_id);
				 //pstmt.setString(3,surgeon_code);// as vishawa told to remove team_doctor_code 
				 pstmt.setString(3,booking_num);
				 pstmt.setString(4,oper_num);
				 rst = pstmt.executeQuery();
				 int r=0;
				 index =0;
				if(rst !=null)	
				{
				while(rst.next()){
					++index;	
					++r;
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
					item_id=checkForNull(rst.getString("ACC_CODE"));
					req_store=checkForNull(rst.getString("REQ_STORE_CODE"));
					sale_document_no=checkForNull(rst.getString("SALE_DOCUMENT_NO"));
					sale_document_type=checkForNull(rst.getString("SALE_DOCUMENT_TYPE"));
					no_of_units=checkForNull(rst.getString("NO_OF_UNITS"));
					reserve_qty=checkForNull(rst.getString("RESERVED_QTY"));
					request_qty=checkForNull(rst.getString("REQUESTED_QTY"));
					p_qty = rst.getString("TR_NO");
					if(p_qty == null) p_qty="";
					frm_pick_list=rst.getString("FRM_PICK_LIST");
					if(frm_pick_list ==null) frm_pick_list="N";
						mm_item_code=rst.getString("MM_ITEM_CODE");
				if(mm_item_code ==null) mm_item_code="";
							
			if(!item_id.equals("") )
		 {
			try 
			 {
		String[] stParameters = {mm_item_code,req_store , "0", "N", "", "N", "" };
		HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
    		avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");

			 }catch(Exception e)
			 {
				System.err.println("2309,Err Msg in Pros=========="+e.getMessage());		 
				e.printStackTrace();
				 avail_stock="";
			 }
		 }
	if(("true").equals(bill_flag))
			    {
				
					if(st_interface_flag.equals("N"))
				{
			
					HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "I#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE")+r;
				key_pi = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");

				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info.putAll(hash);
				bill_info.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
				if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
		}
				String overridden_incl_excl_ind=null;
				panel_str = (String) bill_info.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");				
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");;
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}else
				{
					if(!req_store.equals(""))
					{
						System.err.println("ST_BL_GET_ITEM_CHARGE_DTLS =b4====222=="+System.currentTimeMillis());
					statement=con.prepareCall("{call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");//Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
					System.err.println("ST_BL_GET_ITEM_CHARGE_DTLS =a4====222=="+System.currentTimeMillis());
				String sal_trn_type="";
				p_qty = rst.getString("TR_NO");
								if(patient_class.equals("IP"))
									{
										sal_trn_type="I";
									}else if(patient_class.equals("OP"))
									{
									sal_trn_type="O";
									}else if(patient_class.equals("EM"))
									{
									sal_trn_type="E";
									}else if(patient_class.equals("DC"))
									{
									sal_trn_type="D";
									}else if(patient_class.equals("XT"))
									{
									sal_trn_type="R";
									}
		   String incl_excl=null;
			statement.setString(1, facility_id);
			statement.setString(2, patient_id);
			statement.setString(3, "ST");
			statement.setString(4, encounter_id);
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
			  incl_excl=statement.getString(35);
			String override_value=statement.getString(37);
				bl_bfr.append(checkForNull(""+statement.getString(21),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(25),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(38),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");
				bl_bfr.append(incl_excl).append("::");
				bl_bfr.append(checkForNull(""+statement.getString(36),"N")).append("::");
				bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value always in the screen   but there is no concept of service or panel through ST billing.
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+incl_excl,"E")).append("::");
				bl_bfr.append(override_value);
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
					}
				}
				}//end of if bill_flag
out.println("<script>loadDBRows_pi('"+tab+"','"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+item_id+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','','','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key_pi+"','"+key_line+"','"+req_store+"','"+checkForNull(rst.getString("RESERVED_QTY"))+"','"+checkForNull(rst.getString("REQUESTED_QTY"))+"','"+no_of_units+"','"+sale_document_no+"','"+sale_document_type+"','"+avail_stock+"','"+checkForNull(rst.getString("Store_desc"))+"','"+frm_pick_list+"'); </script>");	
			}//end of while loop
			}
              if(rst!=null)rst.close();
			  if(pstmt!=null)pstmt.close();
			}
			else 
			{
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
					String PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC,   NVL(A.NO_OF_UNITS,1) TR_NO,B.MM_ITEM_CODE FROM  OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")   UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,NVL(A.NO_OF_UNITS,1) TR_NO,B.MM_ITEM_CODE FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC,  NVL(A.NO_OF_UNITS,1) TR_NO,B.MM_ITEM_CODE FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.PROSTHESIS_CODE  = B.PROSTHESIS_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC, NVL(A.NO_OF_UNITS,1) TR_NO,B.MM_ITEM_CODE   FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND  A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE     AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE      AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.PROSTHESIS_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.PROSTHESIS_CODE) ACC_DESC,  NVL(A.NO_OF_UNITS,1) TR_NO,B.MM_ITEM_CODE FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.PROSTHESIS_CODE = B.PROSTHESIS_CODE";//MMS-QH-CRF-0199 
					pstmt = con.prepareStatement(PICK_LIST_UNDEFINED);
					rst = pstmt.executeQuery();
					index=0;
					while(rst.next()){
						++index;	
						line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
						item_id=checkForNull(rst.getString("ACC_CODE"));
						mm_item_code=rst.getString("MM_ITEM_CODE");
						if(mm_item_code ==null) mm_item_code="";
							if(!item_id.equals("") ){
								try {
									/*	 sql_mm_code="select MM_ITEM_CODE from OT_PROSTHESIS where PROSTHESIS_CODE='"+item_id+"'";
								    pstmt_st=con.prepareStatement(sql_mm_code);
									rst_st=pstmt_st.executeQuery();
									if(rst_st !=null && rst_st.next()){
									mm_item_code=checkForNull(rst_st.getString(1));
									}*/
									String[] stParameters = {mm_item_code,req_store_code , "0", "N", "", "N", "" };
									HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
							    	avail_stock = (String)hmStockAvailabilityStatus.get("available_stock");
								}catch(Exception e){
									e.printStackTrace();
									//out.println("<script>alert('Stock is not available for the Item/Store combination')</script>");
									avail_stock="";
								}
							}
						if(("true").equals(bill_flag)){
							p_qty= rst.getString("TR_NO");
							if(p_qty == null) p_qty="";
							if(st_interface_flag.equals("N")){
								HashMap hash = billing_bean.getORBillingParams(oper_num);
								catalog_code = "I#"+rst.getString("ACC_CODE");
								key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
								key_line="";
								booking_date = (String) hash.get("service_date");
								patient_id = (String)hash.get("patient_id");
								encounter_id = (String)hash.get("encounter_id");
								surgeon_code = (String)hash.get("pract_staff_id");
								patient_class = (String)hash.get("patient_class");
								visit_id = (String)hash.get("visit_id");
								ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
								bill_info = billing_bean.formatBillingDetails(bill_dtls);
								hash.put("key",key);
								hash.put("key_line_no",key_line);
								hash.put("oper_code",rst.getString("ACC_CODE"));//pass acc_code in oper_code
								hash.put("acc_type","I");
								hash.put("oper_num",oper_num);
								hash.put("locale",locale);
								hash.put("quantity",rst.getString("TR_NO"));
								bill_info.putAll(hash);
								bill_info.put("quantity",p_qty);
								//set billing details from OTBillingBean........	
								if(from_val_overload.equals("N")){
									or_bean.setOrderBillDtls(key,bill_info);
									putObjectInBean(or_bean_id,or_bean,request);
								}
								String overridden_incl_excl_ind=null;
								panel_str = (String) bill_info.get("bl_panel_str");	
								bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
								bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
								bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
								bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
								bl_bfr.append(overridden_incl_excl_ind).append("::");
								bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
								bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"))).append("::");
								bl_bfr.append(overridden_action_reason_code).append("::");
								bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
								bill_str = bl_bfr.toString();
								bl_bfr.setLength(0);
							}else{					
								if(!req_store_code.equals("")){
						System.err.println("ST_BL_GET_ITEM_CHARGE_DTLS =b4====333333=="+System.currentTimeMillis());
									statement=con.prepareCall("{call ST_BL_GET_ITEM_CHARGE_DTLS (?,?,?,?,?,to_date(?,'dd/MM/yyyy'),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");//Maheshwaran K modified for  SKR-SCF-0788 [IN:039522] as on 24/09/2013
						System.err.println("ST_BL_GET_ITEM_CHARGE_DTLS =a4====333333=="+System.currentTimeMillis());
									String sal_trn_type="";
									if(patient_class.equals("IP")){
										sal_trn_type="I";
									}else if(patient_class.equals("OP")){
								sal_trn_type="O";
								}else if(patient_class.equals("EM")){
									sal_trn_type="E";
								}else if(patient_class.equals("DC")){
									sal_trn_type="D";
								}else if(patient_class.equals("XT")){
									sal_trn_type="R";
								}
								statement.setString(1, facility_id);
								statement.setString(2, patient_id);
								statement.setString(3, "ST");
								statement.setString(4, encounter_id);
								statement.setString(5, sal_trn_type);
								statement.setString(6, com.ehis.util.DateUtils.getCurrentDate("DMY","en"));
								statement.setString(7, mm_item_code);
								statement.setString(8, req_store_code);
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
								String incl_excl=null;
								incl_excl=statement.getString(35);
								String	override_value=statement.getString(37);
								bl_bfr.append(checkForNull(""+statement.getString(21),"0.0")).append("::");
								bl_bfr.append(checkForNull(""+statement.getString(25),"0.0")).append("::");
								bl_bfr.append(checkForNull(""+statement.getString(38),"0.0")).append("::");
								bl_bfr.append(checkForNull(""+st_charge_based_yn,"N")).append("::");
								bl_bfr.append(incl_excl).append("::");
								bl_bfr.append(checkForNull(""+statement.getString(36),"N")).append("::");
								bl_bfr.append(checkForNull(""+"S")).append("::");//Note: when ST is on serv_panel_ind value passing as "S" for showing excl_incl value always in the screen   but there is no concept of service or panel through ST billing.
								bl_bfr.append(overridden_action_reason_code).append("::");
								bl_bfr.append(checkForNull(""+incl_excl,"E")).append("::");
								bl_bfr.append(override_value);
								bill_str = bl_bfr.toString();
								bl_bfr.setLength(0);

								}			
							}
						}
					frm_pick_list="N";	
					out.println("<script>loadDBRows_pi('"+tab+"','"+checkForNull(rst.getString("OPR_CODE"))+"','"+checkForNull(rst.getString("OPR_DESC"))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+checkForNull(rst.getString("ACC_DESC"))+"','"+checkForNull(rst.getString("TR_NO"))+"','','','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+req_store_code+"','','','','','','"+avail_stock+"','"+Store_desc+"','"+frm_pick_list+"'); </script>");	
				}//end of while loop
				}
			}
		}//else
		out.println("<script>refresh_acc('"+flag_acc+"','"+rec_implants_in_nurs_notes_yn+"','"+rec_equp_in_nurs_notes_yn+"','"+rec_instr_in_nurs_notes_yn+"','"+rec_packs_in_nurs_notes_yn+"','"+st_interface_flag+"')</script>");
		out.println("<script>assignRecId()</script>");
		
		if (!tab.equals("record_surgeon") )
		{
		/*	pstmt = con.prepareStatement(SQL_EXIST);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		pstmt.setString(3,"P");
		rst = pstmt.executeQuery();
		if(rst.next()){
			exist_rec_con=true;
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(exist_rec_con ==true)
		{*/
			/* ########################### Consumable packs Code Starts Here#########################################*/
			if(rec_packs_in_nurs_notes_yn.equals("Y"))
			{
					
					String SQL_Conspack = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',C.PACKAGE_CODE) ACC_DESC, A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PACKAGE_HDR_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'P' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PACKAGE_CODE AND C.LANGUAGE_ID=? ORDER BY BILL_SUB_REGN_LINE_NUM";//MMS-QH-CRF-0199
					

					pstmt_Conspack = con.prepareStatement(SQL_Conspack,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			pstmt_Conspack.setString(1,facility_id);
			pstmt_Conspack.setString(2,oper_num);
			pstmt_Conspack.setString(3,locale);
			
			rst_Conspack = pstmt_Conspack.executeQuery();
			
            if(rst_Conspack.next()){
					exist_rec_con=true;
		    }
			if(exist_rec_con ==true)
				{
				rst_Conspack.beforeFirst();
				index = 0;
			while(rst_Conspack.next()){
			   ++index;	
			key_cp = rst_Conspack.getString("KEY");
			key_line_cp = rst_Conspack.getString("KEY_LINE");
			//or_bean.clearBean();
			//System.err.println("bill_flag :" +bill_flag);

			if(("true").equals(bill_flag))
			{
			bill_info_conspack = or_bean.getOrderBillDtls(key_cp+key_line_cp);

			if(bill_info_conspack==null){
				bill_info_conspack = new HashMap();
				bill_info_conspack.put("key",key_cp);
				bill_info_conspack.put("key_line_no",key_line_cp);
				rst_acc_code = rst_Conspack.getString("ACC_CODE");
				bill_info_conspack.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info_conspack.put("acc_type","C");
				bill_info_conspack.put("oper_num",oper_num);
				bill_info_conspack.put("locale",locale);
				bill_info_conspack.put("module_id","OT");
				//populate billing details from OTBillingBean........	

				rst_tr_no = rst_Conspack.getString("TR_NO");
				bill_info_conspack.put("quantity",rst_tr_no);
				bill_info_conspack = billing_bean.getBillingParams(bill_info_conspack,"C");//C-> for Surgical Accessories Billing
				//bill_info.put("quantity",rst.getString("TR_NO"));
if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key_cp+key_line_cp,bill_info_conspack);
				putObjectInBean(or_bean_id,or_bean,request);
		}
			}

			String overridden_incl_excl_ind=null;

			panel_str = (String) bill_info_conspack.get("bl_panel_str");	
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("total_payable"),"0.0")).append("::");
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("patient_payable"),"0.0")).append("::");
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("charged_yn"),"N")).append("::");
			bl_bfr_conspack.append(overridden_incl_excl_ind).append("::");
			
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("preapp_yn"),"N")).append("::");
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("serv_panel_ind"))).append("::");
			bl_bfr_conspack.append(overridden_action_reason_code).append("::");
			bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("incl_excl_ind"),"E")).append("::");

			bill_str_conspack = bl_bfr_conspack.toString();
		
			bl_bfr_conspack.setLength(0); 
			}//end of if bill_flag
		String frompickli="";	
			//Added encode for REMKS on 10/27/2010 by AnithaJ
			out.println("<script>loadDBRows_conspack('"+checkForNull(rst_Conspack.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_Conspack.getString("OPR_DESC")))+"','"+checkForNull(rst_Conspack.getString("LN_NUM"))+"','"+checkForNull(rst_Conspack.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_Conspack.getString("ACC_DESC")))+"','"+checkForNull(rst_Conspack.getString("TR_NO"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_Conspack.getString("REMKS")),"UTF-8")+"','"+index+"','L','1','"+bill_str_conspack+"','"+panel_str+"','"+key_cp+"','"+key_line_cp+"','"+checkForNull(rst_Conspack.getString("REQ_STORE_CODE"))+"','"+checkForNull(rst_Conspack.getString("RESERVED_QTY"))+"','"+checkForNull(rst_Conspack.getString("REQUESTED_QTY"))+"','"+frompickli+"');</script>");

			}
			//}else if(consumable_entry_cmp_yn.equals("N")) //commented on 2/15/2011 by Anitha for 25110
			}//Below condition changed by Sanjay for SRR20056-SCF-7684 on 21-Jun-2011
			else if(("").equals(consumable_entry_cmp_yn)||("N").equals(consumable_entry_cmp_yn))
		{

			/* ########################### Consumable packs Code Starts Here#######################################*/
			
			pstmt = con.prepareStatement(PICK_LIST_EXIST_YN);
			/*SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?) AND ROWNUM=1*/
			pstmt.setString(1,facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
		//6/19/2009trace="4";
			rst = pstmt.executeQuery();
			if(rst.next()){
				pick_list=true;
			}
			if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();

			if(pick_list==true){


				pstmt_Conspack = con.prepareStatement(PICK_LIST_DEFINED_CONSPACK);
				pstmt_Conspack.setString(1,facility_id);
				pstmt_Conspack.setString(2,patient_id);
				//pstmt_Conspack.setString(3,surgeon_code);// as vishawa told to remove team_doctor_code
				pstmt_Conspack.setString(3,booking_num);
				pstmt_Conspack.setString(4,oper_num);
				rst_Conspack = pstmt_Conspack.executeQuery();
					int s=0;
					if(rst_Conspack !=null)
			{
					index=0;
			    while(rst_Conspack.next()){
					++index;	
					++s;
					line_no = (String)line_no_map.get(rst_Conspack.getString("OPR_CODE"));
					frm_pick_list=rst_Conspack.getString("FRM_PICK_LIST");
					if(frm_pick_list ==null) frm_pick_list="N";
				if(("true").equals(bill_flag))
			    {
				HashMap hash_Conspack = billing_bean.getORBillingParams(oper_num);
				catalog_code = "C#"+rst_Conspack.getString("ACC_CODE");
				key_cp = oper_num+"@"+rst_Conspack.getString("OPR_CODE")+"@S@"+rst_Conspack.getString("ACC_CODE")+s;
				key_cp1 = oper_num+"@"+rst_Conspack.getString("OPR_CODE")+"@S@"+rst_Conspack.getString("ACC_CODE");
				key_line_cp="";
				booking_date  = (String) hash_Conspack.get("service_date");
				patient_id	    = (String)hash_Conspack.get("patient_id");
				encounter_id   = (String)hash_Conspack.get("encounter_id");
				surgeon_code  = (String)hash_Conspack.get("pract_staff_id");
				patient_class   = (String)hash_Conspack.get("patient_class");
				visit_id			 =	(String)hash_Conspack.get("visit_id");
				p_qty = rst_Conspack.getString("TR_NO");
				if(p_qty == null) p_qty="";
		
				ArrayList bill_dtls_Conspack=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_conspack			 = billing_bean.formatBillingDetails(bill_dtls_Conspack);
				bill_info_conspack.putAll(hash_Conspack);
				bill_info_conspack.put("quantity",p_qty);


				//set billing details from OTBillingBean........	
				if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key_cp1,bill_info_conspack);
				putObjectInBean(or_bean_id,or_bean,request);
		}
				String overridden_incl_excl_ind=null;
				panel_str = (String) bill_info_conspack.get("bl_panel_str");	
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("total_payable"),"0.0")).append("::");
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("patient_payable"),"0.0")).append("::");
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("charged_yn"),"N")).append("::");
				bl_bfr_conspack.append(overridden_incl_excl_ind).append("::");
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("preapp_yn"),"N")).append("::");
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("serv_panel_ind"))).append("::");
				bl_bfr_conspack.append(overridden_action_reason_code).append("::");
				bl_bfr_conspack.append(checkForNull(""+bill_info_conspack.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr_conspack.toString();
				bl_bfr_conspack.setLength(0);
				}//end of if bill_flag
			out.println("<script>loadDBRows_conspack('"+checkForNull(rst_Conspack.getString("OPR_CODE"))+"','"+encode(checkForNull(rst_Conspack.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_Conspack.getString("ACC_CODE"))+"','"+encode(checkForNull(rst_Conspack.getString("ACC_DESC")))+"','"+checkForNull(rst_Conspack.getString("TR_NO"))+"','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key_cp1+"','"+key_line_cp+"','"+checkForNull(rst_Conspack.getString("REQ_STORE_CODE"))+"','"+checkForNull(rst_Conspack.getString("RESERVED_QTY"))+"','"+checkForNull(rst_Conspack.getString("REQUESTED_QTY"))+"','"+frm_pick_list+"'); </script>");	

			}//end of while loop
			}
		}else
		{

				String PICK_LIST_UNDEFINED_CONSPACK="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE,   GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.PACKAGE_CODE     = B.PACKAGE_CODE  AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL'AND A.SPECIALITY_CODE = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE    AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE     AND A.PACKAGE_CODE     = B.PACKAGE_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE  = D.OPER_SUB_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+")  AND C.OPER_CODE = D.OPER_CODE AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE  AND A.PACKAGE_CODE = B.PACKAGE_CODE";//MMS-QH-CRF-0199
			//System.err.println("PICK_LIST_UNDEFINED_CONSPACK :" +PICK_LIST_UNDEFINED_CONSPACK);

			pstmt = con.prepareStatement(PICK_LIST_UNDEFINED_CONSPACK);
			rst = pstmt.executeQuery();
			 index =0;
			while(rst.next()){
				++index;	
				line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
				HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "C#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				p_qty		= rst.getString("TR_NO");
				if(p_qty == null) p_qty="";

				if(("true").equals(bill_flag))
			    {
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","C");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",p_qty);
				bill_info.putAll(hash);
				bill_info.put("quantity",rst.getString("TR_NO"));
				//set billing details from OTBillingBean........	
				if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
		}

				String overridden_incl_excl_ind=null;

				panel_str = (String) bill_info.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"))).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
			/*oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order	*/
	out.println("<script>loadDBRows_conspack('"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")) )+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','','','','N'); </script>");	
			}//end of while loop
		if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();


	}
		
			if(rst_Conspack!=null)rst_Conspack.close();
			if(pstmt_Conspack!=null)pstmt_Conspack.close();

		}else
		{
		   out.println("<script>refresh_acc('"+flag_acc+"','"+rec_implants_in_nurs_notes_yn+"','"+rec_equp_in_nurs_notes_yn+"','"+rec_instr_in_nurs_notes_yn+"','"+rec_packs_in_nurs_notes_yn+"','"+st_interface_flag+"')</script>");
		out.println("<script>assignRecId()</script>");
		}	
		
			if(rst_Conspack !=null)rst_Conspack.close();
			if(pstmt_Conspack !=null)pstmt_Conspack.close();
			}


			/* @@@@@@@@@@@@@@@@@@@@@@@@@@@ Equipments Code Starts Here @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
		if(rec_equp_in_nurs_notes_yn.equals("Y"))
		{
			//String SQL_EQ = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.ACCESSORY_CODE) ACC_DESC, A.EQUIPMENT_ID TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE, A.Quantity actual_units,C.LOCATION LOCATION, NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI'), TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI') ) desired_date FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_EQUIPMENT C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'E' AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.EQUIPMENT_CODE"; //047546
		//SKR-SCF-0984 [IN:048580]
		String SQL_EQ = "SELECT a.oper_code opr_code, a.oper_line_num ln_num, get_desc ('"+locale+"', 'OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',a.oper_code) opr_desc, a.accessory_code acc_code,get_desc ('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',a.accessory_code) acc_desc, a.equipment_id tr_no, a.remarks remks, bill_sub_regn_num KEY,bill_sub_regn_line_num key_line, a.quantity actual_units,c.LOCATION LOCATION,DECODE (:P_languageid, 'en', NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI'),TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI')), 'th', NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI','NLS_CALENDAR=''THAI BUDDHA'''), TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI','NLS_CALENDAR=''THAI BUDDHA''')) ) desired_date,a.STATUS as OPER_LINE_STATUS FROM ot_surgical_accessories a, ot_oper_mast b, ot_equipment c WHERE a.operating_facility_id = ? AND a.oper_num = ?   AND accessory_type = 'E'   AND a.oper_code = b.oper_code   AND a.accessory_code = c.equipment_code";//MMS-QH-CRF-0199 & CRF-294
                pstmt_eq = con.prepareStatement(SQL_EQ,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);		
		pstmt_eq.setString(1,locale);
		pstmt_eq.setString(2,facility_id);
		pstmt_eq.setString(3,oper_num);
		rst_eq = pstmt_eq.executeQuery();
			if(rst_eq.next())
			{
			exist_rec_eq=true;
		}
			if(exist_rec_eq==true)
		{
		 rst_eq.beforeFirst();
		index=0;
				while(rst_eq.next())
				{
		   ++index;	
			key_eq = rst_eq.getString("KEY");
			key_line_eq = rst_eq.getString("KEY_LINE");
			rst_acc_code = rst_eq.getString("ACC_CODE");
			p_qty = rst_eq.getString("actual_units");
					if(p_qty == null)
						p_qty="";
			st_location = checkForNull(rst_eq.getString("LOCATION"));//Added for CRF 091
						desiredDate = checkForNull(rst_eq.getString("desired_date"));
			if(("true").equals(bill_flag))// added this condition by sathish on 10-01-2009 to disabling billingpart 
			{
			bill_info_eq = or_bean.getOrderBillDtls(key_eq+key_line_eq);
						if(bill_info_eq==null)
						{
				bill_info_eq = new HashMap();
				bill_info_eq.put("key",key_eq);
				bill_info_eq.put("key_line_no",key_line_eq);
				bill_info_eq.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info_eq.put("acc_type","E");
				bill_info_eq.put("oper_num",oper_num);
				bill_info_eq.put("locale",locale);
				bill_info_eq.put("module_id","OT");
				bill_info_eq.put("quantity",p_qty);
				//populate billing details from OTBillingBean........	
				bill_info_eq = billing_bean.getBillingParams(bill_info_eq,"C");//C-> for Surgical Accessories Billing
				if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key_eq+key_line_eq,bill_info_eq);
				putObjectInBean(or_bean_id,or_bean,request);
		}
				//bill_info_eq.clear();
			}
			String overridden_incl_excl_ind=null;
			panel_str = (String) bill_info_eq.get("bl_panel_str");	
			bl_bfr.append(checkForNull(""+bill_info_eq.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_eq.get("charged_yn"),"N")).append("::");
			bl_bfr.append(overridden_incl_excl_ind).append("::");
			bl_bfr.append(checkForNull(""+bill_info_eq.get("preapp_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info_eq.get("serv_panel_ind"))).append("::");
			bl_bfr.append(overridden_action_reason_code).append("::");
			bl_bfr.append(checkForNull(""+bill_info_eq.get("incl_excl_ind"),"E")).append("::");
			bill_str = bl_bfr.toString();
			bl_bfr.setLength(0);
			}//end of if bill_flag
			String from_pick="";
			//Added encode for REMKS on 10/27/2010 by AnithaJ 
					out.println("<script>loadDBRows_eq('"+checkForNull(rst_eq.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("OPR_DESC")),"UTF-8")+"','"+checkForNull(rst_eq.getString("LN_NUM"))+"','"+checkForNull(rst_eq.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst_eq.getString("TR_NO"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("REMKS")),"UTF-8")+"','"+checkForNull(rst_eq.getString("OPER_LINE_STATUS"))+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key_eq+"','"+key_line_eq+"', '"+from_pick+"','"+p_qty+"','"+st_location+"','"+desiredDate+"'); </script>");//Added(STATUS) for AMRI CRF 294
				}
		}
			else if(equipment_entry_cmp_yn.equals("")||equipment_entry_cmp_yn.equals("N"))
		{
				 /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@ Equipments packs Code StartsHer@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
			pstmt = con.prepareStatement(PICK_LIST_EXIST_YN);

			pstmt.setString(1,facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
			rst = pstmt.executeQuery();
				if(rst.next())
				pick_list=true;

				if(pstmt!=null)
					pstmt.close();
				if(rst!=null)
					rst.close();
				if(pick_list==true)
				{
			 if(rec_equp_in_nurs_notes_yn.equals("Y"))
		     {
			 pstmt_eq = con.prepareStatement(PICK_LIST_DEFINED_EQ);
			 pstmt_eq.setString(1,facility_id);
			 pstmt_eq.setString(2,patient_id);
			 //pstmt_eq.setString(3,surgeon_code);//as vishwa told to remove team_doctor_code
			 pstmt_eq.setString(3,booking_num);
			 pstmt_eq.setString(4,oper_num);
			 rst_eq = pstmt_eq.executeQuery();
			 int m=0;
			index =0;
						while(rst_eq.next())
						{
					++index;	
					++m;
					line_no = (String)line_no_map.get(rst_eq.getString("OPR_CODE"));
					frm_pick_list=rst_eq.getString("FRM_PICK_LIST");
					if(frm_pick_list ==null) frm_pick_list="N";
				HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "E#"+rst_eq.getString("ACC_CODE");
				key_eq = oper_num+"@"+rst_eq.getString("OPR_CODE")+"@S@"+rst_eq.getString("ACC_CODE")+m;
				key_eq1 = oper_num+"@"+rst_eq.getString("OPR_CODE")+"@S@"+rst_eq.getString("ACC_CODE");
					p_qty = rst_eq.getString("TR_NO");
				if(p_qty == null) p_qty="";
				st_location = checkForNull(rst_eq.getString("LOCATION"));//Added for CRF 091
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				
				if(("true").equals(bill_flag))
			    {
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_eq			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info_eq.putAll(hash);
				bill_info_eq.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
				if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key_eq1,bill_info_eq);
				putObjectInBean(or_bean_id,or_bean,request);
						}
				key_line_eq="";
				String overridden_incl_excl_ind=null;
				panel_str = (String) bill_info_eq.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info_eq.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("serv_panel_ind"))).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_eq.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
							out.println("<script>loadDBRows_eq('"+checkForNull(rst_eq.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("OPR_DESC")),"UTF-8")+"','"+line_no+"','"+checkForNull(rst_eq.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_eq.getString("ACC_DESC")),"UTF-8")+"','','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key_eq1+"','"+key_line_eq+"','"+frm_pick_list+"','"+p_qty+"','"+st_location+"','"+currentDateTime+"'); </script>");	//047546
			 }//end of while loop
						if(rst_eq!=null)
							rst_eq.close();
						if(pstmt_eq !=null)
							pstmt_eq.close();
					}
			 }
				else
			{ 
				// commented for testing------------ String PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE  A.APPLICABILITY = 'AOPR' AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE   AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC, A.NO_OF_UNITS TR_NO 	FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE   A.APPLICABILITY   = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN  ("+oper_codes.toString()+") AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION	SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY  = 'SCAT' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'  AND A.SPECIALITY_CODE       = D.OPER_GROUP_CODE  AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE  AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,  A.NO_OF_UNITS TR_NO FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY   = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE";
				String PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO ,b.location LOCATION FROM  OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE  A.APPLICABILITY = 'AOPR' AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE   AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC, A.NO_OF_UNITS TR_NO ,b.location LOCATION	FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE   A.APPLICABILITY   = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN  ("+oper_codes.toString()+") AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION	SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO ,b.location LOCATION FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY  = 'SCAT' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO ,b.location LOCATION FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'  AND A.SPECIALITY_CODE       = D.OPER_GROUP_CODE  AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE  AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,  A.NO_OF_UNITS TR_NO ,b.location LOCATION FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY   = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE";//MMS-QH-CRF-0199
				pstmt = con.prepareStatement(PICK_LIST_UNDEFINED);
				rst = pstmt.executeQuery();
					index =0;
					while(rst.next())
					{
					++index;	
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
					HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "E#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
				p_qty = rst.getString("TR_NO");
				st_location = checkForNull(rst.getString("LOCATION"));//Added for CRF 091
						if(p_qty == null)
							p_qty="";
				key_line="";
				booking_date	= (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id	= (String)hash.get("encounter_id");
				surgeon_code	= (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id		= (String)hash.get("visit_id");
	
               		 if(("true").equals(bill_flag))
			    {
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,"31/10/2007 10:00",locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","E");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",p_qty);

				bill_info.putAll(hash);
				bill_info.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
						if(from_val_overload.equals("N"))
		{
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
		}
String overridden_incl_excl_ind=null;
				panel_str = (String) bill_info.get("bl_panel_str");	
    
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"))).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
						out.println("<script>loadDBRows_eq('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")),"UTF-8")+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("ACC_CODE"))+"','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','N','"+p_qty+"','"+st_location+"','"+currentDateTime+"'); </script>");	//047546 Equipment Id
		 }//end of while loop
					if(rst!=null)
						rst.close();
					if(pstmt !=null)
						pstmt.close();
		}
			 /* @@@@@@@@@@@@@@@@@@@@@@@@@@@@ Equipments packs Code Ends Her@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/
			}
			else
		{
		   out.println("<script>refresh_acc('"+flag_acc+"','"+rec_implants_in_nurs_notes_yn+"','"+rec_equp_in_nurs_notes_yn+"','"+rec_instr_in_nurs_notes_yn+"','"+rec_packs_in_nurs_notes_yn+"','"+st_interface_flag+"')</script>");
		out.println("<script>assignRecId()</script>");
		}
			if(rst_eq!=null)
				rst_eq.close();
			if(pstmt_eq !=null)
				pstmt_eq.close();
		}
          /* @@@@@@@@@@@@@@@@@@@@@@@@@@@ Equipments Code Ends Here @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@*/

		//}
		
	/*	pstmt = con.prepareStatement(SQL_EXIST);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		pstmt.setString(3,"I");
		rst = pstmt.executeQuery();
		if(rst.next()){
			exist_rec_inst=true;
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		
		if(exist_rec_inst==true)
		{*/
		    /* $$$$$$$$$$$$$$$$$$$$$$$$$ Instrument?Cssc packs Code Starts Her$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
			if(rec_instr_in_nurs_notes_yn.equals("Y"))
			{
					String SQL_IC="";
					if(Ot_param.equalsIgnoreCase("Y")){
						SQL_IC = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ACCESSORY_CODE) ACC_DESC, A.TRAY_NO TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE, A.Quantity actual_units ,D.LOCATION LOCATION FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT_LANG_VW C, OT_INSTRUMENT D WHERE A.OPERATING_FACILITY_ID=? AND C.LANGUAGE_ID=? AND ACCESSORY_TYPE='I' AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE AND A.ACCESSORY_CODE=D.INSTR_CODE"; //MMS-QH-CRF-0199
					}
					else{
						SQL_IC = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ACCESSORY_CODE) ACC_DESC, A.TRAY_NO TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE, A.Quantity actual_units  FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND C.LANGUAGE_ID=? AND ACCESSORY_TYPE='I' AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE "; //MMS-QH-CRF-0199
					}
					 pstmt_ic = con.prepareStatement(SQL_IC,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
		//	pstmt_ic = con.prepareStatement(SQL_IC);
			pstmt_ic.setString(1,facility_id);
			pstmt_ic.setString(2,locale);
			pstmt_ic.setString(3,oper_num);

			rst_ic = pstmt_ic.executeQuery();

			if(rst_ic.next()){
			exist_rec_inst=true;
		}
		  if(exist_rec_inst==true)
	       {
			rst_ic.beforeFirst();
				index = 0;
			while(rst_ic.next()){
			   ++index;	
			key_ic = rst_ic.getString("KEY");
			key_line_ic = rst_ic.getString("KEY_LINE");
			p_qty = rst_ic.getString("actual_units");
			if(p_qty == null) p_qty="";

            if(("true").equals(bill_flag)) //added by sathish on 10-01-2009 to diable billing part when unchecked interfaced to patient billing check box in masters
			{
			bill_info_ic = or_bean.getOrderBillDtls(key_ic+key_line_ic);
			if(bill_info_ic==null){
				bill_info_ic = new HashMap();
				bill_info_ic.put("key",key_ic);
				bill_info_ic.put("key_line_no",key_line_ic);
				rst_acc_code = rst_ic.getString("ACC_CODE");
				bill_info_ic.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info_ic.put("acc_type","S");
				bill_info_ic.put("oper_num",oper_num);
				bill_info_ic.put("locale",locale);
				bill_info_ic.put("module_id","OT");
				bill_info_ic.put("quantity",p_qty);
				//populate billing details from OTBillingBean........	
				bill_info_ic = billing_bean.getBillingParams(bill_info_ic,"C");//C-> for Surgical Accessories Billing

		if(from_val_overload.equals("N"))
		{
			

				or_bean.setOrderBillDtls(key_ic+key_line_ic,bill_info_ic);
				putObjectInBean(or_bean_id,or_bean,request);
		}
			}
			String overridden_incl_excl_ind=null;
			panel_str = (String) bill_info_ic.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info_ic.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("serv_panel_ind"))).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);

			bl_bfr.setLength(0);
		    }//end of if bill_flag
			 
			 	//Added encode for REMKS on 10/27/2010 by AnithaJ
				//Added by lakshmi against CRF-0058
			if(Ot_param.equalsIgnoreCase("Y")){ out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+checkForNull(rst_ic.getString("LN_NUM"))+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("LOCATION"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("REMKS")),"UTF-8")+"','"+index+"','"+oper_num+"','L','1','"+bill_str+"','"+panel_str+"','"+key_ic+"','"+key_line_ic+"','"+frm_pick_list+"','"+p_qty+"');</script>");
							}
			else{										out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+checkForNull(rst_ic.getString("LN_NUM"))+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("TR_NO"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("REMKS")),"UTF-8")+"','"+index+"','"+oper_num+"','L','1','"+bill_str+"','"+panel_str+"','"+key_ic+"','"+key_line_ic+"','"+frm_pick_list+"','"+p_qty+"');</script>");
				}
			 
			}
			//}else if(instrument_entry_cmp_yn.equals("N")) //commented on 2/15/2011 by Anitha for 25110
			}//Below condition changed by Sanjay for SRR20056-SCF-7684 on 21 Jun 2011
			else if(instrument_entry_cmp_yn.equals("")||instrument_entry_cmp_yn.equals("N"))
		{
			   /* $$$$$$$$$$$$$$$$$$$$$$$$$ Instrument?Cssc packs Code Starts Her$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/

				pstmt = con.prepareStatement(PICK_LIST_EXIST_YN);
			/*SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?) AND ROWNUM=1*/
			pstmt.setString(1,facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
		//6/19/2009trace="4";
			rst = pstmt.executeQuery();
			if(rst.next()){
				pick_list=true;
			}
			if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();
			if(pick_list==true){
                 if(rec_instr_in_nurs_notes_yn.equals("Y"))
			    {
					  int j=0;
				if(Ot_param.equalsIgnoreCase("Y")){		
					pstmt_ic = con.prepareStatement(PICK_LIST_DEFINED_IC_SS);				
				}
				else{
					pstmt_ic = con.prepareStatement(PICK_LIST_DEFINED_IC);
				}
				 pstmt_ic.setString(1,facility_id);
				 pstmt_ic.setString(2,patient_id);
				 //pstmt_ic.setString(3,surgeon_code); as viShwa told to remove team_doctor_code from query
				 pstmt_ic.setString(3,booking_num);
				 pstmt_ic.setString(4,oper_num);
				 rst_ic = pstmt_ic.executeQuery();
				  index =0;
				 while(rst_ic.next()){
					++index;	
					++j;
					line_no = (String)line_no_map.get(rst_ic.getString("OPR_CODE"));
						frm_pick_list=rst_ic.getString("FRM_PICK_LIST");
					if(frm_pick_list ==null) frm_pick_list="N";
				
				if(("true").equals(bill_flag))
			    {
				HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "S#"+rst_ic.getString("ACC_CODE");
				key_ic = oper_num+"@"+rst_ic.getString("OPR_CODE")+"@S@"+rst_ic.getString("ACC_CODE")+j;
				key_ic1 = oper_num+"@"+rst_ic.getString("OPR_CODE")+"@S@"+rst_ic.getString("ACC_CODE");
				p_qty = rst_ic.getString("TR_NO");
				if(p_qty == null) p_qty="";
				key_line_ic="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info_ic			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info_ic.putAll(hash);
				bill_info_ic.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
						if(from_val_overload.equals("N"))
		{
			
				or_bean.setOrderBillDtls(key_ic1,bill_info_ic);
				putObjectInBean(or_bean_id,or_bean,request);
		}
String overridden_incl_excl_ind=null;
				panel_str = (String) bill_info_ic.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info_ic.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("serv_panel_ind"))).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info_ic.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end ofm if bill_flag
				//Modified for CRF-0058 by Rajesh
				if(Ot_param.equalsIgnoreCase("Y")){
					out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','"+checkForNull(rst_ic.getString("LOCATION"))+"','','"+index+"','"+oper_num+"','L','2','"+bill_str+"','"+panel_str+"','"+key_ic1+"','"+key_line_ic+"','"+frm_pick_list+"','"+p_qty+"');</script>");	
				}
				else{
					out.println("<script>loadDBRows_ic('"+checkForNull(rst_ic.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst_ic.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst_ic.getString("ACC_DESC")))+"','','','"+index+"','"+oper_num+"','L','2','"+bill_str+"','"+panel_str+"','"+key_ic1+"','"+key_line_ic+"','"+frm_pick_list+"','"+p_qty+"');</script>");	
				}
				//Modified for CRF-0058 by Rajesh	
			 }//end of while loop
			if(rst_ic!=null)		rst_ic.close();
		    if(pstmt_ic !=null)  pstmt_ic.close();
			
				}
			}else
			{
				//Query modified for CRF-0058 by Rajesh
				String PICK_LIST_UNDEFINED = "";
				if(Ot_param.equalsIgnoreCase("Y")){
				PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO, b.location  LOCATION	FROM   OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.INSTR_CODE  = B.INSTR_CODE  AND C.OPER_CODE  IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO, b.location  LOCATION  FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,A.NO_OF_UNITS TR_NO, b.location  LOCATION  FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO, b.location 	LOCATION  FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT  B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO, b.location LOCATION  FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR'  AND A.OPER_CODE  IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE";//MMS-QH-CRF-0199
				}
				else{
				PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE,GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO 	FROM   OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.INSTR_CODE  = B.INSTR_CODE  AND C.OPER_CODE  IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+")  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,A.NO_OF_UNITS TR_NO FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE  AND A.INSTR_CODE = B.INSTR_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO 	FROM OT_OPER_INSTRUMENT A, OT_INSTRUMENT  B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',C.OPER_CODE)  OPR_DESC, A.INSTR_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE', A.INSTR_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_INSTRUMENT A, OT_INSTRUMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR'  AND A.OPER_CODE  IN ("+oper_codes.toString()+") AND A.OPER_CODE = C.OPER_CODE AND A.INSTR_CODE = B.INSTR_CODE";//MMS-QH-CRF-0199
				}
				//Query modified for CRF-0058 by Rajesh
				
				pstmt = con.prepareStatement(PICK_LIST_UNDEFINED);
				rst = pstmt.executeQuery();
				index =0;
				while(rst.next()){
					++index;	
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
				if(("true").equals(bill_flag))
			    {	
				bill_info = new HashMap();
				HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "S#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
					p_qty = rst.getString("TR_NO");
					if(p_qty == null) p_qty="";
				key_line="";

				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				//ArrayList bill_dtls =or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				ArrayList bill_dtls =or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","C");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity",p_qty);
				bill_info.putAll(hash);
				bill_info.put("quantity",p_qty);
				//set billing details from OTBillingBean........	
						if(from_val_overload.equals("N"))
		{
			
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
		}
				String overridden_incl_excl_ind=null;

				panel_str = (String) bill_info.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
				bl_bfr.append(overridden_incl_excl_ind).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"))).append("::");
				bl_bfr.append(overridden_action_reason_code).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag	
			//Modified for CRF-0058 by Rajesh
			if(Ot_param.equalsIgnoreCase("Y")){
			out.println("<script>loadDBRows_ic('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("LOCATION"))+"','','"+index+"','"+oper_num+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','N','"+p_qty+"'); </script>");	
			}
			else{
				out.println("<script>loadDBRows_ic('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")))+"','','','"+index+"','"+oper_num+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','N','"+p_qty+"'); </script>");
			}
			//Modified for CRF-0058 by Rajesh
			 }//end of while loop
			 if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
		
						
		}
								
				out.println("<script>refresh_acc('"+flag_acc+"','"+rec_implants_in_nurs_notes_yn+"','"+rec_equp_in_nurs_notes_yn+"','"+rec_instr_in_nurs_notes_yn+"','"+rec_packs_in_nurs_notes_yn+"','"+st_interface_flag+"')</script>");
				out.println("<script>assignRecId()</script>");
             
			   /* $$$$$$$$$$$$$$$$$$$$$$ Instrument?Cssc packs Code Ends Her$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/
		}else
		{
		   out.println("<script>refresh_acc('"+flag_acc+"','"+rec_implants_in_nurs_notes_yn+"','"+rec_equp_in_nurs_notes_yn+"','"+rec_instr_in_nurs_notes_yn+"','"+rec_packs_in_nurs_notes_yn+"','"+st_interface_flag+"')</script>");
		out.println("<script>assignRecId()</script>");
		}
			if(rst_ic!=null)rst_ic.close();
			if(pstmt_ic!=null)pstmt_ic.close();
			//out.println("<script>refresh_acc('"+flag_acc+"','"+rec_implants_in_nurs_notes_yn+"','"+rec_equp_in_nurs_notes_yn+"','"+rec_instr_in_nurs_notes_yn+"','"+rec_packs_in_nurs_notes_yn+"','"+st_interface_flag+"')</script>");
	//		out.println("<script>assignRecId()</script>");
			}

			   /* $$$$$$$$$$$$$$$$$$$$$$ Instrument?Cssc packs Code Ends Her$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$*/


	//	}
		}
		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();


 
	
            _bw.write(_wl_block3Bytes, _wl_block3);
 if(fromval.equals("prosimplants") && rec_implants_in_nurs_notes_yn.equals("Y")) {
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
 while(rst.next()){ 
				val = rst.getString(1)+"##"+rst.getString(2);
				
			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(val));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rst.getString(3)));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rst.getString(3)));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
			
			if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
			
            _bw.write(_wl_block30Bytes, _wl_block30);
if(("Y").equals(st_interface_flag)){
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
if(("N").equals(st_interface_flag)){
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
if(("Y").equals(st_interface_flag)){
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(sale_document_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(sale_document_type));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
if(("Y").equals(st_interface_flag)){
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
if(total_stock_val>0) {
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(total_stock_val));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block53Bytes, _wl_block53);
}else {
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block61Bytes, _wl_block61);
 }else if(fromval.equals("Conspack")) {
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_flag1));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disable_flag1));
            _bw.write(_wl_block66Bytes, _wl_block66);
 while(rst.next()){ 
				val = rst.getString(1)+"##"+rst.getString(2);
				
			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(val));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rst.getString(3)));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rst.getString(3)));
            _bw.write(_wl_block69Bytes, _wl_block69);
}
			
			if(rst!=null)rst.close();
				if(pstmt!=null)pstmt.close();
			
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(disable_flag1));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disable_flag1));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(disable_flag1));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(disable_flag1));
            _bw.write(_wl_block78Bytes, _wl_block78);
 }else if(fromval.equals("equipments") && rec_equp_in_nurs_notes_yn.equals("Y"))
		 {
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_flag2));
            _bw.write(_wl_block80Bytes, _wl_block80);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block81Bytes, _wl_block81);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(disable_flag2));
            _bw.write(_wl_block84Bytes, _wl_block84);
 while(rst.next()){ 
			val = rst.getString(1)+"##"+rst.getString(2);
					
			
		
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(val));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rst.getString(3)));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rst.getString(3)));
            _bw.write(_wl_block86Bytes, _wl_block86);
}
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(disable_flag2));
            _bw.write(_wl_block89Bytes, _wl_block89);
 if(customer_id.equalsIgnoreCase("RTN")){
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(disable_flag2));
            _bw.write(_wl_block92Bytes, _wl_block92);
}else{
            _bw.write(_wl_block93Bytes, _wl_block93);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(disable_flag2));
            _bw.write(_wl_block95Bytes, _wl_block95);
}
            _bw.write(_wl_block96Bytes, _wl_block96);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(disable_flag2));
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(disable_flag2));
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(disable_flag2));
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(currentDateTime));
            _bw.write(_wl_block105Bytes, _wl_block105);
}else if(fromval.equals("InstruCSSD") && rec_instr_in_nurs_notes_yn.equals("Y")) {
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_flag3));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(disable_flag3));
            _bw.write(_wl_block66Bytes, _wl_block66);
 while(rst.next()){ 
			val = rst.getString(1)+"##"+rst.getString(2);
//			String chk_val=rst.getString(3);
			
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(val));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(rst.getString(3)));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rst.getString(3)));
            _bw.write(_wl_block69Bytes, _wl_block69);
 }
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(disable_flag3));
            _bw.write(_wl_block112Bytes, _wl_block112);
 if(Ot_param.equalsIgnoreCase("Y")){
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
}
	 else{
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(disable_flag3));
            _bw.write(_wl_block95Bytes, _wl_block95);
}
            _bw.write(_wl_block117Bytes, _wl_block117);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(disable_flag3));
            _bw.write(_wl_block119Bytes, _wl_block119);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block120Bytes, _wl_block120);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(disable_flag3));
            _bw.write(_wl_block122Bytes, _wl_block122);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(disable_flag3));
            _bw.write(_wl_block124Bytes, _wl_block124);
 if (fromvalFlag == 'Y') { 
            _bw.write(_wl_block125Bytes, _wl_block125);
 } 
            _bw.write(_wl_block126Bytes, _wl_block126);
}
            _bw.write(_wl_block127Bytes, _wl_block127);
if(rec_implants_in_nurs_notes_yn=="Y" || rec_instr_in_nurs_notes_yn=="Y" || rec_packs_in_nurs_notes_yn=="Y" || rec_equp_in_nurs_notes_yn=="Y") {
				if(!imgUrl.equals("")){ 
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block129Bytes, _wl_block129);
}
				}
            _bw.write(_wl_block130Bytes, _wl_block130);

		}catch(Exception e){
		 System.err.println("Err Msg in InstrumentRecord"+e.getMessage());
		 e.printStackTrace();
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(rst_Conspack!=null)rst_Conspack.close();
			if(pstmt_Conspack!=null)pstmt_Conspack.close();
			if(pstmt_room!=null)pstmt_room.close();
			if(rst_room!=null)rst_room.close();
			if(rset!=null)rset.close();
			if(pstmt_bl!=null)pstmt_bl.close();
			if(pstmt_doc_type!=null)pstmt_doc_type.close();
			if(rst_acc_reqyn!=null)   rst_acc_reqyn.close();
			if(pstmt_acc_reqyn!=null) pstmt_acc_reqyn.close();
			if(pstmt_req_store!=null) pstmt_req_store.close();
			if(stmt!=null) stmt.close();
			if(pstmt_st!=null) pstmt_st.close();
			if(rst_bl!=null) rst_bl.close();
			if(rset_req_store!=null) rset_req_store.close();
			if(rset_doc_type!=null) rset_doc_type.close();
			if(rst_eq!=null)		rst_eq.close();
			if(rst_ic!=null)		rst_ic.close();
		    if(pstmt_ic !=null)  pstmt_ic.close();
		    if(pstmt_eq !=null)  pstmt_eq.close();
			 
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){
			System.err.println("4056,Err Msg in Pros=========="+e.getMessage());		 
		 	e.printStackTrace();
		}
	}
  
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(bill_flag));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(rec_implants_in_nurs_notes_yn));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(rec_equp_in_nurs_notes_yn));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(rec_instr_in_nurs_notes_yn));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(rec_packs_in_nurs_notes_yn));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(st_interface_flag));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(oper_room_code));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(fromval));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(onLoadFlag));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(bl_episode_type));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(mm_item_code));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(item_id));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(Ot_param));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(fromvalFlag));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(customer_id));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(oneWeekDate));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(checkInTime));
            _bw.write(_wl_block154Bytes, _wl_block154);
 // if (fromvalFlag == 'Y') { 
            _bw.write(_wl_block155Bytes, _wl_block155);
 //} 
            _bw.write(_wl_block156Bytes, _wl_block156);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AccessoryType.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProsthesisImplants.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumablePacks.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Equipments.Label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InstrumentsCSSDPacks.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Implant.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumptionStore.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Manufacturer.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Batch.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ReservedPicklistUnits.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RequestedPicklistUnits.Label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.StockAvailable.Label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AccessoryType.Label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProsthesisImplants.Label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumablePacks.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Equipments.Label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InstrumentsCSSDPacks.Label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Package.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AccessoryType.Label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProsthesisImplants.Label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumablePacks.Label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Equipments.Label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InstrumentsCSSDPacks.Label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.EquipmentID.Label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DateTime.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AccessoryType.Label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ProsthesisImplants.Label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ConsumablePacks.Label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Equipments.Label", java.lang.String .class,"key"));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InstrumentsCSSDPacks.Label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.operation.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Instrument.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TrayNo.label", java.lang.String .class,"key"));
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
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ActualUnits.Label", java.lang.String .class,"key"));
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
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
