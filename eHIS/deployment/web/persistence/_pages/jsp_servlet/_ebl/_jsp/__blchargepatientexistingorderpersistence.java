package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.placeorder.model.BLChargePatientExistingOrderBean;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.Gson;
import com.iba.framework.core.util.UtilDateConverter;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.net.URLDecoder;
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

public final class __blchargepatientexistingorderpersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLChargePatientExistingOrderPersistence.jsp", 1709114094193L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n";
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


	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

	private String decodeParam(String input){
	String output = "";
	if(input!=null){
		output = URLDecoder.decode(input);
	}
	return output;
		
	}
	
	


private String decodeParamUTF(String input){
	String output = "";
	try{
		if(input!=null){
			input = input.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
			input = input.replaceAll("\\+", "%2B");
			output = URLDecoder.decode(input,"UTF-8");
		}
	}
	catch(Exception e){
		System.err.println("Exception while Decoding BillReceiptAjax->"+e);
	}
	return output;
}


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
// Page Added by Rajesh V. To Persist all the services in New Order 
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String params = request.getQueryString();
	String sqlCoverage = "";
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	String beanId = "BLChargePatientExistingOrderBean" ;
	String beanName = "eBL.placeorder.model.BLChargePatientExistingOrderBean";

	BLChargePatientExistingOrderBean serviceBean = (BLChargePatientExistingOrderBean) getObjectFromBean(beanId, beanName, session);
	String facility_id = (String)session.getAttribute("facility_id");
	ResourceBundle rb = null;
	Locale loc = null;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	
	Connection 	con = null;
	CallableStatement cstmt = null;
	try 
	{
		con = ConnectionManager.getConnection();
		request.setCharacterEncoding("UTF-8");
		
		String locale = (String)session.getAttribute("LOCALE");
		String func_mode = request.getParameter("func_mode");
		String event = (request.getParameter("event") == null ? "" : request.getParameter("event"));
		
		Hashtable hash = (Hashtable)xmlObj.parseXMLString( request ) ;
	    hash = (Hashtable)hash.get( "SEARCH" ) ;
		Calendar cal = Calendar.getInstance();
		java.util.Date dt = cal.getTime();
		
		String facilityId = (String)session.getValue( "facility_id" ) ;
		String loggedInUser = (String)session.getValue("login_user");	
		
		List<BLChargePatientExistingOrderBean> serviceList = null;
		
		if(func_mode!= null && "persistExistingOrderBean".equals(func_mode)){
			Gson gson = new Gson();
			JsonParser jsonParser = new JsonParser();
			//JSONObject existingOrder = new JSONObject(request.getParameter("existingOrderObject"));
			
			/*serviceBean.setEpisodeType((String) existingOrder.get("episodeType"));
			serviceBean.setEpisodeId((String) existingOrder.get("episodeId"));
			serviceBean.setVisitId((String) existingOrder.get("visitId"));
			serviceBean.setEncounterId((String) existingOrder.get("encounterId"));
			serviceBean.setAcctSeqNo((String) existingOrder.get("acctSeqNo"));
			serviceBean.setPatientId((String) existingOrder.get("patientId"));
			serviceBean.setOrderId((String) existingOrder.get("orderId"));
			serviceBean.setOrderLineNum((String) existingOrder.get("orderLineNum"));
			serviceBean.setSubModuleId((String) existingOrder.get("subModuleId"));
			serviceBean.setSubRegnNum((String) existingOrder.get("subRegnNum"));
			serviceBean.setSubRegnLineNum((String) existingOrder.get("subRegnLineNum"));
			serviceBean.setServCode((String) existingOrder.get("servCode"));
					
			serviceBean.setServDesc((String) existingOrder.get("servDesc"));
			serviceBean.setServOrPanel((String) existingOrder.get("servOrPanel"));		
			serviceBean.setItemCode((String) existingOrder.get("itemCode"));
			serviceBean.setItemDesc((String) existingOrder.get("itemDesc"));
			serviceBean.setServQty((String) existingOrder.get("baseQty"));
			serviceBean.setBaseChargeAmount((String) existingOrder.get("baseChargeAmount"));
			serviceBean.setServDiscount((String) existingOrder.get("disc_amt"));
			serviceBean.setNetCharge((String) existingOrder.get("netChargeAmount"));
			serviceBean.setPhysicianId((String) existingOrder.get("physicianId"));
			serviceBean.setServedpanelQty((String) existingOrder.get("servedpanelQty"));
			serviceBean.setUomCode((String) existingOrder.get("uomCode"));
			serviceBean.setPractStaffInd((String) existingOrder.get("practStaffInd"));
					
			serviceBean.setInclExclInd((String) existingOrder.get("inclExclInd"));
			serviceBean.setReason((String) existingOrder.get("reason"));
					
			serviceBean.setFutureOrder((String) existingOrder.get("futureOrder"));
			serviceBean.setFutureOrderChargeLater((String) existingOrder.get("futureOrderChargeLater"));
			serviceBean.setRemarks((String) existingOrder.get("remarks"));
					
			serviceBean.setPackInd((String) existingOrder.get("packInd"));
			serviceBean.setDailyProcessInd((String) existingOrder.get("dailyProcessInd"));
			serviceBean.setBedTypeCode((String) existingOrder.get("bedTypeCode"));
			serviceBean.setTokenSerial((String) existingOrder.get("tokenSeriesCode"));
			serviceBean.setTokenSerialNo((String) existingOrder.get("tokenSeriesNo"));
			
			serviceBean.setDispLocn((String) existingOrder.get("dispLocn"));		
			serviceBean.setTrxDocRef((String) existingOrder.get("trxDocRef"));
			serviceBean.setTrxDocRefSeqNum((String) existingOrder.get("trxDocRefSeqNum"));
			serviceBean.setTrxDocRefLineNum((String) existingOrder.get("trxDocRefLineNum"));
			serviceBean.setConfirmedYn((String) existingOrder.get("confirmedYn"));
			serviceBean.setBaseRate((String) existingOrder.get("baseRate"));*/
			JsonObject existingOrder = (JsonObject) jsonParser.parse(request.getParameter("existingOrderObject"));
			serviceBean.setEpisodeType(checkForNull(existingOrder.get("episodeType").getAsString()));
			serviceBean.setEpisodeId(checkForNull(existingOrder.get("episodeId").getAsString()));
			serviceBean.setVisitId(checkForNull(existingOrder.get("visitId").getAsString()));
			serviceBean.setEncounterId(checkForNull(existingOrder.get("encounterId").getAsString()));
			serviceBean.setAcctSeqNo(checkForNull(existingOrder.get("acctSeqNo").getAsString()));
			serviceBean.setPatientId(checkForNull(existingOrder.get("patientId").getAsString()));
			serviceBean.setOrderId(checkForNull(existingOrder.get("orderId").getAsString()));
			serviceBean.setOrderLineNum(checkForNull(existingOrder.get("orderLineNum").getAsString()));
			serviceBean.setSubModuleId(checkForNull(existingOrder.get("subModuleId").getAsString()));
			serviceBean.setSubRegnNum(checkForNull(existingOrder.get("subRegnNum").getAsString()));
			serviceBean.setSubRegnLineNum(checkForNull(existingOrder.get("subRegnLineNum").getAsString()));
			serviceBean.setServCode(checkForNull(existingOrder.get("servCode").getAsString()));
					
			serviceBean.setServDesc(decodeParamUTF(existingOrder.get("servDesc").getAsString()));
			serviceBean.setServOrPanel(checkForNull(existingOrder.get("servOrPanel").getAsString()));		
			serviceBean.setItemCode(checkForNull(existingOrder.get("itemCode").getAsString()));
			serviceBean.setItemDesc(checkForNull(existingOrder.get("itemDesc").getAsString()));
			serviceBean.setServQty(checkForNull(existingOrder.get("baseQty").getAsString()));
			serviceBean.setBaseChargeAmount(checkForNull(existingOrder.get("baseChargeAmount").getAsString()));
			serviceBean.setServDiscount(checkForNull(existingOrder.get("disc_amt").getAsString()));
			serviceBean.setNetCharge(checkForNull(existingOrder.get("netChargeAmount").getAsString()));
			serviceBean.setPhysicianId(checkForNull(existingOrder.get("physicianId").getAsString()));
			serviceBean.setServedpanelQty(checkForNull(existingOrder.get("servedpanelQty").getAsString()));
			serviceBean.setUomCode(checkForNull(existingOrder.get("uomCode").getAsString()));
			serviceBean.setPractStaffInd(checkForNull(existingOrder.get("practStaffInd").getAsString()));
					
			serviceBean.setInclExclInd(checkForNull(existingOrder.get("inclExclInd").getAsString()));
			serviceBean.setReason(checkForNull(existingOrder.get("reason").getAsString()));
					
			serviceBean.setFutureOrder(checkForNull(existingOrder.get("futureOrder").getAsString()));
			serviceBean.setFutureOrderChargeLater(checkForNull(existingOrder.get("futureOrderChargeLater").getAsString()));
			serviceBean.setRemarks(checkForNull(existingOrder.get("remarks").getAsString()));
					
			serviceBean.setPackInd(checkForNull(existingOrder.get("packInd").getAsString()));
			serviceBean.setDailyProcessInd(checkForNull(existingOrder.get("dailyProcessInd").getAsString()));
			serviceBean.setBedTypeCode(checkForNull(existingOrder.get("bedTypeCode").getAsString()));
			serviceBean.setTokenSerial(checkForNull(existingOrder.get("tokenSeriesCode").getAsString()));
			serviceBean.setTokenSerialNo(checkForNull(existingOrder.get("tokenSeriesNo").getAsString()));
			
			serviceBean.setDispLocn(checkForNull(existingOrder.get("dispLocn").getAsString()));		
			serviceBean.setTrxDocRef(checkForNull(existingOrder.get("trxDocRef").getAsString()));
			serviceBean.setTrxDocRefSeqNum(checkForNull(existingOrder.get("trxDocRefSeqNum").getAsString()));
			serviceBean.setTrxDocRefLineNum(checkForNull(existingOrder.get("trxDocRefLineNum").getAsString()));
			serviceBean.setConfirmedYn(checkForNull(existingOrder.get("confirmedYn").getAsString()));
			serviceBean.setBaseRate(checkForNull(existingOrder.get("baseRate").getAsString()));
			serviceBean.setAcctSeqNo(checkForNull(existingOrder.get("acctSeqNo").getAsString()));
			serviceBean.setCustGroup(checkForNull(existingOrder.get("payerGroup").getAsString()));
			serviceBean.setCust(checkForNull(existingOrder.get("payer").getAsString()));
			serviceBean.setPolicyCode(checkForNull(existingOrder.get("policy").getAsString()));
			serviceBean.setPolicyNum(checkForNull(existingOrder.get("policyNum").getAsString()));
			serviceBean.setRateIndicator(checkForNull(existingOrder.get("rateIndicator").getAsString()));
			serviceBean.setAdhocDiscount(checkForNull(existingOrder.get("adhocDiscount").getAsString()));
			serviceBean.setChargeDateTime(checkForNull(existingOrder.get("chargeDateTime").getAsString()));
		}
		
		else if(func_mode != null && "cancelAll".equals(func_mode)){
			serviceList = new ArrayList<BLChargePatientExistingOrderBean> ();
			BLChargePatientExistingOrderBean loopBean = null;
			serviceBean.setEpisodeType(checkForNull(request.getParameter("episodeType")));
			serviceBean.setEpisodeId(checkForNull(request.getParameter("episodeId")));
			serviceBean.setVisitId(checkForNull(request.getParameter("visitId")));
			serviceBean.setEncounterId(checkForNull(request.getParameter("encounterId")));
			serviceBean.setPatientId(checkForNull(request.getParameter("patientId")));
			serviceBean.setAcctSeqNo(checkForNull(request.getParameter("acctSeqNo")));
			serviceBean.setCustGroup(checkForNull(request.getParameter("payerGroup")));
			serviceBean.setCust(checkForNull(request.getParameter("payer")));
			serviceBean.setPolicyCode(checkForNull(request.getParameter("policy")));
			serviceBean.setPolicyNum(checkForNull(request.getParameter("policyNum")));
			int lastIndex = Integer.parseInt(request.getParameter("lastIndex"));
			for(int i = 0; i<= lastIndex; i++){
				if(request.getParameter("servCode"+i) != null){
				loopBean = new BLChargePatientExistingOrderBean();
				loopBean.setTrxDocRef(checkForNull(request.getParameter("trxDocRef"+i)));
				loopBean.setTrxDocRefLineNum(checkForNull(request.getParameter("trxDocRefLineNum"+i)));
				loopBean.setTrxDocRefSeqNum(checkForNull(request.getParameter("trxDocRefSeqNum"+i)));
				loopBean.setPrimKeyLineNum(checkForNull(request.getParameter("primKeyLineNo"+i)));
				loopBean.setPrimKeyMain(checkForNull(request.getParameter("primKeyMain"+i)));
				loopBean.setPrimKeyModId(checkForNull(request.getParameter("primKeyModId"+i)));
				loopBean.setConfirmedYn(checkForNull(request.getParameter("confirmedYn"+i)));
				loopBean.setServedpanelQty(checkForNull(request.getParameter("servedPanelQty"+i)));
				loopBean.setServQty(checkForNull(request.getParameter("servQty"+i)));
				loopBean.setPhysicianId(checkForNull(request.getParameter("physicianId"+i)));
				loopBean.setUomCode(checkForNull(request.getParameter("uomCode"+i)));
				loopBean.setPractStaffInd(checkForNull(request.getParameter("practStaffInd"+i)));
				loopBean.setInclExclInd(checkForNull(request.getParameter("inclExclInd"+i)));
				loopBean.setReason(checkForNull(request.getParameter("reason"+i)));
				loopBean.setRemarks(checkForNull(request.getParameter("remarks"+i)));
				loopBean.setDailyProcessInd(checkForNull(request.getParameter("dailyProcessInd"+i)));
				loopBean.setBedTypeCode(checkForNull(request.getParameter("bedType"+i)));
				loopBean.setTokenSerial(checkForNull(request.getParameter("tokenSeriesCode"+i)));
				loopBean.setTokenSerialNo(checkForNull(request.getParameter("tokenSeriesNo"+i)));
				loopBean.setDispLocn(checkForNull(request.getParameter("dispLocn"+i)));
				loopBean.setSubRegnNum(checkForNull(request.getParameter("secKeyMain"+i)));
				loopBean.setSubRegnLineNum(checkForNull(request.getParameter("secKeyLineNo"+i)));
				loopBean.setServOrPanel(checkForNull(request.getParameter("servOrPanel"+i)));
				loopBean.setBaseRate(checkForNull(request.getParameter("baseRate"+i)));
				loopBean.setRateIndicator(checkForNull(request.getParameter("rateIndicator"+i)));
				loopBean.setNetCharge(checkForNull(request.getParameter("netChargeAmount"+i)));
				loopBean.setServCode(checkForNull(request.getParameter("servCode"+i)));
				loopBean.setPackInd(checkForNull(request.getParameter("trxDocRefLineNum"+i)));
				loopBean.setItemCode(checkForNull(request.getParameter("itemCode"+i)));
				serviceList.add(loopBean);
				}
			}
			serviceBean.setServicesList(serviceList);
		}
		else if(func_mode != null && "confirmAll".equals(func_mode)){
			serviceList = new ArrayList<BLChargePatientExistingOrderBean> ();
			BLChargePatientExistingOrderBean loopBean = null;
			int lastIndex = Integer.parseInt(request.getParameter("lastIndex"));
			for(int i = 0; i<= lastIndex; i++){
				if(request.getParameter("servCode"+i) != null){
					loopBean = new BLChargePatientExistingOrderBean();
					loopBean.setTrxDocRef(checkForNull(request.getParameter("trxDocRef"+i)));
					loopBean.setTrxDocRefLineNum(checkForNull(request.getParameter("trxDocRefLineNum"+i)));
					loopBean.setTrxDocRefSeqNum(checkForNull(request.getParameter("trxDocRefSeqNum"+i)));
					loopBean.setPrimKeyLineNum(checkForNull(request.getParameter("primKeyLineNo"+i)));
					loopBean.setPrimKeyMain(checkForNull(request.getParameter("primKeyMain"+i)));
					loopBean.setPrimKeyModId(checkForNull(request.getParameter("primKeyModId"+i)));
					loopBean.setConfirmedYn(checkForNull(request.getParameter("confirmedYn"+i)));
					loopBean.setServCode(checkForNull(request.getParameter("servCode"+i)));
					loopBean.setServOrPanel(checkForNull(request.getParameter("servOrPanel"+i)));
					loopBean.setItemCode(checkForNull(request.getParameter("itemCode"+i)));
					serviceList.add(loopBean);
				}
			}
			serviceBean.setServicesList(serviceList);
		}
		else if(func_mode != null && "processAll".equals(func_mode)){
			serviceList = new ArrayList<BLChargePatientExistingOrderBean> ();
			BLChargePatientExistingOrderBean loopBean = null;
			serviceBean.setEpisodeType(checkForNull(request.getParameter("episodeType")));
			serviceBean.setEpisodeId(checkForNull(request.getParameter("episodeId")));
			serviceBean.setVisitId(checkForNull(request.getParameter("visitId")));
			serviceBean.setEncounterId(checkForNull(request.getParameter("encounterId")));
			serviceBean.setPatientId(checkForNull(request.getParameter("patientId")));
			int lastIndex = Integer.parseInt(request.getParameter("lastIndex"));
			for(int i = 0; i<= lastIndex; i++){
				if(request.getParameter("primKeyMain"+i) != null){
					loopBean = new BLChargePatientExistingOrderBean();
					loopBean.setSubModuleId(checkForNull(request.getParameter("primKeyModId"+i)));
					loopBean.setOrderId(checkForNull(request.getParameter("primKeyMain"+i)));
					loopBean.setSubRegnNum(checkForNull(request.getParameter("secKeyMain"+i)));
					loopBean.setSubRegnLineNum(checkForNull(request.getParameter("secKeyLineNo"+i)));
					serviceList.add(loopBean);
				}
			}
			serviceBean.setServicesList(serviceList);
		}
		
	}catch (Exception e) {
	
		e.printStackTrace() ;
		System.err.println("Exception from BL Function Privilege :" + e);
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con);
	}

	putObjectInBean(beanId,serviceBean,request);


            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
