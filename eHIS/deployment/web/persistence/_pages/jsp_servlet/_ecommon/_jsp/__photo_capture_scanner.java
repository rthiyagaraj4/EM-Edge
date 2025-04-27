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

public final class __photo_capture_scanner extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/photo_capture_scanner.jsp", 1709116510498L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<head>\n\n\t<title>Capture Scan</title>\n\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../html/IeStyle.css\'></link>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n\t<script language=\"JavaScript\">\n\t\tfunction connectButton_click() {\n\t\t\t//TwainPRO1.SelectSource();\n\t\t\tif (document.getElementById(\"showUI\").value == \'true\')TwainPRO1.ShowUI=\'True\';\n\t\t\telse TwainPRO1.ShowUI=\'False\';\n\t\t\tTwainPRO1.StartSession();\n\t\t\tXpress1.BorderType = 2;\n\t\t\tXpress1.ScrollBars = 3;\n\t\t\tXpress1.hDib = TwainPRO1.hDib;\n\t\t\tXpress1.PICResize(160,180);\n\t\t}\n\n\t\tfunction captureButton_click() {\n\t\t\tvar file = \"ftp://\" + document.location.hostname + \"/pat_photo/\" + capture_form.file.value ;\n\t\t\tvar oldFileExists = capture_form.oldFileExists.value ;\n\t\t\tXpress1.SaveFileName = file ;\n\t\t\tXpress1.SaveFile();\n\t\t\tsetTimeout(\"RefreshPage()\",1500);\t\t\t\n\t\t}\n\n\t\tfunction RefreshPage(){\n\t\t\tvar httpPath = document.getElementById(\"httpPath\").value ;\n\t\t\tdocument.getElementById(\"oldPhoto\").src = httpPath + document.getElementById(\"file\").value ;\n\t\t\tdocument.location.reload(true);\n\t\t}\n\n\t\tfunction disconnectButton_click() {\n\t\t\twindow.close() ;\n\t\t}\n\t</script>\n</head>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<body  onKeyDown = \'lockKey()\' onLoad=\"connectButton_click()\">\n\t<table width=\'100%\' height=\'100%\' align=center cellspacing=0 cellpadding=0>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<object classid=\"clsid:7B0207CE-7FF6-11D4-A13A-004005FA6275 VIEWASTEXT\" id=\"Xpress1\" width=\"192\" height=\"192\" align=\"middle\">\n\t\t\t\t\t<PARAM NAME=\"_ExtentX\" VALUE=\"5080\">\n\t\t\t\t\t<PARAM NAME=\"_ExtentY\" VALUE=\"5080\">\t\t\t\t\t\n\t\t\t\t\t<PARAM NAME=\"ErrStr\" VALUE=\"7V0000M0000-X0306MPXET\">\n\t\t\t\t\t<PARAM NAME=\"ErrCode\" VALUE=\"57566898\">\n\t\t\t\t\t<PARAM NAME=\"ErrInfo\" VALUE=\"1704862304\">\n\t\t\t\t\t<PARAM NAME=\"Persistence\" VALUE=\"7980\">\n\t\t\t\t\t<PARAM NAME=\"_cx\" VALUE=\"1952671082\">\n\t\t\t\t\t<PARAM NAME=\"_cy\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"Font\" VALUE=\"MS Sans Serif\">\n\t\t\t\t\t<PARAM NAME=\"BackColor\" VALUE=\"2147483663\">\n\t\t\t\t\t<PARAM NAME=\"ScrollBarLargeChangeH\" VALUE=\"10\">\n\t\t\t\t\t<PARAM NAME=\"ScrollBarSmallChangeH\" VALUE=\"1\">\n\t\t\t\t\t<PARAM NAME=\"OLEDropMode\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"ScrollBarLargeChangeV\" VALUE=\"10\">\n\t\t\t\t\t<PARAM NAME=\"ScrollBarSmallChangeV\" VALUE=\"1\">\n\t\t\t\t\t<PARAM NAME=\"DisplayProgressive\" VALUE=\"-1\">\n\t\t\t\t\t<PARAM NAME=\"SaveTIFByteOrder\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"LoadRotated\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"FTPUserName\" VALUE=\"\">\n\t\t\t\t\t<PARAM NAME=\"FTPPassword\" VALUE=\"\">\n\t\t\t\t\t<PARAM NAME=\"ProxyServer\" VALUE=\"\">\n\t\t\t\t</object>\n\t\t\t\t<OBJECT id=TwainPRO1 classid=\"clsid:12B127F7-CC36-4A39-A334-AA39689155CE VIEWASTEXT\">\n\t\t\t\t\t<PARAM NAME=\"ErrStr\" VALUE=\"7V0000M0000-X0306MPXET\">\n\t\t\t\t\t<PARAM NAME=\"ErrCode\" VALUE=\"57566898\">\n\t\t\t\t\t<PARAM NAME=\"ErrInfo\" VALUE=\"1704862304\">\n\t\t\t\t\t<PARAM NAME=\"_cx\" VALUE=\"847\">\n\t\t\t\t\t<PARAM NAME=\"_cy\" VALUE=\"847\">\n\t\t\t\t\t<PARAM NAME=\"Caption\" VALUE=\"\">\n\t\t\t\t\t<PARAM NAME=\"ForeColor\" VALUE=\"1163087439\">\n\t\t\t\t\t<PARAM NAME=\"Font\" VALUE=\"MS Sans Serif\">\n\t\t\t\t\t<PARAM NAME=\"ProductName\" VALUE=\"\">\n\t\t\t\t\t<PARAM NAME=\"ProductFamily\" VALUE=\"\">\n\t\t\t\t\t<PARAM NAME=\"Manufacturer\" VALUE=\"\">\n\t\t\t\t\t<PARAM NAME=\"VersionInfo\" VALUE=\"\">\n\t\t\t\t\t<PARAM NAME=\"MaxImages\" VALUE=\"-1\">\n\t\t\t\t\t<PARAM NAME=\"ShowUI\" VALUE=\"-1\">\n\t\t\t\t\t<PARAM NAME=\"SaveJPGLumFactor\" VALUE=\"32\">\n\t\t\t\t\t<PARAM NAME=\"SaveJPGChromFactor\" VALUE=\"36\">\n\t\t\t\t\t<PARAM NAME=\"SaveJPGSubSampling\" VALUE=\"2\">\n\t\t\t\t\t<PARAM NAME=\"SaveJPGProgressive\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"PICPassword\" VALUE=\"\">\n\t\t\t\t\t<PARAM NAME=\"FTPUserName\" VALUE=\"\">\n\t\t\t\t\t<PARAM NAME=\"FTPPassword\" VALUE=\"\">\n\t\t\t\t\t<PARAM NAME=\"ProxyServer\" VALUE=\"\">\n\t\t\t\t\t<PARAM NAME=\"SaveTIFCompression\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"SaveMultiPage\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"CaptionLeft\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"CaptionTop\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"CaptionWidth\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"CaptionHeight\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"ShadowText\" VALUE=\"-1\">\n\t\t\t\t\t<PARAM NAME=\"ClipCaption\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"HAlign\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"VAlign\" VALUE=\"0\">\n\t\t\t\t\t<PARAM NAME=\"EnableExtCaps\" VALUE=\"-1\">\n\t\t\t\t\t<PARAM NAME=\"CloseOnCancel\" VALUE=\"-1\">\n\t\t\t\t\t<PARAM NAME=\"TransferMode\" VALUE=\"0\">\n\t\t\t\t</OBJECT>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t</tr>\n\t</table>\n\n\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"file\" id=\"file\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"oldFileExists\" id=\"oldFileExists\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"httpPath\" id=\"httpPath\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"oldFile\" id=\"oldFile\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"showUI\" id=\"showUI\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t</center>\n</body>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs ;


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
            _bw.write(_wl_block3Bytes, _wl_block3);

	try{

			request.setCharacterEncoding("UTF-8");	

	String file = request.getParameter( "file" ) ;
	String showUI = request.getParameter( "showUI" ) ;
	if (showUI == null) showUI = "false"; 
	String path = "" ;
	String httpPath = "" ;
	String oldFile = "" ;
	String oldFileExists = "0" ;

	if ( file == null ) file = "patient" ;		

//	con = (Connection) session.getValue( "connection" ) ;
	con=ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement( "select pat_photo_os_path, pat_photo_http_path from sm_db_info" ) ;
	rs = pstmt.executeQuery() ;

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

            _bw.write(_wl_block4Bytes, _wl_block4);

			if ( oldFileExists.equals( "1" ) )
				out.println( "<td><img name='oldPhoto' src='" + httpPath + file + "'></td>" ) ;
			else
				out.println( "<td><img name='oldPhoto' src='" + httpPath + "blank.jpg" + "'></td>" ) ;
			
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( file ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( oldFileExists ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( httpPath ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( oldFile ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( showUI ));
            _bw.write(_wl_block10Bytes, _wl_block10);

	try {
		if ( rs != null ) rs.close() ;
		if ( pstmt != null ) pstmt.close() ;
	} catch ( Exception e ) {}
}catch(Exception e){out.println(e);}
finally{
if(con!=null)
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
