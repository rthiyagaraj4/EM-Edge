package eBL.billreceipt.dao;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

import com.google.gson.JsonObject;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
import oracle.sql.STRUCT;
import oracle.sql.StructDescriptor;

import webbeans.eCommon.ConnectionManager;

import eBL.Common.BlRepository;
import eBL.billreceipt.model.BLBillGenInterfaceBean;
import eBL.billreceipt.model.BLBillGenInterfaceInBean;
import eBL.billreceipt.model.BillReceiptCustomerDetails;
import eBL.billreceipt.model.BillReceiptExclusionDiscount;
import eBL.billreceipt.model.BillReceiptExistOrderExclusion;
import eBL.billreceipt.model.BillReceiptInfoDetails;
import eBL.billreceipt.model.BillReceiptPackageInfo;
import eBL.billreceipt.model.BillReceiptServiceDetails;
import eBL.billreceipt.model.BillReceiptSummaryBean;
import eBL.billreceipt.model.BillReceiptUnbillOutst;
import eBL.billreceipt.request.BillGenerationRequest;
import eBL.billreceipt.request.BillReceiptRequest;
import eBL.billreceipt.response.BillReceiptResponse;
import eBL.placeorder.model.BLChargePatientServiceDetailsBean;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.response.PlaceNewOrderResponse;

public class BillReceiptServiceDAOImpl implements BillReceiptServiceDAO{
	
	public LinkedHashMap<String, String> getServiceLocation(BillReceiptRequest request) {
		LinkedHashMap<String, String> servLocn = new LinkedHashMap<String, String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("BR_SERVICE_LOCATION"));
			pstmt.setString(1,request.getFacilityId());
			pstmt.setString(2,request.getLocale());
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					servLocn.put(rst.getString("SERV_LOCN_CODE"), rst.getString("SHORT_DESC"));
				}
			}
		}
		catch(Exception e){
			System.err.println("Exception in getServiceLocation->"+e);
		}
		finally{
			pstmt = null;
			rst = null;
			if(con != null){
				ConnectionManager.returnConnection(con);
			}
		}
		return servLocn;
	}


	public HashMap<String, String> getBillOptions(BillReceiptRequest request) {
		HashMap<String, String> billOptions = new HashMap<String, String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("BR_BILL_OPTIONS"));
			pstmt.setString(1,request.getLocale());
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					billOptions.put(rst.getString("LIST_ELMT_VALUE"), rst.getString("LIST_LABEL"));
				}
			}
		}
		catch(Exception e){
			System.err.println("Exception in getBillOptions->"+e);
		}
		finally{
			pstmt = null;
			rst = null;
			if(con != null){
				ConnectionManager.returnConnection(con);
			}
		}
		return billOptions;
	}
	
	/**
	 * Method used to convert Date from String format to Date Format
	 * @param dateString
	 * @return
	 */
	private long getDateInLong(String dateString){ 
		
		if(dateString==null){
			return 0; 
		}
		else{
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Timestamp inputTimestamp = new Timestamp(sdf.parse(dateString).getTime());
				return inputTimestamp.getTime();
			} 
			catch (ParseException e) {
				System.err.println("Error in Input Date Format");
				e.printStackTrace();
			}
		}
		return 0;
	} 
	
	/**
	 * Method used to retrieve the Existing Orders for the Patient. 
	 * This Method will be called from BLChargePatientExisOrderServDetails.jsp
	 */
	@SuppressWarnings("rawtypes")
	public BillReceiptResponse getServiceDetailsData(PlaceNewOrderRequest bean,Connection conn){
		
		BillReceiptResponse response = new BillReceiptResponse();
		List<BillReceiptCustomerDetails> custList = new ArrayList<BillReceiptCustomerDetails>();
		List<BillReceiptServiceDetails> serviceList = new ArrayList<BillReceiptServiceDetails>();
		List<BillReceiptSummaryBean> summDetails = new ArrayList<BillReceiptSummaryBean>();
		BillReceiptSummaryBean summBean = new BillReceiptSummaryBean();
		
		BillReceiptCustomerDetails custBean = null;
		BillReceiptServiceDetails serviceBean = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;
		Locale loc = new Locale(bean.getLocale());
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		int deci = 0;
		try
		{
			try{
				pstmt = conn.prepareStatement( " select nvl(no_of_decimal,2) no_of_decimal from  sm_acc_entity_param");
				rst = pstmt.executeQuery();
				if(rst != null && rst.next()){
					deci = Integer.parseInt(rst.getString("no_of_decimal"));
				}
			}
			catch(Exception dEx){
				dEx.printStackTrace();
			}
			finally{
				pstmt = null;
				rst = null;
			}
			
			//System.out.println("In getPriceDetailsData:::: ");
			//con = ConnectionManager.getConnection();
			String sql		=	BlRepository.getBlKeyValue("FETCH_FOLIO_RECS");
			cstmt 			= 	conn.prepareCall(sql);
			
			cstmt.setString(1,bean.getFacilityId());
			cstmt.setString(2,bean.getLocale());
			cstmt.setString(3, bean.getPatientId());			
			cstmt.setString(4,bean.getEpisodeType());	
			cstmt.setString(5,bean.getEpisodeId());		
			cstmt.setString(6,bean.getVisitId());		
			cstmt.setString(7,"#"); 	
			cstmt.setString(8,null); 	
			cstmt.setDate(9,null);
			cstmt.setDate(10,null);
			cstmt.setString(11,null);		
			cstmt.setString(12,null);			
			cstmt.setString(13,null);
			cstmt.setString(14, bean.getBillgenType());
			cstmt.setString(15, bean.getBillGenOpt());
			cstmt.setString(16, bean.getServOrPanel());// This Contains Service Location Code
			cstmt.setString(17, null);	
			cstmt.setString(18, null);	
			cstmt.setString(19, bean.getIpBill());	
			cstmt.setString(20, null);	
			cstmt.setString(21, null);	
			cstmt.setString(22, null);	
			cstmt.setString(23, null);	
			cstmt.setString(24, bean.getGroupLineService());	
			cstmt.setString(25, bean.getServGroupCode());
			cstmt.setString(26, bean.getServClass());
			cstmt.setString(27, bean.getServCode());
			cstmt.setString(28, bean.getEntServGroup());
			if((bean.getFromDate() == null) || ("".equals(bean.getFromDate()))){
				cstmt.setString(29, null);
			}
			else{
				Date fromDt = new Date(sdf.parse(bean.getFromDate()).getTime());
				cstmt.setDate(29, fromDt);
			}
			
			if((bean.getToDate() == null) || ("".equals(bean.getToDate()))){
				cstmt.setString(30, null);
			}
			else{
				Date toDt = new Date(sdf.parse(bean.getToDate()).getTime());
				cstmt.setDate(30, toDt);
			}
			cstmt.setString(31, bean.getDepChkYn());
			cstmt.setString(32, bean.getPrePayChkYn());
			cstmt.setString(33, bean.getSplDepChkYn());
			cstmt.setString(34, bean.getLoginUser());
			cstmt.setString(35, bean.getClientIpAddress());		
			cstmt.setString(36, bean.getAcctSeqNo());
			cstmt.setInt(37, bean.getStartFrom());
			cstmt.setInt(38, bean.getEndWith());
			cstmt.registerOutParameter(39, Types.INTEGER);
			cstmt.registerOutParameter(40,OracleTypes.CURSOR);
			cstmt.registerOutParameter(41,OracleTypes.CURSOR);
			
			cstmt.registerOutParameter(42, Types.VARCHAR);
			cstmt.registerOutParameter(43,OracleTypes.CURSOR);
			cstmt.registerOutParameter(44, Types.VARCHAR);
			cstmt.registerOutParameter(45, Types.VARCHAR);
			cstmt.registerOutParameter(46, Types.VARCHAR);
			cstmt.registerOutParameter(47, Types.VARCHAR);
			cstmt.registerOutParameter(48, Types.VARCHAR);
			cstmt.registerOutParameter(49, Types.VARCHAR);
			System.out.println("before set N");
			cstmt.setString(50,"N");
			cstmt.setString(51,"N");
			System.out.println("after set N");
			cstmt.registerOutParameter(50, Types.VARCHAR);
			cstmt.registerOutParameter(51, Types.VARCHAR);
			cstmt.registerOutParameter(52, Types.VARCHAR);
			//cstmt.registerOutParameter(26,OracleTypes.CURSOR);
			//System.out.println("setBalSplDepAmt"+(checkForNull(rst.getString("v_ref_dep_adj_amt"))));
			
			System.out.println("before execute1");
			cstmt.execute();
			response.setTotalRecordCount(cstmt.getInt(39));
			System.out.println("after execute1");
			try{
				rst = (ResultSet) cstmt.getObject(40);
			}
			catch(Exception rsEx1){
				rst = null;
				rsEx1.printStackTrace();
			}
			
			if(rst != null){
				while(rst.next()){
					custBean = new BillReceiptCustomerDetails();
					custBean.setCustCode(checkForNull(rst.getString("cust_code")));
					custBean.setCustGroupCode(checkForNull(rst.getString("cust_group_code")));
					custBean.setBlngGrpId(checkForNull(rst.getString("blng_grp_id")));
					custBean.setPolicyTypeCode(checkForNull(rst.getString("policy_type_code")));
					custBean.setPolicyNo(checkForNull(rst.getString("policy_number")));
					custBean.setEffectiveFrom(checkForNull(rst.getString("policy_effective_from")));
					custBean.setEffectiveTo(checkForNull(rst.getString("policy_effective_to")));
					custBean.setCreditAuthRef(checkForNull(rst.getString("credit_auth_ref")));
					custBean.setCreditAuthDate(checkForNull(rst.getString("credit_auth_date")));
					custBean.setCustSrlNo(checkForNull(rst.getString("cust_srl_no")));
					custBean.setPriority(checkForNull(rst.getString("priority")));
					//custBean.setTrxDocRefSeqNum(checkForNull(rst.getString("trx_doc_ref_seq_num")));
					custList.add(custBean);
				}
			}
			
			if(rst != null){
				rst.close();
			}
	        
			try{
				rst = (ResultSet) cstmt.getObject(41);
			}
			catch(Exception rsEx2){
				rst = null;
				rsEx2.printStackTrace();
			}
			
			if(rst != null){
				while(rst.next()){
					serviceBean = new BillReceiptServiceDetails();
					serviceBean.setInsPkgPatInd(checkForNull(rst.getString("ins_pkg_pat_ind")));
					serviceBean.setPatientId(checkForNull(rst.getString("patient_id")));
					serviceBean.setSplitInd(checkForNull(rst.getString("split_ind")));
					serviceBean.setGrossAmt(round(rst.getString("org_gross_charge_amt"),deci));
					serviceBean.setDiscAmt(round(rst.getString("org_disc_amt"),deci));
					serviceBean.setNetAmt(round(rst.getString("org_net_charge_amt"),deci));
					serviceBean.setExclInBillYn(checkForNull(rst.getString("excluded_in_bill_yn")));
					serviceBean.setTrxFinalizeId(checkForNull(rst.getString("trx_finalize_ind")));
					serviceBean.setFacilityId(checkForNull(rst.getString("operating_facility_id")));
					serviceBean.setServiceDate(checkForNull(rst.getString("service_date")));
					serviceBean.setServItemDesc(checkForNull(rst.getString("serv_item_desc")));
					serviceBean.setServItemDescLang(checkForNull(rst.getString("serv_item_desc_oth_lang")));
					serviceBean.setConfirmedYn(checkForNull(rst.getString("confirmed_yn")));
					serviceBean.setTokenSerialNo(checkForNull(rst.getString("token_serial_no")));
					serviceBean.setTokenSeriesCode(checkForNull(rst.getString("token_series_code")));
					serviceBean.setEpisodeType(checkForNull(rst.getString("episode_type")));
					serviceBean.setPackageInd(checkForNull(rst.getString("package_ind")));
					serviceBean.setEpisodeId(checkForNull(rst.getString("episode_id")));
					serviceBean.setEncounterId(checkForNull(rst.getString("encounter_id")));
					serviceBean.setAcctSeqNo(checkForNull(rst.getString("acct_seq_no")));
					serviceBean.setServItemCode(checkForNull(rst.getString("serv_item_code")));
					serviceBean.setVisitId(checkForNull(rst.getString("visit_id")));
					serviceBean.setTrxDocRef(checkForNull(rst.getString("trx_doc_ref")));
					serviceBean.setTrxDoceRefLineNo(checkForNull(rst.getString("trx_doc_ref_line_num")));
					serviceBean.setTrxDocRefSeqNo(checkForNull(rst.getString("trx_doc_ref_seq_num")));
					serviceBean.setTrxStatus(checkForNull(rst.getString("trx_status")));
					serviceBean.setModuleId(checkForNull(rst.getString("module_id")));
					serviceBean.setBlngGrpId(checkForNull(rst.getString("blng_grp_id")));
					serviceBean.setBlngServCode(checkForNull(rst.getString("blng_serv_code")));
					serviceBean.setPrtGrpHdr(checkForNull(rst.getString("prt_grp_hdr_code")));
					serviceBean.setPrtGrpLine(checkForNull(rst.getString("prt_grp_line_code")));
					
					serviceBean.setPayerServGrpHdr(checkForNull(rst.getString("payer_serv_grp_hdr")));
					serviceBean.setPayerServGrpLine(checkForNull(rst.getString("payer_serv_grp_line")));
					serviceBean.setEntItemGrp(checkForNull(rst.getString("ent_item_grp_code")));
					serviceBean.setPayerItemGrp(checkForNull(rst.getString("payer_item_grp_code")));
					serviceBean.setUpdDiscAmt(checkForNull(rst.getString("upd_disc_amt")));
					serviceBean.setAdhocDiscAmt(checkForNull(rst.getString("adhoc_disc_amt")));
					serviceBean.setActGrossAmt(checkForNull(rst.getString("act_gross_amt")));
					serviceBean.setDailyProcessChargeInd(checkForNull(rst.getString("daily_process_charge_ind")));
					serviceBean.setPkgTrxYn(checkForNull(rst.getString("package_trx_yn")));
					serviceBean.setPkgSeqNo(checkForNull(rst.getString("package_seq_no")));
					serviceBean.setFolioRemarks(checkForNull(rst.getString("folio_remarks")));
					serviceBean.setRefFacilityId(checkForNull(rst.getString("ref_operating_facility_id")));
					serviceBean.setRefTrxDoxRef(checkForNull(rst.getString("ref_trx_doc_ref")));
					serviceBean.setRefTrxDoceRefLineNo(checkForNull(rst.getString("ref_trx_doc_ref_line_num")));
					serviceBean.setTfrPatientId(checkForNull(rst.getString("tfr_patient_id")));
					serviceBean.setTfrEpisodeType(checkForNull(rst.getString("tfr_episode_type")));
					serviceBean.setTfrEpisdoeId(checkForNull(rst.getString("tfr_episode_id")));
					serviceBean.setTfrVisitId(checkForNull(rst.getString("tfr_visit_id")));
					serviceBean.setHomeMedYn(checkForNull(rst.getString("home_medication_yn")));
					serviceBean.setGrossAmtPayer1(round(rst.getString("org_gross_charge_amt_p1"),deci));
					serviceBean.setGrossAmtPayer2(round(rst.getString("org_gross_charge_amt_p2"),deci));
					serviceBean.setGrossAmtPayer3(round(rst.getString("org_gross_charge_amt_p3"),deci));
					serviceBean.setGrossAmtPayer4(round(rst.getString("org_gross_charge_amt_p4"),deci));
					serviceBean.setGrossAmtPayer5(round(rst.getString("org_gross_charge_amt_p5"),deci));
					serviceBean.setGrossAmtPayer6(round(rst.getString("org_gross_charge_amt_p6"),deci));
					serviceBean.setGrossAmtPayer7(round(rst.getString("org_gross_charge_amt_p7"),deci));
					serviceBean.setDiscAmtPayer1(round(rst.getString("org_disc_amt_p1"),deci));
					serviceBean.setDiscAmtPayer2(round(rst.getString("org_disc_amt_p2"),deci));
					serviceBean.setDiscAmtPayer3(round(rst.getString("org_disc_amt_p3"),deci));
					serviceBean.setDiscAmtPayer4(round(rst.getString("org_disc_amt_p4"),deci));
					serviceBean.setDiscAmtPayer5(round(rst.getString("org_disc_amt_p5"),deci));
					serviceBean.setDiscAmtPayer6(round(rst.getString("org_disc_amt_p6"),deci));
					serviceBean.setDiscAmtPayer7(round(rst.getString("org_disc_amt_p7"),deci));
					serviceBean.setNetAmtPayer1(round(rst.getString("org_net_charge_amt_p1"),deci));
					serviceBean.setNetAmtPayer2(round(rst.getString("org_net_charge_amt_p2"),deci));
					serviceBean.setNetAmtPayer3(round(rst.getString("org_net_charge_amt_p3"),deci));
					serviceBean.setNetAmtPayer4(round(rst.getString("org_net_charge_amt_p4"),deci));
					serviceBean.setNetAmtPayer5(round(rst.getString("org_net_charge_amt_p5"),deci));
					serviceBean.setNetAmtPayer6(round(rst.getString("org_net_charge_amt_p6"),deci));
					serviceBean.setNetAmtPayer7(round(rst.getString("org_net_charge_amt_p7"),deci));
					serviceBean.setGrossTotal(round(rst.getString("tot_gross_charge_amt"),deci));
					serviceBean.setDiscTotal(round(rst.getString("tot_disc_amt"),deci));
					serviceBean.setNetTotal(round(rst.getString("tot_net_charge_amt"),deci));
					serviceBean.setPrintGrpHdrDesc(checkForNull(rst.getString("prt_grp_hdr_desc")));
					serviceBean.setPrintGrpLineDesc(checkForNull(rst.getString("service_desc")));
					serviceBean.setTrxDocRefSeqNoP1(checkForNull(rst.getString("trx_doc_ref_seq_num_p1")));
					serviceBean.setTrxDocRefSeqNoP2(checkForNull(rst.getString("trx_doc_ref_seq_num_p2")));
					serviceBean.setTrxDocRefSeqNoP3(checkForNull(rst.getString("trx_doc_ref_seq_num_p3")));
					serviceBean.setTrxDocRefSeqNoP4(checkForNull(rst.getString("trx_doc_ref_seq_num_p4")));
					serviceBean.setTrxDocRefSeqNoP5(checkForNull(rst.getString("trx_doc_ref_seq_num_p5")));
					serviceBean.setTrxDocRefSeqNoP6(checkForNull(rst.getString("trx_doc_ref_seq_num_p6")));
					serviceBean.setTrxDocRefSeqNoP7(checkForNull(rst.getString("trx_doc_ref_seq_num_p7")));
					serviceBean.setColorIndicator(checkForNull(rst.getString("rec_color"))); //to add from Result Set
					serviceBean.setOrderNo(checkForNull(rst.getString("order_no")));
					serviceBean.setQuantity(checkForNull(rst.getString("quantity")));
					serviceBean.setPhysician(checkForNull(rst.getString("physician_name")));
					serviceBean.setServiceDept(checkForNull(rst.getString("service_dept")));
					serviceList.add(serviceBean);
				}
			}
			
			if(rst != null){
				rst.close();
			}
			
			response.setServiceTypeCode(cstmt.getString(42));
			
			try{
				rst = (ResultSet) cstmt.getObject(43);
			}
			catch(Exception rsEx3){
				rst = null;
				rsEx3.printStackTrace();
			}
			
			summBean = new BillReceiptSummaryBean();
			if(rst != null){
				while(rst.next()){
					//summBean = new BillReceiptSummaryBean();
					summBean.setApproxPayerAmt(checkForNull(rst.getString("v_tot_payer_amt")));
					summBean.setApproxPatAmt(checkForNull(rst.getString("v_tot_pat_amt")));
					summBean.setPatAmt(checkForNull(rst.getString("v_patient_amt")));
					summBean.setExemptionAmt(checkForNull(rst.getString("v_tot_exemption_amt")));
					summBean.setDepositAmt(checkForNull(rst.getString("v_tot_deposit_amt")));
					summBean.setNetAmt(checkForNull(rst.getString("v_tot_net_amt")));
					summBean.setSplDepAdjAmt(checkForNull(rst.getString("v_spl_dep_adj_dtl__amt")));
					summBean.setSlmtAmt(checkForNull(rst.getString("v_tot_slmt_amt")));
					summBean.setSplDepAmt(checkForNull(rst.getString("v_tot_spl_dep_amt")));
					summBean.setAvlSplDepAmt(checkForNull(rst.getString("v_available_spl_dep_amt")));
					summBean.setAdjSplDepAmt(checkForNull(rst.getString("v_adjustable_spl_dep_amt")));
					summBean.setBalSplDepAmt(checkForNull(rst.getString("v_balance_spl_dep_amt")));
					summBean.setRefDepAdj(checkForNull(rst.getString("v_ref_dep_adj_amt")));
					summBean.setRefDepBal(checkForNull(rst.getString("v_ref_dep_bal_amt")));
					summBean.setRefprePayAdj(checkForNull(rst.getString("v_ref_prepay_dep_adj_amt")));
					summBean.setRefprePaybal(checkForNull(rst.getString("v_ref_prepay_dep_bal_amt")));
					summBean.setPrevUnBilledAmt(checkForNull(rst.getString("v_prev_unbilled_amt")));
					summBean.setPrevDepAdjAmt(checkForNull(rst.getString("v_dep_adj_amt")));
					summBean.setPrevPreAdjAmt(checkForNull(rst.getString("v_pre_adj_amt")));
					
					System.out.println("setBalSplDepAmt"+(checkForNull(rst.getString("v_ref_dep_adj_amt"))));
					
				}
			}
			
			if(rst != null){
				rst.close();
			}
			
			summBean.setDepAjustedYn(replaceNull1(cstmt.getString(50)));
			summBean.setPreAjustedYn(replaceNull1(cstmt.getString(51)));

			System.err.println("depadjyn ->"+replaceNull1(cstmt.getString(50)));
			System.err.println("prepayadjyn ->"+replaceNull1(cstmt.getString(51)));
			
			response.setCustList(custList);
			response.setServiceList(serviceList);
			response.setSummBean(summBean);
			response.setSplDepYN(cstmt.getString(44));
			response.setErrorCheck(cstmt.getString(45));
			
			
			String errorId = cstmt.getString(46);
			String messageId = cstmt.getString(47);
			String errorText = cstmt.getString(48);
			String error = "";
			String warning = cstmt.getString(49);
			List<String> errorList = new ArrayList<String>();
			
			if(errorId!=null || errorText!=null){
				errorList.add(errorText);
			}
						
			if(messageId!=null){
				if(messageId.contains("|")){
					String msgArr[] = messageId.split("\\|");
					for(int l=0;l<msgArr.length;l++){
						
						try{
							msgArr[l] = rb.getString(msgArr[l]);
						}
						catch(Exception rbException){
							msgArr[l] = getMessageString(msgArr[l],conn);
							System.err.println("Exceprion in RB ->"+rbException);
						}
						
						errorList.add(msgArr[l]);
					}
				}else{
					
					try{
						messageId = rb.getString(messageId);
					}
					catch(Exception rbException){
						messageId = getMessageString(messageId,conn);
						System.err.println("Exceprion in RB ->"+rbException);
					}
					errorList.add(messageId);					
				}
			}
			
			if(warning != null){
				try{
					warning = rb.getString(warning);
				}
				catch(Exception rbException){
					warning = getMessageString(warning,conn);
					System.err.println("Exceprion in RB ->"+rbException);
				}	
				finally{
					response.setWarning(warning);
				}
			}
			
			for (Iterator iterator = errorList.iterator(); iterator.hasNext();) {
				String err = (String) iterator.next();
				error += err + "\n";
			}
			response.setError(error);
			
			pstmt = conn.prepareStatement("Select bl_get_bill_gen_dtls.get_pkg_dtls_count(?,?,?,?,?,?) from dual");
			pstmt.setString(1, bean.getFacilityId());
			pstmt.setString(2, bean.getEpisodeId());
			pstmt.setString(3, bean.getEpisodeType());
			pstmt.setString(4, bean.getPatientId());
			pstmt.setString(5, bean.getVisitId());
			pstmt.setString(6, bean.getLocale());
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				response.setGetPackageCount(rst.getString(1));
			}
			
			
			
		}catch(Exception e){
			System.out.println("Exception in getPriceDetailsData in bLChargePatientServiceDetailsBean=>>>>>>>><<<<<<<<,BEANNN>>>>>>>> "+e); 
			e.printStackTrace();
		}
		finally
		{
				cstmt = null;
				rst = null;
				//if(con!=null) ConnectionManager.returnConnection(con);
				
		}

		
		return response;
	}


	public void insertExcludedServices(PlaceNewOrderRequest bean,BillReceiptExistOrderExclusion exclusionData,Connection conn) {		
		CallableStatement cstmt = null;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			List<BillReceiptExclusionDiscount> discExclList = exclusionData.getExclDiscList();
			if(discExclList == null){
				discExclList = new ArrayList<BillReceiptExclusionDiscount>();
			}
			StructDescriptor exclDiscStructDesc = StructDescriptor.createDescriptor("IBAEHIS.T_ADHOC_DISC_DTLS_REC", conn);
			ArrayDescriptor exclDiscArrDesc = ArrayDescriptor.createDescriptor("IBAEHIS.T_ADHOC_DISC_DTLS_TAB", conn);					
			
			int totalRec = discExclList.size();
			
			Object[] exclDiscArray = new Object[totalRec];  // to store n number of object data
		    Object[] exclDiscObj   = new Object[21];  // to store object data
			int recNo = 0;
			for (Iterator iterator = discExclList.iterator(); iterator.hasNext();) {
				BillReceiptExclusionDiscount discBean = (BillReceiptExclusionDiscount) iterator.next();
				exclDiscObj[0] = bean.getFacilityId();
				exclDiscObj[1] = bean.getPatientId();
				exclDiscObj[2] = bean.getEpisodeType();
				if("".equals(bean.getEpisodeId()) || bean.getEpisodeId()== null){
					exclDiscObj[3] = null;
				}
				else{
					exclDiscObj[3] = bean.getEpisodeId();
				}
				
				if("".equals(bean.getVisitId()) || bean.getVisitId()== null){
					exclDiscObj[4] = null;
				}
				else{
					exclDiscObj[4] = bean.getVisitId();
				}
				
				exclDiscObj[5] = discBean.getTrxDocRef();
				exclDiscObj[6] = discBean.getTrxDocRefLineNum();
				exclDiscObj[7] = discBean.getTrxDocRefSeqNum();
				exclDiscObj[8] = discBean.getBlngServCode();
				exclDiscObj[9] = discBean.getDiscOrExcl();
				if("".equals(bean.getLoginUser()) || bean.getLoginUser() == null){
					exclDiscObj[10] = null;
				}
				else{
					exclDiscObj[10] = discBean.getDiscUserId();//User who Authorizes
				}
				
				if("".equals(discBean.getDiscUserId()) || discBean.getDiscUserId()== null){
					exclDiscObj[11] = null;
				}
				else{
					exclDiscObj[11] = bean.getLoginUser();//User who logged in
				}
				
				if("".equals(discBean.getServiceDate()) || discBean.getServiceDate() == null){
					exclDiscObj[12] = null;
				}
				else{
					exclDiscObj[12] = new Timestamp(sdf.parse(discBean.getServiceDate()).getTime());//discBean.getServiceDate();
				}
				if("".equals(discBean.getItemCode()) || discBean.getItemCode()== null){
					exclDiscObj[13] = null;
				}
				else{
					exclDiscObj[13] = discBean.getItemCode();
				}
				
				if("".equals(discBean.getModuleId()) || discBean.getModuleId()== null){
					exclDiscObj[14] = null;
				}
				else{
					exclDiscObj[14] = discBean.getModuleId();
				}
				
				if("".equals(discBean.getCustCode()) || discBean.getCustCode()== null){
					exclDiscObj[15] = null;
				}
				else{
					exclDiscObj[15] = discBean.getCustCode();
				}
				
				if("".equals(discBean.getDiscReason()) || discBean.getDiscReason()== null){
					exclDiscObj[16] = null;
				}
				else{
					exclDiscObj[16] = discBean.getDiscReason();
				}
				
				if("".equals(discBean.getGrossAmt()) || discBean.getGrossAmt()== null){
					exclDiscObj[17] = null;
				}
				else{
					exclDiscObj[17] = discBean.getGrossAmt();
				}
				
				if("".equals(discBean.getDiscPerc()) ||  discBean.getDiscPerc()== null){
					exclDiscObj[18] = null;
				}
				else{
					exclDiscObj[18] = discBean.getDiscPerc();
				}
				
				if("".equals(discBean.getDiscAmt()) || discBean.getDiscAmt()== null){
					exclDiscObj[19] = null;
				}
				else{
					exclDiscObj[19] = discBean.getDiscAmt();
				}
				
				if("".equals(bean.getClientIpAddress()) || bean.getClientIpAddress() == null){
					exclDiscObj[20] = null;
				}
				else{
					exclDiscObj[20] = bean.getClientIpAddress();
				}
				
				
				STRUCT exlDiscObjStruct = new STRUCT(exclDiscStructDesc,conn, exclDiscObj);
				exclDiscArray[recNo]=exlDiscObjStruct;
				recNo++;
			} 
			
			ARRAY exclDiscParamArray = new ARRAY(exclDiscArrDesc,conn,exclDiscArray); 
			
			cstmt = conn.prepareCall("{ CALL bl_get_bill_gen_dtls.proc_apply_adhoc_disc_excl(?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setArray(1, exclDiscParamArray);
			cstmt.setString(2,bean.getPatientId());
			cstmt.setString(3, bean.getEpisodeType());
			cstmt.setString(4, bean.getEpisodeId());
			cstmt.setString(5, bean.getVisitId());
			cstmt.setString(6, null);
			cstmt.setString(7, null);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.execute();
			System.err.println(cstmt.getString(8));
			System.err.println(cstmt.getString(9));
			System.err.println(cstmt.getString(10));
		}
		/*try{
			String insertToGTT = "Insert into tmp_bill_receipt_exclusion(operating_facility_id,blng_serv_code,trx_doc_ref,trx_doc_ref_line_num,trx_doc_ref_seq_num,blng_serv_type,prt_grp_hdr_code,prt_grp_line_code) values(?,?,?,?,?,?,?,?)";
			HashMap<String,Set<String>> exclusionMap = exclusionData.getServiceExclusion();
			Set<String> groupExclusion = exclusionData.getGroupExclusion();
			Set<String> lineExclusion = exclusionData.getLineExclusion();
			Set<String> exclusionSet = null;
			String exclusion = "";
			if(exclusionMap != null && !exclusionMap.isEmpty()){
				for (Iterator iterator = exclusionMap.keySet().iterator(); iterator.hasNext();) {
					String key = (String) iterator.next();
					if(exclusionMap.containsKey(key)){
						exclusionSet = exclusionMap.get(key);
						if(exclusionSet != null && !exclusionSet.isEmpty()){
							for(Iterator<String> iter = exclusionSet.iterator(); iter.hasNext();){
								exclusion =  iter.next();
								String[] exclusionArr = splitExclusion(checkForNull(exclusion));
								if(exclusionArr.length == 4){
									pstmt = conn.prepareStatement(insertToGTT);
									pstmt.setString(1, exclusionData.getFacilityId());
									pstmt.setString(2, exclusionArr[0]);
									pstmt.setString(3, exclusionArr[1]);
									pstmt.setString(4, exclusionArr[2]);
									pstmt.setString(5, exclusionArr[3]);
									pstmt.setString(6, "D");	
									pstmt.setString(7, null);	
									pstmt.setString(8, null);	
									pstmt.execute();
								}
							}
						}
					}
				}
			}
			
			if(groupExclusion != null && !groupExclusion.isEmpty()){
				for(Iterator<String> iter = groupExclusion.iterator(); iter.hasNext();){
					exclusion =  iter.next();
					pstmt = conn.prepareStatement(insertToGTT);
					pstmt.setString(1, exclusionData.getFacilityId());
					pstmt.setString(2, null);
					pstmt.setString(3, null);
					pstmt.setString(4, null);
					pstmt.setString(5, null);
					pstmt.setString(6, "G");	
					pstmt.setString(7, exclusion);	
					pstmt.setString(8, null);	
					pstmt.execute();
				}
			}
			
			if(lineExclusion != null && !lineExclusion.isEmpty()){
				for(Iterator<String> iter = lineExclusion.iterator(); iter.hasNext();){
					exclusion =  iter.next();
					String[] exclusionArr = splitExclusion(checkForNull(exclusion));
					if(exclusionArr.length == 2){
						pstmt = conn.prepareStatement(insertToGTT);
						pstmt.setString(1, exclusionData.getFacilityId());
						pstmt.setString(2, null);
						pstmt.setString(3, null);
						pstmt.setString(4, null);
						pstmt.setString(5, null);
						pstmt.setString(6, "L");	
						pstmt.setString(7, exclusionArr[0]);	
						pstmt.setString(8, exclusionArr[1]);	
						pstmt.execute();
					}
				}
			}
		}*/
		catch(Exception e){
			System.err.println("Exception in insertExcludedServices ->"+e);
		}
		finally{
			cstmt = null;
		}
	}
	
	public String[] splitExclusion(String exclusion){
		String[] exclusionArr = exclusion.split("::::");
		return exclusionArr;
	}
	
	public String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}

	public void print(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement("Select operating_facility_id,trx_doc_ref,trx_doc_ref_line_num,trx_doc_ref_seq_num,blng_serv_type,blng_serv_code,prt_grp_hdr_code,prt_grp_line_code from tmp_bill_receipt_exclusion")  ;
			rst = pstmt.executeQuery();
			while(rst.next()){
				System.err.println(rst.getString(1)+"		"+rst.getString(2)+"		"+rst.getString(3)+"		"+rst.getString(4)+"		"+rst.getString(5)+"		"+rst.getString(6)+"		"+rst.getString(7)+"		"+rst.getString(8));
			}
		}
		catch(Exception e){
			
		}
		finally{
			ConnectionManager.returnConnection(con);
		}
	}
	
	public void print(Connection conn){
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try{
			//con = ConnectionManager.getConnection();
			pstmt = conn.prepareStatement("Select operating_facility_id,trx_doc_ref,trx_doc_ref_line_num,trx_doc_ref_seq_num,blng_serv_type,blng_serv_code,prt_grp_hdr_code,prt_grp_line_code from tmp_bill_receipt_exclusion")  ;
			rst = pstmt.executeQuery();
			while(rst.next()){
				System.err.println(rst.getString(1)+"		"+rst.getString(2)+"		"+rst.getString(3)+"		"+rst.getString(4)+"		"+rst.getString(5)+"		"+rst.getString(6)+"		"+rst.getString(7)+"		"+rst.getString(8));
			}
		}
		catch(Exception e){
			
		}
		finally{
			//ConnectionManager.returnConnection(con);
		}
	}
	
	public BillReceiptUnbillOutst getTotOutstUnbilled(BillReceiptRequest billRequest){
		BillReceiptUnbillOutst outstDetails = new BillReceiptUnbillOutst();
		Connection con = null;
		CallableStatement cstmt = null;
		try{
			con = ConnectionManager.getConnection();
			String sql = BlRepository.getBlKeyValue("GET_TOT_OUTST_UN_BILLED");
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getPatientId());
			cstmt.setString(3, billRequest.getEpisodeType());
			cstmt.setString(4, billRequest.getEpisodeId());
			cstmt.setString(5, billRequest.getVisitId());
			cstmt.registerOutParameter(6, Types.INTEGER);
			cstmt.registerOutParameter(7, Types.INTEGER);
			outstDetails.setOutStndAmt(cstmt.getString(6));
			outstDetails.setUnbilledAmt(cstmt.getString(7));
		}
		catch(Exception e){
			System.err.println("Exception in getting getTotOutstUnbilled ->"+e);
		}
		finally{
			cstmt = null;
			ConnectionManager.returnConnection(con);
		}
		return outstDetails;
	}
	
	public BillReceiptInfoDetails getHeaderDetails(BillReceiptRequest billRequest){
		BillReceiptInfoDetails infoDtls = new BillReceiptInfoDetails();
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;
		LinkedHashMap<String, String> custMap = new LinkedHashMap<String, String>();
		try{
			con = ConnectionManager.getConnection();
			String sql = BlRepository.getBlKeyValue("GET_BILL_RECEIPT_INFO_DTLS");
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getPatientId());
			cstmt.setString(3, billRequest.getEpisodeType());
			cstmt.setString(4, billRequest.getEpisodeId());
			cstmt.setString(5, billRequest.getVisitId());
			cstmt.setString(6, billRequest.getLoginUser());
			cstmt.setString(7, billRequest.getClientIpAddress());
			cstmt.setString(8, billRequest.getLocale());
			cstmt.registerOutParameter(9, Types.INTEGER);
			cstmt.registerOutParameter(10, Types.INTEGER);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.registerOutParameter(12, Types.VARCHAR);
			cstmt.registerOutParameter(13, Types.INTEGER);
			cstmt.registerOutParameter(14, Types.INTEGER);
			cstmt.registerOutParameter(15, Types.INTEGER);
			cstmt.registerOutParameter(16, Types.INTEGER);
			cstmt.registerOutParameter(17, Types.INTEGER);			
			cstmt.registerOutParameter(18, Types.VARCHAR);
			cstmt.registerOutParameter(19, Types.VARCHAR);
			cstmt.registerOutParameter(20, Types.VARCHAR);
			cstmt.registerOutParameter(21, Types.VARCHAR);
			cstmt.registerOutParameter(22, Types.VARCHAR);
			cstmt.registerOutParameter(23, Types.VARCHAR);
			cstmt.registerOutParameter(24, Types.VARCHAR);
			cstmt.registerOutParameter(25, Types.VARCHAR);
			cstmt.registerOutParameter(26, Types.VARCHAR);
			cstmt.registerOutParameter(27, Types.VARCHAR);
			cstmt.registerOutParameter(28, Types.VARCHAR);
			cstmt.registerOutParameter(29, Types.VARCHAR);
			cstmt.registerOutParameter(30, OracleTypes.CURSOR);
			
			cstmt.execute();
			infoDtls.setOutstCash(cstmt.getString(9));
			infoDtls.setOutstCredit(cstmt.getString(10));
			infoDtls.setCashCntrId(cstmt.getString(11));
			infoDtls.setCashCntrShiftId(cstmt.getString(12));
			infoDtls.setPatDepAvail(cstmt.getString(13));
			infoDtls.setPrePayAvail(cstmt.getString(14));
			infoDtls.setPatDepUnAdj(cstmt.getString(15));
			infoDtls.setPrePayUnAdj(cstmt.getString(16));
			infoDtls.setUnBilled(cstmt.getString(17));
			infoDtls.setLastBedChargeDt(cstmt.getString(18));
			infoDtls.setComputeUpto(cstmt.getString(19));
			
			infoDtls.setAdmDate(cstmt.getString(20)); //To get from Rst
			infoDtls.setDischDate(cstmt.getString(21)); //To get from Rst
			infoDtls.setMessageText(cstmt.getString(22));			
			infoDtls.setInterfaceYn(cstmt.getString(23));
			infoDtls.setFutureOrderYn(cstmt.getString(24));
			infoDtls.setIpBillType(cstmt.getString(25));
			infoDtls.setDefDepYn(cstmt.getString(26));
			infoDtls.setDefPreYn(cstmt.getString(27));	
			infoDtls.setExpDischOrDischLabel(cstmt.getString(28));
			infoDtls.setDisplayLastBedDate(cstmt.getString(29));
			
			rst = (ResultSet) cstmt.getObject(30);
			if(rst != null){
				while(rst.next()){
					System.err.println(rst.getString("cust_code"));
					System.err.println(rst.getString("short_name"));
					custMap.put(rst.getString("cust_code"), rst.getString("short_name"));					
				}
			}
			infoDtls.setCustMap(custMap);
		}
		catch(Exception e){
			System.err.println("Exception in getting getHeaderDetails ->"+e);
		}
		finally{
			cstmt = null;
			rst = null;
			ConnectionManager.returnConnection(con);
		}
		return infoDtls;
	}
	
	public List<BillReceiptUnbillOutst> getOutstandingBills(BillReceiptRequest billRequest){
		List<BillReceiptUnbillOutst> billInfoList = new ArrayList<BillReceiptUnbillOutst>();
		BillReceiptUnbillOutst outstBill = null;
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;

		try{
			con = ConnectionManager.getConnection();
			String sql = BlRepository.getBlKeyValue("GET_OUTSTANDING_BILLS");
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getPatientId());
			cstmt.registerOutParameter(3,OracleTypes.CURSOR);
			cstmt.execute();
			rst = (ResultSet) cstmt.getObject(3);
			if(rst != null){
				while(rst.next()){
					outstBill = new BillReceiptUnbillOutst();
					outstBill.setFacilityId(rst.getString("operating_facility_id"));
					outstBill.setEpisodeType(rst.getString("episode_type"));
					outstBill.setEpisodeNo(rst.getString("episode_id"));
					outstBill.setVisitId(rst.getString("visit_id"));
					outstBill.setTrxDate(rst.getString("nd_doc_date"));
					outstBill.setDocType(rst.getString("doc_type_code"));
					outstBill.setDocNum(rst.getString("doc_num"));
					outstBill.setCustCode(rst.getString("cust_code"));
					if("".equals(replaceNull(rst.getString("new_outst_amt")))){
						outstBill.setOutStndAmt(rst.getString("bill_tot_outst_amt"));
					}
					else{
						outstBill.setOutStndAmt(rst.getString("new_outst_amt"));
					}
					outstBill.setRefundAmt(rst.getString("nd_setl_refnd_amt"));
					outstBill.setExemAmt(rst.getString("exempt_amt"));	
					outstBill.setBillAmt(rst.getString("bill_amt"));
					billInfoList.add(outstBill);
				}
			}
					
			
		}
		catch(Exception e){
			System.err.println("Exception in getOutstandingBills -> "+e);
		}
		finally{
			cstmt = null;
			rst = null;
			ConnectionManager.returnConnection(con);
		}
		return billInfoList;
	}
	
	public List<BillReceiptUnbillOutst> getUnBilledEpisode(BillReceiptRequest billRequest){
		List<BillReceiptUnbillOutst> billInfoList = new ArrayList<BillReceiptUnbillOutst>();
		BillReceiptUnbillOutst unBillEpi = null;
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;

		try{
			con = ConnectionManager.getConnection();
			String sql = BlRepository.getBlKeyValue("GET_UNBILLED_EPI_BILLS");
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getPatientId());
			cstmt.registerOutParameter(3,OracleTypes.CURSOR);
			cstmt.execute();
			rst = (ResultSet) cstmt.getObject(3);
			if(rst != null){
				while(rst.next()){
					unBillEpi = new BillReceiptUnbillOutst();
					unBillEpi.setFacilityId(rst.getString("operating_facility_id"));
					unBillEpi.setEpisodeType(rst.getString("epi_type"));
					unBillEpi.setEpisodeNo(rst.getString("episd_id"));
					unBillEpi.setVisitId(rst.getString("vst_id"));
					unBillEpi.setGrossAmt(rst.getString("org_gross_charge_amt"));
					unBillEpi.setDiscountAmt(rst.getString("org_disc_amt"));
					unBillEpi.setNetAmt(rst.getString("org_net_charge_amt"));
					unBillEpi.setTrxDate(rst.getString("epi_dt"));
					billInfoList.add(unBillEpi);
				}
			}
					
			
		}
		catch(Exception e){
			System.err.println("Exception in getOutstandingBills -> "+e);
		}
		finally{
			cstmt = null;
			rst = null;
			ConnectionManager.returnConnection(con);
		}
		return billInfoList;
	}
	
	public HashMap<String,List<BillReceiptUnbillOutst>> getUnBilledEpisodeRequest(BillReceiptRequest billRequest){
		HashMap<String,List<BillReceiptUnbillOutst>> unBillEpiReqMap = new HashMap<String,List<BillReceiptUnbillOutst>>();
		List<BillReceiptUnbillOutst> dtlList = new ArrayList<BillReceiptUnbillOutst>();
		List<BillReceiptUnbillOutst> summList = new ArrayList<BillReceiptUnbillOutst>();
		BillReceiptUnbillOutst unBillEpi = null;
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;

		try{
			con = ConnectionManager.getConnection();
			String sql = BlRepository.getBlKeyValue("GET_UNBILLED_EPI_SERVICE");
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getPatientId());
			cstmt.setString(3, billRequest.getLocale());
			cstmt.setString(4, billRequest.getEpisodeType());
			cstmt.setString(5, billRequest.getEpisodeId());
			cstmt.setString(6, billRequest.getVisitId());
			cstmt.registerOutParameter(7,OracleTypes.CURSOR);
			cstmt.registerOutParameter(8,OracleTypes.CURSOR);
			cstmt.execute();
			rst = (ResultSet) cstmt.getObject(7);
			if(rst != null){
				while(rst.next()){
					unBillEpi = new BillReceiptUnbillOutst();
					unBillEpi.setModuleId(rst.getString("module_id"));
					unBillEpi.setBillDate(rst.getString("service_date"));
					unBillEpi.setTrxDate(rst.getString("trx_date"));
					unBillEpi.setBlngServCode(rst.getString("blng_serv_code"));
					unBillEpi.setBlngServDesc(rst.getString("short_desc"));
					unBillEpi.setQty(rst.getString("serv_qty"));
					unBillEpi.setGrossAmt(rst.getString("upd_gross_charge_amt"));
					unBillEpi.setDiscountAmt(rst.getString("upd_disc_amt"));
					unBillEpi.setNetAmt(rst.getString("upd_net_charge_amt"));
					System.out.println("in getUnBilledEpisodeRequest in 666="+rst.getString("upd_net_charge_amt"));
					unBillEpi.setConfirmed(rst.getString("CONFIRMED_YN"));
					unBillEpi.setProcessed (rst.getString("PROCESSED_YN"));
				
					dtlList.add(unBillEpi);
				}
			}
			
			rst = null;
			rst = (ResultSet) cstmt.getObject(8);
			if(rst != null && rst.next()){
				unBillEpi = new BillReceiptUnbillOutst();
				unBillEpi.setGrossAmt(checkForNull(rst.getString("upd_gross_charge_amt")));
				unBillEpi.setDiscountAmt(checkForNull(rst.getString("upd_disc_amt")));
				unBillEpi.setNetAmt(checkForNull(rst.getString("upd_net_charge_amt")));
				
				summList.add(unBillEpi);
			}	
			
			unBillEpiReqMap.put("detail", dtlList);
			unBillEpiReqMap.put("summary", summList);
			
		}
		catch(Exception e){
			System.err.println("Exception in getOutstandingBills -> "+e);
		}
		finally{
			cstmt = null;
			rst = null;
			ConnectionManager.returnConnection(con);
		}
		return unBillEpiReqMap;
	}

	public List<BillReceiptPackageInfo> getPackageClosureDtls(BillReceiptRequest billRequest){
		List<BillReceiptPackageInfo> pkgClosureList = new ArrayList<BillReceiptPackageInfo>();
		BillReceiptPackageInfo pkgInfo = null;
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection();
			String sql = BlRepository.getBlKeyValue("GET_PACKAGE_CLOSURE");
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getEpisodeId());
			cstmt.setString(3, billRequest.getEpisodeType());
			cstmt.setString(4, billRequest.getPatientId());
			cstmt.setString(5, billRequest.getVisitId());
			cstmt.setString(6, billRequest.getLocale());
			cstmt.registerOutParameter(7,OracleTypes.CURSOR);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.execute();
			rst = (ResultSet) cstmt.getObject(7);
			String pkg_close_yn = cstmt.getString(8);
			if(rst != null){
				while(rst.next()){
					pkgInfo = new BillReceiptPackageInfo();
					pkgInfo.setPackageCode(rst.getString("package_code"));
					pkgInfo.setPackageDesc(rst.getString("package_desc"));
					pkgInfo.setPkgSeqNo(rst.getString("package_seq_no"));
					pkgInfo.setPackageAmt(rst.getString("package_amt"));
					pkgInfo.setUtilized(rst.getString("utilized_amt"));
					pkgInfo.setDepositAmt(rst.getString("deposit_amt"));
					pkgInfo.setAcrossEncYn(rst.getString("across_encounter_yn"));					
										
					pkgClosureList.add(pkgInfo);
				}
			}
				pkgInfo.setPkgCloseYn(cstmt.getString(8));
			
			
		}
		catch(Exception e){
			System.err.println("Exception in getOutstandingBills -> "+e);
		}
		finally{
			cstmt = null;
			if(rst != null){
				try{
					rst.close();
				}
				catch(Exception rsEx){
					
				}
			}
			ConnectionManager.returnConnection(con);
		}
		return pkgClosureList;
	}


	public List<BillReceiptPackageInfo> getPackageDtls(BillReceiptRequest billRequest) {
		List<BillReceiptPackageInfo> pkgList = new ArrayList<BillReceiptPackageInfo>();
		BillReceiptPackageInfo pkgInfo = null;
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection();
			String sql = BlRepository.getBlKeyValue("GET_PACKAGE_DTLS");
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getPatientId());
			cstmt.setString(3, billRequest.getEpisodeType());
			cstmt.setString(4, billRequest.getEpisodeId());
			cstmt.setString(5, billRequest.getVisitId());
			cstmt.registerOutParameter(6,OracleTypes.CURSOR);			
			cstmt.execute();
			rst = (ResultSet) cstmt.getObject(6);
			if(rst != null){
				while(rst.next()){
					pkgInfo = new BillReceiptPackageInfo();
					pkgInfo.setEpisodeId(replaceNull(rst.getString("episode_id")));			
					pkgInfo.setEpisodeType(rst.getString("episode_type"));
					pkgInfo.setVisitId(replaceNull(rst.getString("visit_id")));
					pkgInfo.setPackageCode(rst.getString("package_code"));
					pkgInfo.setPackageDesc(rst.getString("v_short_desc"));
					pkgInfo.setBlngServCode(replaceNull(rst.getString("blng_serv_code")));
					pkgInfo.setBlngServDesc(replaceNull(rst.getString("serv_desc")));
					pkgInfo.setGrossAmt(replaceNull(rst.getString("upd_gross_charge_amt")));
					pkgInfo.setDiscAmt(replaceNull(rst.getString("upd_disc_amt")));
					pkgInfo.setNetAmt(replaceNull(rst.getString("upd_net_charge_amt")));									
					pkgInfo.setBlngGrpId(replaceNull(rst.getString("blng_grp_id")));
					pkgInfo.setCustDes(replaceNull(rst.getString("cust_desc")));
					pkgList.add(pkgInfo);
				}
			}
			
			
			
		}
		catch(Exception e){
			System.err.println("Exception in getOutstandingBills -> "+e);
		}
		finally{
			cstmt = null;
			if(rst != null){
				try{
					rst.close();
				}
				catch(Exception rsEx){
					
				}
			}
			ConnectionManager.returnConnection(con);
		}
		return pkgList;
	}
	
	public List<BillReceiptCustomerDetails> getEncBillDetails(BillReceiptRequest billRequest){
		List<BillReceiptCustomerDetails> custList = new ArrayList<BillReceiptCustomerDetails>();
		BillReceiptCustomerDetails cust = null;
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;

		try{
			con = ConnectionManager.getConnection();
			String sql = BlRepository.getBlKeyValue("GET_ENC_BILL_DTLS");
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getEpisodeId());
			cstmt.setString(3, billRequest.getEpisodeType());
			cstmt.setString(4, billRequest.getPatientId());
			cstmt.setString(5, billRequest.getVisitId());
			cstmt.setString(6, billRequest.getLocale());
			cstmt.registerOutParameter(7,OracleTypes.CURSOR);			
			cstmt.execute();
			rst = (ResultSet) cstmt.getObject(7);
			if(rst != null){
				while(rst.next()){
					cust = new BillReceiptCustomerDetails();
					cust.setBlngGrpId(rst.getString("blng_grp_desc"));			
					cust.setPriority(rst.getString("priority"));
					cust.setCustCode(rst.getString("cust_desc"));
					cust.setPolicyTypeCode(rst.getString("policy_type_code"));
					cust.setPolicyNo(rst.getString("policy_number"));
					cust.setPolStartDate(rst.getString("policy_start_date"));
					cust.setPolExpDate(rst.getString("policy_expiry_date"));
					cust.setCreditAuthRef(rst.getString("credit_auth_ref"));
					cust.setCreditAuthDate(rst.getString("credit_auth_date"));
					cust.setEffectiveFrom(rst.getString("effective_from"));
					cust.setEffectiveTo(rst.getString("effective_to"));	
					cust.setApprovedAmt(rst.getString("approved_amt"));
					cust.setApprovedDays(rst.getString("approved_days"));
										
					custList.add(cust);
				}
			}
			
			
			
		}
		catch(Exception e){
			System.err.println("Exception in getOutstandingBills -> "+e);
		}
		finally{
			cstmt = null;
			if(rst != null){
				try{
					rst.close();
				}
				catch(Exception rsEx){
					
				}
			}
			ConnectionManager.returnConnection(con);
		}
		return custList;
	}
	
	public List<String> closePackage(BillReceiptRequest billRequest){
		List<String> errorList = new ArrayList<String>();
		Locale loc = new Locale(billRequest.getLocale());
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;

		try{
			con = ConnectionManager.getConnection();
			List<BillReceiptPackageInfo> pkgList = billRequest.getPkgList();
			StructDescriptor pkgStructDesc = StructDescriptor.createDescriptor("IBAEHIS.T_PKG_DTLS_REC", con);
			ArrayDescriptor pkgArrDesc = ArrayDescriptor.createDescriptor("IBAEHIS.T_PKG_DTLS_TAB", con);					
			
			int totalRec = pkgList.size();
			System.out.println("size:::::::::+++++111"+ pkgList.size());
			Object[] pkgArray = new Object[totalRec];  // to store n number of object data
		    Object[] pkgObj   = new Object[9];  // to store object data
			int recNo = 0;
			for (Iterator iterator = pkgList.iterator(); iterator.hasNext();) {
				BillReceiptPackageInfo pkgBean = (BillReceiptPackageInfo) iterator.next();
				pkgObj[0] = billRequest.getFacilityId();
				pkgObj[1] = billRequest.getPatientId();
				
				if("".equals(pkgBean.getPkgSeqNo()) || pkgBean.getPkgSeqNo()== null){
					pkgObj[2] = null;
				}
				else{
					pkgObj[2] = pkgBean.getPkgSeqNo();
				}
				
				if("".equals(pkgBean.getPackageCode()) || pkgBean.getPackageCode()== null){
					pkgObj[3] = null;
				}
				else{
					pkgObj[3] = pkgBean.getPackageCode();
				}
				
				pkgObj[4] = billRequest.getEpisodeType();
				
				if("".equals(billRequest.getEpisodeId()) || billRequest.getEpisodeId() == null){
					pkgObj[5] = null;
				}
				else{
					pkgObj[5] = billRequest.getEpisodeId();
				}
				
				if("".equals(billRequest.getVisitId()) || billRequest.getVisitId() == null){
					pkgObj[6] = null;
				}
				else{
					pkgObj[6] = billRequest.getVisitId();
				}
				pkgObj[7] = billRequest.getLoginUser();
				pkgObj[8] = billRequest.getClientIpAddress();
				
				
				STRUCT pkgObjStruct = new STRUCT(pkgStructDesc,con, pkgObj);
				pkgArray[recNo]=pkgObjStruct;
				recNo++;
			} 
			
			ARRAY pkgParamArray = new ARRAY(pkgArrDesc,con,pkgArray); 
			cstmt = con.prepareCall("{ call bl_get_bill_gen_dtls.bl_package_closure(?,?,?,?,?,?,?,?,?,?,?,?,?) }");
			cstmt.setArray(1, pkgParamArray);
			cstmt.setString(2,billRequest.getFacilityId());
			cstmt.setString(3,billRequest.getPatientId());
			cstmt.setString(4,billRequest.getEpisodeType());
			cstmt.setString(5,billRequest.getEpisodeId());
			cstmt.setString(6,billRequest.getVisitId());
			cstmt.setString(7,null);
			cstmt.setString(8,null);
			cstmt.setString(9,billRequest.getLoginUser());
			cstmt.setString(10,billRequest.getClientIpAddress());
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.registerOutParameter(12, Types.VARCHAR);
			cstmt.registerOutParameter(13, Types.VARCHAR);
			cstmt.execute();
			String sys_err_id = cstmt.getString(11);
			String str_sysmesage_id = cstmt.getString(12);
			String sys_err_text = cstmt.getString(13);	
			if(sys_err_id != null || sys_err_text != null){
				errorList.add(sys_err_text);
			}
			
			if(str_sysmesage_id!=null){
				if(str_sysmesage_id.contains("|")){
					String msgArr[] = str_sysmesage_id.split("\\|");
					for(int l=0;l<msgArr.length;l++){


						try{
							msgArr[l] = rb.getString(msgArr[l]);
						}
						catch(Exception rbException){
							msgArr[l] = getMessageString(msgArr[l],con);
							System.err.println("Exceprion in RB ->"+rbException);
						}
						errorList.add(msgArr[l]);
					}
				}else{

					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						str_sysmesage_id = getMessageString(str_sysmesage_id,con);
						System.err.println("Exceprion in RB ->"+rbException);
					}
					errorList.add(str_sysmesage_id);
				}
			}
			
			if(errorList.isEmpty()){
				con.commit();
			}
			else{
				con.rollback();
			}
		}
		catch(Exception e){
			System.err.println("Exception in getOutstandingBills -> "+e);
		}
		finally{
			cstmt = null;
			if(rst != null){
				try{
					rst.close();
				}
				catch(Exception rsEx){
					
				}
			}
			ConnectionManager.returnConnection(con);
		}
		return errorList;
	}
	
	public List<String> reopenPackage(BillReceiptRequest billRequest){
		List<String> errorList = new ArrayList<String>();
		Locale loc = new Locale(billRequest.getLocale());
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;

		try{
			con = ConnectionManager.getConnection();
			List<BillReceiptPackageInfo> pkgList = billRequest.getPkgList();
			
			
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("REOPEN_PACKAGE"));
			cstmt.setString(1,billRequest.getFacilityId());
			cstmt.setString(2,billRequest.getPkgSeqNo());
			cstmt.setString(3,billRequest.getLoginUser());
			cstmt.setString(4,billRequest.getClientIpAddress());
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.execute();
			String sys_err_id = cstmt.getString(5);
			String str_sysmesage_id = cstmt.getString(6);
			String sys_err_text = cstmt.getString(7);	
			
			
			if(sys_err_id != null || sys_err_text != null){
				errorList.add(sys_err_text);
			}
			
			if(str_sysmesage_id!=null){
				if(str_sysmesage_id.contains("|")){
					String msgArr[] = str_sysmesage_id.split("\\|");
					for(int l=0;l<msgArr.length;l++){


						try{
							msgArr[l] = rb.getString(msgArr[l]);
						}
						catch(Exception rbException){
							msgArr[l] = getMessageString(msgArr[l],con);
							System.err.println("Exceprion in RB ->"+rbException);
						}
						errorList.add(msgArr[l]);
					}
				}else{

					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						str_sysmesage_id = getMessageString(str_sysmesage_id,con);
						System.err.println("Exceprion in RB ->"+rbException);
					}
					errorList.add(str_sysmesage_id);
				}
			}
			
			if(errorList.isEmpty()){
				con.commit();
			}
			else{
				con.rollback();
			}
		}
		catch(Exception e){
			System.err.println("Exception in getOutstandingBills -> "+e);
		}
		finally{
			cstmt = null;
			if(rst != null){
				try{
					rst.close();
				}
				catch(Exception rsEx){
					
				}
			}
			ConnectionManager.returnConnection(con);
		}
		return errorList;
	}
	
	
	
	public String getMessageString(String messageId, Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String output = "";
		String messageQuery = "select message_text_sysdef from sm_message where message_id = ?";
		try{
			pstmt = con.prepareStatement(messageQuery);
			pstmt.setString(1, messageId);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				output = messageId+"-"+rst.getString("message_text_sysdef");
			}						
			
		}
		catch(Exception e){
			System.err.println("Exception in getting Message String ->"+e);
			output = messageId;
		}
		finally{
			pstmt = null;
			rst = null;
			
		}
		return output;
	}	
	
	public String bedComputationYN(BillReceiptRequest billRequest){
		String computeYN = "";
		CallableStatement cstmt = null;
		Connection con = null;
		try{
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("BED_COMPUTATION_YN"));
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getPatientId());
			cstmt.setString(3, billRequest.getEpisodeType());
			cstmt.setString(4, billRequest.getEpisodeId());			
			cstmt.setString(5, billRequest.getVisitId());
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.execute();
			computeYN = cstmt.getString(6);
		}
		catch(Exception e){
			System.err.println("Exception in bedComputationYN ->"+e);
		}
		finally{
			cstmt = null;
			ConnectionManager.returnConnection(con);
		}
		return computeYN;
	}
	
	public JsonObject bedComputationAlert(BillReceiptRequest billRequest){
		JsonObject obj = new JsonObject();
		CallableStatement cstmt = null;
		Connection con = null;
		String messageId = "";
		String errorText="";
		Locale loc = new Locale(billRequest.getLocale());
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		String str_sysmesage_id = "";
		try{
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("BED_COMPUTATION_ALERT"));
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getPatientId());
			cstmt.setString(3, billRequest.getEpisodeType());
			cstmt.setString(4, billRequest.getEpisodeId());
			cstmt.setString(5, billRequest.getVisitId());
			cstmt.setString(6, billRequest.getEncounterId());
			cstmt.setString(7, billRequest.getLocale());
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.setString(12,billRequest.getLoginUser());
			cstmt.setString(13, billRequest.getClientIpAddress());
			cstmt.execute();
			errorText = cstmt.getString(10);
			messageId = cstmt.getString(11);
		System.out.println("be compute errorText="+errorText+"-messageId= "+messageId);
		
		
		
			if( "".equals(replaceNull(messageId)) && "".equals(replaceNull(errorText))){
				obj.addProperty("Success", "Y");
			}
			else{
				obj.addProperty("Success", "N");
				obj.addProperty("messageId",messageId);
				obj.addProperty("errorText",errorText);
			}
			obj.addProperty("alertMess", replaceNull(cstmt.getString(9)));
			obj.addProperty("supDischargeDay", replaceNull(cstmt.getString(8)));
			str_sysmesage_id = "BL6280";
			try{
				str_sysmesage_id = rb.getString(str_sysmesage_id);
			}
			catch(Exception rbException){
				str_sysmesage_id = getMessageString(str_sysmesage_id,con);
				System.err.println("Exceprion in RB ->"+rbException);
			}
			obj.addProperty("exemptMessage", str_sysmesage_id);
			
				if(messageId!=null){
					if(messageId.contains("|")){
						String msgArr[] = messageId.split("\\|");
						for(int l=0;l<msgArr.length;l++){
							
							try{
								msgArr[l] = rb.getString(msgArr[l]);
							}
							catch(Exception rbException){
								msgArr[l] = getMessageString(msgArr[l],con);
								System.err.println("Exceprion in RB ->"+rbException);
							}
							obj.addProperty("messageId", msgArr[l]);
							//errorList.add(msgArr[l]);
						}
					}else{
						
						try{
							messageId = rb.getString(messageId);
						}
						catch(Exception rbException){
							messageId = getMessageString(messageId,con);
							System.err.println("Exceprion in RB 11111->"+rbException);
						}
						//errorList.add(messageId);	
						obj.addProperty("messageId", messageId);
					}
				}				
	
		}
		catch(Exception e){
			System.err.println("Exception in bedComputationYN ->"+e);
		}
		finally{
			cstmt = null;
			ConnectionManager.returnConnection(con);
		}
		return obj;
	}
	
	public List<String> bedComputationMain(BillReceiptRequest billRequest){
		List<String> errorList = new ArrayList<String>();
		CallableStatement cstmt = null;
		Connection con = null;
		String sql = "";
		String errorId = "";
		String errorText = "";
		String messageId = "";
		Locale loc = new Locale(billRequest.getLocale());
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try{
			if("F".equals(billRequest.getIpChkOutBasisInd())){
				sql = BlRepository.getBlKeyValue("BED_COMPUTATION_MAIN_FIXED");
			}
			else{
				sql = BlRepository.getBlKeyValue("BED_COMPUTATION_MAIN");
			}
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(sql);
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getPatientId());
			cstmt.setString(3, billRequest.getEpisodeType());
			cstmt.setString(4, billRequest.getEpisodeId());
			cstmt.setString(5, billRequest.getVisitId());
			cstmt.setString(6, billRequest.getEncounterId());
			if("F".equals(billRequest.getIpChkOutBasisInd())){
				cstmt.setString(7, billRequest.getAdmDateTime());
				cstmt.setString(8, billRequest.getDischDateTime());
				cstmt.setString(9, billRequest.getLoginUser());
				cstmt.setString(10, billRequest.getClientIpAddress());
				cstmt.setString(11, billRequest.getUptoCalDate());
				cstmt.setString(12, billRequest.getFunctionId());
				cstmt.setString(13, billRequest.getSuppressDischarge());
				cstmt.registerOutParameter(14, Types.VARCHAR);
				cstmt.registerOutParameter(15, Types.VARCHAR);
				cstmt.registerOutParameter(16, Types.VARCHAR);
				cstmt.execute();
				errorId = cstmt.getString(14);
				messageId = cstmt.getString(15);
				errorText = cstmt.getString(16);				
			}
			else{
				cstmt.setString(7, billRequest.getLoginUser());
				cstmt.setString(8, billRequest.getClientIpAddress());
				if("".equals(billRequest.getUptoCalDate())){
					cstmt.setString(9, null);
				}
				else{
					cstmt.setTimestamp(9, new Timestamp(sdf.parse(billRequest.getUptoCalDate()).getTime()));
				}
				cstmt.setString(10, billRequest.getFunctionId());
				cstmt.setString(11, billRequest.getSuppressDischarge());
				cstmt.registerOutParameter(12, Types.VARCHAR);
				cstmt.registerOutParameter(13, Types.VARCHAR);
				cstmt.registerOutParameter(14, Types.VARCHAR);
				cstmt.execute();
				errorId = cstmt.getString(12);
				messageId = cstmt.getString(13);
				errorText = cstmt.getString(14);
			}
			if(errorId!=null || errorText!=null){
				errorList.add(errorText);
			}
						
			if(messageId!=null){
				if(messageId.contains("|")){
					String msgArr[] = messageId.split("\\|");
					for(int l=0;l<msgArr.length;l++){
						
						try{
							msgArr[l] = rb.getString(msgArr[l]);
						}
						catch(Exception rbException){
							msgArr[l] = getMessageString(msgArr[l],con);
							System.err.println("Exceprion in RB ->"+rbException);
						}
						
						errorList.add(msgArr[l]);
					}
				}else{
					
					try{
						messageId = rb.getString(messageId);
					}
					catch(Exception rbException){
						messageId = getMessageString(messageId,con);
						System.err.println("Exceprion in RB ->"+rbException);
					}
					errorList.add(messageId);					
				}
			}
			
			if(errorList.isEmpty()){
				con.commit();
			}
			else{
				con.rollback();
			}

		}
		catch(Exception e){
			System.err.println("Exception in bedComputationYN ->"+e);
		}
		finally{
			cstmt = null;
			ConnectionManager.returnConnection(con);
		}
		return errorList;
	}
	
	public JsonObject recalcDepositSlmt(BillGenerationRequest billRequest){
		CallableStatement cstmt = null;
		Connection con = null;
		JsonObject obj = new JsonObject();
		try{
			System.out.println("recalcDepositSlmt");
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("RECLAC_DEPOSIT_SLMT"));
			cstmt.setString(1, billRequest.getPatientId());
			cstmt.setString(2, billRequest.getEpisodeType());
			cstmt.setString(3, billRequest.getEpisodeId());
			cstmt.setString(4, billRequest.getVisitId());
			cstmt.setString(5, billRequest.getDepAdjYn());
			cstmt.setString(6, billRequest.getPrePayAdjYn());
			cstmt.setString(7, billRequest.getPatAmt());
			cstmt.setString(8, billRequest.getApproxPatAmt());
			cstmt.setString(9, billRequest.getSlmtAmt());
			cstmt.setString(10, billRequest.getDeposits());
			cstmt.setString(11,billRequest.getDepAjustedYn());
			cstmt.setString(12,billRequest.getPreAjustedYn());
			cstmt.setString(13,billRequest.getRefDepAdj());
			cstmt.setString(14,billRequest.getRefDepBal());
			cstmt.setString(15,billRequest.getRefprePayAdj());
			cstmt.setString(16,billRequest.getRefprePaybal());
			cstmt.setString(17,billRequest.getPrevDepAdjAmt());
			cstmt.setString(18,billRequest.getPrevPreAdjAmt());
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.registerOutParameter(12, Types.VARCHAR);
			cstmt.registerOutParameter(13, Types.VARCHAR);
			cstmt.registerOutParameter(14, Types.VARCHAR);
			cstmt.registerOutParameter(15, Types.VARCHAR);
			cstmt.registerOutParameter(16, Types.VARCHAR);
			cstmt.registerOutParameter(17, Types.VARCHAR);
			cstmt.registerOutParameter(18, Types.VARCHAR);
			cstmt.execute();
			
			obj.addProperty("approxPatAmt", cstmt.getString(8));
			obj.addProperty("slmtAmt", cstmt.getString(9));
			obj.addProperty("deposits", cstmt.getString(10));
			obj.addProperty("depAjustedYn",replaceNull1(cstmt.getString(11)));
			obj.addProperty("preAjustedYn",replaceNull1(cstmt.getString(12)));
			obj.addProperty("refDepAdj",replaceNull1(cstmt.getString(13)));
			obj.addProperty("refDepBal",replaceNull1(cstmt.getString(14)));
			obj.addProperty("refprePayAdj",replaceNull1(cstmt.getString(15)));
			obj.addProperty("refprePaybal",replaceNull1(cstmt.getString(16)));
			obj.addProperty("prevDepAdjAmt",replaceNull(cstmt.getString(17)));
			obj.addProperty("prevPreAdjAmt",replaceNull(cstmt.getString(18)));
			
		}
		catch(Exception e){
			System.err.println("Exception in recalcDepositSlmt ->"+e);
		}
		finally{
			cstmt = null;
			ConnectionManager.returnConnection(con);
		}
		return obj;
	}
	
	public JsonObject validateCashCounter(BillReceiptRequest billRequest){
		CallableStatement cstmt = null;
		Connection con = null;
		JsonObject obj = new JsonObject();
		try{
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("BILL_CASH_COUNTER_VALIDATE"));
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getPatientId());
			cstmt.setString(3, billRequest.getEpisodeType());
			cstmt.setString(4, billRequest.getEpisodeId());
			cstmt.setString(5, billRequest.getVisitId());
			cstmt.setString(6, billRequest.getLoginUser());
			cstmt.setString(7, billRequest.getClientIpAddress());
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.registerOutParameter(12, Types.VARCHAR);
			cstmt.registerOutParameter(13, Types.VARCHAR);
			cstmt.execute();
			obj.addProperty("errorId",replaceNull(cstmt.getString(8)));
			obj.addProperty("errorText",replaceNull(cstmt.getString(9)));
			obj.addProperty("deceasedYn",replaceNull(cstmt.getString(10)));
			obj.addProperty("activeYn",replaceNull(cstmt.getString(11)));
			obj.addProperty("suspendYn",replaceNull(cstmt.getString(12)));
			obj.addProperty("ipFlag",replaceNull(cstmt.getString(13)));
		}
		catch(Exception e){
			System.err.println("Exception in validateCashCounter ->"+e);
		}
		finally{
			cstmt = null;
			ConnectionManager.returnConnection(con);
		}
		return obj;
	}
	
	public JsonObject specialClinicValidate(BillReceiptRequest billRequest){
		CallableStatement cstmt = null;
		Connection con = null;
		JsonObject obj = new JsonObject();
		try{
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("BL_SPECIAL_CLINIC_VALIDATE"));
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getEpisodeType());
			cstmt.setString(3, billRequest.getEpisodeId());
			cstmt.setString(4, billRequest.getVisitId());
			cstmt.setString(5, billRequest.getLoginUser());
			cstmt.setString(6, billRequest.getClientIpAddress());
			
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			
			cstmt.execute();
			obj.addProperty("errorId",replaceNull(cstmt.getString(7)));
			obj.addProperty("errorText",replaceNull(cstmt.getString(8)));
			
		}
		catch(Exception e){
			System.err.println("Exception in validateCashCounter ->"+e);
		}
		finally{
			cstmt = null;
			ConnectionManager.returnConnection(con);
		}
		return obj;
	}
	
	public JsonObject validateSettlementAmt(BillGenerationRequest billRequest){
		CallableStatement cstmt = null;
		Connection con = null;
		JsonObject obj = new JsonObject();
		try{
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("BILL_SETTLEMENT_AMOUNT_VALIDATE"));
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getPatientId());
			cstmt.setString(3, billRequest.getEpisodeType());
			cstmt.setString(4, billRequest.getEpisodeId());
			cstmt.setString(5, billRequest.getVisitId());
			cstmt.setString(6, billRequest.getPayerAmt());
			cstmt.setString(7, billRequest.getExemptAmt());
			cstmt.setString(8, billRequest.getDocAmt());
			cstmt.setString(9, billRequest.getSlmtAmt());
			cstmt.setString(10, billRequest.getDeposits());
			cstmt.setString(11, billRequest.getCashCntrCode());
			cstmt.setString(12, billRequest.getLoginUser());
			cstmt.registerOutParameter(13, Types.VARCHAR);
			cstmt.registerOutParameter(14, Types.VARCHAR);
			cstmt.registerOutParameter(15, Types.VARCHAR);
			cstmt.registerOutParameter(16, Types.VARCHAR);

			cstmt.execute();
			String errorLevel = replaceNull(cstmt.getString(13));
			String sysMessageId = replaceNull(cstmt.getString(14));
			String errorText = replaceNull(cstmt.getString(15));
			String warningMsg = replaceNull(cstmt.getString(16));
			
			if("".equals(errorLevel) && "".equals(sysMessageId) && "".equals(errorText)){
				obj.addProperty("errorYn","N");
				obj.addProperty("slmtAmt",billRequest.getSlmtAmt());
			}
			else{
				obj.addProperty("errorYn","Y");
				obj.addProperty("errorText",errorText);
				obj.addProperty("errorId",sysMessageId);
				obj.addProperty("slmtAmt",billRequest.getSlmtAmt());
				
			}
			
			obj.addProperty("warningMsg",warningMsg);
		}
		catch(Exception e){
			System.err.println("Exception in validateSettlementAmt ->"+e);
		}
		finally{
			cstmt = null;
			ConnectionManager.returnConnection(con);
		}
		return obj;
	}
	public JsonObject validateExemptionAmt(BillGenerationRequest billRequest){
		CallableStatement cstmt = null;
		Connection con = null;
		JsonObject obj = new JsonObject();
		try{
			BillReceiptServiceDAOImpl billBC = new BillReceiptServiceDAOImpl();
			//BillGenerationRequest billRequest = new BillGenerationRequest();
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("BILL_EXEMPTION_AMOUNT_VALIDATE"));
			cstmt.setString(1, billRequest.getFacilityId());
			cstmt.setString(2, billRequest.getLocale());
			cstmt.setString(3, billRequest.getExemptType());
			cstmt.setString(4, billRequest.getLoginUser());
			cstmt.setString(5, billRequest.getDocAmt());
			cstmt.setString(6, billRequest.getSlmtAmt());
			cstmt.setString(7, billRequest.getExemptAmt());
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.execute();
			String docAmt = replaceNull(cstmt.getString(5));
			String errorLevel = replaceNull(cstmt.getString(8));
			String sysMessageId = replaceNull(cstmt.getString(9));
			String errorText = replaceNull(cstmt.getString(10));
			
			
			
			
			if("".equals(errorLevel) && "".equals(sysMessageId) && "".equals(errorText)){
				obj.addProperty("errorYn","N");
				obj.addProperty("docAmt",docAmt);
				obj.addProperty("slmtAmt",billRequest.getSlmtAmt());
			}
			else{
				obj.addProperty("errorYn","Y");
				obj.addProperty("errorText",errorText);
				obj.addProperty("errorId",sysMessageId);
				
			}
			
			
		}
		catch(Exception e){
			System.err.println("Exception in validateExemptionAmt ->"+e);
		}
		finally{
			cstmt = null;
			ConnectionManager.returnConnection(con);
		}
		return obj;
	}
	
	public JsonObject chkExcludeServValidate(BillReceiptRequest billRequest){
		CallableStatement cstmt = null;
		Connection con = null;
		JsonObject obj = new JsonObject();
		try{
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("VALIDATE_SERV_EXCLUSION"));
			cstmt.setString(1,billRequest.getFacilityId());
			cstmt.setString (2,billRequest.getPatientId());
			cstmt.setString (3,billRequest.getEpisodeType());
			cstmt.setString(4,billRequest.getEpisodeId());
			cstmt.setString(5,billRequest.getVisitId());
			cstmt.setString(6,billRequest.getTrxDocRef());	
			cstmt.setString(7,billRequest.getTrxDocRefLine());	
			cstmt.setString(8,null);	
			cstmt.setString(9,billRequest.getExcludeInBill());	
			cstmt.setString(10,billRequest.getBlngServSeparate());					
			cstmt.registerOutParameter(11, Types.VARCHAR);							
			cstmt.registerOutParameter (12, Types.VARCHAR);
			cstmt.registerOutParameter(13, Types.VARCHAR);
			cstmt.execute();
			String errorLevel = replaceNull(cstmt.getString(11));
			String sysMessageId = replaceNull(cstmt.getString(12));
			String errorText = replaceNull(cstmt.getString(13));		
			
			if("".equals(errorLevel) && "".equals(sysMessageId) && "".equals(errorText)){
				obj.addProperty("allowYn","Y");
			}
			else{
				obj.addProperty("allowYn","N");
				obj.addProperty("errorText",errorText);
				obj.addProperty("errorId",sysMessageId);
			}				
		}
		catch(Exception e){
			System.err.println("Exception in validateSettlementAmt ->"+e);
		}
		finally{
			cstmt = null;
			ConnectionManager.returnConnection(con);
		}
		return obj;
	}
	
	public String checkForServiceDiscount(BillReceiptRequest billRequest){
		PreparedStatement pstmt = null;
		Connection con = null;
		String allowedYn = "N";
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("CHECK_SERVICE_DISCOUNT"));
			pstmt.setString(1,billRequest.getFacilityId());
			pstmt.setString(2,billRequest.getServCode());
			pstmt.setString(3,billRequest.getTrxDocRef());
			pstmt.setString(4,billRequest.getTrxDocRefLine());
			pstmt.setString(5,billRequest.getTrxDocRefSeq());
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				allowedYn = rst.getString("allowed_yn");
			}
			
		}
		catch(Exception e){
			System.err.println("Exception in validateSettlementAmt ->"+e);
			allowedYn = "N";
		}
		finally{
			rst = null;
			ConnectionManager.returnConnection(con);
		}
		return allowedYn;
	}
		
	public JsonObject  UnprocessedCheck(BillReceiptRequest billRequest){
		JsonObject obj = new JsonObject();
		CallableStatement cstmt = null;
		Connection con = null;
		
		Locale loc = new Locale(billRequest.getLocale());
		ResourceBundle rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
		String str_sysmesage_id = "";
		String error="";
		try{
			con = ConnectionManager.getConnection();
			cstmt =  con.prepareCall(BlRepository.getBlKeyValue("UNPROCESSED_CHECK"));
		
		 
			
		      cstmt.setString(1,billRequest.getFacilityId());
				cstmt.setString (2,billRequest.getPatientId());
				cstmt.setString (3,billRequest.getEpisodeType());
				cstmt.setString(4,billRequest.getEpisodeId());
				cstmt.setString(5,billRequest.getVisitId());
		
				cstmt.registerOutParameter(6, Types.VARCHAR);							
				cstmt.registerOutParameter (7, Types.VARCHAR);
				cstmt.registerOutParameter(8, Types.VARCHAR);
				cstmt.registerOutParameter(9, Types.VARCHAR);
				cstmt.execute();
				String errorLevel = replaceNull(cstmt.getString(7));
				String sysMessageId = replaceNull(cstmt.getString(8));
				String errorText = replaceNull(cstmt.getString(9));	
				
				errorText = cstmt.getString(9);
				if(errorText != null){
					obj.addProperty("Success", "N");
					obj.addProperty("errorText",errorText);
				}
				else{
					obj.addProperty("Success", "Y");
				}
				obj.addProperty("unprocessed_yn", replaceNull(cstmt.getString(6)));
				
				str_sysmesage_id = "BL9793";
				try{
					str_sysmesage_id = rb.getString(str_sysmesage_id);
				}
				catch(Exception rbException){
					str_sysmesage_id = getMessageString(str_sysmesage_id,con);
					System.err.println("Exceprion in RB ->"+rbException);
				}
				obj.addProperty("unprocessedMessage", str_sysmesage_id);
			}
			catch(Exception e){
				System.err.println("Exception in unprocessed ->"+e);
			}
			finally{
				cstmt = null;
				ConnectionManager.returnConnection(con);
			}
			return obj;
		}
			
	public List<BLBillGenInterfaceBean> getBillGenInterfaceRecords(BLBillGenInterfaceInBean inBean)
	{
		
		int epiId;
		int visId;
		String strEpiId="";
		String strVisId="";
		
		List<BLBillGenInterfaceBean> interfaceList =new ArrayList<BLBillGenInterfaceBean>();
		BLBillGenInterfaceBean interfaceBean=null;
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
		try
		{
		con = ConnectionManager.getConnection();
		
		//cstmt=	con.prepareCall("{ call bl_proc_admin_interface_recs(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
		cstmt = con.prepareCall(BlRepository.getBlKeyValue("GET_INTERFACE_DTLS"));
		cstmt.setString(1,inBean.getFacilityId());
		cstmt.setString(2,inBean.getLanguageId());
		cstmt.setString(3,inBean.getPrMain());
		
		cstmt.setDate(4,null);
		cstmt.setDate(5,null);
		
	/*	System.out.println("before date before parse in DAO IMPL" +inBean.getFromDate());
		System.out.println("to date before parse in DAO IMPL" +inBean.getToDate());
		cstmt.setTimestamp(4, new Timestamp(sdf1.parse(inBean.getFromDate()).getTime()));
		cstmt.setTimestamp(5, new Timestamp(sdf1.parse(inBean.getToDate()).getTime()));
		System.out.println("from date " + new Timestamp(sdf1.parse(inBean.getFromDate()).getTime()));
		System.out.println("to date" + new Timestamp(sdf1.parse(inBean.getToDate()).getTime()));*/
		cstmt.setString(6,inBean.getEpisodeType());
		cstmt.setString(7,inBean.getPatientId());
		cstmt.setString(8,inBean.getEpisodeId());
		cstmt.setString(9,inBean.getVisitId());
		cstmt.setString(10,inBean.getServiceLocationCode());
		cstmt.setString(11,inBean.getEncounter());
		cstmt.setString(12,inBean.getModules());
		cstmt.setString(13,inBean.getModuleId());
		cstmt.setInt(14, inBean.getStartFrom());
		cstmt.setInt(15, inBean.getEndWith());
		cstmt.setString(16, inBean.getFutureYn());
		cstmt.registerOutParameter(17, Types.INTEGER);
		cstmt.registerOutParameter(18,OracleTypes.CURSOR);
		cstmt.registerOutParameter(19,Types.VARCHAR);
		cstmt.registerOutParameter(20,Types.VARCHAR);
		cstmt.registerOutParameter(21,Types.VARCHAR);
		cstmt.execute();
		
		String error_code=cstmt.getString(19);
		String error_id=cstmt.getString(20);
		String error_text=cstmt.getString(21);
		int totalRecords =cstmt.getInt(17);
		
		
		rst = (ResultSet) cstmt.getObject(18);
		
		if(rst!=null)
		{
			while(rst.next())
			{
				interfaceBean=new BLBillGenInterfaceBean();
					
				interfaceBean.setPrimaryKeyModuleId(replaceNull(rst.getString("PRIMARY_KEY_MODULE_ID")));
				System.out.println("pkey module id :: "+interfaceBean.getPrimaryKeyModuleId());
				interfaceBean.setPrimaryKeyMain(replaceNull(rst.getString("PRIMARY_KEY_MAIN")));
				interfaceBean.setPrimaryKeyLine(replaceNull(rst.getString("PRIMARY_KEY_LINE_NO")));
				interfaceBean.setSecondaryKeyModuleId(replaceNull(rst.getString("SEC_KEY_MODULE_ID")));
				interfaceBean.setSecondaryKeyMain(replaceNull(rst.getString("SEC_KEY_MAIN")));
				interfaceBean.setSecondaryKeyLine(replaceNull(rst.getString("SEC_KEY_LINE_NO")));
				interfaceBean.setServiceItemCode(replaceNull(rst.getString("SERV_ITEM_CODE")));
				interfaceBean.setServiceItemDescription(replaceNull(rst.getString("SERV_ITEM_DESC")));	
				interfaceBean.setPhysicianId(replaceNull(rst.getString("PHYSICIAN_ID")));
				interfaceBean.setBlngServCode(replaceNull(rst.getString("BLNG_SERV_CODE")));	
				interfaceBean.setBlngServiceDesciption(replaceNull(rst.getString("BLNG_SERV_DESC")));
				interfaceBean.setInterfacedDate(rst.getTimestamp("CHARGE_DATE_TIME"));
				interfaceBean.setBillYn(replaceNull(rst.getString("BILL_YN")));
				interfaceBean.setGrossAmt(replaceNull(rst.getString("CHARGE_GROSS_AMT")));	
				interfaceBean.setDiscount(replaceNull(rst.getString("CHARGE_DISC_AMT")));
				interfaceBean.setNetAmt(replaceNull(rst.getString("CHARGE_NET_AMT")));
				interfaceBean.setClinic(replaceNull(rst.getString("CLINC_DESC")));
				interfaceBean.setColor(replaceNull(rst.getString("CURRENT_STAGE_WRT_CHARGE")));
				interfaceBean.setChargingState(replaceNull(rst.getString("CHARGING_STAGE")));
				interfaceBean.setVisitId(replaceNull(rst.getString("VISIT_ID")));			
				interfaceBean.setEpisodeId(replaceNull(rst.getString("EPISODE_ID")));
				interfaceBean.setPatientId(replaceNull(rst.getString("PATIENT_ID")));
				interfaceBean.setPatientName(replaceNull(rst.getString("patient_name")));
				interfaceBean.setTotalRecordCount(totalRecords);
				System.out.println("interfaceList11111"+interfaceBean+"=interfaceBean.setTotalRecordCount="+interfaceBean.getTotalRecordCount()+"-totalRecords="+totalRecords);
				interfaceList.add(interfaceBean);
				System.out.println("interfaceList"+interfaceList);
			}	
		
		}
		
		
		}catch(Exception e)
		{
			System.err.println("Exception in Interface Bean "+e);
			e.printStackTrace();
		}
		finally{
			cstmt = null;
			rst = null;
			ConnectionManager.returnConnection(con);
		
			
		}
		
		return interfaceList;
	}
	
		
	private String sdf(String fromDate) {
		// TODO Auto-generated method stub
		return null;
	}


	public String getDate()
	{
	String currentDate="";
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Connection con=null;
	try{
		con=ConnectionManager.getConnection();
		pstmt=con.prepareStatement("select to_char(sysdate,'DD/MM/yyyy HH24:MI:SS') sys_date from dual");
		rs=pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{
				currentDate=rs.getString("sys_date");
				System.out.println("sys date in dao"+currentDate);
			}
		}
		
		
	}catch(Exception e)
	{
		System.err.println("Exception in getDate-->"+e);
		e.printStackTrace();
	}
	finally
	{
		rs=null;
		pstmt=null;
		ConnectionManager.returnConnection(con);
	}
	
	
	
	
	return currentDate;	
	}
	
	public String getAllRecordsDate()
	{
		String allRecordsDate="";
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection con=null;
		try{
			con=ConnectionManager.getConnection();
			pstmt=con.prepareStatement("select to_char(sysdate-30,'dd/mm/yyyy HH24:MI:SS') system_date from dual");
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
				allRecordsDate=rs.getString("system_date");
					System.out.println("sys date in dao"+allRecordsDate);
				}
			}
			
			
		}catch(Exception e)
		{
			System.err.println("Exception in getAllRecordsDate-->"+e);
			e.printStackTrace();
		}
		finally
		{
			rs=null;
			pstmt=null;
			ConnectionManager.returnConnection(con);
		}
	
		
		
		return allRecordsDate;
	}
	
	public LinkedHashMap<String,String> getFacilityDetails(BLBillGenInterfaceInBean inBean)
	{
		LinkedHashMap<String,String> facDetails=new LinkedHashMap<String, String>();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection con=null;
		System.out.println("loggeduser"+inBean.getLoggedUser());
		System.out.println("locale"+inBean.getLanguageId());
		try{
			con=ConnectionManager.getConnection();
			pstmt=con.prepareStatement("SELECT DISTINCT a.acc_entity_id ID , a.acc_entity_name NAME FROM sy_acc_entity_lang_vw a, sy_user b WHERE a.acc_entity_id = b.facility_id AND b.user_id = ? AND language_id = ?");
			pstmt.setString(1, inBean.getLoggedUser());
			pstmt.setString(2, inBean.getLanguageId());
			rs=pstmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					facDetails.put(rs.getString("ID"),rs.getString("NAME"));
				}
			}
				
	
			
			
		}catch(Exception e)
		{
			System.err.println("Exception in getFacilityDetails"+e);
		}
		finally{
			
			pstmt=null;
			rs=null;
			ConnectionManager.returnConnection(con);
		}
		
		
		return facDetails;
	}


	public String round(String input,int deci){
		int maxvalue = 17;
		String output = "";
		boolean negative = false;
		if(input == null || "null".equals(input)|| input== " "){
			input = "0";
		}
		try{
			if(input.charAt(0) == '-'){
				negative = true;
				input = input.substring(1);
			}
			int temp4=input.length();
			int count=maxvalue -deci;
			if (deci > 0)
			{
				if(input.indexOf(".") <0)
				{
					if (temp4 <= maxvalue)
					{
						if(input.length() > ((maxvalue) -(deci)) && input.length() <= maxvalue)
						{
							String temp2=input.substring(0,count);
							String temp3=temp2+"."+input.substring(count,input.length());
							if(temp3.length()-1 < (maxvalue))
							{
								for(int t=0;t <=((maxvalue)+1-temp3.length());t++)
								{
									temp3+="0";
								}
							}
							output = temp3;
						}
						else if(input.length() <= ((maxvalue) -(deci)) && input.length() <= maxvalue)
						{
							String temp3=input+".";
							for(int m=0;m<deci;m++)
							temp3+="0";
							output = temp3;
						
						}
						if (input.length() == 0 )
						{
							String temp3="0.";
							for(int m=0;m<deci;m++)
							temp3+="0";
							output = temp3;
			 
						}
		   
		 
					}

				}else{
					int temp5=input.indexOf(".");
					String temp7=input.substring(0,temp5);
					String tempForMinus = temp7;
					int a = temp7.length()+1;
					int b = temp7.length()+(deci)+1;
					String temp6="";

					if(temp4>=b){
						temp6 = input.substring(a,b);
					}
					else{
						temp6 = input.substring(a,temp4);
					}
					
					/*Added new Logic for Rounding*/
					String nextDigit = "";
					if(temp4>=(b+1)){
						nextDigit = input.substring(a,(b+1));
					}
					
							

					if(nextDigit.length()>temp6.length()){
						String strLastDigit = nextDigit.substring(deci,(deci)+1);
						int lastDigit = Integer.parseInt(strLastDigit);
						
						if(lastDigit>=5){
							int temp6Int = Integer.parseInt(temp6);
							if(temp6Int>(Math.pow(10,deci) - 2)){
								long temp7Int = 0;
								if(!"".equals(temp7)){
									temp7Int = Long.parseLong(temp7);
								}
								temp7Int = (temp7Int)+(1);
								temp7 = String.valueOf(temp7Int);
								temp6="0";
								temp5 = temp7.length();
							}
							else{
								if(temp6.charAt(0) == '0'){
									int temp10 = (temp6Int)+(1);
									temp6 = "0"+temp10;
								}
								else{
									temp6Int=(temp6Int)+(1);
									temp6 = String.valueOf(temp6Int);
								}												
							}					
							
						}
					}
					/*Added new Logic for Rounding*/
					String localTemp="";
					int len=(deci)-(temp6.length());
					for(int m=0;m<len;m++){
						localTemp+="0";
					}
					
					if(temp5 == 0){
						output = "0."+temp6+localTemp;
					}
					else if(temp5 == 1 && "-".equals(tempForMinus)){
						output = temp7+"0."+temp6+localTemp;
					}
					else{
						output = temp7+"."+temp6+localTemp;
					}
			
				}
			}
			if(negative){
				output = "-"+output;
			}
		}
		catch(Exception e){
			output = input;
		}
		return output;
	}
	
	public String replaceNull(String input){
		if(input == null || "null".equals(input)|| input== " "){
			input = "";
		}
		return input;
	}
	
	public String replaceNull1(String input){
		if(input == null || "null".equals(input)|| input== " "){
			input = "0";
		}
		return input;
	}
	
	public HashMap<String,String> getOutstandingUnbilled(BillReceiptRequest billRequest){
		HashMap<String,String> map = new HashMap<String, String>();
		Connection con = null;
		CallableStatement cstmt = null;		
		try{
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("GET_UNBILLED_OUTST_AMT"));
			cstmt.setString(1, billRequest.getPatientId());
			cstmt.setString(2, billRequest.getEpisodeType());
			cstmt.setString(3, billRequest.getEpisodeId());
			cstmt.setString(4, billRequest.getVisitId());
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.execute();
			map.put("outst",  replaceNull(cstmt.getString(5)));
			map.put("unbilled",  replaceNull(cstmt.getString(6)));
		}
		catch(Exception e){
			System.err.println("Exception in getOutstandingUnbilled"+e);
			e.printStackTrace();
		}
		finally{
			ConnectionManager.returnConnection(con);
			cstmt = null;
			
		}
		return map;
	}
	
	public String getCredentails(String userId){
		String password = "";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection();
			String queryPwd="select upper(app_password.decrypt(APPL_USER_PASSWORD)) as password from sm_appl_user where appl_user_id= ? ";
			pstmt = con.prepareStatement(queryPwd);
			pstmt.setString(1, userId);
			
			rst = pstmt.executeQuery();
			
			if (rst!=null && rst.next())
			{			  				 
				password = rst.getString("password");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			ConnectionManager.returnConnection(con);
			pstmt = null;
			
		}
		return password;
	}
	
	
}
