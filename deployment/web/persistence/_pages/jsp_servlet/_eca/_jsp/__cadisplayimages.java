package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import webbeans.eCommon.*;
import javax.servlet.*;

public final class __cadisplayimages extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CADisplayImages.jsp", 1709115166649L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html> \n<head>\n<body onKeyDown = \'lockKey()\' bgcolor=\"#031B47\" text=\"#ffffff\">\n<TABLE width=\"100%\" height=100% border=0 cellpadding=0 cellspacing=0>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n</table>\n</body>\n</html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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

request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con = null;
	PreparedStatement ptsmt = null;
	ResultSet rs = null;
	byte [] byteArr = null;//IN066005 
	java.sql.Blob img_blob = null;
	BufferedOutputStream Buffout1 = null;
	InputStream ins=null;
	
	long len=0;

	String qryImgContent = "";
	try{
		con = ConnectionManager.getConnection(request);
		String logo_name=request.getParameter("param");		
		qryImgContent = "SELECT IMAGE_CONTENT LOGO FROM CA_NOTE_IMAGE_LIST WHERE IMAGE_REF='VDFI'";
					
		ptsmt = con.prepareStatement(qryImgContent);
		rs = ptsmt.executeQuery();
		while(rs !=null && rs.next()){
			System.out.println("------------------------------------>1");
			img_blob  =  (java.sql.Blob)rs.getBlob("LOGO");
			if(img_blob!=null){
				byteArr = img_blob.getBytes(1,(int)img_blob.length());//IN066005 
				len = img_blob.length();
				if(len > 0){					
				//IN066005 Start
					response.reset();
							response.setContentType("image/gif");
							OutputStream outputStream = response.getOutputStream();
							outputStream.write(byteArr);      
							outputStream.flush();
							outputStream.close();
							//IN066005 end 
					/*****get the data from database and display***start*********/
					/*try{
							ins = img_blob.getBinaryStream();						
							Buffout1 = new BufferedOutputStream( response.getOutputStream() );
							byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
							int index = ins.read(by , 0 , (int)len);
							while ( index != -1) {
								Buffout1.write(by , 0, index);
								index = ins.read ( by , 0 , (int)len );
							}
							Buffout1.flush();
						}catch(Exception e){
							out.println("@@ exp while creating copy="+e);
							e.printStackTrace();
						}*/ // comitted for IN066005 
					/*****get the data from database and display***end*********/
				}else{
					System.out.println("---------------------->len 0");
				}

			}else{
				System.out.println("-------------------------->img_blob null");
			}
		}
		if(ins !=null)
			ins.close();
		
	}catch(Exception e){
		//out.println("failed to display ==>"+e);//COMMON-ICN-0181
		e.printStackTrace();
	}finally{
		try{
			ConnectionManager.returnConnection(con);
			if(ptsmt!=null)
				ptsmt.close();
			if(rs!=null)
				rs.close();
		}catch(Exception e1){
			e1.printStackTrace();
		}
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
