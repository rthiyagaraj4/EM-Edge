package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __serverfunction extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/ServerFunction.jsp", 1741166234834L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");	
	String pr_id = request.getParameter("process_d");

	int process = Integer.parseInt(pr_id);
	Connection con		= null;
	Statement stmt		=	null;
	Statement stmt1		=	null;
	ResultSet rs			=	null;
	ResultSet rset		=	null;
	StringBuffer sbQuery = new StringBuffer();

	try
	{
		con = ConnectionManager.getConnection(request);
			
			if ( process == 1 )
			{
					stmt = con.createStatement();
					int DAYS,MONTHS,AGE;
					
					String DOB=request.getParameter("date_of_birth");
                    out.println(DOB);
					sbQuery.append(	"select calculate_age('"+DOB+"',1) from dual");
					
					rs = stmt.executeQuery(sbQuery.toString());
					rs.next();
					AGE = rs.getInt(1);
                    if(rs!=null) rs.close();
					if(stmt!=null) 	stmt.close();
					sbQuery.append(	"select calculate_age('"+DOB+"',2) from dual");
					
					stmt = con.createStatement();
					rs = stmt.executeQuery(sbQuery.toString());
					rs.next();
					MONTHS = rs.getInt(1);

                    if(stmt!=null) 	stmt.close();
					sbQuery.append(	"select calculate_age('"+DOB+"',3) from dual");
					
					stmt = con.createStatement();
					if(rs!=null) 	rs.close();
					rs = stmt.executeQuery(sbQuery.toString());
					rs.next();
					DAYS = rs.getInt(1);

					if(stmt!=null) 	stmt.close();

					String htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'>parent.f_query_add_mod.practitioner_sub.document.getElementById('b_age').value='"+AGE+"';parent.f_query_add_mod.practitioner_sub.document.getElementById('b_months').value='"+ MONTHS +"';parent.f_query_add_mod.practitioner_sub.document.getElementById('b_days').value='"+DAYS+"';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></body></html>";
					out.println(htmlVal);
			}
			if ( process == 2 )
				{

					stmt1 = con.createStatement();

					String DAYS,MONTHS,AGE;
					
					DAYS = request.getParameter("b_days");
					MONTHS = request.getParameter("b_months");
					AGE = request.getParameter("b_age");

					if ( DAYS.equals("") )
						DAYS = "null";
					if ( MONTHS.equals("") )
						MONTHS = "null";
					if ( AGE.equals("") )
						AGE = "null";

					String DOB;
				
					String sql1 = "select calculate_date_of_birth ("+AGE+","+MONTHS+","+DAYS+") from dual";
					rset = stmt1.executeQuery(sql1);
					rset.next();
					DOB = rset.getString(1);

					if ( DOB == "" || DOB == null )
						DOB = "";

					String htmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><script language='javascript'> parent.f_query_add_mod.practitioner_sub.document.getElementById('date_of_birth').value='"+DOB+"';</script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><input type='hidden' name='result' id='result' value='"+DOB+"'</body></html>";
					out.println(htmlVal);
			} 
		if (rs != null)   rs.close();
		if (rset != null)   rset.close();
		if (stmt != null) stmt.close();
		if (stmt1 != null) stmt1.close();
	}
	catch(Exception e) 
	{
		out.println(e.toString());
	}
	finally
	{
	  ConnectionManager.returnConnection(con,request);

	}



            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
