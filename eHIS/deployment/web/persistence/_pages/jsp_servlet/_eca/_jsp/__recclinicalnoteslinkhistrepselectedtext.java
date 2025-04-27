package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import java.util.*;
import com.ehis.util.*;

public final class __recclinicalnoteslinkhistrepselectedtext extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/RecClinicalNotesLinkHistRepSelectedText.jsp", 1709116164013L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t\t\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t<script language=\'javascript\' src=\'../../eCA/js/RecClinicalNotesLinkRep.js\'></script>\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' onScroll=\"scrollTitle1()\">\n<script language=javascript>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\t\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<form name=\"RecClinicalNotesLinkMedSelectedTextForm\" id=\"RecClinicalNotesLinkMedSelectedTextForm\">\n\t\t<div id=\'divDataTitle\' style=\'postion:relative\'>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<table border=\"1\" id=\"finalDiv1\"  cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t<td class=\'columnheader\'  width=\"15%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<td class=\'columnheader\' width=\"25%\" style=\"font-size:10\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t<td class=\'columnheader\'  width=\"60%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t\t\t<td class=\'columnheader\'  width=\"15%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t<td class=\'columnheader\' width=\"25%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t<td class=\'columnheader\'  width=\"60%\" style=\"font-size:10\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td> \n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t</tr>\n\t\t\t</table> \n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</div>\n\t<div id=\'inhtml\'>\n\t\n\t <table id=\"finalDiv\" border=\"1\" cellpadding=\"0\" cellspacing=\"0\"  width=\"100%\">\n\t<tr> \n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t                    <td  class=\'gridData\' colspan=\"3\">\n\t\t\t\t\t\t\t\t\t<font size=2>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</font>\n\t\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</tr>        \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\n\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td   class=\'gridData\'>&nbsp;</td>\t\n\t\t\t\t\t\t\t<td   class=\'gridData\'  colspan=\"2\">\n\t\t\t\t\t\t\t\t<font size=2>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font>\n\t\t\t\t\t\t\t</td>\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' width=\"15%\" >\n\t\t\t\t\t\t\t\t\t<font size=2>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font></td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t\t<td   class=\'gridData\'>&nbsp;</td>\t\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' width=\"25%\" ><font size=2>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t\t\t<!-- <td class=\'gridData\' width=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" ><font size=2> -->\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'gridData\' width=\"60%\" ><font size=2>\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="&nbsp;";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'gridData\' width=\"60%\" ><font size=2>\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t\t\t\t(";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="-";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =")\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="&nbsp; \n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</font></td></tr><tr><td class=\'gridData\' colspan=\"3\" ><font size=2> ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =":<br><br>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t\t\t\t\t\t   ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'gridData\' width=\"60%\" >&nbsp;</td><tr><td class=\'gridData\' colspan=\"3\"  ><font size=2>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="&nbsp;\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 =":<br>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t   </font></td></tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<td width=\"15%\" class=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' >\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 =" <!--IN063865 added if condition -->\n\t\t\t\t\t\t</td><td width=\"25%\" class=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'><font size=2>";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</font></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t<font size=2>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</font></td><td width=\"25%\" class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</font></td>\n\t\t\t\t    ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t<td  width=\"60%\" class=\'gridData\'><font size=2>\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t<td  width=\"60%\" class=\'gridData\'><font size=2>\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t\t\t(";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =")\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="&nbsp; \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</font></td></tr><tr><td colspan=\"3\"  class=\'gridData\'><font size=2> ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =":";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t  </td></tr>\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t</font></td><td width=\"60%\" class=\'gridData\'></td></tr><tr><td colspan=\"3\"  class=\'gridData\'><font size=2>\n\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="&nbsp;\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</font></td></tr><tr><td colspan=\"3\"  class=\'gridData\'><font size=2>";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t\t\t</td></tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t   </font></td></tr>\n\t\t\t\t   ";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t <!--   </tr> -->\n\t\t\t\t\t\t\n\t\t\t\t\t ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\t\t \n\n</table>\n</div>\n<input type=\"hidden\" name=\"temp\" id=\"temp\" value=\"\">\n<input type=\"hidden\" name=\"count\" id=\"count\" value=\"\">\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n<input type=\"hidden\" name=\"temptext\" id=\"temptext\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"> \n<input type=\"hidden\" name=\"tempHtml\" id=\"tempHtml\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">  <!-- IN041284 -->\n<input type=\"hidden\" name=\"tempHtmlText\" id=\"tempHtmlText\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">  <!-- IN052716 -->\n</form>\n</body>\n\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

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
-----------------------------------------------------------------------
Date       	Edit History      	Name        		Description
-----------------------------------------------------------------------
?             	100            	?           		created
21/02/2012	IN036181	Chowminya G			 reports which has special characters such as an airstrisk or a semicolon
28/04/2014	IN048844	Chowminya			 Issue with result linking a laboratory result  with a decimal point
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
30/04/2014    IN041284		Ramesh G	Sunil KV      	30/04/2014			The alignment for result Link for laboratory� results in a clinical note section template does not display neatly .	
27/11/2014	  IN052716	Ramesh G	Akbar S		27/11/2014			Result Link In Template Based Section In  Clinical Notes For �Table� And �Text�.
18/01/2017	  IN061882	Karthi L										ML-MMOH-CRF-0534 [IN061882]
23/02/2017	  IN063645	Karthi L										ML-MMOH-CRF-0534 [IN061882]
24/02/2017	  IN063640	Karthi L										ML-MMOH-CRF-0534 [IN061882]
10/05/2017    IN063865      Raja S		11/05/2017		Ramesh Goli			ML-MMOH-CRF-0534.1
30/08/2017    IN065040		 Raja S		30/08/2017		Ramesh Goli			ML-MMOH-SCF-0787
19/03/2019    IN069927		 Raja S		19/03/2019		Ramesh Goli			ML-MMOH-SCF-1181
----------------------------------------------------------------------------------------------------------------------------------------------
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet PatientCareBean= null;synchronized(session){
                PatientCareBean=(webbeans.eCommon.RecordSet)pageContext.getAttribute("PatientCareBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(PatientCareBean==null){
                    PatientCareBean=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("PatientCareBean",PatientCareBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p1 = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p1.getProperty("LOCALE");


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	String  patient_id				= "";
    String  hist_rec_type			= "";
	String  event_date_str			= "";
    String  event_date_str_prev		= "";
    String  event_group_desc		= "";
    String  event_group_desc_prev	= "";
    String  event_time_str			= "";
    String  event_desc				= "";
    String  result_num				= "";
    String  result_num_uom			= "";
    String  normalcy_str			= "";
	String  normalcy				= "";
    String  normal_low_value_str	= "";
    String  normal_high_value_str	= "";
    String  result_str				= "";
    String  hist_data_type			= "";
    String  hist_data_exists		= "";
	String  ret_str					= "";
	String  temp					= "";
	String  flag					= "";
    String return_format			= "";
	//IN069927 Start.
	//String strsql1					= "";
	StringBuffer strsql1 = new StringBuffer(" ");
	//IN069927 End.
	String event_time_str_prev		= ""; // ML-MMOH-CRF-0534
	Clob  hist_data	 = null;
	String  order_by1	 = "";	//IN069927
    String  order_by2	 = "";	//IN069927

	String		sec_hdg_code	=	"";

	ArrayList	fields			=	new ArrayList();
	String		categ_sec_qry	=	"";
	String		field_ref		=	"";
	String		col_field		=	"";
	//String		col_val			=	"";
	String		width			=	"";
	int			col_span		=	0;
	double		col_width		=	0.0;
	String 	disable_spec_type_yn = ""; //ML-MMOH-CRF-0534 [IN061882]
	String  disable_ref_range_yn = ""; //ML-MMOH-CRF-0534 [IN061882]
	String  resultLinkQry	= ""; //ML-MMOH-CRF-0534 [IN061882]
	String  dateTimeAlign   = "N"; //IN063865
	PreparedStatement pstmt=null;
	ResultSet rset=null;


	StringBuffer innerhtml_header = new StringBuffer();
	StringBuffer temp_new = new StringBuffer();
	
	StringBuffer textFormat		=	new StringBuffer("");
	StringBuffer displaydata	=	new StringBuffer();
	StringBuffer htmlData		=	new StringBuffer(); //IN041284
	StringBuffer htmlText		= 	new StringBuffer(); //IN052716
	int k=0;

	return_format		=	(request.getParameter("return_format")==null)	?	""	:	request.getParameter("return_format");
    flag				=	(request.getParameter("flag")==null)?"":request.getParameter("flag");
	patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");
	hist_rec_type		=	(request.getParameter("hist_rec_type")==null)	?	""	:	request.getParameter("hist_rec_type");	
	sec_hdg_code		=	(request.getParameter("sec_hdg_code")==null)	?	""	:	request.getParameter("sec_hdg_code");	
	//IN069927 Start.
	order_by1			=	(request.getParameter("order_by1")==null)	?	""	:	request.getParameter("order_by1");
	order_by2			=	(request.getParameter("order_by2")==null)	?	""	:	request.getParameter("order_by2");
	//IN069927 End.
	if(!flag.equals("f"));
	    ret_str=(request.getParameter("ret_str")==null)?"":request.getParameter("ret_str"); 
    
	ret_str=ret_str.substring(1,ret_str.length());

	

	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	try
	{
		
		con =  ConnectionManager.getConnection(request);
		
		categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_SEC_DEF F where f.SEC_HDG_CODE =? and f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

		pstmt = con.prepareStatement(categ_sec_qry);
		
		pstmt.setString(1,sec_hdg_code);
		pstmt.setString(2,hist_rec_type);
		pstmt.setString(3,hist_rec_type);

		rset = pstmt.executeQuery();

		if(rset.next())
		{
			do
			{
				field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
				fields.add(field_ref);
			}
			while(rset.next());

		}
		else
		{
			 if (rset != null) rset.close();
			 if (pstmt != null) pstmt.close();

			categ_sec_qry ="select f.FIELD_REF,f.ORDER_SEQ_NUM from CA_LINK_CATEG_DEF  F where f.RESULT_CATEGORY =? and f.RESULT_SUB_CATEGORY=? order by ORDER_SEQ_NUM";

			pstmt = con.prepareStatement(categ_sec_qry);
			pstmt.setString(1,hist_rec_type);
			pstmt.setString(2,hist_rec_type);

			rset = pstmt.executeQuery();

			if(rset.next())
			{
				do
				{
					field_ref = rset.getString("FIELD_REF")==null?"":rset.getString("FIELD_REF");
					fields.add(field_ref);
				}
				while(rset.next());

				if (rset != null) rset.close();
				if(pstmt != null) pstmt.close();

			}
		

		}
		//ML-MMOH-CRF-0534 [IN061882] - Start
		resultLinkQry = "select disable_ref_range_yn, disable_spec_type_yn, DIS_REP_DATETIME_YN from ca_note_param";
		pstmt = con.prepareStatement(resultLinkQry);
		rset = pstmt.executeQuery();
		while(rset.next()){
			disable_ref_range_yn = rset.getString("disable_ref_range_yn")==null?"":rset.getString("disable_ref_range_yn");
			disable_spec_type_yn = rset.getString("disable_spec_type_yn")==null?"":rset.getString("disable_spec_type_yn");
			dateTimeAlign		 = rset.getString("DIS_REP_DATETIME_YN")==null?"N":rset.getString("DIS_REP_DATETIME_YN"); //IN063865
		}
		if (rset != null) rset.close();
		if(pstmt != null) pstmt.close();
		//ML-MMOH-CRF-0534 [IN061882] - End
	//IN065040 Changes starts
		if(!ret_str.equals("")){
			String tempStr="";
			String tempStr1="";
			String tempStr2="";

			
		StringTokenizer strtCodes1 = new StringTokenizer(ret_str,",");

		while(strtCodes1.hasMoreTokens())
		{
			if(strtCodes1.hasMoreElements()){
				tempStr= (String) strtCodes1.nextToken();
				if(tempStr1.equals(""))
					tempStr1= "'"+tempStr+"',";
				else
					tempStr1= tempStr1 +"'"+tempStr+"',";
					
			}
			
		}
		tempStr1=tempStr1.substring(0,tempStr1.length()-1);
		//IN069927 Start.
		//String testSql="SELECT A.ROWID ROW_ID FROM CR_ENCOUNTER_DETAIL A WHERE A.PATIENT_ID = ? AND A.HIST_REC_TYPE = ? AND A.ROWID in ("+tempStr1+") ORDER BY A.EVENT_DATE";//commented for IN069927
		StringBuffer testSql = new StringBuffer(" ");
		testSql.append("SELECT A.ROWID ROW_ID FROM CR_ENCOUNTER_DETAIL A,CR_CLN_EVT_GRP_LANG_VW C WHERE C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE AND c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE	AND C.EVENT_GROUP(+)=A.EVENT_GROUP 	AND C.language_id(+) = ? AND A.PATIENT_ID = ? AND A.HIST_REC_TYPE = ? AND A.ROWID in ("+tempStr1+") ");
		
		if(order_by1.equals("D")){
			if(order_by2.trim().equals("AS")){
					testSql.append(" order by A.EVENT_DATE,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
			}else{
				testSql.append(" order by A.EVENT_DATE desc ,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
			}
		}else if (order_by1.equals("N")){
			if(order_by2.trim().equals("AS")){
				testSql.append(" order by a.REQUEST_NUM_SEQ,C.LONG_DESC,A.EVENT_DATE");
			}else{
			   testSql.append(" order by a.REQUEST_NUM_SEQ desc,C.LONG_DESC desc,A.EVENT_DATE desc ");
			}
		}		
		
		//pstmt = con.prepareStatement(testSql);	
		//pstmt.setString(1,patient_id);
		//pstmt.setString(2,hist_rec_type);
		
		pstmt = con.prepareStatement(testSql.toString());		
		pstmt.setString(1,locale);
		pstmt.setString(2,patient_id);
		pstmt.setString(3,hist_rec_type);		
		//IN069927 End.
		rset = pstmt.executeQuery();
		while(rset.next()){
			if(tempStr2.equals(""))
			tempStr2 = rset.getString("ROW_ID");
			else
			tempStr2 = tempStr2+","+rset.getString("ROW_ID");
		}
		ret_str=tempStr2;
		if (rset != null) rset.close();
		if(pstmt != null) pstmt.close();
	
		}
		//IN065040 Changes Ends
	
}
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception caught in RecClinicalNotesLinkDiagSelectedText.jsp" + e);//COMMON-ICN-0181
}
/*finally 
{
	
	ConnectionManager.returnConnection(con,request);
}*/



	
            _bw.write(_wl_block7Bytes, _wl_block7);

		if(!ret_str.equals(""))
		{
			
            _bw.write(_wl_block8Bytes, _wl_block8);

				if(fields.size()>0)
				{
					col_span = fields.size();
					col_width= 100/col_span;
					width = col_width+"%";
					

					for(int l=0;l<fields.size();++l)
					{
						col_field = (String)fields.get(l);
						if(col_field.equals("DATEANDTIME"))
						{
						
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

						 innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.datetime.label","common_labels")+"</b></td>");
						}
						else if(col_field.equals("EVENT"))
						{
						
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

						innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Event.label","common_labels")+"</b></td>");
						}
						else if(col_field.equals("VALUE"))
						{
						
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

						innerhtml_header.append("<td align='center' class='columnHeadercenter'  style='font-size:12'><b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Value.label","common_labels")+"</b></td>");
						}


					}
				}
				else
				{

			
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

				}
				
            _bw.write(_wl_block17Bytes, _wl_block17);

		}				
	
            _bw.write(_wl_block18Bytes, _wl_block18);

		htmlData.append("<table id='finalDiv' border='1' cellpadding='0' cellspacing='0'  width='100%'>"); //IN041284
		htmlText.append("<table id='finalDiv' border='0' cellpadding='0' cellspacing='0'  width='100%'>"); //IN052716
		try
		{
			if(!flag.equals("f"))
			{
			if(ret_str!=null || (!ret_str.equals(" ")))
			{
				StringTokenizer strtCodes = new StringTokenizer(ret_str,",");
				
				//con =  ConnectionManager.getConnection(request);
				
				//strsql1="SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,C.LONG_DESC EVENT_GROUP_DESC,C.EVENT_GROUP,B.LONG_DESC EVENT_DESC, B.EVENT_CODE, A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT DECODE(A.NORMALCY_IND,HIGH_STR,'ABNORMAL',LOW_STR,'Abnormal',ABN_STR,'Abnormal',CRIT_STR,'Critically Abnormal',CRIT_HIGH_STR,'Critically Abnormal',CRIT_LOW_STR,'Critically Abnormal') FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT HIST_DATA FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,A.FACILITY_ID,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM CR_ENCOUNTER_DETAIL A,CR_CLIN_EVENT_MAST B ,CR_CLIN_EVENT_GROUP C WHERE B.HIST_REC_TYPE=A.HIST_REC_TYPE AND B.EVENT_CODE=A.EVENT_CODE and  B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  AND  c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  AND C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE AND C.EVENT_GROUP(+)=A.EVENT_GROUP AND A.PATIENT_ID=? AND A.HIST_REC_TYPE =? AND A.ROWID=? ORDER BY a.REQUEST_NUM_SEQ,5,7,6,9,8,3 ";				
				//IN069927 Start.
				//strsql1="SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,C.short_desc EVENT_GROUP_DESC,C.EVENT_GROUP,B.short_desc EVENT_DESC, B.EVENT_CODE, A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT DECODE(a.normalcy_ind,HIGH_STR,'A',LOW_STR,'A',CRIT_STR,'C',ABN_STR,'A',CRIT_HIGH_STR,'C',CRIT_LOW_STR,'C','')FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT HIST_DATA FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,A.FACILITY_ID,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM 	CR_ENCOUNTER_DETAIL A,CR_CLN_EVT_MST_LANG_VW B ,CR_CLN_EVT_GRP_LANG_VW C WHERE 	B.HIST_REC_TYPE=A.HIST_REC_TYPE AND 	B.EVENT_CODE=A.EVENT_CODE and B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and B.language_id = ?  AND c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  AND 	C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE 	AND 	C.EVENT_GROUP(+)=A.EVENT_GROUP 	AND C.language_id(+) = ? and A.PATIENT_ID=? 	AND 	A.HIST_REC_TYPE =? 	AND 	A.ROWID=? 	ORDER BY a.REQUEST_NUM_SEQ,5,7,6,9,8,3";
				strsql1.append("SELECT TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY HH24:MI') EVENT_DATETIME_STR,TO_CHAR(A.EVENT_DATE,'DD/MM/YYYY') EVENT_DATE_STR,TO_CHAR(A.EVENT_DATE,'HH24:MI') EVENT_TIME_STR,A. EVENT_DATE EVENT_DATETIME,TRUNC(A.EVENT_DATE) EVENT_DATE,C.short_desc EVENT_GROUP_DESC,C.EVENT_GROUP,B.short_desc EVENT_DESC, B.EVENT_CODE, A.HIST_DATA_TYPE,A.RESULT_STR, DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999')))||' ' RESULT_NUM,RESULT_NUM_UOM,(SELECT DECODE(a.normalcy_ind,HIGH_STR,'A',LOW_STR,'A',CRIT_STR,'C',ABN_STR,'A',CRIT_HIGH_STR,'C',CRIT_LOW_STR,'C','')FROM CR_CLIN_EVENT_PARAM) Normalcy_Str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_LOW),TO_CHAR(NORMAL_LOW,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low_value_str,DECODE(NVL(RESULT_NUM_DEC,0),0, TO_CHAR(NORMAL_HIGH),TO_CHAR(NORMAL_HIGH,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) Normal_high_value_str,(SELECT HIST_DATA FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA ,A.FACILITY_ID,(SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE=A.HIST_REC_TYPE AND  CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) HIST_DATA_EXISTS,A.ENCOUNTER_ID,A.PATIENT_CLASS,A.CONTR_SYS_ID,A.ACCESSION_NUM,A.CONTR_SYS_EVENT_CODE,A.ROWID ROW_ID FROM 	CR_ENCOUNTER_DETAIL A,CR_CLN_EVT_MST_LANG_VW B ,CR_CLN_EVT_GRP_LANG_VW C WHERE 	B.HIST_REC_TYPE=A.HIST_REC_TYPE AND 	B.EVENT_CODE=A.EVENT_CODE and B.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and B.language_id = ?  AND c.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE  AND 	C.HIST_REC_TYPE(+)=A.HIST_REC_TYPE 	AND 	C.EVENT_GROUP(+)=A.EVENT_GROUP 	AND C.language_id(+) = ? and A.PATIENT_ID=? 	AND 	A.HIST_REC_TYPE =? 	AND 	A.ROWID=? ");
				if(order_by1.equals("D")){
					if(order_by2.trim().equals("AS")){
							strsql1.append(" order by A.EVENT_DATE,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
					}else{
						strsql1.append(" order by A.EVENT_DATE desc ,a.REQUEST_NUM_SEQ,C.LONG_DESC ");
					}
				}else if (order_by1.equals("N")){
					if(order_by2.trim().equals("AS")){
						strsql1.append(" order by a.REQUEST_NUM_SEQ,C.LONG_DESC,A.EVENT_DATE");
					}else{
					   strsql1.append(" order by a.REQUEST_NUM_SEQ desc,C.LONG_DESC desc,A.EVENT_DATE desc ");
					}
				}		
				strsql1.append(" ,6,7,8,9,3");
				
				//stmt = con.prepareStatement(strsql1);
				stmt = con.prepareStatement(strsql1.toString());
				// IN069927 End.
				
				String formet	=	"";
				while(strtCodes.hasMoreTokens())
				{
					if(strtCodes.hasMoreElements())
						temp= (String) strtCodes.nextToken();

					stmt.setString(1,locale);
					stmt.setString(2,locale);
					stmt.setString(3,patient_id);
					stmt.setString(4,hist_rec_type);
					stmt.setString(5,temp);

					rs = stmt.executeQuery();
					
					while(rs!=null && rs.next())
					{
						 event_date_str			=		rs.getString("EVENT_DATE_STR")==null?"":rs.getString("EVENT_DATE_STR");
						 event_group_desc		=		rs.getString("EVENT_GROUP_DESC")==null?"":rs.getString("EVENT_GROUP_DESC");
						 event_time_str			=		rs.getString("EVENT_TIME_STR")==null?"":rs.getString("EVENT_TIME_STR");
						 event_desc				=		rs.getString("EVENT_DESC")==null?"":rs.getString("EVENT_DESC");
						 result_num				=		rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM");
						 result_num_uom			=		rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
					     //normalcy_str			=		rs.getString("Normalcy_Str")==null?"":rs.getString("Normalcy_Str");
						 normalcy				=		rs.getString("Normalcy_Str")==null?"":rs.getString("Normalcy_Str");
						 hist_data_type			=		rs.getString("HIST_DATA_TYPE")==null?"":rs.getString("HIST_DATA_TYPE");
						 normal_low_value_str	=		rs.getString("normal_low_value_str")==null?"":rs.getString("normal_low_value_str");//IN048844 "0" to ""
						 normal_high_value_str	=		rs.getString("normal_high_value_str")==null?"":rs.getString("normal_high_value_str");//IN048844 "0"to""
						 result_str				=		rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
						 hist_data				=		rs.getClob("HIST_DATA");
						 hist_data_exists		=		rs.getString("HIST_DATA_EXISTS")==null?"":rs.getString("HIST_DATA_EXISTS");
						 //Date conversion is done by Archana Dhal on 10/15/2010 related to incident IN024498.
						 event_date_str	=	com.ehis.util.DateUtils.convertDate(event_date_str,"DMY","en",locale);

						if(normalcy.equals("A"))
							normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels");										
						else if(normalcy.equals("C"))
							normalcy_str=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CriticallyAbnormal.label","or_labels");
						else
							normalcy_str = "";
						//IN048844 - Commentted Start
						 //int normal_low_value=(int)Float.parseFloat(normal_low_value_str);
						 //normal_low_value_str=String.valueOf(normal_low_value);
						 //int normal_high_value=(int)Float.parseFloat(normal_high_value_str);
						 //normal_high_value_str=String.valueOf(normal_high_value);
						//IN048844 - Commentted End
						 displaydata.setLength(0);
						
						 if(hist_data!=null)
						 {
							java.io.BufferedReader r = new java.io.BufferedReader(hist_data.getCharacterStream());
							String line = null;
					
							while((line=r.readLine()) != null) 
							{
								displaydata.append(line+"\n");
							}
						 }
			
						 formet = "";

						if(return_format.equals("TEXT"))
							formet="\n";
						else
							formet="<br>";
		
						textFormat.append(formet);
						htmlData.append(formet); //IN041284
						//IN063865 starts
						if("Y".equals(dateTimeAlign))
						event_date_str = event_date_str+ "-" + event_time_str;
						//IN063865 Ends
						
						//out.println("event_date_str    :   "+event_date_str);
						if(!event_date_str_prev.equals(event_date_str))
						{	
							textFormat.append(event_date_str);
							textFormat.append(formet);
							
							
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(event_date_str));
            _bw.write(_wl_block20Bytes, _wl_block20);

							//IN041284 Start.
							htmlData.append("<tr><td  class='gridData' colspan='3'><font size=2>");
							htmlData.append(event_date_str);
							htmlData.append("</font></td></tr>");
							htmlData.append(formet);
							//IN041284 End.
							//IN052716 Start
							htmlText.append("<tr><td  class='' colspan='3'><font size=2>");
							htmlText.append(event_date_str);
							htmlText.append("</font></td></tr>");
							htmlText.append(formet);
							//IN052716 End.
							event_group_desc_prev="";
						}

						//if(!event_group_desc_prev.equals(event_group_desc))
						if(!event_group_desc_prev.equals(event_group_desc) && !"".equals(event_group_desc))
						{
							if(return_format.equals("TEXT"))
						    {	
								textFormat.append("             "+event_group_desc);
								textFormat.append(formet);
							}
							else
							{	
								textFormat.append("             "+event_group_desc);
								textFormat.append(formet);	
							}
							
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(event_group_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);

							//IN041284 Start.
							htmlData.append("<tr><td   class='gridData'>&nbsp;</td> <td   class='gridData'  colspan='2'><font size=2>");
							htmlData.append(event_group_desc);
							htmlData.append("</font></td></tr>");
							//IN041284 End.
							////IN052716 Start.
							htmlText.append("<tr><td   class=''>&nbsp;</td> <td   class=''  colspan='2'><font size=2>");
							htmlText.append(event_group_desc);
							htmlText.append("</font></td></tr>");
							//IN052716 End.
						}
						
            _bw.write(_wl_block23Bytes, _wl_block23);
 
							htmlData.append("<tr>"); //IN041284
							htmlText.append("<tr>");  //IN052716
						
            _bw.write(_wl_block24Bytes, _wl_block24);

						//IN063865 starts
						if(return_format.equals("TEXT")){
							if("Y".equals(dateTimeAlign))
								textFormat.append("                    "+event_desc+" "+result_num+" "+result_num_uom+" "+ normalcy_str+" ");	
							else
								textFormat.append("   "+event_time_str+"                 "+event_desc+" "+result_num+" "+result_num_uom+" "+ normalcy_str+" ");	

						}else{
							if("Y".equals(dateTimeAlign))
								textFormat.append("                              "+event_desc+" "+result_num+" "+result_num_uom+" "+ normalcy_str+" ");
							else
								textFormat.append("   "+event_time_str+"                           "+event_desc+" "+result_num+" "+result_num_uom+" "+ normalcy_str+" ");
								
						}
						//IN063865 Ends
						
            _bw.write(_wl_block24Bytes, _wl_block24);

						
						if(fields.size()>0)
						{
							for(int n=0;n<fields.size();++n)
							{
								col_field = (String)fields.get(n);
								

								if(col_field.equals("DATEANDTIME")) {
								//IN063865 starts
								if("N".equals(dateTimeAlign)) { 
								
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((hist_data_type.equals("HTM")?"OAYELLOW":"gridData")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(event_time_str));
            _bw.write(_wl_block27Bytes, _wl_block27);

								} else { 
            _bw.write(_wl_block28Bytes, _wl_block28);

								} // ML-MMOH-CRF-0534 [IN061882] - End
								//IN063865 Ends
								htmlData.append("<td  class='"+(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")+"' width='15%' >"); //IN041284
								if("N".equals(dateTimeAlign)) { 
									htmlData.append("<font size=2>"+event_time_str+"</font></td>"); //IN041284
									htmlText.append("<td  class='' width='15%' >"); //IN052716
									htmlText.append("<font size=2>"+event_time_str+"</font></td>"); //IN052716
									temp_new.append(""+event_time_str+"");
								}	
								//innerhtml.append("<td style='font-size:12'>&nbsp;"+event_time_str+"</td>");
								}
								else if(col_field.equals("EVENT"))
								{
								
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((hist_data_type.equals("HTM")?"OAYELLOW":"gridData")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(event_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);

								htmlData.append("<td  class='"+(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")+"' width='25%' ><font size=2>"+event_desc+"</font></td>"); //IN041284
								htmlText.append("<td  class='' width='25%' ><font size=2>"+event_desc+"</font></td>"); //IN052716
								temp_new.append(","+event_desc);	
								//innerhtml.append("<td style='font-size:12'>&nbsp;"+event_desc+"</td>");
								}
								else if(col_field.equals("VALUE"))
								{
								
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(width));
            _bw.write(_wl_block31Bytes, _wl_block31);


									if (hist_data_type.equals("NUM") || hist_data_type.equals("TXT") || hist_data_type.equals("STR"))
									{	
										if("N".equals(disable_ref_range_yn)) {
										
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(result_num));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(result_num_uom));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(normalcy_str));
            _bw.write(_wl_block35Bytes, _wl_block35);

											htmlData.append("<td class='gridData' width='60%' ><font size=2>"+result_num+"&nbsp;"+result_num_uom+"&nbsp;&nbsp;&nbsp;"+normalcy_str); //IN041284
											htmlText.append("<td class='' width='60%' ><font size=2>"+result_num+"&nbsp;"+result_num_uom+"&nbsp;&nbsp;&nbsp;"+normalcy_str); //IN052716
									
										} else {
											
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(result_num));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(result_num_uom));
            _bw.write(_wl_block37Bytes, _wl_block37);

												htmlData.append("<td class='gridData' width='60%' ><font size=2>"+result_num+"&nbsp;"+result_num_uom); //IN041284
												htmlText.append("<td class='' width='60%' ><font size=2>"+result_num+"&nbsp;"+result_num_uom); //IN052716
												
										}
										//if(!normal_low_value_str.equals("0") && !normal_high_value_str.equals("0")) //IN048844	
										if("N".equals(disable_ref_range_yn)){ //IN063645
											if(!normal_low_value_str.equals("") && !normal_high_value_str.equals("")) //IN048844
											{
												textFormat.append("("+normal_low_value_str+"-"+normal_high_value_str+") ");
												
											 
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(normal_low_value_str));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(normal_high_value_str));
            _bw.write(_wl_block40Bytes, _wl_block40);

												htmlData.append("("+normal_low_value_str+"-"+normal_high_value_str+")");   //IN041284
												htmlText.append("("+normal_low_value_str+"-"+normal_high_value_str+")");  //IN052716
											}
										}
										if (!result_str.equals(""))
										{	
											if("N".equals(disable_spec_type_yn))  { // ML-MMOH-CRF-0534 [IN061882] 
											
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block41Bytes, _wl_block41);
 
											htmlData.append("&nbsp;"+result_str+"&nbsp;"); //IN041284
											htmlText.append("&nbsp;"+result_str+"&nbsp;");  //IN052716
											textFormat.append("   "+result_str+"  ");
											}// ML-MMOH-CRF-0534 [IN061882]
										}
										
										if(hist_data_exists.equals("Y"))
										{
											   
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(displaydata.toString()));
            _bw.write(_wl_block44Bytes, _wl_block44);

											   htmlData.append("</font></td></tr><tr><td class='gridData' colspan='3' ><font size=2>"); //IN041284
											   htmlData.append("Comment");	//IN041284
											   htmlData.append(":<br><br>"+displaydata.toString()); //IN041284
											   //IN052716 Start. 
											   htmlText.append("</font></td></tr><tr><td class='' colspan='3' ><font size=2>"); 
											   htmlText.append("Comment");	
											   htmlText.append(":<br><br>"+displaydata.toString()); 
											   //IN052716 End.
										}
									 }
									 else if (hist_data_type.equals("HTM") )
									 {
										 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block46Bytes, _wl_block46);
 
											htmlData.append("<td class='gridData' width='60%' >&nbsp;</td><tr><td class='gridData' colspan='3'  ><font size=2>"+result_str+"&nbsp;"); //IN041284
											htmlText.append("<td class='' width='60%' >&nbsp;</td><tr><td class='' colspan='3'  ><font size=2>"+result_str+"&nbsp;");//IN052716
											textFormat.append("   "+result_str+"  ");
											
											
											if(hist_data_exists.equals("Y"))
											{
												
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(displaydata.toString()));
            _bw.write(_wl_block48Bytes, _wl_block48);

												htmlData.append("</font></td></tr><tr><td class='gridData' colspan='3' ><font size=2>");  //IN041284
												htmlData.append("Comment"); //IN041284
												htmlData.append(":<br>"+displaydata.toString()); //IN041284
												//IN052716 Start.
												htmlText.append("</font></td></tr><tr><td class='' colspan='3' ><font size=2>"); 
												htmlText.append("Comment"); 
												htmlText.append(":<br>"+displaydata.toString()); 
												//IN052716 End.
											}
									 }

									 if(hist_data_exists.equals("Y"))
									 {
										if (hist_data_type.equals("TXT"))
												textFormat.append(displaydata.toString()+formet); 	
										else if(hist_data_type.equals("STR"))
											textFormat.append(formet+"Comment:"+displaydata.toString()+formet); 

										
									 }
									
									 
            _bw.write(_wl_block49Bytes, _wl_block49);

								htmlData.append("</font></td></tr>");  //IN041284
								htmlText.append("</font></td></tr>"); //IN052716
								temp_new.append(","+displaydata.toString());	
								//innerhtml.append("<td style='font-size:12'>&nbsp;"+displaydata.toString()+"</td>");
								}
						
							
							}

						}
						else
						{
						
						
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf((hist_data_type.equals("HTM")?"OAYELLOW":"gridData")));
            _bw.write(_wl_block51Bytes, _wl_block51);
if("Y".equals(dateTimeAlign)){
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf((hist_data_type.equals("HTM")?"OAYELLOW":"gridData")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(event_desc));
            _bw.write(_wl_block54Bytes, _wl_block54);
}else{
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(event_time_str));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf((hist_data_type.equals("HTM")?"OAYELLOW":"gridData")));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(event_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
		}
						htmlData.append("<td width='15%' class='"+(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")+"' >");  //IN041284
						if("Y".equals(dateTimeAlign)) // IN063865 added if condition 
						htmlData.append("</td><td width='25%' class='"+(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")+"'><font size=2>"+event_desc+"</font></td>"); //IN041284
						else
						htmlData.append("<font size=2>"+event_time_str+"</font></td><td width='25%' class='"+(hist_data_type.equals("HTM")?"OAYELLOW":"gridData")+"'><font size=2>"+event_desc+"</font></td>"); //IN041284

						htmlText.append("<td width='15%' class='' >");   //IN052716
						if("Y".equals(dateTimeAlign)) //IN063865 added if condition
							htmlText.append(" </td><td width='25%' class=''><font size=2>"+event_desc+"</font></td>"); //IN052716
						else
							htmlText.append("<font size=2>"+event_time_str+"</font></td><td width='25%' class=''><font size=2>"+event_desc+"</font></td>"); 

					if (hist_data_type.equals("NUM") || hist_data_type.equals("STR") || hist_data_type.equals("TXT"))
					{	
						if("N".equals(disable_ref_range_yn)) {
						
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(result_num));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(result_num_uom));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(normalcy_str));
            _bw.write(_wl_block24Bytes, _wl_block24);

							htmlData.append("<td  width='60%' class='gridData'><font size=2>"+result_num+"&nbsp;"+result_num_uom+"&nbsp;&nbsp;&nbsp;"+normalcy_str); //IN041284
							htmlText.append("<td  width='60%' class=''><font size=2>"+result_num+"&nbsp;"+result_num_uom+"&nbsp;&nbsp;&nbsp;"+normalcy_str); //IN052716
						} else {
							
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(result_num));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(result_num_uom));
            _bw.write(_wl_block60Bytes, _wl_block60);

							htmlData.append("<td  width='60%' class='gridData'><font size=2>"+result_num+"&nbsp;"+result_num_uom); //IN041284
							htmlText.append("<td  width='60%' class=''><font size=2>"+result_num+"&nbsp;"+result_num_uom); //IN052716
						}
						//if(!normal_low_value_str.equals("0") && !normal_high_value_str.equals("0"))//IN048844
					    if("N".equals(disable_ref_range_yn)) {
							if(!normal_low_value_str.equals("") && !normal_high_value_str.equals("")) //IN048844
							{	
								textFormat.append("("+normal_low_value_str+"-"+normal_high_value_str+") ");
							 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(normal_low_value_str));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(normal_high_value_str));
            _bw.write(_wl_block62Bytes, _wl_block62);

							 htmlData.append("("+normal_low_value_str+"-"+normal_high_value_str+")"); //IN041284
							 htmlText.append("("+normal_low_value_str+"-"+normal_high_value_str+")"); //IN052716
							}
					    }	
						if (!result_str.equals("") && "N".equals(disable_spec_type_yn )) //IN063865
						{
							
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block63Bytes, _wl_block63);
 
								textFormat.append("   "+result_str+"  ");
							htmlData.append("&nbsp;"+result_str+"&nbsp;"); //IN041284
							htmlText.append("&nbsp;"+result_str+"&nbsp;"); //IN052716
						}
						
						if(hist_data_exists.equals("Y"))
						{
						  
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(displaydata.toString()));
            _bw.write(_wl_block66Bytes, _wl_block66);

						  htmlData.append("</font></td></tr><tr><td colspan='3'  class='gridData'><font size=2>"); //IN041284
						  htmlData.append("Comment"); //IN041284
						  htmlData.append(":"+displaydata.toString()+"</td></tr>"); //IN041284
						  //IN052716 Start.
						  htmlText.append("</font></td></tr><tr><td colspan='3'  class=''><font size=2>"); 
						  htmlText.append("Comment"); 
						  htmlText.append(":"+displaydata.toString()+"</td></tr>"); 
						  //IN052716 End.
						}
						   
					 }
					 else if (hist_data_type.equals("HTM") )
					 {
						 
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(result_str));
            _bw.write(_wl_block68Bytes, _wl_block68);
 
							htmlData.append("</font></td><td width='60%' class='gridData'></td></tr><tr><td colspan='3'  class='gridData'><font size=2>&nbsp;"+result_str+"&nbsp;"); //IN041284
							htmlText.append("</font></td><td width='60%' class=''></td></tr><tr><td colspan='3'  class='gridData'><font size=2>&nbsp;"+result_str+"&nbsp;"); //IN052716
							textFormat.append("   "+result_str+" ");
													
							if(hist_data_exists.equals("Y"))
							{
								
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(displaydata.toString()));
            _bw.write(_wl_block70Bytes, _wl_block70);

								htmlData.append("</font></td></tr><tr><td colspan='3'  class='gridData'><font size=2>"); //IN041284
								htmlData.append("Comment"); //IN041284
								htmlData.append(":"+displaydata.toString()+"</td></tr>"); //IN041284
								//IN052716 Start.
								htmlText.append("</font></td></tr><tr><td colspan='3'  class=''><font size=2>"); 
								htmlText.append("Comment"); 
								htmlText.append(":"+displaydata.toString()+"</td></tr>"); 
								//IN052716 End.
							}
							
					 }
					//	out.println("hist_data_exists    :   "+hist_data_exists+"     textFormat   :   "+textFormat);
					 if(hist_data_exists.equals("Y"))
					 {
						if (hist_data_type.equals("TXT"))
							textFormat.append(displaydata.toString()+formet); 	
						else if(hist_data_type.equals("STR"))
						    textFormat.append(formet+"Comment:"+displaydata.toString()+formet); 

						
					 }
					
					 
            _bw.write(_wl_block71Bytes, _wl_block71);

					htmlData.append("</font></td></tr>"); //IN041284
					htmlText.append("</font></td></tr>");  //IN052716
					}
				   
            _bw.write(_wl_block72Bytes, _wl_block72);

					 k++;
					 if("Y".equals(dateTimeAlign)) //<!--IN063865 added if condition -->
					 event_date_str_prev = event_date_str;
					 else
					 event_date_str_prev = event_date_str;
					 event_group_desc_prev=event_group_desc;
					 event_time_str_prev=event_time_str; //ML-MMOH-CRF-0534
				}

				if(rs!=null) rs.close();	
		}
			
	}
}

if(stmt!=null)stmt.close();		 	

}
	
catch(Exception e)
{
	e.printStackTrace();
	//out.println("Exception cauight in RecClinicalNotesLinkHistRepSelectedText.jsp" + e);//COMMON-ICN-0181
}
finally 
{
	
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
htmlData.append("</table>"); //IN041284
htmlText.append("</table>"); //IN052716

            _bw.write(_wl_block73Bytes, _wl_block73);

String cat="";
String catHtml="";
String catText = ""; //IN052716
if(!return_format.equals("TEXT"))
{
	cat = "<font size=2>"+textFormat.toString()+"</font>";

}
else
{
	cat = textFormat.toString();
}
cat = java.net.URLEncoder.encode(cat,"UTF-8"); //IN036181
catHtml=htmlData.toString(); //IN041284
catHtml = catHtml.replaceAll("<BR>","");
catHtml = catHtml.replaceAll("<br>","");
catHtml = java.net.URLEncoder.encode(catHtml,"UTF-8"); //IN041284
//IN052716 Start
catText=htmlText.toString(); 
catText = catText.replaceAll("<BR>","");
catText = catText.replaceAll("<br>","");
catText = java.net.URLEncoder.encode(catText,"UTF-8"); 
//IN052716 End.

            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(cat.trim()));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(catHtml.trim()));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(catText.trim()));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Comment.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Comment.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Comment.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.Comment.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
