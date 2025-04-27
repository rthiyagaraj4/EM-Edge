package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eCP.*;
import eCA.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __patassessnotesprintpreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/PatAssessNotesPrintPreview.jsp", 1709116601902L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n----------------------------------------------------------------------------------------------------------------------------\nDate       \t\tEdit History      Name        \t\tDescription\n----------------------------------------------------------------------------------------------------------------------------\n?            \t100            \t\t?           \t\tcreated\n20/09/2019\t\tIN071404\t\tSIVABAGYAM M\t\tRAMESH G    20/09/2019\t\t\t\tRegression-OR/RL-Existing Orders and Attached Images\n----------------------------------------------------------------------------------------------------------------------------\n \n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t<style>\n\t\tADDRESS\t{ FONT-FAMILY: Verdana ;FONT-SIZE: 8pt ; FONT-STYLE: NORMAL; COLOR: BLACK; }\n\t</style>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesPart2.js\'></script>\n<script>\n\nvar temp_foot =\"\";\nvar temp_hdr = \"\";\n\nfunction SysPreview()\n{\n\tvar OLECMDID = 7;\n\tvar PROMPT =2;\n\n\ttry\n\t{\n\t\tvar oWebBrowser = document.getElementById(\"WebBrowser1\");\n\n\t\tif(oWebBrowser == null)\n\t\t{\n\t\t\tvar sWebBrowser = \'<OBJECT ID = \"WebBrowser1\" width = 0 height =0 CLASSID =\"CLSID:8856F961-340A-11D0-A96B-00C04FD705A2\"> </OBJECT>\';\n\n\t\t\tdocument.body.insertAdjacentHTML(\'beforeend\',sWebBrowser);\n\n\t\t\toWebBrowser = document.getElementById(\"WebBrowser1\");\n\t\t}\n\n\t\toWebBrowser.ExecWB(OLECMDID,PROMPT);\n\t}\n\tcatch (e)\n\t{\n\t\talert(\"Failed\");\n\t}\n}\n\tfunction setHeader()\n\t{\n\t\tt = new ActiveXObject(\"WScript.Shell\"); \n\t\t\t\t\t\t\n\t\ttemp_hdr=t.RegRead(\"HKCU\\\\Software\\\\Microsoft\\\\Internet Explorer\\\\PageSetup\\\\header\");\n\t\ttemp_foot=t.RegRead(\"HKCU\\\\Software\\\\Microsoft\\\\Internet Explorer\\\\PageSetup\\\\footer\");\n\t\t\t\t\t\t \n\t\tvar pat_info1=\"Preliminary Report\";\n\t\tt.RegWrite(\"HKCU\\\\Software\\\\Microsoft\\\\Internet Explorer\\\\PageSetup\\\\header\",pat_info1+\" &bPage &p of &P\" ); \n\t\tt.RegWrite(\"HKCU\\\\Software\\\\Microsoft\\\\Internet Explorer\\\\PageSetup\\\\footer\",  pat_info1+\"&b&d\");\n\t}\n\n\tfunction theEnd()\n\t{\n\t\tt.RegWrite(\"HKCU\\\\Software\\\\Microsoft\\\\Internet Explorer\\\\PageSetup\\\\header\",\" &bPage &p of &P\" ); \n\t\tt.RegWrite(\"HKCU\\\\Software\\\\Microsoft\\\\Internet Explorer\\\\PageSetup\\\\footer\",  \"&u&b&d\");\n\t\twindow.close();\n\t}\n\n</script>\n</head>\n<body  onLoad = \"setHeader();PrevPreview()\" onUnload = \"theEnd()\" onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name = \"RecClinicalNotesSectionViewForm\">\n<center>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width = \'100%\' style=\"font-family:Verdana;:background-color:#ADADAD\">\n\t\t\t<tr>\n\t\t\t\t\t<td align=\'left\' width=\'5%\' rowspan=\'2\' colspan =\"2\">\n\t\t\t\t\t\t<img valign=\'top\' src=\'../../eCommon/images/Entilogo.jpg\' border=\'0\'>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td  align=center colspan = \"8\"><h3>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</h3>\n\t\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr >\n\t\t\t\t<td align=center colspan =\"8\"><h3>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</h3></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td>&nbsp;</td>\n\t\t\t\t\t<td align=center colspan =\"8\"><h4>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</h4></td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<br>\n\t\t\t\t<table border=\'1\' cellpadding=\'0\' cellspacing=\'0\' width = \'100%\' style=\"font-family:Verdana;:background-color:#ADADAD\">\n\t\t\t<tr>\n\t\t\t<td>\n\t\t\t<table width=\'100%\' border=0 cellpadding=0 cellspacing=0 align=center>\n\t\t\t<tr>\n\t\t\t\t\t<td nowrap colspan =\"2\"><font size=\'2\'><b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></font></td>\n\t\t\t\t\t<td nowrap colspan =\"2\" align =\"left\"><font size=\'2\'>:";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font></td>\n\t\t\t\t\t<td nowrap colspan =\"2\"><font size=\'2\'><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b></td>\n\t\t\t\t\t<td nowrap colspan = \"2\"><font size=\'2\'>:";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</font></td>\n\t\t\t</tr>\t\t\t\t\t\t\t\t\n\t\t\t<tr>\n\t\t\t\t\t<td nowrap colspan =\"2\"><font size=\'2\'><b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t\t<td nowrap colspan =\"2\" align =\"left\"><font size=\'2\'><b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b></font></td>\n\t\t\t\t\t<td nowrap colspan =\"2\"><font size=\'2\'>:";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font></td>\n\t\t\t\t\t\n\t\t\t</tr>\n\t\t\t<tr>\t\n\t\t\t\t\t<td nowrap colspan =\"4\">&nbsp;</td>\n\t\t\t\t\t<td nowrap colspan =\"2\"><font size=\'2\'><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></td>\n\t\t\t\t\t<td nowrap colspan =\"2\"><font size=\'2\'>:";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</b></font></td>\n\t\t\t\t\t<td nowrap colspan =\'2\' ><font size=\'2\'>:";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</font></td>\n\t\t\t\t\t<td nowrap colspan =\"2\" ><font size=\'2\'><b>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</b></font></td>\n\t\t\t\t\t<td nowrap colspan =\"2\"><font size=\'2\'>: ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font></td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td nowrap colspan =\"2\"><font size=\'2\'><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</b></font></td>\n\t\t\t\t<td nowrap colspan =\'2\'><font size=\'2\'>:";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font></td>\n\t\t\t\t<td nowrap colspan =\'2\'><font size=\'2\'><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</b></font></td>\n\t\t\t\t<td nowrap colspan =\"2\"><font size=\'2\'>:";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font></td>\n\t\t\t</tr>\n\t\t\t</td>\n\t\t</tr>\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t</table>\n\t\t<table border=0 cellspacing=0 width=auto width=\'100%\' style=\'font-family:Verdana;font-size:9pt\'>\n\t\t\t<tr>\n\t\t\t\t<td width=10% colspan =\"2\" nowrap><B>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</B></td>\n\t\t\t\t<td width=40% colspan =\"2\" nowrap>&nbsp;:";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t<td width=20% colspan =\"1\" align=right nowrap><b> ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" </B></td>\n\t\t\t\t<td width=20% colspan =\"3\" nowrap>&nbsp;:";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td width=10% colspan =\"2\" nowrap> <B>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</td>\n\t\t\t\t<td width=20% colspan =\"1\" align=right nowrap><b>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</B></td>\n\t\t\t\t<td width=20% colspan =\"3\" nowrap>&nbsp;:";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t\t<hr></hr>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width = \'100%\' style=\"font-family:Verdana\" >\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t<!--<tr>\n\t\t\t\t\t\t\t\t<td class=\'NOTESUBHEADER\' style=\"background-color:#ADADAD;\" colspan=3 >\n\t\t\t\t\t\t\t\t\t<font style=\"FONT-SIZE:13pt;font-weight:bold;\"> <u> <i>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</i> </u></font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>-->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<tr><td colspan=\"3\" style=\"background-color:#ADADAD;\">\n\t\t\t\t\t\t\t\t\t<font style=\"FONT-SIZE:13pt;font-weight:bold;\"><u>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</u>\n\t\t\t\t\t\t\t\t\t</font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr><tr> \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t\t\t\t<td colspan=\"3\" ><font style =\"font-family:Verdana\">";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</font>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"3\" >\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t\t\t\t<applet name=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" code=\"Drawing.class\" codebase=\"../MediPainter/\" archive=\"medipainterapplet.jar\" width=\"660\" height=\"360\" align=\"baseline\" >\n\t\t\t\t\t\t\t\t\t\t\t<param name=\"canDraw\" value=\"0\">\t\n\t\t\t\t\t\t\t\t\t\t\t<param name=\"jpeg_quality\" value=\"50\">\n\t\t\t\t\t\t\t\t\t\t\t<param name=\"image\" value =\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t\t\t\t\t\t\t\t\t</applet> \n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t</td></tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n</table>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n<table width=\'100%\' border=1 cellpadding=0 cellspacing=0 align=center>\n<tr>\n<td>\n<table width=\'100%\' border=0 cellpadding=0 cellspacing=0 align=center style=\"font-family:Verdana;:background-color:#ADADAD;font-size:9pt\">\n<tr>\n<td colspan=\"1\" nowrap align =\"left\" width=\"20%\"><b>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="&nbsp;</b></td>\n<td colspan=\"1\" nowrap align =\"left\"><font size =\"2\">: ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</td>\n</tr>\n</table>\n</td>\n</tr>\n</table>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n<table width=\'100%\' border=1 cellpadding=0 cellspacing=0 align=center>\n<tr>\n<td>\n<table width=\'100%\' border=0 cellpadding=0 cellspacing=0 align=center style=\"font-family:Verdana;:background-color:#ADADAD;font-size:9pt\">\n<tr>\n\t<td colspan=\"1\" nowrap align =\"left\" width=\"20%\"><b>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&nbsp;</b></td>\n\t<td colspan=\"1\" nowrap align =\"left\"><font size =\"2\">: ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t<tr>\n \t<td colspan=\"1\" nowrap align =\"left\" width=\"20%\"><b>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t</tr>\n    ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t</table>\n\t</td>\n\t</tr>\n\t</table>\n\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n   <br>\n\t<table width=\'100%\' border=1 cellpadding=0 cellspacing=0 align=center>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t<table width=\'100%\' border=0 cellpadding=0 cellspacing=0 align=center style=\"font-family:Verdana;:background-color:#ADADAD;font-size:9pt\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'20%\'><b>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</b></td>\n\t\t\t\t\t<td width=\'45%\' align=\'left\'>:  <font size=\'2\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</font></td>\n\t\t\t\t\t<td width=\'15%\'><b>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</b></td><td width=\'20%\' align=\'left\'>:&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'20%\'><b>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</b></td><td width=\'45%\' align=\'left\'>:  <font size=\'2\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</b></td><td width=\'20%\' align=\'left\'>:  </td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'20%\'><b>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</b></td><td width=\'45%\' align=\'left\'> <font size=\'2\'>:  ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</b></td><td width=\'20%\' align=\'left\'><font size=\'2\'>:  ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</font></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t<table width=\'100%\' border=0 cellpadding=0 cellspacing=0 align=center style=\"font-family:Verdana;:background-color:#ADADAD\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td nowrap colspan =\"8\" align =\"left\"><font size =\"1\">";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t\t\t<tr>\n\t\t\t\t</table>\n\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n</center>\n</form>\n</body>\n<script language=\'javascript\'>\n\t//changeEditorTitleForPrev(\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\");\n\n\tfunction PrevPreview()\n\t{\n\tvar i = 0\n\tvar res = confirm(\'Continue printing?\');\n\tif(res)\n\t{\n\t\twhile( i < document.applets.length ) \n\t\t{\n\t\t\tvar j = 0 ;\n\t\t\twhile ( !document.applets[i].isActive() && j++ <=75000 ) \n\t\t\t\twindow.status = i;\n\t\t\ti++;\n\t\t}\n\n\t\tSysPreview();\n\t}\n\t}\n\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</html>\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );
	
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


	
	private String replaceSpecialChars(String input)
	{
		StringBuffer temp=new StringBuffer();
		while(input.indexOf("\n")!=-1)
		{	
			int ii=input.indexOf("\n");
			temp.append(input);
			temp.replace(ii,ii+1,"<br>");
			input=temp.toString();
			temp.delete(0,temp.length());
		}
		
		return input;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

   //This file is saved on 19/11/2005.
   request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
   String locale=(String)session.getAttribute("LOCALE");
	webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	java.sql.Connection			con							=	null;

	java.sql.PreparedStatement	pstmt						=	null;
	java.sql.PreparedStatement	pstPatInfo					=	null;
	java.sql.PreparedStatement	pstmt_sysdate				=	null;
	java.sql.PreparedStatement	pstmt_discharge_time		=	null;
	java.sql.PreparedStatement	pstmt_site_name     		=	null;
	java.sql.PreparedStatement	pstmt_note_header     		=	null;
	java.sql.PreparedStatement	pstmt_event     		    =	null;
	java.sql.PreparedStatement	pstmt_addendum     		    =	null;
	java.sql.PreparedStatement	pstmt_dependency   		    =	null;
	java.sql.PreparedStatement	pstmt_term_set   		    =	null;
	java.sql.PreparedStatement	pstmt_term_code  		    =	null;
	java.sql.PreparedStatement	pstmt_section_content 		=	null;


	java.sql.ResultSet			rsPatInfo			        =	null;
	java.sql.ResultSet			rs							=	null;
	java.sql.ResultSet			rset_sysdate				=	null;
	java.sql.ResultSet			rset_discharge_time			=	null;
	java.sql.ResultSet			rset_site_name				=	null;
	java.sql.ResultSet			rset_note_header			=	null;
	java.sql.ResultSet			rset_event					=	null;
	java.sql.ResultSet			rset_addendum				=	null;
	java.sql.ResultSet			rset_dependency				=	null;
	java.sql.ResultSet			rset_term_set				=	null;
	java.sql.ResultSet			rset_term_code				=	null;
	java.sql.ResultSet			rset_section_content		=	null;
	
	String note_type				=	"",	query_section_details	=	"";
	String sec_hdg_desc			=	"",	child_sec_hdg_desc		=	"";
	String sec_content_type		=	"",	section_content			=	"";
	String editor_title			=	"";
	String child_sec_content_type	=	"";
	String image_linked_yn			=	"",	section_image_content	=	"";
	String preserve_format_yn = "";
	String StrDataAvlFlag	  =	"";
	String mode="";

	String sec_hdg_code =	"",	child_sec_hdg_code	=	"";
	String printDateTime ="";
	String attending_practitioner ="";
	String dischargeDateTime ="";
	String site_name ="";
	String speciality_name ="";
	String facility_name ="";
	String PrtMode = "N";
	String notes_header_desc = "";
	String patient_id = "";
	String patient_name = "";
	String patient_gender = "";
	String patient_age = "";
	String encounter_id = "";
	String episode_type = "";
	String visit_adm_date = "";
	String location_name = "";
	String discharge_summary_text ="";
	
	String strNoteTypeDesc = "";
	String strEventTitleCaption = "";
	String strEventAuthByCaption = "";
	String strEventDateTimeCaption = "";
	String strEventPerfByCaption = "";
	String strPerfPhyName	="";
	String strEventDateTime = "";
	String strMedService = "";
	String login_user_id		=	"";
	String addendumTxt		=	"";
	String strAuthoBy ="";
	String strModifyBy ="";
	String strAddendumFlag = "N";
    String dep_code="";
    String dep_desc="";
	String keys = "";			
	String term_set_id="";
	String term_set_desc="";
	String term_set_desc1="";
	String term_code="";
	String term_code_desc="";
	String flag_ss_ua="";
	String chkVal="";
	String chk_val_hid="";
	int mapSize=0;

	StringTokenizer diagToken = null;
	StringTokenizer chkToken = null;

	login_user_id = (String) session.getValue("login_user");

    //Diagnosis Data Starts now
	
	eCP.PatientAssessmentDiag diagBean = (eCP.PatientAssessmentDiag) session.getAttribute("diagBean");
				
    //Queries start now.

	String strPatInfoQuery = "select short_name patient_name,get_age(date_of_birth) patient_age,DECODE(Sex,'M','Male','F','Female','Unknown') Gender from mp_patient_mast where patient_id = ? "; 

	String strPatEncDtlQry = "select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') ENC_DATE,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN (SELECT SHORT_DESC FROM IP_NURSING_UNIT WHERE FACILITY_ID=A.FACILITY_ID AND NURSING_UNIT_CODE=A.ASSIGN_CARE_LOCN_CODE ) ELSE (SELECT SHORT_DESC FROM OP_CLINIC WHERE FACILITY_ID=A.FACILITY_ID AND CLINIC_CODE=A.ASSIGN_CARE_LOCN_CODE) END LOCN_DESC FROM PR_ENCOUNTER A WHERE A.FACILITY_ID=? AND A.ENCOUNTER_ID = ?";

	String strDischargeTimeQuery="";

	//String strDischargeTimeQuery="select to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, 	nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,acc_entity_name facility_name, service_short_desc specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=ca_op_episode_vw.PHYSICIAN_ID) attending_practitioner from ca_op_episode_vw where facility_id = ? and episode_id = ?";

	String sql_site_name="select site_name from sm_site_param";

	String sql_note_header="select  (select ia.DISCLIMER_TEXT from ca_disclimer_text ia, ca_note_type ib where ia.DISCLIMER_CODE=ib.DISCLIMER_CODE and ib.NOTE_TYPE=a.note_type) DIS_SUMM_DISCLAIMER_TXT,null REF_LETTER_DISCLAIMER_TXT, (select SHORT_NAME from am_practitioner where practitioner_id=a.authorized_by_id) Authorized_by_name, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(select nvl(PATIENT_NAME_LOC_LANG,'')  from MP_PATIENT where PATIENT_ID=a.patient_id) PATIENT_NAME_LOC_LANG,(select practitioner_name from am_practitioner where practitioner_id=a.last_amended_by_id) last_modified_by_name ,(select ib.REPORT_HEADER from ca_note_group ib, ca_note_type ia where ib.note_group=ia.note_group_id and ia.note_type=a.note_type)  note_header_desc from ca_encntr_note a where a.facility_id=? and a.accession_num=?";

	String sql_event="select event_type_caption, note_type,note_type_desc, service_code, short_desc service_desc, event_class, security_level, event_date_caption, to_char(event_date_time,'dd/mm/yyyy hh24:mi') event_date_time, event_perf_by_caption, performed_by_id, short_name performed_by_name, event_title_caption, event_title_desc, event_auth_by_caption, event_status_caption, decode(event_status,'1','InProgress','2','Transcribed','3','Unauthorized','4','Authorized','5','Modified') event_status from ca_encntr_note_vw where facility_id = ? and accession_num = ?";

	String sql_addendum_txt="select ADDENDUM_TEXT, b.PRACTITIONER_NAME, c.RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') from ca_encntr_note_addendum a, AM_PRACTITIONER b,SM_RESP c where a.FACILITY_ID =? and ACCESSION_NUM=? and a.PRACTITIONER_ID = b.PRACTITIONER_ID and a.RESP_ID = c.RESP_ID";

	String sql_dependency="select short_desc from cp_dependency where dependency_code=?";

	String sql_term_set="select term_set_desc from mr_term_set where term_set_id=?";

	String sql_term_code="select short_desc from mr_term_code where term_code=?";

	//Queries end here.

	try
	{ 
		PrtMode					= "Y";
		patient_id			    = checkForNull((String)request.getParameter("patient_id"));
		attending_practitioner	= checkForNull((String)request.getParameter("practitioner_id"));
		episode_type			= checkForNull((String)request.getParameter("episode_type"));
		encounter_id			= checkForNull((String)request.getParameter("encounter_id"));
		dep_code			    = checkForNull((String)request.getParameter("dep_code"));
		chk_val_hid			    = checkForNull((String)request.getParameter("chk_val_hid"));
		mode			        = checkForNull((String)request.getParameter("mode"));

		String clinician_name	= (String)session.getValue("practitioner_name");
		String resp_name		= (String)session.getValue("resp_name");
		String facility_id		= (String)session.getValue("facility_id");

		String strKey	= patient_id + "~"+encounter_id;
		strKey = strKey.trim();

		sectionBean.getPatientSection(strKey);

		if (episode_type.equals("IP"))
		{
//            strDischargeTimeQuery="select to_char(admission_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,facility_name, service_short_desc specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=ca_ip_active_episode_vw.CUR_PHYSICIAN_ID) attending_practitioner from ca_ip_active_episode_vw where facility_id = ? and episode_id = ?";
            strDischargeTimeQuery="SELECT TO_CHAR (admission_date_time, 'dd/mm/yyyy hh24:mi') visit_adm_date, NVL (TO_CHAR (discharge_date_time, 'dd/mm/yyyy hh24:mi'),'') discharge_date_time, a.facility_id, b.facility_name, c.short_desc specialty_name,(SELECT short_name FROM am_practitioner WHERE practitioner_id = a.cur_physician_id) attending_practitioner FROM ca_ip_active_episode_vw a, sm_facility_param_lang_vw b, am_speciality_lang_vw c WHERE a.facility_id = ? AND a.episode_id = ? AND a.FACILITY_ID=b.facility_id and c.SPECIALITY_CODE = a.SPECIALTY_CODE and b.LANGUAGE_ID =? and c.LANGUAGE_ID = b.LANGUAGE_ID";
		}
		else if(episode_type.equals("OP"))
		{
//			strDischargeTimeQuery="select to_char(adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, 	nvl(to_char(DISCHARGE_DATE_TIME,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,acc_entity_name facility_name, service_short_desc specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id=ca_op_episode_vw.PHYSICIAN_ID) attending_practitioner from ca_op_episode_vw where facility_id = ? and episode_id = ?";
			strDischargeTimeQuery="select to_char (adm_visit_date,'dd/mm/yyyy hh24:mi') visit_adm_date, nvl (to_char (DISCHARGE_DATE_TIME, 'dd/mm/yyyy hh24:mi'),'') DISCHARGE_DATE_TIME, a.facility_id, b.facility_name, c.short_desc specialty_name,(select SHORT_NAME from am_practitioner where practitioner_id = a.PHYSICIAN_ID) attending_practitioner     from ca_op_episode_vw a,        sm_facility_param_lang_vw b, am_speciality_lang_vw c where a.facility_id = ? and a.episode_id = ? and a.FACILITY_ID=b.FACILITY_ID and c.SPECIALITY_CODE = a.SPECIALTY_CODE and b.LANGUAGE_ID =? and c.LANGUAGE_ID = b.LANGUAGE_ID";
    	}

		String sys_date_time ="";

		//String url   = HttpUtils.getRequestURL(request).toString();//IN071404
		//url = url.substring(0,url.indexOf("eCP/jsp/"));//IN071404
//		String url   = application.getRealPath("/");//IN071404
		String url					= application.getRealPath("/eCA")+"/";
		String url1 = "";//IN071408
//		url1 = url + "eCA/html/RecClinicalNotesTemplateDispayView.xsl";
//		url =url+"eCA/html/RecClinicalNotesTemplateSentenceView.xsl";
		
		url1 = url + "html/RecClinicalNotesTemplateDispayView.xsl";
		url =url+"html/RecClinicalNotesTemplateSentenceView.xsl";
		
		String accession_num	=	checkForNull( request.getParameter("accession_num"));

		con				=	ConnectionManager.getConnection(request);
		sec_hdg_code	=	checkForNull(	request.getParameter("sec_hdg_code")	);

		try
		{
			pstmt_discharge_time=con.prepareStatement(strDischargeTimeQuery);
			pstmt_discharge_time.setString(1,facility_id);
			pstmt_discharge_time.setString(2,encounter_id);
			pstmt_discharge_time.setString(3,locale);

			rset_discharge_time=pstmt_discharge_time.executeQuery();

			if(rset_discharge_time!=null)
			{
				while(rset_discharge_time.next())
				{
                   dischargeDateTime=checkForNull(rset_discharge_time.getString("DISCHARGE_DATE_TIME"));
                   speciality_name=checkForNull(rset_discharge_time.getString("specialty_name"));
                   facility_name=checkForNull(rset_discharge_time.getString("facility_name"));
                   visit_adm_date=checkForNull(rset_discharge_time.getString("visit_adm_date"));
				}
			}
		}
		catch(Exception e1)
		{
          System.out.println("Exception in Discharge Date Time"+e1);
		}
		finally
		{
			if(rset_discharge_time!=null) rset_discharge_time.close();
			if(pstmt_discharge_time!=null) pstmt_discharge_time.close();
		}


		try
		{
			pstmt_site_name=con.prepareStatement(sql_site_name);
			rset_site_name=pstmt_site_name.executeQuery();

			if(rset_site_name!=null)
			{
				while(rset_site_name.next())
				{
                   site_name=checkForNull(rset_site_name.getString("site_name"));
				}
			}
		}
		catch(Exception e1)
		{
          System.out.println("Exception in Site Name"+e1);
		}
		finally
		{
			if(rset_site_name!=null) rset_site_name.close();
			if(pstmt_site_name!=null) pstmt_site_name.close();
		}

		try
		{
			pstmt_note_header=con.prepareStatement(sql_note_header);
			pstmt_note_header.setString(1,facility_id);
			pstmt_note_header.setString(2,accession_num);
			rset_note_header=pstmt_note_header.executeQuery();

			if(rset_note_header!=null)
			{
				while(rset_note_header.next())
				{
                   discharge_summary_text=checkForNull(rset_note_header.getString("DIS_SUMM_DISCLAIMER_TXT"));
                   notes_header_desc=checkForNull(rset_note_header.getString("note_header_desc"));
                   strAuthoBy=checkForNull(rset_note_header.getString("Authorized_by_name"));
                   strModifyBy=checkForNull(rset_note_header.getString("last_modified_by_name"));
                   printDateTime=checkForNull(rset_note_header.getString("print_date_time"));
				}
			}
		}
		catch(Exception e1)
		{
          System.out.println("Exception in Note Header"+e1);
		}
		finally
		{
			if(rset_note_header!=null) rset_note_header.close();
			if(pstmt_note_header!=null) pstmt_note_header.close();
		}


		try
		{
			pstmt_event=con.prepareStatement(sql_event);
			pstmt_event.setString(1,facility_id);
			pstmt_event.setString(2,accession_num);
			rset_event=pstmt_event.executeQuery();

			if(rset_event!=null)
			{
				while(rset_event.next())
				{
				   strEventTitleCaption=checkForNull(rset_event.getString("event_title_caption"));
				   strEventAuthByCaption=checkForNull(rset_event.getString("event_auth_by_caption"));
				   strEventPerfByCaption=checkForNull(rset_event.getString("event_perf_by_caption"));
				   strEventDateTimeCaption=checkForNull(rset_event.getString("event_date_caption"));
				   strNoteTypeDesc=checkForNull(rset_event.getString("note_type_desc"));
                   strPerfPhyName=checkForNull(rset_event.getString("performed_by_name"));
                   strEventDateTime=checkForNull(rset_event.getString("event_date_time"));
                   strMedService=checkForNull(rset_event.getString("service_desc"));
				}
			}
		}
		catch(Exception e1)
		{
          System.out.println("Exception in Event"+e1);
		}
		finally
		{
			if(rset_event!=null) rset_event.close();
			if(pstmt_event!=null) pstmt_event.close();
		}

		try
		{
			pstmt_addendum=con.prepareStatement(sql_addendum_txt);
			pstmt_addendum.setString(1,facility_id);
			pstmt_addendum.setString(2,accession_num);
			rset_addendum=pstmt_addendum.executeQuery();

			if(rset_addendum!=null)
			{
				while(rset_addendum.next())
				{
				   addendumTxt=checkForNull(rset_addendum.getString("ADDENDUM_TEXT"));
				}
			}
		}
		catch(Exception e1)
		{
          System.out.println("Exception in Addendum Text"+e1);
		}
		finally
		{
			if(rset_addendum!=null) rset_addendum.close();
			if(pstmt_addendum!=null) pstmt_addendum.close();
		}

		try
		{
			pstmt_dependency=con.prepareStatement(sql_dependency);
			pstmt_dependency.setString(1,dep_code);
			rset_dependency=pstmt_dependency.executeQuery();

			if(rset_dependency!=null)
			{
				while(rset_dependency.next())
				{
				   dep_desc=checkForNull(rset_dependency.getString("short_desc"));
				}
			}
		}
		catch(Exception e1)
		{
          System.out.println("Exception in Dependency"+e1);
		}
		finally
		{
			if(rset_dependency!=null) rset_dependency.close();
			if(pstmt_dependency!=null) pstmt_dependency.close();
		}

		//editor_title = "Print Preview";

		try
		{
				pstPatInfo	= con.prepareStatement(strPatInfoQuery);
				pstPatInfo.setString(1,patient_id);

				rsPatInfo = pstPatInfo.executeQuery();

				if(rsPatInfo.next() )
				{
					patient_name = checkForNull(rsPatInfo.getString("patient_name"));
					patient_age  = checkForNull(rsPatInfo.getString("patient_age"));
					patient_gender = checkForNull(rsPatInfo.getString("gender"));
				}	
				else
				{
					patient_name ="";
					patient_age ="";
					patient_gender ="";
				}
		}
		catch (Exception ePP)
		{
		//	out.println("Exception@1-->ePP"+ePP);//COMMON-ICN-0181
			ePP.printStackTrace(System.out);
		}
		finally
		{
			if(rsPatInfo != null) rsPatInfo.close();
			if(pstPatInfo != null) pstPatInfo.close();
		}

		try
		{
			pstPatInfo	= con.prepareStatement(strPatEncDtlQry);
			pstPatInfo.setString(1,facility_id);
			pstPatInfo.setString(2,encounter_id);

			rsPatInfo = pstPatInfo.executeQuery();

			if(rsPatInfo.next() )
			{
				location_name = checkForNull(rsPatInfo.getString("LOCN_DESC"));
			}
			else
				visit_adm_date ="";
		}
		catch (Exception ePPA)
		{
			out.println("Exception@2-->ePPA: "+ePPA);
			ePPA.printStackTrace(System.out);
		}
		finally
		{
			if(rsPatInfo != null) rsPatInfo.close();
			if(pstPatInfo != null) pstPatInfo.close();
		}

		if(PrtMode.equals("Y"))
		{
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(site_name));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(notes_header_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_gender));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_type.equals("IP")?"InPatient":"OutPatient"));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(location_name));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(dischargeDateTime));
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(speciality_name));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(attending_practitioner));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strEventTitleCaption));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strNoteTypeDesc));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strMedService));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(strEventDateTimeCaption));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strEventDateTime));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strEventPerfByCaption));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strPerfPhyName));
            _bw.write(_wl_block33Bytes, _wl_block33);

		}
		
            _bw.write(_wl_block34Bytes, _wl_block34);

				note_type=checkForNull(request.getParameter("note_type"));
       
			try
			{						
			webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();

//			query_section_details = "select sec_hdg_code, sec_hdg_desc, sec_content_type, sec_result_linked_rec_type, child_sec_hdg_code, child_sec_hdg_desc, child_sec_content_type, child_sec_result_link_rec_type, to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time, image_linked_yn, PRESERVE_FORMAT_YN from ca_note_section_view where note_type = ?  order by note_sec_seq_num, child_seq_num ";
			query_section_details = "select sec_hdg_code, sec_hdg_desc, sec_content_type, sec_result_linked_rec_type, NVL(child_sec_hdg_code,sec_hdg_code) child_sec_hdg_code, child_sec_hdg_desc, child_sec_content_type, child_sec_result_link_rec_type, to_char(SYSDATE,'dd/mm/yyyy hh24:mi:ss') sys_date_time, image_linked_yn, PRESERVE_FORMAT_YN from ca_note_section_view   where note_type = ?  order by note_sec_seq_num, child_seq_num ";

			pstmt		=	con.prepareStatement(query_section_details);
			
			pstmt.setString(1,note_type);
			
			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				section_content = "";
				section_image_content = "";
				StrDataAvlFlag	= "N";

				sec_hdg_code			=	checkForNull( rs.getString("sec_hdg_code") );
				sec_hdg_desc			=	checkForNull( rs.getString("sec_hdg_desc") );
				sec_content_type		=	checkForNull( rs.getString("sec_content_type") );
				child_sec_hdg_desc		=	checkForNull( rs.getString("child_sec_hdg_desc") );
				child_sec_hdg_code		=	checkForNull( rs.getString("child_sec_hdg_code") );
				child_sec_content_type	=	checkForNull( rs.getString("child_sec_content_type") );
				preserve_format_yn		=	checkForNull( rs.getString("PRESERVE_FORMAT_YN") );
				sys_date_time			=	rs.getString("sys_date_time");
				image_linked_yn			=	checkForNull(rs.getString("image_linked_yn"));

				try
				{
					/*if( sec_content_type.equals("S") )
					{
						if(child_sec_content_type.equals("T"))
						{
							section_content = checkForNull((String)sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code),"&nbsp;");							
							System.err.println("section_content1=="+section_content);
							if(!(section_content.equals("&nbsp;")))
								section_content=converter.buildHTMLFromXML(section_content,(preserve_format_yn.equals("Y")?url1:url));
							System.err.println("section_content2=="+section_content);
						}
						else
						{
							section_content	= checkForNull((String)sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code),"&nbsp;");
							System.err.println("section_content3=="+section_content);
							section_image_content	= (String) sectionBean.getSectionImageContent(sec_hdg_code,child_sec_hdg_code);
							System.err.println("section_image_content1=="+section_image_content);
						}

						if(!(section_content.equals("&nbsp;")) ||( section_image_content != null && !(section_image_content.equals("") ) ) )
						{
							StrDataAvlFlag	 = "Y";*/
							
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(child_sec_hdg_desc));
            _bw.write(_wl_block36Bytes, _wl_block36);

						/*}
					}*/
					
					/*if( !(sec_content_type.equals("S")) )
					{
						if(sec_content_type.equals("T"))
						{
							section_content = checkForNull( (String) sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code), "&nbsp;" );
							System.err.println("section_content4=="+section_content);
							if(!(section_content.equals("&nbsp;")))
								section_content=converter.buildHTMLFromXML(section_content,(preserve_format_yn.equals("Y")?url1:url));
							System.err.println("section_content5=="+section_content);
						}
						else
						{
							section_content = checkForNull( (String) sectionBean.getSectionContent(sec_hdg_code,child_sec_hdg_code), "&nbsp;" );
							System.err.println("section_content6=="+section_content);
							section_image_content = (String) sectionBean.getSectionImageContent(sec_hdg_code,child_sec_hdg_code);
							
							if(section_image_content == null) 
									section_image_content ="";
							System.err.println("section_image_content2=="+section_image_content);
						}
						if(!(section_content.equals("&nbsp;")) ||( section_image_content != null && !(section_image_content.equals("") ) ) )
						{
							StrDataAvlFlag	 = "Y";*/
					
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(sec_hdg_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);

						/*}
					}*/
				//HYUYGJH

					pstmt_section_content=con.prepareStatement("select NOTES_SECTION_CONTENT from ca_encntr_note_section where ACCESSION_NUM = ? and FACILITY_ID = ? and SEC_HDG_CODE = ? and  SUBSEC_HDG_CODE = ?");
					pstmt_section_content.setString(1,accession_num);
					pstmt_section_content.setString(2,facility_id);
					pstmt_section_content.setString(3,sec_hdg_code);
					pstmt_section_content.setString(4,child_sec_hdg_code);
					System.out.println("	PatAssessNotesPrintPreview.jsp--------accession_num----->"+accession_num);
					System.out.println("	PatAssessNotesPrintPreview.jsp--------facility_id----->"+facility_id);
					System.out.println("	PatAssessNotesPrintPreview.jsp--------sec_hdg_code----->"+sec_hdg_code);
					System.out.println("	PatAssessNotesPrintPreview.jsp--------child_sec_hdg_code----->"+child_sec_hdg_code);
					System.out.println("	PatAssessNotesPrintPreview.jsp--------sec_content_type----->"+sec_content_type);
					rset_section_content =	pstmt_section_content.executeQuery();					
					if(rset_section_content!=null)
					{
						while(rset_section_content.next())
						{
							section_content=rset_section_content.getString("NOTES_SECTION_CONTENT");
						}
					}
					
					if(rset_section_content!=null) rset_section_content.close();
					if(pstmt_section_content!=null) pstmt_section_content.close();
					//parse the notes_section_content
					//assign the parsed value to section_content variable
				
					if(!(section_content.equals(""))){
							
						if(sec_content_type.equals("T"))
							section_content=converter.buildHTMLFromXML(section_content,(preserve_format_yn.equals("Y")?url1:url));
						try
						{
							if(!(section_content.equals("&nbsp;")))
							{
								
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(section_content));
            _bw.write(_wl_block40Bytes, _wl_block40);

							}
						
							if(image_linked_yn.equals("Y"))
							{
								if(!section_image_content.equals(""))
								{
									if((section_content.equals("&nbsp;")))
									{
										
            _bw.write(_wl_block41Bytes, _wl_block41);

									}
									
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sec_hdg_code + child_sec_hdg_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(section_image_content));
            _bw.write(_wl_block44Bytes, _wl_block44);
	
								}
							}
							if (StrDataAvlFlag.equals("Y") )
							{
								
            _bw.write(_wl_block45Bytes, _wl_block45);

							}
							if(addendumTxt!=null && !addendumTxt.equals(""))
							{
									out.println("<tr><td colspan ='3'><table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\"  ><tr><td  width='100%' style=\"font-family:Verdana;font-size:9pt;\" >Addendum Created By: "+clinician_name+", Responsiblity: "+resp_name+", Date/Time: "+sys_date_time+"</td></tr><tr><td width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+addendumTxt+"</td></tr></table></td></tr>");

									strAddendumFlag = "Y";
									addendumTxt ="";
							}				
						}
						catch(Exception e)
						{
							//out.println("Exception caught at inter @1.33-->" + e);//COMMON-ICN-0181
							e.printStackTrace(System.err);
						}
					}

				}
				catch(Exception e)
				{
					//out.println("Exception caught at inter @1.34-->" + e);//COMMON-ICN-0181
					e.printStackTrace(System.err);
				}
			} // end of while(rs.next())
			converter=null;
		}
		catch(Exception e)
		{
			out.println("Exception@2 : "+e);
			e.printStackTrace(System.out);
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		try
		{
			String sqlAddendum = "select ADDENDUM_TEXT, b.PRACTITIONER_NAME, c.RESP_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi:ss') from ca_encntr_note_addendum a, AM_PRACTITIONER b,SM_RESP c where a.FACILITY_ID =? and ACCESSION_NUM=? and a.PRACTITIONER_ID = b.PRACTITIONER_ID and a.RESP_ID = c.RESP_ID";
			pstmt = con.prepareStatement(sqlAddendum);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,accession_num);
			rs=pstmt.executeQuery();

			String addendumText = "";
			String practName = "";
			String respName = "";
			String addedDate = "";
			while(rs.next())
			{
				addendumText = rs.getString(1);
				practName = rs.getString(2);
				respName = rs.getString(3);
				addedDate = rs.getString(4);

				if(addendumText == null) 
					 addendumText ="";

				if(practName == null)
						practName = "";

				if(respName == null)
						respName ="";

				if(addedDate == null)
						addedDate = "";

				out.println("<tr><td style=\"font-family:Verdana;font-size:9pt;\" ><table border=0 cellspacing=0 width='100%' ><tr><td   class='ADDENDUMHEADER' width='100%' style=\"font-family:Verdana;font-size:9pt;\" >Addendum Created By: "+practName+", Responsiblity: "+respName+", Date/Time: "+addedDate+"</td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+addendumText+"</td></tr></table>				</td></tr>");
			}
		}
		catch(Exception e)
		{
			//out.println("Exception@ from ca_encntr_note_addendum : "+e);//COMMON-ICN-0181
			e.printStackTrace(System.out);
		}
		finally
		{
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		
		if(strAddendumFlag.equals("N"))
		{
			if(sectionBean.getAddendumText(sec_hdg_code,child_sec_hdg_code)!=null)
			{
				out.println("<tr><td ><table border=0 cellspacing=0 width='100%' style=\"font-family:Verdana;font-size:9pt;\"  ><tr><td   class='ADDENDUMHEADER' width='100%' style=\"font-family:Verdana;font-size:9pt;\" >Addendum Created By: "+clinician_name+", Responsiblity: "+resp_name+", Date/Time: "+sys_date_time+"</td></tr><tr><td class='BODYCOLORFILLED' width='100%' style=\"font-family:Verdana;font-size:9pt;\" >"+replaceSpecialChars(sectionBean.getAddendumText(sec_hdg_code,child_sec_hdg_code))+"</td></tr></table></td></tr>");
			}
		}

            _bw.write(_wl_block46Bytes, _wl_block46);

	if(chk_val_hid.equals(""))
	{

            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(dep_desc));
            _bw.write(_wl_block49Bytes, _wl_block49);

	}
	else
	{

            _bw.write(_wl_block50Bytes, _wl_block50);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(dep_desc));
            _bw.write(_wl_block52Bytes, _wl_block52);

		ArrayList diagList = diagBean.getKeySet();		
		chkToken = new StringTokenizer(chk_val_hid,"||");

		try
		{
		while(chkToken.hasMoreTokens())
		{
			chkVal = chkToken.nextToken();

			if(chkVal.equals("Y"))
			{							
				keys = (String) diagList.get(mapSize);
				diagToken = new StringTokenizer(keys,"$");							
				term_set_id = diagToken.nextToken();
				term_code = diagToken.nextToken();
				flag_ss_ua = diagToken.nextToken();

		   		pstmt_term_code=con.prepareStatement(sql_term_code);
                pstmt_term_code.setString(1,term_code);
				rset_term_code=pstmt_term_code.executeQuery();

				if(rset_term_code!=null)
				{
					while(rset_term_code.next())
					{
                       term_code_desc=rset_term_code.getString("short_desc");
					}
				}

				if(rset_term_code!=null) rset_term_code.close();
				if(pstmt_term_code!=null) pstmt_term_code.close();

    			pstmt_term_set=con.prepareStatement(sql_term_set);
				pstmt_term_set.setString(1,term_set_id);
				rset_term_set=pstmt_term_set.executeQuery();


				if(rset_term_set!=null)
				{
					while(rset_term_set.next())
					{
                       term_set_desc=rset_term_set.getString("term_set_desc");
					}
				}

				if(rset_term_set!=null) rset_term_set.close();
				if(pstmt_term_set!=null) pstmt_term_set.close();


				if(term_set_desc1.equals(term_set_desc))
					term_set_desc1="";
				else
					term_set_desc1=term_set_desc;
	
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(term_set_desc1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(term_code_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);

		    term_set_desc1=term_set_desc;
			}
			mapSize++;
		}
		
		
            _bw.write(_wl_block55Bytes, _wl_block55);

		}
		catch(Exception e1)
		{
			//out.println("Exception in Printing Diagnosis"+e1);//COMMON-ICN-0181
             e1.printStackTrace();//COMMON-ICN-0181
		}
		finally
		{
				if(rset_term_code!=null) rset_term_code.close();
				if(rset_term_set!=null) rset_term_set.close();

				if(pstmt_term_code!=null) pstmt_term_code.close();
				if(pstmt_term_set!=null) pstmt_term_set.close();

		}
	}
	
            _bw.write(_wl_block56Bytes, _wl_block56);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strAuthoBy));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(strModifyBy));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(printDateTime));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(login_user_id));
            _bw.write(_wl_block64Bytes, _wl_block64);


		if(PrtMode.equals("Y"))
		{
			
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(discharge_summary_text));
            _bw.write(_wl_block66Bytes, _wl_block66);

		}
	} // end of try
	catch(Exception e)
	{
		//out.println("Exception@1: "+e);//COMMON-ICN-0181
		e.printStackTrace(System.out);
	} // end of catch(Exception e)
	finally
	{
		if(rs!=null) rs.close();			
		if(rsPatInfo!=null) rsPatInfo.close();
		if(rset_sysdate!=null) rset_sysdate.close();
		if(rset_discharge_time!=null) rset_discharge_time.close();
		if(rset_site_name!=null) rset_site_name.close();
		if(rset_note_header	!=null) rset_note_header.close();
		if(rset_event!=null) rset_event.close();
		if(rset_addendum!=null) rset_addendum.close();
		if(rset_dependency!=null) rset_dependency.close();
		if(rset_term_set!=null) rset_term_set.close();
		if(rset_term_code!=null) rset_term_code.close();

		if(pstmt!=null) pstmt.close();
		if(pstPatInfo!=null) pstPatInfo.close();
		if(pstmt_sysdate!=null) pstmt_sysdate.close();	
		if(pstmt_discharge_time!=null) pstmt_discharge_time.close();
		if(pstmt_site_name!=null) pstmt_site_name.close();
		if(pstmt_note_header!=null) pstmt_note_header.close();
		if(pstmt_event!=null) pstmt_event.close();
		if(pstmt_addendum!=null) pstmt_addendum.close();
		if(pstmt_dependency!=null) pstmt_dependency.close();
		if(pstmt_term_set!=null) pstmt_term_set.close();
		if(pstmt_term_code!=null) pstmt_term_code.close();

		if(con!=null)	ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(editor_title));
            _bw.write(_wl_block68Bytes, _wl_block68);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.RecClinicalNotesPrintPreviewView.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.name.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encountertype.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterdate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.dischargedate.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Med/AncService.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dependency.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Dependency.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.authorizedby.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Signature.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LastModifiedBy.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Signature.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PrintDateTime.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.LoggedUser.label", java.lang.String .class,"key"));
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
}
