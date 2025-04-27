package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __fmreturntomrd extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMReturnToMRD.jsp", 1709116872953L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script language=\'javascript\' src=\'../../eFM/js/FMReturnToMRD.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script> \n\t\t\t\talert(getMessage(\"FM_NO_USER_RIGHTS\",\"FM\")); \n\t\t\t\tparent.frames[2].location.href=\'../../eCommon/jsp/dmenu.jsp\'; \n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<frameset rows=\'8%,27%,*,9%\' frameborder=\'0\'>\n\t<frame name=\'commontoolbarFrame\' id=\'commontoolbarFrame\' src=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' frameborder=\'0\' scrolling=no noresize>\n\t<!-- below line(s) added by venkatesh.S against issue KAUH-SCF-0016 [IN032341] on 23/April/2012-->\n\t\t<!--<frame name=\'criteria_frame\' id=\'criteria_frame\' src=\'../../eFM/jsp/FMReturnToMRDCriteria.jsp?\' frameborder=0 scrolling=\'no\' noresize> -->\n\t<frame name=\'criteria_frame\' id=\'criteria_frame\' src=\'../../eFM/jsp/FMReturnToMRDCriteria.jsp?userSecurity=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'\' frameborder=0 scrolling=\'no\' noresize>\n\t<!--end issue KAUH-SCF-0016 [IN032341] -->\n\t<frame name=\'result_frame\' id=\'result_frame\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=\'auto\' noresize>\n\t<frame name=\'messageFrame\' id=\'messageFrame\' src=\'../../eCommon/jsp/error.jsp\' scrolling=\'auto\' frameborder=\'0\' noresize>\n </frameset>\n</html>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );


public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}



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
	String sStyle			= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	StringBuffer sourceBuffer	= new StringBuffer();
	StringBuffer sqlBuffer		= new StringBuffer();

	String url		= "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params	= request.getQueryString() ;
	
	sourceBuffer.append(url);
	sourceBuffer.append(params);

	Connection connection			= null;
	PreparedStatement preStatement	= null;
	PreparedStatement pstmt_fn	= null;
	ResultSet resultSet				= null;
	ResultSet rset_fn				= null;

	String facility_id	= checkForNull((String) session.getValue("facility_id"));
	String user_id		= checkForNull((String) session.getValue("login_user"));

	String userAccess =	"";
    String sql1="";
	String userSecurity="";
	try
	{
		connection	= ConnectionManager.getConnection(request);
		
		sql1  = "Select USER_SECURITY_YN from FM_PARAMETER where facility_id = '"+facility_id+"' ";
		preStatement	= connection.prepareStatement(sql1);
		resultSet		= preStatement.executeQuery();
		
		if(resultSet != null && resultSet.next())
		{
			 userSecurity = resultSet.getString("USER_SECURITY_YN");
		}
		
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null)  preStatement.close();
		
		if(userSecurity.equals("Y"))
		{
		
		sqlBuffer.append("SELECT 1 userAccess FROM fm_user_access_rights WHERE facility_id = '");
		sqlBuffer.append(facility_id);
		sqlBuffer.append("' AND appl_user_id = '");
		sqlBuffer.append(user_id);
		sqlBuffer.append("' AND return_file_yn = 'Y' ");
				
		preStatement	= connection.prepareStatement(sqlBuffer.toString());
		resultSet		= preStatement.executeQuery();
	
		if((sqlBuffer != null) && (sqlBuffer.length() > 0))
		{
			sqlBuffer.delete(0,sqlBuffer.length());
		}

		if((resultSet != null) && (resultSet.next()))
		{
			 userAccess = resultSet.getString("userAccess");
		}
		if(!userAccess.equals("1"))
		{
		
            _bw.write(_wl_block8Bytes, _wl_block8);

		}
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null)  preStatement.close();
		}
	}
	catch(Exception exception)
	{
		out.println("Exception :"+exception.toString());
		exception.printStackTrace();
	}
	finally
	{		
		ConnectionManager.returnConnection(connection,request);
		if(rset_fn!=null)	rset_fn.close();
		if(pstmt_fn!=null)  pstmt_fn.close();
	}

if(session.getAttribute("doc_or_file")!=null)
session.removeAttribute("doc_or_file");

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sourceBuffer.toString()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(userSecurity));
            _bw.write(_wl_block11Bytes, _wl_block11);
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
