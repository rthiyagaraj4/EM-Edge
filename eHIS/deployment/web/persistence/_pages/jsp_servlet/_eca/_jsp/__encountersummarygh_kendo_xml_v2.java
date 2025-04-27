package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import java.text.*;
import java.io.*;
import java.net.*;
import webbeans.eCommon.*;
import javax.servlet.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __encountersummarygh_kendo_xml_v2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncounterSummaryGH_Kendo_XML_V2.jsp", 1742382283688L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--[if IE 6]>  \n  <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n<![endif]-->  \n<!--[if IE 7]>  \n  <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n<![endif]-->  \n<!--[if gte IE 7]>  \n\t<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> \n<![endif]-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\t\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" />\n\t\n\t\t<style>\n\t\tu {    \n\t\t    border-bottom: 1px dotted #000;\n\t\t    text-decoration: none;\n\t\t}\n\t\t\n\t\t.tableTemp { table-layout:fixed; }\n\t\t\n\t\ttd.thickBorder{ \n\t\t\tborder: solid #000 1px;\n\t\t\tword-break:break-all;\n\t\t}\t\t\n\t\t\n\t\t@media screen {\t\n\t\t\tdiv#footer_wrapper {       \n\t\t\t\tdisplay: none;      \n\t\t\t}   \n\t\t}\n\t\t\n\t\t@media print { \t\n\t\t\t.tableTemp { page-break-before:auto;page-break-inside:auto; page-break-after:auto} \n\t\t\t.breakMainTable { page-break-before:always}\n\t\t\t.breakMainTempTable { page-break-before:auto;page-break-inside:avoid; page-break-after:auto}\n\t\t\t.lastTable { page-break-before:auto;page-break-inside:auto; page-break-after:always}  \n\t\t\t.breakTable { page-break-before:auto;page-break-inside:auto; page-break-after:auto}  \n\t\t\t.breakTrNotes    { page-break-before:auto; page-break-inside:auto; page-break-after:auto}\n\t\t\t.breakTr    { page-break-before:auto; page-break-inside:avoid; page-break-after:auto}\n\t\t\t.breakTableLC { page-break-before:avoid;page-break-inside:avoid; page-break-after:auto}  \n\t\t\t.breakTrLC    { page-break-before:auto; page-break-inside:avoid; page-break-after:auto}\n\t\t\t.breakSignTable    { page-break-before:auto; page-break-inside:avoid; page-break-after:auto}\n\t\t\t\n\t\t\t/*\n\t\t\ttfoot { \n\t\t\t\tvisibility: hidden; \n\t\t\t}  \n\t\t\t*/ \n\t\t\tth {\n\t\t\t\tfont-family:Arial;\t\t\n\t\t\t}\n\t\t\tthead {\n\t\t\t\tdisplay:table-header-group;\n\t\t\t}\n\t\t\ttbody {\n\t\t\t\tdisplay:table-row-group;\n\t\t\t}\n\t\t\ttfoot {\n\t\t\t\tdisplay:table-footer-group;\t\t\n\t\t\t\t\n\t\t\t}\t\n\t\t\t\n\t\t\tdiv#footer_wrapper {       \n\t\t\t\tdisplay: none;      \n\t\t\t}  \n\t\t\t\n\t\t\t/*\t\t\t\n\t\t\tdiv#footer_content {   \n\t\t\t\toverflow: hidden;\n\t\t\t\tzoom: 1;\t\t\n\t\t\t}   \n\t\t\t\n\t\t\tdiv#footer_wrapper {    \n\t\t\t\tposition: fixed;\n\t\t\t\tbottom: 0;     \n\t\t\t\tclear:both;\n\t\t\t}  \n\t\t\t  \t\n\t\t\t*/\n\t\t\tdiv#print_wrapper {       \n\t\t\t\tdisplay: none;      \n\t\t\t} \t\t\n\t\t\n\t\t}\n\t\t</style>\n\t</head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t<script>\n\t\tvar docReadyCount = 0;\n\t\tvar divCount = 0;\n\t\t\n\t\tfunction printPage(){\n\t\t\t\n\t\t\tif (";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" == \"1\")\n\t\t\t{\t\n\t\t\t\t\n\t\t\t\tdocReadyCount = docReadyCount + 1;\t\n\t\t\t\tif (docReadyCount == divCount) \n\t\t\t\t{\t\t\t\t\n\t\t\t\t\tif(PrintCommandObject)\n\t\t\t\t\t{\t\t\n\t\t\t\t\t\ttry{\t\n\t\t\t\t\t\t\tPrintCommandObject.ExecWB(6,2);\n\t\t\t\t\t \t\tPrintCommandObject.outerHTML = \"\";\n\t\t\t\t\t \t\twindow.close();\n\t\t\t\t\t \t}\n\t\t\t\t\t \tcatch(e){\t\t\t\n\t\t\t\t\t \t\twindow.print();\n\t\t\t\t\t \t}\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t \twindow.print();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t}\n\t\t\t \n\t\t\n\t\t$(document).ready(function() {\n\t\t\t\n\t\t\tdivCount = document.getElementById(\"divCount\").value;\t\n\t\t\t\n\t\t\tif (navigator.appName == \"Microsoft Internet Explorer\"){\t\t\t\n\t\t\t \t// attach and initialize print command ActiveX object\n\t\t\t\ttry{\n\t\t\t \t\tvar PrintCommand = \'<object id=\"PrintCommandObject\" classid=\"CLSID:8856F961-340A-11D0-A96B-00C04FD705A2\" width=\"0\" height=\"0\"></object>\';\t\t \t\t\n\t\t\t \t\tdocument.body.insertAdjacentHTML(\'afterbegin\', PrintCommand);\n\t\t\t\t}\n\t\t\t \tcatch(e){}\n\t\t\t}\t\n\t\t\t\t\n\t\t});\n\t\t\n\t\t$(window).load(function() \n\t\t{\t\t\n\t\t\tif (";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" == \"1\")\n\t\t\t{\t\n\t\t\t\tif (divCount == 0)\n\t\t\t\t{\t\t\n\t\t\t\t\tif(PrintCommandObject)\n\t\t\t\t\t{\n\t\t\t\t\t\ttry{\t\t\t\n\t\t\t\t\t\t\tPrintCommandObject.ExecWB(6,2);\n\t\t\t\t\t \t\tPrintCommandObject.outerHTML = \"\";\n\t\t\t\t\t \t\twindow.close();\n\t\t\t\t\t \t}\n\t\t\t\t\t \tcatch(e){\t \t\t\n\t\t\t\t\t \t\twindow.print();\n\t\t\t\t\t \t}\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t \twindow.print();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t});\n\t\t\n\t\tfunction pagePrint(){\n\t\t\twindow.print();\t\n\t\t}\n\t</script>\n\t<body class=\'CONTENT\' scroll=\"auto\" style=\"background-color:transparent\">\n\t\t<div id=\"footer_wrapper\">   \n\t\t\t<div id=\"footer_content\">\n\t\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 900px;\">   \t\t\t\n\t\t\t\t\t<tr><th>\n\t\t\t\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 900px;\">\n\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t<tr><hr style=\"color:#000080\"/></tr> \n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 12px\"><strong><span style=\"color: #808080\"><span style=\"font-family: verdana, geneva, sans-serif\">24X7 hot-line: ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;</span></span></strong></span></td>\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 12px\"><strong><span style=\"font-family: verdana, geneva, sans-serif\"><span style=\"color: #808080\">Emergency: ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span></span></strong>&nbsp;&nbsp;</span></td>\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 12px\"><span style=\"font-family: verdana, geneva, sans-serif\"><strong><span style=\"color: #808080\">Email: </span><span style=\"color: #808080\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span></strong></span></span></td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 900px;\">\n\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\"50%\" valign=\"top\">\n\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 10px\"><strong><span style=\"color: #808080\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</span></span></strong></span></td>\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td width=\"50%\" valign=\"top\">\n\t\t\t\t\t\t\t\t\t\t&nbsp;<span style=\"font-size: 12px\"><span style=\"color: #ff0000\"><span style=\"font-size: 14px\"><strong><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span></strong></span></span><span style=\"font-size: 14px\"><strong><span style=\"font-family: verdana, geneva, sans-serif\"></span></strong></span></span></td>\n\t\t\t\t\t\t\t\t\t<!-- \n\t\t\t\t\t\t\t\t\t<td width=\"50%\" valign=\"top\">\n\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 10px\"><strong><span style=\"font-family: verdana, geneva, sans-serif\"><span style=\"color: #808080\"> </span></span></strong></span></td>\n\t\t\t\t\t\t\t\t\t -->\n\t\t\t\t\t\t\t\t\t<!-- \t\n\t\t\t\t\t\t\t\t\t<td width=\"50%\" valign=\"top\">\n\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 10px\"><strong><span style=\"font-family: verdana, geneva, sans-serif\"><span style=\"color: #808080\"> Medanta, The Mediclinic: E-18 Defence Colony, New Delhi 110024</span></span></strong></span></td>\n\t\t\t\t\t\t\t\t\t -->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table>\t\t\t\t\n\t\t\t\t\t</th></tr> \n\t\t\t\t</table>\n\t\t\t</div>\t\n\t\t</div> \n\n\t\t<form name=\"EncounterSummaryGH_form\" id=\"EncounterSummaryGH_form\">\n\t\t\t<div id=\"print_wrapper\"> \n\t\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 900px;\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<input type=\'button\' class=\'button\' name=\'print\' id=\'print\' id=\'print\' onClick=\"pagePrint()\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\t \n\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\"> \n\t\t\t\t<thead> \n\t\t\t\t\t<tr><th> \n\t\t\t\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">\n\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td align=\"center\">\n\t\t\t\t\t\t\t\t\t\t<span style=\"color: #808080\"><span style=\"font-size: 14pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span></span></span>\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</th></tr>\n\t\t\t\t\t<tr><th>  \n\t\t\t\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\">\n\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td style=\"border-bottom:2px solid green\" valign=\"center\">\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<table align=\"right\" border=\"0\" cellpadding=\"3\" cellspacing=\"8\" style=\"width: 300px\">\n\t\t\t\t\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"center\">\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- <img src=\"../../eCommon/jsp/DisplayImages.jsp?param=facilityimage\" title=\'Logo\' width=\"100px\" height=\"100px\"> -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" title=\'Logo\' width=\"100px\" height=\"100px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-family: verdana, geneva, sans-serif; color: red; font-size: 14pt; font-weight: bold;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t\t\t\t</table>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td align=\"right\" style=\"border-bottom:2px solid green\" valign=\"center\">\n\t\t\t\t\t\t\t\t\t\t<table align=\"right\" border=\"0\" cellpadding=\"3\" cellspacing=\"8\" style=\"width: 385px\">\n\t\t\t\t\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"color: #808080\"><span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">Name:</span></span></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 300px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"color: #808080\"><span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">Gender:</span></span></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</span></span> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"color: #808080\"><span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">Blood Group:</span></span></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span></span> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"color: #808080\"><span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">Age:</span></span></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" years</span></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"color: #808080\"><span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">Doctor:</span></span></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t <span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</span></span> \n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td align=\"right\" style=\"border-bottom:2px solid green\" valign=\"center\">\n\t\t\t\t\t\t\t\t\t\t<table  align=\"right\" border=\"0\" cellpadding=\"3\" cellspacing=\"8\" style=\"width: 215px\">\n\t\t\t\t\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"color: #808080\"><span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =":</span></span></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</span></span> \n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 300px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"color: #808080\"><span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =":</span></span></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" </span></span> \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"color: #808080\"><span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">Date:</span></span></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</span></span> \n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td align=\"left\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"color: #808080\"><span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\">&nbsp;</span></span></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 13pt\"><span style=\"font-family: verdana, geneva, sans-serif\"></span></span> \n\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table>\t\t\n\t\t\t\t\t</th></tr>\t\t\n\t\t\t\t\t<tr><th> \n\t\t\t\t\t\t<table align=\"right\" border=\"0\" cellpadding=\"3\" cellspacing=\"3\" style=\"width: 540px\">\n\t\t\t\t\t\t\t<tbody>\t\t\t\t\t\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\"340px\" valign=\"center\"><span style=\"color: #808080\"><span style=\"font-size: 11pt\"><span style=\"font-family: verdana, geneva, sans-serif\">Colors Indicate:&nbsp;</span></span></span></td>\n\t\t\t\t\t\t\t\t\t<td width=\"200px\" valign=\"center\">\n\t\t\t\t\t\t\t\t\t\t<table align=\"right\" border=\"0\" cellpadding=\"3\" cellspacing=\"3\" style=\"width: 200px\">\n\t\t\t\t\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  width=\"65px\" valign=\"bottom\"><span style=\"color: #808080\"><span style=\"font-size: 12pt\"><span style=\"font-family: verdana, geneva, sans-serif\">&nbsp;&nbsp;&nbsp;Optimal&nbsp;&nbsp;&nbsp;</span></span></span></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  width=\"65px\" valign=\"bottom\"><span style=\"color: #808080\"><span style=\"font-size: 12pt\"><span style=\"font-family: verdana, geneva, sans-serif\">&nbsp;&nbsp;&nbsp;Borderline&nbsp;&nbsp;&nbsp;</span></span></span></td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td  width=\"65px\" valign=\"bottom\"><span style=\"color: #808080\"><span style=\"font-size: 12pt\"><span style=\"font-family: verdana, geneva, sans-serif\">&nbsp;&nbsp;&nbsp;Abnormal&nbsp;&nbsp;&nbsp;</span></span></span></td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"65px\" style=\"border-top:3px solid green\" valign=\"top\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"65px\" style=\"border-top:3px solid yellow\" valign=\"top\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td width=\"65px\" style=\"border-top:3px solid red\" valign=\"top\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table>\t\t\t\n\t\t\t\t\t</th></tr> \n\t\t\t\t</thead>    \n\t\t\t\t<tbody> \n\t\t\t\t\t<tr><td>\n\t\t\t\t\t\t<div id=\"body_wrapper\">   \n\t\t\t\t\t\t\t<div id=\"body_content\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<p>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</p>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t<div>\n\t\t\t\n\t\t\t\t\t</td></tr>\t\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\t\t\n\t\t\t\t\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 900px;\">\n\t\t\t\t\t\t\t\t<tbody>\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td width=\"100%\" align=\"center\">\n\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 12px\"><strong><span style=\"color: #808080\"><span style=\"font-family: verdana, geneva, sans-serif\">***** End of Report *****</span></span></strong></span>\n\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\t\t\n\t\t\t\t\t\t\t<table class=\"breakSignTable\" align=\"center\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 900px;\">\n\t\t\t\t\t\t\t\t<tbody>\t\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td style=\"border-top:1px solid blue\" valign=\"top\"></td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\'><u><span style=\"font-size: 12px\"><strong><span style=\"color: #808080\"><span style=\"font-family: verdana, geneva, sans-serif\">Authorised Signatory</span></span></strong></span></u></td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\'><br></td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\'label\'><br></td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<!-- \n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td  class=\'label\'><span style=\"font-size: 12px\"><strong><span style=\"color: #808080\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;&nbsp;(&nbsp;";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;)</span></span></strong></span></td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t -->\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td  class=\'label\'><span style=\"font-size: 12px\"><strong><span style=\"color: #808080\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</span></span></strong></span></td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\t\t\t\t\t\t\n\t\t\t\t</tbody> \n\t\t\t\t<tfoot  id=\"table_footer\"> \t\t\n\t\t\t\t\t<tr><th>\t\t\n\t\t\t\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 900px;\">\n\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t<tr><hr style=\"color:#000080\"/></tr> \n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\"30%\">\n\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 12px\"><strong><span style=\"color: #808080\"><span style=\"font-family: verdana, geneva, sans-serif\">24X7 hot-line: ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="&nbsp;</span></span></strong></span></td>\n\t\t\t\t\t\t\t\t\t<td width=\"30%\">\n\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 12px\"><strong><span style=\"font-family: verdana, geneva, sans-serif\"><span style=\"color: #808080\">Emergency: ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</span></span></strong>&nbsp;&nbsp;</span></td>\n\t\t\t\t\t\t\t\t\t<td width=\"40%\">\n\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 12px\"><span style=\"font-family: verdana, geneva, sans-serif\"><strong><span style=\"color: #808080\">Email: </span><span style=\"color: #808080\">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</span></strong></span></span></td>\n\t\t\t\t\t\t\t\t\t<!-- \t\t\n\t\t\t\t\t\t\t\t\t<td width=\"30%\">\n\t\t\t\t\t\t\t\t\t\t&nbsp;<span style=\"font-size: 12px\"><span style=\"color: #ff0000\"><span style=\"font-size: 14px\"><strong><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</span></strong></span></span><span style=\"font-size: 14px\"><strong><span style=\"font-family: verdana, geneva, sans-serif\"></span></strong></span></span></td>\n\t\t\t\t\t\t\t\t\t -->\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 900px;\">\n\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\"50%\" valign=\"top\">\n\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 10px\"><strong><span style=\"color: #808080\"><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</span></span></strong></span></td>\n\t\t\t\t\t\t\t\t\t<td width=\"50%\">\n\t\t\t\t\t\t\t\t\t\t&nbsp;<span style=\"font-size: 12px\"><span style=\"color: #ff0000\"><span style=\"font-size: 14px\"><strong><span style=\"font-family: verdana, geneva, sans-serif\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</span></strong></span></span><span style=\"font-size: 14px\"><strong><span style=\"font-family: verdana, geneva, sans-serif\"></span></strong></span></span></td>\n\t\t\t\t\t\t\t\t\t<!-- \n\t\t\t\t\t\t\t\t\t<td width=\"50%\" valign=\"top\">\n\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 10px\"><strong><span style=\"font-family: verdana, geneva, sans-serif\"><span style=\"color: #808080\"> </span></span></strong></span></td>\n\t\t\t\t\t\t\t\t\t-->\n\t\t\t\t\t\t\t\t\t<!-- \t\n\t\t\t\t\t\t\t\t\t<td width=\"50%\" valign=\"top\">\n\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 10px\"><strong><span style=\"font-family: verdana, geneva, sans-serif\"><span style=\"color: #808080\"> Medanta, The Mediclinic: E-18 Defence Colony, New Delhi 110024</span></span></strong></span></td>\n\t\t\t\t\t\t\t\t\t -->\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</th> </tr> \n\t\t\t\t</tfoot>\n\t\t\t</table>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);
	
	StringBuffer htmlData = new StringBuffer();
	PatientContext oPatientContext = new PatientContext();
	oPatientContext.request = request;
	String xmlSql = "";
	String demoSql = "", bloodSql = "", encounterSql = "", complaintSql = "", vitalSql = "", encSummSql="", authSplSql="";
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement stmt = null;
	CallableStatement cstmt = null;

	String notesHtmlData = "";
	String strHtmlData = "";

	//Patient Demographic Information variables
	String patientNamePrefix = "", patientFirstName = "", patientSecondName = "", patientThirdName = "", patientFamilyName = "", gender = "", dateOfBirth = "", ageInYears = "";
	String patientName = "", bloodGroup = "";
	//Patient Encounter Information variables
	String facilityId = "", attendPractitionerId = "", visitDateTime = "", practitionerName = "";
	boolean encResFlag = false;
	//Facility Details
	String facilityName = "", addrLine1="", addrLine2="", addrLine3="", addrLine4="", postalCode="", countryName="";
	String telephone1="", telephone2="", telephone3="", telephone4="";
	String emailId="", website="", address="";
	
	//Summary Details
	String v_summ_code = "", v_summ_desc = "";
	
	//Authorised By Doctor Details
	String vAuthoriseById = "", vAuthoriseName = "", vAuthoriseBySplty = "", vAuthoriseDegree="";

	// Chart Type: 1 - Text, 2 - Table, 3 - Linear Gauge, 4 - Line Graph
	int chartType = 0;

	String pageSource = "";
	String gaugeID = "";

	int nCount = 0;
	int nListCount = 0;
	int nListSize = 0;
	int nDisCount = 0;
	
	int v_age_num = 0;
	String v_age_unit = "", v_agegroup = "" ;

	double dValue = 0.0;
	double dNormalLow = 0.0;
	double dNormalHigh = 0.0;

	String alignTable = "";
	String chartID = "";
	String divID = "";

	String columnColor = "";
	String sValueRep = "";

	// XML String
	String xmlString = "";
	Blob blobImage = null;
	String facilityImageName = "";
	
	String printFlag = "0";
	
	request.setCharacterEncoding("UTF-8");
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	facilityId	= (String)session.getValue("facility_id");
	String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	
	//patientid = "DU00000692";
	//encounterid = "101024040001";
		
	String appl_user_id=(String)session.getValue("login_user");	

	v_summ_code = request.getParameter("summCode")==null?"":request.getParameter("summCode");
	
	printFlag = request.getParameter("printFlag")==null?"0":request.getParameter("printFlag");
	
	if (facilityId != null){
		oPatientContext.sFacilityId = facilityId;
	}

	if (patientid != null){
		oPatientContext.sPatientId = patientid;
	}

	if (encounterid != null){
		oPatientContext.sEncounterId = encounterid;
	}
	
	try
	{
		con		= ConnectionManager.getConnection(request);
		
		// To get the Facility Information
		demoSql="select facility_name, addr_line1, addr_line2, addr_line3, addr_line4, addr_postal_code, tel_no1, tel_no2, tel_no3, tel_no4, email_id, website_id, "+
					" long_name country_name, facility_logo, facility_image_file_name  from sm_facility_param a, mp_country b "+
					" where facility_id = ? and a.country_code = b.country_code(+)  ";
		stmt=con.prepareStatement(demoSql);
		stmt.setString(1,facilityId);

		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				facilityName = rs.getString("facility_name")==null?"":rs.getString("facility_name");
				addrLine1 = rs.getString("addr_line1")==null?"":rs.getString("addr_line1")+",";
				addrLine2 = rs.getString("addr_line2")==null?"":rs.getString("addr_line2")+",";
				addrLine3 = rs.getString("addr_line3")==null?"":rs.getString("addr_line3")+",";
				addrLine4 = rs.getString("addr_line4")==null?"":rs.getString("addr_line4")+",";
				postalCode = rs.getString("addr_postal_code")==null?"":rs.getString("addr_postal_code")+",";
				telephone1 = rs.getString("tel_no1")==null?"":rs.getString("tel_no1");
				telephone2 = rs.getString("tel_no2")==null?"":rs.getString("tel_no2");
				telephone3 = rs.getString("tel_no3")==null?"":rs.getString("tel_no3");
				telephone4 = rs.getString("tel_no4")==null?"":rs.getString("tel_no4");
				emailId = rs.getString("email_id")==null?"":rs.getString("email_id");
				website = rs.getString("website_id")==null?"":rs.getString("website_id");
				countryName = rs.getString("country_name")==null?"":rs.getString("country_name");
				blobImage = rs.getBlob("facility_logo");   
				facilityImageName = rs.getString("facility_image_file_name")==null?"":rs.getString("facility_image_file_name");
				
				address = facilityName+", "+ addrLine1 + " " + addrLine2 +" "+ addrLine3 + " " + addrLine4+ " " + postalCode + " " +countryName +".";

				
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		/** BLOB to Image **/
		
		long blobLength = blobImage.length();
		System.out.println(" - - - blobLength: "+blobLength);
		if (blobLength>0){
			
			StringBuffer image_folder = new StringBuffer();
			String path	= "";		
			String strFileSep =	"";		
	
			java.util.Properties pFileSep	= null;
			
			try
			{					
				
				path = application.getRealPath("/");
	
				image_folder.append(path);
	
				pFileSep	= System.getProperties();
				strFileSep	= (String) pFileSep.getProperty("file.separator");
				image_folder.append("eCA");
				image_folder.append(strFileSep);
				image_folder.append("images");
				image_folder.append(strFileSep);			
				image_folder.append(facilityImageName);	
								
				File filecreate ;		
				String filename	= "";
				boolean fcre = false;
				
				filename = image_folder.toString();
				
				System.out.println(" - - - facilityImageName: "+facilityImageName);
				
				filecreate = new File(filename);			
				if(!filecreate.exists())
				{
					System.out.println(" - - - filename: "+filename);
					
					InputStream is = blobImage.getBinaryStream();   
		            FileOutputStream fos = new FileOutputStream(filename);   
		  
					int b = 0;   
					while ((b = is.read()) != -1)   
					{   
					    fos.write(b);    
					}   
					fos.close();
				}				
			}		
			catch ( IOException e )
			{
				out.println("<h3> Exception raise by Servlet ...Error in getting image file path </h3> Foll: Error Received : "+e.toString());
				e.printStackTrace();
			}
			catch ( Exception e )
			{
				out.println("<h3> Exception raise by Servlet ...Error in getting image file path </h3> Foll: Error Received : "+e.toString());
				e.printStackTrace();
			}
		}
		// To get the Patient Demographic Information
		demoSql="select patient_id, name_prefix, first_name, second_name, third_name, family_name, sex, date_of_birth, "+
				" round((trunc(sysdate) - trunc(to_date(to_char(date_of_birth, 'dd/MM/YYYY'),'DD/MM/YYYY')))/  365) age_in_years "+
				" from mp_patient where patient_id = ? ";
		stmt=con.prepareStatement(demoSql);
		stmt.setString(1,patientid);

		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				patientNamePrefix = rs.getString("name_prefix")==null?"":rs.getString("name_prefix");
				patientFirstName = rs.getString("first_name")==null?"":rs.getString("first_name");
				patientSecondName = rs.getString("second_name")==null?"":rs.getString("second_name");
				patientThirdName = rs.getString("third_name")==null?"":rs.getString("third_name");
				patientFamilyName = rs.getString("family_name")==null?"":rs.getString("family_name");
				gender = rs.getString("sex");
				dateOfBirth = rs.getString("date_of_birth");
				ageInYears = rs.getString("age_in_years");	
				patientName = patientNamePrefix + " " + patientFirstName +" "+ patientSecondName + " " + patientThirdName+ " " + patientFamilyName;
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		// To get the Patient Blood Group Details
		rs = null;
		stmt = null;

		bloodSql = "SELECT C.SHORT_DESC blood_grp, b.short_desc    rh_factor,a.g6pd_marker g6pd, a.sicc_marker sicc FROM MP_PAT_OTH_DTLS A, "+     
				" MR_RHESUS_FACTOR B, MR_BLOOD_GRP_LANG_VW C WHERE PATIENT_ID = ? and a.rh_factor = b.RHESUS_FACTOR_CODE(+) and a.blood_grp = c.blood_grp(+) "+ 
				" AND C.LANGUAGE_ID = ?" ;
		stmt=con.prepareStatement(bloodSql);
		stmt.setString(1,patientid);
		stmt.setString(2,locale);

		rs=stmt.executeQuery();

		while(rs.next())
		{
			bloodGroup = rs.getString("blood_grp");
		}

		// To get the Patient Encounter Details
		rs = null;
		stmt = null;
		encounterSql = "select facility_id, encounter_id, attend_practitioner_id, to_char(visit_adm_date_time, 'DD MON YYYY') visit_date_time, practitioner_name "+  
				" from pr_encounter, am_practitioner where attend_practitioner_id = practitioner_id and patient_id = ? and encounter_id = ? ";
		stmt=con.prepareStatement(encounterSql);
		stmt.setString(1,patientid);
		stmt.setString(2,encounterid);
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				facilityId = rs.getString("facility_id")==null?"":rs.getString("facility_id");
				attendPractitionerId = rs.getString("attend_practitioner_id")==null?"":rs.getString("attend_practitioner_id");
				visitDateTime = rs.getString("visit_date_time")==null?"":rs.getString("visit_date_time");
				practitionerName = rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");	
				encResFlag = true;
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();		
		
		// To get the Encounter Summary title
		rs = null;
		stmt = null;
		encSummSql = "Select ES_SUMM_TITLE from CR_ES_SUMM_HDR where ES_SUMM_CODE = ? and ES_SUMM_STATUS = 'E' ";
		
		stmt=con.prepareStatement(encSummSql);
		stmt.setString(1,v_summ_code);		
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				v_summ_desc = rs.getString("ES_SUMM_TITLE")==null?"":rs.getString("ES_SUMM_TITLE");					
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();			
		
		System.out.println(" - v_summ_code: "+v_summ_code+" - v_summ_desc: "+v_summ_desc);
		
		// To get the Authorized Doctor Name and Speciality
		/*
		rs = null;
		stmt = null;
		authSplSql = "select practitioner_name, degree, long_desc speciality_name  from am_practitioner a, am_speciality b "+ 
				" where a.primary_speciality_code = b.speciality_code and a.practitioner_id = ? ";
		
		stmt=con.prepareStatement(authSplSql);
		stmt.setString(1,attendPractitionerId);		
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				vAuthoriseName = rs.getString("practitioner_name")==null?"":rs.getString("practitioner_name");					
				vAuthoriseDegree = rs.getString("degree")==null?"":rs.getString("degree");
				vAuthoriseBySplty = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");				
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();	
		*/
		// To get the Authorized Doctor Name and Speciality
		rs = null;
		stmt = null;
		authSplSql = "select long_desc speciality_name  from pr_encounter a, am_speciality b "+ 
				" where a.specialty_code = b.speciality_code and patient_id = ? and encounter_id = ? ";
		
		System.out.println(" - authSplSql: "+authSplSql);
		
		stmt=con.prepareStatement(authSplSql);
		stmt.setString(1,patientid);		
		stmt.setString(2,encounterid);
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{				
				vAuthoriseBySplty = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");				
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();	
		
		
	
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(printFlag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(printFlag));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(telephone1));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(telephone2));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(emailId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(address));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(website));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facilityName));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facilityImageName ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(v_summ_desc ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patientName ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(gender ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bloodGroup ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(ageInYears ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(practitionerName ));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(patientid ));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(encounterid ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(visitDateTime ));
            _bw.write(_wl_block28Bytes, _wl_block28);

									rs = null;
									stmt = null;
					
									//eCA.EncounterSummaryXMLHTML esXMLHtml = new eCA.EncounterSummaryXMLHTML();	
									eCA.EncounterSummaryXMLHTML_V2 esXMLHtml = new eCA.EncounterSummaryXMLHTML_V2();
									facilityId = (String) session.getValue("facility_id");
					
					 				//System.out.println(" - - - 1 - - - ");
					 				
					 				//cstmt=con.prepareCall("{call CA_BUILD_ENCOUNTER_SUMM(?,?,?,?,?)}");
					 				cstmt=con.prepareCall("{call CA_BUILD_ENCOUNTER_SUMM_V2(?,?,?,?,?)}");
									cstmt.setString(1,patientid);
									cstmt.setString(2,encounterid);
									cstmt.setString(3,locale);	
									cstmt.setString(4,v_summ_code);
									cstmt.registerOutParameter(5,java.sql.Types.CLOB);
									
									cstmt.execute();				
									
									//System.out.println(" - - - 2 - - - ");
									
									xmlString = cstmt.getString(5);	
									
									//System.out.println(" - - - 3 - - - ");
									
									//xmlString = " <GraphicalDisplay>	<ReportHeader referrence= 'PRYMHCK' name= 'Primary Master Health Checkup'><MainGroup referrence='CHIEFCOMPL' name='Chief Complaint' ImageUrl='' Remarks=''>	<Template referrence='1' name='NORMAL TEXT'><ResultDesc1 ResultText='Abdominal Pain' ResultVal='- None'></ResultDesc1>	</Template>	</MainGroup><MainGroup referrence='LBIOLFT004' name='Liver Function Test' ImageUrl='' Remarks=''><SubGroup referrence='BLRB' name='Bilirubin' remarks=''><Template referrence='2' name='TABLE OF INFORMATION' Columns='5'><Column> <ColumnName1>Parameter </ColumnName1> <ColumnName2> Units</ColumnName2> <ColumnName3> Result</ColumnName3> <ColumnName4> Your Value is </ColumnName4> <ColumnName5> Reference</ColumnName5></Column><RowNo><RowNo1  ColumnName1='Bilirubin Direct' ColumnName2='mg/dl' bgcolor='' ColumnName3='.2' ColumnName4='' ColumnName5='0-.3'></RowNo1><RowNo2  ColumnName1='Bilirubin Total' ColumnName2='mg/dl' bgcolor='' ColumnName3='.9' ColumnName4='' ColumnName5='.2-1.2'></RowNo2><RowNo3  ColumnName1='Bilirubin Indirect' ColumnName2='mg/dl' bgcolor='' ColumnName3='1.2' ColumnName4='' ColumnName5='-'></RowNo3></RowNo></Template></SubGroup><SubGroup referrence='ENZY' name='Enzymes' remarks=''><Template referrence='2' name='TABLE OF INFORMATION' Columns='5'><Column> <ColumnName1>Parameter </ColumnName1> <ColumnName2> Units</ColumnName2> <ColumnName3> Result</ColumnName3> <ColumnName4> Your Value is </ColumnName4> <ColumnName5> Reference</ColumnName5></Column><RowNo><RowNo1  ColumnName1='SGOT (AST)' ColumnName2='U/L' bgcolor='' ColumnName3='37' ColumnName4='' ColumnName5='0-37'></RowNo1><RowNo2  ColumnName1='Gamma GT' ColumnName2='U/L' bgcolor='H' ColumnName3='115' ColumnName4='H' ColumnName5='8-61'></RowNo2><RowNo3  ColumnName1='SGPT (ALT)' ColumnName2='U/L' bgcolor='H' ColumnName3='59' ColumnName4='H' ColumnName5='0-41'></RowNo3><RowNo4  ColumnName1='Alkaline Phosphatase' ColumnName2='U/L' bgcolor='' ColumnName3='106' ColumnName4='' ColumnName5='40-129'></RowNo4></RowNo></Template></SubGroup><SubGroup referrence='SRPRT' name='Serum Proteins' remarks=''><Template referrence='2' name='TABLE OF INFORMATION' Columns='5'><Column> <ColumnName1>Parameter </ColumnName1> <ColumnName2> Units</ColumnName2> <ColumnName3> Result</ColumnName3> <ColumnName4> Your Value is </ColumnName4> <ColumnName5> Reference</ColumnName5></Column><RowNo><RowNo1  ColumnName1='Globulin' ColumnName2='gm/dl' bgcolor='' ColumnName3='' ColumnName4='' ColumnName5='2-4'></RowNo1><RowNo2  ColumnName1='Total Protein' ColumnName2='gm/dl' bgcolor='' ColumnName3='7.6' ColumnName4='' ColumnName5='6.4-8.3'></RowNo2><RowNo3  ColumnName1='Albumin' ColumnName2='�?µmol/L' bgcolor='' ColumnName3='4.2' ColumnName4='' ColumnName5='3.5-7'></RowNo3></RowNo></Template></SubGroup></MainGroup><MainGroup referrence='CLINICEXAM' name='Clinical Examination' ImageUrl='' Remarks=''><Template referrence='5' name='NOTES'><NotesText notesType='CA' queryColumn='HIST_DATA' columnName='HIST_REC_TYPE~CONTR_SYS_ID~ACCESSION_NUM~CONTR_SYS_EVENT_CODE' columnData='CLNT~CA~CN13$0000000000002841~OPS' dataTable='CR_ENCOUNTER_DETAIL_TXT' /> </Template></MainGroup></ReportHeader></GraphicalDisplay>";
					
									if ((xmlString != null) && (xmlString.length() != 0))
									{
										System.out.println(" - - - xmlString generated - - - "+xmlString);
										
										xmlString = xmlString.replace('&', '^');
										
										htmlData = esXMLHtml.getXMLHtml(xmlString);										
										
										System.out.println(" - - - htmlData generated- - - "+htmlData);		
										strHtmlData = htmlData.toString();
										
										strHtmlData = strHtmlData.replace('^', '&');
										
									}		
					
									if(rs!=null)rs.close();
									if(stmt!=null)stmt.close();		
					
								
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strHtmlData));
            _bw.write(_wl_block30Bytes, _wl_block30);

									}
									catch(Exception e){
										out.println("Exception"+e.toString());					
									}
									finally
									{
										if(con!=null)ConnectionManager.returnConnection(con,request);
									}	
								
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(vAuthoriseName ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(vAuthoriseDegree ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(vAuthoriseBySplty ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(telephone1));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(telephone2));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(emailId));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(website));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(address));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(website));
            _bw.write(_wl_block40Bytes, _wl_block40);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
}
