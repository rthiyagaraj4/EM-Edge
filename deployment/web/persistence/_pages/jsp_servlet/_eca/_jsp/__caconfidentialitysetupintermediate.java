package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eCA.*;
import eOR.Common.*;
import eOR.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __caconfidentialitysetupintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAConfidentialitySetUpIntermediate.jsp", 1719814594798L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");

/*
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           created
10/12/2013	  IN042552		 Karthi L	 To maintain Patient's event confidentiality at Practitioner, Speciality and Responsibility level (Bru-HIMS-CRF-391)
--------------------------------------------------------------------------------------------------------
*/


            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
	
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	try{
		Hashtable hashObj 			= (Hashtable)XMLobj.parseXMLString(request);
 		hashObj 					= (Hashtable)hashObj.get("SEARCH");
		String l_bean_id 			= (String)hashObj.get("bean_id");
		String l_bean_name 			= (String)hashObj.get("bean_name");
		String l_action 			= (String)hashObj.get("p_action") == null?"":(String)hashObj.get("p_action");
		String l_hist_type 			= (String)hashObj.get("p_hist_type") == null?"":(String)hashObj.get("p_hist_type");
		String l_event_type			= (String)hashObj.get("p_event_type")== null?"": (String)hashObj.get("p_event_type");	
		String l_confdnt_id			= (String)hashObj.get("p_confdnt_id")== null?"": (String)hashObj.get("p_confdnt_id");	
		/*
		*	Pagination Data
		*/
		
		String  ctnChkBox			= (String)hashObj.get("p_ctnChkBox") == null?"":(String)hashObj.get("p_ctnChkBox");
		String 	confidntType		= (String)hashObj.get("p_confidnt_type") == null?"":(String)hashObj.get("p_confidnt_type");
		String	result_data_code	= (String)hashObj.get("p_result_data_code") == null?"":(String)hashObj.get("p_result_data_code");
		String	view_list_data		= (String)hashObj.get("p_view_list_data") == null?"":(String)hashObj.get("p_view_list_data");
		String	view_by_data		= (String)hashObj.get("p_view_by_data") == null?"":(String)hashObj.get("p_view_by_data");
		String	based_on_data		= (String)hashObj.get("p_based_on_data") == null?"":(String)hashObj.get("p_based_on_data");
		String  l_search_code		= (String)hashObj.get("p_search_code") == null?"":(String)hashObj.get("p_search_code");
		String 	l_header_filter_based_on	= (String)hashObj.get("p_header_filter_based_on") == null?"":(String)hashObj.get("p_header_filter_based_on");
		int selectedRecords = 0;
		ArrayList l_event_codes =  null;
		HashMap l_set_page_data = null;
		HashMap confdntHashMap = null;
		ArrayList l_condnt_key_list = null;
		CAConfidentialitySetUpBean beanObj = (CAConfidentialitySetUpBean)getBeanObject(l_bean_id, l_bean_name, request);
		confdntHashMap = beanObj.getConfidentialityMapData();
		l_condnt_key_list = beanObj.getKeyConfidentDataArrayList();
		/*if(l_action.equals("LOAD_EVENT_DATA")){
			l_event_codes = beanObj.getEventCodes(l_hist_type, l_event_type, locale); 
			out.println( "clearEventCodes();");
			for( int i=0 ; i< l_event_codes.size() ; i++ ) 
			{
				String[] l_record_details = (String[])l_event_codes.get(i); 
				out.println( "addEventCodes(\"" + l_record_details[0] + "\",\"" + l_record_details[1] + "\") ; " ) ;
			}
		}*/
		//else if(l_action.equals("LOAD_CONT_SYS_CODE")) {
		if(l_action.equals("LOAD_CONT_SYS_CODE")) {
			l_event_codes = beanObj.getContSysCode(l_hist_type);
			out.println( "clearContSysCodes();");
			for( int i=0 ; i< l_event_codes.size() ; i++ ) 
			{
				String[] l_record_details = (String[])l_event_codes.get(i); 
				out.println( "addContSysCodes(\"" + l_record_details[0] + "\",\"" + l_record_details[1] + "\") ; " ) ;
			}
		}
		else if(l_action.equals("SET_EVENT_DATA")){
			l_set_page_data = beanObj.setPaginateData(ctnChkBox, confidntType, result_data_code, view_list_data, view_by_data, based_on_data);
			selectedRecords = l_set_page_data.size();
			beanObj.setConfidentialityMapData(l_set_page_data);
			selectedRecords = l_condnt_key_list.size();
			out.println("selectedRecordCounts(\"" + selectedRecords + "\");");
		} 
		else if(l_action.equals("LOAD_EXIST_PRIVILEGE_DATA")){
			l_set_page_data = beanObj.loadStoredEventData(l_hist_type, l_event_type, l_confdnt_id, l_search_code, view_list_data, view_by_data, based_on_data, l_header_filter_based_on);
			
			if(l_set_page_data != null)
			{
				//selectedRecords = l_set_page_data.size();
				beanObj.setConfidentialityMapData(l_set_page_data);
				HashMap getMapConfidentKey = beanObj.getConfidentialityMapData();
				l_condnt_key_list = new ArrayList();
 				Iterator itr = l_set_page_data.keySet().iterator();
				String key_confdnt_id = "";
				
				while(itr.hasNext())
				{
					key_confdnt_id = itr.next().toString();
					l_condnt_key_list.add(key_confdnt_id);
				}
				selectedRecords = l_condnt_key_list.size();
				beanObj.setKeyConfidentDataArrayList(l_condnt_key_list);
			}
			out.println("selectedRecordCounts(\"" + selectedRecords + "\" );");
		}
		else if(l_action.equals("EMPTY_MAP_DATA")){
			selectedRecords= 0 ;
			if(confdntHashMap != null){
				confdntHashMap.clear();
			}

			if(l_condnt_key_list != null)
			{
				if(l_condnt_key_list.size() > 0)
				{
					l_condnt_key_list.clear();
				}
			}
			out.println("selectedRecordCounts(\"" + selectedRecords + "\" );");
		}
	}
	catch(Exception ex){
		ex.printStackTrace();
		System.out.println(" 69. CAConfidentialitySetUpIntermediate.jsp = Message => " + ex.getMessage());
		
	}


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
