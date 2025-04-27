package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import eBL.Common.*;
import eBL.*;
import eBL.PreApprovalRequestDetailsBean;
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __billingrecordapprovalmodalvalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillingRecordApprovalModalValidations.jsp", 1709114077428L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

String beanId = "PreApprovalRequestDetailsBean";
String beanName = "eBL.PreApprovalRequestDetailsBean";
ArrayList<String[]> modalList = null;
PreApprovalRequestDetailsBean preApprovalRequestDetailsBean 	=  (PreApprovalRequestDetailsBean)getBeanObject(beanId, beanName, request);
	try 
	{
		request.setCharacterEncoding("UTF-8");
		modalList	= new ArrayList();
		String locale = (String) session.getAttribute("LOCALE");
		Hashtable hash = (Hashtable) xmlObj.parseXMLString(request);
		hash = (Hashtable) hash.get("SEARCH");
		System.out.println(" hash .... Inside BillingRecordApprovalModalValidations.jsp:::: "+hash);
		 for (int i = 0; i < hash.size(); i++) 
		{
			if(hash.get("billing_service_code"+i)!=null && hash.get("billing_service_code"+i)!="")
			{
				String[] tempString = new String[23];
				tempString[0]											=	(String) hash.get("patinetId");
				tempString[1]											=	(String) hash.get("episodeType");
				tempString[2]											=	(String) hash.get("episodeId");
				tempString[3]											=	(String) hash.get("visitId");
				tempString[4]											=	(String) hash.get("encounterId");
				tempString[5]											=	(String) hash.get("policyTypeCode");
				tempString[6]											=	(String) hash.get("custGroupCode");
				tempString[7]											=	(String) hash.get("custCode");
				tempString[8]											=	(String) hash.get("acctSeqNo");
				tempString[9]											=	(String) hash.get("priority");
				tempString[10]											=	(String) hash.get("policyNumber");
				tempString[11]											=	(String) hash.get("billing_grp_id");

				tempString[12]											=	(String) hash.get("billing_service_code"+i);
				tempString[13]											=	(String) hash.get("included_excluded"+i);
				tempString[14]											=	(String) hash.get("approval_number"+i);
				tempString[15]											=	(String) hash.get("app_req_date");
				tempString[16]											=	(String) hash.get("approved_date"+i);
				tempString[17]											=	(String) hash.get("approval_status"+i);
				tempString[18]											=	(String) hash.get("approval_remarks"+i);

				tempString[19]											=	(String) hash.get("status");
				tempString[20]											=	(String) hash.get("effective_from");
				tempString[21]											=	(String) hash.get("available_service_amount"+i);
				tempString[22]											=	(String) hash.get("reason"+i);
				
				if(preApprovalRequestDetailsBean.getPreApprovalRequestModalDetailsList()!=null && preApprovalRequestDetailsBean.getPreApprovalRequestModalDetailsList().size()>0)
				{
					ArrayList<String[]> tempModalList = preApprovalRequestDetailsBean.getPreApprovalRequestModalDetailsList();
					tempModalList.add(tempString);
					preApprovalRequestDetailsBean.setPreApprovalRequestModalDetailsList(tempModalList);
				}
				else
				{
					modalList.add(tempString);
					preApprovalRequestDetailsBean.setPreApprovalRequestModalDetailsList(modalList);
				}
			}
			
		}
		 putObjectInBean(beanId, preApprovalRequestDetailsBean, request);
		
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Exception from BillingRecordApprovalModalValidations.jsp :"+ e);
	}

	 

	
	
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
