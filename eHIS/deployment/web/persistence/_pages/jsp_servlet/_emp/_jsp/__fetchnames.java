package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Hashtable;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __fetchnames extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/FetchNames.jsp", 1742362690981L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!-- Last Modified Date Time : 9/23/2005 5:25 PM --> \n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n\t\t\t\t\tvar strobj = eval(\'document.forms[0].";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\');\n\t\t\t\t\tstrobj.value = \'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\');\t\t\t\t\t\t\n\t\t\t\t\tstrobj.value = \'";
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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);

    Hashtable hash	= (Hashtable)obj.parseXMLString(request);
 	hash			= (Hashtable)hash.get("SEARCH");

	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
    try
    {
		con	= ConnectionManager.getConnection(request);
        stmt = con.createStatement();
           
		String frmObj		= (String) hash.get("frmObj");
		String toObj		= (String) hash.get("toObj");
		String param_val	= (String) hash.get("param_val") ;

		if(frmObj == null) frmObj = "";
		if(toObj == null) toObj = "";
		if(param_val == null) param_val = "";
			
		param_val = new String(param_val.getBytes(),"UTF-8");

		String sql ="";
        
        if(!frmObj.substring(frmObj.length()-1).equals("6"))
        {
			if(frmObj.indexOf("oth_lang")==-1)
            {
				param_val=param_val.toUpperCase( );
                sql ="select other_name_loc_lang  from mp_std_other_name where upper(other_name)='"+ param_val +"'" ;					
			}
            else
			{
				sql ="select other_name from mp_std_other_name where other_name_loc_lang='"+ param_val +"'" ;
			}
			rs = stmt.executeQuery(sql) ;
			if(rs!=null)
			{
				if(rs.next())
				{
					String objValue = rs.getString(1);
					
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(toObj));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(objValue));
            _bw.write(_wl_block7Bytes, _wl_block7);

				}
			}
			if(rs != null)  rs.close();
		}
		else
		{
			if(frmObj.indexOf("oth_lang")==-1)
			{
				param_val = param_val.toUpperCase( );
				sql = "select last_name_loc_lang from mp_std_family_name where upper(last_name)='"+ param_val +"' ";
			}
			else
			{
				sql = "select last_name from mp_std_family_name where last_name_loc_lang='"+ param_val +"' ";
			}
			rs = stmt.executeQuery(sql) ;
			if(rs!=null)
			{
				if(rs.next())
				{
					String objValue = rs.getString(1);	
					
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(toObj));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(objValue));
            _bw.write(_wl_block7Bytes, _wl_block7);

				}
			}
			if(rs != null)  rs.close() ;
		}
		if(stmt!=null) stmt.close();

		hash.clear();
	}
	catch(Exception e){out.println("tst "+e);}
	finally
	{	
		if(con!=null) ConnectionManager.returnConnection(con,request);
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
