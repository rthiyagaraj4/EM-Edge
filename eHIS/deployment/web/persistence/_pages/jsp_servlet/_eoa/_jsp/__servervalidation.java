package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __servervalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/ServerValidation.jsp", 1709119276381L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n\n\n";
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
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

Connection con = null;
ResultSet rs=null;
ResultSet rs1=null;
Statement stmt = null;
Statement stmt1 = null;
PreparedStatement pstmt=null;
try{
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
 stmt = con.createStatement();
 stmt1 = con.createStatement();
String to_date = request.getParameter("to_date");
String from_date=request.getParameter("from_date");
if(to_date == null || to_date.equals("null") )	to_date=from_date;
if(from_date == null || from_date.equals("null")) from_date=to_date;

	String wd1="";
	String wd2="";
	
	//String sql="select to_date('"+to_date+"', 'dd/mm/yyyy') - to_date('"+from_date+"', 'dd/mm/yyyy') from dual";
	String sql="select to_date(?, 'dd/mm/yyyy') - to_date(?, 'dd/mm/yyyy') from dual";
		//rs = stmt.executeQuery(sql);
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,to_date);
		pstmt.setString(2,from_date);
		rs = pstmt.executeQuery();
		while(rs.next()){
		wd1 = rs.getString(1);
		}
		
	//String sql2="select to_char(to_date('"+from_date+"','dd/mm/yyyy')+30,'dd/mm/yyyy') from dual";
	String sql2="select to_char(to_date(?,'dd/mm/yyyy')+30,'dd/mm/yyyy') from dual";
	//rs1=stmt1.executeQuery(sql2);
		pstmt = con.prepareStatement(sql2);
		pstmt.setString(1,from_date);
		rs1 = pstmt.executeQuery();
		while(rs1.next()){
		wd2= rs1.getString(1);
		}
	
int check=Integer.parseInt(wd1);
if(check > 29 ){
	String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>parent.frames[1].document.frames[1].document.forms[0].prefenddate.value='"+wd2+"';</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
out.println(a1);
	}
	else	
	{
	String a1="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/'"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script>"
		+"</script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";
	out.println(a1);
	}

}catch(Exception e){out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/'"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body>"); }
finally{

if(rs !=null) rs.close();
if(rs1 !=null) rs1.close();
if(stmt !=null) stmt.close();
if(stmt1 !=null) stmt1.close();
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
