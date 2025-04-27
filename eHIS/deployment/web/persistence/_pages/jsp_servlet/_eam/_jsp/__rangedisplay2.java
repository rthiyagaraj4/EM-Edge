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

public final class __rangedisplay2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/RangeDisplay2.jsp", 1710450574180L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eAM/js/AgeRange.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n<script>\n\nfunction test(num)\n\t{\n\t\tfor(var cnt=0;cnt<num;cnt++)\n\t\t{\n \t\t if(parent.frames[0].document.forms[0].no_of_ranges.value < num)\n \t\t {\n\t\t\tparent.frames[0].document.forms[0].no_of_ranges.select();\n\t\t\tparent.frames[0].document.forms[0].no_of_ranges.focus();\n\t\t }\n\t\t}\n\t}\n\nfunction checkNoDecimal(fld,event)\n{\n\t//alert(\"here\");\n\tvar retVal;\n\tif (parent.frames[0].document.forms[0].range_type.value ==\"A\")\n\t{\n\t\t//alert(\"a\");\n\t\tfld.maxLength=3;\n\t\tretVal=allowValidNumber(fld,event,3, 0);\n\t}\n\telse if (parent.frames[0].document.forms[0].range_type.value ==\"W\")\n\t{\n\t\t//alert(\"w\");\n\t\tfld.maxLength=6;\n \t\tretVal==allowValidNumber(fld, event, 2,3);\n\t}\n\treturn retVal;\n}\n\n\t\n\t\n\tfunction func()\n\t{\n\t\tif (agerange_form.range_type.value == \'A\')\n\t\t{\n\t\t\tif (agerange_form.no_of_ranges.value <1 || agerange_form.no_of_ranges.value >25)\n\t\t\t{\n\t\t\t\tif(agerange_form.no_of_ranges.value.length >0)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"NO_OF_AGE_RANGE\",\"AM\"));\n\t\t\t\t\tagerange_form.no_of_ranges.select();\n\t\t\t\t\tagerange_form.no_of_ranges.focus();\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse if (agerange_form.range_type.value == \'W\')\n\t\t{\n\t\t\tif (agerange_form.no_of_ranges.value <1 || agerange_form.no_of_ranges.value >5)\n\t\t\t{\n\t\t\t\tif(agerange_form.no_of_ranges.value.length >0)\n\t\t\t\t{\n\t\t\t\t\talert(getMessage(\"NO_OF_WEIGHT_RANGE\",\"AM\"));\n\t\t\t\t\tagerange_form.no_of_ranges.select();\n\t\t\t\t\tagerange_form.no_of_ranges.focus();\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\tvar arr1= new Array (\"document.agerange_form.range_1_fr\",\"document.agerange_form.range_1_to\", \t\t\t\t\t\t\"document.agerange_form.range_2_fr\",\"document.agerange_form.range_2_to\", \t\t\t\t\t\t\"document.agerange_form.range_3_fr\",\"document.agerange_form.range_3_to\",\n\t\t\t\t\t\t\t\"document.agerange_form.range_4_fr\",\"document.agerange_form.range_4_to\",\n\t\t\t\t\t\t\t\"document.agerange_form.range_5_fr\",\"document.agerange_form.range_5_to\",\n\t\t\t\t\t\t\t\"document.agerange_form.range_6_fr\",\"document.agerange_form.range_6_to\");\n\t\tvar noofrange = parseInt(agerange_form.no_of_ranges.value);\n\t\tfor(var k=noofrange*2; k< arr1.length;k++)\n\t\t{\n\t\t\teval(arr1[k]).value=\"\";\n\t\t}\n\t}\n\n\tfunction ChkOverLap(obj)\n\t{\n\t\tvar Fr_unit=\"\";\n\t\tvar To_unit=\"\";\n\n\t\t/*if(obj.name ==\"range_1_to_unit\" ||obj.name ==\"range_1_fr_unit\"||obj.name ==\"range_1_to\"||obj.name ==\"range_1_fr\" )\n\t\t\t{\n\t\t*/\n\t\t\tFr_unit=agerange_form.range_1_fr_unit.value;\n\t\t\tTo_unit=agerange_form.range_1_to_unit.value;\n\t\t/*\t}\n\t\telse if(obj.name ==\"range_2_to_unit\")\n\t\t{\n\t\t\tFr_unit=agerange_form.range_2_fr_unit.value;\n\t\t\tTo_unit=agerange_form.range_2_to_unit.value;\n\t\t}*/\n\n\t\tvar FrVal=0;\n\t\tvar ToVal=0;\n\n\t\t\tFrVal=agerange_form.range_1_fr.value;\n\t\t\tToVal=agerange_form.range_1_to.value;\n\n\t\t\tif(Fr_unit==\"D\" && To_unit==\"M\")\n\t\t\t{\n\t\t\t\tFrVal=agerange_form.range_1_fr.value;\n\t\t\t\tToVal=agerange_form.range_1_to.value*30;\n\t\t\t}\n\t\t\telse if(Fr_unit==\"M\" && To_unit==\"D\")\n\t\t\t{\n\n\t\t\t\tFrVal=agerange_form.range_1_fr.value*30;\n\t\t\t\tToVal=agerange_form.range_1_to.value;\n\t\t\t}\n\t\t\telse if(Fr_unit==\"M\" && To_unit==\"Y\")\n\t\t\t{\n\n\t\t\t\tFrVal=agerange_form.range_1_fr.value*30;\n\t\t\t\tToVal=agerange_form.range_1_to.value*365;\n\t\t\t}\n\t\t\telse if(Fr_unit==\"Y\" && To_unit==\"M\")\n\t\t\t{\n\n\t\t\t\tFrVal=agerange_form.range_1_fr.value*365;\n\t\t\t\tToVal=agerange_form.range_1_to.value*30;\n\t\t\t}\n\t\t\telse if(Fr_unit==\"D\" && To_unit==\"Y\")\n\t\t\t{\n\n\t\t\t\tFrVal=agerange_form.range_1_fr.value;\n\t\t\t\tToVal=agerange_form.range_1_to.value*365;\n\t\t\t}\n\t\t\telse if(Fr_unit==\"Y\" && To_unit==\"D\")\n\t\t\t{\n\n\t\t\t\tFrVal=agerange_form.range_1_fr.value*365;\n\t\t\t\tToVal=agerange_form.range_1_to.value;\n\t\t\t}\n\t\t\t\tvar nam=parseInt(FrVal,10);\n\t\t\t\tvar nam1=parseInt(ToVal,10);\n\n\t\t\tif(nam > nam1)\n\t\t\t\t\t\talert(\"Range OverLapping\");\n\t\t\t\t//obj.focus();\n\t}\n\nfunction tt(){\n\talert(\"Range \");\n}\n\n\nfunction ageWeightOption(Obj)\n{\n\t\n\t\n\n\tvar\tobjName =Obj.name;\n\tvar whichObj=\"document.agerange_form.\"+ objName;\n\t\n\t\n\tvar arr1= new Array (\"document.agerange_form.range_1_fr\",\"document.agerange_form.range_1_to\", \"document.agerange_form.range_2_fr\",\"document.agerange_form.range_2_to\", \"document.agerange_form.range_3_fr\",\"document.agerange_form.range_3_to\",\n\t\"document.agerange_form.range_4_fr\",\"document.agerange_form.range_4_to\",\n\t\"document.agerange_form.range_5_fr\",\"document.agerange_form.range_5_to\",\n\t\"document.agerange_form.range_6_fr\",\"document.agerange_form.range_6_to\");\n\n\tfor(var k=0; k< arr1.length;k++)\n\t{\n\n\t\teval(arr1[k]).value=\"\";\n\t\n\t}\n\n\t\n\tvar arr= new Array (\"document.agerange_form.range_1_fr_unit\",\"document.agerange_form.range_1_to_unit\", \"document.agerange_form.range_2_fr_unit\",\"document.agerange_form.range_2_to_unit\", \"document.agerange_form.range_3_fr_unit\",\"document.agerange_form.range_3_to_unit\",\n\t\"document.agerange_form.range_4_fr_unit\",\"document.agerange_form.range_4_to_unit\",\n\t\"document.agerange_form.range_5_fr_unit\",\"document.agerange_form.range_5_to_unit\",\n\t\"document.agerange_form.range_6_fr_unit\",\"document.agerange_form.range_6_to_unit\");\n\n\tfor(j =0; j < arr.length;j++)\n\t{\n\n\t\tvar len=eval(arr[j]).length;\n\n\t\t\n\t\tif(document.agerange_form.range_type.value ==\"W\")\n\t\t{\n\t\t\t\n\t\t\t\n\t\t\tfor(var i=0;i<len ;i++)\n\t\t\t{\n\t\t\t\t\n\t\t\t\teval(arr[j]).options[i]=null;\n\t\t\t}\n\n\t\t\teval(arr[j]).options[0] =new Option(\"Kgs\",\"K\");;\n\t\t\teval(arr[j]).options[1] =new Option(\"Lbs\",\"L\");\n\n\n\t\t}\n\n\t\tif(document.agerange_form.range_type.value ==\"A\")\n\t\t{\n\t\t\t\t\t\n\t\t\tfor(var i=0;i<len ;i++)\n\t\t\t{\n\t\t\t\teval(arr[j]).options[i]=null;\n\t\t\t}\n\t\t\teval(arr[j]).options[0] =new Option(\"Days\",\"D\");\n\t\t\teval(arr[j]).options[1] =new Option(\"Months\",\"M\");\n\t\t\teval(arr[j]).options[2] =new Option(\"Years\",\"Y\");\n\t\t}\n\t}\n\n}\n\n     \n\n      \t\n</script>\n\n</head>\n<body  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"agerange_form\" id=\"agerange_form\" action=\"../../servlet/eAM.AgeRangeServlet\" method=\"post\" target=\"messageFrame\">\n<center>\n\n\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" 23</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_23_fr\" id=\"range_23_fr\" size=\"6\" maxlength=\"6\" value=\"\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(23)\"  onBlur=\"CheckNum(this)\" ></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_23_fr_unit\" id=\"range_23_fr_unit\" onFocus=\"test(23)\" >\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<OPTION  VALUE=\"K\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</option>\n\t\t\t\t\t\t<OPTION VALUE=\"L\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<OPTION VALUE=\"D\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t<OPTION VALUE=\"W\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<OPTION VALUE=\"M\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<OPTION VALUE=\"Y\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t </select></td>\n\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_23_to\" id=\"range_23_to\" size=\"6\" maxlength=\"6\"  value=\"\" onFocus=\"test(23)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_23_to_unit\" id=\"range_23_to_unit\" onFocus=\"test(23)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t </select>\n\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n\n<script>\n\tdocument.getElementById(\'range_23_fr\').value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\tdocument.getElementById(\'range_23_fr_unit\').value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\tdocument.getElementById(\'range_23_to\').value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\";\n\tdocument.getElementById(\'range_23_to_unit\').value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n</script>\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" 24</td>\n\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_24_fr\" id=\"range_24_fr\" size=\"6\" maxlength=\"6\" onFocus=\"test(24)\" onKeyPress=\"return checkNoDecimal(this,event);\"  onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_24_fr_unit\" id=\"range_24_fr_unit\" onFocus=\"test(24)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t </select></td>\n\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\"><input type=\"text\" name=\"range_24_to\" id=\"range_24_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(24)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_24_to_unit\" id=\"range_24_to_unit\" onFocus=\"test(24)\">\n   \t    \t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t\t\t\t\t<OPTION VALUE=\"M\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t </select>\n\t\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n<script>\n\tdocument.getElementById(\'range_24_fr\').value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\tdocument.getElementById(\'range_24_fr_unit\').value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\tdocument.getElementById(\'range_24_to\').value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\tdocument.getElementById(\'range_24_to_unit\').value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n</script>\n\n\t   \t\t\t<tr>\n\t\t\t\t\t\t\t<td width=\"40%\"  class=\"label\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" 25</td>\n\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;&nbsp; <input type=\"text\" name=\"range_25_fr\" id=\"range_25_fr\" size=\"6\" maxlength=\"6\" onKeyPress=\"return checkNoDecimal(this,event);\" onFocus=\"test(25)\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_25_fr_unit\" id=\"range_25_fr_unit\" onFocus=\"test(25)\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t<OPTION  VALUE=\"K\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</option>\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"L\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</option>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"D\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"W\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"M\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"Y\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t </select>\n\t\t\t\t\t\t\t\t\t </td>\n\n\t\t\t\t\t\t\t\t<td class=\"fields\"><input type=\"text\" name=\"range_25_to\" id=\"range_25_to\" size=\"6\" maxlength=\"6\" onFocus=\"test(25)\" onKeyPress=\"return checkNoDecimal(this,event);\" onBlur=\"CheckNum(this)\"></td>\n\t\t\t\t\t\t\t\t<td width=\"15%\"  class=\"fields\">&nbsp;<select name=\"range_25_to_unit\" id=\"range_25_to_unit\" onFocus=\"test(25)\">\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION  VALUE=\"K\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</option>\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"L\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"D\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"W\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"M\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t\t<OPTION VALUE=\"Y\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t </select>\n\t\t\t\t\t\t\t\t\t </td>\n\n\t   \t    \t</tr>\n\t\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n<script>\n\tdocument.getElementById(\'range_25_fr\').value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\tdocument.getElementById(\'range_25_fr_unit\').value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\n\tdocument.getElementById(\'range_25_to\').value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\tdocument.getElementById(\"range_25_to_unit\").value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n</script>\n\n\t<input type=\"hidden\" name=\"function\" id=\"function\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type=\"hidden\" name=\"eff_date_from\" id=\"eff_date_from\" >\n<input type=\"hidden\" name=\"eff_date_to\" id=\"eff_date_to\" >\n<input type=\'hidden\' name=\'function_name\' id=\'function_name\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<input type=\'hidden\' name=\'range_type\' id=\'range_type\' value=\'\'>\n<input type=\'hidden\' name=\'range_id\' id=\'range_id\' value=\'\'>\n<input type=\'hidden\' name=\'long_desc\' id=\'long_desc\' value=\'\'>\n<input type=\'hidden\' name=\'short_desc\' id=\'short_desc\' value=\'\'>\n<input type=\'hidden\' name=\'no_of_ranges\' id=\'no_of_ranges\' value=\'\'>\n<input type=\'hidden\' name= \'eff_status\' value=\'\'>\n\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\n\t<script>\n\tfor(var i=0;i<document.forms[0].elements.length;i++)\n\t\t\tdocument.forms[0].elements[i].disabled=true;\n\t</script>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n</form>\n</center>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

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
	
	String sql="select * from am_summ_range where range_id='"+range_id+"' and range_type='"+range_type+"'";
	stmt = conn.createStatement();
	rset = stmt.executeQuery(sql);
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
 if(range_type.equals("W")) { 
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 } else { 
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
 } 
            _bw.write(_wl_block17Bytes, _wl_block17);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 } else { 
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
 } 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(range_23_fr));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(range_23_fr_unit));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(range_23_to));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(range_23_to_unit));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 } else { 
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
 } 
            _bw.write(_wl_block24Bytes, _wl_block24);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 } else { 
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
 } 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(range_24_fr));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(range_24_fr_unit));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(range_24_to));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(range_24_to_unit));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
 } else { 
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
 } 
            _bw.write(_wl_block40Bytes, _wl_block40);
 if(range_type.equals("W")) { 
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
 } else { 
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
 } 
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(range_25_fr));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(range_25_fr_unit));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(range_25_to));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(range_25_to_unit));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(functionVal));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(functionVal));
            _bw.write(_wl_block55Bytes, _wl_block55);

	if(eff_status.equals("D"))
		{

            _bw.write(_wl_block56Bytes, _wl_block56);
		}


            _bw.write(_wl_block57Bytes, _wl_block57);

}
catch ( Exception e ){ out.println(e);}

finally{

	if ( stmt != null ) stmt.close() ;
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Kgs.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Lbs.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Years.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Kgs.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Lbs.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Years.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Kgs.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Lbs.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Years.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Kgs.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Lbs.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Years.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Kgs.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Lbs.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Years.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Kgs.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Lbs.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.months.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Years.label", java.lang.String .class,"key"));
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
}
