package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.HashMap;
import eOR.OrderEntryBillingQueryBean;
import eOT.OTBillingBean;

public final class __consumablepacksrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ConsumablePacksRecord.jsp", 1721888318000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10_0 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/RecordNursing.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<!-- <Script Language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></Script> -->\n<!-- <script language=\"javascript\" src=\"../../eOT/js/OTMessages.js\"></script> --> \n\n\n<script language=\'javascript\'>\n\nfunction Class_row()\n{\n  this.oper_code =\"\";\n  this.oper_desc=\"\";\n  this.package_code=\"\";\n  this.package_desc=\"\";\n  this.oper_line_no =\"\";\n  this.quantity =\"\";\n  this.remarks =\"\";\n  this.order=\"\";\n  this.accessory_type=\"\";\n  this.db_mode=\"\";\n  this.recId=\"\";\n  this.bill_str=\"\";\n  this.panel_str=\"\";\n  this.key=\"\";\n  this.key_line=\"\";\n  this.rate=\"\";\n}\n\n/*function disableDocLevel(){\n   var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n   formObj.doc_level.disabled=true;\n}*/\n\nfunction callPopulateList(flag){}\n\nfunction loadCodes(){\n\tvar formObj = document.PacksRecordForm;\n\tvar codes =  formObj.operation.value;\n    var arr = codes.split(\"##\");\n\t//alert(arr);\n\tformObj.oper_code.value=arr[0];\n\tformObj.oper_line_no.value=arr[1];\n}\n\nfunction assignCodes(obj){\n\tvar formObj = document.PacksRecordForm;\n\tvar codes =  obj.value;\n    var arr = codes.split(\"##\");\n\t//alert(arr);\n\tformObj.oper_code.value=arr[0];\n\tformObj.oper_line_no.value=arr[1];\n}\n\nfunction loadDBRows(oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order,bill_str,panel_str,key,key_line){ \n  var objrow = newRow();\n  //alert(\"order-110-->\"+order);\n  var rows=parent.parent.parent.ObjectCollect.packs_rows;\n  var rowLength=parent.parent.parent.ObjectCollect.packs_len;\n  if(mode==\'L\' && rowLength==0){\n\t  objrow.oper_code=oper_code;\n\t  objrow.oper_desc=unescape(oper_desc);\n\t  objrow.package_code=package_code;\n\t  objrow.package_desc=unescape(package_desc);\n\t  objrow.oper_line_no=line_no;\n\t  objrow.quantity=quantity;\n\t  objrow.remarks=remarks;\n\t  objrow.recId = index;\n\t  //objrow.db_mode=\"L\";\n\t  objrow.db_mode=(order==1)?\"L\":\"I\";\n\t  objrow.order = order;\n\t  objrow.bill_str=bill_str;\n\t  objrow.panel_str=panel_str;\n\t  objrow.key=key;\n\t  objrow.key_line=key_line;\n\t  objrow.rate=\"\";\n\t  rows.push(objrow);\n\t  \n\t  }\n}\n\n\nfunction refresh(){\n\t var formObj\t\t\t= document.PacksRecordForm;\n\t var params\t\t\t\t= formObj.params.value;\n\t parent.ResultsFrame.location.href=\'../../eOT/jsp/ConsumablePacksDtls.jsp?\'+params;\n}\n\nfunction addRow(){\n  var objrow = newRow();\n  var msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n  var rows=parent.parent.parent.ObjectCollect.packs_rows;\n  var formObj = document.PacksRecordForm;\n  var params = formObj.params.value;\n  var mode =formObj.mode.value;\n  var obj = formObj.operation;\n  var bill_flag = formObj.bill_flag.value;\n   var key = formObj.oper_num.value+\"@\"+formObj.oper_code.value+\"@C\"+\"@\"+formObj.package_code.value;\n  if(chkEmpty()){\n\tif(mode==\'I\'){\n\t   if(alreadyExist()){\n\t\tif(bill_flag==\"true\") //added by sathish to disable Billing Part\n\t\t{\n\t\tvar retVal = callOrderLineCreation();\n\t\tretVal=trimString(retVal);\n\t\tvar arr = retVal.split(\"@@\");\n\t\tif(arr[0]==\"BL0639\"){\n\t\t\talert(getMessage(\"BL0639\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif(localTrimString(arr[2])!=\'\')\n\t\t\t{\n\t\t\tvar err_pat=localTrimString(arr[2]);\n\t\t\talert(err_pat);\n\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\t\tobjrow.oper_code=formObj.oper_code.value;\n\t\t\tobjrow.oper_desc=formObj.operation.options[obj.selectedIndex].text;\n\t\t\tobjrow.package_code=formObj.package_code.value;\n\t\t\tobjrow.package_desc=formObj.package_desc.value;\n\t\t\tobjrow.oper_line_no = formObj.oper_line_no.value;\n\t\t\tobjrow.quantity = formObj.quantity.value;\n\t\t\tobjrow.remarks = formObj.remarks.value;\n\t\t\tobjrow.recId = getRecId();\n\t\t\t//var retVal = callOrderLineCreation();\n\t\t\tif(bill_flag==\"true\")\n\t\t    {\n\t\t\tvar arr = retVal.split(\"@@\");\n\t\t\tobjrow.panel_str = arr[0];\n\t\t\tobjrow.bill_str = arr[1];\n\t\t    }\n\t\t\tobjrow.key=key;\n\t\t\tobjrow.key_line=\"\";\n\t\t\tobjrow.db_mode=\"I\";\n\t\t\trows.push(objrow);\n\t\t\tresetFields();\n\t\t\tparent.ResultsFrame.location.href=\'../../eOT/jsp/ConsumablePacksDtls.jsp?\'+params;\n\t\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\t\n\t} else{\n\t\tparent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t}\n\t}else\n\t  updateRow();\n  }\n}\n\nfunction callOrderLineCreation(){\n\tvar formObj = document.forms[0];\n\tvar oper_num = formObj.oper_num.value;\n\tvar package_code = formObj.package_code.value;\n\tvar oper_code = (formObj.operation.value).split(\"##\")[0];\n\tvar param = \"oper_num=\"+oper_num+\"&acc_type=C&called_from=ACC_TAB&acc_code=\"+package_code+\"&oper_code=\"+oper_code;\n\t//alert(param);\n\tvar xmlStr =\"<root></root>\";\n\tvar temp_jsp=\"OTOrderLineCreation.jsp?\"+param;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText) ;\n\t//alert(responseText);\n\treturn responseText;\n}\n\nfunction newRow(){\n  var objrow = new Class_row();\n   return(objrow);\n}\n\nfunction alreadyExist(){\n\tvar formObj = document.PacksRecordForm;\n\tvar codeDtl = parent.ResultsFrame.code; \n\t//alert(codeDtl);\n\tvar oper_code=formObj.oper_code.value;\n\tvar package_code = formObj.package_code.value;\n\tvar codeRecord = oper_code+package_code;\n\tif(codeDtl.indexOf(codeRecord)>=0)\n\t   return false;\n\telse\n\t  return true;\n}\n\n function assignRecId(){\n\tvar rows = parent.parent.parent.ObjectCollect.packs_rows;\n\tparent.parent.parent.ObjectCollect.packs_len=rows.length;\n\t\n}\n\nfunction getRecId(){\n    var rowLength=parent.parent.parent.parent.ObjectCollect.packs_len;\n\tvar recId = rowLength+1;\n\tparent.parent.parent.parent.ObjectCollect.packs_len = recId;\n\treturn recId;\n}\n\nfunction chkEmpty(){\n\tvar formObj = document.PacksRecordForm;\n\tvar fields = new Array(formObj.operation,formObj.package_desc,formObj.quantity);\n\tvar names = new Array(\'Operation\',\'package\',\'No of Units\');\n\tvar messageFrame = parent.parent.parent.messageFrame;\n\tif(checkFields( fields, names, messageFrame))\n\t\treturn true;\n}\n\nfunction removeRow(){\nvar formObj = document.PacksRecordForm;\nvar params = formObj.params.value;\nvar rows=parent.parent.parent.ObjectCollect.packs_rows;\nvar recId = document.forms[0].recId.value;\nvar mode = document.forms[0].mode.value;\nif(rows.length>0 && mode==\'U\'){        \n  for(var jj=0;jj<rows.length;jj++){\n\t  //alert(\"rows[jj].db_mode--->\"+rows[jj].db_mode)\n\t if(rows[jj]!=null){\n\t\tif(rows[jj].recId==recId){\n\t\t\tDeleteKey(rows[jj].key+rows[jj].key_line);\n\t\t\t if( (rows[jj].db_mode==\'L\' || rows[jj].db_mode==\'U\') && (rows[jj].order==\'1\' ) )\n\t\t\t{\n\t\t\trows[jj].db_mode=\'D\';\n\t\t\t}\n\t\t\t else\n\t\t\tdelete rows[jj];\n\t\t\t   break;\n\t\t}\n\t }else\n\tcontinue;\n }//end for-Loop\n resetFields();\n parent.ResultsFrame.location.href=\'../../eOT/jsp/ConsumablePacksDtls.jsp?\'+params;\n parent.parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n}else\n   resetFields();\n}\n\nfunction updateRow(){\n\tvar formObj = document.PacksRecordForm;\n\tvar params = formObj.params.value;\n\tvar\tpackage_code=formObj.package_code.value;\n\tvar\tpackage_desc=formObj.package_desc.value;\n\tvar\tquantity = formObj.quantity.value;\n\tvar\tremarks = formObj.remarks.value;\n\tvar mode =formObj.mode.value;\n\tvar recId = formObj.recId.value;\n\tvar rows=parent.parent.parent.ObjectCollect.packs_rows;\n\t\tif(rows.length>0 && mode==\'U\'){        \n\t\t\tfor(var jj=0;jj<rows.length;jj++){\n\t\t\t\tif(rows[jj]!=null) {\n\t\t\t\t\tif(rows[jj].recId==recId){\n\t\t\t\t\t\t//rows[jj].package_code=package_code;\n\t\t\t\t\t\t//rows[jj].package_desc=package_desc;\t\n\t\t\t            rows[jj].quantity=quantity;\n\t\t\t\t\t\trows[jj].remarks=remarks;\n\t\t\t            if(rows[jj].db_mode==\'L\' && rows[jj].order==\'1\'){\n\t\t\t\t\t\t   //alert(\"In order 1\");\n\t\t\t\t\t\t\trows[jj].db_mode=\'U\';\n\t\t\t\t\t\t}else if(rows[jj].db_mode==\'L\' && rows[jj].order==\'2\'){\n\t\t\t\t\t\t\t//alert(\"In order 2\");\n\t\t\t\t\t\t\trows[jj].db_mode=\'I\';\n\t\t\t\t\t\t}else if(rows[jj].db_mode==\'L\' && rows[jj].order==\'3\'){\n\t\t\t\t\t\t\t//alert(\"In order 3\");\n\t\t\t\t\t\t\trows[jj].db_mode=\'I\';\n\t\t\t\t\t\t}\n\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t         }else  \n\t\t\tcontinue;\n\t\t }\n      resetFields();\n\t parent.ResultsFrame.location.href=\'../../eOT/jsp/ConsumablePacksDtls.jsp?\'+params;\n }\n}\n\n\n\nfunction splitString(strVal){\n    var arr = strVal.split(\'::\');\n\tvar formObj = document.PacksRecordForm;\n\tformObj.oper_code.value=arr[0];\n\tformObj.operation.value=arr[1];\n\tformObj.oper_line_no.value = arr[2];\n\tformObj.package_code.value=arr[3];\n\tformObj.package_desc.value=arr[4];\n\tformObj.remarks.value=arr[5];\n\tformObj.quantity.value=arr[6];\n\tformObj.recId.value = arr[7];\n\tformObj.mode.value = arr[8];\n\tformObj.operation.disabled=true;\n\tformObj.PackageLookUp.disabled=true;\n\t\n}\n\nfunction resetFields(){\n\tvar formObj = document.PacksRecordForm;\n\t//formObj.operation.value=formObj.operation.value;\n\tformObj.package_code.value=\'\';\n\tformObj.package_desc.value=\'\';\n\tformObj.oper_code.value=\'\';\n\tformObj.quantity.value=\'\';\n\tformObj.remarks.value=\'\';\n\tformObj.mode.value=\'I\';\n\tformObj.operation.disabled=false;\n\tformObj.PackageLookUp.disabled=false;\n    formObj.operation.focus();\n\t//frmObj.InstrumentLookUp.disabled=false;\n\t\n}\n\nfunction setOperLineNumber(line_no){\n   var frmObj = parent.parent.ObjectCollect;\n   if(frmObj.line_no==0){\n\t\tfrmObj.line_no = parseInt(line_no,10);\n   }\n   //alert(\"assing \"+frmObj.line_no); \n}\n\nfunction getOperLineNumber(){\n   frmObj = parent.parent.ObjectCollect;\n   //alert(\"Before Incrementing \"+frmObj.line_no);\n   var line_no= frmObj.line_no + 1;\n   //alert(\"After Incrementing \"+line_no);\n   parent.parent.ObjectCollect.line_no = line_no;\n   //alert(\"After  assing \"+frmObj.line_no);\n   return line_no;\n}\n\nfunction DeleteKey(key){\n\t//alert(param);\n\tvar xmlStr =\"<root></root>\";\n\tvar temp_jsp=\"DeletePersistenceBeankey.jsp?del_key=\"+key;\n\t//alert(temp_jsp);\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText) ;\n\t//alert(responseText);\n\treturn responseText;\n}\nfunction localTrimString(sInString) {\n  return sInString.replace(/^\\s+|\\s+$/g,\"\");\n}\n\n/*function assignCodes(){\n\tvar formObj = document.PacksRecordForm;\n\tvar codes =  formObj.operation.value;\n    var arr = codes.split(\"##\");\n\t//alert(arr);\n\tformObj.oper_code.value=arr[0];\n\tformObj.oper_line_no.value=arr[1];\n}*/\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onLoad=\"loadCodes();\" OnMouseDown";
    private final static byte[]  _wl_block10_0Bytes = _getBytes( _wl_block10_0 );

    private final static java.lang.String  _wl_block10_1 ="=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name = \'PacksRecordForm\' id=\'PacksRecordForm\'>\n";
    private final static byte[]  _wl_block10_1Bytes = _getBytes( _wl_block10_1 );

    private final static java.lang.String  _wl_block11 ="\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\n<table border=\'0\' cellpadding=3 cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr>\n\t \n<td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" </td>\n     <td width=\"25%\" >\n\t\t<select name=\"operation\" id=\"operation\"  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" >\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<option value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' > ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="  </option>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t</select>\n\t <img src=\'../../eCommon/images/mandatory.gif\'></img>\n    </td>\n<!--  </tr> -->\n\t\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\n\n<!-- <tr>  -->\n\t  <td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" </td>\n\t  <td width=\"25%\">\n\t\t  <input type=\'hidden\' name=\'package_code\' id=\'package_code\' > \n\t\t  <input type=\'text\' name=\'package_desc\' id=\'package_desc\' disabled> \n\t\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'PackageLookUp\' id=\'PackageLookUp\' onClick=\'searchPackage(package_code,package_desc);\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t  </td>\n </tr>\n<tr>\n\t <td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n     <td width=\"25%\">\n\t\t<input type=\'text\' name=\'quantity\' id=\'quantity\' maxlength=\'3\' size=\'2\' onBlur=\"ChkNumber(this);\"  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" > \n\t\t <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n<!-- </tr>\n\n<tr> -->\n\t <td class=\"label\" width=\"25%\" >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" </td>\n     <td width=\"25%\">\n\t\t<textarea  name=\'remarks\' ROWS=\'3\'COLS=\'40\' onBlur=\"checkLimit(this,100)\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ></textarea>\n\t</td>\n</tr>\n\n    <td></td>\n\t<td></td>\n\t<td></td>\n\t<td class=\"fields\" width=\"25%\">\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onClick=\'assignCodes(document.forms[0].operation);addRow();\'  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" >\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' onClick=\'removeRow();\' ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" >\n\t</td>\n</tr>\n</table>\n\n<!-- added by Sathish for Amazon Changes-->\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t<!-- end -->\n<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\'hidden\' name=\'oper_code\' id=\'oper_code\' value=\'\'>\n<input type=\'hidden\' name=\'oper_line_no\' id=\'oper_line_no\' value=\'\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\'hidden\' name=\'bill_flag\' id=\'bill_flag\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );
 
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block6Bytes, _wl_block6);
//@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*" contentType=" text/html;charset=" 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block8Bytes, _wl_block8);

	String p_qty = "";
	String trace="0";

	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;

	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean	= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10_0Bytes, _wl_block10_0);
            _bw.write(_wl_block10_1Bytes, _wl_block10_1);
 String params = request.getQueryString(); 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(params));
            _bw.write(_wl_block12Bytes, _wl_block12);

	
	//String called_from =  checkForNull(request.getParameter("called_from"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String booking_num = checkForNull(request.getParameter("booking_num"));
	String bill_flag = request.getParameter("bill_flag");
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	
	HashMap line_no_map = new HashMap();
	String line_no="";
	boolean exist_rec = false;
	boolean pick_list = false;
	StringBuffer oper_codes = new StringBuffer();

	String  nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	String disable_flag="";
	if( nursing_doc_comp_yn.equals("Y") )
	  disable_flag="disabled";
	 else 
	   disable_flag="";

	String key = "";
	String key_line="";
	String bill_str="";
	String panel_str="";
	HashMap bill_info=new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	String order_id="";
	String order_line_num="";
	String booking_date  = "";
	String encounter_id   = "";
	String patient_class   = "";
	String visit_id   = "";
	String catalog_code   = "";

	 String SQL_EXIST = "SELECT ACCESSORY_CODE FROM OT_SURGICAL_ACCESSORIES WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND ROWNUM=1";

	//this query checks whether we have already record in OT_PICK_LISTS Table if returns true="PICK_LIST_DEFINED Qry is executed otherwise PICKlIST_UNDEFINED Qry is executed"
	String PICK_LIST_EXIST_YN = "SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?) AND ROWNUM=1";
	//Code altered by Selvam for PHASE 3 Delivery
	//	String PICK_LIST_DEFINED="SELECT A.OPER_CODE OPR_CODE,C.SHORT_DESC OPR_DESC,A.ITEM_ID ACC_CODE,B.SHORT_DESC ACC_DESC,A.ITEM_QTY TR_NO FROM  OT_PICK_LISTS A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.TEAM_DOCTOR_CODE  = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'P' AND A.ITEM_ID = B.PACKAGE_CODE";
		String PICK_LIST_DEFINED="SELECT A.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.ITEM_ID ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,NVL(A.ITEM_QTY,1) TR_NO FROM  OT_PICK_LISTS A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.TEAM_DOCTOR_CODE  = ? AND (A.BOOKING_NUM= ? OR A.OPER_NUM = ?) AND A.OPER_CODE = C.OPER_CODE AND NVL(FINALIZED_YN,'N')= 'Y' AND A.ITEM_TYPE = 'P' AND A.ITEM_ID = B.PACKAGE_CODE";
 
	String PICK_LIST_UNDEFINED="";	
	//Code altered by Selvam for PHASE 3 Delivery	
	//String SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, B.SHORT_DESC OPR_DESC, A.ACCESSORY_CODE ACC_CODE, C.SHORT_DESC ACC_DESC, A.QUANTITY TR_NO, A.REMARKS REMKS FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PACKAGE_HDR C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PACKAGE_CODE"; 
	//Modified against MMS-QH-CRF-0199
	String SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','LONG_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',C.PACKAGE_CODE) ACC_DESC, A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PACKAGE_HDR_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'P' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PACKAGE_CODE AND C.LANGUAGE_ID=? ORDER BY BILL_SUB_REGN_LINE_NUM";
	String SQL1 = "SELECT A.OPER_CODE OPR_CODE,A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',B.OPER_CODE) OPR_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	String val= "";
	ResultSet rst = null;
	String rst_acc_code = "";
	String rst_tr_no = "";
	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2")) ;

		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		trace="1";
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
		if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();

		pstmt = con.prepareStatement(SQL_EXIST);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		trace="2";
		rst = pstmt.executeQuery();
		if(rst.next()){
			exist_rec=true;
		}
		 if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();
		if(exist_rec==true){
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,oper_num);
			pstmt.setString(3,locale);
		trace="3";
			rst = pstmt.executeQuery();
			while(rst.next()){
			   ++index;	
			key = rst.getString("KEY");
			key_line = rst.getString("KEY_LINE");
			//or_bean.clearBean();
			if(("true").equals(bill_flag))// added by sathish on 10-01-2009 to disable billing Part
			{
			bill_info = or_bean.getOrderBillDtls(key+key_line);
			if(bill_info==null){
				bill_info = new HashMap();
				bill_info.put("key",key);
				bill_info.put("key_line_no",key_line);
				rst_acc_code = rst.getString("ACC_CODE");
				bill_info.put("oper_code",rst_acc_code);//pass acc_code in oper_code
				bill_info.put("acc_type","C");
				bill_info.put("oper_num",oper_num);
				bill_info.put("locale",locale);
				bill_info.put("module_id","OT");
				//populate billing details from OTBillingBean........	
				rst_tr_no = rst.getString("TR_NO");
				bill_info.put("quantity",rst_tr_no);
				bill_info = billing_bean.getBillingParams(bill_info,"C");//C-> for Surgical Accessories Billing
				//bill_info.put("quantity",rst.getString("TR_NO"));
/*test code		
				catalog_code = "C#"+rst_acc_code;
				ArrayList bill_dtls=or_bean.getBillChargeDetails(rst_tr_no,catalog_code,(String)bill_info.get("service_date"),locale,order_id,order_line_num,patient_id,(String)bill_info.get("encounter_id"),(String)bill_info.get("patient_class"),(String)bill_info.get("pract_staff_id"));	
				bill_info	= billing_bean.formatBillingDetails(bill_dtls);
				bill_info.putAll(bill_info);
			//set billing details from OTBillingBean........	
// test code ends here */
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
			out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+checkForNull(rst.getString("REMKS"))+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"');</script>");	

		}
		out.println("<script>refresh()</script>");
		out.println("<script>assignRecId()</script>");
		
		if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();
		} else if(nursing_doc_comp_yn.equals("N")) {
			
			pstmt = con.prepareStatement(PICK_LIST_EXIST_YN);
			/*SELECT OPER_CODE FROM OT_PICK_LISTS WHERE OPERATING_FACILITY_ID=? AND (BOOKING_NUM=? OR OPER_NUM=?) AND ROWNUM=1*/
			pstmt.setString(1,facility_id);
			pstmt.setString(2,booking_num);
			pstmt.setString(3,oper_num);
		trace="4";
			rst = pstmt.executeQuery();
			if(rst.next()){
				pick_list=true;
			}
			if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();
			if(pick_list==true){
				 pstmt = con.prepareStatement(PICK_LIST_DEFINED);
				 pstmt.setString(1,facility_id);
				 pstmt.setString(2,patient_id);
				 pstmt.setString(3,surgeon_code);
				 pstmt.setString(4,booking_num);
				 pstmt.setString(5,oper_num);
		trace="5";
				 rst = pstmt.executeQuery();
				while(rst.next()){
					++index;	
					line_no = (String)line_no_map.get(rst.getString("OPR_CODE"));
                if(("true").equals(bill_flag))
			    {
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
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
				bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
				bill_info.putAll(hash);
				bill_info.put("quantity",p_qty);
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
		/*oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order	*/	out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','L','2','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"'); </script>");	
			}//end of while loop
			if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();
			out.println("<script>refresh()</script>");
			out.println("<script>assignRecId()</script>");
		} else {

			//PICK_LIST_UNDEFINED;
			/*PICK_LIST_UNDEFINED="SELECT A.OPER_CODE OPR_CODE,C.SHORT_DESC OPR_DESC,A.PACKAGE_CODE ACC_CODE,B.SHORT_DESC ACC_DESC,A.PACKAGE_QTY TR_NO FROM OT_OPER_PACKAGE A,OT_PACKAGE_HDR B,OT_OPER_MAST C WHERE  A.OPER_CODE IN ("+oper_codes.toString()+") AND  A.PACKAGE_CODE  = B.PACKAGE_CODE AND A.OPER_CODE = C.OPER_CODE";*/
			//PICK_LIST_UNDEFINED="SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.PACKAGE_CODE ACC_CODE,   B.SHORT_DESC ACC_DESC,   A.PACKAGE_QTY TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.PACKAGE_CODE     = B.PACKAGE_CODE  AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.PACKAGE_CODE ACC_CODE,  B.SHORT_DESC ACC_DESC,   A.PACKAGE_QTY TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL'AND A.SPECIALITY_CODE = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.PACKAGE_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.PACKAGE_QTY TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE    AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE     AND A.PACKAGE_CODE     = B.PACKAGE_CODE UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.PACKAGE_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.PACKAGE_QTY TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE  = D.OPER_SUB_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+")  AND C.OPER_CODE = D.OPER_CODE AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT A.OPER_CODE OPR_CODE, C.SHORT_DESC OPR_DESC, A.PACKAGE_CODE ACC_CODE, B.SHORT_DESC ACC_DESC,   A.PACKAGE_QTY TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE  AND A.PACKAGE_CODE = B.PACKAGE_CODE";
			PICK_LIST_UNDEFINED="SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE,   GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'AOPR' AND A.PACKAGE_CODE     = B.PACKAGE_CODE  AND C.OPER_CODE IN ("+oper_codes.toString()+") UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE,  GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SSPL'AND A.SPECIALITY_CODE = C.SPECIALITY_CODE AND C.OPER_CODE IN ("+oper_codes.toString()+") AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SCAT' AND A.SPECIALITY_CODE   = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE    = D.OPER_CAT_CODE    AND D.OPER_CODE  IN ("+oper_codes.toString()+") AND C.OPER_CODE  = D.OPER_CODE     AND A.PACKAGE_CODE     = B.PACKAGE_CODE UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO  FROM OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C, OT_OPER_FOR_GROUP_CAT D WHERE A.APPLICABILITY = 'SSUB' AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE AND A.OPER_CAT_CODE = D.OPER_CAT_CODE  AND A.OPER_SUB_CAT_CODE  = D.OPER_SUB_CAT_CODE  AND D.OPER_CODE IN ("+oper_codes.toString()+")  AND C.OPER_CODE = D.OPER_CODE AND A.PACKAGE_CODE     = B.PACKAGE_CODE  UNION SELECT C.OPER_CODE OPR_CODE, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',C.OPER_CODE) OPR_DESC, A.PACKAGE_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',B.PACKAGE_CODE) ACC_DESC,   NVL(A.PACKAGE_QTY,1) TR_NO FROM    OT_OPER_PACKAGE A, OT_PACKAGE_HDR B, OT_OPER_MAST C WHERE A.APPLICABILITY = 'SOPR' AND A.OPER_CODE IN ("+oper_codes.toString()+") AND A.OPER_CODE  = C.OPER_CODE  AND A.PACKAGE_CODE = B.PACKAGE_CODE";
			pstmt = con.prepareStatement(PICK_LIST_UNDEFINED);
		trace="6";
			rst = pstmt.executeQuery();
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
				//ArrayList bill_dtls=or_bean.getBillChargeDetails(visit_id,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
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
			/*oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order	*/
	out.println("<script>loadDBRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+line_no+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")) )+"','"+checkForNull(rst.getString("TR_NO"))+"','','"+index+"','L','3','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"'); </script>");	
		}//end of while loop
		if(pstmt!=null)			pstmt.close();
			if(rst!=null)           rst.close();
		out.println("<script>refresh()</script>");
		out.println("<script>assignRecId()</script>");

	}


}
    else
		{
		    out.println("<script>refresh()</script>");
			out.println("<script>assignRecId()</script>");
		}
		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		trace="7";
		rst = pstmt.executeQuery();
	
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
 while(rst.next()){ 
			//OPR_CODE + LN_NO
			val = rst.getString(1)+"##"+rst.getString(2);
			
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(val));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rst.getString(3)));
            _bw.write(_wl_block18Bytes, _wl_block18);
}
            _bw.write(_wl_block19Bytes, _wl_block19);

		}catch(Exception e){
		 System.err.println("Consumable^^Err Msg in ConsumablePacksRecord"+e.getMessage());
		 System.err.println("Consumable^^Err Msg in ConsumablePacksRecord at trace="+trace);
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
  
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block30Bytes, _wl_block30);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bill_flag));
            _bw.write(_wl_block36Bytes, _wl_block36);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Package.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.NoofUnits.Label", java.lang.String .class,"key"));
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
