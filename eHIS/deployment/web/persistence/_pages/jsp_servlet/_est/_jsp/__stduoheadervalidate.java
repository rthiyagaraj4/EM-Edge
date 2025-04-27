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

public final class __stduoheadervalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/StDuoHeaderValidate.jsp", 1723628775787L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n";
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	StDuoHeaderBean bean			=		(StDuoHeaderBean)getBeanObject( "stDuoHeaderBean","eST.Common.StDuoHeaderBean",request ) ;  
	String doc_type_code			=		request.getParameter("doc_type_code");
	String validate					=		request.getParameter("validate");
	String doc_no					=		request.getParameter("doc_no");
	String from_store_code			=		request.getParameter("from_store_code");
	String to_store_code			=		request.getParameter("to_store_code");
	String item_class_code			=		request.getParameter("item_class_code");
	String item_class_desc			=		request.getParameter("item_class_desc");
	String doc_ref					=		request.getParameter("doc_ref");
	String doc_date					=		request.getParameter("doc_date");
	String finalize_yn				=		request.getParameter("finalize_yn");
	String autono_yn				=		request.getParameter("autono_yn");
	//String issue_flag				=		request.getParameter("issue_flag");
	//String mode					=		request.getParameter("mode");
	String message					=		"";
	String flag						=		"";
	boolean	result					=		false;
	request.setCharacterEncoding("UTF-8");
	String locale					=		(String)session.getAttribute("LOCALE");
	
	bean.setLanguageId(locale);
	Hashtable hash					=		(Hashtable) XMLobj.parseXMLString(request);
    hash							=		(Hashtable) hash.get ("SEARCH");

	try{
		if (validate.equals("DOC_TYPE_CODE")){
			out.println(bean.isDocNoAutoGenYN(doc_type_code));
			out.println("enableDocNo("+!bean.isDocNoAutoGenYN(doc_type_code)+");");
			result					=			true;
		}
		else if(validate.equals("ITEM_CLASS")){
				
				if(item_class_desc.equals("---Select---"))
				{
					item_class_desc	=		"";
				}
			
				bean.setItem_class_desc(item_class_desc);
				bean.setItem_class_code(item_class_code);
			
		
		}
		else if(validate.equals("SET_DETAILS")){

			bean.setDoc_type_code(doc_type_code		);
			if(!locale.equals("en"))
			{
			doc_date=	com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");	
			//bean.setDoc_date(com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale));
			}else
			{
			doc_date=doc_date;
			bean.setDoc_date(doc_date);
			}  
			
			bean.setDoc_date(doc_date);
			bean.setDoc_ref(doc_ref);
			bean.setDoc_no(doc_no	);
//			if(!(bean instanceof eST.RequisitionIssueBean)) {
				bean.setFrom_store_code(from_store_code);
				bean.setTo_store_code(to_store_code);
				bean.setItem_class_code(item_class_code);
//			}
			if (from_store_code.equals(to_store_code)) {
				throw new Exception( "BOTH_STORE_CANNOT_BE_SAME");
			}

			bean.setItem_class_code(item_class_code);
			bean.setAutono_yn(autono_yn);
			bean.setFinalize_yn(finalize_yn);
			int iValidDocDate = bean.isValidDocDate(doc_date);
			if (iValidDocDate > 0) {
				if (iValidDocDate== 1) 
					throw new Exception( "ST_DOC_DT_NOT_LT_PROC_MTH");
				else if (iValidDocDate== 2) 
					throw new Exception( "ST_DOC_DT_NOT_GR_SYSDATE");
			}
			result=	true;
			message=	validate+doc_type_code	+
						doc_date + doc_ref +
						doc_no + to_store_code +
						item_class_code + from_store_code;
		}
		else if(validate.equals("UPDATE_DETAILS")){
			String function_id		 =		(String) hash.get("function_id");
			bean.setFunctionId(function_id);

				if(!locale.equals("en"))
			{
				doc_date =bean.getDoc_date();
				doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
			}
				else
			{
					doc_date=bean.getDoc_date();
			}
			
			out.println("setDocumentDetails(\""+bean.getDoc_type_desc()+"\", \""+bean.getDoc_no()+"\", \""+bean.getFrom_store_desc()+"\",\""+bean.getTo_store_desc()+"\", \""+bean.checkForNull(bean.getItem_class_Desc())+"\",\""+doc_date+"\", \""+bean.getDoc_ref()+"\", \""+bean.getTo_store_code()+"\", \""+bean.getFrom_store_code()+"\",\""+bean.getItem_class_code()+"\",\""+bean.getFinalize_yn()+"\",\""+bean.getAutono_yn()+"\",\""+bean.getItem_class_code()+"\",\""+bean.getDoc_type_code()+"\");"); 
			result=	true;
			message=	"";
		}
		// Changed on Aug13 to reload the item classes
		else if(validate.equals("RELOAD_ITEM_CLASSES")) {
			String request_on_store		 =		(String) hash.get("from_store_code");
			String request_by_store		 =		(String) hash.get("to_store_code");

			
			//bean.setFrom_store_code(request_by_store);
			//bean.setTo_store_code(request_on_store);
		

			if (request_on_store.trim().equals("") || request_by_store.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
		
			out.println("clearListItems('formStGeneralHeaderForMultiStore.item_class_code'); ");
			ArrayList itemClasses		= new ArrayList();
			if((bean.getFunctionId().equals("ST_AUTH_AT_ISSUE_STORE")||(bean.getFunctionId().equals("ST_ISSUE_REQ_URG"))||(bean.getFunctionId().equals("ST_STOCK_TRANSFER"))))
			itemClasses		=		 bean.getItemClasses(request_on_store, request_by_store);
			else
			itemClasses		=		 bean.getItemClasses(request_by_store, request_on_store);
			HashMap record =  null;
			for(int i=0; i< itemClasses.size(); i++) {
				record = (HashMap)itemClasses.get(i);
				
				out.println("addListItem(\"formStGeneralHeaderForMultiStore.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}			
		}
		else if(validate.equals("LOAD_PARENT_STORE_ISSUE")) {

			from_store_code				=		(String) hash.get("from_store_code");
				//bean.setFrom_store_code(from_store_code);
				
				//To populate the requisition_on_stores
					out.println("clearListItems('formStGeneralHeaderForMultiStore.to_store_code'); ");
					ArrayList req_by_stores = bean.getOnIssueStores(from_store_code);
					HashMap record = new HashMap();
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formStGeneralHeaderForMultiStore.to_store_code\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						
					}
			
		}
		else if(validate.equals("SET_TO_STORE_CODE")) {

			to_store_code				=		(String) hash.get("to_store_code");
				//bean.setTo_store_code(to_store_code);
				
				
			
		}
		else if(validate.equals("LOAD_PARENT_STORE")) {
			
			from_store_code				=		(String) hash.get("from_store_code");
			
		
			if (from_store_code != null && from_store_code.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			java.util.HashMap resultMap =		bean.canAuthorize(from_store_code);
			if (resultMap != null) {
				String authorize		=		(String)resultMap.get("REQ_AUTHORIZE_ALLOWED_YN");
				if (authorize.equals("Y")) {
					authorize = "Yes";
				}
				else {
					authorize = "No";
				}
				String parent_store		=		(String)resultMap.get("PARENT_STORE_CODE");
				parent_store			=		bean.checkForNull(parent_store,"");
				
				//bean.setFrom_store_code(from_store_code);

				//To populate the requisition_on_stores
					out.println("clearListItems('formStGeneralHeaderForMultiStore.to_store_code'); ");
					ArrayList req_by_stores = bean.getOnStores(from_store_code);
					HashMap record = null;
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formStGeneralHeaderForMultiStore.to_store_code\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");

						if(record.get("PARENT_STORE_CODE").equals(parent_store)){
							
							out.println("setParentStoreCode('"+parent_store+"');");}
					}
				
			}
		}
	}
	catch (Exception exception){
		result=	false;
		message=	exception.getMessage();
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\") ; ") ;
	}

            _bw.write(_wl_block0Bytes, _wl_block0);

putObjectInBean("stDuoHeaderBean",bean,request);

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
