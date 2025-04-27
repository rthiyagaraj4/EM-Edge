package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __header_45_17811 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/header-17811.jsp", 1738424980487L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<head>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\n<script type=\'text/javascript\' src=\"../../eCommon/js/DateUtils.js\"></script>\n<script type=\'text/javascript\' src=\"../../eCommon/js/AlertUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/logout.js\"></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n<script>\n/*Added By Dharma on 11th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start*/\n/*For ALT+F4*/\n\twindow.onbeforeunload = function (e) {\n\t\te = e || window.event;\n\t\t\tif(e.altKey && e.keyCode==0){\n\t\t\tfnLogout(\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\");\n\t\t}\n\t}\n/*Added By Dharma on 11th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End*/\n</script>\n</head>\n\n<body class=\"HEADER\" OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<table width=\"100%\" border=\"0\" cellpadding=0 cellspacing=0>\n<tr>\n<td width=\'100%\' align=\"left\" class=\"HEADERTITLE\">\n&nbsp;<font size=\"2\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" <label class=\"version\">(Version ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =") </label></font>\n</td>\n</tr>\n</table>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n \n <table width=\"100%\" cellpadding=0 cellspacing=0>\n\t\n<tr class=\"HEADER\">\n    <td class=\"HEADER\" align=\"center\" width=\"5%\" id=\'headerImageID\'>\n\t\t<img src=\"../../eCommon/jsp/DisplayImages.jsp?param=clientlogo\" width=\"40\" height=\"40\">\n    </td>\n\n    <td class=\"HEADER\" align=\"left\" width=\"42%\">\n    <b><font size=\"-1\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<BR>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n    </font></b>\n    </td>\n\n    <td class=\"HEADER\" align=\"left\" width=\"23%\">\n    <b><font size=\"-1\">\n    ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n    ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t</font>\n    </b>\n    </td>\n\n    <td class=\"HEADER\" align=\"left\" width=\"20%\" nowrap>\n    <font size=\"-1\">\n    <b>\n\n    <!-- added date/time -->\n    <div id=\"datetime\" style=\"font-size: 80%; text-align: center; padding: 2px\" value=\"\">\n\t\n\t</div>\n    <!-- end- added date/time -->\n\n    ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n    </b>\n    </font>\n    </td>\n    \n    ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t    <td class=\"HEADER\" align = \"left\" widht=\"5%\" nowrap>\n\t\t    ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t    </td>\n    ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \n\n    <td class=\"HEADER\" align=\"center\" width=\"5%\" >\n        <img src=\"../images/CSC.png\" alt=\"CSC\" height=\"26px\" width=\"46px\">\n    </td>\n\t<tr></tr>\n</tr>\n</table> \n<div id=\"desktopheader\" >\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t\t\t\t\n\t\t\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \n</div>\n</body>\n\n<script>\n\n\tfunction displaydatetime(){\n\t\tdocument.getElementById(\"datetime\").innerHTML = getCurrentDate(\"DMYHM\",\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\");\t\n\t\t\n\t\t\n\t}\n\n\twindow.setInterval(\"displaydatetime()\", \"60000\");\n\tdisplaydatetime();\n\t\n</script>\n\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String responsibility_id=(String) session.getValue( "responsibility_id" ) ;		
	String desktop_code="" ;
	desktop_code=(String) session.getValue( responsibility_id ) ;
	request.setCharacterEncoding("UTF-8");	
    String jdbc_user =  "";
	String jdbc_user_id="";
	String display_user_name_yn="";	
	String facility_id = (String) session.getValue( "facility_id" ) ;
	String p_user_name= (String) session.getValue( "login_user" ) ;	
	String locale = (String) session.getValue( "LOCALE" ) ;
    String called_from_ca_yn =request.getParameter( "called_from_ca_yn" ) ;
    String desktop_summary_type =request.getParameter( "desktop_summary_type" ) ;
	if (desktop_summary_type==null) desktop_summary_type="";
	PreparedStatement pstmt=null;
	String facility_name = "" ;
	
	if (called_from_ca_yn==null) called_from_ca_yn="N";

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			Connection con=ConnectionManager.getConnection();
			String sql = "SELECT SITE_NAME,DISPLAY_USER_NAME_YN FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and 'Y' = (SELECT DISPLAY_SITE_NAME_YN FROM SM_FACILITY_PARAM WHERE FACILITY_ID = ?)";
			pstmt =  con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			ResultSet rset=null;
			 rset = pstmt.executeQuery() ;//Changed  for PE By Sudhakar

			String site = "" ;
			if(rset !=null)	{
				if(rset.next()) {
					site = rset.getString("SITE_NAME");
					display_user_name_yn= rset.getString("DISPLAY_USER_NAME_YN");//Changed  for PE By Sudhakar
				}
			}
			if(rset !=null) rset.close();
			if(pstmt !=null) pstmt.close();
			if(rset !=null) rset.close();
			pstmt=con.prepareStatement( "SELECT (SELECT FACILITY_NAME FROM SM_FACILITY_PARAM_LANG_VW WHERE LANGUAGE_ID = ? and facility_id=?)FACILITY_NAME,APPL_USER_NAME,APPL_USER_ID FROM SM_APPL_USER_LANG_VW WHERE LANGUAGE_ID = ? and APPL_USER_ID=?" );
			pstmt.setString(1,locale);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,locale);
			pstmt.setString(4,p_user_name);
			rset = pstmt.executeQuery();
			
			if(rset !=null)	{
				if(rset.next()) {
					jdbc_user = rset.getString("APPL_USER_NAME");
					jdbc_user_id = rset.getString("APPL_USER_ID");
					facility_name = rset.getString("FACILITY_NAME");
				}
			}
			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			
			/*Prasanna*/
			/**
			* Code to check if the alerts icon is to be displayed or not.
			*/
			String masterConfigCode = "";
			String masterConfigValue = "";
			String strSql = "SELECT MASTER_CONFIG_CODE, MASTER_CONFIG_VALUE FROM UA_ALERT_MASTER_CONFIG WHERE MASTER_CONFIG_CODE = 'USEALERT'";
			pstmt = con.prepareStatement(strSql);
			rset = pstmt.executeQuery();
			
			if(rset != null){
				if(rset.next()){
					masterConfigCode = rset.getString("MASTER_CONFIG_CODE");
					masterConfigValue = rset.getString("MASTER_CONFIG_VALUE");
				}
			}
			if(masterConfigValue == "")
				masterConfigValue = "N";
			if(rset!=null)rset.close();
			if(pstmt!=null)pstmt.close();
			/*Prasanna*/
			
			ConnectionManager.returnConnection(con);
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(p_user_name));
            _bw.write(_wl_block8Bytes, _wl_block8);
 if (!called_from_ca_yn.equals("Y")) { 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( session.getAttribute("product_description") ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf( session.getAttribute("version_no") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( facility_name ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(site));
            _bw.write(_wl_block14Bytes, _wl_block14);
if(display_user_name_yn.equals("Y")){ 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( jdbc_user ));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( jdbc_user_id ));
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

    
            _bw.write(_wl_block18Bytes, _wl_block18);
if(masterConfigCode.equalsIgnoreCase("USEALERT") && masterConfigValue.equalsIgnoreCase("Y")){ 
            _bw.write(_wl_block19Bytes, _wl_block19);
            {java.lang.String __page ="AlertHeader.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block20Bytes, _wl_block20);
 }
            _bw.write(_wl_block21Bytes, _wl_block21);

	if(desktop_code!=null && desktop_summary_type.equals("N")) {


            _bw.write(_wl_block22Bytes, _wl_block22);
            {java.lang.String __page ="../../eCommon/jsp/UserDeskTopTitle.jsp";
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page, true );
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding), true );
            }_bw.write(_wl_block23Bytes, _wl_block23);

	}

            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block25Bytes, _wl_block25);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
