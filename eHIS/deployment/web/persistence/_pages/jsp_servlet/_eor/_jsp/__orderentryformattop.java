package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryformattop extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryFormatTop.jsp", 1731999372000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- \nThe logic of implementing this modal window functionality is based on the array.\nThere are many array as the number of the columns/objects in the form.\nBoth in the case of adding new set, a new element is added to all the arrays and\nwhile updating the existing set the corresponding array elements from\nall the arrays are accessed and populated \n \n-->\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       \t\tEdit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             \t100            \t\t?           created\n24/12/2013      IN044267\t\t Nijitha S\t\tAlpha-OR-While creating Order Entry Format Item getting �Exception from contoller Jsp:java.lang.NullPointerException\"\n---------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrderEntryFormats.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n</head>\n<SCRIPT LANGUAGE=\"JavaScript\">\n\nvar seq_arr\t\t\t\t= new Array();\nvar mnemonic_arr\t\t= new Array();\n//var mnemonic_arr1\t\t= new Array();\n\nvar agegroup_arr\t\t= new Array();\nvar label_text_arr\t\t= new Array();\nvar label_text_arr_value= new Array();\n\nvar accept_option_arr\t= new Array();\nvar deflt_value_arr\t\t= new Array();\nvar deflt_value_arr_value\t\t= new Array();\n\nvar object_type_arr\t\t= new Array()\nvar value_arr1\t\t\t= new Array();\nvar value_arr2\t\t\t= new Array();\nvar dependency_arr\t\t= new Array();\nvar occ_no_arr\t\t= new Array();\nfunction callDummy(){}\n\nfunction onLoadDef(level){//Fill the Array\'s  when the  Category is Laboratory\n\tif(level == \"L\"){\n\t if(document.getElementById(\"defFlag\").value == \"1\"){\n\t\t if(seq_arr.length  == 0){ //only when no values inserted in final String\n\t\t\t var i = 0;\n\t\t\t\tseq_arr[i]\t\t\t= \"1\";\n\t\t\t\tmnemonic_arr[i]\t\t= \"SPECIMEN_TYPE\";\n\t\t\t\tlabel_text_arr[i]\t= \"Specimen Type\";\t\n\t\t\t\tsetFormatValues(\"labeltextValue_array\"+i,label_text_arr[i]);\t\t\n\t\t\t\tlabel_text_arr[i]\t= \"labeltextValue_array\"+i;\n\t\t\t\t//accept_option_arr[i]= \"O\";\n\t\t\t\taccept_option_arr[i]= \"R\";\n\t\t\t\tdeflt_value_arr[i]\t= \" \";\t\n\t\t\t\tsetFormatValues(\"descValue_array\"+i,deflt_value_arr[i]);\t\t\n\t\t\t\tdeflt_value_arr[i]\t= \"descValue_array\"+i;\n\t\t\t\tagegroup_arr[i]\t= \" \";\n\t\t\t\tdependency_arr[i] = \" \";\n\t\t\t\tobject_type_arr[i]\t= \"\";\n\t\t\t\tvalue_arr1[i]\t\t= \"\";\n\t\t\t\tvalue_arr2[i]\t\t= \"\";\n\t\t\t\ti++;\n\n\n\t\t\t\tseq_arr[i]\t\t\t= \"2\";\n\t\t\t\tmnemonic_arr[i]\t\t= \"NURSE_COLLECT_YN\";\n\t\t\t\tlabel_text_arr[i]\t= \"Nurse Collect\";\n\t\t\t\t//if(record[4]!=null||record[4]!=\"\")\n\t\t\t\t\n\t\t\t\tsetFormatValues(\"labeltextValue_array\"+i,label_text_arr[i]);\t\t \n\t\t\t\tlabel_text_arr[i]\t= \"labeltextValue_array\"+i;\t\t\t\t\n\t\t\t\taccept_option_arr[i]= \"O\";\n\t\t\t\tdeflt_value_arr[i]\t= \" \";\n\t\t\t\tsetFormatValues(\"descValue_array\"+i,deflt_value_arr[i]);\t\t\n\t\t\t\tdeflt_value_arr[i]\t= \"descValue_array\"+i;\n\t\t\t\tagegroup_arr[i]\t= \" \";\n\t\t\t\tdependency_arr[i] = \" \";\n\t\t\t\tobject_type_arr[i]\t= \"\";\n\t\t\t\tvalue_arr1[i]\t\t= \"\";\n\t\t\t\tvalue_arr2[i]\t\t= \"\";\n\t\t\t\ti++;\n\n\t\t\t\tseq_arr[i]\t\t\t= \"3\";\n\t\t\t\tmnemonic_arr[i]\t\t= \"COLLECTION_STAGE\";\n\t\t\t\tlabel_text_arr[i]\t= \"Collection Stage\";\n\t\t\t\t\n\n\t\t\t\t//if(record[4]!=null||record[4]!=\"\")\n\t\t\t\t\n\t\t\t\tsetFormatValues(\"labeltextValue_array\"+i,label_text_arr[i]);\t\t \n\t\t\t\tlabel_text_arr[i]\t= \"labeltextValue_array\"+i;\n\t\t\t\n\t\t\t\taccept_option_arr[i]= \"D\";\n\t\t\t\tdeflt_value_arr[i]\t= \"Separate\";\n\t\t\t\tsetFormatValues(\"descValue_array\"+i,deflt_value_arr[i]);\t\t\n\t\t\t\tdeflt_value_arr[i]\t= \"descValue_array\"+i;\n\t\t\t\tagegroup_arr[i]\t= \" \";\n\t\t\t\tdependency_arr[i] = \" \";\n\t\t\t\tobject_type_arr[i]\t= \"\";\n\t\t\t\tvalue_arr1[i]\t\t= \"\";\n\t\t\t\tvalue_arr2[i]\t\t= \"\";\n\n\t }\n\t}\n  }\n}\n\n\nfunction populateVals(val,finalString,obj,k,substr){\t\n\tvar valArray = new Array();\n\tvalArray=val.split(\"~\");\t\n\tparent.list_bottom.list_dtl.dontChk.value\t\t\t=\tk;\n\tparent.list_bottom.list_dtl.seq_no.value\t\t\t=\t(seq_arr[k]);\n\tparent.list_bottom.list_dtl.mnemonic.value\t\t\t=\t(mnemonic_arr[k]);\n\t/*for (var repl=0;repl < label_text_arr[k].length;repl++) {\n\t\tif (label_text_arr[k].indexOf(\"�\") != -1) {\n\t\t\tlabel_text_arr[k] = label_text_arr[k].replace(\"�\",\"&\");\n\t\t}\n\t\tif (label_text_arr[k].indexOf(\"!!\") != -1) {\n\t\t\tlabel_text_arr[k] = label_text_arr[k].replace(\"!!\",\"%\");\n\t\t}\n\t\tif (label_text_arr[k].indexOf(\"�\") != -1) {\n\t\t\tlabel_text_arr[k] = label_text_arr[k].replace(\"�\",\"!!\");\n\t\t}\n\t\tif (label_text_arr[k].indexOf(\"�\") != -1) {\n\t\t\tlabel_text_arr[k] = label_text_arr[k].replace(\"�\",\"+\");\n\t\t}\n\t\tif (label_text_arr[k].indexOf(\"�\") != -1) {\n\t\t\tlabel_text_arr[k] = label_text_arr[k].replace(\"�\",\"\\\\\");\n\t\t}\n\t}*/\n\n\n\t\t\tvar templist=label_text_arr[k];\n\t\t\tlabel_text_arr_value[k]=label_text_arr[k];\n\t\t\tvar bean_id = \"Or_OrderEntryFormats\";\n\t\t\tvar xmlStr = \"\"; \n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\n\t\t\txmlStr =\"<root><SEARCH \" ;\n\t\t\txmlStr += \"default_val=\\\"\"+ templist +\"\\\" \" ;\t\t\t\n\t\t\txmlStr +=\" /></root>\" ;\n\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\n\t\t\txmlHttp.open( \"POST\", \"OrderEntryFormatsValidate.jsp?bean_id=\" + bean_id + \"&validate=getdefValue\", false ) ;\n\t\t\txmlHttp.send( xmlDoc ) ;\n\t\t\tresponseText=xmlHttp.responseText ;\t\t\t\n\t\t\tvar templist1=responseText;\t\n\t\t\t\n\t\t\t\n\t\t\tif((templist1.indexOf(\"<option>\")>0) &&(templist1.indexOf(\"</option>\")>0))\n\t\t\t{\n\t\t\t\ttemplist1=templist1.replace(\"<option>\",\"\");\n\t\t\t\ttemplist1=templist1.replace(\"</option>\",\"\");\t\t\t\n\t\t\t\tlabel_text_arr_value[k]=trimString(templist1);\n\t\t\t}\n\n\n\t///\n\tparent.list_bottom.list_dtl.lbl_txt.value\t\t\t=\t(label_text_arr_value[k]);\n\n\tparent.list_bottom.list_dtl.accept_option.value\t\t=\t(accept_option_arr[k]);\n\tobject_type_arr[k] = eval(\"parent.list_bottom.list_dtl.hdn_fld_type\"+parent.list_bottom.list_dtl.mnemonic.selectedIndex).value\n\t\tif(deflt_value_arr[k] == \" \"||deflt_value_arr[k] ==\"null\"||deflt_value_arr[k] ==null)\n\t\t\tdeflt_value_arr[k] = \"\";\n\t// the following method will generate the dynamic html for the\n\t//default value in the modal window depending on the type of the object(textbox/select/check box)\n\t//var tempo=beforepopulate3(deflt_value_arr[k]);\n\t\t\tvar temp=deflt_value_arr[k];\n\t\t\tdeflt_value_arr_value[k]=deflt_value_arr[k];\n\t\t\tvar bean_id = \"Or_OrderEntryFormats\";\n\t\t\tvar xmlStr = \"\"; \n\t\t\tvar xmlDoc = \"\" ;\n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\n\t\t\txmlStr =\"<root><SEARCH \" ;\n\t\t\txmlStr += \"default_val=\\\"\"+ temp +\"\\\" \" ;\t\t\t\n\t\t\txmlStr +=\" /></root>\" ;\n\n\t\t\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\t\t\txmlHttp.open( \"POST\", \"OrderEntryFormatsValidate.jsp?bean_id=\" + bean_id + \"&validate=getdefValue\", false ) ;\n\t\t\txmlHttp.send( xmlDoc ) ;\n\t\t\tresponseText=xmlHttp.responseText ;\t\t\t\n\t\t\tvar temp1=responseText;\t\n\t\t\t\n\t\t\tif((temp1.indexOf(\"<option>\")>0) &&(temp1.indexOf(\"</option>\")>0))\n\t\t\t{\n\t\t\t\ttemp1=temp1.replace(\"<option>\",\"\");\n\t\t\t\ttemp1=temp1.replace(\"</option>\",\"\");\t\t\t\n\t\t\t\tdeflt_value_arr_value[k]=trimString(temp1);\n\t\t\t}\n\t\t\t//var tmpdef=deflt_value_arr_value[k];\n\tif(deflt_value_arr_value[k]==null||deflt_value_arr_value[k]==\"null\")deflt_value_arr_value[k]=\"\";\n\tpopulateValues1(value_arr1[k],value_arr2[k], object_type_arr[k], deflt_value_arr_value[k], dependency_arr[k])  \t\t\n\tvar obj = parent.list_bottom.list_dtl.dflt_val;//IN044267\n\tif(obj!=null && obj.value!=null)//IN044267\n\tparent.list_bottom.list_dtl.dflt_val.value\t\t\t=\t(deflt_value_arr_value[k]); //-- assign the value for the default value\n\t\n\tif(agegroup_arr[k] == \" \")agegroup_arr[k] = \"\";\n\tparent.list_bottom.list_dtl.agegroup.value\t\t\t=\t(agegroup_arr[k]);\n\n\tif(dependency_arr[k] == \"\" || dependency_arr[k] == \"N\")\n\t\tdependency_arr[k]=\" \";\n\tparent.list_bottom.list_dtl.finalValue.value\t=\t(dependency_arr[k]);\n\n\tparent.list_bottom.list_dtl.old_seq_no.value\t=(seq_arr[k]);\n\tif(((mnemonic_arr[k]==\"BLOOD_TRANS_EXP_DATE\")||(mnemonic_arr[k]==\"TRANSPLANT_DATE\")||(mnemonic_arr[k]==\"NN_MOTHER_PAT_ID\")||(mnemonic_arr[k]==\"NN_MOTHER_PAT_NAME\")))\n\t{\n\t\tparent.list_bottom.list_dtl.old_dflt_val.value=\"\";\n\t\tparent.list_bottom.list_dtl.old_dflt_val.disabled = true;\n\t\tparent.list_bottom.list_dtl.dflt_val.value=\"\";\n\t\tparent.list_bottom.list_dtl.dflt_val.disabled = true;\n\t}\n\tparent.list_bottom.list_dtl.old_mnemonic.value\t=(mnemonic_arr[k]);\n\tparent.list_bottom.list_dtl.old_lbl_txt.value\t=(label_text_arr_value[k]);\n\tparent.list_bottom.list_dtl.old_accept_opt.value=(accept_option_arr[k]);\n\tparent.list_bottom.list_dtl.old_dflt_val.value\t=(deflt_value_arr_value[k]);\n\tparent.list_bottom.list_dtl.old_agegroup.value\t=(agegroup_arr[k]);\n\tparent.list_bottom.list_dtl.old_order_type.value=(object_type_arr[k]);\n\tparent.list_bottom.list_dtl.old_finalValue.value=(dependency_arr[k]);\n\t\n\t//parent.list_bottom.list_dtl.old_position.value\t=(position_arr[k]);\n\tfinalString = finalString.replace(valArray[0],\" \");\n\tfinalString = finalString.replace(valArray[1],\" \");\n\t//parent.list_bottom.list_dtl.finalString.value=finalString;\n\n\tif (mnemonic_arr[k]\t== \"SPECIMEN_TYPE\" || mnemonic_arr[k] ==  \"NURSE_COLLECT_YN\" || mnemonic_arr[k] ==  \"COLLECTION_STAGE\") \n\t{\n\t\tif((occ_no_arr[k]==1)||(occ_no_arr[k]==undefined)||(occ_no_arr[k]==\"undefined\"))\n\t\t{\n\t\t\tparent.list_bottom.list_dtl.clear.disabled = true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tparent.list_bottom.list_dtl.clear.disabled =false;\n\t\t}\n\t\tparent.list_bottom.list_dtl.seq_no.disabled = true;\n\t\tparent.list_bottom.list_dtl.mnemonic.disabled = true;\n\t\tparent.list_bottom.list_dtl.lbl_txt.focus();\n\t\tif ((mnemonic_arr[k]\t== \"COLLECTION_STAGE\") || (mnemonic_arr[k]\t== \"SPECIMEN_TYPE\" ))\n\t\t{\n\t\t\tparent.list_bottom.list_dtl.accept_option.disabled = true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tparent.list_bottom.list_dtl.accept_option.disabled = false;\n\t\t}\n\t\tif (mnemonic_arr[k]\t== \"SPECIMEN_TYPE\" )\n\t\t\tparent.list_bottom.list_dtl.accept_option.value = \"R\";\n\t} \n\telse \n\t{\n\t\tparent.list_bottom.list_dtl.clear.disabled = false;\n\t\tparent.list_bottom.list_dtl.seq_no.disabled = false;\n\t\tparent.list_bottom.list_dtl.mnemonic.disabled = false;\n\t\tparent.list_bottom.list_dtl.accept_option.disabled = false;\n\t\tparent.list_bottom.list_dtl.seq_no.focus();\n\t}\n\t\t\t\n\t\n\n    var ord_cat = parent.list_bottom.list_dtl.ord_cat.value\n    var mnemonic = parent.list_bottom.list_dtl.mnemonic.value\n\tif (mnemonic == \'PATIENT_DIAGNOSIS\') \n\t{\n\t\tparent.list_bottom.list_dtl.dflt_val.value = \"\";\n\t\tparent.list_bottom.list_dtl.dflt_val.disabled = true;\t\t\n\t}\n    if (ord_cat == \'OT\') {\n   if (((mnemonic == \'PREF_SURG_DATE\') || (mnemonic == \'SURGERY_TYPE\'))) {\n            //parent.list_bottom.list_dtl.accept_option.value = \'R\';\n            parent.list_bottom.list_dtl.accept_option.disabled = true;\n        } else {\n            //parent.list_bottom.list_dtl.accept_option.value = \'O\';\n            parent.list_bottom.list_dtl.accept_option.disabled = false;\n        }\n    }\n\n    parent.list_bottom.list_dtl.mode.value=\'update\';\n\tparent.list_depend.location.href=\"../../eCommon/html/blank.html\";\n}\n\n\n</SCRIPT>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!-- onLoad=\"onLoadDef(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\" -->\n<body  OnMouseDown=\"CodeArrest()\"; onLoad=\"onLoadDef(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\"; onKeyDown=\"lockKey()\">\n<form name=list_top>\n<table class=\'grid\' width=\'100%\'>\n<tr>\n\t<th class=\' COLUMNHEADER\' align=\"left\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<th class=\' COLUMNHEADER\' align=\"left\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<th class=\'columnheader\' align=\"left\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n</tr>\n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\n\t\t<!-- Build the table -->\n\t\t<tr>\n\t\t\t<td class=\"gridData\">1</td><td class=\"gridData\"><a class=\'gridLink\' href=\'javascript:populateVals(\"\",\"\", this ,\"0\")\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></td><td class=\"gridData\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td><td class=\"gridData\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td><td class=\"gridData\"></td><td class=\"gridData\"></td>\n\t\t</tr>\n\n\n\t\t<tr>\n\t\t\t<td class=\"gridData\">2</td><td class=\"gridData\"><a class=\'gridLink\' href=\'javascript:populateVals(\"\",\"\", this ,\"1\")\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td><td class=\"gridData\"></td><td class=\"gridData\"></td>\n\t\t</tr>\n\n\n        <tr>\n\t\t\t<td class=\"gridData\">3</td><td class=\"gridData\"><a class=\'gridLink\' href=\'javascript:populateVals(\"\",\"\", this ,\"2\")\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td><td class=\"gridData\"></td>\n\t\t</tr>\n\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t <INPUT TYPE=\"hidden\" name=\"defFlag\" id=\"defFlag\" value=\"1\">\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t  <INPUT TYPE=\"hidden\" name=\"defFlag\" id=\"defFlag\" value=\"0\">\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</table>\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);


	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";	

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

//String temp="";
//String tempdesc="";
//int strlength;
	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String level =  request.getParameter("level")==null?"":request.getParameter("level");


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(level));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(level));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

//The existing values from databse will be fethced for this combination - begin
     	
	String prev_values ="";
	//StringBuffer prev_values=new StringBuffer();	
	String bean_id = "Or_OrderEntryFormats" ;
//	String bean_name = "eOR.OrderEntryFormats";
    OrderEntryFormats bean = (OrderEntryFormats)getBeanObject( bean_id, "eOR.OrderEntryFormats", request) ;
	TreeMap finalValues=bean.getFormatFinalValues();
	int mapSize=finalValues.size();
	//String level =  request.getParameter("level")==null?"":request.getParameter("level");;
	String order_category =  request.getParameter("ord_cat")==null?"":request.getParameter("ord_cat");
	String order_type =  request.getParameter("order_type")==null?"":request.getParameter("order_type");
	String order_catalog = request.getParameter("ord_catalog")==null?"":request.getParameter("ord_catalog");
	
	String finalString = "";//request.getParameter("finalString");//java.net.URLDecoder.decode(,"UTF-8")
	
	if (finalString==null)finalString="";	

	String res = request.getParameter("age_group_sd")==null ?"" :request.getParameter("age_group_sd");
	String res1 = request.getParameter("age_group_cd")==null ?"" :request.getParameter("age_group_cd");
	
	
	if(finalString.equals("") || finalString == null){
		
		finalString="";
		ArrayList mnemonic_values = new ArrayList();
		mnemonic_values = bean.getMnemonics(level, order_category, order_type, order_catalog);
			
		for(int i=0; i<mnemonic_values.size(); i++){
			
			String[] record = (String [])mnemonic_values.get(i);
		
			if(record[4]!=null||record[4]!="")
				
				//bean.setFormatListValues("descValue_array"+record[0],record[4]);
				bean.setFormatListValues("descValue_array"+i,record[4]);
		
				prev_values =prev_values+ record[0]+"~"+record[1]+"~"+record[2]+"~"+record[3]+"~"+"descValue_array"+i+"~"+record[5]+"~"+record[6]+"~"+record[7]+"~"+record[8]+"~"+record[9]+"~"+record[11]+"`";
				//prev_values.append(record[0]+"~"+record[1]+"~"+record[2]+"~"+record[3]+"~"+record[4]+"~"+record[5]+"~"+record[6]+"~"+record[7]+"~"+record[8]+"~"+record[9]+"`");
		}	
	
		if((level.trim()).equals("L") && mnemonic_values.size() == 0 && order_category.equalsIgnoreCase("LB") && (mapSize==0)){//i:e create mode and order_category selected is LB
		
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
            _bw.write(_wl_block21Bytes, _wl_block21);
}//Ends

	} else {//End of final string is null	or empty		
		//bean.setFinalString(finalString);
		//finalString = bean.getFinalString();
	}


	if(order_category.equalsIgnoreCase("LB")){
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block23Bytes, _wl_block23);
}
//	bean.setFinalString(prev_values);
//The existing values from databse will be fethced for this combination - End

	//finalString = finalString + prev_values;
	//bean.setFinalString(finalString);
	

	//if(finalString != null){
	if(finalValues != null && finalValues.size()>0){
		//StringTokenizer st1		= new StringTokenizer(finalString,"`");
		StringBuffer	result	= new StringBuffer();
		String			mainStr = "";
		String			subStr	= "";
		int				count	= 0;
		String			classval= "";
		String			tempStr = "";
		int				j		= 0;
		Collection c = finalValues.values();     //obtain an Iterator for Collection 
		Iterator itr = c.iterator();     //iterate through TreeMap values iterator  
		while(itr.hasNext())   {   
		//for(int z=0;z<finalValues.size();z++){
		//while(st1.hasMoreTokens()){
			if(j%2 == 0){
				classval = "gridData";
			}else{
				classval = "gridData";
			}

			//mainStr  = st1.nextToken();	
			mainStr = (String)itr.next();
			StringTokenizer st2 = null;
			if(mainStr != null && !mainStr.equals(""))	
			st2 = new StringTokenizer(mainStr,"~");
			result.append("<tr class='"+classval+"'>");
			String[] record = new String[11] ;
			String allValues = "";
			//StringBuffer allValues=new StringBuffer();
			int i=0;

			//this while loop will put the tokenised values to the respective arrays
			
			while(st2 != null && st2.hasMoreTokens()){
				record[i] = st2.nextToken();
				//allValues = allValues+ record[i] + "~";
					//allValues.append(record[i] + "~");				
             
				if(record[i] == null || record[i].trim().equals("null"))
					record[i] = " ";
				//Fill the arrays
				if(i==0){
					out.println("<script>seq_arr["+j+"]="+record[i]+"</script>");
				}else if(i==1){
				   out.println("<script>mnemonic_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==2){					
     				//record[i] = record[i].replace('�','&');
					//record[i] = record[i].replace('s','%');
					//record[i] = record[i].replace('�','!!');
					//record[i] = record[i].replace('�','+');
					//record[i] = record[i].replace('\\','�');
					//tempStr	  = record[i].replace('�','\\');

					tempStr	  = record[i];				
					for (int repl=0;repl < record[i].length();repl++) {
						if(record[i].lastIndexOf("�") != -1) {
							String tempStr1 = record[i].substring(0,record[i].lastIndexOf("�"));
							String tempStr2 = record[i].substring(record[i].lastIndexOf("�")+1,record[i].length());
							record[i] = tempStr1 + "\\\\" + tempStr2;
						}
					}
					
					out.println("<script>label_text_arr["+j+"]='"+record[i]+"';</script>");
					//record[i] = record[i].replace('�','&');
					//record[i] = record[i].replace('!!','%');
					//record[i] = record[i].replace('�','!!');
					//record[i] = record[i].replace('�','+');
					//tempStr	  = record[i].replace('�','\\');
					record[i] = tempStr;
				
				}else if(i==3){
					out.println("<script>accept_option_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==4){
					out.println("<script>deflt_value_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==5){
					out.println("<script>agegroup_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==6){
					out.println("<script>dependency_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==7){
					out.println("<script>object_type_arr["+j+"]='"+record[i]+"';</script>");
				}else if(i==8){
					out.println("<script>value_arr1["+j+"]='"+record[i]+"';</script>");
				}else if(i==9){
					out.println("<script>value_arr2["+j+"]='"+record[i]+"';</script>");
				}/*else if(i==10){
					if(record[i].indexOf("||")!=-1)
					{
					strlength=record[i].indexOf("||");
					tempdesc="";	tempdesc=record[i].substring(0,strlength);
					}
				}*/
				else if(i==10)
				{
						out.println("<script>occ_no_arr["+j+"]='"+record[i]+"';</script>");
				}
				i++;
			}

			boolean flag = false ;

			subStr = record[1];

			/*if( order_category.trim().equalsIgnoreCase("LB") && (subStr.trim().equalsIgnoreCase("NURSE_COLLECT_YN")) ){ //subStr.trim().equalsIgnoreCase("SPECIMEN_TYPE") ||
				flag = true ;
			}*/


			//this for loop will build the string of "<td>" and thus the final out put of HTML Table
			for(int k=0; k<record.length-1; k++){
				if(k==6 ||k==7 || k==8 ||k==9)
					continue;				
			
				subStr = record[k];
				
				if (subStr == null || subStr.equals("null")) subStr = " ";
				if(k==3){
			 		if(subStr.equalsIgnoreCase("O"))
						subStr = "Optional";

			 		if(subStr.equalsIgnoreCase("R"))
						subStr = "Required";

			 		if(subStr.equalsIgnoreCase("D"))
						subStr = "Display";

				}

				// this is to remove the space given when there in no value assigned to default value
				if(k==4){
					if(subStr.equals(" ") || subStr.equalsIgnoreCase("N"))
						subStr = "";
					if(subStr.equalsIgnoreCase("Y"))
						subStr = "Checked";	
					String temp1=subStr;					
					String temp2 = bean.checkForNull(bean.getFormatListValues(temp1));
					subStr=temp2;	
				}
				//  this is to assign the agegroup short description for it's appropriate agegroup code				
				if(k==5){
					String val ="";
					String dummy ="";
					StringTokenizer token = new StringTokenizer(res,":");
					final int count2 = token.countTokens();
					String array[] = new String[count2];
					int y = 0;
					ArrayList AgeGroup_Data =  new ArrayList();  
					if(res.equals(""))
					{
						AgeGroup_Data = bean.getAgeGroup();
						for(int x=0; x<AgeGroup_Data.size(); x++){
							String[] record3 = (String [])AgeGroup_Data.get(x);
							if(subStr.equalsIgnoreCase(record3[1]))
							{
								 dummy = record3[0];
							}
						}
						subStr =  dummy;
					}
					if(!res.equals(""))
					{
						while(token.hasMoreTokens())
						{
							val = token.nextToken();
							array[y] = val; 
							y++;
						}
					}
					StringTokenizer token1 = new StringTokenizer(res1,":");
					final int count1 = token1.countTokens();
					String desc[] = new String[count1];
					y= 0;
					if(!res1.equals(""))
					{
						while(token1.hasMoreTokens())
						{
							val = token1.nextToken();
							desc[y] = val; 
							y++;
						}
					}
					y = 0;
					while( y < desc.length)
					{
							if(subStr.equalsIgnoreCase(desc[y]))
							{
									dummy = array[y];
							}
										
								y++;
					}
					subStr= dummy;
					if(subStr.equals(" ")||subStr.equals(""))
					{ subStr= ""; }
			 	}			
				if(flag){
					result.append("<td  class='"+ classval +"'>");
					if (k==2)					
					result.append(subStr);
					result.append("</td>");
				}else{
					result.append("<td  class='"+ classval +"'>");

					if(k==1){
						result.append("<a class='gridLink' href='javascript:populateVals(\""+allValues+"\",\""+ finalString+"\", this ,\""+ j+"\",\""+ subStr+"\")' >");
						subStr =  bean.getMnemonicDesc(order_category,subStr);
					}
					if(k==2)
					{						
						String templabel1=subStr;					
						String templabel2 = bean.checkForNull(bean.getFormatListValues(templabel1));
						subStr=templabel2;	
					}				
					result.append(subStr); 				
					result.append("</a></td>");
			}
		}

			i=0;

			j++;
			result.append("</tr>");
			count++;
		}
		out.println(result.toString());
	}

            _bw.write(_wl_block24Bytes, _wl_block24);

		putObjectInBean(bean_id,bean,request); 
 

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SequenceNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.FieldMnemonicDesc.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.labelText.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AcceptOption.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DefaultValue.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.agegroup.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SpecimenType.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SpecimenType.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.required.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.NurseCollect.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.NurseCollect.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Optional.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.CollectionStage.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.CollectionStage.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.display.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Separate.label", java.lang.String .class,"key"));
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
}
