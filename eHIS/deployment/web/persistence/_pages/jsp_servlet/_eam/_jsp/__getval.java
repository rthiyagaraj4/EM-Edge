package jsp_servlet._eam._jsp;

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

public final class __getval extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/GetVal.jsp", 1711028057927L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\t\t\t\t\t\t        \n\t\t\t<script>\n\t\t\t\tvar tp =\"-----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"-----\";\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=tp;\n\t\t\t\topt.value=\"\";\n\t\t\t\tparent.f_query_add_mod.document.forms[0].department.add(opt);\t\t\t\t\t\n\t\t\t</script>\t        \n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<script>\n\t\t\t\tvar temp = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\tvar temp1=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\t\t\topt.text=temp1;\n\t\t\t\topt.value=temp;\n\t\t\t\tparent.f_query_add_mod.document.forms[0].department.add(opt);\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\t\t\t\t\t\t        \n\t<script>\n\t\tvar tp =\"-----\"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"-----\";\n\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\topt.text=tp;\n\t\topt.value=\"\";\n\t\tparent.f_query_add_mod.document.forms[0].section.add(opt);\t\t\t\t\t\n\t</script>\t        \n\t\t\t\t\t\t\t\t\t\t        \n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\n\t<script>\n\t\tvar temp = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\tvar temp1=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\tvar opt=parent.f_query_add_mod.document.createElement(\"OPTION\");\n\t\topt.text=temp1;\n\t\topt.value=temp;\n\t\tparent.f_query_add_mod.document.getElementById(\'section\').add(opt);\n\t</script>\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

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
            _bw.write(_wl_block5Bytes, _wl_block5);
			
			Connection con = null;
			ResultSet rset=null;
			Statement stmt=null;
			PreparedStatement pstmt = null;
try
{	
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	//stmt = con.createStatement();

	String deptcode="";
	String deptdesc="";
	String sectioncode="";
	String sectiondesc="";
	String common=request.getParameter("Common_Text");
	String common1=request.getParameter("Common_Text1");			
	String chksrc=request.getParameter("Chksrc");
	
if(chksrc.trim().equals("facility")) 
{
	String sql = "select dept_code,dept_short_desc from am_facility_dept_vw where eff_status = 'E' and operating_facility_id =? order by dept_short_desc";

	//rset = stmt.executeQuery(sql);
	
	pstmt   = con.prepareStatement(sql);
	pstmt.setString	(	1,	common.trim()		);
	rset		 = pstmt.executeQuery();
	
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");
			if(rset != null) 
			{
				
            _bw.write(_wl_block6Bytes, _wl_block6);
		
				
			while( rset.next() ) 
			{
				deptcode=rset.getString("dept_code");
				deptdesc=rset.getString("dept_short_desc");
						
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(deptcode));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(deptdesc));
            _bw.write(_wl_block9Bytes, _wl_block9);
			   	  
				}
			}
	if(rset!=null) 	rset.close();
	if(stmt!=null) 	stmt.close();
	if(pstmt!=null) 	pstmt.close();
	out.println("</form></body></html>");	
}	
else if(chksrc.trim().equals("department")) 
{
	String sql = "select section_code,section_short_desc from am_dept_section_vw where eff_status = 'E'  and dept_code =? order by section_short_desc";
	//stmt = con.createStatement();
	//rset = stmt.executeQuery(sql);				
	
	pstmt   = con.prepareStatement(sql);
	pstmt.setString	(	1,	common1.trim()	);
	rset		 = pstmt.executeQuery();
	
	out.println("<html><HEAD><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></link><script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></HEAD><body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='nam1' id='nam1'>");

	if(rset != null) 
	{
		
            _bw.write(_wl_block10Bytes, _wl_block10);
				
		while( rset.next() ) 
		{
			sectioncode=rset.getString("section_code");
			sectiondesc=rset.getString("section_short_desc");

		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sectioncode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(sectiondesc));
            _bw.write(_wl_block13Bytes, _wl_block13);
			   	  
		}
	}
	out.println("</form></body></html>");	
	if(rset!=null) 	rset.close();
	if(stmt!=null) 	stmt.close();
	if(pstmt!=null) 	pstmt.close();
 }
}
catch(Exception e)
{}
finally
{
	try
	{
	if (rset != null)   rset.close();
	if (stmt != null)   stmt.close();
	if(pstmt!=null) 	pstmt.close();
	}
	catch(Exception e)
	{}
	ConnectionManager.returnConnection(con,request);
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
