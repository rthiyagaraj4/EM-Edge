package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;

public final class __amintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/AMIntermediate.jsp", 1709113901943L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	Connection con = null;
	con = ConnectionManager.getConnection(request);

try{
	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;
	String action = (String) hash.get("action")==null?"":(String) hash.get("action");
	
	if(action.equals("getPractName")){
		String retVal = "";
		String natid = (String) hash.get("national_id");
		JSONObject practJSONObj	= new JSONObject();
		practJSONObj = eAM.AMCommonBean.getPractName(con,natid);
		int rec_cnt = (Integer)practJSONObj.get("rec_cnt");
		String practitioner_name = (String)practJSONObj.get("practitioner_name");
		retVal = rec_cnt+"|~|"+practitioner_name;
		out.println(retVal);
	}
	else if(action.equals("getOthAltPractName")){
		String retVal = "";
		String othalttype = (String) hash.get("oth_alt_type");
		String othaltid = (String) hash.get("oth_alt_id");
		JSONObject practJSONObj	= new JSONObject();
		practJSONObj = eAM.AMCommonBean.getOthAltPractName(con,othalttype,othaltid);
		int rec_cnt = (Integer)practJSONObj.get("rec_cnt");
		String practitioner_name = (String)practJSONObj.get("practitioner_name");
		retVal = rec_cnt+"|~|"+practitioner_name;
		out.println(retVal);
	}
	else if(action.equals("getOthStaffName")){
		String retVal = "";
		String natid = (String) hash.get("national_id");
		JSONObject staffJSONObj	= new JSONObject();
		staffJSONObj = eAM.AMCommonBean.getOthStaffName(con,natid);
		int rec_cnt = (Integer)staffJSONObj.get("rec_cnt");
		String oth_staff_name = (String)staffJSONObj.get("oth_staff_name");
		retVal = rec_cnt+"|~|"+oth_staff_name;
		out.println(retVal);
	}
	else if(action.equals("getOthAltStaffName")){
		String retVal = "";
		String othalttype = (String) hash.get("oth_alt_type");
		String othaltid = (String) hash.get("oth_alt_id");
		JSONObject staffJSONObj	= new JSONObject();
		staffJSONObj = eAM.AMCommonBean.getOthAltStaffName(con,othalttype,othaltid);
		int rec_cnt = (Integer)staffJSONObj.get("rec_cnt");
		String oth_staff_name = (String)staffJSONObj.get("oth_staff_name");
		retVal = rec_cnt+"|~|"+oth_staff_name;
		out.println(retVal);
	}
	// added by Lakshmanan for MO-CRF-20183.2 US001 start
	else if(action.equals("EmpServNo")){
		int retVal = 0;
		String empservno	= (String) hash.get("empservno");		
		JSONObject empServNoJSONOBJ=eAM.AMCommonBean.getEmpServNo(con,empservno);
		retVal = (Integer)empServNoJSONOBJ.get("rec_cnt");		
		out.println(retVal);
	}
	// added by Lakshmanan for MO-CRF-20183.2 US001 end
}catch(Exception e){ 
	e.printStackTrace();	
}finally{ 
	if(con != null){
		ConnectionManager.returnConnection(con,request);
	}	
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
