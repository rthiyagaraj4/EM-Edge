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

public final class __agerangemodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/AgeRangeModify.jsp", 1709113974445L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n<script language=\'javascript\'>\n\nfunction checkNoDecimal(fld,event)\n{\n\t//alert(\"here\");\n\tvar retVal;\n\t//alert(\"Range Type::\"+document.agerange_form.range_type.value);\n\tif (document.agerange_form.range_type.value ==\"Age\")\n\t{\n\t\t\tfld.maxLength=3;\n\t\t\tretVal=allowValidNumber(fld,event,3, 0);\n\t}\n\telse if (document.agerange_form.range_type.value ==\"Weight\")\n\t{\n\t\tfld.maxLength=6;\n \t\tretVal==allowValidNumber(fld, event, 3, 2);\n\t}\n\treturn retVal;\n}\n\n\n\n\nfunction test(num)\n\t{\n\n\t\t\n\n\t\tfor(var cnt=0;cnt<num;cnt++)\n\t\t{\n \t\t if(agerange_form.no_of_ranges.value < num)\n \t\t {\n\t\t\tagerange_form.no_of_ranges.select();\n\t\t\tagerange_form.no_of_ranges.focus();\n\t\t\t\n\t\t }\n\n\t\t}\n\n\n\t}\n\n\nfunction newTest()\n\t{\n\n\t\t\n\t\tvar rangeVal=agerange_form.no_of_ranges.value;\n\t\tvar cnt;\n\t\tif(rangeVal != \"\")\n\t\t cnt = parseInt(rangeVal)+1;\n\t\tfor(cnt;cnt<= 6;cnt++)\n\t\t{\n\t\t\tvar strFrom=\"agerange_form.range_\"+cnt+\"_fr_unit\";\n\t\t\tvar strTextFrom=\"agerange_form.range_\"+cnt+\"_fr\";\n\t\t\tvar strTo=\"agerange_form.range_\"+cnt+\"_to_unit\";\n\t\t\tvar strTextTo=\"agerange_form.range_\"+cnt+\"_to\";\n\n\n\t\t\teval(strTextFrom).value=\"\";\n\t\t\teval(strTextTo).value=\"\";\n\t\t\teval(strFrom).options[0].selected=true;\n\t\t\teval(strTo).options[0].selected=true;\n\t\t\n\t\t\t/*if(eval(strFrom).value==\"L\")\n\t\t\t{\n\t\t\t\teval(strFrom).options[0].selected=true;\n\t\t\t}\n\t\t\tif(eval(strFrom).value==\"M\")\n\t\t\t{\n\t\t\t\teval(strFrom).options[0].selected=true;\n\t\t\t}\n\t\t\tif(eval(strFrom).value==\"Y\")\n\t\t\t{\n\t\t\t\teval(strFrom).options[0].selected=true;\n\t\t\t}\n\t\t\tif(eval(strTo).value==\"L\")\n\t\t\t{\n\t\t\t\teval(strTo).options[0].selected=true;\n\t\t\t}\n\t\t\tif(eval(strTo).value==\"M\")\n\t\t\t{\n\t\t\t\teval(strTo).options[0].selected=true;\n\t\t\t}\n\t\t\tif(eval(strTo).value==\"Y\")\n\t\t\t{\n\t\t\t\teval(strTo).options[0].selected=true;\n\t\t\t}*/\n\n\n\n\n\t\t\t\n\t\t\t\n\t\t}\n\n\t\t\n\n\n\t}\n\n\n\n\nfunction func()\n\t{\n\t\t\n\n\t\tif (agerange_form.no_of_ranges.value <1 || agerange_form.no_of_ranges.value >6)\n\t\t{\n\t\t\tif(agerange_form.no_of_ranges.value.length >0)\n\t\t\t{\n\t\t\t\talert(\"Invalid Entry\");\n\t\t\t\tagerange_form.no_of_ranges.select();\n\t\t\t\tagerange_form.no_of_ranges.focus();\n\t\t\t}\n\t\t}\n\t}\n\nfunction ageWeightOption(Obj)\n{\n\t\n\t\n\n\tvar\tobjName =Obj.name;\n\tvar whichObj=\"document.agerange_form.\"+ objName;\n\t\n\tvar arr1= new Array (\"document.agerange_form.range_1_fr\",\"document.agerange_form.range_1_to\", \"document.agerange_form.range_2_fr\",\"document.agerange_form.range_2_to\", \"document.agerange_form.range_3_fr\",\"document.agerange_form.range_3_to\",\n\t\"document.agerange_form.range_4_fr\",\"document.agerange_form.range_4_to\",\n\t\"document.agerange_form.range_5_fr\",\"document.agerange_form.range_5_to\",\n\t\"document.agerange_form.range_6_fr\",\"document.agerange_form.range_6_to\");\n\n\tfor(var k=0; k< arr1.length;k++)\n\t\teval(arr1[k]).value=\"\";\n\n\tvar arr= new Array (\"document.agerange_form.range_1_fr_unit\",\"document.agerange_form.range_1_to_unit\", \"document.agerange_form.range_2_fr_unit\",\"document.agerange_form.range_2_to_unit\", \"document.agerange_form.range_3_fr_unit\",\"document.agerange_form.range_3_to_unit\",\n\t\"document.agerange_form.range_4_fr_unit\",\"document.agerange_form.range_4_to_unit\",\n\t\"document.agerange_form.range_5_fr_unit\",\"document.agerange_form.range_5_to_unit\",\n\t\"document.agerange_form.range_6_fr_unit\",\"document.agerange_form.range_6_to_unit\");\n\n\tfor(j =0; j< arr.length;j++)\n\t{\n\n\t\tvar len=eval(arr[j]).length;\n\t\t\n\t\tif(document.agerange_form.range_type.value ==\"W\")\n\t\t{\n\t\t\t\n\t\t\t\n\t\t\tfor(var i=0;i<len ;i++)\n\t\t\t{\n\t\t\t\t\n\t\t\t\teval(arr[j]).options[i]=null;\n\t\t\t}\n\t\t\t//eval(arr[j]).value=\"K\";\n\t\t\t//eval(arr[j]).options[0].selected=true;\n\t\t\teval(arr[j]).options[0] =new Option(\"Kgs\",\"K\");;\n\t\t\teval(arr[j]).options[1] =new Option(\"Lbs\",\"L\");\n\n\n\t\t}\n\n\t\tif(document.agerange_form.range_type.value ==\"A\")\n\t\t{\n\t\t\t\t\t\n\t\t\tfor(var i=0;i<len ;i++)\n\t\t\t{\n\t\t\t\teval(arr[j]).options[i]=null;\n\t\t\t}\n\t\t\t//eval(arr[j]).value=\"D\";\n\t\t\t//eval(arr[j]).options[0].selected=true;\n\t\t\teval(arr[j]).options[0] =new Option(\"Days\",\"D\");\n\t\t\teval(arr[j]).options[1] =new Option(\"Months\",\"M\");\n\t\t\teval(arr[j]).options[2] =new Option(\"Years\",\"Y\");\n\t\t}\n\t}\n\n}\n\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<BR>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"85%\">\n\n\t\t\t<tr><td>&nbsp;</td></tr>\n\n  <tr>\n\t<td class=\"BORDER\" width=\"100%\">\n\t <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t   \t<td class=\"label\" width=\"40%\"><fmt:message key=\"Common.type.label\" bundle=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"/></td>\n\t\t   <!-- \t<td align=\"left\" width=\"60%\" colspan=\"3\">&nbsp;&nbsp;&nbsp;<select name=\"range_type\" id=\"range_type\" onChange=\"ageWeightOption(this)\"> -->\n\n\n\t\t\t\n\t\t\t\t<td align=\"left\" width=\"60%\" colspan=\"3\">&nbsp;&nbsp;\n\n\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n\t\t\t<!-- \t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img> -->\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td width=\"40%\" class=\"label\"><fmt:message key=\"Common.identification.label\" bundle=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"/></td>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t</tr>\n\t\t<tr>\n\t\t\t <td width=\"40%\" class=\"label\"><fmt:message key=\"Common.longdescription.label\" bundle=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/></td>\n\t\t\t ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t</tr>\n\t\t<tr>\n\t\t\t <td width=\"40%\" class=\"label\"><fmt:message key=\"Common.shortdescription.label\" bundle=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</tr>\n\n\t\t<!--<tr>\n\t\t\t <td width=\"40%\" class=\"label\" >Effective From</td>\n\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t\t\t <td width=\"5%\" align=\"left\" class=\"label\">&nbsp;&nbsp;To&nbsp;&nbsp;</td>\n\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\n\t\t</tr>-->\n\t\t<tr>\n\t\t\t <td width=\"40%\" class=\"label\"><fmt:message key=\"Common.enabled.label\" bundle=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/></td>\n\t\t\t  <td width=\"60%\" class=\'fields\' class=\"label\" colspan=\"3\">&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"eff_status\" id=\"eff_status\" value=\"E\"\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</tr>\n\t\t<tr>\n\t\t\t <td width=\"40%\" class=\"label\"><fmt:message key=\"eAM.NoofRanges.label\" bundle=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/></td>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t</tr>\n\n\t\t\t<tr><td>&nbsp;</td><td>&nbsp;</td></tr>\n\n\t    </table>\n\t</td>\n    </tr>\n</table>\n\n\n\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"85%\">\n\n\t\t\t\n\t\t\t<th align=\'LEFT\'><fmt:message key=\"eAM.Ranges.label\" bundle=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/></th>\n\n<tr>\n  <td class=\"BORDER\" width=\"100%\">\n\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t<tr>\n\t\t\t\t\t<td width=\"40%\" align=\"right\" class=\"label\">&nbsp;</td>\n\t\t\t\t\t<td width=\"15%\" align=\"left\" class=\"label\">&nbsp;&nbsp;&nbsp;<fmt:message key=\"Common.from.label\" bundle=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/></td>\n\t\t\t\t\t<td width=\"15%\" align=\"left\" class=\"label\">&nbsp;<fmt:message key=\"Common.Unit.label\" bundle=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/></td>\n\t\t\t\t\t<td width=\"15%\" align=\"left\" class=\"label\">&nbsp;<fmt:message key=\"Common.to.label\" bundle=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"/> </td>\t\n\t\t\t\t\t<td width=\"15%\" align=\"left\" class=\"label\">&nbsp;<fmt:message key=\"Common.Unit.label\" bundle=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"/></td>\n\t\t\t\t</tr>\t\n\n\t\t<tr>\n\t\t\t<td width=\"40%\" class=\"label\">Range 1</td>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t</td>\n\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\"40%\" class=\"label\">Range 2</td>\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\"40%\" class=\"label\">Range 3</td>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</td>\n\t\t</tr>\n\n\n\t\t<tr>\n\t\t\t<td width=\"40%\" class=\"label\">Range 4</td>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t \n\t\t\t</td>\n\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td width=\"40%\" class=\"label\">Range 5</td>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t</td>\n\n\t\t</tr>\n\n\n\n\n\t\t<tr>\n\t\t\t<td width=\"40%\" class=\"label\">Range 6</td>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t</td>\n\n\t\t</tr>\n\n\t\t\t<tr><td>&nbsp;</td><td>&nbsp;</td></tr>\n\n\t</table>\n    </td>\n  </tr>\n</table>\n\n\n\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="      <BR>\n\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"85%\">\n\t  <tr>\n\t\t<td class=\"BORDER\" width=\"100%\">\n\t\t <table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t   \t<td class=\"label\" width=\"40%\"><fmt:message key=\"Common.type.label\" bundle=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"/></td>\n\t\t\t   \t<td class=\'fields\' width=\"60%\" colspan=\"3\">&nbsp;&nbsp;\n\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\n\t\t\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=\"40%\" class=\"label\"><fmt:message key=\"Common.identification.label\" bundle=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"/></td>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t <td width=\"40%\" class=\"label\">Long Desc</td>\n\t\t\t\t ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t <td width=\"40%\" class=\"label\">Short Desc</td>\n\t\t\t\t ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t</tr>\n\n\t\t\t<!-- <tr>\n\t\t\t\t <td width=\"40%\" align=\"right\" class=\"label\" >Effective From</td>\n\n\t\t\t<-%\n\t\t\t\tout.println(\"<td width=\'15%\' align=\'left\'> &nbsp;&nbsp;&nbsp;<input type=\'text\' name=\'eff_date_from1\' id=\'eff_date_from1\' size=\'10\'   onblur=\'CheckDate(this)\' maxlength=\'10\' value=\'\");\n\t\t\t \tif ( rset.getDate(\"eff_date_from\") != null )\n\t\t\t\t{\n\t\t\t\t java.util.Date date = rset.getDate(\"eff_date_from\");\n\t\t\t\t SimpleDateFormat formatter = new SimpleDateFormat (\"dd/MM/yyyy\");\n\t\t\t\t String dateString = formatter.format(date);\n\t\t\t\t out.println(dateString);\n\t\t\t\t date = null;\n\t\t\t\t formatter = null;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t out.println(\"\");\n\t\t\t\t out.println(\"\' readonly> </td>\");\n\t\t\t%->\n\n\t\t\t\t <td width=\"5%\" align=\"left\" class=\"label\">&nbsp;To&nbsp;&nbsp;</td>\n\n\t\t\t<-%\n\t\t\t\tout.println(\"<td width=\'40%\' align=\'left\'><input type=\'text\' name=\'eff_date_to1\' id=\'eff_date_to1\' size=\'10\'  onblur=\'CheckDate(this)\' maxlength=\'10\' value=\'\");\n\n\t\t\t\tif ( rset.getDate(\"eff_date_to\") != null)\n\t\t\t\t{\n\t\t\t\t java.util.Date date1 = rset.getDate(\"eff_date_to\");\n\t\t\t\t SimpleDateFormat formatter = new SimpleDateFormat (\"dd/MM/yyyy\");\n\t\t\t\t String dateString = formatter.format(date1);\n\t\t\t\t out.println(dateString);\n\t\t\t\t date1 = null;\n\t\t\t\t formatter = null;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t out.println(\"\");\n\n\t\t\t \t out.println(\"\'readonly> </td>\");\n\n\t\t\t%->\n\n\n\t\t\t</tr> -->\n\t\t\t<tr>\n\t\t\t\t <td width=\"40%\" class=\"label\"><fmt:message key=\"Common.enabled.label\" bundle=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"/></td>\n\t\t\t\t  <td width=\"60%\" class=\'fields\' colspan=\"3\">&nbsp;&nbsp;&nbsp;<input type=\"checkbox\" name=\"eff_status\" id=\"eff_status\" value=\"E\"\n\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t <td width=\"40%\" class=\"label\"><fmt:message key=\"eAM.NoofRanges.label\" bundle=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t</tr>\n<TR><td>&nbsp</td><td>&nbsp;</td></tr>\n\t\t    </table>\n\t\t</td>\n\t    </tr>\n\t</table>\n\n\t\n\n\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"85%\">\n\t<th align=\'LEFT\'><fmt:message key=\"eAM.Ranges.label\" bundle=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"/></th>\n\t<tr>\n\t  <td class=\"BORDER\" width=\"100%\">\n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\t\t\t<tr>\n\t\t\t\t\t<td width=\"40%\" align=\"right\" class=\"label\">&nbsp;</td>\n\t\t\t\t\t<td width=\"15%\" align=\"left\" class=\"label\">&nbsp;&nbsp;&nbsp;<fmt:message key=\"Common.from.label\" bundle=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"/></td>\n\t\t\t\t\t<td width=\"15%\" align=\"left\" class=\"label\">&nbsp;&nbsp;<fmt:message key=\"Common.to.label\" bundle=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"/></td>\n\t\t\t\t</tr>\t\n\n\t\t<tr>\n\n\t\t\t<tr>\n\t\t\t\t<td width=\"40%\" class=\"label\">Range 1</td>\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t</td>\n\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td width=\"40%\" class=\"label\">Range 2</td>\n\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td width=\"40%\" class=\"label\">Range 3</td>\n\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\n\n\t\t\t<tr>\n\t\t\t\t<td width=\"40%\" class=\"label\">Range 4</td>\n\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t</td>\n\n\t\t\t</tr>\n\n\t\t\t<tr>\n\t\t\t\t<td width=\"40%\" class=\"label\">Range 5</td>\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t</td>\n\n\t\t\t</tr>\n\n\n\n\n\t\t\t<tr>\n\t\t\t\t<td width=\"40%\" class=\"label\">Range 6</td>\n\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t</td>\n\n\t\t\t</tr>\n\t\t\t<tr><td>&nbsp;</td><td>&nbsp;</td></tr>\t\n\t\t</table>\n\t    </td>\n\t  </tr>\n\t</table>\n\n\n\n\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
// String facility_id = request.getParameter("facility_id");
   String range_type = request.getParameter("range_type");
   String range_id=request.getParameter("range_id");
   String str="";
Connection conn = null;
Statement stmt=null;
ResultSet rset=null;

try{
out.println("<html><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/common.js' language='javascript'></script>");



            _bw.write(_wl_block3Bytes, _wl_block3);


out.println("</head><body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >");
conn = ConnectionManager.getConnection(request);
//Connection conn = (Connection) session.getValue( "connection" );
stmt = conn.createStatement();

String sql="select * from am_summ_range where range_id='"+range_id+"' and range_type='"+range_type+"'";
rset = stmt.executeQuery(sql);
rset.next();


out.println(" <form name='agerange_form' id='agerange_form' action='../../servlet/eAM.AgeRangeServlet' method='post' target='messageFrame'><center> <br><br>");


if ( rset.getString("eff_status").equals("E") )
{

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);

				   if (rset.getString("range_type").equals("A"))
				   {
			           	out.println("<input type='text' name='range_type' id='range_type' value='Age' size='13'   maxlength='13' readonly> ");

		   		   }
				   if (rset.getString("range_type").equals("W"))
				   {
				  		out.println("<input type='text' name='range_type' id='range_type' value='Weight' size='13' maxlength='13'  readonly>");

				   }
			   /* 
				if (rset.getString("range_type").equals("A"))
			   {
		           	out.println( "<OPTION selected VALUE="+"A"+">Age" );
		           	out.println( "<OPTION VALUE="+"W"+">Weight" );
				/*out.println( "<OPTION VALUE="+"C"+">Circumference" );
				out.println( "<OPTION VALUE="+"L"+">Length" );
				out.println( "<OPTION VALUE="+"G"+">Gestation" );
				out.println( "<OPTION VALUE="+"P"+">Apgar" );

	   		   }
			  if (rset.getString("range_type").equals("W"))
			   {
			       	out.println( "<OPTION selected VALUE="+"W"+">Weight" );
			       	out.println( "<OPTION VALUE="+"A"+">Age" );
				out.println( "<OPTION VALUE="+"C"+">Circumference" );
				out.println( "<OPTION VALUE="+"L"+">Length" );
				out.println( "<OPTION VALUE="+"G"+">Gestation" );
				out.println( "<OPTION VALUE="+"P"+">Apgar" );

			   }
			   if (rset.getString("range_type").equals("C"))
			   {
			      	out.println( "<OPTION selected VALUE="+"C"+">Circumference" );
			      	out.println( "<OPTION VALUE="+"W"+">Weight" );
				out.println( "<OPTION VALUE="+"A"+">Age" );
				out.println( "<OPTION VALUE="+"L"+">Length" );
				out.println( "<OPTION VALUE="+"G"+">Gestation" );
				out.println( "<OPTION VALUE="+"P"+">Apgar" );
	   		   }
			   if (rset.getString("range_type").equals("L"))
			   {
			      	out.println( "<OPTION selected VALUE="+"L"+">Length" );
			      	out.println( "<OPTION VALUE="+"W"+">Weight" );
				out.println( "<OPTION VALUE="+"A"+">Age" );
				out.println( "<OPTION VALUE="+"C"+">Circumference" );
				out.println( "<OPTION VALUE="+"G"+">Gestation" );
				out.println( "<OPTION VALUE="+"P"+">Apgar" );
	   		   }
			 if (rset.getString("range_type").equals("G"))
			   {
			      	out.println( "<OPTION selected VALUE="+"G"+">Gestation" );
			      	out.println( "<OPTION VALUE="+"L"+">Length" );
			      	out.println( "<OPTION VALUE="+"W"+">Weight" );
				out.println( "<OPTION VALUE="+"A"+">Age" );
				out.println( "<OPTION VALUE="+"C"+">Circumference" );
				out.println( "<OPTION VALUE="+"P"+">Apgar" );
	   		   }
			 if (rset.getString("range_type").equals("P"))
			   {
			      	out.println( "<OPTION selected VALUE="+"P"+">Apgar" );
			      	out.println( "<OPTION VALUE="+"L"+">Length" );
			      	out.println( "<OPTION VALUE="+"W"+">Weight" );
				out.println( "<OPTION VALUE="+"A"+">Age" );
				out.println( "<OPTION VALUE="+"C"+">Circumference" );
				out.println( "<OPTION VALUE="+"G"+">Gestation" );

	   		   }
			   */
		    
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);

			out.println("<td width='60%' class='fields' colspan='3'>&nbsp;&nbsp;&nbsp;<input type='text' name='range_id' id='range_id' readonly size='4' value='"+rset.getString("range_id")+ "' maxlength='4'>");
			out.println("<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>");
			
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);

			 out.println("<td width='60%' class='fields' colspan='3'>&nbsp;&nbsp; <input type='text' name='long_desc' id='long_desc' size='30' onBlur='makeValidString(this)' value=\"" +rset.getString("long_desc")+ "\" maxlength='30'>");
			 out.println("<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>");
			 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);

			 out.println("<td width='60%' class='fields' colspan='3'>&nbsp;&nbsp; <input type='text' name='short_desc' id='short_desc' size='15' onBlur='makeValidString(this)' value=\"" +rset.getString("short_desc")+ "\" maxlength='15'>");
			 out.println("<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>");
			 
            _bw.write(_wl_block11Bytes, _wl_block11);

			out.println("<td width='15%' align='left'> &nbsp;&nbsp;&nbsp;<input type='text' name='eff_date_from1' id='eff_date_from1' size='10'   onblur='CheckDate(this)' maxlength='10' value='");
		 	if ( rset.getDate("eff_date_from") != null )
			{
			 java.util.Date date = rset.getDate("eff_date_from");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			 String dateString = formatter.format(date);
			 out.println(dateString);
			 date = null;
			 formatter = null;
			}
			else
			 out.println("");
			 out.println("'> </td>");
		
            _bw.write(_wl_block12Bytes, _wl_block12);

			out.println("<td width='40%' align='left'><input type='text' name='eff_date_to1' id='eff_date_to1' size='10'  onblur='CheckDate(this)' maxlength='10' value='");

			if ( rset.getDate("eff_date_to") != null)
			{
			 java.util.Date date1 = rset.getDate("eff_date_to");
			 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
			 String dateString = formatter.format(date1);
			 out.println(dateString);
			 date1 = null;
			 formatter = null;
			}
			else
			 out.println("");

		 	 out.println("'> </td>");

		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);

			  String eff_status = rset.getString("eff_status");
			   if  ( eff_status.equals("E") )
			    	out.println("checked>");
			   else
			    	out.println(">");
   		  	  	out.println("</td>");
   		
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);

			 out.println("<td width='60%' class='fields' colspan='3'>&nbsp;&nbsp; <input type='text' name='no_of_ranges' id='no_of_ranges' size='1' maxlength='1'  value='"+rset.getString("no_of_ranges")+ "' onBlur='CheckNum(this);func();newTest()'>");
			 out.println("<img src='../../eCommon/images/mandatory.gif'align='center'></img></td>");
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);

				str="";
				if((rset.getString("range_1_fr")==null)||rset.getString("range_1_fr").equals("null"))
					str="";
				else
					str=rset.getString("range_1_fr");


				out.println("<td width='15%' class='fields'>&nbsp;&nbsp; <input type='text' name='range_1_fr' id='range_1_fr' size='6'  value='"+ str + "'maxlength='6'  onFocus='test(1)'  onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'></td>");
				out.println("<td width='15%' class='fields' >&nbsp;<select name='range_1_fr_unit' id='range_1_fr_unit'  onFocus='test(1)'  >");

				

				String strUnit ="";

				if((rset.getString("range_1_fr_unit")==null)||rset.getString("range_1_fr_unit").equals("null"))
					strUnit="";
				else
					strUnit=rset.getString("range_1_fr_unit");
				out.println("It's coming befor");
				if((strUnit != null) && !(strUnit.equals("")))
				{

					if(strUnit.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");
					out.println("</select>");
					}
					if(strUnit.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");
					out.println("</select>");
					}
					if(strUnit.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years");
					out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");
					out.println("</select>");
					}
					if(strUnit.equals("K"))
					{
					out.println("<OPTION selected VALUE="+"K"+">Kgs");
					out.println("<OPTION VALUE="+"L"+">Lbs");
					out.println("</select>");
					}
					if(strUnit.equals("L"))
					{
					out.println("<OPTION selected VALUE="+"L"+">Lbs");
					out.println("<OPTION VALUE="+"K"+">Kgs");
					out.println("</select>");
					}

				}


				//out.println("It's coming after");

				str="";
				if(rset.getString("range_1_to")==null)
					str="";
				else
					str=rset.getString("range_1_to");

				out.println("</td><td width='15%'class='fields' >&nbsp;<input type='text' name='range_1_to' id='range_1_to' size='6' value='"+ str +"' maxlength='6' onFocus='test(1)'  onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_1_to_unit' id='range_1_to_unit' onFocus='test(1)'  >");

				String strUnitTo1 ="";

				if(rset.getString("range_1_to_unit")==null)
					strUnitTo1="";
				else
					strUnitTo1=rset.getString("range_1_to_unit");


				if(strUnitTo1.equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitTo1.equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitTo1.equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if(strUnitTo1.equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitTo1.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}



			 
            _bw.write(_wl_block23Bytes, _wl_block23);



				if(rset.getString("range_2_fr")==null|| rset.getString("range_2_fr").equals("null"))
					str="";
				else
					str=rset.getString("range_2_fr");

				out.println("<td width='15%'class='fields' >&nbsp;&nbsp; <input type='text' name='range_2_fr' id='range_2_fr' size='6'  value='"+str + "'maxlength='6' onFocus='test(2)' onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'></td>");
				out.println("<td width='15%' class='fields' >&nbsp;<select name='range_2_fr_unit' id='range_2_fr_unit' onFocus='test(2)' >");

				String strUnitFrom2 ="";

				if(rset.getString("range_2_fr_unit")==null)
					strUnitFrom2="";
				else
					strUnitFrom2=rset.getString("range_2_fr_unit");
				out.println("strUnitFrom2::::"+strUnitFrom2);

				if(strUnitFrom2.equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitFrom2.equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitFrom2.equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if(strUnitFrom2.equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitFrom2.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}


				str="";
				if( rset.getString("range_2_to")==null || rset.getString("range_2_to").equals("null"))
					str="";
				else
					str=rset.getString("range_2_to");



				out.println("</td><td width='15%' class='fields' >&nbsp;<input type='text' name='range_2_to' id='range_2_to' size='6' value='"+ str + "' maxlength='6' onFocus='test(2)'  onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_2_to_unit' id='range_2_to_unit' onFocus='test(2)' >");

				String strUnitTo2 ="";

				if(rset.getString("range_2_to_unit")==null)
					strUnitTo2="";
				else
					strUnitTo2=rset.getString("range_2_to_unit");
				//out.println("strUnitFrom2::::"+strUnitFrom2);

				if((strUnitTo2).equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitTo2).equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitTo2).equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if((strUnitTo2).equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if((strUnitTo2).equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

			 
            _bw.write(_wl_block24Bytes, _wl_block24);

				str="";
				if(rset.getString("range_3_fr")==null|| rset.getString("range_3_fr").equals("null"))
					str="";
				else
					str=rset.getString("range_3_fr");
					
				String strUnitFrom3 ="";

				if(rset.getString("range_3_fr_unit")==null)
					strUnitFrom3="";
				else
					strUnitFrom3=rset.getString("range_3_fr_unit");

				out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_3_fr' id='range_3_fr' size='6' onKeyPress='return checkNoDecimal(this,event);' value='"+ str + "'maxlength='6'  onFocus='test(3)'  onBlur='CheckNum(this)'></td>");
				out.println("<td width='15%' class='fields'>&nbsp;<select name='range_3_fr_unit' id='range_3_fr_unit' onFocus='test(3)' >");

				if((strUnitFrom3).equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitFrom3).equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitFrom3).equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if((strUnitFrom3).equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if((strUnitFrom3).equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}
				str="";
				if(rset.getString("range_3_to")==null||rset.getString("range_3_to").equals("null"))
					str="";
				else
					str=rset.getString("range_3_to");

				String strUnitTo3 ="";

				if(rset.getString("range_3_to_unit")==null)
					strUnitTo3="";
				else
					strUnitTo3=rset.getString("range_3_to_unit");

				out.println("</td><td width='15%' class='fields' >&nbsp;<input type='text' name='range_3_to' id='range_3_to' size='6' value='"+str +"' maxlength='6'  onFocus='test(3)' onKeyPress='return checkNoDecimal(this,event);'  onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_3_to_unit' id='range_3_to_unit'  onFocus='test(3)' >");

				if((strUnitTo3).equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitTo3).equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitTo3).equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select></td>");
				}
				if((strUnitTo3).equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitTo3.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

			 
            _bw.write(_wl_block25Bytes, _wl_block25);

				str="";
				if(rset.getString("range_4_fr")==null||rset.getString("range_4_fr").equals("null"))
					str="";
				else
					str=rset.getString("range_4_fr");

				String strUnitFrom4 ="";

				if(rset.getString("range_4_fr_unit")==null)
					strUnitFrom4="";
				else
					strUnitFrom4=rset.getString("range_4_fr_unit");


				out.println("<td width='15%'class='fields' >&nbsp;&nbsp; <input type='text' name='range_4_fr' id='range_4_fr' size='6'  value='"+ str + "'maxlength='6'  onFocus='test(4)'  onBlur='CheckNum(this)' onKeyPress='return checkNoDecimal(this,event);'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_4_fr_unit' id='range_4_fr_unit'  onFocus='test(4)' >");

				if((strUnitFrom4).equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitFrom4).equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if((strUnitFrom4).equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if((strUnitFrom4).equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if((strUnitFrom4).equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

				str="";
				if(rset.getString("range_4_to")==null||rset.getString("range_4_to").equals("null"))
					str="";
				else
					str=rset.getString("range_4_to");
				



				out.println("</td><td width='15%' class='fields'>&nbsp;<input type='text' name='range_4_to' id='range_4_to' size='6' value='"+str+"' maxlength='6'  onFocus='test(4)' onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_4_to_unit' id='range_4_to_unit'  onFocus='test(4)' >");

				String strUnitTo4 ="";

				if(rset.getString("range_4_to_unit")==null)
					strUnitTo4="";
				else
					strUnitTo4=rset.getString("range_4_to_unit");


				if(strUnitTo4.equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitTo4.equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitTo4.equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("</select>");
				}
				if(strUnitTo4.equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitTo4.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

			 
            _bw.write(_wl_block26Bytes, _wl_block26);


				str="";
				if(rset.getString("range_5_fr")==null || rset.getString("range_5_fr").equals("null"))
					str="";
				else
					str=rset.getString("range_5_fr");



				out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_5_fr' id='range_5_fr' size='6'  value='"+str+ "'maxlength='6'  onFocus='test(5)'  onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_5_fr_unit' id='range_5_fr_unit'  onFocus='test(5)'>");

				String strUnitFrom5 ="";

				if(rset.getString("range_5_fr_unit")==null)
					strUnitFrom5="";
				else
					strUnitFrom5=rset.getString("range_5_fr_unit");



				if(strUnitFrom5.equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitFrom5.equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitFrom5.equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if(strUnitFrom5.equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitFrom5.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

				str="";
				if(rset.getString("range_5_to")==null || rset.getString("range_5_to").equals("null"))
					str="";
				else
					str=rset.getString("range_5_to");



				out.println("</td><td width='15%' class='fields' >&nbsp;<input type='text' name='range_5_to' id='range_5_to' size='6' value='"+ str +"' maxlength='6'  onFocus='test(5)' onKeyPress='return checkNoDecimal(this,event);'  onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_5_to_unit' id='range_5_to_unit'  onFocus='test(5)'>");

					String strUnitTo5 ="";

					if(rset.getString("range_5_to_unit")==null)
					strUnitTo5="";
					else
					strUnitTo5=rset.getString("range_5_to_unit");


				if(strUnitTo5.equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitTo5.equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitTo5.equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if(strUnitTo5.equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitTo5.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

			 
            _bw.write(_wl_block27Bytes, _wl_block27);


				str="";
				if(rset.getString("range_6_fr")==null|| rset.getString("range_6_fr").equals("null"))
					str="";
				else
					str=rset.getString("range_6_fr");


				out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_6_fr' id='range_6_fr' size='6'  value='"+ str + "'maxlength='6'  onFocus='test(6)'  onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields'>&nbsp;<select name='range_6_fr_unit' id='range_6_fr_unit'  onFocus='test(6)'>");

					String strUnitFrom6 ="";

					if(rset.getString("range_6_fr_unit")==null)
					strUnitFrom6="";
					else
					strUnitFrom6=rset.getString("range_6_fr_unit");
				
				out.println("str from 6"+strUnitFrom6);

				if(strUnitFrom6.equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitFrom6.equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(strUnitFrom6.equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if(strUnitFrom6.equals("K"))
				{

				out.println("Str from 6::"+strUnitFrom6);
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(strUnitFrom6.equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

				str="";
				if(rset.getString("range_6_to")==null||rset.getString("range_6_to").equals("null"))
					str="";
				else
					str=rset.getString("range_6_to");


				out.println("</td><td width='15%' class='fields' >&nbsp;<input type='text' name='range_6_to' id='range_6_to' size='6' value='"+ str +"' maxlength='6'  onFocus='test(6)'  onKeyPress='return checkNoDecimal(this,event);' onBlur='CheckNum(this)'>");
				out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_6_to_unit' id='range_6_to_unit'  onFocus='test(6)'>");

				if(rset.getString("range_6_to_unit").equals("D"))
				{
				out.println("<OPTION selected VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(rset.getString("range_6_to_unit").equals("M"))
				{
				out.println("<OPTION selected VALUE="+"M"+">Months");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"Y"+">Years");
				out.println("</select>");
				}
				if(rset.getString("range_6_to_unit").equals("Y"))
				{
				out.println("<OPTION selected VALUE="+"Y"+">Years");
				out.println("<OPTION VALUE="+"D"+">Days");
				out.println("<OPTION VALUE="+"M"+">Months");
				out.println("</select>");
				}
				if(rset.getString("range_6_to_unit").equals("K"))
				{
				out.println("<OPTION selected VALUE="+"K"+">Kgs");
				out.println("<OPTION VALUE="+"L"+">Lbs");
				out.println("</select>");
				}
				if(rset.getString("range_6_to_unit").equals("L"))
				{
				out.println("<OPTION selected VALUE="+"L"+">Lbs");
				out.println("<OPTION VALUE="+"K"+">Kgs");
				out.println("</select>");
				}

			 
            _bw.write(_wl_block28Bytes, _wl_block28);


	out.println("</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from'><input type='hidden' name='eff_date_to' id='eff_date_to'><input type='hidden' name='function_name' id='function_name' value='modify'></form>");

}


//CODE FOR DISABLED RECORDS


if ( rset.getString("eff_status").equals("D") )
{

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block30Bytes, _wl_block30);

				   if (rset.getString("range_type").equals("A"))
				   {
			           	out.println("<input type='text' name='range_type' id='range_type' value='Age' size='13'   maxlength='13' readonly> ");

		   		   }
				   if (rset.getString("range_type").equals("W"))
				   {
				  		out.println("<input type='text' name='range_type' id='range_type' value='Weight' size='13' maxlength='13'  readonly>");

				   }
				   if (rset.getString("range_type").equals("C"))
				   {
					out.println("<input type='text' name='range_type' id='range_type' value='Circumference' size='13' maxlength='13' readonly> ");
		   		   }
				   if (rset.getString("range_type").equals("L"))
				   {
					out.println("<input type='text' name='range_type' id='range_type' value='Length' size='13' maxlength='13' readonly> ");
		   		   }
				 if (rset.getString("range_type").equals("G"))
				   {
					out.println("<input type='text' name='range_type' id='range_type' value='Gestation' size='13' maxlength='13' readonly> ");
		   		   }
				 if (rset.getString("range_type").equals("P"))
				   {
					out.println("<input type='text' name='range_type' id='range_type' value='Apgar' size='13' maxlength='13' readonly> ");

		   		   }
			    
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block32Bytes, _wl_block32);

				out.println("<td width='60%' class='fields' colspan='3'>&nbsp;&nbsp;&nbsp;<input type='text' name='range_id' id='range_id' size='4' value='"+rset.getString("range_id")+ "' maxlength='4' readonly>");
				out.println("<img src='../../eCommon/images/mandatory.gif'></img></td>");
				
            _bw.write(_wl_block33Bytes, _wl_block33);

				 out.println("<td width='60%' class='fields' colspan='3'>&nbsp;&nbsp; <input type='text' name='long_desc' id='long_desc' size='30'  value= \"" +rset.getString("long_desc")+ "\" maxlength='30' readonly>");
				 out.println("<img src='../../eCommon/images/mandatory.gif'></img></td>");
				 
            _bw.write(_wl_block34Bytes, _wl_block34);

				 out.println("<td width='60%'class='fields' colspan='3'>&nbsp;&nbsp; <input type='text' name='short_desc' id='short_desc' size='15' value=\"" +rset.getString("short_desc")+ "\" maxlength='15' readonly>");
				 out.println("<img src='../../eCommon/images/mandatory.gif'></img></td>");
				 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block36Bytes, _wl_block36);

				  String eff_status = rset.getString("eff_status");
				   if  ( eff_status.equals("E") )
				    	out.println("checked>");
				   else
				    	out.println(">");
	   		  	  	out.println("</td>");
	   		
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);

				 out.println("<td width='60%'class='fields'colspan='3'>&nbsp;&nbsp; <input type='text' name='no_of_ranges' id='no_of_ranges' size='1' maxlength='1' readonly value='"+rset.getString("no_of_ranges")+ "' onBlur='func()'>");
				 out.println("<img src='../../eCommon/images/mandatory.gif'></img></td>");
			
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block41Bytes, _wl_block41);


					str="";
					if(rset.getString("range_1_fr")==null)
						str="";
					else
						str=rset.getString("range_1_fr");

					 String strUnitFrom1 ="";
					if(rset.getString("range_1_fr_unit")==null|| rset.getString("range_1_fr_unit").equals("null"))
							strUnitFrom1 ="";
						else
							strUnitFrom1=rset.getString("range_1_fr_unit");


					out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_1_fr' id='range_1_fr' size='6'  value='"+ str +
					"' maxlength='6'  readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_1_fr_unit' id='range_1_fr_unit' >");

					if(strUnitFrom1.equals("D"))
					{

					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom1.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPT0ION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom1.equals("Y"))
					{

					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}

					if(strUnitFrom1.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitFrom1.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}





					str="";
					if(rset.getString("range_1_to")==null|| rset.getString("range_1_to").equals("null"))
							str="";
						else
							str=rset.getString("range_1_to");

					//out.println("str is "+str);

					out.println("</td><td width='15%' class='fields'>&nbsp;&nbsp;<input type='text' name='range_1_to' id='range_1_to' size='6' value='"+str +"' maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_1_to_unit' id='range_1_to_unit'>");
					String strUnitTo1 ="";

					if(rset.getString("range_1_to_unit")==null)
					strUnitTo1="";
					else
					strUnitTo1=rset.getString("range_1_to_unit");

					if(strUnitTo1.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitTo1.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitTo1.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(strUnitTo1.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitTo1.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}



				 
            _bw.write(_wl_block42Bytes, _wl_block42);


					str="";
					if(rset.getString("range_2_fr")==null||rset.getString("range_2_fr").equals("null"))
						str="";
					else
						str=rset.getString("range_2_fr");
							out.println("</td><td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_2_fr' id='range_2_fr' size='6'  value='"+ str + "' maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_2_fr_unit' id='range_2_fr_unit' >");

					String strUnitFrom2 ="";

					if(rset.getString("range_2_fr_unit")==null)
					strUnitFrom2="";
					else
					strUnitFrom2=rset.getString("range_2_fr_unit");


					if(strUnitFrom2.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom2.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom2.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(strUnitFrom2.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitFrom2.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




					str="";
					if(rset.getString("range_2_to")==null||rset.getString("range_2_to").equals("null"))
						str="";
					else
						str=rset.getString("range_2_to");


					out.println("</td><td width='15%' class='fields' >&nbsp;&nbsp;<input type='text' name='range_2_to' id='range_2_to' size='6' value='"+str+ "' maxlength='6' readonly>");
					out.println("</td><td width='15%'class='fields'>&nbsp;<select name='range_2_to_unit' id='range_2_to_unit'>");
					String strUnitTo2 ="";

					if(rset.getString("range_2_to_unit")==null)
					strUnitTo2="";
					else
					strUnitTo2=rset.getString("range_2_to_unit");

					if((strUnitTo2).equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitTo2).equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitTo2).equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if((strUnitTo2).equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if((strUnitTo2).equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}



				 
            _bw.write(_wl_block43Bytes, _wl_block43);


					str="";
					if(rset.getString("range_3_fr")==null||rset.getString("range_3_fr").equals("null"))
						str="";
					else
						str=rset.getString("range_3_fr");


					out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_3_fr' id='range_3_fr' size='6'  value='"+str + "'maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_3_fr_unit' id='range_3_fr_unit' >");

					String strUnitFrom3 ="";

					if(rset.getString("range_3_fr_unit")==null)
					strUnitFrom3="";
					else
					strUnitFrom3=rset.getString("range_3_fr_unit");

					if((strUnitFrom3).equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitFrom3).equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitFrom3).equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if((strUnitFrom3).equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if((strUnitFrom3).equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}



					str="";
					if(rset.getString("range_3_to")==null||rset.getString("range_3_to").equals("null"))
						str="";
					else
						str=rset.getString("range_3_to");



					out.println("</td><td width='15%' class='fields' >&nbsp;&nbsp;<input type='text' name='range_3_to' id='range_3_to' size='6' value='"+ str +"' maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_3_to_unit' id='range_3_to_unit'>");

					String strUnitTo3 ="";

					if(rset.getString("range_3_to_unit")==null)
					strUnitTo3="";
					else
					strUnitTo3=rset.getString("range_3_to_unit");

					if((strUnitTo3).equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitTo3).equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitTo3).equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if((strUnitTo3).equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if((strUnitTo3).equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




				 
            _bw.write(_wl_block44Bytes, _wl_block44);


					str="";
					if(rset.getString("range_4_fr")==null||rset.getString("range_4_fr").equals("null"))
						str="";
					else
						str=rset.getString("range_4_fr");

					out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_4_fr' id='range_4_fr' size='6'  value='"+str+ "'maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_4_fr_unit' id='range_4_fr_unit' >");

					String strUnitFrom4="";
					if(rset.getString("range_4_fr_unit")==null)
					strUnitFrom4="";
					else
					strUnitFrom4=rset.getString("range_4_fr_unit");


					if((strUnitFrom4).equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitFrom4).equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if((strUnitFrom4).equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if((strUnitFrom4).equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if((strUnitFrom4).equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




					str="";
					if(rset.getString("range_4_to")==null||rset.getString("range_4_to").equals("null"))
						str="";
					else
						str=rset.getString("range_4_to");

					String strUnitTo4 ="";

					if(rset.getString("range_4_to_unit")==null)
					strUnitTo4="";
					else
					strUnitTo4=rset.getString("range_4_to_unit");



					out.println("</td><td width='15%' class='fields' >&nbsp;&nbsp;<input type='text' name='range_4_to' id='range_4_to' size='6' value='"+ str+"' maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_4_to_unit' id='range_4_to_unit'>");

					if(strUnitTo4.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitTo4.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitTo4.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(strUnitTo4.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitTo4.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




				 
            _bw.write(_wl_block45Bytes, _wl_block45);


					str="";
					if(rset.getString("range_5_fr")==null||rset.getString("range_5_fr").equals("null"))
						str="";
					else
						str=rset.getString("range_5_fr");


					out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_5_fr' id='range_5_fr' size='6'  value='"+str+ "'maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_5_fr_unit' id='range_5_fr_unit' >");

					String strUnitFrom5 ="";

					if(rset.getString("range_5_fr_unit")==null)
					strUnitFrom5="";
					else
					strUnitFrom5=rset.getString("range_5_fr_unit");

					if(strUnitFrom5.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom5.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom5.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(strUnitFrom5.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitFrom5.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}





					str="";
					if(rset.getString("range_5_to")==null||rset.getString("range_5_to").equals("null"))
						str="";
					else
						str=rset.getString("range_5_to");


					out.println("</td><td width='15%' class='fields' >&nbsp;&nbsp;<input type='text' name='range_5_to' id='range_5_to' size='6' value='"+ str +"' maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_5_to_unit' id='range_5_to_unit'>");

					String strUnitTo5 ="";

					if(rset.getString("range_5_fr_unit")==null)
					strUnitTo5="";
					else
					strUnitTo5=rset.getString("range_5_fr_unit");


					if(strUnitTo5.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitTo5.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitTo5.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(strUnitTo5.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitTo5.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




				 
            _bw.write(_wl_block46Bytes, _wl_block46);

					str="";
					if(rset.getString("range_6_fr")==null||rset.getString("range_6_fr").equals("null"))
						str="";
					else
						str=rset.getString("range_6_fr");

					
					String strUnitFrom6 ="";

					if(rset.getString("range_6_fr_unit")==null)
					strUnitFrom6="";
					else
					strUnitFrom6=rset.getString("range_6_fr_unit");



					out.println("<td width='15%' class='fields' >&nbsp;&nbsp; <input type='text' name='range_6_fr' id='range_6_fr' size='6'  value='"+ str + "'maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_6_fr_unit' id='range_6_fr_unit' >");

					if(strUnitFrom6.equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom6.equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(strUnitFrom6.equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(strUnitFrom6.equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(strUnitFrom6.equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




					str="";
					if(rset.getString("range_6_to")==null||rset.getString("range_6_to").equals("null"))
						str="";
					else
						str=rset.getString("range_6_to");


					out.println("</td><td width='15%' class='fields' >&nbsp;&nbsp;<input type='text' name='range_6_to' id='range_6_to' size='6' value='"+ str+"' maxlength='6' readonly>");
					out.println("</td><td width='15%' class='fields' >&nbsp;<select name='range_6_to_unit' id='range_6_to_unit'>");

					if(rset.getString("range_6_to_unit").equals("D"))
					{
					out.println("<OPTION selected VALUE="+"D"+">Days"+"&nbsp;&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"M"+">Months");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(rset.getString("range_6_to_unit").equals("M"))
					{
					out.println("<OPTION selected VALUE="+"M"+">Months");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"Y"+">Years");*/
					out.println("</select>");
					}
					if(rset.getString("range_6_to_unit").equals("Y"))
					{
					out.println("<OPTION selected VALUE="+"Y"+">Years"+"&nbsp;&nbsp;");
					/*out.println("<OPTION VALUE="+"D"+">Days");
					out.println("<OPTION VALUE="+"M"+">Months");*/
					out.println("</select>");
					}
					if(rset.getString("range_6_to_unit").equals("K"))
					{

					out.println("<OPTION selected VALUE="+"K"+">Kgs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}
					
					if(rset.getString("range_6_to_unit").equals("L"))
					{

					out.println("<OPTION selected VALUE="+"L"+">Lbs"+"&nbsp;&nbsp;&nbsp;");
					out.println("</select>");
					}




				 
            _bw.write(_wl_block47Bytes, _wl_block47);


		out.println("</td></tr> </table></div><input type='hidden' name='function' id='function' value='modify'><input type='hidden' name='eff_date_from' id='eff_date_from'><input type='hidden' name='eff_date_to' id='eff_date_to'><input type='hidden' name='function_name' id='function_name' value='modify'></form>");

}

}
catch ( Exception e )
{
	e.printStackTrace();
	out.println(e);
	
}

finally{
	if ( stmt != null ) stmt.close() ;
  	if ( rset != null ) rset.close() ;
	ConnectionManager.returnConnection(conn,request);
}



            _bw.write(_wl_block48Bytes, _wl_block48);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
