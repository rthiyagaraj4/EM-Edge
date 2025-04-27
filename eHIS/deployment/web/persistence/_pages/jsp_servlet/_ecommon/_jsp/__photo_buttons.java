package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __photo_buttons extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/photo_buttons.jsp", 1709116510154L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../html/IeStyle.css\'></link>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script language=\"JavaScript\">\n\t\tvar process = \"\";\n\t\t\tfunction captureButton_click(){\n\t\t\t   process=\"webcam\";\n\t\t\t   if (document.getElementById(\"UI\").checked == true){\n\t\t\t\t\tparent.frames[0].location.href = \"photo_capture_webcam.jsp?";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="&showUI=true\";\n\t\t\t\t}else{\n\t\t\t\t\tparent.frames[0].location.href = \"photo_capture_webcam.jsp?";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="&showUI=false\";\n\t\t\t\t}\n\t\t\t}\n\t\t\tfunction scanButton_click(){\n\t\t\t\tprocess=\"scanner\";\n\t\t\t\tif (document.getElementById(\"UI\").checked == true){\n\t\t\t\t\tparent.frames[0].location.href = \"photo_capture_scanner.jsp?";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&showUI=true\";\n\t\t\t\t}else{\n\t\t\t\t\tparent.frames[0].location.href = \"photo_capture_scanner.jsp?";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&showUI=false\";\n\t\t\t\t}\t\n\t\t\t}\n\t\t\tfunction storeButton_click(){\n\t\t\t\tvar file = \"ftp://\" + document.location.hostname + \"/pat_photo/\" + document.getElementById(\"saveFile\").value ;\n\t\t\t\tif (process == \"scanner\"){\n\t\t\t\t\tparent.frames[0].document.getElementById(\"Xpress1\").SaveFileType = 8;\n\t\t\t\t\tparent.frames[0].document.getElementById(\"Xpress1\").SaveFileName = file;\n\t\t\t\t\tparent.frames[0].document.getElementById(\"Xpress1\").SaveFile();\n\t\t\t\t\tparent.frames[0].document.getElementById(\"oldPhoto\").src = document.getElementById(\"httpPath\").value + document.getElementById(\"saveFile\").value ;\n\t\t\t\t\tsetTimeout(\"RefreshPage()\",2000);\t\n\t\t\t\t}else if (process == \"webcam\"){\n\t\t\t\t\tparent.frames[0].document.getElementById(\"capturePro\").preview=false;\n\t\t\t\t\tparent.frames[0].document.getElementById(\"capturePro\").frameFile = file;\n\t\t\t\t\tparent.frames[0].document.getElementById(\"capturePro\").captureFrame();\n\t\t\t\t\tparent.frames[0].document.getElementById(\"oldPhoto\").src = document.getElementById(\"httpPath\").value + document.getElementById(\"saveFile\").value;\n\t\t\t\t}\n\t\t\t}\n\t\t\tfunction RefreshPage(){\n\t\t\t\tparent.frames[0].RefreshPage();\n\t\t\t}\n\t\t\tfunction closeButton_click(){\n\t\t\t\tif (process == \"scanner\"){\n\t\t\t\t\tparent.frames[0].document.getElementById(\"TwainPRO1\").CloseSession();\t\t\t\t\t\n\t\t\t\t}else if (process == \"webcam\"){\n\t\t\t\t\tparent.frames[0].document.getElementById(\"capturePro\").disconnect() ;\t\t\t\n\t\t\t\t}\t\t\t\t\n\t\t\t\tdocument.parentWindow.close();\n\t\t\t}\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onKeyDown = \'lockKey()\'>\n\t\t<table align=center width=\'100%\' border=0 cellpadding=0 cellspacing=0>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' align=center>\n\t\t\t\tShow UI &nbsp;&nbsp;<input type=\"checkbox\" name=\"UI\" id=\"UI\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'label\' align=center>\n\t\t\t\t<input class=\"button\" type=\"button\" value=\"Capture\" \t\t\t\tname=\"captureButton\" id=\"captureButton\" \t\tonClick=\"captureButton_click()\">\n\t\t\t\t<input class=\"button\" type=\"button\" value=\"Scan\" \t\t\t\tname=\"scanButton\" id=\"scanButton\" \t\tonClick=\"scanButton_click()\">\n\t\t\t\t<input class=\"button\" type=\"button\" value=\"Store\" \t\t\t\tname=\"storeButton\" id=\"storeButton\" \t\tonClick=\"storeButton_click()\">\n\t\t\t\t<input class=\"button\" type=\"button\" value=\"Close\" \t\t\t\tname=\"closeButton\" id=\"closeButton\" \t\tonClick=\"closeButton_click()\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<input name=\'oldPhoto\' id=\'oldPhoto\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t\t\t ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t  ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<input name=\'saveFile\' id=\'saveFile\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t\t<input name=\'httpPath\' id=\'httpPath\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t</body>\n</html>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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

			request.setCharacterEncoding("UTF-8");	

	String params = request.getQueryString();
	
	String file = request.getParameter( "file" ) ;
	String path = "" ;
	String httpPath = "" ;
	String oldFile = "" ;
	String oldFileExists = "0" ;

	Connection con=ConnectionManager.getConnection(request);
	PreparedStatement pstmt = con.prepareStatement( "select pat_photo_os_path, pat_photo_http_path from sm_db_info" ) ;
	ResultSet rs = pstmt.executeQuery() ;

	if ( rs != null && rs.next() ) {
		path = rs.getString( "pat_photo_os_path" );
		httpPath = rs.getString( "pat_photo_http_path" ) ;
	}

	oldFile = path + file ;

	try {
		File f = new File( oldFile ) ;
		if ( f.exists() )
			oldFileExists = "1" ;
	} catch ( Exception e ) {}


            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(params));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(params));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(params));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(params));
            _bw.write(_wl_block6Bytes, _wl_block6);

			if ( oldFileExists.equals( "1" ) ){
			 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(httpPath+file));
            _bw.write(_wl_block8Bytes, _wl_block8);
	 				
			}else{
			  
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(httpPath+"blank.jpg"));
            _bw.write(_wl_block9Bytes, _wl_block9);
			
			}				
		
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(file));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(httpPath));
            _bw.write(_wl_block12Bytes, _wl_block12);

	rs.close();
	pstmt.close();
	ConnectionManager.returnConnection(con,request);

            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
