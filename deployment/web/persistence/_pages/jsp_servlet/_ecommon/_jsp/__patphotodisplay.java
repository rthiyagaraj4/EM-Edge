package jsp_servlet._ecommon._jsp;

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

public final class __patphotodisplay extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/PatPhotoDisplay.jsp", 1709116509826L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<!-- <script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script> -->\n<!-- <script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n<body onKeyDown = \'lockKey()\' bgcolor=\"#031B47\" text=\"#ffffff\">\n<TABLE width=\"100%\" height=100% border=0 cellpadding=0 cellspacing=0>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n</table>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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

request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement ptsmt = null;
ResultSet rs = null;

java.sql.Blob img_blob = null;
//BufferedOutputStream Buffout1 = null;
//InputStream ins=null;
InputStream ins1 = null;
byte [] byteArr = null;
long len=0; 
String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

String qryImgContent = "";
					try{
						con = ConnectionManager.getConnection(request);

						String logo_name=request.getParameter("param");
						qryImgContent = "select pat_photo_blob pat_photo from mp_patient_photo where patient_id='"+patient_id+"'";
						
						ptsmt = con.prepareStatement(qryImgContent);
						rs = ptsmt.executeQuery();
						if(rs !=null && rs.next())
						{
							img_blob  =  (java.sql.Blob)rs.getBlob("pat_photo");
							if(img_blob!=null){
							byteArr = img_blob.getBytes(1,(int)img_blob.length());
								len = img_blob.length();
								if(len > 0){
								  response.reset();
							      response.setContentType("image/gif");
							      OutputStream outputStream = response.getOutputStream();
							      outputStream.write(byteArr);      
							      outputStream.flush();
							      outputStream.close(); 
									/****** create a copy in the image folder*******start****/
									/*	ins1 = img_blob.getBinaryStream();
										bytearrayoutputstream = new ByteArrayOutputStream();
										int i;
										while((i = ins1.read()) != -1) 
										bytearrayoutputstream.write(i);

										boolean fcre=false;
										fcre = file.createNewFile();
										if(fcre)
										{
											FileOutputStream fileoutput = new FileOutputStream(file);
											fileoutput.write(bytearrayoutputstream.toByteArray(),0,(int)len);
											if (fileoutput != null)  fileoutput.close();			
										}*/

									/****** create a copy in the image folder *******end****/
									/*****get the data from database and display***start*********/
								/*	try{

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
										} */
									/*****get the data from database and display***end*********/
								}else{
									File file = null;
									try{
										file = new File(config.getServletContext().getRealPath("/")+"eCommon/images/blank40.gif");
										if(file.exists()){
											int  size1=(int)file.length();
											ins1=new FileInputStream(file);
											byte[] by1 = new byte[(int)size1];
											response.reset();
											response.setContentType("image/gif");
											while((size1=ins1.read(by1))!= -1 )
											{
											response.getOutputStream().write(by1,0,size1);
											}
											response.flushBuffer();
											ins1.close();
										}else{
										}
									}catch(Exception imageEx){
										imageEx.toString();
									}
								}

							}
						}else{
							File file = null;
							try{
								file = new File(config.getServletContext().getRealPath("/")+"eCommon/images/blank40.gif");
								if(file.exists()){
									int  size1=(int)file.length();
									ins1=new FileInputStream(file);
									byte[] by1 = new byte[(int)size1];
									response.reset();
									response.setContentType("image/gif");
									while((size1=ins1.read(by1))!= -1 )
									{
									response.getOutputStream().write(by1,0,size1);
									}
									response.flushBuffer();
									ins1.close();
								}else{
								}
							}catch(Exception imageEx){
								imageEx.toString();
							}
						}
						//if(ins !=null)
							//ins.close();
						if(ins1 !=null)
						ins1.close();
					}catch(Exception e){
						out.println("failed to display ==>"+e);
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
