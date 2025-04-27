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

public final class __paintimage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/PaintImage.jsp", 1709117011907L ,"10.3.6.0","Asia/Calcutta")) return true;
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
 
request.setCharacterEncoding("UTF-8");
//int no_of_days = 0;//checkstyle changes 35886
//int pat_photo_rnwl_dys = 0;  
Connection con = null;
try {
	con = ConnectionManager.getConnection(request);
	Statement st = null;
	ResultSet res = null;
	byte [] byteArr = null;
	/*Added By Dharma against MO-CRF-20154 [IN:070025] Start*/
	int PHOTO_DB_FLAG = 0;
	String PHOTO_IMAGE_PATH = "";
	/*Added By Dharma against MO-CRF-20154 [IN:070025] End*/
	String patient_id = request.getParameter("patient_id");
	String pat_photo_in_db_yn = request.getParameter("pat_photo_in_db_yn");
	String pat_photo_http_path = request.getParameter("pat_photo_http_path");
	pat_photo_http_path=pat_photo_http_path.replace("|","\\");
	st = con.createStatement();	
	/*
	res = st.executeQuery("select pat_photo_renewal_alert_days from mp_param");
	if(res!=null && res.next()) {
	pat_photo_rnwl_dys = res.getInt("pat_photo_renewal_alert_days");
	}  
	if(res != null) res.close(); 
	*/
	/*PHOTO_DB_FLAG,PHOTO_IMAGE_PATH Added By Dharma against MO-CRF-20154 [IN:070025]*/
	if(pat_photo_in_db_yn.equals("Y")){
		res = st.executeQuery("Select PAT_PHOTO_BLOB,PHOTO_DB_FLAG,PHOTO_IMAGE_PATH from MP_PATIENT_PHOTO where PATIENT_ID = '"+patient_id+"' ");
		if(res!=null && res.next()) {
			Blob pat_photo_blob = res.getBlob("PAT_PHOTO_BLOB");				
			byteArr = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());	
			PHOTO_DB_FLAG	= res.getInt("PHOTO_DB_FLAG");
			PHOTO_IMAGE_PATH = res.getString("PHOTO_IMAGE_PATH")==null?"":res.getString("PHOTO_IMAGE_PATH");

			
		} 	

		if(PHOTO_DB_FLAG==0){
			response.reset();
			response.setContentType("image/gif");
			OutputStream o = response.getOutputStream();
			o.write(byteArr); 
			o.flush();
			o.close(); 
		}else if(PHOTO_DB_FLAG==1 && !PHOTO_IMAGE_PATH.equals("")){
			File f1 = new File(PHOTO_IMAGE_PATH);
			System.err.println("PHOTO_IMAGE_PATH==>"+PHOTO_IMAGE_PATH);
			if(f1.exists()){
				System.err.println("Image Exists");
				FileInputStream fis1 = new FileInputStream(f1);
				byteArr = new byte[(int)f1.length()];
				fis1.read(byteArr,0,byteArr.length);
				fis1.close(); 
				response.reset();
				response.setContentType("image/gif");
				OutputStream o1 = response.getOutputStream();
				o1.write(byteArr);      
				o1.flush();
				o1.close(); 
			}
		}

		if(res != null) res.close();
		if(st != null) st.close();
	}else if(pat_photo_in_db_yn.equals("N")){
		/*res = st.executeQuery("Select pat_photo_os_path, pat_photo_http_path from sm_db_info");
		while(res.next()){
			pat_photo_http_path = res.getString("pat_photo_http_path");
		}
		if(res != null) res.close();
		if(st != null) st.close();*/
		String path = pat_photo_http_path+patient_id+".jpg";
		File f = new File(path);	
		if(f.exists()){
			FileInputStream fis = new FileInputStream(f);
			byteArr = new byte[(int)f.length()];
			fis.read(byteArr,0,byteArr.length);
			fis.close(); 
			response.reset();
			response.setContentType("image/gif");
			OutputStream o = response.getOutputStream();
			o.write(byteArr);      
			o.flush();
			o.close(); 
		}
	}
} catch (Exception e) {
	e.printStackTrace(); 
	System.out.println("Exception in PaintImage.jsp...");
} finally {
	if(con!=null)
	con.close();
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
