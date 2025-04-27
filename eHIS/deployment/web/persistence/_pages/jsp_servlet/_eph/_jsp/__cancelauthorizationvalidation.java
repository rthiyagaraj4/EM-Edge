package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eST.Common.*;
import eST.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __cancelauthorizationvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/CancelAuthorizationValidation.jsp", 1732509139903L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	String bean_id				=	request.getParameter("bean_id");
	String bean_name			=	request.getParameter("bean_name");
	String request_by_store		=	request.getParameter("request_by_store");
	String request_on_store		=	request.getParameter("request_on_store");
	int functionType			=	Integer.parseInt(request.getParameter("function_type"));

	request.setCharacterEncoding("UTF-8");
	String locale				=	(String)session.getAttribute("LOCALE");
	boolean result			=		false;
    String message			=		"";
	String flag				=		"";
	
	
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	CancelAuthorizationBean bean		=	(CancelAuthorizationBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);
	Hashtable hash				=	(Hashtable) XMLobj.parseXMLString(request);
    hash						=	(Hashtable) hash.get ("SEARCH");	

	switch (functionType) {
	case 1:
		{
			request_on_store				=		(String) hash.get("request_on_store");
			
				bean.setRequest_on_store(request_on_store);
								
					out.println("clearListItems('formCancelAuthQueryCriteria.request_by_store'); ");
					ArrayList req_by_stores = bean.getbyStores(request_on_store);
					HashMap record = new HashMap();
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (java.util.HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formCancelAuthQueryCriteria.request_by_store\", \"" + record.get("STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						
					}
				
			}
		
		break;
		case 2:
		{
			 request_by_store = (String) hash.get("request_by_store");
			request_on_store = (String) hash.get("request_on_store");

			out.println("clearListItems('formCancelAuthQueryCriteria.item_class_code'); ");

			ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_store);
			
			HashMap record =  new HashMap();
			for(int i=0; i< itemClasses.size(); i++) {
				record = (java.util.HashMap)itemClasses.get(i);
				out.println("addListItem(\"formCancelAuthQueryCriteria.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
		case 3:
		{
			String  request_type = (String) hash.get("request_type")==null?"A":(String) hash.get("request_type");


			out.println("clearListItems('formCancelAuthQueryCriteria.request_on_store'); ");

			ArrayList request_on_store_list = bean.getRequestOnStore(request_type);
			HashMap record =  new HashMap();
			for(int i=0; i< request_on_store_list.size(); i++) {
				record = (java.util.HashMap)request_on_store_list.get(i);
				out.println("addListItem(\"formCancelAuthQueryCriteria.request_on_store\", \"" + record.get("STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;
		case 4:
		{  
		    String reason_code=(String)hash.get("reason_code");
			String row_num    =(String)hash.get("row_num");
			String col_num    =(String)hash.get("col_num");
			String called_from    =(String)hash.get("called_from");
			String doc_type    =(String)hash.get("doc_type");
			String doc_no    =(String)hash.get("doc_no");
			String facility_id    =(String)hash.get("facility_id");
			String item_code    =(String)hash.get("item_code");
			
			
			
			String remarks_desc =bean.getRemarksDesc(reason_code);
			
        
			out.println("assignRemarksDesc('"+remarks_desc+"','"+row_num+"','"+col_num+"','"+called_from+"')");
			
		}
		break;
		case 5:
		{
			bean.updateSelectedValues(hash);
		}
		break;
	default :
		
		out.println("alert(\'Invalid Function\');");
		return;
	}

            _bw.write(_wl_block1Bytes, _wl_block1);

putObjectInBean(bean_id,bean,request);

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
