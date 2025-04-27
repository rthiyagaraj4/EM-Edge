package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import webbeans.eCommon.*;

public final class __databaserolequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/DatabaseRoleQueryCriteria.jsp", 1709121697104L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n<script src=\"../eSM/js/facility_param.js\"></script>\n\n<center>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<p>\n\t\t<table align=\'right\'>\n\t\t<tr>\n\t\t<td>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t</td>\n\t\t</tr>\n\t</table>\t\n\t</p>\n\n\t\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</center>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
	

Connection con=null ;

try {
    request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	
	PreparedStatement pstmt  = null;		
	PreparedStatement pstmt1 = null;		
	ResultSet rs = null;
	ResultSet rs1 = null;
	int maxRecord = 0;
	
	int start = 0 ;
	int end   = 0 ;
	int i=1;
	
	

            _bw.write(_wl_block2Bytes, _wl_block2);

          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
	String classValue = "" ;
	String sql ="";
	sql = "SELECT ora_role_type,ora_role_id,app_password.decrypt(ora_role_password), ora_privilege from sm_ora_role" ;				
	pstmt = con.prepareStatement(sql);
	
	String count="select count(*) as total from sm_ora_role";		
	pstmt1 = con.prepareStatement( count );
	rs1= pstmt1.executeQuery() ;	
	rs1.next();
	maxRecord = rs1.getInt(1);
	if(rs1!=null)rs1.close();
	if(pstmt1!=null)pstmt1.close();
	
	rs = pstmt.executeQuery( sql ) ;
	

            _bw.write(_wl_block5Bytes, _wl_block5);
	
		if ( !(start <= 1) )
			out.println("<A HREF='../eSM/jsp/AddDatabaseRole.jsp?from="+(start-14)+"&to="+(end-14)+"&operation=query&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
				
		if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../eSM/jsp/AddDatabaseRole.jsp?from="+(start+14)+"&to="+(end+14)+"&operation=query&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block6Bytes, _wl_block6);

	out.println( "<table border='1' width='100%' cellspacing='0' cellpadding='0'>" ) ;
	out.println( "<tr bgcolor=black>" ) ;
	out.println( "<th>" ) ;
	out.println( "Role Type" ) ;
	out.println( "</th>" ) ;
	out.println( "<th>" ) ;
	out.println( "Role ID" ) ;
	out.println( "</th>" ) ;
	out.println( "<th>" ) ;
	out.println( "Enabled" ) ;
	out.println( "</th>" ) ;
	out.println(start);
	
	if ( start != 1 )
	{
	start = -1;
		for( int j=1; j<start; i++,j++ )
		{
		out.println("in");
			rs.next() ;
	  		while( rs.next() && i<=end )
	  		{					
				if ( i % 2 == 0 )
					classValue = "QRYEVEN" ;
				else
					classValue = "QRYODD" ;
				out.println( "<tr>" ) ;
			
				String ora_type  = "" + rs.getObject("ora_role_type") ;
				String ora_id 	 = "" + rs.getObject("ora_role_id") ;
				String ora_priv	 = "" + rs.getObject("ora_privilege") ;
				out.println(ora_type+" "+ora_id+" "+ora_priv);
				
				out.println( "<td width='33%' class='" + classValue + "'>+ora_type+</td>" ) ;	
				out.println( "<td width='33%' class='" + classValue + "'>" + ora_id  + "</td>" ) ;	
				out.println( "<td width='33%' class='" + classValue + "'>" + ora_priv + "</td>" ) ;	
				out.println( "</tr>" ) ;
			}	i++;
		}	
			if ( pstmt != null ) pstmt.close() ;
			if ( pstmt1 != null ) pstmt1.close() ;
			if ( rs != null ) rs.close() ;
			out.println( "</tr>" ) ;
			out.println( "</table>" ) ;	
	} 
	else 
	{

            _bw.write(_wl_block7Bytes, _wl_block7);

	}

} catch (Exception e) {}
finally
{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
