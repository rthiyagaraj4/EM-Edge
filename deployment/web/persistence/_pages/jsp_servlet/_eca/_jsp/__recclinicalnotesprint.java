package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.zip.*;
import java.io.*;

public final class __recclinicalnotesprint extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesPrint.jsp", 1742465566499L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" <!-- IN066793 -->\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="<!-- IN042733 -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<style type=\"text/css\" media=\"print\">   \n\tth {\n\t\tfont-family:Arial;\n\t\tcolor:black;\n\t\t//back ground-color:lightgrey; //Commented for IN059489\n\t}\n\tthead {\n\t\tdisplay:table-header-group;\n\t}\n\ttbody {\n\t\tdisplay:table-row-group;\n\t}\n\ttfoot {\n\t\tdisplay:table-footer-group;\t\t\n\t}\n\n</style>\n<!--IN064446 Changes starts-->\n<script>\nfunction SysPreview()\n{\n\talert(\"inside syspreview 93\");\n\tvar OLECMDID = 7;\n\tvar PROMPT =2;\n\t\n\ttry\n\t{\n\t\tvar oWebBrowser = document.getElementById(\"WebBrowser1\");\n\n\t\tif(oWebBrowser == null)\n\t\t{\n\t\t\tvar sWebBrowser = \'<OBJECT ID = \"WebBrowser1\" width = 0 height =0 CLASSID =\"CLSID:8856F961-340A-11D0-A96B-00C04FD705A2\"> </OBJECT>\';\n\n\t\t\tdocument.body.insertAdjacentHTML(\'beforeend\',sWebBrowser);\n\n\t\t\toWebBrowser = document.getElementById(\"WebBrowser1\");\n\t\t}\n\t\t\n\t\toWebBrowser.ExecWB(OLECMDID,PROMPT,null,null);\n\t\talert(\"111\");\n\t\twindow.close();\n\t}\n\tcatch (e)\n\t{\n\t\talert(\"Failed\");\n\t}\n}\n</script>\n<!--IN064446 changes ends -->\n</head>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad = \"Print()\" >\n<form>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<!--  <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link>  // Commented for  for IN059489-->\n<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script Language=\"vbscript\">\n    Dim WSHShell\n    Dim myHeader\n    Dim myFooter\n    Dim myMarginleft \n    Dim myMarginright \n    Set WSHShell = CreateObject(\"WScript.Shell\")\n    REM myHeader = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\")\n    REM myFooter = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\")\n    REM myMarginleft = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_left\") \n    REM myMarginright = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_right\") \n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\", \"&bPage &p of &P\"\n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\", \"&b&d\"\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\", \"\" \n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\", \"\"\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n    \n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_left\", \"0.5\"\n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_right\", \"0.3\"\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_top\", \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_top\", \"0.75\"\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n  \n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_bottom\", \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_bottom\", \"0.5\"\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n<!--IN066793 starts  -->\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\n<style>\n\tADDRESS\t{ \n\t\t\tFONT-FAMILY: Segoe UI ;\n\t\tFONT-SIZE: 10pt ; \n\t\tFONT-STYLE: NORMAL; \n\t\tCOLOR: BLACK; \n\t\t}\n\t\t/* IN054024 Start. */\n\t\tPRE\n\t\t{\n\t\t\tfont-size:10pt;\t\t\t\n\t\t\tfont-family: Segoe UI;\n\t\t\t//BACKGROUND-COLOR: #E2E3F0;\n\t\t\tBACKGROUND-COLOR: #FFFFFF;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\t\t\t\n\t\t}\n\t\t/* IN054024 End. */\n</style>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n<style>\n\tADDRESS\t{ \n\t\t\tFONT-FAMILY: Verdana ;\n\t\tFONT-SIZE: 10pt ; \n\t\tFONT-STYLE: NORMAL; \n\t\tCOLOR: BLACK; \n\t\t}\n\t\t/* IN054024 Start. */\n\t\tPRE\n\t\t{\n\t\t\tfont-size:10pt;\t\t\t\n\t\t\tfont-family: Verdana;\n\t\t\t//BACKGROUND-COLOR: #E2E3F0;\n\t\t\tBACKGROUND-COLOR: #FFFFFF;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfontWeight : bold;\n\t\t\ttext-align: left;\n\t\t\twhite-space: normal;\n\t\t\tword-wrap: break-word;\t\t\t\n\t\t}\n\t\t/* IN054024 End. */\n</style>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\n\t\t\t<!-- IN030419 Starts -->\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<!-- IN030419 Ends -->\n\t\t\t<table border=\"0\" width=\"100%\"> \n\t\t\t   <thead> \n\t\t\t\t\n            ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<tr> \n\t\t\t\t <th style=\"width:100%\">\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t</th> \n\t\t\t\t\t</tr> \n\n\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t<tr> \n\t\t\t\t <!--<th><hr style=\"color:#000080\"/></th> IN032744-->\n\t\t\t\t </tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\n\t\t\t\t<tr> \n\t\t\t\t <th style=\"width:100%\">\n\t\t\t\t <br>\n\t\t\t<!--<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width = \'100%\' style=\"font-family:Verdana;:background-color:#ADADAD\"> //Commented for IN059489 -->\n\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width = \'100%\' style=\"font-family:Verdana;\"> <!--Changed for IN059489-->\n\t\t\t\t<tr>\n\t\t\t\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font></td></tr>\n\t\t\t\t</table>\n\t\t\t\t<br>\n\t\t\t\t</th> \n\t\t\t\t</tr>\n\t\t\t\t<tr> \n\t\t\t\t<!-- <th><hr style=\"color:#000080\"/></th> IN032744-->\n\t\t\t\t </tr>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\n\t\t\t\t\n\t\t\t   </thead> \n\t\t\t   <tfoot  id=\"table_footer\">\n    <tr> \n     <td width=\"100%\"> \n      <table width=\"100%\" border=\"0\"> \n        <tr> \n\t\t\t<!--<th><hr style=\"color:#000080\"/></th> IN032744-->\n\t\t</tr> \n\t\t<tr> \n\t\t <th style=\"width:100%\">&nbsp;</th> \n\t\t</tr> \n      </table> \n\t </td>\n    </tr>\n   </tfoot>\n   <tbody> \n    <tr> \n      <td width=\"100%\">\n\t  \n\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<!-- IN029312 Starts-->\n\t\t\t<!--<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width = \'100%\' style=\"font-family:Verdana;:background-color:#ADADAD\">\n\t\t\t<tr>\n\t\t\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font></td></tr>\n\t\t\t</table>\n\t\t\t<br> -->\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<!--IN029312 Ends -->\n\t\t\t\n\t\t\t<!--<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width = \'100%\' style=\"font-family:Verdana;:background-color:#ADADAD\">\n\t\t\t<tr>\n\t\t\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font></td></tr>\n\t\t\t</table> -->\n\n\t\t\t<!-- shs new \t\tTo\t-->\n                <script>\n\t\t\t\t\t//document.write(a[1]);\n\t\t\t\t</script>\n\t\t\t\t<!-- IN030419 Starts -->\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<table border=\"0\" width=\"100%\"> \n\t\t\t\t\t\t<thead> \n\t\t\t\t\t\t<tr> \n\t\t\t\t\t\t<th style=\"width:100%\">\n\t\t\t\t\t\t<br>\n\t\t\t\t\t\t<!--<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width = \'100%\' style=\"font-family:Verdana;:background-color:#ADADAD\"> //Commented for IN059489-->\n\t\t\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width = \'100%\' style=\"font-family:Verdana;\">  <!--Changed for IN059489-->\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</font></td></tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<br>\n\t\t\t\t\t\t</th> \n\t\t\t\t\t\t</tr> \n\t\t\t\t\t\t<tr> \n\t\t\t\t\t\t<!--<th><hr style=\"color:#000080\"/></th> IN032744-->\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</thead> \n\t\t\t\t\t\t</table>\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t   <!-- IN030419 Ends -->\n\t\t\t   ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n \t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\n\t\t\t<!-- shs new \t\tfrom\t-->\n\t\t\t<!--IN029312 Starts-->\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t<table width=\'100%\' border=1 cellpadding=0 cellspacing=0 align=center>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</font>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<!--IN029312 Ends-->\n\n\t\t\t<!-- shs new \t\tTo\t-->\n\n\t\t\t<script>//document.write(a[2]);</script>\n\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n</td> \n   </tr>\n  </tbody> \n</table>\n<!--IN004500 starts -->\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n<table width=\'100%\' border=0 cellpadding=0 cellspacing=0 align=center>\n<tr>\n\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">&nbsp;</font></td>\n</tr>\n<tr>\n\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</font></td>\n</tr>\n</table>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n<!--IN004500 ends -->\n\t\t\t<script>\n\t\t\tasync function Print() \n\t\t\t\t{\n\t\t\t\t\tif (document) {\n\t\t\t\t\t\tvar i = 0;\n\t\t\t\t\t\tvar res =await confirm(\'Continue printing?\');\n\t\t\t\t\t\tif(res)  \n\t\t\t\t\t\t{\n\t\t\t\t\t\t\twhile( i < document.applets.length ) \n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tvar j = 0 ;\n\t\t\t\t\t\t\t\twhile ( !document.applets[i].isActive() && j++ <=75000 ) \n\t\t\t\t\t\t\t\t\twindow.status = i;\n\t\t\t\t\t\t\t\ti++;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t//Start.\n\t\t\t\t\t\t\t//window.print();\n\t\t\t\t\t\t\t//IN064446 Changes starts\n\t\t\t\t\t\t\t/*\n\t\t\t\t\t\t\twindow.document.close();\n\t\t\t\t\t\t\twindow.focus();\n\t\t\t\t\t\t\twindow.print();\n\t\t\t\t\t\t\twindow.document.close();\n\t\t\t\t\t\t\t*/\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\tSysPreview();\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t//alert(\"1909\");\n\t\t\t\t\t\t\twindow.document.close();\n\t\t\t\t\t\t\twindow.focus();\n\t\t\t\t\t\t\twindow.print();\n\t\t\t\t\t\t\twindow.document.close();\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t//IN064446 Changes Ends\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'!=\'OT_NOTES\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t//window.close();\n\t\t\t\t\t\t\t\t//alert(\"1918\");\n\t\t\t\t\t\t\t\tsetTimeout(function() { window.close(); }, ";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =");\n\t\t\t\t\t\t\t}\t\t\t\t\t\t\t\n\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t//End.\n\t\t\t\t\t\t\t//IN041924 Start.\n\t\t\t\t\t\t\t//setTimeout(function() { if(\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'!=\'OT_NOTES\'){window.close();} }, 1000);\n\t\t\t\t\t\t\t//setTimeout(function() { if(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'!=\'OT_NOTES\'){window.close();} }, ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =");\n\t\t\t\t\t\t\t//IN041924 End.\n\t\t\t\t\t\t\t//[IN038088] Start\t\n\t\t\t\t\t\t\t/*if(\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'!=\'OT_NOTES\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t}*/\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t}else{\n\t\t\t\t\t\t//[IN038088]  End\n\t\t\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'!=\'OT_NOTES\')\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t//alert(\"1937\");\n\t\t\t\t\t\t\t\twindow.close();\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t/* const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t\t\t\t\t\t\t\tdialogTag.close();  */\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t</script>\n</form>\n</body>\n<!--IN059489 Start -->\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\n<style>\nbody{\n\tbackground-image : url(\'../../eCA/images/Draft.jpg\');\n\tbackground-repeat: no-repeat;\n\t background-position: 100 100 50 50;\n\t}\n</style>\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n<!--IN059489 Ends -->\n</html>\n\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );
	
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


	public String checkForNull(String inputString)
	{
		return ((inputString==null)	?	""	:	inputString).trim();
	}
	public String checkForNull(String inputString, String defaultValue)
	{
		if(inputString==null)inputString ="";
		
		return ( (inputString.equals("") )	?	defaultValue	:	inputString).trim();
		
	}


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

/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             	100            ?           	created
19/10/2011		IN029296	Chowminya G		Incident No: IN029296 - <Field patient name in Report Header doesn?t display thai name> 
15/12/2011		IN029312	Menaka V		Incident No: IN029312 - <Report is printed either through
											order tracking or clinical event history it prints without proper header and footer. This happens to all the reports defined as procedure note groups. > 
15/02/2012		IN031116	Ramesh G	 	Report header is overlapping the hospital letter heads & deliverable.	
15/03/2012		IN030419	Menaka V	 	Clinical Note Logo Header and Report Header .	
05/04/2012		IN031989	Menaka V	 	When a patient is selected by using patient without encounter search function and when clinical event history is
											accessed the note header is incomplete for all the existing notes for that patient.
15/05/2012		IN032721	Ramesh G		When we Click on Print Preview the Date is not displayed in the examination date component.										 
07/06/2012		IN0331914	Ramesh G		Logo is missing from the header of clinical notes
20/06/2012	  	IN033489	Menaka V		Report header blank in clinical event history.
09/11/2012	  	IN036159	Dinesh T		Patient details are not displayed properly when his encounter id matches with another encounter id in another facility
22/02/2013	    IN036821	Chowminya G		Reporting Practitioner name not coming in the CA report
25/02/2013		IN037045    Chowminya G		CA Report logo/header alignment
03/05/2013		IN038088	Ramesh G		As we select a clinical note to be printed, we will need to close the note first before we are able to print the note.
06/05/2013	    IN039562	Chowminya G	    Age format Changed to Y-M-D	
15/05/2013    	IN038439	NijithaS		Bru-HIMS-CRF-351
21/05/2013      IN040090    Chowminya G	    Linked Issue: New format age components in local language	
28/05/2013      IN040205    Chowminya G	    Deceased patinet age issue	
25/07/2013		IN041924	Ramesh G		IE9 Issue[Note Print]
19/08/2013		IN041827	Akbar			ML-BRU-SCF-0949
17/10/2013      IN042733    NijithaS		MO-GN-5430		
23/10/2013		IN044358	Ramesh G		Header field of matrix component should be display border for separate each column
13/12/2013		IN045446	Chowminya		Inconsistent display Practitioner Name in Report Header when printing medical certificate 
16/12/2013		IN045646	Chowminya		Speciality name in report header has to be long name
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
18/02/2014	IN043895		Ramesh G		20/2/2014	    Chowminya		Clinical Notes is not correct for some of the Symbols which are loaded. 
02/04/2014	IN048271		Ramesh G		02/04/2014		Akbar			While doing copy paste from word file to clinical notes and after taking print out content are not proper format
04/06/2014	IN049424		Ramesh G 		04/06/2014		Akbar S			IN043895 Changes Reverted.
03/09/2014  IN050584		NijithaS										MO-GN-5454-CA-SL3  
16/03/2015  IN054024		Ramesh G										There is an issue for 1 patient where the Report Header Contents 									as well as the Note Header  Contents do not display on preview print as well as in the Print out.
21/07/2015  IN056353		Ramesh G		21/07/2015      Akbar S			GHL-SCF-942 : Radilogy report blank page printout
05/02/2016	IN004500		Raja S											GHL-SCF-1000
02/05/2016	IN059489		Raja S											Require a provision for adding a full page diagonal Draft watermark in template printout if it is not signed.
08/01/2018	IN064446		Raja S			08/01/2018		Ramesh G		GHL-CRF-0469
29/05/2018	IN067635		Ramesh G										ML-MMOH-SCF-1001/MMS-MD-SCF-0089/MMS-DM-SCF-0546
22/08/2018	IN066793		Sharanraj		22/08/2018
05/10/2018	IN068396		Raja S			05/10/2018		Ramesh G		Ml-MMOH-CRF-1237
10/10/2018	IN068669		sivabagyam	 10/10/2018	        Ramesh G       ARYU-CRF-0026
04/01/2019  IN067016        Ramya Maddena	04/01/2019      Ramesh G    	AMRI-CRF-0370
04/03/2019   IN066807                Ramya Maddena          4/03/2019                Ramesh G        AMRI-CRF-0340
04/05/2019	IN069484		Ramesh G										AMRI-CRF-0398
10/06/2019     IN070668              sivabagyam	          10/06/2019          Ramesh G		SKR-SCF-1215
28/06/2019  IN066005        Ramya Maddena   01/07/2019      Ramesh G        ML-BRU-CRF-0474 
06/09/2019	IN071335	   	Ramesh G											Common-ICN-0012
14/10/2019	IN071513		Ramesh G		14/10/2019		Ramesh G		ML-BRU-CRF-0585.1
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
25/10/2021	24460			Ramesh G		25/10/2021		Ramesh G		ML-MMOH-SCF-1911
13/10/2022	27926			Ramesh Goli										ML-MMOH-CRF-1643
--------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block5Bytes, _wl_block5);
	
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(request.getParameter("title")));
            _bw.write(_wl_block7Bytes, _wl_block7);


	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String header_top = "";
	String display_dis_text_print = "";//IN004500
	//IN030419 Starts
	String logo_hdr_all_pages = "";
	String rpt_hdr_all_pages = "";
	//IN030419 Ends
	String footer_bottom = ""; //[IN031116]
	String hdr_ft_yn = "";//[IN031116]
	String		note_type			=	"";
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	//[IN032210] Start
	String imageLogoHeader ="N";
	String textLogoHeader ="N";
	//[IN032210] End
	boolean restrctPageNo=false; //27926
	note_type			=	request.getParameter("note_type")==null		? ""	:	request.getParameter("note_type");
	String sourceprintl		= request.getParameter("sourceprint")==null?"":request.getParameter("sourceprint"); //IN004500
	//IN059489 Changes starts
	String waterMarkFlag = "N";
	String status = ""; //IN059489
	//IN059489 Changes Ends
	//IN064446 Changes starts
	String[] argsArry = new String[3];
	argsArry[0] =  "";//request.getParameter("data[0]")==null?"":request.getParameter("data[0]");
	argsArry[1] = request.getParameter("data[1]")==null?"":request.getParameter("data[1]");
	argsArry[2] = request.getParameter("data[2]")==null?"":request.getParameter("data[2]");
	String ppFlag = request.getParameter("ppFlag")==null?"N":request.getParameter("ppFlag");
	//IN064446 Changes ends
	String LOGO_HDR_HEIGHT="40";//IN068669
	String LOGO_HDR_WIDTH="40";//IN068669
        String logo_Site_Facility ="S";//IN066005
		//IN030419 Starts
		try
		{	
			con	= ConnectionManager.getConnection(request);
			//pstmt =	con.prepareStatement(" select LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN FROM ca_note_param ");//IN068669
			pstmt =	con.prepareStatement(" select LOGO_HDR_ALL_PAGE_YN,RPT_HDR_ALL_PAGE_YN,LOGO_HDR_WIDTH,LOGO_HDR_HEIGHT  FROM ca_note_param ");//IN068669
			rs	=	pstmt.executeQuery();
			if(rs.next())
			{
				logo_hdr_all_pages	= rs.getString("LOGO_HDR_ALL_PAGE_YN") == null ? "" : rs.getString("LOGO_HDR_ALL_PAGE_YN");
				rpt_hdr_all_pages	= rs.getString("RPT_HDR_ALL_PAGE_YN") == null ? "" : rs.getString("RPT_HDR_ALL_PAGE_YN");
				LOGO_HDR_WIDTH	= rs.getString("LOGO_HDR_WIDTH") == null ? "40" : rs.getString("LOGO_HDR_WIDTH");//IN068669
				LOGO_HDR_HEIGHT	= rs.getString("LOGO_HDR_HEIGHT") == null ? "40" : rs.getString("LOGO_HDR_HEIGHT");//IN068669
			}
			if(rs!=null)	rs.close();
			if(pstmt!=null)	pstmt.close();
			restrctPageNo=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CEH_PRINT_RESTRICT_PAGENO");//27926

	    }
	    catch(Exception e)
		{
			out.println("Exception@111 - in getting logo and report header: "+e);
			
		}
		//IN030419 Ends
		System.out.println("RecClinicalNotesPrint.jsp--------restrctPageNo--------->"+restrctPageNo);
		try
		{
			
			//con	= ConnectionManager.getConnection(request);  \\ Unused Connection
			// [IN031116] Start
			//pstmt =	con.prepareStatement(" select HDR_MARGIN_IN_INCH  from CA_NOTE_TYPE where NOTE_TYPE = ? "); 
			//pstmt =	con.prepareStatement(" select HDR_MARGIN_IN_INCH ,FT_MARGIN_IN_INCH from CA_NOTE_TYPE where NOTE_TYPE = ? "); //[IN031116] End
			//pstmt.setString	(1,note_type );
			//rs	=	pstmt.executeQuery();
			///if(rs.next())
			//{
			//	header_top	= rs.getString("HDR_MARGIN_IN_INCH") == null ? "" : rs.getString("HDR_MARGIN_IN_INCH");
			//	footer_bottom = rs.getString("FT_MARGIN_IN_INCH") == null ? "" : rs.getString("FT_MARGIN_IN_INCH");
			//}
			pstmt = con.prepareStatement("select HDR_FT_MARGIN_IN_NOTE_YN from CA_NOTE_PARAM");
			rs = pstmt.executeQuery();
			if(rs.next()){
				hdr_ft_yn =  rs.getString("HDR_FT_MARGIN_IN_NOTE_YN") == null ? "" : rs.getString("HDR_FT_MARGIN_IN_NOTE_YN");
			}
			if(hdr_ft_yn.equals("Y")){
				rs = null;
				pstmt = null;
				pstmt =	con.prepareStatement(" select HDR_MARGIN_IN_INCH ,FT_MARGIN_IN_INCH from CA_NOTE_TYPE where NOTE_TYPE = ? "); //[IN031116] End
				pstmt.setString	(1,note_type );
				rs	=	pstmt.executeQuery();
				if(rs.next())
				{
					header_top	= rs.getString("HDR_MARGIN_IN_INCH") == null ? "" : rs.getString("HDR_MARGIN_IN_INCH");
					footer_bottom = rs.getString("FT_MARGIN_IN_INCH") == null ? "" : rs.getString("FT_MARGIN_IN_INCH");
				}
			} //[IN031116]
			if(rs!=null)	rs.close();
			if(pstmt!=null)	pstmt.close();

	    }
	    catch(Exception e)
		{
			out.println("Exception@111 - in getting header_appl_yn : "+e);
			
		}
		// IN004500 starts
		if(sourceprintl!="" && sourceprintl.equals("CEH"))
		{
			try
			{
				pstmt = con.prepareStatement("select CEH_DISC_TEXT from CA_NOTE_PARAM");
				rs = pstmt.executeQuery();
				if(rs.next()){
					display_dis_text_print =  rs.getString("CEH_DISC_TEXT") == null ? "" : rs.getString("CEH_DISC_TEXT");
				}
			
				if(rs!=null)	rs.close();
				if(pstmt!=null)	pstmt.close();
		    }
		    catch(Exception e)
			{
				out.println("Exception@111 - in getting header_appl_yn : "+e);
			}
		}
		// IN004500 Ends

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

//27926 Start.
if(!restrctPageNo){

            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);

}
//27926 End.

            _bw.write(_wl_block12Bytes, _wl_block12);

	if(!header_top.equals(""))
	{
	
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(header_top));
            _bw.write(_wl_block14Bytes, _wl_block14);

	} 
	else
	{
	
            _bw.write(_wl_block15Bytes, _wl_block15);

	}
	
            _bw.write(_wl_block16Bytes, _wl_block16);

	//[IN031116] Starts
	if(!footer_bottom.equals(""))
	{
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(footer_bottom));
            _bw.write(_wl_block14Bytes, _wl_block14);

	} 
	else
	{
	
            _bw.write(_wl_block18Bytes, _wl_block18);

	}
	//[IN031116] Ends
	
	//IN066793 starts
	boolean sitespecific=false;
		Connection	 conn=null;
		try
		{
			 conn	= ConnectionManager.getConnection(request);
			sitespecific = CommonBean.isSiteSpecific(conn, "CA","BURMESE_LANGUAGE_FONT");
		}
		catch(Exception e)
		{
			out.println("Exception@111 - in getting header_appl_yn : "+e);
		}
		finally
		{
			if(conn!=null)	ConnectionManager.returnConnection(conn,request);
		}
		
	//IN066793 ends	
	
            _bw.write(_wl_block19Bytes, _wl_block19);
 
if(sitespecific)
{	

            _bw.write(_wl_block20Bytes, _wl_block20);

}
else
{	

            _bw.write(_wl_block21Bytes, _wl_block21);

}
//IN066793 starts  
	Hashtable htParameter=new Hashtable();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	//String data				= request.getParameter("data")==null?"":request.getParameter("data");
	String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String accession_num	= request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	
	//out.println("<script>alert('accession_num"+accession_num+"')</script>");
	String discharge_summary_text ="";
	

	if(discharge_summary_text == null)
		discharge_summary_text = "";

	//Connection			con			=	null;
	//PreparedStatement	pstmt		=	null;
	PreparedStatement	pstmt2			=	null;
	//ResultSet			rs			=	null;
	ResultSet			rs2				=	null;

	PreparedStatement	pstDisTxt	=	null;
	ResultSet			rsDisTxt	=	null;

	String	query_notes_detail		=	"";
	String	notes_content			=	"";
	String  notes_content1			=	"";
	String note_group_desc			= ""; //[IN033191]
	String  strDisTextQuery			=   "";
	String  strNoteType				=	"";
	String  printhdrindsyn			=	"";
	String  head_foot_qry			=	"";
	String  sect_template_query		=	"";
	String  athorise_by_qry			=	"";
	String  note_header_code		=	"";
	String  footer_code				=	"";
	String  report_header_code		=	"";
	String	section_content			=	"";
	String	section_content_rpt		=	"";
	String	section_content_hdr		=	"";
	String	section_content_ftr		=	"";
	String  url1					=	"";
	String  url						=	"";
	String  authorized_by_name		=	""; //IN069484
	String  authorized_by_id		=	""; //IN069484
	String  authorized_sign			=   "N"; //IN069484
	String  last_amended_by						=	"";
	String  doc_ref_id						=	"";
	String		patient_id		=	"", note_status 	=	"", note_type_desc 	=	"";
	String		performing_phy_name		=	"", event_date_time 	=	"", attending_practitioner 	=	"", performing_phy_name1		=	"";//IN036821
	String attending_practitioner_list = "";//IN066807
	String admitting_practitioner="";
	String		speciality_name		=	"", Sex 	=	"", visit_adm_date 	=	"";
	String		discharge_date		=	"", med_service 	=	"", location_code 	=	"";
	String		discharge_date_only = "";//IN067016
	String		patient_class		=	"" ,age	=	"" ,encounter_id = "" ;
	String		login_user_id							=	"";
	String		printDateTime						=	"";
	String		patient_name							=	"";
	String		encounter_id1							=	"";
	String		query_privilege_type	=	"" ;
	String		episode_type	=	"" ;
	String		gender	=	"" ;
	String		called_from	=	"" ;
	String		performed_by_id	=	"" ;
	String		facility_name	=	"" ;
	String		site_name	=	"" ;
	String		pract_sign = "";
	String		pract_sign_qry = "";
	String		clinician_id = "";
	String		appl_task_id = "";
	String      default_pat_name = ""; //--[IN029296]
	HashMap<String,String> paramMap = null;
    String contr_mod_accession_num = ""; //[IN032721]
	String cal_eventdate = "";//IN040090
	//IN040205 - Start
	String deceased_yn = "";
	String deceased_date = "";
	PreparedStatement	pstPatInfo		=	null;
	ResultSet			rsPatInfo		=	null;
	String patient_age = "";
	//IN040205 - end
	int note_print_time_interval	=	0;	//IN041924

		clinician_id			= (String)session.getValue("ca_practitioner_id");
		login_user_id		=	(String)session.getValue("login_user");
		patient_id			=	request.getParameter("patient_id")==null		? ""	:	request.getParameter("patient_id");
		note_status			=	request.getParameter("note_status")==null		? ""	:	request.getParameter("note_status");
		note_type_desc		=	request.getParameter("event_title_desc")==null		? ""	:	request.getParameter("event_title_desc");
		performing_phy_name	=	request.getParameter("performed_by_pract")==null		? ""	:	request.getParameter("performed_by_pract");
		performing_phy_name1	=	request.getParameter("performed_by_pract")==null		? ""	:	request.getParameter("performed_by_pract");//IN036821
		event_date_time		=	request.getParameter("performed_date")==null		? ""	:	request.getParameter("performed_date");
		String strEventDateTime		= checkForNull((String)request.getParameter("event_date_time"),"");//IN042733
		attending_practitioner = request.getParameter("attending_practitioner") == null ? "" : request.getParameter("attending_practitioner");
		attending_practitioner_list = request.getParameter("attending_practitioner_list") == null ? "" : request.getParameter("attending_practitioner_list");//IN066807
		if(attending_practitioner.equals("null"))
			attending_practitioner = "";
		admitting_practitioner = request.getParameter("admitting_practitioner") == null ? "" : request.getParameter("admitting_practitioner");
		if(admitting_practitioner.equals("null"))
			admitting_practitioner = "";
		speciality_name		=	request.getParameter("speciality_name")==null		? ""	:	request.getParameter("speciality_name");
		Sex					=	request.getParameter("Sex")==null		? ""	:	request.getParameter("Sex");
		visit_adm_date		=	request.getParameter("visit_adm_date")==null		? ""	:	request.getParameter("visit_adm_date");
		discharge_date		=	request.getParameter("discharge_date")==null		? ""	:	request.getParameter("discharge_date");
		discharge_date_only	=	request.getParameter("discharge_date")==null		? ""	:	request.getParameter("discharge_date");//IN067016
		med_service			=	request.getParameter("med_service")==null	? ""	:	request.getParameter("med_service");
		location_code		=	request.getParameter("location_code")==null		? ""	:	request.getParameter("location_code");
		patient_class		=	request.getParameter("patient_class")==null		? ""	:	request.getParameter("patient_class");
		printDateTime		=	request.getParameter("printDateTime")==null		? ""	:	request.getParameter("printDateTime");
		note_type			=	request.getParameter("note_type")==null		? ""	:	request.getParameter("note_type");
		patient_name		=	request.getParameter("patient_name")==null		? ""	:	request.getParameter("patient_name");
		//patient_name		=	java.net.URLDecoder.decode(patient_name);
		encounter_id		=	request.getParameter("encounter_id")==null		? ""	:	request.getParameter("encounter_id");
		age					=	request.getParameter("age")==null		? ""	:	request.getParameter("age");
		episode_type		=	request.getParameter("episode_type")==null		? ""	:	request.getParameter("episode_type");
		called_from			=	request.getParameter("called_from")==null		? ""	:	request.getParameter("called_from");
		performed_by_id			=	request.getParameter("performed_by_id")==null		? ""	:	request.getParameter("performed_by_id");
		appl_task_id			=	request.getParameter("appl_task_id")==null		? ""	:	request.getParameter("appl_task_id");
		contr_mod_accession_num = checkForNull((String)request.getParameter("contr_mod_accession_num"),"");   //[IN032721]
		// IN071335 Changes Start.
		//url   = HttpUtils.getRequestURL(request).toString();
		//url = url.substring(0,url.indexOf("jsp/")); 
		url					= application.getRealPath("/eCA")+"/";
		// IN071335 Changes End.
		/*IN066793 starts*/
		
		if(sitespecific)
		{
			System.out.println("ifff");
			url1 = url + "html/RecClinicalNotesTemplateDispayView_Burmese.xsl";
			url =url+"html/RecClinicalNotesTemplateSentenceView_Burmese.xsl";
		}
		else
		{
			System.out.println("else");
			url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";
			url =url+"html/RecClinicalNotesTemplateSentenceView.xsl";
		}
		/*IN066793 ends*/
		cal_eventdate = com.ehis.util.DateUtils.convertDate(strEventDateTime,"DMYHM","en","en");//IN040090//IN050584
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;

	//strDisTextQuery = "select DISCLIMER_TEXT from CA_DISCLIMER_TEXT A, CA_NOTE_TYPE B where B.DISCLIMER_CODE = A.DISCLIMER_CODE and b.note_type = ?  and a.eff_status ='E'";
	
	// shaiju added for sign on print --sshh

		//if(called_from.equals("printOnSign")){//IN031989
			if(	episode_type.equals("O") )
			{
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND */A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //IN036159
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND */A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ?"; //IN036159//IN045446 get_desc for performed_by_name changed from 2 to 1//IN045646 get_desc for specialty_name changed from 2 to 1 //comitted for IN067016
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND */A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ?"; //IN067016//commented for IN066807
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,ca_get_attend_pract_list(a.patient_id,a.encounter_id,a.facility_id) attending_pract_list,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND */A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ?  ORDER BY A.VISIT_ADM_DATE_TIME DESC";//IN066807
			}
			else
			{ 
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'2') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND*/ A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?";//IN036159
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND*/ A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ?";//IN036159
				//IN045446 get_desc for performed_by_name changed from 2 to 1 //IN045646 get_desc for specialty_name changed from 2 to 1 //comitted for IN067016
				//query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND*/ A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ?";//IN067016//commented for IN066807
				query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,ca_get_attend_pract_list (a.patient_id,a.encounter_id,a.facility_id) attending_pract_list,AM_GET_DESC.AM_PRACTITIONER(?,?,'1') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy') ,'') DISCHARGE_DATE_TIME_1,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH,decode(b.deceased_yn,'Y',b.deceased_date,'')) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE /*A.FACILITY_ID=? AND*/ A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? and a.patient_id = ? ORDER BY A.VISIT_ADM_DATE_TIME DESC";//IN066807
			}
		//}//IN031989

		


	
	// --sshh ends
	
	strDisTextQuery = "select 	CA_GET_DESC.CA_DISCLIMER_TEXT(b.DISCLIMER_CODE,?,'1')DISCLIMER_TEXT,b.NOTE_TYPE_DESC from 	CA_NOTE_TYPE B 	where 	b.note_type = ?  and 	b.eff_status ='E'";

	//query_notes_detail = "select a.note_content, b.note_type_desc,b.note_type,(select DECODE (IB.APPL_TASK_ID,'DISCHARGE_SUMMARY',PRINT_HDR_IN_DS_YN,'Y') from ca_note_param IA, CA_NOTE_GROUP IB where IB.NOTE_GROUP=B.NOTE_GROUP_ID AND rownum=1) PRINT_HDR_IN_DS_YN  from ca_encntr_note a, ca_note_type b where a.note_type = b.note_type and a.facility_id = ? and a.accession_num = ?";
	//query_notes_detail = "select a.note_content, b.note_type_desc,b.note_type,(	select DECODE (IB.APPL_TASK_ID,'DISCHARGE_SUMMARY',PRINT_HDR_IN_DS_YN,'Y') from ca_note_param IA, CA_NOTE_GROUP IB where IB.NOTE_GROUP=B.NOTE_GROUP_ID AND rownum=1) PRINT_HDR_IN_DS_YN, b.PRINT_LOGO_HEADER_YN  from 	ca_encntr_note a, ca_note_type_lang_Vw b where 	a.note_type = b.note_type and 	/*a.facility_id = ? 	and */	a.accession_num = ? 	and	b.language_id = ?"; //Commented for IN059489
	//6484 Start.
	//query_notes_detail = "select a.note_content, b.note_type_desc,b.note_type,(	select DECODE (IB.APPL_TASK_ID,'DISCHARGE_SUMMARY',PRINT_HDR_IN_DS_YN,'Y') from ca_note_param IA, CA_NOTE_GROUP IB where IB.NOTE_GROUP=B.NOTE_GROUP_ID AND rownum=1) PRINT_HDR_IN_DS_YN, b.PRINT_LOGO_HEADER_YN,a.EVENT_STATUS  from 	ca_encntr_note a, ca_note_type_lang_Vw b where 	a.note_type = b.note_type and 	/*a.facility_id = ? 	and */	a.accession_num = ? 	and	b.language_id = ?"; //Modified for IN059489
	query_notes_detail = "select a.note_content,a.compress_note_content_yn,a.compress_note_content, b.note_type_desc,b.note_type,(	select DECODE (IB.APPL_TASK_ID,'DISCHARGE_SUMMARY',PRINT_HDR_IN_DS_YN,'Y') from ca_note_param IA, CA_NOTE_GROUP IB where IB.NOTE_GROUP=B.NOTE_GROUP_ID AND rownum=1) PRINT_HDR_IN_DS_YN, b.PRINT_LOGO_HEADER_YN,a.EVENT_STATUS  from 	ca_encntr_note a, ca_note_type_lang_Vw b where 	a.note_type = b.note_type and 	/*a.facility_id = ? 	and */	a.accession_num = ? 	and	b.language_id = ?"; 
	//6484 End.
	//head_foot_qry ="select a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?"; //Commented for IN059489
	head_foot_qry ="select a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE,a.WATERMARK_YN from ca_note_type a where  a.NOTE_TYPE=?"; //Modified for IN059489

	sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;

	//athorise_by_qry ="select a.AUTHORIZED_BY_ID ,a.LAST_AMENDED_BY_ID,a.DOC_REF_ID from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;
	//IN069484 Start		
	//athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ?  " ;
	athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_NAME,a.AUTHORIZED_BY_ID AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ?  " ;
	//IN069484 End.
	pract_sign_qry=	"SELECT a.practitioner_name|| CHR (13)|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32)|| b.position_desc|| NVL2 (b.position_desc, CHR (13), '' )|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32)|| credential_id1 || NVL2 (credential_id1, ', ', '')       || credential_id2 || NVL2 (credential_id2, ', ', '')|| credential_id3 || NVL2 (   credential_id1|| credential_id2|| credential_id3,CHR (13),'')|| CHR (32)|| CHR (32)|| CHR (32)|| CHR (32) || DEGREE pract_with_pos_cred_deg  FROM am_practitioner a, am_position b WHERE a.position_code = b.position_code AND a.practitioner_id = ? ";
	
	//IN040205 - Start
	String strPatInfoQuery = "";
	strPatInfoQuery = "select patient_name patient_name,get_age(date_of_birth,decode(deceased_yn,'Y',deceased_date,sysdate)) patient_age,Sex Gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time from mp_all_patients_vw where patient_id = ? "; 
		
			try
			{
				pstPatInfo	= con.prepareStatement(strPatInfoQuery);
				pstPatInfo.setString    (	1,	patient_id);

				rsPatInfo = pstPatInfo.executeQuery();

				if(rsPatInfo.next() )
				{
					patient_age		= rsPatInfo.getString("patient_age") == null ? "" : rsPatInfo.getString("patient_age");
				}	
			}
			catch (Exception ePP6)
			{

				ePP6.printStackTrace();
			}
			finally
			{
				if(rsPatInfo != null) rsPatInfo.close();
				if(pstPatInfo != null) pstPatInfo.close();
			}
	//IN040205 - end
	try
	{
		//con				=	ConnectionManager.getConnection(request);
		
		//shaiju
			
			pstmt	=	con.prepareStatement(pract_sign_qry);
			pstmt.setString	(	1,	clinician_id	);
			rs		=	pstmt.executeQuery();
			if(rs.next())
			{
				pract_sign			=	rs.getString("pract_with_pos_cred_deg") == null ? "" : rs.getString("pract_with_pos_cred_deg");
			}
			if(rs!=null)	rs.close();
			if(pstmt!=null)	pstmt.close();
		
		
		//if(called_from.equals("printOnSign")){//IN031989
			pstmt	=	con.prepareStatement(query_privilege_type);
			pstmt.setString	(	1,	locale	);
			pstmt.setString	(	2,	locale	);
			pstmt.setString	(	3,	locale	);
			pstmt.setString	(	4,	locale	);
			pstmt.setString	(	5,	performed_by_id	);
			pstmt.setString	(	6,	locale	);
			pstmt.setString	(	7,	locale	);			
			pstmt.setString	(	8,	locale	);	
			pstmt.setString	(	9,	locale	);			
			pstmt.setString	(	10,	locale	);			
			//pstmt.setString	(	11,	facility_id	);
			pstmt.setString	(	11,	encounter_id);
			pstmt.setString	(	12,	patient_id);//IN036159

			rs		=	pstmt.executeQuery();

			if(rs.next())
			{
				facility_name			=	rs.getString("facility_name") == null ? "" : rs.getString("facility_name");
				visit_adm_date			=	rs.getString("visit_adm_date")==null?"":rs.getString("visit_adm_date");
				med_service			=	rs.getString("service_name")==null?"":rs.getString("service_name");
				discharge_date		=	rs.getString("DISCHARGE_DATE_TIME")==null?"":rs.getString("DISCHARGE_DATE_TIME");
				discharge_date_only		=	rs.getString("DISCHARGE_DATE_TIME_1")==null?"":rs.getString("DISCHARGE_DATE_TIME_1");//IN067016
				attending_practitioner	=	rs.getString("attending_practitioner")==null?"":rs.getString("attending_practitioner");
                		attending_practitioner_list	=	rs.getString("attending_pract_list")==null?"":rs.getString("attending_pract_list");//IN066807
				admitting_practitioner	=	rs.getString("admitting_practitioner")==null?"":rs.getString("admitting_practitioner");
				performing_phy_name	=	rs.getString("performed_by_name")==null?"":rs.getString("performed_by_name");
				age				=	rs.getString("AGE")==null?"":rs.getString("AGE");
				gender					=	rs.getString("gender")==null?"":rs.getString("gender");
				//locationDesc			=	rs.getString("location");
				location_code			=	rs.getString("location_code")==null?"":rs.getString("location_code");
				patient_name			=	rs.getString("patient_name")==null?"":rs.getString("patient_name");
				speciality_name			=	rs.getString("specialty_name")==null?"":rs.getString("specialty_name");
				printDateTime			=	rs.getString("print_date_time")==null?"":rs.getString("print_date_time");
				site_name			=	rs.getString("site_name")==null?"":rs.getString("site_name");
				//performed_by_desc			=	rs.getString("performed_by_desc");
				patient_class =	rs.getString("patient_class")==null?"":rs.getString("patient_class");//IN033489

			
			}

				if(gender.equals("M"))
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
				else if (gender.equals("F"))
						Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
				/*  //24460 Start.				
				else 
						//Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
				*/	//24460 End.
			if(discharge_date==null){
				discharge_date="";
			}
			//IN067016--Starts
			if(discharge_date_only==null){
				discharge_date_only="";
			}
			//IN067016--ends
			if(rs!=null)	rs.close();
			if(pstmt!=null)	pstmt.close();
			//[IN033191] Start
			pstmt			=	con.prepareStatement("SELECT A.NOTE_GROUP_DESC NOTEGRDESC FROM CA_NOTE_GROUP A,CA_NOTE_TYPE B WHERE A.NOTE_GROUP=B.NOTE_GROUP_ID AND B.NOTE_TYPE=?");
			pstmt.setString(1, note_type);			
			rs				=	pstmt.executeQuery();
			if(rs.next())
			{
				note_group_desc = rs.getString("NOTEGRDESC");
			}
			
			if(rs!=null)	rs.close();
			if(pstmt!=null)	pstmt.close();
			//[IN033191] End
		//}//IN031989
		
		if(patient_class.equals("OP"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
		else if(patient_class.equals("IP"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
		else if(patient_class.equals("EM"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
		else if(patient_class.equals("DC"))
				patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
		//shaiju
		
		pstDisTxt = con.prepareStatement(strDisTextQuery);
		
		
		pstmt			=	con.prepareStatement(query_notes_detail);
	
	
		//pstmt.setString(1, facility_id);
		pstmt.setString(1, accession_num);
		pstmt.setString(2, locale);

		rs				=	pstmt.executeQuery();
	
		if(rs.next())
		{
			
			//6484 Start.
			strNoteType			=	rs.getString("note_type");
			printhdrindsyn      =   rs.getString("PRINT_LOGO_HEADER_YN");
			note_type_desc = rs.getString("note_type_desc") == null ? "" : rs.getString("note_type_desc");
			status				=	rs.getString("EVENT_STATUS") == null ? "" : rs.getString("EVENT_STATUS");

			if(printhdrindsyn == null)
					printhdrindsyn ="N";
				
			if("Y".equals(rs.getString("compress_note_content_yn")==null?"":(String)rs.getString("compress_note_content_yn"))){
				
				java.sql.Blob note_blob =  (java.sql.Blob)rs.getBlob("compress_note_content");
				if(note_blob!=null && note_blob.length()>0){
					InputStream ins1 = note_blob.getBinaryStream();
					ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
					int i;
					while((i = ins1.read()) != -1) 
						bytearrayoutputstream.write(i);
					
					byte[] compressed	=bytearrayoutputstream.toByteArray();
					if(compressed.length > 0){
						if((compressed[0] == (byte) (GZIPInputStream.GZIP_MAGIC)) && (compressed[1] == (byte) (GZIPInputStream.GZIP_MAGIC >> 8))){
							GZIPInputStream gis = new GZIPInputStream(new ByteArrayInputStream(compressed));
							BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(gis, "UTF-8"));

							String line;
							while ((line = bufferedReader.readLine()) != null) {
								notes_content += line;
							}
						}					
					}
				}				
			}else{
			//6484 End.	
				clob_notes_content	=	(java.sql.Clob) rs.getObject("note_content");
				

				if(clob_notes_content!=null)
				{
					try
					{
						content_reader	= clob_notes_content.getCharacterStream();
						bf_content_reader = new java.io.BufferedReader(content_reader);
						char[] arr_notes_content = new char[(int)clob_notes_content.length()];
						bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
						notes_content = new String(arr_notes_content);
						bf_content_reader.close();
					}
					catch(Exception e)
					{
						out.println("Exception@2-readCLOB : "+e);
					}
				}				
			}	
			if(!notes_content.equals(""))
			{
				//IN044358 Start.
				String str="<th style=\"border-style:dashed;font-size:9pt;font-weight:boldl;\"";
				String str1="<td style=\"border-style:dashed;font-size:9pt;text-align:center;font-weight:bold;\"";
				notes_content = notes_content.replaceAll(str,str1);
				String str_ ="<th style=\"color:black;font-size:9pt;font-weight:normal;border-style:dashed;\"";
				String str1_ ="<td style=\"color:black;font-size:9pt;font-weight:normal;border-style:dashed;text-align:center;\"";
				notes_content = notes_content.replaceAll(str_,str1_);
				notes_content = notes_content.replaceAll("</th>","</td>");
				notes_content = notes_content.replaceAll("<!--","<!-- ");
				//IN044358 End.
				notes_content = notes_content.replaceAll("PADDING-RIGHT: 0in","PADDING-RIGHT: 0.2in");  //IN048271
				notes_content = notes_content.replaceAll("PAGE-BREAK-BEFORE: always;","");           //[IN056353]
				notes_content = notes_content.replaceAll("<HTML><BODY><PRE>","<PRE>");				//IN067635
				notes_content = notes_content.replaceAll("</PRE></BODY></HTML>","</PRE>");			//IN067635
				notes_content = notes_content.replaceAll("line-height: 100%"," ");			//IN068396
				int nIndex = notes_content.indexOf("<BODY onKeyDown='lockKey()'>");
				if(nIndex==-1)
				{
					nIndex = notes_content.indexOf("<BODY>");
				}
				int nIndex1 = notes_content.lastIndexOf("</BODY>");
				
				if(nIndex != -1 && nIndex1 != -1)
					notes_content1 = notes_content.substring(nIndex+6,nIndex1);
				else
					notes_content1 = notes_content;
			}

			pstDisTxt.setString(1,locale);
			pstDisTxt.setString(2,strNoteType);

			try
			{
				rsDisTxt	=	pstDisTxt.executeQuery();

				while(rsDisTxt.next())
				{
					discharge_summary_text = rsDisTxt.getString("DISCLIMER_TEXT") == null ? "" : rsDisTxt.getString("DISCLIMER_TEXT");
				}
				
				/*if(rsDisTxt.next())
					discharge_summary_text = rsDisTxt.getString("DISCLIMER_TEXT") == null ? "" : rsDisTxt.getString("DISCLIMER_TEXT");
				else
					discharge_summary_text =""; */
			}
			catch (Exception eDis)
			{
				out.println("Exception@2-readDisclaimer : "+eDis);
			}
			finally
			{
				if(rsDisTxt != null) rsDisTxt.close();
				if(pstDisTxt != null) pstDisTxt.close();

			}

			//shaiju starts
			
			try{
				//String head_foot_qry ="select a.NOTE_HEADER_CODE,a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
				pstmt2	= con.prepareStatement(head_foot_qry);
				pstmt2.setString(1,note_type);
				rs2 = pstmt2.executeQuery();

				while(rs2.next())
					{
						note_header_code = rs2.getString("NOTE_HEADER_CODE")==null?"":rs2.getString("NOTE_HEADER_CODE");
						footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
						report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
						waterMarkFlag = rs2.getString("WATERMARK_YN") == null ? "" : rs2.getString("WATERMARK_YN"); //IN059489
					}

		
			}
			catch(Exception ee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
				ee.printStackTrace();
			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
		//--[IN029296] - Start
		
			try{
				pstmt2	= con.prepareStatement("select patient_name patient_name,deceased_yn,to_Char(deceased_date,'dd/mm/yyyy hh24:mi') deceased_date from mp_patient where patient_id = ?");//IN040205
				pstmt2.setString(1,patient_id);
				rs2 = pstmt2.executeQuery();
				//Date newDeceasedDt = null;//IN042733
				//Date new_event_date_time = null;//IN042733	

				while(rs2.next())
				{
					default_pat_name	= rs2.getString("patient_name") == null ? "" : rs2.getString("patient_name");
					//IN040205	- Start
					deceased_yn			= rs2.getString("deceased_yn") == null ? "" : rs2.getString("deceased_yn");
					deceased_date		= rs2.getString("deceased_date") == null ? "" : rs2.getString("deceased_date");
					//IN042733 Starts //IN050584 Starts
					/*if(!"".equals(deceased_date))
					{
						newDeceasedDt = 	new SimpleDateFormat("dd/mm/yyyy mm:ss").parse(deceased_date);
					}
					if(!"".equals(strEventDateTime))
					{
						new_event_date_time = 	new SimpleDateFormat("dd/mm/yyyy mm:ss").parse(strEventDateTime);
					}
					if("Y".equals(deceased_yn) && null!=new_event_date_time && null!=newDeceasedDt && new_event_date_time.after(newDeceasedDt) )
					{
						cal_eventdate = com.ehis.util.DateUtils.convertDate(deceased_date,"DMYHM","en","en");
					}*/
					//IN042733 Ends
					//IN040205	- end
				}
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
					
				String eventdate_isAfter_decdate = "";
				pstmt2	= con.prepareStatement("SELECT CASE WHEN TO_DATE (?, 'dd/mm/yyyy hh24:mi') > TO_DATE (?, 'dd/mm/yyyy hh24:mi') THEN 'Y'  ELSE 'N' END eventdate_isAfter_decdate FROM DUAL");
				pstmt2.setString(1,cal_eventdate);
				pstmt2.setString(2,deceased_date);
				
				rs2 = pstmt2.executeQuery();
				
				while(rs2.next())
				{
					eventdate_isAfter_decdate = rs2.getString("eventdate_isAfter_decdate");
				}
				
				if("Y".equals(eventdate_isAfter_decdate))
				{
					cal_eventdate = com.ehis.util.DateUtils.convertDate(deceased_date,"DMYHM","en","en");
				}
				//IN050584 Ends	
						
			}
			catch(Exception ee)
			{
				out.println("Exceptionin RecClinicalNotesPrint.jsp @ pstmt2 : "+ee.toString());
				ee.printStackTrace();
			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
		
		//--[IN029296] - End
		

		// Report Header starts
		try
			{
			
				//String rpt_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(sect_template_query);	
				pstmt2.setString(1,report_header_code);
				rs2 = pstmt2.executeQuery();


				if(rs2.next())
				{
				
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");

				

				if(clob_notes_content!=null)
				{
				try
					{
					//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
					}
					catch(Exception e)
					{
						out.println("Exception@1-readCLOB : "+e);
						e.printStackTrace();
					}


				 }
				}
			}

			catch(Exception eee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();

			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
			if(!accession_num.equals(""))
			{
					try
					{
						//String athorise_by_qry ="select a.AUTHORIZED_BY_ID ,a.LAST_AMENDED_BY_ID,a.DOC_REF_ID from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

						pstmt2	= con.prepareStatement(athorise_by_qry);
						pstmt2.setString(1,locale);
						pstmt2.setString(2,locale);
						pstmt2.setString(3,locale);
						pstmt2.setString(4,locale);
						pstmt2.setString(5,accession_num);
						pstmt2.setString(6,patient_id);
						rs2 = pstmt2.executeQuery();
						while(rs2.next())
						{
							authorized_by_name		=	checkForNull( rs2.getString("AUTHORIZED_BY_NAME") ); //IN069484
							authorized_by_id		=	checkForNull( rs2.getString("AUTHORIZED_BY_ID") );  //IN069484
							last_amended_by		=	checkForNull( rs2.getString("LAST_AMENDED_BY_ID") );
							doc_ref_id		=	checkForNull( rs2.getString("DOC_REF_ID") );

						}
					}
					catch (Exception roro )

					{
						out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+roro.toString());
						roro.printStackTrace();

					}
					finally 
					{
					  if(rs2 != null) rs2.close();
					  if(pstmt2 != null) pstmt2.close();
					}
            }
			encounter_id1 = encounter_id ;
			if(encounter_id.equals("0"))
			{
				encounter_id1 ="";
			}
			
			if(!visit_adm_date.equals(""))
			{
				visit_adm_date					=	com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMYHM","en",locale);
			}
			
			if(!discharge_date.equals(""))
			{
				discharge_date					=	com.ehis.util.DateUtils.convertDate(discharge_date,"DMYHM","en",locale);
			}
			//IN067016--Starts
			if(!discharge_date_only.equals(""))
			{
				discharge_date_only					=	com.ehis.util.DateUtils.convertDate(discharge_date_only,"DMY","en",locale);
			}
			//IN067016--ends



			//out.println("RecClinicalNotesPrint.jsp:patient_name:"+patient_name);
			htParameter.put("V$ATT_PRACT", attending_practitioner);
			htParameter.put("V$ATT_PRACT_LT", attending_practitioner_list);//IN066807
			htParameter.put("V$ADM_PRACT", admitting_practitioner);
			//IN036821 - Start
			if(!performing_phy_name.equals(""))
			{
				htParameter.put("V$REP_PRACT", performing_phy_name);
			}
			else
			{
				htParameter.put("V$REP_PRACT", performing_phy_name1);
			}	
			//IN036821 - End
			htParameter.put("V$PT_SPLTY", speciality_name);
			//--[IN029296]  - Start
			if(patient_name.trim().equals(""))
			htParameter.put("V$PT_NAME", default_pat_name);
			else
			htParameter.put("V$PT_NAME", patient_name);
			//--[IN029296]  - End
			htParameter.put("V$PT_ID", patient_id);
			htParameter.put("V$SEX", Sex);
			//htParameter.put("V$AGE", age);//IN040205 
			htParameter.put("V$AGE", patient_age);//IN040205
			htParameter.put("V$ENC_ID", encounter_id1);
			htParameter.put("V$ADM_DT", visit_adm_date); //visit_adm_date
			htParameter.put("V$DIS_DT", discharge_date); //discharge_date
			htParameter.put("V$DIS_DATE", discharge_date_only); //discharge_date_only//IN067016
			htParameter.put("V$MED_SERV", med_service);
			htParameter.put("V$DOC_REF_H", doc_ref_id);
			htParameter.put("V$PT_LOCN", location_code); //patient_loc
			htParameter.put("V$PT_CLASS", patient_class);//patient_class
			
			//sectionContentUpdatedXML = new StringBuffer();
			StringBuffer section_content_new = new StringBuffer(section_content);
			
			if (! locale.equals("en") )
			{
				if(!section_content_new.toString().equals(""))
				{
					paramMap = new HashMap<String,String>();
					paramMap.put("CURR_SEC_HDG_CODE",report_header_code);
					paramMap.put("LOCALE",locale);						
					paramMap.put("RANGE_PASER_YN","N");
					eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
					section_content_new = tempLangParse.getLangReplacedXML();
					tempLangParse = null;
				}


			}
			
			if(!section_content_new.toString().equals(""))
			{
				//***************************** [CRF-118] Start *****************************					
				eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
				HashMap paramHash=new HashMap();
				Hashtable tempParameter=new Hashtable();
				paramHash.put("#p_patient_id#",patient_id);
				paramHash.put("#p_encounter_id#",encounter_id1);
				paramHash.put("#p_accNum#",accession_num);
				paramHash.put("#p_locale#",locale);
				paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num);  //[IN032721]
				paramHash.put("#p_eventDate#",cal_eventdate);//IN039562//IN040090
				paramHash.put("#p_facility_id#",facility_id);//IN038439
				tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
				if(tempParameter.size()>0){					
				htParameter.putAll(tempParameter);
				}
				//*****************************[CRF-118] Ends *****************************
				sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
			}

			if(!(sectionContentUpdatedXML.toString().equals("")))
						{								
							section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);

						}


			//Report Header Ends


			// notes header
			section_content="";
			try
			{
			
				//String hdr_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(sect_template_query);
				pstmt2.setString(1,note_header_code);
				rs2 = pstmt2.executeQuery();


				if(rs2.next())
				{
				
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");

				

				if(clob_notes_content!=null)
				{
				try
					{
					//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
					}
					catch(Exception e)
					{
						out.println("Exception@1-readCLOB : "+e);
						e.printStackTrace();
					}


				 }
				}
			}

			catch(Exception eee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();

			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}

				htParameter=new Hashtable();
				htParameter.put("V$PR_DATE", event_date_time);
				htParameter.put("V$NT_STATUS", note_status);
				htParameter.put("V$NT_TITLE", note_type_desc);
				htParameter.put("V$NT_TYPE", note_type);
				htParameter.put("V$PR_BY_PRACT", performing_phy_name);
				htParameter.put("V$DOC_REF_NH", doc_ref_id);
				htParameter.put("V$NT_MEDSRV", med_service);
				
			section_content_new = new StringBuffer(section_content);
			
			if (! locale.equals("en") )
				{
					if(!section_content_new.toString().equals(""))
					{
						paramMap = new HashMap<String,String>();
						paramMap.put("CURR_SEC_HDG_CODE",note_header_code);
						paramMap.put("LOCALE",locale);					
						paramMap.put("RANGE_PASER_YN","N");
						eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
						section_content_new = tempLangParse.getLangReplacedXML();
						tempLangParse = null;
					}


				}
			
			
			
			if(!section_content_new.toString().equals(""))
				{
					//IN041827 Start
					eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
					HashMap paramHash=new HashMap();
					Hashtable tempParameter=new Hashtable();
				
					paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
					paramHash.put("#p_accNum#",accession_num);
					paramHash.put("#p_locale#",locale);
					paramHash.put("#p_pract_id#",clinician_id);
					tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
					if(tempParameter.size()>0)
					{					
						htParameter.putAll(tempParameter);
					}
					//IN041827 End
					
					sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
				}

			if(!(sectionContentUpdatedXML.toString().equals("")))
				{
					section_content_hdr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
				}


			// changes notes footer starts
			section_content= "";

			try
			{
			
				//String footer_sect_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;
				pstmt2	= con.prepareStatement(sect_template_query);
				pstmt2.setString(1,footer_code);
				rs2 = pstmt2.executeQuery();


				if(rs2.next())
				{
				
					clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");

				

				if(clob_notes_content!=null)
				{
				try
					{
					//content_reader		= ((oracle.sql.CLOB) clob_notes_content).getCharacterStream();
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
									
					if(section_content == null)
						section_content = "";
					}
					catch(Exception e)
					{
						out.println("Exception@1-readCLOB : "+e);
						e.printStackTrace();
					}


				 }
				}
			}

			catch(Exception eee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();

			}
			finally
			{
				if(rs2 != null) rs2.close();
				if(pstmt2 != null) pstmt2.close();
			}
			//IN069484 Start.
			if(!"".equals(authorized_by_id)){
				try{
					pstmt2	= con.prepareStatement("SELECT PRACTITIONER_SIGN FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?");
					pstmt2.setString(1,authorized_by_id);
					rs2 = pstmt2.executeQuery();
					while(rs2 !=null && rs2.next()){
						java.sql.Blob img_blob  =  (java.sql.Blob)rs2.getBlob("PRACTITIONER_SIGN");
						if(img_blob!=null){ //IN073450
						byte[] bytes = img_blob.getBytes(1, (int)img_blob.length()); 						
						authorized_sign = new String(org.apache.commons.codec.binary.Base64.encodeBase64(bytes), "UTF-8");
						} //IN073450
					}
				}catch(Exception se){
					se.printStackTrace();
				}finally
				{
					if(rs2 != null) rs2.close();
					if(pstmt2 != null) pstmt2.close();
				}
			}
			//IN069484 End.
			if(!printDateTime.equals(""))
			{
				printDateTime					=	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
			}

			htParameter=new Hashtable();
			htParameter.put("V$CUR_USR", login_user_id);
			htParameter.put("V$AT_PRACT", authorized_by_name); //IN069484
			htParameter.put("V$AT_PRACT_SIGN", authorized_sign); //IN069484
			htParameter.put("V$LT_MODI_USR", last_amended_by);
			htParameter.put("V$PRN_DTTIME", printDateTime);//printDateTime
			htParameter.put("V$DOC_REF_F", doc_ref_id);
			htParameter.put("V$LT_PT_P_C_D", pract_sign);

			section_content_new = new StringBuffer(section_content);
			
			//IN038439 Start
			if((!section_content_new.toString().equals("&nbsp;"))&& (!section_content_new.toString().equals("")))
			{							
				eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
				HashMap paramHash=new HashMap();
				Hashtable tempParameter=new Hashtable();
			
				paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
				paramHash.put("#p_accNum#",accession_num);
				paramHash.put("#p_locale#",locale);
				paramHash.put("#p_pract_id#",clinician_id);
				tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
				if(tempParameter.size()>0)
				{					
					htParameter.putAll(tempParameter);
				}
			}
			//IN038439 Ends
			sectionContentUpdatedXML = new StringBuffer();
			
			if (! locale.equals("en") )
			{
				if(!section_content_new.toString().equals(""))
				{
					paramMap = new HashMap<String,String>();
					paramMap.put("CURR_SEC_HDG_CODE",footer_code);
					paramMap.put("LOCALE",locale);						
					paramMap.put("RANGE_PASER_YN","N");
					eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
					section_content_new = tempLangParse.getLangReplacedXML();
					tempLangParse = null;
				}


			}
				
				
			if(!section_content_new.toString().equals(""))
			{
				sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
			}

			
			if(!(sectionContentUpdatedXML.toString().equals("")))
			{								
					
				section_content_ftr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);

			}

			//[IN032210] Start
			try
				{
		
				pstmt	= con.prepareStatement("SELECT IMAGE_REF FROM CA_NOTE_IMAGE_LIST WHERE IMAGE_REF='VDFI'");
				rs = pstmt.executeQuery();
				if(rs.next()){
					imageLogoHeader="Y";				
				}
				
				pstmt	= con.prepareStatement("SELECT PRINT_LOGO_HEADER_YN,PRINT_TEXT_HDR_YN FROM CA_NOTE_TYPE WHERE NOTE_TYPE=?");
				pstmt.setString(1,note_type);
				rs = pstmt.executeQuery();
				if(rs.next()){
					String printLogoHed = rs.getString("PRINT_LOGO_HEADER_YN")==null?"":(String)rs.getString("PRINT_LOGO_HEADER_YN");
					String printtextHed = rs.getString("PRINT_TEXT_HDR_YN")==null?"":(String)rs.getString("PRINT_TEXT_HDR_YN");
					if("Y".equals(printLogoHed) && "Y".equals(printtextHed))
							textLogoHeader="Y";				
				}
			}catch(Exception eee)
			{
				out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
				eee.printStackTrace();

			}
			finally
			{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}

			//[IN032210] End
			//IN071513 Starts
			try{
				pstmt = con.prepareStatement("SELECT LOGO_SITE_FACILITY FROM CA_PARAM_BY_FACILITY WHERE FACILITY_ID=? ");
				pstmt.setString(1,facility_id);
				
				rs = pstmt.executeQuery();
				if(rs.next()){
					logo_Site_Facility = rs.getString("LOGO_SITE_FACILITY")==null?"S":rs.getString("LOGO_SITE_FACILITY");
				}							
			}catch(Exception e){
				out.println("Exception@1 : "+e);
			}finally{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}
			//IN071513 ends
			
            _bw.write(_wl_block22Bytes, _wl_block22);

			//if(printhdrindsyn.equals("Y"))
			//IN037045 - Start Modification - to have the td with 20,60,20 from 20,80
			if((printhdrindsyn.equals("Y")) && (logo_hdr_all_pages.equals("N")))
			{
			  
				if(!called_from.equals("printOnSign"))
				{ 
				//[IN032210] Start	
					if("Y".equals(imageLogoHeader)){
						out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
						out.println("<tr><td colspan='2'>");
						out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
						//IN066005 Start
						if(logo_Site_Facility.equals("S")){
						out.println("<img src='../../eCA/jsp/CADisplayImages.jsp' >");
						}else if(logo_Site_Facility.equals("F")){
							out.println("<img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'>");
						}out.println("</td></tr></table></td></tr>");//IN066005 end
						
						if("Y".equals(textLogoHeader)){
							out.println("<tr>");	
							out.println("<td width='100%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
							out.println("</tr>");
							out.println("<tr>");	
							out.println("<td width='100%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
							out.println("</tr>");
							
						}
						out.println("</table>");
					}else{
						out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
						out.println("<tr>");	
						//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");//IN068669
						//out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
						//IN066005 Starts
						if(logo_Site_Facility.equals("S")){
						out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
						}else if(logo_Site_Facility.equals("F")){
						out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
						}//IN066005 ends
						
						if("Y".equals(textLogoHeader)){				

							out.println("<td width='60%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");
							out.println("</tr>");
							out.println("<tr>");	
							out.println("<td width='60%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");
							out.println("</tr>");
							out.println("<tr>");
							out.println("<td width='60%' colspan='2' align='center'>&nbsp;</td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");
							out.println("</tr>");
							
							
						}else{
							out.println("<td width='80%' align='center'>&nbsp;</h3></td>");								
							out.println("</tr>");//IN037045
						}
						out.println("</table>");
					}

					//[IN032210] End
				}
				else
				{ 
					//out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' width='5%' id='headerImageID'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40'></td><td  align=center><h3>"+site_name+"</h3></td></tr><tr><td>&nbsp;</td><td align=center><h3>"+facility_name+"</h3></td></tr><tr><td width='5%'>&nbsp;</td><td align=center><h4>"+note_type_desc+"</h4></td></tr></table><br>");	  //[IN032210]
					//[IN032210] Start
					if("Y".equals(imageLogoHeader)){
						out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
						out.println("<tr><td colspan='2'>");
						out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
						//IN066005 Start
						if(logo_Site_Facility.equals("S")){
						out.println("<img src='../../eCA/jsp/CADisplayImages.jsp' >");
						}else if(logo_Site_Facility.equals("F")){
							out.println("<img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'>");
						}out.println("</td></tr></table></td></tr>");//IN066005 end
						
						if("Y".equals(textLogoHeader)){
							out.println("<tr>");	
							out.println("<td width='100%' colspan='2' align='center'><h3>"+site_name+"</h3></td>");   //Commented for IN073450
							out.println("</tr>"); 
							out.println("<tr>");	
							out.println("<td width='100%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
							out.println("</tr>");
							out.println("<tr>");	
							out.println("<td width='100%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
							out.println("</tr>");
						}
						out.println("</table>");
					}else{
						out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
						out.println("<tr>");	
						//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");//IN068669
						//out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
						//IN066005 Starts
						if(logo_Site_Facility.equals("S")){
						out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
						}else if(logo_Site_Facility.equals("F")){
						out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
						}//IN066005 ends
						
						if("Y".equals(textLogoHeader)){
							 out.println("<td width='60%' align='center'><h3>"+site_name+"</h3></td>");   //Commented for IN073450
							out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
							out.println("</tr>");//IN037045
							out.println("<tr>");
							//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
							out.println("<td width='60%'  align='center'><h3>"+facility_name+"</h3></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
							out.println("</tr>");
							out.println("<tr>");
							//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
							out.println("<td width='60%'  align='center'><h4>"+note_group_desc+"</h4></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
							out.println("</tr>");
						}else{
							out.println("<td width='60%' align='center'>&nbsp;</h3></td>");
							out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
							out.println("</tr>");
						}
						out.println("</table>");
					}

					//[IN032210] End
				}
			}
			else if(printhdrindsyn.equals("N"))
			{ 
				//out.println("<br><br><br><br><br><br><br><br><br>"); //[IN032210]
			}
			
            _bw.write(_wl_block23Bytes, _wl_block23);


			if((printhdrindsyn.equals("Y")) && (logo_hdr_all_pages.equals("Y")))
			{
				
            _bw.write(_wl_block24Bytes, _wl_block24);
 
				
					if(!called_from.equals("printOnSign"))
					{


						//[IN032210] Start	
						if("Y".equals(imageLogoHeader)){
							out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
							out.println("<tr><td colspan='2'>");
							out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
							//IN066005 Start
							if(logo_Site_Facility.equals("S")){
							out.println("<img src='../../eCA/jsp/CADisplayImages.jsp' >");
							}else if(logo_Site_Facility.equals("F")){
							out.println("<img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'>");	
							}
							out.println("</td></tr></table></td></tr>");//IN066005 end
							
							if("Y".equals(textLogoHeader)){
								out.println("<tr>");	
								out.println("<td width='100%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
								out.println("</tr>");
								out.println("<tr>");	
								out.println("<td width='100%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
								out.println("</tr>");							
							}
							out.println("</table>");
						}else{


							out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
							out.println("<tr>");	
							//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>");//IN068669
							//IN066005 Starts
							if(logo_Site_Facility.equals("S")){
							out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
							}else if(logo_Site_Facility.equals("F")){
							out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
							}//IN066005 ends
							if("Y".equals(textLogoHeader)){
								out.println("<td width='60%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
								out.println("<td width='20%'  align='center'>&nbsp;</td>");
								out.println("</tr>");
								out.println("<tr>");	
								out.println("<td width='60%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
								out.println("<td width='20%'  align='center'>&nbsp;</td>");
								out.println("</tr>");
								out.println("<tr>");
								out.println("<td width='60%' colspan='2' align='center'>&nbsp;</td>");
								out.println("<td width='20%'  align='center'>&nbsp;</td>");
								out.println("</tr>");	
							}else{
								out.println("<td width='60%' align='center'>&nbsp;</h3></td>");
								out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN037045
								out.println("</tr>");
							}
							out.println("</table>");
						}

						//[IN032210] End
					}
					else
					{ 

						//out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' width='5%' id='headerImageID'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40'></td><td  align=center><h3>"+site_name+"</h3></td></tr><tr><td>&nbsp;</td><td align=center><h3>"+facility_name+"</h3></td></tr><tr><td width='5%'>&nbsp;</td><td align=center><h4>"+note_type_desc+"</h4></td></tr></table><br>"); //[IN032210]
						//[IN032210] Start
						if("Y".equals(imageLogoHeader)){
							out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
							out.println("<tr><td colspan='2'>");
							out.println("<table width='100%' style='height:100px;' border=0 cellpadding=3 cellspacing=0 align=center ><tr><td class='HEADER' align='center' id='headerImageID'>");
							//IN066005 Start
							if(logo_Site_Facility.equals("S")){
							out.println("<img src='../../eCA/jsp/CADisplayImages.jsp' >");
							}else if(logo_Site_Facility.equals("F")){
							out.println("<img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'>");	
							}out.println("</td></tr></table></td></tr>");//IN066005 end
							
							if("Y".equals(textLogoHeader)){
								 out.println("<tr>");	
								out.println("<td width='100%' colspan='2' align='center'><h3>"+site_name+"</h3></td>");
								out.println("</tr>"); 
								out.println("<tr>");	
								out.println("<td width='100%' colspan='2' align='center'><h3>"+facility_name+"</h3></td>");
								out.println("</tr>");
								out.println("<tr>");	
								out.println("<td width='100%' colspan='2' align='center'><h4>"+note_group_desc+"</h4></td>");
								out.println("</tr>");
							}
							out.println("</table>");
						}else{
							out.println("<table width='100%' border=0 cellpadding=3 cellspacing=0 align=center >");
							out.println("<tr>");	
							//out.println("<td width='20%' class='HEADER' align='center'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='40' height='40'></td>")//IN068669
							//out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
							//IN066005 Starts
							if(logo_Site_Facility.equals("S")){
							out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
							}else if(logo_Site_Facility.equals("F")){
							out.println("<td width='20%' class='HEADER' align='center' rowspan='3'><img src='../../eCommon/jsp/DisplayImages.jsp?param=facilityimage' border='0' width='"+LOGO_HDR_WIDTH+"' height='"+LOGO_HDR_HEIGHT+"'></td>");
							}//IN066005 ends
							if("Y".equals(textLogoHeader)){		
								 out.println("<td width='60%' align='center'><h3>"+site_name+"</h3></td>");    //Commented for IN073450
								out.println("<td width='20%'  align='center'>&nbsp;</td>");
								out.println("</tr>");
								out.println("<tr>"); 
								//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
								out.println("<td width='60%'  align='center'><h3>"+facility_name+"</h3></td>");
								out.println("<td width='20%'  align='center'>&nbsp;</td>");
								out.println("</tr>");
								out.println("<tr>");
								//out.println("<td width='20%'  align='center'>&nbsp;</td>");//IN068669
								out.println("<td width='60%'  align='center'><h4>"+note_group_desc+"</h4></td>");
								out.println("<td width='20%'  align='center'>&nbsp;</td>");
								out.println("</tr>");
							}else{
								out.println("<td width='60%' align='center'>&nbsp;</h3></td>");
								out.println("<td width='20%'  align='center'>&nbsp;</td></tr>");
							}
							out.println("</table>");
						}
						//IN037045 - End Modification - to have the td with 20,60,20 from 20,80	
						//[IN032210] End
					}
					
					
            _bw.write(_wl_block25Bytes, _wl_block25);

					if(rpt_hdr_all_pages.equals("N"))
					{
						
            _bw.write(_wl_block26Bytes, _wl_block26);

					}
				}
				
			//IN030419 Starts
			if(rpt_hdr_all_pages.equals("Y") && !"".equals(section_content_rpt) && !"&nbsp;".equals(section_content_rpt))//IN070668
			{
			//IN030419 Ends
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(section_content_rpt));
            _bw.write(_wl_block28Bytes, _wl_block28);
} //IN030419
			
            _bw.write(_wl_block29Bytes, _wl_block29);
//if((flag)&&facility_id.equals("GN"))//[101]
			//{//[101]
			
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(section_content_rpt));
            _bw.write(_wl_block31Bytes, _wl_block31);
//}//[101]
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(section_content_hdr));
            _bw.write(_wl_block33Bytes, _wl_block33);

					if(rpt_hdr_all_pages.equals("N") && !"".equals(section_content_rpt) && !"&nbsp;".equals(section_content_rpt))//IN070668 
					{
				
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(section_content_rpt));
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);
     notes_content1 = notes_content1.replaceAll("<IMAGE[^>]*SRC\\s*=\\s*\"[^\"]*\"[^>]*></IMAGE>", "");//ML-MMOH-SCF-2966

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(notes_content1));
            _bw.write(_wl_block38Bytes, _wl_block38);
//if((flag)&&facility_id.equals("GN"))//[101]
			//{//[101]
			if(!"".equals(section_content_ftr) && !"&nbsp;".equals(section_content_ftr)){//IN070668 
			
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(section_content_ftr));
            _bw.write(_wl_block40Bytes, _wl_block40);

			}//IN070668 
			//}//[101]
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(discharge_summary_text));
            _bw.write(_wl_block42Bytes, _wl_block42);

			
			} 
		 
	
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		//IN041924 Start.
		pstmt	=	con.prepareStatement("SELECT NOTE_PRINT_TIME_INTERVAL FROM CA_NOTE_PARAM ");
		rs		=	pstmt.executeQuery();
		if(rs.next()){
			note_print_time_interval			= Integer.parseInt(rs.getString("NOTE_PRINT_TIME_INTERVAL") == null ? "0" : (String)rs.getString("NOTE_PRINT_TIME_INTERVAL"));
		}
		if(rs!=null)	rs.close();
		if(pstmt!=null)	pstmt.close();
		//IN041924 End.
	}
		catch(Exception e)
	{
		out.println("Exception@1 : "+e);
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block43Bytes, _wl_block43);
if(sourceprintl!="" && sourceprintl.equals("CEH"))
{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(display_dis_text_print));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
            _bw.write(_wl_block46Bytes, _wl_block46);
if("Y".equals(ppFlag)){
            _bw.write(_wl_block47Bytes, _wl_block47);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
}
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(note_print_time_interval ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(note_print_time_interval ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(appl_task_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
if (waterMarkFlag.equals("Y") && ("1".equals(status) || "3".equals(status))  ) {
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
