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
import webbeans.eCommon.ConnectionManager;
import java.util.HashMap;
import eOR.OrderEntryBillingQueryBean;
import eOT.OTBillingBean;
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

public final class __equipmentsrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/EquipmentsRecord.jsp", 1709120212000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/RecordNursing.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/Equipment.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script language=\'javascript\'>\nfunction Class_row()\n{\n  this.oper_code =\"\";\n  this.oper_desc=\"\";\n  this.equip_code=\"\";\n  this.equip_desc=\"\";\n  this.oper_line_no =\"\";\n  this.equip_id =\"\";\n  this.remarks =\"\";\n  this.order=\"\";\n  this.accessory_type=\"\";\n  this.db_mode=\"\";\n  this.recId=\"\";\n  this.bill_str=\"\";\n  this.panel_str=\"\";\n  this.key=\"\";\n  this.key_line=\"\";\n   this.rate=\"\";\n\tthis.desiredDate=\"\";//47546\n}\n\nfunction callPopulateList(flag){}\n\nfunction loadCodes(){\n\tvar formObj = document.EquipmentRecordForm;\n\tvar codes =  formObj.operation.value;\n\tvar arr = codes.split(\"##\");\n\t//alert(arr);\n\tformObj.oper_code.value=arr[0];\n\tformObj.oper_line_no.value=arr[1];\n}\n\nfunction assignCodes(obj){\n\tvar formObj = document.EquipmentRecordForm;\n\tvar codes =  obj.value;\n    var arr = codes.split(\"##\");\n\t//alert(arr);\n\tformObj.oper_code.value=arr[0];\n\tformObj.oper_line_no.value=arr[1];\n}\n\nfunction DeleteKey(key){\n\t//alert(param);\n\tvar xmlStr =\"<root></root>\";\n\tvar temp_jsp=\"DeletePersistenceBeankey.jsp?del_key=\"+key;\n\t//alert(temp_jsp);\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText) ;\n\t//alert(responseText);\n\treturn responseText;\n}\n\n/*function disableDocLevel(){\n   var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n   formObj.doc_level.disabled=true;\n}*/\n\nfunction loadDBRows(oper_code,oper_desc,line_no,instr_code,instr_desc,tray_no,remarks,index,mode,order,bill_str,panel_str,key,key_line,quantity, desiredDate){ //47546\n\t//alert(\"bill_str--->\"+bill_str);\n  var objrow = newRow();\n  var rows=parent.parent.parent.ObjectCollect.equipment_rows;\n  var rowLength=parent.parent.parent.ObjectCollect.equipment_len;\n  if(mode==\'L\' && rowLength==0){\n\t  objrow.oper_code=oper_code;\n\t  objrow.oper_desc=decodeURIComponent(oper_desc,\"UTF-8\").replace(/\\+/g,\" \");\n\t  objrow.equip_code=instr_code;\t  \n\t  objrow.equip_desc=decodeURIComponent(instr_desc,\"UTF-8\").replace(/\\+/g,\" \");\n\t  objrow.oper_line_no=line_no;\n\t  objrow.equip_id=tray_no;\n\t  objrow.quantity=quantity;\n\t  objrow.remarks=decodeURIComponent(remarks,\"UTF-8\").replace(/\\+/g,\" \");\n\t  objrow.recId = index;\n\t  objrow.db_mode=(order==1)?\"L\":\"I\";\n\t  objrow.order = order;\n\t  objrow.bill_str=bill_str;\n\t  objrow.panel_str=panel_str;\n\t  objrow.key=key;\n\t  objrow.key_line=key_line;\n\t  objrow.desiredDate=desiredDate;//47546\n\t  objrow.rate=\"\";\n\t  rows.push(objrow);\n\t  //alert(rows.toString());\n\t }\n\t \n}\nfunction refresh(){\n\t var formObj = document.EquipmentRecordForm;\n\t var params = formObj.params.value;\n\t parent.ResultsFrame.location.href=\'../../eOT/jsp/EquipmentsDtls.jsp?\'+params;\n}\n\nfunction addRow(){\n\tvar objrow = newRow();\n  var msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n  var rows=parent.parent.parent.ObjectCollect.equipment_rows;\n  var formObj = document.EquipmentRecordForm;\n  var params = formObj.params.value;\n  var mode =formObj.mode.value;\n  var obj = formObj.operation;\n  var bill_flag=document.forms[0].bill_flag.value;\n  var key = formObj.oper_num.value+\"@\"+formObj.oper_code.value+\"@E\"+\"@\"+formObj.equip_code.value;\n  if(chkEmpty()){\n\tif(mode==\'I\'){\n\t   if(alreadyExist()){\n\t\tif(bill_flag==\"true\")  // added by sathish to disable Billing part\n\t\t{\n\t\tvar retVal = callOrderLineCreation();\n\t\tretVal=trimString(retVal);\n\t\tvar arr = retVal.split(\"@@\");\n\t\tif(arr[0]==\"BL0639\"){\n\t\t\talert(getMessage(\"BL0639\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif(localTrimString(arr[2])!=\'\')\n\t\t\t{\n\t\t\tvar err_pat=localTrimString(arr[2]);\n\t\t\talert(err_pat);\n\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\t\tobjrow.oper_code=formObj.oper_code.value;\n\t\t\tobjrow.oper_desc=formObj.operation.options[obj.selectedIndex].text;\n\t\t\tobjrow.equip_code=formObj.equip_code.value;\n\t\t\tobjrow.equip_desc=formObj.equip_desc.value;\n\t\t\tobjrow.oper_line_no = formObj.oper_line_no.value;\n\t\t\tobjrow.equip_id = formObj.equip_id.value;\n\t\t\tobjrow.remarks = formObj.remarks.value;\n\t\t\t//ADDED FOR BILLING\n\t\t\t/*var retVal = callOrderLineCreation();\n\t\t\tvar arr = retval.split(\"@@\");\n\t\t\tpanel_str = arr[0];\n\t\t\tbill_str = arr[1];*/\n\t\t\tobjrow.recId = getRecId();\n\t\t\tobjrow.db_mode=\"I\";\n\t\t\t//var retVal = callOrderLineCreation();\n\t\t\tif(bill_flag==\"true\")\n\t\t    {\n\t\t\tvar arr = retVal.split(\"@@\");\n\t\t\tobjrow.panel_str = arr[0];\n\t\t\tobjrow.bill_str = arr[1];\n\t\t\t}\n\t\t\tobjrow.key=key;\n\t\t\tobjrow.key_line=\"\";\n\t\t\trows.push(objrow);\n\t\t\tresetFields();\n\t\t\tparent.ResultsFrame.location.href=\'../../eOT/jsp/EquipmentsDtls.jsp?\'+params;\n\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t\n\t} else{\n\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t}\n\t}else\n\t  updateRow();\n  }\n}\n\n\nfunction callOrderLineCreation(){\n\tvar formObj = document.forms[0];\n\tvar oper_num = formObj.oper_num.value;\n\tvar equip_code = formObj.equip_code.value;\n\tvar oper_code = (formObj.operation.value).split(\"##\")[0];\n\tvar param = \"oper_num=\"+oper_num+\"&acc_type=E&called_from=ACC_TAB&acc_code=\"+equip_code+\"&oper_code=\"+oper_code;\n\t//alert(param);\n\tvar xmlStr =\"<root></root>\";\n\tvar temp_jsp=\"OTOrderLineCreation.jsp?\"+param;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText) ;\n\t//alert(responseText);\n\treturn responseText;\n}\n\nfunction newRow(){\n  var objrow = new Class_row();\n   return(objrow);\n}\n\nfunction alreadyExist(){\n\tvar formObj = document.EquipmentRecordForm;\n\tvar codeDtl = parent.ResultsFrame.code; \n\tvar oper_code=formObj.oper_code.value;\n\tvar equip_code = formObj.equip_code.value;\n\tvar codeRecord = oper_code+equip_code;\n\tif(codeDtl.indexOf(codeRecord)>=0)\n\t   return false;\n\telse\n\t  return true;\n}\n\n function assignRecId(){\n\tvar rows = parent.parent.parent.ObjectCollect.equipment_rows;\n\tparent.parent.parent.ObjectCollect.equipment_len=rows.length;\n}\n\nfunction getRecId(){\n    var rowLength=parent.parent.parent.ObjectCollect.equipment_len;\n\tvar recId = rowLength+1;\n\tparent.parent.parent.ObjectCollect.equipment_len = recId;\n\treturn recId;\n}\n\nfunction chkEmpty(){\n\tvar formObj = document.EquipmentRecordForm;\n\tvar fields = new Array(formObj.operation,formObj.equip_desc);\n\tvar operation_title=getLabel(\"Common.operation.label\",\"common\");\n\tvar equipment_title=getLabel(\"Common.equipment.label\",\"common\");\n\tvar names = new Array(operation_title,equipment_title);\n\tvar messageFrame = parent.parent.parent.messageFrame;\n\tif(checkFields( fields, names, messageFrame))\n\t\treturn true;\n}\n\nfunction removeRow(){\n\nvar formObj = document.EquipmentRecordForm;\nvar params = formObj.params.value;\nvar rows=parent.parent.parent.ObjectCollect.equipment_rows;\nvar recId = document.forms[0].recId.value;\nvar mode = document.forms[0].mode.value;\nif(rows.length>0 && mode==\'U\'){        \n  for(var jj=0;jj<rows.length;jj++){\n\t if(rows[jj]!=null){\n\t\t //alert(\"rows[jj].order--->\"+rows[jj].order)\n\t\tif(rows[jj].recId==recId){\n\t\t\tDeleteKey(rows[jj].key+rows[jj].key_line);\n\t\t\tif( (rows[jj].db_mode==\'L\' || rows[jj].db_mode==\'U\') && (rows[jj].order==\'1\' ) )\n\t\t\t {rows[jj].db_mode=\'D\';}\n\t\t\t else\n\t\t\t  delete rows[jj];\n\t\t\t   break;\n\t\t}\n\t }else\n\tcontinue;\n }//end for-Loop\n resetFields();\n parent.ResultsFrame.location.href=\'../../eOT/jsp/EquipmentsDtls.jsp?\'+params;\n parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n}else\n   resetFields();\n}\n\nfunction updateRow(){\n\tvar formObj = document.EquipmentRecordForm;\n\tvar params = formObj.params.value;\n\tvar\tequip_code=formObj.equip_code.value;\n\tvar\tequip_desc=formObj.equip_desc.value;\n\tvar\tequip_id = formObj.equip_id.value;\n\tvar\tremarks = formObj.remarks.value;\n\tvar mode =formObj.mode.value;\n\tvar recId = formObj.recId.value;\n\tvar rows=parent.parent.parent.ObjectCollect.equipment_rows;\n\t\tif(rows.length>0 && mode==\'U\'){        \n\t\t\tfor(var jj=0;jj<rows.length;jj++){\n\t\t\t\tif(rows[jj]!=null) {\n\t\t\t\t\tif(rows[jj].recId==recId){\n\t\t\t\t\t\t//rows[jj].equip_code=equip_code;\n\t\t\t\t\t\t//rows[jj].equip_desc=equip_desc;\t\n\t\t\t            rows[jj].equip_id=equip_id;\n\t\t\t\t\t\trows[jj].remarks=remarks;\n\t\t\t           if(rows[jj].db_mode==\'L\' && rows[jj].order==\'1\'){\n\t\t\t\t\t\t   //alert(\"In order 1\");\n\t\t\t\t\t\t\trows[jj].db_mode=\'U\';\n\t\t\t\t\t\t}else if(rows[jj].db_mode==\'L\' && rows[jj].order==\'2\'){\n\t\t\t\t\t\t\t//alert(\"In order 2\");\n\t\t\t\t\t\t\trows[jj].db_mode=\'I\';\n\t\t\t\t\t\t}else if(rows[jj].db_mode==\'L\' && rows[jj].order==\'3\'){\n\t\t\t\t\t\t\t//alert(\"In order 3\");\n\t\t\t\t\t\t\trows[jj].db_mode=\'I\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t         }else  \n\t\t\tcontinue;\n\t\t }\n      resetFields();\n\t  parent.ResultsFrame.location.href=\'../../eOT/jsp/EquipmentsDtls.jsp?\'+params;\n\t}\n}\n\nfunction splitString(strVal){\n    var arr = strVal.split(\'::\');\n\tvar formObj = document.EquipmentRecordForm;\n\tformObj.oper_code.value=arr[0];\n\tformObj.operation.value=arr[1];\n\tformObj.oper_line_no.value = arr[2];\n\tformObj.equip_code.value=arr[3];\n\tformObj.equip_desc.value=arr[4];\n\tformObj.remarks.value=arr[5];\n\tformObj.equip_id.value=arr[6];\n\tformObj.recId.value = arr[7];\n\tformObj.mode.value = arr[8];\n\tformObj.operation.disabled=true;\n\tformObj.EquipmentLookUp.disabled=true;\n\t\n}\n\nfunction resetFields(){\n\tvar formObj = document.EquipmentRecordForm;\n\t//formObj.operation.value=formObj.operation.value;\n\tformObj.equip_code.value=\'\';\n\tformObj.equip_desc.value=\'\';\n\tformObj.oper_code.value=\'\';\n\tformObj.equip_id.value=\'\';\n\tformObj.remarks.value=\'\';\n\tformObj.mode.value=\'I\';\n\tformObj.operation.disabled=false;\n\tformObj.EquipmentLookUp.disabled=false;\n    formObj.operation.focus();\n\t//frmObj.InstrumentLookUp.disabled=false;\n\t\n}\n\nfunction localTrimString(sInString) {\n  return sInString.replace(/^\\s+|\\s+$/g,\"\");\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onLoad=\"loadCodes();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name = \'EquipmentRecordForm\'>\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\n<table border=\'0\' cellpadding=3 cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n\t \n<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\n     <td class=\"fields\" width=\"25%\" >\n\t\t<select name=\"operation\" id=\"operation\" ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" >\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<option value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' > ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="  </option>\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</select>\n\t <img src=\'../../eCommon/images/mandatory.gif\'></img>\n    </td>\n <!-- </tr> -->\n\t\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\n\n<!-- <tr> --> \n\t  <td class=\"label\" width=\"25%\" >\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \n\t  </td>\n\t  <td width=\"25%\" class=\"fields\">\n\t\t  <input type=\'hidden\' name=\'equip_code\' id=\'equip_code\' > \n\t\t  <input type=\'text\' name=\'equip_desc\' id=\'equip_desc\' disabled> \n\t\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'EquipmentLookUp\' id=\'EquipmentLookUp\' onClick=\'searchEquipments(equip_code,equip_desc);\' ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t  </td>\n </tr>\n<tr>\n\t <td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="  </td>\n     <td width=\"25%\" class=\"fields\">\n\t\t<input type=\'text\' name=\'equip_id\' id=\'equip_id\' maxlength=\'20\' size=\'20\' ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" > \n\t</td>\n<!-- </tr>\n\n<tr> -->\n\t <td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" </td>\n     <td width=\"25%\" class=\"fields\">\n\t\t<textarea name=\'remarks\' ROWS=\'3\' COLS=\'40\' onBlur=\"checkLimit(this,100)\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" > </textarea>\n\t</td>\n</tr>\n\t<td class=\"label\" width=\"25%\"></td>\n\t<td class=\"label\" width=\"25%\"></td>\n\t<td class=\"label\" width=\"25%\"></td>\n\t<td class=\"fields\" width=\"25%\">\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' onClick=\'assignCodes(document.forms[0].operation);addRow();\'  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  >\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onClick=\'removeRow();\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >\n\t</td>\n</tr>\n</table>\n\n<!-- added by Sathish for Amazon Changes-->\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t<!-- end -->\n<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\'hidden\' name=\'oper_code\' id=\'oper_code\' value=\'\'>\n<input type=\'hidden\' name=\'oper_line_no\' id=\'oper_line_no\' value=\'\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type=\'hidden\' name=\'bill_flag\' id=\'bill_flag\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );
 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

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

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

	
	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	

	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;
	


	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");

	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 String params = request.getQueryString(); 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(params));
            _bw.write(_wl_block9Bytes, _wl_block9);
  String bill_flag = request.getParameter("bill_flag");
	String p_qty = "";
	//String called_from =  checkForNull(request.getParameter("called_from"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String booking_num = checkForNull(request.getParameter("booking_num"));
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	String key = "";
	String key_line="";
	String desiredDate = "";//47546
	String bill_str="";
	String panel_str="";
	HashMap bill_info=new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	StringBuffer oper_codes = new StringBuffer();
	String order_id="";
	String order_line_num="";
	String booking_date  = "";
	String encounter_id   = "";
	String patient_class   = "";
	String visit_id   = "";
	String catalog_code   = "";
	String rst_acc_code = "";
	HashMap line_no_map = new HashMap();
	String line_no="";
	boolean exist_rec = false;
	boolean pick_list = false;
	String  nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String currentDateTime = com.ehis.util.DateUtils.getCurrentDate("DMYHM", locale);//47546
	String disable_flag="";
	if( nursing_doc_comp_yn.equals("Y") )
	  disable_flag="disabled";
	 else 
	   disable_flag="";
	
	String SQL_EXIST = "SELECT ACCESSORY_CODE FROM OT_SURGICAL_ACCESSORIES WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND ROWNUM=1";
	//this query checks whether we have already record in OT_PICK_LISTS Table if returns true="PICK_LIST_DEFINED Qry is executed otherwise PICKlIST_UNDEFINED Qry is executed"
	String PICK_LIST_EXIST_YN = "SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?)";
	String PICK_LIST_DEFINED="SELECT A.OPER_CODE OPR_CODE,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC ,A.ITEM_ID ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.ITEM_ID)  ACC_DESC,A.ITEM_QTY TR_NO FROM  OT_PICK_LISTS A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.TEAM_DOCTOR_CODE  = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'E' AND A.ITEM_ID = B.EQUIPMENT_CODE";
	String PICK_LIST_UNDEFINED="";
	//String SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.ACCESSORY_CODE) ACC_DESC, A.EQUIPMENT_ID TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE, A.Quantity actual_units, NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI'), TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI') ) desired_date  FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_EQUIPMENT C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'E' AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.EQUIPMENT_CODE";
	//SKR-SCF-0984 [IN:048580]
	//Modified against MMS-QH-CRF-0199
	String SQL ="SELECT a.oper_code opr_code, a.oper_line_num ln_num,get_desc ('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',a.oper_code) opr_desc, a.accessory_code acc_code,get_desc ('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',a.accessory_code) acc_desc,a.equipment_id tr_no, a.remarks remks, bill_sub_regn_num KEY,bill_sub_regn_line_num key_line, a.quantity actual_units, DECODE (?, 'en', NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI'),TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI') ), 'th', NVL (TO_CHAR (desired_date, 'DD/MM/YYYY HH24:MI','NLS_CALENDAR=''THAI BUDDHA'''),TO_CHAR (a.added_date, 'DD/MM/YYYY HH24:MI','NLS_CALENDAR=''THAI BUDDHA''') ) ) desired_date  FROM ot_surgical_accessories a, ot_oper_mast b, ot_equipment c WHERE a.operating_facility_id =? AND a.oper_num = ? AND accessory_type = 'E' AND a.oper_code = b.oper_code  AND a.accessory_code = c.equipment_code";
	String SQL1 = "SELECT A.OPER_CODE OPR_CODE,A.OPER_LINE_NUM LN_NUM,GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B WHERE B.LANGUAGE_ID = ? AND OPERATING_FACILITY_ID=? AND OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE";
	Connection con = null;
	PreparedStatement pstmt = null;
	String val= "";
	ResultSet rst = null;
	
	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2")) ;

		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
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

		if(rst!=null)		rst.close();
		if(pstmt !=null)  pstmt.close();

		pstmt = con.prepareStatement(SQL_EXIST);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		if(rst.next()){
			exist_rec=true;
		}
		if(rst!=null)		rst.close();
		if(pstmt !=null)  pstmt.close();
		if(exist_rec==true){
		pstmt = con.prepareStatement(SQL);		
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
		   ++index;	
			
			key = rst.getString("KEY");
			key_line = rst.getString("KEY_LINE");
			desiredDate = checkForNull(rst.getString("desired_date"));//47546
			//or_bean.clearBean();
			if(("true").equals(bill_flag))// added this condition by sathish on 10-01-2009 to disabling billingpart 
			{
			bill_info = or_bean.getOrderBillDtls(key+key_line);
			if(bill_info==null){
				bill_info = new HashMap();
				bill_info.put("key",key);
				bill_info.put("key_line_no",key_line);
				rst_acc_code = rst.getString("ACC_CODE");
				bill_info.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info.put("acc_type","E");
				bill_info.put("oper_num",oper_num);
				bill_info.put("locale",locale);
				bill_info.put("module_id","OT");
				bill_info.put("quantity","1");
				//populate billing details from OTBillingBean........	
				bill_info = billing_bean.getBillingParams(bill_info,"C");//C-> for Surgical Accessories Billing
/*test code		
				catalog_code = "E#"+rst_acc_code;
				ArrayList bill_dtls=or_bean.getBillChargeDetails("1",catalog_code,(String)bill_info.get("service_date"),locale,order_id,order_line_num,patient_id,(String)bill_info.get("encounter_id"),(String)bill_info.get("patient_class"),(String)bill_info.get("pract_staff_id"));	
				bill_info	= billing_bean.formatBillingDetails(bill_dtls);
				bill_info.putAll(bill_info);
			//set billing details from OTBillingBean........	
// test code ends here  */

				or_bean.setOrderBillDtls(key+key_line,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
				//bill_info.clear();
			}
			panel_str = (String) bill_info.get("bl_panel_str");	
			bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N"));
			bill_str = bl_bfr.toString();
			
			bl_bfr.setLength(0);
			
			}//end of if bill_flag
			out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("TR_NO"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("REMKS")),"UTF-8")+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst.getString("actual_units"))+"','"+desiredDate+"'); </script>");	//47546

		}
		if(rst!=null)		rst.close();
		if(pstmt !=null)  pstmt.close();
		out.println("<script>refresh()</script>");
		out.println("<script>assignRecId()</script>");
	}else if(nursing_doc_comp_yn.equals("N")){

			
		pstmt = con.prepareStatement(PICK_LIST_EXIST_YN);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,booking_num);
		pstmt.setString(3,oper_num);
		
		rst = pstmt.executeQuery();
		if(rst.next()){
			pick_list=true;
		}
		if(rst!=null)		rst.close();
		if(pstmt !=null)  pstmt.close();
		if(pick_list==true){
			 pstmt = con.prepareStatement(PICK_LIST_DEFINED);
			 //pstmt.setString(1,locale);
			 pstmt.setString(1,facility_id);
			 pstmt.setString(2,patient_id);
			 pstmt.setString(3,surgeon_code);
			 pstmt.setString(4,booking_num);
			 pstmt.setString(5,oper_num);
			 rst = pstmt.executeQuery();
			 while(rst.next()){
					++index;	
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
					
				HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "E#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
				key_line="";
				booking_date  = (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id   = (String)hash.get("encounter_id");
				surgeon_code  = (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id			 =	(String)hash.get("visit_id");
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				if(("true").equals(bill_flag))
			    {
				ArrayList bill_dtls=or_bean.getBillChargeDetails("1",catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info.putAll(hash);
				bill_info.put("quantity","1");
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
				panel_str = (String) bill_info.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
			 out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")),"UTF-8")+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','','"+currentDateTime+"'); </script>");	//47546
			 }//end of while loop
			 if(rst!=null)		rst.close();
		if(pstmt !=null)  pstmt.close();
			out.println("<script>refresh()</script>");
			out.println("<script>assignRecId()</script>");
		} else {
				
				/*PICK_LIST_UNDEFINED="SELECT A.OPER_CODE OPR_CODE,C.SHORT_DESC OPR_DESC,A.EQUIPMENT_CODE ACC_CODE,B.SHORT_DESC ACC_DESC, A.NO_OF_UNITS TR_NO FROM   OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE  A.OPER_CODE IN ("+oper_codes.toString()+") AND A.EQUIPMENT_CODE = B.EQUIPMENT_CODE AND A.OPER_CODE = C.OPER_CODE";*/
				
				/*PICK_LIST_UNDEFINED="SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY        = 'AOPR'     AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE   AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO 	FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY   = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN  ("+oper_codes.toString()+") AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION		SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, 	  B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY  = 'SCAT'     AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE    AND D.OPER_CODE            IN ("+oper_codes.toString()+") AND C.OPER_CODE           = D.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'  AND A.SPECIALITY_CODE       = D.OPER_GROUP_CODE  AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE  AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  B.SHORT_DESC ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY   = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE";*/

				PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE  A.APPLICABILITY = 'AOPR' AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE   AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC, A.NO_OF_UNITS TR_NO 	FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE   A.APPLICABILITY   = 'SSPL' AND A.SPECIALITY_CODE   = C.SPECIALITY_CODE AND C.OPER_CODE IN  ("+oper_codes.toString()+") AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION	SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY  = 'SCAT' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE AND D.OPER_CODE IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,   A.NO_OF_UNITS TR_NO  FROM OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB'  AND A.SPECIALITY_CODE       = D.OPER_GROUP_CODE  AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE = D.OPER_SUB_CAT_CODE AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE = D.OPER_CODE  AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.EQUIPMENT_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.EQUIPMENT_CODE) ACC_DESC,  A.NO_OF_UNITS TR_NO FROM    OT_OPER_EQUIPMENT A, OT_EQUIPMENT B, OT_OPER_MAST C WHERE A.APPLICABILITY   = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE AND A.EQUIPMENT_CODE  = B.EQUIPMENT_CODE";
				
			
				pstmt = con.prepareStatement(PICK_LIST_UNDEFINED);
				rst = pstmt.executeQuery();
				while(rst.next()){
					++index;	
					
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));

					//HashMap hash = billing_bean.getORBillingParams(oper_num);
					HashMap hash = billing_bean.getORBillingParams(oper_num);
				catalog_code = "E#"+rst.getString("ACC_CODE");
				key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
				key_line="";
				booking_date	= (String) hash.get("service_date");
				patient_id	    = (String)hash.get("patient_id");
				encounter_id	= (String)hash.get("encounter_id");
				surgeon_code	= (String)hash.get("pract_staff_id");
				patient_class   = (String)hash.get("patient_class");
				visit_id		= (String)hash.get("visit_id");
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
                if(("true").equals(bill_flag))
			    {
				ArrayList bill_dtls=or_bean.getBillChargeDetails("1",catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,"31/10/2007 10:00",locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
					hash.put("key",key);
					hash.put("key_line_no",key_line);
					hash.put("oper_code",rst.getString("ACC_CODE"));//pass acc_code in oper_code
					hash.put("acc_type","E");
					hash.put("oper_num",oper_num);
					hash.put("locale",locale);
					hash.put("quantity","1");
				bill_info.putAll(hash);
				bill_info.put("quantity","1");
				//set billing details from OTBillingBean........	
				or_bean.setOrderBillDtls(key,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);

				panel_str = (String) bill_info.get("bl_panel_str");	
				bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
				bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N"));
				bill_str = bl_bfr.toString();
				bl_bfr.setLength(0);
				}//end of if bill_flag
					
		out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")),"UTF-8")+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','','"+currentDateTime+"'); </script>");	//47546
			 }//end of while loop
			 if(rst!=null)		rst.close();
		if(pstmt !=null)  pstmt.close();
			out.println("<script>refresh()</script>");
			out.println("<script>assignRecId()</script>");

		}//end of if loop 
			
	}
	 else
		{
		   out.println("<script>refresh()</script>");
		   out.println("<script>assignRecId()</script>");
		}
		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
		rst = pstmt.executeQuery();
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block12Bytes, _wl_block12);
 while(rst.next()){ 
			//OPR_CODE + LN_NO
			val = rst.getString(1)+"##"+rst.getString(2);
					
			
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(val));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(rst.getString(3)));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

		}catch(Exception e){
		 System.err.println("EQP Record: Err Msg in EquipmentRecord"+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
  
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(bill_flag));
            _bw.write(_wl_block33Bytes, _wl_block33);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.equipment.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.EquipmentID.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
