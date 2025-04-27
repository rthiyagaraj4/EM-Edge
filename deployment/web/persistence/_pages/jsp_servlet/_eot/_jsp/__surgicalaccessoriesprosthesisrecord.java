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
import eCommon.Common.*;
import eOT.*;
import eOT.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __surgicalaccessoriesprosthesisrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SurgicalAccessoriesProsthesisRecord.jsp", 1709120390000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="                           \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8_0 ="\' type=\'text/css\'/>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script language=\'javascript\' src=\'../../eOT/js/BlockSlotsBySpeciality.js\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eOT/js/SurgicalAccessories.js\"></script>\n<script Language=\"JavaScript\">\nfunction Class_row(){\n     this.prosthesis_code=\"\";\n\t this.prosthesis_desc=\"\";\n\t //Mode - L=when retrieving from DB ,I=Insert,U=update,D=delete\n\t   this.type=\"S\";\n     this.no_Of_Units=\"\";\n     this.mode=\"\";\n\t this.recId =\"\";\n}\n// This Function checks for Duplicate Start & End Times\nfunction alreadyExist(){\n\tvar formObj = document.SurgicalAccessoriesProsthesisRecordForm;\n\tvar prosthesisCodeDtl =window.parent.frames[4].prosthesis_code; //detail frame\n\tvar frmprosthesis_code=formObj.prosthesis_code.value;\n\tvar err_txt=\"\";\n\tvar dtl_arr = prosthesisCodeDtl.split(\",\");\n\tvar dtl_arr_length = dtl_arr.length;\n\tvar err_flag = \"false\";\n\tvar i = 0;\n\tif(prosthesisCodeDtl!=null && prosthesisCodeDtl!=\"\"){\n\t\tif(dtl_arr_length>0){\n\t\t\twhile(i<=dtl_arr_length-2 && err_flag==\"false\"){\n\t\t\t\tif(dtl_arr[i] == frmprosthesis_code){\n\t\t\t\t\terr_txt+=getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\n\t\t\t\t\terr_flag = \"true\";\n\t\t\t\t}\n\t\t\t\ti++;\n\t\t\t}\n\t\t}\n\t}\n        /*if(prosthesisCodeDtl.indexOf(frmprosthesis_code)>=0){\n\t\t\t//err_txt+=\"APP-OT40 Code Cannot Be Duplicated...\";\n\t\t\terr_txt+=getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\n\t\t}*/\n\t\t if(err_txt.length>0){\n              parent.parent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+err_txt;\n\t     \t  return false;\n\t\t}else return true;\n}\nfunction ChkNumber(obj){\n\tvar quantity=obj.value;\n////alert(window.parent.parent.frames[1].frames[4].name);\n\t//CheckNum(obj);\n\tif(isNaN(quantity)==true)\n\t{\n\t//alert(\"Enter a valid no\");\n\talert(getMessage(\"INVALID_NEXT_NUMBER\",\"common\"));\n\t   obj.select();\n\t   obj.focus();\n}\n\tif(obj.value!=\"\" && quantity<=0){\n\t//alert(\"No. Of Units  cannot be less than or equal to zero\");\n\tvar msg=getMessage(\"APP-OT0068\",\"OT\");\n\tvar msgarry=msg.split(\"#\");\n\tvar noofUnits=getLabel(\"eOT.NoofUnits.Label\",\"OT\");\n\talert(msgarry[0]+noofUnits+msgarry[1]);\n\t  obj.select();\n\t  obj.focus();\n\t}\n}\n function chkEmpty(){\n\tvar desc=getLabel(\"Common.description.label\",\"common\");\n\tvar formObj = document.forms[0];\n\tvar fields = new Array(formObj.prosthesis_desc);\n\tvar names = new Array(desc);\n\tvar messageFrame = parent.parent.messageFrame;\n\tif(checkFieldsofMst( fields, names, messageFrame))\n\t\treturn true;\n}\nfunction newRow(){\n  var objrow = new Class_row(); // \n   return(objrow);\n}\nfunction chkForDuplicates()\n{\n\tvar DtlformObj=document.forms[0];\n\tvar masterframe = window.parent.frames[0];\n\tvar HdrformObj=masterframe.document.forms[0];\n    var appl_desc=HdrformObj.appl_desc.value;\n\tvar speciality_code=HdrformObj.speciality_code.value;\n\tvar category_code=HdrformObj.category_code.value;\n    var subCategory_code=HdrformObj.subCategory_code.value;\n\tvar operation_code=HdrformObj.operation_code.value;\n\tvar prosthesis_code=DtlformObj.prosthesis_code.value;\n\tvar dtlString=DtlformObj.dtlString.value;\n\t\tvar function_id=document.forms[0].function_id.value;\n\tvar surgeon_desc=\"\";\nif(function_id == \"OT_MST_CODE_SURGPREF\")\n{\n\tsurgeon_desc=HdrformObj.surgeon_code.value;\n}\n\n\tvar arr=dtlString.split(\"#\");\n\tvar err_txt=\"\";\n\tfor (var i=0;i<arr.length;i++ )\n\t{\n\t\tvar chkString=arr[i];\n\t\tif(appl_desc==\"AOPR\"){\n\t\t\t if(function_id == \"OT_MST_CODE_SURGPREF\")\n\t\t{\n\t\t\t\t if(chkString.indexOf(prosthesis_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(surgeon_desc)>=0){\n\t\t\t\terr_txt=getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\n\t\t    }\n\t\t}else\n\t\t{\n\t      \tif(chkString.indexOf(prosthesis_code)>=0 && chkString.indexOf(appl_desc)>=0){\n\t\t\terr_txt=getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\n\t\t    }\n\t\t}\n\t   }else if(appl_desc==\"SSPL\"){\n\t\t   if(speciality_code==\'\'){\n\t\t\t   err_txt=getMessage(\"CANNOT_BE_BLANK\",\"OT\");\n\t\t\t\tvar msgArray = err_txt.split(\"&\");\n\t\t\t\tvar speciality=getLabel(\"Common.speciality.label\",\"common\");\n\t\t\t\talert(msgArray[0]+speciality+msgArray[1]);\n\t\t\t\treturn;\n\t\t   } else{\n\t\t\t   if(function_id == \"OT_MST_CODE_SURGPREF\")\n\t\t{\n\t\t\t\t   \tif(chkString.indexOf(prosthesis_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(surgeon_desc)>=0){\n\t\t\terr_txt=getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\n\t\t    }\n\t\t}else\n\t\t\t   {\n\t      \tif(chkString.indexOf(prosthesis_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0){\n\t\t\terr_txt=getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\n\t\t    }\n\t\t   }\n\t\t   }\n\t   }else if(appl_desc==\"SCAT\"){\n\t\t   if(speciality_code==\'\'){\n\t\t\t   err_txt=getMessage(\"CANNOT_BE_BLANK\",\"OT\");\n\t\t\t\tvar msgArray = err_txt.split(\"&\");\n\t\t\t\tvar speciality=getLabel(\"Common.speciality.label\",\"common\");\n\t\t\t\talert(msgArray[0]+speciality+msgArray[1]);\n\t\t\t\treturn;\n\t\t   } else if(category_code==\'\'){\n    \t\t    err_txt=getMessage(\"CANNOT_BE_BLANK\",\"OT\");\n\t\t\t\tvar msgArray = err_txt.split(\"&\");\n\t\t\t\tvar category1=getLabel(\"Common.category1.label\",\"common\");\n\t\t\t\talert(msgArray[0]+category1+msgArray[1]);\n\t\t\t\treturn;\n\t\t   }else{\t\t\t\n\t\t\t    if(function_id == \"OT_MST_CODE_SURGPREF\")\n\t\t{\n\t\t\t\t\tif(chkString.indexOf(prosthesis_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0 && chkString.indexOf(surgeon_desc)>=0){\n\t\t\terr_txt=getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\n\t\t    }\n\t\t}else\n\t\t\t   {\n\t\t\tif(chkString.indexOf(prosthesis_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0){\n\t\t\terr_txt=getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\n\t\t    }\n\t\t   }\n\t\t   }\n\t   }else if(appl_desc==\"SSUB\"){\n\t\t     if(speciality_code==\'\'){\n\t\t\t   err_txt=getMessage(\"CANNOT_BE_BLANK\",\"OT\");\n\t\t\t\tvar msgArray = err_txt.split(\"&\");\n\t\t\t\tvar speciality=getLabel(\"Common.speciality.label\",\"common\");\n\t\t\t\talert(msgArray[0]+speciality+msgArray[1]);\n\t\t\t\treturn;\n\t\t   } else if(category_code==\'\'){\n                err_txt=getMessage(\"CANNOT_BE_BLANK\",\"OT\");\n\t\t\t\tvar msgArray = err_txt.split(\"&\");\n\t\t\t\tvar category1=getLabel(\"Common.category1.label\",\"common\");\n\t\t\t\talert(msgArray[0]+category1+msgArray[1]);\n\t\t\t\treturn;\n\t\t   }else if(subCategory_code==\'\'){\n               err_txt=getMessage(\"CANNOT_BE_BLANK\",\"OT\");\n\t\t\t\tvar msgArray = err_txt.split(\"&\");\n\t\t\t\tvar subCategory=getLabel(\"eOT.SubCategory.Label\",\"OT\");\n\t\t\t\talert(msgArray[0]+subCategory+msgArray[1]);\n\t\t\t\treturn;\n\t\t   }else{\n\t\t\t    if(function_id == \"OT_MST_CODE_SURGPREF\")\n\t\t{\n\t\t\t\t\tif(chkString.indexOf(prosthesis_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0 && chkString.indexOf(subCategory_code)>=0 && chkString.indexOf(surgeon_desc)>=0){\n\t\t\terr_txt=getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\n\t\t    }\n\t\t}else\n\t\t\t   {\n\t      \tif(chkString.indexOf(prosthesis_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(speciality_code)>=0 && chkString.indexOf(category_code)>=0 && chkString.indexOf(subCategory_code)>=0){\n\t\t\terr_txt=getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\n\t\t    }\n\t\t   }\n\t\t   }\n\t   }else if(appl_desc==\"SOPR\"){\n\t\t   if(operation_code==\'\'){\n              err_txt=getMessage(\"CANNOT_BE_BLANK\",\"OT\");\n\t\t\t\tvar msgArray = err_txt.split(\"&\");\n\t\t\t\tvar operation=getLabel(\"Common.operation.label\",\"common\");\n\t\t\t\talert(msgArray[0]+operation+msgArray[1]);\n\t\t\t\treturn;\n\t\t   }else{\n\t\t\t   if(function_id == \"OT_MST_CODE_SURGPREF\")\n\t\t{\n\t\t\t\t   if(chkString.indexOf(prosthesis_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(operation_code)>=0 && chkString.indexOf(surgeon_desc)>=0){\n\t\t\terr_txt=getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\n\t\t    }\n\t\t}else\n\t\t\t   {\n\t      \tif(chkString.indexOf(prosthesis_code)>=0 && chkString.indexOf(appl_desc)>=0 && chkString.indexOf(operation_code)>=0){\n\t\t\terr_txt=getMessage(\"CODE_ALREADY_EXISTS\",\"common\");\n\t\t    }\n\t\t   }\n\t\t   }\n\t   }\n\t}//for loop end\n\t\tif(err_txt.length>0){\n\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/jsp/MstCodeError.jsp?err_num=\'+err_txt;\n\t\t return false;\n\t }\n\telse       \n\t  return true;\n}\nfunction addRow(){\n  var rows=window.parent.frames[1].rows_for_prosthesis;\n  var formObj = document.SurgicalAccessoriesProsthesisRecordForm;\n  formObj.generic_search_for_prosthesis.disabled=false;\n  formObj.prosthesis_desc.disabled=false;\n   var mode =formObj.mode.value;\n      if(chkEmpty()){\n\t\tif(mode==\'I\'){\n\t \t  if(alreadyExist()){ //if the row which is bieng inserted already does not exist\n\t\t   if(chkForDuplicates()){\n\t   \t   var objrow = newRow();\n\t\t   objrow.prosthesis_code=formObj.prosthesis_code.value;\n\t\t   objrow.prosthesis_desc=formObj.prosthesis_desc.value;\n\t\t   objrow.no_Of_Units=formObj.no_Of_Units.value;\n\t\t   objrow.mode=\"I\";\n\t\t   objrow.recId = rows.length+1;\n\t\t   rows.push(objrow);\n\t\t   resetFields();\n\t\t   refresh();\n\t\t   }//chkForDuplicates()\n\t   } //alreadyExist()\n\t \n}else\n\t  updateRow();\n  }//chkEmpty()\n}\n\nfunction modeCheck(){\n\tvar formObj = document.SurgicalAccessoriesProsthesisRecordForm;\n\tvar prosthesisCodeDtl =window.parent.frames[4].prosthesis_code; //detail frame\n\tvar frmprosthesis_code=formObj.prosthesis_code.value;\n\tvar master_frame = window.parent.frames[0];\n\tvar hdr_frm = master_frame.document.forms[0];\n\tvar appl_desc=hdr_frm.appl_desc.value;\n\tvar splty_code=hdr_frm.speciality_code.value;\n\tvar cat_code=hdr_frm.category_code.value;\n\tvar sub_cat_code=hdr_frm.subCategory_code.value;\n\tvar tab=\"Prosthesis\"\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar params = \"appl_desc=\"+appl_desc+\"&splty_code=\"+splty_code+\"&cat_code=\"+cat_code+\"&sub_cat_code=\"+sub_cat_code+\"&tab=\"+tab;\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"ValidationOT.jsp?func_mode=fromSurgicalAcmaster&\"+params,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal1 = trimString(xmlHttp.responseText);\n\tvar err_txt=\"\";\n\tvar dtl_arr = retVal1.split(\",\");\n\tvar dtl_arr_length = dtl_arr.length;\n\tvar i = 0;\n\t\tif(dtl_arr_length>0){\n\t\t\twhile(i<=dtl_arr_length-2){\n\t\t\t\tif(dtl_arr[i] == frmprosthesis_code){\n\t\t\t\t\terr_flag = \"true\";\n\t\t\t\t\terr_txt=\"Update\";\n\t\t\t\t}\n\t\t\t\ti++;\n\t\t\t}\n\t\t}\n\t if(err_txt.length>0){\n\t     \t  return false;\n\t\t}else return true;\n}\n\nfunction updateRow(){\n\tvar formObj = document.SurgicalAccessoriesProsthesisRecordForm;\n\tvar rows=window.parent.parent.frames[1].frames[1].rows_for_prosthesis;\n\tvar mode =formObj.mode.value\n\tvar recId = formObj.recId.value;\n\t\tif(rows.length>0 && mode==\'U\'){\n\t\t\t   for(var jj=0;jj<rows.length;jj++){\n\t\t\t\t if(rows[jj]!=null) {\n\t\t\t\t\ti";
    private final static byte[]  _wl_block8_0Bytes = _getBytes( _wl_block8_0 );

    private final static java.lang.String  _wl_block8_1 ="f(rows[jj].recId==recId){\n\t\t\t\t\t\trows[jj].prosthesis_code=formObj.prosthesis_code.value;\n\t\t\t\t\t\trows[jj].prosthesis_desc=formObj.prosthesis_desc.value;\n\t\t\t\t\t\trows[jj].no_Of_Units=formObj.no_Of_Units.value;\n\t\t\t\t\t\tif( rows[jj].mode==\'I\')\n\t\t\t\t\t\t\tif(modeCheck()){\n\t\t\t\t\t\t\t\tmode=\"I\";\n\t\t\t\t\t\t\t}else{\n\t\t\t\t\t\t\t\tmode=\"U\"\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\trows[jj].mode=mode;\n\t\t\t\t\t}\n\t\t         }else  \n\t\t\tcontinue;\n\t\t }\n      resetFields();\n\t  refresh();\n }\n}\n\nfunction removeRow(){\nvar formObj = document.SurgicalAccessoriesProsthesisRecordForm;\nvar rows=window.parent.parent.frames[1].frames[1].rows_for_prosthesis;\nformObj.generic_search_for_prosthesis.disabled=false;\nformObj.prosthesis_desc.disabled=false;\nvar recId = document.forms[0].recId.value;\nvar mode = document.forms[0].mode.value;\nif(rows.length>0 && mode==\'U\'){        \n  for(var jj=0;jj<rows.length;jj++){\n\t if(rows[jj]!=null){\n\t\tif(rows[jj].recId==recId){\n\t\t\t if(rows[jj].mode==\'L\')\n\t\t\t\trows[jj].mode=\'D\';\n\t\t\t else\n\t\t\t  delete rows[jj];\n\t\t\t   break;\n\t\t}\n\t }else\n\tcontinue;\n }//end for-Loop\n resetFields();\n refresh();\n}else\n   resetFields();\n}\n\nfunction splitString(strVal){\n    var arr = strVal.split(\'::\');\n\tvar frmObj = document.SurgicalAccessoriesProsthesisRecordForm;\n\tfrmObj.prosthesis_code.value=arr[0];\n\tfrmObj.prosthesis_desc.value=arr[1];\n\tfrmObj.no_Of_Units.value=arr[2];\n\tfrmObj.recId.value=arr[3];\n\tfrmObj.mode.value=arr[4];\n\tfrmObj.generic_search_for_prosthesis.disabled=true;\n\tfrmObj.prosthesis_desc.disabled=true;\n}\nfunction resetFields(){\n\tvar frmObj = document.SurgicalAccessoriesProsthesisRecordForm;\n\tfrmObj.prosthesis_desc.value=\'\';\n\tfrmObj.prosthesis_code.value=\'\';\n\tfrmObj.no_Of_Units.value=\'\';\n\tfrmObj.mode.value=\'I\';\n}\nfunction refresh(){\n\twindow.parent.frames[4].location.href=\'../../eOT/jsp/SurgicalAccessoriesProsthesisDetailForm.jsp?\';              //+params;\n}\n\nfunction loadDBRows(prosthesis_code,prosthesis_desc,no_Of_Units,recId,mode){ \n  var objrow = newRow();\n  var rows=window.parent.parent.frames[1].frames[1].rows_for_prosthesis;\n  var i=0;\n   if(mode==\'L\' && rows.length<recId)\n\t{\n\t  \n\t  objrow.prosthesis_code = prosthesis_code;\n\t  objrow.prosthesis_desc = unescape(prosthesis_desc);\n\t  objrow.no_Of_Units =no_Of_Units;\n\t  objrow.mode=mode;\n\t  objrow.recId=recId;\n\t  rows.push(objrow);\n\t}\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block8_1Bytes = _getBytes( _wl_block8_1 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\"SurgicalAccessoriesProsthesisRecordForm\" id=\"SurgicalAccessoriesProsthesisRecordForm\"  onload=\'FocusFirstElement()\'  action=\"\" method=\"\" target=\"\"> \n<table border=0 cellspacing=0 cellpadding=3 width=\'100%\'  align=\'center\'>\n<tr>\n\t<td class=label>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</td>\n\t<td class=\"fields\">\n\t\t<input type=\"text\" name=\"prosthesis_desc\" id=\"prosthesis_desc\" value=\"\" size=15 maxlength=15 onBlur=\"if(this.value!=\'\')callSearchcode(\'PI\',prosthesis_code,prosthesis_desc);else prosthesis_code.value=\'\';\">\n\t\t<input type=\"hidden\" name=\"prosthesis_code\" id=\"prosthesis_code\" value=\"\">\n\t\t<input type=\"button\" class=\"button\" name=\"generic_search_for_prosthesis\" id=\"generic_search_for_prosthesis\" value=\"?\"  onclick=\"callSearchcode(\'PI\',prosthesis_code,prosthesis_desc);\" >\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n\n    <td class=label>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</td>\n\t<td class=\"fields\">\n\t\t<input type=\"text\" name=\"no_Of_Units\" id=\"no_Of_Units\" value=\"\" size=3 maxlength=3 onblur=\'ChkNumber(this);\' >\n\t</td>\n</tr>\n<tr>\n\t<td></td>\n    <td></td>\n    <td></td>\n    <td></td>\n</tr>\n<tr>\n\t<td></td>\n    <td></td>\n    <td></td>\n    <td class=\"fields\">\n\t\t\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onClick=\'addRow();\'  >\n\t\t<input type=\'button\' class=\'button\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onClick=\'removeRow();\'>\n\t</td>\n\n\t\t\n</tr>\n<input type=\"hidden\" name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\"hidden\" name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\"hidden\" name=\'dtlString\' id=\'dtlString\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\n</table>\n<!-- added by Yadav for Amazon Changes-->\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' width=\'100%\' height=\'15\'/> \n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<!-- end -->\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
 
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
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String imgUrl="";
if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8_0Bytes, _wl_block8_0);
            _bw.write(_wl_block8_1Bytes, _wl_block8_1);

String source=request.getParameter("source");
String mode=request.getParameter("update_mode_yn");
if (mode.equals("modify")){
mode="U";
}else{
mode="I";
}
String applicability=request.getParameter("applicability")==null?"":request.getParameter("applicability");
String speciality_code=request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
String surgeon_code=request.getParameter("surgeon_code")==null?"":request.getParameter("surgeon_code");
String speciality_desc="";
String oper_cat_code=request.getParameter("oper_cat_code")==null?"":request.getParameter("oper_cat_code");
String oper_cat_desc="";
String oper_sub_cat_code=request.getParameter("oper_sub_cat_code")==null?"":request.getParameter("oper_sub_cat_code");
String oper_sub_cat_desc="";
String oper_code=request.getParameter("oper_code")==null?"":request.getParameter("oper_code");
String oper_desc="";
String strsql="";
String sql="";
String function_id=request.getParameter("function_id").equals(null)?"":request.getParameter("function_id");
String sql1="";
//if(function_id.equals("SurgeonPreferences")){ modfied by sathish
if(function_id.equals("OT_MST_CODE_SURGPREF")){
sql1="SELECT PREF_ID,APPLICABILITY,SPECIALITY_CODE,OPER_CAT_CODE,OPER_SUB_CAT_CODE,OPER_CODE,TEAM_DOCTOR_CODE from OT_OPER_DR_PREFERENCE";
} else {
sql1="SELECT PROSTHESIS_CODE,APPLICABILITY,SPECIALITY_CODE,OPER_CAT_CODE,OPER_SUB_CAT_CODE,OPER_CODE from OT_OPER_PROSTHESIS";
}
StringBuffer dtlString=new StringBuffer();

if(applicability.equals("SSPL"))
     sql=" AND A.SPECIALITY_CODE='"+speciality_code+"'";
else if(applicability.equals("SCAT"))
     sql=" AND A.SPECIALITY_CODE='"+speciality_code+"' AND A.OPER_CAT_CODE='"+oper_cat_code+"'";
else if(applicability.equals("SSUB"))
     sql=" AND A.SPECIALITY_CODE='"+speciality_code+"' AND A.OPER_CAT_CODE='"+oper_cat_code+"' AND A.OPER_SUB_CAT_CODE='"+oper_sub_cat_code+"'";
else if(applicability.equals("SOPR"))
     sql=" AND A.OPER_CODE='"+oper_code+"'";
	 String no_of_units="";
//strsql="SELECT A.PROSTHESIS_CODE, B.SHORT_DESC, A.NO_OF_UNITS FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS B WHERE A.PROSTHESIS_CODE= B.PROSTHESIS_CODE AND A.APPLICABILITY='"+applicability+"'"+sql;
//if(function_id.equals("SurgeonPreferences")){modifed by sathish
if(function_id.equals("OT_MST_CODE_SURGPREF")){
strsql="SELECT A.PREF_ID, B.SHORT_DESC, A.NO_OF_UNITS FROM OT_OPER_DR_PREFERENCE A, OT_PROSTHESIS_LANG_VW B WHERE A.PREF_ID= B.PROSTHESIS_CODE  AND a.PREF_TYPE='S' AND NVL(A.TEAM_DOCTOR_CODE,'!')=NVL('"+surgeon_code+"',NVL(A.TEAM_DOCTOR_CODE,'!'))  AND B.LANGUAGE_ID='"+locale+"'  AND A.APPLICABILITY='"+applicability+"'"+sql;//IN:048356
} else {
strsql="SELECT A.PROSTHESIS_CODE, B.SHORT_DESC, A.NO_OF_UNITS FROM OT_OPER_PROSTHESIS A, OT_PROSTHESIS_LANG_VW B WHERE A.PROSTHESIS_CODE= B.PROSTHESIS_CODE AND B.LANGUAGE_ID='"+locale+"'  AND A.APPLICABILITY='"+applicability+"'"+sql;//IN:049252
}
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
if(mode.equals("U")){  
try
{
	con=ConnectionManager.getConnection(request);
	stmt=con.prepareStatement(strsql);
	//stmt.setString(1,template_id);
	rs=stmt.executeQuery();
	int index=0;
	while(rs.next())
	{
		index++;
		no_of_units=rs.getString(3);
	    if(no_of_units==null || no_of_units.equals("") || no_of_units.equals("null"))
		   no_of_units="";	
		out.println("<script>loadDBRows('"+rs.getString(1)+"','"+rs.getString(2)+"','"+no_of_units+"','"+index+"','L');</script>");
	}
	
	out.println("<script>refresh()</script>");
	//out.println("<script>assignRecID()</script>");
}catch(Exception e)
{
	e.printStackTrace();
	//System.err.println("Error in SurgicalAccessoriesProsthesisRecord.jsp"+e.getMessage());
}finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) 
		ConnectionManager.returnConnection(con,request);
	}catch(Exception e){e.printStackTrace();}
}
}else if(mode.equals("I")){
try{
	con=ConnectionManager.getConnection(request);
    stmt=con.prepareStatement(sql1);
	rs=stmt.executeQuery();
	while(rs.next())
		{
		if(function_id.equals("OT_MST_CODE_SURGPREF")){
				dtlString=dtlString.append(",").append(rs.getString(1)).append(",").append(rs.getString(2)).append(",").append(rs.getString(3)).append(",").append(rs.getString(4)).append(",").append(rs.getString(5)).append(",").append(rs.getString(6)).append(",").append(rs.getString(7)).append("#");
			}else
			{
				dtlString=dtlString.append(",").append(rs.getString(1)).append(",").append(rs.getString(2)).append(",").append(rs.getString(3)).append(",").append(rs.getString(4)).append(",").append(rs.getString(5)).append(",").append(rs.getString(6)).append("#");

			}
			
		}
		out.println("<script>refresh()</script>");
}catch(Exception e1)
{
	e1.printStackTrace();
	//System.err.println("Error in SurgicalAccessoriesProsthesisRecordForm records.jsp"+e1.getMessage());
}finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) 
		ConnectionManager.returnConnection(con,request);
	}catch(Exception e){
		e.printStackTrace();
	}
}
}

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(dtlString));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.NoofUnits.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
