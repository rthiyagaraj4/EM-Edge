package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __suspendorreinstatebatchvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/SuspendOrReinstateBatchValidate.jsp", 1718701037368L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
  request.setCharacterEncoding("UTF-8");
	String locale						=		(String)session.getAttribute("LOCALE");
	int functionType					=		Integer.parseInt(request.getParameter("function_type"));

	String bean_id						=		"SuspendOrReinstateBatchBean";
	String bean_name					=		"eST.SuspendOrReinstateBatchBean";
	SuspendOrReinstateBatchBean bean	=		(SuspendOrReinstateBatchBean) getBeanObject( bean_id,  bean_name,request  );  

	bean.setLanguageId(locale);
	bean.clear();
	Hashtable hash						=		(Hashtable) XMLobj.parseXMLString(request);
    hash								=		(Hashtable) hash.get ("SEARCH");
	switch (functionType) {
	case 1:
		{
			String Item_code			=		bean.checkForNull((String) hash.get("item_code"));
			String manufacturer			=		bean.checkForNull((String) hash.get("manufacturer"));
            String stNotifiedItems		=		bean.checkForNull((String) hash.get("include_complained_items"));

			//String Batch				=		((String) hash.get("Batch")).equals("S")?"A":"S";

            String Batch				=		bean.checkForNull((String) hash.get("Batch")) ;

            String stTempBatch			=		 Batch ;
			String  item_batch = "";
			String  st_batch = "";
           
			if(stTempBatch.equals("S")){
				if(stNotifiedItems.equals("Y")){
                   Batch = "C" ;
              	   bean.setBatchStatusNotify("C");
				    item_batch = "C";
				   st_batch = "C";
				}
                if(stNotifiedItems.equals("N")){
                   Batch = "A" ;
              	   bean.setBatchStatusNotify("C");
				   item_batch = "N";
				      st_batch = "C";
				}
			} 

			if (stTempBatch.equals("R")){ 
				
                if(stNotifiedItems.equals("N")) {
                  Batch = "S" ;
             	  bean.setBatchStatusNotify("S");
				  item_batch = "Y";
				   st_batch = "Y";
				}
				if(stNotifiedItems.equals("Y")){
                  Batch = "S" ;
             	  bean.setBatchStatusNotify("C");
				   item_batch = "Y";
				   st_batch   = "C";
				}
				              }

			if (stTempBatch.equals("C")){

				if(stNotifiedItems.equals("N")) {
                  Batch = "A" ;
             	  bean.setBatchStatusNotify("A");
				   item_batch = "N";
				   st_batch = "N";
				}
				if(stNotifiedItems.equals("Y")){
                  Batch = "A" ;
             	  bean.setBatchStatusNotify("C");
				  item_batch = "N";
				   st_batch = "C";
				}
			}
			bean.setItem_code(Item_code);
			bean.setManufacturer(manufacturer);
			bean.setBatch(Batch);
			bean.setBatch_status((String) hash.get("Batch"));
			bean.setBatch_id((String) hash.get("batch_id"));
			//Added by Rabbani #Bru-HIMS-CRF-111[Inc no :30070] on  05-AUG-2013 Starts
			bean.setFacility(bean.checkForNull((String) hash.get("dflt_facility_id")));
			bean.setStore_code(bean.checkForNull((String) hash.get("store_code")));
			//ends
           // bean.loadResultPage(); // most important  
            bean.loadResultPage(item_batch,st_batch); // most important 
	}
	break;
	case 2:
		{
			String start					=		(String) hash.get("start");
			String end						=		(String) hash.get("end");

            bean.setCheckbox(hash,Integer.parseInt(start),Integer.parseInt(end));
			out.println(bean.getDataList());
			
		}
	break;

    case 3:
		{
		bean.setProfile((String)hash.get("profile")); 
		bean.updateRemarks(hash);

		}
	break;

	case 4:
		{
			//bean.updateSelectedValues(hash);
		}
	break;
	case 5 :
		{
				out.println("clearListItems('document.SuspendReinstate_form.manufacturer'); ");
				try
				{
					ArrayList manufacturer_list		=		bean.getManufacturerList_item(bean.checkForNull(request.getParameter("item_code")));
					if (manufacturer_list!=null && manufacturer_list.size()>0)
					{
						HashMap record			= null;
						for(int i=0; i< manufacturer_list.size(); i++) 
						{
							record			=		(HashMap)manufacturer_list.get(i);
							String listRecord1		=		bean.checkForNull((String)record.get("MANUFACTURER_ID"));
							String listRecord2		=		bean.checkForNull((String)record.get("SHORT_NAME"));
							out.println("addListItem(\"document.SuspendReinstate_form.manufacturer\", \"" +listRecord1+ "\",\"" +listRecord2+ "\") ; ");
						}
					}
				}catch(Exception e)
				{
					e.printStackTrace();
				}

		}
		break;

	
	default :
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
