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

public final class __encounterinehrwrapper extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/EncounterInEHRWrapper.jsp", 1709115823685L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<title>Clinical Events from Central Repository for ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</title>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<body onKeyDown=\"lockKey()\">\n<form>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<SCRIPT>\nvar arguments; \nvar getUrl =\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\';\nvar features=\'height=600,width=1000,top=50,left=0,resizable=no\';\nvar retVal=window.open(getUrl,arguments,features)\n</script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String patientid				=	checkForNull(request.getParameter("patient_id"));
	
            _bw.write(_wl_block2Bytes, _wl_block2);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block4Bytes, _wl_block4);

		java.util.Properties	p1					=	(java.util.Properties) session.getValue("jdbc");
		StringBuffer sbConURL			=	 new StringBuffer();
		String resp_id					=	checkForNull((String) session.getValue("responsibility_id"));
		String login_user_id			=	checkForNull((String) session.getValue("login_user"));  
		String facilityId				=	checkForNull((String) session.getValue("facility_id"));
		String loggedin_clinician_id	=	checkForNull((String) session.getValue("ca_practitioner_id"));
		String practitioner_type		=	checkForNull((String) session.getValue("practitioner_type"));

		String strClientIPAdd			=	(String) p1.getProperty("client_ip_address");
		String strConnectionPool		=	(String) p1.getProperty("connection_pooling_yn");

		String params		=	"?patient_id="+patientid+"&facilityId="+facilityId+"&EHR_YN=Y&login_user_id="+login_user_id+"&loggedin_clinician_id="+loggedin_clinician_id+"&practitioner_type="+practitioner_type+"&resp_id="+resp_id+"&ClientIP="+strClientIPAdd+"&conpool="+strConnectionPool+"&csssty="+sStyle;

		sbConURL.append("../../eCA/jsp/EncounterInEHRCentralWrapper.jsp");
		sbConURL.append(params);
		


	/*	Connection con			= null;
		PreparedStatement pstmt = null;
		ResultSet rs			= null;

		try
		{
			con = ConnectionManager.getConnection(request);

			strQuery	=	"select BASE_URL ,DEFAULT_USER_ID,app_password.DECRYPT(DEFAULT_USER_PASSWORD) DEFAULT_USER_PASSWORD,EXT_IMAGE_APPL_NAME from CA_EXT_IMAGE_APPL where EXT_IMAGE_APPL_ID = ?";

			pstmt = con.prepareStatement(strQuery);
			pstmt.setString(1,"EHRVW");
				
			rs = pstmt.executeQuery();

			if(rs != null && rs.next())
				//strBaseURL	=  checkForNull(rs.getString(1));
				strBaseURL	=  "http://indbgl-app25:8899/eHIS";

			sbConURL.delete(0,sbConURL.length());
			if(!strBaseURL.equals("") )
			{
				sbConURL.append(strBaseURL);
				sbConURL.append("/eCA/jsp/EncounterInEHRCentralWrapper.jsp");
				sbConURL.append(params);
			}

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		catch (Exception e2)
		{
			e2.printStackTrace();
			
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		} */


            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sbConURL.toString()));
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
