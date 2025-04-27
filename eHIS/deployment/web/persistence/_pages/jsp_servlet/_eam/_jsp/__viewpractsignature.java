package jsp_servlet._eam._jsp;

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

public final class __viewpractsignature extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/ViewPractSignature.jsp", 1709113925068L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n\nThis  file was developed by Shaik Mujafar on Feb/2019 against AAKH-CRF-0079.4\n\n -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="           \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
request.setCharacterEncoding("UTF-8");

Connection con = null;
try { 
	 con = ConnectionManager.getConnection(request);
	PreparedStatement ps1 = null;
	ResultSet res = null;
	byte [] byteArr = null;
	byte [] byteArrStamp = null;
	String practitionerid = request.getParameter("practitionerid");
	String function_id = request.getParameter("function_id");
	String sign_stamp = request.getParameter("sign_stamp");
	
	
	
	Blob pat_photo_blob =null;
	Blob pract_stamp_blob =null;
	//BufferedOutputStream Buffout = null; //Commented for checkstyle
	String table = "";	
	if(function_id.equals("PRACTITIONER")) table = "am_practitioner";
		else
		if(function_id.equals("EXT_PRACT")) table = "am_ext_practitioner";	 
	 String query = "select PRACTITIONER_SIGN,PRACTITIONER_STAMP from "+table+" WHERE PRACTITIONER_ID = ?";	
				ps1=con.prepareStatement(query);
				ps1.setString(1,practitionerid);
				res= ps1.executeQuery();						
							
							
						if(res!=null && res.next())
						{
							pat_photo_blob=(java.sql.Blob)res.getBlob("PRACTITIONER_SIGN");
							pract_stamp_blob=(java.sql.Blob)res.getBlob("PRACTITIONER_STAMP");							
							if(pat_photo_blob!=null && sign_stamp.equals("Sign"))
							{
				byteArr = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());
				
			                response.reset();
							response.setContentType("image/gif");
							OutputStream outputStream = response.getOutputStream();
							outputStream.write(byteArr);      
							outputStream.flush();
							outputStream.close();			
							}
							if(pract_stamp_blob!=null && sign_stamp.equals("Stamp"))
							{
							byteArrStamp = pract_stamp_blob.getBytes(1,(int)pract_stamp_blob.length());				
			                response.reset();
							response.setContentType("image/gif");
							OutputStream outputStream = response.getOutputStream();
							outputStream.write(byteArrStamp);      
							outputStream.flush();
							outputStream.close();			
							}						
							
						}		
	 		
		if(res != null) res.close();
		if(ps1 != null) ps1.close();
	
	
} catch ( java.io.FileNotFoundException fe )	
	{    
		out.println("<script>alert('File is not found !!!!!')</script>");
	}
catch ( java.io.IOException ioe )
	{
       out.println("<script>alert('Access is denied !!!!!')</script>");
	}
catch (Exception e) {
	 out.println("<script>alert('Error in read the file !!!!!')</script>");
	e.printStackTrace(); 
	
} finally {
	//Below Commented for checkstyle
	//if(con!=null)
	//con.close();
	//Added for checkstyle for COMMON-ICN-0056
	if(con!=null) ConnectionManager.returnConnection(con,request);
	
}

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
