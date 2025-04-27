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
import eCommon.Common.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __rcmtransactionspersistance extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/RCMTransactionsPersistance.jsp", 1709114145817L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser xmlObj= null;{
                xmlObj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("xmlObj");
                if(xmlObj==null){
                    xmlObj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("xmlObj",xmlObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	System.err.println("Persitence file called.deff.");
	String params = request.getQueryString();
	String beanId = "bl_BLRCMTransactionsBean";
	String beanName = "eBL.BLRCMTransactionsBean";
	System.err.println("Drug category Persitence file called..");
	
	
	BLRCMTransactionsBean policyBean = (BLRCMTransactionsBean) getBeanObject(beanId, beanName, request);
	
	if(policyBean.getPolicyMap() == null){
		policyBean.setPolicyMap(new HashMap<String, List<BLRCMTransactionsBean>>());
	}
	
	HashMap<String, List<BLRCMTransactionsBean> > policyMap = policyBean.getPolicyMap();
	
	try 
	{
	
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
	
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    	hash = (Hashtable)hash.get( "SEARCH" ) ;	
			
			String facilityId = (String)session.getValue( "facility_id" ) ;
			String loggedInUser = (String)session.getValue("login_user");	
			List<BLRCMTransactionsBean> covList = new ArrayList<BLRCMTransactionsBean>();
			BLRCMTransactionsBean covBean = null;
			int cnt = Integer.parseInt((String)hash.get("bill_tot_rec"));
			
			System.err.println("Rowcount is:"+cnt);
			
			for(int i=0; i<cnt; i++){
				covBean = new BLRCMTransactionsBean();
				System.err.println("covList is:"); 
				System.err.println("Status is:"+hash.get("checkedStatus_"+i));
				
				covBean.setFacilityId((String)hash.get("facility_id"));
				covBean.setPayerGroupCode((String)hash.get("payerGrpCode_"+i));
				covBean.setPayerCode((String)hash.get("payerCode_"+i));
				covBean.setPolicyTypeCode((String)hash.get("policyTypeCode_"+i));
				covBean.setApprDocRefNum((String)hash.get("apprDocRefNum_" + i));
				covBean.setClaimID((String)hash.get("claimID_" + i));
				covBean.setEpisodeType((String)hash.get("episodeType_"+i));
				covBean.setEncounterId((String)hash.get("encounterId_" + i));
				covBean.setVisitAdmitDt((String)hash.get("visitAdmitDt_" + i));
				covBean.setCheckoutDiscDt((String)hash.get("checkoutDiscDt_" + i));  
				covBean.setPatientId((String)hash.get("patientId_" + i));
				covBean.setPatientName((String)hash.get("patientName_" + i));
				covBean.setBillDocTypeCode((String)hash.get("billDocTypeCode_" + i));
				covBean.setBillNum((String)hash.get("billNum_" + i));
				covBean.setNetBillAmt((String)hash.get("netBillAmt_" + i));
				covBean.setApprBillAmt((String)hash.get("apprBillAmt_" + i)); 
				covBean.setReceiptDocRefNum((String)hash.get("receiptDocRefNum_" + i));
				covBean.setBillRemarks((String)hash.get("billRemarks_"+i));
				covBean.setClaimStatus((String)hash.get("claimStatus_" + i));
				covBean.setCheckedStatus((String)hash.get("checkedStatus_" + i));
				covBean.setClaimsServicesLevel((String)hash.get("claimsServicesLevel_" + i));  
				covBean.setStateDurFrom((String)hash.get("StateDurFrom"));
				covBean.setStateDurTo((String)hash.get("StateDurTo"));
				covBean.setApprTotalRec((String)hash.get("apprTotalRec"));
				covBean.setBillTotalRec((String)hash.get("billTotalRec"));
				covBean.setMembershipNo((String)hash.get("membershipNo_"+i));
				covBean.setFileName((String)hash.get("fileName_"+i));
				
				System.err.println("EnID "+(String)hash.get("encounterId_" + i));
				System.err.println("PatID "+(String)hash.get("patientId_" + i));
				System.err.println("BillDocTypeCode "+(String)hash.get("billDocTypeCode_" + i));
				System.err.println("BillNo "+(String)hash.get("billNum_" + i));
				System.err.println("membershipNo "+(String)hash.get("membershipNo_" + i));
				System.err.println("fileName "+(String)hash.get("fileName_" + i));
				
				covList.add(covBean); 
				System.err.println("covList .."+covList.isEmpty());   
			}  
			if(!(covList.isEmpty()))
				policyMap.put("BLRCMTransactionsDtl", covList);  
			 
			
			System.err.println("Data is in Policy Map..");
		
	
		
	}catch (Exception e) {	
		e.printStackTrace();
		System.err.println("Exception from BLDischargeValidation :" + e);
	} 
	putObjectInBean("bl_BLRCMTransactionsBean",policyBean,request);   
	
	
	

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
