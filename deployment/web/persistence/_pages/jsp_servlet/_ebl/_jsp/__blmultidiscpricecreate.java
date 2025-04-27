package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BlServiceDiscPriceBean;
import webbeans.eCommon.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import eBL.Common.BlRepository;
import java.util.*;
import com.ehis.util.*;

public final class __blmultidiscpricecreate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLMultiDiscPriceCreate.jsp", 1737916191707L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Page Added by Nandhini for Price Discount Create Record -->    \n<!-- \nSr No        Version              TFS              SCF/CRF           \t\t   Developer Name\n-----------------------------------------------------------------------------------------------\n1            V210217            14525 \t       \tMMS-QH-CRF-0128.2\t\t       Nandhini M \n--> \n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/BLServiceDiscountPrice.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\nfunction discFieldValidation() {\n\tvar locale = document.forms[0].locale.value;\n\t//alert(\"inside discFieldValidation\");\n\tvar totalRecords = document.forms[0].lastRowIndex.value;\n\t//alert(\"totalRecords:\"+totalRecords);\n\tvar pat_cat_code = document.forms[0].pat_cat_code.value;\n\tvar effFromDate = document.getElementById(\'BCEffFromDate\');\n\tvar effToDate = document.getElementById(\"BCEffToDate\");\n\tvar effFromDuplicateCount = 0;\n\tvar effToDuplicateCount = 0;\n\t\n\tfor(var i=1;i<=totalRecords;i++){\n\t\tvar disc_Ind = document.getElementById(\"disc_Ind\"+i).value;\n\t\tif(disc_Ind == \"\") disc_Ind = \"\";\n\t\t\n\t\tvar isDiscInsMod = document.getElementById(\"isDiscInsMod_\"+i).value;;\n\t\t\n\t\tif(disc_Ind == \"\"){\n\t\t\talert(\"Discount Indicator cannot be Blank\");\n\t\t\tdisc_Ind= document.getElementById(\"discInd\"+i).value = \"\";\n\t\t\tdisc_Ind= document.getElementById(\"discInd\"+i).focus();\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tvar discUptoHrs = document.getElementById(\"discUptoHrs\"+i).value;\n\t\tvar i_discUptoHrs = 0;\n\t\tif(discUptoHrs != \"\") i_discUptoHrs = parseInt(discUptoHrs);\n\t\tvar discUptoPercAmt = document.getElementById(\"discUptoPercAmt\"+i).value;\n\t\tvar i_discUptoPercAmt = 0;\n\t\tif(discUptoPercAmt != \"\") i_discUptoPercAmt = parseInt(discUptoPercAmt);\n\n\t\tif(i_discUptoHrs > 0){\n\t\t\tif(discUptoPercAmt == \"\"){\n\t\t\t\talert(getMessage(\"BL8589\",\"BL\"));\n\t\t\t\tdocument.getElementById(\"discUptoPercAmt\"+i).value = \"\";\n\t\t\t\tdocument.getElementById(\"discUptoPercAmt\"+i).focus();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\t\n\t\t\tif(discUptoPercAmt == 0){\n\t\t\t\talert(\"Discount value cannot be zero\")\n\t\t\t\tdocument.getElementById(\"discUptoPercAmt\"+i).value = \"\";\n\t\t\t\tdocument.getElementById(\"discUptoPercAmt\"+i).focus();\n\t\t\t\treturn false;\n\t\t\t}\t\t\t\n\t\t}\n\t\t\n\t\tvar discPer_ip = document.getElementById(\"discPer_ip\"+i);\n\t\tvar discPer_op = document.getElementById(\"discPer_op\"+i);\n\t\tvar discPer_em = document.getElementById(\"discPer_em\"+i);\n\t\tvar discPer_ex = document.getElementById(\"discPer_ex\"+i);\n\t\tvar discPer_dc = document.getElementById(\"discPer_dc\"+i);\t\t\t\n\t\t\n\t\tif(disc_Ind == \'P\'){\t\t\t\n\t\t\tif(discPer_ip.value > 100){\n\t\t\t\talert(\'Percentage cannot be greater than 100\');\n\t\t\t\tdiscPer_ip.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tif(discPer_op.value > 100){\n\t\t\t\talert(\'Percentage cannot be greater than 100\');\n\t\t\t\tdiscPer_op.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tif(discPer_em.value > 100){\n\t\t\t\talert(\'Percentage cannot be greater than 100\');\n\t\t\t\tdiscPer_em.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tif(discPer_ex.value > 100){\n\t\t\t\talert(\'Percentage cannot be greater than 100\');\n\t\t\t\tdiscPer_ex.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t\tif(discPer_dc.value > 100){\n\t\t\t\talert(\'Percentage cannot be greater than 100\');\n\t\t\t\tdiscPer_dc.select();\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t\t\n\t\tif(pat_cat_code == \"I\" && discPer_ip.value == \"\"){\n\t\t\talert(\"IP Discount value cannot be Blank\");\n\t\t\tsetTimeout(function () {\n\t\t\t\tdiscPer_ip.focus();\n\t\t\t}, 10);\n\t\t\t//discPer_ip.value = \"\";\n\t\t\t//discPer_ip.focus();\n\t\t\treturn false;\t\t\t\n\t\t}\n\t\t\n\t\tif(pat_cat_code == \"O\" && discPer_op.value == \"\"){\n\t\t\talert(\"OP Discount value cannot be Blank\");\n\t\t\tsetTimeout(function () {\n\t\t\t\tdiscPer_op.focus();\n\t\t\t}, 10);\n\t\t\t//discPer_op.value = \"\";\n\t\t\t//discPer_op.focus();\n\t\t\treturn false;\t\t\t\n\t\t}\n\t\t\t\n\t\tif(pat_cat_code == \"D\" && discPer_dc.value == \"\"){\n\t\t\talert(\"DC Discount value cannot be Blank\");\n\t\t\tsetTimeout(function () {\n\t\t\t\tdiscPer_dc.focus();\n\t\t\t}, 10);\n\t\t\t//discPer_dc.focus();\n\t\t\treturn false;\t\t\t\n\t\t}\n\t\t\n\t\tif(pat_cat_code == \"X\" && discPer_ex.value == \"\"){\n\t\t\talert(\"EX Discount value cannot be Blank\");\n\t\t\tsetTimeout(function () {\n\t\t\t\tdiscPer_ex.focus();\n\t\t\t}, 10);\n\t\t\t//discPer_ex.value = \"\";\n\t\t\t//discPer_ex.focus();\n\t\t\treturn false;\t\t\t\n\t\t}\n\t\t\n\t\tif(pat_cat_code == \"E\" && discPer_em.value == \"\"){\n\t\t\talert(\"EM Discount value cannot be Blank\");\n\t\t\tsetTimeout(function () {\n\t\t\t\tdiscPer_ex.focus();\n\t\t\t}, 10);\n\t\t\t//discPer_em.value = \"\";\n\t\t\t//discPer_em.focus();\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tvar discApplicability = document.getElementById(\"discAppl\"+i);\n\t\tif(discApplicability.value == \"\"){\n\t\t\talert(\"Discount Applicability cannot be Blank\");\n\t\t\tsetTimeout(function () {\n\t\t\t\tdiscApplicability.focus();\n\t\t\t}, 10);\n\t\t\t//discApplicability.value = \"\";\n\t\t\t//discApplicability.focus();\n\t\t\treturn false;\n\t\t}\t\n\n\t\tvar discFromDate = document.getElementById(\"discFromDate\"+i);\n\t\tvar disToDate = document.getElementById(\"disToDate\"+i);\n\t\t\n\t\tif(discFromDate.value == \"\"){\n\t\t\talert(\"Effective From Date cannot be Blank\");\n\t\t\tsetTimeout(function () {\n\t\t\t\tdiscFromDate.focus();\n\t\t\t}, 10);\n\t\t\t//discFromDate.value = \"\";\n\t\t\t//discFromDate.focus();\n\t\t\treturn false;\n\t\t}\n\n\t\tif(discFromDate.value != \'\' && isDiscInsMod != \"M\"){\t\n\t\t\tif(!isAfterNow(discFromDate.value,\'DMY\',locale))\n\t\t\t{\n\t\t\t\talert(\"Effective From Date Should be Greater than System Date\");\n\t\t\t\tsetTimeout(function () {\n\t\t\t\tdiscFromDate.focus();\n\t\t\t}, 10);\n\t\t\t\t//discFromDate.value=\"\";\n\t\t\t\t//discFromDate.focus();\n\t\t\t\treturn false;\n\t\t\t} \n\t\t}\n\t\tif(discFromDate.value!=\'\' && disToDate.value!=\'\'){\t\n\t\t\tif(!isBefore(discFromDate.value,disToDate.value,\'DMY\',locale))\n\t\t\t{\n\t\t\t\talert(\"Effective To Date should be greater than Effective From Date\");\n\t\t\t\tsetTimeout(function () {\n\t\t\t\tdisToDate.focus();\n\t\t\t}, 10);\n\t\t\t\t//disToDate.value=\"\";\n\t\t\t\t//disToDate.focus();\n\t\t\t\treturn false;\n\t\t\t} \n\t\t}\n\t\t\n\t\tfor(var j=1;j<=totalRecords;j++){\n\t\t\tif(i != j){\n\t\t\t\tvar lclDiscFromDate = document.getElementById(\"discFromDate\"+j);\n\t\t\t\tvar lclDiscToDate = document.getElementById(\"disToDate\"+j);\n\t\t\t\t\n\t\t\t\tif(lclDiscFromDate.value != \'\' && discFromDate.value != \'\'){\n\t\t\t\t\tif(lclDiscFromDate.value == discFromDate.value) {\n\t\t\t\t\t\teffFromDuplicateCount = 1;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(lclDiscToDate.value != \'\' && disToDate.value != \'\'){\n\t\t\t\t\tif(lclDiscToDate.value == disToDate.value) {\n\t\t\t\t\t\teffToDuplicateCount = 1;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tif(lclDiscFromDate.value != \'\' && lclDiscToDate.value != \'\' && discFromDate.value != \'\'){\n\t\t\t\t\tif(isBetween(lclDiscFromDate.value,lclDiscToDate.value,discFromDate.value,\'DMY\',locale)){\n\t\t\t\t\t\talert(\"Effective dates are overlapping between records, please rectify and continue\");\n\t\t\t\t\t\talert(getMessage(\"BL8108\", \"BL\"));\n\t\t\t\t\t\treturn false;\n\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\t\t\t\n\t\t}\n\t\t\n\t\tif(effFromDuplicateCount > 0) {\n\t\t\talert(\"More than one record has same effective from date, please rectify and continue\");\n\t\t\treturn false;\n\t\t}\n\n\t\tif(effToDuplicateCount > 0) {\n\t\t\talert(\"More than one record has same effective to date, please rectify and continue\");\n\t\t\treturn false;\n\t\t}\t\t\n\t}\t\n\n\treturn true;\n}\n\nfunction fieldValidation(obj,index,class_type) {\n\tvar disc_Ind = document.getElementById(\"disc_Ind\"+index).value;\n\tvar pat_cat_code = document.forms[0].pat_cat_code.value;\n\t\n\tif(disc_Ind == \"\"){\n\t\talert(\"Discount Indicator cannot be blank\");\n\t\tobj.value = \'\';\n\t\tdisc_Ind= document.getElementById(\"discInd\"+index).focus();\n\t\treturn false;\n\t}\n\t\n\tif( (pat_cat_code == \"I\" && class_type == \"IP\" && obj.value == \"\") || (pat_cat_code == \"O\" && class_type == \"OP\" && obj.value == \"\") || (pat_cat_code == \"D\" && class_type == \"DC\" && obj.value == \"\") || (pat_cat_code == \"X\" && class_type == \"EX\" && obj.value == \"\") || (pat_cat_code == \"E\" && class_type == \"EM\" && obj.value == \"\")) {\n\t\talert(\"Discount value cannot be blank\");\n\t\tobj.value = \'\';\n\t\tobj.focus();\n\t\treturn false;\n\t}\n\t\n\tif( (pat_cat_code == \"I\" && class_type == \"IP\" && obj.value == \"0\") || (pat_cat_code == \"O\" && class_type == \"OP\" && obj.value == \"0\") || (pat_cat_code == \"D\" && class_type == \"DC\" && obj.value == \"0\") || (pat_cat_code == \"X\" && class_type == \"EX\" && obj.value == \"0\") || (pat_cat_code == \"E\" && class_type == \"EM\" && obj.value == \"0\")) {\n\t\talert(\"Discount value cannot be zero\");\n\t\tobj.value = \"\";\n\t\tobj.focus();\n\t\treturn false;\n\t}\t\n\t\n\tif(disc_Ind == \'P\' && obj.value > 100){\n\t\talert(\'Percentage cannot be greater than 100\');\n\t\tobj.value = \'\';\n\t\tobj.focus();\n\t\treturn false;\n\t}\n\treturn true;\n}\n\nfunction validateDiscDate(index){\n\t\n\tvar locale = document.forms[0].locale.value;\n\tvar effFromDate = document.getElementById(\'BCEffFromDate\');\n\tvar effToDate = document.getElementById(\"BCEffToDate\");\n\tvar discFromDate = document.getElementById(\'discFromDate\'+index);\n\tvar disToDate = document.getElementById(\'disToDate\'+index);\n\t\n\tif(discFromDate.value !=\'\' && disToDate.value != \'\'){\t\n\t\tif(!isBefore(discFromDate.value,disToDate.value,\'DMY\',locale))\n\t\t{\n\t\t\talert(\"Discount Effective From Date cannot be after Discount Effective To Date\");\n\t\t\tdiscFromDate.value=\"\";\n\t\t\tdiscFromDate.focus();\n\t\t\treturn false;\n\t\t} \t\n\t}\n\t\n\tif(discFromDate.value !=\'\' && disToDate.value != \'\'){\t\n\t\tif(!isAfter(disToDate.value,discFromDate.value,\'DMY\',locale))\n\t\t{\n\t\t\talert(\"Discount Effective To Date cannot be before Effective From Date\");\n\t\t\tdisToDate.value=\"\";\n\t\t\tdisToDate.focus();\n\t\t\treturn false;\n\t\t} \t\n\t}\n\n\tif(effFromDate.value !=\'\' && discFromDate.value != \'\'){\t\n\t\tif(!isBefore(effFromDate.value,discFromDate.value,\'DMY\',locale))\n\t\t{\n\t\t\talert(\"Discount Effective From Date cannot be before Price Effective From Date\");\n\t\t\tdiscFromDate.value=\"\";\n\t\t\tdiscFromDate.focus();\n\t\t\treturn false;\n\t\t} \n\t}\n\t//alert(\"effToDate.value:\"+effToDate.value);\n\t//alert(\"disToDate.value:\"+disToDate.value);\n\tif(effToDate.value != \'\' && disToDate.value != \'\'){\n\t\tif(!isAfter(effToDate.value,disToDate.value,\'DMY\',locale))\n\t\t{\n\t\t\talert(\"Discount Effective To Date should be within Price Effective To Date\");\n\t\t\tdisToDate.value=\"\";\n\t\t\tdisToDate.focus();\n\t\t\treturn false;\n\t\t} \n\t}\n\t\n\treturn true;\n}\n\nfunction valDiscUptoPercAmt(obj, discInd){\n\tvar discValue = parseInt(obj.value);\n\tif(discInd.value == \"\"){\n\t\talert(\"Discount Indicator cannot be Blank\");\n\t\tobj.value = \"\";\n\t\tdiscInd.focus();\n\t\treturn false;\n\t} else {\n\t\tif(discInd.value == \"P\"){\n\t\t\tif(discValue > 100){\n\t\t\t\talert(\"Percentage cannot be greater than 100\");\n\t\t\t\tobj.value = \"\";\n\t\t\t\treturn false;\n\t\t\t} else if(discValue == 0){\n\t\t\t\talert(\"Discount value cannot be zero\");\n\t\t\t\tobj.value = \"\";\n\t\t\t\treturn false;\n\t\t\t}\n\t\t}\n\t}\n}\n\nfunction valDiscUptoHrs(obj){\n\tif(obj.value != \"\" && obj.value == \"0\") {\n\t\talert(\"Range should be within 1 to 999\");\n\t\tobj.value = \"\";\n\t\treturn false;\n\t}\n}\n\n</script>\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\t\t\t\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\">\n\t<form name = \'discbulkupd\' id=\'discbulkupd\' >\t\n      \t<table name=\'Multidiscbulkupd\' id=\'Multidiscbulkupd\'  width=\'100%\' cellpadding=\'3\'  cellspacing=\'0\' align=\"center\" >\n\t\t\t<div id=\"tableContainer\">\t\t\t\n\t\t\t<tr>\n\t\t\t<td align=\"left\" nowrap>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" </td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\'COLUMNHEADER\'\twidth=\'4%\'\talign=\"left\">\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t</td>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\'\twidth=\'4%\'\talign=\"left\">\n\t\t\t\tDiscount <BR>Upto (Hours)\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\'\twidth=\'4%\'\talign=\"left\">\n\t\t\t\t%/Amount\n\t\t\t</td>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t\n\t\t\t\n\t\t\t<td class=\'COLUMNHEADER\'\twidth=\'4%\'\talign=\"left\">\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t</td>\n\t\t\t<td class=\'COLUMNHEADER\'\twidth=\'4%\'\talign=\"left\">\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<td  nowrap class=\'fields\'>\n      \t\t\t<Select name=\'discInd";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'  id=\'discInd";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onchange=\"addData(this,";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =",\'discInd\')\" >\n      \t\t\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\n\t      \t\t\t\t\t<option value=\"A\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </option>\n\t      \t\t\t\t\n\t      \t\t\t\t\t<option value=\"P\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</option>\n\t      \t\t\t</Select>\n\t      \t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n      \t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<td  nowrap class=\'fields\'>\n      \t\t\t<Select name=\'discInd";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =",\'discInd\')\" disabled>\n      \t\t\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</option>\n\t      \t\t\t</Select>\n\t      \t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n      \t\t</td>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\t\n\t\t\n\t\t\t<td  nowrap class=\'fields\'>\n      \t\t\t\t<input type=\"text\" name=\'discUptoHrs";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  id=\'discUptoHrs";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' readonly onkeypress=\'return ChkNumberInput(this,event,\"0\");\' onblur=\"valDiscUptoHrs(this);\" size=\'15\' maxlength=\"3\" value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' />\n      \t\t</td>\n\t\t\t<td  nowrap class=\'fields\'>\n      \t\t\t\t<input type=\"text\" name=\'discUptoPercAmt";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'  id=\'discUptoPercAmt";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' readonly onblur=\"valDiscUptoPercAmt(this,document.forms[0].discInd";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =")\" size=\'15\' maxlength=\"15\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' onkeypress=\'return allowValidNumber(this,event,10,\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\")\'/>\n      \t\t</td>\t\t\t\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\t\t\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t<td  nowrap class=\'fields\'>\n      \t\t\t\t<input type=\"text\" name=\'discPer_ip";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'  id=\'discPer_ip";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' onkeypress=\"return checkForSpecChars(event)\" onblur=\"if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =",\'IP\')) addData(this,";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =",\'IP\')}\" size=\'15\' maxlength=\"15\" value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="/>\n      \t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' readonly onkeypress=\"return checkForSpecChars(event)\" onblur=\"if(checkForNumberDecimalDisc(this)){if(fieldValidation(this,";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="/>\n      \t\t\t</td>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_op";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'  id=\'discPer_op";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =",\'OP\')) addData(this,";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =",\'OP\')}\" size=\'15\' maxlength=\"15\" value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="/>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_op";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="/>\n\t\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_em";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'  id=\'discPer_em";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =",\'EM\')) addData(this,";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =",\'EM\')}\" size=\'15\' maxlength=\"15\" value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_em";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\n\t\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_ex";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'  id=\'discPer_ex";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =",\'EX\')) addData(this,";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =",\'EX\')}\" size=\'15\' maxlength=\"15\" value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_ex";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="/>\n\t\t\t\t</td>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_dc";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'  id=\'discPer_dc";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =",\'DC\')) addData(this,";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =",\'DC\')}\" size=\'15\' maxlength=\"15\" value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\t\t\n\t\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<select name=\'discAppl";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'  id=\'discAppl";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =",\'discAppl\')\" >\n      \t\t\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</option>\n\t      \t\t\t\t\t<option value=\"T\" ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =">Total Amount </option>\n\t      \t\t\t\t\t<option value=\"P\"  ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</option>\n\t      \t\t\t\t\t<option value=\"X\"  ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</option>\n\t      \t\t\t\t\t<option value=\"C\"  ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</option>\n      \t\t\t\t</select>\n      \t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<select name=\'discAppl";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =",\'discAppl\')\" disabled >\n      \t\t\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\'text\' name=\'discFromDate";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'  id=\'discFromDate";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' size=\'15\' maxlength=\'15\' \n\t\t\t\tonBlur=\"if(isValidDate(this)) { if(validateDiscDate(";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =")) addData(this,";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =",\'discfromdate\')}\" value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'  />\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'discFromDate_ctrl\' onClick=\"return showCalendar(\'discFromDate";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\');\"   />\n\t\t\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' size=\'15\' maxlength=\'15\' readonly \n\t\t\t\tonBlur=\"if(isValidDate(this)) { if(validateDiscDate(";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' disabled />\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'discFromDate_ctrl\' readonly onClick=\"return showCalendar(\'discFromDate";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\');\"  disabled />\n\t\t\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>&nbsp;\n\t\t\t\t\t</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' name=\'disToDate";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'  id=\'disToDate";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'  size=\'15\' maxlength=\'15\' onBlur=\"if(isValidDate(this)){if(validateDiscDate(";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =",\'discToDate\')}\" value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' />\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'disToDate_ctrl\' onClick=\"return showCalendar(\'disToDate";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\');\" />\n\t\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'discDtls";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'  id=\'discDtls";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'ip_per";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'  id=\'ip_per";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'op_per";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'  id=\'op_per";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'DC_per";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'  id=\'DC_per";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'EM_per";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'  id=\'EM_per";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'EX_per";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'  id=\'EX_per";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'disc_appl";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'  id=\'disc_appl";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'disc_Ind";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'  id=\'disc_Ind";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'discFrmDate";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'  id=\'discFrmDate";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'discToDate";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'  id=\'discToDate";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'isDiscInsMod_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'  id=\'isDiscInsMod_";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n\t\t\t\t\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\t\t\t\t\t\n\t\t\t\t<input type=\"hidden\" name=\'discUptoHrs";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' />\n\t\t\t\t<input type=\"hidden\" name=\'discUptoPercAmt";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' />\n";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\t\t\t\t\n\t\t\t</td>\n      \t\t</tr>\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t<tr>\n\t\t\t<td  nowrap class=\'fields\'>\n      \t\t\t<Select name=\'discInd";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 =",\'discInd\')\">\n      \t\t\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</option>\n\t      \t\t\t\t\t<option value=\"A\" >";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =" </option>\n\t      \t\t\t\t\n\t      \t\t\t\t\t<option value=\"P\">";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</option>\n\t      \t\t\t</Select>\n\t      \t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n      \t\t</td>\t\t\t\t\t\n";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\t\t\t\n\t\t\t<td  nowrap class=\'fields\'>\n      \t\t\t\t<input type=\"text\" name=\'discUptoHrs";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\' onkeypress=\'return ChkNumberInput(this,event,\"0\");\' onblur=\"valDiscUptoHrs(this);\" size=\'15\' maxlength=\"3\" value=\'\' />\n      \t\t</td>\n\t\t\t<td  nowrap class=\'fields\'>\n      \t\t\t\t<input type=\"text\" name=\'discUptoPercAmt";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'  onkeypress=\"return checkForSpecChars(event)\" onblur=\"valDiscUptoPercAmt(this,document.forms[0].discInd";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =")\" size=\'15\' maxlength=\"15\" value=\'\' onkeypress=\'return allowValidNumber(this,event,10,\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\")\'/>\n      \t\t</td>\t\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\t\t\t\n\t\t\t<td  nowrap class=\'fields\'>\n      \t\t\t\t<input type=\"text\" name=\'discPer_ip";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 =",\'IP\')}\" size=\'15\' maxlength=\"15\" value=\'\' ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="/>\n      \t\t</td>\n\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_op";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =",\'OP\')}\" size=\'15\' maxlength=\"15\" value=\'\' ";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="/>\n\t\t\t</td>\n\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_em";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =",\'EM\')}\" size=\'15\' maxlength=\"15\" value=\'\' ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="/>\n\t\t\t</td>\n\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_ex";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 =",\'EX\')}\" size=\'15\' maxlength=\"15\" value=\'\' ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="/>\n\t\t\t</td>\n\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_dc";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 =",\'DC\')}\" size=\'15\' maxlength=\"15\" value=\'\' ";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="/>\n\t\t\t</td>\n\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<select name=\'discAppl";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 =",\'discAppl\')\">\n      \t\t\t\t\t<option value=\'\' >";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="</option>\n\t      \t\t\t\t\t<option value=\"T\">Total Amount </option>\n\t      \t\t\t\t\t<option value=\"P\" >";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</option>\n\t      \t\t\t\t\t<option value=\"X\" >";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="</option>\n\t      \t\t\t\t\t<option value=\"C\" >";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="</option>\n      \t\t\t\t</select>\n      \t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>\n\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t<input type=\'text\' name=\'discFromDate";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' size=\'15\' maxlength=\'15\' \n\t\t\t\tonBlur=\"if(isValidDate(this)){if(validateDiscDate(";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 =",\'discfromdate\')}\" value=\'\' />\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'discFromDate_ctrl\' onClick=\"return showCalendar(\'discFromDate";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\');\"  />\n\t\t\t\t\t&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>&nbsp;\n\t\t\t</td>\n\t\t\t\t\t\n\t\t\t<td  nowrap class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' name=\'disToDate";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 =",\'discToDate\')}\" value=\'\' />\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'disToDate_ctrl\' onClick=\"return showCalendar(\'disToDate";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'op_per";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'DC_per";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'EM_per";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'EX_per";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'disc_appl";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'disc_Ind";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'discFrmDate";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'discToDate";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'isDiscInsMod_";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\' value=\'I\'>\n\t\t\t\t\n";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t\t<input type=\"hidden\" name=\'discUptoHrs";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' value=\'\' />\n\t\t\t\t<input type=\"hidden\" name=\'discUptoPercAmt";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' value=\'\' />\t\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t</table>\n\t<table width=\'100%\'>\n\t\t<tr>\n\t\t\t<td width=\'70%\'>\n\t\t\t</td>\n\t\t\t<td width=\'10%\'>\n\t\t\t\t<input type=\'button\' name=\'discBulkAdd\'  id=\'discBulkAdd\' value=\'Add\' onclick=\'if(addModify()) addRowDisc(\"discBulkAdd\")\'>\n\t\t\t\t<input type=\'button\' name=\'discBulkSave\'  id=\'discBulkSave\' value=\'Save\' onclick=\'if(discFieldValidation()) saveDiscDtls()\'>\n\t\t\t</td>\n\t\t</tr>\n\t\t\n\t</table>\n      \t\t\t<input type=\'hidden\' name=\'pageId\' id=\'pageId\'  value=\'Bulk\'>\n\t\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\'  value=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'lastRowIndex\' id=\'lastRowIndex\'  value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'inclRowCount\' id=\'inclRowCount\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'pat_cat_code\' id=\'pat_cat_code\'  value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'selBlngClass\' id=\'selBlngClass\'  value=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'>\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'BCEffFromDate\' id=\'BCEffFromDate\'  value=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'>\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'BCEffToDate\' id=\'BCEffToDate\'  value=\'";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\'  value=\'";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\'  value=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'isServiceDiscountEnabledYN\'  id=\'isServiceDiscountEnabledYN\' value = \'";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'>\n\t</form>\n\t</body>\n";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\t\t\t\n\t</html>\n\n";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private String checkForNull(String inputString)
	{	
		if(inputString == null || "null".equals(inputString) || " ".equals(inputString)){
			//inputString=="";
			//System.err.println("28===>");
			return "";
		}
		else{
			///System.err.println("27===>");
			return inputString;
		}
		
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			int tableIndex = 1; // added against 128.2

	String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	System.err.println(mode);

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String isServiceDiscountEnabledYN = "N";
			int servDiscFnCntCheck = 0;
			try
			{
				
				String selBlngClass = request.getParameter("selBlngClass");
				if(selBlngClass == null || "null".equals(selBlngClass)) selBlngClass = "";
				
				String effFromDate = request.getParameter("effFromDate");
				if(effFromDate == null || "null".equals(effFromDate)) effFromDate = "";

				String effToDate = request.getParameter("effToDate");
				if(effToDate == null || "null".equals(effToDate)) effToDate = "";
				
				String pat_cat_code = "";
			
				String locale = (String)session.getAttribute("LOCALE");
				int noofdecimal = Integer.parseInt(request.getParameter("noofdecimal")!=null ? request.getParameter("noofdecimal") : "2");
				con = ConnectionManager.getConnection(request);
				
				try 
				{ 
					String sql = "select NVL(PATIENT_CATEGORY_CODE,'') from bl_blng_class where BLNG_CLASS_CODE = '" + selBlngClass + "'";
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						pat_cat_code = rs.getString(1);			
					}
				} catch (Exception e) {
					System.err.println(e);
				} finally {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();	
				}
				
				try
				{
					String sql = "SELECT COUNT (*) FROM sm_function_control a, sm_site_param b  WHERE a.site_id = b.customer_id AND module_id = 'BL'  AND functionality_id = 'ENABLE_SERVICE_PERIOD_DISC'";
					System.out.println("sql for Package Group Function Control:"+sql);
					pstmt = con.prepareStatement(sql);
					rs = pstmt.executeQuery();	
					if(rs.next())
					{
						servDiscFnCntCheck=rs.getInt(1);
						System.err.println("count for ENABLE_SERVICE_PERIOD_DISC Function Control:"+servDiscFnCntCheck);
					}		
					
					if(servDiscFnCntCheck > 0)
						isServiceDiscountEnabledYN = "Y";
					else
						isServiceDiscountEnabledYN = "N";
				}catch(Exception e){
					System.out.println("Exception in Package Group Function Control Query :"+e);
					e.printStackTrace();
				}finally{
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();	
				}				

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

			if("Y".equals(isServiceDiscountEnabledYN)){

            _bw.write(_wl_block10Bytes, _wl_block10);

			}

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

				if(mode.equals("loaddisc")){
					String discstr=request.getParameter("discstr")==null?"":request.getParameter("discstr");
					System.err.println("84====>"+discstr);
					String[] val = discstr.split(",");
					System.err.println("86====>"+val.length);
					//System.err.println("87====>"+val[0]);
					String discInd =  "";
					String ipper	 =""; 
					String opper	 =""; 
					String DCper	 =""; 
					String EMper   =  "";
					String EXper   =  "";
					String discappl=  "";
					String frmDate =  "";
					String toDate =   "";
					//String dseffecTO = request.getParameter("dseffecTO");
					//System.err.println("400,dseffecTO===>"+dseffecTO);
					String isDiscInsMod = "I";
					String discUptoHrs = "";
					String discUptoPercAmt = "";
					for(int i=0;i<val.length;i++){
						tableIndex = i+1;
						System.err.println("i====>"+i);
						String rowdata=val[i];
						System.err.println("86====>"+rowdata);
						String[] rowval=rowdata.split("::");
						System.err.println("rowval:"+rowval);
						
						discInd = checkForNull(rowval[0]);
						if(" ".equals(discInd)) discInd = "";
						
						ipper	 = checkForNull(rowval[1]);
						if(" ".equals(ipper)) ipper = "";
						
						opper	 = checkForNull(rowval[2]);
						if(" ".equals(opper)) opper = "";
						
						EMper   = checkForNull(rowval[3]);
						if(" ".equals(EMper))  EMper = "";
						
						EXper   = checkForNull(rowval[4]);
						if(" ".equals(EXper))  EXper = "";
						
						DCper	 = checkForNull(rowval[5]);
						if(" ".equals(DCper)) DCper = "";					
						
						discappl= checkForNull(rowval[6]);
						if(" ".equals(discappl))  discappl = "";
						
						frmDate = checkForNull(rowval[7]);
						if(" ".equals(frmDate)) frmDate = "";
						
						toDate =  checkForNull(rowval[8]);
						if(" ".equals(toDate)) toDate = "";
						
						isDiscInsMod =  checkForNull(rowval[9]);
						if(" ".equals(isDiscInsMod)) isDiscInsMod = "I";
						
						discUptoHrs =  checkForNull(rowval[10]);
						if(" ".equals(discUptoHrs)) discUptoHrs = "";

						discUptoPercAmt =  checkForNull(rowval[11]);
						if(" ".equals(discUptoPercAmt)) discUptoPercAmt = "";
					

            _bw.write(_wl_block13Bytes, _wl_block13);

			if("I".equals(isDiscInsMod)){

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(discInd.equals("")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(discInd.equals("A")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(discInd.equals("P")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

			} else{
			
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(discInd.equals("")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(discInd.equals("A")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(discInd.equals("P")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

			}

            _bw.write(_wl_block1Bytes, _wl_block1);

			if("Y".equals(isServiceDiscountEnabledYN)){

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(discUptoHrs));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(discUptoPercAmt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block33Bytes, _wl_block33);

			}

            _bw.write(_wl_block34Bytes, _wl_block34);

			if("I".equals(isDiscInsMod)){

            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ipper));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( ("I".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block41Bytes, _wl_block41);

			} else{
			
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(ipper));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( ("I".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block43Bytes, _wl_block43);

			}

            _bw.write(_wl_block1Bytes, _wl_block1);

			if("I".equals(isDiscInsMod)){

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(opper));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( ("O".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block48Bytes, _wl_block48);

			} else{
			
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(opper));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( ("O".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block50Bytes, _wl_block50);

			}

            _bw.write(_wl_block51Bytes, _wl_block51);

			if("I".equals(isDiscInsMod)){

            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(EMper));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( ("E".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block48Bytes, _wl_block48);

			} else{
			
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(EMper));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( ("E".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block48Bytes, _wl_block48);

			}

            _bw.write(_wl_block1Bytes, _wl_block1);

			if("I".equals(isDiscInsMod)){
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(EXper));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( ("X".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block48Bytes, _wl_block48);

			} else{
				
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(EXper));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( ("X".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block62Bytes, _wl_block62);

			}

            _bw.write(_wl_block1Bytes, _wl_block1);

			if("I".equals(isDiscInsMod)){
				
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(DCper));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( ("D".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block48Bytes, _wl_block48);

			} else{
				
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(DCper));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( ("D".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block48Bytes, _wl_block48);

			}

            _bw.write(_wl_block67Bytes, _wl_block67);

			if("I".equals(isDiscInsMod)){
				
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(discappl.equals("")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(discappl.equals("T")?"selected":""));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(discappl.equals("P")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(discappl.equals("X")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(discappl.equals("C")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

			} else{
				
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(discappl.equals("")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(discappl.equals("T")?"selected":""));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(discappl.equals("P")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(discappl.equals("X")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(discappl.equals("C")?"selected":""));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);

			}

            _bw.write(_wl_block51Bytes, _wl_block51);

			if("I".equals(isDiscInsMod)){
				
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(frmDate));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block84Bytes, _wl_block84);

			} else{
				
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(frmDate));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block87Bytes, _wl_block87);

			}

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(ipper));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(opper));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(DCper));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(EMper));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(EXper));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(discappl));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(discInd));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(frmDate));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(toDate));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(isDiscInsMod));
            _bw.write(_wl_block116Bytes, _wl_block116);

			if("N".equals(isServiceDiscountEnabledYN)){

            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(discUptoHrs));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(discUptoPercAmt));
            _bw.write(_wl_block120Bytes, _wl_block120);

			}

            _bw.write(_wl_block121Bytes, _wl_block121);
  
						//tableIndex+=1;
					}
				}
				else
				{

            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block123Bytes, _wl_block123);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);

			if("Y".equals(isServiceDiscountEnabledYN)){

            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block131Bytes, _wl_block131);

			}				

            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(("I".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(("O".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(("E".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(("X".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(("D".equals(pat_cat_code) || "**".equals(selBlngClass)) ? "" : "readonly"));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block143Bytes, _wl_block143);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block144Bytes, _wl_block144);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block145Bytes, _wl_block145);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block146Bytes, _wl_block146);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block161Bytes, _wl_block161);

			if("N".equals(isServiceDiscountEnabledYN)){

            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block164Bytes, _wl_block164);

			}

            _bw.write(_wl_block121Bytes, _wl_block121);

		 		} 

            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(tableIndex -1 ));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(pat_cat_code));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(selBlngClass));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(effFromDate));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(effToDate));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(isServiceDiscountEnabledYN));
            _bw.write(_wl_block175Bytes, _wl_block175);
 			}catch(Exception e){
				System.err.println("Exception in BLMultiDiscPriceCreate.jsp:"+e);
				e.printStackTrace();
			}finally {
				ConnectionManager.returnConnection(con, request);
			}

            _bw.write(_wl_block176Bytes, _wl_block176);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DiscountDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DiscountIndicator.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IP_amt.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OP_amt.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EM_amt.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EX_amt.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DC_amt.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DiscApplicability.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveFrom.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveTo.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Amount.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Percentage.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Amount.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Percentage.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYABLE_AMT.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYABLE_AMT.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Amount.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Percentage.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYABLE_AMT.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
}
