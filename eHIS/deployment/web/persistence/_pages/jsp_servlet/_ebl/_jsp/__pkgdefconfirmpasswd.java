package jsp_servlet._ebl._jsp;

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

public final class __pkgdefconfirmpasswd extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/PkgDefConfirmPassWd.jsp", 1709114706429L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\'../js/PkgDef.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n</head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<body onLoad=\"call_pass_valid();\">\n\t<form>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<input type=\'hidden\' name=\'user\' id=\'user\' value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<input type=\'hidden\' name=\'err_msg\' id=\'err_msg\' value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t<input type=\'hidden\' name=\'remarks\' id=\'remarks\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type=\'hidden\' name=\'valid_user_rec_found_YN\' id=\'valid_user_rec_found_YN\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\'hidden\' name=\'valid_eligible_user\' id=\'valid_eligible_user\' value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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

/*
Sr No        Version           TFS/Incident        SCF/CRF            		 		 Developer Name
--------------------------------------------------------------------------------------------------------
1		    V220323	    		27763			  MMS-ME-SCF-0052 					   Mohana Priya K
--------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

Connection con = null;
ResultSet rs=null;
ResultSet rs1=null;
String usr_id="";
String valid_user_rec_found_YN="N";
String pass_wd="";
String remarks="";
String pass_word = "";
String err_val="";//V220323
String query_usr_id ="";
String query_pass_wd="";
String query_elgb_user="", valid_eligible_user="";	
PreparedStatement pstmt = null;
try
{
	con	=	ConnectionManager.getConnection(request);
	String facility_id  =  (String) session.getValue("facility_id") ;
	request.setCharacterEncoding("UTF-8");
	usr_id	= 	request.getParameter("usr_id");
	pass_wd	= 	request.getParameter("pass_wd");
	remarks	= 	request.getParameter("remarks");
	if(usr_id==null) usr_id="";
		usr_id=usr_id.trim();
	if(pass_wd==null) pass_wd="";
		pass_wd=pass_wd.trim();
	if(remarks==null)remarks="";
		remarks=remarks.trim();

            _bw.write(_wl_block7Bytes, _wl_block7);

		query_usr_id ="Select 'X' from bl_users_for_credit_auth where operating_facility_id = ? and ((nvl(package_definition_change_yn,'N')='Y') or (nvl(credit_auth_yn,'N')='Y' )) and credit_auth_user_id=?";
	
		query_pass_wd="select nvl(app_password.decrypt(pin_no),'~!@') as pass_wd from sm_appl_user where appl_user_id=? ";
		
		/* Fixed SQL Injection for Common-ICN-0222 */
		pstmt = con.prepareStatement(query_usr_id);
		pstmt.setString(1, facility_id);
		pstmt.setString(2, usr_id);
		rs = pstmt.executeQuery();
		if(rs.next())
		{
			valid_user_rec_found_YN = "Y";
			pstmt = con.prepareStatement(query_pass_wd);
			pstmt.setString(1, usr_id);
			rs1 = pstmt.executeQuery();
			while((rs1.next()))
			{
				pass_word = rs1.getString("pass_wd");
			}
			pass_word=pass_word.trim();
		}
		else
		{
			valid_user_rec_found_YN="N";
		}
		//Added V190828-Gomathi/GHL-SCF-1436 Starts
		query_elgb_user=" select eff_status from sm_appl_user a, sm_facility_for_user b where b.appl_user_id = a.appl_user_id  and a.appl_user_id= ? and facility_id = ? ";
		/* Fixed SQL Injection for Common-ICN-0222 */
		pstmt = con.prepareStatement(query_elgb_user);
		pstmt.setString(1, usr_id);
		pstmt.setString(2, facility_id);
		rs1 = pstmt.executeQuery();
		while(rs1!=null && rs1.next())
		{	
			valid_eligible_user = rs1.getString(1);
		}
		//Added V190828-Gomathi/GHL-SCF-1436 Ends
		
		//V220323 Starts
		System.err.println("124,valid_eligible_user-"+valid_eligible_user);
		if(valid_eligible_user.equals("D"))	
			{
				err_val="BL1025";
				
			}
		
		if(valid_user_rec_found_YN.equals("N"))
		{
			err_val="BL9539";
		}
		else if(!(pass_word.toUpperCase()).equals(pass_wd.toUpperCase()))
			{
				err_val="BL1232";
			}
			//V220323 ends
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(usr_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(err_val));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(valid_user_rec_found_YN));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(valid_eligible_user));
            _bw.write(_wl_block13Bytes, _wl_block13);

	}
	catch(Exception e)
	{
		e.printStackTrace();
		out.println("Exception PkgDefConfirmPassWd : "+e);
	}
	finally
	{
		if (rs != null)   rs.close();
		if (rs1 != null)   rs1.close();
		if(pstmt!=null)	pstmt.close();
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
