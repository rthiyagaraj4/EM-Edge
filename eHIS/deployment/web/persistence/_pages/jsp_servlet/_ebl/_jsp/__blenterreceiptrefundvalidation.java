package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.util.*;
import java.util.*;

public final class __blenterreceiptrefundvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLEnterReceiptRefundValidation.jsp", 1709114099724L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
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
	Connection con				= null;
	PreparedStatement pstmt		= null ;
	Statement stmt				= null;
	ResultSet rs				= null;	ResultSet rscurr = null;	

	try
	{
//		System.err.println("Values in BLEnterReceiptRefundValidation.jsp:"+request.getQueryString());
		con	=	ConnectionManager.getConnection(request);

		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");

		int noofdecimal=2;
		
		String locale	= (String)session.getAttribute("LOCALE");	
		if(locale==null || locale.equals("")) locale="en";	

		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";
//		System.err.println("strloggeduser" +strloggeduser);

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
//		System.err.println("strclientip "+strclientip);

		String patient_id = request.getParameter("patient_id");	
		if(patient_id==null) patient_id="";	

		
		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";	
	
		String episode_id = request.getParameter("episode_id");	
		if(episode_id==null) episode_id="";	

		String visit_id = request.getParameter("visit_id");	
		if(visit_id==null) visit_id="";	
	
		String encounter_id = request.getParameter("encounter_id");	
		if(encounter_id==null) encounter_id="";	

		String rcpt_nat_code = request.getParameter("rcpt_nat_code");	
		if(rcpt_nat_code==null) rcpt_nat_code="";	

		String rcpt_type_code = request.getParameter("rcpt_type_code");	
		if(rcpt_type_code==null) rcpt_type_code="";	

		String ext_acc_interface_yn="", str_ext_acc_facility_id = "";
		String str_ext_account_code	= "", str_ext_dept_ind = "", str_ext_dept_code = "", str_ext_dept_desc="";
		String str_reln_code		= "";

		String str_error_level = "", str_sys_message_id="", str_error_text = "";

		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{	
			noofdecimal  =  rscurr.getInt(1);
		}	
		if(rscurr != null) rscurr.close();
		pstmt.close();

		try
		{
			String query_ext_acc="Select nvl(ext_account_interface_yn,'N') ext_acc_interface from bl_parameters where operating_facility_id='"+facilityid+"'";

			stmt=con.createStatement();
			rs=stmt.executeQuery(query_ext_acc);
			if(rs != null)
			{
				while(rs.next())
				{
					ext_acc_interface_yn =rs.getString("ext_acc_interface");
//					System.err.println("ext_acc_interface_yn :"+ext_acc_interface_yn);
				}
			}
			if (rs != null)   rs.close();
			if (stmt != null) stmt.close();	
		}
		catch(Exception e )
		{
			out.println(e);
		} 

		try
		{
			CallableStatement call = 
			con.prepareCall("{ call blopin.proc_ext_acc_dtls_for_adm_dep (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");			
			call.setString(1,facilityid);
			call.setString(2,patient_id);
			call.setString(3,rcpt_nat_code);
			call.setString(4,rcpt_type_code);
			call.setString(5,episode_type);
			call.setString(6,episode_id);
			call.setString(7,visit_id);
			call.registerOutParameter(8,java.sql.Types.VARCHAR);	
			call.registerOutParameter(9,java.sql.Types.VARCHAR);	
			call.registerOutParameter(10,java.sql.Types.VARCHAR);	
			call.registerOutParameter(11,java.sql.Types.VARCHAR);	
			call.registerOutParameter(12,java.sql.Types.VARCHAR);	
			call.registerOutParameter(13,java.sql.Types.VARCHAR);	
			call.registerOutParameter(14,java.sql.Types.VARCHAR);	
			call.registerOutParameter(15,java.sql.Types.VARCHAR);	
			
			call.execute();									

			str_ext_acc_facility_id  	 = call.getString(8);	
			str_ext_account_code	 = call.getString(9);	
//			System.err.println("In validation Page str_ext_account_code:"+str_ext_account_code);
			str_ext_dept_ind		 = call.getString(10);	
//			System.err.println("In validation Page str_ext_dept_ind:"+str_ext_dept_ind);
			str_ext_dept_code     	 = call.getString(11);	
//			System.err.println("In validation Page str_ext_dept_code:"+str_ext_dept_code);
			str_reln_code		= call.getString(12);	
//			System.err.println("In validation Page str_reln_code:"+str_reln_code);			
			str_error_level		= call.getString(13);	
			str_sys_message_id	= call.getString(14);	
			str_error_text		= call.getString(15);	

			call.close();
	
			if (str_ext_acc_facility_id == null) str_ext_acc_facility_id = "";
			if (str_ext_account_code == null) str_ext_account_code = "";
			if (str_ext_dept_ind == null) str_ext_dept_ind = "";
			if (str_ext_dept_code == null) str_ext_dept_code = "";
			if (str_reln_code == null) str_reln_code = "";
			if (str_error_level == null) str_error_level = "";
			if (str_sys_message_id == null) str_sys_message_id = "";
			if (str_error_text == null) str_error_text = "";

			if((str_error_level.equals("10") && !str_error_text.equals("")) || !str_sys_message_id.equals(""))
			{
				if(str_error_level.equals("10") && !str_error_text.equals(""))
				{
					out.println("E"+"&^&"+str_error_text);
				}
				else if(!str_sys_message_id.equals(""))
				{
					out.println("M"+"&^&"+str_sys_message_id);
				}
			}
			else
			{
				if(str_ext_dept_ind.equals("S"))
				{
					try
					{
						String query_ext_acc="select short_desc from sy_dept_LANG_VW where nvl(status,'x') != 'S' AND   UPPER(LANGUAGE_ID) = UPPER('"+locale+"') and operating_facility_id = '"+facilityid+"' and dept_code ='"+str_ext_dept_code+"'";

						stmt=con.createStatement();
						rs=stmt.executeQuery(query_ext_acc);
						if(rs != null)
						{
							while(rs.next())
							{
								str_ext_dept_desc =rs.getString(1);
//								System.err.println("str_ext_dept_desc :"+str_ext_dept_desc);
							}
						}
						if (rs != null)   rs.close();
						if (stmt != null) stmt.close();	
					}
					catch(Exception e )
					{
						out.println(e);
					}
				}
				out.println("Y"+"&^&"+str_ext_acc_facility_id+"&^&"+str_ext_account_code+"&^&"+str_ext_dept_ind+"&^&"+str_ext_dept_code+"&^&"+str_ext_dept_desc);
			}

		}
		catch(Exception e )
		{
			//System.err.println("Exception while calling proc_ext_acc_dtls_for_adm_dep:"+e);
			//out.println(e);
			e.printStackTrace();
		}
	}
	catch(Exception e )
	{ 
		System.err.println("BLEnterServiceSerachResult:"+e);
	}
	finally
	{	
		if(stmt != null)		stmt.close();
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
