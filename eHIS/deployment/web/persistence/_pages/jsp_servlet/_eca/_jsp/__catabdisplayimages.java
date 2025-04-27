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

public final class __catabdisplayimages extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CATABDisplayImages.jsp", 1709115178154L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n<body onKeyDown = \'lockKey()\' bgcolor=\"#031B47\" text=\"#ffffff\">\n<TABLE width=\"100%\" height=100% border=0 cellpadding=0 cellspacing=0>\n";
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
	Connection con = null;
	PreparedStatement ptsmt = null;
	ResultSet rs = null;

	java.sql.Blob img_blob = null;
	BufferedOutputStream Buffout1 = null;
	InputStream ins=null;
	byte [] byteArr = null;
	long len=0;

	String qryImgContent = "";
	try{
		con = ConnectionManager.getConnection(request);
		String patient_id	= request.getParameter("patient_id")==null?"":(String)request.getParameter("patient_id");	
		String encounterid	= request.getParameter("encounterid")==null?"":(String)request.getParameter("encounterid");
		String facility_id	= request.getParameter("facility_id")==null?"":(String)request.getParameter("facility_id");	
		String patient_class= request.getParameter("patient_class")==null?"":(String)request.getParameter("patient_class");
		String Param = request.getParameter("Param")==null?"":(String)request.getParameter("Param");
		String attend_practitioner_id =request.getParameter("attend_practitioner_id")==null?"":(String)request.getParameter("attend_practitioner_id");
		
		if("PAT_PHOTO".equals(Param)){
			//qryImgContent = "SELECT b.ins_image IMAGE_CONTENT FROM bl_encounter_payer_priority a, bl_pat_ins_documents b WHERE a.operating_facility_id = ? AND a.patient_id = b.patient_id AND a.cust_group_code = b.cust_group_code AND a.cust_code = b.cust_code  AND a.policy_number = b.policy_number AND a.patient_id = ? AND a.episode_type = DECODE (?, 'OP', 'O', 'IP', 'I', 'EM', 'E', 'DC', 'D', 'RF', 'R' )  AND (  ( ? IN ('OP', 'EM') AND a.episode_id || LPAD (TO_CHAR (a.visit_id), 4, '0') = ? )  OR (? IN ('IP', 'DC') AND a.episode_id = ?) ) AND a.priority = 1 AND a.cust_code IS NOT NULL";
			qryImgContent = "SELECT b.ins_image IMAGE_CONTENT FROM bl_encounter_payer_priority a, bl_pat_ins_documents b WHERE a.operating_facility_id = ? AND a.patient_id = b.patient_id AND a.cust_group_code = b.cust_group_code AND a.cust_code = b.cust_code AND a.policy_number = b.policy_number AND a.policy_type_code = b.policy_type_code AND a.patient_id = ? AND a.episode_type =DECODE (?,'OP', 'O','IP', 'I','EM', 'E','DC', 'D','RF', 'R')AND (  ( ? IN ('OP', 'EM') AND a.episode_id || LPAD (TO_CHAR (a.visit_id), 4, '0') = ? )  OR (? IN ('IP', 'DC') AND a.episode_id = ?))AND a.priority = 1 AND a.cust_code IS NOT NULL";
		}else if("PRACTITIONER_SIGN".equals(Param)){
			qryImgContent = "SELECT PRACTITIONER_SIGN IMAGE_CONTENT  FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?";
		}
		ptsmt = con.prepareStatement(qryImgContent);
		if("PAT_PHOTO".equals(Param)){
			ptsmt.setString(1, facility_id);
			ptsmt.setString(2, patient_id);
			ptsmt.setString(3, patient_class);
			ptsmt.setString(4, patient_class);
			ptsmt.setString(5, encounterid);
			ptsmt.setString(6, patient_class);
			ptsmt.setString(7, encounterid);
		}else if("PRACTITIONER_SIGN".equals(Param)){
			ptsmt.setString(1, attend_practitioner_id);
		}
		rs = ptsmt.executeQuery();
		while(rs !=null && rs.next()){			
			img_blob  =  (java.sql.Blob)rs.getBlob("IMAGE_CONTENT");
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
				}
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
