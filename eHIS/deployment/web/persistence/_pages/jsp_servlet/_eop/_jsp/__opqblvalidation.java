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
import eDS.Common.JSONObject;

public final class __opqblvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/OPQBLValidation.jsp", 1729065966418L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="          \n            \n            \n";
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
	try{
		/*out.println("facility_id==> "+request.getParameter("facility_id"));
		out.println("p_patient_id==> "+request.getParameter("p_patient_id"));
		out.println("p_episode_type==> "+request.getParameter("p_episode_type"));
		out.println("p_episode_id==> "+request.getParameter("p_episode_id"));
		out.println("p_visit_id==> "+request.getParameter("p_visit_id"));*/
		String facility_id		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
		String p_patient_id		= request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
		String p_episode_type	= request.getParameter("p_episode_type")==null?"":request.getParameter("p_episode_type");
		int p_episode_id		= Integer.parseInt(request.getParameter("p_episode_id"));
		int p_visit_id			= Integer.parseInt(request.getParameter("p_visit_id"));
		int IsResult			= 0;
		JSONObject json			= new JSONObject();

		
		
		conn=ConnectionManager.getConnection(request);
		String billingSql =  "{call blcommonproc.get_unbilled_unsettled_amt(?,?,?,?,?,?,?)}";
		billingCS = conn.prepareCall(billingSql);
		billingCS.setString(1, facility_id);
		billingCS.setString(2, p_patient_id);
		billingCS.setString(3, p_episode_type);
		billingCS.setInt(4, p_episode_id);
		billingCS.setInt(5, p_visit_id);
		billingCS.registerOutParameter( 6,java.sql.Types.INTEGER);
		billingCS.registerOutParameter( 7,java.sql.Types.INTEGER);
		 try{
				billingCS.execute();
				int p_unbilled_amt 	= billingCS.getInt(6);
				int p_unsettled_amt	= billingCS.getInt(7);
				IsResult		= 1;
				json.put("p_unbilled_amt", p_unbilled_amt);
				json.put("p_unsettled_amt", p_unsettled_amt);
			} catch(Exception e1) {
				e1.printStackTrace();
			} finally{billingCS.close();}
		 
		 json.put("IsResult", IsResult);
		 out.print(json);
	
	}catch(Exception e) { 
		e.printStackTrace();
		
	}finally{ 
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
