package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.io.File;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.ArrayList;

public final class __report_open extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/report_open.jsp", 1713330607682L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html lang=\"en\">  \n<head>  \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />   \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<head>\n  ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\' />\n <Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script language=\"JavaScript\">\n\t\tvar outputWindow;\n \nfunction onFormLoad() {\t \n\twindow.document.title = \'eHIS\' ;\n}\n\t    \nfunction callclose(report_option)\n\t{\n\t\tif(report_option!=\'V\')\n\t\t{\n\t\tself.close();\n\t\toutputWindow.close() ;\n\t\twindow.close() ;\n\t\t}\n\t} \n\n    </script>\n</head>\n<body onLoad=\"onFormLoad();\" OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<form name=\"report_process_form\" id=\"report_process_form\">\n<input type=\"hidden\" name=\"closeWindow\" id=\"closeWindow\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n<input type=\"hidden\" name=\"reportServerEnableFlag\" id=\"reportServerEnableFlag\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n</form>\n</body>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

 public byte [] convertFileToBytes(String fileName) 
	{
	File file = new File(fileName);
	/*****************************************************/
	byte [] returnBase64=null;
	/*********************************/
	byte[] bytes =new byte[(int)file.length()];
	try { 
		 FileInputStream fileInputStreamReader = new FileInputStream(file);
		 bytes = new byte[(int)file.length()];
		 fileInputStreamReader.read(bytes);
		 fileInputStreamReader.close();
		returnBase64=bytes;
	//	returnBase64=new String(Base64.encodeBase64(bytes), "UTF-8");
		//returnBase64=new String(bytes, "UTF-8");			
		if(returnBase64!=null){
			if(file.exists())
				{
				try {
					deleteFile(fileName);
					} 
				catch (Exception e) {				
					System.err.println("Exception occurred while converting deleting the file folder from server folder : "+ e);
					e.printStackTrace();
					}
				}
			else {
				returnBase64=bytes;
				}
			}
			}

   catch (Exception e) 
		{
			returnBase64=bytes;
		//returnBase64="NOT_EXISTS";
		System.err.println("Exception occurred while reading the file folder from server folder : "+ e);
		e.printStackTrace();
		}

	return returnBase64;
    }
public boolean deleteFile(String fileName1) 
	{
	boolean returnVal=false;
	try {
		File file1 = new File(fileName1);
		if(file1.exists())
			{
			try {
				file1.delete();
				returnVal=true;
				} 
			catch (Exception e) {		
				returnVal=false;				
				System.err.println("Exception occurred while converting deleting the file folder from server folder : "+ e);
				e.printStackTrace();
				}
			}
		else {
			returnVal=false;	
			}
		}
   catch (Exception e) 
		{
		returnVal=false;	
		System.err.println("Exception occurred while reading the file folder from server folder : "+ e);
		e.printStackTrace();
		}
	return returnVal;
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

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

	request.setCharacterEncoding("UTF-8");	
   // String params       = request.getQueryString() ;
	response.setContentType("text/html;charset=UTF-8");
    String closeWindow  = request.getParameter( "closeWindow" ) ;      
    String report_url  = request.getParameter( "report_url" ) ;
	String file_dir  = request.getParameter( "file_dir" ) ;	
	String file_name  = request.getParameter( "file_name" ) ;	
	String report_option  = request.getParameter( "report_option" ) ;	
	//Maheshwaran K added 
	Connection con=null;
	String reportServerEnableFlag="";	
		String error_status="";
		String error_text="";
	try 
		{
		con	= ConnectionManager.getConnection(request);
		HashMap hashdata  = eCommon.Common.CommonBean.getSiteSpecificDetails(con,"SM","REPORT_SERVER_POST");
		reportServerEnableFlag = (String)hashdata.get("value1");
		CallableStatement cs = con.prepareCall( "{ call report_submit( ?, ?, ?) }" ) ;
		cs.setString( 1,	report_url ) ;	 
		cs.registerOutParameter( 2,  Types.VARCHAR ) ;
		cs.registerOutParameter( 3,  Types.VARCHAR ) ;
		cs.execute() ;
		error_status	= cs.getString( 2 ) ;
		error_text 	= cs.getString( 3 ) ;

		//System.err.println("report_submit in error_status : "+error_status);
		//System.err.println("report_submit in  error_text : "+error_text);

		if(error_status.equals("S"))
			{
			closeWindow = "true" ;	
			if(report_option.equals("V")) 
				{
				response.reset();
				int index = file_dir.lastIndexOf("/");
				String FinalfileName = file_dir.substring(index + 3);
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition","attachment;filename="+file_name);
				byte [] byteArr =convertFileToBytes(file_dir);
	
				OutputStream o = response.getOutputStream();
				o.write(byteArr); 
				o.flush();
				o.close(); 

			}
			else {
				if(report_option.equals("F")) {
				deleteFile(file_dir);	
				}		
			out.println( "<script language='JavaScript'>alert(getMessage('REPORT_SUBMIT_SERVER','Common') ) ; location.href='../../eCommon/jsp/error.jsp';</script>" ) ;
			}				
				
				
			}
		if(error_status.equals("E"))
			{
			closeWindow = "false" ;	
			response.sendRedirect("../../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error_text, "UTF-8" )+"&err_value=" + error_status);
			}
		if(cs !=null)cs.close() ;
		}
	catch(Exception e)
		{
		System.err.println("Exception : "+e);
		e.printStackTrace();	
		}
	finally 
		{
			ConnectionManager.returnConnection(con,request);
		}
	//End

    if ( closeWindow == null ) closeWindow = "false" ;
 	out.println( "<script language='JavaScript'>'"+closeWindow+"'</script>" ) ;
    if ( closeWindow.equalsIgnoreCase( "true" ) ) {
    //    out.println( "<script language='JavaScript'>alert(getMessage('REPORT_SUBMIT_SERVER','Common') ) ;</script>" ) ;
    } else {
        out.println( "<table align='center'>" ) ;
        out.println( "<tr height=500>" ) ;
        out.println( "<td align='center'>" ) ;

        out.println( "Processing Report.  Please Wait...<br><br>" ) ;
		out.println( "<input type='button' align='center' name='Cancel' id='Cancel' onClick='window.close()' class='button' value='Cancel'>" ) ;

        //out.println( "<img src='../images/BBcancel.gif' alt='Cancel' onClick='window.close()'>" ) ;

        out.println( "</td>" ) ;
        out.println( "</tr>" ) ;
        out.println( "</table>" ) ;
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( closeWindow ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( reportServerEnableFlag ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
