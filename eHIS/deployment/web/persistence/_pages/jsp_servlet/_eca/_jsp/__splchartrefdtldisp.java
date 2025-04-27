package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __splchartrefdtldisp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SplChartRefDtlDisp.jsp", 1709116351199L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<title>SplChartRefDtlList</title>\n\t\t<script src=\'../../eCA/js/SplChartRef.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n//\t\t\tparent.parent.frameSplChartRefHdr.document.forms[0].spl_chart_type.disabled = true;\n\t\t\t//alert(getCAMessage(\"RECORD_ALREADY_EXISTS\"));\n\t\t</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n<style type=\"text/css\">\n      .p_header \n\t  {\t\t\n\t\tbackground-color: #FFFFFF;\n\t\tmargin-right:none; \n\t\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\t\tfont-size: 8pt;\t\n\t\tcolor: black;\n\t\tfont-weight:normal;\n\t\ttext-align:left;\n\t\tpadding:0px;\n\t\tvertical-align:middle;\t\n\t\tborder-bottom:0px;\n\t\tborder-top:0px;\n\t\tborder-left:0px;\n\t\tborder-right:0px;\n\t\tborder-style:normal;\n\t\twidth:1px;\n\t\tposition:relative;\n\t\tborder-color:#659EC7;\n\t\theight:20px;\n      }\n\t .header \n\t {\n\t\theight:20px;\n\t\tmargin-right:none; \n\t\tbackground-color: #FFFFFF;\n\t\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\t\tfont-size: 8pt;\t\n\t\tcolor: black;\n\t\tfont-weight:normal;\n\t\ttext-align:left;\n\t\tpadding:0px;\n\t\tvertical-align:middle;\n\t\tborder-bottom:0px;\n\t\tborder-top:0px;\n\t\tborder-left:0px;\n\t\tborder-right:0px;\n\t\tborder-style:solid;\n\t\twidth:40px;\n\t  }\n   </style>\n</head>\n\n<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<form name=\"SplChartRefDtlList\" id=\"SplChartRefDtlList\"  action=\"../../servlet/eCA.SplChartRefServlet\" method=\"post\" target=\"messageFrame\">\n<table  width=\'100%\' class=\'grid\' >\n<tr>\n\t<td class=\'COLUMNHEADERCENTER\'  width=\'14%\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\'  width=\'8%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td class=\'COLUMNHEADERCENTER\' width=\'8%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\'   nowrap>\t\n\t<label class=\'p_header\'>P</label><input type=\'text\' name=\'header1\' id=\'header1\' id=\"P1\" class=\'header\' size=\'4\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' onkeypress=\"return CheckForSpeChar(event);\" onBlur=\"checkPercentileHeader(this);enableFileds(this);\" ></td>\n\t\n\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\'   nowrap>\n\t<label class=\'p_header\'>P</label><input type=\'text\'  name=\'header2\' id=\'header2\' id=\"P2\" class=\'header\'  size=\'4\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' onkeypress=\"return CheckForSpeChar(event);\" onBlur=\"checkPercentileHeader(this);enableFileds(this);\"></td>\n\n\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\'   nowrap>\n\t<label class=\'p_header\'>P</label><input type=\'text\'  name=\'header3\' id=\'header3\' id=\"P3\" class=\'header\'  size=\'4\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' onkeypress=\"return CheckForSpeChar(event);\" onBlur=\"checkPercentileHeader(this);enableFileds(this);\"></td>\n\n\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\'   nowrap>\n\t<label class=\'p_header\'>P</label><input type=\'text\'  name=\'header4\' id=\'header4\' id=\"P4\" class=\'header\'  size=\'4\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onkeypress=\"return CheckForSpeChar(event);\" onBlur=\"checkPercentileHeader(this);enableFileds(this);\"></td>\n\n\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\'   nowrap>\n\t<label class=\'p_header\'>P</label><input type=\'text\'  name=\'header5\' id=\'header5\' id=\"P5\" class=\'header\'  size=\'4\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onkeypress=\"return CheckForSpeChar(event);\" onBlur=\"checkPercentileHeader(this);enableFileds(this);\"></td>\n\n\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\'   nowrap>\n\t<label class=\'p_header\'>P</label><input type=\'text\'  name=\'header6\' id=\'header6\' id=\"P6\" class=\'header\'  size=\'4\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' onkeypress=\"return CheckForSpeChar(event);\" onBlur=\"checkPercentileHeader(this);enableFileds(this);\"></td>\n\n\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\'   nowrap>\n\t<label class=\'p_header\'>P</label><input type=\'text\'  name=\'header7\' id=\'header7\' id=\"P7\" class=\'header\'  size=\'4\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' onkeypress=\"return CheckForSpeChar(event);\" onBlur=\"checkPercentileHeader(this);enableFileds(this);\"></td>\n\n\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\'   nowrap>\n\t<label class=\'p_header\'>P</label><input type=\'text\'  name=\'header8\' id=\'header8\' id=\"P8\" class=\'header\'  size=\'4\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' onkeypress=\"return CheckForSpeChar(event);\" onBlur=\"checkPercentileHeader(this);enableFileds(this);\"></td>\n\n\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\'   nowrap>\n\t<label class=\'p_header\'>P</label><input type=\'text\'  name=\'header9\' id=\'header9\' id=\"P9\" class=\'header\'  size=\'4\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' onkeypress=\"return CheckForSpeChar(event);\" onBlur=\"checkPercentileHeader(this);enableFileds(this);\"></td>\n\n\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\'   nowrap>\n\t<label class=\'p_header\'>P</label><input type=\'text\'  name=\'header10\' id=\'header10\' id=\"P10\" class=\'header\'  size=\'4\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' onkeypress=\"return CheckForSpeChar(event);\" onBlur=\"checkPercentileHeader(this);enableFileds(this);\"></td>\n\n\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\'   nowrap>\n\t<label class=\'p_header\'>P</label><input type=\'text\'  name=\'header11\' id=\'header11\' id=\"P11\" class=\'header\'  size=\'4\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' onkeypress=\"return CheckForSpeChar(event);\" onBlur=\"checkPercentileHeader(this);enableFileds(this);\"></td>\n\n\t<td width=\'10%\' class=\'COLUMNHEADERCENTER\'   nowrap>\n\t<label class=\'p_header\'>P</label><input type=\'text\'  name=\'header12\' id=\'header12\' id=\"P12\" class=\'header\'  size=\'4\' maxlength=\'3\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' onkeypress=\"return CheckForSpeChar(event);\" onBlur=\"checkPercentileHeader(this);enableFileds(this);\"></td>\n\t\n</tr>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\n\t\t<tr >\n\t\t\t<td width=\'16%\' class = \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' nowrap>&nbsp;";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;</td>\n\n\t\t\t<input type=\'hidden\' name=\'key_value";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' id=\'key_value";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'/>\n\t\t\t<td width=\'10%\' class = \'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' nowrap><input type=\'text\' name=\'median_value";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'median_value";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' size=\'4\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'  onkeypress=\"return allowNumber();\" onBlur=\"checkNumber1(this);\"></td>\n\t\t\t<td width=\'10%\' class = \'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' nowrap><input type=\'text\' name=\'variation_value";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'variation_value";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onkeypress=\"return allowNumber();\" onBlur=\"checkNumber1(this);\"></td>\n\t\t\t<td width=\'10%\' class = \'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' nowrap><input type=\'text\' name=\'trans_value";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'trans_value";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' nowrap><input type=\'text\' name=\'p1_value";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'p1_value";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="readOnly";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="  size=\'4\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' nowrap><input type=\'text\' name=\'p2_value";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' id=\'p2_value";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'  ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =" size=\'4\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' nowrap><input type=\'text\' name=\'p3_value";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'p3_value";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' nowrap><input type=\'text\' name=\'p4_value";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'p4_value";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' nowrap><input type=\'text\' name=\'p5_value";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'p5_value";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' nowrap><input type=\'text\' name=\'p6_value";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'p6_value";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' nowrap><input type=\'text\' name=\'p7_value";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'p7_value";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' nowrap><input type=\'text\' name=\'p8_value";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'p8_value";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' nowrap><input type=\'text\' name=\'p9_value";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'p9_value";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' nowrap><input type=\'text\' name=\'p10_value";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'p10_value";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' onBlur=\"checkNumber1(this);\" onkeypress=\" return allowNumber(this);\"></td>\n\t\t\t<td width=\'10%\' class = \'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' nowrap><input type=\'text\' name=\'p11_value";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'p11_value";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'  onBlur=\"checkNumber1(this);\" onkeypress=\"return allowNumber(this);\"></td>\n\t\t\t<td width=\'10%\' class = \'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' nowrap><input type=\'text\' name=\'p12_value";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' id=\'p12_value";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' onBlur=\"checkNumber1(this);\" onkeypress=\"return allowNumber(this);\"></td>\t\t\t\t\n\t\t</tr>\t\t\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n</table>\n<input type=\"hidden\" name=\"spl_chart_type\" id=\"spl_chart_type\" value = \"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"/>\n<input type=\"hidden\" name=\"spl_chart_group\" id=\"spl_chart_group\" value = \"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"/>\n<input type=\"hidden\" name=\"element_type\" id=\"element_type\" value = \"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\"/>\n<input type=\"hidden\" name=\"xAxis_element\" id=\"xAxis_element\" value = \"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"/>\n<input type=\"hidden\" name=\"gender\" id=\"gender\" value = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"/>\n<input type=\"hidden\" name=\"rec_count\" id=\"rec_count\" value = \"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"/>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );
 private void checkNull(String st)
	{	
	if(st==null || st.equals("null"))
		st = "";
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           	    ?				?			created
30/07/2018	IN061886		Ramesh G				    					To be able to plot Growth Charts for Pre Term babies and abnormal babies.
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);


		String splChartType = request.getParameter("spl_chart_type");
		splChartType = splChartType==null?"":splChartType;

		String splChartGroup = request.getParameter("spl_chart_group");
		splChartGroup = splChartGroup==null?"":splChartGroup;

		String elementType = request.getParameter("element_type");
		elementType = elementType==null?"":elementType;
		
		String xAxis_element = request.getParameter("xAxis_element")==null?"*K":(String)request.getParameter("xAxis_element");	

		String gender = request.getParameter("gender");
		gender = gender==null?"":gender;
		
		StringBuffer key_ref = new StringBuffer();
		key_ref.append(splChartType);
		key_ref.append("#");
		key_ref.append(splChartGroup);
		key_ref.append("#");
		key_ref.append(elementType);
		key_ref.append("#");
		key_ref.append(gender);
		
		String P1_Header ="2";
		String P2_Header= "5";
		String P3_Header= "10";
		String P4_Header= "25";
		String P5_Header= "50";
		String P6_Header= "75";
		String P7_Header= "90";
		String P8_Header= "95";
		String P9_Header= "97";
		String P10_Header="";
		String P11_Header="";
		String P12_Header="";
		int cntHeaderVal = 0;

		Connection con = null;
		PreparedStatement ps1 = null;
		ResultSet res1 = null;
		ArrayList prefArray=new  ArrayList();	
		prefArray.add(0,P1_Header);
		prefArray.add(1,P2_Header);
		prefArray.add(2,P3_Header);
		prefArray.add(3,P4_Header);
		prefArray.add(4,P5_Header);
		prefArray.add(5,P6_Header);
		prefArray.add(6,P7_Header);
		prefArray.add(7,P8_Header);
		prefArray.add(8,P9_Header);
		prefArray.add(9,P10_Header);
		prefArray.add(10,P11_Header);
		prefArray.add(11,P12_Header);							
		try
			{
				con = ConnectionManager.getConnection(request);		
				String sqlStr="SELECT PREF_DESC  FROM CA_SPL_CHART_REF_DTL ORDER BY ABS(SUBSTR(PREF_DESC, 2))"; 

				ps1 = con.prepareStatement(sqlStr);
				//ps1.setString(1,key_ref.toString());
				res1 = ps1.executeQuery();
				int i=0;
				while(res1.next())
				{  
					String str= res1.getString("PREF_DESC");
					//out.println("str   :   "+str);
					prefArray.set(i,str.substring(1));	
					if(((String)prefArray.get(i)).equals(""))
					{
						cntHeaderVal++;
					}
					i++;
				}
				if(res1 != null) res1.close();
				if(ps1 != null) ps1.close();
				
				//out.println("===>cntHeaderVal   :     "+cntHeaderVal);
		}
		catch(Exception e)
		{
			out.println("Exception in try of SplChartRefDtlList.jsp for Percentile Header"+e.toString());
		}
		if(cntHeaderVal < 12)
		{
			P1_Header=(String)prefArray.get(0);
			P2_Header=(String)prefArray.get(1);
			P3_Header=(String)prefArray.get(2);
			P4_Header=(String)prefArray.get(3);
			P5_Header=(String)prefArray.get(4);
			P6_Header=(String)prefArray.get(5);
			P7_Header=(String)prefArray.get(6);
			P8_Header=(String)prefArray.get(7);
			P9_Header=(String)prefArray.get(8);
			P10_Header=(String)prefArray.get(9);
			P11_Header=(String)prefArray.get(10);		
			P12_Header=(String)prefArray.get(11);		
		}
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(P1_Header));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(P2_Header));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(P3_Header));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(P4_Header));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P5_Header));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(P6_Header));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(P7_Header));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(P8_Header));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(P9_Header));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P10_Header));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(P11_Header));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(P12_Header));
            _bw.write(_wl_block23Bytes, _wl_block23);
		
	//out.println("<script>alert('"+gender+"')</script>");
	String classValue = "";
	int i = 1;
	int totalRecords = 0;
	
	PreparedStatement pstmt = null, pstmt1 = null;
	ResultSet rset = null, rset1 = null;

	String sql = "",sql1 = "";

	try{
		
	//	sql = "SELECT  KEY_VALUE, MEDIAN_VALUE, VARIATION_VALUE,BOX_CON_TRANS_VALUE,PREF1,PREF2,PREF3,PREF4,PREF5,PREF6,PREF7,PREF8,PREF9,PREF10,PREF11,PREF12 FROM CA_SPL_CHART_REF_VALUE WHERE SPL_CHART_TYPE = ? AND ELEMENT_TYPE=? AND GENDER = ? AND SPL_CHART_TYPE_GRP_ID = ? ORDER BY to_number(KEY_VALUE)";
		sql = "SELECT  KEY_VALUE, MEDIAN_VALUE, VARIATION_VALUE,BOX_CON_TRANS_VALUE,PREF1,PREF2,PREF3,PREF4,PREF5,PREF6,PREF7,PREF8,PREF9,PREF10,PREF11,PREF12 FROM CA_SPL_CHART_REF_VALUE WHERE SPL_CHART_TYPE = ? AND ELEMENT_TYPE=? AND GENDER = ? AND SPL_CHART_TYPE_GRP_ID = ? AND X_ELEMENT_TYPE=? AND to_number(KEY_VALUE) = ? ORDER BY to_number(KEY_VALUE)";

		//sql1 = "SELECT START_VALUE,VALUE_UNIT FROM CA_SPL_CHART_KEY_VALUE WHERE SPL_CHART_TYPE=? AND to_number(KEY_VALUE) = ?";
		sql1 = "SELECT KEY_VALUE,START_VALUE,VALUE_UNIT FROM CA_SPL_CHART_KEY_VALUE WHERE SPL_CHART_TYPE=? AND SPL_CHART_TYPE_GRP_ID = ? AND X_ELEMENT_TYPE=? ORDER BY to_number(KEY_VALUE)";

	    //pstmt1 = con.prepareStatement(sql1);
	    pstmt1 = con.prepareStatement(sql);

		//pstmt = con.prepareStatement(sql);
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,splChartType);
		pstmt.setString(2,splChartGroup);
		pstmt.setString(3,xAxis_element);
		/*pstmt.setString(1,splChartType);
		pstmt.setString(2,elementType);
		pstmt.setString(3,gender);
		pstmt.setString(4,splChartGroup);*/
		rset  = pstmt.executeQuery();
			
		String keyValue = "";
		String medianValue = "";
		String variationValue = "";
		String transValue = "";
		
		String rangeValue = "",unit = "",unitValue = "";

		String PREF1 = "";
		String PREF2= "";
		String PREF3= "";
		String PREF4= "";
		String PREF5= "";
		String PREF6= "";
		String PREF7= "";
		String PREF8= "";
		String PREF9= "";
		String PREF10= "";
		String PREF11= "";
		String PREF12= "";
	
		classValue = "gridData";
		i = 1;
		while(rset.next())
		{			
			keyValue		= rset.getString("KEY_VALUE")==null ? "":rset.getString("KEY_VALUE");
			unit = rset.getString("VALUE_UNIT");

			//out.println("unit"+unit);
			if(unit.equals("M"))
				 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
			else if(unit.equals("Y"))
				 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
			else if(unit.equals("D"))
				 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
			else if(unit.equals("KG"))
				 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Kgs.label","common_labels");
			else if(unit.equals("KM"))
				 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.kgm2.label","ca_labels");
			else if(unit.equals("CM"))
				 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.centimeters.label","ca_labels");				 
			else if(unit.equals("W"))
				 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.weeks.label","common_labels");   //IN061886
			rangeValue = rset.getString("START_VALUE")+"~"+keyValue+" "+unitValue;
			
			/*medianValue     = rset.getString("MEDIAN_VALUE")==null ? "":rset.getString("MEDIAN_VALUE");
			variationValue  = rset.getString("VARIATION_VALUE")==null ? "":rset.getString("VARIATION_VALUE");
			transValue		= rset.getString("BOX_CON_TRANS_VALUE")==null ? "":rset.getString("BOX_CON_TRANS_VALUE");
  		    PREF1 = rset.getString("PREF1")==null ? "":rset.getString("PREF1");
			PREF2 = rset.getString("PREF2")==null ? "":rset.getString("PREF2");
			PREF3 = rset.getString("PREF3")==null ? "":rset.getString("PREF3"); 
			PREF4 = rset.getString("PREF4")==null ? "":rset.getString("PREF4");
			PREF5 = rset.getString("PREF5")==null ? "":rset.getString("PREF5");
			PREF6 = rset.getString("PREF6")==null ? "":rset.getString("PREF6");
			PREF7 = rset.getString("PREF7")==null ? "":rset.getString("PREF7");
			PREF8 = rset.getString("PREF8")==null ? "":rset.getString("PREF8");
			PREF9 = rset.getString("PREF9")==null ? "":rset.getString("PREF9");
			PREF10 = rset.getString("PREF10")==null ? "":rset.getString("PREF10");
			PREF11 = rset.getString("PREF11")==null ? "":rset.getString("PREF11");
			PREF12 = rset.getString("PREF12")==null ? "":rset.getString("PREF12");*/
			
			/*if(i % 2 == 0 )
				classValue	=	"gridData";
			else	
				classValue	=	"gridData";*/
				//out.println(splChartType+"{}"+keyValue);
		/*	pstmt1.setString(1,splChartType);
			pstmt1.setString(2,(keyValue));*/
			pstmt1.setString(1,splChartType);
			pstmt1.setString(2,elementType);
			pstmt1.setString(3,gender);
			pstmt1.setString(4,splChartGroup);
			pstmt1.setString(5,xAxis_element);
			pstmt1.setString(6,keyValue);
			rset1 = pstmt1.executeQuery();
			if(rset1.next())
			{	

				medianValue     = rset1.getString("MEDIAN_VALUE")==null ? "":rset1.getString("MEDIAN_VALUE");
				variationValue  = rset1.getString("VARIATION_VALUE")==null ? "":rset1.getString("VARIATION_VALUE");
				transValue		= rset1.getString("BOX_CON_TRANS_VALUE")==null ? "":rset1.getString("BOX_CON_TRANS_VALUE");
				PREF1 = rset1.getString("PREF1")==null ? "":rset1.getString("PREF1");
				PREF2 = rset1.getString("PREF2")==null ? "":rset1.getString("PREF2");
				PREF3 = rset1.getString("PREF3")==null ? "":rset1.getString("PREF3"); 
				PREF4 = rset1.getString("PREF4")==null ? "":rset1.getString("PREF4");
				PREF5 = rset1.getString("PREF5")==null ? "":rset1.getString("PREF5");
				PREF6 = rset1.getString("PREF6")==null ? "":rset1.getString("PREF6");
				PREF7 = rset1.getString("PREF7")==null ? "":rset1.getString("PREF7");
				PREF8 = rset1.getString("PREF8")==null ? "":rset1.getString("PREF8");
				PREF9 = rset1.getString("PREF9")==null ? "":rset1.getString("PREF9");
				PREF10 = rset1.getString("PREF10")==null ? "":rset1.getString("PREF10");
				PREF11 = rset1.getString("PREF11")==null ? "":rset1.getString("PREF11");
				PREF12 = rset1.getString("PREF12")==null ? "":rset1.getString("PREF12");


		/*		unit = rset1.getString("VALUE_UNIT");
				
				//out.println("unit"+unit);
				if(unit.equals("M"))
					 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.months.label","common_labels");
				else if(unit.equals("Y"))
					 unitValue =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Years.label","common_labels");
				else if(unit.equals("D"))
					 unitValue = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.days.label","common_labels");
				rangeValue = rset1.getString("START_VALUE")+"~"+keyValue+" "+unitValue;*/
			}
			if(rset1!=null)
				rset1.close();
			//out.println("unitValue"+unitValue);

		
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rangeValue));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(keyValue));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(medianValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(variationValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(transValue));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(P1_Header.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(PREF1));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
if(P2_Header.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(PREF2));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
if(P3_Header.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(PREF3));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
if(P4_Header.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(PREF4));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(P5_Header.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(PREF5));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(P6_Header.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(PREF6));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(P7_Header.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(PREF7));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
if(P8_Header.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(PREF8));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(i));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(P9_Header.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(PREF9));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(P10_Header.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(PREF10));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(P11_Header.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(PREF11));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block41Bytes, _wl_block41);
if(P12_Header.equals("")){
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(PREF12));
            _bw.write(_wl_block70Bytes, _wl_block70);

		i++;
		}		
		totalRecords = i -1;
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
		if(pstmt1!=null) pstmt1.close();
	} 
	catch(Exception e){
		out.println("Exception in try of SplChartRefDtlDisp.jsp"+e.toString());
	}
	finally{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(splChartType));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(splChartGroup));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(elementType));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(xAxis_element));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block77Bytes, _wl_block77);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Range.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Median.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Variance.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Trans.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
