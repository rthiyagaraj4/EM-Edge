package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __discrmsrcomplistaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/DiscrMsrCompListAddModify.jsp", 1734611675623L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- developed by venkatesh.d on 5th may 2005 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<script src=\'../../eCommon/js/FieldFormatMethods.js\' language=\'javascript\'></script>\n\t<script src=\'../../eAM/js/DiscrMsrComp.js\' language=\'javascript\'></script>\n\t<script language=\"JavaScript\">\n\t<!--\n    function invis()\n\t{\n\t\t\n\t\tdocument.getElementById(\'sco1\').style.dispaly=\'none\';\n\t\tdocument.getElementById(\'sco2\').style.dispaly=\'none\';\n\t}\n\tfunction checkSequence(objSequence)\n\t{\n\tvar errorMessage =\"\"\n\t\n\t if(parseInt(objSequence.value) <= 0)\n\t\t\t{\n\t\t\t\t//errorMessage=messageArray[\"VALUE_SHOULD_BE_GR_ZERO\"];\n\t\t\t\t//alert(\'APP-AM1032-Value should be greater than Zero\');\n\t\t\t\terrorMessage= messageArray[\"VALUE_SHOULD_BE_GR_ZERO\"];\n\t\t\t\talert(errorMessage);\n\t\t\t\tobjSequence.value=\'\'\n\t\t\t\tobjSequence.select()\n\t\t\t\treturn false\n\t\t\t}\n\t if(objSequence.value.charAt(0) == \'-\'||objSequence.value.charAt(1) == \'-\')\n\t\t\t{\n\t\t\t\terrorMessage= messageArray[\"VALUE_SHOULD_BE_GR_ZERO\"];\n\t\t\t\talert(errorMessage);\n\t\t\t\tobjSequence.value=\'\'\n\t\t\t\tobjSequence.select()\n\t\t\t\treturn false\n\t\t\t}\n\n}\n\t\t\tfunction doSelect(val)\n\t\t\t{\n\t\t\t\tif(val == \'S\')\n\t\t\t\t{\n\t\t\t\t\tif(document.getElementById(\'desc\').value == \'\' || document.getElementById(\'result\').value == \'\')\n\t\t\t\t\t{\n\t\t\t\t\t\t//alert(\'APP-AM0115 All fields other than Default are mandatory\');\n\t\t\t\t\talert(getMessage(\"MANDATORY_FIELDS\",\"AM\"));\n\t\t\t\t/*\telse if(sortOrderChk() == false)\n\t\t\t\t\t{\n\t\t\t\t\t\talert(parent.getMessage(\'UNIQUIE_SORT_ORDER\'));\n\t\t\t\t\t\tdocument.getElementById(\'sort_order\').select();\n\t\t\t\t\t\tdocument.getElementById(\'sort_order\').focus();\n\t\t\t\t\t} */\n\t\t\t\t\t}\n\t\t\t\t\telse if(oneDefaultChk() == false )\n\t\t\t\t\t{\n                        \n\t\t\t\t\t\t//alert(\'APP-AM0120 Only one default value is allowed\');\n\t\t\t\t\t\talert(getMessage(\"ONE_DEFAULT\",\"AM\"));\n\t\t\t\t\t\tdocument.getElementById(\'default_yn\').focus();\n\t\t\t\t\t}\n\t\t\t\t\telse\n\t\t\t\t\t{\n\t\t\t\t\t\tif(document.getElementById(\'numericval\').value==\"\"||document.getElementById(\'numericval\').value==null)document.getElementById(\'numericval\').value=\"\";\n\t\t\t\t\t\tvar prevconvals = parent.frames[0].document.getElementById(\'prev_con_vals\').value;\n\t\t\t\t\t\tvar convals =document.getElementById(\'ref_range_seq\').value+\"~\"+document.getElementById(\'desc\').value+\"~\"+document.getElementById(\'result\').value+\"~\"+(document.getElementById(\'default_yn\').checked==true?\"Y\":\"N\")+\"~\"+document.getElementById(\'numericval\').value;\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(document.getElementById(\'mode\').value == \'insert\')\n\t\t\t\t\t\t{\t\t\t\t\t\t\t\n                            if(!duplecateCheck(prevconvals,convals))\n                            {\n\t\t\t\t\t\t\t\talert(\'APP-AM1560- ID can not be duplicated\');\n                                document.getElementById(\'result\').focus(); \n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\t\n\t\t\t\t\t\t\t\tif (prevconvals.trim().length>0)\n\t\t\t\t\t\t\t\t\tprevconvals = prevconvals + \"`\";\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tconvals = prevconvals+convals+\"`\";\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.forms[0].con_vals.value=convals;\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tdocument.forms[0].submit();\n\n\t\t\t\t\t\t\t\t//\tparent.frames[0].location.href = \"../../eAM/jsp/DiscrMeasureAlphaInfoResult.jsp?from=A&con_vals=\"+escape(convals)\n\t\t\t\t\t\t\t\tclearFields();\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar rownum = document.getElementById(\"row_num\").value;\n\n\n//parent.frames[0].document.getElementById(\'sorder_0\').innerText = \'2\'\n\t\t\t\t\t\t\tvar obj = eval(parent.frames[0].document.getElementById(\'desc_\'+rownum));\n\t\t\t\t\t\t\tstr = \"<a href=\'javascript:showDetails(\\\"\"+escape(convals)+\"\\\",\\\"\"+rownum+\"\\\",\\\"A\\\")\'>\"+ document.getElementById(\'desc\').value + \"</a>\";\n\t\t\t\t\t\t\tobj.innerHTML= str;\n                            obj = eval(parent.frames[0].document.getElementById(\'result_\'+rownum));\n\t\t\t\t\t\t\tobj.innerText= document.getElementById(\'result\').value;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tobj = eval(parent.frames[0].document.getElementById(\'numericval_\'+rownum));\n\t\t\t\t\t\t\tobj.innerText= document.getElementById(\'numericval\').value;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t//\tobj = eval(\"parent.frames[0].document.getElementById(\'sorder_\')\"+rownum);\n\t\t\t\t\t\t//\tobj.innerText= document.getElementById(\'sort_order\').value;\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tobj = eval(parent.frames[0].document.getElementById(\'def_\'+rownum));\n\t\t\t\t\t\t\tobj.innerText= (document.getElementById(\'default_yn\').checked==true?\"Y\":\"N\");\n                            \n\t\t\t\t\t\t\tclearFields();\n\t\t\t\t\t\t\tformtable();\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(val ==\'D\')\n\t\t\t\t{\n\t\t\t\t\t\tif(document.getElementById(\'desc\').value == \'\' || document.getElementById(\'result\').value == \'\')\n\t\t\t\t\t\t\talert(getMessage(\'CANNOT_DELETE\',\'SM\'));\n\t\t\t\t\t\telse\n\t\t\t\t\t\t{\n\n\t\t\t\t\t\t\tif(document.getElementById(\'numericval\').value==\"\"||document.getElementById(\'numericval\').value==null)document.getElementById(\'numericval\').value=\"\";\n\t\t\t\t\t\t\tvar prevconvals = parent.frames[0].document.getElementById(\'prev_con_vals\').value;\n\t\t\t\t\t\t\tvar convals =document.getElementById(\'ref_range_seq\').value+\"~\"+document.getElementById(\'desc\').value+\"~\"+document.getElementById(\'result\').value+\"~\"+(document.getElementById(\'default_yn\').checked==true?\"Y\":\"N\")+\"~\"+document.getElementById(\'numericval\').value\n\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar splitval = convals.split(\'~\');\n\t\t\t\t\t\t\tvar checkval = splitval[2];\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\tvar presplit = prevconvals.split(\'`\')\n\t\t\t\t\t\t\tvar finalval = \"\";\n\t\t\t\t\t\t\tfor(var i=0;i<presplit.length-1;i++)\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar prearr = presplit[i].split(\'~\');\n\t\t\t\t\t\t\t\tif(checkval != prearr[2])\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tfinalval += presplit[i]+\"`\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\n\t\t\t\t\t\t\tdocument.forms[0].con_vals.value=finalval;\n\t\t\t\t\t\t\tdocument.forms[0].submit();\n\t\t\t\t\t\t\tclearFields();\n\t\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse if(val==\'O\')\n\t\t\t\t{ \n\t\t\t\t\tvar n = parent.frames[0].document.getElementById(\'total_rows\').value;\n\t\t\t\t\tvar retdata=\'\';\n\t\t\t\t\t\n\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t{\n                    \tdocument.getElementById(\'ref_range_seq\').value = i+1\n \t\t\t\t\t\tvar temp = document.getElementById(\'ref_range_seq\').value+\"~\"+parent.frames[0].document.getElementById(\'desc_\'+i).innerText+\"~\"+parent.frames[0].document.getElementById(\'result_\'+i).innerText+\"~\"+parent.frames[0].document.getElementById(\'def_\'+i).innerText+\"~\"+parent.frames[0].document.getElementById(\'numericval_\'+i).innerText;\n\t\t\t\t\t\tif (i>0)\n\t\t\t\t\t\t\tretdata=retdata+\"`\";\n\t\t\t\t\t\t\n\t\t\t\t\t\tretdata=retdata+temp;\n\t\t\t\t\t}\n\t\t\t\t\t\n\t\t\t\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n\t\t\t\t\tdialogBody.contentWindow.returnValue = retdata;\n\t\t\t\t\tconst dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\t\t\t\tdialogTag.close(); \n\t\t\t\t\t//parent.window.returnValue = retdata;\n\t\t\t\t\t//alert(parent.window.returnValue+\"returnval\");\n\t\t\t\n\t\t\t\t    //parent.window.close();\n\t\t\t\t}\n\t\t\t\telse if(val ==\'CL\')\n\t\t\t\t{\n\t\t\t\t\tclearFields();\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t//parent.window.close();\n\t\t\t\t\tparent.parent.document.getElementById(\"dialog_tag\").close();\n\t\t\t\t}\n\t\t\t}\n\n\t\t/*\tfunction sortOrderChk()\n\t\t\t{\n\t\t\t\tif(document.getElementById(\'mode\').value == \'insert\')\n\t\t\t\t{\n\t\t\t\t\tvar rows = parent.frames[0].document.getElementById(\'total_rows\').value;\n\t\t\t\t\tfor(var n=0;n<rows;n++)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar obj = eval(\"parent.frames[0].document.getElementById(\'sorder_\')\"+n);\n\t\t\t\t\t\tif(document.getElementById(\'sort_order\').value == obj.innerText)\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\n\t\t\t\t\treturn true;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t\treturn true;\n\t\t\t} */\n\n\t\t\tfunction oneDefaultChk()\n\t\t\t{\n\t\t\t\tvar rows = eval(parent.frames[0].document.getElementById(\'total_rows\').value);\n\t\t\t\t//alert(rows);\n                var res=document.getElementById(\'result\').value;\n\t\t\t\t//alert(\'in modify page\'+res);\n\t\t\t\tfor(var n=0;n<rows;n++)\n\t\t\t\t{\n\t\t\t\t\tvar obj = eval(parent.frames[0].document.getElementById(\'def_\'+n));\t\n\t\t\t\t\tvar listres=eval(parent.frames[0].document.getElementById(\'result_\'+n).innerTextf);\n\t\t\t\t\t//alert(\'in result page\'+listres);\n\t\t\t\t\tvar temp = document.getElementById(\'default_yn\').checked==true?\"Y\":\"N\"\n                   // alert(obj.innerText); \n\n\t\t\t\t\n\t\t\t\t\tif(listres != res && temp==\'Y\' && obj.innerText == \'Y\') \n\t\t\t\t\t\treturn false;\n\t\t\t\t\n\t\t\t\t}\n\t\t\t\treturn true;\n\t\t\t}\n\n\n\t\t\tfunction clearFields()\n\t\t\t{\n\t\t\t\tdocument.getElementById(\'desc\').value = \"\";\n\t\t\t\tdocument.getElementById(\'result\').value = \"\";\n\t\t\t\tif(document.getElementById(\'result\').disabled == true)\n                document.getElementById(\'result\').disabled=false;\n\t\t\t\tdocument.getElementById(\'numericval\').value = \"\";\n\t\t\t\t//document.getElementById(\'sort_order\').value =\"\";\n\t\t\t\tdocument.getElementById(\'default_yn\').checked = false;\t\t\t\n\t\t\t\tdocument.getElementById(\'mode\').value = \"insert\"\n\t\t\t}\n\t//-->\n\t        function formtable()\n\t\t\t{\n\t\t\t//\talert(\'in formtable\');\n\t\t\t\tvar n = parent.frames[0].document.getElementById(\'total_rows\').value;\n\t\t\t\t\t\n\t\t\t\t\tvar retdata=\'\';\n\t\t\t\t\tfor(var i=0;i<n;i++)\n\t\t\t\t\t{\n                    document.getElementById(\'ref_range_seq\').value = i+1\n                   // alert(document.getElementById(\'ref_range_seq\').value); \n \t\t\t\t\tvar temp = document.getElementById(\'ref_range_seq\').value+\"~\"+parent.frames[0].document.getElementById(\'desc_\'+i).innerText+\"~\"+parent.frames[0].document.getElementById(\'result_\'+i).innerText+\"~\"+parent.frames[0].document.getElementById(\'def_\'+i).innerText+\"~\"+parent.frames[0].document.getElementById(\'numericval_\'+i).innerText+\"`\";\n\t\t\t\t\tretdata +=temp;\n\t\t\t\t\t//\talert(\'retdata\'+retdata);\n\t\t\t\t\t}\n\t\t\t\t\t//alert(\'modified\'+retdata);\n\t\t\t\t\tparent.frames[0].document.getElementById(\'prev_con_vals\').value=retdata;\n\t\t\t}\n\n\t\t\tfunction duplecateCheck(prev,current)\n\t\t\t{\n            arr2=current.split(\"~\");\n            arr=prev.split(\"`\");\n\t\t\tif(prev != \' \')\n\t\t\t\t{\n\t\t\t\t\n\t\t\tfor(i=0;i<arr.length;i++)\n\t\t\t\t{\n\t\t\t\ttemparr=arr[i].split(\"~\");\n\t\t\t\t\n\t\t\t\tif(temparr[2] == arr2[2])\n\t\t\t\t\t{\n\t\t\t\t\t\n\t\t\t\t\treturn false;\n                    }                \n                \n\t\t\t\t}\n\t\t\t\t\n\t\t\t\t}\n\n             return true;\n\n\t\t\t}\n\t\t\t\n\t\t\tfunction CheckForListSpecChars(event){\n\t\t\t\t\tvar strCheck = \'0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*#$%^()+,./:>?{}[]@\\;-=<\\| \';\n\t\t\t\t\tvar whichCode = (window.Event) ? event.which : event.keyCode;\n\t\t\t\t\tkey = String.fromCharCode(whichCode);  // Get key value from key code\n\t\t\t\t\tif (strCheck.indexOf(key) == -1) return false;  // Not a valid key\n\t\t\t\t\tif( (event.keyCode >= 97) && (event.keyCode <= 122) )\n\t\t\t\t\t\treturn (event.keyCode);\n\t\t\t\t\treturn true ;\n\t\t}\n\t</script>\n</head>\n\n<body OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\'DiscrMeasure_form\' id=\'DiscrMeasure_form\' method=\"post\" action=\"DiscrMsrCompListResult.jsp?from=A\" target=\"result\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<br>\n<table border=\'0\' cellpadding=\'2\' cellspacing=\'0\' width=\'90%\' align=\'center\'>\n<tr>\n\t<td   class=\'label\' >";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t<td  align=\'left\'>&nbsp;&nbsp;\n\t<input type=\'text\' ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" name=\'result\' id=\'result\' size=\"4\" maxlength=\"4\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" onBlur=\"ChangeUpperCase(this);makeValidString(this);CheckSpecialChar(this)\" onkeypress=\"return CheckForSpecChars(event)\">\n\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n \t\n</tr>\n\n<tr>\n\t<td  class=\'label\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td  align=\'left\'>&nbsp;&nbsp;\n\t\t<!--<input type=\'text\'  name=\'desc\' id=\'desc\' size=\"45\" maxlength=\"60\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onBlur=\"makeValidString(this)\" OnKeyPress =\"return CheckForListSpecChars(event)\">--COMMENTED FOR IN061911-->\n\t\t<input type=\'text\'  name=\'desc\' id=\'desc\' size=\"45\" maxlength=\"100\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onBlur=\"makeValidString(this)\" OnKeyPress =\"return CheckForListSpecChars(event)\"><!--IN061911-->\n\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n\t<td></td>\n\t<td></td>\n</tr>\n\n<tr id=\'score\' style=\'display:none\'>\n<td id=\'sco1\'   class=\'label\' >";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<td id=\'sco2\' align=\'left\'>&nbsp;&nbsp;\n\t<input type=\'text\' name=\'numericval\' id=\'numericval\' size=\"11\" maxlength=\"11\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onkeyPress=\" return allowValidNumber(this,event,8,2);\"  >\n\t\n</td>\n</tr>\n\n\n\n\n<tr  style=\'display:none\'>\n\t<td  align=\'right\' class=\'label\' >Sort Order</td>\n\t<td  align=\'left\'>&nbsp;&nbsp;\n\t<input type=\'text\'  name=\'sort_order\' id=\'sort_order\' size=\"2\" maxlength=\"2\" value=\"\" onKeyPress=\'return(ChkNumberInput(this,event,0))\'  OnBlur=\"CheckPositiveNumberLocal(this)\">\n\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n\t<td></td>\n\t<td></td>\n\n</tr>\n\n<tr>\n\t<td  class=\'label\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td  align=\'left\'>&nbsp;\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<input type=\"checkbox\" name=\"default_yn\" id=\"default_yn\" value=\"Y\" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" >\n\t</td>\n \t<td></td>\n\t<td></td>\n\n</tr>\n\n<tr><td></td>\n<td></td>\n<td></td>\n<td></td>\n</tr>\n<tr>\n\t<td align=right colspan=2>\n\t\t<input type=\"button\" class=BUTTON name=\"Select\" id=\"Select\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onClick=\"doSelect(\'S\')\">\n\t\t<input type=\"button\" class=BUTTON name=\"Delete\" id=\"Delete\" value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'  onClick=\"doSelect(\'D\')\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =">\n\t\t<input type=\"button\" class=BUTTON name=\"Ok\" id=\"Ok\" value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onClick=\'doSelect(\"O\");\'>\n\t\t<input type=\"button\" class=BUTTON name=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' value=\"Clear\" onClick=\"doSelect(\'CL\')\">\n\t\t<input type=\"button\" class=BUTTON name=\"Cancel\" id=\"Cancel\" value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'  onClick=\"doSelect(\'CA\')\">\n\t</td>\n\t<td></td>\n\t<td></td>\n\n</tr>\n</table>\n<input type=\"hidden\" name=\"con_vals\" id=\"con_vals\" value=\"\">\n<input type=\"hidden\" name=\"discr_measure\" id=\"discr_measure\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\"hidden\" name=\"ref_range_seq\" id=\"ref_range_seq\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\"hidden\" name=\"row_num\" id=\"row_num\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\"hidden\" name=\"status\" id=\"status\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\n</form>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<script>\n\t\n\t//document.getElementById(\'score\').style.display=\'none\';\n\t</script>\n ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

		request.setCharacterEncoding("UTF-8");
		String discrmeasure = request.getParameter("discr_measure")==null?"":request.getParameter("discr_measure");
		String convals = request.getParameter("con_vals")==null?"":request.getParameter("con_vals");
		String rownum = request.getParameter("row_num")==null?"":request.getParameter("row_num");
		String refrangeseq = "1";
		String description = "";
		String result = "";
		//String disab="";
		//String sortorder = "";
		String numericvalues="";
		String defaultval = "";
		String mode = "insert";
		String chk="";
		String status = request.getParameter("status")==null?"":request.getParameter("status");
        String del_disable = "";
		
		if(!convals.equals(""))
		{
			java.util.StringTokenizer st = new java.util.StringTokenizer(convals,"~");
			while(st.hasMoreTokens())
			{
				mode = "modify";
				
						
				refrangeseq = st.nextToken();
				
				description = st.nextToken().trim();
				
				result = st.nextToken();
			
			    defaultval = st.nextToken(); 
			    
				if(st.hasMoreElements()) 
				numericvalues=st.nextToken();
				
						
			}
		}
		if(numericvalues==null||numericvalues=="")numericvalues="";

if(numericvalues.equals("null")||numericvalues=="")
{
numericvalues="";
}
String disbld="";
if(mode.equals("modify")){
	disbld="disabled";
	del_disable = "";
}
else
	del_disable = "disabled";



            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(disbld));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(result));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(description));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(description));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(numericvalues));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(defaultval.equals("Y")) chk="checked"; else chk="";
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(del_disable));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(discrmeasure));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(refrangeseq));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(rownum));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(status));
            _bw.write(_wl_block30Bytes, _wl_block30);
if(status.equals("Y"))
  {
	 // out.println("<script>invis();</script>");
	// disab = "disabled";
	
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.identification.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Score.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Default.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.delete.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
