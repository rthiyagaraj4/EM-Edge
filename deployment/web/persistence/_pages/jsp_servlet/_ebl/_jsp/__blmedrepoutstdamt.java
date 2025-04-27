package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.*;
import eBL.Common.*;
import java.sql.*;
import eBL.BLMedRepOutStdAmtBean;
import oracle.jdbc.*;
import java.math.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __blmedrepoutstdamt extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLMedRepOutStdAmt.jsp", 1709114106412L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n\n\n    ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

    BLMedRepOutStdAmtBean bLMedRepOutStdAmtBean=new BLMedRepOutStdAmtBean();
    Connection con				= null;
    PreparedStatement pstmt		= null;
    ResultSet rs				= null;	
    Double patOutStdAmt=0.0;    
    String facilityId = (String) session.getValue("facility_id");  
    String patientId = request.getParameter("patientId");    
    String authorized_yn="";    
    Double medReqAuthValidity=0.0;
    String	     auth_start_time = ""; 
    patOutStdAmt=bLMedRepOutStdAmtBean.fetchPatOutStdAmt(facilityId,patientId);
    System.err.println("BLMedRepOutStdAmt.jsp-facilityid/patientId/patOutStdAmt::"+facilityId+"/"+patientId+"/"+patOutStdAmt);
    
    if(patOutStdAmt>0){
    	 try
     	{
 	    	  Double medReqAuthValidParam=0.0;
     	con	=	ConnectionManager.getConnection(request);
     	String sqlMedReqAuthValidity= BlRepository.getBlKeyValue("MED_REP_REQ_AUTH_VALIDITY"); 
     	pstmt=con.prepareStatement(sqlMedReqAuthValidity);
     	rs = pstmt.executeQuery() ;
     	if( rs != null ){
     		if( rs.next() ){
     			medReqAuthValidity=rs.getDouble(1);
     		}
     	}
     	if (rs != null) rs.close();
     	pstmt.close();	
     	
     	System.err.println("medReqAuthValidity "+medReqAuthValidity);	
     	
     	String sqlMedRepOutStdAmtAuthYN = BlRepository.getBlKeyValue("MED_REP_OUTSTD_AMT_AUTH_YN_CHECK");   	
     	pstmt = con.prepareStatement(sqlMedRepOutStdAmtAuthYN);
     	pstmt.setString(1,facilityId);
     	pstmt.setString(2,patientId);
     	pstmt.setDouble(3,medReqAuthValidity);
     	rs = pstmt.executeQuery() ;

     	if( rs != null ) 
     	{		
     		if( rs.next() )
     		{  
     			System.err.println("sqlMedRepOutStdAmtAuthYN :: "+sqlMedRepOutStdAmtAuthYN);
     			out.println("Y");	
     						
     		}
     		else{
     			System.err.println("auth_start_time / medReqAuthValidity :: "+auth_start_time+"/"+medReqAuthValidity);
     			out.println("N");
     		}
     			
     		}
     	else{
     		System.err.println("authorized_yn / medReqAuthValidity :: "+authorized_yn+"/"+medReqAuthValidity);
     			out.println("N");
     		}
     		
     	}
     	  	

     	catch(Exception e)
     	{
     		System.err.println("Exception in BLMedRepOutStdAmt.jsp "+e);
     		e.printStackTrace();
     	}
     	finally
 		{
     		if (rs != null) rs.close();

         	if(pstmt != null){
				pstmt.close();	
			}
 			ConnectionManager.returnConnection(con);
 		}
 	    
 	   
    	 
    }else{
    	out.println("Y");
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
