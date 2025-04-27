package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryformatdependency extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryFormatDependency.jsp", 1731999322000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------?                              ?           created\n25/7/2011  IN27169\t\t     Dinesh T\t OrderEntryFormat dependencies are not filtered properly\n20/08/2014 IN050609\t\t\t Nijitha S\t CRF-OR-Bru-HIMS-CRF-434/01-Operator value not defaulted to current date at Date depnedency\n20/08/2014 IN050630\t\t\t Nijitha S\t\t\t\t\t\t\t\t\tCRF-OR-Bru-HIMS-CRF-434/04-script error while setup to dependency date validation  in Order format\n--------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n\t<!-- <title>Dependency</title> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9_0 ="\' type=\'text/css\'/></link>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryFormats.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrCommonFunction.js\"></script>\n \t<script language=\"JavaScript\">\n<!--\nvar values_arr\t\t\t\t= new Array();\nvar other_mnemonic_arr\t\t= new Array();\nvar action_arr\t\t\t\t= new Array();\nvar message_arr\t\t\t\t= new Array();\nvar operator_arr\t\t\t= new Array();\nfunction closeWindow(){\n}\n/*function called on onload to build the table according to the default value of the mnemmonic*/\nfunction chkonload(){\t\n\tvar\tdefault_val=document.decision_support.default_val.value\t\n\tvar\tmnemonic=document.decision_support.mnemonic.value\t\t\t\n\tvar\tord_cat=document.decision_support.ord_cat.value\n\tvar count =document.decision_support.count.value;\n\n\tif( default_val == \"C\" ){\n\t\tdocument.getElementById(\"values0\").innerHTML = \"<div class=\'label\'><B>Yes</B></div>\"\n\t\tdocument.getElementById(\"values1\").innerHTML = \"<div class=\'label\'><B>No</B></div>\"\n\t}else if( default_val ==  \"N\" || default_val == \"E\" || default_val == \"I\" || default_val == \"D\"){\n\t\tdocument.getElementById(\"row_id\"+i).style=\"display\";\n\t\tif(document.decision_support.visible_rows.value > 0){\n\t\t\tvar j=\tdocument.decision_support.visible_rows.value\n\t\t\t\teval(\"document.getElementById(\'del_row0\')\").style.visibility\t= \'hidden\';\n\t\t\t\t\n\t\t\tfor(var i=0;i<j;i++){\n\t\t\t\teval(document.getElementById(\'row_id\'+i)).style=\"display\";\n\t\t\t\teval(document.getElementById(\'next_row\'+i)).style.visibility\t= \'hidden\';\n\t\t\t\t\n\t\t\t}var temp= j-1;\n\t\t\teval(document.getElementById(\'next_row\'+temp)).style.visibility\t\t= \'visible\';\n\t\t\t\n\t\t}if(default_val == \"N\" || default_val == \"I\" ){\n\t\t\tfor(var i=0;i<j;i++){\n\t\t\t\tif(eval(\"document.decision_support.between_value\"+i).value == \"\")\n\t\t\t\t\teval(\"document.decision_support.between_val\"+i).style.display = \'none\';\n\t\t\t\telse\n\t\t\t\t\teval(\"document.decision_support.between_val\"+i).style=\"display\";\n\t\t\t}\n\t\t\t\n\t\t}\n\t}\n\tfor( var i=0;i<count;i++ ){\n\t\tif(eval(\"document.decision_support.action\"+i))\n\t\t{\n\t\t\tvar action = eval(\"document.decision_support.action\"+i).value ;\n\t\t\tif( default_val == \"C\" )\n\t\t\t\teval(document.getElementById(\'row_id\'+i)).style=\"display\";\n\t\t\telse if( default_val == \"L\" || default_val == \"R\" )\n\t\t\t\teval(document.getElementById(\'row_id\'+i)).style=\"display\";\n\t\t\telse if( default_val == \"E\" || default_val == \"D\"){\n\t\t\t\teval(\"document.getElementById(\'values\')\"+i).style.display = \'none\';\n\t\t\t}\n\t\t\tif( action == \"N\" ){\n\t\t\t\teval(\"document.decision_support.mandatory\"+i).style.visibility\t= \'hidden\';\n\t\t\t}\n\t\t}\n\t}\n}\n\n/*Operator\'s check to display and hide the values column*/\nfunction chkforOperator(target,index){\n\tvar\tdefault_val=document.decision_support.default_val.value\n\tvar\toper_value=eval(\"document.decision_support.operator_value\"+index).value\n\tif(default_val == \"N\" || default_val == \"I\" ){\n\t\tif(oper_value == \"\"){\n\t\t\teval(\"document.decision_support.between_val\"+index).style.display = \'none\';\n\t\t}else if(oper_value == \"B\"){\n\t\t\teval(\"document.decision_support.between_val\"+index).style=\"display\";\n\t\t}else if(oper_value == \"L\" || oper_value == \"G\"|| oper_value ==\"E\"){\n\t\t\teval(\"document.decision_support.between_val\"+index).style.display = \'none\';\n\t\t\teval(\"document.decision_support.between_val\"+index).value=\"\";\n\t\t}\n\t}\n}\n/*inserts new row\'s dynamically for default value\'s N and E*/\nfunction insertNextrow(index){\n\t\n\tvar i\t\t= index;\n\tvar y\t\t= document.decision_support.row_count.value;\n\tvar count\t=document.decision_support.count.value;\n\tvar\tdefault_val=document.decision_support.default_val.value\n\tif(default_val == \"E\" || default_val == \"N\" || default_val == \"I\" || default_val == \"D\"){\n\t\tif(document.decision_support.visible_rows.value > 0 ){\n\t\t\tvar j =\tdocument.decision_support.visible_rows.value\n\t\t\ty = j-1;\n\t\t}if(i != y)\n\t\t\ty= i;\n\t}\n\tif(y<count-1){\n\t\teval(document.getElementById(\'next_row\'+i)).style.visibility\t= \'hidden\';\n\t\tdocument.decision_support.row_count.value= ++y;\n\t\teval(document.getElementById(\'row_id\'+y)).style=\"display\";\n\t}else\n\t\talert(\"APP-OR0231 No more new rows can be created....\");\n\n}\nfunction deleteRow(index){\n\t\n\tvar i\t\t= index;\n\tvar y\t\t= document.decision_support.row_count.value;\n\tvar count\t= document.decision_support.count.value;\n\tvar\tdefault_val=document.decision_support.default_val.value\n\tif(i == 0 || i == 99)\n\t\talert(\"APP-OR0232 No more rows can be deleted...\");\n\tif(i>0 && i<99){\n\t\teval(document.getElementById(\'row_id\'+i)).style.display\t\t\t= \'none\';\n\t\tif(default_val == \"E\" || default_val == \"D\" ){\t\t\n\t\t\t\n\t\t\tdocument.decision_support.visible_rows.value=i;\n\t\t\teval(\"document.decision_support.date_val\"+i).value\t\t = \"current_date_time\" ;\n\t\t\teval(\"document.decision_support.operator_value\"+i).value = \"\" ;\n\t\t\teval(\"document.decision_support.action\"+i).value\t\t = \"N\";\n\t\t\teval(\"document.decision_support.message\"+i).value\t\t = \"\" ;\n\t\t\teval(\"document.decision_support.depend_finalString\"+i).value = \"\";\n\t\n\t\t}else if(default_val == \"N\" || default_val == \"I\" ){\t\n\t\t\tdocument.decision_support.visible_rows.value=i;\n\t\t\teval(\"document.decision_support.operator_value\"+i).value\t = \"\" ;\n\t\t\teval(\"document.decision_support.list_val\"+i).value\t\t\t = \"\";\n\t\t\teval(\"document.decision_support.between_val\"+i).value\t\t = \"\" ;\n\t\t\teval(\"document.decision_support.action\"+i).value\t\t\t = \"N\";\n\t\t\teval(\"document.decision_support.message\"+i).value\t\t\t = \"\";\n\t\t\teval(\"document.decision_support.depend_finalString\"+i).value = \"\";\n\t\t\t\n\t\t}\n\t\tif(i ==document.decision_support.row_count.value ){\n\t\t\ti=i-1;\n\t\t\teval(\"document.getElementById(\'next_row\')\"+i).style.visibility\t= \'visible\';\n\t\t\tdocument.decision_support.row_count.value\t\t\t= i;\n\t\t}else if(i < document.decision_support.row_count.value ) {\n\t\t\ty= y-1;\n\t\t\tdocument.decision_support.row_count.value=y;\n\t\t}else if(i > document.decision_support.row_count.value ) {\n\t\t\ty=y-1;\n\t\t\teval(\"document.getElementById(\'next_row\')\"+y).style.visibility\t= \'visible\';\n\t\t\tdocument.decision_support.row_count.value\t\t\t= y;\n\t\t}\n\t\t\n\t}\n\n}\n/*function checks for mandatory conditions  */\nfunction chkMandatory(obj,index)\n{\n\tvar\tdefault_val=document.decision_support.default_val.value\n\tvar i = index;\n\teval(\"document.decision_support.message\"+i).value=\"\";\n\t\n\tvar action = eval(\"document.decision_support.action\"+i).value ;\n\tif(action==\"N\"){\n\t\teval(\"document.decision_support.mandatory\"+i).style.visibility\t= \'hidden\';\n\t\teval(\"document.decision_support.oth_mnemonic\"+i).disabled\t\t= false ;\n\t\teval(\"document.decision_support.message\"+i).disabled\t\t\t= true;\n\t}else if(action==\"W\"){\n\t\teval(\"document.decision_support.mandatory\"+i).style.visibility\t= \'visible\';\n\t\teval(\"document.decision_support.oth_mnemonic\"+i).disabled\t\t= false ;\n\t\teval(\"document.decision_support.message\"+i).disabled\t\t\t= false;\n\t}else if(action==\"S\"){\n\t\teval(\"document.decision_support.mandatory\"+i).style.visibility\t= \'visible\';\n\t\teval(\"document.decision_support.oth_mnemonic\"+i).disabled\t\t= true ;\n\t\teval(\"document.decision_support.message\"+i).disabled\t\t\t= false;\n\t}\n}\n/*****************Between Value check *****************/\nfunction chkBtwn(obj,index){\n\nvar between_val_obj\t   = eval(\"document.decision_support.between_val\"+index);\nvar list_val_obj\t   = eval(\"document.decision_support.list_val\"+index);\n\nif(eval(between_val_obj.value) == \"\"){\n\t//obj.select();\n\tbetween_val_obj.focus();\n\tbetween_val_obj.select();\n\n}else{\n\tif(parseFloat(eval(between_val_obj.value)) < parseFloat(eval(list_val_obj.value))){\n\t\t\talert(\"APP-OR0232 Please enter a meaningful value ...\");\n\t\t\tbetween_val_obj.value = \"\";\n\t\t\tbetween_val_obj.focus();\n\t\t\tbetween_val_obj.select();\n\t }\n}\n\n}\n\nfunction isValidDecimal(val){\n\tif(isNaN(eval(val))){\n\t\talert(getMessage(\'INVALID_DECIMAL_NUMBER\',\'OR\'));\t\t\n\t\treturn false\n\t}else{\n\t\treturn true\n\t}\n}\n\nfunction checkDecimalRange(val,position1,position2){\n\tvar val_length = val.length;\n\n\tif(val == \"\" )\n\t\treturn true ;\n\tif(val.indexOf(\".\") != -1){\n\t\tval = parseFloat(eval(val))\n\n\t\tposition1 = parseFloat(eval(position1))\n\t\tposition2 = parseFloat(eval(position2))\n\t\tif(!((val >= position1) && (val <= position2))){\n\t\t\treturn false\n\t\t}\n\n\t}else{\n\t\tval = parseFloat(val)\n\t\tposition1 = parseFloat(eval(position1))\n\t\tposition2 = parseFloat(eval(position2))\n\n\t\tif(!((val >= position1) && (val <= position2))){\n\n\t\t\treturn false\n\t\t}\n\t}\n\treturn true\n}\n\nfunction checkIntegerRange(val,position1,position2){\n\tif(val == \"\" )\n\t\treturn true ;\n\n\t\tval = parseInt(eval(val))\n\t\tposition1 = parseInt(eval(position1))\n\t\tposition2 = parseInt(eval(position2))\n\n\t\tif(!((val >= position1) && (val <= position2))){\n\t\t\treturn false\n\t\t}\n\treturn true\n}\n/**takes values for insertion*/\nfunction chkforValues(){\n\tvar dontChknum=parent.list_bottom.list_dtl.dontChk.value;\n\tvar seq_num_length = parseInt((parent.list_top.seq_arr.length),10)+1;\n\tvar sequencenumber=document.decision_support.seq_no.value;\n\tvar\tdefault_val\t= document.decision_support.default_val.value\n\tvar\tmin_val\t= document.decision_support.min_val.value\n\tvar\tmax_val\t= document.decision_support.max_val.value\n\tvar\tmnemonic\t= document.decision_support.mnemonic.value\n\tvar count\t\t= document.decision_support.count.value\n\tvar values;var action;var message;var finalValue = \"\";var date_val;var operator_val;var notify;\n\tvar finalValue1 = \"\";var j;\n\tvar row_count   = document.decision_support.row_count.value\n\tif( default_val == \"C\" || default_val == \"L\" || default_val == \"R\" )\n\t{\t\n\t\tfor( var i=0;i<count;i++ ){\n\t\t\t\n\t\t\tvalues\t= eval(\"document.getElementById(\'values\')\"+i).innerText;\t\t\n\t\t\tif((values!=undefined) ||(values!=null))\n\t\t\t{\n\t\t\t\tif(values!=null||values!=\"\")\n\t\t\t\t{\n\t\t\t\t\tif(dontChknum==\"\")\n\t\t\t\t\t{\n\t\t\t\t\t\tsetFormatValues(\"dependency_\"+seq_num_length+\"_array\"+i,values);\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tsetFormatValues(\"dependency_\"+dontChknum+\"_array\"+i,values);\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\tif(dontChknum==\"\")\n\t\t\t{\n\t\t\t\tvalues=\"dependency_\"+seq_num_length+\"_array\"+i;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvalues=\"dependency_\"+dontChknum+\"_array\"+i;\n\t\t\t}\n\t\t\tvalues_arr[i]\t= values;\n\t\t\taction\t= eval(\"document.decision_support.action\"+i).value ;\n\t\t\taction_arr[i]\t= action;\n\t\t\tmessage\t= eval(\"document.decision_support.message\"+i).value ;\n\t\t\tif(eval(\"document.decision_support.notify_chk\"+i).checked == true)\n\t\t\t\tnotify\t\t\t= \"Y\" ; \n\t\t\telse\n\t\t\t\tnotify\t\t\t= \"N\" ;\n\t\t\tmessage_arr[i]\t= message;\n\t\t\tdepend_finalString = eval(\"document.decision_support.depend_finalString\"+i).value;\n\t\t\t\n\t\t\tj\t\t= i+1;\n\n\t\t\tif(action == \"S\" && message == \"\")\n\t\t\t{\talert(\'APP-OR237 Please Enter the Message for Action\');\n\t\t\t\teval(\"document.decision_support.message\"+i).focus() ;\n\t\t\t\treturn false;}\n\t\t\telse if(action == \"W\" && message == \"\")\n\t\t\t{\talert(\'APP-OR237 Please Enter the Message for Action\');\n\t\t\t\teval(\"document";
    private final static byte[]  _wl_block9_0Bytes = _getBytes( _wl_block9_0 );

    private final static java.lang.String  _wl_block9_1 =".decision_support.message\"+i).focus() ;\n\t\t\t\treturn false;}\n\t\t\tif(message == \"\")\n\t\t\t\tmessage = \" \";\n\t\t\tif(action == \"S\")\n\t\t\t\tdepend_finalString = \" \";\n\t\t\tif(depend_finalString == \"\"|| depend_finalString == \"N\")\n\t\t\t\tdepend_finalString = \" \";\n\t\t\t\n\t\t\tif(depend_finalString == \"Y\")\n\t\t\t{\tpopulateOtherMnemonicvalues(j);\n\t\t\t\tdepend_finalString = document.decision_support.depend_finalString.value;\n\t\t\t}\n\t\t\t\n\t\t\t//finalValue += \n\t\t\t\t//values+\",\"+j+\",\"+\" \"+\",\"+\" \"+\",\"+action+\",\"+(message)+\",\"+notify+\",\"+depend_finalString+\"||\";\n\n\t\t\t\tfinalValue += \n\t\t\t\tvalues+\",\"+j+\",\"+\" \"+\",\"+\" \"+\",\"+action+\",\"+(message)+\",\"+notify+\",\"+depend_finalString+\"||\";\n\t\t\t\n\t\t}\n\t\t\t\n\t}else if(default_val == \"E\" || default_val == \"D\"){\n\t\tfor( var i=0;i<=row_count;i++ ){\n\t\t\tif(eval(\"document.decision_support.operator_value\"+i).value != \"\"){\n\t\t\t\ttemp_oper_val\t =\teval(\"document.decision_support.operator_value\"+i).value ;\n\t\t\t\ttemp_action\t\t = eval(\"document.decision_support.action\"+i).value ;\n\t\t\t\tfor(var j=i+1;j<=row_count;j++){\n\t\t\t\t\tdup_oper_val\t= eval(\"document.decision_support.operator_value\"+j).value ;\n\t\t\t\t\tdup_actiuon\t\t= eval(\"document.decision_support.action\"+j).value ;\n\t\t\t\t\tif(temp_oper_val == dup_oper_val && temp_action == dup_actiuon)\n\t\t\t\t\t{\talert(\"APP-OR0233 Duplicate found in combination of Operator and Action\");\n\t\t\t\t\t\teval(\"document.decision_support.operator_value\"+j).focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\t\n\t\t\t}\n\t\t}\n\t\tfor( var i=0;i<=row_count;i++ ){\n\t\t\tif(eval(\"document.decision_support.operator_value\"+i).value ==\"\" ){\n\t\t\t//alert(\"select anyof the operator values:\");\n\t\t\t\n\t\t\t}else{\n\t\t\t\n\t\t\tdate_val\t= eval(\"document.decision_support.date_val\"+i).value ;\n\t\t\toperator_val= eval(\"document.decision_support.operator_value\"+i).value ;\n\t\t\taction\t\t= eval(\"document.decision_support.action\"+i).value ;\n\t\t\tmessage\t\t= eval(\"document.decision_support.message\"+i).value ;\n\t\t\tif(eval(\"document.decision_support.notify_chk\"+i).checked == true)\n\t\t\t\tnotify\t\t\t= \"Y\" ; \n\t\t\telse\n\t\t\t\tnotify\t\t\t= \"N\" ;\n\t\t\tdepend_finalString = eval(\"document.decision_support.depend_finalString\"+i).value;\n\t\t\tj=i+1;values=\" \";\n\t\t\t\n\t\t\tif(action == \"S\" && message == \"\")\n\t\t\t{\talert(\'APP-OR237 Please Enter the Message for Action\');\n\t\t\t\teval(\"document.decision_support.message\"+i).focus() ;\n\t\t\t\treturn false;}\n\t\t\telse if(action == \"W\" && message == \"\")\n\t\t\t{\talert(\'APP-OR237 Please Enter the Message for Action\');\n\t\t\t\teval(\"document.decision_support.message\"+i).focus() ;\n\t\t\t\treturn false;}\n\t\t\tif(message == \"\")\n\t\t\t\tmessage = \" \";\n\t\t\tif(action == \"S\")\n\t\t\t\tdepend_finalString = \" \";\n\t\t\tif(depend_finalString == \"\"|| depend_finalString == \"N\")\n\t\t\t\tdepend_finalString = \" \";\n\t\t\tif(depend_finalString == \"Y\")\n\t\t\t{\tpopulateOtherMnemonicvalues(j);\n\t\t\t\tdepend_finalString = document.decision_support.depend_finalString.value;\n\t\t\t}\n\t\t\t\t\n\t\t\tfinalValue += date_val+\",\"+j+\",\"+values+\",\"+operator_val+\",\"+action+\",\"+(message)+\",\"+notify+\",\"+depend_finalString+\"||\";\n\t\t\t}\n\t\t}\n\t}else if(default_val == \"N\" || default_val == \"I\" ){\n\t\tfor( var i=0;i<=row_count;i++ ){\n\t\t\tif(eval(\"document.decision_support.operator_value\"+i).value != \"\"){\n\t\t\t\ttemp_oper_val\t= eval(\"document.decision_support.operator_value\"+i).value ;\n\t\t\t\ttemp_action\t\t= eval(\"document.decision_support.action\"+i).value ;\n\t\t\t\tfor(var j=i+1;j<=row_count;j++){\n\t\t\t\t\tdup_oper_val\t= eval(\"document.decision_support.operator_value\"+j).value ;\n\t\t\t\t\tdup_action\t\t= eval(\"document.decision_support.action\"+j).value ;\n\t\t\t\t\tif(temp_oper_val == dup_oper_val && temp_action == dup_action)\n\t\t\t\t\t{\talert(\"APP-OR0233 Repeatation in the combination of Operator and Action\");\n\t\t\t\t\t\teval(\"document.decision_support.operator_value\"+j).focus();\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t}\n\t\t}\n\t\tfor( var i=0;i<=row_count;i++ ){\n\t\t\tif(eval(\"document.decision_support.operator_value\"+i).value ==\"\" ){\n\t\t\t\n\t\t\t}else{\n\t\t\t\toperator_val\t= eval(\"document.decision_support.operator_value\"+i).value ;\n\t\t\t\tlist_val\t\t= eval(\"document.decision_support.list_val\"+i).value ;\n\t\t\t\tbetween_val\t\t= eval(\"document.decision_support.between_val\"+i).value ;\n\t\t\t\taction\t\t\t= eval(\"document.decision_support.action\"+i).value ;\n\t\t\t\tmessage\t\t\t= eval(\"document.decision_support.message\"+i).value ;\n\t\t\t\t\n\t\t\t\tif(list_val == \"\"){\n\t\t\t\t\talert(\'APP-OR237 Values Cannot be blank...\');\n\t\t\t\t\teval(\"document.decision_support.list_val\"+i).select()\n\t\t\t\t\teval(\"document.decision_support.list_val\"+i).focus()\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\tif(eval(\"document.decision_support.operator_value\"+i).value ==\"B\" && between_val == \'\'){\n\t\t\t\t\talert(\'APP-OR237 Values Cannot be blank...\');\n\t\t\t\t\teval(\"document.decision_support.between_val\"+i).select()\n\t\t\t\t\teval(\"document.decision_support.between_val\"+i).focus()\n\t\t\t\t\treturn false;\n\n\t\t\t\t}\n\t\t\t\tif(eval(\"document.decision_support.notify_chk\"+i).checked == true)\n\t\t\t\t\tnotify\t\t\t= \"Y\" ; \n\t\t\t\telse\n\t\t\t\t\tnotify\t\t\t= \"N\" ;\n\n\t\t\t\tdepend_finalString = eval(\"document.decision_support.depend_finalString\"+i).value;\n\t\t\t\tj\t\t\t\t= i+1;\n\t\t\t\tif(default_val == \"N\"){\n\t\t\t\t\tif((isValidDecimal(list_val))){\n\n\t\t\t\t\t\tif(list_val.indexOf(\".\") != -1){\n\t\t\t\t\t\t\tint_part = list_val.split(\".\")\n\t\t\t\t\t\t\tdecimal_val = int_part[1]\n\t\t\t\t\t\t\tdecimal_pos = int_part.length +1\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(decimal_val.length > 3) {\n\t\t\t\t\t\t\t\talert(getMessage(\'MAX_NO_DECIMAL\',\'OR\'))\n\t\t\t\t\t\t\t\teval(\"document.decision_support.list_val\"+i).select()\n\t\t\t\t\t\t\t\teval(\"document.decision_support.list_val\"+i).focus()\n\t\t\t\t\t\t\t\treturn false\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\n\t\t\t\t\t\tif(min_val != \"\" && max_val != \"\"){\n\t\t\t\t\t\t\t//alert(checkDecimalRange(list_val,min_val,max_val))\n\t\t\t\t\t\t\tif((checkDecimalRange(list_val,min_val,max_val)) == false){\n\t\t\t\t\t\t\t\t//alert(\"Invalid Decimal Range...\")\n\t\t\t\t\t\t\t\talert(getMessage(\'INVALID_DECIMAL_RANGE\',\'OR\'))  ;\n\t\t\t\t\t\t\t\teval(\"document.decision_support.list_val\"+i).select()\n\t\t\t\t\t\t\t\teval(\"document.decision_support.list_val\"+i).focus()\n\t\t\t\t\t\t\t\treturn false\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}else{\n\t\t\t\t\t\teval(\"document.decision_support.list_val\"+i).select()\n\t\t\t\t\t\teval(\"document.decision_support.list_val\"+i).focus()\n\t\t\t\t\t\treturn false\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(default_val == \"I\"){\n\t\t\t\t\tif(min_val != \"\" && max_val != \"\"){\n\t\t\t\t\t\tif((checkIntegerRange(list_val,min_val,max_val)) == false){\n\t\t\t\t\t\t\t//alert(\"Invalid Integer Range...\")\n\t\t\t\t\t\t\talert(getMessage(\'INVALID_INTEGER_RANGE\',\'OR\'))  ;\n\t\t\t\t\t\t\teval(\"document.decision_support.list_val\"+i).select()\n\t\t\t\t\t\t\teval(\"document.decision_support.list_val\"+i).focus()\n\t\t\t\t\t\t\treturn false\n\t\t\t\t\t\t}else if((checkIntegerRange(between_val,min_val,max_val)) == false){\n\t\t\t\t\t\t\t//alert(\"Invalid Integer Range...\")\n\t\t\t\t\t\t\talert(getMessage(\'INVALID_INTEGER_RANGE\',\'OR\'))  ;\n\t\t\t\t\t\t\teval(\"document.decision_support.between_val\"+i).select()\n\t\t\t\t\t\t\teval(\"document.decision_support.between_val\"+i).focus()\n\t\t\t\t\t\t\treturn false\n\t\t\t\t\t\t}//checkIntegerRange if lup ends\n\t\t\t\t\t}//min_val & max_val  if lup ends\n\t\t\t\t}//default_val  if lup ends\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t\n\t\t\t\tif(between_val == \"\")\n\t\t\t\t\tbetween_val = \" \";\n\t\t\t\tif(action == \"S\" && message == \"\")\n\t\t\t\t{\talert(\'APP-OR237 Please Enter the Message for Action\');\n\t\t\t\t\teval(\"document.decision_support.message\"+i).focus() ;\n\t\t\t\t\treturn false;\n\t\t\t\t}else if(action == \"W\" && message == \"\")\n\t\t\t\t{\talert(\'APP-OR237 Please Enter the Message for Action\');\n\t\t\t\t\teval(\"document.decision_support.message\"+i).focus() ;\n\t\t\t\t\treturn false;}\n\t\t\t\tif(message == \"\")\n\t\t\t\t\tmessage = \" \";\n\t\t\t\tif(action == \"S\")\n\t\t\t\t\tdepend_finalString = \" \";\n\t\t\t\tif(depend_finalString == \"\" || depend_finalString == \"N\")\n\t\t\t\t\tdepend_finalString = \" \";\n\t\t\t\tif(depend_finalString == \"Y\")\n\t\t\t\t{\tpopulateOtherMnemonicvalues(j);\n\t\t\t\t\tdepend_finalString = document.decision_support.depend_finalString.value;\n\t\t\t\t}\n\t\t\t\n\t\t\t\tfinalValue += list_val+\",\"+j+\",\"+between_val+\",\"+operator_val+\",\"+action+\",\"+(message)+\",\"+notify+\",\"+depend_finalString+\"||\";\n\n\t\t\t}\t\n\t\t}\n\t}\n\t\n\tdocument.decision_support.finalvalue.value\t\t= finalValue;\n\tparent.list_bottom.list_dtl.finalValue.value\t= finalValue;\n\tif(finalValue != \"\")\n\t\tparent.list_bottom.list_dtl.chk_depnd.checked = true ;\n\telse \n\t\tparent.list_bottom.list_dtl.chk_depnd.checked = false ;\n\n\tparent.list_top.list_top.disabled\t\t\t\t = false;\n\tparent.list_bottom.list_dtl.chk_depnd.disabled\t = false;\n\tparent.list_bottom.list_dtl.depend.disabled\t\t = false;\n\tparent.list_bottom.list_dtl.clear.disabled\t\t = false;\n\tvar dontChk = document.getElementById(\"dontChk\").value;\n\tif (parent.list_top.mnemonic_arr[dontChk]\t== \"SPECIMEN_TYPE\" || parent.list_top.mnemonic_arr[dontChk] ==  \"NURSE_COLLECT_YN\" || parent.list_top.mnemonic_arr[dontChk] ==  \"COLLECTION_STAGE\") \n\t{\n\t\tif((parent.list_top.occ_no_arr[dontChk]==1)||(parent.list_top.occ_no_arr[dontChk]==undefined)||(parent.list_top.occ_no_arr[dontChk]==\"undefined\"))\n\t\t{\n\t\t\tparent.list_bottom.list_dtl.clear.disabled = true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tparent.list_bottom.list_dtl.clear.disabled =false;\n\t\t}\n\t}\n\tparent.list_bottom.list_dtl.mnemonic.disabled\t = false;\n\tparent.list_bottom.list_dtl.select.disabled\t\t = false;\n\tparent.list_bottom.list_dtl.ok.disabled\t\t\t = false;\n\tparent.list_bottom.list_dtl.close.disabled\t\t = false;\n\tparent.list_bottom.list_dtl.seq_no.disabled\t\t = false;\n\tparent.list_depend.location.href=\"../../eCommon/html/blank.html\";\n}\n\n/****funtion called on click of cancel*****/\nfunction clkCancel(){\n\tvar finalValue = document.decision_support.finalvalue.value;\n\tparent.list_bottom.list_dtl.finalValue.value\t = finalValue;\n\t\n\tif(finalValue != \"\")\n\t\tparent.list_bottom.list_dtl.chk_depnd.checked\t = true ;\n\tif(finalValue == \"\")\n\t\tparent.list_bottom.list_dtl.chk_depnd.checked\t = false ;\n\n\tparent.list_top.list_top.disabled\t\t\t\t\t = false;\n\tparent.list_bottom.list_dtl.chk_depnd.disabled\t\t = false;\n\tparent.list_bottom.list_dtl.depend.disabled\t\t\t = false;\n\tparent.list_bottom.list_dtl.clear.disabled\t\t\t = false;\n\tparent.list_bottom.list_dtl.mnemonic.disabled\t\t = false;\n\tparent.list_bottom.list_dtl.select.disabled\t\t\t = false;\n\tparent.list_bottom.list_dtl.seq_no.disabled\t\t\t = false;\n\tparent.list_bottom.list_dtl.ok.disabled\t\t\t\t = false;\n\tparent.list_bottom.list_dtl.close.disabled\t\t\t = false;\n\tparent.list_depend.location.href=\"../../eCommon/html/blank.html\";\n}\n\n-->\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t \n</head>\n<body onLoad=\'chkonload()\' onunload=\"\"  OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<form name=\"decision_support\" id=\"decision_support\"  >\n";
    private final static byte[]  _wl_block9_1Bytes = _getBytes( _wl_block9_1 );

    private final static java.lang.String  _wl_block10 ="\t<script>\n\t\t\talert(\'APP-002415 Query caused No records to be retrieved...\');\n\t\t\tparent.list_top.list_top.disabled\t\t\t\t= false;\n\t\t\tparent.list_bottom.list_dtl.chk_depnd.checked\t= false ;\n\t\t\tparent.list_bottom.list_dtl.clear.disabled\t\t= false;\n\t\t\tparent.list_bottom.list_dtl.mnemonic.disabled\t= false;\n\t\t\tparent.list_bottom.list_dtl.select.disabled\t\t= false;\n\t\t\tparent.list_bottom.list_dtl.seq_no.disabled\t\t= false;\n\t\t\tparent.list_bottom.list_dtl.ok.disabled\t\t\t= false;\n\t\t\tparent.list_bottom.list_dtl.close.disabled\t\t= false;\n\n\t\t\tparent.list_depend.location.href=\"../../eCommon/html/blank.html\";\n\t\t</script>\n\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table cellpadding=3 cellspacing=0 border=1 width=\'100%\'>\n<th>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n</table>\n<table class=\'grid\' width=\'100%\'>\n<tr>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<th>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </th>\n\t<th>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t<th>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</th>\n</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<tr id=row_id";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =">\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\n\t<td class=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' align=\'center\' nowrap>\n\t<label class=\'label\' id=\'oper";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t<select name=\"date_val";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"date_val";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" ><option value=\"\">--- ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" ---</option>\t\n\t\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<option value=\'current_date_time\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="<option value=\'current_date\' ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option></select>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</label>\n\t<select name=\"operator_value";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" id=\"operator_value";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" onChange=\'chkforOperator(this,";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =")\' >\n\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="---</option>\t\n\t\t<option value=\'E\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="  </option>\n\t\t<option value=\'L\' ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="> ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" </option>\t\n\t\t<option value=\'G\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="  </option>\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\t\t<option value=\'B\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" </option>\n\t</select>\n\t</td>\n\t\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\n\t<td class=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' width=\'\' align=\'center\' id=\'values";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t<input type=text name=\'list_val";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'list_val";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' size=5 maxlength=10 value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' onkeypress=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' >\n\t<input type=text name=\'between_val";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'between_val";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' onBlur=\'chkBtwn(this,";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =")\' style=\'display:none\' onkeypress=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' > \n\t<label class=\'label\' id=\'btw";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'></label>\t\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t<div class=\'label\'><b>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</b></div>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t</td> \t\n\t<td class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' width=\'\' align=\'center\' >\n\t\t<select name=\"action";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"action";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" onChange=\'chkMandatory(this,\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\")\' >\n\t\t\t<option value=\'W\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</option>\n\t\t\t<option value=\'S\' ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="   </option>\n\t\t\t<option value=\'N\' ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="  </option>\n\t\t</select>\n\t</td>\t\n\t<td class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' width=\'\' align=\'center\' nowrap>\n\t<input type=\"text\" name=\"message";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"message";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" maxlength=\'255\' size=\'25\' onpaste=\'return false\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' onKeyPress=\'return checkSpecialChar1(event);\' ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =">\n\t<img name=\'mandatory";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' style=\"visibility:visible\" src=\"../../eCommon/images/mandatory.gif\">\n\t</td><!--IN050630-->\n\t<td class=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' width=\'\' align=\'center\'>\n\t<input type=\"checkbox\" name=\"notify_chk";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" id=\"notify_chk";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" value=\'\' ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =">\n\t\n\t</td>\n\t<td class=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' width=\'\' align=\'center\' nowrap><input type=button class=\'button\' name=\'oth_mnemonic";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' id=\'oth_mnemonic";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'  value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' OnClick=\'listDetails1(\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\")\' ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =">\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t<input type=button class=\'button\' name=\'next_row";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' id=\'next_row";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' value=\'V\' style=\'visibility:visible\' OnClick=\'insertNextrow(";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =")\' >\n\t\t<input type=button class=\'button\' name=\'del_row";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' id=\'del_row";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' value=\'-\' style=\'visibility:visible\' OnClick=\'deleteRow(";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =")\' >\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\n\t</td>\n</tr>\n\t<input type=hidden name=\'depend_finalString";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' id=\'depend_finalString";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\t\t\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n<tr>\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\t\t<td colspan=\'6\' align=\'right\'>\n";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\t\t<td colspan=\'5\' align=\'right\'>\n";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t<input type=button class=\"button\" name=\"ok\" id=\"ok\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" onClick=\"chkforValues()\">\n\t<input type=button class=\"button\" name=\"close\" id=\"close\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" onClick=\'clkCancel()\'></td>\n</tr>\n</table>\n\n<input type=hidden name=\'order_type\' id=\'order_type\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<input type=hidden name=\'order_catalog\' id=\'order_catalog\' value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n<input type=hidden name=\'level\' id=\'level\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n<input type=hidden name=\'seq_no\' id=\'seq_no\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n<input type=hidden name=\'finalString\' id=\'finalString\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n<input type=hidden name=\'row_count\' id=\'row_count\' value=";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =">\n<input type=hidden name=\'finalvalue\' id=\'finalvalue\' value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n<input type=hidden name=\'depend_finalString\' id=\'depend_finalString\' value=\"\">\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9_0Bytes, _wl_block9_0);
            _bw.write(_wl_block9_1Bytes, _wl_block9_1);

try{
	
	String bean_id		= "Or_OrderEntryFormats" ;
	String bean_name	= "eOR.OrderEntryFormats";
	OrderEntryFormats beanObj = (OrderEntryFormats)getBeanObject( bean_id, bean_name, request ) ;
     request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	
	String default_val	= request.getParameter("dflt_val")==null?"":request.getParameter("dflt_val");
	String min_val	= request.getParameter("min_val")==null?"":request.getParameter("min_val");
	String max_val	= request.getParameter("max_val")==null?"":request.getParameter("max_val");
	String mnemonic		= request.getParameter("mnemonic");
	String ord_cat		= request.getParameter("ord_cat")==null?"":request.getParameter("ord_cat");;
	String order_type	=  request.getParameter("order_type")==null?"":request.getParameter("order_type");
	String order_catalog= request.getParameter("ord_catalog")==null?"":request.getParameter("ord_catalog");
	String level		= request.getParameter("level")==null?"":request.getParameter("level");
	String seq_no		= request.getParameter("seq_no")==null?"":request.getParameter("seq_no");
	String finalString	= request.getParameter("finalString")==null?"":request.getParameter("finalString");
	String finalValue	= request.getParameter("finalValue")==null?"":request.getParameter("finalValue");
	String dontChk	= request.getParameter("dontChk")==null?"":request.getParameter("dontChk");
	String format_id = request.getParameter("format_id")==null?"":request.getParameter("format_id");
		
	int i=0,count=1;
	TreeMap OrderTypeData = null;//<IN27169>

	String date_value		 = "";
	String operator_value	 = "";
	String action_value		 = "";
	String other_mnemonic	 = "";
	String message_text		 = "";
	String message_value	 = "";
	String notify			 = "";
	String list_operator_value = "";
	String between_value	 = "";
	String depend_finalString= "";
	//String prev_values		 = "";
	
	String chk_func			 = "";
	//IN050609 Starts
	if(default_val.equals("E"))
		date_value		= "current_date_time"	;
	else
		date_value		= "current_date"	;
	//date_value		= "current_date_time";
	//IN050609 Ends
	action_value	= "N";

	other_mnemonic	= "Y";
	message_text	= "N";
	out.println("<input type=hidden name='default_val' id='default_val' value='"+default_val+"'>" );
	out.println("<input type=hidden name='min_val' id='min_val' value='"+min_val+"'>" );
	out.println("<input type=hidden name='max_val' id='max_val' value='"+max_val+"'>" );
	out.println("<input type=hidden name='mnemonic' id='mnemonic' value='"+mnemonic+"'>" );
	out.println("<input type=hidden name='ord_cat' id='ord_cat' value='"+ord_cat+"'>" );
	out.println("<input type=hidden name='dontChk' id='dontChk' value='"+dontChk+"'>" );
	
	if(finalValue.equals("Y")){
		StringBuffer prev_values = new StringBuffer();
		ArrayList depend_values = new ArrayList();
		depend_values = beanObj.getDependency(level,ord_cat,order_type,order_catalog,seq_no,mnemonic);
		String[] record = null;
		for(int k=0; k<depend_values.size(); k++){
			record = (String [])depend_values.get(k);
			if(record[2]== null)
				record[2]=" ";
			if(record[5] == null)
				record[5] = " ";
			//prev_values.append( record[0]+","+record[1]+","+record[2]+","+record[3]+","+record[4]+","+record[5]+","+record[6]+","+record[7]+"||");

		}
		finalValue = prev_values.toString();		
		record = null;
		prev_values.setLength(0);
		depend_values.clear();
	}

	if(default_val.equals("C"))
		count=2;
	else if(default_val.equals("L") || default_val.equals("R")){
		//OrderTypeData = beanObj.getListTypeData(ord_cat,mnemonic) ;
		if((seq_no!=""||seq_no.equals("")) && (format_id!=""||format_id.equals("")))
		{
			OrderTypeData = beanObj.getListTypeData(ord_cat,mnemonic,seq_no,format_id) ;
		}
		else
		{
		   OrderTypeData = beanObj.getListTypeData(ord_cat,mnemonic) ;
		}
		count=OrderTypeData.size();
	}else if(default_val.equals("E") || default_val.equals("N") || default_val.equals("I")|| default_val.equals("D"))
		count=100;
	
	out.println("<input type=hidden name='count' id='count' value='"+count+"'>" );
	
	if(count  == 0)
	{
            _bw.write(_wl_block10Bytes, _wl_block10);
}
	String[] record = null;
	String[] record1 =null ;int j=0;
	
	if(finalValue != null || !finalValue.equals("")){
		StringTokenizer st1		= new StringTokenizer(finalValue,"||");
		String			mainStr = "";
		int cnt=st1.countTokens();
		record1 = new String[cnt] ;
		while(st1.hasMoreTokens()){
			mainStr  = st1.nextToken();
			record1[j]=mainStr;
			j++;
		}
		out.println("<input type=hidden name='visible_rows' id='visible_rows' value='"+j+"'>" );
	}
	

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if(default_val.equals("N")||default_val.equals("E") || default_val.equals("I") || default_val.equals("D")){
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
} if(!default_val.equals("E") && !default_val.equals("D")){
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

String classValue= "";
String[] record2	 = null ;
StringTokenizer st2	 =null;
for(i=0;i<count;i++){
	classValue			=( (i%2)==0 )? "gridData" : "gridData";
	if(!finalValue.equals("")){
		if((default_val.equals("E") || default_val.equals("N") || default_val.equals("I") || default_val.equals("D"))&& i<j){
			st2	 = new StringTokenizer(record1[i],",");			
			record2	 = new String[8] ;
			int y=0;
			while(st2.hasMoreTokens()){
				record2[y] = st2.nextToken();
				if(default_val.equals("E")|| default_val.equals("D")){
					//IN050609 Starts
					//date_value 		= record2[0];
					if(!"".equals(record2[0].trim()) && !"null".equals(record2[0]) && "Y".equals(record2[0].substring(0,1)))
						date_value		 = record2[0].substring(1);
					else
						date_value 		= record2[0];
					//IN050609 Ends
				//	seq_num			 = record2[1] ;
				//	list_value		 = record2[2] ;
					operator_value	 = record2[3] ;
					action_value	 = record2[4] ;
					message_value	 = record2[5] ;
					notify			 = record2[6] ;
					depend_finalString = record2[7] ;
				}else if(default_val.equals("N")|| default_val.equals("I")){
					
					list_operator_value = record2[0] ;
				//	seq_num			 = record2[1] ;
					between_value	 = record2[2] ;
					operator_value	 = record2[3] ;
					action_value	 = record2[4] ;
					message_value	 = record2[5] ;
					notify			 = record2[6] ;
					depend_finalString = record2[7] ;
				}
				y++;
				
			} record2 = null;
		}else if(default_val.equals("C") || default_val.equals("L") || default_val.equals("R") ){
			st2	 = new StringTokenizer(record1[i],",");
			record2	 = new String[8] ;
			int y=0;
			while(st2.hasMoreTokens()){
				record2[y]		 = st2.nextToken();
				if(default_val.equals("C") || default_val.equals("L") || default_val.equals("R") ){
				//	list_value			 = record2[0] ;
				//	seq_num				 = record2[1] ;
				//	field_mnemonic_value1= record2[2] ;
				//	field_value_type	 = record2[3] ;
					action_value		 = record2[4] ;
					message_value		 = record2[5] ;
					notify				 = record2[6] ;
					depend_finalString	 = record2[7] ;
				}
				y++;
				
			} record2 = null;
		}
		else
		{
			if(default_val.equals("E"))
			date_value		= "current_date_time"	;
			else
			date_value		= "current_date"	;
			operator_value	= ""	;
			action_value	= "N"	;
			message_value	= ""	;
			list_operator_value = "";
			depend_finalString	= "";
			between_value	= "";

			other_mnemonic	= "Y"	;
			message_text	= "N"	;
			notify			= "N"	;
			
		}
		if(message_value.equals(" ")|| message_value == null)
			message_value	= "";
		if(between_value.equals(" ")|| between_value == null)
			between_value	= "";
		if(depend_finalString.equals(" ")|| depend_finalString == null)
			depend_finalString = "";  
		if(action_value.equals("S")){
			other_mnemonic	= "N";
			message_text	= "Y";
		}else if( action_value.equals("W")){
			other_mnemonic	= "Y";
			message_text	= "Y";
		}else if(action_value.equals("N")){
			message_text	= "N";
			other_mnemonic	= "Y";} 

		out.println("<input type=hidden name='between_value"+i+"' id='between_value"+i+"' value='"+between_value+"'>" );
	}

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i));
            _bw.write(_wl_block19Bytes, _wl_block19);
if(default_val.equals("N") || default_val.equals("E")|| default_val.equals("I") || default_val.equals("D")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
	
	if(default_val.equals("E") || default_val.equals("D")){
		

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
if(default_val.equals("E")){
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(eHISFormatter.select(date_value,"current_date_time")));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
}else{
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(eHISFormatter.select(date_value,"current_date")));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block30Bytes, _wl_block30);
	}

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(eHISFormatter.select(operator_value,"E")));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(eHISFormatter.select(operator_value,"L")));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(eHISFormatter.select(operator_value,"G")));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
	if(default_val.equals("N")|| default_val.equals("I"))

            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(eHISFormatter.select(operator_value,"B")));
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
	if(default_val.equals("N") || default_val.equals("I")){
		if(default_val.equals("I")){
			chk_func = "return allowPositiveNumber()";
		}else
			chk_func = "return OrAllowDecimalNumber()";
		

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(list_operator_value));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(chk_func));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(between_value));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(chk_func));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
	}else if(default_val.equals("L") || default_val.equals("R")){
		record = (String[])OrderTypeData.get(i);
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(record[0]));
            _bw.write(_wl_block55Bytes, _wl_block55);
	record = null;}
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(eHISFormatter.select(action_value,"W")));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(eHISFormatter.select(action_value,"S")));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(eHISFormatter.select(action_value,"N")));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(message_value));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",message_text,"","disabled")));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(eHISFormatter.ChkBoxChecked("Y",notify)));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OtherMnemonic.label","or_labels")));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(eHISFormatter.chkReturn("y",other_mnemonic,"","disabled")));
            _bw.write(_wl_block79Bytes, _wl_block79);
	if(default_val.equals("N") || default_val.equals("E")|| default_val.equals("I")|| default_val.equals("D")){

            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
	}
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(depend_finalString));
            _bw.write(_wl_block90Bytes, _wl_block90);
}	

            _bw.write(_wl_block91Bytes, _wl_block91);
	if(default_val.equals("N") || default_val.equals("E")|| default_val.equals("I")|| default_val.equals("D")){

            _bw.write(_wl_block92Bytes, _wl_block92);
	}else{

            _bw.write(_wl_block93Bytes, _wl_block93);
	}
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(order_catalog));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(level));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(seq_no));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(finalString));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(j));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(finalValue));
            _bw.write(_wl_block103Bytes, _wl_block103);

if(OrderTypeData !=null)
	OrderTypeData.clear();
putObjectInBean(bean_id,beanObj,request);
}catch(Exception e){
	e.printStackTrace();
}

            _bw.write(_wl_block104Bytes, _wl_block104);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dependency.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Operator.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Values.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.action.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Message.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.AlertDept.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OtherMnemonic.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CurrentDateTime.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CurrentDate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.EqualsTo.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LessThan.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.GreaterThan.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Between.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Warning.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stop.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.none.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
