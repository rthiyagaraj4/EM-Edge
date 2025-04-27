package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.util.*;

public final class __loginrfselect_45_newui extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/LoginRFSelect-newUI.jsp", 1738426111379L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n<!DOCTYPE html> \n<html> \n<head> \n\t<title>Login Responsibility Facility Select</title>   \n\t<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />   \n\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="/eIPAD/jquery.mobile-1.0a4.1.min.css\" />\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\t    \n\t<script src=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/js/loginIpad-newUI.js\"></script> \n\t<script type=\"application/javascript\" src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/js/iscroll.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/css/mLogin.css\" /> \n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/css/mCommon.css\" /> \n\t<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/css/iPADThemeA.css\" /> \n\t<script>\n\tvar contextPath = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tvar totalItemsCount = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\n\t\n\tdocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\tvar myScroll;\n\t \n\tfunction AssignRespScroller() {\n\t\tmyScroll = new iScroll(\'RespSelectWrapper\', {\n\t\t\tsnap: true,\n\t\t\tmomentum: false,\n\t\t\thScrollbar: false, \n\t\t\tonScrollEnd: function () {\n\t\t\t\tdocument.querySelector(\'#RespSelectIndicator > li.active\').className = \'\';\n\t\t\t\tdocument.querySelector(\'#RespSelectIndicator > li:nth-child(\' + (this.currPageX+1) + \')\').className = \'active\'; \n\t\t\t}\n\t\t });\n\t}\n\tdocument.addEventListener(\'DOMContentLoaded\', AssignRespScroller, false);\n\tfunction setPaginationDots(){\n\t\tvar itemWidth = $(\".loginRespSelectItemOuterBox\").width() + 12; //12px for margin+border\n\t\t//alert(\"itemWidth \"+itemWidth);\n\t\tvar wrapperWidth = $(\"#RespSelectWrapper\").width();\n\t\t//alert(\"wrapperWidth \"+wrapperWidth);\n\t\tvar itemHeight = $(\".loginRespSelectItemOuterBox\").height() + 12; //12px for margin+border\n\t\t//alert(\"itemHeight \"+itemHeight);\n\t\tvar wrapperHeight = $(\"#RespSelectWrapper\").height();\n\t\t//alert(\"wrapperHeight \"+wrapperHeight);\n\t\tvar eachPageContainsRows = Math.floor(wrapperWidth/itemWidth);\n\t\t//alert(\"eachPageContainsRows \"+eachPageContainsRows);\n\t\tvar eachPageContainsCols = Math.floor(wrapperHeight/itemHeight);\n\t\t//alert(\"eachPageContainsCols \"+eachPageContainsCols);\n\t\tvar eachPageContains = eachPageContainsRows * eachPageContainsCols;\n\t\t//alert(\"eachPageContains \"+eachPageContains);\n\t\tvar totalPages = Math.ceil(totalItemsCount/eachPageContains);\n\t\t//alert(\"totalPages \"+totalPages); \n\t\tvar scrollerWidth = wrapperWidth * totalPages;\n\t\t$(\"#RespSelectScroller\").css(\"width\",scrollerWidth+\"px\");\n\t\t$(\"#RespSelectIndicator\").empty();\n\t\tfor(var i=0;i<totalPages;i++){\n\t\t\t$(\"<li></li>\").appendTo(\"#RespSelectIndicator\");\n\t\t}\n\t\t$(\"#RespSelectIndicator li\").first().addClass(\"active\");\n\t\tmyScroll.scrollToPage(0, 0);\n\t} \n\t\n\n\n\t$(document).ready(function() {\n\t\tsetPaginationDots();\n\t\tif (window.DeviceOrientationEvent) {\n\t\t\twindow.addEventListener(\'orientationchange\',\n\t\t\t\t\tsetPaginationDots, false);\n\t\t}\n\t});\n\t\n\tfunction popOpen(id){\n\t\t$(\"#\"+id).show();\n\t\t$(\"#dvMez\").show();\n\t\t$(\"#dvMez\").data(\"popid\",id);\n\t}\n\tfunction popClose(){\n\t\t$(\"#dvMez\").hide();\n\t\tvar popid = $(\"#dvMez\").data(\"popid\");\n\t\t$(\"#\"+popid).hide();\n\t\t$(\"#dvMez\").data(\"popid\",\"\");\n\t}\n\tfunction popIdClose(id){\n\t\t$(\"#dvMez\").hide();\n\t\t$(\"#\"+id).hide();\n\t\t$(\"#dvMez\").data(\"popid\",\"\");\n\t} \n\n\t</script>\n\t\n<style>\n\n\n</style>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</head>\n\n<body>\n\t<div id=\"divParent\" class=\"mdivParent\" data-role=\"page\">\n\t<div id=\"dvMez\" class=\"blurPopup\" date-popid=\"\" onclick=\"popClose()\" data-role=\"none\"></div>\n\t<div style=\"\" class=\"copyrightPop copyrightPopTheme\" id=\"CopyrightPop\" data-role=\"none\">\n   \t\t<div class=\"copyrightCloseTheme\" onclick=\"popIdClose(\'CopyrightPop\')\" data-role=\"none\">x</div>\n   \t\t<div class=\"copyrightTextHeadTheme copyrightHead\" style=\"\" data-role=\"none\">Copyright & License notice:</div>\n   \t\t<div class=\"copyrightTextTheme copyrightText\" data-role=\"none\">&copy; ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</div>\n   \t\t<div class=\"copyrightTextTheme copyrightText\" data-role=\"none\">Use of this product is subject to the Enterprise Management license agreement.</div>\n   \t\t<div class=\"copyrightWarnTheme copyrightText\" data-role=\"none\"><span class=\"copyrightWarnHeadTheme\">Warning: </span>This computer program is protected by copyright law and international treaties. Unauthorized reproduction or distribution of this program, or any portion of it, may result in severe civil and criminal penalties, and will be prosecuted to the maximum extent possible under the law.</div>\n   \t\t<div class=\"copyrightTextHeadTheme copyrightHead\" data-role=\"none\">Trademark notice:</div>\n   \t\t<div class=\"copyrightTextTheme copyrightText\" data-role=\"none\">&copy; CSC, the CSC logo, Enterprise Management, and csc.com are trademarks or registered trademarks of Computer Sciences Corporation, registered in the United States and other jurisdictions worldwide. Other product and service names might be trademarks of CSC or other companies.</div>\n    </div>\n\t  <form id=\'login_form\' name=\'login_form\' id=\'login_form\' class=\"mform\" method=\"post\" action=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eIPAD/jsp/IPad.jsp\">\n\t\t<div id=\"divTable\" class = \"mdivTable\" data-role = \"none\">\n\t\t \t<div data-role = \"none\" class = \"mheaderRow\"><!-- header starts -->\n\t\t\t\t<table class=\"mheader grd1-theme\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t        <tr style = \"width:100%;height:100%\">\n\t\t\t\t\t\t<td style = \"width:90%;height:100%\" align = \"left\" ><span class=\"mheaderText headerText1-theme\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" - ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span></td>\n\t\t\t\t\t\t<td style = \"width:10%;height:100%\" valign = \"center\" align = \"right\" onclick = \"logout()\">\n\t\t\t\t\t\t\t<img src = \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eIPAD/images/Logout1.png\" class=\"mHeaderImgLogout\" ></img>\n\t\t\t\t\t\t</td>\n\t\t\t        </tr>\n\t\t       </table>\n\t\t   </div><!-- div first row header ends  -->\n\t\t   \t<div class=\"bg1-theme\" style=\"display:table-row\">\n\t\t\t\t<div class=\"loginRespSelectTxt headingText1-theme\">Choose Responsibility and Facility</div>\n\t\t\t</div>\n\n\n\t\t\t<div data-role = \"none\" class = \"loginRespRow2 bg1-theme\">\n\t\t   \t\t<div data-role=\"none\" style=\"display:table-cell;vertical-align:middle;text-align:center;\">\n\t\t\t\t\t<div id=\"RespSelectWrapper\" class=\"loginRespSelWrapper\">\n\t\t\t\t\t\t<div id=\"RespSelectScroller\" style=\"height:100%;\">\n\t\t\t\t\t\t\t<div class=\"loginRespSelectPage\">\n\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"loginRespSelectItemOuterBox border1-theme\" style=\"text-align: center;\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"loginFacilityBox grd2-theme border2-theme\" id=\"FacilityBox_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" style=\"display:none\"></div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"loginFaciImageBox grd2-theme border2-theme\" id=\"RespSelectImage_";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"loginRoleProfileIconImage\"><image src=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/eIPAD/images/RoleProfileIcon.png\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"loginRespSelectRespButton btn2-theme normText2-theme\" id=\"RespSelectRespButton_";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" onclick=\"change_resp(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\" data-role = \"none\"> \n\t\t\t\t\t\t\t\t\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;width:195px;height:52px\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"FacilityShowImage_";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"><image src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eIPAD/images/FacilityExpand.png\"/></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div style=\"display:table-row\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t   \t\t\t</div>\n\t\t\t   \t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\t\t   \n  \n\t\t\t<div class=\"loginRespSelectPageNav bg1-theme\">\n\t\t\t\t<div style=\"display:table-cell;vertical-align:middle;text-align: center;\" data-role=\"none\">\n\t\t\t\t\t<div style=\"display:inline-block\">\n\t\t\t\t\t\t<ul id=\"RespSelectIndicator\" class=\"loginRespSelectIndicator pagi1-theme\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<!-- <li class=\"active\"></li> -->\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</ul>\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t</div>\n\n\t\n\t\t\t<div data-role = \"none\" class = \"mfooter\" ><!-- Footer start  -->\n\t\t\t\t<div class = \"mfooterContent border3Top-theme grd3-theme\" data-role = \"none\">\n\t\t\t\t\t<table style = \"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t    \t<tr style = \"width:100%;height:100%\">\n\t\t\t\t        \t<td style = \"width:50%;height:100%\" valign = \"top\">\n\t\t\t\t         \t</td>\n\t\t\t\t         \t<td style = \"width:50%;height:100%\" align = \"right\" valign = \"top\" onclick=\"popOpen(\'CopyrightPop\')\">\n\t\t\t\t         \t\t<span class=\"mcopyrightsText cpyRightTxt-theme\" onclick=\"popOpen(\'CopyrightPop\')\">&copy; ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</span>\n\t\t\t\t        \t\t<img src=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="/eIPAD/images/CSC_Logo.png\" class=\"mimgCopyRights\"></img>\n\t\t\t\t         \t</td>\n\t\t\t\t      \t</tr>\n\t\t\t\t    </table>\n\t\t\t\t</div>    \n\t\t   \t</div><!-- div footerends here -->\n\t\t</div> <!-- div table ends here -->\n\t\t \t<input type=\"hidden\" name=\"RespCount\" id=\"RespCount\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\"/> \n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"begin\"/> \n\t\t\t<input type=\"hidden\" name=\"responsibility_id\" id=\"responsibility_id\" id=\"responsibility_id\" value=\"\"/>\n\t\t\t<input type=\"hidden\" name=\"responsibility_name\" id=\"responsibility_name\" id=\"responsibility_name\" value=\"\"/> \n\t\t\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" id=\"facility_id\" value=\"\"/> \n\t\t\t<input type=\"hidden\" name=\"login_user\" id=\"login_user\" id=\"login_user\" value=\"null\"/>\n\t\t\t<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\" id=\"facility_name\" value=\"\"/> \n\t\t\t<input type=\"hidden\" name=\"level\" id=\"level\" id=\"level\" value=\"\"/> \n\t\t\t<input type=\"hidden\" name=\"clientIP\" id=\"clientIP\" id=\"clientIP\" value=\"\"/> \n\t\t\t<input type=\"hidden\" name=\"user\" id=\"user\" id=\"user\" value=\"\"/> \n\t\t\t<input type=\"hidden\" name=\"compname\" id=\"compname\" value=\"IPAD\" id=\"compname\"/> \n\t\t\t<input type=\"hidden\" name=\"domain\" id=\"domain\" id=\"domain\" value=\"\"/> \n\t\t\t<input type=\"hidden\" name=\"error_num\" id=\"error_num\" id=\"error_num\" value=\"0\"/> \n\t\t\t<input type=\"hidden\" name=\"locale\" id=\"locale\" id=\"locale\" value=\"en\"/>\n\t  </form>\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

String product_description = "";
String version_no = "";
String path = request.getContextPath();
ArrayList<String> RespIdArrayList = new ArrayList<String>();
ArrayList<String> RespNameArrayList = new ArrayList<String>();
ArrayList<String> FacilityIdArrayList = new ArrayList<String>();
ArrayList<String> FacilityNameArrayList = new ArrayList<String>();
int RespCount = 0;
int FacilityCount = 0;



if(request.getAttribute("LoginRespIdArray") != null)
{
	RespIdArrayList = (ArrayList<String>)request.getAttribute("LoginRespIdArray");
}
if(request.getAttribute("LoginRespNameArray") != null)
{
	RespNameArrayList = (ArrayList<String>)request.getAttribute("LoginRespNameArray");
}
if(request.getAttribute("LoginFacilityIdArray") != null)
{
	FacilityIdArrayList = (ArrayList<String>)request.getAttribute("LoginFacilityIdArray");
}
if(request.getAttribute("LoginFacilityNameArray") != null)
{
	FacilityNameArrayList = (ArrayList<String>)request.getAttribute("LoginFacilityNameArray");
}
if(request.getAttribute("LoginRespCount") != null)
{
	RespCount = (Integer)request.getAttribute("LoginRespCount");
}
if(request.getAttribute("LoginFacilityCount") != null)
{
	FacilityCount = (Integer)request.getAttribute("LoginFacilityCount");
}
if(session.getAttribute("version_no") != null)
{
	version_no = (String)session.getAttribute("version_no");
}
if(session.getAttribute("product_description") != null)
{
	product_description = (String)session.getAttribute("product_description");
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);

String locale = (String)session.getValue("LOCALE");
locale = (locale == null || locale.equals(""))?"en":locale;
Connection con =null ;
con = ConnectionManager.getConnection(request);
PreparedStatement pstmt=null;
ResultSet rs=null;
String copyright_info="";
try{
	String inst_info="select a.COPYRIGHT_INFO COPYRIGHT_INFO from sm_installation a,SM_SITE_PARAM_LANG_VW b where b.language_id='"+locale+"'";
	if(pstmt!=null)
		pstmt.close();
	pstmt=con.prepareStatement(inst_info) ;
	if(rs!=null)rs=null;
	rs=pstmt.executeQuery() ;
	if(rs!=null && rs.next()){
		copyright_info=rs.getString("COPYRIGHT_INFO");
	}
	if(copyright_info==null || copyright_info.equals(""))
		copyright_info="";
	
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


            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(path));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(path));
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
            out.print( String.valueOf(RespNameArrayList.size()));
            _bw.write(_wl_block11Bytes, _wl_block11);
 
	int NUMBEROFROWS = 2;

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(copyright_info));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(path));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(product_description));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(path));
            _bw.write(_wl_block17Bytes, _wl_block17);
for(int i= 0; i<RespNameArrayList.size(); i=i+NUMBEROFROWS){ 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(RespIdArrayList.get(i)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(RespIdArrayList.get(i)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(path));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(RespIdArrayList.get(i)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(RespIdArrayList.get(i)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(RespNameArrayList.get(i)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( RespNameArrayList.get(i)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(RespIdArrayList.get(i)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(path));
            _bw.write(_wl_block27Bytes, _wl_block27);
} 
            _bw.write(_wl_block28Bytes, _wl_block28);
for(int i= 1; i<RespNameArrayList.size(); i=i+NUMBEROFROWS){ 
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(RespIdArrayList.get(i)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(RespIdArrayList.get(i)));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(path));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(RespIdArrayList.get(i)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(RespIdArrayList.get(i)));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(RespNameArrayList.get(i)));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( RespNameArrayList.get(i)));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(RespIdArrayList.get(i)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(path));
            _bw.write(_wl_block27Bytes, _wl_block27);
} 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(copyright_info));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(path));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(RespCount));
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
