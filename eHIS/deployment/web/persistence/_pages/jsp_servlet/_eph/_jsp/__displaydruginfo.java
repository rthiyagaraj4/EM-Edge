package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __displaydruginfo extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DisplayDrugInfo.jsp", 1709120702646L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../ePH/js/FDBDrugInfo.js\"></SCRIPT><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t</head>\n\t<body> \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t<table id=\"TblEquiv\" name=\"TblEquiv\" id=\"TblEquiv\" width=\"100%\"  height=\"100%\">\n\t\t\t\t<TBODY     vALIGN =\"TOP\" >\n\t\t\t\t\t<tr><td style=\"BACKGROUND-COLOR:#FFFFCC\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t\t\t<table width=\"100%\" >\n\t\t\t\t\t\t\t\t\t\t<TR><Th  align=\"left\" colspan=2 > AHFS Classification</Th></TR>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<TR ><TD  width=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="%\" style=\"BACKGROUND-COLOR:#FFFFCC\"></td><TD  width=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="%\" style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td></tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t<table>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t<table width=\"100%\">\n\t\t\t\t\t\t\t\t\t\t<TR><Th  align=\"left\" colspan=2 > FDB Classification</Th></TR>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<table width=\"100%\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<TR ><TD  width=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td></tr>\n\t\t\t\t\t\t\t\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t</td></tr>\n\t\t\t\t\t</TBODY>\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t<table id=\"TblIndications\" name=\"TblIndications\" id=\"TblIndications\" width=\"100%\" height=\"100%\">\n\t\t\t\t<TBODY     vALIGN =\"TOP\" >\n\t\t\t\t\t<tr><td style=\"BACKGROUND-COLOR:#FFFFCC\">\n\t\t\t\t\t\t<table>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t<!--  <TR><Th  align=\"left\" id=\"header\" colspan=2> Drug Interaction</Th></TR> -->\n\t\t\t\t\t\t\t\t<TR ><Th colspan=2 >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</Th></TR>\n\t\t\t\t\t\t\t\t<TR ><TD  style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Severity   </b></td>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\t\t<td  style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</TD></TR>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t\t\t<td style=\"BACKGROUND-COLOR:#FFFFCC\">&nbsp;&nbsp;</TD></TR>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t\t\t<TR ><TD  style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Clinical Effect    </b></td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t<td  style=\"BACKGROUND-COLOR:#FFFFCC\">&nbsp;&nbsp;</TD></TR>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t<TR ><TD colspan=2  style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Support Documentation   </b> </td> </tr>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="               \n\t\t\t\t\t\t\t\t\t\t\t<tr><td  style=\"BACKGROUND-COLOR:#FFFFCC\">&nbsp;</td> <td  style=\"BACKGROUND-COLOR:#FFFFCC\"><Li>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</Li></TD></tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t\t<TR ><TD colspan=2 style=\"BACKGROUND-COLOR:#FFFFCC\"><b>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</b></td><tr>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="               \n\t\t\t\t\t\t\t\t\t\t\t<tr><td  style=\"BACKGROUND-COLOR:#FFFFCC\">&nbsp;</td><td style=\"BACKGROUND-COLOR:#FFFFCC\"><Li>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</Li></TD></TR>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t<TR><TD style=\"color:red\" style=\"BACKGROUND-COLOR:#FFFFCC\"> No Relevant Information found</TD></TR>\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td></tr>\n\t\t\t\t\t</TBODY  >\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t<table id=\"TblPrecautions\" name=\"TblPrecautions\" id=\"TblPrecautions\" width=\"100%\" height=\"100%\">\n\t\t\t\t\t<TBODY     vALIGN =\"TOP\" >\n\t\t\t\t\t\t<tr><td style=\"BACKGROUND-COLOR:#FFFFCC\">\n\t\t\t\t\t\t\t<table>\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n<!-- <TR ><Th  align=\"left\" id=\"header\" colspan=2>Precautions</Th></TR> -->\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t<TR><Th  align=\"left\" id=\"header\" colspan=2>Geriatric Precautions</Th></TR>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t <TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Severity  </b> </td><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</TD></TR>\n\t\t\t\t\t\t\t\t\t\t\t <TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Comment   </b> </td><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</TD></TR> \n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t\t\t  <TR><Th  align=\"left\" id=\"header\"  colspan=2>Lactation Precautions</Th></TR>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t\t\t<TR ><TD  style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Severity          </b> </td><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</TD></TR>\n\t\t\t\t\t\t\t\t\t\t\t<TR ><TD  style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Exerection Effect </b> </td><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</TD></TR>\n\t\t\t\t\t\t\t\t\t\t\t<TR ><TD  style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Lactation  effect </b> </td><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</TD></TR>\n\t\t\t\t\t\t\t\t\t\t\t<TR ><TD  style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Comment           </b> </td><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</TD></TR>  \n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t\t\t\t\t\t<TR><Th  align=\"left\" id=\"header\" colspan=2>Pediatric Precautions</Th></TR>\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Severity   </b> </td><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</TD></TR>\n\t\t\t\t\t\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Comment    </b> </td><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t<TR><Th  align=\"left\" id=\"header\" colspan=2>Pregnency Precautions</Th></TR>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Significance </b></td><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</TD></TR>\n\t\t\t\t\t\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b>Comment      </b></td><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t\t\t\t<TR><TD style=\"color:red\"> No Relevant Information found</TD></TR>\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</TD></TR>\n\t\t\t\t\t</TBODY >\n\t\t\t\t</TABLE>\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t\t\t<table id=\"TblADE\" name=\"TblADE\" id=\"TblADE\" width=\"100%\" border=1  height=\"100%\">\n\t\t\t\t\t<TBODY     vALIGN =\"TOP\" >\n\t\t\t\t\t\t<tr><td style=\"BACKGROUND-COLOR:#FFFFCC\">\n\t\t\t\t\t\t\t<table width=\"100%\" border=1>\n\n<!-- <TR><Th align=\"left\" id=\"header\" colspan=3>Common Orders</Th></TR> -->\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<tr><th>child (Age Range :0-13 Years)</th></tr>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr><td colspan=3 align =\'left\'  style=\"BACKGROUND-COLOR:#FFFFCC;color:red\"><b> Indication  : ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</b></td></tr> \n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr><th ><b> Dose Type</b></th><th><b> Route</b></th><th ><b> Order String</b></th></tr> \n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<tr><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="<br>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td></tr>       \n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\t  \n\t\t\t\t\t\t\t\t\t\t\t\t<tr><td style=\"BACKGROUND-COLOR:#FFFFCC\"  colspan=3><font size=\"3\"><b>Adults </b></font>(Age Range :13-65 Years)</td></tr>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<tr><td colspan=3 align =\'left\' style=\"BACKGROUND-COLOR:#FFFFCC;color:red\"><b> Indication  : ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td></tr>   \n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\t  \n\t\t\t\t\t\t\t\t\t\t\t\t<tr><th>Elders (Age Range : >65 Years)</th></tr>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td></tr>\n\t\t\t\t\t</TBODY >\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t<table id=\"TblFood\" name=\"TblFood\" id=\"TblFood\" width=\"100%\" HEIGHT=\"100%\" >\n\t\t\t\t\t<TBODY     vALIGN =\"TOP\" >\n\t\t\t\t\t\t<tr><td style=\"BACKGROUND-COLOR:#FFFFCC\">\n\t\t\t\t\t\t\t<table>\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\t\n<!-- <TR><Th  align=\"left\" id=\"header\">Food Interactions</Th></TR>\t -->\n";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t<TR ><TD  style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t</TD></TR>\n\t\t\t\t\t</TBODY >\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t<table id=\"TblContra\" name=\"TblContra\" id=\"TblContra\" width=\"100%\"  height=\"100%\">\n\t\t\t\t\t<TBODY     vALIGN =\"TOP\" >\n\t\t\t\t\t\t<tr><td style=\"BACKGROUND-COLOR:#FFFFCC\">\n\t\t\t\t\t\t\t<table  width=\"100%\">\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\t\n<!-- <TR><Th align=\"left\" id=\"header\" colspan=2>Contra Indications</Th></TR> -->\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t\t<TR><Th align=\"left\" id=\"header\" colspan=2 WIDTH=\"100%\">Absolute Contraindications</Th></TR>\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="   </td><td style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t\t\t\t\t\t<TR><Th align=\"left\" id=\"header\" colspan=2 WIDTH=\"100%\">Extreme Caution</Th></TR>\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="   </td><td style=\"BACKGROUND-COLOR:#FFFFCC\"> ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\t\t\t\t\t<TR><Th align=\"left\" id=\"header\" colspan=2 WIDTH=\"100%\">Warning</Th></TR>\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t</TD></TR>\t\n\t\t\t\t\t<TBODY >\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t<table id=\"TblInfo\" name=\"TblInfo\" id=\"TblInfo\" width=\"100%\"  height=\"100%\">\n\t\t\t\t\t<TBODY     vALIGN =\"TOP\" >\n\t\t\t\t\t\t<tr><td style=\"BACKGROUND-COLOR:#FFFFCC\">\n\t\t\t\t\t\t\t<table width=\"100%\">\n<!-- <TR><Th align=\"left\" id=\"header\"colspan=2>Side Effects</Th></TR> -->\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t<TR><Th align=\"left\" id=\"header\" colspan=2>SEVERE</Th></TR>\n";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="                \n\t\t\t\t\t\t\t\t\t\t<TR ><Td colspan=2 style=\"BACKGROUND-COLOR:#FFFFCC;color:red\"><b>";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</b> </td></Tr>\n\t\t\t\t\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b> Severity         :</b> ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="  </td><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b> Frequency              : </b>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="   </td></TR>\n\t\t\t\t\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b> Lab Test         : </b>";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="  </td><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b> Visibility             : </b>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="   </td></TR>\n\t\t\t\t\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b> Hypersensitivity :</b> ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="  </td><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b> Physician Intervention : </b>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="   </td></TR>\n\t\t\t\t\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\" colspan=2><hr></hr>  </td></TR>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t\t\t\t\t\t\t\t\t<TR><Th align=\"left\" id=\"header\" colspan=2>LESS SEVERE</Th></TR>\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t\t\t\t\t\t\t<TR ><Td style=\"BACKGROUND-COLOR:#FFFFCC;color:red\" colspan=2><b>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</b> </td></Tr>\n\t\t\t\t\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b> Severity         : </b>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="  </td><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b> Frequency              :</b> ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="   </td></TR>\n\t\t\t\t\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\"><b> Hypersensitivity : </b>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="   </td></TR>\n\t\t\t\t\t\t\t\t\t\t<TR ><TD  style=\"BACKGROUND-COLOR:#FFFFCC\"colspan=2><hr></hr>  </td></TR>\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t</TD></TR>\t\n\t\t\t\t\t</TBODY >\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t<table id=\"TblCounsel\" name=\"TblOverDose\" id=\"TblOverDose\" width=\"100%\"  height=\"100%\">\n\t\t\t\t\t<TBODY     vALIGN =\"TOP\" >\n\n<!-- <TR><Th align=\"left\" id=\"header\">Over Dose</Th></TR> -->\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" </td></tr>\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t\t\t\t\t<TR><TD style=\"color:red\"> No Relevant Information found</TD></TR>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t\t</TBODY>\t\t\t\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t<table id=\"TblCounsel\" name=\"TblCounsel\" id=\"TblCounsel\" width=\"100%\"  >\n\t\t\t\t\t<TBODY   vALIGN =\"TOP\" >\n\t\t\t\t<!-- <TR><Th align=\"left\" id=\"header\">Patient Education</Th></TR> -->\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t<TR ><TD style=\"BACKGROUND-COLOR:#FFFFCC\">";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t\t\t\t\t<TR><TD style=\"color:red\"> No Relevant Information found</TD></TR>\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t</TBODY>\t\t\t\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t<script>showAllFirstTime()</script>\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );
	
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
        response.setHeader("Content-Type", "text/html;");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

		String bean_id					= "ExternalProductLinkBean" ;
		String bean_name				= "ePH.ExternalProductLinkBean";
		ExternalProductLinkBean bean	= (ExternalProductLinkBean)getBeanObject( bean_id, bean_name, request ) ;

		String prodid					= request.getParameter("extprodid");	
		String tabname					= request.getParameter("infoparam");
		HashMap drugInfos = null;
		//HashMap FDBdrugInfos = getExternalDBDrugInfo(prodid);
		
		try
		{
			ArrayList ade	=	new ArrayList();
			HashMap eqdrugs	=	new HashMap();    
			drugInfos = (HashMap)bean.getExternalDBDrugInfo(prodid);

            _bw.write(_wl_block5Bytes, _wl_block5);

					if(drugInfos !=null && drugInfos.size()>0){
						if(tabname.equalsIgnoreCase("TblEquiv")){
							ArrayList data =null;
							//HashMap drug_info_classification	= (HashMap)bean.getDrugClassificationInfo(prodid);
							HashMap drug_info_classification	= (HashMap)drugInfos.get("DRUG_CLASSFI");
							if(drug_info_classification !=null){
								ArrayList AHFS_class_info			= (ArrayList)drug_info_classification.get("AHFS");
								ArrayList FDB_class_info			= (ArrayList)drug_info_classification.get("FDB");

								if(AHFS_class_info!=null && AHFS_class_info.size()>0){

            _bw.write(_wl_block6Bytes, _wl_block6);
	    
											for(int i=0;i<AHFS_class_info.size();i++){
											   data=(ArrayList)AHFS_class_info.get(i);
											   int kk=0;
											   int ll=0;
											   if(data !=null && data.size()>0){
													for(int j=data.size()-1;j>=0;j--){
														// int kk=j*5;
														// int ll=100-kk;
														kk=kk+5;
														ll=100-10;

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(kk));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ll));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(data.get(j)));
            _bw.write(_wl_block10Bytes, _wl_block10);
												
													}
												}
											}

            _bw.write(_wl_block11Bytes, _wl_block11);
	
								}  

								if(FDB_class_info!=null && FDB_class_info.size()>0){

            _bw.write(_wl_block12Bytes, _wl_block12);
	    
										for(int i=0;i<FDB_class_info.size();i++){
										   data=(ArrayList)FDB_class_info.get(i);
											if(data !=null && data.size()>0){
												int kk=0;
												int ll=0;
												for(int j=data.size()-1;j>=0;j--){
													kk=kk+5;
													ll=100-10;

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(kk));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(ll));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(data.get(j)));
            _bw.write(_wl_block14Bytes, _wl_block14);
 
												}
											}
										}

            _bw.write(_wl_block15Bytes, _wl_block15);

								}
							}

            _bw.write(_wl_block16Bytes, _wl_block16);

			}
			else if(tabname.equalsIgnoreCase("TblIndications")){

            _bw.write(_wl_block17Bytes, _wl_block17);

							//HashMap interaction=(HashMap)bean.getDrugInteractionDetail(prodid);
							HashMap interaction=(HashMap)drugInfos.get("INTE");;
							if (interaction!=null && interaction.size()>0)
							{

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(interaction.get("INT_DESC")));
            _bw.write(_wl_block19Bytes, _wl_block19);

									if(interaction.containsKey("SEV_DESC")){

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(interaction.get("SEV_DESC")));
            _bw.write(_wl_block21Bytes, _wl_block21);
  
									}
									else{

            _bw.write(_wl_block22Bytes, _wl_block22);

									}

            _bw.write(_wl_block23Bytes, _wl_block23);

									if(interaction.containsKey("CLIN_EFFECT"))
									{

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(interaction.get("CLIN_EFFECT")));
            _bw.write(_wl_block21Bytes, _wl_block21);
  
									}
									else{

            _bw.write(_wl_block24Bytes, _wl_block24);

									} 

            _bw.write(_wl_block25Bytes, _wl_block25);

									if(interaction.containsKey("SUPP_DOC")){
										ArrayList supp_doc=(ArrayList)interaction.get("SUPP_DOC");
									   for(int i=0;i<supp_doc.size();i++ ){

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(supp_doc.get(i)));
            _bw.write(_wl_block27Bytes, _wl_block27);
    
										}
									}
									if(interaction.containsKey("DRUGS")){
										ArrayList drugs=(ArrayList)interaction.get("DRUGS");

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(drugs.get(0)));
            _bw.write(_wl_block29Bytes, _wl_block29);
  
										for(int i=1;i<(drugs.size());i++ ){

            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(drugs.get(i)));
            _bw.write(_wl_block31Bytes, _wl_block31);
 
										}
									}	
								}
								else{

            _bw.write(_wl_block32Bytes, _wl_block32);

								}

            _bw.write(_wl_block33Bytes, _wl_block33);

			}
			else if(tabname.equalsIgnoreCase("TblPrecautions")){

            _bw.write(_wl_block34Bytes, _wl_block34);

								//HashMap precautions =(HashMap)bean.getDrugPreccautions(prodid);
								HashMap precautions =(HashMap)drugInfos.get("PREC");
								if (precautions!=null && precautions.size()>0){

            _bw.write(_wl_block35Bytes, _wl_block35);
	
									HashMap geriscrnresult = (HashMap)precautions.get("GERI");
									HashMap lactscrnresult = (HashMap)precautions.get("LACT");
									HashMap pediscrnresult = (HashMap)precautions.get("PEDI");
									HashMap pregscrnresult = (HashMap)precautions.get("PREG");
									 
									if(geriscrnresult!=null && geriscrnresult.size()>0){
            _bw.write(_wl_block36Bytes, _wl_block36);
  
										for (int i=0;i<geriscrnresult.size()-1;i=+2)
										{

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(geriscrnresult.get("Severity_Level_Desc_"+i)));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(geriscrnresult.get("comment_"+i)));
            _bw.write(_wl_block39Bytes, _wl_block39);

										}
								   }
								   if(lactscrnresult!=null && lactscrnresult.size()>0){

            _bw.write(_wl_block40Bytes, _wl_block40);
  
										for (int i=0;i<lactscrnresult.size()-1;i=+4)
										{

            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(lactscrnresult.get("Severity_Level_Desc_"+i)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(lactscrnresult.get("Excretion_Effect_Desc_"+i)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(lactscrnresult.get("Effect_desc_"+i)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(lactscrnresult.get("comment_"+i)));
            _bw.write(_wl_block45Bytes, _wl_block45);
 
										}
									}
									if(pediscrnresult!=null && pediscrnresult.size()>0){

            _bw.write(_wl_block46Bytes, _wl_block46);
  
										for (int i=0;i<pediscrnresult.size()-1;i=+2)
										{

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(pediscrnresult.get("Severity_Level_Desc_"+i)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(pediscrnresult.get("comment_"+i)));
            _bw.write(_wl_block39Bytes, _wl_block39);

										}
									}
									if(pregscrnresult!=null && pregscrnresult.size()>0){

            _bw.write(_wl_block49Bytes, _wl_block49);
  
										for (int i=0;i<pregscrnresult.size()-1;i=+2)
										{

            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(pregscrnresult.get("Significent_Level_Desc_"+i)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(pregscrnresult.get("comment_"+i)));
            _bw.write(_wl_block21Bytes, _wl_block21);

										}
									}	
								}
								else{

            _bw.write(_wl_block52Bytes, _wl_block52);

								}

            _bw.write(_wl_block53Bytes, _wl_block53);

			}
			else if(tabname.equalsIgnoreCase("TblInteractions")){

            _bw.write(_wl_block54Bytes, _wl_block54);

								//ArrayList common_orders	=	(ArrayList)bean.getCommonOrders(prodid);
								ArrayList common_orders	=	(ArrayList)drugInfos.get("COMMON_ORD");
								ArrayList child			=	null;
								ArrayList adult			=	null;
								ArrayList elder			=	null;
								HashMap data			=	null;
								if(common_orders!=null && common_orders.size()>0){
									ArrayList data1 = null;
									for(int i=0;i<common_orders.size();i++){
										data = (HashMap) common_orders.get(i);
										if(data!=null && data.size()>0){
											adult=(ArrayList)data.get("ADULT");
											child=(ArrayList)data.get("CHILD");
											elder=(ArrayList)data.get("ELDER"); 
											if(child!=null && child.size()>0){

            _bw.write(_wl_block55Bytes, _wl_block55);

												for(int j=0;j<child.size();j+=2){

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(child.get(j)));
            _bw.write(_wl_block57Bytes, _wl_block57);

													data1=(ArrayList)child.get(j+1);
													if(data1!=null && data1.size()>0){
														for(int k=0;k<data1.size();k+=4){

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(data1.get(k)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(data1.get(k+1)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(data1.get(k+2)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(data1.get(k+3)));
            _bw.write(_wl_block61Bytes, _wl_block61);

														}
													}
												}
											}
											if(adult!=null && adult.size()>0){ 

            _bw.write(_wl_block62Bytes, _wl_block62);

												for(int j=0;j<adult.size();j+=2){

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(adult.get(j)));
            _bw.write(_wl_block57Bytes, _wl_block57);
 
													data1=(ArrayList)adult.get(j+1);
													if(data1!=null && data1.size()>0){
														for(int k=0;k<data1.size();k+=4){

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(data1.get(k)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(data1.get(k+1)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(data1.get(k+2)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(data1.get(k+3)));
            _bw.write(_wl_block64Bytes, _wl_block64);
 
														}
													}
												}
											}
											if(elder!=null && elder.size()>0){ 

            _bw.write(_wl_block65Bytes, _wl_block65);

												for(int j=0;j<elder.size();j+=2){

            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(elder.get(j)));
            _bw.write(_wl_block57Bytes, _wl_block57);
	
													data1=(ArrayList)elder.get(j+1);
													if(data1!=null && data1.size()>0){
														for(int k=0;k<data1.size();k+=4){

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(data1.get(k)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(data1.get(k+1)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(data1.get(k+2)));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(data1.get(k+3)));
            _bw.write(_wl_block61Bytes, _wl_block61);
 
														}
													}
												}
											}
										}
									}
								}
								else{

            _bw.write(_wl_block52Bytes, _wl_block52);

								}

            _bw.write(_wl_block66Bytes, _wl_block66);

			}
			else if(tabname.equalsIgnoreCase("TblFood")){

            _bw.write(_wl_block67Bytes, _wl_block67);

								//ArrayList fooddetails=(ArrayList)bean.getDrugFoodInteractionInfo(prodid);
								HashMap tempFoodDetails=(HashMap)drugInfos.get("DRUG_FOOD");
								ArrayList fooddetails =null;
								if(tempFoodDetails!=null && tempFoodDetails.size()>0)
									fooddetails=(ArrayList)tempFoodDetails.values();
								
								if (fooddetails!=null && fooddetails.size()>0){

            _bw.write(_wl_block68Bytes, _wl_block68);

									for (int i=0;i<fooddetails.size();i++){ 	

            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(fooddetails.get(i)));
            _bw.write(_wl_block21Bytes, _wl_block21);
 
									}
								}
								else{

            _bw.write(_wl_block52Bytes, _wl_block52);

								}

            _bw.write(_wl_block70Bytes, _wl_block70);

			}
			else if(tabname.equalsIgnoreCase("TblContra")){

            _bw.write(_wl_block71Bytes, _wl_block71);

							 //HashMap contra_indications=(HashMap)bean.getDrugContraIndication(prodid);
								HashMap contra_indications=(HashMap)drugInfos.get("CONT");
								if (contra_indications.size()>0) {
									ArrayList abosulete_contra = (ArrayList)contra_indications.get("ABS");
									ArrayList extreme_caution  = (ArrayList)contra_indications.get("EXT");
									ArrayList contra_warning   = (ArrayList)contra_indications.get("WAR");

            _bw.write(_wl_block72Bytes, _wl_block72);
  
									if(abosulete_contra.size()>0){

            _bw.write(_wl_block73Bytes, _wl_block73);
	    
										for(int i=0;i<abosulete_contra.size()-1;i+=2){

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf( abosulete_contra.get(i) ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( abosulete_contra.get(i+1) ));
            _bw.write(_wl_block21Bytes, _wl_block21);

										}
									} 
									if(extreme_caution.size()>0){

            _bw.write(_wl_block76Bytes, _wl_block76);
	    
										for(int i=0;i<extreme_caution.size()-1;i+=2){

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf( extreme_caution.get(i) ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( extreme_caution.get(i+1) ));
            _bw.write(_wl_block21Bytes, _wl_block21);
      
										}
									} 
									if(contra_warning.size()>0){

            _bw.write(_wl_block78Bytes, _wl_block78);
	    
										for(int i=0;i<contra_warning.size()-1;i+=2){

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf( contra_warning.get(i) ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( contra_warning.get(i+1) ));
            _bw.write(_wl_block21Bytes, _wl_block21);
      
										}
									} 
								}
								else{

            _bw.write(_wl_block52Bytes, _wl_block52);

								}

            _bw.write(_wl_block79Bytes, _wl_block79);

			}
			else if(tabname.equalsIgnoreCase("TblInfo")){

            _bw.write(_wl_block80Bytes, _wl_block80);

							//HashMap side_effects	=(HashMap)bean.getDrugSideEffects(prodid);
							HashMap side_effects	=(HashMap)drugInfos.get("SIDE");
							if (side_effects!=null && side_effects.size()>0) 	
							{
								ArrayList severe       = (ArrayList)side_effects.get("SEVE");
								ArrayList less_severe  = (ArrayList)side_effects.get("LESS_SEVE");
								if(severe.size()>0){

            _bw.write(_wl_block81Bytes, _wl_block81);
            
									for(int i=0;i<severe.size();i+=7){

            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf( severe.get(i) ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf( severe.get(i+1) ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( severe.get(i+2) ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( severe.get(i+3) ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( severe.get(i+4) ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf( severe.get(i+5) ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf( severe.get(i+6) ));
            _bw.write(_wl_block89Bytes, _wl_block89);
  
									}
								}
								if(less_severe!= null && less_severe.size()>0){

            _bw.write(_wl_block90Bytes, _wl_block90);
            
									for(int i=0;i<less_severe.size();i+=7){

            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf( less_severe.get(i) ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf( less_severe.get(i+1) ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf( less_severe.get(i+2) ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( less_severe.get(i+3) ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( less_severe.get(i+4) ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( less_severe.get(i+5) ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf( less_severe.get(i+6) ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            
										}
									}
								}
								else{

            _bw.write(_wl_block52Bytes, _wl_block52);
  
								}

            _bw.write(_wl_block96Bytes, _wl_block96);

			}
			else if(tabname.equalsIgnoreCase("TblOverDose")){

            _bw.write(_wl_block97Bytes, _wl_block97);
 
					//String  over_dose_war=(String)bean.getDrugOverDoseMsg(prodid);
					String  over_dose_war=(String)drugInfos.get("OVER");
					if(over_dose_war!=null && !over_dose_war.equals("")){

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( over_dose_war ));
            _bw.write(_wl_block99Bytes, _wl_block99);

					}
					else{

            _bw.write(_wl_block100Bytes, _wl_block100);

					}

            _bw.write(_wl_block101Bytes, _wl_block101);

			}
			else if(tabname.equalsIgnoreCase("TblCounsel")){

            _bw.write(_wl_block102Bytes, _wl_block102);
 
						//String  pat_edu_info=(String)bean.getPatientEducationInfo(prodid);
						String  pat_edu_info=(String)drugInfos.get("PAT_EDU");
						if(pat_edu_info!=null && !pat_edu_info.equals("")){

            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf( pat_edu_info ));
            _bw.write(_wl_block99Bytes, _wl_block99);

						}
						else{

            _bw.write(_wl_block104Bytes, _wl_block104);

						}

            _bw.write(_wl_block105Bytes, _wl_block105);

				}

            _bw.write(_wl_block106Bytes, _wl_block106);

				putObjectInBean(bean_id,bean,request);
			}
			else{
				out.println("The External Database cannot be accessed!!!");
			}

		}
		catch (Exception e)	{
			out.println("The External Database cannot be accessed!!!");
			e.printStackTrace();
		}

            _bw.write(_wl_block107Bytes, _wl_block107);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
