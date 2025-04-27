package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __computestocklevelsstoresvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ComputeStockLevelsStoresValidate.jsp", 1720363605026L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!--<!DOCTYPE html>-->\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
		
	ComputeStockLevelsStoresBean bean = (ComputeStockLevelsStoresBean)getBeanObject( "ComputeStockLevelsStoresBean", "eST.ComputeStockLevelsStoresBean", request ) ;  
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
	String validate			=		request.getParameter("validate")==null?"":request.getParameter( "validate" );
    hash = (Hashtable) hash.get ("SEARCH");

/*	Hashtable hash			=		 new Hashtable();
	String c1				=		request.getParameter( "consumption_period" )==null?"":request.getParameter( "consumption_period" );
	String c2				=		request.getParameter( "fm_item_class_code" )==null?"":request.getParameter( "fm_item_class_code" );
	String c3				=		request.getParameter( "to_item_class_code" )==null?"":request.getParameter( "to_item_class_code" );
	String c4				=		request.getParameter( "fm_item_code" )==null?"":request.getParameter( "fm_item_code" );
	String c5				=		request.getParameter( "to_item_code" )==null?"":request.getParameter( "to_item_code" );
	String c6				=		request.getParameter( "store_code" )==null?"":request.getParameter( "store_code" );
	String c7				=		request.getParameter( "buffer_percentage" )==null?"":request.getParameter( "buffer_percentage" );
	String p_stk_issue		=		request.getParameter( "p_stk_issue" )==null?"":request.getParameter( "p_stk_issue" );
	String validate			=		request.getParameter("validate")==null?"":request.getParameter( "validate" );
	 Hashtable hash1		=		(Hashtable) XMLobj.parseXMLString(request);

	hash.put("consumption_period", c1) ;
	hash.put("fm_item_class_code", c2) ;
	hash.put( "to_item_class_code",c3) ;
	hash.put("fm_item_code",c4 ) ;
	hash.put( "to_item_code",c5) ;
	hash.put("store_code", c6) ;
	hash.put("buffer_percentage", c7) ;
	hash.put("p_stk_issue",p_stk_issue) ;*/
	
	if (validate.equals("FETCH_ITEM")) {
		bean.loadData(hash);
	}
	else if (validate.equals("UPDATE_DETAILS")) {
		   bean.updateData(hash);
	}

            _bw.write(_wl_block2Bytes, _wl_block2);

	putObjectInBean("ComputeStockLevelsStoresBean",bean,request);

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
