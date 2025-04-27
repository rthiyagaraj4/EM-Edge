package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import javax.servlet.*;

public final class __viewgrnbatchuploadfile extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ViewGRNBatchUploadFile.jsp", 1709117560993L ,"10.3.6.0","Asia/Calcutta")) return true;
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

23/04/2022	23925			Ramesh Goli		23/04/2022		RAMESH G    	MO-CRF-20171
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement ptsmt = null;
	ResultSet rs = null;	
	java.sql.Blob hist_blob = null;
	BufferedOutputStream Buffout = null;	

	String qryString = "";
	String imageRef = request.getParameter("imageRef")==null?"":request.getParameter("imageRef");
	
	try
	{
		con = ConnectionManager.getConnection(request);
		qryString = "SELECT IMAGE_REF,IMAGE_TYPE,IMAGE_NAME,IMAGE_CONTENT,IMAGE_IN_DB,IMAGE_SHAREPATH FROM ST_GRN_DTL_EXP_DOC WHERE IMAGE_REF=?";
		ptsmt = con.prepareStatement(qryString);
		ptsmt.setString(1,imageRef);
		
		rs = ptsmt.executeQuery();
		if(rs.next()) {
			String[] objArray =((String)rs.getString("IMAGE_TYPE")).split("\\/");
			String imageName = (String)rs.getString("IMAGE_NAME");
			String imageInDb = (String)rs.getString("IMAGE_IN_DB");
			String imageSharePath = rs.getString("IMAGE_SHAREPATH")==null?"":(String)rs.getString("IMAGE_SHAREPATH");
			if("image".equals(objArray[0])){
				InputStream readImg =null;
				long len1=0;
				if(!"".equals(imageSharePath) && "N".equals(imageInDb)){				
					File file =new File(imageSharePath+"/"+imageName);
					if(file.exists()){
						readImg = new FileInputStream(file);
						len1 = file.length();
					}else{
						String errorMsg="Unable to Retrieve. File Server is not Responding or File is Unavailable. Please contact administrator.";
						readImg = new ByteArrayInputStream(errorMsg.getBytes("UTF-8"));
						len1 = errorMsg.length();
					}
				}else{				
					hist_blob  =  (java.sql.Blob)rs.getBlob("IMAGE_CONTENT");        	 
					len1 = hist_blob.length(); 					  
					readImg = hist_blob.getBinaryStream();  
				} 
				byte[] by = new byte[(int)len1]; 
				int index = readImg.read(by, 0, (int)len1);					
				response.reset();  
				response.setContentType(rs.getString("IMAGE_TYPE"));  
				response.getOutputStream().write(by, 0, (int)len1);  
				response.getOutputStream().flush(); 
			}else{	
				InputStream in =null;
				long len=0;
				System.out.println(imageInDb+"<--------------->"+imageSharePath);
				
				if(!"".equals(imageSharePath) && "N".equals(imageInDb)){
					response.setContentType((String)rs.getString("IMAGE_TYPE"));
					File file =new File(imageSharePath+"/"+imageName);
					if(file.exists()){
						in = new FileInputStream(file);
						len = file.length();
						Buffout = new BufferedOutputStream( response.getOutputStream() );
						byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
						int index = in.read(by , 0 , (int)len);

						while ( index != -1) {
						Buffout.write(by , 0, index);
						index = in.read ( by , 0 , (int)len );
						}
						Buffout.flush();
					}else{
						String errorMsg="Unable to Retrieve. File Server is not Responding or File is Unavailable. Please contact administrator.";
						in = new ByteArrayInputStream(errorMsg.getBytes("UTF-8"));
						len = errorMsg.length();
						
						byte[] by = new byte[(int)len]; 
						int index = in.read(by, 0, (int)len);					
						response.reset();  
						response.setContentType("image/pjpeg");  
						response.getOutputStream().write(by, 0, (int)len);  
						response.getOutputStream().flush(); 
					}
				}else{	
					if("pdf".equals(objArray[1]) || "PDF".equals(objArray[1]) ){
						response.setContentType((String)rs.getString("IMAGE_TYPE"));						
						hist_blob  =  (java.sql.Blob)rs.getBlob("IMAGE_CONTENT");
						in = hist_blob.getBinaryStream();
						len = hist_blob.length();					
					
						Buffout = new BufferedOutputStream( response.getOutputStream() );
						byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
						int index = in.read(by , 0 , (int)len);

						while(index != -1)
						{
							Buffout.write(by , 0, index);
							index = in.read ( by , 0 , (int)len );
						}			
						Buffout.flush();

					}else{
						response.setContentType("application/vnd.ms-word");
						response.setHeader("Content-Disposition","attachment;filename="+imageName);
						response.setHeader("cache-control", "must-revalidate");
						hist_blob  =  (java.sql.Blob)rs.getBlob("IMAGE_CONTENT");
						in = hist_blob.getBinaryStream();
						len = hist_blob.length();					
					
						Buffout = new BufferedOutputStream( response.getOutputStream() );
						byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
						int index = in.read(by , 0 , (int)len);

						while(index != -1)
						{
							Buffout.write(by , 0, index);
							index = in.read ( by , 0 , (int)len );
						}			
						Buffout.flush();
					}					
				} 			
				
			}
		}
		
	}catch(Exception e){
		e.printStackTrace();		
	}finally{
		ConnectionManager.returnConnection(con,request);

		if(rs!=null)
			rs.close();
			
		if(ptsmt!=null)
			ptsmt.close();
			
		
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
