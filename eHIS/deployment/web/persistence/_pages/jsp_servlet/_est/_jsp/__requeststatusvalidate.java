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
import java.lang.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __requeststatusvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/RequestStatusValidate.jsp", 1720283449662L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	
	request.setCharacterEncoding("UTF-8");
	String locale				= (String)session.getAttribute("LOCALE");
	String bean_id				=	request.getParameter("bean_id");
	String bean_name			=	request.getParameter("bean_name");	
	int functionType			=	Integer.parseInt(request.getParameter("function_type"));
		
	if ((bean_id == null) || (bean_id.equals("")))
		return;
		
	RequestStatusBean bean		=	(RequestStatusBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);

	String bean_id1 = "authorizeAtIssueStoreBean";
	String bean_name1 = "eST.AuthorizeAtIssueStoreBean";
	AuthorizeAtIssueStoreBean bean1 = (AuthorizeAtIssueStoreBean) getBeanObject(bean_id1,bean_name1,request);  
	bean1.setLanguageId(locale);

	Hashtable hash				=	(Hashtable) XMLobj.parseXMLString(request);
    hash						=	(Hashtable) hash.get ("SEARCH");	

	switch (functionType) {
	case 1:
		{
			String request_by_store = request.getParameter("request_by_store");			
			bean.setRequest_by_store(request_by_store);
			out.println("clearListItems('formRequestStatusQueryCriteria.request_on_store'); ");
			ArrayList req_by_stores = bean.getOnStoresRequestStatus(bean.getRequest_by_store());
			HashMap record = null;
			for(int i=0; i< req_by_stores.size(); i++) {
				record = (HashMap)req_by_stores.get(i);
				out.println("addListItem(\"formRequestStatusQueryCriteria.request_on_store\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
	case 2:
		{
			String request_by_store = (String) hash.get("request_by_store");
			String request_on_store = (String) hash.get("request_on_store");
			if(request_by_store.equals(null) || request_by_store.equalsIgnoreCase("null")){
				request_by_store="";
			}
			if(request_on_store.equals(null) || request_on_store.equalsIgnoreCase("null")){
				request_on_store="";
			}			

			out.println("clearListItems('formRequestStatusQueryCriteria.item_class_code'); ");
			ArrayList itemClasses = new ArrayList();

			if((!request_by_store.equals("")) && (!request_on_store.equals(""))){
				itemClasses = (ArrayList)bean1.getItemClasses(request_by_store,request_on_store);
			}
			else if((!request_by_store.equals("")) && (request_on_store.equals(""))){
				itemClasses = (ArrayList)bean1.getItemClasses(request_by_store);
			}else{
				itemClasses = (ArrayList)bean1.getDefaultItemClasses1();
			}

			HashMap record = null;
			for(int i=0; i< itemClasses.size(); i++) {
				record = (HashMap)itemClasses.get(i);
				out.println("addListItem(\"formRequestStatusQueryCriteria.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
	case 3:
		{
			String request_type = (String) hash.get("request_type");
			out.println("clearListItems('formRequestStatusQueryCriteria.request_by_store'); ");
			out.println("clearListItems('formRequestStatusQueryCriteria.item_class_code'); ");
			out.println("clearListItems('formRequestStatusQueryCriteria.request_on_store'); ");
			ArrayList reqByStore = bean.getRequestByStore(request_type);
			HashMap record = null;
			for(int i=0; i< reqByStore.size(); i++) {
				record = (HashMap)reqByStore.get(i);
				out.println("addListItem(\"formRequestStatusQueryCriteria.request_by_store\", \"" + record.get("STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
		default :
		//To be replaced with proper message
		out.println("alert(\'Invalid Function\');");
		return;
	}
	
            _bw.write(_wl_block0Bytes, _wl_block0);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
