package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __confirmpasswdform extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/ConfirmPassWdForm.jsp", 1709121696198L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<script>\n\tfunction call_pass_valid()\n\t{ \n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\tvar pin_check = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\t\n\tvar returnArray=false;\t\n\tif(pin_check ==\'Y\')\n\t{\n\t\treturnArray = true;\n\t\tparent.window.returnValue=returnArray;\n\t\tparent.window.close();\n\t}\n\telse\n\t\t{\n\t\talert(getMessage(\'INVALID_USER_PIN\',\'SM\')); \n\t\tparent.window.returnValue=returnArray;\n\t\t}\n\t}\n</script>\n<body onLoad=\"call_pass_valid();\">\n<form>\t\n\t<input type=\'hidden\' name=\'user\' id=\'user\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t<input type=\'hidden\' name=\'err_msg\' id=\'err_msg\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	Connection con = null;
	PreparedStatement stmt		 = null;
	//Statement stmt=null;
	ResultSet rs=null;
	String err_msg="";
	String usr_id="",pass_wd="", resp_id="", func_id="", a="", b="";//Modified by Ajay for MMS-DM-CRF-0209.4
	String valid_user_rec_found_YN = "NULL";
	//String temp_pwd = "";
	int check = 0;	
	try
	{
		con	=	ConnectionManager.getConnection(request);
		String facility_id  =  (String) session.getValue("facility_id") ;
		request.setCharacterEncoding("UTF-8");
		usr_id	= 	request.getParameter("usr_id");
		pass_wd	= 	request.getParameter("pass_wd");	
		resp_id	= 	request.getParameter("resp_id");
		func_id	= 	request.getParameter("func_id");
		

            _bw.write(_wl_block7Bytes, _wl_block7);

	//Modified by Ajay H. for MMS-DM-CRF-0209.4
	if(func_id.equals("PROCESS_REF")){
		String	query_usr_id = "select count(1) from sm_appl_user A where A.appl_user_id = ? and lower(APP_PASSWORD.DECRYPT(A.PIN_NO)) = lower(?) and A.EFF_STATUS = 'E'";
	stmt = con.prepareStatement(query_usr_id);	
	try{ 
	stmt.setString(1,usr_id);
	stmt.setString(2,pass_wd);
	rs = stmt.executeQuery();	
	if(rs.next())
	{
		check =rs.getInt(1);
		if(check>0)
		{
			valid_user_rec_found_YN="Y";

		}
		else
		{
			valid_user_rec_found_YN="N";
		}
	}
	else
	{
		valid_user_rec_found_YN="N";
	}
	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception occurred in ConfirmPassWdForm.jsp : "+e);	
	}
	}else{
	
	String	query_usr_id = "select count(1) from sm_appl_user A inner join mr_user_access_rights B on A.APPL_USER_ID = B.APPL_USER_ID where A.appl_user_id = ? and B.ENABLE_EMIRATES_ID_YN = 'Y' and lower(APP_PASSWORD.DECRYPT(A.PIN_NO)) = lower(?)";
	stmt = con.prepareStatement(query_usr_id);	
	try{ 
	stmt.setString(1,usr_id);
	stmt.setString(2,pass_wd);
	rs = stmt.executeQuery();	
	if(rs.next())
	{
		check =rs.getInt(1);
		if(check>0)
		{
			valid_user_rec_found_YN="Y";		
		}
		else
		{
			valid_user_rec_found_YN="N";
		}
	}
	else
	{
		valid_user_rec_found_YN="N";
	}
	}catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception occurred in ConfirmPassWdForm.jsp : "+e);	
	}
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(valid_user_rec_found_YN));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(usr_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(err_msg));
            _bw.write(_wl_block11Bytes, _wl_block11);

	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if (rs != null)   rs.close();
		if(stmt!=null)	stmt.close();	
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
