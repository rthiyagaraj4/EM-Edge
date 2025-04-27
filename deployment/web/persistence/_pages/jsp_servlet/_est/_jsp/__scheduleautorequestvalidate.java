package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Hashtable;
import java.util.ArrayList;
import eST.ScheduleAutoRequestBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __scheduleautorequestvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ScheduleAutoRequestValidate.jsp", 1719374930029L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block0Bytes, _wl_block0);

	request.setCharacterEncoding("UTF-8");

	String locale							=		(String)session.getAttribute("LOCALE");
	String bean_id							=		request.getParameter("bean_id");
	String bean_name						=		request.getParameter("bean_name");
	boolean result							=		false  ;
	String  message							=		"" ; 
	String  flag							=		"" ; 

	if ((bean_id == null) || (bean_id.equals("")))
		return;
	ScheduleAutoRequestBean bean				=		(ScheduleAutoRequestBean) getBeanObject(bean_id, bean_name,request  );
	bean.setLanguageId(locale);
	String functionType						=	bean.checkForNull(request.getParameter("function_type"),"");
	Hashtable hash							=		(Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");

	if(functionType.equals("POPULATEITEMCLASSES"))
		{
			String request_by_store = (String) hash.get("requisition_by_store");
			String request_on_store = (String) hash.get("requisition_on_store");

			out.println("clearListItems('schduleAutoRequestForm.item_class_code'); ");

			ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_store);
			HashMap record = new HashMap();
			for(int i=0; i< itemClasses.size(); i++) {
				record = (HashMap)itemClasses.get(i);
				out.println("addListItem(\"schduleAutoRequestForm.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}else if(functionType.equals("CHECHFORDUPLICATESCHDULECODE")){
			try
			{
					flag = "";
					String count="";
					ArrayList alparam=new ArrayList();
					String schdule_code = 	  (String)request.getParameter("schdule_code")==null?"":(String)request.getParameter("schdule_code");
					alparam.add(bean.getLoginFacilityId().trim());
					alparam.add(schdule_code.trim().toUpperCase());
					count=(String)bean.fetchRecord("select COUNT(*) COUNT from ST_AUTO_REQ_rule_HDR where FACILITY_ID=? and  SCH_CODE=?",alparam).get("COUNT");
					if(count.equals("0")){
						result = true;
					}else{
						result = false;
					}
				}catch(Exception e){
					result		=	false;
					message		=	e.getMessage();
					e.printStackTrace();
					flag = "";
				}
				finally{
						out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				}
	
			}else if(functionType.equals("SELECTALL"))	{
			try
			{
	String code= (String)request.getParameter("code")==null?"":(String)request.getParameter("code");
	String selected_yn =   (String)request.getParameter("selected")==null?"":(String)request.getParameter("selected");
	int count=0;
	ArrayList		autoSheduleRequestRecordDetails = bean.getApplicableSchduleItems();
	String	temp_auto_type="";

	ArrayList associated_sel=bean.getAssociated_sel();

if(!code.equals("")){
	while((associated_sel != null) && (count < associated_sel.size())){
			temp_auto_type = (String)associated_sel.get(count);
			if(code.equals(temp_auto_type)){
				if(selected_yn.equals("Y")){
					 associated_sel.set(count+2,"Y");
									}else{
					 associated_sel.set(count+2, "N");
				}
					}
			count+=4;

		}

}else{
		int from =   Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
		int to =   Integer.parseInt(request.getParameter("to")==null?"0":request.getParameter("to"));
		count= from *4;
		to = to *4;

	String tempc="";
		if(to > autoSheduleRequestRecordDetails.size())
			to = autoSheduleRequestRecordDetails.size();
		while((autoSheduleRequestRecordDetails != null) && (count <=to)){
			tempc=(String)autoSheduleRequestRecordDetails.get(count);
			int jj=associated_sel.indexOf(tempc);
			if(selected_yn.equals("Y")){
			associated_sel.set(jj+2, "Y");
			}else{
			associated_sel.set(jj+2, "N");
			}
	
			count+=4;
		}
		}
		}catch(Exception e){
					result		=	false;
					message		=	e.getMessage();
					e.printStackTrace();
					flag = "";
				}
				finally{
						out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				}
	
			}else if(functionType.equals("CHECHFORATLEASTONERECORD")){
			try
			{
				flag = "";
				int count=0;
				ArrayList beanvalues	= bean.getAssociated_sel();
        		 if(beanvalues.size()!=0)	{
				for(int i=0; i<beanvalues.size(); i=i+4)		{
				String	rec	=	(String)beanvalues.get(i+2);
				if(rec.equals("Y") )  {
				count=count+1;
				}
				}
				}
				if(count==0){
						result = false;
					}else{
						result = true;
					}
				}catch(Exception e){
					result		=	false;
					message		=	e.getMessage();
					e.printStackTrace();
					flag = "";
				}
				finally{
						out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				}
	
			}else if(functionType.equals("POPULATEREQUESTONSTORE")){
			String request_by_store = (String) hash.get("requisition_by_store");
			if (request_by_store != null && request_by_store.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			HashMap resultMap = bean.canAuthorize(request_by_store);
			
				String parent_store = (String)resultMap.get("PARENT_STORE_CODE");
				parent_store = bean.checkForNull(parent_store,"");
				
				bean.setRequisition_by_store(request_by_store);
				//To populate the requisition_on_stores
					out.println("clearListItems('schduleAutoRequestForm.requisition_on_store'); ");
					ArrayList req_by_stores = bean.getOnStores(bean.getRequisition_by_store());
					HashMap record = new HashMap();
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"schduleAutoRequestForm.requisition_on_store\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						if(record.get("PARENT_STORE_CODE").equals(parent_store)){
							
							out.println("setParentStoreCode('"+parent_store+"');");}
					}
				
		//To populate the item classes 
				if (request_by_store != null && request_by_store.trim() != "") {
					out.println("clearListItems('schduleAutoRequestForm.item_class_code'); ");
					ArrayList itemClasses = bean.getItemClasses(request_by_store,parent_store);
					for(int i=0; i< itemClasses.size(); i++) {
						record = (HashMap)itemClasses.get(i);
						out.println("addListItem(\"schduleAutoRequestForm.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
					}
				}
			}
		

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
