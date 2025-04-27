package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.pendingresults.PreviousResultEventDescriptor;
import eIPAD.IPADConstants;
import eIPAD.pendingresults.PreviousResults;
import eIPAD.pendingresults.PreviousResultsResponse;
import eIPAD.pendingresults.PrevResultDateContainer;
import java.util.List;
import eIPAD.pendingresults.PrevResultCountResponse;
import eCommon.Common.CommonBean;
import eIPAD.pendingresults.PreviousResultsRequest;
import eIPAD.pendingresults.PendingResults;

public final class __previousresultsdata extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/PreviousResultsData.jsp", 1709118030849L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" /> \n<script src=\"../jquery-1.5.2.min.js\"></script> \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n  \n\n<link rel=\"stylesheet\" href=\"../css/iPadPreviousResults.css\"/>\n<script>\nfunction moveRecordsRight(){\n\tvar hdnCurrentSection = document.getElementById(\"hdnCurrentSection\");\n\tvar currentSectionStr;\n\tvar currentSectionNum;\n\tif(hdnCurrentSection){\n\t\tcurrentSectionStr = hdnCurrentSection.value;\n\t\tcurrentSectionNum = parseInt(currentSectionStr);\n\t}\n\t//alert(currentSectionNum);\n\tcurrentSectionNum = currentSectionNum + 1;\n\tvar sectionName = \"#section\"+currentSectionNum;\n\t//$.mobile.changePage(\"#section2\",\"slide\" , false,false);\n\t$.mobile.changePage(sectionName,\"slide\" , false,false);\n\t\n\thdnCurrentSection.value = currentSectionNum;\n}\n\nfunction moveRecordsLeft(){\n\tvar hdnCurrentSection = document.getElementById(\"hdnCurrentSection\");\n\tvar currentSectionStr;\n\tvar currentSectionNum;\n\tif(hdnCurrentSection){\n\t\tcurrentSectionStr = hdnCurrentSection.value;\n\t\tcurrentSectionNum = parseInt(currentSectionStr);\n\t}\n\tcurrentSectionNum = currentSectionNum - 1;\n\tvar sectionName = \"#section\"+currentSectionNum;\n\t$.mobile.changePage(sectionName,\"slide\" , true,false);\n\thdnCurrentSection.value = currentSectionNum;\n}\n\nfunction changeOrientation(orient,height)\n{\n\t//\talert(orient);\n\tif(orient == \"landscape\")\n\t   {\n\t     document.getElementById(\"datadiv\").style.height = \"auto\";\n\t     //document.getElementById(\"txtnotes\").style.height = height;\n\t   }\n     else\n\t   {\n\t   document.getElementById(\"datadiv\").style.height = \"auto\";\n\t  // document.getElementById(\"txtnotes\").style.height = height;\n\t   }\n \n}\n</script>\n</head>\n<body>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<form name = \"previousResultData\">\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t  <section id=\"section";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" data-role = \"page\" style =\"padding:0px;background:#ffffff\">\n\n\t  <div id=\"datadiv\" style=\"width:100%;background:#ffffff;\">\n\t  \t<table style=\"width:100%;border: 1px solid #48d1d8;\" cellpadding = \"0\" cellspacing = \"0\" border=0>\n\t  \t\t<tr style=\"border-bottom: 2 px solid #cccccc\">\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<td style=\"border-right: 2px solid #cccccc;border-bottom: 2px solid #cccccc;\" valign=\"top\">\n\t  \t\t\t\t<table  style = \"width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t \t\t<tr style = \"height:15%;width:100%\" >\n\t\t \t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t \t\t\t\t<td style = \"width:10%\" align=\"top\">\n\t\t\t \t\t\t\t\t<table style = \"width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t \t\t\t\t\t\t<tr class=\"dvApp\">\n\t\t\t \t\t\t\t\t\t<td align=\"top\">\n\t\t\t\t\t    \t \t\t\t<img src=\"../images/Column Left Navigation.png\" onclick=\"moveRecordsLeft()\"/>\n\t\t\t\t\t    \t \t\t</td>\n\t\t\t\t\t    \t \t\t</tr>\n\t\t\t\t\t    \t \t</table>\t\n\t\t\t\t\t    \t \t<table style=\"width:100%;\" border=0>\n\t\t\t\t\t    \t \t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t  \t\t\t\t\t\t<tr>\n\t\t  \t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t  \t\t\t\t\t\t</tr>\n\t\t  \t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t  \t\t\t\t\t\t\n\t\t  \t\t\t\t\t\t</table>\n\t\t\t\t\t    \t </td>\n\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t \t\t\t\t<td style = \"width:10%\" align=\"top\">\n\t\t\t \t\t\t\t\t<table style = \"width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t \t\t\t\t\t\t<tr class=\"dvApp\">\n\t\t\t \t\t\t\t\t\t<td>\n\t\t\t\t\t    \t \t\t<img src=\"../images/Column Left Navigation-Disabled.png\"/>\n\t\t\t\t\t    \t \t\t</td>\n\t\t\t\t\t    \t \t\t</tr>\n\t\t\t\t\t    \t \t</table>\n\t\t\t\t\t    \t \t<table style=\"width:100%;\" border=0>\n\t\t  \t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t  \t\t\t\t\t\t</table>\n\t\t\t\t\t    \t </td>\n\t\t\t \t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t \t\t\t<td valign = \"top\">\n\t\t\t\t \t\t\t\t<table style = \"width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t\t\t \t\t\t\t<tr class=\"dvApp\">\n\t\t\t\t\t\t\t   \t\t <td style = \"width:80%\" align=\"center\">\n\t\t\t\t\t\t\t        \t <span class = \"spanTextSmallHeader\">\n\t\t\t\t\t\t\t        \t ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span>\n\t\t\t\t\t\t\t    \t </td>\n\t\t\t\t\t\t\t    \t\n\t\t\t\t\t\t\t    \t</tr>\n\t\t\t\t\t\t    \t</table>\n\t\t\t\t\t\t\t      \n\t\t\t\t\t\t    \t<table style=\"width:100%;\" border=0>\n\t\t\t\t\t\t    \t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t  \t\t\t\t\t\t\n\t\t  \t\t\t\t\t\t<tr>\n\t\t  \t\t\t\t\t\t\t<td align=\"center\" valign=\"bottom\">\n\t\t  \t\t\t\t\t\t\t\t<span class=\"spanTextSmallBold\">\n\t\t  \t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t  \t\t\t\t\t\t\t\t</span>\n\t\t  \t\t\t\t\t\t\t</td>\n\t\t  \t\t\t\t\t\t</tr>\n\t\t  \t\t\t\t\t\t</table>\n\t\t\t\t\t\t    </td>\n\t\t\t\t\t    \t ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t    \t<td style = \"width:10%\" align=\"center\">\n\t\t\t\t\t    \t\t<table style = \"width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t \t\t\t\t\t\t<tr class=\"dvApp\">\n\t\t\t \t\t\t\t\t\t<td>\n\t\t\t\t\t    \t \t\t\t<img src=\"../images/Column Right Navigation.png\" onclick=\"moveRecordsRight()\"/>\n\t\t\t\t\t    \t \t\t</td>\n\t\t\t\t\t    \t \t\t</tr>\n\t\t\t\t\t    \t \t</table>\n\t\t\t\t\t    \t \t<table style=\"width:100%;\" border=0>\n\t\t\t\t\t\t    \t \t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t  \t\t\t\t\t\t<tr>\n\t\t\t  \t\t\t\t\t\t\t<td>&nbsp;</td>\n\t\t\t  \t\t\t\t\t\t</tr>\n\t\t\t  \t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t  \t\t\t\t\t\t</table>\n\t\t\t\t\t    \t</td>\n\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t    \t<td style = \"width:10%\" align=\"center\">\n\t\t\t\t\t    \t\t<table style = \"width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t \t\t\t\t\t\t<tr class=\"dvApp\">\n\t\t\t \t\t\t\t\t\t<td>\n\t\t\t\t\t    \t \t\t\t<img src=\"../images/Column Right Navigation-Disabled.png\"/>\n\t\t\t\t\t    \t \t\t</td>\n\t\t\t\t\t    \t \t\t</tr>\n\t\t\t\t\t    \t \t</table>\n\t\t\t\t\t    \t \t<table style=\"width:100%;\" border=0>\n\t\t\t  \t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t  \t\t\t\t\t\t</table>\n\t\t\t\t\t    \t</td>\t\n\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t    \t\n\t\t\t\t    \t</tr>\n\t\t\t    \t</table>\n\t  \t\t\t\t\t \n\t  \t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t</tr>\n\t \t\t\n\t \t\t\n\t \t\t\n\t \t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t \t\t<tr style=\"height:60px;background:#e6e6e6\">\n\t \t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t \t\t<tr style=\"height:60px;\">\n\t \t\t\n\t \t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t \t\t\n\t \t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<td style=\"border-right: 2px solid #cccccc;border-bottom: 2px solid #cccccc\" align=\"top\">&nbsp;</td>\t \t\t\n\t \t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t \t\t</tr>\n\t \t\t\n\t \t\t</table>\n\t \t\t\n\t  </div>\n\t  \n\t  <div id=\"icondiv\" style=\"width:100%;height:15%;background:#ffffff\">\n\t  <table width=\"80%\" border=0>\n\t  \t<tr>\n\t  \t\t<td width=\"8%\" align=\"center\">\n\t  \t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t  \t\t\t\t<img src=\"../images/NI_High.gif\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t  \t\t\t\t<img src=\"../images/High-Disabled.PNG\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t  \t\t\t<span>High</span>\n\t  \t\t</td>\n\t  \t\t<td width=\"8%\" align=\"center\">\n\t  \t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t  \t\t\t\t<img src=\"../images/NI_Low.gif\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t  \t\t\t\t<img src=\"../images/Low-Disabled.PNG\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t  \t\t\t<span>Low</span>\n\t  \t\t</td>\n\t  \t\t<td width=\"12%\" align=\"center\">\n\t  \t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t  \t\t\t\t<img src=\"../images/NI_Abnormal.gif\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t  \t\t\t\t<img src=\"../images/Abnormal-Disabled.png\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t  \t\t\t<span>Abnormal</span>\n\t  \t\t</td>\n\t  \t\t<td width=\"10%\" align=\"center\">\n\t  \t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t  \t\t\t\t<img src=\"../images/NI_Critical.gif\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t  \t\t\t\t<img src=\"../images/Critical-Disabled.png\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t  \t\t\t<span>Critical</span>\n\t  \t\t</td>\n\t  \t\t<td width=\"15%\" align=\"center\">\n\t  \t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t  \t\t\t\t<img src=\"../images/NI_CriticallyHigh.gif\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t  \t\t\t\t<img src=\"../images/Critical High-Disabled.png\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t  \t\t\t<span>Critical High</span>\n\t  \t\t</td>\n\t  \t\t<td width=\"15%\" align=\"center\">\n\t  \t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t  \t\t\t\t<img src=\"../images/NI_CriticallyLow.gif\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t  \t\t\t\t<img src=\"../images/Critical low-Disabled.png\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t  \t\t\t<span>Critical Low</span>\n\t  \t\t</td>\n\t  \t\t<td width=\"10%\" align=\"center\">\n\t  \t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t  \t\t\t\t<img src=\"../images/NI_Normal.gif\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t  \t\t\t\t<img src=\"../images/Normal-Disabled.png\"/>\n\t  \t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t  \t\t\t<span>Normal</span>\n\t  \t\t</td>\n\t  \t</tr>\n\t  </table>\n\t  </div>\n\t \n\t  \n\t </section>\t\n\t \t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t \t\t\t\n\t \n\t <input type=\"hidden\" id=\"hdnRequestParam\" name=\"hdnRequestParam\" id=\"hdnRequestParam\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"/>\n\t  <input type=\"hidden\" id=\"hdnResultCount\" name=\"hdnResultCount\" id=\"hdnResultCount\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"/> \n\t  <input type=\"hidden\" id=\"hdnPresentCounter\" name=\"hdnPresentCounter\" id=\"hdnPresentCounter\" value=\"4\"/>\n\t  <input type=\"hidden\" id=\"hdnTotalBuckets\" name=\"hdnTotalBuckets\" id=\"hdnTotalBuckets\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"/>\n\t  <input type=\"hidden\" id=\"hdnCurrentSection\" name=\"hdnCurrentSection\" id=\"hdnCurrentSection\" value=\"1\"/>\n</form>\t \n\t \t\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String param = request.getQueryString();
	int rowIndex = 1;
	int totalResults = 0;
	
	//Here comes the logic of getting the previous results and showing
	// them in a tabular format
	PendingResults pendingResultsBean = new PendingResults();
	PreviousResultsRequest prevResultsRequest = new PreviousResultsRequest();
	prevResultsRequest.setRequest(request);
	prevResultsRequest.setSession(session);
	prevResultsRequest.setLocale(IPADConstants.LOCALE);
	//String rowCounter = request.getParameter("hdnRowCounter");

	String patient_Id = request.getParameter("hdnPatientid");
	patient_Id = CommonBean.checkForNull(patient_Id);
	prevResultsRequest.setPatientId(patient_Id);

	String histRecType = request.getParameter("hdnHistRectType");
	histRecType = CommonBean.checkForNull(histRecType);
	prevResultsRequest.setHistRectType(histRecType);

	String eventClass = request.getParameter("hdnEventClass");
	eventClass = CommonBean.checkForNull(eventClass);
	prevResultsRequest.setEventClass(eventClass);

	String eventCode = request.getParameter("hdnEventCode");
	eventCode = CommonBean.checkForNull(eventCode);
	prevResultsRequest.setEventCode(eventCode);

	String eventGroup = request.getParameter("hdnEventGroup");
	eventGroup = CommonBean.checkForNull(eventGroup);
	prevResultsRequest.setEventGroup(eventGroup);

	String normalcyIndicator = request
			.getParameter("hdnNormalcyIndicator");
	normalcyIndicator = CommonBean.checkForNull(normalcyIndicator);
	if(normalcyIndicator.trim().equals("")){
		normalcyIndicator = "N";
	}
	prevResultsRequest.setNormalcyIndicator(normalcyIndicator);
	
	prevResultsRequest.setMaskDates(true);
// get the list of previous result dates by executing
// the method in the pending results bean
	PrevResultCountResponse prevResultCountResponse = pendingResultsBean
			.getPreviousResultsCount(prevResultsRequest);
	
	List<PrevResultDateContainer> prevResultDateContainerList = prevResultCountResponse.getPrevResultDateContainerList();
	// calculate the earliest date and latest date from the list of previous dates
	// the list already contains the dates in ascending order of date
	// hence the earliest date is in the first index and latest date is the last in the list
	PrevResultDateContainer earliestDate = prevResultDateContainerList.get(0);
	PrevResultDateContainer latestDate = prevResultDateContainerList.get(prevResultDateContainerList.size()-1);
	
	String fromDate = "";
	if(earliestDate != null){
		fromDate = earliestDate.getDateString();
	}
	
	String toDate = "";
	if(latestDate != null){
		toDate = latestDate.getDateString();
	}
	// now unmask the dates in the request
	prevResultsRequest.setMaskDates(false);
	// set the dates
	prevResultsRequest.setFromDate(fromDate);
	prevResultsRequest.setToDate(toDate);

	// now execute to get the previous results
	PreviousResultsResponse previousResultsResponse = 
		pendingResultsBean.getPreviousResults(prevResultsRequest, prevResultCountResponse);
	
	PreviousResultEventDescriptor eventDescriptor =  
			previousResultsResponse.getEventDescriptor();
	
	int rowsForUI = 0;
	if(eventDescriptor != null){
		String eventCategory = eventDescriptor.getEventCategory();
		if(eventCategory != null && !eventCategory.trim().equals("")){
			rowsForUI++;	
		}
		String desc = eventDescriptor.getDescription();
		if(desc != null && !desc.trim().equals("")){
			rowsForUI++;
		}
		String eventGrpDesc = eventDescriptor.getEventGroupDescription();
		if(eventGrpDesc != null && !eventGrpDesc.trim().equals("")){
			rowsForUI++;
		}
		String resultDesc = eventDescriptor.getResultDescriptor();
		if(resultDesc != null && !resultDesc.trim().equals("")){
			rowsForUI++;
		}
	}
	
	
	List<PreviousResults> prevResultsList = previousResultsResponse.getPreviousResultsList();
	int colCounter = 1;
	if(!prevResultsList.isEmpty()){
		totalResults = prevResultsList.size();
	}

            _bw.write(_wl_block3Bytes, _wl_block3);
	
	final int BUCKET_SIZE = 4;
	int bucketNo = 1;
	int tempResultSize = totalResults;
	while(tempResultSize > BUCKET_SIZE){
		bucketNo ++;
		tempResultSize = tempResultSize - BUCKET_SIZE;	
	}
	
	PreviousResults prevResults = null;
	
	int bucketSize = BUCKET_SIZE;
	int recordCounter = 0;
	
	boolean showEnabledLegend = false;

            _bw.write(_wl_block4Bytes, _wl_block4);

	for(int curr = 1;curr<=bucketNo;curr++){
		/* if(curr == bucketNo){
			bucketSize = totalResults - ((bucketNo -1)* BUCKET_SIZE);
		} */	
		// always set the bucket size to the constant value 4
		bucketSize = BUCKET_SIZE;

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(curr));
            _bw.write(_wl_block6Bytes, _wl_block6);
	
				for(int count=1;count<=bucketSize;count++){
					try{
						prevResults = prevResultsList.get((((curr -1) * 4)+(count-1)));	
					}catch(Exception ex){
						// nothing much can be done
					}
					
					if(prevResults != null){
						String resultNum = prevResults.getResultNum();
						if(resultNum != null && !resultNum.trim().equals("")){
							showEnabledLegend = true;
						}
					}
		  
            _bw.write(_wl_block7Bytes, _wl_block7);

			 				if(count ==1){
			 					if(curr != 1){
			 			
            _bw.write(_wl_block8Bytes, _wl_block8);

					    	 		for(int temp=0;temp<rowsForUI;temp++){
					    	 	
            _bw.write(_wl_block9Bytes, _wl_block9);
 } 
            _bw.write(_wl_block10Bytes, _wl_block10);

			 					}
			 					else{
			 						// here the disabled icon will be shown
			 				
            _bw.write(_wl_block11Bytes, _wl_block11);

					    	 		for(int temp=0;temp<rowsForUI;temp++){
					    	 	
            _bw.write(_wl_block9Bytes, _wl_block9);
 } 
            _bw.write(_wl_block12Bytes, _wl_block12);
		
			 						}
			 					}
			 				
            _bw.write(_wl_block13Bytes, _wl_block13);

							        	 if(prevResults != null){
							        		out.println(prevResults.getEventDummyDate());	 
							        	 }
							        	  
            _bw.write(_wl_block14Bytes, _wl_block14);

					    	 		for(int temp=0;temp<(rowsForUI-1);temp++){
					    	 	
            _bw.write(_wl_block9Bytes, _wl_block9);
 } 
            _bw.write(_wl_block15Bytes, _wl_block15);

		  								if(prevResults != null){
		  									out.println(prevResults.getResultStr());	
		  								}
		  								
            _bw.write(_wl_block16Bytes, _wl_block16);

						    	 if(count == bucketSize){
						    		 if(curr != bucketNo){
						      
            _bw.write(_wl_block17Bytes, _wl_block17);

						    	 		for(int temp=0;temp<rowsForUI;temp++){
						    	 	
            _bw.write(_wl_block18Bytes, _wl_block18);
 } 
            _bw.write(_wl_block19Bytes, _wl_block19);
 		}else{
						    
            _bw.write(_wl_block20Bytes, _wl_block20);

					    	 		for(int temp=0;temp<rowsForUI;temp++){
						    	 	
            _bw.write(_wl_block18Bytes, _wl_block18);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);
	
						    		}
						    	 } 
						     
            _bw.write(_wl_block22Bytes, _wl_block22);

				}
			
            _bw.write(_wl_block23Bytes, _wl_block23);

	 			for(int cnt=0;cnt<5;cnt++){
	 				if((cnt % 2) == 0){
	 		
            _bw.write(_wl_block24Bytes, _wl_block24);

	 				}else{
	 		
            _bw.write(_wl_block25Bytes, _wl_block25);
 } 
            _bw.write(_wl_block26Bytes, _wl_block26);

	 			for(int ind=0;ind<bucketSize;ind++){
	 		
            _bw.write(_wl_block27Bytes, _wl_block27);
 
	 				}
	 			}
	 		
            _bw.write(_wl_block28Bytes, _wl_block28);

	  			if(showEnabledLegend){
	  			
            _bw.write(_wl_block29Bytes, _wl_block29);

	  			}
	  			else{
	  			
            _bw.write(_wl_block30Bytes, _wl_block30);
	
	  			}
	  			
            _bw.write(_wl_block31Bytes, _wl_block31);

	  			if(showEnabledLegend){
	  			
            _bw.write(_wl_block32Bytes, _wl_block32);

	  			}
	  			else{
	  			
            _bw.write(_wl_block33Bytes, _wl_block33);
	
	  			}
	  			
            _bw.write(_wl_block34Bytes, _wl_block34);

	  			if(showEnabledLegend){
	  			
            _bw.write(_wl_block35Bytes, _wl_block35);

	  			}
	  			else{
	  			
            _bw.write(_wl_block36Bytes, _wl_block36);
	
	  			}
	  			
            _bw.write(_wl_block37Bytes, _wl_block37);

	  			if(showEnabledLegend){
	  			
            _bw.write(_wl_block38Bytes, _wl_block38);

	  			}
	  			else{
	  			
            _bw.write(_wl_block39Bytes, _wl_block39);
	
	  			}
	  			
            _bw.write(_wl_block40Bytes, _wl_block40);

	  			if(showEnabledLegend){
	  			
            _bw.write(_wl_block41Bytes, _wl_block41);

	  			}
	  			else{
	  			
            _bw.write(_wl_block42Bytes, _wl_block42);
	
	  			}
	  			
            _bw.write(_wl_block43Bytes, _wl_block43);

	  			if(showEnabledLegend){
	  			
            _bw.write(_wl_block44Bytes, _wl_block44);

	  			}
	  			else{
	  			
            _bw.write(_wl_block45Bytes, _wl_block45);
	
	  			}
	  			
            _bw.write(_wl_block46Bytes, _wl_block46);

	  			if(showEnabledLegend){
	  			
            _bw.write(_wl_block47Bytes, _wl_block47);

	  			}
	  			else{
	  			
            _bw.write(_wl_block48Bytes, _wl_block48);
	
	  			}
	  			
            _bw.write(_wl_block49Bytes, _wl_block49);

			}
	  		
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(param));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(totalResults ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bucketNo));
            _bw.write(_wl_block53Bytes, _wl_block53);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
