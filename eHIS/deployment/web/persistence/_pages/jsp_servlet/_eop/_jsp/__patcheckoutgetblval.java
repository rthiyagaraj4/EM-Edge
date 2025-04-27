package jsp_servlet._eop._jsp;

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

public final class __patcheckoutgetblval extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/PatCheckoutGetBLVal.jsp", 1728360463700L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

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

	request.setCharacterEncoding("UTF-8");
	Connection conn = null;
	CallableStatement billingCS = null;

    String  fac_id  	=	(String) session.getValue( "facility_id" ) ;

    String settle_outstanding_bills_yn		=	"";
	String p_error_level					=	"";
	String p_err_msg						=	"";
	String p_error_text						=	"";

	String bl_flag                          = request.getParameter("bl_flag");
	bl_flag           = (bl_flag==null)?"N":bl_flag;
	String bl_install_yn					= request.getParameter("bl_install_yn");
	bl_install_yn           = (bl_install_yn==null)?"":bl_install_yn;
	String P_module_id						= request.getParameter("module_id");
	P_module_id           = (P_module_id==null)?"":P_module_id; 
	String allow_chkout_with_bill_stmt_yn	= request.getParameter("allow_chkout_with_bill_stmt_yn");
	allow_chkout_with_bill_stmt_yn          = (allow_chkout_with_bill_stmt_yn==null)?"":allow_chkout_with_bill_stmt_yn; 
	String P_patient_id						= request.getParameter("patient_id");
	P_patient_id           = (P_patient_id==null)?"":P_patient_id; 
	String p_episode_id						= request.getParameter("episode_id");
	p_episode_id           = (p_episode_id==null)?"":p_episode_id;  
	String visit_id							= request.getParameter("visit_id");
	visit_id           = (visit_id==null)?"":visit_id; 
	String P_encounter_id					= request.getParameter("encounter_id");
	P_encounter_id           = (P_encounter_id==null)?"":P_encounter_id; 

	try
	{
		conn=ConnectionManager.getConnection(request);
       	if(bl_flag.equals("Y"))
		{
			if(bl_install_yn.equals("Y"))
			{
			if(P_module_id.equals("AE") && allow_chkout_with_bill_stmt_yn.equals("Y")){


				String billingSql =  "{call BLVISITREVISE.CHK_FOR_OS_UC_UP_BEF_CHKOUT(?,?,?,?,?,?,?,?,?,?,?,?)}";
				billingCS = conn.prepareCall(billingSql);
				billingCS.setString(1, fac_id);
				billingCS.setString(2, P_patient_id);
				billingCS.setString(3, "E");
				billingCS.setString(4, p_episode_id);
				billingCS.setString(5, visit_id);
				billingCS.setString(6, P_encounter_id);
				billingCS.setString(7, P_module_id);
				billingCS.setString(8, "CHECKOUT_VISIT");
				billingCS.registerOutParameter( 9,java.sql.Types.VARCHAR);
				billingCS.registerOutParameter( 10,java.sql.Types.VARCHAR);
				billingCS.registerOutParameter( 11,java.sql.Types.VARCHAR);
				billingCS.registerOutParameter( 12,java.sql.Types.VARCHAR);

				 try{
						billingCS.execute();
						settle_outstanding_bills_yn = billingCS.getString(9);
						if(settle_outstanding_bills_yn==null) settle_outstanding_bills_yn="N";
						p_error_level =  billingCS.getString(10);
						if(p_error_level==null) p_error_level=" ";
						p_err_msg =  billingCS.getString(11);
						if(p_err_msg==null) p_err_msg=" ";
						p_error_text =  billingCS.getString(12);
						if(p_error_text==null) p_error_text=" ";

					} catch(Exception e1) {
						e1.printStackTrace();
					} finally{billingCS.close();}

			  }
			  	if(bl_flag.equals("Y"))
				{
					if(!(settle_outstanding_bills_yn==null || settle_outstanding_bills_yn.equals("")))
					{
						out.println(settle_outstanding_bills_yn+"&:&"+p_error_level+"&:&"+p_err_msg+"&:&"+p_error_text);
					}
				}
		   }
	     }
	}catch(Exception ec){
	ec.printStackTrace();}
	finally
	{
		//Added by raj on 10/17/2003 while handling unclosed statements, resultsets and connections
		try{
			if(billingCS != null) billingCS.close();
		}catch(Exception e){
		e.printStackTrace();}
		if(conn!=null)
			ConnectionManager.returnConnection(conn,request);
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
