package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __ekyccomparisonpopup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/EkycComparisonPopup.jsp", 1709118613588L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<head>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"></link>\n<script Language=\"javascript\" src=\"../../eMP/js/PasInterface.js\"> </script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<style>\n\ntr, td{\n    border-bottom: 1px solid #d5ecfb;\n\tborder-top: 1px solid #d5ecfb;\n\tborder-left: 1px solid #d5ecfb;\n\tborder-right: 1px solid #d5ecfb;\n\t\n}\n\n.btn {\n    border: none; /* Remove borders */\n    color: white; /* Add a text color */\n    padding: 8px 22px; /* Add some padding */\n    cursor: pointer; /* Add a pointer cursor on mouse-over */\n}\n\n.info {background-color: #0063c5;} /* Blue */\n.info:hover {background: #0b7dda;}\n\n\n</style>\n\n<script>\nfunction cancel()\n{\n\twindow.close();\n}\n\nfunction reset()\n{\n  document.forms[0].reset();\n}\n</script>\n\n<title>\neKYC Comparison\n</title>\n\n</head>\n\n<form>\n\n\n<table width=\"100%\" height=\"100%\" cellPadding=\"1\" noWrap=\"nowrap\" bgcolor=\"#000000\" style=\"border-collapse: collapse;border-style: solid;border-color: #d5ecfb #d5ecfb;\">\n\n\t\t<tr height=\"40\">\n\t\t\t  <td  colSpan=\"4\"  align=\"center\"  style=\"background-color: #dae6f2; color: black;\"> Compare eKYC and EM data </td>\n\t\t</tr>\n\t\t<tr height=\"30\">\n\t\t\t  <td   colSpan=\"4\"  align=\"left\" style=\"background-color: #dae6f2; color: black;\"> AADHAAR Number from eKYC - ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" </td>\n\t\t</tr>\n\t\t <tr style=\"background-color: #f2f9fe; color: black; border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"45\" >\n\t\t\t  &nbsp\n\t\t\t </td>\n\t\t\t  <td height=\"45\">\n\t\t\t  EM\n\t\t\t </td>\n\t\t\t  <td height=\"45\">\n\t\t\t  eKYC\n\t\t\t </td>\n\t\t\t  <td height=\"45\">\n\t\t\t  ACTION\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;\">\n\t\t\t  First Name\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t  ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" &nbsp; \n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t  ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" &nbsp; \n\t\t\t </td>\n\t\t\t  <td height=\"30\">\n\t\t\t  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t  <input type=\'checkbox\' name=\'firstNameCheck\' id=\'firstNameCheck\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;\">\n\t\t\t  Second Name\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t  <input type=\'checkbox\' name=\'secondNameCheck\' id=\'secondNameCheck\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;\">\n\t\t\t  Third Name\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t  ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t  <input type=\'checkbox\' name=\'thirdNameCheck\' id=\'thirdNameCheck\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black;\">\n\t\t\t  Date of Birth\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t  ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t  <input type=\'checkbox\' name=\'dobCheck\' id=\'dobCheck\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black; \">\n\t\t\t  Gender\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" &nbsp; \n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" &nbsp; \n\t\t\t </td>\n\t\t\t  <td  height=\"30\">\n\t\t\t   ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t  <input type=\'checkbox\' name=\'genderCheck\' id=\'genderCheck\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black;\">\n\t\t\t  Phone number\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t  <input type=\'checkbox\' name=\'mobileNumCheck\' id=\'mobileNumCheck\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black;\">\n\t\t\t   Email\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" &nbsp; \n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t   ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" &nbsp; \n\t\t\t </td>\n\t\t\t  <td height=\"30\">\n\t\t\t\t ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t  <input type=\'checkbox\' name=\'mailCheck\' id=\'mailCheck\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black;\">\n\t\t\t  Address 1\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t  <input type=\'checkbox\' name=\'addr1Check\' id=\'addr1Check\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;\">\n\t\t\t   Address 2\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t   ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" &nbsp;\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t  <input type=\'checkbox\' name=\'addr2Check\' id=\'addr2Check\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black;\">\n\t\t\t  Address 3\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" &nbsp;\n\t\t\t </td>\n\t\t\t  <td height=\"30\">\n\t\t\t\t ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t  <input type=\'checkbox\' name=\'addr3Check\' id=\'addr3Check\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black;\">\n\t\t\t  Address 4\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t   ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" &nbsp;\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t  <input type=\'checkbox\' name=\'addr4Check\' id=\'addr4Check\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black;\">\n\t\t\t  District\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t  ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t  <input type=\'checkbox\' name=\'districtCheck\' id=\'districtCheck\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black;\">\n\t\t\t  State\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t   ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t  <input type=\'checkbox\' name=\'stateCheck\' id=\'stateCheck\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"background-color: #f4fafe; color: black; border-bottom: 1px solid #d5ecfb;\">\n\t\t\t <td height=\"30\" style=\"background-color: #f4fafe; color: black;\" >\n\t\t\t  Postal Code\n\t\t\t </td>\n\t\t\t  <td height=\"30\" style=\"font-size: 105%;\">\n\t\t\t  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t  <input type=\'checkbox\' name=\'postalCodeCheck\' id=\'postalCodeCheck\' value=\'Y\' >\n\t\t\t  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t  &nbsp;\n\t\t\t </td>\n\t\t </tr>\n\n\t\t <tr style=\"background-color: #dae6f2; color: black;\">\n\t\t\t <td rowSpan=\"1\" colSpan=\"4\" align=\"right\" height=\"50\">\n\t\t\t  <input class=\"btn info\" type=\"button\" value=\"Replace from eKYC\" align=\"right\" onClick=\"replaceValues()\"/>\n\t\t\t  <input class=\"btn info\" type=\"button\" value=\"Cancel\" align=\"right\" onClick=\"cancel()\"/>\n\t\t\t  <input class=\"btn info\" type=\"button\" value=\"Reset\" align=\"right\" onClick=\"reset()\" />\n\t\t\t </td>\n\t\t </tr>\n\t  </table>\n\n<input type=hidden name=\"aFirstName\" id=\"aFirstName\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" >\n<input type=hidden name=\"aSecondName\" id=\"aSecondName\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\n<input type=hidden name=\"aThirdName\" id=\"aThirdName\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" >\n<input type=hidden name=\"aDOB\" id=\"aDOB\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n<input type=hidden name=\"aGender\" id=\"aGender\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" >\n<input type=hidden name=\"aMail\" id=\"aMail\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" >\n<input type=hidden name=\"aMobile\" id=\"aMobile\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" >\n<input type=hidden name=\"address1\" id=\"address1\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" >\n<input type=hidden name=\"address2\" id=\"address2\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" >\n<input type=hidden name=\"address3\" id=\"address3\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" >\n<input type=hidden name=\"address4\" id=\"address4\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n<input type=hidden name=\"aDistrict\" id=\"aDistrict\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" >\n<input type=hidden name=\"aState\" id=\"aState\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" >\n<input type=hidden name=\"aPostalCode\" id=\"aPostalCode\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" >\n\n<input type=hidden name=\"kFirstName\" id=\"kFirstName\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" >\n<input type=hidden name=\"kSecondName\" id=\"kSecondName\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" >\n<input type=hidden name=\"kThirdName\" id=\"kThirdName\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" >\n<input type=hidden name=\"kGender\" id=\"kGender\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" >\n<input type=hidden name=\"kDOB\" id=\"kDOB\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >\n<input type=hidden name=\"kMail\" id=\"kMail\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" >\n<input type=hidden name=\"kMobile\" id=\"kMobile\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" >\n<input type=hidden name=\"kAddress1\" id=\"kAddress1\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" >\n<input type=hidden name=\"kAddress2\" id=\"kAddress2\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" >\n<input type=hidden name=\"kAddress3\" id=\"kAddress3\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" >\n<input type=hidden name=\"kAddress4\" id=\"kAddress4\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" >\n<input type=hidden name=\"kDistrict\" id=\"kDistrict\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" >\n<input type=hidden name=\"kState\" id=\"kState\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" >\n<input type=hidden name=\"kPostalCode\" id=\"kPostalCode\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" >\n\n\n\n</form>\n</html>\n\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = (String)session.getAttribute("PREFERRED_STYLE"); 
            _bw.write(_wl_block5Bytes, _wl_block5);


String aFirstName = request.getParameter("aFirstName")== null? "" : request.getParameter("aFirstName");
String aSecondName = request.getParameter("aSecondName")== null? "" : request.getParameter("aSecondName");
String aThirdName = request.getParameter("aThirdName")== null? "" : request.getParameter("aThirdName");
String aDOB = request.getParameter("aDOB")== null? "" : request.getParameter("aDOB");
String aGender = request.getParameter("aGen")== null? "" : request.getParameter("aGen");
String aMail = request.getParameter("aMail")== null? "" : request.getParameter("aMail");
String aMobile = request.getParameter("aMob")== null? "" : request.getParameter("aMob");
String address1 = request.getParameter("adr1")== null? "" : request.getParameter("adr1");
String address2 = request.getParameter("adr2")== null? "" : request.getParameter("adr2");
String address3 = request.getParameter("adr3")== null? "" : request.getParameter("adr3");
String address4 = request.getParameter("adr4")== null? "" : request.getParameter("adr4");
String aDistrict = request.getParameter("aDist")== null? "" : request.getParameter("aDist");
String aState = request.getParameter("aState")== null? "" : request.getParameter("aState");
String aPostalCode = request.getParameter("aPC")== null? "" : request.getParameter("aPC");

String kFirstName = request.getParameter("kFirstName")== null? "" : request.getParameter("kFirstName");
String kSecondName = request.getParameter("kSecondName")== null? "" : request.getParameter("kSecondName");
String kThirdName = request.getParameter("kThirdName")== null? "" : request.getParameter("kThirdName");
String kGender = request.getParameter("kGen")== null? "" : request.getParameter("kGen");
String kDOB = request.getParameter("kDob")== null? "" : request.getParameter("kDob");
String kMail = request.getParameter("kEmail")== null? "" : request.getParameter("kEmail");
String kMobile = request.getParameter("kMob")== null? "" : request.getParameter("kMob");
String kAddress1 = request.getParameter("kAdr1")== null? "" : request.getParameter("kAdr1");
String kAddress2 = request.getParameter("kAdr2")== null? "" : request.getParameter("kAdr2");
String kAddress3 = request.getParameter("kAdr3")== null? "" : request.getParameter("kAdr3");
String kAddress4 = request.getParameter("kAdr4")== null? "" : request.getParameter("kAdr4");
String kPostalCode = request.getParameter("kPC")== null? "" : request.getParameter("kPC");
String kState = request.getParameter("kState")== null? "" : request.getParameter("kState");
String kDistrict = request.getParameter("kDist")== null? "" : request.getParameter("kDist");

String aadharNumber = request.getParameter("aadharId")== null? "" : request.getParameter("aadharId");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(aadharNumber ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(aFirstName ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(kFirstName ));
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(!aFirstName.equalsIgnoreCase(kFirstName)) { 
            _bw.write(_wl_block11Bytes, _wl_block11);
 } 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(aSecondName ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(kSecondName ));
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(!aSecondName.equalsIgnoreCase(kSecondName)) { 
            _bw.write(_wl_block13Bytes, _wl_block13);
 } 
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(aThirdName ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(kThirdName ));
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(!aThirdName.equalsIgnoreCase(kThirdName)) { 
            _bw.write(_wl_block15Bytes, _wl_block15);
 } 
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(aDOB ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(kDOB ));
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(!aDOB.equalsIgnoreCase(kDOB)) { 
            _bw.write(_wl_block17Bytes, _wl_block17);
 } 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(aGender ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(kGender ));
            _bw.write(_wl_block20Bytes, _wl_block20);
 if(!aGender.equalsIgnoreCase(kGender)) { 
            _bw.write(_wl_block21Bytes, _wl_block21);
 } 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(aMobile ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(kMobile ));
            _bw.write(_wl_block10Bytes, _wl_block10);
 if(!aMobile.equalsIgnoreCase(kMobile)) { 
            _bw.write(_wl_block23Bytes, _wl_block23);
 } 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(aMail ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(kMail ));
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(!aMail.equalsIgnoreCase(kMail)) { 
            _bw.write(_wl_block27Bytes, _wl_block27);
 } 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(address1 ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(kAddress1 ));
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(!address1.equalsIgnoreCase(kAddress1)) { 
            _bw.write(_wl_block29Bytes, _wl_block29);
 } 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(address2 ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(kAddress2 ));
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(!address2.equalsIgnoreCase(kAddress2)) { 
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(address3 ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(kAddress3 ));
            _bw.write(_wl_block34Bytes, _wl_block34);
 if(!address3.equalsIgnoreCase(kAddress3)) { 
            _bw.write(_wl_block35Bytes, _wl_block35);
 } 
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(address4 ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(kAddress4 ));
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(!address4.equalsIgnoreCase(kAddress4)) { 
            _bw.write(_wl_block38Bytes, _wl_block38);
 } 
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(aDistrict ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(kDistrict ));
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(!aDistrict.equalsIgnoreCase(kDistrict)) { 
            _bw.write(_wl_block40Bytes, _wl_block40);
 } 
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(aState ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(kState ));
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(!aState.equalsIgnoreCase(kState)) { 
            _bw.write(_wl_block42Bytes, _wl_block42);
 } 
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(aPostalCode ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(kPostalCode ));
            _bw.write(_wl_block26Bytes, _wl_block26);
 if(!aPostalCode.equalsIgnoreCase(kPostalCode)) { 
            _bw.write(_wl_block44Bytes, _wl_block44);
 } 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(aFirstName ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(aSecondName ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(aThirdName ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(aDOB ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(aGender ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(aMail ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(aMobile ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(address1 ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(address2 ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(address3 ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(address4 ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(aDistrict ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(aState ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(aPostalCode ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(kFirstName ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(kSecondName ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(kThirdName ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(kGender ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(kDOB ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(kMail ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(kMobile ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(kAddress1 ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(kAddress2 ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(kAddress3 ));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(kAddress4 ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(kDistrict ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(kState ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(kPostalCode ));
            _bw.write(_wl_block73Bytes, _wl_block73);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
