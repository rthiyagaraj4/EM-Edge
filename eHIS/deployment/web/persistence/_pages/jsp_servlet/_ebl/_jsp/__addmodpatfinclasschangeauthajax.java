package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import java.text.*;
import eBL.*;
import eBL.BLReportIdMapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import org.json.simple.JSONObject;

public final class __addmodpatfinclasschangeauthajax extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModPatFinClassChangeAuthAjax.jsp", 1727948166772L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\t\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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



public String appendDelimiter(String patientId, String AuthYN, String delimiter){
	System.err.println("AddModPatFinClassChangeAuthAjax.jsp patientId :: "+patientId+" AuthYN :: "+AuthYN+" delimiter :: "+delimiter);
	
	if(patientId==null){
		return patientId;
	}
	else{
		return patientId+delimiter+AuthYN;
	}
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);


try{
	JSONObject obj=new JSONObject();
	System.err.println("AddModPatFinClassChangeAuthAjax.jsp");
	
	String classTypChangeAuthYN=request.getParameter("classTypChangeAuthYN");
// 	String refreshAuth=request.getParameter("refreshAuth");
// 	String tabsSwapped=request.getParameter("tabsSwapped");
	String patientId=request.getParameter("patientId");
	String called_from=request.getParameter("called_from");
	String delimiter="::";
	String classTypChangeAuthYnPatId="";
	String prevPatId=request.getParameter("prevPatId");
	
	if(("authUser").equals(called_from)){
		
		System.err.println("authUser classTypChangeAuthYnPatId : " + classTypChangeAuthYnPatId);
		classTypChangeAuthYnPatId=appendDelimiter(patientId,classTypChangeAuthYN,delimiter);		
		System.err.println("classTypChangeAuthYnPatId : " + classTypChangeAuthYnPatId);
		session.setAttribute("classTypChangeAuthYnPatId",classTypChangeAuthYnPatId);		
		classTypChangeAuthYnPatId= (String)session.getAttribute("classTypChangeAuthYnPatId");		
		System.err.println("classTypChangeAuthYnPatId : " + classTypChangeAuthYnPatId);
		
	}
	else if(("onLoad").equals(called_from)){	

		System.err.println("onload removing classTypChangeAuthYN value from session "+classTypChangeAuthYnPatId);	
		classTypChangeAuthYnPatId= (String)session.getAttribute("classTypChangeAuthYN");	
		System.err.println("removing classTypChangeAuthYN value from session :: "+classTypChangeAuthYnPatId);
		if(classTypChangeAuthYnPatId != null ){
			String[] classTypChangeTokens=classTypChangeAuthYnPatId.split(delimiter);
			prevPatId=classTypChangeTokens[0];
			classTypChangeAuthYN=classTypChangeTokens[1];
			if(prevPatId != null){
				if(!(patientId.equals(prevPatId))){
					session.removeAttribute("classTypChangeAuthYnPatId");	
				}
			}
		}
		System.err.println("AddModPatFinClassChangeAuthAjax.jsp onload prevPatId "+prevPatId+"patientId "+patientId+"classTypChangeAuthYN " + classTypChangeAuthYN);
	
		
	}
// 	else if(("getSessionVal").equals(called_from)){
// 		System.err.println("getting session value: classTypChangeAuthYN value from session "+classTypChangeAuthYnPatId);	
// 		classTypChangeAuthYnPatId= (String)session.getAttribute("classTypChangeAuthYnPatId");	
// 		System.err.println("getting session value: classTypChangeAuthYN value from session "+classTypChangeAuthYnPatId);	
// 	}
	
	System.err.println("AddModPatFinClassChangeAuthAjax.jsp prevPatId "+prevPatId+"patientId "+patientId+"classTypChangeAuthYN " + classTypChangeAuthYN);
	out.println("SUCCESS");

	obj.put("classTypChangeAuthYnPatId",classTypChangeAuthYnPatId);
	System.err.println("classTypChangeAuthYnPatId==="+classTypChangeAuthYnPatId);
	out.println(classTypChangeAuthYnPatId);   

}
catch(Exception e){	
	e.printStackTrace();
	System.err.println("AddModPatFinClassChangeAuthAjax.jsp : " + e);
}



            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
