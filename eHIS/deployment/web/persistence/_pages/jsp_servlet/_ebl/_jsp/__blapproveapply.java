package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import eBL.*;
import eBL.Common.*;
import java.sql.*;
import eBL.BLMedRepOutStdAmtBean;
import oracle.jdbc.*;
import java.math.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __blapproveapply extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLApproveApply.jsp", 1709114082256L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!doctype html public \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String noOfDecimals = request.getParameter("noOfDecimal1");
	request.setCharacterEncoding("UTF-8");
	String	called_frm  = request.getParameter("called_frm");
    BLMedRepOutStdAmtBean bLMedRepOutStdAmtBean=new BLMedRepOutStdAmtBean();
    Connection con				= null;
    Connection con1				= null;
    PreparedStatement pstmt		= null;
    Statement pstmt1		= null;
    ResultSet rs				= null;	
    ResultSet rs1				= null;
    Double patOutStdAmt=0.0;    
    String facilityId =  (String)request.getParameter("facilityId");  
    String patientId = (String)request.getParameter("patient_id");
    String authorized_yn = (String)request.getParameter("authorized_yn");   
    HttpSession httpSession = request.getSession(false);
    Properties p = (Properties)httpSession.getValue("jdbc");
	String strclientip=p.getProperty("client_ip_address");
	if (strclientip==null) strclientip = "";
	String strLoggedUser = p.getProperty("login_user"); 
	if(strLoggedUser == null) strLoggedUser="";
    System.out.println("strclientip/strLoggedUser"+strclientip+"/"+strLoggedUser);
    System.err.println("BLMedRepOutStdAmt.jsp......facilityid/patientId "+facilityId+"/"+patientId+"-called_frm="+called_frm);		   
    patOutStdAmt=bLMedRepOutStdAmtBean.fetchPatOutStdAmt(facilityId,patientId);
if (called_frm.equals("apply")) {
	    	try{
	    		
	    	con1	=	ConnectionManager.getConnection(request);	
		
				System.err.println("BLMedRepOutStdAmt.jsp......authorized_yn= "+authorized_yn);	
				pstmt1 = con1.createStatement(
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
				String sqlMedRepOutStdAmtAuthYN1 = "SELECT authorized_yn FROM bl_mr_authorized_patient WHERE  operating_facility_id='"+facilityId+"' and patient_id='"+patientId+"'";
			
		    
		    	rs1 = pstmt1.executeQuery(sqlMedRepOutStdAmtAuthYN1) ;	    		    	
		    	if(rs1.next()){
		    		 String f = rs1.getString("authorized_yn");
		             rs1.updateString( "authorized_yn",authorized_yn);
		             rs1.updateRow();
		    	}else{
		    		String sqlMedRepOutStdAmtAuthYNinsert="INSERT INTO bl_mr_authorized_patient(operating_facility_id, patient_id,authorized_yn,ADDED_BY_ID,ADDED_DATE,ADDED_AT_WS_NO,ADDED_FACILITY_ID,MODIFIED_BY_ID,MODIFIED_DATE,MODIFIED_AT_WS_NO,MODIFIED_FACILITY_ID) VALUES('"+facilityId+"','"+patientId+"','"+authorized_yn+"','"+strLoggedUser+"',sysdate,'"+strclientip+"','"+facilityId+"','"+strLoggedUser+"',sysdate,'"+strclientip+"','"+facilityId+"')";
		    		System.out.println("sqlMedRepOutStdAmtAuthYNinsert"+sqlMedRepOutStdAmtAuthYNinsert);
		    		rs1 = pstmt1.executeQuery(sqlMedRepOutStdAmtAuthYNinsert) ;	
		    	}
		    	con1.commit();	    
	    	
	    	}catch(Exception e)
		    	{
		    		System.err.println("Exception in BLMedRepOutStdAmt AJAX CALL"+e);
		    	}
		    	finally
				{
		    		if (rs1 != null) rs1.close();
		        	pstmt1.close();	
					ConnectionManager.returnConnection(con1);
				}	 
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
