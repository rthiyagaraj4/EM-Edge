package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __vwpatfiledetailbd extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/vwPatFileDetailbd.jsp", 1709119142207L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n<HTML>\n<HEAD>\n<TITLE></TITLE>\n<META NAME=\"Generator\" CONTENT=\"EditPlus\">\n<META NAME=\"Author\" CONTENT=\"\">\n<META NAME=\"Keywords\" CONTENT=\"\">\n<META NAME=\"Description\" CONTENT=\"\">\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\tfunction openHistory(){\t\n\n\t\n\t\t var ie7 = (document.all && !window.opera && window.XMLHttpRequest) ? true : false;  \n\t     if (ie7) {\t\t\t  \n\t\t\t   window.open(\'\',\'_parent\',\'\');\n\t\t\t   window.close();\n           }else{\t\t\t\n\t\t\t   this.focus();\n\t\t\t   self.opener = this;\t\t\t \n\t\t\t   self.close();\n           }\t\t\n\t\t\t\t/*\n\t\t\t\tvar dialogHeight= \"75\" ; \n\t\t\t\tvar dialogWidth\t= \"60\" ;\n\t\t\t\tvar dialogTop\t= \"\";\n\t\t\t\tvar center = \"1\" ;\n\t\t\t\tvar status=\"no\";\n\t\t\t\tvar arguments\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; resizable:no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\t\t\tvar features\t= \"\" ;\t\t\t \n\t\t\t\tvar url=\'../../eMR/jsp/vwPatFileDetailmain.jsp?Patient_Id=";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="&function_id=";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="&p_user_password=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&login_user=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'\t\t\t \t\t\t\t\n\t\t\t\t*/\n\t\t\t\twindow.open(\'../../eMR/jsp/vwPatFileDetailmain.jsp?Patient_Id=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\',\'eHIS\',\'location=0,height=700,width=1015,top=0,left=0,resizable=yes\');\t\n\t\t\t}\n</script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script><Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n</HEAD>\n<body onload=\'openHistory()\'>\n</BODY>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

Connection con = null;
PreparedStatement pstmtValidUser=null; 
ResultSet rset =null;

try{

	request.setCharacterEncoding("UTF-8");
	String patient_id = request.getParameter("Patient_Id") == null ? "" : request.getParameter("Patient_Id");
	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
	String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");	
	String login_user = request.getParameter("login_user") == null ? "" : request.getParameter("login_user");	
	String p_user_password = request.getParameter("p_user_password") == null ? "" : request.getParameter("p_user_password");	

		session.putValue("LOCALE",locale);		

	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String responsibility_id=request.getParameter("responsibility_id")==null?"":request.getParameter("responsibility_id");
	
	String client_ip_address = "";
	client_ip_address = request.getRemoteAddr();
 
	String jdbc_props = "";
	String preferred_style = "";
	String facility_name = "";
	if ( function_id == null )
	function_id="";

	String file_type_appl_yn = "";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
 

	
	
	//	session.putValue("responsibility_id",responsibility_id);
		session.putValue("facility_id",facility_id);
	//	session.putValue("login_user",login_user);
		session.putValue("connection_pooling_yn","Y");
		Properties p = new Properties() ;
		p.setProperty( "login_user",login_user) ;
		p.setProperty("connection_pooling_yn","Y") ;
		p.setProperty("client_ip_address",client_ip_address) ;
		p.setProperty("jdbc_props",jdbc_props) ;
		p.setProperty("LOCALE",locale) ;
		session.putValue( "jdbc",p ) ;
	 

	 con =  ConnectionManager.getConnection(request);

	 String strSqlValidUser = "select preferred_style,(select facility_name from sm_facility_param where facility_id=?) facility_name  from sm_appl_user where APPL_USER_ID=? and APPL_USER_PASSWORD=? ";

	 pstmtValidUser = con.prepareStatement(strSqlValidUser);
	pstmtValidUser.setString(1,facility_id);
	pstmtValidUser.setString(2,login_user.trim());
	pstmtValidUser.setString(3,p_user_password.trim());
	rset = pstmtValidUser.executeQuery();
	
	if(rset !=null && rset.next()){
		
		preferred_style = rset.getString("preferred_style");
		facility_name = rset.getString("facility_name");
				
		if(facility_name == null || facility_name.equals(""))
            facility_name = "";
		//out.println("preferred_style"+preferred_style);
           if(preferred_style == null || preferred_style.equals(""))
            preferred_style = "IeStyle.css";
		session.putValue("PREFERRED_STYLE",preferred_style);
		session.putValue("facility_name",facility_name);
		rset.close();
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(p_user_password));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(p_user_password));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block7Bytes, _wl_block7);
} catch(Exception e){
	e.printStackTrace();
}finally{		 
	if (rset !=null) rset.close();
	if (pstmtValidUser!=null) pstmtValidUser.close(); 
	if(con!=null)ConnectionManager.returnConnection(con,request);		
}
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
