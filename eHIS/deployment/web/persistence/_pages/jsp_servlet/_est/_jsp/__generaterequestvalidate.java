package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.Hashtable;
import eST.GenerateRequestBean;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __generaterequestvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/GenerateRequestValidate.jsp", 1719407417050L ,"10.3.6.0","Asia/Calcutta")) return true;
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
 
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------

26/11/2020      TFS:6626         Haribabu                                  ML-MMOH-SCF-1642
--------------------------------------------------------------------------------------------------------------
*/
            _bw.write(_wl_block0Bytes, _wl_block0);
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	Hashtable hash							=		(Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");

	String locale							=		(String)session.getAttribute("LOCALE");
	String bean_id							=		request.getParameter("bean_id");
	String bean_name						=		request.getParameter("bean_name");
	String validate							=		request.getParameter("validate");
	String item_class_code					=		request.getParameter("item_class_code");
	String item_class_desc					=		request.getParameter("item_class_desc");

	if(bean_id == null)
		bean_id = (String)hash.get ("bean_id");

	if(bean_name == null)
		bean_name = (String)hash.get ("bean_name");
	
	boolean result							=		false  ;
	String  message							=		"" ; 
	String  flag							=		"" ; 

	String func_type = request.getParameter("function_type") == null ? "0":request.getParameter("function_type");


	int functionType						=		Integer.parseInt(func_type);
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	GenerateRequestBean bean				=		(GenerateRequestBean) getBeanObject(bean_id, bean_name,request  );
	bean.setLanguageId(locale);
	switch (functionType) {
	case 1:
		{	
			if (validate.equals("doc_type_code")) {
				String doc_type_code = (String) hash.get("doc_type_code");
				if (doc_type_code.trim().equals("")) {
					//To be replaced with proper error message
					out.println("errorDisplay();");
					return;
				}
				if (!bean.isDocNoAutoGenYN(doc_type_code)) {
					out.println("enableDocNo();");
				}else {
					out.println("disableDocNo();");
				}
			}
		}
		break;
	case 2: // case - 2 will be executed when search button is called....
		{
				bean.addMultipleRecord(hash);
		}
		break;
	case 3:
		{
			String request_by_store = (String) hash.get("requisition_by_store");
			if (request_by_store != null && request_by_store.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			HashMap resultMap = bean.canAuthorize(request_by_store);
			if (resultMap != null) {
				String authorize = (String)resultMap.get("REQ_AUTHORIZE_ALLOWED_YN");
				if (authorize.equals("Y")) {
					authorize = "Yes";
				}else {
					authorize = "No";
				}
				out.println("setAuthorize('"+authorize+"');");
				String parent_store = (String)resultMap.get("PARENT_STORE_CODE");
				parent_store = bean.checkForNull(parent_store,"");
				
				bean.setRequisition_by_store(request_by_store);
				//To populate the requisition_on_stores
					out.println("clearListItems('formGenerateRequest.requisition_on_store'); ");
					ArrayList req_by_stores = bean.getOnStores(bean.getRequisition_by_store());
					HashMap record = new HashMap();
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formGenerateRequest.requisition_on_store\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						if(record.get("PARENT_STORE_CODE").equals(parent_store)){
							
							out.println("setParentStoreCode('"+parent_store+"');");}
					}
				
		//To populate the item classes 
				if (request_by_store != null && request_by_store.trim() != "") {
					out.println("clearListItems('formGenerateRequest.item_class_code'); ");
					ArrayList itemClasses = bean.getItemClasses(request_by_store,parent_store);
					for(int i=0; i< itemClasses.size(); i++) {
						record = (HashMap)itemClasses.get(i);
						out.println("addListItem(\"formGenerateRequest.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
					}
				}
			}
		}
		break;
		case 4: // case - 2 will be executed when search button is called....
		{
				bean.initialize();		
		}
		break;
		case 5:
		{
			String request_by_store = (String) hash.get("requisition_by_store");
			String request_on_store = (String) hash.get("requisition_on_store");

			out.println("clearListItems('formGenerateRequest.item_class_code'); ");

			ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_store);
			HashMap record = new HashMap();
			for(int i=0; i< itemClasses.size(); i++) {
				record = (HashMap)itemClasses.get(i);
				out.println("addListItem(\"formGenerateRequest.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
			}
		}
		break;

	
		case 7: 
		 {	
			try
			{
					ArrayList doc_no=bean.getPrintDocNo();
				String pdocno = "";
				for(int i=0;i<doc_no.size();i++){
					pdocno=(String)doc_no.get(i);
					//bean.doOnlineReportPrinting(pdocno);
					bean.doOnlineReportPrinting(pdocno,request,response); //Added By Sakti Sankar on 06/03/2013 against Inc#
				}
				result =  true ;
			    message = request.getParameter("msg");

			  }catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
			}
			finally{
					out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}
		break;
		case 9:
		{
			String documentdate=request.getParameter("documentdate");
			int iValidDocDate = bean.isValidDocDate(documentdate);
			if(iValidDocDate==2)
			{
				out.println("curr_date_grt_sysdaete();");
			}
			

		}	
		break;
		case 10:
		{
				if(item_class_desc.equals("---Select---"))
				{
					item_class_desc	=		"";
				}
				bean.setItem_class_code(item_class_code);
		}
		break;

		case 11:
		{
			String request_by_store = (String) hash.get("requisition_by_store");
			if (request_by_store != null && request_by_store.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
				out.println("setParentStoreCode('"+request_by_store+"');");
				bean.setRequisition_by_store(request_by_store);
		}
		break;
		case 12:
		{
			try
			{
					flag = "";
					int issue_uom_multiples = Integer.parseInt((String)request.getParameter("issue_uom_multiples"));
					//double item_qty =  Double.parseDouble(bean.checkForNull((String)request.getParameter("item_qty"),"0"))*bean.getConvFactTemp_req((String)request.getParameter("item_code"),(String)request.getParameter("store_code"));
					if(bean.getAllowDecimalsYN((String)request.getParameter("item_code")).equals("N")){
						//if(item_qty%bean.getLcm((String)request.getParameter("store_code"),(String)request.getParameter("on_store"),(String)request.getParameter("item_code"))==0)
						if(Double.parseDouble(bean.checkForNull((String)request.getParameter("item_qty"),"0"))%issue_uom_multiples ==0){
							result = true;
						}else{
							result = false;
							flag = ""+issue_uom_multiples;
						}
					}else{
						result = true;
					}
					//Added for 6626 start
					if(result){
						Hashtable hs = new Hashtable();
						String item_code=(String)request.getParameter("item_code");
						String item_qty=(String)request.getParameter("item_qty");
						String index=(String)request.getParameter("index");
						if(!(item_qty.equals("") || item_qty.equals("0"))){
							hs.put("add_itm_"+index, item_code);
							hs.put("req_qty_"+index, item_qty);
	
							bean.setAllNew(hs);
						}
						else{
							hs.put("add_itm_"+index, item_code);
							hs.put("req_qty_"+index, "0");
							bean.setAllNew(hs);
							bean.removeUnSelectedItems(item_code);
						}
						
					}
					//Added for 6626 end

				}catch(Exception e){
					result		=	false;
					message		=	e.getMessage();
					e.printStackTrace();
					flag = "";
				}
				finally{
						out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				}
	
			}
			break;
			case 13:
		{
			try
			{
				 result = false;
				bean.clearCheckedValues();
				bean.clearcheckedItem();//Added for 6626
				String request_by_store = (String) hash.get("request_by_store");
				String checkedValues = (String) hash.get("checkedValues");
				 java.util.StringTokenizer st	=		new java.util.StringTokenizer(checkedValues,"~");
				 ArrayList arr					=		new ArrayList();
				 while( st.hasMoreElements())
				 {
					 arr.add(st.nextElement() );
			 	 }

				 	bean.setCheckedValues(arr);
				 	bean.setcheckedItem(arr);//Added for 6626
				  String count="0";
					for(int i=0;i<arr.size();i++){
					count=(String)bean.fetchRecord("select count(hdr.DOC_NO) count from st_request_hdr hdr,st_request_dtl dtl where hdr.REQ_BY_STORE_CODE=? and hdr.DOC_NO=dtl.DOC_NO and dtl.ITEM_CODE=? and hdr.DOC_TYPE_CODE=dtl.DOC_TYPE_CODE and  hdr.REQUEST_STATUS='W' and hdr.FACILITY_ID=dtl.FACILITY_ID  ",new String[]{request_by_store,(String)arr.get(i)}).get("COUNT");
							
					if(!count.equals("0")){
					result=true;
					break;
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
	
			}
			break;
			default :
			{
			//To be replaced with proper message
				out.println("alert(\'Invalid Function\');");
				return;
			}
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
