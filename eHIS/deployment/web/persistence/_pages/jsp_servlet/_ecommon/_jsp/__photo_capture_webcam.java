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

public final class __photo_capture_webcam extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/photo_capture_webcam.jsp", 1709116510607L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<head>\n\n\t<title>Capture Photo</title>\n\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../html/IeStyle.css\'></link>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script language=\"JavaScript\">\n\t\tfunction connectButton_click() {\n\t\t\tcapturePro.connect( 0 ) ;\n\t\t}\n\n\t\tfunction previewButton_click() {\n\t\t\tcapturePro.preview = 1 ;\n\t\t}\n\n\t\tfunction captureButton_click() {\n\t\t\t\n\t\t\t\n\t\t\tvar file = \"ftp://\" + document.location.hostname + \"/pat_photo/\" + capture_form.file.value ;\n\t\t\t\n\t\t\tvar oldFileExists = capture_form.oldFileExists.value ;\n\t\t\tvar httpPath = capture_form.httpPath.value ;\n\n\t\t\talert(capture_form.oldFile.value);\n//\t\t\tcapturePro.frameFile = capture_form.file.value ;\n\t\t\tcapturePro.frameFile = file ;\n\t\t\tcapturePro.captureFrame() ;\n//\t\t\tcapturePro.preview = 0 ;\n\n\t\t\tdocument.getElementById(\"oldPhoto\").src = httpPath + capture_form.file.value ;\n\t\t}\n\n\t\tfunction disconnectButton_click() {\n\t\t\tcapturePro.disconnect() ;\n\t\t\twindow.close() ;\n\t\t}\n\n\t\tfunction videoFormatButton_click() {\n\t\t\tif ( capturePro.hasDlgVideoFormat )\n\t\t\t\tcapturePro.showVideoFormatDlg() ;\n\t\t}\n\n\t\tfunction videoSourceButton_click() {\n\t\t\tif ( capturePro.HasDlgVideoSource )\n\t\t\t\tcapturePro.showVideoSourceDlg() ;\n\t\t}\n\n\t\tfunction videoCompressButton_click() {\n\t\t\tcapturePro.showVideoCompressionDlg() ;\n\t\t}\n\n\t\tfunction changeButtonColors() {\n\t\t\tdocument.getElementById(\"connectButton\").style.background=\"navy\" ;\n\t\t\tdocument.getElementById(\"connectButton\").style.color=\"white\" ;\n\t\t\tdocument.getElementById(\"connectButton\").style.fontWeight=\"700\" ;\n\t\t\tdocument.getElementById(\"connectButton\").style.borderStyle=\"solid\" ;\n/*\n\t\t\tdocument.getElementById(\"previewButton\").style.background=\"navy\" ;\n\t\t\tdocument.getElementById(\"previewButton\").style.color=\"white\" ;\n\t\t\tdocument.getElementById(\"previewButton\").style.fontWeight=\"700\" ;\n\t\t\tdocument.getElementById(\"previewButton\").style.borderStyle=\"solid\" ;\n*/\n\t\t\tdocument.getElementById(\"captureButton\").style.background=\"navy\" ;\n\t\t\tdocument.getElementById(\"captureButton\").style.color=\"white\" ;\n\t\t\tdocument.getElementById(\"captureButton\").style.fontWeight=\"700\" ;\n\t\t\tdocument.getElementById(\"captureButton\").style.borderStyle=\"solid\" ;\n\n\t\t\tdocument.getElementById(\"disconnectButton\").style.background=\"navy\" ;\n\t\t\tdocument.getElementById(\"disconnectButton\").style.color=\"white\" ;\n\t\t\tdocument.getElementById(\"disconnectButton\").style.fontWeight=\"700\" ;\n\t\t\tdocument.getElementById(\"disconnectButton\").style.borderStyle=\"solid\" ;\n\t\t}\n\t</script>\n</head>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<body onKeyDown = \'lockKey()\' onLoad=\"connectButton_click();\">\n\t<table width=\'100%\' height=\'100%\' align=center cellspacing=0 cellpadding=0>\n\t\t<tr>\n\t\t\t<td>\n\t\t\t\t<object classid=\"clsid:CC34CEBF-5C10-11D1-A40F-00A024229C83\" id=\"capturePro\" width=\"192\" height=\"192\" align=\"middle\">\n\t\t\t\t\t<param name=\"_ExtentX\" value=\"5080\">\n\t\t\t\t\t<param name=\"_ExtentY\" value=\"5080\">\n\t\t\t\t\t<param name=\"ErrStr\" value=\"6E500050GEP-BB301RPACP\">\n\t\t\t\t\t<param name=\"ErrCode\" value=\"1603420513\">\n\t\t\t\t\t<param name=\"ErrInfo\" value=\"1367446139\">\n\t\t\t\t\t<param name=\"BorderVisible\" value=\"1\">\n\t\t\t\t\t<param name=\"BorderWidth\" value=\"1\">\n\t\t\t\t\t<param name=\"Enabled\" value=\"1\">\n\t\t\t\t\t<param name=\"Caption\" value>\n\t\t\t\t\t<param name=\"ForeColor\" value=\"0\">\n\t\t\t\t\t<param name=\"Preview\" value=\"1\">\n\t\t\t\t\t<param name=\"FrameFile\" value=\"\">\n\t\t\t\t\t<param name=\"SaveJPGChromFactor\" value=\"36\">\n\t\t\t\t\t<param name=\"SaveJPGProgressive\" value=\"0\">\n\t\t\t\t\t<param name=\"SaveJPGLumFactor\" value=\"32\">\n\t\t\t\t\t<param name=\"PICPassword\" value>\n\t\t\t\t\t<param name=\"AutoSave\" value=\"0\">\n\t\t\t\t\t<param name=\"Interval\" value=\"60000\">\n\t\t\t\t\t<param name=\"PreviewRate\" value=\"15\">\n\t\t\t\t\t<param name=\"CaptionLeft\" value=\"0\">\n\t\t\t\t\t<param name=\"CaptionTop\" value=\"0\">\n\t\t\t\t\t<param name=\"CaptionWidth\" value=\"0\">\n\t\t\t\t\t<param name=\"CaptionHeight\" value=\"0\">\n\t\t\t\t\t<param name=\"ShadowText\" value=\"1\">\n\t\t\t\t\t<param name=\"ClipCaption\" value=\"0\">\n\t\t\t\t\t<param name=\"StreamFile\" value>\n\t\t\t\t\t<param name=\"FrameRate\" value=\"15\">\n\t\t\t\t\t<param name=\"Yield\" value=\"0\">\n\t\t\t\t\t<param name=\"CaptureAudio\" value=\"0\">\n\t\t\t\t\t<param name=\"TimeLimit\" value=\"0\">\n\t\t\t\t\t<param name=\"AudioChannels\" value=\"1\">\n\t\t\t\t\t<param name=\"AudioBits\" value=\"8\">\n\t\t\t\t\t<param name=\"AudioSampleRate\" value=\"11025\">\n\t\t\t\t\t<param name=\"FTPUserName\" value>\n\t\t\t\t\t<param name=\"FTPPassword\" value>\n\t\t\t\t\t<param name=\"SaveJPGSubSamling\" value=\"2\">\n\t\t\t\t\t<param name=\"AutoIncrement\" value=\"0\">\n\t\t\t\t\t<param name=\"HAlign\" value=\"0\">\n\t\t\t\t\t<param name=\"VAlign\" value=\"0\">\n\t\t\t\t\t<param name=\"ProxyServer\" value>\n\t\t\t\t\t<param name=\"Overlay\" value=\"1\">\n\t\t\t\t\t<param name=\"FTPRename\" value=\"0\">\n\t\t\t\t\t<param name=\"ResX\" value=\"0\">\n\t\t\t\t\t<param name=\"ResY\" value=\"0\">\n\t\t\t\t</object>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t</tr>\n\t</table> \n\t<input type=\"hidden\" name=\"file\" id=\"file\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\t<input type=\"hidden\" name=\"oldFileExists\" id=\"oldFileExists\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t<input type=\"hidden\" name=\"httpPath\" id=\"httpPath\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t<input type=\"hidden\" name=\"oldFile\" id=\"oldFile\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\t\n\t<input type=\"hidden\" name=\"showUI\" id=\"showUI\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n</body>\n\n";
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
