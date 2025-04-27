package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIP.advbedmgmt.GBMConstants;
import eIP.advbedmgmt.transaction.cataskaccess.CATaskAccessConstants;

public final class __ipadvbedmgmttopcrumb extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPAdvBedMgmtTopCrumb.jsp", 1709117772130L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html>\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n<link type=\"text/css\" rel=\"stylesheet\" href=\"../../eIP/html/IPAdvBedMgmtStyle.css\"/>\n<Script src=\"../js/json2.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eIP/js/IPAdvBedMgmtSupplementary.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<style type=\"text/css\">\n#cornerdesignLeft {\n\tposition: relative;\n\twidth: 00px;\n\theight: 0px;\n\t/* margin-left:100px; */\n\t-ms-transform: rotate(-15deg);\n\t-moz-transform: rotate(-15deg);\n\t-o-transform: rotate(-15deg);\n\t-webkit-transform: rotate(-15deg);\n}\n\n/* #cornerdesignLeft:before {\n\tcontent: \"\";\n\tposition: absolute;\n\ttop: -30px;\n\tleft: -70px;\n\twidth: 40px;\n\theight: 40px;\n\tborder: 16px solid #407784;\n\tborder-left: 0px;\n\tborder-right: 0px;\n\tborder-top: 10px solid #407784;\n\t\n\tborder-radius: 0px 00px 0 50px;\n\t-moz-border-radius: 0px 00px 0 50px;\n\t\n\ttransform: rotate(-65deg);\n\t-ms-transform: rotate(-65deg);\n\t\n\tbackground-color: #407784;\n}\n\n#cornerdesignLeft:after {\n\tcontent: \"\";\n\tposition: absolute;\n\ttop: -5px;\n\tleft: 0px;\n\tright: 0px;\n\twidth: 35px;\n\theight: 30px;\n\t\n\tborder: 15px solid #407784;\n\tborder-bottom: 0px;\n\tborder-right: 0px;\n\tborder-top: 0px;\n}\n\n#cornerdesignLeft:after {\n\tleft: -30px;\n\tright: 0px;\n\tbottom: 0px;\n\t\n\t-moz-border-radius: 50px 00px 00px 0;\n\tborder-radius: 50px 00px 00px 0;\n\t\n\t-webkit-transform: rotate(50deg);\n\t-moz-transform: rotate(50deg);\n\t-ms-transform: rotate(50deg);\n\t-o-transform: rotate(50deg);\n\ttransform: rotate(50deg);\n} */\n\n.leftTabStyle{\n\t/* display:table-cell; */\n\theight:85%;\n\twidth:20%;\n\tvertical-align: middle;\n\tbackground-color:#3ca0b2;\n\t/* background-color:#aca072; */\n\tfloat: left;\n\tcolor:#FFFFFF;\n\tPADDING-LEFT:5px;\n\tfont-family:Arial;\n\tFONT-SIZE: 12px;\n\tFONT-WEIGHT: bold ;\n\t\n}\n\nA { \n\ttext-decoration: none;\n}\n\n/* A:link { \n\tCOLOR: #e2e2e2; \n}\n\nA:visited { \n\tCOLOR: #e2e2e2; \n} \nA:active { \n\tCOLOR: #e2e2e2; \n}\n\nA.MENUSUBLEVELLINK\n{\n\tCOLOR: #e2e2e2;\n}\nA.MENUHIGHERLEVELLINK\n{\n\tCOLOR: #e2e2e2;\n}\n */\n</style>\n\n\n</head>\n<body style=\'background-color:#e2e2e2;\'>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n \n \n <!-- <div id=\"wrapper\" style=\'width:100%;height:24px;display:table;margin-bottom:2px;margin-top:2px;background-color:#ffffff;border-bottom:1px solid #000000;\'> \n \t<div id=\"header\" style=\'display: table-row; height:100%;width:20%;\'>\n \t\t<div style=\'display:inline-block;height:100%;width:10%;background-color:#3ca0b2;\'></div>\n \t\t<div id=\"cornerleft\" style=\'display:table-cell;height:100%;width:100%;vertical-align: middle;background-color:#3ca0b2;float: left;color:#FFFFFF;PADDING-LEFT:5px;font-family:arial;FONT-SIZE: 12px;FONT-WEIGHT: bold ;\'>Bed View</div>\n \t\t<div id=\"cornerleft\" class=\"leftTabStyle\">Bed View</div>\n \t</div>\n </div> -->\n \n <table cellspacing=0 cellpadding=0 align=\'left\' v-align=\'bottom\' width=\'100%\' height=\'30px\' style=\'margin-left:2px; margin-bottom:2px;margin-top:2px;background-color:#e2e2e2;border-bottom:1px solid #000000;\'>\n \t<tr>\n \t\t<td class=\"leftTabStyle\">Bed View</td>\n \t\t<td style=\'width:80%;\'></td>\n \t\t<td style=\'width:20%;float:right;height:100%;vertical-align: middle;padding-right:10px;\'>\n \t\t\t<table cellspacing=0 cellpadding=0 align=\'left\' width=\'100%\' height=\'30px\'>\n \t\t\t\t<tr>\n \t\t\t\t<td style=\'cursor:pointer;\'>\n \t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n \t\t\t\t<img src=\'../images/MI_ManageSpecimen.png\' alt=\'Manage Spec\' title=\'Manage Specimens\' onclick=\"showManageSpecimen(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\',\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\')\" ></img>\n \t\t\t\t</td>\n \t\t\t\t</tr>\n \t\t\t</table>\n \t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n \t\t\t\n \t\t\t\n \t\t\t<!-- <a class=\'imageClass1\' onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\'> -->\n \t\t\t<!-- <a> -->\n \t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n \t\t\t\n \t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n \t\t\t\n \t\t\t<!-- </a> -->\n \t\t</td>\n \t</tr>\n </table>\n \n\n</body>\n\n\n</html>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

// facilityId
String facilityId		= (String)session.getAttribute("facility_id");



            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(CATaskAccessConstants.FACILITYID_REQUEST_KEY));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(GBMConstants.IP_MODULE_IDENTIFIER));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(CATaskAccessConstants.RESPONSIBILITY_ID_REQUEST_KEY));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(CATaskAccessConstants.MANAGE_SPECIMEN_TASK_KEYWORD));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(CATaskAccessConstants.TASK_ID_REQUEST_KEY));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
