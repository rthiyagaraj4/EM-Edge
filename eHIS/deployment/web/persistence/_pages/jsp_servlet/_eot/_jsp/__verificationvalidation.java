package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import java.sql.Types;
import eOT.*;
import java.util.Properties;

public final class __verificationvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/VerificationValidation.jsp", 1709117296000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);


Properties p= (Properties)session.getValue("jdbc");
String client_ip_address=""+p.getProperty("client_ip_address");

String user_id = (String)session.getValue("login_user");


 
String order_id_1="";
String waitlist_num_1="";
String theatre_code="";
String facility_id=CommonBean.checkForNull(request.getParameter("facility_id"));
//String patient_id=CommonBean.checkForNull(request.getParameter("patient_id"));
 order_id_1=CommonBean.checkForNull(request.getParameter("order_id_1")); 
 waitlist_num_1=CommonBean.checkForNull(request.getParameter("booking_num_1")); 
 theatre_code=CommonBean.checkForNull(request.getParameter("theatre_code")); 
String p_status="";
String p_msg_txt="";
String p_langerr_msg_txt = "";

Connection con = null;
CallableStatement cstmt = null;
//PreparedStatement pstmt=null;
//PreparedStatement pstmt1=null;
//ResultSet resultset =null;
//ResultSet resultset1 =null;
try
{
	
	int index = 0;
	 	
	con = ConnectionManager.getConnection(request);
		//for checking whether the lab module is installed or not
		cstmt=con.prepareCall("{call OT_SCHEDULE_WAITLIST(?,?,?,?,null,null,null,?,?,?,?,?)}");
		cstmt.setString(++index,facility_id);
		cstmt.setString(++index,order_id_1);
		//cstmt.registerOutParameter(++index,Types.VARCHAR);
		//cstmt.registerOutParameter(++index,Types.INTEGER);
		//cstmt.registerOutParameter(++index,Types.INTEGER);
		//cstmt.registerOutParameter(++index,Types.INTEGER);
		//cstmt.registerOutParameter(++index,Types.VARCHAR);
		//cstmt.setString(++index,booking_no);
		cstmt.setString(++index,waitlist_num_1);
		cstmt.setString(++index,theatre_code);
		cstmt.setString(++index,user_id);
		cstmt.setString(++index,client_ip_address);
		cstmt.registerOutParameter(++index,Types.VARCHAR);
		cstmt.registerOutParameter(++index,Types.VARCHAR);
		cstmt.registerOutParameter(++index,Types.VARCHAR);
		
		cstmt.execute();
		
		p_status =CommonBean.checkForNull(cstmt.getString(7));
		//p_alert_status =CommonBean.checkForNull(cstmt.getString(8));
		p_msg_txt=CommonBean.checkForNull(cstmt.getString(8));
		p_langerr_msg_txt=CommonBean.checkForNull(cstmt.getString(9));
		if(p_status.equals("E")){
			out.println(p_status+"##"+p_msg_txt+"##"+p_langerr_msg_txt);
		}else{
					out.println(p_status+"##");				
		}
	
}catch(Exception e){
		e.printStackTrace();
	}finally{
		
		
		if(cstmt!=null) cstmt.close();		
	//	if(resultset!=null) resultset.close();
		ConnectionManager.returnConnection(con,request);
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
