package jsp_servlet._edr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eDR.*;
import java.util.*;
import com.ehis.util.*;

public final class __enterduplicatepatientidmanual extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/edr/jsp/EnterDuplicatePatientIDManual.jsp", 1724243730000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<iframe name=\'add\' id=\'add\' src=\'../../eDR/jsp/EnterDuplicatesAddPatId.jsp?function_name=insert &flag=create\'  scrolling=no noresize style=\'height:100vh;width:40vw\' frameborder=\'0\'></iframe>\n\t<iframe name=\'mess\' id=\'mess\' src=\'../../eDR/jsp/EnterDuplicateAddModDel.jsp?p_mode=add\'  scrolling=no noresize style=\'height:100vh;width:0vw\' frameborder=\'0\'></iframe>\n\t<iframe name=\'addmodify\' id=\'addmodify\' src=\'../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?check=Show&p_mode=add+&function_name=insert\'  scrolling=yes noresize style=\'height:100vh;width:55vw\' frameborder=\'0\'></iframe>\n\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\t\t<iframe name=\'criteria\' id=\'criteria\' src=\'../../eDR/jsp/EnterDuplicateQueryCriteria.jsp?function_name=modify\' scrolling=no noresize style=\'height:15vh;width:100vw\' frameborder=\'0\'></iframe>\n\t\t<iframe name=\'blanks\' id=\'blanks\' src=\'../../eCommon/html/blank.html\'  scrolling=no noresize style=\'height:85vh;width:100vw\' frameborder=\'0\'></iframe>\n\t   <iframe name=\'mess\' id=\'mess\' src=\'../../eDR/jsp/EnterDuplicateAddModDel.jsp?p_mode=add\'  scrolling=no noresize style=\'height:0vh;width:100vw\' frameborder=\'0\'></iframe>\n\t\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<iframe name=\'modifyform\' id=\'modifyform\' src=\'../../eDR/jsp/EnterDuplicateModify.jsp?p_mode=add+&function_name=delete\' scrolling=yes noresize style=\'height:100vh;width:35vw\' frameborder=\'0\'></iframe>\n\t<iframe name=\'mess\' id=\'mess\' src=\'../../eDR/jsp/EnterDuplicateAddModDel.jsp?p_mode=add\' scrolling=no noresize style=\'height:100vh; width:0vw;\' frameborder=\'0\'></iframe>\n\t<iframe name=\'addmodify\' id=\'addmodify\' src=\'../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?p_mode=add+&function_name=insert\' scrolling=yes noresize style=\'height:100vh;width:55vw\' frameborder=\'0\'></iframe>\n\t\n \t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</html>\n\n";
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

	request.setCharacterEncoding("UTF-8");
	String p_mode = request.getParameter("p_mode");
	
	String p_function_name = request.getParameter("function_name");
	if(p_function_name==null) p_function_name="";
   String flag=request.getParameter("flag");
if(flag==null) flag="";

            _bw.write(_wl_block6Bytes, _wl_block6);

	if (p_mode.equals("addition"))
	{

            _bw.write(_wl_block7Bytes, _wl_block7);

	}
	else if (p_mode.equals("modify"))
	{

            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	else if (p_mode.equals("delete"))
	{

            _bw.write(_wl_block9Bytes, _wl_block9);

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
