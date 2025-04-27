package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __newprocedurecodevalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/NewProcedureCodeValidation.jsp", 1709119748000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
Connection con=null;
PreparedStatement stmt = null;
ResultSet rs = null ;
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
try
{

	String term_set_id   =  request.getParameter("term_set_id")== null?"":request.getParameter("term_set_id");
	term_set_id          =  term_set_id.trim();
	String term_code	 =  request.getParameter("term_code")==null?"":request.getParameter("term_code");
	term_code			 =  term_code.trim();

	if (!(term_set_id.equals("") && term_code.equals(""))){		

		con=ConnectionManager.getConnection(request);
		
		boolean rs_chkk=false;
		String long_desc	= "";
		String short_desc	= "";
		
		String term_code_sql= "";

		if (!term_code.equals(""))
		{

			term_code_sql="select term_code,short_desc ,long_desc from mr_term_code where term_set_id like upper(?) and term_code like upper(?)";

			stmt = con.prepareStatement(term_code_sql);
			stmt.setString(1,term_set_id);//term_set_id
			stmt.setString(2,term_code);//term_code
			rs = stmt.executeQuery();
			if(rs.next())
			{
				rs_chkk=true;
				short_desc  = rs.getString("short_desc");
				long_desc	= rs.getString("long_desc");
				
				String a1="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
					+"top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].LongDescription.value='"+long_desc
					+"';top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].Description.value='"+short_desc +"'</script></head><body CLASS='MESSAGE'></body></html>";
				
				out.println(a1);
			}
			String a2="<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>";
		
			if(long_desc !=null && !long_desc.equals(""))
			{
				a2=a2+"top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].exclamation.style.display='inline'"	;
				
			}else{
			a2 = a2+"top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].exclamation.style.display='none'" ;		
			}
			a2 = a2+"</script></head><body CLASS='MESSAGE'></body></html>";
			out.println(a2);
			
			if(rs != null)rs.close();
			if(stmt != null)stmt.close();

			if(!rs_chkk)
			{
				
				out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><body CLASS='MESSAGE'><script>top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].LongDescription.value='';top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].Description.value='';top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].diagprob_desc.select();document.write('OP0017 - Invalid procedure code');</script></body><html>");
			}
		}
	}else{
			//out.println("<script>alert('"+term_code+"')</script>");
			out.println("<html><head><link rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><body CLASS='MESSAGE'><script>top.content.workAreaFrame.NewProcedureMain.NewProcedure.document.forms[0].Description.value='';</script></body>");

	}

		
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
}catch(Exception e)
{
	//out.println(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
	out.println("<html><head><link  rel='stylesheet' type ='text/css' href='../../eCommon/html/"+sStyle+"'></link><body CLASS='MESSAGE'></body>");
}finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
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
