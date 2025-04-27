package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __encounterinehrcentralwrapper extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncounterInEHRCentralWrapper.jsp", 1709115823216L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "windows-1256".intern();

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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<title>Clinical Events from Central Server</title>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<iframe src=\"../../eCommon/html/blank.html\" name=\"\" id=\"\"  scrolling=\"no\" frameborder=\"0\" noresize style=\"height:0%;width:100vw\"></iframe>\n\t<iframe src=\"../../eCommon/html/blank.html\" name=\"\" id=\"\"  scrolling=\"no\" frameborder=\"0\" noresize style=\"height:0%;width:100vw\"></iframe>\n\t<iframe src=\"../../eCommon/html/blank.html\" name=\"\" id=\"\"  scrolling=\"no\" frameborder=\"0\" noresize style=\"height:0%;width:100vw\"></iframe>\n\t<iframe src=\"../../eCommon/html/blank.html\" name=\"\" id=\"\"  scrolling=\"no\" frameborder=\"0\" noresize style=\"height:0%;width:100vw\"></iframe>\n\t<iframe src=\"../../eCA/jsp/FlowSheet.jsp?";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" name=\"criteria_f0\"   scrolling=\"no\" frameborder=\"0\" noresize style=\"height:0%;width:100vw\"></iframe>\n\t<iframe src=\"../../eCommon/jsp/error.jsp\"\t\t\t name=\"messageFrame\" id=\"messageFrame\"  scrolling=\"no\" frameborder=\"0\" noresize style=\"height:0%;width:100vw\"></iframe>\n\n</html>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=windows-1256");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=windows-1256");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String resp_id					=	checkForNull((String)request.getParameter("responsibility_id"));
		String login_user_id			=	checkForNull((String)request.getParameter("login_user"));  
		String facilityId				=	checkForNull((String)request.getParameter("facility_id"));
		String loggedin_clinician_id	=	checkForNull((String)request.getParameter("ca_practitioner_id"));
		String practitioner_type		=	checkForNull((String)request.getParameter("practitioner_type"));
		String patientid				=	checkForNull((String)request.getParameter("patient_id"));
		String strClientIPAdd			=	checkForNull((String) request.getParameter("ClientIP"));
		String strConnectionPool		=	checkForNull((String) request.getParameter("conpool"));
		String sStyle					=	checkForNull((String) request.getParameter("csssty"));

		String params					=	"",				jdbc_props			=	"";

		try
		{
			session			=	request.getSession(true);
			
			java.util.Properties p	=	new java.util.Properties();

			session.putValue("responsibility_id",resp_id);
			session.putValue("login_user",login_user_id);
			session.putValue("facility_id",facilityId);
			session.putValue("ca_practitioner_id",loggedin_clinician_id);
			session.putValue("practitioner_type",practitioner_type);
			session.putValue("connection_pooling_yn",strConnectionPool);
			p.setProperty( "login_user",login_user_id ) ;
			p.setProperty("connection_pooling_yn",strConnectionPool) ;
			p.setProperty("client_ip_address",strClientIPAdd) ;
			p.setProperty("jdbc_props",jdbc_props) ;
			session.putValue( "jdbc",p ) ;
			session.putValue("PREFERRED_STYLE",sStyle);
			params = "patient_id="+patientid+"&facilityId="+facilityId+"&EHR_YN=Y";
			
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
			
		}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(params));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
