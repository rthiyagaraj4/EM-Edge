package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __autopsynumber extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emo/jsp/AutopsyNumber.jsp", 1724396267932L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

		Connection conn              = null;
		ResultSet rs	             = null;
		java.sql.Statement stmt	             = null;
	try
	{
		 
        request.setCharacterEncoding("UTF-8");
		String facilityId            = (String) session.getValue("facility_id");
		Hashtable hash               = (Hashtable)obj.parseXMLString( request ) ;
		hash                         = (Hashtable)hash.get("SEARCH") ;
		String prefix_facility_id_yn = (String)hash.get("prefix_facility_id_yn");
		String suffix_facility_id_yn = (String)hash.get("suffix_facility_id_yn");
		String prefix_year_yn        = (String)hash.get("prefix_year_yn");
		String suffix_year_yn        = (String)hash.get("suffix_year_yn");
		String start_num             = (String)hash.get("start_num");
		String year                  = "";
		String final_result          = "";
		conn                         = ConnectionManager.getConnection(request);
		stmt                         = conn.createStatement();
		rs                           = stmt.executeQuery("select to_char(sysdate,'yyyy') from dual");
		if(rs!=null)
		{
		 while(rs.next())
			{
				year = rs.getString(1);
			}
		}
		if(rs != null)	rs.close();	
		if(stmt !=null) stmt.close();
		if(prefix_facility_id_yn.equals("Y"))
			final_result = final_result + facilityId;
		if(prefix_year_yn.equals("Y"))
		    final_result = final_result + year;
		stmt             = conn.createStatement();
		rs               = stmt.executeQuery("select trim(to_char('"+start_num+"','0000000000')) anumber from dual");
		if(rs!=null)
		{
			while(rs.next())
			{
				final_result =  final_result+rs.getString("anumber");
			}
		}
		if(suffix_facility_id_yn.equals("Y"))
			final_result    = final_result + facilityId;
		if(suffix_year_yn.equals("Y"))
			final_result    = final_result + year;
			out.println(final_result);
		if(rs != null)	rs.close();	
		if(stmt !=null) stmt.close();
	hash.clear();
	}
	catch(Exception e) {out.println(e.toString());}
	finally
	{
		if(conn !=null) ConnectionManager.returnConnection(conn,request);
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
