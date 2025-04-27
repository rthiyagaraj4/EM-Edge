package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCA.CAOpenChartServlet;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __camaintoolbar extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAMainToolbar.jsp", 1709115558199L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n <head>\t\n    ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\n<script src=\'../js/CAMenu.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCA/js/CAMainMenu.js\' language=\'javascript\'></script>\n<script src=\'../../eCA/js/CAMainMenuLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\n</head>\n<body class=\"COMMON_TOOLBAR\" leftmargin=0 topmargin=0 onKeyDown=\"lockKey()\">\n\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n</body>\n<script>\n\tvar tableVal = \"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tparent.CommonToolbar.displayIcons(tableVal);\n\t//top.frames[1].frames[0].displayIcons(tableVal);\n</script>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String strSql					=	"";
	String practitioner_id	= (String) session.getValue("ca_practitioner_id"); 
	String queryString = request.getQueryString()== null?"":request.getQueryString() ;
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String option_id	= "";
	String short_desc	= "";
	String icon_file_name= "";
	String executable_name= "";
	
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	Connection con = null;
	
	StringBuffer icons = new StringBuffer("");

            _bw.write(_wl_block8Bytes, _wl_block8);

	try
	{
		con = ConnectionManager.getConnection(request);

		icons.append("<table width='100%' border=0 align=center cellpadding=0 cellspacing=0><tr>");

		if(!patient_id.equals(""))
		{
			strSql = "select a.OPTION_ID,a.SHORT_DESC,a.ICON_FILE_NAME,a.EXECUTABLE_NAME from ca_option a, ca_custom_option b where a.option_id = b.option_id and b.practitioner_id = ? and a.DESKTOP_YN <> 'Y' and a.ICON_FILE_NAME is not null";
		}
		else
		{
			strSql = "select a.OPTION_ID,a.SHORT_DESC,a.ICON_FILE_NAME,a.EXECUTABLE_NAME from ca_option a, ca_custom_option b where a.option_id = b.option_id and b.practitioner_id = ? and a.DESKTOP_YN = 'Y' and a.ICON_FILE_NAME is not null";
		}
					
						
		pstmt = con.prepareStatement(strSql);
		pstmt.setString(1,practitioner_id);
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			option_id = rs.getString("OPTION_ID")==null?"":rs.getString("OPTION_ID");
			short_desc = rs.getString("SHORT_DESC")==null?"":rs.getString("SHORT_DESC");
			icon_file_name = rs.getString("ICON_FILE_NAME")==null?"":rs.getString("ICON_FILE_NAME");
			executable_name = rs.getString("EXECUTABLE_NAME")==null?"":rs.getString("EXECUTABLE_NAME");
			if(executable_name.indexOf("?") != -1)
			{
				executable_name=executable_name + "&option_id="+option_id+"&"+queryString;
			}
			else
			{
				executable_name=executable_name+"?"+"option_id="+option_id+"&"+queryString;
			}
			
			icons.append("<td><img src='../../eCA/images/"+icon_file_name+"' id='"+option_id+"' onclick=callFunction('"+short_desc+"','"+executable_name+"')  alt='"+short_desc+"' width='32' height='30'></img></td>");
			icons.append("<td><img id='divider' src='../../eCA/images/MI_Divider.jpg' alt='Divider'></img></td>");
		}
		icons.append("</tr></table>");			

		if(rs!=null) rs.close();
		if (pstmt != null) pstmt.close();
	} 
	catch (Exception e) 
	{
		//out.println("CAMainTitle: "+e);//COMMON-ICN-0181
                   e.printStackTrace();//COMMON-ICN-0181
	}
	 finally 
	{
		
		if(con != null) ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(icons.toString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
