package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __invokemodifyfindtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/InvokeModifyFinDtls.jsp", 1727065406000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n<meta http-equiv=\"X-UA-Compatible\" content=\"IE=Edge\" />\t\t\r\n<meta charset=\"utf-8\">\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<html>\r\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \r\n</html>\r\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\r\n\r\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
	
	request.setCharacterEncoding("UTF-8");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//IN073001 Start.
	String request_num = request.getParameter("request_num") == null ? "" : request.getParameter("request_num");
	String request_line_num = request.getParameter("request_line_num") == null ? "" : request.getParameter("request_line_num");
	String direct_facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");

            _bw.write(_wl_block6Bytes, _wl_block6);


	Connection con = null;
	PreparedStatement pstmt=null; 
	ResultSet rset =null;
	String jspBasedOnFunctionID = "";
	String pageCalledYN = (String) session.getAttribute("pageCalledYN");
	if(pageCalledYN == null) pageCalledYN = "N";

	String strSqlValidUser = "select preferred_style,(select facility_name from sm_facility_param where facility_id=?) facility_name  from sm_appl_user where UPPER(APPL_USER_ID)=UPPER(?) and APPL_USER_PASSWORD= app_password.ENCRYPT(UPPER(?)) ";
	String strSqlValidResp = "SELECT 1 FROM SM_RESP_FOR_USER WHERE UPPER(APPL_USER_ID)=UPPER(?) AND RESP_ID=? ";
	String sql_chartTitle = "select APPL_TASK_DESC from CA_APPL_TASK where option_id = ? ";

	PreparedStatement pstmtValidUser = null;
	PreparedStatement pstmtValidResp = null;

	String client_ip_address = "";
	client_ip_address = request.getRemoteAddr();
	String jdbc_props = "";
	String direct_resp_id = request.getParameter("responsibility_id") == null ? "" : request.getParameter("responsibility_id");
	String direct_login_user = request.getParameter("login_user") == null ? "" : request.getParameter("login_user");
	String direct_login_pwd = request.getParameter("login_pwd") == null ? "" : request.getParameter("login_pwd");
	String limit_function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");

	String preferred_style="",facility_name="";	
	String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
	String calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");//V230106
	String visit_id = "";

	System.err.println("direct_login_user "+direct_login_user+" direct_login_pwd "+direct_login_pwd+" direct_facility_id "+direct_facility_id);

	session.putValue("responsibility_id",direct_resp_id);
	session.putValue("facility_id",direct_facility_id);
	session.putValue("login_user",direct_login_user);
	session.putValue("connection_pooling_yn","Y");
	Properties p = new Properties() ;
	p.setProperty( "login_user",direct_login_user ) ;
	p.setProperty("connection_pooling_yn","Y") ;
	p.setProperty("client_ip_address",client_ip_address) ;
	p.setProperty("jdbc_props",jdbc_props) ;
	p.setProperty("LOCALE",locale) ;
	session.putValue( "jdbc",p ) ;

	try{
		
		String query_string = (String) request.getQueryString();
		query_string = query_string + "&pageCalledYN="+ pageCalledYN;
		if(limit_function_id.equals("MOD_FIN_DTLS")){
			jspBasedOnFunctionID = "../../eBL/jsp/BLModifyFinancialDetailsMain.jsp";
		}else if(limit_function_id.equals("PRICE_LIST")){
			jspBasedOnFunctionID = "../../eBL/jsp/BLServItemPriceList.jsp";
		}else if(limit_function_id.equals("ENC_TRF_CHARGES")){
			jspBasedOnFunctionID = "../../eBL/jsp/BLEncTrfChargesMain.jsp";
		}
		

            _bw.write(_wl_block7Bytes, _wl_block7);
            {java.lang.String __page =jspBasedOnFunctionID
                ;
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("facility_id"), weblogic.utils.StringUtils.valueOf(direct_facility_id
                        )},{ weblogic.utils.StringUtils.valueOf("calledFrom"), weblogic.utils.StringUtils.valueOf("managePatientPopup")},{ weblogic.utils.StringUtils.valueOf("login_user"), weblogic.utils.StringUtils.valueOf(direct_login_user
                        )},{ weblogic.utils.StringUtils.valueOf("function_id"), weblogic.utils.StringUtils.valueOf(limit_function_id
                        )},{ weblogic.utils.StringUtils.valueOf("responsibility_id"), weblogic.utils.StringUtils.valueOf("EBL_MANAGER")},{ weblogic.utils.StringUtils.valueOf("pageCalledYN"), weblogic.utils.StringUtils.valueOf(pageCalledYN
                        )},{ weblogic.utils.StringUtils.valueOf("locale"), weblogic.utils.StringUtils.valueOf(locale
                        )},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block9Bytes, _wl_block9);

	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if (pstmt!=null) pstmt.close();
		if (rset !=null) rset.close();

		if(con!=null)ConnectionManager.returnConnection(con,request);		
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
