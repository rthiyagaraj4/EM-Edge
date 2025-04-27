package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __rangedisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/RangeDisplay.jsp", 1714656190267L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n <html>\n<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n<script>\n\n\nfunction test(num)\n\t{\n\t\tif(num > parent.frames[0].agerange_form.no_of_ranges.value)\n\t\t{\n\t\t\t\n\t\t\teval(\"parent.frames[1].document.agerange_form.range_\"+num+\"_fr\").disabled=true;\n\t\t\teval(\"parent.frames[1].document.agerange_form.range_\"+num+\"_to\").disabled=true;\n\t\t}else\n\t\t{\n\t\t\t\n\t\t}\n\t}\n\nfunction checkNoDecimal(fld,event)\n{\n\t//alert(\"here\");\n\tvar retVal;\n\tif (parent.frames[0].document.forms[0].range_type.value ==\"A\")\n\t{\n\t\t//alert(\"a\");\n\t\tfld.maxLength=3;\n\t\tretVal=allowValidNumber(fld,event,3, 0);\n\t}\n\telse if (parent.frames[0].document.forms[0].range_type.value ==\"W\")\n\t{\n\t\t//alert(\"w\");\n\t\tfld.maxLength=6;\n \t\tretVal==allowValidNumber(fld, event, 2,3);\n\t}\n\treturn retVal;\n}\n\n\t\n\t\n\tfunction func()\n\t{\n\t\tif (agerange_form.range_type.value == \'A\')\n\t\t{\n\t\t\tif (agerange_form.no_of_ranges.value <1 || agerange_form.no_of_ranges.value >25)\n\t\t\t{\n\t\t\t\tif(agerange_form.no_of_ranges.value.length >0)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"NO_OF_AGE_RANGE\",\"AM\"));\n\t\t\t\t\tagerange_form.no_of_ranges.select();\n\t\t\t\t\tagerange_form.no_of_ranges.focus();\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse if (agerange_form.range_type.value == \'W\')\n\t\t{\n\t\t\tif (agerange_form.no_of_ranges.value <1 || agerange_form.no_of_ranges.value >5)\n\t\t\t{\n\t\t\t\tif(agerange_form.no_of_ranges.value.length >0)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"NO_OF_WEIGHT_RANGE\",\"AM\"));\n\t\t\t\t\tagerange_form.no_of_ranges.select();\n\t\t\t\t\tagerange_form.no_of_ranges.focus();\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tvar arr1= new Array (\"document.agerange_form.range_1_fr\",\"document.agerange_form.range_1_to\", \t\t\t\t\t\t\"document.agerange_form.range_2_fr\",\"document.agerange_form.range_2_to\", \t\t\t\t\t\t\"document.agerange_form.range_3_fr\",\"document.agerange_form.range_3_to\",\n\t\t\t\t\t\t\t\"document.agerange_form.range_4_fr\",\"document.agerange_form.range_4_to\",\n\t\t\t\t\t\t\t\"document.agerange_form.range_5_fr\",\"document.agerange_form.range_5_to\",\n\t\t\t\t\t\t\t\"document.agerange_form.range_6_fr\",\"document.agerange_form.range_6_to\");\n\t\tvar noofrange = parseInt(agerange_form.no_of_ranges.value);\n\t\tfor(var k=noofrange*2; k< arr1.length;k++)\n\t\t{\n\t\t\teval(arr1[k]).value=\"\";\n\t\t}\n\t}\n\n\tfunction ChkOverLap(obj)\n\t{\n\t\tvar Fr_unit=\"\";\n\t\tvar To_unit=\"\";\n\n\t\t/*if(obj.name ==\"range_1_to_unit\" ||obj.name ==\"range_1_fr_unit\"||obj.name ==\"range_1_to\"||obj.name ==\"range_1_fr\" )\n\t\t\t{\n\t\t*/\n\t\t\tFr_unit=agerange_form.range_1_fr_unit.value;\n\t\t\tTo_unit=agerange_form.range_1_to_unit.value;\n\t\t/*\t}\n\t\telse if(obj.name ==\"range_2_to_unit\")\n\t\t{\n\t\t\tFr_unit=agerange_form.range_2_fr_unit.value;\n\t\t\tTo_unit=agerange_form.range_2_to_unit.value;\n\t\t}*/\n\n\t\tvar FrVal=0;\n\t\tvar ToVal=0;\n\n\t\t\tFrVal=agerange_form.range_1_fr.value;\n\t\t\tToVal=agerange_form.range_1_to.value;\n\n\t\t\tif(Fr_unit==\"D\" && To_unit==\"M\")\n\t\t\t{\n\t\t\t\tFrVal=agerange_form.range_1_fr.value;\n\t\t\t\tToVal=agerange_form.range_1_to.value*30;\n\t\t\t}\n\t\t\telse if(Fr_unit==\"M\" && To_unit==\"D\")\n\t\t\t{\n\n\t\t\t\tFrVal=agerange_form.range_1_fr.value*30;\n\t\t\t\tToVal=agerange_form.range_1_to.value;\n\t\t\t}\n\t\t\telse if(Fr_unit==\"M\" && To_unit==\"Y\")\n\t\t\t{\n\n\t\t\t\tFrVal=agerange_form.range_1_fr.value*30;\n\t\t\t\tToVal=agerange_form.range_1_to.value*365;\n\t\t\t}\n\t\t\telse if(Fr_unit==\"Y\" && To_unit==\"M\")\n\t\t\t{\n\n\t\t\t\tFrVal=agerange_form.range_1_fr.value*365;\n\t\t\t\tToVal=agerange_form.range_1_to.value*30;\n\t\t\t}\n\t\t\telse if(Fr_unit==\"D\" && To_unit==\"Y\")\n\t\t\t{\n\n\t\t\t\tFrVal=agerange_form.range_1_fr.value;\n\t\t\t\tToVal=agerange_form.range_1_to.value*365;\n\t\t\t}\n\t\t\telse if(Fr_unit==\"Y\" && To_unit==\"D\")\n\t\t\t{\n\n\t\t\t\tFrVal=agerange_form.range_1_fr.value*365;\n\t\t\t\tToVal=agerange_form.range_1_to.value;\n\t\t\t}\n\t\t\t\tvar nam=parseInt(FrVal,10);\n\t\t\t\tvar nam1=parseInt(ToVal,10);\n\n\t\t\tif(nam > nam1)\n\t\t\t\t\t\talert(\"Range OverLapping\");\n\t\t\t\t//obj.focus();\n\t}\n\nfunction tt(){\n\talert(\"Range \");\n}\n\n\nfunction ageWeightOption(Obj)\n{\n\t\n\t\n\n\tvar\tobjName =Obj.name;\n\tvar whichObj=\"document.agerange_form.\"+ objName;\n\t\n\t\n\tvar arr1= new Array (\"document.agerange_form.range_1_fr\",\"document.agerange_form.range_1_to\", \"document.agerange_form.range_2_fr\",\"document.agerange_form.range_2_to\", \"document.agerange_form.range_3_fr\",\"document.agerange_form.range_3_to\",\n\t\"document.agerange_form.range_4_fr\",\"document.agerange_form.range_4_to\",\n\t\"document.agerange_form.range_5_fr\",\"document.agerange_form.range_5_to\",\n\t\"document.agerange_form.range_6_fr\",\"document.agerange_form.range_6_to\");\n\n\tfor(var k=0; k< arr1.length;k++)\n\t{\n\n\t\teval(arr1[k]).value=\"\";\n\t\n\t}\n\n\t\n\tvar arr= new Array (\"document.agerange_form.range_1_fr_unit\",\"document.agerange_form.range_1_to_unit\", \"document.agerange_form.range_2_fr_unit\",\"document.agerange_form.range_2_to_unit\", \"document.agerange_form.range_3_fr_unit\",\"document.agerange_form.range_3_to_unit\",\n\t\"document.agerange_form.range_4_fr_unit\",\"document.agerange_form.range_4_to_unit\",\n\t\"document.agerange_form.range_5_fr_unit\",\"document.agerange_form.range_5_to_unit\",\n\t\"document.agerange_form.range_6_fr_unit\",\"document.agerange_form.range_6_to_unit\");\n\n\tfor(j =0; j < arr.length;j++)\n\t{\n\n\t\tvar len=eval(arr[j]).length;\n\n\t\t\n\t\tif(document.agerange_form.range_type.value ==\"W\")\n\t\t{\n\t\t\t\n\t\t\t\n\t\t\tfor(var i=0;i<len ;i++)\n\t\t\t{\n\t\t\t\t\n\t\t\t\teval(arr[j]).options[i]=null;\n\t\t\t}\n\n\t\t\teval(arr[j]).options[0] =new Option(\"Kgs\",\"K\");;\n\t\t\teval(arr[j]).options[1] =new Option(\"Lbs\",\"L\");\n\n\n\t\t}\n\n\t\tif(document.agerange_form.range_type.value ==\"A\")\n\t\t{\n\t\t\t\t\t\n\t\t\tfor(var i=0;i<len ;i++)\n\t\t\t{\n\t\t\t\teval(arr[j]).options[i]=null;\n\t\t\t}\n\t\t\teval(arr[j]).options[0] =new Option(\"Days\",\"D\");\n\t\t\teval(arr[j]).options[1] =new Option(\"Months\",\"M\");\n\t\t\teval(arr[j]).options[2] =new Option(\"Years\",\"Y\");\n\t\t}\n\t}\n\n}\n\n      \tfunction objClick(objName)\n      \t{\n      \t\t if(objName == \'range_0_7\')\n      \t\t\tmoveToLink(0);\n \t\t if (objName == \'range_6_10\')\n\t\t      \tmoveToLink(1);\n\t\tif(objName == \'range_15_21\')\n\t\t\tmoveToLink(2);\n\t\tif(objName == \'range_22_25\')\n\t\t\tmoveToLink(3);\n\t\tif(objName == \'range_8_14\')\n\t\t\tmoveToLink(4);\n\n      \t}\n      \tfunction moveToLink(LinkIndex) {\n\t\tif(LinkIndex==0)\n\t\t\tdocument.getElementById(\'range1\').scrollIntoView();\n\t\tif(LinkIndex==1)\n\t\t\t{\n\t\t\tdocument.getElementById(\'range2\').scrollIntoView();\n\t\t\t//document.getElementById(\'range_8_fr\').focus();\n\t\t\t}\n\t\tif(LinkIndex==2){\n\t\t\tdocument.getElementById(\'range3\').scrollIntoView();\n\t\t//document.getElementById(\'range_15_fr\').focus();\n\t\t}\n\t\tif(LinkIndex==3)\n\t\t\t{\n\t\t\tdocument.getElementById(\'range4\').scrollIntoView();\n\t\t\t//document.getElementById(\'range_22_fr\').focus();\n\t\t\t}\n\t\tif(LinkIndex==4){document.getElementById(\'range2\').scrollIntoView();\n\t\t//document.getElementById(\'range_8_fr\').focus();\n\t\t}\n\n\n\t}\n\n\n      \t\n</script>\n\n</head>\n<body  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onSelect=\"codeArrestThruSelect();\">\n<form name=\"agerange_form\" id=\"agerange_form\" action=\"../../servlet/eAM.AgeRangeServlet\" method=\"post\" target=\"messageFrame\">\n<center>\n<a name=\'range1\' id=\'range1\'></a>\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"85%\">\n  \t\t\t<!--tr><td>&nbsp;</td><td>&nbsp;</td></tr-->\n<th align=\'LEFT\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n<tr>\n<td colspan=\'5\' align=\'right\' >\n<a href=\"javascript:objClick(\'range_6_10\') \"   alt=\'Identity\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</a>\n</td>\n</tr>\n\t  <tr>\n\t\t<td class=\"BORDER\" width=\"100%\">\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"40%\" align=\"right\" class=\"label\">&nbsp;</td>\n\t\t\t\t\t<td width=\"15%\" class=\"label\">&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t<td width=\"15%\" class=\"label\">&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t<td width=\"15%\" class=\"label\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </td>\t\n\t\t\t\t\t<td width=\"15%\" class=\"label\">&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t</tr>\t\t\t\t\t\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\n\t     \t\t<tr>\n\t       \t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" 1</td>\n\t   \t    \t    <td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_1_fr\" id=\"range_1_fr\" size=\"6\" maxlength=\"3\" onFocus=\"test(1);objClick(\'range_0_7\');\"   onBlur=\"CheckNum(this)\" onKeyPress=\"return checkNoDecimal(this,event);\" ></td>\n   \t       \t\t\t<td width=\"15%\" align=\"left\" class=\"fields\">&nbsp;<select name=\"range_1_fr_unit\" id=\"range_1_fr_unit\" onFocus=\"test(1);\" >\n\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t<OPTION  VALUE=\"K\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t\t\t\t<OPTION VALUE=\"L\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t<OPTION VALUE=\"D\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t<OPTION VALUE=\"W\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<OPTION VALUE=\"M\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<OPTION VALUE=\"Y\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\n\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_1_to\" id=\"range_1_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(1)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_1_to_unit\" id=\"range_1_to_unit\" onFocus=\"test(1)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t</td>\n\t   \t    \t</tr>\n<script>\n\tdocument.getElementById(\'range_1_fr\').value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\tdocument.getElementById(\'range_1_fr_unit\').value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\tdocument.getElementById(\'range_1_to\').value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\tdocument.getElementById(\'range_1_to_unit\').value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n</script>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" 2</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_2_fr\" id=\"range_2_fr\" size=\"6\" maxlength=\"6\" value=\"\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(2)\"  onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_2_fr_unit\" id=\"range_2_fr_unit\" onFocus=\"test(2)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t </select></td>\n\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_2_to\" id=\"range_2_to\" size=\"6\" maxlength=\"6\"  value=\"\" onFocus=\"test(2)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_2_to_unit\" id=\"range_2_to_unit\" onFocus=\"test(2)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<OPTION VALUE=\"D\" >";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n<script>\n\tdocument.getElementById(\'range_2_fr\').value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\tdocument.getElementById(\'range_2_fr_unit\').value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\tdocument.getElementById(\'range_2_to\').value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\tdocument.getElementById(\'range_2_to_unit\').value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n</script>\t\t\t\t\n\t\t\t<tr>\n\t\t\t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" 3</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_3_fr\" id=\"range_3_fr\" size=\"6\" maxlength=\"6\" onFocus=\"test(3)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\" >&nbsp;<select name=\"range_3_fr_unit\" id=\"range_3_fr_unit\" onFocus=\"test(3)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t </select></td>\n\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_3_to\" id=\"range_3_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(3)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_3_to_unit\" id=\"range_3_to_unit\" onFocus=\"test(3)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t </select>\n\t\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n<script>\n\tdocument.getElementById(\'range_3_fr\').value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\tdocument.getElementById(\'range_3_fr_unit\').value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\tdocument.getElementById(\'range_3_to\').value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\tdocument.getElementById(\'range_3_to_unit\').value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\n</script>\t   \t    \t\n\t   \t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" 4</td>\n\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_4_fr\" id=\"range_4_fr\" size=\"6\" maxlength=\"6\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(4)\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_4_fr_unit\" id=\"range_4_fr_unit\" onFocus=\"test(4)\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t<OPTION  VALUE=\"K\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</option>\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"L\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"D\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"W\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"M\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"Y\">";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t\t\t\t\t </select>\n\t\t\t\t\t\t\t\t\t </td>\n\n\t\t\t\t\t\t\t\t<td class=\"fields\"><input type=\"text\" name=\"range_4_to\" id=\"range_4_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(4)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t\t\t<td width=\"15%\"  >&nbsp;<select name=\"range_4_to_unit\" id=\"range_4_to_unit\" onFocus=\"test(4)\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION  VALUE=\"K\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</option>\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"L\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"D\">";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"W\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"M\">";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"Y\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t </select>\n\t\t\t\t\t\t\t\t\t </td>\n\t   \t    \t</tr>\n<script>\n\tdocument.getElementById(\'range_4_fr\').value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\";\n\tdocument.getElementById(\'range_4_fr_unit\').value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\";\n\tdocument.getElementById(\'range_4_to\').value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\";\n\tdocument.getElementById(\'range_4_to_unit\').value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" 5</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_5_fr\" id=\"range_5_fr\" size=\"6\" onKeyPress=\"return checkNoDecimal(this,event);\" maxlength=\"6\" onFocus=\"test(5)\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_5_fr_unit\" id=\"range_5_fr_unit\" onFocus=\"test(5)\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t\t\t<OPTION  VALUE=\"K\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</option>\n\t\t\t\t\t\t\t\t<OPTION VALUE=\"L\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t<OPTION VALUE=\"D\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t    <OPTION VALUE=\"W\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t<OPTION VALUE=\"M\">";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t<OPTION VALUE=\"Y\">";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t </select></td>\n\n\t\t\t\t\t\t<td class=\"fields\"><input type=\"text\" name=\"range_5_to\" id=\"range_5_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(5)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this);\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_5_to_unit\" id=\"range_5_to_unit\" onFocus=\"test(5);\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t<OPTION VALUE=\"W\">";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t </select></td>\n\t   \t    \t</tr>\n<script>\n\tdocument.getElementById(\'range_5_fr\').value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\";\n\tdocument.getElementById(\'range_5_fr_unit\').value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\";\n\tdocument.getElementById(\'range_5_to\').value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\";\n\tdocument.getElementById(\'range_5_to_unit\').value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\";\n</script>\n\t\t\t<tr>\n\t       \t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" 6</td>\n\t   \t    \t    \t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_6_fr\" id=\"range_6_fr\" size=\"6\" maxlength=\"3\" onFocus=\"test(6)\"   onBlur=\"CheckNum(this)\" onKeyPress=\"return checkNoDecimal(this,event);\" ></td>\n   \t       \t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_6_fr_unit\" id=\"range_6_fr_unit\" onFocus=\"test(6);\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_6_to\" id=\"range_6_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(6)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_6_to_unit\" id=\"range_6_to_unit\" onFocus=\"test(6)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t</td>\n\t   \t    \t</tr>\n\n<script>\n\tdocument.getElementById(\'range_6_fr\').value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\";\n\tdocument.getElementById(\'range_6_fr_unit\').value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\";\n\tdocument.getElementById(\'range_6_to\').value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\";\n\tdocument.getElementById(\'range_6_to_unit\').value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =" 7</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_7_fr\" id=\"range_7_fr\" size=\"6\" maxlength=\"6\" value=\"\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(7)\"  onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_7_fr_unit\" id=\"range_7_fr_unit\" onFocus=\"test(7)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t\t\t </select></td>\n\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_7_to\" id=\"range_7_to\" size=\"6\" maxlength=\"6\"  value=\"\" onFocus=\"test(7)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_7_to_unit\" id=\"range_7_to_unit\" onFocus=\"test(7)\" onBlur=\"objClick(\'range_6_10\');\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t\n<script>\n\tdocument.getElementById(\'range_7_fr\').value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\";\n\tdocument.getElementById(\'range_7_fr_unit\').value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\";\n\tdocument.getElementById(\'range_7_to\').value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\";\n\tdocument.getElementById(\'range_7_to_unit\').value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\";\n</script>\n\n </table>\n <br><br><br><br><br>\n <br><br><br><br><br>\n\t  <br><br><br><br><br>\n <br><br><br><br><br>\n<!---------------- FIRST SET ENDS HERE ----------------------------->\n<a name=\'range2\' id=\'range2\'></a>\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"85%\">\n  \t\t\t<!--tr><td>&nbsp;</td><td>&nbsp;</td></tr-->\n<th align=\'LEFT\'>";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</th>\n<tr>\n<td colspan=\'5\' align=\'right\' >\n<a href=\"javascript:objClick(\'range_0_7\') \"alt=\'Identity\'>";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</a>\n<a href=\"javascript:objClick(\'range_15_21\') \"alt=\'Identity\'>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</a>\n</td>\n</tr>\n\t  <tr>\n\t\t<td class=\"BORDER\" width=\"100%\">\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"40%\"  class=\"label\">&nbsp;</td>\n\t\t\t\t\t<td width=\"15%\" class=\"label\">&nbsp;";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</td>\n\t\t\t\t</tr>\t\t\t\t\t\n\n\t     \t\t<tr>\n\t       \t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 =" 8</td>\n\t   \t    \t    <td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_8_fr\" id=\"range_8_fr\" size=\"6\" maxlength=\"3\" onFocus=\"test(8)\"   onBlur=\"CheckNum(this)\" onKeyPress=\"return checkNoDecimal(this,event);\" ></td>\n   \t       \t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_8_fr_unit\" id=\"range_8_fr_unit\" onFocus=\"test(8);\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_8_to\" id=\"range_8_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(8)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_8_to_unit\" id=\"range_8_to_unit\" onFocus=\"test(8)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t</td>\n\t   \t    \t</tr>\n\n<script>\n\tdocument.getElementById(\'range_8_fr\').value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\";\n\tdocument.getElementById(\'range_8_fr_unit\').value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\";\n\tdocument.getElementById(\'range_8_to\').value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\";\n\tdocument.getElementById(\'range_8_to_unit\').value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\";\n</script>\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" 9</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_9_fr\" id=\"range_9_fr\" size=\"6\" maxlength=\"6\" value=\"\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(9)\"  onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_9_fr_unit\" id=\"range_9_fr_unit\" onFocus=\"test(9)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t </select></td>\n\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_9_to\" id=\"range_9_to\" size=\"6\" maxlength=\"6\"  value=\"\" onFocus=\"test(9)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_9_to_unit\" id=\"range_9_to_unit\" onFocus=\"test(9)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n\n<script>\n\tdocument.getElementById(\'range_9_fr\').value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\";\n\tdocument.getElementById(\'range_9_fr_unit\').value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\";\n\tdocument.getElementById(\'range_9_to\').value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\";\n\tdocument.getElementById(\'range_9_to_unit\').value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =" 10</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_10_fr\" id=\"range_10_fr\" size=\"6\" maxlength=\"6\" onFocus=\"test(10)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_10_fr_unit\" id=\"range_10_fr_unit\" onFocus=\"test(10)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t </select></td>\n\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_10_to\" id=\"range_10_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(10)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_10_to_unit\" id=\"range_10_to_unit\" onFocus=\"test(10)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t\t </select>\n\t\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n\n<script>\n\tdocument.getElementById(\"range_10_fr\").value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\";\n\tdocument.getElementById(\"range_10_fr_unit\").value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\";\n\tdocument.getElementById(\"range_10_to\").value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\";\n\tdocument.getElementById(\"range_10_to_unit\").value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\";\n</script>\n\n\t   \t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" 11</td>\n\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_11_fr\" id=\"range_11_fr\" size=\"6\" maxlength=\"6\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(11)\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_11_fr_unit\" id=\"range_11_fr_unit\" onFocus=\"test(11)\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t\t\t\t\t\t\t\t </select>\n\t\t\t\t\t\t\t\t\t </td>\n\n\t\t\t\t\t\t\t\t<td class=\"fields\"><input type=\"text\" name=\"range_11_to\" id=\"range_11_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(11)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_11_to_unit\" id=\"range_11_to_unit\" onFocus=\"test(11)\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\t\t\t\t\t\t\t\t\t </select>\n\t\t\t\t\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n\n<script>\n\tdocument.getElementById(\'range_11_fr\').value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\";\n\tdocument.getElementById(\'range_11_fr_unit\').value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\";\n\tdocument.getElementById(\'range_11_to\').value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\";\n\tdocument.getElementById(\'range_11_to_unit\').value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =" 12</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_12_fr\" id=\"range_12_fr\" size=\"6\" onKeyPress=\"return checkNoDecimal(this,event);\" maxlength=\"6\" onFocus=\"test(12)\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_12_fr_unit\" id=\"range_12_fr_unit\" onFocus=\"test(12)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t\t </select></td>\n\n\t\t\t\t\t\t<td class=\"fields\"><input type=\"text\" name=\"range_12_to\" id=\"range_12_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(12)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_12_to_unit\" id=\"range_12_to_unit\" onFocus=\"test(12)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t\t </select></td>\n\n\n\t   \t    \t</tr>\n<script>\n\tdocument.getElementById(\'range_12_fr\').value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\";\n\tdocument.getElementById(\'range_12_fr_unit\').value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\";\n\tdocument.getElementById(\'range_12_to\').value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\";\n\tdocument.getElementById(\'range_12_to_unit\').value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\";\n</script>\t   \t    \t\n\t   \t    \t\n\t     \t\t<tr>\n\t       \t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =" 13</td>\n\t   \t    \t    <td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_13_fr\" id=\"range_13_fr\" size=\"6\" maxlength=\"3\" onFocus=\"test(13)\"   onBlur=\"CheckNum(this)\" onKeyPress=\"return checkNoDecimal(this,event);\" ></td>\n   \t       \t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_13_fr_unit\" id=\"range_13_fr_unit\" onFocus=\"test(13);\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_13_to\" id=\"range_13_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(13)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_13_to_unit\" id=\"range_13_to_unit\" onFocus=\"test(13)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t</td>\n\t   \t    \t</tr>\n\n<script>\n\tdocument.getElementById(\'range_13_fr\').value=\"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\";\n\tdocument.getElementById(\'range_13_fr_unit\').value=\"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\";\n\tdocument.getElementById(\'range_13_to\').value=\"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\";\n\tdocument.getElementById(\'range_13_to_unit\').value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" 14</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_14_fr\" id=\"range_14_fr\" size=\"6\" maxlength=\"6\" value=\"\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(14)\"  onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_14_fr_unit\" id=\"range_14_fr_unit\" onFocus=\"test(14)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t\t </select></td>\n\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_14_to\" id=\"range_14_to\" size=\"6\" maxlength=\"6\"  value=\"\" onFocus=\"test(14)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_14_to_unit\" id=\"range_14_to_unit\" onFocus=\"test(14)\" onBlur=\"objClick(\'range_15_21\');\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n<script>\n\tdocument.getElementById(\'range_14_fr\').value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\";\n\tdocument.getElementById(\'range_14_fr_unit\').value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\";\n\tdocument.getElementById(\'range_14_to\').value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\";\n\tdocument.getElementById(\'range_14_to_unit\').value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\";\n</script>\t\t\t\n\t\t\t\n\t\t\t\n </table>\n <br><br><br><br><br>\n<br><br><br><br><br>\n <br><br><br><br><br>\n <br><br><br><br><br>\n<!---------------- SECOND SET ENDS HERE ----------------------------->\n<a name=\'range3\' id=\'range3\'></a>\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"85%\">\n  \t\t\t<!--tr><td>&nbsp;</td><td>&nbsp;</td></tr-->\n<th align=\'LEFT\'>";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="</th>\n<tr>\n<td colspan=\'5\' align=\'right\' >\n<a href=\"javascript:objClick(\'range_8_14\') \"alt=\'Identity\'>";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</a>\n<a href=\"javascript:objClick(\'range_22_25\') \"alt=\'Identity\'>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</a>\n</td>\n</tr>\n\t  <tr>\n\t\t<td class=\"BORDER\" width=\"100%\">\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"40%\"  class=\"labelcenter\">&nbsp;</td>\n\t\t\t\t\t<td width=\"15%\" class=\"label\">&nbsp;";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 =" 15</td>\n\t   \t    \t    <td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_15_fr\" id=\"range_15_fr\" size=\"6\" maxlength=\"3\" onFocus=\"test(15)\"   onBlur=\"CheckNum(this)\" onKeyPress=\"return checkNoDecimal(this,event);\" ></td>\n   \t       \t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_15_fr_unit\" id=\"range_15_fr_unit\" onFocus=\"test(15);\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_15_to\" id=\"range_15_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(15)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_15_to_unit\" id=\"range_15_to_unit\" onFocus=\"test(15)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t</td>\n\t   \t    \t</tr>\n<script>\n\tdocument.getElementById(\'range_15_fr\').value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\";\n\tdocument.getElementById(\'range_15_fr_unit\').value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\";\n\tdocument.getElementById(\'range_15_to\').value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\";\n\tdocument.getElementById(\'range_15_to_unit\').value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 =" 16</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_16_fr\" id=\"range_16_fr\" size=\"6\" maxlength=\"6\" value=\"\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(16)\"  onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_16_fr_unit\" id=\"range_16_fr_unit\" onFocus=\"test(16)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t\t\t </select></td>\n\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_16_to\" id=\"range_16_to\" size=\"6\" maxlength=\"6\"  value=\"\" onFocus=\"test(16)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_16_to_unit\" id=\"range_16_to_unit\" onFocus=\"test(16)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n<script>\n\tdocument.getElementById(\'range_16_fr\').value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\";\n\tdocument.getElementById(\'range_16_fr_unit\').value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\";\n\tdocument.getElementById(\'range_16_to\').value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\";\n\tdocument.getElementById(\'range_16_to_unit\').value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 =" 17</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_17_fr\" id=\"range_17_fr\" size=\"6\" maxlength=\"6\" onFocus=\"test(17)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_17_fr_unit\" id=\"range_17_fr_unit\" onFocus=\"test(17)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\n\t\t\t\t\t\t\t </select></td>\n\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_17_to\" id=\"range_17_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(17)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_17_to_unit\" id=\"range_17_to_unit\" onFocus=\"test(17)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t </select>\n\t\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n\n<script>\n\tdocument.getElementById(\'range_17_fr\').value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\";\n\tdocument.getElementById(\'range_17_fr_unit\').value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\";\n\tdocument.getElementById(\'range_17_to\').value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\";\n\tdocument.getElementById(\'range_17_to_unit\').value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =" 18</td>\n\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_18_fr\" id=\"range_18_fr\" size=\"6\" maxlength=\"6\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(18)\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_18_fr_unit\" id=\"range_18_fr_unit\" onFocus=\"test(18)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t\t\t\t\t\t\t\t\t </select>\n\t\t\t\t\t\t\t\t\t </td>\n\n\t\t\t\t\t\t\t\t<td><input type=\"text\" name=\"range_18_to\" id=\"range_18_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(18)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t\t\t<td width=\"15%\"  >&nbsp;<select name=\"range_18_to_unit\" id=\"range_18_to_unit\" onFocus=\"test(18)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\t\t\t\t\t\t </select>\n\t\t\t\t\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n\n<script>\n\tdocument.getElementById(\'range_18_fr\').value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\";\n\tdocument.getElementById(\'range_18_fr_unit\').value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\";\n\tdocument.getElementById(\'range_18_to\').value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\";\n\tdocument.getElementById(\'range_18_to_unit\').value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 =" 19</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_19_fr\" id=\"range_19_fr\" size=\"6\" onKeyPress=\"return checkNoDecimal(this,event);\" maxlength=\"6\" onFocus=\"test(19)\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_19_fr_unit\" id=\"range_19_fr_unit\" onFocus=\"test(19)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\t\t\t\t\t </select></td>\n\n\t\t\t\t\t\t<td class=\"fields\"><input type=\"text\" name=\"range_19_to\" id=\"range_19_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(19)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_19_to_unit\" id=\"range_19_to_unit\" onFocus=\"test(19)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\t\t\t\t </select></td>\n\n\n\t   \t    \t</tr>\n\n<script>\n\tdocument.getElementById(\'range_19_fr\').value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\";\n\tdocument.getElementById(\'range_19_fr_unit\').value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\";\n\tdocument.getElementById(\'range_19_to\').value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\";\n\tdocument.getElementById(\'range_19_to_unit\').value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\";\n</script>\n\n\t     \t\t<tr>\n\t       \t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 =" 20</td>\n\t   \t    \t    <td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_20_fr\" id=\"range_20_fr\" size=\"6\" maxlength=\"3\" onFocus=\"test(20)\"   onBlur=\"CheckNum(this)\" onKeyPress=\"return checkNoDecimal(this,event);\" ></td>\n   \t       \t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_20_fr_unit\" id=\"range_20_fr_unit\" onFocus=\"test(20);\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_20_to\" id=\"range_20_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(20)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_20_to_unit\" id=\"range_20_to_unit\" onFocus=\"test(20)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t</td>\n\t   \t    \t</tr>\n<script>\n\tdocument.getElementById(\'range_20_fr\').value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\";\n\tdocument.getElementById(\'range_20_fr_unit\').value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\";\n\tdocument.getElementById(\'range_20_to\').value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\";\n\tdocument.getElementById(\'range_20_to_unit\').value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 =" 21</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_21_fr\" id=\"range_21_fr\" size=\"6\" maxlength=\"6\" value=\"\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(21)\"  onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_21_fr_unit\" id=\"range_21_fr_unit\" onFocus=\"test(21)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\t\t\t\t\t </select></td>\n\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_21_to\" id=\"range_21_to\" size=\"6\" maxlength=\"6\"  value=\"\" onFocus=\"test(21)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_21_to_unit\" id=\"range_21_to_unit\" onFocus=\"test(21)\" onBlur=\"objClick(\'range_22_25\');\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n\t\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t<script>\n\t\tdocument.getElementById(\'range_21_fr\').value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\";\n\t\tdocument.getElementById(\'range_21_fr_unit\').value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\";\n\t\tdocument.getElementById(\'range_21_to\').value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\";\n\t\tdocument.getElementById(\'range_21_to_unit\').value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\";\n\t</script>\n\n\n </table>\n <br><br><br><br><br>\n <br><br><br><br><br>\n\t  <br><br><br><br><br>\n <br><br><br><br><br>\n<!---------------- THIRD SET ENDS HERE ----------------------------->\n\n<a name=\'range4\'  id=\'range4\'></a>\n  <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"85%\">\n  \t\t\t<!--tr><td>&nbsp;</td><td>&nbsp;</td></tr-->\n<th align=\'LEFT\'>";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="</th>\n<tr>\n<td colspan=\'5\' align=\'right\' >\n<a href=\"javascript:objClick(\'range_15_21\') \"alt=\'Identity\'>";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 =" 22</td>\n\t   \t    \t    <td width=\"15%\" align=\"left\" class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_22_fr\" id=\"range_22_fr\" size=\"6\" maxlength=\"3\" onFocus=\"test(22)\"   onBlur=\"CheckNum(this)\" onKeyPress=\"return checkNoDecimal(this,event);\" ></td>\n   \t       \t\t\t<td width=\"15%\" align=\"left\" class=\"fields\">&nbsp;<select name=\"range_22_fr_unit\" id=\"range_22_fr_unit\" onFocus=\"test(22);\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t\t\t\t\t</select>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_22_to\" id=\"range_22_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(22)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_22_to_unit\" id=\"range_22_to_unit\" onFocus=\"test(22)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t</td>\n\t   \t    \t</tr>\n\n<script>\n\tdocument.getElementById(\'range_22_fr\').value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\";\n\tdocument.getElementById(\'range_22_fr_unit\').value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\";\n\tdocument.getElementById(\'range_22_to\').value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\";\n\tdocument.getElementById(\'range_22_to_unit\').value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\";\n</script>\n\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 =" 23</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_23_fr\" id=\"range_23_fr\" size=\"6\" maxlength=\"6\" value=\"\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(23)\"  onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_23_fr_unit\" id=\"range_23_fr_unit\" onFocus=\"test(23)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\n\t\t\t\t\t </select></td>\n\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_23_to\" id=\"range_23_to\" size=\"6\" maxlength=\"6\"  value=\"\" onFocus=\"test(23)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_23_to_unit\" id=\"range_23_to_unit\" onFocus=\"test(23)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n\n<script>\n\tdocument.getElementById(\'range_23_fr\').value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\";\n\tdocument.getElementById(\'range_23_fr_unit\').value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\";\n\tdocument.getElementById(\'range_23_to\').value=\"";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\";\n\tdocument.getElementById(\'range_23_to_unit\').value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 =" 24</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_24_fr\" id=\"range_24_fr\" size=\"6\" maxlength=\"6\" onFocus=\"test(24)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_24_fr_unit\" id=\"range_24_fr_unit\" onFocus=\"test(24)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\t\t\t\t </select></td>\n\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_24_to\" id=\"range_24_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(24)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_24_to_unit\" id=\"range_24_to_unit\" onFocus=\"test(24)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\n\t\t\t\t\t\t<OPTION VALUE=\"M\">";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t\t\t\t </select>\n\t\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n<script>\n\tdocument.getElementById(\'range_24_fr\').value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\";\n\tdocument.getElementById(\'range_24_fr_unit\').value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\";\n\tdocument.getElementById(\'range_24_to\').value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\";\n\tdocument.getElementById(\'range_24_to_unit\').value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 =" 25</td>\n\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_25_fr\" id=\"range_25_fr\" size=\"6\" maxlength=\"6\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(25)\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_25_fr_unit\" id=\"range_25_fr_unit\" onFocus=\"test(25)\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t\t\t\t\t\t </select>\n\t\t\t\t\t\t\t\t\t </td>\n\n\t\t\t\t\t\t\t\t<td class=\"fields\"><input type=\"text\" name=\"range_25_to\" id=\"range_25_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(25)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_25_to_unit\" id=\"range_25_to_unit\" onFocus=\"test(25)\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\n\t\t\t\t\t\t\t\t\t </select>\n\t\t\t\t\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n<script>\n\tdocument.getElementById(\'range_25_fr\').value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\";\n\tdocument.getElementById(\'range_25_fr_unit\').value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\";\n\tdocument.getElementById(\'range_25_to\').value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\";\n\tdocument.getElementById(\"range_25_to_unit\").value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\";\n</script>\n </table>\n <br><br><br><br><br>\n <br><br><br><br><br>\n <br><br><br><br><br>\n\t  <br><br><br><br><br>\n <br><br><br><br><br>\n\n\n\n<input type=\"hidden\" name=\"function\" id=\"function\" value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\">\n<input type=\"hidden\" name=\"eff_date_from\" id=\"eff_date_from\" >\n<input type=\"hidden\" name=\"eff_date_to\" id=\"eff_date_to\" >\n<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\n<input type=\'hidden\' name=\'range_type\' id=\'range_type\' value=\'\'>\n<input type=\'hidden\' name=\'range_id\' id=\'range_id\' value=\'\'>\n<input type=\'hidden\' name=\'long_desc\' id=\'long_desc\' value=\'\'>\n<input type=\'hidden\' name=\'short_desc\' id=\'short_desc\' value=\'\'>\n<input type=\'hidden\' name=\'no_of_ranges\' id=\'no_of_ranges\' value=\'\'>\n<input type=\'hidden\' name= \'eff_status\' id= \'eff_status\' value=\'\'>\n\n";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\t\n\t<script>\n\tfor(var i=0;i<document.forms[0].elements.length;i++)\n\t\t\tdocument.forms[0].elements[i].disabled=true;\n\t</script>\n";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\n</form>\n</center>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
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

request.setCharacterEncoding("UTF-8");	
	String  range_id = request.getParameter("range_id");
		if(range_id == null) range_id="";
	String range_type = request.getParameter("range_type");
		if(range_type == null || range_type.equals("")) range_type="";
	Connection conn = null;
	Statement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rset=null;
	String eff_status="";
	String functionVal="";
String range_1_fr ="",range_1_fr_unit="",range_1_to ="",range_1_to_unit ="";                    
String range_2_fr ="",range_2_fr_unit="",range_2_to ="",range_2_to_unit ="";
String range_3_fr ="",range_3_fr_unit="",range_3_to ="",range_3_to_unit ="";
String range_4_fr ="",range_4_fr_unit="",range_4_to ="",range_4_to_unit ="";
String range_5_fr ="",range_5_fr_unit="",range_5_to ="",range_5_to_unit ="";
String range_6_fr ="",range_6_fr_unit="",range_6_to ="",range_6_to_unit ="";
String range_7_fr ="",range_7_fr_unit="",range_7_to ="",range_7_to_unit ="";
String range_8_fr ="",range_8_fr_unit="",range_8_to ="",range_8_to_unit ="";
String range_9_fr ="",range_9_fr_unit="",range_9_to ="",range_9_to_unit ="";
String range_10_fr ="",range_10_fr_unit="",range_10_to ="",range_10_to_unit ="";
String range_11_fr ="",range_11_fr_unit="",range_11_to ="",range_11_to_unit ="";
String range_12_fr ="",range_12_fr_unit="",range_12_to ="",range_12_to_unit ="";
String range_13_fr ="",range_13_fr_unit="",range_13_to ="",range_13_to_unit ="";
String range_14_fr ="",range_14_fr_unit="",range_14_to ="",range_14_to_unit ="";
String range_15_fr ="",range_15_fr_unit="",range_15_to ="",range_15_to_unit ="";
String range_16_fr ="",range_16_fr_unit="",range_16_to ="",range_16_to_unit ="";
String range_17_fr ="",range_17_fr_unit="",range_17_to ="",range_17_to_unit ="";
String range_18_fr ="",range_18_fr_unit="",range_18_to ="",range_18_to_unit ="";
String range_19_fr ="",range_19_fr_unit="",range_19_to ="",range_19_to_unit ="";
String range_20_fr ="",range_20_fr_unit="",range_20_to ="",range_20_to_unit ="";
String range_21_fr ="",range_21_fr_unit="",range_21_to ="",range_21_to_unit ="";
String range_22_fr ="",range_22_fr_unit="",range_22_to ="",range_22_to_unit ="";
String range_23_fr ="",range_23_fr_unit="",range_23_to ="",range_23_to_unit ="";
String range_24_fr ="",range_24_fr_unit="",range_24_to ="",range_24_to_unit ="";
String range_25_fr ="",range_25_fr_unit="",range_25_to ="",range_25_to_unit ="";




try{

if(!range_id.equals(""))
{
	conn = ConnectionManager.getConnection(request);
	functionVal ="modify";
	
	//String sql="select * from am_summ_range where range_id='"+range_id+"' and range_type='"+range_type+"'";
	//stmt = conn.createStatement();
	//rset = stmt.executeQuery(sql);
	
	String sql="select * from am_summ_range where range_id=? and range_type=?";
	pstmt   = conn.prepareStatement(sql);
	pstmt.setString	(	1,	range_id		);
	pstmt.setString	(	2,	range_type		);
	rset		 = pstmt.executeQuery();
	rset.next();



eff_status = rset.getString("eff_status");
if(eff_status == null) eff_status="E";


range_1_fr =rset.getString("range_1_fr");
range_1_fr_unit=rset.getString("range_1_fr_unit");
range_1_to =rset.getString("range_1_to");
range_1_to_unit =rset.getString("range_1_to_unit");           
if(range_1_fr == null) range_1_fr="";
if(range_1_fr_unit == null) range_1_fr_unit="";
if(range_1_to == null) range_1_to="";
if(range_1_to_unit == null) range_1_to_unit="";

range_2_fr =rset.getString("range_2_fr");range_2_fr_unit=rset.getString("range_2_fr_unit");range_2_to =rset.getString("range_2_to");range_2_to_unit =rset.getString("range_2_to_unit");
if(range_2_fr == null) range_2_fr="";if(range_2_fr_unit == null) range_2_fr_unit="";if(range_2_to == null) range_2_to="";if(range_2_to_unit == null) range_2_to_unit="";

range_3_fr =rset.getString("range_3_fr");range_3_fr_unit=rset.getString("range_3_fr_unit");range_3_to =rset.getString("range_3_to");range_3_to_unit =rset.getString("range_3_to_unit");
if(range_3_fr == null) range_3_fr="";if(range_3_fr_unit == null) range_3_fr_unit="";if(range_3_to == null) range_3_to="";if(range_3_to_unit == null) range_3_to_unit="";

range_4_fr =rset.getString("range_4_fr");range_4_fr_unit=rset.getString("range_4_fr_unit");range_4_to =rset.getString("range_4_to");range_4_to_unit =rset.getString("range_4_to_unit");
if(range_4_fr == null) range_4_fr="";if(range_4_fr_unit == null) range_4_fr_unit="";if(range_4_to == null) range_4_to="";if(range_4_to_unit == null) range_4_to_unit="";

range_5_fr =rset.getString("range_5_fr");range_5_fr_unit=rset.getString("range_5_fr_unit");range_5_to =rset.getString("range_5_to");range_5_to_unit =rset.getString("range_5_to_unit");
if(range_5_fr == null) range_5_fr="";if(range_5_fr_unit == null) range_5_fr_unit="";if(range_5_to == null) range_5_to="";if(range_5_to_unit == null) range_5_to_unit="";

range_6_fr =rset.getString("range_6_fr");range_6_fr_unit=rset.getString("range_6_fr_unit");range_6_to =rset.getString("range_6_to");range_6_to_unit =rset.getString("range_6_to_unit");
if(range_6_fr == null) range_6_fr="";if(range_6_fr_unit == null) range_6_fr_unit="";if(range_6_to == null) range_6_to="";if(range_6_to_unit == null) range_6_to_unit="";

range_7_fr =rset.getString("range_7_fr");range_7_fr_unit=rset.getString("range_7_fr_unit");range_7_to =rset.getString("range_7_to");range_7_to_unit =rset.getString("range_7_to_unit");
if(range_7_fr == null) range_7_fr="";if(range_7_fr_unit == null) range_7_fr_unit="";if(range_7_to == null) range_7_to="";if(range_7_to_unit == null) range_7_to_unit="";

range_8_fr =rset.getString("range_8_fr");range_8_fr_unit=rset.getString("range_8_fr_unit");range_8_to =rset.getString("range_8_to");range_8_to_unit =rset.getString("range_8_to_unit");
if(range_8_fr == null) range_8_fr="";if(range_8_fr_unit == null) range_8_fr_unit="";if(range_8_to == null) range_8_to="";if(range_8_to_unit == null) range_8_to_unit="";


range_9_fr =rset.getString("range_9_fr");range_9_fr_unit=rset.getString("range_9_fr_unit");range_9_to =rset.getString("range_9_to");range_9_to_unit =rset.getString("range_9_to_unit");
if(range_9_fr == null) range_9_fr="";if(range_9_fr_unit == null) range_9_fr_unit="";if(range_9_to == null) range_9_to="";if(range_9_to_unit == null) range_9_to_unit="";


range_10_fr =rset.getString("range_10_fr");range_10_fr_unit=rset.getString("range_10_fr_unit");range_10_to =rset.getString("range_10_to");range_10_to_unit =rset.getString("range_10_to_unit");
if(range_10_fr == null) range_10_fr="";if(range_10_fr_unit == null) range_10_fr_unit="";if(range_10_to == null) range_10_to="";if(range_10_to_unit == null) range_10_to_unit="";

range_11_fr =rset.getString("range_11_fr");range_11_fr_unit=rset.getString("range_11_fr_unit");range_11_to =rset.getString("range_11_to");range_11_to_unit =rset.getString("range_11_to_unit");
if(range_11_fr == null) range_11_fr="";if(range_11_fr_unit == null) range_11_fr_unit="";if(range_11_to == null) range_11_to="";if(range_11_to_unit == null) range_11_to_unit="";

range_12_fr =rset.getString("range_12_fr");range_12_fr_unit=rset.getString("range_12_fr_unit");range_12_to =rset.getString("range_12_to");range_12_to_unit =rset.getString("range_12_to_unit");
if(range_12_fr == null) range_12_fr="";if(range_12_fr_unit == null) range_12_fr_unit="";if(range_12_to == null) range_12_to="";if(range_12_to_unit == null) range_12_to_unit="";

range_13_fr =rset.getString("range_13_fr");range_13_fr_unit=rset.getString("range_13_fr_unit");range_13_to =rset.getString("range_13_to");range_13_to_unit =rset.getString("range_13_to_unit");
if(range_13_fr == null) range_13_fr="";if(range_13_fr_unit == null) range_13_fr_unit="";if(range_13_to == null) range_13_to="";if(range_13_to_unit == null) range_13_to_unit="";

range_14_fr =rset.getString("range_14_fr");range_14_fr_unit=rset.getString("range_14_fr_unit");range_14_to =rset.getString("range_14_to");range_14_to_unit =rset.getString("range_14_to_unit");
if(range_14_fr == null) range_14_fr="";if(range_14_fr_unit == null) range_14_fr_unit="";if(range_14_to == null) range_14_to="";if(range_14_to_unit == null) range_14_to_unit="";

range_15_fr =rset.getString("range_15_fr");range_15_fr_unit=rset.getString("range_15_fr_unit");range_15_to =rset.getString("range_15_to");range_15_to_unit =rset.getString("range_15_to_unit");
if(range_15_fr == null) range_15_fr="";if(range_15_fr_unit == null) range_15_fr_unit="";if(range_15_to == null) range_15_to="";if(range_15_to_unit == null) range_15_to_unit="";

range_16_fr =rset.getString("range_16_fr");range_16_fr_unit=rset.getString("range_16_fr_unit");range_16_to =rset.getString("range_16_to");range_16_to_unit =rset.getString("range_16_to_unit");
if(range_16_fr == null) range_16_fr="";if(range_16_fr_unit == null) range_16_fr_unit="";if(range_16_to == null) range_16_to="";if(range_16_to_unit == null) range_16_to_unit="";


range_17_fr =rset.getString("range_17_fr");range_17_fr_unit=rset.getString("range_17_fr_unit");range_17_to =rset.getString("range_17_to");range_17_to_unit =rset.getString("range_17_to_unit");
if(range_17_fr == null) range_17_fr="";if(range_17_fr_unit == null) range_17_fr_unit="";if(range_17_to == null) range_17_to="";if(range_17_to_unit == null) range_17_to_unit="";

range_18_fr =rset.getString("range_18_fr");range_18_fr_unit=rset.getString("range_18_fr_unit");range_18_to =rset.getString("range_18_to");range_18_to_unit =rset.getString("range_18_to_unit");
if(range_18_fr == null) range_18_fr="";if(range_18_fr_unit == null) range_18_fr_unit="";if(range_18_to == null) range_18_to="";if(range_18_to_unit == null) range_18_to_unit="";

range_19_fr =rset.getString("range_19_fr");range_19_fr_unit=rset.getString("range_19_fr_unit");range_19_to =rset.getString("range_19_to");range_19_to_unit =rset.getString("range_19_to_unit");
if(range_19_fr == null) range_19_fr="";if(range_19_fr_unit == null) range_19_fr_unit="";if(range_19_to == null) range_19_to="";if(range_19_to_unit == null) range_19_to_unit="";

range_20_fr =rset.getString("range_20_fr");range_20_fr_unit=rset.getString("range_20_fr_unit");range_20_to =rset.getString("range_20_to");range_20_to_unit =rset.getString("range_20_to_unit");
if(range_20_fr == null) range_20_fr="";if(range_20_fr_unit == null) range_20_fr_unit="";if(range_20_to == null) range_20_to="";if(range_20_to_unit == null) range_20_to_unit="";

range_21_fr =rset.getString("range_21_fr");range_21_fr_unit=rset.getString("range_21_fr_unit");range_21_to =rset.getString("range_21_to");range_21_to_unit =rset.getString("range_21_to_unit");
if(range_21_fr == null) range_21_fr="";if(range_21_fr_unit == null) range_21_fr_unit="";if(range_21_to == null) range_21_to="";if(range_21_to_unit == null) range_21_to_unit="";

range_22_fr =rset.getString("range_22_fr");range_22_fr_unit=rset.getString("range_22_fr_unit");range_22_to =rset.getString("range_22_to");range_22_to_unit =rset.getString("range_22_to_unit");
if(range_22_fr == null) range_22_fr="";if(range_22_fr_unit == null) range_22_fr_unit="";if(range_22_to == null) range_22_to="";if(range_22_to_unit == null) range_22_to_unit="";

range_23_fr =rset.getString("range_23_fr");range_23_fr_unit=rset.getString("range_23_fr_unit");range_23_to =rset.getString("range_23_to");range_23_to_unit =rset.getString("range_23_to_unit");
if(range_23_fr == null) range_23_fr="";if(range_23_fr_unit == null) range_23_fr_unit="";if(range_23_to == null) range_23_to="";if(range_23_to_unit == null) range_23_to_unit="";

range_24_fr =rset.getString("range_24_fr");range_24_fr_unit=rset.getString("range_24_fr_unit");range_24_to =rset.getString("range_24_to");range_24_to_unit =rset.getString("range_24_to_unit");
if(range_24_fr == null) range_24_fr="";if(range_24_fr_unit == null) range_24_fr_unit="";if(range_24_to == null) range_24_to="";if(range_24_to_unit == null) range_24_to_unit="";

range_25_fr =rset.getString("range_25_fr");range_25_fr_unit=rset.getString("range_25_fr_unit");range_25_to =rset.getString("range_25_to");range_25_to_unit =rset.getString("range_25_to_unit");
if(range_25_fr == null) range_25_fr="";if(range_25_fr_unit == null) range_25_fr_unit="";if(range_25_to == null) range_25_to="";if(range_25_to_unit == null) range_25_to_unit="";

	

}else
{
functionVal="insert";

if(range_type.equals("A") || range_type.equals("") && range_1_fr_unit.equals("")) range_1_fr_unit="D";else if(range_type.equals("W")  && range_1_fr_unit.equals("")) range_1_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_1_to_unit.equals("")) range_1_to_unit="D";else if(range_type.equals("W") && range_1_to_unit.equals("")) range_1_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_2_fr_unit.equals("")) range_2_fr_unit="D";else if(range_type.equals("W")  && range_2_fr_unit.equals("")) range_2_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_2_to_unit.equals("")) range_2_to_unit="D";else if(range_type.equals("W") && range_2_to_unit.equals("")) range_2_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_3_fr_unit.equals("")) range_3_fr_unit="D";else if(range_type.equals("W")  && range_3_fr_unit.equals("")) range_3_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_3_to_unit.equals("")) range_3_to_unit="D";else if(range_type.equals("W") && range_3_to_unit.equals("")) range_3_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_4_fr_unit.equals("")) range_4_fr_unit="D";else if(range_type.equals("W")  && range_4_fr_unit.equals("")) range_4_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_4_to_unit.equals("")) range_4_to_unit="D";else if(range_type.equals("W") && range_4_to_unit.equals("")) range_4_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_5_fr_unit.equals("")) range_5_fr_unit="D";else if(range_type.equals("W")  && range_5_fr_unit.equals("")) range_5_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_5_to_unit.equals("")) range_5_to_unit="D";else if(range_type.equals("W") && range_5_to_unit.equals("")) range_5_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_6_fr_unit.equals("")) range_6_fr_unit="D";else if(range_type.equals("W")  && range_6_fr_unit.equals("")) range_6_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_6_to_unit.equals("")) range_6_to_unit="D";else if(range_type.equals("W") && range_6_to_unit.equals("")) range_6_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_7_fr_unit.equals("")) range_7_fr_unit="D";else if(range_type.equals("W")  && range_7_fr_unit.equals("")) range_7_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_7_to_unit.equals("")) range_7_to_unit="D";else if(range_type.equals("W") && range_7_to_unit.equals("")) range_7_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_8_fr_unit.equals("")) range_8_fr_unit="D";else if(range_type.equals("W")  && range_8_fr_unit.equals("")) range_8_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_8_to_unit.equals("")) range_8_to_unit="D";else if(range_type.equals("W") && range_8_to_unit.equals("")) range_8_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_9_fr_unit.equals("")) range_9_fr_unit="D";else if(range_type.equals("W")  && range_9_fr_unit.equals("")) range_9_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_9_to_unit.equals("")) range_9_to_unit="D";else if(range_type.equals("W") && range_9_to_unit.equals("")) range_9_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_10_fr_unit.equals("")) range_10_fr_unit="D";else if(range_type.equals("W")  && range_10_fr_unit.equals("")) range_10_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_10_to_unit.equals("")) range_10_to_unit="D";else if(range_type.equals("W") && range_10_to_unit.equals("")) range_10_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_11_fr_unit.equals("")) range_11_fr_unit="D";else if(range_type.equals("W")  && range_11_fr_unit.equals("")) range_11_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_11_to_unit.equals("")) range_11_to_unit="D";else if(range_type.equals("W") && range_11_to_unit.equals("")) range_11_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_12_fr_unit.equals("")) range_12_fr_unit="D";else if(range_type.equals("W")  && range_12_fr_unit.equals("")) range_12_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_12_to_unit.equals("")) range_12_to_unit="D";else if(range_type.equals("W") && range_12_to_unit.equals("")) range_12_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_13_fr_unit.equals("")) range_13_fr_unit="D";else if(range_type.equals("W")  && range_13_fr_unit.equals("")) range_13_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_13_to_unit.equals("")) range_13_to_unit="D";else if(range_type.equals("W") && range_13_to_unit.equals("")) range_13_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_14_fr_unit.equals("")) range_14_fr_unit="D";else if(range_type.equals("W")  && range_14_fr_unit.equals("")) range_14_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_14_to_unit.equals("")) range_14_to_unit="D";else if(range_type.equals("W") && range_14_to_unit.equals("")) range_14_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_15_fr_unit.equals("")) range_15_fr_unit="D";else if(range_type.equals("W")  && range_15_fr_unit.equals("")) range_15_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_15_to_unit.equals("")) range_15_to_unit="D";else if(range_type.equals("W") && range_15_to_unit.equals("")) range_15_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_16_fr_unit.equals("")) range_16_fr_unit="D";else if(range_type.equals("W")  && range_16_fr_unit.equals("")) range_16_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_16_to_unit.equals("")) range_16_to_unit="D";else if(range_type.equals("W") && range_16_to_unit.equals("")) range_16_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_17_fr_unit.equals("")) range_17_fr_unit="D";else if(range_type.equals("W")  && range_17_fr_unit.equals("")) range_17_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_17_to_unit.equals("")) range_17_to_unit="D";else if(range_type.equals("W") && range_17_to_unit.equals("")) range_17_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_18_fr_unit.equals("")) range_18_fr_unit="D";else if(range_type.equals("W")  && range_18_fr_unit.equals("")) range_18_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_18_to_unit.equals("")) range_18_to_unit="D";else if(range_type.equals("W") && range_18_to_unit.equals("")) range_18_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_19_fr_unit.equals("")) range_19_fr_unit="D";else if(range_type.equals("W")  && range_19_fr_unit.equals("")) range_19_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_19_to_unit.equals("")) range_19_to_unit="D";else if(range_type.equals("W") && range_19_to_unit.equals("")) range_19_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_20_fr_unit.equals("")) range_20_fr_unit="D";else if(range_type.equals("W")  && range_20_fr_unit.equals("")) range_20_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_20_to_unit.equals("")) range_20_to_unit="D";else if(range_type.equals("W") && range_20_to_unit.equals("")) range_20_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_21_fr_unit.equals("")) range_21_fr_unit="D";else if(range_type.equals("W")  && range_21_fr_unit.equals("")) range_21_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_21_to_unit.equals("")) range_21_to_unit="D";else if(range_type.equals("W") && range_21_to_unit.equals("")) range_21_to_unit="K";


if(range_type.equals("A") || range_type.equals("") && range_22_fr_unit.equals("")) range_22_fr_unit="D";else if(range_type.equals("W")  && range_22_fr_unit.equals("")) range_22_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_22_to_unit.equals("")) range_22_to_unit="D";else if(range_type.equals("W") && range_22_to_unit.equals("")) range_22_to_unit="K";

if(range_type.equals("A") || range_type.equals("") && range_23_fr_unit.equals("")) range_23_fr_unit="D";else if(range_type.equals("W")  && range_23_fr_unit.equals("")) range_23_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_23_to_unit.equals("")) range_23_to_unit="D";else if(range_type.equals("W") && range_23_to_unit.equals("")) range_23_to_unit="K";


if(range_type.equals("A") || range_type.equals("") && range_24_fr_unit.equals("")) range_24_fr_unit="D";else if(range_type.equals("W")  && range_24_fr_unit.equals("")) range_24_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_24_to_unit.equals("")) range_24_to_unit="D";else if(range_type.equals("W") && range_24_to_unit.equals("")) range_24_to_unit="K";


if(range_type.equals("A") || range_type.equals("") && range_25_fr_unit.equals("")) range_25_fr_unit="D";else if(range_type.equals("W")  && range_25_fr_unit.equals("")) range_25_fr_unit="K";
if(range_type.equals("A") || range_type.equals("")  && range_25_to_unit.equals("")) range_25_to_unit="D";else if(range_type.equals("W") && range_25_to_unit.equals("")) range_25_to_unit="K";
}


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	String kgs=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Kgs.label","common_labels");
	String Lbs=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Lbs.label","common_labels");
	String days=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
	String weeks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");
	String months=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
	String Years=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block23Bytes, _wl_block23);
 } 
            _bw.write(_wl_block24Bytes, _wl_block24);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block25Bytes, _wl_block25);
 } 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(range_1_fr));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(range_1_fr_unit));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(range_1_to));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(range_1_to_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(range_2_fr));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(range_2_fr_unit));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(range_2_to));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(range_2_to_unit));
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block41Bytes, _wl_block41);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block42Bytes, _wl_block42);
 } 
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(range_3_fr));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(range_3_fr_unit));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(range_3_to));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(range_3_to_unit));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block51Bytes, _wl_block51);
 } else { 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(days));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(months));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block56Bytes, _wl_block56);
 } 
            _bw.write(_wl_block57Bytes, _wl_block57);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block60Bytes, _wl_block60);
 } else { 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(days));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(months));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block65Bytes, _wl_block65);
 } 
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(range_4_fr));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(range_4_fr_unit));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(range_4_to));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(range_4_to_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block73Bytes, _wl_block73);
 } else { 
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(days));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(months));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block78Bytes, _wl_block78);
 } 
            _bw.write(_wl_block79Bytes, _wl_block79);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block73Bytes, _wl_block73);
 } else { 
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(days));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(months));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block78Bytes, _wl_block78);
 } 
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(range_5_fr));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(range_5_fr_unit));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(range_5_to));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(range_5_to_unit));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block86Bytes, _wl_block86);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block88Bytes, _wl_block88);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(range_6_fr));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(range_6_fr_unit));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(range_6_to));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(range_6_to_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block94Bytes, _wl_block94);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(range_7_fr));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(range_7_fr_unit));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(range_7_to));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(range_7_to_unit));
            _bw.write(_wl_block99Bytes, _wl_block99);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block105Bytes, _wl_block105);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(range_8_fr));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(range_8_fr_unit));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(range_8_to));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(range_8_to_unit));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block111Bytes, _wl_block111);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block112Bytes, _wl_block112);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(range_9_fr));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(range_9_fr_unit));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(range_9_to));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(range_9_to_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block118Bytes, _wl_block118);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(range_10_fr));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(range_10_fr_unit));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(range_10_to));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(range_10_to_unit));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block51Bytes, _wl_block51);
 } else { 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(days));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(months));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block125Bytes, _wl_block125);
 } 
            _bw.write(_wl_block126Bytes, _wl_block126);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block60Bytes, _wl_block60);
 } else { 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(days));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(months));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block127Bytes, _wl_block127);
 } 
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(range_11_fr));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(range_11_fr_unit));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(range_11_to));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(range_11_to_unit));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block133Bytes, _wl_block133);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(range_12_fr));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(range_12_fr_unit));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(range_12_to));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(range_12_to_unit));
            _bw.write(_wl_block138Bytes, _wl_block138);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block139Bytes, _wl_block139);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block140Bytes, _wl_block140);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(range_13_fr));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(range_13_fr_unit));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(range_13_to));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(range_13_to_unit));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block146Bytes, _wl_block146);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(range_14_fr));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(range_14_fr_unit));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(range_14_to));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(range_14_to_unit));
            _bw.write(_wl_block151Bytes, _wl_block151);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block156Bytes, _wl_block156);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(range_15_fr));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(range_15_fr_unit));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(range_15_to));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(range_15_to_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block161Bytes, _wl_block161);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block162Bytes, _wl_block162);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(range_16_fr));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(range_16_fr_unit));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(range_16_to));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(range_16_to_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block167Bytes, _wl_block167);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block168Bytes, _wl_block168);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(range_17_fr));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(range_17_fr_unit));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(range_17_to));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(range_17_to_unit));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block173Bytes, _wl_block173);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block174Bytes, _wl_block174);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(range_18_fr));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(range_18_fr_unit));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(range_18_to));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(range_18_to_unit));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block180Bytes, _wl_block180);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(range_19_fr));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(range_19_fr_unit));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(range_19_to));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(range_19_to_unit));
            _bw.write(_wl_block185Bytes, _wl_block185);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block187Bytes, _wl_block187);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(range_20_fr));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(range_20_fr_unit));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(range_20_to));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(range_20_to_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block193Bytes, _wl_block193);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(range_21_fr));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(range_21_fr_unit));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(range_21_to));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(range_21_to_unit));
            _bw.write(_wl_block198Bytes, _wl_block198);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block199Bytes, _wl_block199);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block200Bytes, _wl_block200);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block201Bytes, _wl_block201);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(range_22_fr));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(range_22_fr_unit));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(range_22_to));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(range_22_to_unit));
            _bw.write(_wl_block206Bytes, _wl_block206);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block207Bytes, _wl_block207);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block208Bytes, _wl_block208);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(range_23_fr));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(range_23_fr_unit));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(range_23_to));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(range_23_to_unit));
            _bw.write(_wl_block110Bytes, _wl_block110);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block213Bytes, _wl_block213);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block214Bytes, _wl_block214);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } else { 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(days));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(months));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(range_24_fr));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(range_24_fr_unit));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(range_24_to));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(range_24_to_unit));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block220Bytes, _wl_block220);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block51Bytes, _wl_block51);
 } else { 
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(days));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(months));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block56Bytes, _wl_block56);
 } 
            _bw.write(_wl_block221Bytes, _wl_block221);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(kgs));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(Lbs));
            _bw.write(_wl_block60Bytes, _wl_block60);
 } else { 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(days));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(weeks));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(months));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(Years));
            _bw.write(_wl_block127Bytes, _wl_block127);
 } 
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(range_25_fr));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(range_25_fr_unit));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(range_25_to));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(range_25_to_unit));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(functionVal));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(functionVal));
            _bw.write(_wl_block228Bytes, _wl_block228);

	if(eff_status.equals("D"))
		{

            _bw.write(_wl_block229Bytes, _wl_block229);
		}


            _bw.write(_wl_block230Bytes, _wl_block230);

}
catch ( Exception e ){ 
//out.println(e);
e.printStackTrace();
}

finally{

	if ( stmt != null ) stmt.close() ;
	if ( pstmt != null ) pstmt.close() ;
	if ( rset != null ) rset.close() ;
	ConnectionManager.returnConnection(conn,request);

	}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.Ranges.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.Ranges.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.Ranges.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.Ranges.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.from.label", java.lang.String .class,"key"));
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
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.to.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
}
