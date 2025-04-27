package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __user extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/User.jsp", 1709629067540L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n<head>\n<script language=\'javascript\' src=\'../js/User.js\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t    <script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'> </script> \n \n\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<iframe name=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\t\t\t\t\n\t\t<iframe name=\'f_query_add_mod\' \t src=\'../../eCommon/html/blank.html\'  scrolling=\'auto\'frameborder=0 style=\'height:83vh;width:100vw\'></iframe>\t\t\t\t\n\t\t<iframe name=\'messageFrame\'\t src=\'../../eCommon/jsp/MstCodeError.jsp\'frameborder=0 noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\'></iframe>\t\t\t\t\n\t\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<SCRIPT>\n\t\t\talert(getMessage(\'ACCESS_USER_FACILITY_DENIED\',\'SM\'));//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020\t\n\t\t\tdocument.location.href=\'../../eCommon/jsp/dmenu.jsp\';//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020\t\n\t\t</SCRIPT>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n\t\t<iframe name=\'commontoolbarFrame\' src=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" frameborder=0 scrolling=\'no\' noresize style=\'height:8vh;width:100vw\'></iframe>\t\t\t\t\t\t\t\t\n\t\t<iframe name=\'f_query_add_mod\' \t src=\'../../eCommon/html/blank.html\'  scrolling=\'auto\'frameborder=0 style=\'height:83vh;width:100vw\'></iframe>\t\t\t\t\n\t\t<iframe name=\'messageFrame\'\t src=\'../../eCommon/jsp/MstCodeError.jsp\'frameborder=0 noresize scrolling=\'auto\' style=\'height:9vh;width:100vw\'></iframe>\t\t\t\t\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</html>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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
	String url="../../eCommon/jsp/MstCodeToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String ValUser = "";	
	String responsibility_id= (String) session.getAttribute("responsibility_id");
	String create_user_yn="";//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020
	Boolean isUserFacilityAppilcable = false;//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020

	Connection con=null;
	//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020
	Properties p=(Properties)session.getValue("jdbc");
	String globaluser = (String)p.getProperty("login_user"); 
	try{
	con = ConnectionManager.getConnection(request);

	
	isUserFacilityAppilcable = eCommon.Common.CommonBean.isSiteSpecific(con, "SM", "USER_FACILITY_AUTHORIZATION");//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020

				
			
	if(	isUserFacilityAppilcable)//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
		{
JSONObject Json	= eSM.SMCommonBean.getUserFacilityAccessYN(con,globaluser);//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
				create_user_yn = (String) Json.get("create_user_yn");//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	

	if(create_user_yn.equals("Y") )//added by kamatchi for MOHE-CRF-0012 ON 7-MAY-2020	
	   {
	   

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block7Bytes, _wl_block7);

	}
	else
	   {

            _bw.write(_wl_block8Bytes, _wl_block8);
		
	  }   
		}
		else
		{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block10Bytes, _wl_block10);

		}

            _bw.write(_wl_block11Bytes, _wl_block11);

}catch(Exception e){out.println(e);}
finally {				
			ConnectionManager.returnConnection(con,request);
		}	

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
