package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import eOT.*;
import eOT.Common.*;
import eOR.OrderEntryBillingQueryBean;
import java.util.ArrayList;
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

public final class __unusualoccur extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/unusualoccur.jsp", 1743663519580L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script language=\"JavaScript\" src=\"../../eOT/js/RecordSurgeon.js\"></script>\n\t\t<script language=\"JavaScript\"> var lblRemarksDiag=getLabel(\"Common.remarks.label\",\"Common\");\t</script>\n   ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<script language=\"JavaScript\" src=\"../../eOT/js/RecordNursing.js\"></script>\n\t<script language=\"JavaScript\"> \n\t\tvar lblRemarksDiag=getLabel(\"Common.remarks.label\",\"Common\");\t\n\t</script>\n   ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\n\n<script language=\'javascript\'>\n\n  var rightSide_title=getLabel(\"eOT.RightSide.Label\",\"ot\");\n  var leftSide_title=getLabel(\"eOT.LeftSide.Label\",\"ot\");\n  var notApplicable_title=getLabel(\"Common.notapplicable.label\",\"common\");\n  var bilateral_title=getLabel(\"eOT.Bilateral.Label\",\"ot\");\n  var operation_title=getLabel(\"Common.operation.label\",\"common\");\n  var sideApplicable_title=getLabel(\"eOT.SideApplicable.Label\",\"ot\");\n\n  function Class_row(){\n     this.oper_code =\"\";\n     this.oper_desc =\"\";\n     this.side_applicable =\"\";\n\t this.side_applicable_desc=\"\";\n     this.remarks = \"\";\n\t this.line_no=\"\";\n\t this.side_applicable_yn=\"\";\n\t this.proc_link=\"\";\n\t this.proc_result=\"\";\n\t this.term_id=\"\";\n\t this.term_code=\"\";\n\t this.term_desc=\"\";\n\t this.color=\"\";\n\t this.order_line_no=\"\";\n\t this.order_id=\"\";\n\t this.db_mode=\"\";\n\t this.bill_str=\"\";\n\t this.panel_str=\"\";\n\t this.posted_yn=\"\";\n\t this.rate=\"\";\n\t}\n\n/* function moveMandatoryOperations(){\nvar rows=parent.parent.ObjectCollect.rows;\n\tfor( var j in rows){\n\t\tif( rows[j].db_mode!=\"D\" && rows[j].color==\"MANDATORY\" ){\n\t\t\t \n\t\t}\n\t}\n\n}*/\n\n/*function disableDocLevel(){\n   var formObj = parent.parent.common_patient_hdr_frame.CommonOperDtlsHdrForm;\n   if(formObj.doc_level.disabled==false)\n\t   formObj.doc_level.disabled=true;\n}*/\n\n\nfunction loadDBRows(line_no,oper_code,oper_desc,side_applicable,remarks,proc_link,proc_result,term_id,term_code,color,term_desc,order_line_no,order_id,bill_str,panel_str,mode,oper_line_status,cancel_remarks){ \n\t\n  var rowLeng=parent.parent.parent.ObjectCollect.rowLength;\n  var rows = parent.parent.parent.ObjectCollect.rows;\n \n  if(mode==\'L\' && rowLeng==0){\n\t   var objrow = newRow();\n\t   objrow.oper_code=oper_code;\n\t   objrow.oper_desc=unescape(oper_desc);\n\t   objrow.side_applicable=side_applicable;\n\t   if(side_applicable==\"R\"){\n\t\t  objrow.side_applicable_desc=rightSide_title;\n\t\t  objrow.side_applicable_yn=\"Y\";\n\t   }else if(side_applicable==\'B\'){\n\t\t   objrow.side_applicable_yn=\"Y\";\n\t\t  objrow.side_applicable_desc=bilateral_title;\n\t   }else if(side_applicable==\'L\'){\n\t\t   objrow.side_applicable_yn=\"Y\";\n\t\t  objrow.side_applicable_desc=leftSide_title;\n\t   }else if( side_applicable==\'N\' || side_applicable==\'\' ){\n\t\t   objrow.side_applicable_yn=\"N\";\n\t      objrow.side_applicable_desc=notApplicable_title;\n\t   }\n\t   objrow.line_no=line_no;\n\t   objrow.remarks=unescape(remarks);\n\t   objrow.proc_link=proc_link;\n\t   objrow.proc_result=proc_result;\n\t   objrow.term_id=term_id;\n\t   objrow.term_code=term_code;\n\t   objrow.term_desc=term_desc;\n\t   objrow.color=color;\n\t   objrow.order_id = order_id\n\t   objrow.order_line_no=order_line_no;\n\t   objrow.db_mode=\"L\";\n\t   objrow.chk_status=oper_line_status;\n\t   objrow.oper_line_status=oper_line_status;\n\t   objrow.cancel_remarks=unescape(cancel_remarks);\n\t   objrow.bill_str=bill_str;\n\t   objrow.posted_yn=bill_str.split(\"::\")[4];\n\t   objrow.panel_str=panel_str;\n\t   objrow.rate=\"\";\n\t   \n\t   rows.push(objrow);\n\t }\n}\n\n\n\nfunction refresh(){\n\n\tvar formObj = document.forms[0];\n\tvar param = formObj.params.value\n\tvar tab = formObj.tab.value;\n\tparent.ResultsFrame.location.href=\'../../eOT/jsp/SurgeonOperationDtls.jsp?\'+param;\n\n}\n\n\nfunction chkEmpty(){\n\tvar formObj = document.RecordOperationForm; \n\tvar side_applicable_yn = formObj.side_applicable_yn.value;\n\tif(side_applicable_yn==\'N\'){\n\t\tvar fields = new Array(formObj.oper_code);\n\t\tvar names = new Array(operation_title);\n\t}else{\n\t\tvar fields = new Array(formObj.oper_code,formObj.side_applicable);\n\t\tvar names = new Array(operation_title,sideApplicable_title);\n\t }\n\tvar messageFrame = parent.parent.messageFrame;\n\tif(checkFields( fields, names, messageFrame))\n\t\treturn true;\n}\n\nfunction callPopulateList(flag){}\n\nfunction addRow(oper_code,oper_desc,side_applicable,remarks,mode,chk_status,cancel_remarks){\n\tvar formObj = document.forms[0];\n\tvar tab = formObj.tab.value;\n\tvar params2 = formObj.params.value;\n\tvar bill_flag = formObj.bill_flag.value;\n\tvar proc_chrg_cmp_yn = formObj.proc_chrg_cmp_yn.value;\n\t//alert(\"Enters in New Row\");\n\tvar objrow = newRow();\n\t//alert(parent.RecordFrame.frames[0].name);\n\tvar rows=parent.parent.ObjectCollect.rows;\n\t//var msg=\"Code already selected.........\";\n\tvar msg=getMessage(\"CODE_ALREADY_EXISTS\",\"Common\");\n\t//alert(mode);\n\tif(chk_status !=\"99\")\n\t{\n\t\tchk_status=\"\";\n\t}\n  if(chkEmpty()){\n    if(mode==\'I\'){\n\t  if(alreadyExist(oper_code,mode)){\n\t\tif(bill_flag==\"true\")\n\t\t{\n\t\t\tvar xmlDoc = \"\" ;\n\t\tvar xmlHttp = new XMLHttpRequest();\n\t\tvar params= \"order_catalog_code=\"+oper_code;\n\t\tvar xmlStr =\"<root><SEARCH \";\n\t\txmlStr +=\" /></root>\";\n\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\txmlHttp.open(\"POST\",\"CommonValidation.jsp?func_mode=from_direct_booking&\"+params,false);\n\t\txmlHttp.send(xmlDoc);\n\t\tvar retVal1 = trimString(xmlHttp.responseText);\n\n\n\t\tif(retVal1 ==\"Y\")\n\t\t\t{\n\t\tvar retVal = callOrderLineCreation();\n\t\tretVal=trimString(retVal);\n\t\tvar arr = retVal.split(\"@@\");\n\t\t//alert(arr[0]);\n\t\t//alert(arr[2]);\n\t\tif(arr[0]==\"BL0639\" && bill_flag==\"true\"){\n\t\t\talert(getMessage(\"BL0639\",\"BL\"));\n\t\t\treturn false;\n\t\t}\n\t\tif(localTrimString(arr[2])!=\'\')\n\t\t\t{\n\t\t\tvar err_pat=localTrimString(arr[2]);\n\t\t\talert(err_pat);\n\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\t}\n\t\t   objrow.oper_code=oper_code;\n\t\t   objrow.oper_desc=oper_desc;\n\t\t   objrow.side_applicable=side_applicable;\n\t\t   objrow.side_applicable_yn=formObj.side_applicable_yn.value;\n\t\t\tif(side_applicable==\"R\"){\n\t\t\t\tobjrow.side_applicable_desc=rightSide_title;\n\t\t\t\t//objrow.side_applicable_yn=\"Y\";\n\t\t\t}else if(side_applicable==\'B\'){\n\t\t\t\t//objrow.side_applicable_yn=\"Y\";\n\t\t\t\tobjrow.side_applicable_desc=bilateral_title;\n\t\t\t}else if(side_applicable==\'L\'){\n\t\t\t\t//objrow.side_applicable_yn=\"Y\";\n\t\t\t\tobjrow.side_applicable_desc=leftSide_title;\n\t\t\t}else if( side_applicable==\'N\' || side_applicable==\'\' ){\n\t\t\t\t//objrow.side_applicable_yn=\"N\";\n\t\t\t\tobjrow.side_applicable_desc=notApplicable_title;\n\t\t\t}   \n\t\t\tobjrow.line_no=getOperLineNumber();\n\t\t    objrow.db_mode=\"I\";\n\t\t    objrow.chk_status=chk_status;\n\n\t\t    objrow.cancel_remarks=escape(cancel_remarks);\n\t\t \tobjrow.remarks=escape(remarks);\n\t\t\t\twith(formObj){\n\t\t\t\t   objrow.proc_link=proc_link.value;\n\t\t\t\t   objrow.proc_result=proc_result.value;\n\t\t\t\t   objrow.term_id=term_id.value;\n\t\t\t\t   objrow.term_code=term_code.value;\n\t\t\t\t   objrow.term_desc=term_desc.value;\n\t\t\t\t   objrow.color=color.value;\n\t\t\t\t   //Billing part called \n\t\t\t\t  // var retval = callOrderLineCreation();\n\t\t\t\t  objrow.order_id = order_id.value;\n\t\t\t\t  objrow.order_line_no=\"\";\n\t\t         }\n\t\t\t\t  if(bill_flag==\"true\")\n\t\t          {\n\t\t\t\t\t  if(retVal1 ==\"Y\")\n\t\t\t{\n\t\t\t\t   var arr = retVal.split(\"@@\");\n\t\t\t\t   objrow.panel_str=arr[0];\n\t\t\t\t   objrow.bill_str=arr[1];\n\t\t\t}\n\t\t\t\t  }\n\t\t   rows.push(objrow);\n\t\t   resetFields();\n\t\t   //parent.parent.RecordFrame.DetailFrame\n\t\t   //parent.parent.RecordFrame.DetailFrame.location.href=\'../../eOT/jsp/SurgeonOperationDtls.jsp?tab=\'+tab;\n\t\tvar mode=\"I\";\n\t\tdocument.forms[0].remarks_one.innerText=getLabel(\"Common.remarks.label\",\"Common\");\n\t\tvar url_val=\'../../eOT/jsp/SurgeonOperationDtls.jsp?\'+params2+\'&mode_one=\'+mode;\n\t\tparent.ResultsFrame.location.href=url_val;\n\t\t   parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n\t\n\t  }else\n\t\t\tparent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'+msg;\n } else\n\t  updateRow(oper_code,oper_desc,side_applicable,remarks,mode,chk_status,cancel_remarks);\n  }\n\n  \t /*Added by Suma for incident 16685 Starts here */\n\n\t\tvar chk_val=\"\";\n\t  var oper_desc_val=\"\";\n\t  var oper_code_val=\"\";\n\t  var status_value=\"\";\n\t\t  if(rows!=null){\n\t\t   for (var jj=0;jj<rows.length ;jj++ )\n\t\t   {\n\t\t\t   var status_val=rows[jj].chk_status;\n\t\t\t   if(status_val ==\"\")\n\t\t\t   {\n\t\t\t\t   status_val=\"1\";\n\t\t\t   }\n\t\t\t   chk_val +=rows[jj].oper_code+\"*\" +status_val+\"*\"+rows[jj].db_mode+\"$\";\n\t\t\t   oper_desc_val +=rows[jj].oper_desc +\"*\";\n\t\t\t   oper_code_val +=rows[jj].oper_code +\"*\";\n\t\t\t   status_value +=status_val +\"*\";\n\t\t   }\n\t\t  }\n\n\n\t\t\t\tvar xmlDoc = \"\" ;\n\t\t\t\tvar xmlHttp = new XMLHttpRequest();\n\t\t\t\tvar params = \"status_val=\"+chk_val;\n\t\t\t\tvar xmlStr =\"<root><SEARCH \";\n\t\t\t\txmlStr +=\" /></root>\";\n\t\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\t\txmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=new_operation&\"+params,false);\n\t\t\t\txmlHttp.send(xmlDoc);\n\t\t\t\tvar retVal = trimString(xmlHttp.responseText);\n\t\t\t\tparent.parent.frames[5].euip_tab.OperationEquipmentsTabForm.oper_code_new.value=retVal;\n\t\t\t\tparent.parent.frames[5].euip_tab.OperationEquipmentsTabForm.oper_code_all.value=oper_code_val;\n\t\t\t\tparent.parent.frames[5].euip_tab.OperationEquipmentsTabForm.status_value.value=status_value;\n\t\t\t\tparent.parent.frames[5].euip_tab.OperationEquipmentsTabForm.oper_desc_val.value=oper_desc_val;\n\n\t\t\t\t/*16685 changes ends here*/\n\n}\n\nfunction assignRowLength(cou){\n\t//parent.parent.ObjectCollect.rowLength=cou;\n\tparent.parent.parent.ObjectCollect.rowLength=cou;\n}\n\n\nfunction newRow(){\n  var objrow = new Class_row();\n   return(objrow);\n}\n\nfunction alreadyExist(oper_code,mode){\n\tvar rows=parent.parent.ObjectCollect.rows;\n\tif(rows.length>0 && mode==\'I\'){\n\t\tfor(var jj=0;jj<rows.length;jj++){\n\t\t\tif(rows[jj]!=null ){\n\t\t\t\tif(rows[jj].oper_code==oper_code){\n\t\t\t\t\treturn false;\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\tcontinue;\n\t\t }\n\t  }\n\t}\n\treturn true;\n}\n\n/*function removeRow(oper_code,mode){\nvar formObj = document.forms[0];\nvar params = formObj.params.value;\nvar tab = formObj.tab.value;\nvar rows=parent.parent.ObjectCollect.rows;\nif(rows.length==1){ \n\talert(\"All the Operation Cannot be Deleted...\");resetFields(); return;}\nif(rows.length>1 && mode==\'U\'){        \n for(var jj=0;jj<rows.length;jj++){\n if(rows[jj]!=null &&  rows[jj].oper_code!=null && rows[jj].oper_code!=\"\") {\n\t if(rows[jj].oper_code==oper_code){\n\t\t if(rows[jj].db_mode==\'I\')\n\t\t\t//delete rows[jj];\n\t\t\trows.splice(jj,1);\n\t\t else\n\t\t\trows[jj].db_mode=\'D\';\n\t   break;\n\t }\n  }else\n\tcontinue;\n }//end for-Loop\n   resetFields();\n   parent.DetailFrame.location.href=\'../../eOT/jsp/SurgeonOperationDtls.jsp?\'+params;\n   parent.parent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp?err_num=\'\n   //parent.parent.RecordFrame.DetailFrame.location.href=\'../../eOT/jsp/SurgeonOperationDtls.jsp?&tab=\'+tab;\n }else\n   //parent.parent.RecordFrame.resetFields();\n   resetFields();\n}*/\n\nfunction updateRow(oper_code,oper_desc,side_applicable,remarks,mode,chk_status,cancel_remarks){\n\n var formObj = document.forms[0];\n var params = formObj.params.value;\n var tab = formObj.tab.value;\n var rows=parent.parent.ObjectCollect.rows;\n if(rows.length>0 && mode==\'U\'){        \n for(var jj=0;jj<rows.length;jj++){\n if(rows[jj]!=null && rows[jj].oper_code!=null && rows[jj].oper_code!=\"\") {\n      if(rows[jj].oper_code==oper_code){\n\t\t  rows[jj].oper_code=oper_code;\t\n\t\t  rows[jj].oper_desc=oper_desc;\n\t\t  rows[jj].side";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 ="_applicable=side_applicable;\n\t\t  rows[jj].side_applicable_yn=formObj.side_applicable_yn.value;\n\t\t  if(side_applicable==\"R\"){\n\t\t\t  //objrow.side_applicable_yn=\"Y\";\n\t\t\trows[jj].side_applicable_desc=rightSide_title;\n\t\t  }else if(side_applicable==\'B\'){\n\t\t\t  //objrow.side_applicable_yn=\"Y\";\n\t\t\trows[jj].side_applicable_desc=bilateral_title;\n\t      }else if(side_applicable==\'L\'){\n\t\t\t  //objrow.side_applicable_yn=\"Y\";\n\t\t    rows[jj].side_applicable_desc=leftSide_title;\n\t      }else if( side_applicable==\'N\' || side_applicable==\'\' ){\n\t\t\t  //objrow.side_applicable_yn=\"N\";\n\t          rows[jj].side_applicable_desc=notApplicable_title;\n\t     }\n\t\t\n\t\t rows[jj].remarks=escape(remarks);\n\t\t rows[jj].cancel_remarks=escape(cancel_remarks);\n\t\t  if(rows[jj].db_mode==\'L\')\n\t\t  {\n\t\t\trows[jj].db_mode=\'U\'\n\t\t  }\n\t\t rows[jj].chk_status=chk_status;\n\t\t    break;\n\t  }\n  }else  \n\t  continue;\n }\n   //parent.parent.RecordFrame.resetFields();\n   resetFields();\n   var mode=\"M\";\n   document.forms[0].remarks_one.innerText=getLabel(\"Common.remarks.label\",\"Common\");\n   parent.ResultsFrame.location.href=\'../../eOT/jsp/SurgeonOperationDtls.jsp?\'+params+\'&mode_one=\'+mode;\n   //parent.parent.RecordFrame.DetailFrame.location.href=\'../../eOT/jsp/SurgeonOperationDtls.jsp?&tab=\'+tab;\n }\n}\n\nfunction localTrimString(sInString) {\n  return sInString.replace(/^\\s+|\\s+$/g,\"\");\n}\n\n\nfunction splitString(strVal){\n    var arr = strVal.split(\'::\');\n\tvar frmObj = document.forms[0];\n\tfrmObj.oper_code.value=arr[0];\n\tfrmObj.oper_desc.value=arr[1];\n\t/*if(arr[2]==\'Right Side\')\n\t  frmObj.side_applicable.value=\'R\';\n     else if(arr[2]==\'Both Sides\')\n\t\tfrmObj.side_applicable.value=\'B\';\n\t else if(arr[2]==\'Left Side\')\n\t\t frmObj.side_applicable.value=\'L\';*/\n     frmObj.side_applicable.value = (arr[2]==\'N\')?\"\":arr[2];\nif(arr[8] !=\"99\")\n{\n\tfrmObj.remarks.style.visibility=\"visible\";\n\tfrmObj.remarks.style.display=\"inline\";\n\tfrmObj.cancel_remarks.style.visibility=\"hidden\";\n\tfrmObj.cancel_remarks.style.display=\"none\";\n}else\n{\n\tfrmObj.cancel_remarks.style.visibility=\"visible\";\n\tfrmObj.cancel_remarks.style.display=\"inline\";\n\tfrmObj.remarks.style.visibility=\"hidden\";\n\tfrmObj.remarks.style.display=\"none\";\n}\n\n\t frmObj.remarks.value=unescape(arr[3]);\n\t frmObj.cancel_remarks.value=unescape(arr[7]);\n\n\n\n\tfrmObj.mode.value=arr[4];\n\tfrmObj.side_applicable_yn.value=arr[5];\n\tfrmObj.count_val.value=arr[9];\n\n\t//alert(frmObj.side_applicable_yn.value);\n\tfrmObj.OperationLookUp.disabled=true;\n\tif(arr[5]!=\"Y\")\n\t\tfrmObj.side_applicable.disabled=true;\n\telse\n\t\tfrmObj.side_applicable.disabled=false;\n  }\n\nfunction resetFields(){\n\tvar frmObj = document.forms[0];\n\tfrmObj.oper_code.value=\'\';\n\tfrmObj.oper_desc.value=\'\';\n\tfrmObj.side_applicable.value=\'\';\n\tfrmObj.remarks.value=\'\';\n\tfrmObj.cancel_remarks.value=\'\';\n\tfrmObj.mode.value=\'I\';\n\tfrmObj.side_applicable_yn.value=\'\';\n\tfrmObj.OperationLookUp.disabled=false;\n\tfrmObj.OperationLookUp.focus();\n\tfrmObj.chk_status.disabled=true;\n\tfrmObj.chk_status.checked=false;\n\t//frmObj.btn_cancel.disabled=false;\n}\n\nfunction checkLimit(field, limit){\n\t if (field.value.length > limit){\n\t\t   //alert(limit+\'characters only allowed\');\n\n\t\t   var msg = getMessage(\"MAX_LENGTH_DATA\",\"OT\");\n\t\t   var msgArray = msg.split(\"#\");\n\t\t   alert(msgArray[0]+\"\"+msgArray[1]+limit+msgArray[2]);\n\n\t\t   // Truncate at the limit\n\t\t   var revertField = field.value.slice(0, limit);\n\t\t   field.value = revertField;\n\t\t   field.focus();\n\t  }\n}\n\nfunction setOperLineNumber(line_no){\n   //var frmObj = parent.parent.ObjectCollect;\n var  frmObj = parent.parent.parent.ObjectCollect;\n   if(frmObj.line_no==0){\n\t\tfrmObj.line_no = parseInt(line_no,10);\n   }\n   //alert(\"assing \"+frmObj.line_no); \n}\n\nfunction getOperLineNumber(){\n   //frmObj = parent.parent.ObjectCollect;\n\tfrmObj = parent.parent.parent.ObjectCollect;\n   //alert(\"Before Incrementing \"+frmObj.line_no);\n  var line_no= (isNaN(frmObj.line_no)==true)?1:frmObj.line_no+1;\n  // var line_no= (frmObj.line_no==Number.NaN)?1:frmObj.line_no+1;\n   //alert(\"After Incrementing \"+line_no);\n   parent.parent.ObjectCollect.line_no = line_no;\n   //alert(\"After  assing \"+frmObj.line_no);\n   return line_no;\n}\n\n\nfunction LoadMandatoryFlag(code,flag){\n\tvar flag=true;\n\trows = parent.parent.parent.ObjectCollect.mandatory_proc;\n\tif(rows.length!=0) \n\t{\n\tfor(var j in rows) {\n\t\t    alert(\"j==== \" +j);\n\t\t\talert(\"rows[j] :\" +rows[j]);\n\t\t\tif(j==code)\n\t\t\trows[code]=rows[j];\t\t\n\t}\n\t}\n\telse {\n\trows[code]=flag;\n\t}\n\t\n}\n\nfunction callOrderLineCreation(){\n\tvar formObj = document.forms[0];\n\tvar order_id = formObj.order_id.value;\n\tvar oper_num = formObj.oper_num.value;\n\tvar oper_code = formObj.oper_code.value;\n\tvar param = \"order_id=\"+order_id+\"&oper_num=\"+oper_num+\"&oper_code=\"+oper_code+\"&called_from=RECORD_SURGEON\";\n\tvar xmlStr =\"<root></root>\";\n\tvar temp_jsp=\"OTOrderLineCreation.jsp?\"+param;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar responseText=trimString(xmlHttp.responseText) ;\n\t//alert(responseText);\n\treturn responseText;\n}\n\nfunction trimString(sInString) {\n  sInString = sInString.replace( /^\\s+/g, \"\" );// strip leading\n  return sInString.replace( /\\s+$/g, \"\" );// strip trailing\n}\n\n</script>\n</HEAD>\n<BODY OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name = \'RecordOperationForm\'>\n<input type=\'hidden\' name=\'rowLength\' id=\'rowLength\' value=\'0\'>\n<input type=\'hidden\' name=\'tab\' id=\'tab\' value=\'";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n<tr> \n\t  <td class=\"label\" width=\'0%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" </td>\n\t  <td class=\"fields\" width=\'0%\'>\n\t\t  <input type=\'text\' name=\'oper_code\' id=\'oper_code\' maxlength=\'10\' readonly> \n\t\t  <input type=\'button\' class=\'button\' value=\'?\' name=\'OperationLookUp\' id=\'OperationLookUp\' onClick=\'searchOperations(document.forms[0].mode.value);\'  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" > <img name=\'imageflag1\' src=\'../../eCommon/images/mandatory.gif\'></img>\n\t  </td>\n<!-- </tr>\n<tr> -->\n \t  <td class=\"label\" width=\'0%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </td>\n     <td class=\"fields\" width=\'0%\'>\n\t\t<input type=\'text\' name=\'oper_desc\' id=\'oper_desc\' size=\'30\' readonly> \n\t</td>\n</tr>\n\n<tr>\n  <td class=\"label\" width=\'0%\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </td>\n\t<td class=\"fields\" width=\'0%\'>\n\t\t<select name=\'side_applicable\' id=\'side_applicable\' DB_VALUE=\'\' ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" >\n\t\t<option value=\'\' >";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\n\t\t<option value=\'R\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" </option>\n\t\t<option value=\'L\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </option>\n\t\t<option value=\'B\' >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" </option>\n\t\t</select>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' name=\'imageflag\'></img>\n\t</td>\n    <td class=\"label\" valign=\'top\'  width=\'0%\'  id=\'remarks_one\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" </td>\n\t<td class=\"fields\" width=\'0%\'>\n\t\t<textarea rows=\'5\' cols=\'40\' name=\'remarks\' ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" onKeyPress=\"return checkLimit(this,\'1700\');\"></textarea>\n\t\t<textarea rows=\'5\' cols=\'40\'  style=\'visibility:hidden;display:none\' name=\'cancel_remarks\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" onKeyPress=\"return checkLimit(this,\'1700\');\"></textarea>\n\n\t</td> \n\t\n<!-- </tr>\n<tr> -->\n\t\n\t</tr>\n\t<tr>\n\t\t<input type=\'hidden\' name=\'count_val\' id=\'count_val\' value=\"\">\n\n\t<td  class=\"label\" valign=\'top\'  COLSPAN=\'2\'  >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t<input type=\"checkbox\"  name=\"chk_status\" id=\"chk_status\"  onclick=\"assignChkBoxVal(this,document.forms[0].mode.value,document.forms[0].oper_code.value,document.forms[0].count_val.value)\" disabled >\n\t</td>\n\t<td width=\"25%\"></td>\n\t<td class=\"button\" width=\'0%\' align=\'right\'>\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' name=\"btn_select\" onClick=\'addRow(document.forms[0].oper_code.value,document.forms[0].oper_desc.value,document.forms[0].side_applicable.value,document.forms[0].remarks.value,document.forms[0].mode.value,document.forms[0].chk_status.value,document.forms[0].cancel_remarks.value);\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >\n\t\t<!-- <input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' name=\"btn_cancel\" onClick=\'removeRow(document.forms[0].oper_code.value,document.forms[0].mode.value);\' ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" > -->\n\t</td>\n</tr>\n</table>\n   <!-- added by Sathish for Amazon Changes-->\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t<!-- end -->\n\t<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n\t<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n\t<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t<input type=\'hidden\' name=\'collect_speciality_code\' id=\'collect_speciality_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'side_applicable_yn\' id=\'side_applicable_yn\' value=\'\'>\n\t<input type=\'hidden\' name=\'proc_link\' id=\'proc_link\' value=\"\">\n\t<input type=\'hidden\' name=\'proc_result\' id=\'proc_result\' value=\"\">\n\t<input type=\'hidden\' name=\'term_id\' id=\'term_id\' value=\"\">\n\t<input type=\'hidden\' name=\'term_code\' id=\'term_code\' value=\"\">\n\t<input type=\'hidden\' name=\'term_desc\' id=\'term_desc\' value=\"\">\n\t<input type=\'hidden\' name=\'color\' id=\'color\' value=\"\">\n\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\"hidden\" name=\"bill_flag\" id=\"bill_flag\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\"hidden\" name=\"remarks_hidden\" id=\"remarks_hidden\" value=\"\">\n\t<input type=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=\"hidden\" name=\"oper_line_status\" id=\"oper_line_status\" value=\"\">\n\t<input type=\"hidden\" name=\"proc_chrg_cmp_yn\" id=\"proc_chrg_cmp_yn\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );
 
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
  
	 String locale = (String)session.getAttribute("LOCALE"); 
	 request.setCharacterEncoding("UTF-8");	
	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	
	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
	String tab = checkForNull(request.getParameter("tab")); 
	String params = request.getQueryString();
	if(tab.equals("record_surgeon")){ 
            _bw.write(_wl_block7Bytes, _wl_block7);
}else if(tab.equals("record_nursing")){ 
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);
            out.print( String.valueOf(tab));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(params));
            _bw.write(_wl_block11Bytes, _wl_block11);

	
	String called_from = request.getParameter("called_from");
	String facility_id = checkForNull(request.getParameter("facility_id"));
	String oper_num = checkForNull(request.getParameter("oper_num"));
	String surgeon_doc_comp_yn = checkForNull(request.getParameter("surgeon_doc_comp_yn"));
	String proc_chrg_cmp_yn = checkForNull(request.getParameter("proc_chrg_cmp_yn"));
	String bill_flag = request.getParameter("bill_flag");
	String disable_flag="";
	String line_no="";
	String oper_code="";
	String oper_desc="";
	String side_applicable="";
	String remarks="";
	String max_oper_num="";
	String proc_link=""; 
	String proc_result="";
	String term_set_id="";
	String term_code= ""; 
	String term_desc= ""; 
	String color= ""; 
	String proc_code_entered_yn="";
	String auto_populate_yn = "";
	String auto_param = "";
	String order_line_no = "";
	String order_id = "";
	String panel_str="";
	String posted_yn="";
	String module_id="";

	String oper_line_status="";
	String cancel_remarks="";
	//String service_panel_ind = "";
	//String service_panel_code = "";
	HashMap bill_info = new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	String bill_str  = "";
	//ArrayList lst = new ArrayList(2);
	

	

	/*String SQL = "SELECT A.OPER_CODE,A.OPER_LINE_NUM, B.SHORT_DESC,A.RIGHT_LEFT_FLAG,A.OPER_REMARKS FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE";*/
	
	/*
	 SELECT A.OPER_CODE, A.OPER_LINE_NUM, B.SHORT_DESC, A.RIGHT_LEFT_FLAG A.OPER_REMARKS, C.PROC_LINK_APPLICABLE,C.PROC_LINK_RESULTING_OPTION,C.TERM_SET_ID,C.TERM_CODE 
	 FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B, OR_ORDER_CATALOG C
	 WHERE A.OPERATING_FACILITY_ID     = ? 
	 AND A.OPER_NUM                               = ? 
	 AND A.OPER_CODE                             = B.OPER_CODE
	 AND B.ORDER_CATALOG_CODE          = C.ORDER_CATABLOG_CODE

	
	*/


	/*SQL =SELECT A.OPER_CODE,A.OPER_LINE_NUM, B.SHORT_DESC,DECODE(A.RIGHT_LEFT_FLAG,'R','Right Side','L','Left Side','B','Both Sides') RIGHT_LEFT_FLAG,A.OPER_REMARKS FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND NVL(STATUS,'E')='E'*/

	/*String SQL1 = "SELECT MAX(OPER_LINE_NUM) FROM OT_POST_OPER_DTLS WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=?";*/

	String SQL ="SELECT A.OPER_CODE, A.OPER_LINE_NUM, B.SHORT_DESC, A.RIGHT_LEFT_FLAG, A.OPER_REMARKS,C.PROC_LINK_APPLICABLE,C.PROC_LINK_RESULTING_OPTION,C.TERM_SET_ID,TRIM(C.TERM_CODE) TERM_CODE,DECODE(PROC_LINK_RESULTING_OPTION,'M','MANDATORY','O','OPTIONAL',DECODE(C.PROC_LINK_APPLICABLE,'P','AUTO','NA')) COLOR,A.ORDER_LINE_NUM ORDER_LINE_NUM,A.ORDER_ID ORDER_ID,A.OPER_LINE_STATUS OPER_LINE_STATUS,A.CANCEL_REMARKS CANCEL_REMARKS FROM OT_POST_OPER_DTLS A, OT_OPER_MAST_LANG_VW B, OR_ORDER_CATALOG_LANG_VW C WHERE C.LANGUAGE_ID='"+locale+"' AND B.LANGUAGE_ID=? AND A.OPERATING_FACILITY_ID  = ? AND A.OPER_NUM  =?  AND A.OPER_CODE = B.OPER_CODE AND B.ORDER_CATALOG_CODE = C.ORDER_CATALOG_CODE";

		
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt2 = null;
	//CallableStatement cstmt = null;
	ResultSet rst = null;	
	ResultSet rset = null;	
	ResultSet rset2 = null;	
		int count=0;
	try{
		con = ConnectionManager.getConnection(request);
		//pstmt = con.prepareStatement(SQL);
		//pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_OPERATIONS_SELECT1"));


	if(proc_chrg_cmp_yn.equals("Y"))
		disable_flag="disabled";
	else 
		disable_flag="";


		pstmt = con.prepareStatement(SQL);
		//for calling Billing Procedure
		//cstmt=con.prepareCall("{call BL_PROC_FOR_EXT_SERVICE_MP.GET_ORDER_CATALOG_DTLS(?,?,?,?,?,?,?,?,?,?)}");
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);
		pstmt.setString(3,oper_num);
		rst = pstmt.executeQuery();
	
		while(rst.next()){
			count++;
			line_no = checkForNull(rst.getString("OPER_LINE_NUM"));
			oper_code=checkForNull(rst.getString("OPER_CODE"));
			oper_desc= encode(checkForNull(rst.getString("SHORT_DESC")));
			side_applicable= checkForNull(rst.getString("RIGHT_LEFT_FLAG"));
			remarks=encode(checkForNull(rst.getString("OPER_REMARKS")));
			proc_link= checkForNull(rst.getString("PROC_LINK_APPLICABLE"));
			proc_result=checkForNull(rst.getString("PROC_LINK_RESULTING_OPTION"));
			term_set_id = checkForNull(rst.getString("TERM_SET_ID"));
			term_code  = checkForNull(rst.getString("TERM_CODE"));
			color  = checkForNull(rst.getString("COLOR"));

			//KEY and KEY_LINE_NO for Billing Key
			order_id = checkForNull(rst.getString("ORDER_ID"));
			oper_line_status = checkForNull(rst.getString("OPER_LINE_STATUS"));
			cancel_remarks= checkForNull(rst.getString("CANCEL_REMARKS"));
			order_line_no = checkForNull(rst.getString("ORDER_LINE_NUM"));
			posted_yn = billing_bean.billingPostedYN(oper_num,line_no);
			if(("true").equals(bill_flag)){
			bill_info = or_bean.getOrderBillDtls(order_id+order_line_no);	
			if(bill_info==null || (bill_info!=null && bill_info.size()==0)){
				bill_info = new HashMap();
				if("X".equals(posted_yn)){
					module_id = "OT";
					bill_info.put("key",oper_num);
				}else{
					module_id = "OR";
					bill_info.put("key",order_id);
				}
				bill_info.put("key_line_no",order_line_no);
				bill_info.put("oper_code",oper_code);
				bill_info.put("oper_num",oper_num);
				bill_info.put("locale",locale);
				bill_info.put("module_id",module_id);
				bill_info.put("quantity","1");
				bill_info.put("oper_line_status",oper_line_status);
				bill_info.put("cancel_remarks",cancel_remarks);
				
				//populate billing details from OTBillingBean........	
				bill_info = billing_bean.getBillingParams(bill_info,"S");
				or_bean.setOrderBillDtls(order_id+order_line_no,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
				//bill_info.clear();
			}
			panel_str = (String) bill_info.get("bl_panel_str");
			}//end ofm if bill_flag
			if(!term_code.equals("")){
				pstmt1	 = con.prepareStatement("SELECT SHORT_DESC PROC_DESC FROM MR_TERM_CODE WHERE TERM_CODE=?");
				pstmt1.setString(1,term_code);
				rset = pstmt1.executeQuery();
				while(rset.next()){
					term_desc = rset.getString("PROC_DESC");			
				}
			}


			if("M".equals(proc_result)){
				pstmt1	 = con.prepareStatement("SELECT DECODE(COUNT(PROC_CODE),'0','N','Y') FROM OT_POST_OPER_PROC_DTLS  WHERE  OPERATING_FACILITY_ID = ? AND OPER_NUM =?   AND  OPER_CODE=?");
				pstmt1.setString(1,facility_id);
				pstmt1.setString(2,oper_num);
				pstmt1.setString(3,oper_code);
				rset = pstmt1.executeQuery();
				while(rset.next()){
					proc_code_entered_yn = rset.getString(1);			
				}
				out.println("<script> LoadMandatoryFlag('"+oper_code+"','"+proc_code_entered_yn+"')</script>");
			}

			if( "P".equals(proc_link) ){
				pstmt1	 = con.prepareStatement("SELECT DECODE(COUNT(PROC_CODE),'0','I','L') FROM OT_POST_OPER_PROC_DTLS  WHERE  OPERATING_FACILITY_ID = ? AND OPER_NUM =?   AND  OPER_CODE=?");
				pstmt1.setString(1,facility_id);
				pstmt1.setString(2,oper_num);
				pstmt1.setString(3,oper_code);
				rset = pstmt1.executeQuery();
				while(rset.next()){
					auto_populate_yn = rset.getString(1);			
				}
				if("I".equals(auto_populate_yn)){
					auto_param = line_no+"::"+oper_code+"::"+oper_desc+"::"+term_set_id+"::"+term_code+"::"+color+"::"+term_desc;
					out.println("<script>autoPopulate('"+auto_param+"')</script>");
				}
					
			}

			//out.println("<script>loadDBRows('"+line_no+"','"+oper_code+"','"+oper_desc +"','"+side_applicable +"','"+remarks+"','L'); </script>");
            if(("true").equals(bill_flag)){
			String reason_code=null;
			String overridden_incl_excl_ind=null;
			bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
			bl_bfr.append(overridden_incl_excl_ind).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
			//bl_bfr.append(checkForNull(posted_yn,"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
			bl_bfr.append(reason_code).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("err_id"),""));

			bill_str = bl_bfr.toString();
			bl_bfr.setLength(0);
			}
			out.println("<script>loadDBRows('"+line_no+"','"+oper_code+"','"+oper_desc +"','"+side_applicable +"','"+remarks+"','"+proc_link+"','"+proc_result+"','"+term_set_id+"','"+term_code+"','"+color+"','"+term_desc+"','"+order_line_no+"','"+order_id+"','"+bill_str+"','"+panel_str+"','L','"+oper_line_status+"','"+cancel_remarks+"');</script>");
			//out.println("<script>calldhana();</script>");	
			//addRow(oper_code,oper_desc,side_applicable,line_no,remarks,mode)

		}
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_OPERATIONS_SELECT2"));
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		rst = pstmt.executeQuery();
		while(rst.next()){
			max_oper_num = rst.getString(1);			
		}
			if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();

    	out.println("<script> assignRowLength('"+count+"');</script>");
		out.println("<script> setOperLineNumber('"+max_oper_num+"');</script>");
		out.println("<script>refresh();</script>");
		out.println("<script>assignAutoLength();</script>");

	}catch(Exception e){
		e.printStackTrace();
		System.err.println("SurgeonOper Record:  Err Msg in RecordSurgeon"+e.getMessage());
		////eOT.LogFile.log("RecordServletDebugger","In Record Surgeon"+e.getMessage(),this);
	}
	finally{
		if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
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

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block29Bytes, _wl_block29);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bill_flag));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(count));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(proc_chrg_cmp_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SideApplicable.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.RightSide.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.LeftSide.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Bilateral.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
