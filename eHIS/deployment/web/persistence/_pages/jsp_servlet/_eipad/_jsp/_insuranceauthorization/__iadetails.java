package jsp_servlet._eipad._jsp._insuranceauthorization;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __iadetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/InsuranceAuthorization/IADetails.jsp", 1738426386986L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE html> \n<html> \n<head> \n\t<title>Insurance Authorization Form</title>   \n\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/jquery.mobile-1.0.1.min.css\" />\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/kendo.common.min.css\" />\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/css/kendo.default.min.css\" />\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t<script src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/kendo.web.min.js\"></script>\n\t<script src=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eIPAD/console.js\"></script>\n\t\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/css/iPADThemeA.css\" />\n\t<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eIPAD/js/GenericSlider.js\"></script>\n\t<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eCommon/js/common.js\"></script>\n\t<script src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/js/IALoginUI.js\"></script>\n\t<script src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/css/mLogin.css\" /> \n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/eIPAD/css/mCommon.css\" /> \n\t<script>\n\t\tvar contextPath = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\tvar totalItemsCount = \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\tdocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\t\tvar myScroll;\n\t\tfunction logout() {\n\t\t\tvar xmlhttp;\n\t\t\tif (window.XMLHttpRequest) {\n\t\t\txmlhttp = new XMLHttpRequest();\n\t\t\t} else {// code for IE6, IE5\n\t\t\t\txmlhttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t\t\t}\n\t\t\txmlhttp.onreadystatechange = function() {\n\t\t\t\tif (xmlhttp.readyState == 4 && xmlhttp.status == 200) {\n\t\t\t\t\twindow.location = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/ialogin\";\n\t\t\t\t}\n\t\t\t}\n\t\txmlhttp.open(\"POST\", contextPath+\"/eIPAD/jsp/Logoff.jsp\", true);\n\t\txmlhttp.send();\n\t\t}\n\t\n\t\t$(document).ready(function(){\n        \t$(\"#encounterId\").kendoComboBox({\n        \t\tdataTextField: \"encounterId\",\n  \t\t\t\tdataValueField: \"encounterId\"\n        \t});\n    \t});\n\t</script>\n\t<style>\n\t.CNButtonContainer {\nmargin-right: 10px;\ndisplay: table;\nwidth: 42px;\ncursor:pointer;\n}\n\t</style>\n</head>\n<body>\n\t<div id=\"divParent\" class=\"mdivParent\" data-role=\"page\">\n\t  \t<form id=\'formClaimFormsCriteria\' name=\'formClaimFormsCriteria\' id=\'formClaimFormsCriteria\'>\n\t\t\t<div id=\"divTable\" class = \"mdivTable\" data-role = \"none\">\n\t\t \t\t<div data-role = \"none\" class = \"mheaderRow\"><!-- header starts -->\n\t\t\t\t\t<table class=\"mheader grd1-theme\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t        \t<tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t\t<td style = \"width:90%;height:100%\" align = \"left\" ><span class=\"mheaderText headerText1-theme\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" - ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</span></td>\n\t\t\t\t\t\t\t<td style = \"width:10%;height:100%\" valign = \"center\" align = \"right\" onclick = \"logout()\">\n\t\t\t\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="/eIPAD/images/Logout1.png\" class=\"mHeaderImgLogout\" ></img>\n\t\t\t\t\t\t\t</td>\n\t\t\t        \t</tr>\n\t\t       \t\t</table>\n\t\t   \t\t</div><!-- div first row header ends  -->\n\t\t   \t\t<div class=\"bg1-theme\" style=\"display:table-row;height:10%;\">\n\t\t\t\t\t<div style=\"display:table;width:100%;height:auto;\">\n\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t<div style=\"display:table-row;width:100%;height:auto;\">\n\t\t\t  \t\t\t\t<div style=\"display: table-cell;width:40%;height:auto;\">\n            \t\t\t\t\t<div style=\"display:table;width:100%;height:auto;\">\n\t\t\t  \t\t\t\t\t\t<div style=\"display:table-row;width:100%;height:auto;\">\n               \t\t\t\t\t\t\t<div class=\"iaLoginRowFonts\" id=\"labelPat\" style=\"display:table-cell;width:30%;height:auto;vertical-align: middle;\">\n\t\t\t  \t\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t  \t\t\t\t\t\t\t\t<img src=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="/eCommon/images/mandatory.gif\">\n\t\t\t   \t\t\t\t\t\t\t</div>\n\t\t\t     \t\t\t\t\t\t<div id=\"textPat_Label\"  style=\"display:table-cell;width:60%;height:auto;vertical-align: middle;\">\n                    \t\t\t\t\t\t<input type=\"text\" id=\"Patient_Id\" name=\"Patient_Id\" id=\"Patient_Id\" maxlength=\'20\' size=20\' class=\"k-textbox\" value=\'\' style=\"text-transform: uppercase;background-color: #eff4f8;\" onkeyup=\"resetFrame()\"/>\n\t\t\t   \t\t\t\t\t\t\t</div>\n\t\t\t   \t\t\t\t\t\t\t<div id=\"arrPat_Label\"  style=\"display:table-cell;width:10%;height:auto;vertical-align: middle;\" class=\"CNButtonItemTheme\">\n\t\t\t   \t\t\t\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eIPAD/images/Right.png\" onclick=\"populateEncounter()\">\n\t\t\t   \t\t\t\t\t\t\t</div>\n\t\t\t  \t\t\t\t\t\t</div>\n\t\t\t  \t\t\t\t\t</div>\n\t\t\t  \t\t\t\t</div>\n\t\t\t  \t\t\t\t<div style=\"display: table-cell;width:50%;height:10%;vertical-align: middle;\">\n\t\t\t    \t\t\t\t<div style=\"display:table;width:100%;height:10%;vertical-align: middle;\">\n\t\t\t    \t\t\t\t\t<div style=\"display:table-row;width:100%;height:auto;\">\n\t\t\t    \t\t\t\t\t\t<div class=\"iaLoginRowFonts\" id=\"lableEnc\" style=\"display:table-cell;vertical-align: middle;width:30%;height:auto;\">\n\t\t\t    \t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t    \t\t\t\t\t\t</div>\n\t\t\t    \t\t\t\t\t\t<div id=\"spinEnc\"  style=\"display:table-cell;width:70%;height:auto;\">\n\t\t\t    \t\t\t\t\t\t \t<select style=\"width:90%;\" name=\"encounterId\" id=\"encounterId\" id=\"encounterId\" data-mandatory=\"true\" placeholder=\"--Select--\">\n\t\t\t\t\t\t\t\t\t\t\t</select> \n\t\t\t    \t\t\t\t\t\t</div>\n\t\t\t    \t\t\t\t\t</div>\n\t\t\t  \t\t\t\t\t</div>\n\t\t\t  \t\t\t\t</div>\n\t\t\t  \t\t\t\t<div style=\"display: table-cell;width:10%;height:auto;\">\n\t\t\t\t\t\t\t\t<input type=\"button\" class=\"k-button\" name=\"Search\" id=\"Search\" VALUE=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' onclick=\"getResultForTab()\" />\n\t\t\t  \t\t\t\t</div>\n\t\t\t  \t\t\t</div>\n\t\t\t \t\t</div>\n\t\t\t\t</div>\n\t\t\t\t<div data-role = \"none\" class=\"bg1-theme\" style=\"height:100%;\">\n\t\t\t\t\t<div  id=\"searchresultframe\"></div>\n\t\t\t\t\t<div  id=\"iaform\"  style=\"height:100%;width:100%\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div data-role = \"none\" class = \"mfooter\" ><!-- Footer start  -->\n\t\t\t\t\t<div class = \"mfooterContent border3Top-theme grd3-theme iaLoginRowFonts\" data-role = \"none\" id=\"errorframe\"></div>    \n\t\t   \t\t</div><!-- div footerends here -->\n\t\t\t</div> <!-- div table ends here -->\n\t  \t</form>\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

String product_description = "";
String version_no = "";
String path = request.getContextPath();
ArrayList<String> RespIdArrayList = new ArrayList<String>();
ArrayList<String> RespNameArrayList = new ArrayList<String>();
ArrayList<String> FacilityIdArrayList = new ArrayList<String>();
ArrayList<String> FacilityNameArrayList = new ArrayList<String>();
int RespCount = 0;
int FacilityCount = 0;
if(request.getAttribute("LoginRespIdArray") != null) {
	RespIdArrayList = (ArrayList<String>)request.getAttribute("LoginRespIdArray");
}
if(request.getAttribute("LoginRespNameArray") != null) {
	RespNameArrayList = (ArrayList<String>)request.getAttribute("LoginRespNameArray");
}
if(request.getAttribute("LoginFacilityIdArray") != null) {
	FacilityIdArrayList = (ArrayList<String>)request.getAttribute("LoginFacilityIdArray");
}
if(request.getAttribute("LoginFacilityNameArray") != null) {
	FacilityNameArrayList = (ArrayList<String>)request.getAttribute("LoginFacilityNameArray");
}
if(request.getAttribute("LoginRespCount") != null) {
	RespCount = (Integer)request.getAttribute("LoginRespCount");
}
if(request.getAttribute("LoginFacilityCount") != null) {
	FacilityCount = (Integer)request.getAttribute("LoginFacilityCount");
}
if(session.getAttribute("version_no") != null) {
	version_no = (String)session.getAttribute("version_no");
}
if(session.getAttribute("product_description") != null) {
	product_description = (String)session.getAttribute("product_description");
}

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(path));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(path));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(path));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(path));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(path));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(path));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(path));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(path));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(path));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(path));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(path));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(path));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(path));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(path));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(RespNameArrayList.size()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(path));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(product_description));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(path));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(path));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(path));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PatientID.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
}
