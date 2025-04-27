package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import webbeans.eCommon.ConnectionManager;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;

public final class __postoperdiagnosisrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/PostOperDiagnosisRecord.jsp", 1709120312000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7_0 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/RecordSurgeon.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eOT/js/OTMessages.js\"></script>-->\n\n<script language=\'javascript\'>\n\nfunction Class_row()\n{\n  this.icd_code =\"\";\n  this.icd_desc=\"\";\n  this.scheme_code=\"\";\n  this.primary=\"\";\n  this.significant=\"\";\n  this.onset_date =\"\";\n  this.close_date=\"\";\n  this.notifiable=\"\";\n  this.sensitive=\"\";\n  this.srl_no=\"\";\n  this.patient_id=\"\";\n  this.surgeon_code=\"\";\n  this.source_code=\"\";\n  this.source_type=\"\";\n  this.v_stat=\"\";\n  this.remarks =\"\";\n  this.db_mode=\"\";\n  this.recId=\"\";\n}\n\n\n\n/*function disableDocLevel(){\n   var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n   formObj.doc_level.disabled=true;\n}*/\n\n/*function loadDBRows(oper_code,oper_desc,line_no,implant_code,implant_desc,quantity,mfgr,batch,remarks,index,mode){ \n  var objrow = newRow();\n  var rows=parent.parent.parent.ObjectCollect.diagnosis_rows;\n  var rowLength=parent.parent.parent.parent.ObjectCollect.implants_len;\n  if(mode==\'L\' && rowLength==0){\n\t  objrow.oper_code=oper_code;\n\t  objrow.oper_desc=oper_desc;\n\t  objrow.implant_code=implant_code;\n\t  objrow.implant_desc=implant_desc;\n\t  objrow.oper_line_no=line_no;\n\t  objrow.quantity=quantity;\n\t  objrow.manufacturer=mfgr\n\t  objrow.batch=batch;\n\t  objrow.remarks=remarks;\n\t  objrow.recId = index;\n\t  objrow.db_mode=\"L\";\n\t  rows.push(objrow);\n\t }\n}*/\n\nfunction loadDiagCodes(scheme_code,diag_code,srl_no,index,mode){ \n  //alert(scheme_code+diag_code+srl_no);\n  var objrow = newRow();\n  var rows= parent.parent.ObjectCollect.diagnosis_rows;\n  var rowLength=rows.length;\n  var db_flag=parent.parent.ObjectCollect.db_flag;\n  //alert(\'flag\'+db_flag);\n  if(mode==\'L\' &&db_flag==\'ON\'){\n\t  objrow.icd_code=diag_code;\n\t  objrow.scheme_code=scheme_code;\n\t  objrow.srl_no=srl_no;\n\t  objrow.recId = index;\n\t  objrow.db_mode=\"L\";\t  \n\t  rows.push(objrow);\n\t }\n\t// alert(\'dhana\'+rows.length);\n\n}\n\nfunction loadDiagDesc(desc,code,notifiable,sensitive,mode){ \n  var rows= parent.parent.ObjectCollect.diagnosis_rows;\n  //alert(code+\"=\"+desc+\"Mode=\"+mode+\"notify_yn=\"+notifiable+\"sensitive_yn=\"+sensitive);\n  for(i=0;i<rows.length;i++){\n\t  if( mode==\'L\' && rows[i].icd_code==code ){\n\t\t\trows[i].icd_desc=desc;\n\t\t\trows[i].notifiable=notifiable;\n\t\t\trows[i].sensitive=sensitive;\n\t\t\t  //alert(\'icd_desc\'+rows[i].icd_desc);\n\t\t  break;\n\t  }else\t\t continue;\n  }\n  \n}\n\nfunction loadDiagDtls(primary,significant,onset_date,close_date,remarks,srl_no,mode){ \n  var rows= parent.parent.ObjectCollect.diagnosis_rows;\n   //var rowLength=rows.length;\n  //alert(primary+significant+onset_date+close_date+remarks);\n   for(i=0;i<rows.length;i++){\n\t if(mode==\'L\' && rows[i].srl_no==srl_no){\n\t\trows[i].primary=primary;\n\t\trows[i].significant=significant;\n\t\trows[i].onset_date=onset_date;\n\t\trows[i].close_date = close_date;\n\t\tif(close_date!=\"\")\n\t\t\trows[i].date_flag = \"Y\";\n\t\telse \n\t\t\trows[i].date_flag = \"N\";\n\t\trows[i].remarks = remarks;\n\t\tbreak;\n\t}else\n\t\tcontinue;\n   }\n}\n\nfunction refresh(){\n  \tvar formObj = document.PostOperDiagnosisRecordForm;\n\tvar params = formObj.params.value;\n\tparent.DetailFrame.location.href=\'../../eOT/jsp/PostOperDiagnosisDtls.jsp?\'+params;\n }\n\nfunction addRow(){\n  var objrow = newRow();\n  var msg = trimString(getMessage(\"CODE_ALREADY_EXISTS\",\"Common\"));\n  var rows=parent.parent.ObjectCollect.diagnosis_rows;\n  //alert(parent.parent.ObjectCollect.name);\n  var formObj = document.forms[0];\n  var params = formObj.params.value;\n  //var primary = formObj.primary;\n  //var siginficant = formObj.significant;\n  var mode =formObj.mode.value;\n  if(chkEmpty() && validateDate()){\n\t  if(mode==\'I\'){\n\t   if(alreadyExist()){\n\t\tobjrow.icd_code=formObj.icd_code.value;\n\t\tobjrow.icd_desc =formObj.icd_desc.value;\n\t\tobjrow.scheme_code=formObj.scheme_code.value;\n\t\tif(formObj.primary.checked==true){\n\t\t\tobjrow.primary=\"Y\";\n\t\t}else{\n\t\t\tobjrow.primary=\"N\";\n\t\t}\n\t\tif(formObj.significant.checked==true){\n\t\t\tobjrow.significant=\"Y\";\n\t\t}else{\n\t\t\tobjrow.significant=\"N\";\n\t\t}\n\n\t\tobjrow.onset_date=formObj.onset_date.value;\n\t\tobjrow.close_date = formObj.close_date.value\n\t\tif(formObj.close_date.value!=\"\"){\n\t\t\tobjrow.v_stat=\"C\";\n\t\t}else{\n\t\t\tobjrow.v_stat=\"A\";\n\t\t}\n\t\tobjrow.srl_no = getSerialNumber();\n\t\tobjrow.remarks = formObj.remarks.value;\n\t\tobjrow.notifiable = formObj.notifiable.value;\n\t\tobjrow.sensitive = formObj.sensitive.value;\n\t\tobjrow.patient_id =formObj.patient_id.value;\n\t\tobjrow.encounter_id = formObj.encounter_id.value;\n\t\tobjrow.surgeon_code = formObj.surgeon_code.value;\n\t\tobjrow.source_type = formObj.source_type.value;\n\t\tobjrow.source_code = formObj.source_code.value;\n\t\tobjrow.db_mode=\"I\";\n\t\tobjrow.recId = rows.length+1;\n\t\t//objrow.db_mode=\"I\";\n\t\trows.push(objrow);\n\t\tresetFields();\n\t\tparent.DetailFrame.location.href=\'../../eOT/jsp/PostOperDiagnosisDtls.jsp?\'+params;\n\t\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t} else{\n\t\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n\t}\n\t}else\n\t  updateRow();\n  }\n}\n\nfunction newRow(){\n  var objrow = new Class_row();\n   return(objrow);\n}\n\nfunction alreadyExist(){\n\tvar formObj = document.PostOperDiagnosisRecordForm;\n\tvar codeDtl = parent.DetailFrame.code; \n\tvar icd_code=formObj.icd_code.value;\n\tvar icd_code = formObj.icd_code.value;\n\tif(codeDtl.indexOf(icd_code)>=0)\n\t   return false;\n\telse\n\t  return true;\n}\n\n function assignRecId(){\n\tvar rows = parent.parent.ObjectCollect.diagnosis_rows;\n\tparent.parent.ObjectCollect.diagnosis_len=rows.length;\n\t\n}\n\nfunction getRecId(){\n    var rowLength=parent.parent.diagnosis_len;\n\tvar recId = rowLength+1;\n\tparent.parent.ObjectCollect.diagnosis_len = recId;\n\treturn recId;\n}\n\nfunction chkEmpty(){\n\tvar formObj = document.PostOperDiagnosisRecordForm;\n\tvar fields = new Array(formObj.icd_code,formObj.onset_date);\n\tvar icd_value=getLabel(\"Common.ICD.label\",\"common\");\n\tvar onsetDate_value=getLabel(\"Common.onsetdate.label\",\"common\");\n\tvar names = new Array(icd_value,onsetDate_value );\n\tvar messageFrame = parent.parent.messageFrame;\n\tif(checkFields( fields, names, messageFrame))\n\t\treturn true;\n}\n\nfunction removeRow(){\nvar formObj = document.PostOperDiagnosisRecordForm;\nvar params = formObj.params.value;\nvar rows=parent.parent.ObjectCollect.diagnosis_rows;\nvar recId = document.forms[0].recId.value;\nvar mode = document.forms[0].mode.value;\nif(rows.length>0 && mode==\'U\'){        \n  for(var jj=0;jj<rows.length;jj++){\n\t if(rows[jj]!=null){\n\t\tif(rows[jj].recId==recId){\n\t\t\t if(rows[jj].db_mode==\'L\'){\n\t\t\t\t//alert(\"Existing Records Cannot be Deleted\");\n\t\t\t\talert(getMessage(\"CANNOT_DELETE\",\"SM\");\n\t\t\t\tresetFields();\n\t\t\t\tbreak;\n\t\t\t }else{\n\t\t\t     delete rows[jj];\n\t\t\t     resetFields();\n\t\t\t     parent.DetailFrame.location.href=\'../../eOT/jsp/PostOperDiagnosisDtls.jsp?\'+params;\n\t\t\t     parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\';\t\n\t\t\t     break;\n\t\t\t }\n\t\t}\n\t }else\n\tcontinue;\n }//end for-Loop\n }else\n  resetFields();\n}\n\nfunction callPopulateList(flag){}\n\nfunction updateRow(){\n\tvar formObj = document.PostOperDiagnosisRecordForm;\n\tvar params = formObj.params.value;\n\tvar\tonset_date = formObj.onset_date.value;\n\tvar close_date = formObj.close_date.value;\n\tvar primary = \"\";\n\tvar significant = \"\";\n\t\n\t//for primary check Box\n\tif(formObj.primary.checked==true){\n\t\tprimary=\"Y\";\t\n\t}else {\n\t\tprimary=\"N\";\n\t}\n\t//for significant check Box\n\tif(formObj.significant.checked==true){\n\t\tsignificant=\"Y\";\t\n\t}else {\n\t\tsignificant=\"N\";\n\t}\n\n\tvar\tremarks = formObj.remarks.value;\n\tvar mode =formObj.mode.value;\n\tvar recId = formObj.recId.value;\n\tvar rows=parent.parent.parent.ObjectCollect.diagnosis_rows;\n\t\tif(rows.length>0 && mode==\'U\'){        \n\t\t\tfor(var jj=0;jj<rows.length;jj++){\n\t\t\t\tif(rows[jj]!=null) {\n\t\t\t\t\tif(rows[jj].recId==recId){\n\t\t\t\t\t\t//rows[jj].implant_code=implant_code;\n\t\t\t\t\t\t//rows[jj].implant_desc=implant_desc;\t\n\t\t\t\t\t\tif(formObj.close_date.value!=\"\"){\n\t\t\t\t\t\t\trows[jj].v_stat=\"C\";\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\trows[jj].v_stat=\"A\";\n\t\t\t\t\t\t}\n\t\t\t\t\t\trows[jj].patient_id =formObj.patient_id.value;\n\t\t\t\t\t\trows[jj].encounter_id = formObj.encounter_id.value;\n\t\t\t\t\t\trows[jj].surgeon_code = formObj.surgeon_code.value;\n\t\t\t\t\t\trows[jj].source_type = formObj.source_type.value;\n\t\t\t\t\t\trows[jj].source_code = formObj.source_code.value;\n\t\t\t            rows[jj].significant=significant;\n\t\t\t\t\t\trows[jj].primary = primary\n\t\t\t\t\t\trows[jj].onset_date=onset_date;\n\t\t\t\t\t\trows[jj].close_date=close_date;\n\t\t\t\t\t\trows[jj].remarks=remarks;\n\t\t\t            if(rows[jj].db_mode==\'L\')\n\t\t\t\t\t\t\trows[jj].db_mode=\'U\'\n\t\t\t\t\t\t\tbreak;\n\t\t\t\t\t}\n\t\t         }else  \n\t\t\tcontinue;\n\t\t }\n     resetFields();\n\t parent.DetailFrame.location.href=\'../../eOT/jsp/PostOperDiagnosisDtls.jsp?\'+params;\n }\n}\n\nfunction splitString(strVal){\n    var arr = strVal.split(\'::\');\n\tvar formObj = document.PostOperDiagnosisRecordForm;\n\tformObj.icd_code.value=arr[0];\n\tformObj.icd_desc.value=arr[1];\n\tif(arr[2]==\"Y\"){\n\t\tformObj.primary.checked=true;\n\t\t\n\t}else{\n\t\tformObj.primary.checked=false;\n\t\t\n\t}\n\n\tif(arr[3]==\"Y\"){\n\t\tformObj.significant.checked=true;\n\t\t\n\t}else{\n\t\tformObj.significant.checked=false;\n\t\t\n\t}\n\n\tformObj.onset_date.value = arr[4];\n\tformObj.close_date.value=arr[5];\n\tformObj.remarks.value=arr[6];\n\tformObj.recId.value = arr[7];\n\tformObj.mode.value=arr[8];\n\tformObj.ICDCodeLookUp.disabled=true;\n}\n\nfunction resetFields(){\n\tvar formObj = document.PostOperDiagnosisRecordForm;\n\tformObj.icd_code.value=\'\';\n\tformObj.icd_desc.value=\'\';\n\tformObj.primary.checked=false;\n\tformObj.significant.checked=false;\n\tformObj.onset_date.value=\'\';\n\tformObj.close_date.value=\'\';\n\tformObj.remarks.value=\'\';\n\tformObj.mode.value=\'I\';\n\tformObj.ICDCodeLookUp.disabled=false;\n\tformObj.primary.disabled=false;\n\tformObj.significant.disabled=false;\n  }\n\n  function setSerialNumber(serial_no){\n\t//alert(serial_no);\n   var frmObj = parent.parent.ObjectCollect;\n   if(frmObj.serial_no==0){\n\t\tfrmObj.serial_no = parseInt(serial_no,10);\n   }\n   //alert(\"assing \"+frmObj.serial_no); \n}\n\nfunction getSerialNumber(){\n   frmObj = parent.parent.ObjectCollect;\n   //alert(\"Before Incrementing \"+frmObj.serial_no);\n   var serial_no= frmObj.serial_no + 1;\n  // alert(\"After Incrementing \"+serial_no);\n   parent.parent.ObjectCollect.serial_no = serial_no;\n   //alert(\"After  assing \"+frmObj.serial_no);\n   //alert(\"serial_no\"+se";
    private final static byte[]  _wl_block7_0Bytes = _getBytes( _wl_block7_0 );

    private final static java.lang.String  _wl_block7_1 ="rial_no);\n   return serial_no;\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block7_1Bytes = _getBytes( _wl_block7_1 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body onLoad=\"assignHdrDtls();setPrimaryFlag();\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<form name = \'PostOperDiagnosisRecordForm\' >\n\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<table border=\'0\' cellpadding=3  cellspacing=\'0\' width=\'100%\'>\n<tr>\n\t \n<tr> \n\t  <td class=\'label\' align=\'right\'>\n\t  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </td>\n\t  <td align=\'left\'  nowrap>\n\t\t  <input type=\'hidden\' name=\'icd_code\' id=\'icd_code\' > \n\t\t  <input type=\'text\' name=\'icd_desc\' id=\'icd_desc\'  size=\'25\'disabled > \n\t\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'ICDCodeLookUp\' id=\'ICDCodeLookUp\' onClick=\' searchICD(icd_code,icd_desc);\' ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" >\n\t\t   <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t  </td>\n </tr>\n\n<tr> \n\t  <td class=\'label\' align=\'right\' >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </td>\n\t  <td align=\'left\' nowrap>\n\t\t  <input type=\'checkbox\'  name=\'primary\' id=\'primary\' onClick=\"validatePrimaryChkBox(this);\" ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" >\n\t  </td>\n </tr>\n<tr> \n\t  <td class=\'label\' align=\'right\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </td>\n\t  <td align=\'left\' nowrap>\n\t\t  <input type=\'checkbox\'  name=\'significant\' id=\'significant\'  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" >\n\t  </td>\n </tr>\n<tr>\n\t <td class=\'label\' align=\'right\' nowrap>\n\t ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="  </td>\n     <td align=\'left\' nowrap>\n\t\t<input type=\'text\' name=\'onset_date\' id=\'onset_date\'  size=\'7\' readonly > \n\t\t <image src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'onset_date\'); \"  > <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n\t</td>\n</tr>\n\n<tr>\n\t <td class=\'label\' align=\'right\' nowrap>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </td>\n     <td align=\'left\' nowrap>\n\t\t<input type=\'text\' name=\'close_date\' id=\'close_date\' size=\'7\' readonly > \n\t\t <image src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'close_date\');\">\n\t\t\n\t</td>\n</tr>\n\n<tr>\n\t <td class=\'label\' align=\'right\' nowrap ></td>\n     <td align=\'left\' nowrap>\n\t<a href=\"javascript:openNewDialogWindow(\'Remarks\',document.forms[0].remarks,1500,\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\"> ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" </a>\n\t</td>\n</tr>\n<tr>\n\n\t<td></td>\n\t<td class=\'label\' align=\'right\' nowrap width=\'100%\'>\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' onClick=\'addRow();\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" >\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' onClick=\'removeRow();\' ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" >\n\t</td>\n</tr>\n</table>\n<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\'hidden\' name=\'scheme_code\' id=\'scheme_code\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' >\n\n<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\'\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\'hidden\' name=\'primary_yn\' id=\'primary_yn\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=\'hidden\' name=\'primary_flag\' id=\'primary_flag\' value=\'\'>\n\n<input type=\'hidden\' name=\'sensitive\' id=\'sensitive\' value=\'\'>\n<input type=\'hidden\' name=\'notifiable\' id=\'notifiable\' value=\'\'>\n\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'\'>\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\'\'>\n<input type=\'hidden\' name=\'surgeon_code\' id=\'surgeon_code\' value=\'\'>\n<input type=\'hidden\' name=\'source_code\' id=\'source_code\' value=\'\'>\n<input type=\'hidden\' name=\'source_type\' id=\'source_type\' value=\'\'>\n\n<!--<input type=\'hidden\' name=\"facility_id\" id=\"facility_id\" value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'> -->\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
 //qry_mode=YES used in surgeryHistory 
	String qry_mode=CommonBean.checkForNull(request.getParameter("qry_mode")); 
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7_0Bytes, _wl_block7_0);
            _bw.write(_wl_block7_1Bytes, _wl_block7_1);
if(qry_mode.equals("YES")){ 
            _bw.write(_wl_block8Bytes, _wl_block8);
}else{
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
 String params = request.getQueryString(); 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(params));
            _bw.write(_wl_block11Bytes, _wl_block11);

	
	
	String oper_num = CommonBean.checkForNull(request.getParameter("oper_num"));
	
	String facility_id = CommonBean.checkForNull(request.getParameter("facility_id"));
	String patient_id = CommonBean.checkForNull(request.getParameter("patient_id"));
	
	String max_srl_no ="";
	String  surgeon_doc_comp_yn = CommonBean.checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	String disable_flag="";
	if( surgeon_doc_comp_yn.equals("Y") )
	  disable_flag="disabled";
	 else 
	   disable_flag="";
	
	//MAX SERIAL NO QUERY
	String MAX_SRL_NO = "SELECT NVL(MAX(SRL_NO),0) FROM PR_PROBLEM WHERE PATIENT_ID=?";
	
	String SQL = "SELECT NVL(DIAG_CODE_SCHEME,'1') DIAG_CODE_SCHEME FROM OT_PARAM"; 
	String SQL1 = "SELECT PRIMARY_YN FROM PR_PROBLEM WHERE PATIENT_ID =? AND PRIMARY_YN='Y'";
	
	//INITIAL POPULATION QUERY
	String SQL2 ="SELECT DIAG_CODING_SCHEME,DIAG_CODE,SRL_NO FROM OT_POST_OPER_DIAG WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?";
	
	//QUERY FOR DIAG_CODE_SCHEME=1
	String SQL3 ="SELECT SHORT_DESC,NOTIFIABLE_YN,SENSITIVE_YN FROM MR_ICD_MAST WHERE ICD_CODE=? AND RECORD_TYPE='D' AND CAUSE_INDICATOR IS NULL";
	
	//QUERY FOR DIAG_CODE_SCHEME=2
	String SQL4= "SELECT SHORT_DESC, NOTIFIABLE_YN, SENSITIVE_YN FROM MR_ICD_MAST WHERE ICD_CODE = ? AND NVL(RECORD_TYPE,'#')='#' AND CAUSE_INDICATOR IS NULL";

	//QUERY FOR SELECTING ADDN INFORMATION PRIMARY_YN,ONSET_DATE,SIGNIFICANT_YN,CLOSE_DATE,REMARKS
	String SQL5= "SELECT PRIMARY_YN,SIGNIFICANT_YN,TO_CHAR(ONSET_DATE,'DD/MM/YYYY'),TO_CHAR(CLOSE_DATE,'DD/MM/YYYY'),PROBLEM_REMARKS FROM PR_PROBLEM WHERE PATIENT_ID=? AND SRL_NO=?";
		
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String diag_code_scheme="";
	String diag_code_sch="";
	HashMap diag_code=new HashMap();
	HashMap srl_no=new HashMap();
	String primary_yn="";
	int size=0;
	int index=0;
	try{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_PERSONNEL_SELECT2")) ;
		pstmt = con.prepareStatement(SQL);
		rst = pstmt.executeQuery();
		if(rst.next()){
			diag_code_scheme = rst.getString(1);
		}else
			diag_code_scheme = "1";

		if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();

		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,patient_id);
		rst = pstmt.executeQuery();
		if(rst.next()){
			primary_yn = rst.getString(1);
		}else
			primary_yn = "N";
			
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
		// ("primary_yn====="+primary_yn);
		
		pstmt = con.prepareStatement(SQL2);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		index=0;
		while(rst.next()){
			
			++index;
			diag_code_sch=rst.getString(1);
			diag_code.put(""+index,rst.getString(2)); //diagnosis_code
			srl_no.put(""+index,rst.getString(3)); // srl_no
			//1 diagnosis_coding_scheme, 2 diagnosis_code, 3 srl_no
		   out.println("<script>loadDiagCodes('"+CommonBean.checkForNull(rst.getString(1))+"','"+CommonBean.checkForNull(rst.getString(2))+"','"+CommonBean.checkForNull(rst.getString(3))+"','"+index+"','L')</script>");
		}
		
		if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();

		
		if(!diag_code_sch.equals("") ){
			if(diag_code_sch.equals("2") ){
				pstmt = con.prepareStatement(SQL4);
			}else{
				pstmt = con.prepareStatement(SQL3);
			}	 
			size = diag_code.size();
			if(size>0){
				for(int i=1;i<=size;i++){
				  pstmt.setString(1,(String)diag_code.get(""+i));
				  rst = pstmt.executeQuery();
				  while(rst.next()){
				out.println("<script>loadDiagDesc('"+CommonBean.checkForNull(rst.getString(1))+"','"+(String) diag_code.get(""+i)+"','"+CommonBean.checkForNull(rst.getString(2))+"','"+CommonBean.checkForNull(rst.getString(3))+"','L')</script>");
				  }
				}// end of for
	         }// end if
		}
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
		size=srl_no.size();	
		if(size>0){
			
			pstmt = con.prepareStatement(SQL5);
			for(int i=1;i<=size;i++){
				pstmt.setString(1,patient_id);
				pstmt.setString(2,(String) srl_no.get(""+i));
				
				rst = pstmt.executeQuery();
				while(rst.next()){
					
				   //1 primary_yn,signifacnt_yn,onset_date,close_date,remarks
				  out.println("<script>loadDiagDtls('"+CommonBean.checkForNull(rst.getString(1))+"','"+CommonBean.checkForNull(rst.getString(2))+"','"+CommonBean.checkForNull(rst.getString(3))+"','"+CommonBean.checkForNull(rst.getString(4))+"','"+CommonBean.checkForNull(rst.getString(5))+"','"+(String) srl_no.get(""+i)+"','L')</script>");
				}// END WHILE
		    } // END FOR
		}// END IF
		if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();

		pstmt = con.prepareStatement(MAX_SRL_NO);
		pstmt.setString(1,patient_id);
		rst = pstmt.executeQuery();
		while(rst.next()){
			max_srl_no = rst.getString(1);
			
		}
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
		out.println("<script>setSerialNumber('"+max_srl_no+"')</script>");
		out.println("<script>refresh()</script>");
	}catch(Exception e){
		 System.err.println("Err Msg in PostOperDiagnosisRecord "+e.getMessage());
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(diag_code_scheme));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(primary_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(request.getParameter("slate_user_id")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ICD.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.primary.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.significant.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.CloseDate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
