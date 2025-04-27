package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.io.File;
import org.apache.commons.io.FileUtils;

public final class __mpuploadeddocumentview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/MPUploadedDocumentView.jsp", 1729779457772L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--Created by Ashwini on 16-Dec-2019 for AAKH-CRF-0079.11-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
request.setCharacterEncoding("UTF-8");

String facility_id = checkForNull((String)session.getValue("facility_id"));
Connection con = null;
try { 
	con = ConnectionManager.getConnection(request);
	Statement st = null;
	ResultSet res = null;
	byte [] byteArr = null;
	String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");
	String serial_no = request.getParameter("serial_no");
	String query = "";
	Blob pat_photo_blob = null;
	BufferedOutputStream Buffout = null;
	st = con.createStatement();
	
		query = "SELECT document_file FROM mp_upload_document WHERE patient_id = '"+patient_id+"' AND encounter_id = '"+encounter_id+"' AND facility_id = '"+facility_id+"' AND serial_no = '"+serial_no+"'";		
		 
		res = st.executeQuery(query);

		if(res!=null && res.next()) {
			
			// document blob
			pat_photo_blob = (java.sql.Blob)res.getBlob("document_file");
			
			
			if(pat_photo_blob != null){
				// getting the file type from the blob content
				String fileType = "";
				InputStream inputStream = pat_photo_blob.getBinaryStream();
	            byte[] buffer = new byte[4];
	            int bytesRead = inputStream.read(buffer);
				if(bytesRead >= 4){
					String firstBlob4Chars = new String(buffer, 0, bytesRead, "UTF-8") ;
					if("%PDF".equals(firstBlob4Chars)){
						fileType = "application/pdf";
					}
				 	else {
						fileType = "image/gif";
					}
				}
				
				byteArr = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());
	
                response.reset();
				response.setContentType(fileType);
				OutputStream outputStream = response.getOutputStream();
				outputStream.write(byteArr);      
				outputStream.flush();
				outputStream.close();		
			}			
		}
		if(Buffout != null)
			Buffout.flush();	
		
		if(res != null) res.close();
		if(st != null) st.close();	 
	
}
catch ( java.io.FileNotFoundException fe )	
{    
	out.println("<script>alert('File is not found in the stored path!!!!!')</script>");
}
catch ( java.io.IOException ioe )
{
	out.println("<script>alert('Access is denied in the stored path!!!!!')</script>");
}
catch (Exception e) 
{
	out.println("<script>alert('Error in read the file in the stored path!!!!!')</script>");
	e.printStackTrace(); 
} 
finally 
{
	if(con!=null)
	con.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}


            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
