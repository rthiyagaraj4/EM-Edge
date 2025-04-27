package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.ConnectionManager;

public final class __populatevalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/PopulateValues.jsp", 1710451143716L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t\t\t\t<script>\n\t\t\t\tif (document.getElementById(\'res_town_code\') !=null) \tdocument.getElementById(\'res_town_code\').value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t<script>\n\t\t         if (document.getElementById(\'res_area_code\') != null) document.getElementById(\'res_area_code\').value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\tif (document.getElementById(\'postal_code\') !=null) \t\t\t\n\t\t\t\t\t\tdocument.getElementById(\'postal_code\').value = \'\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<script>\n\t\t\t\tif (document.getElementById(\'res_town_code\') !=null) \n\t\t\t\t\tdocument.getElementById(\'res_town_code\').value=\'\';\t\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
 	hash = (Hashtable)hash.get("SEARCH") ;
	Connection con = null;
    try
    {
		request.setCharacterEncoding("UTF-8");	

		con = ConnectionManager.getConnection(request);
        Statement stmt = null;
        ResultSet rs = null ;
        stmt = con.createStatement(); 
		String postal_code = (String) hash.get("postal_code") ;
		if (postal_code==null) postal_code ="";
		String res_area_code = (String) hash.get("res_area_code") ;
		if (res_area_code==null) res_area_code ="";
		String res_town_code = (String) hash.get("res_town_code") ;
		if (res_town_code==null) res_town_code ="";


        String mode = request.getParameter("mode") ;
		if (mode==null) mode="";
	
		
		
		
		String sql = "";
		
        if (!postal_code.equals(""))
		{
			sql = "select res_town_code from mp_postal_code where postal_code = '"+postal_code+"'";
			rs = stmt.executeQuery(sql);
			if (rs.next())
			{
				res_town_code = rs.getString(1);
				if (res_town_code==null) res_town_code=""; 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(res_town_code));
            _bw.write(_wl_block3Bytes, _wl_block3);
}
			 if(rs!=null) 	rs.close();
	         if(stmt!=null) 	stmt.close();

		}

		if (!res_town_code.equals(""))
		{
			sql = "select res_area_code, region_code from mp_res_area where res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+res_town_code+"')";
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(sql);
			if (rs.next())
			{ 
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf( (rs.getString(1)==null ? "" : rs.getString(1))));
            _bw.write(_wl_block5Bytes, _wl_block5);
 if (postal_code.equals("")) 
            _bw.write(_wl_block6Bytes, _wl_block6);
		        
			}	
			if(rs!=null) 	rs.close();
	         if(stmt!=null) 	stmt.close();
		}

		if (!res_area_code.equals(""))
		{
			sql = "select region_code from mp_region where region_code = (select region_code from mp_res_area where res_area_code ='"+res_area_code+"')";
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(sql);
			if (rs.next())
			{
            _bw.write(_wl_block7Bytes, _wl_block7);
}
		}		
		if(rs!=null) 	rs.close();
	    if(stmt!=null) 	stmt.close();
		hash.clear();
    }
    catch(Exception e){out.println("tst "+e);}
    finally
    {
        ConnectionManager.returnConnection(con,request);
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
