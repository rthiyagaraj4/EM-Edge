package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import webbeans.eCommon.*;

public final class __blauthforprivvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAuthForPrivValidation.jsp", 1709114083459L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null;
	CallableStatement cstmt =null;
	PreparedStatement stmt=null;
	ResultSet rs1=null;
	String usr_id="",pass_wd="",remarks="",valid_user_rec_found_YN="N",pass_word="";	
	String  query_elgb_user="", valid_eligible_user="";		
	String priv_code = "";
	String  p_privilege_val="";
	String  p_allowed_yn="";
	try
	{
		con	=	ConnectionManager.getConnection(request);
		String facility_id  =  (String) session.getValue("facility_id") ;
		request.setCharacterEncoding("UTF-8");
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		hash						= (Hashtable)hash.get( "SEARCH" ) ;
		usr_id	= 	(String) hash.get( "usr_id");
		pass_wd	= 	(String) hash.get( "pass_wd");
 		priv_code	= 	(String) hash.get( "priv_code");
		
		if(usr_id==null) usr_id="";
		usr_id=usr_id.trim();
		if(pass_wd==null) pass_wd="";
		pass_wd=pass_wd.trim();		
		if(priv_code==null)priv_code="";
		priv_code=priv_code.trim();
		
		String functionID = request.getParameter("functionID");
		if(functionID==null) functionID="";
		
		String prespid = request.getParameter("prespid");
		if(prespid==null) prespid="";
		
		String payer_group = request.getParameter("payer_group");
		if(payer_group==null) payer_group="";
		
		String payer = request.getParameter("payer");
		if(payer==null) payer="";
		
		String policy = request.getParameter("policy");
		if(policy==null) policy="";
		
		String currentdate = request.getParameter("currentdate");
		if(currentdate==null) currentdate="";
		
		
		try{
			cstmt = con.prepareCall("{ call blpolicyuseraccessdtls.get_bl_policy_privlege_yn(?,?,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),?,?)}");
			cstmt.setString(1, facility_id);
			cstmt.setString(2, usr_id);
			cstmt.setString(3, prespid);
			cstmt.setString(4, functionID);
			cstmt.setString(5, payer_group);
			cstmt.setString(6, payer);
			cstmt.setString(7, policy);
			cstmt.setString(8, priv_code);
			cstmt.setString(9, currentdate);
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			cstmt.registerOutParameter(11, java.sql.Types.VARCHAR);
			cstmt.execute();	
			p_privilege_val = cstmt.getString(10);
			p_allowed_yn = cstmt.getString(11);
			System.err.println("password check in BLAuthForPrivValidation.jsp"+p_privilege_val+"::"+p_allowed_yn);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}		
			
			
		String query_pass_wd="select nvl(app_password.decrypt(pin_no),'~!@') as pass_wd from sm_appl_user where appl_user_id='"+usr_id+"' ";
		System.err.println("	query_pass_wd:"+query_pass_wd);
		
		//Added V190828-Gomathi/GHL-SCF-1436 Starts
		query_elgb_user=" select eff_status from sm_appl_user a, sm_facility_for_user b where b.appl_user_id = a.appl_user_id  and a.appl_user_id= '"+usr_id+"' and facility_id = '"+facility_id+"' ";
		System.err.println("	query_elgb_user:"+query_elgb_user);
		
		
		stmt = con.prepareStatement(query_elgb_user);	
		rs1 = stmt.executeQuery();
		while(rs1!=null && rs1.next())
		{	
			valid_eligible_user = rs1.getString(1);
		}
		//Added V190828-Gomathi/GHL-SCF-1436 Ends

		if(p_privilege_val.equals("Y") &&  p_allowed_yn.equals("Y"))
		{
			valid_user_rec_found_YN = "Y";
			stmt = con.prepareStatement(query_pass_wd);
			rs1 = stmt.executeQuery();
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
		
		
		pass_word=pass_word.toUpperCase();
		pass_wd=pass_wd.toUpperCase();
		
		if(valid_eligible_user.equals("E")){
			if(valid_user_rec_found_YN.equals("Y"))
			{
				if(pass_word.equals(pass_wd)){			
					out.println("Y:::"+valid_eligible_user);	//valid user					
				}
				else{
					out.println("P:::"+valid_eligible_user);	//Invalid pin						
				}
			}
			else{
					out.println("A:::"+valid_eligible_user);	//Invalid priv		
				}
		}else{
			out.println("U:::"+valid_eligible_user);	//Invalid user	
		}
			
			
	}
	catch(Exception e)
	{
		e.printStackTrace();
		out.println("Exception@1 : "+e);
	}
	finally
	{
		if (rs1 != null)   rs1.close();
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
