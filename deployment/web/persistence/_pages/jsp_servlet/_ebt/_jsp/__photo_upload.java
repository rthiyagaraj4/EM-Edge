package jsp_servlet._ebt._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __photo_upload extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebt/jsp/photo_upload.jsp", 1709115157431L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<HTML>\n<HEAD>\t\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration1.js\'></Script>\n\t<Script language=\'javascript\' src=\'../../eMP/js/PatientRegistration2.js\'></Script>\n\t<script language=\"JavaScript\" src=\"../../eBT/js/ViewPatDetails.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</HEAD>\n\n<BODY onUnLoad=\'window.returnValue=\"close\"\' onKeyDown=\'lockKey()\'>\n<form name=\'photoUpload\' id=\'photoUpload\' action=\'../../servlet/eBT.PhotoUploadServlet\' method=\'post\' enctype=\'multipart/form-data\'>\n<table border=0 cellspacing=0 cellpadding=0 width=\'80%\' align=\'center\'>\n<tr ><td class=\'label\' width=\'50%%\' colspan=2>&nbsp;</td></tr>\n<tr ><td class=\'label\' width=\'50%%\' colspan=2>&nbsp;</td></tr>\n<tr ><td class=\'label\' width=\'50%%\' colspan=2>&nbsp;</td></tr>\n<tr ><td class=\'label\' width=\'50%\'>Blood Donor Photo</td><td class=\'fields\'><input type=\"file\" name=\"patFile\" id=\"patFile\" value=\"\"  size=40 maxlength=40 onchange=\"\" onkeypress=\"return onkeyPressEvent(event);\"></td></tr>\n<tr ><td class=\'label\' width=\'50%\' colspan=2>&nbsp;</td></tr>\n<tr\t><td class=\'label\' width=\'50%%\'></td><td width=\'25%\'  class=\'button\'><input type=\'button\' name=\'uploadfile\' id=\'uploadfile\' value=\'Upload File\' onclick=\'parent.uploadfile()\' ></td></tr>\n<tr ><td class=\'label\' width=\'50%\' colspan=2>&nbsp;</td></tr>\n</table>\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n<input type=\"hidden\" name=\"photoCount\" id=\"photoCount\" value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n<input type=\"hidden\" name=\"user_id\" id=\"user_id\" value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n<input type=\"hidden\" name=\"ws_no\" id=\"ws_no\" value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n</form>\n</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	
            _bw.write(_wl_block1Bytes, _wl_block1);
 
String patient_id = request.getParameter("patient_id"); 
String photoCount = request.getParameter("photoCount");
String facility_id = request.getParameter("facility_id");
String user_id = request.getParameter("user_id");
String ws_no = request.getParameter("ws_no");

System.out.println(" ::: patient_id ::: "+patient_id+" ::: photoCount ::: "+photoCount+" ::: facility_id ::: "+facility_id+" ::: user_id ::: "+user_id+" ::: ws_no ::: "+ws_no);

String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
String visit_id = "";
String jdbc_props = "";

System.out.println(" ::: Before Session Put Value ::: ");

session.putValue("LOCALE",locale);
session.putValue("facility_id",facility_id);
session.putValue("login_user",user_id);
session.putValue("connection_pooling_yn","Y");

System.out.println(" ::: After Session Put Value 1 ::: ");

Properties p = new Properties() ;
p.setProperty( "login_user",user_id) ;
p.setProperty("connection_pooling_yn","Y") ;
p.setProperty("client_ip_address",ws_no) ;
p.setProperty("jdbc_props",jdbc_props) ;
p.setProperty("LOCALE",locale) ;
session.putValue( "jdbc",p ) ;

System.out.println(" ::: After Session Put Value 2 ::: ");


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(photoCount));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(ws_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
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
