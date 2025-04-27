package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __qapopulateschemetype extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAPopulateSchemeType.jsp", 1742817545940L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></Script>\n\n";
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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);


String diagnosis = request.getParameter("diagnosis")==null?"":request.getParameter("diagnosis");
String scheme_type = "";

PreparedStatement pstmt =null;
ResultSet rs = null;
Connection conn = ConnectionManager.getConnection(request);
try
{
	pstmt = conn.prepareStatement("select diag_coding_scheme,proc_coding_scheme from mr_param ");
	rs = pstmt.executeQuery();
	if(rs!=null)
	{
		while(rs.next())
		{
	if(diagnosis.equals("D"))
	{
		scheme_type = rs.getString(1);
	}
	else if(diagnosis.equals("P"))
	{
		scheme_type = rs.getString("PROC_CODING_SCHEME");
		
	}
	}
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
}catch(Exception ee)
{
out.println("Error"+ee);
}  
finally
{
   ConnectionManager.returnConnection(conn,request);
}
out.println("<script>var obj=parent.f_query_add_mod.document.getElementById('schema_type');</script>");
        out.println("<script> var length = obj.length;for(i=0;i<length;i++) obj.remove(1);</script>");
if(diagnosis.equals("D"))
	{
       	out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='ICD10';</script>");
        out.println("<script>opt.value='1';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').add(opt)</script>");
		out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
        out.println("<script>opt.text='ICD9-CM';</script>");
        out.println("<script>opt.value='2';</script>");
		out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').add(opt)</script>");
if(scheme_type.equals("1"))
{
out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').options[1].selected=true</script>");
}
if(scheme_type.equals("2"))
{
out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').options[2].selected=true</script>");
}
	}
	else if(diagnosis.equals("P"))
	{
	out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
	out.println("<script>opt.text='CPT4';</script>");
	out.println("<script>opt.value='3';</script>");
	out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').add(opt)</script>");
	out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
	out.println("<script>opt.text='ICD9-CM';</script>");
	out.println("<script>opt.value='4';</script>");
	out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').add(opt)</script>");
	out.println("<script>opt=parent.f_query_add_mod.document.createElement('OPTION');</script>");
	out.println("<script>opt.text='ICD10-PCS';</script>");
	out.println("<script>opt.value='6';</script>");
	out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').add(opt)</script>");
if(scheme_type.equals("3"))
{
out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').options[1].selected=true</script>");
}
if(scheme_type.equals("4"))
{
out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').options[2].selected=true</script>");
}
if(scheme_type.equals("6"))
{
out.println("<script>parent.f_query_add_mod.document.getElementById('schema_type').options[3].selected=true</script>");
}
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
