package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.apache.commons.collections.iterators.EntrySetMapIterator;
import java.sql.*;
import java.util.*;
import eCA.*;
import eOR.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __cachartsummlabnotifyintrmdate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAChartSummLabNotifyIntrmdate.jsp", 1709115164884L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
19/04/2016	IN059255			Karthi L							 			ML-MMOH-CRF-0329.1
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
		String bean_id = "Or_ReviewResults" ;
		String bean_name = "eOR.ReviewResults";
		ReviewResults bean = (ReviewResults)getObjectFromBean(bean_id, bean_name, session);
		bean.setLanguageId(locale);
		
		Hashtable hashObj 			= (Hashtable)XMLobj.parseXMLString(request);
 		hashObj 					= (Hashtable)hashObj.get("SEARCH");
		String l_bean_id 			= (String)hashObj.get("p_bean_id");
		String l_bean_name 			= (String)hashObj.get("p_bean_name");
		String l_action 			= (String)hashObj.get("p_validate") == null?"":(String)hashObj.get("p_validate");
		String l_hist_rec_type 		= (String)hashObj.get("p_histRecType") == null?"":(String)hashObj.get("p_histRecType");
		String l_contrSysId			= (String)hashObj.get("p_contrSysId")== null?"": (String)hashObj.get("p_contrSysId");	
		String l_contrSysEventCode	= (String)hashObj.get("p_contrSysEventCode")== null?"": (String)hashObj.get("p_contrSysEventCode");	
		String l_accessionNum 		= (String)hashObj.get("p_accessionNum") == null?"":(String)hashObj.get("p_accessionNum");
		String l_eventCode			= (String)hashObj.get("p_eventCode") == null?"":(String)hashObj.get("p_eventCode");
		String l_notifyAlert 		= (String)hashObj.get("p_notifyAlert") == null?"":(String)hashObj.get("p_notifyAlert");
		String l_reviewRemarks		= (String)hashObj.get("p_reviewRemarks") == null?"":(String)hashObj.get("p_reviewRemarks");
		String l_caNormalcyInd		= (String)hashObj.get("p_caNormalcyInd") == null?"":(String)hashObj.get("p_caNormalcyInd");
		String l_practitionerId		= (String)hashObj.get("p_practitionerId") == null?"":(String)hashObj.get("p_practitionerId");
		String l_loginUserId		= (String)hashObj.get("p_loginUserId") == null?"":(String)hashObj.get("p_loginUserId");
		String l_reviewType			= "";
		String l_createDateTime 	= "";
		String review_details 		= "";
	 	String[] review_detail_array = new String[2]; 
		CAChartSummaryLabNotifyBean beanObj = (CAChartSummaryLabNotifyBean)getObjectFromBean(l_bean_id, l_bean_name, session);
		
		if(l_action.equals("SET_LAB_NOTIFY_FIELDS")) {
						
			review_details = beanObj.getReviewDetails(l_hist_rec_type, l_contrSysId, l_accessionNum, l_eventCode, l_notifyAlert, l_practitionerId);
			if(review_details != null && !"".equals(review_details)){
				review_detail_array = review_details.split("~");
				l_reviewType 		= review_detail_array[0];
				l_createDateTime 	= review_detail_array[1];
			} 
			
			beanObj.setHist_rec_type(l_hist_rec_type);
			beanObj.setContr_sys_id(l_contrSysId);
			beanObj.setContr_sys_event_code(l_contrSysEventCode);
			beanObj.setAccession_num(l_accessionNum);
			beanObj.setReview_type(l_reviewType);
			beanObj.setCreate_date_time(l_createDateTime);
			beanObj.setReview_remarks(l_reviewRemarks);
			beanObj.setNormalcy_ind(l_caNormalcyInd);
			beanObj.setPractitioner_id(l_practitionerId);
			beanObj.setLogin_user_id(l_loginUserId);
			out.println("callRvwResultsWindow();");
		}
		else if(l_action.equals("COMPLETE_REVIEW")){
			beanObj.setReview_remarks(l_reviewRemarks);
			HashMap statusMap = beanObj.completePendReivew();
			String message = (String)statusMap.get("message");
			System.out.println(" MESSAGE " + message);
			out.println("reviewCompletedStatus(\"" + message + "\" );");
		} 
		else if(l_action.equals("FORWARD_PRACT")){
			ArrayList forwardPractHash = new ArrayList();
			int totalRecs = 1;
	       for (int i = 0;i < totalRecs;i++) {
	           HashMap tempMap = new HashMap();
	           tempMap.put("hist_rec_type",beanObj.getHist_rec_type());
	           tempMap.put("contr_sys_id",beanObj.getContr_sys_id());
	           tempMap.put("accession_num",beanObj.getAccession_num());
	           tempMap.put("review_type",beanObj.getReview_type());
	           tempMap.put("event_code",beanObj.getContr_sys_event_code());
	           tempMap.put("normalcy_ind",beanObj.getNormalcy_ind());
	           forwardPractHash.add(tempMap);
	       }
	       bean.setForwardPractHash(forwardPractHash);
		}   
		
	}
	catch(Exception ex){
		ex.printStackTrace();
		System.out.println(" 69. CAChartSummLabNotifyIntrmdate.jsp = Message => " + ex.getMessage());
		
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
