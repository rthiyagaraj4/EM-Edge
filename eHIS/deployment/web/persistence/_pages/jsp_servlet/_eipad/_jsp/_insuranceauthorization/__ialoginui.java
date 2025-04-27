package jsp_servlet._eipad._jsp._insuranceauthorization;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;

public final class __ialoginui extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/InsuranceAuthorization/IALoginUI.jsp", 1738426400706L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<!DOCTYPE html >\n<html >\n<head>\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n\t<!-- <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  -->\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t<script src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/js/IALoginUI.js\"></script> \n\t<!--    -->\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/mLogin.css\" /> \n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/css/mCommon.css\" />\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/css/iPADThemeA.css\" /> \n\t<title>eHIS Mobile Login</title>\n\t\n\t<script type=\"text/javascript\">\n\tvar contextPath = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tdocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\t\n\tfunction popOpen(id){\n\t\t$(\"#\"+id).show();\n\t\t$(\"#dvMez\").show();\n\t\t$(\"#dvMez\").data(\"popid\",id);\n\t}\n\tfunction popClose(){\n\t\t$(\"#dvMez\").hide();\n\t\tvar popid = $(\"#dvMez\").data(\"popid\");\n\t\t$(\"#\"+popid).hide();\n\t\t$(\"#dvMez\").data(\"popid\",\"\");\n\t}\n\tfunction popIdClose(id){\n\t\t$(\"#dvMez\").hide();\n\t\t$(\"#\"+id).hide();\n\t\t$(\"#dvMez\").data(\"popid\",\"\");\n\t} \n\t</script>\n</head>\n\n\n<body class=\"mbody\">\n\t<div id=\"dvMez\" class=\"blurPopup\" date-popid=\"\" onclick=\"popClose()\"></div>\n<!-- login html starts -->\n\t<form id=\'login_form\' name=\'login_form\' id=\'login_form\' method=\"post\" action=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/ialogin\" class=\"mform\">\n\t\t<div class=\"login_bg_layout bg1-theme\" >\n   \t\t\t<div class=\"login_header_area\">\n       \t\t\t<div class=\"login_header_corner bgRight-theme\"></div>\n       \t\t</div>\n       \n       \t\t<div class=\"login_middle_area\">\n\t        \t<div class=\"login_middle_area_center bgMiddle-theme\">\n\t            \t<div class=\"login_layout loginFldsLayout-theme\">\n\t                \t<div class=\"login_header_title bg3-theme\">\n\t                    \t<div class=\"login_header_left bgHeaderLeft-theme\"  ></div>                \n\t                    \t<div class=\"login_header_right bgHeaderRight-theme\"></div>\n\t                    </div>\n                   \n\t                    <div class=\"login_black_title\">\n\t                \t\t<div class=\"login_black_left bgDropLeft-theme\"></div>                \n\t                    \t<div class=\"login_black_right bgDropRight-theme\"></div>\n\t                    </div>\n                    \n                  \t\t<div class=\"login_table_login bgLoginTable-theme\">  \n\t                    \t<div class=\"login_logo\"> \n\t\t                    \t<div style=\"display:table;width:100%;height:100%\">\n\t\t                    \t\t<div style=\"display:table-row;\">\n\t\t                    \t\t\t<div style=\"display:table-cell;width:80px;vertical-align:middle;text-align:left\">\n\t\t                    \t\t\t\t<img src=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eCommon/jsp/DisplayImages.jsp?param=clientlogo\" width=\"56\" height=\"54\" id=\'headerImageID\' valign=\"middle\">\n\t\t                    \t\t\t</div>\n\t\t                    \t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align:center\">\n\t\t                    \t\t\t\t<div class=\"widgetHeaderHeadingTextTheme\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div>\n\t\t                    \t\t\t</div>\n\t\t                    \t\t</div>\n\t\t                    \t</div>\n\t                    \t</div>\n\t                    \t\n\t                \t\t<div class=\"login_uname normText1-theme\">Username</div>\n\t                 \n\t\t\t                <div class=\"login_uname_textbox normText1-theme\">\n\t\t                    \t<input class=\"login_textbox txtBox1-theme\" id=\'name\' name=\'name\' id=\'name\' type=\"text\"/>\n\t\t                    </div>\n\t                  \n\t                \t\t<div class=\"login_pwd\"></div>\n\t                    \n\t                    \t<div class=\"login_pwd normText1-theme\" >Password</div>\n\t                 \n\t\t                \t<div class=\"login_pwd_textbox normText1-theme\">\n\t\t                    \t<input class=\"login_textbox txtBox1-theme\" type=\'password\' id=\'password\' name=\'password\' id=\'password\' />\n\t\t                    </div>\n\t                    \n\t                    \t<div class=\"login_pwd\"></div>\n\t                    \n\t\t                    <div class=\"login_login_butto\">\n\t\t                    \t<input type=\"submit\" value=\"Login\" class=\"login_classname btn1-theme\" data-inline=\"true\" onclick=\"submit_user_pwd()\" />\n\t\t                    </div>\n\n                    \t</div>\n                \t</div>\n\t\t\t\t</div>\n        \t</div>\n        \n        \t<div class=\"login_footer_area\">\n        \t\t<div class=\"login_footer_area_corner bgLeft-theme\"  >\n            \t<div class=\"login_footer_text footerText-theme\" onclick=\"popOpen(\'CopyrightPop\')\">&copy; ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" <span class=\"login_footer_text_image\"> <img src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/eIPAD/images/CSC.png\"/> </span></div></div>\n        \t</div>\n        \t<div style=\"\" class=\"copyrightPop copyrightPopTheme\" id=\"CopyrightPop\">\n        \t\t<div class=\"copyrightCloseTheme\" onclick=\"popIdClose(\'CopyrightPop\')\">x</div>\n        \t\t<div class=\"copyrightTextHeadTheme copyrightHead\" style=\"\">Copyright & License notice:</div>\n        \t\t<div class=\"copyrightTextTheme copyrightText\">&copy; ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</div>\n        \t\t<div class=\"copyrightTextTheme copyrightText\">Use of this product is subject to the Enterprise Management license agreement.</div>\n        \t\t<div class=\"copyrightWarnTheme copyrightText\"><span class=\"copyrightWarnHeadTheme\">Warning: </span>This computer program is protected by copyright law and international treaties. Unauthorized reproduction or distribution of this program, or any portion of it, may result in severe civil and criminal penalties, and will be prosecuted to the maximum extent possible under the law.</div>\n        \t\t<div class=\"copyrightTextHeadTheme copyrightHead\">Trademark notice:</div>\n        \t\t<div class=\"copyrightTextTheme copyrightText\">&copy; CSC, the CSC logo, Enterprise Management, and csc.com are trademarks or registered trademarks of Computer Sciences Corporation, registered in the United States and other jurisdictions worldwide. Other product and service names might be trademarks of CSC or other companies.</div>\n    \t\t</div>\n    \t\n    \t\n    \t</div>\n    \t\n\t    <!-- login html ends -->\n\t    \n\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"begin\"/> \n\t\t<input type=\"hidden\" name=\"responsibility_id\" id=\"responsibility_id\" id=\"responsibility_id\" value=\"\"/>\n\t\t<input type=\"hidden\" name=\"responsibility_name\" id=\"responsibility_name\" id=\"responsibility_name\" value=\"\"/> \n\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" id=\"facility_id\" value=\"\"/> \n\t\t<input type=\"hidden\" name=\"login_user\" id=\"login_user\" id=\"login_user\" value=\"null\"/>\n\t\t<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\" id=\"facility_name\" value=\"\"/> \n\t\t<input type=\"hidden\" name=\"level\" id=\"level\" id=\"level\" value=\"1\"/> \n\t\t<input type=\"hidden\" name=\"clientIP\" id=\"clientIP\" id=\"clientIP\" value=\"\"/> \n\t\t<input type=\"hidden\" name=\"user\" id=\"user\" id=\"user\" value=\"\"/> \n\t\t<input type=\"hidden\" name=\"compname\" id=\"compname\" value=\"IPAD\" id=\"compname\"/> \n\t\t<input type=\"hidden\" name=\"domain\" id=\"domain\" id=\"domain\" value=\"\"/> \n\t\t<input type=\"hidden\" name=\"error_num\" id=\"error_num\" id=\"error_num\" value=\"0\"/> \n\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"en\"/>\n\t\t<input type=\"hidden\" name=\"RespFaciList\" id=\"RespFaciList\" id=\"RespFaciList\" value=\"en\"/>\n\t</form>\n</body>\n</html>\n    \n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
 

String path = request.getContextPath(); 

String locale = (String)session.getValue("LOCALE");
locale = (locale == null || locale.equals(""))?"en":locale;
Connection con =null ;
con = ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;
String product_name="";
String product_description="";
String version_info="";
String copyright_info="";
String site_name="";
try{
	String inst_info="select a.PRODUCT_NAME PRODUCT_NAME,a.PRODUCT_DESCRIPTION PRODUCT_DESCRIPTION,a.VERSION_NO VERSION_NO,a.COPYRIGHT_INFO COPYRIGHT_INFO,b.SITE_NAME  SITE_NAME from sm_installation a,SM_SITE_PARAM_LANG_VW b where b.language_id='"+locale+"'";
	if(pstmt!=null)
		pstmt.close();
	pstmt=con.prepareStatement(inst_info) ;
	if(rs!=null)rs=null;
	rs=pstmt.executeQuery() ;
	if(rs!=null && rs.next()){
		product_name=rs.getString("PRODUCT_NAME");
		product_description=rs.getString("PRODUCT_DESCRIPTION");
		version_info=rs.getString("VERSION_NO");
		copyright_info=rs.getString("COPYRIGHT_INFO");
		site_name=rs.getString("SITE_NAME");
		}
	if(version_info==null || version_info.equals(""))
		version_info="";
	if(copyright_info==null || copyright_info.equals(""))
		copyright_info="";
	session.setAttribute("version_no",version_info);
	session.setAttribute("product_description",product_description);
	
}catch(Exception ex){
	ex.printStackTrace();
}finally{
	if(rs!=null)
		rs.close();
	if(pstmt!=null)
		pstmt.close();
	if(con!=null)
		con.close();
}





            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(path));
            _bw.write(_wl_block5Bytes, _wl_block5);
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
            out.print( String.valueOf(site_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(copyright_info ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(path));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(copyright_info ));
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
