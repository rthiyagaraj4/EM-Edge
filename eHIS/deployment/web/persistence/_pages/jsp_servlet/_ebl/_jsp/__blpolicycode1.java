package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __blpolicycode1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPolicyCode1.jsp", 1741168951296L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n\tAuthor\t\t \t\t:\tPrakash.S\n\tCreated on \t\t\t:\t16th Jan 2002\n\tLast Modified on\t:\t16th Jan 2002\n\tModule/Function\t\t:\tBL - Get Policy Type Code\n\tPurpose\t\t\t\t:\tThis function is used to populate the Reference Source Code depending up on \n\t\t\t\t\t\t\tthe Facility selected by the user (Either Enterprise/External).\n-->\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;

	String locale	= (String)session.getAttribute("LOCALE");

	try
	{

	con	=	ConnectionManager.getConnection(request);
	//Connection con = (Connection) session.getValue("connection");
	request.setCharacterEncoding("UTF-8");
	//facility_id  =  (String) session.getValue("facility_id") ;
	String cust_code="",policy_type_code="",short_desc="";
	String query_ref_source="" /*,facility_id="" */ ;
	cust_code	= 	request.getParameter("cust_code");

	if(cust_code==null) cust_code="";
	cust_code=cust_code.trim();

	out.println("<html><head>");

	//out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>");


	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<link rel='StyleSheet' href='../../eCommon/html/'"+sStyle+" type='text/css'/>");

//	out.println("<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>");
	//out.println("<script language='javascript'>");
	//out.println("alert(\"hi in temp Jsp\");");
	//out.println("alert(parent.frames[1].document.forms[0].name);");
	
	
		stmt = con.createStatement();
		
		out.println("<script language='javascript'>");
		
		query_ref_source = "Select short_desc, policy_type_code from bl_ins_policy_types_lang_ve where language_id='"+locale+"' and cust_code='"+cust_code+"' and nvl(status,'N') <> 'S' order by short_desc";

		//out.println("</head><body><br>Query : "+query_ref_source+"</body>");
		
		rs = stmt.executeQuery(query_ref_source);

		out.println("var policy_type_code	= 'select';");
		out.println("var short_desc	= '         ---- Select ----       ';");
		out.println("var opt=parent.frames[1].frames[0].document.createElement('OPTION'); ");
		out.println("opt.text	=	short_desc; ");
		out.println("opt.value	=	policy_type_code; ");
		out.println("parent.frames[1].frames[0].document.forms[0].policy_type.add(opt); ");
		out.println("parent.frames[1].frames[0].document.forms[0].policy_type.selectedIndex = 0;");
		while(rs.next())
		{
			
			policy_type_code	=	rs.getString("policy_type_code");
			short_desc	=	rs.getString("short_desc");

			out.println("var policy_type_code	= '"+policy_type_code+"';");
			out.println("var short_desc	= '"+short_desc+"';");

			out.println("var opt = parent.frames[1].frames[0].document.createElement('OPTION'); ");
			out.println("opt.text	=	short_desc; ");
			out.println("opt.value	=	policy_type_code; ");
			out.println("parent.frames[1].frames[0].document.forms[0].policy_type.add(opt); ");
		} // end of while
		
		out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body CLASS='MESSAGE'> </body></html>");
	} // end of try
	catch(Exception e)
	{
		out.println("</script></head><body CLASS='MESSAGE'>");
		//out.println("Exception@1 : "+e);
		e.printStackTrace();
		out.println("</body></html>");
	}
	finally
	{
		if (rs != null)   rs.close();
		if(stmt!=null)	stmt.close();
		ConnectionManager.returnConnection(con, request);
	}
	
	//out.println("</script></head><body CLASS='MESSAGE'> </body></html>");


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
