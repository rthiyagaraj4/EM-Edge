package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __ambprinttripsheet extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AmbPrintTripSheet.jsp", 1709113867834L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\t\n<HEAD>\n<TITLE></TITLE>\n<!-- Added By Dharma on July 31, 2014 Start -->\n<style>\ntable, td {\nword-wrap: break-word;\nword-break: break-all;\n}\n</style>\n<!-- Added By Dharma on July 31, 2014 End-->\n</HEAD>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<BODY onLoad=\"repPrint()\">\n<form name=\"AmbPrintSheet\" id=\"AmbPrintSheet\" action=\"return true\">\n\n<!-- Start of Setting up Header and Footer -->\n<script Language=\"vbscript\">\n    Dim WSHShell\n    Dim myHeader\n    Dim myFooter\n    Set WSHShell = CreateObject(\"WScript.Shell\")\n    myHeader = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\")\n    myFooter = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\")\n\n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\",\"\"\n    WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\", \"&b&d\"\n\n    Sub ResetHeader()\n        Dim WSHShell\n        Set WSHShell = CreateObject(\"WScript.Shell\")\n        WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\", myHeader\n        WSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\", myFooter\n    End Sub\n</script>\n<!-- End of Setting up Header and Footer -->\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<table width=\'100%\' border=\'0\'>\n<tr>\n\t<td width=\'10%\'><img width=\'75\' height=\'75\' src=\'../../eCommon/images/Entilogo.jpg\'></img></td>\n\t<td width=\'87%\'valign=\'center\'><p align=\'center\'><font size=\'5\'> <b>";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="<br>Patient Transport Sheet</b></font></p></td>\n</tr>\n<tr>\n\t<td>&nbsp;</td>\n</tr>\n</table>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<table width=\'100%\' align=\'center\' valign=\'top\' cellpadding=\'1\' cellspacing=\'0\' border=\'1\' bordercolor=#330066>\n\t<tr>\n\t\t<td width=\'30%\' height=\'40\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Incident Number :&nbsp;</b> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</font></td>\n\t\t<td width=\'30%\' height=\'40\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Type of Call :&nbsp;</b>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" <br></font></td>\n\t\t<td colspan=\'3\' height=\'40\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Incident date :&nbsp;</b>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</font></td>\n\t</tr>\n\n\t<tr>\n\t\t<td width=\'30%\' height=\'40\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Pickup Location :&nbsp;</b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</font></td>\n\t\t<td width=\'30%\' height=\'40\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Dropping Location :&nbsp;</b>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</font></td>\n\t\t<td width=\'20%\' height=\'40\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Dispatcher TOC :&nbsp;</b></font></td>\n\t\t<td colspan=\'2\' width=\'20%\' height=\'40\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Prescheduled Pickup Time :&nbsp;</b></font></td>\n\t</tr>\n\n\t<tr>\n\t\t<td width=\'30%\' height=\'40\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Pickup Address :&nbsp;</b>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</font></td>\n\t\t<td width=\'30%\' height=\'40\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Dropping Address :&nbsp;</b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font></td>\n\t\t<td rowspan = \'3\' colspan = \'3\' height=\'40\' valign=\'top\'>\n\t\t\t<table width=\'100%\' height=\'40\'  align=\'left\' valign=\'top\' border=\'1\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan = \'3\' height=\'20\' align=\'center\' valign=\'center\'  bgcolor=#D8D8D8 style=\"border :0px\"> <font size=\'4\'><b>Times</b></font></td>\n\t\t\t\t</tr>\n\t\t\t    <tr>\n\t\t\t\t\t<td width=\'50%\' height=\'20\' align=\'left\' valign=\'top\' bgcolor=#D8D8D8 style=\"border :0px\"> <font size=\'2\'><b>&nbsp;</b></font></td>\n\t\t\t\t\t<td width=\'30%\' height=\'20\' align=\'center\' valign=\'top\' bgcolor=#D8D8D8 style=\"border :0px\"> <font size=\'2\'><b>Date</b></font></td>\n\t\t\t\t\t<td width=\'20%\' height=\'20\' align=\'center\' valign=\'top\' bgcolor=#D8D8D8 style=\"border :0px\"> <font size=\'2\'><b>Time</b></font></td>\n\t\t\t    </tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'50%\' height=\'20\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Call Rec\'d </b></font></td>\n\t\t\t\t\t<td width=\'30%\' height=\'20\' align=\'center\' valign=\'top\'> <font size=\'2\'><b>&nbsp;</b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</font></td>\n\t\t\t\t\t<td width=\'20%\' height=\'20\' align=\'center\' valign=\'top\'> <font size=\'2\'><b>&nbsp;</b>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</font></td>\n\t\t\t\t</tr>\n\t\t\t    <tr>\n\t\t\t\t\t<td width=\'50%\' height=\'20\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Dispatched</b></font></td>\n\t\t\t\t\t<td width=\'30%\' height=\'20\' align=\'center\' valign=\'top\'> <font size=\'2\'><b>&nbsp;</b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font></td>\n\t\t\t    </tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'50%\' height=\'20\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Location </b></font></td>\n\t\t\t\t\t<td width=\'30%\' height=\'20\' align=\'center\' valign=\'top\'> <font size=\'2\'><b>&nbsp;</b></font></td>\n\t\t\t\t\t<td width=\'20%\' height=\'20\' align=\'center\' valign=\'top\'> <font size=\'2\'><b>&nbsp;</b></font></td>\n\t\t\t\t</tr>\n\t\t\t    <tr>\n\t\t\t\t\t<td width=\'50%\' height=\'20\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Destination</b></font></td>\n\t\t\t\t\t<td width=\'30%\' height=\'20\' align=\'center\' valign=\'top\'> <font size=\'2\'><b>&nbsp;</b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font></td>\n\t\t\t    </tr>\n\n\t\t   </table>\n\t\t</td>\n\t</tr>\n\n\t<tr>\n\t\t<td width=\'30%\' height=\'40\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Requester name :&nbsp;</b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font></td>\n\t\t<td width=\'30%\' height=\'40\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Requester Contact :&nbsp;</b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font></td>\n\t</tr>\n\n\t<tr>\n\t\t<td colspan = \'2\' width=\'30%\' height=\'40\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Request Remarks :&nbsp;</b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</font></td>\n\t</tr>\n\n\t<tr>\n\t\t<td colspan =\'2\' width=\'60%\' height=\'40\' align=\'left\' valign=\'top\'>\n\t\t\t<table width=\'100%\' height=\'40\'  align=\'left\' valign=\'top\' border=\'0\' cellpadding=\'0\' cellspacing=\'0\' >\n\t\t\t\t\t<tr>\n\t<!-- Start of Patient Address Block -->\n\t\t\t\t\t\t<td width=\'80%\' height=\'200\' align=\'left\'>\n\t\t\t\t\t\t\t<table width=\'100%\' height=\'200\' border=\'1\' cellpadding=\'0\' cellspacing=\'0\'>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td rowspan=\'5\' width=\'6%\' bgcolor=#D8D8D8> \n\t\t\t\t\t\t\t\t\t<p align=\'center\'><font size=\'4\'><b>P<br>A<br>T<br>I<br>E<br>N<br>T </b></font></p>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\'4\' width=\'94%\' height=\'120\' valign=\'top\' style=\"border :0px\"><font size=\'2\'><b>Patient Name : &nbsp;</b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</font></td>\n\t\t\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\'21%\' height=\'40\' valign=\'top\'><font size=\'2\'><b>Age :&nbsp</b> ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</font></td>\n\t\t\t\t\t\t\t\t\t<td width=\'21%\' valign=\'top\'><font size=\'2\'><b>DOB :&nbsp;</b>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font></td>\n\t\t\t\t\t\t\t\t\t<td width=\'21%\' valign=\'top\'><font size=\'2\'><b>Gender :&nbsp;</b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font></td>\n\t\t\t\t\t\t\t\t\t<td width=\'21%\' valign=\'top\'><font size=\'2\'><b>Phone :</b></font></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\'4\' width=\'94%\' height=\'32\' valign=\'top\'><font size=\'2\'><b>Condition:</b></font></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\'4\' width=\'94%\' height=\'30\' valign=\'top\'><font size=\'2\'><b>Chief Complaint :</b></font></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t<!-- end of Patient Address Block -->\n\t\t\t\t\t\t<td width=\'80%\' height=\'196\' align=\'left\' valign=\'top\'><font size=\'2\'><b>Escorted By :</b></font></td>\n\t\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t\t<td colspan =\'3\' width=\'40%\' height=\'30\' align=\'left\' valign=\'top\'>\n\t\t\t<table width=\'100%\' align=\'left\' valign=\'top\' border=\'1\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan =\'3\' width=\'50%\' height=\'46\' align=\'center\' valign=\'center\' bgcolor=\'#D8D8D8\' border=\'0\' style=\"border :0px\"> <font size=\'4\'><b>Est.&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</b></font></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'50%\' height=\'23\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>To Scene </b></font></td>\n\t\t\t\t\t<td width=\'50%\' height=\'23\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>&nbsp; </b></font></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'50%\' height=\'23\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>To Dest</b></font></td>\n\t\t\t\t\t<td width=\'50%\' height=\'23\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>&nbsp ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" </b></font></td>\n\t\t\t\t</tr>\n\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan =\'3\' width=\'50%\' height=\'46\' align=\'center\' valign=\'center\' bgcolor=\'#D8D8D8\' border=\'0\'> <font size=\'4\' ><b>Odometer </b></font></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'50%\' height=\'23\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Start Mileage </b></font></td>\n\t\t\t\t\t<td width=\'50%\' height=\'23\' align=\'center\' valign=\'top\'> <font size=\'2\'>&nbsp";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'50%\' height=\'23\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>End Mileage</b></font></td>\n\t\t\t\t\t<td width=\'50%\' height=\'23\' align=\'center\' valign=\'top\'> <font size=\'2\'>&nbsp";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'50%\' height=\'23\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>Total </b></font></td>\n\t\t\t\t\t<td width=\'50%\' height=\'23\' align=\'left\' valign=\'top\'> <font size=\'2\'><b>&nbsp";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" </b></font></td>\n\t\t\t\t</tr>\n\t\t    </table>\n\t\t</td>\n\t</tr>\n\t\n\n\t<tr>\n\t\t<td colspan =\'2\' height=\'40\' align=\'left\' valign=\'top\'>\n\t\t\t<table width=\'100%\' border=\'1\'>\n\t\t\t\t<tr style =\"background-color :#D8D8D8\">\n\t\t\t\t\t<td align=\'center\'><font size=\'4\' ><b>Equipment</b></font></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'left\'><font size=\'4\'>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t</font></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t\t<td colspan =\'3\' width=\'50%\' height=\'40\' align=\'center\' valign=\'center\' border=\'0\'>\n\t\t\t<table width=\'100%\' border=\'1\'>\n\t\t\t\t<tr style =\"background-color :#D8D8D8\">\n\t\t\t\t\t<td align=\'center\'><font size=\'4\' ><b>Resources</b></font></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'left\'><font size=\'2\'>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t</font></td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n\n\t<tr>\n\t\t<td colspan =\'5\' height=\'300\'>\n\t\t\t<table width=\'100%\' border=\'0\'>\n\t\t\t\t<tr height=\'50\'>\n\t\t\t\t\t<td width=\'30%\' valign=\'bottom\'>\n\t\t\t\t\t\t<font size=\'2\'><b><br>--------------------------------<br>Person Receiving Patient</b></font>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'30%\' valign=\'bottom\'>\n\t\t\t\t\t\t<font size=\'2\'><b><br>--------------------------------<br>Date/Time</b></font>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'30%\' valign=\'bottom\'>\n\t\t\t\t\t\t<font size=\'2\'><b><br>--------------------------------<br>Driver</b></font>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr height=\'50\'>\n\t\t\t\t\t<td width=\'30%\' valign=\'bottom\'>\n\t\t\t\t\t\t<font size=\'2\'><b><br>--------------------------------<br>Authorizing Physician</b></font>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'30%\' valign=\'bottom\'>\n\t\t\t\t\t\t<font size=\'2\'><b><br>--------------------------------<br>Date/Time</b></font>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'30%\' valign=\'bottom\'>\n\t\t\t\t\t\t<font size=\'2\'><b><br>--------------------------------<br>Attendant</b></font>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</td>\n\t</tr>\n</table>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\n\n\t<script name=\"javascript\">\n\t\tfunction repPrint()\n\t\t{\n\t\t\tif (document.all)\n\t\t\t{\n\t\t\t\tvar res= confirm(\"Continue Printing?\");\n\t\t\t\tif (res)\n\t\t\t\t{\n\t\t\t\twindow.print();\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n\n</form>\n</BODY>\n\n</HTML>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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

Connection con = null;
Statement stmt = null;
Statement stmt1 = null;
ResultSet rset = null;
ResultSet rset1 = null;

String p_facility_id = (String)session.getAttribute("facility_id");
String p_amb_case_no = request.getParameter("p_trip_no");
String fac_name="";

            _bw.write(_wl_block2Bytes, _wl_block2);

try
	{
		con = ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		String str2 = "select facility_name from sm_facility_param where facility_id='"+p_facility_id+"'";
		rset = stmt.executeQuery(str2);

		if (rset !=null)
		{
			while(rset.next())
			{
				fac_name = rset.getString("facility_name");
			}
		}
		if (stmt !=null)
			stmt.close();
		if (rset !=null)
			rset.close();
	}

	catch(Exception e)
	{
	//out.println(e);
	e.printStackTrace();
	}

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(fac_name));
            _bw.write(_wl_block4Bytes, _wl_block4);


try
	{
		stmt = con.createStatement();
		String sql ="SELECT	A.FACILITY_ID FACILITY_ID,A.AMB_CASE_NO AMB_CASE_NO,to_char(A.AMB_CASE_BOOKED_DATE,'dd/mm/yyyy hh24:mi') AMB_CASE_BOOKED_DATE, A.AMB_VEHICLE_ID    AMB_VEHICLE_ID,    To_char(A.AMB_CASE_START_DATE,'dd/mm/yyyy hh24:mi')    AMB_CASE_START_DATE,to_char(A.AMB_CASE_END_DATE,'dd/mm/yyyy hh24:mi') AMB_CASE_END_DATE, A.PATIENT_ID PATIENT_ID ,nvl((select patient_name  || '/' ||  sex  || '/' || get_age(date_of_birth)    from mp_patient where patient_id  =a.patient_id),    patient_name  || '/' ||  a.sex  || '/' || get_age(a.date_of_birth)  ) PATIENT_NAME , TO_CHAR(A.DATE_OF_BIRTH,'DD/MM/YYYY')  DATE_OF_BIRTH,upper(A.AGE) AGE, decode(A.SEX,'M','Male','F','Female','U','Unknown') SEX,A.PICKUP_FROM_HOSP_YN PICKUP_FROM_HOSP_YN,A.PICKUP_LOCN_CODE PICKUP_LOCN_CODE,  NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.PICKUP_LOCN_CODE and rownum <=1),PICKUP_LOCN_DESC) PICKUP_LOCN_DESC, A.PICKUP_ADDRESS    PICKUP_ADDRESS,A.DESTN_LOCN_CODE DESTN_LOCN_CODE ,  NVL((select LONG_DESC   from MP_RES_TOWN where RES_TOWN_CODE = A.DESTN_LOCN_CODE and rownum <=1),A.DESTN_LOCN_DESC) DESTN_LOCN_DESC,  A.DESTN_ADDRESS DESTN_ADDRESS ,A.AMB_CALLER_NAME AMB_CALLER_NAME ,A.AMB_CALLER_CONTACT_NO AMB_CALLER_CONTACT_NO,A.AMB_CALLER_REMARKS AMB_CALLER_REMARKS,    A.AMB_NATURE_CALL_CODE AMB_NATURE_CALL_CODE ,(SELECT LONG_DESC FROM AE_AMB_NATURE WHERE AMB_NATURE_CODE = A.AMB_NATURE_CALL_CODE) NATURE_CALL_DESC,    decode(A.AMB_PRIORITY_IND,'L','Low','H','High','M','Medium')  AMB_PRIORITY_IND,A.AMB_CASE_STATUS AMB_CASE_STATUS,A.AMB_START_MILEAGE AMB_START_MILEAGE,   A.AMB_END_MILEAGE AMB_END_MILEAGE,A.AMB_DISP_REMARKS AMB_DISP_REMARKS ,C.AMB_CURRENT_LOCATION CURRENT_LOCATION ,B.AMB_VEHICLE_NAME AMB_VEHICLE_NAME,  B.AMB_REGN_NO AMB_REGN_NO, B.AMB_MODEL_NO AMB_MODEL_NO,B.AMB_DATE_MANUFCT AMB_DATE_MANUFCT,B.AMB_LAST_MILEAGE AMB_LAST_MILEAGE,  B.AMB_REMARKS AMB_REMARKS ,to_char(a.AMB_CASE_BOOKED_DATE,'dd/mm/yyyy') added_date,     to_char(a.AMB_CASE_BOOKED_DATE,'hh24:mi') added_time ,TO_CHAR (a.amb_case_start_date,'dd/mm/yyyy') disp_start_date,       TO_CHAR (a.amb_case_start_date,'hh24:mi') disp_start_time, TO_CHAR (a.amb_case_end_date, 'dd/mm/yyyy') disp_end_date,TO_CHAR (a.amb_case_end_date, 'hh24:mi') disp_end_time,patient_name pat_name,nvl(amb_uom,'Mileage') amb_uom,A.AMB_EXP_DIST_COVERED,A.AMB_DIST_COVERED FROM    AE_AMB_CASE_REQUEST A , AE_AMB_VEHICLE B,AE_AMB_OPEN_REQUEST C WHERE    A.FACILITY_ID = '"+p_facility_id+"' AND    A.AMB_CASE_NO = '"+p_amb_case_no+"' AND    A.FACILITY_ID = B.FACILITY_ID (+) AND    A.AMB_VEHICLE_ID = B.AMB_VEHICLE_ID (+) AND    A.FACILITY_ID = C.FACILITY_ID (+)AND    A.AMB_CASE_NO = C.AMB_CASE_NO (+)";
		rset = stmt.executeQuery(sql.toString());

		if (rset!=null)
		{
			while(rset.next())
			{

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(checkForNull(rset.getString("amb_case_no")) ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(checkForNull(rset.getString("nature_call_desc"))));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(checkForNull(rset.getString("amb_case_booked_date"))));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(checkForNull(rset.getString("pickup_locn_desc"))));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(checkForNull(rset.getString("destn_locn_desc"))));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(checkForNull(rset.getString("pickup_address"))));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(checkForNull(rset.getString("destn_address"))));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(checkForNull(rset.getString("added_date"))));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checkForNull(rset.getString("added_time"))));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(checkForNull(rset.getString("disp_start_date"))));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checkForNull(rset.getString("disp_start_time"))));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(checkForNull(rset.getString("disp_end_date"))));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(checkForNull(rset.getString("disp_end_time"))));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(checkForNull(rset.getString("amb_caller_name"))));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(checkForNull(rset.getString("amb_caller_contact_no"))));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(checkForNull(rset.getString("amb_caller_remarks"))));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(checkForNull(rset.getString("pat_name"))));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(checkForNull(rset.getString("age"))));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(checkForNull(rset.getString("date_of_birth"))));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(checkForNull(rset.getString("sex"))));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(checkForNull(rset.getString("amb_uom"))));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(checkForNull(rset.getString("amb_exp_dist_covered"))));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(checkForNull(rset.getString("amb_start_mileage"))));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(checkForNull(rset.getString("amb_end_mileage"))));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(checkForNull(rset.getString("amb_dist_covered"))));
            _bw.write(_wl_block28Bytes, _wl_block28);

	try
		{
		//con1 = ConnectionManager.getConnection(request);
		stmt1 = con.createStatement();
		String sql2 = "select amb_equipment_code,(select long_desc from am_resource where resource_id=a.amb_equipment_code) amb_equipment_desc from AE_AMB_REQUEST_EQUIP a where facility_id = '"+p_facility_id+"'  and amb_case_no = '"+p_amb_case_no+"'";
		rset1 = stmt1.executeQuery(sql2);
		if (rset1 !=null)
			{
				while(rset1.next())
				{
					out.println("<font size='2'>"+checkForNull(rset1.getString("amb_equipment_desc"))+"</font><br>");				
				}
			}
		if (stmt1 !=null)
			stmt1.close();
		if (rset1 !=null)
			rset1.close();
		}
	catch(Exception e)
		{
			//out.println(e +"  Sub block1 Block");
			e.printStackTrace();
		}


            _bw.write(_wl_block29Bytes, _wl_block29);

	try
		{
		stmt1 = con.createStatement();
		String sql2 = "SELECT amb_resource_id,A.AMB_RESOURCE_TYPE amb_resource_type, (CASE WHEN A.AMB_RESOURCE_TYPE = 'P' THEN ( SELECT    practitioner_name || (SELECT ' ('||position_desc||')'  FROM am_position WHERE position_code = a.position_code) resource_desc FROM am_practitioner a WHERE UPPER (practitioner_id) LIKE UPPER (a.amb_resource_id) AND eff_status = 'E') WHEN A.AMB_RESOURCE_TYPE = 'E' THEN (SELECT practitioner_name|| (SELECT ' ('||position_desc||')' FROM am_position WHERE position_code = a.position_code) resource_desc FROM am_ext_practitioner a WHERE UPPER (practitioner_id) LIKE UPPER (a.amb_resource_id) AND eff_status = 'E') WHEN A.AMB_RESOURCE_TYPE  = 'O' THEN (SELECT  other_staff_name||' ('||(SELECT long_desc FROM am_other_staff_type WHERE other_staff_type = a.other_staff_type)||')' resource_desc FROM am_other_staff a WHERE UPPER (other_staff_id) LIKE UPPER (a.amb_resource_id) AND eff_status = 'E') ELSE '' END ) amb_resource_desc FROM ae_amb_request_resource a WHERE facility_id = '"+p_facility_id+"' AND amb_case_no = '"+p_amb_case_no+"'";

		rset1 = stmt1.executeQuery(sql2);
		if (rset1 !=null)
			{
				while(rset1.next())
				{
					out.println("<font size='2'>"+checkForNull(rset1.getString("amb_resource_desc"))+"</font><br>");				
				}
			}
		if (stmt1 !=null)
			stmt1.close();
		if (rset1 !=null)
			rset1.close();
		}
	catch(Exception e)
		{
			//out.println(e+"  Sub block2 Block");
			e.printStackTrace();
		}

            _bw.write(_wl_block30Bytes, _wl_block30);

			}
		}

		if (stmt !=null)
			stmt.close();
		if (rset !=null)
			rset.close();
	}
catch(Exception e)
	{
	//out.println(e +"  Main Block");
	e.printStackTrace();
	}
finally
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con,request);
		}
	}

            _bw.write(_wl_block31Bytes, _wl_block31);
            _bw.write(_wl_block32Bytes, _wl_block32);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
