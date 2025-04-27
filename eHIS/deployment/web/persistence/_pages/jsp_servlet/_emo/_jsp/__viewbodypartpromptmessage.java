package jsp_servlet._emo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __viewbodypartpromptmessage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eMO/jsp/ViewBodyPartPromptMessage.jsp", 1704691658819L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1669269240778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--\r\nCRF/SCF Reference No \t:  ML-MMOH-CRF-1950\r\nDetected Release  No  \t:  MARCH 2024 Release \r\nFile prepared by      \t:  Prakash Rajan M\r\nFile prepared date    \t:  02-01-2024\r\nPurpose of the change   :  To display the Hyperlink of Prompt Message for body part already registered in MO Parameter\t\t\t\t   \r\nScript Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites\t\r\n-->\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \r\n<html>\r\n<head>\r\n  ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \r\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\r\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\r\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\r\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\r\n<script type=\"text/javascript\">\r\n\r\nfunction showBodyPartDtls(patient_id)\r\n{ \r\n\tvar retVal = \tnew String();\r\n\tvar arguments = \"\";\r\n\tvar dialogHeight= \"20\" ;\r\n\tvar dialogTop = \"55\" ;\r\n\tvar dialogWidth\t= \"70\" ;\r\n\tvar status = \"no\";\r\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\"  ; dialogTop:\" + dialogTop + \" ; scroll:yes; status:\" + status ;\r\n\t\r\n\tvar retVal = window.showModalDialog(\"../../eMO/jsp/ViewPreviousBodyPartDtls.jsp?patient_id=\"+patient_id,arguments,features);\r\n}\r\n\r\n</script>\r\n</head>\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n<body  OnMouseDown=\"CodeArrest()\" onLoad=\'\' onKeyDown = \'lockKey()\'>\r\n<br>\r\n<form name=\"ViewBodyPartPromptMessage.jsp\" >\r\n<table width=\'0%\' align=\'center\' valign=\'top\' border=\'0\'>\r\n<tr>\r\n<td align=\'center\' width=\'200%\' class=\'fields\' ><a href =\"javascript:showBodyPartDtls(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\')\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</a></td>\r\n<tr>\r\n</table>\r\n</form>\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
 
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

String patient_id = checkForNull(request.getParameter("patient_id"));
String encounter_id = checkForNull(request.getParameter("encounter_id"));
String promt_msgtext = checkForNull(request.getParameter("promt_msgtext"));
Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String facility_id	=	(String)session.getValue("facility_id");
String loggedInId = p.getProperty( "login_user" ) ;
Connection con = null;

try
	{
	con = ConnectionManager.getConnection(request);
	Statement stmt = null;
	ResultSet rset=null;
	PreparedStatement pstmt1=null;
	ResultSet rset1=null;
	

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(promt_msgtext));
            _bw.write(_wl_block9Bytes, _wl_block9);

	}
	catch(Exception e){				   
	e.printStackTrace();
	}
finally	{
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
