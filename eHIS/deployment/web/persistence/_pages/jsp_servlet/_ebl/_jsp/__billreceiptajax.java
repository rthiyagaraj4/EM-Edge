package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.billreceipt.request.BillGenerationRequest;
import eBL.placeorder.request.PlaceNewOrderRequest;
import java.net.URLDecoder;
import eBL.billreceipt.bc.BillReceiptBC;
import eBL.billreceipt.request.BillReceiptRequest;
import eBL.billreceipt.model.BillReceiptPackageInfo;
import java.text.SimpleDateFormat;
import eBL.billreceipt.model.BillReceiptExclusionDiscount;
import eBL.billreceipt.model.BillReceiptExistOrderExclusion;
import java.util.ResourceBundle;
import java.util.Locale;
import com.google.gson.JsonObject;
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

public final class __billreceiptajax extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptAjax.jsp", 1729766943982L ,"10.3.6.0","Asia/Calcutta")) return true;
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


private String decodeParam(String input){
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

private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String calledFrom = "";
 	Connection con = null;
 	CallableStatement cstmt = null;
 	PreparedStatement pstmt = null;
 	ResultSet rst = null;
	String beanId = "BillReceiptExistOrderExclusion" ;
	String beanName = "eBL.billreceipt.model.BillReceiptExistOrderExclusion";
	BillReceiptExistOrderExclusion exclusionBean = null;
	String facilityId = (String) session.getValue("facility_id");
	String loginUser = (String) session.getValue("login_user");
	String discUserId = request.getParameter("discUserId");
	Properties p = null ;
	String client_ip_address = "";
	try 
	{
		con = ConnectionManager.getConnection();
		calledFrom = request.getParameter("calledFrom");
		String locale = (String)session.getAttribute("LOCALE");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.err.println("calledFrom "+calledFrom);
		if("validateDiscount".equals(calledFrom)){
			exclusionBean = (BillReceiptExistOrderExclusion) getObjectFromBean(beanId, beanName, session);
			
			if(exclusionBean.getInterDiscount() == null){
				exclusionBean.setInterDiscount(new HashMap<String,BillReceiptExclusionDiscount>());
			}
			HashMap<String,BillReceiptExclusionDiscount> discountMap = exclusionBean.getInterDiscount();
			BillReceiptExclusionDiscount discBean = null;
			String patientId = request.getParameter("patientId");
			String episodeType = request.getParameter("episodeType");
			String episodeId = request.getParameter("episodeId");
			String visitId = request.getParameter("visitId");
			String trxDocRef = request.getParameter("trxDocRef");
			String trxDocRefLineNum = request.getParameter("trxDocRefLineNum");
			String trxDocRefSeqNum = request.getParameter("trxDocRefSeqNum");
			String blngServCode = request.getParameter("blngServCode");
			String serviceDate = request.getParameter("serviceDate");
			String serviceItemCode = request.getParameter("serviceItemCode");
			String moduleId = request.getParameter("moduleId");
			String payer = request.getParameter("payer");
			String discountCode = request.getParameter("discountCode");
			String discountDesc = decodeParam(request.getParameter("discountDesc"));
						
			String gross = request.getParameter("gross");
			String discountPer = request.getParameter("discountPer");
			String discountAmt = request.getParameter("discountAmt");
			String userId = (String) session.getValue("login_user");
	//		String usePrevious = request.getParameter("usePrevious");//checklist
			String makeDefault = request.getParameter("makeDefault");
			
			
			Locale loc = null;
			ResourceBundle rb = null;
			loc = new Locale(locale);
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			
			cstmt = con.prepareCall("{ call bl_get_bill_gen_dtls.proc_validate_adhoc_disc(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, facilityId);
			cstmt.setString(2, patientId);
			cstmt.setString(3, episodeType);
			cstmt.setString(4, episodeId);
			cstmt.setString(5, visitId);
			cstmt.setString(6, trxDocRef);
			cstmt.setString(7, trxDocRefLineNum);
			cstmt.setString(8, trxDocRefSeqNum);
			cstmt.setString(9, blngServCode);
			cstmt.setString(10, discUserId);//User who authorizes
			cstmt.setString(11, userId);//Logged in User
			if("".equals(serviceDate)){
				cstmt.setString(12, null);
			}
			else{
				cstmt.setTimestamp(12, new Timestamp(sdf.parse(serviceDate).getTime()));
			}
			cstmt.setString(13, serviceItemCode);
			cstmt.setString(14, moduleId);
			cstmt.setString(15, payer);
			cstmt.setString(16, discountCode);
			cstmt.setString(17, gross);
			cstmt.setString(18, discountPer);
			cstmt.setString(19, discountAmt);
			cstmt.setString(20, client_ip_address);
			cstmt.registerOutParameter(21, Types.VARCHAR);
			cstmt.registerOutParameter(22, Types.VARCHAR);
			cstmt.registerOutParameter(23, Types.VARCHAR);
			cstmt.registerOutParameter(24, Types.VARCHAR);
			cstmt.execute();
			String error = "";
			JsonObject obj = new JsonObject();
			obj.addProperty("validUser", cstmt.getString(21));
			if(cstmt.getString(24) != null){
				error += cstmt.getString(24) + "\n";
			}
			String str_sysmesage_id = cstmt.getString(23);
			
			if(str_sysmesage_id != null){
				String msgAdd = "";
				if(str_sysmesage_id.contains("|")){
					String msgArr[] = str_sysmesage_id.split("\\|");
					for(int l=0;l<msgArr.length;l++){
						msgAdd = "msgHdr"+"-"+l;
						
						try{
							msgArr[l] = rb.getString(msgArr[l]);
						}
						catch(Exception rbException){
							System.err.println("Exceprion in RB ->"+rbException);
						}
						error += msgArr[l] + "\n";
					}
				}else{
					msgAdd = "msgHdr";
					
					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						System.err.println("Exceprion in RB ->"+rbException);
					}
					error += str_sysmesage_id + "\n";
				}		
				
			}
			
			obj.addProperty("error", error);
			
			if("Y".equals(cstmt.getString(21)) && "".equals(error)){
				String key = blngServCode+":::"+trxDocRef+":::"+trxDocRefLineNum+":::"+trxDocRefSeqNum;
				if(discountMap.containsKey(key)){
					System.err.println("Key Exists");
					discountMap.remove(key);
				}
				discBean = new BillReceiptExclusionDiscount();
				discBean.setTrxDocRef(trxDocRef);
				discBean.setTrxDocRefLineNum(trxDocRefLineNum);
				discBean.setTrxDocRefSeqNum(trxDocRefSeqNum);
				discBean.setBlngServCode(blngServCode);
				discBean.setDiscOrExcl("D");
				discBean.setCustCode(payer);
				discBean.setDiscAmt(discountAmt);
				discBean.setDiscPerc(discountPer);
				discBean.setDiscReason(discountCode);
				discBean.setDiscUserId(discUserId);
				discBean.setGrossAmt(gross);
				discBean.setItemCode(serviceItemCode);
				discBean.setModuleId(moduleId);
				float netAmt = 0;
				try{
					netAmt = Float.parseFloat(gross) - Float.parseFloat(discountAmt);
					discBean.setNetAmt(String.valueOf(netAmt));
					System.err.println(discBean.getGrossAmt());
				}
				catch(Exception e){
					discBean.setNetAmt(gross);
					System.err.println("Exception in getting gross ->"+e);
				}
				
				discBean.setServiceDate(serviceDate);
				obj.addProperty("netAmt", discBean.getNetAmt());
				discountMap.put(key, discBean);
				if("Y".equals(makeDefault)){
					exclusionBean.setDefDiscCode(discountCode);
					exclusionBean.setDefDiscDesc(discountDesc);
				}
				else{
					exclusionBean.setDefDiscCode("");
					exclusionBean.setDefDiscDesc("");
				}
				exclusionBean.setPrevDiscCode(discountCode);
				exclusionBean.setPrevDiscDesc(discountDesc);
				exclusionBean.setInterDiscount(discountMap);
			}
			putObjectInBean(beanId,exclusionBean,request);
			out.println(obj);
		}
		else if("PackageClosure".equals(calledFrom)){
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			int totalRows = Integer.parseInt(request.getParameter("totalCount"));
			String pkgSeqNo=replaceNull(request.getParameter("pkgSeqNo"));
		  //	StringTokenizer pkgSeqNum = new StringTokenizer(pkgSeqNo,","); //checklist
		  //	String packageSeqNum ="";//checklist
		  
			
			BillReceiptRequest billRequest = new BillReceiptRequest();
			List<BillReceiptPackageInfo> pkgList = new ArrayList<BillReceiptPackageInfo>();
			BillReceiptPackageInfo pkgBean = null;
			for(int i=1;i<=totalRows;i++){
				pkgBean = new BillReceiptPackageInfo();
				pkgBean.setPackageCode(request.getParameter("packageCode"+i));
				pkgBean.setPkgSeqNo(request.getParameter("packageSeqNo"+i));
			/*	while (pkgSeqNum.hasMoreTokens()){
	                 packageSeqNum =pkgSeqNum.nextToken();
				pkgBean.setPkgSeqNo(packageSeqNum);
				}*/
			
				
				pkgList.add(pkgBean);
				
			}
			billRequest.setPkgList(pkgList);
			billRequest.setPatientId(request.getParameter("patientId"));
			System.out.println("obj========================"+request.getParameter("patientId"));
			billRequest.setEpisodeType(request.getParameter("episodeType"));
			System.out.println("obj========================"+request.getParameter("episodeType"));
			
			billRequest.setEpisodeId(request.getParameter("episodeId"));
			System.out.println("obj========================"+request.getParameter("episodeId"));
			billRequest.setVisitId(request.getParameter("visitId"));
			System.out.println("obj========================"+request.getParameter("visitId"));
			billRequest.setFacilityId(facilityId);
			System.out.println("obj========================"+facilityId);
			billRequest.setClientIpAddress(client_ip_address);
			billRequest.setLoginUser(loginUser);
			BillReceiptBC billBC = new BillReceiptBC();
			JsonObject obj = billBC.closePackage(billRequest);
			System.out.println("obj========================"+obj);
			out.println(obj);
		}
		else if("bedComputeYorN".equals(calledFrom)){
			BillReceiptRequest billRequest = new BillReceiptRequest();
			billRequest.setFacilityId(facilityId);
			billRequest.setPatientId(request.getParameter("patientId"));
			billRequest.setEpisodeType(request.getParameter("episodeType"));
			billRequest.setEpisodeId(request.getParameter("episodeId"));
			billRequest.setVisitId(request.getParameter("visitId"));
			BillReceiptBC billBC = new BillReceiptBC();
			String computeYN = billBC.bedComputationYN(billRequest);
			out.println(computeYN);
		}
		else if("bedComputeAlert".equals(calledFrom)){
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			BillReceiptRequest billRequest = new BillReceiptRequest();
			billRequest.setFacilityId(facilityId);
			billRequest.setPatientId(request.getParameter("patientId"));
			billRequest.setEpisodeType(request.getParameter("episodeType"));
			billRequest.setEpisodeId(request.getParameter("episodeId"));
			billRequest.setVisitId(request.getParameter("visitId"));
			billRequest.setEncounterId(request.getParameter("encounterId"));
			billRequest.setLoginUser(loginUser);
			billRequest.setClientIpAddress(client_ip_address);
			billRequest.setLocale(locale);
			BillReceiptBC billBC = new BillReceiptBC();
			JsonObject alertObj = billBC.bedComputationAlert(billRequest);
			out.println(alertObj);
		}
		else if("bedComputeMain".equals(calledFrom)){
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			BillReceiptRequest billRequest = new BillReceiptRequest();
			billRequest.setFacilityId(facilityId);
			billRequest.setPatientId(request.getParameter("patientId"));
			billRequest.setEpisodeType(request.getParameter("episodeType"));
			billRequest.setEpisodeId(request.getParameter("episodeId"));
			billRequest.setVisitId(request.getParameter("visitId"));
			billRequest.setEncounterId(request.getParameter("encounterId"));
			billRequest.setLocale(locale);
			billRequest.setFunctionId("");
			billRequest.setUptoCalDate(request.getParameter("computeUptoDt"));
			billRequest.setDischDateTime("");
			billRequest.setAdmDateTime("");
			billRequest.setLoginUser(loginUser);
			billRequest.setClientIpAddress(client_ip_address);
			billRequest.setIpChkOutBasisInd(request.getParameter("ipChkOutBasisInd"));
			billRequest.setSuppressDischarge(request.getParameter("suppressDischarge"));
			BillReceiptBC billBC = new BillReceiptBC();
			String error = billBC.bedComputationMain(billRequest);
			out.println(error);
			
		}
		else if("recalcDepositSlmt".equals(calledFrom)){
			BillReceiptBC billBC = new BillReceiptBC();
			BillGenerationRequest billRequest = new BillGenerationRequest();
			billRequest.setPatientId(request.getParameter("patientId"));
			billRequest.setEpisodeType(request.getParameter("episodeType"));
			billRequest.setEpisodeId(request.getParameter("episodeId"));
			billRequest.setVisitId(request.getParameter("visitId"));
			billRequest.setDepAdjYn(request.getParameter("depChkYn"));
			billRequest.setPrePayAdjYn(request.getParameter("prePayChkYn"));
			billRequest.setApproxPatAmt(request.getParameter("approxPatAmt"));
			billRequest.setSlmtAmt(request.getParameter("slmtAmt"));
			billRequest.setDeposits(request.getParameter("deposits"));
			billRequest.setPatAmt(request.getParameter("patAmt"));
			billRequest.setDepAjustedYn(request.getParameter("depAdjustedYn"));
			billRequest.setPreAjustedYn(request.getParameter("preAdjustedYn"));
			/*Added below 4 Params */
			billRequest.setRefDepAdj(request.getParameter("refDepAdj"));
			billRequest.setRefDepBal(request.getParameter("refDepBal"));
			billRequest.setRefprePayAdj(request.getParameter("refprePayAdj"));
			billRequest.setRefprePaybal(request.getParameter("refprePaybal"));
			billRequest.setPrevDepAdjAmt(request.getParameter("prevDepAdjAmt"));
			billRequest.setPrevPreAdjAmt(request.getParameter("prevPreAdjAmt"));
			/*Added below 4 Params */
			JsonObject obj = billBC.recalcDepositSlmt(billRequest);
			out.println(obj);
		}
		else if("clearDepositAdjustments".equals(calledFrom)){
			session.setAttribute("deposit_parameter_array_session",null);
			session.setAttribute("deposit_adjusted_payable_amount",null); 
			out.println("SUCCESS");
		}
		else if("sessionAttribute".equals(calledFrom)){
			String pkgClosedYN ="Y";
			
			String pkgSeqNum = request.getParameter("pkgSeqNum");
			
			session.setAttribute("pkgClosedYN",pkgClosedYN);
			session.setAttribute("pkgSeqNum",pkgSeqNum);
			
			out.println(pkgClosedYN);
		}
		else if("ASYNCPRINT".equals(calledFrom)){
	    	int totalRecords = 0;
	    	totalRecords = Integer.parseInt(request.getParameter("totalReport"));
	    	HashMap<String,String> asyncPrinterAttrib=new HashMap<String,String> ();
	    	String printVal = "";
	    	String reportId = "";
	    	for(int i=1;i<=totalRecords;i++){
	    		printVal = decodeParam(request.getParameter("billPrintVal"+i));
	    		reportId = decodeParam(request.getParameter("report"+i));
	    		asyncPrinterAttrib.put(printVal+"/"+i,reportId);
	    	}
	    	session.setAttribute("ASYNC_PRINTER_ATTRIB", asyncPrinterAttrib);
	    	System.err.println("Session set");
	    }
		else if("getBookRef".equals(calledFrom)){
			String docType = request.getParameter("docType");
			String docNum = request.getParameter("docNum");
			String bookRefNum = "";
			pstmt = con.prepareStatement("Select nvl(BOOKING_REF_NUM,'') BOOKING_REF_NUM from bl_receipt_refund_hdr where DOC_TYPE_CODE = ? and DOC_NUMBER = ?");
			pstmt.setString(1, docType);
			pstmt.setString(2, docNum);
			rst = pstmt.executeQuery();
			if(rst != null ){
				if(rst.next()){
					bookRefNum = rst.getString("BOOKING_REF_NUM");
					System.err.println(bookRefNum);
				}
				
			}
			out.println(bookRefNum);
		}
		else if("validateCashCounter".equals(calledFrom)){
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			BillReceiptBC billBC = new BillReceiptBC();
			BillReceiptRequest billRequest = new BillReceiptRequest();
			billRequest.setPatientId(replaceNull(request.getParameter("patientId")));
			billRequest.setFacilityId(replaceNull(request.getParameter("facilityId")));
			billRequest.setEpisodeType(replaceNull(request.getParameter("episodeType")));
			billRequest.setEpisodeId(replaceNull(request.getParameter("episodeId")));
			billRequest.setVisitId(replaceNull(request.getParameter("visitId")));
			billRequest.setClientIpAddress(client_ip_address);
			billRequest.setLoginUser(loginUser);
			JsonObject obj = billBC.validateCashCounter(billRequest);
			out.println(obj);
		}
		else if("specialClinicValidate".equals(calledFrom)){
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			BillReceiptBC billBC = new BillReceiptBC();
			BillReceiptRequest billRequest = new BillReceiptRequest();
			billRequest.setFacilityId(facilityId);
			billRequest.setEpisodeType(replaceNull(request.getParameter("episode_type")));
			billRequest.setEpisodeId(replaceNull(request.getParameter("episode_id")));
			billRequest.setVisitId(replaceNull(request.getParameter("visit_id")));
			billRequest.setClientIpAddress(client_ip_address);
			billRequest.setLoginUser(loginUser);
			JsonObject obj = billBC.specialClinicValidate(billRequest);
			out.println(obj);
		}
		else if("checkForServiceDiscount".equals(calledFrom)){			
			BillReceiptBC billBC = new BillReceiptBC();
			BillReceiptRequest billRequest = new BillReceiptRequest();
			billRequest.setServCode(replaceNull(request.getParameter("blngServCode")));
			billRequest.setTrxDocRef(replaceNull(request.getParameter("trxDocRef")));
			billRequest.setTrxDocRefLine(replaceNull(request.getParameter("trxDocRefLineNum")));
			billRequest.setTrxDocRefSeq(replaceNull(request.getParameter("trxDocRefSeqNum")));
			billRequest.setFacilityId(facilityId);
			
			String allowedYn = billBC.checkForServiceDiscount(billRequest);
			System.err.println("allowedYn"+allowedYn);
			out.println(allowedYn);
		}
		else if ("UnprocessedCheck".equals(calledFrom)){	
			BillReceiptBC billBC = new BillReceiptBC();
			BillReceiptRequest billRequest = new BillReceiptRequest();
			billRequest.setPatientId(replaceNull(request.getParameter("patientId")));
			billRequest.setFacilityId(replaceNull(request.getParameter("facilityId")));
			billRequest.setEpisodeType(replaceNull(request.getParameter("episodeType")));
			billRequest.setEpisodeId(replaceNull(request.getParameter("episodeId")));
			billRequest.setVisitId(replaceNull(request.getParameter("visitId")));
			JsonObject obj = billBC.UnprocessedCheck(billRequest);
			System.err.println("obj11111"+obj);
			out.println(obj);
			
		}else if ("BillSlmtRoundingAmt".equals(calledFrom)){	
		
			String sql="select bl_get_bill_gen_dtls.get_bill_slmt_rounding_amt(?,?,?,?) from dual";
			BillReceiptRequest billRequest = new BillReceiptRequest();
			billRequest.setFacilityId(facilityId);
			
			int patDocNum=Integer.parseInt(request.getParameter("patDocNum"));
			String billDocType=replaceNull(request.getParameter("billDocType"));
			float billSlmtAmt=Float.parseFloat(request.getParameter("billSlmtAmt"));
			float getNumber=0;
		
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,facilityId);
			pstmt.setString(2,billDocType);
			pstmt.setInt(3,patDocNum);
			pstmt.setFloat(4,billSlmtAmt);
			rst=pstmt.executeQuery();
		
			if(rst!=null)
			{
				while(rst.next())
				{
					
					getNumber=rst.getFloat(1);
				
				}
				
			}
		
		 out.println(getNumber);
	//	 System.out.println("getNumber111"+getNumber);
			
		}
		else if ("reopenPackage".equals(calledFrom)){
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			
			BillReceiptBC billBC = new BillReceiptBC();
			BillReceiptRequest billRequest = new BillReceiptRequest();
			String pkgSeqNo=replaceNull(request.getParameter("pkgSeqNo"));
		  	StringTokenizer pkgSeqNum = new StringTokenizer(pkgSeqNo,",");
		  	while (pkgSeqNum.hasMoreTokens()){
                String packageSeqNum =pkgSeqNum.nextToken();
                billRequest.setPkgSeqNo(packageSeqNum);
    			billRequest.setFacilityId(replaceNull(request.getParameter("facilityId")));
    			billRequest.setClientIpAddress(client_ip_address);
    			billRequest.setLoginUser(loginUser);
    			System.err.println("billRequest=="+billRequest);
    			JsonObject obj = billBC.reopenPackage(billRequest);
    			
                System.err.println(packageSeqNum);
                System.err.println("obj11111"+obj);
                out.println(obj);
            }
		}else if ("user_pass".equals(calledFrom)){
			String	p_user_pasword="",valid_user_YN="",valid_user_pass_YN="";
			String rec_found="";
	//		String out_msg=""; //checklist
 			System.out.println("Inside user_pass");
 			String user_name  = replaceNull(request.getParameter("user_name"));	
    		String user_pasword  = replaceNull(request.getParameter("pass_wrd"));	
			
    		if(!"".equals(user_name))
    		{
    			String valid_user_qry="Select distinct 'Y' From BL_DISC_SERVICE_BY_USER Where User_Id= ? And Facility_Id = ? ";

				pstmt=con.prepareStatement(valid_user_qry);
				pstmt.setString(1,user_name);
				pstmt.setString(2,facilityId);
				rst = pstmt.executeQuery();
				if (rst!=null)
				{
					rec_found = "N";

					if (rst.next())
					{
						valid_user_YN = rst.getString(1);
						rec_found = "Y";
					}	
				}
				if(rec_found.equals("N")) valid_user_YN="N";

				if (rst != null)   rst.close();
				if (pstmt != null)   pstmt.close();
  				System.out.println("valid_user_YN:"+valid_user_YN);
    		}
    				
 			if(valid_user_YN.equals("Y"))
 			{
 				if(!user_name.equals("") && !user_pasword.equals(""))
 				{
 					String query_pswd="select upper(app_password.decrypt(APPL_USER_PASSWORD)) as password from sm_appl_user where appl_user_id= ? ";
 					pstmt=con.prepareStatement(query_pswd);
					pstmt.setString(1,user_name);
 					rst = pstmt.executeQuery();
 					if (rst!=null)
 					{
 						rec_found = "N";
 						if (rst.next())
 						{
 							p_user_pasword = rst.getString(1);
 							rec_found = "Y";
 						}
 					}
 					if(rec_found.equals("N")) p_user_pasword="N";
 					if (rst != null)   rst.close();
 					if (pstmt != null)   pstmt.close();

 					if(!user_pasword.equalsIgnoreCase(p_user_pasword))
 					{
 						valid_user_pass_YN = "N";
 					}
 					else
 					{
 						valid_user_pass_YN = "Y";
 					}
				System.out.println("valid_user_pass_YN:"+valid_user_pass_YN);
 				}
 			}
    		
 			JsonObject obj = new JsonObject();
 			obj.addProperty("valid_user_pass_YN", valid_user_pass_YN);
 			obj.addProperty("valid_user_YN", valid_user_YN);
 			out.println(obj);
    				
    	}
		else if("changePatDtls".equals(calledFrom)){
		
		String retValue="";
		
			Boolean SiteSpec=false;
			String SiteSpecific ="";
			try
			{
				//con = ConnectionManager.getConnection(); checkstyle
				SiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "BL","DISABLE_FIN_DETAILS_IN_MP");				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
			if(SiteSpec){
				SiteSpecific="Y";
			}
			else{
				SiteSpecific="N";
			}
		if(  (SiteSpecific.equals("Y"))){
		
		retValue="Y";
		
		}
		else{
		
		retValue="N";
		
		}
		out.println(retValue);
		
		}
		else if("QueuePKID".equals(calledFrom)){ //V221023/TH-KW-CRF-0020.7	/Mohanapriya
			System.err.println("QueuePKID called ajax");
			String sysDate="";
			try
			{
				String query_date="select to_char(sysdate,'dd/mm/yyyy HH24:MI:SS') from dual";
				pstmt=con.prepareStatement(query_date);
 				rst = pstmt.executeQuery();
				if( rst != null ) 
				{
					if( rst.next() ){
						sysDate = rst.getString(1); 
					}
				}
			if (rst != null)   rst.close();
			if (pstmt != null)   pstmt.close();
			}		
			catch(Exception e)
			{
				System.out.println("Exception @ sysdate  :"+e);
				e.printStackTrace();
			}
			p = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			String p_operating_facility_id  = replaceNull(request.getParameter("p_operating_facility_id"));
			String p_Patient_id             = replaceNull(request.getParameter("p_Patient_id"));
			String p_episode_type           = replaceNull(request.getParameter("p_episode_type"));
			String p_episode_id             = replaceNull(request.getParameter("p_episode_id"));
			String p_visit_id               = replaceNull(request.getParameter("p_visit_id"));
			String encounter_id               = replaceNull(request.getParameter("encounter_id"));
			String p_location_code          = replaceNull(request.getParameter("service_location"));
			String p_queue_id_prikey        = replaceNull(request.getParameter("pkid"));
			String p_function_id            = "BILGEN";
			String p_validate_qpkid         = replaceNull(request.getParameter("called"));
			if(p_validate_qpkid.equals("D")){
				p_queue_id_prikey="DUMMY";
			}
			System.err.println("p_Patient_id "+p_Patient_id);
			System.err.println("p_location_code "+p_location_code);
			System.err.println("sysdate called"+sysDate);
			
			cstmt = con.prepareCall("{ call IBAEHIS.insert_bl_qms_token_dtls_temp(?,?,?,?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,TO_DATE(?,'DD/MM/YYYY HH24:MI:SS'),?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, p_operating_facility_id);
			cstmt.setString(2, p_Patient_id);
			cstmt.setString(3, p_episode_type);
			cstmt.setString(4, p_episode_id);
			cstmt.setString(5, p_visit_id);
			cstmt.setString(6, p_location_code);
			cstmt.setString(7, p_queue_id_prikey);
			cstmt.setString(8, "");
			cstmt.setString(9, loginUser);
			cstmt.setString(10, sysDate);
			cstmt.setString(11, client_ip_address);
			cstmt.setString(12, p_operating_facility_id);
			cstmt.setString(13, loginUser);
			cstmt.setString(14, sysDate);
			cstmt.setString(15, client_ip_address);
			cstmt.setString(16, p_operating_facility_id); //
			cstmt.setString(17, p_function_id);
			cstmt.setString(18, p_validate_qpkid);
			cstmt.setString(19, encounter_id);
			cstmt.setString(20, loginUser);
			cstmt.registerOutParameter(21, Types.VARCHAR);
			cstmt.registerOutParameter(22, Types.VARCHAR);
			cstmt.registerOutParameter(23, Types.VARCHAR);
			System.err.println("before queueid procedure");
			cstmt.execute();
			System.err.println("after queueid procedure execution");
			String perrorlevel   = cstmt.getString(21);
			String psysmessageid = cstmt.getString(22);
			String perrortext    = cstmt.getString(23);
			String retval=psysmessageid;
			out.println(retval);
			System.err.println("after completion of queueid procedure "+perrortext);
		}else if ("callUnprocessedBill".equals(calledFrom)){	//V230127- TH-KW-CRF-0092
		
			String patientId=replaceNull(request.getParameter("patientId"));
			String episodeId=replaceNull(request.getParameter("episodeId"));
			String episode_type=replaceNull(request.getParameter("episode_type"));
			String visit_id=replaceNull(request.getParameter("visit_id"));
			cstmt = con.prepareCall("{call ibaehis.bl_validate_unbilled_opip_3T(?,?,?,?,?,?,?)}");//added 2 ?
			System.err.println("patientId "+patientId);
			System.err.println("episodeId "+episodeId);
			System.err.println("facilityId "+facilityId);
			System.err.println("episode_type "+episode_type);
			System.err.println("visit_id "+visit_id);
			cstmt.setString(1,patientId);
			cstmt.setString(2,facilityId);
			cstmt.setString(3,episodeId);
			cstmt.setString(4,episode_type);
			cstmt.setString(5,visit_id);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			System.err.println("before queueid procedure");
			cstmt.execute();
			
			String encontID   = cstmt.getString(6);
			String isValid = cstmt.getString(7);
			System.err.println("encontID "+encontID);
			System.err.println("isValid "+isValid);
			JsonObject obj = new JsonObject();
 			obj.addProperty("encontID", encontID);
 			obj.addProperty("isValid", isValid);
 			obj.addProperty("Success", "Y");
 			out.println(obj);
			con.commit();
			
		}else if ("generateUnprocBill".equals(calledFrom)){	//V230127 TH-KW-CRF-0092
		System.err.println("call bill generation procedure");
		p = (java.util.Properties) session.getValue( "jdbc" ) ;
			client_ip_address = p.getProperty("client_ip_address");
			String patientId=replaceNull(request.getParameter("patientId"));
			String episodeId=replaceNull(request.getParameter("episodeId"));
			String p_old_encounter_id=replaceNull(request.getParameter("oldEncid"));
			String billGenOpt=replaceNull(request.getParameter("billGenOpt"));
			if(billGenOpt=="B") billGenOpt="";
			String cntrUserShift=replaceNull(request.getParameter("cntrUserShift"));
			String cntrUserName=replaceNull(request.getParameter("cntrUserName"));
			String pkgSeqNo=replaceNull(request.getParameter("pkgSeqNo"));
			//New
			String episode_type=replaceNull(request.getParameter("episode_type"));
			String visit_id=replaceNull(request.getParameter("visit_id"));
			
			System.err.println("episode_type "+episode_type);
			System.err.println("visit_id "+visit_id);
			
			System.err.println("patientId "+patientId);
			System.err.println("episodeId "+episodeId);
			System.err.println("p_old_encounter_id "+p_old_encounter_id);
			System.err.println("billGenOpt "+billGenOpt);
			System.err.println("cntrUserShift "+cntrUserShift);
			System.err.println("cntrUserName "+cntrUserName);
			System.err.println("pkgSeqNo "+pkgSeqNo);
			System.err.println("client_ip_address "+client_ip_address);
			System.err.println("loginUser "+loginUser);
			cstmt = con.prepareCall("{call ibaehis.bl_generate_org_unbilled_3T(?,?,?,,?,?,?,?,?,?,?,?,?,?,?,?)}");//added 2 ?
			
			cstmt.setString(1,patientId);
			cstmt.setString(2,facilityId);
			cstmt.setString(3,episodeId);
			cstmt.setString(4,episode_type);
			cstmt.setString(5,visit_id);
			cstmt.setString(6,billGenOpt);//bill gen option
			cstmt.setString(7,client_ip_address);
			cstmt.setString(8,cntrUserName);//cashcountercode
			cstmt.setString(9,cntrUserShift);//p_shift_id
			cstmt.setString(10,loginUser);
			cstmt.setString(11,pkgSeqNo);//p_pkg_seq_csv
			cstmt.setString(12,p_old_encounter_id);
			
			cstmt.registerOutParameter(13, Types.VARCHAR);
			cstmt.registerOutParameter(14, Types.VARCHAR);
			cstmt.registerOutParameter(15, Types.VARCHAR);
			System.err.println("before bill generation procedure");
			cstmt.execute();
			
			String p_error_level   = cstmt.getString(13);
			String p_sys_message_id = cstmt.getString(14);
			String p_error_text = cstmt.getString(15);
			System.err.println("p_error_level "+p_error_level);
			System.err.println("p_sys_message_id "+p_sys_message_id);
			System.err.println("p_error_text "+p_error_text);
			
			if(null != p_error_level && !"".equals(p_error_level)) {
				System.err.println("msg::p_error_level:::"+p_error_level);
				out.println(p_error_level);
				con.rollback();
			} else if(null != p_error_text && !"".equals(p_error_text)) {
				System.out.println("errorText :: "+p_error_text);
				out.println(p_error_text);
				con.rollback();
			} 
			if(null != p_sys_message_id && !"".equals(p_sys_message_id)) {
			 System.out.println("p_sys_message_id :: "+p_sys_message_id);
				out.println(p_sys_message_id);
				con.rollback();
			} 
			else {
				con.commit();
				System.out.println("commit in bill generation ajax");
				out.println("");
			}		
			//out.println(p_sys_message_id);
			//con.commit();
		}
    	
	}catch (Exception e) {
	
		System.out.println("Exception from BillReceiptAjax :" + e);
		e.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con);
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
