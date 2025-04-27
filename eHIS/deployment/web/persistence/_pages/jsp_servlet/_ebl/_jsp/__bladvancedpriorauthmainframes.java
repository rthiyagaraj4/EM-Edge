package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLAdvancedPriorAuthBean;
import webbeans.eCommon.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __bladvancedpriorauthmainframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLAdvancedPriorAuthMainFrames.jsp", 1713248478359L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1669269240919L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!--\r\n-----------------------------------------------------------------------------------------------\r\nDate       Edit History   \t\t\t\tName        \t\t\tDescription\r\n-----------------------------------------------------------------------------------------------\r\n13/02/24      \t         \t\t\tMonika Gupta  \t\t\t\tcreated\r\n-----------------------------------------------------------------------------------------------\r\n-->\r\n<!--\r\nSr No       Version             Incident              SCF/CRF                        Developer Name\r\n\r\n-----------------------------------------------------------------------------------------------\r\n-->\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<html>\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\r\n\t<script language=\'javascript\' src=\'../../eCommon/js/jquery.js\'></script>\t\t \t  \r\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n\t<script language=\'javascript\' src=\'../../eBL/js/BLAdvancedPriorAuth.js\'></script>\t\t\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\r\n\t\r\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\t\t\t<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title></head>\r\n\t\t\t<FRAMESET ROWS =\'15%,85%\' framespacing=0>  \r\n\t\t\t\t<FRAME name=\'BLAdvancedPriorAuthPatientDetailsFrame\' src=\'../../eCommon/jsp/pline.jsp?Patient_Id=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' frameborder=0 noresize scrolling=\"auto\" >\r\n\t\t\t\t<FRAME name=\'BLAdvancedPriorAuthServiceDetailsFrame\' src=\'../../eBL/jsp/BLAdvancedPriorAuthPatientServiceDetails.jsp?";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&function_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&called_from_dashboard_YN=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' frameborder=0 noresize scrolling=\"auto\">\t\r\n\t\t\t</FRAMESET>\t\t\t\r\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n\t\t\t<FRAMESET ROWS =\'16%,40%,44%\' framespacing=0 >\r\n\t\t\t\t<FRAME name=\'BLAdvancedPriorAuthSearchFrame\'\tsrc=\'BLAdvancedPriorAuthSearch.jsp?";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'  frameborder=0 scrolling=\'no\' noresize>\r\n\t\t\t\t<FRAME name=\'BLAdvancedPriorAuthPatientDetailsFrame\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0  noresize>\r\n\t\t\t\t<FRAME name=\'BLAdvancedPriorAuthServiceDetailsFrame\' \tsrc=\'../../eCommon/html/blank.html\' frameborder=0  noresize>\r\n\t\t\t</FRAMESET>\r\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\r\n\t\r\n</html>\r\n\r\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);


	String beanId = "bl_BLAdvancedPriorAuthBean";
	String beanName = "eBL.BLAdvancedPriorAuthBean";
	
	BLAdvancedPriorAuthBean bean = (BLAdvancedPriorAuthBean) getBeanObject(beanId, beanName, request);
	bean.clear();

	String params = request.getQueryString() ;
	if(params==null || params.equals("")) params="";
	
	String function_id = request.getParameter("function_id");
	if(function_id==null || function_id.equals("")) function_id="";
	String called_from_dashboard_YN = request.getParameter("called_from_dashboard_YN");
	if(called_from_dashboard_YN == null || called_from_dashboard_YN.equals("")) called_from_dashboard_YN = "N";
	System.err.println("function_id "+function_id+", called_from_dashboard_YN= "+called_from_dashboard_YN);
	String patientId = request.getParameter("patientId");
	if(patientId==null || patientId.equals("")) patientId="";

	String facility_id = (String)session.getAttribute("facility_id");
	System.err.println("facility_id "+facility_id);
	System.err.println("params "+params);
	System.err.println("In BLAdvancedPriorAuthMainFrames.jsp ");
		

            _bw.write(_wl_block5Bytes, _wl_block5);

		if(called_from_dashboard_YN.equals("Y")){ 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(request.getParameter("title")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(params));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(called_from_dashboard_YN));
            _bw.write(_wl_block11Bytes, _wl_block11);
	}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(params));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(called_from_dashboard_YN));
            _bw.write(_wl_block13Bytes, _wl_block13);
	} 
            _bw.write(_wl_block14Bytes, _wl_block14);

putObjectInBean("bl_BLAdvancedPriorAuthBean",bean,request);   

        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
