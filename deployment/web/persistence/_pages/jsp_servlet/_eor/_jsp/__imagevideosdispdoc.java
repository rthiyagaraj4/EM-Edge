package jsp_servlet._eor._jsp;

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
import eOR.Common.*;
import eOR.*;
import eOR.ImageVideosMultiFileUploadBean.FileDoc;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __imagevideosdispdoc extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ImageVideosDispDoc.jsp", 1709117176000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nDate       Edit History      Name        \tRev.Date\t\tRev.Name\t\tDescription\n---------------------------------------------------------------------------------------------------------------------\n28/03/2019\tIN068778\t\tSelvin M\t\t28/03/2019\t\tRamesh G\t\tTBMC-CRF-0011\n---------------------------------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<script>\n\t\t\t\tparent.window.close();\n\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");

	String fileName = request.getParameter("fileName")==null?"":request.getParameter("fileName");
	String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
	String file_seq_no = request.getParameter("file_seq_no")==null?"":request.getParameter("file_seq_no");
	ImageVideosMultiFileUploadBean fbean = (ImageVideosMultiFileUploadBean) getObjectFromBean("MULTIPLEFILEUPLOADBEAN", "eOR.ImageVideosMultiFileUploadBean", session);
	java.sql.Blob hist_blob = null;
	BufferedOutputStream Buffout = null;
	InputStream in = fbean.getFileInputStream(fileName);
	long len = fbean.getFileSize(fileName);
	String contentType = fbean.getFileType(fileName);
	String orderId = fbean.getOrderId();
	String orderLineNum = fbean.getOrderLineNum();	
	String fileChoosePath = fbean.getSharedPath();
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	try {
		con = ConnectionManager.getConnection(request);		
		fileChoosePath = fileChoosePath + fileName;
		

		String strTemp = "select file_name from OR_MULTI_FILE_UPLOAD_TEMP where order_id = ? and order_line_num = ? and file_name = ? ";
		String fileCheck = "";
		pst = con.prepareStatement(strTemp);
		pst.setString(1, orderId);
		pst.setString(2, orderLineNum);
		pst.setString(3, fileName);
		rs = pst.executeQuery();
		while (rs.next()) {
			fileCheck = rs.getString(1);			
		}
		if (fileName != null && len != -1 && contentType != null && (fileCheck != "" && fileCheck.length() > 0)) {
			if (("image/pjpeg".equals(contentType)) || ("image/gif".equals(contentType)) || ("application/pdf".equals(contentType))) { // image display

				byte[] by = new byte[(int) len]; // file content logic
				int index = in.read(by, 0, (int) len);
				response.reset();
				response.setContentType(contentType);
				response.getOutputStream().write(by, 0, (int) len);
				response.getOutputStream().flush();				
			} else {
			
            _bw.write(_wl_block4Bytes, _wl_block4);

					}
						} else {							
							File file = null;
							InputStream inpStrem = null;
							file = new File(fileChoosePath);
										
							if (file.exists()) {								
								int fileSize = (int) file.length();
								inpStrem = new FileInputStream(file);
								byte[] byArray = new byte[(int) fileSize];
								response.reset();
								while ((fileSize = inpStrem.read(byArray)) != -1) {
									response.getOutputStream().write(byArray, 0, fileSize);
								}
								response.flushBuffer();
								inpStrem.close();

							} else {								
								String qry = "select HIST_DATA,OBJTYPE,file_name from OR_MULTI_FILE_UPLOAD_OBJ where order_id = ? and order_line_num = ? and file_name = ? ";

								pst = con.prepareStatement(qry);								
								pst.setString(1, orderId);
								pst.setString(2, orderLineNum);
								pst.setString(3, fileName);

								rs = pst.executeQuery();
								while (rs.next()) {
									String[] objArray = ((String) rs.getString("OBJTYPE")).split("\\/");
									System.err.println("123,objArray[0]=="+ objArray[0]);
									if ("image".equals(objArray[0])  || "gif".equals(objArray[0]) || "application".equals(objArray[0])) 
									{										 
										hist_blob = (java.sql.Blob) rs.getBlob("HIST_DATA");
										long len1 = hist_blob.length();
										byte[] by = new byte[(int) len1];
										InputStream readImg = hist_blob.getBinaryStream();
										int index = readImg.read(by, 0, (int) len1);
										response.reset();
										response.setContentType(rs.getString("OBJTYPE"));
										response.getOutputStream().write(by, 0,(int) len1);
										response.getOutputStream().flush();
									}
								}
							}
						}
						putObjectInBean("MULTIPLEFILEUPLOADBEAN", fbean, session);
					} catch (Exception e) {						
						e.printStackTrace();
					} finally {
						if (rs != null)
							rs.close();
						if (pst != null)
							pst.close();
						ConnectionManager.returnConnection(con, request);
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
