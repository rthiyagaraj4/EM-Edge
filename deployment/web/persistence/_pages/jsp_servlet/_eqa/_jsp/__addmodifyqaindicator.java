package jsp_servlet._eqa._jsp;

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
import java.sql.*;
import java.util.*;

public final class __addmodifyqaindicator extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/addModifyQAIndicator.jsp", 1742817541720L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n   <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n  <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n  <Script language=\"JavaScript\" src=\"../../eCommon/js/CommonCalendar.js\" ></Script>\n  <script language=\'javascript\' src=\'../../eCommon/js/messages.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n  <script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n  <script language=\'javascript\' src=\'../../eQA/js/QAIndicator.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n  <script>\n \n   function checkMaxLimit(obj,maxSize) {\n        if ( obj.value.length > maxSize )\n        {\n\t\t  \talert(\"APP-OT0016 The value should be of 500 characters\" );\n\t\t\tevent.returnValue = false;\n   \t  \t\tobj.focus();\n        }\n    }\n\n  function hideothers(){\n\t\tif(document.forms[0].clind_type.value==\'R\'){\n\t\t\t\tx_readonly =\"\";\n\t\t\t    document.forms[0].numerator.disabled=false;\n\t\t\t    document.forms[0].denomenator.disabled=false;\n\n\t\t}\n\t\telse if(document.forms[0].clind_type.value!=\'R\'){\n\t\t\t   document.forms[0].numerator.value=\"\";\n\t\t\t   document.forms[0].denomenator.value=\"\";\n\t\t\t   document.forms[0].numerator.disabled=true;\n\t\t\t   document.forms[0].denomenator.disabled=true;\n\t\t}\n  }\n \n\n  </script>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n</head>\n\t <body OnMouseDown=\'CodeArrest()\' onLoad=\'callFocus(1);disabletext();disablegestation(\"ges\"); \' onKeyDown = \'lockKey()\' onSelect=\"codeArrestThruSelect()\">\n\t <form name=\"qaindform\" id=\"qaindform\"  action=\'../../servlet/eQA.QAIndicatorServlet\'   method=\"post\" target=\"messageFrame\"> \n\t\n\t<a id=\"tab1\" name=\"tab1\" tabindex=\'0\' onFocus=\'javascript:callFocus(1);\'></a> \n\t<table width=\'90%\' cellpadding=\'0\' cellspacing=\'0\'  BORDER=\'0\'>\n\t<tr></td>\n\t <table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' BORDER=\'0\'><tr><td width=\'1%\' class=\'BODYCOLORFILLED\'>&nbsp;</td><td width=\'32%\' class=\'BODYCOLORFILLED\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n      <a align =\'left\' href=\"javascript:callFocus(1);\" tabindex=\'-1\'><img  src=\"../../eQA/images/indicatordark.gif\"\" border=0></a><a align=\'left\' href=\"javascript:callFocus(2);\"  tabindex=\'-1\'><img  src=\"../../eQA/images/criterialight.gif\"\" border=0></a>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="<a align=\'left\' href=\"javascript:callFocus(3);\"  tabindex=\'-1\'><img  src=\"../../eCommon/images/LOthers.gif\"\" border=0></a> ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" </td><td width=\'56%\' class=\'BODYCOLORFILLED\'>&nbsp;</td></tr></table>\n\t <table cellspacing=\'0\' cellpadding=\'0\' width=\'90%\' border=0 align=\'center\'>\n\t <tr><td valign=top width=\'50%\'><table cellspacing=\'0\' cellpadding=\'0\' width=\'90%\' border=0 align=\'center\'>\n\t <tr><td colspan=2 class=label height=5></td></tr>\n\t<tr><td colspan=2>&nbsp;</td></tr>\n\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\n\t<tr><td align=\'right\' class=\'label\'>Indicator ID&nbsp;&nbsp;</td><td>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<input type=\"text\" name=\"qind_clind_id\" id=\"qind_clind_id\"   readonly value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" maxlength=\'4\' size=\'4\'  onfocus=\'\' value=\'\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'CheckNum(this)\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<input type=\"text\" name=\"qind_clind_id\" id=\"qind_clind_id\"  maxlength=\'4\' size=\'4\' tabIndex= \'\' onfocus=\'\' value=\'\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'CheckNum(this)\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' ></img>\n\t</td>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</tr>\n\n\t<tr><td align=\'right\' class=\'label\' nowrap>Indicator Description&nbsp;&nbsp;</td><td><input type=\"text\" name=\"qind_clind_desc\" id=\"qind_clind_desc\"   value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"maxlength=\'60\' size=\'60\' tabIndex= \'\' onfocus=\'\' value=\'\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" >&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td></tr>\n\t\n    <tr><td align=\'right\' class=\'label\'>Indicator Group&nbsp;&nbsp;</td><td><select name=\"qind_group_id\" id=\"qind_group_id\" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =">\n    \t <option value=\'\'>---Select--- </option>\n\t ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<option value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' selected>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </option>\t  \n\t     \n\t\t  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t <option value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" </option>\n\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td></tr>\n\t\n\n\t\t\t\t\t\n\t<tr><td align=\'right\' class=\'label\' >Area Of Concern&nbsp;&nbsp;</td><td>\n\t<TEXTAREA  NAME=\"area_of_concern\"   ROWS=\"3\" COLS=\"30\"  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" >";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</TEXTAREA>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t</td></tr>\n\n   \t<tr><td align=\'right\' class=\'label\'>Indicator Type&nbsp;&nbsp;</td><td>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\n\t<select name=\'clind_type\' id=\'clind_type\'  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" disabled>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<select name=\'clind_type\' id=\'clind_type\' onchange=\'hideothers();\' ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t<option value=\'\'>---Select--- </option>\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t<option value=\'R\' selected>Rational Based </option>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t<option value=\'R\'>Rational Based </option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n                   ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\n\t\t\t\t\t<option value=\'S\' selected>Sentinal Event </option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t<option value=\'S\'>Sentinal Event </option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></img></td></tr>\n\t\n \t<tr><td align=\'right\' class=\'label\' nowrap>Standard Description&nbsp;&nbsp;</td><td><input type=\"text\" name=\"standard_desc\" id=\"standard_desc\"   value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" maxlength=\'100\' size=\'60\' tabIndex= \'\' onfocus=\'\' value=\'\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" >\n\t</td></tr>\n\n   <tr><td align=\'right\' class=\'label\'>Standard Value&nbsp;&nbsp;</td><td >\n   <SELECT name=\"standard_oper\" id=\"standard_oper\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" >\n    \t\t\t\t\n\t\t\t<option value=\"\">-------------&nbsp;Select&nbsp;-------------</option>\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t<option value=\'GT\' selected>Greater Than</option>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<option value=\'GT\'>Greater Than</option>\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t<option value=\'GE\' selected>Greater Than Or Equal To</option>\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<option value=\'GE\'>Greater Than Or Equal To</option>\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t<option value=\'LT\' selected>Less Than</option>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t<option value=\'LT\'>Less Than</option>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n       \t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t<option value=\'LE\' selected>Less Than Or Equal To</option>\n\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t<option value=\'LE\'>Less Than Or Equal To</option>\n\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\n\t\t<option value=\'EQ\' selected>Equal To</option>\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t<option value=\'EQ\'>Equal To</option>\n\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t</SELECT>&nbsp;&nbsp;\n\t    <input type=\"text\" name=\"standard_value\" id=\"standard_value\"  onBlur=\'CheckNum(this)\' maxlength=\'7\' size=\'7\' tabIndex= \'\'  value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =">\n\t</td></tr>\n\n<tr><td align=\'right\' class=\'label\'>Classification Criteria&nbsp;&nbsp;</td><td>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n<select name=\'clind_class\' id=\'clind_class\'  ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" onChange=\'disablegestation(\"surg\")\' disabled>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t<select name=\'clind_class\' id=\'clind_class\'  onChange=\'disablegestation(\"surg\")\' >\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t<option value=\'\'>---------------&nbsp;Select&nbsp;---------------- </option>\n\t\t ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n  \t\t<option value=\'D\' selected>Diagnosis-based </option>\n        ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t<option value=\'D\'>Diagnosis-based </option>\n\t\t ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n  \t\t<option value=\'P\' selected>Procedure-based </option>\n        ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t<option value=\'P\'>Procedure-based </option>\n\t\t ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t  ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n  \t\t<option value=\'Z\' selected>Diagnosis/Procedure-based </option>\n        ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t<option value=\'Z\'>Diagnosis/Procedure-based </option>\n\t\t ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\n        ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n  \t\t<option value=\'O\' selected>Orderable-based </option>\n        ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t<option value=\'O\'>Orderable-based </option>\n\t\t ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n  \t\t<option value=\'I\'>Incident-based </option>\n        ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t<option value=\'I\'>Incident-based </option>\n\t\t ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n  \t\t<option value=\'R\' selected>Direct Reporting </option>\n        ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t<option value=\'R\'>Direct Reporting </option>\n\t\t ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n  \t\t<option value=\'S\' selected>Source Based - RIS</option>\n        ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t<option value=\'S\'>Source Based - RIS</option>\n\t\t ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n  \t\t<option value=\'M\' selected>Source Based - OTMS</option>\n        ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t<option value=\'M\'>Source Based - OTMS</option>\n\t\t ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n  \t\t<option value=\'A\' selected>Source Based - A&E</option>\n        ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t<option value=\'A\'>Source Based - A&E</option>\n\t\t ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n  \t\t<option value=\'N\' selected>Source Based - IP</option>\n        ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t<option value=\'N\'>Source Based - IP</option>\n\t\t ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\n\t</select>&nbsp;</td></tr>\n\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\t<tr><td colspan=2 class=label><B>Default reporting Criteria</B>&nbsp;</td></tr>\n\t\t<tr><td colspan=2>&nbsp;</td></tr>\n<tr><td align=\'right\' class=\'label\'>Default Periodicity&nbsp;&nbsp;</td>\n\t<td>\t<select name=\'dflt_rep_periodicity\' id=\'dflt_rep_periodicity\' ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =">\n \t\t\t\t<option value=\'\'>---Select--- </option>\n\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t<option value=\'M\' selected>Monthly </option>\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t<option value=\'M\'>Monthly </option>\n\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t<option value=\'Q\' selected>Quarterly </option>\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n<option value=\'Q\'>Quarterly </option>\n\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\n\t\t<option value=\'B\' selected>Bi-Annually </option>\n\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t<option value=\'B\'>Bi-Annually </option>\n\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\n<option value=\'A\' selected>Annually </option>\n\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t<option value=\'A\'>Annually </option>\n\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\n\t\t\t\t\n\t\t\t\n\t\t\t\t</select>\n\t</td>\n\t</tr>\n\t<!-- \n\t<tr><td align=\'right\' class=\'label\'>Default Age Range&nbsp;&nbsp;</td><td><input type=\"text\" name=\"dflt_bd_age_range_id\" id=\"dflt_bd_age_range_id\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' maxlength=\'3\' size=\'4\' tabIndex= \'\' onfocus=\'\' onBlur=\'CheckNum(this)\'value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =">\n\t</td></tr>\n\t<tr><td align=\'right\' class=\'label\' nowrap>Default Gender For Reports&nbsp;&nbsp;</td><td>\n\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t<input type=\'checkbox\' checked  value=\'Y\' name=\'dflt_bd_by_gender_yn\' id=\'dflt_bd_by_gender_yn\' ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="></td></tr>\n\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t<input type=\'checkbox\'  value=\'N\' name=\'dflt_bd_by_gender_yn\' id=\'dflt_bd_by_gender_yn\' ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" -->\n\t\n\t<tr><td align=\'right\' class=\'label\'>Enabled&nbsp;</td>\n\t<td>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t<input type=\'checkbox\'  checked name=\'eff_status\' id=\'eff_status\' value=\'E\'   >\n\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t<input type=\'checkbox\'  name=\'eff_status\' id=\'eff_status\' value=\'D\'   >\n\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t</td></tr>\n<tr><td colspan=2>&nbsp;</td></tr>\n\t<tr><td colspan=2>&nbsp;</td></tr>\n\t\n\n\n\t</table></table>\n\t<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\t<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n<a id=\"tab2\" name=\"tab2\" tabindex=\'0\' onFocus=\'javascript:callFocus(2);\'></a> \n\n\t<table width=\'90%\' cellpadding=\'0\' cellspacing=\'0\'  BORDER=\'0\'>\n\t<tr></td>\n\t <table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' BORDER=\'0\'><tr><td width=\'1%\' class=\'BODYCOLORFILLED\'>&nbsp;</td><td width=\'32%\' class=\'BODYCOLORFILLED\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n      <a align =\'left\' href=\"javascript:callFocus(1);\" tabindex=\'-1\'><img  src=\"../../eQA/images/indicatorlight.gif\" border=0></a><a align=\'left\' href=\"javascript:callFocus(2);\"  tabindex=\'-1\'><img  src=\"../../eQA/images/criteriadark.gif\" border=0></a>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="<a align=\'left\' href=\"javascript:callFocus(3);\"  tabindex=\'-1\'><img  src=\"../../eCommon/images/LOthers.gif\"\" border=0></a>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td><td width=\'56%\' class=\'BODYCOLORFILLED\'>&nbsp;</td></tr></table>\n\t <table cellspacing=\'0\' cellpadding=\'0\' width=\'90%\' border=0 align=\'center\' >\n\t <tr><td valign=top width=\'50%\'><table cellspacing=\'0\' cellpadding=\'0\' width=\'90%\' border=0 align=\'center\'>\n\t <tr><td colspan=3 class=label height=5></td></tr>\n\t<tr><td colspan=3 class=Label>&nbsp;</td></tr>\n\t\n\t<tr><td align=\'right\' class=\'label\'>Gender&nbsp;&nbsp;</td>\n\t\t<td><select name=\'gender\' id=\'gender\' ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =" onChange=\'disablegestation(\"ges\")\'>\n \t\t\t\t<option value=\'\'>---Select--- </option>\n\t\t\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t<option value=\'M\' selected>Male </option>\n\t\t\t\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t<option value=\'M\'>Male </option>\n\t            ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\n\t\t\t\t<option value=\'F\' selected>Female </option>\n\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t<option value=\'F\'>Female </option>\n\t              ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\n               ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t\n\t\t\t\t<option value=\'U\' selected>Unknown</option>\n\t\t\t\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n<option value=\'U\'>Unknown</option>\n\t\t\t\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\n\t\t\t\t</select>\n\t</td>\n\t<td>&nbsp;</td>\n\t</tr>\n\t\n\t<tr><td align=\'right\' class=\'label\'>Age Range&nbsp;&nbsp;</td>\n\t<td><select type=\'list\' name=\'age_range\' id=\'age_range\'  OnChange=\'disabletext()\' ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 =">\n\t<option value=\"0\">---Select--</option>\n\n\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t<option  value=\'1\' selected> Greater Than </option>\n\t\t";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\n\t\t\t\t\t<option  value=\'1\'> Greater Than </option>\n\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\n\t\t<option value=\'2\' selected> Greater Than Or Equal To </option>\n\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t<option value=\'2\'>  Greater Than Or Equal To </option>\n\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t<option value=\'3\' selected> Less Than </option>\n\t\t";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\n\t\t<option value=\'3\'> Less Than </option>\n\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\n\t\t\n\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\n\t\t<option value=\'4\' selected>Less Than Or Equal To</option>\n\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t\t<option value=\'4\'>  Less Than Or Equal To</option>\n\t\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\n\n\t\t";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\n\n\t\t<option value=\'5\' selected> Between </option>\n\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t<option value=\'5\'> Between </option>\n\t\t";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\n\t\t\t\t</select>\n\t\t\t\t</td>\n\t            <td align=left >\n\t\t\t\t<input type =\'text\'   value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" name=\'day\' size=\'3\'  maxlength=\'3\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'CheckNum(this)\' ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 =">\n            \t<input type =\'text\'  name = \'month\'  value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" size=\'3\' maxlength=\'3\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'CheckNum(this)\' ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =">\n\t\t\t\t<select type=\'List\' name=\'year\' id=\'year\' ";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =">\n\t\t\t<option value=\"\">---Select--</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\n\t\t<option  value=\'Y\' selected>Years </option>\n\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t<option  value=\'Y\'>Years </option>\n\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t<option  value=\'M\' selected>Months </option>\n\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t<option  value=\'M\'>Months </option>\n\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\n\t\t\t<option  value=\'D\' selected>Days </option>\n\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\n\t\t\t<option  value=\'D\'>Days </option>\n\t\t";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\n\n\n\t\t\t\t\n\n\t\t\t\t\n\t\t\t\t\n\t\t\t\n\t\t\n\t\t\t</select>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\' id=\'gif\'></img>\n\t</td>\n\t</tr>\n\t\n\t<tr><td align=\'right\' class=\'label\'  width=\'\' >Patient Class&nbsp;&nbsp;</td><td class=label colspan=\'2\'>\n\tIP<input type=\'checkbox\' name=\'IP\' id=\'IP\'  ";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="    value=\'IP\'  ";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 =" >&nbsp; &nbsp;\n\tOP<input type=\'checkbox\' name=\'OP\' id=\'OP\' ";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="   value=\'OP\' ";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 =">&nbsp;&nbsp;\n\tDC<input type=\'checkbox\' name=\'DC\' id=\'DC\'  ";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="  value=\'DC\' ";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 =" >EM&nbsp;&nbsp;<input type=\'checkbox\' name=\'EM\' id=\'EM\'   ";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 =" value=\'EM\' ";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =">&nbsp;&nbsp;XT<input type=\'checkbox\' name=\'XT\' id=\'XT\' ";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="    value=\'XT\'  ";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =">&nbsp; \n\t</td>\n\t</tr>\n\t<!-- ADDED ON 1ST OCT 2006.....By Yadav -->\n\t<!-- modified by shashi on 23/10/06 -->\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t<!----------------------------------------------->\n\n \t<tr><td align=\'right\' class=\'label\'>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="&nbsp;&nbsp;</td><td width=\'1%\'>\n\t<input type=\'text\' name=\'gcs_event_code1\' id=\'gcs_event_code1\'  value= \"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" size=10 maxlength=6 ";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="></td>\n\t<td align=left><input type=\'text\' name=\'gcs_event_code2\' id=\'gcs_event_code2\'   value= \"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\" size=10 maxlength=20 ";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =">\n\t</td></tr>\n\t\n\t<tr><td align=\'right\' class=\'label\'>";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="&nbsp;&nbsp;</td><td> \n\t<SELECT name=\"gcsScore1\" id=\"gcsScore1\" ";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 =">\n \t\t\t\t<option value=\'\'>---Select--- </option>\n\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\n      ";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t<option value=\'LT\'>Less Than </option>\n\t\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n    ";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t<option value=\'LE\' selected>Less Than  Or Equal To</option>\n\t\t";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t<option value=\'LE\'>Less Than  Or Equal To</option>\n\t\t";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\n\t\t\t</SELECT>&nbsp; \n\t\t\t</td><td>\n            <input type=\'text\' name=\'gcsScore2\' id=\'gcsScore2\'   value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'size=10   maxlength=5  ";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =">&nbsp; <br>\n\t</td></tr>\n\t\n   <tr><td align=\'right\' class=\'label\'>Post Operative Length of Stay&nbsp;&nbsp;</td><td>\n   <SELECT name=\"post_op_los1\" id=\"post_op_los1\" ";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 =">\n    \t\t\t\t\n\t\t\t<option value=\"\">---Select--</option>\n\t";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\n\t\t\t</SELECT>&nbsp\n\t\t\t</td><td>\n   <input type=\'text\' name=\'post_op_los\' id=\'post_op_los\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" size=10 maxlength=5 onBlur=\'CheckNum(this)\' ";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =">&nbsp;\n\t</td></tr>\n\t\n<tr><td align=\'right\' class=\'label\'>Re-Admit-Days&nbsp;&nbsp;</td><td>\n<SELECT name=\"re_admit_days1\" id=\"re_admit_days1\" ";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =" >\n\t\t\t<option value=\"\">---Select--</option>\n\t\t\t\n\t";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n   ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t\t\t\n\t\t\t</SELECT>&nbsp\n\t\t\t</td><td>\n<input type=\'text\' name=\'re_admit_days\' id=\'re_admit_days\'  size=10  maxlength=5 value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onBlur=\'CheckNum(this)\' ";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 =">&nbsp; \n\t</td></tr>\n\t<tr><td align=\'right\' class=\'label\' >Re-Admit-Hours&nbsp;&nbsp;</td><td>\n\t<SELECT name=\"re_admit_hours1\" id=\"re_admit_hours1\" ";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 =">\n\t \t\t\t\t<option value=\'\'>---Select--- </option>\n\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\n\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n        ";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\t\n\t\t\t</SELECT>&nbsp\n\t\t\t</td><td>\n\t<input type=\'text\' name=\'re_admit_hours\' id=\'re_admit_hours\'  size=10  maxlength=5 onKeyPress=\'return(ChkNumberInput(this,event,0))\' value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 =">&nbsp;\n\t</td></tr>\n<tr><td align=\'right\' class=\'label\'>Waterloo  Event Type/Code&nbsp;&nbsp;</td><td>\n<input type=\'text\' name=\'waterloo_event_type\' id=\'waterloo_event_type\'  value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" size=10 maxlength=4 ";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 =">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td><td><input type=\'text\' name=\'waterloo_event_code\' id=\'waterloo_event_code\'   value= \"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 =">\n\t</td></tr>\n\n\n<tr><td align=\'right\' class=\'label\'>Waterloo Score&nbsp;&nbsp;</td><td>\n<SELECT name=\"waterloo_score1\" id=\"waterloo_score1\" ";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\n    \t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\n\t\t\t</SELECT>&nbsp\n\t\t\t</td><td>\n<input type=\'text\' name=\'waterloo_score\' id=\'waterloo_score\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\" maxlength=5 size=10 onBlur=\'CheckNum(this)\' ";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 =">&nbsp; \n\t</td></tr>\n\t<tr><td align=\'right\' class=\'label\'>Gestation Period&nbsp;&nbsp;</td><td>\n<SELECT name=\"gest_period_operator\" id=\"gest_period_operator\" ";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t<option value=\'LT\' selected>Less Than </option>\n\t\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n         ";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\t\t<option value=\'LE\' selected>Less Than Or Equal To </option>\n\t\t";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\n\n \t\t";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\n\t\t\t\n\t\t</SELECT>&nbsp\n\t\t</td>\n\t\t<td><input type=\'text\' name=\'gest_period\' id=\'gest_period\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\" size=10 onBlur=\'CheckNum(this)\' maxlength=5 ";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 =">&nbsp; \n<SELECT name=\"gest_period_in_dwmy\" id=\"gest_period_in_dwmy\" ";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 =">\n\t \t<option value=\'\'>---Select--- </option>\t\t\t\n\t";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\n\t\t<option value=\'D\' selected>Days</option>\n\t\t";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\n\t\t\t\t\t<option value=\'D\'>Days</option>\n\t\t";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\n\t\t<option value=\'W\' selected>Weeks</option>\n\t\t";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\n\t<option value=\'W\'>Weeks</option>\n\t\t";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\n\n\t\t<option value=\'M\' selected>Months</option>\n\t\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\n\t\t<option value=\'M\'>Months</option>\n\t\t";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\n\t\t<option value=\'Y\' selected>Years</option>\n\t\t";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\n\t\t<option value=\'Y\'>Years</option>\n\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t\t\n\t\t\t</SELECT>\n\t</td></tr>\n\t<tr><td align=\'right\' class=\'label\' nowrap>Post Delivery Length of Stay&nbsp;&nbsp;</td><td>\n<SELECT name=\"post_delv_los_operator\" id=\"post_delv_los_operator\" ";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\n\t\t\t</SELECT>&nbsp\n\t\t\t</td><td>\n<input type=\'text\' name=\'post_delv_los\' id=\'post_delv_los\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 =">&nbsp; \n\t</td></tr>\n\t<tr><td align=\'right\' class=\'label\'>Turn-around Time&nbsp;&nbsp;</td><td>\n<SELECT name=\"tat_days_operator\" id=\"tat_days_operator\" ";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n\t\t\t\n\t\t\t</SELECT>&nbsp\n\t\t\t</td><td>\n<input type=\'text\' name=\'tat_days\' id=\'tat_days\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 =">&nbsp; \n\t</td></tr>\n\n<tr><td align=\'right\' class=\'label\'>Pregnancy Admission Type&nbsp;&nbsp;</td><td>\n<input type=\'text\' name=\'term_preg_adm_type\' id=\'term_preg_adm_type\'  value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\" size=10 maxlength=5 ";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="> \n</td><td>&nbsp;</td></tr>\n\n<tr><td class=\'label\' align=\'right\' nowrap>NOD Type for Normal Delivery&nbsp;&nbsp;</td>\n<td align=\'left\' >\n\n<input type=\'text\' name=\'nod_type\' id=\'nod_type\'  value=\"";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\" size=3 maxlength=2 ";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 =">\n</td>\n<td>&nbsp;</td></tr>\n\n\t<tr><td class=\'label\' align=\'right\' nowrap>Surgery Type&nbsp;&nbsp;</td>\n<td align=\'left\' >\n<SELECT name=\"surg_type\" id=\"surg_type\" ";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 =">\n\t\t<option value=\'\'>---Select--- </option>\n\t\t";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t<option value=\'EL\' selected>Elective</option>\n\t\t";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t<option value=\'EL\'>Elective</option>\n\t\t";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t<option value=\'EM\' selected>Emergency</option>\n\t\t";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\n\t\t<option value=\'EM\'>Emergency</option>\n\t\t";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\n</select>\n</td>\n<td>&nbsp;</td></tr>\n\n<!-- <tr><td class=\'label\' align=\'right\' nowrap>Limit for Report Turn-Around Time&nbsp;&nbsp;</td>\n<td align=\'left\' >\n<input type=\'hidden\' name=\'lmt_rpt_trn_time\' id=\'lmt_rpt_trn_time\' onKeyPress=\'return(ChkNumberInput(this,event,0))\' value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\" size=2 maxlength=1 ";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 =" onBlur=\'callFocus(1);\'>\n </td>\n<td>&nbsp;</td></tr> -->\n \n \t<tr><td align=\'right\' class=\'label\'>Numerator Event Type/Code&nbsp;&nbsp;</td><td width=\'1%\'>\n\t<input type=\'text\' name=\'num_event_type\' id=\'num_event_type\'  value= \"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="></td>\n\t\t<td align=left><input type=\'text\' name=\'num_event_code\' id=\'num_event_code\'   value= \"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 =">\n\t</td></tr>\n\t\n\t<tr><td align=\'right\' class=\'label\'>Value&nbsp;&nbsp;</td><td> \n\t<SELECT name=\'num_operator1\' id=\'num_operator1\' ";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\n      ";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\t\t\n\t\t\t</SELECT>&nbsp; \n\t\t\t</td><td>\n            <input type=\'text\' name=\'num_score\' id=\'num_score\'   value=\'";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 =">&nbsp; <br>\n\t</td></tr>\n\n\t<tr><td colspan=3>&nbsp;</td></tr>\n\t<tr><td colspan=3>&nbsp;</td></tr>\n\t</table></table>\n\t<Input type=hidden name=indgrp id=indgrp value=\"\">\n\t<Input type=hidden name=concatValues id=concatValues value=\"\">\n\t<Input type=hidden name=mode id=mode value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\n\t<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\t<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n\t<a  id =\"tab3\" name=\"tab3\" tabindex=\'0\' onFocus=\'javascript:callFocus(3);\'></a> \n\n\t<table width=\'90%\' cellpadding=\'0\' cellspacing=\'0\'  BORDER=\'0\'>\n\t<tr></td>\n\t <table width=\'100%\' cellpadding=\'0\' cellspacing=\'0\' BORDER=\'0\'><tr><td width=\'1%\' class=\'BODYCOLORFILLED\'>&nbsp;</td><td width=\'32%\' class=\'BODYCOLORFILLED\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n      <a align =\'left\' href=\"javascript:callFocus(1);\" tabindex=\'-1\'><img  src=\"../../eQA/images/indicatorlight.gif\"\" border=0></a><a align=\'left\' href=\"javascript:callFocus(2);\"  tabindex=\'-1\'><img  src=\"../../eQA/images/criterialight.gif\"\" border=0></a><a align=\'left\' href=\"javascript:callFocus(3);\"  tabindex=\'-1\'><img  src=\"../../eCommon/images/Others.gif\"\" border=0></a></td><td width=\'56%\' class=\'BODYCOLORFILLED\'>&nbsp;</td></tr></table>\n\t <table cellspacing=\'0\' cellpadding=\'0\' width=\'90%\' border=0 align=\'center\'>\n\t <tr><td valign=top width=\'50%\'><table cellspacing=\'0\' cellpadding=\'0\' width=\'90%\' border=0 align=\'center\'>\n\t <tr><td colspan=2 class=label height=5></td></tr>\n\t<tr><td colspan=2>&nbsp;</td></tr>\n\n\t<tr><td align=\'right\' class=\'label\' >Numerator &nbsp;&nbsp;</td><td>\n\t<TEXTAREA  NAME=\"numerator\"   ROWS=\"3\" COLS=\"50\" onBlur=\"checkMaxLimit(this,500);makeValidString(this)\" ";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="</TEXTAREA>&nbsp;\n\t</td></tr>\n\n\t<tr><td align=\'right\' class=\'label\' >Denominator &nbsp;&nbsp;</td><td>\n\t<TEXTAREA  NAME=\"denomenator\"   ROWS=\"3\" COLS=\"50\"  onBlur=\"checkMaxLimit(this,500);makeValidString(this); \" ";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="  > ";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="</TEXTAREA>&nbsp;\n\t</td></tr>\n\n\n    <tr><td colspan=2>&nbsp;</td></tr>\n\t<tr><td colspan=2>&nbsp;</td></tr>\n\t<tr><td colspan=2>&nbsp;</td></tr>\n\n\t</table></table>\n\t<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\t<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>\n\n\t<input type=\"hidden\" name=\"dflt_bd_age_range_id\" id=\"dflt_bd_age_range_id\"  value=\"\">\n\t<input type=\"hidden\" name=\"dflt_bd_by_gender_yn\" id=\"dflt_bd_by_gender_yn\"  value=\"\">\n\t<input type=\"hidden\" name=\"lmt_rpt_trn_time\" id=\"lmt_rpt_trn_time\"      value=\"\">\n\t</form>\n\n</body>\n</html>\t\t\n\t \n\t";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 =" \n\n";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

Connection con=null;
try
{
con=ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;

PreparedStatement pstmt1=null;
ResultSet rs1=null;

String mode="I";
String qind_clind_id=""; 
String qind_clind_desc="";
String qind_group_id="";
String qind_group_desc="";
String area_of_concern="";
String clind_type="";
String clind_type_desc="";
String standard_desc=""; 
String standard_value=""; 
String clind_class="";
String clind_class_desc="";

String dflt_rep_periodicity="";
String dflt_bd_by_gender_yn=""; 
String dflt_bd_age_range_id="";
String eff_status=""; 
String patient_class_em="";
String patient_class_op="";
String patient_class_dc=""; 
String patient_class_ip=""; 
String patient_class_xt=""; 
String gender=""; 
String age_operator=""; 
String age_range1=""; 
String age_range2="";
String age_in_dmy="";
String gcs_event_type=""; 
String gcs_event_code="";
String gcs_operator="";
String gcs_score="";
String waterloo_event_code="";
String waterloo_score="";

String post_of_los=""; 
String re_admit_days=""; 
String re_admit_hours="";
String post_of_los_operator="";
String re_admit_days_operator="";
String re_admit_hours_operator="";
String waterloo_event_type="";
String waterloo_operator="";
String gest_period_operator="";
String gest_period_in_dwmy="";
String gest_period="";
String post_delv_los_operator="";
String post_delv_los="";
String tat_days_operator="";
String tat_days="";
String nod_type="";
String term_preg_adm_type="";
String std_operator="";
String std_value="";
String readonly ="";
String surg_type="";
String lmt_rpt_trn_time="";
String x_numerator="";
String x_denomenator="";
String x_readonly="";
String xd_readonly="";
String num_event_type="";
String num_event_code="";
String num_operator="";
String num_score="";

String qind_clind_id1=request.getParameter("qind_clind_id")==null ?"":request.getParameter("qind_clind_id");	

 pstmt=con.prepareStatement("Select * from qa_qind_clind_vw where   qind_clind_id=?");
 pstmt.setString(1,qind_clind_id1);
 rs=pstmt.executeQuery();
while(rs.next())
{
	mode="U";
	qind_clind_id=rs.getString("qind_clind_id"); 
	if(qind_clind_id==null||qind_clind_id.equals("null"))qind_clind_id="";

	qind_clind_desc=rs.getString("qind_clind_desc");
	if(qind_clind_desc==null||qind_clind_desc.equals("null"))qind_clind_desc="";

	qind_group_id=rs.getString("qind_group_id");
	if(qind_group_id==null||qind_group_id.equals("null"))qind_group_id="";

	qind_group_desc=rs.getString("qind_group_desc");
	if(qind_group_desc==null||qind_group_desc.equals("null"))qind_group_desc="";

	area_of_concern=rs.getString("area_of_concern");
	if(area_of_concern==null||area_of_concern.equals("null"))area_of_concern="";
	
	clind_type=rs.getString("clind_type");
	if(clind_type==null||clind_type.equals("null"))clind_type="";

	clind_type_desc=rs.getString("clind_type_desc");
	if(clind_type_desc==null|| clind_type_desc.equals("null")) clind_type_desc="";
	
	standard_desc= rs.getString("standard_desc");
	if(standard_desc==null||standard_desc.equals("null"))standard_desc="";
	
	standard_value= rs.getString("standard_value");
	if(standard_value==null||standard_value.equals("null"))standard_value="";
	 
	clind_class=rs.getString("clind_class");
	if(clind_class==null)clind_class="";
	
	clind_class_desc=rs.getString("clind_class_desc");
	if(clind_class_desc==null||clind_class_desc.equals("null"))clind_class_desc="";
	 
	dflt_rep_periodicity=rs.getString("dflt_rep_periodicity");
	if(dflt_rep_periodicity==null||dflt_rep_periodicity.equals("null"))dflt_rep_periodicity="";
 
	dflt_bd_by_gender_yn= rs.getString("dflt_bd_by_gender_yn");
 	if(dflt_bd_by_gender_yn==null||dflt_bd_by_gender_yn.equals("null"))dflt_bd_by_gender_yn="";
 
	gest_period_operator=rs.getString("gest_period_operator");
 	if(gest_period_operator==null||gest_period_operator.equals("null"))gest_period_operator="";

	gest_period_in_dwmy
	=rs.getString("gest_period_in_dwmy");
	if(gest_period_in_dwmy==null||gest_period_in_dwmy.equals("null"))gest_period_in_dwmy="";


	gest_period=rs.getString("gest_period");
	if(gest_period==null||gest_period.equals("null"))gest_period="";

	dflt_bd_age_range_id=rs.getString("dflt_bd_age_range_id");
	if(dflt_bd_age_range_id==null||dflt_bd_age_range_id.equals("null"))dflt_bd_age_range_id="";

	eff_status= rs.getString("eff_status");
	if(eff_status==null||eff_status.equals("null"))eff_status="";
	if(eff_status.equals("E"))
	{
	 readonly="";
	}
    else
	{
	  readonly="disabled";
	}

	nod_type= rs.getString("nod_type");
	if(nod_type==null||nod_type.equals("null"))nod_type="";


	term_preg_adm_type= rs.getString("term_preg_adm_type");
	if(term_preg_adm_type==null||term_preg_adm_type.equals("null"))term_preg_adm_type="";
 

	patient_class_em=rs.getString("patient_class_em");
	if(patient_class_em==null||patient_class_em.equals("null"))patient_class_em="";
 
	 if(patient_class_em.equals("Y"))
	 patient_class_em="checked";
 
	patient_class_op=rs.getString("patient_class_op");
	 if(patient_class_op==null||patient_class_op.equals("null"))patient_class_op="";
	 if(patient_class_op.equals("Y"))
	 patient_class_op="checked";
	 patient_class_dc= rs.getString("patient_class_dc");
	 if(patient_class_dc==null||patient_class_dc.equals("null"))patient_class_dc="";
	 if(patient_class_dc.equals("Y"))
	 patient_class_dc="checked";
	 
	 patient_class_ip= rs.getString("patient_class_ip");
	 if(patient_class_ip==null||patient_class_ip.equals("null"))patient_class_ip="";
	 if(patient_class_ip.equals("Y"))
	 patient_class_ip="checked";
 
	 patient_class_xt= rs.getString("patient_class_xt");
	 if(patient_class_xt==null||patient_class_xt.equals("null"))patient_class_xt="";
	 if(patient_class_xt.equals("Y"))
	 patient_class_xt="checked";

	 gender= rs.getString("gender");
	 if(gender==null||gender.equals("null"))gender="";
	 
	 age_operator=rs.getString("age_operator"); 
	 if(age_operator==null||age_operator.equals("null"))age_operator="";
	 age_range1= rs.getString("age_range1");
	 if(age_range1==null||age_range1.equals("null"))age_range1="";
	 age_range2=rs.getString("age_range2");
	  if(age_range2==null||age_range2.equals("null"))age_range2="";
	 age_in_dmy=rs.getString("age_in_dmy");
	 if(age_in_dmy==null||age_in_dmy.equals("null"))age_in_dmy="";

	 gcs_event_type= rs.getString("gcs_event_type");
	 if(gcs_event_type==null||gcs_event_type.equals("null"))gcs_event_type="";
	 gcs_event_code=rs.getString("gcs_event_code");
	  if(gcs_event_code==null||gcs_event_code.equals("null"))gcs_event_code="";
	 
	 gcs_operator=rs.getString("gcs_operator");
	 if(gcs_operator==null||gcs_operator.equals("null"))gcs_operator="";
	  gcs_score=rs.getString("gcs_score");
	 if(gcs_score==null||gcs_score.equals("null"))gcs_score="";

	 waterloo_event_type=rs.getString("waterloo_event_type");
	 if(waterloo_event_type==null||waterloo_event_type.equals("null"))waterloo_event_type="";

	 waterloo_event_code=rs.getString("waterloo_event_code");
	 if(waterloo_event_code==null||waterloo_event_code.equals("null"))waterloo_event_code="";
	 
	 waterloo_operator=rs.getString("waterloo_operator");
	 if(waterloo_operator==null||waterloo_operator.equals("null"))waterloo_operator="";
	 
	 waterloo_score=rs.getString("waterloo_score");
	 if(waterloo_score==null||waterloo_score.equals("null"))waterloo_score="";
	 
	 
	 post_delv_los_operator= rs.getString("post_delv_los_operator");
	 if(post_delv_los_operator==null||post_delv_los_operator.equals("null"))post_delv_los_operator="";
	 
	 post_delv_los= rs.getString("post_delv_los");
	 if(post_delv_los
	==null||post_delv_los.equals("null"))post_delv_los="";

	 std_operator=rs.getString("std_operator");
	 if(std_operator==null||std_operator.equals("null"))std_operator="";

	 std_value = rs.getString("STD_VALUE");
	 if(std_value==null||std_value.equals("null"))std_value="";
	post_of_los_operator= rs.getString("post_op_los_operator");
	 if(post_of_los_operator==null||post_of_los_operator.equals("null"))post_of_los_operator="";
	 
	 post_of_los= rs.getString("post_op_los");
	 if(post_of_los==null||post_of_los.equals("null"))post_of_los="";
	 
	 tat_days_operator= rs.getString("tat_days_operator");
	 if(tat_days_operator==null||tat_days_operator.equals("null"))tat_days_operator="";
	 
	 tat_days= rs.getString("tat_days");
	 if(tat_days==null||tat_days.equals("null"))tat_days="";


	re_admit_days_operator= rs.getString("re_admit_days_operator");
	 if(re_admit_days_operator==null||re_admit_days_operator.equals("null"))re_admit_days_operator="";
	 
	 re_admit_days= rs.getString("re_admit_days");
	 if(re_admit_days==null||re_admit_days.equals("null"))re_admit_days="";
	 
	 re_admit_hours_operator=rs.getString("re_admit_hours_operator");
	 if(re_admit_hours_operator==null||re_admit_hours_operator.equals("null"))re_admit_hours_operator="";
	 re_admit_hours=rs.getString("re_admit_hours");
	 if(re_admit_hours==null||re_admit_hours.equals("null"))re_admit_hours="";

	 surg_type=rs.getString("surg_type");
	 if(surg_type==null||surg_type.equals("null"))surg_type="";

		lmt_rpt_trn_time=rs.getString("lmt_rpt_trn_time");
		
	 if(lmt_rpt_trn_time==null||lmt_rpt_trn_time.equals("null"))lmt_rpt_trn_time="";


	 num_event_type= rs.getString("num_event_type");
	 if(num_event_type==null||num_event_type.equals("null"))num_event_type="";

	 num_event_code= rs.getString("num_event_code");
	 if(num_event_code==null||num_event_code.equals("null"))num_event_code="";

	 num_operator= rs.getString("num_operator");
	 if(num_operator==null||num_operator.equals("null"))num_operator="";

	 num_score= rs.getString("num_score");
	 if(num_score==null||num_score.equals("null"))num_score="";
	// out.println("surg_type"+surg_type);
}

 pstmt1=con.prepareStatement("Select ltrim(rtrim(ref_note_text)) ref_note_text1, section_id from QA_QIND_CLIND_REF_NOTE where   qind_clind_id=?");
 pstmt1.setString(1,qind_clind_id1);
 rs1=pstmt1.executeQuery();

 if(rs!=null){ x_readonly = ""; xd_readonly = "";}
 while(rs1.next()){
	 if (rs1.getInt("section_id")==80){ 
		//x_numerator = rs1.getString("ref_note_text");
		//x_numerator = rs1.getString("ref_note_text1");
		x_numerator =(rs1.getString("ref_note_text1")==null)? "":(rs1.getString("ref_note_text1"));
	    x_readonly = "readonly";
     }else if (rs1.getInt("section_id")==90){
//		x_denomenator = rs1.getString("ref_note_text");
		//x_denomenator = rs1.getString("ref_note_text1");
		x_denomenator =(rs1.getString("ref_note_text1")==null)? "":(rs1.getString("ref_note_text1"));
	    xd_readonly = "readonly";
     }
 }

if (x_readonly==""){
	if ((eff_status.equals("S")) || (clind_type.equalsIgnoreCase("S"))) {
	    x_readonly = "readonly";
	}
	else if (eff_status.equals("E"))  {
	    x_readonly = "";
	}
	else if ((clind_type=="") ||(clind_type==null))
	    x_readonly = "";
 }


if (xd_readonly==""){
	if ((eff_status.equals("S")) || (clind_type.equalsIgnoreCase("S"))){
	    xd_readonly = "readonly";
	}
	else if (eff_status.equals("E")){
	    xd_readonly = "";
	}
 }

 if(pstmt!=null) pstmt.close();
 if(rs!=null) rs.close();

 if(pstmt1!=null) pstmt1.close();
 if(rs1!=null) rs1.close();


            _bw.write(_wl_block5Bytes, _wl_block5);
 if(clind_type.equalsIgnoreCase("R")|| (clind_type.equalsIgnoreCase(""))) {
            _bw.write(_wl_block6Bytes, _wl_block6);
}
            _bw.write(_wl_block7Bytes, _wl_block7);
 if(mode.equals("U")){
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(qind_clind_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
}else if (mode.equals("I")){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(qind_clind_desc));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block14Bytes, _wl_block14);

	 pstmt=con.prepareStatement("select  QIND_GROUP_ID, QIND_GROUP_DESC FROM QA_QIND_GROUP order by 2");
         rs=pstmt.executeQuery();
	  while(rs.next())
	  {
	 if(rs.getString(1).equals(qind_group_id))
		  {
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block17Bytes, _wl_block17);
}else{
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block20Bytes, _wl_block20);
}}
	 if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
	
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(area_of_concern));
            _bw.write(_wl_block23Bytes, _wl_block23);
if(mode.equals("U"))	{
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block25Bytes, _wl_block25);
} else {
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
	if(clind_type.equals("R"))
					{
            _bw.write(_wl_block29Bytes, _wl_block29);
}else
					{
            _bw.write(_wl_block30Bytes, _wl_block30);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
	if(clind_type.equals("S"))
					{
            _bw.write(_wl_block32Bytes, _wl_block32);
}else
					{
            _bw.write(_wl_block33Bytes, _wl_block33);
}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(standard_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block37Bytes, _wl_block37);
if(std_operator.equals("GT"))
		{
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
if(std_operator.equals("GE"))
		{
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
if(std_operator.equals("LT"))
		{
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
if(std_operator.equals("LE"))
		{
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(std_operator.equals("EQ"))
		{
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(std_value));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block54Bytes, _wl_block54);
if(mode.equals("U"))	{
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block56Bytes, _wl_block56);
} else {
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
	if(clind_class.equals("D")){
            _bw.write(_wl_block59Bytes, _wl_block59);
}else{
            _bw.write(_wl_block60Bytes, _wl_block60);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
 	if(clind_class.equals("P")){
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
}
            _bw.write(_wl_block64Bytes, _wl_block64);
 if(clind_class.equals("Z")){
            _bw.write(_wl_block65Bytes, _wl_block65);
}else{
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
	if(clind_class.equals("O")){
            _bw.write(_wl_block68Bytes, _wl_block68);
}else{
            _bw.write(_wl_block69Bytes, _wl_block69);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
	if(clind_class.equals("I")){
            _bw.write(_wl_block70Bytes, _wl_block70);
}else{
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block61Bytes, _wl_block61);
	if(clind_class.equals("R")){
            _bw.write(_wl_block72Bytes, _wl_block72);
}else{
            _bw.write(_wl_block73Bytes, _wl_block73);
}
            _bw.write(_wl_block74Bytes, _wl_block74);
	if(clind_class.equals("S")){
            _bw.write(_wl_block75Bytes, _wl_block75);
}else{
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
	if(clind_class.equals("M")){
            _bw.write(_wl_block78Bytes, _wl_block78);
}else{
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block80Bytes, _wl_block80);
	if(clind_class.equals("A")){
            _bw.write(_wl_block81Bytes, _wl_block81);
}else{
            _bw.write(_wl_block82Bytes, _wl_block82);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
	if(clind_class.equals("N")){
            _bw.write(_wl_block83Bytes, _wl_block83);
}else{
            _bw.write(_wl_block84Bytes, _wl_block84);
}
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block86Bytes, _wl_block86);
if(dflt_rep_periodicity.equals("M"))
		{
            _bw.write(_wl_block87Bytes, _wl_block87);
}else{
            _bw.write(_wl_block88Bytes, _wl_block88);
}
            _bw.write(_wl_block89Bytes, _wl_block89);
if(dflt_rep_periodicity.equals("Q"))
		{
            _bw.write(_wl_block90Bytes, _wl_block90);
}else{
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(dflt_rep_periodicity.equals("B"))
		{
            _bw.write(_wl_block92Bytes, _wl_block92);
}else{
            _bw.write(_wl_block93Bytes, _wl_block93);
}
            _bw.write(_wl_block94Bytes, _wl_block94);
if(dflt_rep_periodicity.equals("A"))
		{
            _bw.write(_wl_block95Bytes, _wl_block95);
}else{
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(dflt_bd_age_range_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block98Bytes, _wl_block98);
if(dflt_bd_by_gender_yn.equals("Y"))
	{
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block100Bytes, _wl_block100);
}else{
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block100Bytes, _wl_block100);
}
            _bw.write(_wl_block102Bytes, _wl_block102);
if(eff_status.equals("E"))
	{
            _bw.write(_wl_block103Bytes, _wl_block103);
}else{
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block105Bytes, _wl_block105);
if((clind_type.equalsIgnoreCase("R")) || (clind_type.equalsIgnoreCase("")) ){
            _bw.write(_wl_block106Bytes, _wl_block106);
}
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block108Bytes, _wl_block108);
if(gender.equals("M"))
				{
            _bw.write(_wl_block109Bytes, _wl_block109);
}else{
            _bw.write(_wl_block110Bytes, _wl_block110);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
if(gender.equals("F"))
				{
            _bw.write(_wl_block111Bytes, _wl_block111);
}else{
            _bw.write(_wl_block112Bytes, _wl_block112);
}
            _bw.write(_wl_block113Bytes, _wl_block113);
if(gender.equals("U"))
				{
            _bw.write(_wl_block114Bytes, _wl_block114);
}else{
            _bw.write(_wl_block115Bytes, _wl_block115);
}
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block117Bytes, _wl_block117);


		if(age_operator.equals("GT"))
		{
            _bw.write(_wl_block118Bytes, _wl_block118);
}else{
            _bw.write(_wl_block119Bytes, _wl_block119);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
if(age_operator.trim().equals("GE"))
		{
            _bw.write(_wl_block120Bytes, _wl_block120);
}else{
            _bw.write(_wl_block121Bytes, _wl_block121);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(age_operator.equals("LT"))
		{
            _bw.write(_wl_block122Bytes, _wl_block122);
}else{
            _bw.write(_wl_block123Bytes, _wl_block123);
}
            _bw.write(_wl_block124Bytes, _wl_block124);
if(age_operator.trim().equals("LE"))
		{
            _bw.write(_wl_block125Bytes, _wl_block125);
}else{
            _bw.write(_wl_block126Bytes, _wl_block126);
}
            _bw.write(_wl_block127Bytes, _wl_block127);
if(age_operator.trim().equals("BT"))
		{
            _bw.write(_wl_block128Bytes, _wl_block128);
}else{
            _bw.write(_wl_block129Bytes, _wl_block129);
}
            _bw.write(_wl_block77Bytes, _wl_block77);

            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(age_range1));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(age_range2));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block135Bytes, _wl_block135);
if(age_in_dmy.equals("Y"))
		{
            _bw.write(_wl_block136Bytes, _wl_block136);
}else{
            _bw.write(_wl_block137Bytes, _wl_block137);
}
            _bw.write(_wl_block89Bytes, _wl_block89);
if(age_in_dmy.equals("M"))
		{
            _bw.write(_wl_block138Bytes, _wl_block138);
}else{
            _bw.write(_wl_block139Bytes, _wl_block139);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(age_in_dmy.equals("D"))
		{
            _bw.write(_wl_block140Bytes, _wl_block140);
}else{
            _bw.write(_wl_block141Bytes, _wl_block141);
}
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(patient_class_ip));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(patient_class_op));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(patient_class_dc));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(patient_class_em));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(patient_class_xt));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block152Bytes, _wl_block152);
	String legend="GCS Event Type/Code";
		String rec_fit_ev="Recurrent Fits event Type /code";
		String fib_ev="Fibroid event Type /code";
		String cst_ev="Cyst event Type /code";
		String gcs_scor="GCS Score";
		String hb_leg ="Hb event Type /code";
    	//String s=request.getParameter("qind_clind_id");
		String s = request.getParameter("qind_clind_id")==null?"":request.getParameter("qind_clind_id");
		if(s.equals("14"))
		{
		     legend=rec_fit_ev;
			 gcs_scor="value";
		}
		else if(s.equals("20"))
		{
			 legend=fib_ev;
			 gcs_scor="value";
		}
		else if(s.equals("21"))
		{
			 legend=cst_ev;
			 gcs_scor="value";
		} 
		else if(s.equals("15"))
		{
			 legend=hb_leg;
			 gcs_scor="Result";
		} 
		// added by shashi on 09/02/2007 
		else if(s.equals("46"))
		{
			 legend="Denominator Event Type/Code";
			 gcs_scor="Value";
		} 
		else if(s.equals("25"))
		{
			 legend="Thrombolysis Event Type/Code";
			 gcs_scor="Value";
		} 
		else if ((s.equals("34")) || (s.equals("35")))
		{
			 legend="Denominator Event Type/Code";
			 gcs_scor="Value";
		} 
		else if(s.equals("45"))
		{
			 legend="Event Type/Code";
			 gcs_scor="Value";
		} 
		 
	
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(legend));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(gcs_event_type));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(gcs_event_code));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(gcs_scor));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block160Bytes, _wl_block160);
if(gcs_operator.equals("GT"))
		{
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block161Bytes, _wl_block161);
if(gcs_operator.equals("GE"))
		{
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block127Bytes, _wl_block127);
if(gcs_operator.equals("LT"))
		{
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{
            _bw.write(_wl_block162Bytes, _wl_block162);
}
            _bw.write(_wl_block163Bytes, _wl_block163);
if(gcs_operator.equals("LE"))
		{
            _bw.write(_wl_block164Bytes, _wl_block164);
}else{
            _bw.write(_wl_block165Bytes, _wl_block165);
}
            _bw.write(_wl_block89Bytes, _wl_block89);
if(gcs_operator.equals("EQ"))
		{
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(gcs_score));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block169Bytes, _wl_block169);
if(post_of_los_operator.equals("GT"))
		{
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
if(post_of_los_operator.equals("GE"))
		{
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
if(post_of_los_operator.equals("LT"))
		{
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
if(post_of_los_operator.equals("LE"))
		{
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(post_of_los_operator.equals("EQ"))
		{
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(post_of_los));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block173Bytes, _wl_block173);
if(re_admit_days_operator.equals("GT"))
		{
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
if(re_admit_days_operator.equals("GE"))
		{
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
if(re_admit_days_operator.equals("LT"))
		{
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block174Bytes, _wl_block174);
if(re_admit_days_operator.equals("LE"))
		{
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(re_admit_days_operator.equals("EQ"))
		{
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(re_admit_days));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block178Bytes, _wl_block178);
if(re_admit_hours_operator.equals("GT"))
		{
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block179Bytes, _wl_block179);
if(re_admit_hours_operator.equals("GE"))
		{
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block179Bytes, _wl_block179);
if(re_admit_hours_operator.equals("LT"))
		{
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block180Bytes, _wl_block180);
if(re_admit_hours_operator.equals("LE"))
		{
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(re_admit_hours_operator.equals("EQ"))
		{
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(re_admit_hours));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(waterloo_event_type));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(waterloo_event_code));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block178Bytes, _wl_block178);
if(waterloo_operator.equals("GT"))
		{
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block89Bytes, _wl_block89);
if(waterloo_operator.equals("GE"))
		{
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block179Bytes, _wl_block179);
if(waterloo_operator.equals("LT"))
		{
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block186Bytes, _wl_block186);
if(waterloo_operator.equals("LE"))
		{
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(waterloo_operator.equals("EQ"))
		{
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(waterloo_score));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block178Bytes, _wl_block178);
if(gest_period_operator.equals("GT"))
		{
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block179Bytes, _wl_block179);
if(gest_period_operator.equals("GE"))
		{
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block179Bytes, _wl_block179);
if(gest_period_operator.equals("LT"))
		{
            _bw.write(_wl_block190Bytes, _wl_block190);
}else{
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block191Bytes, _wl_block191);
if(gest_period_operator.equals("LE"))
		{
            _bw.write(_wl_block192Bytes, _wl_block192);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block193Bytes, _wl_block193);
if(gest_period_operator.equals("EQ"))
		{
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(gest_period));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block197Bytes, _wl_block197);
if(gest_period_in_dwmy.equals("D"))
		{
            _bw.write(_wl_block198Bytes, _wl_block198);
}else{
            _bw.write(_wl_block199Bytes, _wl_block199);
}
            _bw.write(_wl_block89Bytes, _wl_block89);
if(gest_period_in_dwmy.equals("W"))
		{
            _bw.write(_wl_block200Bytes, _wl_block200);
}else{
            _bw.write(_wl_block201Bytes, _wl_block201);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(gest_period_in_dwmy.equals("M"))
		{
            _bw.write(_wl_block202Bytes, _wl_block202);
}else{
            _bw.write(_wl_block203Bytes, _wl_block203);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
if(gest_period_in_dwmy.equals("Y"))
		{
            _bw.write(_wl_block204Bytes, _wl_block204);
}else{
            _bw.write(_wl_block205Bytes, _wl_block205);
}
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block178Bytes, _wl_block178);
if(post_delv_los_operator.equals("GT"))
		{
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block40Bytes, _wl_block40);
if(post_delv_los_operator.equals("GE"))
		{
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block179Bytes, _wl_block179);
if(post_delv_los_operator.equals("LT"))
		{
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(post_delv_los_operator.equals("LE"))
		{
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(post_delv_los_operator.equals("EQ"))
		{
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(post_delv_los));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block178Bytes, _wl_block178);
if(tat_days_operator.equals("GT"))
		{
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block89Bytes, _wl_block89);
if(tat_days_operator.equals("GE"))
		{
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(tat_days_operator.equals("LT"))

		{
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block174Bytes, _wl_block174);
if(tat_days_operator.equals("LE"))

		{
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
if(tat_days_operator.equals("EQ"))
		{
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(tat_days));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(term_preg_adm_type));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(nod_type));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block215Bytes, _wl_block215);
if(surg_type.equals("EL"))
		{
            _bw.write(_wl_block216Bytes, _wl_block216);
}else{
            _bw.write(_wl_block217Bytes, _wl_block217);
}
            _bw.write(_wl_block89Bytes, _wl_block89);
if(surg_type.equals("EM"))
		{
            _bw.write(_wl_block218Bytes, _wl_block218);
}else{
            _bw.write(_wl_block219Bytes, _wl_block219);
}
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(lmt_rpt_trn_time));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(num_event_type));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(num_event_code));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block160Bytes, _wl_block160);
if(num_operator.equals("GT"))
		{
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block39Bytes, _wl_block39);
}
            _bw.write(_wl_block225Bytes, _wl_block225);
if(num_operator.equals("GE"))
		{
            _bw.write(_wl_block41Bytes, _wl_block41);
}else{
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block127Bytes, _wl_block127);
if(num_operator.equals("LT"))
		{
            _bw.write(_wl_block44Bytes, _wl_block44);
}else{
            _bw.write(_wl_block162Bytes, _wl_block162);
}
            _bw.write(_wl_block163Bytes, _wl_block163);
if(num_operator.equals("LE"))
		{
            _bw.write(_wl_block164Bytes, _wl_block164);
}else{
            _bw.write(_wl_block165Bytes, _wl_block165);
}
            _bw.write(_wl_block89Bytes, _wl_block89);
if(num_operator.equals("EQ"))
		{
            _bw.write(_wl_block50Bytes, _wl_block50);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);
}
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(num_score));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(x_readonly));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(x_numerator));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(xd_readonly));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(x_denomenator));
            _bw.write(_wl_block231Bytes, _wl_block231);

	}catch(Exception e)
	{
		out.println("Exception in addModifyQAIndicator.jsp : "+e.toString());
		e.printStackTrace(System.out);
	 
	}   
	finally   
	{
		ConnectionManager.returnConnection(con,request);  
	}
	
            _bw.write(_wl_block232Bytes, _wl_block232);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
