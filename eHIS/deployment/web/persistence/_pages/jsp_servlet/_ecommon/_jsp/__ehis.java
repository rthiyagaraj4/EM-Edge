package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __ehis extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/eHIS.jsp", 1738424961426L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/BundleInclude.jsp", 1709116471650L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<title>eHospital Information System</title>\n    <script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n    <script Language=\"JavaScript\" src=\"../../eCommon/js/logout.js\"></script>\n    <script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script language=\"JavaScript\">\n   fullScreen() ;\n\n    function fullScreen() {\n        window.resizeTo( screen.availWidth, screen.availHeight ) ;\n        window.moveTo( 0,0 ) ;\n    }\n\n\tfunction resizing() {\n\t\talert(obj.name)\n\t}\n\n/*Added By Dharma on 11th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] Start*/\n/*For ALT+F4*/\n\tdocument.onkeydown = windowRefreshOrClose;\n\tdocument.onkeypress = windowRefreshOrClose\n\tdocument.onkeyup = windowRefreshOrClose;\n\tvar wasPressed = false;\n\n\tfunction windowRefreshOrClose(e){\n\t\te = e || window.event;\n\t    if( wasPressed ) return; \n\t\tif (e.keyCode == 116) {\n\t\t\twasPressed = true;\n\t\t}else {\n\t\t\tif(e.altKey && e.keyCode==115){\n\t\t\t\tfnLogout(\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\");\n\t\t\t}\n\t\t}\n\t }\n\t\n\t//window.onbeforeunload = function (e) {\n\t//\twindowRefreshOrClose();\n\t//}\n\t\n\twindow.onbeforeunload = function () {\n\t\tfnLogout(\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\");\n    \t}\n\n  \n\t\t\t\n\t\t\t\n\t/*Added By Dharma on 11th Nov 2017 against PMG2017-COMN-CRF-0009 [IN:065613] End*/\n\n\n</script>\n\n</head>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<FRAMESET ROWS=\"12%,*\" frameborder=\"5\" FRAMESPACING=0 noresize>\n\t\t<FRAME id=\"header\"  SRC=\"header.jsp\" id=\"header\" NAME=\"header\" SCROLLING=NO noresize>\t\t\n\t\t<frameset cols=\"200px,*\" frameborder=\"0\"  id=\"contentFrameset\" name=\"contentFrameset\" BORDERCOLOR=\"red\" >\n\t\t\t<frame id=\"menucontent\"  src=\"FloatMenu.jsp\" name=\"menucontent\" scrolling=\"NO\" marginwidth=1 BORDERCOLOR=\"red\" />\n\t\t\t<frame id=\"content\" name=\"content\" src=\"maindisplay.jsp\" scrolling=\"no\" marginwidth=1 BORDERCOLOR=\"red\" noresize/>\n\t\t</frameset>\n\t\t</FRAMESET>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t <FRAMESET ROWS=\"7.0%,*\" frameborder=\"5\" FRAMESPACING=0 noresize>\n\t\t           <FRAME SRC=\"header.jsp?desktop_summary_type=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" id=\"header\" NAME=\"header\" SCROLLING=NO noresize>\t\t\n\t\t\t\t\t<frameset frameborder=0 framespacing=0 rows=\"0%,*,0%\" scrolling=\'auto\' id=\'workArea\'   >\n\t\t\t\t\t\t<frame id=\'plineFrame\'  name=\'plineFrame\'  frameborder=\"no\" src=\'../../eCommon/html/blank.html\'  scrolling=\'no\' noresize></frame>\n\t\t\t\t\t\t<frame id=\'content\'  name=\'content\' src=\'../../eCA/jsp/CAMain.jsp\' frameborder=0  marginheight=0 marginwidth=0 SCROLLING=\'yes\' frameborder=0 noresize>\n\t\t\t\t\t\t<frame id=\'blankFrameForCharts\'  name=\'blankFrameForCharts\' src=\'../../eCommon/html/blank.html\'>\n\t\t\t\t\t</frameset>\n\t\t\t\t </frameset>\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<FRAMESET ROWS=\"11.5%,*\" frameborder=\"5\" FRAMESPACING=0 noresize id=\"headerFrameset\"  name=\'headerFrameset\'>\n\t\t\t\t\t<FRAME SRC=\"header.jsp?desktop_summary_type=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" id=\"header\" NAME=\"header\" SCROLLING=NO noresize>\t\n\t\t\t\t\t<frameset cols=\"200px,*\" frameborder=\"0\"  id=\"contentFrameset\" name=\"contentFrameset\" BORDERCOLOR=\"red\" scrolling=\'no\' noresize>\n\t\t\t\t\t\t<frame src=\'../../eCommon/jsp/UserDesktop.jsp?desktop_summary_area=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' id=\"menucontent\" name=\"menucontent\" marginwidth=1 BORDERCOLOR=\"red\" scrolling=\'no\' noresize />\n\t\t\t\t\t\t<frame id=\"content\" id=\"content\" name=\"content\" src=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' marginwidth=1 BORDERCOLOR=\"red\" scrolling=\'no\' noresize />\n\t\t\t\t\t</frameset>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<FRAMESET ROWS=\"12%,*\" frameborder=\"5\" FRAMESPACING=0 noresize>\n\t\t\t\t\t<FRAME SRC=\"header.jsp?desktop_summary_type=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" id=\"header\" NAME=\"header\" SCROLLING=NO noresize>\t\t\n\t\t\t\t\t<frameset cols=\"200px,*\" frameborder=\"0\"  id=\"contentFrameset\" name=\"contentFrameset\" BORDERCOLOR=\"red\" >\n\t\t\t\t\t<frame id=\"menucontent\"  src=\"FloatMenu.jsp\" name=\"menucontent\" scrolling=\"NO\" marginwidth=1 BORDERCOLOR=\"red\" />\n\t\t\t\t\t<frame id=\"content\"   name=\"content\" src=\"maindisplay.jsp\" scrolling=\"no\" marginwidth=1 BORDERCOLOR=\"red\" noresize/>\n\t\t\t\t\t</frameset>\n\t\t\t\t</FRAMESET>\n\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n</html>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");	

PreparedStatement pstmt = null;
Connection con = null;
ResultSet rs = null;
String executable            ="";
String responsibility_id=(String) session.getValue( "responsibility_id" ) ;
String desktop_code="" ;
desktop_code=(String) session.getValue( responsibility_id ) ;
String desktop_summary_type  ="";
String desktop_summary_area  ="";
String dflt_module_id        = "";
String dflt_function_id      = "";
String login_user 			= (String) session.getValue( "login_user" ) ;

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block10Bytes, _wl_block10);

try {
	if(desktop_code!=null ){

		con = ConnectionManager.getConnection(request);
		//String module_id             ="";
		//String function_id           ="";
		String function_name         ="";
		String executable_name       ="";
		String function_type         ="";
		//String menu_id               ="";
		String insert_access_yn      ="";
		String update_access_yn      ="";
		String query_only_access_yn  ="";
		String delete_access_yn      ="";
		String print_access_yn       ="";
		int count=0;

		
		String strsql1 = "SELECT DESKTOP_SUMMARY_TYPE, DESKTOP_SUMMARY_AREA, upper(DFLT_MODULE_ID) DFLT_MODULE_ID, upper(DFLT_FUNCTION_ID) DFLT_FUNCTION_ID FROM SM_DESKTOP_SUM_HDR WHERE DESKTOP_SUMMARY_ID = ?";

		pstmt = con.prepareStatement(strsql1);
		pstmt.setString(1,desktop_code);
		rs = pstmt.executeQuery();

        if(rs!=null && rs.next())
		{
			desktop_summary_type = rs.getString("DESKTOP_SUMMARY_TYPE");
			desktop_summary_area = rs.getString("DESKTOP_SUMMARY_AREA");
			dflt_module_id       = rs.getString("DFLT_MODULE_ID");
			dflt_function_id     = rs.getString("DFLT_FUNCTION_ID");
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		if (desktop_summary_type.equals("N"))
		{
			String strsql = "SELECT function_id,c.FUNCTION_NAME,c.FUNCTION_TYPE, c.EXECUTABLE_NAME, c.INSERT_ACCESS_YN, c.UPDATE_ACCESS_YN, c.DELETE_ACCESS_YN, c.PRINT_ACCESS_YN, c.QUERY_ONLY_ACCESS_YN FROM sm_resp a, sm_function c WHERE a.resp_id=? AND C.MODULE_ID = '" + dflt_module_id +"' AND C.FUNCTION_ID = '"+dflt_function_id +"' AND EXISTS ( select module_id,function_id from (select module_id,function_id,level lev from sm_menu_dtl connect by prior submenu_id=menu_id start with menu_id=(Select menu_id from sm_resp where resp_id=? )) where function_id is not null AND MODULE_ID = '" + dflt_module_id +"' AND FUNCTION_ID = '"+dflt_function_id +"'  )";
			pstmt = con.prepareStatement(strsql);
			pstmt.setString(1,responsibility_id);
			pstmt.setString(2,responsibility_id);
			rs = pstmt.executeQuery();

			if(rs!=null && rs.next())
			{
			
						//module_id = rs.getString("module_id");
						//function_id  = rs.getString("function_id");
						function_name ="User Home - " + rs.getString("FUNCTION_NAME");
						executable_name = rs.getString( "EXECUTABLE_NAME" ) ;
						function_type   = rs.getString("function_type");
						//menu_id          = rs.getString("MODULE_ID");
						insert_access_yn = rs.getString("insert_access_yn");
						update_access_yn = rs.getString("update_access_yn");
						query_only_access_yn = rs.getString("query_only_access_yn");
						delete_access_yn = rs.getString("delete_access_yn");
						print_access_yn = rs.getString("print_access_yn");
				
						executable  =  executable_name +"?module_id="   + dflt_module_id     +
							"&function_id=" + dflt_function_id   +
							"&function_name=" + function_name   +
							"&function_type="   + function_type +
							"&menu_id="+ dflt_module_id +
							"&access=" +    insert_access_yn    +
							update_access_yn    +
							query_only_access_yn +
							delete_access_yn    +
							print_access_yn     +"&expand=1";
						count++;
			}
			else{
				executable = "../../eCommon/html/blank.html";
			}

		}
		if((desktop_summary_type!=null && desktop_summary_type.equals("N"))){
			session.putValue("ca_user_desktop_yn","N");
		}else{
			session.putValue("ca_user_desktop_yn","Y");
		}
    	if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
	}

} catch (Exception e) {
	e.printStackTrace();
}
finally
		{
			try
			{
				
				if(con!= null) ConnectionManager.returnConnection(con,request);
			}
			catch(Exception e)
			{
				out.println("Exception in eHIS.jsp"+e.toString());
				e.printStackTrace();
			}
		}


	if(desktop_code==null){ 	
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{ 
            _bw.write(_wl_block12Bytes, _wl_block12);
 if (desktop_summary_type.equals("C")) { 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(desktop_summary_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
}else if (desktop_summary_type.equals("N")){  
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(desktop_summary_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(desktop_summary_area));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(executable));
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{ 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(desktop_summary_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
