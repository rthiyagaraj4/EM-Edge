package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __positionforinterventionintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/PositionForInterventionIntermediate.jsp", 1709116606371L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t   <script>\n\t\t\tvar temp = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\t\t\tvar opt=parent.frames[1].frames[0].document.createElement(\"OPTION\");\n\t\t\topt.text=temp;\n\t\t\topt.value=temp1;\n\t\t\tvar comp=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =";\n\t\t\tcomp.add(opt)\n       </script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
   
//This file is saved on 18/10/2005.
		String  role_type = request.getParameter("role_type");
		String sql="";
		String locale			= (String)session.getAttribute("LOCALE");
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rset=null;

		String code1="";
		String desc="";
		String comp=" ";

		con = ConnectionManager.getConnection(request);
			
try
	{	
if(role_type.equals("P"))
   {
			//sql = "select pract_type, desc_userdef from am_pract_type where eff_status = 'E' order by desc_userdef";
			sql = "SELECT pract_type, desc_userdef FROM am_pract_type_lang_vw WHERE eff_status = 'E' and language_id = '"+locale+"' ORDER BY desc_userdef";
			comp="parent.frames[1].frames[0].document.forms[0].staff_type";
    }
else
	{
	//sql="select other_staff_type, short_desc from am_other_staff_type where eff_status = 'E' order by short_desc";
	sql="SELECT other_staff_type, short_desc FROM am_other_staff_type_lang_Vw WHERE eff_status = 'E' and language_id = '"+locale+"' ORDER BY short_desc";
    comp="parent.frames[1].frames[0].document.forms[0].staff_type";
	}
		stmt = con.prepareStatement(sql);
		rset = stmt.executeQuery();
				
		out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link></HEAD><body CLASS='MESSAGE'><form name='name1' id='name1'>");

		while( rset.next() ) 
		{
			desc=rset.getString(1);
			code1=rset.getString(2);
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(code1));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(comp));
            _bw.write(_wl_block5Bytes, _wl_block5);
	
		}
	}
	catch(Exception e){out.print(e);out.print("<br>sql:"+sql);}
	finally {
		if (rset != null) rset.close();
		if (stmt != null) stmt.close();
    	ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block6Bytes, _wl_block6);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
