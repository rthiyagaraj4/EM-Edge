package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCP.*;
import eCommon.Common.*;
import com.ehis.eslp.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import java.text.*;
import eOR.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __buildlibraryinterventiondetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/BuildLibraryInterventionDetail.jsp", 1742797682113L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\n      \t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></SCRIPT>\n\t\t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\' ></SCRIPT>\n      \t<SCRIPT language=\'javascript\' src=\'../../eCommon/js/common.js\' ></SCRIPT>\n\t\t<SCRIPT language=\"javascript\" src=\"../js/BuildLibrary.js\"></SCRIPT> \n</HEAD>\n<BODY onKeyDown = \'lockKey()\';  OnMouseDown=\"CodeArrest()\">\n<FORM name=\"formBuildLibraryInterventionDetails\" id=\"formBuildLibraryInterventionDetails\" style=\"overflow-y:scroll;overflow-x:hidden\">\n<script language=\'javascript\'>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<TABLE border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"125%\" align=\"center\">\n\t\t<TR>\n\t\t<TD width=\"70%\" class=\"white\">&nbsp;</TD>\t\t\n\t\t<TD width=\"11%\"align=\"right\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\n\t\t\t<label onClick=\'Interventionnavigation(document.formBuildLibraryInterventionDetails,\"previous\")\'  style=\'cursor:pointer;color:blue\'> ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</label>&nbsp;&nbsp;\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<label onClick=\'Interventionnavigation(document.formBuildLibraryInterventionDetails,\"next\")\'  style=\'cursor:pointer;color:blue\'> ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</label>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</TD><TD width=\"19%\" class=\"white\">&nbsp;</TD></TR></TABLE>\n\n<TABLE border=\'1\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'  width=\'130%\' >\n\t<!-- <TH >Intervention Type</TH> -->\n\t<TH >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</TH>\n\t<TH width=\"5%\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</TH>\n\t<TH width=\"13%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</TH>\n\t<TH width=\"16%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</TH>\n\t<TH width=\"15%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</TH>\n\t<TH width=\"3%\" >&nbsp;</TH>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<TR>\n\t\t<!-- <TD class=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</TD> -->\n\t\t<TD class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<INPUT type=\"hidden\" name=\"interventionDesc";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" id=\"interventionDesc";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t</TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" align=\"center\"><INPUT type=\"text\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" maxlength=\"4\" size=\"1\"  value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" name=\"Alt";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" onblur=\"updateInterventionList(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')\"></TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" align=\"center\"><INPUT type=\"text\"  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" maxlength=\"5\" size=\"1\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" name=\"relativeStart";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" onKeyPress=\'return(ChkNumberInput(this,event,0))\' onblur=\"updateInterventionList(\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\')\">\n\t\t\t<SELECT name=\"relativeStartType";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" id=\"relativeStartType";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" onchange=\"updateInterventionList(\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\')\">\n\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<OPTION ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</OPTION>\n\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t</SELECT>\n\t\t</TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" align=\"left\">\n\t\t\t\t<SELECT name=\"frequency";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"frequency";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" onchange=\"loadDurntypes(this,\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\');updateInterventionList(\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\')\">\n\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t<!-- <INPUT TYPE=\"hidden\" name=\"\" id=\"\" value=\"\"> -->\n\t\t\t\t\t<OPTION ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</OPTION>\n\t\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"  align=\"center\">\n\t\t\t<INPUT type=\"text\" name=\"Duration";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"Duration";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\')\">\n\t\t\t<SELECT name=\"DurationType";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"DurationType";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t\t\t<!-- <OPTION value=\"\"></OPTION> -->\n\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t<option ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" value=\"M\" >";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</option>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" value=\"H\" >";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" value=\"D\" >";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</option>\n\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t<option ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" value=\"W\" >";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" value=\"L\" >";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t<option  value=\"M\" >";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</option>\n\t\t\t\t\t\t<option value=\"H\" >>";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</option>\n\t\t\t\t\t\t<option value=\"D\" >";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</option>\n\t\t\t\t\t\t<option value=\"W\" >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</option>\n\t\t\t\t\t\t<option value=\"L\" >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</option>\n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" align=\"center\">\n\t\t\t<SELECT name=\"Dependency";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"Dependency";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t<OPTION ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t</SELECT></TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" align=\"center\">\n\t\t\t\t<SELECT name=\"stage";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"stage";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\')\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t<OPTION ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="</OPTION>\n\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t</SELECT>\n\t\t</TD>\n\t\t<TD class=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" align=\"center\" ><INPUT type=\"checkBox\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" name=\"select";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" onclick=\"updateInterventionList(\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\')\"></TD>\n\t</TR>\n";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n</TABLE>\n<INPUT type=\"hidden\" name=\"start\" id=\"start\"     value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n<INPUT type=\"hidden\" name=\"end\" id=\"end\"       value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n<INPUT type=\"hidden\" name=\"alphalink\" id=\"alphalink\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n<INPUT type=\"hidden\" name=\"termSet\" id=\"termSet\"   value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n<INPUT type=\"hidden\" name=\"termCode\" id=\"termCode\"  value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n<INPUT type=\"hidden\" name=\"goalCode\" id=\"goalCode\"  value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n<INPUT type=\"hidden\" name=\"libraryid\" id=\"libraryid\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n<INPUT type=\"hidden\" name=\"versionno\" id=\"versionno\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n<INPUT type=\"hidden\" name=\"maxGrpID\" id=\"maxGrpID\"  value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<INPUT type=\"hidden\" name=\"GroupID\" id=\"GroupID\"   value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t<!-- <SCRIPT>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\"));</SCRIPT> -->\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n</FORM>\n</BODY>\n</HTML>\n\n\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.RecordSet BuildLibrary= null;synchronized(session){
                BuildLibrary=(webbeans.eCommon.RecordSet)pageContext.getAttribute("BuildLibrary",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(BuildLibrary==null){
                    BuildLibrary=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("BuildLibrary",BuildLibrary,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);

		//This file is saved on 18/10/2005.
		 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		 String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String alphalink				=	request.getParameter("alphalink")==null ? "":request.getParameter("alphalink");
String termSet					=	request.getParameter("termSet");
String termCode					=	request.getParameter("termCode");
String goalCode					=	request.getParameter("goalCode");
String libraryid				=	request.getParameter("libraryid");
String versionno				=	request.getParameter("versionno");
String maxGrpID					=	request.getParameter("maxGrpID");
String GroupID1					=	request.getParameter("GroupID");
int GroupID						=	Integer.parseInt(GroupID1);

if(!GroupID1.equals("0")){
	maxGrpID=GroupID1;
}
//out.println("maxGrpID"+maxGrpID);
//out.println("GroupID1"+GroupID1);
alphalink						=	alphalink.trim();
Connection connection			=	null;
PreparedStatement pstmt			=	null;
PreparedStatement pstmt1			=	null;//common-icn-0180
PreparedStatement pstmt2			=	null;//common-icn-0180
PreparedStatement pstmt3			=	null;//common-icn-0180
Statement stmt					=	null;
ResultSet rs					=	null;
Statement stmt1					=	null;
ResultSet rs1					=	null;
String from						=	request.getParameter("from") ;
String to						=	request.getParameter("to") ;
String classValue				=	"";
String  sqlData					=	"";
String interventionTypeDesc		=	"";
String interventionCode			=	"";
String interventionDesc			=	"";
String Alt						=	"";
String relativeStart			=	"";
String relativeStartType		=	"";
String tempRelativeStartType	=	"";
String relativeStartSelect		=	"";
String frequency				=	"";
String tempfreq					=	"";
String tempFrequency			=	"";
String frequencySelect			=	"";
String freqdurnunit				=	"";
String freqdurnunitload			=	"";
String freq_default_yn			=	"";
char ch_durn_unit				=	' ';
String freqoptname				=	"";
String Duration					=	"";
String DurationType				=	"";
//String tempDurationType			=	"";
String MDurationSelect			=	"";
String HDurationSelect			=	"";
String WDurationSelect			=	"";
String LDurationSelect			=	"";
String DDurationSelect			=	"";

String dependency				=	"";
String dependencySelect			=	"";
String stage					=	"";
String tempStage				=	"";
String stageSelect				=	"";
String status					=	"";
String checkAttribute			=	"";
String GrpID					=	"";
String disabled					=	"";
String readonly					=	"";
int GrpID1						=	0;
//String sqlFrequency				=	"SELECT FREQ_CODE,FREQ_DESC FROM AM_FREQUENCY WHERE EFF_STATUS='E' ORDER BY 2";
//String sqlIntvnFrequency		=	"SELECT A.FREQ_CODE, A.DEFAULT_YN,B.FREQ_DESC,b.INTERVAL_DURN_TYPE FREQ_DURNUNIT FROM   CA_INTERVENTION_FREQ A,AM_FREQUENCY                     B WHERE  A.INTERVENTION_CODE=? AND A.FREQ_CODE=B.FREQ_CODE ";
//String sqlIntvnFrequency		=	"SELECT A.FREQ_CODE, A.DEFAULT_YN,B.FREQ_DESC,b.INTERVAL_DURN_TYPE FREQ_DURNUNIT FROM   CA_INTERVENTION_FREQ A,AM_FREQUENCY_LANG_VW B WHERE  A.INTERVENTION_CODE=? AND A.FREQ_CODE=B.FREQ_CODE AND B.LANGUAGE_ID = '"+locale+"'";//common-icn-0180
String sqlIntvnFrequency		=	"SELECT A.FREQ_CODE, A.DEFAULT_YN,B.FREQ_DESC,b.INTERVAL_DURN_TYPE FREQ_DURNUNIT FROM   CA_INTERVENTION_FREQ A,AM_FREQUENCY_LANG_VW B WHERE  A.INTERVENTION_CODE=? AND A.FREQ_CODE=B.FREQ_CODE AND B.LANGUAGE_ID = ?";//common-icn-0180


//String sqlDurationType			=	"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw WHERE language_id='"+locale+"'";
//String sqlDurationType			=	"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw WHERE language_id='"+locale+"'";//common-icn-0180
String sqlDurationType			=	"SELECT DURN_TYPE,DURN_DESC FROM AM_DURATION_TYPE_lang_vw WHERE language_id= ?";//common-icn-0180


//String sqlStage					=	"SELECT STAGE_CODE,SHORT_DESC FROM CP_STAGE_lang_vw WHERE language_id='"+locale+"' and EFF_STATUS='E' ORDER BY 2";
//String sqlStage					=	"SELECT STAGE_CODE,SHORT_DESC FROM CP_STAGE_lang_vw WHERE language_id='"+locale+"' and EFF_STATUS='E' ORDER BY 2";//common-icn-0180
String sqlStage					=	"SELECT STAGE_CODE,SHORT_DESC FROM CP_STAGE_lang_vw WHERE language_id= ? and EFF_STATUS='E' ORDER BY 2";//common-icn-0180


//ArrayList frequencyList			=	new ArrayList();
ArrayList IntvnfreqList			=	null;
ArrayList DurationList			=	new ArrayList();
ArrayList StageList				=	new ArrayList();
ArrayList TermCodeList			=	null;
ArrayList Goal					=	null;
HashMap	interventionOutcome		=	null;
ArrayList Intervention			=	null;

String tempTermSet				=	"";
String tempTermCode				=	"";

int maxRecord					=	0;
int dep							=	0;
int start						=	0 ;
int end							=	0 ;
int i							=	1;
 if (from == null){ start = 0 ;  }   else {  start = Integer.parseInt( from ) ; }
 if (to == null){ end = 5 ; }   else {  end = Integer.parseInt( to ) ; }

 ArrayList sessionList				=		(ArrayList)BuildLibrary.getRecordSetHandle();
	if(sessionList.size()>0)
	{
		TermCodeList=(ArrayList)BuildLibrary.getObject(0);
	}
	
if(alphalink.equals("Associated") && !GroupID1.equals("0")){	
//	sqlData="SELECT 	B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,B.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,A.SEQ_NO,A.GROUP_ID, A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT, A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG,'U' DB_ACTION FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION B, CA_INTERVENTION_TYPE C WHERE	A.LIBRARY_ID = '"+libraryid+"' AND  A.VERSION_NO = '"+versionno+"' AND  A.TERM_SET_ID = '"+termSet+"' AND  A.TERM_CODE = '"+termCode+"' AND  A.GOAL_CODE = '"+goalCode+"' AND  B.INTERVENTION_CODE =A.INTERVENTION_CODE AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE ORDER BY INTERVENTION_DESC";
	sqlData		=	"SELECT INTERVENTION_CODE,SHORT_DESC INTERVENTION_DESC FROM CA_INTERVENTION_LANG_VW WHERE INTERVENTION_CODE IN (";
	boolean first_time=true;
	for(int j=0;j<TermCodeList.size();j=j+7){
				 tempTermSet		=	(String)TermCodeList.get(j);
				 tempTermCode		=	(String)TermCodeList.get(j+1);
				if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
					Goal				=	(ArrayList)TermCodeList.get(j+2);
					if(Goal.contains(goalCode)){
						int index				=	Goal.indexOf(goalCode);
						 interventionOutcome	=	(HashMap)Goal.get(index+3);
						 Intervention			=	(ArrayList)interventionOutcome.get("I");
						 if(Intervention.size()>0){
							 for(int k=0;k<Intervention.size();k=k+13){
								 if(!first_time)
									 sqlData =sqlData+",";
								 if(first_time){
									 sqlData =sqlData+"'"+(String)Intervention.get(k)+"'";
									 first_time=false;
								 }
								 else{
									sqlData =sqlData+"'"+(String)Intervention.get(k)+"'";
								 }

							 }
						 }
					}
				}
		}
		//sqlData=sqlData+") AND LANGUAGE_ID = '"+locale+"' ORDER BY INTERVENTION_DESC";//common-icn-0180
		sqlData=sqlData+") AND LANGUAGE_ID = ? ORDER BY INTERVENTION_DESC";//common-icn-0180
	}
else if(!GroupID1.equals("0") || !alphalink.equals("Associated"))
{	
	//sqlData="SELECT  A.INTERVENTION_TYPE,B.SHORT_DESC INTERVENTION_TYPE_DESC, INTERVENTION_CODE,A.SHORT_DESC INTERVENTION_DESC, 	TO_CHAR(NULL) ACCURACY_INDICATOR, TO_NUMBER(NULL) SEQ_NO,TO_NUMBER(NULL) GROUP_ID,	TO_NUMBER(NULL) REL_START_PERIOD, TO_CHAR(NULL) REL_START_PERIOD_UNIT, TO_CHAR(NULL) FREQ_CODE,TO_NUMBER(NULL) FREQ_DURN, TO_CHAR(NULL) FREQ_DURN_UNIT,TO_NUMBER(NULL) DEPENDENCY_LEVEL,	TO_CHAR(NULL) ALT_INTERVENTION_CODE,TO_CHAR(NULL) STAGE_CODE,	DECODE(RESULT_ID,NULL,'I','O') INTVN_FLAG,'I' DB_ACTION  FROM  CA_INTERVENTION                     A, CA_INTERVENTION_TYPE                     B WHERE	( ('"+alphalink+"' IS NOT NULL 	AND UPPER(A.SHORT_DESC) LIKE UPPER('"+alphalink+"%')	)	OR 	('"+alphalink+"' IS NULL AND UPPER(SUBSTR(A.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z'))   AND  A.EFF_STATUS = 'E'   AND  INTERVENTION_CODE NOT IN (SELECT INTERVENTION_CODE FROM CP_LIBRARY_INTERVENTION  WHERE LIBRARY_ID = '"+libraryid+"' AND VERSION_NO = '"+versionno+"'  AND TERM_SET_ID = '"+termSet+"' AND TERM_CODE = '"+termCode+"'  AND GOAL_CODE = '"+goalCode+"')   AND B.INTERVENTION_TYPE = A.INTERVENTION_TYPE                                                                                                                                         UNION ALL SELECT 	B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,	A.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,	A.SEQ_NO,A.GROUP_ID,	A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT,	A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG, 'U' DB_ACTION  FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION                      B, CA_INTERVENTION_TYPE                    C WHERE	 A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  A.GOAL_CODE = '"+goalCode+"'   AND  B.INTERVENTION_CODE = A.INTERVENTION_CODE   AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE   AND  (	('"+alphalink+"' IS NOT NULL AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%'))    		OR ('"+alphalink+"' IS NULL 	AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z'	))ORDER BY INTERVENTION_DESC";
	  //sqlData="SELECT  A.INTERVENTION_TYPE,B.SHORT_DESC INTERVENTION_TYPE_DESC, INTERVENTION_CODE,A.SHORT_DESC INTERVENTION_DESC,     TO_CHAR(NULL) ACCURACY_INDICATOR, TO_NUMBER(NULL) SEQ_NO,TO_NUMBER(NULL) GROUP_ID,	TO_NUMBER(NULL) REL_START_PERIOD, TO_CHAR(NULL) REL_START_PERIOD_UNIT, TO_CHAR(NULL) FREQ_CODE,TO_NUMBER(NULL) FREQ_DURN, TO_CHAR(NULL) FREQ_DURN_UNIT,TO_NUMBER(NULL) DEPENDENCY_LEVEL,	TO_CHAR(NULL) ALT_INTERVENTION_CODE,TO_CHAR(NULL) STAGE_CODE,	DECODE(RESULT_ID,NULL,'I','O') INTVN_FLAG,'I' DB_ACTION  FROM  CA_INTERVENTION_LANG_VW A, CA_INTERVENTION_TYPE_LANG_VW B WHERE	( ('"+alphalink+"' IS NOT NULL 	AND UPPER(A.SHORT_DESC) LIKE UPPER('"+alphalink+"%')	)	OR 	('"+alphalink+"' IS NULL AND UPPER(SUBSTR(A.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z'))   AND  A.EFF_STATUS = 'E'   AND  INTERVENTION_CODE NOT IN (SELECT INTERVENTION_CODE FROM CP_LIBRARY_INTERVENTION  WHERE LIBRARY_ID = '"+libraryid+"' AND VERSION_NO = '"+versionno+"'  AND TERM_SET_ID = '"+termSet+"' AND TERM_CODE = '"+termCode+"'  AND GOAL_CODE = '"+goalCode+"')   AND B.INTERVENTION_TYPE = A.INTERVENTION_TYPE AND A.LANGUAGE_ID ='"+locale+"' AND B.LANGUAGE_ID = A.LANGUAGE_ID UNION ALL SELECT 	B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,	A.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,	A.SEQ_NO,A.GROUP_ID,	A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT,	A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG, 'U' DB_ACTION  FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION_LANG_VW B, CA_INTERVENTION_TYPE_LANG_VW C WHERE A.LIBRARY_ID = '"+libraryid+"'   AND  A.VERSION_NO = '"+versionno+"'   AND  A.TERM_SET_ID = '"+termSet+"'   AND  A.TERM_CODE = '"+termCode+"'   AND  A.GOAL_CODE = '"+goalCode+"'   AND  B.INTERVENTION_CODE = A.INTERVENTION_CODE    AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE    AND  (	('"+alphalink+"' IS NOT NULL  AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%'))        OR ('"+alphalink+"' IS NULL 	AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z'	)) AND B.LANGUAGE_ID = '"+locale+"' AND C.LANGUAGE_ID = B.LANGUAGE_ID ORDER BY INTERVENTION_DESC";//common-icn-0180
	  sqlData="SELECT  A.INTERVENTION_TYPE,B.SHORT_DESC INTERVENTION_TYPE_DESC, INTERVENTION_CODE,A.SHORT_DESC INTERVENTION_DESC,     TO_CHAR(NULL) ACCURACY_INDICATOR, TO_NUMBER(NULL) SEQ_NO,TO_NUMBER(NULL) GROUP_ID,	TO_NUMBER(NULL) REL_START_PERIOD, TO_CHAR(NULL) REL_START_PERIOD_UNIT, TO_CHAR(NULL) FREQ_CODE,TO_NUMBER(NULL) FREQ_DURN, TO_CHAR(NULL) FREQ_DURN_UNIT,TO_NUMBER(NULL) DEPENDENCY_LEVEL,	TO_CHAR(NULL) ALT_INTERVENTION_CODE,TO_CHAR(NULL) STAGE_CODE,	DECODE(RESULT_ID,NULL,'I','O') INTVN_FLAG,'I' DB_ACTION  FROM  CA_INTERVENTION_LANG_VW A, CA_INTERVENTION_TYPE_LANG_VW B WHERE	( ('"+alphalink+"' IS NOT NULL 	AND UPPER(A.SHORT_DESC) LIKE UPPER('"+alphalink+"%')	)	OR 	('"+alphalink+"' IS NULL AND UPPER(SUBSTR(A.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z'))   AND  A.EFF_STATUS = 'E'   AND  INTERVENTION_CODE NOT IN (SELECT INTERVENTION_CODE FROM CP_LIBRARY_INTERVENTION  WHERE LIBRARY_ID = ? AND VERSION_NO = ?  AND TERM_SET_ID = ? AND TERM_CODE = ?  AND GOAL_CODE = ?)   AND B.INTERVENTION_TYPE = A.INTERVENTION_TYPE AND A.LANGUAGE_ID = ? AND B.LANGUAGE_ID = A.LANGUAGE_ID UNION ALL SELECT 	B.INTERVENTION_TYPE,C.SHORT_DESC INTERVENTION_TYPE_DESC,	A.INTERVENTION_CODE,B.SHORT_DESC INTERVENTION_DESC,	A.ACCURACY_INDICATOR,	A.SEQ_NO,A.GROUP_ID,	A.REL_START_PERIOD,A.REL_START_PERIOD_UNIT,	A.FREQ_CODE,A.FREQ_DURN,A.FREQ_DURN_UNIT,	A.DEPENDENCY_LEVEL,A.ALT_INTERVENTION_CODE,	A.STAGE_CODE, DECODE(B.RESULT_ID,NULL,'I','O') INTVN_FLAG, 'U' DB_ACTION  FROM	CP_LIBRARY_INTERVENTION A, CA_INTERVENTION_LANG_VW B, CA_INTERVENTION_TYPE_LANG_VW C WHERE A.LIBRARY_ID = ?   AND  A.VERSION_NO = ?   AND  A.TERM_SET_ID = ?   AND  A.TERM_CODE = ?   AND  A.GOAL_CODE = ?   AND  B.INTERVENTION_CODE = A.INTERVENTION_CODE    AND  C.INTERVENTION_TYPE = B.INTERVENTION_TYPE    AND  (	('"+alphalink+"' IS NOT NULL  AND UPPER(B.SHORT_DESC) LIKE UPPER('"+alphalink+"%'))        OR ('"+alphalink+"' IS NULL 	AND UPPER(SUBSTR(B.SHORT_DESC,1,1)) NOT BETWEEN 'A' AND 'Z'	)) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID ORDER BY INTERVENTION_DESC";//common-icn-0180

}
try{
	connection	=	ConnectionManager.getConnection(request);
	pstmt		= connection.prepareStatement( sqlIntvnFrequency);
	//stmt1		=	connection.createStatement();//common-icn-0180
	pstmt1      = connection.prepareStatement(sqlDurationType);//common-icn-0180
	//rs1			=	stmt1.executeQuery(sqlFrequency);
	//if(rs1!=null){
	//	while(rs1.next()){
	//		frequencyList.add(rs1.getString("FREQ_CODE"));
	//		frequencyList.add(rs1.getString("FREQ_DESC"));

	//	}
	//}
	//rs1.close();
	pstmt1.setString(1, locale);//common-icn-0180
	//rs1=stmt1.executeQuery(sqlDurationType);//common-icn-0180
	rs1=pstmt1.executeQuery();//common-icn-0180
	if(rs1!=null){
		while(rs1.next()){
			DurationList.add(rs1.getString("DURN_TYPE"));
			DurationList.add(rs1.getString("DURN_DESC"));

		}
	}
	rs1.close();
	pstmt2      = connection.prepareStatement(sqlStage);//common-icn-0180
	pstmt2.setString(1, locale);//common-icn-0180
	//rs1=stmt1.executeQuery(sqlStage);//common-icn-0180
	rs1=pstmt2.executeQuery();//common-icn-0180
	if(rs1!=null){
		while(rs1.next()){
			StageList.add(rs1.getString("STAGE_CODE"));
			StageList.add(rs1.getString("SHORT_DESC"));

		}
	}
	rs1.close();
	//common-icn-0180 starts
	//stmt=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	int pstmtcount =1;//common-icn-0180
	//pstmt3      = connection.prepareStatement(sqlData);//common-icn-0180
	
	if(!sqlData.equals("")){
	pstmt3      = connection.prepareStatement(sqlData,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);//common-icn-0180
	//common-icn-0180 starts
	if(alphalink.equals("Associated") && !GroupID1.equals("0")){
	pstmt3.setString(pstmtcount++, locale);//common-icn-0180
	}
	else if(!GroupID1.equals("0") || !alphalink.equals("Associated")){
		pstmt3.setString(pstmtcount++, libraryid);
		pstmt3.setString(pstmtcount++, versionno);
		pstmt3.setString(pstmtcount++, termSet);
		pstmt3.setString(pstmtcount++, termCode);
		pstmt3.setString(pstmtcount++, goalCode);
		pstmt3.setString(pstmtcount++, locale);
		pstmt3.setString(pstmtcount++, libraryid);
		pstmt3.setString(pstmtcount++, versionno);
		pstmt3.setString(pstmtcount++, termSet);
		pstmt3.setString(pstmtcount++, termCode);
		pstmt3.setString(pstmtcount++, goalCode);
		pstmt3.setString(pstmtcount++, locale);
	}
	if(!sqlData.equals("")){
	//rs=stmt.executeQuery(sqlData);//common-icn-0180
	rs=pstmt3.executeQuery();
	//common-icn-0180 ends
	if(rs!=null){
		rs.last();
		maxRecord = rs.getRow();
		rs.beforeFirst();	
		if(maxRecord>0){
				

            _bw.write(_wl_block9Bytes, _wl_block9);

		if (!(start<=1))
		{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		
		if ( !( (start+5) >= maxRecord ) )
		{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

		}

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

	
if (start != 0){
	for(int j=1; j<=start; i++,j++){
		rs.next() ;
	}
}
while(rs.next() && i<=end){	
			IntvnfreqList=new ArrayList();
			if((i%2) == 1)
				classValue = "QRYEVEN";
			else
				classValue ="QRYODD";
			
			interventionCode	=	rs.getString("INTERVENTION_CODE")==null?"":rs.getString("INTERVENTION_CODE");
			interventionDesc	=	rs.getString("INTERVENTION_DESC")==null?"":rs.getString("INTERVENTION_DESC");

			
//			rs1.close();
			//System.err.println("interventionDesc "+interventionDesc+" IntvnfreqList "+IntvnfreqList);
			//System.err.println("freqdurnunitload  "+freqdurnunitload);
			
			for(int j=0;j<TermCodeList.size();j=j+7){
				 tempTermSet	=	(String)TermCodeList.get(j);
				 tempTermCode	=	(String)TermCodeList.get(j+1);
				if(tempTermSet.equals(termSet) && tempTermCode.equals(termCode)){
					Goal			=	(ArrayList)TermCodeList.get(j+2);
					if(Goal.contains(goalCode)){
						int index				=	Goal.indexOf(goalCode);
						 interventionOutcome	=	(HashMap)Goal.get(index+3);
						 Intervention			=	(ArrayList)interventionOutcome.get("I");
						 //System.err.println("Intervention  "+Intervention);
						  if(Intervention.size()>0){
							 if(Intervention.contains(interventionCode)){
								int index1			=	Intervention.indexOf(interventionCode);
								GrpID				=	(String)Intervention.get(index1+1);
								if(!GrpID.equals(""))
									GrpID1				=	Integer.parseInt(GrpID);
								//System.err.println("INTERVENTION_CODE  "+interventionCode);
								//System.err.println("sqlDATA  "+GrpID1);
								Alt					=	(String)Intervention.get(index1+2);
								relativeStart		=	(String)Intervention.get(index1+3);
								relativeStartType	=	(String)Intervention.get(index1+4);
								frequency			=	(String)Intervention.get(index1+5)==null?"":(String)Intervention.get(index1+5);
								Duration			=	(String)Intervention.get(index1+6);
								DurationType		=	(String)Intervention.get(index1+7);
								//freqdurnunitload	=	(String)Intervention.get(index1+7);
								dependency			=	(String)Intervention.get(index1+8);
								dep					=	Integer.parseInt(dependency);
								stage				=	(String)Intervention.get(index1+9);
								status				=	(String)Intervention.get(index1+10);

								if(Alt==null)
									Alt="";

								if(relativeStart.equals("0"))
									relativeStart="";
								
								if(Duration.equals("0"))
									Duration="";
								
								if(status.equals("Y"))
									checkAttribute="checked";
								else
									checkAttribute="";
							 }
						 }
					}
				}
			}
					
			pstmt.setString(1,interventionCode);
			pstmt.setString(2,locale);//common-icn-0180
			rs1=pstmt.executeQuery();
			if(rs1!=null){
				while(rs1.next()){
					tempfreq=rs1.getString("FREQ_CODE");
					IntvnfreqList.add(tempfreq);
					IntvnfreqList.add(rs1.getString("FREQ_DESC"));
					freq_default_yn=rs1.getString("DEFAULT_YN");
					IntvnfreqList.add(freq_default_yn);					
					freqdurnunit=rs1.getString("FREQ_DURNUNIT")==null?"":rs1.getString("FREQ_DURNUNIT");				
					IntvnfreqList.add(freqdurnunit);					
					if(freqdurnunitload.equals(""))
						freqdurnunitload=freqdurnunit;					
					if(!freqdurnunitload.equals("") && freq_default_yn.equals("Y"))
							freqdurnunitload=freqdurnunit;
					if(tempfreq.equals(frequency)){
							freqdurnunitload=freqdurnunit;
					}

				}

			}			
			rs1.close();
			if(!alphalink.equals("Associated")){
				if(GroupID>0 && GroupID==GrpID1){
					disabled	=	"Disabled";
					readonly	=	"readonly";
				}
				else{
					disabled	=	"";
					readonly	=	"";
				
				}
			}
			
			if(IntvnfreqList.size() > 0){
				//System.err.println("*********************************************************************");
				//System.err.println("condition in intvn "+(GrpID.equals("") ||(GroupID>0 && GroupID==GrpID1)));
			//	System.err.println("GrpID in intvn "+GrpID);

			if(GrpID.equals("") ||(GroupID>0 && GroupID==GrpID1)){
			
	
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(interventionTypeDesc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(interventionDesc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(i));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(interventionDesc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(Alt));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(maxGrpID));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(relativeStart));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(maxGrpID));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(maxGrpID));
            _bw.write(_wl_block41Bytes, _wl_block41);
for(int k=0;k<DurationList.size();k=k+2){
					tempRelativeStartType=(String)DurationList.get(k);
					if(relativeStartType.equals(tempRelativeStartType))
						relativeStartSelect="selected";
					else
						relativeStartSelect="";

			
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(relativeStartSelect));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(DurationList.get(k)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(DurationList.get(k+1)));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(maxGrpID));
            _bw.write(_wl_block50Bytes, _wl_block50);
			
						//System.err.println("interventionCode "+interventionCode+" frequency "+frequency);

						for(int k=0;k<IntvnfreqList.size();k=k+4){
							tempFrequency=(String)IntvnfreqList.get(k);
							tempfreq=(String)IntvnfreqList.get(k+2);
							freqdurnunit=(String)IntvnfreqList.get(k+3);
							if(frequency.equals("")||frequency==null){
								//System.err.println("E fre");
								if(tempfreq.equals("Y"))
									frequencySelect="selected";
								else
									frequencySelect="";
							}else{
								//System.err.println("fre");
								//System.err.println("tempFrequency "+tempFrequency);
								//System.err.println("frequency "+frequency);
								if(tempFrequency.equals(frequency))
									frequencySelect="selected";
								else
									frequencySelect="";
								
							}
							freqoptname=interventionCode+','+IntvnfreqList.get(k)+','+freqdurnunit;

				
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(frequencySelect));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(freqoptname));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(IntvnfreqList.get(k+1)));
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(Duration));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(maxGrpID));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(maxGrpID));
            _bw.write(_wl_block41Bytes, _wl_block41);
/*for(int k=0;k<DurationList.size();k=k+2){
					tempDurationType=(String)DurationList.get(k);
					if(tempDurationType.equals(DurationType))
						DurationSelect="selected";
					else
						DurationSelect="";*/
			
            _bw.write(_wl_block57Bytes, _wl_block57);
//}
			ch_durn_unit=freqdurnunitload.charAt(0);
			if(DurationType.equals("M"))
				MDurationSelect="selected";
			else if(DurationType.equals("H"))
				HDurationSelect="selected";
			else if(DurationType.equals("D"))
				DDurationSelect="selected";
			else if(DurationType.equals("W"))
				WDurationSelect="selected";
			else if(DurationType.equals("L"))
				LDurationSelect="selected";	
			//System.err.println("ch_durn_unit "+ch_durn_unit);
				switch(ch_durn_unit){
					case 'M' :

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(MDurationSelect));
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
			
					case 'H':

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(HDurationSelect));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

					case 'D':

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(DDurationSelect));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);

					case 'W':

            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(WDurationSelect));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

					case 'L':

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(LDurationSelect));
            _bw.write(_wl_block66Bytes, _wl_block66);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

							break;
					default:

            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

							}
			
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(maxGrpID));
            _bw.write(_wl_block41Bytes, _wl_block41);
for(int j=1;j<=9;j++){
				if(dep==j)
					dependencySelect="selected";
				else
					dependencySelect="";
			
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(dependencySelect));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(j));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(maxGrpID));
            _bw.write(_wl_block79Bytes, _wl_block79);
for(int k=0;k<StageList.size();k=k+2){
						tempStage=(String)StageList.get(k);
							if(tempStage.equals(stage))
								stageSelect="selected";
							else
								stageSelect="";
					
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(stageSelect));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(StageList.get(k)));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(StageList.get(k+1)));
            _bw.write(_wl_block81Bytes, _wl_block81);
}
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(checkAttribute));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(interventionCode));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(maxGrpID));
            _bw.write(_wl_block87Bytes, _wl_block87);

	}
}

	i++;
		disabled			=	"";
		GrpID				=	"";
		GrpID1				=	0;
		Alt					=	"";
		checkAttribute		=	"";
		relativeStart		=	"";
		relativeStartType	=	"";
		frequency			=	"";
		Duration			=	"";
		DurationType		=	"";
		dependency			=	"";
		stage				=	"";
		status				=	"";
		dep					=	0;
		IntvnfreqList		=	null;
		interventionCode	=	"";
		freqdurnunitload	=	"";
		ch_durn_unit		=	' ';
		MDurationSelect			=	"";
		HDurationSelect			=	"";
		WDurationSelect			=	"";
		LDurationSelect			=	"";
		DDurationSelect			=	"";

//System.err.println("AGain");
}

            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(start));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(end));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(alphalink));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(termSet));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(termCode));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(goalCode));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(libraryid));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(versionno));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(maxGrpID));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(GroupID));
            _bw.write(_wl_block98Bytes, _wl_block98);
	
		}else{

            _bw.write(_wl_block99Bytes, _wl_block99);

}
	}
}
}
catch(Exception e){
	System.err.println(e.toString());
		e.printStackTrace();
}finally{
	try
	{
	if(rs!=null)
		rs.close();
	if(rs1!=null)
		rs1.close();
	if(stmt!=null)
		stmt.close();
	if(stmt1!=null)
		stmt1.close();
	if(pstmt!=null)
		pstmt.close();
	//common-icn-0180 starts
	if(pstmt1!=null)
		pstmt1.close();
	if(pstmt2!=null)
		pstmt2.close();
	if(pstmt3!=null)
		pstmt3.close();
	//common-icn-0180 ends
	ConnectionManager.returnConnection(connection,request);
	}
	catch(Exception e)
	{
		//out.println(e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

}

            _bw.write(_wl_block100Bytes, _wl_block100);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.InterventionDescription.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Alt.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.RelativeStart.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Dep.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stage.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minutes.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Weeks.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Months.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute(s).label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.days.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Weeks.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Months.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
