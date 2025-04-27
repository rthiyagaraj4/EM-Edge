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
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __encountersummarygh_kendo_xml extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncounterSummaryGH_Kendo_XML.jsp", 1738424712110L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--[if IE 6]>  \n  <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n<![endif]-->  \n<!--[if IE 7]>  \n  <!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\">\n<![endif]-->  \n<!--[if gte IE 7]>  \n\t<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> \n<![endif]-->\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<head>\t\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" />\n\t\n\t\t<style>\n\t\tu {    \n\t\t    border-bottom: 1px dotted #000;\n\t\t    text-decoration: none;\n\t\t}\n\t\t\n\t\t.tableTemp { table-layout:fixed; }\n\t\t\n\t\ttd.thickBorder{ \n\t\t\tborder: solid #CECEC9 1px;\n\t\t\tword-break:break-all;\n\t\t}\t\t\n\t\t\n\t\t@media screen {\t\n\t\t\tdiv#footer_wrapper {       \n\t\t\t\tdisplay: none;      \n\t\t\t}   \n\t\t}\n\t\t\n\t\t\n\t\t@media print { \t\n\t\t\t.tableTemp { page-break-before:auto;page-break-inside:auto; page-break-after:auto} \n\t\t\t.breakMainTable { page-break-before:auto}\n\t\t\t.breakMainTempTable { page-break-before:auto;page-break-inside:avoid; page-break-after:auto}\n\t\t\t.lastTable { page-break-before:auto;page-break-inside:auto; page-break-after:always}  \n\t\t\t.breakTable { page-break-before:auto;page-break-inside:auto; page-break-after:auto}  \n\t\t\t.breakTrNotes    { page-break-before:auto; page-break-inside:auto; page-break-after:auto}\n\t\t\t.breakTr    { page-break-before:auto; page-break-inside:avoid; page-break-after:auto}\n\t\t\t.breakTableLC { page-break-before:avoid;page-break-inside:avoid; page-break-after:auto}  \n\t\t\t.breakTrLC    { page-break-before:auto; page-break-inside:avoid; page-break-after:auto}\n\t\t\t.breakSignTable    { page-break-before:auto; page-break-inside:avoid; page-break-after:auto}\n\t\t\t\n\t\t\t/*\n\t\t\ttfoot { \n\t\t\t\tvisibility: hidden; \n\t\t\t}  \n\t\t\t*/ \n\t\t\tth {\n\t\t\t\tfont-family:Arial;\t\t\n\t\t\t}\n\t\t\tthead {\n\t\t\t\tdisplay:table-header-group;\n\t\t\t}\n\t\t\ttbody {\n\t\t\t\tdisplay:table-row-group;\t\t\t\t\n\t\t\t}\n\t\t\ttfoot {\n\t\t\t\tdisplay:table-footer-group;\t\t\n\t\t\t}\t\n\t\t\t\n\t\t\tdiv#footer_wrapper {       \n\t\t\t\tdisplay: none;      \n\t\t\t}  \n\t\t\t\n\t\t\t/*\t\t\t\n\t\t\tdiv#footer_content {   \n\t\t\t\toverflow: hidden;\n\t\t\t\tzoom: 1;\t\t\n\t\t\t}   \n\t\t\t\n\t\t\tdiv#footer_wrapper {    \n\t\t\t\tposition: fixed;\n\t\t\t\tbottom: 0;     \n\t\t\t\tclear:both;\n\t\t\t}  \n\t\t\t*/ \t\n\t\t\t\n\t\t\tdiv#print_wrapper {       \n\t\t\t\tdisplay: none;      \n\t\t\t}\t\t\n\t\t}\n\t\t</style>\n\t</head>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\\\"></Script>\n\n\n\n\t<script>\n\t\tvar docReadyCount = 0;\n\t\tvar divCount = 0;\n\t\t\n\t\tfunction printPage(){\n\t\t\t\n\t\t\tif (";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" == \"1\")\n\t\t\t{\t\n\t\t\t\t\n\t\t\t\tdocReadyCount = docReadyCount + 1;\t\n\t\t\t\tif (docReadyCount == divCount) \n\t\t\t\t{\t\t\t\t\n\t\t\t\t\tif(PrintCommandObject)\n\t\t\t\t\t{\t\t\t\t\t\t\n\t\t\t\t\t\ttry{\t\n\t\t\t\t\t\t\tPrintCommandObject.ExecWB(6,2);\n\t\t\t\t\t \t\tPrintCommandObject.outerHTML = \"\";\n\t\t\t\t\t \t\twindow.close();\n\t\t\t\t\t \t}\n\t\t\t\t\t \tcatch(e){\t\n\t\t\t\t\t \t\twindow.print();\n\t\t\t\t\t \t}\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t \twindow.print();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t}\n\t\t\t \n\t\t\n\t\t$(document).ready(function() {\n\t\t\t\n\t\t\tdivCount = document.getElementById(\"divCount\").value;\t\n\t\t\t\n\t\t\tif (navigator.appName == \"Microsoft Internet Explorer\"){\t\t\t\n\t\t\t \t// attach and initialize print command ActiveX object\n\t\t\t\ttry{\n\t\t\t \t\tvar PrintCommand = \'<object id=\"PrintCommandObject\" classid=\"CLSID:8856F961-340A-11D0-A96B-00C04FD705A2\" width=\"0\" height=\"0\"></object>\';\t\t \t\t\n\t\t\t \t\tdocument.body.insertAdjacentHTML(\'afterbegin\', PrintCommand);\n\t\t\t\t}\n\t\t\t \tcatch(e){}\n\t\t\t}\t\n\t\t\t\t\n\t\t});\n\t\t\n\t\t$(window).load(function() \n\t\t{\t\t\n\t\t\tif (";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" == \"1\")\n\t\t\t{\t\n\t\t\t\tif (divCount == 0)\n\t\t\t\t{\t\t\n\t\t\t\t\tif(PrintCommandObject)\n\t\t\t\t\t{\n\t\t\t\t\t\ttry{\t\t\t\n\t\t\t\t\t\t\tPrintCommandObject.ExecWB(6,2);\n\t\t\t\t\t \t\tPrintCommandObject.outerHTML = \"\";\n\t\t\t\t\t \t\twindow.close();\n\t\t\t\t\t \t}\n\t\t\t\t\t \tcatch(e){\t \t\t\n\t\t\t\t\t \t\twindow.print();\n\t\t\t\t\t \t}\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t \twindow.print();\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t});\n\t\t\n\t\tfunction pagePrint(){\n\t\t\twindow.print();\t\n\t\t}\n\t</script>\n\t<body class=\'CONTENT\' scroll=\"auto\" style=\"background-color:transparent\">\n\t\t<div id=\"footer_wrapper\">   \n\t\t\t<div id=\"footer_content\">\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\t\n\t\t\t</div>\t\n\t\t</div> \n\n\t\t<form name=\"EncounterSummaryGH_form\" id=\"EncounterSummaryGH_form\">\n\t\t\t<div id=\"print_wrapper\"> \n\t\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 900px;\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<input type=\'button\' class=\'button\' name=\'print\' id=\'print\' id=\'print\' onClick=\"pagePrint()\" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'></td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\t \n\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"width: 900px\"> \n\t\t\t\t<thead>\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\t\t\t\n\t\t\t\t</thead>    \n\t\t\t\t<tbody> \n\t\t\t\t\t<tr><td>\n\t\t\t\t\t\t<div id=\"body_wrapper\">   \n\t\t\t\t\t\t\t<div id=\"body_content\" class=\"testbody\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t\t\t\t\t\t\t\t\t<!--\n\n\t\t\t\t\t\t\t\t\t<table class=\"breakTable\" align=\"center\" border=\"0\" cellpadding=\"0\"\n\t\t\t\t\t\t\t\t\t\tcellspacing=\"0\" style=\"width: 900px\">\n\t\t\t\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t\t\t\t<tr class=\"breakTrNotes\">\n\t\t\t\t\t\t\t\t\t\t\t\t<td><div id=\"EMPTY11\"> </div>\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<script> $(\'#EMPTY11\').load(\'../../eCA/jsp/ES_Notes.jsp?divID=EMPTY11&queryColumn=HIST_DATA&columnName=HIST_REC_TYPE~CONTR_SYS_ID~ACCESSION_NUM~CONTR_SYS_EVENT_CODE&columnData=LBIN~~FKH>3012001507@CULT10~CULT10&dataTable=CR_ENCOUNTER_DETAIL_TXT\', function() {});\n\t\t\t\t\t\t\t\t\t\t\t\t\t</script>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t<br><input type=\"hidden\" name=\"divCount\" id=\"divCount\" id=\"divCount\" value=1>\n\n\t\t\t\t\t\t\t\t\t-->\n\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<p>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</p>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t</div>\n\t\t\t\t\t<div>\n\t\t\t\n\t\t\t\t\t</td></tr>\t\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\t\t\n\t\t\t\t\t\t\t<table align=\"center\" border=\"0\" cellpadding=\"1\" cellspacing=\"1\" style=\"width: 900px;\">\n\t\t\t\t\t\t\t\t<tbody>\t\t\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td width=\"100%\" align=\"center\">\n\t\t\t\t\t\t\t\t\t\t\t<span style=\"font-size: 12px\"><strong><span style=\"color: #808080\"><span style=\"font-family: verdana, geneva, sans-serif\">***** End of Report *****</span></span></strong></span>\n\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\t\n\t\t\t\t\t\t\t<table  class=\'breakSignTable\' align=\'center\' border=\'0\' cellpadding=\'0\' cellspacing=\'0\' style=\'width: 900px\'> \n\t\t\t\t\t\t\t\t<tbody>\t\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<hr style=\'color:#0101DF\'/>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\t\t\t\t\t\t\t\t\t\t<td valign=\'left\' align=\'left\' width=\'300px\'>\n\t\t\t\t\t\t\t\t\t\t\t<table align=\'left\' border=\'0\' cellpadding=\'1\' cellspacing=\'1\' style=\'width: 340px\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<u><span style=\'font-size: 12px\'><strong>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\'color: #808080\'><span style=\'font-family: verdana, geneva, sans-serif\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</span></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</strong></span></u>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr><td class=\'label\'><br></td></tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr><td class=\'label\'><br></td></tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\'font-size: 12px\'><strong><span style=\'color: #808080\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\'font-family: verdana, geneva, sans-serif\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" &nbsp;&nbsp;(&nbsp; ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" &nbsp;)</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span></strong></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr><td class=\'label\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\'font-size: 12px\'><strong><span style=\'color: #808080\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<span style=\'font-family: verdana, geneva, sans-serif\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" &nbsp;</span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</span></strong></span>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</td></tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t</tbody> \n\t\t\t\t<tfoot  id=\"table_footer\"> \t\t\n\t\t\t\t\t<tr><th>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\t\t\t\t\n\t\t\t\t\t</th> </tr> \n\t\t\t\t</tfoot>\n\t\t\t</table>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );
	
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
	String demoSql = "", bloodSql = "", encounterSql = "", complaintSql = "",  orderSql = "", encSummSql="", authSplSql="", patientSql = "", headerFooterSql = "";
	String locnSql = "", payerSql = "";
	
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
	String facilityId = "", attendPractitionerId = "", visitDateTime = "", practitionerName = "", specialtyName = "";
	String locnType = "", locnCode = "", locnDesc = "";
	String payerCode ="", payerName = "";
	
	boolean encResFlag = false;
	//Facility Details
	String facilityName = "", addrLine1="", addrLine2="", addrLine3="", addrLine4="", postalCode="", countryName="";
	String telephone1="", telephone2="", telephone3="", telephone4="", fax= "";
	String emailId="", website="", address="";
	
	//Summary Details
	String v_summ_code = "", v_summ_desc = "", v_summ_type = "";
	
	//Signature Doctor Details
	String attendPractName = "", attendPractDegree = "", attendPractSplty ="";
	String admitPractName = "", admitPractDegree = "", admitPractSplty = ""; 
    String authPractName = "", authPractDegree = "", authPractSplty = ""; 

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
	char charAtEnd = '\u0000';	
	
	//Order Specific Details
	String specimenNo = "", specimenType = "", orderNo = "", orderDate="";
	String collectedDate = "", registeredDate = "", authorisedBy = "", authorisedDate="", printedDate="";

	// HTML header String
	String htmlHeaderString = "", htmlFooterString = ""; 
	int footer_sign_flag = 0, footer_sign_posn = 0; 
	String footer_sign_1_label = "", footer_sign_2_label = "", footer_sign_3_label = ""; 
	int footer_sign_1_flag = 0, footer_sign_1_practid = 0, footer_sign_1_splty = 0;
	int footer_sign_2_flag = 0, footer_sign_2_practid = 0, footer_sign_2_splty = 0;
	int footer_sign_3_flag = 0, footer_sign_3_practid = 0, footer_sign_3_splty = 0;
	int tbl_cell_color_fill = 0, tbl_cell_bborder_fill = 0; 
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	facilityId	= (String)session.getValue("facility_id");
	String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	//String patientid = org.owasp.esapi.ESAPI.encoder().encodeForHTMLAttribute(request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
	String encounterid = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	
		
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
		con	= ConnectionManager.getConnection(request);
		
		headerFooterSql = "select es_header_code, es_footer_code, es_footer_sign_flag, es_footer_sign_posn, "+				 
							" nvl(es_footer_sign_1_flag, 0) es_footer_sign_1_flag, nvl(es_footer_sign_1_label,'') es_footer_sign_1_label, "+ 
							" nvl(es_footer_sign_1_practid, 0) es_footer_sign_1_practid, nvl(es_footer_sign_1_splty, 0) es_footer_sign_1_splty, "+
							" nvl(es_footer_sign_2_flag, 0) es_footer_sign_2_flag,  nvl(es_footer_sign_2_label,'') es_footer_sign_2_label, "+
							" nvl(es_footer_sign_2_practid, 0) es_footer_sign_2_practid, nvl(es_footer_sign_2_splty, 0)  es_footer_sign_2_splty, "+
							" nvl(es_footer_sign_3_flag, 0) es_footer_sign_3_flag, nvl(es_footer_sign_3_label, '')  es_footer_sign_3_label, "+
							" nvl(es_footer_sign_3_practid, 0) es_footer_sign_3_practid, nvl(es_footer_sign_3_splty, 0) es_footer_sign_3_splty, "+
							" nvl(es_tbl_cell_color_fill,0) es_tbl_cell_color_fill, nvl(es_tbl_cell_bborder_fill,0) es_tbl_cell_bborder_fill "+
							" from cr_es_summ_layout_hdr where ES_SUMM_CODE = ?";
		
		stmt=con.prepareStatement(headerFooterSql);
		stmt.setString(1, v_summ_code);
		rs=stmt.executeQuery();
		
		if (rs!=null){
			if(rs.next())
			{
				Clob headerClob = rs.getClob("es_header_code");
				Clob footerClob  = rs.getClob("es_footer_code");
				
				if (headerClob != null) {  
			    	htmlHeaderString = headerClob.getSubString(1, (int) headerClob.length());
			   	}
				
				if (footerClob != null) {  
					htmlFooterString = footerClob.getSubString(1, (int) footerClob.length());
			   	}		
				
				footer_sign_flag = rs.getInt("es_footer_sign_flag"); 
				footer_sign_posn = rs.getInt("es_footer_sign_posn");   
				
				footer_sign_1_flag =  rs.getInt("es_footer_sign_1_flag");  
				footer_sign_1_label = rs.getString("es_footer_sign_1_label")==null?"":rs.getString("es_footer_sign_1_label"); 
				footer_sign_1_practid =  rs.getInt("es_footer_sign_1_practid");  
				footer_sign_1_splty =  rs.getInt("es_footer_sign_1_splty"); 
				
				footer_sign_2_flag =  rs.getInt("es_footer_sign_2_flag");  
				footer_sign_2_label = rs.getString("es_footer_sign_2_label")==null?"":rs.getString("es_footer_sign_2_label"); 
				footer_sign_2_practid =  rs.getInt("es_footer_sign_2_practid");  
				footer_sign_2_splty =  rs.getInt("es_footer_sign_2_splty");  
				
				footer_sign_3_flag =  rs.getInt("es_footer_sign_3_flag");  
				footer_sign_3_label = rs.getString("es_footer_sign_3_label")==null?"":rs.getString("es_footer_sign_3_label"); 
				footer_sign_3_practid =  rs.getInt("es_footer_sign_3_practid");  
				footer_sign_3_splty =  rs.getInt("es_footer_sign_3_splty");  
				
				tbl_cell_color_fill = rs.getInt("es_tbl_cell_color_fill");  
				tbl_cell_bborder_fill = rs.getInt("es_tbl_cell_bborder_fill");  
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
		
		// To get the Facility Information
		demoSql="select facility_name, addr_line1, addr_line2, addr_line3, addr_line4, addr_postal_code, tel_no1, tel_no2, tel_no3, tel_no4, fax_no, email_id, website_id, "+
					" long_name country_name, facility_logo, facility_image_file_name  from sm_facility_param a, mp_country b "+
					" where facility_id = ? and a.country_code = b.country_code(+)  ";
		stmt=con.prepareStatement(demoSql);
		stmt.setString(1,facilityId);

		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				facilityName = rs.getString("facility_name")==null?"":rs.getString("facility_name");
				addrLine1 = rs.getString("addr_line1")==null?"":rs.getString("addr_line1");
				addrLine2 = rs.getString("addr_line2")==null?"":rs.getString("addr_line2");
				addrLine3 = rs.getString("addr_line3")==null?"":rs.getString("addr_line3");
				addrLine4 = rs.getString("addr_line4")==null?"":rs.getString("addr_line4");
				postalCode = rs.getString("addr_postal_code")==null?"":rs.getString("addr_postal_code");
				telephone1 = rs.getString("tel_no1")==null?"":rs.getString("tel_no1");
				telephone2 = rs.getString("tel_no2")==null?"":rs.getString("tel_no2");
				telephone3 = rs.getString("tel_no3")==null?"":rs.getString("tel_no3");
				telephone4 = rs.getString("tel_no4")==null?"":rs.getString("tel_no4");
				fax = rs.getString("fax_no")==null?"":rs.getString("fax_no");
				emailId = rs.getString("email_id")==null?"":rs.getString("email_id");
				website = rs.getString("website_id")==null?"":rs.getString("website_id");
				countryName = rs.getString("country_name")==null?"":rs.getString("country_name");
				blobImage = rs.getBlob("facility_logo");   
				facilityImageName = rs.getString("facility_image_file_name")==null?"":rs.getString("facility_image_file_name");				

				if (addrLine1.length()>0){
					charAtEnd = addrLine1.charAt(addrLine1.length() - 1);
					if (!(charAtEnd == ','))
					{
						addrLine1 += ',';
							
					}
				}
				
				if (addrLine2.length()>0){
					charAtEnd = addrLine2.charAt(addrLine2.length() - 1);
					if (!(charAtEnd == ',')){
						addrLine2 += ',';
					}
				}

				if (addrLine3.length()>0){
					charAtEnd = addrLine3.charAt(addrLine3.length() - 1);
					if (!(charAtEnd == ',')){
						addrLine3 += ',';
					}
				}
				
				if (addrLine4.length()>0){
					charAtEnd = addrLine4.charAt(addrLine4.length() - 1);
					if (!(charAtEnd == ',')){
						addrLine4 += ',';
					}
				}
				
				address = addrLine1 + " " + addrLine2 +" "+ addrLine3 + " " + addrLine4+ " " + postalCode + " " +countryName +".";

			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();

		/** BLOB to Image **/
		
		long blobLength = blobImage.length();

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
				
				filecreate = new File(filename);			
				if(!filecreate.exists())
				{
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
				//out.println("<h3> Exception raise by Servlet ...Error in getting image file path </h3> Foll: Error Received : "+e.toString());//COMMON-ICN-0181
				e.printStackTrace();
			}
			catch ( Exception e )
			{
				//out.println("<h3> Exception raise by Servlet ...Error in getting image file path </h3> Foll: Error Received : "+e.toString());//COMMON-ICN-0181
				e.printStackTrace();
			}
		}
		// To get the Patient Demographic Information
		demoSql="select patient_id, name_prefix, first_name, second_name, third_name, family_name, sex, to_char(date_of_birth, 'dd/MM/YYYY') date_of_birth, "+
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
		encounterSql = "select facility_id, encounter_id, attend_practitioner_id, to_char(visit_adm_date_time, 'DD MON YYYY') visit_date_time, practitioner_name, "+ 
						" assign_care_locn_type, assign_care_locn_code "+
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
				locnType = rs.getString("assign_care_locn_type")==null?"":rs.getString("assign_care_locn_type");
				locnCode = rs.getString("assign_care_locn_code")==null?"":rs.getString("assign_care_locn_code");
				encResFlag = true;
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();		
		
		if ((locnType.equalsIgnoreCase("n")) || (locnType.equalsIgnoreCase("c"))){
			if (locnType.equalsIgnoreCase("n")) {
				locnSql = "select nursing_unit_code, long_desc, short_desc  from ip_nursing_unit where facility_id = ? and nursing_unit_code = ? ";
			}
			else if (locnType.equalsIgnoreCase("c")){
				locnSql = "select clinic_code, long_desc, short_desc from op_clinic where facility_id = ? and clinic_code = ? ";
			}
			stmt=con.prepareStatement(locnSql);
			stmt.setString(1,facilityId);
			stmt.setString(2,locnCode);
			rs=stmt.executeQuery();
	
			if (rs!=null){
				if(rs.next())
				{
					locnDesc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
				}
			}		
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();		
		}
		
		// To get the Patient Payer Details
		rs = null;
		stmt = null;
		payerSql = "Select a.cust_code, b.long_name, b.short_name from bl_episode_fin_dtls a, ar_customer b "+ 
						" where patient_id = ? and encounter_id = ? "+
						" and a.cust_code = b.cust_code ";
		stmt=con.prepareStatement(payerSql);
		stmt.setString(1,patientid);
		stmt.setString(2,encounterid);
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				payerCode = rs.getString("cust_code")==null?"":rs.getString("cust_code");
				payerName = rs.getString("long_name")==null?"":rs.getString("long_name");
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();		
		
		// To get the Encounter Summary title
		rs = null;
		stmt = null;
		encSummSql = "Select ES_SUMM_TITLE, ES_SUMM_TYPE from CR_ES_SUMM_HDR where ES_SUMM_CODE = ? and ES_SUMM_STATUS = 'E' ";
		
		stmt=con.prepareStatement(encSummSql);
		stmt.setString(1,v_summ_code);		
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{
				v_summ_desc = rs.getString("ES_SUMM_TITLE")==null?"":rs.getString("ES_SUMM_TITLE");	
				v_summ_type = rs.getString("ES_SUMM_TYPE")==null?"":rs.getString("ES_SUMM_TYPE");	
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();			
		
		//Singature Doctor Name, Speciality			
		rs = null;
		stmt = null;
		authSplSql = "select facility_id, encounter_id, "+ 
						" attend_practitioner_id,  nvl(b.practitioner_name,'') attend_pract_name,  nvl(b.degree,'') attend_pract_degree, nvl(e.long_desc,'') attend_splty_name, "+
						" admit_practitioner_id, nvl(c.practitioner_name,'') admit_pract_name, nvl(c.degree,'') admit_pract_degree, nvl(f.long_desc,'') admit_splty_name, "+
						" disp_auth_practitioner_id,  nvl(d.practitioner_name,'') auth_pract_name, nvl(d.degree,'') auth_pract_degree, nvl(g.long_desc,'') auth_splty_name "+
					" from pr_encounter a, am_practitioner b, am_practitioner c, am_practitioner d, am_speciality e, am_speciality f, am_speciality g "+
					" where attend_practitioner_id = b.practitioner_id "+
							" and admit_practitioner_id = c.practitioner_id(+) "+
							" and disp_auth_practitioner_id = d.practitioner_id(+) "+
							" and b.primary_speciality_code = e.speciality_code(+) "+
							" and c.primary_speciality_code = f.speciality_code(+) "+
							" and d.primary_speciality_code = g.speciality_code(+) "+
							" and patient_id = ? and encounter_id = ? ";
		
		stmt=con.prepareStatement(authSplSql);
		stmt.setString(1,patientid);
		stmt.setString(2,encounterid);
		rs=stmt.executeQuery();
		
		if (rs!=null){
			if(rs.next())
			{
				attendPractName = rs.getString("attend_pract_name")==null?"":rs.getString("attend_pract_name");					
				attendPractDegree = rs.getString("attend_pract_degree")==null?"":rs.getString("attend_pract_degree");
				attendPractSplty = rs.getString("attend_splty_name")==null?"":rs.getString("attend_splty_name");
				
				admitPractName = rs.getString("admit_pract_name")==null?"":rs.getString("admit_pract_name");					
				admitPractDegree = rs.getString("admit_pract_degree")==null?"":rs.getString("admit_pract_degree");
				admitPractSplty = rs.getString("admit_splty_name")==null?"":rs.getString("admit_splty_name");
				
				authPractName = rs.getString("auth_pract_name")==null?"":rs.getString("auth_pract_name");					
				authPractDegree = rs.getString("auth_pract_degree")==null?"":rs.getString("auth_pract_degree");
				authPractSplty = rs.getString("auth_splty_name")==null?"":rs.getString("auth_splty_name");
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();	
		
		// To get the Authorized Doctor Name and Speciality
		rs = null;
		stmt = null;
		authSplSql = "select long_desc speciality_name  from pr_encounter a, am_speciality b "+ 
				" where a.specialty_code = b.speciality_code and patient_id = ? and encounter_id = ? ";
		
		stmt=con.prepareStatement(authSplSql);
		stmt.setString(1,patientid);		
		stmt.setString(2,encounterid);
		rs=stmt.executeQuery();

		if (rs!=null){
			if(rs.next())
			{				
				specialtyName = rs.getString("speciality_name")==null?"":rs.getString("speciality_name");				
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();		
		
		// Order related information
		rs = null;
		stmt = null;
		
		if (v_summ_type.equalsIgnoreCase("rdin")){
			orderSql = " select a.patient_id, a.encounter_id, a.order_id, to_char(c.ord_date_time, 'DD/MM/YYYY') ord_date_time, "+ 
						" null specimen_no, null spec_colltd_date_time, null spec_regd_date_time, null specimen_type_code, null specimen_desc, "+
						" physician_id verified_by_id, null verified_date, null result_printed_date "+
						" from rd_request a, or_order c "+
						" where a.patient_id = ? and a.encounter_id = ?   "+
						" and a.added_date in (select max(added_date) from rd_request d "+ 
	                                			" where d.patient_id = a.patient_id and d.encounter_id = a.encounter_id) "+
	                    " and a.order_id = c.order_id ";
		}
		else
		{
			orderSql = " select a.patient_id, a.encounter_id, a.order_id, to_char(c.ord_date_time, 'DD/MM/YYYY') ord_date_time, "+ 
						" specimen_no, to_char(spec_colltd_date_time, 'DD/MM/YYYY') spec_colltd_date_time, to_char(spec_regd_date_time, 'DD/MM/YYYY') spec_regd_date_time, "+
						" a.specimen_type_code, b.specimen_desc, "+
						" verified_by_id, to_char(verified_date, 'DD/MM/YYYY') verified_date, to_char(result_printed_date, 'DD/MM/YYYY') result_printed_date "+
						" from rl_request_header a, rl_specimen_type_code b, or_order c "+
						" where a.patient_id = ? and a.encounter_id = ?   "+
						" and a.added_date in (select max(added_date) from rl_request_header d "+ 
	                                			" where d.patient_id = a.patient_id and d.encounter_id = a.encounter_id) "+
						" and a.specimen_type_code = b.specimen_type_code "+
	                    " and a.order_id = c.order_id ";
		}
		
		stmt=con.prepareStatement(orderSql);
		stmt.setString(1,patientid);		
		stmt.setString(2,encounterid);
		rs=stmt.executeQuery();
		
		if (rs!=null){
			if(rs.next())
			{	
				orderNo 		= rs.getString("order_id")==null?"":rs.getString("order_id");
				orderDate 		= rs.getString("ord_date_time")==null?"":rs.getString("ord_date_time");
				specimenNo 		= rs.getString("specimen_no")==null?"":rs.getString("specimen_no");	
				specimenType 	= rs.getString("specimen_desc")==null?"":rs.getString("specimen_desc");	
					
				collectedDate 	= rs.getString("spec_colltd_date_time")==null?"":rs.getString("spec_colltd_date_time");	
				registeredDate 	= rs.getString("spec_regd_date_time")==null?"":rs.getString("spec_regd_date_time");	
				authorisedBy 	= rs.getString("verified_by_id")==null?"":rs.getString("verified_by_id");	
				authorisedDate 	= rs.getString("verified_date")==null?"":rs.getString("verified_date");	
				printedDate 	= rs.getString("result_printed_date")==null?"":rs.getString("result_printed_date");						
			}
		}		
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();	
		
		if (htmlHeaderString.length() > 0){
		
			htmlHeaderString =  htmlHeaderString.replace("XYZ", "#"); 
			htmlHeaderString =  htmlHeaderString.replace("^", "'"); 
			htmlHeaderString =  htmlHeaderString.replace("*", "&"); 
			htmlHeaderString =  htmlHeaderString.replace("facilityName", facilityName); 
			htmlHeaderString =  htmlHeaderString.replace("facilityImageName", facilityImageName);
			htmlHeaderString =  htmlHeaderString.replace("address", address);
			htmlHeaderString =  htmlHeaderString.replace("telephone1", telephone1);
			htmlHeaderString =  htmlHeaderString.replace("telephone2", telephone2);
			htmlHeaderString =  htmlHeaderString.replace("telephone3", telephone3);
			htmlHeaderString =  htmlHeaderString.replace("telephone4", telephone4);
			htmlHeaderString =  htmlHeaderString.replace("fax", fax);
			htmlHeaderString =  htmlHeaderString.replace("emailId", emailId);
			htmlHeaderString =  htmlHeaderString.replace("website", website);
			
			htmlHeaderString =  htmlHeaderString.replace("patientName", patientName);
			htmlHeaderString =  htmlHeaderString.replace("gender", gender);
			htmlHeaderString =  htmlHeaderString.replace("bloodGroup", bloodGroup);
			htmlHeaderString =  htmlHeaderString.replace("dateOfBirth", dateOfBirth);
			htmlHeaderString =  htmlHeaderString.replace("ageInYears", ageInYears);
			htmlHeaderString =  htmlHeaderString.replace("practitionerName", practitionerName);
			htmlHeaderString =  htmlHeaderString.replace("payerName", payerName);
			
			htmlHeaderString =  htmlHeaderString.replace("patientid", patientid);
			htmlHeaderString =  htmlHeaderString.replace("encounterid", encounterid);
			htmlHeaderString =  htmlHeaderString.replace("visitDateTime", visitDateTime);
			htmlHeaderString =  htmlHeaderString.replace("specialtyName", specialtyName);
			htmlHeaderString =  htmlHeaderString.replace("locationName", locnDesc);
			
			htmlHeaderString =  htmlHeaderString.replace("specimenNo", specimenNo);
			htmlHeaderString =  htmlHeaderString.replace("specimenType", specimenType);
			htmlHeaderString =  htmlHeaderString.replace("orderNo", orderNo);
			htmlHeaderString =  htmlHeaderString.replace("orderDate", orderDate);
			htmlHeaderString =  htmlHeaderString.replace("collectedDate", collectedDate);
			htmlHeaderString =  htmlHeaderString.replace("registeredDate", registeredDate);			
			htmlHeaderString =  htmlHeaderString.replace("authorisedBy", authorisedBy);
			htmlHeaderString =  htmlHeaderString.replace("authorisedDate", authorisedDate);
			htmlHeaderString =  htmlHeaderString.replace("printedDate", printedDate);
			
			htmlHeaderString =  htmlHeaderString.replace("v_summ_desc", v_summ_desc);		
		
		}
		
		if (htmlFooterString.length() > 0){
		
			htmlFooterString =  htmlFooterString.replace("XYZ", "#"); 
			htmlFooterString =  htmlFooterString.replace("^", "'"); 
			htmlFooterString =  htmlFooterString.replace("*", "&"); 
			htmlFooterString =  htmlFooterString.replace("facilityName", facilityName); 
			htmlFooterString =  htmlFooterString.replace("facilityImageName", facilityImageName);
			htmlFooterString =  htmlFooterString.replace("address", address);
			htmlFooterString =  htmlFooterString.replace("telephone1", telephone1);
			htmlFooterString =  htmlFooterString.replace("telephone2", telephone2);
			htmlFooterString =  htmlFooterString.replace("telephone3", telephone3);
			htmlFooterString =  htmlFooterString.replace("telephone4", telephone4);
			htmlFooterString =  htmlFooterString.replace("fax", fax);
			htmlFooterString =  htmlFooterString.replace("emailId", emailId);
			htmlFooterString =  htmlFooterString.replace("website", website);
			
			htmlFooterString =  htmlFooterString.replace("patientName", patientName);
			htmlFooterString =  htmlFooterString.replace("gender", gender);
			htmlFooterString =  htmlFooterString.replace("bloodGroup", bloodGroup);
			htmlFooterString =  htmlFooterString.replace("dateOfBirth", dateOfBirth);
			htmlFooterString =  htmlFooterString.replace("ageInYears", ageInYears);
			htmlFooterString =  htmlFooterString.replace("practitionerName", practitionerName);
			htmlFooterString =  htmlFooterString.replace("payerName", payerName);
			
			htmlFooterString =  htmlFooterString.replace("patientid", patientid);
			htmlFooterString =  htmlFooterString.replace("encounterid", encounterid);
			htmlFooterString =  htmlFooterString.replace("visitDateTime", visitDateTime);
			htmlFooterString =  htmlFooterString.replace("specialtyName", specialtyName);
			htmlFooterString =  htmlFooterString.replace("locationName", locnDesc);
			
			htmlFooterString =  htmlFooterString.replace("specimenNo", specimenNo);
			htmlFooterString =  htmlFooterString.replace("specimenType", specimenType);
			htmlFooterString =  htmlFooterString.replace("orderNo", orderNo);
			htmlFooterString =  htmlFooterString.replace("orderDate", orderDate);
			htmlFooterString =  htmlFooterString.replace("collectedDate", collectedDate);
			htmlFooterString =  htmlFooterString.replace("registeredDate", registeredDate);			
			htmlFooterString =  htmlFooterString.replace("authorisedBy", authorisedBy);
			htmlFooterString =  htmlFooterString.replace("authorisedDate", authorisedDate);
			htmlFooterString =  htmlFooterString.replace("printedDate", printedDate);
		    
		    htmlFooterString =  htmlFooterString.replace("attendPractName", attendPractName);
			htmlFooterString =  htmlFooterString.replace("attendPractDegree", attendPractDegree);
			htmlFooterString =  htmlFooterString.replace("attendPractSplty", attendPractSplty);
			htmlFooterString =  htmlFooterString.replace("admitPractName", admitPractName);
			htmlFooterString =  htmlFooterString.replace("admitPractDegree", admitPractDegree);
			htmlFooterString =  htmlFooterString.replace("admitPractSplty", admitPractSplty);			
			htmlFooterString =  htmlFooterString.replace("authPractName", authPractName);
			htmlFooterString =  htmlFooterString.replace("authPractDegree", authPractDegree);
			htmlFooterString =  htmlFooterString.replace("authPractSplty", authPractSplty);
			
			htmlFooterString =  htmlFooterString.replace("v_summ_desc", v_summ_desc);	
		}
		
	
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(printFlag));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(printFlag));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( htmlFooterString));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( htmlHeaderString));
            _bw.write(_wl_block12Bytes, _wl_block12);

									rs = null;
									stmt = null;
					
									//eCA.EncounterSummaryXMLHTML esXMLHtml = new eCA.EncounterSummaryXMLHTML();	
									//eCA.EncounterSummaryXMLHTML_V2 esXMLHtml = new eCA.EncounterSummaryXMLHTML_V2();
									eCA.EncounterSummaryXMLHTML_V3 esXMLHtml = new eCA.EncounterSummaryXMLHTML_V3();
									facilityId = (String) session.getValue("facility_id");

									System.out.println(patientid + " ::: " + encounterid + " ::: " + locale + " ::: " + v_summ_code);
					
					 				//cstmt=con.prepareCall("{call CA_BUILD_ENCOUNTER_SUMM(?,?,?,?,?)}");
					 				//cstmt=con.prepareCall("{call CA_BUILD_ENCOUNTER_SUMM_V2(?,?,?,?,?)}");


									cstmt=con.prepareCall("{call CA_BUILD_ENCOUNTER_SUMM_V3(?,?,?,?,?)}");
									cstmt.setString(1,patientid);
									cstmt.setString(2,encounterid);
									cstmt.setString(3,locale);	
									cstmt.setString(4,v_summ_code);
									cstmt.registerOutParameter(5,java.sql.Types.CLOB);
									
									cstmt.execute();				
									
									xmlString = cstmt.getString(5);	

									/*
									
									xmlString = "<GraphicalDisplay><ReportHeader referrence= 'HealthCheck' name= 'Executive Health Check'><MainGroup referrence= 'CHIEFCOMPL' name= 'Chief Complaint' ImageUrl='' Remarks=''><Template referrence='1' name='Textual'><ResultDesc1 ResultText='Chest Pain' ResultVal='- None' /></Template></MainGroup><MainGroup referrence= 'VITALINF' name= 'Vital Information' ImageUrl='' Remarks=''><Template referrence='1' name='Textual'><ResultDesc1 ResultText='Temperature' ResultVal=''></ResultDesc1><ResultDesc2 ResultText='Pulse' ResultVal='72/min'></ResultDesc2><ResultDesc3 ResultText='Respiratory Rate' ResultVal=''></ResultDesc3><ResultDesc4 ResultText='Height' ResultVal='173 cms'></ResultDesc4><ResultDesc5 ResultText='Weight' ResultVal='63 Kg'></ResultDesc5></Template><Group EG2='1' referrence= 'BLP' name = 'Blood Pressure' UOM='mmHG' remarks=''><SubGroup referrence= 'SP' name = 'Systolic BP' remarks=''><Template referrence='3' name='Linear Gauge'><TemplateRange  RangeFrom='90' RangeTo='150' TemplateSplit='3'><TemplateSplit1 RangeFrom='90' RangeTo='120' bgcolor='Green'></TemplateSplit1><TemplateSplit2 RangeFrom='120' RangeTo='140' bgcolor='Yellow'></TemplateSplit2><TemplateSplit3 RangeFrom='140' RangeTo='150' bgcolor='Red'></TemplateSplit3></TemplateRange><ResultVal Result='140' bgcolor='Red' ResultStr='Your Value is Pre-Hypertension' > </ResultVal><ResultNormal    ResultNormal='Optimum :90-120'> </ResultNormal></Template></SubGroup><SubGroup referrence= 'DP' name = 'Diastolic BP' remarks=''> <Template referrence='3' name='Linear Gauge'><TemplateRange  RangeFrom='60' RangeTo='90' TemplateSplit='2'><TemplateSplit1 RangeFrom='60' RangeTo='80' bgcolor='Green'></TemplateSplit1><TemplateSplit2 RangeFrom='80' RangeTo='90' bgcolor='Yellow'></TemplateSplit2></TemplateRange><ResultVal Result='80' bgcolor='Green' ResultStr='Your Value is Optimal' > </ResultVal><ResultNormal    ResultNormal='Optimum :60-80'> </ResultNormal></Template></SubGroup><SubGroup referrence= 'BP' name = 'General BP' remarks=''><Template referrence='3' name='Linear Gauge'><TemplateRange  RangeFrom='80' RangeTo='220' TemplateSplit='3'><TemplateSplit1 RangeFrom='80' RangeTo='120' bgcolor='Green'></TemplateSplit1><TemplateSplit2 RangeFrom='120' RangeTo='140' bgcolor='Yellow'></TemplateSplit2><TemplateSplit3 RangeFrom='140' RangeTo='220' bgcolor='Red'></TemplateSplit3></TemplateRange><ResultVal Result='120' bgcolor='Green' ResultStr='Your Value is Optimal' > </ResultVal><ResultNormal ResultNormal='Optimum :80-120'> </ResultNormal></Template></SubGroup></Group></MainGroup><MainGroup referrence= 'LIVFUNC' name= 'Liver Function Test' ImageUrl='' Remarks='This test help assess the health of the Liver. Infections, alcoholism, cancer and drug damage are usual causes for liver Diseases.'><Group G1='1' referrence='PHYSICEXAM' name='31/05/2012 - Physical Examin' UOM='Milli Liter' remarks=''><SubGroup ES1='1' referrence='EMPTY' name='EMPTY' remarks=''><Template referrence='2' name='TABLE OF INFORMATION' Columns='5'><ColumnType><ColumnType1>P</ColumnType1><ColumnType2>U</ColumnType2><ColumnType3>V</ColumnType3><ColumnType4>Y</ColumnType4><ColumnType5>R</ColumnType5></ColumnType><Column><ColumnName1>Parameter</ColumnName1><ColumnName2>Units</ColumnName2><ColumnName3>Values</ColumnName3><ColumnName4>Your value is </ColumnName4><ColumnName5>Reference</ColumnName5></Column><RowNo><RowNo1  ColumnName1='Quantity' ColumnName2='Milli Liter' bgcolor='' ColumnName3='20 ml' ColumnName4='Normal' ColumnName5='-' MethodName=''></RowNo1><RowNo2  ColumnName1='Reaction (pH)' ColumnName2='' bgcolor='' ColumnName3='5.0' ColumnName4='Normal' ColumnName5='-' MethodName=''></RowNo2><RowNo3  ColumnName1='Specific Gravity' ColumnName2='' bgcolor='' ColumnName3='1.015' ColumnName4='Normal' ColumnName5='-' MethodName=''></RowNo3></RowNo></Template></SubGroup></Group></MainGroup><MainGroup referrence= 'LIPIDPF' name= 'Lipid Profile Test' ImageUrl='LipidProfile.gif' Remarks='Lipid Profile function test'><Group EG2='1'  referrence= 'LDL' name = 'LDL or Bad Cholestrol' UOM='mg/dl' numericresult='116' bgcolor='yellow' remarks='LDL Description to displayed here'><SubGroup referrence= 'LDL' name = 'LDL or Bad Cholestrol' remarks='LDL Description to displayed here'><Template referrence='3' name='Linear Gauge'><TemplateRange  RangeFrom='40' RangeTo='200' TemplateSplit='3'><TemplateSplit1 RangeFrom='40' RangeTo='100' bgcolor='Green'>  </TemplateSplit1><TemplateSplit2 RangeFrom='100' RangeTo='130' bgcolor='Yellow'>  </TemplateSplit2><TemplateSplit3 RangeFrom='130' RangeTo='160' bgcolor='Red'>  </TemplateSplit3></TemplateRange><ResultVal Result='116' bgcolor='Yellow' ResultStr='Your Value is Near Optimum' > </ResultVal><ResultNormal ResultNormal='Optimum :0-100'> </ResultNormal></Template></SubGroup><SubGroup referrence= 'HDL' name = 'HDL or Good Cholestrol' remarks='HDL Description to displayed here'><Template referrence='3' name='Linear Gauge'><TemplateRange  RangeFrom='10' RangeTo='140' TemplateSplit='3'><TemplateSplit1 RangeFrom='10' RangeTo='40' bgcolor='red'>  </TemplateSplit1><TemplateSplit2 RangeFrom='40' RangeTo='60' bgcolor='yellow'>  </TemplateSplit2><TemplateSplit3 RangeFrom='60' RangeTo='140' bgcolor='green'>  </TemplateSplit3></TemplateRange><ResultVal Result='69' bgcolor='green' ResultStr='Your Value is Near Optimum' > </ResultVal><ResultNormal ResultNormal='Optimum :60-120'> </ResultNormal></Template></SubGroup><SubGroup referrence= '' name = 'Cholestrol' remarks='LDL Description to displayed here'><Template referrence='3' name='Linear Gauge'><TemplateRange  RangeFrom='20' RangeTo='280' TemplateSplit='3'><TemplateSplit1 RangeFrom='20' RangeTo='200' bgcolor='green'>  </TemplateSplit1><TemplateSplit2 RangeFrom='200' RangeTo='239' bgcolor='yellow'>  </TemplateSplit2><TemplateSplit3 RangeFrom='240' RangeTo='280' bgcolor='red'>  </TemplateSplit3></TemplateRange><ResultVal Result='100' bgcolor='green' ResultStr='Your Value is Near Optimum' > </ResultVal><ResultNormal ResultNormal='Optimum :20-200'> </ResultNormal></Template></SubGroup></Group></MainGroup><MainGroup referrence= 'VITLINF' name= 'Vitals Information' ImageUrl='Vitals.gif' Remarks='Vitals Recorded'><Group referrence= 'TEMP1' name = 'Temperature' UOM='Celius' remarks=''><SubGroup referrence= 'TEMP1' name = 'Temperature' remarks=''><Template referrence='4' name='Line Graph'><TemplateRange RangeFrom='32' RangeTo='60' TemplateSplit='3' ><TemplateSplit1 RangeFrom='32' RangeTo='40' bgcolor='green'>  </TemplateSplit1><TemplateSplit2 RangeFrom='40' RangeTo='49' bgcolor='yellow'>  </TemplateSplit2><TemplateSplit3 RangeFrom='49' RangeTo='60' bgcolor='red'>  </TemplateSplit3></TemplateRange><ValueRange dataPlot='3' xDataType='Date' yDataType='Temperature'><GraphValue1 xAxis='2013/01/01' yAxis='45'/><GraphValue2 xAxis='2013/01/02' yAxis='42'/><GraphValue3 xAxis='2013/01/03' yAxis='46'/></ValueRange></Template></SubGroup><SubGroup referrence= 'PULSE' name = 'Pulse' remarks=''><Template referrence='4' name='Line Graph'><TemplateRange RangeFrom='40' RangeTo='120' TemplateSplit='2' ><TemplateSplit1 RangeFrom='60' RangeTo='80' bgcolor='green'>  </TemplateSplit1><TemplateSplit2 RangeFrom='80' RangeTo='110' bgcolor='red'>  </TemplateSplit2></TemplateRange><ValueRange dataPlot='2' xDataType='Date' yDataType='Pulse'><GraphValue1 xAxis='2013/01/01' yAxis='70'/><GraphValue2 xAxis='2013/01/02' yAxis='72'/></ValueRange></Template></SubGroup></Group></MainGroup><MainGroup referrence= 'NOTES' name='NOTES' ImageUrl='' Remarks=''><Template referrence='5' name='Notes'><NotesText notesType='LB' queryColumn='HIST_DATA' columnName='HIST_REC_TYPE~CONTR_SYS_ID~ACCESSION_NUM~CONTR_SYS_EVENT_CODE' columnData='LBIN~LB~FKH#3012009984@CULT10~CULT10' dataTable='CR_ENCOUNTER_DETAIL_TXT' /></Template></MainGroup></ReportHeader></GraphicalDisplay>";

									*/

									System.out.println(" ************************************************************************************************** ");				
									
									System.out.println(xmlString);

					
									if ((xmlString != null) && (xmlString.length() != 0))
									{
										xmlString = xmlString.replace('&', '^');
										
										htmlData = esXMLHtml.getXMLHtml(xmlString, tbl_cell_color_fill, tbl_cell_bborder_fill);										
										
										strHtmlData = htmlData.toString();
										
										strHtmlData = strHtmlData.replace('^', '&');
										
									}	

									//System.out.println(" ************************************************************************************************** ");

									//System.out.println(strHtmlData);

									//System.out.println(" ************************************************************************************************** ");

								
            _bw.write(_wl_block13Bytes, _wl_block13);

					
									if(rs!=null)rs.close();
									if(stmt!=null)stmt.close();		
					
								
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strHtmlData));
            _bw.write(_wl_block15Bytes, _wl_block15);

									}
									catch(Exception e){
									//	out.println("Exception"+e.toString());	//COMMON-ICN-0181
                                                                             e.printStackTrace();//COMMON-ICN-0181				
									}
									finally
									{
										if(con!=null)ConnectionManager.returnConnection(con,request);
									}	
								
            _bw.write(_wl_block16Bytes, _wl_block16);
					
					if (footer_sign_flag > 0){
						if (footer_sign_posn > 0){
							if ((footer_sign_1_flag > 0) || (footer_sign_2_flag > 0) || (footer_sign_3_flag > 0))
							{
					
            _bw.write(_wl_block17Bytes, _wl_block17);
 
									if (footer_sign_1_flag > 0){
									
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(footer_sign_1_label ));
            _bw.write(_wl_block19Bytes, _wl_block19);

															if (footer_sign_1_practid == 1){
															
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(attendPractName));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(attendPractDegree));
            _bw.write(_wl_block22Bytes, _wl_block22);

															}															 
															if (footer_sign_1_practid == 2){
											 				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(admitPractName));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(admitPractDegree));
            _bw.write(_wl_block22Bytes, _wl_block22);

															}
															if (footer_sign_1_practid == 3){
											 				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(authPractName));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(authPractDegree));
            _bw.write(_wl_block22Bytes, _wl_block22);

															}
															
            _bw.write(_wl_block23Bytes, _wl_block23);

													if (footer_sign_1_splty == 1){
													
            _bw.write(_wl_block24Bytes, _wl_block24);

														if (footer_sign_1_practid == 1){
														
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(attendPractSplty));
            _bw.write(_wl_block26Bytes, _wl_block26);

														}
														if (footer_sign_1_practid == 2){
														
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(admitPractSplty));
            _bw.write(_wl_block26Bytes, _wl_block26);

														}
														if (footer_sign_1_practid == 3){
														
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(authPractSplty));
            _bw.write(_wl_block26Bytes, _wl_block26);

														}
														
            _bw.write(_wl_block27Bytes, _wl_block27);

													}
													
            _bw.write(_wl_block28Bytes, _wl_block28);
										
									}
									
            _bw.write(_wl_block29Bytes, _wl_block29);
 
									if (footer_sign_2_flag > 0){
									
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(footer_sign_2_label ));
            _bw.write(_wl_block19Bytes, _wl_block19);

															if (footer_sign_2_practid == 1){
															
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(attendPractName));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(attendPractDegree));
            _bw.write(_wl_block22Bytes, _wl_block22);

															}															 
															if (footer_sign_2_practid == 2){
											 				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(admitPractName));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(admitPractDegree));
            _bw.write(_wl_block22Bytes, _wl_block22);

															}
															if (footer_sign_2_practid == 3){
											 				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(authPractName));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(authPractDegree));
            _bw.write(_wl_block22Bytes, _wl_block22);

															}
															
            _bw.write(_wl_block23Bytes, _wl_block23);

														if (footer_sign_2_splty == 1){
													
            _bw.write(_wl_block24Bytes, _wl_block24);

														if (footer_sign_2_practid == 1){
														
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(attendPractSplty));
            _bw.write(_wl_block26Bytes, _wl_block26);

														}
														if (footer_sign_2_practid == 2){
														
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(admitPractSplty));
            _bw.write(_wl_block26Bytes, _wl_block26);

														}
														if (footer_sign_2_practid == 3){
														
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(authPractSplty));
            _bw.write(_wl_block26Bytes, _wl_block26);

														}
														
            _bw.write(_wl_block27Bytes, _wl_block27);

													}
													
            _bw.write(_wl_block28Bytes, _wl_block28);
										
									}
									
            _bw.write(_wl_block30Bytes, _wl_block30);
 
									if (footer_sign_3_flag > 0){
									
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(footer_sign_3_label ));
            _bw.write(_wl_block19Bytes, _wl_block19);

															if (footer_sign_3_practid == 1){
															
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(attendPractName));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(attendPractDegree));
            _bw.write(_wl_block22Bytes, _wl_block22);

															}															 
															if (footer_sign_3_practid == 2){
											 				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(admitPractName));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(admitPractDegree));
            _bw.write(_wl_block22Bytes, _wl_block22);

															}
															if (footer_sign_3_practid == 3){
											 				
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(authPractName));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(authPractDegree));
            _bw.write(_wl_block22Bytes, _wl_block22);

															}
															
            _bw.write(_wl_block23Bytes, _wl_block23);

														if (footer_sign_3_splty == 1){
													
            _bw.write(_wl_block24Bytes, _wl_block24);

														if (footer_sign_3_practid == 1){
														
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(attendPractSplty));
            _bw.write(_wl_block26Bytes, _wl_block26);

														}
														if (footer_sign_3_practid == 2){
														
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(admitPractSplty));
            _bw.write(_wl_block26Bytes, _wl_block26);

														}
														if (footer_sign_3_practid == 3){
														
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(authPractSplty));
            _bw.write(_wl_block26Bytes, _wl_block26);

														}
														
            _bw.write(_wl_block27Bytes, _wl_block27);

													}
													
            _bw.write(_wl_block28Bytes, _wl_block28);
										
									}
									
            _bw.write(_wl_block31Bytes, _wl_block31);
		
								}
							}
						}
					
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( htmlFooterString));
            _bw.write(_wl_block33Bytes, _wl_block33);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
