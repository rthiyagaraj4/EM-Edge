package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import java.text.SimpleDateFormat;
import java.util.*;
import com.ehis.util.*;

public final class __filteringandschedulingmastermain1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilteringAndSchedulingMasterMain1.jsp", 1709879284872L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script language=\"JavaScript\" src=\'../../eXH/js/Filtergl.js\'> </Script>\n<script language=\"JavaScript\" src=\'../../eXH/js/Filter.js\'> </Script>\n<script language=\"JavaScript\" src=\'../../eCommon/js/common.js\'> </Script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"JavaScript\" src=\'../../eXH/js/Validate.js\'> </script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n<title>Interface Filter</title>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<iframe name=\'commontoolbarFrame\' id=\'commontoolbarFrame\'src=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>  \n\t<iframe name=\'search\' id=\'search\' src=\"../../eXH/jsp/FilterAndSchedulingSelectMaster.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" frameborder=0  scrolling=\'no\' style=\'height:6vh;width:100vw\'></iframe>\n\t<iframe name=\'filterframe\' id=\'filterframe\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'no\' style=\'height:10vh;width:100vw\'></iframe>\n\t<iframe name=\'recordframe_detail\' id=\'recordframe_detail\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\'height:20vh;width:100vw\'></iframe>\n\t<iframe name=\'recordframe\' id=\'recordframe\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'no\' style=\'height:40vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/MstCodeError.jsp\' frameborder=0 noresize scrolling=\'no\' style=\'height:12vh;width:100vw\'></iframe>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n \n \n     \n\n\n\t\n\t\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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
request.setCharacterEncoding("UTF-8"); 
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

	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	
	String source = url + params ;
	 
ResultSet resultset = null;
Statement stment=null;
Connection conn = null;
String flag="N";
try
{
if(conn==null) conn = ConnectionManager.getConnection();						  
}
 catch(Exception exp)
      {											    
		 System.out.println("Error in calling getconnection method of FilteringAndSchedulingMasterMain1.jsp  :"+exp.toString());
		exp.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
try{

 stment= conn.createStatement();
 resultset = stment.executeQuery("select FILTER_YN from XH_PARAM ");
 while(resultset.next())
{
flag=resultset.getString(1);
}

}
catch(Exception e)
{
}
finally
{
if(stment!=null)
	{
	stment.close();
	
		}
		if(resultset!=null)
	{
			 resultset.close() ;
	}

		 ConnectionManager.returnConnection(conn);
}


            _bw.write(_wl_block6Bytes, _wl_block6);

	if(flag.equals("Y"))
	{
		// frameset size changed by prithivi for enotification requirement on 11/05/2016
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(source));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(params));
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
												    
	out.println("<script>alert(getMessage('XH0069','XH'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");	
	}
		
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
