package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __icdfordiaggrouppopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/ICDForDiagGroupPopulate.jsp", 1741325214101L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n     ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="     \n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}


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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);

		request.setCharacterEncoding("UTF-8");
        Connection conlConn = null;
		PreparedStatement stmt = null;
		ResultSet rstlRs = null;
		String speciality_code="",practitioner_id="",diag_group_code="";
		String speciality_desc="",practitioner_name="",facility_name="",group_type="";
	try
	{
	      out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></HEAD><body  onKeyDown = 'lockKey()' CLASS='MESSAGE'><form name='nam1' id='nam1'>");

  	       group_type= request.getParameter("group_type");
	       if(group_type == null) group_type="";

	       diag_group_code = request.getParameter("diag_group_code");
	       if(diag_group_code == null) diag_group_code="";
	       
	       speciality_code = request.getParameter("speciality_code");
	       if(speciality_code == null) speciality_code="";
	       
	       practitioner_id = request.getParameter("practitioner_id");
	       if(practitioner_id == null) practitioner_id="";
	       
	       String sql=" select facility_name,practitioner_name ,d.short_desc from mr_diag_group a,sm_facility_param b,am_practitioner c,am_speciality d where a.facility_id=b.facility_id (+) and a.practitioner_id=c.practitioner_id(+) and a.speciality_code = d.speciality_code(+) and a.diag_group_code =? and group_type = ? ";
		   
		   conlConn = ConnectionManager.getConnection(request);	
	       
		   stmt= conlConn.prepareStatement(sql);
			stmt.setString(1,diag_group_code);
			stmt.setString(2,group_type);
	       rstlRs = stmt.executeQuery();
	       
           	if(rstlRs.next() && rstlRs!=null)
	       	{
				speciality_desc = rstlRs.getString("short_desc");
				if(speciality_desc == null) speciality_desc="";
				practitioner_name=rstlRs.getString("practitioner_name");
				if( practitioner_name == null ) practitioner_name ="";
				facility_name=rstlRs.getString("facility_name");
				if(facility_name == null) facility_name="";
				String group_type_disp="";
				if (group_type.equals("D")) group_type_disp="Diagnosis";
				else
					group_type_disp="Procedure";
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('speciality_disp').innerText='Speciality '</script>");
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('facility_disp').innerText='Facility  '</script>");
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('pract_disp').innerText='Practitioner '</script>");
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('diag_code_desc').innerText='    Code Scheme  '</script>");
	       	
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('group_type').innerText='Type  '</script>");
			out.println("<script>parent.frames[1].frames[0].document.getElementById('group_type_disp').innerText=\""+group_type_disp+"\"</script>");
			out.println("<script>parent.frames[1].frames[0].document.getElementById('speciality').innerText=\"  "+speciality_desc+"\"</script>");
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('practitioner').innerText=\"  "+practitioner_name+"\"</script>");
	       	out.println("<script>parent.frames[1].frames[0].document.getElementById('facility').innerText=\""+facility_name+"\"</script>");
	       	       
	    }
 	}catch(Exception e){
			//out.println("Exception @ try "+e.toString());
			e.printStackTrace();
    }finally{

		try
		{
            if(stmt != null){ stmt.close(); }
            if(rstlRs != null){ rstlRs.close(); }	     
		}
		catch(Exception e){
			//out.println("Exception @ finally "+e.toString());
			e.printStackTrace();
    }
			    ConnectionManager.returnConnection(conlConn,request);
     	}

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
